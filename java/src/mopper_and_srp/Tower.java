


package mopper_and_srp;
import battlecode.common.*;

public class Tower {
    public static RobotController rc;
    public static MapLocation myloc;
    public static boolean shouldDefend;
    public static int lastDefenseRound = -100;
    public static final int defenseWaitRounds = 30;
    public static void init(RobotController rc) {
        Tower.rc = rc;
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

    public static UnitType getUnitType() throws GameActionException {
        int money = rc.getMoney();
        int round = rc.getRoundNum();
        UnitType answer;
        if (round < 5) {
            int projected = money - UnitType.SOLDIER.moneyCost;
            answer = UnitType.SOLDIER;
        } else if (money < 2000) {
            if ((round % 50) <= 40) answer = UnitType.SOLDIER;
            else answer = UnitType.MOPPER;
        } else {
            if ((round % 50) > 25) return UnitType.SPLASHER;
            answer = UnitType.SOLDIER;
        }

        // if (rc.getPaint() - answer.paintCost < UnitType.MOPPER.paintCost) return null;
        return answer;
    }

    public static void runTurn() throws GameActionException {
        towerTryAttack();
        UnitType t = (shouldDefend) ? UnitType.MOPPER : getUnitType();
        if (t == null) return;
        if (rc.getPaint() < t.paintCost) return;
        if (!shouldDefend) {
            int lim = 10;
            if (rc.getMapHeight() * rc.getMapWidth() <= 600) lim = 50;
            if (rc.getRoundNum() > lim) {
                if (rc.getMoney() < 1250) return;
            }
        }
        
        loop: {
        {
            MapLocation nextLoc = myloc.add(Direction.NORTH);
            if (rc.canBuildRobot(t, nextLoc)) {
                rc.buildRobot(t, nextLoc);
                break loop;
            }
        }
        
        {
            MapLocation nextLoc = myloc.add(Direction.NORTHEAST);
            if (rc.canBuildRobot(t, nextLoc)) {
                rc.buildRobot(t, nextLoc);
                break loop;
            }
        }
        
        {
            MapLocation nextLoc = myloc.add(Direction.EAST);
            if (rc.canBuildRobot(t, nextLoc)) {
                rc.buildRobot(t, nextLoc);
                break loop;
            }
        }
        
        {
            MapLocation nextLoc = myloc.add(Direction.SOUTHEAST);
            if (rc.canBuildRobot(t, nextLoc)) {
                rc.buildRobot(t, nextLoc);
                break loop;
            }
        }
        
        {
            MapLocation nextLoc = myloc.add(Direction.SOUTH);
            if (rc.canBuildRobot(t, nextLoc)) {
                rc.buildRobot(t, nextLoc);
                break loop;
            }
        }
        
        {
            MapLocation nextLoc = myloc.add(Direction.SOUTHWEST);
            if (rc.canBuildRobot(t, nextLoc)) {
                rc.buildRobot(t, nextLoc);
                break loop;
            }
        }
        
        {
            MapLocation nextLoc = myloc.add(Direction.WEST);
            if (rc.canBuildRobot(t, nextLoc)) {
                rc.buildRobot(t, nextLoc);
                break loop;
            }
        }
        
        {
            MapLocation nextLoc = myloc.add(Direction.NORTHWEST);
            if (rc.canBuildRobot(t, nextLoc)) {
                rc.buildRobot(t, nextLoc);
                break loop;
            }
        }
        
        {
            MapLocation nextLoc = myloc.add(Direction.CENTER);
            if (rc.canBuildRobot(t, nextLoc)) {
                rc.buildRobot(t, nextLoc);
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