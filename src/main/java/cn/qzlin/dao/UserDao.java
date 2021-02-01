package cn.qzlin.dao;

import cn.qzlin.enity.Authority;
import cn.qzlin.enity.Role;
import cn.qzlin.enity.User;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * 用户dao
 */
@Repository
public interface UserDao {

    /**
     * 根据用户名查用户信息
     * @param username
     * @return
     */
    @Select(" SELECT *" +
            " FROM t_user" +
            " WHERE username = #{username}")
    User getUserByUsername(@Param("username") String username);

    /**
     * 查询用户角色
     * @param id
     * @return
     */
    @Select(" SELECT r.*" +
            " FROM t_role r,t_user_role ur" +
            " WHERE r.id = ur.role_id AND ur.user_id = #{id}")
    List<Role> getRoleByUserId(@Param("id")Integer id);

    /**
     * 查询角色的权限
     * @param id
     * @return
     */
    @Select(" SELECT a.*" +
            " FROM t_authority a,t_role_authority ra" +
            " WHERE a.authority_id = ra.authority_id AND ra.role_id = #{id}")
    List<Authority> getAuthByRoleId(@Param("id") Integer id);
}
