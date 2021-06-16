package com.example.beeradviser;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Spinner;
import android.widget.TextView;

import java.util.List;

public class FindBeerActivity extends AppCompatActivity {
    private BeerExpert expert = new BeerExpert();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_find_beer);

    }

    // Вызываем при щелчку на кнопку.
    public void onClickFindBeer(View view){
        // Получить ссылку на TextView.
        TextView brands = (TextView) findViewById(R.id.brands);
        // Получить ссылку на спинер.
        Spinner color = (Spinner) findViewById(R.id.color);
        // Получить вариант выбранный в Spiner.
        String beerType =String.valueOf(color.getSelectedItem());

        List<String> brandList = expert.getBrands(beerType);
        StringBuilder brandsFormatted = new StringBuilder();
        for(String brand : brandList) {
            brandsFormatted.append(brand).append('\n');
        }
        // Вывести сорта пива.
        brands.setText(brandsFormatted);
    }
}
