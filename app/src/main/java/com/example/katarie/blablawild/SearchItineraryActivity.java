package com.example.katarie.blablawild;

import android.app.DatePickerDialog;
import android.content.Context;
import android.content.Intent;
import android.icu.util.Calendar;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Toast;

import java.util.Date;

public class SearchItineraryActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search_itinerary);

        final EditText depart = (EditText) findViewById(R.id.textdepart);
        final EditText destination = (EditText) findViewById(R.id.textdestination);
        Button rechercher = (Button) findViewById(R.id.buttonsearch);
        EditText date = (EditText) findViewById(R.id.date);
        final DatePickerDialog[] datePickerDialog = new DatePickerDialog[1];
        final EditText finalDate = date;
        date.setOnClickListener(new View.OnClickListener() {
            @RequiresApi(api = Build.VERSION_CODES.N)
            @Override
            public void onClick(View v) {
                // calender class's instance and get current date , month and year from calender
                final Calendar c = Calendar.getInstance();
                int mYear = c.get(Calendar.YEAR); // current year
                int mMonth = c.get(Calendar.MONTH); // current month
                int mDay = c.get(Calendar.DAY_OF_MONTH); // current day
                // date picker dialog
                datePickerDialog[0] = new DatePickerDialog(SearchItineraryActivity.this,
                        new DatePickerDialog.OnDateSetListener() {

                            @Override
                            public void onDateSet(DatePicker view, int year,
                                                  int monthOfYear, int dayOfMonth) {
                                // set day of month , month and year value in the edit text
                                finalDate.setText(dayOfMonth + "/"
                                        + (monthOfYear + 1) + "/" + year);

                            }
                        }, mYear, mMonth, mDay);
                datePickerDialog[0].show();
            }
        });

        rechercher.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String departstring = depart.getText().toString();
                String destinationstring = destination.getText().toString();

                if (depart.getText().toString().isEmpty()
                        || destination.getText().toString().isEmpty()){
                    Context context = getApplicationContext();
                    CharSequence text = "Remplissez Départ et destination !";
                    int duration = Toast.LENGTH_SHORT;

                    Toast toast = Toast.makeText(context, text, duration);
                    toast.show();
                }else{
                    Intent intent = new Intent(SearchItineraryActivity.this,
                           ViewSearchItineraryResultsListActivity.class);
                    intent.putExtra("Depart",  departstring);
                    intent.putExtra("Destination", destinationstring);
                    SearchItineraryActivity.this.startActivity(intent);


                }

            }
        });

    }
}
