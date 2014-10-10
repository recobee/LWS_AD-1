package com.livingwordsolutions.technosoft.post_module_location;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.RadioGroup;


public class MyActivity extends android.support.v4.app.FragmentActivity {


    RadioGroup l_lout;
    LinearLayout set_container;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my);

        l_lout = (RadioGroup) findViewById(R.id.rg_main);
        //l_lout.setTranslationY(200);

        Button a_but = (Button) findViewById(R.id.button3);

        set_container = (LinearLayout) l_lout.getParent();

        if (savedInstanceState == null) {
            getSupportFragmentManager().beginTransaction()
                    .add(R.id.fragment_place, new FragmentOne())
                    .commit();
        }


    }


    public void selectFrag(View view) {
        Fragment fr;


        if (view == findViewById(R.id.button3)) {

            fr = new FragmentOne();


        } else {

            fr = new FragmentTwo();

        }

        FragmentManager fm = getSupportFragmentManager();

        FragmentTransaction fragmentTransaction = fm.beginTransaction();

        fragmentTransaction.replace(R.id.fragment_place, fr);

        fragmentTransaction.commit();

    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.my, menu);

        return true;
    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }


}
