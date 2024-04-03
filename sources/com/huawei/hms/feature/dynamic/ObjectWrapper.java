package com.huawei.hms.feature.dynamic;

import android.os.IBinder;
import com.huawei.hms.feature.dynamic.IObjectWrapper;
import java.lang.reflect.Field;

public class ObjectWrapper<T> extends IObjectWrapper.Stub {

    /* renamed from: a  reason: collision with root package name */
    private final T f48753a;

    private ObjectWrapper(T t11) {
        this.f48753a = t11;
    }

    public static <T> T unwrap(IObjectWrapper iObjectWrapper) {
        if (iObjectWrapper instanceof ObjectWrapper) {
            return ((ObjectWrapper) iObjectWrapper).f48753a;
        }
        IBinder asBinder = iObjectWrapper.asBinder();
        Field[] declaredFields = asBinder.getClass().getDeclaredFields();
        int i11 = 0;
        for (Field isSynthetic : declaredFields) {
            if (!isSynthetic.isSynthetic()) {
                i11++;
            }
        }
        if (i11 != 1) {
            throw new IllegalArgumentException("Got " + declaredFields.length + " fields, The number of field number should be 1.");
        } else if (!declaredFields[0].isAccessible()) {
            declaredFields[0].setAccessible(true);
            try {
                return declaredFields[0].get(asBinder);
            } catch (Exception unused) {
                throw new IllegalArgumentException("Get binder failed: null or not permitted.");
            }
        } else {
            throw new IllegalArgumentException("The field is accessible.");
        }
    }

    public static <T> IObjectWrapper wrap(T t11) {
        return new ObjectWrapper(t11);
    }
}
