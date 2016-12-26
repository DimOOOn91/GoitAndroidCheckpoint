package com.example.dima.goitandroidcheckpoint;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.dima.goitandroidcheckpoint.entity.User;

import java.util.ArrayList;
import java.util.List;

public class LoginActivity extends AppCompatActivity {

    public static final String IS_USER_SIGN_IN = "is sign in";

    private List<User> mUsers;

    private EditText mEmail;
    private EditText mPassword;
    private Button mCreateAccount;

    SharedPreferences mSharedPreferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        setTitle(getString(R.string.log_in));

        mUsers = new ArrayList<>();
        mSharedPreferences = getSharedPreferences("my_preferences", MODE_PRIVATE);

        mEmail = (EditText) findViewById(R.id.loginedit_email);
        mPassword = (EditText) findViewById(R.id.loginedit_password);
        mCreateAccount = (Button) findViewById(R.id.loginbutton_create_account);
        mCreateAccount.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                click(view);
            }
        });
        Button logIn = (Button) findViewById(R.id.loginbutton_log_in);
        logIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                click(view);
            }
        });
        TextView mDontHaveAccount = (TextView) findViewById(R.id.logintext_dont_have_account);
        mDontHaveAccount.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                click(view);
            }
        });

    }

    @Override
    protected void onStart() {
        boolean isSignIn = mSharedPreferences.getBoolean(IS_USER_SIGN_IN, false);
        if (isSignIn) {
            enterTheProgram();
        }
        super.onStart();
    }

    private void click(View view) {
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
        mEmail.setError(null);
        for (User existingUser : mUsers) {
            if (email.equals(existingUser.getEmail())) {
                mEmail.setError(getString(R.string.duplicate_email));
                return false;
            }
        }
        User user = new User(email, password);
        mUsers.add(user);
        mSharedPreferences.edit().putBoolean(IS_USER_SIGN_IN, true).apply();
        mPassword.setText("");
        Toast.makeText(this, "Account is created", Toast.LENGTH_SHORT).show();
        return true;
    }

    private void signIn(String email, String password) {
        if (!validForm()) {
            return;
        }
        User user = new User(email, password);
        if (!mUsers.contains(user)) {
            mEmail.setError(getString(R.string.wrong_email_or_password));
            mPassword.setError(getString(R.string.wrong_email_or_password));
            return;
        } else {
            mEmail.setError(null);
            mPassword.setError(null);
        }
        mSharedPreferences.edit().putBoolean(IS_USER_SIGN_IN, true).apply();
        mPassword.setText("");
        enterTheProgram();
        return;

    }

    private void enterTheProgram() {
        startActivity(new Intent(this, MainActivity.class));
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
}
