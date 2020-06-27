package my.struts.config;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.annotation.MapperScan;
import org.simpleframework.xml.Serializer;
import org.simpleframework.xml.core.Persister;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.converter.StringHttpMessageConverter;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.lang.NonNull;
import org.springframework.web.client.RestTemplate;

import javax.sql.DataSource;
import java.net.URI;
import java.net.URISyntaxException;
import java.nio.charset.StandardCharsets;
import java.util.Collections;
import java.util.Objects;

/**
 * configurationです。
 */
@Configuration
@ComponentScan("my.struts")
@MapperScan("my.struts.infrastructure.mapper")
public class AppConfig {

    @NonNull
    @Bean
    public DataSource dataSource() {
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setDriverClassName("org.postgresql.Driver");
        dataSource.setUrl(
                // TODO: 自分用の設定に変更
                "jdbc:postgresql://[host]:[port]/[database]");
        dataSource.setUsername("[user]");
        dataSource.setPassword("[password]");
        return dataSource;
    }

    @NonNull
    @Bean
    public SqlSessionFactory sqlSessionFactory() throws Exception {
        SqlSessionFactoryBean factoryBean = new SqlSessionFactoryBean();
        factoryBean.setDataSource(dataSource());
        SqlSessionFactory sqlSessionFactory = factoryBean.getObject();
        Objects.requireNonNull(sqlSessionFactory);
        return sqlSessionFactory;
    }

    @NonNull
    @Bean
    public RestTemplate restTemplate() {
        RestTemplate restTemplate = new RestTemplate();
        restTemplate.setMessageConverters(
                Collections.singletonList(new StringHttpMessageConverter(StandardCharsets.UTF_8))
        );
        return restTemplate;
    }

    @NonNull
    @Bean
    public URI feedUri() throws URISyntaxException {
        return new URI("http://www.data.jma.go.jp/developer/xml/feed/eqvol.xml");
    }

    @NonNull
    @Bean
    public Serializer serializer() {
        return new Persister();
    }

}
