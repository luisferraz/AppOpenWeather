package br.ufpr.tads.luis.appopenweather.apiweather;

import br.ufpr.tads.luis.appopenweather.model.Weather;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface WeatherService {

    @GET("q={cidade},{pais}&appid=720fcb1a8ea100d9aed065dd6715bbca")
    Call<Weather> getWeather(@Path("cidade") String cidade, @Path("pais") String pais);

}
