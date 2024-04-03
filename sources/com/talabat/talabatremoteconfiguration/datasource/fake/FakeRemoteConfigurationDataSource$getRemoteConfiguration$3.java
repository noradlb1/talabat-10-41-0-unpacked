package com.talabat.talabatremoteconfiguration.datasource.fake;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u00022\u0006\u0010\u0003\u001a\u00020\u0004H\n¢\u0006\u0002\b\u0005"}, d2 = {"<anonymous>", "", "T", "it", "", "invoke"}, k = 3, mv = {1, 6, 0}, xi = 48)
public final class FakeRemoteConfigurationDataSource$getRemoteConfiguration$3 extends Lambda implements Function1<Object, Unit> {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ Function1<T, Unit> f12124g;

    /* renamed from: h  reason: collision with root package name */
    public final /* synthetic */ FakeRemoteConfigurationDataSource f12125h;

    /* renamed from: i  reason: collision with root package name */
    public final /* synthetic */ T f12126i;

    /* renamed from: j  reason: collision with root package name */
    public final /* synthetic */ Class<T> f12127j;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public FakeRemoteConfigurationDataSource$getRemoteConfiguration$3(Function1<? super T, Unit> function1, FakeRemoteConfigurationDataSource fakeRemoteConfigurationDataSource, T t11, Class<T> cls) {
        super(1);
        this.f12124g = function1;
        this.f12125h = fakeRemoteConfigurationDataSource;
        this.f12126i = t11;
        this.f12127j = cls;
    }

    public final void invoke(@NotNull Object obj) {
        Intrinsics.checkNotNullParameter(obj, "it");
        this.f12124g.invoke(this.f12125h.getParser().getTheVariationValue(obj, this.f12126i, this.f12127j));
    }
}
