package com.talabat.core.experiment.data.datasource;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "", "it", "", "invoke"}, k = 3, mv = {1, 6, 0}, xi = 48)
public final class FwfExperimentDataSource$getStringVariant$1 extends Lambda implements Function1<Object, Unit> {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ Function1<String, Unit> f55859g;

    /* renamed from: h  reason: collision with root package name */
    public final /* synthetic */ String f55860h;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public FwfExperimentDataSource$getStringVariant$1(Function1<? super String, Unit> function1, String str) {
        super(1);
        this.f55859g = function1;
        this.f55860h = str;
    }

    public final void invoke(@NotNull Object obj) {
        Intrinsics.checkNotNullParameter(obj, "it");
        Function1<String, Unit> function1 = this.f55859g;
        String str = obj instanceof String ? (String) obj : null;
        if (str == null) {
            str = this.f55860h;
        }
        function1.invoke(str);
    }
}
