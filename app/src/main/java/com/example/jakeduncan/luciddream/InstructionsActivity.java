package com.example.jakeduncan.luciddream;

import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Html;
import android.widget.TextView;

public class InstructionsActivity extends AppCompatActivity {

    public static String text;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_instructions);

//        String versionName = "";
//        try {
//            PackageInfo pinfo = getPackageManager().getPackageInfo(getPackageName(), 0);
//            versionName = pinfo.versionName;
//        } catch (PackageManager.NameNotFoundException e) {
//            // TODO Auto-generated catch block
//            e.printStackTrace();
//        }
//
//
//
//        aboutText = Html.fromHtml("<h1>Your App Name, Version " + versionName + "</h1>"
//                + getString(R.string.about_text));
        text = getString(R.string.lucid);
        TextView textView = (TextView) findViewById(R.id.textView);
        textView.setText(text);
    }
}
