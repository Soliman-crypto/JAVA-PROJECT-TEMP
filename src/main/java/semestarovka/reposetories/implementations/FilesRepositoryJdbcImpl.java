package semestarovka.reposetories.implementations;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import semestarovka.models.FileInfo;
import semestarovka.reposetories.Filesrepo;

import javax.sql.DataSource;
import java.util.List;

public class FilesRepositoryJdbcImpl implements Filesrepo {

    private DataSource dataSource;

    //language=SQL
    private final static String SQL_INSERT = "INSERT INTO fileTable(storage_file_name, original_file_name, type, size, user_id) VALUES (?, ?, ?, ?, ?)";

    //language=SQL
    private final static String SQL_SELECT_BY_ID = "SELECT * FROM fileTable WHERE id = ?";

    private final static String SQL_SELECT = "SELECT * FROM fileTable";


    private JdbcTemplate jdbcTemplate;

    public FilesRepositoryJdbcImpl(DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }

    private RowMapper<FileInfo> fileRowMapper = (row, rowNumber) ->
            FileInfo.builder()
                    .id(row.getLong("id"))
                    .originalFileName(row.getString("original_file_name"))
                    .storageFileName(row.getString("storage_file_name"))
                    .size(row.getLong("size"))
                    .type(row.getString("type"))
                    .userId(row.getLong("user_id"))
                    .build();

    @Override
    public void save(FileInfo entity) {
        jdbcTemplate.update(SQL_INSERT, entity.getStorageFileName(), entity.getOriginalFileName(),
                entity.getType(), entity.getSize(), entity.getUserId());
    }

    @Override
    public FileInfo findById(Long id) {
        return jdbcTemplate.queryForObject(SQL_SELECT_BY_ID, fileRowMapper, id);
    }


    @Override
    public List<FileInfo> findAll() {
        // Implement the query to retrieve all files
        // Use jdbcTemplate.query for multiple results
        return jdbcTemplate.query(SQL_SELECT, fileRowMapper);
    }
}