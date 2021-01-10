package my.struts.presentation.form;

import lombok.Data;
import lombok.EqualsAndHashCode;
import org.apache.struts.action.ActionForm;

import java.util.List;

/**
 * ログイン処理を行います。
 * 
 */
@Data
@EqualsAndHashCode(callSuper = false)
public class EarthquakeFeedForm extends ActionForm {

    /**
     * エントリリストです。
     */
    private List<Entry> entryList;

    @Data
    public static class Entry {

        private String title;
    }
}