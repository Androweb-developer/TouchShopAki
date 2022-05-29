package com.tag.touchapp_10;


import android.app.DatePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.os.Environment;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Calendar;

public class new_entry_form extends AppCompatActivity implements DatePickerDialog.OnDateSetListener{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.new_entry_form);

        findViewById(R.id.submitForm).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                EditText formNo = (EditText) findViewById(R.id.formno_input);
                Log.v("Entered Form No" , formNo.getText().toString());

                EditText name_input = (EditText) findViewById(R.id.name_input);
                Log.v("Entered name_input" , name_input.getText().toString());

                EditText nickname_input = (EditText) findViewById(R.id.nickname_input);
                Log.v("Entered nickname_input" , nickname_input.getText().toString());

                EditText bracket_input = (EditText) findViewById(R.id.bracket_input);
                Log.v("Entered bracket_input" , bracket_input.getText().toString());

                EditText material_input = (EditText) findViewById(R.id.material_input);
                Log.v("Entered material_input" , material_input.getText().toString());

                EditText mark_input = (EditText) findViewById(R.id.mark_input);
                Log.v("Entered mark_input" , mark_input.getText().toString());

                EditText touch_input = (EditText) findViewById(R.id.touch_input);
                Log.v("Entered touch_input" , touch_input.getText().toString());
                FileUtil fileUtil = new FileUtil();
                try {
                    fileUtil.wakingUpFile();
                } catch (Exception e) {
                    e.printStackTrace();
                }

            }
        });

        //for date input
        findViewById(R.id.btnSelectDate).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showDatePickerDialog();
            }
        });

        //To Refresh the data entered
        findViewById(R.id.form_refresh_btn).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                EditText formNo = (EditText) findViewById(R.id.formno_input);
                formNo.setText("");

                EditText name_input = (EditText) findViewById(R.id.name_input);
                name_input.setText("");

                EditText nickname_input = (EditText) findViewById(R.id.nickname_input);
                nickname_input.setText("");

                EditText bracket_input = (EditText) findViewById(R.id.bracket_input);
                bracket_input.setText("");

                EditText material_input = (EditText) findViewById(R.id.material_input);
                material_input.setText("");

                EditText mark_input = (EditText) findViewById(R.id.mark_input);
                mark_input.setText("");

                EditText touch_input = (EditText) findViewById(R.id.touch_input);
                touch_input.setText("");
            }
        });

    }
    //methods
    public void showDatePickerDialog(){
        DatePickerDialog datePickerDialog = new DatePickerDialog(
                this,
                this,
                Calendar.getInstance().get(Calendar.YEAR),
                Calendar.getInstance().get(Calendar.MONTH),
                Calendar.getInstance().get(Calendar.DAY_OF_MONTH)
        );
        datePickerDialog.show();
    }
    @Override
    public void onDateSet(DatePicker view , int year , int month , int dayOfMonth){
        Log.v("Entered dd" , String.valueOf(dayOfMonth));
        Log.v("Entered mm" , String.valueOf(month));
        Log.v("Entered yyyy" , String.valueOf(year));
    }

    public void createFile() {
        String fileName = "testFile.txt";
        File path = Environment.getExternalStoragePublicDirectory(
                Environment.DIRECTORY_DOCUMENTS);
        File file = new File(path, "DemoPicture.txt");
        path.mkdirs();

    }

}
