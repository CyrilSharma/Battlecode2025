package before_upgrades;
import battlecode.common.*;

public class TowerBuild {
    public static RobotController rc;
    public static int[] dx = {0, 1, 1, 1, 0, -1, -1, -1};
    public static int[] dy = {1, 1, 0, -1, -1, -1, 0, 1};
    public static int[][] last = null;
    public static MapLocation prevRuin = null;
    public static boolean[][] moneyTower = null;
    public static boolean[][] paintTower = null;
    public static boolean[][] defenseTower = null;

    public static void init(RobotController rc) throws GameActionException {
        TowerBuild.rc = rc;
        last = new int[rc.getMapWidth()][rc.getMapHeight()];
        moneyTower = rc.getTowerPattern(UnitType.LEVEL_ONE_MONEY_TOWER);
        paintTower = rc.getTowerPattern(UnitType.LEVEL_ONE_PAINT_TOWER);
        defenseTower = rc.getTowerPattern(UnitType.LEVEL_ONE_DEFENSE_TOWER);
    }

    public static MapLocation getRuin(MapInfo[] near) throws GameActionException {
        MapLocation best = null;
        int closest = 100000000;
        if (prevRuin != null && rc.canSenseLocation(prevRuin) && last[prevRuin.x][prevRuin.y] < rc.getRoundNum() && (rc.getType() == UnitType.MOPPER && (seeTaintedRuin(prevRuin)) || (rc.getType() == UnitType.SOLDIER && seeIncompleteRuin(prevRuin)))){
            return prevRuin;
        } 
        for (int i = near.length; --i >= 0; ) {
            if (near[i].hasRuin()) {
                MapLocation m = near[i].getMapLocation();
                int d = m.distanceSquaredTo(rc.getLocation());
                if (d >= closest || last[m.x][m.y] >= rc.getRoundNum()) continue;
                RobotInfo r = rc.senseRobotAtLocation(m);
                if (r == null) {
                    if ((rc.getType() == UnitType.MOPPER && seeTaintedRuin(m)) || (rc.getType() == UnitType.SOLDIER && seeIncompleteRuin(m))) {
                        closest = d;
                        best = m;
                    }
                }
            }
        }
        return best;
    }

