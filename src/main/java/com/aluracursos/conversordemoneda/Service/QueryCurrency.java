package com.aluracursos.conversordemoneda.Service;

import com.aluracursos.conversordemoneda.Model.CurrencyAPIModel;
import com.google.gson.Gson;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class QueryCurrency {

    public CurrencyAPIModel getCurrency(String currency) {
        URI url = URI.create("https://v6.exchangerate-api.com/v6/3e729b49e55c8eec5209f399/latest/" + currency.toLowerCase().replace(" ", ""));

        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder().uri(url).build();
        HttpResponse<String> response;

        try {
            response = client.send(request, HttpResponse.BodyHandlers.ofString());
        } catch (Exception e) {
            throw new RuntimeException("La moneda no fue encontrada.");
        }

        return new Gson().fromJson(response.body(), CurrencyAPIModel.class);
    }
}