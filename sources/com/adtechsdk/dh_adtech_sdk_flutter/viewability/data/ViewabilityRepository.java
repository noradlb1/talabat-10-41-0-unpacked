package com.adtechsdk.dh_adtech_sdk_flutter.viewability.data;

import android.content.Context;
import com.adtechsdk.dh_adtech_sdk_flutter.viewability.entities.Creative;
import com.adtechsdk.dh_adtech_sdk_flutter.viewability.entities.DisplayViewabilitySession;
import com.adtechsdk.dh_adtech_sdk_flutter.viewability.entities.TrackerData;
import com.iab.omid.library.deliveryhero3.adsession.VerificationScriptResource;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineDispatcher;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0000\u0018\u00002\u00020\u0001B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ!\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u000f2\u0006\u0010\u0017\u001a\u00020\u0018H@ø\u0001\u0000¢\u0006\u0002\u0010\u0019R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nXD¢\u0006\u0002\n\u0000R4\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\r0\f*\u00020\u000f2\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\r0\f8B@BX\u000e¢\u0006\f\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013\u0002\u0004\n\u0002\b\u0019¨\u0006\u001a"}, d2 = {"Lcom/adtechsdk/dh_adtech_sdk_flutter/viewability/data/ViewabilityRepository;", "", "mainDispatcher", "Lkotlinx/coroutines/CoroutineDispatcher;", "omSdkDataSource", "Lcom/adtechsdk/dh_adtech_sdk_flutter/viewability/data/OmSdkDataSource;", "omJsSdkDataSource", "Lcom/adtechsdk/dh_adtech_sdk_flutter/viewability/data/OmJsSdkDataSource;", "(Lkotlinx/coroutines/CoroutineDispatcher;Lcom/adtechsdk/dh_adtech_sdk_flutter/viewability/data/OmSdkDataSource;Lcom/adtechsdk/dh_adtech_sdk_flutter/viewability/data/OmJsSdkDataSource;)V", "partnerName", "", "<anonymous parameter 0>", "", "Lcom/iab/omid/library/deliveryhero3/adsession/VerificationScriptResource;", "verificationScriptResources", "Lcom/adtechsdk/dh_adtech_sdk_flutter/viewability/entities/Creative;", "getVerificationScriptResources", "(Lcom/adtechsdk/dh_adtech_sdk_flutter/viewability/entities/Creative;)Ljava/util/List;", "setVerificationScriptResources", "(Lcom/adtechsdk/dh_adtech_sdk_flutter/viewability/entities/Creative;Ljava/util/List;)V", "createDisplayViewabilitySession", "Lcom/adtechsdk/dh_adtech_sdk_flutter/viewability/entities/DisplayViewabilitySession;", "creative", "context", "Landroid/content/Context;", "(Lcom/adtechsdk/dh_adtech_sdk_flutter/viewability/entities/Creative;Landroid/content/Context;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "dh_adtech_sdk_flutter_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class ViewabilityRepository {
    @NotNull
    private final CoroutineDispatcher mainDispatcher;
    /* access modifiers changed from: private */
    @NotNull
    public final OmJsSdkDataSource omJsSdkDataSource;
    /* access modifiers changed from: private */
    @NotNull
    public final OmSdkDataSource omSdkDataSource;
    /* access modifiers changed from: private */
    @NotNull
    public final String partnerName = "com.deliveryhero.adtechsdk_flutter";

    public ViewabilityRepository(@NotNull CoroutineDispatcher coroutineDispatcher, @NotNull OmSdkDataSource omSdkDataSource2, @NotNull OmJsSdkDataSource omJsSdkDataSource2) {
        Intrinsics.checkNotNullParameter(coroutineDispatcher, "mainDispatcher");
        Intrinsics.checkNotNullParameter(omSdkDataSource2, "omSdkDataSource");
        Intrinsics.checkNotNullParameter(omJsSdkDataSource2, "omJsSdkDataSource");
        this.mainDispatcher = coroutineDispatcher;
        this.omSdkDataSource = omSdkDataSource2;
        this.omJsSdkDataSource = omJsSdkDataSource2;
    }

    /* access modifiers changed from: private */
    public final List<VerificationScriptResource> getVerificationScriptResources(Creative creative) {
        ArrayList arrayList = new ArrayList();
        for (TrackerData tryCreateVerificationScriptResource : creative.getTrackers()) {
            VerificationScriptResource tryCreateVerificationScriptResource2 = TrackerDataExtensionKt.tryCreateVerificationScriptResource(tryCreateVerificationScriptResource);
            if (tryCreateVerificationScriptResource2 != null) {
                arrayList.add(tryCreateVerificationScriptResource2);
            }
        }
        return CollectionsKt___CollectionsKt.toList(arrayList);
    }

    private final void setVerificationScriptResources(Creative creative, List<VerificationScriptResource> list) {
    }

    @Nullable
    public final Object createDisplayViewabilitySession(@NotNull Creative creative, @NotNull Context context, @NotNull Continuation<? super DisplayViewabilitySession> continuation) {
        return BuildersKt.withContext(this.mainDispatcher, new ViewabilityRepository$createDisplayViewabilitySession$2(this, context, creative, (Continuation<? super ViewabilityRepository$createDisplayViewabilitySession$2>) null), continuation);
    }
}
