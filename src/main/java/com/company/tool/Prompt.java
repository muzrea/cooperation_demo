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

    public void promptIllegalInput() {
        System.out.println("\n您输入的格式有误，请重新输入：");
    }

    public void promptInsertStudentInfor() {
        System.out.println("\n请输入学生信息：");
        System.out.println("(格式：学号，姓名)");
        System.out.println("(例如：2016001001，张三)");
    }

    public void promptInsertSubjectInfor() {
        System.out.println("\n请输入课程信息：");
        System.out.println("(格式：课程编号，课程名称)");
        System.out.println("(例如：1001，语文)");
    }

    public void promptInsertTeacherInfor() {
        System.out.println("\n请输入教师信息：");
        System.out.println("(格式：教师编号，姓名)");
        System.out.println("(例如：2016010001，张老师)");
    }

    public void promptInsertStudentScore() {
        System.out.println("\n请输入学生成绩：");
        System.out.println("(格式：学号，课程编号，成绩)");
        System.out.println("(例如：2016001001，1001，80)");
    }

    public void promptInputId() {
        System.out.println("\n请指定学号\\教师编号\\课程编号：");
    }

    public void promptInputStudentId() {
        System.out.println("\n请指定学生的学号：");
    }

    public void promptInputSubject() {
        System.out.println("\n请指定课程的名称：");
    }

    public void promptInputTeacherId() {
        System.out.println("\n请指定教师的编号：");
    }

    public void promptInputStudentAndSubject() {
        System.out.println("\n请指定学生及课程：");
        System.out.println("格式：学号，课程编号");
        System.out.println("例如：2016001001，1001");
    }

    public void promptCurrentInfor() {
        System.out.println("\n当前记录为：");
    }

    public void promptConfirmOperation() {
        System.out.println("\n记录修改后不可复原，请确认是否继续操作（Y/N）：");
    }

    public void promptConfirmDeleteOperation() {
        System.out.println("\n记录删除后不可复原，请确认是否删除（Y/N）：");
    }

    public void promptInputDataForReplacement() {
        System.out.println("\n请输入您要修改的信息：");
        System.out.println("(格式 --> 项目：内容)");
        System.out.println("(例如 --> 姓名：张四)");
    }

    public void promptOperationSucceed() {
        System.out.println("操作成功！");
    }

    public void promptOperationFailed() {
        System.out.println("操作失败！");
    }

}
