

package jan18_5_46;
import battlecode.common.*;

public class Mopper {
    public static RobotController rc;
    public static MapLocation buildTower = null;
    public static MapLocation myloc;
    public static int paintCapacity = UnitType.SOLDIER.paintCapacity;
    public static int myPaint;
    public static MapLocation exploreTarget;
    public static MapInfo[] near;
    public static MapLocation ruinLoc;
    public static boolean[][] resourcePat = null;
    public static boolean shouldGoHome = false;

    public static void init(RobotController rc) {
        Mopper.rc = rc;
        resourcePat = rc.getResourcePattern();
    }

    public static boolean canMop(MapInfo mi) throws GameActionException {
        return (!mi.getPaint().isAlly() && mi.getPaint() != PaintType.EMPTY);
    }

    public static void run() throws GameActionException {
        init();
        runTurn();
        postTurn();
    }

    public static void init() throws GameActionException {
        myloc = rc.getLocation();
        myPaint = rc.getPaint();
        near = rc.senseNearbyMapInfos();
        RefuelManager.setHome();
        boolean lowHealth = (myPaint <= (paintCapacity >> 2));
        if (lowHealth != shouldGoHome) {
            shouldGoHome = lowHealth;
            RefuelManager.reset();
        }
    }

    public static boolean checkNearby(MapLocation loc) throws GameActionException {
        MapLocation tmp;
        
        
        
        tmp = new MapLocation(loc.x + 2, loc.y + 2);
        if (rc.canSenseLocation(tmp)) {
            MapInfo mi = rc.senseMapInfo(tmp);
            if (mi.getPaint() != PaintType.EMPTY && !mi.getPaint().isAlly()) {
                if (rc.canAttack(tmp)) {
                    rc.attack(tmp);
                    return true;
                }
            }
        }
        
        
        
        tmp = new MapLocation(loc.x + 2, loc.y + 1);
        if (rc.canSenseLocation(tmp)) {
            MapInfo mi = rc.senseMapInfo(tmp);
            if (mi.getPaint() != PaintType.EMPTY && !mi.getPaint().isAlly()) {
                if (rc.canAttack(tmp)) {
                    rc.attack(tmp);
                    return true;
                }
            }
        }
        
        
        
        tmp = new MapLocation(loc.x + 2, loc.y + 0);
        if (rc.canSenseLocation(tmp)) {
            MapInfo mi = rc.senseMapInfo(tmp);
            if (mi.getPaint() != PaintType.EMPTY && !mi.getPaint().isAlly()) {
                if (rc.canAttack(tmp)) {
                    rc.attack(tmp);
                    return true;
                }
            }
        }
        
        
        
        tmp = new MapLocation(loc.x + 2, loc.y + -1);
        if (rc.canSenseLocation(tmp)) {
            MapInfo mi = rc.senseMapInfo(tmp);
            if (mi.getPaint() != PaintType.EMPTY && !mi.getPaint().isAlly()) {
                if (rc.canAttack(tmp)) {
                    rc.attack(tmp);
                    return true;
                }
            }
        }
        
        
        
        tmp = new MapLocation(loc.x + 2, loc.y + -2);
        if (rc.canSenseLocation(tmp)) {
            MapInfo mi = rc.senseMapInfo(tmp);
            if (mi.getPaint() != PaintType.EMPTY && !mi.getPaint().isAlly()) {
                if (rc.canAttack(tmp)) {
                    rc.attack(tmp);
                    return true;
                }
            }
        }
        
        
        
        
        
        tmp = new MapLocation(loc.x + 1, loc.y + 2);
        if (rc.canSenseLocation(tmp)) {
            MapInfo mi = rc.senseMapInfo(tmp);
            if (mi.getPaint() != PaintType.EMPTY && !mi.getPaint().isAlly()) {
                if (rc.canAttack(tmp)) {
                    rc.attack(tmp);
                    return true;
                }
            }
        }
        
        
        
        tmp = new MapLocation(loc.x + 1, loc.y + 1);
        if (rc.canSenseLocation(tmp)) {
            MapInfo mi = rc.senseMapInfo(tmp);
            if (mi.getPaint() != PaintType.EMPTY && !mi.getPaint().isAlly()) {
                if (rc.canAttack(tmp)) {
                    rc.attack(tmp);
                    return true;
                }
            }
        }
        
        
        
        tmp = new MapLocation(loc.x + 1, loc.y + 0);
        if (rc.canSenseLocation(tmp)) {
            MapInfo mi = rc.senseMapInfo(tmp);
            if (mi.getPaint() != PaintType.EMPTY && !mi.getPaint().isAlly()) {
                if (rc.canAttack(tmp)) {
                    rc.attack(tmp);
                    return true;
                }
            }
        }
        
        
        
        tmp = new MapLocation(loc.x + 1, loc.y + -1);
        if (rc.canSenseLocation(tmp)) {
            MapInfo mi = rc.senseMapInfo(tmp);
            if (mi.getPaint() != PaintType.EMPTY && !mi.getPaint().isAlly()) {
                if (rc.canAttack(tmp)) {
                    rc.attack(tmp);
                    return true;
                }
            }
        }
        
        
        
        tmp = new MapLocation(loc.x + 1, loc.y + -2);
        if (rc.canSenseLocation(tmp)) {
            MapInfo mi = rc.senseMapInfo(tmp);
            if (mi.getPaint() != PaintType.EMPTY && !mi.getPaint().isAlly()) {
                if (rc.canAttack(tmp)) {
                    rc.attack(tmp);
                    return true;
                }
            }
        }
        
        
        
        
        
        tmp = new MapLocation(loc.x + 0, loc.y + 2);
        if (rc.canSenseLocation(tmp)) {
            MapInfo mi = rc.senseMapInfo(tmp);
            if (mi.getPaint() != PaintType.EMPTY && !mi.getPaint().isAlly()) {
                if (rc.canAttack(tmp)) {
                    rc.attack(tmp);
                    return true;
                }
            }
        }
        
        
        
        tmp = new MapLocation(loc.x + 0, loc.y + 1);
        if (rc.canSenseLocation(tmp)) {
            MapInfo mi = rc.senseMapInfo(tmp);
            if (mi.getPaint() != PaintType.EMPTY && !mi.getPaint().isAlly()) {
                if (rc.canAttack(tmp)) {
                    rc.attack(tmp);
                    return true;
                }
            }
        }
        
        
        
        
        
        tmp = new MapLocation(loc.x + 0, loc.y + -1);
        if (rc.canSenseLocation(tmp)) {
            MapInfo mi = rc.senseMapInfo(tmp);
            if (mi.getPaint() != PaintType.EMPTY && !mi.getPaint().isAlly()) {
                if (rc.canAttack(tmp)) {
                    rc.attack(tmp);
                    return true;
                }
            }
        }
        
        
        
        tmp = new MapLocation(loc.x + 0, loc.y + -2);
        if (rc.canSenseLocation(tmp)) {
            MapInfo mi = rc.senseMapInfo(tmp);
            if (mi.getPaint() != PaintType.EMPTY && !mi.getPaint().isAlly()) {
                if (rc.canAttack(tmp)) {
                    rc.attack(tmp);
                    return true;
                }
            }
        }
        
        
        
        
        
        tmp = new MapLocation(loc.x + -1, loc.y + 2);
        if (rc.canSenseLocation(tmp)) {
            MapInfo mi = rc.senseMapInfo(tmp);
            if (mi.getPaint() != PaintType.EMPTY && !mi.getPaint().isAlly()) {
                if (rc.canAttack(tmp)) {
                    rc.attack(tmp);
                    return true;
                }
            }
        }
        
        
        
        tmp = new MapLocation(loc.x + -1, loc.y + 1);
        if (rc.canSenseLocation(tmp)) {
            MapInfo mi = rc.senseMapInfo(tmp);
            if (mi.getPaint() != PaintType.EMPTY && !mi.getPaint().isAlly()) {
                if (rc.canAttack(tmp)) {
                    rc.attack(tmp);
                    return true;
                }
            }
        }
        
        
        
        tmp = new MapLocation(loc.x + -1, loc.y + 0);
        if (rc.canSenseLocation(tmp)) {
            MapInfo mi = rc.senseMapInfo(tmp);
            if (mi.getPaint() != PaintType.EMPTY && !mi.getPaint().isAlly()) {
                if (rc.canAttack(tmp)) {
                    rc.attack(tmp);
                    return true;
                }
            }
        }
        
        
        
        tmp = new MapLocation(loc.x + -1, loc.y + -1);
        if (rc.canSenseLocation(tmp)) {
            MapInfo mi = rc.senseMapInfo(tmp);
            if (mi.getPaint() != PaintType.EMPTY && !mi.getPaint().isAlly()) {
                if (rc.canAttack(tmp)) {
                    rc.attack(tmp);
                    return true;
                }
            }
        }
        
        
        
        tmp = new MapLocation(loc.x + -1, loc.y + -2);
        if (rc.canSenseLocation(tmp)) {
            MapInfo mi = rc.senseMapInfo(tmp);
            if (mi.getPaint() != PaintType.EMPTY && !mi.getPaint().isAlly()) {
                if (rc.canAttack(tmp)) {
                    rc.attack(tmp);
                    return true;
                }
            }
        }
        
        
        
        
        
        tmp = new MapLocation(loc.x + -2, loc.y + 2);
        if (rc.canSenseLocation(tmp)) {
            MapInfo mi = rc.senseMapInfo(tmp);
            if (mi.getPaint() != PaintType.EMPTY && !mi.getPaint().isAlly()) {
                if (rc.canAttack(tmp)) {
                    rc.attack(tmp);
                    return true;
                }
            }
        }
        
        
        
        tmp = new MapLocation(loc.x + -2, loc.y + 1);
        if (rc.canSenseLocation(tmp)) {
            MapInfo mi = rc.senseMapInfo(tmp);
            if (mi.getPaint() != PaintType.EMPTY && !mi.getPaint().isAlly()) {
                if (rc.canAttack(tmp)) {
                    rc.attack(tmp);
                    return true;
                }
            }
        }
        
        
        
        tmp = new MapLocation(loc.x + -2, loc.y + 0);
        if (rc.canSenseLocation(tmp)) {
            MapInfo mi = rc.senseMapInfo(tmp);
            if (mi.getPaint() != PaintType.EMPTY && !mi.getPaint().isAlly()) {
                if (rc.canAttack(tmp)) {
                    rc.attack(tmp);
                    return true;
                }
            }
        }
        
        
        
        tmp = new MapLocation(loc.x + -2, loc.y + -1);
        if (rc.canSenseLocation(tmp)) {
            MapInfo mi = rc.senseMapInfo(tmp);
            if (mi.getPaint() != PaintType.EMPTY && !mi.getPaint().isAlly()) {
                if (rc.canAttack(tmp)) {
                    rc.attack(tmp);
                    return true;
                }
            }
        }
        
        
        
        tmp = new MapLocation(loc.x + -2, loc.y + -2);
        if (rc.canSenseLocation(tmp)) {
            MapInfo mi = rc.senseMapInfo(tmp);
            if (mi.getPaint() != PaintType.EMPTY && !mi.getPaint().isAlly()) {
                if (rc.canAttack(tmp)) {
                    rc.attack(tmp);
                    return true;
                }
            }
        }
        
        
        
        return false;
    }

