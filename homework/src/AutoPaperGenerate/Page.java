package AutoPaperGenerate;

import java.util.List;
import java.util.Scanner;

public class Page {
    //首页
    // public int index(List<User> user){
    //     Scanner input=new Scanner(System.in);
    //     int IndexCommand;
    //     System.out.println("———————————————首页—————————————————");
    //     System.out.println("         0.登录");
    //     System.out.println("         1.退出");
    //     IndexCommand =input.nextInt();
    //     //input.close();
    //     return IndexCommand;
    // }
    //登录页
    public User  Login(List<User> user){
        Scanner input=new Scanner(System.in);
        String userName,passWord;
        System.out.println("—————————登录页————————");
        System.out.println("     用户名     密码  ");
        while(true){
            String []TempVar;
            TempVar = input.nextLine().trim().split(" ");
            userName=TempVar[0];
            passWord=TempVar[1];
            User usertemp;
            usertemp = null;
            for (User value : user) {
                if (userName.equals(value.getUserName()) && passWord.equals(value.getPassWord())) {
                    usertemp = value;
                }
            }
            if(usertemp!=null){
                System.out.println("当前选择为"+usertemp.getStuType()+"出题");
                //input.close();
                return usertemp;
            }else {
                System.out.println("请输入正确的用户名、密码.");
                //input.close();
            }
        }
    }

}
