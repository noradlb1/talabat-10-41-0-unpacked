package androidx.preference;

import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.RestrictTo;
import androidx.appcompat.content.res.AppCompatResources;
import androidx.core.view.ViewCompat;
import androidx.preference.Preference;
import androidx.preference.PreferenceGroup;
import androidx.preference.PreferenceManager;
import androidx.recyclerview.widget.DiffUtil;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;
import java.util.List;

@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
public class PreferenceGroupAdapter extends RecyclerView.Adapter<PreferenceViewHolder> implements Preference.OnPreferenceChangeInternalListener, PreferenceGroup.PreferencePositionCallback {
    private Handler mHandler;
    private PreferenceGroup mPreferenceGroup;
    private List<PreferenceResourceDescriptor> mPreferenceResourceDescriptors;
    private List<Preference> mPreferences;
    private Runnable mSyncRunnable = new Runnable() {
        public void run() {
            PreferenceGroupAdapter.this.e();
        }
    };
    private List<Preference> mVisiblePreferences;

    public static class PreferenceResourceDescriptor {

        /* renamed from: a  reason: collision with root package name */
        public int f37323a;

        /* renamed from: b  reason: collision with root package name */
        public int f37324b;

        /* renamed from: c  reason: collision with root package name */
        public String f37325c;

        public PreferenceResourceDescriptor(Preference preference) {
            this.f37325c = preference.getClass().getName();
            this.f37323a = preference.getLayoutResource();
            this.f37324b = preference.getWidgetLayoutResource();
        }

        public boolean equals(Object obj) {
            if (!(obj instanceof PreferenceResourceDescriptor)) {
                return false;
            }
            PreferenceResourceDescriptor preferenceResourceDescriptor = (PreferenceResourceDescriptor) obj;
            if (this.f37323a == preferenceResourceDescriptor.f37323a && this.f37324b == preferenceResourceDescriptor.f37324b && TextUtils.equals(this.f37325c, preferenceResourceDescriptor.f37325c)) {
                return true;
            }
            return false;
        }

        public int hashCode() {
            return ((((527 + this.f37323a) * 31) + this.f37324b) * 31) + this.f37325c.hashCode();
        }
    }

    public PreferenceGroupAdapter(PreferenceGroup preferenceGroup) {
        this.mPreferenceGroup = preferenceGroup;
        this.mHandler = new Handler();
        this.mPreferenceGroup.A(this);
        this.mPreferences = new ArrayList();
        this.mVisiblePreferences = new ArrayList();
        this.mPreferenceResourceDescriptors = new ArrayList();
        PreferenceGroup preferenceGroup2 = this.mPreferenceGroup;
        if (preferenceGroup2 instanceof PreferenceScreen) {
            setHasStableIds(((PreferenceScreen) preferenceGroup2).shouldUseGeneratedIds());
        } else {
            setHasStableIds(true);
        }
        e();
    }

    private ExpandButton createExpandButton(final PreferenceGroup preferenceGroup, List<Preference> list) {
        ExpandButton expandButton = new ExpandButton(preferenceGroup.getContext(), list, preferenceGroup.g());
        expandButton.setOnPreferenceClickListener(new Preference.OnPreferenceClickListener() {
            public boolean onPreferenceClick(Preference preference) {
                preferenceGroup.setInitialExpandedChildrenCount(Integer.MAX_VALUE);
                PreferenceGroupAdapter.this.onPreferenceHierarchyChange(preference);
                PreferenceGroup.OnExpandButtonClickListener onExpandButtonClickListener = preferenceGroup.getOnExpandButtonClickListener();
                if (onExpandButtonClickListener == null) {
                    return true;
                }
                onExpandButtonClickListener.onExpandButtonClick();
                return true;
            }
        });
        return expandButton;
    }

