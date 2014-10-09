package com.livingwordsolutions.technosoft.post_module_location.Task_async;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;
import android.util.Log;

import com.livingwordsolutions.technosoft.post_module_location.JSONParser;
import com.livingwordsolutions.technosoft.post_module_location.Post_Success;

import org.apache.http.NameValuePair;
import org.apache.http.message.BasicNameValuePair;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by kishorechandra on 07/10/14.
 */

public class sell_shop_task extends AsyncTask<String, String, String> {

    private static final String TAG_SUCCESS = "success";
    private static String url_create_product = "http://myvizag.url.ph/phone_add.php";
    private final Context context;
    private final Object[] objects;
    /**
     * Before starting background thread Show Progress Dialog
     */
    ProgressDialog pDialog;
    JSONParser jsonParser = new JSONParser();

    public sell_shop_task(Context context, Object... objects) {
        this.objects = objects;
        this.context = context;
    }

    @Override
    protected void onPreExecute() {
        super.onPreExecute();
        pDialog = new ProgressDialog(context);
        pDialog.setTitle("Sell Shop Details");
        pDialog.setMessage("Submitting...");
        pDialog.setProgressStyle(pDialog.STYLE_HORIZONTAL);
        pDialog.setProgress(0);
        pDialog.setMax(20);
        pDialog.setIndeterminate(false);
        pDialog.setCancelable(true);
        pDialog.show();
    }

    /**
     * Creating product
     */
    protected String doInBackground(String... args) {
        String ph = objects[0].toString();// Integer.parseInt(objects[0].toString());
        String cons_td = objects[1].toString();
        String sub_mtr = objects[2].toString();

        //  String sub_mtr = insidesub1mitter.getSelectedItem().toString();
            /*String cons_td = cons_t.getText().toString();
            String addre = addr.getText().toString();
            String bedrms = bedrooms.getSelectedItem().toString();
            String furn = furniture.getSelectedItem().toString();
            String sqf = sqft.getSelectedItem().toString();
            String face = facing.getSelectedItem().toString();
            String prc = price.getText().toString();*/
        //String description = inputDesc.getText().toString();

        // Building Parameters
        List<NameValuePair> params = new ArrayList<NameValuePair>();
        params.add(new BasicNameValuePair("phone", ph));

        params.add(new BasicNameValuePair("con", cons_td));
        params.add(new BasicNameValuePair("sub", sub_mtr));
            /*params.add(new BasicNameValuePair("ad", addre));
            params.add(new BasicNameValuePair("bed", bedrms));
            params.add(new BasicNameValuePair("furniture", furn));
            params.add(new BasicNameValuePair("sqft", sqf));
            params.add(new BasicNameValuePair("facing", face));
            params.add(new BasicNameValuePair("price", prc));*/
        //params.add(new BasicNameValuePair("description", description));


        // getting JSON Object
        // Note that create product url accepts POST method
        JSONObject json = jsonParser.makeHttpRequest(url_create_product,
                "POST", params);


        // check log cat fro response
        Log.d("Create Response", json.toString());


        // check for success tag
        try {
            int success = json.getInt(TAG_SUCCESS);

            if (success == 1) {
                // successfully created product
                Intent i = new Intent(context, Post_Success.class);
                Log.i("Submitted", "Successfully !");
                context.startActivity(i);
                // closing this screen
                //getActivity().finish();
            } else {
                Log.e("Failed !", "Submission");
                // failed to create product
            }

        } catch (JSONException e) {
            e.printStackTrace();
        }
        return null;
    }

    protected void onPostExecute(String file_url) {
        // dismiss the dialog once done
        pDialog.dismiss();
    }
}
