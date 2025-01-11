

package jan11_5_59;
import battlecode.common.*;
import java.util.ArrayList;
import java.util.Collections;

public class Soldier {
    public static RobotController rc;
    public static MapLocation home = null;
    public static MapLocation buildTower = null;
    public static MapLocation myloc;
    public static int paintCapacity = UnitType.SOLDIER.paintCapacity;
    public static int myPaint;
    public static MapLocation exploreTarget;
    public static MapInfo[] near;
    public static MapLocation ruinLoc;
    public static MapLocation markedResource = null;
    public static boolean[][] resourcePat = null;
    public static int evenChunkDx[] = {0, 4, -4, 1, 1};
    public static int evenChunkDy[] = {0, 0, 0, 3, -3};
    public static int oddChunkDx[] = {0, 4, -4, -1, -1};
    public static int oddChunkDy[] = {0, 0, 0, 3, -3};
    public static MapLocation chunkGoal = null;

    public static void init(RobotController rc) {
        Soldier.rc = rc;
    }

    public static MapLocation getLowerCenter(MapLocation m) {
        int a = (m.y - 2) / 3;
        int cy = 3 * a + 2, cx;
        if (a % 2 == 0) {
            int b = (m.x - 2) / 4;
            cx = 2 + b * 4;
        }
        else {
            int b = (m.x - 3) / 4;
            cx = 3 + b * 4;
        }
        if (m.x - cx > 2) cx += 4;
        return new MapLocation(cx, cy);
    }

    public static boolean useOdd(MapLocation m) {
        return (((m.y - 2) / 3) & 1) == 1;
    }

    public static boolean shouldUseSecond(MapLocation m) {
        MapLocation c = getLowerCenter(m);
        int dx = m.x - c.x, dy = m.y - c.y;
        if(dx == 0 && dy == 0) return false;
        else return ((Math.abs(dx) & 1) == (Math.abs(dy) & 1));
    }

