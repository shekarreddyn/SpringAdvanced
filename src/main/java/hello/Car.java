package hello;
import java.util.*;


public class Car {

    private String carName;
    private Integer makeYear;
    private Integer engineCapacity;
    private List<String> components;

    public List<String> getComponents() {
        return components;
    }

    public void setComponents(List<String> components) {
        this.components = components;
    }

    public String getCarName() {

        return carName;
    }

    public void setCarName(String carName) {
        this.carName = carName;
    }

    public Integer getMakeYear() {
        return makeYear;
    }

    public void setMakeYear(Integer makeYear) {
        this.makeYear = makeYear;
    }

    public Integer getEngineCapacity() {
        return engineCapacity;
    }

    public void setEngineCapacity(Integer engineCapacity) {
        this.engineCapacity = engineCapacity;
    }
}
