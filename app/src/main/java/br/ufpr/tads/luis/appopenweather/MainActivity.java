package br.ufpr.tads.luis.appopenweather;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

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

        if ((editTextCidade.length() == 0) || (editTextPais.length() == 0)) {
            Toast.makeText(this, "Informe a Cidade e o País para consulta!", Toast.LENGTH_SHORT).show();
            return;
        }

        String cidade = editTextCidade.getText().toString();
        String pais = editTextPais.getText().toString();

        ProgressDialog progressDialog = new ProgressDialog(this);
        progressDialog.setMessage("Consultando clima...");
        progressDialog.show();

        textViewTempAtual.setText("");
        textViewMinima.setText("");
        textViewMaxima.setText("");
        textViewUmidade.setText("");

        Call<Weather> call = new RetrofitConfig().getWeatherService().getWeather(cidade + "," + pais);
        call.enqueue(new Callback<Weather>() {
            @Override
            public void onResponse(Call<Weather> call, Response<Weather> response) {
                Log.i("TESTE", "onResponse: teste");
                Log.i("TESTE", "onResponse: " + response.toString());
                if (response.isSuccessful()) {
                    Weather weather = response.body();
                    progressDialog.dismiss();
                    textViewTempAtual.setText(String.valueOf(weather.getMain().getTemp()) + " °C");
                    textViewMinima.setText(String.valueOf(weather.getMain().getTempMin() + " °C"));
                    textViewMaxima.setText(String.valueOf(weather.getMain().getTempMax() + " °C"));
                    textViewUmidade.setText(String.valueOf(weather.getMain().getHumidity() + "%"));
                }
                else {
                    progressDialog.dismiss();
                    new AlertDialog.Builder(getApplicationContext()).setTitle("Erro!").setMessage(response.message()).show();
                }
            }

            @Override
            public void onFailure(Call<Weather> call, Throwable t) {
                Log.e("CALL ERROR", "onFailure: " + t.getMessage(), t);
            }
        });
    }
}