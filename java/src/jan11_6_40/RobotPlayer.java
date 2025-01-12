package jan11_6_40;
import battlecode.common.*;
public class RobotPlayer {
    @SuppressWarnings("unused")
    public static void run(RobotController rc) throws GameActionException {
        
        Globals.init(rc);
        Mopper.init(rc);
        Pathing.init(rc);
        Soldier.init(rc);
        Splasher.init(rc);
        Tower.init(rc);
        TileLoader.init(rc);
        SymmetryChecker.init(rc);
        Attack.init(rc);
        Explore.init(rc);
        switch (rc.getType()) {
            case SOLDIER: {
                while (true) {
                    try {
                        TileLoader.load();
                        Globals.run();
                        Soldier.run();
                        SymmetryChecker.run();
                        // rc.setIndicatorString("Symmetry: " + SymmetryChecker.getSymmetry());
                        // rc.setIndicatorString("Symmetry: R = " + SymmetryChecker.RSYM + " V = " + SymmetryChecker.VSYM + " H = " + SymmetryChecker.HSYM);
                        
                        // TileLoader.display();
                        
                    } catch (GameActionException e) {
                        System.out.println("Exception = ");
                        e.printStackTrace();
                    } finally {
                        Clock.yield();
                    }
                }
            }
            case MOPPER: {
                while (true) {
                    try {
                        TileLoader.load();
                        Globals.run();
                        Mopper.run();
                        SymmetryChecker.run();
                        // rc.setIndicatorString("Symmetry: " + SymmetryChecker.getSymmetry());
                        // rc.setIndicatorString("Symmetry: R = " + SymmetryChecker.RSYM + " V = " + SymmetryChecker.VSYM + " H = " + SymmetryChecker.HSYM);
                        
                        // TileLoader.display();
                        
                    } catch (GameActionException e) {
                        System.out.println("Exception = ");
                        e.printStackTrace();
                    } finally {
                        Clock.yield();
                    }
                }
            }
            case SPLASHER: {
                while (true) {
                    try {
                        TileLoader.load();
                        Globals.run();
                        Splasher.run();
                        SymmetryChecker.run();
                        // rc.setIndicatorString("Symmetry: " + SymmetryChecker.getSymmetry());
                        // rc.setIndicatorString("Symmetry: R = " + SymmetryChecker.RSYM + " V = " + SymmetryChecker.VSYM + " H = " + SymmetryChecker.HSYM);
                        
                        // TileLoader.display();
                        
                    } catch (GameActionException e) {
                        System.out.println("Exception = ");
                        e.printStackTrace();
                    } finally {
                        Clock.yield();
                    }
                }
            }
            
            default: {
                while (true) {
                    try {
                        TileLoader.load();
                        Globals.run();
                        Tower.run();
                        SymmetryChecker.run();
                        // rc.setIndicatorString("Symmetry: " + SymmetryChecker.getSymmetry());
                        // rc.setIndicatorString("Symmetry: R = " + SymmetryChecker.RSYM + " V = " + SymmetryChecker.VSYM + " H = " + SymmetryChecker.HSYM);
                        
                        // TileLoader.display();
                        
                    } catch (GameActionException e) {
                        System.out.println("Exception = ");
                        e.printStackTrace();
                    } finally {
                        Clock.yield();
                    }
                }
            }
        }
    }
}