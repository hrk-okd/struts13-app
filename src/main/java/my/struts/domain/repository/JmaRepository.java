package my.struts.domain.repository;

import my.struts.domain.model.JmaFeed;
import org.springframework.lang.Nullable;

/**
 * 気象庁情報を取得するレポジトリです。
 */
public interface JmaRepository {

    /**
     * 気象庁の地震・火山フィードを取得します。
     * @return 地震フィード
     */
    @Nullable
    JmaFeed getFeed();
}