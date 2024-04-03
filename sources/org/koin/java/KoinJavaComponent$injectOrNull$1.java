package org.koin.java;

import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.Nullable;
import org.koin.core.parameter.ParametersHolder;
import org.koin.core.qualifier.Qualifier;

@Metadata(d1 = {"\u0000\u0004\n\u0002\b\u0002\u0010\u0001\u001a\u0004\u0018\u00018\u0000\"\u0004\b\u0000\u0010\u0000H\n"}, d2 = {"T", "<anonymous>"}, k = 3, mv = {1, 5, 1})
public final class KoinJavaComponent$injectOrNull$1 extends Lambda implements Function0<T> {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ Class<?> f62767g;

    /* renamed from: h  reason: collision with root package name */
    public final /* synthetic */ Qualifier f62768h;

    /* renamed from: i  reason: collision with root package name */
    public final /* synthetic */ Function0<ParametersHolder> f62769i;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public KoinJavaComponent$injectOrNull$1(Class<?> cls, Qualifier qualifier, Function0<? extends ParametersHolder> function0) {
        super(0);
        this.f62767g = cls;
        this.f62768h = qualifier;
        this.f62769i = function0;
    }

    @Nullable
    public final T invoke() {
        return KoinJavaComponent.getOrNull(this.f62767g, this.f62768h, this.f62769i);
    }
}
