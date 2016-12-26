package com.example.dima.goitandroidcheckpoint;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

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

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
}
