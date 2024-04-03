package com.afollestad.materialdialogs.internal.main;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;
import android.view.WindowManager;
import android.widget.FrameLayout;
import androidx.annotation.ColorInt;
import androidx.core.view.InputDeviceCompat;
import androidx.navigation.compose.DialogNavigator;
import com.afollestad.materialdialogs.LayoutMode;
import com.afollestad.materialdialogs.MaterialDialog;
import com.afollestad.materialdialogs.R;
import com.afollestad.materialdialogs.internal.button.DialogActionButton;
import com.afollestad.materialdialogs.internal.button.DialogActionButtonLayout;
import com.afollestad.materialdialogs.internal.button.DialogActionButtonLayoutKt;
import com.afollestad.materialdialogs.internal.message.DialogContentLayout;
import com.afollestad.materialdialogs.utils.DimensKt;
import com.afollestad.materialdialogs.utils.MDUtil;
import com.afollestad.materialdialogs.utils.ViewsKt;
import kotlin.Metadata;
import kotlin.TypeCastException;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0010\u0007\n\u0002\b\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0002\u0010\u0006J\u000e\u0010:\u001a\u00020;2\u0006\u0010\u0007\u001a\u00020\bJ\u000e\u0010<\u001a\u00020;2\u0006\u0010\u001c\u001a\u00020\u001dJ\u0016\u0010=\u001a\u00020;2\u0006\u0010>\u001a\u00020\u00142\u0006\u0010?\u001a\u00020\u0014J\b\u0010@\u001a\u00020;H\u0014J\u0010\u0010A\u001a\u00020;2\u0006\u0010B\u001a\u00020CH\u0014J\b\u0010D\u001a\u00020;H\u0014J0\u0010E\u001a\u00020;2\u0006\u0010F\u001a\u00020\u00142\u0006\u0010G\u001a\u00020#2\u0006\u0010H\u001a\u00020#2\u0006\u0010I\u001a\u00020#2\u0006\u0010J\u001a\u00020#H\u0014J\u0018\u0010K\u001a\u00020;2\u0006\u0010L\u001a\u00020#2\u0006\u0010M\u001a\u00020#H\u0014J\u001a\u0010N\u001a\u00020\u001b2\u0006\u0010O\u001a\u00020#2\b\b\u0002\u0010P\u001a\u00020QH\u0002J@\u0010R\u001a\u00020;*\u00020C2\b\b\u0001\u0010O\u001a\u00020#2\b\b\u0002\u0010P\u001a\u00020Q2\u0006\u0010G\u001a\u00020Q2\u0006\u0010I\u001a\u00020Q2\u0006\u0010H\u001a\u00020Q2\u0006\u0010J\u001a\u00020QH\u0002J*\u0010S\u001a\u00020;*\u00020C2\b\b\u0001\u0010O\u001a\u00020#2\b\b\u0002\u0010T\u001a\u00020Q2\b\b\u0002\u0010U\u001a\u00020QH\u0002J>\u0010V\u001a\u00020;*\u00020C2\b\b\u0001\u0010O\u001a\u00020#2\b\b\u0002\u0010G\u001a\u00020Q2\b\b\u0002\u0010I\u001a\u00020Q2\b\b\u0002\u0010H\u001a\u00020Q2\b\b\u0002\u0010J\u001a\u00020QH\u0002J(\u0010W\u001a\u00020;*\u00020C2\b\b\u0001\u0010O\u001a\u00020#2\u0006\u0010T\u001a\u00020Q2\b\b\u0002\u0010X\u001a\u00020QH\u0002R\u001c\u0010\u0007\u001a\u0004\u0018\u00010\bX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\fR\u001a\u0010\r\u001a\u00020\u000eX.¢\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012R$\u0010\u0015\u001a\u00020\u00142\u0006\u0010\u0013\u001a\u00020\u0014@FX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\u0017\"\u0004\b\u0018\u0010\u0019R\u0010\u0010\u001a\u001a\u0004\u0018\u00010\u001bX\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\u001c\u001a\u00020\u001dX.¢\u0006\u000e\n\u0000\u001a\u0004\b\u001e\u0010\u001f\"\u0004\b \u0010!R\u0014\u0010\"\u001a\u00020#X\u0004¢\u0006\b\n\u0000\u001a\u0004\b$\u0010%R\u0014\u0010&\u001a\u00020#X\u0004¢\u0006\b\n\u0000\u001a\u0004\b'\u0010%R\u000e\u0010(\u001a\u00020\u0014X\u000e¢\u0006\u0002\n\u0000R\u001a\u0010)\u001a\u00020*X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b+\u0010,\"\u0004\b-\u0010.R\u001a\u0010/\u001a\u00020#X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b0\u0010%\"\u0004\b1\u00102R\u001a\u00103\u001a\u000204X.¢\u0006\u000e\n\u0000\u001a\u0004\b5\u00106\"\u0004\b7\u00108R\u000e\u00109\u001a\u00020#X\u000e¢\u0006\u0002\n\u0000¨\u0006Y"}, d2 = {"Lcom/afollestad/materialdialogs/internal/main/DialogLayout;", "Landroid/widget/FrameLayout;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "buttonsLayout", "Lcom/afollestad/materialdialogs/internal/button/DialogActionButtonLayout;", "getButtonsLayout", "()Lcom/afollestad/materialdialogs/internal/button/DialogActionButtonLayout;", "setButtonsLayout", "(Lcom/afollestad/materialdialogs/internal/button/DialogActionButtonLayout;)V", "contentLayout", "Lcom/afollestad/materialdialogs/internal/message/DialogContentLayout;", "getContentLayout", "()Lcom/afollestad/materialdialogs/internal/message/DialogContentLayout;", "setContentLayout", "(Lcom/afollestad/materialdialogs/internal/message/DialogContentLayout;)V", "value", "", "debugMode", "getDebugMode", "()Z", "setDebugMode", "(Z)V", "debugPaint", "Landroid/graphics/Paint;", "dialog", "Lcom/afollestad/materialdialogs/MaterialDialog;", "getDialog", "()Lcom/afollestad/materialdialogs/MaterialDialog;", "setDialog", "(Lcom/afollestad/materialdialogs/MaterialDialog;)V", "frameMarginVertical", "", "getFrameMarginVertical$com_afollestad_material_dialogs_core", "()I", "frameMarginVerticalLess", "getFrameMarginVerticalLess$com_afollestad_material_dialogs_core", "isButtonsLayoutAChild", "layoutMode", "Lcom/afollestad/materialdialogs/LayoutMode;", "getLayoutMode", "()Lcom/afollestad/materialdialogs/LayoutMode;", "setLayoutMode", "(Lcom/afollestad/materialdialogs/LayoutMode;)V", "maxHeight", "getMaxHeight", "setMaxHeight", "(I)V", "titleLayout", "Lcom/afollestad/materialdialogs/internal/main/DialogTitleLayout;", "getTitleLayout", "()Lcom/afollestad/materialdialogs/internal/main/DialogTitleLayout;", "setTitleLayout", "(Lcom/afollestad/materialdialogs/internal/main/DialogTitleLayout;)V", "windowHeight", "attachButtonsLayout", "", "attachDialog", "invalidateDividers", "showTop", "showBottom", "onAttachedToWindow", "onDraw", "canvas", "Landroid/graphics/Canvas;", "onFinishInflate", "onLayout", "changed", "left", "top", "right", "bottom", "onMeasure", "widthMeasureSpec", "heightMeasureSpec", "paint", "color", "alpha", "", "box", "horizontalLine", "start", "height", "line", "verticalLine", "width", "com.afollestad.material-dialogs.core"}, k = 1, mv = {1, 1, 15})
public final class DialogLayout extends FrameLayout {
    @Nullable
    private DialogActionButtonLayout buttonsLayout;
    @NotNull
    public DialogContentLayout contentLayout;
    private boolean debugMode;
    private Paint debugPaint;
    @NotNull
    public MaterialDialog dialog;
    private final int frameMarginVertical;
    private final int frameMarginVerticalLess;
    private boolean isButtonsLayoutAChild = true;
    @NotNull
    private LayoutMode layoutMode = LayoutMode.WRAP_CONTENT;
    private int maxHeight;
    @NotNull
    public DialogTitleLayout titleLayout;
    private int windowHeight = -1;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public DialogLayout(@NotNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        Intrinsics.checkParameterIsNotNull(context, "context");
        MDUtil mDUtil = MDUtil.INSTANCE;
        this.frameMarginVertical = mDUtil.dimenPx(this, R.dimen.md_dialog_frame_margin_vertical);
        this.frameMarginVerticalLess = mDUtil.dimenPx(this, R.dimen.md_dialog_frame_margin_vertical_less);
    }

