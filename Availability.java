import java.util.Scanner;

public class Availability {
    static Scanner scanner = new Scanner(System.in);
    static String userinput;
    static final int minsDay = 1440;
    static final int minsHr = 60;
    static double runtime;
    static double downtime;
    static float totalTime;
    static float availability;
    static String formattedAvailability;
    static double result;


    static void menu(){



        System.out.println("choose mode \n" +
                "1: calculate availability \n" +
                "2: check minutes for availability");
        try {
            userinput = scanner.nextLine();
            switch (userinput){
                case "1":
                    callCalAvail();
                    break;
                case "2":
                    callMinsAvail();
                    break;
            }
        }catch (Exception ex){
            ex.printStackTrace();
        }
    }

    static void callCalAvail(){
        System.out.println("input total runtime in hours: ");
        runtime = scanner.nextInt();
        System.out.println("input total downtime in hours: ");
        downtime = scanner.nextInt();
        totalTime = (float) ((float) runtime+downtime);
        availability = (float)runtime/totalTime;
        formattedAvailability = String.format("%.4f", availability);
        System.out.printf(formattedAvailability);
    }
    static void callMinsAvail(){
        System.out.println("choose duration : day/hour");
        userinput = scanner.nextLine();
        if (userinput.equals("day")){
            System.out.println("choose availability : 95%, 99.5%, 99.99%, 99.995%, 99.999%");
            String input = scanner.nextLine();
            if(input.equals("95%")) result = (minsDay * 0.5)/100;
            if(input.equals("99.5%")) result = (minsDay * 0.1)/100;
            if(input.equals("99.99%")) result = (minsDay * 0.01)/100;
            if(input.equals("99.995%")) result = (minsDay * 0.005)/100;
            if(input.equals("99.999%")) result = (minsDay * 0.001)/100;
            System.out.println("minutes per day downtime if availability is " + input + " = " + result );
        }else if(userinput.equals("hour")){
            System.out.println("choose availability : 95%, 99.5%, 99.99%, 99.995%, 99.999%");
            String input = scanner.nextLine();
            if(input.equals("95%")) result = (minsHr * 0.5)/100;
            if(input.equals("99.5%")) result = (minsHr * 0.1)/100;
            if(input.equals("99.99%")) result = (minsHr * 0.01)/100;
            if(input.equals("99.995%")) result = (minsHr * 0.005)/100;
            if(input.equals("99.999%")) result = (minsHr * 0.001)/100;
            System.out.println("minutes per day downtime if availability is " + input + " = " + result );
        }

    }

    public static void main(String[] args) {
        menu();
    }

}
