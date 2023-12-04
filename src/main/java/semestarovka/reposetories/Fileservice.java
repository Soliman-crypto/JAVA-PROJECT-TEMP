package semestarovka.reposetories;

import semestarovka.models.FileInfo;
import semestarovka.models.User;

import java.io.InputStream;
import java.io.OutputStream;

public interface Fileservice {


    void saveFileToStorage(InputStream file, String originalFileName, String contentType, Long size, Long userId);
    void writeFileFromStorage(Long fileId, OutputStream outputStream);

    FileInfo getFileInfo(Long fileId);

}
