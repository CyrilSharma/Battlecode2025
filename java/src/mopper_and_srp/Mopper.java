

package mopper_and_srp;
import battlecode.common.*;

public class Mopper {
    public static RobotController rc;
    public static MapLocation buildTower = null;
    public static MapLocation myloc;
    public static int paintCapacity = UnitType.SOLDIER.paintCapacity;
    public static int myPaint;
    public static MapLocation exploreTarget;
    public static MapInfo[] near;
    public static MapLocation ruinLoc;
    public static boolean[][] resourcePat = null;
    public static boolean shouldGoHome = false;

    public static void init(RobotController rc) {
        Mopper.rc = rc;
        resourcePat = rc.getResourcePattern();
    }

    public static boolean canMop(MapInfo mi) throws GameActionException {
        return (!mi.getPaint().isAlly() && mi.getPaint() != PaintType.EMPTY);
    }

    public static MapLocation mopTarget = null;
    public static void computeMopTarget() throws GameActionException {
        RobotInfo enemyTower = null;
        MapLocation[] ruins = rc.senseNearbyRuins(-1);
        for (MapLocation loc: ruins) {
            RobotInfo r = rc.senseRobotAtLocation(loc);
            if (r != null && r.team != rc.getTeam()) {
                enemyTower = r;
                break;
            }
        }

        MapLocation myloc = rc.getLocation();
        int closest = 1000000000;
        MapLocation bestLoc = null;
        MapInfo[] mis = near;
        for (int i = mis.length; --i >= 0;) {
            switch (mis[i].getPaint()) {
                case ENEMY_PRIMARY, ENEMY_SECONDARY -> {
                    MapLocation loc = mis[i].getMapLocation();
                    int d = loc.distanceSquaredTo(myloc);
                    if (d < closest && (enemyTower == null || loc.distanceSquaredTo(enemyTower.location) > enemyTower.type.actionRadiusSquared + 20)) {
                        closest = d;
                        bestLoc = loc;
                    }
                }
                default -> {}
            }
        }

        if (mopTarget != null) {
            if (rc.canSenseLocation(mopTarget)) {
                MapInfo mi = rc.senseMapInfo(mopTarget);
                switch (mi.getPaint()) {
                    case ENEMY_PRIMARY, ENEMY_SECONDARY: return;
                    default: mopTarget = null;
                }
            }
            if (bestLoc != null)
                mopTarget = bestLoc;
        } else {
            mopTarget = bestLoc;
        }
    }

