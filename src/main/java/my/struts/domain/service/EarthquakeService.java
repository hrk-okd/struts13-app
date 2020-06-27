package my.struts.domain.service;

import my.struts.domain.model.JmaFeed;
import my.struts.domain.model.UserInfo;
import org.springframework.lang.NonNull;
import org.springframework.lang.Nullable;

/**
 * ログイン処理を行います。
 */
public interface EarthquakeService {
    
    /**
     * ログイン処理を行います。
     */
    @Nullable
    JmaFeed getFeed();
}