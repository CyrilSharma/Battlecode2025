

package moreMoppers;
import battlecode.common.*;

public class Splasher {
    public static RobotController rc;
    public static MapLocation buildTower = null;
    public static MapLocation myloc;
    public static int paintCapacity = UnitType.SOLDIER.paintCapacity;
    public static int myPaint;
    public static boolean shouldGoHome = false;

    public static void init(RobotController rc) {
        Splasher.rc = rc;
    }

    public static void run() throws GameActionException {
        initTurn();
        runTurn();
        postTurn();
    }

    public static void initTurn() throws GameActionException {
        myloc = rc.getLocation();
        myPaint = rc.getPaint();

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
        } else if (Attack.shouldSplasherMicro()) {
            rc.setIndicatorString("Attacking");
            Attack.splasherAttackMicro();
            return;
        } else {
            Explore.explore(null);
        }
    }

    public static void postTurn() throws GameActionException {
        doAttack();
    }

    public static void doAttack() throws GameActionException {
        rc.setIndicatorString("Preparing to attack, but didn't");
        if (!rc.isActionReady() || rc.getPaint() < (paintCapacity >> 2)) return;
        rc.setIndicatorString("Running attack code...");
        MapLocation myloc = rc.getLocation();
        int x = myloc.x, y = myloc.y;
        MapLocation bestLoc = null;
        int count = 0, bestCount = -1;

        
        
        MapLocation mloc00 = new MapLocation(x + -3, y + -3);
        PaintType mpaint00 = PaintType.ALLY_SECONDARY;
        if (rc.canSenseLocation(mloc00)) {
            MapInfo minfo00 = rc.senseMapInfo(mloc00);
            if (!minfo00.hasRuin() && !minfo00.isWall()) {
                mpaint00 = minfo00.getPaint();
            }
        }
        
        MapLocation mloc01 = new MapLocation(x + -3, y + -2);
        PaintType mpaint01 = PaintType.ALLY_SECONDARY;
        if (rc.canSenseLocation(mloc01)) {
            MapInfo minfo01 = rc.senseMapInfo(mloc01);
            if (!minfo01.hasRuin() && !minfo01.isWall()) {
                mpaint01 = minfo01.getPaint();
            }
        }
        
        MapLocation mloc02 = new MapLocation(x + -3, y + -1);
        PaintType mpaint02 = PaintType.ALLY_SECONDARY;
        if (rc.canSenseLocation(mloc02)) {
            MapInfo minfo02 = rc.senseMapInfo(mloc02);
            if (!minfo02.hasRuin() && !minfo02.isWall()) {
                mpaint02 = minfo02.getPaint();
            }
        }
        
        MapLocation mloc03 = new MapLocation(x + -3, y + 0);
        PaintType mpaint03 = PaintType.ALLY_SECONDARY;
        if (rc.canSenseLocation(mloc03)) {
            MapInfo minfo03 = rc.senseMapInfo(mloc03);
            if (!minfo03.hasRuin() && !minfo03.isWall()) {
                mpaint03 = minfo03.getPaint();
            }
        }
        
        MapLocation mloc04 = new MapLocation(x + -3, y + 1);
        PaintType mpaint04 = PaintType.ALLY_SECONDARY;
        if (rc.canSenseLocation(mloc04)) {
            MapInfo minfo04 = rc.senseMapInfo(mloc04);
            if (!minfo04.hasRuin() && !minfo04.isWall()) {
                mpaint04 = minfo04.getPaint();
            }
        }
        
        MapLocation mloc05 = new MapLocation(x + -3, y + 2);
        PaintType mpaint05 = PaintType.ALLY_SECONDARY;
        if (rc.canSenseLocation(mloc05)) {
            MapInfo minfo05 = rc.senseMapInfo(mloc05);
            if (!minfo05.hasRuin() && !minfo05.isWall()) {
                mpaint05 = minfo05.getPaint();
            }
        }
        
        MapLocation mloc06 = new MapLocation(x + -3, y + 3);
        PaintType mpaint06 = PaintType.ALLY_SECONDARY;
        if (rc.canSenseLocation(mloc06)) {
            MapInfo minfo06 = rc.senseMapInfo(mloc06);
            if (!minfo06.hasRuin() && !minfo06.isWall()) {
                mpaint06 = minfo06.getPaint();
            }
        }
        
        
        
        MapLocation mloc10 = new MapLocation(x + -2, y + -3);
        PaintType mpaint10 = PaintType.ALLY_SECONDARY;
        if (rc.canSenseLocation(mloc10)) {
            MapInfo minfo10 = rc.senseMapInfo(mloc10);
            if (!minfo10.hasRuin() && !minfo10.isWall()) {
                mpaint10 = minfo10.getPaint();
            }
        }
        
        MapLocation mloc11 = new MapLocation(x + -2, y + -2);
        PaintType mpaint11 = PaintType.ALLY_SECONDARY;
        if (rc.canSenseLocation(mloc11)) {
            MapInfo minfo11 = rc.senseMapInfo(mloc11);
            if (!minfo11.hasRuin() && !minfo11.isWall()) {
                mpaint11 = minfo11.getPaint();
            }
        }
        
        MapLocation mloc12 = new MapLocation(x + -2, y + -1);
        PaintType mpaint12 = PaintType.ALLY_SECONDARY;
        if (rc.canSenseLocation(mloc12)) {
            MapInfo minfo12 = rc.senseMapInfo(mloc12);
            if (!minfo12.hasRuin() && !minfo12.isWall()) {
                mpaint12 = minfo12.getPaint();
            }
        }
        
        MapLocation mloc13 = new MapLocation(x + -2, y + 0);
        PaintType mpaint13 = PaintType.ALLY_SECONDARY;
        if (rc.canSenseLocation(mloc13)) {
            MapInfo minfo13 = rc.senseMapInfo(mloc13);
            if (!minfo13.hasRuin() && !minfo13.isWall()) {
                mpaint13 = minfo13.getPaint();
            }
        }
        
        MapLocation mloc14 = new MapLocation(x + -2, y + 1);
        PaintType mpaint14 = PaintType.ALLY_SECONDARY;
        if (rc.canSenseLocation(mloc14)) {
            MapInfo minfo14 = rc.senseMapInfo(mloc14);
            if (!minfo14.hasRuin() && !minfo14.isWall()) {
                mpaint14 = minfo14.getPaint();
            }
        }
        
        MapLocation mloc15 = new MapLocation(x + -2, y + 2);
        PaintType mpaint15 = PaintType.ALLY_SECONDARY;
        if (rc.canSenseLocation(mloc15)) {
            MapInfo minfo15 = rc.senseMapInfo(mloc15);
            if (!minfo15.hasRuin() && !minfo15.isWall()) {
                mpaint15 = minfo15.getPaint();
            }
        }
        
        MapLocation mloc16 = new MapLocation(x + -2, y + 3);
        PaintType mpaint16 = PaintType.ALLY_SECONDARY;
        if (rc.canSenseLocation(mloc16)) {
            MapInfo minfo16 = rc.senseMapInfo(mloc16);
            if (!minfo16.hasRuin() && !minfo16.isWall()) {
                mpaint16 = minfo16.getPaint();
            }
        }
        
        
        
        MapLocation mloc20 = new MapLocation(x + -1, y + -3);
        PaintType mpaint20 = PaintType.ALLY_SECONDARY;
        if (rc.canSenseLocation(mloc20)) {
            MapInfo minfo20 = rc.senseMapInfo(mloc20);
            if (!minfo20.hasRuin() && !minfo20.isWall()) {
                mpaint20 = minfo20.getPaint();
            }
        }
        
        MapLocation mloc21 = new MapLocation(x + -1, y + -2);
        PaintType mpaint21 = PaintType.ALLY_SECONDARY;
        if (rc.canSenseLocation(mloc21)) {
            MapInfo minfo21 = rc.senseMapInfo(mloc21);
            if (!minfo21.hasRuin() && !minfo21.isWall()) {
                mpaint21 = minfo21.getPaint();
            }
        }
        
        MapLocation mloc22 = new MapLocation(x + -1, y + -1);
        PaintType mpaint22 = PaintType.ALLY_SECONDARY;
        if (rc.canSenseLocation(mloc22)) {
            MapInfo minfo22 = rc.senseMapInfo(mloc22);
            if (!minfo22.hasRuin() && !minfo22.isWall()) {
                mpaint22 = minfo22.getPaint();
            }
        }
        
        MapLocation mloc23 = new MapLocation(x + -1, y + 0);
        PaintType mpaint23 = PaintType.ALLY_SECONDARY;
        if (rc.canSenseLocation(mloc23)) {
            MapInfo minfo23 = rc.senseMapInfo(mloc23);
            if (!minfo23.hasRuin() && !minfo23.isWall()) {
                mpaint23 = minfo23.getPaint();
            }
        }
        
        MapLocation mloc24 = new MapLocation(x + -1, y + 1);
        PaintType mpaint24 = PaintType.ALLY_SECONDARY;
        if (rc.canSenseLocation(mloc24)) {
            MapInfo minfo24 = rc.senseMapInfo(mloc24);
            if (!minfo24.hasRuin() && !minfo24.isWall()) {
                mpaint24 = minfo24.getPaint();
            }
        }
        
        MapLocation mloc25 = new MapLocation(x + -1, y + 2);
        PaintType mpaint25 = PaintType.ALLY_SECONDARY;
        if (rc.canSenseLocation(mloc25)) {
            MapInfo minfo25 = rc.senseMapInfo(mloc25);
            if (!minfo25.hasRuin() && !minfo25.isWall()) {
                mpaint25 = minfo25.getPaint();
            }
        }
        
        MapLocation mloc26 = new MapLocation(x + -1, y + 3);
        PaintType mpaint26 = PaintType.ALLY_SECONDARY;
        if (rc.canSenseLocation(mloc26)) {
            MapInfo minfo26 = rc.senseMapInfo(mloc26);
            if (!minfo26.hasRuin() && !minfo26.isWall()) {
                mpaint26 = minfo26.getPaint();
            }
        }
        
        
        
        MapLocation mloc30 = new MapLocation(x + 0, y + -3);
        PaintType mpaint30 = PaintType.ALLY_SECONDARY;
        if (rc.canSenseLocation(mloc30)) {
            MapInfo minfo30 = rc.senseMapInfo(mloc30);
            if (!minfo30.hasRuin() && !minfo30.isWall()) {
                mpaint30 = minfo30.getPaint();
            }
        }
        
        MapLocation mloc31 = new MapLocation(x + 0, y + -2);
        PaintType mpaint31 = PaintType.ALLY_SECONDARY;
        if (rc.canSenseLocation(mloc31)) {
            MapInfo minfo31 = rc.senseMapInfo(mloc31);
            if (!minfo31.hasRuin() && !minfo31.isWall()) {
                mpaint31 = minfo31.getPaint();
            }
        }
        
        MapLocation mloc32 = new MapLocation(x + 0, y + -1);
        PaintType mpaint32 = PaintType.ALLY_SECONDARY;
        if (rc.canSenseLocation(mloc32)) {
            MapInfo minfo32 = rc.senseMapInfo(mloc32);
            if (!minfo32.hasRuin() && !minfo32.isWall()) {
                mpaint32 = minfo32.getPaint();
            }
        }
        
        MapLocation mloc33 = new MapLocation(x + 0, y + 0);
        PaintType mpaint33 = PaintType.ALLY_SECONDARY;
        if (rc.canSenseLocation(mloc33)) {
            MapInfo minfo33 = rc.senseMapInfo(mloc33);
            if (!minfo33.hasRuin() && !minfo33.isWall()) {
                mpaint33 = minfo33.getPaint();
            }
        }
        
        MapLocation mloc34 = new MapLocation(x + 0, y + 1);
        PaintType mpaint34 = PaintType.ALLY_SECONDARY;
        if (rc.canSenseLocation(mloc34)) {
            MapInfo minfo34 = rc.senseMapInfo(mloc34);
            if (!minfo34.hasRuin() && !minfo34.isWall()) {
                mpaint34 = minfo34.getPaint();
            }
        }
        
        MapLocation mloc35 = new MapLocation(x + 0, y + 2);
        PaintType mpaint35 = PaintType.ALLY_SECONDARY;
        if (rc.canSenseLocation(mloc35)) {
            MapInfo minfo35 = rc.senseMapInfo(mloc35);
            if (!minfo35.hasRuin() && !minfo35.isWall()) {
                mpaint35 = minfo35.getPaint();
            }
        }
        
        MapLocation mloc36 = new MapLocation(x + 0, y + 3);
        PaintType mpaint36 = PaintType.ALLY_SECONDARY;
        if (rc.canSenseLocation(mloc36)) {
            MapInfo minfo36 = rc.senseMapInfo(mloc36);
            if (!minfo36.hasRuin() && !minfo36.isWall()) {
                mpaint36 = minfo36.getPaint();
            }
        }
        
        
        
        MapLocation mloc40 = new MapLocation(x + 1, y + -3);
        PaintType mpaint40 = PaintType.ALLY_SECONDARY;
        if (rc.canSenseLocation(mloc40)) {
            MapInfo minfo40 = rc.senseMapInfo(mloc40);
            if (!minfo40.hasRuin() && !minfo40.isWall()) {
                mpaint40 = minfo40.getPaint();
            }
        }
        
        MapLocation mloc41 = new MapLocation(x + 1, y + -2);
        PaintType mpaint41 = PaintType.ALLY_SECONDARY;
        if (rc.canSenseLocation(mloc41)) {
            MapInfo minfo41 = rc.senseMapInfo(mloc41);
            if (!minfo41.hasRuin() && !minfo41.isWall()) {
                mpaint41 = minfo41.getPaint();
            }
        }
        
        MapLocation mloc42 = new MapLocation(x + 1, y + -1);
        PaintType mpaint42 = PaintType.ALLY_SECONDARY;
        if (rc.canSenseLocation(mloc42)) {
            MapInfo minfo42 = rc.senseMapInfo(mloc42);
            if (!minfo42.hasRuin() && !minfo42.isWall()) {
                mpaint42 = minfo42.getPaint();
            }
        }
        
        MapLocation mloc43 = new MapLocation(x + 1, y + 0);
        PaintType mpaint43 = PaintType.ALLY_SECONDARY;
        if (rc.canSenseLocation(mloc43)) {
            MapInfo minfo43 = rc.senseMapInfo(mloc43);
            if (!minfo43.hasRuin() && !minfo43.isWall()) {
                mpaint43 = minfo43.getPaint();
            }
        }
        
        MapLocation mloc44 = new MapLocation(x + 1, y + 1);
        PaintType mpaint44 = PaintType.ALLY_SECONDARY;
        if (rc.canSenseLocation(mloc44)) {
            MapInfo minfo44 = rc.senseMapInfo(mloc44);
            if (!minfo44.hasRuin() && !minfo44.isWall()) {
                mpaint44 = minfo44.getPaint();
            }
        }
        
        MapLocation mloc45 = new MapLocation(x + 1, y + 2);
        PaintType mpaint45 = PaintType.ALLY_SECONDARY;
        if (rc.canSenseLocation(mloc45)) {
            MapInfo minfo45 = rc.senseMapInfo(mloc45);
            if (!minfo45.hasRuin() && !minfo45.isWall()) {
                mpaint45 = minfo45.getPaint();
            }
        }
        
        MapLocation mloc46 = new MapLocation(x + 1, y + 3);
        PaintType mpaint46 = PaintType.ALLY_SECONDARY;
        if (rc.canSenseLocation(mloc46)) {
            MapInfo minfo46 = rc.senseMapInfo(mloc46);
            if (!minfo46.hasRuin() && !minfo46.isWall()) {
                mpaint46 = minfo46.getPaint();
            }
        }
        
        
        
        MapLocation mloc50 = new MapLocation(x + 2, y + -3);
        PaintType mpaint50 = PaintType.ALLY_SECONDARY;
        if (rc.canSenseLocation(mloc50)) {
            MapInfo minfo50 = rc.senseMapInfo(mloc50);
            if (!minfo50.hasRuin() && !minfo50.isWall()) {
                mpaint50 = minfo50.getPaint();
            }
        }
        
        MapLocation mloc51 = new MapLocation(x + 2, y + -2);
        PaintType mpaint51 = PaintType.ALLY_SECONDARY;
        if (rc.canSenseLocation(mloc51)) {
            MapInfo minfo51 = rc.senseMapInfo(mloc51);
            if (!minfo51.hasRuin() && !minfo51.isWall()) {
                mpaint51 = minfo51.getPaint();
            }
        }
        
        MapLocation mloc52 = new MapLocation(x + 2, y + -1);
        PaintType mpaint52 = PaintType.ALLY_SECONDARY;
        if (rc.canSenseLocation(mloc52)) {
            MapInfo minfo52 = rc.senseMapInfo(mloc52);
            if (!minfo52.hasRuin() && !minfo52.isWall()) {
                mpaint52 = minfo52.getPaint();
            }
        }
        
        MapLocation mloc53 = new MapLocation(x + 2, y + 0);
        PaintType mpaint53 = PaintType.ALLY_SECONDARY;
        if (rc.canSenseLocation(mloc53)) {
            MapInfo minfo53 = rc.senseMapInfo(mloc53);
            if (!minfo53.hasRuin() && !minfo53.isWall()) {
                mpaint53 = minfo53.getPaint();
            }
        }
        
        MapLocation mloc54 = new MapLocation(x + 2, y + 1);
        PaintType mpaint54 = PaintType.ALLY_SECONDARY;
        if (rc.canSenseLocation(mloc54)) {
            MapInfo minfo54 = rc.senseMapInfo(mloc54);
            if (!minfo54.hasRuin() && !minfo54.isWall()) {
                mpaint54 = minfo54.getPaint();
            }
        }
        
        MapLocation mloc55 = new MapLocation(x + 2, y + 2);
        PaintType mpaint55 = PaintType.ALLY_SECONDARY;
        if (rc.canSenseLocation(mloc55)) {
            MapInfo minfo55 = rc.senseMapInfo(mloc55);
            if (!minfo55.hasRuin() && !minfo55.isWall()) {
                mpaint55 = minfo55.getPaint();
            }
        }
        
        MapLocation mloc56 = new MapLocation(x + 2, y + 3);
        PaintType mpaint56 = PaintType.ALLY_SECONDARY;
        if (rc.canSenseLocation(mloc56)) {
            MapInfo minfo56 = rc.senseMapInfo(mloc56);
            if (!minfo56.hasRuin() && !minfo56.isWall()) {
                mpaint56 = minfo56.getPaint();
            }
        }
        
        
        
        MapLocation mloc60 = new MapLocation(x + 3, y + -3);
        PaintType mpaint60 = PaintType.ALLY_SECONDARY;
        if (rc.canSenseLocation(mloc60)) {
            MapInfo minfo60 = rc.senseMapInfo(mloc60);
            if (!minfo60.hasRuin() && !minfo60.isWall()) {
                mpaint60 = minfo60.getPaint();
            }
        }
        
        MapLocation mloc61 = new MapLocation(x + 3, y + -2);
        PaintType mpaint61 = PaintType.ALLY_SECONDARY;
        if (rc.canSenseLocation(mloc61)) {
            MapInfo minfo61 = rc.senseMapInfo(mloc61);
            if (!minfo61.hasRuin() && !minfo61.isWall()) {
                mpaint61 = minfo61.getPaint();
            }
        }
        
        MapLocation mloc62 = new MapLocation(x + 3, y + -1);
        PaintType mpaint62 = PaintType.ALLY_SECONDARY;
        if (rc.canSenseLocation(mloc62)) {
            MapInfo minfo62 = rc.senseMapInfo(mloc62);
            if (!minfo62.hasRuin() && !minfo62.isWall()) {
                mpaint62 = minfo62.getPaint();
            }
        }
        
        MapLocation mloc63 = new MapLocation(x + 3, y + 0);
        PaintType mpaint63 = PaintType.ALLY_SECONDARY;
        if (rc.canSenseLocation(mloc63)) {
            MapInfo minfo63 = rc.senseMapInfo(mloc63);
            if (!minfo63.hasRuin() && !minfo63.isWall()) {
                mpaint63 = minfo63.getPaint();
            }
        }
        
        MapLocation mloc64 = new MapLocation(x + 3, y + 1);
        PaintType mpaint64 = PaintType.ALLY_SECONDARY;
        if (rc.canSenseLocation(mloc64)) {
            MapInfo minfo64 = rc.senseMapInfo(mloc64);
            if (!minfo64.hasRuin() && !minfo64.isWall()) {
                mpaint64 = minfo64.getPaint();
            }
        }
        
        MapLocation mloc65 = new MapLocation(x + 3, y + 2);
        PaintType mpaint65 = PaintType.ALLY_SECONDARY;
        if (rc.canSenseLocation(mloc65)) {
            MapInfo minfo65 = rc.senseMapInfo(mloc65);
            if (!minfo65.hasRuin() && !minfo65.isWall()) {
                mpaint65 = minfo65.getPaint();
            }
        }
        
        MapLocation mloc66 = new MapLocation(x + 3, y + 3);
        PaintType mpaint66 = PaintType.ALLY_SECONDARY;
        if (rc.canSenseLocation(mloc66)) {
            MapInfo minfo66 = rc.senseMapInfo(mloc66);
            if (!minfo66.hasRuin() && !minfo66.isWall()) {
                mpaint66 = minfo66.getPaint();
            }
        }
        
        

        
        
        if (rc.canAttack(mloc11)) {
            count = 0;
            
             
            switch (mpaint00) {
                case EMPTY -> count += 1;
                case ENEMY_PRIMARY, ENEMY_SECONDARY -> count += 2;
                default -> {}
            }
             
            switch (mpaint01) {
                case EMPTY -> count += 1;
                case ENEMY_PRIMARY, ENEMY_SECONDARY -> count += 2;
                default -> {}
            }
             
            switch (mpaint02) {
                case EMPTY -> count += 1;
                case ENEMY_PRIMARY, ENEMY_SECONDARY -> count += 2;
                default -> {}
            }
            
            
             
            switch (mpaint10) {
                case EMPTY -> count += 1;
                case ENEMY_PRIMARY, ENEMY_SECONDARY -> count += 2;
                default -> {}
            }
             
            switch (mpaint11) {
                case EMPTY -> count += 1;
                case ENEMY_PRIMARY, ENEMY_SECONDARY -> count += 2;
                default -> {}
            }
             
            switch (mpaint12) {
                case EMPTY -> count += 1;
                case ENEMY_PRIMARY, ENEMY_SECONDARY -> count += 2;
                default -> {}
            }
            
            
             
            switch (mpaint20) {
                case EMPTY -> count += 1;
                case ENEMY_PRIMARY, ENEMY_SECONDARY -> count += 2;
                default -> {}
            }
             
            switch (mpaint21) {
                case EMPTY -> count += 1;
                case ENEMY_PRIMARY, ENEMY_SECONDARY -> count += 2;
                default -> {}
            }
             
            switch (mpaint22) {
                case EMPTY -> count += 1;
                case ENEMY_PRIMARY, ENEMY_SECONDARY -> count += 2;
                default -> {}
            }
            
            
            if (count > bestCount) {
                bestLoc = mloc11;
                bestCount = count;
            }
        }
        
        if (rc.canAttack(mloc12)) {
            count = 0;
            
             
            switch (mpaint01) {
                case EMPTY -> count += 1;
                case ENEMY_PRIMARY, ENEMY_SECONDARY -> count += 2;
                default -> {}
            }
             
            switch (mpaint02) {
                case EMPTY -> count += 1;
                case ENEMY_PRIMARY, ENEMY_SECONDARY -> count += 2;
                default -> {}
            }
             
            switch (mpaint03) {
                case EMPTY -> count += 1;
                case ENEMY_PRIMARY, ENEMY_SECONDARY -> count += 2;
                default -> {}
            }
            
            
             
            switch (mpaint11) {
                case EMPTY -> count += 1;
                case ENEMY_PRIMARY, ENEMY_SECONDARY -> count += 2;
                default -> {}
            }
             
            switch (mpaint12) {
                case EMPTY -> count += 1;
                case ENEMY_PRIMARY, ENEMY_SECONDARY -> count += 2;
                default -> {}
            }
             
            switch (mpaint13) {
                case EMPTY -> count += 1;
                case ENEMY_PRIMARY, ENEMY_SECONDARY -> count += 2;
                default -> {}
            }
            
            
             
            switch (mpaint21) {
                case EMPTY -> count += 1;
                case ENEMY_PRIMARY, ENEMY_SECONDARY -> count += 2;
                default -> {}
            }
             
            switch (mpaint22) {
                case EMPTY -> count += 1;
                case ENEMY_PRIMARY, ENEMY_SECONDARY -> count += 2;
                default -> {}
            }
             
            switch (mpaint23) {
                case EMPTY -> count += 1;
                case ENEMY_PRIMARY, ENEMY_SECONDARY -> count += 2;
                default -> {}
            }
            
            
            if (count > bestCount) {
                bestLoc = mloc12;
                bestCount = count;
            }
        }
        
        if (rc.canAttack(mloc13)) {
            count = 0;
            
             
            switch (mpaint02) {
                case EMPTY -> count += 1;
                case ENEMY_PRIMARY, ENEMY_SECONDARY -> count += 2;
                default -> {}
            }
             
            switch (mpaint03) {
                case EMPTY -> count += 1;
                case ENEMY_PRIMARY, ENEMY_SECONDARY -> count += 2;
                default -> {}
            }
             
            switch (mpaint04) {
                case EMPTY -> count += 1;
                case ENEMY_PRIMARY, ENEMY_SECONDARY -> count += 2;
                default -> {}
            }
            
            
             
            switch (mpaint12) {
                case EMPTY -> count += 1;
                case ENEMY_PRIMARY, ENEMY_SECONDARY -> count += 2;
                default -> {}
            }
             
            switch (mpaint13) {
                case EMPTY -> count += 1;
                case ENEMY_PRIMARY, ENEMY_SECONDARY -> count += 2;
                default -> {}
            }
             
            switch (mpaint14) {
                case EMPTY -> count += 1;
                case ENEMY_PRIMARY, ENEMY_SECONDARY -> count += 2;
                default -> {}
            }
            
            
             
            switch (mpaint22) {
                case EMPTY -> count += 1;
                case ENEMY_PRIMARY, ENEMY_SECONDARY -> count += 2;
                default -> {}
            }
             
            switch (mpaint23) {
                case EMPTY -> count += 1;
                case ENEMY_PRIMARY, ENEMY_SECONDARY -> count += 2;
                default -> {}
            }
             
            switch (mpaint24) {
                case EMPTY -> count += 1;
                case ENEMY_PRIMARY, ENEMY_SECONDARY -> count += 2;
                default -> {}
            }
            
            
            if (count > bestCount) {
                bestLoc = mloc13;
                bestCount = count;
            }
        }
        
        if (rc.canAttack(mloc14)) {
            count = 0;
            
             
            switch (mpaint03) {
                case EMPTY -> count += 1;
                case ENEMY_PRIMARY, ENEMY_SECONDARY -> count += 2;
                default -> {}
            }
             
            switch (mpaint04) {
                case EMPTY -> count += 1;
                case ENEMY_PRIMARY, ENEMY_SECONDARY -> count += 2;
                default -> {}
            }
             
            switch (mpaint05) {
                case EMPTY -> count += 1;
                case ENEMY_PRIMARY, ENEMY_SECONDARY -> count += 2;
                default -> {}
            }
            
            
             
            switch (mpaint13) {
                case EMPTY -> count += 1;
                case ENEMY_PRIMARY, ENEMY_SECONDARY -> count += 2;
                default -> {}
            }
             
            switch (mpaint14) {
                case EMPTY -> count += 1;
                case ENEMY_PRIMARY, ENEMY_SECONDARY -> count += 2;
                default -> {}
            }
             
            switch (mpaint15) {
                case EMPTY -> count += 1;
                case ENEMY_PRIMARY, ENEMY_SECONDARY -> count += 2;
                default -> {}
            }
            
            
             
            switch (mpaint23) {
                case EMPTY -> count += 1;
                case ENEMY_PRIMARY, ENEMY_SECONDARY -> count += 2;
                default -> {}
            }
             
            switch (mpaint24) {
                case EMPTY -> count += 1;
                case ENEMY_PRIMARY, ENEMY_SECONDARY -> count += 2;
                default -> {}
            }
             
            switch (mpaint25) {
                case EMPTY -> count += 1;
                case ENEMY_PRIMARY, ENEMY_SECONDARY -> count += 2;
                default -> {}
            }
            
            
            if (count > bestCount) {
                bestLoc = mloc14;
                bestCount = count;
            }
        }
        
        if (rc.canAttack(mloc15)) {
            count = 0;
            
             
            switch (mpaint04) {
                case EMPTY -> count += 1;
                case ENEMY_PRIMARY, ENEMY_SECONDARY -> count += 2;
                default -> {}
            }
             
            switch (mpaint05) {
                case EMPTY -> count += 1;
                case ENEMY_PRIMARY, ENEMY_SECONDARY -> count += 2;
                default -> {}
            }
             
            switch (mpaint06) {
                case EMPTY -> count += 1;
                case ENEMY_PRIMARY, ENEMY_SECONDARY -> count += 2;
                default -> {}
            }
            
            
             
            switch (mpaint14) {
                case EMPTY -> count += 1;
                case ENEMY_PRIMARY, ENEMY_SECONDARY -> count += 2;
                default -> {}
            }
             
            switch (mpaint15) {
                case EMPTY -> count += 1;
                case ENEMY_PRIMARY, ENEMY_SECONDARY -> count += 2;
                default -> {}
            }
             
            switch (mpaint16) {
                case EMPTY -> count += 1;
                case ENEMY_PRIMARY, ENEMY_SECONDARY -> count += 2;
                default -> {}
            }
            
            
             
            switch (mpaint24) {
                case EMPTY -> count += 1;
                case ENEMY_PRIMARY, ENEMY_SECONDARY -> count += 2;
                default -> {}
            }
             
            switch (mpaint25) {
                case EMPTY -> count += 1;
                case ENEMY_PRIMARY, ENEMY_SECONDARY -> count += 2;
                default -> {}
            }
             
            switch (mpaint26) {
                case EMPTY -> count += 1;
                case ENEMY_PRIMARY, ENEMY_SECONDARY -> count += 2;
                default -> {}
            }
            
            
            if (count > bestCount) {
                bestLoc = mloc15;
                bestCount = count;
            }
        }
        
        
        
        if (rc.canAttack(mloc21)) {
            count = 0;
            
             
            switch (mpaint10) {
                case EMPTY -> count += 1;
                case ENEMY_PRIMARY, ENEMY_SECONDARY -> count += 2;
                default -> {}
            }
             
            switch (mpaint11) {
                case EMPTY -> count += 1;
                case ENEMY_PRIMARY, ENEMY_SECONDARY -> count += 2;
                default -> {}
            }
             
            switch (mpaint12) {
                case EMPTY -> count += 1;
                case ENEMY_PRIMARY, ENEMY_SECONDARY -> count += 2;
                default -> {}
            }
            
            
             
            switch (mpaint20) {
                case EMPTY -> count += 1;
                case ENEMY_PRIMARY, ENEMY_SECONDARY -> count += 2;
                default -> {}
            }
             
            switch (mpaint21) {
                case EMPTY -> count += 1;
                case ENEMY_PRIMARY, ENEMY_SECONDARY -> count += 2;
                default -> {}
            }
             
            switch (mpaint22) {
                case EMPTY -> count += 1;
                case ENEMY_PRIMARY, ENEMY_SECONDARY -> count += 2;
                default -> {}
            }
            
            
             
            switch (mpaint30) {
                case EMPTY -> count += 1;
                case ENEMY_PRIMARY, ENEMY_SECONDARY -> count += 2;
                default -> {}
            }
             
            switch (mpaint31) {
                case EMPTY -> count += 1;
                case ENEMY_PRIMARY, ENEMY_SECONDARY -> count += 2;
                default -> {}
            }
             
            switch (mpaint32) {
                case EMPTY -> count += 1;
                case ENEMY_PRIMARY, ENEMY_SECONDARY -> count += 2;
                default -> {}
            }
            
            
            if (count > bestCount) {
                bestLoc = mloc21;
                bestCount = count;
            }
        }
        
        if (rc.canAttack(mloc22)) {
            count = 0;
            
             
            switch (mpaint11) {
                case EMPTY -> count += 1;
                case ENEMY_PRIMARY, ENEMY_SECONDARY -> count += 2;
                default -> {}
            }
             
            switch (mpaint12) {
                case EMPTY -> count += 1;
                case ENEMY_PRIMARY, ENEMY_SECONDARY -> count += 2;
                default -> {}
            }
             
            switch (mpaint13) {
                case EMPTY -> count += 1;
                case ENEMY_PRIMARY, ENEMY_SECONDARY -> count += 2;
                default -> {}
            }
            
            
             
            switch (mpaint21) {
                case EMPTY -> count += 1;
                case ENEMY_PRIMARY, ENEMY_SECONDARY -> count += 2;
                default -> {}
            }
             
            switch (mpaint22) {
                case EMPTY -> count += 1;
                case ENEMY_PRIMARY, ENEMY_SECONDARY -> count += 2;
                default -> {}
            }
             
            switch (mpaint23) {
                case EMPTY -> count += 1;
                case ENEMY_PRIMARY, ENEMY_SECONDARY -> count += 2;
                default -> {}
            }
            
            
             
            switch (mpaint31) {
                case EMPTY -> count += 1;
                case ENEMY_PRIMARY, ENEMY_SECONDARY -> count += 2;
                default -> {}
            }
             
            switch (mpaint32) {
                case EMPTY -> count += 1;
                case ENEMY_PRIMARY, ENEMY_SECONDARY -> count += 2;
                default -> {}
            }
             
            switch (mpaint33) {
                case EMPTY -> count += 1;
                case ENEMY_PRIMARY, ENEMY_SECONDARY -> count += 2;
                default -> {}
            }
            
            
            if (count > bestCount) {
                bestLoc = mloc22;
                bestCount = count;
            }
        }
        
        if (rc.canAttack(mloc23)) {
            count = 0;
            
             
            switch (mpaint12) {
                case EMPTY -> count += 1;
                case ENEMY_PRIMARY, ENEMY_SECONDARY -> count += 2;
                default -> {}
            }
             
            switch (mpaint13) {
                case EMPTY -> count += 1;
                case ENEMY_PRIMARY, ENEMY_SECONDARY -> count += 2;
                default -> {}
            }
             
            switch (mpaint14) {
                case EMPTY -> count += 1;
                case ENEMY_PRIMARY, ENEMY_SECONDARY -> count += 2;
                default -> {}
            }
            
            
             
            switch (mpaint22) {
                case EMPTY -> count += 1;
                case ENEMY_PRIMARY, ENEMY_SECONDARY -> count += 2;
                default -> {}
            }
             
            switch (mpaint23) {
                case EMPTY -> count += 1;
                case ENEMY_PRIMARY, ENEMY_SECONDARY -> count += 2;
                default -> {}
            }
             
            switch (mpaint24) {
                case EMPTY -> count += 1;
                case ENEMY_PRIMARY, ENEMY_SECONDARY -> count += 2;
                default -> {}
            }
            
            
             
            switch (mpaint32) {
                case EMPTY -> count += 1;
                case ENEMY_PRIMARY, ENEMY_SECONDARY -> count += 2;
                default -> {}
            }
             
            switch (mpaint33) {
                case EMPTY -> count += 1;
                case ENEMY_PRIMARY, ENEMY_SECONDARY -> count += 2;
                default -> {}
            }
             
            switch (mpaint34) {
                case EMPTY -> count += 1;
                case ENEMY_PRIMARY, ENEMY_SECONDARY -> count += 2;
                default -> {}
            }
            
            
            if (count > bestCount) {
                bestLoc = mloc23;
                bestCount = count;
            }
        }
        
        if (rc.canAttack(mloc24)) {
            count = 0;
            
             
            switch (mpaint13) {
                case EMPTY -> count += 1;
                case ENEMY_PRIMARY, ENEMY_SECONDARY -> count += 2;
                default -> {}
            }
             
            switch (mpaint14) {
                case EMPTY -> count += 1;
                case ENEMY_PRIMARY, ENEMY_SECONDARY -> count += 2;
                default -> {}
            }
             
            switch (mpaint15) {
                case EMPTY -> count += 1;
                case ENEMY_PRIMARY, ENEMY_SECONDARY -> count += 2;
                default -> {}
            }
            
            
             
            switch (mpaint23) {
                case EMPTY -> count += 1;
                case ENEMY_PRIMARY, ENEMY_SECONDARY -> count += 2;
                default -> {}
            }
             
            switch (mpaint24) {
                case EMPTY -> count += 1;
                case ENEMY_PRIMARY, ENEMY_SECONDARY -> count += 2;
                default -> {}
            }
             
            switch (mpaint25) {
                case EMPTY -> count += 1;
                case ENEMY_PRIMARY, ENEMY_SECONDARY -> count += 2;
                default -> {}
            }
            
            
             
            switch (mpaint33) {
                case EMPTY -> count += 1;
                case ENEMY_PRIMARY, ENEMY_SECONDARY -> count += 2;
                default -> {}
            }
             
            switch (mpaint34) {
                case EMPTY -> count += 1;
                case ENEMY_PRIMARY, ENEMY_SECONDARY -> count += 2;
                default -> {}
            }
             
            switch (mpaint35) {
                case EMPTY -> count += 1;
                case ENEMY_PRIMARY, ENEMY_SECONDARY -> count += 2;
                default -> {}
            }
            
            
            if (count > bestCount) {
                bestLoc = mloc24;
                bestCount = count;
            }
        }
        
        if (rc.canAttack(mloc25)) {
            count = 0;
            
             
            switch (mpaint14) {
                case EMPTY -> count += 1;
                case ENEMY_PRIMARY, ENEMY_SECONDARY -> count += 2;
                default -> {}
            }
             
            switch (mpaint15) {
                case EMPTY -> count += 1;
                case ENEMY_PRIMARY, ENEMY_SECONDARY -> count += 2;
                default -> {}
            }
             
            switch (mpaint16) {
                case EMPTY -> count += 1;
                case ENEMY_PRIMARY, ENEMY_SECONDARY -> count += 2;
                default -> {}
            }
            
            
             
            switch (mpaint24) {
                case EMPTY -> count += 1;
                case ENEMY_PRIMARY, ENEMY_SECONDARY -> count += 2;
                default -> {}
            }
             
            switch (mpaint25) {
                case EMPTY -> count += 1;
                case ENEMY_PRIMARY, ENEMY_SECONDARY -> count += 2;
                default -> {}
            }
             
            switch (mpaint26) {
                case EMPTY -> count += 1;
                case ENEMY_PRIMARY, ENEMY_SECONDARY -> count += 2;
                default -> {}
            }
            
            
             
            switch (mpaint34) {
                case EMPTY -> count += 1;
                case ENEMY_PRIMARY, ENEMY_SECONDARY -> count += 2;
                default -> {}
            }
             
            switch (mpaint35) {
                case EMPTY -> count += 1;
                case ENEMY_PRIMARY, ENEMY_SECONDARY -> count += 2;
                default -> {}
            }
             
            switch (mpaint36) {
                case EMPTY -> count += 1;
                case ENEMY_PRIMARY, ENEMY_SECONDARY -> count += 2;
                default -> {}
            }
            
            
            if (count > bestCount) {
                bestLoc = mloc25;
                bestCount = count;
            }
        }
        
        
        
        if (rc.canAttack(mloc31)) {
            count = 0;
            
             
            switch (mpaint20) {
                case EMPTY -> count += 1;
                case ENEMY_PRIMARY, ENEMY_SECONDARY -> count += 2;
                default -> {}
            }
             
            switch (mpaint21) {
                case EMPTY -> count += 1;
                case ENEMY_PRIMARY, ENEMY_SECONDARY -> count += 2;
                default -> {}
            }
             
            switch (mpaint22) {
                case EMPTY -> count += 1;
                case ENEMY_PRIMARY, ENEMY_SECONDARY -> count += 2;
                default -> {}
            }
            
            
             
            switch (mpaint30) {
                case EMPTY -> count += 1;
                case ENEMY_PRIMARY, ENEMY_SECONDARY -> count += 2;
                default -> {}
            }
             
            switch (mpaint31) {
                case EMPTY -> count += 1;
                case ENEMY_PRIMARY, ENEMY_SECONDARY -> count += 2;
                default -> {}
            }
             
            switch (mpaint32) {
                case EMPTY -> count += 1;
                case ENEMY_PRIMARY, ENEMY_SECONDARY -> count += 2;
                default -> {}
            }
            
            
             
            switch (mpaint40) {
                case EMPTY -> count += 1;
                case ENEMY_PRIMARY, ENEMY_SECONDARY -> count += 2;
                default -> {}
            }
             
            switch (mpaint41) {
                case EMPTY -> count += 1;
                case ENEMY_PRIMARY, ENEMY_SECONDARY -> count += 2;
                default -> {}
            }
             
            switch (mpaint42) {
                case EMPTY -> count += 1;
                case ENEMY_PRIMARY, ENEMY_SECONDARY -> count += 2;
                default -> {}
            }
            
            
            if (count > bestCount) {
                bestLoc = mloc31;
                bestCount = count;
            }
        }
        
        if (rc.canAttack(mloc32)) {
            count = 0;
            
             
            switch (mpaint21) {
                case EMPTY -> count += 1;
                case ENEMY_PRIMARY, ENEMY_SECONDARY -> count += 2;
                default -> {}
            }
             
            switch (mpaint22) {
                case EMPTY -> count += 1;
                case ENEMY_PRIMARY, ENEMY_SECONDARY -> count += 2;
                default -> {}
            }
             
            switch (mpaint23) {
                case EMPTY -> count += 1;
                case ENEMY_PRIMARY, ENEMY_SECONDARY -> count += 2;
                default -> {}
            }
            
            
             
            switch (mpaint31) {
                case EMPTY -> count += 1;
                case ENEMY_PRIMARY, ENEMY_SECONDARY -> count += 2;
                default -> {}
            }
             
            switch (mpaint32) {
                case EMPTY -> count += 1;
                case ENEMY_PRIMARY, ENEMY_SECONDARY -> count += 2;
                default -> {}
            }
             
            switch (mpaint33) {
                case EMPTY -> count += 1;
                case ENEMY_PRIMARY, ENEMY_SECONDARY -> count += 2;
                default -> {}
            }
            
            
             
            switch (mpaint41) {
                case EMPTY -> count += 1;
                case ENEMY_PRIMARY, ENEMY_SECONDARY -> count += 2;
                default -> {}
            }
             
            switch (mpaint42) {
                case EMPTY -> count += 1;
                case ENEMY_PRIMARY, ENEMY_SECONDARY -> count += 2;
                default -> {}
            }
             
            switch (mpaint43) {
                case EMPTY -> count += 1;
                case ENEMY_PRIMARY, ENEMY_SECONDARY -> count += 2;
                default -> {}
            }
            
            
            if (count > bestCount) {
                bestLoc = mloc32;
                bestCount = count;
            }
        }
        
        if (rc.canAttack(mloc33)) {
            count = 0;
            
             
            switch (mpaint22) {
                case EMPTY -> count += 1;
                case ENEMY_PRIMARY, ENEMY_SECONDARY -> count += 2;
                default -> {}
            }
             
            switch (mpaint23) {
                case EMPTY -> count += 1;
                case ENEMY_PRIMARY, ENEMY_SECONDARY -> count += 2;
                default -> {}
            }
             
            switch (mpaint24) {
                case EMPTY -> count += 1;
                case ENEMY_PRIMARY, ENEMY_SECONDARY -> count += 2;
                default -> {}
            }
            
            
             
            switch (mpaint32) {
                case EMPTY -> count += 1;
                case ENEMY_PRIMARY, ENEMY_SECONDARY -> count += 2;
                default -> {}
            }
             
            switch (mpaint33) {
                case EMPTY -> count += 1;
                case ENEMY_PRIMARY, ENEMY_SECONDARY -> count += 2;
                default -> {}
            }
             
            switch (mpaint34) {
                case EMPTY -> count += 1;
                case ENEMY_PRIMARY, ENEMY_SECONDARY -> count += 2;
                default -> {}
            }
            
            
             
            switch (mpaint42) {
                case EMPTY -> count += 1;
                case ENEMY_PRIMARY, ENEMY_SECONDARY -> count += 2;
                default -> {}
            }
             
            switch (mpaint43) {
                case EMPTY -> count += 1;
                case ENEMY_PRIMARY, ENEMY_SECONDARY -> count += 2;
                default -> {}
            }
             
            switch (mpaint44) {
                case EMPTY -> count += 1;
                case ENEMY_PRIMARY, ENEMY_SECONDARY -> count += 2;
                default -> {}
            }
            
            
            if (count > bestCount) {
                bestLoc = mloc33;
                bestCount = count;
            }
        }
        
        if (rc.canAttack(mloc34)) {
            count = 0;
            
             
            switch (mpaint23) {
                case EMPTY -> count += 1;
                case ENEMY_PRIMARY, ENEMY_SECONDARY -> count += 2;
                default -> {}
            }
             
            switch (mpaint24) {
                case EMPTY -> count += 1;
                case ENEMY_PRIMARY, ENEMY_SECONDARY -> count += 2;
                default -> {}
            }
             
            switch (mpaint25) {
                case EMPTY -> count += 1;
                case ENEMY_PRIMARY, ENEMY_SECONDARY -> count += 2;
                default -> {}
            }
            
            
             
            switch (mpaint33) {
                case EMPTY -> count += 1;
                case ENEMY_PRIMARY, ENEMY_SECONDARY -> count += 2;
                default -> {}
            }
             
            switch (mpaint34) {
                case EMPTY -> count += 1;
                case ENEMY_PRIMARY, ENEMY_SECONDARY -> count += 2;
                default -> {}
            }
             
            switch (mpaint35) {
                case EMPTY -> count += 1;
                case ENEMY_PRIMARY, ENEMY_SECONDARY -> count += 2;
                default -> {}
            }
            
            
             
            switch (mpaint43) {
                case EMPTY -> count += 1;
                case ENEMY_PRIMARY, ENEMY_SECONDARY -> count += 2;
                default -> {}
            }
             
            switch (mpaint44) {
                case EMPTY -> count += 1;
                case ENEMY_PRIMARY, ENEMY_SECONDARY -> count += 2;
                default -> {}
            }
             
            switch (mpaint45) {
                case EMPTY -> count += 1;
                case ENEMY_PRIMARY, ENEMY_SECONDARY -> count += 2;
                default -> {}
            }
            
            
            if (count > bestCount) {
                bestLoc = mloc34;
                bestCount = count;
            }
        }
        
        if (rc.canAttack(mloc35)) {
            count = 0;
            
             
            switch (mpaint24) {
                case EMPTY -> count += 1;
                case ENEMY_PRIMARY, ENEMY_SECONDARY -> count += 2;
                default -> {}
            }
             
            switch (mpaint25) {
                case EMPTY -> count += 1;
                case ENEMY_PRIMARY, ENEMY_SECONDARY -> count += 2;
                default -> {}
            }
             
            switch (mpaint26) {
                case EMPTY -> count += 1;
                case ENEMY_PRIMARY, ENEMY_SECONDARY -> count += 2;
                default -> {}
            }
            
            
             
            switch (mpaint34) {
                case EMPTY -> count += 1;
                case ENEMY_PRIMARY, ENEMY_SECONDARY -> count += 2;
                default -> {}
            }
             
            switch (mpaint35) {
                case EMPTY -> count += 1;
                case ENEMY_PRIMARY, ENEMY_SECONDARY -> count += 2;
                default -> {}
            }
             
            switch (mpaint36) {
                case EMPTY -> count += 1;
                case ENEMY_PRIMARY, ENEMY_SECONDARY -> count += 2;
                default -> {}
            }
            
            
             
            switch (mpaint44) {
                case EMPTY -> count += 1;
                case ENEMY_PRIMARY, ENEMY_SECONDARY -> count += 2;
                default -> {}
            }
             
            switch (mpaint45) {
                case EMPTY -> count += 1;
                case ENEMY_PRIMARY, ENEMY_SECONDARY -> count += 2;
                default -> {}
            }
             
            switch (mpaint46) {
                case EMPTY -> count += 1;
                case ENEMY_PRIMARY, ENEMY_SECONDARY -> count += 2;
                default -> {}
            }
            
            
            if (count > bestCount) {
                bestLoc = mloc35;
                bestCount = count;
            }
        }
        
        
        
        if (rc.canAttack(mloc41)) {
            count = 0;
            
             
            switch (mpaint30) {
                case EMPTY -> count += 1;
                case ENEMY_PRIMARY, ENEMY_SECONDARY -> count += 2;
                default -> {}
            }
             
            switch (mpaint31) {
                case EMPTY -> count += 1;
                case ENEMY_PRIMARY, ENEMY_SECONDARY -> count += 2;
                default -> {}
            }
             
            switch (mpaint32) {
                case EMPTY -> count += 1;
                case ENEMY_PRIMARY, ENEMY_SECONDARY -> count += 2;
                default -> {}
            }
            
            
             
            switch (mpaint40) {
                case EMPTY -> count += 1;
                case ENEMY_PRIMARY, ENEMY_SECONDARY -> count += 2;
                default -> {}
            }
             
            switch (mpaint41) {
                case EMPTY -> count += 1;
                case ENEMY_PRIMARY, ENEMY_SECONDARY -> count += 2;
                default -> {}
            }
             
            switch (mpaint42) {
                case EMPTY -> count += 1;
                case ENEMY_PRIMARY, ENEMY_SECONDARY -> count += 2;
                default -> {}
            }
            
            
             
            switch (mpaint50) {
                case EMPTY -> count += 1;
                case ENEMY_PRIMARY, ENEMY_SECONDARY -> count += 2;
                default -> {}
            }
             
            switch (mpaint51) {
                case EMPTY -> count += 1;
                case ENEMY_PRIMARY, ENEMY_SECONDARY -> count += 2;
                default -> {}
            }
             
            switch (mpaint52) {
                case EMPTY -> count += 1;
                case ENEMY_PRIMARY, ENEMY_SECONDARY -> count += 2;
                default -> {}
            }
            
            
            if (count > bestCount) {
                bestLoc = mloc41;
                bestCount = count;
            }
        }
        
        if (rc.canAttack(mloc42)) {
            count = 0;
            
             
            switch (mpaint31) {
                case EMPTY -> count += 1;
                case ENEMY_PRIMARY, ENEMY_SECONDARY -> count += 2;
                default -> {}
            }
             
            switch (mpaint32) {
                case EMPTY -> count += 1;
                case ENEMY_PRIMARY, ENEMY_SECONDARY -> count += 2;
                default -> {}
            }
             
            switch (mpaint33) {
                case EMPTY -> count += 1;
                case ENEMY_PRIMARY, ENEMY_SECONDARY -> count += 2;
                default -> {}
            }
            
            
             
            switch (mpaint41) {
                case EMPTY -> count += 1;
                case ENEMY_PRIMARY, ENEMY_SECONDARY -> count += 2;
                default -> {}
            }
             
            switch (mpaint42) {
                case EMPTY -> count += 1;
                case ENEMY_PRIMARY, ENEMY_SECONDARY -> count += 2;
                default -> {}
            }
             
            switch (mpaint43) {
                case EMPTY -> count += 1;
                case ENEMY_PRIMARY, ENEMY_SECONDARY -> count += 2;
                default -> {}
            }
            
            
             
            switch (mpaint51) {
                case EMPTY -> count += 1;
                case ENEMY_PRIMARY, ENEMY_SECONDARY -> count += 2;
                default -> {}
            }
             
            switch (mpaint52) {
                case EMPTY -> count += 1;
                case ENEMY_PRIMARY, ENEMY_SECONDARY -> count += 2;
                default -> {}
            }
             
            switch (mpaint53) {
                case EMPTY -> count += 1;
                case ENEMY_PRIMARY, ENEMY_SECONDARY -> count += 2;
                default -> {}
            }
            
            
            if (count > bestCount) {
                bestLoc = mloc42;
                bestCount = count;
            }
        }
        
        if (rc.canAttack(mloc43)) {
            count = 0;
            
             
            switch (mpaint32) {
                case EMPTY -> count += 1;
                case ENEMY_PRIMARY, ENEMY_SECONDARY -> count += 2;
                default -> {}
            }
             
            switch (mpaint33) {
                case EMPTY -> count += 1;
                case ENEMY_PRIMARY, ENEMY_SECONDARY -> count += 2;
                default -> {}
            }
             
            switch (mpaint34) {
                case EMPTY -> count += 1;
                case ENEMY_PRIMARY, ENEMY_SECONDARY -> count += 2;
                default -> {}
            }
            
            
             
            switch (mpaint42) {
                case EMPTY -> count += 1;
                case ENEMY_PRIMARY, ENEMY_SECONDARY -> count += 2;
                default -> {}
            }
             
            switch (mpaint43) {
                case EMPTY -> count += 1;
                case ENEMY_PRIMARY, ENEMY_SECONDARY -> count += 2;
                default -> {}
            }
             
            switch (mpaint44) {
                case EMPTY -> count += 1;
                case ENEMY_PRIMARY, ENEMY_SECONDARY -> count += 2;
                default -> {}
            }
            
            
             
            switch (mpaint52) {
                case EMPTY -> count += 1;
                case ENEMY_PRIMARY, ENEMY_SECONDARY -> count += 2;
                default -> {}
            }
             
            switch (mpaint53) {
                case EMPTY -> count += 1;
                case ENEMY_PRIMARY, ENEMY_SECONDARY -> count += 2;
                default -> {}
            }
             
            switch (mpaint54) {
                case EMPTY -> count += 1;
                case ENEMY_PRIMARY, ENEMY_SECONDARY -> count += 2;
                default -> {}
            }
            
            
            if (count > bestCount) {
                bestLoc = mloc43;
                bestCount = count;
            }
        }
        
        if (rc.canAttack(mloc44)) {
            count = 0;
            
             
            switch (mpaint33) {
                case EMPTY -> count += 1;
                case ENEMY_PRIMARY, ENEMY_SECONDARY -> count += 2;
                default -> {}
            }
             
            switch (mpaint34) {
                case EMPTY -> count += 1;
                case ENEMY_PRIMARY, ENEMY_SECONDARY -> count += 2;
                default -> {}
            }
             
            switch (mpaint35) {
                case EMPTY -> count += 1;
                case ENEMY_PRIMARY, ENEMY_SECONDARY -> count += 2;
                default -> {}
            }
            
            
             
            switch (mpaint43) {
                case EMPTY -> count += 1;
                case ENEMY_PRIMARY, ENEMY_SECONDARY -> count += 2;
                default -> {}
            }
             
            switch (mpaint44) {
                case EMPTY -> count += 1;
                case ENEMY_PRIMARY, ENEMY_SECONDARY -> count += 2;
                default -> {}
            }
             
            switch (mpaint45) {
                case EMPTY -> count += 1;
                case ENEMY_PRIMARY, ENEMY_SECONDARY -> count += 2;
                default -> {}
            }
            
            
             
            switch (mpaint53) {
                case EMPTY -> count += 1;
                case ENEMY_PRIMARY, ENEMY_SECONDARY -> count += 2;
                default -> {}
            }
             
            switch (mpaint54) {
                case EMPTY -> count += 1;
                case ENEMY_PRIMARY, ENEMY_SECONDARY -> count += 2;
                default -> {}
            }
             
            switch (mpaint55) {
                case EMPTY -> count += 1;
                case ENEMY_PRIMARY, ENEMY_SECONDARY -> count += 2;
                default -> {}
            }
            
            
            if (count > bestCount) {
                bestLoc = mloc44;
                bestCount = count;
            }
        }
        
        if (rc.canAttack(mloc45)) {
            count = 0;
            
             
            switch (mpaint34) {
                case EMPTY -> count += 1;
                case ENEMY_PRIMARY, ENEMY_SECONDARY -> count += 2;
                default -> {}
            }
             
            switch (mpaint35) {
                case EMPTY -> count += 1;
                case ENEMY_PRIMARY, ENEMY_SECONDARY -> count += 2;
                default -> {}
            }
             
            switch (mpaint36) {
                case EMPTY -> count += 1;
                case ENEMY_PRIMARY, ENEMY_SECONDARY -> count += 2;
                default -> {}
            }
            
            
             
            switch (mpaint44) {
                case EMPTY -> count += 1;
                case ENEMY_PRIMARY, ENEMY_SECONDARY -> count += 2;
                default -> {}
            }
             
            switch (mpaint45) {
                case EMPTY -> count += 1;
                case ENEMY_PRIMARY, ENEMY_SECONDARY -> count += 2;
                default -> {}
            }
             
            switch (mpaint46) {
                case EMPTY -> count += 1;
                case ENEMY_PRIMARY, ENEMY_SECONDARY -> count += 2;
                default -> {}
            }
            
            
             
            switch (mpaint54) {
                case EMPTY -> count += 1;
                case ENEMY_PRIMARY, ENEMY_SECONDARY -> count += 2;
                default -> {}
            }
             
            switch (mpaint55) {
                case EMPTY -> count += 1;
                case ENEMY_PRIMARY, ENEMY_SECONDARY -> count += 2;
                default -> {}
            }
             
            switch (mpaint56) {
                case EMPTY -> count += 1;
                case ENEMY_PRIMARY, ENEMY_SECONDARY -> count += 2;
                default -> {}
            }
            
            
            if (count > bestCount) {
                bestLoc = mloc45;
                bestCount = count;
            }
        }
        
        
        
        if (rc.canAttack(mloc51)) {
            count = 0;
            
             
            switch (mpaint40) {
                case EMPTY -> count += 1;
                case ENEMY_PRIMARY, ENEMY_SECONDARY -> count += 2;
                default -> {}
            }
             
            switch (mpaint41) {
                case EMPTY -> count += 1;
                case ENEMY_PRIMARY, ENEMY_SECONDARY -> count += 2;
                default -> {}
            }
             
            switch (mpaint42) {
                case EMPTY -> count += 1;
                case ENEMY_PRIMARY, ENEMY_SECONDARY -> count += 2;
                default -> {}
            }
            
            
             
            switch (mpaint50) {
                case EMPTY -> count += 1;
                case ENEMY_PRIMARY, ENEMY_SECONDARY -> count += 2;
                default -> {}
            }
             
            switch (mpaint51) {
                case EMPTY -> count += 1;
                case ENEMY_PRIMARY, ENEMY_SECONDARY -> count += 2;
                default -> {}
            }
             
            switch (mpaint52) {
                case EMPTY -> count += 1;
                case ENEMY_PRIMARY, ENEMY_SECONDARY -> count += 2;
                default -> {}
            }
            
            
             
            switch (mpaint60) {
                case EMPTY -> count += 1;
                case ENEMY_PRIMARY, ENEMY_SECONDARY -> count += 2;
                default -> {}
            }
             
            switch (mpaint61) {
                case EMPTY -> count += 1;
                case ENEMY_PRIMARY, ENEMY_SECONDARY -> count += 2;
                default -> {}
            }
             
            switch (mpaint62) {
                case EMPTY -> count += 1;
                case ENEMY_PRIMARY, ENEMY_SECONDARY -> count += 2;
                default -> {}
            }
            
            
            if (count > bestCount) {
                bestLoc = mloc51;
                bestCount = count;
            }
        }
        
        if (rc.canAttack(mloc52)) {
            count = 0;
            
             
            switch (mpaint41) {
                case EMPTY -> count += 1;
                case ENEMY_PRIMARY, ENEMY_SECONDARY -> count += 2;
                default -> {}
            }
             
            switch (mpaint42) {
                case EMPTY -> count += 1;
                case ENEMY_PRIMARY, ENEMY_SECONDARY -> count += 2;
                default -> {}
            }
             
            switch (mpaint43) {
                case EMPTY -> count += 1;
                case ENEMY_PRIMARY, ENEMY_SECONDARY -> count += 2;
                default -> {}
            }
            
            
             
            switch (mpaint51) {
                case EMPTY -> count += 1;
                case ENEMY_PRIMARY, ENEMY_SECONDARY -> count += 2;
                default -> {}
            }
             
            switch (mpaint52) {
                case EMPTY -> count += 1;
                case ENEMY_PRIMARY, ENEMY_SECONDARY -> count += 2;
                default -> {}
            }
             
            switch (mpaint53) {
                case EMPTY -> count += 1;
                case ENEMY_PRIMARY, ENEMY_SECONDARY -> count += 2;
                default -> {}
            }
            
            
             
            switch (mpaint61) {
                case EMPTY -> count += 1;
                case ENEMY_PRIMARY, ENEMY_SECONDARY -> count += 2;
                default -> {}
            }
             
            switch (mpaint62) {
                case EMPTY -> count += 1;
                case ENEMY_PRIMARY, ENEMY_SECONDARY -> count += 2;
                default -> {}
            }
             
            switch (mpaint63) {
                case EMPTY -> count += 1;
                case ENEMY_PRIMARY, ENEMY_SECONDARY -> count += 2;
                default -> {}
            }
            
            
            if (count > bestCount) {
                bestLoc = mloc52;
                bestCount = count;
            }
        }
        
        if (rc.canAttack(mloc53)) {
            count = 0;
            
             
            switch (mpaint42) {
                case EMPTY -> count += 1;
                case ENEMY_PRIMARY, ENEMY_SECONDARY -> count += 2;
                default -> {}
            }
             
            switch (mpaint43) {
                case EMPTY -> count += 1;
                case ENEMY_PRIMARY, ENEMY_SECONDARY -> count += 2;
                default -> {}
            }
             
            switch (mpaint44) {
                case EMPTY -> count += 1;
                case ENEMY_PRIMARY, ENEMY_SECONDARY -> count += 2;
                default -> {}
            }
            
            
             
            switch (mpaint52) {
                case EMPTY -> count += 1;
                case ENEMY_PRIMARY, ENEMY_SECONDARY -> count += 2;
                default -> {}
            }
             
            switch (mpaint53) {
                case EMPTY -> count += 1;
                case ENEMY_PRIMARY, ENEMY_SECONDARY -> count += 2;
                default -> {}
            }
             
            switch (mpaint54) {
                case EMPTY -> count += 1;
                case ENEMY_PRIMARY, ENEMY_SECONDARY -> count += 2;
                default -> {}
            }
            
            
             
            switch (mpaint62) {
                case EMPTY -> count += 1;
                case ENEMY_PRIMARY, ENEMY_SECONDARY -> count += 2;
                default -> {}
            }
             
            switch (mpaint63) {
                case EMPTY -> count += 1;
                case ENEMY_PRIMARY, ENEMY_SECONDARY -> count += 2;
                default -> {}
            }
             
            switch (mpaint64) {
                case EMPTY -> count += 1;
                case ENEMY_PRIMARY, ENEMY_SECONDARY -> count += 2;
                default -> {}
            }
            
            
            if (count > bestCount) {
                bestLoc = mloc53;
                bestCount = count;
            }
        }
        
        if (rc.canAttack(mloc54)) {
            count = 0;
            
             
            switch (mpaint43) {
                case EMPTY -> count += 1;
                case ENEMY_PRIMARY, ENEMY_SECONDARY -> count += 2;
                default -> {}
            }
             
            switch (mpaint44) {
                case EMPTY -> count += 1;
                case ENEMY_PRIMARY, ENEMY_SECONDARY -> count += 2;
                default -> {}
            }
             
            switch (mpaint45) {
                case EMPTY -> count += 1;
                case ENEMY_PRIMARY, ENEMY_SECONDARY -> count += 2;
                default -> {}
            }
            
            
             
            switch (mpaint53) {
                case EMPTY -> count += 1;
                case ENEMY_PRIMARY, ENEMY_SECONDARY -> count += 2;
                default -> {}
            }
             
            switch (mpaint54) {
                case EMPTY -> count += 1;
                case ENEMY_PRIMARY, ENEMY_SECONDARY -> count += 2;
                default -> {}
            }
             
            switch (mpaint55) {
                case EMPTY -> count += 1;
                case ENEMY_PRIMARY, ENEMY_SECONDARY -> count += 2;
                default -> {}
            }
            
            
             
            switch (mpaint63) {
                case EMPTY -> count += 1;
                case ENEMY_PRIMARY, ENEMY_SECONDARY -> count += 2;
                default -> {}
            }
             
            switch (mpaint64) {
                case EMPTY -> count += 1;
                case ENEMY_PRIMARY, ENEMY_SECONDARY -> count += 2;
                default -> {}
            }
             
            switch (mpaint65) {
                case EMPTY -> count += 1;
                case ENEMY_PRIMARY, ENEMY_SECONDARY -> count += 2;
                default -> {}
            }
            
            
            if (count > bestCount) {
                bestLoc = mloc54;
                bestCount = count;
            }
        }
        
        if (rc.canAttack(mloc55)) {
            count = 0;
            
             
            switch (mpaint44) {
                case EMPTY -> count += 1;
                case ENEMY_PRIMARY, ENEMY_SECONDARY -> count += 2;
                default -> {}
            }
             
            switch (mpaint45) {
                case EMPTY -> count += 1;
                case ENEMY_PRIMARY, ENEMY_SECONDARY -> count += 2;
                default -> {}
            }
             
            switch (mpaint46) {
                case EMPTY -> count += 1;
                case ENEMY_PRIMARY, ENEMY_SECONDARY -> count += 2;
                default -> {}
            }
            
            
             
            switch (mpaint54) {
                case EMPTY -> count += 1;
                case ENEMY_PRIMARY, ENEMY_SECONDARY -> count += 2;
                default -> {}
            }
             
            switch (mpaint55) {
                case EMPTY -> count += 1;
                case ENEMY_PRIMARY, ENEMY_SECONDARY -> count += 2;
                default -> {}
            }
             
            switch (mpaint56) {
                case EMPTY -> count += 1;
                case ENEMY_PRIMARY, ENEMY_SECONDARY -> count += 2;
                default -> {}
            }
            
            
             
            switch (mpaint64) {
                case EMPTY -> count += 1;
                case ENEMY_PRIMARY, ENEMY_SECONDARY -> count += 2;
                default -> {}
            }
             
            switch (mpaint65) {
                case EMPTY -> count += 1;
                case ENEMY_PRIMARY, ENEMY_SECONDARY -> count += 2;
                default -> {}
            }
             
            switch (mpaint66) {
                case EMPTY -> count += 1;
                case ENEMY_PRIMARY, ENEMY_SECONDARY -> count += 2;
                default -> {}
            }
            
            
            if (count > bestCount) {
                bestLoc = mloc55;
                bestCount = count;
            }
        }
        
        

        
        if (bestCount > 5) {
            rc.attack(bestLoc);
        }
    }
}