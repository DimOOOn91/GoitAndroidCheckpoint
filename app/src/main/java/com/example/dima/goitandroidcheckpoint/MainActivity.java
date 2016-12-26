package com.example.dima.goitandroidcheckpoint;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

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

public class MainActivity extends AppCompatActivity {

    public static final String IS_USER_SIGN_IN = "is sign in";

    SharedPreferences mSharedPreferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mSharedPreferences = getSharedPreferences("my_preferences", MODE_PRIVATE);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        menu.add(0, 1, 0, getString(R.string.log_out));
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        mSharedPreferences.edit().putBoolean(IS_USER_SIGN_IN, false).apply();
        startActivity(new Intent(MainActivity.this, LoginActivity.class));
        return super.onOptionsItemSelected(item);
    }
}
