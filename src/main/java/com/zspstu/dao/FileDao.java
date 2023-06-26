package com.zspstu.dao;

import com.zspstu.domain.File;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FileDao {

    @Insert("insert into `file`(fname,fsize,updatetime,fpath,uid) values(#{fname},#{fsize},#{updatetime},#{fpath},#{uid})")
    int addFile( File file);

    //查找该用户的所有文件
    @Select("select * from `file` where uid = #{uid}")
    List<File> queryFilesByUid(@Param("uid") Integer uid);

    @Delete("delete from `file` where fname = #{fname} and uid = #{uid}")
    int deleteFile(@Param("fname")String fname,@Param("uid")Integer uid);

    @Select("SELECT * FROM `file` WHERE uid = #{uid} AND fname = #{fname}")
    File queryByUidAndFName(@Param("uid")Integer uid,@Param("fname")String fname);

    @Select("SELECT * FROM `file` WHERE fname LIKE #{vagueFindName} AND uid = #{uid}")
    List<File> queryFnameVague(@Param("uid")Integer uid,@Param("vagueFindName")String vagueFindName);

    @Update("UPDATE `file` SET fname = #{newName} WHERE uid = #{uid} AND fname = #{oldName}")
    int updateFname(@Param("uid") Integer uid,@Param("oldName")String oldName,@Param("newName")String newName);
}
