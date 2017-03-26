package fr.esilv.jcdecaux.activities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import fr.esilv.jcdecaux.R;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button bout = (Button) findViewById(R.id.bout);
        final EditText search = (EditText) findViewById(R.id.search);

        bout.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {

                Intent intent = new Intent(MainActivity.this, ContractsActivity.class);
                intent.putExtra("query", search.getText().toString());
                startActivity(intent);

            }
        });


    }


}
