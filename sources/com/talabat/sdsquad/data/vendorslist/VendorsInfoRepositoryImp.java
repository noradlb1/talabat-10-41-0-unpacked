package com.talabat.sdsquad.data.vendorslist;

import com.talabat.sdsquad.data.vendorslist.requests.VendorInfoRequest;
import com.talabat.sdsquad.data.vendorslist.response.Collections;
import com.talabat.sdsquad.data.vendorslist.response.Cuisine;
import com.talabat.sdsquad.data.vendorslist.response.Filter;
import com.talabat.sdsquad.data.vendorslist.response.Result;
import com.talabat.sdsquad.data.vendorslist.response.VendorsInfoResponse;
import io.reactivex.Flowable;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import yt.b;

@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u0000 \u00152\u00020\u0001:\u0001\u0015B\u000f\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0014\u0010\u0007\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\n0\t0\bH\u0016J\u0014\u0010\u000b\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\f0\t0\bH\u0016J\u0014\u0010\r\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000e0\t0\bH\u0016J\u001e\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00060\b2\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u0013H\u0016J\u0016\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00060\b2\u0006\u0010\u0012\u001a\u00020\u0013H\u0002R\u0010\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000¨\u0006\u0016"}, d2 = {"Lcom/talabat/sdsquad/data/vendorslist/VendorsInfoRepositoryImp;", "Lcom/talabat/sdsquad/data/vendorslist/VendorsInfoRepository;", "vendorsApi", "Lcom/talabat/sdsquad/data/vendorslist/VendorsApi;", "(Lcom/talabat/sdsquad/data/vendorslist/VendorsApi;)V", "cachedVendorsListResponse", "Lcom/talabat/sdsquad/data/vendorslist/response/VendorsInfoResponse;", "getCollections", "Lio/reactivex/Flowable;", "", "Lcom/talabat/sdsquad/data/vendorslist/response/Collections;", "getCuisines", "Lcom/talabat/sdsquad/data/vendorslist/response/Cuisine;", "getFilters", "Lcom/talabat/sdsquad/data/vendorslist/response/Filter;", "getVendorInfo", "isForceUpdate", "", "vendorInfoRequest", "Lcom/talabat/sdsquad/data/vendorslist/requests/VendorInfoRequest;", "loadVendorsInfo", "Companion", "com_talabat_NewArchi_sdsquad_sdsquad"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class VendorsInfoRepositoryImp implements VendorsInfoRepository {
    @NotNull
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    /* access modifiers changed from: private */
    @Nullable
    public static VendorsInfoRepositoryImp INSTANCE;
    @Nullable
    private VendorsInfoResponse cachedVendorsListResponse;
    @NotNull
    private final VendorsApi vendorsApi;

    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\b\u0010\u0005\u001a\u00020\u0006H\u0007J\u0010\u0010\u0007\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\tH\u0007R\u0010\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u000e¢\u0006\u0002\n\u0000¨\u0006\n"}, d2 = {"Lcom/talabat/sdsquad/data/vendorslist/VendorsInfoRepositoryImp$Companion;", "", "()V", "INSTANCE", "Lcom/talabat/sdsquad/data/vendorslist/VendorsInfoRepositoryImp;", "destroyInstance", "", "getInstance", "vendorsApi", "Lcom/talabat/sdsquad/data/vendorslist/VendorsApi;", "com_talabat_NewArchi_sdsquad_sdsquad"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @JvmStatic
        public final void destroyInstance() {
            VendorsInfoRepositoryImp.INSTANCE = null;
        }

        @JvmStatic
        @NotNull
        public final VendorsInfoRepositoryImp getInstance(@NotNull VendorsApi vendorsApi) {
            VendorsInfoRepositoryImp access$getINSTANCE$cp;
            Intrinsics.checkNotNullParameter(vendorsApi, "vendorsApi");
            VendorsInfoRepositoryImp access$getINSTANCE$cp2 = VendorsInfoRepositoryImp.INSTANCE;
            if (access$getINSTANCE$cp2 != null) {
                return access$getINSTANCE$cp2;
            }
            synchronized (VendorsInfoRepositoryImp.class) {
                access$getINSTANCE$cp = VendorsInfoRepositoryImp.INSTANCE;
                if (access$getINSTANCE$cp == null) {
                    access$getINSTANCE$cp = new VendorsInfoRepositoryImp(vendorsApi, (DefaultConstructorMarker) null);
                    VendorsInfoRepositoryImp.INSTANCE = access$getINSTANCE$cp;
                }
            }
            return access$getINSTANCE$cp;
        }
    }

    private VendorsInfoRepositoryImp(VendorsApi vendorsApi2) {
        this.vendorsApi = vendorsApi2;
    }

    public /* synthetic */ VendorsInfoRepositoryImp(VendorsApi vendorsApi2, DefaultConstructorMarker defaultConstructorMarker) {
        this(vendorsApi2);
    }

    @JvmStatic
    public static final void destroyInstance() {
        Companion.destroyInstance();
    }

    @JvmStatic
    @NotNull
    public static final VendorsInfoRepositoryImp getInstance(@NotNull VendorsApi vendorsApi2) {
        return Companion.getInstance(vendorsApi2);
    }

    private final Flowable<VendorsInfoResponse> loadVendorsInfo(VendorInfoRequest vendorInfoRequest) {
        Flowable<VendorsInfoResponse> doOnNext = this.vendorsApi.getVendorsInfo(vendorInfoRequest).doOnNext(new b(this));
        Intrinsics.checkNotNullExpressionValue(doOnNext, "vendorsApi.getVendorsInf…sponse = it\n            }");
        return doOnNext;
    }

    /* access modifiers changed from: private */
    /* renamed from: loadVendorsInfo$lambda-9  reason: not valid java name */
    public static final void m10780loadVendorsInfo$lambda9(VendorsInfoRepositoryImp vendorsInfoRepositoryImp, VendorsInfoResponse vendorsInfoResponse) {
        Intrinsics.checkNotNullParameter(vendorsInfoRepositoryImp, "this$0");
        vendorsInfoRepositoryImp.cachedVendorsListResponse = vendorsInfoResponse;
    }

    @NotNull
    public Flowable<List<Collections>> getCollections() {
        Result result;
        List<Collections> collections;
        VendorsInfoResponse vendorsInfoResponse = this.cachedVendorsListResponse;
        if (vendorsInfoResponse == null || (result = vendorsInfoResponse.getResult()) == null || (collections = result.getCollections()) == null) {
            Flowable<List<Collections>> just = Flowable.just(CollectionsKt__CollectionsKt.emptyList());
            Intrinsics.checkNotNullExpressionValue(just, "just(emptyList())");
            return just;
        }
        Flowable<List<Collections>> just2 = Flowable.just(collections);
        Intrinsics.checkNotNullExpressionValue(just2, "just(collections)");
        return just2;
    }

    @NotNull
    public Flowable<List<Cuisine>> getCuisines() {
        Result result;
        List<Cuisine> cuisines;
        VendorsInfoResponse vendorsInfoResponse = this.cachedVendorsListResponse;
        if (vendorsInfoResponse == null || (result = vendorsInfoResponse.getResult()) == null || (cuisines = result.getCuisines()) == null) {
            Flowable<List<Cuisine>> just = Flowable.just(CollectionsKt__CollectionsKt.emptyList());
            Intrinsics.checkNotNullExpressionValue(just, "just(emptyList())");
            return just;
        }
        Flowable<List<Cuisine>> just2 = Flowable.just(cuisines);
        Intrinsics.checkNotNullExpressionValue(just2, "just(cuisines)");
        return just2;
    }

    @NotNull
    public Flowable<List<Filter>> getFilters() {
        Result result;
        List<Filter> filters;
        VendorsInfoResponse vendorsInfoResponse = this.cachedVendorsListResponse;
        if (vendorsInfoResponse == null || (result = vendorsInfoResponse.getResult()) == null || (filters = result.getFilters()) == null) {
            Flowable<List<Filter>> just = Flowable.just(CollectionsKt__CollectionsKt.emptyList());
            Intrinsics.checkNotNullExpressionValue(just, "just(emptyList())");
            return just;
        }
        Flowable<List<Filter>> just2 = Flowable.just(filters);
        Intrinsics.checkNotNullExpressionValue(just2, "just(filters)");
        return just2;
    }

    @NotNull
    public Flowable<VendorsInfoResponse> getVendorInfo(boolean z11, @NotNull VendorInfoRequest vendorInfoRequest) {
        Intrinsics.checkNotNullParameter(vendorInfoRequest, "vendorInfoRequest");
        VendorsInfoResponse vendorsInfoResponse = this.cachedVendorsListResponse;
        if (vendorsInfoResponse == null || z11) {
            return loadVendorsInfo(vendorInfoRequest);
        }
        Flowable<VendorsInfoResponse> just = Flowable.just(vendorsInfoResponse);
        Intrinsics.checkNotNullExpressionValue(just, "{\n            Flowable.j…rsListResponse)\n        }");
        return just;
    }
}
