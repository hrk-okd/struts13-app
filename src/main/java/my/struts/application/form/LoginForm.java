package my.struts.application.form;

import lombok.Data;
import lombok.EqualsAndHashCode;
import org.apache.struts.action.ActionForm;

/**
 * ログイン処理を行います。
 * 
 */
@Data
@EqualsAndHashCode(callSuper = false)
public class LoginForm extends ActionForm {

    /**
     * ユーザIDです。
     */
    private String userId;

    /**
     * パスワードです。
     */
    private String password;
}