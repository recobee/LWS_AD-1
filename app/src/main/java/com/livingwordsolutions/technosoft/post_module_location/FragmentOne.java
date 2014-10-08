package com.livingwordsolutions.technosoft.post_module_location;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TabHost;
import android.widget.TabHost.TabSpec;
import android.widget.TabWidget;
import android.widget.TextView;


public class FragmentOne extends Fragment {

    TabHost host;
    TabSpec firstTab, secondTab, thirdTab, fourthTab;
    View result;
    LayoutInflater inflater;
    ViewGroup container;
    TabWidget widget;

    private RadioButton sell_one;
    private RadioButton sell_two;
    private RadioButton sell_three;
    private RadioButton sell_four;
    private RadioButton sell_five;
    private RadioButton sell_six;
    private RadioGroup radioGroup;

    private void initRadioButtons() {
        sell_one = (RadioButton) result.findViewById(R.id.sell_1);
        sell_two = (RadioButton) result.findViewById(R.id.sell_2);
        sell_three = (RadioButton) result.findViewById(R.id.sell_3);
        sell_four = (RadioButton) result.findViewById(R.id.sell_4);
        sell_five = (RadioButton) result.findViewById(R.id.sell_5);
        sell_six = (RadioButton) result.findViewById(R.id.sell_6);
        radioGroup = (RadioGroup) result.findViewById(R.id.rb_group);
        DefaultTabLayout();
        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                radioButtonSelectionActivity(checkedId);
            }
        });


    }

    private void House_Sell_Tabs() {

        host.clearAllTabs();

        firstTab.setContent(new TabHost.TabContentFactory() {
            @Override
            public View createTabContent(String s) {

                View res = inflater.inflate(R.layout.activity_sell__house__details, container, false);
                //res.findViewById(R.id.act_sell_h);
                return res;

            }
        });


        secondTab.setContent(new TabHost.TabContentFactory() {
            @Override
            public View createTabContent(String s) {
                return inflater.inflate(R.layout.activity_location, container, false);
            }
        });


        thirdTab.setContent(new TabHost.TabContentFactory() {
            @Override
            public View createTabContent(String s) {
                return inflater.inflate(R.layout.add_images, container, false);
            }

        });

        host.addTab(firstTab);
        host.addTab(secondTab);
        host.addTab(thirdTab);
        widget = host.getTabWidget();
    }

    private void Appartment_Sell_Tabs() {

        host.clearAllTabs();

        firstTab.setContent(new TabHost.TabContentFactory() {
            @Override
            public View createTabContent(String s) {
                View res2 = inflater.inflate(R.layout.activity_sell__appartment__details, container, false);
                //res2.findViewById(R.id.act_sell_a);
                return res2;
            }
        });


        secondTab.setContent(new TabHost.TabContentFactory() {
            @Override
            public View createTabContent(String s) {
                return inflater.inflate(R.layout.activity_location, container, false);
            }
        });


        thirdTab.setContent(new TabHost.TabContentFactory() {
            @Override
            public View createTabContent(String s) {
                return inflater.inflate(R.layout.add_images, container, false);
            }

        });

        host.addTab(firstTab);
        host.addTab(secondTab);
        host.addTab(thirdTab);
        widget = host.getTabWidget();
    }


    private void Shop_Sell_Tabs() {

        host.clearAllTabs();

        firstTab.setContent(new TabHost.TabContentFactory() {
            @Override
            public View createTabContent(String s) {
                View res2 = inflater.inflate(R.layout.activity_sell__shop__details, container, false);
                //res2.findViewById(R.id.act_sell_a);
                return res2;
            }
        });


        secondTab.setContent(new TabHost.TabContentFactory() {
            @Override
            public View createTabContent(String s) {
                return inflater.inflate(R.layout.activity_location, container, false);
            }
        });


        thirdTab.setContent(new TabHost.TabContentFactory() {
            @Override
            public View createTabContent(String s) {
                return inflater.inflate(R.layout.add_images, container, false);
            }

        });

        host.addTab(firstTab);
        host.addTab(secondTab);
        host.addTab(thirdTab);
        widget = host.getTabWidget();
    }

    private void Underconstruction_Sell_Tabs() {

        host.clearAllTabs();

        firstTab.setContent(new TabHost.TabContentFactory() {
            @Override
            public View createTabContent(String s) {
                View res2 = inflater.inflate(R.layout.activity_sell__underconstruction__details, container, false);
                //res2.findViewById(R.id.act_sell_a);
                return res2;
            }
        });


        secondTab.setContent(new TabHost.TabContentFactory() {
            @Override
            public View createTabContent(String s) {
                return inflater.inflate(R.layout.activity_location, container, false);
            }
        });


        thirdTab.setContent(new TabHost.TabContentFactory() {
            @Override
            public View createTabContent(String s) {
                return inflater.inflate(R.layout.add_images, container, false);
            }

        });

        host.addTab(firstTab);
        host.addTab(secondTab);
        host.addTab(thirdTab);
        widget = host.getTabWidget();
    }


    private void radioButtonSelectionActivity(int checkedId) {


        switch (checkedId) {
            case R.id.sell_1:
                House_Sell_Tabs();

                break;
            case R.id.sell_2:
                Appartment_Sell_Tabs();

                break;
            case R.id.sell_3:
                Shop_Sell_Tabs();

                break;
            case R.id.sell_4:
                Underconstruction_Sell_Tabs();

                break;
            case R.id.sell_5:
                //initSell2Tabs();

                break;
            case R.id.sell_6:
                //initSell2Tabs();

                break;
            default:

        }


    }


    @Override
    public View onCreateView(LayoutInflater inflater, final ViewGroup container, Bundle savedInstanceState) {

        result = inflater.inflate(R.layout.fragment_one, container, false);
        this.inflater = inflater;
        this.container = container;
        initRadioButtons();
        return result;
    }


    // TAB NAMES DEFINES HERE  - START //

    private void initTabsContent(final View firstView, final View secondView, final View thirdView, final View fourthView) {
        firstTab = host.newTabSpec("tag1");
        firstTab.setIndicator("Details");
        firstTab.setContent(new TabHost.TabContentFactory() {
            @Override
            public View createTabContent(String s) {
                return firstView;
            }
        });
        secondTab = host.newTabSpec("tag1");
        secondTab.setIndicator("Location");
        secondTab.setContent(new TabHost.TabContentFactory() {
            @Override
            public View createTabContent(String s) {
                return secondView;
            }
        });
        thirdTab = host.newTabSpec("tag1");
        thirdTab.setIndicator("Images");
        thirdTab.setContent(new TabHost.TabContentFactory() {
            @Override
            public View createTabContent(String s) {
                return thirdView;
            }
        });
        fourthTab = host.newTabSpec("tag1");
        fourthTab.setIndicator("Select Categories");
        fourthTab.setContent(new TabHost.TabContentFactory() {
            @Override
            public View createTabContent(String s) {
                return fourthView;
            }
        });

    }

    // TAB NAMES DEFINES HERE  - END //



    //Default tab start//
    private void DefaultTabLayout() {

        host = (TabHost) result.findViewById(R.id.tab_set);
        host.setup();
        TextView textView = new TextView(result.getContext());
        textView.setText("You are SELL Tab Please select the above options");
        initTabsContent(textView, textView, textView, textView);
        host.addTab(fourthTab);
    }
    //Default tab end//


}
