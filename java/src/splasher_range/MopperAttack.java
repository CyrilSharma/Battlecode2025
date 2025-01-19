package splasher_range;
import battlecode.common.*;

public class MopperAttack {
    public static RobotController rc;

    
    public static int mopperActionRadiusSquared;
    public static int mopperPaintCapacity;
    public static int mopperActionCooldown;
    public static void init(RobotController rc) {
        MopperAttack.rc = rc;
        mopperActionRadiusSquared = UnitType.MOPPER.actionRadiusSquared;
        mopperPaintCapacity = UnitType.MOPPER.paintCapacity;
        mopperActionCooldown = UnitType.MOPPER.actionCooldown;
        
    }

    public static boolean shouldMopperMicro() throws GameActionException {
        for (int i = Globals.enemies.length; --i >= 0; ) {
            switch (Globals.enemies[i].type) {
                case SOLDIER, MOPPER, SPLASHER: return true;
                default: return true;
            }
        }
        return false;
    }

    public static void mopperTryAttack() throws GameActionException {
        if ((rc.getPaint() < (UnitType.MOPPER.paintCapacity >> 1))
         || (Globals.enemies.length == 1)) {
            mopperHealAttack();
        } else {
            mopperMopAttack();
        }
    }

    public static void mopperHealAttack() throws GameActionException {
        for (int i = Globals.enemies.length; --i >= 0; ) {
            switch (Globals.enemies[i].type) {
                case SOLDIER, MOPPER, SPLASHER: {
                    if (rc.canAttack(Globals.enemies[i].location)) {
                        rc.attack(Globals.enemies[i].location);
                        return;
                    }
                }
                default: continue;
            }
        }
    }

