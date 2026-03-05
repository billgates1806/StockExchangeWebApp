package models;

import java.util.*;

public class StockExchange {

    private final Map<String, Double> prices;
    private final Map<Integer, Account> accounts;

    public StockExchange() {
        prices = new HashMap<>();
        accounts = new HashMap<>();

        // Demo market prices
        prices.put("AAPL", 190.50);
        prices.put("GOOG", 2800.25);
        prices.put("TSLA", 210.40);
        prices.put("MSFT", 350.10);

        // Demo accounts
        accounts.put(0, new Account(0, "Rohan", 50000));
        accounts.put(1, new Account(1, "Neal", 75000));
        accounts.put(2, new Account(2, "Swastik", 100000));
    }

    public Account getAccount(int id) {
        return accounts.get(id);
    }

    public double getPrice(String symbol) throws Exception {
        Double p = prices.get(symbol.toUpperCase());
        if (p == null) throw new Exception("Unknown symbol: " + symbol);
        return p;
    }

    public String buy(int id, String symbol, int qty) {
        try {
            Account acc = getAccount(id);
            double price = getPrice(symbol);
            acc.buy(symbol, qty, price);
            return "Buy Successful\n\n" + acc.portfolio();
        } catch (Exception e) {
            return "Buy Failed: " + e.getMessage();
        }
    }

    public String sell(int id, String symbol, int qty) {
        try {
            Account acc = getAccount(id);
            double price = getPrice(symbol);
            acc.sell(symbol, qty, price);
            return "Sell Successful\n\n" + acc.portfolio();
        } catch (Exception e) {
            return "Sell Failed: " + e.getMessage();
        }
    }

    public String portfolio(int id) {
        Account acc = getAccount(id);
        if (acc == null) return "Account not found";
        return acc.portfolio();
    }
}
