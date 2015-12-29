package com.gac.fonttextview;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    private Button zt;
    private Button mode;
    private FontTextView ftv;
    boolean flag_zt;
    boolean flag_mode;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        zt = (Button)findViewById(R.id.id_bt_zt);
        zt.setOnClickListener(this);
        mode = (Button)findViewById(R.id.id_bt_mode);
        mode.setOnClickListener(this);
        ftv = (FontTextView)findViewById(R.id.id_tv);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case  R.id.id_bt_mode:
                if(flag_zt){
                    ftv.setThemeMode("night");
                    flag_zt = false;
                }else{
                    ftv.setThemeMode("day");
                    flag_zt = true;
                }
            break;
            case  R.id.id_bt_zt:
                if(flag_mode){
                    flag_mode = false;
                    ftv.setTypefaceName("xxsjs");
                }else {
                    flag_mode = true;
                    ftv.setTypefaceName("xjl");
                }
                break;
        }
    }
}
