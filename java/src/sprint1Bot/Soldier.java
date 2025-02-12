

package sprint1Bot;
import battlecode.common.*;
import java.util.ArrayList;
import java.util.Collections;

public class Soldier {
    public static RobotController rc;
    public static boolean homeHasPaint = false;
    public static MapLocation buildTower = null;
    public static MapLocation myloc;
    public static int paintCapacity = UnitType.SOLDIER.paintCapacity;
    public static int myPaint;
    public static MapLocation exploreTarget;
    public static MapInfo[] near;
    public static MapLocation ruinLoc;
    public static MapLocation markedResource = null;
    public static boolean[][] resourcePat = null;
    public static boolean shouldGoHome = false;
    public static boolean moved = false;

    public static int evenChunkDx[] = {0, 4, -4, 1, 1};
    public static int evenChunkDy[] = {0, 0, 0, 3, -3};
    public static int oddChunkDx[] = {0, 4, -4, -1, -1};
    public static int oddChunkDy[] = {0, 0, 0, 3, -3};
    public static MapLocation chunkGoal = null;

    public static void init(RobotController rc) {
        Soldier.rc = rc;
        resourcePat = rc.getResourcePattern();
    }

    public static MapLocation getLowerCenter(MapLocation m) {
        int a = (m.y - 2) / 3;
        int cy = 3 * a + 2, cx;
        if (a % 2 == 0) {
            int b = (m.x - 2) / 4;
            cx = 2 + b * 4;
        }
        else {
            int b = (m.x - 3) / 4;
            cx = 3 + b * 4;
        }
        if (m.x - cx > 2) cx += 4;
        return new MapLocation(cx, cy);
    }

    public static boolean useOdd(MapLocation m) {
        return (((m.y - 2) / 3) & 1) == 1;
    }

    public static boolean shouldUseSecond(MapLocation m) {
        MapLocation c = getLowerCenter(m);
        int dx = m.x - c.x, dy = m.y - c.y;
        if(dx == 0 && dy == 0) return false;
        else return ((Math.abs(dx) & 1) == (Math.abs(dy) & 1));
    }

    public static boolean okToTile(MapLocation m) throws GameActionException {
        if (rc.getNumberTowers() == 25) return true;
        MapInfo mCur = rc.senseMapInfo(m);
        boolean b = shouldUseSecond(m);
        if (mCur.getPaint().isAlly()) {
            if (b == (mCur.getPaint() == PaintType.ALLY_SECONDARY)) {
                return false;
            }
        }
        for (int i = 3; --i >= -2; ){
            for (int j = 3; --j >= -2; ){
                if (i == 0 && j == 0) continue;
                MapLocation tmp = new MapLocation(m.x + i, m.y + j);
                if (rc.canSenseLocation(tmp)) {
                    MapInfo mi = rc.senseMapInfo(tmp);
                    if (mi.hasRuin()) {
                        RobotInfo r = rc.senseRobotAtLocation(tmp);
                        if (r == null) return false;
                    }
                }
            }
        }
        return true;
    }

    public static void checkMoneyPatterns() throws GameActionException {
        MapLocation h;
        MapLocation g = getLowerCenter(rc.getLocation());
        for (int i = 5; --i >= 0;) {
            if(useOdd(g)) h = new MapLocation(g.x + oddChunkDx[i], g.y + oddChunkDy[i]);
            else h = new MapLocation(g.x + evenChunkDx[i], g.y + evenChunkDy[i]); 
            if (rc.canCompleteResourcePattern(h)) {
                rc.completeResourcePattern(h);
                if (rc.canMark(h)) {
                    rc.mark(h, false);
                }
            }
        }
    }

    public static boolean canChangeColor(MapInfo mi) throws GameActionException {
        return (mi.getPaint().isAlly() || mi.getPaint() == PaintType.EMPTY);
    }

    public static boolean canChangeColor(MapLocation m) throws GameActionException {
        if (!rc.canSenseLocation(m)) return false;
        MapInfo mi = rc.senseMapInfo(m);
        return canChangeColor(mi);
    }

