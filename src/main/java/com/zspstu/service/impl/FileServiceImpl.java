package com.zspstu.service.impl;

import com.zspstu.dao.FileDao;
import com.zspstu.domain.File;
import com.zspstu.service.FileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FileServiceImpl implements FileService {

    @Autowired
    private FileDao fileDao;

    @Override
    public int addFile(File file) {
        return fileDao.addFile(file);
    }

    @Override
    public List<File> queryFilesByUid(Integer uid) {
        return fileDao.queryFilesByUid(uid);
    }

    @Override
    public int deleteFile(String fname,Integer uid) {
        return fileDao.deleteFile(fname,uid);
    }

    @Override
    public boolean fileExsit(Integer uid, String fname) {
        return fileDao.queryByUidAndFName(uid,fname) != null;
    }

    @Override
    public List<File> queryFnameVague(Integer uid, String vagueFindName) {
        return fileDao.queryFnameVague(uid,vagueFindName);
    }

    @Override
    public int updateFname(Integer uid, String oldName, String newName) {
        return fileDao.updateFname(uid,oldName,newName);
    }


}
