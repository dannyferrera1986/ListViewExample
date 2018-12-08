package com.example.service_admin.listviewexample;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    itemadapter itemadapter;
    List<Item> itemList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        itemList =new ArrayList<Item>();
        itemadapter=new itemadapter(itemList, this);
        ListView itemListView=findViewById(R.id.list);

        itemListView.setAdapter(itemadapter);

        Item newitem= new Item();
        newitem.setName("Carro");
        newitem.setDescription("un carro");
        newitem.setImageid(R.mipmap.ic_launcher);
        itemadapter.AddItem(newitem);

        Button btnadd = findViewById(R.id.button);

        btnadd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Item newitem= new Item();
                newitem.setName("Carro");
                newitem.setDescription("un carro");
                newitem.setImageid(R.mipmap.ic_launcher_foreground);
                itemadapter.AddItem(newitem);
            }
        });

    }
}
