package com.talabat.talabatcommon.feature.darkstores.lookingGlass.network;

import com.talabat.core.network.network.TalabatAPIBuilder;
import com.talabat.talabatcommon.feature.darkstores.lookingGlass.UrlConstantsKt;
import com.talabat.talabatcommon.feature.darkstores.lookingGlass.model.response.LookingGlassResponse;
import kotlin.Lazy;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import retrofit2.Call;

@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004JF\u0010\n\u001a\b\u0012\u0004\u0012\u00020\f0\u000b2\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u00112\u0006\u0010\u0013\u001a\u00020\u00112\u0006\u0010\u0014\u001a\u00020\u000e2\u0006\u0010\u0015\u001a\u00020\u000eH\u0016R\u001b\u0010\u0005\u001a\u00020\u00018BX\u0002¢\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0016"}, d2 = {"Lcom/talabat/talabatcommon/feature/darkstores/lookingGlass/network/LookingGlassService;", "Lcom/talabat/talabatcommon/feature/darkstores/lookingGlass/network/LookingGlassApi;", "talabatAPIBuilder", "Lcom/talabat/core/network/network/TalabatAPIBuilder;", "(Lcom/talabat/core/network/network/TalabatAPIBuilder;)V", "lookingGlassApi", "getLookingGlassApi", "()Lcom/talabat/talabatcommon/feature/darkstores/lookingGlass/network/LookingGlassApi;", "lookingGlassApi$delegate", "Lkotlin/Lazy;", "getGlassData", "Lretrofit2/Call;", "Lcom/talabat/talabatcommon/feature/darkstores/lookingGlass/model/response/LookingGlassResponse;", "countryId", "", "areaId", "productTag", "", "lat", "lng", "limit", "offset", "com_talabat_NewArchi_TalabatCommon_TalabatCommon"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class LookingGlassService implements LookingGlassApi {
    @NotNull
    private final Lazy lookingGlassApi$delegate;

    public LookingGlassService(@NotNull TalabatAPIBuilder talabatAPIBuilder) {
        Intrinsics.checkNotNullParameter(talabatAPIBuilder, "talabatAPIBuilder");
        this.lookingGlassApi$delegate = LazyKt__LazyJVMKt.lazy(LazyThreadSafetyMode.NONE, new LookingGlassService$lookingGlassApi$2(talabatAPIBuilder));
    }

    private final LookingGlassApi getLookingGlassApi() {
        return (LookingGlassApi) this.lookingGlassApi$delegate.getValue();
    }

    @NotNull
    public Call<LookingGlassResponse> getGlassData(int i11, int i12, @NotNull String str, @NotNull String str2, @NotNull String str3, int i13, int i14) {
        Intrinsics.checkNotNullParameter(str, UrlConstantsKt.PRODUCT_TAG);
        Intrinsics.checkNotNullParameter(str2, "lat");
        Intrinsics.checkNotNullParameter(str3, "lng");
        return getLookingGlassApi().getGlassData(i11, i12, str, str2, str3, i13, i14);
    }
}
