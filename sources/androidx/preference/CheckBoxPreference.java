package androidx.preference;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.View;
import android.view.accessibility.AccessibilityManager;
import android.widget.Checkable;
import android.widget.CompoundButton;
import androidx.annotation.RestrictTo;
import androidx.core.content.res.TypedArrayUtils;

public class CheckBoxPreference extends TwoStatePreference {
    private final Listener mListener;

    public class Listener implements CompoundButton.OnCheckedChangeListener {
        public Listener() {
        }

        public void onCheckedChanged(CompoundButton compoundButton, boolean z11) {
            if (!CheckBoxPreference.this.callChangeListener(Boolean.valueOf(z11))) {
                compoundButton.setChecked(!z11);
            } else {
                CheckBoxPreference.this.setChecked(z11);
            }
        }
    }

    public CheckBoxPreference(Context context, AttributeSet attributeSet, int i11) {
        this(context, attributeSet, i11, 0);
    }

    private void syncCheckboxView(View view) {
        boolean z11 = view instanceof CompoundButton;
        if (z11) {
            ((CompoundButton) view).setOnCheckedChangeListener((CompoundButton.OnCheckedChangeListener) null);
        }
        if (view instanceof Checkable) {
            ((Checkable) view).setChecked(this.f37347b);
        }
        if (z11) {
            ((CompoundButton) view).setOnCheckedChangeListener(this.mListener);
        }
    }

    private void syncViewIfAccessibilityEnabled(View view) {
        if (((AccessibilityManager) getContext().getSystemService("accessibility")).isEnabled()) {
            syncCheckboxView(view.findViewById(16908289));
            D(view.findViewById(16908304));
        }
    }

    public void onBindViewHolder(PreferenceViewHolder preferenceViewHolder) {
        super.onBindViewHolder(preferenceViewHolder);
        syncCheckboxView(preferenceViewHolder.findViewById(16908289));
        E(preferenceViewHolder);
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public void v(View view) {
        super.v(view);
        syncViewIfAccessibilityEnabled(view);
    }

    public CheckBoxPreference(Context context, AttributeSet attributeSet, int i11, int i12) {
        super(context, attributeSet, i11, i12);
        this.mListener = new Listener();
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.CheckBoxPreference, i11, i12);
        setSummaryOn((CharSequence) TypedArrayUtils.getString(obtainStyledAttributes, R.styleable.CheckBoxPreference_summaryOn, R.styleable.CheckBoxPreference_android_summaryOn));
        setSummaryOff((CharSequence) TypedArrayUtils.getString(obtainStyledAttributes, R.styleable.CheckBoxPreference_summaryOff, R.styleable.CheckBoxPreference_android_summaryOff));
        setDisableDependentsState(TypedArrayUtils.getBoolean(obtainStyledAttributes, R.styleable.CheckBoxPreference_disableDependentsState, R.styleable.CheckBoxPreference_android_disableDependentsState, false));
        obtainStyledAttributes.recycle();
    }

    public CheckBoxPreference(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, TypedArrayUtils.getAttr(context, R.attr.checkBoxPreferenceStyle, 16842895));
    }

    public CheckBoxPreference(Context context) {
        this(context, (AttributeSet) null);
    }
}
