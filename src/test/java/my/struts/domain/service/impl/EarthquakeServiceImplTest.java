package my.struts.domain.service.impl;

import my.struts.domain.repository.JmaRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.assertj.core.api.Assertions.assertThat;

@ExtendWith(MockitoExtension.class)
class EarthquakeServiceImplTest {

    private EarthquakeServiceImpl target;

    @Mock
    private JmaRepository jmaRepository;

    @BeforeEach
    void setup() {
        target = new EarthquakeServiceImpl(jmaRepository);
    }

    @Test
    void getFeed() {
        // mock

        // execute
        Object actual = target.getFeed();

        // verify
        assertThat(actual).isNull();
    }

}
