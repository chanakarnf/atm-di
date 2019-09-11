package config;




import atm_java.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ATMconfig {
    String name;
    @Bean
    public Account account() {
        return new Account();
    }
    @Bean
    public ATM atm() {
        return new ATM(bank());
    }
    @Bean
    public Bank bank() {
        return new Bank(dataSource());
    }
    @Bean
    public DataSource dataSource() {

        return new DataSource("customers.txt");
    }
    @Bean
    public ATMSimulator atmSimulator() {
        return new ATMSimulator(atm());
    }




}
