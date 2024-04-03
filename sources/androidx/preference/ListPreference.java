package androidx.preference;

import android.content.Context;
import android.content.res.TypedArray;
import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.Log;
import androidx.annotation.ArrayRes;
import androidx.annotation.NonNull;
import androidx.core.content.res.TypedArrayUtils;
import androidx.preference.Preference;

public class ListPreference extends DialogPreference {
    private static final String TAG = "ListPreference";
    private CharSequence[] mEntries;
    private CharSequence[] mEntryValues;
    private String mSummary;
    private String mValue;
    private boolean mValueSet;

    public static final class SimpleSummaryProvider implements Preference.SummaryProvider<ListPreference> {
        private static SimpleSummaryProvider sSimpleSummaryProvider;

        private SimpleSummaryProvider() {
        }

        public static SimpleSummaryProvider getInstance() {
            if (sSimpleSummaryProvider == null) {
                sSimpleSummaryProvider = new SimpleSummaryProvider();
            }
            return sSimpleSummaryProvider;
        }

        public CharSequence provideSummary(ListPreference listPreference) {
            if (TextUtils.isEmpty(listPreference.getEntry())) {
                return listPreference.getContext().getString(R.string.not_set);
            }
            return listPreference.getEntry();
        }
    }

    public ListPreference(Context context, AttributeSet attributeSet, int i11, int i12) {
        super(context, attributeSet, i11, i12);
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.ListPreference, i11, i12);
        this.mEntries = TypedArrayUtils.getTextArray(obtainStyledAttributes, R.styleable.ListPreference_entries, R.styleable.ListPreference_android_entries);
        this.mEntryValues = TypedArrayUtils.getTextArray(obtainStyledAttributes, R.styleable.ListPreference_entryValues, R.styleable.ListPreference_android_entryValues);
        int i13 = R.styleable.ListPreference_useSimpleSummaryProvider;
        if (TypedArrayUtils.getBoolean(obtainStyledAttributes, i13, i13, false)) {
            setSummaryProvider(SimpleSummaryProvider.getInstance());
        }
        obtainStyledAttributes.recycle();
        TypedArray obtainStyledAttributes2 = context.obtainStyledAttributes(attributeSet, R.styleable.Preference, i11, i12);
        this.mSummary = TypedArrayUtils.getString(obtainStyledAttributes2, R.styleable.Preference_summary, R.styleable.Preference_android_summary);
        obtainStyledAttributes2.recycle();
    }

    private int getValueIndex() {
        return findIndexOfValue(this.mValue);
    }

    public int findIndexOfValue(String str) {
        CharSequence[] charSequenceArr;
        if (str == null || (charSequenceArr = this.mEntryValues) == null) {
            return -1;
        }
        for (int length = charSequenceArr.length - 1; length >= 0; length--) {
            if (this.mEntryValues[length].equals(str)) {
                return length;
            }
        }
        return -1;
    }

    public CharSequence[] getEntries() {
        return this.mEntries;
    }

    public CharSequence getEntry() {
        CharSequence[] charSequenceArr;
        int valueIndex = getValueIndex();
        if (valueIndex < 0 || (charSequenceArr = this.mEntries) == null) {
            return null;
        }
        return charSequenceArr[valueIndex];
    }

    public CharSequence[] getEntryValues() {
        return this.mEntryValues;
    }

    public CharSequence getSummary() {
        if (getSummaryProvider() != null) {
            return getSummaryProvider().provideSummary(this);
        }
        Object entry = getEntry();
        CharSequence summary = super.getSummary();
        String str = this.mSummary;
        if (str == null) {
            return summary;
        }
        Object[] objArr = new Object[1];
        if (entry == null) {
            entry = "";
        }
        objArr[0] = entry;
        String format = String.format(str, objArr);
        if (TextUtils.equals(format, summary)) {
            return summary;
        }
        Log.w(TAG, "Setting a summary with a String formatting marker is no longer supported. You should use a SummaryProvider instead.");
        return format;
    }

    public String getValue() {
        return this.mValue;
    }

    public Object p(TypedArray typedArray, int i11) {
        return typedArray.getString(i11);
    }

    public void r(Parcelable parcelable) {
        if (parcelable == null || !parcelable.getClass().equals(SavedState.class)) {
            super.r(parcelable);
            return;
        }
        SavedState savedState = (SavedState) parcelable;
        super.r(savedState.getSuperState());
        setValue(savedState.f37288b);
    }

    public Parcelable s() {
        Parcelable s11 = super.s();
        if (isPersistent()) {
            return s11;
        }
        SavedState savedState = new SavedState(s11);
        savedState.f37288b = getValue();
        return savedState;
    }

    public void setEntries(CharSequence[] charSequenceArr) {
        this.mEntries = charSequenceArr;
    }

    public void setEntryValues(CharSequence[] charSequenceArr) {
        this.mEntryValues = charSequenceArr;
    }

    public void setSummary(CharSequence charSequence) {
        super.setSummary(charSequence);
        if (charSequence == null && this.mSummary != null) {
            this.mSummary = null;
        } else if (charSequence != null && !charSequence.equals(this.mSummary)) {
            this.mSummary = charSequence.toString();
        }
    }

    public void setValue(String str) {
        boolean z11 = !TextUtils.equals(this.mValue, str);
        if (z11 || !this.mValueSet) {
            this.mValue = str;
            this.mValueSet = true;
            y(str);
            if (z11) {
                k();
            }
        }
    }

    public void setValueIndex(int i11) {
        CharSequence[] charSequenceArr = this.mEntryValues;
        if (charSequenceArr != null) {
            setValue(charSequenceArr[i11].toString());
        }
    }

    public void t(Object obj) {
        setValue(j((String) obj));
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
        public String f37288b;

        public SavedState(Parcel parcel) {
            super(parcel);
            this.f37288b = parcel.readString();
        }

        public void writeToParcel(@NonNull Parcel parcel, int i11) {
            super.writeToParcel(parcel, i11);
            parcel.writeString(this.f37288b);
        }

        public SavedState(Parcelable parcelable) {
            super(parcelable);
        }
    }

    public void setEntries(@ArrayRes int i11) {
        setEntries(getContext().getResources().getTextArray(i11));
    }

    public void setEntryValues(@ArrayRes int i11) {
        setEntryValues(getContext().getResources().getTextArray(i11));
    }

    public ListPreference(Context context, AttributeSet attributeSet, int i11) {
        this(context, attributeSet, i11, 0);
    }

    public ListPreference(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, TypedArrayUtils.getAttr(context, R.attr.dialogPreferenceStyle, 16842897));
    }

    public ListPreference(Context context) {
        this(context, (AttributeSet) null);
    }
}
