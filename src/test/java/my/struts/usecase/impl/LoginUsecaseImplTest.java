package my.struts.usecase.impl;

import my.struts.domain.model.UserInfo;
import my.struts.domain.repository.UserRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class LoginUsecaseImplTest {

    private LoginUsecaseImpl target;

    @Mock
    private UserRepository userRepository;

    @Mock
    private UserInfo userInfo;

    @BeforeEach
    void setup() {
        target = new LoginUsecaseImpl(userRepository);
    }

    @Test
    void ログイン成功_ユーザ情報を取得する() {
        // mock
        String userId = "hrk_okd";
        String password = "aaa";
        String userName = "hiroki okuda";

        when(userInfo.getUserId()).thenReturn(userId);
        when(userInfo.getUserName()).thenReturn(userName);
        when(userRepository.find(userId, password)).thenReturn(userInfo);

        // execute
        UserInfo userInfo = target.login(userId, password);

        // verify
        assertThat(userInfo).isNotNull();
        assertThat(userInfo.getUserId()).isEqualTo(userId);
        assertThat(userInfo.getUserName()).isEqualTo(userName);
    }

    @Test
    void ログイン失敗_nullを返す() {
        // mock
        String userId = "hrk_okd";
        String password = "aab";
        when(userRepository.find(userId, password)).thenReturn(null);

        // execute
        UserInfo userInfo = target.login(userId, password);

        // verify
        assertThat(userInfo).isNull();
    }

}
