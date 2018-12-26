package project.controller;
import java.util.Scanner;

import static project.utils.Print.*;
/**
 * @ClassName MenuController
 * @Description TODO
 * @Author lixingyong
 * @Date 2018/12/26 11:00
 * @Version 1.0
 */
public class MenuController {
    private int menuNum = 0;
    private InfoController infoController = new InfoController();
    private static class MenuControllerInstance {
        private static final MenuController MENU = new MenuController();
    }

    private MenuController(){

    }

    public void Menu(){
        println("****************成绩管理系统**************");
        println("**\t\t\t 姓名： zhangsan \t\t\t**");
        println("**\t\t\t 1、新增学生信息 \t\t\t**");
        println("**\t\t\t 2、输出学生信息 \t\t\t**");
        println("**\t\t\t 3、修改学生信息 \t\t\t**");
        println("**\t\t\t 4、导出学生信息 \t\t\t**");
        println("*****************************************");
        Scanner sb = new Scanner(System.in);
        print("请输入对应的序号进入功能，输入0退出:");
        do {
            try {
                menuNum = Integer.valueOf(sb.nextLine());
                if(menuNum > 0 && menuNum < 5){
                    break;
                }else if(menuNum == 0){
                    println("感谢使用成绩管理系统");
                    System.exit(3 * 1000);
                }
            }catch (Exception e){
                println("请输入整数！");
            }
            print("请输入0-4之间的数：");
        }while (true);

        switch (menuNum){
            case 1:
                infoController.addStudentInfo();
                break;
            case 2:
                infoController.showStudentInfo();
                break;
            case 3:
                infoController.updateStudentInfo();
                break;
            case 4:
                infoController.exportStudentInfo();
                break;
            default:
                break;
        }
    }

    public static MenuController getMenu(){
        return MenuControllerInstance.MENU;
    }
}
