package edu.kvcc.cis298.cis298assignment2;

/**
 * Created by ccunn on 27-Sep-16.
 */

public class TConverter {
    public static final String CELSIUS_TO_FAHRENHEIT = "[°F] = ([°C] x 9/5) + 32";
    public static final String CELSIUS_TO_KELVIN = "[°K] = [°C] + 273.15";
    public static final String CELSIUS_TO_RANKINE = "[°R] = [°C] x 1.8 + 491.67";

    public static final String FAHRENHEIT_TO_CELSIUS = "[°C] = ([°F] - 32) x 5/9";
    public static final String FAHRENHEIT_TO_KELVIN = "[°K] = ([°F] - 32)/1.8 + 273.15";
    public static final String FAHRENHEIT_TO_RANKINE = "[°R] = ([°F] - 32) + 491.67";

    public static final String KELVIN_TO_CELSIUS = "[°C] = [°K] - 273.15";
    public static final String KELVIN_TO_FAHRENHEIT = "[°F] = ([°K] - 273.15) x 1.8 + 32";
    public static final String KELVIN_TO_RANKINE = "[°R] = ([°K] - 273.15) x 1.8 + 491.67";

    public static final String RANKINE_TO_CELSIUS = "[°C] = ([°R] - 491.67) / 1.8";
    public static final String RANKINE_TO_FAHRENHEIT = "[°F] = ([°R] - 491.67) + 32.00";
    public static final String RANKINE_TO_KELVIN = "[°K] = ([°R] - 491.67) / 1.8 + 237.15";


    public static double celsiusToFahrenheit(double temperature) {
        return (temperature * 9 / 5) + 32;
    }
    public static double celsiusToKelvin(double temperature) {
        return temperature + 273.15;
    }
    public static double celsiusToRankin(double temperature) {
        return temperature * 1.8 + 491.67;
    }

    public static double fahrenheitToCelsius(double temperature) {
        return (temperature - 32) * 5 / 9;
    }
    public static double fahrenheitToKelvin(double temperature) {
        return (temperature - 32) / 1.8 + 273.15;
    }
    public static double fahrenheitToRankine(double temperature) {
        return (temperature - 32) + 491.67;
    }

    public static double kelvinToCelsius(double temperature) {
        return temperature - 273.15;
    }
    public static double kelvinToFahrenheit(double temperature) {
        return (temperature - 273.15) * 1.8 + 32;
    }
    public static double kelvinToRankine(double temperature) {
        return (temperature - 273.15) * 1.8 + 491.67;
    }

    public static double rankineToCelsius(double temperature) {
        return (temperature - 491.67) / 1.8;
    }
    public static double rankineToFahrenheit(double temperature) {
        return (temperature - 491.67) + 32;
    }
    public static double rankineToKelvin(double temperature) {
        return (temperature - 491.67) / 1.8 + 273.15;
    }


}
