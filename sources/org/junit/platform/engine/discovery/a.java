package org.junit.platform.engine.discovery;

import j$.util.function.Predicate;
import java.util.regex.Pattern;

public final /* synthetic */ class a implements Predicate {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ String f28026a;

    public /* synthetic */ a(String str) {
        this.f28026a = str;
    }

    public /* synthetic */ Predicate and(Predicate predicate) {
        return Predicate.CC.$default$and(this, predicate);
    }

    public /* synthetic */ Predicate negate() {
        return Predicate.CC.$default$negate(this);
    }

    public /* synthetic */ Predicate or(Predicate predicate) {
        return Predicate.CC.$default$or(this, predicate);
    }

    public final boolean test(Object obj) {
        return ((Pattern) obj).matcher(this.f28026a).matches();
    }
}
