package com.instabug.library.ui.custom;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.View;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.instabug.library.R;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@SuppressLint({"Recycle"})
public final class InstabugEditText extends LinearLayout {
    @NotNull
    private final EditText editText;
    @NotNull
    private final TextView labelTextView;

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public InstabugEditText(@NotNull Context context) {
        this(context, (AttributeSet) null, 0, 6, (DefaultConstructorMarker) null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public InstabugEditText(@NotNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, (DefaultConstructorMarker) null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ InstabugEditText(Context context, AttributeSet attributeSet, int i11, int i12, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i12 & 2) != 0 ? null : attributeSet, (i12 & 4) != 0 ? 0 : i11);
    }

    private final void fillViewsFromAttrs(TypedArray typedArray) {
        try {
            this.editText.setText(getText(typedArray));
            this.labelTextView.setText(getLabel(typedArray));
            this.editText.setInputType(getInputType(typedArray));
            this.editText.setHint(getHint(typedArray));
            this.editText.setSingleLine(isSingleLine(typedArray));
        } finally {
            typedArray.recycle();
        }
    }

    private final CharSequence getHint(TypedArray typedArray) {
        return typedArray.getText(R.styleable.InstabugEditText_android_hint);
    }

    private final int getInputType(TypedArray typedArray) {
        return typedArray.getInt(R.styleable.InstabugEditText_android_inputType, 1);
    }

    private final CharSequence getLabel(TypedArray typedArray) {
        return typedArray.getText(R.styleable.InstabugEditText_ib_edit_label);
    }

    private final CharSequence getText(TypedArray typedArray) {
        return typedArray.getText(R.styleable.InstabugEditText_android_text);
    }

    private final boolean isSingleLine(TypedArray typedArray) {
        return typedArray.getBoolean(R.styleable.InstabugEditText_android_singleLine, false);
    }

    @NotNull
    public final EditText getEditText() {
        return this.editText;
    }

    @NotNull
    public final TextView getLabelTextView() {
        return this.labelTextView;
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public InstabugEditText(@NotNull Context context, @Nullable AttributeSet attributeSet, int i11) {
        super(context, attributeSet, i11);
        Intrinsics.checkNotNullParameter(context, "context");
        View inflate = InstabugEditTextKt.getLayoutInflater(context).inflate(R.layout.instabug_edit_text, this, true);
        setOrientation(1);
        View findViewById = inflate.findViewById(R.id.ib_txt_label);
        Intrinsics.checkNotNullExpressionValue(findViewById, "view.findViewById(R.id.ib_txt_label)");
        this.labelTextView = (TextView) findViewById;
        View findViewById2 = inflate.findViewById(R.id.ib_edit_text);
        Intrinsics.checkNotNullExpressionValue(findViewById2, "view.findViewById(R.id.ib_edit_text)");
        this.editText = (EditText) findViewById2;
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.InstabugEditText, i11, 0);
        Intrinsics.checkNotNullExpressionValue(obtainStyledAttributes, "context\n            .lay…bugEditText, defStyle, 0)");
        fillViewsFromAttrs(obtainStyledAttributes);
    }
}
