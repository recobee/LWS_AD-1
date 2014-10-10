package Forms;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTabHost;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.livingwordsolutions.technosoft.post_module_location.R;
import com.livingwordsolutions.technosoft.post_module_location.test_sell2_form;
import com.livingwordsolutions.technosoft.post_module_location.test_sell_form;

/**
 * Created by kishorechandra on 10/10/14.
 */
public class DGTabFragment extends Fragment {

    View rootView;
    FragmentTabHost host;



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        initComponents();
        return host;
    }

    private void initComponents() {


        host = new FragmentTabHost(getActivity());
        host.setup(getActivity(), getChildFragmentManager(), R.id.dgTabContent);
        host.addTab(host.newTabSpec("tab1").setIndicator("tab1"), test_sell2_form.class, null);
        host.addTab(host.newTabSpec("tab1").setIndicator("tab2"), test_sell_form.class, null);
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        host = null;
    }
}
