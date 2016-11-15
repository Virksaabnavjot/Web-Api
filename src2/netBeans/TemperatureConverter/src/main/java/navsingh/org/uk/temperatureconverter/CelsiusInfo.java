package navsingh.org.uk.temperatureconverter;

/**
 *
 * @author Navjot Virk
 */
public class CelsiusInfo {
    double fahrenheit;
    double celsius;
    
    public void getFahrenheit(double celsius){
        this.celsius = celsius;
        fahrenheit = (9.0/5.0)*celsius + 32;
    }
}
