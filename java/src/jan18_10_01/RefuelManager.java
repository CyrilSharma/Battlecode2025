package jan18_10_01;
import java.util.Random;
import battlecode.common.*;

public class RefuelManager {    
    public static RobotController rc;
    public static int homeState;
    public static MapLocation home = null;
    public static boolean reachedHome = false;

    
    
    public static MapLocation previousPosition0;
    
    public static MapLocation previousPosition1;
    
    public static MapLocation previousPosition2;
    
    public static MapLocation previousPosition3;
    
    public static MapLocation previousPosition4;
    
    public static MapLocation previousPosition5;
    
    public static MapLocation previousPosition6;
    
    public static MapLocation previousPosition7;
    
    public static MapLocation previousPosition8;
    
    public static MapLocation previousPosition9;
    

    public static void init(RobotController rc) {
        RefuelManager.rc = rc;
        
        previousPosition0 = rc.getLocation();
        
        previousPosition1 = rc.getLocation();
        
        previousPosition2 = rc.getLocation();
        
        previousPosition3 = rc.getLocation();
        
        previousPosition4 = rc.getLocation();
        
        previousPosition5 = rc.getLocation();
        
        previousPosition6 = rc.getLocation();
        
        previousPosition7 = rc.getLocation();
        
        previousPosition8 = rc.getLocation();
        
        previousPosition9 = rc.getLocation();
        
    }

    public static void updatePositions() throws GameActionException {
        
        previousPosition9 = previousPosition8;
        
        previousPosition8 = previousPosition7;
        
        previousPosition7 = previousPosition6;
        
        previousPosition6 = previousPosition5;
        
        previousPosition5 = previousPosition4;
        
        previousPosition4 = previousPosition3;
        
        previousPosition3 = previousPosition2;
        
        previousPosition2 = previousPosition1;
        
        previousPosition1 = previousPosition0;
        
        previousPosition0 = rc.getLocation();
    }
    
    public static final int TOWER_RUIN = 0;
    public static final int TOWER_NOT_PAINT = 1;
    public static final int TOWER_PAINT = 2;
    public static int getTowerState(RobotInfo robot) {
        if (robot == null) return TOWER_RUIN;
        else {
            switch (robot.type) {
                case LEVEL_ONE_PAINT_TOWER, LEVEL_TWO_PAINT_TOWER, LEVEL_THREE_PAINT_TOWER:
                    return TOWER_PAINT;
                default: {
                    if (robot.paintAmount != 0) return TOWER_PAINT;
                    else return TOWER_NOT_PAINT;
                }
            }
        }
    }
   
    public static void setHome() throws GameActionException {
        if (home != null && rc.canSenseLocation(home)) {
             RobotInfo robot = rc.senseRobotAtLocation(home);
             homeState = getTowerState(robot);
        }
        MapLocation[] ruins = rc.senseNearbyRuins(-1);
        for (MapLocation ruin: ruins) {
            RobotInfo robot = rc.senseRobotAtLocation(ruin);
            if (robot != null && robot.team != rc.getTeam()) continue;
            int towerState = getTowerState(robot);
            // This home null check is only for when the robot is initialized
            // Home will never be null after the robot is created.
            if (home == null || towerState >= homeState) {
                home = ruin;
                homeState = towerState;
                reachedHome = false;
            }
        }
    }

    public static void refuel() throws GameActionException {
        boolean atHome = (rc.getLocation().distanceSquaredTo(home) <= 9);
        if (atHome && !reachedHome) {
            reachedHome = true;
        }
            
        if (!reachedHome && homeState == TOWER_PAINT) {
            rc.setIndicatorString("Going home... " + home.x + " " + home.y);
            Pathing.pathTo(home);
        } else if (atHome && homeState == TOWER_PAINT) {
            rc.setIndicatorString("At home, refueling...");
            Pathing.pathTo(home);
            RobotInfo r = rc.senseRobotAtLocation(home);
            if (r == null) { 
                homeState = getTowerState(r);
            } else {
                int amt = Math.max(rc.getPaint() - rc.getType().paintCapacity, -r.getPaintAmount());
                if (rc.canTransferPaint(home, amt)) {
                    rc.transferPaint(home, amt);
                }
            }
        } else if (homeState != TOWER_PAINT) {
            rc.setIndicatorString("Going somewhere new!");
            findPaintTower();
        } else {
            rc.setIndicatorString("homeState := " + homeState + ", " + home.x + " " + home.y);
        }

        updatePositions();
    }

