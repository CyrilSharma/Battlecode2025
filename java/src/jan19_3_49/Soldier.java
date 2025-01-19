

package jan19_3_49;
import battlecode.common.*;
import java.util.ArrayList;
import java.util.Collections;

public class Soldier {
    public static RobotController rc;
    public static boolean homeHasPaint = false;
    public static MapLocation buildTower = null;
    public static MapLocation myloc;
    public static int paintCapacity = UnitType.SOLDIER.paintCapacity;
    public static int myPaint;
    public static MapLocation exploreTarget;
    public static MapInfo[] near;
    public static MapLocation ruinLoc;
    public static MapLocation markedResource = null;
    public static boolean[][] resourcePat = null;
    public static boolean shouldGoHome = false;
    public static boolean moved = false;
    public static MapLocation returnLoc = null;

    public static void init(RobotController rc) {
        Soldier.rc = rc;
        resourcePat = rc.getResourcePattern();
    }

    public static boolean shouldUseSecond(MapLocation loc, MapLocation center) throws GameActionException {
        return resourcePat[2 + (loc.x - center.x)][2 + (loc.y - center.y)];
    }

    public static boolean okToTile(MapLocation m) throws GameActionException {
        if (rc.getNumberTowers() == 25) return true;
        if (rc.canSenseLocation(m)) {
            MapInfo mc = rc.senseMapInfo(m);
            if (mc.getPaint() != PaintType.EMPTY) return false;
        }
        for (int i = 3; --i >= -2; ){
            for (int j = 3; --j >= -2; ){
                if (i == 0 && j == 0) continue;
                MapLocation tmp = new MapLocation(m.x + i, m.y + j);
                if (rc.canSenseLocation(tmp)) {
                    MapInfo mi = rc.senseMapInfo(tmp);
                    if (mi.hasRuin()) {
                        RobotInfo r = rc.senseRobotAtLocation(tmp);
                        if (r == null) return false;
                    }
                }
            }
        }
        return true;
    }

