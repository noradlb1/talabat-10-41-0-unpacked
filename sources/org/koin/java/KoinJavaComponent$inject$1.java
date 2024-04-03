package org.koin.java;

import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;
import org.koin.core.parameter.ParametersHolder;
import org.koin.core.qualifier.Qualifier;

@Metadata(d1 = {"\u0000\u0004\n\u0002\b\u0002\u0010\u0001\u001a\u00028\u0000\"\u0004\b\u0000\u0010\u0000H\n"}, d2 = {"T", "<anonymous>"}, k = 3, mv = {1, 5, 1})
public final class KoinJavaComponent$inject$1 extends Lambda implements Function0<T> {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ Class<?> f62764g;

    /* renamed from: h  reason: collision with root package name */
    public final /* synthetic */ Qualifier f62765h;

    /* renamed from: i  reason: collision with root package name */
    public final /* synthetic */ Function0<ParametersHolder> f62766i;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public KoinJavaComponent$inject$1(Class<?> cls, Qualifier qualifier, Function0<? extends ParametersHolder> function0) {
        super(0);
        this.f62764g = cls;
        this.f62765h = qualifier;
        this.f62766i = function0;
    }

    public final T invoke() {
        return KoinJavaComponent.get(this.f62764g, this.f62765h, this.f62766i);
    }
}
