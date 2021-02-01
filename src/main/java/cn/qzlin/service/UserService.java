package cn.qzlin.service;

import cn.qzlin.dao.UserDao;
import cn.qzlin.enity.Authority;
import cn.qzlin.enity.Role;
import cn.qzlin.enity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @description:
 * @author: qzl
 * @created: 2021/02/01 11:00
 */
@Service
public class UserService implements UserDetailsService {
    @Autowired
    UserDao userDao;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userDao.getUserByUsername(username);
        if (null == user){
            //用户不存在
            throw new UsernameNotFoundException("用户不存在");
        }
        //查询用户角色
        List<Role> roleList = userDao.getRoleByUserId(user.getId());
        //查询角色下的权限
        for (Role role : roleList){
            List<Authority> authList = userDao.getAuthByRoleId(role.getId());
            role.setAuthorityList(authList);
        }
        user.setRoles(roleList);
        return user;
    }
}
