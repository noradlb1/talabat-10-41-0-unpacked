package com.newrelic.com.google.gson;

import com.newrelic.com.google.gson.stream.JsonReader;
import java.io.IOException;

public interface ToNumberStrategy {
    Number readNumber(JsonReader jsonReader) throws IOException;
}