    public static void checkMoneyPatterns() throws GameActionException {
        MapLocation tmp;
        
        
        
        tmp = new MapLocation(myloc.x + 2, myloc.y + 2);
        if (rc.canSenseLocation(tmp)) {
            MapInfo mi = rc.senseMapInfo(tmp);
            if (mi.getMark() == PaintType.ALLY_PRIMARY) {
                if (rc.canCompleteResourcePattern(tmp)) {
                    rc.completeResourcePattern(tmp);
                    return;
                }
            }
        }
        
        
        
        tmp = new MapLocation(myloc.x + 2, myloc.y + 1);
        if (rc.canSenseLocation(tmp)) {
            MapInfo mi = rc.senseMapInfo(tmp);
            if (mi.getMark() == PaintType.ALLY_PRIMARY) {
                if (rc.canCompleteResourcePattern(tmp)) {
                    rc.completeResourcePattern(tmp);
                    return;
                }
            }
        }
        
        
        
        tmp = new MapLocation(myloc.x + 2, myloc.y + 0);
        if (rc.canSenseLocation(tmp)) {
            MapInfo mi = rc.senseMapInfo(tmp);
            if (mi.getMark() == PaintType.ALLY_PRIMARY) {
                if (rc.canCompleteResourcePattern(tmp)) {
                    rc.completeResourcePattern(tmp);
                    return;
                }
            }
        }
        
        
        
        tmp = new MapLocation(myloc.x + 2, myloc.y + -1);
        if (rc.canSenseLocation(tmp)) {
            MapInfo mi = rc.senseMapInfo(tmp);
            if (mi.getMark() == PaintType.ALLY_PRIMARY) {
                if (rc.canCompleteResourcePattern(tmp)) {
                    rc.completeResourcePattern(tmp);
                    return;
                }
            }
        }
        
        
        
        tmp = new MapLocation(myloc.x + 2, myloc.y + -2);
        if (rc.canSenseLocation(tmp)) {
            MapInfo mi = rc.senseMapInfo(tmp);
            if (mi.getMark() == PaintType.ALLY_PRIMARY) {
                if (rc.canCompleteResourcePattern(tmp)) {
                    rc.completeResourcePattern(tmp);
                    return;
                }
            }
        }
        
        
        
        
        
        tmp = new MapLocation(myloc.x + 1, myloc.y + 2);
        if (rc.canSenseLocation(tmp)) {
            MapInfo mi = rc.senseMapInfo(tmp);
            if (mi.getMark() == PaintType.ALLY_PRIMARY) {
                if (rc.canCompleteResourcePattern(tmp)) {
                    rc.completeResourcePattern(tmp);
                    return;
                }
            }
        }
        
        
        
        tmp = new MapLocation(myloc.x + 1, myloc.y + 1);
        if (rc.canSenseLocation(tmp)) {
            MapInfo mi = rc.senseMapInfo(tmp);
            if (mi.getMark() == PaintType.ALLY_PRIMARY) {
                if (rc.canCompleteResourcePattern(tmp)) {
                    rc.completeResourcePattern(tmp);
                    return;
                }
            }
        }
        
        
        
        tmp = new MapLocation(myloc.x + 1, myloc.y + 0);
        if (rc.canSenseLocation(tmp)) {
            MapInfo mi = rc.senseMapInfo(tmp);
            if (mi.getMark() == PaintType.ALLY_PRIMARY) {
                if (rc.canCompleteResourcePattern(tmp)) {
                    rc.completeResourcePattern(tmp);
                    return;
                }
            }
        }
        
        
        
        tmp = new MapLocation(myloc.x + 1, myloc.y + -1);
        if (rc.canSenseLocation(tmp)) {
            MapInfo mi = rc.senseMapInfo(tmp);
            if (mi.getMark() == PaintType.ALLY_PRIMARY) {
                if (rc.canCompleteResourcePattern(tmp)) {
                    rc.completeResourcePattern(tmp);
                    return;
                }
            }
        }
        
        
        
        tmp = new MapLocation(myloc.x + 1, myloc.y + -2);
        if (rc.canSenseLocation(tmp)) {
            MapInfo mi = rc.senseMapInfo(tmp);
            if (mi.getMark() == PaintType.ALLY_PRIMARY) {
                if (rc.canCompleteResourcePattern(tmp)) {
                    rc.completeResourcePattern(tmp);
                    return;
                }
            }
        }
        
        
        
        
        
        tmp = new MapLocation(myloc.x + 0, myloc.y + 2);
        if (rc.canSenseLocation(tmp)) {
            MapInfo mi = rc.senseMapInfo(tmp);
            if (mi.getMark() == PaintType.ALLY_PRIMARY) {
                if (rc.canCompleteResourcePattern(tmp)) {
                    rc.completeResourcePattern(tmp);
                    return;
                }
            }
        }
        
        
        
        tmp = new MapLocation(myloc.x + 0, myloc.y + 1);
        if (rc.canSenseLocation(tmp)) {
            MapInfo mi = rc.senseMapInfo(tmp);
            if (mi.getMark() == PaintType.ALLY_PRIMARY) {
                if (rc.canCompleteResourcePattern(tmp)) {
                    rc.completeResourcePattern(tmp);
                    return;
                }
            }
        }
        
        
        
        
        
        tmp = new MapLocation(myloc.x + 0, myloc.y + -1);
        if (rc.canSenseLocation(tmp)) {
            MapInfo mi = rc.senseMapInfo(tmp);
            if (mi.getMark() == PaintType.ALLY_PRIMARY) {
                if (rc.canCompleteResourcePattern(tmp)) {
                    rc.completeResourcePattern(tmp);
                    return;
                }
            }
        }
        
        
        
        tmp = new MapLocation(myloc.x + 0, myloc.y + -2);
        if (rc.canSenseLocation(tmp)) {
            MapInfo mi = rc.senseMapInfo(tmp);
            if (mi.getMark() == PaintType.ALLY_PRIMARY) {
                if (rc.canCompleteResourcePattern(tmp)) {
                    rc.completeResourcePattern(tmp);
                    return;
                }
            }
        }
        
        
        
        
        
        tmp = new MapLocation(myloc.x + -1, myloc.y + 2);
        if (rc.canSenseLocation(tmp)) {
            MapInfo mi = rc.senseMapInfo(tmp);
            if (mi.getMark() == PaintType.ALLY_PRIMARY) {
                if (rc.canCompleteResourcePattern(tmp)) {
                    rc.completeResourcePattern(tmp);
                    return;
                }
            }
        }
        
        
        
        tmp = new MapLocation(myloc.x + -1, myloc.y + 1);
        if (rc.canSenseLocation(tmp)) {
            MapInfo mi = rc.senseMapInfo(tmp);
            if (mi.getMark() == PaintType.ALLY_PRIMARY) {
                if (rc.canCompleteResourcePattern(tmp)) {
                    rc.completeResourcePattern(tmp);
                    return;
                }
            }
        }
        
        
        
        tmp = new MapLocation(myloc.x + -1, myloc.y + 0);
        if (rc.canSenseLocation(tmp)) {
            MapInfo mi = rc.senseMapInfo(tmp);
            if (mi.getMark() == PaintType.ALLY_PRIMARY) {
                if (rc.canCompleteResourcePattern(tmp)) {
                    rc.completeResourcePattern(tmp);
                    return;
                }
            }
        }
        
        
        
        tmp = new MapLocation(myloc.x + -1, myloc.y + -1);
        if (rc.canSenseLocation(tmp)) {
            MapInfo mi = rc.senseMapInfo(tmp);
            if (mi.getMark() == PaintType.ALLY_PRIMARY) {
                if (rc.canCompleteResourcePattern(tmp)) {
                    rc.completeResourcePattern(tmp);
                    return;
                }
            }
        }
        
        
        
        tmp = new MapLocation(myloc.x + -1, myloc.y + -2);
        if (rc.canSenseLocation(tmp)) {
            MapInfo mi = rc.senseMapInfo(tmp);
            if (mi.getMark() == PaintType.ALLY_PRIMARY) {
                if (rc.canCompleteResourcePattern(tmp)) {
                    rc.completeResourcePattern(tmp);
                    return;
                }
            }
        }
        
        
        
        
        
        tmp = new MapLocation(myloc.x + -2, myloc.y + 2);
        if (rc.canSenseLocation(tmp)) {
            MapInfo mi = rc.senseMapInfo(tmp);
            if (mi.getMark() == PaintType.ALLY_PRIMARY) {
                if (rc.canCompleteResourcePattern(tmp)) {
                    rc.completeResourcePattern(tmp);
                    return;
                }
            }
        }
        
        
        
        tmp = new MapLocation(myloc.x + -2, myloc.y + 1);
        if (rc.canSenseLocation(tmp)) {
            MapInfo mi = rc.senseMapInfo(tmp);
            if (mi.getMark() == PaintType.ALLY_PRIMARY) {
                if (rc.canCompleteResourcePattern(tmp)) {
                    rc.completeResourcePattern(tmp);
                    return;
                }
            }
        }
        
        
        
        tmp = new MapLocation(myloc.x + -2, myloc.y + 0);
        if (rc.canSenseLocation(tmp)) {
            MapInfo mi = rc.senseMapInfo(tmp);
            if (mi.getMark() == PaintType.ALLY_PRIMARY) {
                if (rc.canCompleteResourcePattern(tmp)) {
                    rc.completeResourcePattern(tmp);
                    return;
                }
            }
        }
        
        
        
        tmp = new MapLocation(myloc.x + -2, myloc.y + -1);
        if (rc.canSenseLocation(tmp)) {
            MapInfo mi = rc.senseMapInfo(tmp);
            if (mi.getMark() == PaintType.ALLY_PRIMARY) {
                if (rc.canCompleteResourcePattern(tmp)) {
                    rc.completeResourcePattern(tmp);
                    return;
                }
            }
        }
        
        
        
        tmp = new MapLocation(myloc.x + -2, myloc.y + -2);
        if (rc.canSenseLocation(tmp)) {
            MapInfo mi = rc.senseMapInfo(tmp);
            if (mi.getMark() == PaintType.ALLY_PRIMARY) {
                if (rc.canCompleteResourcePattern(tmp)) {
                    rc.completeResourcePattern(tmp);
                    return;
                }
            }
        }
        
        
        
    }

    public static boolean canChangeColor(MapInfo mi) throws GameActionException {
        return (mi.getPaint().isAlly() || mi.getPaint() == PaintType.EMPTY);
    }

    public static boolean canChangeColor(MapLocation m) throws GameActionException {
        if (!rc.canSenseLocation(m)) return false;
        MapInfo mi = rc.senseMapInfo(m);
        return canChangeColor(mi);
    }

