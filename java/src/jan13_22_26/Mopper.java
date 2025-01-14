

package jan13_22_26;
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

    public static MapLocation seeRuin() throws GameActionException {
        MapLocation best = null;
        int closest = 100000000;
        for (int i = near.length; --i >= 0; ) {
            if (near[i].hasRuin()) {
                MapLocation m = near[i].getMapLocation();
                RobotInfo r = rc.senseRobotAtLocation(m);
                if (r == null && seeTaintedRuin(m)) {
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

    public static boolean seeTaintedRuin(MapLocation ruin) throws GameActionException {
        MapLocation tmp;
        UnitType t = Globals.getTowerToBuild();
        boolean[][] pattern = rc.getTowerPattern(t);
        
        
        
        tmp = new MapLocation(ruin.x + 2, ruin.y + 2);
        if (rc.canSenseLocation(tmp)) {
            MapInfo mi = rc.senseMapInfo(tmp);
            switch (mi.getPaint()) {
                case ENEMY_SECONDARY: return true;
                case ENEMY_PRIMARY: return true;
                default: {}
            }
        }
        
        
        
        tmp = new MapLocation(ruin.x + 2, ruin.y + 1);
        if (rc.canSenseLocation(tmp)) {
            MapInfo mi = rc.senseMapInfo(tmp);
            switch (mi.getPaint()) {
                case ENEMY_SECONDARY: return true;
                case ENEMY_PRIMARY: return true;
                default: {}
            }
        }
        
        
        
        tmp = new MapLocation(ruin.x + 2, ruin.y + 0);
        if (rc.canSenseLocation(tmp)) {
            MapInfo mi = rc.senseMapInfo(tmp);
            switch (mi.getPaint()) {
                case ENEMY_SECONDARY: return true;
                case ENEMY_PRIMARY: return true;
                default: {}
            }
        }
        
        
        
        tmp = new MapLocation(ruin.x + 2, ruin.y + -1);
        if (rc.canSenseLocation(tmp)) {
            MapInfo mi = rc.senseMapInfo(tmp);
            switch (mi.getPaint()) {
                case ENEMY_SECONDARY: return true;
                case ENEMY_PRIMARY: return true;
                default: {}
            }
        }
        
        
        
        tmp = new MapLocation(ruin.x + 2, ruin.y + -2);
        if (rc.canSenseLocation(tmp)) {
            MapInfo mi = rc.senseMapInfo(tmp);
            switch (mi.getPaint()) {
                case ENEMY_SECONDARY: return true;
                case ENEMY_PRIMARY: return true;
                default: {}
            }
        }
        
        
        
        
        
        tmp = new MapLocation(ruin.x + 1, ruin.y + 2);
        if (rc.canSenseLocation(tmp)) {
            MapInfo mi = rc.senseMapInfo(tmp);
            switch (mi.getPaint()) {
                case ENEMY_SECONDARY: return true;
                case ENEMY_PRIMARY: return true;
                default: {}
            }
        }
        
        
        
        tmp = new MapLocation(ruin.x + 1, ruin.y + 1);
        if (rc.canSenseLocation(tmp)) {
            MapInfo mi = rc.senseMapInfo(tmp);
            switch (mi.getPaint()) {
                case ENEMY_SECONDARY: return true;
                case ENEMY_PRIMARY: return true;
                default: {}
            }
        }
        
        
        
        tmp = new MapLocation(ruin.x + 1, ruin.y + 0);
        if (rc.canSenseLocation(tmp)) {
            MapInfo mi = rc.senseMapInfo(tmp);
            switch (mi.getPaint()) {
                case ENEMY_SECONDARY: return true;
                case ENEMY_PRIMARY: return true;
                default: {}
            }
        }
        
        
        
        tmp = new MapLocation(ruin.x + 1, ruin.y + -1);
        if (rc.canSenseLocation(tmp)) {
            MapInfo mi = rc.senseMapInfo(tmp);
            switch (mi.getPaint()) {
                case ENEMY_SECONDARY: return true;
                case ENEMY_PRIMARY: return true;
                default: {}
            }
        }
        
        
        
        tmp = new MapLocation(ruin.x + 1, ruin.y + -2);
        if (rc.canSenseLocation(tmp)) {
            MapInfo mi = rc.senseMapInfo(tmp);
            switch (mi.getPaint()) {
                case ENEMY_SECONDARY: return true;
                case ENEMY_PRIMARY: return true;
                default: {}
            }
        }
        
        
        
        
        
        tmp = new MapLocation(ruin.x + 0, ruin.y + 2);
        if (rc.canSenseLocation(tmp)) {
            MapInfo mi = rc.senseMapInfo(tmp);
            switch (mi.getPaint()) {
                case ENEMY_SECONDARY: return true;
                case ENEMY_PRIMARY: return true;
                default: {}
            }
        }
        
        
        
        tmp = new MapLocation(ruin.x + 0, ruin.y + 1);
        if (rc.canSenseLocation(tmp)) {
            MapInfo mi = rc.senseMapInfo(tmp);
            switch (mi.getPaint()) {
                case ENEMY_SECONDARY: return true;
                case ENEMY_PRIMARY: return true;
                default: {}
            }
        }
        
        
        
        
        
        tmp = new MapLocation(ruin.x + 0, ruin.y + -1);
        if (rc.canSenseLocation(tmp)) {
            MapInfo mi = rc.senseMapInfo(tmp);
            switch (mi.getPaint()) {
                case ENEMY_SECONDARY: return true;
                case ENEMY_PRIMARY: return true;
                default: {}
            }
        }
        
        
        
        tmp = new MapLocation(ruin.x + 0, ruin.y + -2);
        if (rc.canSenseLocation(tmp)) {
            MapInfo mi = rc.senseMapInfo(tmp);
            switch (mi.getPaint()) {
                case ENEMY_SECONDARY: return true;
                case ENEMY_PRIMARY: return true;
                default: {}
            }
        }
        
        
        
        
        
        tmp = new MapLocation(ruin.x + -1, ruin.y + 2);
        if (rc.canSenseLocation(tmp)) {
            MapInfo mi = rc.senseMapInfo(tmp);
            switch (mi.getPaint()) {
                case ENEMY_SECONDARY: return true;
                case ENEMY_PRIMARY: return true;
                default: {}
            }
        }
        
        
        
        tmp = new MapLocation(ruin.x + -1, ruin.y + 1);
        if (rc.canSenseLocation(tmp)) {
            MapInfo mi = rc.senseMapInfo(tmp);
            switch (mi.getPaint()) {
                case ENEMY_SECONDARY: return true;
                case ENEMY_PRIMARY: return true;
                default: {}
            }
        }
        
        
        
        tmp = new MapLocation(ruin.x + -1, ruin.y + 0);
        if (rc.canSenseLocation(tmp)) {
            MapInfo mi = rc.senseMapInfo(tmp);
            switch (mi.getPaint()) {
                case ENEMY_SECONDARY: return true;
                case ENEMY_PRIMARY: return true;
                default: {}
            }
        }
        
        
        
        tmp = new MapLocation(ruin.x + -1, ruin.y + -1);
        if (rc.canSenseLocation(tmp)) {
            MapInfo mi = rc.senseMapInfo(tmp);
            switch (mi.getPaint()) {
                case ENEMY_SECONDARY: return true;
                case ENEMY_PRIMARY: return true;
                default: {}
            }
        }
        
        
        
        tmp = new MapLocation(ruin.x + -1, ruin.y + -2);
        if (rc.canSenseLocation(tmp)) {
            MapInfo mi = rc.senseMapInfo(tmp);
            switch (mi.getPaint()) {
                case ENEMY_SECONDARY: return true;
                case ENEMY_PRIMARY: return true;
                default: {}
            }
        }
        
        
        
        
        
        tmp = new MapLocation(ruin.x + -2, ruin.y + 2);
        if (rc.canSenseLocation(tmp)) {
            MapInfo mi = rc.senseMapInfo(tmp);
            switch (mi.getPaint()) {
                case ENEMY_SECONDARY: return true;
                case ENEMY_PRIMARY: return true;
                default: {}
            }
        }
        
        
        
        tmp = new MapLocation(ruin.x + -2, ruin.y + 1);
        if (rc.canSenseLocation(tmp)) {
            MapInfo mi = rc.senseMapInfo(tmp);
            switch (mi.getPaint()) {
                case ENEMY_SECONDARY: return true;
                case ENEMY_PRIMARY: return true;
                default: {}
            }
        }
        
        
        
        tmp = new MapLocation(ruin.x + -2, ruin.y + 0);
        if (rc.canSenseLocation(tmp)) {
            MapInfo mi = rc.senseMapInfo(tmp);
            switch (mi.getPaint()) {
                case ENEMY_SECONDARY: return true;
                case ENEMY_PRIMARY: return true;
                default: {}
            }
        }
        
        
        
        tmp = new MapLocation(ruin.x + -2, ruin.y + -1);
        if (rc.canSenseLocation(tmp)) {
            MapInfo mi = rc.senseMapInfo(tmp);
            switch (mi.getPaint()) {
                case ENEMY_SECONDARY: return true;
                case ENEMY_PRIMARY: return true;
                default: {}
            }
        }
        
        
        
        tmp = new MapLocation(ruin.x + -2, ruin.y + -2);
        if (rc.canSenseLocation(tmp)) {
            MapInfo mi = rc.senseMapInfo(tmp);
            switch (mi.getPaint()) {
                case ENEMY_SECONDARY: return true;
                case ENEMY_PRIMARY: return true;
                default: {}
            }
        }
        
        
        

        return false;
    }

    public static void makeTower() throws GameActionException {
        assert(buildTower != null);
        MapLocation tmp;
        MapLocation goal = null;
        int bestDist = 1000000000;
        
        
        
        tmp = new MapLocation(buildTower.x + 2, buildTower.y + 2);
        if (rc.canSenseLocation(tmp)) {
            MapInfo mi = rc.senseMapInfo(tmp);
            switch (mi.getPaint()) {
                case ENEMY_SECONDARY, ENEMY_PRIMARY -> {
                    int d = rc.getLocation().distanceSquaredTo(tmp);
                    if (d < bestDist) {
                        bestDist = d;
                        goal = tmp;
                    }
                }
            }
        }
        
        
        
        tmp = new MapLocation(buildTower.x + 2, buildTower.y + 1);
        if (rc.canSenseLocation(tmp)) {
            MapInfo mi = rc.senseMapInfo(tmp);
            switch (mi.getPaint()) {
                case ENEMY_SECONDARY, ENEMY_PRIMARY -> {
                    int d = rc.getLocation().distanceSquaredTo(tmp);
                    if (d < bestDist) {
                        bestDist = d;
                        goal = tmp;
                    }
                }
            }
        }
        
        
        
        tmp = new MapLocation(buildTower.x + 2, buildTower.y + 0);
        if (rc.canSenseLocation(tmp)) {
            MapInfo mi = rc.senseMapInfo(tmp);
            switch (mi.getPaint()) {
                case ENEMY_SECONDARY, ENEMY_PRIMARY -> {
                    int d = rc.getLocation().distanceSquaredTo(tmp);
                    if (d < bestDist) {
                        bestDist = d;
                        goal = tmp;
                    }
                }
            }
        }
        
        
        
        tmp = new MapLocation(buildTower.x + 2, buildTower.y + -1);
        if (rc.canSenseLocation(tmp)) {
            MapInfo mi = rc.senseMapInfo(tmp);
            switch (mi.getPaint()) {
                case ENEMY_SECONDARY, ENEMY_PRIMARY -> {
                    int d = rc.getLocation().distanceSquaredTo(tmp);
                    if (d < bestDist) {
                        bestDist = d;
                        goal = tmp;
                    }
                }
            }
        }
        
        
        
        tmp = new MapLocation(buildTower.x + 2, buildTower.y + -2);
        if (rc.canSenseLocation(tmp)) {
            MapInfo mi = rc.senseMapInfo(tmp);
            switch (mi.getPaint()) {
                case ENEMY_SECONDARY, ENEMY_PRIMARY -> {
                    int d = rc.getLocation().distanceSquaredTo(tmp);
                    if (d < bestDist) {
                        bestDist = d;
                        goal = tmp;
                    }
                }
            }
        }
        
        
        
        
        
        tmp = new MapLocation(buildTower.x + 1, buildTower.y + 2);
        if (rc.canSenseLocation(tmp)) {
            MapInfo mi = rc.senseMapInfo(tmp);
            switch (mi.getPaint()) {
                case ENEMY_SECONDARY, ENEMY_PRIMARY -> {
                    int d = rc.getLocation().distanceSquaredTo(tmp);
                    if (d < bestDist) {
                        bestDist = d;
                        goal = tmp;
                    }
                }
            }
        }
        
        
        
        tmp = new MapLocation(buildTower.x + 1, buildTower.y + 1);
        if (rc.canSenseLocation(tmp)) {
            MapInfo mi = rc.senseMapInfo(tmp);
            switch (mi.getPaint()) {
                case ENEMY_SECONDARY, ENEMY_PRIMARY -> {
                    int d = rc.getLocation().distanceSquaredTo(tmp);
                    if (d < bestDist) {
                        bestDist = d;
                        goal = tmp;
                    }
                }
            }
        }
        
        
        
        tmp = new MapLocation(buildTower.x + 1, buildTower.y + 0);
        if (rc.canSenseLocation(tmp)) {
            MapInfo mi = rc.senseMapInfo(tmp);
            switch (mi.getPaint()) {
                case ENEMY_SECONDARY, ENEMY_PRIMARY -> {
                    int d = rc.getLocation().distanceSquaredTo(tmp);
                    if (d < bestDist) {
                        bestDist = d;
                        goal = tmp;
                    }
                }
            }
        }
        
        
        
        tmp = new MapLocation(buildTower.x + 1, buildTower.y + -1);
        if (rc.canSenseLocation(tmp)) {
            MapInfo mi = rc.senseMapInfo(tmp);
            switch (mi.getPaint()) {
                case ENEMY_SECONDARY, ENEMY_PRIMARY -> {
                    int d = rc.getLocation().distanceSquaredTo(tmp);
                    if (d < bestDist) {
                        bestDist = d;
                        goal = tmp;
                    }
                }
            }
        }
        
        
        
        tmp = new MapLocation(buildTower.x + 1, buildTower.y + -2);
        if (rc.canSenseLocation(tmp)) {
            MapInfo mi = rc.senseMapInfo(tmp);
            switch (mi.getPaint()) {
                case ENEMY_SECONDARY, ENEMY_PRIMARY -> {
                    int d = rc.getLocation().distanceSquaredTo(tmp);
                    if (d < bestDist) {
                        bestDist = d;
                        goal = tmp;
                    }
                }
            }
        }
        
        
        
        
        
        tmp = new MapLocation(buildTower.x + 0, buildTower.y + 2);
        if (rc.canSenseLocation(tmp)) {
            MapInfo mi = rc.senseMapInfo(tmp);
            switch (mi.getPaint()) {
                case ENEMY_SECONDARY, ENEMY_PRIMARY -> {
                    int d = rc.getLocation().distanceSquaredTo(tmp);
                    if (d < bestDist) {
                        bestDist = d;
                        goal = tmp;
                    }
                }
            }
        }
        
        
        
        tmp = new MapLocation(buildTower.x + 0, buildTower.y + 1);
        if (rc.canSenseLocation(tmp)) {
            MapInfo mi = rc.senseMapInfo(tmp);
            switch (mi.getPaint()) {
                case ENEMY_SECONDARY, ENEMY_PRIMARY -> {
                    int d = rc.getLocation().distanceSquaredTo(tmp);
                    if (d < bestDist) {
                        bestDist = d;
                        goal = tmp;
                    }
                }
            }
        }
        
        
        
        
        
        tmp = new MapLocation(buildTower.x + 0, buildTower.y + -1);
        if (rc.canSenseLocation(tmp)) {
            MapInfo mi = rc.senseMapInfo(tmp);
            switch (mi.getPaint()) {
                case ENEMY_SECONDARY, ENEMY_PRIMARY -> {
                    int d = rc.getLocation().distanceSquaredTo(tmp);
                    if (d < bestDist) {
                        bestDist = d;
                        goal = tmp;
                    }
                }
            }
        }
        
        
        
        tmp = new MapLocation(buildTower.x + 0, buildTower.y + -2);
        if (rc.canSenseLocation(tmp)) {
            MapInfo mi = rc.senseMapInfo(tmp);
            switch (mi.getPaint()) {
                case ENEMY_SECONDARY, ENEMY_PRIMARY -> {
                    int d = rc.getLocation().distanceSquaredTo(tmp);
                    if (d < bestDist) {
                        bestDist = d;
                        goal = tmp;
                    }
                }
            }
        }
        
        
        
        
        
        tmp = new MapLocation(buildTower.x + -1, buildTower.y + 2);
        if (rc.canSenseLocation(tmp)) {
            MapInfo mi = rc.senseMapInfo(tmp);
            switch (mi.getPaint()) {
                case ENEMY_SECONDARY, ENEMY_PRIMARY -> {
                    int d = rc.getLocation().distanceSquaredTo(tmp);
                    if (d < bestDist) {
                        bestDist = d;
                        goal = tmp;
                    }
                }
            }
        }
        
        
        
        tmp = new MapLocation(buildTower.x + -1, buildTower.y + 1);
        if (rc.canSenseLocation(tmp)) {
            MapInfo mi = rc.senseMapInfo(tmp);
            switch (mi.getPaint()) {
                case ENEMY_SECONDARY, ENEMY_PRIMARY -> {
                    int d = rc.getLocation().distanceSquaredTo(tmp);
                    if (d < bestDist) {
                        bestDist = d;
                        goal = tmp;
                    }
                }
            }
        }
        
        
        
        tmp = new MapLocation(buildTower.x + -1, buildTower.y + 0);
        if (rc.canSenseLocation(tmp)) {
            MapInfo mi = rc.senseMapInfo(tmp);
            switch (mi.getPaint()) {
                case ENEMY_SECONDARY, ENEMY_PRIMARY -> {
                    int d = rc.getLocation().distanceSquaredTo(tmp);
                    if (d < bestDist) {
                        bestDist = d;
                        goal = tmp;
                    }
                }
            }
        }
        
        
        
        tmp = new MapLocation(buildTower.x + -1, buildTower.y + -1);
        if (rc.canSenseLocation(tmp)) {
            MapInfo mi = rc.senseMapInfo(tmp);
            switch (mi.getPaint()) {
                case ENEMY_SECONDARY, ENEMY_PRIMARY -> {
                    int d = rc.getLocation().distanceSquaredTo(tmp);
                    if (d < bestDist) {
                        bestDist = d;
                        goal = tmp;
                    }
                }
            }
        }
        
        
        
        tmp = new MapLocation(buildTower.x + -1, buildTower.y + -2);
        if (rc.canSenseLocation(tmp)) {
            MapInfo mi = rc.senseMapInfo(tmp);
            switch (mi.getPaint()) {
                case ENEMY_SECONDARY, ENEMY_PRIMARY -> {
                    int d = rc.getLocation().distanceSquaredTo(tmp);
                    if (d < bestDist) {
                        bestDist = d;
                        goal = tmp;
                    }
                }
            }
        }
        
        
        
        
        
        tmp = new MapLocation(buildTower.x + -2, buildTower.y + 2);
        if (rc.canSenseLocation(tmp)) {
            MapInfo mi = rc.senseMapInfo(tmp);
            switch (mi.getPaint()) {
                case ENEMY_SECONDARY, ENEMY_PRIMARY -> {
                    int d = rc.getLocation().distanceSquaredTo(tmp);
                    if (d < bestDist) {
                        bestDist = d;
                        goal = tmp;
                    }
                }
            }
        }
        
        
        
        tmp = new MapLocation(buildTower.x + -2, buildTower.y + 1);
        if (rc.canSenseLocation(tmp)) {
            MapInfo mi = rc.senseMapInfo(tmp);
            switch (mi.getPaint()) {
                case ENEMY_SECONDARY, ENEMY_PRIMARY -> {
                    int d = rc.getLocation().distanceSquaredTo(tmp);
                    if (d < bestDist) {
                        bestDist = d;
                        goal = tmp;
                    }
                }
            }
        }
        
        
        
        tmp = new MapLocation(buildTower.x + -2, buildTower.y + 0);
        if (rc.canSenseLocation(tmp)) {
            MapInfo mi = rc.senseMapInfo(tmp);
            switch (mi.getPaint()) {
                case ENEMY_SECONDARY, ENEMY_PRIMARY -> {
                    int d = rc.getLocation().distanceSquaredTo(tmp);
                    if (d < bestDist) {
                        bestDist = d;
                        goal = tmp;
                    }
                }
            }
        }
        
        
        
        tmp = new MapLocation(buildTower.x + -2, buildTower.y + -1);
        if (rc.canSenseLocation(tmp)) {
            MapInfo mi = rc.senseMapInfo(tmp);
            switch (mi.getPaint()) {
                case ENEMY_SECONDARY, ENEMY_PRIMARY -> {
                    int d = rc.getLocation().distanceSquaredTo(tmp);
                    if (d < bestDist) {
                        bestDist = d;
                        goal = tmp;
                    }
                }
            }
        }
        
        
        
        tmp = new MapLocation(buildTower.x + -2, buildTower.y + -2);
        if (rc.canSenseLocation(tmp)) {
            MapInfo mi = rc.senseMapInfo(tmp);
            switch (mi.getPaint()) {
                case ENEMY_SECONDARY, ENEMY_PRIMARY -> {
                    int d = rc.getLocation().distanceSquaredTo(tmp);
                    if (d < bestDist) {
                        bestDist = d;
                        goal = tmp;
                    }
                }
            }
        }
        
        
        

        if (goal != null) {
            if (rc.canAttack(goal)) {
                rc.attack(goal);
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

    public static boolean isBuilt(MapLocation ruinLoc) throws GameActionException {
        if (rc.canSenseLocation(ruinLoc)) {
            RobotInfo r = rc.senseRobotAtLocation(ruinLoc);
            return (r != null);
        }
        return false;
    }

    public static void run() throws GameActionException {
        init();
        runTurn();
        postTurn();
    }

    public static void init() throws GameActionException {
        myloc = rc.getLocation();
        myPaint = rc.getPaint();
        near = rc.senseNearbyMapInfos();
        RefuelManager.setHome();
        boolean lowHealth = (myPaint <= (paintCapacity >> 2));
        if (lowHealth != shouldGoHome) {
            shouldGoHome = lowHealth;
            RefuelManager.reset();
        }
    }

    public static void runTurn() throws GameActionException {
        if (shouldGoHome) { 
            rc.setIndicatorString("Refueling");
            RefuelManager.refuel();
            return;
        }
        else if (Attack.shouldMopperMicro()) {
            rc.setIndicatorString("Mopping");
            Attack.mopperAttackMicro();
            return;
        }
        else if (rc.getNumberTowers() < 25){
            buildTower = null;
            ruinLoc = seeRuin();
            if (ruinLoc != null) {
                rc.setIndicatorString("Building");
                buildTower = ruinLoc;
                makeTower();
            }
        }
        
        Explore.exploreOnPaint(near);
    }

    public static void postTurn() throws GameActionException {
        MapLocation nloc;
        MapInfo mi;
        
        nloc = myloc.add(Direction.NORTH);
        mi = rc.senseMapInfo(nloc);
        if (rc.canAttack(nloc) && canMop(mi)) rc.attack(nloc);
        
        nloc = myloc.add(Direction.NORTHEAST);
        mi = rc.senseMapInfo(nloc);
        if (rc.canAttack(nloc) && canMop(mi)) rc.attack(nloc);
        
        nloc = myloc.add(Direction.EAST);
        mi = rc.senseMapInfo(nloc);
        if (rc.canAttack(nloc) && canMop(mi)) rc.attack(nloc);
        
        nloc = myloc.add(Direction.SOUTHEAST);
        mi = rc.senseMapInfo(nloc);
        if (rc.canAttack(nloc) && canMop(mi)) rc.attack(nloc);
        
        nloc = myloc.add(Direction.SOUTH);
        mi = rc.senseMapInfo(nloc);
        if (rc.canAttack(nloc) && canMop(mi)) rc.attack(nloc);
        
        nloc = myloc.add(Direction.SOUTHWEST);
        mi = rc.senseMapInfo(nloc);
        if (rc.canAttack(nloc) && canMop(mi)) rc.attack(nloc);
        
        nloc = myloc.add(Direction.WEST);
        mi = rc.senseMapInfo(nloc);
        if (rc.canAttack(nloc) && canMop(mi)) rc.attack(nloc);
        
        nloc = myloc.add(Direction.NORTHWEST);
        mi = rc.senseMapInfo(nloc);
        if (rc.canAttack(nloc) && canMop(mi)) rc.attack(nloc);
        
        nloc = myloc.add(Direction.CENTER);
        mi = rc.senseMapInfo(nloc);
        if (rc.canAttack(nloc) && canMop(mi)) rc.attack(nloc);
        
    }
}