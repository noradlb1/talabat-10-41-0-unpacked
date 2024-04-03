package com.deliveryhero.persistence.serializers;

import androidx.annotation.NonNull;
import com.deliveryhero.perseus.data.remote.api.client.PerseusRetrofitBuilder;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;
import java.lang.reflect.Type;

public class GsonSerializerFactory {
    private static SerializerInterface createSerializerWithDateFormat(String str) {
        return new GsonSerializer(new GsonBuilder().setDateFormat(str).create());
    }

    public static SerializerInterface createSerializerWithTimeStampDateFormat() {
        return createSerializerWithDateFormat(PerseusRetrofitBuilder.DATE_FORMAT_DATE_TIME);
    }

    public static <T> T deSerialize(String str, TypeToken<T> typeToken) {
        String[] dateFormats = getDateFormats();
        int i11 = 0;
        while (i11 < dateFormats.length) {
            try {
                return createSerializerWithDateFormat(dateFormats[i11]).deSerialize(str, typeToken);
            } catch (Exception unused) {
                i11++;
            }
        }
        return null;
    }

    @NonNull
    private static String[] getDateFormats() {
        return new String[]{"yyyy-MM-dd hh:mm:ss a", PerseusRetrofitBuilder.DATE_FORMAT_DATE_TIME, "MMM dd, yyyy hh:mm:ss a", "MMM dd, yyyy HH:mm:ss"};
    }

    public static String serialize(Object obj) {
        return createSerializerWithTimeStampDateFormat().serialize(obj);
    }

    public static <T> T deSerialize(String str, Type type) {
        String[] dateFormats = getDateFormats();
        int i11 = 0;
        while (i11 < dateFormats.length) {
            try {
                return createSerializerWithDateFormat(dateFormats[i11]).deSerialize(str, type);
            } catch (Exception unused) {
                i11++;
            }
        }
        return null;
    }

    public static <T> T deSerialize(String str, Class<T> cls) {
        String[] dateFormats = getDateFormats();
        int i11 = 0;
        while (i11 < dateFormats.length) {
            try {
                return createSerializerWithDateFormat(dateFormats[i11]).deSerialize(str, cls);
            } catch (Exception unused) {
                i11++;
            }
        }
        return null;
    }
}
