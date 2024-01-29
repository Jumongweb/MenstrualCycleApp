import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

class MenstrualCycleTest {
    @Test
    public void shouldReturnPeriodStartDate(){
        MenstrualCycle menstrualCycle = new MenstrualCycle();
        menstrualCycle.setPeriodStartDate("2024-01-10");
        LocalDate startDate = LocalDate.parse(menstrualCycle.getPeriodStartDate());

        assertEquals("2024-02-05", menstrualCycle.getNextPeriod());
    }
}