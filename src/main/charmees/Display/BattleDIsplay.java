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
            // clear screen
            Display.gap();
            Display.header("CHAPTER " + chapter + " - TURN " + turncount);
            
            // enemy field section
            Display.gap();
            showEnemyField(mobs, chapter, targetIdx, mobMaxHP);

            // active character section
            Display.gap();
            showActiveChar(characters[activeIdx], charMaxHP[activeIdx]);
             
            // bench section
            Display.gap();
            showBench(characters, activeIdx, charMaxHP);
            
            // thin line separator
            Display.thin();
        }

        // enemy Section
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
                    System.out.println(" " + hpBar(m.healthPoints, mobMaxHP[i], 30)
                    + " " + percent(m.healthPoints,mobMaxHP[i]) + "%");
                }
            }

            // active character Section
            public static void showActiveChar(Character c, int maxHP){
                System.out.println("ACTIVE CHARACTER: ");
                Display.thin();
                System.out.println(" " + c.getName() + " " 
                + "   HP: " + c.healthPoints + "/" + maxHP
                + "   MP: " + c.manaPoints + "/" + c.manaPoints);

                System.out.println(" " + hpBar(c.healthPoints, maxHP, 30)
                + " " + percent(c.healthPoints, maxHP) + "%");
            }

        // Bench Section
        private static void showBench(Character[] characters, int activeIdx, int[] charMaxHP){

        }
        // ================================================
        //HELPERS
        // ================================================
        public static String hpBar(int hp, int max, int width){
            if (max <= 0) return "░".repeat(width);
            int filled = (int)((double) hp / max * width); // calculate filled portion
            filled = Math.max(0, Math.min(width, filled)); // ensure within bounds
            return "█".repeat(filled) + "░".repeat(width - filled); // create bar string
        }

        public static void log(String msg){
            System.out.println(" " + msg);
        }

        private static int percent(int hp, int max){
            if (max <= 0) return 0;
            return (int)((double) hp / max * 100);
        }

}