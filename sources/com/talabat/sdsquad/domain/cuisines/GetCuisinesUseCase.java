package com.talabat.sdsquad.domain.cuisines;

import com.talabat.sdsquad.core.DisplayModelMapper;
import com.talabat.sdsquad.core.UseCase;
import com.talabat.sdsquad.data.vendorslist.VendorsInfoRepository;
import com.talabat.sdsquad.data.vendorslist.response.Cuisine;
import com.talabat.sdsquad.ui.cuisines.displaymodels.CuisineDisplayModel;
import io.reactivex.Flowable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import zt.a;
import zt.b;
import zt.c;

@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 \u000e2\u001a\u0012\u0004\u0012\u00020\u0002\u0012\u0010\u0012\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\u00040\u00030\u0001:\u0002\u000e\u000fB!\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0012\u0010\b\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\n0\t¢\u0006\u0002\u0010\u000bJ\u001e\u0010\f\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\u00040\u00032\b\u0010\r\u001a\u0004\u0018\u00010\u0002H\u0016R\u001a\u0010\b\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\n0\tX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0004¢\u0006\u0002\n\u0000¨\u0006\u0010"}, d2 = {"Lcom/talabat/sdsquad/domain/cuisines/GetCuisinesUseCase;", "Lcom/talabat/sdsquad/core/UseCase;", "Lcom/talabat/sdsquad/domain/cuisines/GetCuisinesUseCase$RequestValues;", "Lio/reactivex/Flowable;", "", "Lcom/talabat/sdsquad/ui/cuisines/displaymodels/CuisineDisplayModel;", "mVendorRepository", "Lcom/talabat/sdsquad/data/vendorslist/VendorsInfoRepository;", "mCuisineMapper", "Lcom/talabat/sdsquad/core/DisplayModelMapper;", "Lcom/talabat/sdsquad/data/vendorslist/response/Cuisine;", "(Lcom/talabat/sdsquad/data/vendorslist/VendorsInfoRepository;Lcom/talabat/sdsquad/core/DisplayModelMapper;)V", "executeUseCase", "requestValues", "Companion", "RequestValues", "com_talabat_NewArchi_sdsquad_sdsquad"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class GetCuisinesUseCase extends UseCase<RequestValues, Flowable<List<? extends CuisineDisplayModel>>> {
    public static final int ALL_CUISINE_ID = 0;
    @NotNull
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    @NotNull
    private final DisplayModelMapper<CuisineDisplayModel, Cuisine> mCuisineMapper;
    @NotNull
    private final VendorsInfoRepository mVendorRepository;

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0005"}, d2 = {"Lcom/talabat/sdsquad/domain/cuisines/GetCuisinesUseCase$Companion;", "", "()V", "ALL_CUISINE_ID", "", "com_talabat_NewArchi_sdsquad_sdsquad"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, d2 = {"Lcom/talabat/sdsquad/domain/cuisines/GetCuisinesUseCase$RequestValues;", "Lcom/talabat/sdsquad/core/UseCase$RequestValues;", "selectedCuisine", "", "(I)V", "getSelectedCuisine", "()I", "com_talabat_NewArchi_sdsquad_sdsquad"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class RequestValues implements UseCase.RequestValues {
        private final int selectedCuisine;

        public RequestValues(int i11) {
            this.selectedCuisine = i11;
        }

        public final int getSelectedCuisine() {
            return this.selectedCuisine;
        }
    }

    public GetCuisinesUseCase(@NotNull VendorsInfoRepository vendorsInfoRepository, @NotNull DisplayModelMapper<CuisineDisplayModel, ? super Cuisine> displayModelMapper) {
        Intrinsics.checkNotNullParameter(vendorsInfoRepository, "mVendorRepository");
        Intrinsics.checkNotNullParameter(displayModelMapper, "mCuisineMapper");
        this.mVendorRepository = vendorsInfoRepository;
        this.mCuisineMapper = displayModelMapper;
    }

    /* access modifiers changed from: private */
    /* renamed from: executeUseCase$lambda-1  reason: not valid java name */
    public static final List m10781executeUseCase$lambda1(GetCuisinesUseCase getCuisinesUseCase, List list) {
        Intrinsics.checkNotNullParameter(getCuisinesUseCase, "this$0");
        Intrinsics.checkNotNullParameter(list, "it");
        Iterable<Cuisine> iterable = list;
        ArrayList arrayList = new ArrayList(CollectionsKt__IterablesKt.collectionSizeOrDefault(iterable, 10));
        for (Cuisine mapToView : iterable) {
            arrayList.add(getCuisinesUseCase.mCuisineMapper.mapToView(mapToView));
        }
        return arrayList;
    }

    /* access modifiers changed from: private */
    /* renamed from: executeUseCase$lambda-2  reason: not valid java name */
    public static final List m10782executeUseCase$lambda2(List list) {
        Intrinsics.checkNotNullParameter(list, "it");
        List mutableList = CollectionsKt___CollectionsKt.toMutableList(list);
        mutableList.add(0, new CuisineDisplayModel(0, "All Cuisine", false));
        return mutableList;
    }

    /* access modifiers changed from: private */
    /* renamed from: executeUseCase$lambda-3  reason: not valid java name */
    public static final List m10783executeUseCase$lambda3(RequestValues requestValues, List list) {
        boolean z11;
        Intrinsics.checkNotNullParameter(list, "it");
        Iterator it = list.iterator();
        while (it.hasNext()) {
            CuisineDisplayModel cuisineDisplayModel = (CuisineDisplayModel) it.next();
            Intrinsics.checkNotNull(requestValues);
            if (requestValues.getSelectedCuisine() == cuisineDisplayModel.getId()) {
                z11 = true;
            } else {
                z11 = false;
            }
            cuisineDisplayModel.setOn(z11);
        }
        return list;
    }

    @NotNull
    public Flowable<List<CuisineDisplayModel>> executeUseCase(@Nullable RequestValues requestValues) {
        Flowable<R> map = this.mVendorRepository.getCuisines().map(new a(this)).map(new b()).map(new c(requestValues));
        Intrinsics.checkNotNullExpressionValue(map, "mVendorRepository.getCui…         it\n            }");
        return map;
    }
}
