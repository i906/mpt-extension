package com.i906.mpt.extension.countdown.ui;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.i906.mpt.extension.Utils;
import com.i906.mpt.extension.countdown.R;

public class InfoActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_info);
    }

    @Override
    protected void onResume() {
        super.onResume();
        init();
    }

    private void init() {

        TextView message = (TextView) findViewById(R.id.tv_message);
        Button action = (Button) findViewById(R.id.btn_action);

        if (Utils.isMptAvailable(this)) {
            message.setText(R.string.text_settings);
            action.setText(R.string.label_open);
        }

        action.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (Utils.isMptAvailable(InfoActivity.this)) {
                    Utils.openMptSettings(InfoActivity.this);
                } else {
                    Utils.openMptPlayStore(InfoActivity.this);
                }
            }
        });
    }
}
