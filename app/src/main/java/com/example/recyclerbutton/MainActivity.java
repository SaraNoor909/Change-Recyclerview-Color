package com.example.recyclerbutton;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.Dialog;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.material.floatingactionbutton.ExtendedFloatingActionButton;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    Button efab;
    ArrayList<MyMovieData> list = new ArrayList<>();
    MyMovieAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        efab = findViewById(R.id.fab);

        RecyclerView recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setHasFixedSize(true);


                list.add(new MyMovieData("Avengers","2019 film",R.drawable.avenger,"#FFBB86FC"));
                list.add(new MyMovieData("Venom","2018 film",R.drawable.venom,"#FF6200EE"));
                list.add( new MyMovieData("Batman Begins","2005 film",R.drawable.batman,"#43A047"));
                list.add(new MyMovieData("Jumanji","2019 film",R.drawable.jumanji,"#039BE5"));
                list.add (new MyMovieData("Good Deeds","2012 film",R.drawable.good_deeds,"#FF018786"));
                list.add(new MyMovieData("Hulk","2003 film",R.drawable.hulk,"#FF03DAC5"));
                list.add(new MyMovieData("Avatar","2009 film",R.drawable.avatar,"#FF3700B3"));


                LinearLayoutManager obj = new LinearLayoutManager(this);
                recyclerView.setLayoutManager(obj);
                adapter = new MyMovieAdapter(list,MainActivity.this);

                recyclerView.setAdapter(adapter);


                efab.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {

                        Dialog dialog = new Dialog(MainActivity.this);
                        dialog.setContentView(R.layout.dialogue_box);


                        EditText editText = dialog.findViewById(R.id.ed1);
                        EditText secondText = dialog.findViewById(R.id.ed2);
                        Button buttonAdd = dialog.findViewById(R.id.btnadd);


                        buttonAdd.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View view) {

                                String name = "";
                                String number = "";

                                if(editText.getText().toString().equals(""))
                                {
                                    Toast.makeText(MainActivity.this, "Fill Edit Text", Toast.LENGTH_SHORT).show();
                                }
                                else
                                {
                                    name = editText.getText().toString();
                                }
                                if(secondText.getText().toString().equals(""))
                                {

                                    Toast.makeText(MainActivity.this, "Fill Movie Date", Toast.LENGTH_SHORT).show();
                                }
                                else
                                {
                                    number  = secondText.getText().toString();
                                }

                                list.add(new MyMovieData(name,number,R.drawable.avatar,"#FF03DAC5"));

                                adapter.notifyItemInserted(list.size()-1);
                                recyclerView.scrollToPosition(list.size()-1);
                                dialog.dismiss();
                            }
                        });

                        dialog.show();
                    }
                });
    }
    }
