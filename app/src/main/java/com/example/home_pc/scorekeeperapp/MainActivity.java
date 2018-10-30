package com.example.home_pc.scorekeeperapp;

import android.support.constraint.ConstraintLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    @BindView(R.id.yellow_a) ConstraintLayout comandAYellow;
    @BindView(R.id.red_a) ConstraintLayout comandARed;
    @BindView(R.id.yellow_b) ConstraintLayout comandBYellow;
    @BindView(R.id.red_b) ConstraintLayout comandBRed;
    @BindView(R.id.txt_score_a) TextView txtScoreA;
    @BindView(R.id.txt_score_b) TextView txtScoreB;
    @BindView(R.id.btn_add_goal_a) Button btnAddGoalA;
    @BindView(R.id.btn_add_goal_b) Button btnAddGoalB;
    @BindView(R.id.btn_a_yellow) ImageButton btnAYellow;
    @BindView(R.id.btn_b_yellow) ImageButton btnBYellow;
    @BindView(R.id.btn_b_red) ImageButton btnBRed;
    @BindView(R.id.btn_a_red) ImageButton btnAred;
    @BindView(R.id.btn_reset) Button btnReset;

    private TextView txtAYellow;
    private TextView txtARed;
    private TextView txtBYellow;
    private TextView txtBRed;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        txtAYellow = comandAYellow.findViewById(R.id.txt);
        txtARed = comandARed.findViewById(R.id.txt);
        txtBYellow = comandBYellow.findViewById(R.id.txt);
        txtBRed = comandBRed.findViewById(R.id.txt);

        btnAddGoalA.setOnClickListener(this);
        btnAddGoalB.setOnClickListener(this);
        btnBRed.setOnClickListener(this);
        btnAred.setOnClickListener(this);
        btnAYellow.setOnClickListener(this);
        btnBYellow.setOnClickListener(this);

        btnReset.setOnClickListener(v -> resetAll());

    }

    private void resetAll() {
        txtAYellow.setText("0");
        txtARed.setText("0");
        txtBYellow.setText("0");
        txtBRed.setText("0");
        txtScoreA.setText("0");
        txtScoreB.setText("0");
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_add_goal_a:
                increaseValue(txtScoreA);
                break;
            case R.id.btn_add_goal_b:
                increaseValue(txtScoreB);
                break;
            case R.id.btn_a_yellow:
                increaseValue(txtAYellow);
                break;
            case R.id.btn_a_red:
                increaseValue(txtARed);
                break;
            case R.id.btn_b_yellow:
                increaseValue(txtBYellow);
                break;
            case R.id.btn_b_red:
                increaseValue(txtBRed);
                break;
        }
    }

    private void increaseValue(TextView view){
       int score = Integer.parseInt(view.getText().toString());
       view.setText(String.valueOf(++score));
    }
}
