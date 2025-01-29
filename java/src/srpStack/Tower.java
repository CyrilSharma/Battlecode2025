


package srpStack;
import battlecode.common.*;

public class Tower {
    public static RobotController rc;
    public static MapLocation myloc;
    public static boolean shouldDefend;
    public static int lastDefenseRound = -100;
    public static final int defenseWaitRounds = 30;
    public static UnitType unitToBuild = null;
    public static int enemyLastSeen = 0;
    public static void init(RobotController rc) {
        Tower.rc = rc;
        enemyLastSeen = rc.getRoundNum();
    }

    public static void run() throws GameActionException {
        initTurn();
        runTurn();
    }

    public static boolean isMoneyTower(UnitType r) throws GameActionException {
        switch (r) {
            case LEVEL_ONE_MONEY_TOWER, LEVEL_TWO_MONEY_TOWER, LEVEL_THREE_MONEY_TOWER : {
                return true;
            }
            default: {
                return false;
            }
        }
    }

    public static MapLocation threatLoc = null;
    public static void initTurn() throws GameActionException {
        myloc = rc.getLocation();
        threatLoc = null;
        shouldDefend = false;
        for (RobotInfo r: Globals.enemies) {
            switch (r.type) {
                case SOLDIER, SPLASHER: {
                    threatLoc = r.location;
                    break;
                }
                default: continue;
            }
        }
        if ((threatLoc != null)
         && (rc.getRoundNum() - lastDefenseRound >= defenseWaitRounds)) {
            shouldDefend = true;
        }
        if (rc.getPaint() == 0 && isMoneyTower(rc.getType()) && rc.getMoney() >= 3000) {
            boolean seeSoldier = false;
            for (RobotInfo r : Globals.friends) {
                switch (r.type) {
                    case SOLDIER : {
                        if (r.paintAmount >= 50 && r.location.distanceSquaredTo(myloc) <= 8) {
                            seeSoldier = true;
                            break;
                        }
                    }
                    case MOPPER : {
                        if (r.paintAmount >= 50 && r.location.distanceSquaredTo(myloc) <= 8) {
                            seeSoldier = true;
                            break;
                        }
                    }
                    default: continue;
                }
            }
            boolean patternOk = true;
            boolean pattern[][] = rc.getTowerPattern(UnitType.LEVEL_ONE_MONEY_TOWER);
            MapLocation tmp;
            MapInfo mi;
            
            
            
            tmp = new MapLocation(rc.getLocation().x + 2, rc.getLocation().y + 2);
            if (rc.canSenseLocation(tmp)) {
                mi = rc.senseMapInfo(tmp);
                if (!mi.getPaint().isAlly()) patternOk = false;
                else if ((mi.getPaint() == PaintType.ALLY_SECONDARY) != pattern[4][4]) patternOk = false;
            }
            else patternOk = false;
            
            
            
            tmp = new MapLocation(rc.getLocation().x + 2, rc.getLocation().y + 1);
            if (rc.canSenseLocation(tmp)) {
                mi = rc.senseMapInfo(tmp);
                if (!mi.getPaint().isAlly()) patternOk = false;
                else if ((mi.getPaint() == PaintType.ALLY_SECONDARY) != pattern[4][3]) patternOk = false;
            }
            else patternOk = false;
            
            
            
            tmp = new MapLocation(rc.getLocation().x + 2, rc.getLocation().y + 0);
            if (rc.canSenseLocation(tmp)) {
                mi = rc.senseMapInfo(tmp);
                if (!mi.getPaint().isAlly()) patternOk = false;
                else if ((mi.getPaint() == PaintType.ALLY_SECONDARY) != pattern[4][2]) patternOk = false;
            }
            else patternOk = false;
            
            
            
            tmp = new MapLocation(rc.getLocation().x + 2, rc.getLocation().y + -1);
            if (rc.canSenseLocation(tmp)) {
                mi = rc.senseMapInfo(tmp);
                if (!mi.getPaint().isAlly()) patternOk = false;
                else if ((mi.getPaint() == PaintType.ALLY_SECONDARY) != pattern[4][1]) patternOk = false;
            }
            else patternOk = false;
            
            
            
            tmp = new MapLocation(rc.getLocation().x + 2, rc.getLocation().y + -2);
            if (rc.canSenseLocation(tmp)) {
                mi = rc.senseMapInfo(tmp);
                if (!mi.getPaint().isAlly()) patternOk = false;
                else if ((mi.getPaint() == PaintType.ALLY_SECONDARY) != pattern[4][0]) patternOk = false;
            }
            else patternOk = false;
            
            
            
            
            
            tmp = new MapLocation(rc.getLocation().x + 1, rc.getLocation().y + 2);
            if (rc.canSenseLocation(tmp)) {
                mi = rc.senseMapInfo(tmp);
                if (!mi.getPaint().isAlly()) patternOk = false;
                else if ((mi.getPaint() == PaintType.ALLY_SECONDARY) != pattern[3][4]) patternOk = false;
            }
            else patternOk = false;
            
            
            
            tmp = new MapLocation(rc.getLocation().x + 1, rc.getLocation().y + 1);
            if (rc.canSenseLocation(tmp)) {
                mi = rc.senseMapInfo(tmp);
                if (!mi.getPaint().isAlly()) patternOk = false;
                else if ((mi.getPaint() == PaintType.ALLY_SECONDARY) != pattern[3][3]) patternOk = false;
            }
            else patternOk = false;
            
            
            
            tmp = new MapLocation(rc.getLocation().x + 1, rc.getLocation().y + 0);
            if (rc.canSenseLocation(tmp)) {
                mi = rc.senseMapInfo(tmp);
                if (!mi.getPaint().isAlly()) patternOk = false;
                else if ((mi.getPaint() == PaintType.ALLY_SECONDARY) != pattern[3][2]) patternOk = false;
            }
            else patternOk = false;
            
            
            
            tmp = new MapLocation(rc.getLocation().x + 1, rc.getLocation().y + -1);
            if (rc.canSenseLocation(tmp)) {
                mi = rc.senseMapInfo(tmp);
                if (!mi.getPaint().isAlly()) patternOk = false;
                else if ((mi.getPaint() == PaintType.ALLY_SECONDARY) != pattern[3][1]) patternOk = false;
            }
            else patternOk = false;
            
            
            
            tmp = new MapLocation(rc.getLocation().x + 1, rc.getLocation().y + -2);
            if (rc.canSenseLocation(tmp)) {
                mi = rc.senseMapInfo(tmp);
                if (!mi.getPaint().isAlly()) patternOk = false;
                else if ((mi.getPaint() == PaintType.ALLY_SECONDARY) != pattern[3][0]) patternOk = false;
            }
            else patternOk = false;
            
            
            
            
            
            tmp = new MapLocation(rc.getLocation().x + 0, rc.getLocation().y + 2);
            if (rc.canSenseLocation(tmp)) {
                mi = rc.senseMapInfo(tmp);
                if (!mi.getPaint().isAlly()) patternOk = false;
                else if ((mi.getPaint() == PaintType.ALLY_SECONDARY) != pattern[2][4]) patternOk = false;
            }
            else patternOk = false;
            
            
            
            tmp = new MapLocation(rc.getLocation().x + 0, rc.getLocation().y + 1);
            if (rc.canSenseLocation(tmp)) {
                mi = rc.senseMapInfo(tmp);
                if (!mi.getPaint().isAlly()) patternOk = false;
                else if ((mi.getPaint() == PaintType.ALLY_SECONDARY) != pattern[2][3]) patternOk = false;
            }
            else patternOk = false;
            
            
            
            
            
            tmp = new MapLocation(rc.getLocation().x + 0, rc.getLocation().y + -1);
            if (rc.canSenseLocation(tmp)) {
                mi = rc.senseMapInfo(tmp);
                if (!mi.getPaint().isAlly()) patternOk = false;
                else if ((mi.getPaint() == PaintType.ALLY_SECONDARY) != pattern[2][1]) patternOk = false;
            }
            else patternOk = false;
            
            
            
            tmp = new MapLocation(rc.getLocation().x + 0, rc.getLocation().y + -2);
            if (rc.canSenseLocation(tmp)) {
                mi = rc.senseMapInfo(tmp);
                if (!mi.getPaint().isAlly()) patternOk = false;
                else if ((mi.getPaint() == PaintType.ALLY_SECONDARY) != pattern[2][0]) patternOk = false;
            }
            else patternOk = false;
            
            
            
            
            
            tmp = new MapLocation(rc.getLocation().x + -1, rc.getLocation().y + 2);
            if (rc.canSenseLocation(tmp)) {
                mi = rc.senseMapInfo(tmp);
                if (!mi.getPaint().isAlly()) patternOk = false;
                else if ((mi.getPaint() == PaintType.ALLY_SECONDARY) != pattern[1][4]) patternOk = false;
            }
            else patternOk = false;
            
            
            
            tmp = new MapLocation(rc.getLocation().x + -1, rc.getLocation().y + 1);
            if (rc.canSenseLocation(tmp)) {
                mi = rc.senseMapInfo(tmp);
                if (!mi.getPaint().isAlly()) patternOk = false;
                else if ((mi.getPaint() == PaintType.ALLY_SECONDARY) != pattern[1][3]) patternOk = false;
            }
            else patternOk = false;
            
            
            
            tmp = new MapLocation(rc.getLocation().x + -1, rc.getLocation().y + 0);
            if (rc.canSenseLocation(tmp)) {
                mi = rc.senseMapInfo(tmp);
                if (!mi.getPaint().isAlly()) patternOk = false;
                else if ((mi.getPaint() == PaintType.ALLY_SECONDARY) != pattern[1][2]) patternOk = false;
            }
            else patternOk = false;
            
            
            
            tmp = new MapLocation(rc.getLocation().x + -1, rc.getLocation().y + -1);
            if (rc.canSenseLocation(tmp)) {
                mi = rc.senseMapInfo(tmp);
                if (!mi.getPaint().isAlly()) patternOk = false;
                else if ((mi.getPaint() == PaintType.ALLY_SECONDARY) != pattern[1][1]) patternOk = false;
            }
            else patternOk = false;
            
            
            
            tmp = new MapLocation(rc.getLocation().x + -1, rc.getLocation().y + -2);
            if (rc.canSenseLocation(tmp)) {
                mi = rc.senseMapInfo(tmp);
                if (!mi.getPaint().isAlly()) patternOk = false;
                else if ((mi.getPaint() == PaintType.ALLY_SECONDARY) != pattern[1][0]) patternOk = false;
            }
            else patternOk = false;
            
            
            
            
            
            tmp = new MapLocation(rc.getLocation().x + -2, rc.getLocation().y + 2);
            if (rc.canSenseLocation(tmp)) {
                mi = rc.senseMapInfo(tmp);
                if (!mi.getPaint().isAlly()) patternOk = false;
                else if ((mi.getPaint() == PaintType.ALLY_SECONDARY) != pattern[0][4]) patternOk = false;
            }
            else patternOk = false;
            
            
            
            tmp = new MapLocation(rc.getLocation().x + -2, rc.getLocation().y + 1);
            if (rc.canSenseLocation(tmp)) {
                mi = rc.senseMapInfo(tmp);
                if (!mi.getPaint().isAlly()) patternOk = false;
                else if ((mi.getPaint() == PaintType.ALLY_SECONDARY) != pattern[0][3]) patternOk = false;
            }
            else patternOk = false;
            
            
            
            tmp = new MapLocation(rc.getLocation().x + -2, rc.getLocation().y + 0);
            if (rc.canSenseLocation(tmp)) {
                mi = rc.senseMapInfo(tmp);
                if (!mi.getPaint().isAlly()) patternOk = false;
                else if ((mi.getPaint() == PaintType.ALLY_SECONDARY) != pattern[0][2]) patternOk = false;
            }
            else patternOk = false;
            
            
            
            tmp = new MapLocation(rc.getLocation().x + -2, rc.getLocation().y + -1);
            if (rc.canSenseLocation(tmp)) {
                mi = rc.senseMapInfo(tmp);
                if (!mi.getPaint().isAlly()) patternOk = false;
                else if ((mi.getPaint() == PaintType.ALLY_SECONDARY) != pattern[0][1]) patternOk = false;
            }
            else patternOk = false;
            
            
            
            tmp = new MapLocation(rc.getLocation().x + -2, rc.getLocation().y + -2);
            if (rc.canSenseLocation(tmp)) {
                mi = rc.senseMapInfo(tmp);
                if (!mi.getPaint().isAlly()) patternOk = false;
                else if ((mi.getPaint() == PaintType.ALLY_SECONDARY) != pattern[0][0]) patternOk = false;
            }
            else patternOk = false;
            
            
            
            if (TowerBuild.isFarm(rc.getLocation()) && patternOk && seeSoldier) {
                rc.disintegrate();
            }
        }
    }

