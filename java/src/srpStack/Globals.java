package srpStack;
import java.util.Random;
import battlecode.common.*;

public class Globals {
    public static int born;
    public static int roundNum;
    public static RobotController rc;
    public static final Random rng = new Random();
    public static boolean[][] moneyTower;
    public static boolean[][] paintTower;
    public static void init(RobotController rc) throws GameActionException {
        rng.setSeed((long) rc.getID());
        Globals.rc = rc;
        moneyTower = rc.getTowerPattern(UnitType.LEVEL_ONE_MONEY_TOWER);
        paintTower = rc.getTowerPattern(UnitType.LEVEL_ONE_PAINT_TOWER);
        born = rc.getRoundNum();
    }

    public static RobotInfo[] friends;
    public static RobotInfo[] enemies;
    public static void run() throws GameActionException {
        friends = rc.senseNearbyRobots(-1, rc.getTeam());
        enemies = rc.senseNearbyRobots(-1, rc.getTeam().opponent());
        roundNum = rc.getRoundNum();
        updateTowerTracker();
    }

    public static boolean onMap(MapLocation loc) throws GameActionException {
        return (loc.x >= 0 && loc.y >= 0 && loc.x < rc.getMapWidth() && loc.y < rc.getMapHeight());
    }

    public static UnitType getTowerToBuild(MapLocation loc) throws GameActionException {
        MapLocation tmp;
        MapInfo s;
        
        tmp = loc.add(TowerBuild.corners[0]);
        if (rc.canSenseLocation(tmp)) {
            s = rc.senseMapInfo(tmp);
            if (s.getMark() != PaintType.EMPTY) {
                return UnitType.LEVEL_ONE_MONEY_TOWER;
            }
        }
        
        tmp = loc.add(TowerBuild.corners[1]);
        if (rc.canSenseLocation(tmp)) {
            s = rc.senseMapInfo(tmp);
            if (s.getMark() != PaintType.EMPTY) {
                return UnitType.LEVEL_ONE_MONEY_TOWER;
            }
        }
        
        tmp = loc.add(TowerBuild.corners[2]);
        if (rc.canSenseLocation(tmp)) {
            s = rc.senseMapInfo(tmp);
            if (s.getMark() != PaintType.EMPTY) {
                return UnitType.LEVEL_ONE_MONEY_TOWER;
            }
        }
        
        tmp = loc.add(TowerBuild.corners[3]);
        if (rc.canSenseLocation(tmp)) {
            s = rc.senseMapInfo(tmp);
            if (s.getMark() != PaintType.EMPTY) {
                return UnitType.LEVEL_ONE_MONEY_TOWER;
            }
        }
        
        MapLocation paintMark = loc.add(Direction.WEST);
        MapLocation moneyMark = loc.add(Direction.SOUTH);
        if (rc.canSenseLocation(paintMark)){
            s = rc.senseMapInfo(paintMark);
            if (s.getMark() == PaintType.ALLY_SECONDARY) return UnitType.LEVEL_ONE_PAINT_TOWER;
        }
        if( rc.canSenseLocation(moneyMark)) {
            s = rc.senseMapInfo(moneyMark);
            if (s.getMark() == PaintType.ALLY_SECONDARY) return UnitType.LEVEL_ONE_MONEY_TOWER;
        }
        if (numPaintTowers == 0) return UnitType.LEVEL_ONE_PAINT_TOWER;
        else if (rc.getMoney() < 2000) return UnitType.LEVEL_ONE_MONEY_TOWER;
        return UnitType.LEVEL_ONE_PAINT_TOWER;
    }

    public static boolean isTower(UnitType u) {
        return switch (u) {
            case SOLDIER -> false;
            case SPLASHER -> false;
            case MOPPER -> false;
            default -> true;
        };
    }

    public static int numSrps = 0;
    public static int numMoneyTowers = 1;
    public static int numPaintTowers = 1;
    
    
    public static int income0 = 0;
    public static int numTowers0 = 0;
    
    public static int income1 = 0;
    public static int numTowers1 = 0;
    
    public static int income2 = 0;
    public static int numTowers2 = 0;
    
    public static int income3 = 0;
    public static int numTowers3 = 0;
    
    public static int income4 = 0;
    public static int numTowers4 = 0;
    
    public static int income5 = 0;
    public static int numTowers5 = 0;
    
    public static int income6 = 0;
    public static int numTowers6 = 0;
    
    public static int income7 = 0;
    public static int numTowers7 = 0;
    
    public static int income8 = 0;
    public static int numTowers8 = 0;
    
    public static int income9 = 0;
    public static int numTowers9 = 0;
    
