package com.example.belajarsqlite;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ArrayList<MhsModel> mhsList ;
    MhsModel mm ;
    DbHelper db ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        EditText edNama = (EditText) findViewById(R.id.edNama);
        EditText edNim = (EditText) findViewById(R.id.edNim);
        EditText edNoHp = (EditText) findViewById(R.id.edNoHp);

        Button btnSimpan = (Button) findViewById(R.id.btnSimpan);

        mhsList = new ArrayList<>();

        Intent intent_list = new Intent(MainActivity.this, ListMhsActivity.class);

        db = new DbHelper(getApplicationContext());

        btnSimpan.setOnClickListener(view -> {
            String isian_nama = edNama.getText().toString();
            String isian_nim = edNim.getText().toString();
            String isian_noHp = edNoHp.getText().toString();

            if(isian_nama.isEmpty() || isian_nim.isEmpty() || isian_noHp.isEmpty()){
                Toast.makeText(getApplicationContext(), "Isian masih kosong", Toast.LENGTH_SHORT).show();
            }else{
                // mhsList.add(new MhsModel(-1, isian_nama, isian_nim, isian_noHp));

                mm = new MhsModel(-1, isian_nama, isian_nim, isian_noHp);

                boolean stts = db.simpan(mm);

                if(stts){

                    edNama.setText("");
                    edNim.setText("");
                    edNoHp.setText("");
                    Toast.makeText(getApplicationContext(), "Data berhasil disimpan", Toast.LENGTH_SHORT).show();
                }else{
                    Toast.makeText(getApplicationContext(), "Data gagal disimpan", Toast.LENGTH_SHORT).show();
                }



                // intent_list.putParcelableArrayListExtra("mhsList", mhsList);
                // startActivity(intent_list);

            }
        });

        Button btnLihat = (Button) findViewById(R.id.btnLihat);
        btnLihat.setOnClickListener(view -> {

            mhsList = db.list();

            if(mhsList.isEmpty()){
                Toast.makeText(getApplicationContext(), "Belum ada data", Toast.LENGTH_SHORT).show();
            }else{
                intent_list.putParcelableArrayListExtra("mhsList", mhsList);
                startActivity(intent_list);
            }
        });

    }
}