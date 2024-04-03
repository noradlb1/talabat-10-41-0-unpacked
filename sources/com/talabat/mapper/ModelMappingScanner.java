package com.talabat.mapper;

import io.reactivex.Observable;
import io.reactivex.functions.BiConsumer;
import io.reactivex.functions.Function;
import io.reactivex.functions.Function3;
import java.lang.reflect.Field;
import java.util.Map;
import rs.d;

class ModelMappingScanner implements BiConsumer<Object, Map> {
    private final Function<Field, Mapping> mappingInitializer = new MappingInitializer();
    private final Function3<Object, Mapping, Map<Object, Object>, Object> mappingInjector = new MappingInjector();

    /* access modifiers changed from: private */
    public /* synthetic */ Object lambda$accept$2(Object obj, Map map, Mapping mapping) throws Exception {
        return this.mappingInjector.apply(obj, mapping, map);
    }

    public void accept(Object obj, Map map) {
        Observable.fromArray(obj.getClass().getDeclaredFields()).filter(new l()).doOnNext(new m()).map(this.mappingInitializer).map(new n(this, obj, map)).ignoreElements().doOnError(new d()).onErrorComplete().blockingAwait();
    }
}
