package jan11_5_59;
import java.util.Random;
import battlecode.common.*;

public class Globals {
    public static RobotController rc;
    public static final Random rng = new Random();
    public static void init(RobotController rc) {
        rng.setSeed((long) rc.getID());
        Globals.rc = rc;
    }

    public static RobotInfo[] friends;
    public static RobotInfo[] enemies;
    public static void run() throws GameActionException {
        friends = rc.senseNearbyRobots(-1, rc.getTeam());
        enemies = rc.senseNearbyRobots(-1, rc.getTeam().opponent());
    }

    public static boolean seeIncompleteRuin(MapLocation ruin) throws GameActionException {
        MapLocation tmp;
        UnitType t = getTowerToBuild();
        boolean[][] pattern = rc.getTowerPattern(t);
        
        
        
        tmp = new MapLocation(ruin.x + 2, ruin.y + 2);
        if (rc.canSenseLocation(tmp)) {
            MapInfo mi = rc.senseMapInfo(tmp);
            switch (mi.getPaint()) {
                case ENEMY_SECONDARY, ENEMY_PRIMARY -> {}
                default -> {
                    boolean isSecondary = (mi.getPaint() == PaintType.ALLY_SECONDARY);
                    boolean targetSecondary = pattern[4][4];
                    if ((mi.getPaint() == PaintType.EMPTY) || (isSecondary != targetSecondary)) {
                        return true;
                    }
                }
            }
        }
        
        
        
        tmp = new MapLocation(ruin.x + 2, ruin.y + 1);
        if (rc.canSenseLocation(tmp)) {
            MapInfo mi = rc.senseMapInfo(tmp);
            switch (mi.getPaint()) {
                case ENEMY_SECONDARY, ENEMY_PRIMARY -> {}
                default -> {
                    boolean isSecondary = (mi.getPaint() == PaintType.ALLY_SECONDARY);
                    boolean targetSecondary = pattern[4][3];
                    if ((mi.getPaint() == PaintType.EMPTY) || (isSecondary != targetSecondary)) {
                        return true;
                    }
                }
            }
        }
        
        
        
        tmp = new MapLocation(ruin.x + 2, ruin.y + 0);
        if (rc.canSenseLocation(tmp)) {
            MapInfo mi = rc.senseMapInfo(tmp);
            switch (mi.getPaint()) {
                case ENEMY_SECONDARY, ENEMY_PRIMARY -> {}
                default -> {
                    boolean isSecondary = (mi.getPaint() == PaintType.ALLY_SECONDARY);
                    boolean targetSecondary = pattern[4][2];
                    if ((mi.getPaint() == PaintType.EMPTY) || (isSecondary != targetSecondary)) {
                        return true;
                    }
                }
            }
        }
        
        
        
        tmp = new MapLocation(ruin.x + 2, ruin.y + -1);
        if (rc.canSenseLocation(tmp)) {
            MapInfo mi = rc.senseMapInfo(tmp);
            switch (mi.getPaint()) {
                case ENEMY_SECONDARY, ENEMY_PRIMARY -> {}
                default -> {
                    boolean isSecondary = (mi.getPaint() == PaintType.ALLY_SECONDARY);
                    boolean targetSecondary = pattern[4][1];
                    if ((mi.getPaint() == PaintType.EMPTY) || (isSecondary != targetSecondary)) {
                        return true;
                    }
                }
            }
        }
        
        
        
        tmp = new MapLocation(ruin.x + 2, ruin.y + -2);
        if (rc.canSenseLocation(tmp)) {
            MapInfo mi = rc.senseMapInfo(tmp);
            switch (mi.getPaint()) {
                case ENEMY_SECONDARY, ENEMY_PRIMARY -> {}
                default -> {
                    boolean isSecondary = (mi.getPaint() == PaintType.ALLY_SECONDARY);
                    boolean targetSecondary = pattern[4][0];
                    if ((mi.getPaint() == PaintType.EMPTY) || (isSecondary != targetSecondary)) {
                        return true;
                    }
                }
            }
        }
        
        
        
        
        
        tmp = new MapLocation(ruin.x + 1, ruin.y + 2);
        if (rc.canSenseLocation(tmp)) {
            MapInfo mi = rc.senseMapInfo(tmp);
            switch (mi.getPaint()) {
                case ENEMY_SECONDARY, ENEMY_PRIMARY -> {}
                default -> {
                    boolean isSecondary = (mi.getPaint() == PaintType.ALLY_SECONDARY);
                    boolean targetSecondary = pattern[3][4];
                    if ((mi.getPaint() == PaintType.EMPTY) || (isSecondary != targetSecondary)) {
                        return true;
                    }
                }
            }
        }
        
        
        
        tmp = new MapLocation(ruin.x + 1, ruin.y + 1);
        if (rc.canSenseLocation(tmp)) {
            MapInfo mi = rc.senseMapInfo(tmp);
            switch (mi.getPaint()) {
                case ENEMY_SECONDARY, ENEMY_PRIMARY -> {}
                default -> {
                    boolean isSecondary = (mi.getPaint() == PaintType.ALLY_SECONDARY);
                    boolean targetSecondary = pattern[3][3];
                    if ((mi.getPaint() == PaintType.EMPTY) || (isSecondary != targetSecondary)) {
                        return true;
                    }
                }
            }
        }
        
        
        
        tmp = new MapLocation(ruin.x + 1, ruin.y + 0);
        if (rc.canSenseLocation(tmp)) {
            MapInfo mi = rc.senseMapInfo(tmp);
            switch (mi.getPaint()) {
                case ENEMY_SECONDARY, ENEMY_PRIMARY -> {}
                default -> {
                    boolean isSecondary = (mi.getPaint() == PaintType.ALLY_SECONDARY);
                    boolean targetSecondary = pattern[3][2];
                    if ((mi.getPaint() == PaintType.EMPTY) || (isSecondary != targetSecondary)) {
                        return true;
                    }
                }
            }
        }
        
        
        
        tmp = new MapLocation(ruin.x + 1, ruin.y + -1);
        if (rc.canSenseLocation(tmp)) {
            MapInfo mi = rc.senseMapInfo(tmp);
            switch (mi.getPaint()) {
                case ENEMY_SECONDARY, ENEMY_PRIMARY -> {}
                default -> {
                    boolean isSecondary = (mi.getPaint() == PaintType.ALLY_SECONDARY);
                    boolean targetSecondary = pattern[3][1];
                    if ((mi.getPaint() == PaintType.EMPTY) || (isSecondary != targetSecondary)) {
                        return true;
                    }
                }
            }
        }
        
        
        
        tmp = new MapLocation(ruin.x + 1, ruin.y + -2);
        if (rc.canSenseLocation(tmp)) {
            MapInfo mi = rc.senseMapInfo(tmp);
            switch (mi.getPaint()) {
                case ENEMY_SECONDARY, ENEMY_PRIMARY -> {}
                default -> {
                    boolean isSecondary = (mi.getPaint() == PaintType.ALLY_SECONDARY);
                    boolean targetSecondary = pattern[3][0];
                    if ((mi.getPaint() == PaintType.EMPTY) || (isSecondary != targetSecondary)) {
                        return true;
                    }
                }
            }
        }
        
        
        
        
        
        tmp = new MapLocation(ruin.x + 0, ruin.y + 2);
        if (rc.canSenseLocation(tmp)) {
            MapInfo mi = rc.senseMapInfo(tmp);
            switch (mi.getPaint()) {
                case ENEMY_SECONDARY, ENEMY_PRIMARY -> {}
                default -> {
                    boolean isSecondary = (mi.getPaint() == PaintType.ALLY_SECONDARY);
                    boolean targetSecondary = pattern[2][4];
                    if ((mi.getPaint() == PaintType.EMPTY) || (isSecondary != targetSecondary)) {
                        return true;
                    }
                }
            }
        }
        
        
        
        tmp = new MapLocation(ruin.x + 0, ruin.y + 1);
        if (rc.canSenseLocation(tmp)) {
            MapInfo mi = rc.senseMapInfo(tmp);
            switch (mi.getPaint()) {
                case ENEMY_SECONDARY, ENEMY_PRIMARY -> {}
                default -> {
                    boolean isSecondary = (mi.getPaint() == PaintType.ALLY_SECONDARY);
                    boolean targetSecondary = pattern[2][3];
                    if ((mi.getPaint() == PaintType.EMPTY) || (isSecondary != targetSecondary)) {
                        return true;
                    }
                }
            }
        }
        
        
        
        
        
        tmp = new MapLocation(ruin.x + 0, ruin.y + -1);
        if (rc.canSenseLocation(tmp)) {
            MapInfo mi = rc.senseMapInfo(tmp);
            switch (mi.getPaint()) {
                case ENEMY_SECONDARY, ENEMY_PRIMARY -> {}
                default -> {
                    boolean isSecondary = (mi.getPaint() == PaintType.ALLY_SECONDARY);
                    boolean targetSecondary = pattern[2][1];
                    if ((mi.getPaint() == PaintType.EMPTY) || (isSecondary != targetSecondary)) {
                        return true;
                    }
                }
            }
        }
        
        
        
        tmp = new MapLocation(ruin.x + 0, ruin.y + -2);
        if (rc.canSenseLocation(tmp)) {
            MapInfo mi = rc.senseMapInfo(tmp);
            switch (mi.getPaint()) {
                case ENEMY_SECONDARY, ENEMY_PRIMARY -> {}
                default -> {
                    boolean isSecondary = (mi.getPaint() == PaintType.ALLY_SECONDARY);
                    boolean targetSecondary = pattern[2][0];
                    if ((mi.getPaint() == PaintType.EMPTY) || (isSecondary != targetSecondary)) {
                        return true;
                    }
                }
            }
        }
        
        
        
        
        
        tmp = new MapLocation(ruin.x + -1, ruin.y + 2);
        if (rc.canSenseLocation(tmp)) {
            MapInfo mi = rc.senseMapInfo(tmp);
            switch (mi.getPaint()) {
                case ENEMY_SECONDARY, ENEMY_PRIMARY -> {}
                default -> {
                    boolean isSecondary = (mi.getPaint() == PaintType.ALLY_SECONDARY);
                    boolean targetSecondary = pattern[1][4];
                    if ((mi.getPaint() == PaintType.EMPTY) || (isSecondary != targetSecondary)) {
                        return true;
                    }
                }
            }
        }
        
        
        
        tmp = new MapLocation(ruin.x + -1, ruin.y + 1);
        if (rc.canSenseLocation(tmp)) {
            MapInfo mi = rc.senseMapInfo(tmp);
            switch (mi.getPaint()) {
                case ENEMY_SECONDARY, ENEMY_PRIMARY -> {}
                default -> {
                    boolean isSecondary = (mi.getPaint() == PaintType.ALLY_SECONDARY);
                    boolean targetSecondary = pattern[1][3];
                    if ((mi.getPaint() == PaintType.EMPTY) || (isSecondary != targetSecondary)) {
                        return true;
                    }
                }
            }
        }
        
        
        
        tmp = new MapLocation(ruin.x + -1, ruin.y + 0);
        if (rc.canSenseLocation(tmp)) {
            MapInfo mi = rc.senseMapInfo(tmp);
            switch (mi.getPaint()) {
                case ENEMY_SECONDARY, ENEMY_PRIMARY -> {}
                default -> {
                    boolean isSecondary = (mi.getPaint() == PaintType.ALLY_SECONDARY);
                    boolean targetSecondary = pattern[1][2];
                    if ((mi.getPaint() == PaintType.EMPTY) || (isSecondary != targetSecondary)) {
                        return true;
                    }
                }
            }
        }
        
        
        
        tmp = new MapLocation(ruin.x + -1, ruin.y + -1);
        if (rc.canSenseLocation(tmp)) {
            MapInfo mi = rc.senseMapInfo(tmp);
            switch (mi.getPaint()) {
                case ENEMY_SECONDARY, ENEMY_PRIMARY -> {}
                default -> {
                    boolean isSecondary = (mi.getPaint() == PaintType.ALLY_SECONDARY);
                    boolean targetSecondary = pattern[1][1];
                    if ((mi.getPaint() == PaintType.EMPTY) || (isSecondary != targetSecondary)) {
                        return true;
                    }
                }
            }
        }
        
        
        
        tmp = new MapLocation(ruin.x + -1, ruin.y + -2);
        if (rc.canSenseLocation(tmp)) {
            MapInfo mi = rc.senseMapInfo(tmp);
            switch (mi.getPaint()) {
                case ENEMY_SECONDARY, ENEMY_PRIMARY -> {}
                default -> {
                    boolean isSecondary = (mi.getPaint() == PaintType.ALLY_SECONDARY);
                    boolean targetSecondary = pattern[1][0];
                    if ((mi.getPaint() == PaintType.EMPTY) || (isSecondary != targetSecondary)) {
                        return true;
                    }
                }
            }
        }
        
        
        
        
        
        tmp = new MapLocation(ruin.x + -2, ruin.y + 2);
        if (rc.canSenseLocation(tmp)) {
            MapInfo mi = rc.senseMapInfo(tmp);
            switch (mi.getPaint()) {
                case ENEMY_SECONDARY, ENEMY_PRIMARY -> {}
                default -> {
                    boolean isSecondary = (mi.getPaint() == PaintType.ALLY_SECONDARY);
                    boolean targetSecondary = pattern[0][4];
                    if ((mi.getPaint() == PaintType.EMPTY) || (isSecondary != targetSecondary)) {
                        return true;
                    }
                }
            }
        }
        
        
        
        tmp = new MapLocation(ruin.x + -2, ruin.y + 1);
        if (rc.canSenseLocation(tmp)) {
            MapInfo mi = rc.senseMapInfo(tmp);
            switch (mi.getPaint()) {
                case ENEMY_SECONDARY, ENEMY_PRIMARY -> {}
                default -> {
                    boolean isSecondary = (mi.getPaint() == PaintType.ALLY_SECONDARY);
                    boolean targetSecondary = pattern[0][3];
                    if ((mi.getPaint() == PaintType.EMPTY) || (isSecondary != targetSecondary)) {
                        return true;
                    }
                }
            }
        }
        
        
        
        tmp = new MapLocation(ruin.x + -2, ruin.y + 0);
        if (rc.canSenseLocation(tmp)) {
            MapInfo mi = rc.senseMapInfo(tmp);
            switch (mi.getPaint()) {
                case ENEMY_SECONDARY, ENEMY_PRIMARY -> {}
                default -> {
                    boolean isSecondary = (mi.getPaint() == PaintType.ALLY_SECONDARY);
                    boolean targetSecondary = pattern[0][2];
                    if ((mi.getPaint() == PaintType.EMPTY) || (isSecondary != targetSecondary)) {
                        return true;
                    }
                }
            }
        }
        
        
        
        tmp = new MapLocation(ruin.x + -2, ruin.y + -1);
        if (rc.canSenseLocation(tmp)) {
            MapInfo mi = rc.senseMapInfo(tmp);
            switch (mi.getPaint()) {
                case ENEMY_SECONDARY, ENEMY_PRIMARY -> {}
                default -> {
                    boolean isSecondary = (mi.getPaint() == PaintType.ALLY_SECONDARY);
                    boolean targetSecondary = pattern[0][1];
                    if ((mi.getPaint() == PaintType.EMPTY) || (isSecondary != targetSecondary)) {
                        return true;
                    }
                }
            }
        }
        
        
        
        tmp = new MapLocation(ruin.x + -2, ruin.y + -2);
        if (rc.canSenseLocation(tmp)) {
            MapInfo mi = rc.senseMapInfo(tmp);
            switch (mi.getPaint()) {
                case ENEMY_SECONDARY, ENEMY_PRIMARY -> {}
                default -> {
                    boolean isSecondary = (mi.getPaint() == PaintType.ALLY_SECONDARY);
                    boolean targetSecondary = pattern[0][0];
                    if ((mi.getPaint() == PaintType.EMPTY) || (isSecondary != targetSecondary)) {
                        return true;
                    }
                }
            }
        }
        
        
        
        return false;
    }

    public static UnitType getTowerToBuild() throws GameActionException {
        // return UnitType.LEVEL_ONE_MONEY_TOWER;
        int sz = Math.max(rc.getMapWidth(), rc.getMapHeight());
        int firstPaint = 0;
        if (sz < 900) {
            firstPaint = 3;
        } else if (sz < 1800) {
            firstPaint = 4;
        } else {
            firstPaint = 5;
        }
        if (rc.getMoney() < 2000 && rc.getNumberTowers() != firstPaint) return UnitType.LEVEL_ONE_MONEY_TOWER;
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
}