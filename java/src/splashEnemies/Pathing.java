package splashEnemies;
import battlecode.common.*;

public class Pathing {
    public static RobotController rc;
    public static void init(RobotController rc) {
        Pathing.rc = rc;
        resetPathing(null);
    }

    
    
    
    
    
    

    public static MapLocation myloc;
    public static int bestBugDist = 100000000;
    public static boolean shouldBug = false;
    public static boolean doneSimulating = false;
    public static MapLocation currentTarget = null;

    public static int pathLength = 0;
    
    public static MapLocation bugPath0 = null;
    
    public static MapLocation bugPath1 = null;
    
    public static MapLocation bugPath2 = null;
    
    public static MapLocation bugPath3 = null;
    
    public static MapLocation bugPath4 = null;
    
    public static MapLocation bugPath5 = null;
    
    public static MapLocation bugPath6 = null;
    
    public static MapLocation bugPath7 = null;
    
    public static MapLocation bugPath8 = null;
    
    public static MapLocation bugPath9 = null;
    
    public static MapLocation bugPath10 = null;
    
    public static MapLocation bugPath11 = null;
    
    public static MapLocation bugPath12 = null;
    
    public static MapLocation bugPath13 = null;
    
    public static MapLocation bugPath14 = null;
    
    public static MapLocation bugPath15 = null;
    
    public static MapLocation bugPath16 = null;
    
    public static MapLocation bugPath17 = null;
    
    public static MapLocation bugPath18 = null;
    
    public static MapLocation bugPath19 = null;
    
    public static MapLocation bugPath20 = null;
    
    public static MapLocation bugPath21 = null;
    
    public static MapLocation bugPath22 = null;
    
    public static MapLocation bugPath23 = null;
    
    public static MapLocation bugPath24 = null;
    
    public static MapLocation bugPath25 = null;
    
    public static MapLocation bugPath26 = null;
    
    public static MapLocation bugPath27 = null;
    
    public static MapLocation bugPath28 = null;
    
    public static MapLocation bugPath29 = null;
    
    public static MapLocation bugPath30 = null;
    
    public static MapLocation bugPath31 = null;
    
    public static MapLocation bugPath32 = null;
    
    public static MapLocation bugPath33 = null;
    
    public static MapLocation bugPath34 = null;
    
    public static MapLocation bugPath35 = null;
    
    public static MapLocation bugPath36 = null;
    
    public static MapLocation bugPath37 = null;
    
    public static MapLocation bugPath38 = null;
    
    public static MapLocation bugPath39 = null;
    
    public static MapLocation bugPath40 = null;
    
    public static MapLocation bugPath41 = null;
    
    public static MapLocation bugPath42 = null;
    
    public static MapLocation bugPath43 = null;
    
    public static MapLocation bugPath44 = null;
    
    public static MapLocation bugPath45 = null;
    
    public static MapLocation bugPath46 = null;
    
    public static MapLocation bugPath47 = null;
    
    public static MapLocation bugPath48 = null;
    
    public static MapLocation bugPath49 = null;
    
    public static MapLocation bugPath50 = null;
    
    public static MapLocation bugPath51 = null;
    
    public static MapLocation bugPath52 = null;
    
    public static MapLocation bugPath53 = null;
    
    public static MapLocation bugPath54 = null;
    
    public static MapLocation bugPath55 = null;
    
    public static MapLocation bugPath56 = null;
    
    public static MapLocation bugPath57 = null;
    
    public static MapLocation bugPath58 = null;
    
    public static MapLocation bugPath59 = null;
    
    public static MapLocation bugPath60 = null;
    
    public static MapLocation bugPath61 = null;
    
    public static MapLocation bugPath62 = null;
    
    public static MapLocation bugPath63 = null;
    
    public static MapLocation bugPath64 = null;
    
    public static MapLocation bugPath65 = null;
    
    public static MapLocation bugPath66 = null;
    
    public static MapLocation bugPath67 = null;
    
    public static MapLocation bugPath68 = null;
    
    public static MapLocation bugPath69 = null;
    
    public static MapLocation bugPath70 = null;
    
    public static MapLocation bugPath71 = null;
    
    public static MapLocation bugPath72 = null;
    
    public static MapLocation bugPath73 = null;
    
    public static MapLocation bugPath74 = null;
    
    public static MapLocation bugPath75 = null;
    
    public static MapLocation bugPath76 = null;
    
    public static MapLocation bugPath77 = null;
    
    public static MapLocation bugPath78 = null;
    
    public static MapLocation bugPath79 = null;
    
    public static MapLocation bugPath80 = null;
    
    public static MapLocation bugPath81 = null;
    
    public static MapLocation bugPath82 = null;
    
    public static MapLocation bugPath83 = null;
    
    public static MapLocation bugPath84 = null;
    
    public static MapLocation bugPath85 = null;
    
    public static MapLocation bugPath86 = null;
    
    public static MapLocation bugPath87 = null;
    
    public static MapLocation bugPath88 = null;
    
    public static MapLocation bugPath89 = null;
    
    public static MapLocation bugPath90 = null;
    
    public static MapLocation bugPath91 = null;
    
    public static MapLocation bugPath92 = null;
    
    public static MapLocation bugPath93 = null;
    
    public static MapLocation bugPath94 = null;
    
    public static MapLocation bugPath95 = null;
    
    public static MapLocation bugPath96 = null;
    
    public static MapLocation bugPath97 = null;
    
    public static MapLocation bugPath98 = null;
    
    public static MapLocation bugPath99 = null;
    
    public static MapLocation bugPath100 = null;
    
    public static MapLocation bugPath101 = null;
    
    public static MapLocation bugPath102 = null;
    
    public static MapLocation bugPath103 = null;
    
    public static MapLocation bugPath104 = null;
    
    public static MapLocation bugPath105 = null;
    
    public static MapLocation bugPath106 = null;
    
    public static MapLocation bugPath107 = null;
    
    public static MapLocation bugPath108 = null;
    
    public static MapLocation bugPath109 = null;
    
    public static MapLocation bugPath110 = null;
    
    public static MapLocation bugPath111 = null;
    
    public static MapLocation bugPath112 = null;
    
    public static MapLocation bugPath113 = null;
    
    public static MapLocation bugPath114 = null;
    
    public static MapLocation bugPath115 = null;
    
    public static MapLocation bugPath116 = null;
    
    public static MapLocation bugPath117 = null;
    
    public static MapLocation bugPath118 = null;
    
    public static MapLocation bugPath119 = null;
    
    public static MapLocation bugPath120 = null;
    
    public static MapLocation bugPath121 = null;
    
    public static MapLocation bugPath122 = null;
    
    public static MapLocation bugPath123 = null;
    
    public static MapLocation bugPath124 = null;
    
    public static MapLocation bugPath125 = null;
    
    public static MapLocation bugPath126 = null;
    
    public static MapLocation bugPath127 = null;
    
    public static MapLocation bugPath128 = null;
    
    public static MapLocation bugPath129 = null;
    
    public static MapLocation bugPath130 = null;
    
    public static MapLocation bugPath131 = null;
    
    public static MapLocation bugPath132 = null;
    
    public static MapLocation bugPath133 = null;
    
    public static MapLocation bugPath134 = null;
    
    public static MapLocation bugPath135 = null;
    
    public static MapLocation bugPath136 = null;
    
    public static MapLocation bugPath137 = null;
    
    public static MapLocation bugPath138 = null;
    
    public static MapLocation bugPath139 = null;
    
    public static MapLocation bugPath140 = null;
    
    public static MapLocation bugPath141 = null;
    
    public static MapLocation bugPath142 = null;
    
    public static MapLocation bugPath143 = null;
    
    public static MapLocation bugPath144 = null;
    
    public static MapLocation bugPath145 = null;
    
    public static MapLocation bugPath146 = null;
    
    public static MapLocation bugPath147 = null;
    
    public static MapLocation bugPath148 = null;
    
    public static MapLocation bugPath149 = null;
    
    public static MapLocation bugPath150 = null;
    
    public static MapLocation bugPath151 = null;
    
    public static MapLocation bugPath152 = null;
    
    public static MapLocation bugPath153 = null;
    
    public static MapLocation bugPath154 = null;
    
    public static MapLocation bugPath155 = null;
    
    public static MapLocation bugPath156 = null;
    
    public static MapLocation bugPath157 = null;
    
    public static MapLocation bugPath158 = null;
    
    public static MapLocation bugPath159 = null;
    
    public static MapLocation bugPath160 = null;
    
    public static MapLocation bugPath161 = null;
    
    public static MapLocation bugPath162 = null;
    
    public static MapLocation bugPath163 = null;
    
    public static MapLocation bugPath164 = null;
    
    public static MapLocation bugPath165 = null;
    
    public static MapLocation bugPath166 = null;
    
    public static MapLocation bugPath167 = null;
    
    public static MapLocation bugPath168 = null;
    
    public static MapLocation bugPath169 = null;
    
    public static MapLocation bugPath170 = null;
    
    public static MapLocation bugPath171 = null;
    
    public static MapLocation bugPath172 = null;
    
    public static MapLocation bugPath173 = null;
    
    public static MapLocation bugPath174 = null;
    
    public static MapLocation bugPath175 = null;
    
    public static MapLocation bugPath176 = null;
    
    public static MapLocation bugPath177 = null;
    
    public static MapLocation bugPath178 = null;
    
    public static MapLocation bugPath179 = null;
    
    public static MapLocation bugPath180 = null;
    
    public static MapLocation bugPath181 = null;
    
    public static MapLocation bugPath182 = null;
    
    public static MapLocation bugPath183 = null;
    
    public static MapLocation bugPath184 = null;
    
    public static MapLocation bugPath185 = null;
    
    public static MapLocation bugPath186 = null;
    
    public static MapLocation bugPath187 = null;
    
    public static MapLocation bugPath188 = null;
    
    public static MapLocation bugPath189 = null;
    
    public static MapLocation bugPath190 = null;
    
    public static MapLocation bugPath191 = null;
    
    public static MapLocation bugPath192 = null;
    
    public static MapLocation bugPath193 = null;
    
    public static MapLocation bugPath194 = null;
    
    public static MapLocation bugPath195 = null;
    
    public static MapLocation bugPath196 = null;
    
    public static MapLocation bugPath197 = null;
    
    public static MapLocation bugPath198 = null;
    
    public static MapLocation bugPath199 = null;
    
    public static MapLocation bugPath200 = null;
    
    public static MapLocation bugPath201 = null;
    
    public static MapLocation bugPath202 = null;
    
    public static MapLocation bugPath203 = null;
    
    public static MapLocation bugPath204 = null;
    
    public static MapLocation bugPath205 = null;
    
    public static MapLocation bugPath206 = null;
    
    public static MapLocation bugPath207 = null;
    
    public static MapLocation bugPath208 = null;
    
    public static MapLocation bugPath209 = null;
    
    public static MapLocation bugPath210 = null;
    
    public static MapLocation bugPath211 = null;
    
    public static MapLocation bugPath212 = null;
    
    public static MapLocation bugPath213 = null;
    
    public static MapLocation bugPath214 = null;
    
    public static MapLocation bugPath215 = null;
    
    public static MapLocation bugPath216 = null;
    
    public static MapLocation bugPath217 = null;
    
    public static MapLocation bugPath218 = null;
    
    public static MapLocation bugPath219 = null;
    
    public static MapLocation bugPath220 = null;
    
    public static MapLocation bugPath221 = null;
    
    public static MapLocation bugPath222 = null;
    
    public static MapLocation bugPath223 = null;
    
    public static MapLocation bugPath224 = null;
    
    public static MapLocation bugPath225 = null;
    
    public static MapLocation bugPath226 = null;
    
    public static MapLocation bugPath227 = null;
    
    public static MapLocation bugPath228 = null;
    
    public static MapLocation bugPath229 = null;
    
    public static MapLocation bugPath230 = null;
    
    public static MapLocation bugPath231 = null;
    
    public static MapLocation bugPath232 = null;
    
    public static MapLocation bugPath233 = null;
    
    public static MapLocation bugPath234 = null;
    
    public static MapLocation bugPath235 = null;
    
    public static MapLocation bugPath236 = null;
    
    public static MapLocation bugPath237 = null;
    
    public static MapLocation bugPath238 = null;
    
    public static MapLocation bugPath239 = null;
    
    public static MapLocation bugPath240 = null;
    
    public static MapLocation bugPath241 = null;
    
    public static MapLocation bugPath242 = null;
    
    public static MapLocation bugPath243 = null;
    
    public static MapLocation bugPath244 = null;
    
    public static MapLocation bugPath245 = null;
    
    public static MapLocation bugPath246 = null;
    
    public static MapLocation bugPath247 = null;
    
    public static MapLocation bugPath248 = null;
    
    public static MapLocation bugPath249 = null;
    
    public static MapLocation bugPath250 = null;
    
    public static MapLocation bugPath251 = null;
    
    public static MapLocation bugPath252 = null;
    
    public static MapLocation bugPath253 = null;
    
    public static MapLocation bugPath254 = null;
    
    public static MapLocation bugPath255 = null;
    
    public static MapLocation bugPath256 = null;
    
    public static MapLocation bugPath257 = null;
    
    public static MapLocation bugPath258 = null;
    
    public static MapLocation bugPath259 = null;
    
    public static MapLocation bugPath260 = null;
    
    public static MapLocation bugPath261 = null;
    
    public static MapLocation bugPath262 = null;
    
    public static MapLocation bugPath263 = null;
    
    public static MapLocation bugPath264 = null;
    
    public static MapLocation bugPath265 = null;
    
    public static MapLocation bugPath266 = null;
    
    public static MapLocation bugPath267 = null;
    
    public static MapLocation bugPath268 = null;
    
    public static MapLocation bugPath269 = null;
    
    public static MapLocation bugPath270 = null;
    
    public static MapLocation bugPath271 = null;
    
    public static MapLocation bugPath272 = null;
    
    public static MapLocation bugPath273 = null;
    
    public static MapLocation bugPath274 = null;
    
    public static MapLocation bugPath275 = null;
    
    public static MapLocation bugPath276 = null;
    
    public static MapLocation bugPath277 = null;
    
    public static MapLocation bugPath278 = null;
    
    public static MapLocation bugPath279 = null;
    
    public static MapLocation bugPath280 = null;
    
    public static MapLocation bugPath281 = null;
    
    public static MapLocation bugPath282 = null;
    
    public static MapLocation bugPath283 = null;
    
    public static MapLocation bugPath284 = null;
    
    public static MapLocation bugPath285 = null;
    
    public static MapLocation bugPath286 = null;
    
    public static MapLocation bugPath287 = null;
    
    public static MapLocation bugPath288 = null;
    
    public static MapLocation bugPath289 = null;
    
    public static MapLocation bugPath290 = null;
    
    public static MapLocation bugPath291 = null;
    
    public static MapLocation bugPath292 = null;
    
    public static MapLocation bugPath293 = null;
    
    public static MapLocation bugPath294 = null;
    
    public static MapLocation bugPath295 = null;
    
    public static MapLocation bugPath296 = null;
    
    public static MapLocation bugPath297 = null;
    
    public static MapLocation bugPath298 = null;
    
    public static MapLocation bugPath299 = null;
    
    public static MapLocation bugPath300 = null;
    
    public static MapLocation bugPath301 = null;
    
    public static MapLocation bugPath302 = null;
    
    public static MapLocation bugPath303 = null;
    
    public static MapLocation bugPath304 = null;
    
    public static MapLocation bugPath305 = null;
    
    public static MapLocation bugPath306 = null;
    
    public static MapLocation bugPath307 = null;
    
    public static MapLocation bugPath308 = null;
    
    public static MapLocation bugPath309 = null;
    
    public static MapLocation bugPath310 = null;
    
    public static MapLocation bugPath311 = null;
    
    public static MapLocation bugPath312 = null;
    
    public static MapLocation bugPath313 = null;
    
    public static MapLocation bugPath314 = null;
    
    public static MapLocation bugPath315 = null;
    
    public static MapLocation bugPath316 = null;
    
    public static MapLocation bugPath317 = null;
    
    public static MapLocation bugPath318 = null;
    
    public static MapLocation bugPath319 = null;
    
    public static MapLocation bugPath320 = null;
    
    public static MapLocation bugPath321 = null;
    
    public static MapLocation bugPath322 = null;
    
    public static MapLocation bugPath323 = null;
    
    public static MapLocation bugPath324 = null;
    
    public static MapLocation bugPath325 = null;
    
    public static MapLocation bugPath326 = null;
    
    public static MapLocation bugPath327 = null;
    
    public static MapLocation bugPath328 = null;
    
    public static MapLocation bugPath329 = null;
    
    public static MapLocation bugPath330 = null;
    
    public static MapLocation bugPath331 = null;
    
    public static MapLocation bugPath332 = null;
    
    public static MapLocation bugPath333 = null;
    
    public static MapLocation bugPath334 = null;
    
    public static MapLocation bugPath335 = null;
    
    public static MapLocation bugPath336 = null;
    
    public static MapLocation bugPath337 = null;
    
    public static MapLocation bugPath338 = null;
    
    public static MapLocation bugPath339 = null;
    
    public static MapLocation bugPath340 = null;
    
    public static MapLocation bugPath341 = null;
    
    public static MapLocation bugPath342 = null;
    
    public static MapLocation bugPath343 = null;
    
    public static MapLocation bugPath344 = null;
    
    public static MapLocation bugPath345 = null;
    
    public static MapLocation bugPath346 = null;
    
    public static MapLocation bugPath347 = null;
    
    public static MapLocation bugPath348 = null;
    
    public static MapLocation bugPath349 = null;
    
    public static MapLocation bugPath350 = null;
    
    public static MapLocation bugPath351 = null;
    
    public static MapLocation bugPath352 = null;
    
    public static MapLocation bugPath353 = null;
    
    public static MapLocation bugPath354 = null;
    
    public static MapLocation bugPath355 = null;
    
    public static MapLocation bugPath356 = null;
    
    public static MapLocation bugPath357 = null;
    
    public static MapLocation bugPath358 = null;
    
    public static MapLocation bugPath359 = null;
    
    public static MapLocation bugPath360 = null;
    
    public static MapLocation bugPath361 = null;
    
    public static MapLocation bugPath362 = null;
    
    public static MapLocation bugPath363 = null;
    
    public static MapLocation bugPath364 = null;
    
    public static MapLocation bugPath365 = null;
    
    public static MapLocation bugPath366 = null;
    
    public static MapLocation bugPath367 = null;
    
    public static MapLocation bugPath368 = null;
    
    public static MapLocation bugPath369 = null;
    
    public static MapLocation bugPath370 = null;
    
    public static MapLocation bugPath371 = null;
    
    public static MapLocation bugPath372 = null;
    
    public static MapLocation bugPath373 = null;
    
    public static MapLocation bugPath374 = null;
    
    public static MapLocation bugPath375 = null;
    
    public static MapLocation bugPath376 = null;
    
    public static MapLocation bugPath377 = null;
    
    public static MapLocation bugPath378 = null;
    
    public static MapLocation bugPath379 = null;
    
    public static MapLocation bugPath380 = null;
    
    public static MapLocation bugPath381 = null;
    
    public static MapLocation bugPath382 = null;
    
    public static MapLocation bugPath383 = null;
    
    public static MapLocation bugPath384 = null;
    
    public static MapLocation bugPath385 = null;
    
    public static MapLocation bugPath386 = null;
    
    public static MapLocation bugPath387 = null;
    
    public static MapLocation bugPath388 = null;
    
    public static MapLocation bugPath389 = null;
    
    public static MapLocation bugPath390 = null;
    
    public static MapLocation bugPath391 = null;
    
    public static MapLocation bugPath392 = null;
    
    public static MapLocation bugPath393 = null;
    
    public static MapLocation bugPath394 = null;
    
    public static MapLocation bugPath395 = null;
    
    public static MapLocation bugPath396 = null;
    
    public static MapLocation bugPath397 = null;
    
    public static MapLocation bugPath398 = null;
    
    public static MapLocation bugPath399 = null;
    
    public static MapLocation bugPath400 = null;
    
    public static MapLocation bugPath401 = null;
    
    public static MapLocation bugPath402 = null;
    
    public static MapLocation bugPath403 = null;
    
    public static MapLocation bugPath404 = null;
    
    public static MapLocation bugPath405 = null;
    
    public static MapLocation bugPath406 = null;
    
    public static MapLocation bugPath407 = null;
    
    public static MapLocation bugPath408 = null;
    
    public static MapLocation bugPath409 = null;
    
    public static MapLocation bugPath410 = null;
    
    public static MapLocation bugPath411 = null;
    
    public static MapLocation bugPath412 = null;
    
    public static MapLocation bugPath413 = null;
    
    public static MapLocation bugPath414 = null;
    
    public static MapLocation bugPath415 = null;
    
    public static MapLocation bugPath416 = null;
    
    public static MapLocation bugPath417 = null;
    
    public static MapLocation bugPath418 = null;
    
    public static MapLocation bugPath419 = null;
    
    public static MapLocation bugPath420 = null;
    
    public static MapLocation bugPath421 = null;
    
    public static MapLocation bugPath422 = null;
    
    public static MapLocation bugPath423 = null;
    
    public static MapLocation bugPath424 = null;
    
    public static MapLocation bugPath425 = null;
    
    public static MapLocation bugPath426 = null;
    
    public static MapLocation bugPath427 = null;
    
    public static MapLocation bugPath428 = null;
    
    public static MapLocation bugPath429 = null;
    
    public static MapLocation bugPath430 = null;
    
    public static MapLocation bugPath431 = null;
    
    public static MapLocation bugPath432 = null;
    
    public static MapLocation bugPath433 = null;
    
    public static MapLocation bugPath434 = null;
    
    public static MapLocation bugPath435 = null;
    
    public static MapLocation bugPath436 = null;
    
    public static MapLocation bugPath437 = null;
    
    public static MapLocation bugPath438 = null;
    
    public static MapLocation bugPath439 = null;
    
    public static MapLocation bugPath440 = null;
    
    public static MapLocation bugPath441 = null;
    
    public static MapLocation bugPath442 = null;
    
    public static MapLocation bugPath443 = null;
    
    public static MapLocation bugPath444 = null;
    
    public static MapLocation bugPath445 = null;
    
    public static MapLocation bugPath446 = null;
    
    public static MapLocation bugPath447 = null;
    
    public static MapLocation bugPath448 = null;
    
    public static MapLocation bugPath449 = null;
    
    public static MapLocation bugPath450 = null;
    
    public static MapLocation bugPath451 = null;
    
    public static MapLocation bugPath452 = null;
    
    public static MapLocation bugPath453 = null;
    
    public static MapLocation bugPath454 = null;
    
    public static MapLocation bugPath455 = null;
    
    public static MapLocation bugPath456 = null;
    
    public static MapLocation bugPath457 = null;
    
    public static MapLocation bugPath458 = null;
    
    public static MapLocation bugPath459 = null;
    
    public static MapLocation bugPath460 = null;
    
    public static MapLocation bugPath461 = null;
    
    public static MapLocation bugPath462 = null;
    
    public static MapLocation bugPath463 = null;
    
    public static MapLocation bugPath464 = null;
    
    public static MapLocation bugPath465 = null;
    
    public static MapLocation bugPath466 = null;
    
    public static MapLocation bugPath467 = null;
    
    public static MapLocation bugPath468 = null;
    
    public static MapLocation bugPath469 = null;
    
    public static MapLocation bugPath470 = null;
    
    public static MapLocation bugPath471 = null;
    
    public static MapLocation bugPath472 = null;
    
    public static MapLocation bugPath473 = null;
    
    public static MapLocation bugPath474 = null;
    
    public static MapLocation bugPath475 = null;
    
    public static MapLocation bugPath476 = null;
    
    public static MapLocation bugPath477 = null;
    
    public static MapLocation bugPath478 = null;
    
    public static MapLocation bugPath479 = null;
    
    public static MapLocation bugPath480 = null;
    
    public static MapLocation bugPath481 = null;
    
    public static MapLocation bugPath482 = null;
    
    public static MapLocation bugPath483 = null;
    
    public static MapLocation bugPath484 = null;
    
    public static MapLocation bugPath485 = null;
    
    public static MapLocation bugPath486 = null;
    
    public static MapLocation bugPath487 = null;
    
    public static MapLocation bugPath488 = null;
    
    public static MapLocation bugPath489 = null;
    
    public static MapLocation bugPath490 = null;
    
    public static MapLocation bugPath491 = null;
    
    public static MapLocation bugPath492 = null;
    
    public static MapLocation bugPath493 = null;
    
    public static MapLocation bugPath494 = null;
    
    public static MapLocation bugPath495 = null;
    
    public static MapLocation bugPath496 = null;
    
    public static MapLocation bugPath497 = null;
    
    public static MapLocation bugPath498 = null;
    
    public static MapLocation bugPath499 = null;
    

