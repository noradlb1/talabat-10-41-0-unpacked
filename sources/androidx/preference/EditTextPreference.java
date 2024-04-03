package androidx.preference;

import android.content.Context;
import android.content.res.TypedArray;
import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.widget.EditText;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.content.res.TypedArrayUtils;
import androidx.preference.Preference;

public class EditTextPreference extends DialogPreference {
    @Nullable
    private OnBindEditTextListener mOnBindEditTextListener;
    private String mText;

    public interface OnBindEditTextListener {
        void onBindEditText(@NonNull EditText editText);
    }

    public static final class SimpleSummaryProvider implements Preference.SummaryProvider<EditTextPreference> {
        private static SimpleSummaryProvider sSimpleSummaryProvider;

        private SimpleSummaryProvider() {
        }

        public static SimpleSummaryProvider getInstance() {
            if (sSimpleSummaryProvider == null) {
                sSimpleSummaryProvider = new SimpleSummaryProvider();
            }
            return sSimpleSummaryProvider;
        }

        public CharSequence provideSummary(EditTextPreference editTextPreference) {
            if (TextUtils.isEmpty(editTextPreference.getText())) {
                return editTextPreference.getContext().getString(R.string.not_set);
            }
            return editTextPreference.getText();
        }
    }

    public EditTextPreference(Context context, AttributeSet attributeSet, int i11, int i12) {
        super(context, attributeSet, i11, i12);
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.EditTextPreference, i11, i12);
        int i13 = R.styleable.EditTextPreference_useSimpleSummaryProvider;
        if (TypedArrayUtils.getBoolean(obtainStyledAttributes, i13, i13, false)) {
            setSummaryProvider(SimpleSummaryProvider.getInstance());
        }
        obtainStyledAttributes.recycle();
    }

    @Nullable
    public OnBindEditTextListener D() {
        return this.mOnBindEditTextListener;
    }

    public String getText() {
        return this.mText;
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
        setText(savedState.f37287b);
    }

    public Parcelable s() {
        Parcelable s11 = super.s();
        if (isPersistent()) {
            return s11;
        }
        SavedState savedState = new SavedState(s11);
        savedState.f37287b = getText();
        return savedState;
    }

    public void setOnBindEditTextListener(@Nullable OnBindEditTextListener onBindEditTextListener) {
        this.mOnBindEditTextListener = onBindEditTextListener;
    }

    public void setText(String str) {
        boolean shouldDisableDependents = shouldDisableDependents();
        this.mText = str;
        y(str);
        boolean shouldDisableDependents2 = shouldDisableDependents();
        if (shouldDisableDependents2 != shouldDisableDependents) {
            notifyDependencyChange(shouldDisableDependents2);
        }
        k();
    }

    public boolean shouldDisableDependents() {
        return TextUtils.isEmpty(this.mText) || super.shouldDisableDependents();
    }

    public void t(Object obj) {
        setText(j((String) obj));
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
        public String f37287b;

        public SavedState(Parcel parcel) {
            super(parcel);
            this.f37287b = parcel.readString();
        }

        public void writeToParcel(Parcel parcel, int i11) {
            super.writeToParcel(parcel, i11);
            parcel.writeString(this.f37287b);
        }

        public SavedState(Parcelable parcelable) {
            super(parcelable);
        }
    }

    public EditTextPreference(Context context, AttributeSet attributeSet, int i11) {
        this(context, attributeSet, i11, 0);
    }

    public EditTextPreference(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, TypedArrayUtils.getAttr(context, R.attr.editTextPreferenceStyle, 16842898));
    }

    public EditTextPreference(Context context) {
        this(context, (AttributeSet) null);
    }
}
