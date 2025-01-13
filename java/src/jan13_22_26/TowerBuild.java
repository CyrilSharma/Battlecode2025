package jan13_22_26;
import battlecode.common.*;

public class TowerBuild {
    public static RobotController rc;
    public static int[][] last;
    public static int[] dx = {0, 1, 1, 1, 0, -1, -1, -1};
    public static int[] dy = {1, 1, 0, -1, -1, -1, 0, 1};
    public static void init(RobotController rc) {
        TowerBuild.rc = rc;
        last = new int[rc.getMapWidth()][rc.getMapHeight()];
    }

    public static MapLocation getRuin(MapInfo[] near) throws GameActionException {
        MapLocation best = null;
        int closest = 100000000;
        for (int i = near.length; --i >= 0; ) {
            if (near[i].hasRuin()) {
                MapLocation m = near[i].getMapLocation();
                RobotInfo r = rc.senseRobotAtLocation(m);
                if (r == null) {
                    int d = m.distanceSquaredTo(rc.getLocation());
                    if (d < closest && rc.getRoundNum() > last[m.x][m.y]) {
                        closest = d;
                        best = m;
                    }
                }
            }
        }
        return best;
    }

    public static void makeTower(MapLocation buildTower) throws GameActionException {

        UnitType t = Globals.getTowerToBuild();
        boolean[][] pattern = rc.getTowerPattern(t);

        MapLocation tmp;
        MapLocation goal = null;
        boolean secondCol = false;
        int bestDist = 1000000000;
        
        
        
        tmp = new MapLocation(buildTower.x + 2, buildTower.y + 2);
        if (rc.canSenseLocation(tmp)) {
            MapInfo mi = rc.senseMapInfo(tmp);
            switch (mi.getPaint()) {
                case ENEMY_SECONDARY, ENEMY_PRIMARY -> {
                    if (rc.getType() == UnitType.MOPPER) {
                        int d = rc.getLocation().distanceSquaredTo(tmp);
                        if (d < bestDist) {
                            bestDist = d;
                            goal = tmp;
                        }
                    }
                }
                default -> {
                    if (rc.getType() == UnitType.SOLDIER) {
                        boolean isSecondary = (mi.getPaint() == PaintType.ALLY_SECONDARY);
                        boolean targetSecondary = pattern[4][4];
                        if ((mi.getPaint() == PaintType.EMPTY) || (isSecondary != targetSecondary)) {
                            int d = rc.getLocation().distanceSquaredTo(tmp);
                            if (d < bestDist) {
                                bestDist = d;
                                goal = tmp;
                                secondCol = targetSecondary;
                            }
                        }
                    }
                }
            }
        }
        
        
        
        tmp = new MapLocation(buildTower.x + 2, buildTower.y + 1);
        if (rc.canSenseLocation(tmp)) {
            MapInfo mi = rc.senseMapInfo(tmp);
            switch (mi.getPaint()) {
                case ENEMY_SECONDARY, ENEMY_PRIMARY -> {
                    if (rc.getType() == UnitType.MOPPER) {
                        int d = rc.getLocation().distanceSquaredTo(tmp);
                        if (d < bestDist) {
                            bestDist = d;
                            goal = tmp;
                        }
                    }
                }
                default -> {
                    if (rc.getType() == UnitType.SOLDIER) {
                        boolean isSecondary = (mi.getPaint() == PaintType.ALLY_SECONDARY);
                        boolean targetSecondary = pattern[4][3];
                        if ((mi.getPaint() == PaintType.EMPTY) || (isSecondary != targetSecondary)) {
                            int d = rc.getLocation().distanceSquaredTo(tmp);
                            if (d < bestDist) {
                                bestDist = d;
                                goal = tmp;
                                secondCol = targetSecondary;
                            }
                        }
                    }
                }
            }
        }
        
        
        
        tmp = new MapLocation(buildTower.x + 2, buildTower.y + 0);
        if (rc.canSenseLocation(tmp)) {
            MapInfo mi = rc.senseMapInfo(tmp);
            switch (mi.getPaint()) {
                case ENEMY_SECONDARY, ENEMY_PRIMARY -> {
                    if (rc.getType() == UnitType.MOPPER) {
                        int d = rc.getLocation().distanceSquaredTo(tmp);
                        if (d < bestDist) {
                            bestDist = d;
                            goal = tmp;
                        }
                    }
                }
                default -> {
                    if (rc.getType() == UnitType.SOLDIER) {
                        boolean isSecondary = (mi.getPaint() == PaintType.ALLY_SECONDARY);
                        boolean targetSecondary = pattern[4][2];
                        if ((mi.getPaint() == PaintType.EMPTY) || (isSecondary != targetSecondary)) {
                            int d = rc.getLocation().distanceSquaredTo(tmp);
                            if (d < bestDist) {
                                bestDist = d;
                                goal = tmp;
                                secondCol = targetSecondary;
                            }
                        }
                    }
                }
            }
        }
        
        
        
        tmp = new MapLocation(buildTower.x + 2, buildTower.y + -1);
        if (rc.canSenseLocation(tmp)) {
            MapInfo mi = rc.senseMapInfo(tmp);
            switch (mi.getPaint()) {
                case ENEMY_SECONDARY, ENEMY_PRIMARY -> {
                    if (rc.getType() == UnitType.MOPPER) {
                        int d = rc.getLocation().distanceSquaredTo(tmp);
                        if (d < bestDist) {
                            bestDist = d;
                            goal = tmp;
                        }
                    }
                }
                default -> {
                    if (rc.getType() == UnitType.SOLDIER) {
                        boolean isSecondary = (mi.getPaint() == PaintType.ALLY_SECONDARY);
                        boolean targetSecondary = pattern[4][1];
                        if ((mi.getPaint() == PaintType.EMPTY) || (isSecondary != targetSecondary)) {
                            int d = rc.getLocation().distanceSquaredTo(tmp);
                            if (d < bestDist) {
                                bestDist = d;
                                goal = tmp;
                                secondCol = targetSecondary;
                            }
                        }
                    }
                }
            }
        }
        
        
        
        tmp = new MapLocation(buildTower.x + 2, buildTower.y + -2);
        if (rc.canSenseLocation(tmp)) {
            MapInfo mi = rc.senseMapInfo(tmp);
            switch (mi.getPaint()) {
                case ENEMY_SECONDARY, ENEMY_PRIMARY -> {
                    if (rc.getType() == UnitType.MOPPER) {
                        int d = rc.getLocation().distanceSquaredTo(tmp);
                        if (d < bestDist) {
                            bestDist = d;
                            goal = tmp;
                        }
                    }
                }
                default -> {
                    if (rc.getType() == UnitType.SOLDIER) {
                        boolean isSecondary = (mi.getPaint() == PaintType.ALLY_SECONDARY);
                        boolean targetSecondary = pattern[4][0];
                        if ((mi.getPaint() == PaintType.EMPTY) || (isSecondary != targetSecondary)) {
                            int d = rc.getLocation().distanceSquaredTo(tmp);
                            if (d < bestDist) {
                                bestDist = d;
                                goal = tmp;
                                secondCol = targetSecondary;
                            }
                        }
                    }
                }
            }
        }
        
        
        
        
        
        tmp = new MapLocation(buildTower.x + 1, buildTower.y + 2);
        if (rc.canSenseLocation(tmp)) {
            MapInfo mi = rc.senseMapInfo(tmp);
            switch (mi.getPaint()) {
                case ENEMY_SECONDARY, ENEMY_PRIMARY -> {
                    if (rc.getType() == UnitType.MOPPER) {
                        int d = rc.getLocation().distanceSquaredTo(tmp);
                        if (d < bestDist) {
                            bestDist = d;
                            goal = tmp;
                        }
                    }
                }
                default -> {
                    if (rc.getType() == UnitType.SOLDIER) {
                        boolean isSecondary = (mi.getPaint() == PaintType.ALLY_SECONDARY);
                        boolean targetSecondary = pattern[3][4];
                        if ((mi.getPaint() == PaintType.EMPTY) || (isSecondary != targetSecondary)) {
                            int d = rc.getLocation().distanceSquaredTo(tmp);
                            if (d < bestDist) {
                                bestDist = d;
                                goal = tmp;
                                secondCol = targetSecondary;
                            }
                        }
                    }
                }
            }
        }
        
        
        
        tmp = new MapLocation(buildTower.x + 1, buildTower.y + 1);
        if (rc.canSenseLocation(tmp)) {
            MapInfo mi = rc.senseMapInfo(tmp);
            switch (mi.getPaint()) {
                case ENEMY_SECONDARY, ENEMY_PRIMARY -> {
                    if (rc.getType() == UnitType.MOPPER) {
                        int d = rc.getLocation().distanceSquaredTo(tmp);
                        if (d < bestDist) {
                            bestDist = d;
                            goal = tmp;
                        }
                    }
                }
                default -> {
                    if (rc.getType() == UnitType.SOLDIER) {
                        boolean isSecondary = (mi.getPaint() == PaintType.ALLY_SECONDARY);
                        boolean targetSecondary = pattern[3][3];
                        if ((mi.getPaint() == PaintType.EMPTY) || (isSecondary != targetSecondary)) {
                            int d = rc.getLocation().distanceSquaredTo(tmp);
                            if (d < bestDist) {
                                bestDist = d;
                                goal = tmp;
                                secondCol = targetSecondary;
                            }
                        }
                    }
                }
            }
        }
        
        
        
        tmp = new MapLocation(buildTower.x + 1, buildTower.y + 0);
        if (rc.canSenseLocation(tmp)) {
            MapInfo mi = rc.senseMapInfo(tmp);
            switch (mi.getPaint()) {
                case ENEMY_SECONDARY, ENEMY_PRIMARY -> {
                    if (rc.getType() == UnitType.MOPPER) {
                        int d = rc.getLocation().distanceSquaredTo(tmp);
                        if (d < bestDist) {
                            bestDist = d;
                            goal = tmp;
                        }
                    }
                }
                default -> {
                    if (rc.getType() == UnitType.SOLDIER) {
                        boolean isSecondary = (mi.getPaint() == PaintType.ALLY_SECONDARY);
                        boolean targetSecondary = pattern[3][2];
                        if ((mi.getPaint() == PaintType.EMPTY) || (isSecondary != targetSecondary)) {
                            int d = rc.getLocation().distanceSquaredTo(tmp);
                            if (d < bestDist) {
                                bestDist = d;
                                goal = tmp;
                                secondCol = targetSecondary;
                            }
                        }
                    }
                }
            }
        }
        
        
        
        tmp = new MapLocation(buildTower.x + 1, buildTower.y + -1);
        if (rc.canSenseLocation(tmp)) {
            MapInfo mi = rc.senseMapInfo(tmp);
            switch (mi.getPaint()) {
                case ENEMY_SECONDARY, ENEMY_PRIMARY -> {
                    if (rc.getType() == UnitType.MOPPER) {
                        int d = rc.getLocation().distanceSquaredTo(tmp);
                        if (d < bestDist) {
                            bestDist = d;
                            goal = tmp;
                        }
                    }
                }
                default -> {
                    if (rc.getType() == UnitType.SOLDIER) {
                        boolean isSecondary = (mi.getPaint() == PaintType.ALLY_SECONDARY);
                        boolean targetSecondary = pattern[3][1];
                        if ((mi.getPaint() == PaintType.EMPTY) || (isSecondary != targetSecondary)) {
                            int d = rc.getLocation().distanceSquaredTo(tmp);
                            if (d < bestDist) {
                                bestDist = d;
                                goal = tmp;
                                secondCol = targetSecondary;
                            }
                        }
                    }
                }
            }
        }
        
        
        
        tmp = new MapLocation(buildTower.x + 1, buildTower.y + -2);
        if (rc.canSenseLocation(tmp)) {
            MapInfo mi = rc.senseMapInfo(tmp);
            switch (mi.getPaint()) {
                case ENEMY_SECONDARY, ENEMY_PRIMARY -> {
                    if (rc.getType() == UnitType.MOPPER) {
                        int d = rc.getLocation().distanceSquaredTo(tmp);
                        if (d < bestDist) {
                            bestDist = d;
                            goal = tmp;
                        }
                    }
                }
                default -> {
                    if (rc.getType() == UnitType.SOLDIER) {
                        boolean isSecondary = (mi.getPaint() == PaintType.ALLY_SECONDARY);
                        boolean targetSecondary = pattern[3][0];
                        if ((mi.getPaint() == PaintType.EMPTY) || (isSecondary != targetSecondary)) {
                            int d = rc.getLocation().distanceSquaredTo(tmp);
                            if (d < bestDist) {
                                bestDist = d;
                                goal = tmp;
                                secondCol = targetSecondary;
                            }
                        }
                    }
                }
            }
        }
        
        
        
        
        
        tmp = new MapLocation(buildTower.x + 0, buildTower.y + 2);
        if (rc.canSenseLocation(tmp)) {
            MapInfo mi = rc.senseMapInfo(tmp);
            switch (mi.getPaint()) {
                case ENEMY_SECONDARY, ENEMY_PRIMARY -> {
                    if (rc.getType() == UnitType.MOPPER) {
                        int d = rc.getLocation().distanceSquaredTo(tmp);
                        if (d < bestDist) {
                            bestDist = d;
                            goal = tmp;
                        }
                    }
                }
                default -> {
                    if (rc.getType() == UnitType.SOLDIER) {
                        boolean isSecondary = (mi.getPaint() == PaintType.ALLY_SECONDARY);
                        boolean targetSecondary = pattern[2][4];
                        if ((mi.getPaint() == PaintType.EMPTY) || (isSecondary != targetSecondary)) {
                            int d = rc.getLocation().distanceSquaredTo(tmp);
                            if (d < bestDist) {
                                bestDist = d;
                                goal = tmp;
                                secondCol = targetSecondary;
                            }
                        }
                    }
                }
            }
        }
        
        
        
        tmp = new MapLocation(buildTower.x + 0, buildTower.y + 1);
        if (rc.canSenseLocation(tmp)) {
            MapInfo mi = rc.senseMapInfo(tmp);
            switch (mi.getPaint()) {
                case ENEMY_SECONDARY, ENEMY_PRIMARY -> {
                    if (rc.getType() == UnitType.MOPPER) {
                        int d = rc.getLocation().distanceSquaredTo(tmp);
                        if (d < bestDist) {
                            bestDist = d;
                            goal = tmp;
                        }
                    }
                }
                default -> {
                    if (rc.getType() == UnitType.SOLDIER) {
                        boolean isSecondary = (mi.getPaint() == PaintType.ALLY_SECONDARY);
                        boolean targetSecondary = pattern[2][3];
                        if ((mi.getPaint() == PaintType.EMPTY) || (isSecondary != targetSecondary)) {
                            int d = rc.getLocation().distanceSquaredTo(tmp);
                            if (d < bestDist) {
                                bestDist = d;
                                goal = tmp;
                                secondCol = targetSecondary;
                            }
                        }
                    }
                }
            }
        }
        
        
        
        
        
        tmp = new MapLocation(buildTower.x + 0, buildTower.y + -1);
        if (rc.canSenseLocation(tmp)) {
            MapInfo mi = rc.senseMapInfo(tmp);
            switch (mi.getPaint()) {
                case ENEMY_SECONDARY, ENEMY_PRIMARY -> {
                    if (rc.getType() == UnitType.MOPPER) {
                        int d = rc.getLocation().distanceSquaredTo(tmp);
                        if (d < bestDist) {
                            bestDist = d;
                            goal = tmp;
                        }
                    }
                }
                default -> {
                    if (rc.getType() == UnitType.SOLDIER) {
                        boolean isSecondary = (mi.getPaint() == PaintType.ALLY_SECONDARY);
                        boolean targetSecondary = pattern[2][1];
                        if ((mi.getPaint() == PaintType.EMPTY) || (isSecondary != targetSecondary)) {
                            int d = rc.getLocation().distanceSquaredTo(tmp);
                            if (d < bestDist) {
                                bestDist = d;
                                goal = tmp;
                                secondCol = targetSecondary;
                            }
                        }
                    }
                }
            }
        }
        
        
        
        tmp = new MapLocation(buildTower.x + 0, buildTower.y + -2);
        if (rc.canSenseLocation(tmp)) {
            MapInfo mi = rc.senseMapInfo(tmp);
            switch (mi.getPaint()) {
                case ENEMY_SECONDARY, ENEMY_PRIMARY -> {
                    if (rc.getType() == UnitType.MOPPER) {
                        int d = rc.getLocation().distanceSquaredTo(tmp);
                        if (d < bestDist) {
                            bestDist = d;
                            goal = tmp;
                        }
                    }
                }
                default -> {
                    if (rc.getType() == UnitType.SOLDIER) {
                        boolean isSecondary = (mi.getPaint() == PaintType.ALLY_SECONDARY);
                        boolean targetSecondary = pattern[2][0];
                        if ((mi.getPaint() == PaintType.EMPTY) || (isSecondary != targetSecondary)) {
                            int d = rc.getLocation().distanceSquaredTo(tmp);
                            if (d < bestDist) {
                                bestDist = d;
                                goal = tmp;
                                secondCol = targetSecondary;
                            }
                        }
                    }
                }
            }
        }
        
        
        
        
        
        tmp = new MapLocation(buildTower.x + -1, buildTower.y + 2);
        if (rc.canSenseLocation(tmp)) {
            MapInfo mi = rc.senseMapInfo(tmp);
            switch (mi.getPaint()) {
                case ENEMY_SECONDARY, ENEMY_PRIMARY -> {
                    if (rc.getType() == UnitType.MOPPER) {
                        int d = rc.getLocation().distanceSquaredTo(tmp);
                        if (d < bestDist) {
                            bestDist = d;
                            goal = tmp;
                        }
                    }
                }
                default -> {
                    if (rc.getType() == UnitType.SOLDIER) {
                        boolean isSecondary = (mi.getPaint() == PaintType.ALLY_SECONDARY);
                        boolean targetSecondary = pattern[1][4];
                        if ((mi.getPaint() == PaintType.EMPTY) || (isSecondary != targetSecondary)) {
                            int d = rc.getLocation().distanceSquaredTo(tmp);
                            if (d < bestDist) {
                                bestDist = d;
                                goal = tmp;
                                secondCol = targetSecondary;
                            }
                        }
                    }
                }
            }
        }
        
        
        
        tmp = new MapLocation(buildTower.x + -1, buildTower.y + 1);
        if (rc.canSenseLocation(tmp)) {
            MapInfo mi = rc.senseMapInfo(tmp);
            switch (mi.getPaint()) {
                case ENEMY_SECONDARY, ENEMY_PRIMARY -> {
                    if (rc.getType() == UnitType.MOPPER) {
                        int d = rc.getLocation().distanceSquaredTo(tmp);
                        if (d < bestDist) {
                            bestDist = d;
                            goal = tmp;
                        }
                    }
                }
                default -> {
                    if (rc.getType() == UnitType.SOLDIER) {
                        boolean isSecondary = (mi.getPaint() == PaintType.ALLY_SECONDARY);
                        boolean targetSecondary = pattern[1][3];
                        if ((mi.getPaint() == PaintType.EMPTY) || (isSecondary != targetSecondary)) {
                            int d = rc.getLocation().distanceSquaredTo(tmp);
                            if (d < bestDist) {
                                bestDist = d;
                                goal = tmp;
                                secondCol = targetSecondary;
                            }
                        }
                    }
                }
            }
        }
        
        
        
        tmp = new MapLocation(buildTower.x + -1, buildTower.y + 0);
        if (rc.canSenseLocation(tmp)) {
            MapInfo mi = rc.senseMapInfo(tmp);
            switch (mi.getPaint()) {
                case ENEMY_SECONDARY, ENEMY_PRIMARY -> {
                    if (rc.getType() == UnitType.MOPPER) {
                        int d = rc.getLocation().distanceSquaredTo(tmp);
                        if (d < bestDist) {
                            bestDist = d;
                            goal = tmp;
                        }
                    }
                }
                default -> {
                    if (rc.getType() == UnitType.SOLDIER) {
                        boolean isSecondary = (mi.getPaint() == PaintType.ALLY_SECONDARY);
                        boolean targetSecondary = pattern[1][2];
                        if ((mi.getPaint() == PaintType.EMPTY) || (isSecondary != targetSecondary)) {
                            int d = rc.getLocation().distanceSquaredTo(tmp);
                            if (d < bestDist) {
                                bestDist = d;
                                goal = tmp;
                                secondCol = targetSecondary;
                            }
                        }
                    }
                }
            }
        }
        
        
        
        tmp = new MapLocation(buildTower.x + -1, buildTower.y + -1);
        if (rc.canSenseLocation(tmp)) {
            MapInfo mi = rc.senseMapInfo(tmp);
            switch (mi.getPaint()) {
                case ENEMY_SECONDARY, ENEMY_PRIMARY -> {
                    if (rc.getType() == UnitType.MOPPER) {
                        int d = rc.getLocation().distanceSquaredTo(tmp);
                        if (d < bestDist) {
                            bestDist = d;
                            goal = tmp;
                        }
                    }
                }
                default -> {
                    if (rc.getType() == UnitType.SOLDIER) {
                        boolean isSecondary = (mi.getPaint() == PaintType.ALLY_SECONDARY);
                        boolean targetSecondary = pattern[1][1];
                        if ((mi.getPaint() == PaintType.EMPTY) || (isSecondary != targetSecondary)) {
                            int d = rc.getLocation().distanceSquaredTo(tmp);
                            if (d < bestDist) {
                                bestDist = d;
                                goal = tmp;
                                secondCol = targetSecondary;
                            }
                        }
                    }
                }
            }
        }
        
        
        
        tmp = new MapLocation(buildTower.x + -1, buildTower.y + -2);
        if (rc.canSenseLocation(tmp)) {
            MapInfo mi = rc.senseMapInfo(tmp);
            switch (mi.getPaint()) {
                case ENEMY_SECONDARY, ENEMY_PRIMARY -> {
                    if (rc.getType() == UnitType.MOPPER) {
                        int d = rc.getLocation().distanceSquaredTo(tmp);
                        if (d < bestDist) {
                            bestDist = d;
                            goal = tmp;
                        }
                    }
                }
                default -> {
                    if (rc.getType() == UnitType.SOLDIER) {
                        boolean isSecondary = (mi.getPaint() == PaintType.ALLY_SECONDARY);
                        boolean targetSecondary = pattern[1][0];
                        if ((mi.getPaint() == PaintType.EMPTY) || (isSecondary != targetSecondary)) {
                            int d = rc.getLocation().distanceSquaredTo(tmp);
                            if (d < bestDist) {
                                bestDist = d;
                                goal = tmp;
                                secondCol = targetSecondary;
                            }
                        }
                    }
                }
            }
        }
        
        
        
        
        
        tmp = new MapLocation(buildTower.x + -2, buildTower.y + 2);
        if (rc.canSenseLocation(tmp)) {
            MapInfo mi = rc.senseMapInfo(tmp);
            switch (mi.getPaint()) {
                case ENEMY_SECONDARY, ENEMY_PRIMARY -> {
                    if (rc.getType() == UnitType.MOPPER) {
                        int d = rc.getLocation().distanceSquaredTo(tmp);
                        if (d < bestDist) {
                            bestDist = d;
                            goal = tmp;
                        }
                    }
                }
                default -> {
                    if (rc.getType() == UnitType.SOLDIER) {
                        boolean isSecondary = (mi.getPaint() == PaintType.ALLY_SECONDARY);
                        boolean targetSecondary = pattern[0][4];
                        if ((mi.getPaint() == PaintType.EMPTY) || (isSecondary != targetSecondary)) {
                            int d = rc.getLocation().distanceSquaredTo(tmp);
                            if (d < bestDist) {
                                bestDist = d;
                                goal = tmp;
                                secondCol = targetSecondary;
                            }
                        }
                    }
                }
            }
        }
        
        
        
        tmp = new MapLocation(buildTower.x + -2, buildTower.y + 1);
        if (rc.canSenseLocation(tmp)) {
            MapInfo mi = rc.senseMapInfo(tmp);
            switch (mi.getPaint()) {
                case ENEMY_SECONDARY, ENEMY_PRIMARY -> {
                    if (rc.getType() == UnitType.MOPPER) {
                        int d = rc.getLocation().distanceSquaredTo(tmp);
                        if (d < bestDist) {
                            bestDist = d;
                            goal = tmp;
                        }
                    }
                }
                default -> {
                    if (rc.getType() == UnitType.SOLDIER) {
                        boolean isSecondary = (mi.getPaint() == PaintType.ALLY_SECONDARY);
                        boolean targetSecondary = pattern[0][3];
                        if ((mi.getPaint() == PaintType.EMPTY) || (isSecondary != targetSecondary)) {
                            int d = rc.getLocation().distanceSquaredTo(tmp);
                            if (d < bestDist) {
                                bestDist = d;
                                goal = tmp;
                                secondCol = targetSecondary;
                            }
                        }
                    }
                }
            }
        }
        
        
        
        tmp = new MapLocation(buildTower.x + -2, buildTower.y + 0);
        if (rc.canSenseLocation(tmp)) {
            MapInfo mi = rc.senseMapInfo(tmp);
            switch (mi.getPaint()) {
                case ENEMY_SECONDARY, ENEMY_PRIMARY -> {
                    if (rc.getType() == UnitType.MOPPER) {
                        int d = rc.getLocation().distanceSquaredTo(tmp);
                        if (d < bestDist) {
                            bestDist = d;
                            goal = tmp;
                        }
                    }
                }
                default -> {
                    if (rc.getType() == UnitType.SOLDIER) {
                        boolean isSecondary = (mi.getPaint() == PaintType.ALLY_SECONDARY);
                        boolean targetSecondary = pattern[0][2];
                        if ((mi.getPaint() == PaintType.EMPTY) || (isSecondary != targetSecondary)) {
                            int d = rc.getLocation().distanceSquaredTo(tmp);
                            if (d < bestDist) {
                                bestDist = d;
                                goal = tmp;
                                secondCol = targetSecondary;
                            }
                        }
                    }
                }
            }
        }
        
        
        
        tmp = new MapLocation(buildTower.x + -2, buildTower.y + -1);
        if (rc.canSenseLocation(tmp)) {
            MapInfo mi = rc.senseMapInfo(tmp);
            switch (mi.getPaint()) {
                case ENEMY_SECONDARY, ENEMY_PRIMARY -> {
                    if (rc.getType() == UnitType.MOPPER) {
                        int d = rc.getLocation().distanceSquaredTo(tmp);
                        if (d < bestDist) {
                            bestDist = d;
                            goal = tmp;
                        }
                    }
                }
                default -> {
                    if (rc.getType() == UnitType.SOLDIER) {
                        boolean isSecondary = (mi.getPaint() == PaintType.ALLY_SECONDARY);
                        boolean targetSecondary = pattern[0][1];
                        if ((mi.getPaint() == PaintType.EMPTY) || (isSecondary != targetSecondary)) {
                            int d = rc.getLocation().distanceSquaredTo(tmp);
                            if (d < bestDist) {
                                bestDist = d;
                                goal = tmp;
                                secondCol = targetSecondary;
                            }
                        }
                    }
                }
            }
        }
        
        
        
        tmp = new MapLocation(buildTower.x + -2, buildTower.y + -2);
        if (rc.canSenseLocation(tmp)) {
            MapInfo mi = rc.senseMapInfo(tmp);
            switch (mi.getPaint()) {
                case ENEMY_SECONDARY, ENEMY_PRIMARY -> {
                    if (rc.getType() == UnitType.MOPPER) {
                        int d = rc.getLocation().distanceSquaredTo(tmp);
                        if (d < bestDist) {
                            bestDist = d;
                            goal = tmp;
                        }
                    }
                }
                default -> {
                    if (rc.getType() == UnitType.SOLDIER) {
                        boolean isSecondary = (mi.getPaint() == PaintType.ALLY_SECONDARY);
                        boolean targetSecondary = pattern[0][0];
                        if ((mi.getPaint() == PaintType.EMPTY) || (isSecondary != targetSecondary)) {
                            int d = rc.getLocation().distanceSquaredTo(tmp);
                            if (d < bestDist) {
                                bestDist = d;
                                goal = tmp;
                                secondCol = targetSecondary;
                            }
                        }
                    }
                }
            }
        }
        
        
        

        if (goal != null) {
            Pathing.pathTo(goal);
            if (rc.canAttack(goal)) {
                rc.setIndicatorDot(goal, 255, 0, 0);
                rc.attack(goal, secondCol);
            }
        }
        else {
            rc.setIndicatorString("patroling");
            if (rc.canCompleteTowerPattern(UnitType.LEVEL_ONE_PAINT_TOWER, buildTower)) {
                rc.completeTowerPattern(UnitType.LEVEL_ONE_PAINT_TOWER, buildTower);
            }
            if (rc.canCompleteTowerPattern(UnitType.LEVEL_ONE_MONEY_TOWER, buildTower)) {
                rc.completeTowerPattern(UnitType.LEVEL_ONE_MONEY_TOWER, buildTower);
            }
            Pathing.pathTo(buildTower);
            if (rc.getLocation().distanceSquaredTo(buildTower) <= 2) {
                for (int j = 8; --j >= 0;) {
                    RobotInfo r = rc.senseRobotAtLocation(new MapLocation(buildTower.x + dx[j], buildTower.y + dy[j]));
                    if (r != null && rc.getType() == r.getType()) {
                        if (r.getLocation() == rc.getLocation()) break;
                        last[buildTower.x][buildTower.y] = rc.getRoundNum() + 10;
                        break;
                    }
                }
            }
        }
    }

}