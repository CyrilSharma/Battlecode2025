package sprint1Bot;
import battlecode.common.*;

public class Pathing {
    public static RobotController rc;
    public static void init(RobotController rc) {
        Pathing.rc = rc;
    }

    public static boolean canPaint(MapInfo mi) throws GameActionException {
        if (rc.getType() == UnitType.SOLDIER) {
            return (mi.getPaint() == PaintType.EMPTY && rc.getPaint() >= 50);
        }
        if (rc.getType() == UnitType.MOPPER) {
            return (!mi.getPaint().isAlly() && mi.getPaint() != PaintType.EMPTY);
        }
        return false;
    }

    public static void pathTo(MapLocation target) throws GameActionException {
        Direction dir = rc.getLocation().directionTo(target);
        MapInfo nextTile;
        if (rc.canMove(dir)){
            nextTile = rc.senseMapInfo(rc.getLocation().add(dir));
            if(canPaint(nextTile) && rc.canAttack(rc.getLocation().add(dir))){
                rc.attack(rc.getLocation().add(dir), Soldier.shouldUseSecond(rc.getLocation().add(dir)));
            }
            rc.move(dir);
            return;
        }
        Direction le = dir, ri = dir;
        loop: {
            
                le = le.rotateLeft();
                if (rc.canMove(le)) {
                    nextTile = rc.senseMapInfo(rc.getLocation().add(le));
                    if(canPaint(nextTile) && rc.canAttack(rc.getLocation().add(le))){
                        rc.attack(rc.getLocation().add(le), Soldier.shouldUseSecond(rc.getLocation().add(le)));
                    }
                    rc.move(le);
                    break loop;
                }               
                ri = ri.rotateRight();
                if (rc.canMove(ri)) {
                    nextTile = rc.senseMapInfo(rc.getLocation().add(ri));
                    if(canPaint(nextTile) && rc.canAttack(rc.getLocation().add(ri))){
                        rc.attack(rc.getLocation().add(ri), Soldier.shouldUseSecond(rc.getLocation().add(ri)));
                    }
                    rc.move(ri);
                    break loop;
                }               
            
                le = le.rotateLeft();
                if (rc.canMove(le)) {
                    nextTile = rc.senseMapInfo(rc.getLocation().add(le));
                    if(canPaint(nextTile) && rc.canAttack(rc.getLocation().add(le))){
                        rc.attack(rc.getLocation().add(le), Soldier.shouldUseSecond(rc.getLocation().add(le)));
                    }
                    rc.move(le);
                    break loop;
                }               
                ri = ri.rotateRight();
                if (rc.canMove(ri)) {
                    nextTile = rc.senseMapInfo(rc.getLocation().add(ri));
                    if(canPaint(nextTile) && rc.canAttack(rc.getLocation().add(ri))){
                        rc.attack(rc.getLocation().add(ri), Soldier.shouldUseSecond(rc.getLocation().add(ri)));
                    }
                    rc.move(ri);
                    break loop;
                }               
            
                le = le.rotateLeft();
                if (rc.canMove(le)) {
                    nextTile = rc.senseMapInfo(rc.getLocation().add(le));
                    if(canPaint(nextTile) && rc.canAttack(rc.getLocation().add(le))){
                        rc.attack(rc.getLocation().add(le), Soldier.shouldUseSecond(rc.getLocation().add(le)));
                    }
                    rc.move(le);
                    break loop;
                }               
                ri = ri.rotateRight();
                if (rc.canMove(ri)) {
                    nextTile = rc.senseMapInfo(rc.getLocation().add(ri));
                    if(canPaint(nextTile) && rc.canAttack(rc.getLocation().add(ri))){
                        rc.attack(rc.getLocation().add(ri), Soldier.shouldUseSecond(rc.getLocation().add(ri)));
                    }
                    rc.move(ri);
                    break loop;
                }               
            
                le = le.rotateLeft();
                if (rc.canMove(le)) {
                    nextTile = rc.senseMapInfo(rc.getLocation().add(le));
                    if(canPaint(nextTile) && rc.canAttack(rc.getLocation().add(le))){
                        rc.attack(rc.getLocation().add(le), Soldier.shouldUseSecond(rc.getLocation().add(le)));
                    }
                    rc.move(le);
                    break loop;
                }               
                ri = ri.rotateRight();
                if (rc.canMove(ri)) {
                    nextTile = rc.senseMapInfo(rc.getLocation().add(ri));
                    if(canPaint(nextTile) && rc.canAttack(rc.getLocation().add(ri))){
                        rc.attack(rc.getLocation().add(ri), Soldier.shouldUseSecond(rc.getLocation().add(ri)));
                    }
                    rc.move(ri);
                    break loop;
                }               
            
        }
    }
}