    private List<Preference> createVisiblePreferencesList(PreferenceGroup preferenceGroup) {
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        int preferenceCount = preferenceGroup.getPreferenceCount();
        int i11 = 0;
        for (int i12 = 0; i12 < preferenceCount; i12++) {
            Preference preference = preferenceGroup.getPreference(i12);
            if (preference.isVisible()) {
                if (!isGroupExpandable(preferenceGroup) || i11 < preferenceGroup.getInitialExpandedChildrenCount()) {
                    arrayList.add(preference);
                } else {
                    arrayList2.add(preference);
                }
                if (!(preference instanceof PreferenceGroup)) {
                    i11++;
                } else {
                    PreferenceGroup preferenceGroup2 = (PreferenceGroup) preference;
                    if (!preferenceGroup2.D()) {
                        continue;
                    } else if (!isGroupExpandable(preferenceGroup) || !isGroupExpandable(preferenceGroup2)) {
                        for (Preference next : createVisiblePreferencesList(preferenceGroup2)) {
                            if (!isGroupExpandable(preferenceGroup) || i11 < preferenceGroup.getInitialExpandedChildrenCount()) {
                                arrayList.add(next);
                            } else {
                                arrayList2.add(next);
                            }
                            i11++;
                        }
                    } else {
                        throw new IllegalStateException("Nesting an expandable group inside of another expandable group is not supported!");
                    }
                }
            }
        }
        if (isGroupExpandable(preferenceGroup) && i11 > preferenceGroup.getInitialExpandedChildrenCount()) {
            arrayList.add(createExpandButton(preferenceGroup, arrayList2));
        }
        return arrayList;
    }

    private void flattenPreferenceGroup(List<Preference> list, PreferenceGroup preferenceGroup) {
        preferenceGroup.F();
        int preferenceCount = preferenceGroup.getPreferenceCount();
        for (int i11 = 0; i11 < preferenceCount; i11++) {
            Preference preference = preferenceGroup.getPreference(i11);
            list.add(preference);
            PreferenceResourceDescriptor preferenceResourceDescriptor = new PreferenceResourceDescriptor(preference);
            if (!this.mPreferenceResourceDescriptors.contains(preferenceResourceDescriptor)) {
                this.mPreferenceResourceDescriptors.add(preferenceResourceDescriptor);
            }
            if (preference instanceof PreferenceGroup) {
                PreferenceGroup preferenceGroup2 = (PreferenceGroup) preference;
                if (preferenceGroup2.D()) {
                    flattenPreferenceGroup(list, preferenceGroup2);
                }
            }
            preference.A(this);
        }
    }

    private boolean isGroupExpandable(PreferenceGroup preferenceGroup) {
        return preferenceGroup.getInitialExpandedChildrenCount() != Integer.MAX_VALUE;
    }

    public void e() {
        for (Preference A : this.mPreferences) {
            A.A((Preference.OnPreferenceChangeInternalListener) null);
        }
        ArrayList arrayList = new ArrayList(this.mPreferences.size());
        this.mPreferences = arrayList;
        flattenPreferenceGroup(arrayList, this.mPreferenceGroup);
        final List<Preference> list = this.mVisiblePreferences;
        final List<Preference> createVisiblePreferencesList = createVisiblePreferencesList(this.mPreferenceGroup);
        this.mVisiblePreferences = createVisiblePreferencesList;
        PreferenceManager preferenceManager = this.mPreferenceGroup.getPreferenceManager();
        if (preferenceManager == null || preferenceManager.getPreferenceComparisonCallback() == null) {
            notifyDataSetChanged();
        } else {
            final PreferenceManager.PreferenceComparisonCallback preferenceComparisonCallback = preferenceManager.getPreferenceComparisonCallback();
            DiffUtil.calculateDiff(new DiffUtil.Callback() {
                public boolean areContentsTheSame(int i11, int i12) {
                    return preferenceComparisonCallback.arePreferenceContentsTheSame((Preference) list.get(i11), (Preference) createVisiblePreferencesList.get(i12));
                }

                public boolean areItemsTheSame(int i11, int i12) {
                    return preferenceComparisonCallback.arePreferenceItemsTheSame((Preference) list.get(i11), (Preference) createVisiblePreferencesList.get(i12));
                }

                public int getNewListSize() {
                    return createVisiblePreferencesList.size();
                }

                public int getOldListSize() {
                    return list.size();
                }
            }).dispatchUpdatesTo((RecyclerView.Adapter) this);
        }
        for (Preference b11 : this.mPreferences) {
            b11.b();
        }
    }

