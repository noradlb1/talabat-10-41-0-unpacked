package com.talabat.talabatnavigation;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import androidx.fragment.app.Fragment;
import com.talabat.talabatnavigation.base.NavigatorModel;
import com.talabat.talabatnavigation.base.NavigatorModelForResult;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\b\u0007\u0018\u0000 \u00032\u00020\u0001:\u0001\u0003B\u0005¢\u0006\u0002\u0010\u0002¨\u0006\u0004"}, d2 = {"Lcom/talabat/talabatnavigation/Navigator;", "", "()V", "Companion", "com_talabat_NewArchi_TalabatNavigation_TalabatNavigation"}, k = 1, mv = {1, 6, 0}, xi = 48)
@Deprecated(message = "Please use the :core:navigation module")
public final class Navigator {
    @NotNull
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);

    @Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0018\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0002J\u0018\u0010\u0003\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u0007\u001a\u00020\bH\u0002J\u0018\u0010\u000b\u001a\u00020\u00042\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u0007\u001a\u00020\u000eH\u0002J\u0016\u0010\u000f\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0010\u001a\u00020\bJ\u0016\u0010\u000f\u001a\u00020\u00042\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u0010\u001a\u00020\u000eJ\u0016\u0010\u000f\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u0010\u001a\u00020\bJ\u001a\u0010\u0011\u001a\u00020\u00122\u0006\u0010\f\u001a\u00020\r2\b\u0010\u0013\u001a\u0004\u0018\u00010\u0014H\u0002¨\u0006\u0015"}, d2 = {"Lcom/talabat/talabatnavigation/Navigator$Companion;", "", "()V", "launchActivityForResult", "", "activity", "Landroid/app/Activity;", "intentNavigatorModel", "Lcom/talabat/talabatnavigation/base/NavigatorModelForResult;", "fragment", "Landroidx/fragment/app/Fragment;", "launchActivityWithAction", "context", "Landroid/content/Context;", "Lcom/talabat/talabatnavigation/base/NavigatorModel;", "navigate", "navigatorModel", "newIntent", "Landroid/content/Intent;", "action", "", "com_talabat_NewArchi_TalabatNavigation_TalabatNavigation"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private final void launchActivityForResult(Fragment fragment, NavigatorModelForResult navigatorModelForResult) {
            Context requireContext = fragment.requireContext();
            Intrinsics.checkNotNullExpressionValue(requireContext, "fragment.requireContext()");
            Intent newIntent = newIntent(requireContext, navigatorModelForResult.getAction());
            navigatorModelForResult.getInit().invoke(newIntent);
            newIntent.putExtras(navigatorModelForResult.getOptions());
            fragment.startActivityForResult(newIntent, navigatorModelForResult.getRequestCode());
        }

        private final void launchActivityWithAction(Context context, NavigatorModel navigatorModel) {
            Intent newIntent = newIntent(context, navigatorModel.getAction());
            navigatorModel.getInit().invoke(newIntent);
            newIntent.putExtras(navigatorModel.getOptions());
            context.startActivity(newIntent);
        }

        private final Intent newIntent(Context context, String str) {
            Intent intent = new Intent(str).setPackage(context.getPackageName());
            Intrinsics.checkNotNullExpressionValue(intent, "Intent(action).setPackage(context.packageName)");
            return intent;
        }

        public final void navigate(@NotNull Context context, @NotNull NavigatorModel navigatorModel) {
            Intrinsics.checkNotNullParameter(context, "context");
            Intrinsics.checkNotNullParameter(navigatorModel, "navigatorModel");
            launchActivityWithAction(context, navigatorModel);
        }

        public final void navigate(@NotNull Activity activity, @NotNull NavigatorModelForResult navigatorModelForResult) {
            Intrinsics.checkNotNullParameter(activity, "activity");
            Intrinsics.checkNotNullParameter(navigatorModelForResult, "navigatorModel");
            launchActivityForResult(activity, navigatorModelForResult);
        }

        public final void navigate(@NotNull Fragment fragment, @NotNull NavigatorModelForResult navigatorModelForResult) {
            Intrinsics.checkNotNullParameter(fragment, "fragment");
            Intrinsics.checkNotNullParameter(navigatorModelForResult, "navigatorModel");
            launchActivityForResult(fragment, navigatorModelForResult);
        }

        private final void launchActivityForResult(Activity activity, NavigatorModelForResult navigatorModelForResult) {
            Intent newIntent = newIntent(activity, navigatorModelForResult.getAction());
            navigatorModelForResult.getInit().invoke(newIntent);
            newIntent.putExtras(navigatorModelForResult.getOptions());
            activity.startActivityForResult(newIntent, navigatorModelForResult.getRequestCode());
        }
    }
}
