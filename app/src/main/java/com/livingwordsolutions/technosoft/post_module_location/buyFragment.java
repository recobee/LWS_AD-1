package com.livingwordsolutions.technosoft.post_module_location;


import android.app.Fragment;
import android.app.FragmentTransaction;
import android.app.ProgressDialog;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.TabHost;
import android.widget.TabWidget;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;


/**
 * A simple {@link Fragment} subclass.
 */
public class buyFragment extends Fragment {

    public static final String TAG = "rangeseekbar";
    JSONParser jsonParser = new JSONParser();
    FragmentTransaction fragmentTransaction;
    TabHost host;
    TabHost first_host;
    TabHost.TabSpec firstTab, secondTab;
    View result;
    LayoutInflater inflater;
    ViewGroup container;
    TabWidget widget;
    Spinner option1;
    Spinner option2;
    private RadioButton buy_one;
    private RadioButton buy_two;
    private RadioButton buy_three;
    private RadioButton buy_four;
    private RadioButton buy_five;
    private RadioButton buy_six;
    private RadioGroup radioGroup;
    private String buttonSelected;
    private ProgressDialog pDialog;

    private void initRadioButtons() {
        buy_one = (RadioButton) result.findViewById(R.id.buy_1);
        buy_two = (RadioButton) result.findViewById(R.id.buy_2);
        buy_three = (RadioButton) result.findViewById(R.id.buy_3);
        buy_four = (RadioButton) result.findViewById(R.id.buy_4);
        buy_five = (RadioButton) result.findViewById(R.id.buy_5);
        buy_six = (RadioButton) result.findViewById(R.id.buy_6);
        radioGroup = (RadioGroup) result.findViewById(R.id.rb_group);
        initTabHostLayout();
        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                radioButtonSelectionActivity(checkedId);
            }
        });


    }

    private void initSell2Tabs() {

        host.clearAllTabs();

        secondTab.setContent(new TabHost.TabContentFactory() {
            @Override
            public View createTabContent(String s) {
                final View searchViewTab = inflater.inflate(R.layout.activity_search_lister, container, false);

                final TextView min = (TextView) searchViewTab.findViewById(R.id.minValue);
                final TextView max = (TextView) searchViewTab.findViewById(R.id.maxValue);

                RangeSeekBar<Integer> seekBar = new RangeSeekBar<Integer>(60, 1400000, getActivity());
                seekBar.setOnRangeSeekBarChangeListener(new RangeSeekBar.OnRangeSeekBarChangeListener<Integer>() {
                    @Override
                    public void onRangeSeekBarValuesChanged(RangeSeekBar<?> bar, Integer minValue, Integer maxValue) {
                        // handle changed range values
                        Log.i(TAG, "User selected new range values: MIN=" + minValue + ", MAX=" + maxValue);

                        min.setText("INR." + minValue.toString());
                        max.setText("INR." + maxValue.toString());

                    }
                });

                option1 = (Spinner) searchViewTab.findViewById(R.id.option1);
                List<String> opt1 = new ArrayList<String>();
                opt1.add("2 Bedroom");
                opt1.add("3 Bedroom");
                opt1.add("more than that");
                ArrayAdapter<String> adapter = new ArrayAdapter<String>(getActivity(), android.R.layout.simple_spinner_item, opt1);
                option1.setAdapter(adapter);
                adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

                option2 = (Spinner) searchViewTab.findViewById(R.id.option2);
                List<String> opt2 = new ArrayList<String>();
                opt2.add("2 Bedroom");
                opt2.add("3 Bedroom");
                opt2.add("more than that");
                ArrayAdapter<String> adapter1 = new ArrayAdapter<String>(getActivity(), android.R.layout.simple_spinner_item, opt2);
                option2.setAdapter(adapter1);
                adapter1.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);


                // add RangeSeekBar to pre-defined layout
                ViewGroup layout = (ViewGroup) searchViewTab.findViewById(R.id.layout);
                layout.addView(seekBar);
                return searchViewTab;
            }
        });
        host.addTab(secondTab);
        widget = host.getTabWidget();
    }

    private void radioButtonSelectionActivity(int checkedId) {


        switch (checkedId) {
            case R.id.buy_1:
                initSell2Tabs();
                buttonSelected = "Sell House";
                break;
            case R.id.buy_2:
                initSell2Tabs();
                buttonSelected = "Sell Apartment-flat";
                break;
            case R.id.buy_3:
                initSell2Tabs();
                buttonSelected = "Sell Commercial-Complex";
                break;
            case R.id.buy_4:
                initSell2Tabs();
                buttonSelected = "Category four";
                break;
            case R.id.buy_5:
                initSell2Tabs();
                buttonSelected = "Category five";
                break;
            case R.id.buy_6:
                initSell2Tabs();
                buttonSelected = "Category six";
                break;
            default:

        }

        /*Toast toast = Toast.makeText(result.getContext(), "See" + buttonSelected, Toast.LENGTH_SHORT);
        toast.setGravity(Gravity.CENTER| Gravity.CENTER_HORIZONTAL,0,0);
        View kk = toast.getView();
        kk.setBackgroundResource(android.R.drawable.screen_background_dark_transparent);
        toast.show();*/
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        result = inflater.inflate(R.layout.fragment_buy, container, false);
        this.inflater = inflater;
        this.container = container;
        initRadioButtons();
        return result;
    }

    private void initTabsContent(final View firstView, final View secondView) {
        firstTab = host.newTabSpec("tag1");
        firstTab.setIndicator("Details");
        firstTab.setContent(new TabHost.TabContentFactory() {
            @Override
            public View createTabContent(String s) {
                return firstView;
            }
        });
        secondTab = host.newTabSpec("tag1");
        secondTab.setIndicator("Select");
        secondTab.setContent(new TabHost.TabContentFactory() {
            @Override
            public View createTabContent(String s) {
                return secondView;
            }
        });


    }

    private void initTabHostLayout() {

        host = (TabHost) result.findViewById(R.id.tab_set_buy);
        host.setup();
        TextView textView = new TextView(result.getContext());
        textView.setText("You are SELL Tab Please select the above options");
        initTabsContent(textView, textView);
        host.addTab(firstTab);
        //host.addTab(secondTab);
        //host.addTab(thirdTab);
        //widget = host.getTabWidget();

    }


}
