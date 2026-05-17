package charmees.Display;

import charmees.Util.Character;
import charmees.Util.MobNPC;
import charmees.Util.Display;
import java.util.Scanner;

public class BattleDisplay {

    //TODO: implement battle display

    //MAINLY: show the battlefield, show the active character and mob, 
    // show the HP of all characters and mobs, show the turn count, show the chapter, 
    // show the actions available to the active character, 
    // show the actions available to the active mob 

    public static void showBattleField(
        Character[] characters,
        MobNPC[] mobs,
        int chapter,
        int activeIdx,
        int targetIdx,
        int[] charMaxHP,
        int[] mobMaxHP,
        int turncount)
        {
            Display.gap();
            Display.header("CHAPTER " + chapter + " - TURN " + turncount);
            Display.gap();
            // active characters 
            // benched
            Display.thin();
        }

        public static void showEnemyField(MobNPC[] mobs, int chapter, int targetIdx, int[] mobMaxHP){
                System.out.println("ENEMIES: ");
                for (int i = 0; i < mobs.length; i++){
                    MobNPC m = mobs[i];
                    if (m.chapter != chapter) continue;

                    Display.gap();

                    if(!m.isAlive()){
                        System.out.println(" " + m.getName() + " [" + m.charClass + "] - DEFEATED");
                        continue;
                    }

                    String target = (i == targetIdx) ? " <-- TARGET" : "";
                    System.out.println(" " + m.getName() + " [" + m.charClass + "]"
                    + " HP: " + m.healthPoints + "/" + mobMaxHP[i] + target);
                    
                    //
                }

                
            }

}