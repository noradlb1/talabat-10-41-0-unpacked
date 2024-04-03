package com.google.crypto.tink.jwt;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParseException;
import com.google.gson.internal.Streams;
import com.google.gson.stream.JsonReader;
import java.io.StringReader;
import java.util.Iterator;
import java.util.Map;

final class JsonUtil {
    private JsonUtil() {
    }

    public static boolean isValidString(String str) {
        int length = str.length();
        int i11 = 0;
        while (i11 != length) {
            char charAt = str.charAt(i11);
            i11++;
            if (Character.isSurrogate(charAt)) {
                if (Character.isLowSurrogate(charAt) || i11 == length || !Character.isLowSurrogate(str.charAt(i11))) {
                    return false;
                }
                i11++;
            }
        }
        return true;
    }

    public static JsonObject parseJson(String str) throws JwtInvalidException {
        try {
            JsonReader jsonReader = new JsonReader(new StringReader(str));
            jsonReader.setLenient(false);
            JsonObject asJsonObject = Streams.parse(jsonReader).getAsJsonObject();
            validateAllStringsInJsonObject(asJsonObject);
            return asJsonObject;
        } catch (JsonParseException | IllegalStateException | StackOverflowError e11) {
            throw new JwtInvalidException("invalid JSON: " + e11);
        }
    }

    public static JsonArray parseJsonArray(String str) throws JwtInvalidException {
        try {
            JsonReader jsonReader = new JsonReader(new StringReader(str));
            jsonReader.setLenient(false);
            JsonArray asJsonArray = Streams.parse(jsonReader).getAsJsonArray();
            validateAllStringsInJsonArray(asJsonArray);
            return asJsonArray;
        } catch (JsonParseException | IllegalStateException | StackOverflowError e11) {
            throw new JwtInvalidException("invalid JSON: " + e11);
        }
    }

    private static void validateAllStringsInJsonArray(JsonArray jsonArray) throws JwtInvalidException {
        Iterator<JsonElement> it = jsonArray.iterator();
        while (it.hasNext()) {
            validateAllStringsInJsonElement(it.next());
        }
    }

    private static void validateAllStringsInJsonElement(JsonElement jsonElement) throws JwtInvalidException {
        if (!jsonElement.isJsonPrimitive() || !jsonElement.getAsJsonPrimitive().isString()) {
            if (jsonElement.isJsonObject()) {
                validateAllStringsInJsonObject(jsonElement.getAsJsonObject());
            } else if (jsonElement.isJsonArray()) {
                validateAllStringsInJsonArray(jsonElement.getAsJsonArray());
            }
        } else if (!isValidString(jsonElement.getAsJsonPrimitive().getAsString())) {
            throw new JwtInvalidException("JSON string contains invalid character");
        }
    }

    private static void validateAllStringsInJsonObject(JsonObject jsonObject) throws JwtInvalidException {
        for (Map.Entry next : jsonObject.entrySet()) {
            if (isValidString((String) next.getKey())) {
                validateAllStringsInJsonElement((JsonElement) next.getValue());
            } else {
                throw new JwtInvalidException("JSON string contains character");
            }
        }
    }
}
