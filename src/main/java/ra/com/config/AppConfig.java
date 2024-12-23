package ra.com.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

@Configuration
@ComponentScan(basePackages = {"ra.com.controller", "ra.com.service", "ra.com.repository"})
@EnableWebMvc
public class AppConfig {
    //Cấu hình đường dẫn tới thư mục chứa các views của ứng dụng, file view mở rộng
    @Bean
    public ViewResolver viewResolver() {
        InternalResourceViewResolver viewResolver = new InternalResourceViewResolver();
        //set đường dẫn cho view
        viewResolver.setPrefix("/views/");
        //set phần mở rộng file views
        viewResolver.setSuffix(".jsp");
        return viewResolver;
    }
}
