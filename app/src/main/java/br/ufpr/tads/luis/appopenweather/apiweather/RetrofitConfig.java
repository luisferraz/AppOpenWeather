package br.ufpr.tads.luis.appopenweather.apiweather;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitConfig {
    private final Retrofit retrofit;
    private final String baseURL = "https://api.openweathermap.org/data/2.5/weather";

    public RetrofitConfig() {
        this.retrofit = new Retrofit.Builder().baseUrl(baseURL).addConverterFactory(GsonConverterFactory.create()).build();
    }

    public WeatherService getWeatherService() {
        return this.retrofit.create(WeatherService.class);
    }
}
