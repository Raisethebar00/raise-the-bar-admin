package raise.the.bar.admin.config;

import org.springframework.boot.autoconfigure.AutoConfigureAfter;
import org.springframework.boot.autoconfigure.web.DispatcherServletAutoConfiguration;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

/**
 * Created by Sujeet on 3/5/17.
 */

@Configuration
@AutoConfigureAfter(DispatcherServletAutoConfiguration.class)
public class CustomConfig extends WebMvcConfigurerAdapter {


    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {

        String myExternalFilePath = "file:///app/media/";
        registry.addResourceHandler("/media/**").addResourceLocations(myExternalFilePath);

        super.addResourceHandlers(registry);
    }

}