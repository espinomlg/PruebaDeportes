package com.example.espino.deportes;


import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import com.example.espino.deportes.adapter.SportsAdapter;
import com.example.espino.deportes.model.Preferences;


public class MainActivity extends AppCompatActivity {

    private ListView list;
    private SportsAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        list = (ListView) findViewById(android.R.id.list);
        adapter = new SportsAdapter(getApplicationContext());
        list.setAdapter(adapter);
    }

    public void savePreferences(View v){
        for(byte i = 0; i < adapter.getCount(); i++){
            Preferences.getInstance(getApplicationContext()).putBoolean(adapter.getItem(i).getName(), adapter.getItem(i).isFavourite());
        }
        Toast.makeText(getApplicationContext(),getResources().getString(R.string.data_saved),Toast.LENGTH_SHORT).show();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.action_bar, menu);
        return true;
        //return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case R.id.action_filter:
                final EditText filter = new EditText(MainActivity.this);
                filter.setTextColor(getResources().getColor(R.color.black));
                //AlertDialog.Builder dialog = new AlertDialog.Builder(getApplicationContext());
                AlertDialog.Builder dialog = new AlertDialog.Builder(getApplicationContext());
                dialog.setTitle(getResources().getString(R.string.filter_action));
                dialog.setView(filter);
                dialog.setPositiveButton(getResources().getString(R.string.dialog_ok), new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        adapter.filter(filter.getText().toString());
                    }
                });
                dialog.show();
                break;
        }
        return super.onOptionsItemSelected(item);
    }

    /*
    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
    }

    @Override
    public void onRestoreInstanceState(Bundle state) {
        super.onRestoreInstanceState(state);
    }
*/
}
