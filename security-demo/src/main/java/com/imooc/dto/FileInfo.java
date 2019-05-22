package com.imooc.dto;

/**
 * FileInfo
 *
 * @author Leslie
 * @email panxiang_work@163.com
 * @create 2019/5/22 16:43
 */
public class FileInfo {

    public FileInfo(String path) {
        this.path = path;
    }

    private String path;

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

}
