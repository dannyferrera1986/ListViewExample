package com.example.service_admin.listviewexample;

import android.content.Intent;
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
        DatabaseAdapter dbadapter =new DatabaseAdapter(this);


        itemList =dbadapter.getItemList();
       /*  itemList =new ArrayList<Item>(); */
        itemadapter=new itemadapter(itemList, this,dbadapter);
        ListView itemListView=findViewById(R.id.list);

        itemListView.setAdapter(itemadapter);
 /*
        Item newitem= new Item();
        newitem.setName("Carro");
        newitem.setDescription("un carro");
        newitem.setImageid(R.mipmap.ic_launcher);
        itemadapter.AddItem(newitem); */

        Button btnadd = findViewById(R.id.button);

        btnadd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

             /*   Item newitem= new Item();
                newitem.setName("Carro");rro");
                newitem.setImageid(R.mipmap.i
                newitem.setDescription("un cac_launcher_foreground);
                itemadapter.AddItem(newitem);*/
             Intent intent = new Intent(MainActivity.this,itemactivity.class);
             startActivityForResult(intent,1);

            }
        });

    }
    @Override
    protected void onActivityResult(int requestcode ,int resultcode,Intent data){
        super.onActivityResult(requestcode,resultcode,data);

        String name=data.getStringExtra("name");
        String descripcion=data.getStringExtra("descripcion");
        int imagenid=data.getIntExtra("imagen",R.mipmap.ic_launcher);

        Item newitem =new Item();
        newitem.setName(name);
        newitem.setDescription(descripcion);
        newitem.setImageid(imagenid);

        itemadapter.AddItem(newitem);

    }
}
