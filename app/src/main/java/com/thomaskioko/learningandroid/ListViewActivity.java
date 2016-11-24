package com.thomaskioko.learningandroid;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.List;

/**
 * This activity contains a list of examples taught. Enables the user to navigate throught the
 * activities.
 *
 * @author Thomas Kioko
 */
public class ListViewActivity extends AppCompatActivity implements AdapterView.OnItemClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_view);

        //Create an string array of items
        String[] androidExamples = {"Navigation Drawer", "Tabs", "Maps"};

        //Create an Array Adapter
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, R.layout.list_item, androidExamples);

        //Initialise the listView
        ListView listView = (ListView) findViewById(R.id.listView);
        listView.setAdapter(adapter); // Add the adapter to the listView
        listView.setOnItemClickListener(this);
    }

    /**
     * Callback method to be invoked when an item in this AdapterView has
     * been clicked.
     * <p/>
     * Implementers can call getItemAtPosition(position) if they need
     * to access the data associated with the selected item.
     *
     * @param parent   The AdapterView where the click happened.
     * @param view     The view within the AdapterView that was clicked (this
     *                 will be a view provided by the adapter)
     * @param position The position of the view in the adapter.
     * @param id       The row id of the item that was clicked.
     */
    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        switch (position) {
            case 0:
                startActivity(new Intent(getApplicationContext(), MainActivity.class));
                break;
            case 1:
                startActivity(new Intent(getApplicationContext(), TabsActivity.class));
                break;
            case 2:
                startActivity(new Intent(getApplicationContext(), GoogleMapsActivity.class));
                break;
            default:
                break;
        }
    }
}
