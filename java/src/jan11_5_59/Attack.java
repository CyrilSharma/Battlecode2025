package jan11_5_59;
import battlecode.common.*;

public class Attack {
    public static RobotController rc;

    
    public static int soldierActionRadiusSquared;
    public static int soldierPaintCapacity;
    public static int soldierActionCooldown;
    public static int soldierAttackStrength;
    public static int splasherActionRadiusSquared;
    public static int splasherPaintCapacity;
    public static int splasherActionCooldown;
    public static int splasherAttackStrength;
    public static int mopperActionRadiusSquared;
    public static int mopperPaintCapacity;
    public static int mopperActionCooldown;
    public static int mopperAttackStrength;
    public static void init(RobotController rc) {
        Attack.rc = rc;
        soldierActionRadiusSquared = UnitType.SOLDIER.actionRadiusSquared;
        soldierPaintCapacity = UnitType.SOLDIER.paintCapacity;
        soldierActionCooldown = UnitType.SOLDIER.actionCooldown;
        soldierAttackStrength = UnitType.SOLDIER.attackStrength;
        splasherActionRadiusSquared = UnitType.SPLASHER.actionRadiusSquared;
        splasherPaintCapacity = UnitType.SPLASHER.paintCapacity;
        splasherActionCooldown = UnitType.SPLASHER.actionCooldown;
        splasherAttackStrength = UnitType.SPLASHER.attackStrength;
        mopperActionRadiusSquared = UnitType.MOPPER.actionRadiusSquared;
        mopperPaintCapacity = UnitType.MOPPER.paintCapacity;
        mopperActionCooldown = UnitType.MOPPER.actionCooldown;
        mopperAttackStrength = UnitType.MOPPER.attackStrength;
        
    }

    public static boolean shouldSoldierMicro() throws GameActionException {
        for (int i = Globals.enemies.length; --i >= 0; ) {
            switch (Globals.enemies[i].type) {
                case SOLDIER, MOPPER, SPLASHER: continue;
                default: return true;
            }
        }
        return false;
    }

    public static void soldierTryAttack() throws GameActionException {
        for (int i = Globals.enemies.length; --i >= 0;) {
            RobotInfo enemy = Globals.enemies[i];
            switch (enemy.type) {
                case SOLDIER, SPLASHER, MOPPER: continue;
                default: {
                    MapLocation loc = enemy.location;
                    if (rc.canAttack(loc)) {
                        rc.attack(loc);
                        return;
                    }
                }
            }
        }
    }

    public static boolean shouldSplasherMicro() throws GameActionException {
        // Only activate micro if you can attack a tower.
        for (int i = Globals.enemies.length; --i >= 0; ) {
            switch (Globals.enemies[i].type) {
                case SOLDIER, MOPPER, SPLASHER: continue;
                default: return true;
            }
        }
        return false;
    }

    public static void splasherTryAttack() throws GameActionException {
        // Not quite correct, we should choose the best spot nearby.
        for (int i = Globals.enemies.length; --i >= 0;) {
            RobotInfo enemy = Globals.enemies[i];
            switch (enemy.type) {
                case SOLDIER, SPLASHER, MOPPER: continue;
                default: {
                    MapLocation loc = enemy.location;
                    if (rc.canAttack(loc)) {
                        rc.attack(loc);
                        return;
                    }
                }
            }
        }
    }

    public static boolean shouldMopperMicro() throws GameActionException {
        for (int i = Globals.enemies.length; --i >= 0; ) {
            switch (Globals.enemies[i].type) {
                case SOLDIER, MOPPER, SPLASHER: {
                    if (Globals.enemies[i].paintAmount != 0) return true;
                };
                default: continue;
            }
        }
        return false;
    }

    public static void mopperTryAttack() throws GameActionException {
        MapLocation bestThreatLoc = null;
        int smallestThreatPaint = 100000000;
        MapLocation bestNonThreatLoc = null;
        int smallestNonThreatPaint = 100000000;
        for (int i = Globals.enemies.length; --i >= 0;) {
            RobotInfo enemy = Globals.enemies[i];
            if (enemy.paintAmount == 0) continue;
            MapLocation loc = enemy.location;
            switch (enemy.type) {
                case MOPPER, SPLASHER -> {
                    if (rc.canAttack(loc) && enemy.paintAmount < smallestThreatPaint) {
                        bestThreatLoc = loc;
                        smallestThreatPaint = enemy.paintAmount;
                    }
                }
                case SOLDIER -> {
                    if (rc.canAttack(loc) && enemy.paintAmount < smallestNonThreatPaint) {
                        bestNonThreatLoc = loc;
                        smallestNonThreatPaint = enemy.paintAmount;
                    }
                }
                default -> {}
            }
        }

        if (bestThreatLoc != null) {
            rc.setIndicatorString("Attacking Threat!");
            rc.setIndicatorDot(bestThreatLoc, 0, 0, 0);
            rc.attack(bestThreatLoc);
        } else if (bestNonThreatLoc != null) {
            rc.setIndicatorString("Attacking Normal!");
            rc.setIndicatorDot(bestNonThreatLoc, 0, 0, 0);
            rc.attack(bestNonThreatLoc);
        } else {
            rc.setIndicatorString("Didn't Attack!");
        }
    }
    
    /*------------------ CHOOSE BEST --------------------*//* ################## CHOOSE BEST #################### */


    /*------------------ ADD ALLY --------------------*//* ################## ADD ALLY #################### */

    /*------------------ ADD ENEMY --------------------*/
    
    /* ################## ADD ENEMY #################### */

    /* TODO: Allow moving on enemy paint? */
    /*------------------ INIT TARGET --------------------*//* ################## INIT TARGET #################### */
    
