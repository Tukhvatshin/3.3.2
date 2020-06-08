package com.example.a332;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.content.res.Configuration;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;

import java.util.Locale;

public class MainActivity extends AppCompatActivity {
    protected Spinner spinner;
    protected Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        spinner = findViewById(R.id.spinner);
        button = findViewById(R.id.button);
        initSpinnerCountries();
        onClick();
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
                    case 0:
                        spinnerLocale("ru");
                        break;

                    case 1:
                        spinnerLocale("us");

                        break;
                    case 2:
                        spinnerLocale("de");

                        break;
                }
            }
        });

    }

    public void spinnerLocale(String language) {
        Locale locale = new Locale(language);
        Configuration config = new Configuration();
        config.setLocale(locale);
        getResources().updateConfiguration(config, getBaseContext().getResources().getDisplayMetrics());
    }
}


