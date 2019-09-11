package atm_database;


import atm_database.ATM;
import atm_database.ATMSimulator;
import atm_database.Account;
import atm_database.Bank;
import atm_database.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.io.IOException;
import java.util.Map;

@Configuration
public class ATMconfigJava {
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
        return new Bank(readDatabase());
    }
    @Bean
    public ReadDataSource readFromFile() {
        return new ReadFromFile("customers.txt");
    }
    @Bean
    public ReadDataSource readDatabase() {
        return new ReadDatabase();
    }

    @Bean
    public ATMSimulator atmSimulator() {
        return new ATMSimulator(atm());
    }




}
