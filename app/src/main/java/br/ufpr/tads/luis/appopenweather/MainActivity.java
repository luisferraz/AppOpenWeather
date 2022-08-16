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
    EditText editTextCidade, editTextPais;
    TextView output;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }

    public void getWeatherData(View view) {
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
                    output.setText(weather.toString());
                }
            }

            @Override
            public void onFailure(Call<Weather> call, Throwable t) {

            }
        });
    }
}