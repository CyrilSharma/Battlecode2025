package jan11;
import battlecode.common.*;

public class Splasher {
    public static RobotController rc;
    public static void init(RobotController rc) {
        Splasher.rc = rc;
    }

    public static void run() throws GameActionException {
        Direction dir = Direction.NORTH;
        MapLocation nextLoc = rc.getLocation().add(dir);
        if (rc.canMove(dir)){
            rc.move(dir);
        }
        if (rc.canMopSwing(dir)){
            rc.mopSwing(dir);
            System.out.println("Mop Swing! Booyah!");
        }
        else if (rc.canAttack(nextLoc)){
            rc.attack(nextLoc);
        }
    }
}