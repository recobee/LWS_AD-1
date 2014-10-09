package com.livingwordsolutions.technosoft.post_module_location;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


/**
 * A simple {@link android.app.Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link com.livingwordsolutions.technosoft.post_module_location.FragmentTwo.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link com.livingwordsolutions.technosoft.post_module_location.FragmentTwo#newInstance} factory method to
 * create an instance of this fragment.
 */
public class FragmentTwo extends Fragment {
    @Override

    public View onCreateView(LayoutInflater inflater,

                             ViewGroup container, Bundle savedInstanceState) {


        //Inflate the layout for this fragment

        return inflater.inflate(

                R.layout.fragment_two, container, false);

    }


}
