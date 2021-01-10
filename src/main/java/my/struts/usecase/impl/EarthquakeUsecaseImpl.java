package my.struts.usecase.impl;

import lombok.RequiredArgsConstructor;
import my.struts.domain.model.JmaFeed;
import my.struts.domain.repository.JmaRepository;
import my.struts.usecase.EarthquakeUsecase;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Service;

import static java.util.Objects.isNull;

/**
 * 地震情報を取得するサービスです。。
 */
@Service
@RequiredArgsConstructor
public class EarthquakeUsecaseImpl implements EarthquakeUsecase {

    /**
     * 気象庁情報取得用レポジトリです。
     */
    private final JmaRepository jmaRepository;

    /**
     * {@inheritDoc}
     */
    @Nullable
    @Override
    public JmaFeed getFeed() {
        JmaFeed feed = jmaRepository.getFeed();
        if (isNull(feed)) {
            return null;
        }

        return feed.filterByEarthquake();
    }
}