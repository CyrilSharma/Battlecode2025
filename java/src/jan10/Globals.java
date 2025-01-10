package jan10;
import java.util.Random;
import battlecode.common.*;

public class Globals {
    public static final Random rng = new Random();
    public static void init(RobotController rc) {
        rng.setSeed((long) rc.getID());
    }
}