    public static void appendCurrentPosition() {
        switch (pathLength) {
            
            case 499 ->  {
                
                if (!bugPath498.equals(currentBugPosition))
                
                {
                    bugPath499 = currentBugPosition;
                    pathLength++;
                }
            }
            
            case 498 ->  {
                
                if (!bugPath497.equals(currentBugPosition))
                
                {
                    bugPath498 = currentBugPosition;
                    pathLength++;
                }
            }
            
            case 497 ->  {
                
                if (!bugPath496.equals(currentBugPosition))
                
                {
                    bugPath497 = currentBugPosition;
                    pathLength++;
                }
            }
            
            case 496 ->  {
                
                if (!bugPath495.equals(currentBugPosition))
                
                {
                    bugPath496 = currentBugPosition;
                    pathLength++;
                }
            }
            
            case 495 ->  {
                
                if (!bugPath494.equals(currentBugPosition))
                
                {
                    bugPath495 = currentBugPosition;
                    pathLength++;
                }
            }
            
            case 494 ->  {
                
                if (!bugPath493.equals(currentBugPosition))
                
                {
                    bugPath494 = currentBugPosition;
                    pathLength++;
                }
            }
            
            case 493 ->  {
                
                if (!bugPath492.equals(currentBugPosition))
                
                {
                    bugPath493 = currentBugPosition;
                    pathLength++;
                }
            }
            
            case 492 ->  {
                
                if (!bugPath491.equals(currentBugPosition))
                
                {
                    bugPath492 = currentBugPosition;
                    pathLength++;
                }
            }
            
            case 491 ->  {
                
                if (!bugPath490.equals(currentBugPosition))
                
                {
                    bugPath491 = currentBugPosition;
                    pathLength++;
                }
            }
            
            case 490 ->  {
                
                if (!bugPath489.equals(currentBugPosition))
                
                {
                    bugPath490 = currentBugPosition;
                    pathLength++;
                }
            }
            
            case 489 ->  {
                
                if (!bugPath488.equals(currentBugPosition))
                
                {
                    bugPath489 = currentBugPosition;
                    pathLength++;
                }
            }
            
            case 488 ->  {
                
                if (!bugPath487.equals(currentBugPosition))
                
                {
                    bugPath488 = currentBugPosition;
                    pathLength++;
                }
            }
            
            case 487 ->  {
                
                if (!bugPath486.equals(currentBugPosition))
                
                {
                    bugPath487 = currentBugPosition;
                    pathLength++;
                }
            }
            
            case 486 ->  {
                
                if (!bugPath485.equals(currentBugPosition))
                
                {
                    bugPath486 = currentBugPosition;
                    pathLength++;
                }
            }
            
            case 485 ->  {
                
                if (!bugPath484.equals(currentBugPosition))
                
                {
                    bugPath485 = currentBugPosition;
                    pathLength++;
                }
            }
            
            case 484 ->  {
                
                if (!bugPath483.equals(currentBugPosition))
                
                {
                    bugPath484 = currentBugPosition;
                    pathLength++;
                }
            }
            
            case 483 ->  {
                
                if (!bugPath482.equals(currentBugPosition))
                
                {
                    bugPath483 = currentBugPosition;
                    pathLength++;
                }
            }
            
            case 482 ->  {
                
                if (!bugPath481.equals(currentBugPosition))
                
                {
                    bugPath482 = currentBugPosition;
                    pathLength++;
                }
            }
            
            case 481 ->  {
                
                if (!bugPath480.equals(currentBugPosition))
                
                {
                    bugPath481 = currentBugPosition;
                    pathLength++;
                }
            }
            
            case 480 ->  {
                
                if (!bugPath479.equals(currentBugPosition))
                
                {
                    bugPath480 = currentBugPosition;
                    pathLength++;
                }
            }
            
            case 479 ->  {
                
                if (!bugPath478.equals(currentBugPosition))
                
                {
                    bugPath479 = currentBugPosition;
                    pathLength++;
                }
            }
            
            case 478 ->  {
                
                if (!bugPath477.equals(currentBugPosition))
                
                {
                    bugPath478 = currentBugPosition;
                    pathLength++;
                }
            }
            
            case 477 ->  {
                
                if (!bugPath476.equals(currentBugPosition))
                
                {
                    bugPath477 = currentBugPosition;
                    pathLength++;
                }
            }
            
            case 476 ->  {
                
                if (!bugPath475.equals(currentBugPosition))
                
                {
                    bugPath476 = currentBugPosition;
                    pathLength++;
                }
            }
            
            case 475 ->  {
                
                if (!bugPath474.equals(currentBugPosition))
                
                {
                    bugPath475 = currentBugPosition;
                    pathLength++;
                }
            }
            
            case 474 ->  {
                
                if (!bugPath473.equals(currentBugPosition))
                
                {
                    bugPath474 = currentBugPosition;
                    pathLength++;
                }
            }
            
            case 473 ->  {
                
                if (!bugPath472.equals(currentBugPosition))
                
                {
                    bugPath473 = currentBugPosition;
                    pathLength++;
                }
            }
            
            case 472 ->  {
                
                if (!bugPath471.equals(currentBugPosition))
                
                {
                    bugPath472 = currentBugPosition;
                    pathLength++;
                }
            }
            
            case 471 ->  {
                
                if (!bugPath470.equals(currentBugPosition))
                
                {
                    bugPath471 = currentBugPosition;
                    pathLength++;
                }
            }
            
            case 470 ->  {
                
                if (!bugPath469.equals(currentBugPosition))
                
                {
                    bugPath470 = currentBugPosition;
                    pathLength++;
                }
            }
            
            case 469 ->  {
                
                if (!bugPath468.equals(currentBugPosition))
                
                {
                    bugPath469 = currentBugPosition;
                    pathLength++;
                }
            }
            
            case 468 ->  {
                
                if (!bugPath467.equals(currentBugPosition))
                
                {
                    bugPath468 = currentBugPosition;
                    pathLength++;
                }
            }
            
            case 467 ->  {
                
                if (!bugPath466.equals(currentBugPosition))
                
                {
                    bugPath467 = currentBugPosition;
                    pathLength++;
                }
            }
            
            case 466 ->  {
                
                if (!bugPath465.equals(currentBugPosition))
                
                {
                    bugPath466 = currentBugPosition;
                    pathLength++;
                }
            }
            
            case 465 ->  {
                
                if (!bugPath464.equals(currentBugPosition))
                
                {
                    bugPath465 = currentBugPosition;
                    pathLength++;
                }
            }
            
            case 464 ->  {
                
                if (!bugPath463.equals(currentBugPosition))
                
                {
                    bugPath464 = currentBugPosition;
                    pathLength++;
                }
            }
            
            case 463 ->  {
                
                if (!bugPath462.equals(currentBugPosition))
                
                {
                    bugPath463 = currentBugPosition;
                    pathLength++;
                }
            }
            
            case 462 ->  {
                
                if (!bugPath461.equals(currentBugPosition))
                
                {
                    bugPath462 = currentBugPosition;
                    pathLength++;
                }
            }
            
            case 461 ->  {
                
                if (!bugPath460.equals(currentBugPosition))
                
                {
                    bugPath461 = currentBugPosition;
                    pathLength++;
                }
            }
            
            case 460 ->  {
                
                if (!bugPath459.equals(currentBugPosition))
                
                {
                    bugPath460 = currentBugPosition;
                    pathLength++;
                }
            }
            
            case 459 ->  {
                
                if (!bugPath458.equals(currentBugPosition))
                
                {
                    bugPath459 = currentBugPosition;
                    pathLength++;
                }
            }
            
            case 458 ->  {
                
                if (!bugPath457.equals(currentBugPosition))
                
                {
                    bugPath458 = currentBugPosition;
                    pathLength++;
                }
            }
            
            case 457 ->  {
                
                if (!bugPath456.equals(currentBugPosition))
                
                {
                    bugPath457 = currentBugPosition;
                    pathLength++;
                }
            }
            
            case 456 ->  {
                
                if (!bugPath455.equals(currentBugPosition))
                
                {
                    bugPath456 = currentBugPosition;
                    pathLength++;
                }
            }
            
            case 455 ->  {
                
                if (!bugPath454.equals(currentBugPosition))
                
                {
                    bugPath455 = currentBugPosition;
                    pathLength++;
                }
            }
            
            case 454 ->  {
                
                if (!bugPath453.equals(currentBugPosition))
                
                {
                    bugPath454 = currentBugPosition;
                    pathLength++;
                }
            }
            
            case 453 ->  {
                
                if (!bugPath452.equals(currentBugPosition))
                
                {
                    bugPath453 = currentBugPosition;
                    pathLength++;
                }
            }
            
            case 452 ->  {
                
                if (!bugPath451.equals(currentBugPosition))
                
                {
                    bugPath452 = currentBugPosition;
                    pathLength++;
                }
            }
            
            case 451 ->  {
                
                if (!bugPath450.equals(currentBugPosition))
                
                {
                    bugPath451 = currentBugPosition;
                    pathLength++;
                }
            }
            
            case 450 ->  {
                
                if (!bugPath449.equals(currentBugPosition))
                
                {
                    bugPath450 = currentBugPosition;
                    pathLength++;
                }
            }
            
            case 449 ->  {
                
                if (!bugPath448.equals(currentBugPosition))
                
                {
                    bugPath449 = currentBugPosition;
                    pathLength++;
                }
            }
            
            case 448 ->  {
                
                if (!bugPath447.equals(currentBugPosition))
                
                {
                    bugPath448 = currentBugPosition;
                    pathLength++;
                }
            }
            
            case 447 ->  {
                
                if (!bugPath446.equals(currentBugPosition))
                
                {
                    bugPath447 = currentBugPosition;
                    pathLength++;
                }
            }
            
            case 446 ->  {
                
                if (!bugPath445.equals(currentBugPosition))
                
                {
                    bugPath446 = currentBugPosition;
                    pathLength++;
                }
            }
            
            case 445 ->  {
                
                if (!bugPath444.equals(currentBugPosition))
                
                {
                    bugPath445 = currentBugPosition;
                    pathLength++;
                }
            }
            
            case 444 ->  {
                
                if (!bugPath443.equals(currentBugPosition))
                
                {
                    bugPath444 = currentBugPosition;
                    pathLength++;
                }
            }
            
            case 443 ->  {
                
                if (!bugPath442.equals(currentBugPosition))
                
                {
                    bugPath443 = currentBugPosition;
                    pathLength++;
                }
            }
            
            case 442 ->  {
                
                if (!bugPath441.equals(currentBugPosition))
                
                {
                    bugPath442 = currentBugPosition;
                    pathLength++;
                }
            }
            
            case 441 ->  {
                
                if (!bugPath440.equals(currentBugPosition))
                
                {
                    bugPath441 = currentBugPosition;
                    pathLength++;
                }
            }
            
            case 440 ->  {
                
                if (!bugPath439.equals(currentBugPosition))
                
                {
                    bugPath440 = currentBugPosition;
                    pathLength++;
                }
            }
            
            case 439 ->  {
                
                if (!bugPath438.equals(currentBugPosition))
                
                {
                    bugPath439 = currentBugPosition;
                    pathLength++;
                }
            }
            
            case 438 ->  {
                
                if (!bugPath437.equals(currentBugPosition))
                
                {
                    bugPath438 = currentBugPosition;
                    pathLength++;
                }
            }
            
            case 437 ->  {
                
                if (!bugPath436.equals(currentBugPosition))
                
                {
                    bugPath437 = currentBugPosition;
                    pathLength++;
                }
            }
            
            case 436 ->  {
                
                if (!bugPath435.equals(currentBugPosition))
                
                {
                    bugPath436 = currentBugPosition;
                    pathLength++;
                }
            }
            
            case 435 ->  {
                
                if (!bugPath434.equals(currentBugPosition))
                
                {
                    bugPath435 = currentBugPosition;
                    pathLength++;
                }
            }
            
            case 434 ->  {
                
                if (!bugPath433.equals(currentBugPosition))
                
                {
                    bugPath434 = currentBugPosition;
                    pathLength++;
                }
            }
            
            case 433 ->  {
                
                if (!bugPath432.equals(currentBugPosition))
                
                {
                    bugPath433 = currentBugPosition;
                    pathLength++;
                }
            }
            
            case 432 ->  {
                
                if (!bugPath431.equals(currentBugPosition))
                
                {
                    bugPath432 = currentBugPosition;
                    pathLength++;
                }
            }
            
            case 431 ->  {
                
                if (!bugPath430.equals(currentBugPosition))
                
                {
                    bugPath431 = currentBugPosition;
                    pathLength++;
                }
            }
            
            case 430 ->  {
                
                if (!bugPath429.equals(currentBugPosition))
                
                {
                    bugPath430 = currentBugPosition;
                    pathLength++;
                }
            }
            
            case 429 ->  {
                
                if (!bugPath428.equals(currentBugPosition))
                
                {
                    bugPath429 = currentBugPosition;
                    pathLength++;
                }
            }
            
            case 428 ->  {
                
                if (!bugPath427.equals(currentBugPosition))
                
                {
                    bugPath428 = currentBugPosition;
                    pathLength++;
                }
            }
            
            case 427 ->  {
                
                if (!bugPath426.equals(currentBugPosition))
                
                {
                    bugPath427 = currentBugPosition;
                    pathLength++;
                }
            }
            
            case 426 ->  {
                
                if (!bugPath425.equals(currentBugPosition))
                
                {
                    bugPath426 = currentBugPosition;
                    pathLength++;
                }
            }
            
            case 425 ->  {
                
                if (!bugPath424.equals(currentBugPosition))
                
                {
                    bugPath425 = currentBugPosition;
                    pathLength++;
                }
            }
            
            case 424 ->  {
                
                if (!bugPath423.equals(currentBugPosition))
                
                {
                    bugPath424 = currentBugPosition;
                    pathLength++;
                }
            }
            
            case 423 ->  {
                
                if (!bugPath422.equals(currentBugPosition))
                
                {
                    bugPath423 = currentBugPosition;
                    pathLength++;
                }
            }
            
            case 422 ->  {
                
                if (!bugPath421.equals(currentBugPosition))
                
                {
                    bugPath422 = currentBugPosition;
                    pathLength++;
                }
            }
            
            case 421 ->  {
                
                if (!bugPath420.equals(currentBugPosition))
                
                {
                    bugPath421 = currentBugPosition;
                    pathLength++;
                }
            }
            
            case 420 ->  {
                
                if (!bugPath419.equals(currentBugPosition))
                
                {
                    bugPath420 = currentBugPosition;
                    pathLength++;
                }
            }
            
            case 419 ->  {
                
                if (!bugPath418.equals(currentBugPosition))
                
                {
                    bugPath419 = currentBugPosition;
                    pathLength++;
                }
            }
            
            case 418 ->  {
                
                if (!bugPath417.equals(currentBugPosition))
                
                {
                    bugPath418 = currentBugPosition;
                    pathLength++;
                }
            }
            
            case 417 ->  {
                
                if (!bugPath416.equals(currentBugPosition))
                
                {
                    bugPath417 = currentBugPosition;
                    pathLength++;
                }
            }
            
            case 416 ->  {
                
                if (!bugPath415.equals(currentBugPosition))
                
                {
                    bugPath416 = currentBugPosition;
                    pathLength++;
                }
            }
            
            case 415 ->  {
                
                if (!bugPath414.equals(currentBugPosition))
                
                {
                    bugPath415 = currentBugPosition;
                    pathLength++;
                }
            }
            
            case 414 ->  {
                
                if (!bugPath413.equals(currentBugPosition))
                
                {
                    bugPath414 = currentBugPosition;
                    pathLength++;
                }
            }
            
            case 413 ->  {
                
                if (!bugPath412.equals(currentBugPosition))
                
                {
                    bugPath413 = currentBugPosition;
                    pathLength++;
                }
            }
            
            case 412 ->  {
                
                if (!bugPath411.equals(currentBugPosition))
                
                {
                    bugPath412 = currentBugPosition;
                    pathLength++;
                }
            }
            
            case 411 ->  {
                
                if (!bugPath410.equals(currentBugPosition))
                
                {
                    bugPath411 = currentBugPosition;
                    pathLength++;
                }
            }
            
            case 410 ->  {
                
                if (!bugPath409.equals(currentBugPosition))
                
                {
                    bugPath410 = currentBugPosition;
                    pathLength++;
                }
            }
            
            case 409 ->  {
                
                if (!bugPath408.equals(currentBugPosition))
                
                {
                    bugPath409 = currentBugPosition;
                    pathLength++;
                }
            }
            
            case 408 ->  {
                
                if (!bugPath407.equals(currentBugPosition))
                
                {
                    bugPath408 = currentBugPosition;
                    pathLength++;
                }
            }
            
            case 407 ->  {
                
                if (!bugPath406.equals(currentBugPosition))
                
                {
                    bugPath407 = currentBugPosition;
                    pathLength++;
                }
            }
            
            case 406 ->  {
                
                if (!bugPath405.equals(currentBugPosition))
                
                {
                    bugPath406 = currentBugPosition;
                    pathLength++;
                }
            }
            
            case 405 ->  {
                
                if (!bugPath404.equals(currentBugPosition))
                
                {
                    bugPath405 = currentBugPosition;
                    pathLength++;
                }
            }
            
            case 404 ->  {
                
                if (!bugPath403.equals(currentBugPosition))
                
                {
                    bugPath404 = currentBugPosition;
                    pathLength++;
                }
            }
            
            case 403 ->  {
                
                if (!bugPath402.equals(currentBugPosition))
                
                {
                    bugPath403 = currentBugPosition;
                    pathLength++;
                }
            }
            
            case 402 ->  {
                
                if (!bugPath401.equals(currentBugPosition))
                
                {
                    bugPath402 = currentBugPosition;
                    pathLength++;
                }
            }
            
            case 401 ->  {
                
                if (!bugPath400.equals(currentBugPosition))
                
                {
                    bugPath401 = currentBugPosition;
                    pathLength++;
                }
            }
            
            case 400 ->  {
                
                if (!bugPath399.equals(currentBugPosition))
                
                {
                    bugPath400 = currentBugPosition;
                    pathLength++;
                }
            }
            
            case 399 ->  {
                
                if (!bugPath398.equals(currentBugPosition))
                
                {
                    bugPath399 = currentBugPosition;
                    pathLength++;
                }
            }
            
            case 398 ->  {
                
                if (!bugPath397.equals(currentBugPosition))
                
                {
                    bugPath398 = currentBugPosition;
                    pathLength++;
                }
            }
            
            case 397 ->  {
                
                if (!bugPath396.equals(currentBugPosition))
                
                {
                    bugPath397 = currentBugPosition;
                    pathLength++;
                }
            }
            
            case 396 ->  {
                
                if (!bugPath395.equals(currentBugPosition))
                
                {
                    bugPath396 = currentBugPosition;
                    pathLength++;
                }
            }
            
            case 395 ->  {
                
                if (!bugPath394.equals(currentBugPosition))
                
                {
                    bugPath395 = currentBugPosition;
                    pathLength++;
                }
            }
            
            case 394 ->  {
                
                if (!bugPath393.equals(currentBugPosition))
                
                {
                    bugPath394 = currentBugPosition;
                    pathLength++;
                }
            }
            
            case 393 ->  {
                
                if (!bugPath392.equals(currentBugPosition))
                
                {
                    bugPath393 = currentBugPosition;
                    pathLength++;
                }
            }
            
            case 392 ->  {
                
                if (!bugPath391.equals(currentBugPosition))
                
                {
                    bugPath392 = currentBugPosition;
                    pathLength++;
                }
            }
            
            case 391 ->  {
                
                if (!bugPath390.equals(currentBugPosition))
                
                {
                    bugPath391 = currentBugPosition;
                    pathLength++;
                }
            }
            
            case 390 ->  {
                
                if (!bugPath389.equals(currentBugPosition))
                
                {
                    bugPath390 = currentBugPosition;
                    pathLength++;
                }
            }
            
            case 389 ->  {
                
                if (!bugPath388.equals(currentBugPosition))
                
                {
                    bugPath389 = currentBugPosition;
                    pathLength++;
                }
            }
            
            case 388 ->  {
                
                if (!bugPath387.equals(currentBugPosition))
                
                {
                    bugPath388 = currentBugPosition;
                    pathLength++;
                }
            }
            
            case 387 ->  {
                
                if (!bugPath386.equals(currentBugPosition))
                
                {
                    bugPath387 = currentBugPosition;
                    pathLength++;
                }
            }
            
            case 386 ->  {
                
                if (!bugPath385.equals(currentBugPosition))
                
                {
                    bugPath386 = currentBugPosition;
                    pathLength++;
                }
            }
            
            case 385 ->  {
                
                if (!bugPath384.equals(currentBugPosition))
                
                {
                    bugPath385 = currentBugPosition;
                    pathLength++;
                }
            }
            
            case 384 ->  {
                
                if (!bugPath383.equals(currentBugPosition))
                
                {
                    bugPath384 = currentBugPosition;
                    pathLength++;
                }
            }
            
            case 383 ->  {
                
                if (!bugPath382.equals(currentBugPosition))
                
                {
                    bugPath383 = currentBugPosition;
                    pathLength++;
                }
            }
            
            case 382 ->  {
                
                if (!bugPath381.equals(currentBugPosition))
                
                {
                    bugPath382 = currentBugPosition;
                    pathLength++;
                }
            }
            
            case 381 ->  {
                
                if (!bugPath380.equals(currentBugPosition))
                
                {
                    bugPath381 = currentBugPosition;
                    pathLength++;
                }
            }
            
            case 380 ->  {
                
                if (!bugPath379.equals(currentBugPosition))
                
                {
                    bugPath380 = currentBugPosition;
                    pathLength++;
                }
            }
            
            case 379 ->  {
                
                if (!bugPath378.equals(currentBugPosition))
                
                {
                    bugPath379 = currentBugPosition;
                    pathLength++;
                }
            }
            
            case 378 ->  {
                
                if (!bugPath377.equals(currentBugPosition))
                
                {
                    bugPath378 = currentBugPosition;
                    pathLength++;
                }
            }
            
            case 377 ->  {
                
                if (!bugPath376.equals(currentBugPosition))
                
                {
                    bugPath377 = currentBugPosition;
                    pathLength++;
                }
            }
            
            case 376 ->  {
                
                if (!bugPath375.equals(currentBugPosition))
                
                {
                    bugPath376 = currentBugPosition;
                    pathLength++;
                }
            }
            
            case 375 ->  {
                
                if (!bugPath374.equals(currentBugPosition))
                
                {
                    bugPath375 = currentBugPosition;
                    pathLength++;
                }
            }
            
            case 374 ->  {
                
                if (!bugPath373.equals(currentBugPosition))
                
                {
                    bugPath374 = currentBugPosition;
                    pathLength++;
                }
            }
            
            case 373 ->  {
                
                if (!bugPath372.equals(currentBugPosition))
                
                {
                    bugPath373 = currentBugPosition;
                    pathLength++;
                }
            }
            
            case 372 ->  {
                
                if (!bugPath371.equals(currentBugPosition))
                
                {
                    bugPath372 = currentBugPosition;
                    pathLength++;
                }
            }
            
            case 371 ->  {
                
                if (!bugPath370.equals(currentBugPosition))
                
                {
                    bugPath371 = currentBugPosition;
                    pathLength++;
                }
            }
            
            case 370 ->  {
                
                if (!bugPath369.equals(currentBugPosition))
                
                {
                    bugPath370 = currentBugPosition;
                    pathLength++;
                }
            }
            
            case 369 ->  {
                
                if (!bugPath368.equals(currentBugPosition))
                
                {
                    bugPath369 = currentBugPosition;
                    pathLength++;
                }
            }
            
            case 368 ->  {
                
                if (!bugPath367.equals(currentBugPosition))
                
                {
                    bugPath368 = currentBugPosition;
                    pathLength++;
                }
            }
            
            case 367 ->  {
                
                if (!bugPath366.equals(currentBugPosition))
                
                {
                    bugPath367 = currentBugPosition;
                    pathLength++;
                }
            }
            
            case 366 ->  {
                
                if (!bugPath365.equals(currentBugPosition))
                
                {
                    bugPath366 = currentBugPosition;
                    pathLength++;
                }
            }
            
            case 365 ->  {
                
                if (!bugPath364.equals(currentBugPosition))
                
                {
                    bugPath365 = currentBugPosition;
                    pathLength++;
                }
            }
            
            case 364 ->  {
                
                if (!bugPath363.equals(currentBugPosition))
                
                {
                    bugPath364 = currentBugPosition;
                    pathLength++;
                }
            }
            
            case 363 ->  {
                
                if (!bugPath362.equals(currentBugPosition))
                
                {
                    bugPath363 = currentBugPosition;
                    pathLength++;
                }
            }
            
            case 362 ->  {
                
                if (!bugPath361.equals(currentBugPosition))
                
                {
                    bugPath362 = currentBugPosition;
                    pathLength++;
                }
            }
            
            case 361 ->  {
                
                if (!bugPath360.equals(currentBugPosition))
                
                {
                    bugPath361 = currentBugPosition;
                    pathLength++;
                }
            }
            
            case 360 ->  {
                
                if (!bugPath359.equals(currentBugPosition))
                
                {
                    bugPath360 = currentBugPosition;
                    pathLength++;
                }
            }
            
            case 359 ->  {
                
                if (!bugPath358.equals(currentBugPosition))
                
                {
                    bugPath359 = currentBugPosition;
                    pathLength++;
                }
            }
            
            case 358 ->  {
                
                if (!bugPath357.equals(currentBugPosition))
                
                {
                    bugPath358 = currentBugPosition;
                    pathLength++;
                }
            }
            
            case 357 ->  {
                
                if (!bugPath356.equals(currentBugPosition))
                
                {
                    bugPath357 = currentBugPosition;
                    pathLength++;
                }
            }
            
            case 356 ->  {
                
                if (!bugPath355.equals(currentBugPosition))
                
                {
                    bugPath356 = currentBugPosition;
                    pathLength++;
                }
            }
            
            case 355 ->  {
                
                if (!bugPath354.equals(currentBugPosition))
                
                {
                    bugPath355 = currentBugPosition;
                    pathLength++;
                }
            }
            
            case 354 ->  {
                
                if (!bugPath353.equals(currentBugPosition))
                
                {
                    bugPath354 = currentBugPosition;
                    pathLength++;
                }
            }
            
            case 353 ->  {
                
                if (!bugPath352.equals(currentBugPosition))
                
                {
                    bugPath353 = currentBugPosition;
                    pathLength++;
                }
            }
            
            case 352 ->  {
                
                if (!bugPath351.equals(currentBugPosition))
                
                {
                    bugPath352 = currentBugPosition;
                    pathLength++;
                }
            }
            
            case 351 ->  {
                
                if (!bugPath350.equals(currentBugPosition))
                
                {
                    bugPath351 = currentBugPosition;
                    pathLength++;
                }
            }
            
            case 350 ->  {
                
                if (!bugPath349.equals(currentBugPosition))
                
                {
                    bugPath350 = currentBugPosition;
                    pathLength++;
                }
            }
            
            case 349 ->  {
                
                if (!bugPath348.equals(currentBugPosition))
                
                {
                    bugPath349 = currentBugPosition;
                    pathLength++;
                }
            }
            
            case 348 ->  {
                
                if (!bugPath347.equals(currentBugPosition))
                
                {
                    bugPath348 = currentBugPosition;
                    pathLength++;
                }
            }
            
            case 347 ->  {
                
                if (!bugPath346.equals(currentBugPosition))
                
                {
                    bugPath347 = currentBugPosition;
                    pathLength++;
                }
            }
            
            case 346 ->  {
                
                if (!bugPath345.equals(currentBugPosition))
                
                {
                    bugPath346 = currentBugPosition;
                    pathLength++;
                }
            }
            
            case 345 ->  {
                
                if (!bugPath344.equals(currentBugPosition))
                
                {
                    bugPath345 = currentBugPosition;
                    pathLength++;
                }
            }
            
            case 344 ->  {
                
                if (!bugPath343.equals(currentBugPosition))
                
                {
                    bugPath344 = currentBugPosition;
                    pathLength++;
                }
            }
            
            case 343 ->  {
                
                if (!bugPath342.equals(currentBugPosition))
                
                {
                    bugPath343 = currentBugPosition;
                    pathLength++;
                }
            }
            
            case 342 ->  {
                
                if (!bugPath341.equals(currentBugPosition))
                
                {
                    bugPath342 = currentBugPosition;
                    pathLength++;
                }
            }
            
            case 341 ->  {
                
                if (!bugPath340.equals(currentBugPosition))
                
                {
                    bugPath341 = currentBugPosition;
                    pathLength++;
                }
            }
            
            case 340 ->  {
                
                if (!bugPath339.equals(currentBugPosition))
                
                {
                    bugPath340 = currentBugPosition;
                    pathLength++;
                }
            }
            
            case 339 ->  {
                
                if (!bugPath338.equals(currentBugPosition))
                
                {
                    bugPath339 = currentBugPosition;
                    pathLength++;
                }
            }
            
            case 338 ->  {
                
                if (!bugPath337.equals(currentBugPosition))
                
                {
                    bugPath338 = currentBugPosition;
                    pathLength++;
                }
            }
            
            case 337 ->  {
                
                if (!bugPath336.equals(currentBugPosition))
                
                {
                    bugPath337 = currentBugPosition;
                    pathLength++;
                }
            }
            
            case 336 ->  {
                
                if (!bugPath335.equals(currentBugPosition))
                
                {
                    bugPath336 = currentBugPosition;
                    pathLength++;
                }
            }
            
            case 335 ->  {
                
                if (!bugPath334.equals(currentBugPosition))
                
                {
                    bugPath335 = currentBugPosition;
                    pathLength++;
                }
            }
            
            case 334 ->  {
                
                if (!bugPath333.equals(currentBugPosition))
                
                {
                    bugPath334 = currentBugPosition;
                    pathLength++;
                }
            }
            
            case 333 ->  {
                
                if (!bugPath332.equals(currentBugPosition))
                
                {
                    bugPath333 = currentBugPosition;
                    pathLength++;
                }
            }
            
            case 332 ->  {
                
                if (!bugPath331.equals(currentBugPosition))
                
                {
                    bugPath332 = currentBugPosition;
                    pathLength++;
                }
            }
            
            case 331 ->  {
                
                if (!bugPath330.equals(currentBugPosition))
                
                {
                    bugPath331 = currentBugPosition;
                    pathLength++;
                }
            }
            
            case 330 ->  {
                
                if (!bugPath329.equals(currentBugPosition))
                
                {
                    bugPath330 = currentBugPosition;
                    pathLength++;
                }
            }
            
            case 329 ->  {
                
                if (!bugPath328.equals(currentBugPosition))
                
                {
                    bugPath329 = currentBugPosition;
                    pathLength++;
                }
            }
            
            case 328 ->  {
                
                if (!bugPath327.equals(currentBugPosition))
                
                {
                    bugPath328 = currentBugPosition;
                    pathLength++;
                }
            }
            
            case 327 ->  {
                
                if (!bugPath326.equals(currentBugPosition))
                
                {
                    bugPath327 = currentBugPosition;
                    pathLength++;
                }
            }
            
            case 326 ->  {
                
                if (!bugPath325.equals(currentBugPosition))
                
                {
                    bugPath326 = currentBugPosition;
                    pathLength++;
                }
            }
            
            case 325 ->  {
                
                if (!bugPath324.equals(currentBugPosition))
                
                {
                    bugPath325 = currentBugPosition;
                    pathLength++;
                }
            }
            
            case 324 ->  {
                
                if (!bugPath323.equals(currentBugPosition))
                
                {
                    bugPath324 = currentBugPosition;
                    pathLength++;
                }
            }
            
            case 323 ->  {
                
                if (!bugPath322.equals(currentBugPosition))
                
                {
                    bugPath323 = currentBugPosition;
                    pathLength++;
                }
            }
            
            case 322 ->  {
                
                if (!bugPath321.equals(currentBugPosition))
                
                {
                    bugPath322 = currentBugPosition;
                    pathLength++;
                }
            }
            
            case 321 ->  {
                
                if (!bugPath320.equals(currentBugPosition))
                
                {
                    bugPath321 = currentBugPosition;
                    pathLength++;
                }
            }
            
            case 320 ->  {
                
                if (!bugPath319.equals(currentBugPosition))
                
                {
                    bugPath320 = currentBugPosition;
                    pathLength++;
                }
            }
            
            case 319 ->  {
                
                if (!bugPath318.equals(currentBugPosition))
                
                {
                    bugPath319 = currentBugPosition;
                    pathLength++;
                }
            }
            
            case 318 ->  {
                
                if (!bugPath317.equals(currentBugPosition))
                
                {
                    bugPath318 = currentBugPosition;
                    pathLength++;
                }
            }
            
            case 317 ->  {
                
                if (!bugPath316.equals(currentBugPosition))
                
                {
                    bugPath317 = currentBugPosition;
                    pathLength++;
                }
            }
            
            case 316 ->  {
                
                if (!bugPath315.equals(currentBugPosition))
                
                {
                    bugPath316 = currentBugPosition;
                    pathLength++;
                }
            }
            
            case 315 ->  {
                
                if (!bugPath314.equals(currentBugPosition))
                
                {
                    bugPath315 = currentBugPosition;
                    pathLength++;
                }
            }
            
            case 314 ->  {
                
                if (!bugPath313.equals(currentBugPosition))
                
                {
                    bugPath314 = currentBugPosition;
                    pathLength++;
                }
            }
            
            case 313 ->  {
                
                if (!bugPath312.equals(currentBugPosition))
                
                {
                    bugPath313 = currentBugPosition;
                    pathLength++;
                }
            }
            
            case 312 ->  {
                
                if (!bugPath311.equals(currentBugPosition))
                
                {
                    bugPath312 = currentBugPosition;
                    pathLength++;
                }
            }
            
            case 311 ->  {
                
                if (!bugPath310.equals(currentBugPosition))
                
                {
                    bugPath311 = currentBugPosition;
                    pathLength++;
                }
            }
            
            case 310 ->  {
                
                if (!bugPath309.equals(currentBugPosition))
                
                {
                    bugPath310 = currentBugPosition;
                    pathLength++;
                }
            }
            
            case 309 ->  {
                
                if (!bugPath308.equals(currentBugPosition))
                
                {
                    bugPath309 = currentBugPosition;
                    pathLength++;
                }
            }
            
            case 308 ->  {
                
                if (!bugPath307.equals(currentBugPosition))
                
                {
                    bugPath308 = currentBugPosition;
                    pathLength++;
                }
            }
            
            case 307 ->  {
                
                if (!bugPath306.equals(currentBugPosition))
                
                {
                    bugPath307 = currentBugPosition;
                    pathLength++;
                }
            }
            
            case 306 ->  {
                
                if (!bugPath305.equals(currentBugPosition))
                
                {
                    bugPath306 = currentBugPosition;
                    pathLength++;
                }
            }
            
            case 305 ->  {
                
                if (!bugPath304.equals(currentBugPosition))
                
                {
                    bugPath305 = currentBugPosition;
                    pathLength++;
                }
            }
            
            case 304 ->  {
                
                if (!bugPath303.equals(currentBugPosition))
                
                {
                    bugPath304 = currentBugPosition;
                    pathLength++;
                }
            }
            
            case 303 ->  {
                
                if (!bugPath302.equals(currentBugPosition))
                
                {
                    bugPath303 = currentBugPosition;
                    pathLength++;
                }
            }
            
            case 302 ->  {
                
                if (!bugPath301.equals(currentBugPosition))
                
                {
                    bugPath302 = currentBugPosition;
                    pathLength++;
                }
            }
            
            case 301 ->  {
                
                if (!bugPath300.equals(currentBugPosition))
                
                {
                    bugPath301 = currentBugPosition;
                    pathLength++;
                }
            }
            
            case 300 ->  {
                
                if (!bugPath299.equals(currentBugPosition))
                
                {
                    bugPath300 = currentBugPosition;
                    pathLength++;
                }
            }
            
            case 299 ->  {
                
                if (!bugPath298.equals(currentBugPosition))
                
                {
                    bugPath299 = currentBugPosition;
                    pathLength++;
                }
            }
            
            case 298 ->  {
                
                if (!bugPath297.equals(currentBugPosition))
                
                {
                    bugPath298 = currentBugPosition;
                    pathLength++;
                }
            }
            
            case 297 ->  {
                
                if (!bugPath296.equals(currentBugPosition))
                
                {
                    bugPath297 = currentBugPosition;
                    pathLength++;
                }
            }
            
            case 296 ->  {
                
                if (!bugPath295.equals(currentBugPosition))
                
                {
                    bugPath296 = currentBugPosition;
                    pathLength++;
                }
            }
            
            case 295 ->  {
                
                if (!bugPath294.equals(currentBugPosition))
                
                {
                    bugPath295 = currentBugPosition;
                    pathLength++;
                }
            }
            
            case 294 ->  {
                
                if (!bugPath293.equals(currentBugPosition))
                
                {
                    bugPath294 = currentBugPosition;
                    pathLength++;
                }
            }
            
            case 293 ->  {
                
                if (!bugPath292.equals(currentBugPosition))
                
                {
                    bugPath293 = currentBugPosition;
                    pathLength++;
                }
            }
            
            case 292 ->  {
                
                if (!bugPath291.equals(currentBugPosition))
                
                {
                    bugPath292 = currentBugPosition;
                    pathLength++;
                }
            }
            
            case 291 ->  {
                
                if (!bugPath290.equals(currentBugPosition))
                
                {
                    bugPath291 = currentBugPosition;
                    pathLength++;
                }
            }
            
            case 290 ->  {
                
                if (!bugPath289.equals(currentBugPosition))
                
                {
                    bugPath290 = currentBugPosition;
                    pathLength++;
                }
            }
            
            case 289 ->  {
                
                if (!bugPath288.equals(currentBugPosition))
                
                {
                    bugPath289 = currentBugPosition;
                    pathLength++;
                }
            }
            
            case 288 ->  {
                
                if (!bugPath287.equals(currentBugPosition))
                
                {
                    bugPath288 = currentBugPosition;
                    pathLength++;
                }
            }
            
            case 287 ->  {
                
                if (!bugPath286.equals(currentBugPosition))
                
                {
                    bugPath287 = currentBugPosition;
                    pathLength++;
                }
            }
            
            case 286 ->  {
                
                if (!bugPath285.equals(currentBugPosition))
                
                {
                    bugPath286 = currentBugPosition;
                    pathLength++;
                }
            }
            
            case 285 ->  {
                
                if (!bugPath284.equals(currentBugPosition))
                
                {
                    bugPath285 = currentBugPosition;
                    pathLength++;
                }
            }
            
            case 284 ->  {
                
                if (!bugPath283.equals(currentBugPosition))
                
                {
                    bugPath284 = currentBugPosition;
                    pathLength++;
                }
            }
            
            case 283 ->  {
                
                if (!bugPath282.equals(currentBugPosition))
                
                {
                    bugPath283 = currentBugPosition;
                    pathLength++;
                }
            }
            
            case 282 ->  {
                
                if (!bugPath281.equals(currentBugPosition))
                
                {
                    bugPath282 = currentBugPosition;
                    pathLength++;
                }
            }
            
            case 281 ->  {
                
                if (!bugPath280.equals(currentBugPosition))
                
                {
                    bugPath281 = currentBugPosition;
                    pathLength++;
                }
            }
            
            case 280 ->  {
                
                if (!bugPath279.equals(currentBugPosition))
                
                {
                    bugPath280 = currentBugPosition;
                    pathLength++;
                }
            }
            
            case 279 ->  {
                
                if (!bugPath278.equals(currentBugPosition))
                
                {
                    bugPath279 = currentBugPosition;
                    pathLength++;
                }
            }
            
            case 278 ->  {
                
                if (!bugPath277.equals(currentBugPosition))
                
                {
                    bugPath278 = currentBugPosition;
                    pathLength++;
                }
            }
            
            case 277 ->  {
                
                if (!bugPath276.equals(currentBugPosition))
                
                {
                    bugPath277 = currentBugPosition;
                    pathLength++;
                }
            }
            
            case 276 ->  {
                
                if (!bugPath275.equals(currentBugPosition))
                
                {
                    bugPath276 = currentBugPosition;
                    pathLength++;
                }
            }
            
            case 275 ->  {
                
                if (!bugPath274.equals(currentBugPosition))
                
                {
                    bugPath275 = currentBugPosition;
                    pathLength++;
                }
            }
            
            case 274 ->  {
                
                if (!bugPath273.equals(currentBugPosition))
                
                {
                    bugPath274 = currentBugPosition;
                    pathLength++;
                }
            }
            
            case 273 ->  {
                
                if (!bugPath272.equals(currentBugPosition))
                
                {
                    bugPath273 = currentBugPosition;
                    pathLength++;
                }
            }
            
            case 272 ->  {
                
                if (!bugPath271.equals(currentBugPosition))
                
                {
                    bugPath272 = currentBugPosition;
                    pathLength++;
                }
            }
            
            case 271 ->  {
                
                if (!bugPath270.equals(currentBugPosition))
                
                {
                    bugPath271 = currentBugPosition;
                    pathLength++;
                }
            }
            
            case 270 ->  {
                
                if (!bugPath269.equals(currentBugPosition))
                
                {
                    bugPath270 = currentBugPosition;
                    pathLength++;
                }
            }
            
            case 269 ->  {
                
                if (!bugPath268.equals(currentBugPosition))
                
                {
                    bugPath269 = currentBugPosition;
                    pathLength++;
                }
            }
            
            case 268 ->  {
                
                if (!bugPath267.equals(currentBugPosition))
                
                {
                    bugPath268 = currentBugPosition;
                    pathLength++;
                }
            }
            
            case 267 ->  {
                
                if (!bugPath266.equals(currentBugPosition))
                
                {
                    bugPath267 = currentBugPosition;
                    pathLength++;
                }
            }
            
            case 266 ->  {
                
                if (!bugPath265.equals(currentBugPosition))
                
                {
                    bugPath266 = currentBugPosition;
                    pathLength++;
                }
            }
            
            case 265 ->  {
                
                if (!bugPath264.equals(currentBugPosition))
                
                {
                    bugPath265 = currentBugPosition;
                    pathLength++;
                }
            }
            
            case 264 ->  {
                
                if (!bugPath263.equals(currentBugPosition))
                
                {
                    bugPath264 = currentBugPosition;
                    pathLength++;
                }
            }
            
            case 263 ->  {
                
                if (!bugPath262.equals(currentBugPosition))
                
                {
                    bugPath263 = currentBugPosition;
                    pathLength++;
                }
            }
            
            case 262 ->  {
                
                if (!bugPath261.equals(currentBugPosition))
                
                {
                    bugPath262 = currentBugPosition;
                    pathLength++;
                }
            }
            
            case 261 ->  {
                
                if (!bugPath260.equals(currentBugPosition))
                
                {
                    bugPath261 = currentBugPosition;
                    pathLength++;
                }
            }
            
            case 260 ->  {
                
                if (!bugPath259.equals(currentBugPosition))
                
                {
                    bugPath260 = currentBugPosition;
                    pathLength++;
                }
            }
            
            case 259 ->  {
                
                if (!bugPath258.equals(currentBugPosition))
                
                {
                    bugPath259 = currentBugPosition;
                    pathLength++;
                }
            }
            
            case 258 ->  {
                
                if (!bugPath257.equals(currentBugPosition))
                
                {
                    bugPath258 = currentBugPosition;
                    pathLength++;
                }
            }
            
            case 257 ->  {
                
                if (!bugPath256.equals(currentBugPosition))
                
                {
                    bugPath257 = currentBugPosition;
                    pathLength++;
                }
            }
            
            case 256 ->  {
                
                if (!bugPath255.equals(currentBugPosition))
                
                {
                    bugPath256 = currentBugPosition;
                    pathLength++;
                }
            }
            
            case 255 ->  {
                
                if (!bugPath254.equals(currentBugPosition))
                
                {
                    bugPath255 = currentBugPosition;
                    pathLength++;
                }
            }
            
            case 254 ->  {
                
                if (!bugPath253.equals(currentBugPosition))
                
                {
                    bugPath254 = currentBugPosition;
                    pathLength++;
                }
            }
            
            case 253 ->  {
                
                if (!bugPath252.equals(currentBugPosition))
                
                {
                    bugPath253 = currentBugPosition;
                    pathLength++;
                }
            }
            
            case 252 ->  {
                
                if (!bugPath251.equals(currentBugPosition))
                
                {
                    bugPath252 = currentBugPosition;
                    pathLength++;
                }
            }
            
            case 251 ->  {
                
                if (!bugPath250.equals(currentBugPosition))
                
                {
                    bugPath251 = currentBugPosition;
                    pathLength++;
                }
            }
            
            case 250 ->  {
                
                if (!bugPath249.equals(currentBugPosition))
                
                {
                    bugPath250 = currentBugPosition;
                    pathLength++;
                }
            }
            
            case 249 ->  {
                
                if (!bugPath248.equals(currentBugPosition))
                
                {
                    bugPath249 = currentBugPosition;
                    pathLength++;
                }
            }
            
            case 248 ->  {
                
                if (!bugPath247.equals(currentBugPosition))
                
                {
                    bugPath248 = currentBugPosition;
                    pathLength++;
                }
            }
            
            case 247 ->  {
                
                if (!bugPath246.equals(currentBugPosition))
                
                {
                    bugPath247 = currentBugPosition;
                    pathLength++;
                }
            }
            
            case 246 ->  {
                
                if (!bugPath245.equals(currentBugPosition))
                
                {
                    bugPath246 = currentBugPosition;
                    pathLength++;
                }
            }
            
            case 245 ->  {
                
                if (!bugPath244.equals(currentBugPosition))
                
                {
                    bugPath245 = currentBugPosition;
                    pathLength++;
                }
            }
            
            case 244 ->  {
                
                if (!bugPath243.equals(currentBugPosition))
                
                {
                    bugPath244 = currentBugPosition;
                    pathLength++;
                }
            }
            
            case 243 ->  {
                
                if (!bugPath242.equals(currentBugPosition))
                
                {
                    bugPath243 = currentBugPosition;
                    pathLength++;
                }
            }
            
            case 242 ->  {
                
                if (!bugPath241.equals(currentBugPosition))
                
                {
                    bugPath242 = currentBugPosition;
                    pathLength++;
                }
            }
            
            case 241 ->  {
                
                if (!bugPath240.equals(currentBugPosition))
                
                {
                    bugPath241 = currentBugPosition;
                    pathLength++;
                }
            }
            
            case 240 ->  {
                
                if (!bugPath239.equals(currentBugPosition))
                
                {
                    bugPath240 = currentBugPosition;
                    pathLength++;
                }
            }
            
            case 239 ->  {
                
                if (!bugPath238.equals(currentBugPosition))
                
                {
                    bugPath239 = currentBugPosition;
                    pathLength++;
                }
            }
            
            case 238 ->  {
                
                if (!bugPath237.equals(currentBugPosition))
                
                {
                    bugPath238 = currentBugPosition;
                    pathLength++;
                }
            }
            
            case 237 ->  {
                
                if (!bugPath236.equals(currentBugPosition))
                
                {
                    bugPath237 = currentBugPosition;
                    pathLength++;
                }
            }
            
            case 236 ->  {
                
                if (!bugPath235.equals(currentBugPosition))
                
                {
                    bugPath236 = currentBugPosition;
                    pathLength++;
                }
            }
            
            case 235 ->  {
                
                if (!bugPath234.equals(currentBugPosition))
                
                {
                    bugPath235 = currentBugPosition;
                    pathLength++;
                }
            }
            
            case 234 ->  {
                
                if (!bugPath233.equals(currentBugPosition))
                
                {
                    bugPath234 = currentBugPosition;
                    pathLength++;
                }
            }
            
            case 233 ->  {
                
                if (!bugPath232.equals(currentBugPosition))
                
                {
                    bugPath233 = currentBugPosition;
                    pathLength++;
                }
            }
            
            case 232 ->  {
                
                if (!bugPath231.equals(currentBugPosition))
                
                {
                    bugPath232 = currentBugPosition;
                    pathLength++;
                }
            }
            
            case 231 ->  {
                
                if (!bugPath230.equals(currentBugPosition))
                
                {
                    bugPath231 = currentBugPosition;
                    pathLength++;
                }
            }
            
            case 230 ->  {
                
                if (!bugPath229.equals(currentBugPosition))
                
                {
                    bugPath230 = currentBugPosition;
                    pathLength++;
                }
            }
            
            case 229 ->  {
                
                if (!bugPath228.equals(currentBugPosition))
                
                {
                    bugPath229 = currentBugPosition;
                    pathLength++;
                }
            }
            
            case 228 ->  {
                
                if (!bugPath227.equals(currentBugPosition))
                
                {
                    bugPath228 = currentBugPosition;
                    pathLength++;
                }
            }
            
            case 227 ->  {
                
                if (!bugPath226.equals(currentBugPosition))
                
                {
                    bugPath227 = currentBugPosition;
                    pathLength++;
                }
            }
            
            case 226 ->  {
                
                if (!bugPath225.equals(currentBugPosition))
                
                {
                    bugPath226 = currentBugPosition;
                    pathLength++;
                }
            }
            
            case 225 ->  {
                
                if (!bugPath224.equals(currentBugPosition))
                
                {
                    bugPath225 = currentBugPosition;
                    pathLength++;
                }
            }
            
            case 224 ->  {
                
                if (!bugPath223.equals(currentBugPosition))
                
                {
                    bugPath224 = currentBugPosition;
                    pathLength++;
                }
            }
            
            case 223 ->  {
                
                if (!bugPath222.equals(currentBugPosition))
                
                {
                    bugPath223 = currentBugPosition;
                    pathLength++;
                }
            }
            
            case 222 ->  {
                
                if (!bugPath221.equals(currentBugPosition))
                
                {
                    bugPath222 = currentBugPosition;
                    pathLength++;
                }
            }
            
            case 221 ->  {
                
                if (!bugPath220.equals(currentBugPosition))
                
                {
                    bugPath221 = currentBugPosition;
                    pathLength++;
                }
            }
            
            case 220 ->  {
                
                if (!bugPath219.equals(currentBugPosition))
                
                {
                    bugPath220 = currentBugPosition;
                    pathLength++;
                }
            }
            
            case 219 ->  {
                
                if (!bugPath218.equals(currentBugPosition))
                
                {
                    bugPath219 = currentBugPosition;
                    pathLength++;
                }
            }
            
            case 218 ->  {
                
                if (!bugPath217.equals(currentBugPosition))
                
                {
                    bugPath218 = currentBugPosition;
                    pathLength++;
                }
            }
            
            case 217 ->  {
                
                if (!bugPath216.equals(currentBugPosition))
                
                {
                    bugPath217 = currentBugPosition;
                    pathLength++;
                }
            }
            
            case 216 ->  {
                
                if (!bugPath215.equals(currentBugPosition))
                
                {
                    bugPath216 = currentBugPosition;
                    pathLength++;
                }
            }
            
            case 215 ->  {
                
                if (!bugPath214.equals(currentBugPosition))
                
                {
                    bugPath215 = currentBugPosition;
                    pathLength++;
                }
            }
            
            case 214 ->  {
                
                if (!bugPath213.equals(currentBugPosition))
                
                {
                    bugPath214 = currentBugPosition;
                    pathLength++;
                }
            }
            
            case 213 ->  {
                
                if (!bugPath212.equals(currentBugPosition))
                
                {
                    bugPath213 = currentBugPosition;
                    pathLength++;
                }
            }
            
            case 212 ->  {
                
                if (!bugPath211.equals(currentBugPosition))
                
                {
                    bugPath212 = currentBugPosition;
                    pathLength++;
                }
            }
            
            case 211 ->  {
                
                if (!bugPath210.equals(currentBugPosition))
                
                {
                    bugPath211 = currentBugPosition;
                    pathLength++;
                }
            }
            
            case 210 ->  {
                
                if (!bugPath209.equals(currentBugPosition))
                
                {
                    bugPath210 = currentBugPosition;
                    pathLength++;
                }
            }
            
            case 209 ->  {
                
                if (!bugPath208.equals(currentBugPosition))
                
                {
                    bugPath209 = currentBugPosition;
                    pathLength++;
                }
            }
            
            case 208 ->  {
                
                if (!bugPath207.equals(currentBugPosition))
                
                {
                    bugPath208 = currentBugPosition;
                    pathLength++;
                }
            }
            
            case 207 ->  {
                
                if (!bugPath206.equals(currentBugPosition))
                
                {
                    bugPath207 = currentBugPosition;
                    pathLength++;
                }
            }
            
            case 206 ->  {
                
                if (!bugPath205.equals(currentBugPosition))
                
                {
                    bugPath206 = currentBugPosition;
                    pathLength++;
                }
            }
            
            case 205 ->  {
                
                if (!bugPath204.equals(currentBugPosition))
                
                {
                    bugPath205 = currentBugPosition;
                    pathLength++;
                }
            }
            
            case 204 ->  {
                
                if (!bugPath203.equals(currentBugPosition))
                
                {
                    bugPath204 = currentBugPosition;
                    pathLength++;
                }
            }
            
            case 203 ->  {
                
                if (!bugPath202.equals(currentBugPosition))
                
                {
                    bugPath203 = currentBugPosition;
                    pathLength++;
                }
            }
            
            case 202 ->  {
                
                if (!bugPath201.equals(currentBugPosition))
                
                {
                    bugPath202 = currentBugPosition;
                    pathLength++;
                }
            }
            
            case 201 ->  {
                
                if (!bugPath200.equals(currentBugPosition))
                
                {
                    bugPath201 = currentBugPosition;
                    pathLength++;
                }
            }
            
            case 200 ->  {
                
                if (!bugPath199.equals(currentBugPosition))
                
                {
                    bugPath200 = currentBugPosition;
                    pathLength++;
                }
            }
            
            case 199 ->  {
                
                if (!bugPath198.equals(currentBugPosition))
                
                {
                    bugPath199 = currentBugPosition;
                    pathLength++;
                }
            }
            
            case 198 ->  {
                
                if (!bugPath197.equals(currentBugPosition))
                
                {
                    bugPath198 = currentBugPosition;
                    pathLength++;
                }
            }
            
            case 197 ->  {
                
                if (!bugPath196.equals(currentBugPosition))
                
                {
                    bugPath197 = currentBugPosition;
                    pathLength++;
                }
            }
            
            case 196 ->  {
                
                if (!bugPath195.equals(currentBugPosition))
                
                {
                    bugPath196 = currentBugPosition;
                    pathLength++;
                }
            }
            
            case 195 ->  {
                
                if (!bugPath194.equals(currentBugPosition))
                
                {
                    bugPath195 = currentBugPosition;
                    pathLength++;
                }
            }
            
            case 194 ->  {
                
                if (!bugPath193.equals(currentBugPosition))
                
                {
                    bugPath194 = currentBugPosition;
                    pathLength++;
                }
            }
            
            case 193 ->  {
                
                if (!bugPath192.equals(currentBugPosition))
                
                {
                    bugPath193 = currentBugPosition;
                    pathLength++;
                }
            }
            
            case 192 ->  {
                
                if (!bugPath191.equals(currentBugPosition))
                
                {
                    bugPath192 = currentBugPosition;
                    pathLength++;
                }
            }
            
            case 191 ->  {
                
                if (!bugPath190.equals(currentBugPosition))
                
                {
                    bugPath191 = currentBugPosition;
                    pathLength++;
                }
            }
            
            case 190 ->  {
                
                if (!bugPath189.equals(currentBugPosition))
                
                {
                    bugPath190 = currentBugPosition;
                    pathLength++;
                }
            }
            
            case 189 ->  {
                
                if (!bugPath188.equals(currentBugPosition))
                
                {
                    bugPath189 = currentBugPosition;
                    pathLength++;
                }
            }
            
            case 188 ->  {
                
                if (!bugPath187.equals(currentBugPosition))
                
                {
                    bugPath188 = currentBugPosition;
                    pathLength++;
                }
            }
            
            case 187 ->  {
                
                if (!bugPath186.equals(currentBugPosition))
                
                {
                    bugPath187 = currentBugPosition;
                    pathLength++;
                }
            }
            
            case 186 ->  {
                
                if (!bugPath185.equals(currentBugPosition))
                
                {
                    bugPath186 = currentBugPosition;
                    pathLength++;
                }
            }
            
            case 185 ->  {
                
                if (!bugPath184.equals(currentBugPosition))
                
                {
                    bugPath185 = currentBugPosition;
                    pathLength++;
                }
            }
            
            case 184 ->  {
                
                if (!bugPath183.equals(currentBugPosition))
                
                {
                    bugPath184 = currentBugPosition;
                    pathLength++;
                }
            }
            
            case 183 ->  {
                
                if (!bugPath182.equals(currentBugPosition))
                
                {
                    bugPath183 = currentBugPosition;
                    pathLength++;
                }
            }
            
            case 182 ->  {
                
                if (!bugPath181.equals(currentBugPosition))
                
                {
                    bugPath182 = currentBugPosition;
                    pathLength++;
                }
            }
            
            case 181 ->  {
                
                if (!bugPath180.equals(currentBugPosition))
                
                {
                    bugPath181 = currentBugPosition;
                    pathLength++;
                }
            }
            
            case 180 ->  {
                
                if (!bugPath179.equals(currentBugPosition))
                
                {
                    bugPath180 = currentBugPosition;
                    pathLength++;
                }
            }
            
            case 179 ->  {
                
                if (!bugPath178.equals(currentBugPosition))
                
                {
                    bugPath179 = currentBugPosition;
                    pathLength++;
                }
            }
            
            case 178 ->  {
                
                if (!bugPath177.equals(currentBugPosition))
                
                {
                    bugPath178 = currentBugPosition;
                    pathLength++;
                }
            }
            
            case 177 ->  {
                
                if (!bugPath176.equals(currentBugPosition))
                
                {
                    bugPath177 = currentBugPosition;
                    pathLength++;
                }
            }
            
            case 176 ->  {
                
                if (!bugPath175.equals(currentBugPosition))
                
                {
                    bugPath176 = currentBugPosition;
                    pathLength++;
                }
            }
            
            case 175 ->  {
                
                if (!bugPath174.equals(currentBugPosition))
                
                {
                    bugPath175 = currentBugPosition;
                    pathLength++;
                }
            }
            
            case 174 ->  {
                
                if (!bugPath173.equals(currentBugPosition))
                
                {
                    bugPath174 = currentBugPosition;
                    pathLength++;
                }
            }
            
            case 173 ->  {
                
                if (!bugPath172.equals(currentBugPosition))
                
                {
                    bugPath173 = currentBugPosition;
                    pathLength++;
                }
            }
            
            case 172 ->  {
                
                if (!bugPath171.equals(currentBugPosition))
                
                {
                    bugPath172 = currentBugPosition;
                    pathLength++;
                }
            }
            
            case 171 ->  {
                
                if (!bugPath170.equals(currentBugPosition))
                
                {
                    bugPath171 = currentBugPosition;
                    pathLength++;
                }
            }
            
            case 170 ->  {
                
                if (!bugPath169.equals(currentBugPosition))
                
                {
                    bugPath170 = currentBugPosition;
                    pathLength++;
                }
            }
            
            case 169 ->  {
                
                if (!bugPath168.equals(currentBugPosition))
                
                {
                    bugPath169 = currentBugPosition;
                    pathLength++;
                }
            }
            
            case 168 ->  {
                
                if (!bugPath167.equals(currentBugPosition))
                
                {
                    bugPath168 = currentBugPosition;
                    pathLength++;
                }
            }
            
            case 167 ->  {
                
                if (!bugPath166.equals(currentBugPosition))
                
                {
                    bugPath167 = currentBugPosition;
                    pathLength++;
                }
            }
            
            case 166 ->  {
                
                if (!bugPath165.equals(currentBugPosition))
                
                {
                    bugPath166 = currentBugPosition;
                    pathLength++;
                }
            }
            
            case 165 ->  {
                
                if (!bugPath164.equals(currentBugPosition))
                
                {
                    bugPath165 = currentBugPosition;
                    pathLength++;
                }
            }
            
            case 164 ->  {
                
                if (!bugPath163.equals(currentBugPosition))
                
                {
                    bugPath164 = currentBugPosition;
                    pathLength++;
                }
            }
            
            case 163 ->  {
                
                if (!bugPath162.equals(currentBugPosition))
                
                {
                    bugPath163 = currentBugPosition;
                    pathLength++;
                }
            }
            
            case 162 ->  {
                
                if (!bugPath161.equals(currentBugPosition))
                
                {
                    bugPath162 = currentBugPosition;
                    pathLength++;
                }
            }
            
            case 161 ->  {
                
                if (!bugPath160.equals(currentBugPosition))
                
                {
                    bugPath161 = currentBugPosition;
                    pathLength++;
                }
            }
            
            case 160 ->  {
                
                if (!bugPath159.equals(currentBugPosition))
                
                {
                    bugPath160 = currentBugPosition;
                    pathLength++;
                }
            }
            
            case 159 ->  {
                
                if (!bugPath158.equals(currentBugPosition))
                
                {
                    bugPath159 = currentBugPosition;
                    pathLength++;
                }
            }
            
            case 158 ->  {
                
                if (!bugPath157.equals(currentBugPosition))
                
                {
                    bugPath158 = currentBugPosition;
                    pathLength++;
                }
            }
            
            case 157 ->  {
                
                if (!bugPath156.equals(currentBugPosition))
                
                {
                    bugPath157 = currentBugPosition;
                    pathLength++;
                }
            }
            
            case 156 ->  {
                
                if (!bugPath155.equals(currentBugPosition))
                
                {
                    bugPath156 = currentBugPosition;
                    pathLength++;
                }
            }
            
            case 155 ->  {
                
                if (!bugPath154.equals(currentBugPosition))
                
                {
                    bugPath155 = currentBugPosition;
                    pathLength++;
                }
            }
            
            case 154 ->  {
                
                if (!bugPath153.equals(currentBugPosition))
                
                {
                    bugPath154 = currentBugPosition;
                    pathLength++;
                }
            }
            
            case 153 ->  {
                
                if (!bugPath152.equals(currentBugPosition))
                
                {
                    bugPath153 = currentBugPosition;
                    pathLength++;
                }
            }
            
            case 152 ->  {
                
                if (!bugPath151.equals(currentBugPosition))
                
                {
                    bugPath152 = currentBugPosition;
                    pathLength++;
                }
            }
            
            case 151 ->  {
                
                if (!bugPath150.equals(currentBugPosition))
                
                {
                    bugPath151 = currentBugPosition;
                    pathLength++;
                }
            }
            
            case 150 ->  {
                
                if (!bugPath149.equals(currentBugPosition))
                
                {
                    bugPath150 = currentBugPosition;
                    pathLength++;
                }
            }
            
            case 149 ->  {
                
                if (!bugPath148.equals(currentBugPosition))
                
                {
                    bugPath149 = currentBugPosition;
                    pathLength++;
                }
            }
            
            case 148 ->  {
                
                if (!bugPath147.equals(currentBugPosition))
                
                {
                    bugPath148 = currentBugPosition;
                    pathLength++;
                }
            }
            
            case 147 ->  {
                
                if (!bugPath146.equals(currentBugPosition))
                
                {
                    bugPath147 = currentBugPosition;
                    pathLength++;
                }
            }
            
            case 146 ->  {
                
                if (!bugPath145.equals(currentBugPosition))
                
                {
                    bugPath146 = currentBugPosition;
                    pathLength++;
                }
            }
            
            case 145 ->  {
                
                if (!bugPath144.equals(currentBugPosition))
                
                {
                    bugPath145 = currentBugPosition;
                    pathLength++;
                }
            }
            
            case 144 ->  {
                
                if (!bugPath143.equals(currentBugPosition))
                
                {
                    bugPath144 = currentBugPosition;
                    pathLength++;
                }
            }
            
            case 143 ->  {
                
                if (!bugPath142.equals(currentBugPosition))
                
                {
                    bugPath143 = currentBugPosition;
                    pathLength++;
                }
            }
            
            case 142 ->  {
                
                if (!bugPath141.equals(currentBugPosition))
                
                {
                    bugPath142 = currentBugPosition;
                    pathLength++;
                }
            }
            
            case 141 ->  {
                
                if (!bugPath140.equals(currentBugPosition))
                
                {
                    bugPath141 = currentBugPosition;
                    pathLength++;
                }
            }
            
            case 140 ->  {
                
                if (!bugPath139.equals(currentBugPosition))
                
                {
                    bugPath140 = currentBugPosition;
                    pathLength++;
                }
            }
            
            case 139 ->  {
                
                if (!bugPath138.equals(currentBugPosition))
                
                {
                    bugPath139 = currentBugPosition;
                    pathLength++;
                }
            }
            
            case 138 ->  {
                
                if (!bugPath137.equals(currentBugPosition))
                
                {
                    bugPath138 = currentBugPosition;
                    pathLength++;
                }
            }
            
            case 137 ->  {
                
                if (!bugPath136.equals(currentBugPosition))
                
                {
                    bugPath137 = currentBugPosition;
                    pathLength++;
                }
            }
            
            case 136 ->  {
                
                if (!bugPath135.equals(currentBugPosition))
                
                {
                    bugPath136 = currentBugPosition;
                    pathLength++;
                }
            }
            
            case 135 ->  {
                
                if (!bugPath134.equals(currentBugPosition))
                
                {
                    bugPath135 = currentBugPosition;
                    pathLength++;
                }
            }
            
            case 134 ->  {
                
                if (!bugPath133.equals(currentBugPosition))
                
                {
                    bugPath134 = currentBugPosition;
                    pathLength++;
                }
            }
            
            case 133 ->  {
                
                if (!bugPath132.equals(currentBugPosition))
                
                {
                    bugPath133 = currentBugPosition;
                    pathLength++;
                }
            }
            
            case 132 ->  {
                
                if (!bugPath131.equals(currentBugPosition))
                
                {
                    bugPath132 = currentBugPosition;
                    pathLength++;
                }
            }
            
            case 131 ->  {
                
                if (!bugPath130.equals(currentBugPosition))
                
                {
                    bugPath131 = currentBugPosition;
                    pathLength++;
                }
            }
            
            case 130 ->  {
                
                if (!bugPath129.equals(currentBugPosition))
                
                {
                    bugPath130 = currentBugPosition;
                    pathLength++;
                }
            }
            
            case 129 ->  {
                
                if (!bugPath128.equals(currentBugPosition))
                
                {
                    bugPath129 = currentBugPosition;
                    pathLength++;
                }
            }
            
            case 128 ->  {
                
                if (!bugPath127.equals(currentBugPosition))
                
                {
                    bugPath128 = currentBugPosition;
                    pathLength++;
                }
            }
            
            case 127 ->  {
                
                if (!bugPath126.equals(currentBugPosition))
                
                {
                    bugPath127 = currentBugPosition;
                    pathLength++;
                }
            }
            
            case 126 ->  {
                
                if (!bugPath125.equals(currentBugPosition))
                
                {
                    bugPath126 = currentBugPosition;
                    pathLength++;
                }
            }
            
            case 125 ->  {
                
                if (!bugPath124.equals(currentBugPosition))
                
                {
                    bugPath125 = currentBugPosition;
                    pathLength++;
                }
            }
            
            case 124 ->  {
                
                if (!bugPath123.equals(currentBugPosition))
                
                {
                    bugPath124 = currentBugPosition;
                    pathLength++;
                }
            }
            
            case 123 ->  {
                
                if (!bugPath122.equals(currentBugPosition))
                
                {
                    bugPath123 = currentBugPosition;
                    pathLength++;
                }
            }
            
            case 122 ->  {
                
                if (!bugPath121.equals(currentBugPosition))
                
                {
                    bugPath122 = currentBugPosition;
                    pathLength++;
                }
            }
            
            case 121 ->  {
                
                if (!bugPath120.equals(currentBugPosition))
                
                {
                    bugPath121 = currentBugPosition;
                    pathLength++;
                }
            }
            
            case 120 ->  {
                
                if (!bugPath119.equals(currentBugPosition))
                
                {
                    bugPath120 = currentBugPosition;
                    pathLength++;
                }
            }
            
            case 119 ->  {
                
                if (!bugPath118.equals(currentBugPosition))
                
                {
                    bugPath119 = currentBugPosition;
                    pathLength++;
                }
            }
            
            case 118 ->  {
                
                if (!bugPath117.equals(currentBugPosition))
                
                {
                    bugPath118 = currentBugPosition;
                    pathLength++;
                }
            }
            
            case 117 ->  {
                
                if (!bugPath116.equals(currentBugPosition))
                
                {
                    bugPath117 = currentBugPosition;
                    pathLength++;
                }
            }
            
            case 116 ->  {
                
                if (!bugPath115.equals(currentBugPosition))
                
                {
                    bugPath116 = currentBugPosition;
                    pathLength++;
                }
            }
            
            case 115 ->  {
                
                if (!bugPath114.equals(currentBugPosition))
                
                {
                    bugPath115 = currentBugPosition;
                    pathLength++;
                }
            }
            
            case 114 ->  {
                
                if (!bugPath113.equals(currentBugPosition))
                
                {
                    bugPath114 = currentBugPosition;
                    pathLength++;
                }
            }
            
            case 113 ->  {
                
                if (!bugPath112.equals(currentBugPosition))
                
                {
                    bugPath113 = currentBugPosition;
                    pathLength++;
                }
            }
            
            case 112 ->  {
                
                if (!bugPath111.equals(currentBugPosition))
                
                {
                    bugPath112 = currentBugPosition;
                    pathLength++;
                }
            }
            
            case 111 ->  {
                
                if (!bugPath110.equals(currentBugPosition))
                
                {
                    bugPath111 = currentBugPosition;
                    pathLength++;
                }
            }
            
            case 110 ->  {
                
                if (!bugPath109.equals(currentBugPosition))
                
                {
                    bugPath110 = currentBugPosition;
                    pathLength++;
                }
            }
            
            case 109 ->  {
                
                if (!bugPath108.equals(currentBugPosition))
                
                {
                    bugPath109 = currentBugPosition;
                    pathLength++;
                }
            }
            
            case 108 ->  {
                
                if (!bugPath107.equals(currentBugPosition))
                
                {
                    bugPath108 = currentBugPosition;
                    pathLength++;
                }
            }
            
            case 107 ->  {
                
                if (!bugPath106.equals(currentBugPosition))
                
                {
                    bugPath107 = currentBugPosition;
                    pathLength++;
                }
            }
            
            case 106 ->  {
                
                if (!bugPath105.equals(currentBugPosition))
                
                {
                    bugPath106 = currentBugPosition;
                    pathLength++;
                }
            }
            
            case 105 ->  {
                
                if (!bugPath104.equals(currentBugPosition))
                
                {
                    bugPath105 = currentBugPosition;
                    pathLength++;
                }
            }
            
            case 104 ->  {
                
                if (!bugPath103.equals(currentBugPosition))
                
                {
                    bugPath104 = currentBugPosition;
                    pathLength++;
                }
            }
            
            case 103 ->  {
                
                if (!bugPath102.equals(currentBugPosition))
                
                {
                    bugPath103 = currentBugPosition;
                    pathLength++;
                }
            }
            
            case 102 ->  {
                
                if (!bugPath101.equals(currentBugPosition))
                
                {
                    bugPath102 = currentBugPosition;
                    pathLength++;
                }
            }
            
            case 101 ->  {
                
                if (!bugPath100.equals(currentBugPosition))
                
                {
                    bugPath101 = currentBugPosition;
                    pathLength++;
                }
            }
            
            case 100 ->  {
                
                if (!bugPath99.equals(currentBugPosition))
                
                {
                    bugPath100 = currentBugPosition;
                    pathLength++;
                }
            }
            
            case 99 ->  {
                
                if (!bugPath98.equals(currentBugPosition))
                
                {
                    bugPath99 = currentBugPosition;
                    pathLength++;
                }
            }
            
            case 98 ->  {
                
                if (!bugPath97.equals(currentBugPosition))
                
                {
                    bugPath98 = currentBugPosition;
                    pathLength++;
                }
            }
            
            case 97 ->  {
                
                if (!bugPath96.equals(currentBugPosition))
                
                {
                    bugPath97 = currentBugPosition;
                    pathLength++;
                }
            }
            
            case 96 ->  {
                
                if (!bugPath95.equals(currentBugPosition))
                
                {
                    bugPath96 = currentBugPosition;
                    pathLength++;
                }
            }
            
            case 95 ->  {
                
                if (!bugPath94.equals(currentBugPosition))
                
                {
                    bugPath95 = currentBugPosition;
                    pathLength++;
                }
            }
            
            case 94 ->  {
                
                if (!bugPath93.equals(currentBugPosition))
                
                {
                    bugPath94 = currentBugPosition;
                    pathLength++;
                }
            }
            
            case 93 ->  {
                
                if (!bugPath92.equals(currentBugPosition))
                
                {
                    bugPath93 = currentBugPosition;
                    pathLength++;
                }
            }
            
            case 92 ->  {
                
                if (!bugPath91.equals(currentBugPosition))
                
                {
                    bugPath92 = currentBugPosition;
                    pathLength++;
                }
            }
            
            case 91 ->  {
                
                if (!bugPath90.equals(currentBugPosition))
                
                {
                    bugPath91 = currentBugPosition;
                    pathLength++;
                }
            }
            
            case 90 ->  {
                
                if (!bugPath89.equals(currentBugPosition))
                
                {
                    bugPath90 = currentBugPosition;
                    pathLength++;
                }
            }
            
            case 89 ->  {
                
                if (!bugPath88.equals(currentBugPosition))
                
                {
                    bugPath89 = currentBugPosition;
                    pathLength++;
                }
            }
            
            case 88 ->  {
                
                if (!bugPath87.equals(currentBugPosition))
                
                {
                    bugPath88 = currentBugPosition;
                    pathLength++;
                }
            }
            
            case 87 ->  {
                
                if (!bugPath86.equals(currentBugPosition))
                
                {
                    bugPath87 = currentBugPosition;
                    pathLength++;
                }
            }
            
            case 86 ->  {
                
                if (!bugPath85.equals(currentBugPosition))
                
                {
                    bugPath86 = currentBugPosition;
                    pathLength++;
                }
            }
            
            case 85 ->  {
                
                if (!bugPath84.equals(currentBugPosition))
                
                {
                    bugPath85 = currentBugPosition;
                    pathLength++;
                }
            }
            
            case 84 ->  {
                
                if (!bugPath83.equals(currentBugPosition))
                
                {
                    bugPath84 = currentBugPosition;
                    pathLength++;
                }
            }
            
            case 83 ->  {
                
                if (!bugPath82.equals(currentBugPosition))
                
                {
                    bugPath83 = currentBugPosition;
                    pathLength++;
                }
            }
            
            case 82 ->  {
                
                if (!bugPath81.equals(currentBugPosition))
                
                {
                    bugPath82 = currentBugPosition;
                    pathLength++;
                }
            }
            
            case 81 ->  {
                
                if (!bugPath80.equals(currentBugPosition))
                
                {
                    bugPath81 = currentBugPosition;
                    pathLength++;
                }
            }
            
            case 80 ->  {
                
                if (!bugPath79.equals(currentBugPosition))
                
                {
                    bugPath80 = currentBugPosition;
                    pathLength++;
                }
            }
            
            case 79 ->  {
                
                if (!bugPath78.equals(currentBugPosition))
                
                {
                    bugPath79 = currentBugPosition;
                    pathLength++;
                }
            }
            
            case 78 ->  {
                
                if (!bugPath77.equals(currentBugPosition))
                
                {
                    bugPath78 = currentBugPosition;
                    pathLength++;
                }
            }
            
            case 77 ->  {
                
                if (!bugPath76.equals(currentBugPosition))
                
                {
                    bugPath77 = currentBugPosition;
                    pathLength++;
                }
            }
            
            case 76 ->  {
                
                if (!bugPath75.equals(currentBugPosition))
                
                {
                    bugPath76 = currentBugPosition;
                    pathLength++;
                }
            }
            
            case 75 ->  {
                
                if (!bugPath74.equals(currentBugPosition))
                
                {
                    bugPath75 = currentBugPosition;
                    pathLength++;
                }
            }
            
            case 74 ->  {
                
                if (!bugPath73.equals(currentBugPosition))
                
                {
                    bugPath74 = currentBugPosition;
                    pathLength++;
                }
            }
            
            case 73 ->  {
                
                if (!bugPath72.equals(currentBugPosition))
                
                {
                    bugPath73 = currentBugPosition;
                    pathLength++;
                }
            }
            
            case 72 ->  {
                
                if (!bugPath71.equals(currentBugPosition))
                
                {
                    bugPath72 = currentBugPosition;
                    pathLength++;
                }
            }
            
            case 71 ->  {
                
                if (!bugPath70.equals(currentBugPosition))
                
                {
                    bugPath71 = currentBugPosition;
                    pathLength++;
                }
            }
            
            case 70 ->  {
                
                if (!bugPath69.equals(currentBugPosition))
                
                {
                    bugPath70 = currentBugPosition;
                    pathLength++;
                }
            }
            
            case 69 ->  {
                
                if (!bugPath68.equals(currentBugPosition))
                
                {
                    bugPath69 = currentBugPosition;
                    pathLength++;
                }
            }
            
            case 68 ->  {
                
                if (!bugPath67.equals(currentBugPosition))
                
                {
                    bugPath68 = currentBugPosition;
                    pathLength++;
                }
            }
            
            case 67 ->  {
                
                if (!bugPath66.equals(currentBugPosition))
                
                {
                    bugPath67 = currentBugPosition;
                    pathLength++;
                }
            }
            
            case 66 ->  {
                
                if (!bugPath65.equals(currentBugPosition))
                
                {
                    bugPath66 = currentBugPosition;
                    pathLength++;
                }
            }
            
            case 65 ->  {
                
                if (!bugPath64.equals(currentBugPosition))
                
                {
                    bugPath65 = currentBugPosition;
                    pathLength++;
                }
            }
            
            case 64 ->  {
                
                if (!bugPath63.equals(currentBugPosition))
                
                {
                    bugPath64 = currentBugPosition;
                    pathLength++;
                }
            }
            
            case 63 ->  {
                
                if (!bugPath62.equals(currentBugPosition))
                
                {
                    bugPath63 = currentBugPosition;
                    pathLength++;
                }
            }
            
            case 62 ->  {
                
                if (!bugPath61.equals(currentBugPosition))
                
                {
                    bugPath62 = currentBugPosition;
                    pathLength++;
                }
            }
            
            case 61 ->  {
                
                if (!bugPath60.equals(currentBugPosition))
                
                {
                    bugPath61 = currentBugPosition;
                    pathLength++;
                }
            }
            
            case 60 ->  {
                
                if (!bugPath59.equals(currentBugPosition))
                
                {
                    bugPath60 = currentBugPosition;
                    pathLength++;
                }
            }
            
            case 59 ->  {
                
                if (!bugPath58.equals(currentBugPosition))
                
                {
                    bugPath59 = currentBugPosition;
                    pathLength++;
                }
            }
            
            case 58 ->  {
                
                if (!bugPath57.equals(currentBugPosition))
                
                {
                    bugPath58 = currentBugPosition;
                    pathLength++;
                }
            }
            
            case 57 ->  {
                
                if (!bugPath56.equals(currentBugPosition))
                
                {
                    bugPath57 = currentBugPosition;
                    pathLength++;
                }
            }
            
            case 56 ->  {
                
                if (!bugPath55.equals(currentBugPosition))
                
                {
                    bugPath56 = currentBugPosition;
                    pathLength++;
                }
            }
            
            case 55 ->  {
                
                if (!bugPath54.equals(currentBugPosition))
                
                {
                    bugPath55 = currentBugPosition;
                    pathLength++;
                }
            }
            
            case 54 ->  {
                
                if (!bugPath53.equals(currentBugPosition))
                
                {
                    bugPath54 = currentBugPosition;
                    pathLength++;
                }
            }
            
            case 53 ->  {
                
                if (!bugPath52.equals(currentBugPosition))
                
                {
                    bugPath53 = currentBugPosition;
                    pathLength++;
                }
            }
            
            case 52 ->  {
                
                if (!bugPath51.equals(currentBugPosition))
                
                {
                    bugPath52 = currentBugPosition;
                    pathLength++;
                }
            }
            
            case 51 ->  {
                
                if (!bugPath50.equals(currentBugPosition))
                
                {
                    bugPath51 = currentBugPosition;
                    pathLength++;
                }
            }
            
            case 50 ->  {
                
                if (!bugPath49.equals(currentBugPosition))
                
                {
                    bugPath50 = currentBugPosition;
                    pathLength++;
                }
            }
            
            case 49 ->  {
                
                if (!bugPath48.equals(currentBugPosition))
                
                {
                    bugPath49 = currentBugPosition;
                    pathLength++;
                }
            }
            
            case 48 ->  {
                
                if (!bugPath47.equals(currentBugPosition))
                
                {
                    bugPath48 = currentBugPosition;
                    pathLength++;
                }
            }
            
            case 47 ->  {
                
                if (!bugPath46.equals(currentBugPosition))
                
                {
                    bugPath47 = currentBugPosition;
                    pathLength++;
                }
            }
            
            case 46 ->  {
                
                if (!bugPath45.equals(currentBugPosition))
                
                {
                    bugPath46 = currentBugPosition;
                    pathLength++;
                }
            }
            
            case 45 ->  {
                
                if (!bugPath44.equals(currentBugPosition))
                
                {
                    bugPath45 = currentBugPosition;
                    pathLength++;
                }
            }
            
            case 44 ->  {
                
                if (!bugPath43.equals(currentBugPosition))
                
                {
                    bugPath44 = currentBugPosition;
                    pathLength++;
                }
            }
            
            case 43 ->  {
                
                if (!bugPath42.equals(currentBugPosition))
                
                {
                    bugPath43 = currentBugPosition;
                    pathLength++;
                }
            }
            
            case 42 ->  {
                
                if (!bugPath41.equals(currentBugPosition))
                
                {
                    bugPath42 = currentBugPosition;
                    pathLength++;
                }
            }
            
            case 41 ->  {
                
                if (!bugPath40.equals(currentBugPosition))
                
                {
                    bugPath41 = currentBugPosition;
                    pathLength++;
                }
            }
            
            case 40 ->  {
                
                if (!bugPath39.equals(currentBugPosition))
                
                {
                    bugPath40 = currentBugPosition;
                    pathLength++;
                }
            }
            
            case 39 ->  {
                
                if (!bugPath38.equals(currentBugPosition))
                
                {
                    bugPath39 = currentBugPosition;
                    pathLength++;
                }
            }
            
            case 38 ->  {
                
                if (!bugPath37.equals(currentBugPosition))
                
                {
                    bugPath38 = currentBugPosition;
                    pathLength++;
                }
            }
            
            case 37 ->  {
                
                if (!bugPath36.equals(currentBugPosition))
                
                {
                    bugPath37 = currentBugPosition;
                    pathLength++;
                }
            }
            
            case 36 ->  {
                
                if (!bugPath35.equals(currentBugPosition))
                
                {
                    bugPath36 = currentBugPosition;
                    pathLength++;
                }
            }
            
            case 35 ->  {
                
                if (!bugPath34.equals(currentBugPosition))
                
                {
                    bugPath35 = currentBugPosition;
                    pathLength++;
                }
            }
            
            case 34 ->  {
                
                if (!bugPath33.equals(currentBugPosition))
                
                {
                    bugPath34 = currentBugPosition;
                    pathLength++;
                }
            }
            
            case 33 ->  {
                
                if (!bugPath32.equals(currentBugPosition))
                
                {
                    bugPath33 = currentBugPosition;
                    pathLength++;
                }
            }
            
            case 32 ->  {
                
                if (!bugPath31.equals(currentBugPosition))
                
                {
                    bugPath32 = currentBugPosition;
                    pathLength++;
                }
            }
            
            case 31 ->  {
                
                if (!bugPath30.equals(currentBugPosition))
                
                {
                    bugPath31 = currentBugPosition;
                    pathLength++;
                }
            }
            
            case 30 ->  {
                
                if (!bugPath29.equals(currentBugPosition))
                
                {
                    bugPath30 = currentBugPosition;
                    pathLength++;
                }
            }
            
            case 29 ->  {
                
                if (!bugPath28.equals(currentBugPosition))
                
                {
                    bugPath29 = currentBugPosition;
                    pathLength++;
                }
            }
            
            case 28 ->  {
                
                if (!bugPath27.equals(currentBugPosition))
                
                {
                    bugPath28 = currentBugPosition;
                    pathLength++;
                }
            }
            
            case 27 ->  {
                
                if (!bugPath26.equals(currentBugPosition))
                
                {
                    bugPath27 = currentBugPosition;
                    pathLength++;
                }
            }
            
            case 26 ->  {
                
                if (!bugPath25.equals(currentBugPosition))
                
                {
                    bugPath26 = currentBugPosition;
                    pathLength++;
                }
            }
            
            case 25 ->  {
                
                if (!bugPath24.equals(currentBugPosition))
                
                {
                    bugPath25 = currentBugPosition;
                    pathLength++;
                }
            }
            
            case 24 ->  {
                
                if (!bugPath23.equals(currentBugPosition))
                
                {
                    bugPath24 = currentBugPosition;
                    pathLength++;
                }
            }
            
            case 23 ->  {
                
                if (!bugPath22.equals(currentBugPosition))
                
                {
                    bugPath23 = currentBugPosition;
                    pathLength++;
                }
            }
            
            case 22 ->  {
                
                if (!bugPath21.equals(currentBugPosition))
                
                {
                    bugPath22 = currentBugPosition;
                    pathLength++;
                }
            }
            
            case 21 ->  {
                
                if (!bugPath20.equals(currentBugPosition))
                
                {
                    bugPath21 = currentBugPosition;
                    pathLength++;
                }
            }
            
            case 20 ->  {
                
                if (!bugPath19.equals(currentBugPosition))
                
                {
                    bugPath20 = currentBugPosition;
                    pathLength++;
                }
            }
            
            case 19 ->  {
                
                if (!bugPath18.equals(currentBugPosition))
                
                {
                    bugPath19 = currentBugPosition;
                    pathLength++;
                }
            }
            
            case 18 ->  {
                
                if (!bugPath17.equals(currentBugPosition))
                
                {
                    bugPath18 = currentBugPosition;
                    pathLength++;
                }
            }
            
            case 17 ->  {
                
                if (!bugPath16.equals(currentBugPosition))
                
                {
                    bugPath17 = currentBugPosition;
                    pathLength++;
                }
            }
            
            case 16 ->  {
                
                if (!bugPath15.equals(currentBugPosition))
                
                {
                    bugPath16 = currentBugPosition;
                    pathLength++;
                }
            }
            
            case 15 ->  {
                
                if (!bugPath14.equals(currentBugPosition))
                
                {
                    bugPath15 = currentBugPosition;
                    pathLength++;
                }
            }
            
            case 14 ->  {
                
                if (!bugPath13.equals(currentBugPosition))
                
                {
                    bugPath14 = currentBugPosition;
                    pathLength++;
                }
            }
            
            case 13 ->  {
                
                if (!bugPath12.equals(currentBugPosition))
                
                {
                    bugPath13 = currentBugPosition;
                    pathLength++;
                }
            }
            
            case 12 ->  {
                
                if (!bugPath11.equals(currentBugPosition))
                
                {
                    bugPath12 = currentBugPosition;
                    pathLength++;
                }
            }
            
            case 11 ->  {
                
                if (!bugPath10.equals(currentBugPosition))
                
                {
                    bugPath11 = currentBugPosition;
                    pathLength++;
                }
            }
            
            case 10 ->  {
                
                if (!bugPath9.equals(currentBugPosition))
                
                {
                    bugPath10 = currentBugPosition;
                    pathLength++;
                }
            }
            
            case 9 ->  {
                
                if (!bugPath8.equals(currentBugPosition))
                
                {
                    bugPath9 = currentBugPosition;
                    pathLength++;
                }
            }
            
            case 8 ->  {
                
                if (!bugPath7.equals(currentBugPosition))
                
                {
                    bugPath8 = currentBugPosition;
                    pathLength++;
                }
            }
            
            case 7 ->  {
                
                if (!bugPath6.equals(currentBugPosition))
                
                {
                    bugPath7 = currentBugPosition;
                    pathLength++;
                }
            }
            
            case 6 ->  {
                
                if (!bugPath5.equals(currentBugPosition))
                
                {
                    bugPath6 = currentBugPosition;
                    pathLength++;
                }
            }
            
            case 5 ->  {
                
                if (!bugPath4.equals(currentBugPosition))
                
                {
                    bugPath5 = currentBugPosition;
                    pathLength++;
                }
            }
            
            case 4 ->  {
                
                if (!bugPath3.equals(currentBugPosition))
                
                {
                    bugPath4 = currentBugPosition;
                    pathLength++;
                }
            }
            
            case 3 ->  {
                
                if (!bugPath2.equals(currentBugPosition))
                
                {
                    bugPath3 = currentBugPosition;
                    pathLength++;
                }
            }
            
            case 2 ->  {
                
                if (!bugPath1.equals(currentBugPosition))
                
                {
                    bugPath2 = currentBugPosition;
                    pathLength++;
                }
            }
            
            case 1 ->  {
                
                if (!bugPath0.equals(currentBugPosition))
                
                {
                    bugPath1 = currentBugPosition;
                    pathLength++;
                }
            }
            
            case 0 ->  {
                
                {
                    bugPath0 = currentBugPosition;
                    pathLength++;
                }
            }
            
            default -> { assert(pathLength <= 500); }
        }
    }

