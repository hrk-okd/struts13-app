package my.struts.infrastructure.repository.impl;

import lombok.RequiredArgsConstructor;
import my.struts.domain.entity.MUserAuth;
import my.struts.domain.model.UserInfo;
import my.struts.domain.repository.UserRepository;
import my.struts.infrastructure.mapper.UserMapper;
import org.springframework.lang.NonNull;
import org.springframework.stereotype.Repository;

import static java.util.Objects.isNull;

/**
 * ユーザ情報を取得するレポジトリです。
 */
@Repository
@RequiredArgsConstructor
public class UserRepositoryImpl implements UserRepository {

    /**
     * ユーザ情報取得Mapperです。
     */
    private final UserMapper mapper;

    /**
     * {@inheritDoc}
     */
    @Override
    public UserInfo find(@NonNull final String userId, @NonNull final String password) {
        MUserAuth userAuth = mapper.find(userId, password);
        if (isNull(userAuth)) {
            return null;
        }

        return new UserInfo(userAuth.getUserId(), userAuth.getPassword());
    }

}