    public static void mopperMopAttack() throws GameActionException {
        if (!rc.isActionReady()) return;
        MapLocation myloc = rc.getLocation();
        int x = myloc.x, y = myloc.y;
        
        
        boolean enemy00 = false;
        MapLocation mloc00 = new MapLocation(x + -3, y + -3);
        boolean canSense00 = rc.canSenseLocation(mloc00);
        if (canSense00) {
            RobotInfo r = rc.senseRobotAtLocation( mloc00);
            if (r != null && r.team != rc.getTeam() && r.paintAmount != 0)
                enemy00 = true;
        }
        
        boolean enemy01 = false;
        MapLocation mloc01 = new MapLocation(x + -3, y + -2);
        boolean canSense01 = rc.canSenseLocation(mloc01);
        if (canSense01) {
            RobotInfo r = rc.senseRobotAtLocation( mloc01);
            if (r != null && r.team != rc.getTeam() && r.paintAmount != 0)
                enemy01 = true;
        }
        
        boolean enemy02 = false;
        MapLocation mloc02 = new MapLocation(x + -3, y + -1);
        boolean canSense02 = rc.canSenseLocation(mloc02);
        if (canSense02) {
            RobotInfo r = rc.senseRobotAtLocation( mloc02);
            if (r != null && r.team != rc.getTeam() && r.paintAmount != 0)
                enemy02 = true;
        }
        
        boolean enemy03 = false;
        MapLocation mloc03 = new MapLocation(x + -3, y + 0);
        boolean canSense03 = rc.canSenseLocation(mloc03);
        if (canSense03) {
            RobotInfo r = rc.senseRobotAtLocation( mloc03);
            if (r != null && r.team != rc.getTeam() && r.paintAmount != 0)
                enemy03 = true;
        }
        
        boolean enemy04 = false;
        MapLocation mloc04 = new MapLocation(x + -3, y + 1);
        boolean canSense04 = rc.canSenseLocation(mloc04);
        if (canSense04) {
            RobotInfo r = rc.senseRobotAtLocation( mloc04);
            if (r != null && r.team != rc.getTeam() && r.paintAmount != 0)
                enemy04 = true;
        }
        
        boolean enemy05 = false;
        MapLocation mloc05 = new MapLocation(x + -3, y + 2);
        boolean canSense05 = rc.canSenseLocation(mloc05);
        if (canSense05) {
            RobotInfo r = rc.senseRobotAtLocation( mloc05);
            if (r != null && r.team != rc.getTeam() && r.paintAmount != 0)
                enemy05 = true;
        }
        
        boolean enemy06 = false;
        MapLocation mloc06 = new MapLocation(x + -3, y + 3);
        boolean canSense06 = rc.canSenseLocation(mloc06);
        if (canSense06) {
            RobotInfo r = rc.senseRobotAtLocation( mloc06);
            if (r != null && r.team != rc.getTeam() && r.paintAmount != 0)
                enemy06 = true;
        }
        
        
        
        boolean enemy10 = false;
        MapLocation mloc10 = new MapLocation(x + -2, y + -3);
        boolean canSense10 = rc.canSenseLocation(mloc10);
        if (canSense10) {
            RobotInfo r = rc.senseRobotAtLocation( mloc10);
            if (r != null && r.team != rc.getTeam() && r.paintAmount != 0)
                enemy10 = true;
        }
        
        boolean enemy11 = false;
        MapLocation mloc11 = new MapLocation(x + -2, y + -2);
        boolean canSense11 = rc.canSenseLocation(mloc11);
        if (canSense11) {
            RobotInfo r = rc.senseRobotAtLocation( mloc11);
            if (r != null && r.team != rc.getTeam() && r.paintAmount != 0)
                enemy11 = true;
        }
        
        boolean enemy12 = false;
        MapLocation mloc12 = new MapLocation(x + -2, y + -1);
        boolean canSense12 = rc.canSenseLocation(mloc12);
        if (canSense12) {
            RobotInfo r = rc.senseRobotAtLocation( mloc12);
            if (r != null && r.team != rc.getTeam() && r.paintAmount != 0)
                enemy12 = true;
        }
        
        boolean enemy13 = false;
        MapLocation mloc13 = new MapLocation(x + -2, y + 0);
        boolean canSense13 = rc.canSenseLocation(mloc13);
        if (canSense13) {
            RobotInfo r = rc.senseRobotAtLocation( mloc13);
            if (r != null && r.team != rc.getTeam() && r.paintAmount != 0)
                enemy13 = true;
        }
        
        boolean enemy14 = false;
        MapLocation mloc14 = new MapLocation(x + -2, y + 1);
        boolean canSense14 = rc.canSenseLocation(mloc14);
        if (canSense14) {
            RobotInfo r = rc.senseRobotAtLocation( mloc14);
            if (r != null && r.team != rc.getTeam() && r.paintAmount != 0)
                enemy14 = true;
        }
        
        boolean enemy15 = false;
        MapLocation mloc15 = new MapLocation(x + -2, y + 2);
        boolean canSense15 = rc.canSenseLocation(mloc15);
        if (canSense15) {
            RobotInfo r = rc.senseRobotAtLocation( mloc15);
            if (r != null && r.team != rc.getTeam() && r.paintAmount != 0)
                enemy15 = true;
        }
        
        boolean enemy16 = false;
        MapLocation mloc16 = new MapLocation(x + -2, y + 3);
        boolean canSense16 = rc.canSenseLocation(mloc16);
        if (canSense16) {
            RobotInfo r = rc.senseRobotAtLocation( mloc16);
            if (r != null && r.team != rc.getTeam() && r.paintAmount != 0)
                enemy16 = true;
        }
        
        
        
        boolean enemy20 = false;
        MapLocation mloc20 = new MapLocation(x + -1, y + -3);
        boolean canSense20 = rc.canSenseLocation(mloc20);
        if (canSense20) {
            RobotInfo r = rc.senseRobotAtLocation( mloc20);
            if (r != null && r.team != rc.getTeam() && r.paintAmount != 0)
                enemy20 = true;
        }
        
        boolean enemy21 = false;
        MapLocation mloc21 = new MapLocation(x + -1, y + -2);
        boolean canSense21 = rc.canSenseLocation(mloc21);
        if (canSense21) {
            RobotInfo r = rc.senseRobotAtLocation( mloc21);
            if (r != null && r.team != rc.getTeam() && r.paintAmount != 0)
                enemy21 = true;
        }
        
        boolean enemy22 = false;
        MapLocation mloc22 = new MapLocation(x + -1, y + -1);
        boolean canSense22 = rc.canSenseLocation(mloc22);
        if (canSense22) {
            RobotInfo r = rc.senseRobotAtLocation( mloc22);
            if (r != null && r.team != rc.getTeam() && r.paintAmount != 0)
                enemy22 = true;
        }
        
        boolean enemy23 = false;
        MapLocation mloc23 = new MapLocation(x + -1, y + 0);
        boolean canSense23 = rc.canSenseLocation(mloc23);
        if (canSense23) {
            RobotInfo r = rc.senseRobotAtLocation( mloc23);
            if (r != null && r.team != rc.getTeam() && r.paintAmount != 0)
                enemy23 = true;
        }
        
        boolean enemy24 = false;
        MapLocation mloc24 = new MapLocation(x + -1, y + 1);
        boolean canSense24 = rc.canSenseLocation(mloc24);
        if (canSense24) {
            RobotInfo r = rc.senseRobotAtLocation( mloc24);
            if (r != null && r.team != rc.getTeam() && r.paintAmount != 0)
                enemy24 = true;
        }
        
        boolean enemy25 = false;
        MapLocation mloc25 = new MapLocation(x + -1, y + 2);
        boolean canSense25 = rc.canSenseLocation(mloc25);
        if (canSense25) {
            RobotInfo r = rc.senseRobotAtLocation( mloc25);
            if (r != null && r.team != rc.getTeam() && r.paintAmount != 0)
                enemy25 = true;
        }
        
        boolean enemy26 = false;
        MapLocation mloc26 = new MapLocation(x + -1, y + 3);
        boolean canSense26 = rc.canSenseLocation(mloc26);
        if (canSense26) {
            RobotInfo r = rc.senseRobotAtLocation( mloc26);
            if (r != null && r.team != rc.getTeam() && r.paintAmount != 0)
                enemy26 = true;
        }
        
        
        
        boolean enemy30 = false;
        MapLocation mloc30 = new MapLocation(x + 0, y + -3);
        boolean canSense30 = rc.canSenseLocation(mloc30);
        if (canSense30) {
            RobotInfo r = rc.senseRobotAtLocation( mloc30);
            if (r != null && r.team != rc.getTeam() && r.paintAmount != 0)
                enemy30 = true;
        }
        
        boolean enemy31 = false;
        MapLocation mloc31 = new MapLocation(x + 0, y + -2);
        boolean canSense31 = rc.canSenseLocation(mloc31);
        if (canSense31) {
            RobotInfo r = rc.senseRobotAtLocation( mloc31);
            if (r != null && r.team != rc.getTeam() && r.paintAmount != 0)
                enemy31 = true;
        }
        
        boolean enemy32 = false;
        MapLocation mloc32 = new MapLocation(x + 0, y + -1);
        boolean canSense32 = rc.canSenseLocation(mloc32);
        if (canSense32) {
            RobotInfo r = rc.senseRobotAtLocation( mloc32);
            if (r != null && r.team != rc.getTeam() && r.paintAmount != 0)
                enemy32 = true;
        }
        
        boolean enemy33 = false;
        MapLocation mloc33 = new MapLocation(x + 0, y + 0);
        boolean canSense33 = rc.canSenseLocation(mloc33);
        if (canSense33) {
            RobotInfo r = rc.senseRobotAtLocation( mloc33);
            if (r != null && r.team != rc.getTeam() && r.paintAmount != 0)
                enemy33 = true;
        }
        
        boolean enemy34 = false;
        MapLocation mloc34 = new MapLocation(x + 0, y + 1);
        boolean canSense34 = rc.canSenseLocation(mloc34);
        if (canSense34) {
            RobotInfo r = rc.senseRobotAtLocation( mloc34);
            if (r != null && r.team != rc.getTeam() && r.paintAmount != 0)
                enemy34 = true;
        }
        
        boolean enemy35 = false;
        MapLocation mloc35 = new MapLocation(x + 0, y + 2);
        boolean canSense35 = rc.canSenseLocation(mloc35);
        if (canSense35) {
            RobotInfo r = rc.senseRobotAtLocation( mloc35);
            if (r != null && r.team != rc.getTeam() && r.paintAmount != 0)
                enemy35 = true;
        }
        
        boolean enemy36 = false;
        MapLocation mloc36 = new MapLocation(x + 0, y + 3);
        boolean canSense36 = rc.canSenseLocation(mloc36);
        if (canSense36) {
            RobotInfo r = rc.senseRobotAtLocation( mloc36);
            if (r != null && r.team != rc.getTeam() && r.paintAmount != 0)
                enemy36 = true;
        }
        
        
        
        boolean enemy40 = false;
        MapLocation mloc40 = new MapLocation(x + 1, y + -3);
        boolean canSense40 = rc.canSenseLocation(mloc40);
        if (canSense40) {
            RobotInfo r = rc.senseRobotAtLocation( mloc40);
            if (r != null && r.team != rc.getTeam() && r.paintAmount != 0)
                enemy40 = true;
        }
        
        boolean enemy41 = false;
        MapLocation mloc41 = new MapLocation(x + 1, y + -2);
        boolean canSense41 = rc.canSenseLocation(mloc41);
        if (canSense41) {
            RobotInfo r = rc.senseRobotAtLocation( mloc41);
            if (r != null && r.team != rc.getTeam() && r.paintAmount != 0)
                enemy41 = true;
        }
        
        boolean enemy42 = false;
        MapLocation mloc42 = new MapLocation(x + 1, y + -1);
        boolean canSense42 = rc.canSenseLocation(mloc42);
        if (canSense42) {
            RobotInfo r = rc.senseRobotAtLocation( mloc42);
            if (r != null && r.team != rc.getTeam() && r.paintAmount != 0)
                enemy42 = true;
        }
        
        boolean enemy43 = false;
        MapLocation mloc43 = new MapLocation(x + 1, y + 0);
        boolean canSense43 = rc.canSenseLocation(mloc43);
        if (canSense43) {
            RobotInfo r = rc.senseRobotAtLocation( mloc43);
            if (r != null && r.team != rc.getTeam() && r.paintAmount != 0)
                enemy43 = true;
        }
        
        boolean enemy44 = false;
        MapLocation mloc44 = new MapLocation(x + 1, y + 1);
        boolean canSense44 = rc.canSenseLocation(mloc44);
        if (canSense44) {
            RobotInfo r = rc.senseRobotAtLocation( mloc44);
            if (r != null && r.team != rc.getTeam() && r.paintAmount != 0)
                enemy44 = true;
        }
        
        boolean enemy45 = false;
        MapLocation mloc45 = new MapLocation(x + 1, y + 2);
        boolean canSense45 = rc.canSenseLocation(mloc45);
        if (canSense45) {
            RobotInfo r = rc.senseRobotAtLocation( mloc45);
            if (r != null && r.team != rc.getTeam() && r.paintAmount != 0)
                enemy45 = true;
        }
        
        boolean enemy46 = false;
        MapLocation mloc46 = new MapLocation(x + 1, y + 3);
        boolean canSense46 = rc.canSenseLocation(mloc46);
        if (canSense46) {
            RobotInfo r = rc.senseRobotAtLocation( mloc46);
            if (r != null && r.team != rc.getTeam() && r.paintAmount != 0)
                enemy46 = true;
        }
        
        
        
        boolean enemy50 = false;
        MapLocation mloc50 = new MapLocation(x + 2, y + -3);
        boolean canSense50 = rc.canSenseLocation(mloc50);
        if (canSense50) {
            RobotInfo r = rc.senseRobotAtLocation( mloc50);
            if (r != null && r.team != rc.getTeam() && r.paintAmount != 0)
                enemy50 = true;
        }
        
        boolean enemy51 = false;
        MapLocation mloc51 = new MapLocation(x + 2, y + -2);
        boolean canSense51 = rc.canSenseLocation(mloc51);
        if (canSense51) {
            RobotInfo r = rc.senseRobotAtLocation( mloc51);
            if (r != null && r.team != rc.getTeam() && r.paintAmount != 0)
                enemy51 = true;
        }
        
        boolean enemy52 = false;
        MapLocation mloc52 = new MapLocation(x + 2, y + -1);
        boolean canSense52 = rc.canSenseLocation(mloc52);
        if (canSense52) {
            RobotInfo r = rc.senseRobotAtLocation( mloc52);
            if (r != null && r.team != rc.getTeam() && r.paintAmount != 0)
                enemy52 = true;
        }
        
        boolean enemy53 = false;
        MapLocation mloc53 = new MapLocation(x + 2, y + 0);
        boolean canSense53 = rc.canSenseLocation(mloc53);
        if (canSense53) {
            RobotInfo r = rc.senseRobotAtLocation( mloc53);
            if (r != null && r.team != rc.getTeam() && r.paintAmount != 0)
                enemy53 = true;
        }
        
        boolean enemy54 = false;
        MapLocation mloc54 = new MapLocation(x + 2, y + 1);
        boolean canSense54 = rc.canSenseLocation(mloc54);
        if (canSense54) {
            RobotInfo r = rc.senseRobotAtLocation( mloc54);
            if (r != null && r.team != rc.getTeam() && r.paintAmount != 0)
                enemy54 = true;
        }
        
        boolean enemy55 = false;
        MapLocation mloc55 = new MapLocation(x + 2, y + 2);
        boolean canSense55 = rc.canSenseLocation(mloc55);
        if (canSense55) {
            RobotInfo r = rc.senseRobotAtLocation( mloc55);
            if (r != null && r.team != rc.getTeam() && r.paintAmount != 0)
                enemy55 = true;
        }
        
        boolean enemy56 = false;
        MapLocation mloc56 = new MapLocation(x + 2, y + 3);
        boolean canSense56 = rc.canSenseLocation(mloc56);
        if (canSense56) {
            RobotInfo r = rc.senseRobotAtLocation( mloc56);
            if (r != null && r.team != rc.getTeam() && r.paintAmount != 0)
                enemy56 = true;
        }
        
        
        
        boolean enemy60 = false;
        MapLocation mloc60 = new MapLocation(x + 3, y + -3);
        boolean canSense60 = rc.canSenseLocation(mloc60);
        if (canSense60) {
            RobotInfo r = rc.senseRobotAtLocation( mloc60);
            if (r != null && r.team != rc.getTeam() && r.paintAmount != 0)
                enemy60 = true;
        }
        
        boolean enemy61 = false;
        MapLocation mloc61 = new MapLocation(x + 3, y + -2);
        boolean canSense61 = rc.canSenseLocation(mloc61);
        if (canSense61) {
            RobotInfo r = rc.senseRobotAtLocation( mloc61);
            if (r != null && r.team != rc.getTeam() && r.paintAmount != 0)
                enemy61 = true;
        }
        
        boolean enemy62 = false;
        MapLocation mloc62 = new MapLocation(x + 3, y + -1);
        boolean canSense62 = rc.canSenseLocation(mloc62);
        if (canSense62) {
            RobotInfo r = rc.senseRobotAtLocation( mloc62);
            if (r != null && r.team != rc.getTeam() && r.paintAmount != 0)
                enemy62 = true;
        }
        
        boolean enemy63 = false;
        MapLocation mloc63 = new MapLocation(x + 3, y + 0);
        boolean canSense63 = rc.canSenseLocation(mloc63);
        if (canSense63) {
            RobotInfo r = rc.senseRobotAtLocation( mloc63);
            if (r != null && r.team != rc.getTeam() && r.paintAmount != 0)
                enemy63 = true;
        }
        
        boolean enemy64 = false;
        MapLocation mloc64 = new MapLocation(x + 3, y + 1);
        boolean canSense64 = rc.canSenseLocation(mloc64);
        if (canSense64) {
            RobotInfo r = rc.senseRobotAtLocation( mloc64);
            if (r != null && r.team != rc.getTeam() && r.paintAmount != 0)
                enemy64 = true;
        }
        
        boolean enemy65 = false;
        MapLocation mloc65 = new MapLocation(x + 3, y + 2);
        boolean canSense65 = rc.canSenseLocation(mloc65);
        if (canSense65) {
            RobotInfo r = rc.senseRobotAtLocation( mloc65);
            if (r != null && r.team != rc.getTeam() && r.paintAmount != 0)
                enemy65 = true;
        }
        
        boolean enemy66 = false;
        MapLocation mloc66 = new MapLocation(x + 3, y + 3);
        boolean canSense66 = rc.canSenseLocation(mloc66);
        if (canSense66) {
            RobotInfo r = rc.senseRobotAtLocation( mloc66);
            if (r != null && r.team != rc.getTeam() && r.paintAmount != 0)
                enemy66 = true;
        }
        
        

        MapLocation bestLoc = null;
        int count = 0, bestCount = -1;
        
        
        
        if (canSense22) {
            count = 0;
            
             
            
            
            if (enemy13) ++count;
             
            
            
            if (enemy02) ++count;
            
            
             
            
            
            if (enemy22) ++count;
             
            
            
            if (enemy11) ++count;
            
            
             
            
            
            if (enemy31) ++count;
             
            
            
            if (enemy20) ++count;
            
            
            if (count > bestCount) {
                bestLoc = mloc22;
                bestCount = count;
            }
        }
        
        
        
        if (canSense23) {
            count = 0;
            
             
            
            
            if (enemy24) ++count;
             
            
            
            if (enemy14) ++count;
            
            
             
            
            
            if (enemy23) ++count;
             
            
            
            if (enemy13) ++count;
            
            
             
            
            
            if (enemy22) ++count;
             
            
            
            if (enemy12) ++count;
            
            
            if (count > bestCount) {
                bestLoc = mloc23;
                bestCount = count;
            }
        }
        
        
        
        if (canSense24) {
            count = 0;
            
             
            
            
            if (enemy35) ++count;
             
            
            
            if (enemy26) ++count;
            
            
             
            
            
            if (enemy24) ++count;
             
            
            
            if (enemy15) ++count;
            
            
             
            
            
            if (enemy13) ++count;
             
            
            
            if (enemy04) ++count;
            
            
            if (count > bestCount) {
                bestLoc = mloc24;
                bestCount = count;
            }
        }
        
        
        
        
        
        if (canSense32) {
            count = 0;
            
             
            
            
            if (enemy22) ++count;
             
            
            
            if (enemy21) ++count;
            
            
             
            
            
            if (enemy32) ++count;
             
            
            
            if (enemy31) ++count;
            
            
             
            
            
            if (enemy42) ++count;
             
            
            
            if (enemy41) ++count;
            
            
            if (count > bestCount) {
                bestLoc = mloc32;
                bestCount = count;
            }
        }
        
        
        
        
        
        if (canSense34) {
            count = 0;
            
             
            
            
            if (enemy44) ++count;
             
            
            
            if (enemy45) ++count;
            
            
             
            
            
            if (enemy34) ++count;
             
            
            
            if (enemy35) ++count;
            
            
             
            
            
            if (enemy24) ++count;
             
            
            
            if (enemy25) ++count;
            
            
            if (count > bestCount) {
                bestLoc = mloc34;
                bestCount = count;
            }
        }
        
        
        
        
        
        if (canSense42) {
            count = 0;
            
             
            
            
            if (enemy31) ++count;
             
            
            
            if (enemy40) ++count;
            
            
             
            
            
            if (enemy42) ++count;
             
            
            
            if (enemy51) ++count;
            
            
             
            
            
            if (enemy53) ++count;
             
            
            
            if (enemy62) ++count;
            
            
            if (count > bestCount) {
                bestLoc = mloc42;
                bestCount = count;
            }
        }
        
        
        
        if (canSense43) {
            count = 0;
            
             
            
            
            if (enemy42) ++count;
             
            
            
            if (enemy52) ++count;
            
            
             
            
            
            if (enemy43) ++count;
             
            
            
            if (enemy53) ++count;
            
            
             
            
            
            if (enemy44) ++count;
             
            
            
            if (enemy54) ++count;
            
            
            if (count > bestCount) {
                bestLoc = mloc43;
                bestCount = count;
            }
        }
        
        
        
        if (canSense44) {
            count = 0;
            
             
            
            
            if (enemy53) ++count;
             
            
            
            if (enemy64) ++count;
            
            
             
            
            
            if (enemy44) ++count;
             
            
            
            if (enemy55) ++count;
            
            
             
            
            
            if (enemy35) ++count;
             
            
            
            if (enemy46) ++count;
            
            
            if (count > bestCount) {
                bestLoc = mloc44;
                bestCount = count;
            }
        }
        
        
        

        rc.setIndicatorString("bestCount: " + bestCount + " " + bestLoc.x + " " + bestLoc.y);
        if (bestCount >= 1) {
            rc.mopSwing(myloc.directionTo(bestLoc));
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

    public static void mopperAttackMicro() throws GameActionException {
        mopperTryAttack();
        MapLocation myloc = rc.getLocation();
        MapLocation targetLoc_N = myloc.add(Direction.NORTH);
        boolean canMove_N = (rc.canMove(Direction.NORTH));
        PaintType paint_N = PaintType.ENEMY_PRIMARY;
        if (rc.canSenseLocation(targetLoc_N)) {
            paint_N = rc.senseMapInfo(targetLoc_N).getPaint();
        }
        double paintDmgAttackRange_N = 0;
        double myPaintDmg_N = 0;
        int minDistToEnemy_N = 100000;
        
        MapLocation targetLoc_NE = myloc.add(Direction.NORTHEAST);
        boolean canMove_NE = (rc.canMove(Direction.NORTHEAST));
        PaintType paint_NE = PaintType.ENEMY_PRIMARY;
        if (rc.canSenseLocation(targetLoc_NE)) {
            paint_NE = rc.senseMapInfo(targetLoc_NE).getPaint();
        }
        double paintDmgAttackRange_NE = 0;
        double myPaintDmg_NE = 0;
        int minDistToEnemy_NE = 100000;
        
        MapLocation targetLoc_E = myloc.add(Direction.EAST);
        boolean canMove_E = (rc.canMove(Direction.EAST));
        PaintType paint_E = PaintType.ENEMY_PRIMARY;
        if (rc.canSenseLocation(targetLoc_E)) {
            paint_E = rc.senseMapInfo(targetLoc_E).getPaint();
        }
        double paintDmgAttackRange_E = 0;
        double myPaintDmg_E = 0;
        int minDistToEnemy_E = 100000;
        
        MapLocation targetLoc_SE = myloc.add(Direction.SOUTHEAST);
        boolean canMove_SE = (rc.canMove(Direction.SOUTHEAST));
        PaintType paint_SE = PaintType.ENEMY_PRIMARY;
        if (rc.canSenseLocation(targetLoc_SE)) {
            paint_SE = rc.senseMapInfo(targetLoc_SE).getPaint();
        }
        double paintDmgAttackRange_SE = 0;
        double myPaintDmg_SE = 0;
        int minDistToEnemy_SE = 100000;
        
        MapLocation targetLoc_S = myloc.add(Direction.SOUTH);
        boolean canMove_S = (rc.canMove(Direction.SOUTH));
        PaintType paint_S = PaintType.ENEMY_PRIMARY;
        if (rc.canSenseLocation(targetLoc_S)) {
            paint_S = rc.senseMapInfo(targetLoc_S).getPaint();
        }
        double paintDmgAttackRange_S = 0;
        double myPaintDmg_S = 0;
        int minDistToEnemy_S = 100000;
        
        MapLocation targetLoc_SW = myloc.add(Direction.SOUTHWEST);
        boolean canMove_SW = (rc.canMove(Direction.SOUTHWEST));
        PaintType paint_SW = PaintType.ENEMY_PRIMARY;
        if (rc.canSenseLocation(targetLoc_SW)) {
            paint_SW = rc.senseMapInfo(targetLoc_SW).getPaint();
        }
        double paintDmgAttackRange_SW = 0;
        double myPaintDmg_SW = 0;
        int minDistToEnemy_SW = 100000;
        
        MapLocation targetLoc_W = myloc.add(Direction.WEST);
        boolean canMove_W = (rc.canMove(Direction.WEST));
        PaintType paint_W = PaintType.ENEMY_PRIMARY;
        if (rc.canSenseLocation(targetLoc_W)) {
            paint_W = rc.senseMapInfo(targetLoc_W).getPaint();
        }
        double paintDmgAttackRange_W = 0;
        double myPaintDmg_W = 0;
        int minDistToEnemy_W = 100000;
        
        MapLocation targetLoc_NW = myloc.add(Direction.NORTHWEST);
        boolean canMove_NW = (rc.canMove(Direction.NORTHWEST));
        PaintType paint_NW = PaintType.ENEMY_PRIMARY;
        if (rc.canSenseLocation(targetLoc_NW)) {
            paint_NW = rc.senseMapInfo(targetLoc_NW).getPaint();
        }
        double paintDmgAttackRange_NW = 0;
        double myPaintDmg_NW = 0;
        int minDistToEnemy_NW = 100000;
        
        MapLocation targetLoc_C = myloc.add(Direction.CENTER);
        boolean canMove_C = (true);
        PaintType paint_C = PaintType.ENEMY_PRIMARY;
        if (rc.canSenseLocation(targetLoc_C)) {
            paint_C = rc.senseMapInfo(targetLoc_C).getPaint();
        }
        double paintDmgAttackRange_C = 0;
        double myPaintDmg_C = 0;
        int minDistToEnemy_C = 100000;
        
        boolean actionReady = rc.isActionReady();
        for (int i = Globals.friends.length; --i >= 0; ) {
            RobotInfo robot = Globals.friends[i];
            addAllyN: {}
            addAllyNE: {}
            addAllyE: {}
            addAllySE: {}
            addAllyS: {}
            addAllySW: {}
            addAllyW: {}
            addAllyNW: {}
            addAllyC: {}
            
        }

        for (int i = Globals.enemies.length; --i >= 0; ) {
            RobotInfo robot = Globals.enemies[i];
            
            addEnemyN: {
                if (!canMove_N) break addEnemyN;
                int d = targetLoc_N.distanceSquaredTo(robot.location);
                switch (robot.type) {
                    case SPLASHER: {
                        if (actionReady && d <= mopperActionRadiusSquared) {
                            myPaintDmg_N = GameConstants.MOPPER_SWING_PAINT_DEPLETION;
                        }
                        if (d < minDistToEnemy_N) minDistToEnemy_N = d;
                        break addEnemyN;
                    }
                    case SOLDIER: {
                        if (actionReady && d <= mopperActionRadiusSquared) {
                            myPaintDmg_N = GameConstants.MOPPER_SWING_PAINT_DEPLETION;
                        }
                        if (d < minDistToEnemy_N) minDistToEnemy_N = d;
                        break addEnemyN;
                    }
                    case MOPPER: {
                        if (actionReady && d <= mopperActionRadiusSquared) {
                            myPaintDmg_N = GameConstants.MOPPER_SWING_PAINT_DEPLETION;
                            paintDmgAttackRange_N = GameConstants.MOPPER_SWING_PAINT_DEPLETION;
                        }
                        if (d < minDistToEnemy_N) minDistToEnemy_N = d;
                        break addEnemyN;
                    }
                    case LEVEL_ONE_DEFENSE_TOWER: {
                        if (d <= UnitType.LEVEL_ONE_DEFENSE_TOWER.actionRadiusSquared) canMove_N = false;
                        break addEnemyN;
                    }
                    case LEVEL_ONE_MONEY_TOWER: {
                        if (d <= UnitType.LEVEL_ONE_MONEY_TOWER.actionRadiusSquared) canMove_N = false;
                        break addEnemyN;
                    }
                    case LEVEL_ONE_PAINT_TOWER: {
                        if (d <= UnitType.LEVEL_ONE_PAINT_TOWER.actionRadiusSquared) canMove_N = false;
                        break addEnemyN;
                    }
                    case LEVEL_THREE_DEFENSE_TOWER: {
                        if (d <= UnitType.LEVEL_THREE_DEFENSE_TOWER.actionRadiusSquared) canMove_N = false;
                        break addEnemyN;
                    }
                    case LEVEL_THREE_MONEY_TOWER: {
                        if (d <= UnitType.LEVEL_THREE_MONEY_TOWER.actionRadiusSquared) canMove_N = false;
                        break addEnemyN;
                    }
                    case LEVEL_THREE_PAINT_TOWER: {
                        if (d <= UnitType.LEVEL_THREE_PAINT_TOWER.actionRadiusSquared) canMove_N = false;
                        break addEnemyN;
                    }
                    case LEVEL_TWO_DEFENSE_TOWER: {
                        if (d <= UnitType.LEVEL_TWO_DEFENSE_TOWER.actionRadiusSquared) canMove_N = false;
                        break addEnemyN;
                    }
                    case LEVEL_TWO_MONEY_TOWER: {
                        if (d <= UnitType.LEVEL_TWO_MONEY_TOWER.actionRadiusSquared) canMove_N = false;
                        break addEnemyN;
                    }
                    case LEVEL_TWO_PAINT_TOWER: {
                        if (d <= UnitType.LEVEL_TWO_PAINT_TOWER.actionRadiusSquared) canMove_N = false;
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
                        if (actionReady && d <= mopperActionRadiusSquared) {
                            myPaintDmg_NE = GameConstants.MOPPER_SWING_PAINT_DEPLETION;
                        }
                        if (d < minDistToEnemy_NE) minDistToEnemy_NE = d;
                        break addEnemyNE;
                    }
                    case SOLDIER: {
                        if (actionReady && d <= mopperActionRadiusSquared) {
                            myPaintDmg_NE = GameConstants.MOPPER_SWING_PAINT_DEPLETION;
                        }
                        if (d < minDistToEnemy_NE) minDistToEnemy_NE = d;
                        break addEnemyNE;
                    }
                    case MOPPER: {
                        if (actionReady && d <= mopperActionRadiusSquared) {
                            myPaintDmg_NE = GameConstants.MOPPER_SWING_PAINT_DEPLETION;
                            paintDmgAttackRange_NE = GameConstants.MOPPER_SWING_PAINT_DEPLETION;
                        }
                        if (d < minDistToEnemy_NE) minDistToEnemy_NE = d;
                        break addEnemyNE;
                    }
                    case LEVEL_ONE_DEFENSE_TOWER: {
                        if (d <= UnitType.LEVEL_ONE_DEFENSE_TOWER.actionRadiusSquared) canMove_NE = false;
                        break addEnemyNE;
                    }
                    case LEVEL_ONE_MONEY_TOWER: {
                        if (d <= UnitType.LEVEL_ONE_MONEY_TOWER.actionRadiusSquared) canMove_NE = false;
                        break addEnemyNE;
                    }
                    case LEVEL_ONE_PAINT_TOWER: {
                        if (d <= UnitType.LEVEL_ONE_PAINT_TOWER.actionRadiusSquared) canMove_NE = false;
                        break addEnemyNE;
                    }
                    case LEVEL_THREE_DEFENSE_TOWER: {
                        if (d <= UnitType.LEVEL_THREE_DEFENSE_TOWER.actionRadiusSquared) canMove_NE = false;
                        break addEnemyNE;
                    }
                    case LEVEL_THREE_MONEY_TOWER: {
                        if (d <= UnitType.LEVEL_THREE_MONEY_TOWER.actionRadiusSquared) canMove_NE = false;
                        break addEnemyNE;
                    }
                    case LEVEL_THREE_PAINT_TOWER: {
                        if (d <= UnitType.LEVEL_THREE_PAINT_TOWER.actionRadiusSquared) canMove_NE = false;
                        break addEnemyNE;
                    }
                    case LEVEL_TWO_DEFENSE_TOWER: {
                        if (d <= UnitType.LEVEL_TWO_DEFENSE_TOWER.actionRadiusSquared) canMove_NE = false;
                        break addEnemyNE;
                    }
                    case LEVEL_TWO_MONEY_TOWER: {
                        if (d <= UnitType.LEVEL_TWO_MONEY_TOWER.actionRadiusSquared) canMove_NE = false;
                        break addEnemyNE;
                    }
                    case LEVEL_TWO_PAINT_TOWER: {
                        if (d <= UnitType.LEVEL_TWO_PAINT_TOWER.actionRadiusSquared) canMove_NE = false;
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
                        if (actionReady && d <= mopperActionRadiusSquared) {
                            myPaintDmg_E = GameConstants.MOPPER_SWING_PAINT_DEPLETION;
                        }
                        if (d < minDistToEnemy_E) minDistToEnemy_E = d;
                        break addEnemyE;
                    }
                    case SOLDIER: {
                        if (actionReady && d <= mopperActionRadiusSquared) {
                            myPaintDmg_E = GameConstants.MOPPER_SWING_PAINT_DEPLETION;
                        }
                        if (d < minDistToEnemy_E) minDistToEnemy_E = d;
                        break addEnemyE;
                    }
                    case MOPPER: {
                        if (actionReady && d <= mopperActionRadiusSquared) {
                            myPaintDmg_E = GameConstants.MOPPER_SWING_PAINT_DEPLETION;
                            paintDmgAttackRange_E = GameConstants.MOPPER_SWING_PAINT_DEPLETION;
                        }
                        if (d < minDistToEnemy_E) minDistToEnemy_E = d;
                        break addEnemyE;
                    }
                    case LEVEL_ONE_DEFENSE_TOWER: {
                        if (d <= UnitType.LEVEL_ONE_DEFENSE_TOWER.actionRadiusSquared) canMove_E = false;
                        break addEnemyE;
                    }
                    case LEVEL_ONE_MONEY_TOWER: {
                        if (d <= UnitType.LEVEL_ONE_MONEY_TOWER.actionRadiusSquared) canMove_E = false;
                        break addEnemyE;
                    }
                    case LEVEL_ONE_PAINT_TOWER: {
                        if (d <= UnitType.LEVEL_ONE_PAINT_TOWER.actionRadiusSquared) canMove_E = false;
                        break addEnemyE;
                    }
                    case LEVEL_THREE_DEFENSE_TOWER: {
                        if (d <= UnitType.LEVEL_THREE_DEFENSE_TOWER.actionRadiusSquared) canMove_E = false;
                        break addEnemyE;
                    }
                    case LEVEL_THREE_MONEY_TOWER: {
                        if (d <= UnitType.LEVEL_THREE_MONEY_TOWER.actionRadiusSquared) canMove_E = false;
                        break addEnemyE;
                    }
                    case LEVEL_THREE_PAINT_TOWER: {
                        if (d <= UnitType.LEVEL_THREE_PAINT_TOWER.actionRadiusSquared) canMove_E = false;
                        break addEnemyE;
                    }
                    case LEVEL_TWO_DEFENSE_TOWER: {
                        if (d <= UnitType.LEVEL_TWO_DEFENSE_TOWER.actionRadiusSquared) canMove_E = false;
                        break addEnemyE;
                    }
                    case LEVEL_TWO_MONEY_TOWER: {
                        if (d <= UnitType.LEVEL_TWO_MONEY_TOWER.actionRadiusSquared) canMove_E = false;
                        break addEnemyE;
                    }
                    case LEVEL_TWO_PAINT_TOWER: {
                        if (d <= UnitType.LEVEL_TWO_PAINT_TOWER.actionRadiusSquared) canMove_E = false;
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
                        if (actionReady && d <= mopperActionRadiusSquared) {
                            myPaintDmg_SE = GameConstants.MOPPER_SWING_PAINT_DEPLETION;
                        }
                        if (d < minDistToEnemy_SE) minDistToEnemy_SE = d;
                        break addEnemySE;
                    }
                    case SOLDIER: {
                        if (actionReady && d <= mopperActionRadiusSquared) {
                            myPaintDmg_SE = GameConstants.MOPPER_SWING_PAINT_DEPLETION;
                        }
                        if (d < minDistToEnemy_SE) minDistToEnemy_SE = d;
                        break addEnemySE;
                    }
                    case MOPPER: {
                        if (actionReady && d <= mopperActionRadiusSquared) {
                            myPaintDmg_SE = GameConstants.MOPPER_SWING_PAINT_DEPLETION;
                            paintDmgAttackRange_SE = GameConstants.MOPPER_SWING_PAINT_DEPLETION;
                        }
                        if (d < minDistToEnemy_SE) minDistToEnemy_SE = d;
                        break addEnemySE;
                    }
                    case LEVEL_ONE_DEFENSE_TOWER: {
                        if (d <= UnitType.LEVEL_ONE_DEFENSE_TOWER.actionRadiusSquared) canMove_SE = false;
                        break addEnemySE;
                    }
                    case LEVEL_ONE_MONEY_TOWER: {
                        if (d <= UnitType.LEVEL_ONE_MONEY_TOWER.actionRadiusSquared) canMove_SE = false;
                        break addEnemySE;
                    }
                    case LEVEL_ONE_PAINT_TOWER: {
                        if (d <= UnitType.LEVEL_ONE_PAINT_TOWER.actionRadiusSquared) canMove_SE = false;
                        break addEnemySE;
                    }
                    case LEVEL_THREE_DEFENSE_TOWER: {
                        if (d <= UnitType.LEVEL_THREE_DEFENSE_TOWER.actionRadiusSquared) canMove_SE = false;
                        break addEnemySE;
                    }
                    case LEVEL_THREE_MONEY_TOWER: {
                        if (d <= UnitType.LEVEL_THREE_MONEY_TOWER.actionRadiusSquared) canMove_SE = false;
                        break addEnemySE;
                    }
                    case LEVEL_THREE_PAINT_TOWER: {
                        if (d <= UnitType.LEVEL_THREE_PAINT_TOWER.actionRadiusSquared) canMove_SE = false;
                        break addEnemySE;
                    }
                    case LEVEL_TWO_DEFENSE_TOWER: {
                        if (d <= UnitType.LEVEL_TWO_DEFENSE_TOWER.actionRadiusSquared) canMove_SE = false;
                        break addEnemySE;
                    }
                    case LEVEL_TWO_MONEY_TOWER: {
                        if (d <= UnitType.LEVEL_TWO_MONEY_TOWER.actionRadiusSquared) canMove_SE = false;
                        break addEnemySE;
                    }
                    case LEVEL_TWO_PAINT_TOWER: {
                        if (d <= UnitType.LEVEL_TWO_PAINT_TOWER.actionRadiusSquared) canMove_SE = false;
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
                        if (actionReady && d <= mopperActionRadiusSquared) {
                            myPaintDmg_S = GameConstants.MOPPER_SWING_PAINT_DEPLETION;
                        }
                        if (d < minDistToEnemy_S) minDistToEnemy_S = d;
                        break addEnemyS;
                    }
                    case SOLDIER: {
                        if (actionReady && d <= mopperActionRadiusSquared) {
                            myPaintDmg_S = GameConstants.MOPPER_SWING_PAINT_DEPLETION;
                        }
                        if (d < minDistToEnemy_S) minDistToEnemy_S = d;
                        break addEnemyS;
                    }
                    case MOPPER: {
                        if (actionReady && d <= mopperActionRadiusSquared) {
                            myPaintDmg_S = GameConstants.MOPPER_SWING_PAINT_DEPLETION;
                            paintDmgAttackRange_S = GameConstants.MOPPER_SWING_PAINT_DEPLETION;
                        }
                        if (d < minDistToEnemy_S) minDistToEnemy_S = d;
                        break addEnemyS;
                    }
                    case LEVEL_ONE_DEFENSE_TOWER: {
                        if (d <= UnitType.LEVEL_ONE_DEFENSE_TOWER.actionRadiusSquared) canMove_S = false;
                        break addEnemyS;
                    }
                    case LEVEL_ONE_MONEY_TOWER: {
                        if (d <= UnitType.LEVEL_ONE_MONEY_TOWER.actionRadiusSquared) canMove_S = false;
                        break addEnemyS;
                    }
                    case LEVEL_ONE_PAINT_TOWER: {
                        if (d <= UnitType.LEVEL_ONE_PAINT_TOWER.actionRadiusSquared) canMove_S = false;
                        break addEnemyS;
                    }
                    case LEVEL_THREE_DEFENSE_TOWER: {
                        if (d <= UnitType.LEVEL_THREE_DEFENSE_TOWER.actionRadiusSquared) canMove_S = false;
                        break addEnemyS;
                    }
                    case LEVEL_THREE_MONEY_TOWER: {
                        if (d <= UnitType.LEVEL_THREE_MONEY_TOWER.actionRadiusSquared) canMove_S = false;
                        break addEnemyS;
                    }
                    case LEVEL_THREE_PAINT_TOWER: {
                        if (d <= UnitType.LEVEL_THREE_PAINT_TOWER.actionRadiusSquared) canMove_S = false;
                        break addEnemyS;
                    }
                    case LEVEL_TWO_DEFENSE_TOWER: {
                        if (d <= UnitType.LEVEL_TWO_DEFENSE_TOWER.actionRadiusSquared) canMove_S = false;
                        break addEnemyS;
                    }
                    case LEVEL_TWO_MONEY_TOWER: {
                        if (d <= UnitType.LEVEL_TWO_MONEY_TOWER.actionRadiusSquared) canMove_S = false;
                        break addEnemyS;
                    }
                    case LEVEL_TWO_PAINT_TOWER: {
                        if (d <= UnitType.LEVEL_TWO_PAINT_TOWER.actionRadiusSquared) canMove_S = false;
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
                        if (actionReady && d <= mopperActionRadiusSquared) {
                            myPaintDmg_SW = GameConstants.MOPPER_SWING_PAINT_DEPLETION;
                        }
                        if (d < minDistToEnemy_SW) minDistToEnemy_SW = d;
                        break addEnemySW;
                    }
                    case SOLDIER: {
                        if (actionReady && d <= mopperActionRadiusSquared) {
                            myPaintDmg_SW = GameConstants.MOPPER_SWING_PAINT_DEPLETION;
                        }
                        if (d < minDistToEnemy_SW) minDistToEnemy_SW = d;
                        break addEnemySW;
                    }
                    case MOPPER: {
                        if (actionReady && d <= mopperActionRadiusSquared) {
                            myPaintDmg_SW = GameConstants.MOPPER_SWING_PAINT_DEPLETION;
                            paintDmgAttackRange_SW = GameConstants.MOPPER_SWING_PAINT_DEPLETION;
                        }
                        if (d < minDistToEnemy_SW) minDistToEnemy_SW = d;
                        break addEnemySW;
                    }
                    case LEVEL_ONE_DEFENSE_TOWER: {
                        if (d <= UnitType.LEVEL_ONE_DEFENSE_TOWER.actionRadiusSquared) canMove_SW = false;
                        break addEnemySW;
                    }
                    case LEVEL_ONE_MONEY_TOWER: {
                        if (d <= UnitType.LEVEL_ONE_MONEY_TOWER.actionRadiusSquared) canMove_SW = false;
                        break addEnemySW;
                    }
                    case LEVEL_ONE_PAINT_TOWER: {
                        if (d <= UnitType.LEVEL_ONE_PAINT_TOWER.actionRadiusSquared) canMove_SW = false;
                        break addEnemySW;
                    }
                    case LEVEL_THREE_DEFENSE_TOWER: {
                        if (d <= UnitType.LEVEL_THREE_DEFENSE_TOWER.actionRadiusSquared) canMove_SW = false;
                        break addEnemySW;
                    }
                    case LEVEL_THREE_MONEY_TOWER: {
                        if (d <= UnitType.LEVEL_THREE_MONEY_TOWER.actionRadiusSquared) canMove_SW = false;
                        break addEnemySW;
                    }
                    case LEVEL_THREE_PAINT_TOWER: {
                        if (d <= UnitType.LEVEL_THREE_PAINT_TOWER.actionRadiusSquared) canMove_SW = false;
                        break addEnemySW;
                    }
                    case LEVEL_TWO_DEFENSE_TOWER: {
                        if (d <= UnitType.LEVEL_TWO_DEFENSE_TOWER.actionRadiusSquared) canMove_SW = false;
                        break addEnemySW;
                    }
                    case LEVEL_TWO_MONEY_TOWER: {
                        if (d <= UnitType.LEVEL_TWO_MONEY_TOWER.actionRadiusSquared) canMove_SW = false;
                        break addEnemySW;
                    }
                    case LEVEL_TWO_PAINT_TOWER: {
                        if (d <= UnitType.LEVEL_TWO_PAINT_TOWER.actionRadiusSquared) canMove_SW = false;
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
                        if (actionReady && d <= mopperActionRadiusSquared) {
                            myPaintDmg_W = GameConstants.MOPPER_SWING_PAINT_DEPLETION;
                        }
                        if (d < minDistToEnemy_W) minDistToEnemy_W = d;
                        break addEnemyW;
                    }
                    case SOLDIER: {
                        if (actionReady && d <= mopperActionRadiusSquared) {
                            myPaintDmg_W = GameConstants.MOPPER_SWING_PAINT_DEPLETION;
                        }
                        if (d < minDistToEnemy_W) minDistToEnemy_W = d;
                        break addEnemyW;
                    }
                    case MOPPER: {
                        if (actionReady && d <= mopperActionRadiusSquared) {
                            myPaintDmg_W = GameConstants.MOPPER_SWING_PAINT_DEPLETION;
                            paintDmgAttackRange_W = GameConstants.MOPPER_SWING_PAINT_DEPLETION;
                        }
                        if (d < minDistToEnemy_W) minDistToEnemy_W = d;
                        break addEnemyW;
                    }
                    case LEVEL_ONE_DEFENSE_TOWER: {
                        if (d <= UnitType.LEVEL_ONE_DEFENSE_TOWER.actionRadiusSquared) canMove_W = false;
                        break addEnemyW;
                    }
                    case LEVEL_ONE_MONEY_TOWER: {
                        if (d <= UnitType.LEVEL_ONE_MONEY_TOWER.actionRadiusSquared) canMove_W = false;
                        break addEnemyW;
                    }
                    case LEVEL_ONE_PAINT_TOWER: {
                        if (d <= UnitType.LEVEL_ONE_PAINT_TOWER.actionRadiusSquared) canMove_W = false;
                        break addEnemyW;
                    }
                    case LEVEL_THREE_DEFENSE_TOWER: {
                        if (d <= UnitType.LEVEL_THREE_DEFENSE_TOWER.actionRadiusSquared) canMove_W = false;
                        break addEnemyW;
                    }
                    case LEVEL_THREE_MONEY_TOWER: {
                        if (d <= UnitType.LEVEL_THREE_MONEY_TOWER.actionRadiusSquared) canMove_W = false;
                        break addEnemyW;
                    }
                    case LEVEL_THREE_PAINT_TOWER: {
                        if (d <= UnitType.LEVEL_THREE_PAINT_TOWER.actionRadiusSquared) canMove_W = false;
                        break addEnemyW;
                    }
                    case LEVEL_TWO_DEFENSE_TOWER: {
                        if (d <= UnitType.LEVEL_TWO_DEFENSE_TOWER.actionRadiusSquared) canMove_W = false;
                        break addEnemyW;
                    }
                    case LEVEL_TWO_MONEY_TOWER: {
                        if (d <= UnitType.LEVEL_TWO_MONEY_TOWER.actionRadiusSquared) canMove_W = false;
                        break addEnemyW;
                    }
                    case LEVEL_TWO_PAINT_TOWER: {
                        if (d <= UnitType.LEVEL_TWO_PAINT_TOWER.actionRadiusSquared) canMove_W = false;
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
                        if (actionReady && d <= mopperActionRadiusSquared) {
                            myPaintDmg_NW = GameConstants.MOPPER_SWING_PAINT_DEPLETION;
                        }
                        if (d < minDistToEnemy_NW) minDistToEnemy_NW = d;
                        break addEnemyNW;
                    }
                    case SOLDIER: {
                        if (actionReady && d <= mopperActionRadiusSquared) {
                            myPaintDmg_NW = GameConstants.MOPPER_SWING_PAINT_DEPLETION;
                        }
                        if (d < minDistToEnemy_NW) minDistToEnemy_NW = d;
                        break addEnemyNW;
                    }
                    case MOPPER: {
                        if (actionReady && d <= mopperActionRadiusSquared) {
                            myPaintDmg_NW = GameConstants.MOPPER_SWING_PAINT_DEPLETION;
                            paintDmgAttackRange_NW = GameConstants.MOPPER_SWING_PAINT_DEPLETION;
                        }
                        if (d < minDistToEnemy_NW) minDistToEnemy_NW = d;
                        break addEnemyNW;
                    }
                    case LEVEL_ONE_DEFENSE_TOWER: {
                        if (d <= UnitType.LEVEL_ONE_DEFENSE_TOWER.actionRadiusSquared) canMove_NW = false;
                        break addEnemyNW;
                    }
                    case LEVEL_ONE_MONEY_TOWER: {
                        if (d <= UnitType.LEVEL_ONE_MONEY_TOWER.actionRadiusSquared) canMove_NW = false;
                        break addEnemyNW;
                    }
                    case LEVEL_ONE_PAINT_TOWER: {
                        if (d <= UnitType.LEVEL_ONE_PAINT_TOWER.actionRadiusSquared) canMove_NW = false;
                        break addEnemyNW;
                    }
                    case LEVEL_THREE_DEFENSE_TOWER: {
                        if (d <= UnitType.LEVEL_THREE_DEFENSE_TOWER.actionRadiusSquared) canMove_NW = false;
                        break addEnemyNW;
                    }
                    case LEVEL_THREE_MONEY_TOWER: {
                        if (d <= UnitType.LEVEL_THREE_MONEY_TOWER.actionRadiusSquared) canMove_NW = false;
                        break addEnemyNW;
                    }
                    case LEVEL_THREE_PAINT_TOWER: {
                        if (d <= UnitType.LEVEL_THREE_PAINT_TOWER.actionRadiusSquared) canMove_NW = false;
                        break addEnemyNW;
                    }
                    case LEVEL_TWO_DEFENSE_TOWER: {
                        if (d <= UnitType.LEVEL_TWO_DEFENSE_TOWER.actionRadiusSquared) canMove_NW = false;
                        break addEnemyNW;
                    }
                    case LEVEL_TWO_MONEY_TOWER: {
                        if (d <= UnitType.LEVEL_TWO_MONEY_TOWER.actionRadiusSquared) canMove_NW = false;
                        break addEnemyNW;
                    }
                    case LEVEL_TWO_PAINT_TOWER: {
                        if (d <= UnitType.LEVEL_TWO_PAINT_TOWER.actionRadiusSquared) canMove_NW = false;
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
                        if (actionReady && d <= mopperActionRadiusSquared) {
                            myPaintDmg_C = GameConstants.MOPPER_SWING_PAINT_DEPLETION;
                        }
                        if (d < minDistToEnemy_C) minDistToEnemy_C = d;
                        break addEnemyC;
                    }
                    case SOLDIER: {
                        if (actionReady && d <= mopperActionRadiusSquared) {
                            myPaintDmg_C = GameConstants.MOPPER_SWING_PAINT_DEPLETION;
                        }
                        if (d < minDistToEnemy_C) minDistToEnemy_C = d;
                        break addEnemyC;
                    }
                    case MOPPER: {
                        if (actionReady && d <= mopperActionRadiusSquared) {
                            myPaintDmg_C = GameConstants.MOPPER_SWING_PAINT_DEPLETION;
                            paintDmgAttackRange_C = GameConstants.MOPPER_SWING_PAINT_DEPLETION;
                        }
                        if (d < minDistToEnemy_C) minDistToEnemy_C = d;
                        break addEnemyC;
                    }
                    case LEVEL_ONE_DEFENSE_TOWER: {
                        if (d <= UnitType.LEVEL_ONE_DEFENSE_TOWER.actionRadiusSquared) canMove_C = false;
                        break addEnemyC;
                    }
                    case LEVEL_ONE_MONEY_TOWER: {
                        if (d <= UnitType.LEVEL_ONE_MONEY_TOWER.actionRadiusSquared) canMove_C = false;
                        break addEnemyC;
                    }
                    case LEVEL_ONE_PAINT_TOWER: {
                        if (d <= UnitType.LEVEL_ONE_PAINT_TOWER.actionRadiusSquared) canMove_C = false;
                        break addEnemyC;
                    }
                    case LEVEL_THREE_DEFENSE_TOWER: {
                        if (d <= UnitType.LEVEL_THREE_DEFENSE_TOWER.actionRadiusSquared) canMove_C = false;
                        break addEnemyC;
                    }
                    case LEVEL_THREE_MONEY_TOWER: {
                        if (d <= UnitType.LEVEL_THREE_MONEY_TOWER.actionRadiusSquared) canMove_C = false;
                        break addEnemyC;
                    }
                    case LEVEL_THREE_PAINT_TOWER: {
                        if (d <= UnitType.LEVEL_THREE_PAINT_TOWER.actionRadiusSquared) canMove_C = false;
                        break addEnemyC;
                    }
                    case LEVEL_TWO_DEFENSE_TOWER: {
                        if (d <= UnitType.LEVEL_TWO_DEFENSE_TOWER.actionRadiusSquared) canMove_C = false;
                        break addEnemyC;
                    }
                    case LEVEL_TWO_MONEY_TOWER: {
                        if (d <= UnitType.LEVEL_TWO_MONEY_TOWER.actionRadiusSquared) canMove_C = false;
                        break addEnemyC;
                    }
                    case LEVEL_TWO_PAINT_TOWER: {
                        if (d <= UnitType.LEVEL_TWO_PAINT_TOWER.actionRadiusSquared) canMove_C = false;
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
        }
        double paintDmgAttackRange_best = 0;
        double myPaintDmg_best = 0;
        int minDistToEnemy_best = 100000;
        
        targetLoc_best = targetLoc_N;
    canMove_best = canMove_N;
    paintDmgAttackRange_best = paintDmgAttackRange_N;
    myPaintDmg_best = myPaintDmg_N;
    minDistToEnemy_best = minDistToEnemy_N;
    paint_best = paint_N;
    
        
        bestWins = canMove_best;
        chooseBestNE: {
            if (!canMove_NE || !canMove_best) break chooseBestNE;
            double bestPaintDmgDiff = paintDmgAttackRange_best - myPaintDmg_best;
            double otherPaintDmgDiff = paintDmgAttackRange_NE - myPaintDmg_NE;
            if (bestPaintDmgDiff != otherPaintDmgDiff) {
                bestWins = (bestPaintDmgDiff < otherPaintDmgDiff);
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
            paintDmgAttackRange_best = paintDmgAttackRange_NE;
            myPaintDmg_best = myPaintDmg_NE;
            minDistToEnemy_best = minDistToEnemy_NE;
            paint_best = paint_NE;
            bestDir = Direction.NORTHEAST;
        }
        
        
        bestWins = canMove_best;
        chooseBestE: {
            if (!canMove_E || !canMove_best) break chooseBestE;
            double bestPaintDmgDiff = paintDmgAttackRange_best - myPaintDmg_best;
            double otherPaintDmgDiff = paintDmgAttackRange_E - myPaintDmg_E;
            if (bestPaintDmgDiff != otherPaintDmgDiff) {
                bestWins = (bestPaintDmgDiff < otherPaintDmgDiff);
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
            paintDmgAttackRange_best = paintDmgAttackRange_E;
            myPaintDmg_best = myPaintDmg_E;
            minDistToEnemy_best = minDistToEnemy_E;
            paint_best = paint_E;
            bestDir = Direction.EAST;
        }
        
        
        bestWins = canMove_best;
        chooseBestSE: {
            if (!canMove_SE || !canMove_best) break chooseBestSE;
            double bestPaintDmgDiff = paintDmgAttackRange_best - myPaintDmg_best;
            double otherPaintDmgDiff = paintDmgAttackRange_SE - myPaintDmg_SE;
            if (bestPaintDmgDiff != otherPaintDmgDiff) {
                bestWins = (bestPaintDmgDiff < otherPaintDmgDiff);
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
            paintDmgAttackRange_best = paintDmgAttackRange_SE;
            myPaintDmg_best = myPaintDmg_SE;
            minDistToEnemy_best = minDistToEnemy_SE;
            paint_best = paint_SE;
            bestDir = Direction.SOUTHEAST;
        }
        
        
        bestWins = canMove_best;
        chooseBestS: {
            if (!canMove_S || !canMove_best) break chooseBestS;
            double bestPaintDmgDiff = paintDmgAttackRange_best - myPaintDmg_best;
            double otherPaintDmgDiff = paintDmgAttackRange_S - myPaintDmg_S;
            if (bestPaintDmgDiff != otherPaintDmgDiff) {
                bestWins = (bestPaintDmgDiff < otherPaintDmgDiff);
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
            paintDmgAttackRange_best = paintDmgAttackRange_S;
            myPaintDmg_best = myPaintDmg_S;
            minDistToEnemy_best = minDistToEnemy_S;
            paint_best = paint_S;
            bestDir = Direction.SOUTH;
        }
        
        
        bestWins = canMove_best;
        chooseBestSW: {
            if (!canMove_SW || !canMove_best) break chooseBestSW;
            double bestPaintDmgDiff = paintDmgAttackRange_best - myPaintDmg_best;
            double otherPaintDmgDiff = paintDmgAttackRange_SW - myPaintDmg_SW;
            if (bestPaintDmgDiff != otherPaintDmgDiff) {
                bestWins = (bestPaintDmgDiff < otherPaintDmgDiff);
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
            paintDmgAttackRange_best = paintDmgAttackRange_SW;
            myPaintDmg_best = myPaintDmg_SW;
            minDistToEnemy_best = minDistToEnemy_SW;
            paint_best = paint_SW;
            bestDir = Direction.SOUTHWEST;
        }
        
        
        bestWins = canMove_best;
        chooseBestW: {
            if (!canMove_W || !canMove_best) break chooseBestW;
            double bestPaintDmgDiff = paintDmgAttackRange_best - myPaintDmg_best;
            double otherPaintDmgDiff = paintDmgAttackRange_W - myPaintDmg_W;
            if (bestPaintDmgDiff != otherPaintDmgDiff) {
                bestWins = (bestPaintDmgDiff < otherPaintDmgDiff);
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
            paintDmgAttackRange_best = paintDmgAttackRange_W;
            myPaintDmg_best = myPaintDmg_W;
            minDistToEnemy_best = minDistToEnemy_W;
            paint_best = paint_W;
            bestDir = Direction.WEST;
        }
        
        
        bestWins = canMove_best;
        chooseBestNW: {
            if (!canMove_NW || !canMove_best) break chooseBestNW;
            double bestPaintDmgDiff = paintDmgAttackRange_best - myPaintDmg_best;
            double otherPaintDmgDiff = paintDmgAttackRange_NW - myPaintDmg_NW;
            if (bestPaintDmgDiff != otherPaintDmgDiff) {
                bestWins = (bestPaintDmgDiff < otherPaintDmgDiff);
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
            paintDmgAttackRange_best = paintDmgAttackRange_NW;
            myPaintDmg_best = myPaintDmg_NW;
            minDistToEnemy_best = minDistToEnemy_NW;
            paint_best = paint_NW;
            bestDir = Direction.NORTHWEST;
        }
        
        
        bestWins = canMove_best;
        chooseBestC: {
            if (!canMove_C || !canMove_best) break chooseBestC;
            double bestPaintDmgDiff = paintDmgAttackRange_best - myPaintDmg_best;
            double otherPaintDmgDiff = paintDmgAttackRange_C - myPaintDmg_C;
            if (bestPaintDmgDiff != otherPaintDmgDiff) {
                bestWins = (bestPaintDmgDiff < otherPaintDmgDiff);
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
            paintDmgAttackRange_best = paintDmgAttackRange_C;
            myPaintDmg_best = myPaintDmg_C;
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