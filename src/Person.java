import java.time.*;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.Scanner;

public class Person {
    private final String surname;
    private final String name;
    private final String otch;
    private String data;
    private final char gender;
    private final int age;

    int CountAge(String d){
        try {
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd.MM.yyyy");
            LocalDate start = LocalDate.parse(d, formatter);
            LocalDate end = LocalDate.now();
            Period period = Period.between(start, end);
            while (period.getYears() <= 0) {
                System.out.println("Warning! Age is non-positive number! The result of the program working can be incorrect!\nDo you want to enter correct date of birth? (1-yes, 2-no)");
                Scanner console = new Scanner(System.in);
                int c = console.nextInt();
                if (c == 2)
                    break;
                System.out.println("Enter date of birth");
                data = console.nextLine();
                data = console.nextLine();
                start = LocalDate.parse(data, formatter);
                period = Period.between(start, end);
            }
            return period.getYears();
        }catch (DateTimeParseException e){
            System.out.println("Error! Wrong format of the birth date! Birth date should be entered in format ДД.ММ.ГГГГ!");
        }
        return -1;
    }
    char DetectGender(String o){
        if (o!=null && o.charAt(o.length()-1)=='ч')
            return 'М';
        else if (o!=null && o.charAt(o.length()-1)=='a')
            return 'Ж';
        else {
            System.out.println("Warning! Gender is not detected!");
            return '-';
        }
    }
    Person(String s, String n, String o, String d){
        surname=s;
        name=n;
        otch=o;
        data=d;
        age=CountAge(d);
        gender=DetectGender(o);
    }
    void PrintData(){
        System.out.print(surname+' '+name.charAt(0)+'.'+otch.charAt(0)+".  "+gender+"  "+age+' ');
        if (age%10==1 && (age<10 || age>20))
            System.out.println("год");
        else if (age%10>1 && age%10<5)
            System.out.println("года");
        else System.out.println("лет");
    }
}
