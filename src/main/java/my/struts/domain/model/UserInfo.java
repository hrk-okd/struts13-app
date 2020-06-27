package my.struts.domain.model;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

/**
 * ユーザ情報です。
 * 
 */
@RequiredArgsConstructor
@Getter
public class UserInfo {

    /**
     * ユーザIDです。
     */
    private final String userId;

    /**
     * ユーザ名です。
     */
    private final String userName;

}