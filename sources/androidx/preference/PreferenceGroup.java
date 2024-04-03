package androidx.preference;

import android.content.Context;
import android.content.res.TypedArray;
import android.os.Bundle;
import android.os.Handler;
import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.Log;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
import androidx.collection.SimpleArrayMap;
import androidx.core.content.res.TypedArrayUtils;
import androidx.preference.Preference;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public abstract class PreferenceGroup extends Preference {
    private static final String TAG = "PreferenceGroup";

    /* renamed from: b  reason: collision with root package name */
    public final SimpleArrayMap<String, Long> f37313b;
    private boolean mAttachedToHierarchy;
    private final Runnable mClearRecycleCacheRunnable;
    private int mCurrentPreferenceOrder;
    private final Handler mHandler;
    private int mInitialExpandedChildrenCount;
    private OnExpandButtonClickListener mOnExpandButtonClickListener;
    private boolean mOrderingAsAdded;
    private List<Preference> mPreferences;

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public interface OnExpandButtonClickListener {
        void onExpandButtonClick();
    }

    public interface PreferencePositionCallback {
        int getPreferenceAdapterPosition(Preference preference);

        int getPreferenceAdapterPosition(String str);
    }

    public PreferenceGroup(Context context, AttributeSet attributeSet, int i11, int i12) {
        super(context, attributeSet, i11, i12);
        this.f37313b = new SimpleArrayMap<>();
        this.mHandler = new Handler();
        this.mOrderingAsAdded = true;
        this.mCurrentPreferenceOrder = 0;
        this.mAttachedToHierarchy = false;
        this.mInitialExpandedChildrenCount = Integer.MAX_VALUE;
        this.mOnExpandButtonClickListener = null;
        this.mClearRecycleCacheRunnable = new Runnable() {
            public void run() {
                synchronized (this) {
                    PreferenceGroup.this.f37313b.clear();
                }
            }
        };
        this.mPreferences = new ArrayList();
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.PreferenceGroup, i11, i12);
        int i13 = R.styleable.PreferenceGroup_orderingFromXml;
        this.mOrderingAsAdded = TypedArrayUtils.getBoolean(obtainStyledAttributes, i13, i13, true);
        int i14 = R.styleable.PreferenceGroup_initialExpandedChildrenCount;
        if (obtainStyledAttributes.hasValue(i14)) {
            setInitialExpandedChildrenCount(TypedArrayUtils.getInt(obtainStyledAttributes, i14, i14, Integer.MAX_VALUE));
        }
        obtainStyledAttributes.recycle();
    }

    private boolean removePreferenceInt(Preference preference) {
        boolean remove;
        synchronized (this) {
            preference.q();
            if (preference.getParent() == this) {
                preference.a((PreferenceGroup) null);
            }
            remove = this.mPreferences.remove(preference);
            if (remove) {
                String key = preference.getKey();
                if (key != null) {
                    this.f37313b.put(key, Long.valueOf(preference.g()));
                    this.mHandler.removeCallbacks(this.mClearRecycleCacheRunnable);
                    this.mHandler.post(this.mClearRecycleCacheRunnable);
                }
                if (this.mAttachedToHierarchy) {
                    preference.onDetached();
                }
            }
        }
        return remove;
    }

    public boolean D() {
        return true;
    }

    public boolean E(Preference preference) {
        preference.onParentChanged(this, shouldDisableDependents());
        return true;
    }

    public void F() {
        synchronized (this) {
            Collections.sort(this.mPreferences);
        }
    }

    public void addItemFromInflater(Preference preference) {
        addPreference(preference);
    }

    public boolean addPreference(Preference preference) {
        long j11;
        if (this.mPreferences.contains(preference)) {
            return true;
        }
        if (preference.getKey() != null) {
            PreferenceGroup preferenceGroup = this;
            while (preferenceGroup.getParent() != null) {
                preferenceGroup = preferenceGroup.getParent();
            }
            String key = preference.getKey();
            if (preferenceGroup.findPreference(key) != null) {
                Log.e(TAG, "Found duplicated key: \"" + key + "\". This can cause unintended behaviour, please use unique keys for every preference.");
            }
        }
        if (preference.getOrder() == Integer.MAX_VALUE) {
            if (this.mOrderingAsAdded) {
                int i11 = this.mCurrentPreferenceOrder;
                this.mCurrentPreferenceOrder = i11 + 1;
                preference.setOrder(i11);
            }
            if (preference instanceof PreferenceGroup) {
                ((PreferenceGroup) preference).setOrderingAsAdded(this.mOrderingAsAdded);
            }
        }
        int binarySearch = Collections.binarySearch(this.mPreferences, preference);
        if (binarySearch < 0) {
            binarySearch = (binarySearch * -1) - 1;
        }
        if (!E(preference)) {
            return false;
        }
        synchronized (this) {
            this.mPreferences.add(binarySearch, preference);
        }
        PreferenceManager preferenceManager = getPreferenceManager();
        String key2 = preference.getKey();
        if (key2 == null || !this.f37313b.containsKey(key2)) {
            j11 = preferenceManager.b();
        } else {
            j11 = this.f37313b.get(key2).longValue();
            this.f37313b.remove(key2);
        }
        preference.n(preferenceManager, j11);
        preference.a(this);
        if (this.mAttachedToHierarchy) {
            preference.onAttached();
        }
        l();
        return true;
    }

    public void c(Bundle bundle) {
        super.c(bundle);
        int preferenceCount = getPreferenceCount();
        for (int i11 = 0; i11 < preferenceCount; i11++) {
            getPreference(i11).c(bundle);
        }
    }

    public void d(Bundle bundle) {
        super.d(bundle);
        int preferenceCount = getPreferenceCount();
        for (int i11 = 0; i11 < preferenceCount; i11++) {
            getPreference(i11).d(bundle);
        }
    }

    @Nullable
    public <T extends Preference> T findPreference(@NonNull CharSequence charSequence) {
        T findPreference;
        if (charSequence == null) {
            throw new IllegalArgumentException("Key cannot be null");
        } else if (TextUtils.equals(getKey(), charSequence)) {
            return this;
        } else {
            int preferenceCount = getPreferenceCount();
            for (int i11 = 0; i11 < preferenceCount; i11++) {
                T preference = getPreference(i11);
                if (TextUtils.equals(preference.getKey(), charSequence)) {
                    return preference;
                }
                if ((preference instanceof PreferenceGroup) && (findPreference = ((PreferenceGroup) preference).findPreference(charSequence)) != null) {
                    return findPreference;
                }
            }
            return null;
        }
    }

    public int getInitialExpandedChildrenCount() {
        return this.mInitialExpandedChildrenCount;
    }

    @Nullable
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public OnExpandButtonClickListener getOnExpandButtonClickListener() {
        return this.mOnExpandButtonClickListener;
    }

    public Preference getPreference(int i11) {
        return this.mPreferences.get(i11);
    }

    public int getPreferenceCount() {
        return this.mPreferences.size();
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public boolean isAttached() {
        return this.mAttachedToHierarchy;
    }

    public boolean isOrderingAsAdded() {
        return this.mOrderingAsAdded;
    }

    public void notifyDependencyChange(boolean z11) {
        super.notifyDependencyChange(z11);
        int preferenceCount = getPreferenceCount();
        for (int i11 = 0; i11 < preferenceCount; i11++) {
            getPreference(i11).onParentChanged(this, z11);
        }
    }

    public void onAttached() {
        super.onAttached();
        this.mAttachedToHierarchy = true;
        int preferenceCount = getPreferenceCount();
        for (int i11 = 0; i11 < preferenceCount; i11++) {
            getPreference(i11).onAttached();
        }
    }

    public void onDetached() {
        super.onDetached();
        this.mAttachedToHierarchy = false;
        int preferenceCount = getPreferenceCount();
        for (int i11 = 0; i11 < preferenceCount; i11++) {
            getPreference(i11).onDetached();
        }
    }

    public void r(Parcelable parcelable) {
        if (parcelable == null || !parcelable.getClass().equals(SavedState.class)) {
            super.r(parcelable);
            return;
        }
        SavedState savedState = (SavedState) parcelable;
        this.mInitialExpandedChildrenCount = savedState.f37315b;
        super.r(savedState.getSuperState());
    }

    public void removeAll() {
        synchronized (this) {
            List<Preference> list = this.mPreferences;
            for (int size = list.size() - 1; size >= 0; size--) {
                removePreferenceInt(list.get(0));
            }
        }
        l();
    }

    public boolean removePreference(Preference preference) {
        boolean removePreferenceInt = removePreferenceInt(preference);
        l();
        return removePreferenceInt;
    }

    public boolean removePreferenceRecursively(@NonNull CharSequence charSequence) {
        Preference findPreference = findPreference(charSequence);
        if (findPreference == null) {
            return false;
        }
        return findPreference.getParent().removePreference(findPreference);
    }

    public Parcelable s() {
        return new SavedState(super.s(), this.mInitialExpandedChildrenCount);
    }

    public void setInitialExpandedChildrenCount(int i11) {
        if (i11 != Integer.MAX_VALUE && !hasKey()) {
            Log.e(TAG, getClass().getSimpleName() + " should have a key defined if it contains an expandable preference");
        }
        this.mInitialExpandedChildrenCount = i11;
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public void setOnExpandButtonClickListener(@Nullable OnExpandButtonClickListener onExpandButtonClickListener) {
        this.mOnExpandButtonClickListener = onExpandButtonClickListener;
    }

    public void setOrderingAsAdded(boolean z11) {
        this.mOrderingAsAdded = z11;
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
        public int f37315b;

        public SavedState(Parcel parcel) {
            super(parcel);
            this.f37315b = parcel.readInt();
        }

        public void writeToParcel(Parcel parcel, int i11) {
            super.writeToParcel(parcel, i11);
            parcel.writeInt(this.f37315b);
        }

        public SavedState(Parcelable parcelable, int i11) {
            super(parcelable);
            this.f37315b = i11;
        }
    }

    public PreferenceGroup(Context context, AttributeSet attributeSet, int i11) {
        this(context, attributeSet, i11, 0);
    }

    public PreferenceGroup(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }
}
