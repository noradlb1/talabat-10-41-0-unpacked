package com.talabat.mapper;

import io.reactivex.Observable;
import io.reactivex.functions.Function3;
import java.io.PrintStream;
import java.util.Map;
import rs.c;

class MappingInjector implements Function3<Object, Mapping, Map<Object, Object>, Object> {
    private MappedValues mappedValues(Mapping mapping, Map<Object, Object> map) {
        return (MappedValues) Observable.just(map).flatMapIterable(new e()).filter(new f(mapping)).toList().map(new c()).blockingGet();
    }

    private void updateField(Object obj, Mapping mapping, Map<Object, Object> map) throws Exception {
        MappedValues mappedValues = mappedValues(mapping, map);
        boolean c11 = mappedValues.c();
        Object obj2 = mappedValues;
        if (c11) {
            obj2 = mappedValues.b();
        }
        Object apply = mapping.f61063d.apply(obj2);
        if (mapping.f61062c || apply != null) {
            mapping.f61060a.set(obj, apply);
            return;
        }
        PrintStream printStream = System.out;
        printStream.println("ModelMapping | null value found after mapping @ " + obj2);
    }

    public Object apply(Object obj, Mapping mapping, Map<Object, Object> map) {
        try {
            updateField(obj, mapping, map);
        } catch (Throwable unused) {
        }
        return obj;
    }
}
