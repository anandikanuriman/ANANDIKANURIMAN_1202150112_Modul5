package com.example.anandika.anandikanuriman_1202150112_modul5;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class Todo extends AppCompatActivity {
    //mendeklarasikan variabel
    EditText td, des, prior;
    Database db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_todo);
        setTitle("Add Todo");
        //mengakses id yang ada pada layout
        td = findViewById(R.id.todo);
        des = findViewById(R.id.desc);
        prior = findViewById(R.id.prio);
        //inisiasi database
        db = new Database(this);
    }

    //method saat tombol back diklik
    @Override
    public void onBackPressed() {
        //membuat intent baru
        startActivity(new Intent(Todo.this, Home.class));
        this.finish(); //mengakhiri intent
    }

    //method saat tombol tambah to do diklik
    public void tambah(View view) {
        //jika semua data terisi
        if (db.inputdata(new itemTodo(td.getText().toString(), des.getText().toString(), prior.getText().toString()))) {
            //akan menampilkan toast
            Toast.makeText(this, "Todo ditambahkan", Toast.LENGTH_SHORT).show();
            onBackPressed();
        } else {
            //apabila tidak semua data diisi maka akan ditampilkan toast dibawah
            Toast.makeText(this, "Todo gagal ditambahkan", Toast.LENGTH_SHORT).show();
            //set semua edit text menjadi null
            td.setText(null);
            des.setText(null);
            prior.setText(null);
        }
    }
}
