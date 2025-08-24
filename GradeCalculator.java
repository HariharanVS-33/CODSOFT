import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class GradeCalculator {
    
    //calculating total marks by prompting user to enter marks  
    int marktotal(int subcount){
        int iteration = 0;
        Scanner Scan = new Scanner(System.in);
        List<Integer> MarkList = new ArrayList<>();

        //checking the entered value is within the range 
        while (iteration < subcount) {
            System.out.println("Enter subject "+(iteration+1)+" mark:");
            int values = 0;
            values = Scan.nextInt();
            if (values>=0 && values<=100) {
                MarkList.add(values);
                iteration++;
            }
            else{
                System.out.println("Invalid input, please try again");
            }
        }
        int Totalmark = 0;
        for(int num :MarkList){
            Totalmark += num;
        }
        return Totalmark;
    }

    //calculating percentage
    float percentage(int Totalmark, int subcount){
        float Percentage = Totalmark/subcount;
        return Percentage;
    }

    //calculating grade 
    String gradecalc(float Percentage){
        String[] grades = {"F","F","F","F","F","F","D","C","B","A","A"};
        int band = (int) (Percentage / 10);
        String grade = grades[band];
        return grade;
    }

    //Main function
    public static void main(String[] args) {
        Scanner Scan = new Scanner(System.in);
        GradeCalculator object1 = new GradeCalculator();

        System.out.println("enter total subjects:");
        int subjectcount = Scan.nextInt();

        int Totalmark = object1.marktotal(subjectcount);
        System.out.println("\tYour Totalmark = "+Totalmark);

        float Percentage = object1.percentage(Totalmark,subjectcount);
        System.out.printf("\tYour percentage = %.2f\n",Percentage);

        String grade = object1.gradecalc(Percentage);
        System.out.println("\tYour grade = "+grade+"\n");
    }
}