    public static boolean visited(MapLocation m) throws GameActionException {
       switch (m.y) {
            case 0 -> {
                return ((TileLoader.visited0 >> m.x) & 1) == 1;
            }
            case 1 -> {
                return ((TileLoader.visited1 >> m.x) & 1) == 1;
            }
            case 2 -> {
                return ((TileLoader.visited2 >> m.x) & 1) == 1;
            }
            case 3 -> {
                return ((TileLoader.visited3 >> m.x) & 1) == 1;
            }
            case 4 -> {
                return ((TileLoader.visited4 >> m.x) & 1) == 1;
            }
            case 5 -> {
                return ((TileLoader.visited5 >> m.x) & 1) == 1;
            }
            case 6 -> {
                return ((TileLoader.visited6 >> m.x) & 1) == 1;
            }
            case 7 -> {
                return ((TileLoader.visited7 >> m.x) & 1) == 1;
            }
            case 8 -> {
                return ((TileLoader.visited8 >> m.x) & 1) == 1;
            }
            case 9 -> {
                return ((TileLoader.visited9 >> m.x) & 1) == 1;
            }
            case 10 -> {
                return ((TileLoader.visited10 >> m.x) & 1) == 1;
            }
            case 11 -> {
                return ((TileLoader.visited11 >> m.x) & 1) == 1;
            }
            case 12 -> {
                return ((TileLoader.visited12 >> m.x) & 1) == 1;
            }
            case 13 -> {
                return ((TileLoader.visited13 >> m.x) & 1) == 1;
            }
            case 14 -> {
                return ((TileLoader.visited14 >> m.x) & 1) == 1;
            }
            case 15 -> {
                return ((TileLoader.visited15 >> m.x) & 1) == 1;
            }
            case 16 -> {
                return ((TileLoader.visited16 >> m.x) & 1) == 1;
            }
            case 17 -> {
                return ((TileLoader.visited17 >> m.x) & 1) == 1;
            }
            case 18 -> {
                return ((TileLoader.visited18 >> m.x) & 1) == 1;
            }
            case 19 -> {
                return ((TileLoader.visited19 >> m.x) & 1) == 1;
            }
            case 20 -> {
                return ((TileLoader.visited20 >> m.x) & 1) == 1;
            }
            case 21 -> {
                return ((TileLoader.visited21 >> m.x) & 1) == 1;
            }
            case 22 -> {
                return ((TileLoader.visited22 >> m.x) & 1) == 1;
            }
            case 23 -> {
                return ((TileLoader.visited23 >> m.x) & 1) == 1;
            }
            case 24 -> {
                return ((TileLoader.visited24 >> m.x) & 1) == 1;
            }
            case 25 -> {
                return ((TileLoader.visited25 >> m.x) & 1) == 1;
            }
            case 26 -> {
                return ((TileLoader.visited26 >> m.x) & 1) == 1;
            }
            case 27 -> {
                return ((TileLoader.visited27 >> m.x) & 1) == 1;
            }
            case 28 -> {
                return ((TileLoader.visited28 >> m.x) & 1) == 1;
            }
            case 29 -> {
                return ((TileLoader.visited29 >> m.x) & 1) == 1;
            }
            case 30 -> {
                return ((TileLoader.visited30 >> m.x) & 1) == 1;
            }
            case 31 -> {
                return ((TileLoader.visited31 >> m.x) & 1) == 1;
            }
            case 32 -> {
                return ((TileLoader.visited32 >> m.x) & 1) == 1;
            }
            case 33 -> {
                return ((TileLoader.visited33 >> m.x) & 1) == 1;
            }
            case 34 -> {
                return ((TileLoader.visited34 >> m.x) & 1) == 1;
            }
            case 35 -> {
                return ((TileLoader.visited35 >> m.x) & 1) == 1;
            }
            case 36 -> {
                return ((TileLoader.visited36 >> m.x) & 1) == 1;
            }
            case 37 -> {
                return ((TileLoader.visited37 >> m.x) & 1) == 1;
            }
            case 38 -> {
                return ((TileLoader.visited38 >> m.x) & 1) == 1;
            }
            case 39 -> {
                return ((TileLoader.visited39 >> m.x) & 1) == 1;
            }
            case 40 -> {
                return ((TileLoader.visited40 >> m.x) & 1) == 1;
            }
            case 41 -> {
                return ((TileLoader.visited41 >> m.x) & 1) == 1;
            }
            case 42 -> {
                return ((TileLoader.visited42 >> m.x) & 1) == 1;
            }
            case 43 -> {
                return ((TileLoader.visited43 >> m.x) & 1) == 1;
            }
            case 44 -> {
                return ((TileLoader.visited44 >> m.x) & 1) == 1;
            }
            case 45 -> {
                return ((TileLoader.visited45 >> m.x) & 1) == 1;
            }
            case 46 -> {
                return ((TileLoader.visited46 >> m.x) & 1) == 1;
            }
            case 47 -> {
                return ((TileLoader.visited47 >> m.x) & 1) == 1;
            }
            case 48 -> {
                return ((TileLoader.visited48 >> m.x) & 1) == 1;
            }
            case 49 -> {
                return ((TileLoader.visited49 >> m.x) & 1) == 1;
            }
            case 50 -> {
                return ((TileLoader.visited50 >> m.x) & 1) == 1;
            }
            case 51 -> {
                return ((TileLoader.visited51 >> m.x) & 1) == 1;
            }
            case 52 -> {
                return ((TileLoader.visited52 >> m.x) & 1) == 1;
            }
            case 53 -> {
                return ((TileLoader.visited53 >> m.x) & 1) == 1;
            }
            case 54 -> {
                return ((TileLoader.visited54 >> m.x) & 1) == 1;
            }
            case 55 -> {
                return ((TileLoader.visited55 >> m.x) & 1) == 1;
            }
            case 56 -> {
                return ((TileLoader.visited56 >> m.x) & 1) == 1;
            }
            case 57 -> {
                return ((TileLoader.visited57 >> m.x) & 1) == 1;
            }
            case 58 -> {
                return ((TileLoader.visited58 >> m.x) & 1) == 1;
            }
            case 59 -> {
                return ((TileLoader.visited59 >> m.x) & 1) == 1;
            }
            } 
        return false;
    }

