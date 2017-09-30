package khettaf;

import khettaf.entities.*;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.boot.web.support.SpringBootServletInitializer;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpStatus;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Arrays;
import java.util.Date;

/**
 * Created by Me on 22/09/2017.
 */

@SpringBootApplication
public class Application extends SpringBootServletInitializer {

    public static void main (String[] args){
        SpringApplication.run(Application.class, args);
    }

    //Cors => 9000
    @Bean
    FilterRegistrationBean corsFilter(
            @Value("${tagit.origin:http://localhost:9000}") String origin) {
        return new FilterRegistrationBean(new Filter() {
            public void doFilter(ServletRequest req, ServletResponse res,
                                 FilterChain chain) throws IOException, ServletException {
                HttpServletRequest request = (HttpServletRequest) req;
                HttpServletResponse response = (HttpServletResponse) res;
                String method = request.getMethod();
                // this origin value could just as easily have come from a database
                response.setHeader("Access-Control-Allow-Origin", origin);
                response.setHeader("Access-Control-Allow-Methods",
                        "POST,GET,OPTIONS,DELETE");
                response.setHeader("Access-Control-Max-Age", Long.toString(60 * 60));
                response.setHeader("Access-Control-Allow-Credentials", "true");
                response.setHeader(
                        "Access-Control-Allow-Headers",
                        "Origin,Accept,X-Requested-With,Content-Type,Access-Control-Request-Method,Access-Control-Request-Headers,Authorization");
                if ("OPTIONS".equals(method)) {
                    response.setStatus(HttpStatus.OK.value());
                }
                else {
                    chain.doFilter(req, res);
                }
            }

            public void init(FilterConfig filterConfig) {
            }

            public void destroy() {
            }
        });
    }

    @Bean
    CommandLineRunner init(final KhettafRepo khettafRepo, final POIRepo poiRepo, final TrajetRepo trajetRepo){

        POI poi1 = poiRepo.save(new POI(0.0, 0.0, "Casablanca"));
        POI poi2 = poiRepo.save(new POI(0.0, 0.0, "Rabat"));
        POI poi3 = poiRepo.save(new POI(0.0, 0.0, "Marrakech"));
        POI poi4 = poiRepo.save(new POI(0.0, 0.0, "Fès"));
        Date dateDepart = new Date();
        String description = "Lorem ipsum dolor sit amet, consectetur adipiscing elit. " +
                "Morbi eleifend imperdiet enim vel pharetra. Donec molestie finibus felis " +
                "vitae efficitur. Nunc et erat vitae sapien molestie bibendum.";

        return (event) -> Arrays.asList("Houssam,Boualam,Meryam".split(","))
                .forEach(
                        khettaf -> {
                            Khettaf khettaf1 = khettafRepo.save(new Khettaf(khettaf, "password"));

                            Trajet trajet1 = trajetRepo.save(new Trajet(khettaf1, poi1, poi2, description, dateDepart));
                            Trajet trajet2 = trajetRepo.save(new Trajet(khettaf1, poi3, poi4, description, dateDepart));
                        }
                );
    }
}
