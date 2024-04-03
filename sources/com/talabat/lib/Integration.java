package com.talabat.lib;

import android.app.Application;
import androidx.annotation.VisibleForTesting;
import com.facebook.internal.NativeProtocol;
import java.util.List;
import java.util.Map;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.JvmName;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000D\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010!\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\u0010$\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u001a\b\u0010\u0019\u001a\u00020\u0001H\u0007\u001a\u0006\u0010\u001a\u001a\u00020\r\u001a\u0010\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u001d\u001a\u00020\u0001H\u0007\u001a\u0016\u0010\u001e\u001a\u00020\u001c2\u000e\u0010\u001f\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\b\u001a%\u0010 \u001a\u00020\u001c*\u00020\u00012\u0017\u0010!\u001a\u0013\u0012\u0004\u0012\u00020\u0014\u0012\u0004\u0012\u00020\u001c0\"¢\u0006\u0002\b#H\u0007\u001a\u001b\u0010$\u001a\u00020\u001c*\u00020\u00142\f\u0010%\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003H\u0004\u001a'\u0010&\u001a\u00020\u001c*\u00020\u00142\u0018\u0010%\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00040\u000e0\u0003H\u0004\u001a\u001b\u0010\u0011\u001a\u00020\u001c*\u00020\u00142\f\u0010%\u001a\b\u0012\u0004\u0012\u00020\r0\u0003H\u0004\u001a\u001b\u0010\u001a\u001a\u00020\u001c*\u00020\u00142\f\u0010%\u001a\b\u0012\u0004\u0012\u00020\r0\u0003H\u0004\u001a\u001b\u0010\u0012\u001a\u00020\u001c*\u00020\u00142\f\u0010%\u001a\b\u0012\u0004\u0012\u00020\r0\u0003H\u0004\"\u000e\u0010\u0000\u001a\u00020\u0001X.¢\u0006\u0002\n\u0000\"*\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003@BX\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007\".\u0010\t\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\b2\u000e\u0010\u0002\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\b@BX\u000e¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b\"\u0014\u0010\f\u001a\b\u0012\u0004\u0012\u00020\r0\u0003X\u000e¢\u0006\u0002\n\u0000\"F\u0010\u000f\u001a\u0016\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00040\u000e\u0018\u00010\u00032\u001a\u0010\u0002\u001a\u0016\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00040\u000e\u0018\u00010\u0003@BX\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0007\"*\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\r0\u00032\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\r0\u0003@BX\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0007\"*\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\r0\u00032\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\r0\u0003@BX\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0007\"\u001e\u0010\u0013\u001a\u00020\u0014*\u00020\u00148FX\u0004¢\u0006\f\u0012\u0004\b\u0015\u0010\u0016\u001a\u0004\b\u0017\u0010\u0018¨\u0006'"}, d2 = {"AppContext", "Landroid/app/Application;", "<set-?>", "Lkotlin/Function0;", "", "FirebaseAnalyticsKey", "getFirebaseAnalyticsKey", "()Lkotlin/jvm/functions/Function0;", "", "GaEventsTracker", "getGaEventsTracker", "()Ljava/util/List;", "GemActiveChecker", "", "", "GemComponentStateRetriever", "getGemComponentStateRetriever", "isFirebaseAnalyticsActive", "isSponsoredSortingActive", "set", "Lcom/talabat/lib/TalabatLibIntegrator;", "getSet$annotations", "(Lcom/talabat/lib/TalabatLibIntegrator;)V", "getSet", "(Lcom/talabat/lib/TalabatLibIntegrator;)Lcom/talabat/lib/TalabatLibIntegrator;", "getAppContext", "isGemActive", "setAppContext", "", "appContext", "setGaEventsTracker", "list", "TalabatLibIntegration", "integration", "Lkotlin/Function1;", "Lkotlin/ExtensionFunctionType;", "firebaseAnalyticsKey", "action", "gemComponentStateRetriever", "com_talabat_talabatlib_talabatlib"}, k = 2, mv = {1, 6, 0}, xi = 48)
@JvmName(name = "Integration")
public final class Integration {
    private static Application AppContext;
    @NotNull
    private static Function0<String> FirebaseAnalyticsKey = Integration$FirebaseAnalyticsKey$1.INSTANCE;
    @Nullable
    private static List<String> GaEventsTracker;
    @NotNull
    private static Function0<Boolean> GemActiveChecker = Integration$GemActiveChecker$1.INSTANCE;
    @Nullable
    private static Function0<? extends Map<String, String>> GemComponentStateRetriever;
    @NotNull
    private static Function0<Boolean> isFirebaseAnalyticsActive = Integration$isFirebaseAnalyticsActive$1.INSTANCE;
    @NotNull
    private static Function0<Boolean> isSponsoredSortingActive = Integration$isSponsoredSortingActive$1.INSTANCE;

