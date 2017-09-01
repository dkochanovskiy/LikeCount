import org.junit.Test;
import ru.kochanovskiy.likecount.Like;

public class LikeTest {
    @Test
    void getLikeTest() throws Exception {
        Like like = new Like();
        for(int i = 0; i < 1000; i++){
            like.like("1");
            like.getLikes("1");
        }
    }
}