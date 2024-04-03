package com.talabat.core.navigation.data;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import com.talabat.core.navigation.domain.Navigator;
import com.talabat.core.navigation.domain.screen.Screen;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0000\u0018\u00002\u00020\u0001B\u0007\b\u0007¢\u0006\u0002\u0010\u0002J5\u0010\u0003\u001a\u00020\u00042\n\u0010\u0005\u001a\u0006\u0012\u0002\b\u00030\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0017\u0010\t\u001a\u0013\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u000b0\n¢\u0006\u0002\b\fH\u0002J=\u0010\r\u001a\u00020\u000b2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u00112\n\u0010\u0005\u001a\u0006\u0012\u0002\b\u00030\u00062\u0017\u0010\t\u001a\u0013\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u000b0\n¢\u0006\u0002\b\fH\u0016J5\u0010\u0012\u001a\u00020\u000b2\u0006\u0010\u0007\u001a\u00020\b2\n\u0010\u0005\u001a\u0006\u0012\u0002\b\u00030\u00062\u0017\u0010\t\u001a\u0013\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u000b0\n¢\u0006\u0002\b\fH\u0016¨\u0006\u0013"}, d2 = {"Lcom/talabat/core/navigation/data/ActivityNavigator;", "Lcom/talabat/core/navigation/domain/Navigator;", "()V", "createIntent", "Landroid/content/Intent;", "screen", "Lcom/talabat/core/navigation/domain/screen/Screen;", "context", "Landroid/content/Context;", "extraOptions", "Lkotlin/Function1;", "", "Lkotlin/ExtensionFunctionType;", "navigateForResultTo", "activity", "Landroid/app/Activity;", "requestCode", "", "navigateTo", "com_talabat_core_navigation_data_data"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class ActivityNavigator implements Navigator {
    /* JADX WARNING: type inference failed for: r3v0, types: [com.talabat.core.navigation.domain.screen.Screen, com.talabat.core.navigation.domain.screen.Screen<?>] */
    /* JADX WARNING: Unknown variable types count: 1 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final android.content.Intent createIntent(com.talabat.core.navigation.domain.screen.Screen<?> r3, android.content.Context r4, kotlin.jvm.functions.Function1<? super android.content.Intent, kotlin.Unit> r5) {
        /*
            r2 = this;
            android.content.Intent r0 = new android.content.Intent
            r0.<init>()
            java.lang.String r1 = r3.getLink()
            r0.setAction(r1)
            java.lang.String r4 = r4.getPackageName()
            r0.setPackage(r4)
            java.lang.String r4 = "navigatorData"
            android.os.Parcelable r3 = r3.getData()
            r0.putExtra(r4, r3)
            r5.invoke(r0)
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.talabat.core.navigation.data.ActivityNavigator.createIntent(com.talabat.core.navigation.domain.screen.Screen, android.content.Context, kotlin.jvm.functions.Function1):android.content.Intent");
    }

    public void navigateForResultTo(@NotNull Activity activity, int i11, @NotNull Screen<?> screen, @NotNull Function1<? super Intent, Unit> function1) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        Intrinsics.checkNotNullParameter(screen, "screen");
        Intrinsics.checkNotNullParameter(function1, "extraOptions");
        activity.startActivityForResult(createIntent(screen, activity, function1), i11);
    }

    public void navigateTo(@NotNull Context context, @NotNull Screen<?> screen, @NotNull Function1<? super Intent, Unit> function1) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(screen, "screen");
        Intrinsics.checkNotNullParameter(function1, "extraOptions");
        context.startActivity(createIntent(screen, context, function1));
    }
}
