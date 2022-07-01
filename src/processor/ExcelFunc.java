package processor;

import java.util.Collection;
import java.util.Map;

/**
 * @author zijian.zeng@hand-china.com
 * @since 2022/6/29
 */
public interface ExcelFunc {

    void process(Map<String, String> header,  Collection<Map<String,String>> content);

}
