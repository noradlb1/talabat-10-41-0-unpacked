package androidx.preference;

import android.app.DialogFragment;
import android.app.Fragment;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.ContextThemeWrapper;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
import androidx.annotation.XmlRes;
import androidx.core.content.res.TypedArrayUtils;
import androidx.preference.DialogPreference;
import androidx.preference.PreferenceGroup;
import androidx.preference.PreferenceManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

@Deprecated
public abstract class PreferenceFragment extends Fragment implements PreferenceManager.OnPreferenceTreeClickListener, PreferenceManager.OnDisplayPreferenceDialogListener, PreferenceManager.OnNavigateToScreenListener, DialogPreference.TargetFragment {
    @Deprecated
    public static final String ARG_PREFERENCE_ROOT = "androidx.preference.PreferenceFragmentCompat.PREFERENCE_ROOT";
    private static final String DIALOG_FRAGMENT_TAG = "androidx.preference.PreferenceFragment.DIALOG";
    private static final int MSG_BIND_PREFERENCES = 1;
    private static final String PREFERENCES_TAG = "android:preferences";

    /* renamed from: b  reason: collision with root package name */
    public RecyclerView f37300b;
    private final DividerDecoration mDividerDecoration = new DividerDecoration();
    private final Handler mHandler = new Handler() {
        public void handleMessage(Message message) {
            if (message.what == 1) {
                PreferenceFragment.this.a();
            }
        }
    };
    private boolean mHavePrefs;
    private boolean mInitDone;
    private int mLayoutResId = R.layout.preference_list_fragment;
    private PreferenceManager mPreferenceManager;
    private final Runnable mRequestFocus = new Runnable() {
        public void run() {
            RecyclerView recyclerView = PreferenceFragment.this.f37300b;
            recyclerView.focusableViewAvailable(recyclerView);
        }
    };
    private Runnable mSelectPreferenceRunnable;
    private Context mStyledContext;

    public class DividerDecoration extends RecyclerView.ItemDecoration {
        private boolean mAllowDividerAfterLastItem = true;
        private Drawable mDivider;
        private int mDividerHeight;

        public DividerDecoration() {
        }

        private boolean shouldDrawDividerBelow(View view, RecyclerView recyclerView) {
            boolean z11;
            RecyclerView.ViewHolder childViewHolder = recyclerView.getChildViewHolder(view);
            boolean z12 = false;
            if (!(childViewHolder instanceof PreferenceViewHolder) || !((PreferenceViewHolder) childViewHolder).isDividerAllowedBelow()) {
                z11 = false;
            } else {
                z11 = true;
            }
            if (!z11) {
                return false;
            }
            boolean z13 = this.mAllowDividerAfterLastItem;
            int indexOfChild = recyclerView.indexOfChild(view);
            if (indexOfChild >= recyclerView.getChildCount() - 1) {
                return z13;
            }
            RecyclerView.ViewHolder childViewHolder2 = recyclerView.getChildViewHolder(recyclerView.getChildAt(indexOfChild + 1));
            if ((childViewHolder2 instanceof PreferenceViewHolder) && ((PreferenceViewHolder) childViewHolder2).isDividerAllowedAbove()) {
                z12 = true;
            }
            return z12;
        }

        public void getItemOffsets(Rect rect, View view, RecyclerView recyclerView, RecyclerView.State state) {
            if (shouldDrawDividerBelow(view, recyclerView)) {
                rect.bottom = this.mDividerHeight;
            }
        }

        public void onDrawOver(Canvas canvas, RecyclerView recyclerView, RecyclerView.State state) {
            if (this.mDivider != null) {
                int childCount = recyclerView.getChildCount();
                int width = recyclerView.getWidth();
                for (int i11 = 0; i11 < childCount; i11++) {
                    View childAt = recyclerView.getChildAt(i11);
                    if (shouldDrawDividerBelow(childAt, recyclerView)) {
                        int y11 = ((int) childAt.getY()) + childAt.getHeight();
                        this.mDivider.setBounds(0, y11, width, this.mDividerHeight + y11);
                        this.mDivider.draw(canvas);
                    }
                }
            }
        }

