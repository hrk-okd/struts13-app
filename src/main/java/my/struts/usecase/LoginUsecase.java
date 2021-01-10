package my.struts.usecase;

import my.struts.domain.model.UserInfo;
import org.springframework.lang.NonNull;
import org.springframework.lang.Nullable;

/**
 * ログイン処理を行います。
 * 
 */
public interface LoginUsecase {
    
    /**
     * ログイン処理を行います。
     * 
     * @return ユーザ情報
     */
    @Nullable
    UserInfo login(@NonNull final String userId, @NonNull final String password);
}