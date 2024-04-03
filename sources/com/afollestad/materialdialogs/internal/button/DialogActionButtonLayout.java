package com.afollestad.materialdialogs.internal.button;

import android.content.Context;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.view.View;
import androidx.annotation.RestrictTo;
import androidx.appcompat.widget.AppCompatCheckBox;
import com.afollestad.materialdialogs.R;
import com.afollestad.materialdialogs.WhichButton;
import com.afollestad.materialdialogs.internal.main.BaseSubLayout;
import com.afollestad.materialdialogs.utils.MDUtil;
import com.afollestad.materialdialogs.utils.ViewsKt;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.TypeCastException;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\r\b\u0007\u0018\u0000 22\u00020\u0001:\u00012B\u0019\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0002\u0010\u0006J\u0010\u0010#\u001a\u00020$2\u0006\u0010%\u001a\u00020&H\u0014J\b\u0010'\u001a\u00020$H\u0014J0\u0010(\u001a\u00020$2\u0006\u0010)\u001a\u00020\u001c2\u0006\u0010*\u001a\u00020\u00102\u0006\u0010+\u001a\u00020\u00102\u0006\u0010,\u001a\u00020\u00102\u0006\u0010-\u001a\u00020\u0010H\u0014J\u0018\u0010.\u001a\u00020$2\u0006\u0010/\u001a\u00020\u00102\u0006\u00100\u001a\u00020\u0010H\u0014J\b\u00101\u001a\u00020\u0010H\u0002R\"\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\bX.¢\u0006\u0010\n\u0002\u0010\u000e\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\rR\u000e\u0010\u000f\u001a\u00020\u0010X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0010X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0010X\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u0013\u001a\u00020\u0014X.¢\u0006\u000e\n\u0000\u001a\u0004\b\u0015\u0010\u0016\"\u0004\b\u0017\u0010\u0018R\u000e\u0010\u0019\u001a\u00020\u0010X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u001a\u001a\u00020\u0010X\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u001b\u001a\u00020\u001cX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001d\u0010\u001e\"\u0004\b\u001f\u0010 R\u0017\u0010!\u001a\b\u0012\u0004\u0012\u00020\t0\b8F¢\u0006\u0006\u001a\u0004\b\"\u0010\u000b¨\u00063"}, d2 = {"Lcom/afollestad/materialdialogs/internal/button/DialogActionButtonLayout;", "Lcom/afollestad/materialdialogs/internal/main/BaseSubLayout;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "actionButtons", "", "Lcom/afollestad/materialdialogs/internal/button/DialogActionButton;", "getActionButtons", "()[Lcom/afollestad/materialdialogs/internal/button/DialogActionButton;", "setActionButtons", "([Lcom/afollestad/materialdialogs/internal/button/DialogActionButton;)V", "[Lcom/afollestad/materialdialogs/internal/button/DialogActionButton;", "buttonFramePadding", "", "buttonFramePaddingNeutral", "buttonFrameSpecHeight", "checkBoxPrompt", "Landroidx/appcompat/widget/AppCompatCheckBox;", "getCheckBoxPrompt", "()Landroidx/appcompat/widget/AppCompatCheckBox;", "setCheckBoxPrompt", "(Landroidx/appcompat/widget/AppCompatCheckBox;)V", "checkBoxPromptMarginHorizontal", "checkBoxPromptMarginVertical", "stackButtons", "", "getStackButtons$com_afollestad_material_dialogs_core", "()Z", "setStackButtons$com_afollestad_material_dialogs_core", "(Z)V", "visibleButtons", "getVisibleButtons", "onDraw", "", "canvas", "Landroid/graphics/Canvas;", "onFinishInflate", "onLayout", "changed", "left", "top", "right", "bottom", "onMeasure", "widthMeasureSpec", "heightMeasureSpec", "requiredHeightForButtons", "Companion", "com.afollestad.material-dialogs.core"}, k = 1, mv = {1, 1, 15})
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
public final class DialogActionButtonLayout extends BaseSubLayout {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    public static final int INDEX_NEGATIVE = 1;
    public static final int INDEX_NEUTRAL = 2;
    public static final int INDEX_POSITIVE = 0;
    @NotNull
    public DialogActionButton[] actionButtons;
    private final int buttonFramePadding;
    private final int buttonFramePaddingNeutral;
    private final int buttonFrameSpecHeight;
    @NotNull
    public AppCompatCheckBox checkBoxPrompt;
    private final int checkBoxPromptMarginHorizontal;
    private final int checkBoxPromptMarginVertical;
    private boolean stackButtons;

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0007"}, d2 = {"Lcom/afollestad/materialdialogs/internal/button/DialogActionButtonLayout$Companion;", "", "()V", "INDEX_NEGATIVE", "", "INDEX_NEUTRAL", "INDEX_POSITIVE", "com.afollestad.material-dialogs.core"}, k = 1, mv = {1, 1, 15})
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ DialogActionButtonLayout(Context context, AttributeSet attributeSet, int i11, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i11 & 2) != 0 ? null : attributeSet);
    }

    private final int requiredHeightForButtons() {
        boolean z11;
        if (getVisibleButtons().length == 0) {
            z11 = true;
        } else {
            z11 = false;
        }
        if (z11) {
            return 0;
        }
        if (!this.stackButtons) {
            return this.buttonFrameSpecHeight;
        }
        return this.buttonFrameSpecHeight * getVisibleButtons().length;
    }

    @NotNull
    public final DialogActionButton[] getActionButtons() {
        DialogActionButton[] dialogActionButtonArr = this.actionButtons;
        if (dialogActionButtonArr == null) {
            Intrinsics.throwUninitializedPropertyAccessException("actionButtons");
        }
        return dialogActionButtonArr;
    }

    @NotNull
    public final AppCompatCheckBox getCheckBoxPrompt() {
        AppCompatCheckBox appCompatCheckBox = this.checkBoxPrompt;
        if (appCompatCheckBox == null) {
            Intrinsics.throwUninitializedPropertyAccessException("checkBoxPrompt");
        }
        return appCompatCheckBox;
    }

    public final boolean getStackButtons$com_afollestad_material_dialogs_core() {
        return this.stackButtons;
    }

    @NotNull
    public final DialogActionButton[] getVisibleButtons() {
        DialogActionButton[] dialogActionButtonArr = this.actionButtons;
        if (dialogActionButtonArr == null) {
            Intrinsics.throwUninitializedPropertyAccessException("actionButtons");
        }
        ArrayList arrayList = new ArrayList();
        for (DialogActionButton dialogActionButton : dialogActionButtonArr) {
            if (ViewsKt.isVisible(dialogActionButton)) {
                arrayList.add(dialogActionButton);
            }
        }
        Object[] array = arrayList.toArray(new DialogActionButton[0]);
        if (array != null) {
            return (DialogActionButton[]) array;
        }
        throw new TypeCastException("null cannot be cast to non-null type kotlin.Array<T>");
    }

    public void onDraw(@NotNull Canvas canvas) {
        Intrinsics.checkParameterIsNotNull(canvas, "canvas");
        super.onDraw(canvas);
        if (getDrawDivider()) {
            canvas.drawLine(0.0f, 0.0f, (float) getMeasuredWidth(), (float) getDividerHeight(), a());
        }
    }

    public void onFinishInflate() {
        super.onFinishInflate();
        View findViewById = findViewById(R.id.md_button_positive);
        Intrinsics.checkExpressionValueIsNotNull(findViewById, "findViewById(R.id.md_button_positive)");
        View findViewById2 = findViewById(R.id.md_button_negative);
        Intrinsics.checkExpressionValueIsNotNull(findViewById2, "findViewById(R.id.md_button_negative)");
        View findViewById3 = findViewById(R.id.md_button_neutral);
        Intrinsics.checkExpressionValueIsNotNull(findViewById3, "findViewById(R.id.md_button_neutral)");
        this.actionButtons = new DialogActionButton[]{(DialogActionButton) findViewById, (DialogActionButton) findViewById2, (DialogActionButton) findViewById3};
        View findViewById4 = findViewById(R.id.md_checkbox_prompt);
        Intrinsics.checkExpressionValueIsNotNull(findViewById4, "findViewById(R.id.md_checkbox_prompt)");
        this.checkBoxPrompt = (AppCompatCheckBox) findViewById4;
        DialogActionButton[] dialogActionButtonArr = this.actionButtons;
        if (dialogActionButtonArr == null) {
            Intrinsics.throwUninitializedPropertyAccessException("actionButtons");
        }
        int length = dialogActionButtonArr.length;
        for (int i11 = 0; i11 < length; i11++) {
            dialogActionButtonArr[i11].setOnClickListener(new DialogActionButtonLayout$onFinishInflate$1(this, WhichButton.Companion.fromIndex(i11)));
        }
    }

    public void onLayout(boolean z11, int i11, int i12, int i13, int i14) {
        int i15;
        int i16;
        int i17;
        int i18;
        if (DialogActionButtonLayoutKt.shouldBeVisible(this)) {
            AppCompatCheckBox appCompatCheckBox = this.checkBoxPrompt;
            if (appCompatCheckBox == null) {
                Intrinsics.throwUninitializedPropertyAccessException("checkBoxPrompt");
            }
            if (ViewsKt.isVisible(appCompatCheckBox)) {
                if (ViewsKt.isRtl(this)) {
                    i18 = getMeasuredWidth() - this.checkBoxPromptMarginHorizontal;
                    i17 = this.checkBoxPromptMarginVertical;
                    AppCompatCheckBox appCompatCheckBox2 = this.checkBoxPrompt;
                    if (appCompatCheckBox2 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("checkBoxPrompt");
                    }
                    i16 = i18 - appCompatCheckBox2.getMeasuredWidth();
                    AppCompatCheckBox appCompatCheckBox3 = this.checkBoxPrompt;
                    if (appCompatCheckBox3 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("checkBoxPrompt");
                    }
                    i15 = appCompatCheckBox3.getMeasuredHeight();
                } else {
                    i16 = this.checkBoxPromptMarginHorizontal;
                    i17 = this.checkBoxPromptMarginVertical;
                    AppCompatCheckBox appCompatCheckBox4 = this.checkBoxPrompt;
                    if (appCompatCheckBox4 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("checkBoxPrompt");
                    }
                    i18 = appCompatCheckBox4.getMeasuredWidth() + i16;
                    AppCompatCheckBox appCompatCheckBox5 = this.checkBoxPrompt;
                    if (appCompatCheckBox5 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("checkBoxPrompt");
                    }
                    i15 = appCompatCheckBox5.getMeasuredHeight();
                }
                int i19 = i15 + i17;
                AppCompatCheckBox appCompatCheckBox6 = this.checkBoxPrompt;
                if (appCompatCheckBox6 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("checkBoxPrompt");
                }
                appCompatCheckBox6.layout(i16, i17, i18, i19);
            }
            if (this.stackButtons) {
                int i21 = this.buttonFramePadding;
                int measuredWidth = getMeasuredWidth() - this.buttonFramePadding;
                int measuredHeight = getMeasuredHeight();
                for (DialogActionButton layout : ArraysKt___ArraysKt.reversed((T[]) getVisibleButtons())) {
                    int i22 = measuredHeight - this.buttonFrameSpecHeight;
                    layout.layout(i21, i22, measuredWidth, measuredHeight);
                    measuredHeight = i22;
                }
                return;
            }
            int measuredHeight2 = getMeasuredHeight() - this.buttonFrameSpecHeight;
            int measuredHeight3 = getMeasuredHeight();
            if (ViewsKt.isRtl(this)) {
                DialogActionButton[] dialogActionButtonArr = this.actionButtons;
                if (dialogActionButtonArr == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("actionButtons");
                }
                if (ViewsKt.isVisible(dialogActionButtonArr[2])) {
                    DialogActionButton[] dialogActionButtonArr2 = this.actionButtons;
                    if (dialogActionButtonArr2 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("actionButtons");
                    }
                    DialogActionButton dialogActionButton = dialogActionButtonArr2[2];
                    int measuredWidth2 = getMeasuredWidth() - this.buttonFramePaddingNeutral;
                    dialogActionButton.layout(measuredWidth2 - dialogActionButton.getMeasuredWidth(), measuredHeight2, measuredWidth2, measuredHeight3);
                }
                int i23 = this.buttonFramePadding;
                DialogActionButton[] dialogActionButtonArr3 = this.actionButtons;
                if (dialogActionButtonArr3 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("actionButtons");
                }
                if (ViewsKt.isVisible(dialogActionButtonArr3[0])) {
                    DialogActionButton[] dialogActionButtonArr4 = this.actionButtons;
                    if (dialogActionButtonArr4 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("actionButtons");
                    }
                    DialogActionButton dialogActionButton2 = dialogActionButtonArr4[0];
                    int measuredWidth3 = dialogActionButton2.getMeasuredWidth() + i23;
                    dialogActionButton2.layout(i23, measuredHeight2, measuredWidth3, measuredHeight3);
                    i23 = measuredWidth3;
                }
                DialogActionButton[] dialogActionButtonArr5 = this.actionButtons;
                if (dialogActionButtonArr5 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("actionButtons");
                }
                if (ViewsKt.isVisible(dialogActionButtonArr5[1])) {
                    DialogActionButton[] dialogActionButtonArr6 = this.actionButtons;
                    if (dialogActionButtonArr6 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("actionButtons");
                    }
                    DialogActionButton dialogActionButton3 = dialogActionButtonArr6[1];
                    dialogActionButton3.layout(i23, measuredHeight2, dialogActionButton3.getMeasuredWidth() + i23, measuredHeight3);
                    return;
                }
                return;
            }
            DialogActionButton[] dialogActionButtonArr7 = this.actionButtons;
            if (dialogActionButtonArr7 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("actionButtons");
            }
            if (ViewsKt.isVisible(dialogActionButtonArr7[2])) {
                DialogActionButton[] dialogActionButtonArr8 = this.actionButtons;
                if (dialogActionButtonArr8 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("actionButtons");
                }
                DialogActionButton dialogActionButton4 = dialogActionButtonArr8[2];
                int i24 = this.buttonFramePaddingNeutral;
                dialogActionButton4.layout(i24, measuredHeight2, dialogActionButton4.getMeasuredWidth() + i24, measuredHeight3);
            }
            int measuredWidth4 = getMeasuredWidth() - this.buttonFramePadding;
            DialogActionButton[] dialogActionButtonArr9 = this.actionButtons;
            if (dialogActionButtonArr9 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("actionButtons");
            }
            if (ViewsKt.isVisible(dialogActionButtonArr9[0])) {
                DialogActionButton[] dialogActionButtonArr10 = this.actionButtons;
                if (dialogActionButtonArr10 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("actionButtons");
                }
                DialogActionButton dialogActionButton5 = dialogActionButtonArr10[0];
                int measuredWidth5 = measuredWidth4 - dialogActionButton5.getMeasuredWidth();
                dialogActionButton5.layout(measuredWidth5, measuredHeight2, measuredWidth4, measuredHeight3);
                measuredWidth4 = measuredWidth5;
            }
            DialogActionButton[] dialogActionButtonArr11 = this.actionButtons;
            if (dialogActionButtonArr11 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("actionButtons");
            }
            if (ViewsKt.isVisible(dialogActionButtonArr11[1])) {
                DialogActionButton[] dialogActionButtonArr12 = this.actionButtons;
                if (dialogActionButtonArr12 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("actionButtons");
                }
                DialogActionButton dialogActionButton6 = dialogActionButtonArr12[1];
                dialogActionButton6.layout(measuredWidth4 - dialogActionButton6.getMeasuredWidth(), measuredHeight2, measuredWidth4, measuredHeight3);
            }
        }
    }

    public void onMeasure(int i11, int i12) {
        boolean z11;
        if (!DialogActionButtonLayoutKt.shouldBeVisible(this)) {
            setMeasuredDimension(0, 0);
            return;
        }
        int size = View.MeasureSpec.getSize(i11);
        AppCompatCheckBox appCompatCheckBox = this.checkBoxPrompt;
        if (appCompatCheckBox == null) {
            Intrinsics.throwUninitializedPropertyAccessException("checkBoxPrompt");
        }
        if (ViewsKt.isVisible(appCompatCheckBox)) {
            int i13 = size - (this.checkBoxPromptMarginHorizontal * 2);
            AppCompatCheckBox appCompatCheckBox2 = this.checkBoxPrompt;
            if (appCompatCheckBox2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("checkBoxPrompt");
            }
            appCompatCheckBox2.measure(View.MeasureSpec.makeMeasureSpec(i13, Integer.MIN_VALUE), View.MeasureSpec.makeMeasureSpec(0, 0));
        }
        Context context = getDialog().getContext();
        Intrinsics.checkExpressionValueIsNotNull(context, "dialog.context");
        Context windowContext = getDialog().getWindowContext();
        for (DialogActionButton dialogActionButton : getVisibleButtons()) {
            dialogActionButton.update$com_afollestad_material_dialogs_core(context, windowContext, this.stackButtons);
            if (this.stackButtons) {
                dialogActionButton.measure(View.MeasureSpec.makeMeasureSpec(size, 1073741824), View.MeasureSpec.makeMeasureSpec(this.buttonFrameSpecHeight, 1073741824));
            } else {
                dialogActionButton.measure(View.MeasureSpec.makeMeasureSpec(0, 0), View.MeasureSpec.makeMeasureSpec(this.buttonFrameSpecHeight, 1073741824));
            }
        }
        if (getVisibleButtons().length == 0) {
            z11 = true;
        } else {
            z11 = false;
        }
        if ((!z11) && !this.stackButtons) {
            int i14 = 0;
            for (DialogActionButton measuredWidth : getVisibleButtons()) {
                i14 += measuredWidth.getMeasuredWidth();
            }
            if (i14 >= size && !this.stackButtons) {
                this.stackButtons = true;
                for (DialogActionButton dialogActionButton2 : getVisibleButtons()) {
                    dialogActionButton2.update$com_afollestad_material_dialogs_core(context, windowContext, true);
                    dialogActionButton2.measure(View.MeasureSpec.makeMeasureSpec(size, 1073741824), View.MeasureSpec.makeMeasureSpec(this.buttonFrameSpecHeight, 1073741824));
                }
            }
        }
        int requiredHeightForButtons = requiredHeightForButtons();
        AppCompatCheckBox appCompatCheckBox3 = this.checkBoxPrompt;
        if (appCompatCheckBox3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("checkBoxPrompt");
        }
        if (ViewsKt.isVisible(appCompatCheckBox3)) {
            AppCompatCheckBox appCompatCheckBox4 = this.checkBoxPrompt;
            if (appCompatCheckBox4 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("checkBoxPrompt");
            }
            requiredHeightForButtons += appCompatCheckBox4.getMeasuredHeight() + (this.checkBoxPromptMarginVertical * 2);
        }
        setMeasuredDimension(size, requiredHeightForButtons);
    }

    public final void setActionButtons(@NotNull DialogActionButton[] dialogActionButtonArr) {
        Intrinsics.checkParameterIsNotNull(dialogActionButtonArr, "<set-?>");
        this.actionButtons = dialogActionButtonArr;
    }

    public final void setCheckBoxPrompt(@NotNull AppCompatCheckBox appCompatCheckBox) {
        Intrinsics.checkParameterIsNotNull(appCompatCheckBox, "<set-?>");
        this.checkBoxPrompt = appCompatCheckBox;
    }

    public final void setStackButtons$com_afollestad_material_dialogs_core(boolean z11) {
        this.stackButtons = z11;
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public DialogActionButtonLayout(@NotNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        Intrinsics.checkParameterIsNotNull(context, "context");
        MDUtil mDUtil = MDUtil.INSTANCE;
        this.buttonFramePadding = mDUtil.dimenPx(this, R.dimen.md_action_button_frame_padding) - mDUtil.dimenPx(this, R.dimen.md_action_button_inset_horizontal);
        this.buttonFramePaddingNeutral = mDUtil.dimenPx(this, R.dimen.md_action_button_frame_padding_neutral);
        this.buttonFrameSpecHeight = mDUtil.dimenPx(this, R.dimen.md_action_button_frame_spec_height);
        this.checkBoxPromptMarginVertical = mDUtil.dimenPx(this, R.dimen.md_checkbox_prompt_margin_vertical);
        this.checkBoxPromptMarginHorizontal = mDUtil.dimenPx(this, R.dimen.md_checkbox_prompt_margin_horizontal);
    }
}
