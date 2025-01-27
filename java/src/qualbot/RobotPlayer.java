package qualbot;
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
        MopperAttack.init(rc);
        Explore.init(rc);
        RefuelManager.init(rc);
        TowerBuild.init(rc);
        SquareManager.init(rc);
        Comms.init(rc);
        switch (rc.getType()) {
            case SOLDIER: {
                while (true) {
                    try {
                        TileLoader.load();
                        Globals.run();
                        SquareManager.run();
                        Soldier.run();
                        SymmetryChecker.run();
                        Comms.run();
                        rc.setIndicatorString(
                            "Globals.numSrps := " + Globals.numSrps + ", " +
                            "Globals.numMoneyTowers := " + Globals.numMoneyTowers + ", " +
                            "Globals.numPaintTowers := " + Globals.numPaintTowers
                        );
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
                        SquareManager.run();
                        Mopper.run();
                        SymmetryChecker.run();
                        Comms.run();
                        rc.setIndicatorString(
                            "Globals.numSrps := " + Globals.numSrps + ", " +
                            "Globals.numMoneyTowers := " + Globals.numMoneyTowers + ", " +
                            "Globals.numPaintTowers := " + Globals.numPaintTowers
                        );
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
                        SquareManager.run();
                        Splasher.run();
                        SymmetryChecker.run();
                        Comms.run();
                        rc.setIndicatorString(
                            "Globals.numSrps := " + Globals.numSrps + ", " +
                            "Globals.numMoneyTowers := " + Globals.numMoneyTowers + ", " +
                            "Globals.numPaintTowers := " + Globals.numPaintTowers
                        );
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
                        SquareManager.run();
                        Tower.run();
                        SymmetryChecker.run();
                        Comms.run();
                        rc.setIndicatorString(
                            "Globals.numSrps := " + Globals.numSrps + ", " +
                            "Globals.numMoneyTowers := " + Globals.numMoneyTowers + ", " +
                            "Globals.numPaintTowers := " + Globals.numPaintTowers
                        );
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