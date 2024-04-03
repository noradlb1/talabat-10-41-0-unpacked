package com.talabat.restaurants.v2.domain.swimlane;

import com.talabat.core.featureflag.domain.ITalabatFeatureFlag;
import com.talabat.restaurants.v2.data.swimlane.SwimlaneRepository;
import datamodels.Strategy;
import datamodels.Swimlane;
import io.reactivex.Single;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.functions.Function6;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;
import org.jetbrains.annotations.NotNull;
import ot.c;

@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\u0010\u000e\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\t\u0018\u00002N\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0004\u0012&\u0012$\u0012 \u0012\u001e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00030\u0006j\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0003`\u00070\u00050\u0001BM\u0012\u0006\u0010\b\u001a\u00020\t\u0012>\b\u0002\u0010\n\u001a8\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0004\u0012\u0010\u0012\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\f0\u000b0\u00050\u0001¢\u0006\u0002\u0010\rJ[\u0010\u000e\u001a$\u0012 \u0012\u001e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00030\u0006j\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0003`\u00070\u00052\u0006\u0010\u000f\u001a\u00020\u00022\u0006\u0010\u0010\u001a\u00020\u00032\u0006\u0010\u0011\u001a\u00020\u00032\u0006\u0010\u0012\u001a\u00020\u00042\u0006\u0010\u0013\u001a\u00020\u00042\u0006\u0010\u0014\u001a\u00020\u0004H\u0002RD\u0010\n\u001a8\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0004\u0012\u0010\u0012\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\f0\u000b0\u00050\u0001X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0004¢\u0006\u0002\n\u0000¨\u0006\u0015"}, d2 = {"Lcom/talabat/restaurants/v2/domain/swimlane/GetSwimlaneGaUseCase;", "Lkotlin/Function6;", "", "", "", "Lio/reactivex/Single;", "Ljava/util/HashMap;", "Lkotlin/collections/HashMap;", "talabatFeatureFlag", "Lcom/talabat/core/featureflag/domain/ITalabatFeatureFlag;", "getVendorsSwimlanes", "", "Ldatamodels/Swimlane;", "(Lcom/talabat/core/featureflag/domain/ITalabatFeatureFlag;Lkotlin/jvm/functions/Function6;)V", "invoke", "isForceUpdate", "latitude", "longitude", "areaId", "countryId", "verticalId", "com_talabat_talabat_talabat"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class GetSwimlaneGaUseCase implements Function6<Boolean, String, String, Integer, Integer, Integer, Single<HashMap<String, String>>> {
    @NotNull
    private final Function6<Boolean, String, String, Integer, Integer, Integer, Single<List<Swimlane>>> getVendorsSwimlanes;
    @NotNull
    private final ITalabatFeatureFlag talabatFeatureFlag;

    public GetSwimlaneGaUseCase(@NotNull ITalabatFeatureFlag iTalabatFeatureFlag, @NotNull Function6<? super Boolean, ? super String, ? super String, ? super Integer, ? super Integer, ? super Integer, ? extends Single<List<Swimlane>>> function6) {
        Intrinsics.checkNotNullParameter(iTalabatFeatureFlag, "talabatFeatureFlag");
        Intrinsics.checkNotNullParameter(function6, "getVendorsSwimlanes");
        this.talabatFeatureFlag = iTalabatFeatureFlag;
        this.getVendorsSwimlanes = function6;
    }

    /* access modifiers changed from: private */
    /* renamed from: invoke$lambda-0  reason: not valid java name */
    public static final HashMap m10742invoke$lambda0(List list) {
        String str;
        boolean z11;
        String str2;
        Strategy strategy;
        Intrinsics.checkNotNullParameter(list, "swimlanes");
        String valueOf = String.valueOf(list.size());
        Swimlane swimlane = (Swimlane) CollectionsKt___CollectionsKt.getOrNull(list, 0);
        if (swimlane == null || (strategy = swimlane.getStrategy()) == null) {
            str = null;
        } else {
            str = strategy.getRequestId();
        }
        String str3 = "N/A";
        if (str == null) {
            str = str3;
        }
        Iterator it = list.iterator();
        int i11 = 0;
        String str4 = str3;
        while (it.hasNext()) {
            int i12 = i11 + 1;
            Swimlane swimlane2 = (Swimlane) it.next();
            boolean z12 = true;
            if (str4.length() > 0) {
                z11 = true;
            } else {
                z11 = false;
            }
            if (z11) {
                str4 = str4 + ",";
            }
            StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
            String format = String.format("%s:%s", Arrays.copyOf(new Object[]{Integer.valueOf(i11), swimlane2.getSlug()}, 2));
            Intrinsics.checkNotNullExpressionValue(format, "format(format, *args)");
            str4 = str4 + format;
            if (str3.length() <= 0) {
                z12 = false;
            }
            if (z12) {
                str3 = str3 + ",";
            }
            Strategy strategy2 = swimlane2.getStrategy();
            if (strategy2 != null) {
                str2 = strategy2.getRecommendationStrategy();
            } else {
                str2 = null;
            }
            str3 = str3 + str2;
            i11 = i12;
        }
        HashMap hashMap = new HashMap();
        hashMap.put("swimlaneLength", valueOf);
        hashMap.put("swimlaneRequestId", str);
        hashMap.put("swimlaneStrategyList", str3);
        hashMap.put("swimlaneTitleList", str4);
        hashMap.put("swimlaneVariation", "images_swimlane");
        return hashMap;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2, Object obj3, Object obj4, Object obj5, Object obj6) {
        return invoke(((Boolean) obj).booleanValue(), (String) obj2, (String) obj3, ((Number) obj4).intValue(), ((Number) obj5).intValue(), ((Number) obj6).intValue());
    }

    @NotNull
    public Single<HashMap<String, String>> invoke(boolean z11, @NotNull String str, @NotNull String str2, int i11, int i12, int i13) {
        Intrinsics.checkNotNullParameter(str, "latitude");
        Intrinsics.checkNotNullParameter(str2, "longitude");
        Single<HashMap<String, String>> map = this.getVendorsSwimlanes.invoke(Boolean.valueOf(z11), str, str2, Integer.valueOf(i11), Integer.valueOf(i12), Integer.valueOf(i13)).map(new c());
        Intrinsics.checkNotNullExpressionValue(map, "getVendorsSwimlanes(isFo…esGaMap\n                }");
        return map;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ GetSwimlaneGaUseCase(ITalabatFeatureFlag iTalabatFeatureFlag, Function6 function6, int i11, DefaultConstructorMarker defaultConstructorMarker) {
        this(iTalabatFeatureFlag, (i11 & 2) != 0 ? new GetVendorsSwimlanes(iTalabatFeatureFlag, (SwimlaneRepository) null, 2, (DefaultConstructorMarker) null) : function6);
    }
}
