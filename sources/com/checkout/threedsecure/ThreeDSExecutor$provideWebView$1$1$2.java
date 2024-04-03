package com.checkout.threedsecure;

import com.checkout.threedsecure.error.ThreeDSError;
import com.checkout.threedsecure.model.ThreeDSRequest;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "", "it", "Lcom/checkout/threedsecure/error/ThreeDSError;", "invoke"}, k = 3, mv = {1, 7, 1}, xi = 48)
public final class ThreeDSExecutor$provideWebView$1$1$2 extends Lambda implements Function1<ThreeDSError, Unit> {
    final /* synthetic */ ThreeDSRequest $this_with;
    final /* synthetic */ ThreeDSExecutor this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public ThreeDSExecutor$provideWebView$1$1$2(ThreeDSExecutor threeDSExecutor, ThreeDSRequest threeDSRequest) {
        super(1);
        this.this$0 = threeDSExecutor;
        this.$this_with = threeDSRequest;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((ThreeDSError) obj);
        return Unit.INSTANCE;
    }

    public final void invoke(@NotNull ThreeDSError threeDSError) {
        Intrinsics.checkNotNullParameter(threeDSError, "it");
        this.this$0.handleError(threeDSError, this.$this_with.getResultHandler());
    }
}
