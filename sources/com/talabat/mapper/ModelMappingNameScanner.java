package com.talabat.mapper;

import com.google.gson.annotations.SerializedName;
import io.reactivex.Observable;
import io.reactivex.functions.Function;
import java.lang.reflect.Field;
import java.util.Map;
import org.jetbrains.annotations.NotNull;

class ModelMappingNameScanner implements Function<Object, Map> {

    public static class FieldData {

        /* renamed from: name  reason: collision with root package name */
        private final String f61064name;
        private final Object value;

        public FieldData(String str, Object obj) {
            this.f61064name = str;
            this.value = obj;
        }

        public String a() {
            return this.f61064name;
        }

        public Object b() {
            return this.value;
        }
    }

    /* access modifiers changed from: private */
    @NotNull
    public static FieldData toFieldData(Object obj, Field field) throws IllegalAccessException {
        return new FieldData(((SerializedName) field.getAnnotation(SerializedName.class)).value(), field.get(obj));
    }

    public Map apply(Object obj) {
        return (Map) Observable.fromArray(obj.getClass().getDeclaredFields()).filter(new g()).doOnNext(new h()).map(new i(obj)).toMap(new j(), new k()).blockingGet();
    }
}
