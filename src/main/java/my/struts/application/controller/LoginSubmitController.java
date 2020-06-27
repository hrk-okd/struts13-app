package my.struts.application.controller;

import lombok.RequiredArgsConstructor;
import my.struts.application.form.LoginForm;
import my.struts.domain.model.UserInfo;
import my.struts.domain.service.LoginService;
import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionMapping;
import org.springframework.lang.NonNull;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Objects;

/**
 * ログイン処理を行います。
 */
@Component
@RequiredArgsConstructor
public class LoginSubmitController implements ActionController {

    /**
     * ログインサービスです。
     */
    private final LoginService loginService;

    /**
     * {@inheritDoc}
     */
    @Override
    public String execute(@NonNull final Action action,
            @NonNull final ActionMapping mapping,
            @NonNull final ActionForm form,
            @NonNull final HttpServletRequest request,
            @NonNull final HttpServletResponse response) {

        LoginForm loginForm = (LoginForm) form;

        UserInfo userInfo = loginService.login(loginForm.getUserId(), loginForm.getPassword());
        if (Objects.isNull(userInfo)) {
            return null;
        }

        return "success";
    }


}