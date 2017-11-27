package my.edu.tarc.lab32inputcontrols;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.CheckBox;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener {

    private Spinner spinnerAge;
    private RadioButton radioButtonMale, radioButtonFemale;
    private CheckBox checkBoxSmoker;
    private TextView textViewPremium;
    private RadioGroup radioGroupGender;
    private double basicPremium;
    private double total, extraMale, extraSmoker;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        spinnerAge = (Spinner)findViewById(R.id.spinnerAge);
        spinnerAge.setOnItemSelectedListener(this);

        ArrayAdapter<CharSequence> adapter =
                ArrayAdapter.createFromResource(this, R.array.age, android.R.layout.simple_spinner_item);

        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        spinnerAge.setAdapter(adapter);
        radioButtonFemale = (RadioButton)findViewById(R.id.radioButtonFemale);
        radioButtonMale = (RadioButton) findViewById(R.id.radioButtonMale);
        radioGroupGender = (RadioGroup) findViewById(R.id.radiogroupGender);
        checkBoxSmoker = (CheckBox) findViewById(R.id.checkBoxSmoker);
        textViewPremium = (TextView) findViewById(R.id.textView);



    }



    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        switch (position) {
            case 0:
                basicPremium = 50;
                break;
            case 1:
                basicPremium = 55;
                break;
            case 2:
                basicPremium = 60;
                break;
            case 3:
                basicPremium = 70;
                break;
            case 4:
                basicPremium = 120;
                break;
            case 5:
                basicPremium = 160;
                break;
            case 6:
                basicPremium = 200;
                break;
            case 7:
                basicPremium = 250;
                break;
        }
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }

    public void calculate(View view) {
        int selectedID = radioGroupGender.getCheckedRadioButtonId();
        int spinnerID = spinnerAge.getSelectedItemPosition();
        boolean smoker = checkBoxSmoker.isChecked();

        if(spinnerID == 2 && selectedID == R.id.radioButtonMale)
            extraMale = 50;
        else if(spinnerID == 3 && selectedID == R.id.radioButtonMale)
            extraMale = 100;
        else if(spinnerID == 4 && selectedID == R.id.radioButtonMale)
            extraMale = 100;
        else if(spinnerID == 5 && selectedID == R.id.radioButtonMale)
            extraMale = 50;
        else
            extraMale = 0;

        if(spinnerID == 3 && smoker == true)
            extraSmoker = 100;
        else if(spinnerID == 4 && smoker == true)
            extraSmoker = 150;
        else if(spinnerID == 5 && smoker == true)
            extraSmoker = 150;
        else if(spinnerID == 6 && smoker == true)
            extraSmoker = 250;
        else if(spinnerID == 7 && smoker == true)
            extraSmoker = 250;
        else extraSmoker = 0;

        total = basicPremium + extraMale + extraSmoker;

        textViewPremium.setText("Total = " + total);
    }

    public void reset(View view) {
        textViewPremium.setText("");


    }

}
