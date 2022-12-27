package com.example.recyclerbutton;

import android.annotation.SuppressLint;
import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.graphics.Color;
import android.telecom.StatusHints;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class MyMovieAdapter extends RecyclerView.Adapter<MyMovieAdapter.ViewHolder> {
    ArrayList<MyMovieData> list;
    Context context;

    public MyMovieAdapter(ArrayList<MyMovieData> list, Context context) {
        this.list = list;
        this.context = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View view = layoutInflater.inflate(R.layout.movie_item_list,parent,false);
        return new ViewHolder(view);

    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, @SuppressLint("RecyclerView") int position) {

        MyMovieData myMovieDatalist = list.get(position);
        holder.textViewName.setText(myMovieDatalist.getMovieName());
        holder.textViewDate.setText(myMovieDatalist.getMovieDate());
        holder.movieImage.setImageResource(myMovieDatalist.getMovieImage());
        holder.linearLayout.setBackgroundColor(Color.parseColor(myMovieDatalist.getColor()));



        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Dialog dialog = new Dialog(context);
                dialog.setContentView(R.layout.dialogue_box);

                EditText editText= dialog.findViewById(R.id.ed1);
                EditText editTextSecond = dialog.findViewById(R.id.ed2);
                Button button = dialog.findViewById(R.id.btnadd);
                TextView textView = dialog.findViewById(R.id.heading);
                button.setText("Update");
                textView.setText("Update Movie");


                editText.setText(myMovieDatalist.getMovieName());
                editTextSecond.setText(myMovieDatalist.getMovieDate());

                button.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {

                        String name = "";
                        String number = "";


                        if(editText.getText().toString().equals(""))
                        {

                            Toast.makeText(context, "Fill Edit Text", Toast.LENGTH_SHORT).show();

                        }
                        else
                        {
                            name = editText.getText().toString();

                        }


                        if(editTextSecond.getText().toString().equals(""))
                        {

                            Toast.makeText(context, "Fill Movie Date", Toast.LENGTH_SHORT).show();


                        }
                        else
                        {
                            number  = editTextSecond.getText().toString();

                        }

                        list.set(position,new MyMovieData(name,number,R.drawable.batman,"#F4511E"));
                        notifyItemChanged(position);
                        dialog.dismiss();

                    }
                });
                dialog.show();


            }
        });


        holder.itemView.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View view) {


                AlertDialog.Builder builder = new AlertDialog.Builder(context).
                        setTitle("Delete").
                        setMessage("Are you Sure You Want To Delete").
                        setIcon(R.drawable.ic_baseline_delete_24).
                        setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {

                                list.remove(position);
                                notifyItemRemoved(position);

                            }
                        }).setNegativeButton("No", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {

                            }
                        });

                builder.show();




                return true;
            }
        });


    }
    private  void setAnimation(View viewToAnimation,int position)
    {
        Animation slideIn = AnimationUtils.loadAnimation(context, android.R.anim.slide_in_left);
        viewToAnimation.setAnimation(slideIn);

    }
    @Override
    public int getItemCount() {
        return list.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        ImageView movieImage;
        TextView textViewName;
        TextView textViewDate;
        LinearLayout linearLayout;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            movieImage = itemView.findViewById(R.id.imageview);
            textViewName = itemView.findViewById(R.id.textName);
            textViewDate = itemView.findViewById(R.id.textdate);
            linearLayout = itemView.findViewById(R.id.linearlayout);

        }
    }
}
