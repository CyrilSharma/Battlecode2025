package jan22_submission;
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
            // Pathing.pathTo(home);
            carefullyGoHome();
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
    }

    public static void carefullyGoHome() throws GameActionException {
        rc.setIndicatorString("Going home... safely...");
        SquareManager.computePaintPenalties();
        MapLocation myloc = rc.getLocation();

        String penalties = "";
        Direction bestDir = null;
        int bestDist = 10000000;
        
        
        {
            int dist = SquareManager.m11.distanceSquaredTo(home);
            Direction dir = myloc.directionTo(SquareManager.m11);
            penalties += ("" + dir + "=" + SquareManager.penalty11 + " ");
            if (SquareManager.penalty11 <= 1 && dist < bestDist && rc.canMove(dir)) {
                bestDist = dist;
                bestDir = dir;
            }
        }
        
        {
            int dist = SquareManager.m12.distanceSquaredTo(home);
            Direction dir = myloc.directionTo(SquareManager.m12);
            penalties += ("" + dir + "=" + SquareManager.penalty12 + " ");
            if (SquareManager.penalty12 <= 1 && dist < bestDist && rc.canMove(dir)) {
                bestDist = dist;
                bestDir = dir;
            }
        }
        
        {
            int dist = SquareManager.m13.distanceSquaredTo(home);
            Direction dir = myloc.directionTo(SquareManager.m13);
            penalties += ("" + dir + "=" + SquareManager.penalty13 + " ");
            if (SquareManager.penalty13 <= 1 && dist < bestDist && rc.canMove(dir)) {
                bestDist = dist;
                bestDir = dir;
            }
        }
        
        
        
        {
            int dist = SquareManager.m21.distanceSquaredTo(home);
            Direction dir = myloc.directionTo(SquareManager.m21);
            penalties += ("" + dir + "=" + SquareManager.penalty21 + " ");
            if (SquareManager.penalty21 <= 1 && dist < bestDist && rc.canMove(dir)) {
                bestDist = dist;
                bestDir = dir;
            }
        }
        
        {
            int dist = SquareManager.m22.distanceSquaredTo(home);
            Direction dir = myloc.directionTo(SquareManager.m22);
            penalties += ("" + dir + "=" + SquareManager.penalty22 + " ");
            if (SquareManager.penalty22 <= 1 && dist < bestDist && rc.canMove(dir)) {
                bestDist = dist;
                bestDir = dir;
            }
        }
        
        {
            int dist = SquareManager.m23.distanceSquaredTo(home);
            Direction dir = myloc.directionTo(SquareManager.m23);
            penalties += ("" + dir + "=" + SquareManager.penalty23 + " ");
            if (SquareManager.penalty23 <= 1 && dist < bestDist && rc.canMove(dir)) {
                bestDist = dist;
                bestDir = dir;
            }
        }
        
        
        
        {
            int dist = SquareManager.m31.distanceSquaredTo(home);
            Direction dir = myloc.directionTo(SquareManager.m31);
            penalties += ("" + dir + "=" + SquareManager.penalty31 + " ");
            if (SquareManager.penalty31 <= 1 && dist < bestDist && rc.canMove(dir)) {
                bestDist = dist;
                bestDir = dir;
            }
        }
        
        {
            int dist = SquareManager.m32.distanceSquaredTo(home);
            Direction dir = myloc.directionTo(SquareManager.m32);
            penalties += ("" + dir + "=" + SquareManager.penalty32 + " ");
            if (SquareManager.penalty32 <= 1 && dist < bestDist && rc.canMove(dir)) {
                bestDist = dist;
                bestDir = dir;
            }
        }
        
        {
            int dist = SquareManager.m33.distanceSquaredTo(home);
            Direction dir = myloc.directionTo(SquareManager.m33);
            penalties += ("" + dir + "=" + SquareManager.penalty33 + " ");
            if (SquareManager.penalty33 <= 1 && dist < bestDist && rc.canMove(dir)) {
                bestDist = dist;
                bestDir = dir;
            }
        }
        
        

        rc.setIndicatorString(penalties);
        if (bestDir != null) rc.move(bestDir);
    }

    public static void findPaintTower() throws GameActionException {
        double bestForce = 100000000;
        double currentForce = 0;
        Direction bestDir = Direction.CENTER;
        MapLocation myloc = rc.getLocation();
        MapLocation nloc;
        
        nloc = myloc.add(Direction.NORTH);
        if (rc.canSenseLocation(nloc) && rc.canMove(Direction.NORTH)) {
            MapInfo mi = rc.senseMapInfo(nloc);
            if (mi.getPaint().isAlly()) {
                // currentDistance =  0.2 * nloc.distanceSquaredTo(pastTowerTarget);
                currentForce = 0;
                
                currentForce += (1000 / (nloc.distanceSquaredTo(previousPosition0) + 1));
                // currentDistance += nloc.distanceSquaredTo(previousPosition0);
                
                currentForce += (1000 / (nloc.distanceSquaredTo(previousPosition1) + 1));
                // currentDistance += nloc.distanceSquaredTo(previousPosition1);
                
                currentForce += (1000 / (nloc.distanceSquaredTo(previousPosition2) + 1));
                // currentDistance += nloc.distanceSquaredTo(previousPosition2);
                
                currentForce += (1000 / (nloc.distanceSquaredTo(previousPosition3) + 1));
                // currentDistance += nloc.distanceSquaredTo(previousPosition3);
                
                currentForce += (1000 / (nloc.distanceSquaredTo(previousPosition4) + 1));
                // currentDistance += nloc.distanceSquaredTo(previousPosition4);
                
                currentForce += (1000 / (nloc.distanceSquaredTo(previousPosition5) + 1));
                // currentDistance += nloc.distanceSquaredTo(previousPosition5);
                
                currentForce += (1000 / (nloc.distanceSquaredTo(previousPosition6) + 1));
                // currentDistance += nloc.distanceSquaredTo(previousPosition6);
                
                currentForce += (1000 / (nloc.distanceSquaredTo(previousPosition7) + 1));
                // currentDistance += nloc.distanceSquaredTo(previousPosition7);
                
                currentForce += (1000 / (nloc.distanceSquaredTo(previousPosition8) + 1));
                // currentDistance += nloc.distanceSquaredTo(previousPosition8);
                
                currentForce += (1000 / (nloc.distanceSquaredTo(previousPosition9) + 1));
                // currentDistance += nloc.distanceSquaredTo(previousPosition9);
                
                
                if (currentForce < bestForce) {
                    bestDir = Direction.NORTH;
                    bestForce = currentForce;
                }
            }
        }
        
        nloc = myloc.add(Direction.NORTHEAST);
        if (rc.canSenseLocation(nloc) && rc.canMove(Direction.NORTHEAST)) {
            MapInfo mi = rc.senseMapInfo(nloc);
            if (mi.getPaint().isAlly()) {
                // currentDistance =  0.2 * nloc.distanceSquaredTo(pastTowerTarget);
                currentForce = 0;
                
                currentForce += (1000 / (nloc.distanceSquaredTo(previousPosition0) + 1));
                // currentDistance += nloc.distanceSquaredTo(previousPosition0);
                
                currentForce += (1000 / (nloc.distanceSquaredTo(previousPosition1) + 1));
                // currentDistance += nloc.distanceSquaredTo(previousPosition1);
                
                currentForce += (1000 / (nloc.distanceSquaredTo(previousPosition2) + 1));
                // currentDistance += nloc.distanceSquaredTo(previousPosition2);
                
                currentForce += (1000 / (nloc.distanceSquaredTo(previousPosition3) + 1));
                // currentDistance += nloc.distanceSquaredTo(previousPosition3);
                
                currentForce += (1000 / (nloc.distanceSquaredTo(previousPosition4) + 1));
                // currentDistance += nloc.distanceSquaredTo(previousPosition4);
                
                currentForce += (1000 / (nloc.distanceSquaredTo(previousPosition5) + 1));
                // currentDistance += nloc.distanceSquaredTo(previousPosition5);
                
                currentForce += (1000 / (nloc.distanceSquaredTo(previousPosition6) + 1));
                // currentDistance += nloc.distanceSquaredTo(previousPosition6);
                
                currentForce += (1000 / (nloc.distanceSquaredTo(previousPosition7) + 1));
                // currentDistance += nloc.distanceSquaredTo(previousPosition7);
                
                currentForce += (1000 / (nloc.distanceSquaredTo(previousPosition8) + 1));
                // currentDistance += nloc.distanceSquaredTo(previousPosition8);
                
                currentForce += (1000 / (nloc.distanceSquaredTo(previousPosition9) + 1));
                // currentDistance += nloc.distanceSquaredTo(previousPosition9);
                
                
                if (currentForce < bestForce) {
                    bestDir = Direction.NORTHEAST;
                    bestForce = currentForce;
                }
            }
        }
        
        nloc = myloc.add(Direction.EAST);
        if (rc.canSenseLocation(nloc) && rc.canMove(Direction.EAST)) {
            MapInfo mi = rc.senseMapInfo(nloc);
            if (mi.getPaint().isAlly()) {
                // currentDistance =  0.2 * nloc.distanceSquaredTo(pastTowerTarget);
                currentForce = 0;
                
                currentForce += (1000 / (nloc.distanceSquaredTo(previousPosition0) + 1));
                // currentDistance += nloc.distanceSquaredTo(previousPosition0);
                
                currentForce += (1000 / (nloc.distanceSquaredTo(previousPosition1) + 1));
                // currentDistance += nloc.distanceSquaredTo(previousPosition1);
                
                currentForce += (1000 / (nloc.distanceSquaredTo(previousPosition2) + 1));
                // currentDistance += nloc.distanceSquaredTo(previousPosition2);
                
                currentForce += (1000 / (nloc.distanceSquaredTo(previousPosition3) + 1));
                // currentDistance += nloc.distanceSquaredTo(previousPosition3);
                
                currentForce += (1000 / (nloc.distanceSquaredTo(previousPosition4) + 1));
                // currentDistance += nloc.distanceSquaredTo(previousPosition4);
                
                currentForce += (1000 / (nloc.distanceSquaredTo(previousPosition5) + 1));
                // currentDistance += nloc.distanceSquaredTo(previousPosition5);
                
                currentForce += (1000 / (nloc.distanceSquaredTo(previousPosition6) + 1));
                // currentDistance += nloc.distanceSquaredTo(previousPosition6);
                
                currentForce += (1000 / (nloc.distanceSquaredTo(previousPosition7) + 1));
                // currentDistance += nloc.distanceSquaredTo(previousPosition7);
                
                currentForce += (1000 / (nloc.distanceSquaredTo(previousPosition8) + 1));
                // currentDistance += nloc.distanceSquaredTo(previousPosition8);
                
                currentForce += (1000 / (nloc.distanceSquaredTo(previousPosition9) + 1));
                // currentDistance += nloc.distanceSquaredTo(previousPosition9);
                
                
                if (currentForce < bestForce) {
                    bestDir = Direction.EAST;
                    bestForce = currentForce;
                }
            }
        }
        
        nloc = myloc.add(Direction.SOUTHEAST);
        if (rc.canSenseLocation(nloc) && rc.canMove(Direction.SOUTHEAST)) {
            MapInfo mi = rc.senseMapInfo(nloc);
            if (mi.getPaint().isAlly()) {
                // currentDistance =  0.2 * nloc.distanceSquaredTo(pastTowerTarget);
                currentForce = 0;
                
                currentForce += (1000 / (nloc.distanceSquaredTo(previousPosition0) + 1));
                // currentDistance += nloc.distanceSquaredTo(previousPosition0);
                
                currentForce += (1000 / (nloc.distanceSquaredTo(previousPosition1) + 1));
                // currentDistance += nloc.distanceSquaredTo(previousPosition1);
                
                currentForce += (1000 / (nloc.distanceSquaredTo(previousPosition2) + 1));
                // currentDistance += nloc.distanceSquaredTo(previousPosition2);
                
                currentForce += (1000 / (nloc.distanceSquaredTo(previousPosition3) + 1));
                // currentDistance += nloc.distanceSquaredTo(previousPosition3);
                
                currentForce += (1000 / (nloc.distanceSquaredTo(previousPosition4) + 1));
                // currentDistance += nloc.distanceSquaredTo(previousPosition4);
                
                currentForce += (1000 / (nloc.distanceSquaredTo(previousPosition5) + 1));
                // currentDistance += nloc.distanceSquaredTo(previousPosition5);
                
                currentForce += (1000 / (nloc.distanceSquaredTo(previousPosition6) + 1));
                // currentDistance += nloc.distanceSquaredTo(previousPosition6);
                
                currentForce += (1000 / (nloc.distanceSquaredTo(previousPosition7) + 1));
                // currentDistance += nloc.distanceSquaredTo(previousPosition7);
                
                currentForce += (1000 / (nloc.distanceSquaredTo(previousPosition8) + 1));
                // currentDistance += nloc.distanceSquaredTo(previousPosition8);
                
                currentForce += (1000 / (nloc.distanceSquaredTo(previousPosition9) + 1));
                // currentDistance += nloc.distanceSquaredTo(previousPosition9);
                
                
                if (currentForce < bestForce) {
                    bestDir = Direction.SOUTHEAST;
                    bestForce = currentForce;
                }
            }
        }
        
        nloc = myloc.add(Direction.SOUTH);
        if (rc.canSenseLocation(nloc) && rc.canMove(Direction.SOUTH)) {
            MapInfo mi = rc.senseMapInfo(nloc);
            if (mi.getPaint().isAlly()) {
                // currentDistance =  0.2 * nloc.distanceSquaredTo(pastTowerTarget);
                currentForce = 0;
                
                currentForce += (1000 / (nloc.distanceSquaredTo(previousPosition0) + 1));
                // currentDistance += nloc.distanceSquaredTo(previousPosition0);
                
                currentForce += (1000 / (nloc.distanceSquaredTo(previousPosition1) + 1));
                // currentDistance += nloc.distanceSquaredTo(previousPosition1);
                
                currentForce += (1000 / (nloc.distanceSquaredTo(previousPosition2) + 1));
                // currentDistance += nloc.distanceSquaredTo(previousPosition2);
                
                currentForce += (1000 / (nloc.distanceSquaredTo(previousPosition3) + 1));
                // currentDistance += nloc.distanceSquaredTo(previousPosition3);
                
                currentForce += (1000 / (nloc.distanceSquaredTo(previousPosition4) + 1));
                // currentDistance += nloc.distanceSquaredTo(previousPosition4);
                
                currentForce += (1000 / (nloc.distanceSquaredTo(previousPosition5) + 1));
                // currentDistance += nloc.distanceSquaredTo(previousPosition5);
                
                currentForce += (1000 / (nloc.distanceSquaredTo(previousPosition6) + 1));
                // currentDistance += nloc.distanceSquaredTo(previousPosition6);
                
                currentForce += (1000 / (nloc.distanceSquaredTo(previousPosition7) + 1));
                // currentDistance += nloc.distanceSquaredTo(previousPosition7);
                
                currentForce += (1000 / (nloc.distanceSquaredTo(previousPosition8) + 1));
                // currentDistance += nloc.distanceSquaredTo(previousPosition8);
                
                currentForce += (1000 / (nloc.distanceSquaredTo(previousPosition9) + 1));
                // currentDistance += nloc.distanceSquaredTo(previousPosition9);
                
                
                if (currentForce < bestForce) {
                    bestDir = Direction.SOUTH;
                    bestForce = currentForce;
                }
            }
        }
        
        nloc = myloc.add(Direction.SOUTHWEST);
        if (rc.canSenseLocation(nloc) && rc.canMove(Direction.SOUTHWEST)) {
            MapInfo mi = rc.senseMapInfo(nloc);
            if (mi.getPaint().isAlly()) {
                // currentDistance =  0.2 * nloc.distanceSquaredTo(pastTowerTarget);
                currentForce = 0;
                
                currentForce += (1000 / (nloc.distanceSquaredTo(previousPosition0) + 1));
                // currentDistance += nloc.distanceSquaredTo(previousPosition0);
                
                currentForce += (1000 / (nloc.distanceSquaredTo(previousPosition1) + 1));
                // currentDistance += nloc.distanceSquaredTo(previousPosition1);
                
                currentForce += (1000 / (nloc.distanceSquaredTo(previousPosition2) + 1));
                // currentDistance += nloc.distanceSquaredTo(previousPosition2);
                
                currentForce += (1000 / (nloc.distanceSquaredTo(previousPosition3) + 1));
                // currentDistance += nloc.distanceSquaredTo(previousPosition3);
                
                currentForce += (1000 / (nloc.distanceSquaredTo(previousPosition4) + 1));
                // currentDistance += nloc.distanceSquaredTo(previousPosition4);
                
                currentForce += (1000 / (nloc.distanceSquaredTo(previousPosition5) + 1));
                // currentDistance += nloc.distanceSquaredTo(previousPosition5);
                
                currentForce += (1000 / (nloc.distanceSquaredTo(previousPosition6) + 1));
                // currentDistance += nloc.distanceSquaredTo(previousPosition6);
                
                currentForce += (1000 / (nloc.distanceSquaredTo(previousPosition7) + 1));
                // currentDistance += nloc.distanceSquaredTo(previousPosition7);
                
                currentForce += (1000 / (nloc.distanceSquaredTo(previousPosition8) + 1));
                // currentDistance += nloc.distanceSquaredTo(previousPosition8);
                
                currentForce += (1000 / (nloc.distanceSquaredTo(previousPosition9) + 1));
                // currentDistance += nloc.distanceSquaredTo(previousPosition9);
                
                
                if (currentForce < bestForce) {
                    bestDir = Direction.SOUTHWEST;
                    bestForce = currentForce;
                }
            }
        }
        
        nloc = myloc.add(Direction.WEST);
        if (rc.canSenseLocation(nloc) && rc.canMove(Direction.WEST)) {
            MapInfo mi = rc.senseMapInfo(nloc);
            if (mi.getPaint().isAlly()) {
                // currentDistance =  0.2 * nloc.distanceSquaredTo(pastTowerTarget);
                currentForce = 0;
                
                currentForce += (1000 / (nloc.distanceSquaredTo(previousPosition0) + 1));
                // currentDistance += nloc.distanceSquaredTo(previousPosition0);
                
                currentForce += (1000 / (nloc.distanceSquaredTo(previousPosition1) + 1));
                // currentDistance += nloc.distanceSquaredTo(previousPosition1);
                
                currentForce += (1000 / (nloc.distanceSquaredTo(previousPosition2) + 1));
                // currentDistance += nloc.distanceSquaredTo(previousPosition2);
                
                currentForce += (1000 / (nloc.distanceSquaredTo(previousPosition3) + 1));
                // currentDistance += nloc.distanceSquaredTo(previousPosition3);
                
                currentForce += (1000 / (nloc.distanceSquaredTo(previousPosition4) + 1));
                // currentDistance += nloc.distanceSquaredTo(previousPosition4);
                
                currentForce += (1000 / (nloc.distanceSquaredTo(previousPosition5) + 1));
                // currentDistance += nloc.distanceSquaredTo(previousPosition5);
                
                currentForce += (1000 / (nloc.distanceSquaredTo(previousPosition6) + 1));
                // currentDistance += nloc.distanceSquaredTo(previousPosition6);
                
                currentForce += (1000 / (nloc.distanceSquaredTo(previousPosition7) + 1));
                // currentDistance += nloc.distanceSquaredTo(previousPosition7);
                
                currentForce += (1000 / (nloc.distanceSquaredTo(previousPosition8) + 1));
                // currentDistance += nloc.distanceSquaredTo(previousPosition8);
                
                currentForce += (1000 / (nloc.distanceSquaredTo(previousPosition9) + 1));
                // currentDistance += nloc.distanceSquaredTo(previousPosition9);
                
                
                if (currentForce < bestForce) {
                    bestDir = Direction.WEST;
                    bestForce = currentForce;
                }
            }
        }
        
        nloc = myloc.add(Direction.NORTHWEST);
        if (rc.canSenseLocation(nloc) && rc.canMove(Direction.NORTHWEST)) {
            MapInfo mi = rc.senseMapInfo(nloc);
            if (mi.getPaint().isAlly()) {
                // currentDistance =  0.2 * nloc.distanceSquaredTo(pastTowerTarget);
                currentForce = 0;
                
                currentForce += (1000 / (nloc.distanceSquaredTo(previousPosition0) + 1));
                // currentDistance += nloc.distanceSquaredTo(previousPosition0);
                
                currentForce += (1000 / (nloc.distanceSquaredTo(previousPosition1) + 1));
                // currentDistance += nloc.distanceSquaredTo(previousPosition1);
                
                currentForce += (1000 / (nloc.distanceSquaredTo(previousPosition2) + 1));
                // currentDistance += nloc.distanceSquaredTo(previousPosition2);
                
                currentForce += (1000 / (nloc.distanceSquaredTo(previousPosition3) + 1));
                // currentDistance += nloc.distanceSquaredTo(previousPosition3);
                
                currentForce += (1000 / (nloc.distanceSquaredTo(previousPosition4) + 1));
                // currentDistance += nloc.distanceSquaredTo(previousPosition4);
                
                currentForce += (1000 / (nloc.distanceSquaredTo(previousPosition5) + 1));
                // currentDistance += nloc.distanceSquaredTo(previousPosition5);
                
                currentForce += (1000 / (nloc.distanceSquaredTo(previousPosition6) + 1));
                // currentDistance += nloc.distanceSquaredTo(previousPosition6);
                
                currentForce += (1000 / (nloc.distanceSquaredTo(previousPosition7) + 1));
                // currentDistance += nloc.distanceSquaredTo(previousPosition7);
                
                currentForce += (1000 / (nloc.distanceSquaredTo(previousPosition8) + 1));
                // currentDistance += nloc.distanceSquaredTo(previousPosition8);
                
                currentForce += (1000 / (nloc.distanceSquaredTo(previousPosition9) + 1));
                // currentDistance += nloc.distanceSquaredTo(previousPosition9);
                
                
                if (currentForce < bestForce) {
                    bestDir = Direction.NORTHWEST;
                    bestForce = currentForce;
                }
            }
        }
        
        nloc = myloc.add(Direction.CENTER);
        if (rc.canSenseLocation(nloc) && rc.canMove(Direction.CENTER)) {
            MapInfo mi = rc.senseMapInfo(nloc);
            if (mi.getPaint().isAlly()) {
                // currentDistance =  0.2 * nloc.distanceSquaredTo(pastTowerTarget);
                currentForce = 0;
                
                currentForce += (1000 / (nloc.distanceSquaredTo(previousPosition0) + 1));
                // currentDistance += nloc.distanceSquaredTo(previousPosition0);
                
                currentForce += (1000 / (nloc.distanceSquaredTo(previousPosition1) + 1));
                // currentDistance += nloc.distanceSquaredTo(previousPosition1);
                
                currentForce += (1000 / (nloc.distanceSquaredTo(previousPosition2) + 1));
                // currentDistance += nloc.distanceSquaredTo(previousPosition2);
                
                currentForce += (1000 / (nloc.distanceSquaredTo(previousPosition3) + 1));
                // currentDistance += nloc.distanceSquaredTo(previousPosition3);
                
                currentForce += (1000 / (nloc.distanceSquaredTo(previousPosition4) + 1));
                // currentDistance += nloc.distanceSquaredTo(previousPosition4);
                
                currentForce += (1000 / (nloc.distanceSquaredTo(previousPosition5) + 1));
                // currentDistance += nloc.distanceSquaredTo(previousPosition5);
                
                currentForce += (1000 / (nloc.distanceSquaredTo(previousPosition6) + 1));
                // currentDistance += nloc.distanceSquaredTo(previousPosition6);
                
                currentForce += (1000 / (nloc.distanceSquaredTo(previousPosition7) + 1));
                // currentDistance += nloc.distanceSquaredTo(previousPosition7);
                
                currentForce += (1000 / (nloc.distanceSquaredTo(previousPosition8) + 1));
                // currentDistance += nloc.distanceSquaredTo(previousPosition8);
                
                currentForce += (1000 / (nloc.distanceSquaredTo(previousPosition9) + 1));
                // currentDistance += nloc.distanceSquaredTo(previousPosition9);
                
                
                if (currentForce < bestForce) {
                    bestDir = Direction.CENTER;
                    bestForce = currentForce;
                }
            }
        }
        

        if (rc.canMove(bestDir))
            rc.move(bestDir);
        updatePositions();
    }


    public static void reset() throws GameActionException {
        reachedHome = false;
    }
}