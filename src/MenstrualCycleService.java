import java.time.LocalDate;
import java.util.List;

public interface MenstrualCycleService {
    List<String> getMenstrualPeriodDates(LocalDate startDate, int numberOfDays, int cycle);
    String getOvulationDate(LocalDate periodDate, int cycle);
    List<String> getFertilityDates(LocalDate lastPeriodDate, int cycle);
}