    public static boolean seeIncompleteRuin(MapLocation ruin) throws GameActionException {
        MapLocation tmp;
        UnitType t = Globals.getTowerToBuild(ruin);
        RobotInfo tower = rc.senseRobotAtLocation(ruin);
        boolean needsChanges = (tower == null);
        if (tower != null) return false;
        
        
        
        tmp = new MapLocation(ruin.x + 2, ruin.y + 2);
        if (rc.canSenseLocation(tmp)) {
            MapInfo mi = rc.senseMapInfo(tmp);
            switch (mi.getPaint()) {
                case ENEMY_SECONDARY, ENEMY_PRIMARY: return false;
                default: {
                    boolean isSecondary = (mi.getPaint() == PaintType.ALLY_SECONDARY);
                    boolean targetSecondary = false;
                    switch (t) {
                        case LEVEL_ONE_DEFENSE_TOWER : {
                            targetSecondary = defenseTower[4][4];
                            break;
                        }
                        case LEVEL_ONE_PAINT_TOWER : {
                            targetSecondary = paintTower[4][4];
                            break;
                        }
                        default : {
                            targetSecondary = moneyTower[4][4];
                            break;
                        }
                    }
                    if ((mi.getPaint() == PaintType.EMPTY) || (isSecondary != targetSecondary)) {
                        needsChanges = true;
                    }
                }
            }
        }
        
        
        
        tmp = new MapLocation(ruin.x + 2, ruin.y + 1);
        if (rc.canSenseLocation(tmp)) {
            MapInfo mi = rc.senseMapInfo(tmp);
            switch (mi.getPaint()) {
                case ENEMY_SECONDARY, ENEMY_PRIMARY: return false;
                default: {
                    boolean isSecondary = (mi.getPaint() == PaintType.ALLY_SECONDARY);
                    boolean targetSecondary = false;
                    switch (t) {
                        case LEVEL_ONE_DEFENSE_TOWER : {
                            targetSecondary = defenseTower[4][3];
                            break;
                        }
                        case LEVEL_ONE_PAINT_TOWER : {
                            targetSecondary = paintTower[4][3];
                            break;
                        }
                        default : {
                            targetSecondary = moneyTower[4][3];
                            break;
                        }
                    }
                    if ((mi.getPaint() == PaintType.EMPTY) || (isSecondary != targetSecondary)) {
                        needsChanges = true;
                    }
                }
            }
        }
        
        
        
        tmp = new MapLocation(ruin.x + 2, ruin.y + 0);
        if (rc.canSenseLocation(tmp)) {
            MapInfo mi = rc.senseMapInfo(tmp);
            switch (mi.getPaint()) {
                case ENEMY_SECONDARY, ENEMY_PRIMARY: return false;
                default: {
                    boolean isSecondary = (mi.getPaint() == PaintType.ALLY_SECONDARY);
                    boolean targetSecondary = false;
                    switch (t) {
                        case LEVEL_ONE_DEFENSE_TOWER : {
                            targetSecondary = defenseTower[4][2];
                            break;
                        }
                        case LEVEL_ONE_PAINT_TOWER : {
                            targetSecondary = paintTower[4][2];
                            break;
                        }
                        default : {
                            targetSecondary = moneyTower[4][2];
                            break;
                        }
                    }
                    if ((mi.getPaint() == PaintType.EMPTY) || (isSecondary != targetSecondary)) {
                        needsChanges = true;
                    }
                }
            }
        }
        
        
        
        tmp = new MapLocation(ruin.x + 2, ruin.y + -1);
        if (rc.canSenseLocation(tmp)) {
            MapInfo mi = rc.senseMapInfo(tmp);
            switch (mi.getPaint()) {
                case ENEMY_SECONDARY, ENEMY_PRIMARY: return false;
                default: {
                    boolean isSecondary = (mi.getPaint() == PaintType.ALLY_SECONDARY);
                    boolean targetSecondary = false;
                    switch (t) {
                        case LEVEL_ONE_DEFENSE_TOWER : {
                            targetSecondary = defenseTower[4][1];
                            break;
                        }
                        case LEVEL_ONE_PAINT_TOWER : {
                            targetSecondary = paintTower[4][1];
                            break;
                        }
                        default : {
                            targetSecondary = moneyTower[4][1];
                            break;
                        }
                    }
                    if ((mi.getPaint() == PaintType.EMPTY) || (isSecondary != targetSecondary)) {
                        needsChanges = true;
                    }
                }
            }
        }
        
        
        
        tmp = new MapLocation(ruin.x + 2, ruin.y + -2);
        if (rc.canSenseLocation(tmp)) {
            MapInfo mi = rc.senseMapInfo(tmp);
            switch (mi.getPaint()) {
                case ENEMY_SECONDARY, ENEMY_PRIMARY: return false;
                default: {
                    boolean isSecondary = (mi.getPaint() == PaintType.ALLY_SECONDARY);
                    boolean targetSecondary = false;
                    switch (t) {
                        case LEVEL_ONE_DEFENSE_TOWER : {
                            targetSecondary = defenseTower[4][0];
                            break;
                        }
                        case LEVEL_ONE_PAINT_TOWER : {
                            targetSecondary = paintTower[4][0];
                            break;
                        }
                        default : {
                            targetSecondary = moneyTower[4][0];
                            break;
                        }
                    }
                    if ((mi.getPaint() == PaintType.EMPTY) || (isSecondary != targetSecondary)) {
                        needsChanges = true;
                    }
                }
            }
        }
        
        
        
        
        
        tmp = new MapLocation(ruin.x + 1, ruin.y + 2);
        if (rc.canSenseLocation(tmp)) {
            MapInfo mi = rc.senseMapInfo(tmp);
            switch (mi.getPaint()) {
                case ENEMY_SECONDARY, ENEMY_PRIMARY: return false;
                default: {
                    boolean isSecondary = (mi.getPaint() == PaintType.ALLY_SECONDARY);
                    boolean targetSecondary = false;
                    switch (t) {
                        case LEVEL_ONE_DEFENSE_TOWER : {
                            targetSecondary = defenseTower[3][4];
                            break;
                        }
                        case LEVEL_ONE_PAINT_TOWER : {
                            targetSecondary = paintTower[3][4];
                            break;
                        }
                        default : {
                            targetSecondary = moneyTower[3][4];
                            break;
                        }
                    }
                    if ((mi.getPaint() == PaintType.EMPTY) || (isSecondary != targetSecondary)) {
                        needsChanges = true;
                    }
                }
            }
        }
        
        
        
        tmp = new MapLocation(ruin.x + 1, ruin.y + 1);
        if (rc.canSenseLocation(tmp)) {
            MapInfo mi = rc.senseMapInfo(tmp);
            switch (mi.getPaint()) {
                case ENEMY_SECONDARY, ENEMY_PRIMARY: return false;
                default: {
                    boolean isSecondary = (mi.getPaint() == PaintType.ALLY_SECONDARY);
                    boolean targetSecondary = false;
                    switch (t) {
                        case LEVEL_ONE_DEFENSE_TOWER : {
                            targetSecondary = defenseTower[3][3];
                            break;
                        }
                        case LEVEL_ONE_PAINT_TOWER : {
                            targetSecondary = paintTower[3][3];
                            break;
                        }
                        default : {
                            targetSecondary = moneyTower[3][3];
                            break;
                        }
                    }
                    if ((mi.getPaint() == PaintType.EMPTY) || (isSecondary != targetSecondary)) {
                        needsChanges = true;
                    }
                }
            }
        }
        
        
        
        tmp = new MapLocation(ruin.x + 1, ruin.y + 0);
        if (rc.canSenseLocation(tmp)) {
            MapInfo mi = rc.senseMapInfo(tmp);
            switch (mi.getPaint()) {
                case ENEMY_SECONDARY, ENEMY_PRIMARY: return false;
                default: {
                    boolean isSecondary = (mi.getPaint() == PaintType.ALLY_SECONDARY);
                    boolean targetSecondary = false;
                    switch (t) {
                        case LEVEL_ONE_DEFENSE_TOWER : {
                            targetSecondary = defenseTower[3][2];
                            break;
                        }
                        case LEVEL_ONE_PAINT_TOWER : {
                            targetSecondary = paintTower[3][2];
                            break;
                        }
                        default : {
                            targetSecondary = moneyTower[3][2];
                            break;
                        }
                    }
                    if ((mi.getPaint() == PaintType.EMPTY) || (isSecondary != targetSecondary)) {
                        needsChanges = true;
                    }
                }
            }
        }
        
        
        
        tmp = new MapLocation(ruin.x + 1, ruin.y + -1);
        if (rc.canSenseLocation(tmp)) {
            MapInfo mi = rc.senseMapInfo(tmp);
            switch (mi.getPaint()) {
                case ENEMY_SECONDARY, ENEMY_PRIMARY: return false;
                default: {
                    boolean isSecondary = (mi.getPaint() == PaintType.ALLY_SECONDARY);
                    boolean targetSecondary = false;
                    switch (t) {
                        case LEVEL_ONE_DEFENSE_TOWER : {
                            targetSecondary = defenseTower[3][1];
                            break;
                        }
                        case LEVEL_ONE_PAINT_TOWER : {
                            targetSecondary = paintTower[3][1];
                            break;
                        }
                        default : {
                            targetSecondary = moneyTower[3][1];
                            break;
                        }
                    }
                    if ((mi.getPaint() == PaintType.EMPTY) || (isSecondary != targetSecondary)) {
                        needsChanges = true;
                    }
                }
            }
        }
        
        
        
        tmp = new MapLocation(ruin.x + 1, ruin.y + -2);
        if (rc.canSenseLocation(tmp)) {
            MapInfo mi = rc.senseMapInfo(tmp);
            switch (mi.getPaint()) {
                case ENEMY_SECONDARY, ENEMY_PRIMARY: return false;
                default: {
                    boolean isSecondary = (mi.getPaint() == PaintType.ALLY_SECONDARY);
                    boolean targetSecondary = false;
                    switch (t) {
                        case LEVEL_ONE_DEFENSE_TOWER : {
                            targetSecondary = defenseTower[3][0];
                            break;
                        }
                        case LEVEL_ONE_PAINT_TOWER : {
                            targetSecondary = paintTower[3][0];
                            break;
                        }
                        default : {
                            targetSecondary = moneyTower[3][0];
                            break;
                        }
                    }
                    if ((mi.getPaint() == PaintType.EMPTY) || (isSecondary != targetSecondary)) {
                        needsChanges = true;
                    }
                }
            }
        }
        
        
        
        
        
        tmp = new MapLocation(ruin.x + 0, ruin.y + 2);
        if (rc.canSenseLocation(tmp)) {
            MapInfo mi = rc.senseMapInfo(tmp);
            switch (mi.getPaint()) {
                case ENEMY_SECONDARY, ENEMY_PRIMARY: return false;
                default: {
                    boolean isSecondary = (mi.getPaint() == PaintType.ALLY_SECONDARY);
                    boolean targetSecondary = false;
                    switch (t) {
                        case LEVEL_ONE_DEFENSE_TOWER : {
                            targetSecondary = defenseTower[2][4];
                            break;
                        }
                        case LEVEL_ONE_PAINT_TOWER : {
                            targetSecondary = paintTower[2][4];
                            break;
                        }
                        default : {
                            targetSecondary = moneyTower[2][4];
                            break;
                        }
                    }
                    if ((mi.getPaint() == PaintType.EMPTY) || (isSecondary != targetSecondary)) {
                        needsChanges = true;
                    }
                }
            }
        }
        
        
        
        tmp = new MapLocation(ruin.x + 0, ruin.y + 1);
        if (rc.canSenseLocation(tmp)) {
            MapInfo mi = rc.senseMapInfo(tmp);
            switch (mi.getPaint()) {
                case ENEMY_SECONDARY, ENEMY_PRIMARY: return false;
                default: {
                    boolean isSecondary = (mi.getPaint() == PaintType.ALLY_SECONDARY);
                    boolean targetSecondary = false;
                    switch (t) {
                        case LEVEL_ONE_DEFENSE_TOWER : {
                            targetSecondary = defenseTower[2][3];
                            break;
                        }
                        case LEVEL_ONE_PAINT_TOWER : {
                            targetSecondary = paintTower[2][3];
                            break;
                        }
                        default : {
                            targetSecondary = moneyTower[2][3];
                            break;
                        }
                    }
                    if ((mi.getPaint() == PaintType.EMPTY) || (isSecondary != targetSecondary)) {
                        needsChanges = true;
                    }
                }
            }
        }
        
        
        
        
        
        tmp = new MapLocation(ruin.x + 0, ruin.y + -1);
        if (rc.canSenseLocation(tmp)) {
            MapInfo mi = rc.senseMapInfo(tmp);
            switch (mi.getPaint()) {
                case ENEMY_SECONDARY, ENEMY_PRIMARY: return false;
                default: {
                    boolean isSecondary = (mi.getPaint() == PaintType.ALLY_SECONDARY);
                    boolean targetSecondary = false;
                    switch (t) {
                        case LEVEL_ONE_DEFENSE_TOWER : {
                            targetSecondary = defenseTower[2][1];
                            break;
                        }
                        case LEVEL_ONE_PAINT_TOWER : {
                            targetSecondary = paintTower[2][1];
                            break;
                        }
                        default : {
                            targetSecondary = moneyTower[2][1];
                            break;
                        }
                    }
                    if ((mi.getPaint() == PaintType.EMPTY) || (isSecondary != targetSecondary)) {
                        needsChanges = true;
                    }
                }
            }
        }
        
        
        
        tmp = new MapLocation(ruin.x + 0, ruin.y + -2);
        if (rc.canSenseLocation(tmp)) {
            MapInfo mi = rc.senseMapInfo(tmp);
            switch (mi.getPaint()) {
                case ENEMY_SECONDARY, ENEMY_PRIMARY: return false;
                default: {
                    boolean isSecondary = (mi.getPaint() == PaintType.ALLY_SECONDARY);
                    boolean targetSecondary = false;
                    switch (t) {
                        case LEVEL_ONE_DEFENSE_TOWER : {
                            targetSecondary = defenseTower[2][0];
                            break;
                        }
                        case LEVEL_ONE_PAINT_TOWER : {
                            targetSecondary = paintTower[2][0];
                            break;
                        }
                        default : {
                            targetSecondary = moneyTower[2][0];
                            break;
                        }
                    }
                    if ((mi.getPaint() == PaintType.EMPTY) || (isSecondary != targetSecondary)) {
                        needsChanges = true;
                    }
                }
            }
        }
        
        
        
        
        
        tmp = new MapLocation(ruin.x + -1, ruin.y + 2);
        if (rc.canSenseLocation(tmp)) {
            MapInfo mi = rc.senseMapInfo(tmp);
            switch (mi.getPaint()) {
                case ENEMY_SECONDARY, ENEMY_PRIMARY: return false;
                default: {
                    boolean isSecondary = (mi.getPaint() == PaintType.ALLY_SECONDARY);
                    boolean targetSecondary = false;
                    switch (t) {
                        case LEVEL_ONE_DEFENSE_TOWER : {
                            targetSecondary = defenseTower[1][4];
                            break;
                        }
                        case LEVEL_ONE_PAINT_TOWER : {
                            targetSecondary = paintTower[1][4];
                            break;
                        }
                        default : {
                            targetSecondary = moneyTower[1][4];
                            break;
                        }
                    }
                    if ((mi.getPaint() == PaintType.EMPTY) || (isSecondary != targetSecondary)) {
                        needsChanges = true;
                    }
                }
            }
        }
        
        
        
        tmp = new MapLocation(ruin.x + -1, ruin.y + 1);
        if (rc.canSenseLocation(tmp)) {
            MapInfo mi = rc.senseMapInfo(tmp);
            switch (mi.getPaint()) {
                case ENEMY_SECONDARY, ENEMY_PRIMARY: return false;
                default: {
                    boolean isSecondary = (mi.getPaint() == PaintType.ALLY_SECONDARY);
                    boolean targetSecondary = false;
                    switch (t) {
                        case LEVEL_ONE_DEFENSE_TOWER : {
                            targetSecondary = defenseTower[1][3];
                            break;
                        }
                        case LEVEL_ONE_PAINT_TOWER : {
                            targetSecondary = paintTower[1][3];
                            break;
                        }
                        default : {
                            targetSecondary = moneyTower[1][3];
                            break;
                        }
                    }
                    if ((mi.getPaint() == PaintType.EMPTY) || (isSecondary != targetSecondary)) {
                        needsChanges = true;
                    }
                }
            }
        }
        
        
        
        tmp = new MapLocation(ruin.x + -1, ruin.y + 0);
        if (rc.canSenseLocation(tmp)) {
            MapInfo mi = rc.senseMapInfo(tmp);
            switch (mi.getPaint()) {
                case ENEMY_SECONDARY, ENEMY_PRIMARY: return false;
                default: {
                    boolean isSecondary = (mi.getPaint() == PaintType.ALLY_SECONDARY);
                    boolean targetSecondary = false;
                    switch (t) {
                        case LEVEL_ONE_DEFENSE_TOWER : {
                            targetSecondary = defenseTower[1][2];
                            break;
                        }
                        case LEVEL_ONE_PAINT_TOWER : {
                            targetSecondary = paintTower[1][2];
                            break;
                        }
                        default : {
                            targetSecondary = moneyTower[1][2];
                            break;
                        }
                    }
                    if ((mi.getPaint() == PaintType.EMPTY) || (isSecondary != targetSecondary)) {
                        needsChanges = true;
                    }
                }
            }
        }
        
        
        
        tmp = new MapLocation(ruin.x + -1, ruin.y + -1);
        if (rc.canSenseLocation(tmp)) {
            MapInfo mi = rc.senseMapInfo(tmp);
            switch (mi.getPaint()) {
                case ENEMY_SECONDARY, ENEMY_PRIMARY: return false;
                default: {
                    boolean isSecondary = (mi.getPaint() == PaintType.ALLY_SECONDARY);
                    boolean targetSecondary = false;
                    switch (t) {
                        case LEVEL_ONE_DEFENSE_TOWER : {
                            targetSecondary = defenseTower[1][1];
                            break;
                        }
                        case LEVEL_ONE_PAINT_TOWER : {
                            targetSecondary = paintTower[1][1];
                            break;
                        }
                        default : {
                            targetSecondary = moneyTower[1][1];
                            break;
                        }
                    }
                    if ((mi.getPaint() == PaintType.EMPTY) || (isSecondary != targetSecondary)) {
                        needsChanges = true;
                    }
                }
            }
        }
        
        
        
        tmp = new MapLocation(ruin.x + -1, ruin.y + -2);
        if (rc.canSenseLocation(tmp)) {
            MapInfo mi = rc.senseMapInfo(tmp);
            switch (mi.getPaint()) {
                case ENEMY_SECONDARY, ENEMY_PRIMARY: return false;
                default: {
                    boolean isSecondary = (mi.getPaint() == PaintType.ALLY_SECONDARY);
                    boolean targetSecondary = false;
                    switch (t) {
                        case LEVEL_ONE_DEFENSE_TOWER : {
                            targetSecondary = defenseTower[1][0];
                            break;
                        }
                        case LEVEL_ONE_PAINT_TOWER : {
                            targetSecondary = paintTower[1][0];
                            break;
                        }
                        default : {
                            targetSecondary = moneyTower[1][0];
                            break;
                        }
                    }
                    if ((mi.getPaint() == PaintType.EMPTY) || (isSecondary != targetSecondary)) {
                        needsChanges = true;
                    }
                }
            }
        }
        
        
        
        
        
        tmp = new MapLocation(ruin.x + -2, ruin.y + 2);
        if (rc.canSenseLocation(tmp)) {
            MapInfo mi = rc.senseMapInfo(tmp);
            switch (mi.getPaint()) {
                case ENEMY_SECONDARY, ENEMY_PRIMARY: return false;
                default: {
                    boolean isSecondary = (mi.getPaint() == PaintType.ALLY_SECONDARY);
                    boolean targetSecondary = false;
                    switch (t) {
                        case LEVEL_ONE_DEFENSE_TOWER : {
                            targetSecondary = defenseTower[0][4];
                            break;
                        }
                        case LEVEL_ONE_PAINT_TOWER : {
                            targetSecondary = paintTower[0][4];
                            break;
                        }
                        default : {
                            targetSecondary = moneyTower[0][4];
                            break;
                        }
                    }
                    if ((mi.getPaint() == PaintType.EMPTY) || (isSecondary != targetSecondary)) {
                        needsChanges = true;
                    }
                }
            }
        }
        
        
        
        tmp = new MapLocation(ruin.x + -2, ruin.y + 1);
        if (rc.canSenseLocation(tmp)) {
            MapInfo mi = rc.senseMapInfo(tmp);
            switch (mi.getPaint()) {
                case ENEMY_SECONDARY, ENEMY_PRIMARY: return false;
                default: {
                    boolean isSecondary = (mi.getPaint() == PaintType.ALLY_SECONDARY);
                    boolean targetSecondary = false;
                    switch (t) {
                        case LEVEL_ONE_DEFENSE_TOWER : {
                            targetSecondary = defenseTower[0][3];
                            break;
                        }
                        case LEVEL_ONE_PAINT_TOWER : {
                            targetSecondary = paintTower[0][3];
                            break;
                        }
                        default : {
                            targetSecondary = moneyTower[0][3];
                            break;
                        }
                    }
                    if ((mi.getPaint() == PaintType.EMPTY) || (isSecondary != targetSecondary)) {
                        needsChanges = true;
                    }
                }
            }
        }
        
        
        
        tmp = new MapLocation(ruin.x + -2, ruin.y + 0);
        if (rc.canSenseLocation(tmp)) {
            MapInfo mi = rc.senseMapInfo(tmp);
            switch (mi.getPaint()) {
                case ENEMY_SECONDARY, ENEMY_PRIMARY: return false;
                default: {
                    boolean isSecondary = (mi.getPaint() == PaintType.ALLY_SECONDARY);
                    boolean targetSecondary = false;
                    switch (t) {
                        case LEVEL_ONE_DEFENSE_TOWER : {
                            targetSecondary = defenseTower[0][2];
                            break;
                        }
                        case LEVEL_ONE_PAINT_TOWER : {
                            targetSecondary = paintTower[0][2];
                            break;
                        }
                        default : {
                            targetSecondary = moneyTower[0][2];
                            break;
                        }
                    }
                    if ((mi.getPaint() == PaintType.EMPTY) || (isSecondary != targetSecondary)) {
                        needsChanges = true;
                    }
                }
            }
        }
        
        
        
        tmp = new MapLocation(ruin.x + -2, ruin.y + -1);
        if (rc.canSenseLocation(tmp)) {
            MapInfo mi = rc.senseMapInfo(tmp);
            switch (mi.getPaint()) {
                case ENEMY_SECONDARY, ENEMY_PRIMARY: return false;
                default: {
                    boolean isSecondary = (mi.getPaint() == PaintType.ALLY_SECONDARY);
                    boolean targetSecondary = false;
                    switch (t) {
                        case LEVEL_ONE_DEFENSE_TOWER : {
                            targetSecondary = defenseTower[0][1];
                            break;
                        }
                        case LEVEL_ONE_PAINT_TOWER : {
                            targetSecondary = paintTower[0][1];
                            break;
                        }
                        default : {
                            targetSecondary = moneyTower[0][1];
                            break;
                        }
                    }
                    if ((mi.getPaint() == PaintType.EMPTY) || (isSecondary != targetSecondary)) {
                        needsChanges = true;
                    }
                }
            }
        }
        
        
        
        tmp = new MapLocation(ruin.x + -2, ruin.y + -2);
        if (rc.canSenseLocation(tmp)) {
            MapInfo mi = rc.senseMapInfo(tmp);
            switch (mi.getPaint()) {
                case ENEMY_SECONDARY, ENEMY_PRIMARY: return false;
                default: {
                    boolean isSecondary = (mi.getPaint() == PaintType.ALLY_SECONDARY);
                    boolean targetSecondary = false;
                    switch (t) {
                        case LEVEL_ONE_DEFENSE_TOWER : {
                            targetSecondary = defenseTower[0][0];
                            break;
                        }
                        case LEVEL_ONE_PAINT_TOWER : {
                            targetSecondary = paintTower[0][0];
                            break;
                        }
                        default : {
                            targetSecondary = moneyTower[0][0];
                            break;
                        }
                    }
                    if ((mi.getPaint() == PaintType.EMPTY) || (isSecondary != targetSecondary)) {
                        needsChanges = true;
                    }
                }
            }
        }
        
        
        
        return needsChanges;
    }

