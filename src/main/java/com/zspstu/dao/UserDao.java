package com.zspstu.dao;

import com.zspstu.domain.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Repository;

@Repository
public interface UserDao {

    @Insert("insert into `user`(`username`,`password`)values(#{username},#{password})")
    int save(User user);

    @Select("select * from `user` where uid = #{uid} ")
    User findById(@Param("uid") Integer uid);

    @Select("select * from `user` where (username = #{username} OR uid = #{uid}) and password = #{password}")
    User login(@Param("username") String username, @Param("uid") String uid, @Param("password") String password);

    @Update("UPDATE `user` SET currentSize = #{newSize} WHERE uid = #{userUid}")
    int updateSize(@Param("userUid")int userUid,@Param("newSize") double newSize);

    @Select("select * from `user` where username = #{username}")
    User queryUserByUsername(@Param("username") String username);

    @Select("select uid from `user` where username = #{username}")
    int findUid(@Param("username") String username);
}