    public static boolean visited(MapLocation m) throws GameActionException {
       switch (m.y) {
            case 0 -> {
                return ((TileLoader.visited0 >> m.x) & 1) == 1;
            }
            case 1 -> {
                return ((TileLoader.visited1 >> m.x) & 1) == 1;
            }
            case 2 -> {
                return ((TileLoader.visited2 >> m.x) & 1) == 1;
            }
            case 3 -> {
                return ((TileLoader.visited3 >> m.x) & 1) == 1;
            }
            case 4 -> {
                return ((TileLoader.visited4 >> m.x) & 1) == 1;
            }
            case 5 -> {
                return ((TileLoader.visited5 >> m.x) & 1) == 1;
            }
            case 6 -> {
                return ((TileLoader.visited6 >> m.x) & 1) == 1;
            }
            case 7 -> {
                return ((TileLoader.visited7 >> m.x) & 1) == 1;
            }
            case 8 -> {
                return ((TileLoader.visited8 >> m.x) & 1) == 1;
            }
            case 9 -> {
                return ((TileLoader.visited9 >> m.x) & 1) == 1;
            }
            case 10 -> {
                return ((TileLoader.visited10 >> m.x) & 1) == 1;
            }
            case 11 -> {
                return ((TileLoader.visited11 >> m.x) & 1) == 1;
            }
            case 12 -> {
                return ((TileLoader.visited12 >> m.x) & 1) == 1;
            }
            case 13 -> {
                return ((TileLoader.visited13 >> m.x) & 1) == 1;
            }
            case 14 -> {
                return ((TileLoader.visited14 >> m.x) & 1) == 1;
            }
            case 15 -> {
                return ((TileLoader.visited15 >> m.x) & 1) == 1;
            }
            case 16 -> {
                return ((TileLoader.visited16 >> m.x) & 1) == 1;
            }
            case 17 -> {
                return ((TileLoader.visited17 >> m.x) & 1) == 1;
            }
            case 18 -> {
                return ((TileLoader.visited18 >> m.x) & 1) == 1;
            }
            case 19 -> {
                return ((TileLoader.visited19 >> m.x) & 1) == 1;
            }
            case 20 -> {
                return ((TileLoader.visited20 >> m.x) & 1) == 1;
            }
            case 21 -> {
                return ((TileLoader.visited21 >> m.x) & 1) == 1;
            }
            case 22 -> {
                return ((TileLoader.visited22 >> m.x) & 1) == 1;
            }
            case 23 -> {
                return ((TileLoader.visited23 >> m.x) & 1) == 1;
            }
            case 24 -> {
                return ((TileLoader.visited24 >> m.x) & 1) == 1;
            }
            case 25 -> {
                return ((TileLoader.visited25 >> m.x) & 1) == 1;
            }
            case 26 -> {
                return ((TileLoader.visited26 >> m.x) & 1) == 1;
            }
            case 27 -> {
                return ((TileLoader.visited27 >> m.x) & 1) == 1;
            }
            case 28 -> {
                return ((TileLoader.visited28 >> m.x) & 1) == 1;
            }
            case 29 -> {
                return ((TileLoader.visited29 >> m.x) & 1) == 1;
            }
            case 30 -> {
                return ((TileLoader.visited30 >> m.x) & 1) == 1;
            }
            case 31 -> {
                return ((TileLoader.visited31 >> m.x) & 1) == 1;
            }
            case 32 -> {
                return ((TileLoader.visited32 >> m.x) & 1) == 1;
            }
            case 33 -> {
                return ((TileLoader.visited33 >> m.x) & 1) == 1;
            }
            case 34 -> {
                return ((TileLoader.visited34 >> m.x) & 1) == 1;
            }
            case 35 -> {
                return ((TileLoader.visited35 >> m.x) & 1) == 1;
            }
            case 36 -> {
                return ((TileLoader.visited36 >> m.x) & 1) == 1;
            }
            case 37 -> {
                return ((TileLoader.visited37 >> m.x) & 1) == 1;
            }
            case 38 -> {
                return ((TileLoader.visited38 >> m.x) & 1) == 1;
            }
            case 39 -> {
                return ((TileLoader.visited39 >> m.x) & 1) == 1;
            }
            case 40 -> {
                return ((TileLoader.visited40 >> m.x) & 1) == 1;
            }
            case 41 -> {
                return ((TileLoader.visited41 >> m.x) & 1) == 1;
            }
            case 42 -> {
                return ((TileLoader.visited42 >> m.x) & 1) == 1;
            }
            case 43 -> {
                return ((TileLoader.visited43 >> m.x) & 1) == 1;
            }
            case 44 -> {
                return ((TileLoader.visited44 >> m.x) & 1) == 1;
            }
            case 45 -> {
                return ((TileLoader.visited45 >> m.x) & 1) == 1;
            }
            case 46 -> {
                return ((TileLoader.visited46 >> m.x) & 1) == 1;
            }
            case 47 -> {
                return ((TileLoader.visited47 >> m.x) & 1) == 1;
            }
            case 48 -> {
                return ((TileLoader.visited48 >> m.x) & 1) == 1;
            }
            case 49 -> {
                return ((TileLoader.visited49 >> m.x) & 1) == 1;
            }
            case 50 -> {
                return ((TileLoader.visited50 >> m.x) & 1) == 1;
            }
            case 51 -> {
                return ((TileLoader.visited51 >> m.x) & 1) == 1;
            }
            case 52 -> {
                return ((TileLoader.visited52 >> m.x) & 1) == 1;
            }
            case 53 -> {
                return ((TileLoader.visited53 >> m.x) & 1) == 1;
            }
            case 54 -> {
                return ((TileLoader.visited54 >> m.x) & 1) == 1;
            }
            case 55 -> {
                return ((TileLoader.visited55 >> m.x) & 1) == 1;
            }
            case 56 -> {
                return ((TileLoader.visited56 >> m.x) & 1) == 1;
            }
            case 57 -> {
                return ((TileLoader.visited57 >> m.x) & 1) == 1;
            }
            case 58 -> {
                return ((TileLoader.visited58 >> m.x) & 1) == 1;
            }
            case 59 -> {
                return ((TileLoader.visited59 >> m.x) & 1) == 1;
            }
            } 
        return false;
    }

