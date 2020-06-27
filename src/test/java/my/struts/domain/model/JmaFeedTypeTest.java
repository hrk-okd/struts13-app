package my.struts.domain.model;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.assertj.core.api.Assertions.assertThat;

@ExtendWith(MockitoExtension.class)
class JmaFeedTypeTest {

    @Test
    void isEarthQuake_SEISMIC_CENTERのときにtrue() {
        // mock
        JmaFeedType target = JmaFeedType.SEISMIC_CENTER;

        // execute
        boolean actual = target.isEarthQuake();

        // verify
        assertThat(actual).isTrue();
    }

    @Test
    void isEarthQuake_SEISMIC_CENTER_INTENSITYのときにtrue() {
        // mock
        JmaFeedType target = JmaFeedType.SEISMIC_CENTER_INTENSITY;

        // execute
        boolean actual = target.isEarthQuake();

        // verify
        assertThat(actual).isTrue();
    }

    @Test
    void of_titleからオブジェクト取得_SEISMIC_CENTER() {
        // mock

        // execute
        JmaFeedType actual = JmaFeedType.of(JmaFeedType.SEISMIC_CENTER.getTitle());

        // verify
        assertThat(actual).isEqualByComparingTo(JmaFeedType.SEISMIC_CENTER);
    }

    @Test
    void of_titleからオブジェクト取得_SEISMIC_CENTER_INTENSITY() {
        // mock

        // execute
        JmaFeedType actual = JmaFeedType.of(JmaFeedType.SEISMIC_CENTER_INTENSITY.getTitle());

        // verify
        assertThat(actual).isEqualByComparingTo(JmaFeedType.SEISMIC_CENTER_INTENSITY);
    }

    @Test
    void of_titleからオブジェクト取得_UNDEFINED() {
        // mock

        // execute
        JmaFeedType actual = JmaFeedType.of(JmaFeedType.UNDEFINED.getTitle());

        // verify
        assertThat(actual).isEqualByComparingTo(JmaFeedType.UNDEFINED);
    }

    @Test
    void of_titleからオブジェクト取得_規定外の文字列() {
        // mock

        // execute
        JmaFeedType actual = JmaFeedType.of("123");

        // verify
        assertThat(actual).isEqualByComparingTo(JmaFeedType.UNDEFINED);
    }

}
