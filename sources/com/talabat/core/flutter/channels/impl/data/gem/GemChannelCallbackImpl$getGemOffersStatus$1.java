package com.talabat.core.flutter.channels.impl.data.gem;

import io.flutter.plugin.common.MethodChannel;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0003\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "", "it", "", "invoke"}, k = 3, mv = {1, 6, 0}, xi = 48)
public final class GemChannelCallbackImpl$getGemOffersStatus$1 extends Lambda implements Function1<Throwable, Unit> {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ GemChannelCallbackImpl f55915g;

    /* renamed from: h  reason: collision with root package name */
    public final /* synthetic */ MethodChannel.Result f55916h;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public GemChannelCallbackImpl$getGemOffersStatus$1(GemChannelCallbackImpl gemChannelCallbackImpl, MethodChannel.Result result) {
        super(1);
        this.f55915g = gemChannelCallbackImpl;
        this.f55916h = result;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((Throwable) obj);
        return Unit.INSTANCE;
    }

    public final void invoke(@NotNull Throwable th2) {
        Intrinsics.checkNotNullParameter(th2, "it");
        this.f55915g.canMakeRequestForGemOffersStatus = true;
        this.f55916h.success(Boolean.FALSE);
    }
}