    public static boolean isOk(MapLocation p, MapLocation q) throws GameActionException {
        MapLocation tmp;
        
        
        tmp = new MapLocation(q.x + 2, q.y + 2);
        if (rc.canSenseLocation(tmp)) {
            if (tmp.distanceSquaredTo(p) <= 8) {
                if (shouldUseSecond(tmp, p) != shouldUseSecond(tmp, q)) return false;
            }
        }
        
        tmp = new MapLocation(q.x + 2, q.y + 1);
        if (rc.canSenseLocation(tmp)) {
            if (tmp.distanceSquaredTo(p) <= 8) {
                if (shouldUseSecond(tmp, p) != shouldUseSecond(tmp, q)) return false;
            }
        }
        
        tmp = new MapLocation(q.x + 2, q.y + 0);
        if (rc.canSenseLocation(tmp)) {
            if (tmp.distanceSquaredTo(p) <= 8) {
                if (shouldUseSecond(tmp, p) != shouldUseSecond(tmp, q)) return false;
            }
        }
        
        tmp = new MapLocation(q.x + 2, q.y + -1);
        if (rc.canSenseLocation(tmp)) {
            if (tmp.distanceSquaredTo(p) <= 8) {
                if (shouldUseSecond(tmp, p) != shouldUseSecond(tmp, q)) return false;
            }
        }
        
        tmp = new MapLocation(q.x + 2, q.y + -2);
        if (rc.canSenseLocation(tmp)) {
            if (tmp.distanceSquaredTo(p) <= 8) {
                if (shouldUseSecond(tmp, p) != shouldUseSecond(tmp, q)) return false;
            }
        }
        
        
        
        tmp = new MapLocation(q.x + 1, q.y + 2);
        if (rc.canSenseLocation(tmp)) {
            if (tmp.distanceSquaredTo(p) <= 8) {
                if (shouldUseSecond(tmp, p) != shouldUseSecond(tmp, q)) return false;
            }
        }
        
        tmp = new MapLocation(q.x + 1, q.y + 1);
        if (rc.canSenseLocation(tmp)) {
            if (tmp.distanceSquaredTo(p) <= 8) {
                if (shouldUseSecond(tmp, p) != shouldUseSecond(tmp, q)) return false;
            }
        }
        
        tmp = new MapLocation(q.x + 1, q.y + 0);
        if (rc.canSenseLocation(tmp)) {
            if (tmp.distanceSquaredTo(p) <= 8) {
                if (shouldUseSecond(tmp, p) != shouldUseSecond(tmp, q)) return false;
            }
        }
        
        tmp = new MapLocation(q.x + 1, q.y + -1);
        if (rc.canSenseLocation(tmp)) {
            if (tmp.distanceSquaredTo(p) <= 8) {
                if (shouldUseSecond(tmp, p) != shouldUseSecond(tmp, q)) return false;
            }
        }
        
        tmp = new MapLocation(q.x + 1, q.y + -2);
        if (rc.canSenseLocation(tmp)) {
            if (tmp.distanceSquaredTo(p) <= 8) {
                if (shouldUseSecond(tmp, p) != shouldUseSecond(tmp, q)) return false;
            }
        }
        
        
        
        tmp = new MapLocation(q.x + 0, q.y + 2);
        if (rc.canSenseLocation(tmp)) {
            if (tmp.distanceSquaredTo(p) <= 8) {
                if (shouldUseSecond(tmp, p) != shouldUseSecond(tmp, q)) return false;
            }
        }
        
        tmp = new MapLocation(q.x + 0, q.y + 1);
        if (rc.canSenseLocation(tmp)) {
            if (tmp.distanceSquaredTo(p) <= 8) {
                if (shouldUseSecond(tmp, p) != shouldUseSecond(tmp, q)) return false;
            }
        }
        
        tmp = new MapLocation(q.x + 0, q.y + 0);
        if (rc.canSenseLocation(tmp)) {
            if (tmp.distanceSquaredTo(p) <= 8) {
                if (shouldUseSecond(tmp, p) != shouldUseSecond(tmp, q)) return false;
            }
        }
        
        tmp = new MapLocation(q.x + 0, q.y + -1);
        if (rc.canSenseLocation(tmp)) {
            if (tmp.distanceSquaredTo(p) <= 8) {
                if (shouldUseSecond(tmp, p) != shouldUseSecond(tmp, q)) return false;
            }
        }
        
        tmp = new MapLocation(q.x + 0, q.y + -2);
        if (rc.canSenseLocation(tmp)) {
            if (tmp.distanceSquaredTo(p) <= 8) {
                if (shouldUseSecond(tmp, p) != shouldUseSecond(tmp, q)) return false;
            }
        }
        
        
        
        tmp = new MapLocation(q.x + -1, q.y + 2);
        if (rc.canSenseLocation(tmp)) {
            if (tmp.distanceSquaredTo(p) <= 8) {
                if (shouldUseSecond(tmp, p) != shouldUseSecond(tmp, q)) return false;
            }
        }
        
        tmp = new MapLocation(q.x + -1, q.y + 1);
        if (rc.canSenseLocation(tmp)) {
            if (tmp.distanceSquaredTo(p) <= 8) {
                if (shouldUseSecond(tmp, p) != shouldUseSecond(tmp, q)) return false;
            }
        }
        
        tmp = new MapLocation(q.x + -1, q.y + 0);
        if (rc.canSenseLocation(tmp)) {
            if (tmp.distanceSquaredTo(p) <= 8) {
                if (shouldUseSecond(tmp, p) != shouldUseSecond(tmp, q)) return false;
            }
        }
        
        tmp = new MapLocation(q.x + -1, q.y + -1);
        if (rc.canSenseLocation(tmp)) {
            if (tmp.distanceSquaredTo(p) <= 8) {
                if (shouldUseSecond(tmp, p) != shouldUseSecond(tmp, q)) return false;
            }
        }
        
        tmp = new MapLocation(q.x + -1, q.y + -2);
        if (rc.canSenseLocation(tmp)) {
            if (tmp.distanceSquaredTo(p) <= 8) {
                if (shouldUseSecond(tmp, p) != shouldUseSecond(tmp, q)) return false;
            }
        }
        
        
        
        tmp = new MapLocation(q.x + -2, q.y + 2);
        if (rc.canSenseLocation(tmp)) {
            if (tmp.distanceSquaredTo(p) <= 8) {
                if (shouldUseSecond(tmp, p) != shouldUseSecond(tmp, q)) return false;
            }
        }
        
        tmp = new MapLocation(q.x + -2, q.y + 1);
        if (rc.canSenseLocation(tmp)) {
            if (tmp.distanceSquaredTo(p) <= 8) {
                if (shouldUseSecond(tmp, p) != shouldUseSecond(tmp, q)) return false;
            }
        }
        
        tmp = new MapLocation(q.x + -2, q.y + 0);
        if (rc.canSenseLocation(tmp)) {
            if (tmp.distanceSquaredTo(p) <= 8) {
                if (shouldUseSecond(tmp, p) != shouldUseSecond(tmp, q)) return false;
            }
        }
        
        tmp = new MapLocation(q.x + -2, q.y + -1);
        if (rc.canSenseLocation(tmp)) {
            if (tmp.distanceSquaredTo(p) <= 8) {
                if (shouldUseSecond(tmp, p) != shouldUseSecond(tmp, q)) return false;
            }
        }
        
        tmp = new MapLocation(q.x + -2, q.y + -2);
        if (rc.canSenseLocation(tmp)) {
            if (tmp.distanceSquaredTo(p) <= 8) {
                if (shouldUseSecond(tmp, p) != shouldUseSecond(tmp, q)) return false;
            }
        }
        
        
        return true;
    }

