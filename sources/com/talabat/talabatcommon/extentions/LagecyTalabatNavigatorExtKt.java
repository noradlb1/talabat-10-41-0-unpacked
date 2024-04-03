package com.talabat.talabatcommon.extentions;

import android.content.Context;
import com.talabat.talabatnavigation.Navigator;
import com.talabat.talabatnavigation.base.NavigatorModel;
import com.talabat.talabatnavigation.legacyTalabat.LegacyTalabatActions;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u001a\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\u001a\"\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u0006¨\u0006\b"}, d2 = {"navigateToMainFAQ", "", "Lcom/talabat/talabatnavigation/Navigator$Companion;", "context", "Landroid/content/Context;", "title", "", "url", "com_talabat_NewArchi_TalabatCommon_TalabatCommon"}, k = 2, mv = {1, 6, 0}, xi = 48)
public final class LagecyTalabatNavigatorExtKt {
    public static final void navigateToMainFAQ(@NotNull Navigator.Companion companion, @NotNull Context context, @NotNull String str, @NotNull String str2) {
        Intrinsics.checkNotNullParameter(companion, "<this>");
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(str, "title");
        Intrinsics.checkNotNullParameter(str2, "url");
        companion.navigate(context, new NavigatorModel(LegacyTalabatActions.OPEN_MAIN_FAQ_SCREEN_ACTIVITY, BundleKt.bundleOf(BundleKt.bundleTo((String) LegacyTalabatActions.EXTRA_MAIN_FAQ_SCREEN_TITLE, str), BundleKt.bundleTo("url", str2)), (Function1) null, 4, (DefaultConstructorMarker) null));
    }
}
