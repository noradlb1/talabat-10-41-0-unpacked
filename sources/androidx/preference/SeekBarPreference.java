package androidx.preference;

import android.content.Context;
import android.content.res.TypedArray;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import android.widget.SeekBar;
import android.widget.TextView;
import androidx.preference.Preference;

public class SeekBarPreference extends Preference {
    private static final String TAG = "SeekBarPreference";

    /* renamed from: b  reason: collision with root package name */
    public int f37334b;

    /* renamed from: c  reason: collision with root package name */
    public int f37335c;

    /* renamed from: d  reason: collision with root package name */
    public boolean f37336d;

    /* renamed from: e  reason: collision with root package name */
    public SeekBar f37337e;

    /* renamed from: f  reason: collision with root package name */
    public boolean f37338f;

    /* renamed from: g  reason: collision with root package name */
    public boolean f37339g;
    private int mMax;
    private SeekBar.OnSeekBarChangeListener mSeekBarChangeListener;
    private int mSeekBarIncrement;
    private View.OnKeyListener mSeekBarKeyListener;
    private TextView mSeekBarValueTextView;
    private boolean mShowSeekBarValue;

    public SeekBarPreference(Context context, AttributeSet attributeSet, int i11, int i12) {
        super(context, attributeSet, i11, i12);
        this.mSeekBarChangeListener = new SeekBar.OnSeekBarChangeListener() {
            public void onProgressChanged(SeekBar seekBar, int i11, boolean z11) {
                if (z11) {
                    SeekBarPreference seekBarPreference = SeekBarPreference.this;
                    if (seekBarPreference.f37339g || !seekBarPreference.f37336d) {
                        seekBarPreference.D(seekBar);
                        return;
                    }
                }
                SeekBarPreference seekBarPreference2 = SeekBarPreference.this;
                seekBarPreference2.E(i11 + seekBarPreference2.f37335c);
            }

            public void onStartTrackingTouch(SeekBar seekBar) {
                SeekBarPreference.this.f37336d = true;
            }

            public void onStopTrackingTouch(SeekBar seekBar) {
                SeekBarPreference.this.f37336d = false;
                int progress = seekBar.getProgress();
                SeekBarPreference seekBarPreference = SeekBarPreference.this;
                if (progress + seekBarPreference.f37335c != seekBarPreference.f37334b) {
                    seekBarPreference.D(seekBar);
                }
            }
        };
        this.mSeekBarKeyListener = new View.OnKeyListener() {
            public boolean onKey(View view, int i11, KeyEvent keyEvent) {
                if (keyEvent.getAction() != 0) {
                    return false;
                }
                SeekBarPreference seekBarPreference = SeekBarPreference.this;
                if ((!seekBarPreference.f37338f && (i11 == 21 || i11 == 22)) || i11 == 23 || i11 == 66) {
                    return false;
                }
                SeekBar seekBar = seekBarPreference.f37337e;
                if (seekBar != null) {
                    return seekBar.onKeyDown(i11, keyEvent);
                }
                Log.e(SeekBarPreference.TAG, "SeekBar view is null and hence cannot be adjusted.");
                return false;
            }
        };
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.SeekBarPreference, i11, i12);
        this.f37335c = obtainStyledAttributes.getInt(R.styleable.SeekBarPreference_min, 0);
        setMax(obtainStyledAttributes.getInt(R.styleable.SeekBarPreference_android_max, 100));
        setSeekBarIncrement(obtainStyledAttributes.getInt(R.styleable.SeekBarPreference_seekBarIncrement, 0));
        this.f37338f = obtainStyledAttributes.getBoolean(R.styleable.SeekBarPreference_adjustable, true);
        this.mShowSeekBarValue = obtainStyledAttributes.getBoolean(R.styleable.SeekBarPreference_showSeekBarValue, false);
        this.f37339g = obtainStyledAttributes.getBoolean(R.styleable.SeekBarPreference_updatesContinuously, false);
        obtainStyledAttributes.recycle();
    }

    private void setValueInternal(int i11, boolean z11) {
        int i12 = this.f37335c;
        if (i11 < i12) {
            i11 = i12;
        }
        int i13 = this.mMax;
        if (i11 > i13) {
            i11 = i13;
        }
        if (i11 != this.f37334b) {
            this.f37334b = i11;
            E(i11);
            x(i11);
            if (z11) {
                k();
            }
        }
    }

    public void D(SeekBar seekBar) {
        int progress = this.f37335c + seekBar.getProgress();
        if (progress == this.f37334b) {
            return;
        }
        if (callChangeListener(Integer.valueOf(progress))) {
            setValueInternal(progress, false);
            return;
        }
        seekBar.setProgress(this.f37334b - this.f37335c);
        E(this.f37334b);
    }

    public void E(int i11) {
        TextView textView = this.mSeekBarValueTextView;
        if (textView != null) {
            textView.setText(String.valueOf(i11));
        }
    }

    public int getMax() {
        return this.mMax;
    }

    public int getMin() {
        return this.f37335c;
    }

    public final int getSeekBarIncrement() {
        return this.mSeekBarIncrement;
    }

    public boolean getShowSeekBarValue() {
        return this.mShowSeekBarValue;
    }

    public boolean getUpdatesContinuously() {
        return this.f37339g;
    }

    public int getValue() {
        return this.f37334b;
    }

    public boolean isAdjustable() {
        return this.f37338f;
    }

    public void onBindViewHolder(PreferenceViewHolder preferenceViewHolder) {
        super.onBindViewHolder(preferenceViewHolder);
        preferenceViewHolder.itemView.setOnKeyListener(this.mSeekBarKeyListener);
        this.f37337e = (SeekBar) preferenceViewHolder.findViewById(R.id.seekbar);
        TextView textView = (TextView) preferenceViewHolder.findViewById(R.id.seekbar_value);
        this.mSeekBarValueTextView = textView;
        if (this.mShowSeekBarValue) {
            textView.setVisibility(0);
        } else {
            textView.setVisibility(8);
            this.mSeekBarValueTextView = null;
        }
        SeekBar seekBar = this.f37337e;
        if (seekBar == null) {
            Log.e(TAG, "SeekBar view is null in onBindViewHolder.");
            return;
        }
        seekBar.setOnSeekBarChangeListener(this.mSeekBarChangeListener);
        this.f37337e.setMax(this.mMax - this.f37335c);
        int i11 = this.mSeekBarIncrement;
        if (i11 != 0) {
            this.f37337e.setKeyProgressIncrement(i11);
        } else {
            this.mSeekBarIncrement = this.f37337e.getKeyProgressIncrement();
        }
        this.f37337e.setProgress(this.f37334b - this.f37335c);
        E(this.f37334b);
        this.f37337e.setEnabled(isEnabled());
    }

    public Object p(TypedArray typedArray, int i11) {
        return Integer.valueOf(typedArray.getInt(i11, 0));
    }

    public void r(Parcelable parcelable) {
        if (!parcelable.getClass().equals(SavedState.class)) {
            super.r(parcelable);
            return;
        }
        SavedState savedState = (SavedState) parcelable;
        super.r(savedState.getSuperState());
        this.f37334b = savedState.f37342b;
        this.f37335c = savedState.f37343c;
        this.mMax = savedState.f37344d;
        k();
    }

    public Parcelable s() {
        Parcelable s11 = super.s();
        if (isPersistent()) {
            return s11;
        }
        SavedState savedState = new SavedState(s11);
        savedState.f37342b = this.f37334b;
        savedState.f37343c = this.f37335c;
        savedState.f37344d = this.mMax;
        return savedState;
    }

    public void setAdjustable(boolean z11) {
        this.f37338f = z11;
    }

    public final void setMax(int i11) {
        int i12 = this.f37335c;
        if (i11 < i12) {
            i11 = i12;
        }
        if (i11 != this.mMax) {
            this.mMax = i11;
            k();
        }
    }

    public void setMin(int i11) {
        int i12 = this.mMax;
        if (i11 > i12) {
            i11 = i12;
        }
        if (i11 != this.f37335c) {
            this.f37335c = i11;
            k();
        }
    }

    public final void setSeekBarIncrement(int i11) {
        if (i11 != this.mSeekBarIncrement) {
            this.mSeekBarIncrement = Math.min(this.mMax - this.f37335c, Math.abs(i11));
            k();
        }
    }

    public void setShowSeekBarValue(boolean z11) {
        this.mShowSeekBarValue = z11;
        k();
    }

    public void setUpdatesContinuously(boolean z11) {
        this.f37339g = z11;
    }

    public void setValue(int i11) {
        setValueInternal(i11, true);
    }

    public void t(Object obj) {
        if (obj == null) {
            obj = 0;
        }
        setValue(i(((Integer) obj).intValue()));
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
        public int f37342b;

        /* renamed from: c  reason: collision with root package name */
        public int f37343c;

        /* renamed from: d  reason: collision with root package name */
        public int f37344d;

        public SavedState(Parcel parcel) {
            super(parcel);
            this.f37342b = parcel.readInt();
            this.f37343c = parcel.readInt();
            this.f37344d = parcel.readInt();
        }

        public void writeToParcel(Parcel parcel, int i11) {
            super.writeToParcel(parcel, i11);
            parcel.writeInt(this.f37342b);
            parcel.writeInt(this.f37343c);
            parcel.writeInt(this.f37344d);
        }

        public SavedState(Parcelable parcelable) {
            super(parcelable);
        }
    }

    public SeekBarPreference(Context context, AttributeSet attributeSet, int i11) {
        this(context, attributeSet, i11, 0);
    }

    public SeekBarPreference(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, R.attr.seekBarPreferenceStyle);
    }

    public SeekBarPreference(Context context) {
        this(context, (AttributeSet) null);
    }
}
