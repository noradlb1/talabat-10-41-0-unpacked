package com.talabat.restaurants.v2.domain.swimlane;

import com.google.android.exoplayer2.RendererCapabilities;
import com.talabat.restaurants.v2.data.swimlane.SwimlaneRepository;
import datamodels.FeaturedProducts;
import io.reactivex.Single;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.functions.Function6;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import library.talabat.com.talabatlib.SwimlaneData;
import library.talabat.com.talabatlib.SwimlaneResponse;
import org.jetbrains.annotations.NotNull;
import ot.b;

@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\u0010\u000e\n\u0002\u0010\b\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u00002>\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0004\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00040\u0005\u0012\u0010\u0012\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00070\u00050\u00060\u0001B\u000f\u0012\b\b\u0002\u0010\b\u001a\u00020\t¢\u0006\u0002\u0010\nJK\u0010\u000b\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00070\u00050\u00062\u0006\u0010\f\u001a\u00020\u00022\u0006\u0010\r\u001a\u00020\u00032\u0006\u0010\u000e\u001a\u00020\u00032\u0006\u0010\u000f\u001a\u00020\u00042\u0006\u0010\u0010\u001a\u00020\u00042\f\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00040\u0005H\u0002R\u000e\u0010\b\u001a\u00020\tX\u0004¢\u0006\u0002\n\u0000¨\u0006\u0012"}, d2 = {"Lcom/talabat/restaurants/v2/domain/swimlane/GetFeatureProductsUseCase;", "Lkotlin/Function6;", "", "", "", "", "Lio/reactivex/Single;", "Ldatamodels/FeaturedProducts;", "swimlaneRepository", "Lcom/talabat/restaurants/v2/data/swimlane/SwimlaneRepository;", "(Lcom/talabat/restaurants/v2/data/swimlane/SwimlaneRepository;)V", "invoke", "isForceUpdate", "latitude", "longitude", "areaId", "countryId", "verticalIds", "com_talabat_talabat_talabat"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class GetFeatureProductsUseCase implements Function6<Boolean, String, String, Integer, Integer, List<? extends Integer>, Single<List<? extends FeaturedProducts>>> {
    @NotNull
    private final SwimlaneRepository swimlaneRepository;

    public GetFeatureProductsUseCase() {
        this((SwimlaneRepository) null, 1, (DefaultConstructorMarker) null);
    }

    public GetFeatureProductsUseCase(@NotNull SwimlaneRepository swimlaneRepository2) {
        Intrinsics.checkNotNullParameter(swimlaneRepository2, "swimlaneRepository");
        this.swimlaneRepository = swimlaneRepository2;
    }

    /* access modifiers changed from: private */
    /* renamed from: invoke$lambda-0  reason: not valid java name */
    public static final List m10741invoke$lambda0(SwimlaneResponse swimlaneResponse) {
        List<FeaturedProducts> featureProduct;
        Intrinsics.checkNotNullParameter(swimlaneResponse, "it");
        SwimlaneData result = swimlaneResponse.getResult();
        if (result == null || (featureProduct = result.getFeatureProduct()) == null) {
            return CollectionsKt__CollectionsKt.emptyList();
        }
        return featureProduct;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2, Object obj3, Object obj4, Object obj5, Object obj6) {
        return invoke(((Boolean) obj).booleanValue(), (String) obj2, (String) obj3, ((Number) obj4).intValue(), ((Number) obj5).intValue(), (List<Integer>) (List) obj6);
    }

    @NotNull
    public Single<List<FeaturedProducts>> invoke(boolean z11, @NotNull String str, @NotNull String str2, int i11, int i12, @NotNull List<Integer> list) {
        List<Integer> list2 = list;
        Intrinsics.checkNotNullParameter(str, "latitude");
        Intrinsics.checkNotNullParameter(str2, "longitude");
        Intrinsics.checkNotNullParameter(list2, "verticalIds");
        if (list2.contains(0)) {
            Single<R> map = this.swimlaneRepository.getSwimlanes(new SwimlaneRepository.SwimlaneData(z11, str, str2, i11, i12, list, 0, (String) null, (String) null, RendererCapabilities.MODE_SUPPORT_MASK, (DefaultConstructorMarker) null)).map(new b());
            Intrinsics.checkNotNullExpressionValue(map, "{\n            swimlaneRe…: emptyList() }\n        }");
            return map;
        }
        Single<List<FeaturedProducts>> just = Single.just(CollectionsKt__CollectionsKt.emptyList());
        Intrinsics.checkNotNullExpressionValue(just, "{\n            Single.just(emptyList())\n        }");
        return just;
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r7v1, resolved type: com.talabat.restaurants.v2.data.swimlane.SwimlaneRepositoryImpl} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r7v2, resolved type: com.talabat.restaurants.v2.data.swimlane.SwimlaneRepositoryImpl} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v1, resolved type: com.talabat.restaurants.v2.data.swimlane.SwimlaneRepositoryImpl} */
    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public /* synthetic */ GetFeatureProductsUseCase(com.talabat.restaurants.v2.data.swimlane.SwimlaneRepository r7, int r8, kotlin.jvm.internal.DefaultConstructorMarker r9) {
        /*
            r6 = this;
            r8 = r8 & 1
            if (r8 == 0) goto L_0x000f
            com.talabat.restaurants.v2.data.swimlane.SwimlaneRepositoryImpl r7 = new com.talabat.restaurants.v2.data.swimlane.SwimlaneRepositoryImpl
            r1 = 0
            r2 = 0
            r3 = 0
            r4 = 7
            r5 = 0
            r0 = r7
            r0.<init>(r1, r2, r3, r4, r5)
        L_0x000f:
            r6.<init>(r7)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.talabat.restaurants.v2.domain.swimlane.GetFeatureProductsUseCase.<init>(com.talabat.restaurants.v2.data.swimlane.SwimlaneRepository, int, kotlin.jvm.internal.DefaultConstructorMarker):void");
    }
}
