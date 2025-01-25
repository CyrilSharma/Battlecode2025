package splashEnemies;
import battlecode.common.*;

public class Comms {
    public static RobotController rc;
    public static void init(RobotController rc) throws GameActionException {
        Comms.rc = rc;
    }

    public static void run() throws GameActionException {
        updateSym();
        broadcastSym();
    }

    public static void updateSym() throws GameActionException {
        Message[] m = rc.readMessages(-1);
        for (int i = m.length; --i >= 0;) {
            int msg = m[i].getBytes();
            SymmetryChecker.RSYM &= (msg & 1);
            SymmetryChecker.HSYM &= ((msg & 2) >> 1);
            SymmetryChecker.VSYM &= ((msg & 4) >> 2);
        }
    }

    public static void broadcastSym() throws GameActionException {
        int R = SymmetryChecker.RSYM;
        int H = SymmetryChecker.HSYM;
        int V = SymmetryChecker.VSYM;
        int send = R + 2 * H + 4 * V;
        if (Globals.isTower(rc.getType())) {
            if (rc.canBroadcastMessage()) {
                rc.broadcastMessage(send);
            }
            for (int i = Globals.friends.length; --i >= 0;) {
                if (rc.canSendMessage(Globals.friends[i].location, send)) {
                    rc.sendMessage(Globals.friends[i].location, send);
                }
            }
        }
        else {
            for (int i = Globals.friends.length; --i >= 0;) if (Globals.isTower(Globals.friends[i].getType())) {
                if (rc.canSendMessage(Globals.friends[i].location, send)) {
                    rc.sendMessage(Globals.friends[i].location, send);
                }
            }
        }
    }
}