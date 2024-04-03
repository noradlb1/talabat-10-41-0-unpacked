package org.junit.platform.engine.discovery;

import j$.util.function.Function;

public final /* synthetic */ class g implements Function {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ ExcludePackageNameFilter f28033a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ String f28034b;

    public /* synthetic */ g(ExcludePackageNameFilter excludePackageNameFilter, String str) {
        this.f28033a = excludePackageNameFilter;
        this.f28034b = str;
    }

    public /* synthetic */ Function andThen(Function function) {
        return Function.CC.$default$andThen(this, function);
    }

    public final Object apply(Object obj) {
        return this.f28033a.lambda$apply$0(this.f28034b, (String) obj);
    }

    public /* synthetic */ Function compose(Function function) {
        return Function.CC.$default$compose(this, function);
    }
}