    public static void setCurrentPosition() {
        currentBugPosition = null;
        findCurrentBugPosition: {
            switch (pathLength - 1) {
                
                case 499: {
                    if (bugPath499.distanceSquaredTo(myloc) <= GameConstants.VISION_RADIUS_SQUARED) {
                        currentBugPosition = bugPath499;
                        break findCurrentBugPosition;
                    }
                }
                
                case 498: {
                    if (bugPath498.distanceSquaredTo(myloc) <= GameConstants.VISION_RADIUS_SQUARED) {
                        currentBugPosition = bugPath498;
                        break findCurrentBugPosition;
                    }
                }
                
                case 497: {
                    if (bugPath497.distanceSquaredTo(myloc) <= GameConstants.VISION_RADIUS_SQUARED) {
                        currentBugPosition = bugPath497;
                        break findCurrentBugPosition;
                    }
                }
                
                case 496: {
                    if (bugPath496.distanceSquaredTo(myloc) <= GameConstants.VISION_RADIUS_SQUARED) {
                        currentBugPosition = bugPath496;
                        break findCurrentBugPosition;
                    }
                }
                
                case 495: {
                    if (bugPath495.distanceSquaredTo(myloc) <= GameConstants.VISION_RADIUS_SQUARED) {
                        currentBugPosition = bugPath495;
                        break findCurrentBugPosition;
                    }
                }
                
                case 494: {
                    if (bugPath494.distanceSquaredTo(myloc) <= GameConstants.VISION_RADIUS_SQUARED) {
                        currentBugPosition = bugPath494;
                        break findCurrentBugPosition;
                    }
                }
                
                case 493: {
                    if (bugPath493.distanceSquaredTo(myloc) <= GameConstants.VISION_RADIUS_SQUARED) {
                        currentBugPosition = bugPath493;
                        break findCurrentBugPosition;
                    }
                }
                
                case 492: {
                    if (bugPath492.distanceSquaredTo(myloc) <= GameConstants.VISION_RADIUS_SQUARED) {
                        currentBugPosition = bugPath492;
                        break findCurrentBugPosition;
                    }
                }
                
                case 491: {
                    if (bugPath491.distanceSquaredTo(myloc) <= GameConstants.VISION_RADIUS_SQUARED) {
                        currentBugPosition = bugPath491;
                        break findCurrentBugPosition;
                    }
                }
                
                case 490: {
                    if (bugPath490.distanceSquaredTo(myloc) <= GameConstants.VISION_RADIUS_SQUARED) {
                        currentBugPosition = bugPath490;
                        break findCurrentBugPosition;
                    }
                }
                
                case 489: {
                    if (bugPath489.distanceSquaredTo(myloc) <= GameConstants.VISION_RADIUS_SQUARED) {
                        currentBugPosition = bugPath489;
                        break findCurrentBugPosition;
                    }
                }
                
                case 488: {
                    if (bugPath488.distanceSquaredTo(myloc) <= GameConstants.VISION_RADIUS_SQUARED) {
                        currentBugPosition = bugPath488;
                        break findCurrentBugPosition;
                    }
                }
                
                case 487: {
                    if (bugPath487.distanceSquaredTo(myloc) <= GameConstants.VISION_RADIUS_SQUARED) {
                        currentBugPosition = bugPath487;
                        break findCurrentBugPosition;
                    }
                }
                
                case 486: {
                    if (bugPath486.distanceSquaredTo(myloc) <= GameConstants.VISION_RADIUS_SQUARED) {
                        currentBugPosition = bugPath486;
                        break findCurrentBugPosition;
                    }
                }
                
                case 485: {
                    if (bugPath485.distanceSquaredTo(myloc) <= GameConstants.VISION_RADIUS_SQUARED) {
                        currentBugPosition = bugPath485;
                        break findCurrentBugPosition;
                    }
                }
                
                case 484: {
                    if (bugPath484.distanceSquaredTo(myloc) <= GameConstants.VISION_RADIUS_SQUARED) {
                        currentBugPosition = bugPath484;
                        break findCurrentBugPosition;
                    }
                }
                
                case 483: {
                    if (bugPath483.distanceSquaredTo(myloc) <= GameConstants.VISION_RADIUS_SQUARED) {
                        currentBugPosition = bugPath483;
                        break findCurrentBugPosition;
                    }
                }
                
                case 482: {
                    if (bugPath482.distanceSquaredTo(myloc) <= GameConstants.VISION_RADIUS_SQUARED) {
                        currentBugPosition = bugPath482;
                        break findCurrentBugPosition;
                    }
                }
                
                case 481: {
                    if (bugPath481.distanceSquaredTo(myloc) <= GameConstants.VISION_RADIUS_SQUARED) {
                        currentBugPosition = bugPath481;
                        break findCurrentBugPosition;
                    }
                }
                
                case 480: {
                    if (bugPath480.distanceSquaredTo(myloc) <= GameConstants.VISION_RADIUS_SQUARED) {
                        currentBugPosition = bugPath480;
                        break findCurrentBugPosition;
                    }
                }
                
                case 479: {
                    if (bugPath479.distanceSquaredTo(myloc) <= GameConstants.VISION_RADIUS_SQUARED) {
                        currentBugPosition = bugPath479;
                        break findCurrentBugPosition;
                    }
                }
                
                case 478: {
                    if (bugPath478.distanceSquaredTo(myloc) <= GameConstants.VISION_RADIUS_SQUARED) {
                        currentBugPosition = bugPath478;
                        break findCurrentBugPosition;
                    }
                }
                
                case 477: {
                    if (bugPath477.distanceSquaredTo(myloc) <= GameConstants.VISION_RADIUS_SQUARED) {
                        currentBugPosition = bugPath477;
                        break findCurrentBugPosition;
                    }
                }
                
                case 476: {
                    if (bugPath476.distanceSquaredTo(myloc) <= GameConstants.VISION_RADIUS_SQUARED) {
                        currentBugPosition = bugPath476;
                        break findCurrentBugPosition;
                    }
                }
                
                case 475: {
                    if (bugPath475.distanceSquaredTo(myloc) <= GameConstants.VISION_RADIUS_SQUARED) {
                        currentBugPosition = bugPath475;
                        break findCurrentBugPosition;
                    }
                }
                
                case 474: {
                    if (bugPath474.distanceSquaredTo(myloc) <= GameConstants.VISION_RADIUS_SQUARED) {
                        currentBugPosition = bugPath474;
                        break findCurrentBugPosition;
                    }
                }
                
                case 473: {
                    if (bugPath473.distanceSquaredTo(myloc) <= GameConstants.VISION_RADIUS_SQUARED) {
                        currentBugPosition = bugPath473;
                        break findCurrentBugPosition;
                    }
                }
                
                case 472: {
                    if (bugPath472.distanceSquaredTo(myloc) <= GameConstants.VISION_RADIUS_SQUARED) {
                        currentBugPosition = bugPath472;
                        break findCurrentBugPosition;
                    }
                }
                
                case 471: {
                    if (bugPath471.distanceSquaredTo(myloc) <= GameConstants.VISION_RADIUS_SQUARED) {
                        currentBugPosition = bugPath471;
                        break findCurrentBugPosition;
                    }
                }
                
                case 470: {
                    if (bugPath470.distanceSquaredTo(myloc) <= GameConstants.VISION_RADIUS_SQUARED) {
                        currentBugPosition = bugPath470;
                        break findCurrentBugPosition;
                    }
                }
                
                case 469: {
                    if (bugPath469.distanceSquaredTo(myloc) <= GameConstants.VISION_RADIUS_SQUARED) {
                        currentBugPosition = bugPath469;
                        break findCurrentBugPosition;
                    }
                }
                
                case 468: {
                    if (bugPath468.distanceSquaredTo(myloc) <= GameConstants.VISION_RADIUS_SQUARED) {
                        currentBugPosition = bugPath468;
                        break findCurrentBugPosition;
                    }
                }
                
                case 467: {
                    if (bugPath467.distanceSquaredTo(myloc) <= GameConstants.VISION_RADIUS_SQUARED) {
                        currentBugPosition = bugPath467;
                        break findCurrentBugPosition;
                    }
                }
                
                case 466: {
                    if (bugPath466.distanceSquaredTo(myloc) <= GameConstants.VISION_RADIUS_SQUARED) {
                        currentBugPosition = bugPath466;
                        break findCurrentBugPosition;
                    }
                }
                
                case 465: {
                    if (bugPath465.distanceSquaredTo(myloc) <= GameConstants.VISION_RADIUS_SQUARED) {
                        currentBugPosition = bugPath465;
                        break findCurrentBugPosition;
                    }
                }
                
                case 464: {
                    if (bugPath464.distanceSquaredTo(myloc) <= GameConstants.VISION_RADIUS_SQUARED) {
                        currentBugPosition = bugPath464;
                        break findCurrentBugPosition;
                    }
                }
                
                case 463: {
                    if (bugPath463.distanceSquaredTo(myloc) <= GameConstants.VISION_RADIUS_SQUARED) {
                        currentBugPosition = bugPath463;
                        break findCurrentBugPosition;
                    }
                }
                
                case 462: {
                    if (bugPath462.distanceSquaredTo(myloc) <= GameConstants.VISION_RADIUS_SQUARED) {
                        currentBugPosition = bugPath462;
                        break findCurrentBugPosition;
                    }
                }
                
                case 461: {
                    if (bugPath461.distanceSquaredTo(myloc) <= GameConstants.VISION_RADIUS_SQUARED) {
                        currentBugPosition = bugPath461;
                        break findCurrentBugPosition;
                    }
                }
                
                case 460: {
                    if (bugPath460.distanceSquaredTo(myloc) <= GameConstants.VISION_RADIUS_SQUARED) {
                        currentBugPosition = bugPath460;
                        break findCurrentBugPosition;
                    }
                }
                
                case 459: {
                    if (bugPath459.distanceSquaredTo(myloc) <= GameConstants.VISION_RADIUS_SQUARED) {
                        currentBugPosition = bugPath459;
                        break findCurrentBugPosition;
                    }
                }
                
                case 458: {
                    if (bugPath458.distanceSquaredTo(myloc) <= GameConstants.VISION_RADIUS_SQUARED) {
                        currentBugPosition = bugPath458;
                        break findCurrentBugPosition;
                    }
                }
                
                case 457: {
                    if (bugPath457.distanceSquaredTo(myloc) <= GameConstants.VISION_RADIUS_SQUARED) {
                        currentBugPosition = bugPath457;
                        break findCurrentBugPosition;
                    }
                }
                
                case 456: {
                    if (bugPath456.distanceSquaredTo(myloc) <= GameConstants.VISION_RADIUS_SQUARED) {
                        currentBugPosition = bugPath456;
                        break findCurrentBugPosition;
                    }
                }
                
                case 455: {
                    if (bugPath455.distanceSquaredTo(myloc) <= GameConstants.VISION_RADIUS_SQUARED) {
                        currentBugPosition = bugPath455;
                        break findCurrentBugPosition;
                    }
                }
                
                case 454: {
                    if (bugPath454.distanceSquaredTo(myloc) <= GameConstants.VISION_RADIUS_SQUARED) {
                        currentBugPosition = bugPath454;
                        break findCurrentBugPosition;
                    }
                }
                
                case 453: {
                    if (bugPath453.distanceSquaredTo(myloc) <= GameConstants.VISION_RADIUS_SQUARED) {
                        currentBugPosition = bugPath453;
                        break findCurrentBugPosition;
                    }
                }
                
                case 452: {
                    if (bugPath452.distanceSquaredTo(myloc) <= GameConstants.VISION_RADIUS_SQUARED) {
                        currentBugPosition = bugPath452;
                        break findCurrentBugPosition;
                    }
                }
                
                case 451: {
                    if (bugPath451.distanceSquaredTo(myloc) <= GameConstants.VISION_RADIUS_SQUARED) {
                        currentBugPosition = bugPath451;
                        break findCurrentBugPosition;
                    }
                }
                
                case 450: {
                    if (bugPath450.distanceSquaredTo(myloc) <= GameConstants.VISION_RADIUS_SQUARED) {
                        currentBugPosition = bugPath450;
                        break findCurrentBugPosition;
                    }
                }
                
                case 449: {
                    if (bugPath449.distanceSquaredTo(myloc) <= GameConstants.VISION_RADIUS_SQUARED) {
                        currentBugPosition = bugPath449;
                        break findCurrentBugPosition;
                    }
                }
                
                case 448: {
                    if (bugPath448.distanceSquaredTo(myloc) <= GameConstants.VISION_RADIUS_SQUARED) {
                        currentBugPosition = bugPath448;
                        break findCurrentBugPosition;
                    }
                }
                
                case 447: {
                    if (bugPath447.distanceSquaredTo(myloc) <= GameConstants.VISION_RADIUS_SQUARED) {
                        currentBugPosition = bugPath447;
                        break findCurrentBugPosition;
                    }
                }
                
                case 446: {
                    if (bugPath446.distanceSquaredTo(myloc) <= GameConstants.VISION_RADIUS_SQUARED) {
                        currentBugPosition = bugPath446;
                        break findCurrentBugPosition;
                    }
                }
                
                case 445: {
                    if (bugPath445.distanceSquaredTo(myloc) <= GameConstants.VISION_RADIUS_SQUARED) {
                        currentBugPosition = bugPath445;
                        break findCurrentBugPosition;
                    }
                }
                
                case 444: {
                    if (bugPath444.distanceSquaredTo(myloc) <= GameConstants.VISION_RADIUS_SQUARED) {
                        currentBugPosition = bugPath444;
                        break findCurrentBugPosition;
                    }
                }
                
                case 443: {
                    if (bugPath443.distanceSquaredTo(myloc) <= GameConstants.VISION_RADIUS_SQUARED) {
                        currentBugPosition = bugPath443;
                        break findCurrentBugPosition;
                    }
                }
                
                case 442: {
                    if (bugPath442.distanceSquaredTo(myloc) <= GameConstants.VISION_RADIUS_SQUARED) {
                        currentBugPosition = bugPath442;
                        break findCurrentBugPosition;
                    }
                }
                
                case 441: {
                    if (bugPath441.distanceSquaredTo(myloc) <= GameConstants.VISION_RADIUS_SQUARED) {
                        currentBugPosition = bugPath441;
                        break findCurrentBugPosition;
                    }
                }
                
                case 440: {
                    if (bugPath440.distanceSquaredTo(myloc) <= GameConstants.VISION_RADIUS_SQUARED) {
                        currentBugPosition = bugPath440;
                        break findCurrentBugPosition;
                    }
                }
                
                case 439: {
                    if (bugPath439.distanceSquaredTo(myloc) <= GameConstants.VISION_RADIUS_SQUARED) {
                        currentBugPosition = bugPath439;
                        break findCurrentBugPosition;
                    }
                }
                
                case 438: {
                    if (bugPath438.distanceSquaredTo(myloc) <= GameConstants.VISION_RADIUS_SQUARED) {
                        currentBugPosition = bugPath438;
                        break findCurrentBugPosition;
                    }
                }
                
                case 437: {
                    if (bugPath437.distanceSquaredTo(myloc) <= GameConstants.VISION_RADIUS_SQUARED) {
                        currentBugPosition = bugPath437;
                        break findCurrentBugPosition;
                    }
                }
                
                case 436: {
                    if (bugPath436.distanceSquaredTo(myloc) <= GameConstants.VISION_RADIUS_SQUARED) {
                        currentBugPosition = bugPath436;
                        break findCurrentBugPosition;
                    }
                }
                
                case 435: {
                    if (bugPath435.distanceSquaredTo(myloc) <= GameConstants.VISION_RADIUS_SQUARED) {
                        currentBugPosition = bugPath435;
                        break findCurrentBugPosition;
                    }
                }
                
                case 434: {
                    if (bugPath434.distanceSquaredTo(myloc) <= GameConstants.VISION_RADIUS_SQUARED) {
                        currentBugPosition = bugPath434;
                        break findCurrentBugPosition;
                    }
                }
                
                case 433: {
                    if (bugPath433.distanceSquaredTo(myloc) <= GameConstants.VISION_RADIUS_SQUARED) {
                        currentBugPosition = bugPath433;
                        break findCurrentBugPosition;
                    }
                }
                
                case 432: {
                    if (bugPath432.distanceSquaredTo(myloc) <= GameConstants.VISION_RADIUS_SQUARED) {
                        currentBugPosition = bugPath432;
                        break findCurrentBugPosition;
                    }
                }
                
                case 431: {
                    if (bugPath431.distanceSquaredTo(myloc) <= GameConstants.VISION_RADIUS_SQUARED) {
                        currentBugPosition = bugPath431;
                        break findCurrentBugPosition;
                    }
                }
                
                case 430: {
                    if (bugPath430.distanceSquaredTo(myloc) <= GameConstants.VISION_RADIUS_SQUARED) {
                        currentBugPosition = bugPath430;
                        break findCurrentBugPosition;
                    }
                }
                
                case 429: {
                    if (bugPath429.distanceSquaredTo(myloc) <= GameConstants.VISION_RADIUS_SQUARED) {
                        currentBugPosition = bugPath429;
                        break findCurrentBugPosition;
                    }
                }
                
                case 428: {
                    if (bugPath428.distanceSquaredTo(myloc) <= GameConstants.VISION_RADIUS_SQUARED) {
                        currentBugPosition = bugPath428;
                        break findCurrentBugPosition;
                    }
                }
                
                case 427: {
                    if (bugPath427.distanceSquaredTo(myloc) <= GameConstants.VISION_RADIUS_SQUARED) {
                        currentBugPosition = bugPath427;
                        break findCurrentBugPosition;
                    }
                }
                
                case 426: {
                    if (bugPath426.distanceSquaredTo(myloc) <= GameConstants.VISION_RADIUS_SQUARED) {
                        currentBugPosition = bugPath426;
                        break findCurrentBugPosition;
                    }
                }
                
                case 425: {
                    if (bugPath425.distanceSquaredTo(myloc) <= GameConstants.VISION_RADIUS_SQUARED) {
                        currentBugPosition = bugPath425;
                        break findCurrentBugPosition;
                    }
                }
                
                case 424: {
                    if (bugPath424.distanceSquaredTo(myloc) <= GameConstants.VISION_RADIUS_SQUARED) {
                        currentBugPosition = bugPath424;
                        break findCurrentBugPosition;
                    }
                }
                
                case 423: {
                    if (bugPath423.distanceSquaredTo(myloc) <= GameConstants.VISION_RADIUS_SQUARED) {
                        currentBugPosition = bugPath423;
                        break findCurrentBugPosition;
                    }
                }
                
                case 422: {
                    if (bugPath422.distanceSquaredTo(myloc) <= GameConstants.VISION_RADIUS_SQUARED) {
                        currentBugPosition = bugPath422;
                        break findCurrentBugPosition;
                    }
                }
                
                case 421: {
                    if (bugPath421.distanceSquaredTo(myloc) <= GameConstants.VISION_RADIUS_SQUARED) {
                        currentBugPosition = bugPath421;
                        break findCurrentBugPosition;
                    }
                }
                
                case 420: {
                    if (bugPath420.distanceSquaredTo(myloc) <= GameConstants.VISION_RADIUS_SQUARED) {
                        currentBugPosition = bugPath420;
                        break findCurrentBugPosition;
                    }
                }
                
                case 419: {
                    if (bugPath419.distanceSquaredTo(myloc) <= GameConstants.VISION_RADIUS_SQUARED) {
                        currentBugPosition = bugPath419;
                        break findCurrentBugPosition;
                    }
                }
                
                case 418: {
                    if (bugPath418.distanceSquaredTo(myloc) <= GameConstants.VISION_RADIUS_SQUARED) {
                        currentBugPosition = bugPath418;
                        break findCurrentBugPosition;
                    }
                }
                
                case 417: {
                    if (bugPath417.distanceSquaredTo(myloc) <= GameConstants.VISION_RADIUS_SQUARED) {
                        currentBugPosition = bugPath417;
                        break findCurrentBugPosition;
                    }
                }
                
                case 416: {
                    if (bugPath416.distanceSquaredTo(myloc) <= GameConstants.VISION_RADIUS_SQUARED) {
                        currentBugPosition = bugPath416;
                        break findCurrentBugPosition;
                    }
                }
                
                case 415: {
                    if (bugPath415.distanceSquaredTo(myloc) <= GameConstants.VISION_RADIUS_SQUARED) {
                        currentBugPosition = bugPath415;
                        break findCurrentBugPosition;
                    }
                }
                
                case 414: {
                    if (bugPath414.distanceSquaredTo(myloc) <= GameConstants.VISION_RADIUS_SQUARED) {
                        currentBugPosition = bugPath414;
                        break findCurrentBugPosition;
                    }
                }
                
                case 413: {
                    if (bugPath413.distanceSquaredTo(myloc) <= GameConstants.VISION_RADIUS_SQUARED) {
                        currentBugPosition = bugPath413;
                        break findCurrentBugPosition;
                    }
                }
                
                case 412: {
                    if (bugPath412.distanceSquaredTo(myloc) <= GameConstants.VISION_RADIUS_SQUARED) {
                        currentBugPosition = bugPath412;
                        break findCurrentBugPosition;
                    }
                }
                
                case 411: {
                    if (bugPath411.distanceSquaredTo(myloc) <= GameConstants.VISION_RADIUS_SQUARED) {
                        currentBugPosition = bugPath411;
                        break findCurrentBugPosition;
                    }
                }
                
                case 410: {
                    if (bugPath410.distanceSquaredTo(myloc) <= GameConstants.VISION_RADIUS_SQUARED) {
                        currentBugPosition = bugPath410;
                        break findCurrentBugPosition;
                    }
                }
                
                case 409: {
                    if (bugPath409.distanceSquaredTo(myloc) <= GameConstants.VISION_RADIUS_SQUARED) {
                        currentBugPosition = bugPath409;
                        break findCurrentBugPosition;
                    }
                }
                
                case 408: {
                    if (bugPath408.distanceSquaredTo(myloc) <= GameConstants.VISION_RADIUS_SQUARED) {
                        currentBugPosition = bugPath408;
                        break findCurrentBugPosition;
                    }
                }
                
                case 407: {
                    if (bugPath407.distanceSquaredTo(myloc) <= GameConstants.VISION_RADIUS_SQUARED) {
                        currentBugPosition = bugPath407;
                        break findCurrentBugPosition;
                    }
                }
                
                case 406: {
                    if (bugPath406.distanceSquaredTo(myloc) <= GameConstants.VISION_RADIUS_SQUARED) {
                        currentBugPosition = bugPath406;
                        break findCurrentBugPosition;
                    }
                }
                
                case 405: {
                    if (bugPath405.distanceSquaredTo(myloc) <= GameConstants.VISION_RADIUS_SQUARED) {
                        currentBugPosition = bugPath405;
                        break findCurrentBugPosition;
                    }
                }
                
                case 404: {
                    if (bugPath404.distanceSquaredTo(myloc) <= GameConstants.VISION_RADIUS_SQUARED) {
                        currentBugPosition = bugPath404;
                        break findCurrentBugPosition;
                    }
                }
                
                case 403: {
                    if (bugPath403.distanceSquaredTo(myloc) <= GameConstants.VISION_RADIUS_SQUARED) {
                        currentBugPosition = bugPath403;
                        break findCurrentBugPosition;
                    }
                }
                
                case 402: {
                    if (bugPath402.distanceSquaredTo(myloc) <= GameConstants.VISION_RADIUS_SQUARED) {
                        currentBugPosition = bugPath402;
                        break findCurrentBugPosition;
                    }
                }
                
                case 401: {
                    if (bugPath401.distanceSquaredTo(myloc) <= GameConstants.VISION_RADIUS_SQUARED) {
                        currentBugPosition = bugPath401;
                        break findCurrentBugPosition;
                    }
                }
                
                case 400: {
                    if (bugPath400.distanceSquaredTo(myloc) <= GameConstants.VISION_RADIUS_SQUARED) {
                        currentBugPosition = bugPath400;
                        break findCurrentBugPosition;
                    }
                }
                
                case 399: {
                    if (bugPath399.distanceSquaredTo(myloc) <= GameConstants.VISION_RADIUS_SQUARED) {
                        currentBugPosition = bugPath399;
                        break findCurrentBugPosition;
                    }
                }
                
                case 398: {
                    if (bugPath398.distanceSquaredTo(myloc) <= GameConstants.VISION_RADIUS_SQUARED) {
                        currentBugPosition = bugPath398;
                        break findCurrentBugPosition;
                    }
                }
                
                case 397: {
                    if (bugPath397.distanceSquaredTo(myloc) <= GameConstants.VISION_RADIUS_SQUARED) {
                        currentBugPosition = bugPath397;
                        break findCurrentBugPosition;
                    }
                }
                
                case 396: {
                    if (bugPath396.distanceSquaredTo(myloc) <= GameConstants.VISION_RADIUS_SQUARED) {
                        currentBugPosition = bugPath396;
                        break findCurrentBugPosition;
                    }
                }
                
                case 395: {
                    if (bugPath395.distanceSquaredTo(myloc) <= GameConstants.VISION_RADIUS_SQUARED) {
                        currentBugPosition = bugPath395;
                        break findCurrentBugPosition;
                    }
                }
                
                case 394: {
                    if (bugPath394.distanceSquaredTo(myloc) <= GameConstants.VISION_RADIUS_SQUARED) {
                        currentBugPosition = bugPath394;
                        break findCurrentBugPosition;
                    }
                }
                
                case 393: {
                    if (bugPath393.distanceSquaredTo(myloc) <= GameConstants.VISION_RADIUS_SQUARED) {
                        currentBugPosition = bugPath393;
                        break findCurrentBugPosition;
                    }
                }
                
                case 392: {
                    if (bugPath392.distanceSquaredTo(myloc) <= GameConstants.VISION_RADIUS_SQUARED) {
                        currentBugPosition = bugPath392;
                        break findCurrentBugPosition;
                    }
                }
                
                case 391: {
                    if (bugPath391.distanceSquaredTo(myloc) <= GameConstants.VISION_RADIUS_SQUARED) {
                        currentBugPosition = bugPath391;
                        break findCurrentBugPosition;
                    }
                }
                
                case 390: {
                    if (bugPath390.distanceSquaredTo(myloc) <= GameConstants.VISION_RADIUS_SQUARED) {
                        currentBugPosition = bugPath390;
                        break findCurrentBugPosition;
                    }
                }
                
                case 389: {
                    if (bugPath389.distanceSquaredTo(myloc) <= GameConstants.VISION_RADIUS_SQUARED) {
                        currentBugPosition = bugPath389;
                        break findCurrentBugPosition;
                    }
                }
                
                case 388: {
                    if (bugPath388.distanceSquaredTo(myloc) <= GameConstants.VISION_RADIUS_SQUARED) {
                        currentBugPosition = bugPath388;
                        break findCurrentBugPosition;
                    }
                }
                
                case 387: {
                    if (bugPath387.distanceSquaredTo(myloc) <= GameConstants.VISION_RADIUS_SQUARED) {
                        currentBugPosition = bugPath387;
                        break findCurrentBugPosition;
                    }
                }
                
                case 386: {
                    if (bugPath386.distanceSquaredTo(myloc) <= GameConstants.VISION_RADIUS_SQUARED) {
                        currentBugPosition = bugPath386;
                        break findCurrentBugPosition;
                    }
                }
                
                case 385: {
                    if (bugPath385.distanceSquaredTo(myloc) <= GameConstants.VISION_RADIUS_SQUARED) {
                        currentBugPosition = bugPath385;
                        break findCurrentBugPosition;
                    }
                }
                
                case 384: {
                    if (bugPath384.distanceSquaredTo(myloc) <= GameConstants.VISION_RADIUS_SQUARED) {
                        currentBugPosition = bugPath384;
                        break findCurrentBugPosition;
                    }
                }
                
                case 383: {
                    if (bugPath383.distanceSquaredTo(myloc) <= GameConstants.VISION_RADIUS_SQUARED) {
                        currentBugPosition = bugPath383;
                        break findCurrentBugPosition;
                    }
                }
                
                case 382: {
                    if (bugPath382.distanceSquaredTo(myloc) <= GameConstants.VISION_RADIUS_SQUARED) {
                        currentBugPosition = bugPath382;
                        break findCurrentBugPosition;
                    }
                }
                
                case 381: {
                    if (bugPath381.distanceSquaredTo(myloc) <= GameConstants.VISION_RADIUS_SQUARED) {
                        currentBugPosition = bugPath381;
                        break findCurrentBugPosition;
                    }
                }
                
                case 380: {
                    if (bugPath380.distanceSquaredTo(myloc) <= GameConstants.VISION_RADIUS_SQUARED) {
                        currentBugPosition = bugPath380;
                        break findCurrentBugPosition;
                    }
                }
                
                case 379: {
                    if (bugPath379.distanceSquaredTo(myloc) <= GameConstants.VISION_RADIUS_SQUARED) {
                        currentBugPosition = bugPath379;
                        break findCurrentBugPosition;
                    }
                }
                
                case 378: {
                    if (bugPath378.distanceSquaredTo(myloc) <= GameConstants.VISION_RADIUS_SQUARED) {
                        currentBugPosition = bugPath378;
                        break findCurrentBugPosition;
                    }
                }
                
                case 377: {
                    if (bugPath377.distanceSquaredTo(myloc) <= GameConstants.VISION_RADIUS_SQUARED) {
                        currentBugPosition = bugPath377;
                        break findCurrentBugPosition;
                    }
                }
                
                case 376: {
                    if (bugPath376.distanceSquaredTo(myloc) <= GameConstants.VISION_RADIUS_SQUARED) {
                        currentBugPosition = bugPath376;
                        break findCurrentBugPosition;
                    }
                }
                
                case 375: {
                    if (bugPath375.distanceSquaredTo(myloc) <= GameConstants.VISION_RADIUS_SQUARED) {
                        currentBugPosition = bugPath375;
                        break findCurrentBugPosition;
                    }
                }
                
                case 374: {
                    if (bugPath374.distanceSquaredTo(myloc) <= GameConstants.VISION_RADIUS_SQUARED) {
                        currentBugPosition = bugPath374;
                        break findCurrentBugPosition;
                    }
                }
                
                case 373: {
                    if (bugPath373.distanceSquaredTo(myloc) <= GameConstants.VISION_RADIUS_SQUARED) {
                        currentBugPosition = bugPath373;
                        break findCurrentBugPosition;
                    }
                }
                
                case 372: {
                    if (bugPath372.distanceSquaredTo(myloc) <= GameConstants.VISION_RADIUS_SQUARED) {
                        currentBugPosition = bugPath372;
                        break findCurrentBugPosition;
                    }
                }
                
                case 371: {
                    if (bugPath371.distanceSquaredTo(myloc) <= GameConstants.VISION_RADIUS_SQUARED) {
                        currentBugPosition = bugPath371;
                        break findCurrentBugPosition;
                    }
                }
                
                case 370: {
                    if (bugPath370.distanceSquaredTo(myloc) <= GameConstants.VISION_RADIUS_SQUARED) {
                        currentBugPosition = bugPath370;
                        break findCurrentBugPosition;
                    }
                }
                
                case 369: {
                    if (bugPath369.distanceSquaredTo(myloc) <= GameConstants.VISION_RADIUS_SQUARED) {
                        currentBugPosition = bugPath369;
                        break findCurrentBugPosition;
                    }
                }
                
                case 368: {
                    if (bugPath368.distanceSquaredTo(myloc) <= GameConstants.VISION_RADIUS_SQUARED) {
                        currentBugPosition = bugPath368;
                        break findCurrentBugPosition;
                    }
                }
                
                case 367: {
                    if (bugPath367.distanceSquaredTo(myloc) <= GameConstants.VISION_RADIUS_SQUARED) {
                        currentBugPosition = bugPath367;
                        break findCurrentBugPosition;
                    }
                }
                
                case 366: {
                    if (bugPath366.distanceSquaredTo(myloc) <= GameConstants.VISION_RADIUS_SQUARED) {
                        currentBugPosition = bugPath366;
                        break findCurrentBugPosition;
                    }
                }
                
                case 365: {
                    if (bugPath365.distanceSquaredTo(myloc) <= GameConstants.VISION_RADIUS_SQUARED) {
                        currentBugPosition = bugPath365;
                        break findCurrentBugPosition;
                    }
                }
                
                case 364: {
                    if (bugPath364.distanceSquaredTo(myloc) <= GameConstants.VISION_RADIUS_SQUARED) {
                        currentBugPosition = bugPath364;
                        break findCurrentBugPosition;
                    }
                }
                
                case 363: {
                    if (bugPath363.distanceSquaredTo(myloc) <= GameConstants.VISION_RADIUS_SQUARED) {
                        currentBugPosition = bugPath363;
                        break findCurrentBugPosition;
                    }
                }
                
                case 362: {
                    if (bugPath362.distanceSquaredTo(myloc) <= GameConstants.VISION_RADIUS_SQUARED) {
                        currentBugPosition = bugPath362;
                        break findCurrentBugPosition;
                    }
                }
                
                case 361: {
                    if (bugPath361.distanceSquaredTo(myloc) <= GameConstants.VISION_RADIUS_SQUARED) {
                        currentBugPosition = bugPath361;
                        break findCurrentBugPosition;
                    }
                }
                
                case 360: {
                    if (bugPath360.distanceSquaredTo(myloc) <= GameConstants.VISION_RADIUS_SQUARED) {
                        currentBugPosition = bugPath360;
                        break findCurrentBugPosition;
                    }
                }
                
                case 359: {
                    if (bugPath359.distanceSquaredTo(myloc) <= GameConstants.VISION_RADIUS_SQUARED) {
                        currentBugPosition = bugPath359;
                        break findCurrentBugPosition;
                    }
                }
                
                case 358: {
                    if (bugPath358.distanceSquaredTo(myloc) <= GameConstants.VISION_RADIUS_SQUARED) {
                        currentBugPosition = bugPath358;
                        break findCurrentBugPosition;
                    }
                }
                
                case 357: {
                    if (bugPath357.distanceSquaredTo(myloc) <= GameConstants.VISION_RADIUS_SQUARED) {
                        currentBugPosition = bugPath357;
                        break findCurrentBugPosition;
                    }
                }
                
                case 356: {
                    if (bugPath356.distanceSquaredTo(myloc) <= GameConstants.VISION_RADIUS_SQUARED) {
                        currentBugPosition = bugPath356;
                        break findCurrentBugPosition;
                    }
                }
                
                case 355: {
                    if (bugPath355.distanceSquaredTo(myloc) <= GameConstants.VISION_RADIUS_SQUARED) {
                        currentBugPosition = bugPath355;
                        break findCurrentBugPosition;
                    }
                }
                
                case 354: {
                    if (bugPath354.distanceSquaredTo(myloc) <= GameConstants.VISION_RADIUS_SQUARED) {
                        currentBugPosition = bugPath354;
                        break findCurrentBugPosition;
                    }
                }
                
                case 353: {
                    if (bugPath353.distanceSquaredTo(myloc) <= GameConstants.VISION_RADIUS_SQUARED) {
                        currentBugPosition = bugPath353;
                        break findCurrentBugPosition;
                    }
                }
                
                case 352: {
                    if (bugPath352.distanceSquaredTo(myloc) <= GameConstants.VISION_RADIUS_SQUARED) {
                        currentBugPosition = bugPath352;
                        break findCurrentBugPosition;
                    }
                }
                
                case 351: {
                    if (bugPath351.distanceSquaredTo(myloc) <= GameConstants.VISION_RADIUS_SQUARED) {
                        currentBugPosition = bugPath351;
                        break findCurrentBugPosition;
                    }
                }
                
                case 350: {
                    if (bugPath350.distanceSquaredTo(myloc) <= GameConstants.VISION_RADIUS_SQUARED) {
                        currentBugPosition = bugPath350;
                        break findCurrentBugPosition;
                    }
                }
                
                case 349: {
                    if (bugPath349.distanceSquaredTo(myloc) <= GameConstants.VISION_RADIUS_SQUARED) {
                        currentBugPosition = bugPath349;
                        break findCurrentBugPosition;
                    }
                }
                
                case 348: {
                    if (bugPath348.distanceSquaredTo(myloc) <= GameConstants.VISION_RADIUS_SQUARED) {
                        currentBugPosition = bugPath348;
                        break findCurrentBugPosition;
                    }
                }
                
                case 347: {
                    if (bugPath347.distanceSquaredTo(myloc) <= GameConstants.VISION_RADIUS_SQUARED) {
                        currentBugPosition = bugPath347;
                        break findCurrentBugPosition;
                    }
                }
                
                case 346: {
                    if (bugPath346.distanceSquaredTo(myloc) <= GameConstants.VISION_RADIUS_SQUARED) {
                        currentBugPosition = bugPath346;
                        break findCurrentBugPosition;
                    }
                }
                
                case 345: {
                    if (bugPath345.distanceSquaredTo(myloc) <= GameConstants.VISION_RADIUS_SQUARED) {
                        currentBugPosition = bugPath345;
                        break findCurrentBugPosition;
                    }
                }
                
                case 344: {
                    if (bugPath344.distanceSquaredTo(myloc) <= GameConstants.VISION_RADIUS_SQUARED) {
                        currentBugPosition = bugPath344;
                        break findCurrentBugPosition;
                    }
                }
                
                case 343: {
                    if (bugPath343.distanceSquaredTo(myloc) <= GameConstants.VISION_RADIUS_SQUARED) {
                        currentBugPosition = bugPath343;
                        break findCurrentBugPosition;
                    }
                }
                
                case 342: {
                    if (bugPath342.distanceSquaredTo(myloc) <= GameConstants.VISION_RADIUS_SQUARED) {
                        currentBugPosition = bugPath342;
                        break findCurrentBugPosition;
                    }
                }
                
                case 341: {
                    if (bugPath341.distanceSquaredTo(myloc) <= GameConstants.VISION_RADIUS_SQUARED) {
                        currentBugPosition = bugPath341;
                        break findCurrentBugPosition;
                    }
                }
                
                case 340: {
                    if (bugPath340.distanceSquaredTo(myloc) <= GameConstants.VISION_RADIUS_SQUARED) {
                        currentBugPosition = bugPath340;
                        break findCurrentBugPosition;
                    }
                }
                
                case 339: {
                    if (bugPath339.distanceSquaredTo(myloc) <= GameConstants.VISION_RADIUS_SQUARED) {
                        currentBugPosition = bugPath339;
                        break findCurrentBugPosition;
                    }
                }
                
                case 338: {
                    if (bugPath338.distanceSquaredTo(myloc) <= GameConstants.VISION_RADIUS_SQUARED) {
                        currentBugPosition = bugPath338;
                        break findCurrentBugPosition;
                    }
                }
                
                case 337: {
                    if (bugPath337.distanceSquaredTo(myloc) <= GameConstants.VISION_RADIUS_SQUARED) {
                        currentBugPosition = bugPath337;
                        break findCurrentBugPosition;
                    }
                }
                
                case 336: {
                    if (bugPath336.distanceSquaredTo(myloc) <= GameConstants.VISION_RADIUS_SQUARED) {
                        currentBugPosition = bugPath336;
                        break findCurrentBugPosition;
                    }
                }
                
                case 335: {
                    if (bugPath335.distanceSquaredTo(myloc) <= GameConstants.VISION_RADIUS_SQUARED) {
                        currentBugPosition = bugPath335;
                        break findCurrentBugPosition;
                    }
                }
                
                case 334: {
                    if (bugPath334.distanceSquaredTo(myloc) <= GameConstants.VISION_RADIUS_SQUARED) {
                        currentBugPosition = bugPath334;
                        break findCurrentBugPosition;
                    }
                }
                
                case 333: {
                    if (bugPath333.distanceSquaredTo(myloc) <= GameConstants.VISION_RADIUS_SQUARED) {
                        currentBugPosition = bugPath333;
                        break findCurrentBugPosition;
                    }
                }
                
                case 332: {
                    if (bugPath332.distanceSquaredTo(myloc) <= GameConstants.VISION_RADIUS_SQUARED) {
                        currentBugPosition = bugPath332;
                        break findCurrentBugPosition;
                    }
                }
                
                case 331: {
                    if (bugPath331.distanceSquaredTo(myloc) <= GameConstants.VISION_RADIUS_SQUARED) {
                        currentBugPosition = bugPath331;
                        break findCurrentBugPosition;
                    }
                }
                
                case 330: {
                    if (bugPath330.distanceSquaredTo(myloc) <= GameConstants.VISION_RADIUS_SQUARED) {
                        currentBugPosition = bugPath330;
                        break findCurrentBugPosition;
                    }
                }
                
                case 329: {
                    if (bugPath329.distanceSquaredTo(myloc) <= GameConstants.VISION_RADIUS_SQUARED) {
                        currentBugPosition = bugPath329;
                        break findCurrentBugPosition;
                    }
                }
                
                case 328: {
                    if (bugPath328.distanceSquaredTo(myloc) <= GameConstants.VISION_RADIUS_SQUARED) {
                        currentBugPosition = bugPath328;
                        break findCurrentBugPosition;
                    }
                }
                
                case 327: {
                    if (bugPath327.distanceSquaredTo(myloc) <= GameConstants.VISION_RADIUS_SQUARED) {
                        currentBugPosition = bugPath327;
                        break findCurrentBugPosition;
                    }
                }
                
                case 326: {
                    if (bugPath326.distanceSquaredTo(myloc) <= GameConstants.VISION_RADIUS_SQUARED) {
                        currentBugPosition = bugPath326;
                        break findCurrentBugPosition;
                    }
                }
                
                case 325: {
                    if (bugPath325.distanceSquaredTo(myloc) <= GameConstants.VISION_RADIUS_SQUARED) {
                        currentBugPosition = bugPath325;
                        break findCurrentBugPosition;
                    }
                }
                
                case 324: {
                    if (bugPath324.distanceSquaredTo(myloc) <= GameConstants.VISION_RADIUS_SQUARED) {
                        currentBugPosition = bugPath324;
                        break findCurrentBugPosition;
                    }
                }
                
                case 323: {
                    if (bugPath323.distanceSquaredTo(myloc) <= GameConstants.VISION_RADIUS_SQUARED) {
                        currentBugPosition = bugPath323;
                        break findCurrentBugPosition;
                    }
                }
                
                case 322: {
                    if (bugPath322.distanceSquaredTo(myloc) <= GameConstants.VISION_RADIUS_SQUARED) {
                        currentBugPosition = bugPath322;
                        break findCurrentBugPosition;
                    }
                }
                
                case 321: {
                    if (bugPath321.distanceSquaredTo(myloc) <= GameConstants.VISION_RADIUS_SQUARED) {
                        currentBugPosition = bugPath321;
                        break findCurrentBugPosition;
                    }
                }
                
                case 320: {
                    if (bugPath320.distanceSquaredTo(myloc) <= GameConstants.VISION_RADIUS_SQUARED) {
                        currentBugPosition = bugPath320;
                        break findCurrentBugPosition;
                    }
                }
                
                case 319: {
                    if (bugPath319.distanceSquaredTo(myloc) <= GameConstants.VISION_RADIUS_SQUARED) {
                        currentBugPosition = bugPath319;
                        break findCurrentBugPosition;
                    }
                }
                
                case 318: {
                    if (bugPath318.distanceSquaredTo(myloc) <= GameConstants.VISION_RADIUS_SQUARED) {
                        currentBugPosition = bugPath318;
                        break findCurrentBugPosition;
                    }
                }
                
                case 317: {
                    if (bugPath317.distanceSquaredTo(myloc) <= GameConstants.VISION_RADIUS_SQUARED) {
                        currentBugPosition = bugPath317;
                        break findCurrentBugPosition;
                    }
                }
                
                case 316: {
                    if (bugPath316.distanceSquaredTo(myloc) <= GameConstants.VISION_RADIUS_SQUARED) {
                        currentBugPosition = bugPath316;
                        break findCurrentBugPosition;
                    }
                }
                
                case 315: {
                    if (bugPath315.distanceSquaredTo(myloc) <= GameConstants.VISION_RADIUS_SQUARED) {
                        currentBugPosition = bugPath315;
                        break findCurrentBugPosition;
                    }
                }
                
                case 314: {
                    if (bugPath314.distanceSquaredTo(myloc) <= GameConstants.VISION_RADIUS_SQUARED) {
                        currentBugPosition = bugPath314;
                        break findCurrentBugPosition;
                    }
                }
                
                case 313: {
                    if (bugPath313.distanceSquaredTo(myloc) <= GameConstants.VISION_RADIUS_SQUARED) {
                        currentBugPosition = bugPath313;
                        break findCurrentBugPosition;
                    }
                }
                
                case 312: {
                    if (bugPath312.distanceSquaredTo(myloc) <= GameConstants.VISION_RADIUS_SQUARED) {
                        currentBugPosition = bugPath312;
                        break findCurrentBugPosition;
                    }
                }
                
                case 311: {
                    if (bugPath311.distanceSquaredTo(myloc) <= GameConstants.VISION_RADIUS_SQUARED) {
                        currentBugPosition = bugPath311;
                        break findCurrentBugPosition;
                    }
                }
                
                case 310: {
                    if (bugPath310.distanceSquaredTo(myloc) <= GameConstants.VISION_RADIUS_SQUARED) {
                        currentBugPosition = bugPath310;
                        break findCurrentBugPosition;
                    }
                }
                
                case 309: {
                    if (bugPath309.distanceSquaredTo(myloc) <= GameConstants.VISION_RADIUS_SQUARED) {
                        currentBugPosition = bugPath309;
                        break findCurrentBugPosition;
                    }
                }
                
                case 308: {
                    if (bugPath308.distanceSquaredTo(myloc) <= GameConstants.VISION_RADIUS_SQUARED) {
                        currentBugPosition = bugPath308;
                        break findCurrentBugPosition;
                    }
                }
                
                case 307: {
                    if (bugPath307.distanceSquaredTo(myloc) <= GameConstants.VISION_RADIUS_SQUARED) {
                        currentBugPosition = bugPath307;
                        break findCurrentBugPosition;
                    }
                }
                
                case 306: {
                    if (bugPath306.distanceSquaredTo(myloc) <= GameConstants.VISION_RADIUS_SQUARED) {
                        currentBugPosition = bugPath306;
                        break findCurrentBugPosition;
                    }
                }
                
                case 305: {
                    if (bugPath305.distanceSquaredTo(myloc) <= GameConstants.VISION_RADIUS_SQUARED) {
                        currentBugPosition = bugPath305;
                        break findCurrentBugPosition;
                    }
                }
                
                case 304: {
                    if (bugPath304.distanceSquaredTo(myloc) <= GameConstants.VISION_RADIUS_SQUARED) {
                        currentBugPosition = bugPath304;
                        break findCurrentBugPosition;
                    }
                }
                
                case 303: {
                    if (bugPath303.distanceSquaredTo(myloc) <= GameConstants.VISION_RADIUS_SQUARED) {
                        currentBugPosition = bugPath303;
                        break findCurrentBugPosition;
                    }
                }
                
                case 302: {
                    if (bugPath302.distanceSquaredTo(myloc) <= GameConstants.VISION_RADIUS_SQUARED) {
                        currentBugPosition = bugPath302;
                        break findCurrentBugPosition;
                    }
                }
                
                case 301: {
                    if (bugPath301.distanceSquaredTo(myloc) <= GameConstants.VISION_RADIUS_SQUARED) {
                        currentBugPosition = bugPath301;
                        break findCurrentBugPosition;
                    }
                }
                
                case 300: {
                    if (bugPath300.distanceSquaredTo(myloc) <= GameConstants.VISION_RADIUS_SQUARED) {
                        currentBugPosition = bugPath300;
                        break findCurrentBugPosition;
                    }
                }
                
                case 299: {
                    if (bugPath299.distanceSquaredTo(myloc) <= GameConstants.VISION_RADIUS_SQUARED) {
                        currentBugPosition = bugPath299;
                        break findCurrentBugPosition;
                    }
                }
                
                case 298: {
                    if (bugPath298.distanceSquaredTo(myloc) <= GameConstants.VISION_RADIUS_SQUARED) {
                        currentBugPosition = bugPath298;
                        break findCurrentBugPosition;
                    }
                }
                
                case 297: {
                    if (bugPath297.distanceSquaredTo(myloc) <= GameConstants.VISION_RADIUS_SQUARED) {
                        currentBugPosition = bugPath297;
                        break findCurrentBugPosition;
                    }
                }
                
                case 296: {
                    if (bugPath296.distanceSquaredTo(myloc) <= GameConstants.VISION_RADIUS_SQUARED) {
                        currentBugPosition = bugPath296;
                        break findCurrentBugPosition;
                    }
                }
                
                case 295: {
                    if (bugPath295.distanceSquaredTo(myloc) <= GameConstants.VISION_RADIUS_SQUARED) {
                        currentBugPosition = bugPath295;
                        break findCurrentBugPosition;
                    }
                }
                
                case 294: {
                    if (bugPath294.distanceSquaredTo(myloc) <= GameConstants.VISION_RADIUS_SQUARED) {
                        currentBugPosition = bugPath294;
                        break findCurrentBugPosition;
                    }
                }
                
                case 293: {
                    if (bugPath293.distanceSquaredTo(myloc) <= GameConstants.VISION_RADIUS_SQUARED) {
                        currentBugPosition = bugPath293;
                        break findCurrentBugPosition;
                    }
                }
                
                case 292: {
                    if (bugPath292.distanceSquaredTo(myloc) <= GameConstants.VISION_RADIUS_SQUARED) {
                        currentBugPosition = bugPath292;
                        break findCurrentBugPosition;
                    }
                }
                
                case 291: {
                    if (bugPath291.distanceSquaredTo(myloc) <= GameConstants.VISION_RADIUS_SQUARED) {
                        currentBugPosition = bugPath291;
                        break findCurrentBugPosition;
                    }
                }
                
                case 290: {
                    if (bugPath290.distanceSquaredTo(myloc) <= GameConstants.VISION_RADIUS_SQUARED) {
                        currentBugPosition = bugPath290;
                        break findCurrentBugPosition;
                    }
                }
                
                case 289: {
                    if (bugPath289.distanceSquaredTo(myloc) <= GameConstants.VISION_RADIUS_SQUARED) {
                        currentBugPosition = bugPath289;
                        break findCurrentBugPosition;
                    }
                }
                
                case 288: {
                    if (bugPath288.distanceSquaredTo(myloc) <= GameConstants.VISION_RADIUS_SQUARED) {
                        currentBugPosition = bugPath288;
                        break findCurrentBugPosition;
                    }
                }
                
                case 287: {
                    if (bugPath287.distanceSquaredTo(myloc) <= GameConstants.VISION_RADIUS_SQUARED) {
                        currentBugPosition = bugPath287;
                        break findCurrentBugPosition;
                    }
                }
                
                case 286: {
                    if (bugPath286.distanceSquaredTo(myloc) <= GameConstants.VISION_RADIUS_SQUARED) {
                        currentBugPosition = bugPath286;
                        break findCurrentBugPosition;
                    }
                }
                
                case 285: {
                    if (bugPath285.distanceSquaredTo(myloc) <= GameConstants.VISION_RADIUS_SQUARED) {
                        currentBugPosition = bugPath285;
                        break findCurrentBugPosition;
                    }
                }
                
                case 284: {
                    if (bugPath284.distanceSquaredTo(myloc) <= GameConstants.VISION_RADIUS_SQUARED) {
                        currentBugPosition = bugPath284;
                        break findCurrentBugPosition;
                    }
                }
                
                case 283: {
                    if (bugPath283.distanceSquaredTo(myloc) <= GameConstants.VISION_RADIUS_SQUARED) {
                        currentBugPosition = bugPath283;
                        break findCurrentBugPosition;
                    }
                }
                
                case 282: {
                    if (bugPath282.distanceSquaredTo(myloc) <= GameConstants.VISION_RADIUS_SQUARED) {
                        currentBugPosition = bugPath282;
                        break findCurrentBugPosition;
                    }
                }
                
                case 281: {
                    if (bugPath281.distanceSquaredTo(myloc) <= GameConstants.VISION_RADIUS_SQUARED) {
                        currentBugPosition = bugPath281;
                        break findCurrentBugPosition;
                    }
                }
                
                case 280: {
                    if (bugPath280.distanceSquaredTo(myloc) <= GameConstants.VISION_RADIUS_SQUARED) {
                        currentBugPosition = bugPath280;
                        break findCurrentBugPosition;
                    }
                }
                
                case 279: {
                    if (bugPath279.distanceSquaredTo(myloc) <= GameConstants.VISION_RADIUS_SQUARED) {
                        currentBugPosition = bugPath279;
                        break findCurrentBugPosition;
                    }
                }
                
                case 278: {
                    if (bugPath278.distanceSquaredTo(myloc) <= GameConstants.VISION_RADIUS_SQUARED) {
                        currentBugPosition = bugPath278;
                        break findCurrentBugPosition;
                    }
                }
                
                case 277: {
                    if (bugPath277.distanceSquaredTo(myloc) <= GameConstants.VISION_RADIUS_SQUARED) {
                        currentBugPosition = bugPath277;
                        break findCurrentBugPosition;
                    }
                }
                
                case 276: {
                    if (bugPath276.distanceSquaredTo(myloc) <= GameConstants.VISION_RADIUS_SQUARED) {
                        currentBugPosition = bugPath276;
                        break findCurrentBugPosition;
                    }
                }
                
                case 275: {
                    if (bugPath275.distanceSquaredTo(myloc) <= GameConstants.VISION_RADIUS_SQUARED) {
                        currentBugPosition = bugPath275;
                        break findCurrentBugPosition;
                    }
                }
                
                case 274: {
                    if (bugPath274.distanceSquaredTo(myloc) <= GameConstants.VISION_RADIUS_SQUARED) {
                        currentBugPosition = bugPath274;
                        break findCurrentBugPosition;
                    }
                }
                
                case 273: {
                    if (bugPath273.distanceSquaredTo(myloc) <= GameConstants.VISION_RADIUS_SQUARED) {
                        currentBugPosition = bugPath273;
                        break findCurrentBugPosition;
                    }
                }
                
                case 272: {
                    if (bugPath272.distanceSquaredTo(myloc) <= GameConstants.VISION_RADIUS_SQUARED) {
                        currentBugPosition = bugPath272;
                        break findCurrentBugPosition;
                    }
                }
                
                case 271: {
                    if (bugPath271.distanceSquaredTo(myloc) <= GameConstants.VISION_RADIUS_SQUARED) {
                        currentBugPosition = bugPath271;
                        break findCurrentBugPosition;
                    }
                }
                
                case 270: {
                    if (bugPath270.distanceSquaredTo(myloc) <= GameConstants.VISION_RADIUS_SQUARED) {
                        currentBugPosition = bugPath270;
                        break findCurrentBugPosition;
                    }
                }
                
                case 269: {
                    if (bugPath269.distanceSquaredTo(myloc) <= GameConstants.VISION_RADIUS_SQUARED) {
                        currentBugPosition = bugPath269;
                        break findCurrentBugPosition;
                    }
                }
                
                case 268: {
                    if (bugPath268.distanceSquaredTo(myloc) <= GameConstants.VISION_RADIUS_SQUARED) {
                        currentBugPosition = bugPath268;
                        break findCurrentBugPosition;
                    }
                }
                
                case 267: {
                    if (bugPath267.distanceSquaredTo(myloc) <= GameConstants.VISION_RADIUS_SQUARED) {
                        currentBugPosition = bugPath267;
                        break findCurrentBugPosition;
                    }
                }
                
                case 266: {
                    if (bugPath266.distanceSquaredTo(myloc) <= GameConstants.VISION_RADIUS_SQUARED) {
                        currentBugPosition = bugPath266;
                        break findCurrentBugPosition;
                    }
                }
                
                case 265: {
                    if (bugPath265.distanceSquaredTo(myloc) <= GameConstants.VISION_RADIUS_SQUARED) {
                        currentBugPosition = bugPath265;
                        break findCurrentBugPosition;
                    }
                }
                
                case 264: {
                    if (bugPath264.distanceSquaredTo(myloc) <= GameConstants.VISION_RADIUS_SQUARED) {
                        currentBugPosition = bugPath264;
                        break findCurrentBugPosition;
                    }
                }
                
                case 263: {
                    if (bugPath263.distanceSquaredTo(myloc) <= GameConstants.VISION_RADIUS_SQUARED) {
                        currentBugPosition = bugPath263;
                        break findCurrentBugPosition;
                    }
                }
                
                case 262: {
                    if (bugPath262.distanceSquaredTo(myloc) <= GameConstants.VISION_RADIUS_SQUARED) {
                        currentBugPosition = bugPath262;
                        break findCurrentBugPosition;
                    }
                }
                
                case 261: {
                    if (bugPath261.distanceSquaredTo(myloc) <= GameConstants.VISION_RADIUS_SQUARED) {
                        currentBugPosition = bugPath261;
                        break findCurrentBugPosition;
                    }
                }
                
                case 260: {
                    if (bugPath260.distanceSquaredTo(myloc) <= GameConstants.VISION_RADIUS_SQUARED) {
                        currentBugPosition = bugPath260;
                        break findCurrentBugPosition;
                    }
                }
                
                case 259: {
                    if (bugPath259.distanceSquaredTo(myloc) <= GameConstants.VISION_RADIUS_SQUARED) {
                        currentBugPosition = bugPath259;
                        break findCurrentBugPosition;
                    }
                }
                
                case 258: {
                    if (bugPath258.distanceSquaredTo(myloc) <= GameConstants.VISION_RADIUS_SQUARED) {
                        currentBugPosition = bugPath258;
                        break findCurrentBugPosition;
                    }
                }
                
                case 257: {
                    if (bugPath257.distanceSquaredTo(myloc) <= GameConstants.VISION_RADIUS_SQUARED) {
                        currentBugPosition = bugPath257;
                        break findCurrentBugPosition;
                    }
                }
                
                case 256: {
                    if (bugPath256.distanceSquaredTo(myloc) <= GameConstants.VISION_RADIUS_SQUARED) {
                        currentBugPosition = bugPath256;
                        break findCurrentBugPosition;
                    }
                }
                
                case 255: {
                    if (bugPath255.distanceSquaredTo(myloc) <= GameConstants.VISION_RADIUS_SQUARED) {
                        currentBugPosition = bugPath255;
                        break findCurrentBugPosition;
                    }
                }
                
                case 254: {
                    if (bugPath254.distanceSquaredTo(myloc) <= GameConstants.VISION_RADIUS_SQUARED) {
                        currentBugPosition = bugPath254;
                        break findCurrentBugPosition;
                    }
                }
                
                case 253: {
                    if (bugPath253.distanceSquaredTo(myloc) <= GameConstants.VISION_RADIUS_SQUARED) {
                        currentBugPosition = bugPath253;
                        break findCurrentBugPosition;
                    }
                }
                
                case 252: {
                    if (bugPath252.distanceSquaredTo(myloc) <= GameConstants.VISION_RADIUS_SQUARED) {
                        currentBugPosition = bugPath252;
                        break findCurrentBugPosition;
                    }
                }
                
                case 251: {
                    if (bugPath251.distanceSquaredTo(myloc) <= GameConstants.VISION_RADIUS_SQUARED) {
                        currentBugPosition = bugPath251;
                        break findCurrentBugPosition;
                    }
                }
                
                case 250: {
                    if (bugPath250.distanceSquaredTo(myloc) <= GameConstants.VISION_RADIUS_SQUARED) {
                        currentBugPosition = bugPath250;
                        break findCurrentBugPosition;
                    }
                }
                
                case 249: {
                    if (bugPath249.distanceSquaredTo(myloc) <= GameConstants.VISION_RADIUS_SQUARED) {
                        currentBugPosition = bugPath249;
                        break findCurrentBugPosition;
                    }
                }
                
                case 248: {
                    if (bugPath248.distanceSquaredTo(myloc) <= GameConstants.VISION_RADIUS_SQUARED) {
                        currentBugPosition = bugPath248;
                        break findCurrentBugPosition;
                    }
                }
                
                case 247: {
                    if (bugPath247.distanceSquaredTo(myloc) <= GameConstants.VISION_RADIUS_SQUARED) {
                        currentBugPosition = bugPath247;
                        break findCurrentBugPosition;
                    }
                }
                
                case 246: {
                    if (bugPath246.distanceSquaredTo(myloc) <= GameConstants.VISION_RADIUS_SQUARED) {
                        currentBugPosition = bugPath246;
                        break findCurrentBugPosition;
                    }
                }
                
                case 245: {
                    if (bugPath245.distanceSquaredTo(myloc) <= GameConstants.VISION_RADIUS_SQUARED) {
                        currentBugPosition = bugPath245;
                        break findCurrentBugPosition;
                    }
                }
                
                case 244: {
                    if (bugPath244.distanceSquaredTo(myloc) <= GameConstants.VISION_RADIUS_SQUARED) {
                        currentBugPosition = bugPath244;
                        break findCurrentBugPosition;
                    }
                }
                
                case 243: {
                    if (bugPath243.distanceSquaredTo(myloc) <= GameConstants.VISION_RADIUS_SQUARED) {
                        currentBugPosition = bugPath243;
                        break findCurrentBugPosition;
                    }
                }
                
                case 242: {
                    if (bugPath242.distanceSquaredTo(myloc) <= GameConstants.VISION_RADIUS_SQUARED) {
                        currentBugPosition = bugPath242;
                        break findCurrentBugPosition;
                    }
                }
                
                case 241: {
                    if (bugPath241.distanceSquaredTo(myloc) <= GameConstants.VISION_RADIUS_SQUARED) {
                        currentBugPosition = bugPath241;
                        break findCurrentBugPosition;
                    }
                }
                
                case 240: {
                    if (bugPath240.distanceSquaredTo(myloc) <= GameConstants.VISION_RADIUS_SQUARED) {
                        currentBugPosition = bugPath240;
                        break findCurrentBugPosition;
                    }
                }
                
                case 239: {
                    if (bugPath239.distanceSquaredTo(myloc) <= GameConstants.VISION_RADIUS_SQUARED) {
                        currentBugPosition = bugPath239;
                        break findCurrentBugPosition;
                    }
                }
                
                case 238: {
                    if (bugPath238.distanceSquaredTo(myloc) <= GameConstants.VISION_RADIUS_SQUARED) {
                        currentBugPosition = bugPath238;
                        break findCurrentBugPosition;
                    }
                }
                
                case 237: {
                    if (bugPath237.distanceSquaredTo(myloc) <= GameConstants.VISION_RADIUS_SQUARED) {
                        currentBugPosition = bugPath237;
                        break findCurrentBugPosition;
                    }
                }
                
                case 236: {
                    if (bugPath236.distanceSquaredTo(myloc) <= GameConstants.VISION_RADIUS_SQUARED) {
                        currentBugPosition = bugPath236;
                        break findCurrentBugPosition;
                    }
                }
                
                case 235: {
                    if (bugPath235.distanceSquaredTo(myloc) <= GameConstants.VISION_RADIUS_SQUARED) {
                        currentBugPosition = bugPath235;
                        break findCurrentBugPosition;
                    }
                }
                
                case 234: {
                    if (bugPath234.distanceSquaredTo(myloc) <= GameConstants.VISION_RADIUS_SQUARED) {
                        currentBugPosition = bugPath234;
                        break findCurrentBugPosition;
                    }
                }
                
                case 233: {
                    if (bugPath233.distanceSquaredTo(myloc) <= GameConstants.VISION_RADIUS_SQUARED) {
                        currentBugPosition = bugPath233;
                        break findCurrentBugPosition;
                    }
                }
                
                case 232: {
                    if (bugPath232.distanceSquaredTo(myloc) <= GameConstants.VISION_RADIUS_SQUARED) {
                        currentBugPosition = bugPath232;
                        break findCurrentBugPosition;
                    }
                }
                
                case 231: {
                    if (bugPath231.distanceSquaredTo(myloc) <= GameConstants.VISION_RADIUS_SQUARED) {
                        currentBugPosition = bugPath231;
                        break findCurrentBugPosition;
                    }
                }
                
                case 230: {
                    if (bugPath230.distanceSquaredTo(myloc) <= GameConstants.VISION_RADIUS_SQUARED) {
                        currentBugPosition = bugPath230;
                        break findCurrentBugPosition;
                    }
                }
                
                case 229: {
                    if (bugPath229.distanceSquaredTo(myloc) <= GameConstants.VISION_RADIUS_SQUARED) {
                        currentBugPosition = bugPath229;
                        break findCurrentBugPosition;
                    }
                }
                
                case 228: {
                    if (bugPath228.distanceSquaredTo(myloc) <= GameConstants.VISION_RADIUS_SQUARED) {
                        currentBugPosition = bugPath228;
                        break findCurrentBugPosition;
                    }
                }
                
                case 227: {
                    if (bugPath227.distanceSquaredTo(myloc) <= GameConstants.VISION_RADIUS_SQUARED) {
                        currentBugPosition = bugPath227;
                        break findCurrentBugPosition;
                    }
                }
                
                case 226: {
                    if (bugPath226.distanceSquaredTo(myloc) <= GameConstants.VISION_RADIUS_SQUARED) {
                        currentBugPosition = bugPath226;
                        break findCurrentBugPosition;
                    }
                }
                
                case 225: {
                    if (bugPath225.distanceSquaredTo(myloc) <= GameConstants.VISION_RADIUS_SQUARED) {
                        currentBugPosition = bugPath225;
                        break findCurrentBugPosition;
                    }
                }
                
                case 224: {
                    if (bugPath224.distanceSquaredTo(myloc) <= GameConstants.VISION_RADIUS_SQUARED) {
                        currentBugPosition = bugPath224;
                        break findCurrentBugPosition;
                    }
                }
                
                case 223: {
                    if (bugPath223.distanceSquaredTo(myloc) <= GameConstants.VISION_RADIUS_SQUARED) {
                        currentBugPosition = bugPath223;
                        break findCurrentBugPosition;
                    }
                }
                
                case 222: {
                    if (bugPath222.distanceSquaredTo(myloc) <= GameConstants.VISION_RADIUS_SQUARED) {
                        currentBugPosition = bugPath222;
                        break findCurrentBugPosition;
                    }
                }
                
                case 221: {
                    if (bugPath221.distanceSquaredTo(myloc) <= GameConstants.VISION_RADIUS_SQUARED) {
                        currentBugPosition = bugPath221;
                        break findCurrentBugPosition;
                    }
                }
                
                case 220: {
                    if (bugPath220.distanceSquaredTo(myloc) <= GameConstants.VISION_RADIUS_SQUARED) {
                        currentBugPosition = bugPath220;
                        break findCurrentBugPosition;
                    }
                }
                
                case 219: {
                    if (bugPath219.distanceSquaredTo(myloc) <= GameConstants.VISION_RADIUS_SQUARED) {
                        currentBugPosition = bugPath219;
                        break findCurrentBugPosition;
                    }
                }
                
                case 218: {
                    if (bugPath218.distanceSquaredTo(myloc) <= GameConstants.VISION_RADIUS_SQUARED) {
                        currentBugPosition = bugPath218;
                        break findCurrentBugPosition;
                    }
                }
                
                case 217: {
                    if (bugPath217.distanceSquaredTo(myloc) <= GameConstants.VISION_RADIUS_SQUARED) {
                        currentBugPosition = bugPath217;
                        break findCurrentBugPosition;
                    }
                }
                
                case 216: {
                    if (bugPath216.distanceSquaredTo(myloc) <= GameConstants.VISION_RADIUS_SQUARED) {
                        currentBugPosition = bugPath216;
                        break findCurrentBugPosition;
                    }
                }
                
                case 215: {
                    if (bugPath215.distanceSquaredTo(myloc) <= GameConstants.VISION_RADIUS_SQUARED) {
                        currentBugPosition = bugPath215;
                        break findCurrentBugPosition;
                    }
                }
                
                case 214: {
                    if (bugPath214.distanceSquaredTo(myloc) <= GameConstants.VISION_RADIUS_SQUARED) {
                        currentBugPosition = bugPath214;
                        break findCurrentBugPosition;
                    }
                }
                
                case 213: {
                    if (bugPath213.distanceSquaredTo(myloc) <= GameConstants.VISION_RADIUS_SQUARED) {
                        currentBugPosition = bugPath213;
                        break findCurrentBugPosition;
                    }
                }
                
                case 212: {
                    if (bugPath212.distanceSquaredTo(myloc) <= GameConstants.VISION_RADIUS_SQUARED) {
                        currentBugPosition = bugPath212;
                        break findCurrentBugPosition;
                    }
                }
                
                case 211: {
                    if (bugPath211.distanceSquaredTo(myloc) <= GameConstants.VISION_RADIUS_SQUARED) {
                        currentBugPosition = bugPath211;
                        break findCurrentBugPosition;
                    }
                }
                
                case 210: {
                    if (bugPath210.distanceSquaredTo(myloc) <= GameConstants.VISION_RADIUS_SQUARED) {
                        currentBugPosition = bugPath210;
                        break findCurrentBugPosition;
                    }
                }
                
                case 209: {
                    if (bugPath209.distanceSquaredTo(myloc) <= GameConstants.VISION_RADIUS_SQUARED) {
                        currentBugPosition = bugPath209;
                        break findCurrentBugPosition;
                    }
                }
                
                case 208: {
                    if (bugPath208.distanceSquaredTo(myloc) <= GameConstants.VISION_RADIUS_SQUARED) {
                        currentBugPosition = bugPath208;
                        break findCurrentBugPosition;
                    }
                }
                
                case 207: {
                    if (bugPath207.distanceSquaredTo(myloc) <= GameConstants.VISION_RADIUS_SQUARED) {
                        currentBugPosition = bugPath207;
                        break findCurrentBugPosition;
                    }
                }
                
                case 206: {
                    if (bugPath206.distanceSquaredTo(myloc) <= GameConstants.VISION_RADIUS_SQUARED) {
                        currentBugPosition = bugPath206;
                        break findCurrentBugPosition;
                    }
                }
                
                case 205: {
                    if (bugPath205.distanceSquaredTo(myloc) <= GameConstants.VISION_RADIUS_SQUARED) {
                        currentBugPosition = bugPath205;
                        break findCurrentBugPosition;
                    }
                }
                
                case 204: {
                    if (bugPath204.distanceSquaredTo(myloc) <= GameConstants.VISION_RADIUS_SQUARED) {
                        currentBugPosition = bugPath204;
                        break findCurrentBugPosition;
                    }
                }
                
                case 203: {
                    if (bugPath203.distanceSquaredTo(myloc) <= GameConstants.VISION_RADIUS_SQUARED) {
                        currentBugPosition = bugPath203;
                        break findCurrentBugPosition;
                    }
                }
                
                case 202: {
                    if (bugPath202.distanceSquaredTo(myloc) <= GameConstants.VISION_RADIUS_SQUARED) {
                        currentBugPosition = bugPath202;
                        break findCurrentBugPosition;
                    }
                }
                
                case 201: {
                    if (bugPath201.distanceSquaredTo(myloc) <= GameConstants.VISION_RADIUS_SQUARED) {
                        currentBugPosition = bugPath201;
                        break findCurrentBugPosition;
                    }
                }
                
                case 200: {
                    if (bugPath200.distanceSquaredTo(myloc) <= GameConstants.VISION_RADIUS_SQUARED) {
                        currentBugPosition = bugPath200;
                        break findCurrentBugPosition;
                    }
                }
                
                case 199: {
                    if (bugPath199.distanceSquaredTo(myloc) <= GameConstants.VISION_RADIUS_SQUARED) {
                        currentBugPosition = bugPath199;
                        break findCurrentBugPosition;
                    }
                }
                
                case 198: {
                    if (bugPath198.distanceSquaredTo(myloc) <= GameConstants.VISION_RADIUS_SQUARED) {
                        currentBugPosition = bugPath198;
                        break findCurrentBugPosition;
                    }
                }
                
                case 197: {
                    if (bugPath197.distanceSquaredTo(myloc) <= GameConstants.VISION_RADIUS_SQUARED) {
                        currentBugPosition = bugPath197;
                        break findCurrentBugPosition;
                    }
                }
                
                case 196: {
                    if (bugPath196.distanceSquaredTo(myloc) <= GameConstants.VISION_RADIUS_SQUARED) {
                        currentBugPosition = bugPath196;
                        break findCurrentBugPosition;
                    }
                }
                
                case 195: {
                    if (bugPath195.distanceSquaredTo(myloc) <= GameConstants.VISION_RADIUS_SQUARED) {
                        currentBugPosition = bugPath195;
                        break findCurrentBugPosition;
                    }
                }
                
                case 194: {
                    if (bugPath194.distanceSquaredTo(myloc) <= GameConstants.VISION_RADIUS_SQUARED) {
                        currentBugPosition = bugPath194;
                        break findCurrentBugPosition;
                    }
                }
                
                case 193: {
                    if (bugPath193.distanceSquaredTo(myloc) <= GameConstants.VISION_RADIUS_SQUARED) {
                        currentBugPosition = bugPath193;
                        break findCurrentBugPosition;
                    }
                }
                
                case 192: {
                    if (bugPath192.distanceSquaredTo(myloc) <= GameConstants.VISION_RADIUS_SQUARED) {
                        currentBugPosition = bugPath192;
                        break findCurrentBugPosition;
                    }
                }
                
                case 191: {
                    if (bugPath191.distanceSquaredTo(myloc) <= GameConstants.VISION_RADIUS_SQUARED) {
                        currentBugPosition = bugPath191;
                        break findCurrentBugPosition;
                    }
                }
                
                case 190: {
                    if (bugPath190.distanceSquaredTo(myloc) <= GameConstants.VISION_RADIUS_SQUARED) {
                        currentBugPosition = bugPath190;
                        break findCurrentBugPosition;
                    }
                }
                
                case 189: {
                    if (bugPath189.distanceSquaredTo(myloc) <= GameConstants.VISION_RADIUS_SQUARED) {
                        currentBugPosition = bugPath189;
                        break findCurrentBugPosition;
                    }
                }
                
                case 188: {
                    if (bugPath188.distanceSquaredTo(myloc) <= GameConstants.VISION_RADIUS_SQUARED) {
                        currentBugPosition = bugPath188;
                        break findCurrentBugPosition;
                    }
                }
                
                case 187: {
                    if (bugPath187.distanceSquaredTo(myloc) <= GameConstants.VISION_RADIUS_SQUARED) {
                        currentBugPosition = bugPath187;
                        break findCurrentBugPosition;
                    }
                }
                
                case 186: {
                    if (bugPath186.distanceSquaredTo(myloc) <= GameConstants.VISION_RADIUS_SQUARED) {
                        currentBugPosition = bugPath186;
                        break findCurrentBugPosition;
                    }
                }
                
                case 185: {
                    if (bugPath185.distanceSquaredTo(myloc) <= GameConstants.VISION_RADIUS_SQUARED) {
                        currentBugPosition = bugPath185;
                        break findCurrentBugPosition;
                    }
                }
                
                case 184: {
                    if (bugPath184.distanceSquaredTo(myloc) <= GameConstants.VISION_RADIUS_SQUARED) {
                        currentBugPosition = bugPath184;
                        break findCurrentBugPosition;
                    }
                }
                
                case 183: {
                    if (bugPath183.distanceSquaredTo(myloc) <= GameConstants.VISION_RADIUS_SQUARED) {
                        currentBugPosition = bugPath183;
                        break findCurrentBugPosition;
                    }
                }
                
                case 182: {
                    if (bugPath182.distanceSquaredTo(myloc) <= GameConstants.VISION_RADIUS_SQUARED) {
                        currentBugPosition = bugPath182;
                        break findCurrentBugPosition;
                    }
                }
                
                case 181: {
                    if (bugPath181.distanceSquaredTo(myloc) <= GameConstants.VISION_RADIUS_SQUARED) {
                        currentBugPosition = bugPath181;
                        break findCurrentBugPosition;
                    }
                }
                
                case 180: {
                    if (bugPath180.distanceSquaredTo(myloc) <= GameConstants.VISION_RADIUS_SQUARED) {
                        currentBugPosition = bugPath180;
                        break findCurrentBugPosition;
                    }
                }
                
                case 179: {
                    if (bugPath179.distanceSquaredTo(myloc) <= GameConstants.VISION_RADIUS_SQUARED) {
                        currentBugPosition = bugPath179;
                        break findCurrentBugPosition;
                    }
                }
                
                case 178: {
                    if (bugPath178.distanceSquaredTo(myloc) <= GameConstants.VISION_RADIUS_SQUARED) {
                        currentBugPosition = bugPath178;
                        break findCurrentBugPosition;
                    }
                }
                
                case 177: {
                    if (bugPath177.distanceSquaredTo(myloc) <= GameConstants.VISION_RADIUS_SQUARED) {
                        currentBugPosition = bugPath177;
                        break findCurrentBugPosition;
                    }
                }
                
                case 176: {
                    if (bugPath176.distanceSquaredTo(myloc) <= GameConstants.VISION_RADIUS_SQUARED) {
                        currentBugPosition = bugPath176;
                        break findCurrentBugPosition;
                    }
                }
                
                case 175: {
                    if (bugPath175.distanceSquaredTo(myloc) <= GameConstants.VISION_RADIUS_SQUARED) {
                        currentBugPosition = bugPath175;
                        break findCurrentBugPosition;
                    }
                }
                
                case 174: {
                    if (bugPath174.distanceSquaredTo(myloc) <= GameConstants.VISION_RADIUS_SQUARED) {
                        currentBugPosition = bugPath174;
                        break findCurrentBugPosition;
                    }
                }
                
                case 173: {
                    if (bugPath173.distanceSquaredTo(myloc) <= GameConstants.VISION_RADIUS_SQUARED) {
                        currentBugPosition = bugPath173;
                        break findCurrentBugPosition;
                    }
                }
                
                case 172: {
                    if (bugPath172.distanceSquaredTo(myloc) <= GameConstants.VISION_RADIUS_SQUARED) {
                        currentBugPosition = bugPath172;
                        break findCurrentBugPosition;
                    }
                }
                
                case 171: {
                    if (bugPath171.distanceSquaredTo(myloc) <= GameConstants.VISION_RADIUS_SQUARED) {
                        currentBugPosition = bugPath171;
                        break findCurrentBugPosition;
                    }
                }
                
                case 170: {
                    if (bugPath170.distanceSquaredTo(myloc) <= GameConstants.VISION_RADIUS_SQUARED) {
                        currentBugPosition = bugPath170;
                        break findCurrentBugPosition;
                    }
                }
                
                case 169: {
                    if (bugPath169.distanceSquaredTo(myloc) <= GameConstants.VISION_RADIUS_SQUARED) {
                        currentBugPosition = bugPath169;
                        break findCurrentBugPosition;
                    }
                }
                
                case 168: {
                    if (bugPath168.distanceSquaredTo(myloc) <= GameConstants.VISION_RADIUS_SQUARED) {
                        currentBugPosition = bugPath168;
                        break findCurrentBugPosition;
                    }
                }
                
                case 167: {
                    if (bugPath167.distanceSquaredTo(myloc) <= GameConstants.VISION_RADIUS_SQUARED) {
                        currentBugPosition = bugPath167;
                        break findCurrentBugPosition;
                    }
                }
                
                case 166: {
                    if (bugPath166.distanceSquaredTo(myloc) <= GameConstants.VISION_RADIUS_SQUARED) {
                        currentBugPosition = bugPath166;
                        break findCurrentBugPosition;
                    }
                }
                
                case 165: {
                    if (bugPath165.distanceSquaredTo(myloc) <= GameConstants.VISION_RADIUS_SQUARED) {
                        currentBugPosition = bugPath165;
                        break findCurrentBugPosition;
                    }
                }
                
                case 164: {
                    if (bugPath164.distanceSquaredTo(myloc) <= GameConstants.VISION_RADIUS_SQUARED) {
                        currentBugPosition = bugPath164;
                        break findCurrentBugPosition;
                    }
                }
                
                case 163: {
                    if (bugPath163.distanceSquaredTo(myloc) <= GameConstants.VISION_RADIUS_SQUARED) {
                        currentBugPosition = bugPath163;
                        break findCurrentBugPosition;
                    }
                }
                
                case 162: {
                    if (bugPath162.distanceSquaredTo(myloc) <= GameConstants.VISION_RADIUS_SQUARED) {
                        currentBugPosition = bugPath162;
                        break findCurrentBugPosition;
                    }
                }
                
                case 161: {
                    if (bugPath161.distanceSquaredTo(myloc) <= GameConstants.VISION_RADIUS_SQUARED) {
                        currentBugPosition = bugPath161;
                        break findCurrentBugPosition;
                    }
                }
                
                case 160: {
                    if (bugPath160.distanceSquaredTo(myloc) <= GameConstants.VISION_RADIUS_SQUARED) {
                        currentBugPosition = bugPath160;
                        break findCurrentBugPosition;
                    }
                }
                
                case 159: {
                    if (bugPath159.distanceSquaredTo(myloc) <= GameConstants.VISION_RADIUS_SQUARED) {
                        currentBugPosition = bugPath159;
                        break findCurrentBugPosition;
                    }
                }
                
                case 158: {
                    if (bugPath158.distanceSquaredTo(myloc) <= GameConstants.VISION_RADIUS_SQUARED) {
                        currentBugPosition = bugPath158;
                        break findCurrentBugPosition;
                    }
                }
                
                case 157: {
                    if (bugPath157.distanceSquaredTo(myloc) <= GameConstants.VISION_RADIUS_SQUARED) {
                        currentBugPosition = bugPath157;
                        break findCurrentBugPosition;
                    }
                }
                
                case 156: {
                    if (bugPath156.distanceSquaredTo(myloc) <= GameConstants.VISION_RADIUS_SQUARED) {
                        currentBugPosition = bugPath156;
                        break findCurrentBugPosition;
                    }
                }
                
                case 155: {
                    if (bugPath155.distanceSquaredTo(myloc) <= GameConstants.VISION_RADIUS_SQUARED) {
                        currentBugPosition = bugPath155;
                        break findCurrentBugPosition;
                    }
                }
                
                case 154: {
                    if (bugPath154.distanceSquaredTo(myloc) <= GameConstants.VISION_RADIUS_SQUARED) {
                        currentBugPosition = bugPath154;
                        break findCurrentBugPosition;
                    }
                }
                
                case 153: {
                    if (bugPath153.distanceSquaredTo(myloc) <= GameConstants.VISION_RADIUS_SQUARED) {
                        currentBugPosition = bugPath153;
                        break findCurrentBugPosition;
                    }
                }
                
                case 152: {
                    if (bugPath152.distanceSquaredTo(myloc) <= GameConstants.VISION_RADIUS_SQUARED) {
                        currentBugPosition = bugPath152;
                        break findCurrentBugPosition;
                    }
                }
                
                case 151: {
                    if (bugPath151.distanceSquaredTo(myloc) <= GameConstants.VISION_RADIUS_SQUARED) {
                        currentBugPosition = bugPath151;
                        break findCurrentBugPosition;
                    }
                }
                
                case 150: {
                    if (bugPath150.distanceSquaredTo(myloc) <= GameConstants.VISION_RADIUS_SQUARED) {
                        currentBugPosition = bugPath150;
                        break findCurrentBugPosition;
                    }
                }
                
                case 149: {
                    if (bugPath149.distanceSquaredTo(myloc) <= GameConstants.VISION_RADIUS_SQUARED) {
                        currentBugPosition = bugPath149;
                        break findCurrentBugPosition;
                    }
                }
                
                case 148: {
                    if (bugPath148.distanceSquaredTo(myloc) <= GameConstants.VISION_RADIUS_SQUARED) {
                        currentBugPosition = bugPath148;
                        break findCurrentBugPosition;
                    }
                }
                
                case 147: {
                    if (bugPath147.distanceSquaredTo(myloc) <= GameConstants.VISION_RADIUS_SQUARED) {
                        currentBugPosition = bugPath147;
                        break findCurrentBugPosition;
                    }
                }
                
                case 146: {
                    if (bugPath146.distanceSquaredTo(myloc) <= GameConstants.VISION_RADIUS_SQUARED) {
                        currentBugPosition = bugPath146;
                        break findCurrentBugPosition;
                    }
                }
                
                case 145: {
                    if (bugPath145.distanceSquaredTo(myloc) <= GameConstants.VISION_RADIUS_SQUARED) {
                        currentBugPosition = bugPath145;
                        break findCurrentBugPosition;
                    }
                }
                
                case 144: {
                    if (bugPath144.distanceSquaredTo(myloc) <= GameConstants.VISION_RADIUS_SQUARED) {
                        currentBugPosition = bugPath144;
                        break findCurrentBugPosition;
                    }
                }
                
                case 143: {
                    if (bugPath143.distanceSquaredTo(myloc) <= GameConstants.VISION_RADIUS_SQUARED) {
                        currentBugPosition = bugPath143;
                        break findCurrentBugPosition;
                    }
                }
                
                case 142: {
                    if (bugPath142.distanceSquaredTo(myloc) <= GameConstants.VISION_RADIUS_SQUARED) {
                        currentBugPosition = bugPath142;
                        break findCurrentBugPosition;
                    }
                }
                
                case 141: {
                    if (bugPath141.distanceSquaredTo(myloc) <= GameConstants.VISION_RADIUS_SQUARED) {
                        currentBugPosition = bugPath141;
                        break findCurrentBugPosition;
                    }
                }
                
                case 140: {
                    if (bugPath140.distanceSquaredTo(myloc) <= GameConstants.VISION_RADIUS_SQUARED) {
                        currentBugPosition = bugPath140;
                        break findCurrentBugPosition;
                    }
                }
                
                case 139: {
                    if (bugPath139.distanceSquaredTo(myloc) <= GameConstants.VISION_RADIUS_SQUARED) {
                        currentBugPosition = bugPath139;
                        break findCurrentBugPosition;
                    }
                }
                
                case 138: {
                    if (bugPath138.distanceSquaredTo(myloc) <= GameConstants.VISION_RADIUS_SQUARED) {
                        currentBugPosition = bugPath138;
                        break findCurrentBugPosition;
                    }
                }
                
                case 137: {
                    if (bugPath137.distanceSquaredTo(myloc) <= GameConstants.VISION_RADIUS_SQUARED) {
                        currentBugPosition = bugPath137;
                        break findCurrentBugPosition;
                    }
                }
                
                case 136: {
                    if (bugPath136.distanceSquaredTo(myloc) <= GameConstants.VISION_RADIUS_SQUARED) {
                        currentBugPosition = bugPath136;
                        break findCurrentBugPosition;
                    }
                }
                
                case 135: {
                    if (bugPath135.distanceSquaredTo(myloc) <= GameConstants.VISION_RADIUS_SQUARED) {
                        currentBugPosition = bugPath135;
                        break findCurrentBugPosition;
                    }
                }
                
                case 134: {
                    if (bugPath134.distanceSquaredTo(myloc) <= GameConstants.VISION_RADIUS_SQUARED) {
                        currentBugPosition = bugPath134;
                        break findCurrentBugPosition;
                    }
                }
                
                case 133: {
                    if (bugPath133.distanceSquaredTo(myloc) <= GameConstants.VISION_RADIUS_SQUARED) {
                        currentBugPosition = bugPath133;
                        break findCurrentBugPosition;
                    }
                }
                
                case 132: {
                    if (bugPath132.distanceSquaredTo(myloc) <= GameConstants.VISION_RADIUS_SQUARED) {
                        currentBugPosition = bugPath132;
                        break findCurrentBugPosition;
                    }
                }
                
                case 131: {
                    if (bugPath131.distanceSquaredTo(myloc) <= GameConstants.VISION_RADIUS_SQUARED) {
                        currentBugPosition = bugPath131;
                        break findCurrentBugPosition;
                    }
                }
                
                case 130: {
                    if (bugPath130.distanceSquaredTo(myloc) <= GameConstants.VISION_RADIUS_SQUARED) {
                        currentBugPosition = bugPath130;
                        break findCurrentBugPosition;
                    }
                }
                
                case 129: {
                    if (bugPath129.distanceSquaredTo(myloc) <= GameConstants.VISION_RADIUS_SQUARED) {
                        currentBugPosition = bugPath129;
                        break findCurrentBugPosition;
                    }
                }
                
                case 128: {
                    if (bugPath128.distanceSquaredTo(myloc) <= GameConstants.VISION_RADIUS_SQUARED) {
                        currentBugPosition = bugPath128;
                        break findCurrentBugPosition;
                    }
                }
                
                case 127: {
                    if (bugPath127.distanceSquaredTo(myloc) <= GameConstants.VISION_RADIUS_SQUARED) {
                        currentBugPosition = bugPath127;
                        break findCurrentBugPosition;
                    }
                }
                
                case 126: {
                    if (bugPath126.distanceSquaredTo(myloc) <= GameConstants.VISION_RADIUS_SQUARED) {
                        currentBugPosition = bugPath126;
                        break findCurrentBugPosition;
                    }
                }
                
                case 125: {
                    if (bugPath125.distanceSquaredTo(myloc) <= GameConstants.VISION_RADIUS_SQUARED) {
                        currentBugPosition = bugPath125;
                        break findCurrentBugPosition;
                    }
                }
                
                case 124: {
                    if (bugPath124.distanceSquaredTo(myloc) <= GameConstants.VISION_RADIUS_SQUARED) {
                        currentBugPosition = bugPath124;
                        break findCurrentBugPosition;
                    }
                }
                
                case 123: {
                    if (bugPath123.distanceSquaredTo(myloc) <= GameConstants.VISION_RADIUS_SQUARED) {
                        currentBugPosition = bugPath123;
                        break findCurrentBugPosition;
                    }
                }
                
                case 122: {
                    if (bugPath122.distanceSquaredTo(myloc) <= GameConstants.VISION_RADIUS_SQUARED) {
                        currentBugPosition = bugPath122;
                        break findCurrentBugPosition;
                    }
                }
                
                case 121: {
                    if (bugPath121.distanceSquaredTo(myloc) <= GameConstants.VISION_RADIUS_SQUARED) {
                        currentBugPosition = bugPath121;
                        break findCurrentBugPosition;
                    }
                }
                
                case 120: {
                    if (bugPath120.distanceSquaredTo(myloc) <= GameConstants.VISION_RADIUS_SQUARED) {
                        currentBugPosition = bugPath120;
                        break findCurrentBugPosition;
                    }
                }
                
                case 119: {
                    if (bugPath119.distanceSquaredTo(myloc) <= GameConstants.VISION_RADIUS_SQUARED) {
                        currentBugPosition = bugPath119;
                        break findCurrentBugPosition;
                    }
                }
                
                case 118: {
                    if (bugPath118.distanceSquaredTo(myloc) <= GameConstants.VISION_RADIUS_SQUARED) {
                        currentBugPosition = bugPath118;
                        break findCurrentBugPosition;
                    }
                }
                
                case 117: {
                    if (bugPath117.distanceSquaredTo(myloc) <= GameConstants.VISION_RADIUS_SQUARED) {
                        currentBugPosition = bugPath117;
                        break findCurrentBugPosition;
                    }
                }
                
                case 116: {
                    if (bugPath116.distanceSquaredTo(myloc) <= GameConstants.VISION_RADIUS_SQUARED) {
                        currentBugPosition = bugPath116;
                        break findCurrentBugPosition;
                    }
                }
                
                case 115: {
                    if (bugPath115.distanceSquaredTo(myloc) <= GameConstants.VISION_RADIUS_SQUARED) {
                        currentBugPosition = bugPath115;
                        break findCurrentBugPosition;
                    }
                }
                
                case 114: {
                    if (bugPath114.distanceSquaredTo(myloc) <= GameConstants.VISION_RADIUS_SQUARED) {
                        currentBugPosition = bugPath114;
                        break findCurrentBugPosition;
                    }
                }
                
                case 113: {
                    if (bugPath113.distanceSquaredTo(myloc) <= GameConstants.VISION_RADIUS_SQUARED) {
                        currentBugPosition = bugPath113;
                        break findCurrentBugPosition;
                    }
                }
                
                case 112: {
                    if (bugPath112.distanceSquaredTo(myloc) <= GameConstants.VISION_RADIUS_SQUARED) {
                        currentBugPosition = bugPath112;
                        break findCurrentBugPosition;
                    }
                }
                
                case 111: {
                    if (bugPath111.distanceSquaredTo(myloc) <= GameConstants.VISION_RADIUS_SQUARED) {
                        currentBugPosition = bugPath111;
                        break findCurrentBugPosition;
                    }
                }
                
                case 110: {
                    if (bugPath110.distanceSquaredTo(myloc) <= GameConstants.VISION_RADIUS_SQUARED) {
                        currentBugPosition = bugPath110;
                        break findCurrentBugPosition;
                    }
                }
                
                case 109: {
                    if (bugPath109.distanceSquaredTo(myloc) <= GameConstants.VISION_RADIUS_SQUARED) {
                        currentBugPosition = bugPath109;
                        break findCurrentBugPosition;
                    }
                }
                
                case 108: {
                    if (bugPath108.distanceSquaredTo(myloc) <= GameConstants.VISION_RADIUS_SQUARED) {
                        currentBugPosition = bugPath108;
                        break findCurrentBugPosition;
                    }
                }
                
                case 107: {
                    if (bugPath107.distanceSquaredTo(myloc) <= GameConstants.VISION_RADIUS_SQUARED) {
                        currentBugPosition = bugPath107;
                        break findCurrentBugPosition;
                    }
                }
                
                case 106: {
                    if (bugPath106.distanceSquaredTo(myloc) <= GameConstants.VISION_RADIUS_SQUARED) {
                        currentBugPosition = bugPath106;
                        break findCurrentBugPosition;
                    }
                }
                
                case 105: {
                    if (bugPath105.distanceSquaredTo(myloc) <= GameConstants.VISION_RADIUS_SQUARED) {
                        currentBugPosition = bugPath105;
                        break findCurrentBugPosition;
                    }
                }
                
                case 104: {
                    if (bugPath104.distanceSquaredTo(myloc) <= GameConstants.VISION_RADIUS_SQUARED) {
                        currentBugPosition = bugPath104;
                        break findCurrentBugPosition;
                    }
                }
                
                case 103: {
                    if (bugPath103.distanceSquaredTo(myloc) <= GameConstants.VISION_RADIUS_SQUARED) {
                        currentBugPosition = bugPath103;
                        break findCurrentBugPosition;
                    }
                }
                
                case 102: {
                    if (bugPath102.distanceSquaredTo(myloc) <= GameConstants.VISION_RADIUS_SQUARED) {
                        currentBugPosition = bugPath102;
                        break findCurrentBugPosition;
                    }
                }
                
                case 101: {
                    if (bugPath101.distanceSquaredTo(myloc) <= GameConstants.VISION_RADIUS_SQUARED) {
                        currentBugPosition = bugPath101;
                        break findCurrentBugPosition;
                    }
                }
                
                case 100: {
                    if (bugPath100.distanceSquaredTo(myloc) <= GameConstants.VISION_RADIUS_SQUARED) {
                        currentBugPosition = bugPath100;
                        break findCurrentBugPosition;
                    }
                }
                
                case 99: {
                    if (bugPath99.distanceSquaredTo(myloc) <= GameConstants.VISION_RADIUS_SQUARED) {
                        currentBugPosition = bugPath99;
                        break findCurrentBugPosition;
                    }
                }
                
                case 98: {
                    if (bugPath98.distanceSquaredTo(myloc) <= GameConstants.VISION_RADIUS_SQUARED) {
                        currentBugPosition = bugPath98;
                        break findCurrentBugPosition;
                    }
                }
                
                case 97: {
                    if (bugPath97.distanceSquaredTo(myloc) <= GameConstants.VISION_RADIUS_SQUARED) {
                        currentBugPosition = bugPath97;
                        break findCurrentBugPosition;
                    }
                }
                
                case 96: {
                    if (bugPath96.distanceSquaredTo(myloc) <= GameConstants.VISION_RADIUS_SQUARED) {
                        currentBugPosition = bugPath96;
                        break findCurrentBugPosition;
                    }
                }
                
                case 95: {
                    if (bugPath95.distanceSquaredTo(myloc) <= GameConstants.VISION_RADIUS_SQUARED) {
                        currentBugPosition = bugPath95;
                        break findCurrentBugPosition;
                    }
                }
                
                case 94: {
                    if (bugPath94.distanceSquaredTo(myloc) <= GameConstants.VISION_RADIUS_SQUARED) {
                        currentBugPosition = bugPath94;
                        break findCurrentBugPosition;
                    }
                }
                
                case 93: {
                    if (bugPath93.distanceSquaredTo(myloc) <= GameConstants.VISION_RADIUS_SQUARED) {
                        currentBugPosition = bugPath93;
                        break findCurrentBugPosition;
                    }
                }
                
                case 92: {
                    if (bugPath92.distanceSquaredTo(myloc) <= GameConstants.VISION_RADIUS_SQUARED) {
                        currentBugPosition = bugPath92;
                        break findCurrentBugPosition;
                    }
                }
                
                case 91: {
                    if (bugPath91.distanceSquaredTo(myloc) <= GameConstants.VISION_RADIUS_SQUARED) {
                        currentBugPosition = bugPath91;
                        break findCurrentBugPosition;
                    }
                }
                
                case 90: {
                    if (bugPath90.distanceSquaredTo(myloc) <= GameConstants.VISION_RADIUS_SQUARED) {
                        currentBugPosition = bugPath90;
                        break findCurrentBugPosition;
                    }
                }
                
                case 89: {
                    if (bugPath89.distanceSquaredTo(myloc) <= GameConstants.VISION_RADIUS_SQUARED) {
                        currentBugPosition = bugPath89;
                        break findCurrentBugPosition;
                    }
                }
                
                case 88: {
                    if (bugPath88.distanceSquaredTo(myloc) <= GameConstants.VISION_RADIUS_SQUARED) {
                        currentBugPosition = bugPath88;
                        break findCurrentBugPosition;
                    }
                }
                
                case 87: {
                    if (bugPath87.distanceSquaredTo(myloc) <= GameConstants.VISION_RADIUS_SQUARED) {
                        currentBugPosition = bugPath87;
                        break findCurrentBugPosition;
                    }
                }
                
                case 86: {
                    if (bugPath86.distanceSquaredTo(myloc) <= GameConstants.VISION_RADIUS_SQUARED) {
                        currentBugPosition = bugPath86;
                        break findCurrentBugPosition;
                    }
                }
                
                case 85: {
                    if (bugPath85.distanceSquaredTo(myloc) <= GameConstants.VISION_RADIUS_SQUARED) {
                        currentBugPosition = bugPath85;
                        break findCurrentBugPosition;
                    }
                }
                
                case 84: {
                    if (bugPath84.distanceSquaredTo(myloc) <= GameConstants.VISION_RADIUS_SQUARED) {
                        currentBugPosition = bugPath84;
                        break findCurrentBugPosition;
                    }
                }
                
                case 83: {
                    if (bugPath83.distanceSquaredTo(myloc) <= GameConstants.VISION_RADIUS_SQUARED) {
                        currentBugPosition = bugPath83;
                        break findCurrentBugPosition;
                    }
                }
                
                case 82: {
                    if (bugPath82.distanceSquaredTo(myloc) <= GameConstants.VISION_RADIUS_SQUARED) {
                        currentBugPosition = bugPath82;
                        break findCurrentBugPosition;
                    }
                }
                
                case 81: {
                    if (bugPath81.distanceSquaredTo(myloc) <= GameConstants.VISION_RADIUS_SQUARED) {
                        currentBugPosition = bugPath81;
                        break findCurrentBugPosition;
                    }
                }
                
                case 80: {
                    if (bugPath80.distanceSquaredTo(myloc) <= GameConstants.VISION_RADIUS_SQUARED) {
                        currentBugPosition = bugPath80;
                        break findCurrentBugPosition;
                    }
                }
                
                case 79: {
                    if (bugPath79.distanceSquaredTo(myloc) <= GameConstants.VISION_RADIUS_SQUARED) {
                        currentBugPosition = bugPath79;
                        break findCurrentBugPosition;
                    }
                }
                
                case 78: {
                    if (bugPath78.distanceSquaredTo(myloc) <= GameConstants.VISION_RADIUS_SQUARED) {
                        currentBugPosition = bugPath78;
                        break findCurrentBugPosition;
                    }
                }
                
                case 77: {
                    if (bugPath77.distanceSquaredTo(myloc) <= GameConstants.VISION_RADIUS_SQUARED) {
                        currentBugPosition = bugPath77;
                        break findCurrentBugPosition;
                    }
                }
                
                case 76: {
                    if (bugPath76.distanceSquaredTo(myloc) <= GameConstants.VISION_RADIUS_SQUARED) {
                        currentBugPosition = bugPath76;
                        break findCurrentBugPosition;
                    }
                }
                
                case 75: {
                    if (bugPath75.distanceSquaredTo(myloc) <= GameConstants.VISION_RADIUS_SQUARED) {
                        currentBugPosition = bugPath75;
                        break findCurrentBugPosition;
                    }
                }
                
                case 74: {
                    if (bugPath74.distanceSquaredTo(myloc) <= GameConstants.VISION_RADIUS_SQUARED) {
                        currentBugPosition = bugPath74;
                        break findCurrentBugPosition;
                    }
                }
                
                case 73: {
                    if (bugPath73.distanceSquaredTo(myloc) <= GameConstants.VISION_RADIUS_SQUARED) {
                        currentBugPosition = bugPath73;
                        break findCurrentBugPosition;
                    }
                }
                
                case 72: {
                    if (bugPath72.distanceSquaredTo(myloc) <= GameConstants.VISION_RADIUS_SQUARED) {
                        currentBugPosition = bugPath72;
                        break findCurrentBugPosition;
                    }
                }
                
                case 71: {
                    if (bugPath71.distanceSquaredTo(myloc) <= GameConstants.VISION_RADIUS_SQUARED) {
                        currentBugPosition = bugPath71;
                        break findCurrentBugPosition;
                    }
                }
                
                case 70: {
                    if (bugPath70.distanceSquaredTo(myloc) <= GameConstants.VISION_RADIUS_SQUARED) {
                        currentBugPosition = bugPath70;
                        break findCurrentBugPosition;
                    }
                }
                
                case 69: {
                    if (bugPath69.distanceSquaredTo(myloc) <= GameConstants.VISION_RADIUS_SQUARED) {
                        currentBugPosition = bugPath69;
                        break findCurrentBugPosition;
                    }
                }
                
                case 68: {
                    if (bugPath68.distanceSquaredTo(myloc) <= GameConstants.VISION_RADIUS_SQUARED) {
                        currentBugPosition = bugPath68;
                        break findCurrentBugPosition;
                    }
                }
                
                case 67: {
                    if (bugPath67.distanceSquaredTo(myloc) <= GameConstants.VISION_RADIUS_SQUARED) {
                        currentBugPosition = bugPath67;
                        break findCurrentBugPosition;
                    }
                }
                
                case 66: {
                    if (bugPath66.distanceSquaredTo(myloc) <= GameConstants.VISION_RADIUS_SQUARED) {
                        currentBugPosition = bugPath66;
                        break findCurrentBugPosition;
                    }
                }
                
                case 65: {
                    if (bugPath65.distanceSquaredTo(myloc) <= GameConstants.VISION_RADIUS_SQUARED) {
                        currentBugPosition = bugPath65;
                        break findCurrentBugPosition;
                    }
                }
                
                case 64: {
                    if (bugPath64.distanceSquaredTo(myloc) <= GameConstants.VISION_RADIUS_SQUARED) {
                        currentBugPosition = bugPath64;
                        break findCurrentBugPosition;
                    }
                }
                
                case 63: {
                    if (bugPath63.distanceSquaredTo(myloc) <= GameConstants.VISION_RADIUS_SQUARED) {
                        currentBugPosition = bugPath63;
                        break findCurrentBugPosition;
                    }
                }
                
                case 62: {
                    if (bugPath62.distanceSquaredTo(myloc) <= GameConstants.VISION_RADIUS_SQUARED) {
                        currentBugPosition = bugPath62;
                        break findCurrentBugPosition;
                    }
                }
                
                case 61: {
                    if (bugPath61.distanceSquaredTo(myloc) <= GameConstants.VISION_RADIUS_SQUARED) {
                        currentBugPosition = bugPath61;
                        break findCurrentBugPosition;
                    }
                }
                
                case 60: {
                    if (bugPath60.distanceSquaredTo(myloc) <= GameConstants.VISION_RADIUS_SQUARED) {
                        currentBugPosition = bugPath60;
                        break findCurrentBugPosition;
                    }
                }
                
                case 59: {
                    if (bugPath59.distanceSquaredTo(myloc) <= GameConstants.VISION_RADIUS_SQUARED) {
                        currentBugPosition = bugPath59;
                        break findCurrentBugPosition;
                    }
                }
                
                case 58: {
                    if (bugPath58.distanceSquaredTo(myloc) <= GameConstants.VISION_RADIUS_SQUARED) {
                        currentBugPosition = bugPath58;
                        break findCurrentBugPosition;
                    }
                }
                
                case 57: {
                    if (bugPath57.distanceSquaredTo(myloc) <= GameConstants.VISION_RADIUS_SQUARED) {
                        currentBugPosition = bugPath57;
                        break findCurrentBugPosition;
                    }
                }
                
                case 56: {
                    if (bugPath56.distanceSquaredTo(myloc) <= GameConstants.VISION_RADIUS_SQUARED) {
                        currentBugPosition = bugPath56;
                        break findCurrentBugPosition;
                    }
                }
                
                case 55: {
                    if (bugPath55.distanceSquaredTo(myloc) <= GameConstants.VISION_RADIUS_SQUARED) {
                        currentBugPosition = bugPath55;
                        break findCurrentBugPosition;
                    }
                }
                
                case 54: {
                    if (bugPath54.distanceSquaredTo(myloc) <= GameConstants.VISION_RADIUS_SQUARED) {
                        currentBugPosition = bugPath54;
                        break findCurrentBugPosition;
                    }
                }
                
                case 53: {
                    if (bugPath53.distanceSquaredTo(myloc) <= GameConstants.VISION_RADIUS_SQUARED) {
                        currentBugPosition = bugPath53;
                        break findCurrentBugPosition;
                    }
                }
                
                case 52: {
                    if (bugPath52.distanceSquaredTo(myloc) <= GameConstants.VISION_RADIUS_SQUARED) {
                        currentBugPosition = bugPath52;
                        break findCurrentBugPosition;
                    }
                }
                
                case 51: {
                    if (bugPath51.distanceSquaredTo(myloc) <= GameConstants.VISION_RADIUS_SQUARED) {
                        currentBugPosition = bugPath51;
                        break findCurrentBugPosition;
                    }
                }
                
                case 50: {
                    if (bugPath50.distanceSquaredTo(myloc) <= GameConstants.VISION_RADIUS_SQUARED) {
                        currentBugPosition = bugPath50;
                        break findCurrentBugPosition;
                    }
                }
                
                case 49: {
                    if (bugPath49.distanceSquaredTo(myloc) <= GameConstants.VISION_RADIUS_SQUARED) {
                        currentBugPosition = bugPath49;
                        break findCurrentBugPosition;
                    }
                }
                
                case 48: {
                    if (bugPath48.distanceSquaredTo(myloc) <= GameConstants.VISION_RADIUS_SQUARED) {
                        currentBugPosition = bugPath48;
                        break findCurrentBugPosition;
                    }
                }
                
                case 47: {
                    if (bugPath47.distanceSquaredTo(myloc) <= GameConstants.VISION_RADIUS_SQUARED) {
                        currentBugPosition = bugPath47;
                        break findCurrentBugPosition;
                    }
                }
                
                case 46: {
                    if (bugPath46.distanceSquaredTo(myloc) <= GameConstants.VISION_RADIUS_SQUARED) {
                        currentBugPosition = bugPath46;
                        break findCurrentBugPosition;
                    }
                }
                
                case 45: {
                    if (bugPath45.distanceSquaredTo(myloc) <= GameConstants.VISION_RADIUS_SQUARED) {
                        currentBugPosition = bugPath45;
                        break findCurrentBugPosition;
                    }
                }
                
                case 44: {
                    if (bugPath44.distanceSquaredTo(myloc) <= GameConstants.VISION_RADIUS_SQUARED) {
                        currentBugPosition = bugPath44;
                        break findCurrentBugPosition;
                    }
                }
                
                case 43: {
                    if (bugPath43.distanceSquaredTo(myloc) <= GameConstants.VISION_RADIUS_SQUARED) {
                        currentBugPosition = bugPath43;
                        break findCurrentBugPosition;
                    }
                }
                
                case 42: {
                    if (bugPath42.distanceSquaredTo(myloc) <= GameConstants.VISION_RADIUS_SQUARED) {
                        currentBugPosition = bugPath42;
                        break findCurrentBugPosition;
                    }
                }
                
                case 41: {
                    if (bugPath41.distanceSquaredTo(myloc) <= GameConstants.VISION_RADIUS_SQUARED) {
                        currentBugPosition = bugPath41;
                        break findCurrentBugPosition;
                    }
                }
                
                case 40: {
                    if (bugPath40.distanceSquaredTo(myloc) <= GameConstants.VISION_RADIUS_SQUARED) {
                        currentBugPosition = bugPath40;
                        break findCurrentBugPosition;
                    }
                }
                
                case 39: {
                    if (bugPath39.distanceSquaredTo(myloc) <= GameConstants.VISION_RADIUS_SQUARED) {
                        currentBugPosition = bugPath39;
                        break findCurrentBugPosition;
                    }
                }
                
                case 38: {
                    if (bugPath38.distanceSquaredTo(myloc) <= GameConstants.VISION_RADIUS_SQUARED) {
                        currentBugPosition = bugPath38;
                        break findCurrentBugPosition;
                    }
                }
                
                case 37: {
                    if (bugPath37.distanceSquaredTo(myloc) <= GameConstants.VISION_RADIUS_SQUARED) {
                        currentBugPosition = bugPath37;
                        break findCurrentBugPosition;
                    }
                }
                
                case 36: {
                    if (bugPath36.distanceSquaredTo(myloc) <= GameConstants.VISION_RADIUS_SQUARED) {
                        currentBugPosition = bugPath36;
                        break findCurrentBugPosition;
                    }
                }
                
                case 35: {
                    if (bugPath35.distanceSquaredTo(myloc) <= GameConstants.VISION_RADIUS_SQUARED) {
                        currentBugPosition = bugPath35;
                        break findCurrentBugPosition;
                    }
                }
                
                case 34: {
                    if (bugPath34.distanceSquaredTo(myloc) <= GameConstants.VISION_RADIUS_SQUARED) {
                        currentBugPosition = bugPath34;
                        break findCurrentBugPosition;
                    }
                }
                
                case 33: {
                    if (bugPath33.distanceSquaredTo(myloc) <= GameConstants.VISION_RADIUS_SQUARED) {
                        currentBugPosition = bugPath33;
                        break findCurrentBugPosition;
                    }
                }
                
                case 32: {
                    if (bugPath32.distanceSquaredTo(myloc) <= GameConstants.VISION_RADIUS_SQUARED) {
                        currentBugPosition = bugPath32;
                        break findCurrentBugPosition;
                    }
                }
                
                case 31: {
                    if (bugPath31.distanceSquaredTo(myloc) <= GameConstants.VISION_RADIUS_SQUARED) {
                        currentBugPosition = bugPath31;
                        break findCurrentBugPosition;
                    }
                }
                
                case 30: {
                    if (bugPath30.distanceSquaredTo(myloc) <= GameConstants.VISION_RADIUS_SQUARED) {
                        currentBugPosition = bugPath30;
                        break findCurrentBugPosition;
                    }
                }
                
                case 29: {
                    if (bugPath29.distanceSquaredTo(myloc) <= GameConstants.VISION_RADIUS_SQUARED) {
                        currentBugPosition = bugPath29;
                        break findCurrentBugPosition;
                    }
                }
                
                case 28: {
                    if (bugPath28.distanceSquaredTo(myloc) <= GameConstants.VISION_RADIUS_SQUARED) {
                        currentBugPosition = bugPath28;
                        break findCurrentBugPosition;
                    }
                }
                
                case 27: {
                    if (bugPath27.distanceSquaredTo(myloc) <= GameConstants.VISION_RADIUS_SQUARED) {
                        currentBugPosition = bugPath27;
                        break findCurrentBugPosition;
                    }
                }
                
                case 26: {
                    if (bugPath26.distanceSquaredTo(myloc) <= GameConstants.VISION_RADIUS_SQUARED) {
                        currentBugPosition = bugPath26;
                        break findCurrentBugPosition;
                    }
                }
                
                case 25: {
                    if (bugPath25.distanceSquaredTo(myloc) <= GameConstants.VISION_RADIUS_SQUARED) {
                        currentBugPosition = bugPath25;
                        break findCurrentBugPosition;
                    }
                }
                
                case 24: {
                    if (bugPath24.distanceSquaredTo(myloc) <= GameConstants.VISION_RADIUS_SQUARED) {
                        currentBugPosition = bugPath24;
                        break findCurrentBugPosition;
                    }
                }
                
                case 23: {
                    if (bugPath23.distanceSquaredTo(myloc) <= GameConstants.VISION_RADIUS_SQUARED) {
                        currentBugPosition = bugPath23;
                        break findCurrentBugPosition;
                    }
                }
                
                case 22: {
                    if (bugPath22.distanceSquaredTo(myloc) <= GameConstants.VISION_RADIUS_SQUARED) {
                        currentBugPosition = bugPath22;
                        break findCurrentBugPosition;
                    }
                }
                
                case 21: {
                    if (bugPath21.distanceSquaredTo(myloc) <= GameConstants.VISION_RADIUS_SQUARED) {
                        currentBugPosition = bugPath21;
                        break findCurrentBugPosition;
                    }
                }
                
                case 20: {
                    if (bugPath20.distanceSquaredTo(myloc) <= GameConstants.VISION_RADIUS_SQUARED) {
                        currentBugPosition = bugPath20;
                        break findCurrentBugPosition;
                    }
                }
                
                case 19: {
                    if (bugPath19.distanceSquaredTo(myloc) <= GameConstants.VISION_RADIUS_SQUARED) {
                        currentBugPosition = bugPath19;
                        break findCurrentBugPosition;
                    }
                }
                
                case 18: {
                    if (bugPath18.distanceSquaredTo(myloc) <= GameConstants.VISION_RADIUS_SQUARED) {
                        currentBugPosition = bugPath18;
                        break findCurrentBugPosition;
                    }
                }
                
                case 17: {
                    if (bugPath17.distanceSquaredTo(myloc) <= GameConstants.VISION_RADIUS_SQUARED) {
                        currentBugPosition = bugPath17;
                        break findCurrentBugPosition;
                    }
                }
                
                case 16: {
                    if (bugPath16.distanceSquaredTo(myloc) <= GameConstants.VISION_RADIUS_SQUARED) {
                        currentBugPosition = bugPath16;
                        break findCurrentBugPosition;
                    }
                }
                
                case 15: {
                    if (bugPath15.distanceSquaredTo(myloc) <= GameConstants.VISION_RADIUS_SQUARED) {
                        currentBugPosition = bugPath15;
                        break findCurrentBugPosition;
                    }
                }
                
                case 14: {
                    if (bugPath14.distanceSquaredTo(myloc) <= GameConstants.VISION_RADIUS_SQUARED) {
                        currentBugPosition = bugPath14;
                        break findCurrentBugPosition;
                    }
                }
                
                case 13: {
                    if (bugPath13.distanceSquaredTo(myloc) <= GameConstants.VISION_RADIUS_SQUARED) {
                        currentBugPosition = bugPath13;
                        break findCurrentBugPosition;
                    }
                }
                
                case 12: {
                    if (bugPath12.distanceSquaredTo(myloc) <= GameConstants.VISION_RADIUS_SQUARED) {
                        currentBugPosition = bugPath12;
                        break findCurrentBugPosition;
                    }
                }
                
                case 11: {
                    if (bugPath11.distanceSquaredTo(myloc) <= GameConstants.VISION_RADIUS_SQUARED) {
                        currentBugPosition = bugPath11;
                        break findCurrentBugPosition;
                    }
                }
                
                case 10: {
                    if (bugPath10.distanceSquaredTo(myloc) <= GameConstants.VISION_RADIUS_SQUARED) {
                        currentBugPosition = bugPath10;
                        break findCurrentBugPosition;
                    }
                }
                
                case 9: {
                    if (bugPath9.distanceSquaredTo(myloc) <= GameConstants.VISION_RADIUS_SQUARED) {
                        currentBugPosition = bugPath9;
                        break findCurrentBugPosition;
                    }
                }
                
                case 8: {
                    if (bugPath8.distanceSquaredTo(myloc) <= GameConstants.VISION_RADIUS_SQUARED) {
                        currentBugPosition = bugPath8;
                        break findCurrentBugPosition;
                    }
                }
                
                case 7: {
                    if (bugPath7.distanceSquaredTo(myloc) <= GameConstants.VISION_RADIUS_SQUARED) {
                        currentBugPosition = bugPath7;
                        break findCurrentBugPosition;
                    }
                }
                
                case 6: {
                    if (bugPath6.distanceSquaredTo(myloc) <= GameConstants.VISION_RADIUS_SQUARED) {
                        currentBugPosition = bugPath6;
                        break findCurrentBugPosition;
                    }
                }
                
                case 5: {
                    if (bugPath5.distanceSquaredTo(myloc) <= GameConstants.VISION_RADIUS_SQUARED) {
                        currentBugPosition = bugPath5;
                        break findCurrentBugPosition;
                    }
                }
                
                case 4: {
                    if (bugPath4.distanceSquaredTo(myloc) <= GameConstants.VISION_RADIUS_SQUARED) {
                        currentBugPosition = bugPath4;
                        break findCurrentBugPosition;
                    }
                }
                
                case 3: {
                    if (bugPath3.distanceSquaredTo(myloc) <= GameConstants.VISION_RADIUS_SQUARED) {
                        currentBugPosition = bugPath3;
                        break findCurrentBugPosition;
                    }
                }
                
                case 2: {
                    if (bugPath2.distanceSquaredTo(myloc) <= GameConstants.VISION_RADIUS_SQUARED) {
                        currentBugPosition = bugPath2;
                        break findCurrentBugPosition;
                    }
                }
                
                case 1: {
                    if (bugPath1.distanceSquaredTo(myloc) <= GameConstants.VISION_RADIUS_SQUARED) {
                        currentBugPosition = bugPath1;
                        break findCurrentBugPosition;
                    }
                }
                
                case 0: {
                    if (bugPath0.distanceSquaredTo(myloc) <= GameConstants.VISION_RADIUS_SQUARED) {
                        currentBugPosition = bugPath0;
                        break findCurrentBugPosition;
                    }
                }
                
                default: {
                    assert(pathLength <= 500);
                }
            }
        }
        if (currentBugPosition == null) {
            resetPathing(currentTarget);
        }
    }

