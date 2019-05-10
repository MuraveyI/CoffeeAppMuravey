package com.muravey;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.ImageView;
import android.widget.TextView;


public class LatteCoffee extends AppCompatActivity {

    CoffeeModel coffeeModel;
    ImageView generalImage;
    TextView generalText;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.latte_activity);

        generalImage = findViewById(R.id.latte_image);
        generalText = findViewById(R.id.latte_text);


        coffeeModel = (CoffeeModel) getIntent().getSerializableExtra("coffee");
        if (coffeeModel != null) {

            generalImage.setImageResource(coffeeModel.getImage());

            Log.e("LATTE = ", "onCreate: = " + coffeeModel.getName());


            switch (coffeeModel.getName()) {

                case "Latte":
                    generalText.setText(R.string.latte);
                    break;
                case "Americano":
                    generalText.setText(R.string.americano);
                    break;
                case "Flat White":
                    generalText.setText(R.string.FlateWhite);
                    break;
                case "Cappuccino":
                    generalText.setText(R.string.Cappucino);
                    break;
                case "Frappuccino":
                    generalText.setText(R.string.Frapuccino);
                    break;
                case "Mocha":
                    generalText.setText(R.string.Mocha);
                    break;
                case "Kemex":
                    generalText.setText(R.string.Kemex);
                    break;
                case "Raf":
                    generalText.setText(R.string.Raf);
                    break;
                default:
                    generalText.setText(" there will be text and your coffee");

            }


        }
    }
}