    public static void handleMopTarget(MapLocation target) throws GameActionException {
        if (myloc.distanceSquaredTo(target) >= 9) {
            Pathing.pathTo(target);
            return;
        }

        int bestDist = 1000000;
        int bestScore = -10000;
        MapLocation bestLoc = null;
        
        {
            MapLocation nloc = target.add(Direction.NORTH);
            if (rc.canSenseLocation(nloc)) {
                MapInfo mi = rc.senseMapInfo(nloc);
                int score = switch (mi.getPaint()) {
                    case ENEMY_PRIMARY, ENEMY_SECONDARY -> -2;
                    case EMPTY -> -1;
                    case ALLY_PRIMARY, ALLY_SECONDARY -> 0;
                };

                int dist = nloc.distanceSquaredTo(myloc);
                if ((score > bestScore) || (score == bestScore && dist < bestDist)) {
                    bestScore = score;
                    bestDist = dist;
                    bestLoc = nloc;
                }
            }
        }
        
        {
            MapLocation nloc = target.add(Direction.NORTHEAST);
            if (rc.canSenseLocation(nloc)) {
                MapInfo mi = rc.senseMapInfo(nloc);
                int score = switch (mi.getPaint()) {
                    case ENEMY_PRIMARY, ENEMY_SECONDARY -> -2;
                    case EMPTY -> -1;
                    case ALLY_PRIMARY, ALLY_SECONDARY -> 0;
                };

                int dist = nloc.distanceSquaredTo(myloc);
                if ((score > bestScore) || (score == bestScore && dist < bestDist)) {
                    bestScore = score;
                    bestDist = dist;
                    bestLoc = nloc;
                }
            }
        }
        
        {
            MapLocation nloc = target.add(Direction.EAST);
            if (rc.canSenseLocation(nloc)) {
                MapInfo mi = rc.senseMapInfo(nloc);
                int score = switch (mi.getPaint()) {
                    case ENEMY_PRIMARY, ENEMY_SECONDARY -> -2;
                    case EMPTY -> -1;
                    case ALLY_PRIMARY, ALLY_SECONDARY -> 0;
                };

                int dist = nloc.distanceSquaredTo(myloc);
                if ((score > bestScore) || (score == bestScore && dist < bestDist)) {
                    bestScore = score;
                    bestDist = dist;
                    bestLoc = nloc;
                }
            }
        }
        
        {
            MapLocation nloc = target.add(Direction.SOUTHEAST);
            if (rc.canSenseLocation(nloc)) {
                MapInfo mi = rc.senseMapInfo(nloc);
                int score = switch (mi.getPaint()) {
                    case ENEMY_PRIMARY, ENEMY_SECONDARY -> -2;
                    case EMPTY -> -1;
                    case ALLY_PRIMARY, ALLY_SECONDARY -> 0;
                };

                int dist = nloc.distanceSquaredTo(myloc);
                if ((score > bestScore) || (score == bestScore && dist < bestDist)) {
                    bestScore = score;
                    bestDist = dist;
                    bestLoc = nloc;
                }
            }
        }
        
        {
            MapLocation nloc = target.add(Direction.SOUTH);
            if (rc.canSenseLocation(nloc)) {
                MapInfo mi = rc.senseMapInfo(nloc);
                int score = switch (mi.getPaint()) {
                    case ENEMY_PRIMARY, ENEMY_SECONDARY -> -2;
                    case EMPTY -> -1;
                    case ALLY_PRIMARY, ALLY_SECONDARY -> 0;
                };

                int dist = nloc.distanceSquaredTo(myloc);
                if ((score > bestScore) || (score == bestScore && dist < bestDist)) {
                    bestScore = score;
                    bestDist = dist;
                    bestLoc = nloc;
                }
            }
        }
        
        {
            MapLocation nloc = target.add(Direction.SOUTHWEST);
            if (rc.canSenseLocation(nloc)) {
                MapInfo mi = rc.senseMapInfo(nloc);
                int score = switch (mi.getPaint()) {
                    case ENEMY_PRIMARY, ENEMY_SECONDARY -> -2;
                    case EMPTY -> -1;
                    case ALLY_PRIMARY, ALLY_SECONDARY -> 0;
                };

                int dist = nloc.distanceSquaredTo(myloc);
                if ((score > bestScore) || (score == bestScore && dist < bestDist)) {
                    bestScore = score;
                    bestDist = dist;
                    bestLoc = nloc;
                }
            }
        }
        
        {
            MapLocation nloc = target.add(Direction.WEST);
            if (rc.canSenseLocation(nloc)) {
                MapInfo mi = rc.senseMapInfo(nloc);
                int score = switch (mi.getPaint()) {
                    case ENEMY_PRIMARY, ENEMY_SECONDARY -> -2;
                    case EMPTY -> -1;
                    case ALLY_PRIMARY, ALLY_SECONDARY -> 0;
                };

                int dist = nloc.distanceSquaredTo(myloc);
                if ((score > bestScore) || (score == bestScore && dist < bestDist)) {
                    bestScore = score;
                    bestDist = dist;
                    bestLoc = nloc;
                }
            }
        }
        
        {
            MapLocation nloc = target.add(Direction.NORTHWEST);
            if (rc.canSenseLocation(nloc)) {
                MapInfo mi = rc.senseMapInfo(nloc);
                int score = switch (mi.getPaint()) {
                    case ENEMY_PRIMARY, ENEMY_SECONDARY -> -2;
                    case EMPTY -> -1;
                    case ALLY_PRIMARY, ALLY_SECONDARY -> 0;
                };

                int dist = nloc.distanceSquaredTo(myloc);
                if ((score > bestScore) || (score == bestScore && dist < bestDist)) {
                    bestScore = score;
                    bestDist = dist;
                    bestLoc = nloc;
                }
            }
        }
        
        {
            MapLocation nloc = target.add(Direction.CENTER);
            if (rc.canSenseLocation(nloc)) {
                MapInfo mi = rc.senseMapInfo(nloc);
                int score = switch (mi.getPaint()) {
                    case ENEMY_PRIMARY, ENEMY_SECONDARY -> -2;
                    case EMPTY -> -1;
                    case ALLY_PRIMARY, ALLY_SECONDARY -> 0;
                };

                int dist = nloc.distanceSquaredTo(myloc);
                if ((score > bestScore) || (score == bestScore && dist < bestDist)) {
                    bestScore = score;
                    bestDist = dist;
                    bestLoc = nloc;
                }
            }
        }
        

        if (bestLoc != null) {
            Pathing.pathTo(bestLoc);
            MapLocation newLoc = rc.getLocation();
            rc.setIndicatorString("True Mop Target " + bestLoc + " " + myloc + " " + newLoc + " " + mopTarget);
        }
    }

