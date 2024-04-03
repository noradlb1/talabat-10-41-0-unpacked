package com.talabat.sdsquad.domain.vendorslist;

import com.talabat.sdsquad.core.DisplayModelMapper;
import com.talabat.sdsquad.core.UseCase;
import com.talabat.sdsquad.data.vendorslist.VendorsInfoRepository;
import com.talabat.sdsquad.data.vendorslist.response.Collections;
import com.talabat.sdsquad.ui.vendorslist.displaymodels.CollectionDisplayModel;
import com.talabat.sdsquad.ui.vendorslist.displaymodels.InlineAdDisplayModel;
import com.talabat.sdsquad.ui.vendorslist.displaymodels.SwimlaneDisplayModel;
import com.talabat.sdsquad.ui.vendorslist.displaymodels.VendorCellType;
import com.talabat.sdsquad.ui.vendorslist.displaymodels.VendorDisplayModel;
import com.talabat.sdsquad.ui.vendorslist.displaymodels.VendorDisplayWrapper;
import du.a;
import du.b;
import du.c;
import du.d;
import io.reactivex.Flowable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u001a\u0012\u0004\u0012\u00020\u0002\u0012\u0010\u0012\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\u00040\u00030\u0001:\u0001\u0014B#\u0012\u0006\u0010\f\u001a\u00020\u000b\u0012\u0012\u0010\u0010\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u000f0\u000e¢\u0006\u0004\b\u0012\u0010\u0013J$\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00050\u00042\u0006\u0010\u0006\u001a\u00020\u00022\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00070\u0004H\u0002J\u001e\u0010\n\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\u00040\u00032\b\u0010\u0006\u001a\u0004\u0018\u00010\u0002H\u0014R\u0014\u0010\f\u001a\u00020\u000b8\u0002X\u0004¢\u0006\u0006\n\u0004\b\f\u0010\rR \u0010\u0010\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u000f0\u000e8\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0010\u0010\u0011¨\u0006\u0015"}, d2 = {"Lcom/talabat/sdsquad/domain/vendorslist/GetCollectionUseCase;", "Lcom/talabat/sdsquad/core/UseCase;", "Lcom/talabat/sdsquad/domain/vendorslist/GetCollectionUseCase$RequestValues;", "Lio/reactivex/Flowable;", "", "Lcom/talabat/sdsquad/ui/vendorslist/displaymodels/VendorDisplayWrapper;", "requestValues", "Lcom/talabat/sdsquad/ui/vendorslist/displaymodels/CollectionDisplayModel;", "collections", "addCollectionToList", "e", "Lcom/talabat/sdsquad/data/vendorslist/VendorsInfoRepository;", "mVendorRepository", "Lcom/talabat/sdsquad/data/vendorslist/VendorsInfoRepository;", "Lcom/talabat/sdsquad/core/DisplayModelMapper;", "Lcom/talabat/sdsquad/data/vendorslist/response/Collections;", "mCollectionsDisplayMapper", "Lcom/talabat/sdsquad/core/DisplayModelMapper;", "<init>", "(Lcom/talabat/sdsquad/data/vendorslist/VendorsInfoRepository;Lcom/talabat/sdsquad/core/DisplayModelMapper;)V", "RequestValues", "com_talabat_NewArchi_sdsquad_sdsquad"}, k = 1, mv = {1, 6, 0})
public final class GetCollectionUseCase extends UseCase<RequestValues, Flowable<List<? extends VendorDisplayWrapper>>> {
    @NotNull
    private final DisplayModelMapper<CollectionDisplayModel, Collections> mCollectionsDisplayMapper;
    @NotNull
    private final VendorsInfoRepository mVendorRepository;

    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u001b\u0012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0002\u0010\u0007R\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0017\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\f"}, d2 = {"Lcom/talabat/sdsquad/domain/vendorslist/GetCollectionUseCase$RequestValues;", "Lcom/talabat/sdsquad/core/UseCase$RequestValues;", "vendorsList", "", "Lcom/talabat/sdsquad/ui/vendorslist/displaymodels/VendorDisplayWrapper;", "baseUrl", "", "(Ljava/util/List;Ljava/lang/String;)V", "getBaseUrl", "()Ljava/lang/String;", "getVendorsList", "()Ljava/util/List;", "com_talabat_NewArchi_sdsquad_sdsquad"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class RequestValues implements UseCase.RequestValues {
        @NotNull
        private final String baseUrl;
        @NotNull
        private final List<VendorDisplayWrapper> vendorsList;

        public RequestValues(@NotNull List<VendorDisplayWrapper> list, @NotNull String str) {
            Intrinsics.checkNotNullParameter(list, "vendorsList");
            Intrinsics.checkNotNullParameter(str, "baseUrl");
            this.vendorsList = list;
            this.baseUrl = str;
        }

        @NotNull
        public final String getBaseUrl() {
            return this.baseUrl;
        }

