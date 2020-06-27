package my.struts.domain.model;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.lang.NonNull;
import org.springframework.lang.Nullable;

import java.util.Arrays;

/**
 * feedの種別です。
 */
@RequiredArgsConstructor
@Getter
public enum JmaFeedType {

    /**
     * 震源
     */
    SEISMIC_CENTER("震源に関する情報"),

    /**
     * 震源・震度
     */
    SEISMIC_CENTER_INTENSITY("震源・震度に関する情報"),

    /**
     * 未定義
     */
    UNDEFINED("");

    /**
     * タイトルです。
     */
    private final String title;

    /**
     * 地震の情報かどうかを判断します。
     * @return 地震の場合はtrue
     */
    public boolean isEarthQuake() {
        return this == SEISMIC_CENTER
                || this == SEISMIC_CENTER_INTENSITY;
    }

    /**
     * タイトルからオブジェクトを生成します。
     * このenumで定義されていないタイトルの場合は、UNDEFINEDを返します。
     *
     * @param title タイトル
     * @return タイトルに対応したオブジェクト
     */
    @NonNull
    public static JmaFeedType of(@Nullable final String title) {
        return Arrays.stream(values())
                .filter(jmaFeedType -> jmaFeedType.getTitle().equals(title))
                .findFirst()
                .orElse(JmaFeedType.UNDEFINED);
    }
}