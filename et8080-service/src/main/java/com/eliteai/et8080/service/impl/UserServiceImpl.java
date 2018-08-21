package com.eliteai.et8080.service.impl;

import com.eliteai.et8080.mapper.UserDao;
import com.eliteai.et8080.mapper.UserMapper;
import com.eliteai.et8080.model.User;
import com.eliteai.et8080.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author MR.ZHANG
 * @create 2018-08-20 9:50
 */
@Service
public class UserServiceImpl implements UserService {
    private final Logger logger = LoggerFactory.getLogger(getClass());
    @Autowired
    UserMapper userMapper;

    @Autowired
    UserDao userDao;

    @Override
    public User selectUserById(Integer id) {
        logger.error("userMapper : " + userMapper);
        User user = userMapper.selectByPrimaryKey(id);
        return user;
       /* List<User> users = userDao.selectAll();
        if (users != null && users.size() > 0) {
            return users.get(0);
        }
        logger.error(" ====================users is null=============");
        return null;*/
    }
}
