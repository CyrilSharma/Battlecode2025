


package jan19_3_49;
import battlecode.common.*;

public class Tower {
    public static RobotController rc;
    public static MapLocation myloc;
    public static void init(RobotController rc) {
        Tower.rc = rc;
    }

    public static UnitType getUnitType() throws GameActionException {
        int money = rc.getMoney();
        int round = rc.getRoundNum();
        if (round < 5) {
            if (rc.getMoney() <= GameConstants.INITIAL_TEAM_MONEY) {
                return UnitType.SOLDIER;
            } else {
                return UnitType.MOPPER;
            }
        } else if (money < 2000) {
            if ((round % 50) <= 40) return UnitType.SOLDIER;
            else return UnitType.MOPPER;
        } else {
            if ((round % 50) > 25) return UnitType.SPLASHER;
            else return UnitType.SOLDIER;
        }
        //return UnitType.SOLDIER;
    }

    public static void run() throws GameActionException {
        // Initialize
        myloc = rc.getLocation();
        MapLocation nextLoc;

        towerTryAttack();
        int lim = 10;
        if (rc.getMapHeight() * rc.getMapWidth() <= 600) lim = 50;
        if (rc.getRoundNum() > lim) {
            if(rc.getMoney() < 1250) return;
            if(rc.getPaint() < 200) return;
        }

        UnitType t = getUnitType();
        loop: {
            nextLoc = myloc.add(Direction.NORTH);
            if (rc.canBuildRobot(t, nextLoc)) {
                rc.buildRobot(t, nextLoc);
                break loop;
            }
        
            nextLoc = myloc.add(Direction.NORTHEAST);
            if (rc.canBuildRobot(t, nextLoc)) {
                rc.buildRobot(t, nextLoc);
                break loop;
            }
        
            nextLoc = myloc.add(Direction.EAST);
            if (rc.canBuildRobot(t, nextLoc)) {
                rc.buildRobot(t, nextLoc);
                break loop;
            }
        
            nextLoc = myloc.add(Direction.SOUTHEAST);
            if (rc.canBuildRobot(t, nextLoc)) {
                rc.buildRobot(t, nextLoc);
                break loop;
            }
        
            nextLoc = myloc.add(Direction.SOUTH);
            if (rc.canBuildRobot(t, nextLoc)) {
                rc.buildRobot(t, nextLoc);
                break loop;
            }
        
            nextLoc = myloc.add(Direction.SOUTHWEST);
            if (rc.canBuildRobot(t, nextLoc)) {
                rc.buildRobot(t, nextLoc);
                break loop;
            }
        
            nextLoc = myloc.add(Direction.WEST);
            if (rc.canBuildRobot(t, nextLoc)) {
                rc.buildRobot(t, nextLoc);
                break loop;
            }
        
            nextLoc = myloc.add(Direction.NORTHWEST);
            if (rc.canBuildRobot(t, nextLoc)) {
                rc.buildRobot(t, nextLoc);
                break loop;
            }
        
            nextLoc = myloc.add(Direction.CENTER);
            if (rc.canBuildRobot(t, nextLoc)) {
                rc.buildRobot(t, nextLoc);
                break loop;
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
            rc.setIndicatorString("Attacking Splasher!");
            rc.setIndicatorDot(bestSplasherLoc, 0, 0, 0);
            rc.attack(bestSplasherLoc);
        }  else if (bestSoldierLoc != null) {
            rc.setIndicatorString("Attacking Soldier!");
            rc.setIndicatorDot(bestSoldierLoc, 0, 0, 0);
            rc.attack(bestSoldierLoc);
        } else if (bestNonSoldierLoc != null) {
            rc.setIndicatorString("Attacking Other!");
            rc.setIndicatorDot(bestNonSoldierLoc, 0, 0, 0);
            rc.attack(bestNonSoldierLoc);
        } else {
            rc.setIndicatorString("Didn't Attack!");
        }

        if (rc.canAttack(null)) rc.attack(null);
    }
}