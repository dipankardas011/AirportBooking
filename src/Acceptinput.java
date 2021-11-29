package src;

import java.io.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Acceptinput {
    BufferedReader in =new BufferedReader(new InputStreamReader(System.in));
    String name;
    String t;
    String g;
    int age;
    String dis;
    long no;

    Acceptinput(){
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

    public void accept(String d)throws IOException{
        System.out.println("\n+--------------------+");
        System.out.println("| Enter your details |");
        System.out.println("+--------------------+");
        System.out.println("\nYour Name..");
        name = in.readLine();
        System.out.println("\nYour Gender..");
        g = in.readLine();
        System.out.println("\nYour Age..");
        age = Integer.parseInt(in.readLine());
        System.out.println("\nYour Phone number..");
        no = Long.parseLong(in.readLine());
        dis = d;
    }

    public void dis(){
        System.out.println("\n\t=============");
        System.out.println("\t~~ SUMMARY ~~");
        System.out.println("\tName: "+name);
        System.out.println("\tAge: "+age);
        System.out.println("\tGender: "+g);
        System.out.println("\tPhone number: "+no);
        System.out.println("\tDistination: "+dis);
        System.out.println("\tTime: "+t);
        System.out.println("\t=============\n");
    }
}