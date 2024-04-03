package com.talabat.mapper;

import io.reactivex.Single;
import io.reactivex.functions.Function;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import rs.b;

class MappingInitializer implements Function<Field, Mapping> {
    /* access modifiers changed from: private */
    public static /* synthetic */ ModelMapper lambda$apply$2(Constructor constructor) throws Exception {
        return (ModelMapper) constructor.newInstance(new Object[0]);
    }

    /* access modifiers changed from: private */
    public static /* synthetic */ Mapping lambda$apply$3(Field field, ModelMapping modelMapping, ModelMapper modelMapper) throws Exception {
        return new Mapping(field, modelMapping.value(), modelMapping.acceptNulls(), modelMapper);
    }

    public Mapping apply(Field field) throws Exception {
        ModelMapping modelMapping = (ModelMapping) field.getAnnotation(ModelMapping.class);
        return (Mapping) Single.just(modelMapping).map(new b()).map(new a()).doOnSuccess(new b()).map(new c()).cast(ModelMapper.class).map(new d(field, modelMapping)).blockingGet();
    }
}
