package com.aluracursos.conversordemoneda.Model;

import com.google.gson.annotations.SerializedName;

import java.util.Map;

public class CurrencyModel {

    @SerializedName("result")
    public boolean success;

    @SerializedName("baseCode")
    public String currency;

    @SerializedName("conversionRates")
    public Map<String, Double> conversions;

    public CurrencyModel(CurrencyAPIModel currencyAPIModel) {
        if (currencyAPIModel.result().contains("error")) {
            throw new RuntimeException("Moneda no encontrada.");
        }
        this.success = true;
        this.currency = currencyAPIModel.base_code();
        this.conversions = currencyAPIModel.conversion_rates();
    }

    public double getConversion(String currency) {
        if (!conversions.containsKey(currency)) {
            throw new IllegalArgumentException("Moneda no válida.");
        }
        return conversions.get(currency);
    }

    public String getCurrency() {
        return currency;
    }

    @Override
    public String toString() {
        return "Moneda: " + currency;
    }
}
