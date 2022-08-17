package br.ufpr.tads.luis.appopenweather.apiweather;

import br.ufpr.tads.luis.appopenweather.model.Weather;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface WeatherService {

    @GET("weather?appid=720fcb1a8ea100d9aed065dd6715bbca&units=metric")
    Call<Weather> getWeather(@Query("q") String query);
//            @Path("cidade") String cidade, @Path("pais") String pais);

}
