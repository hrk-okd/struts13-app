package my.struts.domain.repository;

import my.struts.domain.model.UserInfo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.springframework.lang.NonNull;

import my.struts.domain.entity.MUserAuth;

import static java.util.Objects.isNull;

/**
 * ユーザ情報を取得するレポジトリです。
 */
public interface UserRepository {

    /**
     * ユーザ情報を取得します。
     * @param userId ユーザID
     * @param password パスワード
     * @return ユーザ情報
     */
    UserInfo find(@NonNull final String userId, @NonNull final String password);
}