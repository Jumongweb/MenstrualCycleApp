import java.util.Scanner;

public class Main{
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        MenstrualCycle menstrualCycle = new MenstrualCycle();
        System.out.println("Changes");
        System.out.println("Two");
        System.out.println("MENSTRUAL CYCLE TRACKER\n");
        System.out.print("Which did your last period start (yyyy-mm-dd): ");
        String startDate = scanner.nextLine();
        menstrualCycle.setPeriodStartDate(startDate);

        System.out.print("For how many days did you bleed. Ranges(2 - 7): ");
        int bleedingLength = scanner.nextInt();
        while(bleedingLength < 2 || bleedingLength > 7){
            System.out.println("You need to see a doctor");
            System.out.println("Normal bleeding days should be 2 - 7 days");
            System.out.println("You can try again, if the previous response was a mistake");
            System.out.print("For how many days did you bleed. Ranges(2 - 7): ");
            bleedingLength = scanner.nextInt();
        }
        menstrualCycle.setPeriodLength(bleedingLength);

        System.out.print("What is the length of your menstrual cycle. Ranges(23 - 35 days): ");
        int cycleLength = scanner.nextInt();
        while(cycleLength < 23 || cycleLength > 35){
            System.out.println("You need to see a doctor");
            System.out.println("Normal cycleLength ranges from 23 - 35: ");
            System.out.println("You can try again, if the previous response was a mistake");
            System.out.print("What is the length of your menstrual cycle. Ranges(23 - 35 days): ");
            cycleLength = scanner.nextInt();
        }
        menstrualCycle.setPeriodCycleLength(cycleLength);

        System.out.println();
        /* 10 */
        System.out.println("===============================================================");
        System.out.println("RESULT");
        System.out.println("Your next period date is " + menstrualCycle.getNextPeriod());
        System.out.println("Your next ovulation date is " + menstrualCycle.getNextOvulation());
        System.out.println("Your fertile period is " + menstrualCycle.getFertilePeriodBeforeOvulation() + " - " + menstrualCycle.getFertilePeriodAfterOvulation());
        System.out.println("Your safe period start on " + menstrualCycle.getSafeDayStart() + " end before " + menstrualCycle.getSafeDayEnd());
        System.out.println("===============================================================");
    }
}