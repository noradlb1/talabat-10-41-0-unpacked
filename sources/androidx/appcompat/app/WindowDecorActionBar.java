package androidx.appcompat.app;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.res.Configuration;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.ContextThemeWrapper;
import android.view.KeyCharacterMap;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.Interpolator;
import android.widget.SpinnerAdapter;
import androidx.annotation.NonNull;
import androidx.annotation.RestrictTo;
import androidx.appcompat.R;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.content.res.AppCompatResources;
import androidx.appcompat.view.ActionBarPolicy;
import androidx.appcompat.view.ActionMode;
import androidx.appcompat.view.SupportMenuInflater;
import androidx.appcompat.view.ViewPropertyAnimatorCompatSet;
import androidx.appcompat.view.menu.MenuBuilder;
import androidx.appcompat.view.menu.MenuPopupHelper;
import androidx.appcompat.view.menu.SubMenuBuilder;
import androidx.appcompat.widget.ActionBarContainer;
import androidx.appcompat.widget.ActionBarContextView;
import androidx.appcompat.widget.ActionBarOverlayLayout;
import androidx.appcompat.widget.DecorToolbar;
import androidx.appcompat.widget.ScrollingTabContainerView;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.ViewCompat;
import androidx.core.view.ViewPropertyAnimatorCompat;
import androidx.core.view.ViewPropertyAnimatorListener;
import androidx.core.view.ViewPropertyAnimatorListenerAdapter;
import androidx.core.view.ViewPropertyAnimatorUpdateListener;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentTransaction;
import java.lang.ref.WeakReference;
import java.util.ArrayList;

@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
public class WindowDecorActionBar extends ActionBar implements ActionBarOverlayLayout.ActionBarVisibilityCallback {
    private static final long FADE_IN_DURATION_MS = 200;
    private static final long FADE_OUT_DURATION_MS = 100;
    private static final int INVALID_POSITION = -1;
    private static final String TAG = "WindowDecorActionBar";
    private static final Interpolator sHideInterpolator = new AccelerateInterpolator();
    private static final Interpolator sShowInterpolator = new DecelerateInterpolator();

    /* renamed from: a  reason: collision with root package name */
    public Context f617a;

    /* renamed from: b  reason: collision with root package name */
    public ActionBarOverlayLayout f618b;

    /* renamed from: c  reason: collision with root package name */
    public ActionBarContainer f619c;

    /* renamed from: d  reason: collision with root package name */
    public DecorToolbar f620d;

    /* renamed from: e  reason: collision with root package name */
    public ActionBarContextView f621e;

    /* renamed from: f  reason: collision with root package name */
    public View f622f;

    /* renamed from: g  reason: collision with root package name */
    public ScrollingTabContainerView f623g;

    /* renamed from: h  reason: collision with root package name */
    public ActionModeImpl f624h;

    /* renamed from: i  reason: collision with root package name */
    public ActionMode f625i;

    /* renamed from: j  reason: collision with root package name */
    public ActionMode.Callback f626j;

    /* renamed from: k  reason: collision with root package name */
    public boolean f627k = true;

    /* renamed from: l  reason: collision with root package name */
    public boolean f628l;

    /* renamed from: m  reason: collision with root package name */
    public boolean f629m;
    private Activity mActivity;
    private int mCurWindowVisibility = 0;
    private boolean mDisplayHomeAsUpSet;
    private boolean mHasEmbeddedTabs;
    private boolean mLastMenuVisibility;
    private ArrayList<ActionBar.OnMenuVisibilityListener> mMenuVisibilityListeners = new ArrayList<>();
    private boolean mNowShowing = true;
    private int mSavedTabPosition = -1;
    private TabImpl mSelectedTab;
    private boolean mShowHideAnimationEnabled;
    private boolean mShowingForMode;
    private ArrayList<TabImpl> mTabs = new ArrayList<>();
    private Context mThemedContext;

    /* renamed from: n  reason: collision with root package name */
    public ViewPropertyAnimatorCompatSet f630n;

    /* renamed from: o  reason: collision with root package name */
    public boolean f631o;

    /* renamed from: p  reason: collision with root package name */
    public final ViewPropertyAnimatorListener f632p = new ViewPropertyAnimatorListenerAdapter() {
        public void onAnimationEnd(View view) {
            View view2;
            WindowDecorActionBar windowDecorActionBar = WindowDecorActionBar.this;
            if (windowDecorActionBar.f627k && (view2 = windowDecorActionBar.f622f) != null) {
                view2.setTranslationY(0.0f);
                WindowDecorActionBar.this.f619c.setTranslationY(0.0f);
            }
            WindowDecorActionBar.this.f619c.setVisibility(8);
            WindowDecorActionBar.this.f619c.setTransitioning(false);
            WindowDecorActionBar windowDecorActionBar2 = WindowDecorActionBar.this;
            windowDecorActionBar2.f630n = null;
            windowDecorActionBar2.c();
            ActionBarOverlayLayout actionBarOverlayLayout = WindowDecorActionBar.this.f618b;
            if (actionBarOverlayLayout != null) {
                ViewCompat.requestApplyInsets(actionBarOverlayLayout);
            }
        }
    };

    /* renamed from: q  reason: collision with root package name */
    public final ViewPropertyAnimatorListener f633q = new ViewPropertyAnimatorListenerAdapter() {
        public void onAnimationEnd(View view) {
            WindowDecorActionBar windowDecorActionBar = WindowDecorActionBar.this;
            windowDecorActionBar.f630n = null;
            windowDecorActionBar.f619c.requestLayout();
        }
    };

