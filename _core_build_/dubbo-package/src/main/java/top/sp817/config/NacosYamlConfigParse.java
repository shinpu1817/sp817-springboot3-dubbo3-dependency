package top.sp817.config;

import com.alibaba.nacos.api.config.ConfigType;
import com.alibaba.nacos.spring.util.parse.DefaultYamlConfigParse;
import org.yaml.snakeyaml.DumperOptions;
import org.yaml.snakeyaml.LoaderOptions;
import org.yaml.snakeyaml.Yaml;
import org.yaml.snakeyaml.constructor.Constructor;
import org.yaml.snakeyaml.constructor.SafeConstructor;
import org.yaml.snakeyaml.nodes.Tag;
import org.yaml.snakeyaml.representer.Representer;
import org.yaml.snakeyaml.resolver.Resolver;

import java.util.Map;
import java.util.concurrent.atomic.AtomicReference;
import java.util.regex.Pattern;

public class NacosYamlConfigParse extends DefaultYamlConfigParse {
    private static final String YAML_ALLOW_COMPLEX_OBJECT = "yamlAllowComplexObject";

    protected static Yaml createYaml() {
        SafeConstructor constructor;
        LoaderOptions loaderOptions = new LoaderOptions();
        if (getYamlAllowComplexObject()) {
            constructor = new Constructor(loaderOptions);
        } else {
            constructor = new SafeConstructor(loaderOptions);
        }
        DumperOptions dumperOptions = new DumperOptions();
        Representer representer = new Representer(dumperOptions);
        LimitedResolver resolver = new LimitedResolver();
        loaderOptions.setAllowDuplicateKeys(false);
        return new Yaml(constructor, representer, dumperOptions, loaderOptions, resolver);
    }

    private static boolean getYamlAllowComplexObject() {
        return Boolean.getBoolean(YAML_ALLOW_COMPLEX_OBJECT);
    }

    @Override
    public Map<String, Object> parse(String configText) {
        final AtomicReference<Map<String, Object>> result = new AtomicReference<>();
        process(result::set, createYaml(), configText);
        return result.get();
    }

    @Override
    public String processType() {
        return ConfigType.YAML.getType();
    }

    private static class LimitedResolver extends Resolver {

        @Override
        public void addImplicitResolver(Tag tag, Pattern regexp, String first) {
            if (tag == Tag.TIMESTAMP) {
                return;
            }
            super.addImplicitResolver(tag, regexp, first);
        }
    }
}
