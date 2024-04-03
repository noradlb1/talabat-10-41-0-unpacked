package com.talabat.restaurants.v2.domain.swimlane;

import com.talabat.restaurants.v2.data.swimlane.SwimlaneRepository;
import io.reactivex.Single;
import kotlin.Metadata;
import kotlin.jvm.functions.Function5;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import library.talabat.com.talabatlib.SwimlaneResponse;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u000020\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0003\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\u00040\u0001j\u0002`\u0006B\u000f\u0012\b\b\u0002\u0010\u0007\u001a\u00020\b¢\u0006\u0002\u0010\tJ7\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00050\u00042\u0006\u0010\u000b\u001a\u00020\u00022\u0006\u0010\f\u001a\u00020\u00022\u0006\u0010\r\u001a\u00020\u00032\u0006\u0010\u000e\u001a\u00020\u00032\u0006\u0010\u000f\u001a\u00020\u0003H\u0002R\u000e\u0010\u0007\u001a\u00020\bX\u0004¢\u0006\u0002\n\u0000¨\u0006\u0010"}, d2 = {"Lcom/talabat/restaurants/v2/domain/swimlane/RequestSwimlanesUseCase;", "Lkotlin/Function5;", "", "", "Lio/reactivex/Single;", "Llibrary/talabat/com/talabatlib/SwimlaneResponse;", "Lcom/talabat/restaurants/v2/domain/swimlane/RequestSwimlanesUseCaseInterface;", "swimlaneRepository", "Lcom/talabat/restaurants/v2/data/swimlane/SwimlaneRepository;", "(Lcom/talabat/restaurants/v2/data/swimlane/SwimlaneRepository;)V", "invoke", "latitude", "longitude", "areaId", "countryId", "verticalId", "com_talabat_talabat_talabat"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class RequestSwimlanesUseCase implements Function5<String, String, Integer, Integer, Integer, Single<SwimlaneResponse>> {
    @NotNull
    private final SwimlaneRepository swimlaneRepository;

    public RequestSwimlanesUseCase() {
        this((SwimlaneRepository) null, 1, (DefaultConstructorMarker) null);
    }

    public RequestSwimlanesUseCase(@NotNull SwimlaneRepository swimlaneRepository2) {
        Intrinsics.checkNotNullParameter(swimlaneRepository2, "swimlaneRepository");
        this.swimlaneRepository = swimlaneRepository2;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2, Object obj3, Object obj4, Object obj5) {
        return invoke((String) obj, (String) obj2, ((Number) obj3).intValue(), ((Number) obj4).intValue(), ((Number) obj5).intValue());
    }

    @NotNull
    public Single<SwimlaneResponse> invoke(@NotNull String str, @NotNull String str2, int i11, int i12, int i13) {
        Intrinsics.checkNotNullParameter(str, "latitude");
        Intrinsics.checkNotNullParameter(str2, "longitude");
        return this.swimlaneRepository.getSwimlanes(new SwimlaneRepository.SwimlaneData(true, str, str2, i11, i12, CollectionsKt__CollectionsJVMKt.listOf(Integer.valueOf(i13)), 0, "shop_list", "swimlane"));
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r7v1, resolved type: com.talabat.restaurants.v2.data.swimlane.SwimlaneRepositoryImpl} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r7v2, resolved type: com.talabat.restaurants.v2.data.swimlane.SwimlaneRepositoryImpl} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v1, resolved type: com.talabat.restaurants.v2.data.swimlane.SwimlaneRepositoryImpl} */
    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public /* synthetic */ RequestSwimlanesUseCase(com.talabat.restaurants.v2.data.swimlane.SwimlaneRepository r7, int r8, kotlin.jvm.internal.DefaultConstructorMarker r9) {
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
        throw new UnsupportedOperationException("Method not decompiled: com.talabat.restaurants.v2.domain.swimlane.RequestSwimlanesUseCase.<init>(com.talabat.restaurants.v2.data.swimlane.SwimlaneRepository, int, kotlin.jvm.internal.DefaultConstructorMarker):void");
    }
}
