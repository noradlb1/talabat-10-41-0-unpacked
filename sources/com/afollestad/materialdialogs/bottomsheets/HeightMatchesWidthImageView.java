package com.afollestad.materialdialogs.bottomsheets;

import android.content.Context;
import android.util.AttributeSet;
import androidx.annotation.RestrictTo;
import androidx.appcompat.widget.AppCompatImageView;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0007\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0002\u0010\u0006J\u0018\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\nH\u0014¨\u0006\f"}, d2 = {"Lcom/afollestad/materialdialogs/bottomsheets/HeightMatchesWidthImageView;", "Landroidx/appcompat/widget/AppCompatImageView;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "onMeasure", "", "widthMeasureSpec", "", "heightMeasureSpec", "com.afollestad.material-dialogs.bottomsheets"}, k = 1, mv = {1, 1, 15})
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
public final class HeightMatchesWidthImageView extends AppCompatImageView {
    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public HeightMatchesWidthImageView(@NotNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        Intrinsics.checkParameterIsNotNull(context, "context");
    }

    public void onMeasure(int i11, int i12) {
        super.onMeasure(i11, i11);
    }
}
