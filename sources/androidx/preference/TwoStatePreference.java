package androidx.preference;

import android.content.Context;
import android.content.res.TypedArray;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.AttributeSet;
import androidx.preference.Preference;

public abstract class TwoStatePreference extends Preference {

    /* renamed from: b  reason: collision with root package name */
    public boolean f37347b;
    private boolean mCheckedSet;
    private boolean mDisableDependentsState;
    private CharSequence mSummaryOff;
    private CharSequence mSummaryOn;

    public TwoStatePreference(Context context, AttributeSet attributeSet, int i11, int i12) {
        super(context, attributeSet, i11, i12);
    }

    /* JADX WARNING: Removed duplicated region for block: B:16:0x0030  */
    /* JADX WARNING: Removed duplicated region for block: B:20:0x0041  */
    /* JADX WARNING: Removed duplicated region for block: B:23:0x0049  */
    /* JADX WARNING: Removed duplicated region for block: B:25:? A[RETURN, SYNTHETIC] */
    @androidx.annotation.RestrictTo({androidx.annotation.RestrictTo.Scope.LIBRARY})
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void D(android.view.View r5) {
        /*
            r4 = this;
            boolean r0 = r5 instanceof android.widget.TextView
            if (r0 != 0) goto L_0x0005
            return
        L_0x0005:
            android.widget.TextView r5 = (android.widget.TextView) r5
            boolean r0 = r4.f37347b
            r1 = 0
            if (r0 == 0) goto L_0x001b
            java.lang.CharSequence r0 = r4.mSummaryOn
            boolean r0 = android.text.TextUtils.isEmpty(r0)
            if (r0 != 0) goto L_0x001b
            java.lang.CharSequence r0 = r4.mSummaryOn
            r5.setText(r0)
        L_0x0019:
            r0 = r1
            goto L_0x002e
        L_0x001b:
            boolean r0 = r4.f37347b
            if (r0 != 0) goto L_0x002d
            java.lang.CharSequence r0 = r4.mSummaryOff
            boolean r0 = android.text.TextUtils.isEmpty(r0)
            if (r0 != 0) goto L_0x002d
            java.lang.CharSequence r0 = r4.mSummaryOff
            r5.setText(r0)
            goto L_0x0019
        L_0x002d:
            r0 = 1
        L_0x002e:
            if (r0 == 0) goto L_0x003e
            java.lang.CharSequence r2 = r4.getSummary()
            boolean r3 = android.text.TextUtils.isEmpty(r2)
            if (r3 != 0) goto L_0x003e
            r5.setText(r2)
            r0 = r1
        L_0x003e:
            if (r0 != 0) goto L_0x0041
            goto L_0x0043
        L_0x0041:
            r1 = 8
        L_0x0043:
            int r0 = r5.getVisibility()
            if (r1 == r0) goto L_0x004c
            r5.setVisibility(r1)
        L_0x004c:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.preference.TwoStatePreference.D(android.view.View):void");
    }

    public void E(PreferenceViewHolder preferenceViewHolder) {
        D(preferenceViewHolder.findViewById(16908304));
    }

    public boolean getDisableDependentsState() {
        return this.mDisableDependentsState;
    }

    public CharSequence getSummaryOff() {
        return this.mSummaryOff;
    }

    public CharSequence getSummaryOn() {
        return this.mSummaryOn;
    }

    public boolean isChecked() {
        return this.f37347b;
    }

    public void o() {
        super.o();
        boolean z11 = !isChecked();
        if (callChangeListener(Boolean.valueOf(z11))) {
            setChecked(z11);
        }
    }

    public Object p(TypedArray typedArray, int i11) {
        return Boolean.valueOf(typedArray.getBoolean(i11, false));
    }

    public void r(Parcelable parcelable) {
        if (parcelable == null || !parcelable.getClass().equals(SavedState.class)) {
            super.r(parcelable);
            return;
        }
        SavedState savedState = (SavedState) parcelable;
        super.r(savedState.getSuperState());
        setChecked(savedState.f37348b);
    }

    public Parcelable s() {
        Parcelable s11 = super.s();
        if (isPersistent()) {
            return s11;
        }
        SavedState savedState = new SavedState(s11);
        savedState.f37348b = isChecked();
        return savedState;
    }

    public void setChecked(boolean z11) {
        boolean z12;
        if (this.f37347b != z11) {
            z12 = true;
        } else {
            z12 = false;
        }
        if (z12 || !this.mCheckedSet) {
            this.f37347b = z11;
            this.mCheckedSet = true;
            w(z11);
            if (z12) {
                notifyDependencyChange(shouldDisableDependents());
                k();
            }
        }
    }

    public void setDisableDependentsState(boolean z11) {
        this.mDisableDependentsState = z11;
    }

    public void setSummaryOff(CharSequence charSequence) {
        this.mSummaryOff = charSequence;
        if (!isChecked()) {
            k();
        }
    }

    public void setSummaryOn(CharSequence charSequence) {
        this.mSummaryOn = charSequence;
        if (isChecked()) {
            k();
        }
    }

    public boolean shouldDisableDependents() {
        boolean z11;
        if (this.mDisableDependentsState) {
            z11 = this.f37347b;
        } else if (!this.f37347b) {
            z11 = true;
        } else {
            z11 = false;
        }
        if (z11 || super.shouldDisableDependents()) {
            return true;
        }
        return false;
    }

    public void t(Object obj) {
        if (obj == null) {
            obj = Boolean.FALSE;
        }
        setChecked(h(((Boolean) obj).booleanValue()));
    }

    public static class SavedState extends Preference.BaseSavedState {
        public static final Parcelable.Creator<SavedState> CREATOR = new Parcelable.Creator<SavedState>() {
            public SavedState createFromParcel(Parcel parcel) {
                return new SavedState(parcel);
            }

            public SavedState[] newArray(int i11) {
                return new SavedState[i11];
            }
        };

        /* renamed from: b  reason: collision with root package name */
        public boolean f37348b;

        public SavedState(Parcel parcel) {
            super(parcel);
            this.f37348b = parcel.readInt() != 1 ? false : true;
        }

        public void writeToParcel(Parcel parcel, int i11) {
            super.writeToParcel(parcel, i11);
            parcel.writeInt(this.f37348b ? 1 : 0);
        }

        public SavedState(Parcelable parcelable) {
            super(parcelable);
        }
    }

    public TwoStatePreference(Context context, AttributeSet attributeSet, int i11) {
        this(context, attributeSet, i11, 0);
    }

    public TwoStatePreference(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public TwoStatePreference(Context context) {
        this(context, (AttributeSet) null);
    }

    public void setSummaryOff(int i11) {
        setSummaryOff((CharSequence) getContext().getString(i11));
    }

    public void setSummaryOn(int i11) {
        setSummaryOn((CharSequence) getContext().getString(i11));
    }
}
