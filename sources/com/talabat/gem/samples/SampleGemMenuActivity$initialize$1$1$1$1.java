package com.talabat.gem.samples;

import com.talabat.gem.adapters.presentation.GemMenuFooterConfigurations;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n¢\u0006\u0002\b\u0003"}, d2 = {"<anonymous>", "", "Lcom/talabat/gem/adapters/presentation/GemMenuFooterConfigurations;", "invoke"}, k = 3, mv = {1, 6, 0}, xi = 48)
public final class SampleGemMenuActivity$initialize$1$1$1$1 extends Lambda implements Function1<GemMenuFooterConfigurations, Unit> {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ SampleGemMenuActivity f60523g;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public SampleGemMenuActivity$initialize$1$1$1$1(SampleGemMenuActivity sampleGemMenuActivity) {
        super(1);
        this.f60523g = sampleGemMenuActivity;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((GemMenuFooterConfigurations) obj);
        return Unit.INSTANCE;
    }

    public final void invoke(@NotNull GemMenuFooterConfigurations gemMenuFooterConfigurations) {
        Intrinsics.checkNotNullParameter(gemMenuFooterConfigurations, "$this$invoke");
        gemMenuFooterConfigurations.getWith().subTotal(Double.valueOf(this.f60523g.calculatedSubTotal));
    }
}
