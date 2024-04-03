package com.talabat.darkstores.data.swimlanes;

import com.talabat.core.dispatcher.domain.RxSchedulersFactory;
import com.talabat.darkstores.data.ConfigurationParameters;
import com.talabat.darkstores.data.darkstores.DarkstoresRepo;
import com.talabat.darkstores.domain.mapper.MissionControlProductsResponseToDomainMapper;
import com.talabat.darkstores.domain.model.MissionControlProducts;
import com.talabat.feature.darkstoresvendor.domain.model.Vendor;
import gi.e;
import io.reactivex.Single;
import io.reactivex.SingleSource;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import mi.a;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\b\u0000\u0018\u00002\u00020\u0001B/\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\u000b¢\u0006\u0002\u0010\fJ6\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u000f0\u000e2\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u00112\u0006\u0010\u0013\u001a\u00020\u00112\u0006\u0010\u0014\u001a\u00020\u00152\b\u0010\u0016\u001a\u0004\u0018\u00010\u0011R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0004¢\u0006\u0002\n\u0000¨\u0006\u0017"}, d2 = {"Lcom/talabat/darkstores/data/swimlanes/SwimlanesProductRepository;", "", "configurationParameters", "Lcom/talabat/darkstores/data/ConfigurationParameters;", "darkstoresRepo", "Lcom/talabat/darkstores/data/darkstores/DarkstoresRepo;", "swimlanseProductApi", "Lcom/talabat/darkstores/data/swimlanes/SwimlanseProductApi;", "mapMissionControlResponse", "Lcom/talabat/darkstores/domain/mapper/MissionControlProductsResponseToDomainMapper;", "rxSchedulersFactory", "Lcom/talabat/core/dispatcher/domain/RxSchedulersFactory;", "(Lcom/talabat/darkstores/data/ConfigurationParameters;Lcom/talabat/darkstores/data/darkstores/DarkstoresRepo;Lcom/talabat/darkstores/data/swimlanes/SwimlanseProductApi;Lcom/talabat/darkstores/domain/mapper/MissionControlProductsResponseToDomainMapper;Lcom/talabat/core/dispatcher/domain/RxSchedulersFactory;)V", "getSwimlaneProducts", "Lio/reactivex/Single;", "Lcom/talabat/darkstores/domain/model/MissionControlProducts;", "swimlaneId", "", "productId", "productSku", "pageNumber", "", "filterCategoryId", "com_talabat_NewArchi_darkstores_darkstores"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class SwimlanesProductRepository {
    @NotNull
    private final ConfigurationParameters configurationParameters;
    @NotNull
    private final DarkstoresRepo darkstoresRepo;
    @NotNull
    private final MissionControlProductsResponseToDomainMapper mapMissionControlResponse;
    @NotNull
    private final RxSchedulersFactory rxSchedulersFactory;
    @NotNull
    private final SwimlanseProductApi swimlanseProductApi;

    @Inject
    public SwimlanesProductRepository(@NotNull ConfigurationParameters configurationParameters2, @NotNull DarkstoresRepo darkstoresRepo2, @NotNull SwimlanseProductApi swimlanseProductApi2, @NotNull MissionControlProductsResponseToDomainMapper missionControlProductsResponseToDomainMapper, @NotNull RxSchedulersFactory rxSchedulersFactory2) {
        Intrinsics.checkNotNullParameter(configurationParameters2, "configurationParameters");
        Intrinsics.checkNotNullParameter(darkstoresRepo2, "darkstoresRepo");
        Intrinsics.checkNotNullParameter(swimlanseProductApi2, "swimlanseProductApi");
        Intrinsics.checkNotNullParameter(missionControlProductsResponseToDomainMapper, "mapMissionControlResponse");
        Intrinsics.checkNotNullParameter(rxSchedulersFactory2, "rxSchedulersFactory");
        this.configurationParameters = configurationParameters2;
        this.darkstoresRepo = darkstoresRepo2;
        this.swimlanseProductApi = swimlanseProductApi2;
        this.mapMissionControlResponse = missionControlProductsResponseToDomainMapper;
        this.rxSchedulersFactory = rxSchedulersFactory2;
    }

    /* access modifiers changed from: private */
    /* renamed from: getSwimlaneProducts$lambda-0  reason: not valid java name */
    public static final SingleSource m9742getSwimlaneProducts$lambda0(SwimlanesProductRepository swimlanesProductRepository, String str, String str2, String str3, int i11, String str4, Vendor vendor) {
        SwimlanesProductRepository swimlanesProductRepository2 = swimlanesProductRepository;
        Intrinsics.checkNotNullParameter(swimlanesProductRepository, "this$0");
        String str5 = str;
        Intrinsics.checkNotNullParameter(str, "$swimlaneId");
        String str6 = str2;
        Intrinsics.checkNotNullParameter(str2, "$productId");
        String str7 = str3;
        Intrinsics.checkNotNullParameter(str3, "$productSku");
        Intrinsics.checkNotNullParameter(vendor, "vendor");
        return swimlanesProductRepository2.swimlanseProductApi.getSwimlanesProducts(swimlanesProductRepository2.configurationParameters.getCountryCode(), str, vendor.getVendorId(), swimlanesProductRepository2.configurationParameters.getBranchId(), !swimlanesProductRepository2.configurationParameters.isMigrated(), str2, str3, i11, str4);
    }

    @NotNull
    public final Single<MissionControlProducts> getSwimlaneProducts(@NotNull String str, @NotNull String str2, @NotNull String str3, int i11, @Nullable String str4) {
        Intrinsics.checkNotNullParameter(str, "swimlaneId");
        Intrinsics.checkNotNullParameter(str2, "productId");
        Intrinsics.checkNotNullParameter(str3, "productSku");
        Single<R> subscribeOn = this.darkstoresRepo.getVendor().flatMap(new a(this, str, str2, str3, i11, str4)).map(new e(this.mapMissionControlResponse)).subscribeOn(this.rxSchedulersFactory.io());
        Intrinsics.checkNotNullExpressionValue(subscribeOn, "darkstoresRepo.getVendor…rxSchedulersFactory.io())");
        return subscribeOn;
    }
}
