package com.adyen.checkout.ui.internal.common.view;

import android.content.Context;
import android.content.res.TypedArray;
import android.text.Editable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.StringRes;
import androidx.appcompat.widget.AppCompatTextView;
import com.adyen.checkout.ui.R;
import com.adyen.checkout.ui.internal.common.util.ThemeUtil;
import com.adyen.checkout.util.internal.SimpleTextWatcher;

public class CustomTextInputLayout extends LinearLayout {
    private CharSequence mCaption;
    private TextView mCaptionTextView;
    private CharSequence mHint;

    public CustomTextInputLayout(@NonNull Context context) {
        this(context, (AttributeSet) null);
    }

    @Nullable
    private TextView getInputText() {
        if (getChildCount() < 2) {
            return null;
        }
        View childAt = getChildAt(1);
        if (childAt instanceof TextView) {
            return (TextView) childAt;
        }
        return null;
    }

    private void init(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        setOrientation(1);
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.CustomTextInputLayout);
        this.mCaption = obtainStyledAttributes.getString(R.styleable.CustomTextInputLayout_customTextInputLayout_caption);
        this.mHint = obtainStyledAttributes.getString(R.styleable.CustomTextInputLayout_customTextInputLayout_hint);
        obtainStyledAttributes.recycle();
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
        AppCompatTextView appCompatTextView = new AppCompatTextView(context);
        this.mCaptionTextView = appCompatTextView;
        appCompatTextView.setMaxLines(1);
        this.mCaptionTextView.setEllipsize(TextUtils.TruncateAt.END);
        this.mCaptionTextView.setLayoutParams(layoutParams);
        this.mCaptionTextView.setTextColor(ThemeUtil.getPrimaryThemeColor(context));
        addView(this.mCaptionTextView, 0);
        setAddStatesFromChildren(true);
        updateCaptionAndHint();
    }

    /* access modifiers changed from: private */
    public void updateCaptionAndHint() {
        int i11;
        Animation animation;
        TextView inputText = getInputText();
        if (inputText != null) {
            int visibility = this.mCaptionTextView.getVisibility();
            if (inputText.hasFocus() || inputText.length() > 0) {
                i11 = 0;
            } else {
                i11 = 4;
            }
            this.mCaptionTextView.setText(this.mCaption);
            this.mCaptionTextView.setVisibility(i11);
            if (visibility != i11 && !isInEditMode()) {
                if (i11 == 0) {
                    animation = AnimationUtils.loadAnimation(getContext(), R.anim.fade_in_from_bottom);
                } else {
                    animation = AnimationUtils.loadAnimation(getContext(), R.anim.fade_out_to_bottom);
                }
                this.mCaptionTextView.startAnimation(animation);
            }
            if (i11 == 0) {
                inputText.setHint(this.mHint);
            } else {
                inputText.setHint(this.mCaption);
            }
        }
    }

    public void drawableStateChanged() {
        super.drawableStateChanged();
        updateCaptionAndHint();
    }

    public void onFinishInflate() {
        super.onFinishInflate();
        TextView inputText = getInputText();
        if (inputText != null) {
            this.mCaptionTextView.setPadding(inputText.getPaddingLeft(), this.mCaptionTextView.getPaddingTop(), inputText.getPaddingRight(), this.mCaptionTextView.getPaddingBottom());
            if (!isInEditMode()) {
                inputText.setPadding(inputText.getPaddingLeft(), getResources().getDimensionPixelSize(R.dimen.standard_half_margin), inputText.getPaddingRight(), inputText.getPaddingBottom());
            }
            inputText.addTextChangedListener(new SimpleTextWatcher() {
                public void afterTextChanged(Editable editable) {
                    CustomTextInputLayout.this.updateCaptionAndHint();
                }
            });
        }
    }

    public void setCaption(@StringRes int i11) {
        setCaption(getResources().getText(i11));
    }

    public void setHint(@StringRes int i11) {
        setHint(getResources().getText(i11));
    }

    public CustomTextInputLayout(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public void setCaption(@Nullable CharSequence charSequence) {
        this.mCaption = charSequence;
        this.mCaptionTextView.setText(charSequence);
        updateCaptionAndHint();
    }

    public void setHint(@NonNull CharSequence charSequence) {
        this.mHint = charSequence;
        updateCaptionAndHint();
    }

    public CustomTextInputLayout(@NonNull Context context, @Nullable AttributeSet attributeSet, int i11) {
        super(context, attributeSet, i11);
        init(context, attributeSet);
    }
}
