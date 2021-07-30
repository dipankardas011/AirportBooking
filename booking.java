import java.io.IOException;
import java.util.*;
import java.io.*;


public class booking extends name{
    static String A[][] = new String [20][5];
    static int i,j;
    booking(){
        for(int i=0;i<20;i++){
            for(int j=0;j<5;j++){
                A[i][j] = "";
            }
        }
    }

    String book(char ch){
        String seat = "";
        
        if (ch == 'w'){
            for(i=0;i<20;i++){
                for(j=0;j<5;j++){
                    if((j==0 || j==4) && (A[i][j].length() == 0)){
                        int d=j+65;
                        int k=i+1;
                        seat=k+""+(char)d;
                        return seat;
                    }
                }
            }
            return "-x99w";
        }
        else{
            for(i=0;i<20;i++){
                for(j=0;j<5;j++){
                    if((j!=0 && j!=4) && (A[i][j].length() == 0)){
                        int d=j+65;
                        int k=i+1;
                        seat=k+""+(char)d;
                        return seat;
                    }
                }
            }
            return "-x99*";
        }
    }

    void message(){
        System.out.println("===========\nthank you !\n============");
        System.exit(0);
    }

    void display()
    {
        for(i=0;i<20;i++){
            for(int j=0;j<5;j++){
                if(A[i][j].length()==0)
                System.out.println("*(E)");
                else
                System.out.println(A[i][j]);
            }
        }
    }

    static void welcomeStart(){
        System.out.println("+=====================================+");
        System.out.println("| Welcome to the DD AIRLINES PVT LTD. |");
        System.out.println("+=====================================+");
    }

    public static void main(String[] args) throws IOException{
        Scanner in=new Scanner(System.in);
        booking ob1=new booking();
        welcomeStart();
        System.out.println("Enter the destination for the airplane..");
        String destination = in.nextLine();
        int pos=0;
        while(true){
            
            System.out.println("Enter [y] to book ticket and [n] to quit");
            char cae=in.next().charAt(0);
            switch(cae){
                case 'y':
                    pos++;
                    if(pos==101){
                        System.out.println("SORRY! \n but No more passengers allowed");
                        ob1.message();
                    }
                    System.out.println("Enter (w) to book a windows seat or (n) to book a aisle seat");
                    char m=in.next().charAt(0);
                    if(m=='w')
                    {
                        String fr=ob1.book(m);
                        String side="Window seat";
                        if(fr.equals("-x99w")){
                            System.out.println("sorry no window seat avilable so a non windows seta is booked");
                            fr=ob1.book('n');
                            side="Aisle seat";
                        }
                        name ob=new name();
                        ob.accept(destination);
                        ob.t=timer();
                        ob.dis();
                        System.out.println("Seat no.: "+fr);
                        String x="";
                        x = ob.name+", "+ob.age+", "+ob.g+", "+ob.no+", "+ob.dis+", "+ob.t+", "+fr+", "+side;
                        A[i][j]=x;
                    }
                    else{
                        String fr=ob1.book(m);
                        String side="Aisle seat";
                        name ob=new name();
                        ob.accept(destination);
                        ob.t=timer();
                        ob.dis();
                        System.out.println("Seat no.: "+fr);
                        String x="";
                        x = ob.name+", "+ob.age+", "+ob.g+", "+ob.no+", "+ob.dis+", "+ob.t+", "+fr+", "+side;
                        A[i][j]=x;
                    }
                    break;
                    case 'n':
                    ob1.display();
                    ob1.csv();
                    ob1.details();
                    ob1.dat();
                    ob1.message();
                    in.close();
                    break;
                default: System.out.println("wrong input decided");
            }
        }
    }

    int tickets(){
        int count=0;
        for(int i=0;i<20;i++){
            for(int j=0;j<5;j++){
                if(A[i][j].length()>0)
                count++;
            }
        }
        return count;
    }

    void csv()throws IOException{
        
        FileWriter a=new FileWriter("airport tickets.csv");
        BufferedWriter b=new BufferedWriter(a);
        PrintWriter c=new PrintWriter(b);
        c.println(",");
        c.println(",,,,DD AIRLINES PVT LTD.");
        c.println("DATE-TIME: "+timer());
        c.println(",");
        c.println("Name, Age, Gender, Phone_number, Destination, time, Seat_number, Seat_type");

        for(i=0;i<20;i++){
            for(int j=0;j<5;j++){
                if(A[i][j].length()==0)
                c.println("*(E), *(E), *(E), *(E), *(E), *(E), *(E), *(E)");
                else
                c.println(A[i][j]);
            }
        }
        c.println("number of tickets booked: "+tickets());
        c.close();
    }

    void details()throws IOException{
        FileWriter a=new FileWriter("airplane.txt");
        BufferedWriter b=new BufferedWriter(a);
        PrintWriter c=new PrintWriter(b);
        c.println("LOG FILE");
        c.println("DATE-TIME: "+timer());
        c.println("Symbol (O) MEANS BOOKED AND (E) MEANS EMPTY SEATS");
        c.println("");
        c.println("S.No.\t  A\t  B\t  C\t|  |\t  D\t  E");
        c.println("");
        for(int i=0;i<20;i++){
            c.print((i+1)+"\t");
            for(int j=0;j<5;j++){
                if(j==3){
                    c.print("|  |"+"\t");
                }
                if(j==0 || j==4){
                    c.print("(w)");
                }
                else{
                    c.print("(a)");
                }
                if(A[i][j].length()==0)
                c.print("E\t");
                else
                c.print("O\t");
            }
            c.println("");
        }
        c.close();
    }

    void dat()throws IOException{
        FileWriter a=new FileWriter("data.txt");
        BufferedWriter b=new BufferedWriter(a);
        PrintWriter c=new PrintWriter(b);
        for(int i=0;i<20;i++){
            for(int j=0;j<5;j++){
                if(A[i][j].length()>0)
                c.print("1");
                else
                c.print("0");
            }
            c.println();
        }
        c.close();
    }
}