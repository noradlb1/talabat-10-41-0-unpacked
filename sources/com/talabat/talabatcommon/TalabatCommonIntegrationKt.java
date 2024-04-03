package com.talabat.talabatcommon;

import android.content.Context;
import java.util.Locale;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u0016\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\"\u001e\u0010\u0002\u001a\u00020\u00012\u0006\u0010\u0000\u001a\u00020\u0001@BX.¢\u0006\b\n\u0000\u001a\u0004\b\u0003\u0010\u0004\"(\u0010\u0005\u001a\u0010\u0012\f\u0012\n \b*\u0004\u0018\u00010\u00070\u00070\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\f¨\u0006\r"}, d2 = {"<set-?>", "Landroid/content/Context;", "AppContext", "getAppContext", "()Landroid/content/Context;", "SelectedLocaleRetriever", "Lkotlin/Function0;", "Ljava/util/Locale;", "kotlin.jvm.PlatformType", "getSelectedLocaleRetriever", "()Lkotlin/jvm/functions/Function0;", "setSelectedLocaleRetriever", "(Lkotlin/jvm/functions/Function0;)V", "com_talabat_NewArchi_TalabatCommon_TalabatCommon"}, k = 2, mv = {1, 6, 0}, xi = 48)
public final class TalabatCommonIntegrationKt {
    /* access modifiers changed from: private */
    public static Context AppContext;
    @NotNull
    private static Function0<Locale> SelectedLocaleRetriever = TalabatCommonIntegrationKt$SelectedLocaleRetriever$1.INSTANCE;

    @NotNull
    public static final Context getAppContext() {
        Context context = AppContext;
        if (context != null) {
            return context;
        }
        Intrinsics.throwUninitializedPropertyAccessException("AppContext");
        return null;
    }

    @NotNull
    public static final Function0<Locale> getSelectedLocaleRetriever() {
        return SelectedLocaleRetriever;
    }

    public static final void setSelectedLocaleRetriever(@NotNull Function0<Locale> function0) {
        Intrinsics.checkNotNullParameter(function0, "<set-?>");
        SelectedLocaleRetriever = function0;
    }
}
