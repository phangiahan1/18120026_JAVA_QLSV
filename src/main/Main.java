package main;

import dao.AccountDAO;
import hibernate.Accounts;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Accounts> rs = AccountDAO.getAllAccounts();
        for (Accounts item : rs) {
            System.out.println(item.toString());
        }
    }
}
