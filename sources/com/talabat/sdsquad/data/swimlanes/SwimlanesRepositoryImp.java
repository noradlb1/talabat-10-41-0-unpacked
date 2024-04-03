package com.talabat.sdsquad.data.swimlanes;

import com.talabat.sdsquad.data.swimlanes.responses.Result;
import com.talabat.sdsquad.data.swimlanes.responses.SwimLane;
import com.talabat.sdsquad.data.swimlanes.responses.SwimlanesResponse;
import com.talabat.sdsquad.data.vendorslist.VendorsApi;
import io.reactivex.Flowable;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import xt.a;
import xt.b;

@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\u0018\u0000 \u00142\u00020\u0001:\u0001\u0014B\u000f\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0010\u0010\u0007\u001a\n\u0012\u0004\u0012\u00020\t\u0018\u00010\bH\u0016J6\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00060\u000b2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u0011\u001a\u00020\u000f2\u0006\u0010\u0012\u001a\u00020\u000fH\u0016J.\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00060\u000b2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u0011\u001a\u00020\u000f2\u0006\u0010\u0012\u001a\u00020\u000fH\u0002R\u0010\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000¨\u0006\u0015"}, d2 = {"Lcom/talabat/sdsquad/data/swimlanes/SwimlanesRepositoryImp;", "Lcom/talabat/sdsquad/data/swimlanes/SwimlanesRepository;", "vendorsApi", "Lcom/talabat/sdsquad/data/vendorslist/VendorsApi;", "(Lcom/talabat/sdsquad/data/vendorslist/VendorsApi;)V", "cachedVendorsListResponse", "Lcom/talabat/sdsquad/data/swimlanes/responses/SwimlanesResponse;", "getSwimlanes", "", "Lcom/talabat/sdsquad/data/swimlanes/responses/SwimLane;", "getSwimlanesResponse", "Lio/reactivex/Flowable;", "isForceUpdate", "", "latitude", "", "longitude", "areaId", "countryCode", "loadSwimlanes", "Companion", "com_talabat_NewArchi_sdsquad_sdsquad"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class SwimlanesRepositoryImp implements SwimlanesRepository {
    @NotNull
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    /* access modifiers changed from: private */
    @Nullable
    public static SwimlanesRepositoryImp INSTANCE;
    @Nullable
    private SwimlanesResponse cachedVendorsListResponse;
    @NotNull
    private final VendorsApi vendorsApi;

    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\b\u0010\u0005\u001a\u00020\u0006H\u0007J\u0010\u0010\u0007\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\tH\u0007R\u0010\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u000e¢\u0006\u0002\n\u0000¨\u0006\n"}, d2 = {"Lcom/talabat/sdsquad/data/swimlanes/SwimlanesRepositoryImp$Companion;", "", "()V", "INSTANCE", "Lcom/talabat/sdsquad/data/swimlanes/SwimlanesRepositoryImp;", "destroyInstance", "", "getInstance", "vendorsApi", "Lcom/talabat/sdsquad/data/vendorslist/VendorsApi;", "com_talabat_NewArchi_sdsquad_sdsquad"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @JvmStatic
        public final void destroyInstance() {
            SwimlanesRepositoryImp.INSTANCE = null;
        }

        @JvmStatic
        @NotNull
        public final SwimlanesRepositoryImp getInstance(@NotNull VendorsApi vendorsApi) {
            SwimlanesRepositoryImp access$getINSTANCE$cp;
            Intrinsics.checkNotNullParameter(vendorsApi, "vendorsApi");
            SwimlanesRepositoryImp access$getINSTANCE$cp2 = SwimlanesRepositoryImp.INSTANCE;
            if (access$getINSTANCE$cp2 != null) {
                return access$getINSTANCE$cp2;
            }
            synchronized (SwimlanesRepositoryImp.class) {
                access$getINSTANCE$cp = SwimlanesRepositoryImp.INSTANCE;
                if (access$getINSTANCE$cp == null) {
                    access$getINSTANCE$cp = new SwimlanesRepositoryImp(vendorsApi, (DefaultConstructorMarker) null);
                    SwimlanesRepositoryImp.INSTANCE = access$getINSTANCE$cp;
                }
            }
            return access$getINSTANCE$cp;
        }
    }

    private SwimlanesRepositoryImp(VendorsApi vendorsApi2) {
        this.vendorsApi = vendorsApi2;
    }

    public /* synthetic */ SwimlanesRepositoryImp(VendorsApi vendorsApi2, DefaultConstructorMarker defaultConstructorMarker) {
        this(vendorsApi2);
    }

    @JvmStatic
    public static final void destroyInstance() {
        Companion.destroyInstance();
    }

    @JvmStatic
    @NotNull
    public static final SwimlanesRepositoryImp getInstance(@NotNull VendorsApi vendorsApi2) {
        return Companion.getInstance(vendorsApi2);
    }

    private final Flowable<SwimlanesResponse> loadSwimlanes(String str, String str2, String str3, String str4) {
        Flowable<SwimlanesResponse> onErrorReturn = this.vendorsApi.getSwimlane(str, str2, str3, str4).doOnNext(new a(this)).onErrorReturn(new b());
        Intrinsics.checkNotNullExpressionValue(onErrorReturn, "vendorsApi.getSwimlane(l…null, null)\n            }");
        return onErrorReturn;
    }

    /* access modifiers changed from: private */
    /* renamed from: loadSwimlanes$lambda-0  reason: not valid java name */
    public static final void m10777loadSwimlanes$lambda0(SwimlanesRepositoryImp swimlanesRepositoryImp, SwimlanesResponse swimlanesResponse) {
        Intrinsics.checkNotNullParameter(swimlanesRepositoryImp, "this$0");
        swimlanesRepositoryImp.cachedVendorsListResponse = swimlanesResponse;
    }

    /* access modifiers changed from: private */
    /* renamed from: loadSwimlanes$lambda-1  reason: not valid java name */
    public static final SwimlanesResponse m10778loadSwimlanes$lambda1(Throwable th2) {
        Intrinsics.checkNotNullParameter(th2, "it");
        return new SwimlanesResponse((String) null, (Result) null, (String) null);
    }

    @Nullable
    public List<SwimLane> getSwimlanes() {
        Result result;
        SwimlanesResponse swimlanesResponse = this.cachedVendorsListResponse;
        if (swimlanesResponse == null || (result = swimlanesResponse.getResult()) == null) {
            return null;
        }
        return result.getSwimLanes();
    }

    @NotNull
    public Flowable<SwimlanesResponse> getSwimlanesResponse(boolean z11, @NotNull String str, @NotNull String str2, @NotNull String str3, @NotNull String str4) {
        Intrinsics.checkNotNullParameter(str, "latitude");
        Intrinsics.checkNotNullParameter(str2, "longitude");
        Intrinsics.checkNotNullParameter(str3, "areaId");
        Intrinsics.checkNotNullParameter(str4, "countryCode");
        SwimlanesResponse swimlanesResponse = this.cachedVendorsListResponse;
        if (swimlanesResponse == null || z11) {
            return loadSwimlanes(str, str2, str3, str4);
        }
        Flowable<SwimlanesResponse> just = Flowable.just(swimlanesResponse);
        Intrinsics.checkNotNullExpressionValue(just, "{\n            Flowable.j…rsListResponse)\n        }");
        return just;
    }
}
