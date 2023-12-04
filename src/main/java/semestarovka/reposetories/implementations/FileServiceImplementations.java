package semestarovka.reposetories.implementations;

import org.springframework.jdbc.datasource.DriverManagerDataSource;
import semestarovka.models.FileInfo;
import semestarovka.reposetories.Fileservice;
import semestarovka.reposetories.Filesrepo;

import javax.sql.DataSource;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.UUID;

public class FileServiceImplementations implements Fileservice {

    private Filesrepo filesrepo;
    private DataSource dataSource;

    public FileServiceImplementations(DriverManagerDataSource dataSource) {
        this.dataSource = dataSource;
        this.filesrepo = new FilesRepositoryJdbcImpl(dataSource);
    }

    @Override
    public void saveFileToStorage(InputStream file, String originalFileName, String contentType, Long size, Long userId) {
        FileInfo fileInfo = FileInfo.builder()
                .originalFileName(originalFileName)
                .storageFileName(UUID.randomUUID().toString())
                .size(size)
                .type(contentType)
                .userId(userId)
                .build();
        try {
            Files.copy(file, Paths.get("/Users/macbook/Desktop/Java23:24/StevenGrand/src/main/webapp/profilepics/" + fileInfo.getStorageFileName() + "." + fileInfo.getType().split("/")[1]));
            filesrepo.save(fileInfo);
        } catch (IOException e) {
            throw new IllegalArgumentException(e);
        }
    }

    @Override
    public void writeFileFromStorage(Long fileId, OutputStream outputStream) {
        // нашли файл в базе
        FileInfo fileInfo = filesrepo.findById(fileId);
        // нашли файл на диске
        File file = new File("/Users/macbook/Desktop/Java23:24/StevenGrand/src/main/webapp/profilepics/" + fileInfo.getStorageFileName() + "." + fileInfo.getType().split("/")[1]);
        try {
            // записали его в ответ
            Files.copy(file.toPath(), outputStream);
        } catch (IOException e) {
            throw new IllegalArgumentException(e);
        }
    }

    @Override
    public FileInfo getFileInfo(Long fileId) {
        return filesrepo.findById(fileId);
    }
}