    /* renamed from: r  reason: collision with root package name */
    public final ViewPropertyAnimatorUpdateListener f634r = new ViewPropertyAnimatorUpdateListener() {
        public void onAnimationUpdate(View view) {
            ((View) WindowDecorActionBar.this.f619c.getParent()).invalidate();
        }
    };

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public class ActionModeImpl extends ActionMode implements MenuBuilder.Callback {
        private final Context mActionModeContext;
        private ActionMode.Callback mCallback;
        private WeakReference<View> mCustomView;
        private final MenuBuilder mMenu;

        public ActionModeImpl(Context context, ActionMode.Callback callback) {
            this.mActionModeContext = context;
            this.mCallback = callback;
            MenuBuilder defaultShowAsAction = new MenuBuilder(context).setDefaultShowAsAction(1);
            this.mMenu = defaultShowAsAction;
            defaultShowAsAction.setCallback(this);
        }

        public boolean dispatchOnCreate() {
            this.mMenu.stopDispatchingItemsChanged();
            try {
                return this.mCallback.onCreateActionMode(this, this.mMenu);
            } finally {
                this.mMenu.startDispatchingItemsChanged();
            }
        }

        public void finish() {
            WindowDecorActionBar windowDecorActionBar = WindowDecorActionBar.this;
            if (windowDecorActionBar.f624h == this) {
                if (!WindowDecorActionBar.b(windowDecorActionBar.f628l, windowDecorActionBar.f629m, false)) {
                    WindowDecorActionBar windowDecorActionBar2 = WindowDecorActionBar.this;
                    windowDecorActionBar2.f625i = this;
                    windowDecorActionBar2.f626j = this.mCallback;
                } else {
                    this.mCallback.onDestroyActionMode(this);
                }
                this.mCallback = null;
                WindowDecorActionBar.this.animateToMode(false);
                WindowDecorActionBar.this.f621e.closeMode();
                WindowDecorActionBar windowDecorActionBar3 = WindowDecorActionBar.this;
                windowDecorActionBar3.f618b.setHideOnContentScrollEnabled(windowDecorActionBar3.f631o);
                WindowDecorActionBar.this.f624h = null;
            }
        }

        public View getCustomView() {
            WeakReference<View> weakReference = this.mCustomView;
            if (weakReference != null) {
                return weakReference.get();
            }
            return null;
        }

        public Menu getMenu() {
            return this.mMenu;
        }

        public MenuInflater getMenuInflater() {
            return new SupportMenuInflater(this.mActionModeContext);
        }

        public CharSequence getSubtitle() {
            return WindowDecorActionBar.this.f621e.getSubtitle();
        }

        public CharSequence getTitle() {
            return WindowDecorActionBar.this.f621e.getTitle();
        }

        public void invalidate() {
            if (WindowDecorActionBar.this.f624h == this) {
                this.mMenu.stopDispatchingItemsChanged();
                try {
                    this.mCallback.onPrepareActionMode(this, this.mMenu);
                } finally {
                    this.mMenu.startDispatchingItemsChanged();
                }
            }
        }

        public boolean isTitleOptional() {
            return WindowDecorActionBar.this.f621e.isTitleOptional();
        }

        public void onCloseMenu(MenuBuilder menuBuilder, boolean z11) {
        }

        public void onCloseSubMenu(SubMenuBuilder subMenuBuilder) {
        }

        public boolean onMenuItemSelected(@NonNull MenuBuilder menuBuilder, @NonNull MenuItem menuItem) {
            ActionMode.Callback callback = this.mCallback;
            if (callback != null) {
                return callback.onActionItemClicked(this, menuItem);
            }
            return false;
        }

        public void onMenuModeChange(@NonNull MenuBuilder menuBuilder) {
            if (this.mCallback != null) {
                invalidate();
                WindowDecorActionBar.this.f621e.showOverflowMenu();
            }
        }

        public boolean onSubMenuSelected(SubMenuBuilder subMenuBuilder) {
            if (this.mCallback == null) {
                return false;
            }
            if (!subMenuBuilder.hasVisibleItems()) {
                return true;
            }
            new MenuPopupHelper(WindowDecorActionBar.this.getThemedContext(), subMenuBuilder).show();
            return true;
        }

        public void setCustomView(View view) {
            WindowDecorActionBar.this.f621e.setCustomView(view);
            this.mCustomView = new WeakReference<>(view);
        }

        public void setSubtitle(CharSequence charSequence) {
            WindowDecorActionBar.this.f621e.setSubtitle(charSequence);
        }

        public void setTitle(CharSequence charSequence) {
            WindowDecorActionBar.this.f621e.setTitle(charSequence);
        }

        public void setTitleOptionalHint(boolean z11) {
            super.setTitleOptionalHint(z11);
            WindowDecorActionBar.this.f621e.setTitleOptional(z11);
        }

        public void setSubtitle(int i11) {
            setSubtitle((CharSequence) WindowDecorActionBar.this.f617a.getResources().getString(i11));
        }

        public void setTitle(int i11) {
            setTitle((CharSequence) WindowDecorActionBar.this.f617a.getResources().getString(i11));
        }
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public class TabImpl extends ActionBar.Tab {
        private ActionBar.TabListener mCallback;
        private CharSequence mContentDesc;
        private View mCustomView;
        private Drawable mIcon;
        private int mPosition = -1;
        private Object mTag;
        private CharSequence mText;

        public TabImpl() {
        }

        public ActionBar.TabListener getCallback() {
            return this.mCallback;
        }

        public CharSequence getContentDescription() {
            return this.mContentDesc;
        }

        public View getCustomView() {
            return this.mCustomView;
        }

        public Drawable getIcon() {
            return this.mIcon;
        }

        public int getPosition() {
            return this.mPosition;
        }

        public Object getTag() {
            return this.mTag;
        }

        public CharSequence getText() {
            return this.mText;
        }

        public void select() {
            WindowDecorActionBar.this.selectTab(this);
        }

        public ActionBar.Tab setContentDescription(int i11) {
            return setContentDescription(WindowDecorActionBar.this.f617a.getResources().getText(i11));
        }

        public ActionBar.Tab setCustomView(View view) {
            this.mCustomView = view;
            int i11 = this.mPosition;
            if (i11 >= 0) {
                WindowDecorActionBar.this.f623g.updateTab(i11);
            }
            return this;
        }

        public ActionBar.Tab setIcon(Drawable drawable) {
            this.mIcon = drawable;
            int i11 = this.mPosition;
            if (i11 >= 0) {
                WindowDecorActionBar.this.f623g.updateTab(i11);
            }
            return this;
        }

        public void setPosition(int i11) {
            this.mPosition = i11;
        }

        public ActionBar.Tab setTabListener(ActionBar.TabListener tabListener) {
            this.mCallback = tabListener;
            return this;
        }

        public ActionBar.Tab setTag(Object obj) {
            this.mTag = obj;
            return this;
        }

        public ActionBar.Tab setText(CharSequence charSequence) {
            this.mText = charSequence;
            int i11 = this.mPosition;
            if (i11 >= 0) {
                WindowDecorActionBar.this.f623g.updateTab(i11);
            }
            return this;
        }

        public ActionBar.Tab setContentDescription(CharSequence charSequence) {
            this.mContentDesc = charSequence;
            int i11 = this.mPosition;
            if (i11 >= 0) {
                WindowDecorActionBar.this.f623g.updateTab(i11);
            }
            return this;
        }

        public ActionBar.Tab setCustomView(int i11) {
            return setCustomView(LayoutInflater.from(WindowDecorActionBar.this.getThemedContext()).inflate(i11, (ViewGroup) null));
        }

        public ActionBar.Tab setIcon(int i11) {
            return setIcon(AppCompatResources.getDrawable(WindowDecorActionBar.this.f617a, i11));
        }

        public ActionBar.Tab setText(int i11) {
            return setText(WindowDecorActionBar.this.f617a.getResources().getText(i11));
        }
    }

    public WindowDecorActionBar(Activity activity, boolean z11) {
        this.mActivity = activity;
        View decorView = activity.getWindow().getDecorView();
        init(decorView);
        if (!z11) {
            this.f622f = decorView.findViewById(16908290);
        }
    }

    public static boolean b(boolean z11, boolean z12, boolean z13) {
        if (z13) {
            return true;
        }
        return !z11 && !z12;
    }

    private void cleanupTabs() {
        if (this.mSelectedTab != null) {
            selectTab((ActionBar.Tab) null);
        }
        this.mTabs.clear();
        ScrollingTabContainerView scrollingTabContainerView = this.f623g;
        if (scrollingTabContainerView != null) {
            scrollingTabContainerView.removeAllTabs();
        }
        this.mSavedTabPosition = -1;
    }

    private void configureTab(ActionBar.Tab tab, int i11) {
        TabImpl tabImpl = (TabImpl) tab;
        if (tabImpl.getCallback() != null) {
            tabImpl.setPosition(i11);
            this.mTabs.add(i11, tabImpl);
            int size = this.mTabs.size();
            while (true) {
                i11++;
                if (i11 < size) {
                    this.mTabs.get(i11).setPosition(i11);
                } else {
                    return;
                }
            }
        } else {
            throw new IllegalStateException("Action Bar Tab must have a Callback");
        }
    }

    private void ensureTabsExist() {
        if (this.f623g == null) {
            ScrollingTabContainerView scrollingTabContainerView = new ScrollingTabContainerView(this.f617a);
            if (this.mHasEmbeddedTabs) {
                scrollingTabContainerView.setVisibility(0);
                this.f620d.setEmbeddedTabView(scrollingTabContainerView);
            } else {
                if (getNavigationMode() == 2) {
                    scrollingTabContainerView.setVisibility(0);
                    ActionBarOverlayLayout actionBarOverlayLayout = this.f618b;
                    if (actionBarOverlayLayout != null) {
                        ViewCompat.requestApplyInsets(actionBarOverlayLayout);
                    }
                } else {
                    scrollingTabContainerView.setVisibility(8);
                }
                this.f619c.setTabContainer(scrollingTabContainerView);
            }
            this.f623g = scrollingTabContainerView;
        }
    }

    private DecorToolbar getDecorToolbar(View view) {
        String str;
        if (view instanceof DecorToolbar) {
            return (DecorToolbar) view;
        }
        if (view instanceof Toolbar) {
            return ((Toolbar) view).getWrapper();
        }
        StringBuilder sb2 = new StringBuilder();
        sb2.append("Can't make a decor toolbar out of ");
        if (view != null) {
            str = view.getClass().getSimpleName();
        } else {
            str = "null";
        }
        sb2.append(str);
        throw new IllegalStateException(sb2.toString());
    }

    private void hideForActionMode() {
        if (this.mShowingForMode) {
            this.mShowingForMode = false;
            ActionBarOverlayLayout actionBarOverlayLayout = this.f618b;
            if (actionBarOverlayLayout != null) {
                actionBarOverlayLayout.setShowingForActionMode(false);
            }
            updateVisibility(false);
        }
    }

    private void init(View view) {
        boolean z11;
        boolean z12;
        ActionBarOverlayLayout actionBarOverlayLayout = (ActionBarOverlayLayout) view.findViewById(R.id.decor_content_parent);
        this.f618b = actionBarOverlayLayout;
        if (actionBarOverlayLayout != null) {
            actionBarOverlayLayout.setActionBarVisibilityCallback(this);
        }
        this.f620d = getDecorToolbar(view.findViewById(R.id.action_bar));
        this.f621e = (ActionBarContextView) view.findViewById(R.id.action_context_bar);
        ActionBarContainer actionBarContainer = (ActionBarContainer) view.findViewById(R.id.action_bar_container);
        this.f619c = actionBarContainer;
        DecorToolbar decorToolbar = this.f620d;
        if (decorToolbar == null || this.f621e == null || actionBarContainer == null) {
            throw new IllegalStateException(getClass().getSimpleName() + " can only be used with a compatible window decor layout");
        }
        this.f617a = decorToolbar.getContext();
        if ((this.f620d.getDisplayOptions() & 4) != 0) {
            z11 = true;
        } else {
            z11 = false;
        }
        if (z11) {
            this.mDisplayHomeAsUpSet = true;
        }
        ActionBarPolicy actionBarPolicy = ActionBarPolicy.get(this.f617a);
        if (actionBarPolicy.enableHomeButtonByDefault() || z11) {
            z12 = true;
        } else {
            z12 = false;
        }
        setHomeButtonEnabled(z12);
        setHasEmbeddedTabs(actionBarPolicy.hasEmbeddedTabs());
        TypedArray obtainStyledAttributes = this.f617a.obtainStyledAttributes((AttributeSet) null, R.styleable.ActionBar, R.attr.actionBarStyle, 0);
        if (obtainStyledAttributes.getBoolean(R.styleable.ActionBar_hideOnContentScroll, false)) {
            setHideOnContentScrollEnabled(true);
        }
        int dimensionPixelSize = obtainStyledAttributes.getDimensionPixelSize(R.styleable.ActionBar_elevation, 0);
        if (dimensionPixelSize != 0) {
            setElevation((float) dimensionPixelSize);
        }
        obtainStyledAttributes.recycle();
    }

    private void setHasEmbeddedTabs(boolean z11) {
        boolean z12;
        boolean z13;
        this.mHasEmbeddedTabs = z11;
        if (!z11) {
            this.f620d.setEmbeddedTabView((ScrollingTabContainerView) null);
            this.f619c.setTabContainer(this.f623g);
        } else {
            this.f619c.setTabContainer((ScrollingTabContainerView) null);
            this.f620d.setEmbeddedTabView(this.f623g);
        }
        boolean z14 = true;
        if (getNavigationMode() == 2) {
            z12 = true;
        } else {
            z12 = false;
        }
        ScrollingTabContainerView scrollingTabContainerView = this.f623g;
        if (scrollingTabContainerView != null) {
            if (z12) {
                scrollingTabContainerView.setVisibility(0);
                ActionBarOverlayLayout actionBarOverlayLayout = this.f618b;
                if (actionBarOverlayLayout != null) {
                    ViewCompat.requestApplyInsets(actionBarOverlayLayout);
                }
            } else {
                scrollingTabContainerView.setVisibility(8);
            }
        }
        DecorToolbar decorToolbar = this.f620d;
        if (this.mHasEmbeddedTabs || !z12) {
            z13 = false;
        } else {
            z13 = true;
        }
        decorToolbar.setCollapsible(z13);
        ActionBarOverlayLayout actionBarOverlayLayout2 = this.f618b;
        if (this.mHasEmbeddedTabs || !z12) {
            z14 = false;
        }
        actionBarOverlayLayout2.setHasNonEmbeddedTabs(z14);
    }

    private boolean shouldAnimateContextView() {
        return ViewCompat.isLaidOut(this.f619c);
    }

    private void showForActionMode() {
        if (!this.mShowingForMode) {
            this.mShowingForMode = true;
            ActionBarOverlayLayout actionBarOverlayLayout = this.f618b;
            if (actionBarOverlayLayout != null) {
                actionBarOverlayLayout.setShowingForActionMode(true);
            }
            updateVisibility(false);
        }
    }

    private void updateVisibility(boolean z11) {
        if (b(this.f628l, this.f629m, this.mShowingForMode)) {
            if (!this.mNowShowing) {
                this.mNowShowing = true;
                doShow(z11);
            }
        } else if (this.mNowShowing) {
            this.mNowShowing = false;
            doHide(z11);
        }
    }

    public void addOnMenuVisibilityListener(ActionBar.OnMenuVisibilityListener onMenuVisibilityListener) {
        this.mMenuVisibilityListeners.add(onMenuVisibilityListener);
    }

    public void addTab(ActionBar.Tab tab) {
        addTab(tab, this.mTabs.isEmpty());
    }

    public void animateToMode(boolean z11) {
        ViewPropertyAnimatorCompat viewPropertyAnimatorCompat;
        ViewPropertyAnimatorCompat viewPropertyAnimatorCompat2;
        if (z11) {
            showForActionMode();
        } else {
            hideForActionMode();
        }
        if (shouldAnimateContextView()) {
            if (z11) {
                viewPropertyAnimatorCompat = this.f620d.setupAnimatorToVisibility(4, 100);
                viewPropertyAnimatorCompat2 = this.f621e.setupAnimatorToVisibility(0, 200);
            } else {
                viewPropertyAnimatorCompat2 = this.f620d.setupAnimatorToVisibility(0, 200);
                viewPropertyAnimatorCompat = this.f621e.setupAnimatorToVisibility(8, 100);
            }
            ViewPropertyAnimatorCompatSet viewPropertyAnimatorCompatSet = new ViewPropertyAnimatorCompatSet();
            viewPropertyAnimatorCompatSet.playSequentially(viewPropertyAnimatorCompat, viewPropertyAnimatorCompat2);
            viewPropertyAnimatorCompatSet.start();
        } else if (z11) {
            this.f620d.setVisibility(4);
            this.f621e.setVisibility(0);
        } else {
            this.f620d.setVisibility(0);
            this.f621e.setVisibility(8);
        }
    }

    public void c() {
        ActionMode.Callback callback = this.f626j;
        if (callback != null) {
            callback.onDestroyActionMode(this.f625i);
            this.f625i = null;
            this.f626j = null;
        }
    }

    public boolean collapseActionView() {
        DecorToolbar decorToolbar = this.f620d;
        if (decorToolbar == null || !decorToolbar.hasExpandedActionView()) {
            return false;
        }
        this.f620d.collapseActionView();
        return true;
    }

    public void dispatchMenuVisibilityChanged(boolean z11) {
        if (z11 != this.mLastMenuVisibility) {
            this.mLastMenuVisibility = z11;
            int size = this.mMenuVisibilityListeners.size();
            for (int i11 = 0; i11 < size; i11++) {
                this.mMenuVisibilityListeners.get(i11).onMenuVisibilityChanged(z11);
            }
        }
    }

    public void doHide(boolean z11) {
        View view;
        ViewPropertyAnimatorCompatSet viewPropertyAnimatorCompatSet = this.f630n;
        if (viewPropertyAnimatorCompatSet != null) {
            viewPropertyAnimatorCompatSet.cancel();
        }
        if (this.mCurWindowVisibility != 0 || (!this.mShowHideAnimationEnabled && !z11)) {
            this.f632p.onAnimationEnd((View) null);
            return;
        }
        this.f619c.setAlpha(1.0f);
        this.f619c.setTransitioning(true);
        ViewPropertyAnimatorCompatSet viewPropertyAnimatorCompatSet2 = new ViewPropertyAnimatorCompatSet();
        float f11 = (float) (-this.f619c.getHeight());
        if (z11) {
            int[] iArr = {0, 0};
            this.f619c.getLocationInWindow(iArr);
            f11 -= (float) iArr[1];
        }
        ViewPropertyAnimatorCompat translationY = ViewCompat.animate(this.f619c).translationY(f11);
        translationY.setUpdateListener(this.f634r);
        viewPropertyAnimatorCompatSet2.play(translationY);
        if (this.f627k && (view = this.f622f) != null) {
            viewPropertyAnimatorCompatSet2.play(ViewCompat.animate(view).translationY(f11));
        }
        viewPropertyAnimatorCompatSet2.setInterpolator(sHideInterpolator);
        viewPropertyAnimatorCompatSet2.setDuration(250);
        viewPropertyAnimatorCompatSet2.setListener(this.f632p);
        this.f630n = viewPropertyAnimatorCompatSet2;
        viewPropertyAnimatorCompatSet2.start();
    }

    public void doShow(boolean z11) {
        View view;
        View view2;
        ViewPropertyAnimatorCompatSet viewPropertyAnimatorCompatSet = this.f630n;
        if (viewPropertyAnimatorCompatSet != null) {
            viewPropertyAnimatorCompatSet.cancel();
        }
        this.f619c.setVisibility(0);
        if (this.mCurWindowVisibility != 0 || (!this.mShowHideAnimationEnabled && !z11)) {
            this.f619c.setAlpha(1.0f);
            this.f619c.setTranslationY(0.0f);
            if (this.f627k && (view = this.f622f) != null) {
                view.setTranslationY(0.0f);
            }
            this.f633q.onAnimationEnd((View) null);
        } else {
            this.f619c.setTranslationY(0.0f);
            float f11 = (float) (-this.f619c.getHeight());
            if (z11) {
                int[] iArr = {0, 0};
                this.f619c.getLocationInWindow(iArr);
                f11 -= (float) iArr[1];
            }
            this.f619c.setTranslationY(f11);
            ViewPropertyAnimatorCompatSet viewPropertyAnimatorCompatSet2 = new ViewPropertyAnimatorCompatSet();
            ViewPropertyAnimatorCompat translationY = ViewCompat.animate(this.f619c).translationY(0.0f);
            translationY.setUpdateListener(this.f634r);
            viewPropertyAnimatorCompatSet2.play(translationY);
            if (this.f627k && (view2 = this.f622f) != null) {
                view2.setTranslationY(f11);
                viewPropertyAnimatorCompatSet2.play(ViewCompat.animate(this.f622f).translationY(0.0f));
            }
            viewPropertyAnimatorCompatSet2.setInterpolator(sShowInterpolator);
            viewPropertyAnimatorCompatSet2.setDuration(250);
            viewPropertyAnimatorCompatSet2.setListener(this.f633q);
            this.f630n = viewPropertyAnimatorCompatSet2;
            viewPropertyAnimatorCompatSet2.start();
        }
        ActionBarOverlayLayout actionBarOverlayLayout = this.f618b;
        if (actionBarOverlayLayout != null) {
            ViewCompat.requestApplyInsets(actionBarOverlayLayout);
        }
    }

    public void enableContentAnimations(boolean z11) {
        this.f627k = z11;
    }

    public View getCustomView() {
        return this.f620d.getCustomView();
    }

    public int getDisplayOptions() {
        return this.f620d.getDisplayOptions();
    }

    public float getElevation() {
        return ViewCompat.getElevation(this.f619c);
    }

    public int getHeight() {
        return this.f619c.getHeight();
    }

    public int getHideOffset() {
        return this.f618b.getActionBarHideOffset();
    }

    public int getNavigationItemCount() {
        int navigationMode = this.f620d.getNavigationMode();
        if (navigationMode == 1) {
            return this.f620d.getDropdownItemCount();
        }
        if (navigationMode != 2) {
            return 0;
        }
        return this.mTabs.size();
    }

    public int getNavigationMode() {
        return this.f620d.getNavigationMode();
    }

    public int getSelectedNavigationIndex() {
        TabImpl tabImpl;
        int navigationMode = this.f620d.getNavigationMode();
        if (navigationMode == 1) {
            return this.f620d.getDropdownSelectedPosition();
        }
        if (navigationMode == 2 && (tabImpl = this.mSelectedTab) != null) {
            return tabImpl.getPosition();
        }
        return -1;
    }

    public ActionBar.Tab getSelectedTab() {
        return this.mSelectedTab;
    }

    public CharSequence getSubtitle() {
        return this.f620d.getSubtitle();
    }

    public ActionBar.Tab getTabAt(int i11) {
        return this.mTabs.get(i11);
    }

    public int getTabCount() {
        return this.mTabs.size();
    }

    public Context getThemedContext() {
        if (this.mThemedContext == null) {
            TypedValue typedValue = new TypedValue();
            this.f617a.getTheme().resolveAttribute(R.attr.actionBarWidgetTheme, typedValue, true);
            int i11 = typedValue.resourceId;
            if (i11 != 0) {
                this.mThemedContext = new ContextThemeWrapper(this.f617a, i11);
            } else {
                this.mThemedContext = this.f617a;
            }
        }
        return this.mThemedContext;
    }

    public CharSequence getTitle() {
        return this.f620d.getTitle();
    }

    public boolean hasIcon() {
        return this.f620d.hasIcon();
    }

    public boolean hasLogo() {
        return this.f620d.hasLogo();
    }

    public void hide() {
        if (!this.f628l) {
            this.f628l = true;
            updateVisibility(false);
        }
    }

    public void hideForSystem() {
        if (!this.f629m) {
            this.f629m = true;
            updateVisibility(true);
        }
    }

    public boolean isHideOnContentScrollEnabled() {
        return this.f618b.isHideOnContentScrollEnabled();
    }

    public boolean isShowing() {
        int height = getHeight();
        if (!this.mNowShowing || (height != 0 && getHideOffset() >= height)) {
            return false;
        }
        return true;
    }

    public boolean isTitleTruncated() {
        DecorToolbar decorToolbar = this.f620d;
        return decorToolbar != null && decorToolbar.isTitleTruncated();
    }

    public ActionBar.Tab newTab() {
        return new TabImpl();
    }

    public void onConfigurationChanged(Configuration configuration) {
        setHasEmbeddedTabs(ActionBarPolicy.get(this.f617a).hasEmbeddedTabs());
    }

    public void onContentScrollStarted() {
        ViewPropertyAnimatorCompatSet viewPropertyAnimatorCompatSet = this.f630n;
        if (viewPropertyAnimatorCompatSet != null) {
            viewPropertyAnimatorCompatSet.cancel();
            this.f630n = null;
        }
    }

    public void onContentScrollStopped() {
    }

    public boolean onKeyShortcut(int i11, KeyEvent keyEvent) {
        Menu menu;
        int i12;
        ActionModeImpl actionModeImpl = this.f624h;
        if (actionModeImpl == null || (menu = actionModeImpl.getMenu()) == null) {
            return false;
        }
        if (keyEvent != null) {
            i12 = keyEvent.getDeviceId();
        } else {
            i12 = -1;
        }
        boolean z11 = true;
        if (KeyCharacterMap.load(i12).getKeyboardType() == 1) {
            z11 = false;
        }
        menu.setQwertyMode(z11);
        return menu.performShortcut(i11, keyEvent, 0);
    }

    public void onWindowVisibilityChanged(int i11) {
        this.mCurWindowVisibility = i11;
    }

    public void removeAllTabs() {
        cleanupTabs();
    }

    public void removeOnMenuVisibilityListener(ActionBar.OnMenuVisibilityListener onMenuVisibilityListener) {
        this.mMenuVisibilityListeners.remove(onMenuVisibilityListener);
    }

    public void removeTab(ActionBar.Tab tab) {
        removeTabAt(tab.getPosition());
    }

    public void removeTabAt(int i11) {
        int i12;
        ActionBar.Tab tab;
        if (this.f623g != null) {
            TabImpl tabImpl = this.mSelectedTab;
            if (tabImpl != null) {
                i12 = tabImpl.getPosition();
            } else {
                i12 = this.mSavedTabPosition;
            }
            this.f623g.removeTabAt(i11);
            TabImpl remove = this.mTabs.remove(i11);
            if (remove != null) {
                remove.setPosition(-1);
            }
            int size = this.mTabs.size();
            for (int i13 = i11; i13 < size; i13++) {
                this.mTabs.get(i13).setPosition(i13);
            }
            if (i12 == i11) {
                if (this.mTabs.isEmpty()) {
                    tab = null;
                } else {
                    tab = this.mTabs.get(Math.max(0, i11 - 1));
                }
                selectTab(tab);
            }
        }
    }

    public boolean requestFocus() {
        ViewGroup viewGroup = this.f620d.getViewGroup();
        if (viewGroup == null || viewGroup.hasFocus()) {
            return false;
        }
        viewGroup.requestFocus();
        return true;
    }

    public void selectTab(ActionBar.Tab tab) {
        FragmentTransaction fragmentTransaction;
        int i11 = -1;
        if (getNavigationMode() != 2) {
            if (tab != null) {
                i11 = tab.getPosition();
            }
            this.mSavedTabPosition = i11;
            return;
        }
        if (!(this.mActivity instanceof FragmentActivity) || this.f620d.getViewGroup().isInEditMode()) {
            fragmentTransaction = null;
        } else {
            fragmentTransaction = ((FragmentActivity) this.mActivity).getSupportFragmentManager().beginTransaction().disallowAddToBackStack();
        }
        TabImpl tabImpl = this.mSelectedTab;
        if (tabImpl != tab) {
            ScrollingTabContainerView scrollingTabContainerView = this.f623g;
            if (tab != null) {
                i11 = tab.getPosition();
            }
            scrollingTabContainerView.setTabSelected(i11);
            TabImpl tabImpl2 = this.mSelectedTab;
            if (tabImpl2 != null) {
                tabImpl2.getCallback().onTabUnselected(this.mSelectedTab, fragmentTransaction);
            }
            TabImpl tabImpl3 = (TabImpl) tab;
            this.mSelectedTab = tabImpl3;
            if (tabImpl3 != null) {
                tabImpl3.getCallback().onTabSelected(this.mSelectedTab, fragmentTransaction);
            }
        } else if (tabImpl != null) {
            tabImpl.getCallback().onTabReselected(this.mSelectedTab, fragmentTransaction);
            this.f623g.animateToTab(tab.getPosition());
        }
        if (fragmentTransaction != null && !fragmentTransaction.isEmpty()) {
            fragmentTransaction.commit();
        }
    }

    public void setBackgroundDrawable(Drawable drawable) {
        this.f619c.setPrimaryBackground(drawable);
    }

    public void setCustomView(int i11) {
        setCustomView(LayoutInflater.from(getThemedContext()).inflate(i11, this.f620d.getViewGroup(), false));
    }

    public void setDefaultDisplayHomeAsUpEnabled(boolean z11) {
        if (!this.mDisplayHomeAsUpSet) {
            setDisplayHomeAsUpEnabled(z11);
        }
    }

    public void setDisplayHomeAsUpEnabled(boolean z11) {
        setDisplayOptions(z11 ? 4 : 0, 4);
    }

    public void setDisplayOptions(int i11) {
        if ((i11 & 4) != 0) {
            this.mDisplayHomeAsUpSet = true;
        }
        this.f620d.setDisplayOptions(i11);
    }

    public void setDisplayShowCustomEnabled(boolean z11) {
        setDisplayOptions(z11 ? 16 : 0, 16);
    }

    public void setDisplayShowHomeEnabled(boolean z11) {
        setDisplayOptions(z11 ? 2 : 0, 2);
    }

    public void setDisplayShowTitleEnabled(boolean z11) {
        setDisplayOptions(z11 ? 8 : 0, 8);
    }

    public void setDisplayUseLogoEnabled(boolean z11) {
        setDisplayOptions(z11 ? 1 : 0, 1);
    }

    public void setElevation(float f11) {
        ViewCompat.setElevation(this.f619c, f11);
    }

    public void setHideOffset(int i11) {
        if (i11 == 0 || this.f618b.isInOverlayMode()) {
            this.f618b.setActionBarHideOffset(i11);
            return;
        }
        throw new IllegalStateException("Action bar must be in overlay mode (Window.FEATURE_OVERLAY_ACTION_BAR) to set a non-zero hide offset");
    }

    public void setHideOnContentScrollEnabled(boolean z11) {
        if (!z11 || this.f618b.isInOverlayMode()) {
            this.f631o = z11;
            this.f618b.setHideOnContentScrollEnabled(z11);
            return;
        }
        throw new IllegalStateException("Action bar must be in overlay mode (Window.FEATURE_OVERLAY_ACTION_BAR) to enable hide on content scroll");
    }

    public void setHomeActionContentDescription(CharSequence charSequence) {
        this.f620d.setNavigationContentDescription(charSequence);
    }

    public void setHomeAsUpIndicator(Drawable drawable) {
        this.f620d.setNavigationIcon(drawable);
    }

    public void setHomeButtonEnabled(boolean z11) {
        this.f620d.setHomeButtonEnabled(z11);
    }

    public void setIcon(int i11) {
        this.f620d.setIcon(i11);
    }

    public void setListNavigationCallbacks(SpinnerAdapter spinnerAdapter, ActionBar.OnNavigationListener onNavigationListener) {
        this.f620d.setDropdownParams(spinnerAdapter, new NavItemSelectedListener(onNavigationListener));
    }

    public void setLogo(int i11) {
        this.f620d.setLogo(i11);
    }

    public void setNavigationMode(int i11) {
        boolean z11;
        ActionBarOverlayLayout actionBarOverlayLayout;
        int navigationMode = this.f620d.getNavigationMode();
        if (navigationMode == 2) {
            this.mSavedTabPosition = getSelectedNavigationIndex();
            selectTab((ActionBar.Tab) null);
            this.f623g.setVisibility(8);
        }
        if (!(navigationMode == i11 || this.mHasEmbeddedTabs || (actionBarOverlayLayout = this.f618b) == null)) {
            ViewCompat.requestApplyInsets(actionBarOverlayLayout);
        }
        this.f620d.setNavigationMode(i11);
        boolean z12 = false;
        if (i11 == 2) {
            ensureTabsExist();
            this.f623g.setVisibility(0);
            int i12 = this.mSavedTabPosition;
            if (i12 != -1) {
                setSelectedNavigationItem(i12);
                this.mSavedTabPosition = -1;
            }
        }
        DecorToolbar decorToolbar = this.f620d;
        if (i11 != 2 || this.mHasEmbeddedTabs) {
            z11 = false;
        } else {
            z11 = true;
        }
        decorToolbar.setCollapsible(z11);
        ActionBarOverlayLayout actionBarOverlayLayout2 = this.f618b;
        if (i11 == 2 && !this.mHasEmbeddedTabs) {
            z12 = true;
        }
        actionBarOverlayLayout2.setHasNonEmbeddedTabs(z12);
    }

    public void setSelectedNavigationItem(int i11) {
        int navigationMode = this.f620d.getNavigationMode();
        if (navigationMode == 1) {
            this.f620d.setDropdownSelectedPosition(i11);
        } else if (navigationMode == 2) {
            selectTab(this.mTabs.get(i11));
        } else {
            throw new IllegalStateException("setSelectedNavigationIndex not valid for current navigation mode");
        }
    }

    public void setShowHideAnimationEnabled(boolean z11) {
        ViewPropertyAnimatorCompatSet viewPropertyAnimatorCompatSet;
        this.mShowHideAnimationEnabled = z11;
        if (!z11 && (viewPropertyAnimatorCompatSet = this.f630n) != null) {
            viewPropertyAnimatorCompatSet.cancel();
        }
    }

    public void setSplitBackgroundDrawable(Drawable drawable) {
    }

    public void setStackedBackgroundDrawable(Drawable drawable) {
        this.f619c.setStackedBackground(drawable);
    }

    public void setSubtitle(int i11) {
        setSubtitle((CharSequence) this.f617a.getString(i11));
    }

    public void setTitle(int i11) {
        setTitle((CharSequence) this.f617a.getString(i11));
    }

    public void setWindowTitle(CharSequence charSequence) {
        this.f620d.setWindowTitle(charSequence);
    }

    public void show() {
        if (this.f628l) {
            this.f628l = false;
            updateVisibility(false);
        }
    }

    public void showForSystem() {
        if (this.f629m) {
            this.f629m = false;
            updateVisibility(true);
        }
    }

    public ActionMode startActionMode(ActionMode.Callback callback) {
        ActionModeImpl actionModeImpl = this.f624h;
        if (actionModeImpl != null) {
            actionModeImpl.finish();
        }
        this.f618b.setHideOnContentScrollEnabled(false);
        this.f621e.killMode();
        ActionModeImpl actionModeImpl2 = new ActionModeImpl(this.f621e.getContext(), callback);
        if (!actionModeImpl2.dispatchOnCreate()) {
            return null;
        }
        this.f624h = actionModeImpl2;
        actionModeImpl2.invalidate();
        this.f621e.initForMode(actionModeImpl2);
        animateToMode(true);
        return actionModeImpl2;
    }

    public void addTab(ActionBar.Tab tab, int i11) {
        addTab(tab, i11, this.mTabs.isEmpty());
    }

    public void setHomeActionContentDescription(int i11) {
        this.f620d.setNavigationContentDescription(i11);
    }

    public void setHomeAsUpIndicator(int i11) {
        this.f620d.setNavigationIcon(i11);
    }

    public void setIcon(Drawable drawable) {
        this.f620d.setIcon(drawable);
    }

    public void setLogo(Drawable drawable) {
        this.f620d.setLogo(drawable);
    }

    public void setSubtitle(CharSequence charSequence) {
        this.f620d.setSubtitle(charSequence);
    }

    public void setTitle(CharSequence charSequence) {
        this.f620d.setTitle(charSequence);
    }

    public void addTab(ActionBar.Tab tab, boolean z11) {
        ensureTabsExist();
        this.f623g.addTab(tab, z11);
        configureTab(tab, this.mTabs.size());
        if (z11) {
            selectTab(tab);
        }
    }

    public void setDisplayOptions(int i11, int i12) {
        int displayOptions = this.f620d.getDisplayOptions();
        if ((i12 & 4) != 0) {
            this.mDisplayHomeAsUpSet = true;
        }
        this.f620d.setDisplayOptions((i11 & i12) | ((~i12) & displayOptions));
    }

    public void setCustomView(View view) {
        this.f620d.setCustomView(view);
    }

    public void setCustomView(View view, ActionBar.LayoutParams layoutParams) {
        view.setLayoutParams(layoutParams);
        this.f620d.setCustomView(view);
    }

    public void addTab(ActionBar.Tab tab, int i11, boolean z11) {
        ensureTabsExist();
        this.f623g.addTab(tab, i11, z11);
        configureTab(tab, i11);
        if (z11) {
            selectTab(tab);
        }
    }

    public WindowDecorActionBar(Dialog dialog) {
        init(dialog.getWindow().getDecorView());
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public WindowDecorActionBar(View view) {
        init(view);
    }
}
