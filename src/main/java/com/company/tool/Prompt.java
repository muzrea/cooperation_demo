package main.java.com.company.tool;

import main.java.com.company.model.MainMenu;

public class Prompt {

    public void promptWelcome() {
        System.out.println("您好，欢迎登陆学生考试系统！");
    }

    public void promptInputUsername() {
        System.out.println("请输入您的用户名：");
    }

    public void promptInputPassword() {
        System.out.println("请输入您的密码：");
    }

    public void promptIllegalLoginInfor() {
        System.out.println("\n用户名或密码有误，请重新输入");
    }

    public void promptOperationOptions(MainMenu mainMenu) {
        System.out.println("\n您好，" + mainMenu.getRoleName() + "，请选择你需要进行的操作：");
        mainMenu.getAvailableOptions().forEach((k, v) -> System.out.println(k + " " + v));
    }

    public void promptIllegalOption() {
        System.out.println("\n您的输入有误，请输入操作对应的编号：");
    }

    public void promptInputStudentName() {
        System.out.println("\n请输入学生姓名：");
    }

    public void promptInputTeacherName() {
        System.out.println("\n请输入教师姓名：");
    }

    public void promptInputSubjectName() {
        System.out.println("\n请输入课程名称:");
    }

    public void promptCurrentInfor() {
        System.out.println("\n当前记录为：");
    }

    public void promptConfirmOperation() {
        System.out.println("\n记录修改后不可复原，请确认是否继续操作（Y/N）：");
    }

    public void promptOperationSucceed() {
        System.out.println("操作成功！");
    }

    public void promptOperationFailed() {
        System.out.println("操作失败！");
    }

}
