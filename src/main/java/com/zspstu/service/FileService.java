package com.zspstu.service;

import com.zspstu.domain.File;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface FileService {

    int addFile(File file);

    List<File> queryFilesByUid(Integer uid);

    int deleteFile(String fname,Integer uid);

    boolean fileExsit(Integer uid,String fname);

//    String setFileName(String uid,String uploadName);

    List<File> queryFnameVague(Integer uid,String vagueFindName);

    int updateFname(Integer uid,String oldName,String newName);
}
