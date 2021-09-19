package com.it.dao;

/**
 * ToDo
 *
 * @author Lyle
 * @date 2021/9/19
 */
public interface UserDao {

    void save();

    void delete();

    Object findById(int id);
}
