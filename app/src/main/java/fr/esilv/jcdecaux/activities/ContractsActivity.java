package fr.esilv.jcdecaux.activities;

import android.content.Intent;
import android.os.Bundle;
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
import fr.esilv.jcdecaux.adapters.ContractsAdapter;
import fr.esilv.jcdecaux.interfaces.OnContractSelectedListener;
import fr.esilv.jcdecaux.models.Contract;
import fr.esilv.jcdecaux.models.Contracts;
import fr.esilv.jcdecaux.models.Example;
import fr.esilv.jcdecaux.models.Item;

//AIzaSyAgEbIU7ikHCkmsQA_YCkbWByMiJExAb3E
public class ContractsActivity extends AppCompatActivity implements OnContractSelectedListener {

	private static final String CONTRACTS_URL = "https://www.googleapis.com/youtube/v3/search?part=snippet&type=video&key=AIzaSyAgEbIU7ikHCkmsQA_YCkbWByMiJExAb3E&q=";
	private RecyclerView recyclerView;

	String message;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_contracts);

		recyclerView = (RecyclerView) findViewById(R.id.recyclerView);
		recyclerView.setLayoutManager(new LinearLayoutManager(this));
		Intent intent = getIntent();
		message = intent.getStringExtra("query");


		getContracts();
	}

	private void getContracts() {
		StringRequest contractsRequest = new StringRequest(CONTRACTS_URL + message, new Response.Listener<String>() {
			@Override
			public void onResponse(String response) {
				//parse data from webservice to get Contracts as Java object
				Example example = new Gson().fromJson(response, Example.class);

				setAdapter(example.getItems());
			}
		}, new Response.ErrorListener() {
			@Override
			public void onErrorResponse(VolleyError error) {
				Log.e("Examples", "Error");
			}
		});

		Volley.newRequestQueue(this).add(contractsRequest);
	}

	private void setAdapter(List<Item> examples) {
		ContractsAdapter adapter = new ContractsAdapter(examples);
		adapter.setOnContractSelectedListener(this);
		recyclerView.setAdapter(adapter);
	}

	@Override
	public void onContractSelected(Item item) {

	}

	//@Override
	/*public void onContractSelected(Contract contract) {
		StationsActivity.start(this, contract.getName());

	}*/
}
