import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        System.out.println("Введите ФИО и дату рождения в формате дд.мм.гггг");
        Scanner console=new Scanner(System.in);
        String s=console.nextLine();
        String[] words=s.split(" ");
        try {
            Person p = new Person(words[0], words[1], words[2], words[3]);
        p.PrintData();
        }catch (ArrayIndexOutOfBoundsException e){
            System.out.println("Error! The format of data is incorrect! Enter correct info in 3 words and 1 date (format ДД.ММ.ГГГГ!");
        }
    }
}