    public static boolean shouldVisit(MapLocation m) throws GameActionException {
        if (!rc.canSenseLocation(m)) return false;
        boolean ok = false;
        for (int i = 2; --i >= -1;) {
            for (int j = 2; --j >= -1;) {
                MapLocation cur = new MapLocation(m.x + i, m.y + j);
                if (rc.canSenseLocation(cur)) {
                    MapInfo mi = rc.senseMapInfo(cur);
                    if (mi.getMark() != PaintType.EMPTY) return false;
                    if (!mi.isPassable()) {
                        if (rc.canMark(m)) {
                            rc.mark(m, true);
                        }
                        return false;
                    }
                    if (mi.getPaint() == PaintType.EMPTY) ok = true;
                    else if (!mi.getPaint().isAlly()) return false;
                    boolean b = shouldUseSecond(cur);
                    if (b != (mi.getPaint() == PaintType.ALLY_SECONDARY)) {
                        ok = true;
                    }
                    if (cur == rc.getLocation()) continue;
                    RobotInfo r = rc.senseRobotAtLocation(cur);
                    if (r != null && r.getTeam() == rc.getTeam() && r.getType() == UnitType.SOLDIER) return false;
                }
            }
        }
        return (!visited(m) && ok); 
    }

    public static void moneyPattern() throws GameActionException {
        moved = false;
        if (markedResource != null) return;
        if (rc.getPaint() < 50) return;

        if (chunkGoal == null) {
            int dist = 1000000000;
            MapLocation g = getLowerCenter(rc.getLocation());
            MapLocation h;
            ArrayList<Integer> p = new ArrayList<>();
            for (int i = 0; i <= 4; i++) p.add(i);
            Collections.shuffle(p);
            for (int i = 5; --i >= 0;) {
                if (useOdd(g)) h = new MapLocation(g.x + oddChunkDx[p.get(i)], g.y + oddChunkDy[p.get(i)]);
                else h = new MapLocation(g.x + evenChunkDx[p.get(i)], g.y + evenChunkDy[p.get(i)]);
                if (shouldVisit(h)) {
                    int d = rc.getLocation().distanceSquaredTo(h);
                    if (d < dist) {
                        dist = d;
                        chunkGoal = h;
                    }
                }
            }
        }

        if (chunkGoal != null){
            rc.setIndicatorString("going to chunk " + chunkGoal);
            Pathing.pathTo(chunkGoal);
            moved = true;
        }
        else return;
        
        /*
        if (chunkGoal != null) {
            if (!rc.getLocation().equals(chunkGoal)) {
                Pathing.pathTo(chunkGoal);
            }
        }
        else return;
        */

        //MapLocation c = getLowerCenter(rc.getLocation());
        //if (!c.equals(rc.getLocation())) return;

        boolean bad = false;
        boolean no = false;
        for (int i = 3; --i >= -2; ){
            for (int j = 3; --j >= -2; ){
                MapLocation tmp = new MapLocation(chunkGoal.x + i, chunkGoal.y + j);
                if (rc.canSenseLocation(tmp)) {
                    MapInfo mi = rc.senseMapInfo(tmp);
                    if (mi.getMark() == PaintType.ALLY_SECONDARY) {
                        bad = true;
                    }
                    if (!mi.isPassable()) {
                        bad = true;
                    }
                    RobotInfo r = rc.senseRobotAtLocation(tmp);
                    if (r != null && Globals.isTower(r.getType())) {
                        bad = true;
                    }
                }
                else {
                    bad = true;
                    if(rc.onTheMap(tmp)) no = true;
                }
            }
        }
        if (bad && !no) {
            if (rc.canMark(chunkGoal)) {
                rc.mark(chunkGoal, true);
                chunkGoal = null;
            }
            else {
                Pathing.pathTo(chunkGoal);
                rc.setIndicatorString("going to chunk2 " + chunkGoal);
                moved = true;
            }
            return;
        }
        if (!bad) {
            if (rc.canMark(chunkGoal)) {
                rc.mark(chunkGoal, false);
                markedResource = chunkGoal;
                chunkGoal = null;
            }
        }
    }

