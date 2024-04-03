package androidx.preference;

import android.content.Context;
import android.content.res.TypedArray;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.AttributeSet;
import androidx.annotation.ArrayRes;
import androidx.annotation.NonNull;
import androidx.core.content.res.TypedArrayUtils;
import androidx.preference.Preference;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

public class MultiSelectListPreference extends DialogPreference {
    private CharSequence[] mEntries;
    private CharSequence[] mEntryValues;
    private Set<String> mValues;

    public MultiSelectListPreference(Context context, AttributeSet attributeSet, int i11, int i12) {
        super(context, attributeSet, i11, i12);
        this.mValues = new HashSet();
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.MultiSelectListPreference, i11, i12);
        this.mEntries = TypedArrayUtils.getTextArray(obtainStyledAttributes, R.styleable.MultiSelectListPreference_entries, R.styleable.MultiSelectListPreference_android_entries);
        this.mEntryValues = TypedArrayUtils.getTextArray(obtainStyledAttributes, R.styleable.MultiSelectListPreference_entryValues, R.styleable.MultiSelectListPreference_android_entryValues);
        obtainStyledAttributes.recycle();
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

    public CharSequence[] getEntryValues() {
        return this.mEntryValues;
    }

    public Set<String> getValues() {
        return this.mValues;
    }

    public Object p(TypedArray typedArray, int i11) {
        CharSequence[] textArray = typedArray.getTextArray(i11);
        HashSet hashSet = new HashSet();
        for (CharSequence charSequence : textArray) {
            hashSet.add(charSequence.toString());
        }
        return hashSet;
    }

    public void r(Parcelable parcelable) {
        if (parcelable == null || !parcelable.getClass().equals(SavedState.class)) {
            super.r(parcelable);
            return;
        }
        SavedState savedState = (SavedState) parcelable;
        super.r(savedState.getSuperState());
        setValues(savedState.f37292b);
    }

    public Parcelable s() {
        Parcelable s11 = super.s();
        if (isPersistent()) {
            return s11;
        }
        SavedState savedState = new SavedState(s11);
        savedState.f37292b = getValues();
        return savedState;
    }

    public void setEntries(CharSequence[] charSequenceArr) {
        this.mEntries = charSequenceArr;
    }

    public void setEntryValues(CharSequence[] charSequenceArr) {
        this.mEntryValues = charSequenceArr;
    }

    public void setValues(Set<String> set) {
        this.mValues.clear();
        this.mValues.addAll(set);
        persistStringSet(set);
        k();
    }

    public void t(Object obj) {
        setValues(getPersistedStringSet((Set) obj));
    }

    public void setEntries(@ArrayRes int i11) {
        setEntries(getContext().getResources().getTextArray(i11));
    }

    public void setEntryValues(@ArrayRes int i11) {
        setEntryValues(getContext().getResources().getTextArray(i11));
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
        public Set<String> f37292b;

        public SavedState(Parcel parcel) {
            super(parcel);
            int readInt = parcel.readInt();
            this.f37292b = new HashSet();
            String[] strArr = new String[readInt];
            parcel.readStringArray(strArr);
            Collections.addAll(this.f37292b, strArr);
        }

        public void writeToParcel(@NonNull Parcel parcel, int i11) {
            super.writeToParcel(parcel, i11);
            parcel.writeInt(this.f37292b.size());
            Set<String> set = this.f37292b;
            parcel.writeStringArray((String[]) set.toArray(new String[set.size()]));
        }

        public SavedState(Parcelable parcelable) {
            super(parcelable);
        }
    }

    public MultiSelectListPreference(Context context, AttributeSet attributeSet, int i11) {
        this(context, attributeSet, i11, 0);
    }

    public MultiSelectListPreference(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, TypedArrayUtils.getAttr(context, R.attr.dialogPreferenceStyle, 16842897));
    }

    public MultiSelectListPreference(Context context) {
        this(context, (AttributeSet) null);
    }
}