    public static int soldiersBuilt = 0;
    public static int splashersBuilt = 0;
    public static int moppersBuilt = 0;
    public static UnitType getUnitType() throws GameActionException {
        int money = rc.getMoney();
        int round = rc.getRoundNum();
        UnitType answer;
        if (round < 5) {
            answer = UnitType.SOLDIER;
        } else if (money < 2000 && Globals.numMoneyTowers < 3) {
            int total = (soldiersBuilt + moppersBuilt);
            if (total % 5 < 4) answer = UnitType.SOLDIER;
            else answer = UnitType.MOPPER;
        } else {
            int total = (soldiersBuilt + splashersBuilt + moppersBuilt);
            if (total % 5 < 2) answer = UnitType.SPLASHER;
            else if (total % 5 < 4) answer = UnitType.SOLDIER;
            else answer = UnitType.MOPPER;
        }

        switch (answer) {
            case SOLDIER -> ++soldiersBuilt;
            case SPLASHER -> ++splashersBuilt;
            case MOPPER -> ++moppersBuilt;
            default -> {}
        }
        return answer;
    }


    public static void runTurn() throws GameActionException {
        towerTryAttack();
        if (Globals.enemies.length > 0)
            enemyLastSeen = rc.getRoundNum();

        UnitType t;
        if (shouldDefend) {
            t = UnitType.MOPPER;
            //rc.setIndicatorString("Defense! Making a mopper");
        } else if (unitToBuild == null) {
            unitToBuild = getUnitType();
            t = unitToBuild;
            //rc.setIndicatorString("Saving for " + t);
        } else {
            t = unitToBuild;
            //rc.setIndicatorString("Saving for " + t);
        }

        if ((rc.getType() == UnitType.LEVEL_ONE_PAINT_TOWER)
            && (rc.getMoney() >= (UnitType.LEVEL_TWO_PAINT_TOWER.moneyCost + 1000))
            && (rc.getRoundNum() - enemyLastSeen >= 10)) {
            rc.upgradeTower(rc.getLocation());
        } else if ((rc.getType() == UnitType.LEVEL_TWO_PAINT_TOWER)
            && (rc.getMoney() >= (UnitType.LEVEL_THREE_PAINT_TOWER.moneyCost + 1000))
            && (rc.getRoundNum() - enemyLastSeen >= 10)) {
            rc.upgradeTower(rc.getLocation());
        }

        if (t == null) return;
        if (rc.getPaint() < t.paintCost){
            if (isMoneyTower(rc.getType()) && rc.getRoundNum() > 20) unitToBuild = null;
            return;
        }

        if (!shouldDefend) {
            int lim = 10;
            if (rc.getMapHeight() * rc.getMapWidth() <= 600) lim = 50;
            if (rc.getRoundNum() > lim) {
                if (rc.getMoney() < 1250) return;
            }
        }
        
        // This isn't great either.
        int closest = 100000000;
        MapLocation bestLoc = null;
        loop: {
            {
                MapLocation nextLoc = myloc.add(Direction.NORTH);
                if (rc.canBuildRobot(t, nextLoc)) {
                    if (shouldDefend) {
                        int d = threatLoc.distanceSquaredTo(nextLoc);
                        if (d < closest) {
                            closest = d;
                            bestLoc = nextLoc;
                        }
                    } else {
                        bestLoc = nextLoc;
                        break loop;
                    }
                }
            }
            
            {
                MapLocation nextLoc = myloc.add(Direction.NORTHEAST);
                if (rc.canBuildRobot(t, nextLoc)) {
                    if (shouldDefend) {
                        int d = threatLoc.distanceSquaredTo(nextLoc);
                        if (d < closest) {
                            closest = d;
                            bestLoc = nextLoc;
                        }
                    } else {
                        bestLoc = nextLoc;
                        break loop;
                    }
                }
            }
            
            {
                MapLocation nextLoc = myloc.add(Direction.EAST);
                if (rc.canBuildRobot(t, nextLoc)) {
                    if (shouldDefend) {
                        int d = threatLoc.distanceSquaredTo(nextLoc);
                        if (d < closest) {
                            closest = d;
                            bestLoc = nextLoc;
                        }
                    } else {
                        bestLoc = nextLoc;
                        break loop;
                    }
                }
            }
            
            {
                MapLocation nextLoc = myloc.add(Direction.SOUTHEAST);
                if (rc.canBuildRobot(t, nextLoc)) {
                    if (shouldDefend) {
                        int d = threatLoc.distanceSquaredTo(nextLoc);
                        if (d < closest) {
                            closest = d;
                            bestLoc = nextLoc;
                        }
                    } else {
                        bestLoc = nextLoc;
                        break loop;
                    }
                }
            }
            
            {
                MapLocation nextLoc = myloc.add(Direction.SOUTH);
                if (rc.canBuildRobot(t, nextLoc)) {
                    if (shouldDefend) {
                        int d = threatLoc.distanceSquaredTo(nextLoc);
                        if (d < closest) {
                            closest = d;
                            bestLoc = nextLoc;
                        }
                    } else {
                        bestLoc = nextLoc;
                        break loop;
                    }
                }
            }
            
            {
                MapLocation nextLoc = myloc.add(Direction.SOUTHWEST);
                if (rc.canBuildRobot(t, nextLoc)) {
                    if (shouldDefend) {
                        int d = threatLoc.distanceSquaredTo(nextLoc);
                        if (d < closest) {
                            closest = d;
                            bestLoc = nextLoc;
                        }
                    } else {
                        bestLoc = nextLoc;
                        break loop;
                    }
                }
            }
            
            {
                MapLocation nextLoc = myloc.add(Direction.WEST);
                if (rc.canBuildRobot(t, nextLoc)) {
                    if (shouldDefend) {
                        int d = threatLoc.distanceSquaredTo(nextLoc);
                        if (d < closest) {
                            closest = d;
                            bestLoc = nextLoc;
                        }
                    } else {
                        bestLoc = nextLoc;
                        break loop;
                    }
                }
            }
            
            {
                MapLocation nextLoc = myloc.add(Direction.NORTHWEST);
                if (rc.canBuildRobot(t, nextLoc)) {
                    if (shouldDefend) {
                        int d = threatLoc.distanceSquaredTo(nextLoc);
                        if (d < closest) {
                            closest = d;
                            bestLoc = nextLoc;
                        }
                    } else {
                        bestLoc = nextLoc;
                        break loop;
                    }
                }
            }
            
            {
                MapLocation nextLoc = myloc.add(Direction.CENTER);
                if (rc.canBuildRobot(t, nextLoc)) {
                    if (shouldDefend) {
                        int d = threatLoc.distanceSquaredTo(nextLoc);
                        if (d < closest) {
                            closest = d;
                            bestLoc = nextLoc;
                        }
                    } else {
                        bestLoc = nextLoc;
                        break loop;
                    }
                }
            }
            }
        if (bestLoc != null && rc.canBuildRobot(t, bestLoc)) {
            if (shouldDefend) lastDefenseRound = rc.getRoundNum();
            rc.setIndicatorString("Chose to build " + t + " at " + bestLoc);
            rc.buildRobot(t, bestLoc);
            unitToBuild = null;
        }
    }

