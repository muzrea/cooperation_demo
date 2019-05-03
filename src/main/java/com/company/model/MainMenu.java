package main.java.com.company.model;

import java.util.HashMap;
import java.util.Map;

public class MainMenu {
    private String roleName;
    private Map<String, String> allOptions;
    private Map<String, String> availableOptions;

    public MainMenu() {
        this.allOptions = new HashMap<>();
        this.availableOptions = new HashMap<>();
        this.generateAllOptions();
    }

    private void generateAllOptions() {
        this.allOptions.put("1.1.1", "查询所有学生信息");
        this.allOptions.put("1.1.2", "查询指定学生姓名的信息以及所有课程的成绩");
        this.allOptions.put("1.1.3", "查询指定老师的所有学生及其成绩");
        this.allOptions.put("1.1.4", "查询指定课程的所有学生及其成绩");
        this.allOptions.put("1.2.1", "查询所有课程信息");
        this.allOptions.put("1.2.2", "查询指定课程名称的信息");
        this.allOptions.put("1.2.3", "查询指定老师的所有课程信息");
        this.allOptions.put("1.3.1", "查询所有老师信息");
        this.allOptions.put("1.3.2", "查询指定老师信息");
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
        this.allOptions.put("5", "退出");
    }

    public String getRoleName() {
        return this.roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

    public Map<String, String> getAvailableOptions() {
        return this.availableOptions;
    }

    public void setAvailableOptions(Role role) {
        if (role.getName().equals("管理员")) {
            this.availableOptions = this.allOptions;
        } else {
            role.getProfiles()
                    .forEach(
                            item -> this.availableOptions.put(item.getId(), this.allOptions.get(item.getId()))
                    );
        }
    }
}
