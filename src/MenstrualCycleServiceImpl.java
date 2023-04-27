import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.stream.Stream;

public class MenstrualCycleServiceImpl implements MenstrualCycleService{
    @Override
    public List<String> getMenstrualPeriodDates(LocalDate startDate, int  numberOfDays, int cycleLength) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("EEEE, dd/MM/yyyy");
        return Stream.iterate(startDate.plusDays(cycleLength), plusDay -> plusDay.plusDays(1))
                .limit(numberOfDays)
                .map(formatter::format)
                .toList();
    }

    @Override
    public String getOvulationDate(LocalDate periodDate, int cycleLength) {
        periodDate = periodDate.plusDays(cycleLength).minusDays(14);
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("EEEE, dd/MM/yyyy");
        return formatter.format(periodDate);
    }

    @Override
    public List<String> getFertilityDates(LocalDate lastPeriodDate, int cycleLength) {
        lastPeriodDate = lastPeriodDate.plusDays(cycleLength).minusDays(14).minusDays(4);
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("EEEE, dd/MM/yyyy");
        return Stream.iterate(lastPeriodDate, fertile -> fertile.plusDays(1))
                .limit(4)
                .map(formatter::format)
                .toList();
    }
}
