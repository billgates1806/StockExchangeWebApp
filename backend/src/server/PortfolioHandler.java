package server;

import com.sun.net.httpserver.*;
import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.Map;

public class PortfolioHandler implements HttpHandler {

    @Override
    public void handle(HttpExchange ex) throws IOException {

        Map<String, String> q = Util.parseQuery(ex.getRequestURI().getQuery());
        int id = Integer.parseInt(q.get("acc"));

        String result = WebServer.exchange.portfolio(id);

        byte[] resp = result.getBytes(StandardCharsets.UTF_8);
        ex.getResponseHeaders().add("Access-Control-Allow-Origin", "*");
        ex.sendResponseHeaders(200, resp.length);
        ex.getResponseBody().write(resp);
        ex.getResponseBody().close();
    }
}
