package org.koin.core.scope;

import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;
import kotlin.reflect.KClass;
import org.koin.core.parameter.ParametersHolder;
import org.koin.core.qualifier.Qualifier;

@Metadata(d1 = {"\u0000\u0004\n\u0002\b\u0002\u0010\u0001\u001a\u00028\u0000\"\u0004\b\u0000\u0010\u0000H\n"}, d2 = {"T", "<anonymous>"}, k = 3, mv = {1, 5, 1})
public final class Scope$get$1 extends Lambda implements Function0<T> {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ Scope f62747g;

    /* renamed from: h  reason: collision with root package name */
    public final /* synthetic */ Qualifier f62748h;

    /* renamed from: i  reason: collision with root package name */
    public final /* synthetic */ KClass<?> f62749i;

    /* renamed from: j  reason: collision with root package name */
    public final /* synthetic */ Function0<ParametersHolder> f62750j;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public Scope$get$1(Scope scope, Qualifier qualifier, KClass<?> kClass, Function0<? extends ParametersHolder> function0) {
        super(0);
        this.f62747g = scope;
        this.f62748h = qualifier;
        this.f62749i = kClass;
        this.f62750j = function0;
    }

    public final T invoke() {
        return this.f62747g.resolveInstance(this.f62748h, this.f62749i, this.f62750j);
    }
}
