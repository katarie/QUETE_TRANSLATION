package fr.wcs.blablawild;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Toast;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

public class SearchItineraryActivity extends AppCompatActivity {

    Button buttonSearch;
    String departContent;
    String destinationContent;
    String dateContent;
    EditText editTextSearchDeparture;
    EditText editTextSearchDestination;
    EditText editTextSearchDate;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search_itinerary);

        editTextSearchDeparture = (EditText) findViewById(R.id.editTextSearchDeparture);
        editTextSearchDestination = (EditText) findViewById(R.id.editTextSearchDestination);
        editTextSearchDate = (EditText) findViewById(R.id.editTextSearchDate);
        buttonSearch = (Button) findViewById(R.id.buttonSearch);

        final Calendar myCalendar = Calendar.getInstance();
        final EditText editTextSearchDate = (EditText) findViewById(R.id.editTextSearchDate);
        final DatePickerDialog.OnDateSetListener date = new DatePickerDialog.OnDateSetListener() {
            private void updateLabel() {
                String myFormat = "MM/dd/yy";
                SimpleDateFormat sdf = new SimpleDateFormat(myFormat, Locale.US);
                editTextSearchDate.setText(sdf.format(myCalendar.getTime()));
            }
            @Override
            public void onDateSet(DatePicker view, int year, int monthOfYear,
                                  int dayOfMonth) {
                myCalendar.set(Calendar.YEAR, year);
                myCalendar.set(Calendar.MONTH, monthOfYear);
                myCalendar.set(Calendar.DAY_OF_MONTH, dayOfMonth);
                updateLabel();
            }
        };

        editTextSearchDate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new DatePickerDialog(SearchItineraryActivity.this, date, myCalendar
                        .get(Calendar.YEAR), myCalendar.get(Calendar.MONTH),
                        myCalendar.get(Calendar.DAY_OF_MONTH)).show();
            }
        });

        final Intent intent = new Intent(this, ViewSearchItineraryResultsListActivity.class);

        buttonSearch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                departContent = editTextSearchDeparture.getText().toString();
                destinationContent = editTextSearchDestination.getText().toString();
                dateContent = editTextSearchDate.getText().toString();

                if ((departContent.equals("")) || (destinationContent.equals(""))) {
                    Toast.makeText(SearchItineraryActivity.this, "Veuillez renseigner votre départ et votre destination", Toast.LENGTH_SHORT).show();
                } else {
                    Intent intent = new Intent(getApplicationContext(), ViewSearchItineraryResultsListActivity.class);
                    SearchRequestModel searchRequestModel = new SearchRequestModel(departContent, destinationContent, myCalendar.getTime());
                    intent.putExtra("searchRequestModel", searchRequestModel);
                    startActivity(intent);
                }
            }
        });
    }
}