    @TalabatLibIntegrationDsl
    public static final void TalabatLibIntegration(@NotNull Application application, @NotNull Function1<? super TalabatLibIntegrator, Unit> function1) {
        Intrinsics.checkNotNullParameter(application, "<this>");
        Intrinsics.checkNotNullParameter(function1, "integration");
        AppContext = application;
        function1.invoke(TalabatLibIntegrator.INSTANCE);
    }

    @TalabatLibIntegrationDsl
    public static final void firebaseAnalyticsKey(@NotNull TalabatLibIntegrator talabatLibIntegrator, @NotNull Function0<String> function0) {
        Intrinsics.checkNotNullParameter(talabatLibIntegrator, "<this>");
        Intrinsics.checkNotNullParameter(function0, NativeProtocol.WEB_DIALOG_ACTION);
        FirebaseAnalyticsKey = function0;
    }

    @TalabatLibIntegrationDsl
    public static final void gemComponentStateRetriever(@NotNull TalabatLibIntegrator talabatLibIntegrator, @NotNull Function0<? extends Map<String, String>> function0) {
        Intrinsics.checkNotNullParameter(talabatLibIntegrator, "<this>");
        Intrinsics.checkNotNullParameter(function0, NativeProtocol.WEB_DIALOG_ACTION);
        GemComponentStateRetriever = function0;
    }

    @NotNull
    @Deprecated(message = "Please use global app context from dagger DI. This is causing stability and other side effects issues in the system.")
    public static final Application getAppContext() {
        Application application = AppContext;
        if (application != null) {
            return application;
        }
        Intrinsics.throwUninitializedPropertyAccessException("AppContext");
        return null;
    }

    @NotNull
    public static final Function0<String> getFirebaseAnalyticsKey() {
        return FirebaseAnalyticsKey;
    }

    @Nullable
    public static final List<String> getGaEventsTracker() {
        return GaEventsTracker;
    }

    @Nullable
    public static final Function0<Map<String, String>> getGemComponentStateRetriever() {
        return GemComponentStateRetriever;
    }

    @NotNull
    public static final TalabatLibIntegrator getSet(@NotNull TalabatLibIntegrator talabatLibIntegrator) {
        Intrinsics.checkNotNullParameter(talabatLibIntegrator, "<this>");
        return talabatLibIntegrator;
    }

    @TalabatLibIntegrationDsl
    public static /* synthetic */ void getSet$annotations(TalabatLibIntegrator talabatLibIntegrator) {
    }

    @NotNull
    public static final Function0<Boolean> isFirebaseAnalyticsActive() {
        return isFirebaseAnalyticsActive;
    }

    @TalabatLibIntegrationDsl
    public static final void isGemActive(@NotNull TalabatLibIntegrator talabatLibIntegrator, @NotNull Function0<Boolean> function0) {
        Intrinsics.checkNotNullParameter(talabatLibIntegrator, "<this>");
        Intrinsics.checkNotNullParameter(function0, NativeProtocol.WEB_DIALOG_ACTION);
        GemActiveChecker = new Integration$isGemActive$1(talabatLibIntegrator, function0);
    }

    @NotNull
    public static final Function0<Boolean> isSponsoredSortingActive() {
        return isSponsoredSortingActive;
    }

    @VisibleForTesting
    @Deprecated(message = "Please don't use this method except in testing legacy code. Prefer using the context from dagger DI.")
    public static final void setAppContext(@NotNull Application application) {
        Intrinsics.checkNotNullParameter(application, "appContext");
        AppContext = application;
    }

    public static final void setGaEventsTracker(@Nullable List<String> list) {
        GaEventsTracker = list;
    }

    @TalabatLibIntegrationDsl
    public static final void isFirebaseAnalyticsActive(@NotNull TalabatLibIntegrator talabatLibIntegrator, @NotNull Function0<Boolean> function0) {
        Intrinsics.checkNotNullParameter(talabatLibIntegrator, "<this>");
        Intrinsics.checkNotNullParameter(function0, NativeProtocol.WEB_DIALOG_ACTION);
        isFirebaseAnalyticsActive = new Integration$isFirebaseAnalyticsActive$2(talabatLibIntegrator, function0);
    }

    public static final boolean isGemActive() {
        return GemActiveChecker.invoke().booleanValue();
    }

    @TalabatLibIntegrationDsl
    public static final void isSponsoredSortingActive(@NotNull TalabatLibIntegrator talabatLibIntegrator, @NotNull Function0<Boolean> function0) {
        Intrinsics.checkNotNullParameter(talabatLibIntegrator, "<this>");
        Intrinsics.checkNotNullParameter(function0, NativeProtocol.WEB_DIALOG_ACTION);
        isSponsoredSortingActive = new Integration$isSponsoredSortingActive$2(talabatLibIntegrator, function0);
    }
}
