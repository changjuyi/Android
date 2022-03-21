package com.example.activitylifecycleandstate;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private int mCount = 0;
    private TextView mShowCount;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mShowCount = (TextView) findViewById(R.id.show_count);
        if(savedInstanceState != null){
            String str = savedInstanceState.getString("show_count");
            mShowCount.setText(str);
            mCount = Integer.parseInt(str);
        }
        if(savedInstanceState != null){
            mCount = savedInstanceState.getInt("count");
            mShowCount.setText(String.valueOf(mCount));
        }
    }

    public void countUp(View view){
        mCount++;
        if(mShowCount != null){
            mShowCount.setText(Integer.toString(mCount));
        }
    }

    @Override
    protected void onSaveInstanceState(Bundle outState){
        super.onSaveInstanceState(outState);
        outState.putString("show_count",mShowCount.getText().toString());
    }
}