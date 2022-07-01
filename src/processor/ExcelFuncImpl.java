package processor;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.Collection;
import java.util.Map;

import org.apache.http.HttpEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import processor.domain.Entity;
import util.SendPostRequest;

/**
 * @author zijian.zeng@hand-china.com
 * @since 2022/6/29
 */
public class ExcelFuncImpl implements ExcelFunc{


    @Override
    public void process(Map<String, String> header,  Collection<Map<String,String>> content) {
        // 远程调用接口来实现
        Entity entity = new Entity();
        entity.setHeaders(header);
        entity.setDataset(content);
        SendPostRequest.post("localhost:8888/excel/export", entity.toString());


    }


}