    public static int lastMoney = GameConstants.INITIAL_TEAM_MONEY;
    public static void updateTowerTracker() throws GameActionException {
        int currentMoney = rc.getMoney();
        int currentIncome = (currentMoney - lastMoney);
        switch (roundNum % 10) {
            
            case 0 -> {
                income0 = currentIncome;
                numTowers0 = rc.getNumberTowers();
            }
            
            case 1 -> {
                income1 = currentIncome;
                numTowers1 = rc.getNumberTowers();
            }
            
            case 2 -> {
                income2 = currentIncome;
                numTowers2 = rc.getNumberTowers();
            }
            
            case 3 -> {
                income3 = currentIncome;
                numTowers3 = rc.getNumberTowers();
            }
            
            case 4 -> {
                income4 = currentIncome;
                numTowers4 = rc.getNumberTowers();
            }
            
            case 5 -> {
                income5 = currentIncome;
                numTowers5 = rc.getNumberTowers();
            }
            
            case 6 -> {
                income6 = currentIncome;
                numTowers6 = rc.getNumberTowers();
            }
            
            case 7 -> {
                income7 = currentIncome;
                numTowers7 = rc.getNumberTowers();
            }
            
            case 8 -> {
                income8 = currentIncome;
                numTowers8 = rc.getNumberTowers();
            }
            
            case 9 -> {
                income9 = currentIncome;
                numTowers9 = rc.getNumberTowers();
            }
            
            default -> {}
        }
        lastMoney = currentMoney;
        
        int numTowers = 0;
        int highestIncome = -1000000;
        
        if (income0 > highestIncome) {
            highestIncome = income0;
            numTowers = numTowers0;
        }
        
        if (income1 > highestIncome) {
            highestIncome = income1;
            numTowers = numTowers1;
        }
        
        if (income2 > highestIncome) {
            highestIncome = income2;
            numTowers = numTowers2;
        }
        
        if (income3 > highestIncome) {
            highestIncome = income3;
            numTowers = numTowers3;
        }
        
        if (income4 > highestIncome) {
            highestIncome = income4;
            numTowers = numTowers4;
        }
        
        if (income5 > highestIncome) {
            highestIncome = income5;
            numTowers = numTowers5;
        }
        
        if (income6 > highestIncome) {
            highestIncome = income6;
            numTowers = numTowers6;
        }
        
        if (income7 > highestIncome) {
            highestIncome = income7;
            numTowers = numTowers7;
        }
        
        if (income8 > highestIncome) {
            highestIncome = income8;
            numTowers = numTowers8;
        }
        
        if (income9 > highestIncome) {
            highestIncome = income9;
            numTowers = numTowers9;
        }
        
        if (highestIncome < 0) return;

        switchLabel: switch (highestIncome) {
            
            case 0 -> {
                
                if (0 <= numTowers) {
                    numSrps = 0;
                    numMoneyTowers = 0;
                    break switchLabel;
                }
                
                if (0 <= numTowers) {
                    numSrps = 1;
                    numMoneyTowers = 0;
                    break switchLabel;
                }
                
                if (0 <= numTowers) {
                    numSrps = 2;
                    numMoneyTowers = 0;
                    break switchLabel;
                }
                
                if (0 <= numTowers) {
                    numSrps = 3;
                    numMoneyTowers = 0;
                    break switchLabel;
                }
                
                if (0 <= numTowers) {
                    numSrps = 4;
                    numMoneyTowers = 0;
                    break switchLabel;
                }
                
                if (0 <= numTowers) {
                    numSrps = 5;
                    numMoneyTowers = 0;
                    break switchLabel;
                }
                
                if (0 <= numTowers) {
                    numSrps = 6;
                    numMoneyTowers = 0;
                    break switchLabel;
                }
                
                if (0 <= numTowers) {
                    numSrps = 7;
                    numMoneyTowers = 0;
                    break switchLabel;
                }
                
                if (0 <= numTowers) {
                    numSrps = 8;
                    numMoneyTowers = 0;
                    break switchLabel;
                }
                
                if (0 <= numTowers) {
                    numSrps = 9;
                    numMoneyTowers = 0;
                    break switchLabel;
                }
                
                if (0 <= numTowers) {
                    numSrps = 10;
                    numMoneyTowers = 0;
                    break switchLabel;
                }
                
                if (0 <= numTowers) {
                    numSrps = 11;
                    numMoneyTowers = 0;
                    break switchLabel;
                }
                
                if (0 <= numTowers) {
                    numSrps = 12;
                    numMoneyTowers = 0;
                    break switchLabel;
                }
                
                if (0 <= numTowers) {
                    numSrps = 13;
                    numMoneyTowers = 0;
                    break switchLabel;
                }
                
                if (0 <= numTowers) {
                    numSrps = 14;
                    numMoneyTowers = 0;
                    break switchLabel;
                }
                
                if (0 <= numTowers) {
                    numSrps = 15;
                    numMoneyTowers = 0;
                    break switchLabel;
                }
                
                if (0 <= numTowers) {
                    numSrps = 16;
                    numMoneyTowers = 0;
                    break switchLabel;
                }
                
                if (0 <= numTowers) {
                    numSrps = 17;
                    numMoneyTowers = 0;
                    break switchLabel;
                }
                
                if (0 <= numTowers) {
                    numSrps = 18;
                    numMoneyTowers = 0;
                    break switchLabel;
                }
                
                if (0 <= numTowers) {
                    numSrps = 19;
                    numMoneyTowers = 0;
                    break switchLabel;
                }
                
                if (0 <= numTowers) {
                    numSrps = 20;
                    numMoneyTowers = 0;
                    break switchLabel;
                }
                
                if (0 <= numTowers) {
                    numSrps = 21;
                    numMoneyTowers = 0;
                    break switchLabel;
                }
                
                if (0 <= numTowers) {
                    numSrps = 22;
                    numMoneyTowers = 0;
                    break switchLabel;
                }
                
                if (0 <= numTowers) {
                    numSrps = 23;
                    numMoneyTowers = 0;
                    break switchLabel;
                }
                
                if (0 <= numTowers) {
                    numSrps = 24;
                    numMoneyTowers = 0;
                    break switchLabel;
                }
                
            }
            
            case 20 -> {
                
                if (1 <= numTowers) {
                    numSrps = 0;
                    numMoneyTowers = 1;
                    break switchLabel;
                }
                
            }
            
            case 30 -> {
                
                if (1 <= numTowers) {
                    numSrps = 0;
                    numMoneyTowers = 1;
                    break switchLabel;
                }
                
            }
            
            case 40 -> {
                
                if (2 <= numTowers) {
                    numSrps = 0;
                    numMoneyTowers = 2;
                    break switchLabel;
                }
                
            }
            
            case 50 -> {
                
                if (2 <= numTowers) {
                    numSrps = 0;
                    numMoneyTowers = 2;
                    break switchLabel;
                }
                
                if (1 <= numTowers) {
                    numSrps = 10;
                    numMoneyTowers = 1;
                    break switchLabel;
                }
                
            }
            
            case 60 -> {
                
                if (3 <= numTowers) {
                    numSrps = 0;
                    numMoneyTowers = 3;
                    break switchLabel;
                }
                
                if (1 <= numTowers) {
                    numSrps = 10;
                    numMoneyTowers = 1;
                    break switchLabel;
                }
                
            }
            
            case 70 -> {
                
                if (3 <= numTowers) {
                    numSrps = 0;
                    numMoneyTowers = 3;
                    break switchLabel;
                }
                
                if (2 <= numTowers) {
                    numSrps = 5;
                    numMoneyTowers = 2;
                    break switchLabel;
                }
                
            }
            
            case 80 -> {
                
                if (4 <= numTowers) {
                    numSrps = 0;
                    numMoneyTowers = 4;
                    break switchLabel;
                }
                
                if (2 <= numTowers) {
                    numSrps = 5;
                    numMoneyTowers = 2;
                    break switchLabel;
                }
                
                if (1 <= numTowers) {
                    numSrps = 20;
                    numMoneyTowers = 1;
                    break switchLabel;
                }
                
            }
            
            case 90 -> {
                
                if (4 <= numTowers) {
                    numSrps = 0;
                    numMoneyTowers = 4;
                    break switchLabel;
                }
                
                if (1 <= numTowers) {
                    numSrps = 20;
                    numMoneyTowers = 1;
                    break switchLabel;
                }
                
            }
            
            case 100 -> {
                
                if (5 <= numTowers) {
                    numSrps = 0;
                    numMoneyTowers = 5;
                    break switchLabel;
                }
                
                if (2 <= numTowers) {
                    numSrps = 10;
                    numMoneyTowers = 2;
                    break switchLabel;
                }
                
            }
            
            case 110 -> {
                
                if (5 <= numTowers) {
                    numSrps = 0;
                    numMoneyTowers = 5;
                    break switchLabel;
                }
                
                if (2 <= numTowers) {
                    numSrps = 10;
                    numMoneyTowers = 2;
                    break switchLabel;
                }
                
            }
            
            case 120 -> {
                
                if (6 <= numTowers) {
                    numSrps = 0;
                    numMoneyTowers = 6;
                    break switchLabel;
                }
                
            }
            
            case 130 -> {
                
                if (6 <= numTowers) {
                    numSrps = 0;
                    numMoneyTowers = 6;
                    break switchLabel;
                }
                
                if (5 <= numTowers) {
                    numSrps = 2;
                    numMoneyTowers = 5;
                    break switchLabel;
                }
                
                if (2 <= numTowers) {
                    numSrps = 15;
                    numMoneyTowers = 2;
                    break switchLabel;
                }
                
            }
            
            case 140 -> {
                
                if (7 <= numTowers) {
                    numSrps = 0;
                    numMoneyTowers = 7;
                    break switchLabel;
                }
                
                if (5 <= numTowers) {
                    numSrps = 2;
                    numMoneyTowers = 5;
                    break switchLabel;
                }
                
                if (4 <= numTowers) {
                    numSrps = 5;
                    numMoneyTowers = 4;
                    break switchLabel;
                }
                
                if (2 <= numTowers) {
                    numSrps = 15;
                    numMoneyTowers = 2;
                    break switchLabel;
                }
                
            }
            
            case 150 -> {
                
                if (7 <= numTowers) {
                    numSrps = 0;
                    numMoneyTowers = 7;
                    break switchLabel;
                }
                
                if (4 <= numTowers) {
                    numSrps = 5;
                    numMoneyTowers = 4;
                    break switchLabel;
                }
                
                if (3 <= numTowers) {
                    numSrps = 10;
                    numMoneyTowers = 3;
                    break switchLabel;
                }
                
            }
            
            case 160 -> {
                
                if (8 <= numTowers) {
                    numSrps = 0;
                    numMoneyTowers = 8;
                    break switchLabel;
                }
                
                if (5 <= numTowers) {
                    numSrps = 4;
                    numMoneyTowers = 5;
                    break switchLabel;
                }
                
                if (3 <= numTowers) {
                    numSrps = 10;
                    numMoneyTowers = 3;
                    break switchLabel;
                }
                
                if (2 <= numTowers) {
                    numSrps = 20;
                    numMoneyTowers = 2;
                    break switchLabel;
                }
                
            }
            
            case 170 -> {
                
                if (8 <= numTowers) {
                    numSrps = 0;
                    numMoneyTowers = 8;
                    break switchLabel;
                }
                
                if (5 <= numTowers) {
                    numSrps = 4;
                    numMoneyTowers = 5;
                    break switchLabel;
                }
                
                if (2 <= numTowers) {
                    numSrps = 20;
                    numMoneyTowers = 2;
                    break switchLabel;
                }
                
            }
            
            case 180 -> {
                
                if (9 <= numTowers) {
                    numSrps = 0;
                    numMoneyTowers = 9;
                    break switchLabel;
                }
                
            }
            
            case 190 -> {
                
                if (9 <= numTowers) {
                    numSrps = 0;
                    numMoneyTowers = 9;
                    break switchLabel;
                }
                
                if (5 <= numTowers) {
                    numSrps = 6;
                    numMoneyTowers = 5;
                    break switchLabel;
                }
                
            }
            
            case 200 -> {
                
                if (10 <= numTowers) {
                    numSrps = 0;
                    numMoneyTowers = 10;
                    break switchLabel;
                }
                
                if (5 <= numTowers) {
                    numSrps = 6;
                    numMoneyTowers = 5;
                    break switchLabel;
                }
                
                if (4 <= numTowers) {
                    numSrps = 10;
                    numMoneyTowers = 4;
                    break switchLabel;
                }
                
            }
            
            case 210 -> {
                
                if (10 <= numTowers) {
                    numSrps = 0;
                    numMoneyTowers = 10;
                    break switchLabel;
                }
                
                if (6 <= numTowers) {
                    numSrps = 5;
                    numMoneyTowers = 6;
                    break switchLabel;
                }
                
                if (4 <= numTowers) {
                    numSrps = 10;
                    numMoneyTowers = 4;
                    break switchLabel;
                }
                
            }
            
            case 220 -> {
                
                if (11 <= numTowers) {
                    numSrps = 0;
                    numMoneyTowers = 11;
                    break switchLabel;
                }
                
                if (6 <= numTowers) {
                    numSrps = 5;
                    numMoneyTowers = 6;
                    break switchLabel;
                }
                
                if (5 <= numTowers) {
                    numSrps = 8;
                    numMoneyTowers = 5;
                    break switchLabel;
                }
                
            }
            
            case 230 -> {
                
                if (11 <= numTowers) {
                    numSrps = 0;
                    numMoneyTowers = 11;
                    break switchLabel;
                }
                
                if (10 <= numTowers) {
                    numSrps = 1;
                    numMoneyTowers = 10;
                    break switchLabel;
                }
                
                if (5 <= numTowers) {
                    numSrps = 8;
                    numMoneyTowers = 5;
                    break switchLabel;
                }
                
            }
            
            case 240 -> {
                
                if (12 <= numTowers) {
                    numSrps = 0;
                    numMoneyTowers = 12;
                    break switchLabel;
                }
                
                if (10 <= numTowers) {
                    numSrps = 1;
                    numMoneyTowers = 10;
                    break switchLabel;
                }
                
                if (3 <= numTowers) {
                    numSrps = 20;
                    numMoneyTowers = 3;
                    break switchLabel;
                }
                
            }
            
            case 250 -> {
                
                if (12 <= numTowers) {
                    numSrps = 0;
                    numMoneyTowers = 12;
                    break switchLabel;
                }
                
                if (5 <= numTowers) {
                    numSrps = 10;
                    numMoneyTowers = 5;
                    break switchLabel;
                }
                
                if (3 <= numTowers) {
                    numSrps = 20;
                    numMoneyTowers = 3;
                    break switchLabel;
                }
                
            }
            
            case 260 -> {
                
                if (13 <= numTowers) {
                    numSrps = 0;
                    numMoneyTowers = 13;
                    break switchLabel;
                }
                
                if (10 <= numTowers) {
                    numSrps = 2;
                    numMoneyTowers = 10;
                    break switchLabel;
                }
                
                if (5 <= numTowers) {
                    numSrps = 10;
                    numMoneyTowers = 5;
                    break switchLabel;
                }
                
                if (4 <= numTowers) {
                    numSrps = 15;
                    numMoneyTowers = 4;
                    break switchLabel;
                }
                
            }
            
            case 270 -> {
                
                if (13 <= numTowers) {
                    numSrps = 0;
                    numMoneyTowers = 13;
                    break switchLabel;
                }
                
                if (10 <= numTowers) {
                    numSrps = 2;
                    numMoneyTowers = 10;
                    break switchLabel;
                }
                
                if (4 <= numTowers) {
                    numSrps = 15;
                    numMoneyTowers = 4;
                    break switchLabel;
                }
                
            }
            
            case 280 -> {
                
                if (14 <= numTowers) {
                    numSrps = 0;
                    numMoneyTowers = 14;
                    break switchLabel;
                }
                
                if (8 <= numTowers) {
                    numSrps = 5;
                    numMoneyTowers = 8;
                    break switchLabel;
                }
                
                if (5 <= numTowers) {
                    numSrps = 12;
                    numMoneyTowers = 5;
                    break switchLabel;
                }
                
            }
            
            case 290 -> {
                
                if (14 <= numTowers) {
                    numSrps = 0;
                    numMoneyTowers = 14;
                    break switchLabel;
                }
                
                if (10 <= numTowers) {
                    numSrps = 3;
                    numMoneyTowers = 10;
                    break switchLabel;
                }
                
                if (8 <= numTowers) {
                    numSrps = 5;
                    numMoneyTowers = 8;
                    break switchLabel;
                }
                
                if (5 <= numTowers) {
                    numSrps = 12;
                    numMoneyTowers = 5;
                    break switchLabel;
                }
                
            }
            
            case 300 -> {
                
                if (15 <= numTowers) {
                    numSrps = 0;
                    numMoneyTowers = 15;
                    break switchLabel;
                }
                
                if (10 <= numTowers) {
                    numSrps = 3;
                    numMoneyTowers = 10;
                    break switchLabel;
                }
                
                if (6 <= numTowers) {
                    numSrps = 10;
                    numMoneyTowers = 6;
                    break switchLabel;
                }
                
            }
            
            case 310 -> {
                
                if (15 <= numTowers) {
                    numSrps = 0;
                    numMoneyTowers = 15;
                    break switchLabel;
                }
                
                if (6 <= numTowers) {
                    numSrps = 10;
                    numMoneyTowers = 6;
                    break switchLabel;
                }
                
                if (5 <= numTowers) {
                    numSrps = 14;
                    numMoneyTowers = 5;
                    break switchLabel;
                }
                
            }
            
            case 320 -> {
                
                if (16 <= numTowers) {
                    numSrps = 0;
                    numMoneyTowers = 16;
                    break switchLabel;
                }
                
                if (10 <= numTowers) {
                    numSrps = 4;
                    numMoneyTowers = 10;
                    break switchLabel;
                }
                
                if (5 <= numTowers) {
                    numSrps = 14;
                    numMoneyTowers = 5;
                    break switchLabel;
                }
                
                if (4 <= numTowers) {
                    numSrps = 20;
                    numMoneyTowers = 4;
                    break switchLabel;
                }
                
            }
            
            case 330 -> {
                
                if (16 <= numTowers) {
                    numSrps = 0;
                    numMoneyTowers = 16;
                    break switchLabel;
                }
                
                if (10 <= numTowers) {
                    numSrps = 4;
                    numMoneyTowers = 10;
                    break switchLabel;
                }
                
                if (4 <= numTowers) {
                    numSrps = 20;
                    numMoneyTowers = 4;
                    break switchLabel;
                }
                
            }
            
            case 340 -> {
                
                if (17 <= numTowers) {
                    numSrps = 0;
                    numMoneyTowers = 17;
                    break switchLabel;
                }
                
                if (5 <= numTowers) {
                    numSrps = 16;
                    numMoneyTowers = 5;
                    break switchLabel;
                }
                
            }
            
            case 350 -> {
                
                if (17 <= numTowers) {
                    numSrps = 0;
                    numMoneyTowers = 17;
                    break switchLabel;
                }
                
                if (10 <= numTowers) {
                    numSrps = 5;
                    numMoneyTowers = 10;
                    break switchLabel;
                }
                
                if (7 <= numTowers) {
                    numSrps = 10;
                    numMoneyTowers = 7;
                    break switchLabel;
                }
                
                if (5 <= numTowers) {
                    numSrps = 16;
                    numMoneyTowers = 5;
                    break switchLabel;
                }
                
            }
            
            case 360 -> {
                
                if (18 <= numTowers) {
                    numSrps = 0;
                    numMoneyTowers = 18;
                    break switchLabel;
                }
                
                if (10 <= numTowers) {
                    numSrps = 5;
                    numMoneyTowers = 10;
                    break switchLabel;
                }
                
                if (7 <= numTowers) {
                    numSrps = 10;
                    numMoneyTowers = 7;
                    break switchLabel;
                }
                
            }
            
            case 370 -> {
                
                if (18 <= numTowers) {
                    numSrps = 0;
                    numMoneyTowers = 18;
                    break switchLabel;
                }
                
                if (5 <= numTowers) {
                    numSrps = 18;
                    numMoneyTowers = 5;
                    break switchLabel;
                }
                
            }
            
            case 380 -> {
                
                if (19 <= numTowers) {
                    numSrps = 0;
                    numMoneyTowers = 19;
                    break switchLabel;
                }
                
                if (10 <= numTowers) {
                    numSrps = 6;
                    numMoneyTowers = 10;
                    break switchLabel;
                }
                
                if (5 <= numTowers) {
                    numSrps = 18;
                    numMoneyTowers = 5;
                    break switchLabel;
                }
                
            }
            
            case 390 -> {
                
                if (19 <= numTowers) {
                    numSrps = 0;
                    numMoneyTowers = 19;
                    break switchLabel;
                }
                
                if (15 <= numTowers) {
                    numSrps = 2;
                    numMoneyTowers = 15;
                    break switchLabel;
                }
                
                if (10 <= numTowers) {
                    numSrps = 6;
                    numMoneyTowers = 10;
                    break switchLabel;
                }
                
                if (6 <= numTowers) {
                    numSrps = 15;
                    numMoneyTowers = 6;
                    break switchLabel;
                }
                
            }
            
            case 400 -> {
                
                if (20 <= numTowers) {
                    numSrps = 0;
                    numMoneyTowers = 20;
                    break switchLabel;
                }
                
                if (15 <= numTowers) {
                    numSrps = 2;
                    numMoneyTowers = 15;
                    break switchLabel;
                }
                
                if (8 <= numTowers) {
                    numSrps = 10;
                    numMoneyTowers = 8;
                    break switchLabel;
                }
                
                if (6 <= numTowers) {
                    numSrps = 15;
                    numMoneyTowers = 6;
                    break switchLabel;
                }
                
                if (5 <= numTowers) {
                    numSrps = 20;
                    numMoneyTowers = 5;
                    break switchLabel;
                }
                
            }
            
            case 410 -> {
                
                if (20 <= numTowers) {
                    numSrps = 0;
                    numMoneyTowers = 20;
                    break switchLabel;
                }
                
                if (10 <= numTowers) {
                    numSrps = 7;
                    numMoneyTowers = 10;
                    break switchLabel;
                }
                
                if (8 <= numTowers) {
                    numSrps = 10;
                    numMoneyTowers = 8;
                    break switchLabel;
                }
                
                if (5 <= numTowers) {
                    numSrps = 20;
                    numMoneyTowers = 5;
                    break switchLabel;
                }
                
            }
            
            case 420 -> {
                
                if (21 <= numTowers) {
                    numSrps = 0;
                    numMoneyTowers = 21;
                    break switchLabel;
                }
                
                if (12 <= numTowers) {
                    numSrps = 5;
                    numMoneyTowers = 12;
                    break switchLabel;
                }
                
                if (10 <= numTowers) {
                    numSrps = 7;
                    numMoneyTowers = 10;
                    break switchLabel;
                }
                
            }
            
            case 430 -> {
                
                if (21 <= numTowers) {
                    numSrps = 0;
                    numMoneyTowers = 21;
                    break switchLabel;
                }
                
                if (12 <= numTowers) {
                    numSrps = 5;
                    numMoneyTowers = 12;
                    break switchLabel;
                }
                
                if (5 <= numTowers) {
                    numSrps = 22;
                    numMoneyTowers = 5;
                    break switchLabel;
                }
                
            }
            
            case 440 -> {
                
                if (22 <= numTowers) {
                    numSrps = 0;
                    numMoneyTowers = 22;
                    break switchLabel;
                }
                
                if (10 <= numTowers) {
                    numSrps = 8;
                    numMoneyTowers = 10;
                    break switchLabel;
                }
                
                if (5 <= numTowers) {
                    numSrps = 22;
                    numMoneyTowers = 5;
                    break switchLabel;
                }
                
            }
            
            case 450 -> {
                
                if (22 <= numTowers) {
                    numSrps = 0;
                    numMoneyTowers = 22;
                    break switchLabel;
                }
                
                if (10 <= numTowers) {
                    numSrps = 8;
                    numMoneyTowers = 10;
                    break switchLabel;
                }
                
                if (9 <= numTowers) {
                    numSrps = 10;
                    numMoneyTowers = 9;
                    break switchLabel;
                }
                
            }
            
            case 460 -> {
                
                if (23 <= numTowers) {
                    numSrps = 0;
                    numMoneyTowers = 23;
                    break switchLabel;
                }
                
                if (20 <= numTowers) {
                    numSrps = 1;
                    numMoneyTowers = 20;
                    break switchLabel;
                }
                
                if (9 <= numTowers) {
                    numSrps = 10;
                    numMoneyTowers = 9;
                    break switchLabel;
                }
                
                if (5 <= numTowers) {
                    numSrps = 24;
                    numMoneyTowers = 5;
                    break switchLabel;
                }
                
            }
            
            case 470 -> {
                
                if (23 <= numTowers) {
                    numSrps = 0;
                    numMoneyTowers = 23;
                    break switchLabel;
                }
                
                if (20 <= numTowers) {
                    numSrps = 1;
                    numMoneyTowers = 20;
                    break switchLabel;
                }
                
                if (10 <= numTowers) {
                    numSrps = 9;
                    numMoneyTowers = 10;
                    break switchLabel;
                }
                
                if (5 <= numTowers) {
                    numSrps = 24;
                    numMoneyTowers = 5;
                    break switchLabel;
                }
                
            }
            
            case 480 -> {
                
                if (24 <= numTowers) {
                    numSrps = 0;
                    numMoneyTowers = 24;
                    break switchLabel;
                }
                
                if (15 <= numTowers) {
                    numSrps = 4;
                    numMoneyTowers = 15;
                    break switchLabel;
                }
                
                if (10 <= numTowers) {
                    numSrps = 9;
                    numMoneyTowers = 10;
                    break switchLabel;
                }
                
                if (6 <= numTowers) {
                    numSrps = 20;
                    numMoneyTowers = 6;
                    break switchLabel;
                }
                
            }
            
            case 490 -> {
                
                if (24 <= numTowers) {
                    numSrps = 0;
                    numMoneyTowers = 24;
                    break switchLabel;
                }
                
                if (15 <= numTowers) {
                    numSrps = 4;
                    numMoneyTowers = 15;
                    break switchLabel;
                }
                
                if (14 <= numTowers) {
                    numSrps = 5;
                    numMoneyTowers = 14;
                    break switchLabel;
                }
                
                if (6 <= numTowers) {
                    numSrps = 20;
                    numMoneyTowers = 6;
                    break switchLabel;
                }
                
            }
            
            case 23 -> {
                
                if (1 <= numTowers) {
                    numSrps = 1;
                    numMoneyTowers = 1;
                    break switchLabel;
                }
                
            }
            
            case 33 -> {
                
                if (1 <= numTowers) {
                    numSrps = 1;
                    numMoneyTowers = 1;
                    break switchLabel;
                }
                
            }
            
            case 46 -> {
                
                if (2 <= numTowers) {
                    numSrps = 1;
                    numMoneyTowers = 2;
                    break switchLabel;
                }
                
            }
            
            case 56 -> {
                
                if (2 <= numTowers) {
                    numSrps = 1;
                    numMoneyTowers = 2;
                    break switchLabel;
                }
                
                if (1 <= numTowers) {
                    numSrps = 12;
                    numMoneyTowers = 1;
                    break switchLabel;
                }
                
            }
            
            case 69 -> {
                
                if (3 <= numTowers) {
                    numSrps = 1;
                    numMoneyTowers = 3;
                    break switchLabel;
                }
                
                if (1 <= numTowers) {
                    numSrps = 13;
                    numMoneyTowers = 1;
                    break switchLabel;
                }
                
            }
            
            case 79 -> {
                
                if (3 <= numTowers) {
                    numSrps = 1;
                    numMoneyTowers = 3;
                    break switchLabel;
                }
                
            }
            
            case 92 -> {
                
                if (4 <= numTowers) {
                    numSrps = 1;
                    numMoneyTowers = 4;
                    break switchLabel;
                }
                
                if (2 <= numTowers) {
                    numSrps = 7;
                    numMoneyTowers = 2;
                    break switchLabel;
                }
                
                if (1 <= numTowers) {
                    numSrps = 24;
                    numMoneyTowers = 1;
                    break switchLabel;
                }
                
            }
            
            case 102 -> {
                
                if (4 <= numTowers) {
                    numSrps = 1;
                    numMoneyTowers = 4;
                    break switchLabel;
                }
                
                if (1 <= numTowers) {
                    numSrps = 24;
                    numMoneyTowers = 1;
                    break switchLabel;
                }
                
            }
            
            case 115 -> {
                
                if (5 <= numTowers) {
                    numSrps = 1;
                    numMoneyTowers = 5;
                    break switchLabel;
                }
                
                if (3 <= numTowers) {
                    numSrps = 5;
                    numMoneyTowers = 3;
                    break switchLabel;
                }
                
            }
            
            case 125 -> {
                
                if (5 <= numTowers) {
                    numSrps = 1;
                    numMoneyTowers = 5;
                    break switchLabel;
                }
                
            }
            
            case 138 -> {
                
                if (6 <= numTowers) {
                    numSrps = 1;
                    numMoneyTowers = 6;
                    break switchLabel;
                }
                
                if (4 <= numTowers) {
                    numSrps = 4;
                    numMoneyTowers = 4;
                    break switchLabel;
                }
                
            }
            
            case 148 -> {
                
                if (6 <= numTowers) {
                    numSrps = 1;
                    numMoneyTowers = 6;
                    break switchLabel;
                }
                
                if (2 <= numTowers) {
                    numSrps = 18;
                    numMoneyTowers = 2;
                    break switchLabel;
                }
                
            }
            
            case 161 -> {
                
                if (7 <= numTowers) {
                    numSrps = 1;
                    numMoneyTowers = 7;
                    break switchLabel;
                }
                
            }
            
            case 171 -> {
                
                if (7 <= numTowers) {
                    numSrps = 1;
                    numMoneyTowers = 7;
                    break switchLabel;
                }
                
            }
            
            case 184 -> {
                
                if (8 <= numTowers) {
                    numSrps = 1;
                    numMoneyTowers = 8;
                    break switchLabel;
                }
                
                if (6 <= numTowers) {
                    numSrps = 3;
                    numMoneyTowers = 6;
                    break switchLabel;
                }
                
                if (2 <= numTowers) {
                    numSrps = 24;
                    numMoneyTowers = 2;
                    break switchLabel;
                }
                
            }
            
            case 194 -> {
                
                if (8 <= numTowers) {
                    numSrps = 1;
                    numMoneyTowers = 8;
                    break switchLabel;
                }
                
                if (2 <= numTowers) {
                    numSrps = 24;
                    numMoneyTowers = 2;
                    break switchLabel;
                }
                
            }
            
            case 207 -> {
                
                if (9 <= numTowers) {
                    numSrps = 1;
                    numMoneyTowers = 9;
                    break switchLabel;
                }
                
            }
            
            case 217 -> {
                
                if (9 <= numTowers) {
                    numSrps = 1;
                    numMoneyTowers = 9;
                    break switchLabel;
                }
                
            }
            
            case 253 -> {
                
                if (11 <= numTowers) {
                    numSrps = 1;
                    numMoneyTowers = 11;
                    break switchLabel;
                }
                
            }
            
            case 263 -> {
                
                if (11 <= numTowers) {
                    numSrps = 1;
                    numMoneyTowers = 11;
                    break switchLabel;
                }
                
            }
            
            case 276 -> {
                
                if (12 <= numTowers) {
                    numSrps = 1;
                    numMoneyTowers = 12;
                    break switchLabel;
                }
                
                if (7 <= numTowers) {
                    numSrps = 6;
                    numMoneyTowers = 7;
                    break switchLabel;
                }
                
                if (3 <= numTowers) {
                    numSrps = 24;
                    numMoneyTowers = 3;
                    break switchLabel;
                }
                
            }
            
            case 286 -> {
                
                if (12 <= numTowers) {
                    numSrps = 1;
                    numMoneyTowers = 12;
                    break switchLabel;
                }
                
                if (11 <= numTowers) {
                    numSrps = 2;
                    numMoneyTowers = 11;
                    break switchLabel;
                }
                
                if (3 <= numTowers) {
                    numSrps = 24;
                    numMoneyTowers = 3;
                    break switchLabel;
                }
                
            }
            
            case 299 -> {
                
                if (13 <= numTowers) {
                    numSrps = 1;
                    numMoneyTowers = 13;
                    break switchLabel;
                }
                
            }
            
            case 309 -> {
                
                if (13 <= numTowers) {
                    numSrps = 1;
                    numMoneyTowers = 13;
                    break switchLabel;
                }
                
            }
            
            case 322 -> {
                
                if (14 <= numTowers) {
                    numSrps = 1;
                    numMoneyTowers = 14;
                    break switchLabel;
                }
                
                if (12 <= numTowers) {
                    numSrps = 2;
                    numMoneyTowers = 12;
                    break switchLabel;
                }
                
            }
            
            case 332 -> {
                
                if (14 <= numTowers) {
                    numSrps = 1;
                    numMoneyTowers = 14;
                    break switchLabel;
                }
                
                if (4 <= numTowers) {
                    numSrps = 21;
                    numMoneyTowers = 4;
                    break switchLabel;
                }
                
            }
            
            case 345 -> {
                
                if (15 <= numTowers) {
                    numSrps = 1;
                    numMoneyTowers = 15;
                    break switchLabel;
                }
                
            }
            
            case 355 -> {
                
                if (15 <= numTowers) {
                    numSrps = 1;
                    numMoneyTowers = 15;
                    break switchLabel;
                }
                
                if (5 <= numTowers) {
                    numSrps = 17;
                    numMoneyTowers = 5;
                    break switchLabel;
                }
                
            }
            
            case 368 -> {
                
                if (16 <= numTowers) {
                    numSrps = 1;
                    numMoneyTowers = 16;
                    break switchLabel;
                }
                
                if (4 <= numTowers) {
                    numSrps = 24;
                    numMoneyTowers = 4;
                    break switchLabel;
                }
                
            }
            
            case 378 -> {
                
                if (16 <= numTowers) {
                    numSrps = 1;
                    numMoneyTowers = 16;
                    break switchLabel;
                }
                
                if (4 <= numTowers) {
                    numSrps = 24;
                    numMoneyTowers = 4;
                    break switchLabel;
                }
                
            }
            
            case 391 -> {
                
                if (17 <= numTowers) {
                    numSrps = 1;
                    numMoneyTowers = 17;
                    break switchLabel;
                }
                
            }
            
            case 401 -> {
                
                if (17 <= numTowers) {
                    numSrps = 1;
                    numMoneyTowers = 17;
                    break switchLabel;
                }
                
            }
            
            case 414 -> {
                
                if (18 <= numTowers) {
                    numSrps = 1;
                    numMoneyTowers = 18;
                    break switchLabel;
                }
                
            }
            
            case 424 -> {
                
                if (18 <= numTowers) {
                    numSrps = 1;
                    numMoneyTowers = 18;
                    break switchLabel;
                }
                
                if (8 <= numTowers) {
                    numSrps = 11;
                    numMoneyTowers = 8;
                    break switchLabel;
                }
                
            }
            
            case 437 -> {
                
                if (19 <= numTowers) {
                    numSrps = 1;
                    numMoneyTowers = 19;
                    break switchLabel;
                }
                
            }
            
            case 447 -> {
                
                if (19 <= numTowers) {
                    numSrps = 1;
                    numMoneyTowers = 19;
                    break switchLabel;
                }
                
            }
            
            case 483 -> {
                
                if (21 <= numTowers) {
                    numSrps = 1;
                    numMoneyTowers = 21;
                    break switchLabel;
                }
                
            }
            
            case 493 -> {
                
                if (21 <= numTowers) {
                    numSrps = 1;
                    numMoneyTowers = 21;
                    break switchLabel;
                }
                
                if (17 <= numTowers) {
                    numSrps = 3;
                    numMoneyTowers = 17;
                    break switchLabel;
                }
                
            }
            
            case 506 -> {
                
                if (22 <= numTowers) {
                    numSrps = 1;
                    numMoneyTowers = 22;
                    break switchLabel;
                }
                
                if (8 <= numTowers) {
                    numSrps = 14;
                    numMoneyTowers = 8;
                    break switchLabel;
                }
                
            }
            
            case 516 -> {
                
                if (22 <= numTowers) {
                    numSrps = 1;
                    numMoneyTowers = 22;
                    break switchLabel;
                }
                
                if (6 <= numTowers) {
                    numSrps = 22;
                    numMoneyTowers = 6;
                    break switchLabel;
                }
                
            }
            
            case 529 -> {
                
                if (23 <= numTowers) {
                    numSrps = 1;
                    numMoneyTowers = 23;
                    break switchLabel;
                }
                
            }
            
            case 539 -> {
                
                if (23 <= numTowers) {
                    numSrps = 1;
                    numMoneyTowers = 23;
                    break switchLabel;
                }
                
                if (7 <= numTowers) {
                    numSrps = 19;
                    numMoneyTowers = 7;
                    break switchLabel;
                }
                
            }
            
            case 552 -> {
                
                if (24 <= numTowers) {
                    numSrps = 1;
                    numMoneyTowers = 24;
                    break switchLabel;
                }
                
                if (6 <= numTowers) {
                    numSrps = 24;
                    numMoneyTowers = 6;
                    break switchLabel;
                }
                
            }
            
            case 562 -> {
                
                if (24 <= numTowers) {
                    numSrps = 1;
                    numMoneyTowers = 24;
                    break switchLabel;
                }
                
                if (6 <= numTowers) {
                    numSrps = 24;
                    numMoneyTowers = 6;
                    break switchLabel;
                }
                
            }
            
            case 26 -> {
                
                if (1 <= numTowers) {
                    numSrps = 2;
                    numMoneyTowers = 1;
                    break switchLabel;
                }
                
            }
            
            case 36 -> {
                
                if (1 <= numTowers) {
                    numSrps = 2;
                    numMoneyTowers = 1;
                    break switchLabel;
                }
                
            }
            
            case 52 -> {
                
                if (2 <= numTowers) {
                    numSrps = 2;
                    numMoneyTowers = 2;
                    break switchLabel;
                }
                
            }
            
            case 62 -> {
                
                if (2 <= numTowers) {
                    numSrps = 2;
                    numMoneyTowers = 2;
                    break switchLabel;
                }
                
                if (1 <= numTowers) {
                    numSrps = 14;
                    numMoneyTowers = 1;
                    break switchLabel;
                }
                
            }
            
            case 78 -> {
                
                if (3 <= numTowers) {
                    numSrps = 2;
                    numMoneyTowers = 3;
                    break switchLabel;
                }
                
                if (1 <= numTowers) {
                    numSrps = 16;
                    numMoneyTowers = 1;
                    break switchLabel;
                }
                
            }
            
            case 88 -> {
                
                if (3 <= numTowers) {
                    numSrps = 2;
                    numMoneyTowers = 3;
                    break switchLabel;
                }
                
                if (2 <= numTowers) {
                    numSrps = 8;
                    numMoneyTowers = 2;
                    break switchLabel;
                }
                
            }
            
            case 104 -> {
                
                if (4 <= numTowers) {
                    numSrps = 2;
                    numMoneyTowers = 4;
                    break switchLabel;
                }
                
                if (2 <= numTowers) {
                    numSrps = 9;
                    numMoneyTowers = 2;
                    break switchLabel;
                }
                
            }
            
            case 114 -> {
                
                if (4 <= numTowers) {
                    numSrps = 2;
                    numMoneyTowers = 4;
                    break switchLabel;
                }
                
                if (3 <= numTowers) {
                    numSrps = 6;
                    numMoneyTowers = 3;
                    break switchLabel;
                }
                
            }
            
            case 156 -> {
                
                if (6 <= numTowers) {
                    numSrps = 2;
                    numMoneyTowers = 6;
                    break switchLabel;
                }
                
            }
            
            case 166 -> {
                
                if (6 <= numTowers) {
                    numSrps = 2;
                    numMoneyTowers = 6;
                    break switchLabel;
                }
                
                if (2 <= numTowers) {
                    numSrps = 21;
                    numMoneyTowers = 2;
                    break switchLabel;
                }
                
            }
            
            case 182 -> {
                
                if (7 <= numTowers) {
                    numSrps = 2;
                    numMoneyTowers = 7;
                    break switchLabel;
                }
                
                if (2 <= numTowers) {
                    numSrps = 22;
                    numMoneyTowers = 2;
                    break switchLabel;
                }
                
            }
            
            case 192 -> {
                
                if (7 <= numTowers) {
                    numSrps = 2;
                    numMoneyTowers = 7;
                    break switchLabel;
                }
                
                if (6 <= numTowers) {
                    numSrps = 4;
                    numMoneyTowers = 6;
                    break switchLabel;
                }
                
            }
            
            case 208 -> {
                
                if (8 <= numTowers) {
                    numSrps = 2;
                    numMoneyTowers = 8;
                    break switchLabel;
                }
                
            }
            
            case 218 -> {
                
                if (8 <= numTowers) {
                    numSrps = 2;
                    numMoneyTowers = 8;
                    break switchLabel;
                }
                
            }
            
            case 234 -> {
                
                if (9 <= numTowers) {
                    numSrps = 2;
                    numMoneyTowers = 9;
                    break switchLabel;
                }
                
                if (7 <= numTowers) {
                    numSrps = 4;
                    numMoneyTowers = 7;
                    break switchLabel;
                }
                
                if (4 <= numTowers) {
                    numSrps = 12;
                    numMoneyTowers = 4;
                    break switchLabel;
                }
                
            }
            
            case 244 -> {
                
                if (9 <= numTowers) {
                    numSrps = 2;
                    numMoneyTowers = 9;
                    break switchLabel;
                }
                
            }
            
            case 296 -> {
                
                if (11 <= numTowers) {
                    numSrps = 2;
                    numMoneyTowers = 11;
                    break switchLabel;
                }
                
                if (4 <= numTowers) {
                    numSrps = 18;
                    numMoneyTowers = 4;
                    break switchLabel;
                }
                
            }
            
            case 312 -> {
                
                if (12 <= numTowers) {
                    numSrps = 2;
                    numMoneyTowers = 12;
                    break switchLabel;
                }
                
            }
            
            case 338 -> {
                
                if (13 <= numTowers) {
                    numSrps = 2;
                    numMoneyTowers = 13;
                    break switchLabel;
                }
                
                if (8 <= numTowers) {
                    numSrps = 7;
                    numMoneyTowers = 8;
                    break switchLabel;
                }
                
            }
            
            case 348 -> {
                
                if (13 <= numTowers) {
                    numSrps = 2;
                    numMoneyTowers = 13;
                    break switchLabel;
                }
                
                if (12 <= numTowers) {
                    numSrps = 3;
                    numMoneyTowers = 12;
                    break switchLabel;
                }
                
            }
            
            case 364 -> {
                
                if (14 <= numTowers) {
                    numSrps = 2;
                    numMoneyTowers = 14;
                    break switchLabel;
                }
                
                if (6 <= numTowers) {
                    numSrps = 13;
                    numMoneyTowers = 6;
                    break switchLabel;
                }
                
            }
            
            case 374 -> {
                
                if (14 <= numTowers) {
                    numSrps = 2;
                    numMoneyTowers = 14;
                    break switchLabel;
                }
                
            }
            
            case 416 -> {
                
                if (16 <= numTowers) {
                    numSrps = 2;
                    numMoneyTowers = 16;
                    break switchLabel;
                }
                
                if (14 <= numTowers) {
                    numSrps = 3;
                    numMoneyTowers = 14;
                    break switchLabel;
                }
                
                if (13 <= numTowers) {
                    numSrps = 4;
                    numMoneyTowers = 13;
                    break switchLabel;
                }
                
            }
            
            case 426 -> {
                
                if (16 <= numTowers) {
                    numSrps = 2;
                    numMoneyTowers = 16;
                    break switchLabel;
                }
                
                if (13 <= numTowers) {
                    numSrps = 4;
                    numMoneyTowers = 13;
                    break switchLabel;
                }
                
                if (6 <= numTowers) {
                    numSrps = 17;
                    numMoneyTowers = 6;
                    break switchLabel;
                }
                
            }
            
            case 442 -> {
                
                if (17 <= numTowers) {
                    numSrps = 2;
                    numMoneyTowers = 17;
                    break switchLabel;
                }
                
            }
            
            case 452 -> {
                
                if (17 <= numTowers) {
                    numSrps = 2;
                    numMoneyTowers = 17;
                    break switchLabel;
                }
                
            }
            
            case 468 -> {
                
                if (18 <= numTowers) {
                    numSrps = 2;
                    numMoneyTowers = 18;
                    break switchLabel;
                }
                
            }
            
            case 478 -> {
                
                if (18 <= numTowers) {
                    numSrps = 2;
                    numMoneyTowers = 18;
                    break switchLabel;
                }
                
            }
            
            case 494 -> {
                
                if (19 <= numTowers) {
                    numSrps = 2;
                    numMoneyTowers = 19;
                    break switchLabel;
                }
                
                if (13 <= numTowers) {
                    numSrps = 6;
                    numMoneyTowers = 13;
                    break switchLabel;
                }
                
                if (11 <= numTowers) {
                    numSrps = 8;
                    numMoneyTowers = 11;
                    break switchLabel;
                }
                
            }
            
            case 504 -> {
                
                if (19 <= numTowers) {
                    numSrps = 2;
                    numMoneyTowers = 19;
                    break switchLabel;
                }
                
                if (13 <= numTowers) {
                    numSrps = 6;
                    numMoneyTowers = 13;
                    break switchLabel;
                }
                
                if (9 <= numTowers) {
                    numSrps = 12;
                    numMoneyTowers = 9;
                    break switchLabel;
                }
                
            }
            
            case 520 -> {
                
                if (20 <= numTowers) {
                    numSrps = 2;
                    numMoneyTowers = 20;
                    break switchLabel;
                }
                
                if (8 <= numTowers) {
                    numSrps = 15;
                    numMoneyTowers = 8;
                    break switchLabel;
                }
                
            }
            
            case 530 -> {
                
                if (20 <= numTowers) {
                    numSrps = 2;
                    numMoneyTowers = 20;
                    break switchLabel;
                }
                
                if (10 <= numTowers) {
                    numSrps = 11;
                    numMoneyTowers = 10;
                    break switchLabel;
                }
                
                if (8 <= numTowers) {
                    numSrps = 15;
                    numMoneyTowers = 8;
                    break switchLabel;
                }
                
            }
            
            case 546 -> {
                
                if (21 <= numTowers) {
                    numSrps = 2;
                    numMoneyTowers = 21;
                    break switchLabel;
                }
                
            }
            
            case 556 -> {
                
                if (21 <= numTowers) {
                    numSrps = 2;
                    numMoneyTowers = 21;
                    break switchLabel;
                }
                
            }
            
            case 572 -> {
                
                if (22 <= numTowers) {
                    numSrps = 2;
                    numMoneyTowers = 22;
                    break switchLabel;
                }
                
                if (13 <= numTowers) {
                    numSrps = 8;
                    numMoneyTowers = 13;
                    break switchLabel;
                }
                
            }
            
            case 582 -> {
                
                if (22 <= numTowers) {
                    numSrps = 2;
                    numMoneyTowers = 22;
                    break switchLabel;
                }
                
                if (13 <= numTowers) {
                    numSrps = 8;
                    numMoneyTowers = 13;
                    break switchLabel;
                }
                
            }
            
            case 598 -> {
                
                if (23 <= numTowers) {
                    numSrps = 2;
                    numMoneyTowers = 23;
                    break switchLabel;
                }
                
            }
            
            case 608 -> {
                
                if (23 <= numTowers) {
                    numSrps = 2;
                    numMoneyTowers = 23;
                    break switchLabel;
                }
                
                if (19 <= numTowers) {
                    numSrps = 4;
                    numMoneyTowers = 19;
                    break switchLabel;
                }
                
                if (16 <= numTowers) {
                    numSrps = 6;
                    numMoneyTowers = 16;
                    break switchLabel;
                }
                
            }
            
            case 624 -> {
                
                if (24 <= numTowers) {
                    numSrps = 2;
                    numMoneyTowers = 24;
                    break switchLabel;
                }
                
            }
            
            case 634 -> {
                
                if (24 <= numTowers) {
                    numSrps = 2;
                    numMoneyTowers = 24;
                    break switchLabel;
                }
                
            }
            
            case 29 -> {
                
                if (1 <= numTowers) {
                    numSrps = 3;
                    numMoneyTowers = 1;
                    break switchLabel;
                }
                
            }
            
            case 39 -> {
                
                if (1 <= numTowers) {
                    numSrps = 3;
                    numMoneyTowers = 1;
                    break switchLabel;
                }
                
            }
            
            case 58 -> {
                
                if (2 <= numTowers) {
                    numSrps = 3;
                    numMoneyTowers = 2;
                    break switchLabel;
                }
                
            }
            
            case 68 -> {
                
                if (2 <= numTowers) {
                    numSrps = 3;
                    numMoneyTowers = 2;
                    break switchLabel;
                }
                
                if (1 <= numTowers) {
                    numSrps = 16;
                    numMoneyTowers = 1;
                    break switchLabel;
                }
                
            }
            
            case 87 -> {
                
                if (3 <= numTowers) {
                    numSrps = 3;
                    numMoneyTowers = 3;
                    break switchLabel;
                }
                
                if (1 <= numTowers) {
                    numSrps = 19;
                    numMoneyTowers = 1;
                    break switchLabel;
                }
                
            }
            
            case 97 -> {
                
                if (3 <= numTowers) {
                    numSrps = 3;
                    numMoneyTowers = 3;
                    break switchLabel;
                }
                
            }
            
            case 116 -> {
                
                if (4 <= numTowers) {
                    numSrps = 3;
                    numMoneyTowers = 4;
                    break switchLabel;
                }
                
                if (2 <= numTowers) {
                    numSrps = 11;
                    numMoneyTowers = 2;
                    break switchLabel;
                }
                
            }
            
            case 126 -> {
                
                if (4 <= numTowers) {
                    numSrps = 3;
                    numMoneyTowers = 4;
                    break switchLabel;
                }
                
            }
            
            case 145 -> {
                
                if (5 <= numTowers) {
                    numSrps = 3;
                    numMoneyTowers = 5;
                    break switchLabel;
                }
                
            }
            
            case 155 -> {
                
                if (5 <= numTowers) {
                    numSrps = 3;
                    numMoneyTowers = 5;
                    break switchLabel;
                }
                
            }
            
            case 174 -> {
                
                if (6 <= numTowers) {
                    numSrps = 3;
                    numMoneyTowers = 6;
                    break switchLabel;
                }
                
                if (4 <= numTowers) {
                    numSrps = 7;
                    numMoneyTowers = 4;
                    break switchLabel;
                }
                
            }
            
            case 203 -> {
                
                if (7 <= numTowers) {
                    numSrps = 3;
                    numMoneyTowers = 7;
                    break switchLabel;
                }
                
            }
            
            case 213 -> {
                
                if (7 <= numTowers) {
                    numSrps = 3;
                    numMoneyTowers = 7;
                    break switchLabel;
                }
                
                if (3 <= numTowers) {
                    numSrps = 17;
                    numMoneyTowers = 3;
                    break switchLabel;
                }
                
            }
            
            case 232 -> {
                
                if (8 <= numTowers) {
                    numSrps = 3;
                    numMoneyTowers = 8;
                    break switchLabel;
                }
                
                if (3 <= numTowers) {
                    numSrps = 18;
                    numMoneyTowers = 3;
                    break switchLabel;
                }
                
            }
            
            case 242 -> {
                
                if (8 <= numTowers) {
                    numSrps = 3;
                    numMoneyTowers = 8;
                    break switchLabel;
                }
                
            }
            
            case 261 -> {
                
                if (9 <= numTowers) {
                    numSrps = 3;
                    numMoneyTowers = 9;
                    break switchLabel;
                }
                
            }
            
            case 271 -> {
                
                if (9 <= numTowers) {
                    numSrps = 3;
                    numMoneyTowers = 9;
                    break switchLabel;
                }
                
            }
            
            case 319 -> {
                
                if (11 <= numTowers) {
                    numSrps = 3;
                    numMoneyTowers = 11;
                    break switchLabel;
                }
                
            }
            
            case 329 -> {
                
                if (11 <= numTowers) {
                    numSrps = 3;
                    numMoneyTowers = 11;
                    break switchLabel;
                }
                
                if (7 <= numTowers) {
                    numSrps = 9;
                    numMoneyTowers = 7;
                    break switchLabel;
                }
                
            }
            
            case 358 -> {
                
                if (12 <= numTowers) {
                    numSrps = 3;
                    numMoneyTowers = 12;
                    break switchLabel;
                }
                
            }
            
            case 377 -> {
                
                if (13 <= numTowers) {
                    numSrps = 3;
                    numMoneyTowers = 13;
                    break switchLabel;
                }
                
            }
            
            case 387 -> {
                
                if (13 <= numTowers) {
                    numSrps = 3;
                    numMoneyTowers = 13;
                    break switchLabel;
                }
                
            }
            
            case 406 -> {
                
                if (14 <= numTowers) {
                    numSrps = 3;
                    numMoneyTowers = 14;
                    break switchLabel;
                }
                
                if (9 <= numTowers) {
                    numSrps = 8;
                    numMoneyTowers = 9;
                    break switchLabel;
                }
                
            }
            
            case 435 -> {
                
                if (15 <= numTowers) {
                    numSrps = 3;
                    numMoneyTowers = 15;
                    break switchLabel;
                }
                
            }
            
            case 445 -> {
                
                if (15 <= numTowers) {
                    numSrps = 3;
                    numMoneyTowers = 15;
                    break switchLabel;
                }
                
                if (5 <= numTowers) {
                    numSrps = 23;
                    numMoneyTowers = 5;
                    break switchLabel;
                }
                
            }
            
            case 464 -> {
                
                if (16 <= numTowers) {
                    numSrps = 3;
                    numMoneyTowers = 16;
                    break switchLabel;
                }
                
            }
            
            case 474 -> {
                
                if (16 <= numTowers) {
                    numSrps = 3;
                    numMoneyTowers = 16;
                    break switchLabel;
                }
                
            }
            
            case 503 -> {
                
                if (17 <= numTowers) {
                    numSrps = 3;
                    numMoneyTowers = 17;
                    break switchLabel;
                }
                
            }
            
            case 522 -> {
                
                if (18 <= numTowers) {
                    numSrps = 3;
                    numMoneyTowers = 18;
                    break switchLabel;
                }
                
                if (16 <= numTowers) {
                    numSrps = 4;
                    numMoneyTowers = 16;
                    break switchLabel;
                }
                
            }
            
            case 532 -> {
                
                if (18 <= numTowers) {
                    numSrps = 3;
                    numMoneyTowers = 18;
                    break switchLabel;
                }
                
                if (14 <= numTowers) {
                    numSrps = 6;
                    numMoneyTowers = 14;
                    break switchLabel;
                }
                
            }
            
            case 551 -> {
                
                if (19 <= numTowers) {
                    numSrps = 3;
                    numMoneyTowers = 19;
                    break switchLabel;
                }
                
            }
            
            case 561 -> {
                
                if (19 <= numTowers) {
                    numSrps = 3;
                    numMoneyTowers = 19;
                    break switchLabel;
                }
                
            }
            
            case 580 -> {
                
                if (20 <= numTowers) {
                    numSrps = 3;
                    numMoneyTowers = 20;
                    break switchLabel;
                }
                
                if (15 <= numTowers) {
                    numSrps = 6;
                    numMoneyTowers = 15;
                    break switchLabel;
                }
                
            }
            
            case 590 -> {
                
                if (20 <= numTowers) {
                    numSrps = 3;
                    numMoneyTowers = 20;
                    break switchLabel;
                }
                
                if (10 <= numTowers) {
                    numSrps = 13;
                    numMoneyTowers = 10;
                    break switchLabel;
                }
                
            }
            
            case 609 -> {
                
                if (21 <= numTowers) {
                    numSrps = 3;
                    numMoneyTowers = 21;
                    break switchLabel;
                }
                
            }
            
            case 619 -> {
                
                if (21 <= numTowers) {
                    numSrps = 3;
                    numMoneyTowers = 21;
                    break switchLabel;
                }
                
            }
            
            case 638 -> {
                
                if (22 <= numTowers) {
                    numSrps = 3;
                    numMoneyTowers = 22;
                    break switchLabel;
                }
                
            }
            
            case 648 -> {
                
                if (22 <= numTowers) {
                    numSrps = 3;
                    numMoneyTowers = 22;
                    break switchLabel;
                }
                
            }
            
            case 667 -> {
                
                if (23 <= numTowers) {
                    numSrps = 3;
                    numMoneyTowers = 23;
                    break switchLabel;
                }
                
            }
            
            case 677 -> {
                
                if (23 <= numTowers) {
                    numSrps = 3;
                    numMoneyTowers = 23;
                    break switchLabel;
                }
                
            }
            
            case 696 -> {
                
                if (24 <= numTowers) {
                    numSrps = 3;
                    numMoneyTowers = 24;
                    break switchLabel;
                }
                
            }
            
            case 706 -> {
                
                if (24 <= numTowers) {
                    numSrps = 3;
                    numMoneyTowers = 24;
                    break switchLabel;
                }
                
            }
            
            case 32 -> {
                
                if (1 <= numTowers) {
                    numSrps = 4;
                    numMoneyTowers = 1;
                    break switchLabel;
                }
                
            }
            
            case 42 -> {
                
                if (1 <= numTowers) {
                    numSrps = 4;
                    numMoneyTowers = 1;
                    break switchLabel;
                }
                
            }
            
            case 64 -> {
                
                if (2 <= numTowers) {
                    numSrps = 4;
                    numMoneyTowers = 2;
                    break switchLabel;
                }
                
            }
            
            case 74 -> {
                
                if (2 <= numTowers) {
                    numSrps = 4;
                    numMoneyTowers = 2;
                    break switchLabel;
                }
                
                if (1 <= numTowers) {
                    numSrps = 18;
                    numMoneyTowers = 1;
                    break switchLabel;
                }
                
            }
            
            case 96 -> {
                
                if (3 <= numTowers) {
                    numSrps = 4;
                    numMoneyTowers = 3;
                    break switchLabel;
                }
                
                if (1 <= numTowers) {
                    numSrps = 22;
                    numMoneyTowers = 1;
                    break switchLabel;
                }
                
            }
            
            case 106 -> {
                
                if (3 <= numTowers) {
                    numSrps = 4;
                    numMoneyTowers = 3;
                    break switchLabel;
                }
                
                if (2 <= numTowers) {
                    numSrps = 11;
                    numMoneyTowers = 2;
                    break switchLabel;
                }
                
            }
            
            case 128 -> {
                
                if (4 <= numTowers) {
                    numSrps = 4;
                    numMoneyTowers = 4;
                    break switchLabel;
                }
                
                if (2 <= numTowers) {
                    numSrps = 13;
                    numMoneyTowers = 2;
                    break switchLabel;
                }
                
            }
            
            case 202 -> {
                
                if (6 <= numTowers) {
                    numSrps = 4;
                    numMoneyTowers = 6;
                    break switchLabel;
                }
                
            }
            
            case 224 -> {
                
                if (7 <= numTowers) {
                    numSrps = 4;
                    numMoneyTowers = 7;
                    break switchLabel;
                }
                
                if (4 <= numTowers) {
                    numSrps = 12;
                    numMoneyTowers = 4;
                    break switchLabel;
                }
                
            }
            
            case 256 -> {
                
                if (8 <= numTowers) {
                    numSrps = 4;
                    numMoneyTowers = 8;
                    break switchLabel;
                }
                
                if (6 <= numTowers) {
                    numSrps = 7;
                    numMoneyTowers = 6;
                    break switchLabel;
                }
                
            }
            
            case 266 -> {
                
                if (8 <= numTowers) {
                    numSrps = 4;
                    numMoneyTowers = 8;
                    break switchLabel;
                }
                
                if (7 <= numTowers) {
                    numSrps = 6;
                    numMoneyTowers = 7;
                    break switchLabel;
                }
                
            }
            
            case 288 -> {
                
                if (9 <= numTowers) {
                    numSrps = 4;
                    numMoneyTowers = 9;
                    break switchLabel;
                }
                
            }
            
            case 298 -> {
                
                if (9 <= numTowers) {
                    numSrps = 4;
                    numMoneyTowers = 9;
                    break switchLabel;
                }
                
            }
            
            case 352 -> {
                
                if (11 <= numTowers) {
                    numSrps = 4;
                    numMoneyTowers = 11;
                    break switchLabel;
                }
                
                if (9 <= numTowers) {
                    numSrps = 6;
                    numMoneyTowers = 9;
                    break switchLabel;
                }
                
                if (8 <= numTowers) {
                    numSrps = 8;
                    numMoneyTowers = 8;
                    break switchLabel;
                }
                
            }
            
            case 362 -> {
                
                if (11 <= numTowers) {
                    numSrps = 4;
                    numMoneyTowers = 11;
                    break switchLabel;
                }
                
                if (8 <= numTowers) {
                    numSrps = 8;
                    numMoneyTowers = 8;
                    break switchLabel;
                }
                
            }
            
            case 384 -> {
                
                if (12 <= numTowers) {
                    numSrps = 4;
                    numMoneyTowers = 12;
                    break switchLabel;
                }
                
            }
            
            case 394 -> {
                
                if (12 <= numTowers) {
                    numSrps = 4;
                    numMoneyTowers = 12;
                    break switchLabel;
                }
                
            }
            
            case 448 -> {
                
                if (14 <= numTowers) {
                    numSrps = 4;
                    numMoneyTowers = 14;
                    break switchLabel;
                }
                
                if (8 <= numTowers) {
                    numSrps = 12;
                    numMoneyTowers = 8;
                    break switchLabel;
                }
                
            }
            
            case 458 -> {
                
                if (14 <= numTowers) {
                    numSrps = 4;
                    numMoneyTowers = 14;
                    break switchLabel;
                }
                
                if (8 <= numTowers) {
                    numSrps = 12;
                    numMoneyTowers = 8;
                    break switchLabel;
                }
                
            }
            
            case 512 -> {
                
                if (16 <= numTowers) {
                    numSrps = 4;
                    numMoneyTowers = 16;
                    break switchLabel;
                }
                
            }
            
            case 544 -> {
                
                if (17 <= numTowers) {
                    numSrps = 4;
                    numMoneyTowers = 17;
                    break switchLabel;
                }
                
                if (8 <= numTowers) {
                    numSrps = 16;
                    numMoneyTowers = 8;
                    break switchLabel;
                }
                
                if (6 <= numTowers) {
                    numSrps = 23;
                    numMoneyTowers = 6;
                    break switchLabel;
                }
                
            }
            
            case 554 -> {
                
                if (17 <= numTowers) {
                    numSrps = 4;
                    numMoneyTowers = 17;
                    break switchLabel;
                }
                
                if (8 <= numTowers) {
                    numSrps = 16;
                    numMoneyTowers = 8;
                    break switchLabel;
                }
                
            }
            
            case 576 -> {
                
                if (18 <= numTowers) {
                    numSrps = 4;
                    numMoneyTowers = 18;
                    break switchLabel;
                }
                
            }
            
            case 586 -> {
                
                if (18 <= numTowers) {
                    numSrps = 4;
                    numMoneyTowers = 18;
                    break switchLabel;
                }
                
            }
            
            case 618 -> {
                
                if (19 <= numTowers) {
                    numSrps = 4;
                    numMoneyTowers = 19;
                    break switchLabel;
                }
                
                if (16 <= numTowers) {
                    numSrps = 6;
                    numMoneyTowers = 16;
                    break switchLabel;
                }
                
            }
            
            case 640 -> {
                
                if (20 <= numTowers) {
                    numSrps = 4;
                    numMoneyTowers = 20;
                    break switchLabel;
                }
                
                if (18 <= numTowers) {
                    numSrps = 5;
                    numMoneyTowers = 18;
                    break switchLabel;
                }
                
                if (8 <= numTowers) {
                    numSrps = 20;
                    numMoneyTowers = 8;
                    break switchLabel;
                }
                
            }
            
            case 650 -> {
                
                if (20 <= numTowers) {
                    numSrps = 4;
                    numMoneyTowers = 20;
                    break switchLabel;
                }
                
                if (13 <= numTowers) {
                    numSrps = 10;
                    numMoneyTowers = 13;
                    break switchLabel;
                }
                
                if (10 <= numTowers) {
                    numSrps = 15;
                    numMoneyTowers = 10;
                    break switchLabel;
                }
                
                if (8 <= numTowers) {
                    numSrps = 20;
                    numMoneyTowers = 8;
                    break switchLabel;
                }
                
            }
            
            case 672 -> {
                
                if (21 <= numTowers) {
                    numSrps = 4;
                    numMoneyTowers = 21;
                    break switchLabel;
                }
                
                if (12 <= numTowers) {
                    numSrps = 12;
                    numMoneyTowers = 12;
                    break switchLabel;
                }
                
            }
            
            case 682 -> {
                
                if (21 <= numTowers) {
                    numSrps = 4;
                    numMoneyTowers = 21;
                    break switchLabel;
                }
                
                if (12 <= numTowers) {
                    numSrps = 12;
                    numMoneyTowers = 12;
                    break switchLabel;
                }
                
                if (11 <= numTowers) {
                    numSrps = 14;
                    numMoneyTowers = 11;
                    break switchLabel;
                }
                
            }
            
            case 704 -> {
                
                if (22 <= numTowers) {
                    numSrps = 4;
                    numMoneyTowers = 22;
                    break switchLabel;
                }
                
                if (16 <= numTowers) {
                    numSrps = 8;
                    numMoneyTowers = 16;
                    break switchLabel;
                }
                
            }
            
            case 714 -> {
                
                if (22 <= numTowers) {
                    numSrps = 4;
                    numMoneyTowers = 22;
                    break switchLabel;
                }
                
                if (16 <= numTowers) {
                    numSrps = 8;
                    numMoneyTowers = 16;
                    break switchLabel;
                }
                
            }
            
            case 736 -> {
                
                if (23 <= numTowers) {
                    numSrps = 4;
                    numMoneyTowers = 23;
                    break switchLabel;
                }
                
                if (8 <= numTowers) {
                    numSrps = 24;
                    numMoneyTowers = 8;
                    break switchLabel;
                }
                
            }
            
            case 746 -> {
                
                if (23 <= numTowers) {
                    numSrps = 4;
                    numMoneyTowers = 23;
                    break switchLabel;
                }
                
                if (8 <= numTowers) {
                    numSrps = 24;
                    numMoneyTowers = 8;
                    break switchLabel;
                }
                
            }
            
            case 768 -> {
                
                if (24 <= numTowers) {
                    numSrps = 4;
                    numMoneyTowers = 24;
                    break switchLabel;
                }
                
            }
            
            case 778 -> {
                
                if (24 <= numTowers) {
                    numSrps = 4;
                    numMoneyTowers = 24;
                    break switchLabel;
                }
                
            }
            
            case 35 -> {
                
                if (1 <= numTowers) {
                    numSrps = 5;
                    numMoneyTowers = 1;
                    break switchLabel;
                }
                
            }
            
            case 45 -> {
                
                if (1 <= numTowers) {
                    numSrps = 5;
                    numMoneyTowers = 1;
                    break switchLabel;
                }
                
            }
            
            case 105 -> {
                
                if (3 <= numTowers) {
                    numSrps = 5;
                    numMoneyTowers = 3;
                    break switchLabel;
                }
                
            }
            
            case 175 -> {
                
                if (5 <= numTowers) {
                    numSrps = 5;
                    numMoneyTowers = 5;
                    break switchLabel;
                }
                
            }
            
            case 185 -> {
                
                if (5 <= numTowers) {
                    numSrps = 5;
                    numMoneyTowers = 5;
                    break switchLabel;
                }
                
            }
            
            case 245 -> {
                
                if (7 <= numTowers) {
                    numSrps = 5;
                    numMoneyTowers = 7;
                    break switchLabel;
                }
                
                if (5 <= numTowers) {
                    numSrps = 9;
                    numMoneyTowers = 5;
                    break switchLabel;
                }
                
            }
            
            case 255 -> {
                
                if (7 <= numTowers) {
                    numSrps = 5;
                    numMoneyTowers = 7;
                    break switchLabel;
                }
                
            }
            
            case 315 -> {
                
                if (9 <= numTowers) {
                    numSrps = 5;
                    numMoneyTowers = 9;
                    break switchLabel;
                }
                
            }
            
            case 325 -> {
                
                if (9 <= numTowers) {
                    numSrps = 5;
                    numMoneyTowers = 9;
                    break switchLabel;
                }
                
                if (5 <= numTowers) {
                    numSrps = 15;
                    numMoneyTowers = 5;
                    break switchLabel;
                }
                
            }
            
            case 385 -> {
                
                if (11 <= numTowers) {
                    numSrps = 5;
                    numMoneyTowers = 11;
                    break switchLabel;
                }
                
                if (5 <= numTowers) {
                    numSrps = 19;
                    numMoneyTowers = 5;
                    break switchLabel;
                }
                
            }
            
            case 395 -> {
                
                if (11 <= numTowers) {
                    numSrps = 5;
                    numMoneyTowers = 11;
                    break switchLabel;
                }
                
                if (5 <= numTowers) {
                    numSrps = 19;
                    numMoneyTowers = 5;
                    break switchLabel;
                }
                
            }
            
            case 455 -> {
                
                if (13 <= numTowers) {
                    numSrps = 5;
                    numMoneyTowers = 13;
                    break switchLabel;
                }
                
                if (7 <= numTowers) {
                    numSrps = 15;
                    numMoneyTowers = 7;
                    break switchLabel;
                }
                
                if (5 <= numTowers) {
                    numSrps = 23;
                    numMoneyTowers = 5;
                    break switchLabel;
                }
                
            }
            
            case 465 -> {
                
                if (13 <= numTowers) {
                    numSrps = 5;
                    numMoneyTowers = 13;
                    break switchLabel;
                }
                
                if (7 <= numTowers) {
                    numSrps = 15;
                    numMoneyTowers = 7;
                    break switchLabel;
                }
                
            }
            
            case 500 -> {
                
                if (14 <= numTowers) {
                    numSrps = 5;
                    numMoneyTowers = 14;
                    break switchLabel;
                }
                
                if (10 <= numTowers) {
                    numSrps = 10;
                    numMoneyTowers = 10;
                    break switchLabel;
                }
                
            }
            
            case 525 -> {
                
                if (15 <= numTowers) {
                    numSrps = 5;
                    numMoneyTowers = 15;
                    break switchLabel;
                }
                
            }
            
            case 535 -> {
                
                if (15 <= numTowers) {
                    numSrps = 5;
                    numMoneyTowers = 15;
                    break switchLabel;
                }
                
            }
            
            case 560 -> {
                
                if (16 <= numTowers) {
                    numSrps = 5;
                    numMoneyTowers = 16;
                    break switchLabel;
                }
                
                if (11 <= numTowers) {
                    numSrps = 10;
                    numMoneyTowers = 11;
                    break switchLabel;
                }
                
                if (10 <= numTowers) {
                    numSrps = 12;
                    numMoneyTowers = 10;
                    break switchLabel;
                }
                
                if (7 <= numTowers) {
                    numSrps = 20;
                    numMoneyTowers = 7;
                    break switchLabel;
                }
                
            }
            
            case 570 -> {
                
                if (16 <= numTowers) {
                    numSrps = 5;
                    numMoneyTowers = 16;
                    break switchLabel;
                }
                
                if (15 <= numTowers) {
                    numSrps = 6;
                    numMoneyTowers = 15;
                    break switchLabel;
                }
                
                if (10 <= numTowers) {
                    numSrps = 12;
                    numMoneyTowers = 10;
                    break switchLabel;
                }
                
                if (7 <= numTowers) {
                    numSrps = 20;
                    numMoneyTowers = 7;
                    break switchLabel;
                }
                
            }
            
            case 595 -> {
                
                if (17 <= numTowers) {
                    numSrps = 5;
                    numMoneyTowers = 17;
                    break switchLabel;
                }
                
                if (9 <= numTowers) {
                    numSrps = 15;
                    numMoneyTowers = 9;
                    break switchLabel;
                }
                
            }
            
            case 605 -> {
                
                if (17 <= numTowers) {
                    numSrps = 5;
                    numMoneyTowers = 17;
                    break switchLabel;
                }
                
            }
            
            case 630 -> {
                
                if (18 <= numTowers) {
                    numSrps = 5;
                    numMoneyTowers = 18;
                    break switchLabel;
                }
                
                if (10 <= numTowers) {
                    numSrps = 14;
                    numMoneyTowers = 10;
                    break switchLabel;
                }
                
            }
            
            case 665 -> {
                
                if (19 <= numTowers) {
                    numSrps = 5;
                    numMoneyTowers = 19;
                    break switchLabel;
                }
                
            }
            
            case 675 -> {
                
                if (19 <= numTowers) {
                    numSrps = 5;
                    numMoneyTowers = 19;
                    break switchLabel;
                }
                
            }
            
            case 700 -> {
                
                if (20 <= numTowers) {
                    numSrps = 5;
                    numMoneyTowers = 20;
                    break switchLabel;
                }
                
                if (14 <= numTowers) {
                    numSrps = 10;
                    numMoneyTowers = 14;
                    break switchLabel;
                }
                
            }
            
            case 710 -> {
                
                if (20 <= numTowers) {
                    numSrps = 5;
                    numMoneyTowers = 20;
                    break switchLabel;
                }
                
                if (14 <= numTowers) {
                    numSrps = 10;
                    numMoneyTowers = 14;
                    break switchLabel;
                }
                
                if (10 <= numTowers) {
                    numSrps = 17;
                    numMoneyTowers = 10;
                    break switchLabel;
                }
                
            }
            
            case 735 -> {
                
                if (21 <= numTowers) {
                    numSrps = 5;
                    numMoneyTowers = 21;
                    break switchLabel;
                }
                
            }
            
            case 745 -> {
                
                if (21 <= numTowers) {
                    numSrps = 5;
                    numMoneyTowers = 21;
                    break switchLabel;
                }
                
            }
            
            case 770 -> {
                
                if (22 <= numTowers) {
                    numSrps = 5;
                    numMoneyTowers = 22;
                    break switchLabel;
                }
                
                if (20 <= numTowers) {
                    numSrps = 6;
                    numMoneyTowers = 20;
                    break switchLabel;
                }
                
                if (10 <= numTowers) {
                    numSrps = 19;
                    numMoneyTowers = 10;
                    break switchLabel;
                }
                
            }
            
            case 780 -> {
                
                if (22 <= numTowers) {
                    numSrps = 5;
                    numMoneyTowers = 22;
                    break switchLabel;
                }
                
                if (12 <= numTowers) {
                    numSrps = 15;
                    numMoneyTowers = 12;
                    break switchLabel;
                }
                
                if (10 <= numTowers) {
                    numSrps = 19;
                    numMoneyTowers = 10;
                    break switchLabel;
                }
                
            }
            
            case 805 -> {
                
                if (23 <= numTowers) {
                    numSrps = 5;
                    numMoneyTowers = 23;
                    break switchLabel;
                }
                
                if (15 <= numTowers) {
                    numSrps = 11;
                    numMoneyTowers = 15;
                    break switchLabel;
                }
                
            }
            
            case 815 -> {
                
                if (23 <= numTowers) {
                    numSrps = 5;
                    numMoneyTowers = 23;
                    break switchLabel;
                }
                
            }
            
            case 840 -> {
                
                if (24 <= numTowers) {
                    numSrps = 5;
                    numMoneyTowers = 24;
                    break switchLabel;
                }
                
                if (15 <= numTowers) {
                    numSrps = 12;
                    numMoneyTowers = 15;
                    break switchLabel;
                }
                
                if (10 <= numTowers) {
                    numSrps = 21;
                    numMoneyTowers = 10;
                    break switchLabel;
                }
                
            }
            
            case 850 -> {
                
                if (24 <= numTowers) {
                    numSrps = 5;
                    numMoneyTowers = 24;
                    break switchLabel;
                }
                
                if (17 <= numTowers) {
                    numSrps = 10;
                    numMoneyTowers = 17;
                    break switchLabel;
                }
                
                if (15 <= numTowers) {
                    numSrps = 12;
                    numMoneyTowers = 15;
                    break switchLabel;
                }
                
            }
            
            case 38 -> {
                
                if (1 <= numTowers) {
                    numSrps = 6;
                    numMoneyTowers = 1;
                    break switchLabel;
                }
                
            }
            
            case 48 -> {
                
                if (1 <= numTowers) {
                    numSrps = 6;
                    numMoneyTowers = 1;
                    break switchLabel;
                }
                
            }
            
            case 76 -> {
                
                if (2 <= numTowers) {
                    numSrps = 6;
                    numMoneyTowers = 2;
                    break switchLabel;
                }
                
            }
            
            case 86 -> {
                
                if (2 <= numTowers) {
                    numSrps = 6;
                    numMoneyTowers = 2;
                    break switchLabel;
                }
                
                if (1 <= numTowers) {
                    numSrps = 22;
                    numMoneyTowers = 1;
                    break switchLabel;
                }
                
            }
            
            case 124 -> {
                
                if (3 <= numTowers) {
                    numSrps = 6;
                    numMoneyTowers = 3;
                    break switchLabel;
                }
                
                if (2 <= numTowers) {
                    numSrps = 14;
                    numMoneyTowers = 2;
                    break switchLabel;
                }
                
            }
            
            case 152 -> {
                
                if (4 <= numTowers) {
                    numSrps = 6;
                    numMoneyTowers = 4;
                    break switchLabel;
                }
                
                if (2 <= numTowers) {
                    numSrps = 17;
                    numMoneyTowers = 2;
                    break switchLabel;
                }
                
            }
            
            case 162 -> {
                
                if (4 <= numTowers) {
                    numSrps = 6;
                    numMoneyTowers = 4;
                    break switchLabel;
                }
                
            }
            
            case 228 -> {
                
                if (6 <= numTowers) {
                    numSrps = 6;
                    numMoneyTowers = 6;
                    break switchLabel;
                }
                
            }
            
            case 238 -> {
                
                if (6 <= numTowers) {
                    numSrps = 6;
                    numMoneyTowers = 6;
                    break switchLabel;
                }
                
            }
            
            case 304 -> {
                
                if (8 <= numTowers) {
                    numSrps = 6;
                    numMoneyTowers = 8;
                    break switchLabel;
                }
                
            }
            
            case 314 -> {
                
                if (8 <= numTowers) {
                    numSrps = 6;
                    numMoneyTowers = 8;
                    break switchLabel;
                }
                
            }
            
            case 342 -> {
                
                if (9 <= numTowers) {
                    numSrps = 6;
                    numMoneyTowers = 9;
                    break switchLabel;
                }
                
                if (4 <= numTowers) {
                    numSrps = 21;
                    numMoneyTowers = 4;
                    break switchLabel;
                }
                
            }
            
            case 418 -> {
                
                if (11 <= numTowers) {
                    numSrps = 6;
                    numMoneyTowers = 11;
                    break switchLabel;
                }
                
                if (6 <= numTowers) {
                    numSrps = 16;
                    numMoneyTowers = 6;
                    break switchLabel;
                }
                
            }
            
            case 428 -> {
                
                if (11 <= numTowers) {
                    numSrps = 6;
                    numMoneyTowers = 11;
                    break switchLabel;
                }
                
            }
            
            case 456 -> {
                
                if (12 <= numTowers) {
                    numSrps = 6;
                    numMoneyTowers = 12;
                    break switchLabel;
                }
                
            }
            
            case 466 -> {
                
                if (12 <= numTowers) {
                    numSrps = 6;
                    numMoneyTowers = 12;
                    break switchLabel;
                }
                
            }
            
            case 542 -> {
                
                if (14 <= numTowers) {
                    numSrps = 6;
                    numMoneyTowers = 14;
                    break switchLabel;
                }
                
            }
            
            case 646 -> {
                
                if (17 <= numTowers) {
                    numSrps = 6;
                    numMoneyTowers = 17;
                    break switchLabel;
                }
                
                if (12 <= numTowers) {
                    numSrps = 11;
                    numMoneyTowers = 12;
                    break switchLabel;
                }
                
            }
            
            case 656 -> {
                
                if (17 <= numTowers) {
                    numSrps = 6;
                    numMoneyTowers = 17;
                    break switchLabel;
                }
                
                if (16 <= numTowers) {
                    numSrps = 7;
                    numMoneyTowers = 16;
                    break switchLabel;
                }
                
            }
            
            case 684 -> {
                
                if (18 <= numTowers) {
                    numSrps = 6;
                    numMoneyTowers = 18;
                    break switchLabel;
                }
                
            }
            
            case 694 -> {
                
                if (18 <= numTowers) {
                    numSrps = 6;
                    numMoneyTowers = 18;
                    break switchLabel;
                }
                
            }
            
            case 722 -> {
                
                if (19 <= numTowers) {
                    numSrps = 6;
                    numMoneyTowers = 19;
                    break switchLabel;
                }
                
                if (8 <= numTowers) {
                    numSrps = 23;
                    numMoneyTowers = 8;
                    break switchLabel;
                }
                
            }
            
            case 732 -> {
                
                if (19 <= numTowers) {
                    numSrps = 6;
                    numMoneyTowers = 19;
                    break switchLabel;
                }
                
            }
            
            case 760 -> {
                
                if (20 <= numTowers) {
                    numSrps = 6;
                    numMoneyTowers = 20;
                    break switchLabel;
                }
                
                if (15 <= numTowers) {
                    numSrps = 10;
                    numMoneyTowers = 15;
                    break switchLabel;
                }
                
            }
            
            case 798 -> {
                
                if (21 <= numTowers) {
                    numSrps = 6;
                    numMoneyTowers = 21;
                    break switchLabel;
                }
                
            }
            
            case 808 -> {
                
                if (21 <= numTowers) {
                    numSrps = 6;
                    numMoneyTowers = 21;
                    break switchLabel;
                }
                
            }
            
            case 836 -> {
                
                if (22 <= numTowers) {
                    numSrps = 6;
                    numMoneyTowers = 22;
                    break switchLabel;
                }
                
                if (19 <= numTowers) {
                    numSrps = 8;
                    numMoneyTowers = 19;
                    break switchLabel;
                }
                
                if (14 <= numTowers) {
                    numSrps = 13;
                    numMoneyTowers = 14;
                    break switchLabel;
                }
                
            }
            
            case 846 -> {
                
                if (22 <= numTowers) {
                    numSrps = 6;
                    numMoneyTowers = 22;
                    break switchLabel;
                }
                
                if (19 <= numTowers) {
                    numSrps = 8;
                    numMoneyTowers = 19;
                    break switchLabel;
                }
                
                if (18 <= numTowers) {
                    numSrps = 9;
                    numMoneyTowers = 18;
                    break switchLabel;
                }
                
            }
            
            case 874 -> {
                
                if (23 <= numTowers) {
                    numSrps = 6;
                    numMoneyTowers = 23;
                    break switchLabel;
                }
                
            }
            
            case 884 -> {
                
                if (23 <= numTowers) {
                    numSrps = 6;
                    numMoneyTowers = 23;
                    break switchLabel;
                }
                
                if (13 <= numTowers) {
                    numSrps = 16;
                    numMoneyTowers = 13;
                    break switchLabel;
                }
                
            }
            
            case 912 -> {
                
                if (24 <= numTowers) {
                    numSrps = 6;
                    numMoneyTowers = 24;
                    break switchLabel;
                }
                
                if (22 <= numTowers) {
                    numSrps = 7;
                    numMoneyTowers = 22;
                    break switchLabel;
                }
                
            }
            
            case 922 -> {
                
                if (24 <= numTowers) {
                    numSrps = 6;
                    numMoneyTowers = 24;
                    break switchLabel;
                }
                
            }
            
            case 41 -> {
                
                if (1 <= numTowers) {
                    numSrps = 7;
                    numMoneyTowers = 1;
                    break switchLabel;
                }
                
            }
            
            case 51 -> {
                
                if (1 <= numTowers) {
                    numSrps = 7;
                    numMoneyTowers = 1;
                    break switchLabel;
                }
                
            }
            
            case 82 -> {
                
                if (2 <= numTowers) {
                    numSrps = 7;
                    numMoneyTowers = 2;
                    break switchLabel;
                }
                
            }
            
            case 123 -> {
                
                if (3 <= numTowers) {
                    numSrps = 7;
                    numMoneyTowers = 3;
                    break switchLabel;
                }
                
            }
            
            case 133 -> {
                
                if (3 <= numTowers) {
                    numSrps = 7;
                    numMoneyTowers = 3;
                    break switchLabel;
                }
                
            }
            
            case 164 -> {
                
                if (4 <= numTowers) {
                    numSrps = 7;
                    numMoneyTowers = 4;
                    break switchLabel;
                }
                
                if (2 <= numTowers) {
                    numSrps = 19;
                    numMoneyTowers = 2;
                    break switchLabel;
                }
                
            }
            
            case 205 -> {
                
                if (5 <= numTowers) {
                    numSrps = 7;
                    numMoneyTowers = 5;
                    break switchLabel;
                }
                
                if (3 <= numTowers) {
                    numSrps = 15;
                    numMoneyTowers = 3;
                    break switchLabel;
                }
                
            }
            
            case 215 -> {
                
                if (5 <= numTowers) {
                    numSrps = 7;
                    numMoneyTowers = 5;
                    break switchLabel;
                }
                
            }
            
            case 246 -> {
                
                if (6 <= numTowers) {
                    numSrps = 7;
                    numMoneyTowers = 6;
                    break switchLabel;
                }
                
                if (4 <= numTowers) {
                    numSrps = 13;
                    numMoneyTowers = 4;
                    break switchLabel;
                }
                
            }
            
            case 287 -> {
                
                if (7 <= numTowers) {
                    numSrps = 7;
                    numMoneyTowers = 7;
                    break switchLabel;
                }
                
            }
            
            case 297 -> {
                
                if (7 <= numTowers) {
                    numSrps = 7;
                    numMoneyTowers = 7;
                    break switchLabel;
                }
                
            }
            
            case 328 -> {
                
                if (8 <= numTowers) {
                    numSrps = 7;
                    numMoneyTowers = 8;
                    break switchLabel;
                }
                
                if (6 <= numTowers) {
                    numSrps = 11;
                    numMoneyTowers = 6;
                    break switchLabel;
                }
                
            }
            
            case 369 -> {
                
                if (9 <= numTowers) {
                    numSrps = 7;
                    numMoneyTowers = 9;
                    break switchLabel;
                }
                
            }
            
            case 379 -> {
                
                if (9 <= numTowers) {
                    numSrps = 7;
                    numMoneyTowers = 9;
                    break switchLabel;
                }
                
            }
            
            case 451 -> {
                
                if (11 <= numTowers) {
                    numSrps = 7;
                    numMoneyTowers = 11;
                    break switchLabel;
                }
                
            }
            
            case 461 -> {
                
                if (11 <= numTowers) {
                    numSrps = 7;
                    numMoneyTowers = 11;
                    break switchLabel;
                }
                
            }
            
            case 492 -> {
                
                if (12 <= numTowers) {
                    numSrps = 7;
                    numMoneyTowers = 12;
                    break switchLabel;
                }
                
            }
            
            case 502 -> {
                
                if (12 <= numTowers) {
                    numSrps = 7;
                    numMoneyTowers = 12;
                    break switchLabel;
                }
                
            }
            
            case 533 -> {
                
                if (13 <= numTowers) {
                    numSrps = 7;
                    numMoneyTowers = 13;
                    break switchLabel;
                }
                
            }
            
            case 543 -> {
                
                if (13 <= numTowers) {
                    numSrps = 7;
                    numMoneyTowers = 13;
                    break switchLabel;
                }
                
            }
            
            case 574 -> {
                
                if (14 <= numTowers) {
                    numSrps = 7;
                    numMoneyTowers = 14;
                    break switchLabel;
                }
                
                if (12 <= numTowers) {
                    numSrps = 9;
                    numMoneyTowers = 12;
                    break switchLabel;
                }
                
            }
            
            case 584 -> {
                
                if (14 <= numTowers) {
                    numSrps = 7;
                    numMoneyTowers = 14;
                    break switchLabel;
                }
                
            }
            
            case 615 -> {
                
                if (15 <= numTowers) {
                    numSrps = 7;
                    numMoneyTowers = 15;
                    break switchLabel;
                }
                
            }
            
            case 625 -> {
                
                if (15 <= numTowers) {
                    numSrps = 7;
                    numMoneyTowers = 15;
                    break switchLabel;
                }
                
            }
            
            case 666 -> {
                
                if (16 <= numTowers) {
                    numSrps = 7;
                    numMoneyTowers = 16;
                    break switchLabel;
                }
                
                if (9 <= numTowers) {
                    numSrps = 18;
                    numMoneyTowers = 9;
                    break switchLabel;
                }
                
            }
            
            case 697 -> {
                
                if (17 <= numTowers) {
                    numSrps = 7;
                    numMoneyTowers = 17;
                    break switchLabel;
                }
                
            }
            
            case 707 -> {
                
                if (17 <= numTowers) {
                    numSrps = 7;
                    numMoneyTowers = 17;
                    break switchLabel;
                }
                
            }
            
            case 738 -> {
                
                if (18 <= numTowers) {
                    numSrps = 7;
                    numMoneyTowers = 18;
                    break switchLabel;
                }
                
                if (13 <= numTowers) {
                    numSrps = 12;
                    numMoneyTowers = 13;
                    break switchLabel;
                }
                
            }
            
            case 748 -> {
                
                if (18 <= numTowers) {
                    numSrps = 7;
                    numMoneyTowers = 18;
                    break switchLabel;
                }
                
                if (17 <= numTowers) {
                    numSrps = 8;
                    numMoneyTowers = 17;
                    break switchLabel;
                }
                
                if (11 <= numTowers) {
                    numSrps = 16;
                    numMoneyTowers = 11;
                    break switchLabel;
                }
                
            }
            
            case 779 -> {
                
                if (19 <= numTowers) {
                    numSrps = 7;
                    numMoneyTowers = 19;
                    break switchLabel;
                }
                
            }
            
            case 789 -> {
                
                if (19 <= numTowers) {
                    numSrps = 7;
                    numMoneyTowers = 19;
                    break switchLabel;
                }
                
            }
            
            case 820 -> {
                
                if (20 <= numTowers) {
                    numSrps = 7;
                    numMoneyTowers = 20;
                    break switchLabel;
                }
                
            }
            
            case 830 -> {
                
                if (20 <= numTowers) {
                    numSrps = 7;
                    numMoneyTowers = 20;
                    break switchLabel;
                }
                
                if (10 <= numTowers) {
                    numSrps = 21;
                    numMoneyTowers = 10;
                    break switchLabel;
                }
                
            }
            
            case 861 -> {
                
                if (21 <= numTowers) {
                    numSrps = 7;
                    numMoneyTowers = 21;
                    break switchLabel;
                }
                
            }
            
            case 871 -> {
                
                if (21 <= numTowers) {
                    numSrps = 7;
                    numMoneyTowers = 21;
                    break switchLabel;
                }
                
            }
            
            case 902 -> {
                
                if (22 <= numTowers) {
                    numSrps = 7;
                    numMoneyTowers = 22;
                    break switchLabel;
                }
                
            }
            
            case 943 -> {
                
                if (23 <= numTowers) {
                    numSrps = 7;
                    numMoneyTowers = 23;
                    break switchLabel;
                }
                
            }
            
            case 953 -> {
                
                if (23 <= numTowers) {
                    numSrps = 7;
                    numMoneyTowers = 23;
                    break switchLabel;
                }
                
            }
            
            case 984 -> {
                
                if (24 <= numTowers) {
                    numSrps = 7;
                    numMoneyTowers = 24;
                    break switchLabel;
                }
                
            }
            
            case 994 -> {
                
                if (24 <= numTowers) {
                    numSrps = 7;
                    numMoneyTowers = 24;
                    break switchLabel;
                }
                
                if (14 <= numTowers) {
                    numSrps = 17;
                    numMoneyTowers = 14;
                    break switchLabel;
                }
                
            }
            
            case 44 -> {
                
                if (1 <= numTowers) {
                    numSrps = 8;
                    numMoneyTowers = 1;
                    break switchLabel;
                }
                
            }
            
            case 54 -> {
                
                if (1 <= numTowers) {
                    numSrps = 8;
                    numMoneyTowers = 1;
                    break switchLabel;
                }
                
            }
            
            case 98 -> {
                
                if (2 <= numTowers) {
                    numSrps = 8;
                    numMoneyTowers = 2;
                    break switchLabel;
                }
                
            }
            
            case 132 -> {
                
                if (3 <= numTowers) {
                    numSrps = 8;
                    numMoneyTowers = 3;
                    break switchLabel;
                }
                
            }
            
            case 142 -> {
                
                if (3 <= numTowers) {
                    numSrps = 8;
                    numMoneyTowers = 3;
                    break switchLabel;
                }
                
                if (2 <= numTowers) {
                    numSrps = 17;
                    numMoneyTowers = 2;
                    break switchLabel;
                }
                
            }
            
            case 176 -> {
                
                if (4 <= numTowers) {
                    numSrps = 8;
                    numMoneyTowers = 4;
                    break switchLabel;
                }
                
                if (2 <= numTowers) {
                    numSrps = 21;
                    numMoneyTowers = 2;
                    break switchLabel;
                }
                
            }
            
            case 186 -> {
                
                if (4 <= numTowers) {
                    numSrps = 8;
                    numMoneyTowers = 4;
                    break switchLabel;
                }
                
                if (3 <= numTowers) {
                    numSrps = 14;
                    numMoneyTowers = 3;
                    break switchLabel;
                }
                
            }
            
            case 264 -> {
                
                if (6 <= numTowers) {
                    numSrps = 8;
                    numMoneyTowers = 6;
                    break switchLabel;
                }
                
            }
            
            case 274 -> {
                
                if (6 <= numTowers) {
                    numSrps = 8;
                    numMoneyTowers = 6;
                    break switchLabel;
                }
                
            }
            
            case 308 -> {
                
                if (7 <= numTowers) {
                    numSrps = 8;
                    numMoneyTowers = 7;
                    break switchLabel;
                }
                
                if (4 <= numTowers) {
                    numSrps = 19;
                    numMoneyTowers = 4;
                    break switchLabel;
                }
                
            }
            
            case 318 -> {
                
                if (7 <= numTowers) {
                    numSrps = 8;
                    numMoneyTowers = 7;
                    break switchLabel;
                }
                
                if (6 <= numTowers) {
                    numSrps = 11;
                    numMoneyTowers = 6;
                    break switchLabel;
                }
                
                if (4 <= numTowers) {
                    numSrps = 19;
                    numMoneyTowers = 4;
                    break switchLabel;
                }
                
            }
            
            case 396 -> {
                
                if (9 <= numTowers) {
                    numSrps = 8;
                    numMoneyTowers = 9;
                    break switchLabel;
                }
                
            }
            
            case 484 -> {
                
                if (11 <= numTowers) {
                    numSrps = 8;
                    numMoneyTowers = 11;
                    break switchLabel;
                }
                
            }
            
            case 528 -> {
                
                if (12 <= numTowers) {
                    numSrps = 8;
                    numMoneyTowers = 12;
                    break switchLabel;
                }
                
                if (7 <= numTowers) {
                    numSrps = 18;
                    numMoneyTowers = 7;
                    break switchLabel;
                }
                
            }
            
            case 538 -> {
                
                if (12 <= numTowers) {
                    numSrps = 8;
                    numMoneyTowers = 12;
                    break switchLabel;
                }
                
            }
            
            case 616 -> {
                
                if (14 <= numTowers) {
                    numSrps = 8;
                    numMoneyTowers = 14;
                    break switchLabel;
                }
                
                if (11 <= numTowers) {
                    numSrps = 12;
                    numMoneyTowers = 11;
                    break switchLabel;
                }
                
                if (8 <= numTowers) {
                    numSrps = 19;
                    numMoneyTowers = 8;
                    break switchLabel;
                }
                
            }
            
            case 626 -> {
                
                if (14 <= numTowers) {
                    numSrps = 8;
                    numMoneyTowers = 14;
                    break switchLabel;
                }
                
                if (11 <= numTowers) {
                    numSrps = 12;
                    numMoneyTowers = 11;
                    break switchLabel;
                }
                
                if (8 <= numTowers) {
                    numSrps = 19;
                    numMoneyTowers = 8;
                    break switchLabel;
                }
                
            }
            
            case 660 -> {
                
                if (15 <= numTowers) {
                    numSrps = 8;
                    numMoneyTowers = 15;
                    break switchLabel;
                }
                
                if (13 <= numTowers) {
                    numSrps = 10;
                    numMoneyTowers = 13;
                    break switchLabel;
                }
                
                if (10 <= numTowers) {
                    numSrps = 15;
                    numMoneyTowers = 10;
                    break switchLabel;
                }
                
            }
            
            case 670 -> {
                
                if (15 <= numTowers) {
                    numSrps = 8;
                    numMoneyTowers = 15;
                    break switchLabel;
                }
                
            }
            
            case 758 -> {
                
                if (17 <= numTowers) {
                    numSrps = 8;
                    numMoneyTowers = 17;
                    break switchLabel;
                }
                
                if (11 <= numTowers) {
                    numSrps = 16;
                    numMoneyTowers = 11;
                    break switchLabel;
                }
                
            }
            
            case 792 -> {
                
                if (18 <= numTowers) {
                    numSrps = 8;
                    numMoneyTowers = 18;
                    break switchLabel;
                }
                
            }
            
            case 802 -> {
                
                if (18 <= numTowers) {
                    numSrps = 8;
                    numMoneyTowers = 18;
                    break switchLabel;
                }
                
            }
            
            case 880 -> {
                
                if (20 <= numTowers) {
                    numSrps = 8;
                    numMoneyTowers = 20;
                    break switchLabel;
                }
                
                if (11 <= numTowers) {
                    numSrps = 20;
                    numMoneyTowers = 11;
                    break switchLabel;
                }
                
            }
            
            case 890 -> {
                
                if (20 <= numTowers) {
                    numSrps = 8;
                    numMoneyTowers = 20;
                    break switchLabel;
                }
                
                if (11 <= numTowers) {
                    numSrps = 20;
                    numMoneyTowers = 11;
                    break switchLabel;
                }
                
                if (10 <= numTowers) {
                    numSrps = 23;
                    numMoneyTowers = 10;
                    break switchLabel;
                }
                
            }
            
            case 924 -> {
                
                if (21 <= numTowers) {
                    numSrps = 8;
                    numMoneyTowers = 21;
                    break switchLabel;
                }
                
                if (12 <= numTowers) {
                    numSrps = 19;
                    numMoneyTowers = 12;
                    break switchLabel;
                }
                
            }
            
            case 934 -> {
                
                if (21 <= numTowers) {
                    numSrps = 8;
                    numMoneyTowers = 21;
                    break switchLabel;
                }
                
                if (12 <= numTowers) {
                    numSrps = 19;
                    numMoneyTowers = 12;
                    break switchLabel;
                }
                
            }
            
            case 968 -> {
                
                if (22 <= numTowers) {
                    numSrps = 8;
                    numMoneyTowers = 22;
                    break switchLabel;
                }
                
            }
            
            case 978 -> {
                
                if (22 <= numTowers) {
                    numSrps = 8;
                    numMoneyTowers = 22;
                    break switchLabel;
                }
                
            }
            
            case 1012 -> {
                
                if (23 <= numTowers) {
                    numSrps = 8;
                    numMoneyTowers = 23;
                    break switchLabel;
                }
                
                if (11 <= numTowers) {
                    numSrps = 24;
                    numMoneyTowers = 11;
                    break switchLabel;
                }
                
            }
            
            case 1022 -> {
                
                if (23 <= numTowers) {
                    numSrps = 8;
                    numMoneyTowers = 23;
                    break switchLabel;
                }
                
                if (11 <= numTowers) {
                    numSrps = 24;
                    numMoneyTowers = 11;
                    break switchLabel;
                }
                
            }
            
            case 1056 -> {
                
                if (24 <= numTowers) {
                    numSrps = 8;
                    numMoneyTowers = 24;
                    break switchLabel;
                }
                
            }
            
            case 1066 -> {
                
                if (24 <= numTowers) {
                    numSrps = 8;
                    numMoneyTowers = 24;
                    break switchLabel;
                }
                
            }
            
            case 47 -> {
                
                if (1 <= numTowers) {
                    numSrps = 9;
                    numMoneyTowers = 1;
                    break switchLabel;
                }
                
            }
            
            case 57 -> {
                
                if (1 <= numTowers) {
                    numSrps = 9;
                    numMoneyTowers = 1;
                    break switchLabel;
                }
                
            }
            
            case 94 -> {
                
                if (2 <= numTowers) {
                    numSrps = 9;
                    numMoneyTowers = 2;
                    break switchLabel;
                }
                
            }
            
            case 141 -> {
                
                if (3 <= numTowers) {
                    numSrps = 9;
                    numMoneyTowers = 3;
                    break switchLabel;
                }
                
            }
            
            case 151 -> {
                
                if (3 <= numTowers) {
                    numSrps = 9;
                    numMoneyTowers = 3;
                    break switchLabel;
                }
                
            }
            
            case 188 -> {
                
                if (4 <= numTowers) {
                    numSrps = 9;
                    numMoneyTowers = 4;
                    break switchLabel;
                }
                
                if (2 <= numTowers) {
                    numSrps = 23;
                    numMoneyTowers = 2;
                    break switchLabel;
                }
                
            }
            
            case 198 -> {
                
                if (4 <= numTowers) {
                    numSrps = 9;
                    numMoneyTowers = 4;
                    break switchLabel;
                }
                
            }
            
            case 235 -> {
                
                if (5 <= numTowers) {
                    numSrps = 9;
                    numMoneyTowers = 5;
                    break switchLabel;
                }
                
            }
            
            case 282 -> {
                
                if (6 <= numTowers) {
                    numSrps = 9;
                    numMoneyTowers = 6;
                    break switchLabel;
                }
                
                if (4 <= numTowers) {
                    numSrps = 16;
                    numMoneyTowers = 4;
                    break switchLabel;
                }
                
            }
            
            case 292 -> {
                
                if (6 <= numTowers) {
                    numSrps = 9;
                    numMoneyTowers = 6;
                    break switchLabel;
                }
                
            }
            
            case 339 -> {
                
                if (7 <= numTowers) {
                    numSrps = 9;
                    numMoneyTowers = 7;
                    break switchLabel;
                }
                
            }
            
            case 376 -> {
                
                if (8 <= numTowers) {
                    numSrps = 9;
                    numMoneyTowers = 8;
                    break switchLabel;
                }
                
            }
            
            case 386 -> {
                
                if (8 <= numTowers) {
                    numSrps = 9;
                    numMoneyTowers = 8;
                    break switchLabel;
                }
                
            }
            
            case 423 -> {
                
                if (9 <= numTowers) {
                    numSrps = 9;
                    numMoneyTowers = 9;
                    break switchLabel;
                }
                
                if (7 <= numTowers) {
                    numSrps = 13;
                    numMoneyTowers = 7;
                    break switchLabel;
                }
                
            }
            
            case 433 -> {
                
                if (9 <= numTowers) {
                    numSrps = 9;
                    numMoneyTowers = 9;
                    break switchLabel;
                }
                
            }
            
            case 517 -> {
                
                if (11 <= numTowers) {
                    numSrps = 9;
                    numMoneyTowers = 11;
                    break switchLabel;
                }
                
            }
            
            case 527 -> {
                
                if (11 <= numTowers) {
                    numSrps = 9;
                    numMoneyTowers = 11;
                    break switchLabel;
                }
                
            }
            
            case 564 -> {
                
                if (12 <= numTowers) {
                    numSrps = 9;
                    numMoneyTowers = 12;
                    break switchLabel;
                }
                
            }
            
            case 611 -> {
                
                if (13 <= numTowers) {
                    numSrps = 9;
                    numMoneyTowers = 13;
                    break switchLabel;
                }
                
            }
            
            case 621 -> {
                
                if (13 <= numTowers) {
                    numSrps = 9;
                    numMoneyTowers = 13;
                    break switchLabel;
                }
                
            }
            
            case 658 -> {
                
                if (14 <= numTowers) {
                    numSrps = 9;
                    numMoneyTowers = 14;
                    break switchLabel;
                }
                
            }
            
            case 668 -> {
                
                if (14 <= numTowers) {
                    numSrps = 9;
                    numMoneyTowers = 14;
                    break switchLabel;
                }
                
            }
            
            case 705 -> {
                
                if (15 <= numTowers) {
                    numSrps = 9;
                    numMoneyTowers = 15;
                    break switchLabel;
                }
                
            }
            
            case 715 -> {
                
                if (15 <= numTowers) {
                    numSrps = 9;
                    numMoneyTowers = 15;
                    break switchLabel;
                }
                
                if (11 <= numTowers) {
                    numSrps = 15;
                    numMoneyTowers = 11;
                    break switchLabel;
                }
                
            }
            
            case 752 -> {
                
                if (16 <= numTowers) {
                    numSrps = 9;
                    numMoneyTowers = 16;
                    break switchLabel;
                }
                
                if (14 <= numTowers) {
                    numSrps = 11;
                    numMoneyTowers = 14;
                    break switchLabel;
                }
                
            }
            
            case 762 -> {
                
                if (16 <= numTowers) {
                    numSrps = 9;
                    numMoneyTowers = 16;
                    break switchLabel;
                }
                
            }
            
            case 799 -> {
                
                if (17 <= numTowers) {
                    numSrps = 9;
                    numMoneyTowers = 17;
                    break switchLabel;
                }
                
            }
            
            case 809 -> {
                
                if (17 <= numTowers) {
                    numSrps = 9;
                    numMoneyTowers = 17;
                    break switchLabel;
                }
                
            }
            
            case 856 -> {
                
                if (18 <= numTowers) {
                    numSrps = 9;
                    numMoneyTowers = 18;
                    break switchLabel;
                }
                
            }
            
            case 893 -> {
                
                if (19 <= numTowers) {
                    numSrps = 9;
                    numMoneyTowers = 19;
                    break switchLabel;
                }
                
            }
            
            case 903 -> {
                
                if (19 <= numTowers) {
                    numSrps = 9;
                    numMoneyTowers = 19;
                    break switchLabel;
                }
                
            }
            
            case 940 -> {
                
                if (20 <= numTowers) {
                    numSrps = 9;
                    numMoneyTowers = 20;
                    break switchLabel;
                }
                
                if (15 <= numTowers) {
                    numSrps = 14;
                    numMoneyTowers = 15;
                    break switchLabel;
                }
                
            }
            
            case 950 -> {
                
                if (20 <= numTowers) {
                    numSrps = 9;
                    numMoneyTowers = 20;
                    break switchLabel;
                }
                
                if (19 <= numTowers) {
                    numSrps = 10;
                    numMoneyTowers = 19;
                    break switchLabel;
                }
                
            }
            
            case 987 -> {
                
                if (21 <= numTowers) {
                    numSrps = 9;
                    numMoneyTowers = 21;
                    break switchLabel;
                }
                
            }
            
            case 997 -> {
                
                if (21 <= numTowers) {
                    numSrps = 9;
                    numMoneyTowers = 21;
                    break switchLabel;
                }
                
            }
            
            case 1034 -> {
                
                if (22 <= numTowers) {
                    numSrps = 9;
                    numMoneyTowers = 22;
                    break switchLabel;
                }
                
            }
            
            case 1044 -> {
                
                if (22 <= numTowers) {
                    numSrps = 9;
                    numMoneyTowers = 22;
                    break switchLabel;
                }
                
            }
            
            case 1081 -> {
                
                if (23 <= numTowers) {
                    numSrps = 9;
                    numMoneyTowers = 23;
                    break switchLabel;
                }
                
            }
            
            case 1091 -> {
                
                if (23 <= numTowers) {
                    numSrps = 9;
                    numMoneyTowers = 23;
                    break switchLabel;
                }
                
            }
            
            case 1128 -> {
                
                if (24 <= numTowers) {
                    numSrps = 9;
                    numMoneyTowers = 24;
                    break switchLabel;
                }
                
                if (13 <= numTowers) {
                    numSrps = 22;
                    numMoneyTowers = 13;
                    break switchLabel;
                }
                
            }
            
            case 1138 -> {
                
                if (24 <= numTowers) {
                    numSrps = 9;
                    numMoneyTowers = 24;
                    break switchLabel;
                }
                
            }
            
            case 510 -> {
                
                if (10 <= numTowers) {
                    numSrps = 10;
                    numMoneyTowers = 10;
                    break switchLabel;
                }
                
            }
            
            case 550 -> {
                
                if (11 <= numTowers) {
                    numSrps = 10;
                    numMoneyTowers = 11;
                    break switchLabel;
                }
                
            }
            
            case 600 -> {
                
                if (12 <= numTowers) {
                    numSrps = 10;
                    numMoneyTowers = 12;
                    break switchLabel;
                }
                
                if (10 <= numTowers) {
                    numSrps = 13;
                    numMoneyTowers = 10;
                    break switchLabel;
                }
                
            }
            
            case 610 -> {
                
                if (12 <= numTowers) {
                    numSrps = 10;
                    numMoneyTowers = 12;
                    break switchLabel;
                }
                
            }
            
            case 750 -> {
                
                if (15 <= numTowers) {
                    numSrps = 10;
                    numMoneyTowers = 15;
                    break switchLabel;
                }
                
                if (10 <= numTowers) {
                    numSrps = 18;
                    numMoneyTowers = 10;
                    break switchLabel;
                }
                
            }
            
            case 800 -> {
                
                if (16 <= numTowers) {
                    numSrps = 10;
                    numMoneyTowers = 16;
                    break switchLabel;
                }
                
                if (10 <= numTowers) {
                    numSrps = 20;
                    numMoneyTowers = 10;
                    break switchLabel;
                }
                
            }
            
            case 810 -> {
                
                if (16 <= numTowers) {
                    numSrps = 10;
                    numMoneyTowers = 16;
                    break switchLabel;
                }
                
                if (10 <= numTowers) {
                    numSrps = 20;
                    numMoneyTowers = 10;
                    break switchLabel;
                }
                
            }
            
            case 860 -> {
                
                if (17 <= numTowers) {
                    numSrps = 10;
                    numMoneyTowers = 17;
                    break switchLabel;
                }
                
                if (10 <= numTowers) {
                    numSrps = 22;
                    numMoneyTowers = 10;
                    break switchLabel;
                }
                
            }
            
            case 900 -> {
                
                if (18 <= numTowers) {
                    numSrps = 10;
                    numMoneyTowers = 18;
                    break switchLabel;
                }
                
                if (10 <= numTowers) {
                    numSrps = 23;
                    numMoneyTowers = 10;
                    break switchLabel;
                }
                
            }
            
            case 910 -> {
                
                if (18 <= numTowers) {
                    numSrps = 10;
                    numMoneyTowers = 18;
                    break switchLabel;
                }
                
                if (14 <= numTowers) {
                    numSrps = 15;
                    numMoneyTowers = 14;
                    break switchLabel;
                }
                
            }
            
            case 960 -> {
                
                if (19 <= numTowers) {
                    numSrps = 10;
                    numMoneyTowers = 19;
                    break switchLabel;
                }
                
                if (12 <= numTowers) {
                    numSrps = 20;
                    numMoneyTowers = 12;
                    break switchLabel;
                }
                
            }
            
            case 1000 -> {
                
                if (20 <= numTowers) {
                    numSrps = 10;
                    numMoneyTowers = 20;
                    break switchLabel;
                }
                
            }
            
            case 1010 -> {
                
                if (20 <= numTowers) {
                    numSrps = 10;
                    numMoneyTowers = 20;
                    break switchLabel;
                }
                
            }
            
            case 1050 -> {
                
                if (21 <= numTowers) {
                    numSrps = 10;
                    numMoneyTowers = 21;
                    break switchLabel;
                }
                
                if (16 <= numTowers) {
                    numSrps = 15;
                    numMoneyTowers = 16;
                    break switchLabel;
                }
                
                if (13 <= numTowers) {
                    numSrps = 20;
                    numMoneyTowers = 13;
                    break switchLabel;
                }
                
            }
            
            case 1060 -> {
                
                if (21 <= numTowers) {
                    numSrps = 10;
                    numMoneyTowers = 21;
                    break switchLabel;
                }
                
                if (20 <= numTowers) {
                    numSrps = 11;
                    numMoneyTowers = 20;
                    break switchLabel;
                }
                
            }
            
            case 1100 -> {
                
                if (22 <= numTowers) {
                    numSrps = 10;
                    numMoneyTowers = 22;
                    break switchLabel;
                }
                
            }
            
            case 1110 -> {
                
                if (22 <= numTowers) {
                    numSrps = 10;
                    numMoneyTowers = 22;
                    break switchLabel;
                }
                
                if (15 <= numTowers) {
                    numSrps = 18;
                    numMoneyTowers = 15;
                    break switchLabel;
                }
                
            }
            
            case 1150 -> {
                
                if (23 <= numTowers) {
                    numSrps = 10;
                    numMoneyTowers = 23;
                    break switchLabel;
                }
                
            }
            
            case 1160 -> {
                
                if (23 <= numTowers) {
                    numSrps = 10;
                    numMoneyTowers = 23;
                    break switchLabel;
                }
                
            }
            
            case 1200 -> {
                
                if (24 <= numTowers) {
                    numSrps = 10;
                    numMoneyTowers = 24;
                    break switchLabel;
                }
                
                if (15 <= numTowers) {
                    numSrps = 20;
                    numMoneyTowers = 15;
                    break switchLabel;
                }
                
            }
            
            case 1210 -> {
                
                if (24 <= numTowers) {
                    numSrps = 10;
                    numMoneyTowers = 24;
                    break switchLabel;
                }
                
                if (15 <= numTowers) {
                    numSrps = 20;
                    numMoneyTowers = 15;
                    break switchLabel;
                }
                
            }
            
            case 53 -> {
                
                if (1 <= numTowers) {
                    numSrps = 11;
                    numMoneyTowers = 1;
                    break switchLabel;
                }
                
            }
            
            case 63 -> {
                
                if (1 <= numTowers) {
                    numSrps = 11;
                    numMoneyTowers = 1;
                    break switchLabel;
                }
                
            }
            
            case 159 -> {
                
                if (3 <= numTowers) {
                    numSrps = 11;
                    numMoneyTowers = 3;
                    break switchLabel;
                }
                
            }
            
            case 169 -> {
                
                if (3 <= numTowers) {
                    numSrps = 11;
                    numMoneyTowers = 3;
                    break switchLabel;
                }
                
            }
            
            case 212 -> {
                
                if (4 <= numTowers) {
                    numSrps = 11;
                    numMoneyTowers = 4;
                    break switchLabel;
                }
                
            }
            
            case 222 -> {
                
                if (4 <= numTowers) {
                    numSrps = 11;
                    numMoneyTowers = 4;
                    break switchLabel;
                }
                
                if (3 <= numTowers) {
                    numSrps = 18;
                    numMoneyTowers = 3;
                    break switchLabel;
                }
                
            }
            
            case 265 -> {
                
                if (5 <= numTowers) {
                    numSrps = 11;
                    numMoneyTowers = 5;
                    break switchLabel;
                }
                
            }
            
            case 275 -> {
                
                if (5 <= numTowers) {
                    numSrps = 11;
                    numMoneyTowers = 5;
                    break switchLabel;
                }
                
            }
            
            case 371 -> {
                
                if (7 <= numTowers) {
                    numSrps = 11;
                    numMoneyTowers = 7;
                    break switchLabel;
                }
                
            }
            
            case 381 -> {
                
                if (7 <= numTowers) {
                    numSrps = 11;
                    numMoneyTowers = 7;
                    break switchLabel;
                }
                
            }
            
            case 434 -> {
                
                if (8 <= numTowers) {
                    numSrps = 11;
                    numMoneyTowers = 8;
                    break switchLabel;
                }
                
                if (7 <= numTowers) {
                    numSrps = 14;
                    numMoneyTowers = 7;
                    break switchLabel;
                }
                
            }
            
            case 477 -> {
                
                if (9 <= numTowers) {
                    numSrps = 11;
                    numMoneyTowers = 9;
                    break switchLabel;
                }
                
            }
            
            case 487 -> {
                
                if (9 <= numTowers) {
                    numSrps = 11;
                    numMoneyTowers = 9;
                    break switchLabel;
                }
                
            }
            
            case 540 -> {
                
                if (10 <= numTowers) {
                    numSrps = 11;
                    numMoneyTowers = 10;
                    break switchLabel;
                }
                
            }
            
            case 583 -> {
                
                if (11 <= numTowers) {
                    numSrps = 11;
                    numMoneyTowers = 11;
                    break switchLabel;
                }
                
            }
            
            case 593 -> {
                
                if (11 <= numTowers) {
                    numSrps = 11;
                    numMoneyTowers = 11;
                    break switchLabel;
                }
                
            }
            
            case 636 -> {
                
                if (12 <= numTowers) {
                    numSrps = 11;
                    numMoneyTowers = 12;
                    break switchLabel;
                }
                
            }
            
            case 689 -> {
                
                if (13 <= numTowers) {
                    numSrps = 11;
                    numMoneyTowers = 13;
                    break switchLabel;
                }
                
            }
            
            case 699 -> {
                
                if (13 <= numTowers) {
                    numSrps = 11;
                    numMoneyTowers = 13;
                    break switchLabel;
                }
                
            }
            
            case 742 -> {
                
                if (14 <= numTowers) {
                    numSrps = 11;
                    numMoneyTowers = 14;
                    break switchLabel;
                }
                
            }
            
            case 795 -> {
                
                if (15 <= numTowers) {
                    numSrps = 11;
                    numMoneyTowers = 15;
                    break switchLabel;
                }
                
            }
            
            case 848 -> {
                
                if (16 <= numTowers) {
                    numSrps = 11;
                    numMoneyTowers = 16;
                    break switchLabel;
                }
                
            }
            
            case 858 -> {
                
                if (16 <= numTowers) {
                    numSrps = 11;
                    numMoneyTowers = 16;
                    break switchLabel;
                }
                
            }
            
            case 901 -> {
                
                if (17 <= numTowers) {
                    numSrps = 11;
                    numMoneyTowers = 17;
                    break switchLabel;
                }
                
            }
            
            case 911 -> {
                
                if (17 <= numTowers) {
                    numSrps = 11;
                    numMoneyTowers = 17;
                    break switchLabel;
                }
                
            }
            
            case 954 -> {
                
                if (18 <= numTowers) {
                    numSrps = 11;
                    numMoneyTowers = 18;
                    break switchLabel;
                }
                
                if (16 <= numTowers) {
                    numSrps = 13;
                    numMoneyTowers = 16;
                    break switchLabel;
                }
                
            }
            
            case 964 -> {
                
                if (18 <= numTowers) {
                    numSrps = 11;
                    numMoneyTowers = 18;
                    break switchLabel;
                }
                
            }
            
            case 1007 -> {
                
                if (19 <= numTowers) {
                    numSrps = 11;
                    numMoneyTowers = 19;
                    break switchLabel;
                }
                
            }
            
            case 1017 -> {
                
                if (19 <= numTowers) {
                    numSrps = 11;
                    numMoneyTowers = 19;
                    break switchLabel;
                }
                
            }
            
            case 1070 -> {
                
                if (20 <= numTowers) {
                    numSrps = 11;
                    numMoneyTowers = 20;
                    break switchLabel;
                }
                
            }
            
            case 1113 -> {
                
                if (21 <= numTowers) {
                    numSrps = 11;
                    numMoneyTowers = 21;
                    break switchLabel;
                }
                
            }
            
            case 1123 -> {
                
                if (21 <= numTowers) {
                    numSrps = 11;
                    numMoneyTowers = 21;
                    break switchLabel;
                }
                
            }
            
            case 1166 -> {
                
                if (22 <= numTowers) {
                    numSrps = 11;
                    numMoneyTowers = 22;
                    break switchLabel;
                }
                
                if (17 <= numTowers) {
                    numSrps = 16;
                    numMoneyTowers = 17;
                    break switchLabel;
                }
                
            }
            
            case 1176 -> {
                
                if (22 <= numTowers) {
                    numSrps = 11;
                    numMoneyTowers = 22;
                    break switchLabel;
                }
                
                if (21 <= numTowers) {
                    numSrps = 12;
                    numMoneyTowers = 21;
                    break switchLabel;
                }
                
            }
            
            case 1219 -> {
                
                if (23 <= numTowers) {
                    numSrps = 11;
                    numMoneyTowers = 23;
                    break switchLabel;
                }
                
            }
            
            case 1229 -> {
                
                if (23 <= numTowers) {
                    numSrps = 11;
                    numMoneyTowers = 23;
                    break switchLabel;
                }
                
            }
            
            case 1272 -> {
                
                if (24 <= numTowers) {
                    numSrps = 11;
                    numMoneyTowers = 24;
                    break switchLabel;
                }
                
            }
            
            case 1282 -> {
                
                if (24 <= numTowers) {
                    numSrps = 11;
                    numMoneyTowers = 24;
                    break switchLabel;
                }
                
            }
            
            case 66 -> {
                
                if (1 <= numTowers) {
                    numSrps = 12;
                    numMoneyTowers = 1;
                    break switchLabel;
                }
                
            }
            
            case 112 -> {
                
                if (2 <= numTowers) {
                    numSrps = 12;
                    numMoneyTowers = 2;
                    break switchLabel;
                }
                
            }
            
            case 122 -> {
                
                if (2 <= numTowers) {
                    numSrps = 12;
                    numMoneyTowers = 2;
                    break switchLabel;
                }
                
            }
            
            case 168 -> {
                
                if (3 <= numTowers) {
                    numSrps = 12;
                    numMoneyTowers = 3;
                    break switchLabel;
                }
                
            }
            
            case 178 -> {
                
                if (3 <= numTowers) {
                    numSrps = 12;
                    numMoneyTowers = 3;
                    break switchLabel;
                }
                
                if (2 <= numTowers) {
                    numSrps = 23;
                    numMoneyTowers = 2;
                    break switchLabel;
                }
                
            }
            
            case 336 -> {
                
                if (6 <= numTowers) {
                    numSrps = 12;
                    numMoneyTowers = 6;
                    break switchLabel;
                }
                
            }
            
            case 346 -> {
                
                if (6 <= numTowers) {
                    numSrps = 12;
                    numMoneyTowers = 6;
                    break switchLabel;
                }
                
            }
            
            case 392 -> {
                
                if (7 <= numTowers) {
                    numSrps = 12;
                    numMoneyTowers = 7;
                    break switchLabel;
                }
                
            }
            
            case 402 -> {
                
                if (7 <= numTowers) {
                    numSrps = 12;
                    numMoneyTowers = 7;
                    break switchLabel;
                }
                
            }
            
            case 514 -> {
                
                if (9 <= numTowers) {
                    numSrps = 12;
                    numMoneyTowers = 9;
                    break switchLabel;
                }
                
            }
            
            case 728 -> {
                
                if (13 <= numTowers) {
                    numSrps = 12;
                    numMoneyTowers = 13;
                    break switchLabel;
                }
                
            }
            
            case 784 -> {
                
                if (14 <= numTowers) {
                    numSrps = 12;
                    numMoneyTowers = 14;
                    break switchLabel;
                }
                
                if (9 <= numTowers) {
                    numSrps = 22;
                    numMoneyTowers = 9;
                    break switchLabel;
                }
                
            }
            
            case 794 -> {
                
                if (14 <= numTowers) {
                    numSrps = 12;
                    numMoneyTowers = 14;
                    break switchLabel;
                }
                
            }
            
            case 896 -> {
                
                if (16 <= numTowers) {
                    numSrps = 12;
                    numMoneyTowers = 16;
                    break switchLabel;
                }
                
            }
            
            case 906 -> {
                
                if (16 <= numTowers) {
                    numSrps = 12;
                    numMoneyTowers = 16;
                    break switchLabel;
                }
                
            }
            
            case 952 -> {
                
                if (17 <= numTowers) {
                    numSrps = 12;
                    numMoneyTowers = 17;
                    break switchLabel;
                }
                
                if (14 <= numTowers) {
                    numSrps = 16;
                    numMoneyTowers = 14;
                    break switchLabel;
                }
                
            }
            
            case 962 -> {
                
                if (17 <= numTowers) {
                    numSrps = 12;
                    numMoneyTowers = 17;
                    break switchLabel;
                }
                
                if (14 <= numTowers) {
                    numSrps = 16;
                    numMoneyTowers = 14;
                    break switchLabel;
                }
                
                if (13 <= numTowers) {
                    numSrps = 18;
                    numMoneyTowers = 13;
                    break switchLabel;
                }
                
            }
            
            case 1008 -> {
                
                if (18 <= numTowers) {
                    numSrps = 12;
                    numMoneyTowers = 18;
                    break switchLabel;
                }
                
            }
            
            case 1018 -> {
                
                if (18 <= numTowers) {
                    numSrps = 12;
                    numMoneyTowers = 18;
                    break switchLabel;
                }
                
            }
            
            case 1064 -> {
                
                if (19 <= numTowers) {
                    numSrps = 12;
                    numMoneyTowers = 19;
                    break switchLabel;
                }
                
                if (17 <= numTowers) {
                    numSrps = 14;
                    numMoneyTowers = 17;
                    break switchLabel;
                }
                
            }
            
            case 1074 -> {
                
                if (19 <= numTowers) {
                    numSrps = 12;
                    numMoneyTowers = 19;
                    break switchLabel;
                }
                
            }
            
            case 1120 -> {
                
                if (20 <= numTowers) {
                    numSrps = 12;
                    numMoneyTowers = 20;
                    break switchLabel;
                }
                
                if (15 <= numTowers) {
                    numSrps = 18;
                    numMoneyTowers = 15;
                    break switchLabel;
                }
                
                if (14 <= numTowers) {
                    numSrps = 20;
                    numMoneyTowers = 14;
                    break switchLabel;
                }
                
            }
            
            case 1130 -> {
                
                if (20 <= numTowers) {
                    numSrps = 12;
                    numMoneyTowers = 20;
                    break switchLabel;
                }
                
                if (14 <= numTowers) {
                    numSrps = 20;
                    numMoneyTowers = 14;
                    break switchLabel;
                }
                
            }
            
            case 1186 -> {
                
                if (21 <= numTowers) {
                    numSrps = 12;
                    numMoneyTowers = 21;
                    break switchLabel;
                }
                
            }
            
            case 1232 -> {
                
                if (22 <= numTowers) {
                    numSrps = 12;
                    numMoneyTowers = 22;
                    break switchLabel;
                }
                
                if (16 <= numTowers) {
                    numSrps = 19;
                    numMoneyTowers = 16;
                    break switchLabel;
                }
                
            }
            
            case 1242 -> {
                
                if (22 <= numTowers) {
                    numSrps = 12;
                    numMoneyTowers = 22;
                    break switchLabel;
                }
                
                if (16 <= numTowers) {
                    numSrps = 19;
                    numMoneyTowers = 16;
                    break switchLabel;
                }
                
            }
            
            case 1288 -> {
                
                if (23 <= numTowers) {
                    numSrps = 12;
                    numMoneyTowers = 23;
                    break switchLabel;
                }
                
                if (18 <= numTowers) {
                    numSrps = 17;
                    numMoneyTowers = 18;
                    break switchLabel;
                }
                
                if (14 <= numTowers) {
                    numSrps = 24;
                    numMoneyTowers = 14;
                    break switchLabel;
                }
                
            }
            
            case 1298 -> {
                
                if (23 <= numTowers) {
                    numSrps = 12;
                    numMoneyTowers = 23;
                    break switchLabel;
                }
                
                if (22 <= numTowers) {
                    numSrps = 13;
                    numMoneyTowers = 22;
                    break switchLabel;
                }
                
                if (14 <= numTowers) {
                    numSrps = 24;
                    numMoneyTowers = 14;
                    break switchLabel;
                }
                
            }
            
            case 1344 -> {
                
                if (24 <= numTowers) {
                    numSrps = 12;
                    numMoneyTowers = 24;
                    break switchLabel;
                }
                
            }
            
            case 1354 -> {
                
                if (24 <= numTowers) {
                    numSrps = 12;
                    numMoneyTowers = 24;
                    break switchLabel;
                }
                
            }
            
            case 59 -> {
                
                if (1 <= numTowers) {
                    numSrps = 13;
                    numMoneyTowers = 1;
                    break switchLabel;
                }
                
            }
            
            case 118 -> {
                
                if (2 <= numTowers) {
                    numSrps = 13;
                    numMoneyTowers = 2;
                    break switchLabel;
                }
                
            }
            
            case 177 -> {
                
                if (3 <= numTowers) {
                    numSrps = 13;
                    numMoneyTowers = 3;
                    break switchLabel;
                }
                
            }
            
            case 187 -> {
                
                if (3 <= numTowers) {
                    numSrps = 13;
                    numMoneyTowers = 3;
                    break switchLabel;
                }
                
            }
            
            case 236 -> {
                
                if (4 <= numTowers) {
                    numSrps = 13;
                    numMoneyTowers = 4;
                    break switchLabel;
                }
                
            }
            
            case 295 -> {
                
                if (5 <= numTowers) {
                    numSrps = 13;
                    numMoneyTowers = 5;
                    break switchLabel;
                }
                
            }
            
            case 305 -> {
                
                if (5 <= numTowers) {
                    numSrps = 13;
                    numMoneyTowers = 5;
                    break switchLabel;
                }
                
            }
            
            case 354 -> {
                
                if (6 <= numTowers) {
                    numSrps = 13;
                    numMoneyTowers = 6;
                    break switchLabel;
                }
                
                if (4 <= numTowers) {
                    numSrps = 22;
                    numMoneyTowers = 4;
                    break switchLabel;
                }
                
            }
            
            case 413 -> {
                
                if (7 <= numTowers) {
                    numSrps = 13;
                    numMoneyTowers = 7;
                    break switchLabel;
                }
                
            }
            
            case 472 -> {
                
                if (8 <= numTowers) {
                    numSrps = 13;
                    numMoneyTowers = 8;
                    break switchLabel;
                }
                
                if (6 <= numTowers) {
                    numSrps = 19;
                    numMoneyTowers = 6;
                    break switchLabel;
                }
                
            }
            
            case 482 -> {
                
                if (8 <= numTowers) {
                    numSrps = 13;
                    numMoneyTowers = 8;
                    break switchLabel;
                }
                
            }
            
            case 531 -> {
                
                if (9 <= numTowers) {
                    numSrps = 13;
                    numMoneyTowers = 9;
                    break switchLabel;
                }
                
            }
            
            case 541 -> {
                
                if (9 <= numTowers) {
                    numSrps = 13;
                    numMoneyTowers = 9;
                    break switchLabel;
                }
                
            }
            
            case 649 -> {
                
                if (11 <= numTowers) {
                    numSrps = 13;
                    numMoneyTowers = 11;
                    break switchLabel;
                }
                
                if (9 <= numTowers) {
                    numSrps = 17;
                    numMoneyTowers = 9;
                    break switchLabel;
                }
                
            }
            
            case 659 -> {
                
                if (11 <= numTowers) {
                    numSrps = 13;
                    numMoneyTowers = 11;
                    break switchLabel;
                }
                
            }
            
            case 708 -> {
                
                if (12 <= numTowers) {
                    numSrps = 13;
                    numMoneyTowers = 12;
                    break switchLabel;
                }
                
            }
            
            case 718 -> {
                
                if (12 <= numTowers) {
                    numSrps = 13;
                    numMoneyTowers = 12;
                    break switchLabel;
                }
                
            }
            
            case 767 -> {
                
                if (13 <= numTowers) {
                    numSrps = 13;
                    numMoneyTowers = 13;
                    break switchLabel;
                }
                
            }
            
            case 777 -> {
                
                if (13 <= numTowers) {
                    numSrps = 13;
                    numMoneyTowers = 13;
                    break switchLabel;
                }
                
            }
            
            case 826 -> {
                
                if (14 <= numTowers) {
                    numSrps = 13;
                    numMoneyTowers = 14;
                    break switchLabel;
                }
                
                if (12 <= numTowers) {
                    numSrps = 16;
                    numMoneyTowers = 12;
                    break switchLabel;
                }
                
            }
            
            case 885 -> {
                
                if (15 <= numTowers) {
                    numSrps = 13;
                    numMoneyTowers = 15;
                    break switchLabel;
                }
                
            }
            
            case 895 -> {
                
                if (15 <= numTowers) {
                    numSrps = 13;
                    numMoneyTowers = 15;
                    break switchLabel;
                }
                
            }
            
            case 944 -> {
                
                if (16 <= numTowers) {
                    numSrps = 13;
                    numMoneyTowers = 16;
                    break switchLabel;
                }
                
            }
            
            case 1003 -> {
                
                if (17 <= numTowers) {
                    numSrps = 13;
                    numMoneyTowers = 17;
                    break switchLabel;
                }
                
            }
            
            case 1013 -> {
                
                if (17 <= numTowers) {
                    numSrps = 13;
                    numMoneyTowers = 17;
                    break switchLabel;
                }
                
            }
            
            case 1062 -> {
                
                if (18 <= numTowers) {
                    numSrps = 13;
                    numMoneyTowers = 18;
                    break switchLabel;
                }
                
            }
            
            case 1072 -> {
                
                if (18 <= numTowers) {
                    numSrps = 13;
                    numMoneyTowers = 18;
                    break switchLabel;
                }
                
            }
            
            case 1121 -> {
                
                if (19 <= numTowers) {
                    numSrps = 13;
                    numMoneyTowers = 19;
                    break switchLabel;
                }
                
            }
            
            case 1131 -> {
                
                if (19 <= numTowers) {
                    numSrps = 13;
                    numMoneyTowers = 19;
                    break switchLabel;
                }
                
            }
            
            case 1180 -> {
                
                if (20 <= numTowers) {
                    numSrps = 13;
                    numMoneyTowers = 20;
                    break switchLabel;
                }
                
                if (18 <= numTowers) {
                    numSrps = 15;
                    numMoneyTowers = 18;
                    break switchLabel;
                }
                
            }
            
            case 1190 -> {
                
                if (20 <= numTowers) {
                    numSrps = 13;
                    numMoneyTowers = 20;
                    break switchLabel;
                }
                
            }
            
            case 1239 -> {
                
                if (21 <= numTowers) {
                    numSrps = 13;
                    numMoneyTowers = 21;
                    break switchLabel;
                }
                
            }
            
            case 1249 -> {
                
                if (21 <= numTowers) {
                    numSrps = 13;
                    numMoneyTowers = 21;
                    break switchLabel;
                }
                
            }
            
            case 1308 -> {
                
                if (22 <= numTowers) {
                    numSrps = 13;
                    numMoneyTowers = 22;
                    break switchLabel;
                }
                
            }
            
            case 1357 -> {
                
                if (23 <= numTowers) {
                    numSrps = 13;
                    numMoneyTowers = 23;
                    break switchLabel;
                }
                
            }
            
            case 1367 -> {
                
                if (23 <= numTowers) {
                    numSrps = 13;
                    numMoneyTowers = 23;
                    break switchLabel;
                }
                
            }
            
            case 1416 -> {
                
                if (24 <= numTowers) {
                    numSrps = 13;
                    numMoneyTowers = 24;
                    break switchLabel;
                }
                
                if (19 <= numTowers) {
                    numSrps = 18;
                    numMoneyTowers = 19;
                    break switchLabel;
                }
                
            }
            
            case 1426 -> {
                
                if (24 <= numTowers) {
                    numSrps = 13;
                    numMoneyTowers = 24;
                    break switchLabel;
                }
                
                if (23 <= numTowers) {
                    numSrps = 14;
                    numMoneyTowers = 23;
                    break switchLabel;
                }
                
            }
            
            case 72 -> {
                
                if (1 <= numTowers) {
                    numSrps = 14;
                    numMoneyTowers = 1;
                    break switchLabel;
                }
                
            }
            
            case 134 -> {
                
                if (2 <= numTowers) {
                    numSrps = 14;
                    numMoneyTowers = 2;
                    break switchLabel;
                }
                
            }
            
            case 196 -> {
                
                if (3 <= numTowers) {
                    numSrps = 14;
                    numMoneyTowers = 3;
                    break switchLabel;
                }
                
            }
            
            case 248 -> {
                
                if (4 <= numTowers) {
                    numSrps = 14;
                    numMoneyTowers = 4;
                    break switchLabel;
                }
                
            }
            
            case 258 -> {
                
                if (4 <= numTowers) {
                    numSrps = 14;
                    numMoneyTowers = 4;
                    break switchLabel;
                }
                
                if (3 <= numTowers) {
                    numSrps = 22;
                    numMoneyTowers = 3;
                    break switchLabel;
                }
                
            }
            
            case 372 -> {
                
                if (6 <= numTowers) {
                    numSrps = 14;
                    numMoneyTowers = 6;
                    break switchLabel;
                }
                
            }
            
            case 382 -> {
                
                if (6 <= numTowers) {
                    numSrps = 14;
                    numMoneyTowers = 6;
                    break switchLabel;
                }
                
            }
            
            case 444 -> {
                
                if (7 <= numTowers) {
                    numSrps = 14;
                    numMoneyTowers = 7;
                    break switchLabel;
                }
                
                if (6 <= numTowers) {
                    numSrps = 18;
                    numMoneyTowers = 6;
                    break switchLabel;
                }
                
            }
            
            case 496 -> {
                
                if (8 <= numTowers) {
                    numSrps = 14;
                    numMoneyTowers = 8;
                    break switchLabel;
                }
                
            }
            
            case 558 -> {
                
                if (9 <= numTowers) {
                    numSrps = 14;
                    numMoneyTowers = 9;
                    break switchLabel;
                }
                
            }
            
            case 568 -> {
                
                if (9 <= numTowers) {
                    numSrps = 14;
                    numMoneyTowers = 9;
                    break switchLabel;
                }
                
                if (8 <= numTowers) {
                    numSrps = 17;
                    numMoneyTowers = 8;
                    break switchLabel;
                }
                
            }
            
            case 620 -> {
                
                if (10 <= numTowers) {
                    numSrps = 14;
                    numMoneyTowers = 10;
                    break switchLabel;
                }
                
            }
            
            case 692 -> {
                
                if (11 <= numTowers) {
                    numSrps = 14;
                    numMoneyTowers = 11;
                    break switchLabel;
                }
                
            }
            
            case 744 -> {
                
                if (12 <= numTowers) {
                    numSrps = 14;
                    numMoneyTowers = 12;
                    break switchLabel;
                }
                
            }
            
            case 754 -> {
                
                if (12 <= numTowers) {
                    numSrps = 14;
                    numMoneyTowers = 12;
                    break switchLabel;
                }
                
            }
            
            case 806 -> {
                
                if (13 <= numTowers) {
                    numSrps = 14;
                    numMoneyTowers = 13;
                    break switchLabel;
                }
                
            }
            
            case 816 -> {
                
                if (13 <= numTowers) {
                    numSrps = 14;
                    numMoneyTowers = 13;
                    break switchLabel;
                }
                
                if (12 <= numTowers) {
                    numSrps = 16;
                    numMoneyTowers = 12;
                    break switchLabel;
                }
                
            }
            
            case 868 -> {
                
                if (14 <= numTowers) {
                    numSrps = 14;
                    numMoneyTowers = 14;
                    break switchLabel;
                }
                
            }
            
            case 878 -> {
                
                if (14 <= numTowers) {
                    numSrps = 14;
                    numMoneyTowers = 14;
                    break switchLabel;
                }
                
            }
            
            case 930 -> {
                
                if (15 <= numTowers) {
                    numSrps = 14;
                    numMoneyTowers = 15;
                    break switchLabel;
                }
                
                if (10 <= numTowers) {
                    numSrps = 24;
                    numMoneyTowers = 10;
                    break switchLabel;
                }
                
            }
            
            case 992 -> {
                
                if (16 <= numTowers) {
                    numSrps = 14;
                    numMoneyTowers = 16;
                    break switchLabel;
                }
                
            }
            
            case 1002 -> {
                
                if (16 <= numTowers) {
                    numSrps = 14;
                    numMoneyTowers = 16;
                    break switchLabel;
                }
                
            }
            
            case 1054 -> {
                
                if (17 <= numTowers) {
                    numSrps = 14;
                    numMoneyTowers = 17;
                    break switchLabel;
                }
                
            }
            
            case 1116 -> {
                
                if (18 <= numTowers) {
                    numSrps = 14;
                    numMoneyTowers = 18;
                    break switchLabel;
                }
                
            }
            
            case 1126 -> {
                
                if (18 <= numTowers) {
                    numSrps = 14;
                    numMoneyTowers = 18;
                    break switchLabel;
                }
                
            }
            
            case 1178 -> {
                
                if (19 <= numTowers) {
                    numSrps = 14;
                    numMoneyTowers = 19;
                    break switchLabel;
                }
                
            }
            
            case 1188 -> {
                
                if (19 <= numTowers) {
                    numSrps = 14;
                    numMoneyTowers = 19;
                    break switchLabel;
                }
                
            }
            
            case 1240 -> {
                
                if (20 <= numTowers) {
                    numSrps = 14;
                    numMoneyTowers = 20;
                    break switchLabel;
                }
                
            }
            
            case 1250 -> {
                
                if (20 <= numTowers) {
                    numSrps = 14;
                    numMoneyTowers = 20;
                    break switchLabel;
                }
                
            }
            
            case 1302 -> {
                
                if (21 <= numTowers) {
                    numSrps = 14;
                    numMoneyTowers = 21;
                    break switchLabel;
                }
                
                if (19 <= numTowers) {
                    numSrps = 16;
                    numMoneyTowers = 19;
                    break switchLabel;
                }
                
            }
            
            case 1312 -> {
                
                if (21 <= numTowers) {
                    numSrps = 14;
                    numMoneyTowers = 21;
                    break switchLabel;
                }
                
            }
            
            case 1364 -> {
                
                if (22 <= numTowers) {
                    numSrps = 14;
                    numMoneyTowers = 22;
                    break switchLabel;
                }
                
            }
            
            case 1374 -> {
                
                if (22 <= numTowers) {
                    numSrps = 14;
                    numMoneyTowers = 22;
                    break switchLabel;
                }
                
            }
            
            case 1436 -> {
                
                if (23 <= numTowers) {
                    numSrps = 14;
                    numMoneyTowers = 23;
                    break switchLabel;
                }
                
            }
            
            case 1488 -> {
                
                if (24 <= numTowers) {
                    numSrps = 14;
                    numMoneyTowers = 24;
                    break switchLabel;
                }
                
            }
            
            case 1498 -> {
                
                if (24 <= numTowers) {
                    numSrps = 14;
                    numMoneyTowers = 24;
                    break switchLabel;
                }
                
            }
            
            case 65 -> {
                
                if (1 <= numTowers) {
                    numSrps = 15;
                    numMoneyTowers = 1;
                    break switchLabel;
                }
                
            }
            
            case 75 -> {
                
                if (1 <= numTowers) {
                    numSrps = 15;
                    numMoneyTowers = 1;
                    break switchLabel;
                }
                
            }
            
            case 195 -> {
                
                if (3 <= numTowers) {
                    numSrps = 15;
                    numMoneyTowers = 3;
                    break switchLabel;
                }
                
            }
            
            case 335 -> {
                
                if (5 <= numTowers) {
                    numSrps = 15;
                    numMoneyTowers = 5;
                    break switchLabel;
                }
                
            }
            
            case 585 -> {
                
                if (9 <= numTowers) {
                    numSrps = 15;
                    numMoneyTowers = 9;
                    break switchLabel;
                }
                
            }
            
            case 725 -> {
                
                if (11 <= numTowers) {
                    numSrps = 15;
                    numMoneyTowers = 11;
                    break switchLabel;
                }
                
            }
            
            case 790 -> {
                
                if (12 <= numTowers) {
                    numSrps = 15;
                    numMoneyTowers = 12;
                    break switchLabel;
                }
                
            }
            
            case 845 -> {
                
                if (13 <= numTowers) {
                    numSrps = 15;
                    numMoneyTowers = 13;
                    break switchLabel;
                }
                
            }
            
            case 855 -> {
                
                if (13 <= numTowers) {
                    numSrps = 15;
                    numMoneyTowers = 13;
                    break switchLabel;
                }
                
            }
            
            case 920 -> {
                
                if (14 <= numTowers) {
                    numSrps = 15;
                    numMoneyTowers = 14;
                    break switchLabel;
                }
                
                if (10 <= numTowers) {
                    numSrps = 24;
                    numMoneyTowers = 10;
                    break switchLabel;
                }
                
            }
            
            case 975 -> {
                
                if (15 <= numTowers) {
                    numSrps = 15;
                    numMoneyTowers = 15;
                    break switchLabel;
                }
                
            }
            
            case 985 -> {
                
                if (15 <= numTowers) {
                    numSrps = 15;
                    numMoneyTowers = 15;
                    break switchLabel;
                }
                
            }
            
            case 1040 -> {
                
                if (16 <= numTowers) {
                    numSrps = 15;
                    numMoneyTowers = 16;
                    break switchLabel;
                }
                
                if (13 <= numTowers) {
                    numSrps = 20;
                    numMoneyTowers = 13;
                    break switchLabel;
                }
                
            }
            
            case 1105 -> {
                
                if (17 <= numTowers) {
                    numSrps = 15;
                    numMoneyTowers = 17;
                    break switchLabel;
                }
                
            }
            
            case 1115 -> {
                
                if (17 <= numTowers) {
                    numSrps = 15;
                    numMoneyTowers = 17;
                    break switchLabel;
                }
                
            }
            
            case 1170 -> {
                
                if (18 <= numTowers) {
                    numSrps = 15;
                    numMoneyTowers = 18;
                    break switchLabel;
                }
                
            }
            
            case 1235 -> {
                
                if (19 <= numTowers) {
                    numSrps = 15;
                    numMoneyTowers = 19;
                    break switchLabel;
                }
                
            }
            
            case 1245 -> {
                
                if (19 <= numTowers) {
                    numSrps = 15;
                    numMoneyTowers = 19;
                    break switchLabel;
                }
                
                if (15 <= numTowers) {
                    numSrps = 21;
                    numMoneyTowers = 15;
                    break switchLabel;
                }
                
            }
            
            case 1300 -> {
                
                if (20 <= numTowers) {
                    numSrps = 15;
                    numMoneyTowers = 20;
                    break switchLabel;
                }
                
                if (15 <= numTowers) {
                    numSrps = 22;
                    numMoneyTowers = 15;
                    break switchLabel;
                }
                
            }
            
            case 1310 -> {
                
                if (20 <= numTowers) {
                    numSrps = 15;
                    numMoneyTowers = 20;
                    break switchLabel;
                }
                
            }
            
            case 1365 -> {
                
                if (21 <= numTowers) {
                    numSrps = 15;
                    numMoneyTowers = 21;
                    break switchLabel;
                }
                
            }
            
            case 1375 -> {
                
                if (21 <= numTowers) {
                    numSrps = 15;
                    numMoneyTowers = 21;
                    break switchLabel;
                }
                
            }
            
            case 1430 -> {
                
                if (22 <= numTowers) {
                    numSrps = 15;
                    numMoneyTowers = 22;
                    break switchLabel;
                }
                
                if (20 <= numTowers) {
                    numSrps = 17;
                    numMoneyTowers = 20;
                    break switchLabel;
                }
                
            }
            
            case 1440 -> {
                
                if (22 <= numTowers) {
                    numSrps = 15;
                    numMoneyTowers = 22;
                    break switchLabel;
                }
                
                if (18 <= numTowers) {
                    numSrps = 20;
                    numMoneyTowers = 18;
                    break switchLabel;
                }
                
            }
            
            case 1495 -> {
                
                if (23 <= numTowers) {
                    numSrps = 15;
                    numMoneyTowers = 23;
                    break switchLabel;
                }
                
            }
            
            case 1505 -> {
                
                if (23 <= numTowers) {
                    numSrps = 15;
                    numMoneyTowers = 23;
                    break switchLabel;
                }
                
            }
            
            case 1560 -> {
                
                if (24 <= numTowers) {
                    numSrps = 15;
                    numMoneyTowers = 24;
                    break switchLabel;
                }
                
            }
            
            case 1570 -> {
                
                if (24 <= numTowers) {
                    numSrps = 15;
                    numMoneyTowers = 24;
                    break switchLabel;
                }
                
            }
            
            case 136 -> {
                
                if (2 <= numTowers) {
                    numSrps = 16;
                    numMoneyTowers = 2;
                    break switchLabel;
                }
                
            }
            
            case 146 -> {
                
                if (2 <= numTowers) {
                    numSrps = 16;
                    numMoneyTowers = 2;
                    break switchLabel;
                }
                
            }
            
            case 204 -> {
                
                if (3 <= numTowers) {
                    numSrps = 16;
                    numMoneyTowers = 3;
                    break switchLabel;
                }
                
            }
            
            case 214 -> {
                
                if (3 <= numTowers) {
                    numSrps = 16;
                    numMoneyTowers = 3;
                    break switchLabel;
                }
                
            }
            
            case 272 -> {
                
                if (4 <= numTowers) {
                    numSrps = 16;
                    numMoneyTowers = 4;
                    break switchLabel;
                }
                
            }
            
            case 408 -> {
                
                if (6 <= numTowers) {
                    numSrps = 16;
                    numMoneyTowers = 6;
                    break switchLabel;
                }
                
            }
            
            case 476 -> {
                
                if (7 <= numTowers) {
                    numSrps = 16;
                    numMoneyTowers = 7;
                    break switchLabel;
                }
                
            }
            
            case 486 -> {
                
                if (7 <= numTowers) {
                    numSrps = 16;
                    numMoneyTowers = 7;
                    break switchLabel;
                }
                
            }
            
            case 612 -> {
                
                if (9 <= numTowers) {
                    numSrps = 16;
                    numMoneyTowers = 9;
                    break switchLabel;
                }
                
                if (7 <= numTowers) {
                    numSrps = 22;
                    numMoneyTowers = 7;
                    break switchLabel;
                }
                
            }
            
            case 622 -> {
                
                if (9 <= numTowers) {
                    numSrps = 16;
                    numMoneyTowers = 9;
                    break switchLabel;
                }
                
            }
            
            case 680 -> {
                
                if (10 <= numTowers) {
                    numSrps = 16;
                    numMoneyTowers = 10;
                    break switchLabel;
                }
                
            }
            
            case 690 -> {
                
                if (10 <= numTowers) {
                    numSrps = 16;
                    numMoneyTowers = 10;
                    break switchLabel;
                }
                
            }
            
            case 894 -> {
                
                if (13 <= numTowers) {
                    numSrps = 16;
                    numMoneyTowers = 13;
                    break switchLabel;
                }
                
            }
            
            case 1020 -> {
                
                if (15 <= numTowers) {
                    numSrps = 16;
                    numMoneyTowers = 15;
                    break switchLabel;
                }
                
            }
            
            case 1030 -> {
                
                if (15 <= numTowers) {
                    numSrps = 16;
                    numMoneyTowers = 15;
                    break switchLabel;
                }
                
            }
            
            case 1088 -> {
                
                if (16 <= numTowers) {
                    numSrps = 16;
                    numMoneyTowers = 16;
                    break switchLabel;
                }
                
                if (14 <= numTowers) {
                    numSrps = 19;
                    numMoneyTowers = 14;
                    break switchLabel;
                }
                
            }
            
            case 1098 -> {
                
                if (16 <= numTowers) {
                    numSrps = 16;
                    numMoneyTowers = 16;
                    break switchLabel;
                }
                
            }
            
            case 1156 -> {
                
                if (17 <= numTowers) {
                    numSrps = 16;
                    numMoneyTowers = 17;
                    break switchLabel;
                }
                
            }
            
            case 1224 -> {
                
                if (18 <= numTowers) {
                    numSrps = 16;
                    numMoneyTowers = 18;
                    break switchLabel;
                }
                
            }
            
            case 1234 -> {
                
                if (18 <= numTowers) {
                    numSrps = 16;
                    numMoneyTowers = 18;
                    break switchLabel;
                }
                
            }
            
            case 1292 -> {
                
                if (19 <= numTowers) {
                    numSrps = 16;
                    numMoneyTowers = 19;
                    break switchLabel;
                }
                
            }
            
            case 1360 -> {
                
                if (20 <= numTowers) {
                    numSrps = 16;
                    numMoneyTowers = 20;
                    break switchLabel;
                }
                
                if (17 <= numTowers) {
                    numSrps = 20;
                    numMoneyTowers = 17;
                    break switchLabel;
                }
                
            }
            
            case 1370 -> {
                
                if (20 <= numTowers) {
                    numSrps = 16;
                    numMoneyTowers = 20;
                    break switchLabel;
                }
                
                if (17 <= numTowers) {
                    numSrps = 20;
                    numMoneyTowers = 17;
                    break switchLabel;
                }
                
            }
            
            case 1428 -> {
                
                if (21 <= numTowers) {
                    numSrps = 16;
                    numMoneyTowers = 21;
                    break switchLabel;
                }
                
            }
            
            case 1438 -> {
                
                if (21 <= numTowers) {
                    numSrps = 16;
                    numMoneyTowers = 21;
                    break switchLabel;
                }
                
            }
            
            case 1496 -> {
                
                if (22 <= numTowers) {
                    numSrps = 16;
                    numMoneyTowers = 22;
                    break switchLabel;
                }
                
            }
            
            case 1506 -> {
                
                if (22 <= numTowers) {
                    numSrps = 16;
                    numMoneyTowers = 22;
                    break switchLabel;
                }
                
            }
            
            case 1564 -> {
                
                if (23 <= numTowers) {
                    numSrps = 16;
                    numMoneyTowers = 23;
                    break switchLabel;
                }
                
                if (21 <= numTowers) {
                    numSrps = 18;
                    numMoneyTowers = 21;
                    break switchLabel;
                }
                
                if (17 <= numTowers) {
                    numSrps = 24;
                    numMoneyTowers = 17;
                    break switchLabel;
                }
                
            }
            
            case 1574 -> {
                
                if (23 <= numTowers) {
                    numSrps = 16;
                    numMoneyTowers = 23;
                    break switchLabel;
                }
                
                if (17 <= numTowers) {
                    numSrps = 24;
                    numMoneyTowers = 17;
                    break switchLabel;
                }
                
            }
            
            case 1632 -> {
                
                if (24 <= numTowers) {
                    numSrps = 16;
                    numMoneyTowers = 24;
                    break switchLabel;
                }
                
            }
            
            case 1642 -> {
                
                if (24 <= numTowers) {
                    numSrps = 16;
                    numMoneyTowers = 24;
                    break switchLabel;
                }
                
            }
            
            case 71 -> {
                
                if (1 <= numTowers) {
                    numSrps = 17;
                    numMoneyTowers = 1;
                    break switchLabel;
                }
                
            }
            
            case 81 -> {
                
                if (1 <= numTowers) {
                    numSrps = 17;
                    numMoneyTowers = 1;
                    break switchLabel;
                }
                
            }
            
            case 223 -> {
                
                if (3 <= numTowers) {
                    numSrps = 17;
                    numMoneyTowers = 3;
                    break switchLabel;
                }
                
            }
            
            case 284 -> {
                
                if (4 <= numTowers) {
                    numSrps = 17;
                    numMoneyTowers = 4;
                    break switchLabel;
                }
                
            }
            
            case 294 -> {
                
                if (4 <= numTowers) {
                    numSrps = 17;
                    numMoneyTowers = 4;
                    break switchLabel;
                }
                
            }
            
            case 365 -> {
                
                if (5 <= numTowers) {
                    numSrps = 17;
                    numMoneyTowers = 5;
                    break switchLabel;
                }
                
            }
            
            case 436 -> {
                
                if (6 <= numTowers) {
                    numSrps = 17;
                    numMoneyTowers = 6;
                    break switchLabel;
                }
                
            }
            
            case 497 -> {
                
                if (7 <= numTowers) {
                    numSrps = 17;
                    numMoneyTowers = 7;
                    break switchLabel;
                }
                
            }
            
            case 507 -> {
                
                if (7 <= numTowers) {
                    numSrps = 17;
                    numMoneyTowers = 7;
                    break switchLabel;
                }
                
            }
            
            case 578 -> {
                
                if (8 <= numTowers) {
                    numSrps = 17;
                    numMoneyTowers = 8;
                    break switchLabel;
                }
                
            }
            
            case 639 -> {
                
                if (9 <= numTowers) {
                    numSrps = 17;
                    numMoneyTowers = 9;
                    break switchLabel;
                }
                
            }
            
            case 720 -> {
                
                if (10 <= numTowers) {
                    numSrps = 17;
                    numMoneyTowers = 10;
                    break switchLabel;
                }
                
                if (9 <= numTowers) {
                    numSrps = 20;
                    numMoneyTowers = 9;
                    break switchLabel;
                }
                
            }
            
            case 781 -> {
                
                if (11 <= numTowers) {
                    numSrps = 17;
                    numMoneyTowers = 11;
                    break switchLabel;
                }
                
            }
            
            case 791 -> {
                
                if (11 <= numTowers) {
                    numSrps = 17;
                    numMoneyTowers = 11;
                    break switchLabel;
                }
                
            }
            
            case 852 -> {
                
                if (12 <= numTowers) {
                    numSrps = 17;
                    numMoneyTowers = 12;
                    break switchLabel;
                }
                
            }
            
            case 862 -> {
                
                if (12 <= numTowers) {
                    numSrps = 17;
                    numMoneyTowers = 12;
                    break switchLabel;
                }
                
            }
            
            case 923 -> {
                
                if (13 <= numTowers) {
                    numSrps = 17;
                    numMoneyTowers = 13;
                    break switchLabel;
                }
                
                if (11 <= numTowers) {
                    numSrps = 21;
                    numMoneyTowers = 11;
                    break switchLabel;
                }
                
            }
            
            case 933 -> {
                
                if (13 <= numTowers) {
                    numSrps = 17;
                    numMoneyTowers = 13;
                    break switchLabel;
                }
                
            }
            
            case 1004 -> {
                
                if (14 <= numTowers) {
                    numSrps = 17;
                    numMoneyTowers = 14;
                    break switchLabel;
                }
                
            }
            
            case 1065 -> {
                
                if (15 <= numTowers) {
                    numSrps = 17;
                    numMoneyTowers = 15;
                    break switchLabel;
                }
                
            }
            
            case 1075 -> {
                
                if (15 <= numTowers) {
                    numSrps = 17;
                    numMoneyTowers = 15;
                    break switchLabel;
                }
                
            }
            
            case 1136 -> {
                
                if (16 <= numTowers) {
                    numSrps = 17;
                    numMoneyTowers = 16;
                    break switchLabel;
                }
                
            }
            
            case 1146 -> {
                
                if (16 <= numTowers) {
                    numSrps = 17;
                    numMoneyTowers = 16;
                    break switchLabel;
                }
                
            }
            
            case 1207 -> {
                
                if (17 <= numTowers) {
                    numSrps = 17;
                    numMoneyTowers = 17;
                    break switchLabel;
                }
                
            }
            
            case 1217 -> {
                
                if (17 <= numTowers) {
                    numSrps = 17;
                    numMoneyTowers = 17;
                    break switchLabel;
                }
                
            }
            
            case 1278 -> {
                
                if (18 <= numTowers) {
                    numSrps = 17;
                    numMoneyTowers = 18;
                    break switchLabel;
                }
                
            }
            
            case 1349 -> {
                
                if (19 <= numTowers) {
                    numSrps = 17;
                    numMoneyTowers = 19;
                    break switchLabel;
                }
                
            }
            
            case 1359 -> {
                
                if (19 <= numTowers) {
                    numSrps = 17;
                    numMoneyTowers = 19;
                    break switchLabel;
                }
                
            }
            
            case 1420 -> {
                
                if (20 <= numTowers) {
                    numSrps = 17;
                    numMoneyTowers = 20;
                    break switchLabel;
                }
                
            }
            
            case 1491 -> {
                
                if (21 <= numTowers) {
                    numSrps = 17;
                    numMoneyTowers = 21;
                    break switchLabel;
                }
                
            }
            
            case 1501 -> {
                
                if (21 <= numTowers) {
                    numSrps = 17;
                    numMoneyTowers = 21;
                    break switchLabel;
                }
                
            }
            
            case 1562 -> {
                
                if (22 <= numTowers) {
                    numSrps = 17;
                    numMoneyTowers = 22;
                    break switchLabel;
                }
                
            }
            
            case 1572 -> {
                
                if (22 <= numTowers) {
                    numSrps = 17;
                    numMoneyTowers = 22;
                    break switchLabel;
                }
                
            }
            
            case 1633 -> {
                
                if (23 <= numTowers) {
                    numSrps = 17;
                    numMoneyTowers = 23;
                    break switchLabel;
                }
                
            }
            
            case 1643 -> {
                
                if (23 <= numTowers) {
                    numSrps = 17;
                    numMoneyTowers = 23;
                    break switchLabel;
                }
                
            }
            
            case 1704 -> {
                
                if (24 <= numTowers) {
                    numSrps = 17;
                    numMoneyTowers = 24;
                    break switchLabel;
                }
                
                if (22 <= numTowers) {
                    numSrps = 19;
                    numMoneyTowers = 22;
                    break switchLabel;
                }
                
            }
            
            case 1714 -> {
                
                if (24 <= numTowers) {
                    numSrps = 17;
                    numMoneyTowers = 24;
                    break switchLabel;
                }
                
            }
            
            case 84 -> {
                
                if (1 <= numTowers) {
                    numSrps = 18;
                    numMoneyTowers = 1;
                    break switchLabel;
                }
                
            }
            
            case 158 -> {
                
                if (2 <= numTowers) {
                    numSrps = 18;
                    numMoneyTowers = 2;
                    break switchLabel;
                }
                
            }
            
            case 306 -> {
                
                if (4 <= numTowers) {
                    numSrps = 18;
                    numMoneyTowers = 4;
                    break switchLabel;
                }
                
            }
            
            case 454 -> {
                
                if (6 <= numTowers) {
                    numSrps = 18;
                    numMoneyTowers = 6;
                    break switchLabel;
                }
                
            }
            
            case 518 -> {
                
                if (7 <= numTowers) {
                    numSrps = 18;
                    numMoneyTowers = 7;
                    break switchLabel;
                }
                
            }
            
            case 592 -> {
                
                if (8 <= numTowers) {
                    numSrps = 18;
                    numMoneyTowers = 8;
                    break switchLabel;
                }
                
            }
            
            case 602 -> {
                
                if (8 <= numTowers) {
                    numSrps = 18;
                    numMoneyTowers = 8;
                    break switchLabel;
                }
                
                if (7 <= numTowers) {
                    numSrps = 22;
                    numMoneyTowers = 7;
                    break switchLabel;
                }
                
            }
            
            case 676 -> {
                
                if (9 <= numTowers) {
                    numSrps = 18;
                    numMoneyTowers = 9;
                    break switchLabel;
                }
                
            }
            
            case 740 -> {
                
                if (10 <= numTowers) {
                    numSrps = 18;
                    numMoneyTowers = 10;
                    break switchLabel;
                }
                
            }
            
            case 814 -> {
                
                if (11 <= numTowers) {
                    numSrps = 18;
                    numMoneyTowers = 11;
                    break switchLabel;
                }
                
            }
            
            case 824 -> {
                
                if (11 <= numTowers) {
                    numSrps = 18;
                    numMoneyTowers = 11;
                    break switchLabel;
                }
                
            }
            
            case 888 -> {
                
                if (12 <= numTowers) {
                    numSrps = 18;
                    numMoneyTowers = 12;
                    break switchLabel;
                }
                
            }
            
            case 898 -> {
                
                if (12 <= numTowers) {
                    numSrps = 18;
                    numMoneyTowers = 12;
                    break switchLabel;
                }
                
            }
            
            case 972 -> {
                
                if (13 <= numTowers) {
                    numSrps = 18;
                    numMoneyTowers = 13;
                    break switchLabel;
                }
                
            }
            
            case 1036 -> {
                
                if (14 <= numTowers) {
                    numSrps = 18;
                    numMoneyTowers = 14;
                    break switchLabel;
                }
                
            }
            
            case 1046 -> {
                
                if (14 <= numTowers) {
                    numSrps = 18;
                    numMoneyTowers = 14;
                    break switchLabel;
                }
                
            }
            
            case 1184 -> {
                
                if (16 <= numTowers) {
                    numSrps = 18;
                    numMoneyTowers = 16;
                    break switchLabel;
                }
                
            }
            
            case 1194 -> {
                
                if (16 <= numTowers) {
                    numSrps = 18;
                    numMoneyTowers = 16;
                    break switchLabel;
                }
                
            }
            
            case 1258 -> {
                
                if (17 <= numTowers) {
                    numSrps = 18;
                    numMoneyTowers = 17;
                    break switchLabel;
                }
                
            }
            
            case 1268 -> {
                
                if (17 <= numTowers) {
                    numSrps = 18;
                    numMoneyTowers = 17;
                    break switchLabel;
                }
                
            }
            
            case 1332 -> {
                
                if (18 <= numTowers) {
                    numSrps = 18;
                    numMoneyTowers = 18;
                    break switchLabel;
                }
                
            }
            
            case 1342 -> {
                
                if (18 <= numTowers) {
                    numSrps = 18;
                    numMoneyTowers = 18;
                    break switchLabel;
                }
                
            }
            
            case 1406 -> {
                
                if (19 <= numTowers) {
                    numSrps = 18;
                    numMoneyTowers = 19;
                    break switchLabel;
                }
                
            }
            
            case 1480 -> {
                
                if (20 <= numTowers) {
                    numSrps = 18;
                    numMoneyTowers = 20;
                    break switchLabel;
                }
                
            }
            
            case 1490 -> {
                
                if (20 <= numTowers) {
                    numSrps = 18;
                    numMoneyTowers = 20;
                    break switchLabel;
                }
                
            }
            
            case 1554 -> {
                
                if (21 <= numTowers) {
                    numSrps = 18;
                    numMoneyTowers = 21;
                    break switchLabel;
                }
                
            }
            
            case 1628 -> {
                
                if (22 <= numTowers) {
                    numSrps = 18;
                    numMoneyTowers = 22;
                    break switchLabel;
                }
                
            }
            
            case 1638 -> {
                
                if (22 <= numTowers) {
                    numSrps = 18;
                    numMoneyTowers = 22;
                    break switchLabel;
                }
                
            }
            
            case 1702 -> {
                
                if (23 <= numTowers) {
                    numSrps = 18;
                    numMoneyTowers = 23;
                    break switchLabel;
                }
                
            }
            
            case 1712 -> {
                
                if (23 <= numTowers) {
                    numSrps = 18;
                    numMoneyTowers = 23;
                    break switchLabel;
                }
                
            }
            
            case 1776 -> {
                
                if (24 <= numTowers) {
                    numSrps = 18;
                    numMoneyTowers = 24;
                    break switchLabel;
                }
                
            }
            
            case 1786 -> {
                
                if (24 <= numTowers) {
                    numSrps = 18;
                    numMoneyTowers = 24;
                    break switchLabel;
                }
                
            }
            
            case 77 -> {
                
                if (1 <= numTowers) {
                    numSrps = 19;
                    numMoneyTowers = 1;
                    break switchLabel;
                }
                
            }
            
            case 154 -> {
                
                if (2 <= numTowers) {
                    numSrps = 19;
                    numMoneyTowers = 2;
                    break switchLabel;
                }
                
            }
            
            case 231 -> {
                
                if (3 <= numTowers) {
                    numSrps = 19;
                    numMoneyTowers = 3;
                    break switchLabel;
                }
                
            }
            
            case 241 -> {
                
                if (3 <= numTowers) {
                    numSrps = 19;
                    numMoneyTowers = 3;
                    break switchLabel;
                }
                
            }
            
            case 462 -> {
                
                if (6 <= numTowers) {
                    numSrps = 19;
                    numMoneyTowers = 6;
                    break switchLabel;
                }
                
            }
            
            case 549 -> {
                
                if (7 <= numTowers) {
                    numSrps = 19;
                    numMoneyTowers = 7;
                    break switchLabel;
                }
                
            }
            
            case 693 -> {
                
                if (9 <= numTowers) {
                    numSrps = 19;
                    numMoneyTowers = 9;
                    break switchLabel;
                }
                
            }
            
            case 703 -> {
                
                if (9 <= numTowers) {
                    numSrps = 19;
                    numMoneyTowers = 9;
                    break switchLabel;
                }
                
            }
            
            case 847 -> {
                
                if (11 <= numTowers) {
                    numSrps = 19;
                    numMoneyTowers = 11;
                    break switchLabel;
                }
                
            }
            
            case 857 -> {
                
                if (11 <= numTowers) {
                    numSrps = 19;
                    numMoneyTowers = 11;
                    break switchLabel;
                }
                
            }
            
            case 1001 -> {
                
                if (13 <= numTowers) {
                    numSrps = 19;
                    numMoneyTowers = 13;
                    break switchLabel;
                }
                
            }
            
            case 1011 -> {
                
                if (13 <= numTowers) {
                    numSrps = 19;
                    numMoneyTowers = 13;
                    break switchLabel;
                }
                
            }
            
            case 1078 -> {
                
                if (14 <= numTowers) {
                    numSrps = 19;
                    numMoneyTowers = 14;
                    break switchLabel;
                }
                
                if (12 <= numTowers) {
                    numSrps = 23;
                    numMoneyTowers = 12;
                    break switchLabel;
                }
                
            }
            
            case 1155 -> {
                
                if (15 <= numTowers) {
                    numSrps = 19;
                    numMoneyTowers = 15;
                    break switchLabel;
                }
                
            }
            
            case 1165 -> {
                
                if (15 <= numTowers) {
                    numSrps = 19;
                    numMoneyTowers = 15;
                    break switchLabel;
                }
                
            }
            
            case 1309 -> {
                
                if (17 <= numTowers) {
                    numSrps = 19;
                    numMoneyTowers = 17;
                    break switchLabel;
                }
                
            }
            
            case 1319 -> {
                
                if (17 <= numTowers) {
                    numSrps = 19;
                    numMoneyTowers = 17;
                    break switchLabel;
                }
                
            }
            
            case 1386 -> {
                
                if (18 <= numTowers) {
                    numSrps = 19;
                    numMoneyTowers = 18;
                    break switchLabel;
                }
                
                if (16 <= numTowers) {
                    numSrps = 22;
                    numMoneyTowers = 16;
                    break switchLabel;
                }
                
            }
            
            case 1396 -> {
                
                if (18 <= numTowers) {
                    numSrps = 19;
                    numMoneyTowers = 18;
                    break switchLabel;
                }
                
            }
            
            case 1463 -> {
                
                if (19 <= numTowers) {
                    numSrps = 19;
                    numMoneyTowers = 19;
                    break switchLabel;
                }
                
            }
            
            case 1473 -> {
                
                if (19 <= numTowers) {
                    numSrps = 19;
                    numMoneyTowers = 19;
                    break switchLabel;
                }
                
            }
            
            case 1540 -> {
                
                if (20 <= numTowers) {
                    numSrps = 19;
                    numMoneyTowers = 20;
                    break switchLabel;
                }
                
            }
            
            case 1550 -> {
                
                if (20 <= numTowers) {
                    numSrps = 19;
                    numMoneyTowers = 20;
                    break switchLabel;
                }
                
            }
            
            case 1617 -> {
                
                if (21 <= numTowers) {
                    numSrps = 19;
                    numMoneyTowers = 21;
                    break switchLabel;
                }
                
            }
            
            case 1627 -> {
                
                if (21 <= numTowers) {
                    numSrps = 19;
                    numMoneyTowers = 21;
                    break switchLabel;
                }
                
            }
            
            case 1694 -> {
                
                if (22 <= numTowers) {
                    numSrps = 19;
                    numMoneyTowers = 22;
                    break switchLabel;
                }
                
            }
            
            case 1771 -> {
                
                if (23 <= numTowers) {
                    numSrps = 19;
                    numMoneyTowers = 23;
                    break switchLabel;
                }
                
            }
            
            case 1781 -> {
                
                if (23 <= numTowers) {
                    numSrps = 19;
                    numMoneyTowers = 23;
                    break switchLabel;
                }
                
            }
            
            case 1848 -> {
                
                if (24 <= numTowers) {
                    numSrps = 19;
                    numMoneyTowers = 24;
                    break switchLabel;
                }
                
            }
            
            case 1858 -> {
                
                if (24 <= numTowers) {
                    numSrps = 19;
                    numMoneyTowers = 24;
                    break switchLabel;
                }
                
            }
            
            case 730 -> {
                
                if (9 <= numTowers) {
                    numSrps = 20;
                    numMoneyTowers = 9;
                    break switchLabel;
                }
                
            }
            
            case 970 -> {
                
                if (12 <= numTowers) {
                    numSrps = 20;
                    numMoneyTowers = 12;
                    break switchLabel;
                }
                
            }
            
            case 1280 -> {
                
                if (16 <= numTowers) {
                    numSrps = 20;
                    numMoneyTowers = 16;
                    break switchLabel;
                }
                
            }
            
            case 1290 -> {
                
                if (16 <= numTowers) {
                    numSrps = 20;
                    numMoneyTowers = 16;
                    break switchLabel;
                }
                
                if (15 <= numTowers) {
                    numSrps = 22;
                    numMoneyTowers = 15;
                    break switchLabel;
                }
                
            }
            
            case 1450 -> {
                
                if (18 <= numTowers) {
                    numSrps = 20;
                    numMoneyTowers = 18;
                    break switchLabel;
                }
                
            }
            
            case 1520 -> {
                
                if (19 <= numTowers) {
                    numSrps = 20;
                    numMoneyTowers = 19;
                    break switchLabel;
                }
                
            }
            
            case 1530 -> {
                
                if (19 <= numTowers) {
                    numSrps = 20;
                    numMoneyTowers = 19;
                    break switchLabel;
                }
                
            }
            
            case 1600 -> {
                
                if (20 <= numTowers) {
                    numSrps = 20;
                    numMoneyTowers = 20;
                    break switchLabel;
                }
                
            }
            
            case 1610 -> {
                
                if (20 <= numTowers) {
                    numSrps = 20;
                    numMoneyTowers = 20;
                    break switchLabel;
                }
                
            }
            
            case 1680 -> {
                
                if (21 <= numTowers) {
                    numSrps = 20;
                    numMoneyTowers = 21;
                    break switchLabel;
                }
                
            }
            
            case 1690 -> {
                
                if (21 <= numTowers) {
                    numSrps = 20;
                    numMoneyTowers = 21;
                    break switchLabel;
                }
                
            }
            
            case 1760 -> {
                
                if (22 <= numTowers) {
                    numSrps = 20;
                    numMoneyTowers = 22;
                    break switchLabel;
                }
                
            }
            
            case 1770 -> {
                
                if (22 <= numTowers) {
                    numSrps = 20;
                    numMoneyTowers = 22;
                    break switchLabel;
                }
                
            }
            
            case 1840 -> {
                
                if (23 <= numTowers) {
                    numSrps = 20;
                    numMoneyTowers = 23;
                    break switchLabel;
                }
                
                if (20 <= numTowers) {
                    numSrps = 24;
                    numMoneyTowers = 20;
                    break switchLabel;
                }
                
            }
            
            case 1850 -> {
                
                if (23 <= numTowers) {
                    numSrps = 20;
                    numMoneyTowers = 23;
                    break switchLabel;
                }
                
                if (20 <= numTowers) {
                    numSrps = 24;
                    numMoneyTowers = 20;
                    break switchLabel;
                }
                
            }
            
            case 1920 -> {
                
                if (24 <= numTowers) {
                    numSrps = 20;
                    numMoneyTowers = 24;
                    break switchLabel;
                }
                
            }
            
            case 1930 -> {
                
                if (24 <= numTowers) {
                    numSrps = 20;
                    numMoneyTowers = 24;
                    break switchLabel;
                }
                
            }
            
            case 83 -> {
                
                if (1 <= numTowers) {
                    numSrps = 21;
                    numMoneyTowers = 1;
                    break switchLabel;
                }
                
            }
            
            case 93 -> {
                
                if (1 <= numTowers) {
                    numSrps = 21;
                    numMoneyTowers = 1;
                    break switchLabel;
                }
                
            }
            
            case 249 -> {
                
                if (3 <= numTowers) {
                    numSrps = 21;
                    numMoneyTowers = 3;
                    break switchLabel;
                }
                
            }
            
            case 259 -> {
                
                if (3 <= numTowers) {
                    numSrps = 21;
                    numMoneyTowers = 3;
                    break switchLabel;
                }
                
            }
            
            case 415 -> {
                
                if (5 <= numTowers) {
                    numSrps = 21;
                    numMoneyTowers = 5;
                    break switchLabel;
                }
                
            }
            
            case 425 -> {
                
                if (5 <= numTowers) {
                    numSrps = 21;
                    numMoneyTowers = 5;
                    break switchLabel;
                }
                
            }
            
            case 498 -> {
                
                if (6 <= numTowers) {
                    numSrps = 21;
                    numMoneyTowers = 6;
                    break switchLabel;
                }
                
            }
            
            case 508 -> {
                
                if (6 <= numTowers) {
                    numSrps = 21;
                    numMoneyTowers = 6;
                    break switchLabel;
                }
                
            }
            
            case 581 -> {
                
                if (7 <= numTowers) {
                    numSrps = 21;
                    numMoneyTowers = 7;
                    break switchLabel;
                }
                
            }
            
            case 591 -> {
                
                if (7 <= numTowers) {
                    numSrps = 21;
                    numMoneyTowers = 7;
                    break switchLabel;
                }
                
            }
            
            case 664 -> {
                
                if (8 <= numTowers) {
                    numSrps = 21;
                    numMoneyTowers = 8;
                    break switchLabel;
                }
                
            }
            
            case 674 -> {
                
                if (8 <= numTowers) {
                    numSrps = 21;
                    numMoneyTowers = 8;
                    break switchLabel;
                }
                
            }
            
            case 747 -> {
                
                if (9 <= numTowers) {
                    numSrps = 21;
                    numMoneyTowers = 9;
                    break switchLabel;
                }
                
            }
            
            case 757 -> {
                
                if (9 <= numTowers) {
                    numSrps = 21;
                    numMoneyTowers = 9;
                    break switchLabel;
                }
                
            }
            
            case 913 -> {
                
                if (11 <= numTowers) {
                    numSrps = 21;
                    numMoneyTowers = 11;
                    break switchLabel;
                }
                
            }
            
            case 996 -> {
                
                if (12 <= numTowers) {
                    numSrps = 21;
                    numMoneyTowers = 12;
                    break switchLabel;
                }
                
            }
            
            case 1006 -> {
                
                if (12 <= numTowers) {
                    numSrps = 21;
                    numMoneyTowers = 12;
                    break switchLabel;
                }
                
            }
            
            case 1079 -> {
                
                if (13 <= numTowers) {
                    numSrps = 21;
                    numMoneyTowers = 13;
                    break switchLabel;
                }
                
            }
            
            case 1089 -> {
                
                if (13 <= numTowers) {
                    numSrps = 21;
                    numMoneyTowers = 13;
                    break switchLabel;
                }
                
            }
            
            case 1162 -> {
                
                if (14 <= numTowers) {
                    numSrps = 21;
                    numMoneyTowers = 14;
                    break switchLabel;
                }
                
            }
            
            case 1172 -> {
                
                if (14 <= numTowers) {
                    numSrps = 21;
                    numMoneyTowers = 14;
                    break switchLabel;
                }
                
            }
            
            case 1255 -> {
                
                if (15 <= numTowers) {
                    numSrps = 21;
                    numMoneyTowers = 15;
                    break switchLabel;
                }
                
            }
            
            case 1328 -> {
                
                if (16 <= numTowers) {
                    numSrps = 21;
                    numMoneyTowers = 16;
                    break switchLabel;
                }
                
            }
            
            case 1338 -> {
                
                if (16 <= numTowers) {
                    numSrps = 21;
                    numMoneyTowers = 16;
                    break switchLabel;
                }
                
            }
            
            case 1411 -> {
                
                if (17 <= numTowers) {
                    numSrps = 21;
                    numMoneyTowers = 17;
                    break switchLabel;
                }
                
            }
            
            case 1421 -> {
                
                if (17 <= numTowers) {
                    numSrps = 21;
                    numMoneyTowers = 17;
                    break switchLabel;
                }
                
            }
            
            case 1494 -> {
                
                if (18 <= numTowers) {
                    numSrps = 21;
                    numMoneyTowers = 18;
                    break switchLabel;
                }
                
            }
            
            case 1504 -> {
                
                if (18 <= numTowers) {
                    numSrps = 21;
                    numMoneyTowers = 18;
                    break switchLabel;
                }
                
            }
            
            case 1577 -> {
                
                if (19 <= numTowers) {
                    numSrps = 21;
                    numMoneyTowers = 19;
                    break switchLabel;
                }
                
            }
            
            case 1587 -> {
                
                if (19 <= numTowers) {
                    numSrps = 21;
                    numMoneyTowers = 19;
                    break switchLabel;
                }
                
            }
            
            case 1660 -> {
                
                if (20 <= numTowers) {
                    numSrps = 21;
                    numMoneyTowers = 20;
                    break switchLabel;
                }
                
            }
            
            case 1670 -> {
                
                if (20 <= numTowers) {
                    numSrps = 21;
                    numMoneyTowers = 20;
                    break switchLabel;
                }
                
            }
            
            case 1743 -> {
                
                if (21 <= numTowers) {
                    numSrps = 21;
                    numMoneyTowers = 21;
                    break switchLabel;
                }
                
            }
            
            case 1753 -> {
                
                if (21 <= numTowers) {
                    numSrps = 21;
                    numMoneyTowers = 21;
                    break switchLabel;
                }
                
            }
            
            case 1826 -> {
                
                if (22 <= numTowers) {
                    numSrps = 21;
                    numMoneyTowers = 22;
                    break switchLabel;
                }
                
            }
            
            case 1836 -> {
                
                if (22 <= numTowers) {
                    numSrps = 21;
                    numMoneyTowers = 22;
                    break switchLabel;
                }
                
            }
            
            case 1909 -> {
                
                if (23 <= numTowers) {
                    numSrps = 21;
                    numMoneyTowers = 23;
                    break switchLabel;
                }
                
            }
            
            case 1919 -> {
                
                if (23 <= numTowers) {
                    numSrps = 21;
                    numMoneyTowers = 23;
                    break switchLabel;
                }
                
            }
            
            case 1992 -> {
                
                if (24 <= numTowers) {
                    numSrps = 21;
                    numMoneyTowers = 24;
                    break switchLabel;
                }
                
            }
            
            case 2002 -> {
                
                if (24 <= numTowers) {
                    numSrps = 21;
                    numMoneyTowers = 24;
                    break switchLabel;
                }
                
            }
            
            case 172 -> {
                
                if (2 <= numTowers) {
                    numSrps = 22;
                    numMoneyTowers = 2;
                    break switchLabel;
                }
                
            }
            
            case 268 -> {
                
                if (3 <= numTowers) {
                    numSrps = 22;
                    numMoneyTowers = 3;
                    break switchLabel;
                }
                
            }
            
            case 344 -> {
                
                if (4 <= numTowers) {
                    numSrps = 22;
                    numMoneyTowers = 4;
                    break switchLabel;
                }
                
            }
            
            case 526 -> {
                
                if (6 <= numTowers) {
                    numSrps = 22;
                    numMoneyTowers = 6;
                    break switchLabel;
                }
                
            }
            
            case 688 -> {
                
                if (8 <= numTowers) {
                    numSrps = 22;
                    numMoneyTowers = 8;
                    break switchLabel;
                }
                
            }
            
            case 698 -> {
                
                if (8 <= numTowers) {
                    numSrps = 22;
                    numMoneyTowers = 8;
                    break switchLabel;
                }
                
            }
            
            case 774 -> {
                
                if (9 <= numTowers) {
                    numSrps = 22;
                    numMoneyTowers = 9;
                    break switchLabel;
                }
                
            }
            
            case 870 -> {
                
                if (10 <= numTowers) {
                    numSrps = 22;
                    numMoneyTowers = 10;
                    break switchLabel;
                }
                
            }
            
            case 946 -> {
                
                if (11 <= numTowers) {
                    numSrps = 22;
                    numMoneyTowers = 11;
                    break switchLabel;
                }
                
            }
            
            case 956 -> {
                
                if (11 <= numTowers) {
                    numSrps = 22;
                    numMoneyTowers = 11;
                    break switchLabel;
                }
                
            }
            
            case 1032 -> {
                
                if (12 <= numTowers) {
                    numSrps = 22;
                    numMoneyTowers = 12;
                    break switchLabel;
                }
                
            }
            
            case 1042 -> {
                
                if (12 <= numTowers) {
                    numSrps = 22;
                    numMoneyTowers = 12;
                    break switchLabel;
                }
                
            }
            
            case 1118 -> {
                
                if (13 <= numTowers) {
                    numSrps = 22;
                    numMoneyTowers = 13;
                    break switchLabel;
                }
                
            }
            
            case 1204 -> {
                
                if (14 <= numTowers) {
                    numSrps = 22;
                    numMoneyTowers = 14;
                    break switchLabel;
                }
                
            }
            
            case 1214 -> {
                
                if (14 <= numTowers) {
                    numSrps = 22;
                    numMoneyTowers = 14;
                    break switchLabel;
                }
                
            }
            
            case 1376 -> {
                
                if (16 <= numTowers) {
                    numSrps = 22;
                    numMoneyTowers = 16;
                    break switchLabel;
                }
                
            }
            
            case 1462 -> {
                
                if (17 <= numTowers) {
                    numSrps = 22;
                    numMoneyTowers = 17;
                    break switchLabel;
                }
                
            }
            
            case 1472 -> {
                
                if (17 <= numTowers) {
                    numSrps = 22;
                    numMoneyTowers = 17;
                    break switchLabel;
                }
                
                if (16 <= numTowers) {
                    numSrps = 24;
                    numMoneyTowers = 16;
                    break switchLabel;
                }
                
            }
            
            case 1548 -> {
                
                if (18 <= numTowers) {
                    numSrps = 22;
                    numMoneyTowers = 18;
                    break switchLabel;
                }
                
            }
            
            case 1558 -> {
                
                if (18 <= numTowers) {
                    numSrps = 22;
                    numMoneyTowers = 18;
                    break switchLabel;
                }
                
            }
            
            case 1634 -> {
                
                if (19 <= numTowers) {
                    numSrps = 22;
                    numMoneyTowers = 19;
                    break switchLabel;
                }
                
            }
            
            case 1644 -> {
                
                if (19 <= numTowers) {
                    numSrps = 22;
                    numMoneyTowers = 19;
                    break switchLabel;
                }
                
            }
            
            case 1720 -> {
                
                if (20 <= numTowers) {
                    numSrps = 22;
                    numMoneyTowers = 20;
                    break switchLabel;
                }
                
            }
            
            case 1730 -> {
                
                if (20 <= numTowers) {
                    numSrps = 22;
                    numMoneyTowers = 20;
                    break switchLabel;
                }
                
            }
            
            case 1806 -> {
                
                if (21 <= numTowers) {
                    numSrps = 22;
                    numMoneyTowers = 21;
                    break switchLabel;
                }
                
            }
            
            case 1816 -> {
                
                if (21 <= numTowers) {
                    numSrps = 22;
                    numMoneyTowers = 21;
                    break switchLabel;
                }
                
            }
            
            case 1892 -> {
                
                if (22 <= numTowers) {
                    numSrps = 22;
                    numMoneyTowers = 22;
                    break switchLabel;
                }
                
            }
            
            case 1902 -> {
                
                if (22 <= numTowers) {
                    numSrps = 22;
                    numMoneyTowers = 22;
                    break switchLabel;
                }
                
            }
            
            case 1978 -> {
                
                if (23 <= numTowers) {
                    numSrps = 22;
                    numMoneyTowers = 23;
                    break switchLabel;
                }
                
            }
            
            case 1988 -> {
                
                if (23 <= numTowers) {
                    numSrps = 22;
                    numMoneyTowers = 23;
                    break switchLabel;
                }
                
            }
            
            case 2064 -> {
                
                if (24 <= numTowers) {
                    numSrps = 22;
                    numMoneyTowers = 24;
                    break switchLabel;
                }
                
            }
            
            case 2074 -> {
                
                if (24 <= numTowers) {
                    numSrps = 22;
                    numMoneyTowers = 24;
                    break switchLabel;
                }
                
            }
            
            case 89 -> {
                
                if (1 <= numTowers) {
                    numSrps = 23;
                    numMoneyTowers = 1;
                    break switchLabel;
                }
                
            }
            
            case 99 -> {
                
                if (1 <= numTowers) {
                    numSrps = 23;
                    numMoneyTowers = 1;
                    break switchLabel;
                }
                
            }
            
            case 267 -> {
                
                if (3 <= numTowers) {
                    numSrps = 23;
                    numMoneyTowers = 3;
                    break switchLabel;
                }
                
            }
            
            case 277 -> {
                
                if (3 <= numTowers) {
                    numSrps = 23;
                    numMoneyTowers = 3;
                    break switchLabel;
                }
                
            }
            
            case 356 -> {
                
                if (4 <= numTowers) {
                    numSrps = 23;
                    numMoneyTowers = 4;
                    break switchLabel;
                }
                
            }
            
            case 366 -> {
                
                if (4 <= numTowers) {
                    numSrps = 23;
                    numMoneyTowers = 4;
                    break switchLabel;
                }
                
            }
            
            case 534 -> {
                
                if (6 <= numTowers) {
                    numSrps = 23;
                    numMoneyTowers = 6;
                    break switchLabel;
                }
                
            }
            
            case 623 -> {
                
                if (7 <= numTowers) {
                    numSrps = 23;
                    numMoneyTowers = 7;
                    break switchLabel;
                }
                
            }
            
            case 633 -> {
                
                if (7 <= numTowers) {
                    numSrps = 23;
                    numMoneyTowers = 7;
                    break switchLabel;
                }
                
            }
            
            case 712 -> {
                
                if (8 <= numTowers) {
                    numSrps = 23;
                    numMoneyTowers = 8;
                    break switchLabel;
                }
                
            }
            
            case 801 -> {
                
                if (9 <= numTowers) {
                    numSrps = 23;
                    numMoneyTowers = 9;
                    break switchLabel;
                }
                
            }
            
            case 811 -> {
                
                if (9 <= numTowers) {
                    numSrps = 23;
                    numMoneyTowers = 9;
                    break switchLabel;
                }
                
            }
            
            case 979 -> {
                
                if (11 <= numTowers) {
                    numSrps = 23;
                    numMoneyTowers = 11;
                    break switchLabel;
                }
                
            }
            
            case 989 -> {
                
                if (11 <= numTowers) {
                    numSrps = 23;
                    numMoneyTowers = 11;
                    break switchLabel;
                }
                
            }
            
            case 1068 -> {
                
                if (12 <= numTowers) {
                    numSrps = 23;
                    numMoneyTowers = 12;
                    break switchLabel;
                }
                
            }
            
            case 1157 -> {
                
                if (13 <= numTowers) {
                    numSrps = 23;
                    numMoneyTowers = 13;
                    break switchLabel;
                }
                
            }
            
            case 1167 -> {
                
                if (13 <= numTowers) {
                    numSrps = 23;
                    numMoneyTowers = 13;
                    break switchLabel;
                }
                
            }
            
            case 1246 -> {
                
                if (14 <= numTowers) {
                    numSrps = 23;
                    numMoneyTowers = 14;
                    break switchLabel;
                }
                
            }
            
            case 1256 -> {
                
                if (14 <= numTowers) {
                    numSrps = 23;
                    numMoneyTowers = 14;
                    break switchLabel;
                }
                
            }
            
            case 1335 -> {
                
                if (15 <= numTowers) {
                    numSrps = 23;
                    numMoneyTowers = 15;
                    break switchLabel;
                }
                
            }
            
            case 1345 -> {
                
                if (15 <= numTowers) {
                    numSrps = 23;
                    numMoneyTowers = 15;
                    break switchLabel;
                }
                
            }
            
            case 1424 -> {
                
                if (16 <= numTowers) {
                    numSrps = 23;
                    numMoneyTowers = 16;
                    break switchLabel;
                }
                
            }
            
            case 1434 -> {
                
                if (16 <= numTowers) {
                    numSrps = 23;
                    numMoneyTowers = 16;
                    break switchLabel;
                }
                
            }
            
            case 1513 -> {
                
                if (17 <= numTowers) {
                    numSrps = 23;
                    numMoneyTowers = 17;
                    break switchLabel;
                }
                
            }
            
            case 1523 -> {
                
                if (17 <= numTowers) {
                    numSrps = 23;
                    numMoneyTowers = 17;
                    break switchLabel;
                }
                
            }
            
            case 1602 -> {
                
                if (18 <= numTowers) {
                    numSrps = 23;
                    numMoneyTowers = 18;
                    break switchLabel;
                }
                
            }
            
            case 1612 -> {
                
                if (18 <= numTowers) {
                    numSrps = 23;
                    numMoneyTowers = 18;
                    break switchLabel;
                }
                
            }
            
            case 1691 -> {
                
                if (19 <= numTowers) {
                    numSrps = 23;
                    numMoneyTowers = 19;
                    break switchLabel;
                }
                
            }
            
            case 1701 -> {
                
                if (19 <= numTowers) {
                    numSrps = 23;
                    numMoneyTowers = 19;
                    break switchLabel;
                }
                
            }
            
            case 1780 -> {
                
                if (20 <= numTowers) {
                    numSrps = 23;
                    numMoneyTowers = 20;
                    break switchLabel;
                }
                
            }
            
            case 1790 -> {
                
                if (20 <= numTowers) {
                    numSrps = 23;
                    numMoneyTowers = 20;
                    break switchLabel;
                }
                
            }
            
            case 1869 -> {
                
                if (21 <= numTowers) {
                    numSrps = 23;
                    numMoneyTowers = 21;
                    break switchLabel;
                }
                
            }
            
            case 1879 -> {
                
                if (21 <= numTowers) {
                    numSrps = 23;
                    numMoneyTowers = 21;
                    break switchLabel;
                }
                
            }
            
            case 1958 -> {
                
                if (22 <= numTowers) {
                    numSrps = 23;
                    numMoneyTowers = 22;
                    break switchLabel;
                }
                
            }
            
            case 1968 -> {
                
                if (22 <= numTowers) {
                    numSrps = 23;
                    numMoneyTowers = 22;
                    break switchLabel;
                }
                
            }
            
            case 2047 -> {
                
                if (23 <= numTowers) {
                    numSrps = 23;
                    numMoneyTowers = 23;
                    break switchLabel;
                }
                
            }
            
            case 2057 -> {
                
                if (23 <= numTowers) {
                    numSrps = 23;
                    numMoneyTowers = 23;
                    break switchLabel;
                }
                
            }
            
            case 2136 -> {
                
                if (24 <= numTowers) {
                    numSrps = 23;
                    numMoneyTowers = 24;
                    break switchLabel;
                }
                
            }
            
            case 2146 -> {
                
                if (24 <= numTowers) {
                    numSrps = 23;
                    numMoneyTowers = 24;
                    break switchLabel;
                }
                
            }
            
            case 644 -> {
                
                if (7 <= numTowers) {
                    numSrps = 24;
                    numMoneyTowers = 7;
                    break switchLabel;
                }
                
            }
            
            case 654 -> {
                
                if (7 <= numTowers) {
                    numSrps = 24;
                    numMoneyTowers = 7;
                    break switchLabel;
                }
                
            }
            
            case 828 -> {
                
                if (9 <= numTowers) {
                    numSrps = 24;
                    numMoneyTowers = 9;
                    break switchLabel;
                }
                
            }
            
            case 838 -> {
                
                if (9 <= numTowers) {
                    numSrps = 24;
                    numMoneyTowers = 9;
                    break switchLabel;
                }
                
            }
            
            case 1104 -> {
                
                if (12 <= numTowers) {
                    numSrps = 24;
                    numMoneyTowers = 12;
                    break switchLabel;
                }
                
            }
            
            case 1114 -> {
                
                if (12 <= numTowers) {
                    numSrps = 24;
                    numMoneyTowers = 12;
                    break switchLabel;
                }
                
            }
            
            case 1196 -> {
                
                if (13 <= numTowers) {
                    numSrps = 24;
                    numMoneyTowers = 13;
                    break switchLabel;
                }
                
            }
            
            case 1206 -> {
                
                if (13 <= numTowers) {
                    numSrps = 24;
                    numMoneyTowers = 13;
                    break switchLabel;
                }
                
            }
            
            case 1380 -> {
                
                if (15 <= numTowers) {
                    numSrps = 24;
                    numMoneyTowers = 15;
                    break switchLabel;
                }
                
            }
            
            case 1390 -> {
                
                if (15 <= numTowers) {
                    numSrps = 24;
                    numMoneyTowers = 15;
                    break switchLabel;
                }
                
            }
            
            case 1482 -> {
                
                if (16 <= numTowers) {
                    numSrps = 24;
                    numMoneyTowers = 16;
                    break switchLabel;
                }
                
            }
            
            case 1656 -> {
                
                if (18 <= numTowers) {
                    numSrps = 24;
                    numMoneyTowers = 18;
                    break switchLabel;
                }
                
            }
            
            case 1666 -> {
                
                if (18 <= numTowers) {
                    numSrps = 24;
                    numMoneyTowers = 18;
                    break switchLabel;
                }
                
            }
            
            case 1748 -> {
                
                if (19 <= numTowers) {
                    numSrps = 24;
                    numMoneyTowers = 19;
                    break switchLabel;
                }
                
            }
            
            case 1758 -> {
                
                if (19 <= numTowers) {
                    numSrps = 24;
                    numMoneyTowers = 19;
                    break switchLabel;
                }
                
            }
            
            case 1932 -> {
                
                if (21 <= numTowers) {
                    numSrps = 24;
                    numMoneyTowers = 21;
                    break switchLabel;
                }
                
            }
            
            case 1942 -> {
                
                if (21 <= numTowers) {
                    numSrps = 24;
                    numMoneyTowers = 21;
                    break switchLabel;
                }
                
            }
            
            case 2024 -> {
                
                if (22 <= numTowers) {
                    numSrps = 24;
                    numMoneyTowers = 22;
                    break switchLabel;
                }
                
            }
            
            case 2034 -> {
                
                if (22 <= numTowers) {
                    numSrps = 24;
                    numMoneyTowers = 22;
                    break switchLabel;
                }
                
            }
            
            case 2116 -> {
                
                if (23 <= numTowers) {
                    numSrps = 24;
                    numMoneyTowers = 23;
                    break switchLabel;
                }
                
            }
            
            case 2126 -> {
                
                if (23 <= numTowers) {
                    numSrps = 24;
                    numMoneyTowers = 23;
                    break switchLabel;
                }
                
            }
            
            case 2208 -> {
                
                if (24 <= numTowers) {
                    numSrps = 24;
                    numMoneyTowers = 24;
                    break switchLabel;
                }
                
            }
            
            case 2218 -> {
                
                if (24 <= numTowers) {
                    numSrps = 24;
                    numMoneyTowers = 24;
                    break switchLabel;
                }
                
            }
            
            default -> {
                return;
            }
        }
        numPaintTowers = numTowers - numMoneyTowers;
    }
}