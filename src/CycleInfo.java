import java.util.ArrayList;
import java.util.List;

public class CycleInfo {
    private List<String> menstrualDates = new ArrayList<>();
    private List<String> fertilityDates = new ArrayList<>();
    private String ovulationDate;

    public CycleInfo() {
    }

    public void setMenstrualDates(List<String> menstrualDates) {
        this.menstrualDates = menstrualDates;
    }

    public void setFertilityDates(List<String> fertilityDates) {
        this.fertilityDates = fertilityDates;
    }

    public void setOvulationDate(String ovulationDate) {
        this.ovulationDate = ovulationDate;
    }

    public List<String> getMenstrualDates() {
        return menstrualDates;
    }

    public List<String> getFertilityDates() {
        return fertilityDates;
    }

    public String getOvulationDate() {
        return ovulationDate;
    }

    @Override
    public String toString() {
        return String.format("""
                Cycle Info:
                Menstrual Dates -> %s
                Ovulation Date -> %s
                Fertility Dates -> %s
              
                """, getMenstrualDates(), getOvulationDate(), getFertilityDates());
    }
}
