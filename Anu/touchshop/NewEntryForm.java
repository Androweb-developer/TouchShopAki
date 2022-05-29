package com.pkg.touchshop;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class NewEntryForm extends AppCompatActivity {
    private String formNo;
    private String name;
    private String nickName;
    private String bracket;
    private String material;
    private String mark;
    private String touch;
    private String date;
    private String fileName;
    private String previousData;

    public String fromData() {
        String data="";
        data=formNo+","+name+","+nickName+","+bracket+","+material+","+mark+","+touch+","+fileName+","+date+"`";
        return  data;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.new_entry_form);
        test test=new test();
        //previousData=test.load().toString()+"";
        findViewById(R.id.form_submit_btn).setOnClickListener(view -> saveForm());
        findViewById(R.id.form_refresh_btn).setOnClickListener(view -> {
            Intent intent=new Intent(this,test.class);
            startActivity(intent);
        });
    }

    private void saveForm() {
        formNo=((EditText)findViewById(R.id.formno_input)).getText().toString();
        name=((EditText)findViewById(R.id.name_input)).getText().toString();
        nickName=((EditText)findViewById(R.id.nickname_input)).getText().toString();
        bracket=((EditText)findViewById(R.id.bracket_input)).getText().toString();
        material=((EditText)findViewById(R.id.material_input)).getText().toString();
        mark=((EditText)findViewById(R.id.mark_input)).getText().toString();
        fileName=formNo+".jpg";
        touch=((EditText)findViewById(R.id.touch_input)).getText().toString();
        date=((EditText)findViewById(R.id.date_input)).getText().toString();
        if(!formNo.equals("") && !name.equals("") && !nickName.equals("") && !bracket.equals("")
                      && !material.equals("") && !mark.equals("") && !touch.equals("") && !date.equals("")){
            FileOutputStream fileOutputStream=null;
            try{
                fileOutputStream=openFileOutput("data.txt", Context.MODE_PRIVATE);
                fileOutputStream.write((previousData+fromData()+"\n").getBytes());
                Toast.makeText(this, "Form Successfully Saved", Toast.LENGTH_SHORT).show();
            }catch (Exception e){
                Toast.makeText(getApplicationContext(),e.getLocalizedMessage(), Toast.LENGTH_SHORT).show();
            }finally {
                if (fileOutputStream != null) {
                    try {
                        fileOutputStream.flush();
                        fileOutputStream.close();
                    } catch (IOException e) {
                        Toast.makeText(getApplicationContext(), e.getLocalizedMessage(), Toast.LENGTH_SHORT).show();
                    }
                }
            }
        }else{
            Toast.makeText(getApplicationContext(), "Enter all the fields", Toast.LENGTH_SHORT).show();
        }
    }
}