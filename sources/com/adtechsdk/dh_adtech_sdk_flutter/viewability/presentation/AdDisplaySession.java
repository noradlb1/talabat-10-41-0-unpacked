package com.adtechsdk.dh_adtech_sdk_flutter.viewability.presentation;

import android.content.Context;
import android.view.View;
import com.adtechsdk.dh_adtech_sdk_flutter.viewability.ViewabilityMethodChannel;
import com.adtechsdk.dh_adtech_sdk_flutter.viewability.data.ViewabilityRepository;
import com.adtechsdk.dh_adtech_sdk_flutter.viewability.entities.Creative;
import com.adtechsdk.dh_adtech_sdk_flutter.viewability.entities.DisplayViewabilitySession;
import java.util.concurrent.CancellationException;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineDispatcher;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.Job;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0000\u0018\u00002\u00020\u0001B7\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\u000b\u0012\u0006\u0010\f\u001a\u00020\r¢\u0006\u0002\u0010\u000eJ\u0006\u0010\u0013\u001a\u00020\u0014J\u000e\u0010\u0015\u001a\u00020\u00142\u0006\u0010\u0016\u001a\u00020\u0017J\u0010\u0010\u0018\u001a\u00020\u00142\u0006\u0010\u0016\u001a\u00020\u0017H\u0002R\u000e\u0010\f\u001a\u00020\rX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u000f\u001a\u0004\u0018\u00010\u0010X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0011\u001a\u0004\u0018\u00010\u0012X\u000e¢\u0006\u0002\n\u0000¨\u0006\u0019"}, d2 = {"Lcom/adtechsdk/dh_adtech_sdk_flutter/viewability/presentation/AdDisplaySession;", "", "context", "Landroid/content/Context;", "sdkScope", "Lkotlinx/coroutines/CoroutineScope;", "creative", "Lcom/adtechsdk/dh_adtech_sdk_flutter/viewability/entities/Creative;", "mainDispatcher", "Lkotlinx/coroutines/CoroutineDispatcher;", "viewabilityMethodChannel", "Lcom/adtechsdk/dh_adtech_sdk_flutter/viewability/ViewabilityMethodChannel;", "adViewabilityRepository", "Lcom/adtechsdk/dh_adtech_sdk_flutter/viewability/data/ViewabilityRepository;", "(Landroid/content/Context;Lkotlinx/coroutines/CoroutineScope;Lcom/adtechsdk/dh_adtech_sdk_flutter/viewability/entities/Creative;Lkotlinx/coroutines/CoroutineDispatcher;Lcom/adtechsdk/dh_adtech_sdk_flutter/viewability/ViewabilityMethodChannel;Lcom/adtechsdk/dh_adtech_sdk_flutter/viewability/data/ViewabilityRepository;)V", "createViewabilitySessionJob", "Lkotlinx/coroutines/Job;", "viewabilitySession", "Lcom/adtechsdk/dh_adtech_sdk_flutter/viewability/entities/DisplayViewabilitySession;", "finish", "", "start", "adView", "Landroid/view/View;", "startViewabilitySession", "dh_adtech_sdk_flutter_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class AdDisplaySession {
    /* access modifiers changed from: private */
    @NotNull
    public final ViewabilityRepository adViewabilityRepository;
    /* access modifiers changed from: private */
    @NotNull
    public final Context context;
    @Nullable
    private Job createViewabilitySessionJob;
    @Nullable
    private final Creative creative;
    @NotNull
    private final CoroutineDispatcher mainDispatcher;
    @NotNull
    private final CoroutineScope sdkScope;
    /* access modifiers changed from: private */
    @NotNull
    public final ViewabilityMethodChannel viewabilityMethodChannel;
    /* access modifiers changed from: private */
    @Nullable
    public DisplayViewabilitySession viewabilitySession;

    public AdDisplaySession(@NotNull Context context2, @NotNull CoroutineScope coroutineScope, @Nullable Creative creative2, @NotNull CoroutineDispatcher coroutineDispatcher, @NotNull ViewabilityMethodChannel viewabilityMethodChannel2, @NotNull ViewabilityRepository viewabilityRepository) {
        Intrinsics.checkNotNullParameter(context2, "context");
        Intrinsics.checkNotNullParameter(coroutineScope, "sdkScope");
        Intrinsics.checkNotNullParameter(coroutineDispatcher, "mainDispatcher");
        Intrinsics.checkNotNullParameter(viewabilityMethodChannel2, "viewabilityMethodChannel");
        Intrinsics.checkNotNullParameter(viewabilityRepository, "adViewabilityRepository");
        this.context = context2;
        this.sdkScope = coroutineScope;
        this.creative = creative2;
        this.mainDispatcher = coroutineDispatcher;
        this.viewabilityMethodChannel = viewabilityMethodChannel2;
        this.adViewabilityRepository = viewabilityRepository;
    }

    /* access modifiers changed from: private */
    public final void startViewabilitySession(View view) {
        try {
            DisplayViewabilitySession displayViewabilitySession = this.viewabilitySession;
            if (displayViewabilitySession != null) {
                displayViewabilitySession.start(view);
            }
            DisplayViewabilitySession displayViewabilitySession2 = this.viewabilitySession;
            if (displayViewabilitySession2 != null) {
                displayViewabilitySession2.trackLoaded();
            }
            DisplayViewabilitySession displayViewabilitySession3 = this.viewabilitySession;
            if (displayViewabilitySession3 != null) {
                displayViewabilitySession3.trackImpression();
            }
        } catch (Exception e11) {
            ViewabilityMethodChannel viewabilityMethodChannel2 = this.viewabilityMethodChannel;
            String message = e11.getMessage();
            if (message == null) {
                message = "";
            }
            viewabilityMethodChannel2.logError("Error Starting Display Viewability Session", message);
        }
    }

    public final void finish() {
        Job job = this.createViewabilitySessionJob;
        if (job != null) {
            Job.DefaultImpls.cancel$default(job, (CancellationException) null, 1, (Object) null);
        }
        this.createViewabilitySessionJob = null;
        DisplayViewabilitySession displayViewabilitySession = this.viewabilitySession;
        if (displayViewabilitySession != null) {
            displayViewabilitySession.finish();
        }
        this.viewabilitySession = null;
    }

    public final void start(@NotNull View view) {
        Intrinsics.checkNotNullParameter(view, "adView");
        Creative creative2 = this.creative;
        if (creative2 != null) {
            this.createViewabilitySessionJob = BuildersKt__Builders_commonKt.launch$default(this.sdkScope, this.mainDispatcher, (CoroutineStart) null, new AdDisplaySession$start$1(this, creative2, view, (Continuation<? super AdDisplaySession$start$1>) null), 2, (Object) null);
        }
    }
}