    public static void run() throws GameActionException {
        initTurn();
        runTurn();
        postTurn();
    }

    public static void initTurn() throws GameActionException {
        myloc = rc.getLocation();
        myPaint = rc.getPaint();
        near = rc.senseNearbyMapInfos();
        computeMopTarget();
        RefuelManager.setHome();
        boolean lowHealth = (myPaint <= (paintCapacity >> 2));
        if (lowHealth != shouldGoHome) {
            shouldGoHome = lowHealth;
            RefuelManager.reset();
        }
    }

    public static void runTurn() throws GameActionException {
        if (shouldGoHome && RefuelManager.homeState == RefuelManager.TOWER_PAINT) {
            rc.setIndicatorString("Refueling");
            RefuelManager.refuel();
            MopperAttack.mopperTryAttack();
            return;
        } else if (MopperAttack.shouldMopperMicro()) {
            rc.setIndicatorString("Mopping");
            MopperAttack.mopperAttackMicro();
            return;
        } else if (rc.getNumberTowers() < 25){
            MapLocation buildTower = TowerBuild.getRuin(near);
            if (buildTower != null) {
                TowerBuild.makeTower(buildTower);
                return;
            }
        }
        
        if (mopTarget != null) {
            rc.setIndicatorString("Seeking MopTarget " + mopTarget);
            handleMopTarget(mopTarget);
            return;
        }

        rc.setIndicatorString("Exploring " + mopTarget);
        Explore.explore(near);
    }

    public static void postTurn() throws GameActionException {
        MapLocation nloc;
        MapInfo mi;
        
        nloc = myloc.add(Direction.NORTH);
        if (rc.canSenseLocation(nloc)) {
            mi = rc.senseMapInfo(nloc);
            if (rc.canAttack(nloc) && canMop(mi)) rc.attack(nloc);
        }
        
        nloc = myloc.add(Direction.NORTHEAST);
        if (rc.canSenseLocation(nloc)) {
            mi = rc.senseMapInfo(nloc);
            if (rc.canAttack(nloc) && canMop(mi)) rc.attack(nloc);
        }
        
        nloc = myloc.add(Direction.EAST);
        if (rc.canSenseLocation(nloc)) {
            mi = rc.senseMapInfo(nloc);
            if (rc.canAttack(nloc) && canMop(mi)) rc.attack(nloc);
        }
        
        nloc = myloc.add(Direction.SOUTHEAST);
        if (rc.canSenseLocation(nloc)) {
            mi = rc.senseMapInfo(nloc);
            if (rc.canAttack(nloc) && canMop(mi)) rc.attack(nloc);
        }
        
        nloc = myloc.add(Direction.SOUTH);
        if (rc.canSenseLocation(nloc)) {
            mi = rc.senseMapInfo(nloc);
            if (rc.canAttack(nloc) && canMop(mi)) rc.attack(nloc);
        }
        
        nloc = myloc.add(Direction.SOUTHWEST);
        if (rc.canSenseLocation(nloc)) {
            mi = rc.senseMapInfo(nloc);
            if (rc.canAttack(nloc) && canMop(mi)) rc.attack(nloc);
        }
        
        nloc = myloc.add(Direction.WEST);
        if (rc.canSenseLocation(nloc)) {
            mi = rc.senseMapInfo(nloc);
            if (rc.canAttack(nloc) && canMop(mi)) rc.attack(nloc);
        }
        
        nloc = myloc.add(Direction.NORTHWEST);
        if (rc.canSenseLocation(nloc)) {
            mi = rc.senseMapInfo(nloc);
            if (rc.canAttack(nloc) && canMop(mi)) rc.attack(nloc);
        }
        
        nloc = myloc.add(Direction.CENTER);
        if (rc.canSenseLocation(nloc)) {
            mi = rc.senseMapInfo(nloc);
            if (rc.canAttack(nloc) && canMop(mi)) rc.attack(nloc);
        }
        
    }
}