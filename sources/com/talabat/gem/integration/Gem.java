package com.talabat.gem.integration;

import android.app.Application;
import com.talabat.configuration.di.ConfigurationRemoteCoreLibApi;
import com.talabat.core.di.ApiContainer;
import com.talabat.core.featureflag.domain.FeatureFlagCoreLibApi;
import com.talabat.core.navigation.domain.NavigationCoreLibApi;
import com.talabat.core.tracking.domain.TrackingCoreLibApi;
import com.talabat.gem.GemIntegrationDsl;
import com.talabat.gem.IntegrationKt;
import com.talabat.talabatcommon.extentions.CoroutinesKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.JvmName;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u00004\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a\u0016\u0010\u0013\u001a\u00020\u00142\f\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00140\bH\u0007\u001a&\u0010\u0016\u001a\u00020\u0014*\u00020\u00012\u0017\u0010\u0017\u001a\u0013\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020\u00140\u0018¢\u0006\u0002\b\u0019H\u0004\u001a\u001b\u0010\t\u001a\u00020\u0014*\u00020\u000e2\f\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u00060\bH\u0004\u001a\u001b\u0010\u001b\u001a\u00020\u0014*\u00020\u000e2\f\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u00060\bH\u0004\"\u001e\u0010\u0002\u001a\u00020\u00012\u0006\u0010\u0000\u001a\u00020\u0001@BX.¢\u0006\b\n\u0000\u001a\u0004\b\u0003\u0010\u0004\"\u000e\u0010\u0005\u001a\u00020\u0006XT¢\u0006\u0002\n\u0000\"\u000e\u0010\u0007\u001a\u00020\u0006XT¢\u0006\u0002\n\u0000\"*\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00060\b2\f\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00060\b@BX\u000e¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n\"*\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\u00060\b2\f\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00060\b@BX\u000e¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\n\"\u001e\u0010\r\u001a\u00020\u000e*\u00020\u000e8FX\u0004¢\u0006\f\u0012\u0004\b\u000f\u0010\u0010\u001a\u0004\b\u0011\u0010\u0012¨\u0006\u001c"}, d2 = {"<set-?>", "Landroid/app/Application;", "AppContext", "getAppContext", "()Landroid/app/Application;", "FLOATING_BUTTON_ENABLED", "", "SHOW_GEM_POPUP", "Lkotlin/Function0;", "isGemFloatingButtonEnabled", "()Lkotlin/jvm/functions/Function0;", "showGemPopupChecker", "getShowGemPopupChecker", "set", "Lcom/talabat/gem/integration/GemIntegrator;", "getSet$annotations", "(Lcom/talabat/gem/integration/GemIntegrator;)V", "getSet", "(Lcom/talabat/gem/integration/GemIntegrator;)Lcom/talabat/gem/integration/GemIntegrator;", "withGemComponent", "", "block", "GemIntegration", "integration", "Lkotlin/Function1;", "Lkotlin/ExtensionFunctionType;", "checker", "showGemPopup", "com_talabat_Components_gem_gem"}, k = 2, mv = {1, 6, 0}, xi = 48)
@JvmName(name = "Gem")
public final class Gem {
    private static Application AppContext = null;
    @NotNull
    public static final String FLOATING_BUTTON_ENABLED = "Control";
    @NotNull
    public static final String SHOW_GEM_POPUP = "Control";
    @NotNull
    private static Function0<String> isGemFloatingButtonEnabled = Gem$isGemFloatingButtonEnabled$1.INSTANCE;
    @NotNull
    private static Function0<String> showGemPopupChecker = Gem$showGemPopupChecker$1.INSTANCE;

    @GemIntegrationDsl
    public static final void GemIntegration(@NotNull Application application, @NotNull Function1<? super GemIntegrator, Unit> function1) {
        Intrinsics.checkNotNullParameter(application, "<this>");
        Intrinsics.checkNotNullParameter(function1, "integration");
        AppContext = application;
        ApiContainer apiContainer = (ApiContainer) application;
        TrackingCoreLibApi trackingCoreLibApi = (TrackingCoreLibApi) apiContainer.getFeature(TrackingCoreLibApi.class);
        ConfigurationRemoteCoreLibApi configurationRemoteCoreLibApi = (ConfigurationRemoteCoreLibApi) apiContainer.getFeature(ConfigurationRemoteCoreLibApi.class);
        function1.invoke(new GemIntegrator());
        IntegrationKt.GemCoreIntegration(new Gem$GemIntegration$1(application, trackingCoreLibApi, (FeatureFlagCoreLibApi) apiContainer.getFeature(FeatureFlagCoreLibApi.class), configurationRemoteCoreLibApi, (NavigationCoreLibApi) apiContainer.getFeature(NavigationCoreLibApi.class)));
    }

    @NotNull
    public static final Application getAppContext() {
        Application application = AppContext;
        if (application != null) {
            return application;
        }
        Intrinsics.throwUninitializedPropertyAccessException("AppContext");
        return null;
    }

    @NotNull
    public static final GemIntegrator getSet(@NotNull GemIntegrator gemIntegrator) {
        Intrinsics.checkNotNullParameter(gemIntegrator, "<this>");
        return gemIntegrator;
    }

    @GemIntegrationDsl
    public static /* synthetic */ void getSet$annotations(GemIntegrator gemIntegrator) {
    }

    @NotNull
    public static final Function0<String> getShowGemPopupChecker() {
        return showGemPopupChecker;
    }

    @NotNull
    public static final Function0<String> isGemFloatingButtonEnabled() {
        return isGemFloatingButtonEnabled;
    }

    @GemIntegrationDsl
    public static final void showGemPopup(@NotNull GemIntegrator gemIntegrator, @NotNull Function0<String> function0) {
        Intrinsics.checkNotNullParameter(gemIntegrator, "<this>");
        Intrinsics.checkNotNullParameter(function0, "checker");
        showGemPopupChecker = function0;
    }

    @GemIntegrationDsl
    public static final void withGemComponent(@NotNull Function0<Unit> function0) {
        Intrinsics.checkNotNullParameter(function0, "block");
        CoroutinesKt.runHandling(new Gem$withGemComponent$1(IntegrationKt.getLogger()), new Gem$withGemComponent$2(function0));
    }

    @GemIntegrationDsl
    public static final void isGemFloatingButtonEnabled(@NotNull GemIntegrator gemIntegrator, @NotNull Function0<String> function0) {
        Intrinsics.checkNotNullParameter(gemIntegrator, "<this>");
        Intrinsics.checkNotNullParameter(function0, "checker");
        isGemFloatingButtonEnabled = function0;
    }
}
