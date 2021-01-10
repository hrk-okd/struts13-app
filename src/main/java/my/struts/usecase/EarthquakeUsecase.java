package my.struts.usecase;

import my.struts.domain.model.JmaFeed;
import org.springframework.lang.Nullable;

/**
 * ログイン処理を行います。
 */
public interface EarthquakeUsecase {
    
    /**
     * ログイン処理を行います。
     */
    @Nullable
    JmaFeed getFeed();
}