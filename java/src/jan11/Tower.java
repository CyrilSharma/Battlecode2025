


package jan11;
import battlecode.common.*;

public class Tower {
    public static RobotController rc;
    public static MapLocation myloc;
    public static void init(RobotController rc) {
        Tower.rc = rc;
    }

    public static UnitType getUnitType() throws GameActionException {
        if (Globals.rng.nextInt(2) == 0 || rc.getMoney() < 1300) return UnitType.SOLDIER;
        return UnitType.MOPPER;
    }

    public static void run() throws GameActionException {
        // Initialize
        myloc = rc.getLocation();
        MapLocation nextLoc;

        towerTryAttack();
        if (rc.getRoundNum() > 50) {
            if(rc.getMoney() < 1250) return;
            if(rc.getPaint() < 200) return;
        }

        loop: {
            nextLoc = myloc.add(Direction.NORTH);
            if (rc.canBuildRobot(getUnitType(), nextLoc)) {
                rc.buildRobot(getUnitType(), nextLoc);
                break loop;
            }
        
            nextLoc = myloc.add(Direction.NORTHEAST);
            if (rc.canBuildRobot(getUnitType(), nextLoc)) {
                rc.buildRobot(getUnitType(), nextLoc);
                break loop;
            }
        
            nextLoc = myloc.add(Direction.EAST);
            if (rc.canBuildRobot(getUnitType(), nextLoc)) {
                rc.buildRobot(getUnitType(), nextLoc);
                break loop;
            }
        
            nextLoc = myloc.add(Direction.SOUTHEAST);
            if (rc.canBuildRobot(getUnitType(), nextLoc)) {
                rc.buildRobot(getUnitType(), nextLoc);
                break loop;
            }
        
            nextLoc = myloc.add(Direction.SOUTH);
            if (rc.canBuildRobot(getUnitType(), nextLoc)) {
                rc.buildRobot(getUnitType(), nextLoc);
                break loop;
            }
        
            nextLoc = myloc.add(Direction.SOUTHWEST);
            if (rc.canBuildRobot(getUnitType(), nextLoc)) {
                rc.buildRobot(getUnitType(), nextLoc);
                break loop;
            }
        
            nextLoc = myloc.add(Direction.WEST);
            if (rc.canBuildRobot(getUnitType(), nextLoc)) {
                rc.buildRobot(getUnitType(), nextLoc);
                break loop;
            }
        
            nextLoc = myloc.add(Direction.NORTHWEST);
            if (rc.canBuildRobot(getUnitType(), nextLoc)) {
                rc.buildRobot(getUnitType(), nextLoc);
                break loop;
            }
        
            nextLoc = myloc.add(Direction.CENTER);
            if (rc.canBuildRobot(getUnitType(), nextLoc)) {
                rc.buildRobot(getUnitType(), nextLoc);
                break loop;
            }
        }
    }

    public static void towerTryAttack() throws GameActionException {
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

        if (bestSoldierLoc != null) {
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