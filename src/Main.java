import javax.swing.*;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

public class Main {
    private static final MenstrualCycleService menstrualCycleService = new MenstrualCycleServiceImpl();

    public static void main(String[] args) {
        print("""
                Menstrual Cycle Tracking App
                """);
        String lastPeriodStartDate = input("Enter the period start date in the format dd/MM/yyyy: ");
        int numberOfDays = Integer.parseInt(input("How many days did the blood flow?: "));
        int cycleLength = Integer.parseInt(input("Enter you cycle length: "));
        LocalDate date = parseDate(lastPeriodStartDate);
        int cycleNumber = Integer.parseInt(input("How many month cycle do you want to see? "));
        while (cycleNumber > 0){
            List<String> periodDays = menstrualCycleService.getMenstrualPeriodDates(date, numberOfDays, cycleLength);
            List<String> fertilityDates = menstrualCycleService.getFertilityDates(date, cycleLength);
            String ovulationDay = menstrualCycleService.getOvulationDate(date, cycleLength);

            CycleInfo cycleInfo = new CycleInfo();
            cycleInfo.setMenstrualDates(periodDays);
            cycleInfo.setOvulationDate(ovulationDay);
            cycleInfo.setFertilityDates(fertilityDates);
            print(cycleInfo);

            date = date.plusDays(28);
            cycleNumber--;
        }
        print("""
                Thank you for using my Menstrual app Tracker
                Those of you looking for safe days,
                Eh eh eh eh you no go see shi shi
                Always stay safe
                Thank you once again!!!
                """);
    }
    private static LocalDate parseDate(String date){
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        return LocalDate.parse(date, formatter);
    }

    private static void print(Object prompt) {
        JOptionPane.showMessageDialog(null, prompt);
    }

    private static String input(String prompt) {
        return JOptionPane.showInputDialog(null, prompt);
    }
}
