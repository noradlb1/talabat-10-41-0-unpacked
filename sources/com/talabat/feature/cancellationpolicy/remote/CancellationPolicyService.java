package com.talabat.feature.cancellationpolicy.remote;

import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u000f\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0001¢\u0006\u0002\u0010\u0003J!\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u0007H@ø\u0001\u0000¢\u0006\u0002\u0010\tR\u000e\u0010\u0002\u001a\u00020\u0001X\u0004¢\u0006\u0002\n\u0000\u0002\u0004\n\u0002\b\u0019¨\u0006\n"}, d2 = {"Lcom/talabat/feature/cancellationpolicy/remote/CancellationPolicyService;", "Lcom/talabat/feature/cancellationpolicy/remote/CancellationPolicyApi;", "api", "(Lcom/talabat/feature/cancellationpolicy/remote/CancellationPolicyApi;)V", "getCancellationPolicyContent", "Lcom/talabat/feature/cancellationpolicy/remote/CancellationPolicyResponse;", "countryId", "", "verticalId", "(Ljava/lang/String;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "com_talabat_feature_helpcenter_data_data"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class CancellationPolicyService implements CancellationPolicyApi {
    @NotNull
    private final CancellationPolicyApi api;

    @Inject
    public CancellationPolicyService(@NotNull CancellationPolicyApi cancellationPolicyApi) {
        Intrinsics.checkNotNullParameter(cancellationPolicyApi, "api");
        this.api = cancellationPolicyApi;
    }

    @Nullable
    public Object getCancellationPolicyContent(@NotNull String str, @NotNull String str2, @NotNull Continuation<? super CancellationPolicyResponse> continuation) {
        return this.api.getCancellationPolicyContent(str, str2, continuation);
    }
}
