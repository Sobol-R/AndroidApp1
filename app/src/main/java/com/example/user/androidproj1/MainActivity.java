package com.example.user.androidproj1;

import android.inputmethodservice.Keyboard;
import android.support.design.widget.Snackbar;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity {
    EditText userName;
    EditText password;
    Button loginButton;
    RelativeLayout relativeLayout;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initialize();
        initializeAnimation();
    }
    private void initialize() {
        //находим тектовое поля кнопку
        userName = findViewById(R.id.username);
        password = findViewById(R.id.password);
        loginButton = findViewById(R.id.loginButton);
        relativeLayout = findViewById(R.id.mainLayout);
        userName.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2){

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void afterTextChanged(Editable editable) {
                checkUserName();
                check();
            }
        });
        password.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void afterTextChanged(Editable editable) {
               check();
            }
        });

        //TextView showPassword = findViewById(R.id.)
        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

               // Toast.makeText(MainActivity.this, "вы не ввели ваш логин", Toast.LENGTH_LONG).show();
                final Snackbar snack = Snackbar.make(loginButton, "Wrong password or Login", Snackbar.LENGTH_LONG);
                snack.show();
                clear();
                snack.setAction("Hide", new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        snack.dismiss();
                    }
                });
            }
        });
        ActionBar actionBar = getSupportActionBar();
        actionBar.setDisplayHomeAsUpEnabled(true);
        actionBar.setHomeAsUpIndicator(R.drawable.ic_motorcycle_black_24dp);
        actionBar.setTitle("title");
        actionBar.setSubtitle("subtitle");
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate(R.menu.login_activitu_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.about :
                return true;
            case  R.id.exit :
                finish();
                return true;
                default: return false;
        }
    }
    private void initializeAnimation() {
        Animation animation = AnimationUtils.loadAnimation(MainActivity.this, android.R.anim.slide_in_left);
        animation.setDuration(1000);
        animation.setStartOffset(500);
        relativeLayout.startAnimation(animation);
    }
    private void setLoginButtonAnim() {
        Animation animation = AnimationUtils.loadAnimation(MainActivity.this, android.R.anim.slide_in_left);
        animation.setDuration(1000);
        animation.setStartOffset(500);
        loginButton.startAnimation(animation);
    }
    private void clear() {
        userName.getText().clear();
        password.getText().clear();
    }
    private void checkUserName() {
        if (!TextUtils.isEmpty(userName.getText())) {
            password.setVisibility(View.VISIBLE);
            loginButton.setVisibility(View.VISIBLE);
        }
    }
    private void check() {
        if (!TextUtils.isEmpty(userName.getText()) && !TextUtils.isEmpty(password.getText())) {
            loginButton.setEnabled(true);
            setLoginButtonAnim();
        } else {
            loginButton.setEnabled(false);
        }
    }
}
