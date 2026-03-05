package models;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Trade {

    private final String stockSymbol;
    private final int quantity;
    private final double price;
    private final String type; 
    private final LocalDateTime timestamp;

    public Trade(String stockSymbol, int quantity, double price, String type) {
        this.stockSymbol = stockSymbol;
        this.quantity = quantity;
        this.price = price;
        this.type = type;
        this.timestamp = LocalDateTime.now();
    }

    @Override
    public String toString() {
        DateTimeFormatter fmt = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        return type + " | " + stockSymbol + " | Qty: " + quantity +
               " | Price: " + price + " | Time: " + fmt.format(timestamp);
    }
}
