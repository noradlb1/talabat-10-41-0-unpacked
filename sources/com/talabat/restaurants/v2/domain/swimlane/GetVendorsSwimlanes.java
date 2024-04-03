package com.talabat.restaurants.v2.domain.swimlane;

import com.talabat.core.featureflag.domain.ITalabatFeatureFlag;
import com.talabat.restaurants.v2.data.swimlane.SwimlaneRepository;
import com.talabat.restaurants.v2.domain.utils.VendorFilterByVertical;
import datamodels.Restaurant;
import datamodels.Swimlane;
import io.reactivex.Single;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.functions.Function6;
import kotlin.jvm.internal.Intrinsics;
import library.talabat.com.talabatlib.SwimlaneData;
import library.talabat.com.talabatlib.SwimlaneResponse;
import org.jetbrains.annotations.NotNull;
import ot.d;

@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\u0010\u000e\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u000028\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0004\u0012\u0010\u0012\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00070\u00060\u00050\u0001B\u0017\u0012\u0006\u0010\b\u001a\u00020\t\u0012\b\b\u0002\u0010\n\u001a\u00020\u000b¢\u0006\u0002\u0010\fJE\u0010\r\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00070\u00060\u00052\u0006\u0010\u000e\u001a\u00020\u00022\u0006\u0010\u000f\u001a\u00020\u00032\u0006\u0010\u0010\u001a\u00020\u00032\u0006\u0010\u0011\u001a\u00020\u00042\u0006\u0010\u0012\u001a\u00020\u00042\u0006\u0010\u0013\u001a\u00020\u0004H\u0002R\u000e\u0010\n\u001a\u00020\u000bX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0004¢\u0006\u0002\n\u0000¨\u0006\u0014"}, d2 = {"Lcom/talabat/restaurants/v2/domain/swimlane/GetVendorsSwimlanes;", "Lkotlin/Function6;", "", "", "", "Lio/reactivex/Single;", "", "Ldatamodels/Swimlane;", "talabatFeatureFlag", "Lcom/talabat/core/featureflag/domain/ITalabatFeatureFlag;", "swimlaneRepository", "Lcom/talabat/restaurants/v2/data/swimlane/SwimlaneRepository;", "(Lcom/talabat/core/featureflag/domain/ITalabatFeatureFlag;Lcom/talabat/restaurants/v2/data/swimlane/SwimlaneRepository;)V", "invoke", "isForceUpdate", "latitude", "longitude", "areaId", "countryId", "verticalId", "com_talabat_talabat_talabat"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class GetVendorsSwimlanes implements Function6<Boolean, String, String, Integer, Integer, Integer, Single<List<? extends Swimlane>>> {
    @NotNull
    private final SwimlaneRepository swimlaneRepository;
    @NotNull
    private final ITalabatFeatureFlag talabatFeatureFlag;

    public GetVendorsSwimlanes(@NotNull ITalabatFeatureFlag iTalabatFeatureFlag, @NotNull SwimlaneRepository swimlaneRepository2) {
        Intrinsics.checkNotNullParameter(iTalabatFeatureFlag, "talabatFeatureFlag");
        Intrinsics.checkNotNullParameter(swimlaneRepository2, "swimlaneRepository");
        this.talabatFeatureFlag = iTalabatFeatureFlag;
        this.swimlaneRepository = swimlaneRepository2;
    }

    /* access modifiers changed from: private */
    /* renamed from: invoke$lambda-3  reason: not valid java name */
    public static final List m10743invoke$lambda3(int i11, GetVendorsSwimlanes getVendorsSwimlanes, SwimlaneResponse swimlaneResponse) {
        ArrayList<Swimlane> swimLanes;
        Intrinsics.checkNotNullParameter(getVendorsSwimlanes, "this$0");
        Intrinsics.checkNotNullParameter(swimlaneResponse, "it");
        SwimlaneData result = swimlaneResponse.getResult();
        if (result == null || (swimLanes = result.getSwimLanes()) == null) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        for (T next : swimLanes) {
            ArrayList<Restaurant> arrayList2 = ((Swimlane) next).restaurants;
            boolean z11 = false;
            if (arrayList2 != null && !arrayList2.isEmpty()) {
                Iterator<T> it = arrayList2.iterator();
                while (true) {
                    if (!it.hasNext()) {
                        break;
                    }
                    if (VendorFilterByVertical.INSTANCE.vendorFilterPredicate((Restaurant) it.next(), true, i11, getVendorsSwimlanes.talabatFeatureFlag)) {
                        z11 = true;
                        break;
                    }
                }
            }
            if (z11) {
                arrayList.add(next);
            }
        }
        return arrayList;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2, Object obj3, Object obj4, Object obj5, Object obj6) {
        return invoke(((Boolean) obj).booleanValue(), (String) obj2, (String) obj3, ((Number) obj4).intValue(), ((Number) obj5).intValue(), ((Number) obj6).intValue());
    }

    @NotNull
    public Single<List<Swimlane>> invoke(boolean z11, @NotNull String str, @NotNull String str2, int i11, int i12, int i13) {
        Intrinsics.checkNotNullParameter(str, "latitude");
        String str3 = str2;
        Intrinsics.checkNotNullParameter(str3, "longitude");
        Single<R> map = this.swimlaneRepository.getSwimlanes(new SwimlaneRepository.SwimlaneData(z11, str, str3, i11, i12, CollectionsKt__CollectionsJVMKt.listOf(Integer.valueOf(i13)), 0, "shop_list", "swimlane")).map(new d(i13, this));
        Intrinsics.checkNotNullExpressionValue(map, "vendorsSwimlanes.map { i…}\n            }\n        }");
        return map;
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v1, resolved type: com.talabat.restaurants.v2.data.swimlane.SwimlaneRepositoryImpl} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v2, resolved type: com.talabat.restaurants.v2.data.swimlane.SwimlaneRepositoryImpl} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v1, resolved type: com.talabat.restaurants.v2.data.swimlane.SwimlaneRepositoryImpl} */
    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public /* synthetic */ GetVendorsSwimlanes(com.talabat.core.featureflag.domain.ITalabatFeatureFlag r7, com.talabat.restaurants.v2.data.swimlane.SwimlaneRepository r8, int r9, kotlin.jvm.internal.DefaultConstructorMarker r10) {
        /*
            r6 = this;
            r9 = r9 & 2
            if (r9 == 0) goto L_0x000f
            com.talabat.restaurants.v2.data.swimlane.SwimlaneRepositoryImpl r8 = new com.talabat.restaurants.v2.data.swimlane.SwimlaneRepositoryImpl
            r1 = 0
            r2 = 0
            r3 = 0
            r4 = 7
            r5 = 0
            r0 = r8
            r0.<init>(r1, r2, r3, r4, r5)
        L_0x000f:
            r6.<init>(r7, r8)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.talabat.restaurants.v2.domain.swimlane.GetVendorsSwimlanes.<init>(com.talabat.core.featureflag.domain.ITalabatFeatureFlag, com.talabat.restaurants.v2.data.swimlane.SwimlaneRepository, int, kotlin.jvm.internal.DefaultConstructorMarker):void");
    }
}