        public void setAllowDividerAfterLastItem(boolean z11) {
            this.mAllowDividerAfterLastItem = z11;
        }

        public void setDivider(Drawable drawable) {
            if (drawable != null) {
                this.mDividerHeight = drawable.getIntrinsicHeight();
            } else {
                this.mDividerHeight = 0;
            }
            this.mDivider = drawable;
            PreferenceFragment.this.f37300b.invalidateItemDecorations();
        }

        public void setDividerHeight(int i11) {
            this.mDividerHeight = i11;
            PreferenceFragment.this.f37300b.invalidateItemDecorations();
        }
    }

    public interface OnPreferenceDisplayDialogCallback {
        boolean onPreferenceDisplayDialog(@NonNull PreferenceFragment preferenceFragment, Preference preference);
    }

    public interface OnPreferenceStartFragmentCallback {
        boolean onPreferenceStartFragment(PreferenceFragment preferenceFragment, Preference preference);
    }

    public interface OnPreferenceStartScreenCallback {
        boolean onPreferenceStartScreen(PreferenceFragment preferenceFragment, PreferenceScreen preferenceScreen);
    }

    public static class ScrollToPreferenceObserver extends RecyclerView.AdapterDataObserver {
        private final RecyclerView.Adapter mAdapter;
        private final String mKey;
        private final RecyclerView mList;
        private final Preference mPreference;

        public ScrollToPreferenceObserver(RecyclerView.Adapter adapter, RecyclerView recyclerView, Preference preference, String str) {
            this.mAdapter = adapter;
            this.mList = recyclerView;
            this.mPreference = preference;
            this.mKey = str;
        }

        private void scrollToPreference() {
            int i11;
            this.mAdapter.unregisterAdapterDataObserver(this);
            Preference preference = this.mPreference;
            if (preference != null) {
                i11 = ((PreferenceGroup.PreferencePositionCallback) this.mAdapter).getPreferenceAdapterPosition(preference);
            } else {
                i11 = ((PreferenceGroup.PreferencePositionCallback) this.mAdapter).getPreferenceAdapterPosition(this.mKey);
            }
            if (i11 != -1) {
                this.mList.scrollToPosition(i11);
            }
        }

        public void onChanged() {
            scrollToPreference();
        }

        public void onItemRangeChanged(int i11, int i12) {
            scrollToPreference();
        }

        public void onItemRangeInserted(int i11, int i12) {
            scrollToPreference();
        }

        public void onItemRangeMoved(int i11, int i12, int i13) {
            scrollToPreference();
        }

        public void onItemRangeRemoved(int i11, int i12) {
            scrollToPreference();
        }

        public void onItemRangeChanged(int i11, int i12, Object obj) {
            scrollToPreference();
        }
    }

    private void postBindPreferences() {
        if (!this.mHandler.hasMessages(1)) {
            this.mHandler.obtainMessage(1).sendToTarget();
        }
    }

    private void requirePreferenceManager() {
        if (this.mPreferenceManager == null) {
            throw new RuntimeException("This should be called after super.onCreate.");
        }
    }

    private void scrollToPreferenceInternal(final Preference preference, final String str) {
        AnonymousClass3 r02 = new Runnable() {
            public void run() {
                int i11;
                RecyclerView.Adapter adapter = PreferenceFragment.this.f37300b.getAdapter();
                if (adapter instanceof PreferenceGroup.PreferencePositionCallback) {
                    Preference preference = preference;
                    if (preference != null) {
                        i11 = ((PreferenceGroup.PreferencePositionCallback) adapter).getPreferenceAdapterPosition(preference);
                    } else {
                        i11 = ((PreferenceGroup.PreferencePositionCallback) adapter).getPreferenceAdapterPosition(str);
                    }
                    if (i11 != -1) {
                        PreferenceFragment.this.f37300b.scrollToPosition(i11);
                    } else {
                        adapter.registerAdapterDataObserver(new ScrollToPreferenceObserver(adapter, PreferenceFragment.this.f37300b, preference, str));
                    }
                } else if (adapter != null) {
                    throw new IllegalStateException("Adapter must implement PreferencePositionCallback");
                }
            }
        };
        if (this.f37300b == null) {
            this.mSelectPreferenceRunnable = r02;
        } else {
            r02.run();
        }
    }

