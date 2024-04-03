package com.talabat.gem.domain.usecases;

import com.talabat.gem.domain.entities.GemOffer;
import com.talabat.gem.ports.presentation.GemCounterViewPort;
import com.talabat.talabatcommon.extentions.RxKt;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\u0018\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012&\u0010\u0002\u001a\"\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0005 \u0006*\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0007"}, d2 = {"<anonymous>", "", "pair", "Lkotlin/Pair;", "Lcom/talabat/gem/domain/entities/GemOffer;", "", "kotlin.jvm.PlatformType", "invoke"}, k = 3, mv = {1, 6, 0}, xi = 48)
public final class GemCounterBusinessRulesKt$countdownTimerSubscription$6 extends Lambda implements Function1<Pair<? extends GemOffer, ? extends String>, Unit> {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ GemCounterViewPort f60385g;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public GemCounterBusinessRulesKt$countdownTimerSubscription$6(GemCounterViewPort gemCounterViewPort) {
        super(1);
        this.f60385g = gemCounterViewPort;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((Pair<GemOffer, String>) (Pair) obj);
        return Unit.INSTANCE;
    }

    public final void invoke(Pair<GemOffer, String> pair) {
        if (Intrinsics.areEqual((Object) pair.getSecond(), (Object) "00:00") || Intrinsics.areEqual(RxKt.invoke(this.f60385g.getCounterExpired()), (Object) Boolean.TRUE)) {
            GemCounterBusinessRulesKt.hideAndExpire(this.f60385g, pair.getFirst());
        } else {
            GemCounterBusinessRulesKt.showAndUpdateCounter(this.f60385g, pair.getSecond());
        }
    }
}
