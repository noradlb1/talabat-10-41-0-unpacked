package com.talabat.sdsquad.data.vendorslist;

import com.talabat.sdsquad.data.vendorslist.response.ActiveEvent;
import com.talabat.sdsquad.data.vendorslist.response.Vendor;
import com.talabat.sdsquad.data.vendorslist.response.VendorsListResponse;
import com.talabat.sdsquad.data.vendorslist.response.VendorsListResult;
import io.reactivex.Flowable;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import yt.a;

@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\u0018\u0000 \u00172\u00020\u0001:\u0001\u0017B\u000f\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\n\u0010\u0007\u001a\u0004\u0018\u00010\bH\u0016J\u0012\u0010\t\u001a\u0004\u0018\u00010\n2\u0006\u0010\u000b\u001a\u00020\fH\u0016J&\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u00060\u000e2\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u0012H\u0016J\u001e\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00060\u000e2\u0006\u0010\u0015\u001a\u00020\u00122\u0006\u0010\u0016\u001a\u00020\u0012H\u0002R\u0010\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000¨\u0006\u0018"}, d2 = {"Lcom/talabat/sdsquad/data/vendorslist/VendorRepositoryImp;", "Lcom/talabat/sdsquad/data/vendorslist/VendorRepository;", "vendorsApi", "Lcom/talabat/sdsquad/data/vendorslist/VendorsApi;", "(Lcom/talabat/sdsquad/data/vendorslist/VendorsApi;)V", "cachedVendorsListResponse", "Lcom/talabat/sdsquad/data/vendorslist/response/VendorsListResponse;", "getPolygonEvent", "Lcom/talabat/sdsquad/data/vendorslist/response/ActiveEvent;", "getVendorById", "Lcom/talabat/sdsquad/data/vendorslist/response/Vendor;", "vendorId", "", "getVendors", "Lio/reactivex/Flowable;", "isForceUpdate", "", "latitude", "", "longitude", "loadVendors", "lat", "long", "Companion", "com_talabat_NewArchi_sdsquad_sdsquad"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class VendorRepositoryImp implements VendorRepository {
    @NotNull
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    /* access modifiers changed from: private */
    @Nullable
    public static VendorRepositoryImp INSTANCE;
    @Nullable
    private VendorsListResponse cachedVendorsListResponse;
    @NotNull
    private final VendorsApi vendorsApi;

    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\b\u0010\u0005\u001a\u00020\u0006H\u0007J\u0010\u0010\u0007\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\tH\u0007R\u0010\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u000e¢\u0006\u0002\n\u0000¨\u0006\n"}, d2 = {"Lcom/talabat/sdsquad/data/vendorslist/VendorRepositoryImp$Companion;", "", "()V", "INSTANCE", "Lcom/talabat/sdsquad/data/vendorslist/VendorRepositoryImp;", "destroyInstance", "", "getInstance", "vendorsApi", "Lcom/talabat/sdsquad/data/vendorslist/VendorsApi;", "com_talabat_NewArchi_sdsquad_sdsquad"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @JvmStatic
        public final void destroyInstance() {
            VendorRepositoryImp.INSTANCE = null;
        }

        @JvmStatic
        @NotNull
        public final VendorRepositoryImp getInstance(@NotNull VendorsApi vendorsApi) {
            VendorRepositoryImp access$getINSTANCE$cp;
            Intrinsics.checkNotNullParameter(vendorsApi, "vendorsApi");
            VendorRepositoryImp access$getINSTANCE$cp2 = VendorRepositoryImp.INSTANCE;
            if (access$getINSTANCE$cp2 != null) {
                return access$getINSTANCE$cp2;
            }
            synchronized (VendorRepositoryImp.class) {
                access$getINSTANCE$cp = VendorRepositoryImp.INSTANCE;
                if (access$getINSTANCE$cp == null) {
                    access$getINSTANCE$cp = new VendorRepositoryImp(vendorsApi, (DefaultConstructorMarker) null);
                    VendorRepositoryImp.INSTANCE = access$getINSTANCE$cp;
                }
            }
            return access$getINSTANCE$cp;
        }
    }

    private VendorRepositoryImp(VendorsApi vendorsApi2) {
        this.vendorsApi = vendorsApi2;
    }

    public /* synthetic */ VendorRepositoryImp(VendorsApi vendorsApi2, DefaultConstructorMarker defaultConstructorMarker) {
        this(vendorsApi2);
    }

    @JvmStatic
    public static final void destroyInstance() {
        Companion.destroyInstance();
    }

    @JvmStatic
    @NotNull
    public static final VendorRepositoryImp getInstance(@NotNull VendorsApi vendorsApi2) {
        return Companion.getInstance(vendorsApi2);
    }

    private final Flowable<VendorsListResponse> loadVendors(String str, String str2) {
        Flowable<VendorsListResponse> doOnNext = this.vendorsApi.getPolygonVendors(str, str2).doOnNext(new a(this));
        Intrinsics.checkNotNullExpressionValue(doOnNext, "vendorsApi.getPolygonVen…sponse = it\n            }");
        return doOnNext;
    }

    /* access modifiers changed from: private */
    /* renamed from: loadVendors$lambda-2  reason: not valid java name */
    public static final void m10779loadVendors$lambda2(VendorRepositoryImp vendorRepositoryImp, VendorsListResponse vendorsListResponse) {
        Intrinsics.checkNotNullParameter(vendorRepositoryImp, "this$0");
        vendorRepositoryImp.cachedVendorsListResponse = vendorsListResponse;
    }

    @Nullable
    public ActiveEvent getPolygonEvent() {
        VendorsListResult result;
        VendorsListResponse vendorsListResponse = this.cachedVendorsListResponse;
        if (vendorsListResponse == null || (result = vendorsListResponse.getResult()) == null) {
            return null;
        }
        return result.getActiveEvent();
    }

    @Nullable
    public Vendor getVendorById(int i11) {
        VendorsListResult vendorsListResult;
        List<Vendor> list;
        List<Vendor> list2;
        Integer id2;
        VendorsListResult result;
        VendorsListResult result2;
        VendorsListResponse vendorsListResponse = this.cachedVendorsListResponse;
        if (vendorsListResponse != null) {
            if (vendorsListResponse != null) {
                vendorsListResult = vendorsListResponse.getResult();
            } else {
                vendorsListResult = null;
            }
            if (vendorsListResult != null) {
                VendorsListResponse vendorsListResponse2 = this.cachedVendorsListResponse;
                if (vendorsListResponse2 == null || (result2 = vendorsListResponse2.getResult()) == null) {
                    list = null;
                } else {
                    list = result2.getVendors();
                }
                if (list != null) {
                    VendorsListResponse vendorsListResponse3 = this.cachedVendorsListResponse;
                    if (vendorsListResponse3 == null || (result = vendorsListResponse3.getResult()) == null) {
                        list2 = null;
                    } else {
                        list2 = result.getVendors();
                    }
                    Intrinsics.checkNotNull(list2);
                    for (Vendor vendor : list2) {
                        if (vendor != null && (id2 = vendor.getId()) != null && id2.intValue() == i11) {
                            return vendor;
                        }
                    }
                }
            }
        }
        return null;
    }

    @NotNull
    public Flowable<VendorsListResponse> getVendors(boolean z11, @NotNull String str, @NotNull String str2) {
        Intrinsics.checkNotNullParameter(str, "latitude");
        Intrinsics.checkNotNullParameter(str2, "longitude");
        VendorsListResponse vendorsListResponse = this.cachedVendorsListResponse;
        if (vendorsListResponse == null || z11) {
            return loadVendors(str, str2);
        }
        Flowable<VendorsListResponse> just = Flowable.just(vendorsListResponse);
        Intrinsics.checkNotNullExpressionValue(just, "{\n            Flowable.j…rsListResponse)\n        }");
        return just;
    }
}
