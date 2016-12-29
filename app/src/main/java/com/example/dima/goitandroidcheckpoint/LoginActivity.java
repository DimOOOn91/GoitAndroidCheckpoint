package com.example.dima.goitandroidcheckpoint;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.dima.goitandroidcheckpoint.controller.Controller;
import com.example.dima.goitandroidcheckpoint.entity.User;
import com.example.dima.goitandroidcheckpoint.util.SharedPref;

public class LoginActivity extends AppCompatActivity implements View.OnClickListener {

    private Controller mController;

    private EditText mEmail;
    private EditText mPassword;
    private Button mCreateAccount;

    private SharedPref mSharedPreferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        setTitle(getString(R.string.log_in));

        mController = Controller.getInstance();
        mSharedPreferences = new SharedPref(this);

        mEmail = (EditText) findViewById(R.id.loginedit_email);
        mPassword = (EditText) findViewById(R.id.loginedit_password);
        mCreateAccount = (Button) findViewById(R.id.loginbutton_create_account);
        mCreateAccount.setOnClickListener(this);
        Button logIn = (Button) findViewById(R.id.loginbutton_log_in);
        logIn.setOnClickListener(this);
        TextView mDontHaveAccount = (TextView) findViewById(R.id.logintext_dont_have_account);
        mDontHaveAccount.setOnClickListener(this);
    }

    @Override
    protected void onStart() {
        if (mSharedPreferences.isUserSignIn()) {
            User user = mController.getUserByEmail(mSharedPreferences.getCurrentUser());
            mEmail.setText(user.getEmail());
            mPassword.setText(user.getPassword());
        } else if (!TextUtils.isEmpty(mSharedPreferences.getCurrentUser())) {
            mEmail.setText(mSharedPreferences.getCurrentUser());
        }
        super.onStart();
    }

    @Override
    protected void onDestroy() {
        mSharedPreferences.clear();
        super.onDestroy();
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.logintext_dont_have_account:
                findViewById(R.id.loginframe_login).setVisibility(View.GONE);
                mCreateAccount.setVisibility(View.VISIBLE);
                break;
            case R.id.loginbutton_create_account:
                boolean isCreated = createAccount(mEmail.getText().toString(), mPassword.getText().toString());
                if (!isCreated) {
                    break;
                }
                mCreateAccount.setVisibility(View.GONE);
                findViewById(R.id.loginframe_login).setVisibility(View.VISIBLE);
                break;
            case R.id.loginbutton_log_in:
                signIn(mEmail.getText().toString(), mPassword.getText().toString());
                break;
            default:
                break;
        }
    }

    private boolean createAccount(String email, String password) {
        if (!validForm()) {
            return false;
        }
        if (mController.userIsPresent(email)) {
            mEmail.setError(getString(R.string.duplicate_email));
            return false;
        } else {
            mEmail.setError(null);
        }
        User user = new User(email, password);
        mController.addUser(user);
        mPassword.setText("");
        Toast.makeText(this, "Account is created", Toast.LENGTH_SHORT).show();
        return true;
    }

    private boolean validForm() {
        boolean valid = true;

        String email = mEmail.getText().toString();
        if (TextUtils.isEmpty(email)) {
            mEmail.setError(getString(R.string.required));
            valid = false;
        } else if (!email.contains("@")) {
            mEmail.setError(getString(R.string.wrong_email));
            valid = false;
        } else {
            mEmail.setError(null);
        }

        String password = mPassword.getText().toString();
        if (TextUtils.isEmpty(password)) {
            mPassword.setError(getString(R.string.required));
            valid = false;
        } else if (password.length() < 6) {
            mPassword.setError(getString(R.string.too_short));
            valid = false;
        } else {
            mPassword.setError(null);
        }

        return valid;
    }

    private void signIn(String email, String password) {
        if (!validForm()) {
            return;
        }
        if (!mController.userIsPresent(email)) {
            mEmail.setError(getString(R.string.no_user_with_such_email));
            return;
        } else {
            mEmail.setError(null);
        }

        User user = mController.getUserByEmail(email);

        if (!user.isPasswordCorrect(password)) {
            mPassword.setError(getString(R.string.wrong_password));
            return;
        } else {
            mPassword.setError(null);
        }

        mSharedPreferences.signIn(email);
        mPassword.setText("");
        startActivity(new Intent(this, MainActivity.class));
    }

}
