package com.shawon.yousuf.myfabmenu;

import android.app.Dialog;
import android.graphics.drawable.ColorDrawable;
import android.os.Build;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Gravity;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.view.Window;
import android.view.WindowManager;
import android.widget.RelativeLayout;
import android.widget.Toast;

import com.shawon.yousuf.myfabmenu.dialog.DialogFabMenu;

public class MainActivity extends AppCompatActivity {


    RelativeLayout rel1;

    private String TAG = getClass().getSimpleName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);


        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                CustomDialog();

            }
        });


    }


    // method to create and display menu list as dialog
    public void CustomDialog(){


        DialogFabMenu dialogFabMenu = new DialogFabMenu(this);
        dialogFabMenu.setOnSelectListener(new DialogFabMenu.OnSelect() {
            @Override
            public void onAddSelect() {
                Log.d(TAG, "Add");
                Toast.makeText(MainActivity.this, "Add selected " , Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onSettingSelect() {
                Log.d(TAG, "Setting");
                Toast.makeText(MainActivity.this, "Setting selected" , Toast.LENGTH_SHORT).show();
            }
        });

        dialogFabMenu.show();


    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
