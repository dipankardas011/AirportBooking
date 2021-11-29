import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

public class BookingMain extends Acceptinput {
    String[][] seatArrangment;
    final int seatsRows = 20;
    final int seatsCols = 5;
    static int i,j;
    BookingMain(){
        seatArrangment = new String[seatsRows][seatsCols];
        for (i = 0; i < seatsRows; i++) {
            for (j = 0; j < seatsCols; j++) {
                seatArrangment[i][j] = "";
            }
        }
    }

    String bookTicket(char ch){
        String seat = "";

        if(ch == 'w'){
            for (i = 0; i < seatsRows; i++) {
                for (j = 0; j < seatsCols; j++) {
                    if((j==0 || j==seatsCols-1) &&
                        seatArrangment[i][j].length()==0){
                        int d = j+65;
                        int k=i+1;
                        seat = k+""+(char)d;
                        return seat;
                    }
                }
            }

            return "-x99w";
        } else {
            for (i = 0; i < seatsRows; i++) {
                for (j = 1; j < seatsCols-1; j++) {
                    if(seatArrangment[i][j].length()==0){
                        int d = j+65;
                        int k=i+1;
                        seat = k+""+(char)d;
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

    void displayInfo(){
        for (i = 0; i < seatsRows; i++) {
            for (j = 0; j < seatsCols; j++) {
                if(seatArrangment[i][j].length()==0)
                    System.out.println("*(E)");
                else
                    System.out.println(seatArrangment[i][j]);
            }
        }
    }

    static void welcomeStart(){
        System.out.println("+=====================================+");
        System.out.println("| Welcome to the DD AIRLINES PVT LTD. |");
        System.out.println("+=====================================+");
    }

    int tickets(){
        int count = 0;
        for (i = 0; i < seatsRows; i++) {
            for (j = 0; j < seatsCols; j++) {
                if(seatArrangment[i][j].length() > 0)
                    count++;
            }
        }
        return count;
    }

    void csv() throws IOException {
        FileWriter a = new FileWriter("airportTickets.csv");
        BufferedWriter b = new BufferedWriter(a);
        PrintWriter c = new PrintWriter(b);

        c.println(",");
        c.println(",,,,DD AIRLINES PVT LTD.");
        c.println("DATE-TIME: "+timer());
        c.println(",");
        c.println("Name, Age, Gender, Phone_number, Destination, time, Seat_number, Seat_type");

        for (i = 0; i < seatsRows; i++) {
            for (j = 0; j < seatsCols; j++) {
                if(seatArrangment[i][j].length()==0){
                    c.println("*(E), *(E), *(E), *(E), *(E), *(E), *(E), *(E)");
                } else {
                    c.println(seatArrangment[i][j]);
                }
            }
        }
        c.println("Number of tickets booked: " + tickets());

        c.close();
    }

    void details()throws IOException{
        FileWriter a = new FileWriter("airplane.txt");
        BufferedWriter b = new BufferedWriter(a);
        PrintWriter c = new PrintWriter(b);
        c.println("LOG FILE");
        c.println("DATE-TIME: "+timer());
        c.println("Symbol (O) MEANS BOOKED AND (E) MEANS EMPTY SEATS");
        c.println("");
        c.println("S.No.\t  A\t  B\t  C\t|  |\t  D\t  E");
        c.println("");

        for (i = 0; i < seatsRows; i++) {
            c.print((i+1)+"\t");
            for (j = 0; j < seatsCols; j++) {
                if(j==3){
                    c.print("|  |"+"\t");
                } else if(j==0 || j==4){
                    c.print("(w)");
                } else {
                    c.print("(w)");
                    c.print("(a)");
                }
                if(seatArrangment[i][j].length()==0)
                    c.print("E\t");
                else
                    c.print("O\t");
            }
            c.println("");
        }
        c.close();
    }

    void data()throws IOException{
        FileWriter a = new FileWriter("data.txt");
        BufferedWriter b = new BufferedWriter(a);
        PrintWriter c = new PrintWriter(b);

        for (i = 0; i < seatsRows; i++) {
            for (j = 0; j < seatsCols; j++) {
                if(seatArrangment[i][j].length()>0)
                    c.print("1");
                else
                    c.print("0");
            }
            c.println();
        }
        c.close();
    }

    public static void main(String[] args) throws IOException {
        Scanner in = new Scanner(System.in);

        BookingMain obj = new BookingMain();

        welcomeStart();
        System.out.print("Enter the destination for the airplane\n-> ");
        String destination = in.nextLine();
        int pos = 0;
        while (true) {
            System.out.println("Enter [Y] to book ticket and [n] to quit");
            char choice = in.next().charAt(0);
            switch (choice) {
                case 'y', 'Y' -> {
                    pos++;
                    if (pos == (obj.seatsRows * obj.seatsCols) + 1) {
                        System.out.println("SORRY! \n but No more passengers allowed");
                        obj.message();
                    }
                    System.out.println("Enter (w) to book a windows seat or (n) to book a aisle seat");
                    char m = in.next().charAt(0);
                    String fr = "", side = "";
                    if (m == 'w') {
                        fr = obj.bookTicket(m);
                        side = "Window seat";

                        if (fr.equals("-x99w")) {
                            System.out.println("sorry no window seat avilable so a non windows seat is booked");
                            fr = obj.bookTicket('n');
                            side = "Aisle seat";
                        }
                    } else {
                        fr = obj.bookTicket(m);
                        side = "Aisle seat";
                    }
                    Acceptinput obj1 = new Acceptinput();
                    obj1.accept(destination);
                    obj1.t = timer();
                    obj1.dis();
                    System.out.println("Seat No.: " + fr);
                    String x = "";
                    x = obj1.name + ", " + obj1.age + ", " + obj1.g + ", " + obj1.no + ", " + obj1.dis + ", " + obj1.t + ", " + fr + ", " + side;

                    obj.seatArrangment[i][j] = x;
                }
                case 'n', 'N' -> {
                    obj.displayInfo();
                    obj.csv();
                    obj.details();
                    obj.data();
                    obj.message();
                    in.close();
                }
                default -> System.out.println("wrong input decided");
            }
        }
    }
}