    public static void towerTryAttack() throws GameActionException {
        MapLocation bestSplasherLoc = null;
        int smallestSplasherHealth = 100000000;
        MapLocation bestSoldierLoc = null;
        int smallestSoldierHealth = 100000000;
        MapLocation bestNonSoldierLoc = null;
        int smallestNonSoldierHealth = 10000000;
        for (int i = Globals.enemies.length; --i >= 0;) {
            RobotInfo enemy = Globals.enemies[i];
            if (enemy.paintAmount == 0) continue;
            MapLocation loc = enemy.location;
            if (rc.canAttack(loc)) {
                switch (enemy.type) {
                    case SPLASHER -> {
                        if (enemy.health < smallestSplasherHealth) {
                            bestSplasherLoc = loc;
                            smallestSplasherHealth = enemy.health;
                        }
                    }
                    case SOLDIER -> {
                        if (enemy.health < smallestSoldierHealth) {
                            bestSoldierLoc = loc;
                            smallestSoldierHealth = enemy.health;
                        }
                    }
                    default -> {
                        if (enemy.health < smallestNonSoldierHealth) {
                            bestNonSoldierLoc = loc;
                            smallestNonSoldierHealth = enemy.health;
                        }
                    }
                }
                
            }
        }

        if (bestSplasherLoc != null) {
            rc.setIndicatorDot(bestSplasherLoc, 0, 0, 0);
            rc.attack(bestSplasherLoc);
        }  else if (bestSoldierLoc != null) {
            rc.setIndicatorDot(bestSoldierLoc, 0, 0, 0);
            rc.attack(bestSoldierLoc);
        } else if (bestNonSoldierLoc != null) {
            rc.setIndicatorDot(bestNonSoldierLoc, 0, 0, 0);
            rc.attack(bestNonSoldierLoc);
        }

        if (rc.canAttack(null)) rc.attack(null);
    }
}