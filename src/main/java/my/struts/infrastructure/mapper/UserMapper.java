package my.struts.infrastructure.mapper;

import my.struts.domain.entity.MUserAuth;
import org.apache.ibatis.annotations.*;
import org.springframework.lang.NonNull;
import org.springframework.stereotype.Component;

/**
 * ユーザ情報を取得するレポジトリです。
 */
@Component
@Mapper
public interface UserMapper {

    /**
     * ユーザIDとパスワードを指定して、ユーザの認証情報を取得します。
     *
     * @param userId   ユーザID
     * @param password パスワード
     * @return 認証情報
     */
    @Select("select * from public.m_user_auth"
            + " where user_id = #{userId} AND password = #{password}")
    @Results(id = "MUserAuthResult", value = {
            @Result(property = "userId", column = "user_id", id = true),
            @Result(property = "password", column = "password"),
    })
    MUserAuth find(@NonNull @Param("userId") final String userId,
            @NonNull @Param("password") final String password);

//    @Delete("delete from player where id = #{id}")
//    void delete(Long id);

}