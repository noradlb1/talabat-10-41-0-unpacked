package org.junit.platform.engine.discovery;

import j$.util.function.Function;

public final /* synthetic */ class o implements Function {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ IncludePackageNameFilter f28045a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ String f28046b;

    public /* synthetic */ o(IncludePackageNameFilter includePackageNameFilter, String str) {
        this.f28045a = includePackageNameFilter;
        this.f28046b = str;
    }

    public /* synthetic */ Function andThen(Function function) {
        return Function.CC.$default$andThen(this, function);
    }

    public final Object apply(Object obj) {
        return this.f28045a.lambda$apply$0(this.f28046b, (String) obj);
    }

    public /* synthetic */ Function compose(Function function) {
        return Function.CC.$default$compose(this, function);
    }
}