    public static boolean okToTile(MapLocation m) throws GameActionException {
        if (rc.getNumberTowers() == 25) return true;
        MapInfo mCur = rc.senseMapInfo(m);
        boolean b = shouldUseSecond(m);
        if (mCur.getPaint().isAlly()) {
            if (b == (mCur.getPaint() == PaintType.ALLY_SECONDARY)) {
                return false;
            }
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
        MapLocation h;
        MapLocation g = getLowerCenter(rc.getLocation());
        for (int i = 5; --i >= 0;) {
            if(useOdd(g)) h = new MapLocation(g.x + oddChunkDx[i], g.y + oddChunkDy[i]);
            else h = new MapLocation(g.x + evenChunkDx[i], g.y + evenChunkDy[i]); 
            if (rc.canCompleteResourcePattern(h)) {
                rc.completeResourcePattern(h);
                if (rc.canMark(h)) {
                    rc.mark(h, false);
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

    public static void setHome() throws GameActionException {
        if (home != null) {
            //if we can see it, it is not a paint tower, and it is empty - set to null
            if (rc.canSenseLocation(home)) {
                RobotInfo r = rc.senseRobotAtLocation(home);
                if (r == null || r.paintAmount == 0) {
                    home = null;
                }
            }

        }
        RobotInfo[] robots = rc.senseNearbyRobots();
        RobotInfo robot;
        loop: {
        
            if (0 >= robots.length) break loop;
            robot = robots[0];
            if (robot.team == rc.getTeam() && robot.paintAmount > 0 && Globals.isTower(robot.type)) {
                home = robot.location;
                break loop;
            }
        
            if (1 >= robots.length) break loop;
            robot = robots[1];
            if (robot.team == rc.getTeam() && robot.paintAmount > 0 && Globals.isTower(robot.type)) {
                home = robot.location;
                break loop;
            }
        
            if (2 >= robots.length) break loop;
            robot = robots[2];
            if (robot.team == rc.getTeam() && robot.paintAmount > 0 && Globals.isTower(robot.type)) {
                home = robot.location;
                break loop;
            }
        
            if (3 >= robots.length) break loop;
            robot = robots[3];
            if (robot.team == rc.getTeam() && robot.paintAmount > 0 && Globals.isTower(robot.type)) {
                home = robot.location;
                break loop;
            }
        
            if (4 >= robots.length) break loop;
            robot = robots[4];
            if (robot.team == rc.getTeam() && robot.paintAmount > 0 && Globals.isTower(robot.type)) {
                home = robot.location;
                break loop;
            }
        
            if (5 >= robots.length) break loop;
            robot = robots[5];
            if (robot.team == rc.getTeam() && robot.paintAmount > 0 && Globals.isTower(robot.type)) {
                home = robot.location;
                break loop;
            }
        
            if (6 >= robots.length) break loop;
            robot = robots[6];
            if (robot.team == rc.getTeam() && robot.paintAmount > 0 && Globals.isTower(robot.type)) {
                home = robot.location;
                break loop;
            }
        
            if (7 >= robots.length) break loop;
            robot = robots[7];
            if (robot.team == rc.getTeam() && robot.paintAmount > 0 && Globals.isTower(robot.type)) {
                home = robot.location;
                break loop;
            }
        
            if (8 >= robots.length) break loop;
            robot = robots[8];
            if (robot.team == rc.getTeam() && robot.paintAmount > 0 && Globals.isTower(robot.type)) {
                home = robot.location;
                break loop;
            }
        
            if (9 >= robots.length) break loop;
            robot = robots[9];
            if (robot.team == rc.getTeam() && robot.paintAmount > 0 && Globals.isTower(robot.type)) {
                home = robot.location;
                break loop;
            }
        
            if (10 >= robots.length) break loop;
            robot = robots[10];
            if (robot.team == rc.getTeam() && robot.paintAmount > 0 && Globals.isTower(robot.type)) {
                home = robot.location;
                break loop;
            }
        
            if (11 >= robots.length) break loop;
            robot = robots[11];
            if (robot.team == rc.getTeam() && robot.paintAmount > 0 && Globals.isTower(robot.type)) {
                home = robot.location;
                break loop;
            }
        
            if (12 >= robots.length) break loop;
            robot = robots[12];
            if (robot.team == rc.getTeam() && robot.paintAmount > 0 && Globals.isTower(robot.type)) {
                home = robot.location;
                break loop;
            }
        
            if (13 >= robots.length) break loop;
            robot = robots[13];
            if (robot.team == rc.getTeam() && robot.paintAmount > 0 && Globals.isTower(robot.type)) {
                home = robot.location;
                break loop;
            }
        
            if (14 >= robots.length) break loop;
            robot = robots[14];
            if (robot.team == rc.getTeam() && robot.paintAmount > 0 && Globals.isTower(robot.type)) {
                home = robot.location;
                break loop;
            }
        
            if (15 >= robots.length) break loop;
            robot = robots[15];
            if (robot.team == rc.getTeam() && robot.paintAmount > 0 && Globals.isTower(robot.type)) {
                home = robot.location;
                break loop;
            }
        
            if (16 >= robots.length) break loop;
            robot = robots[16];
            if (robot.team == rc.getTeam() && robot.paintAmount > 0 && Globals.isTower(robot.type)) {
                home = robot.location;
                break loop;
            }
        
            if (17 >= robots.length) break loop;
            robot = robots[17];
            if (robot.team == rc.getTeam() && robot.paintAmount > 0 && Globals.isTower(robot.type)) {
                home = robot.location;
                break loop;
            }
        
            if (18 >= robots.length) break loop;
            robot = robots[18];
            if (robot.team == rc.getTeam() && robot.paintAmount > 0 && Globals.isTower(robot.type)) {
                home = robot.location;
                break loop;
            }
        
            if (19 >= robots.length) break loop;
            robot = robots[19];
            if (robot.team == rc.getTeam() && robot.paintAmount > 0 && Globals.isTower(robot.type)) {
                home = robot.location;
                break loop;
            }
        
            if (20 >= robots.length) break loop;
            robot = robots[20];
            if (robot.team == rc.getTeam() && robot.paintAmount > 0 && Globals.isTower(robot.type)) {
                home = robot.location;
                break loop;
            }
        
            if (21 >= robots.length) break loop;
            robot = robots[21];
            if (robot.team == rc.getTeam() && robot.paintAmount > 0 && Globals.isTower(robot.type)) {
                home = robot.location;
                break loop;
            }
        
            if (22 >= robots.length) break loop;
            robot = robots[22];
            if (robot.team == rc.getTeam() && robot.paintAmount > 0 && Globals.isTower(robot.type)) {
                home = robot.location;
                break loop;
            }
        
            if (23 >= robots.length) break loop;
            robot = robots[23];
            if (robot.team == rc.getTeam() && robot.paintAmount > 0 && Globals.isTower(robot.type)) {
                home = robot.location;
                break loop;
            }
        
            if (24 >= robots.length) break loop;
            robot = robots[24];
            if (robot.team == rc.getTeam() && robot.paintAmount > 0 && Globals.isTower(robot.type)) {
                home = robot.location;
                break loop;
            }
        
            if (25 >= robots.length) break loop;
            robot = robots[25];
            if (robot.team == rc.getTeam() && robot.paintAmount > 0 && Globals.isTower(robot.type)) {
                home = robot.location;
                break loop;
            }
        
            if (26 >= robots.length) break loop;
            robot = robots[26];
            if (robot.team == rc.getTeam() && robot.paintAmount > 0 && Globals.isTower(robot.type)) {
                home = robot.location;
                break loop;
            }
        
            if (27 >= robots.length) break loop;
            robot = robots[27];
            if (robot.team == rc.getTeam() && robot.paintAmount > 0 && Globals.isTower(robot.type)) {
                home = robot.location;
                break loop;
            }
        
            if (28 >= robots.length) break loop;
            robot = robots[28];
            if (robot.team == rc.getTeam() && robot.paintAmount > 0 && Globals.isTower(robot.type)) {
                home = robot.location;
                break loop;
            }
        
            if (29 >= robots.length) break loop;
            robot = robots[29];
            if (robot.team == rc.getTeam() && robot.paintAmount > 0 && Globals.isTower(robot.type)) {
                home = robot.location;
                break loop;
            }
        
            if (30 >= robots.length) break loop;
            robot = robots[30];
            if (robot.team == rc.getTeam() && robot.paintAmount > 0 && Globals.isTower(robot.type)) {
                home = robot.location;
                break loop;
            }
        
            if (31 >= robots.length) break loop;
            robot = robots[31];
            if (robot.team == rc.getTeam() && robot.paintAmount > 0 && Globals.isTower(robot.type)) {
                home = robot.location;
                break loop;
            }
        
            if (32 >= robots.length) break loop;
            robot = robots[32];
            if (robot.team == rc.getTeam() && robot.paintAmount > 0 && Globals.isTower(robot.type)) {
                home = robot.location;
                break loop;
            }
        
            if (33 >= robots.length) break loop;
            robot = robots[33];
            if (robot.team == rc.getTeam() && robot.paintAmount > 0 && Globals.isTower(robot.type)) {
                home = robot.location;
                break loop;
            }
        
            if (34 >= robots.length) break loop;
            robot = robots[34];
            if (robot.team == rc.getTeam() && robot.paintAmount > 0 && Globals.isTower(robot.type)) {
                home = robot.location;
                break loop;
            }
        
            if (35 >= robots.length) break loop;
            robot = robots[35];
            if (robot.team == rc.getTeam() && robot.paintAmount > 0 && Globals.isTower(robot.type)) {
                home = robot.location;
                break loop;
            }
        
            if (36 >= robots.length) break loop;
            robot = robots[36];
            if (robot.team == rc.getTeam() && robot.paintAmount > 0 && Globals.isTower(robot.type)) {
                home = robot.location;
                break loop;
            }
        
            if (37 >= robots.length) break loop;
            robot = robots[37];
            if (robot.team == rc.getTeam() && robot.paintAmount > 0 && Globals.isTower(robot.type)) {
                home = robot.location;
                break loop;
            }
        
            if (38 >= robots.length) break loop;
            robot = robots[38];
            if (robot.team == rc.getTeam() && robot.paintAmount > 0 && Globals.isTower(robot.type)) {
                home = robot.location;
                break loop;
            }
        
            if (39 >= robots.length) break loop;
            robot = robots[39];
            if (robot.team == rc.getTeam() && robot.paintAmount > 0 && Globals.isTower(robot.type)) {
                home = robot.location;
                break loop;
            }
        
            if (40 >= robots.length) break loop;
            robot = robots[40];
            if (robot.team == rc.getTeam() && robot.paintAmount > 0 && Globals.isTower(robot.type)) {
                home = robot.location;
                break loop;
            }
        
            if (41 >= robots.length) break loop;
            robot = robots[41];
            if (robot.team == rc.getTeam() && robot.paintAmount > 0 && Globals.isTower(robot.type)) {
                home = robot.location;
                break loop;
            }
        
            if (42 >= robots.length) break loop;
            robot = robots[42];
            if (robot.team == rc.getTeam() && robot.paintAmount > 0 && Globals.isTower(robot.type)) {
                home = robot.location;
                break loop;
            }
        
            if (43 >= robots.length) break loop;
            robot = robots[43];
            if (robot.team == rc.getTeam() && robot.paintAmount > 0 && Globals.isTower(robot.type)) {
                home = robot.location;
                break loop;
            }
        
            if (44 >= robots.length) break loop;
            robot = robots[44];
            if (robot.team == rc.getTeam() && robot.paintAmount > 0 && Globals.isTower(robot.type)) {
                home = robot.location;
                break loop;
            }
        
            if (45 >= robots.length) break loop;
            robot = robots[45];
            if (robot.team == rc.getTeam() && robot.paintAmount > 0 && Globals.isTower(robot.type)) {
                home = robot.location;
                break loop;
            }
        
            if (46 >= robots.length) break loop;
            robot = robots[46];
            if (robot.team == rc.getTeam() && robot.paintAmount > 0 && Globals.isTower(robot.type)) {
                home = robot.location;
                break loop;
            }
        
            if (47 >= robots.length) break loop;
            robot = robots[47];
            if (robot.team == rc.getTeam() && robot.paintAmount > 0 && Globals.isTower(robot.type)) {
                home = robot.location;
                break loop;
            }
        
            if (48 >= robots.length) break loop;
            robot = robots[48];
            if (robot.team == rc.getTeam() && robot.paintAmount > 0 && Globals.isTower(robot.type)) {
                home = robot.location;
                break loop;
            }
        
            if (49 >= robots.length) break loop;
            robot = robots[49];
            if (robot.team == rc.getTeam() && robot.paintAmount > 0 && Globals.isTower(robot.type)) {
                home = robot.location;
                break loop;
            }
        
            if (50 >= robots.length) break loop;
            robot = robots[50];
            if (robot.team == rc.getTeam() && robot.paintAmount > 0 && Globals.isTower(robot.type)) {
                home = robot.location;
                break loop;
            }
        
            if (51 >= robots.length) break loop;
            robot = robots[51];
            if (robot.team == rc.getTeam() && robot.paintAmount > 0 && Globals.isTower(robot.type)) {
                home = robot.location;
                break loop;
            }
        
            if (52 >= robots.length) break loop;
            robot = robots[52];
            if (robot.team == rc.getTeam() && robot.paintAmount > 0 && Globals.isTower(robot.type)) {
                home = robot.location;
                break loop;
            }
        
            if (53 >= robots.length) break loop;
            robot = robots[53];
            if (robot.team == rc.getTeam() && robot.paintAmount > 0 && Globals.isTower(robot.type)) {
                home = robot.location;
                break loop;
            }
        
            if (54 >= robots.length) break loop;
            robot = robots[54];
            if (robot.team == rc.getTeam() && robot.paintAmount > 0 && Globals.isTower(robot.type)) {
                home = robot.location;
                break loop;
            }
        
            if (55 >= robots.length) break loop;
            robot = robots[55];
            if (robot.team == rc.getTeam() && robot.paintAmount > 0 && Globals.isTower(robot.type)) {
                home = robot.location;
                break loop;
            }
        
            if (56 >= robots.length) break loop;
            robot = robots[56];
            if (robot.team == rc.getTeam() && robot.paintAmount > 0 && Globals.isTower(robot.type)) {
                home = robot.location;
                break loop;
            }
        
            if (57 >= robots.length) break loop;
            robot = robots[57];
            if (robot.team == rc.getTeam() && robot.paintAmount > 0 && Globals.isTower(robot.type)) {
                home = robot.location;
                break loop;
            }
        
            if (58 >= robots.length) break loop;
            robot = robots[58];
            if (robot.team == rc.getTeam() && robot.paintAmount > 0 && Globals.isTower(robot.type)) {
                home = robot.location;
                break loop;
            }
        
            if (59 >= robots.length) break loop;
            robot = robots[59];
            if (robot.team == rc.getTeam() && robot.paintAmount > 0 && Globals.isTower(robot.type)) {
                home = robot.location;
                break loop;
            }
        
            if (60 >= robots.length) break loop;
            robot = robots[60];
            if (robot.team == rc.getTeam() && robot.paintAmount > 0 && Globals.isTower(robot.type)) {
                home = robot.location;
                break loop;
            }
        
            if (61 >= robots.length) break loop;
            robot = robots[61];
            if (robot.team == rc.getTeam() && robot.paintAmount > 0 && Globals.isTower(robot.type)) {
                home = robot.location;
                break loop;
            }
        
            if (62 >= robots.length) break loop;
            robot = robots[62];
            if (robot.team == rc.getTeam() && robot.paintAmount > 0 && Globals.isTower(robot.type)) {
                home = robot.location;
                break loop;
            }
        
            if (63 >= robots.length) break loop;
            robot = robots[63];
            if (robot.team == rc.getTeam() && robot.paintAmount > 0 && Globals.isTower(robot.type)) {
                home = robot.location;
                break loop;
            }
        
            if (64 >= robots.length) break loop;
            robot = robots[64];
            if (robot.team == rc.getTeam() && robot.paintAmount > 0 && Globals.isTower(robot.type)) {
                home = robot.location;
                break loop;
            }
        
            if (65 >= robots.length) break loop;
            robot = robots[65];
            if (robot.team == rc.getTeam() && robot.paintAmount > 0 && Globals.isTower(robot.type)) {
                home = robot.location;
                break loop;
            }
        
            if (66 >= robots.length) break loop;
            robot = robots[66];
            if (robot.team == rc.getTeam() && robot.paintAmount > 0 && Globals.isTower(robot.type)) {
                home = robot.location;
                break loop;
            }
        
            if (67 >= robots.length) break loop;
            robot = robots[67];
            if (robot.team == rc.getTeam() && robot.paintAmount > 0 && Globals.isTower(robot.type)) {
                home = robot.location;
                break loop;
            }
        
            if (68 >= robots.length) break loop;
            robot = robots[68];
            if (robot.team == rc.getTeam() && robot.paintAmount > 0 && Globals.isTower(robot.type)) {
                home = robot.location;
                break loop;
            }
        
            if (69 >= robots.length) break loop;
            robot = robots[69];
            if (robot.team == rc.getTeam() && robot.paintAmount > 0 && Globals.isTower(robot.type)) {
                home = robot.location;
                break loop;
            }
        
        }
    }

    public static void refuel() throws GameActionException {
        Pathing.pathTo(home);
        if (rc.canSenseLocation(home)) {
            RobotInfo r = rc.senseRobotAtLocation(home);
            if (r == null) {
                home = null;
                return;
            }
            int amt = Math.max(myPaint - paintCapacity, -r.getPaintAmount());
            if (rc.canTransferPaint(home, amt)) {
                rc.transferPaint(home, amt);
            }
        }
    }

    public static MapLocation seeRuin() throws GameActionException {
        MapLocation best = null;
        int closest = 100000000;
        for (int i = near.length; --i >= 0; ) {
            if (near[i].hasRuin()) {
                MapLocation m = near[i].getMapLocation();
                RobotInfo r = rc.senseRobotAtLocation(m);
                if (r == null) {
                    int d = m.distanceSquaredTo(rc.getLocation());
                    if (d < closest) {
                        closest = d;
                        best = m;
                    }
                }
            }
        }
        return best;
    }

    public static void makeTower() throws GameActionException {
        assert(buildTower != null);

        UnitType t = Globals.getTowerToBuild();
        boolean[][] pattern = rc.getTowerPattern(t);

        MapLocation tmp;
        MapLocation goal = null;
        boolean secondCol = false;
        int bestDist = 1000000000;
        
        
        
        tmp = new MapLocation(buildTower.x + 2, buildTower.y + 2);
        if (rc.canSenseLocation(tmp)) {
            MapInfo mi = rc.senseMapInfo(tmp);
            switch (mi.getPaint()) {
                case ENEMY_SECONDARY, ENEMY_PRIMARY -> {}
                default -> {
                    boolean isSecondary = (mi.getPaint() == PaintType.ALLY_SECONDARY);
                    boolean targetSecondary = pattern[4][4];
                    if ((mi.getPaint() == PaintType.EMPTY) || (isSecondary != targetSecondary)) {
                        int d = rc.getLocation().distanceSquaredTo(tmp);
                        if (d < bestDist) {
                            bestDist = d;
                            goal = tmp;
                            secondCol = targetSecondary;
                        }
                    }
                }
            }
        }
        
        
        
        tmp = new MapLocation(buildTower.x + 2, buildTower.y + 1);
        if (rc.canSenseLocation(tmp)) {
            MapInfo mi = rc.senseMapInfo(tmp);
            switch (mi.getPaint()) {
                case ENEMY_SECONDARY, ENEMY_PRIMARY -> {}
                default -> {
                    boolean isSecondary = (mi.getPaint() == PaintType.ALLY_SECONDARY);
                    boolean targetSecondary = pattern[4][3];
                    if ((mi.getPaint() == PaintType.EMPTY) || (isSecondary != targetSecondary)) {
                        int d = rc.getLocation().distanceSquaredTo(tmp);
                        if (d < bestDist) {
                            bestDist = d;
                            goal = tmp;
                            secondCol = targetSecondary;
                        }
                    }
                }
            }
        }
        
        
        
        tmp = new MapLocation(buildTower.x + 2, buildTower.y + 0);
        if (rc.canSenseLocation(tmp)) {
            MapInfo mi = rc.senseMapInfo(tmp);
            switch (mi.getPaint()) {
                case ENEMY_SECONDARY, ENEMY_PRIMARY -> {}
                default -> {
                    boolean isSecondary = (mi.getPaint() == PaintType.ALLY_SECONDARY);
                    boolean targetSecondary = pattern[4][2];
                    if ((mi.getPaint() == PaintType.EMPTY) || (isSecondary != targetSecondary)) {
                        int d = rc.getLocation().distanceSquaredTo(tmp);
                        if (d < bestDist) {
                            bestDist = d;
                            goal = tmp;
                            secondCol = targetSecondary;
                        }
                    }
                }
            }
        }
        
        
        
        tmp = new MapLocation(buildTower.x + 2, buildTower.y + -1);
        if (rc.canSenseLocation(tmp)) {
            MapInfo mi = rc.senseMapInfo(tmp);
            switch (mi.getPaint()) {
                case ENEMY_SECONDARY, ENEMY_PRIMARY -> {}
                default -> {
                    boolean isSecondary = (mi.getPaint() == PaintType.ALLY_SECONDARY);
                    boolean targetSecondary = pattern[4][1];
                    if ((mi.getPaint() == PaintType.EMPTY) || (isSecondary != targetSecondary)) {
                        int d = rc.getLocation().distanceSquaredTo(tmp);
                        if (d < bestDist) {
                            bestDist = d;
                            goal = tmp;
                            secondCol = targetSecondary;
                        }
                    }
                }
            }
        }
        
        
        
        tmp = new MapLocation(buildTower.x + 2, buildTower.y + -2);
        if (rc.canSenseLocation(tmp)) {
            MapInfo mi = rc.senseMapInfo(tmp);
            switch (mi.getPaint()) {
                case ENEMY_SECONDARY, ENEMY_PRIMARY -> {}
                default -> {
                    boolean isSecondary = (mi.getPaint() == PaintType.ALLY_SECONDARY);
                    boolean targetSecondary = pattern[4][0];
                    if ((mi.getPaint() == PaintType.EMPTY) || (isSecondary != targetSecondary)) {
                        int d = rc.getLocation().distanceSquaredTo(tmp);
                        if (d < bestDist) {
                            bestDist = d;
                            goal = tmp;
                            secondCol = targetSecondary;
                        }
                    }
                }
            }
        }
        
        
        
        
        
        tmp = new MapLocation(buildTower.x + 1, buildTower.y + 2);
        if (rc.canSenseLocation(tmp)) {
            MapInfo mi = rc.senseMapInfo(tmp);
            switch (mi.getPaint()) {
                case ENEMY_SECONDARY, ENEMY_PRIMARY -> {}
                default -> {
                    boolean isSecondary = (mi.getPaint() == PaintType.ALLY_SECONDARY);
                    boolean targetSecondary = pattern[3][4];
                    if ((mi.getPaint() == PaintType.EMPTY) || (isSecondary != targetSecondary)) {
                        int d = rc.getLocation().distanceSquaredTo(tmp);
                        if (d < bestDist) {
                            bestDist = d;
                            goal = tmp;
                            secondCol = targetSecondary;
                        }
                    }
                }
            }
        }
        
        
        
        tmp = new MapLocation(buildTower.x + 1, buildTower.y + 1);
        if (rc.canSenseLocation(tmp)) {
            MapInfo mi = rc.senseMapInfo(tmp);
            switch (mi.getPaint()) {
                case ENEMY_SECONDARY, ENEMY_PRIMARY -> {}
                default -> {
                    boolean isSecondary = (mi.getPaint() == PaintType.ALLY_SECONDARY);
                    boolean targetSecondary = pattern[3][3];
                    if ((mi.getPaint() == PaintType.EMPTY) || (isSecondary != targetSecondary)) {
                        int d = rc.getLocation().distanceSquaredTo(tmp);
                        if (d < bestDist) {
                            bestDist = d;
                            goal = tmp;
                            secondCol = targetSecondary;
                        }
                    }
                }
            }
        }
        
        
        
        tmp = new MapLocation(buildTower.x + 1, buildTower.y + 0);
        if (rc.canSenseLocation(tmp)) {
            MapInfo mi = rc.senseMapInfo(tmp);
            switch (mi.getPaint()) {
                case ENEMY_SECONDARY, ENEMY_PRIMARY -> {}
                default -> {
                    boolean isSecondary = (mi.getPaint() == PaintType.ALLY_SECONDARY);
                    boolean targetSecondary = pattern[3][2];
                    if ((mi.getPaint() == PaintType.EMPTY) || (isSecondary != targetSecondary)) {
                        int d = rc.getLocation().distanceSquaredTo(tmp);
                        if (d < bestDist) {
                            bestDist = d;
                            goal = tmp;
                            secondCol = targetSecondary;
                        }
                    }
                }
            }
        }
        
        
        
        tmp = new MapLocation(buildTower.x + 1, buildTower.y + -1);
        if (rc.canSenseLocation(tmp)) {
            MapInfo mi = rc.senseMapInfo(tmp);
            switch (mi.getPaint()) {
                case ENEMY_SECONDARY, ENEMY_PRIMARY -> {}
                default -> {
                    boolean isSecondary = (mi.getPaint() == PaintType.ALLY_SECONDARY);
                    boolean targetSecondary = pattern[3][1];
                    if ((mi.getPaint() == PaintType.EMPTY) || (isSecondary != targetSecondary)) {
                        int d = rc.getLocation().distanceSquaredTo(tmp);
                        if (d < bestDist) {
                            bestDist = d;
                            goal = tmp;
                            secondCol = targetSecondary;
                        }
                    }
                }
            }
        }
        
        
        
        tmp = new MapLocation(buildTower.x + 1, buildTower.y + -2);
        if (rc.canSenseLocation(tmp)) {
            MapInfo mi = rc.senseMapInfo(tmp);
            switch (mi.getPaint()) {
                case ENEMY_SECONDARY, ENEMY_PRIMARY -> {}
                default -> {
                    boolean isSecondary = (mi.getPaint() == PaintType.ALLY_SECONDARY);
                    boolean targetSecondary = pattern[3][0];
                    if ((mi.getPaint() == PaintType.EMPTY) || (isSecondary != targetSecondary)) {
                        int d = rc.getLocation().distanceSquaredTo(tmp);
                        if (d < bestDist) {
                            bestDist = d;
                            goal = tmp;
                            secondCol = targetSecondary;
                        }
                    }
                }
            }
        }
        
        
        
        
        
        tmp = new MapLocation(buildTower.x + 0, buildTower.y + 2);
        if (rc.canSenseLocation(tmp)) {
            MapInfo mi = rc.senseMapInfo(tmp);
            switch (mi.getPaint()) {
                case ENEMY_SECONDARY, ENEMY_PRIMARY -> {}
                default -> {
                    boolean isSecondary = (mi.getPaint() == PaintType.ALLY_SECONDARY);
                    boolean targetSecondary = pattern[2][4];
                    if ((mi.getPaint() == PaintType.EMPTY) || (isSecondary != targetSecondary)) {
                        int d = rc.getLocation().distanceSquaredTo(tmp);
                        if (d < bestDist) {
                            bestDist = d;
                            goal = tmp;
                            secondCol = targetSecondary;
                        }
                    }
                }
            }
        }
        
        
        
        tmp = new MapLocation(buildTower.x + 0, buildTower.y + 1);
        if (rc.canSenseLocation(tmp)) {
            MapInfo mi = rc.senseMapInfo(tmp);
            switch (mi.getPaint()) {
                case ENEMY_SECONDARY, ENEMY_PRIMARY -> {}
                default -> {
                    boolean isSecondary = (mi.getPaint() == PaintType.ALLY_SECONDARY);
                    boolean targetSecondary = pattern[2][3];
                    if ((mi.getPaint() == PaintType.EMPTY) || (isSecondary != targetSecondary)) {
                        int d = rc.getLocation().distanceSquaredTo(tmp);
                        if (d < bestDist) {
                            bestDist = d;
                            goal = tmp;
                            secondCol = targetSecondary;
                        }
                    }
                }
            }
        }
        
        
        
        
        
        tmp = new MapLocation(buildTower.x + 0, buildTower.y + -1);
        if (rc.canSenseLocation(tmp)) {
            MapInfo mi = rc.senseMapInfo(tmp);
            switch (mi.getPaint()) {
                case ENEMY_SECONDARY, ENEMY_PRIMARY -> {}
                default -> {
                    boolean isSecondary = (mi.getPaint() == PaintType.ALLY_SECONDARY);
                    boolean targetSecondary = pattern[2][1];
                    if ((mi.getPaint() == PaintType.EMPTY) || (isSecondary != targetSecondary)) {
                        int d = rc.getLocation().distanceSquaredTo(tmp);
                        if (d < bestDist) {
                            bestDist = d;
                            goal = tmp;
                            secondCol = targetSecondary;
                        }
                    }
                }
            }
        }
        
        
        
        tmp = new MapLocation(buildTower.x + 0, buildTower.y + -2);
        if (rc.canSenseLocation(tmp)) {
            MapInfo mi = rc.senseMapInfo(tmp);
            switch (mi.getPaint()) {
                case ENEMY_SECONDARY, ENEMY_PRIMARY -> {}
                default -> {
                    boolean isSecondary = (mi.getPaint() == PaintType.ALLY_SECONDARY);
                    boolean targetSecondary = pattern[2][0];
                    if ((mi.getPaint() == PaintType.EMPTY) || (isSecondary != targetSecondary)) {
                        int d = rc.getLocation().distanceSquaredTo(tmp);
                        if (d < bestDist) {
                            bestDist = d;
                            goal = tmp;
                            secondCol = targetSecondary;
                        }
                    }
                }
            }
        }
        
        
        
        
        
        tmp = new MapLocation(buildTower.x + -1, buildTower.y + 2);
        if (rc.canSenseLocation(tmp)) {
            MapInfo mi = rc.senseMapInfo(tmp);
            switch (mi.getPaint()) {
                case ENEMY_SECONDARY, ENEMY_PRIMARY -> {}
                default -> {
                    boolean isSecondary = (mi.getPaint() == PaintType.ALLY_SECONDARY);
                    boolean targetSecondary = pattern[1][4];
                    if ((mi.getPaint() == PaintType.EMPTY) || (isSecondary != targetSecondary)) {
                        int d = rc.getLocation().distanceSquaredTo(tmp);
                        if (d < bestDist) {
                            bestDist = d;
                            goal = tmp;
                            secondCol = targetSecondary;
                        }
                    }
                }
            }
        }
        
        
        
        tmp = new MapLocation(buildTower.x + -1, buildTower.y + 1);
        if (rc.canSenseLocation(tmp)) {
            MapInfo mi = rc.senseMapInfo(tmp);
            switch (mi.getPaint()) {
                case ENEMY_SECONDARY, ENEMY_PRIMARY -> {}
                default -> {
                    boolean isSecondary = (mi.getPaint() == PaintType.ALLY_SECONDARY);
                    boolean targetSecondary = pattern[1][3];
                    if ((mi.getPaint() == PaintType.EMPTY) || (isSecondary != targetSecondary)) {
                        int d = rc.getLocation().distanceSquaredTo(tmp);
                        if (d < bestDist) {
                            bestDist = d;
                            goal = tmp;
                            secondCol = targetSecondary;
                        }
                    }
                }
            }
        }
        
        
        
        tmp = new MapLocation(buildTower.x + -1, buildTower.y + 0);
        if (rc.canSenseLocation(tmp)) {
            MapInfo mi = rc.senseMapInfo(tmp);
            switch (mi.getPaint()) {
                case ENEMY_SECONDARY, ENEMY_PRIMARY -> {}
                default -> {
                    boolean isSecondary = (mi.getPaint() == PaintType.ALLY_SECONDARY);
                    boolean targetSecondary = pattern[1][2];
                    if ((mi.getPaint() == PaintType.EMPTY) || (isSecondary != targetSecondary)) {
                        int d = rc.getLocation().distanceSquaredTo(tmp);
                        if (d < bestDist) {
                            bestDist = d;
                            goal = tmp;
                            secondCol = targetSecondary;
                        }
                    }
                }
            }
        }
        
        
        
        tmp = new MapLocation(buildTower.x + -1, buildTower.y + -1);
        if (rc.canSenseLocation(tmp)) {
            MapInfo mi = rc.senseMapInfo(tmp);
            switch (mi.getPaint()) {
                case ENEMY_SECONDARY, ENEMY_PRIMARY -> {}
                default -> {
                    boolean isSecondary = (mi.getPaint() == PaintType.ALLY_SECONDARY);
                    boolean targetSecondary = pattern[1][1];
                    if ((mi.getPaint() == PaintType.EMPTY) || (isSecondary != targetSecondary)) {
                        int d = rc.getLocation().distanceSquaredTo(tmp);
                        if (d < bestDist) {
                            bestDist = d;
                            goal = tmp;
                            secondCol = targetSecondary;
                        }
                    }
                }
            }
        }
        
        
        
        tmp = new MapLocation(buildTower.x + -1, buildTower.y + -2);
        if (rc.canSenseLocation(tmp)) {
            MapInfo mi = rc.senseMapInfo(tmp);
            switch (mi.getPaint()) {
                case ENEMY_SECONDARY, ENEMY_PRIMARY -> {}
                default -> {
                    boolean isSecondary = (mi.getPaint() == PaintType.ALLY_SECONDARY);
                    boolean targetSecondary = pattern[1][0];
                    if ((mi.getPaint() == PaintType.EMPTY) || (isSecondary != targetSecondary)) {
                        int d = rc.getLocation().distanceSquaredTo(tmp);
                        if (d < bestDist) {
                            bestDist = d;
                            goal = tmp;
                            secondCol = targetSecondary;
                        }
                    }
                }
            }
        }
        
        
        
        
        
        tmp = new MapLocation(buildTower.x + -2, buildTower.y + 2);
        if (rc.canSenseLocation(tmp)) {
            MapInfo mi = rc.senseMapInfo(tmp);
            switch (mi.getPaint()) {
                case ENEMY_SECONDARY, ENEMY_PRIMARY -> {}
                default -> {
                    boolean isSecondary = (mi.getPaint() == PaintType.ALLY_SECONDARY);
                    boolean targetSecondary = pattern[0][4];
                    if ((mi.getPaint() == PaintType.EMPTY) || (isSecondary != targetSecondary)) {
                        int d = rc.getLocation().distanceSquaredTo(tmp);
                        if (d < bestDist) {
                            bestDist = d;
                            goal = tmp;
                            secondCol = targetSecondary;
                        }
                    }
                }
            }
        }
        
        
        
        tmp = new MapLocation(buildTower.x + -2, buildTower.y + 1);
        if (rc.canSenseLocation(tmp)) {
            MapInfo mi = rc.senseMapInfo(tmp);
            switch (mi.getPaint()) {
                case ENEMY_SECONDARY, ENEMY_PRIMARY -> {}
                default -> {
                    boolean isSecondary = (mi.getPaint() == PaintType.ALLY_SECONDARY);
                    boolean targetSecondary = pattern[0][3];
                    if ((mi.getPaint() == PaintType.EMPTY) || (isSecondary != targetSecondary)) {
                        int d = rc.getLocation().distanceSquaredTo(tmp);
                        if (d < bestDist) {
                            bestDist = d;
                            goal = tmp;
                            secondCol = targetSecondary;
                        }
                    }
                }
            }
        }
        
        
        
        tmp = new MapLocation(buildTower.x + -2, buildTower.y + 0);
        if (rc.canSenseLocation(tmp)) {
            MapInfo mi = rc.senseMapInfo(tmp);
            switch (mi.getPaint()) {
                case ENEMY_SECONDARY, ENEMY_PRIMARY -> {}
                default -> {
                    boolean isSecondary = (mi.getPaint() == PaintType.ALLY_SECONDARY);
                    boolean targetSecondary = pattern[0][2];
                    if ((mi.getPaint() == PaintType.EMPTY) || (isSecondary != targetSecondary)) {
                        int d = rc.getLocation().distanceSquaredTo(tmp);
                        if (d < bestDist) {
                            bestDist = d;
                            goal = tmp;
                            secondCol = targetSecondary;
                        }
                    }
                }
            }
        }
        
        
        
        tmp = new MapLocation(buildTower.x + -2, buildTower.y + -1);
        if (rc.canSenseLocation(tmp)) {
            MapInfo mi = rc.senseMapInfo(tmp);
            switch (mi.getPaint()) {
                case ENEMY_SECONDARY, ENEMY_PRIMARY -> {}
                default -> {
                    boolean isSecondary = (mi.getPaint() == PaintType.ALLY_SECONDARY);
                    boolean targetSecondary = pattern[0][1];
                    if ((mi.getPaint() == PaintType.EMPTY) || (isSecondary != targetSecondary)) {
                        int d = rc.getLocation().distanceSquaredTo(tmp);
                        if (d < bestDist) {
                            bestDist = d;
                            goal = tmp;
                            secondCol = targetSecondary;
                        }
                    }
                }
            }
        }
        
        
        
        tmp = new MapLocation(buildTower.x + -2, buildTower.y + -2);
        if (rc.canSenseLocation(tmp)) {
            MapInfo mi = rc.senseMapInfo(tmp);
            switch (mi.getPaint()) {
                case ENEMY_SECONDARY, ENEMY_PRIMARY -> {}
                default -> {
                    boolean isSecondary = (mi.getPaint() == PaintType.ALLY_SECONDARY);
                    boolean targetSecondary = pattern[0][0];
                    if ((mi.getPaint() == PaintType.EMPTY) || (isSecondary != targetSecondary)) {
                        int d = rc.getLocation().distanceSquaredTo(tmp);
                        if (d < bestDist) {
                            bestDist = d;
                            goal = tmp;
                            secondCol = targetSecondary;
                        }
                    }
                }
            }
        }
        
        
        

        if (goal != null) {
            if (rc.canAttack(goal)) {
                rc.setIndicatorDot(goal, 255, 0, 0);
                rc.attack(goal, secondCol);
            }
            else {
                Pathing.pathTo(goal);
            }
        }
        else {
            if (rc.canCompleteTowerPattern(UnitType.LEVEL_ONE_PAINT_TOWER, buildTower)) {
                rc.completeTowerPattern(UnitType.LEVEL_ONE_PAINT_TOWER, buildTower);
            }
            if (rc.canCompleteTowerPattern(UnitType.LEVEL_ONE_MONEY_TOWER, buildTower)) {
                rc.completeTowerPattern(UnitType.LEVEL_ONE_MONEY_TOWER, buildTower);
            }
            Pathing.pathTo(buildTower);
        }
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

    public static boolean shouldVisit(MapLocation m) throws GameActionException {
        if (!rc.canSenseLocation(m)) return false;
        boolean ok = false;
        for (int i = 2; --i >= -1;) {
            for (int j = 2; --j >= -1;) {
                MapLocation cur = new MapLocation(m.x + i, m.y + j);
                if (rc.canSenseLocation(cur)) {
                    MapInfo mi = rc.senseMapInfo(cur);
                    if (mi.getMark() != PaintType.EMPTY) return false;
                    if (!mi.isPassable()) return false;
                    if (mi.getPaint() == PaintType.EMPTY) ok = true;
                    else if (!mi.getPaint().isAlly()) return false;
                    boolean b = shouldUseSecond(cur);
                    if (b != (mi.getPaint() == PaintType.ALLY_SECONDARY)) {
                        ok = true;
                    }
                    if (cur == rc.getLocation()) continue;
                    RobotInfo r = rc.senseRobotAtLocation(cur);
                    if (r != null && r.getTeam() == rc.getTeam() && r.getType() == UnitType.SOLDIER) return false;
                }
            }
        }
        return (!visited(m) && ok); 
    }

    public static void moneyPattern() throws GameActionException {
        if (markedResource != null) return;
        if (ruinLoc != null && rc.getNumberTowers() < 25) return;
        if (rc.getPaint() < 50) return;

        if (chunkGoal == null) {
            int dist = 1000000000;
            MapLocation g = getLowerCenter(rc.getLocation());
            MapLocation h;
            ArrayList<Integer> p = new ArrayList<>();
            for (int i = 0; i <= 4; i++) p.add(i);
            Collections.shuffle(p);
            for (int i = 5; --i >= 0;) {
                if (useOdd(g)) h = new MapLocation(g.x + oddChunkDx[p.get(i)], g.y + oddChunkDy[p.get(i)]);
                else h = new MapLocation(g.x + evenChunkDx[p.get(i)], g.y + evenChunkDy[p.get(i)]);
                if (shouldVisit(h)) {
                    int d = rc.getLocation().distanceSquaredTo(h);
                    if (d < dist) {
                        dist = d;
                        chunkGoal = h;
                    }
                }
            }
        }

        if (chunkGoal != null) {
            if (!rc.getLocation().equals(chunkGoal)) {
                Pathing.pathTo(chunkGoal);
            }
        }
        else return;

        MapLocation c = getLowerCenter(rc.getLocation());
        if (!c.equals(rc.getLocation())) return;

        boolean bad = false;
        for (int i = 3; --i >= -2; ){
            if (bad) break;
            for (int j = 3; --j >= -2; ){
                MapLocation tmp = new MapLocation(rc.getLocation().x + i, rc.getLocation().y + j);
                if (rc.canSenseLocation(tmp)) {
                    MapInfo mi = rc.senseMapInfo(tmp);
                    if (mi.getMark() != PaintType.EMPTY) {
                        if (resourcePat[i + 2][j + 2] != (mi.getMark() == PaintType.ALLY_SECONDARY)) {
                            bad = true;
                            break;
                        }
                    }
                    if (!mi.isPassable()) {
                        bad = true;
                        break;
                    }
                    RobotInfo r = rc.senseRobotAtLocation(tmp);
                    if (r != null && Globals.isTower(r.getType())) {
                        bad = true;
                        break;
                    }
                }
                else {
                    bad = true;
                    break;
                }
            }
        }
        if (!bad) {
            //i think this check can probably be removed...
            if (rc.canMarkResourcePattern(rc.getLocation())) {
                markedResource = rc.getLocation();
                chunkGoal = null;
            }
        }
        else {
            chunkGoal = null;
        }
    }

    public static void makeResourcePatch() throws GameActionException {
        Pathing.pathTo(markedResource);
        MapLocation goal = null;
        int bestDist = 1000000000;
        boolean secondCol = false;
        for (int i = 3; --i >= -2; ){
            for (int j = 3; --j >= -2; ){
                if (i == 0 && j == 0) continue;
                MapLocation tmp = new MapLocation(markedResource.x + i, markedResource.y + j);
                if (rc.canSenseLocation(tmp)) {
                    MapInfo mi = rc.senseMapInfo(tmp);
                    if (canChangeColor(mi)) {
                        boolean b = shouldUseSecond(tmp);
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
        // We do this every turn in the event the tower got destroyed when the unit was created.
        setHome();
        if (resourcePat == null) resourcePat = rc.getResourcePattern();
        myloc = rc.getLocation();
        myPaint = rc.getPaint();
    }
    
    public static void runTurn() throws GameActionException {
        boolean shouldGoHome = (myPaint <= (paintCapacity >> 2));
        if (shouldGoHome && home != null) {
            rc.setIndicatorString("Refueling");
            refuel();
            return;
        } else if (Attack.shouldSoldierMicro()) {
            rc.setIndicatorString("Attacking");
            Attack.soldierAttackMicro();
            return;
        } else if (shouldGoHome && home == null) {
            rc.setIndicatorString("Exploring on Paint");
            Explore.exploreOnPaint(near);
            return;
        } else if (rc.getNumberTowers() < 25 && markedResource == null) {
            buildTower = null;
            ruinLoc = seeRuin();
            if (ruinLoc != null) {
                boolean incRuin = Globals.seeIncompleteRuin(ruinLoc);
                if (incRuin){
                    buildTower = ruinLoc;
                }
                else if (ruinLoc != null && rc.getMoney() >= 1000) {
                    buildTower = ruinLoc;   
                }

                if (buildTower != null) {
                    rc.setIndicatorString("Building a tower + (" + buildTower.x + ", " + buildTower.y + ")");
                    makeTower();
                    return;
                }
            }
        }

        moneyPattern();
        
        if (markedResource != null) {
            rc.setIndicatorString("Patching Resource");
            makeResourcePatch();
            return;
        }


        Explore.explore(near);
        
    }

    public static void postTurn() throws GameActionException {

        // Lay paint where I am first.
        if (canChangeColor(myloc) && rc.canAttack(myloc) && okToTile(myloc) && rc.getPaint() >= 50){
            rc.attack(myloc, shouldUseSecond(myloc));
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