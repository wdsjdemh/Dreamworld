import java.io.IOException;
import com.sun.net.httpserver.HttpHandler;
import com.sun.net.httpserver.HttpServer;
import com.sun.net.httpserver.HttpExchange;

public class MyWorldServer {

    public static void main(String[] args) throws IOException {
        int port = 8080;
        HttpServer server = HttpServer.create();
        server.bind(new InetSocketAddress(port), 0);

        HttpHandler handler = new HttpHandler() {
            public void handle(HttpExchange exchange) throws IOException {
                String response = "<html><head><title>我的世界服务器</title></head><body><h1>我的世界服务器</h1></body></html>";
                exchange.sendResponseHeaders(200, response.length());
                exchange.getResponseBody().write(response.getBytes());
                exchange.getResponseBody().close();
            }
        };

        server.createContext("/", handler);
        server.start();
        System.out.println("服务器已启动，访问 http://localhost:" + port + " 查看页面");
    }
}
