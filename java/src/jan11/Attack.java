package jan11;
import battlecode.common.*;

public class Attack {
    public static RobotController rc;

    
    public static int soldierActionRadiusSquared;
    public static int soldierPaintCapacity;
    public static int soldierActionCooldown;
    public static int splasherActionRadiusSquared;
    public static int splasherPaintCapacity;
    public static int splasherActionCooldown;
    public static int mopperActionRadiusSquared;
    public static int mopperPaintCapacity;
    public static int mopperActionCooldown;
    public static void init(RobotController rc) {
        Attack.rc = rc;
        soldierActionRadiusSquared = UnitType.SOLDIER.actionRadiusSquared;
        soldierPaintCapacity = UnitType.SOLDIER.paintCapacity;
        soldierActionCooldown = UnitType.SOLDIER.actionCooldown;
        splasherActionRadiusSquared = UnitType.SPLASHER.actionRadiusSquared;
        splasherPaintCapacity = UnitType.SPLASHER.paintCapacity;
        splasherActionCooldown = UnitType.SPLASHER.actionCooldown;
        mopperActionRadiusSquared = UnitType.MOPPER.actionRadiusSquared;
        mopperPaintCapacity = UnitType.MOPPER.paintCapacity;
        mopperActionCooldown = UnitType.MOPPER.actionCooldown;
        
    }

    public static boolean shouldSoldierMicro() throws GameActionException {
        for (int i = Globals.enemies.length; --i >= 0; ) {
            switch (Globals.enemies[i].type) {
                case SOLDIER: continue;
                default: return true;
            }
        }
        return false;
    }

        public static void soldierTryAttack() throws GameActionException {
        // Prioritize Attacking Towers.
        for (int i = Globals.enemies.length; --i >= 0;) {
            RobotInfo enemy = Globals.enemies[i];
            switch (enemy.type) {
                case SOLDIER: continue;
                case SPLASHER: continue;
                case MOPPER: continue;
                default: break;
            }
            MapLocation loc = enemy.location;
            if (rc.canAttack(loc)) {
                rc.attack(loc);
                return;
            }
        }

        // If no towers to attack, try to add paint beneath one of my friends.
        for (int i = Globals.friends.length; --i >= 0;) {
            MapLocation loc = Globals.friends[i].location;
            MapInfo mapInfo = rc.senseMapInfo(loc);
            if (rc.canAttack(loc) && mapInfo.getPaint() == PaintType.EMPTY) {
                rc.attack(loc);
            }
        }
    }

    public static boolean shouldSplasherMicro() throws GameActionException {
        return Globals.enemies.length > 0;
    }

    public static void splasherTryAttack() throws GameActionException {
        for (int i = Globals.enemies.length; --i >= 0;) {
            RobotInfo enemy = Globals.enemies[i];
            if (enemy.paintAmount == 0) continue;
            MapLocation loc = enemy.location;
            if (rc.canAttack(loc)) rc.attack(loc);
        }
    }

