package util;

import org.apache.http.HttpEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

/**
 * @author zijian.zeng@hand-china.com
 * @since 2022/6/30
 */
public class SendPostRequest {

    public static String post(String url, String entity) {
        try {
            String username="user";// 账户
            String password="1234";// 密码
            CloseableHttpClient httpClient = HttpClients.createDefault();
            HttpPost httpPost = new HttpPost(url);
            httpPost.addHeader("Authorization", "Basic " + java.util.Base64.getUrlEncoder().encodeToString((username + ":" + password).getBytes()));
            StringEntity se = new StringEntity(entity, "UTF-8");
            se.setContentType("application/json");
            httpPost.setEntity(se);
            CloseableHttpResponse response = httpClient.execute(httpPost);
            HttpEntity entity1 = response.getEntity();
            String resStr = null;
            if (entity1 != null) {
                resStr = EntityUtils.toString(entity1, "UTF-8");
            }
            httpClient.close();
            response.close();
            return resStr;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "";
    }

}
