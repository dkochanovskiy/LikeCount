package ru.kochanovskiy.likecount;

import org.apache.log4j.Logger;

import java.beans.PropertyVetoException;
import java.io.IOException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Like implements LikeService {

    private static final Logger logger = Logger.getLogger(Like.class);

    /**
    * Add likes
     */
    public void like(String playerId) throws IOException {

        final String INSERT_LIKE_QUERY = "update `like` set `like_count` = `like_count` + 1 where `playerId` = 'playerId'";

        try (PreparedStatement ps = ru.kochanovskiy.likecount.DataSource.getInstance().getConnection().prepareStatement(INSERT_LIKE_QUERY)){
            ResultSet rs = ps.executeQuery();

        } catch (SQLException ex) {
            logger.trace("SQLException" + ex);
        } catch (PropertyVetoException ex) {
            logger.trace("PropertyVetoException" + ex);
        }
    }

    /**
     * Get the number of likes by ID
     */
    public long getLikes(String playerId){

        long like_count = 0;

        final String GET_LIKES = "select `like_count` from `like` where id = playerId";

        try(PreparedStatement ps = DataSource.getInstance().getConnection().prepareStatement(GET_LIKES);
            ResultSet rs = ps.executeQuery()) {
            while (rs.next()) {
                like_count = Integer.parseInt(rs.getString("like_count"));
            }
        } catch (SQLException e) {
            logger.trace("SQLException!");
        } catch (IOException e) {
            logger.trace("IOException!");
        } catch (PropertyVetoException e) {
            logger.trace("PropertyVetoException!");
        }
        return like_count;
    }
}
