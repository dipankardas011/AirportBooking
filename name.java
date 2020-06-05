import java.io.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class name {
    BufferedReader in =new BufferedReader(new InputStreamReader(System.in));
    String name;
    String t;
    String g;
    int age;
    String dis;
    long no;

    name(){
        name = "";
        t = "";
        g = "";
        age = 0;
        dis = "";
        no = 0;
    }

    public static String timer(){
        LocalDateTime dt = LocalDateTime.now();
        DateTimeFormatter df = DateTimeFormatter.ofPattern("dd-MM-yy HH:mm:ss");
        return (dt.format(df));
    }

    public void accept()throws IOException{
        System.out.println("enter your name, gender,age, phone number and distination");
        name = in.readLine();
        g = in.readLine();
        age = Integer.parseInt(in.readLine());
        no = Long.parseLong(in.readLine());
        dis = in.readLine();
    }

    public void dis(){
        System.out.println("Name: "+name);
        System.out.println("Age: "+age);
        System.out.println("Gender: "+g);
        System.out.println("Phone number: "+no);
        System.out.println("Distination: "+dis);
        System.out.println("Time: "+t);
    }
}