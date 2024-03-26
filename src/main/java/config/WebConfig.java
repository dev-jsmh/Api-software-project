/**
 *
 * Developed by Jhonatan Samuel Martinez Hernandez year 2024
 *
 */
package config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 *
 * @author Jhonatan Samuel Martinez Hernandez year 2024
 *
 *
 * Here I use this file to configure CORS policy of my api. I have set the
 * enpoint that will be affected for this configuration, the origin from where
 * the api can be use, the Http methods the origin will be able to performe and
 * finally the headers.
 */
@Configuration
public class WebConfig implements WebMvcConfigurer {

    

};
