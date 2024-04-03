package com.afollestad.materialdialogs.internal.main;

import android.content.Context;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.ViewGroup;
import androidx.annotation.RestrictTo;
import androidx.navigation.compose.DialogNavigator;
import com.afollestad.materialdialogs.MaterialDialog;
import com.afollestad.materialdialogs.R;
import com.afollestad.materialdialogs.utils.MDUtil;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b'\u0018\u00002\u00020\u0001B\u001d\b\u0000\u0012\u0006\u0010\u001c\u001a\u00020\u001b\u0012\n\b\u0002\u0010\u001e\u001a\u0004\u0018\u00010\u001d¢\u0006\u0004\b\u001f\u0010 J\b\u0010\u0003\u001a\u00020\u0002H\u0002J\b\u0010\u0005\u001a\u00020\u0004H\u0004R\u0014\u0010\u0006\u001a\u00020\u00048\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0006\u0010\u0007R\u001a\u0010\b\u001a\u00020\u00028\u0004X\u0004¢\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\n\u0010\u000bR\"\u0010\r\u001a\u00020\f8\u0006@\u0006X.¢\u0006\u0012\n\u0004\b\r\u0010\u000e\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012R*\u0010\u0015\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u00138\u0006@FX\u000e¢\u0006\u0012\n\u0004\b\u0015\u0010\u0016\u001a\u0004\b\u0017\u0010\u0018\"\u0004\b\u0019\u0010\u001a¨\u0006!"}, d2 = {"Lcom/afollestad/materialdialogs/internal/main/BaseSubLayout;", "Landroid/view/ViewGroup;", "", "getDividerColor", "Landroid/graphics/Paint;", "a", "dividerPaint", "Landroid/graphics/Paint;", "dividerHeight", "I", "getDividerHeight", "()I", "Lcom/afollestad/materialdialogs/MaterialDialog;", "dialog", "Lcom/afollestad/materialdialogs/MaterialDialog;", "getDialog", "()Lcom/afollestad/materialdialogs/MaterialDialog;", "setDialog", "(Lcom/afollestad/materialdialogs/MaterialDialog;)V", "", "value", "drawDivider", "Z", "getDrawDivider", "()Z", "setDrawDivider", "(Z)V", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", "attrs", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "com.afollestad.material-dialogs.core"}, k = 1, mv = {1, 4, 0})
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
public abstract class BaseSubLayout extends ViewGroup {
    @NotNull
    public MaterialDialog dialog;
    private final int dividerHeight;
    private final Paint dividerPaint;
    private boolean drawDivider;

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ BaseSubLayout(Context context, AttributeSet attributeSet, int i11, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i11 & 2) != 0 ? null : attributeSet);
    }

    private final int getDividerColor() {
        MDUtil mDUtil = MDUtil.INSTANCE;
        MaterialDialog materialDialog = this.dialog;
        if (materialDialog == null) {
            Intrinsics.throwUninitializedPropertyAccessException(DialogNavigator.NAME);
        }
        Context context = materialDialog.getContext();
        Intrinsics.checkExpressionValueIsNotNull(context, "dialog.context");
        return MDUtil.resolveColor$default(mDUtil, context, (Integer) null, Integer.valueOf(R.attr.md_divider_color), (Function0) null, 10, (Object) null);
    }

    @NotNull
    public final Paint a() {
        this.dividerPaint.setColor(getDividerColor());
        return this.dividerPaint;
    }

    @NotNull
    public final MaterialDialog getDialog() {
        MaterialDialog materialDialog = this.dialog;
        if (materialDialog == null) {
            Intrinsics.throwUninitializedPropertyAccessException(DialogNavigator.NAME);
        }
        return materialDialog;
    }

    public final int getDividerHeight() {
        return this.dividerHeight;
    }

    public final boolean getDrawDivider() {
        return this.drawDivider;
    }

    public final void setDialog(@NotNull MaterialDialog materialDialog) {
        Intrinsics.checkParameterIsNotNull(materialDialog, "<set-?>");
        this.dialog = materialDialog;
    }

    public final void setDrawDivider(boolean z11) {
        this.drawDivider = z11;
        invalidate();
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public BaseSubLayout(@NotNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        Intrinsics.checkParameterIsNotNull(context, "context");
        Paint paint = new Paint();
        this.dividerPaint = paint;
        MDUtil mDUtil = MDUtil.INSTANCE;
        int i11 = R.dimen.md_divider_height;
        this.dividerHeight = mDUtil.dimenPx(this, i11);
        setWillNotDraw(false);
        paint.setStyle(Paint.Style.STROKE);
        paint.setStrokeWidth(context.getResources().getDimension(i11));
        paint.setAntiAlias(true);
    }
}
