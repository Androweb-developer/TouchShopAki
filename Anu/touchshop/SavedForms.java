package com.pkg.touchshop;

import android.os.Bundle;
import android.widget.Button;
import android.widget.LinearLayout;

import androidx.appcompat.app.AppCompatActivity;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class SavedForms extends AppCompatActivity {
    private Button newButton;
    private ArrayList<String> formList = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.saved_forms);
        findViewById(R.id.form_refresh_btn).setOnClickListener(view -> getFroms());
    }

    private void getFroms(){
        LinearLayout linearLayout=findViewById(R.id.form_btn_view);
        load();

    }

    public StringBuilder load() {
        FileInputStream fis = null;
        StringBuilder previousData=null;

        try {
            fis = openFileInput("data.txt");
            InputStreamReader isr = new InputStreamReader(fis);
            BufferedReader br = new BufferedReader(isr);
            StringBuilder sb = new StringBuilder();
            String text;

            while ((text = br.readLine()) != null) {
                sb.append(text);
            }
            String[] str=sb.toString().split("`");
            System.out.println(str[1]);
//            for(String s:str){
//                if(s!=null) {
//                    formList.add(s);
//                }
//            }
//            for(String s:formList){
//                System.out.println(s);
//            }
            previousData=sb;

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (fis != null) {
                try {
                    fis.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return previousData;
    }

}