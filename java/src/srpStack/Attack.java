package srpStack;
import battlecode.common.*;




public class Attack {
    public static MapLocation myloc;
    public static RobotController rc;

    
    public static int soldierActionRadiusSquared;
    public static int soldierPaintCapacity;
    public static int soldierActionCooldown;
    public static int soldierAttackStrength;
    public static int soldierAoeAttackStrength;
    public static int splasherActionRadiusSquared;
    public static int splasherPaintCapacity;
    public static int splasherActionCooldown;
    public static int splasherAttackStrength;
    public static int splasherAoeAttackStrength;
    public static void init(RobotController rc) {
        Attack.rc = rc;
        soldierActionRadiusSquared = UnitType.SOLDIER.actionRadiusSquared;
        soldierPaintCapacity = UnitType.SOLDIER.paintCapacity;
        soldierActionCooldown = UnitType.SOLDIER.actionCooldown;
        soldierAttackStrength = UnitType.SOLDIER.attackStrength;
        soldierAoeAttackStrength = UnitType.SOLDIER.aoeAttackStrength;
        splasherActionRadiusSquared = UnitType.SPLASHER.actionRadiusSquared;
        splasherPaintCapacity = UnitType.SPLASHER.paintCapacity;
        splasherActionCooldown = UnitType.SPLASHER.actionCooldown;
        splasherAttackStrength = UnitType.SPLASHER.attackStrength;
        splasherAoeAttackStrength = UnitType.SPLASHER.aoeAttackStrength;
        
        splasherActionRadiusSquared = 9;
    }
    
    public static void initTurn() throws GameActionException {
        myloc = rc.getLocation();
        boolean shouldComputeReachSoon = false;
        for (int i = Globals.enemies.length; --i >= 0; ) {
            RobotInfo enemy = Globals.enemies[i];
            switch (enemy.type) {
                case SOLDIER, MOPPER, SPLASHER: continue;
                default:
                    shouldComputeReachSoon = true;
                    break;
            }
        }
        if (shouldComputeReachSoon) computeReachSoonMask();
    }

    
    
    
    

    // You can get away with looking at (and BFSing) single mask...
    public static long initialMask = 0x10000000000L;;
    public static long reachSoonMask = initialMask;
    public static long loverflow = 0x7fbfdfeff7fbfdfeL;
    public static long roverflow = 0x3fdfeff7fbfdfeffL;
    public static long mask0 = 0x7FFFFFFFFFFDFC7CL;
    public static long mask1 = 0x0000F8FEL;
    public static void computeReachSoonMask() throws GameActionException {
        reachSoonMask = initialMask;
        
        // Unfortunate that we do this twice...
        long passible0 = (~(
              ((long)(TileLoader.local_wall6 | TileLoader.local_ruin6) << 54)
            | ((long)(TileLoader.local_wall5 | TileLoader.local_ruin5) << 45)
            | ((long)(TileLoader.local_wall4 | TileLoader.local_ruin4) << 36)
            | ((long)(TileLoader.local_wall3 | TileLoader.local_ruin3) << 27)
            | ((long)(TileLoader.local_wall2 | TileLoader.local_ruin2) << 18)
            | ((long)(TileLoader.local_wall1 | TileLoader.local_ruin1) << 9)
            | ((long)(TileLoader.local_wall0 | TileLoader.local_ruin0))
        )) & mask0;

        long passible1 = (~(
              ((long)(TileLoader.local_wall8) << 9)
            | ((long)(TileLoader.local_wall7))
        )) & mask1;

        // Run a BFS
        long mask0AndPassible = mask0 & passible0;
        long mask1AndPassible = mask1 & passible1;
        bfsLoop: {
            
            reachSoonMask = (reachSoonMask | ((reachSoonMask << 1) & loverflow) | ((reachSoonMask >>> 1) & roverflow));
            reachSoonMask = (reachSoonMask | (reachSoonMask << 9) | (reachSoonMask >>> 9)) & mask0AndPassible;
            
            reachSoonMask = (reachSoonMask | ((reachSoonMask << 1) & loverflow) | ((reachSoonMask >>> 1) & roverflow));
            reachSoonMask = (reachSoonMask | (reachSoonMask << 9) | (reachSoonMask >>> 9)) & mask0AndPassible;
            
        }
    }

    
    public static boolean canHitSoon(MapLocation m) {
        int dy = (m.y - (myloc.y - 4));
        int dx = (m.x - (myloc.x - 4));
        switch (dy) {
            
            case (0) -> {
                switch (dx) {
                    
                    case (0) -> /* (0, 0) */ {
                        
                        return (0x081C0E0FL & reachSoonMask) != 0;
                    }
                    
                    case (1) -> /* (1, 0) */ {
                        
                        return (0x103C1E1FL & reachSoonMask) != 0;
                    }
                    
                    case (2) -> /* (2, 0) */ {
                        
                        return (0x207C3E3FL & reachSoonMask) != 0;
                    }
                    
                    case (3) -> /* (3, 0) */ {
                        
                        return (0x40F87C7FL & reachSoonMask) != 0;
                    }
                    
                    case (4) -> /* (4, 0) */ {
                        
                        return (0x81F0F8FEL & reachSoonMask) != 0;
                    }
                    
                    case (5) -> /* (5, 0) */ {
                        
                        return (0x103E1F1FCL & reachSoonMask) != 0;
                    }
                    
                    case (6) -> /* (6, 0) */ {
                        
                        return (0x207C3E1F8L & reachSoonMask) != 0;
                    }
                    
                    case (7) -> /* (7, 0) */ {
                        
                        return (0x40783C1F0L & reachSoonMask) != 0;
                    }
                    
                    case (8) -> /* (8, 0) */ {
                        
                        return (0x8070381E0L & reachSoonMask) != 0;
                    }
                    
                    default -> {
                        return false;
                    }
                }
            }
            
            case (1) -> {
                switch (dx) {
                    
                    case (0) -> /* (0, 1) */ {
                        
                        return (0x10381C1E07L & reachSoonMask) != 0;
                    }
                    
                    case (1) -> /* (1, 1) */ {
                        
                        return (0x20783C3E0FL & reachSoonMask) != 0;
                    }
                    
                    case (2) -> /* (2, 1) */ {
                        
                        return (0x40F87C7E1FL & reachSoonMask) != 0;
                    }
                    
                    case (3) -> /* (3, 1) */ {
                        
                        return (0x81F0F8FE3EL & reachSoonMask) != 0;
                    }
                    
                    case (4) -> /* (4, 1) */ {
                        
                        return (0x103E1F1FC7CL & reachSoonMask) != 0;
                    }
                    
                    case (5) -> /* (5, 1) */ {
                        
                        return (0x207C3E3F8F8L & reachSoonMask) != 0;
                    }
                    
                    case (6) -> /* (6, 1) */ {
                        
                        return (0x40F87C3F1F0L & reachSoonMask) != 0;
                    }
                    
                    case (7) -> /* (7, 1) */ {
                        
                        return (0x80F0783E1E0L & reachSoonMask) != 0;
                    }
                    
                    case (8) -> /* (8, 1) */ {
                        
                        return (0x100E0703C1C0L & reachSoonMask) != 0;
                    }
                    
                    default -> {
                        return false;
                    }
                }
            }
            
            case (2) -> {
                switch (dx) {
                    
                    case (0) -> /* (0, 2) */ {
                        
                        return (0x2070383C0E07L & reachSoonMask) != 0;
                    }
                    
                    case (1) -> /* (1, 2) */ {
                        
                        return (0x40F0787C1E0FL & reachSoonMask) != 0;
                    }
                    
                    case (2) -> /* (2, 2) */ {
                        
                        return (0x81F0F8FC3E1FL & reachSoonMask) != 0;
                    }
                    
                    case (3) -> /* (3, 2) */ {
                        
                        return (0x103E1F1FC7C3EL & reachSoonMask) != 0;
                    }
                    
                    case (4) -> /* (4, 2) */ {
                        
                        return (0x207C3E3F8F87CL & reachSoonMask) != 0;
                    }
                    
                    case (5) -> /* (5, 2) */ {
                        
                        return (0x40F87C7F1F0F8L & reachSoonMask) != 0;
                    }
                    
                    case (6) -> /* (6, 2) */ {
                        
                        return (0x81F0F87E3E1F0L & reachSoonMask) != 0;
                    }
                    
                    case (7) -> /* (7, 2) */ {
                        
                        return (0x101E0F07C3C1E0L & reachSoonMask) != 0;
                    }
                    
                    case (8) -> /* (8, 2) */ {
                        
                        return (0x201C0E078381C0L & reachSoonMask) != 0;
                    }
                    
                    default -> {
                        return false;
                    }
                }
            }
            
            case (3) -> {
                switch (dx) {
                    
                    case (0) -> /* (0, 3) */ {
                        
                        return (0x40E070781C0E01L & reachSoonMask) != 0;
                    }
                    
                    case (1) -> /* (1, 3) */ {
                        
                        return (0x81E0F0F83C1E02L & reachSoonMask) != 0;
                    }
                    
                    case (2) -> /* (2, 3) */ {
                        
                        return (0x103E1F1F87C3E04L & reachSoonMask) != 0;
                    }
                    
                    case (3) -> /* (3, 3) */ {
                        
                        return (0x207C3E3F8F87C08L & reachSoonMask) != 0;
                    }
                    
                    case (4) -> /* (4, 3) */ {
                        
                        return (0x40F87C7F1F0F810L & reachSoonMask) != 0;
                    }
                    
                    case (5) -> /* (5, 3) */ {
                        
                        return (0x81F0F8FE3E1F020L & reachSoonMask) != 0;
                    }
                    
                    case (6) -> /* (6, 3) */ {
                        
                        return (0x103E1F0FC7C3E040L & reachSoonMask) != 0;
                    }
                    
                    case (7) -> /* (7, 3) */ {
                        
                        return (0x203C1E0F8783C080L & reachSoonMask) != 0;
                    }
                    
                    case (8) -> /* (8, 3) */ {
                        
                        return (0x40381C0F07038100L & reachSoonMask) != 0;
                    }
                    
                    default -> {
                        return false;
                    }
                }
            }
            
            case (4) -> {
                switch (dx) {
                    
                    case (0) -> /* (0, 4) */ {
                        
                        return (0x1C0E0F0381C0200L & reachSoonMask) != 0;
                    }
                    
                    case (1) -> /* (1, 4) */ {
                        
                        return (0x3C1E1F0783C0400L & reachSoonMask) != 0;
                    }
                    
                    case (2) -> /* (2, 4) */ {
                        
                        return (0x7C3E3F0F87C0800L & reachSoonMask) != 0;
                    }
                    
                    case (3) -> /* (3, 4) */ {
                        
                        return (0xF87C7F1F0F81000L & reachSoonMask) != 0;
                    }
                    
                    case (4) -> /* (4, 4) */ {
                        
                        return (0x1F0F8FE3E1F02000L & reachSoonMask) != 0;
                    }
                    
                    case (5) -> /* (5, 4) */ {
                        
                        return (0x3E1F1FC7C3E04000L & reachSoonMask) != 0;
                    }
                    
                    case (6) -> /* (6, 4) */ {
                        
                        return (0x7C3E1F8F87C08000L & reachSoonMask) != 0;
                    }
                    
                    case (7) -> /* (7, 4) */ {
                        
                        return (0x783C1F0F07810000L & reachSoonMask) != 0;
                    }
                    
                    case (8) -> /* (8, 4) */ {
                        
                        return (0x70381E0E07020000L & reachSoonMask) != 0;
                    }
                    
                    default -> {
                        return false;
                    }
                }
            }
            
            case (5) -> {
                switch (dx) {
                    
                    case (0) -> /* (0, 5) */ {
                        
                        return (0x1C1E07038040000L & reachSoonMask) != 0;
                    }
                    
                    case (1) -> /* (1, 5) */ {
                        
                        return (0x3C3E0F078080000L & reachSoonMask) != 0;
                    }
                    
                    case (2) -> /* (2, 5) */ {
                        
                        return (0x7C7E1F0F8100000L & reachSoonMask) != 0;
                    }
                    
                    case (3) -> /* (3, 5) */ {
                        
                        return (0xF8FE3E1F0200000L & reachSoonMask) != 0;
                    }
                    
                    case (4) -> /* (4, 5) */ {
                        
                        return (0x1F1FC7C3E0400000L & reachSoonMask) != 0;
                    }
                    
                    case (5) -> /* (5, 5) */ {
                        
                        return (0x3E3F8F87C0800000L & reachSoonMask) != 0;
                    }
                    
                    case (6) -> /* (6, 5) */ {
                        
                        return (0x7C3F1F0F81000000L & reachSoonMask) != 0;
                    }
                    
                    case (7) -> /* (7, 5) */ {
                        
                        return (0x783E1E0F02000000L & reachSoonMask) != 0;
                    }
                    
                    case (8) -> /* (8, 5) */ {
                        
                        return (0x703C1C0E04000000L & reachSoonMask) != 0;
                    }
                    
                    default -> {
                        return false;
                    }
                }
            }
            
            case (6) -> {
                switch (dx) {
                    
                    case (0) -> /* (0, 6) */ {
                        
                        return (0x3C0E07008000000L & reachSoonMask) != 0;
                    }
                    
                    case (1) -> /* (1, 6) */ {
                        
                        return (0x7C1E0F010000000L & reachSoonMask) != 0;
                    }
                    
                    case (2) -> /* (2, 6) */ {
                        
                        return (0xFC3E1F020000000L & reachSoonMask) != 0;
                    }
                    
                    case (3) -> /* (3, 6) */ {
                        
                        return (0x1FC7C3E040000000L & reachSoonMask) != 0;
                    }
                    
                    case (4) -> /* (4, 6) */ {
                        
                        return (0x3F8F87C080000000L & reachSoonMask) != 0;
                    }
                    
                    case (5) -> /* (5, 6) */ {
                        
                        return (0x7F1F0F8100000000L & reachSoonMask) != 0;
                    }
                    
                    case (6) -> /* (6, 6) */ {
                        
                        return (0x7E3E1F0200000000L & reachSoonMask) != 0;
                    }
                    
                    case (7) -> /* (7, 6) */ {
                        
                        return (0x7C3C1E0400000000L & reachSoonMask) != 0;
                    }
                    
                    case (8) -> /* (8, 6) */ {
                        
                        return (0x78381C0800000000L & reachSoonMask) != 0;
                    }
                    
                    default -> {
                        return false;
                    }
                }
            }
            
            case (7) -> {
                switch (dx) {
                    
                    case (0) -> /* (0, 7) */ {
                        
                        return (0x1C0E01000000000L & reachSoonMask) != 0;
                    }
                    
                    case (1) -> /* (1, 7) */ {
                        
                        return (0x3C1E02000000000L & reachSoonMask) != 0;
                    }
                    
                    case (2) -> /* (2, 7) */ {
                        
                        return (0x7C3E04000000000L & reachSoonMask) != 0;
                    }
                    
                    case (3) -> /* (3, 7) */ {
                        
                        return (0xF87C08000000000L & reachSoonMask) != 0;
                    }
                    
                    case (4) -> /* (4, 7) */ {
                        
                        return (0x1F0F810000000000L & reachSoonMask) != 0;
                    }
                    
                    case (5) -> /* (5, 7) */ {
                        
                        return (0x3E1F020000000000L & reachSoonMask) != 0;
                    }
                    
                    case (6) -> /* (6, 7) */ {
                        
                        return (0x7C3E040000000000L & reachSoonMask) != 0;
                    }
                    
                    case (7) -> /* (7, 7) */ {
                        
                        return (0x783C080000000000L & reachSoonMask) != 0;
                    }
                    
                    case (8) -> /* (8, 7) */ {
                        
                        return (0x7038100000000000L & reachSoonMask) != 0;
                    }
                    
                    default -> {
                        return false;
                    }
                }
            }
            
            case (8) -> {
                switch (dx) {
                    
                    case (0) -> /* (0, 8) */ {
                        
                        return (0x1C0200000000000L & reachSoonMask) != 0;
                    }
                    
                    case (1) -> /* (1, 8) */ {
                        
                        return (0x3C0400000000000L & reachSoonMask) != 0;
                    }
                    
                    case (2) -> /* (2, 8) */ {
                        
                        return (0x7C0800000000000L & reachSoonMask) != 0;
                    }
                    
                    case (3) -> /* (3, 8) */ {
                        
                        return (0xF81000000000000L & reachSoonMask) != 0;
                    }
                    
                    case (4) -> /* (4, 8) */ {
                        
                        return (0x1F02000000000000L & reachSoonMask) != 0;
                    }
                    
                    case (5) -> /* (5, 8) */ {
                        
                        return (0x3E04000000000000L & reachSoonMask) != 0;
                    }
                    
                    case (6) -> /* (6, 8) */ {
                        
                        return (0x7C08000000000000L & reachSoonMask) != 0;
                    }
                    
                    case (7) -> /* (7, 8) */ {
                        
                        return (0x7810000000000000L & reachSoonMask) != 0;
                    }
                    
                    case (8) -> /* (8, 8) */ {
                        
                        return (0x7020000000000000L & reachSoonMask) != 0;
                    }
                    
                    default -> {
                        return false;
                    }
                }
            }
            
            default -> {
                return false;
            }
        }
    }


