package fr.wcs.blablawild;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.ListView;
import android.widget.Toast;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class ViewSearchItineraryResultsListActivity extends AppCompatActivity {

    TripResultAdapter mResultsAdapter;
    ListView mListViewResults;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_search_itinerary_results_list);

        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy-hh:mm");

        // Intent
        SearchRequestModel searchRequestModel = getIntent().getExtras().getParcelable("searchRequestModel");
        String depart = searchRequestModel.getDepart();
        String destination = searchRequestModel.getDestination();
        Date date = searchRequestModel.getDateTrajet();
        Toast.makeText(ViewSearchItineraryResultsListActivity.this, sdf.format(date) , Toast.LENGTH_SHORT).show();
        setTitle(depart + " >> " + destination);

        // Array List
        mListViewResults = (ListView) findViewById(R.id.listView);
        ArrayList<TripResultModel> results = new ArrayList<>();
        try {
            results.add(new TripResultModel("Bruce", sdf.parse("21/02/2017-15:30"), 15));
            results.add(new TripResultModel("Clark", sdf.parse("21/02/2017-16:00"), 20));
            results.add(new TripResultModel("Bary", sdf.parse("21/02/2017-16:30"), 16));
            results.add(new TripResultModel("Lex", sdf.parse("21/02/2017-17:00"), 40));
        } catch (ParseException e) {
        }
        mResultsAdapter = new TripResultAdapter(this, results);
        mListViewResults.setAdapter(mResultsAdapter);
    }
}
