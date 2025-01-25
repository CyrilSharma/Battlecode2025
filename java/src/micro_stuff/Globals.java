package micro_stuff;
import java.util.Random;
import battlecode.common.*;

public class Globals {
    public static int roundNum;
    public static RobotController rc;
    public static final Random rng = new Random();
    public static boolean[][] moneyTower;
    public static boolean[][] paintTower;
    public static void init(RobotController rc) throws GameActionException {
        rng.setSeed((long) rc.getID());
        Globals.rc = rc;
        moneyTower = rc.getTowerPattern(UnitType.LEVEL_ONE_MONEY_TOWER);
        paintTower = rc.getTowerPattern(UnitType.LEVEL_ONE_PAINT_TOWER);
        Globals.born = rc.getRoundNum();
    }

    public static RobotInfo[] friends;
    public static RobotInfo[] enemies;
    public static void run() throws GameActionException {
        friends = rc.senseNearbyRobots(-1, rc.getTeam());
        enemies = rc.senseNearbyRobots(-1, rc.getTeam().opponent());
        roundNum = rc.getRoundNum();
        updateIncomeTracker();
    }

    public static boolean onMap(MapLocation loc) throws GameActionException {
        return (loc.x >= 0 && loc.y >= 0 && loc.x < rc.getMapWidth() && loc.y < rc.getMapHeight());
    }

    public static UnitType getTowerToBuild(MapLocation loc) throws GameActionException {
        MapLocation paintMark = loc.add(Direction.WEST);
        MapLocation moneyMark = loc.add(Direction.SOUTH);
        if (rc.canSenseLocation(paintMark)){
            MapInfo s = rc.senseMapInfo(paintMark);
            if (s.getMark() == PaintType.ALLY_SECONDARY) return UnitType.LEVEL_ONE_PAINT_TOWER;
        }
        if( rc.canSenseLocation(moneyMark)) {
            MapInfo s = rc.senseMapInfo(moneyMark);
            if (s.getMark() == PaintType.ALLY_SECONDARY) return UnitType.LEVEL_ONE_MONEY_TOWER;
        }
        if (rc.getMoney() < 2000) return UnitType.LEVEL_ONE_MONEY_TOWER;
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


     // Income Tracking.
    public static int born;
    public static int income = GameConstants.NUMBER_INITIAL_MONEY_TOWERS * UnitType.LEVEL_ONE_MONEY_TOWER.moneyPerTurn;
    public static int lastMoney = 0;
    public static int moneyUpdateFreq = 30;
    public static void updateIncomeTracker() throws GameActionException {
        if (roundNum < moneyUpdateFreq) return;
        int modulo = (roundNum % moneyUpdateFreq);
        if (modulo == 0) {
            lastMoney =  rc.getMoney();
        } else if (modulo == 1) {
            income = (rc.getMoney() - lastMoney);
        }
    }

    public static boolean shouldStallForIncome() throws GameActionException {
        if (roundNum < moneyUpdateFreq) return false;
        int modulo = (roundNum % moneyUpdateFreq);
        return (modulo == 0) || (modulo == 1);
    }
    
    public static int getIncome() {
        return income;
    }
}