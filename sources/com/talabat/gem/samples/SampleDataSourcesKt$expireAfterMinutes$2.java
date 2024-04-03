package com.talabat.gem.samples;

import gateways.PreferencesInterceptors;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0006\n\u0000\u0010\u0000\u001a\u00020\u0001*\b\u0012\u0004\u0012\u00020\u00030\u0002H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "", "Lgateways/PreferencesInterceptors;", "", "invoke"}, k = 3, mv = {1, 6, 0}, xi = 48)
public final class SampleDataSourcesKt$expireAfterMinutes$2 extends Lambda implements Function1<PreferencesInterceptors<Double>, Unit> {
    public static final SampleDataSourcesKt$expireAfterMinutes$2 INSTANCE = new SampleDataSourcesKt$expireAfterMinutes$2();

    public SampleDataSourcesKt$expireAfterMinutes$2() {
        super(1);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((PreferencesInterceptors<Double>) (PreferencesInterceptors) obj);
        return Unit.INSTANCE;
    }

    public final void invoke(@NotNull PreferencesInterceptors<Double> preferencesInterceptors) {
        Intrinsics.checkNotNullParameter(preferencesInterceptors, "$this$preferences");
        preferencesInterceptors.getOn().saved(AnonymousClass1.INSTANCE);
    }
}
