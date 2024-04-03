package org.junit.jupiter.engine.descriptor;

import j$.util.function.Function;
import java.lang.reflect.Parameter;
import java.util.concurrent.atomic.AtomicInteger;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.platform.commons.util.AnnotationUtils;

public final /* synthetic */ class q implements Function {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ AtomicInteger f62472a;

    public /* synthetic */ q(AtomicInteger atomicInteger) {
        this.f62472a = atomicInteger;
    }

    public /* synthetic */ Function andThen(Function function) {
        return Function.CC.$default$andThen(this, function);
    }

    public final Object apply(Object obj) {
        return AnnotationUtils.findRepeatableAnnotations((Parameter) obj, this.f62472a.getAndIncrement(), ExtendWith.class);
    }

    public /* synthetic */ Function compose(Function function) {
        return Function.CC.$default$compose(this, function);
    }
}
