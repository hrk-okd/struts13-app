package my.struts.infrastructure.repository.impl;

import my.struts.config.AppConfig;
import my.struts.config.ModelMapperConfig;
import my.struts.domain.model.JmaFeed;
import my.struts.domain.util.XmlParser;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.modelmapper.ModelMapper;
import org.springframework.http.ResponseEntity;
import org.springframework.lang.NonNull;
import org.springframework.util.ResourceUtils;
import org.springframework.web.client.RestTemplate;

import java.io.File;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class EarthquakeRepositoryImplTest {

    private JmaRepositoryImpl target;

    private final AppConfig appConfig = new AppConfig();

    private final ModelMapperConfig modelMapperConfig = new ModelMapperConfig();

    private final XmlParser xmlParser = new XmlParser(appConfig.serializer());

    private final ModelMapper modelMapper = modelMapperConfig.modelMapper();

    private URI uri;

    @Mock
    private RestTemplate restTemplate;

    @Mock
    private ResponseEntity<String> responseEntity;

    @BeforeEach
    void setup() {
        try {
            uri = appConfig.feedUri();
        } catch (URISyntaxException e) {
            e.printStackTrace();
        }

        target = new JmaRepositoryImpl(restTemplate, uri, xmlParser, modelMapper);
    }

    @Test
    void getFeed_getForEntityがnullの場合はnullを返す() {
        // mock
        when(restTemplate.getForEntity(uri, String.class)).thenReturn(null);

        // execute
        JmaFeed actual = target.getFeed();

        // verify
        assertThat(actual).isNull();
    }

    @Test
    void getFeed_hasBodyがfalseの場合はnullを返す() {
        // mock
        when(restTemplate.getForEntity(uri, String.class)).thenReturn(responseEntity);
        when(responseEntity.hasBody()).thenReturn(false);

        // execute
        JmaFeed actual = target.getFeed();

        // verify
        assertThat(actual).isNull();
    }

    @Test
    void getFeed_情報を取得する() throws IOException {
        // mock
        String body = readXml();

        when(restTemplate.getForEntity(uri, String.class)).thenReturn(responseEntity);
        when(responseEntity.hasBody()).thenReturn(true);
        when(responseEntity.getBody()).thenReturn(body);

        // execute
        JmaFeed actual = target.getFeed();

        // verify
        assertThat(actual).isNotNull();
        assertThat(actual.getTitle()).isEqualTo("高頻度（地震火山）");
        assertThat(actual.getSubTitle()).isEqualTo("JMAXML publishing feed");
        assertThat(actual.getEntryList()).isNotNull();
        assertThat(actual.getEntryList()).hasSize(20);
    }

    @NonNull
    private String readXml() throws IOException {
        File file = ResourceUtils.getFile("classpath:jma/eqvol.xml");
        List<String> allLines = Files.readAllLines(Paths.get(file.getAbsolutePath()));
        return String.join("", allLines);
    }

}
