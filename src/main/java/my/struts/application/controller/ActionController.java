package my.struts.application.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionMapping;
import org.springframework.lang.NonNull;

/**
 * アクションから処理を委譲するクラスです。
 */
public interface ActionController {

    /**
     * 処理を実行します。
     *
     * @param action アクション
     * @param mapping マッピング
     * @param form フォーム
     * @param request リクエスト
     * @param response レスポンス
     * @return 遷移先
     */
    String execute(@NonNull final Action action,
            @NonNull final ActionMapping mapping,
            @NonNull final ActionForm form,
            @NonNull final HttpServletRequest request,
            @NonNull final HttpServletResponse response);
}