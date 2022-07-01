package processor.domain;

import java.util.Collection;
import java.util.Map;


/**
 * @author zijian.zeng@hand-china.com
 * @since 2022/6/30
 */
public class Entity {
    private Map<String,String> headers;
    private Collection<Map<String, String>> dataset;

    public Map<String, String> getHeaders() {
        return headers;
    }

    public void setHeaders(Map<String, String> headers) {
        this.headers = headers;
    }

    public Collection<Map<String, String>> getDataset() {
        return dataset;
    }

    public void setDataset(Collection<Map<String, String>> dataset) {
        this.dataset = dataset;
    }
}
