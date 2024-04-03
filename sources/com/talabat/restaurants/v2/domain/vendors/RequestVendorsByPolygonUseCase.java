package com.talabat.restaurants.v2.domain.vendors;

import com.talabat.core.experiment.data.squads.GroceryDiscoveryExperiments;
import com.talabat.core.experiment.domain.ITalabatExperiment;
import com.talabat.core.experiment.domain.TalabatExperimentDataSourceStrategy;
import com.talabat.restaurants.v2.data.vendors.VendorsRepository;
import io.reactivex.Single;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.functions.Function5;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import library.talabat.com.talabatlib.RestuarntListResponse;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\u0010\b\n\u0002\u0010\u000e\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u000024\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0004\u0012\f\u0012\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0005\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00070\u00060\u0001B\u0019\u0012\b\b\u0002\u0010\b\u001a\u00020\t\u0012\b\b\u0002\u0010\n\u001a\u00020\u000b¢\u0006\u0002\u0010\fJ\b\u0010\r\u001a\u00020\u0004H\u0002J?\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00070\u00062\u0006\u0010\u000f\u001a\u00020\u00022\u0006\u0010\u0010\u001a\u00020\u00032\u0006\u0010\u0011\u001a\u00020\u00042\u0006\u0010\u0012\u001a\u00020\u00042\u000e\u0010\u0013\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0005H\u0002R\u000e\u0010\n\u001a\u00020\u000bX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0004¢\u0006\u0002\n\u0000¨\u0006\u0014"}, d2 = {"Lcom/talabat/restaurants/v2/domain/vendors/RequestVendorsByPolygonUseCase;", "Lkotlin/Function5;", "", "", "", "", "Lio/reactivex/Single;", "Llibrary/talabat/com/talabatlib/RestuarntListResponse;", "vendorsRepository", "Lcom/talabat/restaurants/v2/data/vendors/VendorsRepository;", "talabatExperiment", "Lcom/talabat/core/experiment/domain/ITalabatExperiment;", "(Lcom/talabat/restaurants/v2/data/vendors/VendorsRepository;Lcom/talabat/core/experiment/domain/ITalabatExperiment;)V", "getWeightSet", "invoke", "isForceUpdate", "apiVersion", "latitude", "longitude", "verticalIds", "com_talabat_talabat_talabat"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class RequestVendorsByPolygonUseCase implements Function5<Boolean, Integer, String, String, List<? extends Integer>, Single<RestuarntListResponse>> {
    @NotNull
    private final ITalabatExperiment talabatExperiment;
    @NotNull
    private final VendorsRepository vendorsRepository;

    public RequestVendorsByPolygonUseCase() {
        this((VendorsRepository) null, (ITalabatExperiment) null, 3, (DefaultConstructorMarker) null);
    }

    public RequestVendorsByPolygonUseCase(@NotNull VendorsRepository vendorsRepository2, @NotNull ITalabatExperiment iTalabatExperiment) {
        Intrinsics.checkNotNullParameter(vendorsRepository2, "vendorsRepository");
        Intrinsics.checkNotNullParameter(iTalabatExperiment, "talabatExperiment");
        this.vendorsRepository = vendorsRepository2;
        this.talabatExperiment = iTalabatExperiment;
    }

    private final String getWeightSet() {
        return ITalabatExperiment.DefaultImpls.getStringVariant$default(this.talabatExperiment, GroceryDiscoveryExperiments.WEIGHT_SET_VENDOR_LIST_API, "", (TalabatExperimentDataSourceStrategy) null, 4, (Object) null);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2, Object obj3, Object obj4, Object obj5) {
        return invoke(((Boolean) obj).booleanValue(), ((Number) obj2).intValue(), (String) obj3, (String) obj4, (List<Integer>) (List) obj5);
    }

    @NotNull
    public Single<RestuarntListResponse> invoke(boolean z11, int i11, @NotNull String str, @NotNull String str2, @Nullable List<Integer> list) {
        Intrinsics.checkNotNullParameter(str, "latitude");
        Intrinsics.checkNotNullParameter(str2, "longitude");
        return this.vendorsRepository.getVendorsByPolygons(z11, i11, str, str2, list, getWeightSet());
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r7v1, resolved type: com.talabat.restaurants.v2.data.vendors.VendorsRepositoryImpl} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r7v2, resolved type: com.talabat.restaurants.v2.data.vendors.VendorsRepositoryImpl} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v1, resolved type: com.talabat.restaurants.v2.data.vendors.VendorsRepositoryImpl} */
    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public /* synthetic */ RequestVendorsByPolygonUseCase(com.talabat.restaurants.v2.data.vendors.VendorsRepository r7, com.talabat.core.experiment.domain.ITalabatExperiment r8, int r9, kotlin.jvm.internal.DefaultConstructorMarker r10) {
        /*
            r6 = this;
            r10 = r9 & 1
            if (r10 == 0) goto L_0x000f
            com.talabat.restaurants.v2.data.vendors.VendorsRepositoryImpl r7 = new com.talabat.restaurants.v2.data.vendors.VendorsRepositoryImpl
            r1 = 0
            r2 = 0
            r3 = 0
            r4 = 7
            r5 = 0
            r0 = r7
            r0.<init>(r1, r2, r3, r4, r5)
        L_0x000f:
            r9 = r9 & 2
            if (r9 == 0) goto L_0x0015
            com.talabat.core.experiment.data.TalabatExperiment r8 = com.talabat.core.experiment.data.TalabatExperiment.INSTANCE
        L_0x0015:
            r6.<init>(r7, r8)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.talabat.restaurants.v2.domain.vendors.RequestVendorsByPolygonUseCase.<init>(com.talabat.restaurants.v2.data.vendors.VendorsRepository, com.talabat.core.experiment.domain.ITalabatExperiment, int, kotlin.jvm.internal.DefaultConstructorMarker):void");
    }
}
