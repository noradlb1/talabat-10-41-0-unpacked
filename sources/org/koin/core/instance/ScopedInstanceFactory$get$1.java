package org.koin.core.instance;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0002\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0000H\n"}, d2 = {"T", "", "<anonymous>"}, k = 3, mv = {1, 5, 1})
public final class ScopedInstanceFactory$get$1 extends Lambda implements Function0<Unit> {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ ScopedInstanceFactory<T> f62730g;

    /* renamed from: h  reason: collision with root package name */
    public final /* synthetic */ InstanceContext f62731h;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public ScopedInstanceFactory$get$1(ScopedInstanceFactory<T> scopedInstanceFactory, InstanceContext instanceContext) {
        super(0);
        this.f62730g = scopedInstanceFactory;
        this.f62731h = instanceContext;
    }

    public final void invoke() {
        if (!this.f62730g.isCreated(this.f62731h)) {
            this.f62730g.values.put(this.f62731h.getScope().getId(), this.f62730g.create(this.f62731h));
        }
    }
}
