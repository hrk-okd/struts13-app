package my.struts.presentation.action;

import my.struts.presentation.controller.DisplayEarthquakeController;
import my.struts.config.ConfigBuilder;
import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 地震情報を表示します。
 */
public class DisplayEarthquakeAction extends Action {

    /**
     * 地震情報コントローラ
     */
    private final DisplayEarthquakeController controller = ConfigBuilder.getDisplayEarthquakeController();

    /**
     * {@inheritDoc}
     */
    public ActionForward execute(ActionMapping mapping, ActionForm form,
            HttpServletRequest request,
            HttpServletResponse response) throws Exception {
        return mapping.findForward(controller.execute(this, mapping, form, request, response));
    }
}
