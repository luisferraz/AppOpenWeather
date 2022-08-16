package br.ufpr.tads.luis.appopenweather;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import br.ufpr.tads.luis.appopenweather.apiweather.RetrofitConfig;
import br.ufpr.tads.luis.appopenweather.model.Weather;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }

    public void getWeatherData(View view) {
        TextView textViewTempAtual = findViewById(R.id.textViewTempAtual);
        TextView textViewMaxima = findViewById(R.id.textViewMaxima);
        TextView textViewMinima = findViewById(R.id.textViewMinima);
        TextView textViewUmidade = findViewById(R.id.textViewUmidade);

        EditText editTextCidade = findViewById(R.id.editTextCidade);
        EditText editTextPais = findViewById(R.id.editTextPais);

        ProgressDialog progressDialog = new ProgressDialog(this);
        progressDialog.setMessage("Consultando clima...");
        progressDialog.show();


        Call<Weather> call = new RetrofitConfig().getWeatherService().getWeather("Curitiba", "BR");
        call.enqueue(new Callback<Weather>() {
            @Override
            public void onResponse(Call<Weather> call, Response<Weather> response) {
                if (response.isSuccessful()) {
                    Weather weather = response.body();
                    progressDialog.dismiss();
                    assert weather != null;
                    textViewTempAtual.setText(weather.toString());
                }
            }

            @Override
            public void onFailure(Call<Weather> call, Throwable t) {

            }
        });
    }
}