package com.apptimize;

import java.lang.Enum;
import java.util.HashMap;
import org.json.JSONException;

public class jd<T extends Enum<?>> implements jj<Number, T> {

    /* renamed from: a  reason: collision with root package name */
    private Class<T> f43110a;

    /* renamed from: b  reason: collision with root package name */
    private HashMap<Integer, T> f43111b = new HashMap<>();

    public jd(Class<T> cls) {
        this.f43110a = cls;
        for (Enum enumR : (Enum[]) cls.getEnumConstants()) {
            this.f43111b.put(Integer.valueOf(enumR.ordinal()), enumR);
        }
    }

    /* renamed from: a */
    public Number b(T t11) {
        if (t11 == null) {
            return Integer.MAX_VALUE;
        }
        return Integer.valueOf(t11.ordinal());
    }

    public Class<T> b() {
        return this.f43110a;
    }

    public T a(Number number) throws JSONException {
        if (number.equals(Integer.MAX_VALUE)) {
            return null;
        }
        if (this.f43111b.containsKey(Integer.valueOf(number.intValue()))) {
            return (Enum) this.f43111b.get(Integer.valueOf(number.intValue()));
        }
        throw new JSONException(String.format("Enum %s does not contain value %d", new Object[]{this.f43110a, Integer.valueOf(number.intValue())}));
    }

    public Class<Number> a() {
        return Number.class;
    }
}
