package com.talabat.core.flutter.channels.impl.data.gem;

import com.talabat.gem.domain.entities.GemOffer;
import com.talabat.gem.domain.usecases.BusinessRulesKt;
import io.flutter.plugin.common.MethodChannel;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "", "gemOffer", "Lcom/talabat/gem/domain/entities/GemOffer;", "invoke"}, k = 3, mv = {1, 6, 0}, xi = 48)
public final class GemChannelCallbackImpl$requestGemOfferForHome$1 extends Lambda implements Function1<GemOffer, Unit> {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ GemChannelCallbackImpl f55921g;

    /* renamed from: h  reason: collision with root package name */
    public final /* synthetic */ MethodChannel.Result f55922h;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public GemChannelCallbackImpl$requestGemOfferForHome$1(GemChannelCallbackImpl gemChannelCallbackImpl, MethodChannel.Result result) {
        super(1);
        this.f55921g = gemChannelCallbackImpl;
        this.f55922h = result;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((GemOffer) obj);
        return Unit.INSTANCE;
    }

    public final void invoke(@NotNull GemOffer gemOffer) {
        Intrinsics.checkNotNullParameter(gemOffer, "gemOffer");
        this.f55921g.canMakeRequestForGemHome = true;
        if (BusinessRulesKt.isExpired$default(gemOffer, 0, 1, (Object) null)) {
            this.f55922h.success((Object) null);
            return;
        }
        this.f55922h.success(MapsKt__MapsKt.mapOf(TuplesKt.to("remainingTimeInSeconds", BusinessRulesKt.calculateGemRemainingSeconds$default((Long) null, 1, (Object) null)), TuplesKt.to("titleMessage", gemOffer.getCollectionTitle()), TuplesKt.to("subtitleMessage", gemOffer.getBrandingMessage())));
    }
}
