package org.junit.platform.engine.discovery;

import j$.util.function.Function;
import java.util.regex.Pattern;

public final /* synthetic */ class k implements Function {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ IncludeClassNameFilter f28039a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ String f28040b;

    public /* synthetic */ k(IncludeClassNameFilter includeClassNameFilter, String str) {
        this.f28039a = includeClassNameFilter;
        this.f28040b = str;
    }

    public /* synthetic */ Function andThen(Function function) {
        return Function.CC.$default$andThen(this, function);
    }

    public final Object apply(Object obj) {
        return this.f28039a.lambda$apply$0(this.f28040b, (Pattern) obj);
    }

    public /* synthetic */ Function compose(Function function) {
        return Function.CC.$default$compose(this, function);
    }
}
