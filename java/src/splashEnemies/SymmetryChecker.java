


package splashEnemies;
import battlecode.common.*;

public class SymmetryChecker {

    public enum Symmetry {
        Unknown,
        Rotational,
        Horizontal,
        Vertical
    };

    public static int maxY;
    public static int maxX;
    public static long seen_fused;
    public static RobotController rc;
    public static void init(RobotController rc) {
        SymmetryChecker.rc = rc;
        maxY = rc.getMapHeight() - 1;
        maxX = rc.getMapWidth() - 1;
    }

    public static boolean isSymmetryKnown() {
        return (VSYM + HSYM + RSYM) == 1;
    }

    public static Symmetry getSymmetry() {
        return switch (VSYM * 4 + HSYM * 2 + RSYM) {
            case 1 -> Symmetry.Rotational;
            case 2 -> Symmetry.Horizontal;
            case 4 -> Symmetry.Vertical;
            default -> Symmetry.Unknown;
        };
    }

    public static int VSYM = 1;
    public static int HSYM = 1;
    public static int RSYM = 1;
    public static void run() throws GameActionException {
        if (isSymmetryKnown()) return;
        if (HSYM != 0) checkHorizontal();
        if (VSYM != 0) checkVertical();
        if (RSYM != 0) checkRotational();
    }

    public static void checkHorizontal() throws GameActionException {
        switch (rc.getLocation().y) {
            case 0 -> {
                seen_fused = TileLoader.seen0 & getSeenHorizontal(0);
                if ((TileLoader.wall0 & seen_fused) != (getWallHorizontal(0) & seen_fused)) {
                    HSYM = 0;
                }
                if ((TileLoader.ruin0 & seen_fused) != (getRuinHorizontal(0) & seen_fused)) {
                    HSYM = 0;
                }
                seen_fused = TileLoader.seen1 & getSeenHorizontal(1);
                if ((TileLoader.wall1 & seen_fused) != (getWallHorizontal(1) & seen_fused)) {
                    HSYM = 0;
                }
                if ((TileLoader.ruin1 & seen_fused) != (getRuinHorizontal(1) & seen_fused)) {
                    HSYM = 0;
                }
                seen_fused = TileLoader.seen2 & getSeenHorizontal(2);
                if ((TileLoader.wall2 & seen_fused) != (getWallHorizontal(2) & seen_fused)) {
                    HSYM = 0;
                }
                if ((TileLoader.ruin2 & seen_fused) != (getRuinHorizontal(2) & seen_fused)) {
                    HSYM = 0;
                }
                seen_fused = TileLoader.seen3 & getSeenHorizontal(3);
                if ((TileLoader.wall3 & seen_fused) != (getWallHorizontal(3) & seen_fused)) {
                    HSYM = 0;
                }
                if ((TileLoader.ruin3 & seen_fused) != (getRuinHorizontal(3) & seen_fused)) {
                    HSYM = 0;
                }
                seen_fused = TileLoader.seen4 & getSeenHorizontal(4);
                if ((TileLoader.wall4 & seen_fused) != (getWallHorizontal(4) & seen_fused)) {
                    HSYM = 0;
                }
                if ((TileLoader.ruin4 & seen_fused) != (getRuinHorizontal(4) & seen_fused)) {
                    HSYM = 0;
                }
                
            }
            case 1 -> {
                seen_fused = TileLoader.seen0 & getSeenHorizontal(0);
                if ((TileLoader.wall0 & seen_fused) != (getWallHorizontal(0) & seen_fused)) {
                    HSYM = 0;
                }
                if ((TileLoader.ruin0 & seen_fused) != (getRuinHorizontal(0) & seen_fused)) {
                    HSYM = 0;
                }
                seen_fused = TileLoader.seen1 & getSeenHorizontal(1);
                if ((TileLoader.wall1 & seen_fused) != (getWallHorizontal(1) & seen_fused)) {
                    HSYM = 0;
                }
                if ((TileLoader.ruin1 & seen_fused) != (getRuinHorizontal(1) & seen_fused)) {
                    HSYM = 0;
                }
                seen_fused = TileLoader.seen2 & getSeenHorizontal(2);
                if ((TileLoader.wall2 & seen_fused) != (getWallHorizontal(2) & seen_fused)) {
                    HSYM = 0;
                }
                if ((TileLoader.ruin2 & seen_fused) != (getRuinHorizontal(2) & seen_fused)) {
                    HSYM = 0;
                }
                seen_fused = TileLoader.seen3 & getSeenHorizontal(3);
                if ((TileLoader.wall3 & seen_fused) != (getWallHorizontal(3) & seen_fused)) {
                    HSYM = 0;
                }
                if ((TileLoader.ruin3 & seen_fused) != (getRuinHorizontal(3) & seen_fused)) {
                    HSYM = 0;
                }
                seen_fused = TileLoader.seen4 & getSeenHorizontal(4);
                if ((TileLoader.wall4 & seen_fused) != (getWallHorizontal(4) & seen_fused)) {
                    HSYM = 0;
                }
                if ((TileLoader.ruin4 & seen_fused) != (getRuinHorizontal(4) & seen_fused)) {
                    HSYM = 0;
                }
                seen_fused = TileLoader.seen5 & getSeenHorizontal(5);
                if ((TileLoader.wall5 & seen_fused) != (getWallHorizontal(5) & seen_fused)) {
                    HSYM = 0;
                }
                if ((TileLoader.ruin5 & seen_fused) != (getRuinHorizontal(5) & seen_fused)) {
                    HSYM = 0;
                }
                
            }
            case 2 -> {
                seen_fused = TileLoader.seen0 & getSeenHorizontal(0);
                if ((TileLoader.wall0 & seen_fused) != (getWallHorizontal(0) & seen_fused)) {
                    HSYM = 0;
                }
                if ((TileLoader.ruin0 & seen_fused) != (getRuinHorizontal(0) & seen_fused)) {
                    HSYM = 0;
                }
                seen_fused = TileLoader.seen1 & getSeenHorizontal(1);
                if ((TileLoader.wall1 & seen_fused) != (getWallHorizontal(1) & seen_fused)) {
                    HSYM = 0;
                }
                if ((TileLoader.ruin1 & seen_fused) != (getRuinHorizontal(1) & seen_fused)) {
                    HSYM = 0;
                }
                seen_fused = TileLoader.seen2 & getSeenHorizontal(2);
                if ((TileLoader.wall2 & seen_fused) != (getWallHorizontal(2) & seen_fused)) {
                    HSYM = 0;
                }
                if ((TileLoader.ruin2 & seen_fused) != (getRuinHorizontal(2) & seen_fused)) {
                    HSYM = 0;
                }
                seen_fused = TileLoader.seen3 & getSeenHorizontal(3);
                if ((TileLoader.wall3 & seen_fused) != (getWallHorizontal(3) & seen_fused)) {
                    HSYM = 0;
                }
                if ((TileLoader.ruin3 & seen_fused) != (getRuinHorizontal(3) & seen_fused)) {
                    HSYM = 0;
                }
                seen_fused = TileLoader.seen4 & getSeenHorizontal(4);
                if ((TileLoader.wall4 & seen_fused) != (getWallHorizontal(4) & seen_fused)) {
                    HSYM = 0;
                }
                if ((TileLoader.ruin4 & seen_fused) != (getRuinHorizontal(4) & seen_fused)) {
                    HSYM = 0;
                }
                seen_fused = TileLoader.seen5 & getSeenHorizontal(5);
                if ((TileLoader.wall5 & seen_fused) != (getWallHorizontal(5) & seen_fused)) {
                    HSYM = 0;
                }
                if ((TileLoader.ruin5 & seen_fused) != (getRuinHorizontal(5) & seen_fused)) {
                    HSYM = 0;
                }
                seen_fused = TileLoader.seen6 & getSeenHorizontal(6);
                if ((TileLoader.wall6 & seen_fused) != (getWallHorizontal(6) & seen_fused)) {
                    HSYM = 0;
                }
                if ((TileLoader.ruin6 & seen_fused) != (getRuinHorizontal(6) & seen_fused)) {
                    HSYM = 0;
                }
                
            }
            case 3 -> {
                seen_fused = TileLoader.seen0 & getSeenHorizontal(0);
                if ((TileLoader.wall0 & seen_fused) != (getWallHorizontal(0) & seen_fused)) {
                    HSYM = 0;
                }
                if ((TileLoader.ruin0 & seen_fused) != (getRuinHorizontal(0) & seen_fused)) {
                    HSYM = 0;
                }
                seen_fused = TileLoader.seen1 & getSeenHorizontal(1);
                if ((TileLoader.wall1 & seen_fused) != (getWallHorizontal(1) & seen_fused)) {
                    HSYM = 0;
                }
                if ((TileLoader.ruin1 & seen_fused) != (getRuinHorizontal(1) & seen_fused)) {
                    HSYM = 0;
                }
                seen_fused = TileLoader.seen2 & getSeenHorizontal(2);
                if ((TileLoader.wall2 & seen_fused) != (getWallHorizontal(2) & seen_fused)) {
                    HSYM = 0;
                }
                if ((TileLoader.ruin2 & seen_fused) != (getRuinHorizontal(2) & seen_fused)) {
                    HSYM = 0;
                }
                seen_fused = TileLoader.seen3 & getSeenHorizontal(3);
                if ((TileLoader.wall3 & seen_fused) != (getWallHorizontal(3) & seen_fused)) {
                    HSYM = 0;
                }
                if ((TileLoader.ruin3 & seen_fused) != (getRuinHorizontal(3) & seen_fused)) {
                    HSYM = 0;
                }
                seen_fused = TileLoader.seen4 & getSeenHorizontal(4);
                if ((TileLoader.wall4 & seen_fused) != (getWallHorizontal(4) & seen_fused)) {
                    HSYM = 0;
                }
                if ((TileLoader.ruin4 & seen_fused) != (getRuinHorizontal(4) & seen_fused)) {
                    HSYM = 0;
                }
                seen_fused = TileLoader.seen5 & getSeenHorizontal(5);
                if ((TileLoader.wall5 & seen_fused) != (getWallHorizontal(5) & seen_fused)) {
                    HSYM = 0;
                }
                if ((TileLoader.ruin5 & seen_fused) != (getRuinHorizontal(5) & seen_fused)) {
                    HSYM = 0;
                }
                seen_fused = TileLoader.seen6 & getSeenHorizontal(6);
                if ((TileLoader.wall6 & seen_fused) != (getWallHorizontal(6) & seen_fused)) {
                    HSYM = 0;
                }
                if ((TileLoader.ruin6 & seen_fused) != (getRuinHorizontal(6) & seen_fused)) {
                    HSYM = 0;
                }
                seen_fused = TileLoader.seen7 & getSeenHorizontal(7);
                if ((TileLoader.wall7 & seen_fused) != (getWallHorizontal(7) & seen_fused)) {
                    HSYM = 0;
                }
                if ((TileLoader.ruin7 & seen_fused) != (getRuinHorizontal(7) & seen_fused)) {
                    HSYM = 0;
                }
                
            }
            case 4 -> {
                seen_fused = TileLoader.seen0 & getSeenHorizontal(0);
                if ((TileLoader.wall0 & seen_fused) != (getWallHorizontal(0) & seen_fused)) {
                    HSYM = 0;
                }
                if ((TileLoader.ruin0 & seen_fused) != (getRuinHorizontal(0) & seen_fused)) {
                    HSYM = 0;
                }
                seen_fused = TileLoader.seen1 & getSeenHorizontal(1);
                if ((TileLoader.wall1 & seen_fused) != (getWallHorizontal(1) & seen_fused)) {
                    HSYM = 0;
                }
                if ((TileLoader.ruin1 & seen_fused) != (getRuinHorizontal(1) & seen_fused)) {
                    HSYM = 0;
                }
                seen_fused = TileLoader.seen2 & getSeenHorizontal(2);
                if ((TileLoader.wall2 & seen_fused) != (getWallHorizontal(2) & seen_fused)) {
                    HSYM = 0;
                }
                if ((TileLoader.ruin2 & seen_fused) != (getRuinHorizontal(2) & seen_fused)) {
                    HSYM = 0;
                }
                seen_fused = TileLoader.seen3 & getSeenHorizontal(3);
                if ((TileLoader.wall3 & seen_fused) != (getWallHorizontal(3) & seen_fused)) {
                    HSYM = 0;
                }
                if ((TileLoader.ruin3 & seen_fused) != (getRuinHorizontal(3) & seen_fused)) {
                    HSYM = 0;
                }
                seen_fused = TileLoader.seen4 & getSeenHorizontal(4);
                if ((TileLoader.wall4 & seen_fused) != (getWallHorizontal(4) & seen_fused)) {
                    HSYM = 0;
                }
                if ((TileLoader.ruin4 & seen_fused) != (getRuinHorizontal(4) & seen_fused)) {
                    HSYM = 0;
                }
                seen_fused = TileLoader.seen5 & getSeenHorizontal(5);
                if ((TileLoader.wall5 & seen_fused) != (getWallHorizontal(5) & seen_fused)) {
                    HSYM = 0;
                }
                if ((TileLoader.ruin5 & seen_fused) != (getRuinHorizontal(5) & seen_fused)) {
                    HSYM = 0;
                }
                seen_fused = TileLoader.seen6 & getSeenHorizontal(6);
                if ((TileLoader.wall6 & seen_fused) != (getWallHorizontal(6) & seen_fused)) {
                    HSYM = 0;
                }
                if ((TileLoader.ruin6 & seen_fused) != (getRuinHorizontal(6) & seen_fused)) {
                    HSYM = 0;
                }
                seen_fused = TileLoader.seen7 & getSeenHorizontal(7);
                if ((TileLoader.wall7 & seen_fused) != (getWallHorizontal(7) & seen_fused)) {
                    HSYM = 0;
                }
                if ((TileLoader.ruin7 & seen_fused) != (getRuinHorizontal(7) & seen_fused)) {
                    HSYM = 0;
                }
                seen_fused = TileLoader.seen8 & getSeenHorizontal(8);
                if ((TileLoader.wall8 & seen_fused) != (getWallHorizontal(8) & seen_fused)) {
                    HSYM = 0;
                }
                if ((TileLoader.ruin8 & seen_fused) != (getRuinHorizontal(8) & seen_fused)) {
                    HSYM = 0;
                }
                
            }
            case 5 -> {
                seen_fused = TileLoader.seen1 & getSeenHorizontal(1);
                if ((TileLoader.wall1 & seen_fused) != (getWallHorizontal(1) & seen_fused)) {
                    HSYM = 0;
                }
                if ((TileLoader.ruin1 & seen_fused) != (getRuinHorizontal(1) & seen_fused)) {
                    HSYM = 0;
                }
                seen_fused = TileLoader.seen2 & getSeenHorizontal(2);
                if ((TileLoader.wall2 & seen_fused) != (getWallHorizontal(2) & seen_fused)) {
                    HSYM = 0;
                }
                if ((TileLoader.ruin2 & seen_fused) != (getRuinHorizontal(2) & seen_fused)) {
                    HSYM = 0;
                }
                seen_fused = TileLoader.seen3 & getSeenHorizontal(3);
                if ((TileLoader.wall3 & seen_fused) != (getWallHorizontal(3) & seen_fused)) {
                    HSYM = 0;
                }
                if ((TileLoader.ruin3 & seen_fused) != (getRuinHorizontal(3) & seen_fused)) {
                    HSYM = 0;
                }
                seen_fused = TileLoader.seen4 & getSeenHorizontal(4);
                if ((TileLoader.wall4 & seen_fused) != (getWallHorizontal(4) & seen_fused)) {
                    HSYM = 0;
                }
                if ((TileLoader.ruin4 & seen_fused) != (getRuinHorizontal(4) & seen_fused)) {
                    HSYM = 0;
                }
                seen_fused = TileLoader.seen5 & getSeenHorizontal(5);
                if ((TileLoader.wall5 & seen_fused) != (getWallHorizontal(5) & seen_fused)) {
                    HSYM = 0;
                }
                if ((TileLoader.ruin5 & seen_fused) != (getRuinHorizontal(5) & seen_fused)) {
                    HSYM = 0;
                }
                seen_fused = TileLoader.seen6 & getSeenHorizontal(6);
                if ((TileLoader.wall6 & seen_fused) != (getWallHorizontal(6) & seen_fused)) {
                    HSYM = 0;
                }
                if ((TileLoader.ruin6 & seen_fused) != (getRuinHorizontal(6) & seen_fused)) {
                    HSYM = 0;
                }
                seen_fused = TileLoader.seen7 & getSeenHorizontal(7);
                if ((TileLoader.wall7 & seen_fused) != (getWallHorizontal(7) & seen_fused)) {
                    HSYM = 0;
                }
                if ((TileLoader.ruin7 & seen_fused) != (getRuinHorizontal(7) & seen_fused)) {
                    HSYM = 0;
                }
                seen_fused = TileLoader.seen8 & getSeenHorizontal(8);
                if ((TileLoader.wall8 & seen_fused) != (getWallHorizontal(8) & seen_fused)) {
                    HSYM = 0;
                }
                if ((TileLoader.ruin8 & seen_fused) != (getRuinHorizontal(8) & seen_fused)) {
                    HSYM = 0;
                }
                seen_fused = TileLoader.seen9 & getSeenHorizontal(9);
                if ((TileLoader.wall9 & seen_fused) != (getWallHorizontal(9) & seen_fused)) {
                    HSYM = 0;
                }
                if ((TileLoader.ruin9 & seen_fused) != (getRuinHorizontal(9) & seen_fused)) {
                    HSYM = 0;
                }
                
            }
            case 6 -> {
                seen_fused = TileLoader.seen2 & getSeenHorizontal(2);
                if ((TileLoader.wall2 & seen_fused) != (getWallHorizontal(2) & seen_fused)) {
                    HSYM = 0;
                }
                if ((TileLoader.ruin2 & seen_fused) != (getRuinHorizontal(2) & seen_fused)) {
                    HSYM = 0;
                }
                seen_fused = TileLoader.seen3 & getSeenHorizontal(3);
                if ((TileLoader.wall3 & seen_fused) != (getWallHorizontal(3) & seen_fused)) {
                    HSYM = 0;
                }
                if ((TileLoader.ruin3 & seen_fused) != (getRuinHorizontal(3) & seen_fused)) {
                    HSYM = 0;
                }
                seen_fused = TileLoader.seen4 & getSeenHorizontal(4);
                if ((TileLoader.wall4 & seen_fused) != (getWallHorizontal(4) & seen_fused)) {
                    HSYM = 0;
                }
                if ((TileLoader.ruin4 & seen_fused) != (getRuinHorizontal(4) & seen_fused)) {
                    HSYM = 0;
                }
                seen_fused = TileLoader.seen5 & getSeenHorizontal(5);
                if ((TileLoader.wall5 & seen_fused) != (getWallHorizontal(5) & seen_fused)) {
                    HSYM = 0;
                }
                if ((TileLoader.ruin5 & seen_fused) != (getRuinHorizontal(5) & seen_fused)) {
                    HSYM = 0;
                }
                seen_fused = TileLoader.seen6 & getSeenHorizontal(6);
                if ((TileLoader.wall6 & seen_fused) != (getWallHorizontal(6) & seen_fused)) {
                    HSYM = 0;
                }
                if ((TileLoader.ruin6 & seen_fused) != (getRuinHorizontal(6) & seen_fused)) {
                    HSYM = 0;
                }
                seen_fused = TileLoader.seen7 & getSeenHorizontal(7);
                if ((TileLoader.wall7 & seen_fused) != (getWallHorizontal(7) & seen_fused)) {
                    HSYM = 0;
                }
                if ((TileLoader.ruin7 & seen_fused) != (getRuinHorizontal(7) & seen_fused)) {
                    HSYM = 0;
                }
                seen_fused = TileLoader.seen8 & getSeenHorizontal(8);
                if ((TileLoader.wall8 & seen_fused) != (getWallHorizontal(8) & seen_fused)) {
                    HSYM = 0;
                }
                if ((TileLoader.ruin8 & seen_fused) != (getRuinHorizontal(8) & seen_fused)) {
                    HSYM = 0;
                }
                seen_fused = TileLoader.seen9 & getSeenHorizontal(9);
                if ((TileLoader.wall9 & seen_fused) != (getWallHorizontal(9) & seen_fused)) {
                    HSYM = 0;
                }
                if ((TileLoader.ruin9 & seen_fused) != (getRuinHorizontal(9) & seen_fused)) {
                    HSYM = 0;
                }
                seen_fused = TileLoader.seen10 & getSeenHorizontal(10);
                if ((TileLoader.wall10 & seen_fused) != (getWallHorizontal(10) & seen_fused)) {
                    HSYM = 0;
                }
                if ((TileLoader.ruin10 & seen_fused) != (getRuinHorizontal(10) & seen_fused)) {
                    HSYM = 0;
                }
                
            }
            case 7 -> {
                seen_fused = TileLoader.seen3 & getSeenHorizontal(3);
                if ((TileLoader.wall3 & seen_fused) != (getWallHorizontal(3) & seen_fused)) {
                    HSYM = 0;
                }
                if ((TileLoader.ruin3 & seen_fused) != (getRuinHorizontal(3) & seen_fused)) {
                    HSYM = 0;
                }
                seen_fused = TileLoader.seen4 & getSeenHorizontal(4);
                if ((TileLoader.wall4 & seen_fused) != (getWallHorizontal(4) & seen_fused)) {
                    HSYM = 0;
                }
                if ((TileLoader.ruin4 & seen_fused) != (getRuinHorizontal(4) & seen_fused)) {
                    HSYM = 0;
                }
                seen_fused = TileLoader.seen5 & getSeenHorizontal(5);
                if ((TileLoader.wall5 & seen_fused) != (getWallHorizontal(5) & seen_fused)) {
                    HSYM = 0;
                }
                if ((TileLoader.ruin5 & seen_fused) != (getRuinHorizontal(5) & seen_fused)) {
                    HSYM = 0;
                }
                seen_fused = TileLoader.seen6 & getSeenHorizontal(6);
                if ((TileLoader.wall6 & seen_fused) != (getWallHorizontal(6) & seen_fused)) {
                    HSYM = 0;
                }
                if ((TileLoader.ruin6 & seen_fused) != (getRuinHorizontal(6) & seen_fused)) {
                    HSYM = 0;
                }
                seen_fused = TileLoader.seen7 & getSeenHorizontal(7);
                if ((TileLoader.wall7 & seen_fused) != (getWallHorizontal(7) & seen_fused)) {
                    HSYM = 0;
                }
                if ((TileLoader.ruin7 & seen_fused) != (getRuinHorizontal(7) & seen_fused)) {
                    HSYM = 0;
                }
                seen_fused = TileLoader.seen8 & getSeenHorizontal(8);
                if ((TileLoader.wall8 & seen_fused) != (getWallHorizontal(8) & seen_fused)) {
                    HSYM = 0;
                }
                if ((TileLoader.ruin8 & seen_fused) != (getRuinHorizontal(8) & seen_fused)) {
                    HSYM = 0;
                }
                seen_fused = TileLoader.seen9 & getSeenHorizontal(9);
                if ((TileLoader.wall9 & seen_fused) != (getWallHorizontal(9) & seen_fused)) {
                    HSYM = 0;
                }
                if ((TileLoader.ruin9 & seen_fused) != (getRuinHorizontal(9) & seen_fused)) {
                    HSYM = 0;
                }
                seen_fused = TileLoader.seen10 & getSeenHorizontal(10);
                if ((TileLoader.wall10 & seen_fused) != (getWallHorizontal(10) & seen_fused)) {
                    HSYM = 0;
                }
                if ((TileLoader.ruin10 & seen_fused) != (getRuinHorizontal(10) & seen_fused)) {
                    HSYM = 0;
                }
                seen_fused = TileLoader.seen11 & getSeenHorizontal(11);
                if ((TileLoader.wall11 & seen_fused) != (getWallHorizontal(11) & seen_fused)) {
                    HSYM = 0;
                }
                if ((TileLoader.ruin11 & seen_fused) != (getRuinHorizontal(11) & seen_fused)) {
                    HSYM = 0;
                }
                
            }
            case 8 -> {
                seen_fused = TileLoader.seen4 & getSeenHorizontal(4);
                if ((TileLoader.wall4 & seen_fused) != (getWallHorizontal(4) & seen_fused)) {
                    HSYM = 0;
                }
                if ((TileLoader.ruin4 & seen_fused) != (getRuinHorizontal(4) & seen_fused)) {
                    HSYM = 0;
                }
                seen_fused = TileLoader.seen5 & getSeenHorizontal(5);
                if ((TileLoader.wall5 & seen_fused) != (getWallHorizontal(5) & seen_fused)) {
                    HSYM = 0;
                }
                if ((TileLoader.ruin5 & seen_fused) != (getRuinHorizontal(5) & seen_fused)) {
                    HSYM = 0;
                }
                seen_fused = TileLoader.seen6 & getSeenHorizontal(6);
                if ((TileLoader.wall6 & seen_fused) != (getWallHorizontal(6) & seen_fused)) {
                    HSYM = 0;
                }
                if ((TileLoader.ruin6 & seen_fused) != (getRuinHorizontal(6) & seen_fused)) {
                    HSYM = 0;
                }
                seen_fused = TileLoader.seen7 & getSeenHorizontal(7);
                if ((TileLoader.wall7 & seen_fused) != (getWallHorizontal(7) & seen_fused)) {
                    HSYM = 0;
                }
                if ((TileLoader.ruin7 & seen_fused) != (getRuinHorizontal(7) & seen_fused)) {
                    HSYM = 0;
                }
                seen_fused = TileLoader.seen8 & getSeenHorizontal(8);
                if ((TileLoader.wall8 & seen_fused) != (getWallHorizontal(8) & seen_fused)) {
                    HSYM = 0;
                }
                if ((TileLoader.ruin8 & seen_fused) != (getRuinHorizontal(8) & seen_fused)) {
                    HSYM = 0;
                }
                seen_fused = TileLoader.seen9 & getSeenHorizontal(9);
                if ((TileLoader.wall9 & seen_fused) != (getWallHorizontal(9) & seen_fused)) {
                    HSYM = 0;
                }
                if ((TileLoader.ruin9 & seen_fused) != (getRuinHorizontal(9) & seen_fused)) {
                    HSYM = 0;
                }
                seen_fused = TileLoader.seen10 & getSeenHorizontal(10);
                if ((TileLoader.wall10 & seen_fused) != (getWallHorizontal(10) & seen_fused)) {
                    HSYM = 0;
                }
                if ((TileLoader.ruin10 & seen_fused) != (getRuinHorizontal(10) & seen_fused)) {
                    HSYM = 0;
                }
                seen_fused = TileLoader.seen11 & getSeenHorizontal(11);
                if ((TileLoader.wall11 & seen_fused) != (getWallHorizontal(11) & seen_fused)) {
                    HSYM = 0;
                }
                if ((TileLoader.ruin11 & seen_fused) != (getRuinHorizontal(11) & seen_fused)) {
                    HSYM = 0;
                }
                seen_fused = TileLoader.seen12 & getSeenHorizontal(12);
                if ((TileLoader.wall12 & seen_fused) != (getWallHorizontal(12) & seen_fused)) {
                    HSYM = 0;
                }
                if ((TileLoader.ruin12 & seen_fused) != (getRuinHorizontal(12) & seen_fused)) {
                    HSYM = 0;
                }
                
            }
            case 9 -> {
                seen_fused = TileLoader.seen5 & getSeenHorizontal(5);
                if ((TileLoader.wall5 & seen_fused) != (getWallHorizontal(5) & seen_fused)) {
                    HSYM = 0;
                }
                if ((TileLoader.ruin5 & seen_fused) != (getRuinHorizontal(5) & seen_fused)) {
                    HSYM = 0;
                }
                seen_fused = TileLoader.seen6 & getSeenHorizontal(6);
                if ((TileLoader.wall6 & seen_fused) != (getWallHorizontal(6) & seen_fused)) {
                    HSYM = 0;
                }
                if ((TileLoader.ruin6 & seen_fused) != (getRuinHorizontal(6) & seen_fused)) {
                    HSYM = 0;
                }
                seen_fused = TileLoader.seen7 & getSeenHorizontal(7);
                if ((TileLoader.wall7 & seen_fused) != (getWallHorizontal(7) & seen_fused)) {
                    HSYM = 0;
                }
                if ((TileLoader.ruin7 & seen_fused) != (getRuinHorizontal(7) & seen_fused)) {
                    HSYM = 0;
                }
                seen_fused = TileLoader.seen8 & getSeenHorizontal(8);
                if ((TileLoader.wall8 & seen_fused) != (getWallHorizontal(8) & seen_fused)) {
                    HSYM = 0;
                }
                if ((TileLoader.ruin8 & seen_fused) != (getRuinHorizontal(8) & seen_fused)) {
                    HSYM = 0;
                }
                seen_fused = TileLoader.seen9 & getSeenHorizontal(9);
                if ((TileLoader.wall9 & seen_fused) != (getWallHorizontal(9) & seen_fused)) {
                    HSYM = 0;
                }
                if ((TileLoader.ruin9 & seen_fused) != (getRuinHorizontal(9) & seen_fused)) {
                    HSYM = 0;
                }
                seen_fused = TileLoader.seen10 & getSeenHorizontal(10);
                if ((TileLoader.wall10 & seen_fused) != (getWallHorizontal(10) & seen_fused)) {
                    HSYM = 0;
                }
                if ((TileLoader.ruin10 & seen_fused) != (getRuinHorizontal(10) & seen_fused)) {
                    HSYM = 0;
                }
                seen_fused = TileLoader.seen11 & getSeenHorizontal(11);
                if ((TileLoader.wall11 & seen_fused) != (getWallHorizontal(11) & seen_fused)) {
                    HSYM = 0;
                }
                if ((TileLoader.ruin11 & seen_fused) != (getRuinHorizontal(11) & seen_fused)) {
                    HSYM = 0;
                }
                seen_fused = TileLoader.seen12 & getSeenHorizontal(12);
                if ((TileLoader.wall12 & seen_fused) != (getWallHorizontal(12) & seen_fused)) {
                    HSYM = 0;
                }
                if ((TileLoader.ruin12 & seen_fused) != (getRuinHorizontal(12) & seen_fused)) {
                    HSYM = 0;
                }
                seen_fused = TileLoader.seen13 & getSeenHorizontal(13);
                if ((TileLoader.wall13 & seen_fused) != (getWallHorizontal(13) & seen_fused)) {
                    HSYM = 0;
                }
                if ((TileLoader.ruin13 & seen_fused) != (getRuinHorizontal(13) & seen_fused)) {
                    HSYM = 0;
                }
                
            }
            case 10 -> {
                seen_fused = TileLoader.seen6 & getSeenHorizontal(6);
                if ((TileLoader.wall6 & seen_fused) != (getWallHorizontal(6) & seen_fused)) {
                    HSYM = 0;
                }
                if ((TileLoader.ruin6 & seen_fused) != (getRuinHorizontal(6) & seen_fused)) {
                    HSYM = 0;
                }
                seen_fused = TileLoader.seen7 & getSeenHorizontal(7);
                if ((TileLoader.wall7 & seen_fused) != (getWallHorizontal(7) & seen_fused)) {
                    HSYM = 0;
                }
                if ((TileLoader.ruin7 & seen_fused) != (getRuinHorizontal(7) & seen_fused)) {
                    HSYM = 0;
                }
                seen_fused = TileLoader.seen8 & getSeenHorizontal(8);
                if ((TileLoader.wall8 & seen_fused) != (getWallHorizontal(8) & seen_fused)) {
                    HSYM = 0;
                }
                if ((TileLoader.ruin8 & seen_fused) != (getRuinHorizontal(8) & seen_fused)) {
                    HSYM = 0;
                }
                seen_fused = TileLoader.seen9 & getSeenHorizontal(9);
                if ((TileLoader.wall9 & seen_fused) != (getWallHorizontal(9) & seen_fused)) {
                    HSYM = 0;
                }
                if ((TileLoader.ruin9 & seen_fused) != (getRuinHorizontal(9) & seen_fused)) {
                    HSYM = 0;
                }
                seen_fused = TileLoader.seen10 & getSeenHorizontal(10);
                if ((TileLoader.wall10 & seen_fused) != (getWallHorizontal(10) & seen_fused)) {
                    HSYM = 0;
                }
                if ((TileLoader.ruin10 & seen_fused) != (getRuinHorizontal(10) & seen_fused)) {
                    HSYM = 0;
                }
                seen_fused = TileLoader.seen11 & getSeenHorizontal(11);
                if ((TileLoader.wall11 & seen_fused) != (getWallHorizontal(11) & seen_fused)) {
                    HSYM = 0;
                }
                if ((TileLoader.ruin11 & seen_fused) != (getRuinHorizontal(11) & seen_fused)) {
                    HSYM = 0;
                }
                seen_fused = TileLoader.seen12 & getSeenHorizontal(12);
                if ((TileLoader.wall12 & seen_fused) != (getWallHorizontal(12) & seen_fused)) {
                    HSYM = 0;
                }
                if ((TileLoader.ruin12 & seen_fused) != (getRuinHorizontal(12) & seen_fused)) {
                    HSYM = 0;
                }
                seen_fused = TileLoader.seen13 & getSeenHorizontal(13);
                if ((TileLoader.wall13 & seen_fused) != (getWallHorizontal(13) & seen_fused)) {
                    HSYM = 0;
                }
                if ((TileLoader.ruin13 & seen_fused) != (getRuinHorizontal(13) & seen_fused)) {
                    HSYM = 0;
                }
                seen_fused = TileLoader.seen14 & getSeenHorizontal(14);
                if ((TileLoader.wall14 & seen_fused) != (getWallHorizontal(14) & seen_fused)) {
                    HSYM = 0;
                }
                if ((TileLoader.ruin14 & seen_fused) != (getRuinHorizontal(14) & seen_fused)) {
                    HSYM = 0;
                }
                
            }
            case 11 -> {
                seen_fused = TileLoader.seen7 & getSeenHorizontal(7);
                if ((TileLoader.wall7 & seen_fused) != (getWallHorizontal(7) & seen_fused)) {
                    HSYM = 0;
                }
                if ((TileLoader.ruin7 & seen_fused) != (getRuinHorizontal(7) & seen_fused)) {
                    HSYM = 0;
                }
                seen_fused = TileLoader.seen8 & getSeenHorizontal(8);
                if ((TileLoader.wall8 & seen_fused) != (getWallHorizontal(8) & seen_fused)) {
                    HSYM = 0;
                }
                if ((TileLoader.ruin8 & seen_fused) != (getRuinHorizontal(8) & seen_fused)) {
                    HSYM = 0;
                }
                seen_fused = TileLoader.seen9 & getSeenHorizontal(9);
                if ((TileLoader.wall9 & seen_fused) != (getWallHorizontal(9) & seen_fused)) {
                    HSYM = 0;
                }
                if ((TileLoader.ruin9 & seen_fused) != (getRuinHorizontal(9) & seen_fused)) {
                    HSYM = 0;
                }
                seen_fused = TileLoader.seen10 & getSeenHorizontal(10);
                if ((TileLoader.wall10 & seen_fused) != (getWallHorizontal(10) & seen_fused)) {
                    HSYM = 0;
                }
                if ((TileLoader.ruin10 & seen_fused) != (getRuinHorizontal(10) & seen_fused)) {
                    HSYM = 0;
                }
                seen_fused = TileLoader.seen11 & getSeenHorizontal(11);
                if ((TileLoader.wall11 & seen_fused) != (getWallHorizontal(11) & seen_fused)) {
                    HSYM = 0;
                }
                if ((TileLoader.ruin11 & seen_fused) != (getRuinHorizontal(11) & seen_fused)) {
                    HSYM = 0;
                }
                seen_fused = TileLoader.seen12 & getSeenHorizontal(12);
                if ((TileLoader.wall12 & seen_fused) != (getWallHorizontal(12) & seen_fused)) {
                    HSYM = 0;
                }
                if ((TileLoader.ruin12 & seen_fused) != (getRuinHorizontal(12) & seen_fused)) {
                    HSYM = 0;
                }
                seen_fused = TileLoader.seen13 & getSeenHorizontal(13);
                if ((TileLoader.wall13 & seen_fused) != (getWallHorizontal(13) & seen_fused)) {
                    HSYM = 0;
                }
                if ((TileLoader.ruin13 & seen_fused) != (getRuinHorizontal(13) & seen_fused)) {
                    HSYM = 0;
                }
                seen_fused = TileLoader.seen14 & getSeenHorizontal(14);
                if ((TileLoader.wall14 & seen_fused) != (getWallHorizontal(14) & seen_fused)) {
                    HSYM = 0;
                }
                if ((TileLoader.ruin14 & seen_fused) != (getRuinHorizontal(14) & seen_fused)) {
                    HSYM = 0;
                }
                seen_fused = TileLoader.seen15 & getSeenHorizontal(15);
                if ((TileLoader.wall15 & seen_fused) != (getWallHorizontal(15) & seen_fused)) {
                    HSYM = 0;
                }
                if ((TileLoader.ruin15 & seen_fused) != (getRuinHorizontal(15) & seen_fused)) {
                    HSYM = 0;
                }
                
            }
            case 12 -> {
                seen_fused = TileLoader.seen8 & getSeenHorizontal(8);
                if ((TileLoader.wall8 & seen_fused) != (getWallHorizontal(8) & seen_fused)) {
                    HSYM = 0;
                }
                if ((TileLoader.ruin8 & seen_fused) != (getRuinHorizontal(8) & seen_fused)) {
                    HSYM = 0;
                }
                seen_fused = TileLoader.seen9 & getSeenHorizontal(9);
                if ((TileLoader.wall9 & seen_fused) != (getWallHorizontal(9) & seen_fused)) {
                    HSYM = 0;
                }
                if ((TileLoader.ruin9 & seen_fused) != (getRuinHorizontal(9) & seen_fused)) {
                    HSYM = 0;
                }
                seen_fused = TileLoader.seen10 & getSeenHorizontal(10);
                if ((TileLoader.wall10 & seen_fused) != (getWallHorizontal(10) & seen_fused)) {
                    HSYM = 0;
                }
                if ((TileLoader.ruin10 & seen_fused) != (getRuinHorizontal(10) & seen_fused)) {
                    HSYM = 0;
                }
                seen_fused = TileLoader.seen11 & getSeenHorizontal(11);
                if ((TileLoader.wall11 & seen_fused) != (getWallHorizontal(11) & seen_fused)) {
                    HSYM = 0;
                }
                if ((TileLoader.ruin11 & seen_fused) != (getRuinHorizontal(11) & seen_fused)) {
                    HSYM = 0;
                }
                seen_fused = TileLoader.seen12 & getSeenHorizontal(12);
                if ((TileLoader.wall12 & seen_fused) != (getWallHorizontal(12) & seen_fused)) {
                    HSYM = 0;
                }
                if ((TileLoader.ruin12 & seen_fused) != (getRuinHorizontal(12) & seen_fused)) {
                    HSYM = 0;
                }
                seen_fused = TileLoader.seen13 & getSeenHorizontal(13);
                if ((TileLoader.wall13 & seen_fused) != (getWallHorizontal(13) & seen_fused)) {
                    HSYM = 0;
                }
                if ((TileLoader.ruin13 & seen_fused) != (getRuinHorizontal(13) & seen_fused)) {
                    HSYM = 0;
                }
                seen_fused = TileLoader.seen14 & getSeenHorizontal(14);
                if ((TileLoader.wall14 & seen_fused) != (getWallHorizontal(14) & seen_fused)) {
                    HSYM = 0;
                }
                if ((TileLoader.ruin14 & seen_fused) != (getRuinHorizontal(14) & seen_fused)) {
                    HSYM = 0;
                }
                seen_fused = TileLoader.seen15 & getSeenHorizontal(15);
                if ((TileLoader.wall15 & seen_fused) != (getWallHorizontal(15) & seen_fused)) {
                    HSYM = 0;
                }
                if ((TileLoader.ruin15 & seen_fused) != (getRuinHorizontal(15) & seen_fused)) {
                    HSYM = 0;
                }
                seen_fused = TileLoader.seen16 & getSeenHorizontal(16);
                if ((TileLoader.wall16 & seen_fused) != (getWallHorizontal(16) & seen_fused)) {
                    HSYM = 0;
                }
                if ((TileLoader.ruin16 & seen_fused) != (getRuinHorizontal(16) & seen_fused)) {
                    HSYM = 0;
                }
                
            }
            case 13 -> {
                seen_fused = TileLoader.seen9 & getSeenHorizontal(9);
                if ((TileLoader.wall9 & seen_fused) != (getWallHorizontal(9) & seen_fused)) {
                    HSYM = 0;
                }
                if ((TileLoader.ruin9 & seen_fused) != (getRuinHorizontal(9) & seen_fused)) {
                    HSYM = 0;
                }
                seen_fused = TileLoader.seen10 & getSeenHorizontal(10);
                if ((TileLoader.wall10 & seen_fused) != (getWallHorizontal(10) & seen_fused)) {
                    HSYM = 0;
                }
                if ((TileLoader.ruin10 & seen_fused) != (getRuinHorizontal(10) & seen_fused)) {
                    HSYM = 0;
                }
                seen_fused = TileLoader.seen11 & getSeenHorizontal(11);
                if ((TileLoader.wall11 & seen_fused) != (getWallHorizontal(11) & seen_fused)) {
                    HSYM = 0;
                }
                if ((TileLoader.ruin11 & seen_fused) != (getRuinHorizontal(11) & seen_fused)) {
                    HSYM = 0;
                }
                seen_fused = TileLoader.seen12 & getSeenHorizontal(12);
                if ((TileLoader.wall12 & seen_fused) != (getWallHorizontal(12) & seen_fused)) {
                    HSYM = 0;
                }
                if ((TileLoader.ruin12 & seen_fused) != (getRuinHorizontal(12) & seen_fused)) {
                    HSYM = 0;
                }
                seen_fused = TileLoader.seen13 & getSeenHorizontal(13);
                if ((TileLoader.wall13 & seen_fused) != (getWallHorizontal(13) & seen_fused)) {
                    HSYM = 0;
                }
                if ((TileLoader.ruin13 & seen_fused) != (getRuinHorizontal(13) & seen_fused)) {
                    HSYM = 0;
                }
                seen_fused = TileLoader.seen14 & getSeenHorizontal(14);
                if ((TileLoader.wall14 & seen_fused) != (getWallHorizontal(14) & seen_fused)) {
                    HSYM = 0;
                }
                if ((TileLoader.ruin14 & seen_fused) != (getRuinHorizontal(14) & seen_fused)) {
                    HSYM = 0;
                }
                seen_fused = TileLoader.seen15 & getSeenHorizontal(15);
                if ((TileLoader.wall15 & seen_fused) != (getWallHorizontal(15) & seen_fused)) {
                    HSYM = 0;
                }
                if ((TileLoader.ruin15 & seen_fused) != (getRuinHorizontal(15) & seen_fused)) {
                    HSYM = 0;
                }
                seen_fused = TileLoader.seen16 & getSeenHorizontal(16);
                if ((TileLoader.wall16 & seen_fused) != (getWallHorizontal(16) & seen_fused)) {
                    HSYM = 0;
                }
                if ((TileLoader.ruin16 & seen_fused) != (getRuinHorizontal(16) & seen_fused)) {
                    HSYM = 0;
                }
                seen_fused = TileLoader.seen17 & getSeenHorizontal(17);
                if ((TileLoader.wall17 & seen_fused) != (getWallHorizontal(17) & seen_fused)) {
                    HSYM = 0;
                }
                if ((TileLoader.ruin17 & seen_fused) != (getRuinHorizontal(17) & seen_fused)) {
                    HSYM = 0;
                }
                
            }
            case 14 -> {
                seen_fused = TileLoader.seen10 & getSeenHorizontal(10);
                if ((TileLoader.wall10 & seen_fused) != (getWallHorizontal(10) & seen_fused)) {
                    HSYM = 0;
                }
                if ((TileLoader.ruin10 & seen_fused) != (getRuinHorizontal(10) & seen_fused)) {
                    HSYM = 0;
                }
                seen_fused = TileLoader.seen11 & getSeenHorizontal(11);
                if ((TileLoader.wall11 & seen_fused) != (getWallHorizontal(11) & seen_fused)) {
                    HSYM = 0;
                }
                if ((TileLoader.ruin11 & seen_fused) != (getRuinHorizontal(11) & seen_fused)) {
                    HSYM = 0;
                }
                seen_fused = TileLoader.seen12 & getSeenHorizontal(12);
                if ((TileLoader.wall12 & seen_fused) != (getWallHorizontal(12) & seen_fused)) {
                    HSYM = 0;
                }
                if ((TileLoader.ruin12 & seen_fused) != (getRuinHorizontal(12) & seen_fused)) {
                    HSYM = 0;
                }
                seen_fused = TileLoader.seen13 & getSeenHorizontal(13);
                if ((TileLoader.wall13 & seen_fused) != (getWallHorizontal(13) & seen_fused)) {
                    HSYM = 0;
                }
                if ((TileLoader.ruin13 & seen_fused) != (getRuinHorizontal(13) & seen_fused)) {
                    HSYM = 0;
                }
                seen_fused = TileLoader.seen14 & getSeenHorizontal(14);
                if ((TileLoader.wall14 & seen_fused) != (getWallHorizontal(14) & seen_fused)) {
                    HSYM = 0;
                }
                if ((TileLoader.ruin14 & seen_fused) != (getRuinHorizontal(14) & seen_fused)) {
                    HSYM = 0;
                }
                seen_fused = TileLoader.seen15 & getSeenHorizontal(15);
                if ((TileLoader.wall15 & seen_fused) != (getWallHorizontal(15) & seen_fused)) {
                    HSYM = 0;
                }
                if ((TileLoader.ruin15 & seen_fused) != (getRuinHorizontal(15) & seen_fused)) {
                    HSYM = 0;
                }
                seen_fused = TileLoader.seen16 & getSeenHorizontal(16);
                if ((TileLoader.wall16 & seen_fused) != (getWallHorizontal(16) & seen_fused)) {
                    HSYM = 0;
                }
                if ((TileLoader.ruin16 & seen_fused) != (getRuinHorizontal(16) & seen_fused)) {
                    HSYM = 0;
                }
                seen_fused = TileLoader.seen17 & getSeenHorizontal(17);
                if ((TileLoader.wall17 & seen_fused) != (getWallHorizontal(17) & seen_fused)) {
                    HSYM = 0;
                }
                if ((TileLoader.ruin17 & seen_fused) != (getRuinHorizontal(17) & seen_fused)) {
                    HSYM = 0;
                }
                seen_fused = TileLoader.seen18 & getSeenHorizontal(18);
                if ((TileLoader.wall18 & seen_fused) != (getWallHorizontal(18) & seen_fused)) {
                    HSYM = 0;
                }
                if ((TileLoader.ruin18 & seen_fused) != (getRuinHorizontal(18) & seen_fused)) {
                    HSYM = 0;
                }
                
            }
            case 15 -> {
                seen_fused = TileLoader.seen11 & getSeenHorizontal(11);
                if ((TileLoader.wall11 & seen_fused) != (getWallHorizontal(11) & seen_fused)) {
                    HSYM = 0;
                }
                if ((TileLoader.ruin11 & seen_fused) != (getRuinHorizontal(11) & seen_fused)) {
                    HSYM = 0;
                }
                seen_fused = TileLoader.seen12 & getSeenHorizontal(12);
                if ((TileLoader.wall12 & seen_fused) != (getWallHorizontal(12) & seen_fused)) {
                    HSYM = 0;
                }
                if ((TileLoader.ruin12 & seen_fused) != (getRuinHorizontal(12) & seen_fused)) {
                    HSYM = 0;
                }
                seen_fused = TileLoader.seen13 & getSeenHorizontal(13);
                if ((TileLoader.wall13 & seen_fused) != (getWallHorizontal(13) & seen_fused)) {
                    HSYM = 0;
                }
                if ((TileLoader.ruin13 & seen_fused) != (getRuinHorizontal(13) & seen_fused)) {
                    HSYM = 0;
                }
                seen_fused = TileLoader.seen14 & getSeenHorizontal(14);
                if ((TileLoader.wall14 & seen_fused) != (getWallHorizontal(14) & seen_fused)) {
                    HSYM = 0;
                }
                if ((TileLoader.ruin14 & seen_fused) != (getRuinHorizontal(14) & seen_fused)) {
                    HSYM = 0;
                }
                seen_fused = TileLoader.seen15 & getSeenHorizontal(15);
                if ((TileLoader.wall15 & seen_fused) != (getWallHorizontal(15) & seen_fused)) {
                    HSYM = 0;
                }
                if ((TileLoader.ruin15 & seen_fused) != (getRuinHorizontal(15) & seen_fused)) {
                    HSYM = 0;
                }
                seen_fused = TileLoader.seen16 & getSeenHorizontal(16);
                if ((TileLoader.wall16 & seen_fused) != (getWallHorizontal(16) & seen_fused)) {
                    HSYM = 0;
                }
                if ((TileLoader.ruin16 & seen_fused) != (getRuinHorizontal(16) & seen_fused)) {
                    HSYM = 0;
                }
                seen_fused = TileLoader.seen17 & getSeenHorizontal(17);
                if ((TileLoader.wall17 & seen_fused) != (getWallHorizontal(17) & seen_fused)) {
                    HSYM = 0;
                }
                if ((TileLoader.ruin17 & seen_fused) != (getRuinHorizontal(17) & seen_fused)) {
                    HSYM = 0;
                }
                seen_fused = TileLoader.seen18 & getSeenHorizontal(18);
                if ((TileLoader.wall18 & seen_fused) != (getWallHorizontal(18) & seen_fused)) {
                    HSYM = 0;
                }
                if ((TileLoader.ruin18 & seen_fused) != (getRuinHorizontal(18) & seen_fused)) {
                    HSYM = 0;
                }
                seen_fused = TileLoader.seen19 & getSeenHorizontal(19);
                if ((TileLoader.wall19 & seen_fused) != (getWallHorizontal(19) & seen_fused)) {
                    HSYM = 0;
                }
                if ((TileLoader.ruin19 & seen_fused) != (getRuinHorizontal(19) & seen_fused)) {
                    HSYM = 0;
                }
                
            }
            case 16 -> {
                seen_fused = TileLoader.seen12 & getSeenHorizontal(12);
                if ((TileLoader.wall12 & seen_fused) != (getWallHorizontal(12) & seen_fused)) {
                    HSYM = 0;
                }
                if ((TileLoader.ruin12 & seen_fused) != (getRuinHorizontal(12) & seen_fused)) {
                    HSYM = 0;
                }
                seen_fused = TileLoader.seen13 & getSeenHorizontal(13);
                if ((TileLoader.wall13 & seen_fused) != (getWallHorizontal(13) & seen_fused)) {
                    HSYM = 0;
                }
                if ((TileLoader.ruin13 & seen_fused) != (getRuinHorizontal(13) & seen_fused)) {
                    HSYM = 0;
                }
                seen_fused = TileLoader.seen14 & getSeenHorizontal(14);
                if ((TileLoader.wall14 & seen_fused) != (getWallHorizontal(14) & seen_fused)) {
                    HSYM = 0;
                }
                if ((TileLoader.ruin14 & seen_fused) != (getRuinHorizontal(14) & seen_fused)) {
                    HSYM = 0;
                }
                seen_fused = TileLoader.seen15 & getSeenHorizontal(15);
                if ((TileLoader.wall15 & seen_fused) != (getWallHorizontal(15) & seen_fused)) {
                    HSYM = 0;
                }
                if ((TileLoader.ruin15 & seen_fused) != (getRuinHorizontal(15) & seen_fused)) {
                    HSYM = 0;
                }
                seen_fused = TileLoader.seen16 & getSeenHorizontal(16);
                if ((TileLoader.wall16 & seen_fused) != (getWallHorizontal(16) & seen_fused)) {
                    HSYM = 0;
                }
                if ((TileLoader.ruin16 & seen_fused) != (getRuinHorizontal(16) & seen_fused)) {
                    HSYM = 0;
                }
                seen_fused = TileLoader.seen17 & getSeenHorizontal(17);
                if ((TileLoader.wall17 & seen_fused) != (getWallHorizontal(17) & seen_fused)) {
                    HSYM = 0;
                }
                if ((TileLoader.ruin17 & seen_fused) != (getRuinHorizontal(17) & seen_fused)) {
                    HSYM = 0;
                }
                seen_fused = TileLoader.seen18 & getSeenHorizontal(18);
                if ((TileLoader.wall18 & seen_fused) != (getWallHorizontal(18) & seen_fused)) {
                    HSYM = 0;
                }
                if ((TileLoader.ruin18 & seen_fused) != (getRuinHorizontal(18) & seen_fused)) {
                    HSYM = 0;
                }
                seen_fused = TileLoader.seen19 & getSeenHorizontal(19);
                if ((TileLoader.wall19 & seen_fused) != (getWallHorizontal(19) & seen_fused)) {
                    HSYM = 0;
                }
                if ((TileLoader.ruin19 & seen_fused) != (getRuinHorizontal(19) & seen_fused)) {
                    HSYM = 0;
                }
                seen_fused = TileLoader.seen20 & getSeenHorizontal(20);
                if ((TileLoader.wall20 & seen_fused) != (getWallHorizontal(20) & seen_fused)) {
                    HSYM = 0;
                }
                if ((TileLoader.ruin20 & seen_fused) != (getRuinHorizontal(20) & seen_fused)) {
                    HSYM = 0;
                }
                
            }
            case 17 -> {
                seen_fused = TileLoader.seen13 & getSeenHorizontal(13);
                if ((TileLoader.wall13 & seen_fused) != (getWallHorizontal(13) & seen_fused)) {
                    HSYM = 0;
                }
                if ((TileLoader.ruin13 & seen_fused) != (getRuinHorizontal(13) & seen_fused)) {
                    HSYM = 0;
                }
                seen_fused = TileLoader.seen14 & getSeenHorizontal(14);
                if ((TileLoader.wall14 & seen_fused) != (getWallHorizontal(14) & seen_fused)) {
                    HSYM = 0;
                }
                if ((TileLoader.ruin14 & seen_fused) != (getRuinHorizontal(14) & seen_fused)) {
                    HSYM = 0;
                }
                seen_fused = TileLoader.seen15 & getSeenHorizontal(15);
                if ((TileLoader.wall15 & seen_fused) != (getWallHorizontal(15) & seen_fused)) {
                    HSYM = 0;
                }
                if ((TileLoader.ruin15 & seen_fused) != (getRuinHorizontal(15) & seen_fused)) {
                    HSYM = 0;
                }
                seen_fused = TileLoader.seen16 & getSeenHorizontal(16);
                if ((TileLoader.wall16 & seen_fused) != (getWallHorizontal(16) & seen_fused)) {
                    HSYM = 0;
                }
                if ((TileLoader.ruin16 & seen_fused) != (getRuinHorizontal(16) & seen_fused)) {
                    HSYM = 0;
                }
                seen_fused = TileLoader.seen17 & getSeenHorizontal(17);
                if ((TileLoader.wall17 & seen_fused) != (getWallHorizontal(17) & seen_fused)) {
                    HSYM = 0;
                }
                if ((TileLoader.ruin17 & seen_fused) != (getRuinHorizontal(17) & seen_fused)) {
                    HSYM = 0;
                }
                seen_fused = TileLoader.seen18 & getSeenHorizontal(18);
                if ((TileLoader.wall18 & seen_fused) != (getWallHorizontal(18) & seen_fused)) {
                    HSYM = 0;
                }
                if ((TileLoader.ruin18 & seen_fused) != (getRuinHorizontal(18) & seen_fused)) {
                    HSYM = 0;
                }
                seen_fused = TileLoader.seen19 & getSeenHorizontal(19);
                if ((TileLoader.wall19 & seen_fused) != (getWallHorizontal(19) & seen_fused)) {
                    HSYM = 0;
                }
                if ((TileLoader.ruin19 & seen_fused) != (getRuinHorizontal(19) & seen_fused)) {
                    HSYM = 0;
                }
                seen_fused = TileLoader.seen20 & getSeenHorizontal(20);
                if ((TileLoader.wall20 & seen_fused) != (getWallHorizontal(20) & seen_fused)) {
                    HSYM = 0;
                }
                if ((TileLoader.ruin20 & seen_fused) != (getRuinHorizontal(20) & seen_fused)) {
                    HSYM = 0;
                }
                seen_fused = TileLoader.seen21 & getSeenHorizontal(21);
                if ((TileLoader.wall21 & seen_fused) != (getWallHorizontal(21) & seen_fused)) {
                    HSYM = 0;
                }
                if ((TileLoader.ruin21 & seen_fused) != (getRuinHorizontal(21) & seen_fused)) {
                    HSYM = 0;
                }
                
            }
            case 18 -> {
                seen_fused = TileLoader.seen14 & getSeenHorizontal(14);
                if ((TileLoader.wall14 & seen_fused) != (getWallHorizontal(14) & seen_fused)) {
                    HSYM = 0;
                }
                if ((TileLoader.ruin14 & seen_fused) != (getRuinHorizontal(14) & seen_fused)) {
                    HSYM = 0;
                }
                seen_fused = TileLoader.seen15 & getSeenHorizontal(15);
                if ((TileLoader.wall15 & seen_fused) != (getWallHorizontal(15) & seen_fused)) {
                    HSYM = 0;
                }
                if ((TileLoader.ruin15 & seen_fused) != (getRuinHorizontal(15) & seen_fused)) {
                    HSYM = 0;
                }
                seen_fused = TileLoader.seen16 & getSeenHorizontal(16);
                if ((TileLoader.wall16 & seen_fused) != (getWallHorizontal(16) & seen_fused)) {
                    HSYM = 0;
                }
                if ((TileLoader.ruin16 & seen_fused) != (getRuinHorizontal(16) & seen_fused)) {
                    HSYM = 0;
                }
                seen_fused = TileLoader.seen17 & getSeenHorizontal(17);
                if ((TileLoader.wall17 & seen_fused) != (getWallHorizontal(17) & seen_fused)) {
                    HSYM = 0;
                }
                if ((TileLoader.ruin17 & seen_fused) != (getRuinHorizontal(17) & seen_fused)) {
                    HSYM = 0;
                }
                seen_fused = TileLoader.seen18 & getSeenHorizontal(18);
                if ((TileLoader.wall18 & seen_fused) != (getWallHorizontal(18) & seen_fused)) {
                    HSYM = 0;
                }
                if ((TileLoader.ruin18 & seen_fused) != (getRuinHorizontal(18) & seen_fused)) {
                    HSYM = 0;
                }
                seen_fused = TileLoader.seen19 & getSeenHorizontal(19);
                if ((TileLoader.wall19 & seen_fused) != (getWallHorizontal(19) & seen_fused)) {
                    HSYM = 0;
                }
                if ((TileLoader.ruin19 & seen_fused) != (getRuinHorizontal(19) & seen_fused)) {
                    HSYM = 0;
                }
                seen_fused = TileLoader.seen20 & getSeenHorizontal(20);
                if ((TileLoader.wall20 & seen_fused) != (getWallHorizontal(20) & seen_fused)) {
                    HSYM = 0;
                }
                if ((TileLoader.ruin20 & seen_fused) != (getRuinHorizontal(20) & seen_fused)) {
                    HSYM = 0;
                }
                seen_fused = TileLoader.seen21 & getSeenHorizontal(21);
                if ((TileLoader.wall21 & seen_fused) != (getWallHorizontal(21) & seen_fused)) {
                    HSYM = 0;
                }
                if ((TileLoader.ruin21 & seen_fused) != (getRuinHorizontal(21) & seen_fused)) {
                    HSYM = 0;
                }
                seen_fused = TileLoader.seen22 & getSeenHorizontal(22);
                if ((TileLoader.wall22 & seen_fused) != (getWallHorizontal(22) & seen_fused)) {
                    HSYM = 0;
                }
                if ((TileLoader.ruin22 & seen_fused) != (getRuinHorizontal(22) & seen_fused)) {
                    HSYM = 0;
                }
                
            }
            case 19 -> {
                seen_fused = TileLoader.seen15 & getSeenHorizontal(15);
                if ((TileLoader.wall15 & seen_fused) != (getWallHorizontal(15) & seen_fused)) {
                    HSYM = 0;
                }
                if ((TileLoader.ruin15 & seen_fused) != (getRuinHorizontal(15) & seen_fused)) {
                    HSYM = 0;
                }
                seen_fused = TileLoader.seen16 & getSeenHorizontal(16);
                if ((TileLoader.wall16 & seen_fused) != (getWallHorizontal(16) & seen_fused)) {
                    HSYM = 0;
                }
                if ((TileLoader.ruin16 & seen_fused) != (getRuinHorizontal(16) & seen_fused)) {
                    HSYM = 0;
                }
                seen_fused = TileLoader.seen17 & getSeenHorizontal(17);
                if ((TileLoader.wall17 & seen_fused) != (getWallHorizontal(17) & seen_fused)) {
                    HSYM = 0;
                }
                if ((TileLoader.ruin17 & seen_fused) != (getRuinHorizontal(17) & seen_fused)) {
                    HSYM = 0;
                }
                seen_fused = TileLoader.seen18 & getSeenHorizontal(18);
                if ((TileLoader.wall18 & seen_fused) != (getWallHorizontal(18) & seen_fused)) {
                    HSYM = 0;
                }
                if ((TileLoader.ruin18 & seen_fused) != (getRuinHorizontal(18) & seen_fused)) {
                    HSYM = 0;
                }
                seen_fused = TileLoader.seen19 & getSeenHorizontal(19);
                if ((TileLoader.wall19 & seen_fused) != (getWallHorizontal(19) & seen_fused)) {
                    HSYM = 0;
                }
                if ((TileLoader.ruin19 & seen_fused) != (getRuinHorizontal(19) & seen_fused)) {
                    HSYM = 0;
                }
                seen_fused = TileLoader.seen20 & getSeenHorizontal(20);
                if ((TileLoader.wall20 & seen_fused) != (getWallHorizontal(20) & seen_fused)) {
                    HSYM = 0;
                }
                if ((TileLoader.ruin20 & seen_fused) != (getRuinHorizontal(20) & seen_fused)) {
                    HSYM = 0;
                }
                seen_fused = TileLoader.seen21 & getSeenHorizontal(21);
                if ((TileLoader.wall21 & seen_fused) != (getWallHorizontal(21) & seen_fused)) {
                    HSYM = 0;
                }
                if ((TileLoader.ruin21 & seen_fused) != (getRuinHorizontal(21) & seen_fused)) {
                    HSYM = 0;
                }
                seen_fused = TileLoader.seen22 & getSeenHorizontal(22);
                if ((TileLoader.wall22 & seen_fused) != (getWallHorizontal(22) & seen_fused)) {
                    HSYM = 0;
                }
                if ((TileLoader.ruin22 & seen_fused) != (getRuinHorizontal(22) & seen_fused)) {
                    HSYM = 0;
                }
                seen_fused = TileLoader.seen23 & getSeenHorizontal(23);
                if ((TileLoader.wall23 & seen_fused) != (getWallHorizontal(23) & seen_fused)) {
                    HSYM = 0;
                }
                if ((TileLoader.ruin23 & seen_fused) != (getRuinHorizontal(23) & seen_fused)) {
                    HSYM = 0;
                }
                
            }
            case 20 -> {
                seen_fused = TileLoader.seen16 & getSeenHorizontal(16);
                if ((TileLoader.wall16 & seen_fused) != (getWallHorizontal(16) & seen_fused)) {
                    HSYM = 0;
                }
                if ((TileLoader.ruin16 & seen_fused) != (getRuinHorizontal(16) & seen_fused)) {
                    HSYM = 0;
                }
                seen_fused = TileLoader.seen17 & getSeenHorizontal(17);
                if ((TileLoader.wall17 & seen_fused) != (getWallHorizontal(17) & seen_fused)) {
                    HSYM = 0;
                }
                if ((TileLoader.ruin17 & seen_fused) != (getRuinHorizontal(17) & seen_fused)) {
                    HSYM = 0;
                }
                seen_fused = TileLoader.seen18 & getSeenHorizontal(18);
                if ((TileLoader.wall18 & seen_fused) != (getWallHorizontal(18) & seen_fused)) {
                    HSYM = 0;
                }
                if ((TileLoader.ruin18 & seen_fused) != (getRuinHorizontal(18) & seen_fused)) {
                    HSYM = 0;
                }
                seen_fused = TileLoader.seen19 & getSeenHorizontal(19);
                if ((TileLoader.wall19 & seen_fused) != (getWallHorizontal(19) & seen_fused)) {
                    HSYM = 0;
                }
                if ((TileLoader.ruin19 & seen_fused) != (getRuinHorizontal(19) & seen_fused)) {
                    HSYM = 0;
                }
                seen_fused = TileLoader.seen20 & getSeenHorizontal(20);
                if ((TileLoader.wall20 & seen_fused) != (getWallHorizontal(20) & seen_fused)) {
                    HSYM = 0;
                }
                if ((TileLoader.ruin20 & seen_fused) != (getRuinHorizontal(20) & seen_fused)) {
                    HSYM = 0;
                }
                seen_fused = TileLoader.seen21 & getSeenHorizontal(21);
                if ((TileLoader.wall21 & seen_fused) != (getWallHorizontal(21) & seen_fused)) {
                    HSYM = 0;
                }
                if ((TileLoader.ruin21 & seen_fused) != (getRuinHorizontal(21) & seen_fused)) {
                    HSYM = 0;
                }
                seen_fused = TileLoader.seen22 & getSeenHorizontal(22);
                if ((TileLoader.wall22 & seen_fused) != (getWallHorizontal(22) & seen_fused)) {
                    HSYM = 0;
                }
                if ((TileLoader.ruin22 & seen_fused) != (getRuinHorizontal(22) & seen_fused)) {
                    HSYM = 0;
                }
                seen_fused = TileLoader.seen23 & getSeenHorizontal(23);
                if ((TileLoader.wall23 & seen_fused) != (getWallHorizontal(23) & seen_fused)) {
                    HSYM = 0;
                }
                if ((TileLoader.ruin23 & seen_fused) != (getRuinHorizontal(23) & seen_fused)) {
                    HSYM = 0;
                }
                seen_fused = TileLoader.seen24 & getSeenHorizontal(24);
                if ((TileLoader.wall24 & seen_fused) != (getWallHorizontal(24) & seen_fused)) {
                    HSYM = 0;
                }
                if ((TileLoader.ruin24 & seen_fused) != (getRuinHorizontal(24) & seen_fused)) {
                    HSYM = 0;
                }
                
            }
            case 21 -> {
                seen_fused = TileLoader.seen17 & getSeenHorizontal(17);
                if ((TileLoader.wall17 & seen_fused) != (getWallHorizontal(17) & seen_fused)) {
                    HSYM = 0;
                }
                if ((TileLoader.ruin17 & seen_fused) != (getRuinHorizontal(17) & seen_fused)) {
                    HSYM = 0;
                }
                seen_fused = TileLoader.seen18 & getSeenHorizontal(18);
                if ((TileLoader.wall18 & seen_fused) != (getWallHorizontal(18) & seen_fused)) {
                    HSYM = 0;
                }
                if ((TileLoader.ruin18 & seen_fused) != (getRuinHorizontal(18) & seen_fused)) {
                    HSYM = 0;
                }
                seen_fused = TileLoader.seen19 & getSeenHorizontal(19);
                if ((TileLoader.wall19 & seen_fused) != (getWallHorizontal(19) & seen_fused)) {
                    HSYM = 0;
                }
                if ((TileLoader.ruin19 & seen_fused) != (getRuinHorizontal(19) & seen_fused)) {
                    HSYM = 0;
                }
                seen_fused = TileLoader.seen20 & getSeenHorizontal(20);
                if ((TileLoader.wall20 & seen_fused) != (getWallHorizontal(20) & seen_fused)) {
                    HSYM = 0;
                }
                if ((TileLoader.ruin20 & seen_fused) != (getRuinHorizontal(20) & seen_fused)) {
                    HSYM = 0;
                }
                seen_fused = TileLoader.seen21 & getSeenHorizontal(21);
                if ((TileLoader.wall21 & seen_fused) != (getWallHorizontal(21) & seen_fused)) {
                    HSYM = 0;
                }
                if ((TileLoader.ruin21 & seen_fused) != (getRuinHorizontal(21) & seen_fused)) {
                    HSYM = 0;
                }
                seen_fused = TileLoader.seen22 & getSeenHorizontal(22);
                if ((TileLoader.wall22 & seen_fused) != (getWallHorizontal(22) & seen_fused)) {
                    HSYM = 0;
                }
                if ((TileLoader.ruin22 & seen_fused) != (getRuinHorizontal(22) & seen_fused)) {
                    HSYM = 0;
                }
                seen_fused = TileLoader.seen23 & getSeenHorizontal(23);
                if ((TileLoader.wall23 & seen_fused) != (getWallHorizontal(23) & seen_fused)) {
                    HSYM = 0;
                }
                if ((TileLoader.ruin23 & seen_fused) != (getRuinHorizontal(23) & seen_fused)) {
                    HSYM = 0;
                }
                seen_fused = TileLoader.seen24 & getSeenHorizontal(24);
                if ((TileLoader.wall24 & seen_fused) != (getWallHorizontal(24) & seen_fused)) {
                    HSYM = 0;
                }
                if ((TileLoader.ruin24 & seen_fused) != (getRuinHorizontal(24) & seen_fused)) {
                    HSYM = 0;
                }
                seen_fused = TileLoader.seen25 & getSeenHorizontal(25);
                if ((TileLoader.wall25 & seen_fused) != (getWallHorizontal(25) & seen_fused)) {
                    HSYM = 0;
                }
                if ((TileLoader.ruin25 & seen_fused) != (getRuinHorizontal(25) & seen_fused)) {
                    HSYM = 0;
                }
                
            }
            case 22 -> {
                seen_fused = TileLoader.seen18 & getSeenHorizontal(18);
                if ((TileLoader.wall18 & seen_fused) != (getWallHorizontal(18) & seen_fused)) {
                    HSYM = 0;
                }
                if ((TileLoader.ruin18 & seen_fused) != (getRuinHorizontal(18) & seen_fused)) {
                    HSYM = 0;
                }
                seen_fused = TileLoader.seen19 & getSeenHorizontal(19);
                if ((TileLoader.wall19 & seen_fused) != (getWallHorizontal(19) & seen_fused)) {
                    HSYM = 0;
                }
                if ((TileLoader.ruin19 & seen_fused) != (getRuinHorizontal(19) & seen_fused)) {
                    HSYM = 0;
                }
                seen_fused = TileLoader.seen20 & getSeenHorizontal(20);
                if ((TileLoader.wall20 & seen_fused) != (getWallHorizontal(20) & seen_fused)) {
                    HSYM = 0;
                }
                if ((TileLoader.ruin20 & seen_fused) != (getRuinHorizontal(20) & seen_fused)) {
                    HSYM = 0;
                }
                seen_fused = TileLoader.seen21 & getSeenHorizontal(21);
                if ((TileLoader.wall21 & seen_fused) != (getWallHorizontal(21) & seen_fused)) {
                    HSYM = 0;
                }
                if ((TileLoader.ruin21 & seen_fused) != (getRuinHorizontal(21) & seen_fused)) {
                    HSYM = 0;
                }
                seen_fused = TileLoader.seen22 & getSeenHorizontal(22);
                if ((TileLoader.wall22 & seen_fused) != (getWallHorizontal(22) & seen_fused)) {
                    HSYM = 0;
                }
                if ((TileLoader.ruin22 & seen_fused) != (getRuinHorizontal(22) & seen_fused)) {
                    HSYM = 0;
                }
                seen_fused = TileLoader.seen23 & getSeenHorizontal(23);
                if ((TileLoader.wall23 & seen_fused) != (getWallHorizontal(23) & seen_fused)) {
                    HSYM = 0;
                }
                if ((TileLoader.ruin23 & seen_fused) != (getRuinHorizontal(23) & seen_fused)) {
                    HSYM = 0;
                }
                seen_fused = TileLoader.seen24 & getSeenHorizontal(24);
                if ((TileLoader.wall24 & seen_fused) != (getWallHorizontal(24) & seen_fused)) {
                    HSYM = 0;
                }
                if ((TileLoader.ruin24 & seen_fused) != (getRuinHorizontal(24) & seen_fused)) {
                    HSYM = 0;
                }
                seen_fused = TileLoader.seen25 & getSeenHorizontal(25);
                if ((TileLoader.wall25 & seen_fused) != (getWallHorizontal(25) & seen_fused)) {
                    HSYM = 0;
                }
                if ((TileLoader.ruin25 & seen_fused) != (getRuinHorizontal(25) & seen_fused)) {
                    HSYM = 0;
                }
                seen_fused = TileLoader.seen26 & getSeenHorizontal(26);
                if ((TileLoader.wall26 & seen_fused) != (getWallHorizontal(26) & seen_fused)) {
                    HSYM = 0;
                }
                if ((TileLoader.ruin26 & seen_fused) != (getRuinHorizontal(26) & seen_fused)) {
                    HSYM = 0;
                }
                
            }
            case 23 -> {
                seen_fused = TileLoader.seen19 & getSeenHorizontal(19);
                if ((TileLoader.wall19 & seen_fused) != (getWallHorizontal(19) & seen_fused)) {
                    HSYM = 0;
                }
                if ((TileLoader.ruin19 & seen_fused) != (getRuinHorizontal(19) & seen_fused)) {
                    HSYM = 0;
                }
                seen_fused = TileLoader.seen20 & getSeenHorizontal(20);
                if ((TileLoader.wall20 & seen_fused) != (getWallHorizontal(20) & seen_fused)) {
                    HSYM = 0;
                }
                if ((TileLoader.ruin20 & seen_fused) != (getRuinHorizontal(20) & seen_fused)) {
                    HSYM = 0;
                }
                seen_fused = TileLoader.seen21 & getSeenHorizontal(21);
                if ((TileLoader.wall21 & seen_fused) != (getWallHorizontal(21) & seen_fused)) {
                    HSYM = 0;
                }
                if ((TileLoader.ruin21 & seen_fused) != (getRuinHorizontal(21) & seen_fused)) {
                    HSYM = 0;
                }
                seen_fused = TileLoader.seen22 & getSeenHorizontal(22);
                if ((TileLoader.wall22 & seen_fused) != (getWallHorizontal(22) & seen_fused)) {
                    HSYM = 0;
                }
                if ((TileLoader.ruin22 & seen_fused) != (getRuinHorizontal(22) & seen_fused)) {
                    HSYM = 0;
                }
                seen_fused = TileLoader.seen23 & getSeenHorizontal(23);
                if ((TileLoader.wall23 & seen_fused) != (getWallHorizontal(23) & seen_fused)) {
                    HSYM = 0;
                }
                if ((TileLoader.ruin23 & seen_fused) != (getRuinHorizontal(23) & seen_fused)) {
                    HSYM = 0;
                }
                seen_fused = TileLoader.seen24 & getSeenHorizontal(24);
                if ((TileLoader.wall24 & seen_fused) != (getWallHorizontal(24) & seen_fused)) {
                    HSYM = 0;
                }
                if ((TileLoader.ruin24 & seen_fused) != (getRuinHorizontal(24) & seen_fused)) {
                    HSYM = 0;
                }
                seen_fused = TileLoader.seen25 & getSeenHorizontal(25);
                if ((TileLoader.wall25 & seen_fused) != (getWallHorizontal(25) & seen_fused)) {
                    HSYM = 0;
                }
                if ((TileLoader.ruin25 & seen_fused) != (getRuinHorizontal(25) & seen_fused)) {
                    HSYM = 0;
                }
                seen_fused = TileLoader.seen26 & getSeenHorizontal(26);
                if ((TileLoader.wall26 & seen_fused) != (getWallHorizontal(26) & seen_fused)) {
                    HSYM = 0;
                }
                if ((TileLoader.ruin26 & seen_fused) != (getRuinHorizontal(26) & seen_fused)) {
                    HSYM = 0;
                }
                seen_fused = TileLoader.seen27 & getSeenHorizontal(27);
                if ((TileLoader.wall27 & seen_fused) != (getWallHorizontal(27) & seen_fused)) {
                    HSYM = 0;
                }
                if ((TileLoader.ruin27 & seen_fused) != (getRuinHorizontal(27) & seen_fused)) {
                    HSYM = 0;
                }
                
            }
            case 24 -> {
                seen_fused = TileLoader.seen20 & getSeenHorizontal(20);
                if ((TileLoader.wall20 & seen_fused) != (getWallHorizontal(20) & seen_fused)) {
                    HSYM = 0;
                }
                if ((TileLoader.ruin20 & seen_fused) != (getRuinHorizontal(20) & seen_fused)) {
                    HSYM = 0;
                }
                seen_fused = TileLoader.seen21 & getSeenHorizontal(21);
                if ((TileLoader.wall21 & seen_fused) != (getWallHorizontal(21) & seen_fused)) {
                    HSYM = 0;
                }
                if ((TileLoader.ruin21 & seen_fused) != (getRuinHorizontal(21) & seen_fused)) {
                    HSYM = 0;
                }
                seen_fused = TileLoader.seen22 & getSeenHorizontal(22);
                if ((TileLoader.wall22 & seen_fused) != (getWallHorizontal(22) & seen_fused)) {
                    HSYM = 0;
                }
                if ((TileLoader.ruin22 & seen_fused) != (getRuinHorizontal(22) & seen_fused)) {
                    HSYM = 0;
                }
                seen_fused = TileLoader.seen23 & getSeenHorizontal(23);
                if ((TileLoader.wall23 & seen_fused) != (getWallHorizontal(23) & seen_fused)) {
                    HSYM = 0;
                }
                if ((TileLoader.ruin23 & seen_fused) != (getRuinHorizontal(23) & seen_fused)) {
                    HSYM = 0;
                }
                seen_fused = TileLoader.seen24 & getSeenHorizontal(24);
                if ((TileLoader.wall24 & seen_fused) != (getWallHorizontal(24) & seen_fused)) {
                    HSYM = 0;
                }
                if ((TileLoader.ruin24 & seen_fused) != (getRuinHorizontal(24) & seen_fused)) {
                    HSYM = 0;
                }
                seen_fused = TileLoader.seen25 & getSeenHorizontal(25);
                if ((TileLoader.wall25 & seen_fused) != (getWallHorizontal(25) & seen_fused)) {
                    HSYM = 0;
                }
                if ((TileLoader.ruin25 & seen_fused) != (getRuinHorizontal(25) & seen_fused)) {
                    HSYM = 0;
                }
                seen_fused = TileLoader.seen26 & getSeenHorizontal(26);
                if ((TileLoader.wall26 & seen_fused) != (getWallHorizontal(26) & seen_fused)) {
                    HSYM = 0;
                }
                if ((TileLoader.ruin26 & seen_fused) != (getRuinHorizontal(26) & seen_fused)) {
                    HSYM = 0;
                }
                seen_fused = TileLoader.seen27 & getSeenHorizontal(27);
                if ((TileLoader.wall27 & seen_fused) != (getWallHorizontal(27) & seen_fused)) {
                    HSYM = 0;
                }
                if ((TileLoader.ruin27 & seen_fused) != (getRuinHorizontal(27) & seen_fused)) {
                    HSYM = 0;
                }
                seen_fused = TileLoader.seen28 & getSeenHorizontal(28);
                if ((TileLoader.wall28 & seen_fused) != (getWallHorizontal(28) & seen_fused)) {
                    HSYM = 0;
                }
                if ((TileLoader.ruin28 & seen_fused) != (getRuinHorizontal(28) & seen_fused)) {
                    HSYM = 0;
                }
                
            }
            case 25 -> {
                seen_fused = TileLoader.seen21 & getSeenHorizontal(21);
                if ((TileLoader.wall21 & seen_fused) != (getWallHorizontal(21) & seen_fused)) {
                    HSYM = 0;
                }
                if ((TileLoader.ruin21 & seen_fused) != (getRuinHorizontal(21) & seen_fused)) {
                    HSYM = 0;
                }
                seen_fused = TileLoader.seen22 & getSeenHorizontal(22);
                if ((TileLoader.wall22 & seen_fused) != (getWallHorizontal(22) & seen_fused)) {
                    HSYM = 0;
                }
                if ((TileLoader.ruin22 & seen_fused) != (getRuinHorizontal(22) & seen_fused)) {
                    HSYM = 0;
                }
                seen_fused = TileLoader.seen23 & getSeenHorizontal(23);
                if ((TileLoader.wall23 & seen_fused) != (getWallHorizontal(23) & seen_fused)) {
                    HSYM = 0;
                }
                if ((TileLoader.ruin23 & seen_fused) != (getRuinHorizontal(23) & seen_fused)) {
                    HSYM = 0;
                }
                seen_fused = TileLoader.seen24 & getSeenHorizontal(24);
                if ((TileLoader.wall24 & seen_fused) != (getWallHorizontal(24) & seen_fused)) {
                    HSYM = 0;
                }
                if ((TileLoader.ruin24 & seen_fused) != (getRuinHorizontal(24) & seen_fused)) {
                    HSYM = 0;
                }
                seen_fused = TileLoader.seen25 & getSeenHorizontal(25);
                if ((TileLoader.wall25 & seen_fused) != (getWallHorizontal(25) & seen_fused)) {
                    HSYM = 0;
                }
                if ((TileLoader.ruin25 & seen_fused) != (getRuinHorizontal(25) & seen_fused)) {
                    HSYM = 0;
                }
                seen_fused = TileLoader.seen26 & getSeenHorizontal(26);
                if ((TileLoader.wall26 & seen_fused) != (getWallHorizontal(26) & seen_fused)) {
                    HSYM = 0;
                }
                if ((TileLoader.ruin26 & seen_fused) != (getRuinHorizontal(26) & seen_fused)) {
                    HSYM = 0;
                }
                seen_fused = TileLoader.seen27 & getSeenHorizontal(27);
                if ((TileLoader.wall27 & seen_fused) != (getWallHorizontal(27) & seen_fused)) {
                    HSYM = 0;
                }
                if ((TileLoader.ruin27 & seen_fused) != (getRuinHorizontal(27) & seen_fused)) {
                    HSYM = 0;
                }
                seen_fused = TileLoader.seen28 & getSeenHorizontal(28);
                if ((TileLoader.wall28 & seen_fused) != (getWallHorizontal(28) & seen_fused)) {
                    HSYM = 0;
                }
                if ((TileLoader.ruin28 & seen_fused) != (getRuinHorizontal(28) & seen_fused)) {
                    HSYM = 0;
                }
                seen_fused = TileLoader.seen29 & getSeenHorizontal(29);
                if ((TileLoader.wall29 & seen_fused) != (getWallHorizontal(29) & seen_fused)) {
                    HSYM = 0;
                }
                if ((TileLoader.ruin29 & seen_fused) != (getRuinHorizontal(29) & seen_fused)) {
                    HSYM = 0;
                }
                
            }
            case 26 -> {
                seen_fused = TileLoader.seen22 & getSeenHorizontal(22);
                if ((TileLoader.wall22 & seen_fused) != (getWallHorizontal(22) & seen_fused)) {
                    HSYM = 0;
                }
                if ((TileLoader.ruin22 & seen_fused) != (getRuinHorizontal(22) & seen_fused)) {
                    HSYM = 0;
                }
                seen_fused = TileLoader.seen23 & getSeenHorizontal(23);
                if ((TileLoader.wall23 & seen_fused) != (getWallHorizontal(23) & seen_fused)) {
                    HSYM = 0;
                }
                if ((TileLoader.ruin23 & seen_fused) != (getRuinHorizontal(23) & seen_fused)) {
                    HSYM = 0;
                }
                seen_fused = TileLoader.seen24 & getSeenHorizontal(24);
                if ((TileLoader.wall24 & seen_fused) != (getWallHorizontal(24) & seen_fused)) {
                    HSYM = 0;
                }
                if ((TileLoader.ruin24 & seen_fused) != (getRuinHorizontal(24) & seen_fused)) {
                    HSYM = 0;
                }
                seen_fused = TileLoader.seen25 & getSeenHorizontal(25);
                if ((TileLoader.wall25 & seen_fused) != (getWallHorizontal(25) & seen_fused)) {
                    HSYM = 0;
                }
                if ((TileLoader.ruin25 & seen_fused) != (getRuinHorizontal(25) & seen_fused)) {
                    HSYM = 0;
                }
                seen_fused = TileLoader.seen26 & getSeenHorizontal(26);
                if ((TileLoader.wall26 & seen_fused) != (getWallHorizontal(26) & seen_fused)) {
                    HSYM = 0;
                }
                if ((TileLoader.ruin26 & seen_fused) != (getRuinHorizontal(26) & seen_fused)) {
                    HSYM = 0;
                }
                seen_fused = TileLoader.seen27 & getSeenHorizontal(27);
                if ((TileLoader.wall27 & seen_fused) != (getWallHorizontal(27) & seen_fused)) {
                    HSYM = 0;
                }
                if ((TileLoader.ruin27 & seen_fused) != (getRuinHorizontal(27) & seen_fused)) {
                    HSYM = 0;
                }
                seen_fused = TileLoader.seen28 & getSeenHorizontal(28);
                if ((TileLoader.wall28 & seen_fused) != (getWallHorizontal(28) & seen_fused)) {
                    HSYM = 0;
                }
                if ((TileLoader.ruin28 & seen_fused) != (getRuinHorizontal(28) & seen_fused)) {
                    HSYM = 0;
                }
                seen_fused = TileLoader.seen29 & getSeenHorizontal(29);
                if ((TileLoader.wall29 & seen_fused) != (getWallHorizontal(29) & seen_fused)) {
                    HSYM = 0;
                }
                if ((TileLoader.ruin29 & seen_fused) != (getRuinHorizontal(29) & seen_fused)) {
                    HSYM = 0;
                }
                seen_fused = TileLoader.seen30 & getSeenHorizontal(30);
                if ((TileLoader.wall30 & seen_fused) != (getWallHorizontal(30) & seen_fused)) {
                    HSYM = 0;
                }
                if ((TileLoader.ruin30 & seen_fused) != (getRuinHorizontal(30) & seen_fused)) {
                    HSYM = 0;
                }
                
            }
            case 27 -> {
                seen_fused = TileLoader.seen23 & getSeenHorizontal(23);
                if ((TileLoader.wall23 & seen_fused) != (getWallHorizontal(23) & seen_fused)) {
                    HSYM = 0;
                }
                if ((TileLoader.ruin23 & seen_fused) != (getRuinHorizontal(23) & seen_fused)) {
                    HSYM = 0;
                }
                seen_fused = TileLoader.seen24 & getSeenHorizontal(24);
                if ((TileLoader.wall24 & seen_fused) != (getWallHorizontal(24) & seen_fused)) {
                    HSYM = 0;
                }
                if ((TileLoader.ruin24 & seen_fused) != (getRuinHorizontal(24) & seen_fused)) {
                    HSYM = 0;
                }
                seen_fused = TileLoader.seen25 & getSeenHorizontal(25);
                if ((TileLoader.wall25 & seen_fused) != (getWallHorizontal(25) & seen_fused)) {
                    HSYM = 0;
                }
                if ((TileLoader.ruin25 & seen_fused) != (getRuinHorizontal(25) & seen_fused)) {
                    HSYM = 0;
                }
                seen_fused = TileLoader.seen26 & getSeenHorizontal(26);
                if ((TileLoader.wall26 & seen_fused) != (getWallHorizontal(26) & seen_fused)) {
                    HSYM = 0;
                }
                if ((TileLoader.ruin26 & seen_fused) != (getRuinHorizontal(26) & seen_fused)) {
                    HSYM = 0;
                }
                seen_fused = TileLoader.seen27 & getSeenHorizontal(27);
                if ((TileLoader.wall27 & seen_fused) != (getWallHorizontal(27) & seen_fused)) {
                    HSYM = 0;
                }
                if ((TileLoader.ruin27 & seen_fused) != (getRuinHorizontal(27) & seen_fused)) {
                    HSYM = 0;
                }
                seen_fused = TileLoader.seen28 & getSeenHorizontal(28);
                if ((TileLoader.wall28 & seen_fused) != (getWallHorizontal(28) & seen_fused)) {
                    HSYM = 0;
                }
                if ((TileLoader.ruin28 & seen_fused) != (getRuinHorizontal(28) & seen_fused)) {
                    HSYM = 0;
                }
                seen_fused = TileLoader.seen29 & getSeenHorizontal(29);
                if ((TileLoader.wall29 & seen_fused) != (getWallHorizontal(29) & seen_fused)) {
                    HSYM = 0;
                }
                if ((TileLoader.ruin29 & seen_fused) != (getRuinHorizontal(29) & seen_fused)) {
                    HSYM = 0;
                }
                seen_fused = TileLoader.seen30 & getSeenHorizontal(30);
                if ((TileLoader.wall30 & seen_fused) != (getWallHorizontal(30) & seen_fused)) {
                    HSYM = 0;
                }
                if ((TileLoader.ruin30 & seen_fused) != (getRuinHorizontal(30) & seen_fused)) {
                    HSYM = 0;
                }
                seen_fused = TileLoader.seen31 & getSeenHorizontal(31);
                if ((TileLoader.wall31 & seen_fused) != (getWallHorizontal(31) & seen_fused)) {
                    HSYM = 0;
                }
                if ((TileLoader.ruin31 & seen_fused) != (getRuinHorizontal(31) & seen_fused)) {
                    HSYM = 0;
                }
                
            }
            case 28 -> {
                seen_fused = TileLoader.seen24 & getSeenHorizontal(24);
                if ((TileLoader.wall24 & seen_fused) != (getWallHorizontal(24) & seen_fused)) {
                    HSYM = 0;
                }
                if ((TileLoader.ruin24 & seen_fused) != (getRuinHorizontal(24) & seen_fused)) {
                    HSYM = 0;
                }
                seen_fused = TileLoader.seen25 & getSeenHorizontal(25);
                if ((TileLoader.wall25 & seen_fused) != (getWallHorizontal(25) & seen_fused)) {
                    HSYM = 0;
                }
                if ((TileLoader.ruin25 & seen_fused) != (getRuinHorizontal(25) & seen_fused)) {
                    HSYM = 0;
                }
                seen_fused = TileLoader.seen26 & getSeenHorizontal(26);
                if ((TileLoader.wall26 & seen_fused) != (getWallHorizontal(26) & seen_fused)) {
                    HSYM = 0;
                }
                if ((TileLoader.ruin26 & seen_fused) != (getRuinHorizontal(26) & seen_fused)) {
                    HSYM = 0;
                }
                seen_fused = TileLoader.seen27 & getSeenHorizontal(27);
                if ((TileLoader.wall27 & seen_fused) != (getWallHorizontal(27) & seen_fused)) {
                    HSYM = 0;
                }
                if ((TileLoader.ruin27 & seen_fused) != (getRuinHorizontal(27) & seen_fused)) {
                    HSYM = 0;
                }
                seen_fused = TileLoader.seen28 & getSeenHorizontal(28);
                if ((TileLoader.wall28 & seen_fused) != (getWallHorizontal(28) & seen_fused)) {
                    HSYM = 0;
                }
                if ((TileLoader.ruin28 & seen_fused) != (getRuinHorizontal(28) & seen_fused)) {
                    HSYM = 0;
                }
                seen_fused = TileLoader.seen29 & getSeenHorizontal(29);
                if ((TileLoader.wall29 & seen_fused) != (getWallHorizontal(29) & seen_fused)) {
                    HSYM = 0;
                }
                if ((TileLoader.ruin29 & seen_fused) != (getRuinHorizontal(29) & seen_fused)) {
                    HSYM = 0;
                }
                seen_fused = TileLoader.seen30 & getSeenHorizontal(30);
                if ((TileLoader.wall30 & seen_fused) != (getWallHorizontal(30) & seen_fused)) {
                    HSYM = 0;
                }
                if ((TileLoader.ruin30 & seen_fused) != (getRuinHorizontal(30) & seen_fused)) {
                    HSYM = 0;
                }
                seen_fused = TileLoader.seen31 & getSeenHorizontal(31);
                if ((TileLoader.wall31 & seen_fused) != (getWallHorizontal(31) & seen_fused)) {
                    HSYM = 0;
                }
                if ((TileLoader.ruin31 & seen_fused) != (getRuinHorizontal(31) & seen_fused)) {
                    HSYM = 0;
                }
                seen_fused = TileLoader.seen32 & getSeenHorizontal(32);
                if ((TileLoader.wall32 & seen_fused) != (getWallHorizontal(32) & seen_fused)) {
                    HSYM = 0;
                }
                if ((TileLoader.ruin32 & seen_fused) != (getRuinHorizontal(32) & seen_fused)) {
                    HSYM = 0;
                }
                
            }
            case 29 -> {
                seen_fused = TileLoader.seen25 & getSeenHorizontal(25);
                if ((TileLoader.wall25 & seen_fused) != (getWallHorizontal(25) & seen_fused)) {
                    HSYM = 0;
                }
                if ((TileLoader.ruin25 & seen_fused) != (getRuinHorizontal(25) & seen_fused)) {
                    HSYM = 0;
                }
                seen_fused = TileLoader.seen26 & getSeenHorizontal(26);
                if ((TileLoader.wall26 & seen_fused) != (getWallHorizontal(26) & seen_fused)) {
                    HSYM = 0;
                }
                if ((TileLoader.ruin26 & seen_fused) != (getRuinHorizontal(26) & seen_fused)) {
                    HSYM = 0;
                }
                seen_fused = TileLoader.seen27 & getSeenHorizontal(27);
                if ((TileLoader.wall27 & seen_fused) != (getWallHorizontal(27) & seen_fused)) {
                    HSYM = 0;
                }
                if ((TileLoader.ruin27 & seen_fused) != (getRuinHorizontal(27) & seen_fused)) {
                    HSYM = 0;
                }
                seen_fused = TileLoader.seen28 & getSeenHorizontal(28);
                if ((TileLoader.wall28 & seen_fused) != (getWallHorizontal(28) & seen_fused)) {
                    HSYM = 0;
                }
                if ((TileLoader.ruin28 & seen_fused) != (getRuinHorizontal(28) & seen_fused)) {
                    HSYM = 0;
                }
                seen_fused = TileLoader.seen29 & getSeenHorizontal(29);
                if ((TileLoader.wall29 & seen_fused) != (getWallHorizontal(29) & seen_fused)) {
                    HSYM = 0;
                }
                if ((TileLoader.ruin29 & seen_fused) != (getRuinHorizontal(29) & seen_fused)) {
                    HSYM = 0;
                }
                seen_fused = TileLoader.seen30 & getSeenHorizontal(30);
                if ((TileLoader.wall30 & seen_fused) != (getWallHorizontal(30) & seen_fused)) {
                    HSYM = 0;
                }
                if ((TileLoader.ruin30 & seen_fused) != (getRuinHorizontal(30) & seen_fused)) {
                    HSYM = 0;
                }
                seen_fused = TileLoader.seen31 & getSeenHorizontal(31);
                if ((TileLoader.wall31 & seen_fused) != (getWallHorizontal(31) & seen_fused)) {
                    HSYM = 0;
                }
                if ((TileLoader.ruin31 & seen_fused) != (getRuinHorizontal(31) & seen_fused)) {
                    HSYM = 0;
                }
                seen_fused = TileLoader.seen32 & getSeenHorizontal(32);
                if ((TileLoader.wall32 & seen_fused) != (getWallHorizontal(32) & seen_fused)) {
                    HSYM = 0;
                }
                if ((TileLoader.ruin32 & seen_fused) != (getRuinHorizontal(32) & seen_fused)) {
                    HSYM = 0;
                }
                seen_fused = TileLoader.seen33 & getSeenHorizontal(33);
                if ((TileLoader.wall33 & seen_fused) != (getWallHorizontal(33) & seen_fused)) {
                    HSYM = 0;
                }
                if ((TileLoader.ruin33 & seen_fused) != (getRuinHorizontal(33) & seen_fused)) {
                    HSYM = 0;
                }
                
            }
            case 30 -> {
                seen_fused = TileLoader.seen26 & getSeenHorizontal(26);
                if ((TileLoader.wall26 & seen_fused) != (getWallHorizontal(26) & seen_fused)) {
                    HSYM = 0;
                }
                if ((TileLoader.ruin26 & seen_fused) != (getRuinHorizontal(26) & seen_fused)) {
                    HSYM = 0;
                }
                seen_fused = TileLoader.seen27 & getSeenHorizontal(27);
                if ((TileLoader.wall27 & seen_fused) != (getWallHorizontal(27) & seen_fused)) {
                    HSYM = 0;
                }
                if ((TileLoader.ruin27 & seen_fused) != (getRuinHorizontal(27) & seen_fused)) {
                    HSYM = 0;
                }
                seen_fused = TileLoader.seen28 & getSeenHorizontal(28);
                if ((TileLoader.wall28 & seen_fused) != (getWallHorizontal(28) & seen_fused)) {
                    HSYM = 0;
                }
                if ((TileLoader.ruin28 & seen_fused) != (getRuinHorizontal(28) & seen_fused)) {
                    HSYM = 0;
                }
                seen_fused = TileLoader.seen29 & getSeenHorizontal(29);
                if ((TileLoader.wall29 & seen_fused) != (getWallHorizontal(29) & seen_fused)) {
                    HSYM = 0;
                }
                if ((TileLoader.ruin29 & seen_fused) != (getRuinHorizontal(29) & seen_fused)) {
                    HSYM = 0;
                }
                seen_fused = TileLoader.seen30 & getSeenHorizontal(30);
                if ((TileLoader.wall30 & seen_fused) != (getWallHorizontal(30) & seen_fused)) {
                    HSYM = 0;
                }
                if ((TileLoader.ruin30 & seen_fused) != (getRuinHorizontal(30) & seen_fused)) {
                    HSYM = 0;
                }
                seen_fused = TileLoader.seen31 & getSeenHorizontal(31);
                if ((TileLoader.wall31 & seen_fused) != (getWallHorizontal(31) & seen_fused)) {
                    HSYM = 0;
                }
                if ((TileLoader.ruin31 & seen_fused) != (getRuinHorizontal(31) & seen_fused)) {
                    HSYM = 0;
                }
                seen_fused = TileLoader.seen32 & getSeenHorizontal(32);
                if ((TileLoader.wall32 & seen_fused) != (getWallHorizontal(32) & seen_fused)) {
                    HSYM = 0;
                }
                if ((TileLoader.ruin32 & seen_fused) != (getRuinHorizontal(32) & seen_fused)) {
                    HSYM = 0;
                }
                seen_fused = TileLoader.seen33 & getSeenHorizontal(33);
                if ((TileLoader.wall33 & seen_fused) != (getWallHorizontal(33) & seen_fused)) {
                    HSYM = 0;
                }
                if ((TileLoader.ruin33 & seen_fused) != (getRuinHorizontal(33) & seen_fused)) {
                    HSYM = 0;
                }
                seen_fused = TileLoader.seen34 & getSeenHorizontal(34);
                if ((TileLoader.wall34 & seen_fused) != (getWallHorizontal(34) & seen_fused)) {
                    HSYM = 0;
                }
                if ((TileLoader.ruin34 & seen_fused) != (getRuinHorizontal(34) & seen_fused)) {
                    HSYM = 0;
                }
                
            }
            case 31 -> {
                seen_fused = TileLoader.seen27 & getSeenHorizontal(27);
                if ((TileLoader.wall27 & seen_fused) != (getWallHorizontal(27) & seen_fused)) {
                    HSYM = 0;
                }
                if ((TileLoader.ruin27 & seen_fused) != (getRuinHorizontal(27) & seen_fused)) {
                    HSYM = 0;
                }
                seen_fused = TileLoader.seen28 & getSeenHorizontal(28);
                if ((TileLoader.wall28 & seen_fused) != (getWallHorizontal(28) & seen_fused)) {
                    HSYM = 0;
                }
                if ((TileLoader.ruin28 & seen_fused) != (getRuinHorizontal(28) & seen_fused)) {
                    HSYM = 0;
                }
                seen_fused = TileLoader.seen29 & getSeenHorizontal(29);
                if ((TileLoader.wall29 & seen_fused) != (getWallHorizontal(29) & seen_fused)) {
                    HSYM = 0;
                }
                if ((TileLoader.ruin29 & seen_fused) != (getRuinHorizontal(29) & seen_fused)) {
                    HSYM = 0;
                }
                seen_fused = TileLoader.seen30 & getSeenHorizontal(30);
                if ((TileLoader.wall30 & seen_fused) != (getWallHorizontal(30) & seen_fused)) {
                    HSYM = 0;
                }
                if ((TileLoader.ruin30 & seen_fused) != (getRuinHorizontal(30) & seen_fused)) {
                    HSYM = 0;
                }
                seen_fused = TileLoader.seen31 & getSeenHorizontal(31);
                if ((TileLoader.wall31 & seen_fused) != (getWallHorizontal(31) & seen_fused)) {
                    HSYM = 0;
                }
                if ((TileLoader.ruin31 & seen_fused) != (getRuinHorizontal(31) & seen_fused)) {
                    HSYM = 0;
                }
                seen_fused = TileLoader.seen32 & getSeenHorizontal(32);
                if ((TileLoader.wall32 & seen_fused) != (getWallHorizontal(32) & seen_fused)) {
                    HSYM = 0;
                }
                if ((TileLoader.ruin32 & seen_fused) != (getRuinHorizontal(32) & seen_fused)) {
                    HSYM = 0;
                }
                seen_fused = TileLoader.seen33 & getSeenHorizontal(33);
                if ((TileLoader.wall33 & seen_fused) != (getWallHorizontal(33) & seen_fused)) {
                    HSYM = 0;
                }
                if ((TileLoader.ruin33 & seen_fused) != (getRuinHorizontal(33) & seen_fused)) {
                    HSYM = 0;
                }
                seen_fused = TileLoader.seen34 & getSeenHorizontal(34);
                if ((TileLoader.wall34 & seen_fused) != (getWallHorizontal(34) & seen_fused)) {
                    HSYM = 0;
                }
                if ((TileLoader.ruin34 & seen_fused) != (getRuinHorizontal(34) & seen_fused)) {
                    HSYM = 0;
                }
                seen_fused = TileLoader.seen35 & getSeenHorizontal(35);
                if ((TileLoader.wall35 & seen_fused) != (getWallHorizontal(35) & seen_fused)) {
                    HSYM = 0;
                }
                if ((TileLoader.ruin35 & seen_fused) != (getRuinHorizontal(35) & seen_fused)) {
                    HSYM = 0;
                }
                
            }
            case 32 -> {
                seen_fused = TileLoader.seen28 & getSeenHorizontal(28);
                if ((TileLoader.wall28 & seen_fused) != (getWallHorizontal(28) & seen_fused)) {
                    HSYM = 0;
                }
                if ((TileLoader.ruin28 & seen_fused) != (getRuinHorizontal(28) & seen_fused)) {
                    HSYM = 0;
                }
                seen_fused = TileLoader.seen29 & getSeenHorizontal(29);
                if ((TileLoader.wall29 & seen_fused) != (getWallHorizontal(29) & seen_fused)) {
                    HSYM = 0;
                }
                if ((TileLoader.ruin29 & seen_fused) != (getRuinHorizontal(29) & seen_fused)) {
                    HSYM = 0;
                }
                seen_fused = TileLoader.seen30 & getSeenHorizontal(30);
                if ((TileLoader.wall30 & seen_fused) != (getWallHorizontal(30) & seen_fused)) {
                    HSYM = 0;
                }
                if ((TileLoader.ruin30 & seen_fused) != (getRuinHorizontal(30) & seen_fused)) {
                    HSYM = 0;
                }
                seen_fused = TileLoader.seen31 & getSeenHorizontal(31);
                if ((TileLoader.wall31 & seen_fused) != (getWallHorizontal(31) & seen_fused)) {
                    HSYM = 0;
                }
                if ((TileLoader.ruin31 & seen_fused) != (getRuinHorizontal(31) & seen_fused)) {
                    HSYM = 0;
                }
                seen_fused = TileLoader.seen32 & getSeenHorizontal(32);
                if ((TileLoader.wall32 & seen_fused) != (getWallHorizontal(32) & seen_fused)) {
                    HSYM = 0;
                }
                if ((TileLoader.ruin32 & seen_fused) != (getRuinHorizontal(32) & seen_fused)) {
                    HSYM = 0;
                }
                seen_fused = TileLoader.seen33 & getSeenHorizontal(33);
                if ((TileLoader.wall33 & seen_fused) != (getWallHorizontal(33) & seen_fused)) {
                    HSYM = 0;
                }
                if ((TileLoader.ruin33 & seen_fused) != (getRuinHorizontal(33) & seen_fused)) {
                    HSYM = 0;
                }
                seen_fused = TileLoader.seen34 & getSeenHorizontal(34);
                if ((TileLoader.wall34 & seen_fused) != (getWallHorizontal(34) & seen_fused)) {
                    HSYM = 0;
                }
                if ((TileLoader.ruin34 & seen_fused) != (getRuinHorizontal(34) & seen_fused)) {
                    HSYM = 0;
                }
                seen_fused = TileLoader.seen35 & getSeenHorizontal(35);
                if ((TileLoader.wall35 & seen_fused) != (getWallHorizontal(35) & seen_fused)) {
                    HSYM = 0;
                }
                if ((TileLoader.ruin35 & seen_fused) != (getRuinHorizontal(35) & seen_fused)) {
                    HSYM = 0;
                }
                seen_fused = TileLoader.seen36 & getSeenHorizontal(36);
                if ((TileLoader.wall36 & seen_fused) != (getWallHorizontal(36) & seen_fused)) {
                    HSYM = 0;
                }
                if ((TileLoader.ruin36 & seen_fused) != (getRuinHorizontal(36) & seen_fused)) {
                    HSYM = 0;
                }
                
            }
            case 33 -> {
                seen_fused = TileLoader.seen29 & getSeenHorizontal(29);
                if ((TileLoader.wall29 & seen_fused) != (getWallHorizontal(29) & seen_fused)) {
                    HSYM = 0;
                }
                if ((TileLoader.ruin29 & seen_fused) != (getRuinHorizontal(29) & seen_fused)) {
                    HSYM = 0;
                }
                seen_fused = TileLoader.seen30 & getSeenHorizontal(30);
                if ((TileLoader.wall30 & seen_fused) != (getWallHorizontal(30) & seen_fused)) {
                    HSYM = 0;
                }
                if ((TileLoader.ruin30 & seen_fused) != (getRuinHorizontal(30) & seen_fused)) {
                    HSYM = 0;
                }
                seen_fused = TileLoader.seen31 & getSeenHorizontal(31);
                if ((TileLoader.wall31 & seen_fused) != (getWallHorizontal(31) & seen_fused)) {
                    HSYM = 0;
                }
                if ((TileLoader.ruin31 & seen_fused) != (getRuinHorizontal(31) & seen_fused)) {
                    HSYM = 0;
                }
                seen_fused = TileLoader.seen32 & getSeenHorizontal(32);
                if ((TileLoader.wall32 & seen_fused) != (getWallHorizontal(32) & seen_fused)) {
                    HSYM = 0;
                }
                if ((TileLoader.ruin32 & seen_fused) != (getRuinHorizontal(32) & seen_fused)) {
                    HSYM = 0;
                }
                seen_fused = TileLoader.seen33 & getSeenHorizontal(33);
                if ((TileLoader.wall33 & seen_fused) != (getWallHorizontal(33) & seen_fused)) {
                    HSYM = 0;
                }
                if ((TileLoader.ruin33 & seen_fused) != (getRuinHorizontal(33) & seen_fused)) {
                    HSYM = 0;
                }
                seen_fused = TileLoader.seen34 & getSeenHorizontal(34);
                if ((TileLoader.wall34 & seen_fused) != (getWallHorizontal(34) & seen_fused)) {
                    HSYM = 0;
                }
                if ((TileLoader.ruin34 & seen_fused) != (getRuinHorizontal(34) & seen_fused)) {
                    HSYM = 0;
                }
                seen_fused = TileLoader.seen35 & getSeenHorizontal(35);
                if ((TileLoader.wall35 & seen_fused) != (getWallHorizontal(35) & seen_fused)) {
                    HSYM = 0;
                }
                if ((TileLoader.ruin35 & seen_fused) != (getRuinHorizontal(35) & seen_fused)) {
                    HSYM = 0;
                }
                seen_fused = TileLoader.seen36 & getSeenHorizontal(36);
                if ((TileLoader.wall36 & seen_fused) != (getWallHorizontal(36) & seen_fused)) {
                    HSYM = 0;
                }
                if ((TileLoader.ruin36 & seen_fused) != (getRuinHorizontal(36) & seen_fused)) {
                    HSYM = 0;
                }
                seen_fused = TileLoader.seen37 & getSeenHorizontal(37);
                if ((TileLoader.wall37 & seen_fused) != (getWallHorizontal(37) & seen_fused)) {
                    HSYM = 0;
                }
                if ((TileLoader.ruin37 & seen_fused) != (getRuinHorizontal(37) & seen_fused)) {
                    HSYM = 0;
                }
                
            }
            case 34 -> {
                seen_fused = TileLoader.seen30 & getSeenHorizontal(30);
                if ((TileLoader.wall30 & seen_fused) != (getWallHorizontal(30) & seen_fused)) {
                    HSYM = 0;
                }
                if ((TileLoader.ruin30 & seen_fused) != (getRuinHorizontal(30) & seen_fused)) {
                    HSYM = 0;
                }
                seen_fused = TileLoader.seen31 & getSeenHorizontal(31);
                if ((TileLoader.wall31 & seen_fused) != (getWallHorizontal(31) & seen_fused)) {
                    HSYM = 0;
                }
                if ((TileLoader.ruin31 & seen_fused) != (getRuinHorizontal(31) & seen_fused)) {
                    HSYM = 0;
                }
                seen_fused = TileLoader.seen32 & getSeenHorizontal(32);
                if ((TileLoader.wall32 & seen_fused) != (getWallHorizontal(32) & seen_fused)) {
                    HSYM = 0;
                }
                if ((TileLoader.ruin32 & seen_fused) != (getRuinHorizontal(32) & seen_fused)) {
                    HSYM = 0;
                }
                seen_fused = TileLoader.seen33 & getSeenHorizontal(33);
                if ((TileLoader.wall33 & seen_fused) != (getWallHorizontal(33) & seen_fused)) {
                    HSYM = 0;
                }
                if ((TileLoader.ruin33 & seen_fused) != (getRuinHorizontal(33) & seen_fused)) {
                    HSYM = 0;
                }
                seen_fused = TileLoader.seen34 & getSeenHorizontal(34);
                if ((TileLoader.wall34 & seen_fused) != (getWallHorizontal(34) & seen_fused)) {
                    HSYM = 0;
                }
                if ((TileLoader.ruin34 & seen_fused) != (getRuinHorizontal(34) & seen_fused)) {
                    HSYM = 0;
                }
                seen_fused = TileLoader.seen35 & getSeenHorizontal(35);
                if ((TileLoader.wall35 & seen_fused) != (getWallHorizontal(35) & seen_fused)) {
                    HSYM = 0;
                }
                if ((TileLoader.ruin35 & seen_fused) != (getRuinHorizontal(35) & seen_fused)) {
                    HSYM = 0;
                }
                seen_fused = TileLoader.seen36 & getSeenHorizontal(36);
                if ((TileLoader.wall36 & seen_fused) != (getWallHorizontal(36) & seen_fused)) {
                    HSYM = 0;
                }
                if ((TileLoader.ruin36 & seen_fused) != (getRuinHorizontal(36) & seen_fused)) {
                    HSYM = 0;
                }
                seen_fused = TileLoader.seen37 & getSeenHorizontal(37);
                if ((TileLoader.wall37 & seen_fused) != (getWallHorizontal(37) & seen_fused)) {
                    HSYM = 0;
                }
                if ((TileLoader.ruin37 & seen_fused) != (getRuinHorizontal(37) & seen_fused)) {
                    HSYM = 0;
                }
                seen_fused = TileLoader.seen38 & getSeenHorizontal(38);
                if ((TileLoader.wall38 & seen_fused) != (getWallHorizontal(38) & seen_fused)) {
                    HSYM = 0;
                }
                if ((TileLoader.ruin38 & seen_fused) != (getRuinHorizontal(38) & seen_fused)) {
                    HSYM = 0;
                }
                
            }
            case 35 -> {
                seen_fused = TileLoader.seen31 & getSeenHorizontal(31);
                if ((TileLoader.wall31 & seen_fused) != (getWallHorizontal(31) & seen_fused)) {
                    HSYM = 0;
                }
                if ((TileLoader.ruin31 & seen_fused) != (getRuinHorizontal(31) & seen_fused)) {
                    HSYM = 0;
                }
                seen_fused = TileLoader.seen32 & getSeenHorizontal(32);
                if ((TileLoader.wall32 & seen_fused) != (getWallHorizontal(32) & seen_fused)) {
                    HSYM = 0;
                }
                if ((TileLoader.ruin32 & seen_fused) != (getRuinHorizontal(32) & seen_fused)) {
                    HSYM = 0;
                }
                seen_fused = TileLoader.seen33 & getSeenHorizontal(33);
                if ((TileLoader.wall33 & seen_fused) != (getWallHorizontal(33) & seen_fused)) {
                    HSYM = 0;
                }
                if ((TileLoader.ruin33 & seen_fused) != (getRuinHorizontal(33) & seen_fused)) {
                    HSYM = 0;
                }
                seen_fused = TileLoader.seen34 & getSeenHorizontal(34);
                if ((TileLoader.wall34 & seen_fused) != (getWallHorizontal(34) & seen_fused)) {
                    HSYM = 0;
                }
                if ((TileLoader.ruin34 & seen_fused) != (getRuinHorizontal(34) & seen_fused)) {
                    HSYM = 0;
                }
                seen_fused = TileLoader.seen35 & getSeenHorizontal(35);
                if ((TileLoader.wall35 & seen_fused) != (getWallHorizontal(35) & seen_fused)) {
                    HSYM = 0;
                }
                if ((TileLoader.ruin35 & seen_fused) != (getRuinHorizontal(35) & seen_fused)) {
                    HSYM = 0;
                }
                seen_fused = TileLoader.seen36 & getSeenHorizontal(36);
                if ((TileLoader.wall36 & seen_fused) != (getWallHorizontal(36) & seen_fused)) {
                    HSYM = 0;
                }
                if ((TileLoader.ruin36 & seen_fused) != (getRuinHorizontal(36) & seen_fused)) {
                    HSYM = 0;
                }
                seen_fused = TileLoader.seen37 & getSeenHorizontal(37);
                if ((TileLoader.wall37 & seen_fused) != (getWallHorizontal(37) & seen_fused)) {
                    HSYM = 0;
                }
                if ((TileLoader.ruin37 & seen_fused) != (getRuinHorizontal(37) & seen_fused)) {
                    HSYM = 0;
                }
                seen_fused = TileLoader.seen38 & getSeenHorizontal(38);
                if ((TileLoader.wall38 & seen_fused) != (getWallHorizontal(38) & seen_fused)) {
                    HSYM = 0;
                }
                if ((TileLoader.ruin38 & seen_fused) != (getRuinHorizontal(38) & seen_fused)) {
                    HSYM = 0;
                }
                seen_fused = TileLoader.seen39 & getSeenHorizontal(39);
                if ((TileLoader.wall39 & seen_fused) != (getWallHorizontal(39) & seen_fused)) {
                    HSYM = 0;
                }
                if ((TileLoader.ruin39 & seen_fused) != (getRuinHorizontal(39) & seen_fused)) {
                    HSYM = 0;
                }
                
            }
            case 36 -> {
                seen_fused = TileLoader.seen32 & getSeenHorizontal(32);
                if ((TileLoader.wall32 & seen_fused) != (getWallHorizontal(32) & seen_fused)) {
                    HSYM = 0;
                }
                if ((TileLoader.ruin32 & seen_fused) != (getRuinHorizontal(32) & seen_fused)) {
                    HSYM = 0;
                }
                seen_fused = TileLoader.seen33 & getSeenHorizontal(33);
                if ((TileLoader.wall33 & seen_fused) != (getWallHorizontal(33) & seen_fused)) {
                    HSYM = 0;
                }
                if ((TileLoader.ruin33 & seen_fused) != (getRuinHorizontal(33) & seen_fused)) {
                    HSYM = 0;
                }
                seen_fused = TileLoader.seen34 & getSeenHorizontal(34);
                if ((TileLoader.wall34 & seen_fused) != (getWallHorizontal(34) & seen_fused)) {
                    HSYM = 0;
                }
                if ((TileLoader.ruin34 & seen_fused) != (getRuinHorizontal(34) & seen_fused)) {
                    HSYM = 0;
                }
                seen_fused = TileLoader.seen35 & getSeenHorizontal(35);
                if ((TileLoader.wall35 & seen_fused) != (getWallHorizontal(35) & seen_fused)) {
                    HSYM = 0;
                }
                if ((TileLoader.ruin35 & seen_fused) != (getRuinHorizontal(35) & seen_fused)) {
                    HSYM = 0;
                }
                seen_fused = TileLoader.seen36 & getSeenHorizontal(36);
                if ((TileLoader.wall36 & seen_fused) != (getWallHorizontal(36) & seen_fused)) {
                    HSYM = 0;
                }
                if ((TileLoader.ruin36 & seen_fused) != (getRuinHorizontal(36) & seen_fused)) {
                    HSYM = 0;
                }
                seen_fused = TileLoader.seen37 & getSeenHorizontal(37);
                if ((TileLoader.wall37 & seen_fused) != (getWallHorizontal(37) & seen_fused)) {
                    HSYM = 0;
                }
                if ((TileLoader.ruin37 & seen_fused) != (getRuinHorizontal(37) & seen_fused)) {
                    HSYM = 0;
                }
                seen_fused = TileLoader.seen38 & getSeenHorizontal(38);
                if ((TileLoader.wall38 & seen_fused) != (getWallHorizontal(38) & seen_fused)) {
                    HSYM = 0;
                }
                if ((TileLoader.ruin38 & seen_fused) != (getRuinHorizontal(38) & seen_fused)) {
                    HSYM = 0;
                }
                seen_fused = TileLoader.seen39 & getSeenHorizontal(39);
                if ((TileLoader.wall39 & seen_fused) != (getWallHorizontal(39) & seen_fused)) {
                    HSYM = 0;
                }
                if ((TileLoader.ruin39 & seen_fused) != (getRuinHorizontal(39) & seen_fused)) {
                    HSYM = 0;
                }
                seen_fused = TileLoader.seen40 & getSeenHorizontal(40);
                if ((TileLoader.wall40 & seen_fused) != (getWallHorizontal(40) & seen_fused)) {
                    HSYM = 0;
                }
                if ((TileLoader.ruin40 & seen_fused) != (getRuinHorizontal(40) & seen_fused)) {
                    HSYM = 0;
                }
                
            }
            case 37 -> {
                seen_fused = TileLoader.seen33 & getSeenHorizontal(33);
                if ((TileLoader.wall33 & seen_fused) != (getWallHorizontal(33) & seen_fused)) {
                    HSYM = 0;
                }
                if ((TileLoader.ruin33 & seen_fused) != (getRuinHorizontal(33) & seen_fused)) {
                    HSYM = 0;
                }
                seen_fused = TileLoader.seen34 & getSeenHorizontal(34);
                if ((TileLoader.wall34 & seen_fused) != (getWallHorizontal(34) & seen_fused)) {
                    HSYM = 0;
                }
                if ((TileLoader.ruin34 & seen_fused) != (getRuinHorizontal(34) & seen_fused)) {
                    HSYM = 0;
                }
                seen_fused = TileLoader.seen35 & getSeenHorizontal(35);
                if ((TileLoader.wall35 & seen_fused) != (getWallHorizontal(35) & seen_fused)) {
                    HSYM = 0;
                }
                if ((TileLoader.ruin35 & seen_fused) != (getRuinHorizontal(35) & seen_fused)) {
                    HSYM = 0;
                }
                seen_fused = TileLoader.seen36 & getSeenHorizontal(36);
                if ((TileLoader.wall36 & seen_fused) != (getWallHorizontal(36) & seen_fused)) {
                    HSYM = 0;
                }
                if ((TileLoader.ruin36 & seen_fused) != (getRuinHorizontal(36) & seen_fused)) {
                    HSYM = 0;
                }
                seen_fused = TileLoader.seen37 & getSeenHorizontal(37);
                if ((TileLoader.wall37 & seen_fused) != (getWallHorizontal(37) & seen_fused)) {
                    HSYM = 0;
                }
                if ((TileLoader.ruin37 & seen_fused) != (getRuinHorizontal(37) & seen_fused)) {
                    HSYM = 0;
                }
                seen_fused = TileLoader.seen38 & getSeenHorizontal(38);
                if ((TileLoader.wall38 & seen_fused) != (getWallHorizontal(38) & seen_fused)) {
                    HSYM = 0;
                }
                if ((TileLoader.ruin38 & seen_fused) != (getRuinHorizontal(38) & seen_fused)) {
                    HSYM = 0;
                }
                seen_fused = TileLoader.seen39 & getSeenHorizontal(39);
                if ((TileLoader.wall39 & seen_fused) != (getWallHorizontal(39) & seen_fused)) {
                    HSYM = 0;
                }
                if ((TileLoader.ruin39 & seen_fused) != (getRuinHorizontal(39) & seen_fused)) {
                    HSYM = 0;
                }
                seen_fused = TileLoader.seen40 & getSeenHorizontal(40);
                if ((TileLoader.wall40 & seen_fused) != (getWallHorizontal(40) & seen_fused)) {
                    HSYM = 0;
                }
                if ((TileLoader.ruin40 & seen_fused) != (getRuinHorizontal(40) & seen_fused)) {
                    HSYM = 0;
                }
                seen_fused = TileLoader.seen41 & getSeenHorizontal(41);
                if ((TileLoader.wall41 & seen_fused) != (getWallHorizontal(41) & seen_fused)) {
                    HSYM = 0;
                }
                if ((TileLoader.ruin41 & seen_fused) != (getRuinHorizontal(41) & seen_fused)) {
                    HSYM = 0;
                }
                
            }
            case 38 -> {
                seen_fused = TileLoader.seen34 & getSeenHorizontal(34);
                if ((TileLoader.wall34 & seen_fused) != (getWallHorizontal(34) & seen_fused)) {
                    HSYM = 0;
                }
                if ((TileLoader.ruin34 & seen_fused) != (getRuinHorizontal(34) & seen_fused)) {
                    HSYM = 0;
                }
                seen_fused = TileLoader.seen35 & getSeenHorizontal(35);
                if ((TileLoader.wall35 & seen_fused) != (getWallHorizontal(35) & seen_fused)) {
                    HSYM = 0;
                }
                if ((TileLoader.ruin35 & seen_fused) != (getRuinHorizontal(35) & seen_fused)) {
                    HSYM = 0;
                }
                seen_fused = TileLoader.seen36 & getSeenHorizontal(36);
                if ((TileLoader.wall36 & seen_fused) != (getWallHorizontal(36) & seen_fused)) {
                    HSYM = 0;
                }
                if ((TileLoader.ruin36 & seen_fused) != (getRuinHorizontal(36) & seen_fused)) {
                    HSYM = 0;
                }
                seen_fused = TileLoader.seen37 & getSeenHorizontal(37);
                if ((TileLoader.wall37 & seen_fused) != (getWallHorizontal(37) & seen_fused)) {
                    HSYM = 0;
                }
                if ((TileLoader.ruin37 & seen_fused) != (getRuinHorizontal(37) & seen_fused)) {
                    HSYM = 0;
                }
                seen_fused = TileLoader.seen38 & getSeenHorizontal(38);
                if ((TileLoader.wall38 & seen_fused) != (getWallHorizontal(38) & seen_fused)) {
                    HSYM = 0;
                }
                if ((TileLoader.ruin38 & seen_fused) != (getRuinHorizontal(38) & seen_fused)) {
                    HSYM = 0;
                }
                seen_fused = TileLoader.seen39 & getSeenHorizontal(39);
                if ((TileLoader.wall39 & seen_fused) != (getWallHorizontal(39) & seen_fused)) {
                    HSYM = 0;
                }
                if ((TileLoader.ruin39 & seen_fused) != (getRuinHorizontal(39) & seen_fused)) {
                    HSYM = 0;
                }
                seen_fused = TileLoader.seen40 & getSeenHorizontal(40);
                if ((TileLoader.wall40 & seen_fused) != (getWallHorizontal(40) & seen_fused)) {
                    HSYM = 0;
                }
                if ((TileLoader.ruin40 & seen_fused) != (getRuinHorizontal(40) & seen_fused)) {
                    HSYM = 0;
                }
                seen_fused = TileLoader.seen41 & getSeenHorizontal(41);
                if ((TileLoader.wall41 & seen_fused) != (getWallHorizontal(41) & seen_fused)) {
                    HSYM = 0;
                }
                if ((TileLoader.ruin41 & seen_fused) != (getRuinHorizontal(41) & seen_fused)) {
                    HSYM = 0;
                }
                seen_fused = TileLoader.seen42 & getSeenHorizontal(42);
                if ((TileLoader.wall42 & seen_fused) != (getWallHorizontal(42) & seen_fused)) {
                    HSYM = 0;
                }
                if ((TileLoader.ruin42 & seen_fused) != (getRuinHorizontal(42) & seen_fused)) {
                    HSYM = 0;
                }
                
            }
            case 39 -> {
                seen_fused = TileLoader.seen35 & getSeenHorizontal(35);
                if ((TileLoader.wall35 & seen_fused) != (getWallHorizontal(35) & seen_fused)) {
                    HSYM = 0;
                }
                if ((TileLoader.ruin35 & seen_fused) != (getRuinHorizontal(35) & seen_fused)) {
                    HSYM = 0;
                }
                seen_fused = TileLoader.seen36 & getSeenHorizontal(36);
                if ((TileLoader.wall36 & seen_fused) != (getWallHorizontal(36) & seen_fused)) {
                    HSYM = 0;
                }
                if ((TileLoader.ruin36 & seen_fused) != (getRuinHorizontal(36) & seen_fused)) {
                    HSYM = 0;
                }
                seen_fused = TileLoader.seen37 & getSeenHorizontal(37);
                if ((TileLoader.wall37 & seen_fused) != (getWallHorizontal(37) & seen_fused)) {
                    HSYM = 0;
                }
                if ((TileLoader.ruin37 & seen_fused) != (getRuinHorizontal(37) & seen_fused)) {
                    HSYM = 0;
                }
                seen_fused = TileLoader.seen38 & getSeenHorizontal(38);
                if ((TileLoader.wall38 & seen_fused) != (getWallHorizontal(38) & seen_fused)) {
                    HSYM = 0;
                }
                if ((TileLoader.ruin38 & seen_fused) != (getRuinHorizontal(38) & seen_fused)) {
                    HSYM = 0;
                }
                seen_fused = TileLoader.seen39 & getSeenHorizontal(39);
                if ((TileLoader.wall39 & seen_fused) != (getWallHorizontal(39) & seen_fused)) {
                    HSYM = 0;
                }
                if ((TileLoader.ruin39 & seen_fused) != (getRuinHorizontal(39) & seen_fused)) {
                    HSYM = 0;
                }
                seen_fused = TileLoader.seen40 & getSeenHorizontal(40);
                if ((TileLoader.wall40 & seen_fused) != (getWallHorizontal(40) & seen_fused)) {
                    HSYM = 0;
                }
                if ((TileLoader.ruin40 & seen_fused) != (getRuinHorizontal(40) & seen_fused)) {
                    HSYM = 0;
                }
                seen_fused = TileLoader.seen41 & getSeenHorizontal(41);
                if ((TileLoader.wall41 & seen_fused) != (getWallHorizontal(41) & seen_fused)) {
                    HSYM = 0;
                }
                if ((TileLoader.ruin41 & seen_fused) != (getRuinHorizontal(41) & seen_fused)) {
                    HSYM = 0;
                }
                seen_fused = TileLoader.seen42 & getSeenHorizontal(42);
                if ((TileLoader.wall42 & seen_fused) != (getWallHorizontal(42) & seen_fused)) {
                    HSYM = 0;
                }
                if ((TileLoader.ruin42 & seen_fused) != (getRuinHorizontal(42) & seen_fused)) {
                    HSYM = 0;
                }
                seen_fused = TileLoader.seen43 & getSeenHorizontal(43);
                if ((TileLoader.wall43 & seen_fused) != (getWallHorizontal(43) & seen_fused)) {
                    HSYM = 0;
                }
                if ((TileLoader.ruin43 & seen_fused) != (getRuinHorizontal(43) & seen_fused)) {
                    HSYM = 0;
                }
                
            }
            case 40 -> {
                seen_fused = TileLoader.seen36 & getSeenHorizontal(36);
                if ((TileLoader.wall36 & seen_fused) != (getWallHorizontal(36) & seen_fused)) {
                    HSYM = 0;
                }
                if ((TileLoader.ruin36 & seen_fused) != (getRuinHorizontal(36) & seen_fused)) {
                    HSYM = 0;
                }
                seen_fused = TileLoader.seen37 & getSeenHorizontal(37);
                if ((TileLoader.wall37 & seen_fused) != (getWallHorizontal(37) & seen_fused)) {
                    HSYM = 0;
                }
                if ((TileLoader.ruin37 & seen_fused) != (getRuinHorizontal(37) & seen_fused)) {
                    HSYM = 0;
                }
                seen_fused = TileLoader.seen38 & getSeenHorizontal(38);
                if ((TileLoader.wall38 & seen_fused) != (getWallHorizontal(38) & seen_fused)) {
                    HSYM = 0;
                }
                if ((TileLoader.ruin38 & seen_fused) != (getRuinHorizontal(38) & seen_fused)) {
                    HSYM = 0;
                }
                seen_fused = TileLoader.seen39 & getSeenHorizontal(39);
                if ((TileLoader.wall39 & seen_fused) != (getWallHorizontal(39) & seen_fused)) {
                    HSYM = 0;
                }
                if ((TileLoader.ruin39 & seen_fused) != (getRuinHorizontal(39) & seen_fused)) {
                    HSYM = 0;
                }
                seen_fused = TileLoader.seen40 & getSeenHorizontal(40);
                if ((TileLoader.wall40 & seen_fused) != (getWallHorizontal(40) & seen_fused)) {
                    HSYM = 0;
                }
                if ((TileLoader.ruin40 & seen_fused) != (getRuinHorizontal(40) & seen_fused)) {
                    HSYM = 0;
                }
                seen_fused = TileLoader.seen41 & getSeenHorizontal(41);
                if ((TileLoader.wall41 & seen_fused) != (getWallHorizontal(41) & seen_fused)) {
                    HSYM = 0;
                }
                if ((TileLoader.ruin41 & seen_fused) != (getRuinHorizontal(41) & seen_fused)) {
                    HSYM = 0;
                }
                seen_fused = TileLoader.seen42 & getSeenHorizontal(42);
                if ((TileLoader.wall42 & seen_fused) != (getWallHorizontal(42) & seen_fused)) {
                    HSYM = 0;
                }
                if ((TileLoader.ruin42 & seen_fused) != (getRuinHorizontal(42) & seen_fused)) {
                    HSYM = 0;
                }
                seen_fused = TileLoader.seen43 & getSeenHorizontal(43);
                if ((TileLoader.wall43 & seen_fused) != (getWallHorizontal(43) & seen_fused)) {
                    HSYM = 0;
                }
                if ((TileLoader.ruin43 & seen_fused) != (getRuinHorizontal(43) & seen_fused)) {
                    HSYM = 0;
                }
                seen_fused = TileLoader.seen44 & getSeenHorizontal(44);
                if ((TileLoader.wall44 & seen_fused) != (getWallHorizontal(44) & seen_fused)) {
                    HSYM = 0;
                }
                if ((TileLoader.ruin44 & seen_fused) != (getRuinHorizontal(44) & seen_fused)) {
                    HSYM = 0;
                }
                
            }
            case 41 -> {
                seen_fused = TileLoader.seen37 & getSeenHorizontal(37);
                if ((TileLoader.wall37 & seen_fused) != (getWallHorizontal(37) & seen_fused)) {
                    HSYM = 0;
                }
                if ((TileLoader.ruin37 & seen_fused) != (getRuinHorizontal(37) & seen_fused)) {
                    HSYM = 0;
                }
                seen_fused = TileLoader.seen38 & getSeenHorizontal(38);
                if ((TileLoader.wall38 & seen_fused) != (getWallHorizontal(38) & seen_fused)) {
                    HSYM = 0;
                }
                if ((TileLoader.ruin38 & seen_fused) != (getRuinHorizontal(38) & seen_fused)) {
                    HSYM = 0;
                }
                seen_fused = TileLoader.seen39 & getSeenHorizontal(39);
                if ((TileLoader.wall39 & seen_fused) != (getWallHorizontal(39) & seen_fused)) {
                    HSYM = 0;
                }
                if ((TileLoader.ruin39 & seen_fused) != (getRuinHorizontal(39) & seen_fused)) {
                    HSYM = 0;
                }
                seen_fused = TileLoader.seen40 & getSeenHorizontal(40);
                if ((TileLoader.wall40 & seen_fused) != (getWallHorizontal(40) & seen_fused)) {
                    HSYM = 0;
                }
                if ((TileLoader.ruin40 & seen_fused) != (getRuinHorizontal(40) & seen_fused)) {
                    HSYM = 0;
                }
                seen_fused = TileLoader.seen41 & getSeenHorizontal(41);
                if ((TileLoader.wall41 & seen_fused) != (getWallHorizontal(41) & seen_fused)) {
                    HSYM = 0;
                }
                if ((TileLoader.ruin41 & seen_fused) != (getRuinHorizontal(41) & seen_fused)) {
                    HSYM = 0;
                }
                seen_fused = TileLoader.seen42 & getSeenHorizontal(42);
                if ((TileLoader.wall42 & seen_fused) != (getWallHorizontal(42) & seen_fused)) {
                    HSYM = 0;
                }
                if ((TileLoader.ruin42 & seen_fused) != (getRuinHorizontal(42) & seen_fused)) {
                    HSYM = 0;
                }
                seen_fused = TileLoader.seen43 & getSeenHorizontal(43);
                if ((TileLoader.wall43 & seen_fused) != (getWallHorizontal(43) & seen_fused)) {
                    HSYM = 0;
                }
                if ((TileLoader.ruin43 & seen_fused) != (getRuinHorizontal(43) & seen_fused)) {
                    HSYM = 0;
                }
                seen_fused = TileLoader.seen44 & getSeenHorizontal(44);
                if ((TileLoader.wall44 & seen_fused) != (getWallHorizontal(44) & seen_fused)) {
                    HSYM = 0;
                }
                if ((TileLoader.ruin44 & seen_fused) != (getRuinHorizontal(44) & seen_fused)) {
                    HSYM = 0;
                }
                seen_fused = TileLoader.seen45 & getSeenHorizontal(45);
                if ((TileLoader.wall45 & seen_fused) != (getWallHorizontal(45) & seen_fused)) {
                    HSYM = 0;
                }
                if ((TileLoader.ruin45 & seen_fused) != (getRuinHorizontal(45) & seen_fused)) {
                    HSYM = 0;
                }
                
            }
            case 42 -> {
                seen_fused = TileLoader.seen38 & getSeenHorizontal(38);
                if ((TileLoader.wall38 & seen_fused) != (getWallHorizontal(38) & seen_fused)) {
                    HSYM = 0;
                }
                if ((TileLoader.ruin38 & seen_fused) != (getRuinHorizontal(38) & seen_fused)) {
                    HSYM = 0;
                }
                seen_fused = TileLoader.seen39 & getSeenHorizontal(39);
                if ((TileLoader.wall39 & seen_fused) != (getWallHorizontal(39) & seen_fused)) {
                    HSYM = 0;
                }
                if ((TileLoader.ruin39 & seen_fused) != (getRuinHorizontal(39) & seen_fused)) {
                    HSYM = 0;
                }
                seen_fused = TileLoader.seen40 & getSeenHorizontal(40);
                if ((TileLoader.wall40 & seen_fused) != (getWallHorizontal(40) & seen_fused)) {
                    HSYM = 0;
                }
                if ((TileLoader.ruin40 & seen_fused) != (getRuinHorizontal(40) & seen_fused)) {
                    HSYM = 0;
                }
                seen_fused = TileLoader.seen41 & getSeenHorizontal(41);
                if ((TileLoader.wall41 & seen_fused) != (getWallHorizontal(41) & seen_fused)) {
                    HSYM = 0;
                }
                if ((TileLoader.ruin41 & seen_fused) != (getRuinHorizontal(41) & seen_fused)) {
                    HSYM = 0;
                }
                seen_fused = TileLoader.seen42 & getSeenHorizontal(42);
                if ((TileLoader.wall42 & seen_fused) != (getWallHorizontal(42) & seen_fused)) {
                    HSYM = 0;
                }
                if ((TileLoader.ruin42 & seen_fused) != (getRuinHorizontal(42) & seen_fused)) {
                    HSYM = 0;
                }
                seen_fused = TileLoader.seen43 & getSeenHorizontal(43);
                if ((TileLoader.wall43 & seen_fused) != (getWallHorizontal(43) & seen_fused)) {
                    HSYM = 0;
                }
                if ((TileLoader.ruin43 & seen_fused) != (getRuinHorizontal(43) & seen_fused)) {
                    HSYM = 0;
                }
                seen_fused = TileLoader.seen44 & getSeenHorizontal(44);
                if ((TileLoader.wall44 & seen_fused) != (getWallHorizontal(44) & seen_fused)) {
                    HSYM = 0;
                }
                if ((TileLoader.ruin44 & seen_fused) != (getRuinHorizontal(44) & seen_fused)) {
                    HSYM = 0;
                }
                seen_fused = TileLoader.seen45 & getSeenHorizontal(45);
                if ((TileLoader.wall45 & seen_fused) != (getWallHorizontal(45) & seen_fused)) {
                    HSYM = 0;
                }
                if ((TileLoader.ruin45 & seen_fused) != (getRuinHorizontal(45) & seen_fused)) {
                    HSYM = 0;
                }
                seen_fused = TileLoader.seen46 & getSeenHorizontal(46);
                if ((TileLoader.wall46 & seen_fused) != (getWallHorizontal(46) & seen_fused)) {
                    HSYM = 0;
                }
                if ((TileLoader.ruin46 & seen_fused) != (getRuinHorizontal(46) & seen_fused)) {
                    HSYM = 0;
                }
                
            }
            case 43 -> {
                seen_fused = TileLoader.seen39 & getSeenHorizontal(39);
                if ((TileLoader.wall39 & seen_fused) != (getWallHorizontal(39) & seen_fused)) {
                    HSYM = 0;
                }
                if ((TileLoader.ruin39 & seen_fused) != (getRuinHorizontal(39) & seen_fused)) {
                    HSYM = 0;
                }
                seen_fused = TileLoader.seen40 & getSeenHorizontal(40);
                if ((TileLoader.wall40 & seen_fused) != (getWallHorizontal(40) & seen_fused)) {
                    HSYM = 0;
                }
                if ((TileLoader.ruin40 & seen_fused) != (getRuinHorizontal(40) & seen_fused)) {
                    HSYM = 0;
                }
                seen_fused = TileLoader.seen41 & getSeenHorizontal(41);
                if ((TileLoader.wall41 & seen_fused) != (getWallHorizontal(41) & seen_fused)) {
                    HSYM = 0;
                }
                if ((TileLoader.ruin41 & seen_fused) != (getRuinHorizontal(41) & seen_fused)) {
                    HSYM = 0;
                }
                seen_fused = TileLoader.seen42 & getSeenHorizontal(42);
                if ((TileLoader.wall42 & seen_fused) != (getWallHorizontal(42) & seen_fused)) {
                    HSYM = 0;
                }
                if ((TileLoader.ruin42 & seen_fused) != (getRuinHorizontal(42) & seen_fused)) {
                    HSYM = 0;
                }
                seen_fused = TileLoader.seen43 & getSeenHorizontal(43);
                if ((TileLoader.wall43 & seen_fused) != (getWallHorizontal(43) & seen_fused)) {
                    HSYM = 0;
                }
                if ((TileLoader.ruin43 & seen_fused) != (getRuinHorizontal(43) & seen_fused)) {
                    HSYM = 0;
                }
                seen_fused = TileLoader.seen44 & getSeenHorizontal(44);
                if ((TileLoader.wall44 & seen_fused) != (getWallHorizontal(44) & seen_fused)) {
                    HSYM = 0;
                }
                if ((TileLoader.ruin44 & seen_fused) != (getRuinHorizontal(44) & seen_fused)) {
                    HSYM = 0;
                }
                seen_fused = TileLoader.seen45 & getSeenHorizontal(45);
                if ((TileLoader.wall45 & seen_fused) != (getWallHorizontal(45) & seen_fused)) {
                    HSYM = 0;
                }
                if ((TileLoader.ruin45 & seen_fused) != (getRuinHorizontal(45) & seen_fused)) {
                    HSYM = 0;
                }
                seen_fused = TileLoader.seen46 & getSeenHorizontal(46);
                if ((TileLoader.wall46 & seen_fused) != (getWallHorizontal(46) & seen_fused)) {
                    HSYM = 0;
                }
                if ((TileLoader.ruin46 & seen_fused) != (getRuinHorizontal(46) & seen_fused)) {
                    HSYM = 0;
                }
                seen_fused = TileLoader.seen47 & getSeenHorizontal(47);
                if ((TileLoader.wall47 & seen_fused) != (getWallHorizontal(47) & seen_fused)) {
                    HSYM = 0;
                }
                if ((TileLoader.ruin47 & seen_fused) != (getRuinHorizontal(47) & seen_fused)) {
                    HSYM = 0;
                }
                
            }
            case 44 -> {
                seen_fused = TileLoader.seen40 & getSeenHorizontal(40);
                if ((TileLoader.wall40 & seen_fused) != (getWallHorizontal(40) & seen_fused)) {
                    HSYM = 0;
                }
                if ((TileLoader.ruin40 & seen_fused) != (getRuinHorizontal(40) & seen_fused)) {
                    HSYM = 0;
                }
                seen_fused = TileLoader.seen41 & getSeenHorizontal(41);
                if ((TileLoader.wall41 & seen_fused) != (getWallHorizontal(41) & seen_fused)) {
                    HSYM = 0;
                }
                if ((TileLoader.ruin41 & seen_fused) != (getRuinHorizontal(41) & seen_fused)) {
                    HSYM = 0;
                }
                seen_fused = TileLoader.seen42 & getSeenHorizontal(42);
                if ((TileLoader.wall42 & seen_fused) != (getWallHorizontal(42) & seen_fused)) {
                    HSYM = 0;
                }
                if ((TileLoader.ruin42 & seen_fused) != (getRuinHorizontal(42) & seen_fused)) {
                    HSYM = 0;
                }
                seen_fused = TileLoader.seen43 & getSeenHorizontal(43);
                if ((TileLoader.wall43 & seen_fused) != (getWallHorizontal(43) & seen_fused)) {
                    HSYM = 0;
                }
                if ((TileLoader.ruin43 & seen_fused) != (getRuinHorizontal(43) & seen_fused)) {
                    HSYM = 0;
                }
                seen_fused = TileLoader.seen44 & getSeenHorizontal(44);
                if ((TileLoader.wall44 & seen_fused) != (getWallHorizontal(44) & seen_fused)) {
                    HSYM = 0;
                }
                if ((TileLoader.ruin44 & seen_fused) != (getRuinHorizontal(44) & seen_fused)) {
                    HSYM = 0;
                }
                seen_fused = TileLoader.seen45 & getSeenHorizontal(45);
                if ((TileLoader.wall45 & seen_fused) != (getWallHorizontal(45) & seen_fused)) {
                    HSYM = 0;
                }
                if ((TileLoader.ruin45 & seen_fused) != (getRuinHorizontal(45) & seen_fused)) {
                    HSYM = 0;
                }
                seen_fused = TileLoader.seen46 & getSeenHorizontal(46);
                if ((TileLoader.wall46 & seen_fused) != (getWallHorizontal(46) & seen_fused)) {
                    HSYM = 0;
                }
                if ((TileLoader.ruin46 & seen_fused) != (getRuinHorizontal(46) & seen_fused)) {
                    HSYM = 0;
                }
                seen_fused = TileLoader.seen47 & getSeenHorizontal(47);
                if ((TileLoader.wall47 & seen_fused) != (getWallHorizontal(47) & seen_fused)) {
                    HSYM = 0;
                }
                if ((TileLoader.ruin47 & seen_fused) != (getRuinHorizontal(47) & seen_fused)) {
                    HSYM = 0;
                }
                seen_fused = TileLoader.seen48 & getSeenHorizontal(48);
                if ((TileLoader.wall48 & seen_fused) != (getWallHorizontal(48) & seen_fused)) {
                    HSYM = 0;
                }
                if ((TileLoader.ruin48 & seen_fused) != (getRuinHorizontal(48) & seen_fused)) {
                    HSYM = 0;
                }
                
            }
            case 45 -> {
                seen_fused = TileLoader.seen41 & getSeenHorizontal(41);
                if ((TileLoader.wall41 & seen_fused) != (getWallHorizontal(41) & seen_fused)) {
                    HSYM = 0;
                }
                if ((TileLoader.ruin41 & seen_fused) != (getRuinHorizontal(41) & seen_fused)) {
                    HSYM = 0;
                }
                seen_fused = TileLoader.seen42 & getSeenHorizontal(42);
                if ((TileLoader.wall42 & seen_fused) != (getWallHorizontal(42) & seen_fused)) {
                    HSYM = 0;
                }
                if ((TileLoader.ruin42 & seen_fused) != (getRuinHorizontal(42) & seen_fused)) {
                    HSYM = 0;
                }
                seen_fused = TileLoader.seen43 & getSeenHorizontal(43);
                if ((TileLoader.wall43 & seen_fused) != (getWallHorizontal(43) & seen_fused)) {
                    HSYM = 0;
                }
                if ((TileLoader.ruin43 & seen_fused) != (getRuinHorizontal(43) & seen_fused)) {
                    HSYM = 0;
                }
                seen_fused = TileLoader.seen44 & getSeenHorizontal(44);
                if ((TileLoader.wall44 & seen_fused) != (getWallHorizontal(44) & seen_fused)) {
                    HSYM = 0;
                }
                if ((TileLoader.ruin44 & seen_fused) != (getRuinHorizontal(44) & seen_fused)) {
                    HSYM = 0;
                }
                seen_fused = TileLoader.seen45 & getSeenHorizontal(45);
                if ((TileLoader.wall45 & seen_fused) != (getWallHorizontal(45) & seen_fused)) {
                    HSYM = 0;
                }
                if ((TileLoader.ruin45 & seen_fused) != (getRuinHorizontal(45) & seen_fused)) {
                    HSYM = 0;
                }
                seen_fused = TileLoader.seen46 & getSeenHorizontal(46);
                if ((TileLoader.wall46 & seen_fused) != (getWallHorizontal(46) & seen_fused)) {
                    HSYM = 0;
                }
                if ((TileLoader.ruin46 & seen_fused) != (getRuinHorizontal(46) & seen_fused)) {
                    HSYM = 0;
                }
                seen_fused = TileLoader.seen47 & getSeenHorizontal(47);
                if ((TileLoader.wall47 & seen_fused) != (getWallHorizontal(47) & seen_fused)) {
                    HSYM = 0;
                }
                if ((TileLoader.ruin47 & seen_fused) != (getRuinHorizontal(47) & seen_fused)) {
                    HSYM = 0;
                }
                seen_fused = TileLoader.seen48 & getSeenHorizontal(48);
                if ((TileLoader.wall48 & seen_fused) != (getWallHorizontal(48) & seen_fused)) {
                    HSYM = 0;
                }
                if ((TileLoader.ruin48 & seen_fused) != (getRuinHorizontal(48) & seen_fused)) {
                    HSYM = 0;
                }
                seen_fused = TileLoader.seen49 & getSeenHorizontal(49);
                if ((TileLoader.wall49 & seen_fused) != (getWallHorizontal(49) & seen_fused)) {
                    HSYM = 0;
                }
                if ((TileLoader.ruin49 & seen_fused) != (getRuinHorizontal(49) & seen_fused)) {
                    HSYM = 0;
                }
                
            }
            case 46 -> {
                seen_fused = TileLoader.seen42 & getSeenHorizontal(42);
                if ((TileLoader.wall42 & seen_fused) != (getWallHorizontal(42) & seen_fused)) {
                    HSYM = 0;
                }
                if ((TileLoader.ruin42 & seen_fused) != (getRuinHorizontal(42) & seen_fused)) {
                    HSYM = 0;
                }
                seen_fused = TileLoader.seen43 & getSeenHorizontal(43);
                if ((TileLoader.wall43 & seen_fused) != (getWallHorizontal(43) & seen_fused)) {
                    HSYM = 0;
                }
                if ((TileLoader.ruin43 & seen_fused) != (getRuinHorizontal(43) & seen_fused)) {
                    HSYM = 0;
                }
                seen_fused = TileLoader.seen44 & getSeenHorizontal(44);
                if ((TileLoader.wall44 & seen_fused) != (getWallHorizontal(44) & seen_fused)) {
                    HSYM = 0;
                }
                if ((TileLoader.ruin44 & seen_fused) != (getRuinHorizontal(44) & seen_fused)) {
                    HSYM = 0;
                }
                seen_fused = TileLoader.seen45 & getSeenHorizontal(45);
                if ((TileLoader.wall45 & seen_fused) != (getWallHorizontal(45) & seen_fused)) {
                    HSYM = 0;
                }
                if ((TileLoader.ruin45 & seen_fused) != (getRuinHorizontal(45) & seen_fused)) {
                    HSYM = 0;
                }
                seen_fused = TileLoader.seen46 & getSeenHorizontal(46);
                if ((TileLoader.wall46 & seen_fused) != (getWallHorizontal(46) & seen_fused)) {
                    HSYM = 0;
                }
                if ((TileLoader.ruin46 & seen_fused) != (getRuinHorizontal(46) & seen_fused)) {
                    HSYM = 0;
                }
                seen_fused = TileLoader.seen47 & getSeenHorizontal(47);
                if ((TileLoader.wall47 & seen_fused) != (getWallHorizontal(47) & seen_fused)) {
                    HSYM = 0;
                }
                if ((TileLoader.ruin47 & seen_fused) != (getRuinHorizontal(47) & seen_fused)) {
                    HSYM = 0;
                }
                seen_fused = TileLoader.seen48 & getSeenHorizontal(48);
                if ((TileLoader.wall48 & seen_fused) != (getWallHorizontal(48) & seen_fused)) {
                    HSYM = 0;
                }
                if ((TileLoader.ruin48 & seen_fused) != (getRuinHorizontal(48) & seen_fused)) {
                    HSYM = 0;
                }
                seen_fused = TileLoader.seen49 & getSeenHorizontal(49);
                if ((TileLoader.wall49 & seen_fused) != (getWallHorizontal(49) & seen_fused)) {
                    HSYM = 0;
                }
                if ((TileLoader.ruin49 & seen_fused) != (getRuinHorizontal(49) & seen_fused)) {
                    HSYM = 0;
                }
                seen_fused = TileLoader.seen50 & getSeenHorizontal(50);
                if ((TileLoader.wall50 & seen_fused) != (getWallHorizontal(50) & seen_fused)) {
                    HSYM = 0;
                }
                if ((TileLoader.ruin50 & seen_fused) != (getRuinHorizontal(50) & seen_fused)) {
                    HSYM = 0;
                }
                
            }
            case 47 -> {
                seen_fused = TileLoader.seen43 & getSeenHorizontal(43);
                if ((TileLoader.wall43 & seen_fused) != (getWallHorizontal(43) & seen_fused)) {
                    HSYM = 0;
                }
                if ((TileLoader.ruin43 & seen_fused) != (getRuinHorizontal(43) & seen_fused)) {
                    HSYM = 0;
                }
                seen_fused = TileLoader.seen44 & getSeenHorizontal(44);
                if ((TileLoader.wall44 & seen_fused) != (getWallHorizontal(44) & seen_fused)) {
                    HSYM = 0;
                }
                if ((TileLoader.ruin44 & seen_fused) != (getRuinHorizontal(44) & seen_fused)) {
                    HSYM = 0;
                }
                seen_fused = TileLoader.seen45 & getSeenHorizontal(45);
                if ((TileLoader.wall45 & seen_fused) != (getWallHorizontal(45) & seen_fused)) {
                    HSYM = 0;
                }
                if ((TileLoader.ruin45 & seen_fused) != (getRuinHorizontal(45) & seen_fused)) {
                    HSYM = 0;
                }
                seen_fused = TileLoader.seen46 & getSeenHorizontal(46);
                if ((TileLoader.wall46 & seen_fused) != (getWallHorizontal(46) & seen_fused)) {
                    HSYM = 0;
                }
                if ((TileLoader.ruin46 & seen_fused) != (getRuinHorizontal(46) & seen_fused)) {
                    HSYM = 0;
                }
                seen_fused = TileLoader.seen47 & getSeenHorizontal(47);
                if ((TileLoader.wall47 & seen_fused) != (getWallHorizontal(47) & seen_fused)) {
                    HSYM = 0;
                }
                if ((TileLoader.ruin47 & seen_fused) != (getRuinHorizontal(47) & seen_fused)) {
                    HSYM = 0;
                }
                seen_fused = TileLoader.seen48 & getSeenHorizontal(48);
                if ((TileLoader.wall48 & seen_fused) != (getWallHorizontal(48) & seen_fused)) {
                    HSYM = 0;
                }
                if ((TileLoader.ruin48 & seen_fused) != (getRuinHorizontal(48) & seen_fused)) {
                    HSYM = 0;
                }
                seen_fused = TileLoader.seen49 & getSeenHorizontal(49);
                if ((TileLoader.wall49 & seen_fused) != (getWallHorizontal(49) & seen_fused)) {
                    HSYM = 0;
                }
                if ((TileLoader.ruin49 & seen_fused) != (getRuinHorizontal(49) & seen_fused)) {
                    HSYM = 0;
                }
                seen_fused = TileLoader.seen50 & getSeenHorizontal(50);
                if ((TileLoader.wall50 & seen_fused) != (getWallHorizontal(50) & seen_fused)) {
                    HSYM = 0;
                }
                if ((TileLoader.ruin50 & seen_fused) != (getRuinHorizontal(50) & seen_fused)) {
                    HSYM = 0;
                }
                seen_fused = TileLoader.seen51 & getSeenHorizontal(51);
                if ((TileLoader.wall51 & seen_fused) != (getWallHorizontal(51) & seen_fused)) {
                    HSYM = 0;
                }
                if ((TileLoader.ruin51 & seen_fused) != (getRuinHorizontal(51) & seen_fused)) {
                    HSYM = 0;
                }
                
            }
            case 48 -> {
                seen_fused = TileLoader.seen44 & getSeenHorizontal(44);
                if ((TileLoader.wall44 & seen_fused) != (getWallHorizontal(44) & seen_fused)) {
                    HSYM = 0;
                }
                if ((TileLoader.ruin44 & seen_fused) != (getRuinHorizontal(44) & seen_fused)) {
                    HSYM = 0;
                }
                seen_fused = TileLoader.seen45 & getSeenHorizontal(45);
                if ((TileLoader.wall45 & seen_fused) != (getWallHorizontal(45) & seen_fused)) {
                    HSYM = 0;
                }
                if ((TileLoader.ruin45 & seen_fused) != (getRuinHorizontal(45) & seen_fused)) {
                    HSYM = 0;
                }
                seen_fused = TileLoader.seen46 & getSeenHorizontal(46);
                if ((TileLoader.wall46 & seen_fused) != (getWallHorizontal(46) & seen_fused)) {
                    HSYM = 0;
                }
                if ((TileLoader.ruin46 & seen_fused) != (getRuinHorizontal(46) & seen_fused)) {
                    HSYM = 0;
                }
                seen_fused = TileLoader.seen47 & getSeenHorizontal(47);
                if ((TileLoader.wall47 & seen_fused) != (getWallHorizontal(47) & seen_fused)) {
                    HSYM = 0;
                }
                if ((TileLoader.ruin47 & seen_fused) != (getRuinHorizontal(47) & seen_fused)) {
                    HSYM = 0;
                }
                seen_fused = TileLoader.seen48 & getSeenHorizontal(48);
                if ((TileLoader.wall48 & seen_fused) != (getWallHorizontal(48) & seen_fused)) {
                    HSYM = 0;
                }
                if ((TileLoader.ruin48 & seen_fused) != (getRuinHorizontal(48) & seen_fused)) {
                    HSYM = 0;
                }
                seen_fused = TileLoader.seen49 & getSeenHorizontal(49);
                if ((TileLoader.wall49 & seen_fused) != (getWallHorizontal(49) & seen_fused)) {
                    HSYM = 0;
                }
                if ((TileLoader.ruin49 & seen_fused) != (getRuinHorizontal(49) & seen_fused)) {
                    HSYM = 0;
                }
                seen_fused = TileLoader.seen50 & getSeenHorizontal(50);
                if ((TileLoader.wall50 & seen_fused) != (getWallHorizontal(50) & seen_fused)) {
                    HSYM = 0;
                }
                if ((TileLoader.ruin50 & seen_fused) != (getRuinHorizontal(50) & seen_fused)) {
                    HSYM = 0;
                }
                seen_fused = TileLoader.seen51 & getSeenHorizontal(51);
                if ((TileLoader.wall51 & seen_fused) != (getWallHorizontal(51) & seen_fused)) {
                    HSYM = 0;
                }
                if ((TileLoader.ruin51 & seen_fused) != (getRuinHorizontal(51) & seen_fused)) {
                    HSYM = 0;
                }
                seen_fused = TileLoader.seen52 & getSeenHorizontal(52);
                if ((TileLoader.wall52 & seen_fused) != (getWallHorizontal(52) & seen_fused)) {
                    HSYM = 0;
                }
                if ((TileLoader.ruin52 & seen_fused) != (getRuinHorizontal(52) & seen_fused)) {
                    HSYM = 0;
                }
                
            }
            case 49 -> {
                seen_fused = TileLoader.seen45 & getSeenHorizontal(45);
                if ((TileLoader.wall45 & seen_fused) != (getWallHorizontal(45) & seen_fused)) {
                    HSYM = 0;
                }
                if ((TileLoader.ruin45 & seen_fused) != (getRuinHorizontal(45) & seen_fused)) {
                    HSYM = 0;
                }
                seen_fused = TileLoader.seen46 & getSeenHorizontal(46);
                if ((TileLoader.wall46 & seen_fused) != (getWallHorizontal(46) & seen_fused)) {
                    HSYM = 0;
                }
                if ((TileLoader.ruin46 & seen_fused) != (getRuinHorizontal(46) & seen_fused)) {
                    HSYM = 0;
                }
                seen_fused = TileLoader.seen47 & getSeenHorizontal(47);
                if ((TileLoader.wall47 & seen_fused) != (getWallHorizontal(47) & seen_fused)) {
                    HSYM = 0;
                }
                if ((TileLoader.ruin47 & seen_fused) != (getRuinHorizontal(47) & seen_fused)) {
                    HSYM = 0;
                }
                seen_fused = TileLoader.seen48 & getSeenHorizontal(48);
                if ((TileLoader.wall48 & seen_fused) != (getWallHorizontal(48) & seen_fused)) {
                    HSYM = 0;
                }
                if ((TileLoader.ruin48 & seen_fused) != (getRuinHorizontal(48) & seen_fused)) {
                    HSYM = 0;
                }
                seen_fused = TileLoader.seen49 & getSeenHorizontal(49);
                if ((TileLoader.wall49 & seen_fused) != (getWallHorizontal(49) & seen_fused)) {
                    HSYM = 0;
                }
                if ((TileLoader.ruin49 & seen_fused) != (getRuinHorizontal(49) & seen_fused)) {
                    HSYM = 0;
                }
                seen_fused = TileLoader.seen50 & getSeenHorizontal(50);
                if ((TileLoader.wall50 & seen_fused) != (getWallHorizontal(50) & seen_fused)) {
                    HSYM = 0;
                }
                if ((TileLoader.ruin50 & seen_fused) != (getRuinHorizontal(50) & seen_fused)) {
                    HSYM = 0;
                }
                seen_fused = TileLoader.seen51 & getSeenHorizontal(51);
                if ((TileLoader.wall51 & seen_fused) != (getWallHorizontal(51) & seen_fused)) {
                    HSYM = 0;
                }
                if ((TileLoader.ruin51 & seen_fused) != (getRuinHorizontal(51) & seen_fused)) {
                    HSYM = 0;
                }
                seen_fused = TileLoader.seen52 & getSeenHorizontal(52);
                if ((TileLoader.wall52 & seen_fused) != (getWallHorizontal(52) & seen_fused)) {
                    HSYM = 0;
                }
                if ((TileLoader.ruin52 & seen_fused) != (getRuinHorizontal(52) & seen_fused)) {
                    HSYM = 0;
                }
                seen_fused = TileLoader.seen53 & getSeenHorizontal(53);
                if ((TileLoader.wall53 & seen_fused) != (getWallHorizontal(53) & seen_fused)) {
                    HSYM = 0;
                }
                if ((TileLoader.ruin53 & seen_fused) != (getRuinHorizontal(53) & seen_fused)) {
                    HSYM = 0;
                }
                
            }
            case 50 -> {
                seen_fused = TileLoader.seen46 & getSeenHorizontal(46);
                if ((TileLoader.wall46 & seen_fused) != (getWallHorizontal(46) & seen_fused)) {
                    HSYM = 0;
                }
                if ((TileLoader.ruin46 & seen_fused) != (getRuinHorizontal(46) & seen_fused)) {
                    HSYM = 0;
                }
                seen_fused = TileLoader.seen47 & getSeenHorizontal(47);
                if ((TileLoader.wall47 & seen_fused) != (getWallHorizontal(47) & seen_fused)) {
                    HSYM = 0;
                }
                if ((TileLoader.ruin47 & seen_fused) != (getRuinHorizontal(47) & seen_fused)) {
                    HSYM = 0;
                }
                seen_fused = TileLoader.seen48 & getSeenHorizontal(48);
                if ((TileLoader.wall48 & seen_fused) != (getWallHorizontal(48) & seen_fused)) {
                    HSYM = 0;
                }
                if ((TileLoader.ruin48 & seen_fused) != (getRuinHorizontal(48) & seen_fused)) {
                    HSYM = 0;
                }
                seen_fused = TileLoader.seen49 & getSeenHorizontal(49);
                if ((TileLoader.wall49 & seen_fused) != (getWallHorizontal(49) & seen_fused)) {
                    HSYM = 0;
                }
                if ((TileLoader.ruin49 & seen_fused) != (getRuinHorizontal(49) & seen_fused)) {
                    HSYM = 0;
                }
                seen_fused = TileLoader.seen50 & getSeenHorizontal(50);
                if ((TileLoader.wall50 & seen_fused) != (getWallHorizontal(50) & seen_fused)) {
                    HSYM = 0;
                }
                if ((TileLoader.ruin50 & seen_fused) != (getRuinHorizontal(50) & seen_fused)) {
                    HSYM = 0;
                }
                seen_fused = TileLoader.seen51 & getSeenHorizontal(51);
                if ((TileLoader.wall51 & seen_fused) != (getWallHorizontal(51) & seen_fused)) {
                    HSYM = 0;
                }
                if ((TileLoader.ruin51 & seen_fused) != (getRuinHorizontal(51) & seen_fused)) {
                    HSYM = 0;
                }
                seen_fused = TileLoader.seen52 & getSeenHorizontal(52);
                if ((TileLoader.wall52 & seen_fused) != (getWallHorizontal(52) & seen_fused)) {
                    HSYM = 0;
                }
                if ((TileLoader.ruin52 & seen_fused) != (getRuinHorizontal(52) & seen_fused)) {
                    HSYM = 0;
                }
                seen_fused = TileLoader.seen53 & getSeenHorizontal(53);
                if ((TileLoader.wall53 & seen_fused) != (getWallHorizontal(53) & seen_fused)) {
                    HSYM = 0;
                }
                if ((TileLoader.ruin53 & seen_fused) != (getRuinHorizontal(53) & seen_fused)) {
                    HSYM = 0;
                }
                seen_fused = TileLoader.seen54 & getSeenHorizontal(54);
                if ((TileLoader.wall54 & seen_fused) != (getWallHorizontal(54) & seen_fused)) {
                    HSYM = 0;
                }
                if ((TileLoader.ruin54 & seen_fused) != (getRuinHorizontal(54) & seen_fused)) {
                    HSYM = 0;
                }
                
            }
            case 51 -> {
                seen_fused = TileLoader.seen47 & getSeenHorizontal(47);
                if ((TileLoader.wall47 & seen_fused) != (getWallHorizontal(47) & seen_fused)) {
                    HSYM = 0;
                }
                if ((TileLoader.ruin47 & seen_fused) != (getRuinHorizontal(47) & seen_fused)) {
                    HSYM = 0;
                }
                seen_fused = TileLoader.seen48 & getSeenHorizontal(48);
                if ((TileLoader.wall48 & seen_fused) != (getWallHorizontal(48) & seen_fused)) {
                    HSYM = 0;
                }
                if ((TileLoader.ruin48 & seen_fused) != (getRuinHorizontal(48) & seen_fused)) {
                    HSYM = 0;
                }
                seen_fused = TileLoader.seen49 & getSeenHorizontal(49);
                if ((TileLoader.wall49 & seen_fused) != (getWallHorizontal(49) & seen_fused)) {
                    HSYM = 0;
                }
                if ((TileLoader.ruin49 & seen_fused) != (getRuinHorizontal(49) & seen_fused)) {
                    HSYM = 0;
                }
                seen_fused = TileLoader.seen50 & getSeenHorizontal(50);
                if ((TileLoader.wall50 & seen_fused) != (getWallHorizontal(50) & seen_fused)) {
                    HSYM = 0;
                }
                if ((TileLoader.ruin50 & seen_fused) != (getRuinHorizontal(50) & seen_fused)) {
                    HSYM = 0;
                }
                seen_fused = TileLoader.seen51 & getSeenHorizontal(51);
                if ((TileLoader.wall51 & seen_fused) != (getWallHorizontal(51) & seen_fused)) {
                    HSYM = 0;
                }
                if ((TileLoader.ruin51 & seen_fused) != (getRuinHorizontal(51) & seen_fused)) {
                    HSYM = 0;
                }
                seen_fused = TileLoader.seen52 & getSeenHorizontal(52);
                if ((TileLoader.wall52 & seen_fused) != (getWallHorizontal(52) & seen_fused)) {
                    HSYM = 0;
                }
                if ((TileLoader.ruin52 & seen_fused) != (getRuinHorizontal(52) & seen_fused)) {
                    HSYM = 0;
                }
                seen_fused = TileLoader.seen53 & getSeenHorizontal(53);
                if ((TileLoader.wall53 & seen_fused) != (getWallHorizontal(53) & seen_fused)) {
                    HSYM = 0;
                }
                if ((TileLoader.ruin53 & seen_fused) != (getRuinHorizontal(53) & seen_fused)) {
                    HSYM = 0;
                }
                seen_fused = TileLoader.seen54 & getSeenHorizontal(54);
                if ((TileLoader.wall54 & seen_fused) != (getWallHorizontal(54) & seen_fused)) {
                    HSYM = 0;
                }
                if ((TileLoader.ruin54 & seen_fused) != (getRuinHorizontal(54) & seen_fused)) {
                    HSYM = 0;
                }
                seen_fused = TileLoader.seen55 & getSeenHorizontal(55);
                if ((TileLoader.wall55 & seen_fused) != (getWallHorizontal(55) & seen_fused)) {
                    HSYM = 0;
                }
                if ((TileLoader.ruin55 & seen_fused) != (getRuinHorizontal(55) & seen_fused)) {
                    HSYM = 0;
                }
                
            }
            case 52 -> {
                seen_fused = TileLoader.seen48 & getSeenHorizontal(48);
                if ((TileLoader.wall48 & seen_fused) != (getWallHorizontal(48) & seen_fused)) {
                    HSYM = 0;
                }
                if ((TileLoader.ruin48 & seen_fused) != (getRuinHorizontal(48) & seen_fused)) {
                    HSYM = 0;
                }
                seen_fused = TileLoader.seen49 & getSeenHorizontal(49);
                if ((TileLoader.wall49 & seen_fused) != (getWallHorizontal(49) & seen_fused)) {
                    HSYM = 0;
                }
                if ((TileLoader.ruin49 & seen_fused) != (getRuinHorizontal(49) & seen_fused)) {
                    HSYM = 0;
                }
                seen_fused = TileLoader.seen50 & getSeenHorizontal(50);
                if ((TileLoader.wall50 & seen_fused) != (getWallHorizontal(50) & seen_fused)) {
                    HSYM = 0;
                }
                if ((TileLoader.ruin50 & seen_fused) != (getRuinHorizontal(50) & seen_fused)) {
                    HSYM = 0;
                }
                seen_fused = TileLoader.seen51 & getSeenHorizontal(51);
                if ((TileLoader.wall51 & seen_fused) != (getWallHorizontal(51) & seen_fused)) {
                    HSYM = 0;
                }
                if ((TileLoader.ruin51 & seen_fused) != (getRuinHorizontal(51) & seen_fused)) {
                    HSYM = 0;
                }
                seen_fused = TileLoader.seen52 & getSeenHorizontal(52);
                if ((TileLoader.wall52 & seen_fused) != (getWallHorizontal(52) & seen_fused)) {
                    HSYM = 0;
                }
                if ((TileLoader.ruin52 & seen_fused) != (getRuinHorizontal(52) & seen_fused)) {
                    HSYM = 0;
                }
                seen_fused = TileLoader.seen53 & getSeenHorizontal(53);
                if ((TileLoader.wall53 & seen_fused) != (getWallHorizontal(53) & seen_fused)) {
                    HSYM = 0;
                }
                if ((TileLoader.ruin53 & seen_fused) != (getRuinHorizontal(53) & seen_fused)) {
                    HSYM = 0;
                }
                seen_fused = TileLoader.seen54 & getSeenHorizontal(54);
                if ((TileLoader.wall54 & seen_fused) != (getWallHorizontal(54) & seen_fused)) {
                    HSYM = 0;
                }
                if ((TileLoader.ruin54 & seen_fused) != (getRuinHorizontal(54) & seen_fused)) {
                    HSYM = 0;
                }
                seen_fused = TileLoader.seen55 & getSeenHorizontal(55);
                if ((TileLoader.wall55 & seen_fused) != (getWallHorizontal(55) & seen_fused)) {
                    HSYM = 0;
                }
                if ((TileLoader.ruin55 & seen_fused) != (getRuinHorizontal(55) & seen_fused)) {
                    HSYM = 0;
                }
                seen_fused = TileLoader.seen56 & getSeenHorizontal(56);
                if ((TileLoader.wall56 & seen_fused) != (getWallHorizontal(56) & seen_fused)) {
                    HSYM = 0;
                }
                if ((TileLoader.ruin56 & seen_fused) != (getRuinHorizontal(56) & seen_fused)) {
                    HSYM = 0;
                }
                
            }
            case 53 -> {
                seen_fused = TileLoader.seen49 & getSeenHorizontal(49);
                if ((TileLoader.wall49 & seen_fused) != (getWallHorizontal(49) & seen_fused)) {
                    HSYM = 0;
                }
                if ((TileLoader.ruin49 & seen_fused) != (getRuinHorizontal(49) & seen_fused)) {
                    HSYM = 0;
                }
                seen_fused = TileLoader.seen50 & getSeenHorizontal(50);
                if ((TileLoader.wall50 & seen_fused) != (getWallHorizontal(50) & seen_fused)) {
                    HSYM = 0;
                }
                if ((TileLoader.ruin50 & seen_fused) != (getRuinHorizontal(50) & seen_fused)) {
                    HSYM = 0;
                }
                seen_fused = TileLoader.seen51 & getSeenHorizontal(51);
                if ((TileLoader.wall51 & seen_fused) != (getWallHorizontal(51) & seen_fused)) {
                    HSYM = 0;
                }
                if ((TileLoader.ruin51 & seen_fused) != (getRuinHorizontal(51) & seen_fused)) {
                    HSYM = 0;
                }
                seen_fused = TileLoader.seen52 & getSeenHorizontal(52);
                if ((TileLoader.wall52 & seen_fused) != (getWallHorizontal(52) & seen_fused)) {
                    HSYM = 0;
                }
                if ((TileLoader.ruin52 & seen_fused) != (getRuinHorizontal(52) & seen_fused)) {
                    HSYM = 0;
                }
                seen_fused = TileLoader.seen53 & getSeenHorizontal(53);
                if ((TileLoader.wall53 & seen_fused) != (getWallHorizontal(53) & seen_fused)) {
                    HSYM = 0;
                }
                if ((TileLoader.ruin53 & seen_fused) != (getRuinHorizontal(53) & seen_fused)) {
                    HSYM = 0;
                }
                seen_fused = TileLoader.seen54 & getSeenHorizontal(54);
                if ((TileLoader.wall54 & seen_fused) != (getWallHorizontal(54) & seen_fused)) {
                    HSYM = 0;
                }
                if ((TileLoader.ruin54 & seen_fused) != (getRuinHorizontal(54) & seen_fused)) {
                    HSYM = 0;
                }
                seen_fused = TileLoader.seen55 & getSeenHorizontal(55);
                if ((TileLoader.wall55 & seen_fused) != (getWallHorizontal(55) & seen_fused)) {
                    HSYM = 0;
                }
                if ((TileLoader.ruin55 & seen_fused) != (getRuinHorizontal(55) & seen_fused)) {
                    HSYM = 0;
                }
                seen_fused = TileLoader.seen56 & getSeenHorizontal(56);
                if ((TileLoader.wall56 & seen_fused) != (getWallHorizontal(56) & seen_fused)) {
                    HSYM = 0;
                }
                if ((TileLoader.ruin56 & seen_fused) != (getRuinHorizontal(56) & seen_fused)) {
                    HSYM = 0;
                }
                seen_fused = TileLoader.seen57 & getSeenHorizontal(57);
                if ((TileLoader.wall57 & seen_fused) != (getWallHorizontal(57) & seen_fused)) {
                    HSYM = 0;
                }
                if ((TileLoader.ruin57 & seen_fused) != (getRuinHorizontal(57) & seen_fused)) {
                    HSYM = 0;
                }
                
            }
            case 54 -> {
                seen_fused = TileLoader.seen50 & getSeenHorizontal(50);
                if ((TileLoader.wall50 & seen_fused) != (getWallHorizontal(50) & seen_fused)) {
                    HSYM = 0;
                }
                if ((TileLoader.ruin50 & seen_fused) != (getRuinHorizontal(50) & seen_fused)) {
                    HSYM = 0;
                }
                seen_fused = TileLoader.seen51 & getSeenHorizontal(51);
                if ((TileLoader.wall51 & seen_fused) != (getWallHorizontal(51) & seen_fused)) {
                    HSYM = 0;
                }
                if ((TileLoader.ruin51 & seen_fused) != (getRuinHorizontal(51) & seen_fused)) {
                    HSYM = 0;
                }
                seen_fused = TileLoader.seen52 & getSeenHorizontal(52);
                if ((TileLoader.wall52 & seen_fused) != (getWallHorizontal(52) & seen_fused)) {
                    HSYM = 0;
                }
                if ((TileLoader.ruin52 & seen_fused) != (getRuinHorizontal(52) & seen_fused)) {
                    HSYM = 0;
                }
                seen_fused = TileLoader.seen53 & getSeenHorizontal(53);
                if ((TileLoader.wall53 & seen_fused) != (getWallHorizontal(53) & seen_fused)) {
                    HSYM = 0;
                }
                if ((TileLoader.ruin53 & seen_fused) != (getRuinHorizontal(53) & seen_fused)) {
                    HSYM = 0;
                }
                seen_fused = TileLoader.seen54 & getSeenHorizontal(54);
                if ((TileLoader.wall54 & seen_fused) != (getWallHorizontal(54) & seen_fused)) {
                    HSYM = 0;
                }
                if ((TileLoader.ruin54 & seen_fused) != (getRuinHorizontal(54) & seen_fused)) {
                    HSYM = 0;
                }
                seen_fused = TileLoader.seen55 & getSeenHorizontal(55);
                if ((TileLoader.wall55 & seen_fused) != (getWallHorizontal(55) & seen_fused)) {
                    HSYM = 0;
                }
                if ((TileLoader.ruin55 & seen_fused) != (getRuinHorizontal(55) & seen_fused)) {
                    HSYM = 0;
                }
                seen_fused = TileLoader.seen56 & getSeenHorizontal(56);
                if ((TileLoader.wall56 & seen_fused) != (getWallHorizontal(56) & seen_fused)) {
                    HSYM = 0;
                }
                if ((TileLoader.ruin56 & seen_fused) != (getRuinHorizontal(56) & seen_fused)) {
                    HSYM = 0;
                }
                seen_fused = TileLoader.seen57 & getSeenHorizontal(57);
                if ((TileLoader.wall57 & seen_fused) != (getWallHorizontal(57) & seen_fused)) {
                    HSYM = 0;
                }
                if ((TileLoader.ruin57 & seen_fused) != (getRuinHorizontal(57) & seen_fused)) {
                    HSYM = 0;
                }
                seen_fused = TileLoader.seen58 & getSeenHorizontal(58);
                if ((TileLoader.wall58 & seen_fused) != (getWallHorizontal(58) & seen_fused)) {
                    HSYM = 0;
                }
                if ((TileLoader.ruin58 & seen_fused) != (getRuinHorizontal(58) & seen_fused)) {
                    HSYM = 0;
                }
                
            }
            case 55 -> {
                seen_fused = TileLoader.seen51 & getSeenHorizontal(51);
                if ((TileLoader.wall51 & seen_fused) != (getWallHorizontal(51) & seen_fused)) {
                    HSYM = 0;
                }
                if ((TileLoader.ruin51 & seen_fused) != (getRuinHorizontal(51) & seen_fused)) {
                    HSYM = 0;
                }
                seen_fused = TileLoader.seen52 & getSeenHorizontal(52);
                if ((TileLoader.wall52 & seen_fused) != (getWallHorizontal(52) & seen_fused)) {
                    HSYM = 0;
                }
                if ((TileLoader.ruin52 & seen_fused) != (getRuinHorizontal(52) & seen_fused)) {
                    HSYM = 0;
                }
                seen_fused = TileLoader.seen53 & getSeenHorizontal(53);
                if ((TileLoader.wall53 & seen_fused) != (getWallHorizontal(53) & seen_fused)) {
                    HSYM = 0;
                }
                if ((TileLoader.ruin53 & seen_fused) != (getRuinHorizontal(53) & seen_fused)) {
                    HSYM = 0;
                }
                seen_fused = TileLoader.seen54 & getSeenHorizontal(54);
                if ((TileLoader.wall54 & seen_fused) != (getWallHorizontal(54) & seen_fused)) {
                    HSYM = 0;
                }
                if ((TileLoader.ruin54 & seen_fused) != (getRuinHorizontal(54) & seen_fused)) {
                    HSYM = 0;
                }
                seen_fused = TileLoader.seen55 & getSeenHorizontal(55);
                if ((TileLoader.wall55 & seen_fused) != (getWallHorizontal(55) & seen_fused)) {
                    HSYM = 0;
                }
                if ((TileLoader.ruin55 & seen_fused) != (getRuinHorizontal(55) & seen_fused)) {
                    HSYM = 0;
                }
                seen_fused = TileLoader.seen56 & getSeenHorizontal(56);
                if ((TileLoader.wall56 & seen_fused) != (getWallHorizontal(56) & seen_fused)) {
                    HSYM = 0;
                }
                if ((TileLoader.ruin56 & seen_fused) != (getRuinHorizontal(56) & seen_fused)) {
                    HSYM = 0;
                }
                seen_fused = TileLoader.seen57 & getSeenHorizontal(57);
                if ((TileLoader.wall57 & seen_fused) != (getWallHorizontal(57) & seen_fused)) {
                    HSYM = 0;
                }
                if ((TileLoader.ruin57 & seen_fused) != (getRuinHorizontal(57) & seen_fused)) {
                    HSYM = 0;
                }
                seen_fused = TileLoader.seen58 & getSeenHorizontal(58);
                if ((TileLoader.wall58 & seen_fused) != (getWallHorizontal(58) & seen_fused)) {
                    HSYM = 0;
                }
                if ((TileLoader.ruin58 & seen_fused) != (getRuinHorizontal(58) & seen_fused)) {
                    HSYM = 0;
                }
                seen_fused = TileLoader.seen59 & getSeenHorizontal(59);
                if ((TileLoader.wall59 & seen_fused) != (getWallHorizontal(59) & seen_fused)) {
                    HSYM = 0;
                }
                if ((TileLoader.ruin59 & seen_fused) != (getRuinHorizontal(59) & seen_fused)) {
                    HSYM = 0;
                }
                
            }
            case 56 -> {
                seen_fused = TileLoader.seen52 & getSeenHorizontal(52);
                if ((TileLoader.wall52 & seen_fused) != (getWallHorizontal(52) & seen_fused)) {
                    HSYM = 0;
                }
                if ((TileLoader.ruin52 & seen_fused) != (getRuinHorizontal(52) & seen_fused)) {
                    HSYM = 0;
                }
                seen_fused = TileLoader.seen53 & getSeenHorizontal(53);
                if ((TileLoader.wall53 & seen_fused) != (getWallHorizontal(53) & seen_fused)) {
                    HSYM = 0;
                }
                if ((TileLoader.ruin53 & seen_fused) != (getRuinHorizontal(53) & seen_fused)) {
                    HSYM = 0;
                }
                seen_fused = TileLoader.seen54 & getSeenHorizontal(54);
                if ((TileLoader.wall54 & seen_fused) != (getWallHorizontal(54) & seen_fused)) {
                    HSYM = 0;
                }
                if ((TileLoader.ruin54 & seen_fused) != (getRuinHorizontal(54) & seen_fused)) {
                    HSYM = 0;
                }
                seen_fused = TileLoader.seen55 & getSeenHorizontal(55);
                if ((TileLoader.wall55 & seen_fused) != (getWallHorizontal(55) & seen_fused)) {
                    HSYM = 0;
                }
                if ((TileLoader.ruin55 & seen_fused) != (getRuinHorizontal(55) & seen_fused)) {
                    HSYM = 0;
                }
                seen_fused = TileLoader.seen56 & getSeenHorizontal(56);
                if ((TileLoader.wall56 & seen_fused) != (getWallHorizontal(56) & seen_fused)) {
                    HSYM = 0;
                }
                if ((TileLoader.ruin56 & seen_fused) != (getRuinHorizontal(56) & seen_fused)) {
                    HSYM = 0;
                }
                seen_fused = TileLoader.seen57 & getSeenHorizontal(57);
                if ((TileLoader.wall57 & seen_fused) != (getWallHorizontal(57) & seen_fused)) {
                    HSYM = 0;
                }
                if ((TileLoader.ruin57 & seen_fused) != (getRuinHorizontal(57) & seen_fused)) {
                    HSYM = 0;
                }
                seen_fused = TileLoader.seen58 & getSeenHorizontal(58);
                if ((TileLoader.wall58 & seen_fused) != (getWallHorizontal(58) & seen_fused)) {
                    HSYM = 0;
                }
                if ((TileLoader.ruin58 & seen_fused) != (getRuinHorizontal(58) & seen_fused)) {
                    HSYM = 0;
                }
                seen_fused = TileLoader.seen59 & getSeenHorizontal(59);
                if ((TileLoader.wall59 & seen_fused) != (getWallHorizontal(59) & seen_fused)) {
                    HSYM = 0;
                }
                if ((TileLoader.ruin59 & seen_fused) != (getRuinHorizontal(59) & seen_fused)) {
                    HSYM = 0;
                }
                
            }
            case 57 -> {
                seen_fused = TileLoader.seen53 & getSeenHorizontal(53);
                if ((TileLoader.wall53 & seen_fused) != (getWallHorizontal(53) & seen_fused)) {
                    HSYM = 0;
                }
                if ((TileLoader.ruin53 & seen_fused) != (getRuinHorizontal(53) & seen_fused)) {
                    HSYM = 0;
                }
                seen_fused = TileLoader.seen54 & getSeenHorizontal(54);
                if ((TileLoader.wall54 & seen_fused) != (getWallHorizontal(54) & seen_fused)) {
                    HSYM = 0;
                }
                if ((TileLoader.ruin54 & seen_fused) != (getRuinHorizontal(54) & seen_fused)) {
                    HSYM = 0;
                }
                seen_fused = TileLoader.seen55 & getSeenHorizontal(55);
                if ((TileLoader.wall55 & seen_fused) != (getWallHorizontal(55) & seen_fused)) {
                    HSYM = 0;
                }
                if ((TileLoader.ruin55 & seen_fused) != (getRuinHorizontal(55) & seen_fused)) {
                    HSYM = 0;
                }
                seen_fused = TileLoader.seen56 & getSeenHorizontal(56);
                if ((TileLoader.wall56 & seen_fused) != (getWallHorizontal(56) & seen_fused)) {
                    HSYM = 0;
                }
                if ((TileLoader.ruin56 & seen_fused) != (getRuinHorizontal(56) & seen_fused)) {
                    HSYM = 0;
                }
                seen_fused = TileLoader.seen57 & getSeenHorizontal(57);
                if ((TileLoader.wall57 & seen_fused) != (getWallHorizontal(57) & seen_fused)) {
                    HSYM = 0;
                }
                if ((TileLoader.ruin57 & seen_fused) != (getRuinHorizontal(57) & seen_fused)) {
                    HSYM = 0;
                }
                seen_fused = TileLoader.seen58 & getSeenHorizontal(58);
                if ((TileLoader.wall58 & seen_fused) != (getWallHorizontal(58) & seen_fused)) {
                    HSYM = 0;
                }
                if ((TileLoader.ruin58 & seen_fused) != (getRuinHorizontal(58) & seen_fused)) {
                    HSYM = 0;
                }
                seen_fused = TileLoader.seen59 & getSeenHorizontal(59);
                if ((TileLoader.wall59 & seen_fused) != (getWallHorizontal(59) & seen_fused)) {
                    HSYM = 0;
                }
                if ((TileLoader.ruin59 & seen_fused) != (getRuinHorizontal(59) & seen_fused)) {
                    HSYM = 0;
                }
                
            }
            case 58 -> {
                seen_fused = TileLoader.seen54 & getSeenHorizontal(54);
                if ((TileLoader.wall54 & seen_fused) != (getWallHorizontal(54) & seen_fused)) {
                    HSYM = 0;
                }
                if ((TileLoader.ruin54 & seen_fused) != (getRuinHorizontal(54) & seen_fused)) {
                    HSYM = 0;
                }
                seen_fused = TileLoader.seen55 & getSeenHorizontal(55);
                if ((TileLoader.wall55 & seen_fused) != (getWallHorizontal(55) & seen_fused)) {
                    HSYM = 0;
                }
                if ((TileLoader.ruin55 & seen_fused) != (getRuinHorizontal(55) & seen_fused)) {
                    HSYM = 0;
                }
                seen_fused = TileLoader.seen56 & getSeenHorizontal(56);
                if ((TileLoader.wall56 & seen_fused) != (getWallHorizontal(56) & seen_fused)) {
                    HSYM = 0;
                }
                if ((TileLoader.ruin56 & seen_fused) != (getRuinHorizontal(56) & seen_fused)) {
                    HSYM = 0;
                }
                seen_fused = TileLoader.seen57 & getSeenHorizontal(57);
                if ((TileLoader.wall57 & seen_fused) != (getWallHorizontal(57) & seen_fused)) {
                    HSYM = 0;
                }
                if ((TileLoader.ruin57 & seen_fused) != (getRuinHorizontal(57) & seen_fused)) {
                    HSYM = 0;
                }
                seen_fused = TileLoader.seen58 & getSeenHorizontal(58);
                if ((TileLoader.wall58 & seen_fused) != (getWallHorizontal(58) & seen_fused)) {
                    HSYM = 0;
                }
                if ((TileLoader.ruin58 & seen_fused) != (getRuinHorizontal(58) & seen_fused)) {
                    HSYM = 0;
                }
                seen_fused = TileLoader.seen59 & getSeenHorizontal(59);
                if ((TileLoader.wall59 & seen_fused) != (getWallHorizontal(59) & seen_fused)) {
                    HSYM = 0;
                }
                if ((TileLoader.ruin59 & seen_fused) != (getRuinHorizontal(59) & seen_fused)) {
                    HSYM = 0;
                }
                
            }
            case 59 -> {
                seen_fused = TileLoader.seen55 & getSeenHorizontal(55);
                if ((TileLoader.wall55 & seen_fused) != (getWallHorizontal(55) & seen_fused)) {
                    HSYM = 0;
                }
                if ((TileLoader.ruin55 & seen_fused) != (getRuinHorizontal(55) & seen_fused)) {
                    HSYM = 0;
                }
                seen_fused = TileLoader.seen56 & getSeenHorizontal(56);
                if ((TileLoader.wall56 & seen_fused) != (getWallHorizontal(56) & seen_fused)) {
                    HSYM = 0;
                }
                if ((TileLoader.ruin56 & seen_fused) != (getRuinHorizontal(56) & seen_fused)) {
                    HSYM = 0;
                }
                seen_fused = TileLoader.seen57 & getSeenHorizontal(57);
                if ((TileLoader.wall57 & seen_fused) != (getWallHorizontal(57) & seen_fused)) {
                    HSYM = 0;
                }
                if ((TileLoader.ruin57 & seen_fused) != (getRuinHorizontal(57) & seen_fused)) {
                    HSYM = 0;
                }
                seen_fused = TileLoader.seen58 & getSeenHorizontal(58);
                if ((TileLoader.wall58 & seen_fused) != (getWallHorizontal(58) & seen_fused)) {
                    HSYM = 0;
                }
                if ((TileLoader.ruin58 & seen_fused) != (getRuinHorizontal(58) & seen_fused)) {
                    HSYM = 0;
                }
                seen_fused = TileLoader.seen59 & getSeenHorizontal(59);
                if ((TileLoader.wall59 & seen_fused) != (getWallHorizontal(59) & seen_fused)) {
                    HSYM = 0;
                }
                if ((TileLoader.ruin59 & seen_fused) != (getRuinHorizontal(59) & seen_fused)) {
                    HSYM = 0;
                }
                
            }
            
            default -> {}
        }
    }

    public static void checkVertical() throws GameActionException {
        switch (rc.getLocation().x) {
            case 0 -> {
                seen_fused = TileLoader.seen0 & TileLoader.seen_reversed0;
                if ((TileLoader.wall0 & seen_fused) != (TileLoader.wall_reversed0 & seen_fused)) {
                    VSYM = 0;
                }
                if ((TileLoader.ruin0 & seen_fused) != (TileLoader.ruin_reversed0 & seen_fused)) {
                    VSYM = 0;
                }
                seen_fused = TileLoader.seen1 & TileLoader.seen_reversed1;
                if ((TileLoader.wall1 & seen_fused) != (TileLoader.wall_reversed1 & seen_fused)) {
                    VSYM = 0;
                }
                if ((TileLoader.ruin1 & seen_fused) != (TileLoader.ruin_reversed1 & seen_fused)) {
                    VSYM = 0;
                }
                seen_fused = TileLoader.seen2 & TileLoader.seen_reversed2;
                if ((TileLoader.wall2 & seen_fused) != (TileLoader.wall_reversed2 & seen_fused)) {
                    VSYM = 0;
                }
                if ((TileLoader.ruin2 & seen_fused) != (TileLoader.ruin_reversed2 & seen_fused)) {
                    VSYM = 0;
                }
                seen_fused = TileLoader.seen3 & TileLoader.seen_reversed3;
                if ((TileLoader.wall3 & seen_fused) != (TileLoader.wall_reversed3 & seen_fused)) {
                    VSYM = 0;
                }
                if ((TileLoader.ruin3 & seen_fused) != (TileLoader.ruin_reversed3 & seen_fused)) {
                    VSYM = 0;
                }
                seen_fused = TileLoader.seen4 & TileLoader.seen_reversed4;
                if ((TileLoader.wall4 & seen_fused) != (TileLoader.wall_reversed4 & seen_fused)) {
                    VSYM = 0;
                }
                if ((TileLoader.ruin4 & seen_fused) != (TileLoader.ruin_reversed4 & seen_fused)) {
                    VSYM = 0;
                }
                
            }
            case 1 -> {
                seen_fused = TileLoader.seen0 & TileLoader.seen_reversed0;
                if ((TileLoader.wall0 & seen_fused) != (TileLoader.wall_reversed0 & seen_fused)) {
                    VSYM = 0;
                }
                if ((TileLoader.ruin0 & seen_fused) != (TileLoader.ruin_reversed0 & seen_fused)) {
                    VSYM = 0;
                }
                seen_fused = TileLoader.seen1 & TileLoader.seen_reversed1;
                if ((TileLoader.wall1 & seen_fused) != (TileLoader.wall_reversed1 & seen_fused)) {
                    VSYM = 0;
                }
                if ((TileLoader.ruin1 & seen_fused) != (TileLoader.ruin_reversed1 & seen_fused)) {
                    VSYM = 0;
                }
                seen_fused = TileLoader.seen2 & TileLoader.seen_reversed2;
                if ((TileLoader.wall2 & seen_fused) != (TileLoader.wall_reversed2 & seen_fused)) {
                    VSYM = 0;
                }
                if ((TileLoader.ruin2 & seen_fused) != (TileLoader.ruin_reversed2 & seen_fused)) {
                    VSYM = 0;
                }
                seen_fused = TileLoader.seen3 & TileLoader.seen_reversed3;
                if ((TileLoader.wall3 & seen_fused) != (TileLoader.wall_reversed3 & seen_fused)) {
                    VSYM = 0;
                }
                if ((TileLoader.ruin3 & seen_fused) != (TileLoader.ruin_reversed3 & seen_fused)) {
                    VSYM = 0;
                }
                seen_fused = TileLoader.seen4 & TileLoader.seen_reversed4;
                if ((TileLoader.wall4 & seen_fused) != (TileLoader.wall_reversed4 & seen_fused)) {
                    VSYM = 0;
                }
                if ((TileLoader.ruin4 & seen_fused) != (TileLoader.ruin_reversed4 & seen_fused)) {
                    VSYM = 0;
                }
                seen_fused = TileLoader.seen5 & TileLoader.seen_reversed5;
                if ((TileLoader.wall5 & seen_fused) != (TileLoader.wall_reversed5 & seen_fused)) {
                    VSYM = 0;
                }
                if ((TileLoader.ruin5 & seen_fused) != (TileLoader.ruin_reversed5 & seen_fused)) {
                    VSYM = 0;
                }
                
            }
            case 2 -> {
                seen_fused = TileLoader.seen0 & TileLoader.seen_reversed0;
                if ((TileLoader.wall0 & seen_fused) != (TileLoader.wall_reversed0 & seen_fused)) {
                    VSYM = 0;
                }
                if ((TileLoader.ruin0 & seen_fused) != (TileLoader.ruin_reversed0 & seen_fused)) {
                    VSYM = 0;
                }
                seen_fused = TileLoader.seen1 & TileLoader.seen_reversed1;
                if ((TileLoader.wall1 & seen_fused) != (TileLoader.wall_reversed1 & seen_fused)) {
                    VSYM = 0;
                }
                if ((TileLoader.ruin1 & seen_fused) != (TileLoader.ruin_reversed1 & seen_fused)) {
                    VSYM = 0;
                }
                seen_fused = TileLoader.seen2 & TileLoader.seen_reversed2;
                if ((TileLoader.wall2 & seen_fused) != (TileLoader.wall_reversed2 & seen_fused)) {
                    VSYM = 0;
                }
                if ((TileLoader.ruin2 & seen_fused) != (TileLoader.ruin_reversed2 & seen_fused)) {
                    VSYM = 0;
                }
                seen_fused = TileLoader.seen3 & TileLoader.seen_reversed3;
                if ((TileLoader.wall3 & seen_fused) != (TileLoader.wall_reversed3 & seen_fused)) {
                    VSYM = 0;
                }
                if ((TileLoader.ruin3 & seen_fused) != (TileLoader.ruin_reversed3 & seen_fused)) {
                    VSYM = 0;
                }
                seen_fused = TileLoader.seen4 & TileLoader.seen_reversed4;
                if ((TileLoader.wall4 & seen_fused) != (TileLoader.wall_reversed4 & seen_fused)) {
                    VSYM = 0;
                }
                if ((TileLoader.ruin4 & seen_fused) != (TileLoader.ruin_reversed4 & seen_fused)) {
                    VSYM = 0;
                }
                seen_fused = TileLoader.seen5 & TileLoader.seen_reversed5;
                if ((TileLoader.wall5 & seen_fused) != (TileLoader.wall_reversed5 & seen_fused)) {
                    VSYM = 0;
                }
                if ((TileLoader.ruin5 & seen_fused) != (TileLoader.ruin_reversed5 & seen_fused)) {
                    VSYM = 0;
                }
                seen_fused = TileLoader.seen6 & TileLoader.seen_reversed6;
                if ((TileLoader.wall6 & seen_fused) != (TileLoader.wall_reversed6 & seen_fused)) {
                    VSYM = 0;
                }
                if ((TileLoader.ruin6 & seen_fused) != (TileLoader.ruin_reversed6 & seen_fused)) {
                    VSYM = 0;
                }
                
            }
            case 3 -> {
                seen_fused = TileLoader.seen0 & TileLoader.seen_reversed0;
                if ((TileLoader.wall0 & seen_fused) != (TileLoader.wall_reversed0 & seen_fused)) {
                    VSYM = 0;
                }
                if ((TileLoader.ruin0 & seen_fused) != (TileLoader.ruin_reversed0 & seen_fused)) {
                    VSYM = 0;
                }
                seen_fused = TileLoader.seen1 & TileLoader.seen_reversed1;
                if ((TileLoader.wall1 & seen_fused) != (TileLoader.wall_reversed1 & seen_fused)) {
                    VSYM = 0;
                }
                if ((TileLoader.ruin1 & seen_fused) != (TileLoader.ruin_reversed1 & seen_fused)) {
                    VSYM = 0;
                }
                seen_fused = TileLoader.seen2 & TileLoader.seen_reversed2;
                if ((TileLoader.wall2 & seen_fused) != (TileLoader.wall_reversed2 & seen_fused)) {
                    VSYM = 0;
                }
                if ((TileLoader.ruin2 & seen_fused) != (TileLoader.ruin_reversed2 & seen_fused)) {
                    VSYM = 0;
                }
                seen_fused = TileLoader.seen3 & TileLoader.seen_reversed3;
                if ((TileLoader.wall3 & seen_fused) != (TileLoader.wall_reversed3 & seen_fused)) {
                    VSYM = 0;
                }
                if ((TileLoader.ruin3 & seen_fused) != (TileLoader.ruin_reversed3 & seen_fused)) {
                    VSYM = 0;
                }
                seen_fused = TileLoader.seen4 & TileLoader.seen_reversed4;
                if ((TileLoader.wall4 & seen_fused) != (TileLoader.wall_reversed4 & seen_fused)) {
                    VSYM = 0;
                }
                if ((TileLoader.ruin4 & seen_fused) != (TileLoader.ruin_reversed4 & seen_fused)) {
                    VSYM = 0;
                }
                seen_fused = TileLoader.seen5 & TileLoader.seen_reversed5;
                if ((TileLoader.wall5 & seen_fused) != (TileLoader.wall_reversed5 & seen_fused)) {
                    VSYM = 0;
                }
                if ((TileLoader.ruin5 & seen_fused) != (TileLoader.ruin_reversed5 & seen_fused)) {
                    VSYM = 0;
                }
                seen_fused = TileLoader.seen6 & TileLoader.seen_reversed6;
                if ((TileLoader.wall6 & seen_fused) != (TileLoader.wall_reversed6 & seen_fused)) {
                    VSYM = 0;
                }
                if ((TileLoader.ruin6 & seen_fused) != (TileLoader.ruin_reversed6 & seen_fused)) {
                    VSYM = 0;
                }
                seen_fused = TileLoader.seen7 & TileLoader.seen_reversed7;
                if ((TileLoader.wall7 & seen_fused) != (TileLoader.wall_reversed7 & seen_fused)) {
                    VSYM = 0;
                }
                if ((TileLoader.ruin7 & seen_fused) != (TileLoader.ruin_reversed7 & seen_fused)) {
                    VSYM = 0;
                }
                
            }
            case 4 -> {
                seen_fused = TileLoader.seen0 & TileLoader.seen_reversed0;
                if ((TileLoader.wall0 & seen_fused) != (TileLoader.wall_reversed0 & seen_fused)) {
                    VSYM = 0;
                }
                if ((TileLoader.ruin0 & seen_fused) != (TileLoader.ruin_reversed0 & seen_fused)) {
                    VSYM = 0;
                }
                seen_fused = TileLoader.seen1 & TileLoader.seen_reversed1;
                if ((TileLoader.wall1 & seen_fused) != (TileLoader.wall_reversed1 & seen_fused)) {
                    VSYM = 0;
                }
                if ((TileLoader.ruin1 & seen_fused) != (TileLoader.ruin_reversed1 & seen_fused)) {
                    VSYM = 0;
                }
                seen_fused = TileLoader.seen2 & TileLoader.seen_reversed2;
                if ((TileLoader.wall2 & seen_fused) != (TileLoader.wall_reversed2 & seen_fused)) {
                    VSYM = 0;
                }
                if ((TileLoader.ruin2 & seen_fused) != (TileLoader.ruin_reversed2 & seen_fused)) {
                    VSYM = 0;
                }
                seen_fused = TileLoader.seen3 & TileLoader.seen_reversed3;
                if ((TileLoader.wall3 & seen_fused) != (TileLoader.wall_reversed3 & seen_fused)) {
                    VSYM = 0;
                }
                if ((TileLoader.ruin3 & seen_fused) != (TileLoader.ruin_reversed3 & seen_fused)) {
                    VSYM = 0;
                }
                seen_fused = TileLoader.seen4 & TileLoader.seen_reversed4;
                if ((TileLoader.wall4 & seen_fused) != (TileLoader.wall_reversed4 & seen_fused)) {
                    VSYM = 0;
                }
                if ((TileLoader.ruin4 & seen_fused) != (TileLoader.ruin_reversed4 & seen_fused)) {
                    VSYM = 0;
                }
                seen_fused = TileLoader.seen5 & TileLoader.seen_reversed5;
                if ((TileLoader.wall5 & seen_fused) != (TileLoader.wall_reversed5 & seen_fused)) {
                    VSYM = 0;
                }
                if ((TileLoader.ruin5 & seen_fused) != (TileLoader.ruin_reversed5 & seen_fused)) {
                    VSYM = 0;
                }
                seen_fused = TileLoader.seen6 & TileLoader.seen_reversed6;
                if ((TileLoader.wall6 & seen_fused) != (TileLoader.wall_reversed6 & seen_fused)) {
                    VSYM = 0;
                }
                if ((TileLoader.ruin6 & seen_fused) != (TileLoader.ruin_reversed6 & seen_fused)) {
                    VSYM = 0;
                }
                seen_fused = TileLoader.seen7 & TileLoader.seen_reversed7;
                if ((TileLoader.wall7 & seen_fused) != (TileLoader.wall_reversed7 & seen_fused)) {
                    VSYM = 0;
                }
                if ((TileLoader.ruin7 & seen_fused) != (TileLoader.ruin_reversed7 & seen_fused)) {
                    VSYM = 0;
                }
                seen_fused = TileLoader.seen8 & TileLoader.seen_reversed8;
                if ((TileLoader.wall8 & seen_fused) != (TileLoader.wall_reversed8 & seen_fused)) {
                    VSYM = 0;
                }
                if ((TileLoader.ruin8 & seen_fused) != (TileLoader.ruin_reversed8 & seen_fused)) {
                    VSYM = 0;
                }
                
            }
            case 5 -> {
                seen_fused = TileLoader.seen1 & TileLoader.seen_reversed1;
                if ((TileLoader.wall1 & seen_fused) != (TileLoader.wall_reversed1 & seen_fused)) {
                    VSYM = 0;
                }
                if ((TileLoader.ruin1 & seen_fused) != (TileLoader.ruin_reversed1 & seen_fused)) {
                    VSYM = 0;
                }
                seen_fused = TileLoader.seen2 & TileLoader.seen_reversed2;
                if ((TileLoader.wall2 & seen_fused) != (TileLoader.wall_reversed2 & seen_fused)) {
                    VSYM = 0;
                }
                if ((TileLoader.ruin2 & seen_fused) != (TileLoader.ruin_reversed2 & seen_fused)) {
                    VSYM = 0;
                }
                seen_fused = TileLoader.seen3 & TileLoader.seen_reversed3;
                if ((TileLoader.wall3 & seen_fused) != (TileLoader.wall_reversed3 & seen_fused)) {
                    VSYM = 0;
                }
                if ((TileLoader.ruin3 & seen_fused) != (TileLoader.ruin_reversed3 & seen_fused)) {
                    VSYM = 0;
                }
                seen_fused = TileLoader.seen4 & TileLoader.seen_reversed4;
                if ((TileLoader.wall4 & seen_fused) != (TileLoader.wall_reversed4 & seen_fused)) {
                    VSYM = 0;
                }
                if ((TileLoader.ruin4 & seen_fused) != (TileLoader.ruin_reversed4 & seen_fused)) {
                    VSYM = 0;
                }
                seen_fused = TileLoader.seen5 & TileLoader.seen_reversed5;
                if ((TileLoader.wall5 & seen_fused) != (TileLoader.wall_reversed5 & seen_fused)) {
                    VSYM = 0;
                }
                if ((TileLoader.ruin5 & seen_fused) != (TileLoader.ruin_reversed5 & seen_fused)) {
                    VSYM = 0;
                }
                seen_fused = TileLoader.seen6 & TileLoader.seen_reversed6;
                if ((TileLoader.wall6 & seen_fused) != (TileLoader.wall_reversed6 & seen_fused)) {
                    VSYM = 0;
                }
                if ((TileLoader.ruin6 & seen_fused) != (TileLoader.ruin_reversed6 & seen_fused)) {
                    VSYM = 0;
                }
                seen_fused = TileLoader.seen7 & TileLoader.seen_reversed7;
                if ((TileLoader.wall7 & seen_fused) != (TileLoader.wall_reversed7 & seen_fused)) {
                    VSYM = 0;
                }
                if ((TileLoader.ruin7 & seen_fused) != (TileLoader.ruin_reversed7 & seen_fused)) {
                    VSYM = 0;
                }
                seen_fused = TileLoader.seen8 & TileLoader.seen_reversed8;
                if ((TileLoader.wall8 & seen_fused) != (TileLoader.wall_reversed8 & seen_fused)) {
                    VSYM = 0;
                }
                if ((TileLoader.ruin8 & seen_fused) != (TileLoader.ruin_reversed8 & seen_fused)) {
                    VSYM = 0;
                }
                seen_fused = TileLoader.seen9 & TileLoader.seen_reversed9;
                if ((TileLoader.wall9 & seen_fused) != (TileLoader.wall_reversed9 & seen_fused)) {
                    VSYM = 0;
                }
                if ((TileLoader.ruin9 & seen_fused) != (TileLoader.ruin_reversed9 & seen_fused)) {
                    VSYM = 0;
                }
                
            }
            case 6 -> {
                seen_fused = TileLoader.seen2 & TileLoader.seen_reversed2;
                if ((TileLoader.wall2 & seen_fused) != (TileLoader.wall_reversed2 & seen_fused)) {
                    VSYM = 0;
                }
                if ((TileLoader.ruin2 & seen_fused) != (TileLoader.ruin_reversed2 & seen_fused)) {
                    VSYM = 0;
                }
                seen_fused = TileLoader.seen3 & TileLoader.seen_reversed3;
                if ((TileLoader.wall3 & seen_fused) != (TileLoader.wall_reversed3 & seen_fused)) {
                    VSYM = 0;
                }
                if ((TileLoader.ruin3 & seen_fused) != (TileLoader.ruin_reversed3 & seen_fused)) {
                    VSYM = 0;
                }
                seen_fused = TileLoader.seen4 & TileLoader.seen_reversed4;
                if ((TileLoader.wall4 & seen_fused) != (TileLoader.wall_reversed4 & seen_fused)) {
                    VSYM = 0;
                }
                if ((TileLoader.ruin4 & seen_fused) != (TileLoader.ruin_reversed4 & seen_fused)) {
                    VSYM = 0;
                }
                seen_fused = TileLoader.seen5 & TileLoader.seen_reversed5;
                if ((TileLoader.wall5 & seen_fused) != (TileLoader.wall_reversed5 & seen_fused)) {
                    VSYM = 0;
                }
                if ((TileLoader.ruin5 & seen_fused) != (TileLoader.ruin_reversed5 & seen_fused)) {
                    VSYM = 0;
                }
                seen_fused = TileLoader.seen6 & TileLoader.seen_reversed6;
                if ((TileLoader.wall6 & seen_fused) != (TileLoader.wall_reversed6 & seen_fused)) {
                    VSYM = 0;
                }
                if ((TileLoader.ruin6 & seen_fused) != (TileLoader.ruin_reversed6 & seen_fused)) {
                    VSYM = 0;
                }
                seen_fused = TileLoader.seen7 & TileLoader.seen_reversed7;
                if ((TileLoader.wall7 & seen_fused) != (TileLoader.wall_reversed7 & seen_fused)) {
                    VSYM = 0;
                }
                if ((TileLoader.ruin7 & seen_fused) != (TileLoader.ruin_reversed7 & seen_fused)) {
                    VSYM = 0;
                }
                seen_fused = TileLoader.seen8 & TileLoader.seen_reversed8;
                if ((TileLoader.wall8 & seen_fused) != (TileLoader.wall_reversed8 & seen_fused)) {
                    VSYM = 0;
                }
                if ((TileLoader.ruin8 & seen_fused) != (TileLoader.ruin_reversed8 & seen_fused)) {
                    VSYM = 0;
                }
                seen_fused = TileLoader.seen9 & TileLoader.seen_reversed9;
                if ((TileLoader.wall9 & seen_fused) != (TileLoader.wall_reversed9 & seen_fused)) {
                    VSYM = 0;
                }
                if ((TileLoader.ruin9 & seen_fused) != (TileLoader.ruin_reversed9 & seen_fused)) {
                    VSYM = 0;
                }
                seen_fused = TileLoader.seen10 & TileLoader.seen_reversed10;
                if ((TileLoader.wall10 & seen_fused) != (TileLoader.wall_reversed10 & seen_fused)) {
                    VSYM = 0;
                }
                if ((TileLoader.ruin10 & seen_fused) != (TileLoader.ruin_reversed10 & seen_fused)) {
                    VSYM = 0;
                }
                
            }
            case 7 -> {
                seen_fused = TileLoader.seen3 & TileLoader.seen_reversed3;
                if ((TileLoader.wall3 & seen_fused) != (TileLoader.wall_reversed3 & seen_fused)) {
                    VSYM = 0;
                }
                if ((TileLoader.ruin3 & seen_fused) != (TileLoader.ruin_reversed3 & seen_fused)) {
                    VSYM = 0;
                }
                seen_fused = TileLoader.seen4 & TileLoader.seen_reversed4;
                if ((TileLoader.wall4 & seen_fused) != (TileLoader.wall_reversed4 & seen_fused)) {
                    VSYM = 0;
                }
                if ((TileLoader.ruin4 & seen_fused) != (TileLoader.ruin_reversed4 & seen_fused)) {
                    VSYM = 0;
                }
                seen_fused = TileLoader.seen5 & TileLoader.seen_reversed5;
                if ((TileLoader.wall5 & seen_fused) != (TileLoader.wall_reversed5 & seen_fused)) {
                    VSYM = 0;
                }
                if ((TileLoader.ruin5 & seen_fused) != (TileLoader.ruin_reversed5 & seen_fused)) {
                    VSYM = 0;
                }
                seen_fused = TileLoader.seen6 & TileLoader.seen_reversed6;
                if ((TileLoader.wall6 & seen_fused) != (TileLoader.wall_reversed6 & seen_fused)) {
                    VSYM = 0;
                }
                if ((TileLoader.ruin6 & seen_fused) != (TileLoader.ruin_reversed6 & seen_fused)) {
                    VSYM = 0;
                }
                seen_fused = TileLoader.seen7 & TileLoader.seen_reversed7;
                if ((TileLoader.wall7 & seen_fused) != (TileLoader.wall_reversed7 & seen_fused)) {
                    VSYM = 0;
                }
                if ((TileLoader.ruin7 & seen_fused) != (TileLoader.ruin_reversed7 & seen_fused)) {
                    VSYM = 0;
                }
                seen_fused = TileLoader.seen8 & TileLoader.seen_reversed8;
                if ((TileLoader.wall8 & seen_fused) != (TileLoader.wall_reversed8 & seen_fused)) {
                    VSYM = 0;
                }
                if ((TileLoader.ruin8 & seen_fused) != (TileLoader.ruin_reversed8 & seen_fused)) {
                    VSYM = 0;
                }
                seen_fused = TileLoader.seen9 & TileLoader.seen_reversed9;
                if ((TileLoader.wall9 & seen_fused) != (TileLoader.wall_reversed9 & seen_fused)) {
                    VSYM = 0;
                }
                if ((TileLoader.ruin9 & seen_fused) != (TileLoader.ruin_reversed9 & seen_fused)) {
                    VSYM = 0;
                }
                seen_fused = TileLoader.seen10 & TileLoader.seen_reversed10;
                if ((TileLoader.wall10 & seen_fused) != (TileLoader.wall_reversed10 & seen_fused)) {
                    VSYM = 0;
                }
                if ((TileLoader.ruin10 & seen_fused) != (TileLoader.ruin_reversed10 & seen_fused)) {
                    VSYM = 0;
                }
                seen_fused = TileLoader.seen11 & TileLoader.seen_reversed11;
                if ((TileLoader.wall11 & seen_fused) != (TileLoader.wall_reversed11 & seen_fused)) {
                    VSYM = 0;
                }
                if ((TileLoader.ruin11 & seen_fused) != (TileLoader.ruin_reversed11 & seen_fused)) {
                    VSYM = 0;
                }
                
            }
            case 8 -> {
                seen_fused = TileLoader.seen4 & TileLoader.seen_reversed4;
                if ((TileLoader.wall4 & seen_fused) != (TileLoader.wall_reversed4 & seen_fused)) {
                    VSYM = 0;
                }
                if ((TileLoader.ruin4 & seen_fused) != (TileLoader.ruin_reversed4 & seen_fused)) {
                    VSYM = 0;
                }
                seen_fused = TileLoader.seen5 & TileLoader.seen_reversed5;
                if ((TileLoader.wall5 & seen_fused) != (TileLoader.wall_reversed5 & seen_fused)) {
                    VSYM = 0;
                }
                if ((TileLoader.ruin5 & seen_fused) != (TileLoader.ruin_reversed5 & seen_fused)) {
                    VSYM = 0;
                }
                seen_fused = TileLoader.seen6 & TileLoader.seen_reversed6;
                if ((TileLoader.wall6 & seen_fused) != (TileLoader.wall_reversed6 & seen_fused)) {
                    VSYM = 0;
                }
                if ((TileLoader.ruin6 & seen_fused) != (TileLoader.ruin_reversed6 & seen_fused)) {
                    VSYM = 0;
                }
                seen_fused = TileLoader.seen7 & TileLoader.seen_reversed7;
                if ((TileLoader.wall7 & seen_fused) != (TileLoader.wall_reversed7 & seen_fused)) {
                    VSYM = 0;
                }
                if ((TileLoader.ruin7 & seen_fused) != (TileLoader.ruin_reversed7 & seen_fused)) {
                    VSYM = 0;
                }
                seen_fused = TileLoader.seen8 & TileLoader.seen_reversed8;
                if ((TileLoader.wall8 & seen_fused) != (TileLoader.wall_reversed8 & seen_fused)) {
                    VSYM = 0;
                }
                if ((TileLoader.ruin8 & seen_fused) != (TileLoader.ruin_reversed8 & seen_fused)) {
                    VSYM = 0;
                }
                seen_fused = TileLoader.seen9 & TileLoader.seen_reversed9;
                if ((TileLoader.wall9 & seen_fused) != (TileLoader.wall_reversed9 & seen_fused)) {
                    VSYM = 0;
                }
                if ((TileLoader.ruin9 & seen_fused) != (TileLoader.ruin_reversed9 & seen_fused)) {
                    VSYM = 0;
                }
                seen_fused = TileLoader.seen10 & TileLoader.seen_reversed10;
                if ((TileLoader.wall10 & seen_fused) != (TileLoader.wall_reversed10 & seen_fused)) {
                    VSYM = 0;
                }
                if ((TileLoader.ruin10 & seen_fused) != (TileLoader.ruin_reversed10 & seen_fused)) {
                    VSYM = 0;
                }
                seen_fused = TileLoader.seen11 & TileLoader.seen_reversed11;
                if ((TileLoader.wall11 & seen_fused) != (TileLoader.wall_reversed11 & seen_fused)) {
                    VSYM = 0;
                }
                if ((TileLoader.ruin11 & seen_fused) != (TileLoader.ruin_reversed11 & seen_fused)) {
                    VSYM = 0;
                }
                seen_fused = TileLoader.seen12 & TileLoader.seen_reversed12;
                if ((TileLoader.wall12 & seen_fused) != (TileLoader.wall_reversed12 & seen_fused)) {
                    VSYM = 0;
                }
                if ((TileLoader.ruin12 & seen_fused) != (TileLoader.ruin_reversed12 & seen_fused)) {
                    VSYM = 0;
                }
                
            }
            case 9 -> {
                seen_fused = TileLoader.seen5 & TileLoader.seen_reversed5;
                if ((TileLoader.wall5 & seen_fused) != (TileLoader.wall_reversed5 & seen_fused)) {
                    VSYM = 0;
                }
                if ((TileLoader.ruin5 & seen_fused) != (TileLoader.ruin_reversed5 & seen_fused)) {
                    VSYM = 0;
                }
                seen_fused = TileLoader.seen6 & TileLoader.seen_reversed6;
                if ((TileLoader.wall6 & seen_fused) != (TileLoader.wall_reversed6 & seen_fused)) {
                    VSYM = 0;
                }
                if ((TileLoader.ruin6 & seen_fused) != (TileLoader.ruin_reversed6 & seen_fused)) {
                    VSYM = 0;
                }
                seen_fused = TileLoader.seen7 & TileLoader.seen_reversed7;
                if ((TileLoader.wall7 & seen_fused) != (TileLoader.wall_reversed7 & seen_fused)) {
                    VSYM = 0;
                }
                if ((TileLoader.ruin7 & seen_fused) != (TileLoader.ruin_reversed7 & seen_fused)) {
                    VSYM = 0;
                }
                seen_fused = TileLoader.seen8 & TileLoader.seen_reversed8;
                if ((TileLoader.wall8 & seen_fused) != (TileLoader.wall_reversed8 & seen_fused)) {
                    VSYM = 0;
                }
                if ((TileLoader.ruin8 & seen_fused) != (TileLoader.ruin_reversed8 & seen_fused)) {
                    VSYM = 0;
                }
                seen_fused = TileLoader.seen9 & TileLoader.seen_reversed9;
                if ((TileLoader.wall9 & seen_fused) != (TileLoader.wall_reversed9 & seen_fused)) {
                    VSYM = 0;
                }
                if ((TileLoader.ruin9 & seen_fused) != (TileLoader.ruin_reversed9 & seen_fused)) {
                    VSYM = 0;
                }
                seen_fused = TileLoader.seen10 & TileLoader.seen_reversed10;
                if ((TileLoader.wall10 & seen_fused) != (TileLoader.wall_reversed10 & seen_fused)) {
                    VSYM = 0;
                }
                if ((TileLoader.ruin10 & seen_fused) != (TileLoader.ruin_reversed10 & seen_fused)) {
                    VSYM = 0;
                }
                seen_fused = TileLoader.seen11 & TileLoader.seen_reversed11;
                if ((TileLoader.wall11 & seen_fused) != (TileLoader.wall_reversed11 & seen_fused)) {
                    VSYM = 0;
                }
                if ((TileLoader.ruin11 & seen_fused) != (TileLoader.ruin_reversed11 & seen_fused)) {
                    VSYM = 0;
                }
                seen_fused = TileLoader.seen12 & TileLoader.seen_reversed12;
                if ((TileLoader.wall12 & seen_fused) != (TileLoader.wall_reversed12 & seen_fused)) {
                    VSYM = 0;
                }
                if ((TileLoader.ruin12 & seen_fused) != (TileLoader.ruin_reversed12 & seen_fused)) {
                    VSYM = 0;
                }
                seen_fused = TileLoader.seen13 & TileLoader.seen_reversed13;
                if ((TileLoader.wall13 & seen_fused) != (TileLoader.wall_reversed13 & seen_fused)) {
                    VSYM = 0;
                }
                if ((TileLoader.ruin13 & seen_fused) != (TileLoader.ruin_reversed13 & seen_fused)) {
                    VSYM = 0;
                }
                
            }
            case 10 -> {
                seen_fused = TileLoader.seen6 & TileLoader.seen_reversed6;
                if ((TileLoader.wall6 & seen_fused) != (TileLoader.wall_reversed6 & seen_fused)) {
                    VSYM = 0;
                }
                if ((TileLoader.ruin6 & seen_fused) != (TileLoader.ruin_reversed6 & seen_fused)) {
                    VSYM = 0;
                }
                seen_fused = TileLoader.seen7 & TileLoader.seen_reversed7;
                if ((TileLoader.wall7 & seen_fused) != (TileLoader.wall_reversed7 & seen_fused)) {
                    VSYM = 0;
                }
                if ((TileLoader.ruin7 & seen_fused) != (TileLoader.ruin_reversed7 & seen_fused)) {
                    VSYM = 0;
                }
                seen_fused = TileLoader.seen8 & TileLoader.seen_reversed8;
                if ((TileLoader.wall8 & seen_fused) != (TileLoader.wall_reversed8 & seen_fused)) {
                    VSYM = 0;
                }
                if ((TileLoader.ruin8 & seen_fused) != (TileLoader.ruin_reversed8 & seen_fused)) {
                    VSYM = 0;
                }
                seen_fused = TileLoader.seen9 & TileLoader.seen_reversed9;
                if ((TileLoader.wall9 & seen_fused) != (TileLoader.wall_reversed9 & seen_fused)) {
                    VSYM = 0;
                }
                if ((TileLoader.ruin9 & seen_fused) != (TileLoader.ruin_reversed9 & seen_fused)) {
                    VSYM = 0;
                }
                seen_fused = TileLoader.seen10 & TileLoader.seen_reversed10;
                if ((TileLoader.wall10 & seen_fused) != (TileLoader.wall_reversed10 & seen_fused)) {
                    VSYM = 0;
                }
                if ((TileLoader.ruin10 & seen_fused) != (TileLoader.ruin_reversed10 & seen_fused)) {
                    VSYM = 0;
                }
                seen_fused = TileLoader.seen11 & TileLoader.seen_reversed11;
                if ((TileLoader.wall11 & seen_fused) != (TileLoader.wall_reversed11 & seen_fused)) {
                    VSYM = 0;
                }
                if ((TileLoader.ruin11 & seen_fused) != (TileLoader.ruin_reversed11 & seen_fused)) {
                    VSYM = 0;
                }
                seen_fused = TileLoader.seen12 & TileLoader.seen_reversed12;
                if ((TileLoader.wall12 & seen_fused) != (TileLoader.wall_reversed12 & seen_fused)) {
                    VSYM = 0;
                }
                if ((TileLoader.ruin12 & seen_fused) != (TileLoader.ruin_reversed12 & seen_fused)) {
                    VSYM = 0;
                }
                seen_fused = TileLoader.seen13 & TileLoader.seen_reversed13;
                if ((TileLoader.wall13 & seen_fused) != (TileLoader.wall_reversed13 & seen_fused)) {
                    VSYM = 0;
                }
                if ((TileLoader.ruin13 & seen_fused) != (TileLoader.ruin_reversed13 & seen_fused)) {
                    VSYM = 0;
                }
                seen_fused = TileLoader.seen14 & TileLoader.seen_reversed14;
                if ((TileLoader.wall14 & seen_fused) != (TileLoader.wall_reversed14 & seen_fused)) {
                    VSYM = 0;
                }
                if ((TileLoader.ruin14 & seen_fused) != (TileLoader.ruin_reversed14 & seen_fused)) {
                    VSYM = 0;
                }
                
            }
            case 11 -> {
                seen_fused = TileLoader.seen7 & TileLoader.seen_reversed7;
                if ((TileLoader.wall7 & seen_fused) != (TileLoader.wall_reversed7 & seen_fused)) {
                    VSYM = 0;
                }
                if ((TileLoader.ruin7 & seen_fused) != (TileLoader.ruin_reversed7 & seen_fused)) {
                    VSYM = 0;
                }
                seen_fused = TileLoader.seen8 & TileLoader.seen_reversed8;
                if ((TileLoader.wall8 & seen_fused) != (TileLoader.wall_reversed8 & seen_fused)) {
                    VSYM = 0;
                }
                if ((TileLoader.ruin8 & seen_fused) != (TileLoader.ruin_reversed8 & seen_fused)) {
                    VSYM = 0;
                }
                seen_fused = TileLoader.seen9 & TileLoader.seen_reversed9;
                if ((TileLoader.wall9 & seen_fused) != (TileLoader.wall_reversed9 & seen_fused)) {
                    VSYM = 0;
                }
                if ((TileLoader.ruin9 & seen_fused) != (TileLoader.ruin_reversed9 & seen_fused)) {
                    VSYM = 0;
                }
                seen_fused = TileLoader.seen10 & TileLoader.seen_reversed10;
                if ((TileLoader.wall10 & seen_fused) != (TileLoader.wall_reversed10 & seen_fused)) {
                    VSYM = 0;
                }
                if ((TileLoader.ruin10 & seen_fused) != (TileLoader.ruin_reversed10 & seen_fused)) {
                    VSYM = 0;
                }
                seen_fused = TileLoader.seen11 & TileLoader.seen_reversed11;
                if ((TileLoader.wall11 & seen_fused) != (TileLoader.wall_reversed11 & seen_fused)) {
                    VSYM = 0;
                }
                if ((TileLoader.ruin11 & seen_fused) != (TileLoader.ruin_reversed11 & seen_fused)) {
                    VSYM = 0;
                }
                seen_fused = TileLoader.seen12 & TileLoader.seen_reversed12;
                if ((TileLoader.wall12 & seen_fused) != (TileLoader.wall_reversed12 & seen_fused)) {
                    VSYM = 0;
                }
                if ((TileLoader.ruin12 & seen_fused) != (TileLoader.ruin_reversed12 & seen_fused)) {
                    VSYM = 0;
                }
                seen_fused = TileLoader.seen13 & TileLoader.seen_reversed13;
                if ((TileLoader.wall13 & seen_fused) != (TileLoader.wall_reversed13 & seen_fused)) {
                    VSYM = 0;
                }
                if ((TileLoader.ruin13 & seen_fused) != (TileLoader.ruin_reversed13 & seen_fused)) {
                    VSYM = 0;
                }
                seen_fused = TileLoader.seen14 & TileLoader.seen_reversed14;
                if ((TileLoader.wall14 & seen_fused) != (TileLoader.wall_reversed14 & seen_fused)) {
                    VSYM = 0;
                }
                if ((TileLoader.ruin14 & seen_fused) != (TileLoader.ruin_reversed14 & seen_fused)) {
                    VSYM = 0;
                }
                seen_fused = TileLoader.seen15 & TileLoader.seen_reversed15;
                if ((TileLoader.wall15 & seen_fused) != (TileLoader.wall_reversed15 & seen_fused)) {
                    VSYM = 0;
                }
                if ((TileLoader.ruin15 & seen_fused) != (TileLoader.ruin_reversed15 & seen_fused)) {
                    VSYM = 0;
                }
                
            }
            case 12 -> {
                seen_fused = TileLoader.seen8 & TileLoader.seen_reversed8;
                if ((TileLoader.wall8 & seen_fused) != (TileLoader.wall_reversed8 & seen_fused)) {
                    VSYM = 0;
                }
                if ((TileLoader.ruin8 & seen_fused) != (TileLoader.ruin_reversed8 & seen_fused)) {
                    VSYM = 0;
                }
                seen_fused = TileLoader.seen9 & TileLoader.seen_reversed9;
                if ((TileLoader.wall9 & seen_fused) != (TileLoader.wall_reversed9 & seen_fused)) {
                    VSYM = 0;
                }
                if ((TileLoader.ruin9 & seen_fused) != (TileLoader.ruin_reversed9 & seen_fused)) {
                    VSYM = 0;
                }
                seen_fused = TileLoader.seen10 & TileLoader.seen_reversed10;
                if ((TileLoader.wall10 & seen_fused) != (TileLoader.wall_reversed10 & seen_fused)) {
                    VSYM = 0;
                }
                if ((TileLoader.ruin10 & seen_fused) != (TileLoader.ruin_reversed10 & seen_fused)) {
                    VSYM = 0;
                }
                seen_fused = TileLoader.seen11 & TileLoader.seen_reversed11;
                if ((TileLoader.wall11 & seen_fused) != (TileLoader.wall_reversed11 & seen_fused)) {
                    VSYM = 0;
                }
                if ((TileLoader.ruin11 & seen_fused) != (TileLoader.ruin_reversed11 & seen_fused)) {
                    VSYM = 0;
                }
                seen_fused = TileLoader.seen12 & TileLoader.seen_reversed12;
                if ((TileLoader.wall12 & seen_fused) != (TileLoader.wall_reversed12 & seen_fused)) {
                    VSYM = 0;
                }
                if ((TileLoader.ruin12 & seen_fused) != (TileLoader.ruin_reversed12 & seen_fused)) {
                    VSYM = 0;
                }
                seen_fused = TileLoader.seen13 & TileLoader.seen_reversed13;
                if ((TileLoader.wall13 & seen_fused) != (TileLoader.wall_reversed13 & seen_fused)) {
                    VSYM = 0;
                }
                if ((TileLoader.ruin13 & seen_fused) != (TileLoader.ruin_reversed13 & seen_fused)) {
                    VSYM = 0;
                }
                seen_fused = TileLoader.seen14 & TileLoader.seen_reversed14;
                if ((TileLoader.wall14 & seen_fused) != (TileLoader.wall_reversed14 & seen_fused)) {
                    VSYM = 0;
                }
                if ((TileLoader.ruin14 & seen_fused) != (TileLoader.ruin_reversed14 & seen_fused)) {
                    VSYM = 0;
                }
                seen_fused = TileLoader.seen15 & TileLoader.seen_reversed15;
                if ((TileLoader.wall15 & seen_fused) != (TileLoader.wall_reversed15 & seen_fused)) {
                    VSYM = 0;
                }
                if ((TileLoader.ruin15 & seen_fused) != (TileLoader.ruin_reversed15 & seen_fused)) {
                    VSYM = 0;
                }
                seen_fused = TileLoader.seen16 & TileLoader.seen_reversed16;
                if ((TileLoader.wall16 & seen_fused) != (TileLoader.wall_reversed16 & seen_fused)) {
                    VSYM = 0;
                }
                if ((TileLoader.ruin16 & seen_fused) != (TileLoader.ruin_reversed16 & seen_fused)) {
                    VSYM = 0;
                }
                
            }
            case 13 -> {
                seen_fused = TileLoader.seen9 & TileLoader.seen_reversed9;
                if ((TileLoader.wall9 & seen_fused) != (TileLoader.wall_reversed9 & seen_fused)) {
                    VSYM = 0;
                }
                if ((TileLoader.ruin9 & seen_fused) != (TileLoader.ruin_reversed9 & seen_fused)) {
                    VSYM = 0;
                }
                seen_fused = TileLoader.seen10 & TileLoader.seen_reversed10;
                if ((TileLoader.wall10 & seen_fused) != (TileLoader.wall_reversed10 & seen_fused)) {
                    VSYM = 0;
                }
                if ((TileLoader.ruin10 & seen_fused) != (TileLoader.ruin_reversed10 & seen_fused)) {
                    VSYM = 0;
                }
                seen_fused = TileLoader.seen11 & TileLoader.seen_reversed11;
                if ((TileLoader.wall11 & seen_fused) != (TileLoader.wall_reversed11 & seen_fused)) {
                    VSYM = 0;
                }
                if ((TileLoader.ruin11 & seen_fused) != (TileLoader.ruin_reversed11 & seen_fused)) {
                    VSYM = 0;
                }
                seen_fused = TileLoader.seen12 & TileLoader.seen_reversed12;
                if ((TileLoader.wall12 & seen_fused) != (TileLoader.wall_reversed12 & seen_fused)) {
                    VSYM = 0;
                }
                if ((TileLoader.ruin12 & seen_fused) != (TileLoader.ruin_reversed12 & seen_fused)) {
                    VSYM = 0;
                }
                seen_fused = TileLoader.seen13 & TileLoader.seen_reversed13;
                if ((TileLoader.wall13 & seen_fused) != (TileLoader.wall_reversed13 & seen_fused)) {
                    VSYM = 0;
                }
                if ((TileLoader.ruin13 & seen_fused) != (TileLoader.ruin_reversed13 & seen_fused)) {
                    VSYM = 0;
                }
                seen_fused = TileLoader.seen14 & TileLoader.seen_reversed14;
                if ((TileLoader.wall14 & seen_fused) != (TileLoader.wall_reversed14 & seen_fused)) {
                    VSYM = 0;
                }
                if ((TileLoader.ruin14 & seen_fused) != (TileLoader.ruin_reversed14 & seen_fused)) {
                    VSYM = 0;
                }
                seen_fused = TileLoader.seen15 & TileLoader.seen_reversed15;
                if ((TileLoader.wall15 & seen_fused) != (TileLoader.wall_reversed15 & seen_fused)) {
                    VSYM = 0;
                }
                if ((TileLoader.ruin15 & seen_fused) != (TileLoader.ruin_reversed15 & seen_fused)) {
                    VSYM = 0;
                }
                seen_fused = TileLoader.seen16 & TileLoader.seen_reversed16;
                if ((TileLoader.wall16 & seen_fused) != (TileLoader.wall_reversed16 & seen_fused)) {
                    VSYM = 0;
                }
                if ((TileLoader.ruin16 & seen_fused) != (TileLoader.ruin_reversed16 & seen_fused)) {
                    VSYM = 0;
                }
                seen_fused = TileLoader.seen17 & TileLoader.seen_reversed17;
                if ((TileLoader.wall17 & seen_fused) != (TileLoader.wall_reversed17 & seen_fused)) {
                    VSYM = 0;
                }
                if ((TileLoader.ruin17 & seen_fused) != (TileLoader.ruin_reversed17 & seen_fused)) {
                    VSYM = 0;
                }
                
            }
            case 14 -> {
                seen_fused = TileLoader.seen10 & TileLoader.seen_reversed10;
                if ((TileLoader.wall10 & seen_fused) != (TileLoader.wall_reversed10 & seen_fused)) {
                    VSYM = 0;
                }
                if ((TileLoader.ruin10 & seen_fused) != (TileLoader.ruin_reversed10 & seen_fused)) {
                    VSYM = 0;
                }
                seen_fused = TileLoader.seen11 & TileLoader.seen_reversed11;
                if ((TileLoader.wall11 & seen_fused) != (TileLoader.wall_reversed11 & seen_fused)) {
                    VSYM = 0;
                }
                if ((TileLoader.ruin11 & seen_fused) != (TileLoader.ruin_reversed11 & seen_fused)) {
                    VSYM = 0;
                }
                seen_fused = TileLoader.seen12 & TileLoader.seen_reversed12;
                if ((TileLoader.wall12 & seen_fused) != (TileLoader.wall_reversed12 & seen_fused)) {
                    VSYM = 0;
                }
                if ((TileLoader.ruin12 & seen_fused) != (TileLoader.ruin_reversed12 & seen_fused)) {
                    VSYM = 0;
                }
                seen_fused = TileLoader.seen13 & TileLoader.seen_reversed13;
                if ((TileLoader.wall13 & seen_fused) != (TileLoader.wall_reversed13 & seen_fused)) {
                    VSYM = 0;
                }
                if ((TileLoader.ruin13 & seen_fused) != (TileLoader.ruin_reversed13 & seen_fused)) {
                    VSYM = 0;
                }
                seen_fused = TileLoader.seen14 & TileLoader.seen_reversed14;
                if ((TileLoader.wall14 & seen_fused) != (TileLoader.wall_reversed14 & seen_fused)) {
                    VSYM = 0;
                }
                if ((TileLoader.ruin14 & seen_fused) != (TileLoader.ruin_reversed14 & seen_fused)) {
                    VSYM = 0;
                }
                seen_fused = TileLoader.seen15 & TileLoader.seen_reversed15;
                if ((TileLoader.wall15 & seen_fused) != (TileLoader.wall_reversed15 & seen_fused)) {
                    VSYM = 0;
                }
                if ((TileLoader.ruin15 & seen_fused) != (TileLoader.ruin_reversed15 & seen_fused)) {
                    VSYM = 0;
                }
                seen_fused = TileLoader.seen16 & TileLoader.seen_reversed16;
                if ((TileLoader.wall16 & seen_fused) != (TileLoader.wall_reversed16 & seen_fused)) {
                    VSYM = 0;
                }
                if ((TileLoader.ruin16 & seen_fused) != (TileLoader.ruin_reversed16 & seen_fused)) {
                    VSYM = 0;
                }
                seen_fused = TileLoader.seen17 & TileLoader.seen_reversed17;
                if ((TileLoader.wall17 & seen_fused) != (TileLoader.wall_reversed17 & seen_fused)) {
                    VSYM = 0;
                }
                if ((TileLoader.ruin17 & seen_fused) != (TileLoader.ruin_reversed17 & seen_fused)) {
                    VSYM = 0;
                }
                seen_fused = TileLoader.seen18 & TileLoader.seen_reversed18;
                if ((TileLoader.wall18 & seen_fused) != (TileLoader.wall_reversed18 & seen_fused)) {
                    VSYM = 0;
                }
                if ((TileLoader.ruin18 & seen_fused) != (TileLoader.ruin_reversed18 & seen_fused)) {
                    VSYM = 0;
                }
                
            }
            case 15 -> {
                seen_fused = TileLoader.seen11 & TileLoader.seen_reversed11;
                if ((TileLoader.wall11 & seen_fused) != (TileLoader.wall_reversed11 & seen_fused)) {
                    VSYM = 0;
                }
                if ((TileLoader.ruin11 & seen_fused) != (TileLoader.ruin_reversed11 & seen_fused)) {
                    VSYM = 0;
                }
                seen_fused = TileLoader.seen12 & TileLoader.seen_reversed12;
                if ((TileLoader.wall12 & seen_fused) != (TileLoader.wall_reversed12 & seen_fused)) {
                    VSYM = 0;
                }
                if ((TileLoader.ruin12 & seen_fused) != (TileLoader.ruin_reversed12 & seen_fused)) {
                    VSYM = 0;
                }
                seen_fused = TileLoader.seen13 & TileLoader.seen_reversed13;
                if ((TileLoader.wall13 & seen_fused) != (TileLoader.wall_reversed13 & seen_fused)) {
                    VSYM = 0;
                }
                if ((TileLoader.ruin13 & seen_fused) != (TileLoader.ruin_reversed13 & seen_fused)) {
                    VSYM = 0;
                }
                seen_fused = TileLoader.seen14 & TileLoader.seen_reversed14;
                if ((TileLoader.wall14 & seen_fused) != (TileLoader.wall_reversed14 & seen_fused)) {
                    VSYM = 0;
                }
                if ((TileLoader.ruin14 & seen_fused) != (TileLoader.ruin_reversed14 & seen_fused)) {
                    VSYM = 0;
                }
                seen_fused = TileLoader.seen15 & TileLoader.seen_reversed15;
                if ((TileLoader.wall15 & seen_fused) != (TileLoader.wall_reversed15 & seen_fused)) {
                    VSYM = 0;
                }
                if ((TileLoader.ruin15 & seen_fused) != (TileLoader.ruin_reversed15 & seen_fused)) {
                    VSYM = 0;
                }
                seen_fused = TileLoader.seen16 & TileLoader.seen_reversed16;
                if ((TileLoader.wall16 & seen_fused) != (TileLoader.wall_reversed16 & seen_fused)) {
                    VSYM = 0;
                }
                if ((TileLoader.ruin16 & seen_fused) != (TileLoader.ruin_reversed16 & seen_fused)) {
                    VSYM = 0;
                }
                seen_fused = TileLoader.seen17 & TileLoader.seen_reversed17;
                if ((TileLoader.wall17 & seen_fused) != (TileLoader.wall_reversed17 & seen_fused)) {
                    VSYM = 0;
                }
                if ((TileLoader.ruin17 & seen_fused) != (TileLoader.ruin_reversed17 & seen_fused)) {
                    VSYM = 0;
                }
                seen_fused = TileLoader.seen18 & TileLoader.seen_reversed18;
                if ((TileLoader.wall18 & seen_fused) != (TileLoader.wall_reversed18 & seen_fused)) {
                    VSYM = 0;
                }
                if ((TileLoader.ruin18 & seen_fused) != (TileLoader.ruin_reversed18 & seen_fused)) {
                    VSYM = 0;
                }
                seen_fused = TileLoader.seen19 & TileLoader.seen_reversed19;
                if ((TileLoader.wall19 & seen_fused) != (TileLoader.wall_reversed19 & seen_fused)) {
                    VSYM = 0;
                }
                if ((TileLoader.ruin19 & seen_fused) != (TileLoader.ruin_reversed19 & seen_fused)) {
                    VSYM = 0;
                }
                
            }
            case 16 -> {
                seen_fused = TileLoader.seen12 & TileLoader.seen_reversed12;
                if ((TileLoader.wall12 & seen_fused) != (TileLoader.wall_reversed12 & seen_fused)) {
                    VSYM = 0;
                }
                if ((TileLoader.ruin12 & seen_fused) != (TileLoader.ruin_reversed12 & seen_fused)) {
                    VSYM = 0;
                }
                seen_fused = TileLoader.seen13 & TileLoader.seen_reversed13;
                if ((TileLoader.wall13 & seen_fused) != (TileLoader.wall_reversed13 & seen_fused)) {
                    VSYM = 0;
                }
                if ((TileLoader.ruin13 & seen_fused) != (TileLoader.ruin_reversed13 & seen_fused)) {
                    VSYM = 0;
                }
                seen_fused = TileLoader.seen14 & TileLoader.seen_reversed14;
                if ((TileLoader.wall14 & seen_fused) != (TileLoader.wall_reversed14 & seen_fused)) {
                    VSYM = 0;
                }
                if ((TileLoader.ruin14 & seen_fused) != (TileLoader.ruin_reversed14 & seen_fused)) {
                    VSYM = 0;
                }
                seen_fused = TileLoader.seen15 & TileLoader.seen_reversed15;
                if ((TileLoader.wall15 & seen_fused) != (TileLoader.wall_reversed15 & seen_fused)) {
                    VSYM = 0;
                }
                if ((TileLoader.ruin15 & seen_fused) != (TileLoader.ruin_reversed15 & seen_fused)) {
                    VSYM = 0;
                }
                seen_fused = TileLoader.seen16 & TileLoader.seen_reversed16;
                if ((TileLoader.wall16 & seen_fused) != (TileLoader.wall_reversed16 & seen_fused)) {
                    VSYM = 0;
                }
                if ((TileLoader.ruin16 & seen_fused) != (TileLoader.ruin_reversed16 & seen_fused)) {
                    VSYM = 0;
                }
                seen_fused = TileLoader.seen17 & TileLoader.seen_reversed17;
                if ((TileLoader.wall17 & seen_fused) != (TileLoader.wall_reversed17 & seen_fused)) {
                    VSYM = 0;
                }
                if ((TileLoader.ruin17 & seen_fused) != (TileLoader.ruin_reversed17 & seen_fused)) {
                    VSYM = 0;
                }
                seen_fused = TileLoader.seen18 & TileLoader.seen_reversed18;
                if ((TileLoader.wall18 & seen_fused) != (TileLoader.wall_reversed18 & seen_fused)) {
                    VSYM = 0;
                }
                if ((TileLoader.ruin18 & seen_fused) != (TileLoader.ruin_reversed18 & seen_fused)) {
                    VSYM = 0;
                }
                seen_fused = TileLoader.seen19 & TileLoader.seen_reversed19;
                if ((TileLoader.wall19 & seen_fused) != (TileLoader.wall_reversed19 & seen_fused)) {
                    VSYM = 0;
                }
                if ((TileLoader.ruin19 & seen_fused) != (TileLoader.ruin_reversed19 & seen_fused)) {
                    VSYM = 0;
                }
                seen_fused = TileLoader.seen20 & TileLoader.seen_reversed20;
                if ((TileLoader.wall20 & seen_fused) != (TileLoader.wall_reversed20 & seen_fused)) {
                    VSYM = 0;
                }
                if ((TileLoader.ruin20 & seen_fused) != (TileLoader.ruin_reversed20 & seen_fused)) {
                    VSYM = 0;
                }
                
            }
            case 17 -> {
                seen_fused = TileLoader.seen13 & TileLoader.seen_reversed13;
                if ((TileLoader.wall13 & seen_fused) != (TileLoader.wall_reversed13 & seen_fused)) {
                    VSYM = 0;
                }
                if ((TileLoader.ruin13 & seen_fused) != (TileLoader.ruin_reversed13 & seen_fused)) {
                    VSYM = 0;
                }
                seen_fused = TileLoader.seen14 & TileLoader.seen_reversed14;
                if ((TileLoader.wall14 & seen_fused) != (TileLoader.wall_reversed14 & seen_fused)) {
                    VSYM = 0;
                }
                if ((TileLoader.ruin14 & seen_fused) != (TileLoader.ruin_reversed14 & seen_fused)) {
                    VSYM = 0;
                }
                seen_fused = TileLoader.seen15 & TileLoader.seen_reversed15;
                if ((TileLoader.wall15 & seen_fused) != (TileLoader.wall_reversed15 & seen_fused)) {
                    VSYM = 0;
                }
                if ((TileLoader.ruin15 & seen_fused) != (TileLoader.ruin_reversed15 & seen_fused)) {
                    VSYM = 0;
                }
                seen_fused = TileLoader.seen16 & TileLoader.seen_reversed16;
                if ((TileLoader.wall16 & seen_fused) != (TileLoader.wall_reversed16 & seen_fused)) {
                    VSYM = 0;
                }
                if ((TileLoader.ruin16 & seen_fused) != (TileLoader.ruin_reversed16 & seen_fused)) {
                    VSYM = 0;
                }
                seen_fused = TileLoader.seen17 & TileLoader.seen_reversed17;
                if ((TileLoader.wall17 & seen_fused) != (TileLoader.wall_reversed17 & seen_fused)) {
                    VSYM = 0;
                }
                if ((TileLoader.ruin17 & seen_fused) != (TileLoader.ruin_reversed17 & seen_fused)) {
                    VSYM = 0;
                }
                seen_fused = TileLoader.seen18 & TileLoader.seen_reversed18;
                if ((TileLoader.wall18 & seen_fused) != (TileLoader.wall_reversed18 & seen_fused)) {
                    VSYM = 0;
                }
                if ((TileLoader.ruin18 & seen_fused) != (TileLoader.ruin_reversed18 & seen_fused)) {
                    VSYM = 0;
                }
                seen_fused = TileLoader.seen19 & TileLoader.seen_reversed19;
                if ((TileLoader.wall19 & seen_fused) != (TileLoader.wall_reversed19 & seen_fused)) {
                    VSYM = 0;
                }
                if ((TileLoader.ruin19 & seen_fused) != (TileLoader.ruin_reversed19 & seen_fused)) {
                    VSYM = 0;
                }
                seen_fused = TileLoader.seen20 & TileLoader.seen_reversed20;
                if ((TileLoader.wall20 & seen_fused) != (TileLoader.wall_reversed20 & seen_fused)) {
                    VSYM = 0;
                }
                if ((TileLoader.ruin20 & seen_fused) != (TileLoader.ruin_reversed20 & seen_fused)) {
                    VSYM = 0;
                }
                seen_fused = TileLoader.seen21 & TileLoader.seen_reversed21;
                if ((TileLoader.wall21 & seen_fused) != (TileLoader.wall_reversed21 & seen_fused)) {
                    VSYM = 0;
                }
                if ((TileLoader.ruin21 & seen_fused) != (TileLoader.ruin_reversed21 & seen_fused)) {
                    VSYM = 0;
                }
                
            }
            case 18 -> {
                seen_fused = TileLoader.seen14 & TileLoader.seen_reversed14;
                if ((TileLoader.wall14 & seen_fused) != (TileLoader.wall_reversed14 & seen_fused)) {
                    VSYM = 0;
                }
                if ((TileLoader.ruin14 & seen_fused) != (TileLoader.ruin_reversed14 & seen_fused)) {
                    VSYM = 0;
                }
                seen_fused = TileLoader.seen15 & TileLoader.seen_reversed15;
                if ((TileLoader.wall15 & seen_fused) != (TileLoader.wall_reversed15 & seen_fused)) {
                    VSYM = 0;
                }
                if ((TileLoader.ruin15 & seen_fused) != (TileLoader.ruin_reversed15 & seen_fused)) {
                    VSYM = 0;
                }
                seen_fused = TileLoader.seen16 & TileLoader.seen_reversed16;
                if ((TileLoader.wall16 & seen_fused) != (TileLoader.wall_reversed16 & seen_fused)) {
                    VSYM = 0;
                }
                if ((TileLoader.ruin16 & seen_fused) != (TileLoader.ruin_reversed16 & seen_fused)) {
                    VSYM = 0;
                }
                seen_fused = TileLoader.seen17 & TileLoader.seen_reversed17;
                if ((TileLoader.wall17 & seen_fused) != (TileLoader.wall_reversed17 & seen_fused)) {
                    VSYM = 0;
                }
                if ((TileLoader.ruin17 & seen_fused) != (TileLoader.ruin_reversed17 & seen_fused)) {
                    VSYM = 0;
                }
                seen_fused = TileLoader.seen18 & TileLoader.seen_reversed18;
                if ((TileLoader.wall18 & seen_fused) != (TileLoader.wall_reversed18 & seen_fused)) {
                    VSYM = 0;
                }
                if ((TileLoader.ruin18 & seen_fused) != (TileLoader.ruin_reversed18 & seen_fused)) {
                    VSYM = 0;
                }
                seen_fused = TileLoader.seen19 & TileLoader.seen_reversed19;
                if ((TileLoader.wall19 & seen_fused) != (TileLoader.wall_reversed19 & seen_fused)) {
                    VSYM = 0;
                }
                if ((TileLoader.ruin19 & seen_fused) != (TileLoader.ruin_reversed19 & seen_fused)) {
                    VSYM = 0;
                }
                seen_fused = TileLoader.seen20 & TileLoader.seen_reversed20;
                if ((TileLoader.wall20 & seen_fused) != (TileLoader.wall_reversed20 & seen_fused)) {
                    VSYM = 0;
                }
                if ((TileLoader.ruin20 & seen_fused) != (TileLoader.ruin_reversed20 & seen_fused)) {
                    VSYM = 0;
                }
                seen_fused = TileLoader.seen21 & TileLoader.seen_reversed21;
                if ((TileLoader.wall21 & seen_fused) != (TileLoader.wall_reversed21 & seen_fused)) {
                    VSYM = 0;
                }
                if ((TileLoader.ruin21 & seen_fused) != (TileLoader.ruin_reversed21 & seen_fused)) {
                    VSYM = 0;
                }
                seen_fused = TileLoader.seen22 & TileLoader.seen_reversed22;
                if ((TileLoader.wall22 & seen_fused) != (TileLoader.wall_reversed22 & seen_fused)) {
                    VSYM = 0;
                }
                if ((TileLoader.ruin22 & seen_fused) != (TileLoader.ruin_reversed22 & seen_fused)) {
                    VSYM = 0;
                }
                
            }
            case 19 -> {
                seen_fused = TileLoader.seen15 & TileLoader.seen_reversed15;
                if ((TileLoader.wall15 & seen_fused) != (TileLoader.wall_reversed15 & seen_fused)) {
                    VSYM = 0;
                }
                if ((TileLoader.ruin15 & seen_fused) != (TileLoader.ruin_reversed15 & seen_fused)) {
                    VSYM = 0;
                }
                seen_fused = TileLoader.seen16 & TileLoader.seen_reversed16;
                if ((TileLoader.wall16 & seen_fused) != (TileLoader.wall_reversed16 & seen_fused)) {
                    VSYM = 0;
                }
                if ((TileLoader.ruin16 & seen_fused) != (TileLoader.ruin_reversed16 & seen_fused)) {
                    VSYM = 0;
                }
                seen_fused = TileLoader.seen17 & TileLoader.seen_reversed17;
                if ((TileLoader.wall17 & seen_fused) != (TileLoader.wall_reversed17 & seen_fused)) {
                    VSYM = 0;
                }
                if ((TileLoader.ruin17 & seen_fused) != (TileLoader.ruin_reversed17 & seen_fused)) {
                    VSYM = 0;
                }
                seen_fused = TileLoader.seen18 & TileLoader.seen_reversed18;
                if ((TileLoader.wall18 & seen_fused) != (TileLoader.wall_reversed18 & seen_fused)) {
                    VSYM = 0;
                }
                if ((TileLoader.ruin18 & seen_fused) != (TileLoader.ruin_reversed18 & seen_fused)) {
                    VSYM = 0;
                }
                seen_fused = TileLoader.seen19 & TileLoader.seen_reversed19;
                if ((TileLoader.wall19 & seen_fused) != (TileLoader.wall_reversed19 & seen_fused)) {
                    VSYM = 0;
                }
                if ((TileLoader.ruin19 & seen_fused) != (TileLoader.ruin_reversed19 & seen_fused)) {
                    VSYM = 0;
                }
                seen_fused = TileLoader.seen20 & TileLoader.seen_reversed20;
                if ((TileLoader.wall20 & seen_fused) != (TileLoader.wall_reversed20 & seen_fused)) {
                    VSYM = 0;
                }
                if ((TileLoader.ruin20 & seen_fused) != (TileLoader.ruin_reversed20 & seen_fused)) {
                    VSYM = 0;
                }
                seen_fused = TileLoader.seen21 & TileLoader.seen_reversed21;
                if ((TileLoader.wall21 & seen_fused) != (TileLoader.wall_reversed21 & seen_fused)) {
                    VSYM = 0;
                }
                if ((TileLoader.ruin21 & seen_fused) != (TileLoader.ruin_reversed21 & seen_fused)) {
                    VSYM = 0;
                }
                seen_fused = TileLoader.seen22 & TileLoader.seen_reversed22;
                if ((TileLoader.wall22 & seen_fused) != (TileLoader.wall_reversed22 & seen_fused)) {
                    VSYM = 0;
                }
                if ((TileLoader.ruin22 & seen_fused) != (TileLoader.ruin_reversed22 & seen_fused)) {
                    VSYM = 0;
                }
                seen_fused = TileLoader.seen23 & TileLoader.seen_reversed23;
                if ((TileLoader.wall23 & seen_fused) != (TileLoader.wall_reversed23 & seen_fused)) {
                    VSYM = 0;
                }
                if ((TileLoader.ruin23 & seen_fused) != (TileLoader.ruin_reversed23 & seen_fused)) {
                    VSYM = 0;
                }
                
            }
            case 20 -> {
                seen_fused = TileLoader.seen16 & TileLoader.seen_reversed16;
                if ((TileLoader.wall16 & seen_fused) != (TileLoader.wall_reversed16 & seen_fused)) {
                    VSYM = 0;
                }
                if ((TileLoader.ruin16 & seen_fused) != (TileLoader.ruin_reversed16 & seen_fused)) {
                    VSYM = 0;
                }
                seen_fused = TileLoader.seen17 & TileLoader.seen_reversed17;
                if ((TileLoader.wall17 & seen_fused) != (TileLoader.wall_reversed17 & seen_fused)) {
                    VSYM = 0;
                }
                if ((TileLoader.ruin17 & seen_fused) != (TileLoader.ruin_reversed17 & seen_fused)) {
                    VSYM = 0;
                }
                seen_fused = TileLoader.seen18 & TileLoader.seen_reversed18;
                if ((TileLoader.wall18 & seen_fused) != (TileLoader.wall_reversed18 & seen_fused)) {
                    VSYM = 0;
                }
                if ((TileLoader.ruin18 & seen_fused) != (TileLoader.ruin_reversed18 & seen_fused)) {
                    VSYM = 0;
                }
                seen_fused = TileLoader.seen19 & TileLoader.seen_reversed19;
                if ((TileLoader.wall19 & seen_fused) != (TileLoader.wall_reversed19 & seen_fused)) {
                    VSYM = 0;
                }
                if ((TileLoader.ruin19 & seen_fused) != (TileLoader.ruin_reversed19 & seen_fused)) {
                    VSYM = 0;
                }
                seen_fused = TileLoader.seen20 & TileLoader.seen_reversed20;
                if ((TileLoader.wall20 & seen_fused) != (TileLoader.wall_reversed20 & seen_fused)) {
                    VSYM = 0;
                }
                if ((TileLoader.ruin20 & seen_fused) != (TileLoader.ruin_reversed20 & seen_fused)) {
                    VSYM = 0;
                }
                seen_fused = TileLoader.seen21 & TileLoader.seen_reversed21;
                if ((TileLoader.wall21 & seen_fused) != (TileLoader.wall_reversed21 & seen_fused)) {
                    VSYM = 0;
                }
                if ((TileLoader.ruin21 & seen_fused) != (TileLoader.ruin_reversed21 & seen_fused)) {
                    VSYM = 0;
                }
                seen_fused = TileLoader.seen22 & TileLoader.seen_reversed22;
                if ((TileLoader.wall22 & seen_fused) != (TileLoader.wall_reversed22 & seen_fused)) {
                    VSYM = 0;
                }
                if ((TileLoader.ruin22 & seen_fused) != (TileLoader.ruin_reversed22 & seen_fused)) {
                    VSYM = 0;
                }
                seen_fused = TileLoader.seen23 & TileLoader.seen_reversed23;
                if ((TileLoader.wall23 & seen_fused) != (TileLoader.wall_reversed23 & seen_fused)) {
                    VSYM = 0;
                }
                if ((TileLoader.ruin23 & seen_fused) != (TileLoader.ruin_reversed23 & seen_fused)) {
                    VSYM = 0;
                }
                seen_fused = TileLoader.seen24 & TileLoader.seen_reversed24;
                if ((TileLoader.wall24 & seen_fused) != (TileLoader.wall_reversed24 & seen_fused)) {
                    VSYM = 0;
                }
                if ((TileLoader.ruin24 & seen_fused) != (TileLoader.ruin_reversed24 & seen_fused)) {
                    VSYM = 0;
                }
                
            }
            case 21 -> {
                seen_fused = TileLoader.seen17 & TileLoader.seen_reversed17;
                if ((TileLoader.wall17 & seen_fused) != (TileLoader.wall_reversed17 & seen_fused)) {
                    VSYM = 0;
                }
                if ((TileLoader.ruin17 & seen_fused) != (TileLoader.ruin_reversed17 & seen_fused)) {
                    VSYM = 0;
                }
                seen_fused = TileLoader.seen18 & TileLoader.seen_reversed18;
                if ((TileLoader.wall18 & seen_fused) != (TileLoader.wall_reversed18 & seen_fused)) {
                    VSYM = 0;
                }
                if ((TileLoader.ruin18 & seen_fused) != (TileLoader.ruin_reversed18 & seen_fused)) {
                    VSYM = 0;
                }
                seen_fused = TileLoader.seen19 & TileLoader.seen_reversed19;
                if ((TileLoader.wall19 & seen_fused) != (TileLoader.wall_reversed19 & seen_fused)) {
                    VSYM = 0;
                }
                if ((TileLoader.ruin19 & seen_fused) != (TileLoader.ruin_reversed19 & seen_fused)) {
                    VSYM = 0;
                }
                seen_fused = TileLoader.seen20 & TileLoader.seen_reversed20;
                if ((TileLoader.wall20 & seen_fused) != (TileLoader.wall_reversed20 & seen_fused)) {
                    VSYM = 0;
                }
                if ((TileLoader.ruin20 & seen_fused) != (TileLoader.ruin_reversed20 & seen_fused)) {
                    VSYM = 0;
                }
                seen_fused = TileLoader.seen21 & TileLoader.seen_reversed21;
                if ((TileLoader.wall21 & seen_fused) != (TileLoader.wall_reversed21 & seen_fused)) {
                    VSYM = 0;
                }
                if ((TileLoader.ruin21 & seen_fused) != (TileLoader.ruin_reversed21 & seen_fused)) {
                    VSYM = 0;
                }
                seen_fused = TileLoader.seen22 & TileLoader.seen_reversed22;
                if ((TileLoader.wall22 & seen_fused) != (TileLoader.wall_reversed22 & seen_fused)) {
                    VSYM = 0;
                }
                if ((TileLoader.ruin22 & seen_fused) != (TileLoader.ruin_reversed22 & seen_fused)) {
                    VSYM = 0;
                }
                seen_fused = TileLoader.seen23 & TileLoader.seen_reversed23;
                if ((TileLoader.wall23 & seen_fused) != (TileLoader.wall_reversed23 & seen_fused)) {
                    VSYM = 0;
                }
                if ((TileLoader.ruin23 & seen_fused) != (TileLoader.ruin_reversed23 & seen_fused)) {
                    VSYM = 0;
                }
                seen_fused = TileLoader.seen24 & TileLoader.seen_reversed24;
                if ((TileLoader.wall24 & seen_fused) != (TileLoader.wall_reversed24 & seen_fused)) {
                    VSYM = 0;
                }
                if ((TileLoader.ruin24 & seen_fused) != (TileLoader.ruin_reversed24 & seen_fused)) {
                    VSYM = 0;
                }
                seen_fused = TileLoader.seen25 & TileLoader.seen_reversed25;
                if ((TileLoader.wall25 & seen_fused) != (TileLoader.wall_reversed25 & seen_fused)) {
                    VSYM = 0;
                }
                if ((TileLoader.ruin25 & seen_fused) != (TileLoader.ruin_reversed25 & seen_fused)) {
                    VSYM = 0;
                }
                
            }
            case 22 -> {
                seen_fused = TileLoader.seen18 & TileLoader.seen_reversed18;
                if ((TileLoader.wall18 & seen_fused) != (TileLoader.wall_reversed18 & seen_fused)) {
                    VSYM = 0;
                }
                if ((TileLoader.ruin18 & seen_fused) != (TileLoader.ruin_reversed18 & seen_fused)) {
                    VSYM = 0;
                }
                seen_fused = TileLoader.seen19 & TileLoader.seen_reversed19;
                if ((TileLoader.wall19 & seen_fused) != (TileLoader.wall_reversed19 & seen_fused)) {
                    VSYM = 0;
                }
                if ((TileLoader.ruin19 & seen_fused) != (TileLoader.ruin_reversed19 & seen_fused)) {
                    VSYM = 0;
                }
                seen_fused = TileLoader.seen20 & TileLoader.seen_reversed20;
                if ((TileLoader.wall20 & seen_fused) != (TileLoader.wall_reversed20 & seen_fused)) {
                    VSYM = 0;
                }
                if ((TileLoader.ruin20 & seen_fused) != (TileLoader.ruin_reversed20 & seen_fused)) {
                    VSYM = 0;
                }
                seen_fused = TileLoader.seen21 & TileLoader.seen_reversed21;
                if ((TileLoader.wall21 & seen_fused) != (TileLoader.wall_reversed21 & seen_fused)) {
                    VSYM = 0;
                }
                if ((TileLoader.ruin21 & seen_fused) != (TileLoader.ruin_reversed21 & seen_fused)) {
                    VSYM = 0;
                }
                seen_fused = TileLoader.seen22 & TileLoader.seen_reversed22;
                if ((TileLoader.wall22 & seen_fused) != (TileLoader.wall_reversed22 & seen_fused)) {
                    VSYM = 0;
                }
                if ((TileLoader.ruin22 & seen_fused) != (TileLoader.ruin_reversed22 & seen_fused)) {
                    VSYM = 0;
                }
                seen_fused = TileLoader.seen23 & TileLoader.seen_reversed23;
                if ((TileLoader.wall23 & seen_fused) != (TileLoader.wall_reversed23 & seen_fused)) {
                    VSYM = 0;
                }
                if ((TileLoader.ruin23 & seen_fused) != (TileLoader.ruin_reversed23 & seen_fused)) {
                    VSYM = 0;
                }
                seen_fused = TileLoader.seen24 & TileLoader.seen_reversed24;
                if ((TileLoader.wall24 & seen_fused) != (TileLoader.wall_reversed24 & seen_fused)) {
                    VSYM = 0;
                }
                if ((TileLoader.ruin24 & seen_fused) != (TileLoader.ruin_reversed24 & seen_fused)) {
                    VSYM = 0;
                }
                seen_fused = TileLoader.seen25 & TileLoader.seen_reversed25;
                if ((TileLoader.wall25 & seen_fused) != (TileLoader.wall_reversed25 & seen_fused)) {
                    VSYM = 0;
                }
                if ((TileLoader.ruin25 & seen_fused) != (TileLoader.ruin_reversed25 & seen_fused)) {
                    VSYM = 0;
                }
                seen_fused = TileLoader.seen26 & TileLoader.seen_reversed26;
                if ((TileLoader.wall26 & seen_fused) != (TileLoader.wall_reversed26 & seen_fused)) {
                    VSYM = 0;
                }
                if ((TileLoader.ruin26 & seen_fused) != (TileLoader.ruin_reversed26 & seen_fused)) {
                    VSYM = 0;
                }
                
            }
            case 23 -> {
                seen_fused = TileLoader.seen19 & TileLoader.seen_reversed19;
                if ((TileLoader.wall19 & seen_fused) != (TileLoader.wall_reversed19 & seen_fused)) {
                    VSYM = 0;
                }
                if ((TileLoader.ruin19 & seen_fused) != (TileLoader.ruin_reversed19 & seen_fused)) {
                    VSYM = 0;
                }
                seen_fused = TileLoader.seen20 & TileLoader.seen_reversed20;
                if ((TileLoader.wall20 & seen_fused) != (TileLoader.wall_reversed20 & seen_fused)) {
                    VSYM = 0;
                }
                if ((TileLoader.ruin20 & seen_fused) != (TileLoader.ruin_reversed20 & seen_fused)) {
                    VSYM = 0;
                }
                seen_fused = TileLoader.seen21 & TileLoader.seen_reversed21;
                if ((TileLoader.wall21 & seen_fused) != (TileLoader.wall_reversed21 & seen_fused)) {
                    VSYM = 0;
                }
                if ((TileLoader.ruin21 & seen_fused) != (TileLoader.ruin_reversed21 & seen_fused)) {
                    VSYM = 0;
                }
                seen_fused = TileLoader.seen22 & TileLoader.seen_reversed22;
                if ((TileLoader.wall22 & seen_fused) != (TileLoader.wall_reversed22 & seen_fused)) {
                    VSYM = 0;
                }
                if ((TileLoader.ruin22 & seen_fused) != (TileLoader.ruin_reversed22 & seen_fused)) {
                    VSYM = 0;
                }
                seen_fused = TileLoader.seen23 & TileLoader.seen_reversed23;
                if ((TileLoader.wall23 & seen_fused) != (TileLoader.wall_reversed23 & seen_fused)) {
                    VSYM = 0;
                }
                if ((TileLoader.ruin23 & seen_fused) != (TileLoader.ruin_reversed23 & seen_fused)) {
                    VSYM = 0;
                }
                seen_fused = TileLoader.seen24 & TileLoader.seen_reversed24;
                if ((TileLoader.wall24 & seen_fused) != (TileLoader.wall_reversed24 & seen_fused)) {
                    VSYM = 0;
                }
                if ((TileLoader.ruin24 & seen_fused) != (TileLoader.ruin_reversed24 & seen_fused)) {
                    VSYM = 0;
                }
                seen_fused = TileLoader.seen25 & TileLoader.seen_reversed25;
                if ((TileLoader.wall25 & seen_fused) != (TileLoader.wall_reversed25 & seen_fused)) {
                    VSYM = 0;
                }
                if ((TileLoader.ruin25 & seen_fused) != (TileLoader.ruin_reversed25 & seen_fused)) {
                    VSYM = 0;
                }
                seen_fused = TileLoader.seen26 & TileLoader.seen_reversed26;
                if ((TileLoader.wall26 & seen_fused) != (TileLoader.wall_reversed26 & seen_fused)) {
                    VSYM = 0;
                }
                if ((TileLoader.ruin26 & seen_fused) != (TileLoader.ruin_reversed26 & seen_fused)) {
                    VSYM = 0;
                }
                seen_fused = TileLoader.seen27 & TileLoader.seen_reversed27;
                if ((TileLoader.wall27 & seen_fused) != (TileLoader.wall_reversed27 & seen_fused)) {
                    VSYM = 0;
                }
                if ((TileLoader.ruin27 & seen_fused) != (TileLoader.ruin_reversed27 & seen_fused)) {
                    VSYM = 0;
                }
                
            }
            case 24 -> {
                seen_fused = TileLoader.seen20 & TileLoader.seen_reversed20;
                if ((TileLoader.wall20 & seen_fused) != (TileLoader.wall_reversed20 & seen_fused)) {
                    VSYM = 0;
                }
                if ((TileLoader.ruin20 & seen_fused) != (TileLoader.ruin_reversed20 & seen_fused)) {
                    VSYM = 0;
                }
                seen_fused = TileLoader.seen21 & TileLoader.seen_reversed21;
                if ((TileLoader.wall21 & seen_fused) != (TileLoader.wall_reversed21 & seen_fused)) {
                    VSYM = 0;
                }
                if ((TileLoader.ruin21 & seen_fused) != (TileLoader.ruin_reversed21 & seen_fused)) {
                    VSYM = 0;
                }
                seen_fused = TileLoader.seen22 & TileLoader.seen_reversed22;
                if ((TileLoader.wall22 & seen_fused) != (TileLoader.wall_reversed22 & seen_fused)) {
                    VSYM = 0;
                }
                if ((TileLoader.ruin22 & seen_fused) != (TileLoader.ruin_reversed22 & seen_fused)) {
                    VSYM = 0;
                }
                seen_fused = TileLoader.seen23 & TileLoader.seen_reversed23;
                if ((TileLoader.wall23 & seen_fused) != (TileLoader.wall_reversed23 & seen_fused)) {
                    VSYM = 0;
                }
                if ((TileLoader.ruin23 & seen_fused) != (TileLoader.ruin_reversed23 & seen_fused)) {
                    VSYM = 0;
                }
                seen_fused = TileLoader.seen24 & TileLoader.seen_reversed24;
                if ((TileLoader.wall24 & seen_fused) != (TileLoader.wall_reversed24 & seen_fused)) {
                    VSYM = 0;
                }
                if ((TileLoader.ruin24 & seen_fused) != (TileLoader.ruin_reversed24 & seen_fused)) {
                    VSYM = 0;
                }
                seen_fused = TileLoader.seen25 & TileLoader.seen_reversed25;
                if ((TileLoader.wall25 & seen_fused) != (TileLoader.wall_reversed25 & seen_fused)) {
                    VSYM = 0;
                }
                if ((TileLoader.ruin25 & seen_fused) != (TileLoader.ruin_reversed25 & seen_fused)) {
                    VSYM = 0;
                }
                seen_fused = TileLoader.seen26 & TileLoader.seen_reversed26;
                if ((TileLoader.wall26 & seen_fused) != (TileLoader.wall_reversed26 & seen_fused)) {
                    VSYM = 0;
                }
                if ((TileLoader.ruin26 & seen_fused) != (TileLoader.ruin_reversed26 & seen_fused)) {
                    VSYM = 0;
                }
                seen_fused = TileLoader.seen27 & TileLoader.seen_reversed27;
                if ((TileLoader.wall27 & seen_fused) != (TileLoader.wall_reversed27 & seen_fused)) {
                    VSYM = 0;
                }
                if ((TileLoader.ruin27 & seen_fused) != (TileLoader.ruin_reversed27 & seen_fused)) {
                    VSYM = 0;
                }
                seen_fused = TileLoader.seen28 & TileLoader.seen_reversed28;
                if ((TileLoader.wall28 & seen_fused) != (TileLoader.wall_reversed28 & seen_fused)) {
                    VSYM = 0;
                }
                if ((TileLoader.ruin28 & seen_fused) != (TileLoader.ruin_reversed28 & seen_fused)) {
                    VSYM = 0;
                }
                
            }
            case 25 -> {
                seen_fused = TileLoader.seen21 & TileLoader.seen_reversed21;
                if ((TileLoader.wall21 & seen_fused) != (TileLoader.wall_reversed21 & seen_fused)) {
                    VSYM = 0;
                }
                if ((TileLoader.ruin21 & seen_fused) != (TileLoader.ruin_reversed21 & seen_fused)) {
                    VSYM = 0;
                }
                seen_fused = TileLoader.seen22 & TileLoader.seen_reversed22;
                if ((TileLoader.wall22 & seen_fused) != (TileLoader.wall_reversed22 & seen_fused)) {
                    VSYM = 0;
                }
                if ((TileLoader.ruin22 & seen_fused) != (TileLoader.ruin_reversed22 & seen_fused)) {
                    VSYM = 0;
                }
                seen_fused = TileLoader.seen23 & TileLoader.seen_reversed23;
                if ((TileLoader.wall23 & seen_fused) != (TileLoader.wall_reversed23 & seen_fused)) {
                    VSYM = 0;
                }
                if ((TileLoader.ruin23 & seen_fused) != (TileLoader.ruin_reversed23 & seen_fused)) {
                    VSYM = 0;
                }
                seen_fused = TileLoader.seen24 & TileLoader.seen_reversed24;
                if ((TileLoader.wall24 & seen_fused) != (TileLoader.wall_reversed24 & seen_fused)) {
                    VSYM = 0;
                }
                if ((TileLoader.ruin24 & seen_fused) != (TileLoader.ruin_reversed24 & seen_fused)) {
                    VSYM = 0;
                }
                seen_fused = TileLoader.seen25 & TileLoader.seen_reversed25;
                if ((TileLoader.wall25 & seen_fused) != (TileLoader.wall_reversed25 & seen_fused)) {
                    VSYM = 0;
                }
                if ((TileLoader.ruin25 & seen_fused) != (TileLoader.ruin_reversed25 & seen_fused)) {
                    VSYM = 0;
                }
                seen_fused = TileLoader.seen26 & TileLoader.seen_reversed26;
                if ((TileLoader.wall26 & seen_fused) != (TileLoader.wall_reversed26 & seen_fused)) {
                    VSYM = 0;
                }
                if ((TileLoader.ruin26 & seen_fused) != (TileLoader.ruin_reversed26 & seen_fused)) {
                    VSYM = 0;
                }
                seen_fused = TileLoader.seen27 & TileLoader.seen_reversed27;
                if ((TileLoader.wall27 & seen_fused) != (TileLoader.wall_reversed27 & seen_fused)) {
                    VSYM = 0;
                }
                if ((TileLoader.ruin27 & seen_fused) != (TileLoader.ruin_reversed27 & seen_fused)) {
                    VSYM = 0;
                }
                seen_fused = TileLoader.seen28 & TileLoader.seen_reversed28;
                if ((TileLoader.wall28 & seen_fused) != (TileLoader.wall_reversed28 & seen_fused)) {
                    VSYM = 0;
                }
                if ((TileLoader.ruin28 & seen_fused) != (TileLoader.ruin_reversed28 & seen_fused)) {
                    VSYM = 0;
                }
                seen_fused = TileLoader.seen29 & TileLoader.seen_reversed29;
                if ((TileLoader.wall29 & seen_fused) != (TileLoader.wall_reversed29 & seen_fused)) {
                    VSYM = 0;
                }
                if ((TileLoader.ruin29 & seen_fused) != (TileLoader.ruin_reversed29 & seen_fused)) {
                    VSYM = 0;
                }
                
            }
            case 26 -> {
                seen_fused = TileLoader.seen22 & TileLoader.seen_reversed22;
                if ((TileLoader.wall22 & seen_fused) != (TileLoader.wall_reversed22 & seen_fused)) {
                    VSYM = 0;
                }
                if ((TileLoader.ruin22 & seen_fused) != (TileLoader.ruin_reversed22 & seen_fused)) {
                    VSYM = 0;
                }
                seen_fused = TileLoader.seen23 & TileLoader.seen_reversed23;
                if ((TileLoader.wall23 & seen_fused) != (TileLoader.wall_reversed23 & seen_fused)) {
                    VSYM = 0;
                }
                if ((TileLoader.ruin23 & seen_fused) != (TileLoader.ruin_reversed23 & seen_fused)) {
                    VSYM = 0;
                }
                seen_fused = TileLoader.seen24 & TileLoader.seen_reversed24;
                if ((TileLoader.wall24 & seen_fused) != (TileLoader.wall_reversed24 & seen_fused)) {
                    VSYM = 0;
                }
                if ((TileLoader.ruin24 & seen_fused) != (TileLoader.ruin_reversed24 & seen_fused)) {
                    VSYM = 0;
                }
                seen_fused = TileLoader.seen25 & TileLoader.seen_reversed25;
                if ((TileLoader.wall25 & seen_fused) != (TileLoader.wall_reversed25 & seen_fused)) {
                    VSYM = 0;
                }
                if ((TileLoader.ruin25 & seen_fused) != (TileLoader.ruin_reversed25 & seen_fused)) {
                    VSYM = 0;
                }
                seen_fused = TileLoader.seen26 & TileLoader.seen_reversed26;
                if ((TileLoader.wall26 & seen_fused) != (TileLoader.wall_reversed26 & seen_fused)) {
                    VSYM = 0;
                }
                if ((TileLoader.ruin26 & seen_fused) != (TileLoader.ruin_reversed26 & seen_fused)) {
                    VSYM = 0;
                }
                seen_fused = TileLoader.seen27 & TileLoader.seen_reversed27;
                if ((TileLoader.wall27 & seen_fused) != (TileLoader.wall_reversed27 & seen_fused)) {
                    VSYM = 0;
                }
                if ((TileLoader.ruin27 & seen_fused) != (TileLoader.ruin_reversed27 & seen_fused)) {
                    VSYM = 0;
                }
                seen_fused = TileLoader.seen28 & TileLoader.seen_reversed28;
                if ((TileLoader.wall28 & seen_fused) != (TileLoader.wall_reversed28 & seen_fused)) {
                    VSYM = 0;
                }
                if ((TileLoader.ruin28 & seen_fused) != (TileLoader.ruin_reversed28 & seen_fused)) {
                    VSYM = 0;
                }
                seen_fused = TileLoader.seen29 & TileLoader.seen_reversed29;
                if ((TileLoader.wall29 & seen_fused) != (TileLoader.wall_reversed29 & seen_fused)) {
                    VSYM = 0;
                }
                if ((TileLoader.ruin29 & seen_fused) != (TileLoader.ruin_reversed29 & seen_fused)) {
                    VSYM = 0;
                }
                seen_fused = TileLoader.seen30 & TileLoader.seen_reversed30;
                if ((TileLoader.wall30 & seen_fused) != (TileLoader.wall_reversed30 & seen_fused)) {
                    VSYM = 0;
                }
                if ((TileLoader.ruin30 & seen_fused) != (TileLoader.ruin_reversed30 & seen_fused)) {
                    VSYM = 0;
                }
                
            }
            case 27 -> {
                seen_fused = TileLoader.seen23 & TileLoader.seen_reversed23;
                if ((TileLoader.wall23 & seen_fused) != (TileLoader.wall_reversed23 & seen_fused)) {
                    VSYM = 0;
                }
                if ((TileLoader.ruin23 & seen_fused) != (TileLoader.ruin_reversed23 & seen_fused)) {
                    VSYM = 0;
                }
                seen_fused = TileLoader.seen24 & TileLoader.seen_reversed24;
                if ((TileLoader.wall24 & seen_fused) != (TileLoader.wall_reversed24 & seen_fused)) {
                    VSYM = 0;
                }
                if ((TileLoader.ruin24 & seen_fused) != (TileLoader.ruin_reversed24 & seen_fused)) {
                    VSYM = 0;
                }
                seen_fused = TileLoader.seen25 & TileLoader.seen_reversed25;
                if ((TileLoader.wall25 & seen_fused) != (TileLoader.wall_reversed25 & seen_fused)) {
                    VSYM = 0;
                }
                if ((TileLoader.ruin25 & seen_fused) != (TileLoader.ruin_reversed25 & seen_fused)) {
                    VSYM = 0;
                }
                seen_fused = TileLoader.seen26 & TileLoader.seen_reversed26;
                if ((TileLoader.wall26 & seen_fused) != (TileLoader.wall_reversed26 & seen_fused)) {
                    VSYM = 0;
                }
                if ((TileLoader.ruin26 & seen_fused) != (TileLoader.ruin_reversed26 & seen_fused)) {
                    VSYM = 0;
                }
                seen_fused = TileLoader.seen27 & TileLoader.seen_reversed27;
                if ((TileLoader.wall27 & seen_fused) != (TileLoader.wall_reversed27 & seen_fused)) {
                    VSYM = 0;
                }
                if ((TileLoader.ruin27 & seen_fused) != (TileLoader.ruin_reversed27 & seen_fused)) {
                    VSYM = 0;
                }
                seen_fused = TileLoader.seen28 & TileLoader.seen_reversed28;
                if ((TileLoader.wall28 & seen_fused) != (TileLoader.wall_reversed28 & seen_fused)) {
                    VSYM = 0;
                }
                if ((TileLoader.ruin28 & seen_fused) != (TileLoader.ruin_reversed28 & seen_fused)) {
                    VSYM = 0;
                }
                seen_fused = TileLoader.seen29 & TileLoader.seen_reversed29;
                if ((TileLoader.wall29 & seen_fused) != (TileLoader.wall_reversed29 & seen_fused)) {
                    VSYM = 0;
                }
                if ((TileLoader.ruin29 & seen_fused) != (TileLoader.ruin_reversed29 & seen_fused)) {
                    VSYM = 0;
                }
                seen_fused = TileLoader.seen30 & TileLoader.seen_reversed30;
                if ((TileLoader.wall30 & seen_fused) != (TileLoader.wall_reversed30 & seen_fused)) {
                    VSYM = 0;
                }
                if ((TileLoader.ruin30 & seen_fused) != (TileLoader.ruin_reversed30 & seen_fused)) {
                    VSYM = 0;
                }
                seen_fused = TileLoader.seen31 & TileLoader.seen_reversed31;
                if ((TileLoader.wall31 & seen_fused) != (TileLoader.wall_reversed31 & seen_fused)) {
                    VSYM = 0;
                }
                if ((TileLoader.ruin31 & seen_fused) != (TileLoader.ruin_reversed31 & seen_fused)) {
                    VSYM = 0;
                }
                
            }
            case 28 -> {
                seen_fused = TileLoader.seen24 & TileLoader.seen_reversed24;
                if ((TileLoader.wall24 & seen_fused) != (TileLoader.wall_reversed24 & seen_fused)) {
                    VSYM = 0;
                }
                if ((TileLoader.ruin24 & seen_fused) != (TileLoader.ruin_reversed24 & seen_fused)) {
                    VSYM = 0;
                }
                seen_fused = TileLoader.seen25 & TileLoader.seen_reversed25;
                if ((TileLoader.wall25 & seen_fused) != (TileLoader.wall_reversed25 & seen_fused)) {
                    VSYM = 0;
                }
                if ((TileLoader.ruin25 & seen_fused) != (TileLoader.ruin_reversed25 & seen_fused)) {
                    VSYM = 0;
                }
                seen_fused = TileLoader.seen26 & TileLoader.seen_reversed26;
                if ((TileLoader.wall26 & seen_fused) != (TileLoader.wall_reversed26 & seen_fused)) {
                    VSYM = 0;
                }
                if ((TileLoader.ruin26 & seen_fused) != (TileLoader.ruin_reversed26 & seen_fused)) {
                    VSYM = 0;
                }
                seen_fused = TileLoader.seen27 & TileLoader.seen_reversed27;
                if ((TileLoader.wall27 & seen_fused) != (TileLoader.wall_reversed27 & seen_fused)) {
                    VSYM = 0;
                }
                if ((TileLoader.ruin27 & seen_fused) != (TileLoader.ruin_reversed27 & seen_fused)) {
                    VSYM = 0;
                }
                seen_fused = TileLoader.seen28 & TileLoader.seen_reversed28;
                if ((TileLoader.wall28 & seen_fused) != (TileLoader.wall_reversed28 & seen_fused)) {
                    VSYM = 0;
                }
                if ((TileLoader.ruin28 & seen_fused) != (TileLoader.ruin_reversed28 & seen_fused)) {
                    VSYM = 0;
                }
                seen_fused = TileLoader.seen29 & TileLoader.seen_reversed29;
                if ((TileLoader.wall29 & seen_fused) != (TileLoader.wall_reversed29 & seen_fused)) {
                    VSYM = 0;
                }
                if ((TileLoader.ruin29 & seen_fused) != (TileLoader.ruin_reversed29 & seen_fused)) {
                    VSYM = 0;
                }
                seen_fused = TileLoader.seen30 & TileLoader.seen_reversed30;
                if ((TileLoader.wall30 & seen_fused) != (TileLoader.wall_reversed30 & seen_fused)) {
                    VSYM = 0;
                }
                if ((TileLoader.ruin30 & seen_fused) != (TileLoader.ruin_reversed30 & seen_fused)) {
                    VSYM = 0;
                }
                seen_fused = TileLoader.seen31 & TileLoader.seen_reversed31;
                if ((TileLoader.wall31 & seen_fused) != (TileLoader.wall_reversed31 & seen_fused)) {
                    VSYM = 0;
                }
                if ((TileLoader.ruin31 & seen_fused) != (TileLoader.ruin_reversed31 & seen_fused)) {
                    VSYM = 0;
                }
                seen_fused = TileLoader.seen32 & TileLoader.seen_reversed32;
                if ((TileLoader.wall32 & seen_fused) != (TileLoader.wall_reversed32 & seen_fused)) {
                    VSYM = 0;
                }
                if ((TileLoader.ruin32 & seen_fused) != (TileLoader.ruin_reversed32 & seen_fused)) {
                    VSYM = 0;
                }
                
            }
            case 29 -> {
                seen_fused = TileLoader.seen25 & TileLoader.seen_reversed25;
                if ((TileLoader.wall25 & seen_fused) != (TileLoader.wall_reversed25 & seen_fused)) {
                    VSYM = 0;
                }
                if ((TileLoader.ruin25 & seen_fused) != (TileLoader.ruin_reversed25 & seen_fused)) {
                    VSYM = 0;
                }
                seen_fused = TileLoader.seen26 & TileLoader.seen_reversed26;
                if ((TileLoader.wall26 & seen_fused) != (TileLoader.wall_reversed26 & seen_fused)) {
                    VSYM = 0;
                }
                if ((TileLoader.ruin26 & seen_fused) != (TileLoader.ruin_reversed26 & seen_fused)) {
                    VSYM = 0;
                }
                seen_fused = TileLoader.seen27 & TileLoader.seen_reversed27;
                if ((TileLoader.wall27 & seen_fused) != (TileLoader.wall_reversed27 & seen_fused)) {
                    VSYM = 0;
                }
                if ((TileLoader.ruin27 & seen_fused) != (TileLoader.ruin_reversed27 & seen_fused)) {
                    VSYM = 0;
                }
                seen_fused = TileLoader.seen28 & TileLoader.seen_reversed28;
                if ((TileLoader.wall28 & seen_fused) != (TileLoader.wall_reversed28 & seen_fused)) {
                    VSYM = 0;
                }
                if ((TileLoader.ruin28 & seen_fused) != (TileLoader.ruin_reversed28 & seen_fused)) {
                    VSYM = 0;
                }
                seen_fused = TileLoader.seen29 & TileLoader.seen_reversed29;
                if ((TileLoader.wall29 & seen_fused) != (TileLoader.wall_reversed29 & seen_fused)) {
                    VSYM = 0;
                }
                if ((TileLoader.ruin29 & seen_fused) != (TileLoader.ruin_reversed29 & seen_fused)) {
                    VSYM = 0;
                }
                seen_fused = TileLoader.seen30 & TileLoader.seen_reversed30;
                if ((TileLoader.wall30 & seen_fused) != (TileLoader.wall_reversed30 & seen_fused)) {
                    VSYM = 0;
                }
                if ((TileLoader.ruin30 & seen_fused) != (TileLoader.ruin_reversed30 & seen_fused)) {
                    VSYM = 0;
                }
                seen_fused = TileLoader.seen31 & TileLoader.seen_reversed31;
                if ((TileLoader.wall31 & seen_fused) != (TileLoader.wall_reversed31 & seen_fused)) {
                    VSYM = 0;
                }
                if ((TileLoader.ruin31 & seen_fused) != (TileLoader.ruin_reversed31 & seen_fused)) {
                    VSYM = 0;
                }
                seen_fused = TileLoader.seen32 & TileLoader.seen_reversed32;
                if ((TileLoader.wall32 & seen_fused) != (TileLoader.wall_reversed32 & seen_fused)) {
                    VSYM = 0;
                }
                if ((TileLoader.ruin32 & seen_fused) != (TileLoader.ruin_reversed32 & seen_fused)) {
                    VSYM = 0;
                }
                seen_fused = TileLoader.seen33 & TileLoader.seen_reversed33;
                if ((TileLoader.wall33 & seen_fused) != (TileLoader.wall_reversed33 & seen_fused)) {
                    VSYM = 0;
                }
                if ((TileLoader.ruin33 & seen_fused) != (TileLoader.ruin_reversed33 & seen_fused)) {
                    VSYM = 0;
                }
                
            }
            case 30 -> {
                seen_fused = TileLoader.seen26 & TileLoader.seen_reversed26;
                if ((TileLoader.wall26 & seen_fused) != (TileLoader.wall_reversed26 & seen_fused)) {
                    VSYM = 0;
                }
                if ((TileLoader.ruin26 & seen_fused) != (TileLoader.ruin_reversed26 & seen_fused)) {
                    VSYM = 0;
                }
                seen_fused = TileLoader.seen27 & TileLoader.seen_reversed27;
                if ((TileLoader.wall27 & seen_fused) != (TileLoader.wall_reversed27 & seen_fused)) {
                    VSYM = 0;
                }
                if ((TileLoader.ruin27 & seen_fused) != (TileLoader.ruin_reversed27 & seen_fused)) {
                    VSYM = 0;
                }
                seen_fused = TileLoader.seen28 & TileLoader.seen_reversed28;
                if ((TileLoader.wall28 & seen_fused) != (TileLoader.wall_reversed28 & seen_fused)) {
                    VSYM = 0;
                }
                if ((TileLoader.ruin28 & seen_fused) != (TileLoader.ruin_reversed28 & seen_fused)) {
                    VSYM = 0;
                }
                seen_fused = TileLoader.seen29 & TileLoader.seen_reversed29;
                if ((TileLoader.wall29 & seen_fused) != (TileLoader.wall_reversed29 & seen_fused)) {
                    VSYM = 0;
                }
                if ((TileLoader.ruin29 & seen_fused) != (TileLoader.ruin_reversed29 & seen_fused)) {
                    VSYM = 0;
                }
                seen_fused = TileLoader.seen30 & TileLoader.seen_reversed30;
                if ((TileLoader.wall30 & seen_fused) != (TileLoader.wall_reversed30 & seen_fused)) {
                    VSYM = 0;
                }
                if ((TileLoader.ruin30 & seen_fused) != (TileLoader.ruin_reversed30 & seen_fused)) {
                    VSYM = 0;
                }
                seen_fused = TileLoader.seen31 & TileLoader.seen_reversed31;
                if ((TileLoader.wall31 & seen_fused) != (TileLoader.wall_reversed31 & seen_fused)) {
                    VSYM = 0;
                }
                if ((TileLoader.ruin31 & seen_fused) != (TileLoader.ruin_reversed31 & seen_fused)) {
                    VSYM = 0;
                }
                seen_fused = TileLoader.seen32 & TileLoader.seen_reversed32;
                if ((TileLoader.wall32 & seen_fused) != (TileLoader.wall_reversed32 & seen_fused)) {
                    VSYM = 0;
                }
                if ((TileLoader.ruin32 & seen_fused) != (TileLoader.ruin_reversed32 & seen_fused)) {
                    VSYM = 0;
                }
                seen_fused = TileLoader.seen33 & TileLoader.seen_reversed33;
                if ((TileLoader.wall33 & seen_fused) != (TileLoader.wall_reversed33 & seen_fused)) {
                    VSYM = 0;
                }
                if ((TileLoader.ruin33 & seen_fused) != (TileLoader.ruin_reversed33 & seen_fused)) {
                    VSYM = 0;
                }
                seen_fused = TileLoader.seen34 & TileLoader.seen_reversed34;
                if ((TileLoader.wall34 & seen_fused) != (TileLoader.wall_reversed34 & seen_fused)) {
                    VSYM = 0;
                }
                if ((TileLoader.ruin34 & seen_fused) != (TileLoader.ruin_reversed34 & seen_fused)) {
                    VSYM = 0;
                }
                
            }
            case 31 -> {
                seen_fused = TileLoader.seen27 & TileLoader.seen_reversed27;
                if ((TileLoader.wall27 & seen_fused) != (TileLoader.wall_reversed27 & seen_fused)) {
                    VSYM = 0;
                }
                if ((TileLoader.ruin27 & seen_fused) != (TileLoader.ruin_reversed27 & seen_fused)) {
                    VSYM = 0;
                }
                seen_fused = TileLoader.seen28 & TileLoader.seen_reversed28;
                if ((TileLoader.wall28 & seen_fused) != (TileLoader.wall_reversed28 & seen_fused)) {
                    VSYM = 0;
                }
                if ((TileLoader.ruin28 & seen_fused) != (TileLoader.ruin_reversed28 & seen_fused)) {
                    VSYM = 0;
                }
                seen_fused = TileLoader.seen29 & TileLoader.seen_reversed29;
                if ((TileLoader.wall29 & seen_fused) != (TileLoader.wall_reversed29 & seen_fused)) {
                    VSYM = 0;
                }
                if ((TileLoader.ruin29 & seen_fused) != (TileLoader.ruin_reversed29 & seen_fused)) {
                    VSYM = 0;
                }
                seen_fused = TileLoader.seen30 & TileLoader.seen_reversed30;
                if ((TileLoader.wall30 & seen_fused) != (TileLoader.wall_reversed30 & seen_fused)) {
                    VSYM = 0;
                }
                if ((TileLoader.ruin30 & seen_fused) != (TileLoader.ruin_reversed30 & seen_fused)) {
                    VSYM = 0;
                }
                seen_fused = TileLoader.seen31 & TileLoader.seen_reversed31;
                if ((TileLoader.wall31 & seen_fused) != (TileLoader.wall_reversed31 & seen_fused)) {
                    VSYM = 0;
                }
                if ((TileLoader.ruin31 & seen_fused) != (TileLoader.ruin_reversed31 & seen_fused)) {
                    VSYM = 0;
                }
                seen_fused = TileLoader.seen32 & TileLoader.seen_reversed32;
                if ((TileLoader.wall32 & seen_fused) != (TileLoader.wall_reversed32 & seen_fused)) {
                    VSYM = 0;
                }
                if ((TileLoader.ruin32 & seen_fused) != (TileLoader.ruin_reversed32 & seen_fused)) {
                    VSYM = 0;
                }
                seen_fused = TileLoader.seen33 & TileLoader.seen_reversed33;
                if ((TileLoader.wall33 & seen_fused) != (TileLoader.wall_reversed33 & seen_fused)) {
                    VSYM = 0;
                }
                if ((TileLoader.ruin33 & seen_fused) != (TileLoader.ruin_reversed33 & seen_fused)) {
                    VSYM = 0;
                }
                seen_fused = TileLoader.seen34 & TileLoader.seen_reversed34;
                if ((TileLoader.wall34 & seen_fused) != (TileLoader.wall_reversed34 & seen_fused)) {
                    VSYM = 0;
                }
                if ((TileLoader.ruin34 & seen_fused) != (TileLoader.ruin_reversed34 & seen_fused)) {
                    VSYM = 0;
                }
                seen_fused = TileLoader.seen35 & TileLoader.seen_reversed35;
                if ((TileLoader.wall35 & seen_fused) != (TileLoader.wall_reversed35 & seen_fused)) {
                    VSYM = 0;
                }
                if ((TileLoader.ruin35 & seen_fused) != (TileLoader.ruin_reversed35 & seen_fused)) {
                    VSYM = 0;
                }
                
            }
            case 32 -> {
                seen_fused = TileLoader.seen28 & TileLoader.seen_reversed28;
                if ((TileLoader.wall28 & seen_fused) != (TileLoader.wall_reversed28 & seen_fused)) {
                    VSYM = 0;
                }
                if ((TileLoader.ruin28 & seen_fused) != (TileLoader.ruin_reversed28 & seen_fused)) {
                    VSYM = 0;
                }
                seen_fused = TileLoader.seen29 & TileLoader.seen_reversed29;
                if ((TileLoader.wall29 & seen_fused) != (TileLoader.wall_reversed29 & seen_fused)) {
                    VSYM = 0;
                }
                if ((TileLoader.ruin29 & seen_fused) != (TileLoader.ruin_reversed29 & seen_fused)) {
                    VSYM = 0;
                }
                seen_fused = TileLoader.seen30 & TileLoader.seen_reversed30;
                if ((TileLoader.wall30 & seen_fused) != (TileLoader.wall_reversed30 & seen_fused)) {
                    VSYM = 0;
                }
                if ((TileLoader.ruin30 & seen_fused) != (TileLoader.ruin_reversed30 & seen_fused)) {
                    VSYM = 0;
                }
                seen_fused = TileLoader.seen31 & TileLoader.seen_reversed31;
                if ((TileLoader.wall31 & seen_fused) != (TileLoader.wall_reversed31 & seen_fused)) {
                    VSYM = 0;
                }
                if ((TileLoader.ruin31 & seen_fused) != (TileLoader.ruin_reversed31 & seen_fused)) {
                    VSYM = 0;
                }
                seen_fused = TileLoader.seen32 & TileLoader.seen_reversed32;
                if ((TileLoader.wall32 & seen_fused) != (TileLoader.wall_reversed32 & seen_fused)) {
                    VSYM = 0;
                }
                if ((TileLoader.ruin32 & seen_fused) != (TileLoader.ruin_reversed32 & seen_fused)) {
                    VSYM = 0;
                }
                seen_fused = TileLoader.seen33 & TileLoader.seen_reversed33;
                if ((TileLoader.wall33 & seen_fused) != (TileLoader.wall_reversed33 & seen_fused)) {
                    VSYM = 0;
                }
                if ((TileLoader.ruin33 & seen_fused) != (TileLoader.ruin_reversed33 & seen_fused)) {
                    VSYM = 0;
                }
                seen_fused = TileLoader.seen34 & TileLoader.seen_reversed34;
                if ((TileLoader.wall34 & seen_fused) != (TileLoader.wall_reversed34 & seen_fused)) {
                    VSYM = 0;
                }
                if ((TileLoader.ruin34 & seen_fused) != (TileLoader.ruin_reversed34 & seen_fused)) {
                    VSYM = 0;
                }
                seen_fused = TileLoader.seen35 & TileLoader.seen_reversed35;
                if ((TileLoader.wall35 & seen_fused) != (TileLoader.wall_reversed35 & seen_fused)) {
                    VSYM = 0;
                }
                if ((TileLoader.ruin35 & seen_fused) != (TileLoader.ruin_reversed35 & seen_fused)) {
                    VSYM = 0;
                }
                seen_fused = TileLoader.seen36 & TileLoader.seen_reversed36;
                if ((TileLoader.wall36 & seen_fused) != (TileLoader.wall_reversed36 & seen_fused)) {
                    VSYM = 0;
                }
                if ((TileLoader.ruin36 & seen_fused) != (TileLoader.ruin_reversed36 & seen_fused)) {
                    VSYM = 0;
                }
                
            }
            case 33 -> {
                seen_fused = TileLoader.seen29 & TileLoader.seen_reversed29;
                if ((TileLoader.wall29 & seen_fused) != (TileLoader.wall_reversed29 & seen_fused)) {
                    VSYM = 0;
                }
                if ((TileLoader.ruin29 & seen_fused) != (TileLoader.ruin_reversed29 & seen_fused)) {
                    VSYM = 0;
                }
                seen_fused = TileLoader.seen30 & TileLoader.seen_reversed30;
                if ((TileLoader.wall30 & seen_fused) != (TileLoader.wall_reversed30 & seen_fused)) {
                    VSYM = 0;
                }
                if ((TileLoader.ruin30 & seen_fused) != (TileLoader.ruin_reversed30 & seen_fused)) {
                    VSYM = 0;
                }
                seen_fused = TileLoader.seen31 & TileLoader.seen_reversed31;
                if ((TileLoader.wall31 & seen_fused) != (TileLoader.wall_reversed31 & seen_fused)) {
                    VSYM = 0;
                }
                if ((TileLoader.ruin31 & seen_fused) != (TileLoader.ruin_reversed31 & seen_fused)) {
                    VSYM = 0;
                }
                seen_fused = TileLoader.seen32 & TileLoader.seen_reversed32;
                if ((TileLoader.wall32 & seen_fused) != (TileLoader.wall_reversed32 & seen_fused)) {
                    VSYM = 0;
                }
                if ((TileLoader.ruin32 & seen_fused) != (TileLoader.ruin_reversed32 & seen_fused)) {
                    VSYM = 0;
                }
                seen_fused = TileLoader.seen33 & TileLoader.seen_reversed33;
                if ((TileLoader.wall33 & seen_fused) != (TileLoader.wall_reversed33 & seen_fused)) {
                    VSYM = 0;
                }
                if ((TileLoader.ruin33 & seen_fused) != (TileLoader.ruin_reversed33 & seen_fused)) {
                    VSYM = 0;
                }
                seen_fused = TileLoader.seen34 & TileLoader.seen_reversed34;
                if ((TileLoader.wall34 & seen_fused) != (TileLoader.wall_reversed34 & seen_fused)) {
                    VSYM = 0;
                }
                if ((TileLoader.ruin34 & seen_fused) != (TileLoader.ruin_reversed34 & seen_fused)) {
                    VSYM = 0;
                }
                seen_fused = TileLoader.seen35 & TileLoader.seen_reversed35;
                if ((TileLoader.wall35 & seen_fused) != (TileLoader.wall_reversed35 & seen_fused)) {
                    VSYM = 0;
                }
                if ((TileLoader.ruin35 & seen_fused) != (TileLoader.ruin_reversed35 & seen_fused)) {
                    VSYM = 0;
                }
                seen_fused = TileLoader.seen36 & TileLoader.seen_reversed36;
                if ((TileLoader.wall36 & seen_fused) != (TileLoader.wall_reversed36 & seen_fused)) {
                    VSYM = 0;
                }
                if ((TileLoader.ruin36 & seen_fused) != (TileLoader.ruin_reversed36 & seen_fused)) {
                    VSYM = 0;
                }
                seen_fused = TileLoader.seen37 & TileLoader.seen_reversed37;
                if ((TileLoader.wall37 & seen_fused) != (TileLoader.wall_reversed37 & seen_fused)) {
                    VSYM = 0;
                }
                if ((TileLoader.ruin37 & seen_fused) != (TileLoader.ruin_reversed37 & seen_fused)) {
                    VSYM = 0;
                }
                
            }
            case 34 -> {
                seen_fused = TileLoader.seen30 & TileLoader.seen_reversed30;
                if ((TileLoader.wall30 & seen_fused) != (TileLoader.wall_reversed30 & seen_fused)) {
                    VSYM = 0;
                }
                if ((TileLoader.ruin30 & seen_fused) != (TileLoader.ruin_reversed30 & seen_fused)) {
                    VSYM = 0;
                }
                seen_fused = TileLoader.seen31 & TileLoader.seen_reversed31;
                if ((TileLoader.wall31 & seen_fused) != (TileLoader.wall_reversed31 & seen_fused)) {
                    VSYM = 0;
                }
                if ((TileLoader.ruin31 & seen_fused) != (TileLoader.ruin_reversed31 & seen_fused)) {
                    VSYM = 0;
                }
                seen_fused = TileLoader.seen32 & TileLoader.seen_reversed32;
                if ((TileLoader.wall32 & seen_fused) != (TileLoader.wall_reversed32 & seen_fused)) {
                    VSYM = 0;
                }
                if ((TileLoader.ruin32 & seen_fused) != (TileLoader.ruin_reversed32 & seen_fused)) {
                    VSYM = 0;
                }
                seen_fused = TileLoader.seen33 & TileLoader.seen_reversed33;
                if ((TileLoader.wall33 & seen_fused) != (TileLoader.wall_reversed33 & seen_fused)) {
                    VSYM = 0;
                }
                if ((TileLoader.ruin33 & seen_fused) != (TileLoader.ruin_reversed33 & seen_fused)) {
                    VSYM = 0;
                }
                seen_fused = TileLoader.seen34 & TileLoader.seen_reversed34;
                if ((TileLoader.wall34 & seen_fused) != (TileLoader.wall_reversed34 & seen_fused)) {
                    VSYM = 0;
                }
                if ((TileLoader.ruin34 & seen_fused) != (TileLoader.ruin_reversed34 & seen_fused)) {
                    VSYM = 0;
                }
                seen_fused = TileLoader.seen35 & TileLoader.seen_reversed35;
                if ((TileLoader.wall35 & seen_fused) != (TileLoader.wall_reversed35 & seen_fused)) {
                    VSYM = 0;
                }
                if ((TileLoader.ruin35 & seen_fused) != (TileLoader.ruin_reversed35 & seen_fused)) {
                    VSYM = 0;
                }
                seen_fused = TileLoader.seen36 & TileLoader.seen_reversed36;
                if ((TileLoader.wall36 & seen_fused) != (TileLoader.wall_reversed36 & seen_fused)) {
                    VSYM = 0;
                }
                if ((TileLoader.ruin36 & seen_fused) != (TileLoader.ruin_reversed36 & seen_fused)) {
                    VSYM = 0;
                }
                seen_fused = TileLoader.seen37 & TileLoader.seen_reversed37;
                if ((TileLoader.wall37 & seen_fused) != (TileLoader.wall_reversed37 & seen_fused)) {
                    VSYM = 0;
                }
                if ((TileLoader.ruin37 & seen_fused) != (TileLoader.ruin_reversed37 & seen_fused)) {
                    VSYM = 0;
                }
                seen_fused = TileLoader.seen38 & TileLoader.seen_reversed38;
                if ((TileLoader.wall38 & seen_fused) != (TileLoader.wall_reversed38 & seen_fused)) {
                    VSYM = 0;
                }
                if ((TileLoader.ruin38 & seen_fused) != (TileLoader.ruin_reversed38 & seen_fused)) {
                    VSYM = 0;
                }
                
            }
            case 35 -> {
                seen_fused = TileLoader.seen31 & TileLoader.seen_reversed31;
                if ((TileLoader.wall31 & seen_fused) != (TileLoader.wall_reversed31 & seen_fused)) {
                    VSYM = 0;
                }
                if ((TileLoader.ruin31 & seen_fused) != (TileLoader.ruin_reversed31 & seen_fused)) {
                    VSYM = 0;
                }
                seen_fused = TileLoader.seen32 & TileLoader.seen_reversed32;
                if ((TileLoader.wall32 & seen_fused) != (TileLoader.wall_reversed32 & seen_fused)) {
                    VSYM = 0;
                }
                if ((TileLoader.ruin32 & seen_fused) != (TileLoader.ruin_reversed32 & seen_fused)) {
                    VSYM = 0;
                }
                seen_fused = TileLoader.seen33 & TileLoader.seen_reversed33;
                if ((TileLoader.wall33 & seen_fused) != (TileLoader.wall_reversed33 & seen_fused)) {
                    VSYM = 0;
                }
                if ((TileLoader.ruin33 & seen_fused) != (TileLoader.ruin_reversed33 & seen_fused)) {
                    VSYM = 0;
                }
                seen_fused = TileLoader.seen34 & TileLoader.seen_reversed34;
                if ((TileLoader.wall34 & seen_fused) != (TileLoader.wall_reversed34 & seen_fused)) {
                    VSYM = 0;
                }
                if ((TileLoader.ruin34 & seen_fused) != (TileLoader.ruin_reversed34 & seen_fused)) {
                    VSYM = 0;
                }
                seen_fused = TileLoader.seen35 & TileLoader.seen_reversed35;
                if ((TileLoader.wall35 & seen_fused) != (TileLoader.wall_reversed35 & seen_fused)) {
                    VSYM = 0;
                }
                if ((TileLoader.ruin35 & seen_fused) != (TileLoader.ruin_reversed35 & seen_fused)) {
                    VSYM = 0;
                }
                seen_fused = TileLoader.seen36 & TileLoader.seen_reversed36;
                if ((TileLoader.wall36 & seen_fused) != (TileLoader.wall_reversed36 & seen_fused)) {
                    VSYM = 0;
                }
                if ((TileLoader.ruin36 & seen_fused) != (TileLoader.ruin_reversed36 & seen_fused)) {
                    VSYM = 0;
                }
                seen_fused = TileLoader.seen37 & TileLoader.seen_reversed37;
                if ((TileLoader.wall37 & seen_fused) != (TileLoader.wall_reversed37 & seen_fused)) {
                    VSYM = 0;
                }
                if ((TileLoader.ruin37 & seen_fused) != (TileLoader.ruin_reversed37 & seen_fused)) {
                    VSYM = 0;
                }
                seen_fused = TileLoader.seen38 & TileLoader.seen_reversed38;
                if ((TileLoader.wall38 & seen_fused) != (TileLoader.wall_reversed38 & seen_fused)) {
                    VSYM = 0;
                }
                if ((TileLoader.ruin38 & seen_fused) != (TileLoader.ruin_reversed38 & seen_fused)) {
                    VSYM = 0;
                }
                seen_fused = TileLoader.seen39 & TileLoader.seen_reversed39;
                if ((TileLoader.wall39 & seen_fused) != (TileLoader.wall_reversed39 & seen_fused)) {
                    VSYM = 0;
                }
                if ((TileLoader.ruin39 & seen_fused) != (TileLoader.ruin_reversed39 & seen_fused)) {
                    VSYM = 0;
                }
                
            }
            case 36 -> {
                seen_fused = TileLoader.seen32 & TileLoader.seen_reversed32;
                if ((TileLoader.wall32 & seen_fused) != (TileLoader.wall_reversed32 & seen_fused)) {
                    VSYM = 0;
                }
                if ((TileLoader.ruin32 & seen_fused) != (TileLoader.ruin_reversed32 & seen_fused)) {
                    VSYM = 0;
                }
                seen_fused = TileLoader.seen33 & TileLoader.seen_reversed33;
                if ((TileLoader.wall33 & seen_fused) != (TileLoader.wall_reversed33 & seen_fused)) {
                    VSYM = 0;
                }
                if ((TileLoader.ruin33 & seen_fused) != (TileLoader.ruin_reversed33 & seen_fused)) {
                    VSYM = 0;
                }
                seen_fused = TileLoader.seen34 & TileLoader.seen_reversed34;
                if ((TileLoader.wall34 & seen_fused) != (TileLoader.wall_reversed34 & seen_fused)) {
                    VSYM = 0;
                }
                if ((TileLoader.ruin34 & seen_fused) != (TileLoader.ruin_reversed34 & seen_fused)) {
                    VSYM = 0;
                }
                seen_fused = TileLoader.seen35 & TileLoader.seen_reversed35;
                if ((TileLoader.wall35 & seen_fused) != (TileLoader.wall_reversed35 & seen_fused)) {
                    VSYM = 0;
                }
                if ((TileLoader.ruin35 & seen_fused) != (TileLoader.ruin_reversed35 & seen_fused)) {
                    VSYM = 0;
                }
                seen_fused = TileLoader.seen36 & TileLoader.seen_reversed36;
                if ((TileLoader.wall36 & seen_fused) != (TileLoader.wall_reversed36 & seen_fused)) {
                    VSYM = 0;
                }
                if ((TileLoader.ruin36 & seen_fused) != (TileLoader.ruin_reversed36 & seen_fused)) {
                    VSYM = 0;
                }
                seen_fused = TileLoader.seen37 & TileLoader.seen_reversed37;
                if ((TileLoader.wall37 & seen_fused) != (TileLoader.wall_reversed37 & seen_fused)) {
                    VSYM = 0;
                }
                if ((TileLoader.ruin37 & seen_fused) != (TileLoader.ruin_reversed37 & seen_fused)) {
                    VSYM = 0;
                }
                seen_fused = TileLoader.seen38 & TileLoader.seen_reversed38;
                if ((TileLoader.wall38 & seen_fused) != (TileLoader.wall_reversed38 & seen_fused)) {
                    VSYM = 0;
                }
                if ((TileLoader.ruin38 & seen_fused) != (TileLoader.ruin_reversed38 & seen_fused)) {
                    VSYM = 0;
                }
                seen_fused = TileLoader.seen39 & TileLoader.seen_reversed39;
                if ((TileLoader.wall39 & seen_fused) != (TileLoader.wall_reversed39 & seen_fused)) {
                    VSYM = 0;
                }
                if ((TileLoader.ruin39 & seen_fused) != (TileLoader.ruin_reversed39 & seen_fused)) {
                    VSYM = 0;
                }
                seen_fused = TileLoader.seen40 & TileLoader.seen_reversed40;
                if ((TileLoader.wall40 & seen_fused) != (TileLoader.wall_reversed40 & seen_fused)) {
                    VSYM = 0;
                }
                if ((TileLoader.ruin40 & seen_fused) != (TileLoader.ruin_reversed40 & seen_fused)) {
                    VSYM = 0;
                }
                
            }
            case 37 -> {
                seen_fused = TileLoader.seen33 & TileLoader.seen_reversed33;
                if ((TileLoader.wall33 & seen_fused) != (TileLoader.wall_reversed33 & seen_fused)) {
                    VSYM = 0;
                }
                if ((TileLoader.ruin33 & seen_fused) != (TileLoader.ruin_reversed33 & seen_fused)) {
                    VSYM = 0;
                }
                seen_fused = TileLoader.seen34 & TileLoader.seen_reversed34;
                if ((TileLoader.wall34 & seen_fused) != (TileLoader.wall_reversed34 & seen_fused)) {
                    VSYM = 0;
                }
                if ((TileLoader.ruin34 & seen_fused) != (TileLoader.ruin_reversed34 & seen_fused)) {
                    VSYM = 0;
                }
                seen_fused = TileLoader.seen35 & TileLoader.seen_reversed35;
                if ((TileLoader.wall35 & seen_fused) != (TileLoader.wall_reversed35 & seen_fused)) {
                    VSYM = 0;
                }
                if ((TileLoader.ruin35 & seen_fused) != (TileLoader.ruin_reversed35 & seen_fused)) {
                    VSYM = 0;
                }
                seen_fused = TileLoader.seen36 & TileLoader.seen_reversed36;
                if ((TileLoader.wall36 & seen_fused) != (TileLoader.wall_reversed36 & seen_fused)) {
                    VSYM = 0;
                }
                if ((TileLoader.ruin36 & seen_fused) != (TileLoader.ruin_reversed36 & seen_fused)) {
                    VSYM = 0;
                }
                seen_fused = TileLoader.seen37 & TileLoader.seen_reversed37;
                if ((TileLoader.wall37 & seen_fused) != (TileLoader.wall_reversed37 & seen_fused)) {
                    VSYM = 0;
                }
                if ((TileLoader.ruin37 & seen_fused) != (TileLoader.ruin_reversed37 & seen_fused)) {
                    VSYM = 0;
                }
                seen_fused = TileLoader.seen38 & TileLoader.seen_reversed38;
                if ((TileLoader.wall38 & seen_fused) != (TileLoader.wall_reversed38 & seen_fused)) {
                    VSYM = 0;
                }
                if ((TileLoader.ruin38 & seen_fused) != (TileLoader.ruin_reversed38 & seen_fused)) {
                    VSYM = 0;
                }
                seen_fused = TileLoader.seen39 & TileLoader.seen_reversed39;
                if ((TileLoader.wall39 & seen_fused) != (TileLoader.wall_reversed39 & seen_fused)) {
                    VSYM = 0;
                }
                if ((TileLoader.ruin39 & seen_fused) != (TileLoader.ruin_reversed39 & seen_fused)) {
                    VSYM = 0;
                }
                seen_fused = TileLoader.seen40 & TileLoader.seen_reversed40;
                if ((TileLoader.wall40 & seen_fused) != (TileLoader.wall_reversed40 & seen_fused)) {
                    VSYM = 0;
                }
                if ((TileLoader.ruin40 & seen_fused) != (TileLoader.ruin_reversed40 & seen_fused)) {
                    VSYM = 0;
                }
                seen_fused = TileLoader.seen41 & TileLoader.seen_reversed41;
                if ((TileLoader.wall41 & seen_fused) != (TileLoader.wall_reversed41 & seen_fused)) {
                    VSYM = 0;
                }
                if ((TileLoader.ruin41 & seen_fused) != (TileLoader.ruin_reversed41 & seen_fused)) {
                    VSYM = 0;
                }
                
            }
            case 38 -> {
                seen_fused = TileLoader.seen34 & TileLoader.seen_reversed34;
                if ((TileLoader.wall34 & seen_fused) != (TileLoader.wall_reversed34 & seen_fused)) {
                    VSYM = 0;
                }
                if ((TileLoader.ruin34 & seen_fused) != (TileLoader.ruin_reversed34 & seen_fused)) {
                    VSYM = 0;
                }
                seen_fused = TileLoader.seen35 & TileLoader.seen_reversed35;
                if ((TileLoader.wall35 & seen_fused) != (TileLoader.wall_reversed35 & seen_fused)) {
                    VSYM = 0;
                }
                if ((TileLoader.ruin35 & seen_fused) != (TileLoader.ruin_reversed35 & seen_fused)) {
                    VSYM = 0;
                }
                seen_fused = TileLoader.seen36 & TileLoader.seen_reversed36;
                if ((TileLoader.wall36 & seen_fused) != (TileLoader.wall_reversed36 & seen_fused)) {
                    VSYM = 0;
                }
                if ((TileLoader.ruin36 & seen_fused) != (TileLoader.ruin_reversed36 & seen_fused)) {
                    VSYM = 0;
                }
                seen_fused = TileLoader.seen37 & TileLoader.seen_reversed37;
                if ((TileLoader.wall37 & seen_fused) != (TileLoader.wall_reversed37 & seen_fused)) {
                    VSYM = 0;
                }
                if ((TileLoader.ruin37 & seen_fused) != (TileLoader.ruin_reversed37 & seen_fused)) {
                    VSYM = 0;
                }
                seen_fused = TileLoader.seen38 & TileLoader.seen_reversed38;
                if ((TileLoader.wall38 & seen_fused) != (TileLoader.wall_reversed38 & seen_fused)) {
                    VSYM = 0;
                }
                if ((TileLoader.ruin38 & seen_fused) != (TileLoader.ruin_reversed38 & seen_fused)) {
                    VSYM = 0;
                }
                seen_fused = TileLoader.seen39 & TileLoader.seen_reversed39;
                if ((TileLoader.wall39 & seen_fused) != (TileLoader.wall_reversed39 & seen_fused)) {
                    VSYM = 0;
                }
                if ((TileLoader.ruin39 & seen_fused) != (TileLoader.ruin_reversed39 & seen_fused)) {
                    VSYM = 0;
                }
                seen_fused = TileLoader.seen40 & TileLoader.seen_reversed40;
                if ((TileLoader.wall40 & seen_fused) != (TileLoader.wall_reversed40 & seen_fused)) {
                    VSYM = 0;
                }
                if ((TileLoader.ruin40 & seen_fused) != (TileLoader.ruin_reversed40 & seen_fused)) {
                    VSYM = 0;
                }
                seen_fused = TileLoader.seen41 & TileLoader.seen_reversed41;
                if ((TileLoader.wall41 & seen_fused) != (TileLoader.wall_reversed41 & seen_fused)) {
                    VSYM = 0;
                }
                if ((TileLoader.ruin41 & seen_fused) != (TileLoader.ruin_reversed41 & seen_fused)) {
                    VSYM = 0;
                }
                seen_fused = TileLoader.seen42 & TileLoader.seen_reversed42;
                if ((TileLoader.wall42 & seen_fused) != (TileLoader.wall_reversed42 & seen_fused)) {
                    VSYM = 0;
                }
                if ((TileLoader.ruin42 & seen_fused) != (TileLoader.ruin_reversed42 & seen_fused)) {
                    VSYM = 0;
                }
                
            }
            case 39 -> {
                seen_fused = TileLoader.seen35 & TileLoader.seen_reversed35;
                if ((TileLoader.wall35 & seen_fused) != (TileLoader.wall_reversed35 & seen_fused)) {
                    VSYM = 0;
                }
                if ((TileLoader.ruin35 & seen_fused) != (TileLoader.ruin_reversed35 & seen_fused)) {
                    VSYM = 0;
                }
                seen_fused = TileLoader.seen36 & TileLoader.seen_reversed36;
                if ((TileLoader.wall36 & seen_fused) != (TileLoader.wall_reversed36 & seen_fused)) {
                    VSYM = 0;
                }
                if ((TileLoader.ruin36 & seen_fused) != (TileLoader.ruin_reversed36 & seen_fused)) {
                    VSYM = 0;
                }
                seen_fused = TileLoader.seen37 & TileLoader.seen_reversed37;
                if ((TileLoader.wall37 & seen_fused) != (TileLoader.wall_reversed37 & seen_fused)) {
                    VSYM = 0;
                }
                if ((TileLoader.ruin37 & seen_fused) != (TileLoader.ruin_reversed37 & seen_fused)) {
                    VSYM = 0;
                }
                seen_fused = TileLoader.seen38 & TileLoader.seen_reversed38;
                if ((TileLoader.wall38 & seen_fused) != (TileLoader.wall_reversed38 & seen_fused)) {
                    VSYM = 0;
                }
                if ((TileLoader.ruin38 & seen_fused) != (TileLoader.ruin_reversed38 & seen_fused)) {
                    VSYM = 0;
                }
                seen_fused = TileLoader.seen39 & TileLoader.seen_reversed39;
                if ((TileLoader.wall39 & seen_fused) != (TileLoader.wall_reversed39 & seen_fused)) {
                    VSYM = 0;
                }
                if ((TileLoader.ruin39 & seen_fused) != (TileLoader.ruin_reversed39 & seen_fused)) {
                    VSYM = 0;
                }
                seen_fused = TileLoader.seen40 & TileLoader.seen_reversed40;
                if ((TileLoader.wall40 & seen_fused) != (TileLoader.wall_reversed40 & seen_fused)) {
                    VSYM = 0;
                }
                if ((TileLoader.ruin40 & seen_fused) != (TileLoader.ruin_reversed40 & seen_fused)) {
                    VSYM = 0;
                }
                seen_fused = TileLoader.seen41 & TileLoader.seen_reversed41;
                if ((TileLoader.wall41 & seen_fused) != (TileLoader.wall_reversed41 & seen_fused)) {
                    VSYM = 0;
                }
                if ((TileLoader.ruin41 & seen_fused) != (TileLoader.ruin_reversed41 & seen_fused)) {
                    VSYM = 0;
                }
                seen_fused = TileLoader.seen42 & TileLoader.seen_reversed42;
                if ((TileLoader.wall42 & seen_fused) != (TileLoader.wall_reversed42 & seen_fused)) {
                    VSYM = 0;
                }
                if ((TileLoader.ruin42 & seen_fused) != (TileLoader.ruin_reversed42 & seen_fused)) {
                    VSYM = 0;
                }
                seen_fused = TileLoader.seen43 & TileLoader.seen_reversed43;
                if ((TileLoader.wall43 & seen_fused) != (TileLoader.wall_reversed43 & seen_fused)) {
                    VSYM = 0;
                }
                if ((TileLoader.ruin43 & seen_fused) != (TileLoader.ruin_reversed43 & seen_fused)) {
                    VSYM = 0;
                }
                
            }
            case 40 -> {
                seen_fused = TileLoader.seen36 & TileLoader.seen_reversed36;
                if ((TileLoader.wall36 & seen_fused) != (TileLoader.wall_reversed36 & seen_fused)) {
                    VSYM = 0;
                }
                if ((TileLoader.ruin36 & seen_fused) != (TileLoader.ruin_reversed36 & seen_fused)) {
                    VSYM = 0;
                }
                seen_fused = TileLoader.seen37 & TileLoader.seen_reversed37;
                if ((TileLoader.wall37 & seen_fused) != (TileLoader.wall_reversed37 & seen_fused)) {
                    VSYM = 0;
                }
                if ((TileLoader.ruin37 & seen_fused) != (TileLoader.ruin_reversed37 & seen_fused)) {
                    VSYM = 0;
                }
                seen_fused = TileLoader.seen38 & TileLoader.seen_reversed38;
                if ((TileLoader.wall38 & seen_fused) != (TileLoader.wall_reversed38 & seen_fused)) {
                    VSYM = 0;
                }
                if ((TileLoader.ruin38 & seen_fused) != (TileLoader.ruin_reversed38 & seen_fused)) {
                    VSYM = 0;
                }
                seen_fused = TileLoader.seen39 & TileLoader.seen_reversed39;
                if ((TileLoader.wall39 & seen_fused) != (TileLoader.wall_reversed39 & seen_fused)) {
                    VSYM = 0;
                }
                if ((TileLoader.ruin39 & seen_fused) != (TileLoader.ruin_reversed39 & seen_fused)) {
                    VSYM = 0;
                }
                seen_fused = TileLoader.seen40 & TileLoader.seen_reversed40;
                if ((TileLoader.wall40 & seen_fused) != (TileLoader.wall_reversed40 & seen_fused)) {
                    VSYM = 0;
                }
                if ((TileLoader.ruin40 & seen_fused) != (TileLoader.ruin_reversed40 & seen_fused)) {
                    VSYM = 0;
                }
                seen_fused = TileLoader.seen41 & TileLoader.seen_reversed41;
                if ((TileLoader.wall41 & seen_fused) != (TileLoader.wall_reversed41 & seen_fused)) {
                    VSYM = 0;
                }
                if ((TileLoader.ruin41 & seen_fused) != (TileLoader.ruin_reversed41 & seen_fused)) {
                    VSYM = 0;
                }
                seen_fused = TileLoader.seen42 & TileLoader.seen_reversed42;
                if ((TileLoader.wall42 & seen_fused) != (TileLoader.wall_reversed42 & seen_fused)) {
                    VSYM = 0;
                }
                if ((TileLoader.ruin42 & seen_fused) != (TileLoader.ruin_reversed42 & seen_fused)) {
                    VSYM = 0;
                }
                seen_fused = TileLoader.seen43 & TileLoader.seen_reversed43;
                if ((TileLoader.wall43 & seen_fused) != (TileLoader.wall_reversed43 & seen_fused)) {
                    VSYM = 0;
                }
                if ((TileLoader.ruin43 & seen_fused) != (TileLoader.ruin_reversed43 & seen_fused)) {
                    VSYM = 0;
                }
                seen_fused = TileLoader.seen44 & TileLoader.seen_reversed44;
                if ((TileLoader.wall44 & seen_fused) != (TileLoader.wall_reversed44 & seen_fused)) {
                    VSYM = 0;
                }
                if ((TileLoader.ruin44 & seen_fused) != (TileLoader.ruin_reversed44 & seen_fused)) {
                    VSYM = 0;
                }
                
            }
            case 41 -> {
                seen_fused = TileLoader.seen37 & TileLoader.seen_reversed37;
                if ((TileLoader.wall37 & seen_fused) != (TileLoader.wall_reversed37 & seen_fused)) {
                    VSYM = 0;
                }
                if ((TileLoader.ruin37 & seen_fused) != (TileLoader.ruin_reversed37 & seen_fused)) {
                    VSYM = 0;
                }
                seen_fused = TileLoader.seen38 & TileLoader.seen_reversed38;
                if ((TileLoader.wall38 & seen_fused) != (TileLoader.wall_reversed38 & seen_fused)) {
                    VSYM = 0;
                }
                if ((TileLoader.ruin38 & seen_fused) != (TileLoader.ruin_reversed38 & seen_fused)) {
                    VSYM = 0;
                }
                seen_fused = TileLoader.seen39 & TileLoader.seen_reversed39;
                if ((TileLoader.wall39 & seen_fused) != (TileLoader.wall_reversed39 & seen_fused)) {
                    VSYM = 0;
                }
                if ((TileLoader.ruin39 & seen_fused) != (TileLoader.ruin_reversed39 & seen_fused)) {
                    VSYM = 0;
                }
                seen_fused = TileLoader.seen40 & TileLoader.seen_reversed40;
                if ((TileLoader.wall40 & seen_fused) != (TileLoader.wall_reversed40 & seen_fused)) {
                    VSYM = 0;
                }
                if ((TileLoader.ruin40 & seen_fused) != (TileLoader.ruin_reversed40 & seen_fused)) {
                    VSYM = 0;
                }
                seen_fused = TileLoader.seen41 & TileLoader.seen_reversed41;
                if ((TileLoader.wall41 & seen_fused) != (TileLoader.wall_reversed41 & seen_fused)) {
                    VSYM = 0;
                }
                if ((TileLoader.ruin41 & seen_fused) != (TileLoader.ruin_reversed41 & seen_fused)) {
                    VSYM = 0;
                }
                seen_fused = TileLoader.seen42 & TileLoader.seen_reversed42;
                if ((TileLoader.wall42 & seen_fused) != (TileLoader.wall_reversed42 & seen_fused)) {
                    VSYM = 0;
                }
                if ((TileLoader.ruin42 & seen_fused) != (TileLoader.ruin_reversed42 & seen_fused)) {
                    VSYM = 0;
                }
                seen_fused = TileLoader.seen43 & TileLoader.seen_reversed43;
                if ((TileLoader.wall43 & seen_fused) != (TileLoader.wall_reversed43 & seen_fused)) {
                    VSYM = 0;
                }
                if ((TileLoader.ruin43 & seen_fused) != (TileLoader.ruin_reversed43 & seen_fused)) {
                    VSYM = 0;
                }
                seen_fused = TileLoader.seen44 & TileLoader.seen_reversed44;
                if ((TileLoader.wall44 & seen_fused) != (TileLoader.wall_reversed44 & seen_fused)) {
                    VSYM = 0;
                }
                if ((TileLoader.ruin44 & seen_fused) != (TileLoader.ruin_reversed44 & seen_fused)) {
                    VSYM = 0;
                }
                seen_fused = TileLoader.seen45 & TileLoader.seen_reversed45;
                if ((TileLoader.wall45 & seen_fused) != (TileLoader.wall_reversed45 & seen_fused)) {
                    VSYM = 0;
                }
                if ((TileLoader.ruin45 & seen_fused) != (TileLoader.ruin_reversed45 & seen_fused)) {
                    VSYM = 0;
                }
                
            }
            case 42 -> {
                seen_fused = TileLoader.seen38 & TileLoader.seen_reversed38;
                if ((TileLoader.wall38 & seen_fused) != (TileLoader.wall_reversed38 & seen_fused)) {
                    VSYM = 0;
                }
                if ((TileLoader.ruin38 & seen_fused) != (TileLoader.ruin_reversed38 & seen_fused)) {
                    VSYM = 0;
                }
                seen_fused = TileLoader.seen39 & TileLoader.seen_reversed39;
                if ((TileLoader.wall39 & seen_fused) != (TileLoader.wall_reversed39 & seen_fused)) {
                    VSYM = 0;
                }
                if ((TileLoader.ruin39 & seen_fused) != (TileLoader.ruin_reversed39 & seen_fused)) {
                    VSYM = 0;
                }
                seen_fused = TileLoader.seen40 & TileLoader.seen_reversed40;
                if ((TileLoader.wall40 & seen_fused) != (TileLoader.wall_reversed40 & seen_fused)) {
                    VSYM = 0;
                }
                if ((TileLoader.ruin40 & seen_fused) != (TileLoader.ruin_reversed40 & seen_fused)) {
                    VSYM = 0;
                }
                seen_fused = TileLoader.seen41 & TileLoader.seen_reversed41;
                if ((TileLoader.wall41 & seen_fused) != (TileLoader.wall_reversed41 & seen_fused)) {
                    VSYM = 0;
                }
                if ((TileLoader.ruin41 & seen_fused) != (TileLoader.ruin_reversed41 & seen_fused)) {
                    VSYM = 0;
                }
                seen_fused = TileLoader.seen42 & TileLoader.seen_reversed42;
                if ((TileLoader.wall42 & seen_fused) != (TileLoader.wall_reversed42 & seen_fused)) {
                    VSYM = 0;
                }
                if ((TileLoader.ruin42 & seen_fused) != (TileLoader.ruin_reversed42 & seen_fused)) {
                    VSYM = 0;
                }
                seen_fused = TileLoader.seen43 & TileLoader.seen_reversed43;
                if ((TileLoader.wall43 & seen_fused) != (TileLoader.wall_reversed43 & seen_fused)) {
                    VSYM = 0;
                }
                if ((TileLoader.ruin43 & seen_fused) != (TileLoader.ruin_reversed43 & seen_fused)) {
                    VSYM = 0;
                }
                seen_fused = TileLoader.seen44 & TileLoader.seen_reversed44;
                if ((TileLoader.wall44 & seen_fused) != (TileLoader.wall_reversed44 & seen_fused)) {
                    VSYM = 0;
                }
                if ((TileLoader.ruin44 & seen_fused) != (TileLoader.ruin_reversed44 & seen_fused)) {
                    VSYM = 0;
                }
                seen_fused = TileLoader.seen45 & TileLoader.seen_reversed45;
                if ((TileLoader.wall45 & seen_fused) != (TileLoader.wall_reversed45 & seen_fused)) {
                    VSYM = 0;
                }
                if ((TileLoader.ruin45 & seen_fused) != (TileLoader.ruin_reversed45 & seen_fused)) {
                    VSYM = 0;
                }
                seen_fused = TileLoader.seen46 & TileLoader.seen_reversed46;
                if ((TileLoader.wall46 & seen_fused) != (TileLoader.wall_reversed46 & seen_fused)) {
                    VSYM = 0;
                }
                if ((TileLoader.ruin46 & seen_fused) != (TileLoader.ruin_reversed46 & seen_fused)) {
                    VSYM = 0;
                }
                
            }
            case 43 -> {
                seen_fused = TileLoader.seen39 & TileLoader.seen_reversed39;
                if ((TileLoader.wall39 & seen_fused) != (TileLoader.wall_reversed39 & seen_fused)) {
                    VSYM = 0;
                }
                if ((TileLoader.ruin39 & seen_fused) != (TileLoader.ruin_reversed39 & seen_fused)) {
                    VSYM = 0;
                }
                seen_fused = TileLoader.seen40 & TileLoader.seen_reversed40;
                if ((TileLoader.wall40 & seen_fused) != (TileLoader.wall_reversed40 & seen_fused)) {
                    VSYM = 0;
                }
                if ((TileLoader.ruin40 & seen_fused) != (TileLoader.ruin_reversed40 & seen_fused)) {
                    VSYM = 0;
                }
                seen_fused = TileLoader.seen41 & TileLoader.seen_reversed41;
                if ((TileLoader.wall41 & seen_fused) != (TileLoader.wall_reversed41 & seen_fused)) {
                    VSYM = 0;
                }
                if ((TileLoader.ruin41 & seen_fused) != (TileLoader.ruin_reversed41 & seen_fused)) {
                    VSYM = 0;
                }
                seen_fused = TileLoader.seen42 & TileLoader.seen_reversed42;
                if ((TileLoader.wall42 & seen_fused) != (TileLoader.wall_reversed42 & seen_fused)) {
                    VSYM = 0;
                }
                if ((TileLoader.ruin42 & seen_fused) != (TileLoader.ruin_reversed42 & seen_fused)) {
                    VSYM = 0;
                }
                seen_fused = TileLoader.seen43 & TileLoader.seen_reversed43;
                if ((TileLoader.wall43 & seen_fused) != (TileLoader.wall_reversed43 & seen_fused)) {
                    VSYM = 0;
                }
                if ((TileLoader.ruin43 & seen_fused) != (TileLoader.ruin_reversed43 & seen_fused)) {
                    VSYM = 0;
                }
                seen_fused = TileLoader.seen44 & TileLoader.seen_reversed44;
                if ((TileLoader.wall44 & seen_fused) != (TileLoader.wall_reversed44 & seen_fused)) {
                    VSYM = 0;
                }
                if ((TileLoader.ruin44 & seen_fused) != (TileLoader.ruin_reversed44 & seen_fused)) {
                    VSYM = 0;
                }
                seen_fused = TileLoader.seen45 & TileLoader.seen_reversed45;
                if ((TileLoader.wall45 & seen_fused) != (TileLoader.wall_reversed45 & seen_fused)) {
                    VSYM = 0;
                }
                if ((TileLoader.ruin45 & seen_fused) != (TileLoader.ruin_reversed45 & seen_fused)) {
                    VSYM = 0;
                }
                seen_fused = TileLoader.seen46 & TileLoader.seen_reversed46;
                if ((TileLoader.wall46 & seen_fused) != (TileLoader.wall_reversed46 & seen_fused)) {
                    VSYM = 0;
                }
                if ((TileLoader.ruin46 & seen_fused) != (TileLoader.ruin_reversed46 & seen_fused)) {
                    VSYM = 0;
                }
                seen_fused = TileLoader.seen47 & TileLoader.seen_reversed47;
                if ((TileLoader.wall47 & seen_fused) != (TileLoader.wall_reversed47 & seen_fused)) {
                    VSYM = 0;
                }
                if ((TileLoader.ruin47 & seen_fused) != (TileLoader.ruin_reversed47 & seen_fused)) {
                    VSYM = 0;
                }
                
            }
            case 44 -> {
                seen_fused = TileLoader.seen40 & TileLoader.seen_reversed40;
                if ((TileLoader.wall40 & seen_fused) != (TileLoader.wall_reversed40 & seen_fused)) {
                    VSYM = 0;
                }
                if ((TileLoader.ruin40 & seen_fused) != (TileLoader.ruin_reversed40 & seen_fused)) {
                    VSYM = 0;
                }
                seen_fused = TileLoader.seen41 & TileLoader.seen_reversed41;
                if ((TileLoader.wall41 & seen_fused) != (TileLoader.wall_reversed41 & seen_fused)) {
                    VSYM = 0;
                }
                if ((TileLoader.ruin41 & seen_fused) != (TileLoader.ruin_reversed41 & seen_fused)) {
                    VSYM = 0;
                }
                seen_fused = TileLoader.seen42 & TileLoader.seen_reversed42;
                if ((TileLoader.wall42 & seen_fused) != (TileLoader.wall_reversed42 & seen_fused)) {
                    VSYM = 0;
                }
                if ((TileLoader.ruin42 & seen_fused) != (TileLoader.ruin_reversed42 & seen_fused)) {
                    VSYM = 0;
                }
                seen_fused = TileLoader.seen43 & TileLoader.seen_reversed43;
                if ((TileLoader.wall43 & seen_fused) != (TileLoader.wall_reversed43 & seen_fused)) {
                    VSYM = 0;
                }
                if ((TileLoader.ruin43 & seen_fused) != (TileLoader.ruin_reversed43 & seen_fused)) {
                    VSYM = 0;
                }
                seen_fused = TileLoader.seen44 & TileLoader.seen_reversed44;
                if ((TileLoader.wall44 & seen_fused) != (TileLoader.wall_reversed44 & seen_fused)) {
                    VSYM = 0;
                }
                if ((TileLoader.ruin44 & seen_fused) != (TileLoader.ruin_reversed44 & seen_fused)) {
                    VSYM = 0;
                }
                seen_fused = TileLoader.seen45 & TileLoader.seen_reversed45;
                if ((TileLoader.wall45 & seen_fused) != (TileLoader.wall_reversed45 & seen_fused)) {
                    VSYM = 0;
                }
                if ((TileLoader.ruin45 & seen_fused) != (TileLoader.ruin_reversed45 & seen_fused)) {
                    VSYM = 0;
                }
                seen_fused = TileLoader.seen46 & TileLoader.seen_reversed46;
                if ((TileLoader.wall46 & seen_fused) != (TileLoader.wall_reversed46 & seen_fused)) {
                    VSYM = 0;
                }
                if ((TileLoader.ruin46 & seen_fused) != (TileLoader.ruin_reversed46 & seen_fused)) {
                    VSYM = 0;
                }
                seen_fused = TileLoader.seen47 & TileLoader.seen_reversed47;
                if ((TileLoader.wall47 & seen_fused) != (TileLoader.wall_reversed47 & seen_fused)) {
                    VSYM = 0;
                }
                if ((TileLoader.ruin47 & seen_fused) != (TileLoader.ruin_reversed47 & seen_fused)) {
                    VSYM = 0;
                }
                seen_fused = TileLoader.seen48 & TileLoader.seen_reversed48;
                if ((TileLoader.wall48 & seen_fused) != (TileLoader.wall_reversed48 & seen_fused)) {
                    VSYM = 0;
                }
                if ((TileLoader.ruin48 & seen_fused) != (TileLoader.ruin_reversed48 & seen_fused)) {
                    VSYM = 0;
                }
                
            }
            case 45 -> {
                seen_fused = TileLoader.seen41 & TileLoader.seen_reversed41;
                if ((TileLoader.wall41 & seen_fused) != (TileLoader.wall_reversed41 & seen_fused)) {
                    VSYM = 0;
                }
                if ((TileLoader.ruin41 & seen_fused) != (TileLoader.ruin_reversed41 & seen_fused)) {
                    VSYM = 0;
                }
                seen_fused = TileLoader.seen42 & TileLoader.seen_reversed42;
                if ((TileLoader.wall42 & seen_fused) != (TileLoader.wall_reversed42 & seen_fused)) {
                    VSYM = 0;
                }
                if ((TileLoader.ruin42 & seen_fused) != (TileLoader.ruin_reversed42 & seen_fused)) {
                    VSYM = 0;
                }
                seen_fused = TileLoader.seen43 & TileLoader.seen_reversed43;
                if ((TileLoader.wall43 & seen_fused) != (TileLoader.wall_reversed43 & seen_fused)) {
                    VSYM = 0;
                }
                if ((TileLoader.ruin43 & seen_fused) != (TileLoader.ruin_reversed43 & seen_fused)) {
                    VSYM = 0;
                }
                seen_fused = TileLoader.seen44 & TileLoader.seen_reversed44;
                if ((TileLoader.wall44 & seen_fused) != (TileLoader.wall_reversed44 & seen_fused)) {
                    VSYM = 0;
                }
                if ((TileLoader.ruin44 & seen_fused) != (TileLoader.ruin_reversed44 & seen_fused)) {
                    VSYM = 0;
                }
                seen_fused = TileLoader.seen45 & TileLoader.seen_reversed45;
                if ((TileLoader.wall45 & seen_fused) != (TileLoader.wall_reversed45 & seen_fused)) {
                    VSYM = 0;
                }
                if ((TileLoader.ruin45 & seen_fused) != (TileLoader.ruin_reversed45 & seen_fused)) {
                    VSYM = 0;
                }
                seen_fused = TileLoader.seen46 & TileLoader.seen_reversed46;
                if ((TileLoader.wall46 & seen_fused) != (TileLoader.wall_reversed46 & seen_fused)) {
                    VSYM = 0;
                }
                if ((TileLoader.ruin46 & seen_fused) != (TileLoader.ruin_reversed46 & seen_fused)) {
                    VSYM = 0;
                }
                seen_fused = TileLoader.seen47 & TileLoader.seen_reversed47;
                if ((TileLoader.wall47 & seen_fused) != (TileLoader.wall_reversed47 & seen_fused)) {
                    VSYM = 0;
                }
                if ((TileLoader.ruin47 & seen_fused) != (TileLoader.ruin_reversed47 & seen_fused)) {
                    VSYM = 0;
                }
                seen_fused = TileLoader.seen48 & TileLoader.seen_reversed48;
                if ((TileLoader.wall48 & seen_fused) != (TileLoader.wall_reversed48 & seen_fused)) {
                    VSYM = 0;
                }
                if ((TileLoader.ruin48 & seen_fused) != (TileLoader.ruin_reversed48 & seen_fused)) {
                    VSYM = 0;
                }
                seen_fused = TileLoader.seen49 & TileLoader.seen_reversed49;
                if ((TileLoader.wall49 & seen_fused) != (TileLoader.wall_reversed49 & seen_fused)) {
                    VSYM = 0;
                }
                if ((TileLoader.ruin49 & seen_fused) != (TileLoader.ruin_reversed49 & seen_fused)) {
                    VSYM = 0;
                }
                
            }
            case 46 -> {
                seen_fused = TileLoader.seen42 & TileLoader.seen_reversed42;
                if ((TileLoader.wall42 & seen_fused) != (TileLoader.wall_reversed42 & seen_fused)) {
                    VSYM = 0;
                }
                if ((TileLoader.ruin42 & seen_fused) != (TileLoader.ruin_reversed42 & seen_fused)) {
                    VSYM = 0;
                }
                seen_fused = TileLoader.seen43 & TileLoader.seen_reversed43;
                if ((TileLoader.wall43 & seen_fused) != (TileLoader.wall_reversed43 & seen_fused)) {
                    VSYM = 0;
                }
                if ((TileLoader.ruin43 & seen_fused) != (TileLoader.ruin_reversed43 & seen_fused)) {
                    VSYM = 0;
                }
                seen_fused = TileLoader.seen44 & TileLoader.seen_reversed44;
                if ((TileLoader.wall44 & seen_fused) != (TileLoader.wall_reversed44 & seen_fused)) {
                    VSYM = 0;
                }
                if ((TileLoader.ruin44 & seen_fused) != (TileLoader.ruin_reversed44 & seen_fused)) {
                    VSYM = 0;
                }
                seen_fused = TileLoader.seen45 & TileLoader.seen_reversed45;
                if ((TileLoader.wall45 & seen_fused) != (TileLoader.wall_reversed45 & seen_fused)) {
                    VSYM = 0;
                }
                if ((TileLoader.ruin45 & seen_fused) != (TileLoader.ruin_reversed45 & seen_fused)) {
                    VSYM = 0;
                }
                seen_fused = TileLoader.seen46 & TileLoader.seen_reversed46;
                if ((TileLoader.wall46 & seen_fused) != (TileLoader.wall_reversed46 & seen_fused)) {
                    VSYM = 0;
                }
                if ((TileLoader.ruin46 & seen_fused) != (TileLoader.ruin_reversed46 & seen_fused)) {
                    VSYM = 0;
                }
                seen_fused = TileLoader.seen47 & TileLoader.seen_reversed47;
                if ((TileLoader.wall47 & seen_fused) != (TileLoader.wall_reversed47 & seen_fused)) {
                    VSYM = 0;
                }
                if ((TileLoader.ruin47 & seen_fused) != (TileLoader.ruin_reversed47 & seen_fused)) {
                    VSYM = 0;
                }
                seen_fused = TileLoader.seen48 & TileLoader.seen_reversed48;
                if ((TileLoader.wall48 & seen_fused) != (TileLoader.wall_reversed48 & seen_fused)) {
                    VSYM = 0;
                }
                if ((TileLoader.ruin48 & seen_fused) != (TileLoader.ruin_reversed48 & seen_fused)) {
                    VSYM = 0;
                }
                seen_fused = TileLoader.seen49 & TileLoader.seen_reversed49;
                if ((TileLoader.wall49 & seen_fused) != (TileLoader.wall_reversed49 & seen_fused)) {
                    VSYM = 0;
                }
                if ((TileLoader.ruin49 & seen_fused) != (TileLoader.ruin_reversed49 & seen_fused)) {
                    VSYM = 0;
                }
                seen_fused = TileLoader.seen50 & TileLoader.seen_reversed50;
                if ((TileLoader.wall50 & seen_fused) != (TileLoader.wall_reversed50 & seen_fused)) {
                    VSYM = 0;
                }
                if ((TileLoader.ruin50 & seen_fused) != (TileLoader.ruin_reversed50 & seen_fused)) {
                    VSYM = 0;
                }
                
            }
            case 47 -> {
                seen_fused = TileLoader.seen43 & TileLoader.seen_reversed43;
                if ((TileLoader.wall43 & seen_fused) != (TileLoader.wall_reversed43 & seen_fused)) {
                    VSYM = 0;
                }
                if ((TileLoader.ruin43 & seen_fused) != (TileLoader.ruin_reversed43 & seen_fused)) {
                    VSYM = 0;
                }
                seen_fused = TileLoader.seen44 & TileLoader.seen_reversed44;
                if ((TileLoader.wall44 & seen_fused) != (TileLoader.wall_reversed44 & seen_fused)) {
                    VSYM = 0;
                }
                if ((TileLoader.ruin44 & seen_fused) != (TileLoader.ruin_reversed44 & seen_fused)) {
                    VSYM = 0;
                }
                seen_fused = TileLoader.seen45 & TileLoader.seen_reversed45;
                if ((TileLoader.wall45 & seen_fused) != (TileLoader.wall_reversed45 & seen_fused)) {
                    VSYM = 0;
                }
                if ((TileLoader.ruin45 & seen_fused) != (TileLoader.ruin_reversed45 & seen_fused)) {
                    VSYM = 0;
                }
                seen_fused = TileLoader.seen46 & TileLoader.seen_reversed46;
                if ((TileLoader.wall46 & seen_fused) != (TileLoader.wall_reversed46 & seen_fused)) {
                    VSYM = 0;
                }
                if ((TileLoader.ruin46 & seen_fused) != (TileLoader.ruin_reversed46 & seen_fused)) {
                    VSYM = 0;
                }
                seen_fused = TileLoader.seen47 & TileLoader.seen_reversed47;
                if ((TileLoader.wall47 & seen_fused) != (TileLoader.wall_reversed47 & seen_fused)) {
                    VSYM = 0;
                }
                if ((TileLoader.ruin47 & seen_fused) != (TileLoader.ruin_reversed47 & seen_fused)) {
                    VSYM = 0;
                }
                seen_fused = TileLoader.seen48 & TileLoader.seen_reversed48;
                if ((TileLoader.wall48 & seen_fused) != (TileLoader.wall_reversed48 & seen_fused)) {
                    VSYM = 0;
                }
                if ((TileLoader.ruin48 & seen_fused) != (TileLoader.ruin_reversed48 & seen_fused)) {
                    VSYM = 0;
                }
                seen_fused = TileLoader.seen49 & TileLoader.seen_reversed49;
                if ((TileLoader.wall49 & seen_fused) != (TileLoader.wall_reversed49 & seen_fused)) {
                    VSYM = 0;
                }
                if ((TileLoader.ruin49 & seen_fused) != (TileLoader.ruin_reversed49 & seen_fused)) {
                    VSYM = 0;
                }
                seen_fused = TileLoader.seen50 & TileLoader.seen_reversed50;
                if ((TileLoader.wall50 & seen_fused) != (TileLoader.wall_reversed50 & seen_fused)) {
                    VSYM = 0;
                }
                if ((TileLoader.ruin50 & seen_fused) != (TileLoader.ruin_reversed50 & seen_fused)) {
                    VSYM = 0;
                }
                seen_fused = TileLoader.seen51 & TileLoader.seen_reversed51;
                if ((TileLoader.wall51 & seen_fused) != (TileLoader.wall_reversed51 & seen_fused)) {
                    VSYM = 0;
                }
                if ((TileLoader.ruin51 & seen_fused) != (TileLoader.ruin_reversed51 & seen_fused)) {
                    VSYM = 0;
                }
                
            }
            case 48 -> {
                seen_fused = TileLoader.seen44 & TileLoader.seen_reversed44;
                if ((TileLoader.wall44 & seen_fused) != (TileLoader.wall_reversed44 & seen_fused)) {
                    VSYM = 0;
                }
                if ((TileLoader.ruin44 & seen_fused) != (TileLoader.ruin_reversed44 & seen_fused)) {
                    VSYM = 0;
                }
                seen_fused = TileLoader.seen45 & TileLoader.seen_reversed45;
                if ((TileLoader.wall45 & seen_fused) != (TileLoader.wall_reversed45 & seen_fused)) {
                    VSYM = 0;
                }
                if ((TileLoader.ruin45 & seen_fused) != (TileLoader.ruin_reversed45 & seen_fused)) {
                    VSYM = 0;
                }
                seen_fused = TileLoader.seen46 & TileLoader.seen_reversed46;
                if ((TileLoader.wall46 & seen_fused) != (TileLoader.wall_reversed46 & seen_fused)) {
                    VSYM = 0;
                }
                if ((TileLoader.ruin46 & seen_fused) != (TileLoader.ruin_reversed46 & seen_fused)) {
                    VSYM = 0;
                }
                seen_fused = TileLoader.seen47 & TileLoader.seen_reversed47;
                if ((TileLoader.wall47 & seen_fused) != (TileLoader.wall_reversed47 & seen_fused)) {
                    VSYM = 0;
                }
                if ((TileLoader.ruin47 & seen_fused) != (TileLoader.ruin_reversed47 & seen_fused)) {
                    VSYM = 0;
                }
                seen_fused = TileLoader.seen48 & TileLoader.seen_reversed48;
                if ((TileLoader.wall48 & seen_fused) != (TileLoader.wall_reversed48 & seen_fused)) {
                    VSYM = 0;
                }
                if ((TileLoader.ruin48 & seen_fused) != (TileLoader.ruin_reversed48 & seen_fused)) {
                    VSYM = 0;
                }
                seen_fused = TileLoader.seen49 & TileLoader.seen_reversed49;
                if ((TileLoader.wall49 & seen_fused) != (TileLoader.wall_reversed49 & seen_fused)) {
                    VSYM = 0;
                }
                if ((TileLoader.ruin49 & seen_fused) != (TileLoader.ruin_reversed49 & seen_fused)) {
                    VSYM = 0;
                }
                seen_fused = TileLoader.seen50 & TileLoader.seen_reversed50;
                if ((TileLoader.wall50 & seen_fused) != (TileLoader.wall_reversed50 & seen_fused)) {
                    VSYM = 0;
                }
                if ((TileLoader.ruin50 & seen_fused) != (TileLoader.ruin_reversed50 & seen_fused)) {
                    VSYM = 0;
                }
                seen_fused = TileLoader.seen51 & TileLoader.seen_reversed51;
                if ((TileLoader.wall51 & seen_fused) != (TileLoader.wall_reversed51 & seen_fused)) {
                    VSYM = 0;
                }
                if ((TileLoader.ruin51 & seen_fused) != (TileLoader.ruin_reversed51 & seen_fused)) {
                    VSYM = 0;
                }
                seen_fused = TileLoader.seen52 & TileLoader.seen_reversed52;
                if ((TileLoader.wall52 & seen_fused) != (TileLoader.wall_reversed52 & seen_fused)) {
                    VSYM = 0;
                }
                if ((TileLoader.ruin52 & seen_fused) != (TileLoader.ruin_reversed52 & seen_fused)) {
                    VSYM = 0;
                }
                
            }
            case 49 -> {
                seen_fused = TileLoader.seen45 & TileLoader.seen_reversed45;
                if ((TileLoader.wall45 & seen_fused) != (TileLoader.wall_reversed45 & seen_fused)) {
                    VSYM = 0;
                }
                if ((TileLoader.ruin45 & seen_fused) != (TileLoader.ruin_reversed45 & seen_fused)) {
                    VSYM = 0;
                }
                seen_fused = TileLoader.seen46 & TileLoader.seen_reversed46;
                if ((TileLoader.wall46 & seen_fused) != (TileLoader.wall_reversed46 & seen_fused)) {
                    VSYM = 0;
                }
                if ((TileLoader.ruin46 & seen_fused) != (TileLoader.ruin_reversed46 & seen_fused)) {
                    VSYM = 0;
                }
                seen_fused = TileLoader.seen47 & TileLoader.seen_reversed47;
                if ((TileLoader.wall47 & seen_fused) != (TileLoader.wall_reversed47 & seen_fused)) {
                    VSYM = 0;
                }
                if ((TileLoader.ruin47 & seen_fused) != (TileLoader.ruin_reversed47 & seen_fused)) {
                    VSYM = 0;
                }
                seen_fused = TileLoader.seen48 & TileLoader.seen_reversed48;
                if ((TileLoader.wall48 & seen_fused) != (TileLoader.wall_reversed48 & seen_fused)) {
                    VSYM = 0;
                }
                if ((TileLoader.ruin48 & seen_fused) != (TileLoader.ruin_reversed48 & seen_fused)) {
                    VSYM = 0;
                }
                seen_fused = TileLoader.seen49 & TileLoader.seen_reversed49;
                if ((TileLoader.wall49 & seen_fused) != (TileLoader.wall_reversed49 & seen_fused)) {
                    VSYM = 0;
                }
                if ((TileLoader.ruin49 & seen_fused) != (TileLoader.ruin_reversed49 & seen_fused)) {
                    VSYM = 0;
                }
                seen_fused = TileLoader.seen50 & TileLoader.seen_reversed50;
                if ((TileLoader.wall50 & seen_fused) != (TileLoader.wall_reversed50 & seen_fused)) {
                    VSYM = 0;
                }
                if ((TileLoader.ruin50 & seen_fused) != (TileLoader.ruin_reversed50 & seen_fused)) {
                    VSYM = 0;
                }
                seen_fused = TileLoader.seen51 & TileLoader.seen_reversed51;
                if ((TileLoader.wall51 & seen_fused) != (TileLoader.wall_reversed51 & seen_fused)) {
                    VSYM = 0;
                }
                if ((TileLoader.ruin51 & seen_fused) != (TileLoader.ruin_reversed51 & seen_fused)) {
                    VSYM = 0;
                }
                seen_fused = TileLoader.seen52 & TileLoader.seen_reversed52;
                if ((TileLoader.wall52 & seen_fused) != (TileLoader.wall_reversed52 & seen_fused)) {
                    VSYM = 0;
                }
                if ((TileLoader.ruin52 & seen_fused) != (TileLoader.ruin_reversed52 & seen_fused)) {
                    VSYM = 0;
                }
                seen_fused = TileLoader.seen53 & TileLoader.seen_reversed53;
                if ((TileLoader.wall53 & seen_fused) != (TileLoader.wall_reversed53 & seen_fused)) {
                    VSYM = 0;
                }
                if ((TileLoader.ruin53 & seen_fused) != (TileLoader.ruin_reversed53 & seen_fused)) {
                    VSYM = 0;
                }
                
            }
            case 50 -> {
                seen_fused = TileLoader.seen46 & TileLoader.seen_reversed46;
                if ((TileLoader.wall46 & seen_fused) != (TileLoader.wall_reversed46 & seen_fused)) {
                    VSYM = 0;
                }
                if ((TileLoader.ruin46 & seen_fused) != (TileLoader.ruin_reversed46 & seen_fused)) {
                    VSYM = 0;
                }
                seen_fused = TileLoader.seen47 & TileLoader.seen_reversed47;
                if ((TileLoader.wall47 & seen_fused) != (TileLoader.wall_reversed47 & seen_fused)) {
                    VSYM = 0;
                }
                if ((TileLoader.ruin47 & seen_fused) != (TileLoader.ruin_reversed47 & seen_fused)) {
                    VSYM = 0;
                }
                seen_fused = TileLoader.seen48 & TileLoader.seen_reversed48;
                if ((TileLoader.wall48 & seen_fused) != (TileLoader.wall_reversed48 & seen_fused)) {
                    VSYM = 0;
                }
                if ((TileLoader.ruin48 & seen_fused) != (TileLoader.ruin_reversed48 & seen_fused)) {
                    VSYM = 0;
                }
                seen_fused = TileLoader.seen49 & TileLoader.seen_reversed49;
                if ((TileLoader.wall49 & seen_fused) != (TileLoader.wall_reversed49 & seen_fused)) {
                    VSYM = 0;
                }
                if ((TileLoader.ruin49 & seen_fused) != (TileLoader.ruin_reversed49 & seen_fused)) {
                    VSYM = 0;
                }
                seen_fused = TileLoader.seen50 & TileLoader.seen_reversed50;
                if ((TileLoader.wall50 & seen_fused) != (TileLoader.wall_reversed50 & seen_fused)) {
                    VSYM = 0;
                }
                if ((TileLoader.ruin50 & seen_fused) != (TileLoader.ruin_reversed50 & seen_fused)) {
                    VSYM = 0;
                }
                seen_fused = TileLoader.seen51 & TileLoader.seen_reversed51;
                if ((TileLoader.wall51 & seen_fused) != (TileLoader.wall_reversed51 & seen_fused)) {
                    VSYM = 0;
                }
                if ((TileLoader.ruin51 & seen_fused) != (TileLoader.ruin_reversed51 & seen_fused)) {
                    VSYM = 0;
                }
                seen_fused = TileLoader.seen52 & TileLoader.seen_reversed52;
                if ((TileLoader.wall52 & seen_fused) != (TileLoader.wall_reversed52 & seen_fused)) {
                    VSYM = 0;
                }
                if ((TileLoader.ruin52 & seen_fused) != (TileLoader.ruin_reversed52 & seen_fused)) {
                    VSYM = 0;
                }
                seen_fused = TileLoader.seen53 & TileLoader.seen_reversed53;
                if ((TileLoader.wall53 & seen_fused) != (TileLoader.wall_reversed53 & seen_fused)) {
                    VSYM = 0;
                }
                if ((TileLoader.ruin53 & seen_fused) != (TileLoader.ruin_reversed53 & seen_fused)) {
                    VSYM = 0;
                }
                seen_fused = TileLoader.seen54 & TileLoader.seen_reversed54;
                if ((TileLoader.wall54 & seen_fused) != (TileLoader.wall_reversed54 & seen_fused)) {
                    VSYM = 0;
                }
                if ((TileLoader.ruin54 & seen_fused) != (TileLoader.ruin_reversed54 & seen_fused)) {
                    VSYM = 0;
                }
                
            }
            case 51 -> {
                seen_fused = TileLoader.seen47 & TileLoader.seen_reversed47;
                if ((TileLoader.wall47 & seen_fused) != (TileLoader.wall_reversed47 & seen_fused)) {
                    VSYM = 0;
                }
                if ((TileLoader.ruin47 & seen_fused) != (TileLoader.ruin_reversed47 & seen_fused)) {
                    VSYM = 0;
                }
                seen_fused = TileLoader.seen48 & TileLoader.seen_reversed48;
                if ((TileLoader.wall48 & seen_fused) != (TileLoader.wall_reversed48 & seen_fused)) {
                    VSYM = 0;
                }
                if ((TileLoader.ruin48 & seen_fused) != (TileLoader.ruin_reversed48 & seen_fused)) {
                    VSYM = 0;
                }
                seen_fused = TileLoader.seen49 & TileLoader.seen_reversed49;
                if ((TileLoader.wall49 & seen_fused) != (TileLoader.wall_reversed49 & seen_fused)) {
                    VSYM = 0;
                }
                if ((TileLoader.ruin49 & seen_fused) != (TileLoader.ruin_reversed49 & seen_fused)) {
                    VSYM = 0;
                }
                seen_fused = TileLoader.seen50 & TileLoader.seen_reversed50;
                if ((TileLoader.wall50 & seen_fused) != (TileLoader.wall_reversed50 & seen_fused)) {
                    VSYM = 0;
                }
                if ((TileLoader.ruin50 & seen_fused) != (TileLoader.ruin_reversed50 & seen_fused)) {
                    VSYM = 0;
                }
                seen_fused = TileLoader.seen51 & TileLoader.seen_reversed51;
                if ((TileLoader.wall51 & seen_fused) != (TileLoader.wall_reversed51 & seen_fused)) {
                    VSYM = 0;
                }
                if ((TileLoader.ruin51 & seen_fused) != (TileLoader.ruin_reversed51 & seen_fused)) {
                    VSYM = 0;
                }
                seen_fused = TileLoader.seen52 & TileLoader.seen_reversed52;
                if ((TileLoader.wall52 & seen_fused) != (TileLoader.wall_reversed52 & seen_fused)) {
                    VSYM = 0;
                }
                if ((TileLoader.ruin52 & seen_fused) != (TileLoader.ruin_reversed52 & seen_fused)) {
                    VSYM = 0;
                }
                seen_fused = TileLoader.seen53 & TileLoader.seen_reversed53;
                if ((TileLoader.wall53 & seen_fused) != (TileLoader.wall_reversed53 & seen_fused)) {
                    VSYM = 0;
                }
                if ((TileLoader.ruin53 & seen_fused) != (TileLoader.ruin_reversed53 & seen_fused)) {
                    VSYM = 0;
                }
                seen_fused = TileLoader.seen54 & TileLoader.seen_reversed54;
                if ((TileLoader.wall54 & seen_fused) != (TileLoader.wall_reversed54 & seen_fused)) {
                    VSYM = 0;
                }
                if ((TileLoader.ruin54 & seen_fused) != (TileLoader.ruin_reversed54 & seen_fused)) {
                    VSYM = 0;
                }
                seen_fused = TileLoader.seen55 & TileLoader.seen_reversed55;
                if ((TileLoader.wall55 & seen_fused) != (TileLoader.wall_reversed55 & seen_fused)) {
                    VSYM = 0;
                }
                if ((TileLoader.ruin55 & seen_fused) != (TileLoader.ruin_reversed55 & seen_fused)) {
                    VSYM = 0;
                }
                
            }
            case 52 -> {
                seen_fused = TileLoader.seen48 & TileLoader.seen_reversed48;
                if ((TileLoader.wall48 & seen_fused) != (TileLoader.wall_reversed48 & seen_fused)) {
                    VSYM = 0;
                }
                if ((TileLoader.ruin48 & seen_fused) != (TileLoader.ruin_reversed48 & seen_fused)) {
                    VSYM = 0;
                }
                seen_fused = TileLoader.seen49 & TileLoader.seen_reversed49;
                if ((TileLoader.wall49 & seen_fused) != (TileLoader.wall_reversed49 & seen_fused)) {
                    VSYM = 0;
                }
                if ((TileLoader.ruin49 & seen_fused) != (TileLoader.ruin_reversed49 & seen_fused)) {
                    VSYM = 0;
                }
                seen_fused = TileLoader.seen50 & TileLoader.seen_reversed50;
                if ((TileLoader.wall50 & seen_fused) != (TileLoader.wall_reversed50 & seen_fused)) {
                    VSYM = 0;
                }
                if ((TileLoader.ruin50 & seen_fused) != (TileLoader.ruin_reversed50 & seen_fused)) {
                    VSYM = 0;
                }
                seen_fused = TileLoader.seen51 & TileLoader.seen_reversed51;
                if ((TileLoader.wall51 & seen_fused) != (TileLoader.wall_reversed51 & seen_fused)) {
                    VSYM = 0;
                }
                if ((TileLoader.ruin51 & seen_fused) != (TileLoader.ruin_reversed51 & seen_fused)) {
                    VSYM = 0;
                }
                seen_fused = TileLoader.seen52 & TileLoader.seen_reversed52;
                if ((TileLoader.wall52 & seen_fused) != (TileLoader.wall_reversed52 & seen_fused)) {
                    VSYM = 0;
                }
                if ((TileLoader.ruin52 & seen_fused) != (TileLoader.ruin_reversed52 & seen_fused)) {
                    VSYM = 0;
                }
                seen_fused = TileLoader.seen53 & TileLoader.seen_reversed53;
                if ((TileLoader.wall53 & seen_fused) != (TileLoader.wall_reversed53 & seen_fused)) {
                    VSYM = 0;
                }
                if ((TileLoader.ruin53 & seen_fused) != (TileLoader.ruin_reversed53 & seen_fused)) {
                    VSYM = 0;
                }
                seen_fused = TileLoader.seen54 & TileLoader.seen_reversed54;
                if ((TileLoader.wall54 & seen_fused) != (TileLoader.wall_reversed54 & seen_fused)) {
                    VSYM = 0;
                }
                if ((TileLoader.ruin54 & seen_fused) != (TileLoader.ruin_reversed54 & seen_fused)) {
                    VSYM = 0;
                }
                seen_fused = TileLoader.seen55 & TileLoader.seen_reversed55;
                if ((TileLoader.wall55 & seen_fused) != (TileLoader.wall_reversed55 & seen_fused)) {
                    VSYM = 0;
                }
                if ((TileLoader.ruin55 & seen_fused) != (TileLoader.ruin_reversed55 & seen_fused)) {
                    VSYM = 0;
                }
                seen_fused = TileLoader.seen56 & TileLoader.seen_reversed56;
                if ((TileLoader.wall56 & seen_fused) != (TileLoader.wall_reversed56 & seen_fused)) {
                    VSYM = 0;
                }
                if ((TileLoader.ruin56 & seen_fused) != (TileLoader.ruin_reversed56 & seen_fused)) {
                    VSYM = 0;
                }
                
            }
            case 53 -> {
                seen_fused = TileLoader.seen49 & TileLoader.seen_reversed49;
                if ((TileLoader.wall49 & seen_fused) != (TileLoader.wall_reversed49 & seen_fused)) {
                    VSYM = 0;
                }
                if ((TileLoader.ruin49 & seen_fused) != (TileLoader.ruin_reversed49 & seen_fused)) {
                    VSYM = 0;
                }
                seen_fused = TileLoader.seen50 & TileLoader.seen_reversed50;
                if ((TileLoader.wall50 & seen_fused) != (TileLoader.wall_reversed50 & seen_fused)) {
                    VSYM = 0;
                }
                if ((TileLoader.ruin50 & seen_fused) != (TileLoader.ruin_reversed50 & seen_fused)) {
                    VSYM = 0;
                }
                seen_fused = TileLoader.seen51 & TileLoader.seen_reversed51;
                if ((TileLoader.wall51 & seen_fused) != (TileLoader.wall_reversed51 & seen_fused)) {
                    VSYM = 0;
                }
                if ((TileLoader.ruin51 & seen_fused) != (TileLoader.ruin_reversed51 & seen_fused)) {
                    VSYM = 0;
                }
                seen_fused = TileLoader.seen52 & TileLoader.seen_reversed52;
                if ((TileLoader.wall52 & seen_fused) != (TileLoader.wall_reversed52 & seen_fused)) {
                    VSYM = 0;
                }
                if ((TileLoader.ruin52 & seen_fused) != (TileLoader.ruin_reversed52 & seen_fused)) {
                    VSYM = 0;
                }
                seen_fused = TileLoader.seen53 & TileLoader.seen_reversed53;
                if ((TileLoader.wall53 & seen_fused) != (TileLoader.wall_reversed53 & seen_fused)) {
                    VSYM = 0;
                }
                if ((TileLoader.ruin53 & seen_fused) != (TileLoader.ruin_reversed53 & seen_fused)) {
                    VSYM = 0;
                }
                seen_fused = TileLoader.seen54 & TileLoader.seen_reversed54;
                if ((TileLoader.wall54 & seen_fused) != (TileLoader.wall_reversed54 & seen_fused)) {
                    VSYM = 0;
                }
                if ((TileLoader.ruin54 & seen_fused) != (TileLoader.ruin_reversed54 & seen_fused)) {
                    VSYM = 0;
                }
                seen_fused = TileLoader.seen55 & TileLoader.seen_reversed55;
                if ((TileLoader.wall55 & seen_fused) != (TileLoader.wall_reversed55 & seen_fused)) {
                    VSYM = 0;
                }
                if ((TileLoader.ruin55 & seen_fused) != (TileLoader.ruin_reversed55 & seen_fused)) {
                    VSYM = 0;
                }
                seen_fused = TileLoader.seen56 & TileLoader.seen_reversed56;
                if ((TileLoader.wall56 & seen_fused) != (TileLoader.wall_reversed56 & seen_fused)) {
                    VSYM = 0;
                }
                if ((TileLoader.ruin56 & seen_fused) != (TileLoader.ruin_reversed56 & seen_fused)) {
                    VSYM = 0;
                }
                seen_fused = TileLoader.seen57 & TileLoader.seen_reversed57;
                if ((TileLoader.wall57 & seen_fused) != (TileLoader.wall_reversed57 & seen_fused)) {
                    VSYM = 0;
                }
                if ((TileLoader.ruin57 & seen_fused) != (TileLoader.ruin_reversed57 & seen_fused)) {
                    VSYM = 0;
                }
                
            }
            case 54 -> {
                seen_fused = TileLoader.seen50 & TileLoader.seen_reversed50;
                if ((TileLoader.wall50 & seen_fused) != (TileLoader.wall_reversed50 & seen_fused)) {
                    VSYM = 0;
                }
                if ((TileLoader.ruin50 & seen_fused) != (TileLoader.ruin_reversed50 & seen_fused)) {
                    VSYM = 0;
                }
                seen_fused = TileLoader.seen51 & TileLoader.seen_reversed51;
                if ((TileLoader.wall51 & seen_fused) != (TileLoader.wall_reversed51 & seen_fused)) {
                    VSYM = 0;
                }
                if ((TileLoader.ruin51 & seen_fused) != (TileLoader.ruin_reversed51 & seen_fused)) {
                    VSYM = 0;
                }
                seen_fused = TileLoader.seen52 & TileLoader.seen_reversed52;
                if ((TileLoader.wall52 & seen_fused) != (TileLoader.wall_reversed52 & seen_fused)) {
                    VSYM = 0;
                }
                if ((TileLoader.ruin52 & seen_fused) != (TileLoader.ruin_reversed52 & seen_fused)) {
                    VSYM = 0;
                }
                seen_fused = TileLoader.seen53 & TileLoader.seen_reversed53;
                if ((TileLoader.wall53 & seen_fused) != (TileLoader.wall_reversed53 & seen_fused)) {
                    VSYM = 0;
                }
                if ((TileLoader.ruin53 & seen_fused) != (TileLoader.ruin_reversed53 & seen_fused)) {
                    VSYM = 0;
                }
                seen_fused = TileLoader.seen54 & TileLoader.seen_reversed54;
                if ((TileLoader.wall54 & seen_fused) != (TileLoader.wall_reversed54 & seen_fused)) {
                    VSYM = 0;
                }
                if ((TileLoader.ruin54 & seen_fused) != (TileLoader.ruin_reversed54 & seen_fused)) {
                    VSYM = 0;
                }
                seen_fused = TileLoader.seen55 & TileLoader.seen_reversed55;
                if ((TileLoader.wall55 & seen_fused) != (TileLoader.wall_reversed55 & seen_fused)) {
                    VSYM = 0;
                }
                if ((TileLoader.ruin55 & seen_fused) != (TileLoader.ruin_reversed55 & seen_fused)) {
                    VSYM = 0;
                }
                seen_fused = TileLoader.seen56 & TileLoader.seen_reversed56;
                if ((TileLoader.wall56 & seen_fused) != (TileLoader.wall_reversed56 & seen_fused)) {
                    VSYM = 0;
                }
                if ((TileLoader.ruin56 & seen_fused) != (TileLoader.ruin_reversed56 & seen_fused)) {
                    VSYM = 0;
                }
                seen_fused = TileLoader.seen57 & TileLoader.seen_reversed57;
                if ((TileLoader.wall57 & seen_fused) != (TileLoader.wall_reversed57 & seen_fused)) {
                    VSYM = 0;
                }
                if ((TileLoader.ruin57 & seen_fused) != (TileLoader.ruin_reversed57 & seen_fused)) {
                    VSYM = 0;
                }
                seen_fused = TileLoader.seen58 & TileLoader.seen_reversed58;
                if ((TileLoader.wall58 & seen_fused) != (TileLoader.wall_reversed58 & seen_fused)) {
                    VSYM = 0;
                }
                if ((TileLoader.ruin58 & seen_fused) != (TileLoader.ruin_reversed58 & seen_fused)) {
                    VSYM = 0;
                }
                
            }
            case 55 -> {
                seen_fused = TileLoader.seen51 & TileLoader.seen_reversed51;
                if ((TileLoader.wall51 & seen_fused) != (TileLoader.wall_reversed51 & seen_fused)) {
                    VSYM = 0;
                }
                if ((TileLoader.ruin51 & seen_fused) != (TileLoader.ruin_reversed51 & seen_fused)) {
                    VSYM = 0;
                }
                seen_fused = TileLoader.seen52 & TileLoader.seen_reversed52;
                if ((TileLoader.wall52 & seen_fused) != (TileLoader.wall_reversed52 & seen_fused)) {
                    VSYM = 0;
                }
                if ((TileLoader.ruin52 & seen_fused) != (TileLoader.ruin_reversed52 & seen_fused)) {
                    VSYM = 0;
                }
                seen_fused = TileLoader.seen53 & TileLoader.seen_reversed53;
                if ((TileLoader.wall53 & seen_fused) != (TileLoader.wall_reversed53 & seen_fused)) {
                    VSYM = 0;
                }
                if ((TileLoader.ruin53 & seen_fused) != (TileLoader.ruin_reversed53 & seen_fused)) {
                    VSYM = 0;
                }
                seen_fused = TileLoader.seen54 & TileLoader.seen_reversed54;
                if ((TileLoader.wall54 & seen_fused) != (TileLoader.wall_reversed54 & seen_fused)) {
                    VSYM = 0;
                }
                if ((TileLoader.ruin54 & seen_fused) != (TileLoader.ruin_reversed54 & seen_fused)) {
                    VSYM = 0;
                }
                seen_fused = TileLoader.seen55 & TileLoader.seen_reversed55;
                if ((TileLoader.wall55 & seen_fused) != (TileLoader.wall_reversed55 & seen_fused)) {
                    VSYM = 0;
                }
                if ((TileLoader.ruin55 & seen_fused) != (TileLoader.ruin_reversed55 & seen_fused)) {
                    VSYM = 0;
                }
                seen_fused = TileLoader.seen56 & TileLoader.seen_reversed56;
                if ((TileLoader.wall56 & seen_fused) != (TileLoader.wall_reversed56 & seen_fused)) {
                    VSYM = 0;
                }
                if ((TileLoader.ruin56 & seen_fused) != (TileLoader.ruin_reversed56 & seen_fused)) {
                    VSYM = 0;
                }
                seen_fused = TileLoader.seen57 & TileLoader.seen_reversed57;
                if ((TileLoader.wall57 & seen_fused) != (TileLoader.wall_reversed57 & seen_fused)) {
                    VSYM = 0;
                }
                if ((TileLoader.ruin57 & seen_fused) != (TileLoader.ruin_reversed57 & seen_fused)) {
                    VSYM = 0;
                }
                seen_fused = TileLoader.seen58 & TileLoader.seen_reversed58;
                if ((TileLoader.wall58 & seen_fused) != (TileLoader.wall_reversed58 & seen_fused)) {
                    VSYM = 0;
                }
                if ((TileLoader.ruin58 & seen_fused) != (TileLoader.ruin_reversed58 & seen_fused)) {
                    VSYM = 0;
                }
                seen_fused = TileLoader.seen59 & TileLoader.seen_reversed59;
                if ((TileLoader.wall59 & seen_fused) != (TileLoader.wall_reversed59 & seen_fused)) {
                    VSYM = 0;
                }
                if ((TileLoader.ruin59 & seen_fused) != (TileLoader.ruin_reversed59 & seen_fused)) {
                    VSYM = 0;
                }
                
            }
            case 56 -> {
                seen_fused = TileLoader.seen52 & TileLoader.seen_reversed52;
                if ((TileLoader.wall52 & seen_fused) != (TileLoader.wall_reversed52 & seen_fused)) {
                    VSYM = 0;
                }
                if ((TileLoader.ruin52 & seen_fused) != (TileLoader.ruin_reversed52 & seen_fused)) {
                    VSYM = 0;
                }
                seen_fused = TileLoader.seen53 & TileLoader.seen_reversed53;
                if ((TileLoader.wall53 & seen_fused) != (TileLoader.wall_reversed53 & seen_fused)) {
                    VSYM = 0;
                }
                if ((TileLoader.ruin53 & seen_fused) != (TileLoader.ruin_reversed53 & seen_fused)) {
                    VSYM = 0;
                }
                seen_fused = TileLoader.seen54 & TileLoader.seen_reversed54;
                if ((TileLoader.wall54 & seen_fused) != (TileLoader.wall_reversed54 & seen_fused)) {
                    VSYM = 0;
                }
                if ((TileLoader.ruin54 & seen_fused) != (TileLoader.ruin_reversed54 & seen_fused)) {
                    VSYM = 0;
                }
                seen_fused = TileLoader.seen55 & TileLoader.seen_reversed55;
                if ((TileLoader.wall55 & seen_fused) != (TileLoader.wall_reversed55 & seen_fused)) {
                    VSYM = 0;
                }
                if ((TileLoader.ruin55 & seen_fused) != (TileLoader.ruin_reversed55 & seen_fused)) {
                    VSYM = 0;
                }
                seen_fused = TileLoader.seen56 & TileLoader.seen_reversed56;
                if ((TileLoader.wall56 & seen_fused) != (TileLoader.wall_reversed56 & seen_fused)) {
                    VSYM = 0;
                }
                if ((TileLoader.ruin56 & seen_fused) != (TileLoader.ruin_reversed56 & seen_fused)) {
                    VSYM = 0;
                }
                seen_fused = TileLoader.seen57 & TileLoader.seen_reversed57;
                if ((TileLoader.wall57 & seen_fused) != (TileLoader.wall_reversed57 & seen_fused)) {
                    VSYM = 0;
                }
                if ((TileLoader.ruin57 & seen_fused) != (TileLoader.ruin_reversed57 & seen_fused)) {
                    VSYM = 0;
                }
                seen_fused = TileLoader.seen58 & TileLoader.seen_reversed58;
                if ((TileLoader.wall58 & seen_fused) != (TileLoader.wall_reversed58 & seen_fused)) {
                    VSYM = 0;
                }
                if ((TileLoader.ruin58 & seen_fused) != (TileLoader.ruin_reversed58 & seen_fused)) {
                    VSYM = 0;
                }
                seen_fused = TileLoader.seen59 & TileLoader.seen_reversed59;
                if ((TileLoader.wall59 & seen_fused) != (TileLoader.wall_reversed59 & seen_fused)) {
                    VSYM = 0;
                }
                if ((TileLoader.ruin59 & seen_fused) != (TileLoader.ruin_reversed59 & seen_fused)) {
                    VSYM = 0;
                }
                
            }
            case 57 -> {
                seen_fused = TileLoader.seen53 & TileLoader.seen_reversed53;
                if ((TileLoader.wall53 & seen_fused) != (TileLoader.wall_reversed53 & seen_fused)) {
                    VSYM = 0;
                }
                if ((TileLoader.ruin53 & seen_fused) != (TileLoader.ruin_reversed53 & seen_fused)) {
                    VSYM = 0;
                }
                seen_fused = TileLoader.seen54 & TileLoader.seen_reversed54;
                if ((TileLoader.wall54 & seen_fused) != (TileLoader.wall_reversed54 & seen_fused)) {
                    VSYM = 0;
                }
                if ((TileLoader.ruin54 & seen_fused) != (TileLoader.ruin_reversed54 & seen_fused)) {
                    VSYM = 0;
                }
                seen_fused = TileLoader.seen55 & TileLoader.seen_reversed55;
                if ((TileLoader.wall55 & seen_fused) != (TileLoader.wall_reversed55 & seen_fused)) {
                    VSYM = 0;
                }
                if ((TileLoader.ruin55 & seen_fused) != (TileLoader.ruin_reversed55 & seen_fused)) {
                    VSYM = 0;
                }
                seen_fused = TileLoader.seen56 & TileLoader.seen_reversed56;
                if ((TileLoader.wall56 & seen_fused) != (TileLoader.wall_reversed56 & seen_fused)) {
                    VSYM = 0;
                }
                if ((TileLoader.ruin56 & seen_fused) != (TileLoader.ruin_reversed56 & seen_fused)) {
                    VSYM = 0;
                }
                seen_fused = TileLoader.seen57 & TileLoader.seen_reversed57;
                if ((TileLoader.wall57 & seen_fused) != (TileLoader.wall_reversed57 & seen_fused)) {
                    VSYM = 0;
                }
                if ((TileLoader.ruin57 & seen_fused) != (TileLoader.ruin_reversed57 & seen_fused)) {
                    VSYM = 0;
                }
                seen_fused = TileLoader.seen58 & TileLoader.seen_reversed58;
                if ((TileLoader.wall58 & seen_fused) != (TileLoader.wall_reversed58 & seen_fused)) {
                    VSYM = 0;
                }
                if ((TileLoader.ruin58 & seen_fused) != (TileLoader.ruin_reversed58 & seen_fused)) {
                    VSYM = 0;
                }
                seen_fused = TileLoader.seen59 & TileLoader.seen_reversed59;
                if ((TileLoader.wall59 & seen_fused) != (TileLoader.wall_reversed59 & seen_fused)) {
                    VSYM = 0;
                }
                if ((TileLoader.ruin59 & seen_fused) != (TileLoader.ruin_reversed59 & seen_fused)) {
                    VSYM = 0;
                }
                
            }
            case 58 -> {
                seen_fused = TileLoader.seen54 & TileLoader.seen_reversed54;
                if ((TileLoader.wall54 & seen_fused) != (TileLoader.wall_reversed54 & seen_fused)) {
                    VSYM = 0;
                }
                if ((TileLoader.ruin54 & seen_fused) != (TileLoader.ruin_reversed54 & seen_fused)) {
                    VSYM = 0;
                }
                seen_fused = TileLoader.seen55 & TileLoader.seen_reversed55;
                if ((TileLoader.wall55 & seen_fused) != (TileLoader.wall_reversed55 & seen_fused)) {
                    VSYM = 0;
                }
                if ((TileLoader.ruin55 & seen_fused) != (TileLoader.ruin_reversed55 & seen_fused)) {
                    VSYM = 0;
                }
                seen_fused = TileLoader.seen56 & TileLoader.seen_reversed56;
                if ((TileLoader.wall56 & seen_fused) != (TileLoader.wall_reversed56 & seen_fused)) {
                    VSYM = 0;
                }
                if ((TileLoader.ruin56 & seen_fused) != (TileLoader.ruin_reversed56 & seen_fused)) {
                    VSYM = 0;
                }
                seen_fused = TileLoader.seen57 & TileLoader.seen_reversed57;
                if ((TileLoader.wall57 & seen_fused) != (TileLoader.wall_reversed57 & seen_fused)) {
                    VSYM = 0;
                }
                if ((TileLoader.ruin57 & seen_fused) != (TileLoader.ruin_reversed57 & seen_fused)) {
                    VSYM = 0;
                }
                seen_fused = TileLoader.seen58 & TileLoader.seen_reversed58;
                if ((TileLoader.wall58 & seen_fused) != (TileLoader.wall_reversed58 & seen_fused)) {
                    VSYM = 0;
                }
                if ((TileLoader.ruin58 & seen_fused) != (TileLoader.ruin_reversed58 & seen_fused)) {
                    VSYM = 0;
                }
                seen_fused = TileLoader.seen59 & TileLoader.seen_reversed59;
                if ((TileLoader.wall59 & seen_fused) != (TileLoader.wall_reversed59 & seen_fused)) {
                    VSYM = 0;
                }
                if ((TileLoader.ruin59 & seen_fused) != (TileLoader.ruin_reversed59 & seen_fused)) {
                    VSYM = 0;
                }
                
            }
            case 59 -> {
                seen_fused = TileLoader.seen55 & TileLoader.seen_reversed55;
                if ((TileLoader.wall55 & seen_fused) != (TileLoader.wall_reversed55 & seen_fused)) {
                    VSYM = 0;
                }
                if ((TileLoader.ruin55 & seen_fused) != (TileLoader.ruin_reversed55 & seen_fused)) {
                    VSYM = 0;
                }
                seen_fused = TileLoader.seen56 & TileLoader.seen_reversed56;
                if ((TileLoader.wall56 & seen_fused) != (TileLoader.wall_reversed56 & seen_fused)) {
                    VSYM = 0;
                }
                if ((TileLoader.ruin56 & seen_fused) != (TileLoader.ruin_reversed56 & seen_fused)) {
                    VSYM = 0;
                }
                seen_fused = TileLoader.seen57 & TileLoader.seen_reversed57;
                if ((TileLoader.wall57 & seen_fused) != (TileLoader.wall_reversed57 & seen_fused)) {
                    VSYM = 0;
                }
                if ((TileLoader.ruin57 & seen_fused) != (TileLoader.ruin_reversed57 & seen_fused)) {
                    VSYM = 0;
                }
                seen_fused = TileLoader.seen58 & TileLoader.seen_reversed58;
                if ((TileLoader.wall58 & seen_fused) != (TileLoader.wall_reversed58 & seen_fused)) {
                    VSYM = 0;
                }
                if ((TileLoader.ruin58 & seen_fused) != (TileLoader.ruin_reversed58 & seen_fused)) {
                    VSYM = 0;
                }
                seen_fused = TileLoader.seen59 & TileLoader.seen_reversed59;
                if ((TileLoader.wall59 & seen_fused) != (TileLoader.wall_reversed59 & seen_fused)) {
                    VSYM = 0;
                }
                if ((TileLoader.ruin59 & seen_fused) != (TileLoader.ruin_reversed59 & seen_fused)) {
                    VSYM = 0;
                }
                
            }
            
            default -> {}
        }
    }

    public static void checkRotational() throws GameActionException {
        switch (rc.getLocation().y) {
            case 0 -> {
                seen_fused = TileLoader.seen0 & getSeenReversedHorizontal(0);
                if ((TileLoader.wall0 & seen_fused) != (getWallReversedHorizontal(0) & seen_fused)) {
                    RSYM = 0;
                }
                if ((TileLoader.ruin0 & seen_fused) != (getRuinReversedHorizontal(0) & seen_fused)) {
                    RSYM = 0;
                }
                seen_fused = TileLoader.seen1 & getSeenReversedHorizontal(1);
                if ((TileLoader.wall1 & seen_fused) != (getWallReversedHorizontal(1) & seen_fused)) {
                    RSYM = 0;
                }
                if ((TileLoader.ruin1 & seen_fused) != (getRuinReversedHorizontal(1) & seen_fused)) {
                    RSYM = 0;
                }
                seen_fused = TileLoader.seen2 & getSeenReversedHorizontal(2);
                if ((TileLoader.wall2 & seen_fused) != (getWallReversedHorizontal(2) & seen_fused)) {
                    RSYM = 0;
                }
                if ((TileLoader.ruin2 & seen_fused) != (getRuinReversedHorizontal(2) & seen_fused)) {
                    RSYM = 0;
                }
                seen_fused = TileLoader.seen3 & getSeenReversedHorizontal(3);
                if ((TileLoader.wall3 & seen_fused) != (getWallReversedHorizontal(3) & seen_fused)) {
                    RSYM = 0;
                }
                if ((TileLoader.ruin3 & seen_fused) != (getRuinReversedHorizontal(3) & seen_fused)) {
                    RSYM = 0;
                }
                seen_fused = TileLoader.seen4 & getSeenReversedHorizontal(4);
                if ((TileLoader.wall4 & seen_fused) != (getWallReversedHorizontal(4) & seen_fused)) {
                    RSYM = 0;
                }
                if ((TileLoader.ruin4 & seen_fused) != (getRuinReversedHorizontal(4) & seen_fused)) {
                    RSYM = 0;
                }
                
            }
            case 1 -> {
                seen_fused = TileLoader.seen0 & getSeenReversedHorizontal(0);
                if ((TileLoader.wall0 & seen_fused) != (getWallReversedHorizontal(0) & seen_fused)) {
                    RSYM = 0;
                }
                if ((TileLoader.ruin0 & seen_fused) != (getRuinReversedHorizontal(0) & seen_fused)) {
                    RSYM = 0;
                }
                seen_fused = TileLoader.seen1 & getSeenReversedHorizontal(1);
                if ((TileLoader.wall1 & seen_fused) != (getWallReversedHorizontal(1) & seen_fused)) {
                    RSYM = 0;
                }
                if ((TileLoader.ruin1 & seen_fused) != (getRuinReversedHorizontal(1) & seen_fused)) {
                    RSYM = 0;
                }
                seen_fused = TileLoader.seen2 & getSeenReversedHorizontal(2);
                if ((TileLoader.wall2 & seen_fused) != (getWallReversedHorizontal(2) & seen_fused)) {
                    RSYM = 0;
                }
                if ((TileLoader.ruin2 & seen_fused) != (getRuinReversedHorizontal(2) & seen_fused)) {
                    RSYM = 0;
                }
                seen_fused = TileLoader.seen3 & getSeenReversedHorizontal(3);
                if ((TileLoader.wall3 & seen_fused) != (getWallReversedHorizontal(3) & seen_fused)) {
                    RSYM = 0;
                }
                if ((TileLoader.ruin3 & seen_fused) != (getRuinReversedHorizontal(3) & seen_fused)) {
                    RSYM = 0;
                }
                seen_fused = TileLoader.seen4 & getSeenReversedHorizontal(4);
                if ((TileLoader.wall4 & seen_fused) != (getWallReversedHorizontal(4) & seen_fused)) {
                    RSYM = 0;
                }
                if ((TileLoader.ruin4 & seen_fused) != (getRuinReversedHorizontal(4) & seen_fused)) {
                    RSYM = 0;
                }
                seen_fused = TileLoader.seen5 & getSeenReversedHorizontal(5);
                if ((TileLoader.wall5 & seen_fused) != (getWallReversedHorizontal(5) & seen_fused)) {
                    RSYM = 0;
                }
                if ((TileLoader.ruin5 & seen_fused) != (getRuinReversedHorizontal(5) & seen_fused)) {
                    RSYM = 0;
                }
                
            }
            case 2 -> {
                seen_fused = TileLoader.seen0 & getSeenReversedHorizontal(0);
                if ((TileLoader.wall0 & seen_fused) != (getWallReversedHorizontal(0) & seen_fused)) {
                    RSYM = 0;
                }
                if ((TileLoader.ruin0 & seen_fused) != (getRuinReversedHorizontal(0) & seen_fused)) {
                    RSYM = 0;
                }
                seen_fused = TileLoader.seen1 & getSeenReversedHorizontal(1);
                if ((TileLoader.wall1 & seen_fused) != (getWallReversedHorizontal(1) & seen_fused)) {
                    RSYM = 0;
                }
                if ((TileLoader.ruin1 & seen_fused) != (getRuinReversedHorizontal(1) & seen_fused)) {
                    RSYM = 0;
                }
                seen_fused = TileLoader.seen2 & getSeenReversedHorizontal(2);
                if ((TileLoader.wall2 & seen_fused) != (getWallReversedHorizontal(2) & seen_fused)) {
                    RSYM = 0;
                }
                if ((TileLoader.ruin2 & seen_fused) != (getRuinReversedHorizontal(2) & seen_fused)) {
                    RSYM = 0;
                }
                seen_fused = TileLoader.seen3 & getSeenReversedHorizontal(3);
                if ((TileLoader.wall3 & seen_fused) != (getWallReversedHorizontal(3) & seen_fused)) {
                    RSYM = 0;
                }
                if ((TileLoader.ruin3 & seen_fused) != (getRuinReversedHorizontal(3) & seen_fused)) {
                    RSYM = 0;
                }
                seen_fused = TileLoader.seen4 & getSeenReversedHorizontal(4);
                if ((TileLoader.wall4 & seen_fused) != (getWallReversedHorizontal(4) & seen_fused)) {
                    RSYM = 0;
                }
                if ((TileLoader.ruin4 & seen_fused) != (getRuinReversedHorizontal(4) & seen_fused)) {
                    RSYM = 0;
                }
                seen_fused = TileLoader.seen5 & getSeenReversedHorizontal(5);
                if ((TileLoader.wall5 & seen_fused) != (getWallReversedHorizontal(5) & seen_fused)) {
                    RSYM = 0;
                }
                if ((TileLoader.ruin5 & seen_fused) != (getRuinReversedHorizontal(5) & seen_fused)) {
                    RSYM = 0;
                }
                seen_fused = TileLoader.seen6 & getSeenReversedHorizontal(6);
                if ((TileLoader.wall6 & seen_fused) != (getWallReversedHorizontal(6) & seen_fused)) {
                    RSYM = 0;
                }
                if ((TileLoader.ruin6 & seen_fused) != (getRuinReversedHorizontal(6) & seen_fused)) {
                    RSYM = 0;
                }
                
            }
            case 3 -> {
                seen_fused = TileLoader.seen0 & getSeenReversedHorizontal(0);
                if ((TileLoader.wall0 & seen_fused) != (getWallReversedHorizontal(0) & seen_fused)) {
                    RSYM = 0;
                }
                if ((TileLoader.ruin0 & seen_fused) != (getRuinReversedHorizontal(0) & seen_fused)) {
                    RSYM = 0;
                }
                seen_fused = TileLoader.seen1 & getSeenReversedHorizontal(1);
                if ((TileLoader.wall1 & seen_fused) != (getWallReversedHorizontal(1) & seen_fused)) {
                    RSYM = 0;
                }
                if ((TileLoader.ruin1 & seen_fused) != (getRuinReversedHorizontal(1) & seen_fused)) {
                    RSYM = 0;
                }
                seen_fused = TileLoader.seen2 & getSeenReversedHorizontal(2);
                if ((TileLoader.wall2 & seen_fused) != (getWallReversedHorizontal(2) & seen_fused)) {
                    RSYM = 0;
                }
                if ((TileLoader.ruin2 & seen_fused) != (getRuinReversedHorizontal(2) & seen_fused)) {
                    RSYM = 0;
                }
                seen_fused = TileLoader.seen3 & getSeenReversedHorizontal(3);
                if ((TileLoader.wall3 & seen_fused) != (getWallReversedHorizontal(3) & seen_fused)) {
                    RSYM = 0;
                }
                if ((TileLoader.ruin3 & seen_fused) != (getRuinReversedHorizontal(3) & seen_fused)) {
                    RSYM = 0;
                }
                seen_fused = TileLoader.seen4 & getSeenReversedHorizontal(4);
                if ((TileLoader.wall4 & seen_fused) != (getWallReversedHorizontal(4) & seen_fused)) {
                    RSYM = 0;
                }
                if ((TileLoader.ruin4 & seen_fused) != (getRuinReversedHorizontal(4) & seen_fused)) {
                    RSYM = 0;
                }
                seen_fused = TileLoader.seen5 & getSeenReversedHorizontal(5);
                if ((TileLoader.wall5 & seen_fused) != (getWallReversedHorizontal(5) & seen_fused)) {
                    RSYM = 0;
                }
                if ((TileLoader.ruin5 & seen_fused) != (getRuinReversedHorizontal(5) & seen_fused)) {
                    RSYM = 0;
                }
                seen_fused = TileLoader.seen6 & getSeenReversedHorizontal(6);
                if ((TileLoader.wall6 & seen_fused) != (getWallReversedHorizontal(6) & seen_fused)) {
                    RSYM = 0;
                }
                if ((TileLoader.ruin6 & seen_fused) != (getRuinReversedHorizontal(6) & seen_fused)) {
                    RSYM = 0;
                }
                seen_fused = TileLoader.seen7 & getSeenReversedHorizontal(7);
                if ((TileLoader.wall7 & seen_fused) != (getWallReversedHorizontal(7) & seen_fused)) {
                    RSYM = 0;
                }
                if ((TileLoader.ruin7 & seen_fused) != (getRuinReversedHorizontal(7) & seen_fused)) {
                    RSYM = 0;
                }
                
            }
            case 4 -> {
                seen_fused = TileLoader.seen0 & getSeenReversedHorizontal(0);
                if ((TileLoader.wall0 & seen_fused) != (getWallReversedHorizontal(0) & seen_fused)) {
                    RSYM = 0;
                }
                if ((TileLoader.ruin0 & seen_fused) != (getRuinReversedHorizontal(0) & seen_fused)) {
                    RSYM = 0;
                }
                seen_fused = TileLoader.seen1 & getSeenReversedHorizontal(1);
                if ((TileLoader.wall1 & seen_fused) != (getWallReversedHorizontal(1) & seen_fused)) {
                    RSYM = 0;
                }
                if ((TileLoader.ruin1 & seen_fused) != (getRuinReversedHorizontal(1) & seen_fused)) {
                    RSYM = 0;
                }
                seen_fused = TileLoader.seen2 & getSeenReversedHorizontal(2);
                if ((TileLoader.wall2 & seen_fused) != (getWallReversedHorizontal(2) & seen_fused)) {
                    RSYM = 0;
                }
                if ((TileLoader.ruin2 & seen_fused) != (getRuinReversedHorizontal(2) & seen_fused)) {
                    RSYM = 0;
                }
                seen_fused = TileLoader.seen3 & getSeenReversedHorizontal(3);
                if ((TileLoader.wall3 & seen_fused) != (getWallReversedHorizontal(3) & seen_fused)) {
                    RSYM = 0;
                }
                if ((TileLoader.ruin3 & seen_fused) != (getRuinReversedHorizontal(3) & seen_fused)) {
                    RSYM = 0;
                }
                seen_fused = TileLoader.seen4 & getSeenReversedHorizontal(4);
                if ((TileLoader.wall4 & seen_fused) != (getWallReversedHorizontal(4) & seen_fused)) {
                    RSYM = 0;
                }
                if ((TileLoader.ruin4 & seen_fused) != (getRuinReversedHorizontal(4) & seen_fused)) {
                    RSYM = 0;
                }
                seen_fused = TileLoader.seen5 & getSeenReversedHorizontal(5);
                if ((TileLoader.wall5 & seen_fused) != (getWallReversedHorizontal(5) & seen_fused)) {
                    RSYM = 0;
                }
                if ((TileLoader.ruin5 & seen_fused) != (getRuinReversedHorizontal(5) & seen_fused)) {
                    RSYM = 0;
                }
                seen_fused = TileLoader.seen6 & getSeenReversedHorizontal(6);
                if ((TileLoader.wall6 & seen_fused) != (getWallReversedHorizontal(6) & seen_fused)) {
                    RSYM = 0;
                }
                if ((TileLoader.ruin6 & seen_fused) != (getRuinReversedHorizontal(6) & seen_fused)) {
                    RSYM = 0;
                }
                seen_fused = TileLoader.seen7 & getSeenReversedHorizontal(7);
                if ((TileLoader.wall7 & seen_fused) != (getWallReversedHorizontal(7) & seen_fused)) {
                    RSYM = 0;
                }
                if ((TileLoader.ruin7 & seen_fused) != (getRuinReversedHorizontal(7) & seen_fused)) {
                    RSYM = 0;
                }
                seen_fused = TileLoader.seen8 & getSeenReversedHorizontal(8);
                if ((TileLoader.wall8 & seen_fused) != (getWallReversedHorizontal(8) & seen_fused)) {
                    RSYM = 0;
                }
                if ((TileLoader.ruin8 & seen_fused) != (getRuinReversedHorizontal(8) & seen_fused)) {
                    RSYM = 0;
                }
                
            }
            case 5 -> {
                seen_fused = TileLoader.seen1 & getSeenReversedHorizontal(1);
                if ((TileLoader.wall1 & seen_fused) != (getWallReversedHorizontal(1) & seen_fused)) {
                    RSYM = 0;
                }
                if ((TileLoader.ruin1 & seen_fused) != (getRuinReversedHorizontal(1) & seen_fused)) {
                    RSYM = 0;
                }
                seen_fused = TileLoader.seen2 & getSeenReversedHorizontal(2);
                if ((TileLoader.wall2 & seen_fused) != (getWallReversedHorizontal(2) & seen_fused)) {
                    RSYM = 0;
                }
                if ((TileLoader.ruin2 & seen_fused) != (getRuinReversedHorizontal(2) & seen_fused)) {
                    RSYM = 0;
                }
                seen_fused = TileLoader.seen3 & getSeenReversedHorizontal(3);
                if ((TileLoader.wall3 & seen_fused) != (getWallReversedHorizontal(3) & seen_fused)) {
                    RSYM = 0;
                }
                if ((TileLoader.ruin3 & seen_fused) != (getRuinReversedHorizontal(3) & seen_fused)) {
                    RSYM = 0;
                }
                seen_fused = TileLoader.seen4 & getSeenReversedHorizontal(4);
                if ((TileLoader.wall4 & seen_fused) != (getWallReversedHorizontal(4) & seen_fused)) {
                    RSYM = 0;
                }
                if ((TileLoader.ruin4 & seen_fused) != (getRuinReversedHorizontal(4) & seen_fused)) {
                    RSYM = 0;
                }
                seen_fused = TileLoader.seen5 & getSeenReversedHorizontal(5);
                if ((TileLoader.wall5 & seen_fused) != (getWallReversedHorizontal(5) & seen_fused)) {
                    RSYM = 0;
                }
                if ((TileLoader.ruin5 & seen_fused) != (getRuinReversedHorizontal(5) & seen_fused)) {
                    RSYM = 0;
                }
                seen_fused = TileLoader.seen6 & getSeenReversedHorizontal(6);
                if ((TileLoader.wall6 & seen_fused) != (getWallReversedHorizontal(6) & seen_fused)) {
                    RSYM = 0;
                }
                if ((TileLoader.ruin6 & seen_fused) != (getRuinReversedHorizontal(6) & seen_fused)) {
                    RSYM = 0;
                }
                seen_fused = TileLoader.seen7 & getSeenReversedHorizontal(7);
                if ((TileLoader.wall7 & seen_fused) != (getWallReversedHorizontal(7) & seen_fused)) {
                    RSYM = 0;
                }
                if ((TileLoader.ruin7 & seen_fused) != (getRuinReversedHorizontal(7) & seen_fused)) {
                    RSYM = 0;
                }
                seen_fused = TileLoader.seen8 & getSeenReversedHorizontal(8);
                if ((TileLoader.wall8 & seen_fused) != (getWallReversedHorizontal(8) & seen_fused)) {
                    RSYM = 0;
                }
                if ((TileLoader.ruin8 & seen_fused) != (getRuinReversedHorizontal(8) & seen_fused)) {
                    RSYM = 0;
                }
                seen_fused = TileLoader.seen9 & getSeenReversedHorizontal(9);
                if ((TileLoader.wall9 & seen_fused) != (getWallReversedHorizontal(9) & seen_fused)) {
                    RSYM = 0;
                }
                if ((TileLoader.ruin9 & seen_fused) != (getRuinReversedHorizontal(9) & seen_fused)) {
                    RSYM = 0;
                }
                
            }
            case 6 -> {
                seen_fused = TileLoader.seen2 & getSeenReversedHorizontal(2);
                if ((TileLoader.wall2 & seen_fused) != (getWallReversedHorizontal(2) & seen_fused)) {
                    RSYM = 0;
                }
                if ((TileLoader.ruin2 & seen_fused) != (getRuinReversedHorizontal(2) & seen_fused)) {
                    RSYM = 0;
                }
                seen_fused = TileLoader.seen3 & getSeenReversedHorizontal(3);
                if ((TileLoader.wall3 & seen_fused) != (getWallReversedHorizontal(3) & seen_fused)) {
                    RSYM = 0;
                }
                if ((TileLoader.ruin3 & seen_fused) != (getRuinReversedHorizontal(3) & seen_fused)) {
                    RSYM = 0;
                }
                seen_fused = TileLoader.seen4 & getSeenReversedHorizontal(4);
                if ((TileLoader.wall4 & seen_fused) != (getWallReversedHorizontal(4) & seen_fused)) {
                    RSYM = 0;
                }
                if ((TileLoader.ruin4 & seen_fused) != (getRuinReversedHorizontal(4) & seen_fused)) {
                    RSYM = 0;
                }
                seen_fused = TileLoader.seen5 & getSeenReversedHorizontal(5);
                if ((TileLoader.wall5 & seen_fused) != (getWallReversedHorizontal(5) & seen_fused)) {
                    RSYM = 0;
                }
                if ((TileLoader.ruin5 & seen_fused) != (getRuinReversedHorizontal(5) & seen_fused)) {
                    RSYM = 0;
                }
                seen_fused = TileLoader.seen6 & getSeenReversedHorizontal(6);
                if ((TileLoader.wall6 & seen_fused) != (getWallReversedHorizontal(6) & seen_fused)) {
                    RSYM = 0;
                }
                if ((TileLoader.ruin6 & seen_fused) != (getRuinReversedHorizontal(6) & seen_fused)) {
                    RSYM = 0;
                }
                seen_fused = TileLoader.seen7 & getSeenReversedHorizontal(7);
                if ((TileLoader.wall7 & seen_fused) != (getWallReversedHorizontal(7) & seen_fused)) {
                    RSYM = 0;
                }
                if ((TileLoader.ruin7 & seen_fused) != (getRuinReversedHorizontal(7) & seen_fused)) {
                    RSYM = 0;
                }
                seen_fused = TileLoader.seen8 & getSeenReversedHorizontal(8);
                if ((TileLoader.wall8 & seen_fused) != (getWallReversedHorizontal(8) & seen_fused)) {
                    RSYM = 0;
                }
                if ((TileLoader.ruin8 & seen_fused) != (getRuinReversedHorizontal(8) & seen_fused)) {
                    RSYM = 0;
                }
                seen_fused = TileLoader.seen9 & getSeenReversedHorizontal(9);
                if ((TileLoader.wall9 & seen_fused) != (getWallReversedHorizontal(9) & seen_fused)) {
                    RSYM = 0;
                }
                if ((TileLoader.ruin9 & seen_fused) != (getRuinReversedHorizontal(9) & seen_fused)) {
                    RSYM = 0;
                }
                seen_fused = TileLoader.seen10 & getSeenReversedHorizontal(10);
                if ((TileLoader.wall10 & seen_fused) != (getWallReversedHorizontal(10) & seen_fused)) {
                    RSYM = 0;
                }
                if ((TileLoader.ruin10 & seen_fused) != (getRuinReversedHorizontal(10) & seen_fused)) {
                    RSYM = 0;
                }
                
            }
            case 7 -> {
                seen_fused = TileLoader.seen3 & getSeenReversedHorizontal(3);
                if ((TileLoader.wall3 & seen_fused) != (getWallReversedHorizontal(3) & seen_fused)) {
                    RSYM = 0;
                }
                if ((TileLoader.ruin3 & seen_fused) != (getRuinReversedHorizontal(3) & seen_fused)) {
                    RSYM = 0;
                }
                seen_fused = TileLoader.seen4 & getSeenReversedHorizontal(4);
                if ((TileLoader.wall4 & seen_fused) != (getWallReversedHorizontal(4) & seen_fused)) {
                    RSYM = 0;
                }
                if ((TileLoader.ruin4 & seen_fused) != (getRuinReversedHorizontal(4) & seen_fused)) {
                    RSYM = 0;
                }
                seen_fused = TileLoader.seen5 & getSeenReversedHorizontal(5);
                if ((TileLoader.wall5 & seen_fused) != (getWallReversedHorizontal(5) & seen_fused)) {
                    RSYM = 0;
                }
                if ((TileLoader.ruin5 & seen_fused) != (getRuinReversedHorizontal(5) & seen_fused)) {
                    RSYM = 0;
                }
                seen_fused = TileLoader.seen6 & getSeenReversedHorizontal(6);
                if ((TileLoader.wall6 & seen_fused) != (getWallReversedHorizontal(6) & seen_fused)) {
                    RSYM = 0;
                }
                if ((TileLoader.ruin6 & seen_fused) != (getRuinReversedHorizontal(6) & seen_fused)) {
                    RSYM = 0;
                }
                seen_fused = TileLoader.seen7 & getSeenReversedHorizontal(7);
                if ((TileLoader.wall7 & seen_fused) != (getWallReversedHorizontal(7) & seen_fused)) {
                    RSYM = 0;
                }
                if ((TileLoader.ruin7 & seen_fused) != (getRuinReversedHorizontal(7) & seen_fused)) {
                    RSYM = 0;
                }
                seen_fused = TileLoader.seen8 & getSeenReversedHorizontal(8);
                if ((TileLoader.wall8 & seen_fused) != (getWallReversedHorizontal(8) & seen_fused)) {
                    RSYM = 0;
                }
                if ((TileLoader.ruin8 & seen_fused) != (getRuinReversedHorizontal(8) & seen_fused)) {
                    RSYM = 0;
                }
                seen_fused = TileLoader.seen9 & getSeenReversedHorizontal(9);
                if ((TileLoader.wall9 & seen_fused) != (getWallReversedHorizontal(9) & seen_fused)) {
                    RSYM = 0;
                }
                if ((TileLoader.ruin9 & seen_fused) != (getRuinReversedHorizontal(9) & seen_fused)) {
                    RSYM = 0;
                }
                seen_fused = TileLoader.seen10 & getSeenReversedHorizontal(10);
                if ((TileLoader.wall10 & seen_fused) != (getWallReversedHorizontal(10) & seen_fused)) {
                    RSYM = 0;
                }
                if ((TileLoader.ruin10 & seen_fused) != (getRuinReversedHorizontal(10) & seen_fused)) {
                    RSYM = 0;
                }
                seen_fused = TileLoader.seen11 & getSeenReversedHorizontal(11);
                if ((TileLoader.wall11 & seen_fused) != (getWallReversedHorizontal(11) & seen_fused)) {
                    RSYM = 0;
                }
                if ((TileLoader.ruin11 & seen_fused) != (getRuinReversedHorizontal(11) & seen_fused)) {
                    RSYM = 0;
                }
                
            }
            case 8 -> {
                seen_fused = TileLoader.seen4 & getSeenReversedHorizontal(4);
                if ((TileLoader.wall4 & seen_fused) != (getWallReversedHorizontal(4) & seen_fused)) {
                    RSYM = 0;
                }
                if ((TileLoader.ruin4 & seen_fused) != (getRuinReversedHorizontal(4) & seen_fused)) {
                    RSYM = 0;
                }
                seen_fused = TileLoader.seen5 & getSeenReversedHorizontal(5);
                if ((TileLoader.wall5 & seen_fused) != (getWallReversedHorizontal(5) & seen_fused)) {
                    RSYM = 0;
                }
                if ((TileLoader.ruin5 & seen_fused) != (getRuinReversedHorizontal(5) & seen_fused)) {
                    RSYM = 0;
                }
                seen_fused = TileLoader.seen6 & getSeenReversedHorizontal(6);
                if ((TileLoader.wall6 & seen_fused) != (getWallReversedHorizontal(6) & seen_fused)) {
                    RSYM = 0;
                }
                if ((TileLoader.ruin6 & seen_fused) != (getRuinReversedHorizontal(6) & seen_fused)) {
                    RSYM = 0;
                }
                seen_fused = TileLoader.seen7 & getSeenReversedHorizontal(7);
                if ((TileLoader.wall7 & seen_fused) != (getWallReversedHorizontal(7) & seen_fused)) {
                    RSYM = 0;
                }
                if ((TileLoader.ruin7 & seen_fused) != (getRuinReversedHorizontal(7) & seen_fused)) {
                    RSYM = 0;
                }
                seen_fused = TileLoader.seen8 & getSeenReversedHorizontal(8);
                if ((TileLoader.wall8 & seen_fused) != (getWallReversedHorizontal(8) & seen_fused)) {
                    RSYM = 0;
                }
                if ((TileLoader.ruin8 & seen_fused) != (getRuinReversedHorizontal(8) & seen_fused)) {
                    RSYM = 0;
                }
                seen_fused = TileLoader.seen9 & getSeenReversedHorizontal(9);
                if ((TileLoader.wall9 & seen_fused) != (getWallReversedHorizontal(9) & seen_fused)) {
                    RSYM = 0;
                }
                if ((TileLoader.ruin9 & seen_fused) != (getRuinReversedHorizontal(9) & seen_fused)) {
                    RSYM = 0;
                }
                seen_fused = TileLoader.seen10 & getSeenReversedHorizontal(10);
                if ((TileLoader.wall10 & seen_fused) != (getWallReversedHorizontal(10) & seen_fused)) {
                    RSYM = 0;
                }
                if ((TileLoader.ruin10 & seen_fused) != (getRuinReversedHorizontal(10) & seen_fused)) {
                    RSYM = 0;
                }
                seen_fused = TileLoader.seen11 & getSeenReversedHorizontal(11);
                if ((TileLoader.wall11 & seen_fused) != (getWallReversedHorizontal(11) & seen_fused)) {
                    RSYM = 0;
                }
                if ((TileLoader.ruin11 & seen_fused) != (getRuinReversedHorizontal(11) & seen_fused)) {
                    RSYM = 0;
                }
                seen_fused = TileLoader.seen12 & getSeenReversedHorizontal(12);
                if ((TileLoader.wall12 & seen_fused) != (getWallReversedHorizontal(12) & seen_fused)) {
                    RSYM = 0;
                }
                if ((TileLoader.ruin12 & seen_fused) != (getRuinReversedHorizontal(12) & seen_fused)) {
                    RSYM = 0;
                }
                
            }
            case 9 -> {
                seen_fused = TileLoader.seen5 & getSeenReversedHorizontal(5);
                if ((TileLoader.wall5 & seen_fused) != (getWallReversedHorizontal(5) & seen_fused)) {
                    RSYM = 0;
                }
                if ((TileLoader.ruin5 & seen_fused) != (getRuinReversedHorizontal(5) & seen_fused)) {
                    RSYM = 0;
                }
                seen_fused = TileLoader.seen6 & getSeenReversedHorizontal(6);
                if ((TileLoader.wall6 & seen_fused) != (getWallReversedHorizontal(6) & seen_fused)) {
                    RSYM = 0;
                }
                if ((TileLoader.ruin6 & seen_fused) != (getRuinReversedHorizontal(6) & seen_fused)) {
                    RSYM = 0;
                }
                seen_fused = TileLoader.seen7 & getSeenReversedHorizontal(7);
                if ((TileLoader.wall7 & seen_fused) != (getWallReversedHorizontal(7) & seen_fused)) {
                    RSYM = 0;
                }
                if ((TileLoader.ruin7 & seen_fused) != (getRuinReversedHorizontal(7) & seen_fused)) {
                    RSYM = 0;
                }
                seen_fused = TileLoader.seen8 & getSeenReversedHorizontal(8);
                if ((TileLoader.wall8 & seen_fused) != (getWallReversedHorizontal(8) & seen_fused)) {
                    RSYM = 0;
                }
                if ((TileLoader.ruin8 & seen_fused) != (getRuinReversedHorizontal(8) & seen_fused)) {
                    RSYM = 0;
                }
                seen_fused = TileLoader.seen9 & getSeenReversedHorizontal(9);
                if ((TileLoader.wall9 & seen_fused) != (getWallReversedHorizontal(9) & seen_fused)) {
                    RSYM = 0;
                }
                if ((TileLoader.ruin9 & seen_fused) != (getRuinReversedHorizontal(9) & seen_fused)) {
                    RSYM = 0;
                }
                seen_fused = TileLoader.seen10 & getSeenReversedHorizontal(10);
                if ((TileLoader.wall10 & seen_fused) != (getWallReversedHorizontal(10) & seen_fused)) {
                    RSYM = 0;
                }
                if ((TileLoader.ruin10 & seen_fused) != (getRuinReversedHorizontal(10) & seen_fused)) {
                    RSYM = 0;
                }
                seen_fused = TileLoader.seen11 & getSeenReversedHorizontal(11);
                if ((TileLoader.wall11 & seen_fused) != (getWallReversedHorizontal(11) & seen_fused)) {
                    RSYM = 0;
                }
                if ((TileLoader.ruin11 & seen_fused) != (getRuinReversedHorizontal(11) & seen_fused)) {
                    RSYM = 0;
                }
                seen_fused = TileLoader.seen12 & getSeenReversedHorizontal(12);
                if ((TileLoader.wall12 & seen_fused) != (getWallReversedHorizontal(12) & seen_fused)) {
                    RSYM = 0;
                }
                if ((TileLoader.ruin12 & seen_fused) != (getRuinReversedHorizontal(12) & seen_fused)) {
                    RSYM = 0;
                }
                seen_fused = TileLoader.seen13 & getSeenReversedHorizontal(13);
                if ((TileLoader.wall13 & seen_fused) != (getWallReversedHorizontal(13) & seen_fused)) {
                    RSYM = 0;
                }
                if ((TileLoader.ruin13 & seen_fused) != (getRuinReversedHorizontal(13) & seen_fused)) {
                    RSYM = 0;
                }
                
            }
            case 10 -> {
                seen_fused = TileLoader.seen6 & getSeenReversedHorizontal(6);
                if ((TileLoader.wall6 & seen_fused) != (getWallReversedHorizontal(6) & seen_fused)) {
                    RSYM = 0;
                }
                if ((TileLoader.ruin6 & seen_fused) != (getRuinReversedHorizontal(6) & seen_fused)) {
                    RSYM = 0;
                }
                seen_fused = TileLoader.seen7 & getSeenReversedHorizontal(7);
                if ((TileLoader.wall7 & seen_fused) != (getWallReversedHorizontal(7) & seen_fused)) {
                    RSYM = 0;
                }
                if ((TileLoader.ruin7 & seen_fused) != (getRuinReversedHorizontal(7) & seen_fused)) {
                    RSYM = 0;
                }
                seen_fused = TileLoader.seen8 & getSeenReversedHorizontal(8);
                if ((TileLoader.wall8 & seen_fused) != (getWallReversedHorizontal(8) & seen_fused)) {
                    RSYM = 0;
                }
                if ((TileLoader.ruin8 & seen_fused) != (getRuinReversedHorizontal(8) & seen_fused)) {
                    RSYM = 0;
                }
                seen_fused = TileLoader.seen9 & getSeenReversedHorizontal(9);
                if ((TileLoader.wall9 & seen_fused) != (getWallReversedHorizontal(9) & seen_fused)) {
                    RSYM = 0;
                }
                if ((TileLoader.ruin9 & seen_fused) != (getRuinReversedHorizontal(9) & seen_fused)) {
                    RSYM = 0;
                }
                seen_fused = TileLoader.seen10 & getSeenReversedHorizontal(10);
                if ((TileLoader.wall10 & seen_fused) != (getWallReversedHorizontal(10) & seen_fused)) {
                    RSYM = 0;
                }
                if ((TileLoader.ruin10 & seen_fused) != (getRuinReversedHorizontal(10) & seen_fused)) {
                    RSYM = 0;
                }
                seen_fused = TileLoader.seen11 & getSeenReversedHorizontal(11);
                if ((TileLoader.wall11 & seen_fused) != (getWallReversedHorizontal(11) & seen_fused)) {
                    RSYM = 0;
                }
                if ((TileLoader.ruin11 & seen_fused) != (getRuinReversedHorizontal(11) & seen_fused)) {
                    RSYM = 0;
                }
                seen_fused = TileLoader.seen12 & getSeenReversedHorizontal(12);
                if ((TileLoader.wall12 & seen_fused) != (getWallReversedHorizontal(12) & seen_fused)) {
                    RSYM = 0;
                }
                if ((TileLoader.ruin12 & seen_fused) != (getRuinReversedHorizontal(12) & seen_fused)) {
                    RSYM = 0;
                }
                seen_fused = TileLoader.seen13 & getSeenReversedHorizontal(13);
                if ((TileLoader.wall13 & seen_fused) != (getWallReversedHorizontal(13) & seen_fused)) {
                    RSYM = 0;
                }
                if ((TileLoader.ruin13 & seen_fused) != (getRuinReversedHorizontal(13) & seen_fused)) {
                    RSYM = 0;
                }
                seen_fused = TileLoader.seen14 & getSeenReversedHorizontal(14);
                if ((TileLoader.wall14 & seen_fused) != (getWallReversedHorizontal(14) & seen_fused)) {
                    RSYM = 0;
                }
                if ((TileLoader.ruin14 & seen_fused) != (getRuinReversedHorizontal(14) & seen_fused)) {
                    RSYM = 0;
                }
                
            }
            case 11 -> {
                seen_fused = TileLoader.seen7 & getSeenReversedHorizontal(7);
                if ((TileLoader.wall7 & seen_fused) != (getWallReversedHorizontal(7) & seen_fused)) {
                    RSYM = 0;
                }
                if ((TileLoader.ruin7 & seen_fused) != (getRuinReversedHorizontal(7) & seen_fused)) {
                    RSYM = 0;
                }
                seen_fused = TileLoader.seen8 & getSeenReversedHorizontal(8);
                if ((TileLoader.wall8 & seen_fused) != (getWallReversedHorizontal(8) & seen_fused)) {
                    RSYM = 0;
                }
                if ((TileLoader.ruin8 & seen_fused) != (getRuinReversedHorizontal(8) & seen_fused)) {
                    RSYM = 0;
                }
                seen_fused = TileLoader.seen9 & getSeenReversedHorizontal(9);
                if ((TileLoader.wall9 & seen_fused) != (getWallReversedHorizontal(9) & seen_fused)) {
                    RSYM = 0;
                }
                if ((TileLoader.ruin9 & seen_fused) != (getRuinReversedHorizontal(9) & seen_fused)) {
                    RSYM = 0;
                }
                seen_fused = TileLoader.seen10 & getSeenReversedHorizontal(10);
                if ((TileLoader.wall10 & seen_fused) != (getWallReversedHorizontal(10) & seen_fused)) {
                    RSYM = 0;
                }
                if ((TileLoader.ruin10 & seen_fused) != (getRuinReversedHorizontal(10) & seen_fused)) {
                    RSYM = 0;
                }
                seen_fused = TileLoader.seen11 & getSeenReversedHorizontal(11);
                if ((TileLoader.wall11 & seen_fused) != (getWallReversedHorizontal(11) & seen_fused)) {
                    RSYM = 0;
                }
                if ((TileLoader.ruin11 & seen_fused) != (getRuinReversedHorizontal(11) & seen_fused)) {
                    RSYM = 0;
                }
                seen_fused = TileLoader.seen12 & getSeenReversedHorizontal(12);
                if ((TileLoader.wall12 & seen_fused) != (getWallReversedHorizontal(12) & seen_fused)) {
                    RSYM = 0;
                }
                if ((TileLoader.ruin12 & seen_fused) != (getRuinReversedHorizontal(12) & seen_fused)) {
                    RSYM = 0;
                }
                seen_fused = TileLoader.seen13 & getSeenReversedHorizontal(13);
                if ((TileLoader.wall13 & seen_fused) != (getWallReversedHorizontal(13) & seen_fused)) {
                    RSYM = 0;
                }
                if ((TileLoader.ruin13 & seen_fused) != (getRuinReversedHorizontal(13) & seen_fused)) {
                    RSYM = 0;
                }
                seen_fused = TileLoader.seen14 & getSeenReversedHorizontal(14);
                if ((TileLoader.wall14 & seen_fused) != (getWallReversedHorizontal(14) & seen_fused)) {
                    RSYM = 0;
                }
                if ((TileLoader.ruin14 & seen_fused) != (getRuinReversedHorizontal(14) & seen_fused)) {
                    RSYM = 0;
                }
                seen_fused = TileLoader.seen15 & getSeenReversedHorizontal(15);
                if ((TileLoader.wall15 & seen_fused) != (getWallReversedHorizontal(15) & seen_fused)) {
                    RSYM = 0;
                }
                if ((TileLoader.ruin15 & seen_fused) != (getRuinReversedHorizontal(15) & seen_fused)) {
                    RSYM = 0;
                }
                
            }
            case 12 -> {
                seen_fused = TileLoader.seen8 & getSeenReversedHorizontal(8);
                if ((TileLoader.wall8 & seen_fused) != (getWallReversedHorizontal(8) & seen_fused)) {
                    RSYM = 0;
                }
                if ((TileLoader.ruin8 & seen_fused) != (getRuinReversedHorizontal(8) & seen_fused)) {
                    RSYM = 0;
                }
                seen_fused = TileLoader.seen9 & getSeenReversedHorizontal(9);
                if ((TileLoader.wall9 & seen_fused) != (getWallReversedHorizontal(9) & seen_fused)) {
                    RSYM = 0;
                }
                if ((TileLoader.ruin9 & seen_fused) != (getRuinReversedHorizontal(9) & seen_fused)) {
                    RSYM = 0;
                }
                seen_fused = TileLoader.seen10 & getSeenReversedHorizontal(10);
                if ((TileLoader.wall10 & seen_fused) != (getWallReversedHorizontal(10) & seen_fused)) {
                    RSYM = 0;
                }
                if ((TileLoader.ruin10 & seen_fused) != (getRuinReversedHorizontal(10) & seen_fused)) {
                    RSYM = 0;
                }
                seen_fused = TileLoader.seen11 & getSeenReversedHorizontal(11);
                if ((TileLoader.wall11 & seen_fused) != (getWallReversedHorizontal(11) & seen_fused)) {
                    RSYM = 0;
                }
                if ((TileLoader.ruin11 & seen_fused) != (getRuinReversedHorizontal(11) & seen_fused)) {
                    RSYM = 0;
                }
                seen_fused = TileLoader.seen12 & getSeenReversedHorizontal(12);
                if ((TileLoader.wall12 & seen_fused) != (getWallReversedHorizontal(12) & seen_fused)) {
                    RSYM = 0;
                }
                if ((TileLoader.ruin12 & seen_fused) != (getRuinReversedHorizontal(12) & seen_fused)) {
                    RSYM = 0;
                }
                seen_fused = TileLoader.seen13 & getSeenReversedHorizontal(13);
                if ((TileLoader.wall13 & seen_fused) != (getWallReversedHorizontal(13) & seen_fused)) {
                    RSYM = 0;
                }
                if ((TileLoader.ruin13 & seen_fused) != (getRuinReversedHorizontal(13) & seen_fused)) {
                    RSYM = 0;
                }
                seen_fused = TileLoader.seen14 & getSeenReversedHorizontal(14);
                if ((TileLoader.wall14 & seen_fused) != (getWallReversedHorizontal(14) & seen_fused)) {
                    RSYM = 0;
                }
                if ((TileLoader.ruin14 & seen_fused) != (getRuinReversedHorizontal(14) & seen_fused)) {
                    RSYM = 0;
                }
                seen_fused = TileLoader.seen15 & getSeenReversedHorizontal(15);
                if ((TileLoader.wall15 & seen_fused) != (getWallReversedHorizontal(15) & seen_fused)) {
                    RSYM = 0;
                }
                if ((TileLoader.ruin15 & seen_fused) != (getRuinReversedHorizontal(15) & seen_fused)) {
                    RSYM = 0;
                }
                seen_fused = TileLoader.seen16 & getSeenReversedHorizontal(16);
                if ((TileLoader.wall16 & seen_fused) != (getWallReversedHorizontal(16) & seen_fused)) {
                    RSYM = 0;
                }
                if ((TileLoader.ruin16 & seen_fused) != (getRuinReversedHorizontal(16) & seen_fused)) {
                    RSYM = 0;
                }
                
            }
            case 13 -> {
                seen_fused = TileLoader.seen9 & getSeenReversedHorizontal(9);
                if ((TileLoader.wall9 & seen_fused) != (getWallReversedHorizontal(9) & seen_fused)) {
                    RSYM = 0;
                }
                if ((TileLoader.ruin9 & seen_fused) != (getRuinReversedHorizontal(9) & seen_fused)) {
                    RSYM = 0;
                }
                seen_fused = TileLoader.seen10 & getSeenReversedHorizontal(10);
                if ((TileLoader.wall10 & seen_fused) != (getWallReversedHorizontal(10) & seen_fused)) {
                    RSYM = 0;
                }
                if ((TileLoader.ruin10 & seen_fused) != (getRuinReversedHorizontal(10) & seen_fused)) {
                    RSYM = 0;
                }
                seen_fused = TileLoader.seen11 & getSeenReversedHorizontal(11);
                if ((TileLoader.wall11 & seen_fused) != (getWallReversedHorizontal(11) & seen_fused)) {
                    RSYM = 0;
                }
                if ((TileLoader.ruin11 & seen_fused) != (getRuinReversedHorizontal(11) & seen_fused)) {
                    RSYM = 0;
                }
                seen_fused = TileLoader.seen12 & getSeenReversedHorizontal(12);
                if ((TileLoader.wall12 & seen_fused) != (getWallReversedHorizontal(12) & seen_fused)) {
                    RSYM = 0;
                }
                if ((TileLoader.ruin12 & seen_fused) != (getRuinReversedHorizontal(12) & seen_fused)) {
                    RSYM = 0;
                }
                seen_fused = TileLoader.seen13 & getSeenReversedHorizontal(13);
                if ((TileLoader.wall13 & seen_fused) != (getWallReversedHorizontal(13) & seen_fused)) {
                    RSYM = 0;
                }
                if ((TileLoader.ruin13 & seen_fused) != (getRuinReversedHorizontal(13) & seen_fused)) {
                    RSYM = 0;
                }
                seen_fused = TileLoader.seen14 & getSeenReversedHorizontal(14);
                if ((TileLoader.wall14 & seen_fused) != (getWallReversedHorizontal(14) & seen_fused)) {
                    RSYM = 0;
                }
                if ((TileLoader.ruin14 & seen_fused) != (getRuinReversedHorizontal(14) & seen_fused)) {
                    RSYM = 0;
                }
                seen_fused = TileLoader.seen15 & getSeenReversedHorizontal(15);
                if ((TileLoader.wall15 & seen_fused) != (getWallReversedHorizontal(15) & seen_fused)) {
                    RSYM = 0;
                }
                if ((TileLoader.ruin15 & seen_fused) != (getRuinReversedHorizontal(15) & seen_fused)) {
                    RSYM = 0;
                }
                seen_fused = TileLoader.seen16 & getSeenReversedHorizontal(16);
                if ((TileLoader.wall16 & seen_fused) != (getWallReversedHorizontal(16) & seen_fused)) {
                    RSYM = 0;
                }
                if ((TileLoader.ruin16 & seen_fused) != (getRuinReversedHorizontal(16) & seen_fused)) {
                    RSYM = 0;
                }
                seen_fused = TileLoader.seen17 & getSeenReversedHorizontal(17);
                if ((TileLoader.wall17 & seen_fused) != (getWallReversedHorizontal(17) & seen_fused)) {
                    RSYM = 0;
                }
                if ((TileLoader.ruin17 & seen_fused) != (getRuinReversedHorizontal(17) & seen_fused)) {
                    RSYM = 0;
                }
                
            }
            case 14 -> {
                seen_fused = TileLoader.seen10 & getSeenReversedHorizontal(10);
                if ((TileLoader.wall10 & seen_fused) != (getWallReversedHorizontal(10) & seen_fused)) {
                    RSYM = 0;
                }
                if ((TileLoader.ruin10 & seen_fused) != (getRuinReversedHorizontal(10) & seen_fused)) {
                    RSYM = 0;
                }
                seen_fused = TileLoader.seen11 & getSeenReversedHorizontal(11);
                if ((TileLoader.wall11 & seen_fused) != (getWallReversedHorizontal(11) & seen_fused)) {
                    RSYM = 0;
                }
                if ((TileLoader.ruin11 & seen_fused) != (getRuinReversedHorizontal(11) & seen_fused)) {
                    RSYM = 0;
                }
                seen_fused = TileLoader.seen12 & getSeenReversedHorizontal(12);
                if ((TileLoader.wall12 & seen_fused) != (getWallReversedHorizontal(12) & seen_fused)) {
                    RSYM = 0;
                }
                if ((TileLoader.ruin12 & seen_fused) != (getRuinReversedHorizontal(12) & seen_fused)) {
                    RSYM = 0;
                }
                seen_fused = TileLoader.seen13 & getSeenReversedHorizontal(13);
                if ((TileLoader.wall13 & seen_fused) != (getWallReversedHorizontal(13) & seen_fused)) {
                    RSYM = 0;
                }
                if ((TileLoader.ruin13 & seen_fused) != (getRuinReversedHorizontal(13) & seen_fused)) {
                    RSYM = 0;
                }
                seen_fused = TileLoader.seen14 & getSeenReversedHorizontal(14);
                if ((TileLoader.wall14 & seen_fused) != (getWallReversedHorizontal(14) & seen_fused)) {
                    RSYM = 0;
                }
                if ((TileLoader.ruin14 & seen_fused) != (getRuinReversedHorizontal(14) & seen_fused)) {
                    RSYM = 0;
                }
                seen_fused = TileLoader.seen15 & getSeenReversedHorizontal(15);
                if ((TileLoader.wall15 & seen_fused) != (getWallReversedHorizontal(15) & seen_fused)) {
                    RSYM = 0;
                }
                if ((TileLoader.ruin15 & seen_fused) != (getRuinReversedHorizontal(15) & seen_fused)) {
                    RSYM = 0;
                }
                seen_fused = TileLoader.seen16 & getSeenReversedHorizontal(16);
                if ((TileLoader.wall16 & seen_fused) != (getWallReversedHorizontal(16) & seen_fused)) {
                    RSYM = 0;
                }
                if ((TileLoader.ruin16 & seen_fused) != (getRuinReversedHorizontal(16) & seen_fused)) {
                    RSYM = 0;
                }
                seen_fused = TileLoader.seen17 & getSeenReversedHorizontal(17);
                if ((TileLoader.wall17 & seen_fused) != (getWallReversedHorizontal(17) & seen_fused)) {
                    RSYM = 0;
                }
                if ((TileLoader.ruin17 & seen_fused) != (getRuinReversedHorizontal(17) & seen_fused)) {
                    RSYM = 0;
                }
                seen_fused = TileLoader.seen18 & getSeenReversedHorizontal(18);
                if ((TileLoader.wall18 & seen_fused) != (getWallReversedHorizontal(18) & seen_fused)) {
                    RSYM = 0;
                }
                if ((TileLoader.ruin18 & seen_fused) != (getRuinReversedHorizontal(18) & seen_fused)) {
                    RSYM = 0;
                }
                
            }
            case 15 -> {
                seen_fused = TileLoader.seen11 & getSeenReversedHorizontal(11);
                if ((TileLoader.wall11 & seen_fused) != (getWallReversedHorizontal(11) & seen_fused)) {
                    RSYM = 0;
                }
                if ((TileLoader.ruin11 & seen_fused) != (getRuinReversedHorizontal(11) & seen_fused)) {
                    RSYM = 0;
                }
                seen_fused = TileLoader.seen12 & getSeenReversedHorizontal(12);
                if ((TileLoader.wall12 & seen_fused) != (getWallReversedHorizontal(12) & seen_fused)) {
                    RSYM = 0;
                }
                if ((TileLoader.ruin12 & seen_fused) != (getRuinReversedHorizontal(12) & seen_fused)) {
                    RSYM = 0;
                }
                seen_fused = TileLoader.seen13 & getSeenReversedHorizontal(13);
                if ((TileLoader.wall13 & seen_fused) != (getWallReversedHorizontal(13) & seen_fused)) {
                    RSYM = 0;
                }
                if ((TileLoader.ruin13 & seen_fused) != (getRuinReversedHorizontal(13) & seen_fused)) {
                    RSYM = 0;
                }
                seen_fused = TileLoader.seen14 & getSeenReversedHorizontal(14);
                if ((TileLoader.wall14 & seen_fused) != (getWallReversedHorizontal(14) & seen_fused)) {
                    RSYM = 0;
                }
                if ((TileLoader.ruin14 & seen_fused) != (getRuinReversedHorizontal(14) & seen_fused)) {
                    RSYM = 0;
                }
                seen_fused = TileLoader.seen15 & getSeenReversedHorizontal(15);
                if ((TileLoader.wall15 & seen_fused) != (getWallReversedHorizontal(15) & seen_fused)) {
                    RSYM = 0;
                }
                if ((TileLoader.ruin15 & seen_fused) != (getRuinReversedHorizontal(15) & seen_fused)) {
                    RSYM = 0;
                }
                seen_fused = TileLoader.seen16 & getSeenReversedHorizontal(16);
                if ((TileLoader.wall16 & seen_fused) != (getWallReversedHorizontal(16) & seen_fused)) {
                    RSYM = 0;
                }
                if ((TileLoader.ruin16 & seen_fused) != (getRuinReversedHorizontal(16) & seen_fused)) {
                    RSYM = 0;
                }
                seen_fused = TileLoader.seen17 & getSeenReversedHorizontal(17);
                if ((TileLoader.wall17 & seen_fused) != (getWallReversedHorizontal(17) & seen_fused)) {
                    RSYM = 0;
                }
                if ((TileLoader.ruin17 & seen_fused) != (getRuinReversedHorizontal(17) & seen_fused)) {
                    RSYM = 0;
                }
                seen_fused = TileLoader.seen18 & getSeenReversedHorizontal(18);
                if ((TileLoader.wall18 & seen_fused) != (getWallReversedHorizontal(18) & seen_fused)) {
                    RSYM = 0;
                }
                if ((TileLoader.ruin18 & seen_fused) != (getRuinReversedHorizontal(18) & seen_fused)) {
                    RSYM = 0;
                }
                seen_fused = TileLoader.seen19 & getSeenReversedHorizontal(19);
                if ((TileLoader.wall19 & seen_fused) != (getWallReversedHorizontal(19) & seen_fused)) {
                    RSYM = 0;
                }
                if ((TileLoader.ruin19 & seen_fused) != (getRuinReversedHorizontal(19) & seen_fused)) {
                    RSYM = 0;
                }
                
            }
            case 16 -> {
                seen_fused = TileLoader.seen12 & getSeenReversedHorizontal(12);
                if ((TileLoader.wall12 & seen_fused) != (getWallReversedHorizontal(12) & seen_fused)) {
                    RSYM = 0;
                }
                if ((TileLoader.ruin12 & seen_fused) != (getRuinReversedHorizontal(12) & seen_fused)) {
                    RSYM = 0;
                }
                seen_fused = TileLoader.seen13 & getSeenReversedHorizontal(13);
                if ((TileLoader.wall13 & seen_fused) != (getWallReversedHorizontal(13) & seen_fused)) {
                    RSYM = 0;
                }
                if ((TileLoader.ruin13 & seen_fused) != (getRuinReversedHorizontal(13) & seen_fused)) {
                    RSYM = 0;
                }
                seen_fused = TileLoader.seen14 & getSeenReversedHorizontal(14);
                if ((TileLoader.wall14 & seen_fused) != (getWallReversedHorizontal(14) & seen_fused)) {
                    RSYM = 0;
                }
                if ((TileLoader.ruin14 & seen_fused) != (getRuinReversedHorizontal(14) & seen_fused)) {
                    RSYM = 0;
                }
                seen_fused = TileLoader.seen15 & getSeenReversedHorizontal(15);
                if ((TileLoader.wall15 & seen_fused) != (getWallReversedHorizontal(15) & seen_fused)) {
                    RSYM = 0;
                }
                if ((TileLoader.ruin15 & seen_fused) != (getRuinReversedHorizontal(15) & seen_fused)) {
                    RSYM = 0;
                }
                seen_fused = TileLoader.seen16 & getSeenReversedHorizontal(16);
                if ((TileLoader.wall16 & seen_fused) != (getWallReversedHorizontal(16) & seen_fused)) {
                    RSYM = 0;
                }
                if ((TileLoader.ruin16 & seen_fused) != (getRuinReversedHorizontal(16) & seen_fused)) {
                    RSYM = 0;
                }
                seen_fused = TileLoader.seen17 & getSeenReversedHorizontal(17);
                if ((TileLoader.wall17 & seen_fused) != (getWallReversedHorizontal(17) & seen_fused)) {
                    RSYM = 0;
                }
                if ((TileLoader.ruin17 & seen_fused) != (getRuinReversedHorizontal(17) & seen_fused)) {
                    RSYM = 0;
                }
                seen_fused = TileLoader.seen18 & getSeenReversedHorizontal(18);
                if ((TileLoader.wall18 & seen_fused) != (getWallReversedHorizontal(18) & seen_fused)) {
                    RSYM = 0;
                }
                if ((TileLoader.ruin18 & seen_fused) != (getRuinReversedHorizontal(18) & seen_fused)) {
                    RSYM = 0;
                }
                seen_fused = TileLoader.seen19 & getSeenReversedHorizontal(19);
                if ((TileLoader.wall19 & seen_fused) != (getWallReversedHorizontal(19) & seen_fused)) {
                    RSYM = 0;
                }
                if ((TileLoader.ruin19 & seen_fused) != (getRuinReversedHorizontal(19) & seen_fused)) {
                    RSYM = 0;
                }
                seen_fused = TileLoader.seen20 & getSeenReversedHorizontal(20);
                if ((TileLoader.wall20 & seen_fused) != (getWallReversedHorizontal(20) & seen_fused)) {
                    RSYM = 0;
                }
                if ((TileLoader.ruin20 & seen_fused) != (getRuinReversedHorizontal(20) & seen_fused)) {
                    RSYM = 0;
                }
                
            }
            case 17 -> {
                seen_fused = TileLoader.seen13 & getSeenReversedHorizontal(13);
                if ((TileLoader.wall13 & seen_fused) != (getWallReversedHorizontal(13) & seen_fused)) {
                    RSYM = 0;
                }
                if ((TileLoader.ruin13 & seen_fused) != (getRuinReversedHorizontal(13) & seen_fused)) {
                    RSYM = 0;
                }
                seen_fused = TileLoader.seen14 & getSeenReversedHorizontal(14);
                if ((TileLoader.wall14 & seen_fused) != (getWallReversedHorizontal(14) & seen_fused)) {
                    RSYM = 0;
                }
                if ((TileLoader.ruin14 & seen_fused) != (getRuinReversedHorizontal(14) & seen_fused)) {
                    RSYM = 0;
                }
                seen_fused = TileLoader.seen15 & getSeenReversedHorizontal(15);
                if ((TileLoader.wall15 & seen_fused) != (getWallReversedHorizontal(15) & seen_fused)) {
                    RSYM = 0;
                }
                if ((TileLoader.ruin15 & seen_fused) != (getRuinReversedHorizontal(15) & seen_fused)) {
                    RSYM = 0;
                }
                seen_fused = TileLoader.seen16 & getSeenReversedHorizontal(16);
                if ((TileLoader.wall16 & seen_fused) != (getWallReversedHorizontal(16) & seen_fused)) {
                    RSYM = 0;
                }
                if ((TileLoader.ruin16 & seen_fused) != (getRuinReversedHorizontal(16) & seen_fused)) {
                    RSYM = 0;
                }
                seen_fused = TileLoader.seen17 & getSeenReversedHorizontal(17);
                if ((TileLoader.wall17 & seen_fused) != (getWallReversedHorizontal(17) & seen_fused)) {
                    RSYM = 0;
                }
                if ((TileLoader.ruin17 & seen_fused) != (getRuinReversedHorizontal(17) & seen_fused)) {
                    RSYM = 0;
                }
                seen_fused = TileLoader.seen18 & getSeenReversedHorizontal(18);
                if ((TileLoader.wall18 & seen_fused) != (getWallReversedHorizontal(18) & seen_fused)) {
                    RSYM = 0;
                }
                if ((TileLoader.ruin18 & seen_fused) != (getRuinReversedHorizontal(18) & seen_fused)) {
                    RSYM = 0;
                }
                seen_fused = TileLoader.seen19 & getSeenReversedHorizontal(19);
                if ((TileLoader.wall19 & seen_fused) != (getWallReversedHorizontal(19) & seen_fused)) {
                    RSYM = 0;
                }
                if ((TileLoader.ruin19 & seen_fused) != (getRuinReversedHorizontal(19) & seen_fused)) {
                    RSYM = 0;
                }
                seen_fused = TileLoader.seen20 & getSeenReversedHorizontal(20);
                if ((TileLoader.wall20 & seen_fused) != (getWallReversedHorizontal(20) & seen_fused)) {
                    RSYM = 0;
                }
                if ((TileLoader.ruin20 & seen_fused) != (getRuinReversedHorizontal(20) & seen_fused)) {
                    RSYM = 0;
                }
                seen_fused = TileLoader.seen21 & getSeenReversedHorizontal(21);
                if ((TileLoader.wall21 & seen_fused) != (getWallReversedHorizontal(21) & seen_fused)) {
                    RSYM = 0;
                }
                if ((TileLoader.ruin21 & seen_fused) != (getRuinReversedHorizontal(21) & seen_fused)) {
                    RSYM = 0;
                }
                
            }
            case 18 -> {
                seen_fused = TileLoader.seen14 & getSeenReversedHorizontal(14);
                if ((TileLoader.wall14 & seen_fused) != (getWallReversedHorizontal(14) & seen_fused)) {
                    RSYM = 0;
                }
                if ((TileLoader.ruin14 & seen_fused) != (getRuinReversedHorizontal(14) & seen_fused)) {
                    RSYM = 0;
                }
                seen_fused = TileLoader.seen15 & getSeenReversedHorizontal(15);
                if ((TileLoader.wall15 & seen_fused) != (getWallReversedHorizontal(15) & seen_fused)) {
                    RSYM = 0;
                }
                if ((TileLoader.ruin15 & seen_fused) != (getRuinReversedHorizontal(15) & seen_fused)) {
                    RSYM = 0;
                }
                seen_fused = TileLoader.seen16 & getSeenReversedHorizontal(16);
                if ((TileLoader.wall16 & seen_fused) != (getWallReversedHorizontal(16) & seen_fused)) {
                    RSYM = 0;
                }
                if ((TileLoader.ruin16 & seen_fused) != (getRuinReversedHorizontal(16) & seen_fused)) {
                    RSYM = 0;
                }
                seen_fused = TileLoader.seen17 & getSeenReversedHorizontal(17);
                if ((TileLoader.wall17 & seen_fused) != (getWallReversedHorizontal(17) & seen_fused)) {
                    RSYM = 0;
                }
                if ((TileLoader.ruin17 & seen_fused) != (getRuinReversedHorizontal(17) & seen_fused)) {
                    RSYM = 0;
                }
                seen_fused = TileLoader.seen18 & getSeenReversedHorizontal(18);
                if ((TileLoader.wall18 & seen_fused) != (getWallReversedHorizontal(18) & seen_fused)) {
                    RSYM = 0;
                }
                if ((TileLoader.ruin18 & seen_fused) != (getRuinReversedHorizontal(18) & seen_fused)) {
                    RSYM = 0;
                }
                seen_fused = TileLoader.seen19 & getSeenReversedHorizontal(19);
                if ((TileLoader.wall19 & seen_fused) != (getWallReversedHorizontal(19) & seen_fused)) {
                    RSYM = 0;
                }
                if ((TileLoader.ruin19 & seen_fused) != (getRuinReversedHorizontal(19) & seen_fused)) {
                    RSYM = 0;
                }
                seen_fused = TileLoader.seen20 & getSeenReversedHorizontal(20);
                if ((TileLoader.wall20 & seen_fused) != (getWallReversedHorizontal(20) & seen_fused)) {
                    RSYM = 0;
                }
                if ((TileLoader.ruin20 & seen_fused) != (getRuinReversedHorizontal(20) & seen_fused)) {
                    RSYM = 0;
                }
                seen_fused = TileLoader.seen21 & getSeenReversedHorizontal(21);
                if ((TileLoader.wall21 & seen_fused) != (getWallReversedHorizontal(21) & seen_fused)) {
                    RSYM = 0;
                }
                if ((TileLoader.ruin21 & seen_fused) != (getRuinReversedHorizontal(21) & seen_fused)) {
                    RSYM = 0;
                }
                seen_fused = TileLoader.seen22 & getSeenReversedHorizontal(22);
                if ((TileLoader.wall22 & seen_fused) != (getWallReversedHorizontal(22) & seen_fused)) {
                    RSYM = 0;
                }
                if ((TileLoader.ruin22 & seen_fused) != (getRuinReversedHorizontal(22) & seen_fused)) {
                    RSYM = 0;
                }
                
            }
            case 19 -> {
                seen_fused = TileLoader.seen15 & getSeenReversedHorizontal(15);
                if ((TileLoader.wall15 & seen_fused) != (getWallReversedHorizontal(15) & seen_fused)) {
                    RSYM = 0;
                }
                if ((TileLoader.ruin15 & seen_fused) != (getRuinReversedHorizontal(15) & seen_fused)) {
                    RSYM = 0;
                }
                seen_fused = TileLoader.seen16 & getSeenReversedHorizontal(16);
                if ((TileLoader.wall16 & seen_fused) != (getWallReversedHorizontal(16) & seen_fused)) {
                    RSYM = 0;
                }
                if ((TileLoader.ruin16 & seen_fused) != (getRuinReversedHorizontal(16) & seen_fused)) {
                    RSYM = 0;
                }
                seen_fused = TileLoader.seen17 & getSeenReversedHorizontal(17);
                if ((TileLoader.wall17 & seen_fused) != (getWallReversedHorizontal(17) & seen_fused)) {
                    RSYM = 0;
                }
                if ((TileLoader.ruin17 & seen_fused) != (getRuinReversedHorizontal(17) & seen_fused)) {
                    RSYM = 0;
                }
                seen_fused = TileLoader.seen18 & getSeenReversedHorizontal(18);
                if ((TileLoader.wall18 & seen_fused) != (getWallReversedHorizontal(18) & seen_fused)) {
                    RSYM = 0;
                }
                if ((TileLoader.ruin18 & seen_fused) != (getRuinReversedHorizontal(18) & seen_fused)) {
                    RSYM = 0;
                }
                seen_fused = TileLoader.seen19 & getSeenReversedHorizontal(19);
                if ((TileLoader.wall19 & seen_fused) != (getWallReversedHorizontal(19) & seen_fused)) {
                    RSYM = 0;
                }
                if ((TileLoader.ruin19 & seen_fused) != (getRuinReversedHorizontal(19) & seen_fused)) {
                    RSYM = 0;
                }
                seen_fused = TileLoader.seen20 & getSeenReversedHorizontal(20);
                if ((TileLoader.wall20 & seen_fused) != (getWallReversedHorizontal(20) & seen_fused)) {
                    RSYM = 0;
                }
                if ((TileLoader.ruin20 & seen_fused) != (getRuinReversedHorizontal(20) & seen_fused)) {
                    RSYM = 0;
                }
                seen_fused = TileLoader.seen21 & getSeenReversedHorizontal(21);
                if ((TileLoader.wall21 & seen_fused) != (getWallReversedHorizontal(21) & seen_fused)) {
                    RSYM = 0;
                }
                if ((TileLoader.ruin21 & seen_fused) != (getRuinReversedHorizontal(21) & seen_fused)) {
                    RSYM = 0;
                }
                seen_fused = TileLoader.seen22 & getSeenReversedHorizontal(22);
                if ((TileLoader.wall22 & seen_fused) != (getWallReversedHorizontal(22) & seen_fused)) {
                    RSYM = 0;
                }
                if ((TileLoader.ruin22 & seen_fused) != (getRuinReversedHorizontal(22) & seen_fused)) {
                    RSYM = 0;
                }
                seen_fused = TileLoader.seen23 & getSeenReversedHorizontal(23);
                if ((TileLoader.wall23 & seen_fused) != (getWallReversedHorizontal(23) & seen_fused)) {
                    RSYM = 0;
                }
                if ((TileLoader.ruin23 & seen_fused) != (getRuinReversedHorizontal(23) & seen_fused)) {
                    RSYM = 0;
                }
                
            }
            case 20 -> {
                seen_fused = TileLoader.seen16 & getSeenReversedHorizontal(16);
                if ((TileLoader.wall16 & seen_fused) != (getWallReversedHorizontal(16) & seen_fused)) {
                    RSYM = 0;
                }
                if ((TileLoader.ruin16 & seen_fused) != (getRuinReversedHorizontal(16) & seen_fused)) {
                    RSYM = 0;
                }
                seen_fused = TileLoader.seen17 & getSeenReversedHorizontal(17);
                if ((TileLoader.wall17 & seen_fused) != (getWallReversedHorizontal(17) & seen_fused)) {
                    RSYM = 0;
                }
                if ((TileLoader.ruin17 & seen_fused) != (getRuinReversedHorizontal(17) & seen_fused)) {
                    RSYM = 0;
                }
                seen_fused = TileLoader.seen18 & getSeenReversedHorizontal(18);
                if ((TileLoader.wall18 & seen_fused) != (getWallReversedHorizontal(18) & seen_fused)) {
                    RSYM = 0;
                }
                if ((TileLoader.ruin18 & seen_fused) != (getRuinReversedHorizontal(18) & seen_fused)) {
                    RSYM = 0;
                }
                seen_fused = TileLoader.seen19 & getSeenReversedHorizontal(19);
                if ((TileLoader.wall19 & seen_fused) != (getWallReversedHorizontal(19) & seen_fused)) {
                    RSYM = 0;
                }
                if ((TileLoader.ruin19 & seen_fused) != (getRuinReversedHorizontal(19) & seen_fused)) {
                    RSYM = 0;
                }
                seen_fused = TileLoader.seen20 & getSeenReversedHorizontal(20);
                if ((TileLoader.wall20 & seen_fused) != (getWallReversedHorizontal(20) & seen_fused)) {
                    RSYM = 0;
                }
                if ((TileLoader.ruin20 & seen_fused) != (getRuinReversedHorizontal(20) & seen_fused)) {
                    RSYM = 0;
                }
                seen_fused = TileLoader.seen21 & getSeenReversedHorizontal(21);
                if ((TileLoader.wall21 & seen_fused) != (getWallReversedHorizontal(21) & seen_fused)) {
                    RSYM = 0;
                }
                if ((TileLoader.ruin21 & seen_fused) != (getRuinReversedHorizontal(21) & seen_fused)) {
                    RSYM = 0;
                }
                seen_fused = TileLoader.seen22 & getSeenReversedHorizontal(22);
                if ((TileLoader.wall22 & seen_fused) != (getWallReversedHorizontal(22) & seen_fused)) {
                    RSYM = 0;
                }
                if ((TileLoader.ruin22 & seen_fused) != (getRuinReversedHorizontal(22) & seen_fused)) {
                    RSYM = 0;
                }
                seen_fused = TileLoader.seen23 & getSeenReversedHorizontal(23);
                if ((TileLoader.wall23 & seen_fused) != (getWallReversedHorizontal(23) & seen_fused)) {
                    RSYM = 0;
                }
                if ((TileLoader.ruin23 & seen_fused) != (getRuinReversedHorizontal(23) & seen_fused)) {
                    RSYM = 0;
                }
                seen_fused = TileLoader.seen24 & getSeenReversedHorizontal(24);
                if ((TileLoader.wall24 & seen_fused) != (getWallReversedHorizontal(24) & seen_fused)) {
                    RSYM = 0;
                }
                if ((TileLoader.ruin24 & seen_fused) != (getRuinReversedHorizontal(24) & seen_fused)) {
                    RSYM = 0;
                }
                
            }
            case 21 -> {
                seen_fused = TileLoader.seen17 & getSeenReversedHorizontal(17);
                if ((TileLoader.wall17 & seen_fused) != (getWallReversedHorizontal(17) & seen_fused)) {
                    RSYM = 0;
                }
                if ((TileLoader.ruin17 & seen_fused) != (getRuinReversedHorizontal(17) & seen_fused)) {
                    RSYM = 0;
                }
                seen_fused = TileLoader.seen18 & getSeenReversedHorizontal(18);
                if ((TileLoader.wall18 & seen_fused) != (getWallReversedHorizontal(18) & seen_fused)) {
                    RSYM = 0;
                }
                if ((TileLoader.ruin18 & seen_fused) != (getRuinReversedHorizontal(18) & seen_fused)) {
                    RSYM = 0;
                }
                seen_fused = TileLoader.seen19 & getSeenReversedHorizontal(19);
                if ((TileLoader.wall19 & seen_fused) != (getWallReversedHorizontal(19) & seen_fused)) {
                    RSYM = 0;
                }
                if ((TileLoader.ruin19 & seen_fused) != (getRuinReversedHorizontal(19) & seen_fused)) {
                    RSYM = 0;
                }
                seen_fused = TileLoader.seen20 & getSeenReversedHorizontal(20);
                if ((TileLoader.wall20 & seen_fused) != (getWallReversedHorizontal(20) & seen_fused)) {
                    RSYM = 0;
                }
                if ((TileLoader.ruin20 & seen_fused) != (getRuinReversedHorizontal(20) & seen_fused)) {
                    RSYM = 0;
                }
                seen_fused = TileLoader.seen21 & getSeenReversedHorizontal(21);
                if ((TileLoader.wall21 & seen_fused) != (getWallReversedHorizontal(21) & seen_fused)) {
                    RSYM = 0;
                }
                if ((TileLoader.ruin21 & seen_fused) != (getRuinReversedHorizontal(21) & seen_fused)) {
                    RSYM = 0;
                }
                seen_fused = TileLoader.seen22 & getSeenReversedHorizontal(22);
                if ((TileLoader.wall22 & seen_fused) != (getWallReversedHorizontal(22) & seen_fused)) {
                    RSYM = 0;
                }
                if ((TileLoader.ruin22 & seen_fused) != (getRuinReversedHorizontal(22) & seen_fused)) {
                    RSYM = 0;
                }
                seen_fused = TileLoader.seen23 & getSeenReversedHorizontal(23);
                if ((TileLoader.wall23 & seen_fused) != (getWallReversedHorizontal(23) & seen_fused)) {
                    RSYM = 0;
                }
                if ((TileLoader.ruin23 & seen_fused) != (getRuinReversedHorizontal(23) & seen_fused)) {
                    RSYM = 0;
                }
                seen_fused = TileLoader.seen24 & getSeenReversedHorizontal(24);
                if ((TileLoader.wall24 & seen_fused) != (getWallReversedHorizontal(24) & seen_fused)) {
                    RSYM = 0;
                }
                if ((TileLoader.ruin24 & seen_fused) != (getRuinReversedHorizontal(24) & seen_fused)) {
                    RSYM = 0;
                }
                seen_fused = TileLoader.seen25 & getSeenReversedHorizontal(25);
                if ((TileLoader.wall25 & seen_fused) != (getWallReversedHorizontal(25) & seen_fused)) {
                    RSYM = 0;
                }
                if ((TileLoader.ruin25 & seen_fused) != (getRuinReversedHorizontal(25) & seen_fused)) {
                    RSYM = 0;
                }
                
            }
            case 22 -> {
                seen_fused = TileLoader.seen18 & getSeenReversedHorizontal(18);
                if ((TileLoader.wall18 & seen_fused) != (getWallReversedHorizontal(18) & seen_fused)) {
                    RSYM = 0;
                }
                if ((TileLoader.ruin18 & seen_fused) != (getRuinReversedHorizontal(18) & seen_fused)) {
                    RSYM = 0;
                }
                seen_fused = TileLoader.seen19 & getSeenReversedHorizontal(19);
                if ((TileLoader.wall19 & seen_fused) != (getWallReversedHorizontal(19) & seen_fused)) {
                    RSYM = 0;
                }
                if ((TileLoader.ruin19 & seen_fused) != (getRuinReversedHorizontal(19) & seen_fused)) {
                    RSYM = 0;
                }
                seen_fused = TileLoader.seen20 & getSeenReversedHorizontal(20);
                if ((TileLoader.wall20 & seen_fused) != (getWallReversedHorizontal(20) & seen_fused)) {
                    RSYM = 0;
                }
                if ((TileLoader.ruin20 & seen_fused) != (getRuinReversedHorizontal(20) & seen_fused)) {
                    RSYM = 0;
                }
                seen_fused = TileLoader.seen21 & getSeenReversedHorizontal(21);
                if ((TileLoader.wall21 & seen_fused) != (getWallReversedHorizontal(21) & seen_fused)) {
                    RSYM = 0;
                }
                if ((TileLoader.ruin21 & seen_fused) != (getRuinReversedHorizontal(21) & seen_fused)) {
                    RSYM = 0;
                }
                seen_fused = TileLoader.seen22 & getSeenReversedHorizontal(22);
                if ((TileLoader.wall22 & seen_fused) != (getWallReversedHorizontal(22) & seen_fused)) {
                    RSYM = 0;
                }
                if ((TileLoader.ruin22 & seen_fused) != (getRuinReversedHorizontal(22) & seen_fused)) {
                    RSYM = 0;
                }
                seen_fused = TileLoader.seen23 & getSeenReversedHorizontal(23);
                if ((TileLoader.wall23 & seen_fused) != (getWallReversedHorizontal(23) & seen_fused)) {
                    RSYM = 0;
                }
                if ((TileLoader.ruin23 & seen_fused) != (getRuinReversedHorizontal(23) & seen_fused)) {
                    RSYM = 0;
                }
                seen_fused = TileLoader.seen24 & getSeenReversedHorizontal(24);
                if ((TileLoader.wall24 & seen_fused) != (getWallReversedHorizontal(24) & seen_fused)) {
                    RSYM = 0;
                }
                if ((TileLoader.ruin24 & seen_fused) != (getRuinReversedHorizontal(24) & seen_fused)) {
                    RSYM = 0;
                }
                seen_fused = TileLoader.seen25 & getSeenReversedHorizontal(25);
                if ((TileLoader.wall25 & seen_fused) != (getWallReversedHorizontal(25) & seen_fused)) {
                    RSYM = 0;
                }
                if ((TileLoader.ruin25 & seen_fused) != (getRuinReversedHorizontal(25) & seen_fused)) {
                    RSYM = 0;
                }
                seen_fused = TileLoader.seen26 & getSeenReversedHorizontal(26);
                if ((TileLoader.wall26 & seen_fused) != (getWallReversedHorizontal(26) & seen_fused)) {
                    RSYM = 0;
                }
                if ((TileLoader.ruin26 & seen_fused) != (getRuinReversedHorizontal(26) & seen_fused)) {
                    RSYM = 0;
                }
                
            }
            case 23 -> {
                seen_fused = TileLoader.seen19 & getSeenReversedHorizontal(19);
                if ((TileLoader.wall19 & seen_fused) != (getWallReversedHorizontal(19) & seen_fused)) {
                    RSYM = 0;
                }
                if ((TileLoader.ruin19 & seen_fused) != (getRuinReversedHorizontal(19) & seen_fused)) {
                    RSYM = 0;
                }
                seen_fused = TileLoader.seen20 & getSeenReversedHorizontal(20);
                if ((TileLoader.wall20 & seen_fused) != (getWallReversedHorizontal(20) & seen_fused)) {
                    RSYM = 0;
                }
                if ((TileLoader.ruin20 & seen_fused) != (getRuinReversedHorizontal(20) & seen_fused)) {
                    RSYM = 0;
                }
                seen_fused = TileLoader.seen21 & getSeenReversedHorizontal(21);
                if ((TileLoader.wall21 & seen_fused) != (getWallReversedHorizontal(21) & seen_fused)) {
                    RSYM = 0;
                }
                if ((TileLoader.ruin21 & seen_fused) != (getRuinReversedHorizontal(21) & seen_fused)) {
                    RSYM = 0;
                }
                seen_fused = TileLoader.seen22 & getSeenReversedHorizontal(22);
                if ((TileLoader.wall22 & seen_fused) != (getWallReversedHorizontal(22) & seen_fused)) {
                    RSYM = 0;
                }
                if ((TileLoader.ruin22 & seen_fused) != (getRuinReversedHorizontal(22) & seen_fused)) {
                    RSYM = 0;
                }
                seen_fused = TileLoader.seen23 & getSeenReversedHorizontal(23);
                if ((TileLoader.wall23 & seen_fused) != (getWallReversedHorizontal(23) & seen_fused)) {
                    RSYM = 0;
                }
                if ((TileLoader.ruin23 & seen_fused) != (getRuinReversedHorizontal(23) & seen_fused)) {
                    RSYM = 0;
                }
                seen_fused = TileLoader.seen24 & getSeenReversedHorizontal(24);
                if ((TileLoader.wall24 & seen_fused) != (getWallReversedHorizontal(24) & seen_fused)) {
                    RSYM = 0;
                }
                if ((TileLoader.ruin24 & seen_fused) != (getRuinReversedHorizontal(24) & seen_fused)) {
                    RSYM = 0;
                }
                seen_fused = TileLoader.seen25 & getSeenReversedHorizontal(25);
                if ((TileLoader.wall25 & seen_fused) != (getWallReversedHorizontal(25) & seen_fused)) {
                    RSYM = 0;
                }
                if ((TileLoader.ruin25 & seen_fused) != (getRuinReversedHorizontal(25) & seen_fused)) {
                    RSYM = 0;
                }
                seen_fused = TileLoader.seen26 & getSeenReversedHorizontal(26);
                if ((TileLoader.wall26 & seen_fused) != (getWallReversedHorizontal(26) & seen_fused)) {
                    RSYM = 0;
                }
                if ((TileLoader.ruin26 & seen_fused) != (getRuinReversedHorizontal(26) & seen_fused)) {
                    RSYM = 0;
                }
                seen_fused = TileLoader.seen27 & getSeenReversedHorizontal(27);
                if ((TileLoader.wall27 & seen_fused) != (getWallReversedHorizontal(27) & seen_fused)) {
                    RSYM = 0;
                }
                if ((TileLoader.ruin27 & seen_fused) != (getRuinReversedHorizontal(27) & seen_fused)) {
                    RSYM = 0;
                }
                
            }
            case 24 -> {
                seen_fused = TileLoader.seen20 & getSeenReversedHorizontal(20);
                if ((TileLoader.wall20 & seen_fused) != (getWallReversedHorizontal(20) & seen_fused)) {
                    RSYM = 0;
                }
                if ((TileLoader.ruin20 & seen_fused) != (getRuinReversedHorizontal(20) & seen_fused)) {
                    RSYM = 0;
                }
                seen_fused = TileLoader.seen21 & getSeenReversedHorizontal(21);
                if ((TileLoader.wall21 & seen_fused) != (getWallReversedHorizontal(21) & seen_fused)) {
                    RSYM = 0;
                }
                if ((TileLoader.ruin21 & seen_fused) != (getRuinReversedHorizontal(21) & seen_fused)) {
                    RSYM = 0;
                }
                seen_fused = TileLoader.seen22 & getSeenReversedHorizontal(22);
                if ((TileLoader.wall22 & seen_fused) != (getWallReversedHorizontal(22) & seen_fused)) {
                    RSYM = 0;
                }
                if ((TileLoader.ruin22 & seen_fused) != (getRuinReversedHorizontal(22) & seen_fused)) {
                    RSYM = 0;
                }
                seen_fused = TileLoader.seen23 & getSeenReversedHorizontal(23);
                if ((TileLoader.wall23 & seen_fused) != (getWallReversedHorizontal(23) & seen_fused)) {
                    RSYM = 0;
                }
                if ((TileLoader.ruin23 & seen_fused) != (getRuinReversedHorizontal(23) & seen_fused)) {
                    RSYM = 0;
                }
                seen_fused = TileLoader.seen24 & getSeenReversedHorizontal(24);
                if ((TileLoader.wall24 & seen_fused) != (getWallReversedHorizontal(24) & seen_fused)) {
                    RSYM = 0;
                }
                if ((TileLoader.ruin24 & seen_fused) != (getRuinReversedHorizontal(24) & seen_fused)) {
                    RSYM = 0;
                }
                seen_fused = TileLoader.seen25 & getSeenReversedHorizontal(25);
                if ((TileLoader.wall25 & seen_fused) != (getWallReversedHorizontal(25) & seen_fused)) {
                    RSYM = 0;
                }
                if ((TileLoader.ruin25 & seen_fused) != (getRuinReversedHorizontal(25) & seen_fused)) {
                    RSYM = 0;
                }
                seen_fused = TileLoader.seen26 & getSeenReversedHorizontal(26);
                if ((TileLoader.wall26 & seen_fused) != (getWallReversedHorizontal(26) & seen_fused)) {
                    RSYM = 0;
                }
                if ((TileLoader.ruin26 & seen_fused) != (getRuinReversedHorizontal(26) & seen_fused)) {
                    RSYM = 0;
                }
                seen_fused = TileLoader.seen27 & getSeenReversedHorizontal(27);
                if ((TileLoader.wall27 & seen_fused) != (getWallReversedHorizontal(27) & seen_fused)) {
                    RSYM = 0;
                }
                if ((TileLoader.ruin27 & seen_fused) != (getRuinReversedHorizontal(27) & seen_fused)) {
                    RSYM = 0;
                }
                seen_fused = TileLoader.seen28 & getSeenReversedHorizontal(28);
                if ((TileLoader.wall28 & seen_fused) != (getWallReversedHorizontal(28) & seen_fused)) {
                    RSYM = 0;
                }
                if ((TileLoader.ruin28 & seen_fused) != (getRuinReversedHorizontal(28) & seen_fused)) {
                    RSYM = 0;
                }
                
            }
            case 25 -> {
                seen_fused = TileLoader.seen21 & getSeenReversedHorizontal(21);
                if ((TileLoader.wall21 & seen_fused) != (getWallReversedHorizontal(21) & seen_fused)) {
                    RSYM = 0;
                }
                if ((TileLoader.ruin21 & seen_fused) != (getRuinReversedHorizontal(21) & seen_fused)) {
                    RSYM = 0;
                }
                seen_fused = TileLoader.seen22 & getSeenReversedHorizontal(22);
                if ((TileLoader.wall22 & seen_fused) != (getWallReversedHorizontal(22) & seen_fused)) {
                    RSYM = 0;
                }
                if ((TileLoader.ruin22 & seen_fused) != (getRuinReversedHorizontal(22) & seen_fused)) {
                    RSYM = 0;
                }
                seen_fused = TileLoader.seen23 & getSeenReversedHorizontal(23);
                if ((TileLoader.wall23 & seen_fused) != (getWallReversedHorizontal(23) & seen_fused)) {
                    RSYM = 0;
                }
                if ((TileLoader.ruin23 & seen_fused) != (getRuinReversedHorizontal(23) & seen_fused)) {
                    RSYM = 0;
                }
                seen_fused = TileLoader.seen24 & getSeenReversedHorizontal(24);
                if ((TileLoader.wall24 & seen_fused) != (getWallReversedHorizontal(24) & seen_fused)) {
                    RSYM = 0;
                }
                if ((TileLoader.ruin24 & seen_fused) != (getRuinReversedHorizontal(24) & seen_fused)) {
                    RSYM = 0;
                }
                seen_fused = TileLoader.seen25 & getSeenReversedHorizontal(25);
                if ((TileLoader.wall25 & seen_fused) != (getWallReversedHorizontal(25) & seen_fused)) {
                    RSYM = 0;
                }
                if ((TileLoader.ruin25 & seen_fused) != (getRuinReversedHorizontal(25) & seen_fused)) {
                    RSYM = 0;
                }
                seen_fused = TileLoader.seen26 & getSeenReversedHorizontal(26);
                if ((TileLoader.wall26 & seen_fused) != (getWallReversedHorizontal(26) & seen_fused)) {
                    RSYM = 0;
                }
                if ((TileLoader.ruin26 & seen_fused) != (getRuinReversedHorizontal(26) & seen_fused)) {
                    RSYM = 0;
                }
                seen_fused = TileLoader.seen27 & getSeenReversedHorizontal(27);
                if ((TileLoader.wall27 & seen_fused) != (getWallReversedHorizontal(27) & seen_fused)) {
                    RSYM = 0;
                }
                if ((TileLoader.ruin27 & seen_fused) != (getRuinReversedHorizontal(27) & seen_fused)) {
                    RSYM = 0;
                }
                seen_fused = TileLoader.seen28 & getSeenReversedHorizontal(28);
                if ((TileLoader.wall28 & seen_fused) != (getWallReversedHorizontal(28) & seen_fused)) {
                    RSYM = 0;
                }
                if ((TileLoader.ruin28 & seen_fused) != (getRuinReversedHorizontal(28) & seen_fused)) {
                    RSYM = 0;
                }
                seen_fused = TileLoader.seen29 & getSeenReversedHorizontal(29);
                if ((TileLoader.wall29 & seen_fused) != (getWallReversedHorizontal(29) & seen_fused)) {
                    RSYM = 0;
                }
                if ((TileLoader.ruin29 & seen_fused) != (getRuinReversedHorizontal(29) & seen_fused)) {
                    RSYM = 0;
                }
                
            }
            case 26 -> {
                seen_fused = TileLoader.seen22 & getSeenReversedHorizontal(22);
                if ((TileLoader.wall22 & seen_fused) != (getWallReversedHorizontal(22) & seen_fused)) {
                    RSYM = 0;
                }
                if ((TileLoader.ruin22 & seen_fused) != (getRuinReversedHorizontal(22) & seen_fused)) {
                    RSYM = 0;
                }
                seen_fused = TileLoader.seen23 & getSeenReversedHorizontal(23);
                if ((TileLoader.wall23 & seen_fused) != (getWallReversedHorizontal(23) & seen_fused)) {
                    RSYM = 0;
                }
                if ((TileLoader.ruin23 & seen_fused) != (getRuinReversedHorizontal(23) & seen_fused)) {
                    RSYM = 0;
                }
                seen_fused = TileLoader.seen24 & getSeenReversedHorizontal(24);
                if ((TileLoader.wall24 & seen_fused) != (getWallReversedHorizontal(24) & seen_fused)) {
                    RSYM = 0;
                }
                if ((TileLoader.ruin24 & seen_fused) != (getRuinReversedHorizontal(24) & seen_fused)) {
                    RSYM = 0;
                }
                seen_fused = TileLoader.seen25 & getSeenReversedHorizontal(25);
                if ((TileLoader.wall25 & seen_fused) != (getWallReversedHorizontal(25) & seen_fused)) {
                    RSYM = 0;
                }
                if ((TileLoader.ruin25 & seen_fused) != (getRuinReversedHorizontal(25) & seen_fused)) {
                    RSYM = 0;
                }
                seen_fused = TileLoader.seen26 & getSeenReversedHorizontal(26);
                if ((TileLoader.wall26 & seen_fused) != (getWallReversedHorizontal(26) & seen_fused)) {
                    RSYM = 0;
                }
                if ((TileLoader.ruin26 & seen_fused) != (getRuinReversedHorizontal(26) & seen_fused)) {
                    RSYM = 0;
                }
                seen_fused = TileLoader.seen27 & getSeenReversedHorizontal(27);
                if ((TileLoader.wall27 & seen_fused) != (getWallReversedHorizontal(27) & seen_fused)) {
                    RSYM = 0;
                }
                if ((TileLoader.ruin27 & seen_fused) != (getRuinReversedHorizontal(27) & seen_fused)) {
                    RSYM = 0;
                }
                seen_fused = TileLoader.seen28 & getSeenReversedHorizontal(28);
                if ((TileLoader.wall28 & seen_fused) != (getWallReversedHorizontal(28) & seen_fused)) {
                    RSYM = 0;
                }
                if ((TileLoader.ruin28 & seen_fused) != (getRuinReversedHorizontal(28) & seen_fused)) {
                    RSYM = 0;
                }
                seen_fused = TileLoader.seen29 & getSeenReversedHorizontal(29);
                if ((TileLoader.wall29 & seen_fused) != (getWallReversedHorizontal(29) & seen_fused)) {
                    RSYM = 0;
                }
                if ((TileLoader.ruin29 & seen_fused) != (getRuinReversedHorizontal(29) & seen_fused)) {
                    RSYM = 0;
                }
                seen_fused = TileLoader.seen30 & getSeenReversedHorizontal(30);
                if ((TileLoader.wall30 & seen_fused) != (getWallReversedHorizontal(30) & seen_fused)) {
                    RSYM = 0;
                }
                if ((TileLoader.ruin30 & seen_fused) != (getRuinReversedHorizontal(30) & seen_fused)) {
                    RSYM = 0;
                }
                
            }
            case 27 -> {
                seen_fused = TileLoader.seen23 & getSeenReversedHorizontal(23);
                if ((TileLoader.wall23 & seen_fused) != (getWallReversedHorizontal(23) & seen_fused)) {
                    RSYM = 0;
                }
                if ((TileLoader.ruin23 & seen_fused) != (getRuinReversedHorizontal(23) & seen_fused)) {
                    RSYM = 0;
                }
                seen_fused = TileLoader.seen24 & getSeenReversedHorizontal(24);
                if ((TileLoader.wall24 & seen_fused) != (getWallReversedHorizontal(24) & seen_fused)) {
                    RSYM = 0;
                }
                if ((TileLoader.ruin24 & seen_fused) != (getRuinReversedHorizontal(24) & seen_fused)) {
                    RSYM = 0;
                }
                seen_fused = TileLoader.seen25 & getSeenReversedHorizontal(25);
                if ((TileLoader.wall25 & seen_fused) != (getWallReversedHorizontal(25) & seen_fused)) {
                    RSYM = 0;
                }
                if ((TileLoader.ruin25 & seen_fused) != (getRuinReversedHorizontal(25) & seen_fused)) {
                    RSYM = 0;
                }
                seen_fused = TileLoader.seen26 & getSeenReversedHorizontal(26);
                if ((TileLoader.wall26 & seen_fused) != (getWallReversedHorizontal(26) & seen_fused)) {
                    RSYM = 0;
                }
                if ((TileLoader.ruin26 & seen_fused) != (getRuinReversedHorizontal(26) & seen_fused)) {
                    RSYM = 0;
                }
                seen_fused = TileLoader.seen27 & getSeenReversedHorizontal(27);
                if ((TileLoader.wall27 & seen_fused) != (getWallReversedHorizontal(27) & seen_fused)) {
                    RSYM = 0;
                }
                if ((TileLoader.ruin27 & seen_fused) != (getRuinReversedHorizontal(27) & seen_fused)) {
                    RSYM = 0;
                }
                seen_fused = TileLoader.seen28 & getSeenReversedHorizontal(28);
                if ((TileLoader.wall28 & seen_fused) != (getWallReversedHorizontal(28) & seen_fused)) {
                    RSYM = 0;
                }
                if ((TileLoader.ruin28 & seen_fused) != (getRuinReversedHorizontal(28) & seen_fused)) {
                    RSYM = 0;
                }
                seen_fused = TileLoader.seen29 & getSeenReversedHorizontal(29);
                if ((TileLoader.wall29 & seen_fused) != (getWallReversedHorizontal(29) & seen_fused)) {
                    RSYM = 0;
                }
                if ((TileLoader.ruin29 & seen_fused) != (getRuinReversedHorizontal(29) & seen_fused)) {
                    RSYM = 0;
                }
                seen_fused = TileLoader.seen30 & getSeenReversedHorizontal(30);
                if ((TileLoader.wall30 & seen_fused) != (getWallReversedHorizontal(30) & seen_fused)) {
                    RSYM = 0;
                }
                if ((TileLoader.ruin30 & seen_fused) != (getRuinReversedHorizontal(30) & seen_fused)) {
                    RSYM = 0;
                }
                seen_fused = TileLoader.seen31 & getSeenReversedHorizontal(31);
                if ((TileLoader.wall31 & seen_fused) != (getWallReversedHorizontal(31) & seen_fused)) {
                    RSYM = 0;
                }
                if ((TileLoader.ruin31 & seen_fused) != (getRuinReversedHorizontal(31) & seen_fused)) {
                    RSYM = 0;
                }
                
            }
            case 28 -> {
                seen_fused = TileLoader.seen24 & getSeenReversedHorizontal(24);
                if ((TileLoader.wall24 & seen_fused) != (getWallReversedHorizontal(24) & seen_fused)) {
                    RSYM = 0;
                }
                if ((TileLoader.ruin24 & seen_fused) != (getRuinReversedHorizontal(24) & seen_fused)) {
                    RSYM = 0;
                }
                seen_fused = TileLoader.seen25 & getSeenReversedHorizontal(25);
                if ((TileLoader.wall25 & seen_fused) != (getWallReversedHorizontal(25) & seen_fused)) {
                    RSYM = 0;
                }
                if ((TileLoader.ruin25 & seen_fused) != (getRuinReversedHorizontal(25) & seen_fused)) {
                    RSYM = 0;
                }
                seen_fused = TileLoader.seen26 & getSeenReversedHorizontal(26);
                if ((TileLoader.wall26 & seen_fused) != (getWallReversedHorizontal(26) & seen_fused)) {
                    RSYM = 0;
                }
                if ((TileLoader.ruin26 & seen_fused) != (getRuinReversedHorizontal(26) & seen_fused)) {
                    RSYM = 0;
                }
                seen_fused = TileLoader.seen27 & getSeenReversedHorizontal(27);
                if ((TileLoader.wall27 & seen_fused) != (getWallReversedHorizontal(27) & seen_fused)) {
                    RSYM = 0;
                }
                if ((TileLoader.ruin27 & seen_fused) != (getRuinReversedHorizontal(27) & seen_fused)) {
                    RSYM = 0;
                }
                seen_fused = TileLoader.seen28 & getSeenReversedHorizontal(28);
                if ((TileLoader.wall28 & seen_fused) != (getWallReversedHorizontal(28) & seen_fused)) {
                    RSYM = 0;
                }
                if ((TileLoader.ruin28 & seen_fused) != (getRuinReversedHorizontal(28) & seen_fused)) {
                    RSYM = 0;
                }
                seen_fused = TileLoader.seen29 & getSeenReversedHorizontal(29);
                if ((TileLoader.wall29 & seen_fused) != (getWallReversedHorizontal(29) & seen_fused)) {
                    RSYM = 0;
                }
                if ((TileLoader.ruin29 & seen_fused) != (getRuinReversedHorizontal(29) & seen_fused)) {
                    RSYM = 0;
                }
                seen_fused = TileLoader.seen30 & getSeenReversedHorizontal(30);
                if ((TileLoader.wall30 & seen_fused) != (getWallReversedHorizontal(30) & seen_fused)) {
                    RSYM = 0;
                }
                if ((TileLoader.ruin30 & seen_fused) != (getRuinReversedHorizontal(30) & seen_fused)) {
                    RSYM = 0;
                }
                seen_fused = TileLoader.seen31 & getSeenReversedHorizontal(31);
                if ((TileLoader.wall31 & seen_fused) != (getWallReversedHorizontal(31) & seen_fused)) {
                    RSYM = 0;
                }
                if ((TileLoader.ruin31 & seen_fused) != (getRuinReversedHorizontal(31) & seen_fused)) {
                    RSYM = 0;
                }
                seen_fused = TileLoader.seen32 & getSeenReversedHorizontal(32);
                if ((TileLoader.wall32 & seen_fused) != (getWallReversedHorizontal(32) & seen_fused)) {
                    RSYM = 0;
                }
                if ((TileLoader.ruin32 & seen_fused) != (getRuinReversedHorizontal(32) & seen_fused)) {
                    RSYM = 0;
                }
                
            }
            case 29 -> {
                seen_fused = TileLoader.seen25 & getSeenReversedHorizontal(25);
                if ((TileLoader.wall25 & seen_fused) != (getWallReversedHorizontal(25) & seen_fused)) {
                    RSYM = 0;
                }
                if ((TileLoader.ruin25 & seen_fused) != (getRuinReversedHorizontal(25) & seen_fused)) {
                    RSYM = 0;
                }
                seen_fused = TileLoader.seen26 & getSeenReversedHorizontal(26);
                if ((TileLoader.wall26 & seen_fused) != (getWallReversedHorizontal(26) & seen_fused)) {
                    RSYM = 0;
                }
                if ((TileLoader.ruin26 & seen_fused) != (getRuinReversedHorizontal(26) & seen_fused)) {
                    RSYM = 0;
                }
                seen_fused = TileLoader.seen27 & getSeenReversedHorizontal(27);
                if ((TileLoader.wall27 & seen_fused) != (getWallReversedHorizontal(27) & seen_fused)) {
                    RSYM = 0;
                }
                if ((TileLoader.ruin27 & seen_fused) != (getRuinReversedHorizontal(27) & seen_fused)) {
                    RSYM = 0;
                }
                seen_fused = TileLoader.seen28 & getSeenReversedHorizontal(28);
                if ((TileLoader.wall28 & seen_fused) != (getWallReversedHorizontal(28) & seen_fused)) {
                    RSYM = 0;
                }
                if ((TileLoader.ruin28 & seen_fused) != (getRuinReversedHorizontal(28) & seen_fused)) {
                    RSYM = 0;
                }
                seen_fused = TileLoader.seen29 & getSeenReversedHorizontal(29);
                if ((TileLoader.wall29 & seen_fused) != (getWallReversedHorizontal(29) & seen_fused)) {
                    RSYM = 0;
                }
                if ((TileLoader.ruin29 & seen_fused) != (getRuinReversedHorizontal(29) & seen_fused)) {
                    RSYM = 0;
                }
                seen_fused = TileLoader.seen30 & getSeenReversedHorizontal(30);
                if ((TileLoader.wall30 & seen_fused) != (getWallReversedHorizontal(30) & seen_fused)) {
                    RSYM = 0;
                }
                if ((TileLoader.ruin30 & seen_fused) != (getRuinReversedHorizontal(30) & seen_fused)) {
                    RSYM = 0;
                }
                seen_fused = TileLoader.seen31 & getSeenReversedHorizontal(31);
                if ((TileLoader.wall31 & seen_fused) != (getWallReversedHorizontal(31) & seen_fused)) {
                    RSYM = 0;
                }
                if ((TileLoader.ruin31 & seen_fused) != (getRuinReversedHorizontal(31) & seen_fused)) {
                    RSYM = 0;
                }
                seen_fused = TileLoader.seen32 & getSeenReversedHorizontal(32);
                if ((TileLoader.wall32 & seen_fused) != (getWallReversedHorizontal(32) & seen_fused)) {
                    RSYM = 0;
                }
                if ((TileLoader.ruin32 & seen_fused) != (getRuinReversedHorizontal(32) & seen_fused)) {
                    RSYM = 0;
                }
                seen_fused = TileLoader.seen33 & getSeenReversedHorizontal(33);
                if ((TileLoader.wall33 & seen_fused) != (getWallReversedHorizontal(33) & seen_fused)) {
                    RSYM = 0;
                }
                if ((TileLoader.ruin33 & seen_fused) != (getRuinReversedHorizontal(33) & seen_fused)) {
                    RSYM = 0;
                }
                
            }
            case 30 -> {
                seen_fused = TileLoader.seen26 & getSeenReversedHorizontal(26);
                if ((TileLoader.wall26 & seen_fused) != (getWallReversedHorizontal(26) & seen_fused)) {
                    RSYM = 0;
                }
                if ((TileLoader.ruin26 & seen_fused) != (getRuinReversedHorizontal(26) & seen_fused)) {
                    RSYM = 0;
                }
                seen_fused = TileLoader.seen27 & getSeenReversedHorizontal(27);
                if ((TileLoader.wall27 & seen_fused) != (getWallReversedHorizontal(27) & seen_fused)) {
                    RSYM = 0;
                }
                if ((TileLoader.ruin27 & seen_fused) != (getRuinReversedHorizontal(27) & seen_fused)) {
                    RSYM = 0;
                }
                seen_fused = TileLoader.seen28 & getSeenReversedHorizontal(28);
                if ((TileLoader.wall28 & seen_fused) != (getWallReversedHorizontal(28) & seen_fused)) {
                    RSYM = 0;
                }
                if ((TileLoader.ruin28 & seen_fused) != (getRuinReversedHorizontal(28) & seen_fused)) {
                    RSYM = 0;
                }
                seen_fused = TileLoader.seen29 & getSeenReversedHorizontal(29);
                if ((TileLoader.wall29 & seen_fused) != (getWallReversedHorizontal(29) & seen_fused)) {
                    RSYM = 0;
                }
                if ((TileLoader.ruin29 & seen_fused) != (getRuinReversedHorizontal(29) & seen_fused)) {
                    RSYM = 0;
                }
                seen_fused = TileLoader.seen30 & getSeenReversedHorizontal(30);
                if ((TileLoader.wall30 & seen_fused) != (getWallReversedHorizontal(30) & seen_fused)) {
                    RSYM = 0;
                }
                if ((TileLoader.ruin30 & seen_fused) != (getRuinReversedHorizontal(30) & seen_fused)) {
                    RSYM = 0;
                }
                seen_fused = TileLoader.seen31 & getSeenReversedHorizontal(31);
                if ((TileLoader.wall31 & seen_fused) != (getWallReversedHorizontal(31) & seen_fused)) {
                    RSYM = 0;
                }
                if ((TileLoader.ruin31 & seen_fused) != (getRuinReversedHorizontal(31) & seen_fused)) {
                    RSYM = 0;
                }
                seen_fused = TileLoader.seen32 & getSeenReversedHorizontal(32);
                if ((TileLoader.wall32 & seen_fused) != (getWallReversedHorizontal(32) & seen_fused)) {
                    RSYM = 0;
                }
                if ((TileLoader.ruin32 & seen_fused) != (getRuinReversedHorizontal(32) & seen_fused)) {
                    RSYM = 0;
                }
                seen_fused = TileLoader.seen33 & getSeenReversedHorizontal(33);
                if ((TileLoader.wall33 & seen_fused) != (getWallReversedHorizontal(33) & seen_fused)) {
                    RSYM = 0;
                }
                if ((TileLoader.ruin33 & seen_fused) != (getRuinReversedHorizontal(33) & seen_fused)) {
                    RSYM = 0;
                }
                seen_fused = TileLoader.seen34 & getSeenReversedHorizontal(34);
                if ((TileLoader.wall34 & seen_fused) != (getWallReversedHorizontal(34) & seen_fused)) {
                    RSYM = 0;
                }
                if ((TileLoader.ruin34 & seen_fused) != (getRuinReversedHorizontal(34) & seen_fused)) {
                    RSYM = 0;
                }
                
            }
            case 31 -> {
                seen_fused = TileLoader.seen27 & getSeenReversedHorizontal(27);
                if ((TileLoader.wall27 & seen_fused) != (getWallReversedHorizontal(27) & seen_fused)) {
                    RSYM = 0;
                }
                if ((TileLoader.ruin27 & seen_fused) != (getRuinReversedHorizontal(27) & seen_fused)) {
                    RSYM = 0;
                }
                seen_fused = TileLoader.seen28 & getSeenReversedHorizontal(28);
                if ((TileLoader.wall28 & seen_fused) != (getWallReversedHorizontal(28) & seen_fused)) {
                    RSYM = 0;
                }
                if ((TileLoader.ruin28 & seen_fused) != (getRuinReversedHorizontal(28) & seen_fused)) {
                    RSYM = 0;
                }
                seen_fused = TileLoader.seen29 & getSeenReversedHorizontal(29);
                if ((TileLoader.wall29 & seen_fused) != (getWallReversedHorizontal(29) & seen_fused)) {
                    RSYM = 0;
                }
                if ((TileLoader.ruin29 & seen_fused) != (getRuinReversedHorizontal(29) & seen_fused)) {
                    RSYM = 0;
                }
                seen_fused = TileLoader.seen30 & getSeenReversedHorizontal(30);
                if ((TileLoader.wall30 & seen_fused) != (getWallReversedHorizontal(30) & seen_fused)) {
                    RSYM = 0;
                }
                if ((TileLoader.ruin30 & seen_fused) != (getRuinReversedHorizontal(30) & seen_fused)) {
                    RSYM = 0;
                }
                seen_fused = TileLoader.seen31 & getSeenReversedHorizontal(31);
                if ((TileLoader.wall31 & seen_fused) != (getWallReversedHorizontal(31) & seen_fused)) {
                    RSYM = 0;
                }
                if ((TileLoader.ruin31 & seen_fused) != (getRuinReversedHorizontal(31) & seen_fused)) {
                    RSYM = 0;
                }
                seen_fused = TileLoader.seen32 & getSeenReversedHorizontal(32);
                if ((TileLoader.wall32 & seen_fused) != (getWallReversedHorizontal(32) & seen_fused)) {
                    RSYM = 0;
                }
                if ((TileLoader.ruin32 & seen_fused) != (getRuinReversedHorizontal(32) & seen_fused)) {
                    RSYM = 0;
                }
                seen_fused = TileLoader.seen33 & getSeenReversedHorizontal(33);
                if ((TileLoader.wall33 & seen_fused) != (getWallReversedHorizontal(33) & seen_fused)) {
                    RSYM = 0;
                }
                if ((TileLoader.ruin33 & seen_fused) != (getRuinReversedHorizontal(33) & seen_fused)) {
                    RSYM = 0;
                }
                seen_fused = TileLoader.seen34 & getSeenReversedHorizontal(34);
                if ((TileLoader.wall34 & seen_fused) != (getWallReversedHorizontal(34) & seen_fused)) {
                    RSYM = 0;
                }
                if ((TileLoader.ruin34 & seen_fused) != (getRuinReversedHorizontal(34) & seen_fused)) {
                    RSYM = 0;
                }
                seen_fused = TileLoader.seen35 & getSeenReversedHorizontal(35);
                if ((TileLoader.wall35 & seen_fused) != (getWallReversedHorizontal(35) & seen_fused)) {
                    RSYM = 0;
                }
                if ((TileLoader.ruin35 & seen_fused) != (getRuinReversedHorizontal(35) & seen_fused)) {
                    RSYM = 0;
                }
                
            }
            case 32 -> {
                seen_fused = TileLoader.seen28 & getSeenReversedHorizontal(28);
                if ((TileLoader.wall28 & seen_fused) != (getWallReversedHorizontal(28) & seen_fused)) {
                    RSYM = 0;
                }
                if ((TileLoader.ruin28 & seen_fused) != (getRuinReversedHorizontal(28) & seen_fused)) {
                    RSYM = 0;
                }
                seen_fused = TileLoader.seen29 & getSeenReversedHorizontal(29);
                if ((TileLoader.wall29 & seen_fused) != (getWallReversedHorizontal(29) & seen_fused)) {
                    RSYM = 0;
                }
                if ((TileLoader.ruin29 & seen_fused) != (getRuinReversedHorizontal(29) & seen_fused)) {
                    RSYM = 0;
                }
                seen_fused = TileLoader.seen30 & getSeenReversedHorizontal(30);
                if ((TileLoader.wall30 & seen_fused) != (getWallReversedHorizontal(30) & seen_fused)) {
                    RSYM = 0;
                }
                if ((TileLoader.ruin30 & seen_fused) != (getRuinReversedHorizontal(30) & seen_fused)) {
                    RSYM = 0;
                }
                seen_fused = TileLoader.seen31 & getSeenReversedHorizontal(31);
                if ((TileLoader.wall31 & seen_fused) != (getWallReversedHorizontal(31) & seen_fused)) {
                    RSYM = 0;
                }
                if ((TileLoader.ruin31 & seen_fused) != (getRuinReversedHorizontal(31) & seen_fused)) {
                    RSYM = 0;
                }
                seen_fused = TileLoader.seen32 & getSeenReversedHorizontal(32);
                if ((TileLoader.wall32 & seen_fused) != (getWallReversedHorizontal(32) & seen_fused)) {
                    RSYM = 0;
                }
                if ((TileLoader.ruin32 & seen_fused) != (getRuinReversedHorizontal(32) & seen_fused)) {
                    RSYM = 0;
                }
                seen_fused = TileLoader.seen33 & getSeenReversedHorizontal(33);
                if ((TileLoader.wall33 & seen_fused) != (getWallReversedHorizontal(33) & seen_fused)) {
                    RSYM = 0;
                }
                if ((TileLoader.ruin33 & seen_fused) != (getRuinReversedHorizontal(33) & seen_fused)) {
                    RSYM = 0;
                }
                seen_fused = TileLoader.seen34 & getSeenReversedHorizontal(34);
                if ((TileLoader.wall34 & seen_fused) != (getWallReversedHorizontal(34) & seen_fused)) {
                    RSYM = 0;
                }
                if ((TileLoader.ruin34 & seen_fused) != (getRuinReversedHorizontal(34) & seen_fused)) {
                    RSYM = 0;
                }
                seen_fused = TileLoader.seen35 & getSeenReversedHorizontal(35);
                if ((TileLoader.wall35 & seen_fused) != (getWallReversedHorizontal(35) & seen_fused)) {
                    RSYM = 0;
                }
                if ((TileLoader.ruin35 & seen_fused) != (getRuinReversedHorizontal(35) & seen_fused)) {
                    RSYM = 0;
                }
                seen_fused = TileLoader.seen36 & getSeenReversedHorizontal(36);
                if ((TileLoader.wall36 & seen_fused) != (getWallReversedHorizontal(36) & seen_fused)) {
                    RSYM = 0;
                }
                if ((TileLoader.ruin36 & seen_fused) != (getRuinReversedHorizontal(36) & seen_fused)) {
                    RSYM = 0;
                }
                
            }
            case 33 -> {
                seen_fused = TileLoader.seen29 & getSeenReversedHorizontal(29);
                if ((TileLoader.wall29 & seen_fused) != (getWallReversedHorizontal(29) & seen_fused)) {
                    RSYM = 0;
                }
                if ((TileLoader.ruin29 & seen_fused) != (getRuinReversedHorizontal(29) & seen_fused)) {
                    RSYM = 0;
                }
                seen_fused = TileLoader.seen30 & getSeenReversedHorizontal(30);
                if ((TileLoader.wall30 & seen_fused) != (getWallReversedHorizontal(30) & seen_fused)) {
                    RSYM = 0;
                }
                if ((TileLoader.ruin30 & seen_fused) != (getRuinReversedHorizontal(30) & seen_fused)) {
                    RSYM = 0;
                }
                seen_fused = TileLoader.seen31 & getSeenReversedHorizontal(31);
                if ((TileLoader.wall31 & seen_fused) != (getWallReversedHorizontal(31) & seen_fused)) {
                    RSYM = 0;
                }
                if ((TileLoader.ruin31 & seen_fused) != (getRuinReversedHorizontal(31) & seen_fused)) {
                    RSYM = 0;
                }
                seen_fused = TileLoader.seen32 & getSeenReversedHorizontal(32);
                if ((TileLoader.wall32 & seen_fused) != (getWallReversedHorizontal(32) & seen_fused)) {
                    RSYM = 0;
                }
                if ((TileLoader.ruin32 & seen_fused) != (getRuinReversedHorizontal(32) & seen_fused)) {
                    RSYM = 0;
                }
                seen_fused = TileLoader.seen33 & getSeenReversedHorizontal(33);
                if ((TileLoader.wall33 & seen_fused) != (getWallReversedHorizontal(33) & seen_fused)) {
                    RSYM = 0;
                }
                if ((TileLoader.ruin33 & seen_fused) != (getRuinReversedHorizontal(33) & seen_fused)) {
                    RSYM = 0;
                }
                seen_fused = TileLoader.seen34 & getSeenReversedHorizontal(34);
                if ((TileLoader.wall34 & seen_fused) != (getWallReversedHorizontal(34) & seen_fused)) {
                    RSYM = 0;
                }
                if ((TileLoader.ruin34 & seen_fused) != (getRuinReversedHorizontal(34) & seen_fused)) {
                    RSYM = 0;
                }
                seen_fused = TileLoader.seen35 & getSeenReversedHorizontal(35);
                if ((TileLoader.wall35 & seen_fused) != (getWallReversedHorizontal(35) & seen_fused)) {
                    RSYM = 0;
                }
                if ((TileLoader.ruin35 & seen_fused) != (getRuinReversedHorizontal(35) & seen_fused)) {
                    RSYM = 0;
                }
                seen_fused = TileLoader.seen36 & getSeenReversedHorizontal(36);
                if ((TileLoader.wall36 & seen_fused) != (getWallReversedHorizontal(36) & seen_fused)) {
                    RSYM = 0;
                }
                if ((TileLoader.ruin36 & seen_fused) != (getRuinReversedHorizontal(36) & seen_fused)) {
                    RSYM = 0;
                }
                seen_fused = TileLoader.seen37 & getSeenReversedHorizontal(37);
                if ((TileLoader.wall37 & seen_fused) != (getWallReversedHorizontal(37) & seen_fused)) {
                    RSYM = 0;
                }
                if ((TileLoader.ruin37 & seen_fused) != (getRuinReversedHorizontal(37) & seen_fused)) {
                    RSYM = 0;
                }
                
            }
            case 34 -> {
                seen_fused = TileLoader.seen30 & getSeenReversedHorizontal(30);
                if ((TileLoader.wall30 & seen_fused) != (getWallReversedHorizontal(30) & seen_fused)) {
                    RSYM = 0;
                }
                if ((TileLoader.ruin30 & seen_fused) != (getRuinReversedHorizontal(30) & seen_fused)) {
                    RSYM = 0;
                }
                seen_fused = TileLoader.seen31 & getSeenReversedHorizontal(31);
                if ((TileLoader.wall31 & seen_fused) != (getWallReversedHorizontal(31) & seen_fused)) {
                    RSYM = 0;
                }
                if ((TileLoader.ruin31 & seen_fused) != (getRuinReversedHorizontal(31) & seen_fused)) {
                    RSYM = 0;
                }
                seen_fused = TileLoader.seen32 & getSeenReversedHorizontal(32);
                if ((TileLoader.wall32 & seen_fused) != (getWallReversedHorizontal(32) & seen_fused)) {
                    RSYM = 0;
                }
                if ((TileLoader.ruin32 & seen_fused) != (getRuinReversedHorizontal(32) & seen_fused)) {
                    RSYM = 0;
                }
                seen_fused = TileLoader.seen33 & getSeenReversedHorizontal(33);
                if ((TileLoader.wall33 & seen_fused) != (getWallReversedHorizontal(33) & seen_fused)) {
                    RSYM = 0;
                }
                if ((TileLoader.ruin33 & seen_fused) != (getRuinReversedHorizontal(33) & seen_fused)) {
                    RSYM = 0;
                }
                seen_fused = TileLoader.seen34 & getSeenReversedHorizontal(34);
                if ((TileLoader.wall34 & seen_fused) != (getWallReversedHorizontal(34) & seen_fused)) {
                    RSYM = 0;
                }
                if ((TileLoader.ruin34 & seen_fused) != (getRuinReversedHorizontal(34) & seen_fused)) {
                    RSYM = 0;
                }
                seen_fused = TileLoader.seen35 & getSeenReversedHorizontal(35);
                if ((TileLoader.wall35 & seen_fused) != (getWallReversedHorizontal(35) & seen_fused)) {
                    RSYM = 0;
                }
                if ((TileLoader.ruin35 & seen_fused) != (getRuinReversedHorizontal(35) & seen_fused)) {
                    RSYM = 0;
                }
                seen_fused = TileLoader.seen36 & getSeenReversedHorizontal(36);
                if ((TileLoader.wall36 & seen_fused) != (getWallReversedHorizontal(36) & seen_fused)) {
                    RSYM = 0;
                }
                if ((TileLoader.ruin36 & seen_fused) != (getRuinReversedHorizontal(36) & seen_fused)) {
                    RSYM = 0;
                }
                seen_fused = TileLoader.seen37 & getSeenReversedHorizontal(37);
                if ((TileLoader.wall37 & seen_fused) != (getWallReversedHorizontal(37) & seen_fused)) {
                    RSYM = 0;
                }
                if ((TileLoader.ruin37 & seen_fused) != (getRuinReversedHorizontal(37) & seen_fused)) {
                    RSYM = 0;
                }
                seen_fused = TileLoader.seen38 & getSeenReversedHorizontal(38);
                if ((TileLoader.wall38 & seen_fused) != (getWallReversedHorizontal(38) & seen_fused)) {
                    RSYM = 0;
                }
                if ((TileLoader.ruin38 & seen_fused) != (getRuinReversedHorizontal(38) & seen_fused)) {
                    RSYM = 0;
                }
                
            }
            case 35 -> {
                seen_fused = TileLoader.seen31 & getSeenReversedHorizontal(31);
                if ((TileLoader.wall31 & seen_fused) != (getWallReversedHorizontal(31) & seen_fused)) {
                    RSYM = 0;
                }
                if ((TileLoader.ruin31 & seen_fused) != (getRuinReversedHorizontal(31) & seen_fused)) {
                    RSYM = 0;
                }
                seen_fused = TileLoader.seen32 & getSeenReversedHorizontal(32);
                if ((TileLoader.wall32 & seen_fused) != (getWallReversedHorizontal(32) & seen_fused)) {
                    RSYM = 0;
                }
                if ((TileLoader.ruin32 & seen_fused) != (getRuinReversedHorizontal(32) & seen_fused)) {
                    RSYM = 0;
                }
                seen_fused = TileLoader.seen33 & getSeenReversedHorizontal(33);
                if ((TileLoader.wall33 & seen_fused) != (getWallReversedHorizontal(33) & seen_fused)) {
                    RSYM = 0;
                }
                if ((TileLoader.ruin33 & seen_fused) != (getRuinReversedHorizontal(33) & seen_fused)) {
                    RSYM = 0;
                }
                seen_fused = TileLoader.seen34 & getSeenReversedHorizontal(34);
                if ((TileLoader.wall34 & seen_fused) != (getWallReversedHorizontal(34) & seen_fused)) {
                    RSYM = 0;
                }
                if ((TileLoader.ruin34 & seen_fused) != (getRuinReversedHorizontal(34) & seen_fused)) {
                    RSYM = 0;
                }
                seen_fused = TileLoader.seen35 & getSeenReversedHorizontal(35);
                if ((TileLoader.wall35 & seen_fused) != (getWallReversedHorizontal(35) & seen_fused)) {
                    RSYM = 0;
                }
                if ((TileLoader.ruin35 & seen_fused) != (getRuinReversedHorizontal(35) & seen_fused)) {
                    RSYM = 0;
                }
                seen_fused = TileLoader.seen36 & getSeenReversedHorizontal(36);
                if ((TileLoader.wall36 & seen_fused) != (getWallReversedHorizontal(36) & seen_fused)) {
                    RSYM = 0;
                }
                if ((TileLoader.ruin36 & seen_fused) != (getRuinReversedHorizontal(36) & seen_fused)) {
                    RSYM = 0;
                }
                seen_fused = TileLoader.seen37 & getSeenReversedHorizontal(37);
                if ((TileLoader.wall37 & seen_fused) != (getWallReversedHorizontal(37) & seen_fused)) {
                    RSYM = 0;
                }
                if ((TileLoader.ruin37 & seen_fused) != (getRuinReversedHorizontal(37) & seen_fused)) {
                    RSYM = 0;
                }
                seen_fused = TileLoader.seen38 & getSeenReversedHorizontal(38);
                if ((TileLoader.wall38 & seen_fused) != (getWallReversedHorizontal(38) & seen_fused)) {
                    RSYM = 0;
                }
                if ((TileLoader.ruin38 & seen_fused) != (getRuinReversedHorizontal(38) & seen_fused)) {
                    RSYM = 0;
                }
                seen_fused = TileLoader.seen39 & getSeenReversedHorizontal(39);
                if ((TileLoader.wall39 & seen_fused) != (getWallReversedHorizontal(39) & seen_fused)) {
                    RSYM = 0;
                }
                if ((TileLoader.ruin39 & seen_fused) != (getRuinReversedHorizontal(39) & seen_fused)) {
                    RSYM = 0;
                }
                
            }
            case 36 -> {
                seen_fused = TileLoader.seen32 & getSeenReversedHorizontal(32);
                if ((TileLoader.wall32 & seen_fused) != (getWallReversedHorizontal(32) & seen_fused)) {
                    RSYM = 0;
                }
                if ((TileLoader.ruin32 & seen_fused) != (getRuinReversedHorizontal(32) & seen_fused)) {
                    RSYM = 0;
                }
                seen_fused = TileLoader.seen33 & getSeenReversedHorizontal(33);
                if ((TileLoader.wall33 & seen_fused) != (getWallReversedHorizontal(33) & seen_fused)) {
                    RSYM = 0;
                }
                if ((TileLoader.ruin33 & seen_fused) != (getRuinReversedHorizontal(33) & seen_fused)) {
                    RSYM = 0;
                }
                seen_fused = TileLoader.seen34 & getSeenReversedHorizontal(34);
                if ((TileLoader.wall34 & seen_fused) != (getWallReversedHorizontal(34) & seen_fused)) {
                    RSYM = 0;
                }
                if ((TileLoader.ruin34 & seen_fused) != (getRuinReversedHorizontal(34) & seen_fused)) {
                    RSYM = 0;
                }
                seen_fused = TileLoader.seen35 & getSeenReversedHorizontal(35);
                if ((TileLoader.wall35 & seen_fused) != (getWallReversedHorizontal(35) & seen_fused)) {
                    RSYM = 0;
                }
                if ((TileLoader.ruin35 & seen_fused) != (getRuinReversedHorizontal(35) & seen_fused)) {
                    RSYM = 0;
                }
                seen_fused = TileLoader.seen36 & getSeenReversedHorizontal(36);
                if ((TileLoader.wall36 & seen_fused) != (getWallReversedHorizontal(36) & seen_fused)) {
                    RSYM = 0;
                }
                if ((TileLoader.ruin36 & seen_fused) != (getRuinReversedHorizontal(36) & seen_fused)) {
                    RSYM = 0;
                }
                seen_fused = TileLoader.seen37 & getSeenReversedHorizontal(37);
                if ((TileLoader.wall37 & seen_fused) != (getWallReversedHorizontal(37) & seen_fused)) {
                    RSYM = 0;
                }
                if ((TileLoader.ruin37 & seen_fused) != (getRuinReversedHorizontal(37) & seen_fused)) {
                    RSYM = 0;
                }
                seen_fused = TileLoader.seen38 & getSeenReversedHorizontal(38);
                if ((TileLoader.wall38 & seen_fused) != (getWallReversedHorizontal(38) & seen_fused)) {
                    RSYM = 0;
                }
                if ((TileLoader.ruin38 & seen_fused) != (getRuinReversedHorizontal(38) & seen_fused)) {
                    RSYM = 0;
                }
                seen_fused = TileLoader.seen39 & getSeenReversedHorizontal(39);
                if ((TileLoader.wall39 & seen_fused) != (getWallReversedHorizontal(39) & seen_fused)) {
                    RSYM = 0;
                }
                if ((TileLoader.ruin39 & seen_fused) != (getRuinReversedHorizontal(39) & seen_fused)) {
                    RSYM = 0;
                }
                seen_fused = TileLoader.seen40 & getSeenReversedHorizontal(40);
                if ((TileLoader.wall40 & seen_fused) != (getWallReversedHorizontal(40) & seen_fused)) {
                    RSYM = 0;
                }
                if ((TileLoader.ruin40 & seen_fused) != (getRuinReversedHorizontal(40) & seen_fused)) {
                    RSYM = 0;
                }
                
            }
            case 37 -> {
                seen_fused = TileLoader.seen33 & getSeenReversedHorizontal(33);
                if ((TileLoader.wall33 & seen_fused) != (getWallReversedHorizontal(33) & seen_fused)) {
                    RSYM = 0;
                }
                if ((TileLoader.ruin33 & seen_fused) != (getRuinReversedHorizontal(33) & seen_fused)) {
                    RSYM = 0;
                }
                seen_fused = TileLoader.seen34 & getSeenReversedHorizontal(34);
                if ((TileLoader.wall34 & seen_fused) != (getWallReversedHorizontal(34) & seen_fused)) {
                    RSYM = 0;
                }
                if ((TileLoader.ruin34 & seen_fused) != (getRuinReversedHorizontal(34) & seen_fused)) {
                    RSYM = 0;
                }
                seen_fused = TileLoader.seen35 & getSeenReversedHorizontal(35);
                if ((TileLoader.wall35 & seen_fused) != (getWallReversedHorizontal(35) & seen_fused)) {
                    RSYM = 0;
                }
                if ((TileLoader.ruin35 & seen_fused) != (getRuinReversedHorizontal(35) & seen_fused)) {
                    RSYM = 0;
                }
                seen_fused = TileLoader.seen36 & getSeenReversedHorizontal(36);
                if ((TileLoader.wall36 & seen_fused) != (getWallReversedHorizontal(36) & seen_fused)) {
                    RSYM = 0;
                }
                if ((TileLoader.ruin36 & seen_fused) != (getRuinReversedHorizontal(36) & seen_fused)) {
                    RSYM = 0;
                }
                seen_fused = TileLoader.seen37 & getSeenReversedHorizontal(37);
                if ((TileLoader.wall37 & seen_fused) != (getWallReversedHorizontal(37) & seen_fused)) {
                    RSYM = 0;
                }
                if ((TileLoader.ruin37 & seen_fused) != (getRuinReversedHorizontal(37) & seen_fused)) {
                    RSYM = 0;
                }
                seen_fused = TileLoader.seen38 & getSeenReversedHorizontal(38);
                if ((TileLoader.wall38 & seen_fused) != (getWallReversedHorizontal(38) & seen_fused)) {
                    RSYM = 0;
                }
                if ((TileLoader.ruin38 & seen_fused) != (getRuinReversedHorizontal(38) & seen_fused)) {
                    RSYM = 0;
                }
                seen_fused = TileLoader.seen39 & getSeenReversedHorizontal(39);
                if ((TileLoader.wall39 & seen_fused) != (getWallReversedHorizontal(39) & seen_fused)) {
                    RSYM = 0;
                }
                if ((TileLoader.ruin39 & seen_fused) != (getRuinReversedHorizontal(39) & seen_fused)) {
                    RSYM = 0;
                }
                seen_fused = TileLoader.seen40 & getSeenReversedHorizontal(40);
                if ((TileLoader.wall40 & seen_fused) != (getWallReversedHorizontal(40) & seen_fused)) {
                    RSYM = 0;
                }
                if ((TileLoader.ruin40 & seen_fused) != (getRuinReversedHorizontal(40) & seen_fused)) {
                    RSYM = 0;
                }
                seen_fused = TileLoader.seen41 & getSeenReversedHorizontal(41);
                if ((TileLoader.wall41 & seen_fused) != (getWallReversedHorizontal(41) & seen_fused)) {
                    RSYM = 0;
                }
                if ((TileLoader.ruin41 & seen_fused) != (getRuinReversedHorizontal(41) & seen_fused)) {
                    RSYM = 0;
                }
                
            }
            case 38 -> {
                seen_fused = TileLoader.seen34 & getSeenReversedHorizontal(34);
                if ((TileLoader.wall34 & seen_fused) != (getWallReversedHorizontal(34) & seen_fused)) {
                    RSYM = 0;
                }
                if ((TileLoader.ruin34 & seen_fused) != (getRuinReversedHorizontal(34) & seen_fused)) {
                    RSYM = 0;
                }
                seen_fused = TileLoader.seen35 & getSeenReversedHorizontal(35);
                if ((TileLoader.wall35 & seen_fused) != (getWallReversedHorizontal(35) & seen_fused)) {
                    RSYM = 0;
                }
                if ((TileLoader.ruin35 & seen_fused) != (getRuinReversedHorizontal(35) & seen_fused)) {
                    RSYM = 0;
                }
                seen_fused = TileLoader.seen36 & getSeenReversedHorizontal(36);
                if ((TileLoader.wall36 & seen_fused) != (getWallReversedHorizontal(36) & seen_fused)) {
                    RSYM = 0;
                }
                if ((TileLoader.ruin36 & seen_fused) != (getRuinReversedHorizontal(36) & seen_fused)) {
                    RSYM = 0;
                }
                seen_fused = TileLoader.seen37 & getSeenReversedHorizontal(37);
                if ((TileLoader.wall37 & seen_fused) != (getWallReversedHorizontal(37) & seen_fused)) {
                    RSYM = 0;
                }
                if ((TileLoader.ruin37 & seen_fused) != (getRuinReversedHorizontal(37) & seen_fused)) {
                    RSYM = 0;
                }
                seen_fused = TileLoader.seen38 & getSeenReversedHorizontal(38);
                if ((TileLoader.wall38 & seen_fused) != (getWallReversedHorizontal(38) & seen_fused)) {
                    RSYM = 0;
                }
                if ((TileLoader.ruin38 & seen_fused) != (getRuinReversedHorizontal(38) & seen_fused)) {
                    RSYM = 0;
                }
                seen_fused = TileLoader.seen39 & getSeenReversedHorizontal(39);
                if ((TileLoader.wall39 & seen_fused) != (getWallReversedHorizontal(39) & seen_fused)) {
                    RSYM = 0;
                }
                if ((TileLoader.ruin39 & seen_fused) != (getRuinReversedHorizontal(39) & seen_fused)) {
                    RSYM = 0;
                }
                seen_fused = TileLoader.seen40 & getSeenReversedHorizontal(40);
                if ((TileLoader.wall40 & seen_fused) != (getWallReversedHorizontal(40) & seen_fused)) {
                    RSYM = 0;
                }
                if ((TileLoader.ruin40 & seen_fused) != (getRuinReversedHorizontal(40) & seen_fused)) {
                    RSYM = 0;
                }
                seen_fused = TileLoader.seen41 & getSeenReversedHorizontal(41);
                if ((TileLoader.wall41 & seen_fused) != (getWallReversedHorizontal(41) & seen_fused)) {
                    RSYM = 0;
                }
                if ((TileLoader.ruin41 & seen_fused) != (getRuinReversedHorizontal(41) & seen_fused)) {
                    RSYM = 0;
                }
                seen_fused = TileLoader.seen42 & getSeenReversedHorizontal(42);
                if ((TileLoader.wall42 & seen_fused) != (getWallReversedHorizontal(42) & seen_fused)) {
                    RSYM = 0;
                }
                if ((TileLoader.ruin42 & seen_fused) != (getRuinReversedHorizontal(42) & seen_fused)) {
                    RSYM = 0;
                }
                
            }
            case 39 -> {
                seen_fused = TileLoader.seen35 & getSeenReversedHorizontal(35);
                if ((TileLoader.wall35 & seen_fused) != (getWallReversedHorizontal(35) & seen_fused)) {
                    RSYM = 0;
                }
                if ((TileLoader.ruin35 & seen_fused) != (getRuinReversedHorizontal(35) & seen_fused)) {
                    RSYM = 0;
                }
                seen_fused = TileLoader.seen36 & getSeenReversedHorizontal(36);
                if ((TileLoader.wall36 & seen_fused) != (getWallReversedHorizontal(36) & seen_fused)) {
                    RSYM = 0;
                }
                if ((TileLoader.ruin36 & seen_fused) != (getRuinReversedHorizontal(36) & seen_fused)) {
                    RSYM = 0;
                }
                seen_fused = TileLoader.seen37 & getSeenReversedHorizontal(37);
                if ((TileLoader.wall37 & seen_fused) != (getWallReversedHorizontal(37) & seen_fused)) {
                    RSYM = 0;
                }
                if ((TileLoader.ruin37 & seen_fused) != (getRuinReversedHorizontal(37) & seen_fused)) {
                    RSYM = 0;
                }
                seen_fused = TileLoader.seen38 & getSeenReversedHorizontal(38);
                if ((TileLoader.wall38 & seen_fused) != (getWallReversedHorizontal(38) & seen_fused)) {
                    RSYM = 0;
                }
                if ((TileLoader.ruin38 & seen_fused) != (getRuinReversedHorizontal(38) & seen_fused)) {
                    RSYM = 0;
                }
                seen_fused = TileLoader.seen39 & getSeenReversedHorizontal(39);
                if ((TileLoader.wall39 & seen_fused) != (getWallReversedHorizontal(39) & seen_fused)) {
                    RSYM = 0;
                }
                if ((TileLoader.ruin39 & seen_fused) != (getRuinReversedHorizontal(39) & seen_fused)) {
                    RSYM = 0;
                }
                seen_fused = TileLoader.seen40 & getSeenReversedHorizontal(40);
                if ((TileLoader.wall40 & seen_fused) != (getWallReversedHorizontal(40) & seen_fused)) {
                    RSYM = 0;
                }
                if ((TileLoader.ruin40 & seen_fused) != (getRuinReversedHorizontal(40) & seen_fused)) {
                    RSYM = 0;
                }
                seen_fused = TileLoader.seen41 & getSeenReversedHorizontal(41);
                if ((TileLoader.wall41 & seen_fused) != (getWallReversedHorizontal(41) & seen_fused)) {
                    RSYM = 0;
                }
                if ((TileLoader.ruin41 & seen_fused) != (getRuinReversedHorizontal(41) & seen_fused)) {
                    RSYM = 0;
                }
                seen_fused = TileLoader.seen42 & getSeenReversedHorizontal(42);
                if ((TileLoader.wall42 & seen_fused) != (getWallReversedHorizontal(42) & seen_fused)) {
                    RSYM = 0;
                }
                if ((TileLoader.ruin42 & seen_fused) != (getRuinReversedHorizontal(42) & seen_fused)) {
                    RSYM = 0;
                }
                seen_fused = TileLoader.seen43 & getSeenReversedHorizontal(43);
                if ((TileLoader.wall43 & seen_fused) != (getWallReversedHorizontal(43) & seen_fused)) {
                    RSYM = 0;
                }
                if ((TileLoader.ruin43 & seen_fused) != (getRuinReversedHorizontal(43) & seen_fused)) {
                    RSYM = 0;
                }
                
            }
            case 40 -> {
                seen_fused = TileLoader.seen36 & getSeenReversedHorizontal(36);
                if ((TileLoader.wall36 & seen_fused) != (getWallReversedHorizontal(36) & seen_fused)) {
                    RSYM = 0;
                }
                if ((TileLoader.ruin36 & seen_fused) != (getRuinReversedHorizontal(36) & seen_fused)) {
                    RSYM = 0;
                }
                seen_fused = TileLoader.seen37 & getSeenReversedHorizontal(37);
                if ((TileLoader.wall37 & seen_fused) != (getWallReversedHorizontal(37) & seen_fused)) {
                    RSYM = 0;
                }
                if ((TileLoader.ruin37 & seen_fused) != (getRuinReversedHorizontal(37) & seen_fused)) {
                    RSYM = 0;
                }
                seen_fused = TileLoader.seen38 & getSeenReversedHorizontal(38);
                if ((TileLoader.wall38 & seen_fused) != (getWallReversedHorizontal(38) & seen_fused)) {
                    RSYM = 0;
                }
                if ((TileLoader.ruin38 & seen_fused) != (getRuinReversedHorizontal(38) & seen_fused)) {
                    RSYM = 0;
                }
                seen_fused = TileLoader.seen39 & getSeenReversedHorizontal(39);
                if ((TileLoader.wall39 & seen_fused) != (getWallReversedHorizontal(39) & seen_fused)) {
                    RSYM = 0;
                }
                if ((TileLoader.ruin39 & seen_fused) != (getRuinReversedHorizontal(39) & seen_fused)) {
                    RSYM = 0;
                }
                seen_fused = TileLoader.seen40 & getSeenReversedHorizontal(40);
                if ((TileLoader.wall40 & seen_fused) != (getWallReversedHorizontal(40) & seen_fused)) {
                    RSYM = 0;
                }
                if ((TileLoader.ruin40 & seen_fused) != (getRuinReversedHorizontal(40) & seen_fused)) {
                    RSYM = 0;
                }
                seen_fused = TileLoader.seen41 & getSeenReversedHorizontal(41);
                if ((TileLoader.wall41 & seen_fused) != (getWallReversedHorizontal(41) & seen_fused)) {
                    RSYM = 0;
                }
                if ((TileLoader.ruin41 & seen_fused) != (getRuinReversedHorizontal(41) & seen_fused)) {
                    RSYM = 0;
                }
                seen_fused = TileLoader.seen42 & getSeenReversedHorizontal(42);
                if ((TileLoader.wall42 & seen_fused) != (getWallReversedHorizontal(42) & seen_fused)) {
                    RSYM = 0;
                }
                if ((TileLoader.ruin42 & seen_fused) != (getRuinReversedHorizontal(42) & seen_fused)) {
                    RSYM = 0;
                }
                seen_fused = TileLoader.seen43 & getSeenReversedHorizontal(43);
                if ((TileLoader.wall43 & seen_fused) != (getWallReversedHorizontal(43) & seen_fused)) {
                    RSYM = 0;
                }
                if ((TileLoader.ruin43 & seen_fused) != (getRuinReversedHorizontal(43) & seen_fused)) {
                    RSYM = 0;
                }
                seen_fused = TileLoader.seen44 & getSeenReversedHorizontal(44);
                if ((TileLoader.wall44 & seen_fused) != (getWallReversedHorizontal(44) & seen_fused)) {
                    RSYM = 0;
                }
                if ((TileLoader.ruin44 & seen_fused) != (getRuinReversedHorizontal(44) & seen_fused)) {
                    RSYM = 0;
                }
                
            }
            case 41 -> {
                seen_fused = TileLoader.seen37 & getSeenReversedHorizontal(37);
                if ((TileLoader.wall37 & seen_fused) != (getWallReversedHorizontal(37) & seen_fused)) {
                    RSYM = 0;
                }
                if ((TileLoader.ruin37 & seen_fused) != (getRuinReversedHorizontal(37) & seen_fused)) {
                    RSYM = 0;
                }
                seen_fused = TileLoader.seen38 & getSeenReversedHorizontal(38);
                if ((TileLoader.wall38 & seen_fused) != (getWallReversedHorizontal(38) & seen_fused)) {
                    RSYM = 0;
                }
                if ((TileLoader.ruin38 & seen_fused) != (getRuinReversedHorizontal(38) & seen_fused)) {
                    RSYM = 0;
                }
                seen_fused = TileLoader.seen39 & getSeenReversedHorizontal(39);
                if ((TileLoader.wall39 & seen_fused) != (getWallReversedHorizontal(39) & seen_fused)) {
                    RSYM = 0;
                }
                if ((TileLoader.ruin39 & seen_fused) != (getRuinReversedHorizontal(39) & seen_fused)) {
                    RSYM = 0;
                }
                seen_fused = TileLoader.seen40 & getSeenReversedHorizontal(40);
                if ((TileLoader.wall40 & seen_fused) != (getWallReversedHorizontal(40) & seen_fused)) {
                    RSYM = 0;
                }
                if ((TileLoader.ruin40 & seen_fused) != (getRuinReversedHorizontal(40) & seen_fused)) {
                    RSYM = 0;
                }
                seen_fused = TileLoader.seen41 & getSeenReversedHorizontal(41);
                if ((TileLoader.wall41 & seen_fused) != (getWallReversedHorizontal(41) & seen_fused)) {
                    RSYM = 0;
                }
                if ((TileLoader.ruin41 & seen_fused) != (getRuinReversedHorizontal(41) & seen_fused)) {
                    RSYM = 0;
                }
                seen_fused = TileLoader.seen42 & getSeenReversedHorizontal(42);
                if ((TileLoader.wall42 & seen_fused) != (getWallReversedHorizontal(42) & seen_fused)) {
                    RSYM = 0;
                }
                if ((TileLoader.ruin42 & seen_fused) != (getRuinReversedHorizontal(42) & seen_fused)) {
                    RSYM = 0;
                }
                seen_fused = TileLoader.seen43 & getSeenReversedHorizontal(43);
                if ((TileLoader.wall43 & seen_fused) != (getWallReversedHorizontal(43) & seen_fused)) {
                    RSYM = 0;
                }
                if ((TileLoader.ruin43 & seen_fused) != (getRuinReversedHorizontal(43) & seen_fused)) {
                    RSYM = 0;
                }
                seen_fused = TileLoader.seen44 & getSeenReversedHorizontal(44);
                if ((TileLoader.wall44 & seen_fused) != (getWallReversedHorizontal(44) & seen_fused)) {
                    RSYM = 0;
                }
                if ((TileLoader.ruin44 & seen_fused) != (getRuinReversedHorizontal(44) & seen_fused)) {
                    RSYM = 0;
                }
                seen_fused = TileLoader.seen45 & getSeenReversedHorizontal(45);
                if ((TileLoader.wall45 & seen_fused) != (getWallReversedHorizontal(45) & seen_fused)) {
                    RSYM = 0;
                }
                if ((TileLoader.ruin45 & seen_fused) != (getRuinReversedHorizontal(45) & seen_fused)) {
                    RSYM = 0;
                }
                
            }
            case 42 -> {
                seen_fused = TileLoader.seen38 & getSeenReversedHorizontal(38);
                if ((TileLoader.wall38 & seen_fused) != (getWallReversedHorizontal(38) & seen_fused)) {
                    RSYM = 0;
                }
                if ((TileLoader.ruin38 & seen_fused) != (getRuinReversedHorizontal(38) & seen_fused)) {
                    RSYM = 0;
                }
                seen_fused = TileLoader.seen39 & getSeenReversedHorizontal(39);
                if ((TileLoader.wall39 & seen_fused) != (getWallReversedHorizontal(39) & seen_fused)) {
                    RSYM = 0;
                }
                if ((TileLoader.ruin39 & seen_fused) != (getRuinReversedHorizontal(39) & seen_fused)) {
                    RSYM = 0;
                }
                seen_fused = TileLoader.seen40 & getSeenReversedHorizontal(40);
                if ((TileLoader.wall40 & seen_fused) != (getWallReversedHorizontal(40) & seen_fused)) {
                    RSYM = 0;
                }
                if ((TileLoader.ruin40 & seen_fused) != (getRuinReversedHorizontal(40) & seen_fused)) {
                    RSYM = 0;
                }
                seen_fused = TileLoader.seen41 & getSeenReversedHorizontal(41);
                if ((TileLoader.wall41 & seen_fused) != (getWallReversedHorizontal(41) & seen_fused)) {
                    RSYM = 0;
                }
                if ((TileLoader.ruin41 & seen_fused) != (getRuinReversedHorizontal(41) & seen_fused)) {
                    RSYM = 0;
                }
                seen_fused = TileLoader.seen42 & getSeenReversedHorizontal(42);
                if ((TileLoader.wall42 & seen_fused) != (getWallReversedHorizontal(42) & seen_fused)) {
                    RSYM = 0;
                }
                if ((TileLoader.ruin42 & seen_fused) != (getRuinReversedHorizontal(42) & seen_fused)) {
                    RSYM = 0;
                }
                seen_fused = TileLoader.seen43 & getSeenReversedHorizontal(43);
                if ((TileLoader.wall43 & seen_fused) != (getWallReversedHorizontal(43) & seen_fused)) {
                    RSYM = 0;
                }
                if ((TileLoader.ruin43 & seen_fused) != (getRuinReversedHorizontal(43) & seen_fused)) {
                    RSYM = 0;
                }
                seen_fused = TileLoader.seen44 & getSeenReversedHorizontal(44);
                if ((TileLoader.wall44 & seen_fused) != (getWallReversedHorizontal(44) & seen_fused)) {
                    RSYM = 0;
                }
                if ((TileLoader.ruin44 & seen_fused) != (getRuinReversedHorizontal(44) & seen_fused)) {
                    RSYM = 0;
                }
                seen_fused = TileLoader.seen45 & getSeenReversedHorizontal(45);
                if ((TileLoader.wall45 & seen_fused) != (getWallReversedHorizontal(45) & seen_fused)) {
                    RSYM = 0;
                }
                if ((TileLoader.ruin45 & seen_fused) != (getRuinReversedHorizontal(45) & seen_fused)) {
                    RSYM = 0;
                }
                seen_fused = TileLoader.seen46 & getSeenReversedHorizontal(46);
                if ((TileLoader.wall46 & seen_fused) != (getWallReversedHorizontal(46) & seen_fused)) {
                    RSYM = 0;
                }
                if ((TileLoader.ruin46 & seen_fused) != (getRuinReversedHorizontal(46) & seen_fused)) {
                    RSYM = 0;
                }
                
            }
            case 43 -> {
                seen_fused = TileLoader.seen39 & getSeenReversedHorizontal(39);
                if ((TileLoader.wall39 & seen_fused) != (getWallReversedHorizontal(39) & seen_fused)) {
                    RSYM = 0;
                }
                if ((TileLoader.ruin39 & seen_fused) != (getRuinReversedHorizontal(39) & seen_fused)) {
                    RSYM = 0;
                }
                seen_fused = TileLoader.seen40 & getSeenReversedHorizontal(40);
                if ((TileLoader.wall40 & seen_fused) != (getWallReversedHorizontal(40) & seen_fused)) {
                    RSYM = 0;
                }
                if ((TileLoader.ruin40 & seen_fused) != (getRuinReversedHorizontal(40) & seen_fused)) {
                    RSYM = 0;
                }
                seen_fused = TileLoader.seen41 & getSeenReversedHorizontal(41);
                if ((TileLoader.wall41 & seen_fused) != (getWallReversedHorizontal(41) & seen_fused)) {
                    RSYM = 0;
                }
                if ((TileLoader.ruin41 & seen_fused) != (getRuinReversedHorizontal(41) & seen_fused)) {
                    RSYM = 0;
                }
                seen_fused = TileLoader.seen42 & getSeenReversedHorizontal(42);
                if ((TileLoader.wall42 & seen_fused) != (getWallReversedHorizontal(42) & seen_fused)) {
                    RSYM = 0;
                }
                if ((TileLoader.ruin42 & seen_fused) != (getRuinReversedHorizontal(42) & seen_fused)) {
                    RSYM = 0;
                }
                seen_fused = TileLoader.seen43 & getSeenReversedHorizontal(43);
                if ((TileLoader.wall43 & seen_fused) != (getWallReversedHorizontal(43) & seen_fused)) {
                    RSYM = 0;
                }
                if ((TileLoader.ruin43 & seen_fused) != (getRuinReversedHorizontal(43) & seen_fused)) {
                    RSYM = 0;
                }
                seen_fused = TileLoader.seen44 & getSeenReversedHorizontal(44);
                if ((TileLoader.wall44 & seen_fused) != (getWallReversedHorizontal(44) & seen_fused)) {
                    RSYM = 0;
                }
                if ((TileLoader.ruin44 & seen_fused) != (getRuinReversedHorizontal(44) & seen_fused)) {
                    RSYM = 0;
                }
                seen_fused = TileLoader.seen45 & getSeenReversedHorizontal(45);
                if ((TileLoader.wall45 & seen_fused) != (getWallReversedHorizontal(45) & seen_fused)) {
                    RSYM = 0;
                }
                if ((TileLoader.ruin45 & seen_fused) != (getRuinReversedHorizontal(45) & seen_fused)) {
                    RSYM = 0;
                }
                seen_fused = TileLoader.seen46 & getSeenReversedHorizontal(46);
                if ((TileLoader.wall46 & seen_fused) != (getWallReversedHorizontal(46) & seen_fused)) {
                    RSYM = 0;
                }
                if ((TileLoader.ruin46 & seen_fused) != (getRuinReversedHorizontal(46) & seen_fused)) {
                    RSYM = 0;
                }
                seen_fused = TileLoader.seen47 & getSeenReversedHorizontal(47);
                if ((TileLoader.wall47 & seen_fused) != (getWallReversedHorizontal(47) & seen_fused)) {
                    RSYM = 0;
                }
                if ((TileLoader.ruin47 & seen_fused) != (getRuinReversedHorizontal(47) & seen_fused)) {
                    RSYM = 0;
                }
                
            }
            case 44 -> {
                seen_fused = TileLoader.seen40 & getSeenReversedHorizontal(40);
                if ((TileLoader.wall40 & seen_fused) != (getWallReversedHorizontal(40) & seen_fused)) {
                    RSYM = 0;
                }
                if ((TileLoader.ruin40 & seen_fused) != (getRuinReversedHorizontal(40) & seen_fused)) {
                    RSYM = 0;
                }
                seen_fused = TileLoader.seen41 & getSeenReversedHorizontal(41);
                if ((TileLoader.wall41 & seen_fused) != (getWallReversedHorizontal(41) & seen_fused)) {
                    RSYM = 0;
                }
                if ((TileLoader.ruin41 & seen_fused) != (getRuinReversedHorizontal(41) & seen_fused)) {
                    RSYM = 0;
                }
                seen_fused = TileLoader.seen42 & getSeenReversedHorizontal(42);
                if ((TileLoader.wall42 & seen_fused) != (getWallReversedHorizontal(42) & seen_fused)) {
                    RSYM = 0;
                }
                if ((TileLoader.ruin42 & seen_fused) != (getRuinReversedHorizontal(42) & seen_fused)) {
                    RSYM = 0;
                }
                seen_fused = TileLoader.seen43 & getSeenReversedHorizontal(43);
                if ((TileLoader.wall43 & seen_fused) != (getWallReversedHorizontal(43) & seen_fused)) {
                    RSYM = 0;
                }
                if ((TileLoader.ruin43 & seen_fused) != (getRuinReversedHorizontal(43) & seen_fused)) {
                    RSYM = 0;
                }
                seen_fused = TileLoader.seen44 & getSeenReversedHorizontal(44);
                if ((TileLoader.wall44 & seen_fused) != (getWallReversedHorizontal(44) & seen_fused)) {
                    RSYM = 0;
                }
                if ((TileLoader.ruin44 & seen_fused) != (getRuinReversedHorizontal(44) & seen_fused)) {
                    RSYM = 0;
                }
                seen_fused = TileLoader.seen45 & getSeenReversedHorizontal(45);
                if ((TileLoader.wall45 & seen_fused) != (getWallReversedHorizontal(45) & seen_fused)) {
                    RSYM = 0;
                }
                if ((TileLoader.ruin45 & seen_fused) != (getRuinReversedHorizontal(45) & seen_fused)) {
                    RSYM = 0;
                }
                seen_fused = TileLoader.seen46 & getSeenReversedHorizontal(46);
                if ((TileLoader.wall46 & seen_fused) != (getWallReversedHorizontal(46) & seen_fused)) {
                    RSYM = 0;
                }
                if ((TileLoader.ruin46 & seen_fused) != (getRuinReversedHorizontal(46) & seen_fused)) {
                    RSYM = 0;
                }
                seen_fused = TileLoader.seen47 & getSeenReversedHorizontal(47);
                if ((TileLoader.wall47 & seen_fused) != (getWallReversedHorizontal(47) & seen_fused)) {
                    RSYM = 0;
                }
                if ((TileLoader.ruin47 & seen_fused) != (getRuinReversedHorizontal(47) & seen_fused)) {
                    RSYM = 0;
                }
                seen_fused = TileLoader.seen48 & getSeenReversedHorizontal(48);
                if ((TileLoader.wall48 & seen_fused) != (getWallReversedHorizontal(48) & seen_fused)) {
                    RSYM = 0;
                }
                if ((TileLoader.ruin48 & seen_fused) != (getRuinReversedHorizontal(48) & seen_fused)) {
                    RSYM = 0;
                }
                
            }
            case 45 -> {
                seen_fused = TileLoader.seen41 & getSeenReversedHorizontal(41);
                if ((TileLoader.wall41 & seen_fused) != (getWallReversedHorizontal(41) & seen_fused)) {
                    RSYM = 0;
                }
                if ((TileLoader.ruin41 & seen_fused) != (getRuinReversedHorizontal(41) & seen_fused)) {
                    RSYM = 0;
                }
                seen_fused = TileLoader.seen42 & getSeenReversedHorizontal(42);
                if ((TileLoader.wall42 & seen_fused) != (getWallReversedHorizontal(42) & seen_fused)) {
                    RSYM = 0;
                }
                if ((TileLoader.ruin42 & seen_fused) != (getRuinReversedHorizontal(42) & seen_fused)) {
                    RSYM = 0;
                }
                seen_fused = TileLoader.seen43 & getSeenReversedHorizontal(43);
                if ((TileLoader.wall43 & seen_fused) != (getWallReversedHorizontal(43) & seen_fused)) {
                    RSYM = 0;
                }
                if ((TileLoader.ruin43 & seen_fused) != (getRuinReversedHorizontal(43) & seen_fused)) {
                    RSYM = 0;
                }
                seen_fused = TileLoader.seen44 & getSeenReversedHorizontal(44);
                if ((TileLoader.wall44 & seen_fused) != (getWallReversedHorizontal(44) & seen_fused)) {
                    RSYM = 0;
                }
                if ((TileLoader.ruin44 & seen_fused) != (getRuinReversedHorizontal(44) & seen_fused)) {
                    RSYM = 0;
                }
                seen_fused = TileLoader.seen45 & getSeenReversedHorizontal(45);
                if ((TileLoader.wall45 & seen_fused) != (getWallReversedHorizontal(45) & seen_fused)) {
                    RSYM = 0;
                }
                if ((TileLoader.ruin45 & seen_fused) != (getRuinReversedHorizontal(45) & seen_fused)) {
                    RSYM = 0;
                }
                seen_fused = TileLoader.seen46 & getSeenReversedHorizontal(46);
                if ((TileLoader.wall46 & seen_fused) != (getWallReversedHorizontal(46) & seen_fused)) {
                    RSYM = 0;
                }
                if ((TileLoader.ruin46 & seen_fused) != (getRuinReversedHorizontal(46) & seen_fused)) {
                    RSYM = 0;
                }
                seen_fused = TileLoader.seen47 & getSeenReversedHorizontal(47);
                if ((TileLoader.wall47 & seen_fused) != (getWallReversedHorizontal(47) & seen_fused)) {
                    RSYM = 0;
                }
                if ((TileLoader.ruin47 & seen_fused) != (getRuinReversedHorizontal(47) & seen_fused)) {
                    RSYM = 0;
                }
                seen_fused = TileLoader.seen48 & getSeenReversedHorizontal(48);
                if ((TileLoader.wall48 & seen_fused) != (getWallReversedHorizontal(48) & seen_fused)) {
                    RSYM = 0;
                }
                if ((TileLoader.ruin48 & seen_fused) != (getRuinReversedHorizontal(48) & seen_fused)) {
                    RSYM = 0;
                }
                seen_fused = TileLoader.seen49 & getSeenReversedHorizontal(49);
                if ((TileLoader.wall49 & seen_fused) != (getWallReversedHorizontal(49) & seen_fused)) {
                    RSYM = 0;
                }
                if ((TileLoader.ruin49 & seen_fused) != (getRuinReversedHorizontal(49) & seen_fused)) {
                    RSYM = 0;
                }
                
            }
            case 46 -> {
                seen_fused = TileLoader.seen42 & getSeenReversedHorizontal(42);
                if ((TileLoader.wall42 & seen_fused) != (getWallReversedHorizontal(42) & seen_fused)) {
                    RSYM = 0;
                }
                if ((TileLoader.ruin42 & seen_fused) != (getRuinReversedHorizontal(42) & seen_fused)) {
                    RSYM = 0;
                }
                seen_fused = TileLoader.seen43 & getSeenReversedHorizontal(43);
                if ((TileLoader.wall43 & seen_fused) != (getWallReversedHorizontal(43) & seen_fused)) {
                    RSYM = 0;
                }
                if ((TileLoader.ruin43 & seen_fused) != (getRuinReversedHorizontal(43) & seen_fused)) {
                    RSYM = 0;
                }
                seen_fused = TileLoader.seen44 & getSeenReversedHorizontal(44);
                if ((TileLoader.wall44 & seen_fused) != (getWallReversedHorizontal(44) & seen_fused)) {
                    RSYM = 0;
                }
                if ((TileLoader.ruin44 & seen_fused) != (getRuinReversedHorizontal(44) & seen_fused)) {
                    RSYM = 0;
                }
                seen_fused = TileLoader.seen45 & getSeenReversedHorizontal(45);
                if ((TileLoader.wall45 & seen_fused) != (getWallReversedHorizontal(45) & seen_fused)) {
                    RSYM = 0;
                }
                if ((TileLoader.ruin45 & seen_fused) != (getRuinReversedHorizontal(45) & seen_fused)) {
                    RSYM = 0;
                }
                seen_fused = TileLoader.seen46 & getSeenReversedHorizontal(46);
                if ((TileLoader.wall46 & seen_fused) != (getWallReversedHorizontal(46) & seen_fused)) {
                    RSYM = 0;
                }
                if ((TileLoader.ruin46 & seen_fused) != (getRuinReversedHorizontal(46) & seen_fused)) {
                    RSYM = 0;
                }
                seen_fused = TileLoader.seen47 & getSeenReversedHorizontal(47);
                if ((TileLoader.wall47 & seen_fused) != (getWallReversedHorizontal(47) & seen_fused)) {
                    RSYM = 0;
                }
                if ((TileLoader.ruin47 & seen_fused) != (getRuinReversedHorizontal(47) & seen_fused)) {
                    RSYM = 0;
                }
                seen_fused = TileLoader.seen48 & getSeenReversedHorizontal(48);
                if ((TileLoader.wall48 & seen_fused) != (getWallReversedHorizontal(48) & seen_fused)) {
                    RSYM = 0;
                }
                if ((TileLoader.ruin48 & seen_fused) != (getRuinReversedHorizontal(48) & seen_fused)) {
                    RSYM = 0;
                }
                seen_fused = TileLoader.seen49 & getSeenReversedHorizontal(49);
                if ((TileLoader.wall49 & seen_fused) != (getWallReversedHorizontal(49) & seen_fused)) {
                    RSYM = 0;
                }
                if ((TileLoader.ruin49 & seen_fused) != (getRuinReversedHorizontal(49) & seen_fused)) {
                    RSYM = 0;
                }
                seen_fused = TileLoader.seen50 & getSeenReversedHorizontal(50);
                if ((TileLoader.wall50 & seen_fused) != (getWallReversedHorizontal(50) & seen_fused)) {
                    RSYM = 0;
                }
                if ((TileLoader.ruin50 & seen_fused) != (getRuinReversedHorizontal(50) & seen_fused)) {
                    RSYM = 0;
                }
                
            }
            case 47 -> {
                seen_fused = TileLoader.seen43 & getSeenReversedHorizontal(43);
                if ((TileLoader.wall43 & seen_fused) != (getWallReversedHorizontal(43) & seen_fused)) {
                    RSYM = 0;
                }
                if ((TileLoader.ruin43 & seen_fused) != (getRuinReversedHorizontal(43) & seen_fused)) {
                    RSYM = 0;
                }
                seen_fused = TileLoader.seen44 & getSeenReversedHorizontal(44);
                if ((TileLoader.wall44 & seen_fused) != (getWallReversedHorizontal(44) & seen_fused)) {
                    RSYM = 0;
                }
                if ((TileLoader.ruin44 & seen_fused) != (getRuinReversedHorizontal(44) & seen_fused)) {
                    RSYM = 0;
                }
                seen_fused = TileLoader.seen45 & getSeenReversedHorizontal(45);
                if ((TileLoader.wall45 & seen_fused) != (getWallReversedHorizontal(45) & seen_fused)) {
                    RSYM = 0;
                }
                if ((TileLoader.ruin45 & seen_fused) != (getRuinReversedHorizontal(45) & seen_fused)) {
                    RSYM = 0;
                }
                seen_fused = TileLoader.seen46 & getSeenReversedHorizontal(46);
                if ((TileLoader.wall46 & seen_fused) != (getWallReversedHorizontal(46) & seen_fused)) {
                    RSYM = 0;
                }
                if ((TileLoader.ruin46 & seen_fused) != (getRuinReversedHorizontal(46) & seen_fused)) {
                    RSYM = 0;
                }
                seen_fused = TileLoader.seen47 & getSeenReversedHorizontal(47);
                if ((TileLoader.wall47 & seen_fused) != (getWallReversedHorizontal(47) & seen_fused)) {
                    RSYM = 0;
                }
                if ((TileLoader.ruin47 & seen_fused) != (getRuinReversedHorizontal(47) & seen_fused)) {
                    RSYM = 0;
                }
                seen_fused = TileLoader.seen48 & getSeenReversedHorizontal(48);
                if ((TileLoader.wall48 & seen_fused) != (getWallReversedHorizontal(48) & seen_fused)) {
                    RSYM = 0;
                }
                if ((TileLoader.ruin48 & seen_fused) != (getRuinReversedHorizontal(48) & seen_fused)) {
                    RSYM = 0;
                }
                seen_fused = TileLoader.seen49 & getSeenReversedHorizontal(49);
                if ((TileLoader.wall49 & seen_fused) != (getWallReversedHorizontal(49) & seen_fused)) {
                    RSYM = 0;
                }
                if ((TileLoader.ruin49 & seen_fused) != (getRuinReversedHorizontal(49) & seen_fused)) {
                    RSYM = 0;
                }
                seen_fused = TileLoader.seen50 & getSeenReversedHorizontal(50);
                if ((TileLoader.wall50 & seen_fused) != (getWallReversedHorizontal(50) & seen_fused)) {
                    RSYM = 0;
                }
                if ((TileLoader.ruin50 & seen_fused) != (getRuinReversedHorizontal(50) & seen_fused)) {
                    RSYM = 0;
                }
                seen_fused = TileLoader.seen51 & getSeenReversedHorizontal(51);
                if ((TileLoader.wall51 & seen_fused) != (getWallReversedHorizontal(51) & seen_fused)) {
                    RSYM = 0;
                }
                if ((TileLoader.ruin51 & seen_fused) != (getRuinReversedHorizontal(51) & seen_fused)) {
                    RSYM = 0;
                }
                
            }
            case 48 -> {
                seen_fused = TileLoader.seen44 & getSeenReversedHorizontal(44);
                if ((TileLoader.wall44 & seen_fused) != (getWallReversedHorizontal(44) & seen_fused)) {
                    RSYM = 0;
                }
                if ((TileLoader.ruin44 & seen_fused) != (getRuinReversedHorizontal(44) & seen_fused)) {
                    RSYM = 0;
                }
                seen_fused = TileLoader.seen45 & getSeenReversedHorizontal(45);
                if ((TileLoader.wall45 & seen_fused) != (getWallReversedHorizontal(45) & seen_fused)) {
                    RSYM = 0;
                }
                if ((TileLoader.ruin45 & seen_fused) != (getRuinReversedHorizontal(45) & seen_fused)) {
                    RSYM = 0;
                }
                seen_fused = TileLoader.seen46 & getSeenReversedHorizontal(46);
                if ((TileLoader.wall46 & seen_fused) != (getWallReversedHorizontal(46) & seen_fused)) {
                    RSYM = 0;
                }
                if ((TileLoader.ruin46 & seen_fused) != (getRuinReversedHorizontal(46) & seen_fused)) {
                    RSYM = 0;
                }
                seen_fused = TileLoader.seen47 & getSeenReversedHorizontal(47);
                if ((TileLoader.wall47 & seen_fused) != (getWallReversedHorizontal(47) & seen_fused)) {
                    RSYM = 0;
                }
                if ((TileLoader.ruin47 & seen_fused) != (getRuinReversedHorizontal(47) & seen_fused)) {
                    RSYM = 0;
                }
                seen_fused = TileLoader.seen48 & getSeenReversedHorizontal(48);
                if ((TileLoader.wall48 & seen_fused) != (getWallReversedHorizontal(48) & seen_fused)) {
                    RSYM = 0;
                }
                if ((TileLoader.ruin48 & seen_fused) != (getRuinReversedHorizontal(48) & seen_fused)) {
                    RSYM = 0;
                }
                seen_fused = TileLoader.seen49 & getSeenReversedHorizontal(49);
                if ((TileLoader.wall49 & seen_fused) != (getWallReversedHorizontal(49) & seen_fused)) {
                    RSYM = 0;
                }
                if ((TileLoader.ruin49 & seen_fused) != (getRuinReversedHorizontal(49) & seen_fused)) {
                    RSYM = 0;
                }
                seen_fused = TileLoader.seen50 & getSeenReversedHorizontal(50);
                if ((TileLoader.wall50 & seen_fused) != (getWallReversedHorizontal(50) & seen_fused)) {
                    RSYM = 0;
                }
                if ((TileLoader.ruin50 & seen_fused) != (getRuinReversedHorizontal(50) & seen_fused)) {
                    RSYM = 0;
                }
                seen_fused = TileLoader.seen51 & getSeenReversedHorizontal(51);
                if ((TileLoader.wall51 & seen_fused) != (getWallReversedHorizontal(51) & seen_fused)) {
                    RSYM = 0;
                }
                if ((TileLoader.ruin51 & seen_fused) != (getRuinReversedHorizontal(51) & seen_fused)) {
                    RSYM = 0;
                }
                seen_fused = TileLoader.seen52 & getSeenReversedHorizontal(52);
                if ((TileLoader.wall52 & seen_fused) != (getWallReversedHorizontal(52) & seen_fused)) {
                    RSYM = 0;
                }
                if ((TileLoader.ruin52 & seen_fused) != (getRuinReversedHorizontal(52) & seen_fused)) {
                    RSYM = 0;
                }
                
            }
            case 49 -> {
                seen_fused = TileLoader.seen45 & getSeenReversedHorizontal(45);
                if ((TileLoader.wall45 & seen_fused) != (getWallReversedHorizontal(45) & seen_fused)) {
                    RSYM = 0;
                }
                if ((TileLoader.ruin45 & seen_fused) != (getRuinReversedHorizontal(45) & seen_fused)) {
                    RSYM = 0;
                }
                seen_fused = TileLoader.seen46 & getSeenReversedHorizontal(46);
                if ((TileLoader.wall46 & seen_fused) != (getWallReversedHorizontal(46) & seen_fused)) {
                    RSYM = 0;
                }
                if ((TileLoader.ruin46 & seen_fused) != (getRuinReversedHorizontal(46) & seen_fused)) {
                    RSYM = 0;
                }
                seen_fused = TileLoader.seen47 & getSeenReversedHorizontal(47);
                if ((TileLoader.wall47 & seen_fused) != (getWallReversedHorizontal(47) & seen_fused)) {
                    RSYM = 0;
                }
                if ((TileLoader.ruin47 & seen_fused) != (getRuinReversedHorizontal(47) & seen_fused)) {
                    RSYM = 0;
                }
                seen_fused = TileLoader.seen48 & getSeenReversedHorizontal(48);
                if ((TileLoader.wall48 & seen_fused) != (getWallReversedHorizontal(48) & seen_fused)) {
                    RSYM = 0;
                }
                if ((TileLoader.ruin48 & seen_fused) != (getRuinReversedHorizontal(48) & seen_fused)) {
                    RSYM = 0;
                }
                seen_fused = TileLoader.seen49 & getSeenReversedHorizontal(49);
                if ((TileLoader.wall49 & seen_fused) != (getWallReversedHorizontal(49) & seen_fused)) {
                    RSYM = 0;
                }
                if ((TileLoader.ruin49 & seen_fused) != (getRuinReversedHorizontal(49) & seen_fused)) {
                    RSYM = 0;
                }
                seen_fused = TileLoader.seen50 & getSeenReversedHorizontal(50);
                if ((TileLoader.wall50 & seen_fused) != (getWallReversedHorizontal(50) & seen_fused)) {
                    RSYM = 0;
                }
                if ((TileLoader.ruin50 & seen_fused) != (getRuinReversedHorizontal(50) & seen_fused)) {
                    RSYM = 0;
                }
                seen_fused = TileLoader.seen51 & getSeenReversedHorizontal(51);
                if ((TileLoader.wall51 & seen_fused) != (getWallReversedHorizontal(51) & seen_fused)) {
                    RSYM = 0;
                }
                if ((TileLoader.ruin51 & seen_fused) != (getRuinReversedHorizontal(51) & seen_fused)) {
                    RSYM = 0;
                }
                seen_fused = TileLoader.seen52 & getSeenReversedHorizontal(52);
                if ((TileLoader.wall52 & seen_fused) != (getWallReversedHorizontal(52) & seen_fused)) {
                    RSYM = 0;
                }
                if ((TileLoader.ruin52 & seen_fused) != (getRuinReversedHorizontal(52) & seen_fused)) {
                    RSYM = 0;
                }
                seen_fused = TileLoader.seen53 & getSeenReversedHorizontal(53);
                if ((TileLoader.wall53 & seen_fused) != (getWallReversedHorizontal(53) & seen_fused)) {
                    RSYM = 0;
                }
                if ((TileLoader.ruin53 & seen_fused) != (getRuinReversedHorizontal(53) & seen_fused)) {
                    RSYM = 0;
                }
                
            }
            case 50 -> {
                seen_fused = TileLoader.seen46 & getSeenReversedHorizontal(46);
                if ((TileLoader.wall46 & seen_fused) != (getWallReversedHorizontal(46) & seen_fused)) {
                    RSYM = 0;
                }
                if ((TileLoader.ruin46 & seen_fused) != (getRuinReversedHorizontal(46) & seen_fused)) {
                    RSYM = 0;
                }
                seen_fused = TileLoader.seen47 & getSeenReversedHorizontal(47);
                if ((TileLoader.wall47 & seen_fused) != (getWallReversedHorizontal(47) & seen_fused)) {
                    RSYM = 0;
                }
                if ((TileLoader.ruin47 & seen_fused) != (getRuinReversedHorizontal(47) & seen_fused)) {
                    RSYM = 0;
                }
                seen_fused = TileLoader.seen48 & getSeenReversedHorizontal(48);
                if ((TileLoader.wall48 & seen_fused) != (getWallReversedHorizontal(48) & seen_fused)) {
                    RSYM = 0;
                }
                if ((TileLoader.ruin48 & seen_fused) != (getRuinReversedHorizontal(48) & seen_fused)) {
                    RSYM = 0;
                }
                seen_fused = TileLoader.seen49 & getSeenReversedHorizontal(49);
                if ((TileLoader.wall49 & seen_fused) != (getWallReversedHorizontal(49) & seen_fused)) {
                    RSYM = 0;
                }
                if ((TileLoader.ruin49 & seen_fused) != (getRuinReversedHorizontal(49) & seen_fused)) {
                    RSYM = 0;
                }
                seen_fused = TileLoader.seen50 & getSeenReversedHorizontal(50);
                if ((TileLoader.wall50 & seen_fused) != (getWallReversedHorizontal(50) & seen_fused)) {
                    RSYM = 0;
                }
                if ((TileLoader.ruin50 & seen_fused) != (getRuinReversedHorizontal(50) & seen_fused)) {
                    RSYM = 0;
                }
                seen_fused = TileLoader.seen51 & getSeenReversedHorizontal(51);
                if ((TileLoader.wall51 & seen_fused) != (getWallReversedHorizontal(51) & seen_fused)) {
                    RSYM = 0;
                }
                if ((TileLoader.ruin51 & seen_fused) != (getRuinReversedHorizontal(51) & seen_fused)) {
                    RSYM = 0;
                }
                seen_fused = TileLoader.seen52 & getSeenReversedHorizontal(52);
                if ((TileLoader.wall52 & seen_fused) != (getWallReversedHorizontal(52) & seen_fused)) {
                    RSYM = 0;
                }
                if ((TileLoader.ruin52 & seen_fused) != (getRuinReversedHorizontal(52) & seen_fused)) {
                    RSYM = 0;
                }
                seen_fused = TileLoader.seen53 & getSeenReversedHorizontal(53);
                if ((TileLoader.wall53 & seen_fused) != (getWallReversedHorizontal(53) & seen_fused)) {
                    RSYM = 0;
                }
                if ((TileLoader.ruin53 & seen_fused) != (getRuinReversedHorizontal(53) & seen_fused)) {
                    RSYM = 0;
                }
                seen_fused = TileLoader.seen54 & getSeenReversedHorizontal(54);
                if ((TileLoader.wall54 & seen_fused) != (getWallReversedHorizontal(54) & seen_fused)) {
                    RSYM = 0;
                }
                if ((TileLoader.ruin54 & seen_fused) != (getRuinReversedHorizontal(54) & seen_fused)) {
                    RSYM = 0;
                }
                
            }
            case 51 -> {
                seen_fused = TileLoader.seen47 & getSeenReversedHorizontal(47);
                if ((TileLoader.wall47 & seen_fused) != (getWallReversedHorizontal(47) & seen_fused)) {
                    RSYM = 0;
                }
                if ((TileLoader.ruin47 & seen_fused) != (getRuinReversedHorizontal(47) & seen_fused)) {
                    RSYM = 0;
                }
                seen_fused = TileLoader.seen48 & getSeenReversedHorizontal(48);
                if ((TileLoader.wall48 & seen_fused) != (getWallReversedHorizontal(48) & seen_fused)) {
                    RSYM = 0;
                }
                if ((TileLoader.ruin48 & seen_fused) != (getRuinReversedHorizontal(48) & seen_fused)) {
                    RSYM = 0;
                }
                seen_fused = TileLoader.seen49 & getSeenReversedHorizontal(49);
                if ((TileLoader.wall49 & seen_fused) != (getWallReversedHorizontal(49) & seen_fused)) {
                    RSYM = 0;
                }
                if ((TileLoader.ruin49 & seen_fused) != (getRuinReversedHorizontal(49) & seen_fused)) {
                    RSYM = 0;
                }
                seen_fused = TileLoader.seen50 & getSeenReversedHorizontal(50);
                if ((TileLoader.wall50 & seen_fused) != (getWallReversedHorizontal(50) & seen_fused)) {
                    RSYM = 0;
                }
                if ((TileLoader.ruin50 & seen_fused) != (getRuinReversedHorizontal(50) & seen_fused)) {
                    RSYM = 0;
                }
                seen_fused = TileLoader.seen51 & getSeenReversedHorizontal(51);
                if ((TileLoader.wall51 & seen_fused) != (getWallReversedHorizontal(51) & seen_fused)) {
                    RSYM = 0;
                }
                if ((TileLoader.ruin51 & seen_fused) != (getRuinReversedHorizontal(51) & seen_fused)) {
                    RSYM = 0;
                }
                seen_fused = TileLoader.seen52 & getSeenReversedHorizontal(52);
                if ((TileLoader.wall52 & seen_fused) != (getWallReversedHorizontal(52) & seen_fused)) {
                    RSYM = 0;
                }
                if ((TileLoader.ruin52 & seen_fused) != (getRuinReversedHorizontal(52) & seen_fused)) {
                    RSYM = 0;
                }
                seen_fused = TileLoader.seen53 & getSeenReversedHorizontal(53);
                if ((TileLoader.wall53 & seen_fused) != (getWallReversedHorizontal(53) & seen_fused)) {
                    RSYM = 0;
                }
                if ((TileLoader.ruin53 & seen_fused) != (getRuinReversedHorizontal(53) & seen_fused)) {
                    RSYM = 0;
                }
                seen_fused = TileLoader.seen54 & getSeenReversedHorizontal(54);
                if ((TileLoader.wall54 & seen_fused) != (getWallReversedHorizontal(54) & seen_fused)) {
                    RSYM = 0;
                }
                if ((TileLoader.ruin54 & seen_fused) != (getRuinReversedHorizontal(54) & seen_fused)) {
                    RSYM = 0;
                }
                seen_fused = TileLoader.seen55 & getSeenReversedHorizontal(55);
                if ((TileLoader.wall55 & seen_fused) != (getWallReversedHorizontal(55) & seen_fused)) {
                    RSYM = 0;
                }
                if ((TileLoader.ruin55 & seen_fused) != (getRuinReversedHorizontal(55) & seen_fused)) {
                    RSYM = 0;
                }
                
            }
            case 52 -> {
                seen_fused = TileLoader.seen48 & getSeenReversedHorizontal(48);
                if ((TileLoader.wall48 & seen_fused) != (getWallReversedHorizontal(48) & seen_fused)) {
                    RSYM = 0;
                }
                if ((TileLoader.ruin48 & seen_fused) != (getRuinReversedHorizontal(48) & seen_fused)) {
                    RSYM = 0;
                }
                seen_fused = TileLoader.seen49 & getSeenReversedHorizontal(49);
                if ((TileLoader.wall49 & seen_fused) != (getWallReversedHorizontal(49) & seen_fused)) {
                    RSYM = 0;
                }
                if ((TileLoader.ruin49 & seen_fused) != (getRuinReversedHorizontal(49) & seen_fused)) {
                    RSYM = 0;
                }
                seen_fused = TileLoader.seen50 & getSeenReversedHorizontal(50);
                if ((TileLoader.wall50 & seen_fused) != (getWallReversedHorizontal(50) & seen_fused)) {
                    RSYM = 0;
                }
                if ((TileLoader.ruin50 & seen_fused) != (getRuinReversedHorizontal(50) & seen_fused)) {
                    RSYM = 0;
                }
                seen_fused = TileLoader.seen51 & getSeenReversedHorizontal(51);
                if ((TileLoader.wall51 & seen_fused) != (getWallReversedHorizontal(51) & seen_fused)) {
                    RSYM = 0;
                }
                if ((TileLoader.ruin51 & seen_fused) != (getRuinReversedHorizontal(51) & seen_fused)) {
                    RSYM = 0;
                }
                seen_fused = TileLoader.seen52 & getSeenReversedHorizontal(52);
                if ((TileLoader.wall52 & seen_fused) != (getWallReversedHorizontal(52) & seen_fused)) {
                    RSYM = 0;
                }
                if ((TileLoader.ruin52 & seen_fused) != (getRuinReversedHorizontal(52) & seen_fused)) {
                    RSYM = 0;
                }
                seen_fused = TileLoader.seen53 & getSeenReversedHorizontal(53);
                if ((TileLoader.wall53 & seen_fused) != (getWallReversedHorizontal(53) & seen_fused)) {
                    RSYM = 0;
                }
                if ((TileLoader.ruin53 & seen_fused) != (getRuinReversedHorizontal(53) & seen_fused)) {
                    RSYM = 0;
                }
                seen_fused = TileLoader.seen54 & getSeenReversedHorizontal(54);
                if ((TileLoader.wall54 & seen_fused) != (getWallReversedHorizontal(54) & seen_fused)) {
                    RSYM = 0;
                }
                if ((TileLoader.ruin54 & seen_fused) != (getRuinReversedHorizontal(54) & seen_fused)) {
                    RSYM = 0;
                }
                seen_fused = TileLoader.seen55 & getSeenReversedHorizontal(55);
                if ((TileLoader.wall55 & seen_fused) != (getWallReversedHorizontal(55) & seen_fused)) {
                    RSYM = 0;
                }
                if ((TileLoader.ruin55 & seen_fused) != (getRuinReversedHorizontal(55) & seen_fused)) {
                    RSYM = 0;
                }
                seen_fused = TileLoader.seen56 & getSeenReversedHorizontal(56);
                if ((TileLoader.wall56 & seen_fused) != (getWallReversedHorizontal(56) & seen_fused)) {
                    RSYM = 0;
                }
                if ((TileLoader.ruin56 & seen_fused) != (getRuinReversedHorizontal(56) & seen_fused)) {
                    RSYM = 0;
                }
                
            }
            case 53 -> {
                seen_fused = TileLoader.seen49 & getSeenReversedHorizontal(49);
                if ((TileLoader.wall49 & seen_fused) != (getWallReversedHorizontal(49) & seen_fused)) {
                    RSYM = 0;
                }
                if ((TileLoader.ruin49 & seen_fused) != (getRuinReversedHorizontal(49) & seen_fused)) {
                    RSYM = 0;
                }
                seen_fused = TileLoader.seen50 & getSeenReversedHorizontal(50);
                if ((TileLoader.wall50 & seen_fused) != (getWallReversedHorizontal(50) & seen_fused)) {
                    RSYM = 0;
                }
                if ((TileLoader.ruin50 & seen_fused) != (getRuinReversedHorizontal(50) & seen_fused)) {
                    RSYM = 0;
                }
                seen_fused = TileLoader.seen51 & getSeenReversedHorizontal(51);
                if ((TileLoader.wall51 & seen_fused) != (getWallReversedHorizontal(51) & seen_fused)) {
                    RSYM = 0;
                }
                if ((TileLoader.ruin51 & seen_fused) != (getRuinReversedHorizontal(51) & seen_fused)) {
                    RSYM = 0;
                }
                seen_fused = TileLoader.seen52 & getSeenReversedHorizontal(52);
                if ((TileLoader.wall52 & seen_fused) != (getWallReversedHorizontal(52) & seen_fused)) {
                    RSYM = 0;
                }
                if ((TileLoader.ruin52 & seen_fused) != (getRuinReversedHorizontal(52) & seen_fused)) {
                    RSYM = 0;
                }
                seen_fused = TileLoader.seen53 & getSeenReversedHorizontal(53);
                if ((TileLoader.wall53 & seen_fused) != (getWallReversedHorizontal(53) & seen_fused)) {
                    RSYM = 0;
                }
                if ((TileLoader.ruin53 & seen_fused) != (getRuinReversedHorizontal(53) & seen_fused)) {
                    RSYM = 0;
                }
                seen_fused = TileLoader.seen54 & getSeenReversedHorizontal(54);
                if ((TileLoader.wall54 & seen_fused) != (getWallReversedHorizontal(54) & seen_fused)) {
                    RSYM = 0;
                }
                if ((TileLoader.ruin54 & seen_fused) != (getRuinReversedHorizontal(54) & seen_fused)) {
                    RSYM = 0;
                }
                seen_fused = TileLoader.seen55 & getSeenReversedHorizontal(55);
                if ((TileLoader.wall55 & seen_fused) != (getWallReversedHorizontal(55) & seen_fused)) {
                    RSYM = 0;
                }
                if ((TileLoader.ruin55 & seen_fused) != (getRuinReversedHorizontal(55) & seen_fused)) {
                    RSYM = 0;
                }
                seen_fused = TileLoader.seen56 & getSeenReversedHorizontal(56);
                if ((TileLoader.wall56 & seen_fused) != (getWallReversedHorizontal(56) & seen_fused)) {
                    RSYM = 0;
                }
                if ((TileLoader.ruin56 & seen_fused) != (getRuinReversedHorizontal(56) & seen_fused)) {
                    RSYM = 0;
                }
                seen_fused = TileLoader.seen57 & getSeenReversedHorizontal(57);
                if ((TileLoader.wall57 & seen_fused) != (getWallReversedHorizontal(57) & seen_fused)) {
                    RSYM = 0;
                }
                if ((TileLoader.ruin57 & seen_fused) != (getRuinReversedHorizontal(57) & seen_fused)) {
                    RSYM = 0;
                }
                
            }
            case 54 -> {
                seen_fused = TileLoader.seen50 & getSeenReversedHorizontal(50);
                if ((TileLoader.wall50 & seen_fused) != (getWallReversedHorizontal(50) & seen_fused)) {
                    RSYM = 0;
                }
                if ((TileLoader.ruin50 & seen_fused) != (getRuinReversedHorizontal(50) & seen_fused)) {
                    RSYM = 0;
                }
                seen_fused = TileLoader.seen51 & getSeenReversedHorizontal(51);
                if ((TileLoader.wall51 & seen_fused) != (getWallReversedHorizontal(51) & seen_fused)) {
                    RSYM = 0;
                }
                if ((TileLoader.ruin51 & seen_fused) != (getRuinReversedHorizontal(51) & seen_fused)) {
                    RSYM = 0;
                }
                seen_fused = TileLoader.seen52 & getSeenReversedHorizontal(52);
                if ((TileLoader.wall52 & seen_fused) != (getWallReversedHorizontal(52) & seen_fused)) {
                    RSYM = 0;
                }
                if ((TileLoader.ruin52 & seen_fused) != (getRuinReversedHorizontal(52) & seen_fused)) {
                    RSYM = 0;
                }
                seen_fused = TileLoader.seen53 & getSeenReversedHorizontal(53);
                if ((TileLoader.wall53 & seen_fused) != (getWallReversedHorizontal(53) & seen_fused)) {
                    RSYM = 0;
                }
                if ((TileLoader.ruin53 & seen_fused) != (getRuinReversedHorizontal(53) & seen_fused)) {
                    RSYM = 0;
                }
                seen_fused = TileLoader.seen54 & getSeenReversedHorizontal(54);
                if ((TileLoader.wall54 & seen_fused) != (getWallReversedHorizontal(54) & seen_fused)) {
                    RSYM = 0;
                }
                if ((TileLoader.ruin54 & seen_fused) != (getRuinReversedHorizontal(54) & seen_fused)) {
                    RSYM = 0;
                }
                seen_fused = TileLoader.seen55 & getSeenReversedHorizontal(55);
                if ((TileLoader.wall55 & seen_fused) != (getWallReversedHorizontal(55) & seen_fused)) {
                    RSYM = 0;
                }
                if ((TileLoader.ruin55 & seen_fused) != (getRuinReversedHorizontal(55) & seen_fused)) {
                    RSYM = 0;
                }
                seen_fused = TileLoader.seen56 & getSeenReversedHorizontal(56);
                if ((TileLoader.wall56 & seen_fused) != (getWallReversedHorizontal(56) & seen_fused)) {
                    RSYM = 0;
                }
                if ((TileLoader.ruin56 & seen_fused) != (getRuinReversedHorizontal(56) & seen_fused)) {
                    RSYM = 0;
                }
                seen_fused = TileLoader.seen57 & getSeenReversedHorizontal(57);
                if ((TileLoader.wall57 & seen_fused) != (getWallReversedHorizontal(57) & seen_fused)) {
                    RSYM = 0;
                }
                if ((TileLoader.ruin57 & seen_fused) != (getRuinReversedHorizontal(57) & seen_fused)) {
                    RSYM = 0;
                }
                seen_fused = TileLoader.seen58 & getSeenReversedHorizontal(58);
                if ((TileLoader.wall58 & seen_fused) != (getWallReversedHorizontal(58) & seen_fused)) {
                    RSYM = 0;
                }
                if ((TileLoader.ruin58 & seen_fused) != (getRuinReversedHorizontal(58) & seen_fused)) {
                    RSYM = 0;
                }
                
            }
            case 55 -> {
                seen_fused = TileLoader.seen51 & getSeenReversedHorizontal(51);
                if ((TileLoader.wall51 & seen_fused) != (getWallReversedHorizontal(51) & seen_fused)) {
                    RSYM = 0;
                }
                if ((TileLoader.ruin51 & seen_fused) != (getRuinReversedHorizontal(51) & seen_fused)) {
                    RSYM = 0;
                }
                seen_fused = TileLoader.seen52 & getSeenReversedHorizontal(52);
                if ((TileLoader.wall52 & seen_fused) != (getWallReversedHorizontal(52) & seen_fused)) {
                    RSYM = 0;
                }
                if ((TileLoader.ruin52 & seen_fused) != (getRuinReversedHorizontal(52) & seen_fused)) {
                    RSYM = 0;
                }
                seen_fused = TileLoader.seen53 & getSeenReversedHorizontal(53);
                if ((TileLoader.wall53 & seen_fused) != (getWallReversedHorizontal(53) & seen_fused)) {
                    RSYM = 0;
                }
                if ((TileLoader.ruin53 & seen_fused) != (getRuinReversedHorizontal(53) & seen_fused)) {
                    RSYM = 0;
                }
                seen_fused = TileLoader.seen54 & getSeenReversedHorizontal(54);
                if ((TileLoader.wall54 & seen_fused) != (getWallReversedHorizontal(54) & seen_fused)) {
                    RSYM = 0;
                }
                if ((TileLoader.ruin54 & seen_fused) != (getRuinReversedHorizontal(54) & seen_fused)) {
                    RSYM = 0;
                }
                seen_fused = TileLoader.seen55 & getSeenReversedHorizontal(55);
                if ((TileLoader.wall55 & seen_fused) != (getWallReversedHorizontal(55) & seen_fused)) {
                    RSYM = 0;
                }
                if ((TileLoader.ruin55 & seen_fused) != (getRuinReversedHorizontal(55) & seen_fused)) {
                    RSYM = 0;
                }
                seen_fused = TileLoader.seen56 & getSeenReversedHorizontal(56);
                if ((TileLoader.wall56 & seen_fused) != (getWallReversedHorizontal(56) & seen_fused)) {
                    RSYM = 0;
                }
                if ((TileLoader.ruin56 & seen_fused) != (getRuinReversedHorizontal(56) & seen_fused)) {
                    RSYM = 0;
                }
                seen_fused = TileLoader.seen57 & getSeenReversedHorizontal(57);
                if ((TileLoader.wall57 & seen_fused) != (getWallReversedHorizontal(57) & seen_fused)) {
                    RSYM = 0;
                }
                if ((TileLoader.ruin57 & seen_fused) != (getRuinReversedHorizontal(57) & seen_fused)) {
                    RSYM = 0;
                }
                seen_fused = TileLoader.seen58 & getSeenReversedHorizontal(58);
                if ((TileLoader.wall58 & seen_fused) != (getWallReversedHorizontal(58) & seen_fused)) {
                    RSYM = 0;
                }
                if ((TileLoader.ruin58 & seen_fused) != (getRuinReversedHorizontal(58) & seen_fused)) {
                    RSYM = 0;
                }
                seen_fused = TileLoader.seen59 & getSeenReversedHorizontal(59);
                if ((TileLoader.wall59 & seen_fused) != (getWallReversedHorizontal(59) & seen_fused)) {
                    RSYM = 0;
                }
                if ((TileLoader.ruin59 & seen_fused) != (getRuinReversedHorizontal(59) & seen_fused)) {
                    RSYM = 0;
                }
                
            }
            case 56 -> {
                seen_fused = TileLoader.seen52 & getSeenReversedHorizontal(52);
                if ((TileLoader.wall52 & seen_fused) != (getWallReversedHorizontal(52) & seen_fused)) {
                    RSYM = 0;
                }
                if ((TileLoader.ruin52 & seen_fused) != (getRuinReversedHorizontal(52) & seen_fused)) {
                    RSYM = 0;
                }
                seen_fused = TileLoader.seen53 & getSeenReversedHorizontal(53);
                if ((TileLoader.wall53 & seen_fused) != (getWallReversedHorizontal(53) & seen_fused)) {
                    RSYM = 0;
                }
                if ((TileLoader.ruin53 & seen_fused) != (getRuinReversedHorizontal(53) & seen_fused)) {
                    RSYM = 0;
                }
                seen_fused = TileLoader.seen54 & getSeenReversedHorizontal(54);
                if ((TileLoader.wall54 & seen_fused) != (getWallReversedHorizontal(54) & seen_fused)) {
                    RSYM = 0;
                }
                if ((TileLoader.ruin54 & seen_fused) != (getRuinReversedHorizontal(54) & seen_fused)) {
                    RSYM = 0;
                }
                seen_fused = TileLoader.seen55 & getSeenReversedHorizontal(55);
                if ((TileLoader.wall55 & seen_fused) != (getWallReversedHorizontal(55) & seen_fused)) {
                    RSYM = 0;
                }
                if ((TileLoader.ruin55 & seen_fused) != (getRuinReversedHorizontal(55) & seen_fused)) {
                    RSYM = 0;
                }
                seen_fused = TileLoader.seen56 & getSeenReversedHorizontal(56);
                if ((TileLoader.wall56 & seen_fused) != (getWallReversedHorizontal(56) & seen_fused)) {
                    RSYM = 0;
                }
                if ((TileLoader.ruin56 & seen_fused) != (getRuinReversedHorizontal(56) & seen_fused)) {
                    RSYM = 0;
                }
                seen_fused = TileLoader.seen57 & getSeenReversedHorizontal(57);
                if ((TileLoader.wall57 & seen_fused) != (getWallReversedHorizontal(57) & seen_fused)) {
                    RSYM = 0;
                }
                if ((TileLoader.ruin57 & seen_fused) != (getRuinReversedHorizontal(57) & seen_fused)) {
                    RSYM = 0;
                }
                seen_fused = TileLoader.seen58 & getSeenReversedHorizontal(58);
                if ((TileLoader.wall58 & seen_fused) != (getWallReversedHorizontal(58) & seen_fused)) {
                    RSYM = 0;
                }
                if ((TileLoader.ruin58 & seen_fused) != (getRuinReversedHorizontal(58) & seen_fused)) {
                    RSYM = 0;
                }
                seen_fused = TileLoader.seen59 & getSeenReversedHorizontal(59);
                if ((TileLoader.wall59 & seen_fused) != (getWallReversedHorizontal(59) & seen_fused)) {
                    RSYM = 0;
                }
                if ((TileLoader.ruin59 & seen_fused) != (getRuinReversedHorizontal(59) & seen_fused)) {
                    RSYM = 0;
                }
                
            }
            case 57 -> {
                seen_fused = TileLoader.seen53 & getSeenReversedHorizontal(53);
                if ((TileLoader.wall53 & seen_fused) != (getWallReversedHorizontal(53) & seen_fused)) {
                    RSYM = 0;
                }
                if ((TileLoader.ruin53 & seen_fused) != (getRuinReversedHorizontal(53) & seen_fused)) {
                    RSYM = 0;
                }
                seen_fused = TileLoader.seen54 & getSeenReversedHorizontal(54);
                if ((TileLoader.wall54 & seen_fused) != (getWallReversedHorizontal(54) & seen_fused)) {
                    RSYM = 0;
                }
                if ((TileLoader.ruin54 & seen_fused) != (getRuinReversedHorizontal(54) & seen_fused)) {
                    RSYM = 0;
                }
                seen_fused = TileLoader.seen55 & getSeenReversedHorizontal(55);
                if ((TileLoader.wall55 & seen_fused) != (getWallReversedHorizontal(55) & seen_fused)) {
                    RSYM = 0;
                }
                if ((TileLoader.ruin55 & seen_fused) != (getRuinReversedHorizontal(55) & seen_fused)) {
                    RSYM = 0;
                }
                seen_fused = TileLoader.seen56 & getSeenReversedHorizontal(56);
                if ((TileLoader.wall56 & seen_fused) != (getWallReversedHorizontal(56) & seen_fused)) {
                    RSYM = 0;
                }
                if ((TileLoader.ruin56 & seen_fused) != (getRuinReversedHorizontal(56) & seen_fused)) {
                    RSYM = 0;
                }
                seen_fused = TileLoader.seen57 & getSeenReversedHorizontal(57);
                if ((TileLoader.wall57 & seen_fused) != (getWallReversedHorizontal(57) & seen_fused)) {
                    RSYM = 0;
                }
                if ((TileLoader.ruin57 & seen_fused) != (getRuinReversedHorizontal(57) & seen_fused)) {
                    RSYM = 0;
                }
                seen_fused = TileLoader.seen58 & getSeenReversedHorizontal(58);
                if ((TileLoader.wall58 & seen_fused) != (getWallReversedHorizontal(58) & seen_fused)) {
                    RSYM = 0;
                }
                if ((TileLoader.ruin58 & seen_fused) != (getRuinReversedHorizontal(58) & seen_fused)) {
                    RSYM = 0;
                }
                seen_fused = TileLoader.seen59 & getSeenReversedHorizontal(59);
                if ((TileLoader.wall59 & seen_fused) != (getWallReversedHorizontal(59) & seen_fused)) {
                    RSYM = 0;
                }
                if ((TileLoader.ruin59 & seen_fused) != (getRuinReversedHorizontal(59) & seen_fused)) {
                    RSYM = 0;
                }
                
            }
            case 58 -> {
                seen_fused = TileLoader.seen54 & getSeenReversedHorizontal(54);
                if ((TileLoader.wall54 & seen_fused) != (getWallReversedHorizontal(54) & seen_fused)) {
                    RSYM = 0;
                }
                if ((TileLoader.ruin54 & seen_fused) != (getRuinReversedHorizontal(54) & seen_fused)) {
                    RSYM = 0;
                }
                seen_fused = TileLoader.seen55 & getSeenReversedHorizontal(55);
                if ((TileLoader.wall55 & seen_fused) != (getWallReversedHorizontal(55) & seen_fused)) {
                    RSYM = 0;
                }
                if ((TileLoader.ruin55 & seen_fused) != (getRuinReversedHorizontal(55) & seen_fused)) {
                    RSYM = 0;
                }
                seen_fused = TileLoader.seen56 & getSeenReversedHorizontal(56);
                if ((TileLoader.wall56 & seen_fused) != (getWallReversedHorizontal(56) & seen_fused)) {
                    RSYM = 0;
                }
                if ((TileLoader.ruin56 & seen_fused) != (getRuinReversedHorizontal(56) & seen_fused)) {
                    RSYM = 0;
                }
                seen_fused = TileLoader.seen57 & getSeenReversedHorizontal(57);
                if ((TileLoader.wall57 & seen_fused) != (getWallReversedHorizontal(57) & seen_fused)) {
                    RSYM = 0;
                }
                if ((TileLoader.ruin57 & seen_fused) != (getRuinReversedHorizontal(57) & seen_fused)) {
                    RSYM = 0;
                }
                seen_fused = TileLoader.seen58 & getSeenReversedHorizontal(58);
                if ((TileLoader.wall58 & seen_fused) != (getWallReversedHorizontal(58) & seen_fused)) {
                    RSYM = 0;
                }
                if ((TileLoader.ruin58 & seen_fused) != (getRuinReversedHorizontal(58) & seen_fused)) {
                    RSYM = 0;
                }
                seen_fused = TileLoader.seen59 & getSeenReversedHorizontal(59);
                if ((TileLoader.wall59 & seen_fused) != (getWallReversedHorizontal(59) & seen_fused)) {
                    RSYM = 0;
                }
                if ((TileLoader.ruin59 & seen_fused) != (getRuinReversedHorizontal(59) & seen_fused)) {
                    RSYM = 0;
                }
                
            }
            case 59 -> {
                seen_fused = TileLoader.seen55 & getSeenReversedHorizontal(55);
                if ((TileLoader.wall55 & seen_fused) != (getWallReversedHorizontal(55) & seen_fused)) {
                    RSYM = 0;
                }
                if ((TileLoader.ruin55 & seen_fused) != (getRuinReversedHorizontal(55) & seen_fused)) {
                    RSYM = 0;
                }
                seen_fused = TileLoader.seen56 & getSeenReversedHorizontal(56);
                if ((TileLoader.wall56 & seen_fused) != (getWallReversedHorizontal(56) & seen_fused)) {
                    RSYM = 0;
                }
                if ((TileLoader.ruin56 & seen_fused) != (getRuinReversedHorizontal(56) & seen_fused)) {
                    RSYM = 0;
                }
                seen_fused = TileLoader.seen57 & getSeenReversedHorizontal(57);
                if ((TileLoader.wall57 & seen_fused) != (getWallReversedHorizontal(57) & seen_fused)) {
                    RSYM = 0;
                }
                if ((TileLoader.ruin57 & seen_fused) != (getRuinReversedHorizontal(57) & seen_fused)) {
                    RSYM = 0;
                }
                seen_fused = TileLoader.seen58 & getSeenReversedHorizontal(58);
                if ((TileLoader.wall58 & seen_fused) != (getWallReversedHorizontal(58) & seen_fused)) {
                    RSYM = 0;
                }
                if ((TileLoader.ruin58 & seen_fused) != (getRuinReversedHorizontal(58) & seen_fused)) {
                    RSYM = 0;
                }
                seen_fused = TileLoader.seen59 & getSeenReversedHorizontal(59);
                if ((TileLoader.wall59 & seen_fused) != (getWallReversedHorizontal(59) & seen_fused)) {
                    RSYM = 0;
                }
                if ((TileLoader.ruin59 & seen_fused) != (getRuinReversedHorizontal(59) & seen_fused)) {
                    RSYM = 0;
                }
                
            }
            
            default -> {}
        }
    }

    // Can be done by just having masks that store the correct horizontal mask or whatever.
    
    
    public static long getWallHorizontal(int y) {
        return switch (maxY - y) {
            
            case 0 -> TileLoader.wall0;
            case 1 -> TileLoader.wall1;
            case 2 -> TileLoader.wall2;
            case 3 -> TileLoader.wall3;
            case 4 -> TileLoader.wall4;
            case 5 -> TileLoader.wall5;
            case 6 -> TileLoader.wall6;
            case 7 -> TileLoader.wall7;
            case 8 -> TileLoader.wall8;
            case 9 -> TileLoader.wall9;
            case 10 -> TileLoader.wall10;
            case 11 -> TileLoader.wall11;
            case 12 -> TileLoader.wall12;
            case 13 -> TileLoader.wall13;
            case 14 -> TileLoader.wall14;
            case 15 -> TileLoader.wall15;
            case 16 -> TileLoader.wall16;
            case 17 -> TileLoader.wall17;
            case 18 -> TileLoader.wall18;
            case 19 -> TileLoader.wall19;
            case 20 -> TileLoader.wall20;
            case 21 -> TileLoader.wall21;
            case 22 -> TileLoader.wall22;
            case 23 -> TileLoader.wall23;
            case 24 -> TileLoader.wall24;
            case 25 -> TileLoader.wall25;
            case 26 -> TileLoader.wall26;
            case 27 -> TileLoader.wall27;
            case 28 -> TileLoader.wall28;
            case 29 -> TileLoader.wall29;
            case 30 -> TileLoader.wall30;
            case 31 -> TileLoader.wall31;
            case 32 -> TileLoader.wall32;
            case 33 -> TileLoader.wall33;
            case 34 -> TileLoader.wall34;
            case 35 -> TileLoader.wall35;
            case 36 -> TileLoader.wall36;
            case 37 -> TileLoader.wall37;
            case 38 -> TileLoader.wall38;
            case 39 -> TileLoader.wall39;
            case 40 -> TileLoader.wall40;
            case 41 -> TileLoader.wall41;
            case 42 -> TileLoader.wall42;
            case 43 -> TileLoader.wall43;
            case 44 -> TileLoader.wall44;
            case 45 -> TileLoader.wall45;
            case 46 -> TileLoader.wall46;
            case 47 -> TileLoader.wall47;
            case 48 -> TileLoader.wall48;
            case 49 -> TileLoader.wall49;
            case 50 -> TileLoader.wall50;
            case 51 -> TileLoader.wall51;
            case 52 -> TileLoader.wall52;
            case 53 -> TileLoader.wall53;
            case 54 -> TileLoader.wall54;
            case 55 -> TileLoader.wall55;
            case 56 -> TileLoader.wall56;
            case 57 -> TileLoader.wall57;
            case 58 -> TileLoader.wall58;
            case 59 -> TileLoader.wall59;
            default -> 0;
        };
    }
    
    
    public static long getSeenHorizontal(int y) {
        return switch (maxY - y) {
            
            case 0 -> TileLoader.seen0;
            case 1 -> TileLoader.seen1;
            case 2 -> TileLoader.seen2;
            case 3 -> TileLoader.seen3;
            case 4 -> TileLoader.seen4;
            case 5 -> TileLoader.seen5;
            case 6 -> TileLoader.seen6;
            case 7 -> TileLoader.seen7;
            case 8 -> TileLoader.seen8;
            case 9 -> TileLoader.seen9;
            case 10 -> TileLoader.seen10;
            case 11 -> TileLoader.seen11;
            case 12 -> TileLoader.seen12;
            case 13 -> TileLoader.seen13;
            case 14 -> TileLoader.seen14;
            case 15 -> TileLoader.seen15;
            case 16 -> TileLoader.seen16;
            case 17 -> TileLoader.seen17;
            case 18 -> TileLoader.seen18;
            case 19 -> TileLoader.seen19;
            case 20 -> TileLoader.seen20;
            case 21 -> TileLoader.seen21;
            case 22 -> TileLoader.seen22;
            case 23 -> TileLoader.seen23;
            case 24 -> TileLoader.seen24;
            case 25 -> TileLoader.seen25;
            case 26 -> TileLoader.seen26;
            case 27 -> TileLoader.seen27;
            case 28 -> TileLoader.seen28;
            case 29 -> TileLoader.seen29;
            case 30 -> TileLoader.seen30;
            case 31 -> TileLoader.seen31;
            case 32 -> TileLoader.seen32;
            case 33 -> TileLoader.seen33;
            case 34 -> TileLoader.seen34;
            case 35 -> TileLoader.seen35;
            case 36 -> TileLoader.seen36;
            case 37 -> TileLoader.seen37;
            case 38 -> TileLoader.seen38;
            case 39 -> TileLoader.seen39;
            case 40 -> TileLoader.seen40;
            case 41 -> TileLoader.seen41;
            case 42 -> TileLoader.seen42;
            case 43 -> TileLoader.seen43;
            case 44 -> TileLoader.seen44;
            case 45 -> TileLoader.seen45;
            case 46 -> TileLoader.seen46;
            case 47 -> TileLoader.seen47;
            case 48 -> TileLoader.seen48;
            case 49 -> TileLoader.seen49;
            case 50 -> TileLoader.seen50;
            case 51 -> TileLoader.seen51;
            case 52 -> TileLoader.seen52;
            case 53 -> TileLoader.seen53;
            case 54 -> TileLoader.seen54;
            case 55 -> TileLoader.seen55;
            case 56 -> TileLoader.seen56;
            case 57 -> TileLoader.seen57;
            case 58 -> TileLoader.seen58;
            case 59 -> TileLoader.seen59;
            default -> 0;
        };
    }
    
    
    public static long getRuinHorizontal(int y) {
        return switch (maxY - y) {
            
            case 0 -> TileLoader.ruin0;
            case 1 -> TileLoader.ruin1;
            case 2 -> TileLoader.ruin2;
            case 3 -> TileLoader.ruin3;
            case 4 -> TileLoader.ruin4;
            case 5 -> TileLoader.ruin5;
            case 6 -> TileLoader.ruin6;
            case 7 -> TileLoader.ruin7;
            case 8 -> TileLoader.ruin8;
            case 9 -> TileLoader.ruin9;
            case 10 -> TileLoader.ruin10;
            case 11 -> TileLoader.ruin11;
            case 12 -> TileLoader.ruin12;
            case 13 -> TileLoader.ruin13;
            case 14 -> TileLoader.ruin14;
            case 15 -> TileLoader.ruin15;
            case 16 -> TileLoader.ruin16;
            case 17 -> TileLoader.ruin17;
            case 18 -> TileLoader.ruin18;
            case 19 -> TileLoader.ruin19;
            case 20 -> TileLoader.ruin20;
            case 21 -> TileLoader.ruin21;
            case 22 -> TileLoader.ruin22;
            case 23 -> TileLoader.ruin23;
            case 24 -> TileLoader.ruin24;
            case 25 -> TileLoader.ruin25;
            case 26 -> TileLoader.ruin26;
            case 27 -> TileLoader.ruin27;
            case 28 -> TileLoader.ruin28;
            case 29 -> TileLoader.ruin29;
            case 30 -> TileLoader.ruin30;
            case 31 -> TileLoader.ruin31;
            case 32 -> TileLoader.ruin32;
            case 33 -> TileLoader.ruin33;
            case 34 -> TileLoader.ruin34;
            case 35 -> TileLoader.ruin35;
            case 36 -> TileLoader.ruin36;
            case 37 -> TileLoader.ruin37;
            case 38 -> TileLoader.ruin38;
            case 39 -> TileLoader.ruin39;
            case 40 -> TileLoader.ruin40;
            case 41 -> TileLoader.ruin41;
            case 42 -> TileLoader.ruin42;
            case 43 -> TileLoader.ruin43;
            case 44 -> TileLoader.ruin44;
            case 45 -> TileLoader.ruin45;
            case 46 -> TileLoader.ruin46;
            case 47 -> TileLoader.ruin47;
            case 48 -> TileLoader.ruin48;
            case 49 -> TileLoader.ruin49;
            case 50 -> TileLoader.ruin50;
            case 51 -> TileLoader.ruin51;
            case 52 -> TileLoader.ruin52;
            case 53 -> TileLoader.ruin53;
            case 54 -> TileLoader.ruin54;
            case 55 -> TileLoader.ruin55;
            case 56 -> TileLoader.ruin56;
            case 57 -> TileLoader.ruin57;
            case 58 -> TileLoader.ruin58;
            case 59 -> TileLoader.ruin59;
            default -> 0;
        };
    }
    
    
    public static long getWallReversedHorizontal(int y) {
        return switch (maxY - y) {
            
            case 0 -> TileLoader.wall_reversed0;
            case 1 -> TileLoader.wall_reversed1;
            case 2 -> TileLoader.wall_reversed2;
            case 3 -> TileLoader.wall_reversed3;
            case 4 -> TileLoader.wall_reversed4;
            case 5 -> TileLoader.wall_reversed5;
            case 6 -> TileLoader.wall_reversed6;
            case 7 -> TileLoader.wall_reversed7;
            case 8 -> TileLoader.wall_reversed8;
            case 9 -> TileLoader.wall_reversed9;
            case 10 -> TileLoader.wall_reversed10;
            case 11 -> TileLoader.wall_reversed11;
            case 12 -> TileLoader.wall_reversed12;
            case 13 -> TileLoader.wall_reversed13;
            case 14 -> TileLoader.wall_reversed14;
            case 15 -> TileLoader.wall_reversed15;
            case 16 -> TileLoader.wall_reversed16;
            case 17 -> TileLoader.wall_reversed17;
            case 18 -> TileLoader.wall_reversed18;
            case 19 -> TileLoader.wall_reversed19;
            case 20 -> TileLoader.wall_reversed20;
            case 21 -> TileLoader.wall_reversed21;
            case 22 -> TileLoader.wall_reversed22;
            case 23 -> TileLoader.wall_reversed23;
            case 24 -> TileLoader.wall_reversed24;
            case 25 -> TileLoader.wall_reversed25;
            case 26 -> TileLoader.wall_reversed26;
            case 27 -> TileLoader.wall_reversed27;
            case 28 -> TileLoader.wall_reversed28;
            case 29 -> TileLoader.wall_reversed29;
            case 30 -> TileLoader.wall_reversed30;
            case 31 -> TileLoader.wall_reversed31;
            case 32 -> TileLoader.wall_reversed32;
            case 33 -> TileLoader.wall_reversed33;
            case 34 -> TileLoader.wall_reversed34;
            case 35 -> TileLoader.wall_reversed35;
            case 36 -> TileLoader.wall_reversed36;
            case 37 -> TileLoader.wall_reversed37;
            case 38 -> TileLoader.wall_reversed38;
            case 39 -> TileLoader.wall_reversed39;
            case 40 -> TileLoader.wall_reversed40;
            case 41 -> TileLoader.wall_reversed41;
            case 42 -> TileLoader.wall_reversed42;
            case 43 -> TileLoader.wall_reversed43;
            case 44 -> TileLoader.wall_reversed44;
            case 45 -> TileLoader.wall_reversed45;
            case 46 -> TileLoader.wall_reversed46;
            case 47 -> TileLoader.wall_reversed47;
            case 48 -> TileLoader.wall_reversed48;
            case 49 -> TileLoader.wall_reversed49;
            case 50 -> TileLoader.wall_reversed50;
            case 51 -> TileLoader.wall_reversed51;
            case 52 -> TileLoader.wall_reversed52;
            case 53 -> TileLoader.wall_reversed53;
            case 54 -> TileLoader.wall_reversed54;
            case 55 -> TileLoader.wall_reversed55;
            case 56 -> TileLoader.wall_reversed56;
            case 57 -> TileLoader.wall_reversed57;
            case 58 -> TileLoader.wall_reversed58;
            case 59 -> TileLoader.wall_reversed59;
            default -> 0;
        };
    }
    
    
    public static long getSeenReversedHorizontal(int y) {
        return switch (maxY - y) {
            
            case 0 -> TileLoader.seen_reversed0;
            case 1 -> TileLoader.seen_reversed1;
            case 2 -> TileLoader.seen_reversed2;
            case 3 -> TileLoader.seen_reversed3;
            case 4 -> TileLoader.seen_reversed4;
            case 5 -> TileLoader.seen_reversed5;
            case 6 -> TileLoader.seen_reversed6;
            case 7 -> TileLoader.seen_reversed7;
            case 8 -> TileLoader.seen_reversed8;
            case 9 -> TileLoader.seen_reversed9;
            case 10 -> TileLoader.seen_reversed10;
            case 11 -> TileLoader.seen_reversed11;
            case 12 -> TileLoader.seen_reversed12;
            case 13 -> TileLoader.seen_reversed13;
            case 14 -> TileLoader.seen_reversed14;
            case 15 -> TileLoader.seen_reversed15;
            case 16 -> TileLoader.seen_reversed16;
            case 17 -> TileLoader.seen_reversed17;
            case 18 -> TileLoader.seen_reversed18;
            case 19 -> TileLoader.seen_reversed19;
            case 20 -> TileLoader.seen_reversed20;
            case 21 -> TileLoader.seen_reversed21;
            case 22 -> TileLoader.seen_reversed22;
            case 23 -> TileLoader.seen_reversed23;
            case 24 -> TileLoader.seen_reversed24;
            case 25 -> TileLoader.seen_reversed25;
            case 26 -> TileLoader.seen_reversed26;
            case 27 -> TileLoader.seen_reversed27;
            case 28 -> TileLoader.seen_reversed28;
            case 29 -> TileLoader.seen_reversed29;
            case 30 -> TileLoader.seen_reversed30;
            case 31 -> TileLoader.seen_reversed31;
            case 32 -> TileLoader.seen_reversed32;
            case 33 -> TileLoader.seen_reversed33;
            case 34 -> TileLoader.seen_reversed34;
            case 35 -> TileLoader.seen_reversed35;
            case 36 -> TileLoader.seen_reversed36;
            case 37 -> TileLoader.seen_reversed37;
            case 38 -> TileLoader.seen_reversed38;
            case 39 -> TileLoader.seen_reversed39;
            case 40 -> TileLoader.seen_reversed40;
            case 41 -> TileLoader.seen_reversed41;
            case 42 -> TileLoader.seen_reversed42;
            case 43 -> TileLoader.seen_reversed43;
            case 44 -> TileLoader.seen_reversed44;
            case 45 -> TileLoader.seen_reversed45;
            case 46 -> TileLoader.seen_reversed46;
            case 47 -> TileLoader.seen_reversed47;
            case 48 -> TileLoader.seen_reversed48;
            case 49 -> TileLoader.seen_reversed49;
            case 50 -> TileLoader.seen_reversed50;
            case 51 -> TileLoader.seen_reversed51;
            case 52 -> TileLoader.seen_reversed52;
            case 53 -> TileLoader.seen_reversed53;
            case 54 -> TileLoader.seen_reversed54;
            case 55 -> TileLoader.seen_reversed55;
            case 56 -> TileLoader.seen_reversed56;
            case 57 -> TileLoader.seen_reversed57;
            case 58 -> TileLoader.seen_reversed58;
            case 59 -> TileLoader.seen_reversed59;
            default -> 0;
        };
    }
    
    
    public static long getRuinReversedHorizontal(int y) {
        return switch (maxY - y) {
            
            case 0 -> TileLoader.ruin_reversed0;
            case 1 -> TileLoader.ruin_reversed1;
            case 2 -> TileLoader.ruin_reversed2;
            case 3 -> TileLoader.ruin_reversed3;
            case 4 -> TileLoader.ruin_reversed4;
            case 5 -> TileLoader.ruin_reversed5;
            case 6 -> TileLoader.ruin_reversed6;
            case 7 -> TileLoader.ruin_reversed7;
            case 8 -> TileLoader.ruin_reversed8;
            case 9 -> TileLoader.ruin_reversed9;
            case 10 -> TileLoader.ruin_reversed10;
            case 11 -> TileLoader.ruin_reversed11;
            case 12 -> TileLoader.ruin_reversed12;
            case 13 -> TileLoader.ruin_reversed13;
            case 14 -> TileLoader.ruin_reversed14;
            case 15 -> TileLoader.ruin_reversed15;
            case 16 -> TileLoader.ruin_reversed16;
            case 17 -> TileLoader.ruin_reversed17;
            case 18 -> TileLoader.ruin_reversed18;
            case 19 -> TileLoader.ruin_reversed19;
            case 20 -> TileLoader.ruin_reversed20;
            case 21 -> TileLoader.ruin_reversed21;
            case 22 -> TileLoader.ruin_reversed22;
            case 23 -> TileLoader.ruin_reversed23;
            case 24 -> TileLoader.ruin_reversed24;
            case 25 -> TileLoader.ruin_reversed25;
            case 26 -> TileLoader.ruin_reversed26;
            case 27 -> TileLoader.ruin_reversed27;
            case 28 -> TileLoader.ruin_reversed28;
            case 29 -> TileLoader.ruin_reversed29;
            case 30 -> TileLoader.ruin_reversed30;
            case 31 -> TileLoader.ruin_reversed31;
            case 32 -> TileLoader.ruin_reversed32;
            case 33 -> TileLoader.ruin_reversed33;
            case 34 -> TileLoader.ruin_reversed34;
            case 35 -> TileLoader.ruin_reversed35;
            case 36 -> TileLoader.ruin_reversed36;
            case 37 -> TileLoader.ruin_reversed37;
            case 38 -> TileLoader.ruin_reversed38;
            case 39 -> TileLoader.ruin_reversed39;
            case 40 -> TileLoader.ruin_reversed40;
            case 41 -> TileLoader.ruin_reversed41;
            case 42 -> TileLoader.ruin_reversed42;
            case 43 -> TileLoader.ruin_reversed43;
            case 44 -> TileLoader.ruin_reversed44;
            case 45 -> TileLoader.ruin_reversed45;
            case 46 -> TileLoader.ruin_reversed46;
            case 47 -> TileLoader.ruin_reversed47;
            case 48 -> TileLoader.ruin_reversed48;
            case 49 -> TileLoader.ruin_reversed49;
            case 50 -> TileLoader.ruin_reversed50;
            case 51 -> TileLoader.ruin_reversed51;
            case 52 -> TileLoader.ruin_reversed52;
            case 53 -> TileLoader.ruin_reversed53;
            case 54 -> TileLoader.ruin_reversed54;
            case 55 -> TileLoader.ruin_reversed55;
            case 56 -> TileLoader.ruin_reversed56;
            case 57 -> TileLoader.ruin_reversed57;
            case 58 -> TileLoader.ruin_reversed58;
            case 59 -> TileLoader.ruin_reversed59;
            default -> 0;
        };
    }
    
}