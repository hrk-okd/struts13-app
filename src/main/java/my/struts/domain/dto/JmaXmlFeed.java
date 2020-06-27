package my.struts.domain.dto;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.simpleframework.xml.Element;
import org.simpleframework.xml.ElementList;
import org.simpleframework.xml.Root;

import java.util.List;

/**
 * 地震情報のフィードです。
 */
@Root(name = "feed")
@NoArgsConstructor
@Data
public class JmaXmlFeed {

    /**
     * タイトルです。
     */
    @Element(name = "title")
    private String title;

    /**
     * サブタイトルです。
     */
    @Element(name = "subtitle")
    private String subTitle;

    /**
     * エントリリストです
     */
    @ElementList(name = "entry", inline = true, required = false)
    private List<Entry> entryList;

    @NoArgsConstructor
    @Data
    public static class Entry {

        /**
         * タイトルです。
         */
        @Element(name = "title")
        private String title;

        /**
         * タイトルです。
         */
        @Element(name = "id")
        private String id;

    }
}