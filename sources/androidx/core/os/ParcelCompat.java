package androidx.core.os;

import android.annotation.SuppressLint;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.SparseArray;
import androidx.annotation.DoNotInline;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.OptIn;
import androidx.annotation.RequiresApi;
import androidx.core.os.BuildCompat;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public final class ParcelCompat {

    @RequiresApi(29)
    public static class Api29Impl {
        private Api29Impl() {
        }

        @DoNotInline
        public static final <T extends Parcelable> List<T> a(@NonNull Parcel parcel, @NonNull List<T> list, @Nullable ClassLoader classLoader) {
            return parcel.readParcelableList(list, classLoader);
        }
    }

    @RequiresApi(30)
    public static class Api30Impl {
        private Api30Impl() {
        }

        @DoNotInline
        public static final Parcelable.Creator<?> a(@NonNull Parcel parcel, @Nullable ClassLoader classLoader) {
            return parcel.readParcelableCreator(classLoader);
        }
    }

    @RequiresApi(33)
    public static class TiramisuImpl {
        private TiramisuImpl() {
        }

        @DoNotInline
        public static <T extends Parcelable> T a(@NonNull Parcel parcel, @Nullable ClassLoader classLoader, @NonNull Class<T> cls) {
            return (Parcelable) parcel.readParcelable(classLoader, cls);
        }

        @DoNotInline
        public static <T> T[] b(@NonNull Parcel parcel, @Nullable ClassLoader classLoader, @NonNull Class<T> cls) {
            return parcel.readParcelableArray(classLoader, cls);
        }

        @DoNotInline
        public static <T> List<T> c(@NonNull Parcel parcel, @NonNull List<T> list, @Nullable ClassLoader classLoader, @NonNull Class<T> cls) {
            return parcel.readParcelableList(list, classLoader, cls);
        }

        @DoNotInline
        public static <T extends Serializable> T d(@NonNull Parcel parcel, @Nullable ClassLoader classLoader, @NonNull Class<T> cls) {
            return (Serializable) parcel.readSerializable(classLoader, cls);
        }

        @DoNotInline
        public static <T> T[] readArray(Parcel parcel, ClassLoader classLoader, Class<T> cls) {
            return parcel.readArray(classLoader, cls);
        }

        @DoNotInline
        public static <T> ArrayList<T> readArrayList(Parcel parcel, ClassLoader classLoader, Class<? extends T> cls) {
            return parcel.readArrayList(classLoader, cls);
        }

        @DoNotInline
        public static <V, K> HashMap<K, V> readHashMap(Parcel parcel, ClassLoader classLoader, Class<? extends K> cls, Class<? extends V> cls2) {
            return parcel.readHashMap(classLoader, cls, cls2);
        }

        @DoNotInline
        public static <T> void readList(@NonNull Parcel parcel, @NonNull List<? super T> list, @Nullable ClassLoader classLoader, @NonNull Class<T> cls) {
            parcel.readList(list, classLoader, cls);
        }

        @DoNotInline
        public static <K, V> void readMap(Parcel parcel, Map<? super K, ? super V> map, ClassLoader classLoader, Class<K> cls, Class<V> cls2) {
            parcel.readMap(map, classLoader, cls, cls2);
        }

        @DoNotInline
        public static <T> Parcelable.Creator<T> readParcelableCreator(Parcel parcel, ClassLoader classLoader, Class<T> cls) {
            return parcel.readParcelableCreator(classLoader, cls);
        }

        @DoNotInline
        public static <T> SparseArray<T> readSparseArray(Parcel parcel, ClassLoader classLoader, Class<? extends T> cls) {
            return parcel.readSparseArray(classLoader, cls);
        }
    }

    private ParcelCompat() {
    }

    @SuppressLint({"ArrayReturn", "NullableCollection"})
    @OptIn(markerClass = {BuildCompat.PrereleaseSdkCheck.class})
    @Nullable
    public static <T> T[] readArray(@NonNull Parcel parcel, @Nullable ClassLoader classLoader, @NonNull Class<T> cls) {
        if (BuildCompat.isAtLeastT()) {
            return TiramisuImpl.readArray(parcel, classLoader, cls);
        }
        return parcel.readArray(classLoader);
    }

    @SuppressLint({"ConcreteCollection", "NullableCollection"})
    @OptIn(markerClass = {BuildCompat.PrereleaseSdkCheck.class})
    @Nullable
    public static <T> ArrayList<T> readArrayList(@NonNull Parcel parcel, @Nullable ClassLoader classLoader, @NonNull Class<? extends T> cls) {
        if (BuildCompat.isAtLeastT()) {
            return TiramisuImpl.readArrayList(parcel, classLoader, cls);
        }
        return parcel.readArrayList(classLoader);
    }

    public static boolean readBoolean(@NonNull Parcel parcel) {
        return parcel.readInt() != 0;
    }

    @SuppressLint({"ConcreteCollection", "NullableCollection"})
    @OptIn(markerClass = {BuildCompat.PrereleaseSdkCheck.class})
    @Nullable
    public static <K, V> HashMap<K, V> readHashMap(@NonNull Parcel parcel, @Nullable ClassLoader classLoader, @NonNull Class<? extends K> cls, @NonNull Class<? extends V> cls2) {
        if (BuildCompat.isAtLeastT()) {
            return TiramisuImpl.readHashMap(parcel, classLoader, cls, cls2);
        }
        return parcel.readHashMap(classLoader);
    }

    @OptIn(markerClass = {BuildCompat.PrereleaseSdkCheck.class})
    public static <T> void readList(@NonNull Parcel parcel, @NonNull List<? super T> list, @Nullable ClassLoader classLoader, @NonNull Class<T> cls) {
        if (BuildCompat.isAtLeastT()) {
            TiramisuImpl.readList(parcel, list, classLoader, cls);
        } else {
            parcel.readList(list, classLoader);
        }
    }

    @OptIn(markerClass = {BuildCompat.PrereleaseSdkCheck.class})
    public static <K, V> void readMap(@NonNull Parcel parcel, @NonNull Map<? super K, ? super V> map, @Nullable ClassLoader classLoader, @NonNull Class<K> cls, @NonNull Class<V> cls2) {
        if (BuildCompat.isAtLeastT()) {
            TiramisuImpl.readMap(parcel, map, classLoader, cls, cls2);
        } else {
            parcel.readMap(map, classLoader);
        }
    }

    @OptIn(markerClass = {BuildCompat.PrereleaseSdkCheck.class})
    @Nullable
    public static <T extends Parcelable> T readParcelable(@NonNull Parcel parcel, @Nullable ClassLoader classLoader, @NonNull Class<T> cls) {
        if (BuildCompat.isAtLeastT()) {
            return TiramisuImpl.a(parcel, classLoader, cls);
        }
        return parcel.readParcelable(classLoader);
    }

    @SuppressLint({"ArrayReturn", "NullableCollection"})
    @OptIn(markerClass = {BuildCompat.PrereleaseSdkCheck.class})
    @Nullable
    public static <T> T[] readParcelableArray(@NonNull Parcel parcel, @Nullable ClassLoader classLoader, @NonNull Class<T> cls) {
        if (BuildCompat.isAtLeastT()) {
            return TiramisuImpl.b(parcel, classLoader, cls);
        }
        return parcel.readParcelableArray(classLoader);
    }

    @RequiresApi(30)
    @OptIn(markerClass = {BuildCompat.PrereleaseSdkCheck.class})
    @Nullable
    public static <T> Parcelable.Creator<T> readParcelableCreator(@NonNull Parcel parcel, @Nullable ClassLoader classLoader, @NonNull Class<T> cls) {
        if (BuildCompat.isAtLeastT()) {
            return TiramisuImpl.readParcelableCreator(parcel, classLoader, cls);
        }
        return Api30Impl.a(parcel, classLoader);
    }

    @RequiresApi(api = 29)
    @OptIn(markerClass = {BuildCompat.PrereleaseSdkCheck.class})
    @NonNull
    public static <T> List<T> readParcelableList(@NonNull Parcel parcel, @NonNull List<T> list, @Nullable ClassLoader classLoader, @NonNull Class<T> cls) {
        if (BuildCompat.isAtLeastT()) {
            return TiramisuImpl.c(parcel, list, classLoader, cls);
        }
        return Api29Impl.a(parcel, list, classLoader);
    }

    @OptIn(markerClass = {BuildCompat.PrereleaseSdkCheck.class})
    @Nullable
    public static <T extends Serializable> T readSerializable(@NonNull Parcel parcel, @Nullable ClassLoader classLoader, @NonNull Class<T> cls) {
        if (BuildCompat.isAtLeastT()) {
            return TiramisuImpl.d(parcel, classLoader, cls);
        }
        return parcel.readSerializable();
    }

    @OptIn(markerClass = {BuildCompat.PrereleaseSdkCheck.class})
    @Nullable
    public static <T> SparseArray<T> readSparseArray(@NonNull Parcel parcel, @Nullable ClassLoader classLoader, @NonNull Class<? extends T> cls) {
        if (BuildCompat.isAtLeastT()) {
            return TiramisuImpl.readSparseArray(parcel, classLoader, cls);
        }
        return parcel.readSparseArray(classLoader);
    }

    public static void writeBoolean(@NonNull Parcel parcel, boolean z11) {
        parcel.writeInt(z11 ? 1 : 0);
    }
}
