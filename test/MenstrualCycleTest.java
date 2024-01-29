import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

class MenstrualCycleTest {
    private MenstrualCycle menstrualCycle;

    @Test
    public void shouldSetAndReturnPeriodLength(){
        menstrualCycle.setPeriodLength(5);
        assertEquals(5, menstrualCycle.getPeriodLength());
    }
    @Test
    public void shouldSetAndReturnPeriodCycle(){
        menstrualCycle.setPeriodCycleLength(28);
        assertEquals(28, menstrualCycle.getPeriodCycleLength());
    }

    @Test
    public void shouldSetAndReturnPeriodStartDay(){
        menstrualCycle.setPeriodStartDate("2024-10-10");
        assertEquals("2024-10-10", menstrualCycle.getPeriodStartDate());
    }
    @BeforeEach
    public void beforeEachMethod(){
        menstrualCycle = new MenstrualCycle();
    }
    @Test
    public void shouldReturnNextPeriod(){
        menstrualCycle.setPeriodStartDate("2024-01-10");
        LocalDate startDate = LocalDate.parse(menstrualCycle.getPeriodStartDate());

        assertEquals(startDate, menstrualCycle.getNextPeriod());
    }
}