package androidx.preference;

import android.content.DialogInterface;
import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public class MultiSelectListPreferenceDialogFragmentCompat extends PreferenceDialogFragmentCompat {
    private static final String SAVE_STATE_CHANGED = "MultiSelectListPreferenceDialogFragmentCompat.changed";
    private static final String SAVE_STATE_ENTRIES = "MultiSelectListPreferenceDialogFragmentCompat.entries";
    private static final String SAVE_STATE_ENTRY_VALUES = "MultiSelectListPreferenceDialogFragmentCompat.entryValues";
    private static final String SAVE_STATE_VALUES = "MultiSelectListPreferenceDialogFragmentCompat.values";
    public Set<String> C = new HashSet();
    public boolean F;
    public CharSequence[] G;
    public CharSequence[] H;

    private MultiSelectListPreference getListPreference() {
        return (MultiSelectListPreference) getPreference();
    }

    public static MultiSelectListPreferenceDialogFragmentCompat newInstance(String str) {
        MultiSelectListPreferenceDialogFragmentCompat multiSelectListPreferenceDialogFragmentCompat = new MultiSelectListPreferenceDialogFragmentCompat();
        Bundle bundle = new Bundle(1);
        bundle.putString("key", str);
        multiSelectListPreferenceDialogFragmentCompat.setArguments(bundle);
        return multiSelectListPreferenceDialogFragmentCompat;
    }

    public void l0(AlertDialog.Builder builder) {
        super.l0(builder);
        int length = this.H.length;
        boolean[] zArr = new boolean[length];
        for (int i11 = 0; i11 < length; i11++) {
            zArr[i11] = this.C.contains(this.H[i11].toString());
        }
        builder.setMultiChoiceItems(this.G, zArr, (DialogInterface.OnMultiChoiceClickListener) new DialogInterface.OnMultiChoiceClickListener() {
            public void onClick(DialogInterface dialogInterface, int i11, boolean z11) {
                if (z11) {
                    MultiSelectListPreferenceDialogFragmentCompat multiSelectListPreferenceDialogFragmentCompat = MultiSelectListPreferenceDialogFragmentCompat.this;
                    multiSelectListPreferenceDialogFragmentCompat.F = multiSelectListPreferenceDialogFragmentCompat.C.add(multiSelectListPreferenceDialogFragmentCompat.H[i11].toString()) | multiSelectListPreferenceDialogFragmentCompat.F;
                    return;
                }
                MultiSelectListPreferenceDialogFragmentCompat multiSelectListPreferenceDialogFragmentCompat2 = MultiSelectListPreferenceDialogFragmentCompat.this;
                multiSelectListPreferenceDialogFragmentCompat2.F = multiSelectListPreferenceDialogFragmentCompat2.C.remove(multiSelectListPreferenceDialogFragmentCompat2.H[i11].toString()) | multiSelectListPreferenceDialogFragmentCompat2.F;
            }
        });
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        if (bundle == null) {
            MultiSelectListPreference listPreference = getListPreference();
            if (listPreference.getEntries() == null || listPreference.getEntryValues() == null) {
                throw new IllegalStateException("MultiSelectListPreference requires an entries array and an entryValues array.");
            }
            this.C.clear();
            this.C.addAll(listPreference.getValues());
            this.F = false;
            this.G = listPreference.getEntries();
            this.H = listPreference.getEntryValues();
            return;
        }
        this.C.clear();
        this.C.addAll(bundle.getStringArrayList(SAVE_STATE_VALUES));
        this.F = bundle.getBoolean(SAVE_STATE_CHANGED, false);
        this.G = bundle.getCharSequenceArray(SAVE_STATE_ENTRIES);
        this.H = bundle.getCharSequenceArray(SAVE_STATE_ENTRY_VALUES);
    }

    public void onDialogClosed(boolean z11) {
        if (z11 && this.F) {
            MultiSelectListPreference listPreference = getListPreference();
            if (listPreference.callChangeListener(this.C)) {
                listPreference.setValues(this.C);
            }
        }
        this.F = false;
    }

    public void onSaveInstanceState(@NonNull Bundle bundle) {
        super.onSaveInstanceState(bundle);
        bundle.putStringArrayList(SAVE_STATE_VALUES, new ArrayList(this.C));
        bundle.putBoolean(SAVE_STATE_CHANGED, this.F);
        bundle.putCharSequenceArray(SAVE_STATE_ENTRIES, this.G);
        bundle.putCharSequenceArray(SAVE_STATE_ENTRY_VALUES, this.H);
    }
}
