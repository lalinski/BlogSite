package com.lalin.test.site.blog.mix.one.Dao;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * Created by frzhao on 2017/4/22.
 */
public interface UserRepository extends JpaRepository<User, Integer> {

    public List<User> findByUsername(String username);
}