    public static void findPaintTower() throws GameActionException {
        double bestDistance = 0;
        double currentDistance;
        Direction bestDir = Direction.CENTER;
        MapLocation myloc = rc.getLocation();
        MapLocation nloc;
        
        nloc = myloc.add(Direction.NORTH);
        if (rc.canSenseLocation(nloc) && rc.canMove(Direction.NORTH)) {
            MapInfo mi = rc.senseMapInfo(nloc);
            if (mi.getPaint().isAlly()) {
                // currentDistance =  0.2 * nloc.distanceSquaredTo(pastTowerTarget);
                currentDistance = 0;
                
                // currentDistance += 0.1 * nloc.distanceSquaredTo(previousPosition0);
                currentDistance += nloc.distanceSquaredTo(previousPosition0);
                
                // currentDistance += 0.2 * nloc.distanceSquaredTo(previousPosition1);
                currentDistance += nloc.distanceSquaredTo(previousPosition1);
                
                // currentDistance += 0.3 * nloc.distanceSquaredTo(previousPosition2);
                currentDistance += nloc.distanceSquaredTo(previousPosition2);
                
                // currentDistance += 0.4 * nloc.distanceSquaredTo(previousPosition3);
                currentDistance += nloc.distanceSquaredTo(previousPosition3);
                
                // currentDistance += 0.5 * nloc.distanceSquaredTo(previousPosition4);
                currentDistance += nloc.distanceSquaredTo(previousPosition4);
                
                // currentDistance += 0.6 * nloc.distanceSquaredTo(previousPosition5);
                currentDistance += nloc.distanceSquaredTo(previousPosition5);
                
                // currentDistance += 0.7 * nloc.distanceSquaredTo(previousPosition6);
                currentDistance += nloc.distanceSquaredTo(previousPosition6);
                
                // currentDistance += 0.8 * nloc.distanceSquaredTo(previousPosition7);
                currentDistance += nloc.distanceSquaredTo(previousPosition7);
                
                // currentDistance += 0.9 * nloc.distanceSquaredTo(previousPosition8);
                currentDistance += nloc.distanceSquaredTo(previousPosition8);
                
                // currentDistance += 1.0 * nloc.distanceSquaredTo(previousPosition9);
                currentDistance += nloc.distanceSquaredTo(previousPosition9);
                
                
                if (currentDistance > bestDistance) {
                    bestDir = Direction.NORTH;
                    bestDistance = currentDistance;
                }
            }
        }
        
        nloc = myloc.add(Direction.NORTHEAST);
        if (rc.canSenseLocation(nloc) && rc.canMove(Direction.NORTHEAST)) {
            MapInfo mi = rc.senseMapInfo(nloc);
            if (mi.getPaint().isAlly()) {
                // currentDistance =  0.2 * nloc.distanceSquaredTo(pastTowerTarget);
                currentDistance = 0;
                
                // currentDistance += 0.1 * nloc.distanceSquaredTo(previousPosition0);
                currentDistance += nloc.distanceSquaredTo(previousPosition0);
                
                // currentDistance += 0.2 * nloc.distanceSquaredTo(previousPosition1);
                currentDistance += nloc.distanceSquaredTo(previousPosition1);
                
                // currentDistance += 0.3 * nloc.distanceSquaredTo(previousPosition2);
                currentDistance += nloc.distanceSquaredTo(previousPosition2);
                
                // currentDistance += 0.4 * nloc.distanceSquaredTo(previousPosition3);
                currentDistance += nloc.distanceSquaredTo(previousPosition3);
                
                // currentDistance += 0.5 * nloc.distanceSquaredTo(previousPosition4);
                currentDistance += nloc.distanceSquaredTo(previousPosition4);
                
                // currentDistance += 0.6 * nloc.distanceSquaredTo(previousPosition5);
                currentDistance += nloc.distanceSquaredTo(previousPosition5);
                
                // currentDistance += 0.7 * nloc.distanceSquaredTo(previousPosition6);
                currentDistance += nloc.distanceSquaredTo(previousPosition6);
                
                // currentDistance += 0.8 * nloc.distanceSquaredTo(previousPosition7);
                currentDistance += nloc.distanceSquaredTo(previousPosition7);
                
                // currentDistance += 0.9 * nloc.distanceSquaredTo(previousPosition8);
                currentDistance += nloc.distanceSquaredTo(previousPosition8);
                
                // currentDistance += 1.0 * nloc.distanceSquaredTo(previousPosition9);
                currentDistance += nloc.distanceSquaredTo(previousPosition9);
                
                
                if (currentDistance > bestDistance) {
                    bestDir = Direction.NORTHEAST;
                    bestDistance = currentDistance;
                }
            }
        }
        
        nloc = myloc.add(Direction.EAST);
        if (rc.canSenseLocation(nloc) && rc.canMove(Direction.EAST)) {
            MapInfo mi = rc.senseMapInfo(nloc);
            if (mi.getPaint().isAlly()) {
                // currentDistance =  0.2 * nloc.distanceSquaredTo(pastTowerTarget);
                currentDistance = 0;
                
                // currentDistance += 0.1 * nloc.distanceSquaredTo(previousPosition0);
                currentDistance += nloc.distanceSquaredTo(previousPosition0);
                
                // currentDistance += 0.2 * nloc.distanceSquaredTo(previousPosition1);
                currentDistance += nloc.distanceSquaredTo(previousPosition1);
                
                // currentDistance += 0.3 * nloc.distanceSquaredTo(previousPosition2);
                currentDistance += nloc.distanceSquaredTo(previousPosition2);
                
                // currentDistance += 0.4 * nloc.distanceSquaredTo(previousPosition3);
                currentDistance += nloc.distanceSquaredTo(previousPosition3);
                
                // currentDistance += 0.5 * nloc.distanceSquaredTo(previousPosition4);
                currentDistance += nloc.distanceSquaredTo(previousPosition4);
                
                // currentDistance += 0.6 * nloc.distanceSquaredTo(previousPosition5);
                currentDistance += nloc.distanceSquaredTo(previousPosition5);
                
                // currentDistance += 0.7 * nloc.distanceSquaredTo(previousPosition6);
                currentDistance += nloc.distanceSquaredTo(previousPosition6);
                
                // currentDistance += 0.8 * nloc.distanceSquaredTo(previousPosition7);
                currentDistance += nloc.distanceSquaredTo(previousPosition7);
                
                // currentDistance += 0.9 * nloc.distanceSquaredTo(previousPosition8);
                currentDistance += nloc.distanceSquaredTo(previousPosition8);
                
                // currentDistance += 1.0 * nloc.distanceSquaredTo(previousPosition9);
                currentDistance += nloc.distanceSquaredTo(previousPosition9);
                
                
                if (currentDistance > bestDistance) {
                    bestDir = Direction.EAST;
                    bestDistance = currentDistance;
                }
            }
        }
        
        nloc = myloc.add(Direction.SOUTHEAST);
        if (rc.canSenseLocation(nloc) && rc.canMove(Direction.SOUTHEAST)) {
            MapInfo mi = rc.senseMapInfo(nloc);
            if (mi.getPaint().isAlly()) {
                // currentDistance =  0.2 * nloc.distanceSquaredTo(pastTowerTarget);
                currentDistance = 0;
                
                // currentDistance += 0.1 * nloc.distanceSquaredTo(previousPosition0);
                currentDistance += nloc.distanceSquaredTo(previousPosition0);
                
                // currentDistance += 0.2 * nloc.distanceSquaredTo(previousPosition1);
                currentDistance += nloc.distanceSquaredTo(previousPosition1);
                
                // currentDistance += 0.3 * nloc.distanceSquaredTo(previousPosition2);
                currentDistance += nloc.distanceSquaredTo(previousPosition2);
                
                // currentDistance += 0.4 * nloc.distanceSquaredTo(previousPosition3);
                currentDistance += nloc.distanceSquaredTo(previousPosition3);
                
                // currentDistance += 0.5 * nloc.distanceSquaredTo(previousPosition4);
                currentDistance += nloc.distanceSquaredTo(previousPosition4);
                
                // currentDistance += 0.6 * nloc.distanceSquaredTo(previousPosition5);
                currentDistance += nloc.distanceSquaredTo(previousPosition5);
                
                // currentDistance += 0.7 * nloc.distanceSquaredTo(previousPosition6);
                currentDistance += nloc.distanceSquaredTo(previousPosition6);
                
                // currentDistance += 0.8 * nloc.distanceSquaredTo(previousPosition7);
                currentDistance += nloc.distanceSquaredTo(previousPosition7);
                
                // currentDistance += 0.9 * nloc.distanceSquaredTo(previousPosition8);
                currentDistance += nloc.distanceSquaredTo(previousPosition8);
                
                // currentDistance += 1.0 * nloc.distanceSquaredTo(previousPosition9);
                currentDistance += nloc.distanceSquaredTo(previousPosition9);
                
                
                if (currentDistance > bestDistance) {
                    bestDir = Direction.SOUTHEAST;
                    bestDistance = currentDistance;
                }
            }
        }
        
        nloc = myloc.add(Direction.SOUTH);
        if (rc.canSenseLocation(nloc) && rc.canMove(Direction.SOUTH)) {
            MapInfo mi = rc.senseMapInfo(nloc);
            if (mi.getPaint().isAlly()) {
                // currentDistance =  0.2 * nloc.distanceSquaredTo(pastTowerTarget);
                currentDistance = 0;
                
                // currentDistance += 0.1 * nloc.distanceSquaredTo(previousPosition0);
                currentDistance += nloc.distanceSquaredTo(previousPosition0);
                
                // currentDistance += 0.2 * nloc.distanceSquaredTo(previousPosition1);
                currentDistance += nloc.distanceSquaredTo(previousPosition1);
                
                // currentDistance += 0.3 * nloc.distanceSquaredTo(previousPosition2);
                currentDistance += nloc.distanceSquaredTo(previousPosition2);
                
                // currentDistance += 0.4 * nloc.distanceSquaredTo(previousPosition3);
                currentDistance += nloc.distanceSquaredTo(previousPosition3);
                
                // currentDistance += 0.5 * nloc.distanceSquaredTo(previousPosition4);
                currentDistance += nloc.distanceSquaredTo(previousPosition4);
                
                // currentDistance += 0.6 * nloc.distanceSquaredTo(previousPosition5);
                currentDistance += nloc.distanceSquaredTo(previousPosition5);
                
                // currentDistance += 0.7 * nloc.distanceSquaredTo(previousPosition6);
                currentDistance += nloc.distanceSquaredTo(previousPosition6);
                
                // currentDistance += 0.8 * nloc.distanceSquaredTo(previousPosition7);
                currentDistance += nloc.distanceSquaredTo(previousPosition7);
                
                // currentDistance += 0.9 * nloc.distanceSquaredTo(previousPosition8);
                currentDistance += nloc.distanceSquaredTo(previousPosition8);
                
                // currentDistance += 1.0 * nloc.distanceSquaredTo(previousPosition9);
                currentDistance += nloc.distanceSquaredTo(previousPosition9);
                
                
                if (currentDistance > bestDistance) {
                    bestDir = Direction.SOUTH;
                    bestDistance = currentDistance;
                }
            }
        }
        
        nloc = myloc.add(Direction.SOUTHWEST);
        if (rc.canSenseLocation(nloc) && rc.canMove(Direction.SOUTHWEST)) {
            MapInfo mi = rc.senseMapInfo(nloc);
            if (mi.getPaint().isAlly()) {
                // currentDistance =  0.2 * nloc.distanceSquaredTo(pastTowerTarget);
                currentDistance = 0;
                
                // currentDistance += 0.1 * nloc.distanceSquaredTo(previousPosition0);
                currentDistance += nloc.distanceSquaredTo(previousPosition0);
                
                // currentDistance += 0.2 * nloc.distanceSquaredTo(previousPosition1);
                currentDistance += nloc.distanceSquaredTo(previousPosition1);
                
                // currentDistance += 0.3 * nloc.distanceSquaredTo(previousPosition2);
                currentDistance += nloc.distanceSquaredTo(previousPosition2);
                
                // currentDistance += 0.4 * nloc.distanceSquaredTo(previousPosition3);
                currentDistance += nloc.distanceSquaredTo(previousPosition3);
                
                // currentDistance += 0.5 * nloc.distanceSquaredTo(previousPosition4);
                currentDistance += nloc.distanceSquaredTo(previousPosition4);
                
                // currentDistance += 0.6 * nloc.distanceSquaredTo(previousPosition5);
                currentDistance += nloc.distanceSquaredTo(previousPosition5);
                
                // currentDistance += 0.7 * nloc.distanceSquaredTo(previousPosition6);
                currentDistance += nloc.distanceSquaredTo(previousPosition6);
                
                // currentDistance += 0.8 * nloc.distanceSquaredTo(previousPosition7);
                currentDistance += nloc.distanceSquaredTo(previousPosition7);
                
                // currentDistance += 0.9 * nloc.distanceSquaredTo(previousPosition8);
                currentDistance += nloc.distanceSquaredTo(previousPosition8);
                
                // currentDistance += 1.0 * nloc.distanceSquaredTo(previousPosition9);
                currentDistance += nloc.distanceSquaredTo(previousPosition9);
                
                
                if (currentDistance > bestDistance) {
                    bestDir = Direction.SOUTHWEST;
                    bestDistance = currentDistance;
                }
            }
        }
        
        nloc = myloc.add(Direction.WEST);
        if (rc.canSenseLocation(nloc) && rc.canMove(Direction.WEST)) {
            MapInfo mi = rc.senseMapInfo(nloc);
            if (mi.getPaint().isAlly()) {
                // currentDistance =  0.2 * nloc.distanceSquaredTo(pastTowerTarget);
                currentDistance = 0;
                
                // currentDistance += 0.1 * nloc.distanceSquaredTo(previousPosition0);
                currentDistance += nloc.distanceSquaredTo(previousPosition0);
                
                // currentDistance += 0.2 * nloc.distanceSquaredTo(previousPosition1);
                currentDistance += nloc.distanceSquaredTo(previousPosition1);
                
                // currentDistance += 0.3 * nloc.distanceSquaredTo(previousPosition2);
                currentDistance += nloc.distanceSquaredTo(previousPosition2);
                
                // currentDistance += 0.4 * nloc.distanceSquaredTo(previousPosition3);
                currentDistance += nloc.distanceSquaredTo(previousPosition3);
                
                // currentDistance += 0.5 * nloc.distanceSquaredTo(previousPosition4);
                currentDistance += nloc.distanceSquaredTo(previousPosition4);
                
                // currentDistance += 0.6 * nloc.distanceSquaredTo(previousPosition5);
                currentDistance += nloc.distanceSquaredTo(previousPosition5);
                
                // currentDistance += 0.7 * nloc.distanceSquaredTo(previousPosition6);
                currentDistance += nloc.distanceSquaredTo(previousPosition6);
                
                // currentDistance += 0.8 * nloc.distanceSquaredTo(previousPosition7);
                currentDistance += nloc.distanceSquaredTo(previousPosition7);
                
                // currentDistance += 0.9 * nloc.distanceSquaredTo(previousPosition8);
                currentDistance += nloc.distanceSquaredTo(previousPosition8);
                
                // currentDistance += 1.0 * nloc.distanceSquaredTo(previousPosition9);
                currentDistance += nloc.distanceSquaredTo(previousPosition9);
                
                
                if (currentDistance > bestDistance) {
                    bestDir = Direction.WEST;
                    bestDistance = currentDistance;
                }
            }
        }
        
        nloc = myloc.add(Direction.NORTHWEST);
        if (rc.canSenseLocation(nloc) && rc.canMove(Direction.NORTHWEST)) {
            MapInfo mi = rc.senseMapInfo(nloc);
            if (mi.getPaint().isAlly()) {
                // currentDistance =  0.2 * nloc.distanceSquaredTo(pastTowerTarget);
                currentDistance = 0;
                
                // currentDistance += 0.1 * nloc.distanceSquaredTo(previousPosition0);
                currentDistance += nloc.distanceSquaredTo(previousPosition0);
                
                // currentDistance += 0.2 * nloc.distanceSquaredTo(previousPosition1);
                currentDistance += nloc.distanceSquaredTo(previousPosition1);
                
                // currentDistance += 0.3 * nloc.distanceSquaredTo(previousPosition2);
                currentDistance += nloc.distanceSquaredTo(previousPosition2);
                
                // currentDistance += 0.4 * nloc.distanceSquaredTo(previousPosition3);
                currentDistance += nloc.distanceSquaredTo(previousPosition3);
                
                // currentDistance += 0.5 * nloc.distanceSquaredTo(previousPosition4);
                currentDistance += nloc.distanceSquaredTo(previousPosition4);
                
                // currentDistance += 0.6 * nloc.distanceSquaredTo(previousPosition5);
                currentDistance += nloc.distanceSquaredTo(previousPosition5);
                
                // currentDistance += 0.7 * nloc.distanceSquaredTo(previousPosition6);
                currentDistance += nloc.distanceSquaredTo(previousPosition6);
                
                // currentDistance += 0.8 * nloc.distanceSquaredTo(previousPosition7);
                currentDistance += nloc.distanceSquaredTo(previousPosition7);
                
                // currentDistance += 0.9 * nloc.distanceSquaredTo(previousPosition8);
                currentDistance += nloc.distanceSquaredTo(previousPosition8);
                
                // currentDistance += 1.0 * nloc.distanceSquaredTo(previousPosition9);
                currentDistance += nloc.distanceSquaredTo(previousPosition9);
                
                
                if (currentDistance > bestDistance) {
                    bestDir = Direction.NORTHWEST;
                    bestDistance = currentDistance;
                }
            }
        }
        
        nloc = myloc.add(Direction.CENTER);
        if (rc.canSenseLocation(nloc) && rc.canMove(Direction.CENTER)) {
            MapInfo mi = rc.senseMapInfo(nloc);
            if (mi.getPaint().isAlly()) {
                // currentDistance =  0.2 * nloc.distanceSquaredTo(pastTowerTarget);
                currentDistance = 0;
                
                // currentDistance += 0.1 * nloc.distanceSquaredTo(previousPosition0);
                currentDistance += nloc.distanceSquaredTo(previousPosition0);
                
                // currentDistance += 0.2 * nloc.distanceSquaredTo(previousPosition1);
                currentDistance += nloc.distanceSquaredTo(previousPosition1);
                
                // currentDistance += 0.3 * nloc.distanceSquaredTo(previousPosition2);
                currentDistance += nloc.distanceSquaredTo(previousPosition2);
                
                // currentDistance += 0.4 * nloc.distanceSquaredTo(previousPosition3);
                currentDistance += nloc.distanceSquaredTo(previousPosition3);
                
                // currentDistance += 0.5 * nloc.distanceSquaredTo(previousPosition4);
                currentDistance += nloc.distanceSquaredTo(previousPosition4);
                
                // currentDistance += 0.6 * nloc.distanceSquaredTo(previousPosition5);
                currentDistance += nloc.distanceSquaredTo(previousPosition5);
                
                // currentDistance += 0.7 * nloc.distanceSquaredTo(previousPosition6);
                currentDistance += nloc.distanceSquaredTo(previousPosition6);
                
                // currentDistance += 0.8 * nloc.distanceSquaredTo(previousPosition7);
                currentDistance += nloc.distanceSquaredTo(previousPosition7);
                
                // currentDistance += 0.9 * nloc.distanceSquaredTo(previousPosition8);
                currentDistance += nloc.distanceSquaredTo(previousPosition8);
                
                // currentDistance += 1.0 * nloc.distanceSquaredTo(previousPosition9);
                currentDistance += nloc.distanceSquaredTo(previousPosition9);
                
                
                if (currentDistance > bestDistance) {
                    bestDir = Direction.CENTER;
                    bestDistance = currentDistance;
                }
            }
        }
        

        if (rc.canMove(bestDir))
            rc.move(bestDir);
    }


    public static void reset() throws GameActionException {
        reachedHome = false;
    }
}