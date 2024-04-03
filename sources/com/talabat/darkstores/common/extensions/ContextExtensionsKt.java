package com.talabat.darkstores.common.extensions;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.util.TypedValue;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import androidx.annotation.AttrRes;
import androidx.annotation.ColorRes;
import androidx.annotation.DrawableRes;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u00002\n\u0000\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\u001a\u0016\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\b\b\u0001\u0010\u0003\u001a\u00020\u0001H\u0000\u001a\u0016\u0010\u0004\u001a\u00020\u0001*\u00020\u00022\b\b\u0001\u0010\u0005\u001a\u00020\u0001H\u0000\u001a\u0016\u0010\u0006\u001a\u00020\u0001*\u00020\u00022\b\b\u0001\u0010\u0007\u001a\u00020\u0001H\u0000\u001a\u0018\u0010\b\u001a\u0004\u0018\u00010\t*\u00020\u00022\b\b\u0001\u0010\n\u001a\u00020\u0001H\u0000\u001a\n\u0010\u000b\u001a\u00020\f*\u00020\r\u001a\u0012\u0010\u000b\u001a\u00020\f*\u00020\u00022\u0006\u0010\u000e\u001a\u00020\u000f\u001a\n\u0010\u000b\u001a\u00020\f*\u00020\u0010\u001a\n\u0010\u0011\u001a\u00020\u0012*\u00020\u0002\u001a\u0019\u0010\u0013\u001a\u00020\f\"\n\b\u0000\u0010\u0014\u0018\u0001*\u00020\r*\u00020\u0002H\b¨\u0006\u0015"}, d2 = {"getAttributeColor", "", "Landroid/content/Context;", "attrColor", "getAttributeDrawable", "attrDrawableRes", "getColorCompat", "color", "getDrawableCompat", "Landroid/graphics/drawable/Drawable;", "drawable", "hideKeyboard", "", "Landroid/app/Activity;", "view", "Landroid/view/View;", "Landroidx/fragment/app/Fragment;", "isValidForGlide", "", "startActivity", "T", "com_talabat_NewArchi_darkstores_darkstores"}, k = 2, mv = {1, 6, 0}, xi = 48)
public final class ContextExtensionsKt {
    public static final int getAttributeColor(@NotNull Context context, @AttrRes int i11) {
        Intrinsics.checkNotNullParameter(context, "<this>");
        TypedValue typedValue = new TypedValue();
        context.getTheme().resolveAttribute(i11, typedValue, true);
        return typedValue.data;
    }

    public static final int getAttributeDrawable(@NotNull Context context, @AttrRes int i11) {
        Intrinsics.checkNotNullParameter(context, "<this>");
        TypedValue typedValue = new TypedValue();
        context.getTheme().resolveAttribute(i11, typedValue, true);
        return typedValue.resourceId;
    }

    public static final int getColorCompat(@NotNull Context context, @ColorRes int i11) {
        Intrinsics.checkNotNullParameter(context, "<this>");
        return ContextCompat.getColor(context, i11);
    }

    @Nullable
    public static final Drawable getDrawableCompat(@NotNull Context context, @DrawableRes int i11) {
        Intrinsics.checkNotNullParameter(context, "<this>");
        return ContextCompat.getDrawable(context, i11);
    }

    public static final void hideKeyboard(@NotNull Context context, @NotNull View view) {
        Intrinsics.checkNotNullParameter(context, "<this>");
        Intrinsics.checkNotNullParameter(view, "view");
        Object systemService = context.getSystemService("input_method");
        if (systemService != null) {
            ((InputMethodManager) systemService).hideSoftInputFromWindow(view.getWindowToken(), 0);
            return;
        }
        throw new NullPointerException("null cannot be cast to non-null type android.view.inputmethod.InputMethodManager");
    }

    public static final boolean isValidForGlide(@NotNull Context context) {
        Intrinsics.checkNotNullParameter(context, "<this>");
        if (!(context instanceof Activity)) {
            return true;
        }
        Activity activity = (Activity) context;
        if (activity.isDestroyed() || activity.isFinishing()) {
            return false;
        }
        return true;
    }

    public static final /* synthetic */ <T extends Activity> void startActivity(Context context) {
        Intrinsics.checkNotNullParameter(context, "<this>");
        Intrinsics.reifiedOperationMarker(4, "T");
        context.startActivity(new Intent(context, Activity.class));
    }

    public static final void hideKeyboard(@NotNull Fragment fragment) {
        FragmentActivity activity;
        Intrinsics.checkNotNullParameter(fragment, "<this>");
        View view = fragment.getView();
        if (view != null && (activity = fragment.getActivity()) != null) {
            Intrinsics.checkNotNullExpressionValue(activity, "activity");
            hideKeyboard(activity, view);
        }
    }

    public static final void hideKeyboard(@NotNull Activity activity) {
        Intrinsics.checkNotNullParameter(activity, "<this>");
        View currentFocus = activity.getCurrentFocus();
        if (currentFocus == null) {
            currentFocus = new View(activity);
        }
        hideKeyboard(activity, currentFocus);
    }
}
