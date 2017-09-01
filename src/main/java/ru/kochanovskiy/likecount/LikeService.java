package ru.kochanovskiy.likecount;

import java.io.IOException;
import java.sql.SQLException;

public interface LikeService {
    void like(String playerId) throws SQLException, IOException;
    long getLikes(String playerId);
}
