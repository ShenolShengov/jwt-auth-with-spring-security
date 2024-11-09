package bg.about_java.jwt_auth_with_spring_security.config;

import bg.about_java.jwt_auth_with_spring_security.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ResourceLoader;
import org.springframework.jdbc.datasource.init.DataSourceInitializer;
import org.springframework.jdbc.datasource.init.ResourceDatabasePopulator;

import javax.sql.DataSource;

@Configuration
@RequiredArgsConstructor
public class DataSourceInitializerConfiguration {

    private final UserRepository userRepository;

    @Bean
    public DataSourceInitializer initializer(DataSource dataSource, ResourceLoader loader) {
        DataSourceInitializer initializer = new DataSourceInitializer();
        initializer.setDataSource(dataSource);
        if (userRepository.count() == 0) {
            ResourceDatabasePopulator populator = new ResourceDatabasePopulator();
            populator.addScript(loader.getResource("classpath:data-mysql.sql"));
            initializer.setDatabasePopulator(populator);
        }
        return initializer;
    }
}
