package cs1302.p2;

import javafx.scene.control.MenuBar;
import javafx.scene.layout.FlowPane;
import javafx.stage.Stage;

public class MainMenu extends MenuBar{

public MainMenu(Stage screams, ImgPane imgpain){
super();
FileMenu hoho = new FileMenu(screams,imgpain);
getMenus().add(hoho);
setUseSystemMenuBar(true);
}

public MainMenu(FlowPane img1, FlowPane img2, Stage screams){
super();
}

}