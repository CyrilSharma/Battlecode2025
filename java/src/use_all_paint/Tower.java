


package use_all_paint;
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

    
    public static void initTurn() throws GameActionException {
        myloc = rc.getLocation();
        shouldDefend = false;
        if ((Globals.enemies.length >= 1) && (rc.getRoundNum() - lastDefenseRound >= defenseWaitRounds)) {
            shouldDefend = true;
            lastDefenseRound = rc.getRoundNum();
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
        } else if (money < 2000 && Globals.getIncome() < 60) {
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
            rc.setIndicatorString("Defense! Making a mopper");
        } else if (unitToBuild == null) {
            unitToBuild = getUnitType();
            t = unitToBuild;
            rc.setIndicatorString("Saving for " + t);
        } else {
            t = unitToBuild;
            rc.setIndicatorString("Saving for " + t);
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
        if (rc.getPaint() < t.paintCost) return;
        if (!shouldDefend) {
            int lim = 10;
            if (rc.getMapHeight() * rc.getMapWidth() <= 600) lim = 50;
            if (rc.getRoundNum() > lim) {
                if (rc.getMoney() < 1250) return;
            }
        }
        
        // This isn't great either.
        loop: {
        {
            MapLocation nextLoc = myloc.add(Direction.NORTH);
            if (rc.canBuildRobot(t, nextLoc)) {
                rc.buildRobot(t, nextLoc);
                unitToBuild = null;
                break loop;
            }
        }
        
        {
            MapLocation nextLoc = myloc.add(Direction.NORTHEAST);
            if (rc.canBuildRobot(t, nextLoc)) {
                rc.buildRobot(t, nextLoc);
                unitToBuild = null;
                break loop;
            }
        }
        
        {
            MapLocation nextLoc = myloc.add(Direction.EAST);
            if (rc.canBuildRobot(t, nextLoc)) {
                rc.buildRobot(t, nextLoc);
                unitToBuild = null;
                break loop;
            }
        }
        
        {
            MapLocation nextLoc = myloc.add(Direction.SOUTHEAST);
            if (rc.canBuildRobot(t, nextLoc)) {
                rc.buildRobot(t, nextLoc);
                unitToBuild = null;
                break loop;
            }
        }
        
        {
            MapLocation nextLoc = myloc.add(Direction.SOUTH);
            if (rc.canBuildRobot(t, nextLoc)) {
                rc.buildRobot(t, nextLoc);
                unitToBuild = null;
                break loop;
            }
        }
        
        {
            MapLocation nextLoc = myloc.add(Direction.SOUTHWEST);
            if (rc.canBuildRobot(t, nextLoc)) {
                rc.buildRobot(t, nextLoc);
                unitToBuild = null;
                break loop;
            }
        }
        
        {
            MapLocation nextLoc = myloc.add(Direction.WEST);
            if (rc.canBuildRobot(t, nextLoc)) {
                rc.buildRobot(t, nextLoc);
                unitToBuild = null;
                break loop;
            }
        }
        
        {
            MapLocation nextLoc = myloc.add(Direction.NORTHWEST);
            if (rc.canBuildRobot(t, nextLoc)) {
                rc.buildRobot(t, nextLoc);
                unitToBuild = null;
                break loop;
            }
        }
        
        {
            MapLocation nextLoc = myloc.add(Direction.CENTER);
            if (rc.canBuildRobot(t, nextLoc)) {
                rc.buildRobot(t, nextLoc);
                unitToBuild = null;
                break loop;
            }
        }
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