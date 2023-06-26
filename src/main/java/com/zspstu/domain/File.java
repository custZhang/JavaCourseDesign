package com.zspstu.domain;

public class File {
    private Integer fid;
    private String fname;
    private double fsize;
    private String updatetime;
    private String fpath;
    private Integer uid;

    public File() {
    }

    public File(Integer fid, String fname, double fsize, String updatetime, String fpath, Integer uid) {
        this.fid = fid;
        this.fname = fname;
        this.fsize = fsize;
        this.fsize = this.fsize == 0 ? 0.01 : fsize;
        this.updatetime = updatetime;
        this.fpath = fpath;
        this.uid = uid;
    }

    public Integer getFid() {
        return fid;
    }

    public void setFid(Integer fid) {
        this.fid = fid;
    }

    public String getFname() {
        return fname;
    }

    public void setFname(String fname) {
        this.fname = fname;
    }

    public double getFsize() {
        return fsize;
    }

    public void setFsize(double fsize) {
        this.fsize = fsize;
    }

    public String getUpdatetime() {
        return updatetime;
    }

    public void setUpdatetime(String updatetime) {
        this.updatetime = updatetime;
    }

    public String getFpath() {
        return fpath;
    }

    public void setFpath(String fpath) {
        this.fpath = fpath;
    }

    public Integer getUid() {
        return uid;
    }

    public void setUid(Integer uid) {
        this.uid = uid;
    }

    @Override
    public String toString() {
        return "File{" +
                "fid=" + fid +
                ", fname='" + fname + '\'' +
                ", fsize=" + fsize +
                ", updatetime='" + updatetime + '\'' +
                ", fpath='" + fpath + '\'' +
                ", uid=" + uid +
                '}';
    }
}
