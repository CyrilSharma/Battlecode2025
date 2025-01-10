

package jan10;
import battlecode.common.*;

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
    public static MapLocation removing = null;
    public static int removeMask = 0;
    public static boolean[][] resourcePat = null;

    public static void init(RobotController rc) {
        Soldier.rc = rc;
    }

    public static boolean isTower(UnitType u) {
        return (u == UnitType.LEVEL_ONE_PAINT_TOWER ||
                u == UnitType.LEVEL_ONE_MONEY_TOWER ||
                u == UnitType.LEVEL_ONE_DEFENSE_TOWER ||
                u == UnitType.LEVEL_TWO_PAINT_TOWER ||
                u == UnitType.LEVEL_TWO_MONEY_TOWER ||
                u == UnitType.LEVEL_TWO_DEFENSE_TOWER ||
                u == UnitType.LEVEL_THREE_PAINT_TOWER ||
                u == UnitType.LEVEL_THREE_MONEY_TOWER ||
                u == UnitType.LEVEL_THREE_DEFENSE_TOWER);
    }

    public static boolean canChangeColor(MapInfo mi) throws GameActionException {
        return (mi.getPaint().isAlly() || mi.getPaint() == PaintType.EMPTY);
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
            if (robot.team == rc.getTeam() && robot.paintAmount > 0 && isTower(robot.type)) {
                home = robot.location;
                break loop;
            }
        
            if (1 >= robots.length) break loop;
            robot = robots[1];
            if (robot.team == rc.getTeam() && robot.paintAmount > 0 && isTower(robot.type)) {
                home = robot.location;
                break loop;
            }
        
            if (2 >= robots.length) break loop;
            robot = robots[2];
            if (robot.team == rc.getTeam() && robot.paintAmount > 0 && isTower(robot.type)) {
                home = robot.location;
                break loop;
            }
        
            if (3 >= robots.length) break loop;
            robot = robots[3];
            if (robot.team == rc.getTeam() && robot.paintAmount > 0 && isTower(robot.type)) {
                home = robot.location;
                break loop;
            }
        
            if (4 >= robots.length) break loop;
            robot = robots[4];
            if (robot.team == rc.getTeam() && robot.paintAmount > 0 && isTower(robot.type)) {
                home = robot.location;
                break loop;
            }
        
            if (5 >= robots.length) break loop;
            robot = robots[5];
            if (robot.team == rc.getTeam() && robot.paintAmount > 0 && isTower(robot.type)) {
                home = robot.location;
                break loop;
            }
        
            if (6 >= robots.length) break loop;
            robot = robots[6];
            if (robot.team == rc.getTeam() && robot.paintAmount > 0 && isTower(robot.type)) {
                home = robot.location;
                break loop;
            }
        
            if (7 >= robots.length) break loop;
            robot = robots[7];
            if (robot.team == rc.getTeam() && robot.paintAmount > 0 && isTower(robot.type)) {
                home = robot.location;
                break loop;
            }
        
            if (8 >= robots.length) break loop;
            robot = robots[8];
            if (robot.team == rc.getTeam() && robot.paintAmount > 0 && isTower(robot.type)) {
                home = robot.location;
                break loop;
            }
        
            if (9 >= robots.length) break loop;
            robot = robots[9];
            if (robot.team == rc.getTeam() && robot.paintAmount > 0 && isTower(robot.type)) {
                home = robot.location;
                break loop;
            }
        
            if (10 >= robots.length) break loop;
            robot = robots[10];
            if (robot.team == rc.getTeam() && robot.paintAmount > 0 && isTower(robot.type)) {
                home = robot.location;
                break loop;
            }
        
            if (11 >= robots.length) break loop;
            robot = robots[11];
            if (robot.team == rc.getTeam() && robot.paintAmount > 0 && isTower(robot.type)) {
                home = robot.location;
                break loop;
            }
        
            if (12 >= robots.length) break loop;
            robot = robots[12];
            if (robot.team == rc.getTeam() && robot.paintAmount > 0 && isTower(robot.type)) {
                home = robot.location;
                break loop;
            }
        
            if (13 >= robots.length) break loop;
            robot = robots[13];
            if (robot.team == rc.getTeam() && robot.paintAmount > 0 && isTower(robot.type)) {
                home = robot.location;
                break loop;
            }
        
            if (14 >= robots.length) break loop;
            robot = robots[14];
            if (robot.team == rc.getTeam() && robot.paintAmount > 0 && isTower(robot.type)) {
                home = robot.location;
                break loop;
            }
        
            if (15 >= robots.length) break loop;
            robot = robots[15];
            if (robot.team == rc.getTeam() && robot.paintAmount > 0 && isTower(robot.type)) {
                home = robot.location;
                break loop;
            }
        
            if (16 >= robots.length) break loop;
            robot = robots[16];
            if (robot.team == rc.getTeam() && robot.paintAmount > 0 && isTower(robot.type)) {
                home = robot.location;
                break loop;
            }
        
            if (17 >= robots.length) break loop;
            robot = robots[17];
            if (robot.team == rc.getTeam() && robot.paintAmount > 0 && isTower(robot.type)) {
                home = robot.location;
                break loop;
            }
        
            if (18 >= robots.length) break loop;
            robot = robots[18];
            if (robot.team == rc.getTeam() && robot.paintAmount > 0 && isTower(robot.type)) {
                home = robot.location;
                break loop;
            }
        
            if (19 >= robots.length) break loop;
            robot = robots[19];
            if (robot.team == rc.getTeam() && robot.paintAmount > 0 && isTower(robot.type)) {
                home = robot.location;
                break loop;
            }
        
            if (20 >= robots.length) break loop;
            robot = robots[20];
            if (robot.team == rc.getTeam() && robot.paintAmount > 0 && isTower(robot.type)) {
                home = robot.location;
                break loop;
            }
        
            if (21 >= robots.length) break loop;
            robot = robots[21];
            if (robot.team == rc.getTeam() && robot.paintAmount > 0 && isTower(robot.type)) {
                home = robot.location;
                break loop;
            }
        
            if (22 >= robots.length) break loop;
            robot = robots[22];
            if (robot.team == rc.getTeam() && robot.paintAmount > 0 && isTower(robot.type)) {
                home = robot.location;
                break loop;
            }
        
            if (23 >= robots.length) break loop;
            robot = robots[23];
            if (robot.team == rc.getTeam() && robot.paintAmount > 0 && isTower(robot.type)) {
                home = robot.location;
                break loop;
            }
        
            if (24 >= robots.length) break loop;
            robot = robots[24];
            if (robot.team == rc.getTeam() && robot.paintAmount > 0 && isTower(robot.type)) {
                home = robot.location;
                break loop;
            }
        
            if (25 >= robots.length) break loop;
            robot = robots[25];
            if (robot.team == rc.getTeam() && robot.paintAmount > 0 && isTower(robot.type)) {
                home = robot.location;
                break loop;
            }
        
            if (26 >= robots.length) break loop;
            robot = robots[26];
            if (robot.team == rc.getTeam() && robot.paintAmount > 0 && isTower(robot.type)) {
                home = robot.location;
                break loop;
            }
        
            if (27 >= robots.length) break loop;
            robot = robots[27];
            if (robot.team == rc.getTeam() && robot.paintAmount > 0 && isTower(robot.type)) {
                home = robot.location;
                break loop;
            }
        
            if (28 >= robots.length) break loop;
            robot = robots[28];
            if (robot.team == rc.getTeam() && robot.paintAmount > 0 && isTower(robot.type)) {
                home = robot.location;
                break loop;
            }
        
            if (29 >= robots.length) break loop;
            robot = robots[29];
            if (robot.team == rc.getTeam() && robot.paintAmount > 0 && isTower(robot.type)) {
                home = robot.location;
                break loop;
            }
        
            if (30 >= robots.length) break loop;
            robot = robots[30];
            if (robot.team == rc.getTeam() && robot.paintAmount > 0 && isTower(robot.type)) {
                home = robot.location;
                break loop;
            }
        
            if (31 >= robots.length) break loop;
            robot = robots[31];
            if (robot.team == rc.getTeam() && robot.paintAmount > 0 && isTower(robot.type)) {
                home = robot.location;
                break loop;
            }
        
            if (32 >= robots.length) break loop;
            robot = robots[32];
            if (robot.team == rc.getTeam() && robot.paintAmount > 0 && isTower(robot.type)) {
                home = robot.location;
                break loop;
            }
        
            if (33 >= robots.length) break loop;
            robot = robots[33];
            if (robot.team == rc.getTeam() && robot.paintAmount > 0 && isTower(robot.type)) {
                home = robot.location;
                break loop;
            }
        
            if (34 >= robots.length) break loop;
            robot = robots[34];
            if (robot.team == rc.getTeam() && robot.paintAmount > 0 && isTower(robot.type)) {
                home = robot.location;
                break loop;
            }
        
            if (35 >= robots.length) break loop;
            robot = robots[35];
            if (robot.team == rc.getTeam() && robot.paintAmount > 0 && isTower(robot.type)) {
                home = robot.location;
                break loop;
            }
        
            if (36 >= robots.length) break loop;
            robot = robots[36];
            if (robot.team == rc.getTeam() && robot.paintAmount > 0 && isTower(robot.type)) {
                home = robot.location;
                break loop;
            }
        
            if (37 >= robots.length) break loop;
            robot = robots[37];
            if (robot.team == rc.getTeam() && robot.paintAmount > 0 && isTower(robot.type)) {
                home = robot.location;
                break loop;
            }
        
            if (38 >= robots.length) break loop;
            robot = robots[38];
            if (robot.team == rc.getTeam() && robot.paintAmount > 0 && isTower(robot.type)) {
                home = robot.location;
                break loop;
            }
        
            if (39 >= robots.length) break loop;
            robot = robots[39];
            if (robot.team == rc.getTeam() && robot.paintAmount > 0 && isTower(robot.type)) {
                home = robot.location;
                break loop;
            }
        
            if (40 >= robots.length) break loop;
            robot = robots[40];
            if (robot.team == rc.getTeam() && robot.paintAmount > 0 && isTower(robot.type)) {
                home = robot.location;
                break loop;
            }
        
            if (41 >= robots.length) break loop;
            robot = robots[41];
            if (robot.team == rc.getTeam() && robot.paintAmount > 0 && isTower(robot.type)) {
                home = robot.location;
                break loop;
            }
        
            if (42 >= robots.length) break loop;
            robot = robots[42];
            if (robot.team == rc.getTeam() && robot.paintAmount > 0 && isTower(robot.type)) {
                home = robot.location;
                break loop;
            }
        
            if (43 >= robots.length) break loop;
            robot = robots[43];
            if (robot.team == rc.getTeam() && robot.paintAmount > 0 && isTower(robot.type)) {
                home = robot.location;
                break loop;
            }
        
            if (44 >= robots.length) break loop;
            robot = robots[44];
            if (robot.team == rc.getTeam() && robot.paintAmount > 0 && isTower(robot.type)) {
                home = robot.location;
                break loop;
            }
        
            if (45 >= robots.length) break loop;
            robot = robots[45];
            if (robot.team == rc.getTeam() && robot.paintAmount > 0 && isTower(robot.type)) {
                home = robot.location;
                break loop;
            }
        
            if (46 >= robots.length) break loop;
            robot = robots[46];
            if (robot.team == rc.getTeam() && robot.paintAmount > 0 && isTower(robot.type)) {
                home = robot.location;
                break loop;
            }
        
            if (47 >= robots.length) break loop;
            robot = robots[47];
            if (robot.team == rc.getTeam() && robot.paintAmount > 0 && isTower(robot.type)) {
                home = robot.location;
                break loop;
            }
        
            if (48 >= robots.length) break loop;
            robot = robots[48];
            if (robot.team == rc.getTeam() && robot.paintAmount > 0 && isTower(robot.type)) {
                home = robot.location;
                break loop;
            }
        
            if (49 >= robots.length) break loop;
            robot = robots[49];
            if (robot.team == rc.getTeam() && robot.paintAmount > 0 && isTower(robot.type)) {
                home = robot.location;
                break loop;
            }
        
            if (50 >= robots.length) break loop;
            robot = robots[50];
            if (robot.team == rc.getTeam() && robot.paintAmount > 0 && isTower(robot.type)) {
                home = robot.location;
                break loop;
            }
        
            if (51 >= robots.length) break loop;
            robot = robots[51];
            if (robot.team == rc.getTeam() && robot.paintAmount > 0 && isTower(robot.type)) {
                home = robot.location;
                break loop;
            }
        
            if (52 >= robots.length) break loop;
            robot = robots[52];
            if (robot.team == rc.getTeam() && robot.paintAmount > 0 && isTower(robot.type)) {
                home = robot.location;
                break loop;
            }
        
            if (53 >= robots.length) break loop;
            robot = robots[53];
            if (robot.team == rc.getTeam() && robot.paintAmount > 0 && isTower(robot.type)) {
                home = robot.location;
                break loop;
            }
        
            if (54 >= robots.length) break loop;
            robot = robots[54];
            if (robot.team == rc.getTeam() && robot.paintAmount > 0 && isTower(robot.type)) {
                home = robot.location;
                break loop;
            }
        
            if (55 >= robots.length) break loop;
            robot = robots[55];
            if (robot.team == rc.getTeam() && robot.paintAmount > 0 && isTower(robot.type)) {
                home = robot.location;
                break loop;
            }
        
            if (56 >= robots.length) break loop;
            robot = robots[56];
            if (robot.team == rc.getTeam() && robot.paintAmount > 0 && isTower(robot.type)) {
                home = robot.location;
                break loop;
            }
        
            if (57 >= robots.length) break loop;
            robot = robots[57];
            if (robot.team == rc.getTeam() && robot.paintAmount > 0 && isTower(robot.type)) {
                home = robot.location;
                break loop;
            }
        
            if (58 >= robots.length) break loop;
            robot = robots[58];
            if (robot.team == rc.getTeam() && robot.paintAmount > 0 && isTower(robot.type)) {
                home = robot.location;
                break loop;
            }
        
            if (59 >= robots.length) break loop;
            robot = robots[59];
            if (robot.team == rc.getTeam() && robot.paintAmount > 0 && isTower(robot.type)) {
                home = robot.location;
                break loop;
            }
        
            if (60 >= robots.length) break loop;
            robot = robots[60];
            if (robot.team == rc.getTeam() && robot.paintAmount > 0 && isTower(robot.type)) {
                home = robot.location;
                break loop;
            }
        
            if (61 >= robots.length) break loop;
            robot = robots[61];
            if (robot.team == rc.getTeam() && robot.paintAmount > 0 && isTower(robot.type)) {
                home = robot.location;
                break loop;
            }
        
            if (62 >= robots.length) break loop;
            robot = robots[62];
            if (robot.team == rc.getTeam() && robot.paintAmount > 0 && isTower(robot.type)) {
                home = robot.location;
                break loop;
            }
        
            if (63 >= robots.length) break loop;
            robot = robots[63];
            if (robot.team == rc.getTeam() && robot.paintAmount > 0 && isTower(robot.type)) {
                home = robot.location;
                break loop;
            }
        
            if (64 >= robots.length) break loop;
            robot = robots[64];
            if (robot.team == rc.getTeam() && robot.paintAmount > 0 && isTower(robot.type)) {
                home = robot.location;
                break loop;
            }
        
            if (65 >= robots.length) break loop;
            robot = robots[65];
            if (robot.team == rc.getTeam() && robot.paintAmount > 0 && isTower(robot.type)) {
                home = robot.location;
                break loop;
            }
        
            if (66 >= robots.length) break loop;
            robot = robots[66];
            if (robot.team == rc.getTeam() && robot.paintAmount > 0 && isTower(robot.type)) {
                home = robot.location;
                break loop;
            }
        
            if (67 >= robots.length) break loop;
            robot = robots[67];
            if (robot.team == rc.getTeam() && robot.paintAmount > 0 && isTower(robot.type)) {
                home = robot.location;
                break loop;
            }
        
            if (68 >= robots.length) break loop;
            robot = robots[68];
            if (robot.team == rc.getTeam() && robot.paintAmount > 0 && isTower(robot.type)) {
                home = robot.location;
                break loop;
            }
        
            if (69 >= robots.length) break loop;
            robot = robots[69];
            if (robot.team == rc.getTeam() && robot.paintAmount > 0 && isTower(robot.type)) {
                home = robot.location;
                break loop;
            }
        
        }
    }

    public static void refuel() throws GameActionException {
        Pathing.pathTo(home);
        if (rc.canSenseLocation(home)) {
            RobotInfo r = rc.senseRobotAtLocation(home);
            int amt = Math.max(myPaint - paintCapacity, -r.getPaintAmount());
            if (rc.canTransferPaint(home, amt)) {
                rc.transferPaint(home, amt);
            }
        }
    }

    public static MapLocation seeRuin() throws GameActionException {
        for (int i = near.length; --i >= 0; ) {
            if (near[i].hasRuin()) {
                RobotInfo r = rc.senseRobotAtLocation(near[i].getMapLocation());
                if (r == null) {
                    return near[i].getMapLocation();
                }
            }
        }
        return null;
    }

    public static UnitType getTowerToBuild() throws GameActionException {
        if (rc.getNumberTowers() < 3) return UnitType.LEVEL_ONE_MONEY_TOWER;
        return UnitType.LEVEL_ONE_PAINT_TOWER;
    }

    public static void makeTower() throws GameActionException {
        assert(buildTower != null);

        UnitType t = getTowerToBuild();
        MapLocation check = buildTower.add(Direction.NORTH);
        if (rc.canSenseLocation(check) && rc.senseMapInfo(check).getMark() == PaintType.EMPTY && rc.canMarkTowerPattern(t, buildTower)){
            rc.markTowerPattern(t, buildTower);
        }

        MapLocation goal = null;
        boolean secondCol = false;
        int bestDist = 1000000000;

        for (int i = 3; --i >= -2; ){
            for (int j = 3; --j >= -2; ){
                if (i == 0 && j == 0) continue;
                MapLocation tmp = new MapLocation(buildTower.x + i, buildTower.y + j);
                if (rc.canSenseLocation(tmp)) {
                    MapInfo mi = rc.senseMapInfo(tmp);
                    if (mi.getMark() != mi.getPaint() && mi.getMark() != PaintType.EMPTY && canChangeColor(mi)) {
                        int d = rc.getLocation().distanceSquaredTo(tmp);
                        if (d < bestDist) {
                            bestDist = d;
                            goal = tmp;
                            secondCol = mi.getMark() == PaintType.ALLY_SECONDARY;
                        }
                    }
                }
            }
        }
        if (goal != null) {
            if (rc.canAttack(goal)) {
                rc.attack(goal, secondCol);
            }
            else {
                Pathing.pathTo(goal);
            }
        }
        else {
            if (rc.canCompleteTowerPattern(UnitType.LEVEL_ONE_PAINT_TOWER, buildTower)){
                rc.completeTowerPattern(UnitType.LEVEL_ONE_PAINT_TOWER, buildTower);
                removing = buildTower;
                removeMask = (1 << 25) - 1;
            }
            if (rc.canCompleteTowerPattern(UnitType.LEVEL_ONE_MONEY_TOWER, buildTower)){
                rc.completeTowerPattern(UnitType.LEVEL_ONE_MONEY_TOWER, buildTower);
                removing = buildTower;
                removeMask = (1 << 25) - 1;
            }
            Pathing.pathTo(buildTower);
        }
    }

    public static boolean isBuilt(MapLocation ruinLoc) throws GameActionException {
        if (rc.canSenseLocation(ruinLoc)) {
            RobotInfo r = rc.senseRobotAtLocation(ruinLoc);
            return (r != null);
        }
        return false;
    }

    public static void moneyPattern() throws GameActionException {
        //make sure we see no ruins
        //and make sure nothing in the 5 by 5 is marked
        if (ruinLoc != null && rc.getNumberTowers() < 25) return;
        if (rc.getPaint() < 20) return;
        if (rc.getNumberTowers() < 4) return;
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
                rc.markResourcePattern(rc.getLocation());
                markedResource = rc.getLocation();
            }
        }
    }

    public static boolean paintMarkedSquares() throws GameActionException {
        if (rc.getPaint() < 20) return false;
        MapLocation goal = null;
        int bestDist = 1000000000;
        boolean secondCol = false;
        for (int i = near.length; --i >= 0; ) {
            if (near[i].getMark() != PaintType.EMPTY && near[i].getMark() != near[i].getPaint() && canChangeColor(near[i])) {
                int d = rc.getLocation().distanceSquaredTo(near[i].getMapLocation());
                if (d < bestDist) {
                    bestDist = d;
                    goal = near[i].getMapLocation();
                    secondCol = (near[i].getMark() == PaintType.ALLY_SECONDARY);
                }
            }
        }
        if (goal != null) {
            if (rc.canAttack(goal)) {
                rc.attack(goal, secondCol);
            }
            else {
                Pathing.pathTo(goal);
            }
            return true;
        }
        return false;
    }

    public static boolean seeIncompleteRuin(MapLocation ruin) throws GameActionException {
        for (int i = 3; --i >= -2; ){
            for (int j = 3; --j >= -2; ){
                if (i == 0 && j == 0) continue;
                MapLocation tmp = new MapLocation(ruin.x + i, ruin.y + j);
                if (rc.canSenseLocation(tmp)) {
                    MapInfo mi = rc.senseMapInfo(tmp);
                    if ((mi.getMark() != mi.getPaint() || mi.getMark() == PaintType.EMPTY) && canChangeColor(mi)) {
                        return true;
                    }
                }
            }
        }
        return false;
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
                    if (mi.getMark() != mi.getPaint() && mi.getMark() != PaintType.EMPTY && canChangeColor(mi)) {
                        int d = rc.getLocation().distanceSquaredTo(tmp);
                        if (d < bestDist) {
                            bestDist = d;
                            goal = tmp;
                            secondCol = (mi.getMark() == PaintType.ALLY_SECONDARY);
                        }
                    }
                }
            }
        }
        if (goal != null) {
            if (rc.canAttack(goal)) {
                rc.attack(goal, secondCol);
            }
        }
        if (rc.canCompleteResourcePattern(markedResource)) {
            rc.completeResourcePattern(markedResource);
            markedResource = null;
        }
    }

    public static void removePattern() throws GameActionException {
        MapLocation goal = removing;
        for (int i = 3; --i >= -2; ){
            for (int j = 3; --j >= -2; ){
                if (i == 0 && j == 0) continue;
                MapLocation tmp = new MapLocation(removing.x + i, removing.y + j);
                int v = (i + 2) * 5 + (j + 2);
                if ((removeMask & (1 << v)) != 0) {
                    if (rc.canRemoveMark(tmp)) {
                        removeMask ^= (1 << v);
                        rc.removeMark(tmp);
                    }
                    else if (v != 12) {
                        goal = tmp;
                    }
                }
            }
        }
        if (removeMask == (1 << 12)) {
            removing = null;
            removeMask = 0;
        }
        else {
            Pathing.pathTo(goal);
        }
    }

    public static void run() throws GameActionException {
        near = rc.senseNearbyMapInfos();
        // We do this every turn in the event the tower got destroyed when the unit was created.
        setHome();
        if (resourcePat == null) resourcePat = rc.getResourcePattern();

        myloc = rc.getLocation();
        myPaint = rc.getPaint();

        if (myPaint <= (paintCapacity >> 2)) {
            if (home != null) {
                refuel();
            }
            else {
                Explore.exploreOnPaint(near);
            }
            return;
        }
        else if (rc.getNumberTowers() < 25 && markedResource == null && removing == null){
            buildTower = null;
            ruinLoc = seeRuin();
            if (ruinLoc != null) {
                boolean incRuin = seeIncompleteRuin(ruinLoc);

                if (incRuin){
                    buildTower = ruinLoc;
                }
                else if (ruinLoc != null && rc.getMoney() >= 1000) {
                    buildTower = ruinLoc;   
                }

                if (buildTower != null) {
                    makeTower();
                }
            }
        }
        
        if (markedResource != null) {
            makeResourcePatch();
            return;
        }

        if (removing != null) {
            removePattern();
            return;
        }

        moneyPattern();
        if(!paintMarkedSquares()) Explore.explore(near);

        // Lay paint where I am first.
        MapInfo currentTile = rc.senseMapInfo(myloc);
        if (!currentTile.getPaint().isAlly() && rc.canAttack(myloc)){
            rc.attack(myloc);
        }

        // Paint around me.
        
    }
}