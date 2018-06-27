package com.cdac.yogalisting.activity;

import android.app.ProgressDialog;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.cdac.yogalisting.R;
import com.cdac.yogalisting.adapter.YogaListingAdapter;
import com.cdac.yogalisting.helper.UrlHelper;
import com.cdac.yogalisting.pojo.YogaPojo;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class MainActivity extends AppCompatActivity {

    private ListView listView;
    private ArrayList<YogaPojo> arrayList = new ArrayList<>();
    private YogaListingAdapter adapter ;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        init();

        adapter = new YogaListingAdapter(this, R.layout.list_item, arrayList);
        listView.setAdapter(adapter);

        fetchYogaDataFromServer();
    }

    private void init() {
        listView = (ListView) findViewById(R.id.listView);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int poistion, long l) {

                YogaPojo pojo = arrayList.get(poistion);

                Intent i = new Intent(MainActivity.this, ContentActivity.class);
                i.putExtra("des" , pojo.getDescription());
                startActivity(i);

            }
        });
    }

    private void fetchYogaDataFromServer() {

        final ProgressDialog dialog = new ProgressDialog(this);
        dialog.setMessage("Loading...");
        dialog.show();

        StringRequest request =
                new StringRequest(Request.Method.POST, UrlHelper.YOGA_URL,
                        new Response.Listener<String>() {
                            @Override
                            public void onResponse(String response) {
                                dialog.cancel();
                                Log.d("1234", "onResponse: "+response);
                                parseYogaJSON(response);
                            }
                        },
                        new Response.ErrorListener() {
                            @Override
                            public void onErrorResponse(VolleyError error) {
                                dialog.cancel();
                                Toast.makeText(MainActivity.this, "error in network", Toast.LENGTH_SHORT).show();
                            }
                        })
                {
                    @Override
                    protected Map<String, String> getParams() throws AuthFailureError {
                        HashMap<String, String> map = new HashMap<>();
                        map.put("cat" ,"Yoga");
                        return map;
                    }
                };

        RequestQueue queue = Volley.newRequestQueue(this);
        queue.add(request);

    }

    private void parseYogaJSON(String response) {
        try {
            JSONObject jsonObject = new JSONObject(response);

            JSONArray array = jsonObject.getJSONArray("item");

            for (int i = 0; i< array.length(); i++)
            {
                JSONObject arrayObject  =array.getJSONObject(i);

                YogaPojo pojo = new YogaPojo();
                pojo.setId(arrayObject.getString("id"));
                pojo.setDescription(arrayObject.getString("description"));
                pojo.setCategory(arrayObject.getString("category"));
                pojo.setImg(arrayObject.getString("img"));
                pojo.setType(arrayObject.getString("type"));

                arrayList.add(pojo);
            }

            adapter.notifyDataSetChanged();


        } catch (JSONException e) {
            e.printStackTrace();
        }
    }
}
