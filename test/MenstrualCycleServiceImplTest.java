import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import java.util.List;


class MenstrualCycleServiceImplTest {
    MenstrualCycleService menstrualCycleService = new MenstrualCycleServiceImpl();

    @BeforeEach
    void setUp() {
    }

    @Test
    void testGetMenstrualPeriodDates() {
        List<String> responses = menstrualCycleService.getMenstrualPeriodDates(LocalDate.of(2023, 4, 1), 5, 28);
        System.out.println(responses);
    }


    @Test
    void testGetOvulationDate() {
        String response = menstrualCycleService.getOvulationDate(LocalDate.of(2023, 4, 1), 28);
        System.out.println(response);
    }
    @Test
    void testGetFertilityDates() {
        List<String> responses = menstrualCycleService.getFertilityDates(LocalDate.of(2023, 4, 1), 28);
            System.out.println(responses);
    }
}