    public static void helpPattern(MapInfo[] near) throws GameActionException {
        for (int i = near.length; --i >= 0;) {
            if (near[i].getMark() == PaintType.ALLY_PRIMARY) {
                if (checkNearby(near[i].getMapLocation())) return;
            }
        }
    }

    public static void runTurn() throws GameActionException {
        if (shouldGoHome) { 
            rc.setIndicatorString("Refueling");
            RefuelManager.refuel();
            return;
        }
        else if (Attack.shouldMopperMicro()) {
            rc.setIndicatorString("Mopping");
            Attack.mopperAttackMicro();
            return;
        }
        else if (rc.getNumberTowers() < 25){
            MapLocation buildTower = TowerBuild.getRuin(near);
            if (buildTower != null) {
                TowerBuild.makeTower(buildTower);
            }
        }

        helpPattern(near);
        
        Explore.exploreOnPaint(near);
    }

    public static void postTurn() throws GameActionException {
        MapLocation nloc;
        MapInfo mi;
        
        nloc = myloc.add(Direction.NORTH);
        mi = rc.senseMapInfo(nloc);
        if (rc.canAttack(nloc) && canMop(mi)) rc.attack(nloc);
        
        nloc = myloc.add(Direction.NORTHEAST);
        mi = rc.senseMapInfo(nloc);
        if (rc.canAttack(nloc) && canMop(mi)) rc.attack(nloc);
        
        nloc = myloc.add(Direction.EAST);
        mi = rc.senseMapInfo(nloc);
        if (rc.canAttack(nloc) && canMop(mi)) rc.attack(nloc);
        
        nloc = myloc.add(Direction.SOUTHEAST);
        mi = rc.senseMapInfo(nloc);
        if (rc.canAttack(nloc) && canMop(mi)) rc.attack(nloc);
        
        nloc = myloc.add(Direction.SOUTH);
        mi = rc.senseMapInfo(nloc);
        if (rc.canAttack(nloc) && canMop(mi)) rc.attack(nloc);
        
        nloc = myloc.add(Direction.SOUTHWEST);
        mi = rc.senseMapInfo(nloc);
        if (rc.canAttack(nloc) && canMop(mi)) rc.attack(nloc);
        
        nloc = myloc.add(Direction.WEST);
        mi = rc.senseMapInfo(nloc);
        if (rc.canAttack(nloc) && canMop(mi)) rc.attack(nloc);
        
        nloc = myloc.add(Direction.NORTHWEST);
        mi = rc.senseMapInfo(nloc);
        if (rc.canAttack(nloc) && canMop(mi)) rc.attack(nloc);
        
        nloc = myloc.add(Direction.CENTER);
        mi = rc.senseMapInfo(nloc);
        if (rc.canAttack(nloc) && canMop(mi)) rc.attack(nloc);
        
    }
}