    public static boolean enoughPaint(MapLocation ruin) throws GameActionException {
        MapLocation tmp;
        UnitType t = Globals.getTowerToBuild(ruin);
        RobotInfo tower = rc.senseRobotAtLocation(ruin);
        int needsChanges = 0;
        if (tower != null) return false;
        
        
        
        tmp = new MapLocation(ruin.x + 2, ruin.y + 2);
        if (rc.canSenseLocation(tmp)) {
            MapInfo mi = rc.senseMapInfo(tmp);
            switch (mi.getPaint()) {
                case ENEMY_SECONDARY, ENEMY_PRIMARY: return false;
                default: {
                    boolean isSecondary = (mi.getPaint() == PaintType.ALLY_SECONDARY);
                    boolean targetSecondary = false;
                    switch (t) {
                        case LEVEL_ONE_DEFENSE_TOWER : {
                            targetSecondary = defenseTower[4][4];
                            break;
                        }
                        case LEVEL_ONE_PAINT_TOWER : {
                            targetSecondary = paintTower[4][4];
                            break;
                        }
                        default : {
                            targetSecondary = moneyTower[4][4];
                            break;
                        }
                    }
                    if ((mi.getPaint() == PaintType.EMPTY) || (isSecondary != targetSecondary)) {
                        needsChanges += 5;
                        if (rc.getPaint() - needsChanges < 10) return false;
                    }
                }
            }
        }
        
        
        
        tmp = new MapLocation(ruin.x + 2, ruin.y + 1);
        if (rc.canSenseLocation(tmp)) {
            MapInfo mi = rc.senseMapInfo(tmp);
            switch (mi.getPaint()) {
                case ENEMY_SECONDARY, ENEMY_PRIMARY: return false;
                default: {
                    boolean isSecondary = (mi.getPaint() == PaintType.ALLY_SECONDARY);
                    boolean targetSecondary = false;
                    switch (t) {
                        case LEVEL_ONE_DEFENSE_TOWER : {
                            targetSecondary = defenseTower[4][3];
                            break;
                        }
                        case LEVEL_ONE_PAINT_TOWER : {
                            targetSecondary = paintTower[4][3];
                            break;
                        }
                        default : {
                            targetSecondary = moneyTower[4][3];
                            break;
                        }
                    }
                    if ((mi.getPaint() == PaintType.EMPTY) || (isSecondary != targetSecondary)) {
                        needsChanges += 5;
                        if (rc.getPaint() - needsChanges < 10) return false;
                    }
                }
            }
        }
        
        
        
        tmp = new MapLocation(ruin.x + 2, ruin.y + 0);
        if (rc.canSenseLocation(tmp)) {
            MapInfo mi = rc.senseMapInfo(tmp);
            switch (mi.getPaint()) {
                case ENEMY_SECONDARY, ENEMY_PRIMARY: return false;
                default: {
                    boolean isSecondary = (mi.getPaint() == PaintType.ALLY_SECONDARY);
                    boolean targetSecondary = false;
                    switch (t) {
                        case LEVEL_ONE_DEFENSE_TOWER : {
                            targetSecondary = defenseTower[4][2];
                            break;
                        }
                        case LEVEL_ONE_PAINT_TOWER : {
                            targetSecondary = paintTower[4][2];
                            break;
                        }
                        default : {
                            targetSecondary = moneyTower[4][2];
                            break;
                        }
                    }
                    if ((mi.getPaint() == PaintType.EMPTY) || (isSecondary != targetSecondary)) {
                        needsChanges += 5;
                        if (rc.getPaint() - needsChanges < 10) return false;
                    }
                }
            }
        }
        
        
        
        tmp = new MapLocation(ruin.x + 2, ruin.y + -1);
        if (rc.canSenseLocation(tmp)) {
            MapInfo mi = rc.senseMapInfo(tmp);
            switch (mi.getPaint()) {
                case ENEMY_SECONDARY, ENEMY_PRIMARY: return false;
                default: {
                    boolean isSecondary = (mi.getPaint() == PaintType.ALLY_SECONDARY);
                    boolean targetSecondary = false;
                    switch (t) {
                        case LEVEL_ONE_DEFENSE_TOWER : {
                            targetSecondary = defenseTower[4][1];
                            break;
                        }
                        case LEVEL_ONE_PAINT_TOWER : {
                            targetSecondary = paintTower[4][1];
                            break;
                        }
                        default : {
                            targetSecondary = moneyTower[4][1];
                            break;
                        }
                    }
                    if ((mi.getPaint() == PaintType.EMPTY) || (isSecondary != targetSecondary)) {
                        needsChanges += 5;
                        if (rc.getPaint() - needsChanges < 10) return false;
                    }
                }
            }
        }
        
        
        
        tmp = new MapLocation(ruin.x + 2, ruin.y + -2);
        if (rc.canSenseLocation(tmp)) {
            MapInfo mi = rc.senseMapInfo(tmp);
            switch (mi.getPaint()) {
                case ENEMY_SECONDARY, ENEMY_PRIMARY: return false;
                default: {
                    boolean isSecondary = (mi.getPaint() == PaintType.ALLY_SECONDARY);
                    boolean targetSecondary = false;
                    switch (t) {
                        case LEVEL_ONE_DEFENSE_TOWER : {
                            targetSecondary = defenseTower[4][0];
                            break;
                        }
                        case LEVEL_ONE_PAINT_TOWER : {
                            targetSecondary = paintTower[4][0];
                            break;
                        }
                        default : {
                            targetSecondary = moneyTower[4][0];
                            break;
                        }
                    }
                    if ((mi.getPaint() == PaintType.EMPTY) || (isSecondary != targetSecondary)) {
                        needsChanges += 5;
                        if (rc.getPaint() - needsChanges < 10) return false;
                    }
                }
            }
        }
        
        
        
        
        
        tmp = new MapLocation(ruin.x + 1, ruin.y + 2);
        if (rc.canSenseLocation(tmp)) {
            MapInfo mi = rc.senseMapInfo(tmp);
            switch (mi.getPaint()) {
                case ENEMY_SECONDARY, ENEMY_PRIMARY: return false;
                default: {
                    boolean isSecondary = (mi.getPaint() == PaintType.ALLY_SECONDARY);
                    boolean targetSecondary = false;
                    switch (t) {
                        case LEVEL_ONE_DEFENSE_TOWER : {
                            targetSecondary = defenseTower[3][4];
                            break;
                        }
                        case LEVEL_ONE_PAINT_TOWER : {
                            targetSecondary = paintTower[3][4];
                            break;
                        }
                        default : {
                            targetSecondary = moneyTower[3][4];
                            break;
                        }
                    }
                    if ((mi.getPaint() == PaintType.EMPTY) || (isSecondary != targetSecondary)) {
                        needsChanges += 5;
                        if (rc.getPaint() - needsChanges < 10) return false;
                    }
                }
            }
        }
        
        
        
        tmp = new MapLocation(ruin.x + 1, ruin.y + 1);
        if (rc.canSenseLocation(tmp)) {
            MapInfo mi = rc.senseMapInfo(tmp);
            switch (mi.getPaint()) {
                case ENEMY_SECONDARY, ENEMY_PRIMARY: return false;
                default: {
                    boolean isSecondary = (mi.getPaint() == PaintType.ALLY_SECONDARY);
                    boolean targetSecondary = false;
                    switch (t) {
                        case LEVEL_ONE_DEFENSE_TOWER : {
                            targetSecondary = defenseTower[3][3];
                            break;
                        }
                        case LEVEL_ONE_PAINT_TOWER : {
                            targetSecondary = paintTower[3][3];
                            break;
                        }
                        default : {
                            targetSecondary = moneyTower[3][3];
                            break;
                        }
                    }
                    if ((mi.getPaint() == PaintType.EMPTY) || (isSecondary != targetSecondary)) {
                        needsChanges += 5;
                        if (rc.getPaint() - needsChanges < 10) return false;
                    }
                }
            }
        }
        
        
        
        tmp = new MapLocation(ruin.x + 1, ruin.y + 0);
        if (rc.canSenseLocation(tmp)) {
            MapInfo mi = rc.senseMapInfo(tmp);
            switch (mi.getPaint()) {
                case ENEMY_SECONDARY, ENEMY_PRIMARY: return false;
                default: {
                    boolean isSecondary = (mi.getPaint() == PaintType.ALLY_SECONDARY);
                    boolean targetSecondary = false;
                    switch (t) {
                        case LEVEL_ONE_DEFENSE_TOWER : {
                            targetSecondary = defenseTower[3][2];
                            break;
                        }
                        case LEVEL_ONE_PAINT_TOWER : {
                            targetSecondary = paintTower[3][2];
                            break;
                        }
                        default : {
                            targetSecondary = moneyTower[3][2];
                            break;
                        }
                    }
                    if ((mi.getPaint() == PaintType.EMPTY) || (isSecondary != targetSecondary)) {
                        needsChanges += 5;
                        if (rc.getPaint() - needsChanges < 10) return false;
                    }
                }
            }
        }
        
        
        
        tmp = new MapLocation(ruin.x + 1, ruin.y + -1);
        if (rc.canSenseLocation(tmp)) {
            MapInfo mi = rc.senseMapInfo(tmp);
            switch (mi.getPaint()) {
                case ENEMY_SECONDARY, ENEMY_PRIMARY: return false;
                default: {
                    boolean isSecondary = (mi.getPaint() == PaintType.ALLY_SECONDARY);
                    boolean targetSecondary = false;
                    switch (t) {
                        case LEVEL_ONE_DEFENSE_TOWER : {
                            targetSecondary = defenseTower[3][1];
                            break;
                        }
                        case LEVEL_ONE_PAINT_TOWER : {
                            targetSecondary = paintTower[3][1];
                            break;
                        }
                        default : {
                            targetSecondary = moneyTower[3][1];
                            break;
                        }
                    }
                    if ((mi.getPaint() == PaintType.EMPTY) || (isSecondary != targetSecondary)) {
                        needsChanges += 5;
                        if (rc.getPaint() - needsChanges < 10) return false;
                    }
                }
            }
        }
        
        
        
        tmp = new MapLocation(ruin.x + 1, ruin.y + -2);
        if (rc.canSenseLocation(tmp)) {
            MapInfo mi = rc.senseMapInfo(tmp);
            switch (mi.getPaint()) {
                case ENEMY_SECONDARY, ENEMY_PRIMARY: return false;
                default: {
                    boolean isSecondary = (mi.getPaint() == PaintType.ALLY_SECONDARY);
                    boolean targetSecondary = false;
                    switch (t) {
                        case LEVEL_ONE_DEFENSE_TOWER : {
                            targetSecondary = defenseTower[3][0];
                            break;
                        }
                        case LEVEL_ONE_PAINT_TOWER : {
                            targetSecondary = paintTower[3][0];
                            break;
                        }
                        default : {
                            targetSecondary = moneyTower[3][0];
                            break;
                        }
                    }
                    if ((mi.getPaint() == PaintType.EMPTY) || (isSecondary != targetSecondary)) {
                        needsChanges += 5;
                        if (rc.getPaint() - needsChanges < 10) return false;
                    }
                }
            }
        }
        
        
        
        
        
        tmp = new MapLocation(ruin.x + 0, ruin.y + 2);
        if (rc.canSenseLocation(tmp)) {
            MapInfo mi = rc.senseMapInfo(tmp);
            switch (mi.getPaint()) {
                case ENEMY_SECONDARY, ENEMY_PRIMARY: return false;
                default: {
                    boolean isSecondary = (mi.getPaint() == PaintType.ALLY_SECONDARY);
                    boolean targetSecondary = false;
                    switch (t) {
                        case LEVEL_ONE_DEFENSE_TOWER : {
                            targetSecondary = defenseTower[2][4];
                            break;
                        }
                        case LEVEL_ONE_PAINT_TOWER : {
                            targetSecondary = paintTower[2][4];
                            break;
                        }
                        default : {
                            targetSecondary = moneyTower[2][4];
                            break;
                        }
                    }
                    if ((mi.getPaint() == PaintType.EMPTY) || (isSecondary != targetSecondary)) {
                        needsChanges += 5;
                        if (rc.getPaint() - needsChanges < 10) return false;
                    }
                }
            }
        }
        
        
        
        tmp = new MapLocation(ruin.x + 0, ruin.y + 1);
        if (rc.canSenseLocation(tmp)) {
            MapInfo mi = rc.senseMapInfo(tmp);
            switch (mi.getPaint()) {
                case ENEMY_SECONDARY, ENEMY_PRIMARY: return false;
                default: {
                    boolean isSecondary = (mi.getPaint() == PaintType.ALLY_SECONDARY);
                    boolean targetSecondary = false;
                    switch (t) {
                        case LEVEL_ONE_DEFENSE_TOWER : {
                            targetSecondary = defenseTower[2][3];
                            break;
                        }
                        case LEVEL_ONE_PAINT_TOWER : {
                            targetSecondary = paintTower[2][3];
                            break;
                        }
                        default : {
                            targetSecondary = moneyTower[2][3];
                            break;
                        }
                    }
                    if ((mi.getPaint() == PaintType.EMPTY) || (isSecondary != targetSecondary)) {
                        needsChanges += 5;
                        if (rc.getPaint() - needsChanges < 10) return false;
                    }
                }
            }
        }
        
        
        
        
        
        tmp = new MapLocation(ruin.x + 0, ruin.y + -1);
        if (rc.canSenseLocation(tmp)) {
            MapInfo mi = rc.senseMapInfo(tmp);
            switch (mi.getPaint()) {
                case ENEMY_SECONDARY, ENEMY_PRIMARY: return false;
                default: {
                    boolean isSecondary = (mi.getPaint() == PaintType.ALLY_SECONDARY);
                    boolean targetSecondary = false;
                    switch (t) {
                        case LEVEL_ONE_DEFENSE_TOWER : {
                            targetSecondary = defenseTower[2][1];
                            break;
                        }
                        case LEVEL_ONE_PAINT_TOWER : {
                            targetSecondary = paintTower[2][1];
                            break;
                        }
                        default : {
                            targetSecondary = moneyTower[2][1];
                            break;
                        }
                    }
                    if ((mi.getPaint() == PaintType.EMPTY) || (isSecondary != targetSecondary)) {
                        needsChanges += 5;
                        if (rc.getPaint() - needsChanges < 10) return false;
                    }
                }
            }
        }
        
        
        
        tmp = new MapLocation(ruin.x + 0, ruin.y + -2);
        if (rc.canSenseLocation(tmp)) {
            MapInfo mi = rc.senseMapInfo(tmp);
            switch (mi.getPaint()) {
                case ENEMY_SECONDARY, ENEMY_PRIMARY: return false;
                default: {
                    boolean isSecondary = (mi.getPaint() == PaintType.ALLY_SECONDARY);
                    boolean targetSecondary = false;
                    switch (t) {
                        case LEVEL_ONE_DEFENSE_TOWER : {
                            targetSecondary = defenseTower[2][0];
                            break;
                        }
                        case LEVEL_ONE_PAINT_TOWER : {
                            targetSecondary = paintTower[2][0];
                            break;
                        }
                        default : {
                            targetSecondary = moneyTower[2][0];
                            break;
                        }
                    }
                    if ((mi.getPaint() == PaintType.EMPTY) || (isSecondary != targetSecondary)) {
                        needsChanges += 5;
                        if (rc.getPaint() - needsChanges < 10) return false;
                    }
                }
            }
        }
        
        
        
        
        
        tmp = new MapLocation(ruin.x + -1, ruin.y + 2);
        if (rc.canSenseLocation(tmp)) {
            MapInfo mi = rc.senseMapInfo(tmp);
            switch (mi.getPaint()) {
                case ENEMY_SECONDARY, ENEMY_PRIMARY: return false;
                default: {
                    boolean isSecondary = (mi.getPaint() == PaintType.ALLY_SECONDARY);
                    boolean targetSecondary = false;
                    switch (t) {
                        case LEVEL_ONE_DEFENSE_TOWER : {
                            targetSecondary = defenseTower[1][4];
                            break;
                        }
                        case LEVEL_ONE_PAINT_TOWER : {
                            targetSecondary = paintTower[1][4];
                            break;
                        }
                        default : {
                            targetSecondary = moneyTower[1][4];
                            break;
                        }
                    }
                    if ((mi.getPaint() == PaintType.EMPTY) || (isSecondary != targetSecondary)) {
                        needsChanges += 5;
                        if (rc.getPaint() - needsChanges < 10) return false;
                    }
                }
            }
        }
        
        
        
        tmp = new MapLocation(ruin.x + -1, ruin.y + 1);
        if (rc.canSenseLocation(tmp)) {
            MapInfo mi = rc.senseMapInfo(tmp);
            switch (mi.getPaint()) {
                case ENEMY_SECONDARY, ENEMY_PRIMARY: return false;
                default: {
                    boolean isSecondary = (mi.getPaint() == PaintType.ALLY_SECONDARY);
                    boolean targetSecondary = false;
                    switch (t) {
                        case LEVEL_ONE_DEFENSE_TOWER : {
                            targetSecondary = defenseTower[1][3];
                            break;
                        }
                        case LEVEL_ONE_PAINT_TOWER : {
                            targetSecondary = paintTower[1][3];
                            break;
                        }
                        default : {
                            targetSecondary = moneyTower[1][3];
                            break;
                        }
                    }
                    if ((mi.getPaint() == PaintType.EMPTY) || (isSecondary != targetSecondary)) {
                        needsChanges += 5;
                        if (rc.getPaint() - needsChanges < 10) return false;
                    }
                }
            }
        }
        
        
        
        tmp = new MapLocation(ruin.x + -1, ruin.y + 0);
        if (rc.canSenseLocation(tmp)) {
            MapInfo mi = rc.senseMapInfo(tmp);
            switch (mi.getPaint()) {
                case ENEMY_SECONDARY, ENEMY_PRIMARY: return false;
                default: {
                    boolean isSecondary = (mi.getPaint() == PaintType.ALLY_SECONDARY);
                    boolean targetSecondary = false;
                    switch (t) {
                        case LEVEL_ONE_DEFENSE_TOWER : {
                            targetSecondary = defenseTower[1][2];
                            break;
                        }
                        case LEVEL_ONE_PAINT_TOWER : {
                            targetSecondary = paintTower[1][2];
                            break;
                        }
                        default : {
                            targetSecondary = moneyTower[1][2];
                            break;
                        }
                    }
                    if ((mi.getPaint() == PaintType.EMPTY) || (isSecondary != targetSecondary)) {
                        needsChanges += 5;
                        if (rc.getPaint() - needsChanges < 10) return false;
                    }
                }
            }
        }
        
        
        
        tmp = new MapLocation(ruin.x + -1, ruin.y + -1);
        if (rc.canSenseLocation(tmp)) {
            MapInfo mi = rc.senseMapInfo(tmp);
            switch (mi.getPaint()) {
                case ENEMY_SECONDARY, ENEMY_PRIMARY: return false;
                default: {
                    boolean isSecondary = (mi.getPaint() == PaintType.ALLY_SECONDARY);
                    boolean targetSecondary = false;
                    switch (t) {
                        case LEVEL_ONE_DEFENSE_TOWER : {
                            targetSecondary = defenseTower[1][1];
                            break;
                        }
                        case LEVEL_ONE_PAINT_TOWER : {
                            targetSecondary = paintTower[1][1];
                            break;
                        }
                        default : {
                            targetSecondary = moneyTower[1][1];
                            break;
                        }
                    }
                    if ((mi.getPaint() == PaintType.EMPTY) || (isSecondary != targetSecondary)) {
                        needsChanges += 5;
                        if (rc.getPaint() - needsChanges < 10) return false;
                    }
                }
            }
        }
        
        
        
        tmp = new MapLocation(ruin.x + -1, ruin.y + -2);
        if (rc.canSenseLocation(tmp)) {
            MapInfo mi = rc.senseMapInfo(tmp);
            switch (mi.getPaint()) {
                case ENEMY_SECONDARY, ENEMY_PRIMARY: return false;
                default: {
                    boolean isSecondary = (mi.getPaint() == PaintType.ALLY_SECONDARY);
                    boolean targetSecondary = false;
                    switch (t) {
                        case LEVEL_ONE_DEFENSE_TOWER : {
                            targetSecondary = defenseTower[1][0];
                            break;
                        }
                        case LEVEL_ONE_PAINT_TOWER : {
                            targetSecondary = paintTower[1][0];
                            break;
                        }
                        default : {
                            targetSecondary = moneyTower[1][0];
                            break;
                        }
                    }
                    if ((mi.getPaint() == PaintType.EMPTY) || (isSecondary != targetSecondary)) {
                        needsChanges += 5;
                        if (rc.getPaint() - needsChanges < 10) return false;
                    }
                }
            }
        }
        
        
        
        
        
        tmp = new MapLocation(ruin.x + -2, ruin.y + 2);
        if (rc.canSenseLocation(tmp)) {
            MapInfo mi = rc.senseMapInfo(tmp);
            switch (mi.getPaint()) {
                case ENEMY_SECONDARY, ENEMY_PRIMARY: return false;
                default: {
                    boolean isSecondary = (mi.getPaint() == PaintType.ALLY_SECONDARY);
                    boolean targetSecondary = false;
                    switch (t) {
                        case LEVEL_ONE_DEFENSE_TOWER : {
                            targetSecondary = defenseTower[0][4];
                            break;
                        }
                        case LEVEL_ONE_PAINT_TOWER : {
                            targetSecondary = paintTower[0][4];
                            break;
                        }
                        default : {
                            targetSecondary = moneyTower[0][4];
                            break;
                        }
                    }
                    if ((mi.getPaint() == PaintType.EMPTY) || (isSecondary != targetSecondary)) {
                        needsChanges += 5;
                        if (rc.getPaint() - needsChanges < 10) return false;
                    }
                }
            }
        }
        
        
        
        tmp = new MapLocation(ruin.x + -2, ruin.y + 1);
        if (rc.canSenseLocation(tmp)) {
            MapInfo mi = rc.senseMapInfo(tmp);
            switch (mi.getPaint()) {
                case ENEMY_SECONDARY, ENEMY_PRIMARY: return false;
                default: {
                    boolean isSecondary = (mi.getPaint() == PaintType.ALLY_SECONDARY);
                    boolean targetSecondary = false;
                    switch (t) {
                        case LEVEL_ONE_DEFENSE_TOWER : {
                            targetSecondary = defenseTower[0][3];
                            break;
                        }
                        case LEVEL_ONE_PAINT_TOWER : {
                            targetSecondary = paintTower[0][3];
                            break;
                        }
                        default : {
                            targetSecondary = moneyTower[0][3];
                            break;
                        }
                    }
                    if ((mi.getPaint() == PaintType.EMPTY) || (isSecondary != targetSecondary)) {
                        needsChanges += 5;
                        if (rc.getPaint() - needsChanges < 10) return false;
                    }
                }
            }
        }
        
        
        
        tmp = new MapLocation(ruin.x + -2, ruin.y + 0);
        if (rc.canSenseLocation(tmp)) {
            MapInfo mi = rc.senseMapInfo(tmp);
            switch (mi.getPaint()) {
                case ENEMY_SECONDARY, ENEMY_PRIMARY: return false;
                default: {
                    boolean isSecondary = (mi.getPaint() == PaintType.ALLY_SECONDARY);
                    boolean targetSecondary = false;
                    switch (t) {
                        case LEVEL_ONE_DEFENSE_TOWER : {
                            targetSecondary = defenseTower[0][2];
                            break;
                        }
                        case LEVEL_ONE_PAINT_TOWER : {
                            targetSecondary = paintTower[0][2];
                            break;
                        }
                        default : {
                            targetSecondary = moneyTower[0][2];
                            break;
                        }
                    }
                    if ((mi.getPaint() == PaintType.EMPTY) || (isSecondary != targetSecondary)) {
                        needsChanges += 5;
                        if (rc.getPaint() - needsChanges < 10) return false;
                    }
                }
            }
        }
        
        
        
        tmp = new MapLocation(ruin.x + -2, ruin.y + -1);
        if (rc.canSenseLocation(tmp)) {
            MapInfo mi = rc.senseMapInfo(tmp);
            switch (mi.getPaint()) {
                case ENEMY_SECONDARY, ENEMY_PRIMARY: return false;
                default: {
                    boolean isSecondary = (mi.getPaint() == PaintType.ALLY_SECONDARY);
                    boolean targetSecondary = false;
                    switch (t) {
                        case LEVEL_ONE_DEFENSE_TOWER : {
                            targetSecondary = defenseTower[0][1];
                            break;
                        }
                        case LEVEL_ONE_PAINT_TOWER : {
                            targetSecondary = paintTower[0][1];
                            break;
                        }
                        default : {
                            targetSecondary = moneyTower[0][1];
                            break;
                        }
                    }
                    if ((mi.getPaint() == PaintType.EMPTY) || (isSecondary != targetSecondary)) {
                        needsChanges += 5;
                        if (rc.getPaint() - needsChanges < 10) return false;
                    }
                }
            }
        }
        
        
        
        tmp = new MapLocation(ruin.x + -2, ruin.y + -2);
        if (rc.canSenseLocation(tmp)) {
            MapInfo mi = rc.senseMapInfo(tmp);
            switch (mi.getPaint()) {
                case ENEMY_SECONDARY, ENEMY_PRIMARY: return false;
                default: {
                    boolean isSecondary = (mi.getPaint() == PaintType.ALLY_SECONDARY);
                    boolean targetSecondary = false;
                    switch (t) {
                        case LEVEL_ONE_DEFENSE_TOWER : {
                            targetSecondary = defenseTower[0][0];
                            break;
                        }
                        case LEVEL_ONE_PAINT_TOWER : {
                            targetSecondary = paintTower[0][0];
                            break;
                        }
                        default : {
                            targetSecondary = moneyTower[0][0];
                            break;
                        }
                    }
                    if ((mi.getPaint() == PaintType.EMPTY) || (isSecondary != targetSecondary)) {
                        needsChanges += 5;
                        if (rc.getPaint() - needsChanges < 10) return false;
                    }
                }
            }
        }
        
        
        
        return (rc.getPaint() - needsChanges) >= 10;
    }

