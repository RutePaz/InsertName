package app2.com;

import android.app.DatePickerDialog;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Toast;

import java.util.Calendar;

public class MainActivity extends AppCompatActivity {

    String  name, email, date;
    int favouriteNumber;

    EditText nameInput;
    EditText emailInput;
    EditText favNumberInput;
    private EditText dateInput;

    DatePickerDialog  datePickerDialog;

    Button submitbt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        nameInput =  (EditText) findViewById(R.id.nameInput);
        emailInput =  (EditText) findViewById(R.id.emailInput);
        favNumberInput =  (EditText) findViewById(R.id.favNumberInput);
        dateInput = (EditText) findViewById(R.id.dateInput);

        dateInput.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Calendar calendar = Calendar.getInstance();
                int year =  calendar.get(Calendar.YEAR);
                int month =  calendar.get(Calendar.MONTH);
                int day = calendar.get(Calendar.DAY_OF_MONTH);

                datePickerDialog = new DatePickerDialog(MainActivity.this, new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker view, int year, int month, int day) {

                        dateInput.setText(day + "/"+ (month+1) +"/"+ year);

                    }
                },year, month, day);
                datePickerDialog.show();

            }
        });


        //botão
        submitbt = (Button) findViewById(R.id.submitbt);
        submitbt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                name = nameInput.getText().toString();
                email = emailInput.getText().toString();
                favouriteNumber = Integer.valueOf(favNumberInput.getText().toString());
                date = dateInput.getText().toString();



                showTost(name);
                showTost(email);
                showTost(String.valueOf(favouriteNumber));
                showTost(date);

            }

        });

    }

    private void showTost(String text) {
        Toast.makeText(MainActivity.this, text, Toast.LENGTH_SHORT).show();
    }
}
