package project;

import project.controller.MenuController;

/**
 * @ClassName Test
 * @Description TODO
 * @Author lixingyong
 * @Date 2018/12/26 10:33
 * @Version 1.0
 */
public class Test {
    public static void main(String[] args){
        MenuController menuController = MenuController.getMenu();
        while(true){
            menuController.Menu();
        }
    }
}
