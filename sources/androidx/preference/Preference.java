package androidx.preference;

import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.AbsSavedState;
import android.view.ContextMenu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;
import androidx.annotation.CallSuper;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
import androidx.appcompat.content.res.AppCompatResources;
import androidx.core.content.res.TypedArrayUtils;
import androidx.core.view.accessibility.AccessibilityNodeInfoCompat;
import androidx.preference.PreferenceManager;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class Preference implements Comparable<Preference> {
    private static final String CLIPBOARD_ID = "Preference";
    public static final int DEFAULT_ORDER = Integer.MAX_VALUE;
    private boolean mAllowDividerAbove;
    private boolean mAllowDividerBelow;
    private boolean mBaseMethodCalled;
    private final View.OnClickListener mClickListener;
    private Context mContext;
    private boolean mCopyingEnabled;
    private Object mDefaultValue;
    private String mDependencyKey;
    private boolean mDependencyMet;
    private List<Preference> mDependents;
    private boolean mEnabled;
    private Bundle mExtras;
    private String mFragment;
    private boolean mHasId;
    private boolean mHasSingleLineTitleAttr;
    private Drawable mIcon;
    private int mIconResId;
    private boolean mIconSpaceReserved;
    private long mId;
    private Intent mIntent;
    private String mKey;
    private int mLayoutResId;
    private OnPreferenceChangeInternalListener mListener;
    private OnPreferenceChangeListener mOnChangeListener;
    private OnPreferenceClickListener mOnClickListener;
    private OnPreferenceCopyListener mOnCopyListener;
    private int mOrder;
    private boolean mParentDependencyMet;
    private PreferenceGroup mParentGroup;
    private boolean mPersistent;
    @Nullable
    private PreferenceDataStore mPreferenceDataStore;
    @Nullable
    private PreferenceManager mPreferenceManager;
    private boolean mRequiresKey;
    private boolean mSelectable;
    private boolean mShouldDisableView;
    private boolean mSingleLineTitle;
    private CharSequence mSummary;
    private SummaryProvider mSummaryProvider;
    private CharSequence mTitle;
    private int mViewId;
    private boolean mVisible;
    private boolean mWasDetached;
    private int mWidgetLayoutResId;

    public static class BaseSavedState extends AbsSavedState {
        public static final Parcelable.Creator<BaseSavedState> CREATOR = new Parcelable.Creator<BaseSavedState>() {
            public BaseSavedState createFromParcel(Parcel parcel) {
                return new BaseSavedState(parcel);
            }

            public BaseSavedState[] newArray(int i11) {
                return new BaseSavedState[i11];
            }
        };

        public BaseSavedState(Parcel parcel) {
            super(parcel);
        }

        public BaseSavedState(Parcelable parcelable) {
            super(parcelable);
        }
    }

    public interface OnPreferenceChangeInternalListener {
        void onPreferenceChange(Preference preference);

        void onPreferenceHierarchyChange(Preference preference);

        void onPreferenceVisibilityChange(Preference preference);
    }

    public interface OnPreferenceChangeListener {
        boolean onPreferenceChange(Preference preference, Object obj);
    }

    public interface OnPreferenceClickListener {
        boolean onPreferenceClick(Preference preference);
    }

    public static class OnPreferenceCopyListener implements View.OnCreateContextMenuListener, MenuItem.OnMenuItemClickListener {
        private final Preference mPreference;

        public OnPreferenceCopyListener(Preference preference) {
            this.mPreference = preference;
        }

        public void onCreateContextMenu(ContextMenu contextMenu, View view, ContextMenu.ContextMenuInfo contextMenuInfo) {
            CharSequence summary = this.mPreference.getSummary();
            if (this.mPreference.isCopyingEnabled() && !TextUtils.isEmpty(summary)) {
                contextMenu.setHeaderTitle(summary);
                contextMenu.add(0, 0, 0, R.string.copy).setOnMenuItemClickListener(this);
            }
        }

        public boolean onMenuItemClick(MenuItem menuItem) {
            CharSequence summary = this.mPreference.getSummary();
            ((ClipboardManager) this.mPreference.getContext().getSystemService("clipboard")).setPrimaryClip(ClipData.newPlainText(Preference.CLIPBOARD_ID, summary));
            Toast.makeText(this.mPreference.getContext(), this.mPreference.getContext().getString(R.string.preference_copied, new Object[]{summary}), 0).show();
            return true;
        }
    }

    public interface SummaryProvider<T extends Preference> {
        CharSequence provideSummary(T t11);
    }

    public Preference(Context context, AttributeSet attributeSet, int i11, int i12) {
        this.mOrder = Integer.MAX_VALUE;
        this.mViewId = 0;
        this.mEnabled = true;
        this.mSelectable = true;
        this.mPersistent = true;
        this.mDependencyMet = true;
        this.mParentDependencyMet = true;
        this.mVisible = true;
        this.mAllowDividerAbove = true;
        this.mAllowDividerBelow = true;
        this.mSingleLineTitle = true;
        this.mShouldDisableView = true;
        int i13 = R.layout.preference;
        this.mLayoutResId = i13;
        this.mClickListener = new View.OnClickListener() {
            public void onClick(View view) {
                Preference.this.v(view);
            }
        };
        this.mContext = context;
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.Preference, i11, i12);
        this.mIconResId = TypedArrayUtils.getResourceId(obtainStyledAttributes, R.styleable.Preference_icon, R.styleable.Preference_android_icon, 0);
        this.mKey = TypedArrayUtils.getString(obtainStyledAttributes, R.styleable.Preference_key, R.styleable.Preference_android_key);
        this.mTitle = TypedArrayUtils.getText(obtainStyledAttributes, R.styleable.Preference_title, R.styleable.Preference_android_title);
        this.mSummary = TypedArrayUtils.getText(obtainStyledAttributes, R.styleable.Preference_summary, R.styleable.Preference_android_summary);
        this.mOrder = TypedArrayUtils.getInt(obtainStyledAttributes, R.styleable.Preference_order, R.styleable.Preference_android_order, Integer.MAX_VALUE);
        this.mFragment = TypedArrayUtils.getString(obtainStyledAttributes, R.styleable.Preference_fragment, R.styleable.Preference_android_fragment);
        this.mLayoutResId = TypedArrayUtils.getResourceId(obtainStyledAttributes, R.styleable.Preference_layout, R.styleable.Preference_android_layout, i13);
        this.mWidgetLayoutResId = TypedArrayUtils.getResourceId(obtainStyledAttributes, R.styleable.Preference_widgetLayout, R.styleable.Preference_android_widgetLayout, 0);
        this.mEnabled = TypedArrayUtils.getBoolean(obtainStyledAttributes, R.styleable.Preference_enabled, R.styleable.Preference_android_enabled, true);
        this.mSelectable = TypedArrayUtils.getBoolean(obtainStyledAttributes, R.styleable.Preference_selectable, R.styleable.Preference_android_selectable, true);
        this.mPersistent = TypedArrayUtils.getBoolean(obtainStyledAttributes, R.styleable.Preference_persistent, R.styleable.Preference_android_persistent, true);
        this.mDependencyKey = TypedArrayUtils.getString(obtainStyledAttributes, R.styleable.Preference_dependency, R.styleable.Preference_android_dependency);
        int i14 = R.styleable.Preference_allowDividerAbove;
        this.mAllowDividerAbove = TypedArrayUtils.getBoolean(obtainStyledAttributes, i14, i14, this.mSelectable);
        int i15 = R.styleable.Preference_allowDividerBelow;
        this.mAllowDividerBelow = TypedArrayUtils.getBoolean(obtainStyledAttributes, i15, i15, this.mSelectable);
        int i16 = R.styleable.Preference_defaultValue;
        if (obtainStyledAttributes.hasValue(i16)) {
            this.mDefaultValue = p(obtainStyledAttributes, i16);
        } else {
            int i17 = R.styleable.Preference_android_defaultValue;
            if (obtainStyledAttributes.hasValue(i17)) {
                this.mDefaultValue = p(obtainStyledAttributes, i17);
            }
        }
        this.mShouldDisableView = TypedArrayUtils.getBoolean(obtainStyledAttributes, R.styleable.Preference_shouldDisableView, R.styleable.Preference_android_shouldDisableView, true);
        int i18 = R.styleable.Preference_singleLineTitle;
        boolean hasValue = obtainStyledAttributes.hasValue(i18);
        this.mHasSingleLineTitleAttr = hasValue;
        if (hasValue) {
            this.mSingleLineTitle = TypedArrayUtils.getBoolean(obtainStyledAttributes, i18, R.styleable.Preference_android_singleLineTitle, true);
        }
        this.mIconSpaceReserved = TypedArrayUtils.getBoolean(obtainStyledAttributes, R.styleable.Preference_iconSpaceReserved, R.styleable.Preference_android_iconSpaceReserved, false);
        int i19 = R.styleable.Preference_isPreferenceVisible;
        this.mVisible = TypedArrayUtils.getBoolean(obtainStyledAttributes, i19, i19, true);
        int i21 = R.styleable.Preference_enableCopying;
        this.mCopyingEnabled = TypedArrayUtils.getBoolean(obtainStyledAttributes, i21, i21, false);
        obtainStyledAttributes.recycle();
    }

    private void dispatchSetInitialValue() {
        if (getPreferenceDataStore() != null) {
            u(true, this.mDefaultValue);
        } else if (!B() || !getSharedPreferences().contains(this.mKey)) {
            Object obj = this.mDefaultValue;
            if (obj != null) {
                u(false, obj);
            }
        } else {
            u(true, (Object) null);
        }
    }

    private void registerDependency() {
        if (!TextUtils.isEmpty(this.mDependencyKey)) {
            Preference e11 = e(this.mDependencyKey);
            if (e11 != null) {
                e11.registerDependent(this);
                return;
            }
            throw new IllegalStateException("Dependency \"" + this.mDependencyKey + "\" not found for preference \"" + this.mKey + "\" (title: \"" + this.mTitle + "\"");
        }
    }

    private void registerDependent(Preference preference) {
        if (this.mDependents == null) {
            this.mDependents = new ArrayList();
        }
        this.mDependents.add(preference);
        preference.onDependencyChanged(this, shouldDisableDependents());
    }

    private void setEnabledStateOnViews(View view, boolean z11) {
        view.setEnabled(z11);
        if (view instanceof ViewGroup) {
            ViewGroup viewGroup = (ViewGroup) view;
            for (int childCount = viewGroup.getChildCount() - 1; childCount >= 0; childCount--) {
                setEnabledStateOnViews(viewGroup.getChildAt(childCount), z11);
            }
        }
    }

    private void tryCommit(@NonNull SharedPreferences.Editor editor) {
        if (this.mPreferenceManager.c()) {
            editor.apply();
        }
    }

    private void unregisterDependency() {
        Preference e11;
        String str = this.mDependencyKey;
        if (str != null && (e11 = e(str)) != null) {
            e11.unregisterDependent(this);
        }
    }

    private void unregisterDependent(Preference preference) {
        List<Preference> list = this.mDependents;
        if (list != null) {
            list.remove(preference);
        }
    }

    public final void A(OnPreferenceChangeInternalListener onPreferenceChangeInternalListener) {
        this.mListener = onPreferenceChangeInternalListener;
    }

    public boolean B() {
        return this.mPreferenceManager != null && isPersistent() && hasKey();
    }

    public final boolean C() {
        return this.mWasDetached;
    }

    public void a(@Nullable PreferenceGroup preferenceGroup) {
        if (preferenceGroup == null || this.mParentGroup == null) {
            this.mParentGroup = preferenceGroup;
            return;
        }
        throw new IllegalStateException("This preference already has a parent. You must remove the existing parent before assigning a new one.");
    }

    public final void b() {
        this.mWasDetached = false;
    }

    public void c(Bundle bundle) {
        Parcelable parcelable;
        if (hasKey() && (parcelable = bundle.getParcelable(this.mKey)) != null) {
            this.mBaseMethodCalled = false;
            r(parcelable);
            if (!this.mBaseMethodCalled) {
                throw new IllegalStateException("Derived class did not call super.onRestoreInstanceState()");
            }
        }
    }

    public boolean callChangeListener(Object obj) {
        OnPreferenceChangeListener onPreferenceChangeListener = this.mOnChangeListener;
        return onPreferenceChangeListener == null || onPreferenceChangeListener.onPreferenceChange(this, obj);
    }

    public void d(Bundle bundle) {
        if (hasKey()) {
            this.mBaseMethodCalled = false;
            Parcelable s11 = s();
            if (!this.mBaseMethodCalled) {
                throw new IllegalStateException("Derived class did not call super.onSaveInstanceState()");
            } else if (s11 != null) {
                bundle.putParcelable(this.mKey, s11);
            }
        }
    }

    @Nullable
    public <T extends Preference> T e(@NonNull String str) {
        PreferenceManager preferenceManager = this.mPreferenceManager;
        if (preferenceManager == null) {
            return null;
        }
        return preferenceManager.findPreference(str);
    }

    public StringBuilder f() {
        StringBuilder sb2 = new StringBuilder();
        CharSequence title = getTitle();
        if (!TextUtils.isEmpty(title)) {
            sb2.append(title);
            sb2.append(' ');
        }
        CharSequence summary = getSummary();
        if (!TextUtils.isEmpty(summary)) {
            sb2.append(summary);
            sb2.append(' ');
        }
        if (sb2.length() > 0) {
            sb2.setLength(sb2.length() - 1);
        }
        return sb2;
    }

    public long g() {
        return this.mId;
    }

    public Context getContext() {
        return this.mContext;
    }

    public String getDependency() {
        return this.mDependencyKey;
    }

    public Bundle getExtras() {
        if (this.mExtras == null) {
            this.mExtras = new Bundle();
        }
        return this.mExtras;
    }

    public String getFragment() {
        return this.mFragment;
    }

    public Drawable getIcon() {
        int i11;
        if (this.mIcon == null && (i11 = this.mIconResId) != 0) {
            this.mIcon = AppCompatResources.getDrawable(this.mContext, i11);
        }
        return this.mIcon;
    }

    public Intent getIntent() {
        return this.mIntent;
    }

    public String getKey() {
        return this.mKey;
    }

    public final int getLayoutResource() {
        return this.mLayoutResId;
    }

    public OnPreferenceChangeListener getOnPreferenceChangeListener() {
        return this.mOnChangeListener;
    }

    public OnPreferenceClickListener getOnPreferenceClickListener() {
        return this.mOnClickListener;
    }

    public int getOrder() {
        return this.mOrder;
    }

    @Nullable
    public PreferenceGroup getParent() {
        return this.mParentGroup;
    }

    public Set<String> getPersistedStringSet(Set<String> set) {
        if (!B()) {
            return set;
        }
        PreferenceDataStore preferenceDataStore = getPreferenceDataStore();
        if (preferenceDataStore != null) {
            return preferenceDataStore.getStringSet(this.mKey, set);
        }
        return this.mPreferenceManager.getSharedPreferences().getStringSet(this.mKey, set);
    }

    @Nullable
    public PreferenceDataStore getPreferenceDataStore() {
        PreferenceDataStore preferenceDataStore = this.mPreferenceDataStore;
        if (preferenceDataStore != null) {
            return preferenceDataStore;
        }
        PreferenceManager preferenceManager = this.mPreferenceManager;
        if (preferenceManager != null) {
            return preferenceManager.getPreferenceDataStore();
        }
        return null;
    }

    public PreferenceManager getPreferenceManager() {
        return this.mPreferenceManager;
    }

    public SharedPreferences getSharedPreferences() {
        if (this.mPreferenceManager == null || getPreferenceDataStore() != null) {
            return null;
        }
        return this.mPreferenceManager.getSharedPreferences();
    }

    public boolean getShouldDisableView() {
        return this.mShouldDisableView;
    }

    public CharSequence getSummary() {
        if (getSummaryProvider() != null) {
            return getSummaryProvider().provideSummary(this);
        }
        return this.mSummary;
    }

    @Nullable
    public final SummaryProvider getSummaryProvider() {
        return this.mSummaryProvider;
    }

    public CharSequence getTitle() {
        return this.mTitle;
    }

    public final int getWidgetLayoutResource() {
        return this.mWidgetLayoutResId;
    }

    public boolean h(boolean z11) {
        if (!B()) {
            return z11;
        }
        PreferenceDataStore preferenceDataStore = getPreferenceDataStore();
        if (preferenceDataStore != null) {
            return preferenceDataStore.getBoolean(this.mKey, z11);
        }
        return this.mPreferenceManager.getSharedPreferences().getBoolean(this.mKey, z11);
    }

    public boolean hasKey() {
        return !TextUtils.isEmpty(this.mKey);
    }

    public int i(int i11) {
        if (!B()) {
            return i11;
        }
        PreferenceDataStore preferenceDataStore = getPreferenceDataStore();
        if (preferenceDataStore != null) {
            return preferenceDataStore.getInt(this.mKey, i11);
        }
        return this.mPreferenceManager.getSharedPreferences().getInt(this.mKey, i11);
    }

    public boolean isCopyingEnabled() {
        return this.mCopyingEnabled;
    }

    public boolean isEnabled() {
        return this.mEnabled && this.mDependencyMet && this.mParentDependencyMet;
    }

    public boolean isIconSpaceReserved() {
        return this.mIconSpaceReserved;
    }

    public boolean isPersistent() {
        return this.mPersistent;
    }

    public boolean isSelectable() {
        return this.mSelectable;
    }

    public final boolean isShown() {
        if (!isVisible() || getPreferenceManager() == null) {
            return false;
        }
        if (this == getPreferenceManager().getPreferenceScreen()) {
            return true;
        }
        PreferenceGroup parent = getParent();
        if (parent == null) {
            return false;
        }
        return parent.isShown();
    }

    public boolean isSingleLineTitle() {
        return this.mSingleLineTitle;
    }

    public final boolean isVisible() {
        return this.mVisible;
    }

    public String j(String str) {
        if (!B()) {
            return str;
        }
        PreferenceDataStore preferenceDataStore = getPreferenceDataStore();
        if (preferenceDataStore != null) {
            return preferenceDataStore.getString(this.mKey, str);
        }
        return this.mPreferenceManager.getSharedPreferences().getString(this.mKey, str);
    }

    public void k() {
        OnPreferenceChangeInternalListener onPreferenceChangeInternalListener = this.mListener;
        if (onPreferenceChangeInternalListener != null) {
            onPreferenceChangeInternalListener.onPreferenceChange(this);
        }
    }

    public void l() {
        OnPreferenceChangeInternalListener onPreferenceChangeInternalListener = this.mListener;
        if (onPreferenceChangeInternalListener != null) {
            onPreferenceChangeInternalListener.onPreferenceHierarchyChange(this);
        }
    }

    public void m(PreferenceManager preferenceManager) {
        this.mPreferenceManager = preferenceManager;
        if (!this.mHasId) {
            this.mId = preferenceManager.b();
        }
        dispatchSetInitialValue();
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public void n(PreferenceManager preferenceManager, long j11) {
        this.mId = j11;
        this.mHasId = true;
        try {
            m(preferenceManager);
        } finally {
            this.mHasId = false;
        }
    }

    public void notifyDependencyChange(boolean z11) {
        List<Preference> list = this.mDependents;
        if (list != null) {
            int size = list.size();
            for (int i11 = 0; i11 < size; i11++) {
                list.get(i11).onDependencyChanged(this, z11);
            }
        }
    }

    public void o() {
    }

    public void onAttached() {
        registerDependency();
    }

    /* JADX WARNING: Removed duplicated region for block: B:23:0x0081  */
    /* JADX WARNING: Removed duplicated region for block: B:43:0x00b6  */
    /* JADX WARNING: Removed duplicated region for block: B:45:0x00bf  */
    /* JADX WARNING: Removed duplicated region for block: B:54:0x00d3  */
    /* JADX WARNING: Removed duplicated region for block: B:55:0x00db  */
    /* JADX WARNING: Removed duplicated region for block: B:62:0x0106  */
    /* JADX WARNING: Removed duplicated region for block: B:63:0x0109  */
    /* JADX WARNING: Removed duplicated region for block: B:9:0x0043  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void onBindViewHolder(androidx.preference.PreferenceViewHolder r9) {
        /*
            r8 = this;
            android.view.View r0 = r9.itemView
            android.view.View$OnClickListener r1 = r8.mClickListener
            r0.setOnClickListener(r1)
            int r1 = r8.mViewId
            r0.setId(r1)
            r1 = 16908304(0x1020010, float:2.3877274E-38)
            android.view.View r1 = r9.findViewById(r1)
            android.widget.TextView r1 = (android.widget.TextView) r1
            r2 = 0
            r3 = 8
            r4 = 0
            if (r1 == 0) goto L_0x0037
            java.lang.CharSequence r5 = r8.getSummary()
            boolean r6 = android.text.TextUtils.isEmpty(r5)
            if (r6 != 0) goto L_0x0034
            r1.setText(r5)
            r1.setVisibility(r2)
            int r1 = r1.getCurrentTextColor()
            java.lang.Integer r1 = java.lang.Integer.valueOf(r1)
            goto L_0x0038
        L_0x0034:
            r1.setVisibility(r3)
        L_0x0037:
            r1 = r4
        L_0x0038:
            r5 = 16908310(0x1020016, float:2.387729E-38)
            android.view.View r5 = r9.findViewById(r5)
            android.widget.TextView r5 = (android.widget.TextView) r5
            if (r5 == 0) goto L_0x0075
            java.lang.CharSequence r6 = r8.getTitle()
            boolean r7 = android.text.TextUtils.isEmpty(r6)
            if (r7 != 0) goto L_0x0072
            r5.setText(r6)
            r5.setVisibility(r2)
            boolean r6 = r8.mHasSingleLineTitleAttr
            if (r6 == 0) goto L_0x005c
            boolean r6 = r8.mSingleLineTitle
            r5.setSingleLine(r6)
        L_0x005c:
            boolean r6 = r8.isSelectable()
            if (r6 != 0) goto L_0x0075
            boolean r6 = r8.isEnabled()
            if (r6 == 0) goto L_0x0075
            if (r1 == 0) goto L_0x0075
            int r1 = r1.intValue()
            r5.setTextColor(r1)
            goto L_0x0075
        L_0x0072:
            r5.setVisibility(r3)
        L_0x0075:
            r1 = 16908294(0x1020006, float:2.3877246E-38)
            android.view.View r1 = r9.findViewById(r1)
            android.widget.ImageView r1 = (android.widget.ImageView) r1
            r5 = 4
            if (r1 == 0) goto L_0x00ae
            int r6 = r8.mIconResId
            if (r6 != 0) goto L_0x0089
            android.graphics.drawable.Drawable r7 = r8.mIcon
            if (r7 == 0) goto L_0x009c
        L_0x0089:
            android.graphics.drawable.Drawable r7 = r8.mIcon
            if (r7 != 0) goto L_0x0095
            android.content.Context r7 = r8.mContext
            android.graphics.drawable.Drawable r6 = androidx.appcompat.content.res.AppCompatResources.getDrawable(r7, r6)
            r8.mIcon = r6
        L_0x0095:
            android.graphics.drawable.Drawable r6 = r8.mIcon
            if (r6 == 0) goto L_0x009c
            r1.setImageDrawable(r6)
        L_0x009c:
            android.graphics.drawable.Drawable r6 = r8.mIcon
            if (r6 == 0) goto L_0x00a4
            r1.setVisibility(r2)
            goto L_0x00ae
        L_0x00a4:
            boolean r6 = r8.mIconSpaceReserved
            if (r6 == 0) goto L_0x00aa
            r6 = r5
            goto L_0x00ab
        L_0x00aa:
            r6 = r3
        L_0x00ab:
            r1.setVisibility(r6)
        L_0x00ae:
            int r1 = androidx.preference.R.id.icon_frame
            android.view.View r1 = r9.findViewById(r1)
            if (r1 != 0) goto L_0x00bd
            r1 = 16908350(0x102003e, float:2.3877403E-38)
            android.view.View r1 = r9.findViewById(r1)
        L_0x00bd:
            if (r1 == 0) goto L_0x00cf
            android.graphics.drawable.Drawable r6 = r8.mIcon
            if (r6 == 0) goto L_0x00c7
            r1.setVisibility(r2)
            goto L_0x00cf
        L_0x00c7:
            boolean r2 = r8.mIconSpaceReserved
            if (r2 == 0) goto L_0x00cc
            r3 = r5
        L_0x00cc:
            r1.setVisibility(r3)
        L_0x00cf:
            boolean r1 = r8.mShouldDisableView
            if (r1 == 0) goto L_0x00db
            boolean r1 = r8.isEnabled()
            r8.setEnabledStateOnViews(r0, r1)
            goto L_0x00df
        L_0x00db:
            r1 = 1
            r8.setEnabledStateOnViews(r0, r1)
        L_0x00df:
            boolean r1 = r8.isSelectable()
            r0.setFocusable(r1)
            r0.setClickable(r1)
            boolean r2 = r8.mAllowDividerAbove
            r9.setDividerAllowedAbove(r2)
            boolean r2 = r8.mAllowDividerBelow
            r9.setDividerAllowedBelow(r2)
            boolean r9 = r8.isCopyingEnabled()
            if (r9 == 0) goto L_0x0104
            androidx.preference.Preference$OnPreferenceCopyListener r2 = r8.mOnCopyListener
            if (r2 != 0) goto L_0x0104
            androidx.preference.Preference$OnPreferenceCopyListener r2 = new androidx.preference.Preference$OnPreferenceCopyListener
            r2.<init>(r8)
            r8.mOnCopyListener = r2
        L_0x0104:
            if (r9 == 0) goto L_0x0109
            androidx.preference.Preference$OnPreferenceCopyListener r2 = r8.mOnCopyListener
            goto L_0x010a
        L_0x0109:
            r2 = r4
        L_0x010a:
            r0.setOnCreateContextMenuListener(r2)
            r0.setLongClickable(r9)
            if (r9 == 0) goto L_0x0117
            if (r1 != 0) goto L_0x0117
            androidx.core.view.ViewCompat.setBackground(r0, r4)
        L_0x0117:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.preference.Preference.onBindViewHolder(androidx.preference.PreferenceViewHolder):void");
    }

    public void onDependencyChanged(Preference preference, boolean z11) {
        if (this.mDependencyMet == z11) {
            this.mDependencyMet = !z11;
            notifyDependencyChange(shouldDisableDependents());
            k();
        }
    }

    public void onDetached() {
        unregisterDependency();
        this.mWasDetached = true;
    }

    @CallSuper
    @Deprecated
    public void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfoCompat accessibilityNodeInfoCompat) {
    }

    public void onParentChanged(Preference preference, boolean z11) {
        if (this.mParentDependencyMet == z11) {
            this.mParentDependencyMet = !z11;
            notifyDependencyChange(shouldDisableDependents());
            k();
        }
    }

    public Object p(TypedArray typedArray, int i11) {
        return null;
    }

    public Bundle peekExtras() {
        return this.mExtras;
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public void performClick() {
        PreferenceManager.OnPreferenceTreeClickListener onPreferenceTreeClickListener;
        if (isEnabled() && isSelectable()) {
            o();
            OnPreferenceClickListener onPreferenceClickListener = this.mOnClickListener;
            if (onPreferenceClickListener == null || !onPreferenceClickListener.onPreferenceClick(this)) {
                PreferenceManager preferenceManager = getPreferenceManager();
                if ((preferenceManager == null || (onPreferenceTreeClickListener = preferenceManager.getOnPreferenceTreeClickListener()) == null || !onPreferenceTreeClickListener.onPreferenceTreeClick(this)) && this.mIntent != null) {
                    getContext().startActivity(this.mIntent);
                }
            }
        }
    }

    public boolean persistStringSet(Set<String> set) {
        if (!B()) {
            return false;
        }
        if (set.equals(getPersistedStringSet((Set<String>) null))) {
            return true;
        }
        PreferenceDataStore preferenceDataStore = getPreferenceDataStore();
        if (preferenceDataStore != null) {
            preferenceDataStore.putStringSet(this.mKey, set);
        } else {
            SharedPreferences.Editor a11 = this.mPreferenceManager.a();
            a11.putStringSet(this.mKey, set);
            tryCommit(a11);
        }
        return true;
    }

    public void q() {
        unregisterDependency();
    }

    public void r(Parcelable parcelable) {
        this.mBaseMethodCalled = true;
        if (parcelable != AbsSavedState.EMPTY_STATE && parcelable != null) {
            throw new IllegalArgumentException("Wrong state class -- expecting Preference State");
        }
    }

    public void restoreHierarchyState(Bundle bundle) {
        c(bundle);
    }

    public Parcelable s() {
        this.mBaseMethodCalled = true;
        return AbsSavedState.EMPTY_STATE;
    }

    public void saveHierarchyState(Bundle bundle) {
        d(bundle);
    }

    public void setCopyingEnabled(boolean z11) {
        if (this.mCopyingEnabled != z11) {
            this.mCopyingEnabled = z11;
            k();
        }
    }

    public void setDefaultValue(Object obj) {
        this.mDefaultValue = obj;
    }

    public void setDependency(String str) {
        unregisterDependency();
        this.mDependencyKey = str;
        registerDependency();
    }

    public void setEnabled(boolean z11) {
        if (this.mEnabled != z11) {
            this.mEnabled = z11;
            notifyDependencyChange(shouldDisableDependents());
            k();
        }
    }

    public void setFragment(String str) {
        this.mFragment = str;
    }

    public void setIcon(Drawable drawable) {
        if (this.mIcon != drawable) {
            this.mIcon = drawable;
            this.mIconResId = 0;
            k();
        }
    }

    public void setIconSpaceReserved(boolean z11) {
        if (this.mIconSpaceReserved != z11) {
            this.mIconSpaceReserved = z11;
            k();
        }
    }

    public void setIntent(Intent intent) {
        this.mIntent = intent;
    }

    public void setKey(String str) {
        this.mKey = str;
        if (this.mRequiresKey && !hasKey()) {
            z();
        }
    }

    public void setLayoutResource(int i11) {
        this.mLayoutResId = i11;
    }

    public void setOnPreferenceChangeListener(OnPreferenceChangeListener onPreferenceChangeListener) {
        this.mOnChangeListener = onPreferenceChangeListener;
    }

    public void setOnPreferenceClickListener(OnPreferenceClickListener onPreferenceClickListener) {
        this.mOnClickListener = onPreferenceClickListener;
    }

    public void setOrder(int i11) {
        if (i11 != this.mOrder) {
            this.mOrder = i11;
            l();
        }
    }

    public void setPersistent(boolean z11) {
        this.mPersistent = z11;
    }

    public void setPreferenceDataStore(PreferenceDataStore preferenceDataStore) {
        this.mPreferenceDataStore = preferenceDataStore;
    }

    public void setSelectable(boolean z11) {
        if (this.mSelectable != z11) {
            this.mSelectable = z11;
            k();
        }
    }

    public void setShouldDisableView(boolean z11) {
        if (this.mShouldDisableView != z11) {
            this.mShouldDisableView = z11;
            k();
        }
    }

    public void setSingleLineTitle(boolean z11) {
        this.mHasSingleLineTitleAttr = true;
        this.mSingleLineTitle = z11;
    }

    public void setSummary(CharSequence charSequence) {
        if (getSummaryProvider() != null) {
            throw new IllegalStateException("Preference already has a SummaryProvider set.");
        } else if (!TextUtils.equals(this.mSummary, charSequence)) {
            this.mSummary = charSequence;
            k();
        }
    }

    public final void setSummaryProvider(@Nullable SummaryProvider summaryProvider) {
        this.mSummaryProvider = summaryProvider;
        k();
    }

    public void setTitle(CharSequence charSequence) {
        if ((charSequence == null && this.mTitle != null) || (charSequence != null && !charSequence.equals(this.mTitle))) {
            this.mTitle = charSequence;
            k();
        }
    }

    public void setViewId(int i11) {
        this.mViewId = i11;
    }

    public final void setVisible(boolean z11) {
        if (this.mVisible != z11) {
            this.mVisible = z11;
            OnPreferenceChangeInternalListener onPreferenceChangeInternalListener = this.mListener;
            if (onPreferenceChangeInternalListener != null) {
                onPreferenceChangeInternalListener.onPreferenceVisibilityChange(this);
            }
        }
    }

    public void setWidgetLayoutResource(int i11) {
        this.mWidgetLayoutResId = i11;
    }

    public boolean shouldDisableDependents() {
        return !isEnabled();
    }

    public void t(@Nullable Object obj) {
    }

    public String toString() {
        return f().toString();
    }

    @Deprecated
    public void u(boolean z11, Object obj) {
        t(obj);
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public void v(View view) {
        performClick();
    }

    public boolean w(boolean z11) {
        if (!B()) {
            return false;
        }
        if (z11 == h(!z11)) {
            return true;
        }
        PreferenceDataStore preferenceDataStore = getPreferenceDataStore();
        if (preferenceDataStore != null) {
            preferenceDataStore.putBoolean(this.mKey, z11);
        } else {
            SharedPreferences.Editor a11 = this.mPreferenceManager.a();
            a11.putBoolean(this.mKey, z11);
            tryCommit(a11);
        }
        return true;
    }

    public boolean x(int i11) {
        if (!B()) {
            return false;
        }
        if (i11 == i(~i11)) {
            return true;
        }
        PreferenceDataStore preferenceDataStore = getPreferenceDataStore();
        if (preferenceDataStore != null) {
            preferenceDataStore.putInt(this.mKey, i11);
        } else {
            SharedPreferences.Editor a11 = this.mPreferenceManager.a();
            a11.putInt(this.mKey, i11);
            tryCommit(a11);
        }
        return true;
    }

    public boolean y(String str) {
        if (!B()) {
            return false;
        }
        if (TextUtils.equals(str, j((String) null))) {
            return true;
        }
        PreferenceDataStore preferenceDataStore = getPreferenceDataStore();
        if (preferenceDataStore != null) {
            preferenceDataStore.putString(this.mKey, str);
        } else {
            SharedPreferences.Editor a11 = this.mPreferenceManager.a();
            a11.putString(this.mKey, str);
            tryCommit(a11);
        }
        return true;
    }

    public void z() {
        if (!TextUtils.isEmpty(this.mKey)) {
            this.mRequiresKey = true;
            return;
        }
        throw new IllegalStateException("Preference does not have a key assigned.");
    }

    public int compareTo(@NonNull Preference preference) {
        int i11 = this.mOrder;
        int i12 = preference.mOrder;
        if (i11 != i12) {
            return i11 - i12;
        }
        CharSequence charSequence = this.mTitle;
        CharSequence charSequence2 = preference.mTitle;
        if (charSequence == charSequence2) {
            return 0;
        }
        if (charSequence == null) {
            return 1;
        }
        if (charSequence2 == null) {
            return -1;
        }
        return charSequence.toString().compareToIgnoreCase(preference.mTitle.toString());
    }

    public void setTitle(int i11) {
        setTitle((CharSequence) this.mContext.getString(i11));
    }

    public void setIcon(int i11) {
        setIcon(AppCompatResources.getDrawable(this.mContext, i11));
        this.mIconResId = i11;
    }

    public void setSummary(int i11) {
        setSummary((CharSequence) this.mContext.getString(i11));
    }

    public Preference(Context context, AttributeSet attributeSet, int i11) {
        this(context, attributeSet, i11, 0);
    }

    public Preference(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, TypedArrayUtils.getAttr(context, R.attr.preferenceStyle, 16842894));
    }

    public Preference(Context context) {
        this(context, (AttributeSet) null);
    }
}
