package com.talabat.sdsquad.data.darkstors;

import com.talabat.sdsquad.data.darkstors.responses.DarkStoreResponse;
import com.talabat.sdsquad.data.vendorslist.VendorsApi;
import com.talabat.sdsquad.data.vendorslist.response.Vendor;
import io.reactivex.Flowable;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import vt.a;
import vt.b;

@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 \u00122\u00020\u0001:\u0001\u0012B\u000f\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J.\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00060\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u000eH\u0016J\n\u0010\u0010\u001a\u0004\u0018\u00010\u0011H\u0016R\u0010\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000¨\u0006\u0013"}, d2 = {"Lcom/talabat/sdsquad/data/darkstors/DarkStoreRepositoryImp;", "Lcom/talabat/sdsquad/data/darkstors/DarkStoreRepository;", "vendorsApi", "Lcom/talabat/sdsquad/data/vendorslist/VendorsApi;", "(Lcom/talabat/sdsquad/data/vendorslist/VendorsApi;)V", "cachedDarkStore", "Lcom/talabat/sdsquad/data/darkstors/responses/DarkStoreResponse;", "getDarkStore", "Lio/reactivex/Flowable;", "isForceUpdate", "", "areaId", "", "latitude", "", "longitude", "getDarkStoreObject", "Lcom/talabat/sdsquad/data/vendorslist/response/Vendor;", "Companion", "com_talabat_NewArchi_sdsquad_sdsquad"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class DarkStoreRepositoryImp implements DarkStoreRepository {
    @NotNull
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    /* access modifiers changed from: private */
    @Nullable
    public static DarkStoreRepositoryImp INSTANCE;
    @Nullable
    private DarkStoreResponse cachedDarkStore;
    @NotNull
    private final VendorsApi vendorsApi;

    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\b\u0010\u0005\u001a\u00020\u0006H\u0007J\u0010\u0010\u0007\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\tH\u0007R\u0010\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u000e¢\u0006\u0002\n\u0000¨\u0006\n"}, d2 = {"Lcom/talabat/sdsquad/data/darkstors/DarkStoreRepositoryImp$Companion;", "", "()V", "INSTANCE", "Lcom/talabat/sdsquad/data/darkstors/DarkStoreRepositoryImp;", "destroyInstance", "", "getInstance", "vendorsApi", "Lcom/talabat/sdsquad/data/vendorslist/VendorsApi;", "com_talabat_NewArchi_sdsquad_sdsquad"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @JvmStatic
        public final void destroyInstance() {
            DarkStoreRepositoryImp.INSTANCE = null;
        }

        @JvmStatic
        @NotNull
        public final DarkStoreRepositoryImp getInstance(@NotNull VendorsApi vendorsApi) {
            DarkStoreRepositoryImp access$getINSTANCE$cp;
            Intrinsics.checkNotNullParameter(vendorsApi, "vendorsApi");
            DarkStoreRepositoryImp access$getINSTANCE$cp2 = DarkStoreRepositoryImp.INSTANCE;
            if (access$getINSTANCE$cp2 != null) {
                return access$getINSTANCE$cp2;
            }
            synchronized (DarkStoreRepositoryImp.class) {
                access$getINSTANCE$cp = DarkStoreRepositoryImp.INSTANCE;
                if (access$getINSTANCE$cp == null) {
                    access$getINSTANCE$cp = new DarkStoreRepositoryImp(vendorsApi, (DefaultConstructorMarker) null);
                    DarkStoreRepositoryImp.INSTANCE = access$getINSTANCE$cp;
                }
            }
            return access$getINSTANCE$cp;
        }
    }

    private DarkStoreRepositoryImp(VendorsApi vendorsApi2) {
        this.vendorsApi = vendorsApi2;
    }

    public /* synthetic */ DarkStoreRepositoryImp(VendorsApi vendorsApi2, DefaultConstructorMarker defaultConstructorMarker) {
        this(vendorsApi2);
    }

    @JvmStatic
    public static final void destroyInstance() {
        Companion.destroyInstance();
    }

    /* access modifiers changed from: private */
    /* renamed from: getDarkStore$lambda-0  reason: not valid java name */
    public static final void m10773getDarkStore$lambda0(DarkStoreRepositoryImp darkStoreRepositoryImp, DarkStoreResponse darkStoreResponse) {
        Intrinsics.checkNotNullParameter(darkStoreRepositoryImp, "this$0");
        darkStoreRepositoryImp.cachedDarkStore = darkStoreResponse;
    }

    /* access modifiers changed from: private */
    /* renamed from: getDarkStore$lambda-1  reason: not valid java name */
    public static final void m10774getDarkStore$lambda1(Throwable th2) {
        new DarkStoreResponse((String) null, (String) null, (Boolean) null, (Object) null, (Vendor) null, 31, (DefaultConstructorMarker) null);
    }

    @JvmStatic
    @NotNull
    public static final DarkStoreRepositoryImp getInstance(@NotNull VendorsApi vendorsApi2) {
        return Companion.getInstance(vendorsApi2);
    }

    @NotNull
    public Flowable<DarkStoreResponse> getDarkStore(boolean z11, int i11, @NotNull String str, @NotNull String str2) {
        Intrinsics.checkNotNullParameter(str, "latitude");
        Intrinsics.checkNotNullParameter(str2, "longitude");
        DarkStoreResponse darkStoreResponse = this.cachedDarkStore;
        if (darkStoreResponse == null || z11) {
            Flowable<DarkStoreResponse> doOnError = this.vendorsApi.getDarkStoresInfo(i11, str, str2).doOnNext(new a(this)).doOnError(new b());
            Intrinsics.checkNotNullExpressionValue(doOnError, "{\n            vendorsApi…              }\n        }");
            return doOnError;
        }
        Flowable<DarkStoreResponse> just = Flowable.just(darkStoreResponse);
        Intrinsics.checkNotNullExpressionValue(just, "{\n            Flowable.j…achedDarkStore)\n        }");
        return just;
    }

    @Nullable
    public Vendor getDarkStoreObject() {
        DarkStoreResponse darkStoreResponse = this.cachedDarkStore;
        if (darkStoreResponse != null) {
            return darkStoreResponse.getResult();
        }
        return null;
    }
}
