package com.aluracursos.conversordemoneda.Model;

import java.util.Map;

public record CurrencyAPIModel(String result,
                               String base_code,
                               Map<String, Double> conversion_rates){
}