    public static void makeResourcePatch() throws GameActionException {
        Pathing.pathTo(markedResource);
        MapLocation goal = null;
        int bestDist = 1000000000;
        boolean secondCol = false;
        for (int i = 3; --i >= -2; ){
            for (int j = 3; --j >= -2; ){
                if (i == 0 && j == 0) continue;
                MapLocation tmp = new MapLocation(markedResource.x + i, markedResource.y + j);
                if (rc.canSenseLocation(tmp)) {
                    MapInfo mi = rc.senseMapInfo(tmp);
                    if (canChangeColor(mi)) {
                        boolean b = shouldUseSecond(tmp);
                        if (mi.getPaint().isAlly()) {
                            if (b == (mi.getPaint() == PaintType.ALLY_SECONDARY)) {
                                continue;
                            }
                        }
                        int d = rc.getLocation().distanceSquaredTo(tmp);
                        if (d < bestDist) {
                            bestDist = d;
                            goal = tmp;
                            secondCol = b;
                        }
                    }
                }
            }
        }
        if (goal != null) {
            if (rc.canAttack(goal)) {
                rc.attack(goal, secondCol);
            }
            if (rc.canCompleteResourcePattern(markedResource)) {
                rc.completeResourcePattern(markedResource);
                markedResource = null;
            }
        }
        else {
            if (rc.canCompleteResourcePattern(markedResource)) {
                rc.completeResourcePattern(markedResource);
            }
            markedResource = null;
        }
    }