    public static boolean shouldSoldierMicro() throws GameActionException {
        for (int i = Globals.enemies.length; --i >= 0; ) {
            RobotInfo enemy = Globals.enemies[i];
            switch (enemy.type) {
                case SOLDIER, MOPPER, SPLASHER: continue;
                default: if (canHitSoon(enemy.location)) return true;
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
            RobotInfo enemy = Globals.enemies[i];
            switch (enemy.type) {
                case SOLDIER, MOPPER, SPLASHER: continue;
                default: if (canHitSoon(enemy.location)) return true;
            }
        }
        return false;
    }

    public static void splasherTryAttack() throws GameActionException {
        if (!rc.isActionReady() || rc.getPaint() < (UnitType.SPLASHER.paintCapacity >> 2)) return;
        MapLocation myloc = rc.getLocation();
        int x = myloc.x, y = myloc.y;
        MapLocation bestLoc = null;
        int count = 0, bestCount = -1;

        
        
        MapLocation mloc00 = new MapLocation(x + -3, y + -3);
        boolean hasTower00 = false;
        if (rc.canSenseLocation(mloc00)) {
            RobotInfo r00 = rc.senseRobotAtLocation(mloc00);
            if ( r00 != null &&  r00.team != rc.getTeam() && Globals.isTower(r00.type)) {
                hasTower00 = true;
            }
        }
        
        MapLocation mloc01 = new MapLocation(x + -3, y + -2);
        boolean hasTower01 = false;
        if (rc.canSenseLocation(mloc01)) {
            RobotInfo r01 = rc.senseRobotAtLocation(mloc01);
            if ( r01 != null &&  r01.team != rc.getTeam() && Globals.isTower(r01.type)) {
                hasTower01 = true;
            }
        }
        
        MapLocation mloc02 = new MapLocation(x + -3, y + -1);
        boolean hasTower02 = false;
        if (rc.canSenseLocation(mloc02)) {
            RobotInfo r02 = rc.senseRobotAtLocation(mloc02);
            if ( r02 != null &&  r02.team != rc.getTeam() && Globals.isTower(r02.type)) {
                hasTower02 = true;
            }
        }
        
        MapLocation mloc03 = new MapLocation(x + -3, y + 0);
        boolean hasTower03 = false;
        if (rc.canSenseLocation(mloc03)) {
            RobotInfo r03 = rc.senseRobotAtLocation(mloc03);
            if ( r03 != null &&  r03.team != rc.getTeam() && Globals.isTower(r03.type)) {
                hasTower03 = true;
            }
        }
        
        MapLocation mloc04 = new MapLocation(x + -3, y + 1);
        boolean hasTower04 = false;
        if (rc.canSenseLocation(mloc04)) {
            RobotInfo r04 = rc.senseRobotAtLocation(mloc04);
            if ( r04 != null &&  r04.team != rc.getTeam() && Globals.isTower(r04.type)) {
                hasTower04 = true;
            }
        }
        
        MapLocation mloc05 = new MapLocation(x + -3, y + 2);
        boolean hasTower05 = false;
        if (rc.canSenseLocation(mloc05)) {
            RobotInfo r05 = rc.senseRobotAtLocation(mloc05);
            if ( r05 != null &&  r05.team != rc.getTeam() && Globals.isTower(r05.type)) {
                hasTower05 = true;
            }
        }
        
        MapLocation mloc06 = new MapLocation(x + -3, y + 3);
        boolean hasTower06 = false;
        if (rc.canSenseLocation(mloc06)) {
            RobotInfo r06 = rc.senseRobotAtLocation(mloc06);
            if ( r06 != null &&  r06.team != rc.getTeam() && Globals.isTower(r06.type)) {
                hasTower06 = true;
            }
        }
        
        
        
        MapLocation mloc10 = new MapLocation(x + -2, y + -3);
        boolean hasTower10 = false;
        if (rc.canSenseLocation(mloc10)) {
            RobotInfo r10 = rc.senseRobotAtLocation(mloc10);
            if ( r10 != null &&  r10.team != rc.getTeam() && Globals.isTower(r10.type)) {
                hasTower10 = true;
            }
        }
        
        MapLocation mloc11 = new MapLocation(x + -2, y + -2);
        boolean hasTower11 = false;
        if (rc.canSenseLocation(mloc11)) {
            RobotInfo r11 = rc.senseRobotAtLocation(mloc11);
            if ( r11 != null &&  r11.team != rc.getTeam() && Globals.isTower(r11.type)) {
                hasTower11 = true;
            }
        }
        
        MapLocation mloc12 = new MapLocation(x + -2, y + -1);
        boolean hasTower12 = false;
        if (rc.canSenseLocation(mloc12)) {
            RobotInfo r12 = rc.senseRobotAtLocation(mloc12);
            if ( r12 != null &&  r12.team != rc.getTeam() && Globals.isTower(r12.type)) {
                hasTower12 = true;
            }
        }
        
        MapLocation mloc13 = new MapLocation(x + -2, y + 0);
        boolean hasTower13 = false;
        if (rc.canSenseLocation(mloc13)) {
            RobotInfo r13 = rc.senseRobotAtLocation(mloc13);
            if ( r13 != null &&  r13.team != rc.getTeam() && Globals.isTower(r13.type)) {
                hasTower13 = true;
            }
        }
        
        MapLocation mloc14 = new MapLocation(x + -2, y + 1);
        boolean hasTower14 = false;
        if (rc.canSenseLocation(mloc14)) {
            RobotInfo r14 = rc.senseRobotAtLocation(mloc14);
            if ( r14 != null &&  r14.team != rc.getTeam() && Globals.isTower(r14.type)) {
                hasTower14 = true;
            }
        }
        
        MapLocation mloc15 = new MapLocation(x + -2, y + 2);
        boolean hasTower15 = false;
        if (rc.canSenseLocation(mloc15)) {
            RobotInfo r15 = rc.senseRobotAtLocation(mloc15);
            if ( r15 != null &&  r15.team != rc.getTeam() && Globals.isTower(r15.type)) {
                hasTower15 = true;
            }
        }
        
        MapLocation mloc16 = new MapLocation(x + -2, y + 3);
        boolean hasTower16 = false;
        if (rc.canSenseLocation(mloc16)) {
            RobotInfo r16 = rc.senseRobotAtLocation(mloc16);
            if ( r16 != null &&  r16.team != rc.getTeam() && Globals.isTower(r16.type)) {
                hasTower16 = true;
            }
        }
        
        
        
        MapLocation mloc20 = new MapLocation(x + -1, y + -3);
        boolean hasTower20 = false;
        if (rc.canSenseLocation(mloc20)) {
            RobotInfo r20 = rc.senseRobotAtLocation(mloc20);
            if ( r20 != null &&  r20.team != rc.getTeam() && Globals.isTower(r20.type)) {
                hasTower20 = true;
            }
        }
        
        MapLocation mloc21 = new MapLocation(x + -1, y + -2);
        boolean hasTower21 = false;
        if (rc.canSenseLocation(mloc21)) {
            RobotInfo r21 = rc.senseRobotAtLocation(mloc21);
            if ( r21 != null &&  r21.team != rc.getTeam() && Globals.isTower(r21.type)) {
                hasTower21 = true;
            }
        }
        
        MapLocation mloc22 = new MapLocation(x + -1, y + -1);
        boolean hasTower22 = false;
        if (rc.canSenseLocation(mloc22)) {
            RobotInfo r22 = rc.senseRobotAtLocation(mloc22);
            if ( r22 != null &&  r22.team != rc.getTeam() && Globals.isTower(r22.type)) {
                hasTower22 = true;
            }
        }
        
        MapLocation mloc23 = new MapLocation(x + -1, y + 0);
        boolean hasTower23 = false;
        if (rc.canSenseLocation(mloc23)) {
            RobotInfo r23 = rc.senseRobotAtLocation(mloc23);
            if ( r23 != null &&  r23.team != rc.getTeam() && Globals.isTower(r23.type)) {
                hasTower23 = true;
            }
        }
        
        MapLocation mloc24 = new MapLocation(x + -1, y + 1);
        boolean hasTower24 = false;
        if (rc.canSenseLocation(mloc24)) {
            RobotInfo r24 = rc.senseRobotAtLocation(mloc24);
            if ( r24 != null &&  r24.team != rc.getTeam() && Globals.isTower(r24.type)) {
                hasTower24 = true;
            }
        }
        
        MapLocation mloc25 = new MapLocation(x + -1, y + 2);
        boolean hasTower25 = false;
        if (rc.canSenseLocation(mloc25)) {
            RobotInfo r25 = rc.senseRobotAtLocation(mloc25);
            if ( r25 != null &&  r25.team != rc.getTeam() && Globals.isTower(r25.type)) {
                hasTower25 = true;
            }
        }
        
        MapLocation mloc26 = new MapLocation(x + -1, y + 3);
        boolean hasTower26 = false;
        if (rc.canSenseLocation(mloc26)) {
            RobotInfo r26 = rc.senseRobotAtLocation(mloc26);
            if ( r26 != null &&  r26.team != rc.getTeam() && Globals.isTower(r26.type)) {
                hasTower26 = true;
            }
        }
        
        
        
        MapLocation mloc30 = new MapLocation(x + 0, y + -3);
        boolean hasTower30 = false;
        if (rc.canSenseLocation(mloc30)) {
            RobotInfo r30 = rc.senseRobotAtLocation(mloc30);
            if ( r30 != null &&  r30.team != rc.getTeam() && Globals.isTower(r30.type)) {
                hasTower30 = true;
            }
        }
        
        MapLocation mloc31 = new MapLocation(x + 0, y + -2);
        boolean hasTower31 = false;
        if (rc.canSenseLocation(mloc31)) {
            RobotInfo r31 = rc.senseRobotAtLocation(mloc31);
            if ( r31 != null &&  r31.team != rc.getTeam() && Globals.isTower(r31.type)) {
                hasTower31 = true;
            }
        }
        
        MapLocation mloc32 = new MapLocation(x + 0, y + -1);
        boolean hasTower32 = false;
        if (rc.canSenseLocation(mloc32)) {
            RobotInfo r32 = rc.senseRobotAtLocation(mloc32);
            if ( r32 != null &&  r32.team != rc.getTeam() && Globals.isTower(r32.type)) {
                hasTower32 = true;
            }
        }
        
        MapLocation mloc33 = new MapLocation(x + 0, y + 0);
        boolean hasTower33 = false;
        if (rc.canSenseLocation(mloc33)) {
            RobotInfo r33 = rc.senseRobotAtLocation(mloc33);
            if ( r33 != null &&  r33.team != rc.getTeam() && Globals.isTower(r33.type)) {
                hasTower33 = true;
            }
        }
        
        MapLocation mloc34 = new MapLocation(x + 0, y + 1);
        boolean hasTower34 = false;
        if (rc.canSenseLocation(mloc34)) {
            RobotInfo r34 = rc.senseRobotAtLocation(mloc34);
            if ( r34 != null &&  r34.team != rc.getTeam() && Globals.isTower(r34.type)) {
                hasTower34 = true;
            }
        }
        
        MapLocation mloc35 = new MapLocation(x + 0, y + 2);
        boolean hasTower35 = false;
        if (rc.canSenseLocation(mloc35)) {
            RobotInfo r35 = rc.senseRobotAtLocation(mloc35);
            if ( r35 != null &&  r35.team != rc.getTeam() && Globals.isTower(r35.type)) {
                hasTower35 = true;
            }
        }
        
        MapLocation mloc36 = new MapLocation(x + 0, y + 3);
        boolean hasTower36 = false;
        if (rc.canSenseLocation(mloc36)) {
            RobotInfo r36 = rc.senseRobotAtLocation(mloc36);
            if ( r36 != null &&  r36.team != rc.getTeam() && Globals.isTower(r36.type)) {
                hasTower36 = true;
            }
        }
        
        
        
        MapLocation mloc40 = new MapLocation(x + 1, y + -3);
        boolean hasTower40 = false;
        if (rc.canSenseLocation(mloc40)) {
            RobotInfo r40 = rc.senseRobotAtLocation(mloc40);
            if ( r40 != null &&  r40.team != rc.getTeam() && Globals.isTower(r40.type)) {
                hasTower40 = true;
            }
        }
        
        MapLocation mloc41 = new MapLocation(x + 1, y + -2);
        boolean hasTower41 = false;
        if (rc.canSenseLocation(mloc41)) {
            RobotInfo r41 = rc.senseRobotAtLocation(mloc41);
            if ( r41 != null &&  r41.team != rc.getTeam() && Globals.isTower(r41.type)) {
                hasTower41 = true;
            }
        }
        
        MapLocation mloc42 = new MapLocation(x + 1, y + -1);
        boolean hasTower42 = false;
        if (rc.canSenseLocation(mloc42)) {
            RobotInfo r42 = rc.senseRobotAtLocation(mloc42);
            if ( r42 != null &&  r42.team != rc.getTeam() && Globals.isTower(r42.type)) {
                hasTower42 = true;
            }
        }
        
        MapLocation mloc43 = new MapLocation(x + 1, y + 0);
        boolean hasTower43 = false;
        if (rc.canSenseLocation(mloc43)) {
            RobotInfo r43 = rc.senseRobotAtLocation(mloc43);
            if ( r43 != null &&  r43.team != rc.getTeam() && Globals.isTower(r43.type)) {
                hasTower43 = true;
            }
        }
        
        MapLocation mloc44 = new MapLocation(x + 1, y + 1);
        boolean hasTower44 = false;
        if (rc.canSenseLocation(mloc44)) {
            RobotInfo r44 = rc.senseRobotAtLocation(mloc44);
            if ( r44 != null &&  r44.team != rc.getTeam() && Globals.isTower(r44.type)) {
                hasTower44 = true;
            }
        }
        
        MapLocation mloc45 = new MapLocation(x + 1, y + 2);
        boolean hasTower45 = false;
        if (rc.canSenseLocation(mloc45)) {
            RobotInfo r45 = rc.senseRobotAtLocation(mloc45);
            if ( r45 != null &&  r45.team != rc.getTeam() && Globals.isTower(r45.type)) {
                hasTower45 = true;
            }
        }
        
        MapLocation mloc46 = new MapLocation(x + 1, y + 3);
        boolean hasTower46 = false;
        if (rc.canSenseLocation(mloc46)) {
            RobotInfo r46 = rc.senseRobotAtLocation(mloc46);
            if ( r46 != null &&  r46.team != rc.getTeam() && Globals.isTower(r46.type)) {
                hasTower46 = true;
            }
        }
        
        
        
        MapLocation mloc50 = new MapLocation(x + 2, y + -3);
        boolean hasTower50 = false;
        if (rc.canSenseLocation(mloc50)) {
            RobotInfo r50 = rc.senseRobotAtLocation(mloc50);
            if ( r50 != null &&  r50.team != rc.getTeam() && Globals.isTower(r50.type)) {
                hasTower50 = true;
            }
        }
        
        MapLocation mloc51 = new MapLocation(x + 2, y + -2);
        boolean hasTower51 = false;
        if (rc.canSenseLocation(mloc51)) {
            RobotInfo r51 = rc.senseRobotAtLocation(mloc51);
            if ( r51 != null &&  r51.team != rc.getTeam() && Globals.isTower(r51.type)) {
                hasTower51 = true;
            }
        }
        
        MapLocation mloc52 = new MapLocation(x + 2, y + -1);
        boolean hasTower52 = false;
        if (rc.canSenseLocation(mloc52)) {
            RobotInfo r52 = rc.senseRobotAtLocation(mloc52);
            if ( r52 != null &&  r52.team != rc.getTeam() && Globals.isTower(r52.type)) {
                hasTower52 = true;
            }
        }
        
        MapLocation mloc53 = new MapLocation(x + 2, y + 0);
        boolean hasTower53 = false;
        if (rc.canSenseLocation(mloc53)) {
            RobotInfo r53 = rc.senseRobotAtLocation(mloc53);
            if ( r53 != null &&  r53.team != rc.getTeam() && Globals.isTower(r53.type)) {
                hasTower53 = true;
            }
        }
        
        MapLocation mloc54 = new MapLocation(x + 2, y + 1);
        boolean hasTower54 = false;
        if (rc.canSenseLocation(mloc54)) {
            RobotInfo r54 = rc.senseRobotAtLocation(mloc54);
            if ( r54 != null &&  r54.team != rc.getTeam() && Globals.isTower(r54.type)) {
                hasTower54 = true;
            }
        }
        
        MapLocation mloc55 = new MapLocation(x + 2, y + 2);
        boolean hasTower55 = false;
        if (rc.canSenseLocation(mloc55)) {
            RobotInfo r55 = rc.senseRobotAtLocation(mloc55);
            if ( r55 != null &&  r55.team != rc.getTeam() && Globals.isTower(r55.type)) {
                hasTower55 = true;
            }
        }
        
        MapLocation mloc56 = new MapLocation(x + 2, y + 3);
        boolean hasTower56 = false;
        if (rc.canSenseLocation(mloc56)) {
            RobotInfo r56 = rc.senseRobotAtLocation(mloc56);
            if ( r56 != null &&  r56.team != rc.getTeam() && Globals.isTower(r56.type)) {
                hasTower56 = true;
            }
        }
        
        
        
        MapLocation mloc60 = new MapLocation(x + 3, y + -3);
        boolean hasTower60 = false;
        if (rc.canSenseLocation(mloc60)) {
            RobotInfo r60 = rc.senseRobotAtLocation(mloc60);
            if ( r60 != null &&  r60.team != rc.getTeam() && Globals.isTower(r60.type)) {
                hasTower60 = true;
            }
        }
        
        MapLocation mloc61 = new MapLocation(x + 3, y + -2);
        boolean hasTower61 = false;
        if (rc.canSenseLocation(mloc61)) {
            RobotInfo r61 = rc.senseRobotAtLocation(mloc61);
            if ( r61 != null &&  r61.team != rc.getTeam() && Globals.isTower(r61.type)) {
                hasTower61 = true;
            }
        }
        
        MapLocation mloc62 = new MapLocation(x + 3, y + -1);
        boolean hasTower62 = false;
        if (rc.canSenseLocation(mloc62)) {
            RobotInfo r62 = rc.senseRobotAtLocation(mloc62);
            if ( r62 != null &&  r62.team != rc.getTeam() && Globals.isTower(r62.type)) {
                hasTower62 = true;
            }
        }
        
        MapLocation mloc63 = new MapLocation(x + 3, y + 0);
        boolean hasTower63 = false;
        if (rc.canSenseLocation(mloc63)) {
            RobotInfo r63 = rc.senseRobotAtLocation(mloc63);
            if ( r63 != null &&  r63.team != rc.getTeam() && Globals.isTower(r63.type)) {
                hasTower63 = true;
            }
        }
        
        MapLocation mloc64 = new MapLocation(x + 3, y + 1);
        boolean hasTower64 = false;
        if (rc.canSenseLocation(mloc64)) {
            RobotInfo r64 = rc.senseRobotAtLocation(mloc64);
            if ( r64 != null &&  r64.team != rc.getTeam() && Globals.isTower(r64.type)) {
                hasTower64 = true;
            }
        }
        
        MapLocation mloc65 = new MapLocation(x + 3, y + 2);
        boolean hasTower65 = false;
        if (rc.canSenseLocation(mloc65)) {
            RobotInfo r65 = rc.senseRobotAtLocation(mloc65);
            if ( r65 != null &&  r65.team != rc.getTeam() && Globals.isTower(r65.type)) {
                hasTower65 = true;
            }
        }
        
        MapLocation mloc66 = new MapLocation(x + 3, y + 3);
        boolean hasTower66 = false;
        if (rc.canSenseLocation(mloc66)) {
            RobotInfo r66 = rc.senseRobotAtLocation(mloc66);
            if ( r66 != null &&  r66.team != rc.getTeam() && Globals.isTower(r66.type)) {
                hasTower66 = true;
            }
        }
        
        

        
        
        if (rc.canAttack(mloc11)) {
            count = 0;
            
             
            if (hasTower00) ++count;
             
            if (hasTower01) ++count;
             
            if (hasTower02) ++count;
            
            
             
            if (hasTower10) ++count;
             
            if (hasTower11) ++count;
             
            if (hasTower12) ++count;
            
            
             
            if (hasTower20) ++count;
             
            if (hasTower21) ++count;
             
            if (hasTower22) ++count;
            
            
            if (count > bestCount) {
                bestLoc = mloc11;
                bestCount = count;
            }
        }
        
        if (rc.canAttack(mloc12)) {
            count = 0;
            
             
            if (hasTower01) ++count;
             
            if (hasTower02) ++count;
             
            if (hasTower03) ++count;
            
            
             
            if (hasTower11) ++count;
             
            if (hasTower12) ++count;
             
            if (hasTower13) ++count;
            
            
             
            if (hasTower21) ++count;
             
            if (hasTower22) ++count;
             
            if (hasTower23) ++count;
            
            
            if (count > bestCount) {
                bestLoc = mloc12;
                bestCount = count;
            }
        }
        
        if (rc.canAttack(mloc13)) {
            count = 0;
            
             
            if (hasTower02) ++count;
             
            if (hasTower03) ++count;
             
            if (hasTower04) ++count;
            
            
             
            if (hasTower12) ++count;
             
            if (hasTower13) ++count;
             
            if (hasTower14) ++count;
            
            
             
            if (hasTower22) ++count;
             
            if (hasTower23) ++count;
             
            if (hasTower24) ++count;
            
            
            if (count > bestCount) {
                bestLoc = mloc13;
                bestCount = count;
            }
        }
        
        if (rc.canAttack(mloc14)) {
            count = 0;
            
             
            if (hasTower03) ++count;
             
            if (hasTower04) ++count;
             
            if (hasTower05) ++count;
            
            
             
            if (hasTower13) ++count;
             
            if (hasTower14) ++count;
             
            if (hasTower15) ++count;
            
            
             
            if (hasTower23) ++count;
             
            if (hasTower24) ++count;
             
            if (hasTower25) ++count;
            
            
            if (count > bestCount) {
                bestLoc = mloc14;
                bestCount = count;
            }
        }
        
        if (rc.canAttack(mloc15)) {
            count = 0;
            
             
            if (hasTower04) ++count;
             
            if (hasTower05) ++count;
             
            if (hasTower06) ++count;
            
            
             
            if (hasTower14) ++count;
             
            if (hasTower15) ++count;
             
            if (hasTower16) ++count;
            
            
             
            if (hasTower24) ++count;
             
            if (hasTower25) ++count;
             
            if (hasTower26) ++count;
            
            
            if (count > bestCount) {
                bestLoc = mloc15;
                bestCount = count;
            }
        }
        
        
        
        if (rc.canAttack(mloc21)) {
            count = 0;
            
             
            if (hasTower10) ++count;
             
            if (hasTower11) ++count;
             
            if (hasTower12) ++count;
            
            
             
            if (hasTower20) ++count;
             
            if (hasTower21) ++count;
             
            if (hasTower22) ++count;
            
            
             
            if (hasTower30) ++count;
             
            if (hasTower31) ++count;
             
            if (hasTower32) ++count;
            
            
            if (count > bestCount) {
                bestLoc = mloc21;
                bestCount = count;
            }
        }
        
        if (rc.canAttack(mloc22)) {
            count = 0;
            
             
            if (hasTower11) ++count;
             
            if (hasTower12) ++count;
             
            if (hasTower13) ++count;
            
            
             
            if (hasTower21) ++count;
             
            if (hasTower22) ++count;
             
            if (hasTower23) ++count;
            
            
             
            if (hasTower31) ++count;
             
            if (hasTower32) ++count;
             
            if (hasTower33) ++count;
            
            
            if (count > bestCount) {
                bestLoc = mloc22;
                bestCount = count;
            }
        }
        
        if (rc.canAttack(mloc23)) {
            count = 0;
            
             
            if (hasTower12) ++count;
             
            if (hasTower13) ++count;
             
            if (hasTower14) ++count;
            
            
             
            if (hasTower22) ++count;
             
            if (hasTower23) ++count;
             
            if (hasTower24) ++count;
            
            
             
            if (hasTower32) ++count;
             
            if (hasTower33) ++count;
             
            if (hasTower34) ++count;
            
            
            if (count > bestCount) {
                bestLoc = mloc23;
                bestCount = count;
            }
        }
        
        if (rc.canAttack(mloc24)) {
            count = 0;
            
             
            if (hasTower13) ++count;
             
            if (hasTower14) ++count;
             
            if (hasTower15) ++count;
            
            
             
            if (hasTower23) ++count;
             
            if (hasTower24) ++count;
             
            if (hasTower25) ++count;
            
            
             
            if (hasTower33) ++count;
             
            if (hasTower34) ++count;
             
            if (hasTower35) ++count;
            
            
            if (count > bestCount) {
                bestLoc = mloc24;
                bestCount = count;
            }
        }
        
        if (rc.canAttack(mloc25)) {
            count = 0;
            
             
            if (hasTower14) ++count;
             
            if (hasTower15) ++count;
             
            if (hasTower16) ++count;
            
            
             
            if (hasTower24) ++count;
             
            if (hasTower25) ++count;
             
            if (hasTower26) ++count;
            
            
             
            if (hasTower34) ++count;
             
            if (hasTower35) ++count;
             
            if (hasTower36) ++count;
            
            
            if (count > bestCount) {
                bestLoc = mloc25;
                bestCount = count;
            }
        }
        
        
        
        if (rc.canAttack(mloc31)) {
            count = 0;
            
             
            if (hasTower20) ++count;
             
            if (hasTower21) ++count;
             
            if (hasTower22) ++count;
            
            
             
            if (hasTower30) ++count;
             
            if (hasTower31) ++count;
             
            if (hasTower32) ++count;
            
            
             
            if (hasTower40) ++count;
             
            if (hasTower41) ++count;
             
            if (hasTower42) ++count;
            
            
            if (count > bestCount) {
                bestLoc = mloc31;
                bestCount = count;
            }
        }
        
        if (rc.canAttack(mloc32)) {
            count = 0;
            
             
            if (hasTower21) ++count;
             
            if (hasTower22) ++count;
             
            if (hasTower23) ++count;
            
            
             
            if (hasTower31) ++count;
             
            if (hasTower32) ++count;
             
            if (hasTower33) ++count;
            
            
             
            if (hasTower41) ++count;
             
            if (hasTower42) ++count;
             
            if (hasTower43) ++count;
            
            
            if (count > bestCount) {
                bestLoc = mloc32;
                bestCount = count;
            }
        }
        
        if (rc.canAttack(mloc33)) {
            count = 0;
            
             
            if (hasTower22) ++count;
             
            if (hasTower23) ++count;
             
            if (hasTower24) ++count;
            
            
             
            if (hasTower32) ++count;
             
            if (hasTower33) ++count;
             
            if (hasTower34) ++count;
            
            
             
            if (hasTower42) ++count;
             
            if (hasTower43) ++count;
             
            if (hasTower44) ++count;
            
            
            if (count > bestCount) {
                bestLoc = mloc33;
                bestCount = count;
            }
        }
        
        if (rc.canAttack(mloc34)) {
            count = 0;
            
             
            if (hasTower23) ++count;
             
            if (hasTower24) ++count;
             
            if (hasTower25) ++count;
            
            
             
            if (hasTower33) ++count;
             
            if (hasTower34) ++count;
             
            if (hasTower35) ++count;
            
            
             
            if (hasTower43) ++count;
             
            if (hasTower44) ++count;
             
            if (hasTower45) ++count;
            
            
            if (count > bestCount) {
                bestLoc = mloc34;
                bestCount = count;
            }
        }
        
        if (rc.canAttack(mloc35)) {
            count = 0;
            
             
            if (hasTower24) ++count;
             
            if (hasTower25) ++count;
             
            if (hasTower26) ++count;
            
            
             
            if (hasTower34) ++count;
             
            if (hasTower35) ++count;
             
            if (hasTower36) ++count;
            
            
             
            if (hasTower44) ++count;
             
            if (hasTower45) ++count;
             
            if (hasTower46) ++count;
            
            
            if (count > bestCount) {
                bestLoc = mloc35;
                bestCount = count;
            }
        }
        
        
        
        if (rc.canAttack(mloc41)) {
            count = 0;
            
             
            if (hasTower30) ++count;
             
            if (hasTower31) ++count;
             
            if (hasTower32) ++count;
            
            
             
            if (hasTower40) ++count;
             
            if (hasTower41) ++count;
             
            if (hasTower42) ++count;
            
            
             
            if (hasTower50) ++count;
             
            if (hasTower51) ++count;
             
            if (hasTower52) ++count;
            
            
            if (count > bestCount) {
                bestLoc = mloc41;
                bestCount = count;
            }
        }
        
        if (rc.canAttack(mloc42)) {
            count = 0;
            
             
            if (hasTower31) ++count;
             
            if (hasTower32) ++count;
             
            if (hasTower33) ++count;
            
            
             
            if (hasTower41) ++count;
             
            if (hasTower42) ++count;
             
            if (hasTower43) ++count;
            
            
             
            if (hasTower51) ++count;
             
            if (hasTower52) ++count;
             
            if (hasTower53) ++count;
            
            
            if (count > bestCount) {
                bestLoc = mloc42;
                bestCount = count;
            }
        }
        
        if (rc.canAttack(mloc43)) {
            count = 0;
            
             
            if (hasTower32) ++count;
             
            if (hasTower33) ++count;
             
            if (hasTower34) ++count;
            
            
             
            if (hasTower42) ++count;
             
            if (hasTower43) ++count;
             
            if (hasTower44) ++count;
            
            
             
            if (hasTower52) ++count;
             
            if (hasTower53) ++count;
             
            if (hasTower54) ++count;
            
            
            if (count > bestCount) {
                bestLoc = mloc43;
                bestCount = count;
            }
        }
        
        if (rc.canAttack(mloc44)) {
            count = 0;
            
             
            if (hasTower33) ++count;
             
            if (hasTower34) ++count;
             
            if (hasTower35) ++count;
            
            
             
            if (hasTower43) ++count;
             
            if (hasTower44) ++count;
             
            if (hasTower45) ++count;
            
            
             
            if (hasTower53) ++count;
             
            if (hasTower54) ++count;
             
            if (hasTower55) ++count;
            
            
            if (count > bestCount) {
                bestLoc = mloc44;
                bestCount = count;
            }
        }
        
        if (rc.canAttack(mloc45)) {
            count = 0;
            
             
            if (hasTower34) ++count;
             
            if (hasTower35) ++count;
             
            if (hasTower36) ++count;
            
            
             
            if (hasTower44) ++count;
             
            if (hasTower45) ++count;
             
            if (hasTower46) ++count;
            
            
             
            if (hasTower54) ++count;
             
            if (hasTower55) ++count;
             
            if (hasTower56) ++count;
            
            
            if (count > bestCount) {
                bestLoc = mloc45;
                bestCount = count;
            }
        }
        
        
        
        if (rc.canAttack(mloc51)) {
            count = 0;
            
             
            if (hasTower40) ++count;
             
            if (hasTower41) ++count;
             
            if (hasTower42) ++count;
            
            
             
            if (hasTower50) ++count;
             
            if (hasTower51) ++count;
             
            if (hasTower52) ++count;
            
            
             
            if (hasTower60) ++count;
             
            if (hasTower61) ++count;
             
            if (hasTower62) ++count;
            
            
            if (count > bestCount) {
                bestLoc = mloc51;
                bestCount = count;
            }
        }
        
        if (rc.canAttack(mloc52)) {
            count = 0;
            
             
            if (hasTower41) ++count;
             
            if (hasTower42) ++count;
             
            if (hasTower43) ++count;
            
            
             
            if (hasTower51) ++count;
             
            if (hasTower52) ++count;
             
            if (hasTower53) ++count;
            
            
             
            if (hasTower61) ++count;
             
            if (hasTower62) ++count;
             
            if (hasTower63) ++count;
            
            
            if (count > bestCount) {
                bestLoc = mloc52;
                bestCount = count;
            }
        }
        
        if (rc.canAttack(mloc53)) {
            count = 0;
            
             
            if (hasTower42) ++count;
             
            if (hasTower43) ++count;
             
            if (hasTower44) ++count;
            
            
             
            if (hasTower52) ++count;
             
            if (hasTower53) ++count;
             
            if (hasTower54) ++count;
            
            
             
            if (hasTower62) ++count;
             
            if (hasTower63) ++count;
             
            if (hasTower64) ++count;
            
            
            if (count > bestCount) {
                bestLoc = mloc53;
                bestCount = count;
            }
        }
        
        if (rc.canAttack(mloc54)) {
            count = 0;
            
             
            if (hasTower43) ++count;
             
            if (hasTower44) ++count;
             
            if (hasTower45) ++count;
            
            
             
            if (hasTower53) ++count;
             
            if (hasTower54) ++count;
             
            if (hasTower55) ++count;
            
            
             
            if (hasTower63) ++count;
             
            if (hasTower64) ++count;
             
            if (hasTower65) ++count;
            
            
            if (count > bestCount) {
                bestLoc = mloc54;
                bestCount = count;
            }
        }
        
        if (rc.canAttack(mloc55)) {
            count = 0;
            
             
            if (hasTower44) ++count;
             
            if (hasTower45) ++count;
             
            if (hasTower46) ++count;
            
            
             
            if (hasTower54) ++count;
             
            if (hasTower55) ++count;
             
            if (hasTower56) ++count;
            
            
             
            if (hasTower64) ++count;
             
            if (hasTower65) ++count;
             
            if (hasTower66) ++count;
            
            
            if (count > bestCount) {
                bestLoc = mloc55;
                bestCount = count;
            }
        }
        
        

        if (bestCount >= 1) {
            rc.attack(bestLoc);
        }
    }
    
    /*------------------ CHOOSE BEST --------------------*//* ################## CHOOSE BEST #################### */


    /*------------------ ADD ALLY --------------------*//* ################## ADD ALLY #################### */

    /*------------------ ADD ENEMY --------------------*/
    
    /* ################## ADD ENEMY #################### */

    /*------------------ INIT TARGET --------------------*//* ################## INIT TARGET #################### */
    
    /*------------------ COPY --------------------*/
    /* ################## COPY #################### */

    
    public static void soldierAttackMicro() throws GameActionException {
        soldierTryAttack();
        MapLocation myloc = rc.getLocation();
        SquareManager.computePaintPenalties();
        MapLocation targetLoc_N = SquareManager.m23;
        boolean canMove_N = (rc.canMove(Direction.NORTH));
        double healthDmgAttackRange_N = 0;
        double myHealthDmg_N = 0;
        int minDistToEnemy_N = 100000;
        int penalty_N = SquareManager.penalty23;
        int towerHealth_N = 1000000;
        boolean canBeHit_N = false;
        boolean canLandHit_N = false;
        
        MapLocation targetLoc_NE = SquareManager.m33;
        boolean canMove_NE = (rc.canMove(Direction.NORTHEAST));
        double healthDmgAttackRange_NE = 0;
        double myHealthDmg_NE = 0;
        int minDistToEnemy_NE = 100000;
        int penalty_NE = SquareManager.penalty33;
        int towerHealth_NE = 1000000;
        boolean canBeHit_NE = false;
        boolean canLandHit_NE = false;
        
        MapLocation targetLoc_E = SquareManager.m32;
        boolean canMove_E = (rc.canMove(Direction.EAST));
        double healthDmgAttackRange_E = 0;
        double myHealthDmg_E = 0;
        int minDistToEnemy_E = 100000;
        int penalty_E = SquareManager.penalty32;
        int towerHealth_E = 1000000;
        boolean canBeHit_E = false;
        boolean canLandHit_E = false;
        
        MapLocation targetLoc_SE = SquareManager.m31;
        boolean canMove_SE = (rc.canMove(Direction.SOUTHEAST));
        double healthDmgAttackRange_SE = 0;
        double myHealthDmg_SE = 0;
        int minDistToEnemy_SE = 100000;
        int penalty_SE = SquareManager.penalty31;
        int towerHealth_SE = 1000000;
        boolean canBeHit_SE = false;
        boolean canLandHit_SE = false;
        
        MapLocation targetLoc_S = SquareManager.m21;
        boolean canMove_S = (rc.canMove(Direction.SOUTH));
        double healthDmgAttackRange_S = 0;
        double myHealthDmg_S = 0;
        int minDistToEnemy_S = 100000;
        int penalty_S = SquareManager.penalty21;
        int towerHealth_S = 1000000;
        boolean canBeHit_S = false;
        boolean canLandHit_S = false;
        
        MapLocation targetLoc_SW = SquareManager.m11;
        boolean canMove_SW = (rc.canMove(Direction.SOUTHWEST));
        double healthDmgAttackRange_SW = 0;
        double myHealthDmg_SW = 0;
        int minDistToEnemy_SW = 100000;
        int penalty_SW = SquareManager.penalty11;
        int towerHealth_SW = 1000000;
        boolean canBeHit_SW = false;
        boolean canLandHit_SW = false;
        
        MapLocation targetLoc_W = SquareManager.m12;
        boolean canMove_W = (rc.canMove(Direction.WEST));
        double healthDmgAttackRange_W = 0;
        double myHealthDmg_W = 0;
        int minDistToEnemy_W = 100000;
        int penalty_W = SquareManager.penalty12;
        int towerHealth_W = 1000000;
        boolean canBeHit_W = false;
        boolean canLandHit_W = false;
        
        MapLocation targetLoc_NW = SquareManager.m13;
        boolean canMove_NW = (rc.canMove(Direction.NORTHWEST));
        double healthDmgAttackRange_NW = 0;
        double myHealthDmg_NW = 0;
        int minDistToEnemy_NW = 100000;
        int penalty_NW = SquareManager.penalty13;
        int towerHealth_NW = 1000000;
        boolean canBeHit_NW = false;
        boolean canLandHit_NW = false;
        
        MapLocation targetLoc_C = SquareManager.m22;
        boolean canMove_C = (true);
        double healthDmgAttackRange_C = 0;
        double myHealthDmg_C = 0;
        int minDistToEnemy_C = 100000;
        int penalty_C = SquareManager.penalty22;
        int towerHealth_C = 1000000;
        boolean canBeHit_C = false;
        boolean canLandHit_C = false;
        
        boolean friendNearby = false;
        for (RobotInfo r: Globals.friends) {
            if (r.type == UnitType.SOLDIER) {
                friendNearby = true;
                break;
            }
        }
        boolean shouldWaitForFriend = (friendNearby && (rc.getRoundNum() % 2 == 0));

        // Use GameConstant.
        boolean actionReady = (rc.isActionReady() && (rc.getPaint() >= 5) && !shouldWaitForFriend);
        int cooldownTurns = rc.getActionCooldownTurns();
        
        for (int i = Globals.friends.length; --i >= 0; ) {
            RobotInfo robot = Globals.friends[i];
            addAlly0N: {
                
            }
            addAlly0NE: {
                
            }
            addAlly0E: {
                
            }
            addAlly0SE: {
                
            }
            addAlly0S: {
                
            }
            addAlly0SW: {
                
            }
            addAlly0W: {
                
            }
            addAlly0NW: {
                
            }
            addAlly0C: {
                
            }
            
        }

        for (int i = Globals.enemies.length; --i >= 0; ) {
            RobotInfo robot = Globals.enemies[i];
            
            addEnemy0N: {
                if (!canMove_N) break addEnemy0N;
                int d = targetLoc_N.distanceSquaredTo(robot.location);
                switch (robot.type) {
                    case MOPPER: {
                        // Expected Paint taken.
                        if (d <= UnitType.MOPPER.actionRadiusSquared) {
                            penalty_N += 3.3;
                        } else if (d <= 8) {
                            penalty_N += 2.5;
                        }
                        break addEnemy0N;
                    }
                    case LEVEL_ONE_DEFENSE_TOWER: {
                        if (actionReady && d <= soldierActionRadiusSquared) {
                            
                            myHealthDmg_N = soldierAttackStrength;
                            
                            towerHealth_N = Math.min(towerHealth_N, robot.health);
                            canLandHit_N = true;
                        }
                        if (d <= UnitType.LEVEL_ONE_DEFENSE_TOWER.actionRadiusSquared) {
                            // Should have another one for AOE damage.
                            healthDmgAttackRange_N += UnitType.LEVEL_ONE_DEFENSE_TOWER.attackStrength;
                            canBeHit_N = true;
                        }

                        if (d < minDistToEnemy_N) minDistToEnemy_N = d;
                        break addEnemy0N;
                    }
                    case LEVEL_ONE_MONEY_TOWER: {
                        if (actionReady && d <= soldierActionRadiusSquared) {
                            
                            myHealthDmg_N = soldierAttackStrength;
                            
                            towerHealth_N = Math.min(towerHealth_N, robot.health);
                            canLandHit_N = true;
                        }
                        if (d <= UnitType.LEVEL_ONE_MONEY_TOWER.actionRadiusSquared) {
                            // Should have another one for AOE damage.
                            healthDmgAttackRange_N += UnitType.LEVEL_ONE_MONEY_TOWER.attackStrength;
                            canBeHit_N = true;
                        }

                        if (d < minDistToEnemy_N) minDistToEnemy_N = d;
                        break addEnemy0N;
                    }
                    case LEVEL_ONE_PAINT_TOWER: {
                        if (actionReady && d <= soldierActionRadiusSquared) {
                            
                            myHealthDmg_N = soldierAttackStrength;
                            
                            towerHealth_N = Math.min(towerHealth_N, robot.health);
                            canLandHit_N = true;
                        }
                        if (d <= UnitType.LEVEL_ONE_PAINT_TOWER.actionRadiusSquared) {
                            // Should have another one for AOE damage.
                            healthDmgAttackRange_N += UnitType.LEVEL_ONE_PAINT_TOWER.attackStrength;
                            canBeHit_N = true;
                        }

                        if (d < minDistToEnemy_N) minDistToEnemy_N = d;
                        break addEnemy0N;
                    }
                    case LEVEL_THREE_DEFENSE_TOWER: {
                        if (actionReady && d <= soldierActionRadiusSquared) {
                            
                            myHealthDmg_N = soldierAttackStrength;
                            
                            towerHealth_N = Math.min(towerHealth_N, robot.health);
                            canLandHit_N = true;
                        }
                        if (d <= UnitType.LEVEL_THREE_DEFENSE_TOWER.actionRadiusSquared) {
                            // Should have another one for AOE damage.
                            healthDmgAttackRange_N += UnitType.LEVEL_THREE_DEFENSE_TOWER.attackStrength;
                            canBeHit_N = true;
                        }

                        if (d < minDistToEnemy_N) minDistToEnemy_N = d;
                        break addEnemy0N;
                    }
                    case LEVEL_THREE_MONEY_TOWER: {
                        if (actionReady && d <= soldierActionRadiusSquared) {
                            
                            myHealthDmg_N = soldierAttackStrength;
                            
                            towerHealth_N = Math.min(towerHealth_N, robot.health);
                            canLandHit_N = true;
                        }
                        if (d <= UnitType.LEVEL_THREE_MONEY_TOWER.actionRadiusSquared) {
                            // Should have another one for AOE damage.
                            healthDmgAttackRange_N += UnitType.LEVEL_THREE_MONEY_TOWER.attackStrength;
                            canBeHit_N = true;
                        }

                        if (d < minDistToEnemy_N) minDistToEnemy_N = d;
                        break addEnemy0N;
                    }
                    case LEVEL_THREE_PAINT_TOWER: {
                        if (actionReady && d <= soldierActionRadiusSquared) {
                            
                            myHealthDmg_N = soldierAttackStrength;
                            
                            towerHealth_N = Math.min(towerHealth_N, robot.health);
                            canLandHit_N = true;
                        }
                        if (d <= UnitType.LEVEL_THREE_PAINT_TOWER.actionRadiusSquared) {
                            // Should have another one for AOE damage.
                            healthDmgAttackRange_N += UnitType.LEVEL_THREE_PAINT_TOWER.attackStrength;
                            canBeHit_N = true;
                        }

                        if (d < minDistToEnemy_N) minDistToEnemy_N = d;
                        break addEnemy0N;
                    }
                    case LEVEL_TWO_DEFENSE_TOWER: {
                        if (actionReady && d <= soldierActionRadiusSquared) {
                            
                            myHealthDmg_N = soldierAttackStrength;
                            
                            towerHealth_N = Math.min(towerHealth_N, robot.health);
                            canLandHit_N = true;
                        }
                        if (d <= UnitType.LEVEL_TWO_DEFENSE_TOWER.actionRadiusSquared) {
                            // Should have another one for AOE damage.
                            healthDmgAttackRange_N += UnitType.LEVEL_TWO_DEFENSE_TOWER.attackStrength;
                            canBeHit_N = true;
                        }

                        if (d < minDistToEnemy_N) minDistToEnemy_N = d;
                        break addEnemy0N;
                    }
                    case LEVEL_TWO_MONEY_TOWER: {
                        if (actionReady && d <= soldierActionRadiusSquared) {
                            
                            myHealthDmg_N = soldierAttackStrength;
                            
                            towerHealth_N = Math.min(towerHealth_N, robot.health);
                            canLandHit_N = true;
                        }
                        if (d <= UnitType.LEVEL_TWO_MONEY_TOWER.actionRadiusSquared) {
                            // Should have another one for AOE damage.
                            healthDmgAttackRange_N += UnitType.LEVEL_TWO_MONEY_TOWER.attackStrength;
                            canBeHit_N = true;
                        }

                        if (d < minDistToEnemy_N) minDistToEnemy_N = d;
                        break addEnemy0N;
                    }
                    case LEVEL_TWO_PAINT_TOWER: {
                        if (actionReady && d <= soldierActionRadiusSquared) {
                            
                            myHealthDmg_N = soldierAttackStrength;
                            
                            towerHealth_N = Math.min(towerHealth_N, robot.health);
                            canLandHit_N = true;
                        }
                        if (d <= UnitType.LEVEL_TWO_PAINT_TOWER.actionRadiusSquared) {
                            // Should have another one for AOE damage.
                            healthDmgAttackRange_N += UnitType.LEVEL_TWO_PAINT_TOWER.attackStrength;
                            canBeHit_N = true;
                        }

                        if (d < minDistToEnemy_N) minDistToEnemy_N = d;
                        break addEnemy0N;
                    }
                    
                    default: break addEnemy0N;
                }
            }
            
            addEnemy0NE: {
                if (!canMove_NE) break addEnemy0NE;
                int d = targetLoc_NE.distanceSquaredTo(robot.location);
                switch (robot.type) {
                    case MOPPER: {
                        // Expected Paint taken.
                        if (d <= UnitType.MOPPER.actionRadiusSquared) {
                            penalty_NE += 3.3;
                        } else if (d <= 8) {
                            penalty_NE += 2.5;
                        }
                        break addEnemy0NE;
                    }
                    case LEVEL_ONE_DEFENSE_TOWER: {
                        if (actionReady && d <= soldierActionRadiusSquared) {
                            
                            myHealthDmg_NE = soldierAttackStrength;
                            
                            towerHealth_NE = Math.min(towerHealth_NE, robot.health);
                            canLandHit_NE = true;
                        }
                        if (d <= UnitType.LEVEL_ONE_DEFENSE_TOWER.actionRadiusSquared) {
                            // Should have another one for AOE damage.
                            healthDmgAttackRange_NE += UnitType.LEVEL_ONE_DEFENSE_TOWER.attackStrength;
                            canBeHit_NE = true;
                        }

                        if (d < minDistToEnemy_NE) minDistToEnemy_NE = d;
                        break addEnemy0NE;
                    }
                    case LEVEL_ONE_MONEY_TOWER: {
                        if (actionReady && d <= soldierActionRadiusSquared) {
                            
                            myHealthDmg_NE = soldierAttackStrength;
                            
                            towerHealth_NE = Math.min(towerHealth_NE, robot.health);
                            canLandHit_NE = true;
                        }
                        if (d <= UnitType.LEVEL_ONE_MONEY_TOWER.actionRadiusSquared) {
                            // Should have another one for AOE damage.
                            healthDmgAttackRange_NE += UnitType.LEVEL_ONE_MONEY_TOWER.attackStrength;
                            canBeHit_NE = true;
                        }

                        if (d < minDistToEnemy_NE) minDistToEnemy_NE = d;
                        break addEnemy0NE;
                    }
                    case LEVEL_ONE_PAINT_TOWER: {
                        if (actionReady && d <= soldierActionRadiusSquared) {
                            
                            myHealthDmg_NE = soldierAttackStrength;
                            
                            towerHealth_NE = Math.min(towerHealth_NE, robot.health);
                            canLandHit_NE = true;
                        }
                        if (d <= UnitType.LEVEL_ONE_PAINT_TOWER.actionRadiusSquared) {
                            // Should have another one for AOE damage.
                            healthDmgAttackRange_NE += UnitType.LEVEL_ONE_PAINT_TOWER.attackStrength;
                            canBeHit_NE = true;
                        }

                        if (d < minDistToEnemy_NE) minDistToEnemy_NE = d;
                        break addEnemy0NE;
                    }
                    case LEVEL_THREE_DEFENSE_TOWER: {
                        if (actionReady && d <= soldierActionRadiusSquared) {
                            
                            myHealthDmg_NE = soldierAttackStrength;
                            
                            towerHealth_NE = Math.min(towerHealth_NE, robot.health);
                            canLandHit_NE = true;
                        }
                        if (d <= UnitType.LEVEL_THREE_DEFENSE_TOWER.actionRadiusSquared) {
                            // Should have another one for AOE damage.
                            healthDmgAttackRange_NE += UnitType.LEVEL_THREE_DEFENSE_TOWER.attackStrength;
                            canBeHit_NE = true;
                        }

                        if (d < minDistToEnemy_NE) minDistToEnemy_NE = d;
                        break addEnemy0NE;
                    }
                    case LEVEL_THREE_MONEY_TOWER: {
                        if (actionReady && d <= soldierActionRadiusSquared) {
                            
                            myHealthDmg_NE = soldierAttackStrength;
                            
                            towerHealth_NE = Math.min(towerHealth_NE, robot.health);
                            canLandHit_NE = true;
                        }
                        if (d <= UnitType.LEVEL_THREE_MONEY_TOWER.actionRadiusSquared) {
                            // Should have another one for AOE damage.
                            healthDmgAttackRange_NE += UnitType.LEVEL_THREE_MONEY_TOWER.attackStrength;
                            canBeHit_NE = true;
                        }

                        if (d < minDistToEnemy_NE) minDistToEnemy_NE = d;
                        break addEnemy0NE;
                    }
                    case LEVEL_THREE_PAINT_TOWER: {
                        if (actionReady && d <= soldierActionRadiusSquared) {
                            
                            myHealthDmg_NE = soldierAttackStrength;
                            
                            towerHealth_NE = Math.min(towerHealth_NE, robot.health);
                            canLandHit_NE = true;
                        }
                        if (d <= UnitType.LEVEL_THREE_PAINT_TOWER.actionRadiusSquared) {
                            // Should have another one for AOE damage.
                            healthDmgAttackRange_NE += UnitType.LEVEL_THREE_PAINT_TOWER.attackStrength;
                            canBeHit_NE = true;
                        }

                        if (d < minDistToEnemy_NE) minDistToEnemy_NE = d;
                        break addEnemy0NE;
                    }
                    case LEVEL_TWO_DEFENSE_TOWER: {
                        if (actionReady && d <= soldierActionRadiusSquared) {
                            
                            myHealthDmg_NE = soldierAttackStrength;
                            
                            towerHealth_NE = Math.min(towerHealth_NE, robot.health);
                            canLandHit_NE = true;
                        }
                        if (d <= UnitType.LEVEL_TWO_DEFENSE_TOWER.actionRadiusSquared) {
                            // Should have another one for AOE damage.
                            healthDmgAttackRange_NE += UnitType.LEVEL_TWO_DEFENSE_TOWER.attackStrength;
                            canBeHit_NE = true;
                        }

                        if (d < minDistToEnemy_NE) minDistToEnemy_NE = d;
                        break addEnemy0NE;
                    }
                    case LEVEL_TWO_MONEY_TOWER: {
                        if (actionReady && d <= soldierActionRadiusSquared) {
                            
                            myHealthDmg_NE = soldierAttackStrength;
                            
                            towerHealth_NE = Math.min(towerHealth_NE, robot.health);
                            canLandHit_NE = true;
                        }
                        if (d <= UnitType.LEVEL_TWO_MONEY_TOWER.actionRadiusSquared) {
                            // Should have another one for AOE damage.
                            healthDmgAttackRange_NE += UnitType.LEVEL_TWO_MONEY_TOWER.attackStrength;
                            canBeHit_NE = true;
                        }

                        if (d < minDistToEnemy_NE) minDistToEnemy_NE = d;
                        break addEnemy0NE;
                    }
                    case LEVEL_TWO_PAINT_TOWER: {
                        if (actionReady && d <= soldierActionRadiusSquared) {
                            
                            myHealthDmg_NE = soldierAttackStrength;
                            
                            towerHealth_NE = Math.min(towerHealth_NE, robot.health);
                            canLandHit_NE = true;
                        }
                        if (d <= UnitType.LEVEL_TWO_PAINT_TOWER.actionRadiusSquared) {
                            // Should have another one for AOE damage.
                            healthDmgAttackRange_NE += UnitType.LEVEL_TWO_PAINT_TOWER.attackStrength;
                            canBeHit_NE = true;
                        }

                        if (d < minDistToEnemy_NE) minDistToEnemy_NE = d;
                        break addEnemy0NE;
                    }
                    
                    default: break addEnemy0NE;
                }
            }
            
            addEnemy0E: {
                if (!canMove_E) break addEnemy0E;
                int d = targetLoc_E.distanceSquaredTo(robot.location);
                switch (robot.type) {
                    case MOPPER: {
                        // Expected Paint taken.
                        if (d <= UnitType.MOPPER.actionRadiusSquared) {
                            penalty_E += 3.3;
                        } else if (d <= 8) {
                            penalty_E += 2.5;
                        }
                        break addEnemy0E;
                    }
                    case LEVEL_ONE_DEFENSE_TOWER: {
                        if (actionReady && d <= soldierActionRadiusSquared) {
                            
                            myHealthDmg_E = soldierAttackStrength;
                            
                            towerHealth_E = Math.min(towerHealth_E, robot.health);
                            canLandHit_E = true;
                        }
                        if (d <= UnitType.LEVEL_ONE_DEFENSE_TOWER.actionRadiusSquared) {
                            // Should have another one for AOE damage.
                            healthDmgAttackRange_E += UnitType.LEVEL_ONE_DEFENSE_TOWER.attackStrength;
                            canBeHit_E = true;
                        }

                        if (d < minDistToEnemy_E) minDistToEnemy_E = d;
                        break addEnemy0E;
                    }
                    case LEVEL_ONE_MONEY_TOWER: {
                        if (actionReady && d <= soldierActionRadiusSquared) {
                            
                            myHealthDmg_E = soldierAttackStrength;
                            
                            towerHealth_E = Math.min(towerHealth_E, robot.health);
                            canLandHit_E = true;
                        }
                        if (d <= UnitType.LEVEL_ONE_MONEY_TOWER.actionRadiusSquared) {
                            // Should have another one for AOE damage.
                            healthDmgAttackRange_E += UnitType.LEVEL_ONE_MONEY_TOWER.attackStrength;
                            canBeHit_E = true;
                        }

                        if (d < minDistToEnemy_E) minDistToEnemy_E = d;
                        break addEnemy0E;
                    }
                    case LEVEL_ONE_PAINT_TOWER: {
                        if (actionReady && d <= soldierActionRadiusSquared) {
                            
                            myHealthDmg_E = soldierAttackStrength;
                            
                            towerHealth_E = Math.min(towerHealth_E, robot.health);
                            canLandHit_E = true;
                        }
                        if (d <= UnitType.LEVEL_ONE_PAINT_TOWER.actionRadiusSquared) {
                            // Should have another one for AOE damage.
                            healthDmgAttackRange_E += UnitType.LEVEL_ONE_PAINT_TOWER.attackStrength;
                            canBeHit_E = true;
                        }

                        if (d < minDistToEnemy_E) minDistToEnemy_E = d;
                        break addEnemy0E;
                    }
                    case LEVEL_THREE_DEFENSE_TOWER: {
                        if (actionReady && d <= soldierActionRadiusSquared) {
                            
                            myHealthDmg_E = soldierAttackStrength;
                            
                            towerHealth_E = Math.min(towerHealth_E, robot.health);
                            canLandHit_E = true;
                        }
                        if (d <= UnitType.LEVEL_THREE_DEFENSE_TOWER.actionRadiusSquared) {
                            // Should have another one for AOE damage.
                            healthDmgAttackRange_E += UnitType.LEVEL_THREE_DEFENSE_TOWER.attackStrength;
                            canBeHit_E = true;
                        }

                        if (d < minDistToEnemy_E) minDistToEnemy_E = d;
                        break addEnemy0E;
                    }
                    case LEVEL_THREE_MONEY_TOWER: {
                        if (actionReady && d <= soldierActionRadiusSquared) {
                            
                            myHealthDmg_E = soldierAttackStrength;
                            
                            towerHealth_E = Math.min(towerHealth_E, robot.health);
                            canLandHit_E = true;
                        }
                        if (d <= UnitType.LEVEL_THREE_MONEY_TOWER.actionRadiusSquared) {
                            // Should have another one for AOE damage.
                            healthDmgAttackRange_E += UnitType.LEVEL_THREE_MONEY_TOWER.attackStrength;
                            canBeHit_E = true;
                        }

                        if (d < minDistToEnemy_E) minDistToEnemy_E = d;
                        break addEnemy0E;
                    }
                    case LEVEL_THREE_PAINT_TOWER: {
                        if (actionReady && d <= soldierActionRadiusSquared) {
                            
                            myHealthDmg_E = soldierAttackStrength;
                            
                            towerHealth_E = Math.min(towerHealth_E, robot.health);
                            canLandHit_E = true;
                        }
                        if (d <= UnitType.LEVEL_THREE_PAINT_TOWER.actionRadiusSquared) {
                            // Should have another one for AOE damage.
                            healthDmgAttackRange_E += UnitType.LEVEL_THREE_PAINT_TOWER.attackStrength;
                            canBeHit_E = true;
                        }

                        if (d < minDistToEnemy_E) minDistToEnemy_E = d;
                        break addEnemy0E;
                    }
                    case LEVEL_TWO_DEFENSE_TOWER: {
                        if (actionReady && d <= soldierActionRadiusSquared) {
                            
                            myHealthDmg_E = soldierAttackStrength;
                            
                            towerHealth_E = Math.min(towerHealth_E, robot.health);
                            canLandHit_E = true;
                        }
                        if (d <= UnitType.LEVEL_TWO_DEFENSE_TOWER.actionRadiusSquared) {
                            // Should have another one for AOE damage.
                            healthDmgAttackRange_E += UnitType.LEVEL_TWO_DEFENSE_TOWER.attackStrength;
                            canBeHit_E = true;
                        }

                        if (d < minDistToEnemy_E) minDistToEnemy_E = d;
                        break addEnemy0E;
                    }
                    case LEVEL_TWO_MONEY_TOWER: {
                        if (actionReady && d <= soldierActionRadiusSquared) {
                            
                            myHealthDmg_E = soldierAttackStrength;
                            
                            towerHealth_E = Math.min(towerHealth_E, robot.health);
                            canLandHit_E = true;
                        }
                        if (d <= UnitType.LEVEL_TWO_MONEY_TOWER.actionRadiusSquared) {
                            // Should have another one for AOE damage.
                            healthDmgAttackRange_E += UnitType.LEVEL_TWO_MONEY_TOWER.attackStrength;
                            canBeHit_E = true;
                        }

                        if (d < minDistToEnemy_E) minDistToEnemy_E = d;
                        break addEnemy0E;
                    }
                    case LEVEL_TWO_PAINT_TOWER: {
                        if (actionReady && d <= soldierActionRadiusSquared) {
                            
                            myHealthDmg_E = soldierAttackStrength;
                            
                            towerHealth_E = Math.min(towerHealth_E, robot.health);
                            canLandHit_E = true;
                        }
                        if (d <= UnitType.LEVEL_TWO_PAINT_TOWER.actionRadiusSquared) {
                            // Should have another one for AOE damage.
                            healthDmgAttackRange_E += UnitType.LEVEL_TWO_PAINT_TOWER.attackStrength;
                            canBeHit_E = true;
                        }

                        if (d < minDistToEnemy_E) minDistToEnemy_E = d;
                        break addEnemy0E;
                    }
                    
                    default: break addEnemy0E;
                }
            }
            
            addEnemy0SE: {
                if (!canMove_SE) break addEnemy0SE;
                int d = targetLoc_SE.distanceSquaredTo(robot.location);
                switch (robot.type) {
                    case MOPPER: {
                        // Expected Paint taken.
                        if (d <= UnitType.MOPPER.actionRadiusSquared) {
                            penalty_SE += 3.3;
                        } else if (d <= 8) {
                            penalty_SE += 2.5;
                        }
                        break addEnemy0SE;
                    }
                    case LEVEL_ONE_DEFENSE_TOWER: {
                        if (actionReady && d <= soldierActionRadiusSquared) {
                            
                            myHealthDmg_SE = soldierAttackStrength;
                            
                            towerHealth_SE = Math.min(towerHealth_SE, robot.health);
                            canLandHit_SE = true;
                        }
                        if (d <= UnitType.LEVEL_ONE_DEFENSE_TOWER.actionRadiusSquared) {
                            // Should have another one for AOE damage.
                            healthDmgAttackRange_SE += UnitType.LEVEL_ONE_DEFENSE_TOWER.attackStrength;
                            canBeHit_SE = true;
                        }

                        if (d < minDistToEnemy_SE) minDistToEnemy_SE = d;
                        break addEnemy0SE;
                    }
                    case LEVEL_ONE_MONEY_TOWER: {
                        if (actionReady && d <= soldierActionRadiusSquared) {
                            
                            myHealthDmg_SE = soldierAttackStrength;
                            
                            towerHealth_SE = Math.min(towerHealth_SE, robot.health);
                            canLandHit_SE = true;
                        }
                        if (d <= UnitType.LEVEL_ONE_MONEY_TOWER.actionRadiusSquared) {
                            // Should have another one for AOE damage.
                            healthDmgAttackRange_SE += UnitType.LEVEL_ONE_MONEY_TOWER.attackStrength;
                            canBeHit_SE = true;
                        }

                        if (d < minDistToEnemy_SE) minDistToEnemy_SE = d;
                        break addEnemy0SE;
                    }
                    case LEVEL_ONE_PAINT_TOWER: {
                        if (actionReady && d <= soldierActionRadiusSquared) {
                            
                            myHealthDmg_SE = soldierAttackStrength;
                            
                            towerHealth_SE = Math.min(towerHealth_SE, robot.health);
                            canLandHit_SE = true;
                        }
                        if (d <= UnitType.LEVEL_ONE_PAINT_TOWER.actionRadiusSquared) {
                            // Should have another one for AOE damage.
                            healthDmgAttackRange_SE += UnitType.LEVEL_ONE_PAINT_TOWER.attackStrength;
                            canBeHit_SE = true;
                        }

                        if (d < minDistToEnemy_SE) minDistToEnemy_SE = d;
                        break addEnemy0SE;
                    }
                    case LEVEL_THREE_DEFENSE_TOWER: {
                        if (actionReady && d <= soldierActionRadiusSquared) {
                            
                            myHealthDmg_SE = soldierAttackStrength;
                            
                            towerHealth_SE = Math.min(towerHealth_SE, robot.health);
                            canLandHit_SE = true;
                        }
                        if (d <= UnitType.LEVEL_THREE_DEFENSE_TOWER.actionRadiusSquared) {
                            // Should have another one for AOE damage.
                            healthDmgAttackRange_SE += UnitType.LEVEL_THREE_DEFENSE_TOWER.attackStrength;
                            canBeHit_SE = true;
                        }

                        if (d < minDistToEnemy_SE) minDistToEnemy_SE = d;
                        break addEnemy0SE;
                    }
                    case LEVEL_THREE_MONEY_TOWER: {
                        if (actionReady && d <= soldierActionRadiusSquared) {
                            
                            myHealthDmg_SE = soldierAttackStrength;
                            
                            towerHealth_SE = Math.min(towerHealth_SE, robot.health);
                            canLandHit_SE = true;
                        }
                        if (d <= UnitType.LEVEL_THREE_MONEY_TOWER.actionRadiusSquared) {
                            // Should have another one for AOE damage.
                            healthDmgAttackRange_SE += UnitType.LEVEL_THREE_MONEY_TOWER.attackStrength;
                            canBeHit_SE = true;
                        }

                        if (d < minDistToEnemy_SE) minDistToEnemy_SE = d;
                        break addEnemy0SE;
                    }
                    case LEVEL_THREE_PAINT_TOWER: {
                        if (actionReady && d <= soldierActionRadiusSquared) {
                            
                            myHealthDmg_SE = soldierAttackStrength;
                            
                            towerHealth_SE = Math.min(towerHealth_SE, robot.health);
                            canLandHit_SE = true;
                        }
                        if (d <= UnitType.LEVEL_THREE_PAINT_TOWER.actionRadiusSquared) {
                            // Should have another one for AOE damage.
                            healthDmgAttackRange_SE += UnitType.LEVEL_THREE_PAINT_TOWER.attackStrength;
                            canBeHit_SE = true;
                        }

                        if (d < minDistToEnemy_SE) minDistToEnemy_SE = d;
                        break addEnemy0SE;
                    }
                    case LEVEL_TWO_DEFENSE_TOWER: {
                        if (actionReady && d <= soldierActionRadiusSquared) {
                            
                            myHealthDmg_SE = soldierAttackStrength;
                            
                            towerHealth_SE = Math.min(towerHealth_SE, robot.health);
                            canLandHit_SE = true;
                        }
                        if (d <= UnitType.LEVEL_TWO_DEFENSE_TOWER.actionRadiusSquared) {
                            // Should have another one for AOE damage.
                            healthDmgAttackRange_SE += UnitType.LEVEL_TWO_DEFENSE_TOWER.attackStrength;
                            canBeHit_SE = true;
                        }

                        if (d < minDistToEnemy_SE) minDistToEnemy_SE = d;
                        break addEnemy0SE;
                    }
                    case LEVEL_TWO_MONEY_TOWER: {
                        if (actionReady && d <= soldierActionRadiusSquared) {
                            
                            myHealthDmg_SE = soldierAttackStrength;
                            
                            towerHealth_SE = Math.min(towerHealth_SE, robot.health);
                            canLandHit_SE = true;
                        }
                        if (d <= UnitType.LEVEL_TWO_MONEY_TOWER.actionRadiusSquared) {
                            // Should have another one for AOE damage.
                            healthDmgAttackRange_SE += UnitType.LEVEL_TWO_MONEY_TOWER.attackStrength;
                            canBeHit_SE = true;
                        }

                        if (d < minDistToEnemy_SE) minDistToEnemy_SE = d;
                        break addEnemy0SE;
                    }
                    case LEVEL_TWO_PAINT_TOWER: {
                        if (actionReady && d <= soldierActionRadiusSquared) {
                            
                            myHealthDmg_SE = soldierAttackStrength;
                            
                            towerHealth_SE = Math.min(towerHealth_SE, robot.health);
                            canLandHit_SE = true;
                        }
                        if (d <= UnitType.LEVEL_TWO_PAINT_TOWER.actionRadiusSquared) {
                            // Should have another one for AOE damage.
                            healthDmgAttackRange_SE += UnitType.LEVEL_TWO_PAINT_TOWER.attackStrength;
                            canBeHit_SE = true;
                        }

                        if (d < minDistToEnemy_SE) minDistToEnemy_SE = d;
                        break addEnemy0SE;
                    }
                    
                    default: break addEnemy0SE;
                }
            }
            
            addEnemy0S: {
                if (!canMove_S) break addEnemy0S;
                int d = targetLoc_S.distanceSquaredTo(robot.location);
                switch (robot.type) {
                    case MOPPER: {
                        // Expected Paint taken.
                        if (d <= UnitType.MOPPER.actionRadiusSquared) {
                            penalty_S += 3.3;
                        } else if (d <= 8) {
                            penalty_S += 2.5;
                        }
                        break addEnemy0S;
                    }
                    case LEVEL_ONE_DEFENSE_TOWER: {
                        if (actionReady && d <= soldierActionRadiusSquared) {
                            
                            myHealthDmg_S = soldierAttackStrength;
                            
                            towerHealth_S = Math.min(towerHealth_S, robot.health);
                            canLandHit_S = true;
                        }
                        if (d <= UnitType.LEVEL_ONE_DEFENSE_TOWER.actionRadiusSquared) {
                            // Should have another one for AOE damage.
                            healthDmgAttackRange_S += UnitType.LEVEL_ONE_DEFENSE_TOWER.attackStrength;
                            canBeHit_S = true;
                        }

                        if (d < minDistToEnemy_S) minDistToEnemy_S = d;
                        break addEnemy0S;
                    }
                    case LEVEL_ONE_MONEY_TOWER: {
                        if (actionReady && d <= soldierActionRadiusSquared) {
                            
                            myHealthDmg_S = soldierAttackStrength;
                            
                            towerHealth_S = Math.min(towerHealth_S, robot.health);
                            canLandHit_S = true;
                        }
                        if (d <= UnitType.LEVEL_ONE_MONEY_TOWER.actionRadiusSquared) {
                            // Should have another one for AOE damage.
                            healthDmgAttackRange_S += UnitType.LEVEL_ONE_MONEY_TOWER.attackStrength;
                            canBeHit_S = true;
                        }

                        if (d < minDistToEnemy_S) minDistToEnemy_S = d;
                        break addEnemy0S;
                    }
                    case LEVEL_ONE_PAINT_TOWER: {
                        if (actionReady && d <= soldierActionRadiusSquared) {
                            
                            myHealthDmg_S = soldierAttackStrength;
                            
                            towerHealth_S = Math.min(towerHealth_S, robot.health);
                            canLandHit_S = true;
                        }
                        if (d <= UnitType.LEVEL_ONE_PAINT_TOWER.actionRadiusSquared) {
                            // Should have another one for AOE damage.
                            healthDmgAttackRange_S += UnitType.LEVEL_ONE_PAINT_TOWER.attackStrength;
                            canBeHit_S = true;
                        }

                        if (d < minDistToEnemy_S) minDistToEnemy_S = d;
                        break addEnemy0S;
                    }
                    case LEVEL_THREE_DEFENSE_TOWER: {
                        if (actionReady && d <= soldierActionRadiusSquared) {
                            
                            myHealthDmg_S = soldierAttackStrength;
                            
                            towerHealth_S = Math.min(towerHealth_S, robot.health);
                            canLandHit_S = true;
                        }
                        if (d <= UnitType.LEVEL_THREE_DEFENSE_TOWER.actionRadiusSquared) {
                            // Should have another one for AOE damage.
                            healthDmgAttackRange_S += UnitType.LEVEL_THREE_DEFENSE_TOWER.attackStrength;
                            canBeHit_S = true;
                        }

                        if (d < minDistToEnemy_S) minDistToEnemy_S = d;
                        break addEnemy0S;
                    }
                    case LEVEL_THREE_MONEY_TOWER: {
                        if (actionReady && d <= soldierActionRadiusSquared) {
                            
                            myHealthDmg_S = soldierAttackStrength;
                            
                            towerHealth_S = Math.min(towerHealth_S, robot.health);
                            canLandHit_S = true;
                        }
                        if (d <= UnitType.LEVEL_THREE_MONEY_TOWER.actionRadiusSquared) {
                            // Should have another one for AOE damage.
                            healthDmgAttackRange_S += UnitType.LEVEL_THREE_MONEY_TOWER.attackStrength;
                            canBeHit_S = true;
                        }

                        if (d < minDistToEnemy_S) minDistToEnemy_S = d;
                        break addEnemy0S;
                    }
                    case LEVEL_THREE_PAINT_TOWER: {
                        if (actionReady && d <= soldierActionRadiusSquared) {
                            
                            myHealthDmg_S = soldierAttackStrength;
                            
                            towerHealth_S = Math.min(towerHealth_S, robot.health);
                            canLandHit_S = true;
                        }
                        if (d <= UnitType.LEVEL_THREE_PAINT_TOWER.actionRadiusSquared) {
                            // Should have another one for AOE damage.
                            healthDmgAttackRange_S += UnitType.LEVEL_THREE_PAINT_TOWER.attackStrength;
                            canBeHit_S = true;
                        }

                        if (d < minDistToEnemy_S) minDistToEnemy_S = d;
                        break addEnemy0S;
                    }
                    case LEVEL_TWO_DEFENSE_TOWER: {
                        if (actionReady && d <= soldierActionRadiusSquared) {
                            
                            myHealthDmg_S = soldierAttackStrength;
                            
                            towerHealth_S = Math.min(towerHealth_S, robot.health);
                            canLandHit_S = true;
                        }
                        if (d <= UnitType.LEVEL_TWO_DEFENSE_TOWER.actionRadiusSquared) {
                            // Should have another one for AOE damage.
                            healthDmgAttackRange_S += UnitType.LEVEL_TWO_DEFENSE_TOWER.attackStrength;
                            canBeHit_S = true;
                        }

                        if (d < minDistToEnemy_S) minDistToEnemy_S = d;
                        break addEnemy0S;
                    }
                    case LEVEL_TWO_MONEY_TOWER: {
                        if (actionReady && d <= soldierActionRadiusSquared) {
                            
                            myHealthDmg_S = soldierAttackStrength;
                            
                            towerHealth_S = Math.min(towerHealth_S, robot.health);
                            canLandHit_S = true;
                        }
                        if (d <= UnitType.LEVEL_TWO_MONEY_TOWER.actionRadiusSquared) {
                            // Should have another one for AOE damage.
                            healthDmgAttackRange_S += UnitType.LEVEL_TWO_MONEY_TOWER.attackStrength;
                            canBeHit_S = true;
                        }

                        if (d < minDistToEnemy_S) minDistToEnemy_S = d;
                        break addEnemy0S;
                    }
                    case LEVEL_TWO_PAINT_TOWER: {
                        if (actionReady && d <= soldierActionRadiusSquared) {
                            
                            myHealthDmg_S = soldierAttackStrength;
                            
                            towerHealth_S = Math.min(towerHealth_S, robot.health);
                            canLandHit_S = true;
                        }
                        if (d <= UnitType.LEVEL_TWO_PAINT_TOWER.actionRadiusSquared) {
                            // Should have another one for AOE damage.
                            healthDmgAttackRange_S += UnitType.LEVEL_TWO_PAINT_TOWER.attackStrength;
                            canBeHit_S = true;
                        }

                        if (d < minDistToEnemy_S) minDistToEnemy_S = d;
                        break addEnemy0S;
                    }
                    
                    default: break addEnemy0S;
                }
            }
            
            addEnemy0SW: {
                if (!canMove_SW) break addEnemy0SW;
                int d = targetLoc_SW.distanceSquaredTo(robot.location);
                switch (robot.type) {
                    case MOPPER: {
                        // Expected Paint taken.
                        if (d <= UnitType.MOPPER.actionRadiusSquared) {
                            penalty_SW += 3.3;
                        } else if (d <= 8) {
                            penalty_SW += 2.5;
                        }
                        break addEnemy0SW;
                    }
                    case LEVEL_ONE_DEFENSE_TOWER: {
                        if (actionReady && d <= soldierActionRadiusSquared) {
                            
                            myHealthDmg_SW = soldierAttackStrength;
                            
                            towerHealth_SW = Math.min(towerHealth_SW, robot.health);
                            canLandHit_SW = true;
                        }
                        if (d <= UnitType.LEVEL_ONE_DEFENSE_TOWER.actionRadiusSquared) {
                            // Should have another one for AOE damage.
                            healthDmgAttackRange_SW += UnitType.LEVEL_ONE_DEFENSE_TOWER.attackStrength;
                            canBeHit_SW = true;
                        }

                        if (d < minDistToEnemy_SW) minDistToEnemy_SW = d;
                        break addEnemy0SW;
                    }
                    case LEVEL_ONE_MONEY_TOWER: {
                        if (actionReady && d <= soldierActionRadiusSquared) {
                            
                            myHealthDmg_SW = soldierAttackStrength;
                            
                            towerHealth_SW = Math.min(towerHealth_SW, robot.health);
                            canLandHit_SW = true;
                        }
                        if (d <= UnitType.LEVEL_ONE_MONEY_TOWER.actionRadiusSquared) {
                            // Should have another one for AOE damage.
                            healthDmgAttackRange_SW += UnitType.LEVEL_ONE_MONEY_TOWER.attackStrength;
                            canBeHit_SW = true;
                        }

                        if (d < minDistToEnemy_SW) minDistToEnemy_SW = d;
                        break addEnemy0SW;
                    }
                    case LEVEL_ONE_PAINT_TOWER: {
                        if (actionReady && d <= soldierActionRadiusSquared) {
                            
                            myHealthDmg_SW = soldierAttackStrength;
                            
                            towerHealth_SW = Math.min(towerHealth_SW, robot.health);
                            canLandHit_SW = true;
                        }
                        if (d <= UnitType.LEVEL_ONE_PAINT_TOWER.actionRadiusSquared) {
                            // Should have another one for AOE damage.
                            healthDmgAttackRange_SW += UnitType.LEVEL_ONE_PAINT_TOWER.attackStrength;
                            canBeHit_SW = true;
                        }

                        if (d < minDistToEnemy_SW) minDistToEnemy_SW = d;
                        break addEnemy0SW;
                    }
                    case LEVEL_THREE_DEFENSE_TOWER: {
                        if (actionReady && d <= soldierActionRadiusSquared) {
                            
                            myHealthDmg_SW = soldierAttackStrength;
                            
                            towerHealth_SW = Math.min(towerHealth_SW, robot.health);
                            canLandHit_SW = true;
                        }
                        if (d <= UnitType.LEVEL_THREE_DEFENSE_TOWER.actionRadiusSquared) {
                            // Should have another one for AOE damage.
                            healthDmgAttackRange_SW += UnitType.LEVEL_THREE_DEFENSE_TOWER.attackStrength;
                            canBeHit_SW = true;
                        }

                        if (d < minDistToEnemy_SW) minDistToEnemy_SW = d;
                        break addEnemy0SW;
                    }
                    case LEVEL_THREE_MONEY_TOWER: {
                        if (actionReady && d <= soldierActionRadiusSquared) {
                            
                            myHealthDmg_SW = soldierAttackStrength;
                            
                            towerHealth_SW = Math.min(towerHealth_SW, robot.health);
                            canLandHit_SW = true;
                        }
                        if (d <= UnitType.LEVEL_THREE_MONEY_TOWER.actionRadiusSquared) {
                            // Should have another one for AOE damage.
                            healthDmgAttackRange_SW += UnitType.LEVEL_THREE_MONEY_TOWER.attackStrength;
                            canBeHit_SW = true;
                        }

                        if (d < minDistToEnemy_SW) minDistToEnemy_SW = d;
                        break addEnemy0SW;
                    }
                    case LEVEL_THREE_PAINT_TOWER: {
                        if (actionReady && d <= soldierActionRadiusSquared) {
                            
                            myHealthDmg_SW = soldierAttackStrength;
                            
                            towerHealth_SW = Math.min(towerHealth_SW, robot.health);
                            canLandHit_SW = true;
                        }
                        if (d <= UnitType.LEVEL_THREE_PAINT_TOWER.actionRadiusSquared) {
                            // Should have another one for AOE damage.
                            healthDmgAttackRange_SW += UnitType.LEVEL_THREE_PAINT_TOWER.attackStrength;
                            canBeHit_SW = true;
                        }

                        if (d < minDistToEnemy_SW) minDistToEnemy_SW = d;
                        break addEnemy0SW;
                    }
                    case LEVEL_TWO_DEFENSE_TOWER: {
                        if (actionReady && d <= soldierActionRadiusSquared) {
                            
                            myHealthDmg_SW = soldierAttackStrength;
                            
                            towerHealth_SW = Math.min(towerHealth_SW, robot.health);
                            canLandHit_SW = true;
                        }
                        if (d <= UnitType.LEVEL_TWO_DEFENSE_TOWER.actionRadiusSquared) {
                            // Should have another one for AOE damage.
                            healthDmgAttackRange_SW += UnitType.LEVEL_TWO_DEFENSE_TOWER.attackStrength;
                            canBeHit_SW = true;
                        }

                        if (d < minDistToEnemy_SW) minDistToEnemy_SW = d;
                        break addEnemy0SW;
                    }
                    case LEVEL_TWO_MONEY_TOWER: {
                        if (actionReady && d <= soldierActionRadiusSquared) {
                            
                            myHealthDmg_SW = soldierAttackStrength;
                            
                            towerHealth_SW = Math.min(towerHealth_SW, robot.health);
                            canLandHit_SW = true;
                        }
                        if (d <= UnitType.LEVEL_TWO_MONEY_TOWER.actionRadiusSquared) {
                            // Should have another one for AOE damage.
                            healthDmgAttackRange_SW += UnitType.LEVEL_TWO_MONEY_TOWER.attackStrength;
                            canBeHit_SW = true;
                        }

                        if (d < minDistToEnemy_SW) minDistToEnemy_SW = d;
                        break addEnemy0SW;
                    }
                    case LEVEL_TWO_PAINT_TOWER: {
                        if (actionReady && d <= soldierActionRadiusSquared) {
                            
                            myHealthDmg_SW = soldierAttackStrength;
                            
                            towerHealth_SW = Math.min(towerHealth_SW, robot.health);
                            canLandHit_SW = true;
                        }
                        if (d <= UnitType.LEVEL_TWO_PAINT_TOWER.actionRadiusSquared) {
                            // Should have another one for AOE damage.
                            healthDmgAttackRange_SW += UnitType.LEVEL_TWO_PAINT_TOWER.attackStrength;
                            canBeHit_SW = true;
                        }

                        if (d < minDistToEnemy_SW) minDistToEnemy_SW = d;
                        break addEnemy0SW;
                    }
                    
                    default: break addEnemy0SW;
                }
            }
            
            addEnemy0W: {
                if (!canMove_W) break addEnemy0W;
                int d = targetLoc_W.distanceSquaredTo(robot.location);
                switch (robot.type) {
                    case MOPPER: {
                        // Expected Paint taken.
                        if (d <= UnitType.MOPPER.actionRadiusSquared) {
                            penalty_W += 3.3;
                        } else if (d <= 8) {
                            penalty_W += 2.5;
                        }
                        break addEnemy0W;
                    }
                    case LEVEL_ONE_DEFENSE_TOWER: {
                        if (actionReady && d <= soldierActionRadiusSquared) {
                            
                            myHealthDmg_W = soldierAttackStrength;
                            
                            towerHealth_W = Math.min(towerHealth_W, robot.health);
                            canLandHit_W = true;
                        }
                        if (d <= UnitType.LEVEL_ONE_DEFENSE_TOWER.actionRadiusSquared) {
                            // Should have another one for AOE damage.
                            healthDmgAttackRange_W += UnitType.LEVEL_ONE_DEFENSE_TOWER.attackStrength;
                            canBeHit_W = true;
                        }

                        if (d < minDistToEnemy_W) minDistToEnemy_W = d;
                        break addEnemy0W;
                    }
                    case LEVEL_ONE_MONEY_TOWER: {
                        if (actionReady && d <= soldierActionRadiusSquared) {
                            
                            myHealthDmg_W = soldierAttackStrength;
                            
                            towerHealth_W = Math.min(towerHealth_W, robot.health);
                            canLandHit_W = true;
                        }
                        if (d <= UnitType.LEVEL_ONE_MONEY_TOWER.actionRadiusSquared) {
                            // Should have another one for AOE damage.
                            healthDmgAttackRange_W += UnitType.LEVEL_ONE_MONEY_TOWER.attackStrength;
                            canBeHit_W = true;
                        }

                        if (d < minDistToEnemy_W) minDistToEnemy_W = d;
                        break addEnemy0W;
                    }
                    case LEVEL_ONE_PAINT_TOWER: {
                        if (actionReady && d <= soldierActionRadiusSquared) {
                            
                            myHealthDmg_W = soldierAttackStrength;
                            
                            towerHealth_W = Math.min(towerHealth_W, robot.health);
                            canLandHit_W = true;
                        }
                        if (d <= UnitType.LEVEL_ONE_PAINT_TOWER.actionRadiusSquared) {
                            // Should have another one for AOE damage.
                            healthDmgAttackRange_W += UnitType.LEVEL_ONE_PAINT_TOWER.attackStrength;
                            canBeHit_W = true;
                        }

                        if (d < minDistToEnemy_W) minDistToEnemy_W = d;
                        break addEnemy0W;
                    }
                    case LEVEL_THREE_DEFENSE_TOWER: {
                        if (actionReady && d <= soldierActionRadiusSquared) {
                            
                            myHealthDmg_W = soldierAttackStrength;
                            
                            towerHealth_W = Math.min(towerHealth_W, robot.health);
                            canLandHit_W = true;
                        }
                        if (d <= UnitType.LEVEL_THREE_DEFENSE_TOWER.actionRadiusSquared) {
                            // Should have another one for AOE damage.
                            healthDmgAttackRange_W += UnitType.LEVEL_THREE_DEFENSE_TOWER.attackStrength;
                            canBeHit_W = true;
                        }

                        if (d < minDistToEnemy_W) minDistToEnemy_W = d;
                        break addEnemy0W;
                    }
                    case LEVEL_THREE_MONEY_TOWER: {
                        if (actionReady && d <= soldierActionRadiusSquared) {
                            
                            myHealthDmg_W = soldierAttackStrength;
                            
                            towerHealth_W = Math.min(towerHealth_W, robot.health);
                            canLandHit_W = true;
                        }
                        if (d <= UnitType.LEVEL_THREE_MONEY_TOWER.actionRadiusSquared) {
                            // Should have another one for AOE damage.
                            healthDmgAttackRange_W += UnitType.LEVEL_THREE_MONEY_TOWER.attackStrength;
                            canBeHit_W = true;
                        }

                        if (d < minDistToEnemy_W) minDistToEnemy_W = d;
                        break addEnemy0W;
                    }
                    case LEVEL_THREE_PAINT_TOWER: {
                        if (actionReady && d <= soldierActionRadiusSquared) {
                            
                            myHealthDmg_W = soldierAttackStrength;
                            
                            towerHealth_W = Math.min(towerHealth_W, robot.health);
                            canLandHit_W = true;
                        }
                        if (d <= UnitType.LEVEL_THREE_PAINT_TOWER.actionRadiusSquared) {
                            // Should have another one for AOE damage.
                            healthDmgAttackRange_W += UnitType.LEVEL_THREE_PAINT_TOWER.attackStrength;
                            canBeHit_W = true;
                        }

                        if (d < minDistToEnemy_W) minDistToEnemy_W = d;
                        break addEnemy0W;
                    }
                    case LEVEL_TWO_DEFENSE_TOWER: {
                        if (actionReady && d <= soldierActionRadiusSquared) {
                            
                            myHealthDmg_W = soldierAttackStrength;
                            
                            towerHealth_W = Math.min(towerHealth_W, robot.health);
                            canLandHit_W = true;
                        }
                        if (d <= UnitType.LEVEL_TWO_DEFENSE_TOWER.actionRadiusSquared) {
                            // Should have another one for AOE damage.
                            healthDmgAttackRange_W += UnitType.LEVEL_TWO_DEFENSE_TOWER.attackStrength;
                            canBeHit_W = true;
                        }

                        if (d < minDistToEnemy_W) minDistToEnemy_W = d;
                        break addEnemy0W;
                    }
                    case LEVEL_TWO_MONEY_TOWER: {
                        if (actionReady && d <= soldierActionRadiusSquared) {
                            
                            myHealthDmg_W = soldierAttackStrength;
                            
                            towerHealth_W = Math.min(towerHealth_W, robot.health);
                            canLandHit_W = true;
                        }
                        if (d <= UnitType.LEVEL_TWO_MONEY_TOWER.actionRadiusSquared) {
                            // Should have another one for AOE damage.
                            healthDmgAttackRange_W += UnitType.LEVEL_TWO_MONEY_TOWER.attackStrength;
                            canBeHit_W = true;
                        }

                        if (d < minDistToEnemy_W) minDistToEnemy_W = d;
                        break addEnemy0W;
                    }
                    case LEVEL_TWO_PAINT_TOWER: {
                        if (actionReady && d <= soldierActionRadiusSquared) {
                            
                            myHealthDmg_W = soldierAttackStrength;
                            
                            towerHealth_W = Math.min(towerHealth_W, robot.health);
                            canLandHit_W = true;
                        }
                        if (d <= UnitType.LEVEL_TWO_PAINT_TOWER.actionRadiusSquared) {
                            // Should have another one for AOE damage.
                            healthDmgAttackRange_W += UnitType.LEVEL_TWO_PAINT_TOWER.attackStrength;
                            canBeHit_W = true;
                        }

                        if (d < minDistToEnemy_W) minDistToEnemy_W = d;
                        break addEnemy0W;
                    }
                    
                    default: break addEnemy0W;
                }
            }
            
            addEnemy0NW: {
                if (!canMove_NW) break addEnemy0NW;
                int d = targetLoc_NW.distanceSquaredTo(robot.location);
                switch (robot.type) {
                    case MOPPER: {
                        // Expected Paint taken.
                        if (d <= UnitType.MOPPER.actionRadiusSquared) {
                            penalty_NW += 3.3;
                        } else if (d <= 8) {
                            penalty_NW += 2.5;
                        }
                        break addEnemy0NW;
                    }
                    case LEVEL_ONE_DEFENSE_TOWER: {
                        if (actionReady && d <= soldierActionRadiusSquared) {
                            
                            myHealthDmg_NW = soldierAttackStrength;
                            
                            towerHealth_NW = Math.min(towerHealth_NW, robot.health);
                            canLandHit_NW = true;
                        }
                        if (d <= UnitType.LEVEL_ONE_DEFENSE_TOWER.actionRadiusSquared) {
                            // Should have another one for AOE damage.
                            healthDmgAttackRange_NW += UnitType.LEVEL_ONE_DEFENSE_TOWER.attackStrength;
                            canBeHit_NW = true;
                        }

                        if (d < minDistToEnemy_NW) minDistToEnemy_NW = d;
                        break addEnemy0NW;
                    }
                    case LEVEL_ONE_MONEY_TOWER: {
                        if (actionReady && d <= soldierActionRadiusSquared) {
                            
                            myHealthDmg_NW = soldierAttackStrength;
                            
                            towerHealth_NW = Math.min(towerHealth_NW, robot.health);
                            canLandHit_NW = true;
                        }
                        if (d <= UnitType.LEVEL_ONE_MONEY_TOWER.actionRadiusSquared) {
                            // Should have another one for AOE damage.
                            healthDmgAttackRange_NW += UnitType.LEVEL_ONE_MONEY_TOWER.attackStrength;
                            canBeHit_NW = true;
                        }

                        if (d < minDistToEnemy_NW) minDistToEnemy_NW = d;
                        break addEnemy0NW;
                    }
                    case LEVEL_ONE_PAINT_TOWER: {
                        if (actionReady && d <= soldierActionRadiusSquared) {
                            
                            myHealthDmg_NW = soldierAttackStrength;
                            
                            towerHealth_NW = Math.min(towerHealth_NW, robot.health);
                            canLandHit_NW = true;
                        }
                        if (d <= UnitType.LEVEL_ONE_PAINT_TOWER.actionRadiusSquared) {
                            // Should have another one for AOE damage.
                            healthDmgAttackRange_NW += UnitType.LEVEL_ONE_PAINT_TOWER.attackStrength;
                            canBeHit_NW = true;
                        }

                        if (d < minDistToEnemy_NW) minDistToEnemy_NW = d;
                        break addEnemy0NW;
                    }
                    case LEVEL_THREE_DEFENSE_TOWER: {
                        if (actionReady && d <= soldierActionRadiusSquared) {
                            
                            myHealthDmg_NW = soldierAttackStrength;
                            
                            towerHealth_NW = Math.min(towerHealth_NW, robot.health);
                            canLandHit_NW = true;
                        }
                        if (d <= UnitType.LEVEL_THREE_DEFENSE_TOWER.actionRadiusSquared) {
                            // Should have another one for AOE damage.
                            healthDmgAttackRange_NW += UnitType.LEVEL_THREE_DEFENSE_TOWER.attackStrength;
                            canBeHit_NW = true;
                        }

                        if (d < minDistToEnemy_NW) minDistToEnemy_NW = d;
                        break addEnemy0NW;
                    }
                    case LEVEL_THREE_MONEY_TOWER: {
                        if (actionReady && d <= soldierActionRadiusSquared) {
                            
                            myHealthDmg_NW = soldierAttackStrength;
                            
                            towerHealth_NW = Math.min(towerHealth_NW, robot.health);
                            canLandHit_NW = true;
                        }
                        if (d <= UnitType.LEVEL_THREE_MONEY_TOWER.actionRadiusSquared) {
                            // Should have another one for AOE damage.
                            healthDmgAttackRange_NW += UnitType.LEVEL_THREE_MONEY_TOWER.attackStrength;
                            canBeHit_NW = true;
                        }

                        if (d < minDistToEnemy_NW) minDistToEnemy_NW = d;
                        break addEnemy0NW;
                    }
                    case LEVEL_THREE_PAINT_TOWER: {
                        if (actionReady && d <= soldierActionRadiusSquared) {
                            
                            myHealthDmg_NW = soldierAttackStrength;
                            
                            towerHealth_NW = Math.min(towerHealth_NW, robot.health);
                            canLandHit_NW = true;
                        }
                        if (d <= UnitType.LEVEL_THREE_PAINT_TOWER.actionRadiusSquared) {
                            // Should have another one for AOE damage.
                            healthDmgAttackRange_NW += UnitType.LEVEL_THREE_PAINT_TOWER.attackStrength;
                            canBeHit_NW = true;
                        }

                        if (d < minDistToEnemy_NW) minDistToEnemy_NW = d;
                        break addEnemy0NW;
                    }
                    case LEVEL_TWO_DEFENSE_TOWER: {
                        if (actionReady && d <= soldierActionRadiusSquared) {
                            
                            myHealthDmg_NW = soldierAttackStrength;
                            
                            towerHealth_NW = Math.min(towerHealth_NW, robot.health);
                            canLandHit_NW = true;
                        }
                        if (d <= UnitType.LEVEL_TWO_DEFENSE_TOWER.actionRadiusSquared) {
                            // Should have another one for AOE damage.
                            healthDmgAttackRange_NW += UnitType.LEVEL_TWO_DEFENSE_TOWER.attackStrength;
                            canBeHit_NW = true;
                        }

                        if (d < minDistToEnemy_NW) minDistToEnemy_NW = d;
                        break addEnemy0NW;
                    }
                    case LEVEL_TWO_MONEY_TOWER: {
                        if (actionReady && d <= soldierActionRadiusSquared) {
                            
                            myHealthDmg_NW = soldierAttackStrength;
                            
                            towerHealth_NW = Math.min(towerHealth_NW, robot.health);
                            canLandHit_NW = true;
                        }
                        if (d <= UnitType.LEVEL_TWO_MONEY_TOWER.actionRadiusSquared) {
                            // Should have another one for AOE damage.
                            healthDmgAttackRange_NW += UnitType.LEVEL_TWO_MONEY_TOWER.attackStrength;
                            canBeHit_NW = true;
                        }

                        if (d < minDistToEnemy_NW) minDistToEnemy_NW = d;
                        break addEnemy0NW;
                    }
                    case LEVEL_TWO_PAINT_TOWER: {
                        if (actionReady && d <= soldierActionRadiusSquared) {
                            
                            myHealthDmg_NW = soldierAttackStrength;
                            
                            towerHealth_NW = Math.min(towerHealth_NW, robot.health);
                            canLandHit_NW = true;
                        }
                        if (d <= UnitType.LEVEL_TWO_PAINT_TOWER.actionRadiusSquared) {
                            // Should have another one for AOE damage.
                            healthDmgAttackRange_NW += UnitType.LEVEL_TWO_PAINT_TOWER.attackStrength;
                            canBeHit_NW = true;
                        }

                        if (d < minDistToEnemy_NW) minDistToEnemy_NW = d;
                        break addEnemy0NW;
                    }
                    
                    default: break addEnemy0NW;
                }
            }
            
            addEnemy0C: {
                if (!canMove_C) break addEnemy0C;
                int d = targetLoc_C.distanceSquaredTo(robot.location);
                switch (robot.type) {
                    case MOPPER: {
                        // Expected Paint taken.
                        if (d <= UnitType.MOPPER.actionRadiusSquared) {
                            penalty_C += 3.3;
                        } else if (d <= 8) {
                            penalty_C += 2.5;
                        }
                        break addEnemy0C;
                    }
                    case LEVEL_ONE_DEFENSE_TOWER: {
                        if (actionReady && d <= soldierActionRadiusSquared) {
                            
                            myHealthDmg_C = soldierAttackStrength;
                            
                            towerHealth_C = Math.min(towerHealth_C, robot.health);
                            canLandHit_C = true;
                        }
                        if (d <= UnitType.LEVEL_ONE_DEFENSE_TOWER.actionRadiusSquared) {
                            // Should have another one for AOE damage.
                            healthDmgAttackRange_C += UnitType.LEVEL_ONE_DEFENSE_TOWER.attackStrength;
                            canBeHit_C = true;
                        }

                        if (d < minDistToEnemy_C) minDistToEnemy_C = d;
                        break addEnemy0C;
                    }
                    case LEVEL_ONE_MONEY_TOWER: {
                        if (actionReady && d <= soldierActionRadiusSquared) {
                            
                            myHealthDmg_C = soldierAttackStrength;
                            
                            towerHealth_C = Math.min(towerHealth_C, robot.health);
                            canLandHit_C = true;
                        }
                        if (d <= UnitType.LEVEL_ONE_MONEY_TOWER.actionRadiusSquared) {
                            // Should have another one for AOE damage.
                            healthDmgAttackRange_C += UnitType.LEVEL_ONE_MONEY_TOWER.attackStrength;
                            canBeHit_C = true;
                        }

                        if (d < minDistToEnemy_C) minDistToEnemy_C = d;
                        break addEnemy0C;
                    }
                    case LEVEL_ONE_PAINT_TOWER: {
                        if (actionReady && d <= soldierActionRadiusSquared) {
                            
                            myHealthDmg_C = soldierAttackStrength;
                            
                            towerHealth_C = Math.min(towerHealth_C, robot.health);
                            canLandHit_C = true;
                        }
                        if (d <= UnitType.LEVEL_ONE_PAINT_TOWER.actionRadiusSquared) {
                            // Should have another one for AOE damage.
                            healthDmgAttackRange_C += UnitType.LEVEL_ONE_PAINT_TOWER.attackStrength;
                            canBeHit_C = true;
                        }

                        if (d < minDistToEnemy_C) minDistToEnemy_C = d;
                        break addEnemy0C;
                    }
                    case LEVEL_THREE_DEFENSE_TOWER: {
                        if (actionReady && d <= soldierActionRadiusSquared) {
                            
                            myHealthDmg_C = soldierAttackStrength;
                            
                            towerHealth_C = Math.min(towerHealth_C, robot.health);
                            canLandHit_C = true;
                        }
                        if (d <= UnitType.LEVEL_THREE_DEFENSE_TOWER.actionRadiusSquared) {
                            // Should have another one for AOE damage.
                            healthDmgAttackRange_C += UnitType.LEVEL_THREE_DEFENSE_TOWER.attackStrength;
                            canBeHit_C = true;
                        }

                        if (d < minDistToEnemy_C) minDistToEnemy_C = d;
                        break addEnemy0C;
                    }
                    case LEVEL_THREE_MONEY_TOWER: {
                        if (actionReady && d <= soldierActionRadiusSquared) {
                            
                            myHealthDmg_C = soldierAttackStrength;
                            
                            towerHealth_C = Math.min(towerHealth_C, robot.health);
                            canLandHit_C = true;
                        }
                        if (d <= UnitType.LEVEL_THREE_MONEY_TOWER.actionRadiusSquared) {
                            // Should have another one for AOE damage.
                            healthDmgAttackRange_C += UnitType.LEVEL_THREE_MONEY_TOWER.attackStrength;
                            canBeHit_C = true;
                        }

                        if (d < minDistToEnemy_C) minDistToEnemy_C = d;
                        break addEnemy0C;
                    }
                    case LEVEL_THREE_PAINT_TOWER: {
                        if (actionReady && d <= soldierActionRadiusSquared) {
                            
                            myHealthDmg_C = soldierAttackStrength;
                            
                            towerHealth_C = Math.min(towerHealth_C, robot.health);
                            canLandHit_C = true;
                        }
                        if (d <= UnitType.LEVEL_THREE_PAINT_TOWER.actionRadiusSquared) {
                            // Should have another one for AOE damage.
                            healthDmgAttackRange_C += UnitType.LEVEL_THREE_PAINT_TOWER.attackStrength;
                            canBeHit_C = true;
                        }

                        if (d < minDistToEnemy_C) minDistToEnemy_C = d;
                        break addEnemy0C;
                    }
                    case LEVEL_TWO_DEFENSE_TOWER: {
                        if (actionReady && d <= soldierActionRadiusSquared) {
                            
                            myHealthDmg_C = soldierAttackStrength;
                            
                            towerHealth_C = Math.min(towerHealth_C, robot.health);
                            canLandHit_C = true;
                        }
                        if (d <= UnitType.LEVEL_TWO_DEFENSE_TOWER.actionRadiusSquared) {
                            // Should have another one for AOE damage.
                            healthDmgAttackRange_C += UnitType.LEVEL_TWO_DEFENSE_TOWER.attackStrength;
                            canBeHit_C = true;
                        }

                        if (d < minDistToEnemy_C) minDistToEnemy_C = d;
                        break addEnemy0C;
                    }
                    case LEVEL_TWO_MONEY_TOWER: {
                        if (actionReady && d <= soldierActionRadiusSquared) {
                            
                            myHealthDmg_C = soldierAttackStrength;
                            
                            towerHealth_C = Math.min(towerHealth_C, robot.health);
                            canLandHit_C = true;
                        }
                        if (d <= UnitType.LEVEL_TWO_MONEY_TOWER.actionRadiusSquared) {
                            // Should have another one for AOE damage.
                            healthDmgAttackRange_C += UnitType.LEVEL_TWO_MONEY_TOWER.attackStrength;
                            canBeHit_C = true;
                        }

                        if (d < minDistToEnemy_C) minDistToEnemy_C = d;
                        break addEnemy0C;
                    }
                    case LEVEL_TWO_PAINT_TOWER: {
                        if (actionReady && d <= soldierActionRadiusSquared) {
                            
                            myHealthDmg_C = soldierAttackStrength;
                            
                            towerHealth_C = Math.min(towerHealth_C, robot.health);
                            canLandHit_C = true;
                        }
                        if (d <= UnitType.LEVEL_TWO_PAINT_TOWER.actionRadiusSquared) {
                            // Should have another one for AOE damage.
                            healthDmgAttackRange_C += UnitType.LEVEL_TWO_PAINT_TOWER.attackStrength;
                            canBeHit_C = true;
                        }

                        if (d < minDistToEnemy_C) minDistToEnemy_C = d;
                        break addEnemy0C;
                    }
                    
                    default: break addEnemy0C;
                }
            }
            
        }

        
        System.out.println("[231] " + "minDistToEnemy_N = " + minDistToEnemy_N + ", " + "targetLoc_N.x = " + targetLoc_N.x + ", " + "canMove_N = " + canMove_N + ", " + "targetLoc_N.y = " + targetLoc_N.y + ", " + "penalty_N = " + penalty_N + ", " + "healthDmgAttackRange_N = " + healthDmgAttackRange_N + ", " + "myHealthDmg_N = " + myHealthDmg_N + ", " + "towerHealth_N = " + towerHealth_N + ", " + "canBeHit_N = " + canBeHit_N + ", " + "canLandHit_N = " + canLandHit_N);
        
        System.out.println("[231] " + "minDistToEnemy_NE = " + minDistToEnemy_NE + ", " + "targetLoc_NE.x = " + targetLoc_NE.x + ", " + "canMove_NE = " + canMove_NE + ", " + "targetLoc_NE.y = " + targetLoc_NE.y + ", " + "penalty_NE = " + penalty_NE + ", " + "healthDmgAttackRange_NE = " + healthDmgAttackRange_NE + ", " + "myHealthDmg_NE = " + myHealthDmg_NE + ", " + "towerHealth_NE = " + towerHealth_NE + ", " + "canBeHit_NE = " + canBeHit_NE + ", " + "canLandHit_NE = " + canLandHit_NE);
        
        System.out.println("[231] " + "minDistToEnemy_E = " + minDistToEnemy_E + ", " + "targetLoc_E.x = " + targetLoc_E.x + ", " + "canMove_E = " + canMove_E + ", " + "targetLoc_E.y = " + targetLoc_E.y + ", " + "penalty_E = " + penalty_E + ", " + "healthDmgAttackRange_E = " + healthDmgAttackRange_E + ", " + "myHealthDmg_E = " + myHealthDmg_E + ", " + "towerHealth_E = " + towerHealth_E + ", " + "canBeHit_E = " + canBeHit_E + ", " + "canLandHit_E = " + canLandHit_E);
        
        System.out.println("[231] " + "minDistToEnemy_SE = " + minDistToEnemy_SE + ", " + "targetLoc_SE.x = " + targetLoc_SE.x + ", " + "canMove_SE = " + canMove_SE + ", " + "targetLoc_SE.y = " + targetLoc_SE.y + ", " + "penalty_SE = " + penalty_SE + ", " + "healthDmgAttackRange_SE = " + healthDmgAttackRange_SE + ", " + "myHealthDmg_SE = " + myHealthDmg_SE + ", " + "towerHealth_SE = " + towerHealth_SE + ", " + "canBeHit_SE = " + canBeHit_SE + ", " + "canLandHit_SE = " + canLandHit_SE);
        
        System.out.println("[231] " + "minDistToEnemy_S = " + minDistToEnemy_S + ", " + "targetLoc_S.x = " + targetLoc_S.x + ", " + "canMove_S = " + canMove_S + ", " + "targetLoc_S.y = " + targetLoc_S.y + ", " + "penalty_S = " + penalty_S + ", " + "healthDmgAttackRange_S = " + healthDmgAttackRange_S + ", " + "myHealthDmg_S = " + myHealthDmg_S + ", " + "towerHealth_S = " + towerHealth_S + ", " + "canBeHit_S = " + canBeHit_S + ", " + "canLandHit_S = " + canLandHit_S);
        
        System.out.println("[231] " + "minDistToEnemy_SW = " + minDistToEnemy_SW + ", " + "targetLoc_SW.x = " + targetLoc_SW.x + ", " + "canMove_SW = " + canMove_SW + ", " + "targetLoc_SW.y = " + targetLoc_SW.y + ", " + "penalty_SW = " + penalty_SW + ", " + "healthDmgAttackRange_SW = " + healthDmgAttackRange_SW + ", " + "myHealthDmg_SW = " + myHealthDmg_SW + ", " + "towerHealth_SW = " + towerHealth_SW + ", " + "canBeHit_SW = " + canBeHit_SW + ", " + "canLandHit_SW = " + canLandHit_SW);
        
        System.out.println("[231] " + "minDistToEnemy_W = " + minDistToEnemy_W + ", " + "targetLoc_W.x = " + targetLoc_W.x + ", " + "canMove_W = " + canMove_W + ", " + "targetLoc_W.y = " + targetLoc_W.y + ", " + "penalty_W = " + penalty_W + ", " + "healthDmgAttackRange_W = " + healthDmgAttackRange_W + ", " + "myHealthDmg_W = " + myHealthDmg_W + ", " + "towerHealth_W = " + towerHealth_W + ", " + "canBeHit_W = " + canBeHit_W + ", " + "canLandHit_W = " + canLandHit_W);
        
        System.out.println("[231] " + "minDistToEnemy_NW = " + minDistToEnemy_NW + ", " + "targetLoc_NW.x = " + targetLoc_NW.x + ", " + "canMove_NW = " + canMove_NW + ", " + "targetLoc_NW.y = " + targetLoc_NW.y + ", " + "penalty_NW = " + penalty_NW + ", " + "healthDmgAttackRange_NW = " + healthDmgAttackRange_NW + ", " + "myHealthDmg_NW = " + myHealthDmg_NW + ", " + "towerHealth_NW = " + towerHealth_NW + ", " + "canBeHit_NW = " + canBeHit_NW + ", " + "canLandHit_NW = " + canLandHit_NW);
        
        System.out.println("[231] " + "minDistToEnemy_C = " + minDistToEnemy_C + ", " + "targetLoc_C.x = " + targetLoc_C.x + ", " + "canMove_C = " + canMove_C + ", " + "targetLoc_C.y = " + targetLoc_C.y + ", " + "penalty_C = " + penalty_C + ", " + "healthDmgAttackRange_C = " + healthDmgAttackRange_C + ", " + "myHealthDmg_C = " + myHealthDmg_C + ", " + "towerHealth_C = " + towerHealth_C + ", " + "canBeHit_C = " + canBeHit_C + ", " + "canLandHit_C = " + canLandHit_C);
        

        boolean bestWins = false;
        Direction bestDir = Direction.NORTH;
        MapLocation targetLoc_best = SquareManager.m23;
        boolean canMove_best = (rc.canMove(Direction.NORTH));
        double healthDmgAttackRange_best = 0;
        double myHealthDmg_best = 0;
        int minDistToEnemy_best = 100000;
        int penalty_best = SquareManager.penalty23;
        int towerHealth_best = 1000000;
        boolean canBeHit_best = false;
        boolean canLandHit_best = false;
        
        
        targetLoc_best = targetLoc_N;
        canMove_best = canMove_N;
        healthDmgAttackRange_best = healthDmgAttackRange_N;
        myHealthDmg_best = myHealthDmg_N;
        minDistToEnemy_best = minDistToEnemy_N;
        penalty_best = penalty_N;
        towerHealth_best = towerHealth_N;
        canBeHit_best = canBeHit_N;
        canLandHit_best = canLandHit_N;
        
        bestWins = canMove_best;
        chooseBest0NE: {
            if (!canMove_NE || !canMove_best) break chooseBest0NE;

            // Choose the square where I deal the most net damage.
            double bestHealthDmgDiff = healthDmgAttackRange_best - myHealthDmg_best;
            double otherHealthDmgDiff = healthDmgAttackRange_NE - myHealthDmg_NE;
            if (bestHealthDmgDiff != otherHealthDmgDiff) {
                bestWins = (bestHealthDmgDiff < otherHealthDmgDiff);
                break chooseBest0NE;
            }

            if (actionReady) {
                // If I can attack at either square, prefer the one which lets me attack a low health tower.
                if (canLandHit_best && canLandHit_NE) {
                    if (towerHealth_best != towerHealth_NE) {
                        bestWins = towerHealth_best < towerHealth_NE;
                        break chooseBest0NE;
                    }
                }

                // If I can attack, choose the square which lets me land a hit.
                if (canLandHit_best != canLandHit_NE) {
                    bestWins = canLandHit_best;
                    break chooseBest0NE;
                }
            } else {
                // If I can't attack, choose the square which gets me out of action radius.
                if (canBeHit_best != canBeHit_NE) {
                    bestWins = !canBeHit_best;
                    break chooseBest0NE;
                }
            }

            // If both squares are in action radius, prefer the one which lets you get out of action radius.
            if (canBeHit_best && canBeHit_NE) {
                if ((minDistToEnemy_best <= 2) != (minDistToEnemy_NE <= 2)) {
                    bestWins = !(minDistToEnemy_best <= 2);
                    break chooseBest0NE;
                }
            }

            // If I can't land a hit at either square, prefer the one which is closer.
            // This is necessary if we're far away, but if we can already land a hit,
            // Then there's really no difference between these two squares, so we should go for penalty instead.
            else if (!canLandHit_C && !canLandHit_best && !canLandHit_NE) {
                if (minDistToEnemy_best != minDistToEnemy_NE) {
                    bestWins = minDistToEnemy_best < minDistToEnemy_NE;
                    break chooseBest0NE;
                }
            }

            // All else equal, prefer the square with better paint penalty.
            bestWins = (penalty_best <= penalty_NE);
            break chooseBest0NE;
        }
        
        
        if (!bestWins) {
            targetLoc_best = targetLoc_NE;
            canMove_best = canMove_NE;
            healthDmgAttackRange_best = healthDmgAttackRange_NE;
            myHealthDmg_best = myHealthDmg_NE;
            minDistToEnemy_best = minDistToEnemy_NE;
            penalty_best = penalty_NE;
            towerHealth_best = towerHealth_NE;
            canBeHit_best = canBeHit_NE;
            canLandHit_best = canLandHit_NE;
            bestDir = Direction.NORTHEAST;
        }
        
        
        bestWins = canMove_best;
        chooseBest0E: {
            if (!canMove_E || !canMove_best) break chooseBest0E;

            // Choose the square where I deal the most net damage.
            double bestHealthDmgDiff = healthDmgAttackRange_best - myHealthDmg_best;
            double otherHealthDmgDiff = healthDmgAttackRange_E - myHealthDmg_E;
            if (bestHealthDmgDiff != otherHealthDmgDiff) {
                bestWins = (bestHealthDmgDiff < otherHealthDmgDiff);
                break chooseBest0E;
            }

            if (actionReady) {
                // If I can attack at either square, prefer the one which lets me attack a low health tower.
                if (canLandHit_best && canLandHit_E) {
                    if (towerHealth_best != towerHealth_E) {
                        bestWins = towerHealth_best < towerHealth_E;
                        break chooseBest0E;
                    }
                }

                // If I can attack, choose the square which lets me land a hit.
                if (canLandHit_best != canLandHit_E) {
                    bestWins = canLandHit_best;
                    break chooseBest0E;
                }
            } else {
                // If I can't attack, choose the square which gets me out of action radius.
                if (canBeHit_best != canBeHit_E) {
                    bestWins = !canBeHit_best;
                    break chooseBest0E;
                }
            }

            // If both squares are in action radius, prefer the one which lets you get out of action radius.
            if (canBeHit_best && canBeHit_E) {
                if ((minDistToEnemy_best <= 2) != (minDistToEnemy_E <= 2)) {
                    bestWins = !(minDistToEnemy_best <= 2);
                    break chooseBest0E;
                }
            }

            // If I can't land a hit at either square, prefer the one which is closer.
            // This is necessary if we're far away, but if we can already land a hit,
            // Then there's really no difference between these two squares, so we should go for penalty instead.
            else if (!canLandHit_C && !canLandHit_best && !canLandHit_E) {
                if (minDistToEnemy_best != minDistToEnemy_E) {
                    bestWins = minDistToEnemy_best < minDistToEnemy_E;
                    break chooseBest0E;
                }
            }

            // All else equal, prefer the square with better paint penalty.
            bestWins = (penalty_best <= penalty_E);
            break chooseBest0E;
        }
        
        
        if (!bestWins) {
            targetLoc_best = targetLoc_E;
            canMove_best = canMove_E;
            healthDmgAttackRange_best = healthDmgAttackRange_E;
            myHealthDmg_best = myHealthDmg_E;
            minDistToEnemy_best = minDistToEnemy_E;
            penalty_best = penalty_E;
            towerHealth_best = towerHealth_E;
            canBeHit_best = canBeHit_E;
            canLandHit_best = canLandHit_E;
            bestDir = Direction.EAST;
        }
        
        
        bestWins = canMove_best;
        chooseBest0SE: {
            if (!canMove_SE || !canMove_best) break chooseBest0SE;

            // Choose the square where I deal the most net damage.
            double bestHealthDmgDiff = healthDmgAttackRange_best - myHealthDmg_best;
            double otherHealthDmgDiff = healthDmgAttackRange_SE - myHealthDmg_SE;
            if (bestHealthDmgDiff != otherHealthDmgDiff) {
                bestWins = (bestHealthDmgDiff < otherHealthDmgDiff);
                break chooseBest0SE;
            }

            if (actionReady) {
                // If I can attack at either square, prefer the one which lets me attack a low health tower.
                if (canLandHit_best && canLandHit_SE) {
                    if (towerHealth_best != towerHealth_SE) {
                        bestWins = towerHealth_best < towerHealth_SE;
                        break chooseBest0SE;
                    }
                }

                // If I can attack, choose the square which lets me land a hit.
                if (canLandHit_best != canLandHit_SE) {
                    bestWins = canLandHit_best;
                    break chooseBest0SE;
                }
            } else {
                // If I can't attack, choose the square which gets me out of action radius.
                if (canBeHit_best != canBeHit_SE) {
                    bestWins = !canBeHit_best;
                    break chooseBest0SE;
                }
            }

            // If both squares are in action radius, prefer the one which lets you get out of action radius.
            if (canBeHit_best && canBeHit_SE) {
                if ((minDistToEnemy_best <= 2) != (minDistToEnemy_SE <= 2)) {
                    bestWins = !(minDistToEnemy_best <= 2);
                    break chooseBest0SE;
                }
            }

            // If I can't land a hit at either square, prefer the one which is closer.
            // This is necessary if we're far away, but if we can already land a hit,
            // Then there's really no difference between these two squares, so we should go for penalty instead.
            else if (!canLandHit_C && !canLandHit_best && !canLandHit_SE) {
                if (minDistToEnemy_best != minDistToEnemy_SE) {
                    bestWins = minDistToEnemy_best < minDistToEnemy_SE;
                    break chooseBest0SE;
                }
            }

            // All else equal, prefer the square with better paint penalty.
            bestWins = (penalty_best <= penalty_SE);
            break chooseBest0SE;
        }
        
        
        if (!bestWins) {
            targetLoc_best = targetLoc_SE;
            canMove_best = canMove_SE;
            healthDmgAttackRange_best = healthDmgAttackRange_SE;
            myHealthDmg_best = myHealthDmg_SE;
            minDistToEnemy_best = minDistToEnemy_SE;
            penalty_best = penalty_SE;
            towerHealth_best = towerHealth_SE;
            canBeHit_best = canBeHit_SE;
            canLandHit_best = canLandHit_SE;
            bestDir = Direction.SOUTHEAST;
        }
        
        
        bestWins = canMove_best;
        chooseBest0S: {
            if (!canMove_S || !canMove_best) break chooseBest0S;

            // Choose the square where I deal the most net damage.
            double bestHealthDmgDiff = healthDmgAttackRange_best - myHealthDmg_best;
            double otherHealthDmgDiff = healthDmgAttackRange_S - myHealthDmg_S;
            if (bestHealthDmgDiff != otherHealthDmgDiff) {
                bestWins = (bestHealthDmgDiff < otherHealthDmgDiff);
                break chooseBest0S;
            }

            if (actionReady) {
                // If I can attack at either square, prefer the one which lets me attack a low health tower.
                if (canLandHit_best && canLandHit_S) {
                    if (towerHealth_best != towerHealth_S) {
                        bestWins = towerHealth_best < towerHealth_S;
                        break chooseBest0S;
                    }
                }

                // If I can attack, choose the square which lets me land a hit.
                if (canLandHit_best != canLandHit_S) {
                    bestWins = canLandHit_best;
                    break chooseBest0S;
                }
            } else {
                // If I can't attack, choose the square which gets me out of action radius.
                if (canBeHit_best != canBeHit_S) {
                    bestWins = !canBeHit_best;
                    break chooseBest0S;
                }
            }

            // If both squares are in action radius, prefer the one which lets you get out of action radius.
            if (canBeHit_best && canBeHit_S) {
                if ((minDistToEnemy_best <= 2) != (minDistToEnemy_S <= 2)) {
                    bestWins = !(minDistToEnemy_best <= 2);
                    break chooseBest0S;
                }
            }

            // If I can't land a hit at either square, prefer the one which is closer.
            // This is necessary if we're far away, but if we can already land a hit,
            // Then there's really no difference between these two squares, so we should go for penalty instead.
            else if (!canLandHit_C && !canLandHit_best && !canLandHit_S) {
                if (minDistToEnemy_best != minDistToEnemy_S) {
                    bestWins = minDistToEnemy_best < minDistToEnemy_S;
                    break chooseBest0S;
                }
            }

            // All else equal, prefer the square with better paint penalty.
            bestWins = (penalty_best <= penalty_S);
            break chooseBest0S;
        }
        
        
        if (!bestWins) {
            targetLoc_best = targetLoc_S;
            canMove_best = canMove_S;
            healthDmgAttackRange_best = healthDmgAttackRange_S;
            myHealthDmg_best = myHealthDmg_S;
            minDistToEnemy_best = minDistToEnemy_S;
            penalty_best = penalty_S;
            towerHealth_best = towerHealth_S;
            canBeHit_best = canBeHit_S;
            canLandHit_best = canLandHit_S;
            bestDir = Direction.SOUTH;
        }
        
        
        bestWins = canMove_best;
        chooseBest0SW: {
            if (!canMove_SW || !canMove_best) break chooseBest0SW;

            // Choose the square where I deal the most net damage.
            double bestHealthDmgDiff = healthDmgAttackRange_best - myHealthDmg_best;
            double otherHealthDmgDiff = healthDmgAttackRange_SW - myHealthDmg_SW;
            if (bestHealthDmgDiff != otherHealthDmgDiff) {
                bestWins = (bestHealthDmgDiff < otherHealthDmgDiff);
                break chooseBest0SW;
            }

            if (actionReady) {
                // If I can attack at either square, prefer the one which lets me attack a low health tower.
                if (canLandHit_best && canLandHit_SW) {
                    if (towerHealth_best != towerHealth_SW) {
                        bestWins = towerHealth_best < towerHealth_SW;
                        break chooseBest0SW;
                    }
                }

                // If I can attack, choose the square which lets me land a hit.
                if (canLandHit_best != canLandHit_SW) {
                    bestWins = canLandHit_best;
                    break chooseBest0SW;
                }
            } else {
                // If I can't attack, choose the square which gets me out of action radius.
                if (canBeHit_best != canBeHit_SW) {
                    bestWins = !canBeHit_best;
                    break chooseBest0SW;
                }
            }

            // If both squares are in action radius, prefer the one which lets you get out of action radius.
            if (canBeHit_best && canBeHit_SW) {
                if ((minDistToEnemy_best <= 2) != (minDistToEnemy_SW <= 2)) {
                    bestWins = !(minDistToEnemy_best <= 2);
                    break chooseBest0SW;
                }
            }

            // If I can't land a hit at either square, prefer the one which is closer.
            // This is necessary if we're far away, but if we can already land a hit,
            // Then there's really no difference between these two squares, so we should go for penalty instead.
            else if (!canLandHit_C && !canLandHit_best && !canLandHit_SW) {
                if (minDistToEnemy_best != minDistToEnemy_SW) {
                    bestWins = minDistToEnemy_best < minDistToEnemy_SW;
                    break chooseBest0SW;
                }
            }

            // All else equal, prefer the square with better paint penalty.
            bestWins = (penalty_best <= penalty_SW);
            break chooseBest0SW;
        }
        
        
        if (!bestWins) {
            targetLoc_best = targetLoc_SW;
            canMove_best = canMove_SW;
            healthDmgAttackRange_best = healthDmgAttackRange_SW;
            myHealthDmg_best = myHealthDmg_SW;
            minDistToEnemy_best = minDistToEnemy_SW;
            penalty_best = penalty_SW;
            towerHealth_best = towerHealth_SW;
            canBeHit_best = canBeHit_SW;
            canLandHit_best = canLandHit_SW;
            bestDir = Direction.SOUTHWEST;
        }
        
        
        bestWins = canMove_best;
        chooseBest0W: {
            if (!canMove_W || !canMove_best) break chooseBest0W;

            // Choose the square where I deal the most net damage.
            double bestHealthDmgDiff = healthDmgAttackRange_best - myHealthDmg_best;
            double otherHealthDmgDiff = healthDmgAttackRange_W - myHealthDmg_W;
            if (bestHealthDmgDiff != otherHealthDmgDiff) {
                bestWins = (bestHealthDmgDiff < otherHealthDmgDiff);
                break chooseBest0W;
            }

            if (actionReady) {
                // If I can attack at either square, prefer the one which lets me attack a low health tower.
                if (canLandHit_best && canLandHit_W) {
                    if (towerHealth_best != towerHealth_W) {
                        bestWins = towerHealth_best < towerHealth_W;
                        break chooseBest0W;
                    }
                }

                // If I can attack, choose the square which lets me land a hit.
                if (canLandHit_best != canLandHit_W) {
                    bestWins = canLandHit_best;
                    break chooseBest0W;
                }
            } else {
                // If I can't attack, choose the square which gets me out of action radius.
                if (canBeHit_best != canBeHit_W) {
                    bestWins = !canBeHit_best;
                    break chooseBest0W;
                }
            }

            // If both squares are in action radius, prefer the one which lets you get out of action radius.
            if (canBeHit_best && canBeHit_W) {
                if ((minDistToEnemy_best <= 2) != (minDistToEnemy_W <= 2)) {
                    bestWins = !(minDistToEnemy_best <= 2);
                    break chooseBest0W;
                }
            }

            // If I can't land a hit at either square, prefer the one which is closer.
            // This is necessary if we're far away, but if we can already land a hit,
            // Then there's really no difference between these two squares, so we should go for penalty instead.
            else if (!canLandHit_C && !canLandHit_best && !canLandHit_W) {
                if (minDistToEnemy_best != minDistToEnemy_W) {
                    bestWins = minDistToEnemy_best < minDistToEnemy_W;
                    break chooseBest0W;
                }
            }

            // All else equal, prefer the square with better paint penalty.
            bestWins = (penalty_best <= penalty_W);
            break chooseBest0W;
        }
        
        
        if (!bestWins) {
            targetLoc_best = targetLoc_W;
            canMove_best = canMove_W;
            healthDmgAttackRange_best = healthDmgAttackRange_W;
            myHealthDmg_best = myHealthDmg_W;
            minDistToEnemy_best = minDistToEnemy_W;
            penalty_best = penalty_W;
            towerHealth_best = towerHealth_W;
            canBeHit_best = canBeHit_W;
            canLandHit_best = canLandHit_W;
            bestDir = Direction.WEST;
        }
        
        
        bestWins = canMove_best;
        chooseBest0NW: {
            if (!canMove_NW || !canMove_best) break chooseBest0NW;

            // Choose the square where I deal the most net damage.
            double bestHealthDmgDiff = healthDmgAttackRange_best - myHealthDmg_best;
            double otherHealthDmgDiff = healthDmgAttackRange_NW - myHealthDmg_NW;
            if (bestHealthDmgDiff != otherHealthDmgDiff) {
                bestWins = (bestHealthDmgDiff < otherHealthDmgDiff);
                break chooseBest0NW;
            }

            if (actionReady) {
                // If I can attack at either square, prefer the one which lets me attack a low health tower.
                if (canLandHit_best && canLandHit_NW) {
                    if (towerHealth_best != towerHealth_NW) {
                        bestWins = towerHealth_best < towerHealth_NW;
                        break chooseBest0NW;
                    }
                }

                // If I can attack, choose the square which lets me land a hit.
                if (canLandHit_best != canLandHit_NW) {
                    bestWins = canLandHit_best;
                    break chooseBest0NW;
                }
            } else {
                // If I can't attack, choose the square which gets me out of action radius.
                if (canBeHit_best != canBeHit_NW) {
                    bestWins = !canBeHit_best;
                    break chooseBest0NW;
                }
            }

            // If both squares are in action radius, prefer the one which lets you get out of action radius.
            if (canBeHit_best && canBeHit_NW) {
                if ((minDistToEnemy_best <= 2) != (minDistToEnemy_NW <= 2)) {
                    bestWins = !(minDistToEnemy_best <= 2);
                    break chooseBest0NW;
                }
            }

            // If I can't land a hit at either square, prefer the one which is closer.
            // This is necessary if we're far away, but if we can already land a hit,
            // Then there's really no difference between these two squares, so we should go for penalty instead.
            else if (!canLandHit_C && !canLandHit_best && !canLandHit_NW) {
                if (minDistToEnemy_best != minDistToEnemy_NW) {
                    bestWins = minDistToEnemy_best < minDistToEnemy_NW;
                    break chooseBest0NW;
                }
            }

            // All else equal, prefer the square with better paint penalty.
            bestWins = (penalty_best <= penalty_NW);
            break chooseBest0NW;
        }
        
        
        if (!bestWins) {
            targetLoc_best = targetLoc_NW;
            canMove_best = canMove_NW;
            healthDmgAttackRange_best = healthDmgAttackRange_NW;
            myHealthDmg_best = myHealthDmg_NW;
            minDistToEnemy_best = minDistToEnemy_NW;
            penalty_best = penalty_NW;
            towerHealth_best = towerHealth_NW;
            canBeHit_best = canBeHit_NW;
            canLandHit_best = canLandHit_NW;
            bestDir = Direction.NORTHWEST;
        }
        
        
        bestWins = canMove_best;
        chooseBest0C: {
            if (!canMove_C || !canMove_best) break chooseBest0C;

            // Choose the square where I deal the most net damage.
            double bestHealthDmgDiff = healthDmgAttackRange_best - myHealthDmg_best;
            double otherHealthDmgDiff = healthDmgAttackRange_C - myHealthDmg_C;
            if (bestHealthDmgDiff != otherHealthDmgDiff) {
                bestWins = (bestHealthDmgDiff < otherHealthDmgDiff);
                break chooseBest0C;
            }

            if (actionReady) {
                // If I can attack at either square, prefer the one which lets me attack a low health tower.
                if (canLandHit_best && canLandHit_C) {
                    if (towerHealth_best != towerHealth_C) {
                        bestWins = towerHealth_best < towerHealth_C;
                        break chooseBest0C;
                    }
                }

                // If I can attack, choose the square which lets me land a hit.
                if (canLandHit_best != canLandHit_C) {
                    bestWins = canLandHit_best;
                    break chooseBest0C;
                }
            } else {
                // If I can't attack, choose the square which gets me out of action radius.
                if (canBeHit_best != canBeHit_C) {
                    bestWins = !canBeHit_best;
                    break chooseBest0C;
                }
            }

            // If both squares are in action radius, prefer the one which lets you get out of action radius.
            if (canBeHit_best && canBeHit_C) {
                if ((minDistToEnemy_best <= 2) != (minDistToEnemy_C <= 2)) {
                    bestWins = !(minDistToEnemy_best <= 2);
                    break chooseBest0C;
                }
            }

            // If I can't land a hit at either square, prefer the one which is closer.
            // This is necessary if we're far away, but if we can already land a hit,
            // Then there's really no difference between these two squares, so we should go for penalty instead.
            else if (!canLandHit_C && !canLandHit_best && !canLandHit_C) {
                if (minDistToEnemy_best != minDistToEnemy_C) {
                    bestWins = minDistToEnemy_best < minDistToEnemy_C;
                    break chooseBest0C;
                }
            }

            // All else equal, prefer the square with better paint penalty.
            bestWins = (penalty_best <= penalty_C);
            break chooseBest0C;
        }
        
        
        if (!bestWins) {
            targetLoc_best = targetLoc_C;
            canMove_best = canMove_C;
            healthDmgAttackRange_best = healthDmgAttackRange_C;
            myHealthDmg_best = myHealthDmg_C;
            minDistToEnemy_best = minDistToEnemy_C;
            penalty_best = penalty_C;
            towerHealth_best = towerHealth_C;
            canBeHit_best = canBeHit_C;
            canLandHit_best = canLandHit_C;
            bestDir = Direction.CENTER;
        }
        
        

        
        System.out.println("[246] " + "minDistToEnemy_best = " + minDistToEnemy_best + ", " + "targetLoc_best.x = " + targetLoc_best.x + ", " + "canMove_best = " + canMove_best + ", " + "targetLoc_best.y = " + targetLoc_best.y + ", " + "penalty_best = " + penalty_best + ", " + "healthDmgAttackRange_best = " + healthDmgAttackRange_best + ", " + "myHealthDmg_best = " + myHealthDmg_best + ", " + "towerHealth_best = " + towerHealth_best + ", " + "canBeHit_best = " + canBeHit_best + ", " + "canLandHit_best = " + canLandHit_best);
        System.out.println("Chose: " + bestDir);
        System.out.println("\n");

        if (rc.canMove(bestDir)) {
            Pathing.move(bestDir);
        }
        soldierTryAttack();
    }
    
    
    public static void splasherAttackMicro() throws GameActionException {
        splasherTryAttack();
        MapLocation myloc = rc.getLocation();
        SquareManager.computePaintPenalties();
        MapLocation targetLoc_N = SquareManager.m23;
        boolean canMove_N = (rc.canMove(Direction.NORTH));
        double healthDmgAttackRange_N = 0;
        double myHealthDmg_N = 0;
        int minDistToEnemy_N = 100000;
        int penalty_N = SquareManager.penalty23;
        int towerHealth_N = 1000000;
        boolean canBeHit_N = false;
        boolean canLandHit_N = false;
        
        MapLocation targetLoc_NE = SquareManager.m33;
        boolean canMove_NE = (rc.canMove(Direction.NORTHEAST));
        double healthDmgAttackRange_NE = 0;
        double myHealthDmg_NE = 0;
        int minDistToEnemy_NE = 100000;
        int penalty_NE = SquareManager.penalty33;
        int towerHealth_NE = 1000000;
        boolean canBeHit_NE = false;
        boolean canLandHit_NE = false;
        
        MapLocation targetLoc_E = SquareManager.m32;
        boolean canMove_E = (rc.canMove(Direction.EAST));
        double healthDmgAttackRange_E = 0;
        double myHealthDmg_E = 0;
        int minDistToEnemy_E = 100000;
        int penalty_E = SquareManager.penalty32;
        int towerHealth_E = 1000000;
        boolean canBeHit_E = false;
        boolean canLandHit_E = false;
        
        MapLocation targetLoc_SE = SquareManager.m31;
        boolean canMove_SE = (rc.canMove(Direction.SOUTHEAST));
        double healthDmgAttackRange_SE = 0;
        double myHealthDmg_SE = 0;
        int minDistToEnemy_SE = 100000;
        int penalty_SE = SquareManager.penalty31;
        int towerHealth_SE = 1000000;
        boolean canBeHit_SE = false;
        boolean canLandHit_SE = false;
        
        MapLocation targetLoc_S = SquareManager.m21;
        boolean canMove_S = (rc.canMove(Direction.SOUTH));
        double healthDmgAttackRange_S = 0;
        double myHealthDmg_S = 0;
        int minDistToEnemy_S = 100000;
        int penalty_S = SquareManager.penalty21;
        int towerHealth_S = 1000000;
        boolean canBeHit_S = false;
        boolean canLandHit_S = false;
        
        MapLocation targetLoc_SW = SquareManager.m11;
        boolean canMove_SW = (rc.canMove(Direction.SOUTHWEST));
        double healthDmgAttackRange_SW = 0;
        double myHealthDmg_SW = 0;
        int minDistToEnemy_SW = 100000;
        int penalty_SW = SquareManager.penalty11;
        int towerHealth_SW = 1000000;
        boolean canBeHit_SW = false;
        boolean canLandHit_SW = false;
        
        MapLocation targetLoc_W = SquareManager.m12;
        boolean canMove_W = (rc.canMove(Direction.WEST));
        double healthDmgAttackRange_W = 0;
        double myHealthDmg_W = 0;
        int minDistToEnemy_W = 100000;
        int penalty_W = SquareManager.penalty12;
        int towerHealth_W = 1000000;
        boolean canBeHit_W = false;
        boolean canLandHit_W = false;
        
        MapLocation targetLoc_NW = SquareManager.m13;
        boolean canMove_NW = (rc.canMove(Direction.NORTHWEST));
        double healthDmgAttackRange_NW = 0;
        double myHealthDmg_NW = 0;
        int minDistToEnemy_NW = 100000;
        int penalty_NW = SquareManager.penalty13;
        int towerHealth_NW = 1000000;
        boolean canBeHit_NW = false;
        boolean canLandHit_NW = false;
        
        MapLocation targetLoc_C = SquareManager.m22;
        boolean canMove_C = (true);
        double healthDmgAttackRange_C = 0;
        double myHealthDmg_C = 0;
        int minDistToEnemy_C = 100000;
        int penalty_C = SquareManager.penalty22;
        int towerHealth_C = 1000000;
        boolean canBeHit_C = false;
        boolean canLandHit_C = false;
        
        boolean friendNearby = false;
        for (RobotInfo r: Globals.friends) {
            if (r.type == UnitType.SOLDIER) {
                friendNearby = true;
                break;
            }
        }
        boolean shouldWaitForFriend = (friendNearby && (rc.getRoundNum() % 2 == 0));

        // Use GameConstant.
        boolean actionReady = (rc.isActionReady() && (rc.getPaint() >= 5) && !shouldWaitForFriend);
        int cooldownTurns = rc.getActionCooldownTurns();
        
        for (int i = Globals.friends.length; --i >= 0; ) {
            RobotInfo robot = Globals.friends[i];
            addAlly0N: {
                
            }
            addAlly0NE: {
                
            }
            addAlly0E: {
                
            }
            addAlly0SE: {
                
            }
            addAlly0S: {
                
            }
            addAlly0SW: {
                
            }
            addAlly0W: {
                
            }
            addAlly0NW: {
                
            }
            addAlly0C: {
                
            }
            
        }

        for (int i = Globals.enemies.length; --i >= 0; ) {
            RobotInfo robot = Globals.enemies[i];
            
            addEnemy0N: {
                if (!canMove_N) break addEnemy0N;
                int d = targetLoc_N.distanceSquaredTo(robot.location);
                switch (robot.type) {
                    case MOPPER: {
                        // Expected Paint taken.
                        if (d <= UnitType.MOPPER.actionRadiusSquared) {
                            penalty_N += 3.3;
                        } else if (d <= 8) {
                            penalty_N += 2.5;
                        }
                        break addEnemy0N;
                    }
                    case LEVEL_ONE_DEFENSE_TOWER: {
                        if (actionReady && d <= splasherActionRadiusSquared) {
                            
                            myHealthDmg_N = splasherAoeAttackStrength;
                            
                            towerHealth_N = Math.min(towerHealth_N, robot.health);
                            canLandHit_N = true;
                        }
                        if (d <= UnitType.LEVEL_ONE_DEFENSE_TOWER.actionRadiusSquared) {
                            // Should have another one for AOE damage.
                            healthDmgAttackRange_N += UnitType.LEVEL_ONE_DEFENSE_TOWER.attackStrength;
                            canBeHit_N = true;
                        }

                        if (d < minDistToEnemy_N) minDistToEnemy_N = d;
                        break addEnemy0N;
                    }
                    case LEVEL_ONE_MONEY_TOWER: {
                        if (actionReady && d <= splasherActionRadiusSquared) {
                            
                            myHealthDmg_N = splasherAoeAttackStrength;
                            
                            towerHealth_N = Math.min(towerHealth_N, robot.health);
                            canLandHit_N = true;
                        }
                        if (d <= UnitType.LEVEL_ONE_MONEY_TOWER.actionRadiusSquared) {
                            // Should have another one for AOE damage.
                            healthDmgAttackRange_N += UnitType.LEVEL_ONE_MONEY_TOWER.attackStrength;
                            canBeHit_N = true;
                        }

                        if (d < minDistToEnemy_N) minDistToEnemy_N = d;
                        break addEnemy0N;
                    }
                    case LEVEL_ONE_PAINT_TOWER: {
                        if (actionReady && d <= splasherActionRadiusSquared) {
                            
                            myHealthDmg_N = splasherAoeAttackStrength;
                            
                            towerHealth_N = Math.min(towerHealth_N, robot.health);
                            canLandHit_N = true;
                        }
                        if (d <= UnitType.LEVEL_ONE_PAINT_TOWER.actionRadiusSquared) {
                            // Should have another one for AOE damage.
                            healthDmgAttackRange_N += UnitType.LEVEL_ONE_PAINT_TOWER.attackStrength;
                            canBeHit_N = true;
                        }

                        if (d < minDistToEnemy_N) minDistToEnemy_N = d;
                        break addEnemy0N;
                    }
                    case LEVEL_THREE_DEFENSE_TOWER: {
                        if (actionReady && d <= splasherActionRadiusSquared) {
                            
                            myHealthDmg_N = splasherAoeAttackStrength;
                            
                            towerHealth_N = Math.min(towerHealth_N, robot.health);
                            canLandHit_N = true;
                        }
                        if (d <= UnitType.LEVEL_THREE_DEFENSE_TOWER.actionRadiusSquared) {
                            // Should have another one for AOE damage.
                            healthDmgAttackRange_N += UnitType.LEVEL_THREE_DEFENSE_TOWER.attackStrength;
                            canBeHit_N = true;
                        }

                        if (d < minDistToEnemy_N) minDistToEnemy_N = d;
                        break addEnemy0N;
                    }
                    case LEVEL_THREE_MONEY_TOWER: {
                        if (actionReady && d <= splasherActionRadiusSquared) {
                            
                            myHealthDmg_N = splasherAoeAttackStrength;
                            
                            towerHealth_N = Math.min(towerHealth_N, robot.health);
                            canLandHit_N = true;
                        }
                        if (d <= UnitType.LEVEL_THREE_MONEY_TOWER.actionRadiusSquared) {
                            // Should have another one for AOE damage.
                            healthDmgAttackRange_N += UnitType.LEVEL_THREE_MONEY_TOWER.attackStrength;
                            canBeHit_N = true;
                        }

                        if (d < minDistToEnemy_N) minDistToEnemy_N = d;
                        break addEnemy0N;
                    }
                    case LEVEL_THREE_PAINT_TOWER: {
                        if (actionReady && d <= splasherActionRadiusSquared) {
                            
                            myHealthDmg_N = splasherAoeAttackStrength;
                            
                            towerHealth_N = Math.min(towerHealth_N, robot.health);
                            canLandHit_N = true;
                        }
                        if (d <= UnitType.LEVEL_THREE_PAINT_TOWER.actionRadiusSquared) {
                            // Should have another one for AOE damage.
                            healthDmgAttackRange_N += UnitType.LEVEL_THREE_PAINT_TOWER.attackStrength;
                            canBeHit_N = true;
                        }

                        if (d < minDistToEnemy_N) minDistToEnemy_N = d;
                        break addEnemy0N;
                    }
                    case LEVEL_TWO_DEFENSE_TOWER: {
                        if (actionReady && d <= splasherActionRadiusSquared) {
                            
                            myHealthDmg_N = splasherAoeAttackStrength;
                            
                            towerHealth_N = Math.min(towerHealth_N, robot.health);
                            canLandHit_N = true;
                        }
                        if (d <= UnitType.LEVEL_TWO_DEFENSE_TOWER.actionRadiusSquared) {
                            // Should have another one for AOE damage.
                            healthDmgAttackRange_N += UnitType.LEVEL_TWO_DEFENSE_TOWER.attackStrength;
                            canBeHit_N = true;
                        }

                        if (d < minDistToEnemy_N) minDistToEnemy_N = d;
                        break addEnemy0N;
                    }
                    case LEVEL_TWO_MONEY_TOWER: {
                        if (actionReady && d <= splasherActionRadiusSquared) {
                            
                            myHealthDmg_N = splasherAoeAttackStrength;
                            
                            towerHealth_N = Math.min(towerHealth_N, robot.health);
                            canLandHit_N = true;
                        }
                        if (d <= UnitType.LEVEL_TWO_MONEY_TOWER.actionRadiusSquared) {
                            // Should have another one for AOE damage.
                            healthDmgAttackRange_N += UnitType.LEVEL_TWO_MONEY_TOWER.attackStrength;
                            canBeHit_N = true;
                        }

                        if (d < minDistToEnemy_N) minDistToEnemy_N = d;
                        break addEnemy0N;
                    }
                    case LEVEL_TWO_PAINT_TOWER: {
                        if (actionReady && d <= splasherActionRadiusSquared) {
                            
                            myHealthDmg_N = splasherAoeAttackStrength;
                            
                            towerHealth_N = Math.min(towerHealth_N, robot.health);
                            canLandHit_N = true;
                        }
                        if (d <= UnitType.LEVEL_TWO_PAINT_TOWER.actionRadiusSquared) {
                            // Should have another one for AOE damage.
                            healthDmgAttackRange_N += UnitType.LEVEL_TWO_PAINT_TOWER.attackStrength;
                            canBeHit_N = true;
                        }

                        if (d < minDistToEnemy_N) minDistToEnemy_N = d;
                        break addEnemy0N;
                    }
                    
                    default: break addEnemy0N;
                }
            }
            
            addEnemy0NE: {
                if (!canMove_NE) break addEnemy0NE;
                int d = targetLoc_NE.distanceSquaredTo(robot.location);
                switch (robot.type) {
                    case MOPPER: {
                        // Expected Paint taken.
                        if (d <= UnitType.MOPPER.actionRadiusSquared) {
                            penalty_NE += 3.3;
                        } else if (d <= 8) {
                            penalty_NE += 2.5;
                        }
                        break addEnemy0NE;
                    }
                    case LEVEL_ONE_DEFENSE_TOWER: {
                        if (actionReady && d <= splasherActionRadiusSquared) {
                            
                            myHealthDmg_NE = splasherAoeAttackStrength;
                            
                            towerHealth_NE = Math.min(towerHealth_NE, robot.health);
                            canLandHit_NE = true;
                        }
                        if (d <= UnitType.LEVEL_ONE_DEFENSE_TOWER.actionRadiusSquared) {
                            // Should have another one for AOE damage.
                            healthDmgAttackRange_NE += UnitType.LEVEL_ONE_DEFENSE_TOWER.attackStrength;
                            canBeHit_NE = true;
                        }

                        if (d < minDistToEnemy_NE) minDistToEnemy_NE = d;
                        break addEnemy0NE;
                    }
                    case LEVEL_ONE_MONEY_TOWER: {
                        if (actionReady && d <= splasherActionRadiusSquared) {
                            
                            myHealthDmg_NE = splasherAoeAttackStrength;
                            
                            towerHealth_NE = Math.min(towerHealth_NE, robot.health);
                            canLandHit_NE = true;
                        }
                        if (d <= UnitType.LEVEL_ONE_MONEY_TOWER.actionRadiusSquared) {
                            // Should have another one for AOE damage.
                            healthDmgAttackRange_NE += UnitType.LEVEL_ONE_MONEY_TOWER.attackStrength;
                            canBeHit_NE = true;
                        }

                        if (d < minDistToEnemy_NE) minDistToEnemy_NE = d;
                        break addEnemy0NE;
                    }
                    case LEVEL_ONE_PAINT_TOWER: {
                        if (actionReady && d <= splasherActionRadiusSquared) {
                            
                            myHealthDmg_NE = splasherAoeAttackStrength;
                            
                            towerHealth_NE = Math.min(towerHealth_NE, robot.health);
                            canLandHit_NE = true;
                        }
                        if (d <= UnitType.LEVEL_ONE_PAINT_TOWER.actionRadiusSquared) {
                            // Should have another one for AOE damage.
                            healthDmgAttackRange_NE += UnitType.LEVEL_ONE_PAINT_TOWER.attackStrength;
                            canBeHit_NE = true;
                        }

                        if (d < minDistToEnemy_NE) minDistToEnemy_NE = d;
                        break addEnemy0NE;
                    }
                    case LEVEL_THREE_DEFENSE_TOWER: {
                        if (actionReady && d <= splasherActionRadiusSquared) {
                            
                            myHealthDmg_NE = splasherAoeAttackStrength;
                            
                            towerHealth_NE = Math.min(towerHealth_NE, robot.health);
                            canLandHit_NE = true;
                        }
                        if (d <= UnitType.LEVEL_THREE_DEFENSE_TOWER.actionRadiusSquared) {
                            // Should have another one for AOE damage.
                            healthDmgAttackRange_NE += UnitType.LEVEL_THREE_DEFENSE_TOWER.attackStrength;
                            canBeHit_NE = true;
                        }

                        if (d < minDistToEnemy_NE) minDistToEnemy_NE = d;
                        break addEnemy0NE;
                    }
                    case LEVEL_THREE_MONEY_TOWER: {
                        if (actionReady && d <= splasherActionRadiusSquared) {
                            
                            myHealthDmg_NE = splasherAoeAttackStrength;
                            
                            towerHealth_NE = Math.min(towerHealth_NE, robot.health);
                            canLandHit_NE = true;
                        }
                        if (d <= UnitType.LEVEL_THREE_MONEY_TOWER.actionRadiusSquared) {
                            // Should have another one for AOE damage.
                            healthDmgAttackRange_NE += UnitType.LEVEL_THREE_MONEY_TOWER.attackStrength;
                            canBeHit_NE = true;
                        }

                        if (d < minDistToEnemy_NE) minDistToEnemy_NE = d;
                        break addEnemy0NE;
                    }
                    case LEVEL_THREE_PAINT_TOWER: {
                        if (actionReady && d <= splasherActionRadiusSquared) {
                            
                            myHealthDmg_NE = splasherAoeAttackStrength;
                            
                            towerHealth_NE = Math.min(towerHealth_NE, robot.health);
                            canLandHit_NE = true;
                        }
                        if (d <= UnitType.LEVEL_THREE_PAINT_TOWER.actionRadiusSquared) {
                            // Should have another one for AOE damage.
                            healthDmgAttackRange_NE += UnitType.LEVEL_THREE_PAINT_TOWER.attackStrength;
                            canBeHit_NE = true;
                        }

                        if (d < minDistToEnemy_NE) minDistToEnemy_NE = d;
                        break addEnemy0NE;
                    }
                    case LEVEL_TWO_DEFENSE_TOWER: {
                        if (actionReady && d <= splasherActionRadiusSquared) {
                            
                            myHealthDmg_NE = splasherAoeAttackStrength;
                            
                            towerHealth_NE = Math.min(towerHealth_NE, robot.health);
                            canLandHit_NE = true;
                        }
                        if (d <= UnitType.LEVEL_TWO_DEFENSE_TOWER.actionRadiusSquared) {
                            // Should have another one for AOE damage.
                            healthDmgAttackRange_NE += UnitType.LEVEL_TWO_DEFENSE_TOWER.attackStrength;
                            canBeHit_NE = true;
                        }

                        if (d < minDistToEnemy_NE) minDistToEnemy_NE = d;
                        break addEnemy0NE;
                    }
                    case LEVEL_TWO_MONEY_TOWER: {
                        if (actionReady && d <= splasherActionRadiusSquared) {
                            
                            myHealthDmg_NE = splasherAoeAttackStrength;
                            
                            towerHealth_NE = Math.min(towerHealth_NE, robot.health);
                            canLandHit_NE = true;
                        }
                        if (d <= UnitType.LEVEL_TWO_MONEY_TOWER.actionRadiusSquared) {
                            // Should have another one for AOE damage.
                            healthDmgAttackRange_NE += UnitType.LEVEL_TWO_MONEY_TOWER.attackStrength;
                            canBeHit_NE = true;
                        }

                        if (d < minDistToEnemy_NE) minDistToEnemy_NE = d;
                        break addEnemy0NE;
                    }
                    case LEVEL_TWO_PAINT_TOWER: {
                        if (actionReady && d <= splasherActionRadiusSquared) {
                            
                            myHealthDmg_NE = splasherAoeAttackStrength;
                            
                            towerHealth_NE = Math.min(towerHealth_NE, robot.health);
                            canLandHit_NE = true;
                        }
                        if (d <= UnitType.LEVEL_TWO_PAINT_TOWER.actionRadiusSquared) {
                            // Should have another one for AOE damage.
                            healthDmgAttackRange_NE += UnitType.LEVEL_TWO_PAINT_TOWER.attackStrength;
                            canBeHit_NE = true;
                        }

                        if (d < minDistToEnemy_NE) minDistToEnemy_NE = d;
                        break addEnemy0NE;
                    }
                    
                    default: break addEnemy0NE;
                }
            }
            
            addEnemy0E: {
                if (!canMove_E) break addEnemy0E;
                int d = targetLoc_E.distanceSquaredTo(robot.location);
                switch (robot.type) {
                    case MOPPER: {
                        // Expected Paint taken.
                        if (d <= UnitType.MOPPER.actionRadiusSquared) {
                            penalty_E += 3.3;
                        } else if (d <= 8) {
                            penalty_E += 2.5;
                        }
                        break addEnemy0E;
                    }
                    case LEVEL_ONE_DEFENSE_TOWER: {
                        if (actionReady && d <= splasherActionRadiusSquared) {
                            
                            myHealthDmg_E = splasherAoeAttackStrength;
                            
                            towerHealth_E = Math.min(towerHealth_E, robot.health);
                            canLandHit_E = true;
                        }
                        if (d <= UnitType.LEVEL_ONE_DEFENSE_TOWER.actionRadiusSquared) {
                            // Should have another one for AOE damage.
                            healthDmgAttackRange_E += UnitType.LEVEL_ONE_DEFENSE_TOWER.attackStrength;
                            canBeHit_E = true;
                        }

                        if (d < minDistToEnemy_E) minDistToEnemy_E = d;
                        break addEnemy0E;
                    }
                    case LEVEL_ONE_MONEY_TOWER: {
                        if (actionReady && d <= splasherActionRadiusSquared) {
                            
                            myHealthDmg_E = splasherAoeAttackStrength;
                            
                            towerHealth_E = Math.min(towerHealth_E, robot.health);
                            canLandHit_E = true;
                        }
                        if (d <= UnitType.LEVEL_ONE_MONEY_TOWER.actionRadiusSquared) {
                            // Should have another one for AOE damage.
                            healthDmgAttackRange_E += UnitType.LEVEL_ONE_MONEY_TOWER.attackStrength;
                            canBeHit_E = true;
                        }

                        if (d < minDistToEnemy_E) minDistToEnemy_E = d;
                        break addEnemy0E;
                    }
                    case LEVEL_ONE_PAINT_TOWER: {
                        if (actionReady && d <= splasherActionRadiusSquared) {
                            
                            myHealthDmg_E = splasherAoeAttackStrength;
                            
                            towerHealth_E = Math.min(towerHealth_E, robot.health);
                            canLandHit_E = true;
                        }
                        if (d <= UnitType.LEVEL_ONE_PAINT_TOWER.actionRadiusSquared) {
                            // Should have another one for AOE damage.
                            healthDmgAttackRange_E += UnitType.LEVEL_ONE_PAINT_TOWER.attackStrength;
                            canBeHit_E = true;
                        }

                        if (d < minDistToEnemy_E) minDistToEnemy_E = d;
                        break addEnemy0E;
                    }
                    case LEVEL_THREE_DEFENSE_TOWER: {
                        if (actionReady && d <= splasherActionRadiusSquared) {
                            
                            myHealthDmg_E = splasherAoeAttackStrength;
                            
                            towerHealth_E = Math.min(towerHealth_E, robot.health);
                            canLandHit_E = true;
                        }
                        if (d <= UnitType.LEVEL_THREE_DEFENSE_TOWER.actionRadiusSquared) {
                            // Should have another one for AOE damage.
                            healthDmgAttackRange_E += UnitType.LEVEL_THREE_DEFENSE_TOWER.attackStrength;
                            canBeHit_E = true;
                        }

                        if (d < minDistToEnemy_E) minDistToEnemy_E = d;
                        break addEnemy0E;
                    }
                    case LEVEL_THREE_MONEY_TOWER: {
                        if (actionReady && d <= splasherActionRadiusSquared) {
                            
                            myHealthDmg_E = splasherAoeAttackStrength;
                            
                            towerHealth_E = Math.min(towerHealth_E, robot.health);
                            canLandHit_E = true;
                        }
                        if (d <= UnitType.LEVEL_THREE_MONEY_TOWER.actionRadiusSquared) {
                            // Should have another one for AOE damage.
                            healthDmgAttackRange_E += UnitType.LEVEL_THREE_MONEY_TOWER.attackStrength;
                            canBeHit_E = true;
                        }

                        if (d < minDistToEnemy_E) minDistToEnemy_E = d;
                        break addEnemy0E;
                    }
                    case LEVEL_THREE_PAINT_TOWER: {
                        if (actionReady && d <= splasherActionRadiusSquared) {
                            
                            myHealthDmg_E = splasherAoeAttackStrength;
                            
                            towerHealth_E = Math.min(towerHealth_E, robot.health);
                            canLandHit_E = true;
                        }
                        if (d <= UnitType.LEVEL_THREE_PAINT_TOWER.actionRadiusSquared) {
                            // Should have another one for AOE damage.
                            healthDmgAttackRange_E += UnitType.LEVEL_THREE_PAINT_TOWER.attackStrength;
                            canBeHit_E = true;
                        }

                        if (d < minDistToEnemy_E) minDistToEnemy_E = d;
                        break addEnemy0E;
                    }
                    case LEVEL_TWO_DEFENSE_TOWER: {
                        if (actionReady && d <= splasherActionRadiusSquared) {
                            
                            myHealthDmg_E = splasherAoeAttackStrength;
                            
                            towerHealth_E = Math.min(towerHealth_E, robot.health);
                            canLandHit_E = true;
                        }
                        if (d <= UnitType.LEVEL_TWO_DEFENSE_TOWER.actionRadiusSquared) {
                            // Should have another one for AOE damage.
                            healthDmgAttackRange_E += UnitType.LEVEL_TWO_DEFENSE_TOWER.attackStrength;
                            canBeHit_E = true;
                        }

                        if (d < minDistToEnemy_E) minDistToEnemy_E = d;
                        break addEnemy0E;
                    }
                    case LEVEL_TWO_MONEY_TOWER: {
                        if (actionReady && d <= splasherActionRadiusSquared) {
                            
                            myHealthDmg_E = splasherAoeAttackStrength;
                            
                            towerHealth_E = Math.min(towerHealth_E, robot.health);
                            canLandHit_E = true;
                        }
                        if (d <= UnitType.LEVEL_TWO_MONEY_TOWER.actionRadiusSquared) {
                            // Should have another one for AOE damage.
                            healthDmgAttackRange_E += UnitType.LEVEL_TWO_MONEY_TOWER.attackStrength;
                            canBeHit_E = true;
                        }

                        if (d < minDistToEnemy_E) minDistToEnemy_E = d;
                        break addEnemy0E;
                    }
                    case LEVEL_TWO_PAINT_TOWER: {
                        if (actionReady && d <= splasherActionRadiusSquared) {
                            
                            myHealthDmg_E = splasherAoeAttackStrength;
                            
                            towerHealth_E = Math.min(towerHealth_E, robot.health);
                            canLandHit_E = true;
                        }
                        if (d <= UnitType.LEVEL_TWO_PAINT_TOWER.actionRadiusSquared) {
                            // Should have another one for AOE damage.
                            healthDmgAttackRange_E += UnitType.LEVEL_TWO_PAINT_TOWER.attackStrength;
                            canBeHit_E = true;
                        }

                        if (d < minDistToEnemy_E) minDistToEnemy_E = d;
                        break addEnemy0E;
                    }
                    
                    default: break addEnemy0E;
                }
            }
            
            addEnemy0SE: {
                if (!canMove_SE) break addEnemy0SE;
                int d = targetLoc_SE.distanceSquaredTo(robot.location);
                switch (robot.type) {
                    case MOPPER: {
                        // Expected Paint taken.
                        if (d <= UnitType.MOPPER.actionRadiusSquared) {
                            penalty_SE += 3.3;
                        } else if (d <= 8) {
                            penalty_SE += 2.5;
                        }
                        break addEnemy0SE;
                    }
                    case LEVEL_ONE_DEFENSE_TOWER: {
                        if (actionReady && d <= splasherActionRadiusSquared) {
                            
                            myHealthDmg_SE = splasherAoeAttackStrength;
                            
                            towerHealth_SE = Math.min(towerHealth_SE, robot.health);
                            canLandHit_SE = true;
                        }
                        if (d <= UnitType.LEVEL_ONE_DEFENSE_TOWER.actionRadiusSquared) {
                            // Should have another one for AOE damage.
                            healthDmgAttackRange_SE += UnitType.LEVEL_ONE_DEFENSE_TOWER.attackStrength;
                            canBeHit_SE = true;
                        }

                        if (d < minDistToEnemy_SE) minDistToEnemy_SE = d;
                        break addEnemy0SE;
                    }
                    case LEVEL_ONE_MONEY_TOWER: {
                        if (actionReady && d <= splasherActionRadiusSquared) {
                            
                            myHealthDmg_SE = splasherAoeAttackStrength;
                            
                            towerHealth_SE = Math.min(towerHealth_SE, robot.health);
                            canLandHit_SE = true;
                        }
                        if (d <= UnitType.LEVEL_ONE_MONEY_TOWER.actionRadiusSquared) {
                            // Should have another one for AOE damage.
                            healthDmgAttackRange_SE += UnitType.LEVEL_ONE_MONEY_TOWER.attackStrength;
                            canBeHit_SE = true;
                        }

                        if (d < minDistToEnemy_SE) minDistToEnemy_SE = d;
                        break addEnemy0SE;
                    }
                    case LEVEL_ONE_PAINT_TOWER: {
                        if (actionReady && d <= splasherActionRadiusSquared) {
                            
                            myHealthDmg_SE = splasherAoeAttackStrength;
                            
                            towerHealth_SE = Math.min(towerHealth_SE, robot.health);
                            canLandHit_SE = true;
                        }
                        if (d <= UnitType.LEVEL_ONE_PAINT_TOWER.actionRadiusSquared) {
                            // Should have another one for AOE damage.
                            healthDmgAttackRange_SE += UnitType.LEVEL_ONE_PAINT_TOWER.attackStrength;
                            canBeHit_SE = true;
                        }

                        if (d < minDistToEnemy_SE) minDistToEnemy_SE = d;
                        break addEnemy0SE;
                    }
                    case LEVEL_THREE_DEFENSE_TOWER: {
                        if (actionReady && d <= splasherActionRadiusSquared) {
                            
                            myHealthDmg_SE = splasherAoeAttackStrength;
                            
                            towerHealth_SE = Math.min(towerHealth_SE, robot.health);
                            canLandHit_SE = true;
                        }
                        if (d <= UnitType.LEVEL_THREE_DEFENSE_TOWER.actionRadiusSquared) {
                            // Should have another one for AOE damage.
                            healthDmgAttackRange_SE += UnitType.LEVEL_THREE_DEFENSE_TOWER.attackStrength;
                            canBeHit_SE = true;
                        }

                        if (d < minDistToEnemy_SE) minDistToEnemy_SE = d;
                        break addEnemy0SE;
                    }
                    case LEVEL_THREE_MONEY_TOWER: {
                        if (actionReady && d <= splasherActionRadiusSquared) {
                            
                            myHealthDmg_SE = splasherAoeAttackStrength;
                            
                            towerHealth_SE = Math.min(towerHealth_SE, robot.health);
                            canLandHit_SE = true;
                        }
                        if (d <= UnitType.LEVEL_THREE_MONEY_TOWER.actionRadiusSquared) {
                            // Should have another one for AOE damage.
                            healthDmgAttackRange_SE += UnitType.LEVEL_THREE_MONEY_TOWER.attackStrength;
                            canBeHit_SE = true;
                        }

                        if (d < minDistToEnemy_SE) minDistToEnemy_SE = d;
                        break addEnemy0SE;
                    }
                    case LEVEL_THREE_PAINT_TOWER: {
                        if (actionReady && d <= splasherActionRadiusSquared) {
                            
                            myHealthDmg_SE = splasherAoeAttackStrength;
                            
                            towerHealth_SE = Math.min(towerHealth_SE, robot.health);
                            canLandHit_SE = true;
                        }
                        if (d <= UnitType.LEVEL_THREE_PAINT_TOWER.actionRadiusSquared) {
                            // Should have another one for AOE damage.
                            healthDmgAttackRange_SE += UnitType.LEVEL_THREE_PAINT_TOWER.attackStrength;
                            canBeHit_SE = true;
                        }

                        if (d < minDistToEnemy_SE) minDistToEnemy_SE = d;
                        break addEnemy0SE;
                    }
                    case LEVEL_TWO_DEFENSE_TOWER: {
                        if (actionReady && d <= splasherActionRadiusSquared) {
                            
                            myHealthDmg_SE = splasherAoeAttackStrength;
                            
                            towerHealth_SE = Math.min(towerHealth_SE, robot.health);
                            canLandHit_SE = true;
                        }
                        if (d <= UnitType.LEVEL_TWO_DEFENSE_TOWER.actionRadiusSquared) {
                            // Should have another one for AOE damage.
                            healthDmgAttackRange_SE += UnitType.LEVEL_TWO_DEFENSE_TOWER.attackStrength;
                            canBeHit_SE = true;
                        }

                        if (d < minDistToEnemy_SE) minDistToEnemy_SE = d;
                        break addEnemy0SE;
                    }
                    case LEVEL_TWO_MONEY_TOWER: {
                        if (actionReady && d <= splasherActionRadiusSquared) {
                            
                            myHealthDmg_SE = splasherAoeAttackStrength;
                            
                            towerHealth_SE = Math.min(towerHealth_SE, robot.health);
                            canLandHit_SE = true;
                        }
                        if (d <= UnitType.LEVEL_TWO_MONEY_TOWER.actionRadiusSquared) {
                            // Should have another one for AOE damage.
                            healthDmgAttackRange_SE += UnitType.LEVEL_TWO_MONEY_TOWER.attackStrength;
                            canBeHit_SE = true;
                        }

                        if (d < minDistToEnemy_SE) minDistToEnemy_SE = d;
                        break addEnemy0SE;
                    }
                    case LEVEL_TWO_PAINT_TOWER: {
                        if (actionReady && d <= splasherActionRadiusSquared) {
                            
                            myHealthDmg_SE = splasherAoeAttackStrength;
                            
                            towerHealth_SE = Math.min(towerHealth_SE, robot.health);
                            canLandHit_SE = true;
                        }
                        if (d <= UnitType.LEVEL_TWO_PAINT_TOWER.actionRadiusSquared) {
                            // Should have another one for AOE damage.
                            healthDmgAttackRange_SE += UnitType.LEVEL_TWO_PAINT_TOWER.attackStrength;
                            canBeHit_SE = true;
                        }

                        if (d < minDistToEnemy_SE) minDistToEnemy_SE = d;
                        break addEnemy0SE;
                    }
                    
                    default: break addEnemy0SE;
                }
            }
            
            addEnemy0S: {
                if (!canMove_S) break addEnemy0S;
                int d = targetLoc_S.distanceSquaredTo(robot.location);
                switch (robot.type) {
                    case MOPPER: {
                        // Expected Paint taken.
                        if (d <= UnitType.MOPPER.actionRadiusSquared) {
                            penalty_S += 3.3;
                        } else if (d <= 8) {
                            penalty_S += 2.5;
                        }
                        break addEnemy0S;
                    }
                    case LEVEL_ONE_DEFENSE_TOWER: {
                        if (actionReady && d <= splasherActionRadiusSquared) {
                            
                            myHealthDmg_S = splasherAoeAttackStrength;
                            
                            towerHealth_S = Math.min(towerHealth_S, robot.health);
                            canLandHit_S = true;
                        }
                        if (d <= UnitType.LEVEL_ONE_DEFENSE_TOWER.actionRadiusSquared) {
                            // Should have another one for AOE damage.
                            healthDmgAttackRange_S += UnitType.LEVEL_ONE_DEFENSE_TOWER.attackStrength;
                            canBeHit_S = true;
                        }

                        if (d < minDistToEnemy_S) minDistToEnemy_S = d;
                        break addEnemy0S;
                    }
                    case LEVEL_ONE_MONEY_TOWER: {
                        if (actionReady && d <= splasherActionRadiusSquared) {
                            
                            myHealthDmg_S = splasherAoeAttackStrength;
                            
                            towerHealth_S = Math.min(towerHealth_S, robot.health);
                            canLandHit_S = true;
                        }
                        if (d <= UnitType.LEVEL_ONE_MONEY_TOWER.actionRadiusSquared) {
                            // Should have another one for AOE damage.
                            healthDmgAttackRange_S += UnitType.LEVEL_ONE_MONEY_TOWER.attackStrength;
                            canBeHit_S = true;
                        }

                        if (d < minDistToEnemy_S) minDistToEnemy_S = d;
                        break addEnemy0S;
                    }
                    case LEVEL_ONE_PAINT_TOWER: {
                        if (actionReady && d <= splasherActionRadiusSquared) {
                            
                            myHealthDmg_S = splasherAoeAttackStrength;
                            
                            towerHealth_S = Math.min(towerHealth_S, robot.health);
                            canLandHit_S = true;
                        }
                        if (d <= UnitType.LEVEL_ONE_PAINT_TOWER.actionRadiusSquared) {
                            // Should have another one for AOE damage.
                            healthDmgAttackRange_S += UnitType.LEVEL_ONE_PAINT_TOWER.attackStrength;
                            canBeHit_S = true;
                        }

                        if (d < minDistToEnemy_S) minDistToEnemy_S = d;
                        break addEnemy0S;
                    }
                    case LEVEL_THREE_DEFENSE_TOWER: {
                        if (actionReady && d <= splasherActionRadiusSquared) {
                            
                            myHealthDmg_S = splasherAoeAttackStrength;
                            
                            towerHealth_S = Math.min(towerHealth_S, robot.health);
                            canLandHit_S = true;
                        }
                        if (d <= UnitType.LEVEL_THREE_DEFENSE_TOWER.actionRadiusSquared) {
                            // Should have another one for AOE damage.
                            healthDmgAttackRange_S += UnitType.LEVEL_THREE_DEFENSE_TOWER.attackStrength;
                            canBeHit_S = true;
                        }

                        if (d < minDistToEnemy_S) minDistToEnemy_S = d;
                        break addEnemy0S;
                    }
                    case LEVEL_THREE_MONEY_TOWER: {
                        if (actionReady && d <= splasherActionRadiusSquared) {
                            
                            myHealthDmg_S = splasherAoeAttackStrength;
                            
                            towerHealth_S = Math.min(towerHealth_S, robot.health);
                            canLandHit_S = true;
                        }
                        if (d <= UnitType.LEVEL_THREE_MONEY_TOWER.actionRadiusSquared) {
                            // Should have another one for AOE damage.
                            healthDmgAttackRange_S += UnitType.LEVEL_THREE_MONEY_TOWER.attackStrength;
                            canBeHit_S = true;
                        }

                        if (d < minDistToEnemy_S) minDistToEnemy_S = d;
                        break addEnemy0S;
                    }
                    case LEVEL_THREE_PAINT_TOWER: {
                        if (actionReady && d <= splasherActionRadiusSquared) {
                            
                            myHealthDmg_S = splasherAoeAttackStrength;
                            
                            towerHealth_S = Math.min(towerHealth_S, robot.health);
                            canLandHit_S = true;
                        }
                        if (d <= UnitType.LEVEL_THREE_PAINT_TOWER.actionRadiusSquared) {
                            // Should have another one for AOE damage.
                            healthDmgAttackRange_S += UnitType.LEVEL_THREE_PAINT_TOWER.attackStrength;
                            canBeHit_S = true;
                        }

                        if (d < minDistToEnemy_S) minDistToEnemy_S = d;
                        break addEnemy0S;
                    }
                    case LEVEL_TWO_DEFENSE_TOWER: {
                        if (actionReady && d <= splasherActionRadiusSquared) {
                            
                            myHealthDmg_S = splasherAoeAttackStrength;
                            
                            towerHealth_S = Math.min(towerHealth_S, robot.health);
                            canLandHit_S = true;
                        }
                        if (d <= UnitType.LEVEL_TWO_DEFENSE_TOWER.actionRadiusSquared) {
                            // Should have another one for AOE damage.
                            healthDmgAttackRange_S += UnitType.LEVEL_TWO_DEFENSE_TOWER.attackStrength;
                            canBeHit_S = true;
                        }

                        if (d < minDistToEnemy_S) minDistToEnemy_S = d;
                        break addEnemy0S;
                    }
                    case LEVEL_TWO_MONEY_TOWER: {
                        if (actionReady && d <= splasherActionRadiusSquared) {
                            
                            myHealthDmg_S = splasherAoeAttackStrength;
                            
                            towerHealth_S = Math.min(towerHealth_S, robot.health);
                            canLandHit_S = true;
                        }
                        if (d <= UnitType.LEVEL_TWO_MONEY_TOWER.actionRadiusSquared) {
                            // Should have another one for AOE damage.
                            healthDmgAttackRange_S += UnitType.LEVEL_TWO_MONEY_TOWER.attackStrength;
                            canBeHit_S = true;
                        }

                        if (d < minDistToEnemy_S) minDistToEnemy_S = d;
                        break addEnemy0S;
                    }
                    case LEVEL_TWO_PAINT_TOWER: {
                        if (actionReady && d <= splasherActionRadiusSquared) {
                            
                            myHealthDmg_S = splasherAoeAttackStrength;
                            
                            towerHealth_S = Math.min(towerHealth_S, robot.health);
                            canLandHit_S = true;
                        }
                        if (d <= UnitType.LEVEL_TWO_PAINT_TOWER.actionRadiusSquared) {
                            // Should have another one for AOE damage.
                            healthDmgAttackRange_S += UnitType.LEVEL_TWO_PAINT_TOWER.attackStrength;
                            canBeHit_S = true;
                        }

                        if (d < minDistToEnemy_S) minDistToEnemy_S = d;
                        break addEnemy0S;
                    }
                    
                    default: break addEnemy0S;
                }
            }
            
            addEnemy0SW: {
                if (!canMove_SW) break addEnemy0SW;
                int d = targetLoc_SW.distanceSquaredTo(robot.location);
                switch (robot.type) {
                    case MOPPER: {
                        // Expected Paint taken.
                        if (d <= UnitType.MOPPER.actionRadiusSquared) {
                            penalty_SW += 3.3;
                        } else if (d <= 8) {
                            penalty_SW += 2.5;
                        }
                        break addEnemy0SW;
                    }
                    case LEVEL_ONE_DEFENSE_TOWER: {
                        if (actionReady && d <= splasherActionRadiusSquared) {
                            
                            myHealthDmg_SW = splasherAoeAttackStrength;
                            
                            towerHealth_SW = Math.min(towerHealth_SW, robot.health);
                            canLandHit_SW = true;
                        }
                        if (d <= UnitType.LEVEL_ONE_DEFENSE_TOWER.actionRadiusSquared) {
                            // Should have another one for AOE damage.
                            healthDmgAttackRange_SW += UnitType.LEVEL_ONE_DEFENSE_TOWER.attackStrength;
                            canBeHit_SW = true;
                        }

                        if (d < minDistToEnemy_SW) minDistToEnemy_SW = d;
                        break addEnemy0SW;
                    }
                    case LEVEL_ONE_MONEY_TOWER: {
                        if (actionReady && d <= splasherActionRadiusSquared) {
                            
                            myHealthDmg_SW = splasherAoeAttackStrength;
                            
                            towerHealth_SW = Math.min(towerHealth_SW, robot.health);
                            canLandHit_SW = true;
                        }
                        if (d <= UnitType.LEVEL_ONE_MONEY_TOWER.actionRadiusSquared) {
                            // Should have another one for AOE damage.
                            healthDmgAttackRange_SW += UnitType.LEVEL_ONE_MONEY_TOWER.attackStrength;
                            canBeHit_SW = true;
                        }

                        if (d < minDistToEnemy_SW) minDistToEnemy_SW = d;
                        break addEnemy0SW;
                    }
                    case LEVEL_ONE_PAINT_TOWER: {
                        if (actionReady && d <= splasherActionRadiusSquared) {
                            
                            myHealthDmg_SW = splasherAoeAttackStrength;
                            
                            towerHealth_SW = Math.min(towerHealth_SW, robot.health);
                            canLandHit_SW = true;
                        }
                        if (d <= UnitType.LEVEL_ONE_PAINT_TOWER.actionRadiusSquared) {
                            // Should have another one for AOE damage.
                            healthDmgAttackRange_SW += UnitType.LEVEL_ONE_PAINT_TOWER.attackStrength;
                            canBeHit_SW = true;
                        }

                        if (d < minDistToEnemy_SW) minDistToEnemy_SW = d;
                        break addEnemy0SW;
                    }
                    case LEVEL_THREE_DEFENSE_TOWER: {
                        if (actionReady && d <= splasherActionRadiusSquared) {
                            
                            myHealthDmg_SW = splasherAoeAttackStrength;
                            
                            towerHealth_SW = Math.min(towerHealth_SW, robot.health);
                            canLandHit_SW = true;
                        }
                        if (d <= UnitType.LEVEL_THREE_DEFENSE_TOWER.actionRadiusSquared) {
                            // Should have another one for AOE damage.
                            healthDmgAttackRange_SW += UnitType.LEVEL_THREE_DEFENSE_TOWER.attackStrength;
                            canBeHit_SW = true;
                        }

                        if (d < minDistToEnemy_SW) minDistToEnemy_SW = d;
                        break addEnemy0SW;
                    }
                    case LEVEL_THREE_MONEY_TOWER: {
                        if (actionReady && d <= splasherActionRadiusSquared) {
                            
                            myHealthDmg_SW = splasherAoeAttackStrength;
                            
                            towerHealth_SW = Math.min(towerHealth_SW, robot.health);
                            canLandHit_SW = true;
                        }
                        if (d <= UnitType.LEVEL_THREE_MONEY_TOWER.actionRadiusSquared) {
                            // Should have another one for AOE damage.
                            healthDmgAttackRange_SW += UnitType.LEVEL_THREE_MONEY_TOWER.attackStrength;
                            canBeHit_SW = true;
                        }

                        if (d < minDistToEnemy_SW) minDistToEnemy_SW = d;
                        break addEnemy0SW;
                    }
                    case LEVEL_THREE_PAINT_TOWER: {
                        if (actionReady && d <= splasherActionRadiusSquared) {
                            
                            myHealthDmg_SW = splasherAoeAttackStrength;
                            
                            towerHealth_SW = Math.min(towerHealth_SW, robot.health);
                            canLandHit_SW = true;
                        }
                        if (d <= UnitType.LEVEL_THREE_PAINT_TOWER.actionRadiusSquared) {
                            // Should have another one for AOE damage.
                            healthDmgAttackRange_SW += UnitType.LEVEL_THREE_PAINT_TOWER.attackStrength;
                            canBeHit_SW = true;
                        }

                        if (d < minDistToEnemy_SW) minDistToEnemy_SW = d;
                        break addEnemy0SW;
                    }
                    case LEVEL_TWO_DEFENSE_TOWER: {
                        if (actionReady && d <= splasherActionRadiusSquared) {
                            
                            myHealthDmg_SW = splasherAoeAttackStrength;
                            
                            towerHealth_SW = Math.min(towerHealth_SW, robot.health);
                            canLandHit_SW = true;
                        }
                        if (d <= UnitType.LEVEL_TWO_DEFENSE_TOWER.actionRadiusSquared) {
                            // Should have another one for AOE damage.
                            healthDmgAttackRange_SW += UnitType.LEVEL_TWO_DEFENSE_TOWER.attackStrength;
                            canBeHit_SW = true;
                        }

                        if (d < minDistToEnemy_SW) minDistToEnemy_SW = d;
                        break addEnemy0SW;
                    }
                    case LEVEL_TWO_MONEY_TOWER: {
                        if (actionReady && d <= splasherActionRadiusSquared) {
                            
                            myHealthDmg_SW = splasherAoeAttackStrength;
                            
                            towerHealth_SW = Math.min(towerHealth_SW, robot.health);
                            canLandHit_SW = true;
                        }
                        if (d <= UnitType.LEVEL_TWO_MONEY_TOWER.actionRadiusSquared) {
                            // Should have another one for AOE damage.
                            healthDmgAttackRange_SW += UnitType.LEVEL_TWO_MONEY_TOWER.attackStrength;
                            canBeHit_SW = true;
                        }

                        if (d < minDistToEnemy_SW) minDistToEnemy_SW = d;
                        break addEnemy0SW;
                    }
                    case LEVEL_TWO_PAINT_TOWER: {
                        if (actionReady && d <= splasherActionRadiusSquared) {
                            
                            myHealthDmg_SW = splasherAoeAttackStrength;
                            
                            towerHealth_SW = Math.min(towerHealth_SW, robot.health);
                            canLandHit_SW = true;
                        }
                        if (d <= UnitType.LEVEL_TWO_PAINT_TOWER.actionRadiusSquared) {
                            // Should have another one for AOE damage.
                            healthDmgAttackRange_SW += UnitType.LEVEL_TWO_PAINT_TOWER.attackStrength;
                            canBeHit_SW = true;
                        }

                        if (d < minDistToEnemy_SW) minDistToEnemy_SW = d;
                        break addEnemy0SW;
                    }
                    
                    default: break addEnemy0SW;
                }
            }
            
            addEnemy0W: {
                if (!canMove_W) break addEnemy0W;
                int d = targetLoc_W.distanceSquaredTo(robot.location);
                switch (robot.type) {
                    case MOPPER: {
                        // Expected Paint taken.
                        if (d <= UnitType.MOPPER.actionRadiusSquared) {
                            penalty_W += 3.3;
                        } else if (d <= 8) {
                            penalty_W += 2.5;
                        }
                        break addEnemy0W;
                    }
                    case LEVEL_ONE_DEFENSE_TOWER: {
                        if (actionReady && d <= splasherActionRadiusSquared) {
                            
                            myHealthDmg_W = splasherAoeAttackStrength;
                            
                            towerHealth_W = Math.min(towerHealth_W, robot.health);
                            canLandHit_W = true;
                        }
                        if (d <= UnitType.LEVEL_ONE_DEFENSE_TOWER.actionRadiusSquared) {
                            // Should have another one for AOE damage.
                            healthDmgAttackRange_W += UnitType.LEVEL_ONE_DEFENSE_TOWER.attackStrength;
                            canBeHit_W = true;
                        }

                        if (d < minDistToEnemy_W) minDistToEnemy_W = d;
                        break addEnemy0W;
                    }
                    case LEVEL_ONE_MONEY_TOWER: {
                        if (actionReady && d <= splasherActionRadiusSquared) {
                            
                            myHealthDmg_W = splasherAoeAttackStrength;
                            
                            towerHealth_W = Math.min(towerHealth_W, robot.health);
                            canLandHit_W = true;
                        }
                        if (d <= UnitType.LEVEL_ONE_MONEY_TOWER.actionRadiusSquared) {
                            // Should have another one for AOE damage.
                            healthDmgAttackRange_W += UnitType.LEVEL_ONE_MONEY_TOWER.attackStrength;
                            canBeHit_W = true;
                        }

                        if (d < minDistToEnemy_W) minDistToEnemy_W = d;
                        break addEnemy0W;
                    }
                    case LEVEL_ONE_PAINT_TOWER: {
                        if (actionReady && d <= splasherActionRadiusSquared) {
                            
                            myHealthDmg_W = splasherAoeAttackStrength;
                            
                            towerHealth_W = Math.min(towerHealth_W, robot.health);
                            canLandHit_W = true;
                        }
                        if (d <= UnitType.LEVEL_ONE_PAINT_TOWER.actionRadiusSquared) {
                            // Should have another one for AOE damage.
                            healthDmgAttackRange_W += UnitType.LEVEL_ONE_PAINT_TOWER.attackStrength;
                            canBeHit_W = true;
                        }

                        if (d < minDistToEnemy_W) minDistToEnemy_W = d;
                        break addEnemy0W;
                    }
                    case LEVEL_THREE_DEFENSE_TOWER: {
                        if (actionReady && d <= splasherActionRadiusSquared) {
                            
                            myHealthDmg_W = splasherAoeAttackStrength;
                            
                            towerHealth_W = Math.min(towerHealth_W, robot.health);
                            canLandHit_W = true;
                        }
                        if (d <= UnitType.LEVEL_THREE_DEFENSE_TOWER.actionRadiusSquared) {
                            // Should have another one for AOE damage.
                            healthDmgAttackRange_W += UnitType.LEVEL_THREE_DEFENSE_TOWER.attackStrength;
                            canBeHit_W = true;
                        }

                        if (d < minDistToEnemy_W) minDistToEnemy_W = d;
                        break addEnemy0W;
                    }
                    case LEVEL_THREE_MONEY_TOWER: {
                        if (actionReady && d <= splasherActionRadiusSquared) {
                            
                            myHealthDmg_W = splasherAoeAttackStrength;
                            
                            towerHealth_W = Math.min(towerHealth_W, robot.health);
                            canLandHit_W = true;
                        }
                        if (d <= UnitType.LEVEL_THREE_MONEY_TOWER.actionRadiusSquared) {
                            // Should have another one for AOE damage.
                            healthDmgAttackRange_W += UnitType.LEVEL_THREE_MONEY_TOWER.attackStrength;
                            canBeHit_W = true;
                        }

                        if (d < minDistToEnemy_W) minDistToEnemy_W = d;
                        break addEnemy0W;
                    }
                    case LEVEL_THREE_PAINT_TOWER: {
                        if (actionReady && d <= splasherActionRadiusSquared) {
                            
                            myHealthDmg_W = splasherAoeAttackStrength;
                            
                            towerHealth_W = Math.min(towerHealth_W, robot.health);
                            canLandHit_W = true;
                        }
                        if (d <= UnitType.LEVEL_THREE_PAINT_TOWER.actionRadiusSquared) {
                            // Should have another one for AOE damage.
                            healthDmgAttackRange_W += UnitType.LEVEL_THREE_PAINT_TOWER.attackStrength;
                            canBeHit_W = true;
                        }

                        if (d < minDistToEnemy_W) minDistToEnemy_W = d;
                        break addEnemy0W;
                    }
                    case LEVEL_TWO_DEFENSE_TOWER: {
                        if (actionReady && d <= splasherActionRadiusSquared) {
                            
                            myHealthDmg_W = splasherAoeAttackStrength;
                            
                            towerHealth_W = Math.min(towerHealth_W, robot.health);
                            canLandHit_W = true;
                        }
                        if (d <= UnitType.LEVEL_TWO_DEFENSE_TOWER.actionRadiusSquared) {
                            // Should have another one for AOE damage.
                            healthDmgAttackRange_W += UnitType.LEVEL_TWO_DEFENSE_TOWER.attackStrength;
                            canBeHit_W = true;
                        }

                        if (d < minDistToEnemy_W) minDistToEnemy_W = d;
                        break addEnemy0W;
                    }
                    case LEVEL_TWO_MONEY_TOWER: {
                        if (actionReady && d <= splasherActionRadiusSquared) {
                            
                            myHealthDmg_W = splasherAoeAttackStrength;
                            
                            towerHealth_W = Math.min(towerHealth_W, robot.health);
                            canLandHit_W = true;
                        }
                        if (d <= UnitType.LEVEL_TWO_MONEY_TOWER.actionRadiusSquared) {
                            // Should have another one for AOE damage.
                            healthDmgAttackRange_W += UnitType.LEVEL_TWO_MONEY_TOWER.attackStrength;
                            canBeHit_W = true;
                        }

                        if (d < minDistToEnemy_W) minDistToEnemy_W = d;
                        break addEnemy0W;
                    }
                    case LEVEL_TWO_PAINT_TOWER: {
                        if (actionReady && d <= splasherActionRadiusSquared) {
                            
                            myHealthDmg_W = splasherAoeAttackStrength;
                            
                            towerHealth_W = Math.min(towerHealth_W, robot.health);
                            canLandHit_W = true;
                        }
                        if (d <= UnitType.LEVEL_TWO_PAINT_TOWER.actionRadiusSquared) {
                            // Should have another one for AOE damage.
                            healthDmgAttackRange_W += UnitType.LEVEL_TWO_PAINT_TOWER.attackStrength;
                            canBeHit_W = true;
                        }

                        if (d < minDistToEnemy_W) minDistToEnemy_W = d;
                        break addEnemy0W;
                    }
                    
                    default: break addEnemy0W;
                }
            }
            
            addEnemy0NW: {
                if (!canMove_NW) break addEnemy0NW;
                int d = targetLoc_NW.distanceSquaredTo(robot.location);
                switch (robot.type) {
                    case MOPPER: {
                        // Expected Paint taken.
                        if (d <= UnitType.MOPPER.actionRadiusSquared) {
                            penalty_NW += 3.3;
                        } else if (d <= 8) {
                            penalty_NW += 2.5;
                        }
                        break addEnemy0NW;
                    }
                    case LEVEL_ONE_DEFENSE_TOWER: {
                        if (actionReady && d <= splasherActionRadiusSquared) {
                            
                            myHealthDmg_NW = splasherAoeAttackStrength;
                            
                            towerHealth_NW = Math.min(towerHealth_NW, robot.health);
                            canLandHit_NW = true;
                        }
                        if (d <= UnitType.LEVEL_ONE_DEFENSE_TOWER.actionRadiusSquared) {
                            // Should have another one for AOE damage.
                            healthDmgAttackRange_NW += UnitType.LEVEL_ONE_DEFENSE_TOWER.attackStrength;
                            canBeHit_NW = true;
                        }

                        if (d < minDistToEnemy_NW) minDistToEnemy_NW = d;
                        break addEnemy0NW;
                    }
                    case LEVEL_ONE_MONEY_TOWER: {
                        if (actionReady && d <= splasherActionRadiusSquared) {
                            
                            myHealthDmg_NW = splasherAoeAttackStrength;
                            
                            towerHealth_NW = Math.min(towerHealth_NW, robot.health);
                            canLandHit_NW = true;
                        }
                        if (d <= UnitType.LEVEL_ONE_MONEY_TOWER.actionRadiusSquared) {
                            // Should have another one for AOE damage.
                            healthDmgAttackRange_NW += UnitType.LEVEL_ONE_MONEY_TOWER.attackStrength;
                            canBeHit_NW = true;
                        }

                        if (d < minDistToEnemy_NW) minDistToEnemy_NW = d;
                        break addEnemy0NW;
                    }
                    case LEVEL_ONE_PAINT_TOWER: {
                        if (actionReady && d <= splasherActionRadiusSquared) {
                            
                            myHealthDmg_NW = splasherAoeAttackStrength;
                            
                            towerHealth_NW = Math.min(towerHealth_NW, robot.health);
                            canLandHit_NW = true;
                        }
                        if (d <= UnitType.LEVEL_ONE_PAINT_TOWER.actionRadiusSquared) {
                            // Should have another one for AOE damage.
                            healthDmgAttackRange_NW += UnitType.LEVEL_ONE_PAINT_TOWER.attackStrength;
                            canBeHit_NW = true;
                        }

                        if (d < minDistToEnemy_NW) minDistToEnemy_NW = d;
                        break addEnemy0NW;
                    }
                    case LEVEL_THREE_DEFENSE_TOWER: {
                        if (actionReady && d <= splasherActionRadiusSquared) {
                            
                            myHealthDmg_NW = splasherAoeAttackStrength;
                            
                            towerHealth_NW = Math.min(towerHealth_NW, robot.health);
                            canLandHit_NW = true;
                        }
                        if (d <= UnitType.LEVEL_THREE_DEFENSE_TOWER.actionRadiusSquared) {
                            // Should have another one for AOE damage.
                            healthDmgAttackRange_NW += UnitType.LEVEL_THREE_DEFENSE_TOWER.attackStrength;
                            canBeHit_NW = true;
                        }

                        if (d < minDistToEnemy_NW) minDistToEnemy_NW = d;
                        break addEnemy0NW;
                    }
                    case LEVEL_THREE_MONEY_TOWER: {
                        if (actionReady && d <= splasherActionRadiusSquared) {
                            
                            myHealthDmg_NW = splasherAoeAttackStrength;
                            
                            towerHealth_NW = Math.min(towerHealth_NW, robot.health);
                            canLandHit_NW = true;
                        }
                        if (d <= UnitType.LEVEL_THREE_MONEY_TOWER.actionRadiusSquared) {
                            // Should have another one for AOE damage.
                            healthDmgAttackRange_NW += UnitType.LEVEL_THREE_MONEY_TOWER.attackStrength;
                            canBeHit_NW = true;
                        }

                        if (d < minDistToEnemy_NW) minDistToEnemy_NW = d;
                        break addEnemy0NW;
                    }
                    case LEVEL_THREE_PAINT_TOWER: {
                        if (actionReady && d <= splasherActionRadiusSquared) {
                            
                            myHealthDmg_NW = splasherAoeAttackStrength;
                            
                            towerHealth_NW = Math.min(towerHealth_NW, robot.health);
                            canLandHit_NW = true;
                        }
                        if (d <= UnitType.LEVEL_THREE_PAINT_TOWER.actionRadiusSquared) {
                            // Should have another one for AOE damage.
                            healthDmgAttackRange_NW += UnitType.LEVEL_THREE_PAINT_TOWER.attackStrength;
                            canBeHit_NW = true;
                        }

                        if (d < minDistToEnemy_NW) minDistToEnemy_NW = d;
                        break addEnemy0NW;
                    }
                    case LEVEL_TWO_DEFENSE_TOWER: {
                        if (actionReady && d <= splasherActionRadiusSquared) {
                            
                            myHealthDmg_NW = splasherAoeAttackStrength;
                            
                            towerHealth_NW = Math.min(towerHealth_NW, robot.health);
                            canLandHit_NW = true;
                        }
                        if (d <= UnitType.LEVEL_TWO_DEFENSE_TOWER.actionRadiusSquared) {
                            // Should have another one for AOE damage.
                            healthDmgAttackRange_NW += UnitType.LEVEL_TWO_DEFENSE_TOWER.attackStrength;
                            canBeHit_NW = true;
                        }

                        if (d < minDistToEnemy_NW) minDistToEnemy_NW = d;
                        break addEnemy0NW;
                    }
                    case LEVEL_TWO_MONEY_TOWER: {
                        if (actionReady && d <= splasherActionRadiusSquared) {
                            
                            myHealthDmg_NW = splasherAoeAttackStrength;
                            
                            towerHealth_NW = Math.min(towerHealth_NW, robot.health);
                            canLandHit_NW = true;
                        }
                        if (d <= UnitType.LEVEL_TWO_MONEY_TOWER.actionRadiusSquared) {
                            // Should have another one for AOE damage.
                            healthDmgAttackRange_NW += UnitType.LEVEL_TWO_MONEY_TOWER.attackStrength;
                            canBeHit_NW = true;
                        }

                        if (d < minDistToEnemy_NW) minDistToEnemy_NW = d;
                        break addEnemy0NW;
                    }
                    case LEVEL_TWO_PAINT_TOWER: {
                        if (actionReady && d <= splasherActionRadiusSquared) {
                            
                            myHealthDmg_NW = splasherAoeAttackStrength;
                            
                            towerHealth_NW = Math.min(towerHealth_NW, robot.health);
                            canLandHit_NW = true;
                        }
                        if (d <= UnitType.LEVEL_TWO_PAINT_TOWER.actionRadiusSquared) {
                            // Should have another one for AOE damage.
                            healthDmgAttackRange_NW += UnitType.LEVEL_TWO_PAINT_TOWER.attackStrength;
                            canBeHit_NW = true;
                        }

                        if (d < minDistToEnemy_NW) minDistToEnemy_NW = d;
                        break addEnemy0NW;
                    }
                    
                    default: break addEnemy0NW;
                }
            }
            
            addEnemy0C: {
                if (!canMove_C) break addEnemy0C;
                int d = targetLoc_C.distanceSquaredTo(robot.location);
                switch (robot.type) {
                    case MOPPER: {
                        // Expected Paint taken.
                        if (d <= UnitType.MOPPER.actionRadiusSquared) {
                            penalty_C += 3.3;
                        } else if (d <= 8) {
                            penalty_C += 2.5;
                        }
                        break addEnemy0C;
                    }
                    case LEVEL_ONE_DEFENSE_TOWER: {
                        if (actionReady && d <= splasherActionRadiusSquared) {
                            
                            myHealthDmg_C = splasherAoeAttackStrength;
                            
                            towerHealth_C = Math.min(towerHealth_C, robot.health);
                            canLandHit_C = true;
                        }
                        if (d <= UnitType.LEVEL_ONE_DEFENSE_TOWER.actionRadiusSquared) {
                            // Should have another one for AOE damage.
                            healthDmgAttackRange_C += UnitType.LEVEL_ONE_DEFENSE_TOWER.attackStrength;
                            canBeHit_C = true;
                        }

                        if (d < minDistToEnemy_C) minDistToEnemy_C = d;
                        break addEnemy0C;
                    }
                    case LEVEL_ONE_MONEY_TOWER: {
                        if (actionReady && d <= splasherActionRadiusSquared) {
                            
                            myHealthDmg_C = splasherAoeAttackStrength;
                            
                            towerHealth_C = Math.min(towerHealth_C, robot.health);
                            canLandHit_C = true;
                        }
                        if (d <= UnitType.LEVEL_ONE_MONEY_TOWER.actionRadiusSquared) {
                            // Should have another one for AOE damage.
                            healthDmgAttackRange_C += UnitType.LEVEL_ONE_MONEY_TOWER.attackStrength;
                            canBeHit_C = true;
                        }

                        if (d < minDistToEnemy_C) minDistToEnemy_C = d;
                        break addEnemy0C;
                    }
                    case LEVEL_ONE_PAINT_TOWER: {
                        if (actionReady && d <= splasherActionRadiusSquared) {
                            
                            myHealthDmg_C = splasherAoeAttackStrength;
                            
                            towerHealth_C = Math.min(towerHealth_C, robot.health);
                            canLandHit_C = true;
                        }
                        if (d <= UnitType.LEVEL_ONE_PAINT_TOWER.actionRadiusSquared) {
                            // Should have another one for AOE damage.
                            healthDmgAttackRange_C += UnitType.LEVEL_ONE_PAINT_TOWER.attackStrength;
                            canBeHit_C = true;
                        }

                        if (d < minDistToEnemy_C) minDistToEnemy_C = d;
                        break addEnemy0C;
                    }
                    case LEVEL_THREE_DEFENSE_TOWER: {
                        if (actionReady && d <= splasherActionRadiusSquared) {
                            
                            myHealthDmg_C = splasherAoeAttackStrength;
                            
                            towerHealth_C = Math.min(towerHealth_C, robot.health);
                            canLandHit_C = true;
                        }
                        if (d <= UnitType.LEVEL_THREE_DEFENSE_TOWER.actionRadiusSquared) {
                            // Should have another one for AOE damage.
                            healthDmgAttackRange_C += UnitType.LEVEL_THREE_DEFENSE_TOWER.attackStrength;
                            canBeHit_C = true;
                        }

                        if (d < minDistToEnemy_C) minDistToEnemy_C = d;
                        break addEnemy0C;
                    }
                    case LEVEL_THREE_MONEY_TOWER: {
                        if (actionReady && d <= splasherActionRadiusSquared) {
                            
                            myHealthDmg_C = splasherAoeAttackStrength;
                            
                            towerHealth_C = Math.min(towerHealth_C, robot.health);
                            canLandHit_C = true;
                        }
                        if (d <= UnitType.LEVEL_THREE_MONEY_TOWER.actionRadiusSquared) {
                            // Should have another one for AOE damage.
                            healthDmgAttackRange_C += UnitType.LEVEL_THREE_MONEY_TOWER.attackStrength;
                            canBeHit_C = true;
                        }

                        if (d < minDistToEnemy_C) minDistToEnemy_C = d;
                        break addEnemy0C;
                    }
                    case LEVEL_THREE_PAINT_TOWER: {
                        if (actionReady && d <= splasherActionRadiusSquared) {
                            
                            myHealthDmg_C = splasherAoeAttackStrength;
                            
                            towerHealth_C = Math.min(towerHealth_C, robot.health);
                            canLandHit_C = true;
                        }
                        if (d <= UnitType.LEVEL_THREE_PAINT_TOWER.actionRadiusSquared) {
                            // Should have another one for AOE damage.
                            healthDmgAttackRange_C += UnitType.LEVEL_THREE_PAINT_TOWER.attackStrength;
                            canBeHit_C = true;
                        }

                        if (d < minDistToEnemy_C) minDistToEnemy_C = d;
                        break addEnemy0C;
                    }
                    case LEVEL_TWO_DEFENSE_TOWER: {
                        if (actionReady && d <= splasherActionRadiusSquared) {
                            
                            myHealthDmg_C = splasherAoeAttackStrength;
                            
                            towerHealth_C = Math.min(towerHealth_C, robot.health);
                            canLandHit_C = true;
                        }
                        if (d <= UnitType.LEVEL_TWO_DEFENSE_TOWER.actionRadiusSquared) {
                            // Should have another one for AOE damage.
                            healthDmgAttackRange_C += UnitType.LEVEL_TWO_DEFENSE_TOWER.attackStrength;
                            canBeHit_C = true;
                        }

                        if (d < minDistToEnemy_C) minDistToEnemy_C = d;
                        break addEnemy0C;
                    }
                    case LEVEL_TWO_MONEY_TOWER: {
                        if (actionReady && d <= splasherActionRadiusSquared) {
                            
                            myHealthDmg_C = splasherAoeAttackStrength;
                            
                            towerHealth_C = Math.min(towerHealth_C, robot.health);
                            canLandHit_C = true;
                        }
                        if (d <= UnitType.LEVEL_TWO_MONEY_TOWER.actionRadiusSquared) {
                            // Should have another one for AOE damage.
                            healthDmgAttackRange_C += UnitType.LEVEL_TWO_MONEY_TOWER.attackStrength;
                            canBeHit_C = true;
                        }

                        if (d < minDistToEnemy_C) minDistToEnemy_C = d;
                        break addEnemy0C;
                    }
                    case LEVEL_TWO_PAINT_TOWER: {
                        if (actionReady && d <= splasherActionRadiusSquared) {
                            
                            myHealthDmg_C = splasherAoeAttackStrength;
                            
                            towerHealth_C = Math.min(towerHealth_C, robot.health);
                            canLandHit_C = true;
                        }
                        if (d <= UnitType.LEVEL_TWO_PAINT_TOWER.actionRadiusSquared) {
                            // Should have another one for AOE damage.
                            healthDmgAttackRange_C += UnitType.LEVEL_TWO_PAINT_TOWER.attackStrength;
                            canBeHit_C = true;
                        }

                        if (d < minDistToEnemy_C) minDistToEnemy_C = d;
                        break addEnemy0C;
                    }
                    
                    default: break addEnemy0C;
                }
            }
            
        }

        
        System.out.println("[231] " + "minDistToEnemy_N = " + minDistToEnemy_N + ", " + "targetLoc_N.x = " + targetLoc_N.x + ", " + "canMove_N = " + canMove_N + ", " + "targetLoc_N.y = " + targetLoc_N.y + ", " + "penalty_N = " + penalty_N + ", " + "healthDmgAttackRange_N = " + healthDmgAttackRange_N + ", " + "myHealthDmg_N = " + myHealthDmg_N + ", " + "towerHealth_N = " + towerHealth_N + ", " + "canBeHit_N = " + canBeHit_N + ", " + "canLandHit_N = " + canLandHit_N);
        
        System.out.println("[231] " + "minDistToEnemy_NE = " + minDistToEnemy_NE + ", " + "targetLoc_NE.x = " + targetLoc_NE.x + ", " + "canMove_NE = " + canMove_NE + ", " + "targetLoc_NE.y = " + targetLoc_NE.y + ", " + "penalty_NE = " + penalty_NE + ", " + "healthDmgAttackRange_NE = " + healthDmgAttackRange_NE + ", " + "myHealthDmg_NE = " + myHealthDmg_NE + ", " + "towerHealth_NE = " + towerHealth_NE + ", " + "canBeHit_NE = " + canBeHit_NE + ", " + "canLandHit_NE = " + canLandHit_NE);
        
        System.out.println("[231] " + "minDistToEnemy_E = " + minDistToEnemy_E + ", " + "targetLoc_E.x = " + targetLoc_E.x + ", " + "canMove_E = " + canMove_E + ", " + "targetLoc_E.y = " + targetLoc_E.y + ", " + "penalty_E = " + penalty_E + ", " + "healthDmgAttackRange_E = " + healthDmgAttackRange_E + ", " + "myHealthDmg_E = " + myHealthDmg_E + ", " + "towerHealth_E = " + towerHealth_E + ", " + "canBeHit_E = " + canBeHit_E + ", " + "canLandHit_E = " + canLandHit_E);
        
        System.out.println("[231] " + "minDistToEnemy_SE = " + minDistToEnemy_SE + ", " + "targetLoc_SE.x = " + targetLoc_SE.x + ", " + "canMove_SE = " + canMove_SE + ", " + "targetLoc_SE.y = " + targetLoc_SE.y + ", " + "penalty_SE = " + penalty_SE + ", " + "healthDmgAttackRange_SE = " + healthDmgAttackRange_SE + ", " + "myHealthDmg_SE = " + myHealthDmg_SE + ", " + "towerHealth_SE = " + towerHealth_SE + ", " + "canBeHit_SE = " + canBeHit_SE + ", " + "canLandHit_SE = " + canLandHit_SE);
        
        System.out.println("[231] " + "minDistToEnemy_S = " + minDistToEnemy_S + ", " + "targetLoc_S.x = " + targetLoc_S.x + ", " + "canMove_S = " + canMove_S + ", " + "targetLoc_S.y = " + targetLoc_S.y + ", " + "penalty_S = " + penalty_S + ", " + "healthDmgAttackRange_S = " + healthDmgAttackRange_S + ", " + "myHealthDmg_S = " + myHealthDmg_S + ", " + "towerHealth_S = " + towerHealth_S + ", " + "canBeHit_S = " + canBeHit_S + ", " + "canLandHit_S = " + canLandHit_S);
        
        System.out.println("[231] " + "minDistToEnemy_SW = " + minDistToEnemy_SW + ", " + "targetLoc_SW.x = " + targetLoc_SW.x + ", " + "canMove_SW = " + canMove_SW + ", " + "targetLoc_SW.y = " + targetLoc_SW.y + ", " + "penalty_SW = " + penalty_SW + ", " + "healthDmgAttackRange_SW = " + healthDmgAttackRange_SW + ", " + "myHealthDmg_SW = " + myHealthDmg_SW + ", " + "towerHealth_SW = " + towerHealth_SW + ", " + "canBeHit_SW = " + canBeHit_SW + ", " + "canLandHit_SW = " + canLandHit_SW);
        
        System.out.println("[231] " + "minDistToEnemy_W = " + minDistToEnemy_W + ", " + "targetLoc_W.x = " + targetLoc_W.x + ", " + "canMove_W = " + canMove_W + ", " + "targetLoc_W.y = " + targetLoc_W.y + ", " + "penalty_W = " + penalty_W + ", " + "healthDmgAttackRange_W = " + healthDmgAttackRange_W + ", " + "myHealthDmg_W = " + myHealthDmg_W + ", " + "towerHealth_W = " + towerHealth_W + ", " + "canBeHit_W = " + canBeHit_W + ", " + "canLandHit_W = " + canLandHit_W);
        
        System.out.println("[231] " + "minDistToEnemy_NW = " + minDistToEnemy_NW + ", " + "targetLoc_NW.x = " + targetLoc_NW.x + ", " + "canMove_NW = " + canMove_NW + ", " + "targetLoc_NW.y = " + targetLoc_NW.y + ", " + "penalty_NW = " + penalty_NW + ", " + "healthDmgAttackRange_NW = " + healthDmgAttackRange_NW + ", " + "myHealthDmg_NW = " + myHealthDmg_NW + ", " + "towerHealth_NW = " + towerHealth_NW + ", " + "canBeHit_NW = " + canBeHit_NW + ", " + "canLandHit_NW = " + canLandHit_NW);
        
        System.out.println("[231] " + "minDistToEnemy_C = " + minDistToEnemy_C + ", " + "targetLoc_C.x = " + targetLoc_C.x + ", " + "canMove_C = " + canMove_C + ", " + "targetLoc_C.y = " + targetLoc_C.y + ", " + "penalty_C = " + penalty_C + ", " + "healthDmgAttackRange_C = " + healthDmgAttackRange_C + ", " + "myHealthDmg_C = " + myHealthDmg_C + ", " + "towerHealth_C = " + towerHealth_C + ", " + "canBeHit_C = " + canBeHit_C + ", " + "canLandHit_C = " + canLandHit_C);
        

        boolean bestWins = false;
        Direction bestDir = Direction.NORTH;
        MapLocation targetLoc_best = SquareManager.m23;
        boolean canMove_best = (rc.canMove(Direction.NORTH));
        double healthDmgAttackRange_best = 0;
        double myHealthDmg_best = 0;
        int minDistToEnemy_best = 100000;
        int penalty_best = SquareManager.penalty23;
        int towerHealth_best = 1000000;
        boolean canBeHit_best = false;
        boolean canLandHit_best = false;
        
        
        targetLoc_best = targetLoc_N;
        canMove_best = canMove_N;
        healthDmgAttackRange_best = healthDmgAttackRange_N;
        myHealthDmg_best = myHealthDmg_N;
        minDistToEnemy_best = minDistToEnemy_N;
        penalty_best = penalty_N;
        towerHealth_best = towerHealth_N;
        canBeHit_best = canBeHit_N;
        canLandHit_best = canLandHit_N;
        
        bestWins = canMove_best;
        chooseBest0NE: {
            if (!canMove_NE || !canMove_best) break chooseBest0NE;

            // Choose the square where I deal the most net damage.
            double bestHealthDmgDiff = healthDmgAttackRange_best - myHealthDmg_best;
            double otherHealthDmgDiff = healthDmgAttackRange_NE - myHealthDmg_NE;
            if (bestHealthDmgDiff != otherHealthDmgDiff) {
                bestWins = (bestHealthDmgDiff < otherHealthDmgDiff);
                break chooseBest0NE;
            }

            if (actionReady) {
                // If I can attack at either square, prefer the one which lets me attack a low health tower.
                if (canLandHit_best && canLandHit_NE) {
                    if (towerHealth_best != towerHealth_NE) {
                        bestWins = towerHealth_best < towerHealth_NE;
                        break chooseBest0NE;
                    }
                }

                // If I can attack, choose the square which lets me land a hit.
                if (canLandHit_best != canLandHit_NE) {
                    bestWins = canLandHit_best;
                    break chooseBest0NE;
                }
            } else {
                // If I can't attack, choose the square which gets me out of action radius.
                if (canBeHit_best != canBeHit_NE) {
                    bestWins = !canBeHit_best;
                    break chooseBest0NE;
                }
            }

            // If both squares are in action radius, prefer the one which lets you get out of action radius.
            if (canBeHit_best && canBeHit_NE) {
                if ((minDistToEnemy_best <= 2) != (minDistToEnemy_NE <= 2)) {
                    bestWins = !(minDistToEnemy_best <= 2);
                    break chooseBest0NE;
                }
            }

            // If I can't land a hit at either square, prefer the one which is closer.
            // This is necessary if we're far away, but if we can already land a hit,
            // Then there's really no difference between these two squares, so we should go for penalty instead.
            else if (!canLandHit_C && !canLandHit_best && !canLandHit_NE) {
                if (minDistToEnemy_best != minDistToEnemy_NE) {
                    bestWins = minDistToEnemy_best < minDistToEnemy_NE;
                    break chooseBest0NE;
                }
            }

            // All else equal, prefer the square with better paint penalty.
            bestWins = (penalty_best <= penalty_NE);
            break chooseBest0NE;
        }
        
        
        if (!bestWins) {
            targetLoc_best = targetLoc_NE;
            canMove_best = canMove_NE;
            healthDmgAttackRange_best = healthDmgAttackRange_NE;
            myHealthDmg_best = myHealthDmg_NE;
            minDistToEnemy_best = minDistToEnemy_NE;
            penalty_best = penalty_NE;
            towerHealth_best = towerHealth_NE;
            canBeHit_best = canBeHit_NE;
            canLandHit_best = canLandHit_NE;
            bestDir = Direction.NORTHEAST;
        }
        
        
        bestWins = canMove_best;
        chooseBest0E: {
            if (!canMove_E || !canMove_best) break chooseBest0E;

            // Choose the square where I deal the most net damage.
            double bestHealthDmgDiff = healthDmgAttackRange_best - myHealthDmg_best;
            double otherHealthDmgDiff = healthDmgAttackRange_E - myHealthDmg_E;
            if (bestHealthDmgDiff != otherHealthDmgDiff) {
                bestWins = (bestHealthDmgDiff < otherHealthDmgDiff);
                break chooseBest0E;
            }

            if (actionReady) {
                // If I can attack at either square, prefer the one which lets me attack a low health tower.
                if (canLandHit_best && canLandHit_E) {
                    if (towerHealth_best != towerHealth_E) {
                        bestWins = towerHealth_best < towerHealth_E;
                        break chooseBest0E;
                    }
                }

                // If I can attack, choose the square which lets me land a hit.
                if (canLandHit_best != canLandHit_E) {
                    bestWins = canLandHit_best;
                    break chooseBest0E;
                }
            } else {
                // If I can't attack, choose the square which gets me out of action radius.
                if (canBeHit_best != canBeHit_E) {
                    bestWins = !canBeHit_best;
                    break chooseBest0E;
                }
            }

            // If both squares are in action radius, prefer the one which lets you get out of action radius.
            if (canBeHit_best && canBeHit_E) {
                if ((minDistToEnemy_best <= 2) != (minDistToEnemy_E <= 2)) {
                    bestWins = !(minDistToEnemy_best <= 2);
                    break chooseBest0E;
                }
            }

            // If I can't land a hit at either square, prefer the one which is closer.
            // This is necessary if we're far away, but if we can already land a hit,
            // Then there's really no difference between these two squares, so we should go for penalty instead.
            else if (!canLandHit_C && !canLandHit_best && !canLandHit_E) {
                if (minDistToEnemy_best != minDistToEnemy_E) {
                    bestWins = minDistToEnemy_best < minDistToEnemy_E;
                    break chooseBest0E;
                }
            }

            // All else equal, prefer the square with better paint penalty.
            bestWins = (penalty_best <= penalty_E);
            break chooseBest0E;
        }
        
        
        if (!bestWins) {
            targetLoc_best = targetLoc_E;
            canMove_best = canMove_E;
            healthDmgAttackRange_best = healthDmgAttackRange_E;
            myHealthDmg_best = myHealthDmg_E;
            minDistToEnemy_best = minDistToEnemy_E;
            penalty_best = penalty_E;
            towerHealth_best = towerHealth_E;
            canBeHit_best = canBeHit_E;
            canLandHit_best = canLandHit_E;
            bestDir = Direction.EAST;
        }
        
        
        bestWins = canMove_best;
        chooseBest0SE: {
            if (!canMove_SE || !canMove_best) break chooseBest0SE;

            // Choose the square where I deal the most net damage.
            double bestHealthDmgDiff = healthDmgAttackRange_best - myHealthDmg_best;
            double otherHealthDmgDiff = healthDmgAttackRange_SE - myHealthDmg_SE;
            if (bestHealthDmgDiff != otherHealthDmgDiff) {
                bestWins = (bestHealthDmgDiff < otherHealthDmgDiff);
                break chooseBest0SE;
            }

            if (actionReady) {
                // If I can attack at either square, prefer the one which lets me attack a low health tower.
                if (canLandHit_best && canLandHit_SE) {
                    if (towerHealth_best != towerHealth_SE) {
                        bestWins = towerHealth_best < towerHealth_SE;
                        break chooseBest0SE;
                    }
                }

                // If I can attack, choose the square which lets me land a hit.
                if (canLandHit_best != canLandHit_SE) {
                    bestWins = canLandHit_best;
                    break chooseBest0SE;
                }
            } else {
                // If I can't attack, choose the square which gets me out of action radius.
                if (canBeHit_best != canBeHit_SE) {
                    bestWins = !canBeHit_best;
                    break chooseBest0SE;
                }
            }

            // If both squares are in action radius, prefer the one which lets you get out of action radius.
            if (canBeHit_best && canBeHit_SE) {
                if ((minDistToEnemy_best <= 2) != (minDistToEnemy_SE <= 2)) {
                    bestWins = !(minDistToEnemy_best <= 2);
                    break chooseBest0SE;
                }
            }

            // If I can't land a hit at either square, prefer the one which is closer.
            // This is necessary if we're far away, but if we can already land a hit,
            // Then there's really no difference between these two squares, so we should go for penalty instead.
            else if (!canLandHit_C && !canLandHit_best && !canLandHit_SE) {
                if (minDistToEnemy_best != minDistToEnemy_SE) {
                    bestWins = minDistToEnemy_best < minDistToEnemy_SE;
                    break chooseBest0SE;
                }
            }

            // All else equal, prefer the square with better paint penalty.
            bestWins = (penalty_best <= penalty_SE);
            break chooseBest0SE;
        }
        
        
        if (!bestWins) {
            targetLoc_best = targetLoc_SE;
            canMove_best = canMove_SE;
            healthDmgAttackRange_best = healthDmgAttackRange_SE;
            myHealthDmg_best = myHealthDmg_SE;
            minDistToEnemy_best = minDistToEnemy_SE;
            penalty_best = penalty_SE;
            towerHealth_best = towerHealth_SE;
            canBeHit_best = canBeHit_SE;
            canLandHit_best = canLandHit_SE;
            bestDir = Direction.SOUTHEAST;
        }
        
        
        bestWins = canMove_best;
        chooseBest0S: {
            if (!canMove_S || !canMove_best) break chooseBest0S;

            // Choose the square where I deal the most net damage.
            double bestHealthDmgDiff = healthDmgAttackRange_best - myHealthDmg_best;
            double otherHealthDmgDiff = healthDmgAttackRange_S - myHealthDmg_S;
            if (bestHealthDmgDiff != otherHealthDmgDiff) {
                bestWins = (bestHealthDmgDiff < otherHealthDmgDiff);
                break chooseBest0S;
            }

            if (actionReady) {
                // If I can attack at either square, prefer the one which lets me attack a low health tower.
                if (canLandHit_best && canLandHit_S) {
                    if (towerHealth_best != towerHealth_S) {
                        bestWins = towerHealth_best < towerHealth_S;
                        break chooseBest0S;
                    }
                }

                // If I can attack, choose the square which lets me land a hit.
                if (canLandHit_best != canLandHit_S) {
                    bestWins = canLandHit_best;
                    break chooseBest0S;
                }
            } else {
                // If I can't attack, choose the square which gets me out of action radius.
                if (canBeHit_best != canBeHit_S) {
                    bestWins = !canBeHit_best;
                    break chooseBest0S;
                }
            }

            // If both squares are in action radius, prefer the one which lets you get out of action radius.
            if (canBeHit_best && canBeHit_S) {
                if ((minDistToEnemy_best <= 2) != (minDistToEnemy_S <= 2)) {
                    bestWins = !(minDistToEnemy_best <= 2);
                    break chooseBest0S;
                }
            }

            // If I can't land a hit at either square, prefer the one which is closer.
            // This is necessary if we're far away, but if we can already land a hit,
            // Then there's really no difference between these two squares, so we should go for penalty instead.
            else if (!canLandHit_C && !canLandHit_best && !canLandHit_S) {
                if (minDistToEnemy_best != minDistToEnemy_S) {
                    bestWins = minDistToEnemy_best < minDistToEnemy_S;
                    break chooseBest0S;
                }
            }

            // All else equal, prefer the square with better paint penalty.
            bestWins = (penalty_best <= penalty_S);
            break chooseBest0S;
        }
        
        
        if (!bestWins) {
            targetLoc_best = targetLoc_S;
            canMove_best = canMove_S;
            healthDmgAttackRange_best = healthDmgAttackRange_S;
            myHealthDmg_best = myHealthDmg_S;
            minDistToEnemy_best = minDistToEnemy_S;
            penalty_best = penalty_S;
            towerHealth_best = towerHealth_S;
            canBeHit_best = canBeHit_S;
            canLandHit_best = canLandHit_S;
            bestDir = Direction.SOUTH;
        }
        
        
        bestWins = canMove_best;
        chooseBest0SW: {
            if (!canMove_SW || !canMove_best) break chooseBest0SW;

            // Choose the square where I deal the most net damage.
            double bestHealthDmgDiff = healthDmgAttackRange_best - myHealthDmg_best;
            double otherHealthDmgDiff = healthDmgAttackRange_SW - myHealthDmg_SW;
            if (bestHealthDmgDiff != otherHealthDmgDiff) {
                bestWins = (bestHealthDmgDiff < otherHealthDmgDiff);
                break chooseBest0SW;
            }

            if (actionReady) {
                // If I can attack at either square, prefer the one which lets me attack a low health tower.
                if (canLandHit_best && canLandHit_SW) {
                    if (towerHealth_best != towerHealth_SW) {
                        bestWins = towerHealth_best < towerHealth_SW;
                        break chooseBest0SW;
                    }
                }

                // If I can attack, choose the square which lets me land a hit.
                if (canLandHit_best != canLandHit_SW) {
                    bestWins = canLandHit_best;
                    break chooseBest0SW;
                }
            } else {
                // If I can't attack, choose the square which gets me out of action radius.
                if (canBeHit_best != canBeHit_SW) {
                    bestWins = !canBeHit_best;
                    break chooseBest0SW;
                }
            }

            // If both squares are in action radius, prefer the one which lets you get out of action radius.
            if (canBeHit_best && canBeHit_SW) {
                if ((minDistToEnemy_best <= 2) != (minDistToEnemy_SW <= 2)) {
                    bestWins = !(minDistToEnemy_best <= 2);
                    break chooseBest0SW;
                }
            }

            // If I can't land a hit at either square, prefer the one which is closer.
            // This is necessary if we're far away, but if we can already land a hit,
            // Then there's really no difference between these two squares, so we should go for penalty instead.
            else if (!canLandHit_C && !canLandHit_best && !canLandHit_SW) {
                if (minDistToEnemy_best != minDistToEnemy_SW) {
                    bestWins = minDistToEnemy_best < minDistToEnemy_SW;
                    break chooseBest0SW;
                }
            }

            // All else equal, prefer the square with better paint penalty.
            bestWins = (penalty_best <= penalty_SW);
            break chooseBest0SW;
        }
        
        
        if (!bestWins) {
            targetLoc_best = targetLoc_SW;
            canMove_best = canMove_SW;
            healthDmgAttackRange_best = healthDmgAttackRange_SW;
            myHealthDmg_best = myHealthDmg_SW;
            minDistToEnemy_best = minDistToEnemy_SW;
            penalty_best = penalty_SW;
            towerHealth_best = towerHealth_SW;
            canBeHit_best = canBeHit_SW;
            canLandHit_best = canLandHit_SW;
            bestDir = Direction.SOUTHWEST;
        }
        
        
        bestWins = canMove_best;
        chooseBest0W: {
            if (!canMove_W || !canMove_best) break chooseBest0W;

            // Choose the square where I deal the most net damage.
            double bestHealthDmgDiff = healthDmgAttackRange_best - myHealthDmg_best;
            double otherHealthDmgDiff = healthDmgAttackRange_W - myHealthDmg_W;
            if (bestHealthDmgDiff != otherHealthDmgDiff) {
                bestWins = (bestHealthDmgDiff < otherHealthDmgDiff);
                break chooseBest0W;
            }

            if (actionReady) {
                // If I can attack at either square, prefer the one which lets me attack a low health tower.
                if (canLandHit_best && canLandHit_W) {
                    if (towerHealth_best != towerHealth_W) {
                        bestWins = towerHealth_best < towerHealth_W;
                        break chooseBest0W;
                    }
                }

                // If I can attack, choose the square which lets me land a hit.
                if (canLandHit_best != canLandHit_W) {
                    bestWins = canLandHit_best;
                    break chooseBest0W;
                }
            } else {
                // If I can't attack, choose the square which gets me out of action radius.
                if (canBeHit_best != canBeHit_W) {
                    bestWins = !canBeHit_best;
                    break chooseBest0W;
                }
            }

            // If both squares are in action radius, prefer the one which lets you get out of action radius.
            if (canBeHit_best && canBeHit_W) {
                if ((minDistToEnemy_best <= 2) != (minDistToEnemy_W <= 2)) {
                    bestWins = !(minDistToEnemy_best <= 2);
                    break chooseBest0W;
                }
            }

            // If I can't land a hit at either square, prefer the one which is closer.
            // This is necessary if we're far away, but if we can already land a hit,
            // Then there's really no difference between these two squares, so we should go for penalty instead.
            else if (!canLandHit_C && !canLandHit_best && !canLandHit_W) {
                if (minDistToEnemy_best != minDistToEnemy_W) {
                    bestWins = minDistToEnemy_best < minDistToEnemy_W;
                    break chooseBest0W;
                }
            }

            // All else equal, prefer the square with better paint penalty.
            bestWins = (penalty_best <= penalty_W);
            break chooseBest0W;
        }
        
        
        if (!bestWins) {
            targetLoc_best = targetLoc_W;
            canMove_best = canMove_W;
            healthDmgAttackRange_best = healthDmgAttackRange_W;
            myHealthDmg_best = myHealthDmg_W;
            minDistToEnemy_best = minDistToEnemy_W;
            penalty_best = penalty_W;
            towerHealth_best = towerHealth_W;
            canBeHit_best = canBeHit_W;
            canLandHit_best = canLandHit_W;
            bestDir = Direction.WEST;
        }
        
        
        bestWins = canMove_best;
        chooseBest0NW: {
            if (!canMove_NW || !canMove_best) break chooseBest0NW;

            // Choose the square where I deal the most net damage.
            double bestHealthDmgDiff = healthDmgAttackRange_best - myHealthDmg_best;
            double otherHealthDmgDiff = healthDmgAttackRange_NW - myHealthDmg_NW;
            if (bestHealthDmgDiff != otherHealthDmgDiff) {
                bestWins = (bestHealthDmgDiff < otherHealthDmgDiff);
                break chooseBest0NW;
            }

            if (actionReady) {
                // If I can attack at either square, prefer the one which lets me attack a low health tower.
                if (canLandHit_best && canLandHit_NW) {
                    if (towerHealth_best != towerHealth_NW) {
                        bestWins = towerHealth_best < towerHealth_NW;
                        break chooseBest0NW;
                    }
                }

                // If I can attack, choose the square which lets me land a hit.
                if (canLandHit_best != canLandHit_NW) {
                    bestWins = canLandHit_best;
                    break chooseBest0NW;
                }
            } else {
                // If I can't attack, choose the square which gets me out of action radius.
                if (canBeHit_best != canBeHit_NW) {
                    bestWins = !canBeHit_best;
                    break chooseBest0NW;
                }
            }

            // If both squares are in action radius, prefer the one which lets you get out of action radius.
            if (canBeHit_best && canBeHit_NW) {
                if ((minDistToEnemy_best <= 2) != (minDistToEnemy_NW <= 2)) {
                    bestWins = !(minDistToEnemy_best <= 2);
                    break chooseBest0NW;
                }
            }

            // If I can't land a hit at either square, prefer the one which is closer.
            // This is necessary if we're far away, but if we can already land a hit,
            // Then there's really no difference between these two squares, so we should go for penalty instead.
            else if (!canLandHit_C && !canLandHit_best && !canLandHit_NW) {
                if (minDistToEnemy_best != minDistToEnemy_NW) {
                    bestWins = minDistToEnemy_best < minDistToEnemy_NW;
                    break chooseBest0NW;
                }
            }

            // All else equal, prefer the square with better paint penalty.
            bestWins = (penalty_best <= penalty_NW);
            break chooseBest0NW;
        }
        
        
        if (!bestWins) {
            targetLoc_best = targetLoc_NW;
            canMove_best = canMove_NW;
            healthDmgAttackRange_best = healthDmgAttackRange_NW;
            myHealthDmg_best = myHealthDmg_NW;
            minDistToEnemy_best = minDistToEnemy_NW;
            penalty_best = penalty_NW;
            towerHealth_best = towerHealth_NW;
            canBeHit_best = canBeHit_NW;
            canLandHit_best = canLandHit_NW;
            bestDir = Direction.NORTHWEST;
        }
        
        
        bestWins = canMove_best;
        chooseBest0C: {
            if (!canMove_C || !canMove_best) break chooseBest0C;

            // Choose the square where I deal the most net damage.
            double bestHealthDmgDiff = healthDmgAttackRange_best - myHealthDmg_best;
            double otherHealthDmgDiff = healthDmgAttackRange_C - myHealthDmg_C;
            if (bestHealthDmgDiff != otherHealthDmgDiff) {
                bestWins = (bestHealthDmgDiff < otherHealthDmgDiff);
                break chooseBest0C;
            }

            if (actionReady) {
                // If I can attack at either square, prefer the one which lets me attack a low health tower.
                if (canLandHit_best && canLandHit_C) {
                    if (towerHealth_best != towerHealth_C) {
                        bestWins = towerHealth_best < towerHealth_C;
                        break chooseBest0C;
                    }
                }

                // If I can attack, choose the square which lets me land a hit.
                if (canLandHit_best != canLandHit_C) {
                    bestWins = canLandHit_best;
                    break chooseBest0C;
                }
            } else {
                // If I can't attack, choose the square which gets me out of action radius.
                if (canBeHit_best != canBeHit_C) {
                    bestWins = !canBeHit_best;
                    break chooseBest0C;
                }
            }

            // If both squares are in action radius, prefer the one which lets you get out of action radius.
            if (canBeHit_best && canBeHit_C) {
                if ((minDistToEnemy_best <= 2) != (minDistToEnemy_C <= 2)) {
                    bestWins = !(minDistToEnemy_best <= 2);
                    break chooseBest0C;
                }
            }

            // If I can't land a hit at either square, prefer the one which is closer.
            // This is necessary if we're far away, but if we can already land a hit,
            // Then there's really no difference between these two squares, so we should go for penalty instead.
            else if (!canLandHit_C && !canLandHit_best && !canLandHit_C) {
                if (minDistToEnemy_best != minDistToEnemy_C) {
                    bestWins = minDistToEnemy_best < minDistToEnemy_C;
                    break chooseBest0C;
                }
            }

            // All else equal, prefer the square with better paint penalty.
            bestWins = (penalty_best <= penalty_C);
            break chooseBest0C;
        }
        
        
        if (!bestWins) {
            targetLoc_best = targetLoc_C;
            canMove_best = canMove_C;
            healthDmgAttackRange_best = healthDmgAttackRange_C;
            myHealthDmg_best = myHealthDmg_C;
            minDistToEnemy_best = minDistToEnemy_C;
            penalty_best = penalty_C;
            towerHealth_best = towerHealth_C;
            canBeHit_best = canBeHit_C;
            canLandHit_best = canLandHit_C;
            bestDir = Direction.CENTER;
        }
        
        

        
        System.out.println("[246] " + "minDistToEnemy_best = " + minDistToEnemy_best + ", " + "targetLoc_best.x = " + targetLoc_best.x + ", " + "canMove_best = " + canMove_best + ", " + "targetLoc_best.y = " + targetLoc_best.y + ", " + "penalty_best = " + penalty_best + ", " + "healthDmgAttackRange_best = " + healthDmgAttackRange_best + ", " + "myHealthDmg_best = " + myHealthDmg_best + ", " + "towerHealth_best = " + towerHealth_best + ", " + "canBeHit_best = " + canBeHit_best + ", " + "canLandHit_best = " + canLandHit_best);
        System.out.println("Chose: " + bestDir);
        System.out.println("\n");

        if (rc.canMove(bestDir)) {
            Pathing.move(bestDir);
        }
        splasherTryAttack();
    }
    
    

}