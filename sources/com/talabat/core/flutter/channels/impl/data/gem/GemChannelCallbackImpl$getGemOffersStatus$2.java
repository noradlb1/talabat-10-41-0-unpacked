package com.talabat.core.flutter.channels.impl.data.gem;

import com.talabat.gem.domain.entities.GemOffer;
import io.flutter.plugin.common.MethodChannel;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, d2 = {"<anonymous>", "", "it", "Lcom/talabat/gem/domain/entities/GemOffer;", "kotlin.jvm.PlatformType", "invoke"}, k = 3, mv = {1, 6, 0}, xi = 48)
public final class GemChannelCallbackImpl$getGemOffersStatus$2 extends Lambda implements Function1<GemOffer, Unit> {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ GemChannelCallbackImpl f55917g;

    /* renamed from: h  reason: collision with root package name */
    public final /* synthetic */ MethodChannel.Result f55918h;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public GemChannelCallbackImpl$getGemOffersStatus$2(GemChannelCallbackImpl gemChannelCallbackImpl, MethodChannel.Result result) {
        super(1);
        this.f55917g = gemChannelCallbackImpl;
        this.f55918h = result;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((GemOffer) obj);
        return Unit.INSTANCE;
    }

    public final void invoke(GemOffer gemOffer) {
        this.f55917g.canMakeRequestForGemOffersStatus = true;
        this.f55918h.success(Boolean.valueOf(this.f55917g.isGemOffersActive()));
    }
}
