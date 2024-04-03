package com.talabat.talabatlife.features.waitList.network;

import com.talabat.core.network.network.TalabatAPIBuilder;
import com.talabat.talabatlife.features.waitList.model.UserWaitListRootResponse;
import kotlin.Lazy;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import retrofit2.Call;

@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u001e\u0010\n\u001a\b\u0012\u0004\u0012\u00020\f0\u000b2\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u000eH\u0016J\u001e\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\f0\u000b2\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u000eH\u0016R\u001b\u0010\u0005\u001a\u00020\u00018BX\u0002¢\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0011"}, d2 = {"Lcom/talabat/talabatlife/features/waitList/network/WaitListService;", "Lcom/talabat/talabatlife/features/waitList/network/WaitListApi;", "talabatAPIBuilder", "Lcom/talabat/core/network/network/TalabatAPIBuilder;", "(Lcom/talabat/core/network/network/TalabatAPIBuilder;)V", "waitListApi", "getWaitListApi", "()Lcom/talabat/talabatlife/features/waitList/network/WaitListApi;", "waitListApi$delegate", "Lkotlin/Lazy;", "getUserWaitListState", "Lretrofit2/Call;", "Lcom/talabat/talabatlife/features/waitList/model/UserWaitListRootResponse;", "country", "", "version", "joinWaitList", "com_talabat_NewArchi_TalabatLife_TalabatLife"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class WaitListService implements WaitListApi {
    @NotNull
    private final Lazy waitListApi$delegate;

    public WaitListService(@NotNull TalabatAPIBuilder talabatAPIBuilder) {
        Intrinsics.checkNotNullParameter(talabatAPIBuilder, "talabatAPIBuilder");
        this.waitListApi$delegate = LazyKt__LazyJVMKt.lazy(LazyThreadSafetyMode.NONE, new WaitListService$waitListApi$2(talabatAPIBuilder));
    }

    private final WaitListApi getWaitListApi() {
        return (WaitListApi) this.waitListApi$delegate.getValue();
    }

    @NotNull
    public Call<UserWaitListRootResponse> getUserWaitListState(int i11, int i12) {
        return getWaitListApi().getUserWaitListState(i11, i12);
    }

    @NotNull
    public Call<UserWaitListRootResponse> joinWaitList(int i11, int i12) {
        return getWaitListApi().joinWaitList(i11, i12);
    }
}
