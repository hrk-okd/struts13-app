package my.struts.presentation.controller;

import lombok.RequiredArgsConstructor;
import my.struts.presentation.form.LoginForm;
import my.struts.domain.model.UserInfo;
import my.struts.usecase.LoginUsecase;
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
    private final LoginUsecase loginUsecase;

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

        UserInfo userInfo = loginUsecase.login(loginForm.getUserId(), loginForm.getPassword());
        if (Objects.isNull(userInfo)) {
            return null;
        }

        return "success";
    }


}