package sprint1Bot;
import battlecode.common.*;

public class Explore {
    public static RobotController rc;
    public static MapLocation exploreTarget = null;
    public static void init(RobotController rc) {
        Explore.rc = rc;
    }

    public static void exploreOnPaint(MapInfo[] near) throws GameActionException {
        explore(near);
    }

    public static void explore(MapInfo[] near) throws GameActionException {
        rc.setIndicatorString("exploring to " + exploreTarget);
        if (exploreTarget == null || rc.getLocation().distanceSquaredTo(exploreTarget) <= 5) {
            exploreTarget = new MapLocation(
                Globals.rng.nextInt(rc.getMapWidth()),
                Globals.rng.nextInt(rc.getMapHeight())
            );
        }
        Pathing.pathTo(exploreTarget);
    }

}