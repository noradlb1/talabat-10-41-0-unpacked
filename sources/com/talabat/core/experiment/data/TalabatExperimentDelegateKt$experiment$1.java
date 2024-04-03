package com.talabat.core.experiment.data;

import com.talabat.core.fwfprojectskeys.domain.FWFKey;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "", "T", "Lcom/talabat/core/experiment/data/ExperimentDelegateBuilder;", "invoke"}, k = 3, mv = {1, 6, 0}, xi = 48)
public final class TalabatExperimentDelegateKt$experiment$1 extends Lambda implements Function1<ExperimentDelegateBuilder<T>, Unit> {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ FWFKey f55848g;

    /* renamed from: h  reason: collision with root package name */
    public final /* synthetic */ T f55849h;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public TalabatExperimentDelegateKt$experiment$1(FWFKey fWFKey, T t11) {
        super(1);
        this.f55848g = fWFKey;
        this.f55849h = t11;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((ExperimentDelegateBuilder) obj);
        return Unit.INSTANCE;
    }

    public final void invoke(@NotNull ExperimentDelegateBuilder<T> experimentDelegateBuilder) {
        Intrinsics.checkNotNullParameter(experimentDelegateBuilder, "$this$experiment");
        experimentDelegateBuilder.getWith().name(this.f55848g);
        experimentDelegateBuilder.getWith().defaultValue(this.f55849h);
    }
}
