package com.example.dima.goitandroidcheckpoint;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.Spinner;

import com.example.dima.goitandroidcheckpoint.entity.Bet;
import com.example.dima.goitandroidcheckpoint.entity.Horse;
import com.example.dima.goitandroidcheckpoint.entity.Winner;
import com.example.dima.goitandroidcheckpoint.util.SharedPref;

import java.util.ArrayList;
import java.util.List;

/**
 * Вариант№2.
 *
 * Написать программу для приема ставок и расчета выигрышей на скачках.
 * Пользователи, зарегистрированные в системе, могут поставить любую сумму на одну из семи лошадей.
 * Предварительно администратор системы вносит список лошадей. По результатам заезда
 * (его можно смоделировать на основе случайных чисел) должна рассчитываться сумма выигрыша.
 *
 * (*) Система должна иметь возможность обрабатывать несколько видов ставок
 * (какая лошадь придет первой, какая лошадь придет последней и т.д.).
 */

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private List<String> mPositions;
    private List<Bet> mBetList;
    private List<Winner> mWinners;

    private SharedPref mSharedPreferences;

    private LinearLayout mBatFrame;
    private Spinner mHorse;
    private Spinner mHorsePosition;
    private EditText mBetSum;
    private ListView mBetListView;

    private BetAdapter mBetAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        generateCollections();
        mSharedPreferences = new SharedPref(this);

        mBetListView = (ListView) findViewById(R.id.mainBet_listView);
        mBetAdapter = new BetAdapter(this, mBetList);
        mBetListView.setAdapter(mBetAdapter);

        ArrayAdapter<Horse> arrayAdapterHorse = new ArrayAdapter<Horse>(this, android.R.layout.simple_spinner_item, Horse.values());
        arrayAdapterHorse.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        mHorse = (Spinner) findViewById(R.id.mainBet_horse);
        mHorse.setAdapter(arrayAdapterHorse);


        ArrayAdapter<String> arrayAdapterPosition = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, mPositions);
        arrayAdapterPosition.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        mHorsePosition = (Spinner) findViewById(R.id.mainBet_horsePosition);
        mHorsePosition.setAdapter(arrayAdapterPosition);

        mBetSum = (EditText) findViewById(R.id.mainBet_sum);

        Button mainButtonSet = (Button) findViewById(R.id.mainBet_setBet);
        mainButtonSet.setOnClickListener(this);

        Button mainButtonBegin = (Button) findViewById(R.id.mainBet_beginRace);
        mainButtonBegin.setOnClickListener(this);




    }

    private void generateCollections() {
        mBetList = new ArrayList<>();
        mWinners = new ArrayList<>();
        mPositions = new ArrayList<>();
        mPositions.add("first");
        mPositions.add("second");
        mPositions.add("third");
        mPositions.add("last");
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.mainBet_setBet:
                String user = mSharedPreferences.getCurrentUser();
                Horse horse = (Horse) mHorse.getSelectedItem();
                String horsePosition = mHorsePosition.getSelectedItem().toString();
                int sum = Integer.valueOf(mBetSum.getText().toString());
                Bet bet = new Bet(user, sum, horse, horsePosition);
                mBetList.add(bet);
                mBetAdapter.notifyDataSetChanged();
                break;
            case R.id.mainBet_beginRace:
                break;
            default:
                break;
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        menu.add(0, 1, 0, getString(R.string.log_out));
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        mSharedPreferences.signOut();
        startActivity(new Intent(MainActivity.this, LoginActivity.class));
        return super.onOptionsItemSelected(item);
    }
}
