package com.livingwordsolutions.technosoft.post_module_location;

import android.app.Activity;
import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.RadioGroup;


public class MyActivity extends Activity {

    


    RadioGroup l_lout;
    LinearLayout set_container;
    boolean isBottom = true;
    ImageButton b1, b2, b3, b4, b5, b6;
    Intent camera, gallery;
    int[] idDetails = new int[6];
    Bitmap image;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my);

        l_lout = (RadioGroup) findViewById(R.id.rg_main);
        //l_lout.setTranslationY(200);

        Button a_but = (Button) findViewById(R.id.button3);

        set_container = (LinearLayout) l_lout.getParent();

        if (savedInstanceState == null) {
            getFragmentManager().beginTransaction()
                    .add(R.id.fragment_place, new FragmentOne())
                    .commit();
        }


    }





    public void selectFrag(View view) {
        Fragment fr;



        if(view == findViewById(R.id.button3)) {

            fr = new FragmentOne();


        }else{

            fr = new FragmentTwo();

        }

        FragmentManager fm = getFragmentManager();

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
