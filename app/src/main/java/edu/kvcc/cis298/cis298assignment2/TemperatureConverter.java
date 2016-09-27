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

    private EditText mTemperatureInput;
    private RadioGroup mFromGroup;
    private RadioGroup mToGroup;
    private Button mConvertButton;
    private TextView mConversionTextView;
    private TextView mFormulaTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_temperature_converter);

        // >Fill the widgit variables with the actual objects.
        mTemperatureInput = (EditText) findViewById(R.id.temperature_input);
        mFromGroup = (RadioGroup) findViewById(R.id.from_temperatures_group);
        mToGroup = (RadioGroup) findViewById(R.id.to_temperatures_group);
        mConvertButton = (Button) findViewById(R.id.convert_button);
        // >Set the convert button's onClick listener so that it will calculate when pressed.
        mConvertButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // >Get the id's of the selected radio buttons and convert the temperature.
                int fromScale = mFromGroup.getCheckedRadioButtonId();
                int toScale = mToGroup.getCheckedRadioButtonId();
                convertTemperature(fromScale, toScale);
            }
        });
        mConversionTextView = (TextView) findViewById(R.id.conversion_text_view);
        mFormulaTextView = (TextView) findViewById(R.id.formula_text_view);
    }

    private void convertTemperature(int fromScaleId, int toScaleId) {
        try {
            // >Get the text as a string and try to parse it to a double.
            double temperature = Double.parseDouble(mTemperatureInput.getText().toString());

            switch (fromScaleId) {
                case R.id.from_celsius_radiobutton:
                    switch (toScaleId) {
                        case R.id.to_celsius_radiobutton:
                            break;
                        case R.id.to_fahrenheit_radiobutton:
                            break;
                        case R.id.to_kelvin_radiobutton:
                            break;
                        case R.id.to_rankin_radiobutton:
                            break;
                    }
                    break;
                case R.id.from_fahrenheit_radiobutton:
                    switch (toScaleId) {
                        case R.id.to_celsius_radiobutton:
                            break;
                        case R.id.to_fahrenheit_radiobutton:
                            break;
                        case R.id.to_kelvin_radiobutton:
                            break;
                        case R.id.to_rankin_radiobutton:
                            break;
                    }
                    break;
                case R.id.from_kelvin_radiobutton:
                    switch (toScaleId) {
                        case R.id.to_celsius_radiobutton:
                            break;
                        case R.id.to_fahrenheit_radiobutton:
                            break;
                        case R.id.to_kelvin_radiobutton:
                            break;
                        case R.id.to_rankin_radiobutton:
                            break;
                    }
                    break;
                case R.id.from_rankin_radiobutton:
                    switch (toScaleId) {
                        case R.id.to_celsius_radiobutton:
                            break;
                        case R.id.to_fahrenheit_radiobutton:
                            break;
                        case R.id.to_kelvin_radiobutton:
                            break;
                        case R.id.to_rankin_radiobutton:
                            break;
                    }
                    break;
            }
            mConversionTextView.setText(Double.toString(temperature));
        } catch (Exception e) {
            mConversionTextView.setText("You must enter a temperature!");
        }
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
