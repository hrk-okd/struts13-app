package my.struts.infrastructure.repository.impl;

import lombok.RequiredArgsConstructor;
import my.struts.domain.dto.JmaXmlFeed;
import my.struts.domain.model.JmaFeed;
import my.struts.domain.repository.JmaRepository;
import my.struts.domain.util.XmlParser;
import org.modelmapper.ModelMapper;
import org.springframework.http.ResponseEntity;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Repository;
import org.springframework.web.client.RestTemplate;

import java.net.URI;

import static java.util.Objects.isNull;

/**
 * 気象庁の情報を取得するレポジトリ実装です。
 */
@Repository
@RequiredArgsConstructor
public class JmaRepositoryImpl implements JmaRepository {

    /**
     * {@link RestTemplate}です。
     */
    private final RestTemplate restTemplate;

    /**
     * {@link URI}です。
     */
    private final URI uri;

    /**
     * XMLパーサです。
     */
    private final XmlParser xmlParser;

    /**
     * モデルマッパーです。
     */
    private final ModelMapper modelMapper;

    /**
     * {@inheritDoc}
     */
    @Nullable
    @Override
    public JmaFeed getFeed() {
        ResponseEntity<String> response = restTemplate.getForEntity(uri, String.class);
        if (!response.hasBody()) {
            return null;
        }

        String responseBody = response.getBody();
        if (isNull(responseBody)) {
            return null;
        }

        JmaXmlFeed xml = xmlParser.read(responseBody, JmaXmlFeed.class);
        if (isNull(xml)) {
            return null;
        }

        return modelMapper.map(xml, JmaFeed.class);
    }

}