package com.example.a332;

import android.content.res.Configuration;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;

import androidx.appcompat.app.AppCompatActivity;

import java.util.Locale;

public class MainActivity extends AppCompatActivity {
    private Spinner spinner;
    private Button button;
    private Spinner spinnerTheme;
    private Button buttonTheme;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Utils.onActivityCreateSetTheme(this);
        spinner = findViewById(R.id.spinner);
        spinnerTheme = findViewById(R.id.spinnerTheme);
        button = findViewById(R.id.button);
        buttonTheme = findViewById(R.id.buttonTheme);
        initSpinnerCountries();
        initSpinnerStyleTheme();
        onClick();
        onClickTheme();
    }

    private void initSpinnerCountries() {
        ArrayAdapter<CharSequence> adapterCountries = ArrayAdapter.createFromResource(this,
                R.array.countries, android.R.layout.simple_spinner_item);
        spinner.setAdapter(adapterCountries);

    }

    private void onClick() {
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int selected = spinner.getSelectedItemPosition();
                switch (selected) {
                    case 0: {
                        spinnerLocale("ru");
                        break;
                    }
                    case 1: {
                        spinnerLocale("de");
                        break;
                    }
                    case 2: {
                        spinnerLocale("ang");
                        break;
                    }
                }
            }

        });
    }

    public void spinnerLocale(String language) {
        Locale locale = new Locale(language);
        Configuration config = new Configuration();
        config.setLocale(locale);
        getResources().updateConfiguration(config, getBaseContext().getResources().getDisplayMetrics());
        recreate();

    }


    private void initSpinnerStyleTheme() {
        ArrayAdapter<CharSequence> adapterTheme = ArrayAdapter.createFromResource(this,
                R.array.styleTheme, android.R.layout.simple_spinner_item);
        spinner.setAdapter(adapterTheme);
    }

    private void onClickTheme() {
        buttonTheme.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int selectedTheme = spinnerTheme.getSelectedItemPosition();
                switch (selectedTheme) {
                    case 0:
                        Utils.changeToTheme(MainActivity.this, Utils.THEME_DEFAULT);
                        break;
                    case 1:
                        Utils.changeToTheme(MainActivity.this, Utils.THEME_BLACK);
                        break;
                    case 2:
                        Utils.changeToTheme(MainActivity.this, Utils.THEME_GREEN);
                        break;
                    case 3:
                        Utils.changeToTheme(MainActivity.this, Utils.THEME_BLUE);
                        break;
                }
                recreate();
            }

        });
    }

}