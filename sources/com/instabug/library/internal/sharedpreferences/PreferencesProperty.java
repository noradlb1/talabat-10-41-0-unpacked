package com.instabug.library.internal.sharedpreferences;

import android.content.SharedPreferences;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import kotlin.properties.ReadWriteProperty;
import kotlin.reflect.KProperty;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public abstract class PreferencesProperty<T> implements ReadWriteProperty<Object, T> {
    private final T defaultValue;
    private volatile boolean firstLoad = true;
    @NotNull
    private final String key;
    private volatile T value;

    public PreferencesProperty(@NotNull String str, T t11) {
        Intrinsics.checkNotNullParameter(str, "key");
        this.key = str;
        this.defaultValue = t11;
        this.value = t11;
    }

    private final T get(SharedPreferences sharedPreferences) {
        T t11 = this.defaultValue;
        if (t11 instanceof String) {
            return sharedPreferences.getString(this.key, (String) t11);
        }
        if (t11 instanceof Float) {
            return Float.valueOf(sharedPreferences.getFloat(this.key, ((Number) t11).floatValue()));
        }
        if (t11 instanceof Integer) {
            return Integer.valueOf(sharedPreferences.getInt(this.key, ((Number) t11).intValue()));
        }
        if (t11 instanceof Long) {
            return Long.valueOf(sharedPreferences.getLong(this.key, ((Number) t11).longValue()));
        }
        if (t11 instanceof Boolean) {
            return Boolean.valueOf(sharedPreferences.getBoolean(this.key, ((Boolean) t11).booleanValue()));
        }
        throw new UnsupportedOperationException("can't persist non-primitive type");
    }

    private final SharedPreferences.Editor put(SharedPreferences.Editor editor, T t11) {
        if (t11 instanceof String) {
            editor.putString(this.key, (String) t11);
        } else if (t11 instanceof Float) {
            editor.putFloat(this.key, ((Number) t11).floatValue());
        } else if (t11 instanceof Integer) {
            editor.putInt(this.key, ((Number) t11).intValue());
        } else if (t11 instanceof Long) {
            editor.putLong(this.key, ((Number) t11).longValue());
        } else if (t11 instanceof Boolean) {
            editor.putBoolean(this.key, ((Boolean) t11).booleanValue());
        }
        return editor;
    }

    @Nullable
    public abstract SharedPreferences getPref();

    public T getValue(@Nullable Object obj, @NotNull KProperty<?> kProperty) {
        T t11;
        PreferencesProperty preferencesProperty;
        T t12;
        Intrinsics.checkNotNullParameter(kProperty, "property");
        synchronized (this) {
            t11 = null;
            if (this.firstLoad) {
                preferencesProperty = this;
            } else {
                preferencesProperty = null;
            }
            if (preferencesProperty != null) {
                this.firstLoad = false;
                SharedPreferences pref = getPref();
                if (pref == null) {
                    t12 = null;
                } else {
                    t12 = get(pref);
                }
                if (t12 == null) {
                    t12 = this.value;
                }
                if (t12 != null) {
                    this.value = t12;
                    t11 = t12;
                }
            }
            if (t11 == null) {
                t11 = this.value;
            }
        }
        return t11;
    }

    public void setValue(@Nullable Object obj, @NotNull KProperty<?> kProperty, T t11) {
        SharedPreferences.Editor edit;
        SharedPreferences.Editor put;
        Intrinsics.checkNotNullParameter(kProperty, "property");
        synchronized (this) {
            this.firstLoad = false;
            this.value = t11;
            Unit unit = Unit.INSTANCE;
        }
        SharedPreferences pref = getPref();
        if (pref != null && (edit = pref.edit()) != null && (put = put(edit, t11)) != null) {
            put.apply();
        }
    }
}
