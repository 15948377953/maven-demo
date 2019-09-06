package com.ls.service;

import com.ls.pojo.User;

public interface UserService {
    //根据id查找
    public User getUserById(Integer userid);

    //添加一条数据
    public int insert(User user);

    //根据userName查找

    public User getUserByUserName(String userName);

}
