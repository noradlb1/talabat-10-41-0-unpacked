package androidx.preference;

import android.content.Context;
import android.text.TextUtils;
import java.util.ArrayList;
import java.util.List;

final class ExpandButton extends Preference {
    private long mId;

    public ExpandButton(Context context, List<Preference> list, long j11) {
        super(context);
        initLayout();
        setSummary(list);
        this.mId = j11 + 1000000;
    }

    private void initLayout() {
        setLayoutResource(R.layout.expand_button);
        setIcon(R.drawable.ic_arrow_down_24dp);
        setTitle(R.string.expand_button_title);
        setOrder(999);
    }

    private void setSummary(List<Preference> list) {
        ArrayList arrayList = new ArrayList();
        CharSequence charSequence = null;
        for (Preference next : list) {
            CharSequence title = next.getTitle();
            boolean z11 = next instanceof PreferenceGroup;
            if (z11 && !TextUtils.isEmpty(title)) {
                arrayList.add((PreferenceGroup) next);
            }
            if (arrayList.contains(next.getParent())) {
                if (z11) {
                    arrayList.add((PreferenceGroup) next);
                }
            } else if (!TextUtils.isEmpty(title)) {
                if (charSequence == null) {
                    charSequence = title;
                } else {
                    charSequence = getContext().getString(R.string.summary_collapsed_preference_list, new Object[]{charSequence, title});
                }
            }
        }
        setSummary(charSequence);
    }

    public long g() {
        return this.mId;
    }

    public void onBindViewHolder(PreferenceViewHolder preferenceViewHolder) {
        super.onBindViewHolder(preferenceViewHolder);
        preferenceViewHolder.setDividerAllowedAbove(false);
    }
}