    public static /* synthetic */ void a(DialogLayout dialogLayout, Canvas canvas, int i11, float f11, float f12, int i12, Object obj) {
        if ((i12 & 2) != 0) {
            f11 = (float) dialogLayout.getMeasuredHeight();
        }
        if ((i12 & 4) != 0) {
            f12 = f11;
        }
        dialogLayout.horizontalLine(canvas, i11, f11, f12);
    }

    public static /* synthetic */ Paint b(DialogLayout dialogLayout, int i11, float f11, int i12, Object obj) {
        if ((i12 & 2) != 0) {
            f11 = 1.0f;
        }
        return dialogLayout.paint(i11, f11);
    }

    private final void box(@NotNull Canvas canvas, @ColorInt int i11, float f11, float f12, float f13, float f14, float f15) {
        canvas.drawRect(f12, f14, f13, f15, paint(i11, f11));
    }

    public static /* synthetic */ void c(DialogLayout dialogLayout, Canvas canvas, int i11, float f11, float f12, int i12, Object obj) {
        if ((i12 & 4) != 0) {
            f12 = f11;
        }
        dialogLayout.verticalLine(canvas, i11, f11, f12);
    }

    private final void horizontalLine(@NotNull Canvas canvas, @ColorInt int i11, float f11, float f12) {
        line(canvas, i11, 0.0f, (float) getMeasuredWidth(), f11, f12);
    }

