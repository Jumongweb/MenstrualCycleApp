import java.time.LocalDate;

public class MenstrualCycle {
    private String periodStartDate;
    private int periodLength;
    private int periodCycleLength;

    public void setPeriodStartDate(String periodStartDate){
        this.periodStartDate = periodStartDate;
    }
    public String getPeriodStartDate(){
        return  periodStartDate;
    }
    public void setPeriodLength(int periodLength){
        if (periodLength < 4 || periodLength > 7){
            System.out.println("Average length is 4 - 7");
            System.out.println("Go and see a doctor");
        }
        this.periodLength = periodLength;
    }
    public int getPeriodLength(){
        return periodLength;
    }
    public void setPeriodCycleLength(int periodCycleLength){
        this.periodCycleLength = periodCycleLength;
    }
    public int getPeriodCycleLength(){
        return periodCycleLength;
    }

    /*public LocalDate getNextPeriod(){
        int totalDays = getPeriodLength() + getPeriodCycleLength();
        LocalDate startDate = LocalDate.parse(getPeriodStartDate());

        return startDate.plusDays(totalDays);
    } */
    public String getNextPeriod(String date){
        int totalDays = getPeriodLength() + getPeriodCycleLength();
        LocalDate startDate = LocalDate.parse(getPeriodStartDate());
        date = String.valueOf(startDate.plusDays(totalDays));
        return date;
    }
    public LocalDate getNextOvulation(){
        int ovulation = getPeriodCycleLength() / 2;
        int totalDays = getPeriodLength() + getPeriodCycleLength() + ovulation;
        LocalDate ovulationDate = LocalDate.parse(getPeriodStartDate());

        return ovulationDate.plusDays(totalDays);
    }
    public LocalDate getFertilePeriodBeforeOvulation(){
        int ovulation = getPeriodCycleLength() / 2;
        int totalDays = (getPeriodLength() + getPeriodCycleLength() + ovulation) - 6;
        LocalDate fertileDateBeforeOvulation = LocalDate.parse(getPeriodStartDate());

        return fertileDateBeforeOvulation.plusDays(totalDays);
    }
    public LocalDate getFertilePeriodAfterOvulation(){
        int ovulation = getPeriodCycleLength() / 2;
        int totalDays = (getPeriodLength() + getPeriodCycleLength() + ovulation) + 1;
        LocalDate fertileDateBeforeOvulation = LocalDate.parse(getPeriodStartDate());

        return fertileDateBeforeOvulation.plusDays(totalDays);
    }
    public LocalDate getSafeDayStart(){
        int totalDays = getPeriodLength() + getPeriodCycleLength();
        LocalDate startDate = LocalDate.parse(getPeriodStartDate());

        return startDate.plusDays(totalDays + getPeriodLength());
    }
    public LocalDate getSafeDayEnd(){
        int ovulation = getPeriodCycleLength() / 2;
        int totalDays = (getPeriodLength() + getPeriodCycleLength() + ovulation) - 6;
        LocalDate fertileDateBeforeOvulation = LocalDate.parse(getPeriodStartDate());

        return fertileDateBeforeOvulation.plusDays(totalDays);
    }
}
