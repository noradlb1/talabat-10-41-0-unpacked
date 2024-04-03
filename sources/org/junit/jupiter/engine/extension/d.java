package org.junit.jupiter.engine.extension;

import j$.util.function.IntFunction;

public final /* synthetic */ class d implements IntFunction {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ int f62589a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ RepeatedTestDisplayNameFormatter f62590b;

    public /* synthetic */ d(int i11, RepeatedTestDisplayNameFormatter repeatedTestDisplayNameFormatter) {
        this.f62589a = i11;
        this.f62590b = repeatedTestDisplayNameFormatter;
    }

    public final Object apply(int i11) {
        return RepeatedTestExtension.lambda$provideTestTemplateInvocationContexts$0(this.f62589a, this.f62590b, i11);
    }
}
