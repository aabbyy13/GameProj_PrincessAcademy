package charmees.Display;

import charmees.Util.Character;
import charmees.Util.MobNPC;
import charmees.Util.Display;
import java.util.Scanner;

public class BattleDIsplay {

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

}