    /*------------------ COPY --------------------*/
    /* ################## COPY #################### */

    
    public static void soldierAttackMicro() throws GameActionException {
        soldierTryAttack();
        MapLocation myloc = rc.getLocation();
        MapLocation targetLoc_N = myloc.add(Direction.NORTH);
        boolean canMove_N = (rc.canMove(Direction.NORTH));
        PaintType paint_N = PaintType.ENEMY_PRIMARY;
        if (rc.canSenseLocation(targetLoc_N)) {
            paint_N = rc.senseMapInfo(targetLoc_N).getPaint();
            switch (rc.senseMapInfo(targetLoc_N).getPaint()) {
                 case PaintType.ENEMY_PRIMARY -> canMove_N = false;
                 case PaintType.ENEMY_SECONDARY -> canMove_N = false;
                 default -> {}
            }
        }
        double healthDmgAttackRange_N = 0;
        double myHealthDmg_N = 0;
        int minDistToEnemy_N = 100000;
        
        MapLocation targetLoc_NE = myloc.add(Direction.NORTHEAST);
        boolean canMove_NE = (rc.canMove(Direction.NORTHEAST));
        PaintType paint_NE = PaintType.ENEMY_PRIMARY;
        if (rc.canSenseLocation(targetLoc_NE)) {
            paint_NE = rc.senseMapInfo(targetLoc_NE).getPaint();
            switch (rc.senseMapInfo(targetLoc_NE).getPaint()) {
                 case PaintType.ENEMY_PRIMARY -> canMove_NE = false;
                 case PaintType.ENEMY_SECONDARY -> canMove_NE = false;
                 default -> {}
            }
        }
        double healthDmgAttackRange_NE = 0;
        double myHealthDmg_NE = 0;
        int minDistToEnemy_NE = 100000;
        
        MapLocation targetLoc_E = myloc.add(Direction.EAST);
        boolean canMove_E = (rc.canMove(Direction.EAST));
        PaintType paint_E = PaintType.ENEMY_PRIMARY;
        if (rc.canSenseLocation(targetLoc_E)) {
            paint_E = rc.senseMapInfo(targetLoc_E).getPaint();
            switch (rc.senseMapInfo(targetLoc_E).getPaint()) {
                 case PaintType.ENEMY_PRIMARY -> canMove_E = false;
                 case PaintType.ENEMY_SECONDARY -> canMove_E = false;
                 default -> {}
            }
        }
        double healthDmgAttackRange_E = 0;
        double myHealthDmg_E = 0;
        int minDistToEnemy_E = 100000;
        
        MapLocation targetLoc_SE = myloc.add(Direction.SOUTHEAST);
        boolean canMove_SE = (rc.canMove(Direction.SOUTHEAST));
        PaintType paint_SE = PaintType.ENEMY_PRIMARY;
        if (rc.canSenseLocation(targetLoc_SE)) {
            paint_SE = rc.senseMapInfo(targetLoc_SE).getPaint();
            switch (rc.senseMapInfo(targetLoc_SE).getPaint()) {
                 case PaintType.ENEMY_PRIMARY -> canMove_SE = false;
                 case PaintType.ENEMY_SECONDARY -> canMove_SE = false;
                 default -> {}
            }
        }
        double healthDmgAttackRange_SE = 0;
        double myHealthDmg_SE = 0;
        int minDistToEnemy_SE = 100000;
        
        MapLocation targetLoc_S = myloc.add(Direction.SOUTH);
        boolean canMove_S = (rc.canMove(Direction.SOUTH));
        PaintType paint_S = PaintType.ENEMY_PRIMARY;
        if (rc.canSenseLocation(targetLoc_S)) {
            paint_S = rc.senseMapInfo(targetLoc_S).getPaint();
            switch (rc.senseMapInfo(targetLoc_S).getPaint()) {
                 case PaintType.ENEMY_PRIMARY -> canMove_S = false;
                 case PaintType.ENEMY_SECONDARY -> canMove_S = false;
                 default -> {}
            }
        }
        double healthDmgAttackRange_S = 0;
        double myHealthDmg_S = 0;
        int minDistToEnemy_S = 100000;
        
        MapLocation targetLoc_SW = myloc.add(Direction.SOUTHWEST);
        boolean canMove_SW = (rc.canMove(Direction.SOUTHWEST));
        PaintType paint_SW = PaintType.ENEMY_PRIMARY;
        if (rc.canSenseLocation(targetLoc_SW)) {
            paint_SW = rc.senseMapInfo(targetLoc_SW).getPaint();
            switch (rc.senseMapInfo(targetLoc_SW).getPaint()) {
                 case PaintType.ENEMY_PRIMARY -> canMove_SW = false;
                 case PaintType.ENEMY_SECONDARY -> canMove_SW = false;
                 default -> {}
            }
        }
        double healthDmgAttackRange_SW = 0;
        double myHealthDmg_SW = 0;
        int minDistToEnemy_SW = 100000;
        
        MapLocation targetLoc_W = myloc.add(Direction.WEST);
        boolean canMove_W = (rc.canMove(Direction.WEST));
        PaintType paint_W = PaintType.ENEMY_PRIMARY;
        if (rc.canSenseLocation(targetLoc_W)) {
            paint_W = rc.senseMapInfo(targetLoc_W).getPaint();
            switch (rc.senseMapInfo(targetLoc_W).getPaint()) {
                 case PaintType.ENEMY_PRIMARY -> canMove_W = false;
                 case PaintType.ENEMY_SECONDARY -> canMove_W = false;
                 default -> {}
            }
        }
        double healthDmgAttackRange_W = 0;
        double myHealthDmg_W = 0;
        int minDistToEnemy_W = 100000;
        
        MapLocation targetLoc_NW = myloc.add(Direction.NORTHWEST);
        boolean canMove_NW = (rc.canMove(Direction.NORTHWEST));
        PaintType paint_NW = PaintType.ENEMY_PRIMARY;
        if (rc.canSenseLocation(targetLoc_NW)) {
            paint_NW = rc.senseMapInfo(targetLoc_NW).getPaint();
            switch (rc.senseMapInfo(targetLoc_NW).getPaint()) {
                 case PaintType.ENEMY_PRIMARY -> canMove_NW = false;
                 case PaintType.ENEMY_SECONDARY -> canMove_NW = false;
                 default -> {}
            }
        }
        double healthDmgAttackRange_NW = 0;
        double myHealthDmg_NW = 0;
        int minDistToEnemy_NW = 100000;
        
        MapLocation targetLoc_C = myloc.add(Direction.CENTER);
        boolean canMove_C = (true);
        PaintType paint_C = PaintType.ENEMY_PRIMARY;
        if (rc.canSenseLocation(targetLoc_C)) {
            paint_C = rc.senseMapInfo(targetLoc_C).getPaint();
            switch (rc.senseMapInfo(targetLoc_C).getPaint()) {
                 case PaintType.ENEMY_PRIMARY -> canMove_C = false;
                 case PaintType.ENEMY_SECONDARY -> canMove_C = false;
                 default -> {}
            }
        }
        double healthDmgAttackRange_C = 0;
        double myHealthDmg_C = 0;
        int minDistToEnemy_C = 100000;
        
        boolean actionReady = rc.isActionReady();
        for (int i = Globals.friends.length; --i >= 0; ) {
            RobotInfo robot = Globals.friends[i];
            addAllyN: {
                
            }
            addAllyNE: {
                
            }
            addAllyE: {
                
            }
            addAllySE: {
                
            }
            addAllyS: {
                
            }
            addAllySW: {
                
            }
            addAllyW: {
                
            }
            addAllyNW: {
                
            }
            addAllyC: {
                
            }
            
        }

        for (int i = Globals.enemies.length; --i >= 0; ) {
            RobotInfo robot = Globals.enemies[i];
            
            addEnemyN: {
                if (!canMove_N) break addEnemyN;
                int d = targetLoc_N.distanceSquaredTo(robot.location);
                switch (robot.type) {
                    case LEVEL_ONE_DEFENSE_TOWER: {
                        if (actionReady && d <= soldierActionRadiusSquared) {
                            myHealthDmg_N = soldierAttackStrength;
                        }
                        if (d <= UnitType.LEVEL_ONE_DEFENSE_TOWER.actionRadiusSquared) {
                            // Should have another one for AOE damage.
                            healthDmgAttackRange_N += UnitType.LEVEL_ONE_DEFENSE_TOWER.attackStrength;
                        }
                        if (d < minDistToEnemy_N) minDistToEnemy_N = d;
                        break addEnemyN;
                    }
                    case LEVEL_ONE_MONEY_TOWER: {
                        if (actionReady && d <= soldierActionRadiusSquared) {
                            myHealthDmg_N = soldierAttackStrength;
                        }
                        if (d <= UnitType.LEVEL_ONE_MONEY_TOWER.actionRadiusSquared) {
                            // Should have another one for AOE damage.
                            healthDmgAttackRange_N += UnitType.LEVEL_ONE_MONEY_TOWER.attackStrength;
                        }
                        if (d < minDistToEnemy_N) minDistToEnemy_N = d;
                        break addEnemyN;
                    }
                    case LEVEL_ONE_PAINT_TOWER: {
                        if (actionReady && d <= soldierActionRadiusSquared) {
                            myHealthDmg_N = soldierAttackStrength;
                        }
                        if (d <= UnitType.LEVEL_ONE_PAINT_TOWER.actionRadiusSquared) {
                            // Should have another one for AOE damage.
                            healthDmgAttackRange_N += UnitType.LEVEL_ONE_PAINT_TOWER.attackStrength;
                        }
                        if (d < minDistToEnemy_N) minDistToEnemy_N = d;
                        break addEnemyN;
                    }
                    case LEVEL_THREE_DEFENSE_TOWER: {
                        if (actionReady && d <= soldierActionRadiusSquared) {
                            myHealthDmg_N = soldierAttackStrength;
                        }
                        if (d <= UnitType.LEVEL_THREE_DEFENSE_TOWER.actionRadiusSquared) {
                            // Should have another one for AOE damage.
                            healthDmgAttackRange_N += UnitType.LEVEL_THREE_DEFENSE_TOWER.attackStrength;
                        }
                        if (d < minDistToEnemy_N) minDistToEnemy_N = d;
                        break addEnemyN;
                    }
                    case LEVEL_THREE_MONEY_TOWER: {
                        if (actionReady && d <= soldierActionRadiusSquared) {
                            myHealthDmg_N = soldierAttackStrength;
                        }
                        if (d <= UnitType.LEVEL_THREE_MONEY_TOWER.actionRadiusSquared) {
                            // Should have another one for AOE damage.
                            healthDmgAttackRange_N += UnitType.LEVEL_THREE_MONEY_TOWER.attackStrength;
                        }
                        if (d < minDistToEnemy_N) minDistToEnemy_N = d;
                        break addEnemyN;
                    }
                    case LEVEL_THREE_PAINT_TOWER: {
                        if (actionReady && d <= soldierActionRadiusSquared) {
                            myHealthDmg_N = soldierAttackStrength;
                        }
                        if (d <= UnitType.LEVEL_THREE_PAINT_TOWER.actionRadiusSquared) {
                            // Should have another one for AOE damage.
                            healthDmgAttackRange_N += UnitType.LEVEL_THREE_PAINT_TOWER.attackStrength;
                        }
                        if (d < minDistToEnemy_N) minDistToEnemy_N = d;
                        break addEnemyN;
                    }
                    case LEVEL_TWO_DEFENSE_TOWER: {
                        if (actionReady && d <= soldierActionRadiusSquared) {
                            myHealthDmg_N = soldierAttackStrength;
                        }
                        if (d <= UnitType.LEVEL_TWO_DEFENSE_TOWER.actionRadiusSquared) {
                            // Should have another one for AOE damage.
                            healthDmgAttackRange_N += UnitType.LEVEL_TWO_DEFENSE_TOWER.attackStrength;
                        }
                        if (d < minDistToEnemy_N) minDistToEnemy_N = d;
                        break addEnemyN;
                    }
                    case LEVEL_TWO_MONEY_TOWER: {
                        if (actionReady && d <= soldierActionRadiusSquared) {
                            myHealthDmg_N = soldierAttackStrength;
                        }
                        if (d <= UnitType.LEVEL_TWO_MONEY_TOWER.actionRadiusSquared) {
                            // Should have another one for AOE damage.
                            healthDmgAttackRange_N += UnitType.LEVEL_TWO_MONEY_TOWER.attackStrength;
                        }
                        if (d < minDistToEnemy_N) minDistToEnemy_N = d;
                        break addEnemyN;
                    }
                    case LEVEL_TWO_PAINT_TOWER: {
                        if (actionReady && d <= soldierActionRadiusSquared) {
                            myHealthDmg_N = soldierAttackStrength;
                        }
                        if (d <= UnitType.LEVEL_TWO_PAINT_TOWER.actionRadiusSquared) {
                            // Should have another one for AOE damage.
                            healthDmgAttackRange_N += UnitType.LEVEL_TWO_PAINT_TOWER.attackStrength;
                        }
                        if (d < minDistToEnemy_N) minDistToEnemy_N = d;
                        break addEnemyN;
                    }
                    
                    default: break addEnemyN;
                }
            }
            
            addEnemyNE: {
                if (!canMove_NE) break addEnemyNE;
                int d = targetLoc_NE.distanceSquaredTo(robot.location);
                switch (robot.type) {
                    case LEVEL_ONE_DEFENSE_TOWER: {
                        if (actionReady && d <= soldierActionRadiusSquared) {
                            myHealthDmg_NE = soldierAttackStrength;
                        }
                        if (d <= UnitType.LEVEL_ONE_DEFENSE_TOWER.actionRadiusSquared) {
                            // Should have another one for AOE damage.
                            healthDmgAttackRange_NE += UnitType.LEVEL_ONE_DEFENSE_TOWER.attackStrength;
                        }
                        if (d < minDistToEnemy_NE) minDistToEnemy_NE = d;
                        break addEnemyNE;
                    }
                    case LEVEL_ONE_MONEY_TOWER: {
                        if (actionReady && d <= soldierActionRadiusSquared) {
                            myHealthDmg_NE = soldierAttackStrength;
                        }
                        if (d <= UnitType.LEVEL_ONE_MONEY_TOWER.actionRadiusSquared) {
                            // Should have another one for AOE damage.
                            healthDmgAttackRange_NE += UnitType.LEVEL_ONE_MONEY_TOWER.attackStrength;
                        }
                        if (d < minDistToEnemy_NE) minDistToEnemy_NE = d;
                        break addEnemyNE;
                    }
                    case LEVEL_ONE_PAINT_TOWER: {
                        if (actionReady && d <= soldierActionRadiusSquared) {
                            myHealthDmg_NE = soldierAttackStrength;
                        }
                        if (d <= UnitType.LEVEL_ONE_PAINT_TOWER.actionRadiusSquared) {
                            // Should have another one for AOE damage.
                            healthDmgAttackRange_NE += UnitType.LEVEL_ONE_PAINT_TOWER.attackStrength;
                        }
                        if (d < minDistToEnemy_NE) minDistToEnemy_NE = d;
                        break addEnemyNE;
                    }
                    case LEVEL_THREE_DEFENSE_TOWER: {
                        if (actionReady && d <= soldierActionRadiusSquared) {
                            myHealthDmg_NE = soldierAttackStrength;
                        }
                        if (d <= UnitType.LEVEL_THREE_DEFENSE_TOWER.actionRadiusSquared) {
                            // Should have another one for AOE damage.
                            healthDmgAttackRange_NE += UnitType.LEVEL_THREE_DEFENSE_TOWER.attackStrength;
                        }
                        if (d < minDistToEnemy_NE) minDistToEnemy_NE = d;
                        break addEnemyNE;
                    }
                    case LEVEL_THREE_MONEY_TOWER: {
                        if (actionReady && d <= soldierActionRadiusSquared) {
                            myHealthDmg_NE = soldierAttackStrength;
                        }
                        if (d <= UnitType.LEVEL_THREE_MONEY_TOWER.actionRadiusSquared) {
                            // Should have another one for AOE damage.
                            healthDmgAttackRange_NE += UnitType.LEVEL_THREE_MONEY_TOWER.attackStrength;
                        }
                        if (d < minDistToEnemy_NE) minDistToEnemy_NE = d;
                        break addEnemyNE;
                    }
                    case LEVEL_THREE_PAINT_TOWER: {
                        if (actionReady && d <= soldierActionRadiusSquared) {
                            myHealthDmg_NE = soldierAttackStrength;
                        }
                        if (d <= UnitType.LEVEL_THREE_PAINT_TOWER.actionRadiusSquared) {
                            // Should have another one for AOE damage.
                            healthDmgAttackRange_NE += UnitType.LEVEL_THREE_PAINT_TOWER.attackStrength;
                        }
                        if (d < minDistToEnemy_NE) minDistToEnemy_NE = d;
                        break addEnemyNE;
                    }
                    case LEVEL_TWO_DEFENSE_TOWER: {
                        if (actionReady && d <= soldierActionRadiusSquared) {
                            myHealthDmg_NE = soldierAttackStrength;
                        }
                        if (d <= UnitType.LEVEL_TWO_DEFENSE_TOWER.actionRadiusSquared) {
                            // Should have another one for AOE damage.
                            healthDmgAttackRange_NE += UnitType.LEVEL_TWO_DEFENSE_TOWER.attackStrength;
                        }
                        if (d < minDistToEnemy_NE) minDistToEnemy_NE = d;
                        break addEnemyNE;
                    }
                    case LEVEL_TWO_MONEY_TOWER: {
                        if (actionReady && d <= soldierActionRadiusSquared) {
                            myHealthDmg_NE = soldierAttackStrength;
                        }
                        if (d <= UnitType.LEVEL_TWO_MONEY_TOWER.actionRadiusSquared) {
                            // Should have another one for AOE damage.
                            healthDmgAttackRange_NE += UnitType.LEVEL_TWO_MONEY_TOWER.attackStrength;
                        }
                        if (d < minDistToEnemy_NE) minDistToEnemy_NE = d;
                        break addEnemyNE;
                    }
                    case LEVEL_TWO_PAINT_TOWER: {
                        if (actionReady && d <= soldierActionRadiusSquared) {
                            myHealthDmg_NE = soldierAttackStrength;
                        }
                        if (d <= UnitType.LEVEL_TWO_PAINT_TOWER.actionRadiusSquared) {
                            // Should have another one for AOE damage.
                            healthDmgAttackRange_NE += UnitType.LEVEL_TWO_PAINT_TOWER.attackStrength;
                        }
                        if (d < minDistToEnemy_NE) minDistToEnemy_NE = d;
                        break addEnemyNE;
                    }
                    
                    default: break addEnemyNE;
                }
            }
            
            addEnemyE: {
                if (!canMove_E) break addEnemyE;
                int d = targetLoc_E.distanceSquaredTo(robot.location);
                switch (robot.type) {
                    case LEVEL_ONE_DEFENSE_TOWER: {
                        if (actionReady && d <= soldierActionRadiusSquared) {
                            myHealthDmg_E = soldierAttackStrength;
                        }
                        if (d <= UnitType.LEVEL_ONE_DEFENSE_TOWER.actionRadiusSquared) {
                            // Should have another one for AOE damage.
                            healthDmgAttackRange_E += UnitType.LEVEL_ONE_DEFENSE_TOWER.attackStrength;
                        }
                        if (d < minDistToEnemy_E) minDistToEnemy_E = d;
                        break addEnemyE;
                    }
                    case LEVEL_ONE_MONEY_TOWER: {
                        if (actionReady && d <= soldierActionRadiusSquared) {
                            myHealthDmg_E = soldierAttackStrength;
                        }
                        if (d <= UnitType.LEVEL_ONE_MONEY_TOWER.actionRadiusSquared) {
                            // Should have another one for AOE damage.
                            healthDmgAttackRange_E += UnitType.LEVEL_ONE_MONEY_TOWER.attackStrength;
                        }
                        if (d < minDistToEnemy_E) minDistToEnemy_E = d;
                        break addEnemyE;
                    }
                    case LEVEL_ONE_PAINT_TOWER: {
                        if (actionReady && d <= soldierActionRadiusSquared) {
                            myHealthDmg_E = soldierAttackStrength;
                        }
                        if (d <= UnitType.LEVEL_ONE_PAINT_TOWER.actionRadiusSquared) {
                            // Should have another one for AOE damage.
                            healthDmgAttackRange_E += UnitType.LEVEL_ONE_PAINT_TOWER.attackStrength;
                        }
                        if (d < minDistToEnemy_E) minDistToEnemy_E = d;
                        break addEnemyE;
                    }
                    case LEVEL_THREE_DEFENSE_TOWER: {
                        if (actionReady && d <= soldierActionRadiusSquared) {
                            myHealthDmg_E = soldierAttackStrength;
                        }
                        if (d <= UnitType.LEVEL_THREE_DEFENSE_TOWER.actionRadiusSquared) {
                            // Should have another one for AOE damage.
                            healthDmgAttackRange_E += UnitType.LEVEL_THREE_DEFENSE_TOWER.attackStrength;
                        }
                        if (d < minDistToEnemy_E) minDistToEnemy_E = d;
                        break addEnemyE;
                    }
                    case LEVEL_THREE_MONEY_TOWER: {
                        if (actionReady && d <= soldierActionRadiusSquared) {
                            myHealthDmg_E = soldierAttackStrength;
                        }
                        if (d <= UnitType.LEVEL_THREE_MONEY_TOWER.actionRadiusSquared) {
                            // Should have another one for AOE damage.
                            healthDmgAttackRange_E += UnitType.LEVEL_THREE_MONEY_TOWER.attackStrength;
                        }
                        if (d < minDistToEnemy_E) minDistToEnemy_E = d;
                        break addEnemyE;
                    }
                    case LEVEL_THREE_PAINT_TOWER: {
                        if (actionReady && d <= soldierActionRadiusSquared) {
                            myHealthDmg_E = soldierAttackStrength;
                        }
                        if (d <= UnitType.LEVEL_THREE_PAINT_TOWER.actionRadiusSquared) {
                            // Should have another one for AOE damage.
                            healthDmgAttackRange_E += UnitType.LEVEL_THREE_PAINT_TOWER.attackStrength;
                        }
                        if (d < minDistToEnemy_E) minDistToEnemy_E = d;
                        break addEnemyE;
                    }
                    case LEVEL_TWO_DEFENSE_TOWER: {
                        if (actionReady && d <= soldierActionRadiusSquared) {
                            myHealthDmg_E = soldierAttackStrength;
                        }
                        if (d <= UnitType.LEVEL_TWO_DEFENSE_TOWER.actionRadiusSquared) {
                            // Should have another one for AOE damage.
                            healthDmgAttackRange_E += UnitType.LEVEL_TWO_DEFENSE_TOWER.attackStrength;
                        }
                        if (d < minDistToEnemy_E) minDistToEnemy_E = d;
                        break addEnemyE;
                    }
                    case LEVEL_TWO_MONEY_TOWER: {
                        if (actionReady && d <= soldierActionRadiusSquared) {
                            myHealthDmg_E = soldierAttackStrength;
                        }
                        if (d <= UnitType.LEVEL_TWO_MONEY_TOWER.actionRadiusSquared) {
                            // Should have another one for AOE damage.
                            healthDmgAttackRange_E += UnitType.LEVEL_TWO_MONEY_TOWER.attackStrength;
                        }
                        if (d < minDistToEnemy_E) minDistToEnemy_E = d;
                        break addEnemyE;
                    }
                    case LEVEL_TWO_PAINT_TOWER: {
                        if (actionReady && d <= soldierActionRadiusSquared) {
                            myHealthDmg_E = soldierAttackStrength;
                        }
                        if (d <= UnitType.LEVEL_TWO_PAINT_TOWER.actionRadiusSquared) {
                            // Should have another one for AOE damage.
                            healthDmgAttackRange_E += UnitType.LEVEL_TWO_PAINT_TOWER.attackStrength;
                        }
                        if (d < minDistToEnemy_E) minDistToEnemy_E = d;
                        break addEnemyE;
                    }
                    
                    default: break addEnemyE;
                }
            }
            
            addEnemySE: {
                if (!canMove_SE) break addEnemySE;
                int d = targetLoc_SE.distanceSquaredTo(robot.location);
                switch (robot.type) {
                    case LEVEL_ONE_DEFENSE_TOWER: {
                        if (actionReady && d <= soldierActionRadiusSquared) {
                            myHealthDmg_SE = soldierAttackStrength;
                        }
                        if (d <= UnitType.LEVEL_ONE_DEFENSE_TOWER.actionRadiusSquared) {
                            // Should have another one for AOE damage.
                            healthDmgAttackRange_SE += UnitType.LEVEL_ONE_DEFENSE_TOWER.attackStrength;
                        }
                        if (d < minDistToEnemy_SE) minDistToEnemy_SE = d;
                        break addEnemySE;
                    }
                    case LEVEL_ONE_MONEY_TOWER: {
                        if (actionReady && d <= soldierActionRadiusSquared) {
                            myHealthDmg_SE = soldierAttackStrength;
                        }
                        if (d <= UnitType.LEVEL_ONE_MONEY_TOWER.actionRadiusSquared) {
                            // Should have another one for AOE damage.
                            healthDmgAttackRange_SE += UnitType.LEVEL_ONE_MONEY_TOWER.attackStrength;
                        }
                        if (d < minDistToEnemy_SE) minDistToEnemy_SE = d;
                        break addEnemySE;
                    }
                    case LEVEL_ONE_PAINT_TOWER: {
                        if (actionReady && d <= soldierActionRadiusSquared) {
                            myHealthDmg_SE = soldierAttackStrength;
                        }
                        if (d <= UnitType.LEVEL_ONE_PAINT_TOWER.actionRadiusSquared) {
                            // Should have another one for AOE damage.
                            healthDmgAttackRange_SE += UnitType.LEVEL_ONE_PAINT_TOWER.attackStrength;
                        }
                        if (d < minDistToEnemy_SE) minDistToEnemy_SE = d;
                        break addEnemySE;
                    }
                    case LEVEL_THREE_DEFENSE_TOWER: {
                        if (actionReady && d <= soldierActionRadiusSquared) {
                            myHealthDmg_SE = soldierAttackStrength;
                        }
                        if (d <= UnitType.LEVEL_THREE_DEFENSE_TOWER.actionRadiusSquared) {
                            // Should have another one for AOE damage.
                            healthDmgAttackRange_SE += UnitType.LEVEL_THREE_DEFENSE_TOWER.attackStrength;
                        }
                        if (d < minDistToEnemy_SE) minDistToEnemy_SE = d;
                        break addEnemySE;
                    }
                    case LEVEL_THREE_MONEY_TOWER: {
                        if (actionReady && d <= soldierActionRadiusSquared) {
                            myHealthDmg_SE = soldierAttackStrength;
                        }
                        if (d <= UnitType.LEVEL_THREE_MONEY_TOWER.actionRadiusSquared) {
                            // Should have another one for AOE damage.
                            healthDmgAttackRange_SE += UnitType.LEVEL_THREE_MONEY_TOWER.attackStrength;
                        }
                        if (d < minDistToEnemy_SE) minDistToEnemy_SE = d;
                        break addEnemySE;
                    }
                    case LEVEL_THREE_PAINT_TOWER: {
                        if (actionReady && d <= soldierActionRadiusSquared) {
                            myHealthDmg_SE = soldierAttackStrength;
                        }
                        if (d <= UnitType.LEVEL_THREE_PAINT_TOWER.actionRadiusSquared) {
                            // Should have another one for AOE damage.
                            healthDmgAttackRange_SE += UnitType.LEVEL_THREE_PAINT_TOWER.attackStrength;
                        }
                        if (d < minDistToEnemy_SE) minDistToEnemy_SE = d;
                        break addEnemySE;
                    }
                    case LEVEL_TWO_DEFENSE_TOWER: {
                        if (actionReady && d <= soldierActionRadiusSquared) {
                            myHealthDmg_SE = soldierAttackStrength;
                        }
                        if (d <= UnitType.LEVEL_TWO_DEFENSE_TOWER.actionRadiusSquared) {
                            // Should have another one for AOE damage.
                            healthDmgAttackRange_SE += UnitType.LEVEL_TWO_DEFENSE_TOWER.attackStrength;
                        }
                        if (d < minDistToEnemy_SE) minDistToEnemy_SE = d;
                        break addEnemySE;
                    }
                    case LEVEL_TWO_MONEY_TOWER: {
                        if (actionReady && d <= soldierActionRadiusSquared) {
                            myHealthDmg_SE = soldierAttackStrength;
                        }
                        if (d <= UnitType.LEVEL_TWO_MONEY_TOWER.actionRadiusSquared) {
                            // Should have another one for AOE damage.
                            healthDmgAttackRange_SE += UnitType.LEVEL_TWO_MONEY_TOWER.attackStrength;
                        }
                        if (d < minDistToEnemy_SE) minDistToEnemy_SE = d;
                        break addEnemySE;
                    }
                    case LEVEL_TWO_PAINT_TOWER: {
                        if (actionReady && d <= soldierActionRadiusSquared) {
                            myHealthDmg_SE = soldierAttackStrength;
                        }
                        if (d <= UnitType.LEVEL_TWO_PAINT_TOWER.actionRadiusSquared) {
                            // Should have another one for AOE damage.
                            healthDmgAttackRange_SE += UnitType.LEVEL_TWO_PAINT_TOWER.attackStrength;
                        }
                        if (d < minDistToEnemy_SE) minDistToEnemy_SE = d;
                        break addEnemySE;
                    }
                    
                    default: break addEnemySE;
                }
            }
            
            addEnemyS: {
                if (!canMove_S) break addEnemyS;
                int d = targetLoc_S.distanceSquaredTo(robot.location);
                switch (robot.type) {
                    case LEVEL_ONE_DEFENSE_TOWER: {
                        if (actionReady && d <= soldierActionRadiusSquared) {
                            myHealthDmg_S = soldierAttackStrength;
                        }
                        if (d <= UnitType.LEVEL_ONE_DEFENSE_TOWER.actionRadiusSquared) {
                            // Should have another one for AOE damage.
                            healthDmgAttackRange_S += UnitType.LEVEL_ONE_DEFENSE_TOWER.attackStrength;
                        }
                        if (d < minDistToEnemy_S) minDistToEnemy_S = d;
                        break addEnemyS;
                    }
                    case LEVEL_ONE_MONEY_TOWER: {
                        if (actionReady && d <= soldierActionRadiusSquared) {
                            myHealthDmg_S = soldierAttackStrength;
                        }
                        if (d <= UnitType.LEVEL_ONE_MONEY_TOWER.actionRadiusSquared) {
                            // Should have another one for AOE damage.
                            healthDmgAttackRange_S += UnitType.LEVEL_ONE_MONEY_TOWER.attackStrength;
                        }
                        if (d < minDistToEnemy_S) minDistToEnemy_S = d;
                        break addEnemyS;
                    }
                    case LEVEL_ONE_PAINT_TOWER: {
                        if (actionReady && d <= soldierActionRadiusSquared) {
                            myHealthDmg_S = soldierAttackStrength;
                        }
                        if (d <= UnitType.LEVEL_ONE_PAINT_TOWER.actionRadiusSquared) {
                            // Should have another one for AOE damage.
                            healthDmgAttackRange_S += UnitType.LEVEL_ONE_PAINT_TOWER.attackStrength;
                        }
                        if (d < minDistToEnemy_S) minDistToEnemy_S = d;
                        break addEnemyS;
                    }
                    case LEVEL_THREE_DEFENSE_TOWER: {
                        if (actionReady && d <= soldierActionRadiusSquared) {
                            myHealthDmg_S = soldierAttackStrength;
                        }
                        if (d <= UnitType.LEVEL_THREE_DEFENSE_TOWER.actionRadiusSquared) {
                            // Should have another one for AOE damage.
                            healthDmgAttackRange_S += UnitType.LEVEL_THREE_DEFENSE_TOWER.attackStrength;
                        }
                        if (d < minDistToEnemy_S) minDistToEnemy_S = d;
                        break addEnemyS;
                    }
                    case LEVEL_THREE_MONEY_TOWER: {
                        if (actionReady && d <= soldierActionRadiusSquared) {
                            myHealthDmg_S = soldierAttackStrength;
                        }
                        if (d <= UnitType.LEVEL_THREE_MONEY_TOWER.actionRadiusSquared) {
                            // Should have another one for AOE damage.
                            healthDmgAttackRange_S += UnitType.LEVEL_THREE_MONEY_TOWER.attackStrength;
                        }
                        if (d < minDistToEnemy_S) minDistToEnemy_S = d;
                        break addEnemyS;
                    }
                    case LEVEL_THREE_PAINT_TOWER: {
                        if (actionReady && d <= soldierActionRadiusSquared) {
                            myHealthDmg_S = soldierAttackStrength;
                        }
                        if (d <= UnitType.LEVEL_THREE_PAINT_TOWER.actionRadiusSquared) {
                            // Should have another one for AOE damage.
                            healthDmgAttackRange_S += UnitType.LEVEL_THREE_PAINT_TOWER.attackStrength;
                        }
                        if (d < minDistToEnemy_S) minDistToEnemy_S = d;
                        break addEnemyS;
                    }
                    case LEVEL_TWO_DEFENSE_TOWER: {
                        if (actionReady && d <= soldierActionRadiusSquared) {
                            myHealthDmg_S = soldierAttackStrength;
                        }
                        if (d <= UnitType.LEVEL_TWO_DEFENSE_TOWER.actionRadiusSquared) {
                            // Should have another one for AOE damage.
                            healthDmgAttackRange_S += UnitType.LEVEL_TWO_DEFENSE_TOWER.attackStrength;
                        }
                        if (d < minDistToEnemy_S) minDistToEnemy_S = d;
                        break addEnemyS;
                    }
                    case LEVEL_TWO_MONEY_TOWER: {
                        if (actionReady && d <= soldierActionRadiusSquared) {
                            myHealthDmg_S = soldierAttackStrength;
                        }
                        if (d <= UnitType.LEVEL_TWO_MONEY_TOWER.actionRadiusSquared) {
                            // Should have another one for AOE damage.
                            healthDmgAttackRange_S += UnitType.LEVEL_TWO_MONEY_TOWER.attackStrength;
                        }
                        if (d < minDistToEnemy_S) minDistToEnemy_S = d;
                        break addEnemyS;
                    }
                    case LEVEL_TWO_PAINT_TOWER: {
                        if (actionReady && d <= soldierActionRadiusSquared) {
                            myHealthDmg_S = soldierAttackStrength;
                        }
                        if (d <= UnitType.LEVEL_TWO_PAINT_TOWER.actionRadiusSquared) {
                            // Should have another one for AOE damage.
                            healthDmgAttackRange_S += UnitType.LEVEL_TWO_PAINT_TOWER.attackStrength;
                        }
                        if (d < minDistToEnemy_S) minDistToEnemy_S = d;
                        break addEnemyS;
                    }
                    
                    default: break addEnemyS;
                }
            }
            
            addEnemySW: {
                if (!canMove_SW) break addEnemySW;
                int d = targetLoc_SW.distanceSquaredTo(robot.location);
                switch (robot.type) {
                    case LEVEL_ONE_DEFENSE_TOWER: {
                        if (actionReady && d <= soldierActionRadiusSquared) {
                            myHealthDmg_SW = soldierAttackStrength;
                        }
                        if (d <= UnitType.LEVEL_ONE_DEFENSE_TOWER.actionRadiusSquared) {
                            // Should have another one for AOE damage.
                            healthDmgAttackRange_SW += UnitType.LEVEL_ONE_DEFENSE_TOWER.attackStrength;
                        }
                        if (d < minDistToEnemy_SW) minDistToEnemy_SW = d;
                        break addEnemySW;
                    }
                    case LEVEL_ONE_MONEY_TOWER: {
                        if (actionReady && d <= soldierActionRadiusSquared) {
                            myHealthDmg_SW = soldierAttackStrength;
                        }
                        if (d <= UnitType.LEVEL_ONE_MONEY_TOWER.actionRadiusSquared) {
                            // Should have another one for AOE damage.
                            healthDmgAttackRange_SW += UnitType.LEVEL_ONE_MONEY_TOWER.attackStrength;
                        }
                        if (d < minDistToEnemy_SW) minDistToEnemy_SW = d;
                        break addEnemySW;
                    }
                    case LEVEL_ONE_PAINT_TOWER: {
                        if (actionReady && d <= soldierActionRadiusSquared) {
                            myHealthDmg_SW = soldierAttackStrength;
                        }
                        if (d <= UnitType.LEVEL_ONE_PAINT_TOWER.actionRadiusSquared) {
                            // Should have another one for AOE damage.
                            healthDmgAttackRange_SW += UnitType.LEVEL_ONE_PAINT_TOWER.attackStrength;
                        }
                        if (d < minDistToEnemy_SW) minDistToEnemy_SW = d;
                        break addEnemySW;
                    }
                    case LEVEL_THREE_DEFENSE_TOWER: {
                        if (actionReady && d <= soldierActionRadiusSquared) {
                            myHealthDmg_SW = soldierAttackStrength;
                        }
                        if (d <= UnitType.LEVEL_THREE_DEFENSE_TOWER.actionRadiusSquared) {
                            // Should have another one for AOE damage.
                            healthDmgAttackRange_SW += UnitType.LEVEL_THREE_DEFENSE_TOWER.attackStrength;
                        }
                        if (d < minDistToEnemy_SW) minDistToEnemy_SW = d;
                        break addEnemySW;
                    }
                    case LEVEL_THREE_MONEY_TOWER: {
                        if (actionReady && d <= soldierActionRadiusSquared) {
                            myHealthDmg_SW = soldierAttackStrength;
                        }
                        if (d <= UnitType.LEVEL_THREE_MONEY_TOWER.actionRadiusSquared) {
                            // Should have another one for AOE damage.
                            healthDmgAttackRange_SW += UnitType.LEVEL_THREE_MONEY_TOWER.attackStrength;
                        }
                        if (d < minDistToEnemy_SW) minDistToEnemy_SW = d;
                        break addEnemySW;
                    }
                    case LEVEL_THREE_PAINT_TOWER: {
                        if (actionReady && d <= soldierActionRadiusSquared) {
                            myHealthDmg_SW = soldierAttackStrength;
                        }
                        if (d <= UnitType.LEVEL_THREE_PAINT_TOWER.actionRadiusSquared) {
                            // Should have another one for AOE damage.
                            healthDmgAttackRange_SW += UnitType.LEVEL_THREE_PAINT_TOWER.attackStrength;
                        }
                        if (d < minDistToEnemy_SW) minDistToEnemy_SW = d;
                        break addEnemySW;
                    }
                    case LEVEL_TWO_DEFENSE_TOWER: {
                        if (actionReady && d <= soldierActionRadiusSquared) {
                            myHealthDmg_SW = soldierAttackStrength;
                        }
                        if (d <= UnitType.LEVEL_TWO_DEFENSE_TOWER.actionRadiusSquared) {
                            // Should have another one for AOE damage.
                            healthDmgAttackRange_SW += UnitType.LEVEL_TWO_DEFENSE_TOWER.attackStrength;
                        }
                        if (d < minDistToEnemy_SW) minDistToEnemy_SW = d;
                        break addEnemySW;
                    }
                    case LEVEL_TWO_MONEY_TOWER: {
                        if (actionReady && d <= soldierActionRadiusSquared) {
                            myHealthDmg_SW = soldierAttackStrength;
                        }
                        if (d <= UnitType.LEVEL_TWO_MONEY_TOWER.actionRadiusSquared) {
                            // Should have another one for AOE damage.
                            healthDmgAttackRange_SW += UnitType.LEVEL_TWO_MONEY_TOWER.attackStrength;
                        }
                        if (d < minDistToEnemy_SW) minDistToEnemy_SW = d;
                        break addEnemySW;
                    }
                    case LEVEL_TWO_PAINT_TOWER: {
                        if (actionReady && d <= soldierActionRadiusSquared) {
                            myHealthDmg_SW = soldierAttackStrength;
                        }
                        if (d <= UnitType.LEVEL_TWO_PAINT_TOWER.actionRadiusSquared) {
                            // Should have another one for AOE damage.
                            healthDmgAttackRange_SW += UnitType.LEVEL_TWO_PAINT_TOWER.attackStrength;
                        }
                        if (d < minDistToEnemy_SW) minDistToEnemy_SW = d;
                        break addEnemySW;
                    }
                    
                    default: break addEnemySW;
                }
            }
            
            addEnemyW: {
                if (!canMove_W) break addEnemyW;
                int d = targetLoc_W.distanceSquaredTo(robot.location);
                switch (robot.type) {
                    case LEVEL_ONE_DEFENSE_TOWER: {
                        if (actionReady && d <= soldierActionRadiusSquared) {
                            myHealthDmg_W = soldierAttackStrength;
                        }
                        if (d <= UnitType.LEVEL_ONE_DEFENSE_TOWER.actionRadiusSquared) {
                            // Should have another one for AOE damage.
                            healthDmgAttackRange_W += UnitType.LEVEL_ONE_DEFENSE_TOWER.attackStrength;
                        }
                        if (d < minDistToEnemy_W) minDistToEnemy_W = d;
                        break addEnemyW;
                    }
                    case LEVEL_ONE_MONEY_TOWER: {
                        if (actionReady && d <= soldierActionRadiusSquared) {
                            myHealthDmg_W = soldierAttackStrength;
                        }
                        if (d <= UnitType.LEVEL_ONE_MONEY_TOWER.actionRadiusSquared) {
                            // Should have another one for AOE damage.
                            healthDmgAttackRange_W += UnitType.LEVEL_ONE_MONEY_TOWER.attackStrength;
                        }
                        if (d < minDistToEnemy_W) minDistToEnemy_W = d;
                        break addEnemyW;
                    }
                    case LEVEL_ONE_PAINT_TOWER: {
                        if (actionReady && d <= soldierActionRadiusSquared) {
                            myHealthDmg_W = soldierAttackStrength;
                        }
                        if (d <= UnitType.LEVEL_ONE_PAINT_TOWER.actionRadiusSquared) {
                            // Should have another one for AOE damage.
                            healthDmgAttackRange_W += UnitType.LEVEL_ONE_PAINT_TOWER.attackStrength;
                        }
                        if (d < minDistToEnemy_W) minDistToEnemy_W = d;
                        break addEnemyW;
                    }
                    case LEVEL_THREE_DEFENSE_TOWER: {
                        if (actionReady && d <= soldierActionRadiusSquared) {
                            myHealthDmg_W = soldierAttackStrength;
                        }
                        if (d <= UnitType.LEVEL_THREE_DEFENSE_TOWER.actionRadiusSquared) {
                            // Should have another one for AOE damage.
                            healthDmgAttackRange_W += UnitType.LEVEL_THREE_DEFENSE_TOWER.attackStrength;
                        }
                        if (d < minDistToEnemy_W) minDistToEnemy_W = d;
                        break addEnemyW;
                    }
                    case LEVEL_THREE_MONEY_TOWER: {
                        if (actionReady && d <= soldierActionRadiusSquared) {
                            myHealthDmg_W = soldierAttackStrength;
                        }
                        if (d <= UnitType.LEVEL_THREE_MONEY_TOWER.actionRadiusSquared) {
                            // Should have another one for AOE damage.
                            healthDmgAttackRange_W += UnitType.LEVEL_THREE_MONEY_TOWER.attackStrength;
                        }
                        if (d < minDistToEnemy_W) minDistToEnemy_W = d;
                        break addEnemyW;
                    }
                    case LEVEL_THREE_PAINT_TOWER: {
                        if (actionReady && d <= soldierActionRadiusSquared) {
                            myHealthDmg_W = soldierAttackStrength;
                        }
                        if (d <= UnitType.LEVEL_THREE_PAINT_TOWER.actionRadiusSquared) {
                            // Should have another one for AOE damage.
                            healthDmgAttackRange_W += UnitType.LEVEL_THREE_PAINT_TOWER.attackStrength;
                        }
                        if (d < minDistToEnemy_W) minDistToEnemy_W = d;
                        break addEnemyW;
                    }
                    case LEVEL_TWO_DEFENSE_TOWER: {
                        if (actionReady && d <= soldierActionRadiusSquared) {
                            myHealthDmg_W = soldierAttackStrength;
                        }
                        if (d <= UnitType.LEVEL_TWO_DEFENSE_TOWER.actionRadiusSquared) {
                            // Should have another one for AOE damage.
                            healthDmgAttackRange_W += UnitType.LEVEL_TWO_DEFENSE_TOWER.attackStrength;
                        }
                        if (d < minDistToEnemy_W) minDistToEnemy_W = d;
                        break addEnemyW;
                    }
                    case LEVEL_TWO_MONEY_TOWER: {
                        if (actionReady && d <= soldierActionRadiusSquared) {
                            myHealthDmg_W = soldierAttackStrength;
                        }
                        if (d <= UnitType.LEVEL_TWO_MONEY_TOWER.actionRadiusSquared) {
                            // Should have another one for AOE damage.
                            healthDmgAttackRange_W += UnitType.LEVEL_TWO_MONEY_TOWER.attackStrength;
                        }
                        if (d < minDistToEnemy_W) minDistToEnemy_W = d;
                        break addEnemyW;
                    }
                    case LEVEL_TWO_PAINT_TOWER: {
                        if (actionReady && d <= soldierActionRadiusSquared) {
                            myHealthDmg_W = soldierAttackStrength;
                        }
                        if (d <= UnitType.LEVEL_TWO_PAINT_TOWER.actionRadiusSquared) {
                            // Should have another one for AOE damage.
                            healthDmgAttackRange_W += UnitType.LEVEL_TWO_PAINT_TOWER.attackStrength;
                        }
                        if (d < minDistToEnemy_W) minDistToEnemy_W = d;
                        break addEnemyW;
                    }
                    
                    default: break addEnemyW;
                }
            }
            
            addEnemyNW: {
                if (!canMove_NW) break addEnemyNW;
                int d = targetLoc_NW.distanceSquaredTo(robot.location);
                switch (robot.type) {
                    case LEVEL_ONE_DEFENSE_TOWER: {
                        if (actionReady && d <= soldierActionRadiusSquared) {
                            myHealthDmg_NW = soldierAttackStrength;
                        }
                        if (d <= UnitType.LEVEL_ONE_DEFENSE_TOWER.actionRadiusSquared) {
                            // Should have another one for AOE damage.
                            healthDmgAttackRange_NW += UnitType.LEVEL_ONE_DEFENSE_TOWER.attackStrength;
                        }
                        if (d < minDistToEnemy_NW) minDistToEnemy_NW = d;
                        break addEnemyNW;
                    }
                    case LEVEL_ONE_MONEY_TOWER: {
                        if (actionReady && d <= soldierActionRadiusSquared) {
                            myHealthDmg_NW = soldierAttackStrength;
                        }
                        if (d <= UnitType.LEVEL_ONE_MONEY_TOWER.actionRadiusSquared) {
                            // Should have another one for AOE damage.
                            healthDmgAttackRange_NW += UnitType.LEVEL_ONE_MONEY_TOWER.attackStrength;
                        }
                        if (d < minDistToEnemy_NW) minDistToEnemy_NW = d;
                        break addEnemyNW;
                    }
                    case LEVEL_ONE_PAINT_TOWER: {
                        if (actionReady && d <= soldierActionRadiusSquared) {
                            myHealthDmg_NW = soldierAttackStrength;
                        }
                        if (d <= UnitType.LEVEL_ONE_PAINT_TOWER.actionRadiusSquared) {
                            // Should have another one for AOE damage.
                            healthDmgAttackRange_NW += UnitType.LEVEL_ONE_PAINT_TOWER.attackStrength;
                        }
                        if (d < minDistToEnemy_NW) minDistToEnemy_NW = d;
                        break addEnemyNW;
                    }
                    case LEVEL_THREE_DEFENSE_TOWER: {
                        if (actionReady && d <= soldierActionRadiusSquared) {
                            myHealthDmg_NW = soldierAttackStrength;
                        }
                        if (d <= UnitType.LEVEL_THREE_DEFENSE_TOWER.actionRadiusSquared) {
                            // Should have another one for AOE damage.
                            healthDmgAttackRange_NW += UnitType.LEVEL_THREE_DEFENSE_TOWER.attackStrength;
                        }
                        if (d < minDistToEnemy_NW) minDistToEnemy_NW = d;
                        break addEnemyNW;
                    }
                    case LEVEL_THREE_MONEY_TOWER: {
                        if (actionReady && d <= soldierActionRadiusSquared) {
                            myHealthDmg_NW = soldierAttackStrength;
                        }
                        if (d <= UnitType.LEVEL_THREE_MONEY_TOWER.actionRadiusSquared) {
                            // Should have another one for AOE damage.
                            healthDmgAttackRange_NW += UnitType.LEVEL_THREE_MONEY_TOWER.attackStrength;
                        }
                        if (d < minDistToEnemy_NW) minDistToEnemy_NW = d;
                        break addEnemyNW;
                    }
                    case LEVEL_THREE_PAINT_TOWER: {
                        if (actionReady && d <= soldierActionRadiusSquared) {
                            myHealthDmg_NW = soldierAttackStrength;
                        }
                        if (d <= UnitType.LEVEL_THREE_PAINT_TOWER.actionRadiusSquared) {
                            // Should have another one for AOE damage.
                            healthDmgAttackRange_NW += UnitType.LEVEL_THREE_PAINT_TOWER.attackStrength;
                        }
                        if (d < minDistToEnemy_NW) minDistToEnemy_NW = d;
                        break addEnemyNW;
                    }
                    case LEVEL_TWO_DEFENSE_TOWER: {
                        if (actionReady && d <= soldierActionRadiusSquared) {
                            myHealthDmg_NW = soldierAttackStrength;
                        }
                        if (d <= UnitType.LEVEL_TWO_DEFENSE_TOWER.actionRadiusSquared) {
                            // Should have another one for AOE damage.
                            healthDmgAttackRange_NW += UnitType.LEVEL_TWO_DEFENSE_TOWER.attackStrength;
                        }
                        if (d < minDistToEnemy_NW) minDistToEnemy_NW = d;
                        break addEnemyNW;
                    }
                    case LEVEL_TWO_MONEY_TOWER: {
                        if (actionReady && d <= soldierActionRadiusSquared) {
                            myHealthDmg_NW = soldierAttackStrength;
                        }
                        if (d <= UnitType.LEVEL_TWO_MONEY_TOWER.actionRadiusSquared) {
                            // Should have another one for AOE damage.
                            healthDmgAttackRange_NW += UnitType.LEVEL_TWO_MONEY_TOWER.attackStrength;
                        }
                        if (d < minDistToEnemy_NW) minDistToEnemy_NW = d;
                        break addEnemyNW;
                    }
                    case LEVEL_TWO_PAINT_TOWER: {
                        if (actionReady && d <= soldierActionRadiusSquared) {
                            myHealthDmg_NW = soldierAttackStrength;
                        }
                        if (d <= UnitType.LEVEL_TWO_PAINT_TOWER.actionRadiusSquared) {
                            // Should have another one for AOE damage.
                            healthDmgAttackRange_NW += UnitType.LEVEL_TWO_PAINT_TOWER.attackStrength;
                        }
                        if (d < minDistToEnemy_NW) minDistToEnemy_NW = d;
                        break addEnemyNW;
                    }
                    
                    default: break addEnemyNW;
                }
            }
            
            addEnemyC: {
                if (!canMove_C) break addEnemyC;
                int d = targetLoc_C.distanceSquaredTo(robot.location);
                switch (robot.type) {
                    case LEVEL_ONE_DEFENSE_TOWER: {
                        if (actionReady && d <= soldierActionRadiusSquared) {
                            myHealthDmg_C = soldierAttackStrength;
                        }
                        if (d <= UnitType.LEVEL_ONE_DEFENSE_TOWER.actionRadiusSquared) {
                            // Should have another one for AOE damage.
                            healthDmgAttackRange_C += UnitType.LEVEL_ONE_DEFENSE_TOWER.attackStrength;
                        }
                        if (d < minDistToEnemy_C) minDistToEnemy_C = d;
                        break addEnemyC;
                    }
                    case LEVEL_ONE_MONEY_TOWER: {
                        if (actionReady && d <= soldierActionRadiusSquared) {
                            myHealthDmg_C = soldierAttackStrength;
                        }
                        if (d <= UnitType.LEVEL_ONE_MONEY_TOWER.actionRadiusSquared) {
                            // Should have another one for AOE damage.
                            healthDmgAttackRange_C += UnitType.LEVEL_ONE_MONEY_TOWER.attackStrength;
                        }
                        if (d < minDistToEnemy_C) minDistToEnemy_C = d;
                        break addEnemyC;
                    }
                    case LEVEL_ONE_PAINT_TOWER: {
                        if (actionReady && d <= soldierActionRadiusSquared) {
                            myHealthDmg_C = soldierAttackStrength;
                        }
                        if (d <= UnitType.LEVEL_ONE_PAINT_TOWER.actionRadiusSquared) {
                            // Should have another one for AOE damage.
                            healthDmgAttackRange_C += UnitType.LEVEL_ONE_PAINT_TOWER.attackStrength;
                        }
                        if (d < minDistToEnemy_C) minDistToEnemy_C = d;
                        break addEnemyC;
                    }
                    case LEVEL_THREE_DEFENSE_TOWER: {
                        if (actionReady && d <= soldierActionRadiusSquared) {
                            myHealthDmg_C = soldierAttackStrength;
                        }
                        if (d <= UnitType.LEVEL_THREE_DEFENSE_TOWER.actionRadiusSquared) {
                            // Should have another one for AOE damage.
                            healthDmgAttackRange_C += UnitType.LEVEL_THREE_DEFENSE_TOWER.attackStrength;
                        }
                        if (d < minDistToEnemy_C) minDistToEnemy_C = d;
                        break addEnemyC;
                    }
                    case LEVEL_THREE_MONEY_TOWER: {
                        if (actionReady && d <= soldierActionRadiusSquared) {
                            myHealthDmg_C = soldierAttackStrength;
                        }
                        if (d <= UnitType.LEVEL_THREE_MONEY_TOWER.actionRadiusSquared) {
                            // Should have another one for AOE damage.
                            healthDmgAttackRange_C += UnitType.LEVEL_THREE_MONEY_TOWER.attackStrength;
                        }
                        if (d < minDistToEnemy_C) minDistToEnemy_C = d;
                        break addEnemyC;
                    }
                    case LEVEL_THREE_PAINT_TOWER: {
                        if (actionReady && d <= soldierActionRadiusSquared) {
                            myHealthDmg_C = soldierAttackStrength;
                        }
                        if (d <= UnitType.LEVEL_THREE_PAINT_TOWER.actionRadiusSquared) {
                            // Should have another one for AOE damage.
                            healthDmgAttackRange_C += UnitType.LEVEL_THREE_PAINT_TOWER.attackStrength;
                        }
                        if (d < minDistToEnemy_C) minDistToEnemy_C = d;
                        break addEnemyC;
                    }
                    case LEVEL_TWO_DEFENSE_TOWER: {
                        if (actionReady && d <= soldierActionRadiusSquared) {
                            myHealthDmg_C = soldierAttackStrength;
                        }
                        if (d <= UnitType.LEVEL_TWO_DEFENSE_TOWER.actionRadiusSquared) {
                            // Should have another one for AOE damage.
                            healthDmgAttackRange_C += UnitType.LEVEL_TWO_DEFENSE_TOWER.attackStrength;
                        }
                        if (d < minDistToEnemy_C) minDistToEnemy_C = d;
                        break addEnemyC;
                    }
                    case LEVEL_TWO_MONEY_TOWER: {
                        if (actionReady && d <= soldierActionRadiusSquared) {
                            myHealthDmg_C = soldierAttackStrength;
                        }
                        if (d <= UnitType.LEVEL_TWO_MONEY_TOWER.actionRadiusSquared) {
                            // Should have another one for AOE damage.
                            healthDmgAttackRange_C += UnitType.LEVEL_TWO_MONEY_TOWER.attackStrength;
                        }
                        if (d < minDistToEnemy_C) minDistToEnemy_C = d;
                        break addEnemyC;
                    }
                    case LEVEL_TWO_PAINT_TOWER: {
                        if (actionReady && d <= soldierActionRadiusSquared) {
                            myHealthDmg_C = soldierAttackStrength;
                        }
                        if (d <= UnitType.LEVEL_TWO_PAINT_TOWER.actionRadiusSquared) {
                            // Should have another one for AOE damage.
                            healthDmgAttackRange_C += UnitType.LEVEL_TWO_PAINT_TOWER.attackStrength;
                        }
                        if (d < minDistToEnemy_C) minDistToEnemy_C = d;
                        break addEnemyC;
                    }
                    
                    default: break addEnemyC;
                }
            }
            
        }

        

        boolean bestWins = false;
        Direction bestDir = Direction.NORTH;
        MapLocation targetLoc_best = myloc.add(Direction.NORTH);
        boolean canMove_best = (rc.canMove(Direction.NORTH));
        PaintType paint_best = PaintType.ENEMY_PRIMARY;
        if (rc.canSenseLocation(targetLoc_best)) {
            paint_best = rc.senseMapInfo(targetLoc_best).getPaint();
            switch (rc.senseMapInfo(targetLoc_best).getPaint()) {
                 case PaintType.ENEMY_PRIMARY -> canMove_best = false;
                 case PaintType.ENEMY_SECONDARY -> canMove_best = false;
                 default -> {}
            }
        }
        double healthDmgAttackRange_best = 0;
        double myHealthDmg_best = 0;
        int minDistToEnemy_best = 100000;
        
        
        bestWins = canMove_best;
        chooseBestNE: {
            if (!canMove_NE || !canMove_best) break chooseBestNE;
            double bestHealthDmgDiff = healthDmgAttackRange_best - myHealthDmg_best;
            double otherHealthDmgDiff = healthDmgAttackRange_NE - myHealthDmg_NE;
            if (bestHealthDmgDiff != otherHealthDmgDiff) {
                bestWins = (bestHealthDmgDiff < otherHealthDmgDiff);
                break chooseBestNE;
            }
            if (paint_best.isAlly() != paint_NE.isAlly()) {
                bestWins = paint_best.isAlly();
                break chooseBestNE;
            }
            bestWins = (minDistToEnemy_best <= minDistToEnemy_NE);
            break chooseBestNE;
        }
        
        
        if (!bestWins) {
            targetLoc_best = targetLoc_NE;
            canMove_best = canMove_NE;
            healthDmgAttackRange_best = healthDmgAttackRange_NE;
            myHealthDmg_best = myHealthDmg_NE;
            minDistToEnemy_best = minDistToEnemy_NE;
            paint_best = paint_NE;
            bestDir = Direction.NORTHEAST;
        }
        
        
        bestWins = canMove_best;
        chooseBestE: {
            if (!canMove_E || !canMove_best) break chooseBestE;
            double bestHealthDmgDiff = healthDmgAttackRange_best - myHealthDmg_best;
            double otherHealthDmgDiff = healthDmgAttackRange_E - myHealthDmg_E;
            if (bestHealthDmgDiff != otherHealthDmgDiff) {
                bestWins = (bestHealthDmgDiff < otherHealthDmgDiff);
                break chooseBestE;
            }
            if (paint_best.isAlly() != paint_E.isAlly()) {
                bestWins = paint_best.isAlly();
                break chooseBestE;
            }
            bestWins = (minDistToEnemy_best <= minDistToEnemy_E);
            break chooseBestE;
        }
        
        
        if (!bestWins) {
            targetLoc_best = targetLoc_E;
            canMove_best = canMove_E;
            healthDmgAttackRange_best = healthDmgAttackRange_E;
            myHealthDmg_best = myHealthDmg_E;
            minDistToEnemy_best = minDistToEnemy_E;
            paint_best = paint_E;
            bestDir = Direction.EAST;
        }
        
        
        bestWins = canMove_best;
        chooseBestSE: {
            if (!canMove_SE || !canMove_best) break chooseBestSE;
            double bestHealthDmgDiff = healthDmgAttackRange_best - myHealthDmg_best;
            double otherHealthDmgDiff = healthDmgAttackRange_SE - myHealthDmg_SE;
            if (bestHealthDmgDiff != otherHealthDmgDiff) {
                bestWins = (bestHealthDmgDiff < otherHealthDmgDiff);
                break chooseBestSE;
            }
            if (paint_best.isAlly() != paint_SE.isAlly()) {
                bestWins = paint_best.isAlly();
                break chooseBestSE;
            }
            bestWins = (minDistToEnemy_best <= minDistToEnemy_SE);
            break chooseBestSE;
        }
        
        
        if (!bestWins) {
            targetLoc_best = targetLoc_SE;
            canMove_best = canMove_SE;
            healthDmgAttackRange_best = healthDmgAttackRange_SE;
            myHealthDmg_best = myHealthDmg_SE;
            minDistToEnemy_best = minDistToEnemy_SE;
            paint_best = paint_SE;
            bestDir = Direction.SOUTHEAST;
        }
        
        
        bestWins = canMove_best;
        chooseBestS: {
            if (!canMove_S || !canMove_best) break chooseBestS;
            double bestHealthDmgDiff = healthDmgAttackRange_best - myHealthDmg_best;
            double otherHealthDmgDiff = healthDmgAttackRange_S - myHealthDmg_S;
            if (bestHealthDmgDiff != otherHealthDmgDiff) {
                bestWins = (bestHealthDmgDiff < otherHealthDmgDiff);
                break chooseBestS;
            }
            if (paint_best.isAlly() != paint_S.isAlly()) {
                bestWins = paint_best.isAlly();
                break chooseBestS;
            }
            bestWins = (minDistToEnemy_best <= minDistToEnemy_S);
            break chooseBestS;
        }
        
        
        if (!bestWins) {
            targetLoc_best = targetLoc_S;
            canMove_best = canMove_S;
            healthDmgAttackRange_best = healthDmgAttackRange_S;
            myHealthDmg_best = myHealthDmg_S;
            minDistToEnemy_best = minDistToEnemy_S;
            paint_best = paint_S;
            bestDir = Direction.SOUTH;
        }
        
        
        bestWins = canMove_best;
        chooseBestSW: {
            if (!canMove_SW || !canMove_best) break chooseBestSW;
            double bestHealthDmgDiff = healthDmgAttackRange_best - myHealthDmg_best;
            double otherHealthDmgDiff = healthDmgAttackRange_SW - myHealthDmg_SW;
            if (bestHealthDmgDiff != otherHealthDmgDiff) {
                bestWins = (bestHealthDmgDiff < otherHealthDmgDiff);
                break chooseBestSW;
            }
            if (paint_best.isAlly() != paint_SW.isAlly()) {
                bestWins = paint_best.isAlly();
                break chooseBestSW;
            }
            bestWins = (minDistToEnemy_best <= minDistToEnemy_SW);
            break chooseBestSW;
        }
        
        
        if (!bestWins) {
            targetLoc_best = targetLoc_SW;
            canMove_best = canMove_SW;
            healthDmgAttackRange_best = healthDmgAttackRange_SW;
            myHealthDmg_best = myHealthDmg_SW;
            minDistToEnemy_best = minDistToEnemy_SW;
            paint_best = paint_SW;
            bestDir = Direction.SOUTHWEST;
        }
        
        
        bestWins = canMove_best;
        chooseBestW: {
            if (!canMove_W || !canMove_best) break chooseBestW;
            double bestHealthDmgDiff = healthDmgAttackRange_best - myHealthDmg_best;
            double otherHealthDmgDiff = healthDmgAttackRange_W - myHealthDmg_W;
            if (bestHealthDmgDiff != otherHealthDmgDiff) {
                bestWins = (bestHealthDmgDiff < otherHealthDmgDiff);
                break chooseBestW;
            }
            if (paint_best.isAlly() != paint_W.isAlly()) {
                bestWins = paint_best.isAlly();
                break chooseBestW;
            }
            bestWins = (minDistToEnemy_best <= minDistToEnemy_W);
            break chooseBestW;
        }
        
        
        if (!bestWins) {
            targetLoc_best = targetLoc_W;
            canMove_best = canMove_W;
            healthDmgAttackRange_best = healthDmgAttackRange_W;
            myHealthDmg_best = myHealthDmg_W;
            minDistToEnemy_best = minDistToEnemy_W;
            paint_best = paint_W;
            bestDir = Direction.WEST;
        }
        
        
        bestWins = canMove_best;
        chooseBestNW: {
            if (!canMove_NW || !canMove_best) break chooseBestNW;
            double bestHealthDmgDiff = healthDmgAttackRange_best - myHealthDmg_best;
            double otherHealthDmgDiff = healthDmgAttackRange_NW - myHealthDmg_NW;
            if (bestHealthDmgDiff != otherHealthDmgDiff) {
                bestWins = (bestHealthDmgDiff < otherHealthDmgDiff);
                break chooseBestNW;
            }
            if (paint_best.isAlly() != paint_NW.isAlly()) {
                bestWins = paint_best.isAlly();
                break chooseBestNW;
            }
            bestWins = (minDistToEnemy_best <= minDistToEnemy_NW);
            break chooseBestNW;
        }
        
        
        if (!bestWins) {
            targetLoc_best = targetLoc_NW;
            canMove_best = canMove_NW;
            healthDmgAttackRange_best = healthDmgAttackRange_NW;
            myHealthDmg_best = myHealthDmg_NW;
            minDistToEnemy_best = minDistToEnemy_NW;
            paint_best = paint_NW;
            bestDir = Direction.NORTHWEST;
        }
        
        
        bestWins = canMove_best;
        chooseBestC: {
            if (!canMove_C || !canMove_best) break chooseBestC;
            double bestHealthDmgDiff = healthDmgAttackRange_best - myHealthDmg_best;
            double otherHealthDmgDiff = healthDmgAttackRange_C - myHealthDmg_C;
            if (bestHealthDmgDiff != otherHealthDmgDiff) {
                bestWins = (bestHealthDmgDiff < otherHealthDmgDiff);
                break chooseBestC;
            }
            if (paint_best.isAlly() != paint_C.isAlly()) {
                bestWins = paint_best.isAlly();
                break chooseBestC;
            }
            bestWins = (minDistToEnemy_best <= minDistToEnemy_C);
            break chooseBestC;
        }
        
        
        if (!bestWins) {
            targetLoc_best = targetLoc_C;
            canMove_best = canMove_C;
            healthDmgAttackRange_best = healthDmgAttackRange_C;
            myHealthDmg_best = myHealthDmg_C;
            minDistToEnemy_best = minDistToEnemy_C;
            paint_best = paint_C;
            bestDir = Direction.CENTER;
        }
        
        

        

        if (rc.canMove(bestDir)) {
            rc.move(bestDir);
        }
        soldierTryAttack();
    }
    
    
    public static void splasherAttackMicro() throws GameActionException {
        splasherTryAttack();
        MapLocation myloc = rc.getLocation();
        MapLocation targetLoc_N = myloc.add(Direction.NORTH);
        boolean canMove_N = (rc.canMove(Direction.NORTH));
        PaintType paint_N = PaintType.ENEMY_PRIMARY;
        if (rc.canSenseLocation(targetLoc_N)) {
            paint_N = rc.senseMapInfo(targetLoc_N).getPaint();
            switch (rc.senseMapInfo(targetLoc_N).getPaint()) {
                 case PaintType.ENEMY_PRIMARY -> canMove_N = false;
                 case PaintType.ENEMY_SECONDARY -> canMove_N = false;
                 default -> {}
            }
        }
        double healthDmgAttackRange_N = 0;
        double myHealthDmg_N = 0;
        int minDistToEnemy_N = 100000;
        
        MapLocation targetLoc_NE = myloc.add(Direction.NORTHEAST);
        boolean canMove_NE = (rc.canMove(Direction.NORTHEAST));
        PaintType paint_NE = PaintType.ENEMY_PRIMARY;
        if (rc.canSenseLocation(targetLoc_NE)) {
            paint_NE = rc.senseMapInfo(targetLoc_NE).getPaint();
            switch (rc.senseMapInfo(targetLoc_NE).getPaint()) {
                 case PaintType.ENEMY_PRIMARY -> canMove_NE = false;
                 case PaintType.ENEMY_SECONDARY -> canMove_NE = false;
                 default -> {}
            }
        }
        double healthDmgAttackRange_NE = 0;
        double myHealthDmg_NE = 0;
        int minDistToEnemy_NE = 100000;
        
        MapLocation targetLoc_E = myloc.add(Direction.EAST);
        boolean canMove_E = (rc.canMove(Direction.EAST));
        PaintType paint_E = PaintType.ENEMY_PRIMARY;
        if (rc.canSenseLocation(targetLoc_E)) {
            paint_E = rc.senseMapInfo(targetLoc_E).getPaint();
            switch (rc.senseMapInfo(targetLoc_E).getPaint()) {
                 case PaintType.ENEMY_PRIMARY -> canMove_E = false;
                 case PaintType.ENEMY_SECONDARY -> canMove_E = false;
                 default -> {}
            }
        }
        double healthDmgAttackRange_E = 0;
        double myHealthDmg_E = 0;
        int minDistToEnemy_E = 100000;
        
        MapLocation targetLoc_SE = myloc.add(Direction.SOUTHEAST);
        boolean canMove_SE = (rc.canMove(Direction.SOUTHEAST));
        PaintType paint_SE = PaintType.ENEMY_PRIMARY;
        if (rc.canSenseLocation(targetLoc_SE)) {
            paint_SE = rc.senseMapInfo(targetLoc_SE).getPaint();
            switch (rc.senseMapInfo(targetLoc_SE).getPaint()) {
                 case PaintType.ENEMY_PRIMARY -> canMove_SE = false;
                 case PaintType.ENEMY_SECONDARY -> canMove_SE = false;
                 default -> {}
            }
        }
        double healthDmgAttackRange_SE = 0;
        double myHealthDmg_SE = 0;
        int minDistToEnemy_SE = 100000;
        
        MapLocation targetLoc_S = myloc.add(Direction.SOUTH);
        boolean canMove_S = (rc.canMove(Direction.SOUTH));
        PaintType paint_S = PaintType.ENEMY_PRIMARY;
        if (rc.canSenseLocation(targetLoc_S)) {
            paint_S = rc.senseMapInfo(targetLoc_S).getPaint();
            switch (rc.senseMapInfo(targetLoc_S).getPaint()) {
                 case PaintType.ENEMY_PRIMARY -> canMove_S = false;
                 case PaintType.ENEMY_SECONDARY -> canMove_S = false;
                 default -> {}
            }
        }
        double healthDmgAttackRange_S = 0;
        double myHealthDmg_S = 0;
        int minDistToEnemy_S = 100000;
        
        MapLocation targetLoc_SW = myloc.add(Direction.SOUTHWEST);
        boolean canMove_SW = (rc.canMove(Direction.SOUTHWEST));
        PaintType paint_SW = PaintType.ENEMY_PRIMARY;
        if (rc.canSenseLocation(targetLoc_SW)) {
            paint_SW = rc.senseMapInfo(targetLoc_SW).getPaint();
            switch (rc.senseMapInfo(targetLoc_SW).getPaint()) {
                 case PaintType.ENEMY_PRIMARY -> canMove_SW = false;
                 case PaintType.ENEMY_SECONDARY -> canMove_SW = false;
                 default -> {}
            }
        }
        double healthDmgAttackRange_SW = 0;
        double myHealthDmg_SW = 0;
        int minDistToEnemy_SW = 100000;
        
        MapLocation targetLoc_W = myloc.add(Direction.WEST);
        boolean canMove_W = (rc.canMove(Direction.WEST));
        PaintType paint_W = PaintType.ENEMY_PRIMARY;
        if (rc.canSenseLocation(targetLoc_W)) {
            paint_W = rc.senseMapInfo(targetLoc_W).getPaint();
            switch (rc.senseMapInfo(targetLoc_W).getPaint()) {
                 case PaintType.ENEMY_PRIMARY -> canMove_W = false;
                 case PaintType.ENEMY_SECONDARY -> canMove_W = false;
                 default -> {}
            }
        }
        double healthDmgAttackRange_W = 0;
        double myHealthDmg_W = 0;
        int minDistToEnemy_W = 100000;
        
        MapLocation targetLoc_NW = myloc.add(Direction.NORTHWEST);
        boolean canMove_NW = (rc.canMove(Direction.NORTHWEST));
        PaintType paint_NW = PaintType.ENEMY_PRIMARY;
        if (rc.canSenseLocation(targetLoc_NW)) {
            paint_NW = rc.senseMapInfo(targetLoc_NW).getPaint();
            switch (rc.senseMapInfo(targetLoc_NW).getPaint()) {
                 case PaintType.ENEMY_PRIMARY -> canMove_NW = false;
                 case PaintType.ENEMY_SECONDARY -> canMove_NW = false;
                 default -> {}
            }
        }
        double healthDmgAttackRange_NW = 0;
        double myHealthDmg_NW = 0;
        int minDistToEnemy_NW = 100000;
        
        MapLocation targetLoc_C = myloc.add(Direction.CENTER);
        boolean canMove_C = (true);
        PaintType paint_C = PaintType.ENEMY_PRIMARY;
        if (rc.canSenseLocation(targetLoc_C)) {
            paint_C = rc.senseMapInfo(targetLoc_C).getPaint();
            switch (rc.senseMapInfo(targetLoc_C).getPaint()) {
                 case PaintType.ENEMY_PRIMARY -> canMove_C = false;
                 case PaintType.ENEMY_SECONDARY -> canMove_C = false;
                 default -> {}
            }
        }
        double healthDmgAttackRange_C = 0;
        double myHealthDmg_C = 0;
        int minDistToEnemy_C = 100000;
        
        boolean actionReady = rc.isActionReady();
        for (int i = Globals.friends.length; --i >= 0; ) {
            RobotInfo robot = Globals.friends[i];
            addAllyN: {
                
            }
            addAllyNE: {
                
            }
            addAllyE: {
                
            }
            addAllySE: {
                
            }
            addAllyS: {
                
            }
            addAllySW: {
                
            }
            addAllyW: {
                
            }
            addAllyNW: {
                
            }
            addAllyC: {
                
            }
            
        }

        for (int i = Globals.enemies.length; --i >= 0; ) {
            RobotInfo robot = Globals.enemies[i];
            
            addEnemyN: {
                if (!canMove_N) break addEnemyN;
                int d = targetLoc_N.distanceSquaredTo(robot.location);
                switch (robot.type) {
                    case LEVEL_ONE_DEFENSE_TOWER: {
                        if (actionReady && d <= splasherActionRadiusSquared) {
                            myHealthDmg_N = splasherAttackStrength;
                        }
                        if (d <= UnitType.LEVEL_ONE_DEFENSE_TOWER.actionRadiusSquared) {
                            // Should have another one for AOE damage.
                            healthDmgAttackRange_N += UnitType.LEVEL_ONE_DEFENSE_TOWER.attackStrength;
                        }
                        if (d < minDistToEnemy_N) minDistToEnemy_N = d;
                        break addEnemyN;
                    }
                    case LEVEL_ONE_MONEY_TOWER: {
                        if (actionReady && d <= splasherActionRadiusSquared) {
                            myHealthDmg_N = splasherAttackStrength;
                        }
                        if (d <= UnitType.LEVEL_ONE_MONEY_TOWER.actionRadiusSquared) {
                            // Should have another one for AOE damage.
                            healthDmgAttackRange_N += UnitType.LEVEL_ONE_MONEY_TOWER.attackStrength;
                        }
                        if (d < minDistToEnemy_N) minDistToEnemy_N = d;
                        break addEnemyN;
                    }
                    case LEVEL_ONE_PAINT_TOWER: {
                        if (actionReady && d <= splasherActionRadiusSquared) {
                            myHealthDmg_N = splasherAttackStrength;
                        }
                        if (d <= UnitType.LEVEL_ONE_PAINT_TOWER.actionRadiusSquared) {
                            // Should have another one for AOE damage.
                            healthDmgAttackRange_N += UnitType.LEVEL_ONE_PAINT_TOWER.attackStrength;
                        }
                        if (d < minDistToEnemy_N) minDistToEnemy_N = d;
                        break addEnemyN;
                    }
                    case LEVEL_THREE_DEFENSE_TOWER: {
                        if (actionReady && d <= splasherActionRadiusSquared) {
                            myHealthDmg_N = splasherAttackStrength;
                        }
                        if (d <= UnitType.LEVEL_THREE_DEFENSE_TOWER.actionRadiusSquared) {
                            // Should have another one for AOE damage.
                            healthDmgAttackRange_N += UnitType.LEVEL_THREE_DEFENSE_TOWER.attackStrength;
                        }
                        if (d < minDistToEnemy_N) minDistToEnemy_N = d;
                        break addEnemyN;
                    }
                    case LEVEL_THREE_MONEY_TOWER: {
                        if (actionReady && d <= splasherActionRadiusSquared) {
                            myHealthDmg_N = splasherAttackStrength;
                        }
                        if (d <= UnitType.LEVEL_THREE_MONEY_TOWER.actionRadiusSquared) {
                            // Should have another one for AOE damage.
                            healthDmgAttackRange_N += UnitType.LEVEL_THREE_MONEY_TOWER.attackStrength;
                        }
                        if (d < minDistToEnemy_N) minDistToEnemy_N = d;
                        break addEnemyN;
                    }
                    case LEVEL_THREE_PAINT_TOWER: {
                        if (actionReady && d <= splasherActionRadiusSquared) {
                            myHealthDmg_N = splasherAttackStrength;
                        }
                        if (d <= UnitType.LEVEL_THREE_PAINT_TOWER.actionRadiusSquared) {
                            // Should have another one for AOE damage.
                            healthDmgAttackRange_N += UnitType.LEVEL_THREE_PAINT_TOWER.attackStrength;
                        }
                        if (d < minDistToEnemy_N) minDistToEnemy_N = d;
                        break addEnemyN;
                    }
                    case LEVEL_TWO_DEFENSE_TOWER: {
                        if (actionReady && d <= splasherActionRadiusSquared) {
                            myHealthDmg_N = splasherAttackStrength;
                        }
                        if (d <= UnitType.LEVEL_TWO_DEFENSE_TOWER.actionRadiusSquared) {
                            // Should have another one for AOE damage.
                            healthDmgAttackRange_N += UnitType.LEVEL_TWO_DEFENSE_TOWER.attackStrength;
                        }
                        if (d < minDistToEnemy_N) minDistToEnemy_N = d;
                        break addEnemyN;
                    }
                    case LEVEL_TWO_MONEY_TOWER: {
                        if (actionReady && d <= splasherActionRadiusSquared) {
                            myHealthDmg_N = splasherAttackStrength;
                        }
                        if (d <= UnitType.LEVEL_TWO_MONEY_TOWER.actionRadiusSquared) {
                            // Should have another one for AOE damage.
                            healthDmgAttackRange_N += UnitType.LEVEL_TWO_MONEY_TOWER.attackStrength;
                        }
                        if (d < minDistToEnemy_N) minDistToEnemy_N = d;
                        break addEnemyN;
                    }
                    case LEVEL_TWO_PAINT_TOWER: {
                        if (actionReady && d <= splasherActionRadiusSquared) {
                            myHealthDmg_N = splasherAttackStrength;
                        }
                        if (d <= UnitType.LEVEL_TWO_PAINT_TOWER.actionRadiusSquared) {
                            // Should have another one for AOE damage.
                            healthDmgAttackRange_N += UnitType.LEVEL_TWO_PAINT_TOWER.attackStrength;
                        }
                        if (d < minDistToEnemy_N) minDistToEnemy_N = d;
                        break addEnemyN;
                    }
                    
                    default: break addEnemyN;
                }
            }
            
            addEnemyNE: {
                if (!canMove_NE) break addEnemyNE;
                int d = targetLoc_NE.distanceSquaredTo(robot.location);
                switch (robot.type) {
                    case LEVEL_ONE_DEFENSE_TOWER: {
                        if (actionReady && d <= splasherActionRadiusSquared) {
                            myHealthDmg_NE = splasherAttackStrength;
                        }
                        if (d <= UnitType.LEVEL_ONE_DEFENSE_TOWER.actionRadiusSquared) {
                            // Should have another one for AOE damage.
                            healthDmgAttackRange_NE += UnitType.LEVEL_ONE_DEFENSE_TOWER.attackStrength;
                        }
                        if (d < minDistToEnemy_NE) minDistToEnemy_NE = d;
                        break addEnemyNE;
                    }
                    case LEVEL_ONE_MONEY_TOWER: {
                        if (actionReady && d <= splasherActionRadiusSquared) {
                            myHealthDmg_NE = splasherAttackStrength;
                        }
                        if (d <= UnitType.LEVEL_ONE_MONEY_TOWER.actionRadiusSquared) {
                            // Should have another one for AOE damage.
                            healthDmgAttackRange_NE += UnitType.LEVEL_ONE_MONEY_TOWER.attackStrength;
                        }
                        if (d < minDistToEnemy_NE) minDistToEnemy_NE = d;
                        break addEnemyNE;
                    }
                    case LEVEL_ONE_PAINT_TOWER: {
                        if (actionReady && d <= splasherActionRadiusSquared) {
                            myHealthDmg_NE = splasherAttackStrength;
                        }
                        if (d <= UnitType.LEVEL_ONE_PAINT_TOWER.actionRadiusSquared) {
                            // Should have another one for AOE damage.
                            healthDmgAttackRange_NE += UnitType.LEVEL_ONE_PAINT_TOWER.attackStrength;
                        }
                        if (d < minDistToEnemy_NE) minDistToEnemy_NE = d;
                        break addEnemyNE;
                    }
                    case LEVEL_THREE_DEFENSE_TOWER: {
                        if (actionReady && d <= splasherActionRadiusSquared) {
                            myHealthDmg_NE = splasherAttackStrength;
                        }
                        if (d <= UnitType.LEVEL_THREE_DEFENSE_TOWER.actionRadiusSquared) {
                            // Should have another one for AOE damage.
                            healthDmgAttackRange_NE += UnitType.LEVEL_THREE_DEFENSE_TOWER.attackStrength;
                        }
                        if (d < minDistToEnemy_NE) minDistToEnemy_NE = d;
                        break addEnemyNE;
                    }
                    case LEVEL_THREE_MONEY_TOWER: {
                        if (actionReady && d <= splasherActionRadiusSquared) {
                            myHealthDmg_NE = splasherAttackStrength;
                        }
                        if (d <= UnitType.LEVEL_THREE_MONEY_TOWER.actionRadiusSquared) {
                            // Should have another one for AOE damage.
                            healthDmgAttackRange_NE += UnitType.LEVEL_THREE_MONEY_TOWER.attackStrength;
                        }
                        if (d < minDistToEnemy_NE) minDistToEnemy_NE = d;
                        break addEnemyNE;
                    }
                    case LEVEL_THREE_PAINT_TOWER: {
                        if (actionReady && d <= splasherActionRadiusSquared) {
                            myHealthDmg_NE = splasherAttackStrength;
                        }
                        if (d <= UnitType.LEVEL_THREE_PAINT_TOWER.actionRadiusSquared) {
                            // Should have another one for AOE damage.
                            healthDmgAttackRange_NE += UnitType.LEVEL_THREE_PAINT_TOWER.attackStrength;
                        }
                        if (d < minDistToEnemy_NE) minDistToEnemy_NE = d;
                        break addEnemyNE;
                    }
                    case LEVEL_TWO_DEFENSE_TOWER: {
                        if (actionReady && d <= splasherActionRadiusSquared) {
                            myHealthDmg_NE = splasherAttackStrength;
                        }
                        if (d <= UnitType.LEVEL_TWO_DEFENSE_TOWER.actionRadiusSquared) {
                            // Should have another one for AOE damage.
                            healthDmgAttackRange_NE += UnitType.LEVEL_TWO_DEFENSE_TOWER.attackStrength;
                        }
                        if (d < minDistToEnemy_NE) minDistToEnemy_NE = d;
                        break addEnemyNE;
                    }
                    case LEVEL_TWO_MONEY_TOWER: {
                        if (actionReady && d <= splasherActionRadiusSquared) {
                            myHealthDmg_NE = splasherAttackStrength;
                        }
                        if (d <= UnitType.LEVEL_TWO_MONEY_TOWER.actionRadiusSquared) {
                            // Should have another one for AOE damage.
                            healthDmgAttackRange_NE += UnitType.LEVEL_TWO_MONEY_TOWER.attackStrength;
                        }
                        if (d < minDistToEnemy_NE) minDistToEnemy_NE = d;
                        break addEnemyNE;
                    }
                    case LEVEL_TWO_PAINT_TOWER: {
                        if (actionReady && d <= splasherActionRadiusSquared) {
                            myHealthDmg_NE = splasherAttackStrength;
                        }
                        if (d <= UnitType.LEVEL_TWO_PAINT_TOWER.actionRadiusSquared) {
                            // Should have another one for AOE damage.
                            healthDmgAttackRange_NE += UnitType.LEVEL_TWO_PAINT_TOWER.attackStrength;
                        }
                        if (d < minDistToEnemy_NE) minDistToEnemy_NE = d;
                        break addEnemyNE;
                    }
                    
                    default: break addEnemyNE;
                }
            }
            
            addEnemyE: {
                if (!canMove_E) break addEnemyE;
                int d = targetLoc_E.distanceSquaredTo(robot.location);
                switch (robot.type) {
                    case LEVEL_ONE_DEFENSE_TOWER: {
                        if (actionReady && d <= splasherActionRadiusSquared) {
                            myHealthDmg_E = splasherAttackStrength;
                        }
                        if (d <= UnitType.LEVEL_ONE_DEFENSE_TOWER.actionRadiusSquared) {
                            // Should have another one for AOE damage.
                            healthDmgAttackRange_E += UnitType.LEVEL_ONE_DEFENSE_TOWER.attackStrength;
                        }
                        if (d < minDistToEnemy_E) minDistToEnemy_E = d;
                        break addEnemyE;
                    }
                    case LEVEL_ONE_MONEY_TOWER: {
                        if (actionReady && d <= splasherActionRadiusSquared) {
                            myHealthDmg_E = splasherAttackStrength;
                        }
                        if (d <= UnitType.LEVEL_ONE_MONEY_TOWER.actionRadiusSquared) {
                            // Should have another one for AOE damage.
                            healthDmgAttackRange_E += UnitType.LEVEL_ONE_MONEY_TOWER.attackStrength;
                        }
                        if (d < minDistToEnemy_E) minDistToEnemy_E = d;
                        break addEnemyE;
                    }
                    case LEVEL_ONE_PAINT_TOWER: {
                        if (actionReady && d <= splasherActionRadiusSquared) {
                            myHealthDmg_E = splasherAttackStrength;
                        }
                        if (d <= UnitType.LEVEL_ONE_PAINT_TOWER.actionRadiusSquared) {
                            // Should have another one for AOE damage.
                            healthDmgAttackRange_E += UnitType.LEVEL_ONE_PAINT_TOWER.attackStrength;
                        }
                        if (d < minDistToEnemy_E) minDistToEnemy_E = d;
                        break addEnemyE;
                    }
                    case LEVEL_THREE_DEFENSE_TOWER: {
                        if (actionReady && d <= splasherActionRadiusSquared) {
                            myHealthDmg_E = splasherAttackStrength;
                        }
                        if (d <= UnitType.LEVEL_THREE_DEFENSE_TOWER.actionRadiusSquared) {
                            // Should have another one for AOE damage.
                            healthDmgAttackRange_E += UnitType.LEVEL_THREE_DEFENSE_TOWER.attackStrength;
                        }
                        if (d < minDistToEnemy_E) minDistToEnemy_E = d;
                        break addEnemyE;
                    }
                    case LEVEL_THREE_MONEY_TOWER: {
                        if (actionReady && d <= splasherActionRadiusSquared) {
                            myHealthDmg_E = splasherAttackStrength;
                        }
                        if (d <= UnitType.LEVEL_THREE_MONEY_TOWER.actionRadiusSquared) {
                            // Should have another one for AOE damage.
                            healthDmgAttackRange_E += UnitType.LEVEL_THREE_MONEY_TOWER.attackStrength;
                        }
                        if (d < minDistToEnemy_E) minDistToEnemy_E = d;
                        break addEnemyE;
                    }
                    case LEVEL_THREE_PAINT_TOWER: {
                        if (actionReady && d <= splasherActionRadiusSquared) {
                            myHealthDmg_E = splasherAttackStrength;
                        }
                        if (d <= UnitType.LEVEL_THREE_PAINT_TOWER.actionRadiusSquared) {
                            // Should have another one for AOE damage.
                            healthDmgAttackRange_E += UnitType.LEVEL_THREE_PAINT_TOWER.attackStrength;
                        }
                        if (d < minDistToEnemy_E) minDistToEnemy_E = d;
                        break addEnemyE;
                    }
                    case LEVEL_TWO_DEFENSE_TOWER: {
                        if (actionReady && d <= splasherActionRadiusSquared) {
                            myHealthDmg_E = splasherAttackStrength;
                        }
                        if (d <= UnitType.LEVEL_TWO_DEFENSE_TOWER.actionRadiusSquared) {
                            // Should have another one for AOE damage.
                            healthDmgAttackRange_E += UnitType.LEVEL_TWO_DEFENSE_TOWER.attackStrength;
                        }
                        if (d < minDistToEnemy_E) minDistToEnemy_E = d;
                        break addEnemyE;
                    }
                    case LEVEL_TWO_MONEY_TOWER: {
                        if (actionReady && d <= splasherActionRadiusSquared) {
                            myHealthDmg_E = splasherAttackStrength;
                        }
                        if (d <= UnitType.LEVEL_TWO_MONEY_TOWER.actionRadiusSquared) {
                            // Should have another one for AOE damage.
                            healthDmgAttackRange_E += UnitType.LEVEL_TWO_MONEY_TOWER.attackStrength;
                        }
                        if (d < minDistToEnemy_E) minDistToEnemy_E = d;
                        break addEnemyE;
                    }
                    case LEVEL_TWO_PAINT_TOWER: {
                        if (actionReady && d <= splasherActionRadiusSquared) {
                            myHealthDmg_E = splasherAttackStrength;
                        }
                        if (d <= UnitType.LEVEL_TWO_PAINT_TOWER.actionRadiusSquared) {
                            // Should have another one for AOE damage.
                            healthDmgAttackRange_E += UnitType.LEVEL_TWO_PAINT_TOWER.attackStrength;
                        }
                        if (d < minDistToEnemy_E) minDistToEnemy_E = d;
                        break addEnemyE;
                    }
                    
                    default: break addEnemyE;
                }
            }
            
            addEnemySE: {
                if (!canMove_SE) break addEnemySE;
                int d = targetLoc_SE.distanceSquaredTo(robot.location);
                switch (robot.type) {
                    case LEVEL_ONE_DEFENSE_TOWER: {
                        if (actionReady && d <= splasherActionRadiusSquared) {
                            myHealthDmg_SE = splasherAttackStrength;
                        }
                        if (d <= UnitType.LEVEL_ONE_DEFENSE_TOWER.actionRadiusSquared) {
                            // Should have another one for AOE damage.
                            healthDmgAttackRange_SE += UnitType.LEVEL_ONE_DEFENSE_TOWER.attackStrength;
                        }
                        if (d < minDistToEnemy_SE) minDistToEnemy_SE = d;
                        break addEnemySE;
                    }
                    case LEVEL_ONE_MONEY_TOWER: {
                        if (actionReady && d <= splasherActionRadiusSquared) {
                            myHealthDmg_SE = splasherAttackStrength;
                        }
                        if (d <= UnitType.LEVEL_ONE_MONEY_TOWER.actionRadiusSquared) {
                            // Should have another one for AOE damage.
                            healthDmgAttackRange_SE += UnitType.LEVEL_ONE_MONEY_TOWER.attackStrength;
                        }
                        if (d < minDistToEnemy_SE) minDistToEnemy_SE = d;
                        break addEnemySE;
                    }
                    case LEVEL_ONE_PAINT_TOWER: {
                        if (actionReady && d <= splasherActionRadiusSquared) {
                            myHealthDmg_SE = splasherAttackStrength;
                        }
                        if (d <= UnitType.LEVEL_ONE_PAINT_TOWER.actionRadiusSquared) {
                            // Should have another one for AOE damage.
                            healthDmgAttackRange_SE += UnitType.LEVEL_ONE_PAINT_TOWER.attackStrength;
                        }
                        if (d < minDistToEnemy_SE) minDistToEnemy_SE = d;
                        break addEnemySE;
                    }
                    case LEVEL_THREE_DEFENSE_TOWER: {
                        if (actionReady && d <= splasherActionRadiusSquared) {
                            myHealthDmg_SE = splasherAttackStrength;
                        }
                        if (d <= UnitType.LEVEL_THREE_DEFENSE_TOWER.actionRadiusSquared) {
                            // Should have another one for AOE damage.
                            healthDmgAttackRange_SE += UnitType.LEVEL_THREE_DEFENSE_TOWER.attackStrength;
                        }
                        if (d < minDistToEnemy_SE) minDistToEnemy_SE = d;
                        break addEnemySE;
                    }
                    case LEVEL_THREE_MONEY_TOWER: {
                        if (actionReady && d <= splasherActionRadiusSquared) {
                            myHealthDmg_SE = splasherAttackStrength;
                        }
                        if (d <= UnitType.LEVEL_THREE_MONEY_TOWER.actionRadiusSquared) {
                            // Should have another one for AOE damage.
                            healthDmgAttackRange_SE += UnitType.LEVEL_THREE_MONEY_TOWER.attackStrength;
                        }
                        if (d < minDistToEnemy_SE) minDistToEnemy_SE = d;
                        break addEnemySE;
                    }
                    case LEVEL_THREE_PAINT_TOWER: {
                        if (actionReady && d <= splasherActionRadiusSquared) {
                            myHealthDmg_SE = splasherAttackStrength;
                        }
                        if (d <= UnitType.LEVEL_THREE_PAINT_TOWER.actionRadiusSquared) {
                            // Should have another one for AOE damage.
                            healthDmgAttackRange_SE += UnitType.LEVEL_THREE_PAINT_TOWER.attackStrength;
                        }
                        if (d < minDistToEnemy_SE) minDistToEnemy_SE = d;
                        break addEnemySE;
                    }
                    case LEVEL_TWO_DEFENSE_TOWER: {
                        if (actionReady && d <= splasherActionRadiusSquared) {
                            myHealthDmg_SE = splasherAttackStrength;
                        }
                        if (d <= UnitType.LEVEL_TWO_DEFENSE_TOWER.actionRadiusSquared) {
                            // Should have another one for AOE damage.
                            healthDmgAttackRange_SE += UnitType.LEVEL_TWO_DEFENSE_TOWER.attackStrength;
                        }
                        if (d < minDistToEnemy_SE) minDistToEnemy_SE = d;
                        break addEnemySE;
                    }
                    case LEVEL_TWO_MONEY_TOWER: {
                        if (actionReady && d <= splasherActionRadiusSquared) {
                            myHealthDmg_SE = splasherAttackStrength;
                        }
                        if (d <= UnitType.LEVEL_TWO_MONEY_TOWER.actionRadiusSquared) {
                            // Should have another one for AOE damage.
                            healthDmgAttackRange_SE += UnitType.LEVEL_TWO_MONEY_TOWER.attackStrength;
                        }
                        if (d < minDistToEnemy_SE) minDistToEnemy_SE = d;
                        break addEnemySE;
                    }
                    case LEVEL_TWO_PAINT_TOWER: {
                        if (actionReady && d <= splasherActionRadiusSquared) {
                            myHealthDmg_SE = splasherAttackStrength;
                        }
                        if (d <= UnitType.LEVEL_TWO_PAINT_TOWER.actionRadiusSquared) {
                            // Should have another one for AOE damage.
                            healthDmgAttackRange_SE += UnitType.LEVEL_TWO_PAINT_TOWER.attackStrength;
                        }
                        if (d < minDistToEnemy_SE) minDistToEnemy_SE = d;
                        break addEnemySE;
                    }
                    
                    default: break addEnemySE;
                }
            }
            
            addEnemyS: {
                if (!canMove_S) break addEnemyS;
                int d = targetLoc_S.distanceSquaredTo(robot.location);
                switch (robot.type) {
                    case LEVEL_ONE_DEFENSE_TOWER: {
                        if (actionReady && d <= splasherActionRadiusSquared) {
                            myHealthDmg_S = splasherAttackStrength;
                        }
                        if (d <= UnitType.LEVEL_ONE_DEFENSE_TOWER.actionRadiusSquared) {
                            // Should have another one for AOE damage.
                            healthDmgAttackRange_S += UnitType.LEVEL_ONE_DEFENSE_TOWER.attackStrength;
                        }
                        if (d < minDistToEnemy_S) minDistToEnemy_S = d;
                        break addEnemyS;
                    }
                    case LEVEL_ONE_MONEY_TOWER: {
                        if (actionReady && d <= splasherActionRadiusSquared) {
                            myHealthDmg_S = splasherAttackStrength;
                        }
                        if (d <= UnitType.LEVEL_ONE_MONEY_TOWER.actionRadiusSquared) {
                            // Should have another one for AOE damage.
                            healthDmgAttackRange_S += UnitType.LEVEL_ONE_MONEY_TOWER.attackStrength;
                        }
                        if (d < minDistToEnemy_S) minDistToEnemy_S = d;
                        break addEnemyS;
                    }
                    case LEVEL_ONE_PAINT_TOWER: {
                        if (actionReady && d <= splasherActionRadiusSquared) {
                            myHealthDmg_S = splasherAttackStrength;
                        }
                        if (d <= UnitType.LEVEL_ONE_PAINT_TOWER.actionRadiusSquared) {
                            // Should have another one for AOE damage.
                            healthDmgAttackRange_S += UnitType.LEVEL_ONE_PAINT_TOWER.attackStrength;
                        }
                        if (d < minDistToEnemy_S) minDistToEnemy_S = d;
                        break addEnemyS;
                    }
                    case LEVEL_THREE_DEFENSE_TOWER: {
                        if (actionReady && d <= splasherActionRadiusSquared) {
                            myHealthDmg_S = splasherAttackStrength;
                        }
                        if (d <= UnitType.LEVEL_THREE_DEFENSE_TOWER.actionRadiusSquared) {
                            // Should have another one for AOE damage.
                            healthDmgAttackRange_S += UnitType.LEVEL_THREE_DEFENSE_TOWER.attackStrength;
                        }
                        if (d < minDistToEnemy_S) minDistToEnemy_S = d;
                        break addEnemyS;
                    }
                    case LEVEL_THREE_MONEY_TOWER: {
                        if (actionReady && d <= splasherActionRadiusSquared) {
                            myHealthDmg_S = splasherAttackStrength;
                        }
                        if (d <= UnitType.LEVEL_THREE_MONEY_TOWER.actionRadiusSquared) {
                            // Should have another one for AOE damage.
                            healthDmgAttackRange_S += UnitType.LEVEL_THREE_MONEY_TOWER.attackStrength;
                        }
                        if (d < minDistToEnemy_S) minDistToEnemy_S = d;
                        break addEnemyS;
                    }
                    case LEVEL_THREE_PAINT_TOWER: {
                        if (actionReady && d <= splasherActionRadiusSquared) {
                            myHealthDmg_S = splasherAttackStrength;
                        }
                        if (d <= UnitType.LEVEL_THREE_PAINT_TOWER.actionRadiusSquared) {
                            // Should have another one for AOE damage.
                            healthDmgAttackRange_S += UnitType.LEVEL_THREE_PAINT_TOWER.attackStrength;
                        }
                        if (d < minDistToEnemy_S) minDistToEnemy_S = d;
                        break addEnemyS;
                    }
                    case LEVEL_TWO_DEFENSE_TOWER: {
                        if (actionReady && d <= splasherActionRadiusSquared) {
                            myHealthDmg_S = splasherAttackStrength;
                        }
                        if (d <= UnitType.LEVEL_TWO_DEFENSE_TOWER.actionRadiusSquared) {
                            // Should have another one for AOE damage.
                            healthDmgAttackRange_S += UnitType.LEVEL_TWO_DEFENSE_TOWER.attackStrength;
                        }
                        if (d < minDistToEnemy_S) minDistToEnemy_S = d;
                        break addEnemyS;
                    }
                    case LEVEL_TWO_MONEY_TOWER: {
                        if (actionReady && d <= splasherActionRadiusSquared) {
                            myHealthDmg_S = splasherAttackStrength;
                        }
                        if (d <= UnitType.LEVEL_TWO_MONEY_TOWER.actionRadiusSquared) {
                            // Should have another one for AOE damage.
                            healthDmgAttackRange_S += UnitType.LEVEL_TWO_MONEY_TOWER.attackStrength;
                        }
                        if (d < minDistToEnemy_S) minDistToEnemy_S = d;
                        break addEnemyS;
                    }
                    case LEVEL_TWO_PAINT_TOWER: {
                        if (actionReady && d <= splasherActionRadiusSquared) {
                            myHealthDmg_S = splasherAttackStrength;
                        }
                        if (d <= UnitType.LEVEL_TWO_PAINT_TOWER.actionRadiusSquared) {
                            // Should have another one for AOE damage.
                            healthDmgAttackRange_S += UnitType.LEVEL_TWO_PAINT_TOWER.attackStrength;
                        }
                        if (d < minDistToEnemy_S) minDistToEnemy_S = d;
                        break addEnemyS;
                    }
                    
                    default: break addEnemyS;
                }
            }
            
            addEnemySW: {
                if (!canMove_SW) break addEnemySW;
                int d = targetLoc_SW.distanceSquaredTo(robot.location);
                switch (robot.type) {
                    case LEVEL_ONE_DEFENSE_TOWER: {
                        if (actionReady && d <= splasherActionRadiusSquared) {
                            myHealthDmg_SW = splasherAttackStrength;
                        }
                        if (d <= UnitType.LEVEL_ONE_DEFENSE_TOWER.actionRadiusSquared) {
                            // Should have another one for AOE damage.
                            healthDmgAttackRange_SW += UnitType.LEVEL_ONE_DEFENSE_TOWER.attackStrength;
                        }
                        if (d < minDistToEnemy_SW) minDistToEnemy_SW = d;
                        break addEnemySW;
                    }
                    case LEVEL_ONE_MONEY_TOWER: {
                        if (actionReady && d <= splasherActionRadiusSquared) {
                            myHealthDmg_SW = splasherAttackStrength;
                        }
                        if (d <= UnitType.LEVEL_ONE_MONEY_TOWER.actionRadiusSquared) {
                            // Should have another one for AOE damage.
                            healthDmgAttackRange_SW += UnitType.LEVEL_ONE_MONEY_TOWER.attackStrength;
                        }
                        if (d < minDistToEnemy_SW) minDistToEnemy_SW = d;
                        break addEnemySW;
                    }
                    case LEVEL_ONE_PAINT_TOWER: {
                        if (actionReady && d <= splasherActionRadiusSquared) {
                            myHealthDmg_SW = splasherAttackStrength;
                        }
                        if (d <= UnitType.LEVEL_ONE_PAINT_TOWER.actionRadiusSquared) {
                            // Should have another one for AOE damage.
                            healthDmgAttackRange_SW += UnitType.LEVEL_ONE_PAINT_TOWER.attackStrength;
                        }
                        if (d < minDistToEnemy_SW) minDistToEnemy_SW = d;
                        break addEnemySW;
                    }
                    case LEVEL_THREE_DEFENSE_TOWER: {
                        if (actionReady && d <= splasherActionRadiusSquared) {
                            myHealthDmg_SW = splasherAttackStrength;
                        }
                        if (d <= UnitType.LEVEL_THREE_DEFENSE_TOWER.actionRadiusSquared) {
                            // Should have another one for AOE damage.
                            healthDmgAttackRange_SW += UnitType.LEVEL_THREE_DEFENSE_TOWER.attackStrength;
                        }
                        if (d < minDistToEnemy_SW) minDistToEnemy_SW = d;
                        break addEnemySW;
                    }
                    case LEVEL_THREE_MONEY_TOWER: {
                        if (actionReady && d <= splasherActionRadiusSquared) {
                            myHealthDmg_SW = splasherAttackStrength;
                        }
                        if (d <= UnitType.LEVEL_THREE_MONEY_TOWER.actionRadiusSquared) {
                            // Should have another one for AOE damage.
                            healthDmgAttackRange_SW += UnitType.LEVEL_THREE_MONEY_TOWER.attackStrength;
                        }
                        if (d < minDistToEnemy_SW) minDistToEnemy_SW = d;
                        break addEnemySW;
                    }
                    case LEVEL_THREE_PAINT_TOWER: {
                        if (actionReady && d <= splasherActionRadiusSquared) {
                            myHealthDmg_SW = splasherAttackStrength;
                        }
                        if (d <= UnitType.LEVEL_THREE_PAINT_TOWER.actionRadiusSquared) {
                            // Should have another one for AOE damage.
                            healthDmgAttackRange_SW += UnitType.LEVEL_THREE_PAINT_TOWER.attackStrength;
                        }
                        if (d < minDistToEnemy_SW) minDistToEnemy_SW = d;
                        break addEnemySW;
                    }
                    case LEVEL_TWO_DEFENSE_TOWER: {
                        if (actionReady && d <= splasherActionRadiusSquared) {
                            myHealthDmg_SW = splasherAttackStrength;
                        }
                        if (d <= UnitType.LEVEL_TWO_DEFENSE_TOWER.actionRadiusSquared) {
                            // Should have another one for AOE damage.
                            healthDmgAttackRange_SW += UnitType.LEVEL_TWO_DEFENSE_TOWER.attackStrength;
                        }
                        if (d < minDistToEnemy_SW) minDistToEnemy_SW = d;
                        break addEnemySW;
                    }
                    case LEVEL_TWO_MONEY_TOWER: {
                        if (actionReady && d <= splasherActionRadiusSquared) {
                            myHealthDmg_SW = splasherAttackStrength;
                        }
                        if (d <= UnitType.LEVEL_TWO_MONEY_TOWER.actionRadiusSquared) {
                            // Should have another one for AOE damage.
                            healthDmgAttackRange_SW += UnitType.LEVEL_TWO_MONEY_TOWER.attackStrength;
                        }
                        if (d < minDistToEnemy_SW) minDistToEnemy_SW = d;
                        break addEnemySW;
                    }
                    case LEVEL_TWO_PAINT_TOWER: {
                        if (actionReady && d <= splasherActionRadiusSquared) {
                            myHealthDmg_SW = splasherAttackStrength;
                        }
                        if (d <= UnitType.LEVEL_TWO_PAINT_TOWER.actionRadiusSquared) {
                            // Should have another one for AOE damage.
                            healthDmgAttackRange_SW += UnitType.LEVEL_TWO_PAINT_TOWER.attackStrength;
                        }
                        if (d < minDistToEnemy_SW) minDistToEnemy_SW = d;
                        break addEnemySW;
                    }
                    
                    default: break addEnemySW;
                }
            }
            
            addEnemyW: {
                if (!canMove_W) break addEnemyW;
                int d = targetLoc_W.distanceSquaredTo(robot.location);
                switch (robot.type) {
                    case LEVEL_ONE_DEFENSE_TOWER: {
                        if (actionReady && d <= splasherActionRadiusSquared) {
                            myHealthDmg_W = splasherAttackStrength;
                        }
                        if (d <= UnitType.LEVEL_ONE_DEFENSE_TOWER.actionRadiusSquared) {
                            // Should have another one for AOE damage.
                            healthDmgAttackRange_W += UnitType.LEVEL_ONE_DEFENSE_TOWER.attackStrength;
                        }
                        if (d < minDistToEnemy_W) minDistToEnemy_W = d;
                        break addEnemyW;
                    }
                    case LEVEL_ONE_MONEY_TOWER: {
                        if (actionReady && d <= splasherActionRadiusSquared) {
                            myHealthDmg_W = splasherAttackStrength;
                        }
                        if (d <= UnitType.LEVEL_ONE_MONEY_TOWER.actionRadiusSquared) {
                            // Should have another one for AOE damage.
                            healthDmgAttackRange_W += UnitType.LEVEL_ONE_MONEY_TOWER.attackStrength;
                        }
                        if (d < minDistToEnemy_W) minDistToEnemy_W = d;
                        break addEnemyW;
                    }
                    case LEVEL_ONE_PAINT_TOWER: {
                        if (actionReady && d <= splasherActionRadiusSquared) {
                            myHealthDmg_W = splasherAttackStrength;
                        }
                        if (d <= UnitType.LEVEL_ONE_PAINT_TOWER.actionRadiusSquared) {
                            // Should have another one for AOE damage.
                            healthDmgAttackRange_W += UnitType.LEVEL_ONE_PAINT_TOWER.attackStrength;
                        }
                        if (d < minDistToEnemy_W) minDistToEnemy_W = d;
                        break addEnemyW;
                    }
                    case LEVEL_THREE_DEFENSE_TOWER: {
                        if (actionReady && d <= splasherActionRadiusSquared) {
                            myHealthDmg_W = splasherAttackStrength;
                        }
                        if (d <= UnitType.LEVEL_THREE_DEFENSE_TOWER.actionRadiusSquared) {
                            // Should have another one for AOE damage.
                            healthDmgAttackRange_W += UnitType.LEVEL_THREE_DEFENSE_TOWER.attackStrength;
                        }
                        if (d < minDistToEnemy_W) minDistToEnemy_W = d;
                        break addEnemyW;
                    }
                    case LEVEL_THREE_MONEY_TOWER: {
                        if (actionReady && d <= splasherActionRadiusSquared) {
                            myHealthDmg_W = splasherAttackStrength;
                        }
                        if (d <= UnitType.LEVEL_THREE_MONEY_TOWER.actionRadiusSquared) {
                            // Should have another one for AOE damage.
                            healthDmgAttackRange_W += UnitType.LEVEL_THREE_MONEY_TOWER.attackStrength;
                        }
                        if (d < minDistToEnemy_W) minDistToEnemy_W = d;
                        break addEnemyW;
                    }
                    case LEVEL_THREE_PAINT_TOWER: {
                        if (actionReady && d <= splasherActionRadiusSquared) {
                            myHealthDmg_W = splasherAttackStrength;
                        }
                        if (d <= UnitType.LEVEL_THREE_PAINT_TOWER.actionRadiusSquared) {
                            // Should have another one for AOE damage.
                            healthDmgAttackRange_W += UnitType.LEVEL_THREE_PAINT_TOWER.attackStrength;
                        }
                        if (d < minDistToEnemy_W) minDistToEnemy_W = d;
                        break addEnemyW;
                    }
                    case LEVEL_TWO_DEFENSE_TOWER: {
                        if (actionReady && d <= splasherActionRadiusSquared) {
                            myHealthDmg_W = splasherAttackStrength;
                        }
                        if (d <= UnitType.LEVEL_TWO_DEFENSE_TOWER.actionRadiusSquared) {
                            // Should have another one for AOE damage.
                            healthDmgAttackRange_W += UnitType.LEVEL_TWO_DEFENSE_TOWER.attackStrength;
                        }
                        if (d < minDistToEnemy_W) minDistToEnemy_W = d;
                        break addEnemyW;
                    }
                    case LEVEL_TWO_MONEY_TOWER: {
                        if (actionReady && d <= splasherActionRadiusSquared) {
                            myHealthDmg_W = splasherAttackStrength;
                        }
                        if (d <= UnitType.LEVEL_TWO_MONEY_TOWER.actionRadiusSquared) {
                            // Should have another one for AOE damage.
                            healthDmgAttackRange_W += UnitType.LEVEL_TWO_MONEY_TOWER.attackStrength;
                        }
                        if (d < minDistToEnemy_W) minDistToEnemy_W = d;
                        break addEnemyW;
                    }
                    case LEVEL_TWO_PAINT_TOWER: {
                        if (actionReady && d <= splasherActionRadiusSquared) {
                            myHealthDmg_W = splasherAttackStrength;
                        }
                        if (d <= UnitType.LEVEL_TWO_PAINT_TOWER.actionRadiusSquared) {
                            // Should have another one for AOE damage.
                            healthDmgAttackRange_W += UnitType.LEVEL_TWO_PAINT_TOWER.attackStrength;
                        }
                        if (d < minDistToEnemy_W) minDistToEnemy_W = d;
                        break addEnemyW;
                    }
                    
                    default: break addEnemyW;
                }
            }
            
            addEnemyNW: {
                if (!canMove_NW) break addEnemyNW;
                int d = targetLoc_NW.distanceSquaredTo(robot.location);
                switch (robot.type) {
                    case LEVEL_ONE_DEFENSE_TOWER: {
                        if (actionReady && d <= splasherActionRadiusSquared) {
                            myHealthDmg_NW = splasherAttackStrength;
                        }
                        if (d <= UnitType.LEVEL_ONE_DEFENSE_TOWER.actionRadiusSquared) {
                            // Should have another one for AOE damage.
                            healthDmgAttackRange_NW += UnitType.LEVEL_ONE_DEFENSE_TOWER.attackStrength;
                        }
                        if (d < minDistToEnemy_NW) minDistToEnemy_NW = d;
                        break addEnemyNW;
                    }
                    case LEVEL_ONE_MONEY_TOWER: {
                        if (actionReady && d <= splasherActionRadiusSquared) {
                            myHealthDmg_NW = splasherAttackStrength;
                        }
                        if (d <= UnitType.LEVEL_ONE_MONEY_TOWER.actionRadiusSquared) {
                            // Should have another one for AOE damage.
                            healthDmgAttackRange_NW += UnitType.LEVEL_ONE_MONEY_TOWER.attackStrength;
                        }
                        if (d < minDistToEnemy_NW) minDistToEnemy_NW = d;
                        break addEnemyNW;
                    }
                    case LEVEL_ONE_PAINT_TOWER: {
                        if (actionReady && d <= splasherActionRadiusSquared) {
                            myHealthDmg_NW = splasherAttackStrength;
                        }
                        if (d <= UnitType.LEVEL_ONE_PAINT_TOWER.actionRadiusSquared) {
                            // Should have another one for AOE damage.
                            healthDmgAttackRange_NW += UnitType.LEVEL_ONE_PAINT_TOWER.attackStrength;
                        }
                        if (d < minDistToEnemy_NW) minDistToEnemy_NW = d;
                        break addEnemyNW;
                    }
                    case LEVEL_THREE_DEFENSE_TOWER: {
                        if (actionReady && d <= splasherActionRadiusSquared) {
                            myHealthDmg_NW = splasherAttackStrength;
                        }
                        if (d <= UnitType.LEVEL_THREE_DEFENSE_TOWER.actionRadiusSquared) {
                            // Should have another one for AOE damage.
                            healthDmgAttackRange_NW += UnitType.LEVEL_THREE_DEFENSE_TOWER.attackStrength;
                        }
                        if (d < minDistToEnemy_NW) minDistToEnemy_NW = d;
                        break addEnemyNW;
                    }
                    case LEVEL_THREE_MONEY_TOWER: {
                        if (actionReady && d <= splasherActionRadiusSquared) {
                            myHealthDmg_NW = splasherAttackStrength;
                        }
                        if (d <= UnitType.LEVEL_THREE_MONEY_TOWER.actionRadiusSquared) {
                            // Should have another one for AOE damage.
                            healthDmgAttackRange_NW += UnitType.LEVEL_THREE_MONEY_TOWER.attackStrength;
                        }
                        if (d < minDistToEnemy_NW) minDistToEnemy_NW = d;
                        break addEnemyNW;
                    }
                    case LEVEL_THREE_PAINT_TOWER: {
                        if (actionReady && d <= splasherActionRadiusSquared) {
                            myHealthDmg_NW = splasherAttackStrength;
                        }
                        if (d <= UnitType.LEVEL_THREE_PAINT_TOWER.actionRadiusSquared) {
                            // Should have another one for AOE damage.
                            healthDmgAttackRange_NW += UnitType.LEVEL_THREE_PAINT_TOWER.attackStrength;
                        }
                        if (d < minDistToEnemy_NW) minDistToEnemy_NW = d;
                        break addEnemyNW;
                    }
                    case LEVEL_TWO_DEFENSE_TOWER: {
                        if (actionReady && d <= splasherActionRadiusSquared) {
                            myHealthDmg_NW = splasherAttackStrength;
                        }
                        if (d <= UnitType.LEVEL_TWO_DEFENSE_TOWER.actionRadiusSquared) {
                            // Should have another one for AOE damage.
                            healthDmgAttackRange_NW += UnitType.LEVEL_TWO_DEFENSE_TOWER.attackStrength;
                        }
                        if (d < minDistToEnemy_NW) minDistToEnemy_NW = d;
                        break addEnemyNW;
                    }
                    case LEVEL_TWO_MONEY_TOWER: {
                        if (actionReady && d <= splasherActionRadiusSquared) {
                            myHealthDmg_NW = splasherAttackStrength;
                        }
                        if (d <= UnitType.LEVEL_TWO_MONEY_TOWER.actionRadiusSquared) {
                            // Should have another one for AOE damage.
                            healthDmgAttackRange_NW += UnitType.LEVEL_TWO_MONEY_TOWER.attackStrength;
                        }
                        if (d < minDistToEnemy_NW) minDistToEnemy_NW = d;
                        break addEnemyNW;
                    }
                    case LEVEL_TWO_PAINT_TOWER: {
                        if (actionReady && d <= splasherActionRadiusSquared) {
                            myHealthDmg_NW = splasherAttackStrength;
                        }
                        if (d <= UnitType.LEVEL_TWO_PAINT_TOWER.actionRadiusSquared) {
                            // Should have another one for AOE damage.
                            healthDmgAttackRange_NW += UnitType.LEVEL_TWO_PAINT_TOWER.attackStrength;
                        }
                        if (d < minDistToEnemy_NW) minDistToEnemy_NW = d;
                        break addEnemyNW;
                    }
                    
                    default: break addEnemyNW;
                }
            }
            
            addEnemyC: {
                if (!canMove_C) break addEnemyC;
                int d = targetLoc_C.distanceSquaredTo(robot.location);
                switch (robot.type) {
                    case LEVEL_ONE_DEFENSE_TOWER: {
                        if (actionReady && d <= splasherActionRadiusSquared) {
                            myHealthDmg_C = splasherAttackStrength;
                        }
                        if (d <= UnitType.LEVEL_ONE_DEFENSE_TOWER.actionRadiusSquared) {
                            // Should have another one for AOE damage.
                            healthDmgAttackRange_C += UnitType.LEVEL_ONE_DEFENSE_TOWER.attackStrength;
                        }
                        if (d < minDistToEnemy_C) minDistToEnemy_C = d;
                        break addEnemyC;
                    }
                    case LEVEL_ONE_MONEY_TOWER: {
                        if (actionReady && d <= splasherActionRadiusSquared) {
                            myHealthDmg_C = splasherAttackStrength;
                        }
                        if (d <= UnitType.LEVEL_ONE_MONEY_TOWER.actionRadiusSquared) {
                            // Should have another one for AOE damage.
                            healthDmgAttackRange_C += UnitType.LEVEL_ONE_MONEY_TOWER.attackStrength;
                        }
                        if (d < minDistToEnemy_C) minDistToEnemy_C = d;
                        break addEnemyC;
                    }
                    case LEVEL_ONE_PAINT_TOWER: {
                        if (actionReady && d <= splasherActionRadiusSquared) {
                            myHealthDmg_C = splasherAttackStrength;
                        }
                        if (d <= UnitType.LEVEL_ONE_PAINT_TOWER.actionRadiusSquared) {
                            // Should have another one for AOE damage.
                            healthDmgAttackRange_C += UnitType.LEVEL_ONE_PAINT_TOWER.attackStrength;
                        }
                        if (d < minDistToEnemy_C) minDistToEnemy_C = d;
                        break addEnemyC;
                    }
                    case LEVEL_THREE_DEFENSE_TOWER: {
                        if (actionReady && d <= splasherActionRadiusSquared) {
                            myHealthDmg_C = splasherAttackStrength;
                        }
                        if (d <= UnitType.LEVEL_THREE_DEFENSE_TOWER.actionRadiusSquared) {
                            // Should have another one for AOE damage.
                            healthDmgAttackRange_C += UnitType.LEVEL_THREE_DEFENSE_TOWER.attackStrength;
                        }
                        if (d < minDistToEnemy_C) minDistToEnemy_C = d;
                        break addEnemyC;
                    }
                    case LEVEL_THREE_MONEY_TOWER: {
                        if (actionReady && d <= splasherActionRadiusSquared) {
                            myHealthDmg_C = splasherAttackStrength;
                        }
                        if (d <= UnitType.LEVEL_THREE_MONEY_TOWER.actionRadiusSquared) {
                            // Should have another one for AOE damage.
                            healthDmgAttackRange_C += UnitType.LEVEL_THREE_MONEY_TOWER.attackStrength;
                        }
                        if (d < minDistToEnemy_C) minDistToEnemy_C = d;
                        break addEnemyC;
                    }
                    case LEVEL_THREE_PAINT_TOWER: {
                        if (actionReady && d <= splasherActionRadiusSquared) {
                            myHealthDmg_C = splasherAttackStrength;
                        }
                        if (d <= UnitType.LEVEL_THREE_PAINT_TOWER.actionRadiusSquared) {
                            // Should have another one for AOE damage.
                            healthDmgAttackRange_C += UnitType.LEVEL_THREE_PAINT_TOWER.attackStrength;
                        }
                        if (d < minDistToEnemy_C) minDistToEnemy_C = d;
                        break addEnemyC;
                    }
                    case LEVEL_TWO_DEFENSE_TOWER: {
                        if (actionReady && d <= splasherActionRadiusSquared) {
                            myHealthDmg_C = splasherAttackStrength;
                        }
                        if (d <= UnitType.LEVEL_TWO_DEFENSE_TOWER.actionRadiusSquared) {
                            // Should have another one for AOE damage.
                            healthDmgAttackRange_C += UnitType.LEVEL_TWO_DEFENSE_TOWER.attackStrength;
                        }
                        if (d < minDistToEnemy_C) minDistToEnemy_C = d;
                        break addEnemyC;
                    }
                    case LEVEL_TWO_MONEY_TOWER: {
                        if (actionReady && d <= splasherActionRadiusSquared) {
                            myHealthDmg_C = splasherAttackStrength;
                        }
                        if (d <= UnitType.LEVEL_TWO_MONEY_TOWER.actionRadiusSquared) {
                            // Should have another one for AOE damage.
                            healthDmgAttackRange_C += UnitType.LEVEL_TWO_MONEY_TOWER.attackStrength;
                        }
                        if (d < minDistToEnemy_C) minDistToEnemy_C = d;
                        break addEnemyC;
                    }
                    case LEVEL_TWO_PAINT_TOWER: {
                        if (actionReady && d <= splasherActionRadiusSquared) {
                            myHealthDmg_C = splasherAttackStrength;
                        }
                        if (d <= UnitType.LEVEL_TWO_PAINT_TOWER.actionRadiusSquared) {
                            // Should have another one for AOE damage.
                            healthDmgAttackRange_C += UnitType.LEVEL_TWO_PAINT_TOWER.attackStrength;
                        }
                        if (d < minDistToEnemy_C) minDistToEnemy_C = d;
                        break addEnemyC;
                    }
                    
                    default: break addEnemyC;
                }
            }
            
        }

        

        boolean bestWins = false;
        Direction bestDir = Direction.NORTH;
        MapLocation targetLoc_best = myloc.add(Direction.NORTH);
        boolean canMove_best = (rc.canMove(Direction.NORTH));
        PaintType paint_best = PaintType.ENEMY_PRIMARY;
        if (rc.canSenseLocation(targetLoc_best)) {
            paint_best = rc.senseMapInfo(targetLoc_best).getPaint();
            switch (rc.senseMapInfo(targetLoc_best).getPaint()) {
                 case PaintType.ENEMY_PRIMARY -> canMove_best = false;
                 case PaintType.ENEMY_SECONDARY -> canMove_best = false;
                 default -> {}
            }
        }
        double healthDmgAttackRange_best = 0;
        double myHealthDmg_best = 0;
        int minDistToEnemy_best = 100000;
        
        
        bestWins = canMove_best;
        chooseBestNE: {
            if (!canMove_NE || !canMove_best) break chooseBestNE;
            double bestHealthDmgDiff = healthDmgAttackRange_best - myHealthDmg_best;
            double otherHealthDmgDiff = healthDmgAttackRange_NE - myHealthDmg_NE;
            if (bestHealthDmgDiff != otherHealthDmgDiff) {
                bestWins = (bestHealthDmgDiff < otherHealthDmgDiff);
                break chooseBestNE;
            }
            if (paint_best.isAlly() != paint_NE.isAlly()) {
                bestWins = paint_best.isAlly();
                break chooseBestNE;
            }
            bestWins = (minDistToEnemy_best <= minDistToEnemy_NE);
            break chooseBestNE;
        }
        
        
        if (!bestWins) {
            targetLoc_best = targetLoc_NE;
            canMove_best = canMove_NE;
            healthDmgAttackRange_best = healthDmgAttackRange_NE;
            myHealthDmg_best = myHealthDmg_NE;
            minDistToEnemy_best = minDistToEnemy_NE;
            paint_best = paint_NE;
            bestDir = Direction.NORTHEAST;
        }
        
        
        bestWins = canMove_best;
        chooseBestE: {
            if (!canMove_E || !canMove_best) break chooseBestE;
            double bestHealthDmgDiff = healthDmgAttackRange_best - myHealthDmg_best;
            double otherHealthDmgDiff = healthDmgAttackRange_E - myHealthDmg_E;
            if (bestHealthDmgDiff != otherHealthDmgDiff) {
                bestWins = (bestHealthDmgDiff < otherHealthDmgDiff);
                break chooseBestE;
            }
            if (paint_best.isAlly() != paint_E.isAlly()) {
                bestWins = paint_best.isAlly();
                break chooseBestE;
            }
            bestWins = (minDistToEnemy_best <= minDistToEnemy_E);
            break chooseBestE;
        }
        
        
        if (!bestWins) {
            targetLoc_best = targetLoc_E;
            canMove_best = canMove_E;
            healthDmgAttackRange_best = healthDmgAttackRange_E;
            myHealthDmg_best = myHealthDmg_E;
            minDistToEnemy_best = minDistToEnemy_E;
            paint_best = paint_E;
            bestDir = Direction.EAST;
        }
        
        
        bestWins = canMove_best;
        chooseBestSE: {
            if (!canMove_SE || !canMove_best) break chooseBestSE;
            double bestHealthDmgDiff = healthDmgAttackRange_best - myHealthDmg_best;
            double otherHealthDmgDiff = healthDmgAttackRange_SE - myHealthDmg_SE;
            if (bestHealthDmgDiff != otherHealthDmgDiff) {
                bestWins = (bestHealthDmgDiff < otherHealthDmgDiff);
                break chooseBestSE;
            }
            if (paint_best.isAlly() != paint_SE.isAlly()) {
                bestWins = paint_best.isAlly();
                break chooseBestSE;
            }
            bestWins = (minDistToEnemy_best <= minDistToEnemy_SE);
            break chooseBestSE;
        }
        
        
        if (!bestWins) {
            targetLoc_best = targetLoc_SE;
            canMove_best = canMove_SE;
            healthDmgAttackRange_best = healthDmgAttackRange_SE;
            myHealthDmg_best = myHealthDmg_SE;
            minDistToEnemy_best = minDistToEnemy_SE;
            paint_best = paint_SE;
            bestDir = Direction.SOUTHEAST;
        }
        
        
        bestWins = canMove_best;
        chooseBestS: {
            if (!canMove_S || !canMove_best) break chooseBestS;
            double bestHealthDmgDiff = healthDmgAttackRange_best - myHealthDmg_best;
            double otherHealthDmgDiff = healthDmgAttackRange_S - myHealthDmg_S;
            if (bestHealthDmgDiff != otherHealthDmgDiff) {
                bestWins = (bestHealthDmgDiff < otherHealthDmgDiff);
                break chooseBestS;
            }
            if (paint_best.isAlly() != paint_S.isAlly()) {
                bestWins = paint_best.isAlly();
                break chooseBestS;
            }
            bestWins = (minDistToEnemy_best <= minDistToEnemy_S);
            break chooseBestS;
        }
        
        
        if (!bestWins) {
            targetLoc_best = targetLoc_S;
            canMove_best = canMove_S;
            healthDmgAttackRange_best = healthDmgAttackRange_S;
            myHealthDmg_best = myHealthDmg_S;
            minDistToEnemy_best = minDistToEnemy_S;
            paint_best = paint_S;
            bestDir = Direction.SOUTH;
        }
        
        
        bestWins = canMove_best;
        chooseBestSW: {
            if (!canMove_SW || !canMove_best) break chooseBestSW;
            double bestHealthDmgDiff = healthDmgAttackRange_best - myHealthDmg_best;
            double otherHealthDmgDiff = healthDmgAttackRange_SW - myHealthDmg_SW;
            if (bestHealthDmgDiff != otherHealthDmgDiff) {
                bestWins = (bestHealthDmgDiff < otherHealthDmgDiff);
                break chooseBestSW;
            }
            if (paint_best.isAlly() != paint_SW.isAlly()) {
                bestWins = paint_best.isAlly();
                break chooseBestSW;
            }
            bestWins = (minDistToEnemy_best <= minDistToEnemy_SW);
            break chooseBestSW;
        }
        
        
        if (!bestWins) {
            targetLoc_best = targetLoc_SW;
            canMove_best = canMove_SW;
            healthDmgAttackRange_best = healthDmgAttackRange_SW;
            myHealthDmg_best = myHealthDmg_SW;
            minDistToEnemy_best = minDistToEnemy_SW;
            paint_best = paint_SW;
            bestDir = Direction.SOUTHWEST;
        }
        
        
        bestWins = canMove_best;
        chooseBestW: {
            if (!canMove_W || !canMove_best) break chooseBestW;
            double bestHealthDmgDiff = healthDmgAttackRange_best - myHealthDmg_best;
            double otherHealthDmgDiff = healthDmgAttackRange_W - myHealthDmg_W;
            if (bestHealthDmgDiff != otherHealthDmgDiff) {
                bestWins = (bestHealthDmgDiff < otherHealthDmgDiff);
                break chooseBestW;
            }
            if (paint_best.isAlly() != paint_W.isAlly()) {
                bestWins = paint_best.isAlly();
                break chooseBestW;
            }
            bestWins = (minDistToEnemy_best <= minDistToEnemy_W);
            break chooseBestW;
        }
        
        
        if (!bestWins) {
            targetLoc_best = targetLoc_W;
            canMove_best = canMove_W;
            healthDmgAttackRange_best = healthDmgAttackRange_W;
            myHealthDmg_best = myHealthDmg_W;
            minDistToEnemy_best = minDistToEnemy_W;
            paint_best = paint_W;
            bestDir = Direction.WEST;
        }
        
        
        bestWins = canMove_best;
        chooseBestNW: {
            if (!canMove_NW || !canMove_best) break chooseBestNW;
            double bestHealthDmgDiff = healthDmgAttackRange_best - myHealthDmg_best;
            double otherHealthDmgDiff = healthDmgAttackRange_NW - myHealthDmg_NW;
            if (bestHealthDmgDiff != otherHealthDmgDiff) {
                bestWins = (bestHealthDmgDiff < otherHealthDmgDiff);
                break chooseBestNW;
            }
            if (paint_best.isAlly() != paint_NW.isAlly()) {
                bestWins = paint_best.isAlly();
                break chooseBestNW;
            }
            bestWins = (minDistToEnemy_best <= minDistToEnemy_NW);
            break chooseBestNW;
        }
        
        
        if (!bestWins) {
            targetLoc_best = targetLoc_NW;
            canMove_best = canMove_NW;
            healthDmgAttackRange_best = healthDmgAttackRange_NW;
            myHealthDmg_best = myHealthDmg_NW;
            minDistToEnemy_best = minDistToEnemy_NW;
            paint_best = paint_NW;
            bestDir = Direction.NORTHWEST;
        }
        
        
        bestWins = canMove_best;
        chooseBestC: {
            if (!canMove_C || !canMove_best) break chooseBestC;
            double bestHealthDmgDiff = healthDmgAttackRange_best - myHealthDmg_best;
            double otherHealthDmgDiff = healthDmgAttackRange_C - myHealthDmg_C;
            if (bestHealthDmgDiff != otherHealthDmgDiff) {
                bestWins = (bestHealthDmgDiff < otherHealthDmgDiff);
                break chooseBestC;
            }
            if (paint_best.isAlly() != paint_C.isAlly()) {
                bestWins = paint_best.isAlly();
                break chooseBestC;
            }
            bestWins = (minDistToEnemy_best <= minDistToEnemy_C);
            break chooseBestC;
        }
        
        
        if (!bestWins) {
            targetLoc_best = targetLoc_C;
            canMove_best = canMove_C;
            healthDmgAttackRange_best = healthDmgAttackRange_C;
            myHealthDmg_best = myHealthDmg_C;
            minDistToEnemy_best = minDistToEnemy_C;
            paint_best = paint_C;
            bestDir = Direction.CENTER;
        }
        
        

        

        if (rc.canMove(bestDir)) {
            rc.move(bestDir);
        }
        splasherTryAttack();
    }
    
    
    public static void mopperAttackMicro() throws GameActionException {
        mopperTryAttack();
        MapLocation myloc = rc.getLocation();
        MapLocation targetLoc_N = myloc.add(Direction.NORTH);
        boolean canMove_N = (rc.canMove(Direction.NORTH));
        PaintType paint_N = PaintType.ENEMY_PRIMARY;
        if (rc.canSenseLocation(targetLoc_N)) {
            paint_N = rc.senseMapInfo(targetLoc_N).getPaint();
            switch (rc.senseMapInfo(targetLoc_N).getPaint()) {
                 case PaintType.ENEMY_PRIMARY -> canMove_N = false;
                 case PaintType.ENEMY_SECONDARY -> canMove_N = false;
                 default -> {}
            }
        }
        double healthDmgAttackRange_N = 0;
        double myHealthDmg_N = 0;
        int minDistToEnemy_N = 100000;
        
        MapLocation targetLoc_NE = myloc.add(Direction.NORTHEAST);
        boolean canMove_NE = (rc.canMove(Direction.NORTHEAST));
        PaintType paint_NE = PaintType.ENEMY_PRIMARY;
        if (rc.canSenseLocation(targetLoc_NE)) {
            paint_NE = rc.senseMapInfo(targetLoc_NE).getPaint();
            switch (rc.senseMapInfo(targetLoc_NE).getPaint()) {
                 case PaintType.ENEMY_PRIMARY -> canMove_NE = false;
                 case PaintType.ENEMY_SECONDARY -> canMove_NE = false;
                 default -> {}
            }
        }
        double healthDmgAttackRange_NE = 0;
        double myHealthDmg_NE = 0;
        int minDistToEnemy_NE = 100000;
        
        MapLocation targetLoc_E = myloc.add(Direction.EAST);
        boolean canMove_E = (rc.canMove(Direction.EAST));
        PaintType paint_E = PaintType.ENEMY_PRIMARY;
        if (rc.canSenseLocation(targetLoc_E)) {
            paint_E = rc.senseMapInfo(targetLoc_E).getPaint();
            switch (rc.senseMapInfo(targetLoc_E).getPaint()) {
                 case PaintType.ENEMY_PRIMARY -> canMove_E = false;
                 case PaintType.ENEMY_SECONDARY -> canMove_E = false;
                 default -> {}
            }
        }
        double healthDmgAttackRange_E = 0;
        double myHealthDmg_E = 0;
        int minDistToEnemy_E = 100000;
        
        MapLocation targetLoc_SE = myloc.add(Direction.SOUTHEAST);
        boolean canMove_SE = (rc.canMove(Direction.SOUTHEAST));
        PaintType paint_SE = PaintType.ENEMY_PRIMARY;
        if (rc.canSenseLocation(targetLoc_SE)) {
            paint_SE = rc.senseMapInfo(targetLoc_SE).getPaint();
            switch (rc.senseMapInfo(targetLoc_SE).getPaint()) {
                 case PaintType.ENEMY_PRIMARY -> canMove_SE = false;
                 case PaintType.ENEMY_SECONDARY -> canMove_SE = false;
                 default -> {}
            }
        }
        double healthDmgAttackRange_SE = 0;
        double myHealthDmg_SE = 0;
        int minDistToEnemy_SE = 100000;
        
        MapLocation targetLoc_S = myloc.add(Direction.SOUTH);
        boolean canMove_S = (rc.canMove(Direction.SOUTH));
        PaintType paint_S = PaintType.ENEMY_PRIMARY;
        if (rc.canSenseLocation(targetLoc_S)) {
            paint_S = rc.senseMapInfo(targetLoc_S).getPaint();
            switch (rc.senseMapInfo(targetLoc_S).getPaint()) {
                 case PaintType.ENEMY_PRIMARY -> canMove_S = false;
                 case PaintType.ENEMY_SECONDARY -> canMove_S = false;
                 default -> {}
            }
        }
        double healthDmgAttackRange_S = 0;
        double myHealthDmg_S = 0;
        int minDistToEnemy_S = 100000;
        
        MapLocation targetLoc_SW = myloc.add(Direction.SOUTHWEST);
        boolean canMove_SW = (rc.canMove(Direction.SOUTHWEST));
        PaintType paint_SW = PaintType.ENEMY_PRIMARY;
        if (rc.canSenseLocation(targetLoc_SW)) {
            paint_SW = rc.senseMapInfo(targetLoc_SW).getPaint();
            switch (rc.senseMapInfo(targetLoc_SW).getPaint()) {
                 case PaintType.ENEMY_PRIMARY -> canMove_SW = false;
                 case PaintType.ENEMY_SECONDARY -> canMove_SW = false;
                 default -> {}
            }
        }
        double healthDmgAttackRange_SW = 0;
        double myHealthDmg_SW = 0;
        int minDistToEnemy_SW = 100000;
        
        MapLocation targetLoc_W = myloc.add(Direction.WEST);
        boolean canMove_W = (rc.canMove(Direction.WEST));
        PaintType paint_W = PaintType.ENEMY_PRIMARY;
        if (rc.canSenseLocation(targetLoc_W)) {
            paint_W = rc.senseMapInfo(targetLoc_W).getPaint();
            switch (rc.senseMapInfo(targetLoc_W).getPaint()) {
                 case PaintType.ENEMY_PRIMARY -> canMove_W = false;
                 case PaintType.ENEMY_SECONDARY -> canMove_W = false;
                 default -> {}
            }
        }
        double healthDmgAttackRange_W = 0;
        double myHealthDmg_W = 0;
        int minDistToEnemy_W = 100000;
        
        MapLocation targetLoc_NW = myloc.add(Direction.NORTHWEST);
        boolean canMove_NW = (rc.canMove(Direction.NORTHWEST));
        PaintType paint_NW = PaintType.ENEMY_PRIMARY;
        if (rc.canSenseLocation(targetLoc_NW)) {
            paint_NW = rc.senseMapInfo(targetLoc_NW).getPaint();
            switch (rc.senseMapInfo(targetLoc_NW).getPaint()) {
                 case PaintType.ENEMY_PRIMARY -> canMove_NW = false;
                 case PaintType.ENEMY_SECONDARY -> canMove_NW = false;
                 default -> {}
            }
        }
        double healthDmgAttackRange_NW = 0;
        double myHealthDmg_NW = 0;
        int minDistToEnemy_NW = 100000;
        
        MapLocation targetLoc_C = myloc.add(Direction.CENTER);
        boolean canMove_C = (true);
        PaintType paint_C = PaintType.ENEMY_PRIMARY;
        if (rc.canSenseLocation(targetLoc_C)) {
            paint_C = rc.senseMapInfo(targetLoc_C).getPaint();
            switch (rc.senseMapInfo(targetLoc_C).getPaint()) {
                 case PaintType.ENEMY_PRIMARY -> canMove_C = false;
                 case PaintType.ENEMY_SECONDARY -> canMove_C = false;
                 default -> {}
            }
        }
        double healthDmgAttackRange_C = 0;
        double myHealthDmg_C = 0;
        int minDistToEnemy_C = 100000;
        
        boolean actionReady = rc.isActionReady();
        for (int i = Globals.friends.length; --i >= 0; ) {
            RobotInfo robot = Globals.friends[i];
            addAllyN: {
                
            }
            addAllyNE: {
                
            }
            addAllyE: {
                
            }
            addAllySE: {
                
            }
            addAllyS: {
                
            }
            addAllySW: {
                
            }
            addAllyW: {
                
            }
            addAllyNW: {
                
            }
            addAllyC: {
                
            }
            
        }

        for (int i = Globals.enemies.length; --i >= 0; ) {
            RobotInfo robot = Globals.enemies[i];
            
            addEnemyN: {
                if (!canMove_N) break addEnemyN;
                int d = targetLoc_N.distanceSquaredTo(robot.location);
                switch (robot.type) {
                    case LEVEL_ONE_DEFENSE_TOWER: {
                        if (actionReady && d <= mopperActionRadiusSquared) {
                            myHealthDmg_N = mopperAttackStrength;
                        }
                        if (d <= UnitType.LEVEL_ONE_DEFENSE_TOWER.actionRadiusSquared) {
                            // Should have another one for AOE damage.
                            healthDmgAttackRange_N += UnitType.LEVEL_ONE_DEFENSE_TOWER.attackStrength;
                        }
                        if (d < minDistToEnemy_N) minDistToEnemy_N = d;
                        break addEnemyN;
                    }
                    case LEVEL_ONE_MONEY_TOWER: {
                        if (actionReady && d <= mopperActionRadiusSquared) {
                            myHealthDmg_N = mopperAttackStrength;
                        }
                        if (d <= UnitType.LEVEL_ONE_MONEY_TOWER.actionRadiusSquared) {
                            // Should have another one for AOE damage.
                            healthDmgAttackRange_N += UnitType.LEVEL_ONE_MONEY_TOWER.attackStrength;
                        }
                        if (d < minDistToEnemy_N) minDistToEnemy_N = d;
                        break addEnemyN;
                    }
                    case LEVEL_ONE_PAINT_TOWER: {
                        if (actionReady && d <= mopperActionRadiusSquared) {
                            myHealthDmg_N = mopperAttackStrength;
                        }
                        if (d <= UnitType.LEVEL_ONE_PAINT_TOWER.actionRadiusSquared) {
                            // Should have another one for AOE damage.
                            healthDmgAttackRange_N += UnitType.LEVEL_ONE_PAINT_TOWER.attackStrength;
                        }
                        if (d < minDistToEnemy_N) minDistToEnemy_N = d;
                        break addEnemyN;
                    }
                    case LEVEL_THREE_DEFENSE_TOWER: {
                        if (actionReady && d <= mopperActionRadiusSquared) {
                            myHealthDmg_N = mopperAttackStrength;
                        }
                        if (d <= UnitType.LEVEL_THREE_DEFENSE_TOWER.actionRadiusSquared) {
                            // Should have another one for AOE damage.
                            healthDmgAttackRange_N += UnitType.LEVEL_THREE_DEFENSE_TOWER.attackStrength;
                        }
                        if (d < minDistToEnemy_N) minDistToEnemy_N = d;
                        break addEnemyN;
                    }
                    case LEVEL_THREE_MONEY_TOWER: {
                        if (actionReady && d <= mopperActionRadiusSquared) {
                            myHealthDmg_N = mopperAttackStrength;
                        }
                        if (d <= UnitType.LEVEL_THREE_MONEY_TOWER.actionRadiusSquared) {
                            // Should have another one for AOE damage.
                            healthDmgAttackRange_N += UnitType.LEVEL_THREE_MONEY_TOWER.attackStrength;
                        }
                        if (d < minDistToEnemy_N) minDistToEnemy_N = d;
                        break addEnemyN;
                    }
                    case LEVEL_THREE_PAINT_TOWER: {
                        if (actionReady && d <= mopperActionRadiusSquared) {
                            myHealthDmg_N = mopperAttackStrength;
                        }
                        if (d <= UnitType.LEVEL_THREE_PAINT_TOWER.actionRadiusSquared) {
                            // Should have another one for AOE damage.
                            healthDmgAttackRange_N += UnitType.LEVEL_THREE_PAINT_TOWER.attackStrength;
                        }
                        if (d < minDistToEnemy_N) minDistToEnemy_N = d;
                        break addEnemyN;
                    }
                    case LEVEL_TWO_DEFENSE_TOWER: {
                        if (actionReady && d <= mopperActionRadiusSquared) {
                            myHealthDmg_N = mopperAttackStrength;
                        }
                        if (d <= UnitType.LEVEL_TWO_DEFENSE_TOWER.actionRadiusSquared) {
                            // Should have another one for AOE damage.
                            healthDmgAttackRange_N += UnitType.LEVEL_TWO_DEFENSE_TOWER.attackStrength;
                        }
                        if (d < minDistToEnemy_N) minDistToEnemy_N = d;
                        break addEnemyN;
                    }
                    case LEVEL_TWO_MONEY_TOWER: {
                        if (actionReady && d <= mopperActionRadiusSquared) {
                            myHealthDmg_N = mopperAttackStrength;
                        }
                        if (d <= UnitType.LEVEL_TWO_MONEY_TOWER.actionRadiusSquared) {
                            // Should have another one for AOE damage.
                            healthDmgAttackRange_N += UnitType.LEVEL_TWO_MONEY_TOWER.attackStrength;
                        }
                        if (d < minDistToEnemy_N) minDistToEnemy_N = d;
                        break addEnemyN;
                    }
                    case LEVEL_TWO_PAINT_TOWER: {
                        if (actionReady && d <= mopperActionRadiusSquared) {
                            myHealthDmg_N = mopperAttackStrength;
                        }
                        if (d <= UnitType.LEVEL_TWO_PAINT_TOWER.actionRadiusSquared) {
                            // Should have another one for AOE damage.
                            healthDmgAttackRange_N += UnitType.LEVEL_TWO_PAINT_TOWER.attackStrength;
                        }
                        if (d < minDistToEnemy_N) minDistToEnemy_N = d;
                        break addEnemyN;
                    }
                    
                    default: break addEnemyN;
                }
            }
            
            addEnemyNE: {
                if (!canMove_NE) break addEnemyNE;
                int d = targetLoc_NE.distanceSquaredTo(robot.location);
                switch (robot.type) {
                    case LEVEL_ONE_DEFENSE_TOWER: {
                        if (actionReady && d <= mopperActionRadiusSquared) {
                            myHealthDmg_NE = mopperAttackStrength;
                        }
                        if (d <= UnitType.LEVEL_ONE_DEFENSE_TOWER.actionRadiusSquared) {
                            // Should have another one for AOE damage.
                            healthDmgAttackRange_NE += UnitType.LEVEL_ONE_DEFENSE_TOWER.attackStrength;
                        }
                        if (d < minDistToEnemy_NE) minDistToEnemy_NE = d;
                        break addEnemyNE;
                    }
                    case LEVEL_ONE_MONEY_TOWER: {
                        if (actionReady && d <= mopperActionRadiusSquared) {
                            myHealthDmg_NE = mopperAttackStrength;
                        }
                        if (d <= UnitType.LEVEL_ONE_MONEY_TOWER.actionRadiusSquared) {
                            // Should have another one for AOE damage.
                            healthDmgAttackRange_NE += UnitType.LEVEL_ONE_MONEY_TOWER.attackStrength;
                        }
                        if (d < minDistToEnemy_NE) minDistToEnemy_NE = d;
                        break addEnemyNE;
                    }
                    case LEVEL_ONE_PAINT_TOWER: {
                        if (actionReady && d <= mopperActionRadiusSquared) {
                            myHealthDmg_NE = mopperAttackStrength;
                        }
                        if (d <= UnitType.LEVEL_ONE_PAINT_TOWER.actionRadiusSquared) {
                            // Should have another one for AOE damage.
                            healthDmgAttackRange_NE += UnitType.LEVEL_ONE_PAINT_TOWER.attackStrength;
                        }
                        if (d < minDistToEnemy_NE) minDistToEnemy_NE = d;
                        break addEnemyNE;
                    }
                    case LEVEL_THREE_DEFENSE_TOWER: {
                        if (actionReady && d <= mopperActionRadiusSquared) {
                            myHealthDmg_NE = mopperAttackStrength;
                        }
                        if (d <= UnitType.LEVEL_THREE_DEFENSE_TOWER.actionRadiusSquared) {
                            // Should have another one for AOE damage.
                            healthDmgAttackRange_NE += UnitType.LEVEL_THREE_DEFENSE_TOWER.attackStrength;
                        }
                        if (d < minDistToEnemy_NE) minDistToEnemy_NE = d;
                        break addEnemyNE;
                    }
                    case LEVEL_THREE_MONEY_TOWER: {
                        if (actionReady && d <= mopperActionRadiusSquared) {
                            myHealthDmg_NE = mopperAttackStrength;
                        }
                        if (d <= UnitType.LEVEL_THREE_MONEY_TOWER.actionRadiusSquared) {
                            // Should have another one for AOE damage.
                            healthDmgAttackRange_NE += UnitType.LEVEL_THREE_MONEY_TOWER.attackStrength;
                        }
                        if (d < minDistToEnemy_NE) minDistToEnemy_NE = d;
                        break addEnemyNE;
                    }
                    case LEVEL_THREE_PAINT_TOWER: {
                        if (actionReady && d <= mopperActionRadiusSquared) {
                            myHealthDmg_NE = mopperAttackStrength;
                        }
                        if (d <= UnitType.LEVEL_THREE_PAINT_TOWER.actionRadiusSquared) {
                            // Should have another one for AOE damage.
                            healthDmgAttackRange_NE += UnitType.LEVEL_THREE_PAINT_TOWER.attackStrength;
                        }
                        if (d < minDistToEnemy_NE) minDistToEnemy_NE = d;
                        break addEnemyNE;
                    }
                    case LEVEL_TWO_DEFENSE_TOWER: {
                        if (actionReady && d <= mopperActionRadiusSquared) {
                            myHealthDmg_NE = mopperAttackStrength;
                        }
                        if (d <= UnitType.LEVEL_TWO_DEFENSE_TOWER.actionRadiusSquared) {
                            // Should have another one for AOE damage.
                            healthDmgAttackRange_NE += UnitType.LEVEL_TWO_DEFENSE_TOWER.attackStrength;
                        }
                        if (d < minDistToEnemy_NE) minDistToEnemy_NE = d;
                        break addEnemyNE;
                    }
                    case LEVEL_TWO_MONEY_TOWER: {
                        if (actionReady && d <= mopperActionRadiusSquared) {
                            myHealthDmg_NE = mopperAttackStrength;
                        }
                        if (d <= UnitType.LEVEL_TWO_MONEY_TOWER.actionRadiusSquared) {
                            // Should have another one for AOE damage.
                            healthDmgAttackRange_NE += UnitType.LEVEL_TWO_MONEY_TOWER.attackStrength;
                        }
                        if (d < minDistToEnemy_NE) minDistToEnemy_NE = d;
                        break addEnemyNE;
                    }
                    case LEVEL_TWO_PAINT_TOWER: {
                        if (actionReady && d <= mopperActionRadiusSquared) {
                            myHealthDmg_NE = mopperAttackStrength;
                        }
                        if (d <= UnitType.LEVEL_TWO_PAINT_TOWER.actionRadiusSquared) {
                            // Should have another one for AOE damage.
                            healthDmgAttackRange_NE += UnitType.LEVEL_TWO_PAINT_TOWER.attackStrength;
                        }
                        if (d < minDistToEnemy_NE) minDistToEnemy_NE = d;
                        break addEnemyNE;
                    }
                    
                    default: break addEnemyNE;
                }
            }
            
            addEnemyE: {
                if (!canMove_E) break addEnemyE;
                int d = targetLoc_E.distanceSquaredTo(robot.location);
                switch (robot.type) {
                    case LEVEL_ONE_DEFENSE_TOWER: {
                        if (actionReady && d <= mopperActionRadiusSquared) {
                            myHealthDmg_E = mopperAttackStrength;
                        }
                        if (d <= UnitType.LEVEL_ONE_DEFENSE_TOWER.actionRadiusSquared) {
                            // Should have another one for AOE damage.
                            healthDmgAttackRange_E += UnitType.LEVEL_ONE_DEFENSE_TOWER.attackStrength;
                        }
                        if (d < minDistToEnemy_E) minDistToEnemy_E = d;
                        break addEnemyE;
                    }
                    case LEVEL_ONE_MONEY_TOWER: {
                        if (actionReady && d <= mopperActionRadiusSquared) {
                            myHealthDmg_E = mopperAttackStrength;
                        }
                        if (d <= UnitType.LEVEL_ONE_MONEY_TOWER.actionRadiusSquared) {
                            // Should have another one for AOE damage.
                            healthDmgAttackRange_E += UnitType.LEVEL_ONE_MONEY_TOWER.attackStrength;
                        }
                        if (d < minDistToEnemy_E) minDistToEnemy_E = d;
                        break addEnemyE;
                    }
                    case LEVEL_ONE_PAINT_TOWER: {
                        if (actionReady && d <= mopperActionRadiusSquared) {
                            myHealthDmg_E = mopperAttackStrength;
                        }
                        if (d <= UnitType.LEVEL_ONE_PAINT_TOWER.actionRadiusSquared) {
                            // Should have another one for AOE damage.
                            healthDmgAttackRange_E += UnitType.LEVEL_ONE_PAINT_TOWER.attackStrength;
                        }
                        if (d < minDistToEnemy_E) minDistToEnemy_E = d;
                        break addEnemyE;
                    }
                    case LEVEL_THREE_DEFENSE_TOWER: {
                        if (actionReady && d <= mopperActionRadiusSquared) {
                            myHealthDmg_E = mopperAttackStrength;
                        }
                        if (d <= UnitType.LEVEL_THREE_DEFENSE_TOWER.actionRadiusSquared) {
                            // Should have another one for AOE damage.
                            healthDmgAttackRange_E += UnitType.LEVEL_THREE_DEFENSE_TOWER.attackStrength;
                        }
                        if (d < minDistToEnemy_E) minDistToEnemy_E = d;
                        break addEnemyE;
                    }
                    case LEVEL_THREE_MONEY_TOWER: {
                        if (actionReady && d <= mopperActionRadiusSquared) {
                            myHealthDmg_E = mopperAttackStrength;
                        }
                        if (d <= UnitType.LEVEL_THREE_MONEY_TOWER.actionRadiusSquared) {
                            // Should have another one for AOE damage.
                            healthDmgAttackRange_E += UnitType.LEVEL_THREE_MONEY_TOWER.attackStrength;
                        }
                        if (d < minDistToEnemy_E) minDistToEnemy_E = d;
                        break addEnemyE;
                    }
                    case LEVEL_THREE_PAINT_TOWER: {
                        if (actionReady && d <= mopperActionRadiusSquared) {
                            myHealthDmg_E = mopperAttackStrength;
                        }
                        if (d <= UnitType.LEVEL_THREE_PAINT_TOWER.actionRadiusSquared) {
                            // Should have another one for AOE damage.
                            healthDmgAttackRange_E += UnitType.LEVEL_THREE_PAINT_TOWER.attackStrength;
                        }
                        if (d < minDistToEnemy_E) minDistToEnemy_E = d;
                        break addEnemyE;
                    }
                    case LEVEL_TWO_DEFENSE_TOWER: {
                        if (actionReady && d <= mopperActionRadiusSquared) {
                            myHealthDmg_E = mopperAttackStrength;
                        }
                        if (d <= UnitType.LEVEL_TWO_DEFENSE_TOWER.actionRadiusSquared) {
                            // Should have another one for AOE damage.
                            healthDmgAttackRange_E += UnitType.LEVEL_TWO_DEFENSE_TOWER.attackStrength;
                        }
                        if (d < minDistToEnemy_E) minDistToEnemy_E = d;
                        break addEnemyE;
                    }
                    case LEVEL_TWO_MONEY_TOWER: {
                        if (actionReady && d <= mopperActionRadiusSquared) {
                            myHealthDmg_E = mopperAttackStrength;
                        }
                        if (d <= UnitType.LEVEL_TWO_MONEY_TOWER.actionRadiusSquared) {
                            // Should have another one for AOE damage.
                            healthDmgAttackRange_E += UnitType.LEVEL_TWO_MONEY_TOWER.attackStrength;
                        }
                        if (d < minDistToEnemy_E) minDistToEnemy_E = d;
                        break addEnemyE;
                    }
                    case LEVEL_TWO_PAINT_TOWER: {
                        if (actionReady && d <= mopperActionRadiusSquared) {
                            myHealthDmg_E = mopperAttackStrength;
                        }
                        if (d <= UnitType.LEVEL_TWO_PAINT_TOWER.actionRadiusSquared) {
                            // Should have another one for AOE damage.
                            healthDmgAttackRange_E += UnitType.LEVEL_TWO_PAINT_TOWER.attackStrength;
                        }
                        if (d < minDistToEnemy_E) minDistToEnemy_E = d;
                        break addEnemyE;
                    }
                    
                    default: break addEnemyE;
                }
            }
            
            addEnemySE: {
                if (!canMove_SE) break addEnemySE;
                int d = targetLoc_SE.distanceSquaredTo(robot.location);
                switch (robot.type) {
                    case LEVEL_ONE_DEFENSE_TOWER: {
                        if (actionReady && d <= mopperActionRadiusSquared) {
                            myHealthDmg_SE = mopperAttackStrength;
                        }
                        if (d <= UnitType.LEVEL_ONE_DEFENSE_TOWER.actionRadiusSquared) {
                            // Should have another one for AOE damage.
                            healthDmgAttackRange_SE += UnitType.LEVEL_ONE_DEFENSE_TOWER.attackStrength;
                        }
                        if (d < minDistToEnemy_SE) minDistToEnemy_SE = d;
                        break addEnemySE;
                    }
                    case LEVEL_ONE_MONEY_TOWER: {
                        if (actionReady && d <= mopperActionRadiusSquared) {
                            myHealthDmg_SE = mopperAttackStrength;
                        }
                        if (d <= UnitType.LEVEL_ONE_MONEY_TOWER.actionRadiusSquared) {
                            // Should have another one for AOE damage.
                            healthDmgAttackRange_SE += UnitType.LEVEL_ONE_MONEY_TOWER.attackStrength;
                        }
                        if (d < minDistToEnemy_SE) minDistToEnemy_SE = d;
                        break addEnemySE;
                    }
                    case LEVEL_ONE_PAINT_TOWER: {
                        if (actionReady && d <= mopperActionRadiusSquared) {
                            myHealthDmg_SE = mopperAttackStrength;
                        }
                        if (d <= UnitType.LEVEL_ONE_PAINT_TOWER.actionRadiusSquared) {
                            // Should have another one for AOE damage.
                            healthDmgAttackRange_SE += UnitType.LEVEL_ONE_PAINT_TOWER.attackStrength;
                        }
                        if (d < minDistToEnemy_SE) minDistToEnemy_SE = d;
                        break addEnemySE;
                    }
                    case LEVEL_THREE_DEFENSE_TOWER: {
                        if (actionReady && d <= mopperActionRadiusSquared) {
                            myHealthDmg_SE = mopperAttackStrength;
                        }
                        if (d <= UnitType.LEVEL_THREE_DEFENSE_TOWER.actionRadiusSquared) {
                            // Should have another one for AOE damage.
                            healthDmgAttackRange_SE += UnitType.LEVEL_THREE_DEFENSE_TOWER.attackStrength;
                        }
                        if (d < minDistToEnemy_SE) minDistToEnemy_SE = d;
                        break addEnemySE;
                    }
                    case LEVEL_THREE_MONEY_TOWER: {
                        if (actionReady && d <= mopperActionRadiusSquared) {
                            myHealthDmg_SE = mopperAttackStrength;
                        }
                        if (d <= UnitType.LEVEL_THREE_MONEY_TOWER.actionRadiusSquared) {
                            // Should have another one for AOE damage.
                            healthDmgAttackRange_SE += UnitType.LEVEL_THREE_MONEY_TOWER.attackStrength;
                        }
                        if (d < minDistToEnemy_SE) minDistToEnemy_SE = d;
                        break addEnemySE;
                    }
                    case LEVEL_THREE_PAINT_TOWER: {
                        if (actionReady && d <= mopperActionRadiusSquared) {
                            myHealthDmg_SE = mopperAttackStrength;
                        }
                        if (d <= UnitType.LEVEL_THREE_PAINT_TOWER.actionRadiusSquared) {
                            // Should have another one for AOE damage.
                            healthDmgAttackRange_SE += UnitType.LEVEL_THREE_PAINT_TOWER.attackStrength;
                        }
                        if (d < minDistToEnemy_SE) minDistToEnemy_SE = d;
                        break addEnemySE;
                    }
                    case LEVEL_TWO_DEFENSE_TOWER: {
                        if (actionReady && d <= mopperActionRadiusSquared) {
                            myHealthDmg_SE = mopperAttackStrength;
                        }
                        if (d <= UnitType.LEVEL_TWO_DEFENSE_TOWER.actionRadiusSquared) {
                            // Should have another one for AOE damage.
                            healthDmgAttackRange_SE += UnitType.LEVEL_TWO_DEFENSE_TOWER.attackStrength;
                        }
                        if (d < minDistToEnemy_SE) minDistToEnemy_SE = d;
                        break addEnemySE;
                    }
                    case LEVEL_TWO_MONEY_TOWER: {
                        if (actionReady && d <= mopperActionRadiusSquared) {
                            myHealthDmg_SE = mopperAttackStrength;
                        }
                        if (d <= UnitType.LEVEL_TWO_MONEY_TOWER.actionRadiusSquared) {
                            // Should have another one for AOE damage.
                            healthDmgAttackRange_SE += UnitType.LEVEL_TWO_MONEY_TOWER.attackStrength;
                        }
                        if (d < minDistToEnemy_SE) minDistToEnemy_SE = d;
                        break addEnemySE;
                    }
                    case LEVEL_TWO_PAINT_TOWER: {
                        if (actionReady && d <= mopperActionRadiusSquared) {
                            myHealthDmg_SE = mopperAttackStrength;
                        }
                        if (d <= UnitType.LEVEL_TWO_PAINT_TOWER.actionRadiusSquared) {
                            // Should have another one for AOE damage.
                            healthDmgAttackRange_SE += UnitType.LEVEL_TWO_PAINT_TOWER.attackStrength;
                        }
                        if (d < minDistToEnemy_SE) minDistToEnemy_SE = d;
                        break addEnemySE;
                    }
                    
                    default: break addEnemySE;
                }
            }
            
            addEnemyS: {
                if (!canMove_S) break addEnemyS;
                int d = targetLoc_S.distanceSquaredTo(robot.location);
                switch (robot.type) {
                    case LEVEL_ONE_DEFENSE_TOWER: {
                        if (actionReady && d <= mopperActionRadiusSquared) {
                            myHealthDmg_S = mopperAttackStrength;
                        }
                        if (d <= UnitType.LEVEL_ONE_DEFENSE_TOWER.actionRadiusSquared) {
                            // Should have another one for AOE damage.
                            healthDmgAttackRange_S += UnitType.LEVEL_ONE_DEFENSE_TOWER.attackStrength;
                        }
                        if (d < minDistToEnemy_S) minDistToEnemy_S = d;
                        break addEnemyS;
                    }
                    case LEVEL_ONE_MONEY_TOWER: {
                        if (actionReady && d <= mopperActionRadiusSquared) {
                            myHealthDmg_S = mopperAttackStrength;
                        }
                        if (d <= UnitType.LEVEL_ONE_MONEY_TOWER.actionRadiusSquared) {
                            // Should have another one for AOE damage.
                            healthDmgAttackRange_S += UnitType.LEVEL_ONE_MONEY_TOWER.attackStrength;
                        }
                        if (d < minDistToEnemy_S) minDistToEnemy_S = d;
                        break addEnemyS;
                    }
                    case LEVEL_ONE_PAINT_TOWER: {
                        if (actionReady && d <= mopperActionRadiusSquared) {
                            myHealthDmg_S = mopperAttackStrength;
                        }
                        if (d <= UnitType.LEVEL_ONE_PAINT_TOWER.actionRadiusSquared) {
                            // Should have another one for AOE damage.
                            healthDmgAttackRange_S += UnitType.LEVEL_ONE_PAINT_TOWER.attackStrength;
                        }
                        if (d < minDistToEnemy_S) minDistToEnemy_S = d;
                        break addEnemyS;
                    }
                    case LEVEL_THREE_DEFENSE_TOWER: {
                        if (actionReady && d <= mopperActionRadiusSquared) {
                            myHealthDmg_S = mopperAttackStrength;
                        }
                        if (d <= UnitType.LEVEL_THREE_DEFENSE_TOWER.actionRadiusSquared) {
                            // Should have another one for AOE damage.
                            healthDmgAttackRange_S += UnitType.LEVEL_THREE_DEFENSE_TOWER.attackStrength;
                        }
                        if (d < minDistToEnemy_S) minDistToEnemy_S = d;
                        break addEnemyS;
                    }
                    case LEVEL_THREE_MONEY_TOWER: {
                        if (actionReady && d <= mopperActionRadiusSquared) {
                            myHealthDmg_S = mopperAttackStrength;
                        }
                        if (d <= UnitType.LEVEL_THREE_MONEY_TOWER.actionRadiusSquared) {
                            // Should have another one for AOE damage.
                            healthDmgAttackRange_S += UnitType.LEVEL_THREE_MONEY_TOWER.attackStrength;
                        }
                        if (d < minDistToEnemy_S) minDistToEnemy_S = d;
                        break addEnemyS;
                    }
                    case LEVEL_THREE_PAINT_TOWER: {
                        if (actionReady && d <= mopperActionRadiusSquared) {
                            myHealthDmg_S = mopperAttackStrength;
                        }
                        if (d <= UnitType.LEVEL_THREE_PAINT_TOWER.actionRadiusSquared) {
                            // Should have another one for AOE damage.
                            healthDmgAttackRange_S += UnitType.LEVEL_THREE_PAINT_TOWER.attackStrength;
                        }
                        if (d < minDistToEnemy_S) minDistToEnemy_S = d;
                        break addEnemyS;
                    }
                    case LEVEL_TWO_DEFENSE_TOWER: {
                        if (actionReady && d <= mopperActionRadiusSquared) {
                            myHealthDmg_S = mopperAttackStrength;
                        }
                        if (d <= UnitType.LEVEL_TWO_DEFENSE_TOWER.actionRadiusSquared) {
                            // Should have another one for AOE damage.
                            healthDmgAttackRange_S += UnitType.LEVEL_TWO_DEFENSE_TOWER.attackStrength;
                        }
                        if (d < minDistToEnemy_S) minDistToEnemy_S = d;
                        break addEnemyS;
                    }
                    case LEVEL_TWO_MONEY_TOWER: {
                        if (actionReady && d <= mopperActionRadiusSquared) {
                            myHealthDmg_S = mopperAttackStrength;
                        }
                        if (d <= UnitType.LEVEL_TWO_MONEY_TOWER.actionRadiusSquared) {
                            // Should have another one for AOE damage.
                            healthDmgAttackRange_S += UnitType.LEVEL_TWO_MONEY_TOWER.attackStrength;
                        }
                        if (d < minDistToEnemy_S) minDistToEnemy_S = d;
                        break addEnemyS;
                    }
                    case LEVEL_TWO_PAINT_TOWER: {
                        if (actionReady && d <= mopperActionRadiusSquared) {
                            myHealthDmg_S = mopperAttackStrength;
                        }
                        if (d <= UnitType.LEVEL_TWO_PAINT_TOWER.actionRadiusSquared) {
                            // Should have another one for AOE damage.
                            healthDmgAttackRange_S += UnitType.LEVEL_TWO_PAINT_TOWER.attackStrength;
                        }
                        if (d < minDistToEnemy_S) minDistToEnemy_S = d;
                        break addEnemyS;
                    }
                    
                    default: break addEnemyS;
                }
            }
            
            addEnemySW: {
                if (!canMove_SW) break addEnemySW;
                int d = targetLoc_SW.distanceSquaredTo(robot.location);
                switch (robot.type) {
                    case LEVEL_ONE_DEFENSE_TOWER: {
                        if (actionReady && d <= mopperActionRadiusSquared) {
                            myHealthDmg_SW = mopperAttackStrength;
                        }
                        if (d <= UnitType.LEVEL_ONE_DEFENSE_TOWER.actionRadiusSquared) {
                            // Should have another one for AOE damage.
                            healthDmgAttackRange_SW += UnitType.LEVEL_ONE_DEFENSE_TOWER.attackStrength;
                        }
                        if (d < minDistToEnemy_SW) minDistToEnemy_SW = d;
                        break addEnemySW;
                    }
                    case LEVEL_ONE_MONEY_TOWER: {
                        if (actionReady && d <= mopperActionRadiusSquared) {
                            myHealthDmg_SW = mopperAttackStrength;
                        }
                        if (d <= UnitType.LEVEL_ONE_MONEY_TOWER.actionRadiusSquared) {
                            // Should have another one for AOE damage.
                            healthDmgAttackRange_SW += UnitType.LEVEL_ONE_MONEY_TOWER.attackStrength;
                        }
                        if (d < minDistToEnemy_SW) minDistToEnemy_SW = d;
                        break addEnemySW;
                    }
                    case LEVEL_ONE_PAINT_TOWER: {
                        if (actionReady && d <= mopperActionRadiusSquared) {
                            myHealthDmg_SW = mopperAttackStrength;
                        }
                        if (d <= UnitType.LEVEL_ONE_PAINT_TOWER.actionRadiusSquared) {
                            // Should have another one for AOE damage.
                            healthDmgAttackRange_SW += UnitType.LEVEL_ONE_PAINT_TOWER.attackStrength;
                        }
                        if (d < minDistToEnemy_SW) minDistToEnemy_SW = d;
                        break addEnemySW;
                    }
                    case LEVEL_THREE_DEFENSE_TOWER: {
                        if (actionReady && d <= mopperActionRadiusSquared) {
                            myHealthDmg_SW = mopperAttackStrength;
                        }
                        if (d <= UnitType.LEVEL_THREE_DEFENSE_TOWER.actionRadiusSquared) {
                            // Should have another one for AOE damage.
                            healthDmgAttackRange_SW += UnitType.LEVEL_THREE_DEFENSE_TOWER.attackStrength;
                        }
                        if (d < minDistToEnemy_SW) minDistToEnemy_SW = d;
                        break addEnemySW;
                    }
                    case LEVEL_THREE_MONEY_TOWER: {
                        if (actionReady && d <= mopperActionRadiusSquared) {
                            myHealthDmg_SW = mopperAttackStrength;
                        }
                        if (d <= UnitType.LEVEL_THREE_MONEY_TOWER.actionRadiusSquared) {
                            // Should have another one for AOE damage.
                            healthDmgAttackRange_SW += UnitType.LEVEL_THREE_MONEY_TOWER.attackStrength;
                        }
                        if (d < minDistToEnemy_SW) minDistToEnemy_SW = d;
                        break addEnemySW;
                    }
                    case LEVEL_THREE_PAINT_TOWER: {
                        if (actionReady && d <= mopperActionRadiusSquared) {
                            myHealthDmg_SW = mopperAttackStrength;
                        }
                        if (d <= UnitType.LEVEL_THREE_PAINT_TOWER.actionRadiusSquared) {
                            // Should have another one for AOE damage.
                            healthDmgAttackRange_SW += UnitType.LEVEL_THREE_PAINT_TOWER.attackStrength;
                        }
                        if (d < minDistToEnemy_SW) minDistToEnemy_SW = d;
                        break addEnemySW;
                    }
                    case LEVEL_TWO_DEFENSE_TOWER: {
                        if (actionReady && d <= mopperActionRadiusSquared) {
                            myHealthDmg_SW = mopperAttackStrength;
                        }
                        if (d <= UnitType.LEVEL_TWO_DEFENSE_TOWER.actionRadiusSquared) {
                            // Should have another one for AOE damage.
                            healthDmgAttackRange_SW += UnitType.LEVEL_TWO_DEFENSE_TOWER.attackStrength;
                        }
                        if (d < minDistToEnemy_SW) minDistToEnemy_SW = d;
                        break addEnemySW;
                    }
                    case LEVEL_TWO_MONEY_TOWER: {
                        if (actionReady && d <= mopperActionRadiusSquared) {
                            myHealthDmg_SW = mopperAttackStrength;
                        }
                        if (d <= UnitType.LEVEL_TWO_MONEY_TOWER.actionRadiusSquared) {
                            // Should have another one for AOE damage.
                            healthDmgAttackRange_SW += UnitType.LEVEL_TWO_MONEY_TOWER.attackStrength;
                        }
                        if (d < minDistToEnemy_SW) minDistToEnemy_SW = d;
                        break addEnemySW;
                    }
                    case LEVEL_TWO_PAINT_TOWER: {
                        if (actionReady && d <= mopperActionRadiusSquared) {
                            myHealthDmg_SW = mopperAttackStrength;
                        }
                        if (d <= UnitType.LEVEL_TWO_PAINT_TOWER.actionRadiusSquared) {
                            // Should have another one for AOE damage.
                            healthDmgAttackRange_SW += UnitType.LEVEL_TWO_PAINT_TOWER.attackStrength;
                        }
                        if (d < minDistToEnemy_SW) minDistToEnemy_SW = d;
                        break addEnemySW;
                    }
                    
                    default: break addEnemySW;
                }
            }
            
            addEnemyW: {
                if (!canMove_W) break addEnemyW;
                int d = targetLoc_W.distanceSquaredTo(robot.location);
                switch (robot.type) {
                    case LEVEL_ONE_DEFENSE_TOWER: {
                        if (actionReady && d <= mopperActionRadiusSquared) {
                            myHealthDmg_W = mopperAttackStrength;
                        }
                        if (d <= UnitType.LEVEL_ONE_DEFENSE_TOWER.actionRadiusSquared) {
                            // Should have another one for AOE damage.
                            healthDmgAttackRange_W += UnitType.LEVEL_ONE_DEFENSE_TOWER.attackStrength;
                        }
                        if (d < minDistToEnemy_W) minDistToEnemy_W = d;
                        break addEnemyW;
                    }
                    case LEVEL_ONE_MONEY_TOWER: {
                        if (actionReady && d <= mopperActionRadiusSquared) {
                            myHealthDmg_W = mopperAttackStrength;
                        }
                        if (d <= UnitType.LEVEL_ONE_MONEY_TOWER.actionRadiusSquared) {
                            // Should have another one for AOE damage.
                            healthDmgAttackRange_W += UnitType.LEVEL_ONE_MONEY_TOWER.attackStrength;
                        }
                        if (d < minDistToEnemy_W) minDistToEnemy_W = d;
                        break addEnemyW;
                    }
                    case LEVEL_ONE_PAINT_TOWER: {
                        if (actionReady && d <= mopperActionRadiusSquared) {
                            myHealthDmg_W = mopperAttackStrength;
                        }
                        if (d <= UnitType.LEVEL_ONE_PAINT_TOWER.actionRadiusSquared) {
                            // Should have another one for AOE damage.
                            healthDmgAttackRange_W += UnitType.LEVEL_ONE_PAINT_TOWER.attackStrength;
                        }
                        if (d < minDistToEnemy_W) minDistToEnemy_W = d;
                        break addEnemyW;
                    }
                    case LEVEL_THREE_DEFENSE_TOWER: {
                        if (actionReady && d <= mopperActionRadiusSquared) {
                            myHealthDmg_W = mopperAttackStrength;
                        }
                        if (d <= UnitType.LEVEL_THREE_DEFENSE_TOWER.actionRadiusSquared) {
                            // Should have another one for AOE damage.
                            healthDmgAttackRange_W += UnitType.LEVEL_THREE_DEFENSE_TOWER.attackStrength;
                        }
                        if (d < minDistToEnemy_W) minDistToEnemy_W = d;
                        break addEnemyW;
                    }
                    case LEVEL_THREE_MONEY_TOWER: {
                        if (actionReady && d <= mopperActionRadiusSquared) {
                            myHealthDmg_W = mopperAttackStrength;
                        }
                        if (d <= UnitType.LEVEL_THREE_MONEY_TOWER.actionRadiusSquared) {
                            // Should have another one for AOE damage.
                            healthDmgAttackRange_W += UnitType.LEVEL_THREE_MONEY_TOWER.attackStrength;
                        }
                        if (d < minDistToEnemy_W) minDistToEnemy_W = d;
                        break addEnemyW;
                    }
                    case LEVEL_THREE_PAINT_TOWER: {
                        if (actionReady && d <= mopperActionRadiusSquared) {
                            myHealthDmg_W = mopperAttackStrength;
                        }
                        if (d <= UnitType.LEVEL_THREE_PAINT_TOWER.actionRadiusSquared) {
                            // Should have another one for AOE damage.
                            healthDmgAttackRange_W += UnitType.LEVEL_THREE_PAINT_TOWER.attackStrength;
                        }
                        if (d < minDistToEnemy_W) minDistToEnemy_W = d;
                        break addEnemyW;
                    }
                    case LEVEL_TWO_DEFENSE_TOWER: {
                        if (actionReady && d <= mopperActionRadiusSquared) {
                            myHealthDmg_W = mopperAttackStrength;
                        }
                        if (d <= UnitType.LEVEL_TWO_DEFENSE_TOWER.actionRadiusSquared) {
                            // Should have another one for AOE damage.
                            healthDmgAttackRange_W += UnitType.LEVEL_TWO_DEFENSE_TOWER.attackStrength;
                        }
                        if (d < minDistToEnemy_W) minDistToEnemy_W = d;
                        break addEnemyW;
                    }
                    case LEVEL_TWO_MONEY_TOWER: {
                        if (actionReady && d <= mopperActionRadiusSquared) {
                            myHealthDmg_W = mopperAttackStrength;
                        }
                        if (d <= UnitType.LEVEL_TWO_MONEY_TOWER.actionRadiusSquared) {
                            // Should have another one for AOE damage.
                            healthDmgAttackRange_W += UnitType.LEVEL_TWO_MONEY_TOWER.attackStrength;
                        }
                        if (d < minDistToEnemy_W) minDistToEnemy_W = d;
                        break addEnemyW;
                    }
                    case LEVEL_TWO_PAINT_TOWER: {
                        if (actionReady && d <= mopperActionRadiusSquared) {
                            myHealthDmg_W = mopperAttackStrength;
                        }
                        if (d <= UnitType.LEVEL_TWO_PAINT_TOWER.actionRadiusSquared) {
                            // Should have another one for AOE damage.
                            healthDmgAttackRange_W += UnitType.LEVEL_TWO_PAINT_TOWER.attackStrength;
                        }
                        if (d < minDistToEnemy_W) minDistToEnemy_W = d;
                        break addEnemyW;
                    }
                    
                    default: break addEnemyW;
                }
            }
            
            addEnemyNW: {
                if (!canMove_NW) break addEnemyNW;
                int d = targetLoc_NW.distanceSquaredTo(robot.location);
                switch (robot.type) {
                    case LEVEL_ONE_DEFENSE_TOWER: {
                        if (actionReady && d <= mopperActionRadiusSquared) {
                            myHealthDmg_NW = mopperAttackStrength;
                        }
                        if (d <= UnitType.LEVEL_ONE_DEFENSE_TOWER.actionRadiusSquared) {
                            // Should have another one for AOE damage.
                            healthDmgAttackRange_NW += UnitType.LEVEL_ONE_DEFENSE_TOWER.attackStrength;
                        }
                        if (d < minDistToEnemy_NW) minDistToEnemy_NW = d;
                        break addEnemyNW;
                    }
                    case LEVEL_ONE_MONEY_TOWER: {
                        if (actionReady && d <= mopperActionRadiusSquared) {
                            myHealthDmg_NW = mopperAttackStrength;
                        }
                        if (d <= UnitType.LEVEL_ONE_MONEY_TOWER.actionRadiusSquared) {
                            // Should have another one for AOE damage.
                            healthDmgAttackRange_NW += UnitType.LEVEL_ONE_MONEY_TOWER.attackStrength;
                        }
                        if (d < minDistToEnemy_NW) minDistToEnemy_NW = d;
                        break addEnemyNW;
                    }
                    case LEVEL_ONE_PAINT_TOWER: {
                        if (actionReady && d <= mopperActionRadiusSquared) {
                            myHealthDmg_NW = mopperAttackStrength;
                        }
                        if (d <= UnitType.LEVEL_ONE_PAINT_TOWER.actionRadiusSquared) {
                            // Should have another one for AOE damage.
                            healthDmgAttackRange_NW += UnitType.LEVEL_ONE_PAINT_TOWER.attackStrength;
                        }
                        if (d < minDistToEnemy_NW) minDistToEnemy_NW = d;
                        break addEnemyNW;
                    }
                    case LEVEL_THREE_DEFENSE_TOWER: {
                        if (actionReady && d <= mopperActionRadiusSquared) {
                            myHealthDmg_NW = mopperAttackStrength;
                        }
                        if (d <= UnitType.LEVEL_THREE_DEFENSE_TOWER.actionRadiusSquared) {
                            // Should have another one for AOE damage.
                            healthDmgAttackRange_NW += UnitType.LEVEL_THREE_DEFENSE_TOWER.attackStrength;
                        }
                        if (d < minDistToEnemy_NW) minDistToEnemy_NW = d;
                        break addEnemyNW;
                    }
                    case LEVEL_THREE_MONEY_TOWER: {
                        if (actionReady && d <= mopperActionRadiusSquared) {
                            myHealthDmg_NW = mopperAttackStrength;
                        }
                        if (d <= UnitType.LEVEL_THREE_MONEY_TOWER.actionRadiusSquared) {
                            // Should have another one for AOE damage.
                            healthDmgAttackRange_NW += UnitType.LEVEL_THREE_MONEY_TOWER.attackStrength;
                        }
                        if (d < minDistToEnemy_NW) minDistToEnemy_NW = d;
                        break addEnemyNW;
                    }
                    case LEVEL_THREE_PAINT_TOWER: {
                        if (actionReady && d <= mopperActionRadiusSquared) {
                            myHealthDmg_NW = mopperAttackStrength;
                        }
                        if (d <= UnitType.LEVEL_THREE_PAINT_TOWER.actionRadiusSquared) {
                            // Should have another one for AOE damage.
                            healthDmgAttackRange_NW += UnitType.LEVEL_THREE_PAINT_TOWER.attackStrength;
                        }
                        if (d < minDistToEnemy_NW) minDistToEnemy_NW = d;
                        break addEnemyNW;
                    }
                    case LEVEL_TWO_DEFENSE_TOWER: {
                        if (actionReady && d <= mopperActionRadiusSquared) {
                            myHealthDmg_NW = mopperAttackStrength;
                        }
                        if (d <= UnitType.LEVEL_TWO_DEFENSE_TOWER.actionRadiusSquared) {
                            // Should have another one for AOE damage.
                            healthDmgAttackRange_NW += UnitType.LEVEL_TWO_DEFENSE_TOWER.attackStrength;
                        }
                        if (d < minDistToEnemy_NW) minDistToEnemy_NW = d;
                        break addEnemyNW;
                    }
                    case LEVEL_TWO_MONEY_TOWER: {
                        if (actionReady && d <= mopperActionRadiusSquared) {
                            myHealthDmg_NW = mopperAttackStrength;
                        }
                        if (d <= UnitType.LEVEL_TWO_MONEY_TOWER.actionRadiusSquared) {
                            // Should have another one for AOE damage.
                            healthDmgAttackRange_NW += UnitType.LEVEL_TWO_MONEY_TOWER.attackStrength;
                        }
                        if (d < minDistToEnemy_NW) minDistToEnemy_NW = d;
                        break addEnemyNW;
                    }
                    case LEVEL_TWO_PAINT_TOWER: {
                        if (actionReady && d <= mopperActionRadiusSquared) {
                            myHealthDmg_NW = mopperAttackStrength;
                        }
                        if (d <= UnitType.LEVEL_TWO_PAINT_TOWER.actionRadiusSquared) {
                            // Should have another one for AOE damage.
                            healthDmgAttackRange_NW += UnitType.LEVEL_TWO_PAINT_TOWER.attackStrength;
                        }
                        if (d < minDistToEnemy_NW) minDistToEnemy_NW = d;
                        break addEnemyNW;
                    }
                    
                    default: break addEnemyNW;
                }
            }
            
            addEnemyC: {
                if (!canMove_C) break addEnemyC;
                int d = targetLoc_C.distanceSquaredTo(robot.location);
                switch (robot.type) {
                    case LEVEL_ONE_DEFENSE_TOWER: {
                        if (actionReady && d <= mopperActionRadiusSquared) {
                            myHealthDmg_C = mopperAttackStrength;
                        }
                        if (d <= UnitType.LEVEL_ONE_DEFENSE_TOWER.actionRadiusSquared) {
                            // Should have another one for AOE damage.
                            healthDmgAttackRange_C += UnitType.LEVEL_ONE_DEFENSE_TOWER.attackStrength;
                        }
                        if (d < minDistToEnemy_C) minDistToEnemy_C = d;
                        break addEnemyC;
                    }
                    case LEVEL_ONE_MONEY_TOWER: {
                        if (actionReady && d <= mopperActionRadiusSquared) {
                            myHealthDmg_C = mopperAttackStrength;
                        }
                        if (d <= UnitType.LEVEL_ONE_MONEY_TOWER.actionRadiusSquared) {
                            // Should have another one for AOE damage.
                            healthDmgAttackRange_C += UnitType.LEVEL_ONE_MONEY_TOWER.attackStrength;
                        }
                        if (d < minDistToEnemy_C) minDistToEnemy_C = d;
                        break addEnemyC;
                    }
                    case LEVEL_ONE_PAINT_TOWER: {
                        if (actionReady && d <= mopperActionRadiusSquared) {
                            myHealthDmg_C = mopperAttackStrength;
                        }
                        if (d <= UnitType.LEVEL_ONE_PAINT_TOWER.actionRadiusSquared) {
                            // Should have another one for AOE damage.
                            healthDmgAttackRange_C += UnitType.LEVEL_ONE_PAINT_TOWER.attackStrength;
                        }
                        if (d < minDistToEnemy_C) minDistToEnemy_C = d;
                        break addEnemyC;
                    }
                    case LEVEL_THREE_DEFENSE_TOWER: {
                        if (actionReady && d <= mopperActionRadiusSquared) {
                            myHealthDmg_C = mopperAttackStrength;
                        }
                        if (d <= UnitType.LEVEL_THREE_DEFENSE_TOWER.actionRadiusSquared) {
                            // Should have another one for AOE damage.
                            healthDmgAttackRange_C += UnitType.LEVEL_THREE_DEFENSE_TOWER.attackStrength;
                        }
                        if (d < minDistToEnemy_C) minDistToEnemy_C = d;
                        break addEnemyC;
                    }
                    case LEVEL_THREE_MONEY_TOWER: {
                        if (actionReady && d <= mopperActionRadiusSquared) {
                            myHealthDmg_C = mopperAttackStrength;
                        }
                        if (d <= UnitType.LEVEL_THREE_MONEY_TOWER.actionRadiusSquared) {
                            // Should have another one for AOE damage.
                            healthDmgAttackRange_C += UnitType.LEVEL_THREE_MONEY_TOWER.attackStrength;
                        }
                        if (d < minDistToEnemy_C) minDistToEnemy_C = d;
                        break addEnemyC;
                    }
                    case LEVEL_THREE_PAINT_TOWER: {
                        if (actionReady && d <= mopperActionRadiusSquared) {
                            myHealthDmg_C = mopperAttackStrength;
                        }
                        if (d <= UnitType.LEVEL_THREE_PAINT_TOWER.actionRadiusSquared) {
                            // Should have another one for AOE damage.
                            healthDmgAttackRange_C += UnitType.LEVEL_THREE_PAINT_TOWER.attackStrength;
                        }
                        if (d < minDistToEnemy_C) minDistToEnemy_C = d;
                        break addEnemyC;
                    }
                    case LEVEL_TWO_DEFENSE_TOWER: {
                        if (actionReady && d <= mopperActionRadiusSquared) {
                            myHealthDmg_C = mopperAttackStrength;
                        }
                        if (d <= UnitType.LEVEL_TWO_DEFENSE_TOWER.actionRadiusSquared) {
                            // Should have another one for AOE damage.
                            healthDmgAttackRange_C += UnitType.LEVEL_TWO_DEFENSE_TOWER.attackStrength;
                        }
                        if (d < minDistToEnemy_C) minDistToEnemy_C = d;
                        break addEnemyC;
                    }
                    case LEVEL_TWO_MONEY_TOWER: {
                        if (actionReady && d <= mopperActionRadiusSquared) {
                            myHealthDmg_C = mopperAttackStrength;
                        }
                        if (d <= UnitType.LEVEL_TWO_MONEY_TOWER.actionRadiusSquared) {
                            // Should have another one for AOE damage.
                            healthDmgAttackRange_C += UnitType.LEVEL_TWO_MONEY_TOWER.attackStrength;
                        }
                        if (d < minDistToEnemy_C) minDistToEnemy_C = d;
                        break addEnemyC;
                    }
                    case LEVEL_TWO_PAINT_TOWER: {
                        if (actionReady && d <= mopperActionRadiusSquared) {
                            myHealthDmg_C = mopperAttackStrength;
                        }
                        if (d <= UnitType.LEVEL_TWO_PAINT_TOWER.actionRadiusSquared) {
                            // Should have another one for AOE damage.
                            healthDmgAttackRange_C += UnitType.LEVEL_TWO_PAINT_TOWER.attackStrength;
                        }
                        if (d < minDistToEnemy_C) minDistToEnemy_C = d;
                        break addEnemyC;
                    }
                    
                    default: break addEnemyC;
                }
            }
            
        }

        

        boolean bestWins = false;
        Direction bestDir = Direction.NORTH;
        MapLocation targetLoc_best = myloc.add(Direction.NORTH);
        boolean canMove_best = (rc.canMove(Direction.NORTH));
        PaintType paint_best = PaintType.ENEMY_PRIMARY;
        if (rc.canSenseLocation(targetLoc_best)) {
            paint_best = rc.senseMapInfo(targetLoc_best).getPaint();
            switch (rc.senseMapInfo(targetLoc_best).getPaint()) {
                 case PaintType.ENEMY_PRIMARY -> canMove_best = false;
                 case PaintType.ENEMY_SECONDARY -> canMove_best = false;
                 default -> {}
            }
        }
        double healthDmgAttackRange_best = 0;
        double myHealthDmg_best = 0;
        int minDistToEnemy_best = 100000;
        
        
        bestWins = canMove_best;
        chooseBestNE: {
            if (!canMove_NE || !canMove_best) break chooseBestNE;
            double bestHealthDmgDiff = healthDmgAttackRange_best - myHealthDmg_best;
            double otherHealthDmgDiff = healthDmgAttackRange_NE - myHealthDmg_NE;
            if (bestHealthDmgDiff != otherHealthDmgDiff) {
                bestWins = (bestHealthDmgDiff < otherHealthDmgDiff);
                break chooseBestNE;
            }
            if (paint_best.isAlly() != paint_NE.isAlly()) {
                bestWins = paint_best.isAlly();
                break chooseBestNE;
            }
            bestWins = (minDistToEnemy_best <= minDistToEnemy_NE);
            break chooseBestNE;
        }
        
        
        if (!bestWins) {
            targetLoc_best = targetLoc_NE;
            canMove_best = canMove_NE;
            healthDmgAttackRange_best = healthDmgAttackRange_NE;
            myHealthDmg_best = myHealthDmg_NE;
            minDistToEnemy_best = minDistToEnemy_NE;
            paint_best = paint_NE;
            bestDir = Direction.NORTHEAST;
        }
        
        
        bestWins = canMove_best;
        chooseBestE: {
            if (!canMove_E || !canMove_best) break chooseBestE;
            double bestHealthDmgDiff = healthDmgAttackRange_best - myHealthDmg_best;
            double otherHealthDmgDiff = healthDmgAttackRange_E - myHealthDmg_E;
            if (bestHealthDmgDiff != otherHealthDmgDiff) {
                bestWins = (bestHealthDmgDiff < otherHealthDmgDiff);
                break chooseBestE;
            }
            if (paint_best.isAlly() != paint_E.isAlly()) {
                bestWins = paint_best.isAlly();
                break chooseBestE;
            }
            bestWins = (minDistToEnemy_best <= minDistToEnemy_E);
            break chooseBestE;
        }
        
        
        if (!bestWins) {
            targetLoc_best = targetLoc_E;
            canMove_best = canMove_E;
            healthDmgAttackRange_best = healthDmgAttackRange_E;
            myHealthDmg_best = myHealthDmg_E;
            minDistToEnemy_best = minDistToEnemy_E;
            paint_best = paint_E;
            bestDir = Direction.EAST;
        }
        
        
        bestWins = canMove_best;
        chooseBestSE: {
            if (!canMove_SE || !canMove_best) break chooseBestSE;
            double bestHealthDmgDiff = healthDmgAttackRange_best - myHealthDmg_best;
            double otherHealthDmgDiff = healthDmgAttackRange_SE - myHealthDmg_SE;
            if (bestHealthDmgDiff != otherHealthDmgDiff) {
                bestWins = (bestHealthDmgDiff < otherHealthDmgDiff);
                break chooseBestSE;
            }
            if (paint_best.isAlly() != paint_SE.isAlly()) {
                bestWins = paint_best.isAlly();
                break chooseBestSE;
            }
            bestWins = (minDistToEnemy_best <= minDistToEnemy_SE);
            break chooseBestSE;
        }
        
        
        if (!bestWins) {
            targetLoc_best = targetLoc_SE;
            canMove_best = canMove_SE;
            healthDmgAttackRange_best = healthDmgAttackRange_SE;
            myHealthDmg_best = myHealthDmg_SE;
            minDistToEnemy_best = minDistToEnemy_SE;
            paint_best = paint_SE;
            bestDir = Direction.SOUTHEAST;
        }
        
        
        bestWins = canMove_best;
        chooseBestS: {
            if (!canMove_S || !canMove_best) break chooseBestS;
            double bestHealthDmgDiff = healthDmgAttackRange_best - myHealthDmg_best;
            double otherHealthDmgDiff = healthDmgAttackRange_S - myHealthDmg_S;
            if (bestHealthDmgDiff != otherHealthDmgDiff) {
                bestWins = (bestHealthDmgDiff < otherHealthDmgDiff);
                break chooseBestS;
            }
            if (paint_best.isAlly() != paint_S.isAlly()) {
                bestWins = paint_best.isAlly();
                break chooseBestS;
            }
            bestWins = (minDistToEnemy_best <= minDistToEnemy_S);
            break chooseBestS;
        }
        
        
        if (!bestWins) {
            targetLoc_best = targetLoc_S;
            canMove_best = canMove_S;
            healthDmgAttackRange_best = healthDmgAttackRange_S;
            myHealthDmg_best = myHealthDmg_S;
            minDistToEnemy_best = minDistToEnemy_S;
            paint_best = paint_S;
            bestDir = Direction.SOUTH;
        }
        
        
        bestWins = canMove_best;
        chooseBestSW: {
            if (!canMove_SW || !canMove_best) break chooseBestSW;
            double bestHealthDmgDiff = healthDmgAttackRange_best - myHealthDmg_best;
            double otherHealthDmgDiff = healthDmgAttackRange_SW - myHealthDmg_SW;
            if (bestHealthDmgDiff != otherHealthDmgDiff) {
                bestWins = (bestHealthDmgDiff < otherHealthDmgDiff);
                break chooseBestSW;
            }
            if (paint_best.isAlly() != paint_SW.isAlly()) {
                bestWins = paint_best.isAlly();
                break chooseBestSW;
            }
            bestWins = (minDistToEnemy_best <= minDistToEnemy_SW);
            break chooseBestSW;
        }
        
        
        if (!bestWins) {
            targetLoc_best = targetLoc_SW;
            canMove_best = canMove_SW;
            healthDmgAttackRange_best = healthDmgAttackRange_SW;
            myHealthDmg_best = myHealthDmg_SW;
            minDistToEnemy_best = minDistToEnemy_SW;
            paint_best = paint_SW;
            bestDir = Direction.SOUTHWEST;
        }
        
        
        bestWins = canMove_best;
        chooseBestW: {
            if (!canMove_W || !canMove_best) break chooseBestW;
            double bestHealthDmgDiff = healthDmgAttackRange_best - myHealthDmg_best;
            double otherHealthDmgDiff = healthDmgAttackRange_W - myHealthDmg_W;
            if (bestHealthDmgDiff != otherHealthDmgDiff) {
                bestWins = (bestHealthDmgDiff < otherHealthDmgDiff);
                break chooseBestW;
            }
            if (paint_best.isAlly() != paint_W.isAlly()) {
                bestWins = paint_best.isAlly();
                break chooseBestW;
            }
            bestWins = (minDistToEnemy_best <= minDistToEnemy_W);
            break chooseBestW;
        }
        
        
        if (!bestWins) {
            targetLoc_best = targetLoc_W;
            canMove_best = canMove_W;
            healthDmgAttackRange_best = healthDmgAttackRange_W;
            myHealthDmg_best = myHealthDmg_W;
            minDistToEnemy_best = minDistToEnemy_W;
            paint_best = paint_W;
            bestDir = Direction.WEST;
        }
        
        
        bestWins = canMove_best;
        chooseBestNW: {
            if (!canMove_NW || !canMove_best) break chooseBestNW;
            double bestHealthDmgDiff = healthDmgAttackRange_best - myHealthDmg_best;
            double otherHealthDmgDiff = healthDmgAttackRange_NW - myHealthDmg_NW;
            if (bestHealthDmgDiff != otherHealthDmgDiff) {
                bestWins = (bestHealthDmgDiff < otherHealthDmgDiff);
                break chooseBestNW;
            }
            if (paint_best.isAlly() != paint_NW.isAlly()) {
                bestWins = paint_best.isAlly();
                break chooseBestNW;
            }
            bestWins = (minDistToEnemy_best <= minDistToEnemy_NW);
            break chooseBestNW;
        }
        
        
        if (!bestWins) {
            targetLoc_best = targetLoc_NW;
            canMove_best = canMove_NW;
            healthDmgAttackRange_best = healthDmgAttackRange_NW;
            myHealthDmg_best = myHealthDmg_NW;
            minDistToEnemy_best = minDistToEnemy_NW;
            paint_best = paint_NW;
            bestDir = Direction.NORTHWEST;
        }
        
        
        bestWins = canMove_best;
        chooseBestC: {
            if (!canMove_C || !canMove_best) break chooseBestC;
            double bestHealthDmgDiff = healthDmgAttackRange_best - myHealthDmg_best;
            double otherHealthDmgDiff = healthDmgAttackRange_C - myHealthDmg_C;
            if (bestHealthDmgDiff != otherHealthDmgDiff) {
                bestWins = (bestHealthDmgDiff < otherHealthDmgDiff);
                break chooseBestC;
            }
            if (paint_best.isAlly() != paint_C.isAlly()) {
                bestWins = paint_best.isAlly();
                break chooseBestC;
            }
            bestWins = (minDistToEnemy_best <= minDistToEnemy_C);
            break chooseBestC;
        }
        
        
        if (!bestWins) {
            targetLoc_best = targetLoc_C;
            canMove_best = canMove_C;
            healthDmgAttackRange_best = healthDmgAttackRange_C;
            myHealthDmg_best = myHealthDmg_C;
            minDistToEnemy_best = minDistToEnemy_C;
            paint_best = paint_C;
            bestDir = Direction.CENTER;
        }
        
        

        

        if (rc.canMove(bestDir)) {
            rc.move(bestDir);
        }
        mopperTryAttack();
    }
    
    

}