    private final void line(@NotNull Canvas canvas, @ColorInt int i11, float f11, float f12, float f13, float f14) {
        canvas.drawLine(f11, f13, f12, f14, b(this, i11, 0.0f, 2, (Object) null));
    }

    private final Paint paint(int i11, float f11) {
        if (this.debugPaint == null) {
            Paint paint = new Paint();
            paint.setStrokeWidth(DimensKt.dp(this, 1));
            paint.setStyle(Paint.Style.FILL);
            paint.setAntiAlias(true);
            this.debugPaint = paint;
        }
        Paint paint2 = this.debugPaint;
        if (paint2 == null) {
            Intrinsics.throwNpe();
        }
        paint2.setColor(i11);
        setAlpha(f11);
        return paint2;
    }

    private final void verticalLine(@NotNull Canvas canvas, @ColorInt int i11, float f11, float f12) {
        line(canvas, i11, f11, f12, 0.0f, (float) getMeasuredHeight());
    }

    public final void attachButtonsLayout(@NotNull DialogActionButtonLayout dialogActionButtonLayout) {
        Intrinsics.checkParameterIsNotNull(dialogActionButtonLayout, "buttonsLayout");
        this.buttonsLayout = dialogActionButtonLayout;
        this.isButtonsLayoutAChild = false;
    }

    public final void attachDialog(@NotNull MaterialDialog materialDialog) {
        Intrinsics.checkParameterIsNotNull(materialDialog, DialogNavigator.NAME);
        DialogTitleLayout dialogTitleLayout = this.titleLayout;
        if (dialogTitleLayout == null) {
            Intrinsics.throwUninitializedPropertyAccessException("titleLayout");
        }
        dialogTitleLayout.setDialog(materialDialog);
        DialogActionButtonLayout dialogActionButtonLayout = this.buttonsLayout;
        if (dialogActionButtonLayout != null) {
            dialogActionButtonLayout.setDialog(materialDialog);
        }
    }

