package androidx.preference;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import androidx.annotation.NonNull;

public class DropDownPreference extends ListPreference {
    private final ArrayAdapter mAdapter;
    private final Context mContext;
    private final AdapterView.OnItemSelectedListener mItemSelectedListener;
    private Spinner mSpinner;

    public DropDownPreference(Context context) {
        this(context, (AttributeSet) null);
    }

    private int findSpinnerIndexOfValue(String str) {
        CharSequence[] entryValues = getEntryValues();
        if (str == null || entryValues == null) {
            return -1;
        }
        for (int length = entryValues.length - 1; length >= 0; length--) {
            if (entryValues[length].equals(str)) {
                return length;
            }
        }
        return -1;
    }

    private void updateEntries() {
        this.mAdapter.clear();
        if (getEntries() != null) {
            for (CharSequence charSequence : getEntries()) {
                this.mAdapter.add(charSequence.toString());
            }
        }
    }

    public ArrayAdapter D() {
        return new ArrayAdapter(this.mContext, 17367049);
    }

    public void k() {
        super.k();
        ArrayAdapter arrayAdapter = this.mAdapter;
        if (arrayAdapter != null) {
            arrayAdapter.notifyDataSetChanged();
        }
    }

    public void o() {
        this.mSpinner.performClick();
    }

    public void onBindViewHolder(PreferenceViewHolder preferenceViewHolder) {
        Spinner spinner = (Spinner) preferenceViewHolder.itemView.findViewById(R.id.spinner);
        this.mSpinner = spinner;
        spinner.setAdapter(this.mAdapter);
        this.mSpinner.setOnItemSelectedListener(this.mItemSelectedListener);
        this.mSpinner.setSelection(findSpinnerIndexOfValue(getValue()));
        super.onBindViewHolder(preferenceViewHolder);
    }

    public void setEntries(@NonNull CharSequence[] charSequenceArr) {
        super.setEntries(charSequenceArr);
        updateEntries();
    }

    public void setValueIndex(int i11) {
        setValue(getEntryValues()[i11].toString());
    }

    public DropDownPreference(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, R.attr.dropdownPreferenceStyle);
    }

    public DropDownPreference(Context context, AttributeSet attributeSet, int i11) {
        this(context, attributeSet, i11, 0);
    }

    public DropDownPreference(Context context, AttributeSet attributeSet, int i11, int i12) {
        super(context, attributeSet, i11, i12);
        this.mItemSelectedListener = new AdapterView.OnItemSelectedListener() {
            public void onItemSelected(AdapterView<?> adapterView, View view, int i11, long j11) {
                if (i11 >= 0) {
                    String charSequence = DropDownPreference.this.getEntryValues()[i11].toString();
                    if (!charSequence.equals(DropDownPreference.this.getValue()) && DropDownPreference.this.callChangeListener(charSequence)) {
                        DropDownPreference.this.setValue(charSequence);
                    }
                }
            }

            public void onNothingSelected(AdapterView<?> adapterView) {
            }
        };
        this.mContext = context;
        this.mAdapter = D();
        updateEntries();
    }
}
