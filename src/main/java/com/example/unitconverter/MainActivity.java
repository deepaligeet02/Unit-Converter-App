package com.example.unitconverter;

        import android.os.Bundle;
        import android.view.View;
        import android.widget.ArrayAdapter;
        import android.widget.Button;
        import android.widget.EditText;
        import android.widget.Spinner;

        import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private EditText inputEditText, outputEditText;
    private Spinner conversionTypeSpinner;
    private Button convertButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        inputEditText = findViewById(R.id.inputEditText);
        outputEditText = findViewById(R.id.outputEditText);
        conversionTypeSpinner = findViewById(R.id.conversionTypeSpinner);
        convertButton = findViewById(R.id.convertButton);

        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(
                this,
                R.array.conversion_types,
                android.R.layout.simple_spinner_item
        );
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        conversionTypeSpinner.setAdapter(adapter);

        convertButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                performConversion();
            }
        });
    }

    private void performConversion() {
        String inputValueStr = inputEditText.getText().toString();
        if (inputValueStr.isEmpty()) {
            outputEditText.setText("");
            return;
        }

        double inputValue = Double.parseDouble(inputValueStr);
        String conversionType = conversionTypeSpinner.getSelectedItem().toString();
        double result;

        switch (conversionType) {
            case "Feet to Meters":
                result = feetToMeters(inputValue);
                break;
            case "Meters to Feet":
                result = metersToFeet(inputValue);
                break;
            case "Meters to kilometers":
                result = metersToKilometers(inputValue);
                break;
            case "Meters to Centimeters":
                result = metersToCentimeters(inputValue);
                break;
            case "Grams to Kilograms":
                result = gramsToKilograms(inputValue);
                break;
            case "Liters to Milliliters":
                result = litersToMilliliters(inputValue);
                break;
            case "Kilograms to Grams":
                result = kilogramsToGrams(inputValue);
                break;
            default:
                result = 0.0;
        }

        outputEditText.setText(String.valueOf(result));
    }

    private double feetToMeters(double feet) {
        return feet * 0.3048;
    }

    private double metersToFeet(double meters) {
        return meters * 3.28084;
    }
    private double metersToKilometers(double meters) {
        return meters / 1000.0;
    }
    public double metersToCentimeters(double meters) {
        return meters * 100;
    }
    public  double gramsToKilograms(double grams) {
        return grams / 1000.0;
    }
    public  double litersToMilliliters(double liters) {
        return liters * 1000;
    }
    public double kilogramsToGrams(double kilograms) {
        return kilograms * 1000;
    }
}