    @Nullable
    public final DialogActionButtonLayout getButtonsLayout() {
        return this.buttonsLayout;
    }

    @NotNull
    public final DialogContentLayout getContentLayout() {
        DialogContentLayout dialogContentLayout = this.contentLayout;
        if (dialogContentLayout == null) {
            Intrinsics.throwUninitializedPropertyAccessException("contentLayout");
        }
        return dialogContentLayout;
    }

    public final boolean getDebugMode() {
        return this.debugMode;
    }

    @NotNull
    public final MaterialDialog getDialog() {
        MaterialDialog materialDialog = this.dialog;
        if (materialDialog == null) {
            Intrinsics.throwUninitializedPropertyAccessException(DialogNavigator.NAME);
        }
        return materialDialog;
    }

    public final int getFrameMarginVertical$com_afollestad_material_dialogs_core() {
        return this.frameMarginVertical;
    }

    public final int getFrameMarginVerticalLess$com_afollestad_material_dialogs_core() {
        return this.frameMarginVerticalLess;
    }

    @NotNull
    public final LayoutMode getLayoutMode() {
        return this.layoutMode;
    }

    public final int getMaxHeight() {
        return this.maxHeight;
    }

    @NotNull
    public final DialogTitleLayout getTitleLayout() {
        DialogTitleLayout dialogTitleLayout = this.titleLayout;
        if (dialogTitleLayout == null) {
            Intrinsics.throwUninitializedPropertyAccessException("titleLayout");
        }
        return dialogTitleLayout;
    }

