package com.talabat.growth.ui.util;

import android.app.Activity;
import android.net.Uri;
import com.talabat.core.observabilityNew.domain.IObservabilityManager;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000$\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u001a(\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u00012\b\b\u0002\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f\"\u000e\u0010\u0000\u001a\u00020\u0001XT¢\u0006\u0002\n\u0000\"\u000e\u0010\u0002\u001a\u00020\u0001XT¢\u0006\u0002\n\u0000\"\u000e\u0010\u0003\u001a\u00020\u0001XT¢\u0006\u0002\n\u0000¨\u0006\r"}, d2 = {"TALABAT_DEEP_LINK_SCHEMA", "", "TALABAT_FOOD_VERTICAL_DEEP_LINK", "TALABAT_HOME_DEEP_LINK", "redirectToDeepLink", "", "activity", "Landroid/app/Activity;", "deepLink", "navigator", "Lcom/talabat/growth/ui/util/DeepLinkNavigator;", "observabilityManager", "Lcom/talabat/core/observabilityNew/domain/IObservabilityManager;", "com_talabat_NewArchi_GrowthSquad_GrowthSquad"}, k = 2, mv = {1, 6, 0}, xi = 48)
public final class DeepLinkUtilKt {
    @NotNull
    private static final String TALABAT_DEEP_LINK_SCHEMA = "talabat://";
    @NotNull
    private static final String TALABAT_FOOD_VERTICAL_DEEP_LINK = "talabat://?s=l&vertical=1";
    @NotNull
    private static final String TALABAT_HOME_DEEP_LINK = "talabat://?";

    public static final void redirectToDeepLink(@NotNull Activity activity, @NotNull String str, @NotNull DeepLinkNavigator deepLinkNavigator, @NotNull IObservabilityManager iObservabilityManager) {
        Object obj;
        String str2;
        Intrinsics.checkNotNullParameter(activity, "activity");
        Intrinsics.checkNotNullParameter(str, "deepLink");
        Intrinsics.checkNotNullParameter(deepLinkNavigator, "navigator");
        Intrinsics.checkNotNullParameter(iObservabilityManager, "observabilityManager");
        try {
            Result.Companion companion = Result.Companion;
            boolean z11 = true;
            if (!(!StringsKt__StringsJVMKt.isBlank(str)) || !StringsKt__StringsJVMKt.startsWith$default(str, "talabat://", false, 2, (Object) null)) {
                z11 = false;
            }
            if (z11) {
                str2 = str;
            } else {
                str2 = null;
            }
            if (str2 == null) {
                str2 = TALABAT_HOME_DEEP_LINK;
            }
            if (Uri.parse(str2).getQuery() != null) {
                obj = Result.m6329constructorimpl(str2);
                if (Result.m6332exceptionOrNullimpl(obj) != null) {
                    IObservabilityManager.DefaultImpls.trackUnExpectedScenario$default(iObservabilityManager, "NotValidVoucherDeepLink >> " + str, (Map) null, 2, (Object) null);
                }
                if (Result.m6335isFailureimpl(obj)) {
                    obj = TALABAT_FOOD_VERTICAL_DEEP_LINK;
                }
                deepLinkNavigator.startHomeScreenWithDeepLink(activity, (String) obj);
                return;
            }
            throw new IllegalArgumentException("Required value was null.".toString());
        } catch (Throwable th2) {
            Result.Companion companion2 = Result.Companion;
            obj = Result.m6329constructorimpl(ResultKt.createFailure(th2));
        }
    }

    public static /* synthetic */ void redirectToDeepLink$default(Activity activity, String str, DeepLinkNavigator deepLinkNavigator, IObservabilityManager iObservabilityManager, int i11, Object obj) {
        if ((i11 & 4) != 0) {
            deepLinkNavigator = DeepLinkUtilNavigator.INSTANCE;
        }
        redirectToDeepLink(activity, str, deepLinkNavigator, iObservabilityManager);
    }
}