    public static boolean shouldMopperMicro() throws GameActionException {
        for (int i = Globals.enemies.length; --i >= 0;) {
            if (Globals.enemies[i].paintAmount != 0) return true;
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
    
    
    public static void soldierAttackMicro() throws GameActionException {
        soldierTryAttack();
        MapLocation myloc = rc.getLocation();
        MapLocation targetLoc_N = myloc.add(Direction.NORTH);
        boolean canMove_N = (rc.canMove(Direction.NORTH));
        if (rc.canSenseLocation(targetLoc_N)) {
            PaintType paint_N = rc.senseMapInfo(targetLoc_N).getPaint();
            switch (rc.senseMapInfo(targetLoc_N).getPaint()) {
                 case PaintType.ENEMY_PRIMARY -> canMove_N = false;
                 case PaintType.ENEMY_SECONDARY -> canMove_N = false;
                 default -> {}
            }
        }
        double healthDmgAttackRange_N = 0;
        double myHealthDmg_N = 0;
        double paintDmgAttackRange_N = 0;
        double myPaintDmg_N = 0;
        int minDistToEnemy_N = 100000;
        
        MapLocation targetLoc_NE = myloc.add(Direction.NORTHEAST);
        boolean canMove_NE = (rc.canMove(Direction.NORTHEAST));
        if (rc.canSenseLocation(targetLoc_NE)) {
            PaintType paint_NE = rc.senseMapInfo(targetLoc_NE).getPaint();
            switch (rc.senseMapInfo(targetLoc_NE).getPaint()) {
                 case PaintType.ENEMY_PRIMARY -> canMove_NE = false;
                 case PaintType.ENEMY_SECONDARY -> canMove_NE = false;
                 default -> {}
            }
        }
        double healthDmgAttackRange_NE = 0;
        double myHealthDmg_NE = 0;
        double paintDmgAttackRange_NE = 0;
        double myPaintDmg_NE = 0;
        int minDistToEnemy_NE = 100000;
        
        MapLocation targetLoc_E = myloc.add(Direction.EAST);
        boolean canMove_E = (rc.canMove(Direction.EAST));
        if (rc.canSenseLocation(targetLoc_E)) {
            PaintType paint_E = rc.senseMapInfo(targetLoc_E).getPaint();
            switch (rc.senseMapInfo(targetLoc_E).getPaint()) {
                 case PaintType.ENEMY_PRIMARY -> canMove_E = false;
                 case PaintType.ENEMY_SECONDARY -> canMove_E = false;
                 default -> {}
            }
        }
        double healthDmgAttackRange_E = 0;
        double myHealthDmg_E = 0;
        double paintDmgAttackRange_E = 0;
        double myPaintDmg_E = 0;
        int minDistToEnemy_E = 100000;
        
        MapLocation targetLoc_SE = myloc.add(Direction.SOUTHEAST);
        boolean canMove_SE = (rc.canMove(Direction.SOUTHEAST));
        if (rc.canSenseLocation(targetLoc_SE)) {
            PaintType paint_SE = rc.senseMapInfo(targetLoc_SE).getPaint();
            switch (rc.senseMapInfo(targetLoc_SE).getPaint()) {
                 case PaintType.ENEMY_PRIMARY -> canMove_SE = false;
                 case PaintType.ENEMY_SECONDARY -> canMove_SE = false;
                 default -> {}
            }
        }
        double healthDmgAttackRange_SE = 0;
        double myHealthDmg_SE = 0;
        double paintDmgAttackRange_SE = 0;
        double myPaintDmg_SE = 0;
        int minDistToEnemy_SE = 100000;
        
        MapLocation targetLoc_S = myloc.add(Direction.SOUTH);
        boolean canMove_S = (rc.canMove(Direction.SOUTH));
        if (rc.canSenseLocation(targetLoc_S)) {
            PaintType paint_S = rc.senseMapInfo(targetLoc_S).getPaint();
            switch (rc.senseMapInfo(targetLoc_S).getPaint()) {
                 case PaintType.ENEMY_PRIMARY -> canMove_S = false;
                 case PaintType.ENEMY_SECONDARY -> canMove_S = false;
                 default -> {}
            }
        }
        double healthDmgAttackRange_S = 0;
        double myHealthDmg_S = 0;
        double paintDmgAttackRange_S = 0;
        double myPaintDmg_S = 0;
        int minDistToEnemy_S = 100000;
        
        MapLocation targetLoc_SW = myloc.add(Direction.SOUTHWEST);
        boolean canMove_SW = (rc.canMove(Direction.SOUTHWEST));
        if (rc.canSenseLocation(targetLoc_SW)) {
            PaintType paint_SW = rc.senseMapInfo(targetLoc_SW).getPaint();
            switch (rc.senseMapInfo(targetLoc_SW).getPaint()) {
                 case PaintType.ENEMY_PRIMARY -> canMove_SW = false;
                 case PaintType.ENEMY_SECONDARY -> canMove_SW = false;
                 default -> {}
            }
        }
        double healthDmgAttackRange_SW = 0;
        double myHealthDmg_SW = 0;
        double paintDmgAttackRange_SW = 0;
        double myPaintDmg_SW = 0;
        int minDistToEnemy_SW = 100000;
        
        MapLocation targetLoc_W = myloc.add(Direction.WEST);
        boolean canMove_W = (rc.canMove(Direction.WEST));
        if (rc.canSenseLocation(targetLoc_W)) {
            PaintType paint_W = rc.senseMapInfo(targetLoc_W).getPaint();
            switch (rc.senseMapInfo(targetLoc_W).getPaint()) {
                 case PaintType.ENEMY_PRIMARY -> canMove_W = false;
                 case PaintType.ENEMY_SECONDARY -> canMove_W = false;
                 default -> {}
            }
        }
        double healthDmgAttackRange_W = 0;
        double myHealthDmg_W = 0;
        double paintDmgAttackRange_W = 0;
        double myPaintDmg_W = 0;
        int minDistToEnemy_W = 100000;
        
        MapLocation targetLoc_NW = myloc.add(Direction.NORTHWEST);
        boolean canMove_NW = (rc.canMove(Direction.NORTHWEST));
        if (rc.canSenseLocation(targetLoc_NW)) {
            PaintType paint_NW = rc.senseMapInfo(targetLoc_NW).getPaint();
            switch (rc.senseMapInfo(targetLoc_NW).getPaint()) {
                 case PaintType.ENEMY_PRIMARY -> canMove_NW = false;
                 case PaintType.ENEMY_SECONDARY -> canMove_NW = false;
                 default -> {}
            }
        }
        double healthDmgAttackRange_NW = 0;
        double myHealthDmg_NW = 0;
        double paintDmgAttackRange_NW = 0;
        double myPaintDmg_NW = 0;
        int minDistToEnemy_NW = 100000;
        
        MapLocation targetLoc_C = myloc.add(Direction.CENTER);
        boolean canMove_C = (true);
        if (rc.canSenseLocation(targetLoc_C)) {
            PaintType paint_C = rc.senseMapInfo(targetLoc_C).getPaint();
            switch (rc.senseMapInfo(targetLoc_C).getPaint()) {
                 case PaintType.ENEMY_PRIMARY -> canMove_C = false;
                 case PaintType.ENEMY_SECONDARY -> canMove_C = false;
                 default -> {}
            }
        }
        double healthDmgAttackRange_C = 0;
        double myHealthDmg_C = 0;
        double paintDmgAttackRange_C = 0;
        double myPaintDmg_C = 0;
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
                    case SPLASHER: {
                        if (d <= splasherActionRadiusSquared) {
                            paintDmgAttackRange_N += (2 * 2) / splasherActionCooldown;
                        }
                        if (d <= soldierActionRadiusSquared && rc.isActionReady()) {
                            myPaintDmg_N = 0;
                        }
                        if (d < minDistToEnemy_N) minDistToEnemy_N = d;
                        break addEnemyN;
                    }
                    case MOPPER: {
                        if (d <= mopperActionRadiusSquared) {
                            paintDmgAttackRange_N += 11.666666666666666;
                        }
                        if (d <= soldierActionRadiusSquared && rc.isActionReady()) {
                            myPaintDmg_N = 0;
                        }
                        if (d < minDistToEnemy_N) minDistToEnemy_N = d;
                        break addEnemyN;
                    }
                    case SOLDIER: {
                        if (d <= soldierActionRadiusSquared && rc.isActionReady()) {
                            myPaintDmg_N = 0;
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
                    case SPLASHER: {
                        if (d <= splasherActionRadiusSquared) {
                            paintDmgAttackRange_NE += (2 * 2) / splasherActionCooldown;
                        }
                        if (d <= soldierActionRadiusSquared && rc.isActionReady()) {
                            myPaintDmg_NE = 0;
                        }
                        if (d < minDistToEnemy_NE) minDistToEnemy_NE = d;
                        break addEnemyNE;
                    }
                    case MOPPER: {
                        if (d <= mopperActionRadiusSquared) {
                            paintDmgAttackRange_NE += 11.666666666666666;
                        }
                        if (d <= soldierActionRadiusSquared && rc.isActionReady()) {
                            myPaintDmg_NE = 0;
                        }
                        if (d < minDistToEnemy_NE) minDistToEnemy_NE = d;
                        break addEnemyNE;
                    }
                    case SOLDIER: {
                        if (d <= soldierActionRadiusSquared && rc.isActionReady()) {
                            myPaintDmg_NE = 0;
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
                    case SPLASHER: {
                        if (d <= splasherActionRadiusSquared) {
                            paintDmgAttackRange_E += (2 * 2) / splasherActionCooldown;
                        }
                        if (d <= soldierActionRadiusSquared && rc.isActionReady()) {
                            myPaintDmg_E = 0;
                        }
                        if (d < minDistToEnemy_E) minDistToEnemy_E = d;
                        break addEnemyE;
                    }
                    case MOPPER: {
                        if (d <= mopperActionRadiusSquared) {
                            paintDmgAttackRange_E += 11.666666666666666;
                        }
                        if (d <= soldierActionRadiusSquared && rc.isActionReady()) {
                            myPaintDmg_E = 0;
                        }
                        if (d < minDistToEnemy_E) minDistToEnemy_E = d;
                        break addEnemyE;
                    }
                    case SOLDIER: {
                        if (d <= soldierActionRadiusSquared && rc.isActionReady()) {
                            myPaintDmg_E = 0;
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
                    case SPLASHER: {
                        if (d <= splasherActionRadiusSquared) {
                            paintDmgAttackRange_SE += (2 * 2) / splasherActionCooldown;
                        }
                        if (d <= soldierActionRadiusSquared && rc.isActionReady()) {
                            myPaintDmg_SE = 0;
                        }
                        if (d < minDistToEnemy_SE) minDistToEnemy_SE = d;
                        break addEnemySE;
                    }
                    case MOPPER: {
                        if (d <= mopperActionRadiusSquared) {
                            paintDmgAttackRange_SE += 11.666666666666666;
                        }
                        if (d <= soldierActionRadiusSquared && rc.isActionReady()) {
                            myPaintDmg_SE = 0;
                        }
                        if (d < minDistToEnemy_SE) minDistToEnemy_SE = d;
                        break addEnemySE;
                    }
                    case SOLDIER: {
                        if (d <= soldierActionRadiusSquared && rc.isActionReady()) {
                            myPaintDmg_SE = 0;
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
                    case SPLASHER: {
                        if (d <= splasherActionRadiusSquared) {
                            paintDmgAttackRange_S += (2 * 2) / splasherActionCooldown;
                        }
                        if (d <= soldierActionRadiusSquared && rc.isActionReady()) {
                            myPaintDmg_S = 0;
                        }
                        if (d < minDistToEnemy_S) minDistToEnemy_S = d;
                        break addEnemyS;
                    }
                    case MOPPER: {
                        if (d <= mopperActionRadiusSquared) {
                            paintDmgAttackRange_S += 11.666666666666666;
                        }
                        if (d <= soldierActionRadiusSquared && rc.isActionReady()) {
                            myPaintDmg_S = 0;
                        }
                        if (d < minDistToEnemy_S) minDistToEnemy_S = d;
                        break addEnemyS;
                    }
                    case SOLDIER: {
                        if (d <= soldierActionRadiusSquared && rc.isActionReady()) {
                            myPaintDmg_S = 0;
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
                    case SPLASHER: {
                        if (d <= splasherActionRadiusSquared) {
                            paintDmgAttackRange_SW += (2 * 2) / splasherActionCooldown;
                        }
                        if (d <= soldierActionRadiusSquared && rc.isActionReady()) {
                            myPaintDmg_SW = 0;
                        }
                        if (d < minDistToEnemy_SW) minDistToEnemy_SW = d;
                        break addEnemySW;
                    }
                    case MOPPER: {
                        if (d <= mopperActionRadiusSquared) {
                            paintDmgAttackRange_SW += 11.666666666666666;
                        }
                        if (d <= soldierActionRadiusSquared && rc.isActionReady()) {
                            myPaintDmg_SW = 0;
                        }
                        if (d < minDistToEnemy_SW) minDistToEnemy_SW = d;
                        break addEnemySW;
                    }
                    case SOLDIER: {
                        if (d <= soldierActionRadiusSquared && rc.isActionReady()) {
                            myPaintDmg_SW = 0;
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
                    case SPLASHER: {
                        if (d <= splasherActionRadiusSquared) {
                            paintDmgAttackRange_W += (2 * 2) / splasherActionCooldown;
                        }
                        if (d <= soldierActionRadiusSquared && rc.isActionReady()) {
                            myPaintDmg_W = 0;
                        }
                        if (d < minDistToEnemy_W) minDistToEnemy_W = d;
                        break addEnemyW;
                    }
                    case MOPPER: {
                        if (d <= mopperActionRadiusSquared) {
                            paintDmgAttackRange_W += 11.666666666666666;
                        }
                        if (d <= soldierActionRadiusSquared && rc.isActionReady()) {
                            myPaintDmg_W = 0;
                        }
                        if (d < minDistToEnemy_W) minDistToEnemy_W = d;
                        break addEnemyW;
                    }
                    case SOLDIER: {
                        if (d <= soldierActionRadiusSquared && rc.isActionReady()) {
                            myPaintDmg_W = 0;
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
                    case SPLASHER: {
                        if (d <= splasherActionRadiusSquared) {
                            paintDmgAttackRange_NW += (2 * 2) / splasherActionCooldown;
                        }
                        if (d <= soldierActionRadiusSquared && rc.isActionReady()) {
                            myPaintDmg_NW = 0;
                        }
                        if (d < minDistToEnemy_NW) minDistToEnemy_NW = d;
                        break addEnemyNW;
                    }
                    case MOPPER: {
                        if (d <= mopperActionRadiusSquared) {
                            paintDmgAttackRange_NW += 11.666666666666666;
                        }
                        if (d <= soldierActionRadiusSquared && rc.isActionReady()) {
                            myPaintDmg_NW = 0;
                        }
                        if (d < minDistToEnemy_NW) minDistToEnemy_NW = d;
                        break addEnemyNW;
                    }
                    case SOLDIER: {
                        if (d <= soldierActionRadiusSquared && rc.isActionReady()) {
                            myPaintDmg_NW = 0;
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
                    case SPLASHER: {
                        if (d <= splasherActionRadiusSquared) {
                            paintDmgAttackRange_C += (2 * 2) / splasherActionCooldown;
                        }
                        if (d <= soldierActionRadiusSquared && rc.isActionReady()) {
                            myPaintDmg_C = 0;
                        }
                        if (d < minDistToEnemy_C) minDistToEnemy_C = d;
                        break addEnemyC;
                    }
                    case MOPPER: {
                        if (d <= mopperActionRadiusSquared) {
                            paintDmgAttackRange_C += 11.666666666666666;
                        }
                        if (d <= soldierActionRadiusSquared && rc.isActionReady()) {
                            myPaintDmg_C = 0;
                        }
                        if (d < minDistToEnemy_C) minDistToEnemy_C = d;
                        break addEnemyC;
                    }
                    case SOLDIER: {
                        if (d <= soldierActionRadiusSquared && rc.isActionReady()) {
                            myPaintDmg_C = 0;
                        }
                        if (d < minDistToEnemy_C) minDistToEnemy_C = d;
                        break addEnemyC;
                    }
                    
                    default: break addEnemyC;
                }
            }
            
        }

        
        System.out.println("[144] " + "minDistToEnemy_N = " + minDistToEnemy_N + ", " + "targetLoc_N.x = " + targetLoc_N.x + ", " + "canMove_N = " + canMove_N + ", " + "targetLoc_N.y = " + targetLoc_N.y + ", " + "myPaintDmg_N = " + myPaintDmg_N + ", " + "paintDmgAttackRange_N = " + paintDmgAttackRange_N);
        
        System.out.println("[144] " + "minDistToEnemy_NE = " + minDistToEnemy_NE + ", " + "targetLoc_NE.x = " + targetLoc_NE.x + ", " + "canMove_NE = " + canMove_NE + ", " + "targetLoc_NE.y = " + targetLoc_NE.y + ", " + "myPaintDmg_NE = " + myPaintDmg_NE + ", " + "paintDmgAttackRange_NE = " + paintDmgAttackRange_NE);
        
        System.out.println("[144] " + "minDistToEnemy_E = " + minDistToEnemy_E + ", " + "targetLoc_E.x = " + targetLoc_E.x + ", " + "canMove_E = " + canMove_E + ", " + "targetLoc_E.y = " + targetLoc_E.y + ", " + "myPaintDmg_E = " + myPaintDmg_E + ", " + "paintDmgAttackRange_E = " + paintDmgAttackRange_E);
        
        System.out.println("[144] " + "minDistToEnemy_SE = " + minDistToEnemy_SE + ", " + "targetLoc_SE.x = " + targetLoc_SE.x + ", " + "canMove_SE = " + canMove_SE + ", " + "targetLoc_SE.y = " + targetLoc_SE.y + ", " + "myPaintDmg_SE = " + myPaintDmg_SE + ", " + "paintDmgAttackRange_SE = " + paintDmgAttackRange_SE);
        
        System.out.println("[144] " + "minDistToEnemy_S = " + minDistToEnemy_S + ", " + "targetLoc_S.x = " + targetLoc_S.x + ", " + "canMove_S = " + canMove_S + ", " + "targetLoc_S.y = " + targetLoc_S.y + ", " + "myPaintDmg_S = " + myPaintDmg_S + ", " + "paintDmgAttackRange_S = " + paintDmgAttackRange_S);
        
        System.out.println("[144] " + "minDistToEnemy_SW = " + minDistToEnemy_SW + ", " + "targetLoc_SW.x = " + targetLoc_SW.x + ", " + "canMove_SW = " + canMove_SW + ", " + "targetLoc_SW.y = " + targetLoc_SW.y + ", " + "myPaintDmg_SW = " + myPaintDmg_SW + ", " + "paintDmgAttackRange_SW = " + paintDmgAttackRange_SW);
        
        System.out.println("[144] " + "minDistToEnemy_W = " + minDistToEnemy_W + ", " + "targetLoc_W.x = " + targetLoc_W.x + ", " + "canMove_W = " + canMove_W + ", " + "targetLoc_W.y = " + targetLoc_W.y + ", " + "myPaintDmg_W = " + myPaintDmg_W + ", " + "paintDmgAttackRange_W = " + paintDmgAttackRange_W);
        
        System.out.println("[144] " + "minDistToEnemy_NW = " + minDistToEnemy_NW + ", " + "targetLoc_NW.x = " + targetLoc_NW.x + ", " + "canMove_NW = " + canMove_NW + ", " + "targetLoc_NW.y = " + targetLoc_NW.y + ", " + "myPaintDmg_NW = " + myPaintDmg_NW + ", " + "paintDmgAttackRange_NW = " + paintDmgAttackRange_NW);
        
        System.out.println("[144] " + "minDistToEnemy_C = " + minDistToEnemy_C + ", " + "targetLoc_C.x = " + targetLoc_C.x + ", " + "canMove_C = " + canMove_C + ", " + "targetLoc_C.y = " + targetLoc_C.y + ", " + "myPaintDmg_C = " + myPaintDmg_C + ", " + "paintDmgAttackRange_C = " + paintDmgAttackRange_C);
        

        boolean bestWins = false;
        Direction bestDir = Direction.NORTH;
        MapLocation targetLoc_best = myloc.add(Direction.NORTH);
        boolean canMove_best = (rc.canMove(Direction.NORTH));
        if (rc.canSenseLocation(targetLoc_best)) {
            PaintType paint_best = rc.senseMapInfo(targetLoc_best).getPaint();
            switch (rc.senseMapInfo(targetLoc_best).getPaint()) {
                 case PaintType.ENEMY_PRIMARY -> canMove_best = false;
                 case PaintType.ENEMY_SECONDARY -> canMove_best = false;
                 default -> {}
            }
        }
        double healthDmgAttackRange_best = 0;
        double myHealthDmg_best = 0;
        double paintDmgAttackRange_best = 0;
        double myPaintDmg_best = 0;
        int minDistToEnemy_best = 100000;
        
        
        bestWins = canMove_best;
        chooseBestNE: {
            if (!canMove_NE || !canMove_best) break chooseBestNE;
            double bestAttackDmgDiff = paintDmgAttackRange_best - myPaintDmg_best;
            double otherAttackDmgDiff = paintDmgAttackRange_NE - myPaintDmg_NE;
            if (bestAttackDmgDiff != otherAttackDmgDiff) {
                bestWins = (bestAttackDmgDiff < otherAttackDmgDiff);
                break chooseBestNE;
            }
            bestWins = (minDistToEnemy_best <= minDistToEnemy_NE);
            break chooseBestNE;
        }
        
        
        if (!bestWins) {
            targetLoc_best = targetLoc_NE;
            canMove_best = canMove_NE;
            paintDmgAttackRange_best = paintDmgAttackRange_NE;
            myPaintDmg_best = myPaintDmg_NE;
            minDistToEnemy_best = minDistToEnemy_NE;
            bestDir = Direction.NORTHEAST;
        }
        
        
        bestWins = canMove_best;
        chooseBestE: {
            if (!canMove_E || !canMove_best) break chooseBestE;
            double bestAttackDmgDiff = paintDmgAttackRange_best - myPaintDmg_best;
            double otherAttackDmgDiff = paintDmgAttackRange_E - myPaintDmg_E;
            if (bestAttackDmgDiff != otherAttackDmgDiff) {
                bestWins = (bestAttackDmgDiff < otherAttackDmgDiff);
                break chooseBestE;
            }
            bestWins = (minDistToEnemy_best <= minDistToEnemy_E);
            break chooseBestE;
        }
        
        
        if (!bestWins) {
            targetLoc_best = targetLoc_E;
            canMove_best = canMove_E;
            paintDmgAttackRange_best = paintDmgAttackRange_E;
            myPaintDmg_best = myPaintDmg_E;
            minDistToEnemy_best = minDistToEnemy_E;
            bestDir = Direction.EAST;
        }
        
        
        bestWins = canMove_best;
        chooseBestSE: {
            if (!canMove_SE || !canMove_best) break chooseBestSE;
            double bestAttackDmgDiff = paintDmgAttackRange_best - myPaintDmg_best;
            double otherAttackDmgDiff = paintDmgAttackRange_SE - myPaintDmg_SE;
            if (bestAttackDmgDiff != otherAttackDmgDiff) {
                bestWins = (bestAttackDmgDiff < otherAttackDmgDiff);
                break chooseBestSE;
            }
            bestWins = (minDistToEnemy_best <= minDistToEnemy_SE);
            break chooseBestSE;
        }
        
        
        if (!bestWins) {
            targetLoc_best = targetLoc_SE;
            canMove_best = canMove_SE;
            paintDmgAttackRange_best = paintDmgAttackRange_SE;
            myPaintDmg_best = myPaintDmg_SE;
            minDistToEnemy_best = minDistToEnemy_SE;
            bestDir = Direction.SOUTHEAST;
        }
        
        
        bestWins = canMove_best;
        chooseBestS: {
            if (!canMove_S || !canMove_best) break chooseBestS;
            double bestAttackDmgDiff = paintDmgAttackRange_best - myPaintDmg_best;
            double otherAttackDmgDiff = paintDmgAttackRange_S - myPaintDmg_S;
            if (bestAttackDmgDiff != otherAttackDmgDiff) {
                bestWins = (bestAttackDmgDiff < otherAttackDmgDiff);
                break chooseBestS;
            }
            bestWins = (minDistToEnemy_best <= minDistToEnemy_S);
            break chooseBestS;
        }
        
        
        if (!bestWins) {
            targetLoc_best = targetLoc_S;
            canMove_best = canMove_S;
            paintDmgAttackRange_best = paintDmgAttackRange_S;
            myPaintDmg_best = myPaintDmg_S;
            minDistToEnemy_best = minDistToEnemy_S;
            bestDir = Direction.SOUTH;
        }
        
        
        bestWins = canMove_best;
        chooseBestSW: {
            if (!canMove_SW || !canMove_best) break chooseBestSW;
            double bestAttackDmgDiff = paintDmgAttackRange_best - myPaintDmg_best;
            double otherAttackDmgDiff = paintDmgAttackRange_SW - myPaintDmg_SW;
            if (bestAttackDmgDiff != otherAttackDmgDiff) {
                bestWins = (bestAttackDmgDiff < otherAttackDmgDiff);
                break chooseBestSW;
            }
            bestWins = (minDistToEnemy_best <= minDistToEnemy_SW);
            break chooseBestSW;
        }
        
        
        if (!bestWins) {
            targetLoc_best = targetLoc_SW;
            canMove_best = canMove_SW;
            paintDmgAttackRange_best = paintDmgAttackRange_SW;
            myPaintDmg_best = myPaintDmg_SW;
            minDistToEnemy_best = minDistToEnemy_SW;
            bestDir = Direction.SOUTHWEST;
        }
        
        
        bestWins = canMove_best;
        chooseBestW: {
            if (!canMove_W || !canMove_best) break chooseBestW;
            double bestAttackDmgDiff = paintDmgAttackRange_best - myPaintDmg_best;
            double otherAttackDmgDiff = paintDmgAttackRange_W - myPaintDmg_W;
            if (bestAttackDmgDiff != otherAttackDmgDiff) {
                bestWins = (bestAttackDmgDiff < otherAttackDmgDiff);
                break chooseBestW;
            }
            bestWins = (minDistToEnemy_best <= minDistToEnemy_W);
            break chooseBestW;
        }
        
        
        if (!bestWins) {
            targetLoc_best = targetLoc_W;
            canMove_best = canMove_W;
            paintDmgAttackRange_best = paintDmgAttackRange_W;
            myPaintDmg_best = myPaintDmg_W;
            minDistToEnemy_best = minDistToEnemy_W;
            bestDir = Direction.WEST;
        }
        
        
        bestWins = canMove_best;
        chooseBestNW: {
            if (!canMove_NW || !canMove_best) break chooseBestNW;
            double bestAttackDmgDiff = paintDmgAttackRange_best - myPaintDmg_best;
            double otherAttackDmgDiff = paintDmgAttackRange_NW - myPaintDmg_NW;
            if (bestAttackDmgDiff != otherAttackDmgDiff) {
                bestWins = (bestAttackDmgDiff < otherAttackDmgDiff);
                break chooseBestNW;
            }
            bestWins = (minDistToEnemy_best <= minDistToEnemy_NW);
            break chooseBestNW;
        }
        
        
        if (!bestWins) {
            targetLoc_best = targetLoc_NW;
            canMove_best = canMove_NW;
            paintDmgAttackRange_best = paintDmgAttackRange_NW;
            myPaintDmg_best = myPaintDmg_NW;
            minDistToEnemy_best = minDistToEnemy_NW;
            bestDir = Direction.NORTHWEST;
        }
        
        
        bestWins = canMove_best;
        chooseBestC: {
            if (!canMove_C || !canMove_best) break chooseBestC;
            double bestAttackDmgDiff = paintDmgAttackRange_best - myPaintDmg_best;
            double otherAttackDmgDiff = paintDmgAttackRange_C - myPaintDmg_C;
            if (bestAttackDmgDiff != otherAttackDmgDiff) {
                bestWins = (bestAttackDmgDiff < otherAttackDmgDiff);
                break chooseBestC;
            }
            bestWins = (minDistToEnemy_best <= minDistToEnemy_C);
            break chooseBestC;
        }
        
        
        if (!bestWins) {
            targetLoc_best = targetLoc_C;
            canMove_best = canMove_C;
            paintDmgAttackRange_best = paintDmgAttackRange_C;
            myPaintDmg_best = myPaintDmg_C;
            minDistToEnemy_best = minDistToEnemy_C;
            bestDir = Direction.CENTER;
        }
        
        

        
        System.out.println("[156] " + "minDistToEnemy_best = " + minDistToEnemy_best + ", " + "targetLoc_best.x = " + targetLoc_best.x + ", " + "canMove_best = " + canMove_best + ", " + "targetLoc_best.y = " + targetLoc_best.y + ", " + "myPaintDmg_best = " + myPaintDmg_best + ", " + "paintDmgAttackRange_best = " + paintDmgAttackRange_best);
        System.out.println("\n");

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
        if (rc.canSenseLocation(targetLoc_N)) {
            PaintType paint_N = rc.senseMapInfo(targetLoc_N).getPaint();
            switch (rc.senseMapInfo(targetLoc_N).getPaint()) {
                 case PaintType.ENEMY_PRIMARY -> canMove_N = false;
                 case PaintType.ENEMY_SECONDARY -> canMove_N = false;
                 default -> {}
            }
        }
        double healthDmgAttackRange_N = 0;
        double myHealthDmg_N = 0;
        double paintDmgAttackRange_N = 0;
        double myPaintDmg_N = 0;
        int minDistToEnemy_N = 100000;
        
        MapLocation targetLoc_NE = myloc.add(Direction.NORTHEAST);
        boolean canMove_NE = (rc.canMove(Direction.NORTHEAST));
        if (rc.canSenseLocation(targetLoc_NE)) {
            PaintType paint_NE = rc.senseMapInfo(targetLoc_NE).getPaint();
            switch (rc.senseMapInfo(targetLoc_NE).getPaint()) {
                 case PaintType.ENEMY_PRIMARY -> canMove_NE = false;
                 case PaintType.ENEMY_SECONDARY -> canMove_NE = false;
                 default -> {}
            }
        }
        double healthDmgAttackRange_NE = 0;
        double myHealthDmg_NE = 0;
        double paintDmgAttackRange_NE = 0;
        double myPaintDmg_NE = 0;
        int minDistToEnemy_NE = 100000;
        
        MapLocation targetLoc_E = myloc.add(Direction.EAST);
        boolean canMove_E = (rc.canMove(Direction.EAST));
        if (rc.canSenseLocation(targetLoc_E)) {
            PaintType paint_E = rc.senseMapInfo(targetLoc_E).getPaint();
            switch (rc.senseMapInfo(targetLoc_E).getPaint()) {
                 case PaintType.ENEMY_PRIMARY -> canMove_E = false;
                 case PaintType.ENEMY_SECONDARY -> canMove_E = false;
                 default -> {}
            }
        }
        double healthDmgAttackRange_E = 0;
        double myHealthDmg_E = 0;
        double paintDmgAttackRange_E = 0;
        double myPaintDmg_E = 0;
        int minDistToEnemy_E = 100000;
        
        MapLocation targetLoc_SE = myloc.add(Direction.SOUTHEAST);
        boolean canMove_SE = (rc.canMove(Direction.SOUTHEAST));
        if (rc.canSenseLocation(targetLoc_SE)) {
            PaintType paint_SE = rc.senseMapInfo(targetLoc_SE).getPaint();
            switch (rc.senseMapInfo(targetLoc_SE).getPaint()) {
                 case PaintType.ENEMY_PRIMARY -> canMove_SE = false;
                 case PaintType.ENEMY_SECONDARY -> canMove_SE = false;
                 default -> {}
            }
        }
        double healthDmgAttackRange_SE = 0;
        double myHealthDmg_SE = 0;
        double paintDmgAttackRange_SE = 0;
        double myPaintDmg_SE = 0;
        int minDistToEnemy_SE = 100000;
        
        MapLocation targetLoc_S = myloc.add(Direction.SOUTH);
        boolean canMove_S = (rc.canMove(Direction.SOUTH));
        if (rc.canSenseLocation(targetLoc_S)) {
            PaintType paint_S = rc.senseMapInfo(targetLoc_S).getPaint();
            switch (rc.senseMapInfo(targetLoc_S).getPaint()) {
                 case PaintType.ENEMY_PRIMARY -> canMove_S = false;
                 case PaintType.ENEMY_SECONDARY -> canMove_S = false;
                 default -> {}
            }
        }
        double healthDmgAttackRange_S = 0;
        double myHealthDmg_S = 0;
        double paintDmgAttackRange_S = 0;
        double myPaintDmg_S = 0;
        int minDistToEnemy_S = 100000;
        
        MapLocation targetLoc_SW = myloc.add(Direction.SOUTHWEST);
        boolean canMove_SW = (rc.canMove(Direction.SOUTHWEST));
        if (rc.canSenseLocation(targetLoc_SW)) {
            PaintType paint_SW = rc.senseMapInfo(targetLoc_SW).getPaint();
            switch (rc.senseMapInfo(targetLoc_SW).getPaint()) {
                 case PaintType.ENEMY_PRIMARY -> canMove_SW = false;
                 case PaintType.ENEMY_SECONDARY -> canMove_SW = false;
                 default -> {}
            }
        }
        double healthDmgAttackRange_SW = 0;
        double myHealthDmg_SW = 0;
        double paintDmgAttackRange_SW = 0;
        double myPaintDmg_SW = 0;
        int minDistToEnemy_SW = 100000;
        
        MapLocation targetLoc_W = myloc.add(Direction.WEST);
        boolean canMove_W = (rc.canMove(Direction.WEST));
        if (rc.canSenseLocation(targetLoc_W)) {
            PaintType paint_W = rc.senseMapInfo(targetLoc_W).getPaint();
            switch (rc.senseMapInfo(targetLoc_W).getPaint()) {
                 case PaintType.ENEMY_PRIMARY -> canMove_W = false;
                 case PaintType.ENEMY_SECONDARY -> canMove_W = false;
                 default -> {}
            }
        }
        double healthDmgAttackRange_W = 0;
        double myHealthDmg_W = 0;
        double paintDmgAttackRange_W = 0;
        double myPaintDmg_W = 0;
        int minDistToEnemy_W = 100000;
        
        MapLocation targetLoc_NW = myloc.add(Direction.NORTHWEST);
        boolean canMove_NW = (rc.canMove(Direction.NORTHWEST));
        if (rc.canSenseLocation(targetLoc_NW)) {
            PaintType paint_NW = rc.senseMapInfo(targetLoc_NW).getPaint();
            switch (rc.senseMapInfo(targetLoc_NW).getPaint()) {
                 case PaintType.ENEMY_PRIMARY -> canMove_NW = false;
                 case PaintType.ENEMY_SECONDARY -> canMove_NW = false;
                 default -> {}
            }
        }
        double healthDmgAttackRange_NW = 0;
        double myHealthDmg_NW = 0;
        double paintDmgAttackRange_NW = 0;
        double myPaintDmg_NW = 0;
        int minDistToEnemy_NW = 100000;
        
        MapLocation targetLoc_C = myloc.add(Direction.CENTER);
        boolean canMove_C = (true);
        if (rc.canSenseLocation(targetLoc_C)) {
            PaintType paint_C = rc.senseMapInfo(targetLoc_C).getPaint();
            switch (rc.senseMapInfo(targetLoc_C).getPaint()) {
                 case PaintType.ENEMY_PRIMARY -> canMove_C = false;
                 case PaintType.ENEMY_SECONDARY -> canMove_C = false;
                 default -> {}
            }
        }
        double healthDmgAttackRange_C = 0;
        double myHealthDmg_C = 0;
        double paintDmgAttackRange_C = 0;
        double myPaintDmg_C = 0;
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
                    case SPLASHER: {
                        if (d <= splasherActionRadiusSquared) {
                            paintDmgAttackRange_N += (2 * 2) / splasherActionCooldown;
                        }
                        if (d <= splasherActionRadiusSquared && rc.isActionReady()) {
                            myPaintDmg_N = (2 * 2);
                        }
                        if (d < minDistToEnemy_N) minDistToEnemy_N = d;
                        break addEnemyN;
                    }
                    case MOPPER: {
                        if (d <= mopperActionRadiusSquared) {
                            paintDmgAttackRange_N += 11.666666666666666;
                        }
                        if (d <= splasherActionRadiusSquared && rc.isActionReady()) {
                            myPaintDmg_N = (2 * 2 * 2);
                        }
                        if (d < minDistToEnemy_N) minDistToEnemy_N = d;
                        break addEnemyN;
                    }
                    case SOLDIER: {
                        if (d <= splasherActionRadiusSquared && rc.isActionReady()) {
                            myPaintDmg_N = (2 * 2);
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
                    case SPLASHER: {
                        if (d <= splasherActionRadiusSquared) {
                            paintDmgAttackRange_NE += (2 * 2) / splasherActionCooldown;
                        }
                        if (d <= splasherActionRadiusSquared && rc.isActionReady()) {
                            myPaintDmg_NE = (2 * 2);
                        }
                        if (d < minDistToEnemy_NE) minDistToEnemy_NE = d;
                        break addEnemyNE;
                    }
                    case MOPPER: {
                        if (d <= mopperActionRadiusSquared) {
                            paintDmgAttackRange_NE += 11.666666666666666;
                        }
                        if (d <= splasherActionRadiusSquared && rc.isActionReady()) {
                            myPaintDmg_NE = (2 * 2 * 2);
                        }
                        if (d < minDistToEnemy_NE) minDistToEnemy_NE = d;
                        break addEnemyNE;
                    }
                    case SOLDIER: {
                        if (d <= splasherActionRadiusSquared && rc.isActionReady()) {
                            myPaintDmg_NE = (2 * 2);
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
                    case SPLASHER: {
                        if (d <= splasherActionRadiusSquared) {
                            paintDmgAttackRange_E += (2 * 2) / splasherActionCooldown;
                        }
                        if (d <= splasherActionRadiusSquared && rc.isActionReady()) {
                            myPaintDmg_E = (2 * 2);
                        }
                        if (d < minDistToEnemy_E) minDistToEnemy_E = d;
                        break addEnemyE;
                    }
                    case MOPPER: {
                        if (d <= mopperActionRadiusSquared) {
                            paintDmgAttackRange_E += 11.666666666666666;
                        }
                        if (d <= splasherActionRadiusSquared && rc.isActionReady()) {
                            myPaintDmg_E = (2 * 2 * 2);
                        }
                        if (d < minDistToEnemy_E) minDistToEnemy_E = d;
                        break addEnemyE;
                    }
                    case SOLDIER: {
                        if (d <= splasherActionRadiusSquared && rc.isActionReady()) {
                            myPaintDmg_E = (2 * 2);
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
                    case SPLASHER: {
                        if (d <= splasherActionRadiusSquared) {
                            paintDmgAttackRange_SE += (2 * 2) / splasherActionCooldown;
                        }
                        if (d <= splasherActionRadiusSquared && rc.isActionReady()) {
                            myPaintDmg_SE = (2 * 2);
                        }
                        if (d < minDistToEnemy_SE) minDistToEnemy_SE = d;
                        break addEnemySE;
                    }
                    case MOPPER: {
                        if (d <= mopperActionRadiusSquared) {
                            paintDmgAttackRange_SE += 11.666666666666666;
                        }
                        if (d <= splasherActionRadiusSquared && rc.isActionReady()) {
                            myPaintDmg_SE = (2 * 2 * 2);
                        }
                        if (d < minDistToEnemy_SE) minDistToEnemy_SE = d;
                        break addEnemySE;
                    }
                    case SOLDIER: {
                        if (d <= splasherActionRadiusSquared && rc.isActionReady()) {
                            myPaintDmg_SE = (2 * 2);
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
                    case SPLASHER: {
                        if (d <= splasherActionRadiusSquared) {
                            paintDmgAttackRange_S += (2 * 2) / splasherActionCooldown;
                        }
                        if (d <= splasherActionRadiusSquared && rc.isActionReady()) {
                            myPaintDmg_S = (2 * 2);
                        }
                        if (d < minDistToEnemy_S) minDistToEnemy_S = d;
                        break addEnemyS;
                    }
                    case MOPPER: {
                        if (d <= mopperActionRadiusSquared) {
                            paintDmgAttackRange_S += 11.666666666666666;
                        }
                        if (d <= splasherActionRadiusSquared && rc.isActionReady()) {
                            myPaintDmg_S = (2 * 2 * 2);
                        }
                        if (d < minDistToEnemy_S) minDistToEnemy_S = d;
                        break addEnemyS;
                    }
                    case SOLDIER: {
                        if (d <= splasherActionRadiusSquared && rc.isActionReady()) {
                            myPaintDmg_S = (2 * 2);
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
                    case SPLASHER: {
                        if (d <= splasherActionRadiusSquared) {
                            paintDmgAttackRange_SW += (2 * 2) / splasherActionCooldown;
                        }
                        if (d <= splasherActionRadiusSquared && rc.isActionReady()) {
                            myPaintDmg_SW = (2 * 2);
                        }
                        if (d < minDistToEnemy_SW) minDistToEnemy_SW = d;
                        break addEnemySW;
                    }
                    case MOPPER: {
                        if (d <= mopperActionRadiusSquared) {
                            paintDmgAttackRange_SW += 11.666666666666666;
                        }
                        if (d <= splasherActionRadiusSquared && rc.isActionReady()) {
                            myPaintDmg_SW = (2 * 2 * 2);
                        }
                        if (d < minDistToEnemy_SW) minDistToEnemy_SW = d;
                        break addEnemySW;
                    }
                    case SOLDIER: {
                        if (d <= splasherActionRadiusSquared && rc.isActionReady()) {
                            myPaintDmg_SW = (2 * 2);
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
                    case SPLASHER: {
                        if (d <= splasherActionRadiusSquared) {
                            paintDmgAttackRange_W += (2 * 2) / splasherActionCooldown;
                        }
                        if (d <= splasherActionRadiusSquared && rc.isActionReady()) {
                            myPaintDmg_W = (2 * 2);
                        }
                        if (d < minDistToEnemy_W) minDistToEnemy_W = d;
                        break addEnemyW;
                    }
                    case MOPPER: {
                        if (d <= mopperActionRadiusSquared) {
                            paintDmgAttackRange_W += 11.666666666666666;
                        }
                        if (d <= splasherActionRadiusSquared && rc.isActionReady()) {
                            myPaintDmg_W = (2 * 2 * 2);
                        }
                        if (d < minDistToEnemy_W) minDistToEnemy_W = d;
                        break addEnemyW;
                    }
                    case SOLDIER: {
                        if (d <= splasherActionRadiusSquared && rc.isActionReady()) {
                            myPaintDmg_W = (2 * 2);
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
                    case SPLASHER: {
                        if (d <= splasherActionRadiusSquared) {
                            paintDmgAttackRange_NW += (2 * 2) / splasherActionCooldown;
                        }
                        if (d <= splasherActionRadiusSquared && rc.isActionReady()) {
                            myPaintDmg_NW = (2 * 2);
                        }
                        if (d < minDistToEnemy_NW) minDistToEnemy_NW = d;
                        break addEnemyNW;
                    }
                    case MOPPER: {
                        if (d <= mopperActionRadiusSquared) {
                            paintDmgAttackRange_NW += 11.666666666666666;
                        }
                        if (d <= splasherActionRadiusSquared && rc.isActionReady()) {
                            myPaintDmg_NW = (2 * 2 * 2);
                        }
                        if (d < minDistToEnemy_NW) minDistToEnemy_NW = d;
                        break addEnemyNW;
                    }
                    case SOLDIER: {
                        if (d <= splasherActionRadiusSquared && rc.isActionReady()) {
                            myPaintDmg_NW = (2 * 2);
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
                    case SPLASHER: {
                        if (d <= splasherActionRadiusSquared) {
                            paintDmgAttackRange_C += (2 * 2) / splasherActionCooldown;
                        }
                        if (d <= splasherActionRadiusSquared && rc.isActionReady()) {
                            myPaintDmg_C = (2 * 2);
                        }
                        if (d < minDistToEnemy_C) minDistToEnemy_C = d;
                        break addEnemyC;
                    }
                    case MOPPER: {
                        if (d <= mopperActionRadiusSquared) {
                            paintDmgAttackRange_C += 11.666666666666666;
                        }
                        if (d <= splasherActionRadiusSquared && rc.isActionReady()) {
                            myPaintDmg_C = (2 * 2 * 2);
                        }
                        if (d < minDistToEnemy_C) minDistToEnemy_C = d;
                        break addEnemyC;
                    }
                    case SOLDIER: {
                        if (d <= splasherActionRadiusSquared && rc.isActionReady()) {
                            myPaintDmg_C = (2 * 2);
                        }
                        if (d < minDistToEnemy_C) minDistToEnemy_C = d;
                        break addEnemyC;
                    }
                    
                    default: break addEnemyC;
                }
            }
            
        }

        
        System.out.println("[144] " + "minDistToEnemy_N = " + minDistToEnemy_N + ", " + "targetLoc_N.x = " + targetLoc_N.x + ", " + "canMove_N = " + canMove_N + ", " + "targetLoc_N.y = " + targetLoc_N.y + ", " + "myPaintDmg_N = " + myPaintDmg_N + ", " + "paintDmgAttackRange_N = " + paintDmgAttackRange_N);
        
        System.out.println("[144] " + "minDistToEnemy_NE = " + minDistToEnemy_NE + ", " + "targetLoc_NE.x = " + targetLoc_NE.x + ", " + "canMove_NE = " + canMove_NE + ", " + "targetLoc_NE.y = " + targetLoc_NE.y + ", " + "myPaintDmg_NE = " + myPaintDmg_NE + ", " + "paintDmgAttackRange_NE = " + paintDmgAttackRange_NE);
        
        System.out.println("[144] " + "minDistToEnemy_E = " + minDistToEnemy_E + ", " + "targetLoc_E.x = " + targetLoc_E.x + ", " + "canMove_E = " + canMove_E + ", " + "targetLoc_E.y = " + targetLoc_E.y + ", " + "myPaintDmg_E = " + myPaintDmg_E + ", " + "paintDmgAttackRange_E = " + paintDmgAttackRange_E);
        
        System.out.println("[144] " + "minDistToEnemy_SE = " + minDistToEnemy_SE + ", " + "targetLoc_SE.x = " + targetLoc_SE.x + ", " + "canMove_SE = " + canMove_SE + ", " + "targetLoc_SE.y = " + targetLoc_SE.y + ", " + "myPaintDmg_SE = " + myPaintDmg_SE + ", " + "paintDmgAttackRange_SE = " + paintDmgAttackRange_SE);
        
        System.out.println("[144] " + "minDistToEnemy_S = " + minDistToEnemy_S + ", " + "targetLoc_S.x = " + targetLoc_S.x + ", " + "canMove_S = " + canMove_S + ", " + "targetLoc_S.y = " + targetLoc_S.y + ", " + "myPaintDmg_S = " + myPaintDmg_S + ", " + "paintDmgAttackRange_S = " + paintDmgAttackRange_S);
        
        System.out.println("[144] " + "minDistToEnemy_SW = " + minDistToEnemy_SW + ", " + "targetLoc_SW.x = " + targetLoc_SW.x + ", " + "canMove_SW = " + canMove_SW + ", " + "targetLoc_SW.y = " + targetLoc_SW.y + ", " + "myPaintDmg_SW = " + myPaintDmg_SW + ", " + "paintDmgAttackRange_SW = " + paintDmgAttackRange_SW);
        
        System.out.println("[144] " + "minDistToEnemy_W = " + minDistToEnemy_W + ", " + "targetLoc_W.x = " + targetLoc_W.x + ", " + "canMove_W = " + canMove_W + ", " + "targetLoc_W.y = " + targetLoc_W.y + ", " + "myPaintDmg_W = " + myPaintDmg_W + ", " + "paintDmgAttackRange_W = " + paintDmgAttackRange_W);
        
        System.out.println("[144] " + "minDistToEnemy_NW = " + minDistToEnemy_NW + ", " + "targetLoc_NW.x = " + targetLoc_NW.x + ", " + "canMove_NW = " + canMove_NW + ", " + "targetLoc_NW.y = " + targetLoc_NW.y + ", " + "myPaintDmg_NW = " + myPaintDmg_NW + ", " + "paintDmgAttackRange_NW = " + paintDmgAttackRange_NW);
        
        System.out.println("[144] " + "minDistToEnemy_C = " + minDistToEnemy_C + ", " + "targetLoc_C.x = " + targetLoc_C.x + ", " + "canMove_C = " + canMove_C + ", " + "targetLoc_C.y = " + targetLoc_C.y + ", " + "myPaintDmg_C = " + myPaintDmg_C + ", " + "paintDmgAttackRange_C = " + paintDmgAttackRange_C);
        

        boolean bestWins = false;
        Direction bestDir = Direction.NORTH;
        MapLocation targetLoc_best = myloc.add(Direction.NORTH);
        boolean canMove_best = (rc.canMove(Direction.NORTH));
        if (rc.canSenseLocation(targetLoc_best)) {
            PaintType paint_best = rc.senseMapInfo(targetLoc_best).getPaint();
            switch (rc.senseMapInfo(targetLoc_best).getPaint()) {
                 case PaintType.ENEMY_PRIMARY -> canMove_best = false;
                 case PaintType.ENEMY_SECONDARY -> canMove_best = false;
                 default -> {}
            }
        }
        double healthDmgAttackRange_best = 0;
        double myHealthDmg_best = 0;
        double paintDmgAttackRange_best = 0;
        double myPaintDmg_best = 0;
        int minDistToEnemy_best = 100000;
        
        
        bestWins = canMove_best;
        chooseBestNE: {
            if (!canMove_NE || !canMove_best) break chooseBestNE;
            double bestAttackDmgDiff = paintDmgAttackRange_best - myPaintDmg_best;
            double otherAttackDmgDiff = paintDmgAttackRange_NE - myPaintDmg_NE;
            if (bestAttackDmgDiff != otherAttackDmgDiff) {
                bestWins = (bestAttackDmgDiff < otherAttackDmgDiff);
                break chooseBestNE;
            }
            bestWins = (minDistToEnemy_best <= minDistToEnemy_NE);
            break chooseBestNE;
        }
        
        
        if (!bestWins) {
            targetLoc_best = targetLoc_NE;
            canMove_best = canMove_NE;
            paintDmgAttackRange_best = paintDmgAttackRange_NE;
            myPaintDmg_best = myPaintDmg_NE;
            minDistToEnemy_best = minDistToEnemy_NE;
            bestDir = Direction.NORTHEAST;
        }
        
        
        bestWins = canMove_best;
        chooseBestE: {
            if (!canMove_E || !canMove_best) break chooseBestE;
            double bestAttackDmgDiff = paintDmgAttackRange_best - myPaintDmg_best;
            double otherAttackDmgDiff = paintDmgAttackRange_E - myPaintDmg_E;
            if (bestAttackDmgDiff != otherAttackDmgDiff) {
                bestWins = (bestAttackDmgDiff < otherAttackDmgDiff);
                break chooseBestE;
            }
            bestWins = (minDistToEnemy_best <= minDistToEnemy_E);
            break chooseBestE;
        }
        
        
        if (!bestWins) {
            targetLoc_best = targetLoc_E;
            canMove_best = canMove_E;
            paintDmgAttackRange_best = paintDmgAttackRange_E;
            myPaintDmg_best = myPaintDmg_E;
            minDistToEnemy_best = minDistToEnemy_E;
            bestDir = Direction.EAST;
        }
        
        
        bestWins = canMove_best;
        chooseBestSE: {
            if (!canMove_SE || !canMove_best) break chooseBestSE;
            double bestAttackDmgDiff = paintDmgAttackRange_best - myPaintDmg_best;
            double otherAttackDmgDiff = paintDmgAttackRange_SE - myPaintDmg_SE;
            if (bestAttackDmgDiff != otherAttackDmgDiff) {
                bestWins = (bestAttackDmgDiff < otherAttackDmgDiff);
                break chooseBestSE;
            }
            bestWins = (minDistToEnemy_best <= minDistToEnemy_SE);
            break chooseBestSE;
        }
        
        
        if (!bestWins) {
            targetLoc_best = targetLoc_SE;
            canMove_best = canMove_SE;
            paintDmgAttackRange_best = paintDmgAttackRange_SE;
            myPaintDmg_best = myPaintDmg_SE;
            minDistToEnemy_best = minDistToEnemy_SE;
            bestDir = Direction.SOUTHEAST;
        }
        
        
        bestWins = canMove_best;
        chooseBestS: {
            if (!canMove_S || !canMove_best) break chooseBestS;
            double bestAttackDmgDiff = paintDmgAttackRange_best - myPaintDmg_best;
            double otherAttackDmgDiff = paintDmgAttackRange_S - myPaintDmg_S;
            if (bestAttackDmgDiff != otherAttackDmgDiff) {
                bestWins = (bestAttackDmgDiff < otherAttackDmgDiff);
                break chooseBestS;
            }
            bestWins = (minDistToEnemy_best <= minDistToEnemy_S);
            break chooseBestS;
        }
        
        
        if (!bestWins) {
            targetLoc_best = targetLoc_S;
            canMove_best = canMove_S;
            paintDmgAttackRange_best = paintDmgAttackRange_S;
            myPaintDmg_best = myPaintDmg_S;
            minDistToEnemy_best = minDistToEnemy_S;
            bestDir = Direction.SOUTH;
        }
        
        
        bestWins = canMove_best;
        chooseBestSW: {
            if (!canMove_SW || !canMove_best) break chooseBestSW;
            double bestAttackDmgDiff = paintDmgAttackRange_best - myPaintDmg_best;
            double otherAttackDmgDiff = paintDmgAttackRange_SW - myPaintDmg_SW;
            if (bestAttackDmgDiff != otherAttackDmgDiff) {
                bestWins = (bestAttackDmgDiff < otherAttackDmgDiff);
                break chooseBestSW;
            }
            bestWins = (minDistToEnemy_best <= minDistToEnemy_SW);
            break chooseBestSW;
        }
        
        
        if (!bestWins) {
            targetLoc_best = targetLoc_SW;
            canMove_best = canMove_SW;
            paintDmgAttackRange_best = paintDmgAttackRange_SW;
            myPaintDmg_best = myPaintDmg_SW;
            minDistToEnemy_best = minDistToEnemy_SW;
            bestDir = Direction.SOUTHWEST;
        }
        
        
        bestWins = canMove_best;
        chooseBestW: {
            if (!canMove_W || !canMove_best) break chooseBestW;
            double bestAttackDmgDiff = paintDmgAttackRange_best - myPaintDmg_best;
            double otherAttackDmgDiff = paintDmgAttackRange_W - myPaintDmg_W;
            if (bestAttackDmgDiff != otherAttackDmgDiff) {
                bestWins = (bestAttackDmgDiff < otherAttackDmgDiff);
                break chooseBestW;
            }
            bestWins = (minDistToEnemy_best <= minDistToEnemy_W);
            break chooseBestW;
        }
        
        
        if (!bestWins) {
            targetLoc_best = targetLoc_W;
            canMove_best = canMove_W;
            paintDmgAttackRange_best = paintDmgAttackRange_W;
            myPaintDmg_best = myPaintDmg_W;
            minDistToEnemy_best = minDistToEnemy_W;
            bestDir = Direction.WEST;
        }
        
        
        bestWins = canMove_best;
        chooseBestNW: {
            if (!canMove_NW || !canMove_best) break chooseBestNW;
            double bestAttackDmgDiff = paintDmgAttackRange_best - myPaintDmg_best;
            double otherAttackDmgDiff = paintDmgAttackRange_NW - myPaintDmg_NW;
            if (bestAttackDmgDiff != otherAttackDmgDiff) {
                bestWins = (bestAttackDmgDiff < otherAttackDmgDiff);
                break chooseBestNW;
            }
            bestWins = (minDistToEnemy_best <= minDistToEnemy_NW);
            break chooseBestNW;
        }
        
        
        if (!bestWins) {
            targetLoc_best = targetLoc_NW;
            canMove_best = canMove_NW;
            paintDmgAttackRange_best = paintDmgAttackRange_NW;
            myPaintDmg_best = myPaintDmg_NW;
            minDistToEnemy_best = minDistToEnemy_NW;
            bestDir = Direction.NORTHWEST;
        }
        
        
        bestWins = canMove_best;
        chooseBestC: {
            if (!canMove_C || !canMove_best) break chooseBestC;
            double bestAttackDmgDiff = paintDmgAttackRange_best - myPaintDmg_best;
            double otherAttackDmgDiff = paintDmgAttackRange_C - myPaintDmg_C;
            if (bestAttackDmgDiff != otherAttackDmgDiff) {
                bestWins = (bestAttackDmgDiff < otherAttackDmgDiff);
                break chooseBestC;
            }
            bestWins = (minDistToEnemy_best <= minDistToEnemy_C);
            break chooseBestC;
        }
        
        
        if (!bestWins) {
            targetLoc_best = targetLoc_C;
            canMove_best = canMove_C;
            paintDmgAttackRange_best = paintDmgAttackRange_C;
            myPaintDmg_best = myPaintDmg_C;
            minDistToEnemy_best = minDistToEnemy_C;
            bestDir = Direction.CENTER;
        }
        
        

        
        System.out.println("[156] " + "minDistToEnemy_best = " + minDistToEnemy_best + ", " + "targetLoc_best.x = " + targetLoc_best.x + ", " + "canMove_best = " + canMove_best + ", " + "targetLoc_best.y = " + targetLoc_best.y + ", " + "myPaintDmg_best = " + myPaintDmg_best + ", " + "paintDmgAttackRange_best = " + paintDmgAttackRange_best);
        System.out.println("\n");

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
        if (rc.canSenseLocation(targetLoc_N)) {
            PaintType paint_N = rc.senseMapInfo(targetLoc_N).getPaint();
            switch (rc.senseMapInfo(targetLoc_N).getPaint()) {
                 case PaintType.ENEMY_PRIMARY -> canMove_N = false;
                 case PaintType.ENEMY_SECONDARY -> canMove_N = false;
                 default -> {}
            }
        }
        double healthDmgAttackRange_N = 0;
        double myHealthDmg_N = 0;
        double paintDmgAttackRange_N = 0;
        double myPaintDmg_N = 0;
        int minDistToEnemy_N = 100000;
        
        MapLocation targetLoc_NE = myloc.add(Direction.NORTHEAST);
        boolean canMove_NE = (rc.canMove(Direction.NORTHEAST));
        if (rc.canSenseLocation(targetLoc_NE)) {
            PaintType paint_NE = rc.senseMapInfo(targetLoc_NE).getPaint();
            switch (rc.senseMapInfo(targetLoc_NE).getPaint()) {
                 case PaintType.ENEMY_PRIMARY -> canMove_NE = false;
                 case PaintType.ENEMY_SECONDARY -> canMove_NE = false;
                 default -> {}
            }
        }
        double healthDmgAttackRange_NE = 0;
        double myHealthDmg_NE = 0;
        double paintDmgAttackRange_NE = 0;
        double myPaintDmg_NE = 0;
        int minDistToEnemy_NE = 100000;
        
        MapLocation targetLoc_E = myloc.add(Direction.EAST);
        boolean canMove_E = (rc.canMove(Direction.EAST));
        if (rc.canSenseLocation(targetLoc_E)) {
            PaintType paint_E = rc.senseMapInfo(targetLoc_E).getPaint();
            switch (rc.senseMapInfo(targetLoc_E).getPaint()) {
                 case PaintType.ENEMY_PRIMARY -> canMove_E = false;
                 case PaintType.ENEMY_SECONDARY -> canMove_E = false;
                 default -> {}
            }
        }
        double healthDmgAttackRange_E = 0;
        double myHealthDmg_E = 0;
        double paintDmgAttackRange_E = 0;
        double myPaintDmg_E = 0;
        int minDistToEnemy_E = 100000;
        
        MapLocation targetLoc_SE = myloc.add(Direction.SOUTHEAST);
        boolean canMove_SE = (rc.canMove(Direction.SOUTHEAST));
        if (rc.canSenseLocation(targetLoc_SE)) {
            PaintType paint_SE = rc.senseMapInfo(targetLoc_SE).getPaint();
            switch (rc.senseMapInfo(targetLoc_SE).getPaint()) {
                 case PaintType.ENEMY_PRIMARY -> canMove_SE = false;
                 case PaintType.ENEMY_SECONDARY -> canMove_SE = false;
                 default -> {}
            }
        }
        double healthDmgAttackRange_SE = 0;
        double myHealthDmg_SE = 0;
        double paintDmgAttackRange_SE = 0;
        double myPaintDmg_SE = 0;
        int minDistToEnemy_SE = 100000;
        
        MapLocation targetLoc_S = myloc.add(Direction.SOUTH);
        boolean canMove_S = (rc.canMove(Direction.SOUTH));
        if (rc.canSenseLocation(targetLoc_S)) {
            PaintType paint_S = rc.senseMapInfo(targetLoc_S).getPaint();
            switch (rc.senseMapInfo(targetLoc_S).getPaint()) {
                 case PaintType.ENEMY_PRIMARY -> canMove_S = false;
                 case PaintType.ENEMY_SECONDARY -> canMove_S = false;
                 default -> {}
            }
        }
        double healthDmgAttackRange_S = 0;
        double myHealthDmg_S = 0;
        double paintDmgAttackRange_S = 0;
        double myPaintDmg_S = 0;
        int minDistToEnemy_S = 100000;
        
        MapLocation targetLoc_SW = myloc.add(Direction.SOUTHWEST);
        boolean canMove_SW = (rc.canMove(Direction.SOUTHWEST));
        if (rc.canSenseLocation(targetLoc_SW)) {
            PaintType paint_SW = rc.senseMapInfo(targetLoc_SW).getPaint();
            switch (rc.senseMapInfo(targetLoc_SW).getPaint()) {
                 case PaintType.ENEMY_PRIMARY -> canMove_SW = false;
                 case PaintType.ENEMY_SECONDARY -> canMove_SW = false;
                 default -> {}
            }
        }
        double healthDmgAttackRange_SW = 0;
        double myHealthDmg_SW = 0;
        double paintDmgAttackRange_SW = 0;
        double myPaintDmg_SW = 0;
        int minDistToEnemy_SW = 100000;
        
        MapLocation targetLoc_W = myloc.add(Direction.WEST);
        boolean canMove_W = (rc.canMove(Direction.WEST));
        if (rc.canSenseLocation(targetLoc_W)) {
            PaintType paint_W = rc.senseMapInfo(targetLoc_W).getPaint();
            switch (rc.senseMapInfo(targetLoc_W).getPaint()) {
                 case PaintType.ENEMY_PRIMARY -> canMove_W = false;
                 case PaintType.ENEMY_SECONDARY -> canMove_W = false;
                 default -> {}
            }
        }
        double healthDmgAttackRange_W = 0;
        double myHealthDmg_W = 0;
        double paintDmgAttackRange_W = 0;
        double myPaintDmg_W = 0;
        int minDistToEnemy_W = 100000;
        
        MapLocation targetLoc_NW = myloc.add(Direction.NORTHWEST);
        boolean canMove_NW = (rc.canMove(Direction.NORTHWEST));
        if (rc.canSenseLocation(targetLoc_NW)) {
            PaintType paint_NW = rc.senseMapInfo(targetLoc_NW).getPaint();
            switch (rc.senseMapInfo(targetLoc_NW).getPaint()) {
                 case PaintType.ENEMY_PRIMARY -> canMove_NW = false;
                 case PaintType.ENEMY_SECONDARY -> canMove_NW = false;
                 default -> {}
            }
        }
        double healthDmgAttackRange_NW = 0;
        double myHealthDmg_NW = 0;
        double paintDmgAttackRange_NW = 0;
        double myPaintDmg_NW = 0;
        int minDistToEnemy_NW = 100000;
        
        MapLocation targetLoc_C = myloc.add(Direction.CENTER);
        boolean canMove_C = (true);
        if (rc.canSenseLocation(targetLoc_C)) {
            PaintType paint_C = rc.senseMapInfo(targetLoc_C).getPaint();
            switch (rc.senseMapInfo(targetLoc_C).getPaint()) {
                 case PaintType.ENEMY_PRIMARY -> canMove_C = false;
                 case PaintType.ENEMY_SECONDARY -> canMove_C = false;
                 default -> {}
            }
        }
        double healthDmgAttackRange_C = 0;
        double myHealthDmg_C = 0;
        double paintDmgAttackRange_C = 0;
        double myPaintDmg_C = 0;
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
                    case SPLASHER: {
                        if (d <= splasherActionRadiusSquared) {
                            paintDmgAttackRange_N += (4 * 2) / splasherActionCooldown;
                        }
                        if (d <= mopperActionRadiusSquared && rc.isActionReady()) {
                            myPaintDmg_N = 15;
                        }
                        if (d < minDistToEnemy_N) minDistToEnemy_N = d;
                        break addEnemyN;
                    }
                    case MOPPER: {
                        if (d <= mopperActionRadiusSquared) {
                            paintDmgAttackRange_N += 11.666666666666666;
                        }
                        if (d <= mopperActionRadiusSquared && rc.isActionReady()) {
                            myPaintDmg_N = 15;
                        }
                        if (d < minDistToEnemy_N) minDistToEnemy_N = d;
                        break addEnemyN;
                    }
                    case SOLDIER: {
                        if (d <= mopperActionRadiusSquared && rc.isActionReady()) {
                            myPaintDmg_N = 15;
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
                    case SPLASHER: {
                        if (d <= splasherActionRadiusSquared) {
                            paintDmgAttackRange_NE += (4 * 2) / splasherActionCooldown;
                        }
                        if (d <= mopperActionRadiusSquared && rc.isActionReady()) {
                            myPaintDmg_NE = 15;
                        }
                        if (d < minDistToEnemy_NE) minDistToEnemy_NE = d;
                        break addEnemyNE;
                    }
                    case MOPPER: {
                        if (d <= mopperActionRadiusSquared) {
                            paintDmgAttackRange_NE += 11.666666666666666;
                        }
                        if (d <= mopperActionRadiusSquared && rc.isActionReady()) {
                            myPaintDmg_NE = 15;
                        }
                        if (d < minDistToEnemy_NE) minDistToEnemy_NE = d;
                        break addEnemyNE;
                    }
                    case SOLDIER: {
                        if (d <= mopperActionRadiusSquared && rc.isActionReady()) {
                            myPaintDmg_NE = 15;
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
                    case SPLASHER: {
                        if (d <= splasherActionRadiusSquared) {
                            paintDmgAttackRange_E += (4 * 2) / splasherActionCooldown;
                        }
                        if (d <= mopperActionRadiusSquared && rc.isActionReady()) {
                            myPaintDmg_E = 15;
                        }
                        if (d < minDistToEnemy_E) minDistToEnemy_E = d;
                        break addEnemyE;
                    }
                    case MOPPER: {
                        if (d <= mopperActionRadiusSquared) {
                            paintDmgAttackRange_E += 11.666666666666666;
                        }
                        if (d <= mopperActionRadiusSquared && rc.isActionReady()) {
                            myPaintDmg_E = 15;
                        }
                        if (d < minDistToEnemy_E) minDistToEnemy_E = d;
                        break addEnemyE;
                    }
                    case SOLDIER: {
                        if (d <= mopperActionRadiusSquared && rc.isActionReady()) {
                            myPaintDmg_E = 15;
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
                    case SPLASHER: {
                        if (d <= splasherActionRadiusSquared) {
                            paintDmgAttackRange_SE += (4 * 2) / splasherActionCooldown;
                        }
                        if (d <= mopperActionRadiusSquared && rc.isActionReady()) {
                            myPaintDmg_SE = 15;
                        }
                        if (d < minDistToEnemy_SE) minDistToEnemy_SE = d;
                        break addEnemySE;
                    }
                    case MOPPER: {
                        if (d <= mopperActionRadiusSquared) {
                            paintDmgAttackRange_SE += 11.666666666666666;
                        }
                        if (d <= mopperActionRadiusSquared && rc.isActionReady()) {
                            myPaintDmg_SE = 15;
                        }
                        if (d < minDistToEnemy_SE) minDistToEnemy_SE = d;
                        break addEnemySE;
                    }
                    case SOLDIER: {
                        if (d <= mopperActionRadiusSquared && rc.isActionReady()) {
                            myPaintDmg_SE = 15;
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
                    case SPLASHER: {
                        if (d <= splasherActionRadiusSquared) {
                            paintDmgAttackRange_S += (4 * 2) / splasherActionCooldown;
                        }
                        if (d <= mopperActionRadiusSquared && rc.isActionReady()) {
                            myPaintDmg_S = 15;
                        }
                        if (d < minDistToEnemy_S) minDistToEnemy_S = d;
                        break addEnemyS;
                    }
                    case MOPPER: {
                        if (d <= mopperActionRadiusSquared) {
                            paintDmgAttackRange_S += 11.666666666666666;
                        }
                        if (d <= mopperActionRadiusSquared && rc.isActionReady()) {
                            myPaintDmg_S = 15;
                        }
                        if (d < minDistToEnemy_S) minDistToEnemy_S = d;
                        break addEnemyS;
                    }
                    case SOLDIER: {
                        if (d <= mopperActionRadiusSquared && rc.isActionReady()) {
                            myPaintDmg_S = 15;
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
                    case SPLASHER: {
                        if (d <= splasherActionRadiusSquared) {
                            paintDmgAttackRange_SW += (4 * 2) / splasherActionCooldown;
                        }
                        if (d <= mopperActionRadiusSquared && rc.isActionReady()) {
                            myPaintDmg_SW = 15;
                        }
                        if (d < minDistToEnemy_SW) minDistToEnemy_SW = d;
                        break addEnemySW;
                    }
                    case MOPPER: {
                        if (d <= mopperActionRadiusSquared) {
                            paintDmgAttackRange_SW += 11.666666666666666;
                        }
                        if (d <= mopperActionRadiusSquared && rc.isActionReady()) {
                            myPaintDmg_SW = 15;
                        }
                        if (d < minDistToEnemy_SW) minDistToEnemy_SW = d;
                        break addEnemySW;
                    }
                    case SOLDIER: {
                        if (d <= mopperActionRadiusSquared && rc.isActionReady()) {
                            myPaintDmg_SW = 15;
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
                    case SPLASHER: {
                        if (d <= splasherActionRadiusSquared) {
                            paintDmgAttackRange_W += (4 * 2) / splasherActionCooldown;
                        }
                        if (d <= mopperActionRadiusSquared && rc.isActionReady()) {
                            myPaintDmg_W = 15;
                        }
                        if (d < minDistToEnemy_W) minDistToEnemy_W = d;
                        break addEnemyW;
                    }
                    case MOPPER: {
                        if (d <= mopperActionRadiusSquared) {
                            paintDmgAttackRange_W += 11.666666666666666;
                        }
                        if (d <= mopperActionRadiusSquared && rc.isActionReady()) {
                            myPaintDmg_W = 15;
                        }
                        if (d < minDistToEnemy_W) minDistToEnemy_W = d;
                        break addEnemyW;
                    }
                    case SOLDIER: {
                        if (d <= mopperActionRadiusSquared && rc.isActionReady()) {
                            myPaintDmg_W = 15;
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
                    case SPLASHER: {
                        if (d <= splasherActionRadiusSquared) {
                            paintDmgAttackRange_NW += (4 * 2) / splasherActionCooldown;
                        }
                        if (d <= mopperActionRadiusSquared && rc.isActionReady()) {
                            myPaintDmg_NW = 15;
                        }
                        if (d < minDistToEnemy_NW) minDistToEnemy_NW = d;
                        break addEnemyNW;
                    }
                    case MOPPER: {
                        if (d <= mopperActionRadiusSquared) {
                            paintDmgAttackRange_NW += 11.666666666666666;
                        }
                        if (d <= mopperActionRadiusSquared && rc.isActionReady()) {
                            myPaintDmg_NW = 15;
                        }
                        if (d < minDistToEnemy_NW) minDistToEnemy_NW = d;
                        break addEnemyNW;
                    }
                    case SOLDIER: {
                        if (d <= mopperActionRadiusSquared && rc.isActionReady()) {
                            myPaintDmg_NW = 15;
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
                    case SPLASHER: {
                        if (d <= splasherActionRadiusSquared) {
                            paintDmgAttackRange_C += (4 * 2) / splasherActionCooldown;
                        }
                        if (d <= mopperActionRadiusSquared && rc.isActionReady()) {
                            myPaintDmg_C = 15;
                        }
                        if (d < minDistToEnemy_C) minDistToEnemy_C = d;
                        break addEnemyC;
                    }
                    case MOPPER: {
                        if (d <= mopperActionRadiusSquared) {
                            paintDmgAttackRange_C += 11.666666666666666;
                        }
                        if (d <= mopperActionRadiusSquared && rc.isActionReady()) {
                            myPaintDmg_C = 15;
                        }
                        if (d < minDistToEnemy_C) minDistToEnemy_C = d;
                        break addEnemyC;
                    }
                    case SOLDIER: {
                        if (d <= mopperActionRadiusSquared && rc.isActionReady()) {
                            myPaintDmg_C = 15;
                        }
                        if (d < minDistToEnemy_C) minDistToEnemy_C = d;
                        break addEnemyC;
                    }
                    
                    default: break addEnemyC;
                }
            }
            
        }

        
        System.out.println("[144] " + "minDistToEnemy_N = " + minDistToEnemy_N + ", " + "targetLoc_N.x = " + targetLoc_N.x + ", " + "canMove_N = " + canMove_N + ", " + "targetLoc_N.y = " + targetLoc_N.y + ", " + "myPaintDmg_N = " + myPaintDmg_N + ", " + "paintDmgAttackRange_N = " + paintDmgAttackRange_N);
        
        System.out.println("[144] " + "minDistToEnemy_NE = " + minDistToEnemy_NE + ", " + "targetLoc_NE.x = " + targetLoc_NE.x + ", " + "canMove_NE = " + canMove_NE + ", " + "targetLoc_NE.y = " + targetLoc_NE.y + ", " + "myPaintDmg_NE = " + myPaintDmg_NE + ", " + "paintDmgAttackRange_NE = " + paintDmgAttackRange_NE);
        
        System.out.println("[144] " + "minDistToEnemy_E = " + minDistToEnemy_E + ", " + "targetLoc_E.x = " + targetLoc_E.x + ", " + "canMove_E = " + canMove_E + ", " + "targetLoc_E.y = " + targetLoc_E.y + ", " + "myPaintDmg_E = " + myPaintDmg_E + ", " + "paintDmgAttackRange_E = " + paintDmgAttackRange_E);
        
        System.out.println("[144] " + "minDistToEnemy_SE = " + minDistToEnemy_SE + ", " + "targetLoc_SE.x = " + targetLoc_SE.x + ", " + "canMove_SE = " + canMove_SE + ", " + "targetLoc_SE.y = " + targetLoc_SE.y + ", " + "myPaintDmg_SE = " + myPaintDmg_SE + ", " + "paintDmgAttackRange_SE = " + paintDmgAttackRange_SE);
        
        System.out.println("[144] " + "minDistToEnemy_S = " + minDistToEnemy_S + ", " + "targetLoc_S.x = " + targetLoc_S.x + ", " + "canMove_S = " + canMove_S + ", " + "targetLoc_S.y = " + targetLoc_S.y + ", " + "myPaintDmg_S = " + myPaintDmg_S + ", " + "paintDmgAttackRange_S = " + paintDmgAttackRange_S);
        
        System.out.println("[144] " + "minDistToEnemy_SW = " + minDistToEnemy_SW + ", " + "targetLoc_SW.x = " + targetLoc_SW.x + ", " + "canMove_SW = " + canMove_SW + ", " + "targetLoc_SW.y = " + targetLoc_SW.y + ", " + "myPaintDmg_SW = " + myPaintDmg_SW + ", " + "paintDmgAttackRange_SW = " + paintDmgAttackRange_SW);
        
        System.out.println("[144] " + "minDistToEnemy_W = " + minDistToEnemy_W + ", " + "targetLoc_W.x = " + targetLoc_W.x + ", " + "canMove_W = " + canMove_W + ", " + "targetLoc_W.y = " + targetLoc_W.y + ", " + "myPaintDmg_W = " + myPaintDmg_W + ", " + "paintDmgAttackRange_W = " + paintDmgAttackRange_W);
        
        System.out.println("[144] " + "minDistToEnemy_NW = " + minDistToEnemy_NW + ", " + "targetLoc_NW.x = " + targetLoc_NW.x + ", " + "canMove_NW = " + canMove_NW + ", " + "targetLoc_NW.y = " + targetLoc_NW.y + ", " + "myPaintDmg_NW = " + myPaintDmg_NW + ", " + "paintDmgAttackRange_NW = " + paintDmgAttackRange_NW);
        
        System.out.println("[144] " + "minDistToEnemy_C = " + minDistToEnemy_C + ", " + "targetLoc_C.x = " + targetLoc_C.x + ", " + "canMove_C = " + canMove_C + ", " + "targetLoc_C.y = " + targetLoc_C.y + ", " + "myPaintDmg_C = " + myPaintDmg_C + ", " + "paintDmgAttackRange_C = " + paintDmgAttackRange_C);
        

        boolean bestWins = false;
        Direction bestDir = Direction.NORTH;
        MapLocation targetLoc_best = myloc.add(Direction.NORTH);
        boolean canMove_best = (rc.canMove(Direction.NORTH));
        if (rc.canSenseLocation(targetLoc_best)) {
            PaintType paint_best = rc.senseMapInfo(targetLoc_best).getPaint();
            switch (rc.senseMapInfo(targetLoc_best).getPaint()) {
                 case PaintType.ENEMY_PRIMARY -> canMove_best = false;
                 case PaintType.ENEMY_SECONDARY -> canMove_best = false;
                 default -> {}
            }
        }
        double healthDmgAttackRange_best = 0;
        double myHealthDmg_best = 0;
        double paintDmgAttackRange_best = 0;
        double myPaintDmg_best = 0;
        int minDistToEnemy_best = 100000;
        
        
        bestWins = canMove_best;
        chooseBestNE: {
            if (!canMove_NE || !canMove_best) break chooseBestNE;
            double bestAttackDmgDiff = paintDmgAttackRange_best - myPaintDmg_best;
            double otherAttackDmgDiff = paintDmgAttackRange_NE - myPaintDmg_NE;
            if (bestAttackDmgDiff != otherAttackDmgDiff) {
                bestWins = (bestAttackDmgDiff < otherAttackDmgDiff);
                break chooseBestNE;
            }
            bestWins = (minDistToEnemy_best <= minDistToEnemy_NE);
            break chooseBestNE;
        }
        
        
        if (!bestWins) {
            targetLoc_best = targetLoc_NE;
            canMove_best = canMove_NE;
            paintDmgAttackRange_best = paintDmgAttackRange_NE;
            myPaintDmg_best = myPaintDmg_NE;
            minDistToEnemy_best = minDistToEnemy_NE;
            bestDir = Direction.NORTHEAST;
        }
        
        
        bestWins = canMove_best;
        chooseBestE: {
            if (!canMove_E || !canMove_best) break chooseBestE;
            double bestAttackDmgDiff = paintDmgAttackRange_best - myPaintDmg_best;
            double otherAttackDmgDiff = paintDmgAttackRange_E - myPaintDmg_E;
            if (bestAttackDmgDiff != otherAttackDmgDiff) {
                bestWins = (bestAttackDmgDiff < otherAttackDmgDiff);
                break chooseBestE;
            }
            bestWins = (minDistToEnemy_best <= minDistToEnemy_E);
            break chooseBestE;
        }
        
        
        if (!bestWins) {
            targetLoc_best = targetLoc_E;
            canMove_best = canMove_E;
            paintDmgAttackRange_best = paintDmgAttackRange_E;
            myPaintDmg_best = myPaintDmg_E;
            minDistToEnemy_best = minDistToEnemy_E;
            bestDir = Direction.EAST;
        }
        
        
        bestWins = canMove_best;
        chooseBestSE: {
            if (!canMove_SE || !canMove_best) break chooseBestSE;
            double bestAttackDmgDiff = paintDmgAttackRange_best - myPaintDmg_best;
            double otherAttackDmgDiff = paintDmgAttackRange_SE - myPaintDmg_SE;
            if (bestAttackDmgDiff != otherAttackDmgDiff) {
                bestWins = (bestAttackDmgDiff < otherAttackDmgDiff);
                break chooseBestSE;
            }
            bestWins = (minDistToEnemy_best <= minDistToEnemy_SE);
            break chooseBestSE;
        }
        
        
        if (!bestWins) {
            targetLoc_best = targetLoc_SE;
            canMove_best = canMove_SE;
            paintDmgAttackRange_best = paintDmgAttackRange_SE;
            myPaintDmg_best = myPaintDmg_SE;
            minDistToEnemy_best = minDistToEnemy_SE;
            bestDir = Direction.SOUTHEAST;
        }
        
        
        bestWins = canMove_best;
        chooseBestS: {
            if (!canMove_S || !canMove_best) break chooseBestS;
            double bestAttackDmgDiff = paintDmgAttackRange_best - myPaintDmg_best;
            double otherAttackDmgDiff = paintDmgAttackRange_S - myPaintDmg_S;
            if (bestAttackDmgDiff != otherAttackDmgDiff) {
                bestWins = (bestAttackDmgDiff < otherAttackDmgDiff);
                break chooseBestS;
            }
            bestWins = (minDistToEnemy_best <= minDistToEnemy_S);
            break chooseBestS;
        }
        
        
        if (!bestWins) {
            targetLoc_best = targetLoc_S;
            canMove_best = canMove_S;
            paintDmgAttackRange_best = paintDmgAttackRange_S;
            myPaintDmg_best = myPaintDmg_S;
            minDistToEnemy_best = minDistToEnemy_S;
            bestDir = Direction.SOUTH;
        }
        
        
        bestWins = canMove_best;
        chooseBestSW: {
            if (!canMove_SW || !canMove_best) break chooseBestSW;
            double bestAttackDmgDiff = paintDmgAttackRange_best - myPaintDmg_best;
            double otherAttackDmgDiff = paintDmgAttackRange_SW - myPaintDmg_SW;
            if (bestAttackDmgDiff != otherAttackDmgDiff) {
                bestWins = (bestAttackDmgDiff < otherAttackDmgDiff);
                break chooseBestSW;
            }
            bestWins = (minDistToEnemy_best <= minDistToEnemy_SW);
            break chooseBestSW;
        }
        
        
        if (!bestWins) {
            targetLoc_best = targetLoc_SW;
            canMove_best = canMove_SW;
            paintDmgAttackRange_best = paintDmgAttackRange_SW;
            myPaintDmg_best = myPaintDmg_SW;
            minDistToEnemy_best = minDistToEnemy_SW;
            bestDir = Direction.SOUTHWEST;
        }
        
        
        bestWins = canMove_best;
        chooseBestW: {
            if (!canMove_W || !canMove_best) break chooseBestW;
            double bestAttackDmgDiff = paintDmgAttackRange_best - myPaintDmg_best;
            double otherAttackDmgDiff = paintDmgAttackRange_W - myPaintDmg_W;
            if (bestAttackDmgDiff != otherAttackDmgDiff) {
                bestWins = (bestAttackDmgDiff < otherAttackDmgDiff);
                break chooseBestW;
            }
            bestWins = (minDistToEnemy_best <= minDistToEnemy_W);
            break chooseBestW;
        }
        
        
        if (!bestWins) {
            targetLoc_best = targetLoc_W;
            canMove_best = canMove_W;
            paintDmgAttackRange_best = paintDmgAttackRange_W;
            myPaintDmg_best = myPaintDmg_W;
            minDistToEnemy_best = minDistToEnemy_W;
            bestDir = Direction.WEST;
        }
        
        
        bestWins = canMove_best;
        chooseBestNW: {
            if (!canMove_NW || !canMove_best) break chooseBestNW;
            double bestAttackDmgDiff = paintDmgAttackRange_best - myPaintDmg_best;
            double otherAttackDmgDiff = paintDmgAttackRange_NW - myPaintDmg_NW;
            if (bestAttackDmgDiff != otherAttackDmgDiff) {
                bestWins = (bestAttackDmgDiff < otherAttackDmgDiff);
                break chooseBestNW;
            }
            bestWins = (minDistToEnemy_best <= minDistToEnemy_NW);
            break chooseBestNW;
        }
        
        
        if (!bestWins) {
            targetLoc_best = targetLoc_NW;
            canMove_best = canMove_NW;
            paintDmgAttackRange_best = paintDmgAttackRange_NW;
            myPaintDmg_best = myPaintDmg_NW;
            minDistToEnemy_best = minDistToEnemy_NW;
            bestDir = Direction.NORTHWEST;
        }
        
        
        bestWins = canMove_best;
        chooseBestC: {
            if (!canMove_C || !canMove_best) break chooseBestC;
            double bestAttackDmgDiff = paintDmgAttackRange_best - myPaintDmg_best;
            double otherAttackDmgDiff = paintDmgAttackRange_C - myPaintDmg_C;
            if (bestAttackDmgDiff != otherAttackDmgDiff) {
                bestWins = (bestAttackDmgDiff < otherAttackDmgDiff);
                break chooseBestC;
            }
            bestWins = (minDistToEnemy_best <= minDistToEnemy_C);
            break chooseBestC;
        }
        
        
        if (!bestWins) {
            targetLoc_best = targetLoc_C;
            canMove_best = canMove_C;
            paintDmgAttackRange_best = paintDmgAttackRange_C;
            myPaintDmg_best = myPaintDmg_C;
            minDistToEnemy_best = minDistToEnemy_C;
            bestDir = Direction.CENTER;
        }
        
        

        
        System.out.println("[156] " + "minDistToEnemy_best = " + minDistToEnemy_best + ", " + "targetLoc_best.x = " + targetLoc_best.x + ", " + "canMove_best = " + canMove_best + ", " + "targetLoc_best.y = " + targetLoc_best.y + ", " + "myPaintDmg_best = " + myPaintDmg_best + ", " + "paintDmgAttackRange_best = " + paintDmgAttackRange_best);
        System.out.println("\n");

        if (rc.canMove(bestDir)) {
            rc.move(bestDir);
        }
        mopperTryAttack();
    }
    
    

}