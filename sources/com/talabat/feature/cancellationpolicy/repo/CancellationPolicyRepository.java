package com.talabat.feature.cancellationpolicy.repo;

import com.talabat.feature.cancellationpolicy.domain.model.CancellationPolicyData;
import com.talabat.feature.cancellationpolicy.domain.repo.ICancellationPolicyRepository;
import com.talabat.feature.cancellationpolicy.mapper.ICancellationPolicyMapper;
import com.talabat.feature.cancellationpolicy.remote.CancellationPolicyService;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineDispatcher;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B/\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\t¢\u0006\u0002\u0010\u000bJ\u0011\u0010\f\u001a\u00020\rH@ø\u0001\u0000¢\u0006\u0002\u0010\u000eR\u000e\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\tX\u0004¢\u0006\u0002\n\u0000\u0002\u0004\n\u0002\b\u0019¨\u0006\u000f"}, d2 = {"Lcom/talabat/feature/cancellationpolicy/repo/CancellationPolicyRepository;", "Lcom/talabat/feature/cancellationpolicy/domain/repo/ICancellationPolicyRepository;", "cancellationPolicyService", "Lcom/talabat/feature/cancellationpolicy/remote/CancellationPolicyService;", "cancellationPolicyMapper", "Lcom/talabat/feature/cancellationpolicy/mapper/ICancellationPolicyMapper;", "ioDispatcher", "Lkotlinx/coroutines/CoroutineDispatcher;", "countryId", "", "verticalType", "(Lcom/talabat/feature/cancellationpolicy/remote/CancellationPolicyService;Lcom/talabat/feature/cancellationpolicy/mapper/ICancellationPolicyMapper;Lkotlinx/coroutines/CoroutineDispatcher;Ljava/lang/String;Ljava/lang/String;)V", "getCancellationContent", "Lcom/talabat/feature/cancellationpolicy/domain/model/CancellationPolicyData;", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "com_talabat_feature_helpcenter_data_data"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class CancellationPolicyRepository implements ICancellationPolicyRepository {
    /* access modifiers changed from: private */
    @NotNull
    public final ICancellationPolicyMapper cancellationPolicyMapper;
    /* access modifiers changed from: private */
    @NotNull
    public final CancellationPolicyService cancellationPolicyService;
    /* access modifiers changed from: private */
    @NotNull
    public final String countryId;
    @NotNull
    private final CoroutineDispatcher ioDispatcher;
    /* access modifiers changed from: private */
    @NotNull
    public final String verticalType;

    @Inject
    public CancellationPolicyRepository(@NotNull CancellationPolicyService cancellationPolicyService2, @NotNull ICancellationPolicyMapper iCancellationPolicyMapper, @NotNull CoroutineDispatcher coroutineDispatcher, @NotNull String str, @NotNull String str2) {
        Intrinsics.checkNotNullParameter(cancellationPolicyService2, "cancellationPolicyService");
        Intrinsics.checkNotNullParameter(iCancellationPolicyMapper, "cancellationPolicyMapper");
        Intrinsics.checkNotNullParameter(coroutineDispatcher, "ioDispatcher");
        Intrinsics.checkNotNullParameter(str, "countryId");
        Intrinsics.checkNotNullParameter(str2, "verticalType");
        this.cancellationPolicyService = cancellationPolicyService2;
        this.cancellationPolicyMapper = iCancellationPolicyMapper;
        this.ioDispatcher = coroutineDispatcher;
        this.countryId = str;
        this.verticalType = str2;
    }

    @Nullable
    public Object getCancellationContent(@NotNull Continuation<? super CancellationPolicyData> continuation) {
        return BuildersKt.withContext(this.ioDispatcher, new CancellationPolicyRepository$getCancellationContent$2(this, (Continuation<? super CancellationPolicyRepository$getCancellationContent$2>) null), continuation);
    }
}