    public static MapLocation currentBugPosition = null;
    public static Direction currentBugDirection = null;
    public static void pathTo(MapLocation target) throws GameActionException {
        if (!rc.isMovementReady()) return;

        // Simple cases that shouldn't require the full call.
        myloc = rc.getLocation();
        if (myloc.equals(target)) return;
        if (myloc.isAdjacentTo(target)) {
            if (rc.canMove(myloc.directionTo(target))) {
                Pathing.move(myloc.directionTo(target));
            }
            return;
        }

        int count = Clock.getBytecodeNum();
        rc.setIndicatorDot(target, 0, 0, 255);
        if (currentTarget == null || !target.equals(currentTarget)) {
            resetPathing(target);
        } else {
            setCurrentPosition();
        }
        
        rc.setIndicatorDot(currentBugPosition, 0, 255, 0);
        doneSimulating = currentBugPosition.equals(target);
        bugLoop: {
            
            if (doneSimulating || currentBugPosition.equals(target)) break bugLoop;
            if (shouldBug) {
                bug();
            } else {
                greedy();
            }
            appendCurrentPosition();
            
            if (doneSimulating || currentBugPosition.equals(target)) break bugLoop;
            if (shouldBug) {
                bug();
            } else {
                greedy();
            }
            appendCurrentPosition();
            
            if (doneSimulating || currentBugPosition.equals(target)) break bugLoop;
            if (shouldBug) {
                bug();
            } else {
                greedy();
            }
            appendCurrentPosition();
            
            if (doneSimulating || currentBugPosition.equals(target)) break bugLoop;
            if (shouldBug) {
                bug();
            } else {
                greedy();
            }
            appendCurrentPosition();
            
            if (doneSimulating || currentBugPosition.equals(target)) break bugLoop;
            if (shouldBug) {
                bug();
            } else {
                greedy();
            }
            appendCurrentPosition();
            
            if (doneSimulating || currentBugPosition.equals(target)) break bugLoop;
            if (shouldBug) {
                bug();
            } else {
                greedy();
            }
            appendCurrentPosition();
            
            if (doneSimulating || currentBugPosition.equals(target)) break bugLoop;
            if (shouldBug) {
                bug();
            } else {
                greedy();
            }
            appendCurrentPosition();
            
            if (doneSimulating || currentBugPosition.equals(target)) break bugLoop;
            if (shouldBug) {
                bug();
            } else {
                greedy();
            }
            appendCurrentPosition();
            
            if (doneSimulating || currentBugPosition.equals(target)) break bugLoop;
            if (shouldBug) {
                bug();
            } else {
                greedy();
            }
            appendCurrentPosition();
            
            if (doneSimulating || currentBugPosition.equals(target)) break bugLoop;
            if (shouldBug) {
                bug();
            } else {
                greedy();
            }
            appendCurrentPosition();
            
        }
        rc.setIndicatorDot(currentBugPosition, 0, 255, 255);

        long localMask0 = 0;
        long localMask1 = 0;
        int index = ((currentBugPosition.y - (myloc.y - 4)) * 9)
                   + (currentBugPosition.x - (myloc.x - 4));
        if (index >= 63) {
            localMask1 = 1L << (index - 63);
        } else {
            localMask0 = 1L << index;
        }

        long temp;
        long adjIntersection;
        // 0b000000000
        //   000111000
        //   000111000
        //   000111000
        //   000000000
        //   000000000
        //   000000000L;
        long adjTiles = 0b000000000000111000000111000000111000000000000000000000000000000L;
        long mask0 = 0x7FFFFFFFFFFFFFFFL;
        long mask1 = 0x3FFFFL;
        long loverflow = 0x7fbfdfeff7fbfdfeL;
        long roverflow = 0x3fdfeff7fbfdfeffL;

        // Seen mask.
        // 111111111
        // 111111111
        // 111111111
        // 111111111
        // 111111111
        // 011111110
        // 001111100
        long passible0 = (~(
              ((long)(TileLoader.local_wall6 | TileLoader.local_ruin6) << 54)
            | ((long)(TileLoader.local_wall5 | TileLoader.local_ruin5) << 45)
            | ((long)(TileLoader.local_wall4 | TileLoader.local_ruin4) << 36)
            | ((long)(TileLoader.local_wall3 | TileLoader.local_ruin3) << 27)
            | ((long)(TileLoader.local_wall2 | TileLoader.local_ruin2) << 18)
            | ((long)(TileLoader.local_wall1 | TileLoader.local_ruin1) << 9)
            | ((long)(TileLoader.local_wall0 | TileLoader.local_ruin0))
        ) | localMask0) & 0b111111111111111111111111111111111111111111111011111110001111100L;

        long passible1 = (~(
              ((long)(TileLoader.local_wall8) << 9)
            | ((long)(TileLoader.local_wall7))
        ) | localMask1) & 0b001111100011111110L;

        
        
        int dist00 = 10000;
        
        int dist01 = 10000;
        
        int dist02 = 10000;
        
        
        
        int dist10 = 10000;
        
        int dist11 = 10000;
        
        int dist12 = 10000;
        
        
        
        int dist20 = 10000;
        
        int dist21 = 10000;
        
        int dist22 = 10000;
        
        

        // Run a BFS
        long mask0AndPassible = mask0 & passible0;
        long mask1AndPassible = mask1 & passible1;
        bfsLoop: {
            
            
            adjIntersection = (localMask0 & adjTiles);

            if (adjIntersection == (passible0 & adjTiles)) break bfsLoop;
            
            
            
            
            if ((0x40000000L & adjIntersection) != 0) { 
                dist00 = Math.min(dist00, 0);
            }
            
            
            
            if ((0x8000000000L & adjIntersection) != 0) { 
                dist01 = Math.min(dist01, 0);
            }
            
            
            
            if ((0x1000000000000L & adjIntersection) != 0) { 
                dist02 = Math.min(dist02, 0);
            }
            
            
            
            
            
            if ((0x80000000L & adjIntersection) != 0) { 
                dist10 = Math.min(dist10, 0);
            }
            
            
            
            if ((0x10000000000L & adjIntersection) != 0) { 
                dist11 = Math.min(dist11, 0);
            }
            
            
            
            if ((0x2000000000000L & adjIntersection) != 0) { 
                dist12 = Math.min(dist12, 0);
            }
            
            
            
            
            
            if ((0x100000000L & adjIntersection) != 0) { 
                dist20 = Math.min(dist20, 0);
            }
            
            
            
            if ((0x20000000000L & adjIntersection) != 0) { 
                dist21 = Math.min(dist21, 0);
            }
            
            
            
            if ((0x4000000000000L & adjIntersection) != 0) { 
                dist22 = Math.min(dist22, 0);
            }
            
            
            localMask0 = (localMask0 | ((localMask0 << 1) & loverflow) | ((localMask0 >>> 1) & roverflow));
            localMask1 = (localMask1 | ((localMask1 << 1) & loverflow) | ((localMask1 >>> 1) & roverflow));
            temp = localMask0;
            localMask0 = (localMask0 | (localMask0 << 9) | (localMask0 >>> 9)
                       | (localMask1 << 54)) & mask0AndPassible;
            localMask1 = (localMask1 | (localMask1 << 9) | (localMask1 >>> 9)
                       | (temp >>> 54)) & mask1AndPassible;
            
            
            adjIntersection = (localMask0 & adjTiles);

            if (adjIntersection == (passible0 & adjTiles)) break bfsLoop;
            
            
            
            
            if ((0x40000000L & adjIntersection) != 0) { 
                dist00 = Math.min(dist00, 1);
            }
            
            
            
            if ((0x8000000000L & adjIntersection) != 0) { 
                dist01 = Math.min(dist01, 1);
            }
            
            
            
            if ((0x1000000000000L & adjIntersection) != 0) { 
                dist02 = Math.min(dist02, 1);
            }
            
            
            
            
            
            if ((0x80000000L & adjIntersection) != 0) { 
                dist10 = Math.min(dist10, 1);
            }
            
            
            
            if ((0x10000000000L & adjIntersection) != 0) { 
                dist11 = Math.min(dist11, 1);
            }
            
            
            
            if ((0x2000000000000L & adjIntersection) != 0) { 
                dist12 = Math.min(dist12, 1);
            }
            
            
            
            
            
            if ((0x100000000L & adjIntersection) != 0) { 
                dist20 = Math.min(dist20, 1);
            }
            
            
            
            if ((0x20000000000L & adjIntersection) != 0) { 
                dist21 = Math.min(dist21, 1);
            }
            
            
            
            if ((0x4000000000000L & adjIntersection) != 0) { 
                dist22 = Math.min(dist22, 1);
            }
            
            
            localMask0 = (localMask0 | ((localMask0 << 1) & loverflow) | ((localMask0 >>> 1) & roverflow));
            localMask1 = (localMask1 | ((localMask1 << 1) & loverflow) | ((localMask1 >>> 1) & roverflow));
            temp = localMask0;
            localMask0 = (localMask0 | (localMask0 << 9) | (localMask0 >>> 9)
                       | (localMask1 << 54)) & mask0AndPassible;
            localMask1 = (localMask1 | (localMask1 << 9) | (localMask1 >>> 9)
                       | (temp >>> 54)) & mask1AndPassible;
            
            
            adjIntersection = (localMask0 & adjTiles);

            if (adjIntersection == (passible0 & adjTiles)) break bfsLoop;
            
            
            
            
            if ((0x40000000L & adjIntersection) != 0) { 
                dist00 = Math.min(dist00, 2);
            }
            
            
            
            if ((0x8000000000L & adjIntersection) != 0) { 
                dist01 = Math.min(dist01, 2);
            }
            
            
            
            if ((0x1000000000000L & adjIntersection) != 0) { 
                dist02 = Math.min(dist02, 2);
            }
            
            
            
            
            
            if ((0x80000000L & adjIntersection) != 0) { 
                dist10 = Math.min(dist10, 2);
            }
            
            
            
            if ((0x10000000000L & adjIntersection) != 0) { 
                dist11 = Math.min(dist11, 2);
            }
            
            
            
            if ((0x2000000000000L & adjIntersection) != 0) { 
                dist12 = Math.min(dist12, 2);
            }
            
            
            
            
            
            if ((0x100000000L & adjIntersection) != 0) { 
                dist20 = Math.min(dist20, 2);
            }
            
            
            
            if ((0x20000000000L & adjIntersection) != 0) { 
                dist21 = Math.min(dist21, 2);
            }
            
            
            
            if ((0x4000000000000L & adjIntersection) != 0) { 
                dist22 = Math.min(dist22, 2);
            }
            
            
            localMask0 = (localMask0 | ((localMask0 << 1) & loverflow) | ((localMask0 >>> 1) & roverflow));
            localMask1 = (localMask1 | ((localMask1 << 1) & loverflow) | ((localMask1 >>> 1) & roverflow));
            temp = localMask0;
            localMask0 = (localMask0 | (localMask0 << 9) | (localMask0 >>> 9)
                       | (localMask1 << 54)) & mask0AndPassible;
            localMask1 = (localMask1 | (localMask1 << 9) | (localMask1 >>> 9)
                       | (temp >>> 54)) & mask1AndPassible;
            
            
            adjIntersection = (localMask0 & adjTiles);

            if (adjIntersection == (passible0 & adjTiles)) break bfsLoop;
            
            
            
            
            if ((0x40000000L & adjIntersection) != 0) { 
                dist00 = Math.min(dist00, 3);
            }
            
            
            
            if ((0x8000000000L & adjIntersection) != 0) { 
                dist01 = Math.min(dist01, 3);
            }
            
            
            
            if ((0x1000000000000L & adjIntersection) != 0) { 
                dist02 = Math.min(dist02, 3);
            }
            
            
            
            
            
            if ((0x80000000L & adjIntersection) != 0) { 
                dist10 = Math.min(dist10, 3);
            }
            
            
            
            if ((0x10000000000L & adjIntersection) != 0) { 
                dist11 = Math.min(dist11, 3);
            }
            
            
            
            if ((0x2000000000000L & adjIntersection) != 0) { 
                dist12 = Math.min(dist12, 3);
            }
            
            
            
            
            
            if ((0x100000000L & adjIntersection) != 0) { 
                dist20 = Math.min(dist20, 3);
            }
            
            
            
            if ((0x20000000000L & adjIntersection) != 0) { 
                dist21 = Math.min(dist21, 3);
            }
            
            
            
            if ((0x4000000000000L & adjIntersection) != 0) { 
                dist22 = Math.min(dist22, 3);
            }
            
            
            localMask0 = (localMask0 | ((localMask0 << 1) & loverflow) | ((localMask0 >>> 1) & roverflow));
            localMask1 = (localMask1 | ((localMask1 << 1) & loverflow) | ((localMask1 >>> 1) & roverflow));
            temp = localMask0;
            localMask0 = (localMask0 | (localMask0 << 9) | (localMask0 >>> 9)
                       | (localMask1 << 54)) & mask0AndPassible;
            localMask1 = (localMask1 | (localMask1 << 9) | (localMask1 >>> 9)
                       | (temp >>> 54)) & mask1AndPassible;
            
            
            adjIntersection = (localMask0 & adjTiles);

            if (adjIntersection == (passible0 & adjTiles)) break bfsLoop;
            
            
            
            
            if ((0x40000000L & adjIntersection) != 0) { 
                dist00 = Math.min(dist00, 4);
            }
            
            
            
            if ((0x8000000000L & adjIntersection) != 0) { 
                dist01 = Math.min(dist01, 4);
            }
            
            
            
            if ((0x1000000000000L & adjIntersection) != 0) { 
                dist02 = Math.min(dist02, 4);
            }
            
            
            
            
            
            if ((0x80000000L & adjIntersection) != 0) { 
                dist10 = Math.min(dist10, 4);
            }
            
            
            
            if ((0x10000000000L & adjIntersection) != 0) { 
                dist11 = Math.min(dist11, 4);
            }
            
            
            
            if ((0x2000000000000L & adjIntersection) != 0) { 
                dist12 = Math.min(dist12, 4);
            }
            
            
            
            
            
            if ((0x100000000L & adjIntersection) != 0) { 
                dist20 = Math.min(dist20, 4);
            }
            
            
            
            if ((0x20000000000L & adjIntersection) != 0) { 
                dist21 = Math.min(dist21, 4);
            }
            
            
            
            if ((0x4000000000000L & adjIntersection) != 0) { 
                dist22 = Math.min(dist22, 4);
            }
            
            
            localMask0 = (localMask0 | ((localMask0 << 1) & loverflow) | ((localMask0 >>> 1) & roverflow));
            localMask1 = (localMask1 | ((localMask1 << 1) & loverflow) | ((localMask1 >>> 1) & roverflow));
            temp = localMask0;
            localMask0 = (localMask0 | (localMask0 << 9) | (localMask0 >>> 9)
                       | (localMask1 << 54)) & mask0AndPassible;
            localMask1 = (localMask1 | (localMask1 << 9) | (localMask1 >>> 9)
                       | (temp >>> 54)) & mask1AndPassible;
            
            
            adjIntersection = (localMask0 & adjTiles);

            if (adjIntersection == (passible0 & adjTiles)) break bfsLoop;
            
            
            
            
            if ((0x40000000L & adjIntersection) != 0) { 
                dist00 = Math.min(dist00, 5);
            }
            
            
            
            if ((0x8000000000L & adjIntersection) != 0) { 
                dist01 = Math.min(dist01, 5);
            }
            
            
            
            if ((0x1000000000000L & adjIntersection) != 0) { 
                dist02 = Math.min(dist02, 5);
            }
            
            
            
            
            
            if ((0x80000000L & adjIntersection) != 0) { 
                dist10 = Math.min(dist10, 5);
            }
            
            
            
            if ((0x10000000000L & adjIntersection) != 0) { 
                dist11 = Math.min(dist11, 5);
            }
            
            
            
            if ((0x2000000000000L & adjIntersection) != 0) { 
                dist12 = Math.min(dist12, 5);
            }
            
            
            
            
            
            if ((0x100000000L & adjIntersection) != 0) { 
                dist20 = Math.min(dist20, 5);
            }
            
            
            
            if ((0x20000000000L & adjIntersection) != 0) { 
                dist21 = Math.min(dist21, 5);
            }
            
            
            
            if ((0x4000000000000L & adjIntersection) != 0) { 
                dist22 = Math.min(dist22, 5);
            }
            
            
            localMask0 = (localMask0 | ((localMask0 << 1) & loverflow) | ((localMask0 >>> 1) & roverflow));
            localMask1 = (localMask1 | ((localMask1 << 1) & loverflow) | ((localMask1 >>> 1) & roverflow));
            temp = localMask0;
            localMask0 = (localMask0 | (localMask0 << 9) | (localMask0 >>> 9)
                       | (localMask1 << 54)) & mask0AndPassible;
            localMask1 = (localMask1 | (localMask1 << 9) | (localMask1 >>> 9)
                       | (temp >>> 54)) & mask1AndPassible;
            
            
            adjIntersection = (localMask0 & adjTiles);

            if (adjIntersection == (passible0 & adjTiles)) break bfsLoop;
            
            
            
            
            if ((0x40000000L & adjIntersection) != 0) { 
                dist00 = Math.min(dist00, 6);
            }
            
            
            
            if ((0x8000000000L & adjIntersection) != 0) { 
                dist01 = Math.min(dist01, 6);
            }
            
            
            
            if ((0x1000000000000L & adjIntersection) != 0) { 
                dist02 = Math.min(dist02, 6);
            }
            
            
            
            
            
            if ((0x80000000L & adjIntersection) != 0) { 
                dist10 = Math.min(dist10, 6);
            }
            
            
            
            if ((0x10000000000L & adjIntersection) != 0) { 
                dist11 = Math.min(dist11, 6);
            }
            
            
            
            if ((0x2000000000000L & adjIntersection) != 0) { 
                dist12 = Math.min(dist12, 6);
            }
            
            
            
            
            
            if ((0x100000000L & adjIntersection) != 0) { 
                dist20 = Math.min(dist20, 6);
            }
            
            
            
            if ((0x20000000000L & adjIntersection) != 0) { 
                dist21 = Math.min(dist21, 6);
            }
            
            
            
            if ((0x4000000000000L & adjIntersection) != 0) { 
                dist22 = Math.min(dist22, 6);
            }
            
            
            localMask0 = (localMask0 | ((localMask0 << 1) & loverflow) | ((localMask0 >>> 1) & roverflow));
            localMask1 = (localMask1 | ((localMask1 << 1) & loverflow) | ((localMask1 >>> 1) & roverflow));
            temp = localMask0;
            localMask0 = (localMask0 | (localMask0 << 9) | (localMask0 >>> 9)
                       | (localMask1 << 54)) & mask0AndPassible;
            localMask1 = (localMask1 | (localMask1 << 9) | (localMask1 >>> 9)
                       | (temp >>> 54)) & mask1AndPassible;
            
            
            adjIntersection = (localMask0 & adjTiles);

            if (adjIntersection == (passible0 & adjTiles)) break bfsLoop;
            
            
            
            
            if ((0x40000000L & adjIntersection) != 0) { 
                dist00 = Math.min(dist00, 7);
            }
            
            
            
            if ((0x8000000000L & adjIntersection) != 0) { 
                dist01 = Math.min(dist01, 7);
            }
            
            
            
            if ((0x1000000000000L & adjIntersection) != 0) { 
                dist02 = Math.min(dist02, 7);
            }
            
            
            
            
            
            if ((0x80000000L & adjIntersection) != 0) { 
                dist10 = Math.min(dist10, 7);
            }
            
            
            
            if ((0x10000000000L & adjIntersection) != 0) { 
                dist11 = Math.min(dist11, 7);
            }
            
            
            
            if ((0x2000000000000L & adjIntersection) != 0) { 
                dist12 = Math.min(dist12, 7);
            }
            
            
            
            
            
            if ((0x100000000L & adjIntersection) != 0) { 
                dist20 = Math.min(dist20, 7);
            }
            
            
            
            if ((0x20000000000L & adjIntersection) != 0) { 
                dist21 = Math.min(dist21, 7);
            }
            
            
            
            if ((0x4000000000000L & adjIntersection) != 0) { 
                dist22 = Math.min(dist22, 7);
            }
            
            
            localMask0 = (localMask0 | ((localMask0 << 1) & loverflow) | ((localMask0 >>> 1) & roverflow));
            localMask1 = (localMask1 | ((localMask1 << 1) & loverflow) | ((localMask1 >>> 1) & roverflow));
            temp = localMask0;
            localMask0 = (localMask0 | (localMask0 << 9) | (localMask0 >>> 9)
                       | (localMask1 << 54)) & mask0AndPassible;
            localMask1 = (localMask1 | (localMask1 << 9) | (localMask1 >>> 9)
                       | (temp >>> 54)) & mask1AndPassible;
            
            
            adjIntersection = (localMask0 & adjTiles);

            if (adjIntersection == (passible0 & adjTiles)) break bfsLoop;
            
            
            
            
            if ((0x40000000L & adjIntersection) != 0) { 
                dist00 = Math.min(dist00, 8);
            }
            
            
            
            if ((0x8000000000L & adjIntersection) != 0) { 
                dist01 = Math.min(dist01, 8);
            }
            
            
            
            if ((0x1000000000000L & adjIntersection) != 0) { 
                dist02 = Math.min(dist02, 8);
            }
            
            
            
            
            
            if ((0x80000000L & adjIntersection) != 0) { 
                dist10 = Math.min(dist10, 8);
            }
            
            
            
            if ((0x10000000000L & adjIntersection) != 0) { 
                dist11 = Math.min(dist11, 8);
            }
            
            
            
            if ((0x2000000000000L & adjIntersection) != 0) { 
                dist12 = Math.min(dist12, 8);
            }
            
            
            
            
            
            if ((0x100000000L & adjIntersection) != 0) { 
                dist20 = Math.min(dist20, 8);
            }
            
            
            
            if ((0x20000000000L & adjIntersection) != 0) { 
                dist21 = Math.min(dist21, 8);
            }
            
            
            
            if ((0x4000000000000L & adjIntersection) != 0) { 
                dist22 = Math.min(dist22, 8);
            }
            
            
            localMask0 = (localMask0 | ((localMask0 << 1) & loverflow) | ((localMask0 >>> 1) & roverflow));
            localMask1 = (localMask1 | ((localMask1 << 1) & loverflow) | ((localMask1 >>> 1) & roverflow));
            temp = localMask0;
            localMask0 = (localMask0 | (localMask0 << 9) | (localMask0 >>> 9)
                       | (localMask1 << 54)) & mask0AndPassible;
            localMask1 = (localMask1 | (localMask1 << 9) | (localMask1 >>> 9)
                       | (temp >>> 54)) & mask1AndPassible;
            
            
            adjIntersection = (localMask0 & adjTiles);

            if (adjIntersection == (passible0 & adjTiles)) break bfsLoop;
            
            
            
            
            if ((0x40000000L & adjIntersection) != 0) { 
                dist00 = Math.min(dist00, 9);
            }
            
            
            
            if ((0x8000000000L & adjIntersection) != 0) { 
                dist01 = Math.min(dist01, 9);
            }
            
            
            
            if ((0x1000000000000L & adjIntersection) != 0) { 
                dist02 = Math.min(dist02, 9);
            }
            
            
            
            
            
            if ((0x80000000L & adjIntersection) != 0) { 
                dist10 = Math.min(dist10, 9);
            }
            
            
            
            if ((0x10000000000L & adjIntersection) != 0) { 
                dist11 = Math.min(dist11, 9);
            }
            
            
            
            if ((0x2000000000000L & adjIntersection) != 0) { 
                dist12 = Math.min(dist12, 9);
            }
            
            
            
            
            
            if ((0x100000000L & adjIntersection) != 0) { 
                dist20 = Math.min(dist20, 9);
            }
            
            
            
            if ((0x20000000000L & adjIntersection) != 0) { 
                dist21 = Math.min(dist21, 9);
            }
            
            
            
            if ((0x4000000000000L & adjIntersection) != 0) { 
                dist22 = Math.min(dist22, 9);
            }
            
            
            localMask0 = (localMask0 | ((localMask0 << 1) & loverflow) | ((localMask0 >>> 1) & roverflow));
            localMask1 = (localMask1 | ((localMask1 << 1) & loverflow) | ((localMask1 >>> 1) & roverflow));
            temp = localMask0;
            localMask0 = (localMask0 | (localMask0 << 9) | (localMask0 >>> 9)
                       | (localMask1 << 54)) & mask0AndPassible;
            localMask1 = (localMask1 | (localMask1 << 9) | (localMask1 >>> 9)
                       | (temp >>> 54)) & mask1AndPassible;
            
            
            adjIntersection = (localMask0 & adjTiles);

            if (adjIntersection == (passible0 & adjTiles)) break bfsLoop;
            
            
            
            
            if ((0x40000000L & adjIntersection) != 0) { 
                dist00 = Math.min(dist00, 10);
            }
            
            
            
            if ((0x8000000000L & adjIntersection) != 0) { 
                dist01 = Math.min(dist01, 10);
            }
            
            
            
            if ((0x1000000000000L & adjIntersection) != 0) { 
                dist02 = Math.min(dist02, 10);
            }
            
            
            
            
            
            if ((0x80000000L & adjIntersection) != 0) { 
                dist10 = Math.min(dist10, 10);
            }
            
            
            
            if ((0x10000000000L & adjIntersection) != 0) { 
                dist11 = Math.min(dist11, 10);
            }
            
            
            
            if ((0x2000000000000L & adjIntersection) != 0) { 
                dist12 = Math.min(dist12, 10);
            }
            
            
            
            
            
            if ((0x100000000L & adjIntersection) != 0) { 
                dist20 = Math.min(dist20, 10);
            }
            
            
            
            if ((0x20000000000L & adjIntersection) != 0) { 
                dist21 = Math.min(dist21, 10);
            }
            
            
            
            if ((0x4000000000000L & adjIntersection) != 0) { 
                dist22 = Math.min(dist22, 10);
            }
            
            
            localMask0 = (localMask0 | ((localMask0 << 1) & loverflow) | ((localMask0 >>> 1) & roverflow));
            localMask1 = (localMask1 | ((localMask1 << 1) & loverflow) | ((localMask1 >>> 1) & roverflow));
            temp = localMask0;
            localMask0 = (localMask0 | (localMask0 << 9) | (localMask0 >>> 9)
                       | (localMask1 << 54)) & mask0AndPassible;
            localMask1 = (localMask1 | (localMask1 << 9) | (localMask1 >>> 9)
                       | (temp >>> 54)) & mask1AndPassible;
            
            
            adjIntersection = (localMask0 & adjTiles);

            if (adjIntersection == (passible0 & adjTiles)) break bfsLoop;
            
            
            
            
            if ((0x40000000L & adjIntersection) != 0) { 
                dist00 = Math.min(dist00, 11);
            }
            
            
            
            if ((0x8000000000L & adjIntersection) != 0) { 
                dist01 = Math.min(dist01, 11);
            }
            
            
            
            if ((0x1000000000000L & adjIntersection) != 0) { 
                dist02 = Math.min(dist02, 11);
            }
            
            
            
            
            
            if ((0x80000000L & adjIntersection) != 0) { 
                dist10 = Math.min(dist10, 11);
            }
            
            
            
            if ((0x10000000000L & adjIntersection) != 0) { 
                dist11 = Math.min(dist11, 11);
            }
            
            
            
            if ((0x2000000000000L & adjIntersection) != 0) { 
                dist12 = Math.min(dist12, 11);
            }
            
            
            
            
            
            if ((0x100000000L & adjIntersection) != 0) { 
                dist20 = Math.min(dist20, 11);
            }
            
            
            
            if ((0x20000000000L & adjIntersection) != 0) { 
                dist21 = Math.min(dist21, 11);
            }
            
            
            
            if ((0x4000000000000L & adjIntersection) != 0) { 
                dist22 = Math.min(dist22, 11);
            }
            
            
            localMask0 = (localMask0 | ((localMask0 << 1) & loverflow) | ((localMask0 >>> 1) & roverflow));
            localMask1 = (localMask1 | ((localMask1 << 1) & loverflow) | ((localMask1 >>> 1) & roverflow));
            temp = localMask0;
            localMask0 = (localMask0 | (localMask0 << 9) | (localMask0 >>> 9)
                       | (localMask1 << 54)) & mask0AndPassible;
            localMask1 = (localMask1 | (localMask1 << 9) | (localMask1 >>> 9)
                       | (temp >>> 54)) & mask1AndPassible;
            
            
            adjIntersection = (localMask0 & adjTiles);

            if (adjIntersection == (passible0 & adjTiles)) break bfsLoop;
            
            
            
            
            if ((0x40000000L & adjIntersection) != 0) { 
                dist00 = Math.min(dist00, 12);
            }
            
            
            
            if ((0x8000000000L & adjIntersection) != 0) { 
                dist01 = Math.min(dist01, 12);
            }
            
            
            
            if ((0x1000000000000L & adjIntersection) != 0) { 
                dist02 = Math.min(dist02, 12);
            }
            
            
            
            
            
            if ((0x80000000L & adjIntersection) != 0) { 
                dist10 = Math.min(dist10, 12);
            }
            
            
            
            if ((0x10000000000L & adjIntersection) != 0) { 
                dist11 = Math.min(dist11, 12);
            }
            
            
            
            if ((0x2000000000000L & adjIntersection) != 0) { 
                dist12 = Math.min(dist12, 12);
            }
            
            
            
            
            
            if ((0x100000000L & adjIntersection) != 0) { 
                dist20 = Math.min(dist20, 12);
            }
            
            
            
            if ((0x20000000000L & adjIntersection) != 0) { 
                dist21 = Math.min(dist21, 12);
            }
            
            
            
            if ((0x4000000000000L & adjIntersection) != 0) { 
                dist22 = Math.min(dist22, 12);
            }
            
            
            localMask0 = (localMask0 | ((localMask0 << 1) & loverflow) | ((localMask0 >>> 1) & roverflow));
            localMask1 = (localMask1 | ((localMask1 << 1) & loverflow) | ((localMask1 >>> 1) & roverflow));
            temp = localMask0;
            localMask0 = (localMask0 | (localMask0 << 9) | (localMask0 >>> 9)
                       | (localMask1 << 54)) & mask0AndPassible;
            localMask1 = (localMask1 | (localMask1 << 9) | (localMask1 >>> 9)
                       | (temp >>> 54)) & mask1AndPassible;
            
            
            adjIntersection = (localMask0 & adjTiles);

            if (adjIntersection == (passible0 & adjTiles)) break bfsLoop;
            
            
            
            
            if ((0x40000000L & adjIntersection) != 0) { 
                dist00 = Math.min(dist00, 13);
            }
            
            
            
            if ((0x8000000000L & adjIntersection) != 0) { 
                dist01 = Math.min(dist01, 13);
            }
            
            
            
            if ((0x1000000000000L & adjIntersection) != 0) { 
                dist02 = Math.min(dist02, 13);
            }
            
            
            
            
            
            if ((0x80000000L & adjIntersection) != 0) { 
                dist10 = Math.min(dist10, 13);
            }
            
            
            
            if ((0x10000000000L & adjIntersection) != 0) { 
                dist11 = Math.min(dist11, 13);
            }
            
            
            
            if ((0x2000000000000L & adjIntersection) != 0) { 
                dist12 = Math.min(dist12, 13);
            }
            
            
            
            
            
            if ((0x100000000L & adjIntersection) != 0) { 
                dist20 = Math.min(dist20, 13);
            }
            
            
            
            if ((0x20000000000L & adjIntersection) != 0) { 
                dist21 = Math.min(dist21, 13);
            }
            
            
            
            if ((0x4000000000000L & adjIntersection) != 0) { 
                dist22 = Math.min(dist22, 13);
            }
            
            
            localMask0 = (localMask0 | ((localMask0 << 1) & loverflow) | ((localMask0 >>> 1) & roverflow));
            localMask1 = (localMask1 | ((localMask1 << 1) & loverflow) | ((localMask1 >>> 1) & roverflow));
            temp = localMask0;
            localMask0 = (localMask0 | (localMask0 << 9) | (localMask0 >>> 9)
                       | (localMask1 << 54)) & mask0AndPassible;
            localMask1 = (localMask1 | (localMask1 << 9) | (localMask1 >>> 9)
                       | (temp >>> 54)) & mask1AndPassible;
            
            
            adjIntersection = (localMask0 & adjTiles);

            if (adjIntersection == (passible0 & adjTiles)) break bfsLoop;
            
            
            
            
            if ((0x40000000L & adjIntersection) != 0) { 
                dist00 = Math.min(dist00, 14);
            }
            
            
            
            if ((0x8000000000L & adjIntersection) != 0) { 
                dist01 = Math.min(dist01, 14);
            }
            
            
            
            if ((0x1000000000000L & adjIntersection) != 0) { 
                dist02 = Math.min(dist02, 14);
            }
            
            
            
            
            
            if ((0x80000000L & adjIntersection) != 0) { 
                dist10 = Math.min(dist10, 14);
            }
            
            
            
            if ((0x10000000000L & adjIntersection) != 0) { 
                dist11 = Math.min(dist11, 14);
            }
            
            
            
            if ((0x2000000000000L & adjIntersection) != 0) { 
                dist12 = Math.min(dist12, 14);
            }
            
            
            
            
            
            if ((0x100000000L & adjIntersection) != 0) { 
                dist20 = Math.min(dist20, 14);
            }
            
            
            
            if ((0x20000000000L & adjIntersection) != 0) { 
                dist21 = Math.min(dist21, 14);
            }
            
            
            
            if ((0x4000000000000L & adjIntersection) != 0) { 
                dist22 = Math.min(dist22, 14);
            }
            
            
            localMask0 = (localMask0 | ((localMask0 << 1) & loverflow) | ((localMask0 >>> 1) & roverflow));
            localMask1 = (localMask1 | ((localMask1 << 1) & loverflow) | ((localMask1 >>> 1) & roverflow));
            temp = localMask0;
            localMask0 = (localMask0 | (localMask0 << 9) | (localMask0 >>> 9)
                       | (localMask1 << 54)) & mask0AndPassible;
            localMask1 = (localMask1 | (localMask1 << 9) | (localMask1 >>> 9)
                       | (temp >>> 54)) & mask1AndPassible;
            
            
            adjIntersection = (localMask0 & adjTiles);

            if (adjIntersection == (passible0 & adjTiles)) break bfsLoop;
            
            
            
            
            if ((0x40000000L & adjIntersection) != 0) { 
                dist00 = Math.min(dist00, 15);
            }
            
            
            
            if ((0x8000000000L & adjIntersection) != 0) { 
                dist01 = Math.min(dist01, 15);
            }
            
            
            
            if ((0x1000000000000L & adjIntersection) != 0) { 
                dist02 = Math.min(dist02, 15);
            }
            
            
            
            
            
            if ((0x80000000L & adjIntersection) != 0) { 
                dist10 = Math.min(dist10, 15);
            }
            
            
            
            if ((0x10000000000L & adjIntersection) != 0) { 
                dist11 = Math.min(dist11, 15);
            }
            
            
            
            if ((0x2000000000000L & adjIntersection) != 0) { 
                dist12 = Math.min(dist12, 15);
            }
            
            
            
            
            
            if ((0x100000000L & adjIntersection) != 0) { 
                dist20 = Math.min(dist20, 15);
            }
            
            
            
            if ((0x20000000000L & adjIntersection) != 0) { 
                dist21 = Math.min(dist21, 15);
            }
            
            
            
            if ((0x4000000000000L & adjIntersection) != 0) { 
                dist22 = Math.min(dist22, 15);
            }
            
            
            localMask0 = (localMask0 | ((localMask0 << 1) & loverflow) | ((localMask0 >>> 1) & roverflow));
            localMask1 = (localMask1 | ((localMask1 << 1) & loverflow) | ((localMask1 >>> 1) & roverflow));
            temp = localMask0;
            localMask0 = (localMask0 | (localMask0 << 9) | (localMask0 >>> 9)
                       | (localMask1 << 54)) & mask0AndPassible;
            localMask1 = (localMask1 | (localMask1 << 9) | (localMask1 >>> 9)
                       | (temp >>> 54)) & mask1AndPassible;
            
            
            adjIntersection = (localMask0 & adjTiles);

            if (adjIntersection == (passible0 & adjTiles)) break bfsLoop;
            
            
            
            
            if ((0x40000000L & adjIntersection) != 0) { 
                dist00 = Math.min(dist00, 16);
            }
            
            
            
            if ((0x8000000000L & adjIntersection) != 0) { 
                dist01 = Math.min(dist01, 16);
            }
            
            
            
            if ((0x1000000000000L & adjIntersection) != 0) { 
                dist02 = Math.min(dist02, 16);
            }
            
            
            
            
            
            if ((0x80000000L & adjIntersection) != 0) { 
                dist10 = Math.min(dist10, 16);
            }
            
            
            
            if ((0x10000000000L & adjIntersection) != 0) { 
                dist11 = Math.min(dist11, 16);
            }
            
            
            
            if ((0x2000000000000L & adjIntersection) != 0) { 
                dist12 = Math.min(dist12, 16);
            }
            
            
            
            
            
            if ((0x100000000L & adjIntersection) != 0) { 
                dist20 = Math.min(dist20, 16);
            }
            
            
            
            if ((0x20000000000L & adjIntersection) != 0) { 
                dist21 = Math.min(dist21, 16);
            }
            
            
            
            if ((0x4000000000000L & adjIntersection) != 0) { 
                dist22 = Math.min(dist22, 16);
            }
            
            
            localMask0 = (localMask0 | ((localMask0 << 1) & loverflow) | ((localMask0 >>> 1) & roverflow));
            localMask1 = (localMask1 | ((localMask1 << 1) & loverflow) | ((localMask1 >>> 1) & roverflow));
            temp = localMask0;
            localMask0 = (localMask0 | (localMask0 << 9) | (localMask0 >>> 9)
                       | (localMask1 << 54)) & mask0AndPassible;
            localMask1 = (localMask1 | (localMask1 << 9) | (localMask1 >>> 9)
                       | (temp >>> 54)) & mask1AndPassible;
            
            
            adjIntersection = (localMask0 & adjTiles);

            if (adjIntersection == (passible0 & adjTiles)) break bfsLoop;
            
            
            
            
            if ((0x40000000L & adjIntersection) != 0) { 
                dist00 = Math.min(dist00, 17);
            }
            
            
            
            if ((0x8000000000L & adjIntersection) != 0) { 
                dist01 = Math.min(dist01, 17);
            }
            
            
            
            if ((0x1000000000000L & adjIntersection) != 0) { 
                dist02 = Math.min(dist02, 17);
            }
            
            
            
            
            
            if ((0x80000000L & adjIntersection) != 0) { 
                dist10 = Math.min(dist10, 17);
            }
            
            
            
            if ((0x10000000000L & adjIntersection) != 0) { 
                dist11 = Math.min(dist11, 17);
            }
            
            
            
            if ((0x2000000000000L & adjIntersection) != 0) { 
                dist12 = Math.min(dist12, 17);
            }
            
            
            
            
            
            if ((0x100000000L & adjIntersection) != 0) { 
                dist20 = Math.min(dist20, 17);
            }
            
            
            
            if ((0x20000000000L & adjIntersection) != 0) { 
                dist21 = Math.min(dist21, 17);
            }
            
            
            
            if ((0x4000000000000L & adjIntersection) != 0) { 
                dist22 = Math.min(dist22, 17);
            }
            
            
            localMask0 = (localMask0 | ((localMask0 << 1) & loverflow) | ((localMask0 >>> 1) & roverflow));
            localMask1 = (localMask1 | ((localMask1 << 1) & loverflow) | ((localMask1 >>> 1) & roverflow));
            temp = localMask0;
            localMask0 = (localMask0 | (localMask0 << 9) | (localMask0 >>> 9)
                       | (localMask1 << 54)) & mask0AndPassible;
            localMask1 = (localMask1 | (localMask1 << 9) | (localMask1 >>> 9)
                       | (temp >>> 54)) & mask1AndPassible;
            
            
            adjIntersection = (localMask0 & adjTiles);

            if (adjIntersection == (passible0 & adjTiles)) break bfsLoop;
            
            
            
            
            if ((0x40000000L & adjIntersection) != 0) { 
                dist00 = Math.min(dist00, 18);
            }
            
            
            
            if ((0x8000000000L & adjIntersection) != 0) { 
                dist01 = Math.min(dist01, 18);
            }
            
            
            
            if ((0x1000000000000L & adjIntersection) != 0) { 
                dist02 = Math.min(dist02, 18);
            }
            
            
            
            
            
            if ((0x80000000L & adjIntersection) != 0) { 
                dist10 = Math.min(dist10, 18);
            }
            
            
            
            if ((0x10000000000L & adjIntersection) != 0) { 
                dist11 = Math.min(dist11, 18);
            }
            
            
            
            if ((0x2000000000000L & adjIntersection) != 0) { 
                dist12 = Math.min(dist12, 18);
            }
            
            
            
            
            
            if ((0x100000000L & adjIntersection) != 0) { 
                dist20 = Math.min(dist20, 18);
            }
            
            
            
            if ((0x20000000000L & adjIntersection) != 0) { 
                dist21 = Math.min(dist21, 18);
            }
            
            
            
            if ((0x4000000000000L & adjIntersection) != 0) { 
                dist22 = Math.min(dist22, 18);
            }
            
            
            localMask0 = (localMask0 | ((localMask0 << 1) & loverflow) | ((localMask0 >>> 1) & roverflow));
            localMask1 = (localMask1 | ((localMask1 << 1) & loverflow) | ((localMask1 >>> 1) & roverflow));
            temp = localMask0;
            localMask0 = (localMask0 | (localMask0 << 9) | (localMask0 >>> 9)
                       | (localMask1 << 54)) & mask0AndPassible;
            localMask1 = (localMask1 | (localMask1 << 9) | (localMask1 >>> 9)
                       | (temp >>> 54)) & mask1AndPassible;
            
            
            adjIntersection = (localMask0 & adjTiles);

            if (adjIntersection == (passible0 & adjTiles)) break bfsLoop;
            
            
            
            
            if ((0x40000000L & adjIntersection) != 0) { 
                dist00 = Math.min(dist00, 19);
            }
            
            
            
            if ((0x8000000000L & adjIntersection) != 0) { 
                dist01 = Math.min(dist01, 19);
            }
            
            
            
            if ((0x1000000000000L & adjIntersection) != 0) { 
                dist02 = Math.min(dist02, 19);
            }
            
            
            
            
            
            if ((0x80000000L & adjIntersection) != 0) { 
                dist10 = Math.min(dist10, 19);
            }
            
            
            
            if ((0x10000000000L & adjIntersection) != 0) { 
                dist11 = Math.min(dist11, 19);
            }
            
            
            
            if ((0x2000000000000L & adjIntersection) != 0) { 
                dist12 = Math.min(dist12, 19);
            }
            
            
            
            
            
            if ((0x100000000L & adjIntersection) != 0) { 
                dist20 = Math.min(dist20, 19);
            }
            
            
            
            if ((0x20000000000L & adjIntersection) != 0) { 
                dist21 = Math.min(dist21, 19);
            }
            
            
            
            if ((0x4000000000000L & adjIntersection) != 0) { 
                dist22 = Math.min(dist22, 19);
            }
            
            
            localMask0 = (localMask0 | ((localMask0 << 1) & loverflow) | ((localMask0 >>> 1) & roverflow));
            localMask1 = (localMask1 | ((localMask1 << 1) & loverflow) | ((localMask1 >>> 1) & roverflow));
            temp = localMask0;
            localMask0 = (localMask0 | (localMask0 << 9) | (localMask0 >>> 9)
                       | (localMask1 << 54)) & mask0AndPassible;
            localMask1 = (localMask1 | (localMask1 << 9) | (localMask1 >>> 9)
                       | (temp >>> 54)) & mask1AndPassible;
            
        }
        
        SquareManager.computePaintPenalties();

        // Pick the best direction.
        // One thing I noticed is if units are going in opposite directions,
        // Then they'll hit each other at this step. Perhaps we should disallow stay-still moves?
        String dists = "";
        
        
        Direction bestDir = null;
        Direction backupDir = null;
        int bestPenalty = 10000000;
        int bestDist = 10000000;
        int bestBugDist = 10000000;
        int centerBugDist = myloc.distanceSquaredTo(currentBugPosition);
        
        
        
        {
            dists += "N=" + dist12 + " ";
            // boolean canMove = rc.canMove(Direction.NORTH);
            boolean canMove = rc.canMove(Direction.NORTH);
            MapLocation nloc = myloc.add(Direction.NORTH);
            int penalty = SquareManager.penalty23;
            int bugDist = nloc.distanceSquaredTo(currentBugPosition);
            boolean shouldUpdate = false;
            updateLabel: {
                if (!canMove) break updateLabel;
                backupDir = Direction.NORTH;

                // Only consider locations that improve the distance, to avoid cycles.
                if (dist12 > dist11) break updateLabel;
                if (dist12 == dist11 && bugDist >= centerBugDist) break updateLabel;
                
                // Choose the location with lower penalty.
                if (penalty != bestPenalty) {
                    shouldUpdate = (penalty < bestPenalty);
                    break updateLabel;
                }

                // Choose the location with lower BFS distance.
                if (dist12 != bestDist) {
                    shouldUpdate = dist12 < bestDist;
                    break updateLabel;
                }

                // Choose the location with lower Bug distance.
                if (bugDist != bestBugDist) {
                    shouldUpdate = bugDist < bestBugDist;
                    break updateLabel;
                }
            }

            Direction dir = Direction.NORTH;
            int dist = dist12;
            System.out.println("[242] " + "dir = " + dir + ", " + "canMove = " + canMove + ", " + "dist = " + dist + ", " + "penalty = " + penalty + ", " + "bugDist = " + bugDist + ", " + "shouldUpdate = " + shouldUpdate);
            if (shouldUpdate) {
                bestDir = Direction.NORTH;
                bestDist = dist12;
                bestBugDist = bugDist;
                bestPenalty = penalty;
            }
        }
        
        
        
        {
            dists += "NE=" + dist22 + " ";
            // boolean canMove = rc.canMove(Direction.NORTHEAST);
            boolean canMove = rc.canMove(Direction.NORTHEAST);
            MapLocation nloc = myloc.add(Direction.NORTHEAST);
            int penalty = SquareManager.penalty33;
            int bugDist = nloc.distanceSquaredTo(currentBugPosition);
            boolean shouldUpdate = false;
            updateLabel: {
                if (!canMove) break updateLabel;
                backupDir = Direction.NORTHEAST;

                // Only consider locations that improve the distance, to avoid cycles.
                if (dist22 > dist11) break updateLabel;
                if (dist22 == dist11 && bugDist >= centerBugDist) break updateLabel;
                
                // Choose the location with lower penalty.
                if (penalty != bestPenalty) {
                    shouldUpdate = (penalty < bestPenalty);
                    break updateLabel;
                }

                // Choose the location with lower BFS distance.
                if (dist22 != bestDist) {
                    shouldUpdate = dist22 < bestDist;
                    break updateLabel;
                }

                // Choose the location with lower Bug distance.
                if (bugDist != bestBugDist) {
                    shouldUpdate = bugDist < bestBugDist;
                    break updateLabel;
                }
            }

            Direction dir = Direction.NORTHEAST;
            int dist = dist22;
            System.out.println("[242] " + "dir = " + dir + ", " + "canMove = " + canMove + ", " + "dist = " + dist + ", " + "penalty = " + penalty + ", " + "bugDist = " + bugDist + ", " + "shouldUpdate = " + shouldUpdate);
            if (shouldUpdate) {
                bestDir = Direction.NORTHEAST;
                bestDist = dist22;
                bestBugDist = bugDist;
                bestPenalty = penalty;
            }
        }
        
        
        
        {
            dists += "E=" + dist21 + " ";
            // boolean canMove = rc.canMove(Direction.EAST);
            boolean canMove = rc.canMove(Direction.EAST);
            MapLocation nloc = myloc.add(Direction.EAST);
            int penalty = SquareManager.penalty32;
            int bugDist = nloc.distanceSquaredTo(currentBugPosition);
            boolean shouldUpdate = false;
            updateLabel: {
                if (!canMove) break updateLabel;
                backupDir = Direction.EAST;

                // Only consider locations that improve the distance, to avoid cycles.
                if (dist21 > dist11) break updateLabel;
                if (dist21 == dist11 && bugDist >= centerBugDist) break updateLabel;
                
                // Choose the location with lower penalty.
                if (penalty != bestPenalty) {
                    shouldUpdate = (penalty < bestPenalty);
                    break updateLabel;
                }

                // Choose the location with lower BFS distance.
                if (dist21 != bestDist) {
                    shouldUpdate = dist21 < bestDist;
                    break updateLabel;
                }

                // Choose the location with lower Bug distance.
                if (bugDist != bestBugDist) {
                    shouldUpdate = bugDist < bestBugDist;
                    break updateLabel;
                }
            }

            Direction dir = Direction.EAST;
            int dist = dist21;
            System.out.println("[242] " + "dir = " + dir + ", " + "canMove = " + canMove + ", " + "dist = " + dist + ", " + "penalty = " + penalty + ", " + "bugDist = " + bugDist + ", " + "shouldUpdate = " + shouldUpdate);
            if (shouldUpdate) {
                bestDir = Direction.EAST;
                bestDist = dist21;
                bestBugDist = bugDist;
                bestPenalty = penalty;
            }
        }
        
        
        
        {
            dists += "SE=" + dist20 + " ";
            // boolean canMove = rc.canMove(Direction.SOUTHEAST);
            boolean canMove = rc.canMove(Direction.SOUTHEAST);
            MapLocation nloc = myloc.add(Direction.SOUTHEAST);
            int penalty = SquareManager.penalty31;
            int bugDist = nloc.distanceSquaredTo(currentBugPosition);
            boolean shouldUpdate = false;
            updateLabel: {
                if (!canMove) break updateLabel;
                backupDir = Direction.SOUTHEAST;

                // Only consider locations that improve the distance, to avoid cycles.
                if (dist20 > dist11) break updateLabel;
                if (dist20 == dist11 && bugDist >= centerBugDist) break updateLabel;
                
                // Choose the location with lower penalty.
                if (penalty != bestPenalty) {
                    shouldUpdate = (penalty < bestPenalty);
                    break updateLabel;
                }

                // Choose the location with lower BFS distance.
                if (dist20 != bestDist) {
                    shouldUpdate = dist20 < bestDist;
                    break updateLabel;
                }

                // Choose the location with lower Bug distance.
                if (bugDist != bestBugDist) {
                    shouldUpdate = bugDist < bestBugDist;
                    break updateLabel;
                }
            }

            Direction dir = Direction.SOUTHEAST;
            int dist = dist20;
            System.out.println("[242] " + "dir = " + dir + ", " + "canMove = " + canMove + ", " + "dist = " + dist + ", " + "penalty = " + penalty + ", " + "bugDist = " + bugDist + ", " + "shouldUpdate = " + shouldUpdate);
            if (shouldUpdate) {
                bestDir = Direction.SOUTHEAST;
                bestDist = dist20;
                bestBugDist = bugDist;
                bestPenalty = penalty;
            }
        }
        
        
        
        {
            dists += "S=" + dist10 + " ";
            // boolean canMove = rc.canMove(Direction.SOUTH);
            boolean canMove = rc.canMove(Direction.SOUTH);
            MapLocation nloc = myloc.add(Direction.SOUTH);
            int penalty = SquareManager.penalty21;
            int bugDist = nloc.distanceSquaredTo(currentBugPosition);
            boolean shouldUpdate = false;
            updateLabel: {
                if (!canMove) break updateLabel;
                backupDir = Direction.SOUTH;

                // Only consider locations that improve the distance, to avoid cycles.
                if (dist10 > dist11) break updateLabel;
                if (dist10 == dist11 && bugDist >= centerBugDist) break updateLabel;
                
                // Choose the location with lower penalty.
                if (penalty != bestPenalty) {
                    shouldUpdate = (penalty < bestPenalty);
                    break updateLabel;
                }

                // Choose the location with lower BFS distance.
                if (dist10 != bestDist) {
                    shouldUpdate = dist10 < bestDist;
                    break updateLabel;
                }

                // Choose the location with lower Bug distance.
                if (bugDist != bestBugDist) {
                    shouldUpdate = bugDist < bestBugDist;
                    break updateLabel;
                }
            }

            Direction dir = Direction.SOUTH;
            int dist = dist10;
            System.out.println("[242] " + "dir = " + dir + ", " + "canMove = " + canMove + ", " + "dist = " + dist + ", " + "penalty = " + penalty + ", " + "bugDist = " + bugDist + ", " + "shouldUpdate = " + shouldUpdate);
            if (shouldUpdate) {
                bestDir = Direction.SOUTH;
                bestDist = dist10;
                bestBugDist = bugDist;
                bestPenalty = penalty;
            }
        }
        
        
        
        {
            dists += "SW=" + dist00 + " ";
            // boolean canMove = rc.canMove(Direction.SOUTHWEST);
            boolean canMove = rc.canMove(Direction.SOUTHWEST);
            MapLocation nloc = myloc.add(Direction.SOUTHWEST);
            int penalty = SquareManager.penalty11;
            int bugDist = nloc.distanceSquaredTo(currentBugPosition);
            boolean shouldUpdate = false;
            updateLabel: {
                if (!canMove) break updateLabel;
                backupDir = Direction.SOUTHWEST;

                // Only consider locations that improve the distance, to avoid cycles.
                if (dist00 > dist11) break updateLabel;
                if (dist00 == dist11 && bugDist >= centerBugDist) break updateLabel;
                
                // Choose the location with lower penalty.
                if (penalty != bestPenalty) {
                    shouldUpdate = (penalty < bestPenalty);
                    break updateLabel;
                }

                // Choose the location with lower BFS distance.
                if (dist00 != bestDist) {
                    shouldUpdate = dist00 < bestDist;
                    break updateLabel;
                }

                // Choose the location with lower Bug distance.
                if (bugDist != bestBugDist) {
                    shouldUpdate = bugDist < bestBugDist;
                    break updateLabel;
                }
            }

            Direction dir = Direction.SOUTHWEST;
            int dist = dist00;
            System.out.println("[242] " + "dir = " + dir + ", " + "canMove = " + canMove + ", " + "dist = " + dist + ", " + "penalty = " + penalty + ", " + "bugDist = " + bugDist + ", " + "shouldUpdate = " + shouldUpdate);
            if (shouldUpdate) {
                bestDir = Direction.SOUTHWEST;
                bestDist = dist00;
                bestBugDist = bugDist;
                bestPenalty = penalty;
            }
        }
        
        
        
        {
            dists += "W=" + dist01 + " ";
            // boolean canMove = rc.canMove(Direction.WEST);
            boolean canMove = rc.canMove(Direction.WEST);
            MapLocation nloc = myloc.add(Direction.WEST);
            int penalty = SquareManager.penalty12;
            int bugDist = nloc.distanceSquaredTo(currentBugPosition);
            boolean shouldUpdate = false;
            updateLabel: {
                if (!canMove) break updateLabel;
                backupDir = Direction.WEST;

                // Only consider locations that improve the distance, to avoid cycles.
                if (dist01 > dist11) break updateLabel;
                if (dist01 == dist11 && bugDist >= centerBugDist) break updateLabel;
                
                // Choose the location with lower penalty.
                if (penalty != bestPenalty) {
                    shouldUpdate = (penalty < bestPenalty);
                    break updateLabel;
                }

                // Choose the location with lower BFS distance.
                if (dist01 != bestDist) {
                    shouldUpdate = dist01 < bestDist;
                    break updateLabel;
                }

                // Choose the location with lower Bug distance.
                if (bugDist != bestBugDist) {
                    shouldUpdate = bugDist < bestBugDist;
                    break updateLabel;
                }
            }

            Direction dir = Direction.WEST;
            int dist = dist01;
            System.out.println("[242] " + "dir = " + dir + ", " + "canMove = " + canMove + ", " + "dist = " + dist + ", " + "penalty = " + penalty + ", " + "bugDist = " + bugDist + ", " + "shouldUpdate = " + shouldUpdate);
            if (shouldUpdate) {
                bestDir = Direction.WEST;
                bestDist = dist01;
                bestBugDist = bugDist;
                bestPenalty = penalty;
            }
        }
        
        
        
        {
            dists += "NW=" + dist02 + " ";
            // boolean canMove = rc.canMove(Direction.NORTHWEST);
            boolean canMove = rc.canMove(Direction.NORTHWEST);
            MapLocation nloc = myloc.add(Direction.NORTHWEST);
            int penalty = SquareManager.penalty13;
            int bugDist = nloc.distanceSquaredTo(currentBugPosition);
            boolean shouldUpdate = false;
            updateLabel: {
                if (!canMove) break updateLabel;
                backupDir = Direction.NORTHWEST;

                // Only consider locations that improve the distance, to avoid cycles.
                if (dist02 > dist11) break updateLabel;
                if (dist02 == dist11 && bugDist >= centerBugDist) break updateLabel;
                
                // Choose the location with lower penalty.
                if (penalty != bestPenalty) {
                    shouldUpdate = (penalty < bestPenalty);
                    break updateLabel;
                }

                // Choose the location with lower BFS distance.
                if (dist02 != bestDist) {
                    shouldUpdate = dist02 < bestDist;
                    break updateLabel;
                }

                // Choose the location with lower Bug distance.
                if (bugDist != bestBugDist) {
                    shouldUpdate = bugDist < bestBugDist;
                    break updateLabel;
                }
            }

            Direction dir = Direction.NORTHWEST;
            int dist = dist02;
            System.out.println("[242] " + "dir = " + dir + ", " + "canMove = " + canMove + ", " + "dist = " + dist + ", " + "penalty = " + penalty + ", " + "bugDist = " + bugDist + ", " + "shouldUpdate = " + shouldUpdate);
            if (shouldUpdate) {
                bestDir = Direction.NORTHWEST;
                bestDist = dist02;
                bestBugDist = bugDist;
                bestPenalty = penalty;
            }
        }
        

        System.out.println("Chose := " + bestDir);
        System.out.println("\n");

        // Move in the best direction.
        if (bestDir != null && bestDir != Direction.CENTER) {
            Pathing.move(bestDir);
        }
        
        // If we couldn't move in any good direction
        // We are blocked by a unit, so choose some direction to backup into.
        // To let the other unit through.
        else if (backupDir != null) {
            Pathing.move(backupDir);
        }
        return;
    }