        @NotNull
        public final List<VendorDisplayWrapper> getVendorsList() {
            return this.vendorsList;
        }
    }

    public GetCollectionUseCase(@NotNull VendorsInfoRepository vendorsInfoRepository, @NotNull DisplayModelMapper<CollectionDisplayModel, ? super Collections> displayModelMapper) {
        Intrinsics.checkNotNullParameter(vendorsInfoRepository, "mVendorRepository");
        Intrinsics.checkNotNullParameter(displayModelMapper, "mCollectionsDisplayMapper");
        this.mVendorRepository = vendorsInfoRepository;
        this.mCollectionsDisplayMapper = displayModelMapper;
    }

    private final List<VendorDisplayWrapper> addCollectionToList(RequestValues requestValues, List<CollectionDisplayModel> list) {
        List<VendorDisplayWrapper> mutableList = CollectionsKt___CollectionsKt.toMutableList(requestValues.getVendorsList());
        mutableList.add(0, new VendorDisplayWrapper(VendorCellType.Collections, (VendorDisplayModel) null, list, (SwimlaneDisplayModel) null, (InlineAdDisplayModel) null, 24, (DefaultConstructorMarker) null));
        return mutableList;
    }

    /* access modifiers changed from: private */
    /* renamed from: executeUseCase$lambda-8$lambda-2  reason: not valid java name */
    public static final List m10789executeUseCase$lambda8$lambda2(RequestValues requestValues, List list) {
        Intrinsics.checkNotNullParameter(requestValues, "$requestValues");
        Intrinsics.checkNotNullParameter(list, "it");
        ArrayList arrayList = new ArrayList();
        for (Object next : list) {
            Collections collections = (Collections) next;
            boolean z11 = false;
            for (VendorDisplayWrapper vendorDisplayModel : requestValues.getVendorsList()) {
                VendorDisplayModel vendorDisplayModel2 = vendorDisplayModel.getVendorDisplayModel();
                if (vendorDisplayModel2 != null && CollectionsKt___CollectionsKt.contains(vendorDisplayModel2.getFiltersId(), collections.getId())) {
                    z11 = true;
                }
            }
            if (z11) {
                arrayList.add(next);
            }
        }
        return arrayList;
    }

    /* access modifiers changed from: private */
    /* renamed from: executeUseCase$lambda-8$lambda-4  reason: not valid java name */
    public static final List m10790executeUseCase$lambda8$lambda4(GetCollectionUseCase getCollectionUseCase, List list) {
        Intrinsics.checkNotNullParameter(getCollectionUseCase, "this$0");
        Intrinsics.checkNotNullParameter(list, "it");
        Iterable<Collections> iterable = list;
        ArrayList arrayList = new ArrayList(CollectionsKt__IterablesKt.collectionSizeOrDefault(iterable, 10));
        for (Collections mapToView : iterable) {
            arrayList.add(getCollectionUseCase.mCollectionsDisplayMapper.mapToView(mapToView));
        }
        return arrayList;
    }

    /* access modifiers changed from: private */
    /* renamed from: executeUseCase$lambda-8$lambda-6  reason: not valid java name */
    public static final List m10791executeUseCase$lambda8$lambda6(RequestValues requestValues, List list) {
        Intrinsics.checkNotNullParameter(requestValues, "$requestValues");
        Intrinsics.checkNotNullParameter(list, "it");
        Iterator it = list.iterator();
        while (it.hasNext()) {
            ((CollectionDisplayModel) it.next()).setBaseUrl(requestValues.getBaseUrl());
        }
        return list;
    }

    /* access modifiers changed from: private */
    /* renamed from: executeUseCase$lambda-8$lambda-7  reason: not valid java name */
    public static final List m10792executeUseCase$lambda8$lambda7(GetCollectionUseCase getCollectionUseCase, RequestValues requestValues, List list) {
        Intrinsics.checkNotNullParameter(getCollectionUseCase, "this$0");
        Intrinsics.checkNotNullParameter(requestValues, "$requestValues");
        Intrinsics.checkNotNullParameter(list, "it");
        return getCollectionUseCase.addCollectionToList(requestValues, list);
    }

    @NotNull
    /* renamed from: e */
    public Flowable<List<VendorDisplayWrapper>> executeUseCase(@Nullable RequestValues requestValues) {
        if (requestValues == null) {
            throw new Exception("Get Collection error in mapping");
        } else if (!requestValues.getVendorsList().isEmpty()) {
            Flowable<R> map = this.mVendorRepository.getCollections().map(new a(requestValues)).map(new b(this)).map(new c(requestValues)).map(new d(this, requestValues));
            Intrinsics.checkNotNullExpressionValue(map, "{\n                mVendo…lues, it) }\n            }");
            return map;
        } else {
            Flowable<List<VendorDisplayWrapper>> just = Flowable.just(requestValues.getVendorsList());
            Intrinsics.checkNotNullExpressionValue(just, "{\n                Flowab…endorsList)\n            }");
            return just;
        }
    }
}