    public static boolean seeIncompleteRuin(MapLocation ruin) throws GameActionException {
        MapLocation tmp;
        UnitType t = Globals.getTowerToBuild();
        boolean[][] pattern = rc.getTowerPattern(t);
        RobotInfo tower = rc.senseRobotAtLocation(ruin);
        boolean needsChanges = (tower == null);
        // This should never trigger. Just here for completeness.
        if (tower != null && tower.team != rc.getTeam()) return false;
        
        
        
        tmp = new MapLocation(ruin.x + 2, ruin.y + 2);
        if (rc.canSenseLocation(tmp)) {
            MapInfo mi = rc.senseMapInfo(tmp);
            switch (mi.getPaint()) {
                case ENEMY_SECONDARY, ENEMY_PRIMARY: return false;
                default: {
                    boolean isSecondary = (mi.getPaint() == PaintType.ALLY_SECONDARY);
                    boolean targetSecondary = pattern[4][4];
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
                    boolean targetSecondary = pattern[4][3];
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
                    boolean targetSecondary = pattern[4][2];
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
                    boolean targetSecondary = pattern[4][1];
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
                    boolean targetSecondary = pattern[4][0];
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
                    boolean targetSecondary = pattern[3][4];
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
                    boolean targetSecondary = pattern[3][3];
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
                    boolean targetSecondary = pattern[3][2];
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
                    boolean targetSecondary = pattern[3][1];
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
                    boolean targetSecondary = pattern[3][0];
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
                    boolean targetSecondary = pattern[2][4];
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
                    boolean targetSecondary = pattern[2][3];
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
                    boolean targetSecondary = pattern[2][1];
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
                    boolean targetSecondary = pattern[2][0];
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
                    boolean targetSecondary = pattern[1][4];
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
                    boolean targetSecondary = pattern[1][3];
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
                    boolean targetSecondary = pattern[1][2];
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
                    boolean targetSecondary = pattern[1][1];
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
                    boolean targetSecondary = pattern[1][0];
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
                    boolean targetSecondary = pattern[0][4];
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
                    boolean targetSecondary = pattern[0][3];
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
                    boolean targetSecondary = pattern[0][2];
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
                    boolean targetSecondary = pattern[0][1];
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
                    boolean targetSecondary = pattern[0][0];
                    if ((mi.getPaint() == PaintType.EMPTY) || (isSecondary != targetSecondary)) {
                        needsChanges = true;
                    }
                }
            }
        }
        
        
        
        return needsChanges;
    }


    public static void run() throws GameActionException {
        initTurn();
        runTurn();
        postTurn();
    }

    public static void initTurn() throws GameActionException {
        near = rc.senseNearbyMapInfos();
        myloc = rc.getLocation();
        myPaint = rc.getPaint();

        RefuelManager.setHome();
        boolean lowHealth = (myPaint <= (paintCapacity >> 2));
        if (lowHealth != shouldGoHome) {
            shouldGoHome = lowHealth;
            RefuelManager.reset();
        }
    }