    public final void invalidateDividers(boolean z11, boolean z12) {
        DialogTitleLayout dialogTitleLayout = this.titleLayout;
        if (dialogTitleLayout == null) {
            Intrinsics.throwUninitializedPropertyAccessException("titleLayout");
        }
        dialogTitleLayout.setDrawDivider(z11);
        DialogActionButtonLayout dialogActionButtonLayout = this.buttonsLayout;
        if (dialogActionButtonLayout != null) {
            dialogActionButtonLayout.setDrawDivider(z12);
        }
    }

    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        Object systemService = getContext().getSystemService("window");
        if (systemService != null) {
            this.windowHeight = MDUtil.INSTANCE.getWidthAndHeight((WindowManager) systemService).component2().intValue();
            return;
        }
        throw new TypeCastException("null cannot be cast to non-null type android.view.WindowManager");
    }

    public void onDraw(@NotNull Canvas canvas) {
        float f11;
        Intrinsics.checkParameterIsNotNull(canvas, "canvas");
        super.onDraw(canvas);
        if (this.debugMode) {
            Canvas canvas2 = canvas;
            c(this, canvas2, -16776961, DimensKt.dp(this, 24), 0.0f, 4, (Object) null);
            a(this, canvas2, -16776961, DimensKt.dp(this, 24), 0.0f, 4, (Object) null);
            c(this, canvas, -16776961, ((float) getMeasuredWidth()) - DimensKt.dp(this, 24), 0.0f, 4, (Object) null);
            DialogTitleLayout dialogTitleLayout = this.titleLayout;
            if (dialogTitleLayout == null) {
                Intrinsics.throwUninitializedPropertyAccessException("titleLayout");
            }
            if (ViewsKt.isVisible(dialogTitleLayout)) {
                DialogTitleLayout dialogTitleLayout2 = this.titleLayout;
                if (dialogTitleLayout2 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("titleLayout");
                }
                a(this, canvas, -65536, (float) dialogTitleLayout2.getBottom(), 0.0f, 4, (Object) null);
            }
            DialogContentLayout dialogContentLayout = this.contentLayout;
            if (dialogContentLayout == null) {
                Intrinsics.throwUninitializedPropertyAccessException("contentLayout");
            }
            if (ViewsKt.isVisible(dialogContentLayout)) {
                DialogContentLayout dialogContentLayout2 = this.contentLayout;
                if (dialogContentLayout2 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("contentLayout");
                }
                a(this, canvas, InputDeviceCompat.SOURCE_ANY, (float) dialogContentLayout2.getTop(), 0.0f, 4, (Object) null);
            }
            if (DialogActionButtonLayoutKt.shouldBeVisible(this.buttonsLayout)) {
                if (ViewsKt.isRtl(this)) {
                    f11 = DimensKt.dp(this, 8);
                } else {
                    f11 = ((float) getMeasuredWidth()) - DimensKt.dp(this, 8);
                }
                c(this, canvas, -16711681, f11, 0.0f, 4, (Object) null);
                DialogActionButtonLayout dialogActionButtonLayout = this.buttonsLayout;
                if (dialogActionButtonLayout == null || !dialogActionButtonLayout.getStackButtons$com_afollestad_material_dialogs_core()) {
                    DialogActionButtonLayout dialogActionButtonLayout2 = this.buttonsLayout;
                    if (dialogActionButtonLayout2 != null) {
                        if (dialogActionButtonLayout2 == null) {
                            Intrinsics.throwNpe();
                        }
                        for (DialogActionButton dialogActionButton : dialogActionButtonLayout2.getVisibleButtons()) {
                            DialogActionButtonLayout dialogActionButtonLayout3 = this.buttonsLayout;
                            if (dialogActionButtonLayout3 == null) {
                                Intrinsics.throwNpe();
                            }
                            float top = ((float) dialogActionButtonLayout3.getTop()) + ((float) dialogActionButton.getTop()) + DimensKt.dp(this, 8);
                            DialogActionButtonLayout dialogActionButtonLayout4 = this.buttonsLayout;
                            if (dialogActionButtonLayout4 == null) {
                                Intrinsics.throwNpe();
                            }
                            box(canvas, -16711681, 0.4f, ((float) dialogActionButton.getLeft()) + DimensKt.dp(this, 4), ((float) dialogActionButton.getRight()) - DimensKt.dp(this, 4), top, ((float) dialogActionButtonLayout4.getBottom()) - DimensKt.dp(this, 8));
                        }
                        DialogActionButtonLayout dialogActionButtonLayout5 = this.buttonsLayout;
                        if (dialogActionButtonLayout5 == null) {
                            Intrinsics.throwNpe();
                        }
                        a(this, canvas, -65281, (float) dialogActionButtonLayout5.getTop(), 0.0f, 4, (Object) null);
                        float measuredHeight = ((float) getMeasuredHeight()) - (DimensKt.dp(this, 52) - DimensKt.dp(this, 8));
                        float measuredHeight2 = ((float) getMeasuredHeight()) - DimensKt.dp(this, 8);
                        Canvas canvas3 = canvas;
                        a(this, canvas3, -65536, measuredHeight, 0.0f, 4, (Object) null);
                        a(this, canvas3, -65536, measuredHeight2, 0.0f, 4, (Object) null);
                        a(this, canvas3, -16776961, measuredHeight - DimensKt.dp(this, 8), 0.0f, 4, (Object) null);
                        return;
                    }
                    return;
                }
                DialogActionButtonLayout dialogActionButtonLayout6 = this.buttonsLayout;
                if (dialogActionButtonLayout6 == null) {
                    Intrinsics.throwNpe();
                }
                float top2 = ((float) dialogActionButtonLayout6.getTop()) + DimensKt.dp(this, 8);
                DialogActionButtonLayout dialogActionButtonLayout7 = this.buttonsLayout;
                if (dialogActionButtonLayout7 == null) {
                    Intrinsics.throwNpe();
                }
                float f12 = top2;
                for (DialogActionButton left : dialogActionButtonLayout7.getVisibleButtons()) {
                    float dp2 = f12 + DimensKt.dp(this, 36);
                    box(canvas, -16711681, 0.4f, (float) left.getLeft(), ((float) getMeasuredWidth()) - DimensKt.dp(this, 8), f12, dp2);
                    f12 = dp2 + DimensKt.dp(this, 16);
                }
                DialogActionButtonLayout dialogActionButtonLayout8 = this.buttonsLayout;
                if (dialogActionButtonLayout8 == null) {
                    Intrinsics.throwNpe();
                }
                a(this, canvas, -16776961, (float) dialogActionButtonLayout8.getTop(), 0.0f, 4, (Object) null);
                DialogActionButtonLayout dialogActionButtonLayout9 = this.buttonsLayout;
                if (dialogActionButtonLayout9 == null) {
                    Intrinsics.throwNpe();
                }
                float top3 = ((float) dialogActionButtonLayout9.getTop()) + DimensKt.dp(this, 8);
                float measuredHeight3 = ((float) getMeasuredHeight()) - DimensKt.dp(this, 8);
                Canvas canvas4 = canvas;
                a(this, canvas4, -65536, top3, 0.0f, 4, (Object) null);
                a(this, canvas4, -65536, measuredHeight3, 0.0f, 4, (Object) null);
            }
        }
    }

    public void onFinishInflate() {
        super.onFinishInflate();
        View findViewById = findViewById(R.id.md_title_layout);
        Intrinsics.checkExpressionValueIsNotNull(findViewById, "findViewById(R.id.md_title_layout)");
        this.titleLayout = (DialogTitleLayout) findViewById;
        View findViewById2 = findViewById(R.id.md_content_layout);
        Intrinsics.checkExpressionValueIsNotNull(findViewById2, "findViewById(R.id.md_content_layout)");
        this.contentLayout = (DialogContentLayout) findViewById2;
        this.buttonsLayout = (DialogActionButtonLayout) findViewById(R.id.md_button_layout);
    }

    public void onLayout(boolean z11, int i11, int i12, int i13, int i14) {
        int i15;
        int i16;
        int measuredWidth = getMeasuredWidth();
        DialogTitleLayout dialogTitleLayout = this.titleLayout;
        if (dialogTitleLayout == null) {
            Intrinsics.throwUninitializedPropertyAccessException("titleLayout");
        }
        int measuredHeight = dialogTitleLayout.getMeasuredHeight();
        DialogTitleLayout dialogTitleLayout2 = this.titleLayout;
        if (dialogTitleLayout2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("titleLayout");
        }
        dialogTitleLayout2.layout(0, 0, measuredWidth, measuredHeight);
        if (this.isButtonsLayoutAChild) {
            int measuredHeight2 = getMeasuredHeight();
            DialogActionButtonLayout dialogActionButtonLayout = this.buttonsLayout;
            if (dialogActionButtonLayout != null) {
                i16 = dialogActionButtonLayout.getMeasuredHeight();
            } else {
                i16 = 0;
            }
            i15 = measuredHeight2 - i16;
            if (DialogActionButtonLayoutKt.shouldBeVisible(this.buttonsLayout)) {
                int measuredWidth2 = getMeasuredWidth();
                int measuredHeight3 = getMeasuredHeight();
                DialogActionButtonLayout dialogActionButtonLayout2 = this.buttonsLayout;
                if (dialogActionButtonLayout2 == null) {
                    Intrinsics.throwNpe();
                }
                dialogActionButtonLayout2.layout(0, i15, measuredWidth2, measuredHeight3);
            }
        } else {
            i15 = getMeasuredHeight();
        }
        int measuredWidth3 = getMeasuredWidth();
        DialogContentLayout dialogContentLayout = this.contentLayout;
        if (dialogContentLayout == null) {
            Intrinsics.throwUninitializedPropertyAccessException("contentLayout");
        }
        dialogContentLayout.layout(0, measuredHeight, measuredWidth3, i15);
    }

    public void onMeasure(int i11, int i12) {
        int i13;
        int size = View.MeasureSpec.getSize(i11);
        int size2 = View.MeasureSpec.getSize(i12);
        int i14 = this.maxHeight;
        if (1 <= i14 && size2 > i14) {
            size2 = i14;
        }
        DialogTitleLayout dialogTitleLayout = this.titleLayout;
        if (dialogTitleLayout == null) {
            Intrinsics.throwUninitializedPropertyAccessException("titleLayout");
        }
        int i15 = 0;
        dialogTitleLayout.measure(View.MeasureSpec.makeMeasureSpec(size, 1073741824), View.MeasureSpec.makeMeasureSpec(0, 0));
        if (DialogActionButtonLayoutKt.shouldBeVisible(this.buttonsLayout)) {
            DialogActionButtonLayout dialogActionButtonLayout = this.buttonsLayout;
            if (dialogActionButtonLayout == null) {
                Intrinsics.throwNpe();
            }
            dialogActionButtonLayout.measure(View.MeasureSpec.makeMeasureSpec(size, 1073741824), View.MeasureSpec.makeMeasureSpec(0, 0));
        }
        DialogTitleLayout dialogTitleLayout2 = this.titleLayout;
        if (dialogTitleLayout2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("titleLayout");
        }
        int measuredHeight = dialogTitleLayout2.getMeasuredHeight();
        DialogActionButtonLayout dialogActionButtonLayout2 = this.buttonsLayout;
        if (dialogActionButtonLayout2 != null) {
            i13 = dialogActionButtonLayout2.getMeasuredHeight();
        } else {
            i13 = 0;
        }
        int i16 = size2 - (measuredHeight + i13);
        DialogContentLayout dialogContentLayout = this.contentLayout;
        if (dialogContentLayout == null) {
            Intrinsics.throwUninitializedPropertyAccessException("contentLayout");
        }
        dialogContentLayout.measure(View.MeasureSpec.makeMeasureSpec(size, 1073741824), View.MeasureSpec.makeMeasureSpec(i16, Integer.MIN_VALUE));
        if (this.layoutMode == LayoutMode.WRAP_CONTENT) {
            DialogTitleLayout dialogTitleLayout3 = this.titleLayout;
            if (dialogTitleLayout3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("titleLayout");
            }
            int measuredHeight2 = dialogTitleLayout3.getMeasuredHeight();
            DialogContentLayout dialogContentLayout2 = this.contentLayout;
            if (dialogContentLayout2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("contentLayout");
            }
            int measuredHeight3 = measuredHeight2 + dialogContentLayout2.getMeasuredHeight();
            DialogActionButtonLayout dialogActionButtonLayout3 = this.buttonsLayout;
            if (dialogActionButtonLayout3 != null) {
                i15 = dialogActionButtonLayout3.getMeasuredHeight();
            }
            setMeasuredDimension(size, measuredHeight3 + i15);
            return;
        }
        setMeasuredDimension(size, this.windowHeight);
    }

    public final void setButtonsLayout(@Nullable DialogActionButtonLayout dialogActionButtonLayout) {
        this.buttonsLayout = dialogActionButtonLayout;
    }

    public final void setContentLayout(@NotNull DialogContentLayout dialogContentLayout) {
        Intrinsics.checkParameterIsNotNull(dialogContentLayout, "<set-?>");
        this.contentLayout = dialogContentLayout;
    }

    public final void setDebugMode(boolean z11) {
        this.debugMode = z11;
        setWillNotDraw(!z11);
    }

    public final void setDialog(@NotNull MaterialDialog materialDialog) {
        Intrinsics.checkParameterIsNotNull(materialDialog, "<set-?>");
        this.dialog = materialDialog;
    }

    public final void setLayoutMode(@NotNull LayoutMode layoutMode2) {
        Intrinsics.checkParameterIsNotNull(layoutMode2, "<set-?>");
        this.layoutMode = layoutMode2;
    }

    public final void setMaxHeight(int i11) {
        this.maxHeight = i11;
    }

    public final void setTitleLayout(@NotNull DialogTitleLayout dialogTitleLayout) {
        Intrinsics.checkParameterIsNotNull(dialogTitleLayout, "<set-?>");
        this.titleLayout = dialogTitleLayout;
    }
}