    public Preference getItem(int i11) {
        if (i11 < 0 || i11 >= getItemCount()) {
            return null;
        }
        return this.mVisiblePreferences.get(i11);
    }

    public int getItemCount() {
        return this.mVisiblePreferences.size();
    }

    public long getItemId(int i11) {
        if (!hasStableIds()) {
            return -1;
        }
        return getItem(i11).g();
    }

    public int getItemViewType(int i11) {
        PreferenceResourceDescriptor preferenceResourceDescriptor = new PreferenceResourceDescriptor(getItem(i11));
        int indexOf = this.mPreferenceResourceDescriptors.indexOf(preferenceResourceDescriptor);
        if (indexOf != -1) {
            return indexOf;
        }
        int size = this.mPreferenceResourceDescriptors.size();
        this.mPreferenceResourceDescriptors.add(preferenceResourceDescriptor);
        return size;
    }

    public int getPreferenceAdapterPosition(String str) {
        int size = this.mVisiblePreferences.size();
        for (int i11 = 0; i11 < size; i11++) {
            if (TextUtils.equals(str, this.mVisiblePreferences.get(i11).getKey())) {
                return i11;
            }
        }
        return -1;
    }

    public void onPreferenceChange(Preference preference) {
        int indexOf = this.mVisiblePreferences.indexOf(preference);
        if (indexOf != -1) {
            notifyItemChanged(indexOf, preference);
        }
    }

    public void onPreferenceHierarchyChange(Preference preference) {
        this.mHandler.removeCallbacks(this.mSyncRunnable);
        this.mHandler.post(this.mSyncRunnable);
    }

    public void onPreferenceVisibilityChange(Preference preference) {
        onPreferenceHierarchyChange(preference);
    }

    public void onBindViewHolder(@NonNull PreferenceViewHolder preferenceViewHolder, int i11) {
        getItem(i11).onBindViewHolder(preferenceViewHolder);
    }

    @NonNull
    public PreferenceViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i11) {
        PreferenceResourceDescriptor preferenceResourceDescriptor = this.mPreferenceResourceDescriptors.get(i11);
        LayoutInflater from = LayoutInflater.from(viewGroup.getContext());
        TypedArray obtainStyledAttributes = viewGroup.getContext().obtainStyledAttributes((AttributeSet) null, R.styleable.BackgroundStyle);
        Drawable drawable = obtainStyledAttributes.getDrawable(R.styleable.BackgroundStyle_android_selectableItemBackground);
        if (drawable == null) {
            drawable = AppCompatResources.getDrawable(viewGroup.getContext(), 17301602);
        }
        obtainStyledAttributes.recycle();
        View inflate = from.inflate(preferenceResourceDescriptor.f37323a, viewGroup, false);
        if (inflate.getBackground() == null) {
            ViewCompat.setBackground(inflate, drawable);
        }
        ViewGroup viewGroup2 = (ViewGroup) inflate.findViewById(16908312);
        if (viewGroup2 != null) {
            int i12 = preferenceResourceDescriptor.f37324b;
            if (i12 != 0) {
                from.inflate(i12, viewGroup2);
            } else {
                viewGroup2.setVisibility(8);
            }
        }
        return new PreferenceViewHolder(inflate);
    }

    public int getPreferenceAdapterPosition(Preference preference) {
        int size = this.mVisiblePreferences.size();
        for (int i11 = 0; i11 < size; i11++) {
            Preference preference2 = this.mVisiblePreferences.get(i11);
            if (preference2 != null && preference2.equals(preference)) {
                return i11;
            }
        }
        return -1;
    }
}