    public static boolean checkNearby(MapLocation loc) throws GameActionException {
        MapLocation tmp;
        
        
        
        tmp = new MapLocation(loc.x + 2, loc.y + 2);
        if (rc.canSenseLocation(tmp)) {
            MapInfo mi = rc.senseMapInfo(tmp);
            boolean b = shouldUseSecond(tmp);
            if (mi.getPaint() == PaintType.EMPTY || (mi.getPaint().isAlly() && b != (mi.getPaint() == PaintType.ALLY_SECONDARY))) {
                if (rc.canAttack(tmp)) {
                    rc.attack(tmp, b);
                    return true;
                }
            }
        }
        
        
        
        tmp = new MapLocation(loc.x + 2, loc.y + 1);
        if (rc.canSenseLocation(tmp)) {
            MapInfo mi = rc.senseMapInfo(tmp);
            boolean b = shouldUseSecond(tmp);
            if (mi.getPaint() == PaintType.EMPTY || (mi.getPaint().isAlly() && b != (mi.getPaint() == PaintType.ALLY_SECONDARY))) {
                if (rc.canAttack(tmp)) {
                    rc.attack(tmp, b);
                    return true;
                }
            }
        }
        
        
        
        tmp = new MapLocation(loc.x + 2, loc.y + 0);
        if (rc.canSenseLocation(tmp)) {
            MapInfo mi = rc.senseMapInfo(tmp);
            boolean b = shouldUseSecond(tmp);
            if (mi.getPaint() == PaintType.EMPTY || (mi.getPaint().isAlly() && b != (mi.getPaint() == PaintType.ALLY_SECONDARY))) {
                if (rc.canAttack(tmp)) {
                    rc.attack(tmp, b);
                    return true;
                }
            }
        }
        
        
        
        tmp = new MapLocation(loc.x + 2, loc.y + -1);
        if (rc.canSenseLocation(tmp)) {
            MapInfo mi = rc.senseMapInfo(tmp);
            boolean b = shouldUseSecond(tmp);
            if (mi.getPaint() == PaintType.EMPTY || (mi.getPaint().isAlly() && b != (mi.getPaint() == PaintType.ALLY_SECONDARY))) {
                if (rc.canAttack(tmp)) {
                    rc.attack(tmp, b);
                    return true;
                }
            }
        }
        
        
        
        tmp = new MapLocation(loc.x + 2, loc.y + -2);
        if (rc.canSenseLocation(tmp)) {
            MapInfo mi = rc.senseMapInfo(tmp);
            boolean b = shouldUseSecond(tmp);
            if (mi.getPaint() == PaintType.EMPTY || (mi.getPaint().isAlly() && b != (mi.getPaint() == PaintType.ALLY_SECONDARY))) {
                if (rc.canAttack(tmp)) {
                    rc.attack(tmp, b);
                    return true;
                }
            }
        }
        
        
        
        
        
        tmp = new MapLocation(loc.x + 1, loc.y + 2);
        if (rc.canSenseLocation(tmp)) {
            MapInfo mi = rc.senseMapInfo(tmp);
            boolean b = shouldUseSecond(tmp);
            if (mi.getPaint() == PaintType.EMPTY || (mi.getPaint().isAlly() && b != (mi.getPaint() == PaintType.ALLY_SECONDARY))) {
                if (rc.canAttack(tmp)) {
                    rc.attack(tmp, b);
                    return true;
                }
            }
        }
        
        
        
        tmp = new MapLocation(loc.x + 1, loc.y + 1);
        if (rc.canSenseLocation(tmp)) {
            MapInfo mi = rc.senseMapInfo(tmp);
            boolean b = shouldUseSecond(tmp);
            if (mi.getPaint() == PaintType.EMPTY || (mi.getPaint().isAlly() && b != (mi.getPaint() == PaintType.ALLY_SECONDARY))) {
                if (rc.canAttack(tmp)) {
                    rc.attack(tmp, b);
                    return true;
                }
            }
        }
        
        
        
        tmp = new MapLocation(loc.x + 1, loc.y + 0);
        if (rc.canSenseLocation(tmp)) {
            MapInfo mi = rc.senseMapInfo(tmp);
            boolean b = shouldUseSecond(tmp);
            if (mi.getPaint() == PaintType.EMPTY || (mi.getPaint().isAlly() && b != (mi.getPaint() == PaintType.ALLY_SECONDARY))) {
                if (rc.canAttack(tmp)) {
                    rc.attack(tmp, b);
                    return true;
                }
            }
        }
        
        
        
        tmp = new MapLocation(loc.x + 1, loc.y + -1);
        if (rc.canSenseLocation(tmp)) {
            MapInfo mi = rc.senseMapInfo(tmp);
            boolean b = shouldUseSecond(tmp);
            if (mi.getPaint() == PaintType.EMPTY || (mi.getPaint().isAlly() && b != (mi.getPaint() == PaintType.ALLY_SECONDARY))) {
                if (rc.canAttack(tmp)) {
                    rc.attack(tmp, b);
                    return true;
                }
            }
        }
        
        
        
        tmp = new MapLocation(loc.x + 1, loc.y + -2);
        if (rc.canSenseLocation(tmp)) {
            MapInfo mi = rc.senseMapInfo(tmp);
            boolean b = shouldUseSecond(tmp);
            if (mi.getPaint() == PaintType.EMPTY || (mi.getPaint().isAlly() && b != (mi.getPaint() == PaintType.ALLY_SECONDARY))) {
                if (rc.canAttack(tmp)) {
                    rc.attack(tmp, b);
                    return true;
                }
            }
        }
        
        
        
        
        
        tmp = new MapLocation(loc.x + 0, loc.y + 2);
        if (rc.canSenseLocation(tmp)) {
            MapInfo mi = rc.senseMapInfo(tmp);
            boolean b = shouldUseSecond(tmp);
            if (mi.getPaint() == PaintType.EMPTY || (mi.getPaint().isAlly() && b != (mi.getPaint() == PaintType.ALLY_SECONDARY))) {
                if (rc.canAttack(tmp)) {
                    rc.attack(tmp, b);
                    return true;
                }
            }
        }
        
        
        
        tmp = new MapLocation(loc.x + 0, loc.y + 1);
        if (rc.canSenseLocation(tmp)) {
            MapInfo mi = rc.senseMapInfo(tmp);
            boolean b = shouldUseSecond(tmp);
            if (mi.getPaint() == PaintType.EMPTY || (mi.getPaint().isAlly() && b != (mi.getPaint() == PaintType.ALLY_SECONDARY))) {
                if (rc.canAttack(tmp)) {
                    rc.attack(tmp, b);
                    return true;
                }
            }
        }
        
        
        
        
        
        tmp = new MapLocation(loc.x + 0, loc.y + -1);
        if (rc.canSenseLocation(tmp)) {
            MapInfo mi = rc.senseMapInfo(tmp);
            boolean b = shouldUseSecond(tmp);
            if (mi.getPaint() == PaintType.EMPTY || (mi.getPaint().isAlly() && b != (mi.getPaint() == PaintType.ALLY_SECONDARY))) {
                if (rc.canAttack(tmp)) {
                    rc.attack(tmp, b);
                    return true;
                }
            }
        }
        
        
        
        tmp = new MapLocation(loc.x + 0, loc.y + -2);
        if (rc.canSenseLocation(tmp)) {
            MapInfo mi = rc.senseMapInfo(tmp);
            boolean b = shouldUseSecond(tmp);
            if (mi.getPaint() == PaintType.EMPTY || (mi.getPaint().isAlly() && b != (mi.getPaint() == PaintType.ALLY_SECONDARY))) {
                if (rc.canAttack(tmp)) {
                    rc.attack(tmp, b);
                    return true;
                }
            }
        }
        
        
        
        
        
        tmp = new MapLocation(loc.x + -1, loc.y + 2);
        if (rc.canSenseLocation(tmp)) {
            MapInfo mi = rc.senseMapInfo(tmp);
            boolean b = shouldUseSecond(tmp);
            if (mi.getPaint() == PaintType.EMPTY || (mi.getPaint().isAlly() && b != (mi.getPaint() == PaintType.ALLY_SECONDARY))) {
                if (rc.canAttack(tmp)) {
                    rc.attack(tmp, b);
                    return true;
                }
            }
        }
        
        
        
        tmp = new MapLocation(loc.x + -1, loc.y + 1);
        if (rc.canSenseLocation(tmp)) {
            MapInfo mi = rc.senseMapInfo(tmp);
            boolean b = shouldUseSecond(tmp);
            if (mi.getPaint() == PaintType.EMPTY || (mi.getPaint().isAlly() && b != (mi.getPaint() == PaintType.ALLY_SECONDARY))) {
                if (rc.canAttack(tmp)) {
                    rc.attack(tmp, b);
                    return true;
                }
            }
        }
        
        
        
        tmp = new MapLocation(loc.x + -1, loc.y + 0);
        if (rc.canSenseLocation(tmp)) {
            MapInfo mi = rc.senseMapInfo(tmp);
            boolean b = shouldUseSecond(tmp);
            if (mi.getPaint() == PaintType.EMPTY || (mi.getPaint().isAlly() && b != (mi.getPaint() == PaintType.ALLY_SECONDARY))) {
                if (rc.canAttack(tmp)) {
                    rc.attack(tmp, b);
                    return true;
                }
            }
        }
        
        
        
        tmp = new MapLocation(loc.x + -1, loc.y + -1);
        if (rc.canSenseLocation(tmp)) {
            MapInfo mi = rc.senseMapInfo(tmp);
            boolean b = shouldUseSecond(tmp);
            if (mi.getPaint() == PaintType.EMPTY || (mi.getPaint().isAlly() && b != (mi.getPaint() == PaintType.ALLY_SECONDARY))) {
                if (rc.canAttack(tmp)) {
                    rc.attack(tmp, b);
                    return true;
                }
            }
        }
        
        
        
        tmp = new MapLocation(loc.x + -1, loc.y + -2);
        if (rc.canSenseLocation(tmp)) {
            MapInfo mi = rc.senseMapInfo(tmp);
            boolean b = shouldUseSecond(tmp);
            if (mi.getPaint() == PaintType.EMPTY || (mi.getPaint().isAlly() && b != (mi.getPaint() == PaintType.ALLY_SECONDARY))) {
                if (rc.canAttack(tmp)) {
                    rc.attack(tmp, b);
                    return true;
                }
            }
        }
        
        
        
        
        
        tmp = new MapLocation(loc.x + -2, loc.y + 2);
        if (rc.canSenseLocation(tmp)) {
            MapInfo mi = rc.senseMapInfo(tmp);
            boolean b = shouldUseSecond(tmp);
            if (mi.getPaint() == PaintType.EMPTY || (mi.getPaint().isAlly() && b != (mi.getPaint() == PaintType.ALLY_SECONDARY))) {
                if (rc.canAttack(tmp)) {
                    rc.attack(tmp, b);
                    return true;
                }
            }
        }
        
        
        
        tmp = new MapLocation(loc.x + -2, loc.y + 1);
        if (rc.canSenseLocation(tmp)) {
            MapInfo mi = rc.senseMapInfo(tmp);
            boolean b = shouldUseSecond(tmp);
            if (mi.getPaint() == PaintType.EMPTY || (mi.getPaint().isAlly() && b != (mi.getPaint() == PaintType.ALLY_SECONDARY))) {
                if (rc.canAttack(tmp)) {
                    rc.attack(tmp, b);
                    return true;
                }
            }
        }
        
        
        
        tmp = new MapLocation(loc.x + -2, loc.y + 0);
        if (rc.canSenseLocation(tmp)) {
            MapInfo mi = rc.senseMapInfo(tmp);
            boolean b = shouldUseSecond(tmp);
            if (mi.getPaint() == PaintType.EMPTY || (mi.getPaint().isAlly() && b != (mi.getPaint() == PaintType.ALLY_SECONDARY))) {
                if (rc.canAttack(tmp)) {
                    rc.attack(tmp, b);
                    return true;
                }
            }
        }
        
        
        
        tmp = new MapLocation(loc.x + -2, loc.y + -1);
        if (rc.canSenseLocation(tmp)) {
            MapInfo mi = rc.senseMapInfo(tmp);
            boolean b = shouldUseSecond(tmp);
            if (mi.getPaint() == PaintType.EMPTY || (mi.getPaint().isAlly() && b != (mi.getPaint() == PaintType.ALLY_SECONDARY))) {
                if (rc.canAttack(tmp)) {
                    rc.attack(tmp, b);
                    return true;
                }
            }
        }
        
        
        
        tmp = new MapLocation(loc.x + -2, loc.y + -2);
        if (rc.canSenseLocation(tmp)) {
            MapInfo mi = rc.senseMapInfo(tmp);
            boolean b = shouldUseSecond(tmp);
            if (mi.getPaint() == PaintType.EMPTY || (mi.getPaint().isAlly() && b != (mi.getPaint() == PaintType.ALLY_SECONDARY))) {
                if (rc.canAttack(tmp)) {
                    rc.attack(tmp, b);
                    return true;
                }
            }
        }
        
        
        
        return false;
    }

