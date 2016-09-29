package edu.kvcc.cis298.cis298assignment2;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.TextView;

public class TemperatureConverter extends AppCompatActivity {
    // >Keys for the Bundle.
    private final String KEY_CONVERSION = "conversion";
    private final String KEY_FORMULA = "formula";

    // >Widgets.
    private EditText mTemperatureInput;
    private RadioGroup mFromGroup;
    private RadioGroup mToGroup;
    private TextView mConversionTextView;
    private TextView mFormulaTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_temperature_converter);

        // >Fill the widget variables with the actual objects.
        mTemperatureInput = (EditText) findViewById(R.id.temperature_input);
        mFromGroup = (RadioGroup) findViewById(R.id.from_temperatures_group);
        mToGroup = (RadioGroup) findViewById(R.id.to_temperatures_group);
        Button mConvertButton = (Button) findViewById(R.id.convert_button);
        // >Set the convert button's onClick listener so that it will calculate when pressed.
        mConvertButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // >Get the id's of the selected radio buttons and convert the temperature.
                convertTemperature(mFromGroup.getCheckedRadioButtonId(), mToGroup.getCheckedRadioButtonId());
            }
        });
        mConversionTextView = (TextView) findViewById(R.id.conversion_text_view);
        mFormulaTextView = (TextView) findViewById(R.id.formula_text_view);

        // >Set the displayed text(if the orientation was changed)
        if (savedInstanceState != null) {
            mConversionTextView.setText(savedInstanceState.getString(KEY_CONVERSION));
            mFormulaTextView.setText(savedInstanceState.getString(KEY_FORMULA));
        }
    }

    // >The int parameters are used to determine the scale that is being converted from and to.
    private void convertTemperature(int fromScaleId, int toScaleId) {
        // >Check if the input was valid.
        if (!validateInput()) {
            mConversionTextView.setText(R.string.error_no_input);
            return;
        }
        // >Check that the temperature scales where selected.
        if (!validateScales()) {
            mConversionTextView.setText(R.string.error_scales_not_selected);
            return;
        }

        boolean sameScales = false;// >If we are converting from and to the same scale.

        // >Get the text as a string and parse it to a double.(this was checked by validateInput())
        double temperature = Double.parseDouble(mTemperatureInput.getText().toString());
        double convertedTemperature = 0.0d;// >The temperature after conversion.
        String conversionFormula = "";// >The formula used for conversion.

        String abvFrom = "";// >The 'from' scale's abbreviation.
        String abvTo = "";// >The 'to' scale's abbreviation.

        // >Set the 'to' abbreviation.
        switch (toScaleId) {
            case R.id.to_celsius_radiobutton:
                abvTo = "C";
                break;
            case R.id.to_fahrenheit_radiobutton:
                abvTo = "F";
                break;
            case R.id.to_kelvin_radiobutton:
                abvTo = "K";
                break;
            case R.id.to_rankin_radiobutton:
                abvTo = "R";
                break;
        }

        // >Set the 'from' abbreviation and get the converted temperature.
        switch (fromScaleId) {
            case R.id.from_celsius_radiobutton:
                abvFrom = "C";
                switch (toScaleId) {
                    case R.id.to_celsius_radiobutton:
                        sameScales = true;
                        break;
                    case R.id.to_fahrenheit_radiobutton:
                        convertedTemperature = TConverter.celsiusToFahrenheit(temperature);
                        conversionFormula = TConverter.CELSIUS_TO_FAHRENHEIT;
                        break;
                    case R.id.to_kelvin_radiobutton:
                        convertedTemperature = TConverter.celsiusToKelvin(temperature);
                        conversionFormula = TConverter.CELSIUS_TO_KELVIN;
                        break;
                    case R.id.to_rankin_radiobutton:
                        convertedTemperature = TConverter.celsiusToRankin(temperature);
                        conversionFormula = TConverter.CELSIUS_TO_RANKINE;
                        break;
                }
                break;
            case R.id.from_fahrenheit_radiobutton:
                abvFrom = "F";
                switch (toScaleId) {
                    case R.id.to_celsius_radiobutton:
                        convertedTemperature = TConverter.fahrenheitToCelsius(temperature);
                        conversionFormula = TConverter.FAHRENHEIT_TO_CELSIUS;
                        break;
                    case R.id.to_fahrenheit_radiobutton:
                        sameScales = true;
                        break;
                    case R.id.to_kelvin_radiobutton:
                        convertedTemperature = TConverter.fahrenheitToKelvin(temperature);
                        conversionFormula = TConverter.FAHRENHEIT_TO_KELVIN;
                        break;
                    case R.id.to_rankin_radiobutton:
                        convertedTemperature = TConverter.fahrenheitToRankine(temperature);
                        conversionFormula = TConverter.FAHRENHEIT_TO_RANKINE;
                        break;
                }
                break;
            case R.id.from_kelvin_radiobutton:
                abvFrom = "K";
                switch (toScaleId) {
                    case R.id.to_celsius_radiobutton:
                        convertedTemperature = TConverter.kelvinToCelsius(temperature);
                        conversionFormula = TConverter.KELVIN_TO_CELSIUS;
                        break;
                    case R.id.to_fahrenheit_radiobutton:
                        convertedTemperature = TConverter.kelvinToFahrenheit(temperature);
                        conversionFormula = TConverter.KELVIN_TO_FAHRENHEIT;
                        break;
                    case R.id.to_kelvin_radiobutton:
                        sameScales = true;
                        break;
                    case R.id.to_rankin_radiobutton:
                        convertedTemperature = TConverter.kelvinToRankine(temperature);
                        conversionFormula = TConverter.KELVIN_TO_RANKINE;
                        break;
                }
                break;
            case R.id.from_rankin_radiobutton:
                abvFrom = "R";
                switch (toScaleId) {
                    case R.id.to_celsius_radiobutton:
                        convertedTemperature = TConverter.rankineToCelsius(temperature);
                        conversionFormula = TConverter.RANKINE_TO_CELSIUS;
                        break;
                    case R.id.to_fahrenheit_radiobutton:
                        convertedTemperature = TConverter.rankineToFahrenheit(temperature);
                        conversionFormula = TConverter.RANKINE_TO_FAHRENHEIT;
                        break;
                    case R.id.to_kelvin_radiobutton:
                        convertedTemperature = TConverter.rankineToKelvin(temperature);
                        conversionFormula = TConverter.RANKINE_TO_KELVIN;
                        break;
                    case R.id.to_rankin_radiobutton:
                        sameScales = true;
                        break;
                }
                break;
        }


        if (sameScales) {
            convertedTemperature = temperature;
            conversionFormula = "[" + abvFrom + "] = [" + abvTo + "]";
        }
        mConversionTextView.setText(Double.toString(temperature) + "°" + abvFrom + " = " + Double.toString(convertedTemperature) + "°" + abvTo);
        mFormulaTextView.setText(conversionFormula);
    }

    private boolean validateInput() {
        boolean isValid = false;
        try {
            // >Get the text as a string and try to parse it to a double.
            double inputTemperature = Double.parseDouble(mTemperatureInput.getText().toString());
            isValid = true;
        } catch (Exception e) {

        }
        return  isValid;
    }

    private boolean validateScales() {
        return (mFromGroup.getCheckedRadioButtonId() != -1 && mToGroup.getCheckedRadioButtonId() != -1);
    }


    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);

        outState.putString(KEY_CONVERSION, mConversionTextView.getText().toString());
        outState.putString(KEY_FORMULA, mFormulaTextView.getText().toString());
    }











    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_temperature_converter, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
