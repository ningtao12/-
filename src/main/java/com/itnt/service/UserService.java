package com.itnt.service;

import com.itnt.pojo.User;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;


@Transactional
public interface UserService {

    public boolean save(User user);

    public boolean delete(Integer id);

    public boolean update(User user);

    public User getById(Integer id);

    public List<User> getAll();
}
