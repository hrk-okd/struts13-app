package my.struts.domain.util;

import lombok.NoArgsConstructor;

/**
 * アプリケーション独自の例外です。
 */
@NoArgsConstructor
public class AppException extends RuntimeException {

    /**
     * コンストラクタです。
     * @param message メッセージ
     */
    public AppException(String message) {
        super(message);
    }

    /**
     * コンストラクタです。
     * @param e 例外
     */
    public AppException(Exception e) {
        super(e);
    }
}
