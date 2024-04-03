package com.checkout.threedsecure;

import com.checkout.threedsecure.model.ThreeDSRequest;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003H\n¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"<anonymous>", "", "it", "", "invoke", "(Ljava/lang/String;)Ljava/lang/Boolean;"}, k = 3, mv = {1, 7, 1}, xi = 48)
public final class ThreeDSExecutor$provideWebView$1$1$1 extends Lambda implements Function1<String, Boolean> {
    final /* synthetic */ ThreeDSRequest $this_with;
    final /* synthetic */ ThreeDSExecutor this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public ThreeDSExecutor$provideWebView$1$1$1(ThreeDSExecutor threeDSExecutor, ThreeDSRequest threeDSRequest) {
        super(1);
        this.this$0 = threeDSExecutor;
        this.$this_with = threeDSRequest;
    }

    @NotNull
    public final Boolean invoke(@Nullable String str) {
        return Boolean.valueOf(this.this$0.handleResult(str, this.$this_with.getSuccessUrl(), this.$this_with.getFailureUrl(), this.$this_with.getResultHandler()));
    }
}
