package com.example.unitconverter;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Objects;

public class MainActivity extends AppCompatActivity {
    public String selectedUnit;
    private ArrayAdapter<CharSequence> oUnitAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Spinner spinnerInputUnits = findViewById(R.id.inputUnit);

        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(
                this,
                R.array.units,
                android.R.layout.simple_spinner_item
        );

        adapter.setDropDownViewResource(android.R.layout.simple_spinner_item);

        spinnerInputUnits.setAdapter(adapter);

        Button convertValue = findViewById(R.id.button);




        Spinner spinnerOutputUnits = findViewById(R.id.outputUnit);
        spinnerInputUnits.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                selectedUnit = spinnerInputUnits.getSelectedItem().toString();
                int parentId = parent.getId();

                if (parentId == R.id.inputUnit){
                    switch (selectedUnit){
                        case "Select your Unit" : oUnitAdapter = ArrayAdapter.createFromResource(parent.getContext(),
                                R.array.array_default_units, android.R.layout.simple_spinner_item);
                        break;
                        case "inch" :
                        case "yard" :
                        case "metre" :
                        case "km" :
                        case "mile" : oUnitAdapter = ArrayAdapter.createFromResource(parent.getContext(),
                                R.array.array_length_units, android.R.layout.simple_spinner_item);
                        break;

                        case "kg" :
                        case "lbs" :
                        case "ounce" :
                        case "ton" : oUnitAdapter = ArrayAdapter.createFromResource(parent.getContext(),
                                R.array.array_weight_units, android.R.layout.simple_spinner_item);
                        break;

                        case "Kelvin" :
                        case "Celsius" :
                        case "Fahrenheit" : oUnitAdapter = ArrayAdapter.createFromResource(parent.getContext(),
                                R.array.array_temperature_units, android.R.layout.simple_spinner_item);
                        break;

                        default: break;
                    }
                    oUnitAdapter.setDropDownViewResource(android.R.layout.simple_spinner_item);

                    //Populate the output according to the selected input
                    spinnerOutputUnits.setAdapter(oUnitAdapter);
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {


            }
        });

        convertValue.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                selectedUnit = spinnerInputUnits.getSelectedItem().toString();
                String selectedOutputUnit = spinnerOutputUnits.getSelectedItem().toString();
                EditText inputValue = findViewById(R.id.inputValue);
                int invalue = Integer.parseInt(inputValue.getText().toString());
                String finalValue;
                final TextView outputValue = findViewById(R.id.outputValue);


                    conversionMethod conv = new conversionMethod();
                    switch (selectedUnit){
                        case "Select your Unit" : Toast.makeText(getApplicationContext(), "Error: Select some unit " , Toast.LENGTH_SHORT).show();
                            break;
                        case "inch" :
                        case "yard" :
                        case "metre" :
                        case "km" :
                        case "mile" : finalValue = conv.lengthUnits(selectedUnit,selectedOutputUnit, invalue);

                            outputValue.setText(finalValue);
                            break;

                        case "kg" :
                        case "lbs" :
                        case "ounce" :
                        case "ton" : finalValue = conv.weightUnits(selectedUnit, selectedOutputUnit, invalue);
                            outputValue.setText(finalValue);
                            break;

                        case "Kelvin" :
                        case "Celsius" :
                        case "Fahrenheit" : finalValue = conv.tempUnits(selectedUnit, selectedOutputUnit, invalue);
                            outputValue.setText(finalValue);
                            break;

                        default: break;
                    }

                if (Objects.equals(selectedUnit, selectedOutputUnit))
                {
                    Toast.makeText(getApplicationContext(),"Error: There should be different units selected",Toast.LENGTH_SHORT).show();
                }


            }
        });


    }

}