package com.google.gson.internal.bind;

import com.google.gson.JsonSyntaxException;
import com.google.gson.TypeAdapter;
import com.google.gson.TypeAdapterFactory;
import com.google.gson.internal.C$Gson$Preconditions;
import com.google.gson.internal.JavaVersion;
import com.google.gson.internal.PreJava9DateFormatProvider;
import com.google.gson.internal.bind.util.ISO8601Utils;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonToken;
import com.google.gson.stream.JsonWriter;
import java.io.IOException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.ParsePosition;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;

public final class DefaultDateTypeAdapter<T extends Date> extends TypeAdapter<T> {
    private static final String SIMPLE_NAME = "DefaultDateTypeAdapter";
    private final List<DateFormat> dateFormats;
    private final DateType<T> dateType;

    public static abstract class DateType<T extends Date> {
        public static final DateType<Date> DATE = new DateType<Date>(Date.class) {
            public Date deserialize(Date date) {
                return date;
            }
        };
        private final Class<T> dateClass;

        public DateType(Class<T> cls) {
            this.dateClass = cls;
        }

        private final TypeAdapterFactory createFactory(DefaultDateTypeAdapter<T> defaultDateTypeAdapter) {
            return TypeAdapters.newFactory(this.dateClass, defaultDateTypeAdapter);
        }

        public final TypeAdapterFactory createAdapterFactory(String str) {
            return createFactory(new DefaultDateTypeAdapter(this, str));
        }

        public final TypeAdapterFactory createDefaultsAdapterFactory() {
            return createFactory(new DefaultDateTypeAdapter(this, 2, 2));
        }

        public abstract T deserialize(Date date);

        public final TypeAdapterFactory createAdapterFactory(int i11) {
            return createFactory(new DefaultDateTypeAdapter(this, i11));
        }

        public final TypeAdapterFactory createAdapterFactory(int i11, int i12) {
            return createFactory(new DefaultDateTypeAdapter(this, i11, i12));
        }
    }

    private Date deserializeToDate(JsonReader jsonReader) throws IOException {
        String nextString = jsonReader.nextString();
        synchronized (this.dateFormats) {
            for (DateFormat parse : this.dateFormats) {
                try {
                    Date parse2 = parse.parse(nextString);
                    return parse2;
                } catch (ParseException unused) {
                }
            }
            try {
                return ISO8601Utils.parse(nextString, new ParsePosition(0));
            } catch (ParseException e11) {
                throw new JsonSyntaxException("Failed parsing '" + nextString + "' as Date; at path " + jsonReader.getPreviousPath(), e11);
            }
        }
    }

    public String toString() {
        DateFormat dateFormat = this.dateFormats.get(0);
        if (dateFormat instanceof SimpleDateFormat) {
            return "DefaultDateTypeAdapter(" + ((SimpleDateFormat) dateFormat).toPattern() + ')';
        }
        return "DefaultDateTypeAdapter(" + dateFormat.getClass().getSimpleName() + ')';
    }

    public T read(JsonReader jsonReader) throws IOException {
        if (jsonReader.peek() == JsonToken.NULL) {
            jsonReader.nextNull();
            return null;
        }
        return this.dateType.deserialize(deserializeToDate(jsonReader));
    }

    public void write(JsonWriter jsonWriter, Date date) throws IOException {
        String format;
        if (date == null) {
            jsonWriter.nullValue();
            return;
        }
        DateFormat dateFormat = this.dateFormats.get(0);
        synchronized (this.dateFormats) {
            format = dateFormat.format(date);
        }
        jsonWriter.value(format);
    }

    private DefaultDateTypeAdapter(DateType<T> dateType2, String str) {
        ArrayList arrayList = new ArrayList();
        this.dateFormats = arrayList;
        this.dateType = (DateType) C$Gson$Preconditions.checkNotNull(dateType2);
        Locale locale = Locale.US;
        arrayList.add(new SimpleDateFormat(str, locale));
        if (!Locale.getDefault().equals(locale)) {
            arrayList.add(new SimpleDateFormat(str));
        }
    }

    private DefaultDateTypeAdapter(DateType<T> dateType2, int i11) {
        ArrayList arrayList = new ArrayList();
        this.dateFormats = arrayList;
        this.dateType = (DateType) C$Gson$Preconditions.checkNotNull(dateType2);
        Locale locale = Locale.US;
        arrayList.add(DateFormat.getDateInstance(i11, locale));
        if (!Locale.getDefault().equals(locale)) {
            arrayList.add(DateFormat.getDateInstance(i11));
        }
        if (JavaVersion.isJava9OrLater()) {
            arrayList.add(PreJava9DateFormatProvider.getUSDateFormat(i11));
        }
    }

    private DefaultDateTypeAdapter(DateType<T> dateType2, int i11, int i12) {
        ArrayList arrayList = new ArrayList();
        this.dateFormats = arrayList;
        this.dateType = (DateType) C$Gson$Preconditions.checkNotNull(dateType2);
        Locale locale = Locale.US;
        arrayList.add(DateFormat.getDateTimeInstance(i11, i12, locale));
        if (!Locale.getDefault().equals(locale)) {
            arrayList.add(DateFormat.getDateTimeInstance(i11, i12));
        }
        if (JavaVersion.isJava9OrLater()) {
            arrayList.add(PreJava9DateFormatProvider.getUSDateTimeFormat(i11, i12));
        }
    }
}
