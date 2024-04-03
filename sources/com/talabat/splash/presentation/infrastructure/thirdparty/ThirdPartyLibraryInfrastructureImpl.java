package com.talabat.splash.presentation.infrastructure.thirdparty;

import android.content.Context;
import android.location.Address;
import android.location.Location;
import com.facebook.FacebookSdk;
import com.talabat.core.dispatcher.domain.CoroutineDispatchersFactory;
import com.talabat.splash.domain.model.AppInfoGlobalCountryWrapper;
import java.util.List;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import org.jetbrains.annotations.NotNull;
import tracking.TalabatAdjust;

@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u001f\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ!\u0010\t\u001a\n\u0012\u0004\u0012\u00020\u000b\u0018\u00010\n2\u0006\u0010\f\u001a\u00020\rH@ø\u0001\u0000¢\u0006\u0002\u0010\u000eJ\u0019\u0010\u000f\u001a\u00020\u00102\u0006\u0010\f\u001a\u00020\rH@ø\u0001\u0000¢\u0006\u0002\u0010\u000eJ\b\u0010\u0011\u001a\u00020\u0010H\u0016J\b\u0010\u0012\u001a\u00020\u0010H\u0016R\u000e\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0004¢\u0006\u0002\n\u0000\u0002\u0004\n\u0002\b\u0019¨\u0006\u0013"}, d2 = {"Lcom/talabat/splash/presentation/infrastructure/thirdparty/ThirdPartyLibraryInfrastructureImpl;", "Lcom/talabat/splash/presentation/infrastructure/thirdparty/ThirdPartyLibraryInfrastructure;", "context", "Landroid/content/Context;", "appInfoGlobalCountryWrapper", "Lcom/talabat/splash/domain/model/AppInfoGlobalCountryWrapper;", "dispatchersFactory", "Lcom/talabat/core/dispatcher/domain/CoroutineDispatchersFactory;", "(Landroid/content/Context;Lcom/talabat/splash/domain/model/AppInfoGlobalCountryWrapper;Lcom/talabat/core/dispatcher/domain/CoroutineDispatchersFactory;)V", "getFromLocation", "", "Landroid/location/Address;", "location", "Landroid/location/Location;", "(Landroid/location/Location;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getReverseGeoCodeCountry", "", "initAdjust", "initFacebookSDK", "com_talabat_talabat_talabat"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class ThirdPartyLibraryInfrastructureImpl implements ThirdPartyLibraryInfrastructure {
    @NotNull
    private final AppInfoGlobalCountryWrapper appInfoGlobalCountryWrapper;
    /* access modifiers changed from: private */
    @NotNull
    public final Context context;
    @NotNull
    private final CoroutineDispatchersFactory dispatchersFactory;

    @Inject
    public ThirdPartyLibraryInfrastructureImpl(@NotNull Context context2, @NotNull AppInfoGlobalCountryWrapper appInfoGlobalCountryWrapper2, @NotNull CoroutineDispatchersFactory coroutineDispatchersFactory) {
        Intrinsics.checkNotNullParameter(context2, "context");
        Intrinsics.checkNotNullParameter(appInfoGlobalCountryWrapper2, "appInfoGlobalCountryWrapper");
        Intrinsics.checkNotNullParameter(coroutineDispatchersFactory, "dispatchersFactory");
        this.context = context2;
        this.appInfoGlobalCountryWrapper = appInfoGlobalCountryWrapper2;
        this.dispatchersFactory = coroutineDispatchersFactory;
    }

    /* access modifiers changed from: private */
    public final Object getFromLocation(Location location, Continuation<? super List<? extends Address>> continuation) {
        return BuildersKt.withContext(this.dispatchersFactory.io(), new ThirdPartyLibraryInfrastructureImpl$getFromLocation$2(this, location, (Continuation<? super ThirdPartyLibraryInfrastructureImpl$getFromLocation$2>) null), continuation);
    }

    /* JADX WARNING: Removed duplicated region for block: B:14:0x0035  */
    /* JADX WARNING: Removed duplicated region for block: B:24:0x0050 A[Catch:{ Exception -> 0x0064 }] */
    /* JADX WARNING: Removed duplicated region for block: B:25:0x0055 A[Catch:{ Exception -> 0x0064 }] */
    /* JADX WARNING: Removed duplicated region for block: B:27:0x0058 A[Catch:{ Exception -> 0x0064 }] */
    /* JADX WARNING: Removed duplicated region for block: B:29:0x005b A[Catch:{ Exception -> 0x0064 }] */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0023  */
    @org.jetbrains.annotations.Nullable
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public java.lang.Object getReverseGeoCodeCountry(@org.jetbrains.annotations.NotNull android.location.Location r5, @org.jetbrains.annotations.NotNull kotlin.coroutines.Continuation<? super kotlin.Unit> r6) {
        /*
            r4 = this;
            boolean r0 = r6 instanceof com.talabat.splash.presentation.infrastructure.thirdparty.ThirdPartyLibraryInfrastructureImpl$getReverseGeoCodeCountry$1
            if (r0 == 0) goto L_0x0013
            r0 = r6
            com.talabat.splash.presentation.infrastructure.thirdparty.ThirdPartyLibraryInfrastructureImpl$getReverseGeoCodeCountry$1 r0 = (com.talabat.splash.presentation.infrastructure.thirdparty.ThirdPartyLibraryInfrastructureImpl$getReverseGeoCodeCountry$1) r0
            int r1 = r0.f61513k
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L_0x0013
            int r1 = r1 - r2
            r0.f61513k = r1
            goto L_0x0018
        L_0x0013:
            com.talabat.splash.presentation.infrastructure.thirdparty.ThirdPartyLibraryInfrastructureImpl$getReverseGeoCodeCountry$1 r0 = new com.talabat.splash.presentation.infrastructure.thirdparty.ThirdPartyLibraryInfrastructureImpl$getReverseGeoCodeCountry$1
            r0.<init>(r4, r6)
        L_0x0018:
            java.lang.Object r6 = r0.f61511i
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.f61513k
            r3 = 1
            if (r2 == 0) goto L_0x0035
            if (r2 != r3) goto L_0x002d
            java.lang.Object r5 = r0.f61510h
            com.talabat.splash.presentation.infrastructure.thirdparty.ThirdPartyLibraryInfrastructureImpl r5 = (com.talabat.splash.presentation.infrastructure.thirdparty.ThirdPartyLibraryInfrastructureImpl) r5
            kotlin.ResultKt.throwOnFailure(r6)     // Catch:{ Exception -> 0x0064 }
            goto L_0x0044
        L_0x002d:
            java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
            java.lang.String r6 = "call to 'resume' before 'invoke' with coroutine"
            r5.<init>(r6)
            throw r5
        L_0x0035:
            kotlin.ResultKt.throwOnFailure(r6)
            r0.f61510h = r4     // Catch:{ Exception -> 0x0064 }
            r0.f61513k = r3     // Catch:{ Exception -> 0x0064 }
            java.lang.Object r6 = r4.getFromLocation(r5, r0)     // Catch:{ Exception -> 0x0064 }
            if (r6 != r1) goto L_0x0043
            return r1
        L_0x0043:
            r5 = r4
        L_0x0044:
            java.util.List r6 = (java.util.List) r6     // Catch:{ Exception -> 0x0064 }
            if (r6 == 0) goto L_0x0055
            java.lang.Object r6 = kotlin.collections.CollectionsKt___CollectionsKt.firstOrNull(r6)     // Catch:{ Exception -> 0x0064 }
            android.location.Address r6 = (android.location.Address) r6     // Catch:{ Exception -> 0x0064 }
            if (r6 == 0) goto L_0x0055
            java.lang.String r6 = r6.getCountryCode()     // Catch:{ Exception -> 0x0064 }
            goto L_0x0056
        L_0x0055:
            r6 = 0
        L_0x0056:
            if (r6 != 0) goto L_0x005b
            kotlin.Unit r5 = kotlin.Unit.INSTANCE     // Catch:{ Exception -> 0x0064 }
            return r5
        L_0x005b:
            int r6 = com.talabat.helpers.TalabatUtils.getGlobalCountryFromGeoCode(r6)     // Catch:{ Exception -> 0x0064 }
            com.talabat.splash.domain.model.AppInfoGlobalCountryWrapper r5 = r5.appInfoGlobalCountryWrapper     // Catch:{ Exception -> 0x0064 }
            r5.saveReverseGeoConuntry(r6)     // Catch:{ Exception -> 0x0064 }
        L_0x0064:
            kotlin.Unit r5 = kotlin.Unit.INSTANCE
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.talabat.splash.presentation.infrastructure.thirdparty.ThirdPartyLibraryInfrastructureImpl.getReverseGeoCodeCountry(android.location.Location, kotlin.coroutines.Continuation):java.lang.Object");
    }

    public void initAdjust() {
        TalabatAdjust.initializeAdjust(this.context);
    }

    public void initFacebookSDK() {
        FacebookSdk.sdkInitialize(this.context);
    }
}
