package androidx.preference;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import androidx.annotation.NonNull;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

@Deprecated
public class MultiSelectListPreferenceDialogFragment extends PreferenceDialogFragment {
    private static final String SAVE_STATE_CHANGED = "MultiSelectListPreferenceDialogFragment.changed";
    private static final String SAVE_STATE_ENTRIES = "MultiSelectListPreferenceDialogFragment.entries";
    private static final String SAVE_STATE_ENTRY_VALUES = "MultiSelectListPreferenceDialogFragment.entryValues";
    private static final String SAVE_STATE_VALUES = "MultiSelectListPreferenceDialogFragment.values";

    /* renamed from: b  reason: collision with root package name */
    public Set<String> f37293b = new HashSet();

    /* renamed from: c  reason: collision with root package name */
    public boolean f37294c;

    /* renamed from: d  reason: collision with root package name */
    public CharSequence[] f37295d;

    /* renamed from: e  reason: collision with root package name */
    public CharSequence[] f37296e;

    private MultiSelectListPreference getListPreference() {
        return (MultiSelectListPreference) getPreference();
    }

    @Deprecated
    public static MultiSelectListPreferenceDialogFragment newInstance(String str) {
        MultiSelectListPreferenceDialogFragment multiSelectListPreferenceDialogFragment = new MultiSelectListPreferenceDialogFragment();
        Bundle bundle = new Bundle(1);
        bundle.putString("key", str);
        multiSelectListPreferenceDialogFragment.setArguments(bundle);
        return multiSelectListPreferenceDialogFragment;
    }

    public void d(AlertDialog.Builder builder) {
        super.d(builder);
        int length = this.f37296e.length;
        boolean[] zArr = new boolean[length];
        for (int i11 = 0; i11 < length; i11++) {
            zArr[i11] = this.f37293b.contains(this.f37296e[i11].toString());
        }
        builder.setMultiChoiceItems(this.f37295d, zArr, new DialogInterface.OnMultiChoiceClickListener() {
            public void onClick(DialogInterface dialogInterface, int i11, boolean z11) {
                if (z11) {
                    MultiSelectListPreferenceDialogFragment multiSelectListPreferenceDialogFragment = MultiSelectListPreferenceDialogFragment.this;
                    multiSelectListPreferenceDialogFragment.f37294c = multiSelectListPreferenceDialogFragment.f37293b.add(multiSelectListPreferenceDialogFragment.f37296e[i11].toString()) | multiSelectListPreferenceDialogFragment.f37294c;
                    return;
                }
                MultiSelectListPreferenceDialogFragment multiSelectListPreferenceDialogFragment2 = MultiSelectListPreferenceDialogFragment.this;
                multiSelectListPreferenceDialogFragment2.f37294c = multiSelectListPreferenceDialogFragment2.f37293b.remove(multiSelectListPreferenceDialogFragment2.f37296e[i11].toString()) | multiSelectListPreferenceDialogFragment2.f37294c;
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
            this.f37293b.clear();
            this.f37293b.addAll(listPreference.getValues());
            this.f37294c = false;
            this.f37295d = listPreference.getEntries();
            this.f37296e = listPreference.getEntryValues();
            return;
        }
        this.f37293b.clear();
        this.f37293b.addAll(bundle.getStringArrayList(SAVE_STATE_VALUES));
        this.f37294c = bundle.getBoolean(SAVE_STATE_CHANGED, false);
        this.f37295d = bundle.getCharSequenceArray(SAVE_STATE_ENTRIES);
        this.f37296e = bundle.getCharSequenceArray(SAVE_STATE_ENTRY_VALUES);
    }

    @Deprecated
    public void onDialogClosed(boolean z11) {
        MultiSelectListPreference listPreference = getListPreference();
        if (z11 && this.f37294c) {
            Set<String> set = this.f37293b;
            if (listPreference.callChangeListener(set)) {
                listPreference.setValues(set);
            }
        }
        this.f37294c = false;
    }

    public void onSaveInstanceState(@NonNull Bundle bundle) {
        super.onSaveInstanceState(bundle);
        bundle.putStringArrayList(SAVE_STATE_VALUES, new ArrayList(this.f37293b));
        bundle.putBoolean(SAVE_STATE_CHANGED, this.f37294c);
        bundle.putCharSequenceArray(SAVE_STATE_ENTRIES, this.f37295d);
        bundle.putCharSequenceArray(SAVE_STATE_ENTRY_VALUES, this.f37296e);
    }
}