    public static void bug() throws GameActionException {
        assert(bestBugDist < 10000);
        assert(!currentBugDirection.equals(Direction.CENTER));
        
        MapLocation currentLoc = null, newLoc = currentBugPosition.add(currentBugDirection);
        if (newLoc.distanceSquaredTo(myloc) <= GameConstants.VISION_RADIUS_SQUARED) {
            if (rc.onTheMap(newLoc)) {
                MapInfo mi = rc.senseMapInfo(newLoc);
                if (mi.isPassable() || newLoc.equals(currentTarget)) {
                    currentLoc = newLoc;
                }
            }
        } else {
            // We're starting to consider locations out of vision range,
            // We must halt to prevent wrong decisions.
            doneSimulating = true;
            return;
        }

        if (currentLoc == null) {
            leftLoop: {
                
                newLoc = currentBugPosition.add(currentBugDirection.rotateLeft());
                if (newLoc.distanceSquaredTo(myloc) <= GameConstants.VISION_RADIUS_SQUARED) {
                    if (rc.onTheMap(newLoc)) {
                        MapInfo mi = rc.senseMapInfo(newLoc);
                        if (mi.isPassable() || newLoc.equals(currentTarget)) {
                            currentLoc = newLoc;
                            break leftLoop;
                        }
                    }
                } else {
                    // We're starting to consider locations out of vision range,
                    // We must halt to prevent wrong decisions.
                    doneSimulating = true;
                    return;
                }
                
                // If the new direction is not passible, set currentBugDirection to it.
                currentBugDirection = currentBugDirection.rotateLeft();
                
                newLoc = currentBugPosition.add(currentBugDirection.rotateLeft());
                if (newLoc.distanceSquaredTo(myloc) <= GameConstants.VISION_RADIUS_SQUARED) {
                    if (rc.onTheMap(newLoc)) {
                        MapInfo mi = rc.senseMapInfo(newLoc);
                        if (mi.isPassable() || newLoc.equals(currentTarget)) {
                            currentLoc = newLoc;
                            break leftLoop;
                        }
                    }
                } else {
                    // We're starting to consider locations out of vision range,
                    // We must halt to prevent wrong decisions.
                    doneSimulating = true;
                    return;
                }
                
                // If the new direction is not passible, set currentBugDirection to it.
                currentBugDirection = currentBugDirection.rotateLeft();
                
                newLoc = currentBugPosition.add(currentBugDirection.rotateLeft());
                if (newLoc.distanceSquaredTo(myloc) <= GameConstants.VISION_RADIUS_SQUARED) {
                    if (rc.onTheMap(newLoc)) {
                        MapInfo mi = rc.senseMapInfo(newLoc);
                        if (mi.isPassable() || newLoc.equals(currentTarget)) {
                            currentLoc = newLoc;
                            break leftLoop;
                        }
                    }
                } else {
                    // We're starting to consider locations out of vision range,
                    // We must halt to prevent wrong decisions.
                    doneSimulating = true;
                    return;
                }
                
                // If the new direction is not passible, set currentBugDirection to it.
                currentBugDirection = currentBugDirection.rotateLeft();
                
                newLoc = currentBugPosition.add(currentBugDirection.rotateLeft());
                if (newLoc.distanceSquaredTo(myloc) <= GameConstants.VISION_RADIUS_SQUARED) {
                    if (rc.onTheMap(newLoc)) {
                        MapInfo mi = rc.senseMapInfo(newLoc);
                        if (mi.isPassable() || newLoc.equals(currentTarget)) {
                            currentLoc = newLoc;
                            break leftLoop;
                        }
                    }
                } else {
                    // We're starting to consider locations out of vision range,
                    // We must halt to prevent wrong decisions.
                    doneSimulating = true;
                    return;
                }
                
                // If the new direction is not passible, set currentBugDirection to it.
                currentBugDirection = currentBugDirection.rotateLeft();
                
                newLoc = currentBugPosition.add(currentBugDirection.rotateLeft());
                if (newLoc.distanceSquaredTo(myloc) <= GameConstants.VISION_RADIUS_SQUARED) {
                    if (rc.onTheMap(newLoc)) {
                        MapInfo mi = rc.senseMapInfo(newLoc);
                        if (mi.isPassable() || newLoc.equals(currentTarget)) {
                            currentLoc = newLoc;
                            break leftLoop;
                        }
                    }
                } else {
                    // We're starting to consider locations out of vision range,
                    // We must halt to prevent wrong decisions.
                    doneSimulating = true;
                    return;
                }
                
                // If the new direction is not passible, set currentBugDirection to it.
                currentBugDirection = currentBugDirection.rotateLeft();
                
                newLoc = currentBugPosition.add(currentBugDirection.rotateLeft());
                if (newLoc.distanceSquaredTo(myloc) <= GameConstants.VISION_RADIUS_SQUARED) {
                    if (rc.onTheMap(newLoc)) {
                        MapInfo mi = rc.senseMapInfo(newLoc);
                        if (mi.isPassable() || newLoc.equals(currentTarget)) {
                            currentLoc = newLoc;
                            break leftLoop;
                        }
                    }
                } else {
                    // We're starting to consider locations out of vision range,
                    // We must halt to prevent wrong decisions.
                    doneSimulating = true;
                    return;
                }
                
                // If the new direction is not passible, set currentBugDirection to it.
                currentBugDirection = currentBugDirection.rotateLeft();
                
                newLoc = currentBugPosition.add(currentBugDirection.rotateLeft());
                if (newLoc.distanceSquaredTo(myloc) <= GameConstants.VISION_RADIUS_SQUARED) {
                    if (rc.onTheMap(newLoc)) {
                        MapInfo mi = rc.senseMapInfo(newLoc);
                        if (mi.isPassable() || newLoc.equals(currentTarget)) {
                            currentLoc = newLoc;
                            break leftLoop;
                        }
                    }
                } else {
                    // We're starting to consider locations out of vision range,
                    // We must halt to prevent wrong decisions.
                    doneSimulating = true;
                    return;
                }
                
                // If the new direction is not passible, set currentBugDirection to it.
                currentBugDirection = currentBugDirection.rotateLeft();
                
                newLoc = currentBugPosition.add(currentBugDirection.rotateLeft());
                if (newLoc.distanceSquaredTo(myloc) <= GameConstants.VISION_RADIUS_SQUARED) {
                    if (rc.onTheMap(newLoc)) {
                        MapInfo mi = rc.senseMapInfo(newLoc);
                        if (mi.isPassable() || newLoc.equals(currentTarget)) {
                            currentLoc = newLoc;
                            break leftLoop;
                        }
                    }
                } else {
                    // We're starting to consider locations out of vision range,
                    // We must halt to prevent wrong decisions.
                    doneSimulating = true;
                    return;
                }
                
                // If the new direction is not passible, set currentBugDirection to it.
                currentBugDirection = currentBugDirection.rotateLeft();
                
            }
        }

        if (currentLoc != null) {
            assert(!currentLoc.equals(currentBugPosition));
            currentBugPosition = currentLoc;
            currentBugDirection = currentBugDirection.rotateRight();
            int d = currentBugPosition.distanceSquaredTo(currentTarget);
            if (d < bestBugDist) shouldBug = false;
        } else {
            System.out.println("Trapped in a box!");
        }
    }

