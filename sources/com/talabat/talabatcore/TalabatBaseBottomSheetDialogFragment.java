package com.talabat.talabatcore;

import android.app.Dialog;
import android.content.DialogInterface;
import android.graphics.drawable.GradientDrawable;
import android.graphics.drawable.LayerDrawable;
import android.os.Build;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.Window;
import android.widget.FrameLayout;
import androidx.annotation.RequiresApi;
import com.google.android.material.R;
import com.google.android.material.bottomsheet.BottomSheetBehavior;
import com.google.android.material.bottomsheet.BottomSheetDialog;
import com.google.android.material.bottomsheet.BottomSheetDialogFragment;
import cw.a;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\b\u0016\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0012\u0010\u0003\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006H\u0016J\u0010\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\u0004H\u0003¨\u0006\n"}, d2 = {"Lcom/talabat/talabatcore/TalabatBaseBottomSheetDialogFragment;", "Lcom/google/android/material/bottomsheet/BottomSheetDialogFragment;", "()V", "onCreateDialog", "Landroid/app/Dialog;", "savedInstanceState", "Landroid/os/Bundle;", "setWhiteNavigationBar", "", "dialog", "com_talabat_NewArchi_TalabatCore_TalabatCore"}, k = 1, mv = {1, 6, 0}, xi = 48)
public class TalabatBaseBottomSheetDialogFragment extends BottomSheetDialogFragment {
    @NotNull
    public Map<Integer, View> _$_findViewCache = new LinkedHashMap();

    /* access modifiers changed from: private */
    /* renamed from: onCreateDialog$lambda-3  reason: not valid java name */
    public static final void m5822onCreateDialog$lambda3(DialogInterface dialogInterface) {
        if (dialogInterface != null) {
            FrameLayout frameLayout = (FrameLayout) ((BottomSheetDialog) dialogInterface).findViewById(R.id.design_bottom_sheet);
            Intrinsics.checkNotNull(frameLayout);
            BottomSheetBehavior from = BottomSheetBehavior.from(frameLayout);
            from.setBottomSheetCallback(new TalabatBaseBottomSheetDialogFragment$onCreateDialog$1$1(from));
            from.setState(3);
            return;
        }
        throw new NullPointerException("null cannot be cast to non-null type com.google.android.material.bottomsheet.BottomSheetDialog");
    }

    @RequiresApi(api = 23)
    private final void setWhiteNavigationBar(Dialog dialog) {
        Window window = dialog.getWindow();
        if (window != null) {
            DisplayMetrics displayMetrics = new DisplayMetrics();
            window.getWindowManager().getDefaultDisplay().getMetrics(displayMetrics);
            GradientDrawable gradientDrawable = new GradientDrawable();
            GradientDrawable gradientDrawable2 = new GradientDrawable();
            gradientDrawable2.setShape(0);
            gradientDrawable2.setColor(-1);
            LayerDrawable layerDrawable = new LayerDrawable(new GradientDrawable[]{gradientDrawable, gradientDrawable2});
            layerDrawable.setLayerInsetTop(1, displayMetrics.heightPixels);
            window.setBackgroundDrawable(layerDrawable);
        }
    }

    public void _$_clearFindViewByIdCache() {
        this._$_findViewCache.clear();
    }

    @Nullable
    public View _$_findCachedViewById(int i11) {
        View findViewById;
        Map<Integer, View> map = this._$_findViewCache;
        View view = map.get(Integer.valueOf(i11));
        if (view != null) {
            return view;
        }
        View view2 = getView();
        if (view2 == null || (findViewById = view2.findViewById(i11)) == null) {
            return null;
        }
        map.put(Integer.valueOf(i11), findViewById);
        return findViewById;
    }

    @NotNull
    public Dialog onCreateDialog(@Nullable Bundle bundle) {
        BottomSheetDialog bottomSheetDialog = (BottomSheetDialog) super.onCreateDialog(bundle);
        if (Build.VERSION.SDK_INT >= 27) {
            setWhiteNavigationBar(bottomSheetDialog);
        }
        bottomSheetDialog.setOnShowListener(new a());
        return bottomSheetDialog;
    }

    public /* synthetic */ void onDestroyView() {
        super.onDestroyView();
        _$_clearFindViewByIdCache();
    }
}
