
package src.main.charmees.core;

import src.main.charmees.gui.MainMenu;

public class GameSystem {
    protected MainMenu mainMenu;

    public GameSystem(MainMenu mainMenu) {
        this.mainMenu = mainMenu;
    }
    public void MainMenu(){
        mainMenu.run();
    }
}
