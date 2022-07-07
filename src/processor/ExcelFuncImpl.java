package processor;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.nio.charset.StandardCharsets;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import org.apache.http.HttpEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;
import processor.domain.Entity;
import util.SendPostRequest;

/**
 * @author zijian.zeng@hand-china.com
 * @since 2022/6/29
 */
public class ExcelFuncImpl implements ExcelFunc {


    @Override
    public void process(Map<String, String> header, Collection<Map<String, String>> content) {
        // 远程调用接口来实现
        Entity entity = new Entity();
        entity.setHeaders(header);
        entity.setDataset(content);
        Map<String, Object> map = new HashMap<>();
        map.put("headers", header);
        map.put("content", content);
        String url = "localhost:8888/excel/export";
        UriComponentsBuilder builder = UriComponentsBuilder.fromHttpUrl(url);
        URI uri = builder.build().encode(StandardCharsets.UTF_8).toUri();
        ResponseEntity<String> responseEntity = null;
        RestTemplate restTemplate = new RestTemplate();
        RequestEntity<Map<String, Object>> requestEntity = RequestEntity
                .post(uri)
                .header("Accept", MediaType.APPLICATION_JSON.toString())
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON)
                .body(map); //也可以是DTO

        try {
            responseEntity = restTemplate.exchange(requestEntity, String.class);
        } catch (Exception e) {
            System.out.println(responseEntity);
        }
    }


}