    public static void moneyPattern() throws GameActionException {
        if (markedResource != null) return;
        if (!(rc.getNumberTowers() > 2 || rc.getRoundNum() > 100)) return;
        //this just checks that nothing is like directly in the way
        for (int i = 3; --i >= -2; ){
            for (int j = 3; --j >= -2; ){
                MapLocation tmp = new MapLocation(myloc.x + i, myloc.y + j);
                if (rc.canSenseLocation(tmp)) {
                    MapInfo mi = rc.senseMapInfo(tmp);
                    if (!mi.isPassable()) {
                        return;
                    }
                    if (!mi.getPaint().isAlly() && mi.getPaint() != PaintType.EMPTY) return;
                    if (mi.isResourcePatternCenter()) return;
                    RobotInfo r = rc.senseRobotAtLocation(tmp);
                    if (r != null && Globals.isTower(r.getType())) {
                        return;
                    }
                }
                else {
                    return;
                }
            }
        }

        // ok there is probably better way to do this with bitmasks or something but ill just do this for now...
        for (int i = near.length; --i >= 0; ) {
            if (near[i].getMark() == PaintType.ALLY_PRIMARY) {
                if (!isOk(near[i].getMapLocation(), myloc)) return;
            }
        }

        if (rc.canMark(myloc)) {
            rc.mark(myloc, false);
            markedResource = myloc;
        }
    }

    public static void makeResourcePatch() throws GameActionException {
        //TODO: if we see a conflict, stop building and mark with a 2 (can add later)
        Pathing.pathTo(markedResource);
        moved = true;
        MapLocation goal = null;
        int bestDist = 1000000000;
        boolean secondCol = false;
        for (int i = 3; --i >= -2; ){
            for (int j = 3; --j >= -2; ){
                MapLocation tmp = new MapLocation(markedResource.x + i, markedResource.y + j);
                if (rc.canSenseLocation(tmp)) {
                    MapInfo mi = rc.senseMapInfo(tmp);
                    if (canChangeColor(mi)) {
                        boolean b = shouldUseSecond(tmp, markedResource);
                        if (mi.getPaint().isAlly()) {
                            if (b == (mi.getPaint() == PaintType.ALLY_SECONDARY)) {
                                continue;
                            }
                        }
                        int d = rc.getLocation().distanceSquaredTo(tmp);
                        if (d < bestDist) {
                            bestDist = d;
                            goal = tmp;
                            secondCol = b;
                        }
                    }
                }
            }
        }
        if (goal != null) {
            if (rc.canAttack(goal)) {
                rc.attack(goal, secondCol);
            }
            if (rc.canCompleteResourcePattern(markedResource)) {
                rc.completeResourcePattern(markedResource);
                markedResource = null;
            }
            MapInfo mi = rc.senseMapInfo(myloc);
            if (mi.isResourcePatternCenter()) {
                markedResource = null;
            }
        }
        else {
            if (rc.canCompleteResourcePattern(markedResource)) {
                rc.completeResourcePattern(markedResource);
            }
            markedResource = null;
        }
    }

    public static void run() throws GameActionException {
        initTurn();
        runTurn();
        postTurn();
    }

    public static void initTurn() throws GameActionException {
        near = rc.senseNearbyMapInfos();
        myloc = rc.getLocation();
        myPaint = rc.getPaint();
        moved = false;

        RefuelManager.setHome();
        boolean lowHealth = (myPaint <= (paintCapacity >> 2));
        if (lowHealth != shouldGoHome) {
            shouldGoHome = lowHealth;
            if (buildTower != null && shouldGoHome) returnLoc = buildTower;
            RefuelManager.reset();
        }
    }


