package com.adyen.checkout.base.internal;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.newrelic.agent.android.instrumentation.Instrumented;
import com.newrelic.agent.android.instrumentation.JSONObjectInstrumentation;
import com.talabat.configuration.discovery.RealDiscoveryConfigurationRepository;
import j$.util.DesugarTimeZone;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.lang.reflect.Array;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.TimeZone;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

@Instrumented
public abstract class JsonObject implements Parcelable {
    private static final String DATE_PATTERN = "yyyy-MM-dd'T'HH:mm:ss'Z'";
    private static final TimeZone TIME_ZONE = DesugarTimeZone.getTimeZone("UTC");
    private final JSONObject mJsonObject;

    public static abstract class Creator<T extends JsonObject> implements Parcelable.Creator<T> {
        @NonNull
        public abstract T createFromJson(@NonNull JSONObject jSONObject) throws JSONException;

        public final T createFromParcel(@NonNull Parcel parcel) {
            JSONObject readJsonObject = Parcelables.readJsonObject(parcel);
            Objects.requireNonNull(readJsonObject, "JSONObject is null.");
            try {
                return createFromJson(readJsonObject);
            } catch (JSONException e11) {
                throw new RuntimeException("Invalid JSON.", e11);
            }
        }
    }

    public static final class DefaultCreator<T extends JsonObject> extends Creator<T> {
        private final Class<T> mClass;

        public DefaultCreator(@NonNull Class<T> cls) {
            this.mClass = cls;
        }

        @NonNull
        public T createFromJson(@NonNull JSONObject jSONObject) throws JSONException {
            return JsonObject.parseFrom(jSONObject, this.mClass);
        }

        public T[] newArray(int i11) {
            return (JsonObject[]) Array.newInstance(this.mClass, i11);
        }
    }

    @Target({ElementType.FIELD})
    @Retention(RetentionPolicy.RUNTIME)
    public @interface SerializedName {
        @NonNull
        String value();
    }

    public JsonObject(@NonNull JSONObject jSONObject) throws JSONException {
        String str;
        if (!(jSONObject instanceof JSONObject)) {
            str = jSONObject.toString();
        } else {
            str = JSONObjectInstrumentation.toString(jSONObject);
        }
        this.mJsonObject = new JSONObject(str);
    }

    @NonNull
    private static <T extends Enum<T>> T getEnumValueFromField(@NonNull Field field) throws JSONException {
        try {
            return (Enum) field.get((Object) null);
        } catch (IllegalAccessException unused) {
            throw new JSONException("Could not access enum constant " + field.getName() + RealDiscoveryConfigurationRepository.VERSION_DELIMETER);
        }
    }

    @NonNull
    public static <T extends Enum<T>> T parseEnumValue(@NonNull String str, @NonNull Class<T> cls) throws JSONException {
        for (Field field : cls.getFields()) {
            if (str.equalsIgnoreCase(field.getName())) {
                return getEnumValueFromField(field);
            }
            SerializedName serializedName = (SerializedName) field.getAnnotation(SerializedName.class);
            if (serializedName != null && str.equalsIgnoreCase(serializedName.value())) {
                return getEnumValueFromField(field);
            }
        }
        throw new JSONException("Could not find enum constant for value " + str);
    }

    @NonNull
    public static <T extends JsonObject> T parseFrom(@NonNull JSONObject jSONObject, @NonNull Class<T> cls) throws JSONException {
        try {
            return (JsonObject) Objects.reflectiveInit(cls, jSONObject);
        } catch (InvocationTargetException e11) {
            Throwable cause = e11.getCause();
            if (cause instanceof JSONException) {
                throw ((JSONException) cause);
            }
            throw new RuntimeException("Could not instantiate " + cls.getSimpleName() + RealDiscoveryConfigurationRepository.VERSION_DELIMETER, cause);
        }
    }

    @NonNull
    public static JSONObject serialize(@NonNull JsonObject jsonObject) {
        return jsonObject.mJsonObject;
    }

    @Nullable
    public static JSONObject serializeOptional(@Nullable JsonObject jsonObject) {
        if (jsonObject != null) {
            return jsonObject.mJsonObject;
        }
        return null;
    }

    @NonNull
    public JSONObject a() {
        return this.mJsonObject;
    }

    @NonNull
    public final <T extends JsonObject> T b(@NonNull String str, @NonNull Class<T> cls) throws JSONException {
        return parseFrom(this.mJsonObject.getJSONObject(str), cls);
    }

    @NonNull
    public final Date c(@NonNull String str) throws JSONException {
        String string = this.mJsonObject.getString(str);
        try {
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat(DATE_PATTERN, Locale.US);
            simpleDateFormat.setTimeZone(TIME_ZONE);
            return simpleDateFormat.parse(string);
        } catch (ParseException unused) {
            throw new JSONException("Invalid date string: " + string);
        }
    }

    @NonNull
    public final <T extends Enum<T>> T d(@NonNull String str, @NonNull Class<T> cls) throws JSONException {
        return parseEnumValue(this.mJsonObject.getString(str), cls);
    }

    public final int describeContents() {
        return 0;
    }

    @SafeVarargs
    @NonNull
    public final <T extends JsonObject> List<T> e(@NonNull String str, @NonNull Class<T>... clsArr) throws JSONException {
        ArrayList arrayList = new ArrayList();
        JSONArray jSONArray = this.mJsonObject.getJSONArray(str);
        for (int i11 = 0; i11 < jSONArray.length(); i11++) {
            arrayList.add(parseFrom(jSONArray.getJSONObject(i11), clsArr[i11 % clsArr.length]));
        }
        return arrayList;
    }

    @Nullable
    public final <T extends JsonObject> T f(@NonNull String str, @NonNull Class<T> cls) throws JSONException {
        if (this.mJsonObject.has(str)) {
            return b(str, cls);
        }
        return null;
    }

    @SafeVarargs
    @Nullable
    public final <T extends JsonObject> List<T> g(@NonNull String str, @NonNull Class<T>... clsArr) throws JSONException {
        if (this.mJsonObject.has(str)) {
            return e(str, clsArr);
        }
        return null;
    }

    public final void writeToParcel(@NonNull Parcel parcel, int i11) {
        Parcelables.writeJsonObject(parcel, this.mJsonObject);
    }
}
