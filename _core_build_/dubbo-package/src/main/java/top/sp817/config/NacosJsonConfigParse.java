package top.sp817.config;

import com.alibaba.nacos.api.config.ConfigType;
import com.alibaba.nacos.spring.util.parse.DefaultYamlConfigParse;

import java.util.Map;
import java.util.concurrent.atomic.AtomicReference;

public class NacosJsonConfigParse extends DefaultYamlConfigParse {
    @Override
    public Map<String, Object> parse(String configText) {
        final AtomicReference<Map<String, Object>> result = new AtomicReference<>();
        process(result::set, NacosYamlConfigParse.createYaml(), configText);
        return result.get();
    }

    @Override
    public String processType() {
        return ConfigType.JSON.getType();
    }
}
