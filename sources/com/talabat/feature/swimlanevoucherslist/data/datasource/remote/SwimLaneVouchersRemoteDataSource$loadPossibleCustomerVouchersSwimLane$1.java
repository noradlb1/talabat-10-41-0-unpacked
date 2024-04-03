package com.talabat.feature.swimlanevoucherslist.data.datasource.remote;

import com.talabat.features.swimlanevoucherslist.domain.model.VouchersSwimLaneRequest;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
@DebugMetadata(c = "com.talabat.feature.swimlanevoucherslist.data.datasource.remote.SwimLaneVouchersRemoteDataSource", f = "SwimLaneVouchersRemoteDataSource.kt", i = {}, l = {17}, m = "loadPossibleCustomerVouchersSwimLane", n = {}, s = {})
public final class SwimLaneVouchersRemoteDataSource$loadPossibleCustomerVouchersSwimLane$1 extends ContinuationImpl {

    /* renamed from: h  reason: collision with root package name */
    public /* synthetic */ Object f59014h;

    /* renamed from: i  reason: collision with root package name */
    public final /* synthetic */ SwimLaneVouchersRemoteDataSource f59015i;

    /* renamed from: j  reason: collision with root package name */
    public int f59016j;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public SwimLaneVouchersRemoteDataSource$loadPossibleCustomerVouchersSwimLane$1(SwimLaneVouchersRemoteDataSource swimLaneVouchersRemoteDataSource, Continuation<? super SwimLaneVouchersRemoteDataSource$loadPossibleCustomerVouchersSwimLane$1> continuation) {
        super(continuation);
        this.f59015i = swimLaneVouchersRemoteDataSource;
    }

    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        this.f59014h = obj;
        this.f59016j |= Integer.MIN_VALUE;
        return this.f59015i.loadPossibleCustomerVouchersSwimLane((VouchersSwimLaneRequest) null, this);
    }
}