    public static void greedy() throws GameActionException {
        int bestPenalty = 1000000;
        int closestDist = 1000000;
        MapLocation bestLoc = currentBugPosition;
        // Looping over all directions is kind of not great.
        
        {
            MapLocation newLoc = currentBugPosition.add(Direction.NORTH);
            if (newLoc.distanceSquaredTo(myloc) <= GameConstants.VISION_RADIUS_SQUARED) {
                if (rc.onTheMap(newLoc)) {
                    MapInfo mi = rc.senseMapInfo(newLoc);
                    if (mi.isPassable() || newLoc.equals(currentTarget)) {
                        boolean shouldUpdate = false;
                        int d = newLoc.distanceSquaredTo(currentTarget);
                        int penalty = switch(mi.getPaint()) {
                            case ENEMY_PRIMARY, ENEMY_SECONDARY -> 2;
                            case ALLY_PRIMARY, ALLY_SECONDARY -> 0;
                            case EMPTY -> 1;
                        };
                        updateLabel: {
                            if (d != closestDist) {
                                shouldUpdate = (d < closestDist);
                                break updateLabel;
                            }
                            shouldUpdate = penalty < bestPenalty;
                            break updateLabel;
                        }
                        if (shouldUpdate) {
                            closestDist = d;
                            bestPenalty = penalty;
                            bestLoc = newLoc;
                        }
                    }
                }
            } else {
                // This is kind of not great.
                doneSimulating = true;
                return;
            }
        }        
        
        {
            MapLocation newLoc = currentBugPosition.add(Direction.NORTHEAST);
            if (newLoc.distanceSquaredTo(myloc) <= GameConstants.VISION_RADIUS_SQUARED) {
                if (rc.onTheMap(newLoc)) {
                    MapInfo mi = rc.senseMapInfo(newLoc);
                    if (mi.isPassable() || newLoc.equals(currentTarget)) {
                        boolean shouldUpdate = false;
                        int d = newLoc.distanceSquaredTo(currentTarget);
                        int penalty = switch(mi.getPaint()) {
                            case ENEMY_PRIMARY, ENEMY_SECONDARY -> 2;
                            case ALLY_PRIMARY, ALLY_SECONDARY -> 0;
                            case EMPTY -> 1;
                        };
                        updateLabel: {
                            if (d != closestDist) {
                                shouldUpdate = (d < closestDist);
                                break updateLabel;
                            }
                            shouldUpdate = penalty < bestPenalty;
                            break updateLabel;
                        }
                        if (shouldUpdate) {
                            closestDist = d;
                            bestPenalty = penalty;
                            bestLoc = newLoc;
                        }
                    }
                }
            } else {
                // This is kind of not great.
                doneSimulating = true;
                return;
            }
        }        
        
        {
            MapLocation newLoc = currentBugPosition.add(Direction.EAST);
            if (newLoc.distanceSquaredTo(myloc) <= GameConstants.VISION_RADIUS_SQUARED) {
                if (rc.onTheMap(newLoc)) {
                    MapInfo mi = rc.senseMapInfo(newLoc);
                    if (mi.isPassable() || newLoc.equals(currentTarget)) {
                        boolean shouldUpdate = false;
                        int d = newLoc.distanceSquaredTo(currentTarget);
                        int penalty = switch(mi.getPaint()) {
                            case ENEMY_PRIMARY, ENEMY_SECONDARY -> 2;
                            case ALLY_PRIMARY, ALLY_SECONDARY -> 0;
                            case EMPTY -> 1;
                        };
                        updateLabel: {
                            if (d != closestDist) {
                                shouldUpdate = (d < closestDist);
                                break updateLabel;
                            }
                            shouldUpdate = penalty < bestPenalty;
                            break updateLabel;
                        }
                        if (shouldUpdate) {
                            closestDist = d;
                            bestPenalty = penalty;
                            bestLoc = newLoc;
                        }
                    }
                }
            } else {
                // This is kind of not great.
                doneSimulating = true;
                return;
            }
        }        
        
        {
            MapLocation newLoc = currentBugPosition.add(Direction.SOUTHEAST);
            if (newLoc.distanceSquaredTo(myloc) <= GameConstants.VISION_RADIUS_SQUARED) {
                if (rc.onTheMap(newLoc)) {
                    MapInfo mi = rc.senseMapInfo(newLoc);
                    if (mi.isPassable() || newLoc.equals(currentTarget)) {
                        boolean shouldUpdate = false;
                        int d = newLoc.distanceSquaredTo(currentTarget);
                        int penalty = switch(mi.getPaint()) {
                            case ENEMY_PRIMARY, ENEMY_SECONDARY -> 2;
                            case ALLY_PRIMARY, ALLY_SECONDARY -> 0;
                            case EMPTY -> 1;
                        };
                        updateLabel: {
                            if (d != closestDist) {
                                shouldUpdate = (d < closestDist);
                                break updateLabel;
                            }
                            shouldUpdate = penalty < bestPenalty;
                            break updateLabel;
                        }
                        if (shouldUpdate) {
                            closestDist = d;
                            bestPenalty = penalty;
                            bestLoc = newLoc;
                        }
                    }
                }
            } else {
                // This is kind of not great.
                doneSimulating = true;
                return;
            }
        }        
        
        {
            MapLocation newLoc = currentBugPosition.add(Direction.SOUTH);
            if (newLoc.distanceSquaredTo(myloc) <= GameConstants.VISION_RADIUS_SQUARED) {
                if (rc.onTheMap(newLoc)) {
                    MapInfo mi = rc.senseMapInfo(newLoc);
                    if (mi.isPassable() || newLoc.equals(currentTarget)) {
                        boolean shouldUpdate = false;
                        int d = newLoc.distanceSquaredTo(currentTarget);
                        int penalty = switch(mi.getPaint()) {
                            case ENEMY_PRIMARY, ENEMY_SECONDARY -> 2;
                            case ALLY_PRIMARY, ALLY_SECONDARY -> 0;
                            case EMPTY -> 1;
                        };
                        updateLabel: {
                            if (d != closestDist) {
                                shouldUpdate = (d < closestDist);
                                break updateLabel;
                            }
                            shouldUpdate = penalty < bestPenalty;
                            break updateLabel;
                        }
                        if (shouldUpdate) {
                            closestDist = d;
                            bestPenalty = penalty;
                            bestLoc = newLoc;
                        }
                    }
                }
            } else {
                // This is kind of not great.
                doneSimulating = true;
                return;
            }
        }        
        
        {
            MapLocation newLoc = currentBugPosition.add(Direction.SOUTHWEST);
            if (newLoc.distanceSquaredTo(myloc) <= GameConstants.VISION_RADIUS_SQUARED) {
                if (rc.onTheMap(newLoc)) {
                    MapInfo mi = rc.senseMapInfo(newLoc);
                    if (mi.isPassable() || newLoc.equals(currentTarget)) {
                        boolean shouldUpdate = false;
                        int d = newLoc.distanceSquaredTo(currentTarget);
                        int penalty = switch(mi.getPaint()) {
                            case ENEMY_PRIMARY, ENEMY_SECONDARY -> 2;
                            case ALLY_PRIMARY, ALLY_SECONDARY -> 0;
                            case EMPTY -> 1;
                        };
                        updateLabel: {
                            if (d != closestDist) {
                                shouldUpdate = (d < closestDist);
                                break updateLabel;
                            }
                            shouldUpdate = penalty < bestPenalty;
                            break updateLabel;
                        }
                        if (shouldUpdate) {
                            closestDist = d;
                            bestPenalty = penalty;
                            bestLoc = newLoc;
                        }
                    }
                }
            } else {
                // This is kind of not great.
                doneSimulating = true;
                return;
            }
        }        
        
        {
            MapLocation newLoc = currentBugPosition.add(Direction.WEST);
            if (newLoc.distanceSquaredTo(myloc) <= GameConstants.VISION_RADIUS_SQUARED) {
                if (rc.onTheMap(newLoc)) {
                    MapInfo mi = rc.senseMapInfo(newLoc);
                    if (mi.isPassable() || newLoc.equals(currentTarget)) {
                        boolean shouldUpdate = false;
                        int d = newLoc.distanceSquaredTo(currentTarget);
                        int penalty = switch(mi.getPaint()) {
                            case ENEMY_PRIMARY, ENEMY_SECONDARY -> 2;
                            case ALLY_PRIMARY, ALLY_SECONDARY -> 0;
                            case EMPTY -> 1;
                        };
                        updateLabel: {
                            if (d != closestDist) {
                                shouldUpdate = (d < closestDist);
                                break updateLabel;
                            }
                            shouldUpdate = penalty < bestPenalty;
                            break updateLabel;
                        }
                        if (shouldUpdate) {
                            closestDist = d;
                            bestPenalty = penalty;
                            bestLoc = newLoc;
                        }
                    }
                }
            } else {
                // This is kind of not great.
                doneSimulating = true;
                return;
            }
        }        
        
        {
            MapLocation newLoc = currentBugPosition.add(Direction.NORTHWEST);
            if (newLoc.distanceSquaredTo(myloc) <= GameConstants.VISION_RADIUS_SQUARED) {
                if (rc.onTheMap(newLoc)) {
                    MapInfo mi = rc.senseMapInfo(newLoc);
                    if (mi.isPassable() || newLoc.equals(currentTarget)) {
                        boolean shouldUpdate = false;
                        int d = newLoc.distanceSquaredTo(currentTarget);
                        int penalty = switch(mi.getPaint()) {
                            case ENEMY_PRIMARY, ENEMY_SECONDARY -> 2;
                            case ALLY_PRIMARY, ALLY_SECONDARY -> 0;
                            case EMPTY -> 1;
                        };
                        updateLabel: {
                            if (d != closestDist) {
                                shouldUpdate = (d < closestDist);
                                break updateLabel;
                            }
                            shouldUpdate = penalty < bestPenalty;
                            break updateLabel;
                        }
                        if (shouldUpdate) {
                            closestDist = d;
                            bestPenalty = penalty;
                            bestLoc = newLoc;
                        }
                    }
                }
            } else {
                // This is kind of not great.
                doneSimulating = true;
                return;
            }
        }        
        
        {
            MapLocation newLoc = currentBugPosition.add(Direction.CENTER);
            if (newLoc.distanceSquaredTo(myloc) <= GameConstants.VISION_RADIUS_SQUARED) {
                if (rc.onTheMap(newLoc)) {
                    MapInfo mi = rc.senseMapInfo(newLoc);
                    if (mi.isPassable() || newLoc.equals(currentTarget)) {
                        boolean shouldUpdate = false;
                        int d = newLoc.distanceSquaredTo(currentTarget);
                        int penalty = switch(mi.getPaint()) {
                            case ENEMY_PRIMARY, ENEMY_SECONDARY -> 2;
                            case ALLY_PRIMARY, ALLY_SECONDARY -> 0;
                            case EMPTY -> 1;
                        };
                        updateLabel: {
                            if (d != closestDist) {
                                shouldUpdate = (d < closestDist);
                                break updateLabel;
                            }
                            shouldUpdate = penalty < bestPenalty;
                            break updateLabel;
                        }
                        if (shouldUpdate) {
                            closestDist = d;
                            bestPenalty = penalty;
                            bestLoc = newLoc;
                        }
                    }
                }
            } else {
                // This is kind of not great.
                doneSimulating = true;
                return;
            }
        }        
        

        if (!bestLoc.equals(currentBugPosition)) {
            currentBugPosition = bestLoc;
            return;
        } else {
            bestBugDist = currentBugPosition.distanceSquaredTo(currentTarget);
            currentBugDirection = currentBugPosition.directionTo(currentTarget);
            assert(!currentBugDirection.equals(Direction.CENTER));
            shouldBug = true;
            return;
        }
    }

    public static void resetPathing(MapLocation target) {
        bestBugDist = 100000000;
        shouldBug = false;
        currentTarget = target;
        currentBugDirection = null;
        currentBugPosition = rc.getLocation();
        pathLength = 0;
    }

    public static void move(Direction dir) throws GameActionException {
        rc.move(dir);
        MapLocation myloc = rc.getLocation();
        if (myloc.distanceSquaredTo(currentBugPosition) > GameConstants.VISION_RADIUS_SQUARED) {
            setCurrentPosition();
        }
    }
}