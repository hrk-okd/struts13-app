package my.struts.domain.model;

import lombok.AccessLevel;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.lang.NonNull;
import org.springframework.lang.Nullable;
import org.springframework.util.CollectionUtils;

import java.util.List;
import java.util.stream.Collectors;

/**
 * 気象庁のfeed情報モデルです。
 */
@NoArgsConstructor
@Data
public class JmaFeed {

    /**
     * タイトルです。
     */
    private String title;

    /**
     * サブタイトルです。
     */
    private String subTitle;

    /**
     * エントリリストです。
     */
    private List<Entry> entryList;

    /**
     * エントリです。
     */
    @NoArgsConstructor
    @Data
    public static class Entry {

        /**
         * タイトルです。
         */
        @Setter(AccessLevel.NONE)
        private String title;

        /**
         * IDです。
         */
        private String id;

        /**
         * フィードの種別です。
         */
        @NonNull
        private JmaFeedType feedType = JmaFeedType.UNDEFINED;

        /**
         * タイトルを設定します。
         *
         * @param val 値
         */
        public void setTitle(@Nullable final String val) {
            title = val;
            feedType = JmaFeedType.of(title);
        }

    }

    @Nullable
    public JmaFeed filterByEarthquake() {
        if (CollectionUtils.isEmpty(entryList)) {
            return null;
        }

        List<Entry> filteredList = entryList.stream()
                .filter(entry -> entry.getFeedType().isEarthQuake())
                .collect(Collectors.toList());

        JmaFeed feed = new JmaFeed();
        feed.setTitle(title);
        feed.setSubTitle(subTitle);
        feed.setEntryList(filteredList);
        return feed;
    }
}