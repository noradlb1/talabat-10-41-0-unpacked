package androidx.preference;

import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.util.AttributeSet;
import android.util.Log;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
import androidx.annotation.XmlRes;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.preference.DialogPreference;
import androidx.preference.PreferenceGroup;
import androidx.preference.PreferenceManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

public abstract class PreferenceFragmentCompat extends Fragment implements PreferenceManager.OnPreferenceTreeClickListener, PreferenceManager.OnDisplayPreferenceDialogListener, PreferenceManager.OnNavigateToScreenListener, DialogPreference.TargetFragment {
    public static final String ARG_PREFERENCE_ROOT = "androidx.preference.PreferenceFragmentCompat.PREFERENCE_ROOT";
    private static final String DIALOG_FRAGMENT_TAG = "androidx.preference.PreferenceFragment.DIALOG";
    private static final int MSG_BIND_PREFERENCES = 1;
    private static final String PREFERENCES_TAG = "android:preferences";
    private static final String TAG = "PreferenceFragment";
    public RecyclerView C;
    private final DividerDecoration mDividerDecoration = new DividerDecoration();
    private Handler mHandler = new Handler() {
        public void handleMessage(Message message) {
            if (message.what == 1) {
                PreferenceFragmentCompat.this.i0();
            }
        }
    };
    private boolean mHavePrefs;
    private boolean mInitDone;
    private int mLayoutResId = R.layout.preference_list_fragment;
    private PreferenceManager mPreferenceManager;
    private final Runnable mRequestFocus = new Runnable() {
        public void run() {
            RecyclerView recyclerView = PreferenceFragmentCompat.this.C;
            recyclerView.focusableViewAvailable(recyclerView);
        }
    };
    private Runnable mSelectPreferenceRunnable;

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
            PreferenceFragmentCompat.this.C.invalidateItemDecorations();
        }

        public void setDividerHeight(int i11) {
            this.mDividerHeight = i11;
            PreferenceFragmentCompat.this.C.invalidateItemDecorations();
        }
    }

    public interface OnPreferenceDisplayDialogCallback {
        boolean onPreferenceDisplayDialog(@NonNull PreferenceFragmentCompat preferenceFragmentCompat, Preference preference);
    }

    public interface OnPreferenceStartFragmentCallback {
        boolean onPreferenceStartFragment(PreferenceFragmentCompat preferenceFragmentCompat, Preference preference);
    }

    public interface OnPreferenceStartScreenCallback {
        boolean onPreferenceStartScreen(PreferenceFragmentCompat preferenceFragmentCompat, PreferenceScreen preferenceScreen);
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
                RecyclerView.Adapter adapter = PreferenceFragmentCompat.this.C.getAdapter();
                if (adapter instanceof PreferenceGroup.PreferencePositionCallback) {
                    Preference preference = preference;
                    if (preference != null) {
                        i11 = ((PreferenceGroup.PreferencePositionCallback) adapter).getPreferenceAdapterPosition(preference);
                    } else {
                        i11 = ((PreferenceGroup.PreferencePositionCallback) adapter).getPreferenceAdapterPosition(str);
                    }
                    if (i11 != -1) {
                        PreferenceFragmentCompat.this.C.scrollToPosition(i11);
                    } else {
                        adapter.registerAdapterDataObserver(new ScrollToPreferenceObserver(adapter, PreferenceFragmentCompat.this.C, preference, str));
                    }
                } else if (adapter != null) {
                    throw new IllegalStateException("Adapter must implement PreferencePositionCallback");
                }
            }
        };
        if (this.C == null) {
            this.mSelectPreferenceRunnable = r02;
        } else {
            r02.run();
        }
    }

    private void unbindPreferences() {
        getListView().setAdapter((RecyclerView.Adapter) null);
        PreferenceScreen preferenceScreen = getPreferenceScreen();
        if (preferenceScreen != null) {
            preferenceScreen.onDetached();
        }
        l0();
    }

    public void addPreferencesFromResource(@XmlRes int i11) {
        requirePreferenceManager();
        setPreferenceScreen(this.mPreferenceManager.inflateFromResource(getContext(), i11, getPreferenceScreen()));
    }

    @Nullable
    public <T extends Preference> T findPreference(@NonNull CharSequence charSequence) {
        PreferenceManager preferenceManager = this.mPreferenceManager;
        if (preferenceManager == null) {
            return null;
        }
        return preferenceManager.findPreference(charSequence);
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public Fragment getCallbackFragment() {
        return null;
    }

    public final RecyclerView getListView() {
        return this.C;
    }

    public PreferenceManager getPreferenceManager() {
        return this.mPreferenceManager;
    }

    public PreferenceScreen getPreferenceScreen() {
        return this.mPreferenceManager.getPreferenceScreen();
    }

    public void i0() {
        PreferenceScreen preferenceScreen = getPreferenceScreen();
        if (preferenceScreen != null) {
            getListView().setAdapter(k0(preferenceScreen));
            preferenceScreen.onAttached();
        }
        j0();
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public void j0() {
    }

    public RecyclerView.Adapter k0(PreferenceScreen preferenceScreen) {
        return new PreferenceGroupAdapter(preferenceScreen);
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public void l0() {
    }

    public void onCreate(@Nullable Bundle bundle) {
        String str;
        super.onCreate(bundle);
        TypedValue typedValue = new TypedValue();
        getActivity().getTheme().resolveAttribute(R.attr.preferenceTheme, typedValue, true);
        int i11 = typedValue.resourceId;
        if (i11 == 0) {
            i11 = R.style.PreferenceThemeOverlay;
        }
        getActivity().getTheme().applyStyle(i11, false);
        PreferenceManager preferenceManager = new PreferenceManager(getContext());
        this.mPreferenceManager = preferenceManager;
        preferenceManager.setOnNavigateToScreenListener(this);
        if (getArguments() != null) {
            str = getArguments().getString("androidx.preference.PreferenceFragmentCompat.PREFERENCE_ROOT");
        } else {
            str = null;
        }
        onCreatePreferences(bundle, str);
    }

    public RecyclerView.LayoutManager onCreateLayoutManager() {
        return new LinearLayoutManager(getContext());
    }

    public abstract void onCreatePreferences(Bundle bundle, String str);

    public RecyclerView onCreateRecyclerView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        RecyclerView recyclerView;
        if (getContext().getPackageManager().hasSystemFeature("android.hardware.type.automotive") && (recyclerView = (RecyclerView) viewGroup.findViewById(R.id.recycler_view)) != null) {
            return recyclerView;
        }
        RecyclerView recyclerView2 = (RecyclerView) layoutInflater.inflate(R.layout.preference_recyclerview, viewGroup, false);
        recyclerView2.setLayoutManager(onCreateLayoutManager());
        recyclerView2.setAccessibilityDelegateCompat(new PreferenceRecyclerViewAccessibilityDelegate(recyclerView2));
        return recyclerView2;
    }

    public View onCreateView(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, @Nullable Bundle bundle) {
        TypedArray obtainStyledAttributes = getContext().obtainStyledAttributes((AttributeSet) null, R.styleable.PreferenceFragmentCompat, R.attr.preferenceFragmentCompatStyle, 0);
        this.mLayoutResId = obtainStyledAttributes.getResourceId(R.styleable.PreferenceFragmentCompat_android_layout, this.mLayoutResId);
        Drawable drawable = obtainStyledAttributes.getDrawable(R.styleable.PreferenceFragmentCompat_android_divider);
        int dimensionPixelSize = obtainStyledAttributes.getDimensionPixelSize(R.styleable.PreferenceFragmentCompat_android_dividerHeight, -1);
        boolean z11 = obtainStyledAttributes.getBoolean(R.styleable.PreferenceFragmentCompat_allowDividerAfterLastItem, true);
        obtainStyledAttributes.recycle();
        LayoutInflater cloneInContext = layoutInflater.cloneInContext(getContext());
        View inflate = cloneInContext.inflate(this.mLayoutResId, viewGroup, false);
        View findViewById = inflate.findViewById(16908351);
        if (findViewById instanceof ViewGroup) {
            ViewGroup viewGroup2 = (ViewGroup) findViewById;
            RecyclerView onCreateRecyclerView = onCreateRecyclerView(cloneInContext, viewGroup2, bundle);
            if (onCreateRecyclerView != null) {
                this.C = onCreateRecyclerView;
                onCreateRecyclerView.addItemDecoration(this.mDividerDecoration);
                setDivider(drawable);
                if (dimensionPixelSize != -1) {
                    setDividerHeight(dimensionPixelSize);
                }
                this.mDividerDecoration.setAllowDividerAfterLastItem(z11);
                if (this.C.getParent() == null) {
                    viewGroup2.addView(this.C);
                }
                this.mHandler.post(this.mRequestFocus);
                return inflate;
            }
            throw new RuntimeException("Could not create RecyclerView");
        }
        throw new IllegalStateException("Content has view with id attribute 'android.R.id.list_container' that is not a ViewGroup class");
    }

    public void onDestroyView() {
        this.mHandler.removeCallbacks(this.mRequestFocus);
        this.mHandler.removeMessages(1);
        if (this.mHavePrefs) {
            unbindPreferences();
        }
        this.C = null;
        super.onDestroyView();
    }

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
        if (!z11 && getParentFragmentManager().findFragmentByTag(DIALOG_FRAGMENT_TAG) == null) {
            if (preference instanceof EditTextPreference) {
                dialogFragment = EditTextPreferenceDialogFragmentCompat.newInstance(preference.getKey());
            } else if (preference instanceof ListPreference) {
                dialogFragment = ListPreferenceDialogFragmentCompat.newInstance(preference.getKey());
            } else if (preference instanceof MultiSelectListPreference) {
                dialogFragment = MultiSelectListPreferenceDialogFragmentCompat.newInstance(preference.getKey());
            } else {
                throw new IllegalArgumentException("Cannot display dialog for an unknown Preference type: " + preference.getClass().getSimpleName() + ". Make sure to implement onPreferenceDisplayDialog() to handle displaying a custom dialog for this Preference.");
            }
            dialogFragment.setTargetFragment(this, 0);
            dialogFragment.show(getParentFragmentManager(), DIALOG_FRAGMENT_TAG);
        }
    }

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

    public boolean onPreferenceTreeClick(Preference preference) {
        boolean z11;
        if (preference.getFragment() == null) {
            return false;
        }
        if (getCallbackFragment() instanceof OnPreferenceStartFragmentCallback) {
            z11 = ((OnPreferenceStartFragmentCallback) getCallbackFragment()).onPreferenceStartFragment(this, preference);
        } else {
            z11 = false;
        }
        if (!z11 && (getActivity() instanceof OnPreferenceStartFragmentCallback)) {
            z11 = ((OnPreferenceStartFragmentCallback) getActivity()).onPreferenceStartFragment(this, preference);
        }
        if (z11) {
            return true;
        }
        Log.w(TAG, "onPreferenceStartFragment is not implemented in the parent activity - attempting to use a fallback implementation. You should implement this method so that you can configure the new fragment that will be displayed, and set a transition between the fragments.");
        FragmentManager supportFragmentManager = requireActivity().getSupportFragmentManager();
        Bundle extras = preference.getExtras();
        Fragment instantiate = supportFragmentManager.getFragmentFactory().instantiate(requireActivity().getClassLoader(), preference.getFragment());
        instantiate.setArguments(extras);
        instantiate.setTargetFragment(this, 0);
        supportFragmentManager.beginTransaction().replace(((View) getView().getParent()).getId(), instantiate).addToBackStack((String) null).commit();
        return true;
    }

    public void onSaveInstanceState(@NonNull Bundle bundle) {
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

    public void onViewCreated(@NonNull View view, @Nullable Bundle bundle) {
        Bundle bundle2;
        PreferenceScreen preferenceScreen;
        super.onViewCreated(view, bundle);
        if (!(bundle == null || (bundle2 = bundle.getBundle(PREFERENCES_TAG)) == null || (preferenceScreen = getPreferenceScreen()) == null)) {
            preferenceScreen.restoreHierarchyState(bundle2);
        }
        if (this.mHavePrefs) {
            i0();
            Runnable runnable = this.mSelectPreferenceRunnable;
            if (runnable != null) {
                runnable.run();
                this.mSelectPreferenceRunnable = null;
            }
        }
        this.mInitDone = true;
    }

    public void scrollToPreference(String str) {
        scrollToPreferenceInternal((Preference) null, str);
    }

    public void setDivider(Drawable drawable) {
        this.mDividerDecoration.setDivider(drawable);
    }

    public void setDividerHeight(int i11) {
        this.mDividerDecoration.setDividerHeight(i11);
    }

    public void setPreferenceScreen(PreferenceScreen preferenceScreen) {
        if (this.mPreferenceManager.setPreferences(preferenceScreen) && preferenceScreen != null) {
            l0();
            this.mHavePrefs = true;
            if (this.mInitDone) {
                postBindPreferences();
            }
        }
    }

    public void setPreferencesFromResource(@XmlRes int i11, @Nullable String str) {
        requirePreferenceManager();
        PreferenceScreen inflateFromResource = this.mPreferenceManager.inflateFromResource(getContext(), i11, (PreferenceScreen) null);
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

    public void scrollToPreference(Preference preference) {
        scrollToPreferenceInternal(preference, (String) null);
    }
}
