package jan19_3_49;
import java.util.Random;
import battlecode.common.*;

public class Globals {
    public static RobotController rc;
    public static final Random rng = new Random();
    public static boolean[][] moneyTower;
    public static boolean[][] paintTower;
    public static void init(RobotController rc) throws GameActionException {
        rng.setSeed((long) rc.getID());
        Globals.rc = rc;
        moneyTower = rc.getTowerPattern(UnitType.LEVEL_ONE_MONEY_TOWER);
        paintTower = rc.getTowerPattern(UnitType.LEVEL_ONE_PAINT_TOWER);
    }

    public static RobotInfo[] friends;
    public static RobotInfo[] enemies;
    public static void run() throws GameActionException {
        friends = rc.senseNearbyRobots(-1, rc.getTeam());
        enemies = rc.senseNearbyRobots(-1, rc.getTeam().opponent());
    }

    public static UnitType getTowerToBuild(MapLocation loc) throws GameActionException {
        int pt = 0, mt = 0;
        MapLocation tmp;
        String s = "";
        
        
        
        tmp = new MapLocation(loc.x + 2, loc.y + 2);
        if (rc.canSenseLocation(tmp)) {
            MapInfo mi = rc.senseMapInfo(tmp);
            if (mi.getPaint().isAlly()) {
                if ((mi.getPaint() == PaintType.ALLY_SECONDARY) == paintTower[2 + (tmp.x - loc.x)][2 + (tmp.y - loc.y)]) {
                    pt++;
                }
                if ((mi.getPaint() == PaintType.ALLY_SECONDARY) == moneyTower[2 + (tmp.x - loc.x)][2 + (tmp.y - loc.y)]) {
                    mt++;
                }
            }
        }
        
        
        
        tmp = new MapLocation(loc.x + 2, loc.y + 1);
        if (rc.canSenseLocation(tmp)) {
            MapInfo mi = rc.senseMapInfo(tmp);
            if (mi.getPaint().isAlly()) {
                if ((mi.getPaint() == PaintType.ALLY_SECONDARY) == paintTower[2 + (tmp.x - loc.x)][2 + (tmp.y - loc.y)]) {
                    pt++;
                }
                if ((mi.getPaint() == PaintType.ALLY_SECONDARY) == moneyTower[2 + (tmp.x - loc.x)][2 + (tmp.y - loc.y)]) {
                    mt++;
                }
            }
        }
        
        
        
        tmp = new MapLocation(loc.x + 2, loc.y + 0);
        if (rc.canSenseLocation(tmp)) {
            MapInfo mi = rc.senseMapInfo(tmp);
            if (mi.getPaint().isAlly()) {
                if ((mi.getPaint() == PaintType.ALLY_SECONDARY) == paintTower[2 + (tmp.x - loc.x)][2 + (tmp.y - loc.y)]) {
                    pt++;
                }
                if ((mi.getPaint() == PaintType.ALLY_SECONDARY) == moneyTower[2 + (tmp.x - loc.x)][2 + (tmp.y - loc.y)]) {
                    mt++;
                }
            }
        }
        
        
        
        tmp = new MapLocation(loc.x + 2, loc.y + -1);
        if (rc.canSenseLocation(tmp)) {
            MapInfo mi = rc.senseMapInfo(tmp);
            if (mi.getPaint().isAlly()) {
                if ((mi.getPaint() == PaintType.ALLY_SECONDARY) == paintTower[2 + (tmp.x - loc.x)][2 + (tmp.y - loc.y)]) {
                    pt++;
                }
                if ((mi.getPaint() == PaintType.ALLY_SECONDARY) == moneyTower[2 + (tmp.x - loc.x)][2 + (tmp.y - loc.y)]) {
                    mt++;
                }
            }
        }
        
        
        
        tmp = new MapLocation(loc.x + 2, loc.y + -2);
        if (rc.canSenseLocation(tmp)) {
            MapInfo mi = rc.senseMapInfo(tmp);
            if (mi.getPaint().isAlly()) {
                if ((mi.getPaint() == PaintType.ALLY_SECONDARY) == paintTower[2 + (tmp.x - loc.x)][2 + (tmp.y - loc.y)]) {
                    pt++;
                }
                if ((mi.getPaint() == PaintType.ALLY_SECONDARY) == moneyTower[2 + (tmp.x - loc.x)][2 + (tmp.y - loc.y)]) {
                    mt++;
                }
            }
        }
        
        
        
        
        
        tmp = new MapLocation(loc.x + 1, loc.y + 2);
        if (rc.canSenseLocation(tmp)) {
            MapInfo mi = rc.senseMapInfo(tmp);
            if (mi.getPaint().isAlly()) {
                if ((mi.getPaint() == PaintType.ALLY_SECONDARY) == paintTower[2 + (tmp.x - loc.x)][2 + (tmp.y - loc.y)]) {
                    pt++;
                }
                if ((mi.getPaint() == PaintType.ALLY_SECONDARY) == moneyTower[2 + (tmp.x - loc.x)][2 + (tmp.y - loc.y)]) {
                    mt++;
                }
            }
        }
        
        
        
        tmp = new MapLocation(loc.x + 1, loc.y + 1);
        if (rc.canSenseLocation(tmp)) {
            MapInfo mi = rc.senseMapInfo(tmp);
            if (mi.getPaint().isAlly()) {
                if ((mi.getPaint() == PaintType.ALLY_SECONDARY) == paintTower[2 + (tmp.x - loc.x)][2 + (tmp.y - loc.y)]) {
                    pt++;
                }
                if ((mi.getPaint() == PaintType.ALLY_SECONDARY) == moneyTower[2 + (tmp.x - loc.x)][2 + (tmp.y - loc.y)]) {
                    mt++;
                }
            }
        }
        
        
        
        tmp = new MapLocation(loc.x + 1, loc.y + 0);
        if (rc.canSenseLocation(tmp)) {
            MapInfo mi = rc.senseMapInfo(tmp);
            if (mi.getPaint().isAlly()) {
                if ((mi.getPaint() == PaintType.ALLY_SECONDARY) == paintTower[2 + (tmp.x - loc.x)][2 + (tmp.y - loc.y)]) {
                    pt++;
                }
                if ((mi.getPaint() == PaintType.ALLY_SECONDARY) == moneyTower[2 + (tmp.x - loc.x)][2 + (tmp.y - loc.y)]) {
                    mt++;
                }
            }
        }
        
        
        
        tmp = new MapLocation(loc.x + 1, loc.y + -1);
        if (rc.canSenseLocation(tmp)) {
            MapInfo mi = rc.senseMapInfo(tmp);
            if (mi.getPaint().isAlly()) {
                if ((mi.getPaint() == PaintType.ALLY_SECONDARY) == paintTower[2 + (tmp.x - loc.x)][2 + (tmp.y - loc.y)]) {
                    pt++;
                }
                if ((mi.getPaint() == PaintType.ALLY_SECONDARY) == moneyTower[2 + (tmp.x - loc.x)][2 + (tmp.y - loc.y)]) {
                    mt++;
                }
            }
        }
        
        
        
        tmp = new MapLocation(loc.x + 1, loc.y + -2);
        if (rc.canSenseLocation(tmp)) {
            MapInfo mi = rc.senseMapInfo(tmp);
            if (mi.getPaint().isAlly()) {
                if ((mi.getPaint() == PaintType.ALLY_SECONDARY) == paintTower[2 + (tmp.x - loc.x)][2 + (tmp.y - loc.y)]) {
                    pt++;
                }
                if ((mi.getPaint() == PaintType.ALLY_SECONDARY) == moneyTower[2 + (tmp.x - loc.x)][2 + (tmp.y - loc.y)]) {
                    mt++;
                }
            }
        }
        
        
        
        
        
        tmp = new MapLocation(loc.x + 0, loc.y + 2);
        if (rc.canSenseLocation(tmp)) {
            MapInfo mi = rc.senseMapInfo(tmp);
            if (mi.getPaint().isAlly()) {
                if ((mi.getPaint() == PaintType.ALLY_SECONDARY) == paintTower[2 + (tmp.x - loc.x)][2 + (tmp.y - loc.y)]) {
                    pt++;
                }
                if ((mi.getPaint() == PaintType.ALLY_SECONDARY) == moneyTower[2 + (tmp.x - loc.x)][2 + (tmp.y - loc.y)]) {
                    mt++;
                }
            }
        }
        
        
        
        tmp = new MapLocation(loc.x + 0, loc.y + 1);
        if (rc.canSenseLocation(tmp)) {
            MapInfo mi = rc.senseMapInfo(tmp);
            if (mi.getPaint().isAlly()) {
                if ((mi.getPaint() == PaintType.ALLY_SECONDARY) == paintTower[2 + (tmp.x - loc.x)][2 + (tmp.y - loc.y)]) {
                    pt++;
                }
                if ((mi.getPaint() == PaintType.ALLY_SECONDARY) == moneyTower[2 + (tmp.x - loc.x)][2 + (tmp.y - loc.y)]) {
                    mt++;
                }
            }
        }
        
        
        
        
        
        tmp = new MapLocation(loc.x + 0, loc.y + -1);
        if (rc.canSenseLocation(tmp)) {
            MapInfo mi = rc.senseMapInfo(tmp);
            if (mi.getPaint().isAlly()) {
                if ((mi.getPaint() == PaintType.ALLY_SECONDARY) == paintTower[2 + (tmp.x - loc.x)][2 + (tmp.y - loc.y)]) {
                    pt++;
                }
                if ((mi.getPaint() == PaintType.ALLY_SECONDARY) == moneyTower[2 + (tmp.x - loc.x)][2 + (tmp.y - loc.y)]) {
                    mt++;
                }
            }
        }
        
        
        
        tmp = new MapLocation(loc.x + 0, loc.y + -2);
        if (rc.canSenseLocation(tmp)) {
            MapInfo mi = rc.senseMapInfo(tmp);
            if (mi.getPaint().isAlly()) {
                if ((mi.getPaint() == PaintType.ALLY_SECONDARY) == paintTower[2 + (tmp.x - loc.x)][2 + (tmp.y - loc.y)]) {
                    pt++;
                }
                if ((mi.getPaint() == PaintType.ALLY_SECONDARY) == moneyTower[2 + (tmp.x - loc.x)][2 + (tmp.y - loc.y)]) {
                    mt++;
                }
            }
        }
        
        
        
        
        
        tmp = new MapLocation(loc.x + -1, loc.y + 2);
        if (rc.canSenseLocation(tmp)) {
            MapInfo mi = rc.senseMapInfo(tmp);
            if (mi.getPaint().isAlly()) {
                if ((mi.getPaint() == PaintType.ALLY_SECONDARY) == paintTower[2 + (tmp.x - loc.x)][2 + (tmp.y - loc.y)]) {
                    pt++;
                }
                if ((mi.getPaint() == PaintType.ALLY_SECONDARY) == moneyTower[2 + (tmp.x - loc.x)][2 + (tmp.y - loc.y)]) {
                    mt++;
                }
            }
        }
        
        
        
        tmp = new MapLocation(loc.x + -1, loc.y + 1);
        if (rc.canSenseLocation(tmp)) {
            MapInfo mi = rc.senseMapInfo(tmp);
            if (mi.getPaint().isAlly()) {
                if ((mi.getPaint() == PaintType.ALLY_SECONDARY) == paintTower[2 + (tmp.x - loc.x)][2 + (tmp.y - loc.y)]) {
                    pt++;
                }
                if ((mi.getPaint() == PaintType.ALLY_SECONDARY) == moneyTower[2 + (tmp.x - loc.x)][2 + (tmp.y - loc.y)]) {
                    mt++;
                }
            }
        }
        
        
        
        tmp = new MapLocation(loc.x + -1, loc.y + 0);
        if (rc.canSenseLocation(tmp)) {
            MapInfo mi = rc.senseMapInfo(tmp);
            if (mi.getPaint().isAlly()) {
                if ((mi.getPaint() == PaintType.ALLY_SECONDARY) == paintTower[2 + (tmp.x - loc.x)][2 + (tmp.y - loc.y)]) {
                    pt++;
                }
                if ((mi.getPaint() == PaintType.ALLY_SECONDARY) == moneyTower[2 + (tmp.x - loc.x)][2 + (tmp.y - loc.y)]) {
                    mt++;
                }
            }
        }
        
        
        
        tmp = new MapLocation(loc.x + -1, loc.y + -1);
        if (rc.canSenseLocation(tmp)) {
            MapInfo mi = rc.senseMapInfo(tmp);
            if (mi.getPaint().isAlly()) {
                if ((mi.getPaint() == PaintType.ALLY_SECONDARY) == paintTower[2 + (tmp.x - loc.x)][2 + (tmp.y - loc.y)]) {
                    pt++;
                }
                if ((mi.getPaint() == PaintType.ALLY_SECONDARY) == moneyTower[2 + (tmp.x - loc.x)][2 + (tmp.y - loc.y)]) {
                    mt++;
                }
            }
        }
        
        
        
        tmp = new MapLocation(loc.x + -1, loc.y + -2);
        if (rc.canSenseLocation(tmp)) {
            MapInfo mi = rc.senseMapInfo(tmp);
            if (mi.getPaint().isAlly()) {
                if ((mi.getPaint() == PaintType.ALLY_SECONDARY) == paintTower[2 + (tmp.x - loc.x)][2 + (tmp.y - loc.y)]) {
                    pt++;
                }
                if ((mi.getPaint() == PaintType.ALLY_SECONDARY) == moneyTower[2 + (tmp.x - loc.x)][2 + (tmp.y - loc.y)]) {
                    mt++;
                }
            }
        }
        
        
        
        
        
        tmp = new MapLocation(loc.x + -2, loc.y + 2);
        if (rc.canSenseLocation(tmp)) {
            MapInfo mi = rc.senseMapInfo(tmp);
            if (mi.getPaint().isAlly()) {
                if ((mi.getPaint() == PaintType.ALLY_SECONDARY) == paintTower[2 + (tmp.x - loc.x)][2 + (tmp.y - loc.y)]) {
                    pt++;
                }
                if ((mi.getPaint() == PaintType.ALLY_SECONDARY) == moneyTower[2 + (tmp.x - loc.x)][2 + (tmp.y - loc.y)]) {
                    mt++;
                }
            }
        }
        
        
        
        tmp = new MapLocation(loc.x + -2, loc.y + 1);
        if (rc.canSenseLocation(tmp)) {
            MapInfo mi = rc.senseMapInfo(tmp);
            if (mi.getPaint().isAlly()) {
                if ((mi.getPaint() == PaintType.ALLY_SECONDARY) == paintTower[2 + (tmp.x - loc.x)][2 + (tmp.y - loc.y)]) {
                    pt++;
                }
                if ((mi.getPaint() == PaintType.ALLY_SECONDARY) == moneyTower[2 + (tmp.x - loc.x)][2 + (tmp.y - loc.y)]) {
                    mt++;
                }
            }
        }
        
        
        
        tmp = new MapLocation(loc.x + -2, loc.y + 0);
        if (rc.canSenseLocation(tmp)) {
            MapInfo mi = rc.senseMapInfo(tmp);
            if (mi.getPaint().isAlly()) {
                if ((mi.getPaint() == PaintType.ALLY_SECONDARY) == paintTower[2 + (tmp.x - loc.x)][2 + (tmp.y - loc.y)]) {
                    pt++;
                }
                if ((mi.getPaint() == PaintType.ALLY_SECONDARY) == moneyTower[2 + (tmp.x - loc.x)][2 + (tmp.y - loc.y)]) {
                    mt++;
                }
            }
        }
        
        
        
        tmp = new MapLocation(loc.x + -2, loc.y + -1);
        if (rc.canSenseLocation(tmp)) {
            MapInfo mi = rc.senseMapInfo(tmp);
            if (mi.getPaint().isAlly()) {
                if ((mi.getPaint() == PaintType.ALLY_SECONDARY) == paintTower[2 + (tmp.x - loc.x)][2 + (tmp.y - loc.y)]) {
                    pt++;
                }
                if ((mi.getPaint() == PaintType.ALLY_SECONDARY) == moneyTower[2 + (tmp.x - loc.x)][2 + (tmp.y - loc.y)]) {
                    mt++;
                }
            }
        }
        
        
        
        tmp = new MapLocation(loc.x + -2, loc.y + -2);
        if (rc.canSenseLocation(tmp)) {
            MapInfo mi = rc.senseMapInfo(tmp);
            if (mi.getPaint().isAlly()) {
                if ((mi.getPaint() == PaintType.ALLY_SECONDARY) == paintTower[2 + (tmp.x - loc.x)][2 + (tmp.y - loc.y)]) {
                    pt++;
                }
                if ((mi.getPaint() == PaintType.ALLY_SECONDARY) == moneyTower[2 + (tmp.x - loc.x)][2 + (tmp.y - loc.y)]) {
                    mt++;
                }
            }
        }
        
        
        
        if (mt - pt >= 5) return UnitType.LEVEL_ONE_MONEY_TOWER;
        if (pt - mt >= 5) return UnitType.LEVEL_ONE_PAINT_TOWER;
        int sz = Math.max(rc.getMapWidth(), rc.getMapHeight());
        int firstPaint = 0;
        if (sz <= 35) {
            firstPaint = 3;
        } else if (sz <= 50) {
            firstPaint = 4;
        } else if (sz <= 55){
            firstPaint = 5;
        }
        else {
            firstPaint = 7;
        }
        if (rc.getMoney() < 2000 && rc.getNumberTowers() != firstPaint) return UnitType.LEVEL_ONE_MONEY_TOWER;
        return UnitType.LEVEL_ONE_PAINT_TOWER;
    }

    public static boolean isTower(UnitType u) {
        return switch (u) {
            case SOLDIER -> false;
            case SPLASHER -> false;
            case MOPPER -> false;
            default -> true;
        };
    }
}