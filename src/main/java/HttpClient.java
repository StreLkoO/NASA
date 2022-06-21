import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;

import java.io.IOException;

public class HttpClient {
    private final CloseableHttpClient httpClient;
    private static HttpClient instance;

    private HttpClient() {
        httpClient = HttpClientBuilder.create()
                .setDefaultRequestConfig(RequestConfig.custom()
                        .setConnectTimeout(5000)
                        .setSocketTimeout(30000)
                        .setRedirectsEnabled(false)
                        .build())
                .build();
    }

    public static HttpClient get() {
        if (instance == null) {
            instance = new HttpClient();
        }
        return instance;
    }

    public byte[] getContentFromURL(String url) {

        HttpGet request = new HttpGet(url);
        try (CloseableHttpResponse response = httpClient.execute(request)) {
            return response.getEntity().getContent().readAllBytes();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
}
