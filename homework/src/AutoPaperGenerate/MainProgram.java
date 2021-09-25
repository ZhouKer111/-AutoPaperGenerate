package AutoPaperGenerate;


import java.util.List;
import java.util.Scanner;

public class MainProgram {

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);
        MainJob Job = new MainJob();
        Page page = new Page();
        List<User> user;
        user = Job.userSet();
        /*首页
         *int judgeVar;
        judgeVar=page.index(user);
        if(judgeVar==1){
            System.out.println("欢迎再次光临");
            System.exit(0);
        }*/
        User teacher;
        teacher = page.Login(user);
        while (true) {
            String questions;
            int questions_N = 0;
            boolean flag = false;
            System.out.println("准备生成" + teacher.getStuType() + "数学题目，请输入生成题目数量（输入-1将退出当前用户，重新登录）：");
            questions = input.nextLine().trim();
            if (questions.equals("-1")) {
                teacher = page.Login(user);
            } else if (Job.composition(questions) == 1) {
                questions_N = Integer.parseInt(questions);
                flag = true;
                if (questions_N < 10 || questions_N > 30) {
                    System.out.println("题目数量的有效输入范围是“10-30”,请重新输入（含10,30，或-1退出登录）");
                }
            } else {
                if (questions.contains("切换为")) {
                    switch (questions) {
                        case "切换为小学":
                            teacher.setStuType("小学");
                            break;
                        case "切换为初中":
                            teacher.setStuType("初中");
                            break;
                        case "切换为高中":
                            teacher.setStuType("高中");
                            break;
                        default:
                            System.out.println("请输入小学、初中和高中三个选项中的一个");
                            break;
                    }
                } else {
                    System.out.println("请正确输入内容");
                }
            }
            if (flag) {
                Job.paperFolderGenerate(questions_N, teacher);
            }

        }

    }

}