    public static boolean getGoodColor(MapLocation m) throws GameActionException {
        MapLocation tmp;
        
        
        tmp = new MapLocation(m.x + 2, m.y + 2);
        if (rc.canSenseLocation(tmp)) {
            MapInfo mi = rc.senseMapInfo(tmp);
            if (mi.getMark() == PaintType.ALLY_PRIMARY) {
                return Soldier.shouldUseSecond(m, tmp);
            }
        }
        
        tmp = new MapLocation(m.x + 2, m.y + 1);
        if (rc.canSenseLocation(tmp)) {
            MapInfo mi = rc.senseMapInfo(tmp);
            if (mi.getMark() == PaintType.ALLY_PRIMARY) {
                return Soldier.shouldUseSecond(m, tmp);
            }
        }
        
        tmp = new MapLocation(m.x + 2, m.y + 0);
        if (rc.canSenseLocation(tmp)) {
            MapInfo mi = rc.senseMapInfo(tmp);
            if (mi.getMark() == PaintType.ALLY_PRIMARY) {
                return Soldier.shouldUseSecond(m, tmp);
            }
        }
        
        tmp = new MapLocation(m.x + 2, m.y + -1);
        if (rc.canSenseLocation(tmp)) {
            MapInfo mi = rc.senseMapInfo(tmp);
            if (mi.getMark() == PaintType.ALLY_PRIMARY) {
                return Soldier.shouldUseSecond(m, tmp);
            }
        }
        
        tmp = new MapLocation(m.x + 2, m.y + -2);
        if (rc.canSenseLocation(tmp)) {
            MapInfo mi = rc.senseMapInfo(tmp);
            if (mi.getMark() == PaintType.ALLY_PRIMARY) {
                return Soldier.shouldUseSecond(m, tmp);
            }
        }
        
        
        
        tmp = new MapLocation(m.x + 1, m.y + 2);
        if (rc.canSenseLocation(tmp)) {
            MapInfo mi = rc.senseMapInfo(tmp);
            if (mi.getMark() == PaintType.ALLY_PRIMARY) {
                return Soldier.shouldUseSecond(m, tmp);
            }
        }
        
        tmp = new MapLocation(m.x + 1, m.y + 1);
        if (rc.canSenseLocation(tmp)) {
            MapInfo mi = rc.senseMapInfo(tmp);
            if (mi.getMark() == PaintType.ALLY_PRIMARY) {
                return Soldier.shouldUseSecond(m, tmp);
            }
        }
        
        tmp = new MapLocation(m.x + 1, m.y + 0);
        if (rc.canSenseLocation(tmp)) {
            MapInfo mi = rc.senseMapInfo(tmp);
            if (mi.getMark() == PaintType.ALLY_PRIMARY) {
                return Soldier.shouldUseSecond(m, tmp);
            }
        }
        
        tmp = new MapLocation(m.x + 1, m.y + -1);
        if (rc.canSenseLocation(tmp)) {
            MapInfo mi = rc.senseMapInfo(tmp);
            if (mi.getMark() == PaintType.ALLY_PRIMARY) {
                return Soldier.shouldUseSecond(m, tmp);
            }
        }
        
        tmp = new MapLocation(m.x + 1, m.y + -2);
        if (rc.canSenseLocation(tmp)) {
            MapInfo mi = rc.senseMapInfo(tmp);
            if (mi.getMark() == PaintType.ALLY_PRIMARY) {
                return Soldier.shouldUseSecond(m, tmp);
            }
        }
        
        
        
        tmp = new MapLocation(m.x + 0, m.y + 2);
        if (rc.canSenseLocation(tmp)) {
            MapInfo mi = rc.senseMapInfo(tmp);
            if (mi.getMark() == PaintType.ALLY_PRIMARY) {
                return Soldier.shouldUseSecond(m, tmp);
            }
        }
        
        tmp = new MapLocation(m.x + 0, m.y + 1);
        if (rc.canSenseLocation(tmp)) {
            MapInfo mi = rc.senseMapInfo(tmp);
            if (mi.getMark() == PaintType.ALLY_PRIMARY) {
                return Soldier.shouldUseSecond(m, tmp);
            }
        }
        
        tmp = new MapLocation(m.x + 0, m.y + 0);
        if (rc.canSenseLocation(tmp)) {
            MapInfo mi = rc.senseMapInfo(tmp);
            if (mi.getMark() == PaintType.ALLY_PRIMARY) {
                return Soldier.shouldUseSecond(m, tmp);
            }
        }
        
        tmp = new MapLocation(m.x + 0, m.y + -1);
        if (rc.canSenseLocation(tmp)) {
            MapInfo mi = rc.senseMapInfo(tmp);
            if (mi.getMark() == PaintType.ALLY_PRIMARY) {
                return Soldier.shouldUseSecond(m, tmp);
            }
        }
        
        tmp = new MapLocation(m.x + 0, m.y + -2);
        if (rc.canSenseLocation(tmp)) {
            MapInfo mi = rc.senseMapInfo(tmp);
            if (mi.getMark() == PaintType.ALLY_PRIMARY) {
                return Soldier.shouldUseSecond(m, tmp);
            }
        }
        
        
        
        tmp = new MapLocation(m.x + -1, m.y + 2);
        if (rc.canSenseLocation(tmp)) {
            MapInfo mi = rc.senseMapInfo(tmp);
            if (mi.getMark() == PaintType.ALLY_PRIMARY) {
                return Soldier.shouldUseSecond(m, tmp);
            }
        }
        
        tmp = new MapLocation(m.x + -1, m.y + 1);
        if (rc.canSenseLocation(tmp)) {
            MapInfo mi = rc.senseMapInfo(tmp);
            if (mi.getMark() == PaintType.ALLY_PRIMARY) {
                return Soldier.shouldUseSecond(m, tmp);
            }
        }
        
        tmp = new MapLocation(m.x + -1, m.y + 0);
        if (rc.canSenseLocation(tmp)) {
            MapInfo mi = rc.senseMapInfo(tmp);
            if (mi.getMark() == PaintType.ALLY_PRIMARY) {
                return Soldier.shouldUseSecond(m, tmp);
            }
        }
        
        tmp = new MapLocation(m.x + -1, m.y + -1);
        if (rc.canSenseLocation(tmp)) {
            MapInfo mi = rc.senseMapInfo(tmp);
            if (mi.getMark() == PaintType.ALLY_PRIMARY) {
                return Soldier.shouldUseSecond(m, tmp);
            }
        }
        
        tmp = new MapLocation(m.x + -1, m.y + -2);
        if (rc.canSenseLocation(tmp)) {
            MapInfo mi = rc.senseMapInfo(tmp);
            if (mi.getMark() == PaintType.ALLY_PRIMARY) {
                return Soldier.shouldUseSecond(m, tmp);
            }
        }
        
        
        
        tmp = new MapLocation(m.x + -2, m.y + 2);
        if (rc.canSenseLocation(tmp)) {
            MapInfo mi = rc.senseMapInfo(tmp);
            if (mi.getMark() == PaintType.ALLY_PRIMARY) {
                return Soldier.shouldUseSecond(m, tmp);
            }
        }
        
        tmp = new MapLocation(m.x + -2, m.y + 1);
        if (rc.canSenseLocation(tmp)) {
            MapInfo mi = rc.senseMapInfo(tmp);
            if (mi.getMark() == PaintType.ALLY_PRIMARY) {
                return Soldier.shouldUseSecond(m, tmp);
            }
        }
        
        tmp = new MapLocation(m.x + -2, m.y + 0);
        if (rc.canSenseLocation(tmp)) {
            MapInfo mi = rc.senseMapInfo(tmp);
            if (mi.getMark() == PaintType.ALLY_PRIMARY) {
                return Soldier.shouldUseSecond(m, tmp);
            }
        }
        
        tmp = new MapLocation(m.x + -2, m.y + -1);
        if (rc.canSenseLocation(tmp)) {
            MapInfo mi = rc.senseMapInfo(tmp);
            if (mi.getMark() == PaintType.ALLY_PRIMARY) {
                return Soldier.shouldUseSecond(m, tmp);
            }
        }
        
        tmp = new MapLocation(m.x + -2, m.y + -2);
        if (rc.canSenseLocation(tmp)) {
            MapInfo mi = rc.senseMapInfo(tmp);
            if (mi.getMark() == PaintType.ALLY_PRIMARY) {
                return Soldier.shouldUseSecond(m, tmp);
            }
        }
        
        
        return false;
    }

