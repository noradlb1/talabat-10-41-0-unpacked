package com.talabat.talabatcommon.extentions;

import android.app.Activity;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import androidx.annotation.LayoutRes;
import androidx.appcompat.app.AppCompatActivity;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\"\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u001a\n\u0010\u0000\u001a\u00020\u0001*\u00020\u0002\u001a-\u0010\u0003\u001a\u00020\u0001*\u00020\u00042\b\b\u0001\u0010\u0005\u001a\u00020\u00062\u0017\u0010\u0007\u001a\u0013\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00010\b¢\u0006\u0002\b\t¨\u0006\n"}, d2 = {"hideKeyBoard", "", "Landroid/app/Activity;", "withLayout", "Landroidx/appcompat/app/AppCompatActivity;", "layoutId", "", "onCreate", "Lkotlin/Function1;", "Lkotlin/ExtensionFunctionType;", "com_talabat_NewArchi_TalabatCommon_TalabatCommon"}, k = 2, mv = {1, 6, 0}, xi = 48)
public final class ActivityKt {
    public static final void hideKeyBoard(@NotNull Activity activity) {
        InputMethodManager inputMethodManager;
        Intrinsics.checkNotNullParameter(activity, "<this>");
        View currentFocus = activity.getCurrentFocus();
        if (currentFocus != null) {
            Object systemService = activity.getSystemService("input_method");
            if (systemService instanceof InputMethodManager) {
                inputMethodManager = (InputMethodManager) systemService;
            } else {
                inputMethodManager = null;
            }
            if (inputMethodManager != null) {
                inputMethodManager.hideSoftInputFromWindow(currentFocus.getWindowToken(), 0);
            }
        }
    }

    public static final void withLayout(@NotNull AppCompatActivity appCompatActivity, @LayoutRes int i11, @NotNull Function1<? super AppCompatActivity, Unit> function1) {
        Intrinsics.checkNotNullParameter(appCompatActivity, "<this>");
        Intrinsics.checkNotNullParameter(function1, "onCreate");
        appCompatActivity.getLifecycle().addObserver(new ActivityKt$withLayout$1(appCompatActivity, i11, function1));
    }
}
