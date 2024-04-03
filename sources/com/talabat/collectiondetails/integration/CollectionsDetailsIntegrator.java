package com.talabat.collectiondetails.integration;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.JvmName;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0006\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\"\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u00048GX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0003\u0010\u0006\"\u0004\b\u0007\u0010\bR7\u0010\t\u001a\u001d\u0012\u0013\u0012\u00110\u000b¢\u0006\f\b\f\u0012\b\b\r\u0012\u0004\b\b(\u000e\u0012\u0004\u0012\u00020\u00050\n8GX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\t\u0010\u000f\"\u0004\b\u0010\u0010\u0011¨\u0006\u0012"}, d2 = {"Lcom/talabat/collectiondetails/integration/CollectionsDetailsIntegrator;", "", "()V", "pauseBannerForNextScreen", "Lkotlin/Function0;", "", "()Lkotlin/jvm/functions/Function0;", "setPauseBannerForNextScreen", "(Lkotlin/jvm/functions/Function0;)V", "updateTrackingChannel", "Lkotlin/Function1;", "", "Lkotlin/ParameterName;", "name", "channel", "()Lkotlin/jvm/functions/Function1;", "setUpdateTrackingChannel", "(Lkotlin/jvm/functions/Function1;)V", "com_talabat_Components_collectiondetails_collectiondetails"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class CollectionsDetailsIntegrator {
    @NotNull
    public static final CollectionsDetailsIntegrator INSTANCE = new CollectionsDetailsIntegrator();
    @NotNull
    private static Function0<Unit> pauseBannerForNextScreen = CollectionsDetailsIntegrator$pauseBannerForNextScreen$1.INSTANCE;
    @NotNull
    private static Function1<? super String, Unit> updateTrackingChannel = CollectionsDetailsIntegrator$updateTrackingChannel$1.INSTANCE;

    private CollectionsDetailsIntegrator() {
    }

    @NotNull
    @JvmName(name = "pauseBannerForNextScreen")
    public final Function0<Unit> pauseBannerForNextScreen() {
        return pauseBannerForNextScreen;
    }

    public final void setPauseBannerForNextScreen(@NotNull Function0<Unit> function0) {
        Intrinsics.checkNotNullParameter(function0, "<set-?>");
        pauseBannerForNextScreen = function0;
    }

    public final void setUpdateTrackingChannel(@NotNull Function1<? super String, Unit> function1) {
        Intrinsics.checkNotNullParameter(function1, "<set-?>");
        updateTrackingChannel = function1;
    }

    @NotNull
    @JvmName(name = "updateTrackingChannel")
    public final Function1<String, Unit> updateTrackingChannel() {
        return updateTrackingChannel;
    }
}
