package before_upgrades;
import battlecode.common.*;
import java.util.Stack;

public class Explore {
    public static RobotController rc;
    public static MapLocation exploreTarget = null;
    public static Stack<MapLocation> circle;

    //r = 8
    //public static int cX[] = {-8, -5, 0, 5, 8, 5, 0, -5};
    //public static int cY[] = {0, 6, 8, 6, 0, -6, -8, -6};

    public static int cX[] = {-6, -4, 0, 4, 6, 4, 0, -6};
    public static int cY[] = {0, 4, 6, 4, 0, -4, -6, -4};

    public static void init(RobotController rc) {
        Explore.rc = rc;
        circle = new Stack<>();
    }

    public static void exploreOnPaint(MapInfo[] near) throws GameActionException {
        explore(near);
    }

    public static void explore(MapInfo[] near) throws GameActionException {
        if (exploreTarget == null || rc.getLocation().distanceSquaredTo(exploreTarget) <= 5) {
            /*
            if (!circle.isEmpty()) {
                exploreTarget = circle.pop();
            }
            else {
                if (Globals.rng.nextInt(3) == 0) {
                    int st = Globals.rng.nextInt(8);
                    MapLocation loc;
                    
                    loc = new MapLocation(rc.getLocation().x + cX[(st + 0) % 8], rc.getLocation().y + cY[(st + 0) % 8]);
                    if (Globals.onMap(loc)) {
                        circle.push(loc);
                    }
                    
                    loc = new MapLocation(rc.getLocation().x + cX[(st + 1) % 8], rc.getLocation().y + cY[(st + 1) % 8]);
                    if (Globals.onMap(loc)) {
                        circle.push(loc);
                    }
                    
                    loc = new MapLocation(rc.getLocation().x + cX[(st + 2) % 8], rc.getLocation().y + cY[(st + 2) % 8]);
                    if (Globals.onMap(loc)) {
                        circle.push(loc);
                    }
                    
                    loc = new MapLocation(rc.getLocation().x + cX[(st + 3) % 8], rc.getLocation().y + cY[(st + 3) % 8]);
                    if (Globals.onMap(loc)) {
                        circle.push(loc);
                    }
                    
                    exploreTarget = circle.pop();
                }
                if (exploreTarget == null) {
                    exploreTarget = new MapLocation(
                        Globals.rng.nextInt(rc.getMapWidth()),
                        Globals.rng.nextInt(rc.getMapHeight())
                    );
                }
            }
            */
            exploreTarget = new MapLocation(
                Globals.rng.nextInt(rc.getMapWidth()),
                Globals.rng.nextInt(rc.getMapHeight())
            );
        }
        Pathing.pathTo(exploreTarget);
    }

}