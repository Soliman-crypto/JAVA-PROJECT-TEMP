package semestarovka.reposetories;


import semestarovka.models.FileInfo;

import java.util.List;

public interface Filesrepo {


    void save(FileInfo fileInfo);
    FileInfo findById(Long id);

    List<FileInfo> findAll();
}