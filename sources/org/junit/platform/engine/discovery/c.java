package org.junit.platform.engine.discovery;

import j$.util.function.Function;
import java.util.regex.Pattern;

public final /* synthetic */ class c implements Function {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ ExcludeClassNameFilter f28027a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ String f28028b;

    public /* synthetic */ c(ExcludeClassNameFilter excludeClassNameFilter, String str) {
        this.f28027a = excludeClassNameFilter;
        this.f28028b = str;
    }

    public /* synthetic */ Function andThen(Function function) {
        return Function.CC.$default$andThen(this, function);
    }

    public final Object apply(Object obj) {
        return this.f28027a.lambda$apply$0(this.f28028b, (Pattern) obj);
    }

    public /* synthetic */ Function compose(Function function) {
        return Function.CC.$default$compose(this, function);
    }
}
