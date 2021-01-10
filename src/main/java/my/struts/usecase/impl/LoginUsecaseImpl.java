package my.struts.usecase.impl;

import my.struts.usecase.LoginUsecase;
import org.springframework.lang.NonNull;
import org.springframework.lang.Nullable;

import lombok.RequiredArgsConstructor;
import my.struts.domain.model.UserInfo;
import my.struts.domain.repository.UserRepository;
import org.springframework.stereotype.Service;

/**
 * ログイン処理を行います。
 */
@Service
@RequiredArgsConstructor
public class LoginUsecaseImpl implements LoginUsecase {

    /**
     * ユーザ情報取得用レポジトリです。
     */
    private final UserRepository userRepository;

    /**
     * {@inheritDoc}
     */
    @Nullable
    public UserInfo login(@NonNull final String userId, @NonNull final String password) {
        return userRepository.find(userId, password);
    }
}