package my.struts.presentation.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import my.struts.presentation.controller.LoginSubmitController;
import my.struts.config.ConfigBuilder;

/**
 * ログイン処理を行います。
 */
public class LoginSubmitAction extends Action {

    /**
     * ログインコントローラ
     */
    private final LoginSubmitController controller = ConfigBuilder.getLoginSubmitController();

    /**
     * {@inheritDoc}
     */
    public ActionForward execute(ActionMapping mapping, ActionForm form,
            HttpServletRequest request,
            HttpServletResponse response) throws Exception {
        return mapping.findForward(controller.execute(this, mapping, form, request, response));
    }
}
