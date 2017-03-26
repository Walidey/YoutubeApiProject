package fr.esilv.jcdecaux.activities;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.google.gson.Gson;
import java.util.List;

import fr.esilv.jcdecaux.Constants;
import fr.esilv.jcdecaux.R;
import fr.esilv.jcdecaux.adapters.StationsAdapter;
import fr.esilv.jcdecaux.models.Example;
import fr.esilv.jcdecaux.models.Item;
import fr.esilv.jcdecaux.models.Stations;

public class StationsActivity extends AppCompatActivity {

	private static final String CONTRACT = "CONTRACT";
	private static final String STATIONS_URL = "https://api.jcdecaux.com/vls/v1/stations?contract=";
	private RecyclerView recyclerView;
	private String contractName;

	public static void start(Context context, String contractName) {
		Intent intent = new Intent(context, StationsActivity.class);
		intent.putExtra(CONTRACT, contractName);
		context.startActivity(intent);
	}

	@Override
	protected void onCreate(@Nullable Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_stations);

		contractName = getIntent().getStringExtra(CONTRACT);

		recyclerView = (RecyclerView) findViewById(R.id.recyclerView);
		recyclerView.setLayoutManager(new LinearLayoutManager(this));

		getStations();

	}

	private void getStations() {
		StringRequest stationsRequest = new StringRequest(STATIONS_URL + contractName + "&apiKey=" + Constants.API_KEY, new Response.Listener<String>() {
			@Override
			public void onResponse(String response) {
				//parse data from webservice to get Contracts as Java object
				Example item  = new Gson().fromJson(response, Example.class);


				setAdapter(item.getItems());
			}
		}, new Response.ErrorListener() {
			@Override
			public void onErrorResponse(VolleyError error) {
				Log.e("Contracts", "Error");
			}
		});

		Volley.newRequestQueue(this).add(stationsRequest);
	}

	private void setAdapter(List< Item > item) {
		StationsAdapter adapter = new StationsAdapter(item);
		recyclerView.setAdapter(adapter);
	}
}
