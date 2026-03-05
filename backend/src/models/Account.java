package models;

import java.util.*;

public class Account {

    private final int id;
    private final String name;
    private double cashBalance;
    private final Map<String, Integer> holdings;
    private final List<Trade> tradeHistory;

    public Account(int id, String name, double cashBalance) {
        this.id = id;
        this.name = name;
        this.cashBalance = cashBalance;
        this.holdings = new HashMap<>();
        this.tradeHistory = new ArrayList<>();
    }

    public String portfolio() {
        StringBuilder sb = new StringBuilder();

        sb.append("Account: ").append(name).append(" (ID ").append(id).append(")").append("\n");
        sb.append("Cash Balance: ").append(cashBalance).append("\n\n");

        sb.append("Holdings:\n");
        if (holdings.isEmpty()) sb.append("  None\n");
        else {
            for (var e : holdings.entrySet()) {
                sb.append("  ").append(e.getKey()).append(": ").append(e.getValue()).append("\n");
            }
        }

        sb.append("\nTrade History:\n");
        if (tradeHistory.isEmpty()) sb.append("  No trades yet.\n");
        else {
            for (Trade t : tradeHistory) sb.append("  ").append(t).append("\n");
        }

        return sb.toString();
    }

    public void buy(String symbol, int qty, double price) throws Exception {
        double cost = qty * price;
        if (cashBalance < cost) throw new Exception("Insufficient balance");

        cashBalance -= cost;
        holdings.put(symbol, holdings.getOrDefault(symbol, 0) + qty);
        tradeHistory.add(new Trade(symbol, qty, price, "BUY"));
    }

    public void sell(String symbol, int qty, double price) throws Exception {
        int current = holdings.getOrDefault(symbol, 0);
        if (current < qty) throw new Exception("Not enough quantity to sell");

        holdings.put(symbol, current - qty);
        cashBalance += qty * price;
        tradeHistory.add(new Trade(symbol, qty, price, "SELL"));
    }
}
