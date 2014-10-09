package Forms;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;

import com.livingwordsolutions.technosoft.post_module_location.R;
import com.livingwordsolutions.technosoft.post_module_location.Task_async.sell_shop_task;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by kishorechandra on 07/10/14.
 */
public class sell_shop extends Fragment {

    EditText phone;
    Spinner submitter;
    EditText cons_t;
    EditText addr;
    Spinner rooms;
    Spinner furniture;
    Spinner sqft;
    Spinner facing;
    EditText price;
    Button btn;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View firstTabView = inflater.inflate(R.layout.form_sell_shop, container, false);

        phone = (EditText) firstTabView.findViewById(R.id.phone_val);
        cons_t = (EditText) firstTabView.findViewById(R.id.cons_by);
        addr = (EditText) firstTabView.findViewById(R.id.address);
        price = (EditText) firstTabView.findViewById(R.id.price);
        btn = (Button) firstTabView.findViewById(R.id.btn);


        submitter = (Spinner) firstTabView.findViewById(R.id.submitter);
        List<String> arrays = new ArrayList<String>();
        arrays.add("Individual");
        arrays.add("Builder");
        arrays.add("Broker");
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(getActivity(), android.R.layout.simple_spinner_item, arrays);
        submitter.setAdapter(adapter);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);


        rooms = (Spinner) firstTabView.findViewById(R.id.rooms);
        List<String> list1 = new ArrayList<String>();
        list1.add("Single");
        list1.add("2 rooms");
        list1.add("3 rooms");
        ArrayAdapter<String> adapter1 = new ArrayAdapter<String>(getActivity(), android.R.layout.simple_spinner_item, list1);
        rooms.setAdapter(adapter1);
        adapter1.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        furniture = (Spinner) firstTabView.findViewById(R.id.furniture);
        List<String> list2 = new ArrayList<String>();
        list2.add("Not Furnished");
        list2.add("Fully Furnished");
        list2.add("Furnished");
        ArrayAdapter<String> adapter2 = new ArrayAdapter<String>(getActivity(), android.R.layout.simple_spinner_item, list2);
        furniture.setAdapter(adapter2);
        adapter2.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        sqft = (Spinner) firstTabView.findViewById(R.id.sqft);
        List<String> list3 = new ArrayList<String>();
        list3.add("below 100 sqft");
        list3.add("100 - 500 sqft");
        list3.add("500 - 1000 sqft");
        list3.add("1000 - 2000 sqft");
        list3.add("2000 - 5000 sqft");
        list3.add("5000 - more sqft");
        ArrayAdapter<String> adapter3 = new ArrayAdapter<String>(getActivity(), android.R.layout.simple_spinner_item, list3);
        sqft.setAdapter(adapter3);
        adapter3.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        facing = (Spinner) firstTabView.findViewById(R.id.facing);
        List<String> list4 = new ArrayList<String>();
        list4.add("East Facing");
        list4.add("West Facing");
        list4.add("North Facing");
        list4.add("South Facing");
        ArrayAdapter<String> adapter4 = new ArrayAdapter<String>(getActivity(), android.R.layout.simple_spinner_item, list4);
        facing.setAdapter(adapter4);
        adapter4.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        btn.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {

                new sell_shop_task(getActivity(), phone.getText(), cons_t.getText(),submitter.getSelectedItem()).execute();

            }

        });

        return firstTabView;
    }




    }


