package charmees.Display;

import charmees.Util.*;
import charmees.Util.Character;
import charmees.Util.MobNPC;
import java.util.ArrayList;
import java.util.Scanner;

public class BattleLogic {
    // This class will handle the battle logic for both Story Mode
    // It will be called by the BattleDisplay class

    private final Character[] characters; // index 2 is always Lazuli
    private final MobNPC[] mobs;
    private final int Chapter;
    private final Scanner sc;

    private int activeIdx = 0; //current character (never index 2 / Lazuli)
    private int targetIdx = 0; //current enemy target   
    private int turnCount = 1; // counts the number of turns in the battle

    private final int[] charMaxHP;
    private final int[] mobMaxHP;

    //dialogue triggers for certain HP Boss thresholds
    private boolean boss50Trigger = false;
    private boolean boss10Trigger = false;

    //constructors
    public BattleLogic(Character[] characters, MobNPC[] mobs, int chapter, Scanner sc) {
        this.characters = characters;
        this.mobs = mobs;
        this.Chapter = chapter;
        this.sc = sc;

        // initialize max HP arrays
        charMaxHP = new int[characters.length];
        for (int i = 0; i < characters.length; i++) {
            charMaxHP[i] = characters[i].healthPoints;
        }

        mobMaxHP = new int[mobs.length];
        for (int i = 0; i < mobs.length; i++) {
            mobMaxHP[i] = mobs[i].healthPoints;
        }

    }
}