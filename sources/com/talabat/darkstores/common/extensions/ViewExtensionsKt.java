package com.talabat.darkstores.common.extensions;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import androidx.annotation.LayoutRes;
import androidx.core.content.ContextCompat;
import androidx.core.graphics.drawable.DrawableCompat;
import com.jakewharton.rxbinding3.view.RxView;
import io.reactivex.Observable;
import java.util.concurrent.TimeUnit;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000*\n\u0000\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0004\u001a\n\u0010\u0000\u001a\u00020\u0001*\u00020\u0002\u001a\u0014\u0010\u0003\u001a\u00020\u0002*\u00020\u00042\b\b\u0001\u0010\u0005\u001a\u00020\u0006\u001a\u001a\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\b*\u00020\u00022\b\b\u0002\u0010\n\u001a\u00020\u000b\u001a\n\u0010\f\u001a\u00020\t*\u00020\u0002\u001a\u0012\u0010\r\u001a\u00020\t*\u00020\u00022\u0006\u0010\u000e\u001a\u00020\u0006¨\u0006\u000f"}, d2 = {"hideKeyboard", "", "Landroid/view/View;", "inflate", "Landroid/view/ViewGroup;", "layout", "", "setSingleOnClickListener", "Lio/reactivex/Observable;", "", "debounceTime", "", "showKeyboard", "tintBackground", "color", "com_talabat_NewArchi_darkstores_darkstores"}, k = 2, mv = {1, 6, 0}, xi = 48)
public final class ViewExtensionsKt {
    public static final boolean hideKeyboard(@NotNull View view) {
        Intrinsics.checkNotNullParameter(view, "<this>");
        Object systemService = view.getContext().getSystemService("input_method");
        if (systemService != null) {
            return ((InputMethodManager) systemService).hideSoftInputFromWindow(view.getWindowToken(), 0);
        }
        throw new NullPointerException("null cannot be cast to non-null type android.view.inputmethod.InputMethodManager");
    }

    @NotNull
    public static final View inflate(@NotNull ViewGroup viewGroup, @LayoutRes int i11) {
        Intrinsics.checkNotNullParameter(viewGroup, "<this>");
        View inflate = LayoutInflater.from(viewGroup.getContext()).inflate(i11, viewGroup, false);
        Intrinsics.checkNotNullExpressionValue(inflate, "from(context).inflate(layout, this, false)");
        return inflate;
    }

    @NotNull
    public static final Observable<Unit> setSingleOnClickListener(@NotNull View view, long j11) {
        Intrinsics.checkNotNullParameter(view, "<this>");
        Observable<Unit> throttleFirst = RxView.clicks(view).throttleFirst(j11, TimeUnit.MILLISECONDS);
        Intrinsics.checkNotNullExpressionValue(throttleFirst, "this.clicks()\n        .t…e, TimeUnit.MILLISECONDS)");
        return throttleFirst;
    }

    public static /* synthetic */ Observable setSingleOnClickListener$default(View view, long j11, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            j11 = 600;
        }
        return setSingleOnClickListener(view, j11);
    }

    public static final void showKeyboard(@NotNull View view) {
        Intrinsics.checkNotNullParameter(view, "<this>");
        Context context = view.getContext();
        Intrinsics.checkNotNullExpressionValue(context, "context");
        InputMethodManager inputMethodManager = (InputMethodManager) ContextCompat.getSystemService(context, InputMethodManager.class);
        if (inputMethodManager != null) {
            inputMethodManager.toggleSoftInput(2, 1);
        }
    }

    public static final void tintBackground(@NotNull View view, int i11) {
        Intrinsics.checkNotNullParameter(view, "<this>");
        Drawable mutate = DrawableCompat.wrap(view.getBackground()).mutate();
        Intrinsics.checkNotNullExpressionValue(mutate, "wrap(background).mutate()");
        DrawableCompat.setTint(mutate, i11);
        view.setBackground(mutate);
    }
}
