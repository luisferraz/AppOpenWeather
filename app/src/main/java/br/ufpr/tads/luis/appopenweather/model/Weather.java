package br.ufpr.tads.luis.appopenweather.model;

public class Weather {
    private String cidade;
    private String pais;
    private Double tempAtual;
    private Double tempMin;
    private Double tempMax;
    private Double umidade;

    public Weather() {
    }

    public Weather(String cidade, String pais, Double tempAtual, Double tempMin, Double tempMax, Double umidade) {
        this.cidade = cidade;
        this.pais = pais;
        this.tempAtual = tempAtual;
        this.tempMin = tempMin;
        this.tempMax = tempMax;
        this.umidade = umidade;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public String getPais() {
        return pais;
    }

    public void setPais(String pais) {
        this.pais = pais;
    }

    public Double getTempAtual() {
        return tempAtual;
    }

    public void setTempAtual(Double tempAtual) {
        this.tempAtual = tempAtual;
    }

    public Double getTempMin() {
        return tempMin;
    }

    public void setTempMin(Double tempMin) {
        this.tempMin = tempMin;
    }

    public Double getTempMax() {
        return tempMax;
    }

    public void setTempMax(Double tempMax) {
        this.tempMax = tempMax;
    }

    public Double getUmidade() {
        return umidade;
    }

    public void setUmidade(Double umidade) {
        this.umidade = umidade;
    }

    @Override
    public String toString() {
        return "Weather{" +
                "cidade='" + cidade + '\'' +
                ", pais='" + pais + '\'' +
                ", tempAtual=" + tempAtual +
                ", tempMin=" + tempMin +
                ", tempMax=" + tempMax +
                ", umidade=" + umidade +
                '}';
    }
}
