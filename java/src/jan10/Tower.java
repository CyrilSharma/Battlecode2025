


package jan10;
import battlecode.common.*;

public class Tower {
    public static RobotController rc;
    public static MapLocation myloc;
    public static void init(RobotController rc) {
        Tower.rc = rc;
    }

    public static UnitType getUnitType() throws GameActionException {
        if (Globals.rng.nextInt(2) == 0 || rc.getMoney() < 1300) return UnitType.SOLDIER;
        return UnitType.MOPPER;
    }

    public static void run() throws GameActionException {
        // Initialize
        myloc = rc.getLocation();
        MapLocation nextLoc;

        if (rc.getRoundNum() > 50) {
            if(rc.getMoney() < 1250) return;
            if(rc.getPaint() < 200) return;
        }

        loop: {
            nextLoc = myloc.add(Direction.NORTH);
            if (rc.canBuildRobot(getUnitType(), nextLoc)) {
                rc.buildRobot(getUnitType(), nextLoc);
                break loop;
            }
        
            nextLoc = myloc.add(Direction.NORTHEAST);
            if (rc.canBuildRobot(getUnitType(), nextLoc)) {
                rc.buildRobot(getUnitType(), nextLoc);
                break loop;
            }
        
            nextLoc = myloc.add(Direction.EAST);
            if (rc.canBuildRobot(getUnitType(), nextLoc)) {
                rc.buildRobot(getUnitType(), nextLoc);
                break loop;
            }
        
            nextLoc = myloc.add(Direction.SOUTHEAST);
            if (rc.canBuildRobot(getUnitType(), nextLoc)) {
                rc.buildRobot(getUnitType(), nextLoc);
                break loop;
            }
        
            nextLoc = myloc.add(Direction.SOUTH);
            if (rc.canBuildRobot(getUnitType(), nextLoc)) {
                rc.buildRobot(getUnitType(), nextLoc);
                break loop;
            }
        
            nextLoc = myloc.add(Direction.SOUTHWEST);
            if (rc.canBuildRobot(getUnitType(), nextLoc)) {
                rc.buildRobot(getUnitType(), nextLoc);
                break loop;
            }
        
            nextLoc = myloc.add(Direction.WEST);
            if (rc.canBuildRobot(getUnitType(), nextLoc)) {
                rc.buildRobot(getUnitType(), nextLoc);
                break loop;
            }
        
            nextLoc = myloc.add(Direction.NORTHWEST);
            if (rc.canBuildRobot(getUnitType(), nextLoc)) {
                rc.buildRobot(getUnitType(), nextLoc);
                break loop;
            }
        
            nextLoc = myloc.add(Direction.CENTER);
            if (rc.canBuildRobot(getUnitType(), nextLoc)) {
                rc.buildRobot(getUnitType(), nextLoc);
                break loop;
            }
        }
    }
}