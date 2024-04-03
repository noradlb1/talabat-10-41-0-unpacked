package com.talabat.feature.tpro.presentation.util;

import android.app.Activity;
import android.content.res.ColorStateList;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.Toast;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.appcompat.widget.AppCompatTextView;
import com.talabat.talabatcommon.R;
import com.talabat.talabatcommon.views.darkstores.lookingGlass.adapter.HeadlinesAdapterKt;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u001a\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a\u001a\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006\u001a\u001a\u0010\u0007\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006¨\u0006\b"}, d2 = {"showErrorToast", "", "Landroid/widget/Toast;", "message", "", "activity", "Landroid/app/Activity;", "showSuccessToast", "com_talabat_feature_tpro_presentation_presentation"}, k = 2, mv = {1, 6, 0}, xi = 48)
public final class ToastExtensionsKt {
    public static final void showErrorToast(@NotNull Toast toast, @NotNull String str, @NotNull Activity activity) {
        Intrinsics.checkNotNullParameter(toast, "<this>");
        Intrinsics.checkNotNullParameter(str, "message");
        Intrinsics.checkNotNullParameter(activity, "activity");
        View inflate = activity.getLayoutInflater().inflate(R.layout.view_custom_toast, (ViewGroup) activity.findViewById(R.id.custom_toast_view));
        ((AppCompatTextView) inflate.findViewById(R.id.text_view_custom_toast)).setText(str);
        toast.setGravity(80, 0, 200);
        toast.setDuration(1);
        toast.setView(inflate);
        toast.show();
    }

    public static final void showSuccessToast(@NotNull Toast toast, @NotNull String str, @NotNull Activity activity) {
        Intrinsics.checkNotNullParameter(toast, "<this>");
        Intrinsics.checkNotNullParameter(str, "message");
        Intrinsics.checkNotNullParameter(activity, "activity");
        LayoutInflater layoutInflater = activity.getLayoutInflater();
        int i11 = R.layout.view_custom_toast;
        int i12 = R.id.custom_toast_view;
        View inflate = layoutInflater.inflate(i11, (ViewGroup) activity.findViewById(i12));
        ((LinearLayout) inflate.findViewById(i12)).setBackgroundTintList(ColorStateList.valueOf(HeadlinesAdapterKt.getColor(com.designsystem.marshmallow.R.color.ds_success_10)));
        ((AppCompatTextView) inflate.findViewById(R.id.text_view_custom_toast)).setText(str);
        ((AppCompatImageView) inflate.findViewById(R.id.image_view_custom_toast)).setImageResource(R.drawable.ic_ds_success);
        toast.setGravity(80, 0, 200);
        toast.setDuration(1);
        toast.setView(inflate);
        toast.show();
    }
}