    private void unbindPreferences() {
        PreferenceScreen preferenceScreen = getPreferenceScreen();
        if (preferenceScreen != null) {
            preferenceScreen.onDetached();
        }
        d();
    }

    public void a() {
        PreferenceScreen preferenceScreen = getPreferenceScreen();
        if (preferenceScreen != null) {
            getListView().setAdapter(c(preferenceScreen));
            preferenceScreen.onAttached();
        }
        b();
    }

    @Deprecated
    public void addPreferencesFromResource(@XmlRes int i11) {
        requirePreferenceManager();
        setPreferenceScreen(this.mPreferenceManager.inflateFromResource(this.mStyledContext, i11, getPreferenceScreen()));
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public void b() {
    }

    @Deprecated
    public RecyclerView.Adapter c(PreferenceScreen preferenceScreen) {
        return new PreferenceGroupAdapter(preferenceScreen);
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public void d() {
    }

    @Deprecated
    public <T extends Preference> T findPreference(CharSequence charSequence) {
        PreferenceManager preferenceManager = this.mPreferenceManager;
        if (preferenceManager == null) {
            return null;
        }
        return preferenceManager.findPreference(charSequence);
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public Fragment getCallbackFragment() {
        return null;
    }

    @Deprecated
    public final RecyclerView getListView() {
        return this.f37300b;
    }

    @Deprecated
    public PreferenceManager getPreferenceManager() {
        return this.mPreferenceManager;
    }

    @Deprecated
    public PreferenceScreen getPreferenceScreen() {
        return this.mPreferenceManager.getPreferenceScreen();
    }

    public void onCreate(Bundle bundle) {
        String str;
        super.onCreate(bundle);
        TypedValue typedValue = new TypedValue();
        getActivity().getTheme().resolveAttribute(R.attr.preferenceTheme, typedValue, true);
        int i11 = typedValue.resourceId;
        if (i11 == 0) {
            i11 = R.style.PreferenceThemeOverlay;
        }
        ContextThemeWrapper contextThemeWrapper = new ContextThemeWrapper(getActivity(), i11);
        this.mStyledContext = contextThemeWrapper;
        PreferenceManager preferenceManager = new PreferenceManager(contextThemeWrapper);
        this.mPreferenceManager = preferenceManager;
        preferenceManager.setOnNavigateToScreenListener(this);
        if (getArguments() != null) {
            str = getArguments().getString("androidx.preference.PreferenceFragmentCompat.PREFERENCE_ROOT");
        } else {
            str = null;
        }
        onCreatePreferences(bundle, str);
    }

    @Deprecated
    public RecyclerView.LayoutManager onCreateLayoutManager() {
        return new LinearLayoutManager(getActivity());
    }

    @Deprecated
    public abstract void onCreatePreferences(Bundle bundle, String str);

    @Deprecated
    public RecyclerView onCreateRecyclerView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        RecyclerView recyclerView;
        if (this.mStyledContext.getPackageManager().hasSystemFeature("android.hardware.type.automotive") && (recyclerView = (RecyclerView) viewGroup.findViewById(R.id.recycler_view)) != null) {
            return recyclerView;
        }
        RecyclerView recyclerView2 = (RecyclerView) layoutInflater.inflate(R.layout.preference_recyclerview, viewGroup, false);
        recyclerView2.setLayoutManager(onCreateLayoutManager());
        recyclerView2.setAccessibilityDelegateCompat(new PreferenceRecyclerViewAccessibilityDelegate(recyclerView2));
        return recyclerView2;
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        Context context = this.mStyledContext;
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes((AttributeSet) null, R.styleable.PreferenceFragment, TypedArrayUtils.getAttr(context, R.attr.preferenceFragmentStyle, 16844038), 0);
        this.mLayoutResId = obtainStyledAttributes.getResourceId(R.styleable.PreferenceFragment_android_layout, this.mLayoutResId);
        Drawable drawable = obtainStyledAttributes.getDrawable(R.styleable.PreferenceFragment_android_divider);
        int dimensionPixelSize = obtainStyledAttributes.getDimensionPixelSize(R.styleable.PreferenceFragment_android_dividerHeight, -1);
        boolean z11 = obtainStyledAttributes.getBoolean(R.styleable.PreferenceFragment_allowDividerAfterLastItem, true);
        obtainStyledAttributes.recycle();
        LayoutInflater cloneInContext = layoutInflater.cloneInContext(this.mStyledContext);
        View inflate = cloneInContext.inflate(this.mLayoutResId, viewGroup, false);
        View findViewById = inflate.findViewById(16908351);
        if (findViewById instanceof ViewGroup) {
            ViewGroup viewGroup2 = (ViewGroup) findViewById;
            RecyclerView onCreateRecyclerView = onCreateRecyclerView(cloneInContext, viewGroup2, bundle);
            if (onCreateRecyclerView != null) {
                this.f37300b = onCreateRecyclerView;
                onCreateRecyclerView.addItemDecoration(this.mDividerDecoration);
                setDivider(drawable);
                if (dimensionPixelSize != -1) {
                    setDividerHeight(dimensionPixelSize);
                }
                this.mDividerDecoration.setAllowDividerAfterLastItem(z11);
                if (this.f37300b.getParent() == null) {
                    viewGroup2.addView(this.f37300b);
                }
                this.mHandler.post(this.mRequestFocus);
                return inflate;
            }
            throw new RuntimeException("Could not create RecyclerView");
        }
        throw new RuntimeException("Content has view with id attribute 'android.R.id.list_container' that is not a ViewGroup class");
    }

    public void onDestroyView() {
        this.mHandler.removeCallbacks(this.mRequestFocus);
        this.mHandler.removeMessages(1);
        if (this.mHavePrefs) {
            unbindPreferences();
        }
        this.f37300b = null;
        super.onDestroyView();
    }

    @Deprecated
    public void onDisplayPreferenceDialog(Preference preference) {
        boolean z11;
        DialogFragment dialogFragment;
        if (getCallbackFragment() instanceof OnPreferenceDisplayDialogCallback) {
            z11 = ((OnPreferenceDisplayDialogCallback) getCallbackFragment()).onPreferenceDisplayDialog(this, preference);
        } else {
            z11 = false;
        }
        if (!z11 && (getActivity() instanceof OnPreferenceDisplayDialogCallback)) {
            z11 = ((OnPreferenceDisplayDialogCallback) getActivity()).onPreferenceDisplayDialog(this, preference);
        }
        if (!z11 && getFragmentManager().findFragmentByTag(DIALOG_FRAGMENT_TAG) == null) {
            if (preference instanceof EditTextPreference) {
                dialogFragment = EditTextPreferenceDialogFragment.newInstance(preference.getKey());
            } else if (preference instanceof ListPreference) {
                dialogFragment = ListPreferenceDialogFragment.newInstance(preference.getKey());
            } else if (preference instanceof MultiSelectListPreference) {
                dialogFragment = MultiSelectListPreferenceDialogFragment.newInstance(preference.getKey());
            } else {
                throw new IllegalArgumentException("Tried to display dialog for unknown preference type. Did you forget to override onDisplayPreferenceDialog()?");
            }
            dialogFragment.setTargetFragment(this, 0);
            dialogFragment.show(getFragmentManager(), DIALOG_FRAGMENT_TAG);
        }
    }

    @Deprecated
    public void onNavigateToScreen(PreferenceScreen preferenceScreen) {
        boolean z11;
        if (getCallbackFragment() instanceof OnPreferenceStartScreenCallback) {
            z11 = ((OnPreferenceStartScreenCallback) getCallbackFragment()).onPreferenceStartScreen(this, preferenceScreen);
        } else {
            z11 = false;
        }
        if (!z11 && (getActivity() instanceof OnPreferenceStartScreenCallback)) {
            ((OnPreferenceStartScreenCallback) getActivity()).onPreferenceStartScreen(this, preferenceScreen);
        }
    }

    @Deprecated
    public boolean onPreferenceTreeClick(Preference preference) {
        boolean z11 = false;
        if (preference.getFragment() == null) {
            return false;
        }
        if (getCallbackFragment() instanceof OnPreferenceStartFragmentCallback) {
            z11 = ((OnPreferenceStartFragmentCallback) getCallbackFragment()).onPreferenceStartFragment(this, preference);
        }
        if (z11 || !(getActivity() instanceof OnPreferenceStartFragmentCallback)) {
            return z11;
        }
        return ((OnPreferenceStartFragmentCallback) getActivity()).onPreferenceStartFragment(this, preference);
    }

    public void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        PreferenceScreen preferenceScreen = getPreferenceScreen();
        if (preferenceScreen != null) {
            Bundle bundle2 = new Bundle();
            preferenceScreen.saveHierarchyState(bundle2);
            bundle.putBundle(PREFERENCES_TAG, bundle2);
        }
    }

    public void onStart() {
        super.onStart();
        this.mPreferenceManager.setOnPreferenceTreeClickListener(this);
        this.mPreferenceManager.setOnDisplayPreferenceDialogListener(this);
    }

    public void onStop() {
        super.onStop();
        this.mPreferenceManager.setOnPreferenceTreeClickListener((PreferenceManager.OnPreferenceTreeClickListener) null);
        this.mPreferenceManager.setOnDisplayPreferenceDialogListener((PreferenceManager.OnDisplayPreferenceDialogListener) null);
    }

    public void onViewCreated(View view, Bundle bundle) {
        Bundle bundle2;
        PreferenceScreen preferenceScreen;
        super.onViewCreated(view, bundle);
        if (!(bundle == null || (bundle2 = bundle.getBundle(PREFERENCES_TAG)) == null || (preferenceScreen = getPreferenceScreen()) == null)) {
            preferenceScreen.restoreHierarchyState(bundle2);
        }
        if (this.mHavePrefs) {
            a();
            Runnable runnable = this.mSelectPreferenceRunnable;
            if (runnable != null) {
                runnable.run();
                this.mSelectPreferenceRunnable = null;
            }
        }
        this.mInitDone = true;
    }

    @Deprecated
    public void scrollToPreference(String str) {
        scrollToPreferenceInternal((Preference) null, str);
    }

    @Deprecated
    public void setDivider(Drawable drawable) {
        this.mDividerDecoration.setDivider(drawable);
    }

    @Deprecated
    public void setDividerHeight(int i11) {
        this.mDividerDecoration.setDividerHeight(i11);
    }

    @Deprecated
    public void setPreferenceScreen(PreferenceScreen preferenceScreen) {
        if (this.mPreferenceManager.setPreferences(preferenceScreen) && preferenceScreen != null) {
            d();
            this.mHavePrefs = true;
            if (this.mInitDone) {
                postBindPreferences();
            }
        }
    }

    @Deprecated
    public void setPreferencesFromResource(@XmlRes int i11, @Nullable String str) {
        requirePreferenceManager();
        PreferenceScreen inflateFromResource = this.mPreferenceManager.inflateFromResource(this.mStyledContext, i11, (PreferenceScreen) null);
        Object obj = inflateFromResource;
        if (str != null) {
            Object findPreference = inflateFromResource.findPreference(str);
            boolean z11 = findPreference instanceof PreferenceScreen;
            obj = findPreference;
            if (!z11) {
                throw new IllegalArgumentException("Preference object with key " + str + " is not a PreferenceScreen");
            }
        }
        setPreferenceScreen((PreferenceScreen) obj);
    }

    @Deprecated
    public void scrollToPreference(Preference preference) {
        scrollToPreferenceInternal(preference, (String) null);
    }
}
