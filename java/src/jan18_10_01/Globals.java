package jan18_10_01;
import java.util.Random;
import battlecode.common.*;

public class Globals {
    public static RobotController rc;
    public static final Random rng = new Random();
    public static void init(RobotController rc) {
        rng.setSeed((long) rc.getID());
        Globals.rc = rc;
    }

    public static RobotInfo[] friends;
    public static RobotInfo[] enemies;
    public static void run() throws GameActionException {
        friends = rc.senseNearbyRobots(-1, rc.getTeam());
        enemies = rc.senseNearbyRobots(-1, rc.getTeam().opponent());
    }

    public static UnitType getTowerToBuild() throws GameActionException {
        // return UnitType.LEVEL_ONE_MONEY_TOWER;
        int sz = Math.max(rc.getMapWidth(), rc.getMapHeight());
        int firstPaint = 0;
        if (sz <= 35) {
            firstPaint = 3;
        } else if (sz <= 50) {
            firstPaint = 4;
        } else if (sz <= 55){
            firstPaint = 5;
        }
        else {
            firstPaint = 7;
        }
        if (rc.getMoney() < 2000 && rc.getNumberTowers() != firstPaint) return UnitType.LEVEL_ONE_MONEY_TOWER;
        return UnitType.LEVEL_ONE_PAINT_TOWER;
    }

    public static boolean isTower(UnitType u) {
        return switch (u) {
            case SOLDIER -> false;
            case SPLASHER -> false;
            case MOPPER -> false;
            default -> true;
        };
    }
}