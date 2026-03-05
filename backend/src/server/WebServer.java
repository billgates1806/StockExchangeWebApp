package server;

import com.sun.net.httpserver.*;
import models.StockExchange;

import java.io.IOException;
import java.net.InetSocketAddress;

public class WebServer {

    public static StockExchange exchange = new StockExchange();

    public static void main(String[] args) throws IOException {

        HttpServer server = HttpServer.create(new InetSocketAddress(8080), 0);

        server.createContext("/buy", new BuyHandler());
        server.createContext("/sell", new SellHandler());
        server.createContext("/portfolio", new PortfolioHandler());

        server.setExecutor(null);
        server.start();

        System.out.println("Server running at http://localhost:8080/");
    }
}