    public static void helpPattern(MapInfo[] near) throws GameActionException {
        for (int i = near.length; --i >= 0;) {
            if (near[i].getMark() == PaintType.ALLY_PRIMARY) {
                if (checkNearby(near[i].getMapLocation())) return;
            }
        }
    }
    
    public static void runTurn() throws GameActionException {
        if (shouldGoHome) {
            rc.setIndicatorString("Refueling");
            RefuelManager.refuel();
            return;
        } else if (Attack.shouldSoldierMicro()) {
            rc.setIndicatorString("Attacking");
            Attack.soldierAttackMicro();
            return;
        } else if (rc.getNumberTowers() < 25 && markedResource == null) {
            MapLocation buildTower = TowerBuild.getRuin(near);
            if (buildTower != null) {
                TowerBuild.makeTower(buildTower);
                return;
            }
        }

        moneyPattern();
        if (markedResource != null) {
            rc.setIndicatorString("Patching Resource");
            makeResourcePatch();
            return;
        }

        helpPattern(near);

        if (moved) return;

        rc.setIndicatorString("Exploring");
        Explore.explore(near);
    }

    public static void postTurn() throws GameActionException {

        // Lay paint where I am first.
        if (canChangeColor(myloc) && rc.canAttack(myloc) && okToTile(myloc) && rc.getPaint() >= 50){
            rc.attack(myloc, shouldUseSecond(myloc));
        }

        if (buildTower != null) {
            if (rc.canCompleteTowerPattern(UnitType.LEVEL_ONE_PAINT_TOWER, buildTower)) {
                rc.completeTowerPattern(UnitType.LEVEL_ONE_PAINT_TOWER, buildTower);
            }
            if (rc.canCompleteTowerPattern(UnitType.LEVEL_ONE_MONEY_TOWER, buildTower)) {
                rc.completeTowerPattern(UnitType.LEVEL_ONE_MONEY_TOWER, buildTower);
            }
        }
        checkMoneyPatterns();
    }
}