    public static boolean seeTaintedRuin(MapLocation ruin) throws GameActionException {
        MapLocation tmp;
        UnitType t = Globals.getTowerToBuild(ruin);
        
        
        
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

    public static void makeTower(MapLocation buildTower) throws GameActionException {
        prevRuin = buildTower;

        UnitType t = Globals.getTowerToBuild(buildTower);
        MapLocation tmp;
        MapLocation goal = null;
        boolean secondCol = false;
        int bestDist = 1000000000;
        int d;
        
        
        
        tmp = new MapLocation(buildTower.x + 2, buildTower.y + 2);
        d = rc.getLocation().distanceSquaredTo(tmp);
        if (d < bestDist) {
            if (rc.canSenseLocation(tmp)) {
                MapInfo mi = rc.senseMapInfo(tmp);
                switch (mi.getPaint()) {
                    case ENEMY_SECONDARY, ENEMY_PRIMARY -> {
                        if (rc.getType() == UnitType.MOPPER) {
                            bestDist = d;
                            goal = tmp;
                        }
                        break;
                    }
                    default -> {
                        if (rc.getType() == UnitType.SOLDIER) {
                            boolean isSecondary = (mi.getPaint() == PaintType.ALLY_SECONDARY);
                            boolean targetSecondary = false;
                            switch (t) {
                                case LEVEL_ONE_DEFENSE_TOWER : {
                                    targetSecondary = defenseTower[4][4];
                                    break;
                                }
                                case LEVEL_ONE_PAINT_TOWER : {
                                    targetSecondary = paintTower[4][4];
                                    break;
                                }
                                default : {
                                    targetSecondary = moneyTower[4][4];
                                    break;
                                }
                            }
                            if ((mi.getPaint() == PaintType.EMPTY) || (isSecondary != targetSecondary)) {
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
        d = rc.getLocation().distanceSquaredTo(tmp);
        if (d < bestDist) {
            if (rc.canSenseLocation(tmp)) {
                MapInfo mi = rc.senseMapInfo(tmp);
                switch (mi.getPaint()) {
                    case ENEMY_SECONDARY, ENEMY_PRIMARY -> {
                        if (rc.getType() == UnitType.MOPPER) {
                            bestDist = d;
                            goal = tmp;
                        }
                        break;
                    }
                    default -> {
                        if (rc.getType() == UnitType.SOLDIER) {
                            boolean isSecondary = (mi.getPaint() == PaintType.ALLY_SECONDARY);
                            boolean targetSecondary = false;
                            switch (t) {
                                case LEVEL_ONE_DEFENSE_TOWER : {
                                    targetSecondary = defenseTower[4][3];
                                    break;
                                }
                                case LEVEL_ONE_PAINT_TOWER : {
                                    targetSecondary = paintTower[4][3];
                                    break;
                                }
                                default : {
                                    targetSecondary = moneyTower[4][3];
                                    break;
                                }
                            }
                            if ((mi.getPaint() == PaintType.EMPTY) || (isSecondary != targetSecondary)) {
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
        d = rc.getLocation().distanceSquaredTo(tmp);
        if (d < bestDist) {
            if (rc.canSenseLocation(tmp)) {
                MapInfo mi = rc.senseMapInfo(tmp);
                switch (mi.getPaint()) {
                    case ENEMY_SECONDARY, ENEMY_PRIMARY -> {
                        if (rc.getType() == UnitType.MOPPER) {
                            bestDist = d;
                            goal = tmp;
                        }
                        break;
                    }
                    default -> {
                        if (rc.getType() == UnitType.SOLDIER) {
                            boolean isSecondary = (mi.getPaint() == PaintType.ALLY_SECONDARY);
                            boolean targetSecondary = false;
                            switch (t) {
                                case LEVEL_ONE_DEFENSE_TOWER : {
                                    targetSecondary = defenseTower[4][2];
                                    break;
                                }
                                case LEVEL_ONE_PAINT_TOWER : {
                                    targetSecondary = paintTower[4][2];
                                    break;
                                }
                                default : {
                                    targetSecondary = moneyTower[4][2];
                                    break;
                                }
                            }
                            if ((mi.getPaint() == PaintType.EMPTY) || (isSecondary != targetSecondary)) {
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
        d = rc.getLocation().distanceSquaredTo(tmp);
        if (d < bestDist) {
            if (rc.canSenseLocation(tmp)) {
                MapInfo mi = rc.senseMapInfo(tmp);
                switch (mi.getPaint()) {
                    case ENEMY_SECONDARY, ENEMY_PRIMARY -> {
                        if (rc.getType() == UnitType.MOPPER) {
                            bestDist = d;
                            goal = tmp;
                        }
                        break;
                    }
                    default -> {
                        if (rc.getType() == UnitType.SOLDIER) {
                            boolean isSecondary = (mi.getPaint() == PaintType.ALLY_SECONDARY);
                            boolean targetSecondary = false;
                            switch (t) {
                                case LEVEL_ONE_DEFENSE_TOWER : {
                                    targetSecondary = defenseTower[4][1];
                                    break;
                                }
                                case LEVEL_ONE_PAINT_TOWER : {
                                    targetSecondary = paintTower[4][1];
                                    break;
                                }
                                default : {
                                    targetSecondary = moneyTower[4][1];
                                    break;
                                }
                            }
                            if ((mi.getPaint() == PaintType.EMPTY) || (isSecondary != targetSecondary)) {
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
        d = rc.getLocation().distanceSquaredTo(tmp);
        if (d < bestDist) {
            if (rc.canSenseLocation(tmp)) {
                MapInfo mi = rc.senseMapInfo(tmp);
                switch (mi.getPaint()) {
                    case ENEMY_SECONDARY, ENEMY_PRIMARY -> {
                        if (rc.getType() == UnitType.MOPPER) {
                            bestDist = d;
                            goal = tmp;
                        }
                        break;
                    }
                    default -> {
                        if (rc.getType() == UnitType.SOLDIER) {
                            boolean isSecondary = (mi.getPaint() == PaintType.ALLY_SECONDARY);
                            boolean targetSecondary = false;
                            switch (t) {
                                case LEVEL_ONE_DEFENSE_TOWER : {
                                    targetSecondary = defenseTower[4][0];
                                    break;
                                }
                                case LEVEL_ONE_PAINT_TOWER : {
                                    targetSecondary = paintTower[4][0];
                                    break;
                                }
                                default : {
                                    targetSecondary = moneyTower[4][0];
                                    break;
                                }
                            }
                            if ((mi.getPaint() == PaintType.EMPTY) || (isSecondary != targetSecondary)) {
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
        d = rc.getLocation().distanceSquaredTo(tmp);
        if (d < bestDist) {
            if (rc.canSenseLocation(tmp)) {
                MapInfo mi = rc.senseMapInfo(tmp);
                switch (mi.getPaint()) {
                    case ENEMY_SECONDARY, ENEMY_PRIMARY -> {
                        if (rc.getType() == UnitType.MOPPER) {
                            bestDist = d;
                            goal = tmp;
                        }
                        break;
                    }
                    default -> {
                        if (rc.getType() == UnitType.SOLDIER) {
                            boolean isSecondary = (mi.getPaint() == PaintType.ALLY_SECONDARY);
                            boolean targetSecondary = false;
                            switch (t) {
                                case LEVEL_ONE_DEFENSE_TOWER : {
                                    targetSecondary = defenseTower[3][4];
                                    break;
                                }
                                case LEVEL_ONE_PAINT_TOWER : {
                                    targetSecondary = paintTower[3][4];
                                    break;
                                }
                                default : {
                                    targetSecondary = moneyTower[3][4];
                                    break;
                                }
                            }
                            if ((mi.getPaint() == PaintType.EMPTY) || (isSecondary != targetSecondary)) {
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
        d = rc.getLocation().distanceSquaredTo(tmp);
        if (d < bestDist) {
            if (rc.canSenseLocation(tmp)) {
                MapInfo mi = rc.senseMapInfo(tmp);
                switch (mi.getPaint()) {
                    case ENEMY_SECONDARY, ENEMY_PRIMARY -> {
                        if (rc.getType() == UnitType.MOPPER) {
                            bestDist = d;
                            goal = tmp;
                        }
                        break;
                    }
                    default -> {
                        if (rc.getType() == UnitType.SOLDIER) {
                            boolean isSecondary = (mi.getPaint() == PaintType.ALLY_SECONDARY);
                            boolean targetSecondary = false;
                            switch (t) {
                                case LEVEL_ONE_DEFENSE_TOWER : {
                                    targetSecondary = defenseTower[3][3];
                                    break;
                                }
                                case LEVEL_ONE_PAINT_TOWER : {
                                    targetSecondary = paintTower[3][3];
                                    break;
                                }
                                default : {
                                    targetSecondary = moneyTower[3][3];
                                    break;
                                }
                            }
                            if ((mi.getPaint() == PaintType.EMPTY) || (isSecondary != targetSecondary)) {
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
        d = rc.getLocation().distanceSquaredTo(tmp);
        if (d < bestDist) {
            if (rc.canSenseLocation(tmp)) {
                MapInfo mi = rc.senseMapInfo(tmp);
                switch (mi.getPaint()) {
                    case ENEMY_SECONDARY, ENEMY_PRIMARY -> {
                        if (rc.getType() == UnitType.MOPPER) {
                            bestDist = d;
                            goal = tmp;
                        }
                        break;
                    }
                    default -> {
                        if (rc.getType() == UnitType.SOLDIER) {
                            boolean isSecondary = (mi.getPaint() == PaintType.ALLY_SECONDARY);
                            boolean targetSecondary = false;
                            switch (t) {
                                case LEVEL_ONE_DEFENSE_TOWER : {
                                    targetSecondary = defenseTower[3][2];
                                    break;
                                }
                                case LEVEL_ONE_PAINT_TOWER : {
                                    targetSecondary = paintTower[3][2];
                                    break;
                                }
                                default : {
                                    targetSecondary = moneyTower[3][2];
                                    break;
                                }
                            }
                            if ((mi.getPaint() == PaintType.EMPTY) || (isSecondary != targetSecondary)) {
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
        d = rc.getLocation().distanceSquaredTo(tmp);
        if (d < bestDist) {
            if (rc.canSenseLocation(tmp)) {
                MapInfo mi = rc.senseMapInfo(tmp);
                switch (mi.getPaint()) {
                    case ENEMY_SECONDARY, ENEMY_PRIMARY -> {
                        if (rc.getType() == UnitType.MOPPER) {
                            bestDist = d;
                            goal = tmp;
                        }
                        break;
                    }
                    default -> {
                        if (rc.getType() == UnitType.SOLDIER) {
                            boolean isSecondary = (mi.getPaint() == PaintType.ALLY_SECONDARY);
                            boolean targetSecondary = false;
                            switch (t) {
                                case LEVEL_ONE_DEFENSE_TOWER : {
                                    targetSecondary = defenseTower[3][1];
                                    break;
                                }
                                case LEVEL_ONE_PAINT_TOWER : {
                                    targetSecondary = paintTower[3][1];
                                    break;
                                }
                                default : {
                                    targetSecondary = moneyTower[3][1];
                                    break;
                                }
                            }
                            if ((mi.getPaint() == PaintType.EMPTY) || (isSecondary != targetSecondary)) {
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
        d = rc.getLocation().distanceSquaredTo(tmp);
        if (d < bestDist) {
            if (rc.canSenseLocation(tmp)) {
                MapInfo mi = rc.senseMapInfo(tmp);
                switch (mi.getPaint()) {
                    case ENEMY_SECONDARY, ENEMY_PRIMARY -> {
                        if (rc.getType() == UnitType.MOPPER) {
                            bestDist = d;
                            goal = tmp;
                        }
                        break;
                    }
                    default -> {
                        if (rc.getType() == UnitType.SOLDIER) {
                            boolean isSecondary = (mi.getPaint() == PaintType.ALLY_SECONDARY);
                            boolean targetSecondary = false;
                            switch (t) {
                                case LEVEL_ONE_DEFENSE_TOWER : {
                                    targetSecondary = defenseTower[3][0];
                                    break;
                                }
                                case LEVEL_ONE_PAINT_TOWER : {
                                    targetSecondary = paintTower[3][0];
                                    break;
                                }
                                default : {
                                    targetSecondary = moneyTower[3][0];
                                    break;
                                }
                            }
                            if ((mi.getPaint() == PaintType.EMPTY) || (isSecondary != targetSecondary)) {
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
        d = rc.getLocation().distanceSquaredTo(tmp);
        if (d < bestDist) {
            if (rc.canSenseLocation(tmp)) {
                MapInfo mi = rc.senseMapInfo(tmp);
                switch (mi.getPaint()) {
                    case ENEMY_SECONDARY, ENEMY_PRIMARY -> {
                        if (rc.getType() == UnitType.MOPPER) {
                            bestDist = d;
                            goal = tmp;
                        }
                        break;
                    }
                    default -> {
                        if (rc.getType() == UnitType.SOLDIER) {
                            boolean isSecondary = (mi.getPaint() == PaintType.ALLY_SECONDARY);
                            boolean targetSecondary = false;
                            switch (t) {
                                case LEVEL_ONE_DEFENSE_TOWER : {
                                    targetSecondary = defenseTower[2][4];
                                    break;
                                }
                                case LEVEL_ONE_PAINT_TOWER : {
                                    targetSecondary = paintTower[2][4];
                                    break;
                                }
                                default : {
                                    targetSecondary = moneyTower[2][4];
                                    break;
                                }
                            }
                            if ((mi.getPaint() == PaintType.EMPTY) || (isSecondary != targetSecondary)) {
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
        d = rc.getLocation().distanceSquaredTo(tmp);
        if (d < bestDist) {
            if (rc.canSenseLocation(tmp)) {
                MapInfo mi = rc.senseMapInfo(tmp);
                switch (mi.getPaint()) {
                    case ENEMY_SECONDARY, ENEMY_PRIMARY -> {
                        if (rc.getType() == UnitType.MOPPER) {
                            bestDist = d;
                            goal = tmp;
                        }
                        break;
                    }
                    default -> {
                        if (rc.getType() == UnitType.SOLDIER) {
                            boolean isSecondary = (mi.getPaint() == PaintType.ALLY_SECONDARY);
                            boolean targetSecondary = false;
                            switch (t) {
                                case LEVEL_ONE_DEFENSE_TOWER : {
                                    targetSecondary = defenseTower[2][3];
                                    break;
                                }
                                case LEVEL_ONE_PAINT_TOWER : {
                                    targetSecondary = paintTower[2][3];
                                    break;
                                }
                                default : {
                                    targetSecondary = moneyTower[2][3];
                                    break;
                                }
                            }
                            if ((mi.getPaint() == PaintType.EMPTY) || (isSecondary != targetSecondary)) {
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
        d = rc.getLocation().distanceSquaredTo(tmp);
        if (d < bestDist) {
            if (rc.canSenseLocation(tmp)) {
                MapInfo mi = rc.senseMapInfo(tmp);
                switch (mi.getPaint()) {
                    case ENEMY_SECONDARY, ENEMY_PRIMARY -> {
                        if (rc.getType() == UnitType.MOPPER) {
                            bestDist = d;
                            goal = tmp;
                        }
                        break;
                    }
                    default -> {
                        if (rc.getType() == UnitType.SOLDIER) {
                            boolean isSecondary = (mi.getPaint() == PaintType.ALLY_SECONDARY);
                            boolean targetSecondary = false;
                            switch (t) {
                                case LEVEL_ONE_DEFENSE_TOWER : {
                                    targetSecondary = defenseTower[2][1];
                                    break;
                                }
                                case LEVEL_ONE_PAINT_TOWER : {
                                    targetSecondary = paintTower[2][1];
                                    break;
                                }
                                default : {
                                    targetSecondary = moneyTower[2][1];
                                    break;
                                }
                            }
                            if ((mi.getPaint() == PaintType.EMPTY) || (isSecondary != targetSecondary)) {
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
        d = rc.getLocation().distanceSquaredTo(tmp);
        if (d < bestDist) {
            if (rc.canSenseLocation(tmp)) {
                MapInfo mi = rc.senseMapInfo(tmp);
                switch (mi.getPaint()) {
                    case ENEMY_SECONDARY, ENEMY_PRIMARY -> {
                        if (rc.getType() == UnitType.MOPPER) {
                            bestDist = d;
                            goal = tmp;
                        }
                        break;
                    }
                    default -> {
                        if (rc.getType() == UnitType.SOLDIER) {
                            boolean isSecondary = (mi.getPaint() == PaintType.ALLY_SECONDARY);
                            boolean targetSecondary = false;
                            switch (t) {
                                case LEVEL_ONE_DEFENSE_TOWER : {
                                    targetSecondary = defenseTower[2][0];
                                    break;
                                }
                                case LEVEL_ONE_PAINT_TOWER : {
                                    targetSecondary = paintTower[2][0];
                                    break;
                                }
                                default : {
                                    targetSecondary = moneyTower[2][0];
                                    break;
                                }
                            }
                            if ((mi.getPaint() == PaintType.EMPTY) || (isSecondary != targetSecondary)) {
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
        d = rc.getLocation().distanceSquaredTo(tmp);
        if (d < bestDist) {
            if (rc.canSenseLocation(tmp)) {
                MapInfo mi = rc.senseMapInfo(tmp);
                switch (mi.getPaint()) {
                    case ENEMY_SECONDARY, ENEMY_PRIMARY -> {
                        if (rc.getType() == UnitType.MOPPER) {
                            bestDist = d;
                            goal = tmp;
                        }
                        break;
                    }
                    default -> {
                        if (rc.getType() == UnitType.SOLDIER) {
                            boolean isSecondary = (mi.getPaint() == PaintType.ALLY_SECONDARY);
                            boolean targetSecondary = false;
                            switch (t) {
                                case LEVEL_ONE_DEFENSE_TOWER : {
                                    targetSecondary = defenseTower[1][4];
                                    break;
                                }
                                case LEVEL_ONE_PAINT_TOWER : {
                                    targetSecondary = paintTower[1][4];
                                    break;
                                }
                                default : {
                                    targetSecondary = moneyTower[1][4];
                                    break;
                                }
                            }
                            if ((mi.getPaint() == PaintType.EMPTY) || (isSecondary != targetSecondary)) {
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
        d = rc.getLocation().distanceSquaredTo(tmp);
        if (d < bestDist) {
            if (rc.canSenseLocation(tmp)) {
                MapInfo mi = rc.senseMapInfo(tmp);
                switch (mi.getPaint()) {
                    case ENEMY_SECONDARY, ENEMY_PRIMARY -> {
                        if (rc.getType() == UnitType.MOPPER) {
                            bestDist = d;
                            goal = tmp;
                        }
                        break;
                    }
                    default -> {
                        if (rc.getType() == UnitType.SOLDIER) {
                            boolean isSecondary = (mi.getPaint() == PaintType.ALLY_SECONDARY);
                            boolean targetSecondary = false;
                            switch (t) {
                                case LEVEL_ONE_DEFENSE_TOWER : {
                                    targetSecondary = defenseTower[1][3];
                                    break;
                                }
                                case LEVEL_ONE_PAINT_TOWER : {
                                    targetSecondary = paintTower[1][3];
                                    break;
                                }
                                default : {
                                    targetSecondary = moneyTower[1][3];
                                    break;
                                }
                            }
                            if ((mi.getPaint() == PaintType.EMPTY) || (isSecondary != targetSecondary)) {
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
        d = rc.getLocation().distanceSquaredTo(tmp);
        if (d < bestDist) {
            if (rc.canSenseLocation(tmp)) {
                MapInfo mi = rc.senseMapInfo(tmp);
                switch (mi.getPaint()) {
                    case ENEMY_SECONDARY, ENEMY_PRIMARY -> {
                        if (rc.getType() == UnitType.MOPPER) {
                            bestDist = d;
                            goal = tmp;
                        }
                        break;
                    }
                    default -> {
                        if (rc.getType() == UnitType.SOLDIER) {
                            boolean isSecondary = (mi.getPaint() == PaintType.ALLY_SECONDARY);
                            boolean targetSecondary = false;
                            switch (t) {
                                case LEVEL_ONE_DEFENSE_TOWER : {
                                    targetSecondary = defenseTower[1][2];
                                    break;
                                }
                                case LEVEL_ONE_PAINT_TOWER : {
                                    targetSecondary = paintTower[1][2];
                                    break;
                                }
                                default : {
                                    targetSecondary = moneyTower[1][2];
                                    break;
                                }
                            }
                            if ((mi.getPaint() == PaintType.EMPTY) || (isSecondary != targetSecondary)) {
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
        d = rc.getLocation().distanceSquaredTo(tmp);
        if (d < bestDist) {
            if (rc.canSenseLocation(tmp)) {
                MapInfo mi = rc.senseMapInfo(tmp);
                switch (mi.getPaint()) {
                    case ENEMY_SECONDARY, ENEMY_PRIMARY -> {
                        if (rc.getType() == UnitType.MOPPER) {
                            bestDist = d;
                            goal = tmp;
                        }
                        break;
                    }
                    default -> {
                        if (rc.getType() == UnitType.SOLDIER) {
                            boolean isSecondary = (mi.getPaint() == PaintType.ALLY_SECONDARY);
                            boolean targetSecondary = false;
                            switch (t) {
                                case LEVEL_ONE_DEFENSE_TOWER : {
                                    targetSecondary = defenseTower[1][1];
                                    break;
                                }
                                case LEVEL_ONE_PAINT_TOWER : {
                                    targetSecondary = paintTower[1][1];
                                    break;
                                }
                                default : {
                                    targetSecondary = moneyTower[1][1];
                                    break;
                                }
                            }
                            if ((mi.getPaint() == PaintType.EMPTY) || (isSecondary != targetSecondary)) {
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
        d = rc.getLocation().distanceSquaredTo(tmp);
        if (d < bestDist) {
            if (rc.canSenseLocation(tmp)) {
                MapInfo mi = rc.senseMapInfo(tmp);
                switch (mi.getPaint()) {
                    case ENEMY_SECONDARY, ENEMY_PRIMARY -> {
                        if (rc.getType() == UnitType.MOPPER) {
                            bestDist = d;
                            goal = tmp;
                        }
                        break;
                    }
                    default -> {
                        if (rc.getType() == UnitType.SOLDIER) {
                            boolean isSecondary = (mi.getPaint() == PaintType.ALLY_SECONDARY);
                            boolean targetSecondary = false;
                            switch (t) {
                                case LEVEL_ONE_DEFENSE_TOWER : {
                                    targetSecondary = defenseTower[1][0];
                                    break;
                                }
                                case LEVEL_ONE_PAINT_TOWER : {
                                    targetSecondary = paintTower[1][0];
                                    break;
                                }
                                default : {
                                    targetSecondary = moneyTower[1][0];
                                    break;
                                }
                            }
                            if ((mi.getPaint() == PaintType.EMPTY) || (isSecondary != targetSecondary)) {
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
        d = rc.getLocation().distanceSquaredTo(tmp);
        if (d < bestDist) {
            if (rc.canSenseLocation(tmp)) {
                MapInfo mi = rc.senseMapInfo(tmp);
                switch (mi.getPaint()) {
                    case ENEMY_SECONDARY, ENEMY_PRIMARY -> {
                        if (rc.getType() == UnitType.MOPPER) {
                            bestDist = d;
                            goal = tmp;
                        }
                        break;
                    }
                    default -> {
                        if (rc.getType() == UnitType.SOLDIER) {
                            boolean isSecondary = (mi.getPaint() == PaintType.ALLY_SECONDARY);
                            boolean targetSecondary = false;
                            switch (t) {
                                case LEVEL_ONE_DEFENSE_TOWER : {
                                    targetSecondary = defenseTower[0][4];
                                    break;
                                }
                                case LEVEL_ONE_PAINT_TOWER : {
                                    targetSecondary = paintTower[0][4];
                                    break;
                                }
                                default : {
                                    targetSecondary = moneyTower[0][4];
                                    break;
                                }
                            }
                            if ((mi.getPaint() == PaintType.EMPTY) || (isSecondary != targetSecondary)) {
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
        d = rc.getLocation().distanceSquaredTo(tmp);
        if (d < bestDist) {
            if (rc.canSenseLocation(tmp)) {
                MapInfo mi = rc.senseMapInfo(tmp);
                switch (mi.getPaint()) {
                    case ENEMY_SECONDARY, ENEMY_PRIMARY -> {
                        if (rc.getType() == UnitType.MOPPER) {
                            bestDist = d;
                            goal = tmp;
                        }
                        break;
                    }
                    default -> {
                        if (rc.getType() == UnitType.SOLDIER) {
                            boolean isSecondary = (mi.getPaint() == PaintType.ALLY_SECONDARY);
                            boolean targetSecondary = false;
                            switch (t) {
                                case LEVEL_ONE_DEFENSE_TOWER : {
                                    targetSecondary = defenseTower[0][3];
                                    break;
                                }
                                case LEVEL_ONE_PAINT_TOWER : {
                                    targetSecondary = paintTower[0][3];
                                    break;
                                }
                                default : {
                                    targetSecondary = moneyTower[0][3];
                                    break;
                                }
                            }
                            if ((mi.getPaint() == PaintType.EMPTY) || (isSecondary != targetSecondary)) {
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
        d = rc.getLocation().distanceSquaredTo(tmp);
        if (d < bestDist) {
            if (rc.canSenseLocation(tmp)) {
                MapInfo mi = rc.senseMapInfo(tmp);
                switch (mi.getPaint()) {
                    case ENEMY_SECONDARY, ENEMY_PRIMARY -> {
                        if (rc.getType() == UnitType.MOPPER) {
                            bestDist = d;
                            goal = tmp;
                        }
                        break;
                    }
                    default -> {
                        if (rc.getType() == UnitType.SOLDIER) {
                            boolean isSecondary = (mi.getPaint() == PaintType.ALLY_SECONDARY);
                            boolean targetSecondary = false;
                            switch (t) {
                                case LEVEL_ONE_DEFENSE_TOWER : {
                                    targetSecondary = defenseTower[0][2];
                                    break;
                                }
                                case LEVEL_ONE_PAINT_TOWER : {
                                    targetSecondary = paintTower[0][2];
                                    break;
                                }
                                default : {
                                    targetSecondary = moneyTower[0][2];
                                    break;
                                }
                            }
                            if ((mi.getPaint() == PaintType.EMPTY) || (isSecondary != targetSecondary)) {
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
        d = rc.getLocation().distanceSquaredTo(tmp);
        if (d < bestDist) {
            if (rc.canSenseLocation(tmp)) {
                MapInfo mi = rc.senseMapInfo(tmp);
                switch (mi.getPaint()) {
                    case ENEMY_SECONDARY, ENEMY_PRIMARY -> {
                        if (rc.getType() == UnitType.MOPPER) {
                            bestDist = d;
                            goal = tmp;
                        }
                        break;
                    }
                    default -> {
                        if (rc.getType() == UnitType.SOLDIER) {
                            boolean isSecondary = (mi.getPaint() == PaintType.ALLY_SECONDARY);
                            boolean targetSecondary = false;
                            switch (t) {
                                case LEVEL_ONE_DEFENSE_TOWER : {
                                    targetSecondary = defenseTower[0][1];
                                    break;
                                }
                                case LEVEL_ONE_PAINT_TOWER : {
                                    targetSecondary = paintTower[0][1];
                                    break;
                                }
                                default : {
                                    targetSecondary = moneyTower[0][1];
                                    break;
                                }
                            }
                            if ((mi.getPaint() == PaintType.EMPTY) || (isSecondary != targetSecondary)) {
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
        d = rc.getLocation().distanceSquaredTo(tmp);
        if (d < bestDist) {
            if (rc.canSenseLocation(tmp)) {
                MapInfo mi = rc.senseMapInfo(tmp);
                switch (mi.getPaint()) {
                    case ENEMY_SECONDARY, ENEMY_PRIMARY -> {
                        if (rc.getType() == UnitType.MOPPER) {
                            bestDist = d;
                            goal = tmp;
                        }
                        break;
                    }
                    default -> {
                        if (rc.getType() == UnitType.SOLDIER) {
                            boolean isSecondary = (mi.getPaint() == PaintType.ALLY_SECONDARY);
                            boolean targetSecondary = false;
                            switch (t) {
                                case LEVEL_ONE_DEFENSE_TOWER : {
                                    targetSecondary = defenseTower[0][0];
                                    break;
                                }
                                case LEVEL_ONE_PAINT_TOWER : {
                                    targetSecondary = paintTower[0][0];
                                    break;
                                }
                                default : {
                                    targetSecondary = moneyTower[0][0];
                                    break;
                                }
                            }
                            if ((mi.getPaint() == PaintType.EMPTY) || (isSecondary != targetSecondary)) {
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
            if (rc.canAttack(goal)) {
                rc.setIndicatorDot(goal, 255, 0, 0);
                rc.attack(goal, secondCol);
            }
            if (rc.getType() == UnitType.MOPPER) Mopper.handleMopTarget(goal);
            else Pathing.pathTo(goal);
        }
        else {
            if (rc.canCompleteTowerPattern(UnitType.LEVEL_ONE_PAINT_TOWER, buildTower)) {
                rc.completeTowerPattern(UnitType.LEVEL_ONE_PAINT_TOWER, buildTower);
            }
            if (rc.canCompleteTowerPattern(UnitType.LEVEL_ONE_MONEY_TOWER, buildTower)) {
                rc.completeTowerPattern(UnitType.LEVEL_ONE_MONEY_TOWER, buildTower);
            }
            Pathing.pathTo(buildTower);
            if (rc.getLocation().distanceSquaredTo(buildTower) <= 2) {
                int saw = 0;
                for (int j = 8; --j >= 0;) {
                    RobotInfo r = rc.senseRobotAtLocation(new MapLocation(buildTower.x + dx[j], buildTower.y + dy[j]));
                    if (r != null && rc.getType() == r.getType()) {
                        if (r.getLocation() == rc.getLocation()) break;
                        saw++;
                        if (saw > 1) {
                            last[buildTower.x][buildTower.y] = rc.getRoundNum() + 10;
                            break;
                        }
                    }
                }
            }
            else Pathing.pathTo(buildTower);
        }
    }

}