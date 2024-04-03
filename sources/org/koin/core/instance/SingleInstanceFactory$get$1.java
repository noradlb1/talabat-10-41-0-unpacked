package org.koin.core.instance;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0002\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0000H\n"}, d2 = {"T", "", "<anonymous>"}, k = 3, mv = {1, 5, 1})
public final class SingleInstanceFactory$get$1 extends Lambda implements Function0<Unit> {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ SingleInstanceFactory<T> f62732g;

    /* renamed from: h  reason: collision with root package name */
    public final /* synthetic */ InstanceContext f62733h;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public SingleInstanceFactory$get$1(SingleInstanceFactory<T> singleInstanceFactory, InstanceContext instanceContext) {
        super(0);
        this.f62732g = singleInstanceFactory;
        this.f62733h = instanceContext;
    }

    public final void invoke() {
        if (!this.f62732g.isCreated(this.f62733h)) {
            SingleInstanceFactory<T> singleInstanceFactory = this.f62732g;
            singleInstanceFactory.value = singleInstanceFactory.create(this.f62733h);
        }
    }
}
