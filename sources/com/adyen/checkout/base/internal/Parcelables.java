package com.adyen.checkout.base.internal;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.newrelic.agent.android.instrumentation.Instrumented;
import com.newrelic.agent.android.instrumentation.JSONObjectInstrumentation;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;

@Instrumented
public final class Parcelables {
    private static final int FLAG_NON_NULL = 1;
    private static final int FLAG_NULL = 0;

    private Parcelables() {
        throw new IllegalStateException("No instances.");
    }

    @Nullable
    public static <T extends Parcelable> T read(@NonNull Parcel parcel, @NonNull Class<T> cls) {
        int readInt = parcel.readInt();
        if (readInt == 0) {
            return null;
        }
        if (readInt == 1) {
            return parcel.readParcelable(cls.getClassLoader());
        }
        throw new IllegalArgumentException("Invalid flag.");
    }

    @Nullable
    public static JSONObject readJsonObject(@NonNull Parcel parcel) {
        int readInt = parcel.readInt();
        if (readInt == 0) {
            return null;
        }
        if (readInt == 1) {
            try {
                return new JSONObject(parcel.readString());
            } catch (JSONException e11) {
                throw new RuntimeException("Invalid JSON.", e11);
            }
        } else {
            throw new IllegalArgumentException("Invalid flag.");
        }
    }

    @Nullable
    public static <T extends Parcelable> List<T> readList(@NonNull Parcel parcel, @NonNull Class cls) {
        int readInt = parcel.readInt();
        if (readInt == 0) {
            return null;
        }
        if (readInt == 1) {
            ArrayList arrayList = new ArrayList();
            parcel.readList(arrayList, cls.getClassLoader());
            return arrayList;
        }
        throw new IllegalArgumentException("Invalid flag.");
    }

    @Nullable
    public static <T extends Serializable> T readSerializable(@NonNull Parcel parcel) {
        int readInt = parcel.readInt();
        if (readInt == 0) {
            return null;
        }
        if (readInt == 1) {
            return parcel.readSerializable();
        }
        throw new IllegalArgumentException("Invalid flag.");
    }

    public static <T extends Parcelable> void write(@NonNull Parcel parcel, @Nullable T t11) {
        if (t11 == null) {
            parcel.writeInt(0);
            return;
        }
        parcel.writeInt(1);
        parcel.writeParcelable(t11, 0);
    }

    public static void writeJsonObject(@NonNull Parcel parcel, @Nullable JSONObject jSONObject) {
        if (jSONObject == null) {
            parcel.writeInt(0);
            return;
        }
        parcel.writeInt(1);
        parcel.writeString(JSONObjectInstrumentation.toString(jSONObject));
    }

    public static <T extends Parcelable> void writeList(@NonNull Parcel parcel, @Nullable List<T> list) {
        if (list == null) {
            parcel.writeInt(0);
            return;
        }
        parcel.writeInt(1);
        parcel.writeList(list);
    }

    public static <T extends Serializable> void writeSerializable(@NonNull Parcel parcel, @Nullable T t11) {
        if (t11 == null) {
            parcel.writeInt(0);
            return;
        }
        parcel.writeInt(1);
        parcel.writeSerializable(t11);
    }
}
