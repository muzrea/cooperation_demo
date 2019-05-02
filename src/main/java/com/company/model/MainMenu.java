package main.java.com.company.model;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MainMenu {
    private String roleName;
    private Map<String, String> allOptions;
    private Map<String, String> availabelOptions;

    public MainMenu() {
        this.allOptions = new HashMap<>();
        this.availabelOptions = new HashMap<>();
        this.generateAllOptions();
    }

    private void generateAllOptions() {
        this.allOptions.put("1.1.1", "所有学生信息");
        this.allOptions.put("1.1.2", "指定学生姓名的信息以及所有课程的成绩");
        this.allOptions.put("1.1.3", "指定老师的所有学生及其成绩");
        this.allOptions.put("1.1.4", "指定课程的所有学生及其成绩");
        this.allOptions.put("1.2.1", "所有课程信息");
        this.allOptions.put("1.2.2", "指定课程名称的信息");
        this.allOptions.put("1.2.3", "指定老师的所有课程信息");
        this.allOptions.put("1.3.1", "所有老师信息");
        this.allOptions.put("1.3.2", "指定老师信息");
        this.allOptions.put("2.1", "新增学生信息");
        this.allOptions.put("2.2", "新增课程信息");
        this.allOptions.put("2.3", "新增老师信息");
        this.allOptions.put("2.4", "给指定学生新增成绩");
        this.allOptions.put("3.1", "修改指定学号的学生");
        this.allOptions.put("3.2", "修改指定课程的信息");
        this.allOptions.put("3.3", "修改指定老师的信息");
        this.allOptions.put("3.4", "修改指定学生的成绩");
        this.allOptions.put("4.1", "删除指定学生");
        this.allOptions.put("4.2", "删除指定课程");
        this.allOptions.put("4.3", "删除指定老师");
        this.allOptions.put("5.", "退出");
    }

    public String getRoleName() {
        return this.roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

    public Map<String, String> getAllOptions() {
        return this.allOptions;
    }

    public Map<String, String> getAvailableOptions() {
        return this.availabelOptions;
    }

    public void setAvailableOptions(List<Profile> profiles) {
        profiles.forEach(item -> this.availabelOptions.put(item.getId(), this.allOptions.get(item.getId())));
    }
}
