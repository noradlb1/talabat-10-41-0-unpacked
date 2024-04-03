package com.afollestad.materialdialogs.utils;

import android.content.res.Resources;
import android.content.res.TypedArray;
import android.util.TypedValue;
import android.view.View;
import androidx.annotation.AttrRes;
import androidx.annotation.DimenRes;
import com.afollestad.materialdialogs.MaterialDialog;
import com.afollestad.materialdialogs.R;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001c\n\u0000\n\u0002\u0010\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a3\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\n\b\u0003\u0010\u0003\u001a\u0004\u0018\u00010\u00042\n\b\u0003\u0010\u0005\u001a\u0004\u0018\u00010\u00042\b\b\u0002\u0010\u0006\u001a\u00020\u0001H\u0000¢\u0006\u0002\u0010\u0007\u001a\u0014\u0010\b\u001a\u00020\u0001*\u00020\t2\u0006\u0010\n\u001a\u00020\u0004H\u0000¨\u0006\u000b"}, d2 = {"dimen", "", "Lcom/afollestad/materialdialogs/MaterialDialog;", "res", "", "attr", "fallback", "(Lcom/afollestad/materialdialogs/MaterialDialog;Ljava/lang/Integer;Ljava/lang/Integer;F)F", "dp", "Landroid/view/View;", "value", "com.afollestad.material-dialogs.core"}, k = 2, mv = {1, 1, 15})
public final class DimensKt {
    public static final float dimen(@NotNull MaterialDialog materialDialog, @Nullable @DimenRes Integer num, @Nullable @AttrRes Integer num2, float f11) {
        Intrinsics.checkParameterIsNotNull(materialDialog, "$this$dimen");
        MDUtil.INSTANCE.assertOneSet("dimen", num2, num);
        if (num != null) {
            return materialDialog.getWindowContext().getResources().getDimension(num.intValue());
        }
        if (num2 != null) {
            TypedArray obtainStyledAttributes = materialDialog.getWindowContext().getTheme().obtainStyledAttributes(new int[]{num2.intValue()});
            try {
                return obtainStyledAttributes.getDimension(0, f11);
            } finally {
                obtainStyledAttributes.recycle();
            }
        } else {
            throw new IllegalArgumentException("Required value was null.".toString());
        }
    }

    public static /* synthetic */ float dimen$default(MaterialDialog materialDialog, Integer num, Integer num2, float f11, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            num = null;
        }
        if ((i11 & 2) != 0) {
            num2 = null;
        }
        if ((i11 & 4) != 0) {
            f11 = materialDialog.getWindowContext().getResources().getDimension(R.dimen.md_dialog_default_corner_radius);
        }
        return dimen(materialDialog, num, num2, f11);
    }

    public static final float dp(@NotNull View view, int i11) {
        Intrinsics.checkParameterIsNotNull(view, "$this$dp");
        Resources resources = view.getResources();
        Intrinsics.checkExpressionValueIsNotNull(resources, "resources");
        return TypedValue.applyDimension(1, (float) i11, resources.getDisplayMetrics());
    }
}