    public static boolean checkNearby(MapLocation loc) throws GameActionException {
        MapLocation tmp;
        
        
        
        tmp = new MapLocation(loc.x + 2, loc.y + 2);
        if (rc.canSenseLocation(tmp)) {
            MapInfo mi = rc.senseMapInfo(tmp);
            boolean b = shouldUseSecond(tmp, loc);
            if (mi.getPaint() == PaintType.EMPTY || (mi.getPaint().isAlly() && b != (mi.getPaint() == PaintType.ALLY_SECONDARY))) {
                if (rc.canAttack(tmp)) {
                    rc.attack(tmp, b);
                    return true;
                }
            }
        }
        
        
        
        tmp = new MapLocation(loc.x + 2, loc.y + 1);
        if (rc.canSenseLocation(tmp)) {
            MapInfo mi = rc.senseMapInfo(tmp);
            boolean b = shouldUseSecond(tmp, loc);
            if (mi.getPaint() == PaintType.EMPTY || (mi.getPaint().isAlly() && b != (mi.getPaint() == PaintType.ALLY_SECONDARY))) {
                if (rc.canAttack(tmp)) {
                    rc.attack(tmp, b);
                    return true;
                }
            }
        }
        
        
        
        tmp = new MapLocation(loc.x + 2, loc.y + 0);
        if (rc.canSenseLocation(tmp)) {
            MapInfo mi = rc.senseMapInfo(tmp);
            boolean b = shouldUseSecond(tmp, loc);
            if (mi.getPaint() == PaintType.EMPTY || (mi.getPaint().isAlly() && b != (mi.getPaint() == PaintType.ALLY_SECONDARY))) {
                if (rc.canAttack(tmp)) {
                    rc.attack(tmp, b);
                    return true;
                }
            }
        }
        
        
        
        tmp = new MapLocation(loc.x + 2, loc.y + -1);
        if (rc.canSenseLocation(tmp)) {
            MapInfo mi = rc.senseMapInfo(tmp);
            boolean b = shouldUseSecond(tmp, loc);
            if (mi.getPaint() == PaintType.EMPTY || (mi.getPaint().isAlly() && b != (mi.getPaint() == PaintType.ALLY_SECONDARY))) {
                if (rc.canAttack(tmp)) {
                    rc.attack(tmp, b);
                    return true;
                }
            }
        }
        
        
        
        tmp = new MapLocation(loc.x + 2, loc.y + -2);
        if (rc.canSenseLocation(tmp)) {
            MapInfo mi = rc.senseMapInfo(tmp);
            boolean b = shouldUseSecond(tmp, loc);
            if (mi.getPaint() == PaintType.EMPTY || (mi.getPaint().isAlly() && b != (mi.getPaint() == PaintType.ALLY_SECONDARY))) {
                if (rc.canAttack(tmp)) {
                    rc.attack(tmp, b);
                    return true;
                }
            }
        }
        
        
        
        
        
        tmp = new MapLocation(loc.x + 1, loc.y + 2);
        if (rc.canSenseLocation(tmp)) {
            MapInfo mi = rc.senseMapInfo(tmp);
            boolean b = shouldUseSecond(tmp, loc);
            if (mi.getPaint() == PaintType.EMPTY || (mi.getPaint().isAlly() && b != (mi.getPaint() == PaintType.ALLY_SECONDARY))) {
                if (rc.canAttack(tmp)) {
                    rc.attack(tmp, b);
                    return true;
                }
            }
        }
        
        
        
        tmp = new MapLocation(loc.x + 1, loc.y + 1);
        if (rc.canSenseLocation(tmp)) {
            MapInfo mi = rc.senseMapInfo(tmp);
            boolean b = shouldUseSecond(tmp, loc);
            if (mi.getPaint() == PaintType.EMPTY || (mi.getPaint().isAlly() && b != (mi.getPaint() == PaintType.ALLY_SECONDARY))) {
                if (rc.canAttack(tmp)) {
                    rc.attack(tmp, b);
                    return true;
                }
            }
        }
        
        
        
        tmp = new MapLocation(loc.x + 1, loc.y + 0);
        if (rc.canSenseLocation(tmp)) {
            MapInfo mi = rc.senseMapInfo(tmp);
            boolean b = shouldUseSecond(tmp, loc);
            if (mi.getPaint() == PaintType.EMPTY || (mi.getPaint().isAlly() && b != (mi.getPaint() == PaintType.ALLY_SECONDARY))) {
                if (rc.canAttack(tmp)) {
                    rc.attack(tmp, b);
                    return true;
                }
            }
        }
        
        
        
        tmp = new MapLocation(loc.x + 1, loc.y + -1);
        if (rc.canSenseLocation(tmp)) {
            MapInfo mi = rc.senseMapInfo(tmp);
            boolean b = shouldUseSecond(tmp, loc);
            if (mi.getPaint() == PaintType.EMPTY || (mi.getPaint().isAlly() && b != (mi.getPaint() == PaintType.ALLY_SECONDARY))) {
                if (rc.canAttack(tmp)) {
                    rc.attack(tmp, b);
                    return true;
                }
            }
        }
        
        
        
        tmp = new MapLocation(loc.x + 1, loc.y + -2);
        if (rc.canSenseLocation(tmp)) {
            MapInfo mi = rc.senseMapInfo(tmp);
            boolean b = shouldUseSecond(tmp, loc);
            if (mi.getPaint() == PaintType.EMPTY || (mi.getPaint().isAlly() && b != (mi.getPaint() == PaintType.ALLY_SECONDARY))) {
                if (rc.canAttack(tmp)) {
                    rc.attack(tmp, b);
                    return true;
                }
            }
        }
        
        
        
        
        
        tmp = new MapLocation(loc.x + 0, loc.y + 2);
        if (rc.canSenseLocation(tmp)) {
            MapInfo mi = rc.senseMapInfo(tmp);
            boolean b = shouldUseSecond(tmp, loc);
            if (mi.getPaint() == PaintType.EMPTY || (mi.getPaint().isAlly() && b != (mi.getPaint() == PaintType.ALLY_SECONDARY))) {
                if (rc.canAttack(tmp)) {
                    rc.attack(tmp, b);
                    return true;
                }
            }
        }
        
        
        
        tmp = new MapLocation(loc.x + 0, loc.y + 1);
        if (rc.canSenseLocation(tmp)) {
            MapInfo mi = rc.senseMapInfo(tmp);
            boolean b = shouldUseSecond(tmp, loc);
            if (mi.getPaint() == PaintType.EMPTY || (mi.getPaint().isAlly() && b != (mi.getPaint() == PaintType.ALLY_SECONDARY))) {
                if (rc.canAttack(tmp)) {
                    rc.attack(tmp, b);
                    return true;
                }
            }
        }
        
        
        
        
        
        tmp = new MapLocation(loc.x + 0, loc.y + -1);
        if (rc.canSenseLocation(tmp)) {
            MapInfo mi = rc.senseMapInfo(tmp);
            boolean b = shouldUseSecond(tmp, loc);
            if (mi.getPaint() == PaintType.EMPTY || (mi.getPaint().isAlly() && b != (mi.getPaint() == PaintType.ALLY_SECONDARY))) {
                if (rc.canAttack(tmp)) {
                    rc.attack(tmp, b);
                    return true;
                }
            }
        }
        
        
        
        tmp = new MapLocation(loc.x + 0, loc.y + -2);
        if (rc.canSenseLocation(tmp)) {
            MapInfo mi = rc.senseMapInfo(tmp);
            boolean b = shouldUseSecond(tmp, loc);
            if (mi.getPaint() == PaintType.EMPTY || (mi.getPaint().isAlly() && b != (mi.getPaint() == PaintType.ALLY_SECONDARY))) {
                if (rc.canAttack(tmp)) {
                    rc.attack(tmp, b);
                    return true;
                }
            }
        }
        
        
        
        
        
        tmp = new MapLocation(loc.x + -1, loc.y + 2);
        if (rc.canSenseLocation(tmp)) {
            MapInfo mi = rc.senseMapInfo(tmp);
            boolean b = shouldUseSecond(tmp, loc);
            if (mi.getPaint() == PaintType.EMPTY || (mi.getPaint().isAlly() && b != (mi.getPaint() == PaintType.ALLY_SECONDARY))) {
                if (rc.canAttack(tmp)) {
                    rc.attack(tmp, b);
                    return true;
                }
            }
        }
        
        
        
        tmp = new MapLocation(loc.x + -1, loc.y + 1);
        if (rc.canSenseLocation(tmp)) {
            MapInfo mi = rc.senseMapInfo(tmp);
            boolean b = shouldUseSecond(tmp, loc);
            if (mi.getPaint() == PaintType.EMPTY || (mi.getPaint().isAlly() && b != (mi.getPaint() == PaintType.ALLY_SECONDARY))) {
                if (rc.canAttack(tmp)) {
                    rc.attack(tmp, b);
                    return true;
                }
            }
        }
        
        
        
        tmp = new MapLocation(loc.x + -1, loc.y + 0);
        if (rc.canSenseLocation(tmp)) {
            MapInfo mi = rc.senseMapInfo(tmp);
            boolean b = shouldUseSecond(tmp, loc);
            if (mi.getPaint() == PaintType.EMPTY || (mi.getPaint().isAlly() && b != (mi.getPaint() == PaintType.ALLY_SECONDARY))) {
                if (rc.canAttack(tmp)) {
                    rc.attack(tmp, b);
                    return true;
                }
            }
        }
        
        
        
        tmp = new MapLocation(loc.x + -1, loc.y + -1);
        if (rc.canSenseLocation(tmp)) {
            MapInfo mi = rc.senseMapInfo(tmp);
            boolean b = shouldUseSecond(tmp, loc);
            if (mi.getPaint() == PaintType.EMPTY || (mi.getPaint().isAlly() && b != (mi.getPaint() == PaintType.ALLY_SECONDARY))) {
                if (rc.canAttack(tmp)) {
                    rc.attack(tmp, b);
                    return true;
                }
            }
        }
        
        
        
        tmp = new MapLocation(loc.x + -1, loc.y + -2);
        if (rc.canSenseLocation(tmp)) {
            MapInfo mi = rc.senseMapInfo(tmp);
            boolean b = shouldUseSecond(tmp, loc);
            if (mi.getPaint() == PaintType.EMPTY || (mi.getPaint().isAlly() && b != (mi.getPaint() == PaintType.ALLY_SECONDARY))) {
                if (rc.canAttack(tmp)) {
                    rc.attack(tmp, b);
                    return true;
                }
            }
        }
        
        
        
        
        
        tmp = new MapLocation(loc.x + -2, loc.y + 2);
        if (rc.canSenseLocation(tmp)) {
            MapInfo mi = rc.senseMapInfo(tmp);
            boolean b = shouldUseSecond(tmp, loc);
            if (mi.getPaint() == PaintType.EMPTY || (mi.getPaint().isAlly() && b != (mi.getPaint() == PaintType.ALLY_SECONDARY))) {
                if (rc.canAttack(tmp)) {
                    rc.attack(tmp, b);
                    return true;
                }
            }
        }
        
        
        
        tmp = new MapLocation(loc.x + -2, loc.y + 1);
        if (rc.canSenseLocation(tmp)) {
            MapInfo mi = rc.senseMapInfo(tmp);
            boolean b = shouldUseSecond(tmp, loc);
            if (mi.getPaint() == PaintType.EMPTY || (mi.getPaint().isAlly() && b != (mi.getPaint() == PaintType.ALLY_SECONDARY))) {
                if (rc.canAttack(tmp)) {
                    rc.attack(tmp, b);
                    return true;
                }
            }
        }
        
        
        
        tmp = new MapLocation(loc.x + -2, loc.y + 0);
        if (rc.canSenseLocation(tmp)) {
            MapInfo mi = rc.senseMapInfo(tmp);
            boolean b = shouldUseSecond(tmp, loc);
            if (mi.getPaint() == PaintType.EMPTY || (mi.getPaint().isAlly() && b != (mi.getPaint() == PaintType.ALLY_SECONDARY))) {
                if (rc.canAttack(tmp)) {
                    rc.attack(tmp, b);
                    return true;
                }
            }
        }
        
        
        
        tmp = new MapLocation(loc.x + -2, loc.y + -1);
        if (rc.canSenseLocation(tmp)) {
            MapInfo mi = rc.senseMapInfo(tmp);
            boolean b = shouldUseSecond(tmp, loc);
            if (mi.getPaint() == PaintType.EMPTY || (mi.getPaint().isAlly() && b != (mi.getPaint() == PaintType.ALLY_SECONDARY))) {
                if (rc.canAttack(tmp)) {
                    rc.attack(tmp, b);
                    return true;
                }
            }
        }
        
        
        
        tmp = new MapLocation(loc.x + -2, loc.y + -2);
        if (rc.canSenseLocation(tmp)) {
            MapInfo mi = rc.senseMapInfo(tmp);
            boolean b = shouldUseSecond(tmp, loc);
            if (mi.getPaint() == PaintType.EMPTY || (mi.getPaint().isAlly() && b != (mi.getPaint() == PaintType.ALLY_SECONDARY))) {
                if (rc.canAttack(tmp)) {
                    rc.attack(tmp, b);
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
        } else if (Attack.shouldSoldierMicro()) {
            rc.setIndicatorString("Attacking");
            Attack.soldierAttackMicro();
            return;
        } else if (rc.getNumberTowers() < 25 && markedResource == null) {
            buildTower = TowerBuild.getRuin(near);
            if (buildTower != null) {
                TowerBuild.makeTower(buildTower);
                return;
            }
        }

        if (returnLoc != null) {
            if (myloc.distanceSquaredTo(returnLoc) <= 5) {
                returnLoc = null;
            }
            else {
                Pathing.pathTo(returnLoc);
            }
        }

        moneyPattern();
        if (markedResource != null) {
            rc.setIndicatorString("Patching Resource");
            makeResourcePatch();
            return;
        }

        helpPattern(near);

        if (moved) return;

        //rc.setIndicatorString("Exploring");
        Explore.explore(near);
    }

    public static void postTurn() throws GameActionException {

        // Lay paint where I am first.
        if (canChangeColor(myloc) && rc.canAttack(myloc) && rc.getPaint() >= 50 && okToTile(myloc)){
            rc.attack(myloc, getGoodColor(myloc));
        }

        if (buildTower != null) {
            if (rc.canCompleteTowerPattern(UnitType.LEVEL_ONE_PAINT_TOWER, buildTower)) {
                rc.completeTowerPattern(UnitType.LEVEL_ONE_PAINT_TOWER, buildTower);
            }
            if (rc.canCompleteTowerPattern(UnitType.LEVEL_ONE_MONEY_TOWER, buildTower)) {
                rc.completeTowerPattern(UnitType.LEVEL_ONE_MONEY_TOWER, buildTower);
            }
        }
        checkMoneyPatterns();
    }
}