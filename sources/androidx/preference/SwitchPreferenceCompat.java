package androidx.preference;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.View;
import android.view.accessibility.AccessibilityManager;
import android.widget.Checkable;
import android.widget.CompoundButton;
import androidx.annotation.RestrictTo;
import androidx.appcompat.widget.SwitchCompat;
import androidx.core.content.res.TypedArrayUtils;

public class SwitchPreferenceCompat extends TwoStatePreference {
    private final Listener mListener;
    private CharSequence mSwitchOff;
    private CharSequence mSwitchOn;

    public class Listener implements CompoundButton.OnCheckedChangeListener {
        public Listener() {
        }

        public void onCheckedChanged(CompoundButton compoundButton, boolean z11) {
            if (!SwitchPreferenceCompat.this.callChangeListener(Boolean.valueOf(z11))) {
                compoundButton.setChecked(!z11);
            } else {
                SwitchPreferenceCompat.this.setChecked(z11);
            }
        }
    }

    public SwitchPreferenceCompat(Context context, AttributeSet attributeSet, int i11, int i12) {
        super(context, attributeSet, i11, i12);
        this.mListener = new Listener();
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.SwitchPreferenceCompat, i11, i12);
        setSummaryOn((CharSequence) TypedArrayUtils.getString(obtainStyledAttributes, R.styleable.SwitchPreferenceCompat_summaryOn, R.styleable.SwitchPreferenceCompat_android_summaryOn));
        setSummaryOff((CharSequence) TypedArrayUtils.getString(obtainStyledAttributes, R.styleable.SwitchPreferenceCompat_summaryOff, R.styleable.SwitchPreferenceCompat_android_summaryOff));
        setSwitchTextOn((CharSequence) TypedArrayUtils.getString(obtainStyledAttributes, R.styleable.SwitchPreferenceCompat_switchTextOn, R.styleable.SwitchPreferenceCompat_android_switchTextOn));
        setSwitchTextOff((CharSequence) TypedArrayUtils.getString(obtainStyledAttributes, R.styleable.SwitchPreferenceCompat_switchTextOff, R.styleable.SwitchPreferenceCompat_android_switchTextOff));
        setDisableDependentsState(TypedArrayUtils.getBoolean(obtainStyledAttributes, R.styleable.SwitchPreferenceCompat_disableDependentsState, R.styleable.SwitchPreferenceCompat_android_disableDependentsState, false));
        obtainStyledAttributes.recycle();
    }

    private void syncSwitchView(View view) {
        boolean z11 = view instanceof SwitchCompat;
        if (z11) {
            ((SwitchCompat) view).setOnCheckedChangeListener((CompoundButton.OnCheckedChangeListener) null);
        }
        if (view instanceof Checkable) {
            ((Checkable) view).setChecked(this.f37347b);
        }
        if (z11) {
            SwitchCompat switchCompat = (SwitchCompat) view;
            switchCompat.setTextOn(this.mSwitchOn);
            switchCompat.setTextOff(this.mSwitchOff);
            switchCompat.setOnCheckedChangeListener(this.mListener);
        }
    }

    private void syncViewIfAccessibilityEnabled(View view) {
        if (((AccessibilityManager) getContext().getSystemService("accessibility")).isEnabled()) {
            syncSwitchView(view.findViewById(R.id.switchWidget));
            D(view.findViewById(16908304));
        }
    }

    public CharSequence getSwitchTextOff() {
        return this.mSwitchOff;
    }

    public CharSequence getSwitchTextOn() {
        return this.mSwitchOn;
    }

    public void onBindViewHolder(PreferenceViewHolder preferenceViewHolder) {
        super.onBindViewHolder(preferenceViewHolder);
        syncSwitchView(preferenceViewHolder.findViewById(R.id.switchWidget));
        E(preferenceViewHolder);
    }

    public void setSwitchTextOff(CharSequence charSequence) {
        this.mSwitchOff = charSequence;
        k();
    }

    public void setSwitchTextOn(CharSequence charSequence) {
        this.mSwitchOn = charSequence;
        k();
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public void v(View view) {
        super.v(view);
        syncViewIfAccessibilityEnabled(view);
    }

    public void setSwitchTextOff(int i11) {
        setSwitchTextOff((CharSequence) getContext().getString(i11));
    }

    public void setSwitchTextOn(int i11) {
        setSwitchTextOn((CharSequence) getContext().getString(i11));
    }

    public SwitchPreferenceCompat(Context context, AttributeSet attributeSet, int i11) {
        this(context, attributeSet, i11, 0);
    }

    public SwitchPreferenceCompat(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, R.attr.switchPreferenceCompatStyle);
    }

    public SwitchPreferenceCompat(Context context) {
        this(context, (AttributeSet) null);
    }
}
