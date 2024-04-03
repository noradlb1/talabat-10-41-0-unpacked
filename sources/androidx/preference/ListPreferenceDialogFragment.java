package androidx.preference;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import androidx.annotation.NonNull;

@Deprecated
public class ListPreferenceDialogFragment extends PreferenceDialogFragment {
    private static final String SAVE_STATE_ENTRIES = "ListPreferenceDialogFragment.entries";
    private static final String SAVE_STATE_ENTRY_VALUES = "ListPreferenceDialogFragment.entryValues";
    private static final String SAVE_STATE_INDEX = "ListPreferenceDialogFragment.index";

    /* renamed from: b  reason: collision with root package name */
    public int f37289b;
    private CharSequence[] mEntries;
    private CharSequence[] mEntryValues;

    private ListPreference getListPreference() {
        return (ListPreference) getPreference();
    }

    @Deprecated
    public static ListPreferenceDialogFragment newInstance(String str) {
        ListPreferenceDialogFragment listPreferenceDialogFragment = new ListPreferenceDialogFragment();
        Bundle bundle = new Bundle(1);
        bundle.putString("key", str);
        listPreferenceDialogFragment.setArguments(bundle);
        return listPreferenceDialogFragment;
    }

    public void d(AlertDialog.Builder builder) {
        super.d(builder);
        builder.setSingleChoiceItems(this.mEntries, this.f37289b, new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialogInterface, int i11) {
                ListPreferenceDialogFragment listPreferenceDialogFragment = ListPreferenceDialogFragment.this;
                listPreferenceDialogFragment.f37289b = i11;
                listPreferenceDialogFragment.onClick(dialogInterface, -1);
                dialogInterface.dismiss();
            }
        });
        builder.setPositiveButton((CharSequence) null, (DialogInterface.OnClickListener) null);
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        if (bundle == null) {
            ListPreference listPreference = getListPreference();
            if (listPreference.getEntries() == null || listPreference.getEntryValues() == null) {
                throw new IllegalStateException("ListPreference requires an entries array and an entryValues array.");
            }
            this.f37289b = listPreference.findIndexOfValue(listPreference.getValue());
            this.mEntries = listPreference.getEntries();
            this.mEntryValues = listPreference.getEntryValues();
            return;
        }
        this.f37289b = bundle.getInt(SAVE_STATE_INDEX, 0);
        this.mEntries = bundle.getCharSequenceArray(SAVE_STATE_ENTRIES);
        this.mEntryValues = bundle.getCharSequenceArray(SAVE_STATE_ENTRY_VALUES);
    }

    @Deprecated
    public void onDialogClosed(boolean z11) {
        int i11;
        ListPreference listPreference = getListPreference();
        if (z11 && (i11 = this.f37289b) >= 0) {
            String charSequence = this.mEntryValues[i11].toString();
            if (listPreference.callChangeListener(charSequence)) {
                listPreference.setValue(charSequence);
            }
        }
    }

    public void onSaveInstanceState(@NonNull Bundle bundle) {
        super.onSaveInstanceState(bundle);
        bundle.putInt(SAVE_STATE_INDEX, this.f37289b);
        bundle.putCharSequenceArray(SAVE_STATE_ENTRIES, this.mEntries);
        bundle.putCharSequenceArray(SAVE_STATE_ENTRY_VALUES, this.mEntryValues);
    }
}
