package androidx.appcompat.app;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.Dialog;
import android.app.UiModeManager;
import android.content.BroadcastReceiver;
import android.content.ComponentName;
import android.content.Context;
import android.content.ContextWrapper;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.pm.ActivityInfo;
import android.content.pm.PackageManager;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Bundle;
import android.os.LocaleList;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.PowerManager;
import android.text.TextUtils;
import android.util.AndroidRuntimeException;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.util.Log;
import android.util.TypedValue;
import android.view.ActionMode;
import android.view.ContextThemeWrapper;
import android.view.KeyCharacterMap;
import android.view.KeyEvent;
import android.view.KeyboardShortcutGroup;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.Window;
import android.view.WindowManager;
import android.widget.FrameLayout;
import android.widget.PopupWindow;
import android.widget.TextView;
import android.window.OnBackInvokedCallback;
import android.window.OnBackInvokedDispatcher;
import androidx.annotation.CallSuper;
import androidx.annotation.DoNotInline;
import androidx.annotation.IdRes;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.annotation.RestrictTo;
import androidx.annotation.StyleRes;
import androidx.annotation.VisibleForTesting;
import androidx.appcompat.R;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.content.res.AppCompatResources;
import androidx.appcompat.view.ActionMode;
import androidx.appcompat.view.SupportActionModeWrapper;
import androidx.appcompat.view.SupportMenuInflater;
import androidx.appcompat.view.WindowCallbackWrapper;
import androidx.appcompat.view.menu.ListMenuPresenter;
import androidx.appcompat.view.menu.MenuBuilder;
import androidx.appcompat.view.menu.MenuPresenter;
import androidx.appcompat.view.menu.MenuView;
import androidx.appcompat.widget.ActionBarContextView;
import androidx.appcompat.widget.AppCompatDrawableManager;
import androidx.appcompat.widget.ContentFrameLayout;
import androidx.appcompat.widget.DecorContentParent;
import androidx.appcompat.widget.FitWindowsViewGroup;
import androidx.appcompat.widget.TintTypedArray;
import androidx.appcompat.widget.Toolbar;
import androidx.appcompat.widget.VectorEnabledTintResources;
import androidx.appcompat.widget.ViewUtils;
import androidx.collection.SimpleArrayMap;
import androidx.core.app.NavUtils;
import androidx.core.content.ContextCompat;
import androidx.core.content.res.ResourcesCompat;
import androidx.core.os.LocaleListCompat;
import androidx.core.util.ObjectsCompat;
import androidx.core.view.KeyEventDispatcher;
import androidx.core.view.LayoutInflaterCompat;
import androidx.core.view.OnApplyWindowInsetsListener;
import androidx.core.view.ViewCompat;
import androidx.core.view.ViewPropertyAnimatorCompat;
import androidx.core.view.ViewPropertyAnimatorListener;
import androidx.core.view.ViewPropertyAnimatorListenerAdapter;
import androidx.core.view.WindowInsetsCompat;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleOwner;
import com.google.firebase.database.core.ValidationPath;
import java.lang.Thread;
import java.util.List;
import java.util.Locale;
import java.util.Objects;
import org.xmlpull.v1.XmlPullParser;

@RestrictTo({RestrictTo.Scope.LIBRARY})
class AppCompatDelegateImpl extends AppCompatDelegate implements MenuBuilder.Callback, LayoutInflater.Factory2 {
    private static final boolean IS_PRE_LOLLIPOP = false;
    private static final boolean sCanApplyOverrideConfiguration = true;
    private static final boolean sCanReturnDifferentContext = (!"robolectric".equals(Build.FINGERPRINT));
    private static boolean sInstalledExceptionHandler;
    private static final SimpleArrayMap<String, Integer> sLocalNightModes = new SimpleArrayMap<>();
    private static final int[] sWindowBackgroundStyleable = {16842836};

    /* renamed from: c  reason: collision with root package name */
    public final Object f543c;

    /* renamed from: d  reason: collision with root package name */
    public final Context f544d;

    /* renamed from: e  reason: collision with root package name */
    public Window f545e;

    /* renamed from: f  reason: collision with root package name */
    public final AppCompatCallback f546f;

    /* renamed from: g  reason: collision with root package name */
    public ActionBar f547g;

    /* renamed from: h  reason: collision with root package name */
    public MenuInflater f548h;

    /* renamed from: i  reason: collision with root package name */
    public ActionMode f549i;

    /* renamed from: j  reason: collision with root package name */
    public ActionBarContextView f550j;

    /* renamed from: k  reason: collision with root package name */
    public PopupWindow f551k;

    /* renamed from: l  reason: collision with root package name */
    public Runnable f552l;

    /* renamed from: m  reason: collision with root package name */
    public ViewPropertyAnimatorCompat f553m;
    private ActionMenuPresenterCallback mActionMenuPresenterCallback;
    private int mActivityHandlesConfigFlags;
    private boolean mActivityHandlesConfigFlagsChecked;
    private AppCompatViewInflater mAppCompatViewInflater;
    private AppCompatWindowCallback mAppCompatWindowCallback;
    private AutoNightModeManager mAutoBatteryNightModeManager;
    private AutoNightModeManager mAutoTimeNightModeManager;
    private OnBackInvokedCallback mBackCallback;
    private boolean mBaseContextAttached;
    private boolean mClosingActionMenu;
    private boolean mCreated;
    private DecorContentParent mDecorContentParent;
    private OnBackInvokedDispatcher mDispatcher;
    private Configuration mEffectiveConfiguration;
    private boolean mEnableDefaultActionBarUp;
    private boolean mFeatureIndeterminateProgress;
    private boolean mFeatureProgress;
    private boolean mHandleNativeActionModes;
    private final Runnable mInvalidatePanelMenuRunnable;
    private LayoutIncludeDetector mLayoutIncludeDetector;
    private int mLocalNightMode;
    private boolean mLongPressBackDown;
    private PanelMenuPresenterCallback mPanelMenuPresenterCallback;
    private PanelFeatureState[] mPanels;
    private PanelFeatureState mPreparedPanel;
    private View mStatusGuard;
    private boolean mSubDecorInstalled;
    private Rect mTempRect1;
    private Rect mTempRect2;
    private int mThemeResId;
    private CharSequence mTitle;
    private TextView mTitleView;

    /* renamed from: n  reason: collision with root package name */
    public ViewGroup f554n;

    /* renamed from: o  reason: collision with root package name */
    public boolean f555o;

    /* renamed from: p  reason: collision with root package name */
    public boolean f556p;

    /* renamed from: q  reason: collision with root package name */
    public boolean f557q;

    /* renamed from: r  reason: collision with root package name */
    public boolean f558r;

    /* renamed from: s  reason: collision with root package name */
    public boolean f559s;

    /* renamed from: t  reason: collision with root package name */
    public boolean f560t;

    /* renamed from: u  reason: collision with root package name */
    public boolean f561u;

    /* renamed from: v  reason: collision with root package name */
    public int f562v;

    /* renamed from: androidx.appcompat.app.AppCompatDelegateImpl$1  reason: invalid class name */
    public class AnonymousClass1 implements Thread.UncaughtExceptionHandler {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ Thread.UncaughtExceptionHandler f563a;

        private boolean shouldWrapException(Throwable th2) {
            String message;
            if (!(th2 instanceof Resources.NotFoundException) || (message = th2.getMessage()) == null) {
                return false;
            }
            if (message.contains("drawable") || message.contains("Drawable")) {
                return true;
            }
            return false;
        }

        public void uncaughtException(@NonNull Thread thread, @NonNull Throwable th2) {
            if (shouldWrapException(th2)) {
                Resources.NotFoundException notFoundException = new Resources.NotFoundException(th2.getMessage() + ". If the resource you are trying to use is a vector resource, you may be referencing it in an unsupported way. See AppCompatDelegate.setCompatVectorFromResourcesEnabled() for more info.");
                notFoundException.initCause(th2.getCause());
                notFoundException.setStackTrace(th2.getStackTrace());
                this.f563a.uncaughtException(thread, notFoundException);
                return;
            }
            this.f563a.uncaughtException(thread, th2);
        }
    }

    /* renamed from: androidx.appcompat.app.AppCompatDelegateImpl$4  reason: invalid class name */
    public class AnonymousClass4 implements FitWindowsViewGroup.OnFitSystemWindowsListener {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ AppCompatDelegateImpl f566a;

        public void onFitSystemWindows(Rect rect) {
            rect.top = this.f566a.P((WindowInsetsCompat) null, rect);
        }
    }

    public class ActionBarDrawableToggleImpl implements ActionBarDrawerToggle.Delegate {
        public ActionBarDrawableToggleImpl() {
        }

        public Context getActionBarThemedContext() {
            return AppCompatDelegateImpl.this.v();
        }

        public Drawable getThemeUpIndicator() {
            TintTypedArray obtainStyledAttributes = TintTypedArray.obtainStyledAttributes(getActionBarThemedContext(), (AttributeSet) null, new int[]{R.attr.homeAsUpIndicator});
            Drawable drawable = obtainStyledAttributes.getDrawable(0);
            obtainStyledAttributes.recycle();
            return drawable;
        }

        public boolean isNavigationVisible() {
            ActionBar supportActionBar = AppCompatDelegateImpl.this.getSupportActionBar();
            if (supportActionBar == null || (supportActionBar.getDisplayOptions() & 4) == 0) {
                return false;
            }
            return true;
        }

        public void setActionBarDescription(int i11) {
            ActionBar supportActionBar = AppCompatDelegateImpl.this.getSupportActionBar();
            if (supportActionBar != null) {
                supportActionBar.setHomeActionContentDescription(i11);
            }
        }

        public void setActionBarUpIndicator(Drawable drawable, int i11) {
            ActionBar supportActionBar = AppCompatDelegateImpl.this.getSupportActionBar();
            if (supportActionBar != null) {
                supportActionBar.setHomeAsUpIndicator(drawable);
                supportActionBar.setHomeActionContentDescription(i11);
            }
        }
    }

    public interface ActionBarMenuCallback {
        @Nullable
        View onCreatePanelView(int i11);

        boolean onPreparePanel(int i11);
    }

    public final class ActionMenuPresenterCallback implements MenuPresenter.Callback {
        public ActionMenuPresenterCallback() {
        }

        public void onCloseMenu(@NonNull MenuBuilder menuBuilder, boolean z11) {
            AppCompatDelegateImpl.this.n(menuBuilder);
        }

        public boolean onOpenSubMenu(@NonNull MenuBuilder menuBuilder) {
            Window.Callback z11 = AppCompatDelegateImpl.this.z();
            if (z11 == null) {
                return true;
            }
            z11.onMenuOpened(108, menuBuilder);
            return true;
        }
    }

    public class ActionModeCallbackWrapperV9 implements ActionMode.Callback {
        private ActionMode.Callback mWrapped;

        public ActionModeCallbackWrapperV9(ActionMode.Callback callback) {
            this.mWrapped = callback;
        }

        public boolean onActionItemClicked(ActionMode actionMode, MenuItem menuItem) {
            return this.mWrapped.onActionItemClicked(actionMode, menuItem);
        }

        public boolean onCreateActionMode(ActionMode actionMode, Menu menu) {
            return this.mWrapped.onCreateActionMode(actionMode, menu);
        }

        public void onDestroyActionMode(ActionMode actionMode) {
            this.mWrapped.onDestroyActionMode(actionMode);
            AppCompatDelegateImpl appCompatDelegateImpl = AppCompatDelegateImpl.this;
            if (appCompatDelegateImpl.f551k != null) {
                appCompatDelegateImpl.f545e.getDecorView().removeCallbacks(AppCompatDelegateImpl.this.f552l);
            }
            AppCompatDelegateImpl appCompatDelegateImpl2 = AppCompatDelegateImpl.this;
            if (appCompatDelegateImpl2.f550j != null) {
                appCompatDelegateImpl2.t();
                AppCompatDelegateImpl appCompatDelegateImpl3 = AppCompatDelegateImpl.this;
                appCompatDelegateImpl3.f553m = ViewCompat.animate(appCompatDelegateImpl3.f550j).alpha(0.0f);
                AppCompatDelegateImpl.this.f553m.setListener(new ViewPropertyAnimatorListenerAdapter() {
                    public void onAnimationEnd(View view) {
                        AppCompatDelegateImpl.this.f550j.setVisibility(8);
                        AppCompatDelegateImpl appCompatDelegateImpl = AppCompatDelegateImpl.this;
                        PopupWindow popupWindow = appCompatDelegateImpl.f551k;
                        if (popupWindow != null) {
                            popupWindow.dismiss();
                        } else if (appCompatDelegateImpl.f550j.getParent() instanceof View) {
                            ViewCompat.requestApplyInsets((View) AppCompatDelegateImpl.this.f550j.getParent());
                        }
                        AppCompatDelegateImpl.this.f550j.killMode();
                        AppCompatDelegateImpl.this.f553m.setListener((ViewPropertyAnimatorListener) null);
                        AppCompatDelegateImpl appCompatDelegateImpl2 = AppCompatDelegateImpl.this;
                        appCompatDelegateImpl2.f553m = null;
                        ViewCompat.requestApplyInsets(appCompatDelegateImpl2.f554n);
                    }
                });
            }
            AppCompatDelegateImpl appCompatDelegateImpl4 = AppCompatDelegateImpl.this;
            AppCompatCallback appCompatCallback = appCompatDelegateImpl4.f546f;
            if (appCompatCallback != null) {
                appCompatCallback.onSupportActionModeFinished(appCompatDelegateImpl4.f549i);
            }
            AppCompatDelegateImpl appCompatDelegateImpl5 = AppCompatDelegateImpl.this;
            appCompatDelegateImpl5.f549i = null;
            ViewCompat.requestApplyInsets(appCompatDelegateImpl5.f554n);
            AppCompatDelegateImpl.this.O();
        }

        public boolean onPrepareActionMode(ActionMode actionMode, Menu menu) {
            ViewCompat.requestApplyInsets(AppCompatDelegateImpl.this.f554n);
            return this.mWrapped.onPrepareActionMode(actionMode, menu);
        }
    }

    @RequiresApi(17)
    public static class Api17Impl {
        private Api17Impl() {
        }

        public static Context a(@NonNull Context context, @NonNull Configuration configuration) {
            return context.createConfigurationContext(configuration);
        }

        public static void b(@NonNull Configuration configuration, @NonNull Configuration configuration2, @NonNull Configuration configuration3) {
            int i11 = configuration.densityDpi;
            int i12 = configuration2.densityDpi;
            if (i11 != i12) {
                configuration3.densityDpi = i12;
            }
        }

        @DoNotInline
        public static void c(Configuration configuration, Locale locale) {
            configuration.setLayoutDirection(locale);
        }

        @DoNotInline
        public static void d(Configuration configuration, Locale locale) {
            configuration.setLocale(locale);
        }
    }

    @RequiresApi(21)
    public static class Api21Impl {
        private Api21Impl() {
        }

        public static boolean a(PowerManager powerManager) {
            return powerManager.isPowerSaveMode();
        }

        @DoNotInline
        public static String b(Locale locale) {
            return locale.toLanguageTag();
        }
    }

    @RequiresApi(24)
    public static class Api24Impl {
        private Api24Impl() {
        }

        @DoNotInline
        public static void a(@NonNull Configuration configuration, @NonNull Configuration configuration2, @NonNull Configuration configuration3) {
            LocaleList a11 = configuration.getLocales();
            LocaleList a12 = configuration2.getLocales();
            if (!a11.equals(a12)) {
                configuration3.setLocales(a12);
                configuration3.locale = configuration2.locale;
            }
        }

        @DoNotInline
        public static LocaleListCompat b(Configuration configuration) {
            return LocaleListCompat.forLanguageTags(configuration.getLocales().toLanguageTags());
        }

        @DoNotInline
        public static void c(Configuration configuration, LocaleListCompat localeListCompat) {
            configuration.setLocales(LocaleList.forLanguageTags(localeListCompat.toLanguageTags()));
        }

        @DoNotInline
        public static void setDefaultLocales(LocaleListCompat localeListCompat) {
            LocaleList.setDefault(LocaleList.forLanguageTags(localeListCompat.toLanguageTags()));
        }
    }

    @RequiresApi(26)
    public static class Api26Impl {
        private Api26Impl() {
        }

        public static void a(@NonNull Configuration configuration, @NonNull Configuration configuration2, @NonNull Configuration configuration3) {
            if ((configuration.colorMode & 3) != (configuration2.colorMode & 3)) {
                configuration3.colorMode = configuration3.colorMode | (configuration2.colorMode & 3);
            }
            if ((configuration.colorMode & 12) != (configuration2.colorMode & 12)) {
                configuration3.colorMode = configuration3.colorMode | (configuration2.colorMode & 12);
            }
        }
    }

    @RequiresApi(33)
    public static class Api33Impl {
        private Api33Impl() {
        }

        @DoNotInline
        public static OnBackInvokedDispatcher a(Activity activity) {
            return activity.getOnBackInvokedDispatcher();
        }

        @DoNotInline
        public static OnBackInvokedCallback b(Object obj, AppCompatDelegateImpl appCompatDelegateImpl) {
            Objects.requireNonNull(appCompatDelegateImpl);
            a aVar = new a(appCompatDelegateImpl);
            ((OnBackInvokedDispatcher) obj).registerOnBackInvokedCallback(1000000, aVar);
            return aVar;
        }

        @DoNotInline
        public static void c(Object obj, Object obj2) {
            ((OnBackInvokedDispatcher) obj).unregisterOnBackInvokedCallback((OnBackInvokedCallback) obj2);
        }
    }

    public class AppCompatWindowCallback extends WindowCallbackWrapper {
        private ActionBarMenuCallback mActionBarCallback;
        private boolean mDispatchKeyEventBypassEnabled;
        private boolean mOnContentChangedBypassEnabled;
        private boolean mOnPanelClosedBypassEnabled;

        public AppCompatWindowCallback(Window.Callback callback) {
            super(callback);
        }

        public void a(@Nullable ActionBarMenuCallback actionBarMenuCallback) {
            this.mActionBarCallback = actionBarMenuCallback;
        }

        public final android.view.ActionMode b(ActionMode.Callback callback) {
            SupportActionModeWrapper.CallbackWrapper callbackWrapper = new SupportActionModeWrapper.CallbackWrapper(AppCompatDelegateImpl.this.f544d, callback);
            androidx.appcompat.view.ActionMode startSupportActionMode = AppCompatDelegateImpl.this.startSupportActionMode(callbackWrapper);
            if (startSupportActionMode != null) {
                return callbackWrapper.getActionModeWrapper(startSupportActionMode);
            }
            return null;
        }

        /* JADX INFO: finally extract failed */
        public boolean bypassDispatchKeyEvent(Window.Callback callback, KeyEvent keyEvent) {
            try {
                this.mDispatchKeyEventBypassEnabled = true;
                boolean dispatchKeyEvent = callback.dispatchKeyEvent(keyEvent);
                this.mDispatchKeyEventBypassEnabled = false;
                return dispatchKeyEvent;
            } catch (Throwable th2) {
                this.mDispatchKeyEventBypassEnabled = false;
                throw th2;
            }
        }

        /* JADX INFO: finally extract failed */
        public void bypassOnContentChanged(Window.Callback callback) {
            try {
                this.mOnContentChangedBypassEnabled = true;
                callback.onContentChanged();
                this.mOnContentChangedBypassEnabled = false;
            } catch (Throwable th2) {
                this.mOnContentChangedBypassEnabled = false;
                throw th2;
            }
        }

        /* JADX INFO: finally extract failed */
        public void bypassOnPanelClosed(Window.Callback callback, int i11, Menu menu) {
            try {
                this.mOnPanelClosedBypassEnabled = true;
                callback.onPanelClosed(i11, menu);
                this.mOnPanelClosedBypassEnabled = false;
            } catch (Throwable th2) {
                this.mOnPanelClosedBypassEnabled = false;
                throw th2;
            }
        }

        public boolean dispatchKeyEvent(KeyEvent keyEvent) {
            if (this.mDispatchKeyEventBypassEnabled) {
                return getWrapped().dispatchKeyEvent(keyEvent);
            }
            if (AppCompatDelegateImpl.this.r(keyEvent) || super.dispatchKeyEvent(keyEvent)) {
                return true;
            }
            return false;
        }

        public boolean dispatchKeyShortcutEvent(KeyEvent keyEvent) {
            if (super.dispatchKeyShortcutEvent(keyEvent) || AppCompatDelegateImpl.this.D(keyEvent.getKeyCode(), keyEvent)) {
                return true;
            }
            return false;
        }

        public void onContentChanged() {
            if (this.mOnContentChangedBypassEnabled) {
                getWrapped().onContentChanged();
            }
        }

        public boolean onCreatePanelMenu(int i11, Menu menu) {
            if (i11 != 0 || (menu instanceof MenuBuilder)) {
                return super.onCreatePanelMenu(i11, menu);
            }
            return false;
        }

        public View onCreatePanelView(int i11) {
            View onCreatePanelView;
            ActionBarMenuCallback actionBarMenuCallback = this.mActionBarCallback;
            if (actionBarMenuCallback == null || (onCreatePanelView = actionBarMenuCallback.onCreatePanelView(i11)) == null) {
                return super.onCreatePanelView(i11);
            }
            return onCreatePanelView;
        }

        public boolean onMenuOpened(int i11, Menu menu) {
            super.onMenuOpened(i11, menu);
            AppCompatDelegateImpl.this.F(i11);
            return true;
        }

        public void onPanelClosed(int i11, Menu menu) {
            if (this.mOnPanelClosedBypassEnabled) {
                getWrapped().onPanelClosed(i11, menu);
                return;
            }
            super.onPanelClosed(i11, menu);
            AppCompatDelegateImpl.this.G(i11);
        }

        public boolean onPreparePanel(int i11, View view, Menu menu) {
            MenuBuilder menuBuilder;
            if (menu instanceof MenuBuilder) {
                menuBuilder = (MenuBuilder) menu;
            } else {
                menuBuilder = null;
            }
            if (i11 == 0 && menuBuilder == null) {
                return false;
            }
            boolean z11 = true;
            if (menuBuilder != null) {
                menuBuilder.setOverrideVisibleItems(true);
            }
            ActionBarMenuCallback actionBarMenuCallback = this.mActionBarCallback;
            if (actionBarMenuCallback == null || !actionBarMenuCallback.onPreparePanel(i11)) {
                z11 = false;
            }
            if (!z11) {
                z11 = super.onPreparePanel(i11, view, menu);
            }
            if (menuBuilder != null) {
                menuBuilder.setOverrideVisibleItems(false);
            }
            return z11;
        }

        @RequiresApi(24)
        public void onProvideKeyboardShortcuts(List<KeyboardShortcutGroup> list, Menu menu, int i11) {
            MenuBuilder menuBuilder;
            PanelFeatureState x11 = AppCompatDelegateImpl.this.x(0, true);
            if (x11 == null || (menuBuilder = x11.f590j) == null) {
                super.onProvideKeyboardShortcuts(list, menu, i11);
            } else {
                super.onProvideKeyboardShortcuts(list, menuBuilder, i11);
            }
        }

        public android.view.ActionMode onWindowStartingActionMode(ActionMode.Callback callback) {
            return null;
        }

        @RequiresApi(23)
        public android.view.ActionMode onWindowStartingActionMode(ActionMode.Callback callback, int i11) {
            if (!AppCompatDelegateImpl.this.isHandleNativeActionModesEnabled() || i11 != 0) {
                return super.onWindowStartingActionMode(callback, i11);
            }
            return b(callback);
        }
    }

    public class AutoBatteryNightModeManager extends AutoNightModeManager {
        private final PowerManager mPowerManager;

        public AutoBatteryNightModeManager(@NonNull Context context) {
            super();
            this.mPowerManager = (PowerManager) context.getApplicationContext().getSystemService("power");
        }

        public IntentFilter b() {
            IntentFilter intentFilter = new IntentFilter();
            intentFilter.addAction("android.os.action.POWER_SAVE_MODE_CHANGED");
            return intentFilter;
        }

        public int getApplyableNightMode() {
            return Api21Impl.a(this.mPowerManager) ? 2 : 1;
        }

        public void onChange() {
            AppCompatDelegateImpl.this.applyDayNight();
        }
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY})
    @VisibleForTesting
    public abstract class AutoNightModeManager {
        private BroadcastReceiver mReceiver;

        public AutoNightModeManager() {
        }

        public void a() {
            BroadcastReceiver broadcastReceiver = this.mReceiver;
            if (broadcastReceiver != null) {
                try {
                    AppCompatDelegateImpl.this.f544d.unregisterReceiver(broadcastReceiver);
                } catch (IllegalArgumentException unused) {
                }
                this.mReceiver = null;
            }
        }

        @Nullable
        public abstract IntentFilter b();

        public void c() {
            a();
            IntentFilter b11 = b();
            if (b11 != null && b11.countActions() != 0) {
                if (this.mReceiver == null) {
                    this.mReceiver = new BroadcastReceiver() {
                        public void onReceive(Context context, Intent intent) {
                            AutoNightModeManager.this.onChange();
                        }
                    };
                }
                AppCompatDelegateImpl.this.f544d.registerReceiver(this.mReceiver, b11);
            }
        }

        public abstract int getApplyableNightMode();

        public abstract void onChange();
    }

    public class AutoTimeNightModeManager extends AutoNightModeManager {
        private final TwilightManager mTwilightManager;

        public AutoTimeNightModeManager(@NonNull TwilightManager twilightManager) {
            super();
            this.mTwilightManager = twilightManager;
        }

        public IntentFilter b() {
            IntentFilter intentFilter = new IntentFilter();
            intentFilter.addAction("android.intent.action.TIME_SET");
            intentFilter.addAction("android.intent.action.TIMEZONE_CHANGED");
            intentFilter.addAction("android.intent.action.TIME_TICK");
            return intentFilter;
        }

        public int getApplyableNightMode() {
            return this.mTwilightManager.b() ? 2 : 1;
        }

        public void onChange() {
            AppCompatDelegateImpl.this.applyDayNight();
        }
    }

    @RequiresApi(17)
    public static class ContextThemeWrapperCompatApi17Impl {
        private ContextThemeWrapperCompatApi17Impl() {
        }

        public static void a(ContextThemeWrapper contextThemeWrapper, Configuration configuration) {
            contextThemeWrapper.applyOverrideConfiguration(configuration);
        }
    }

    public class ListMenuDecorView extends ContentFrameLayout {
        public ListMenuDecorView(Context context) {
            super(context);
        }

        private boolean isOutOfBounds(int i11, int i12) {
            return i11 < -5 || i12 < -5 || i11 > getWidth() + 5 || i12 > getHeight() + 5;
        }

        public boolean dispatchKeyEvent(KeyEvent keyEvent) {
            if (AppCompatDelegateImpl.this.r(keyEvent) || super.dispatchKeyEvent(keyEvent)) {
                return true;
            }
            return false;
        }

        public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
            if (motionEvent.getAction() != 0 || !isOutOfBounds((int) motionEvent.getX(), (int) motionEvent.getY())) {
                return super.onInterceptTouchEvent(motionEvent);
            }
            AppCompatDelegateImpl.this.o(0);
            return true;
        }

        public void setBackgroundResource(int i11) {
            setBackgroundDrawable(AppCompatResources.getDrawable(getContext(), i11));
        }
    }

    public static final class PanelFeatureState {

        /* renamed from: a  reason: collision with root package name */
        public int f581a;

        /* renamed from: b  reason: collision with root package name */
        public int f582b;

        /* renamed from: c  reason: collision with root package name */
        public int f583c;

        /* renamed from: d  reason: collision with root package name */
        public int f584d;

        /* renamed from: e  reason: collision with root package name */
        public int f585e;

        /* renamed from: f  reason: collision with root package name */
        public int f586f;

        /* renamed from: g  reason: collision with root package name */
        public ViewGroup f587g;

        /* renamed from: h  reason: collision with root package name */
        public View f588h;

        /* renamed from: i  reason: collision with root package name */
        public View f589i;

        /* renamed from: j  reason: collision with root package name */
        public MenuBuilder f590j;

        /* renamed from: k  reason: collision with root package name */
        public ListMenuPresenter f591k;

        /* renamed from: l  reason: collision with root package name */
        public Context f592l;

        /* renamed from: m  reason: collision with root package name */
        public boolean f593m;

        /* renamed from: n  reason: collision with root package name */
        public boolean f594n;

        /* renamed from: o  reason: collision with root package name */
        public boolean f595o;

        /* renamed from: p  reason: collision with root package name */
        public boolean f596p = false;

        /* renamed from: q  reason: collision with root package name */
        public boolean f597q;
        public boolean qwertyMode;

        /* renamed from: r  reason: collision with root package name */
        public Bundle f598r;

        @SuppressLint({"BanParcelableUsage"})
        public static class SavedState implements Parcelable {
            public static final Parcelable.Creator<SavedState> CREATOR = new Parcelable.ClassLoaderCreator<SavedState>() {
                public SavedState[] newArray(int i11) {
                    return new SavedState[i11];
                }

                public SavedState createFromParcel(Parcel parcel, ClassLoader classLoader) {
                    return SavedState.a(parcel, classLoader);
                }

                public SavedState createFromParcel(Parcel parcel) {
                    return SavedState.a(parcel, (ClassLoader) null);
                }
            };

            /* renamed from: b  reason: collision with root package name */
            public int f599b;

            /* renamed from: c  reason: collision with root package name */
            public boolean f600c;

            /* renamed from: d  reason: collision with root package name */
            public Bundle f601d;

            public static SavedState a(Parcel parcel, ClassLoader classLoader) {
                SavedState savedState = new SavedState();
                savedState.f599b = parcel.readInt();
                boolean z11 = true;
                if (parcel.readInt() != 1) {
                    z11 = false;
                }
                savedState.f600c = z11;
                if (z11) {
                    savedState.f601d = parcel.readBundle(classLoader);
                }
                return savedState;
            }

            public int describeContents() {
                return 0;
            }

            public void writeToParcel(Parcel parcel, int i11) {
                parcel.writeInt(this.f599b);
                parcel.writeInt(this.f600c ? 1 : 0);
                if (this.f600c) {
                    parcel.writeBundle(this.f601d);
                }
            }
        }

        public PanelFeatureState(int i11) {
            this.f581a = i11;
        }

        public MenuView a(MenuPresenter.Callback callback) {
            if (this.f590j == null) {
                return null;
            }
            if (this.f591k == null) {
                ListMenuPresenter listMenuPresenter = new ListMenuPresenter(this.f592l, R.layout.abc_list_menu_item_layout);
                this.f591k = listMenuPresenter;
                listMenuPresenter.setCallback(callback);
                this.f590j.addMenuPresenter(this.f591k);
            }
            return this.f591k.getMenuView(this.f587g);
        }

        public void b(MenuBuilder menuBuilder) {
            ListMenuPresenter listMenuPresenter;
            MenuBuilder menuBuilder2 = this.f590j;
            if (menuBuilder != menuBuilder2) {
                if (menuBuilder2 != null) {
                    menuBuilder2.removeMenuPresenter(this.f591k);
                }
                this.f590j = menuBuilder;
                if (menuBuilder != null && (listMenuPresenter = this.f591k) != null) {
                    menuBuilder.addMenuPresenter(listMenuPresenter);
                }
            }
        }

        public void c(Context context) {
            TypedValue typedValue = new TypedValue();
            Resources.Theme newTheme = context.getResources().newTheme();
            newTheme.setTo(context.getTheme());
            newTheme.resolveAttribute(R.attr.actionBarPopupTheme, typedValue, true);
            int i11 = typedValue.resourceId;
            if (i11 != 0) {
                newTheme.applyStyle(i11, true);
            }
            newTheme.resolveAttribute(R.attr.panelMenuListTheme, typedValue, true);
            int i12 = typedValue.resourceId;
            if (i12 != 0) {
                newTheme.applyStyle(i12, true);
            } else {
                newTheme.applyStyle(R.style.Theme_AppCompat_CompactMenu, true);
            }
            androidx.appcompat.view.ContextThemeWrapper contextThemeWrapper = new androidx.appcompat.view.ContextThemeWrapper(context, 0);
            contextThemeWrapper.getTheme().setTo(newTheme);
            this.f592l = contextThemeWrapper;
            TypedArray obtainStyledAttributes = contextThemeWrapper.obtainStyledAttributes(R.styleable.AppCompatTheme);
            this.f582b = obtainStyledAttributes.getResourceId(R.styleable.AppCompatTheme_panelBackground, 0);
            this.f586f = obtainStyledAttributes.getResourceId(R.styleable.AppCompatTheme_android_windowAnimationStyle, 0);
            obtainStyledAttributes.recycle();
        }

        public void clearMenuPresenters() {
            MenuBuilder menuBuilder = this.f590j;
            if (menuBuilder != null) {
                menuBuilder.removeMenuPresenter(this.f591k);
            }
            this.f591k = null;
        }

        public boolean hasPanelItems() {
            if (this.f588h == null) {
                return false;
            }
            if (this.f589i != null) {
                return true;
            }
            if (this.f591k.getAdapter().getCount() > 0) {
                return true;
            }
            return false;
        }
    }

    public final class PanelMenuPresenterCallback implements MenuPresenter.Callback {
        public PanelMenuPresenterCallback() {
        }

        public void onCloseMenu(@NonNull MenuBuilder menuBuilder, boolean z11) {
            boolean z12;
            MenuBuilder rootMenu = menuBuilder.getRootMenu();
            if (rootMenu != menuBuilder) {
                z12 = true;
            } else {
                z12 = false;
            }
            AppCompatDelegateImpl appCompatDelegateImpl = AppCompatDelegateImpl.this;
            if (z12) {
                menuBuilder = rootMenu;
            }
            PanelFeatureState u11 = appCompatDelegateImpl.u(menuBuilder);
            if (u11 == null) {
                return;
            }
            if (z12) {
                AppCompatDelegateImpl.this.m(u11.f581a, u11, rootMenu);
                AppCompatDelegateImpl.this.p(u11, true);
                return;
            }
            AppCompatDelegateImpl.this.p(u11, z11);
        }

        public boolean onOpenSubMenu(@NonNull MenuBuilder menuBuilder) {
            Window.Callback z11;
            if (menuBuilder != menuBuilder.getRootMenu()) {
                return true;
            }
            AppCompatDelegateImpl appCompatDelegateImpl = AppCompatDelegateImpl.this;
            if (!appCompatDelegateImpl.f555o || (z11 = appCompatDelegateImpl.z()) == null || AppCompatDelegateImpl.this.f560t) {
                return true;
            }
            z11.onMenuOpened(108, menuBuilder);
            return true;
        }
    }

    public AppCompatDelegateImpl(Activity activity, AppCompatCallback appCompatCallback) {
        this(activity, (Window) null, appCompatCallback, activity);
    }

    private boolean applyApplicationSpecificConfig(boolean z11) {
        return applyApplicationSpecificConfig(z11, true);
    }

    private void applyFixedSizeWindow() {
        ContentFrameLayout contentFrameLayout = (ContentFrameLayout) this.f554n.findViewById(16908290);
        View decorView = this.f545e.getDecorView();
        contentFrameLayout.setDecorPadding(decorView.getPaddingLeft(), decorView.getPaddingTop(), decorView.getPaddingRight(), decorView.getPaddingBottom());
        TypedArray obtainStyledAttributes = this.f544d.obtainStyledAttributes(R.styleable.AppCompatTheme);
        obtainStyledAttributes.getValue(R.styleable.AppCompatTheme_windowMinWidthMajor, contentFrameLayout.getMinWidthMajor());
        obtainStyledAttributes.getValue(R.styleable.AppCompatTheme_windowMinWidthMinor, contentFrameLayout.getMinWidthMinor());
        int i11 = R.styleable.AppCompatTheme_windowFixedWidthMajor;
        if (obtainStyledAttributes.hasValue(i11)) {
            obtainStyledAttributes.getValue(i11, contentFrameLayout.getFixedWidthMajor());
        }
        int i12 = R.styleable.AppCompatTheme_windowFixedWidthMinor;
        if (obtainStyledAttributes.hasValue(i12)) {
            obtainStyledAttributes.getValue(i12, contentFrameLayout.getFixedWidthMinor());
        }
        int i13 = R.styleable.AppCompatTheme_windowFixedHeightMajor;
        if (obtainStyledAttributes.hasValue(i13)) {
            obtainStyledAttributes.getValue(i13, contentFrameLayout.getFixedHeightMajor());
        }
        int i14 = R.styleable.AppCompatTheme_windowFixedHeightMinor;
        if (obtainStyledAttributes.hasValue(i14)) {
            obtainStyledAttributes.getValue(i14, contentFrameLayout.getFixedHeightMinor());
        }
        obtainStyledAttributes.recycle();
        contentFrameLayout.requestLayout();
    }

    private void attachToWindow(@NonNull Window window) {
        if (this.f545e == null) {
            Window.Callback callback = window.getCallback();
            if (!(callback instanceof AppCompatWindowCallback)) {
                AppCompatWindowCallback appCompatWindowCallback = new AppCompatWindowCallback(callback);
                this.mAppCompatWindowCallback = appCompatWindowCallback;
                window.setCallback(appCompatWindowCallback);
                TintTypedArray obtainStyledAttributes = TintTypedArray.obtainStyledAttributes(this.f544d, (AttributeSet) null, sWindowBackgroundStyleable);
                Drawable drawableIfKnown = obtainStyledAttributes.getDrawableIfKnown(0);
                if (drawableIfKnown != null) {
                    window.setBackgroundDrawable(drawableIfKnown);
                }
                obtainStyledAttributes.recycle();
                this.f545e = window;
                if (Build.VERSION.SDK_INT >= 33 && this.mDispatcher == null) {
                    setOnBackInvokedDispatcher((OnBackInvokedDispatcher) null);
                    return;
                }
                return;
            }
            throw new IllegalStateException("AppCompat has already installed itself into the Window");
        }
        throw new IllegalStateException("AppCompat has already installed itself into the Window");
    }

    private int calculateNightMode() {
        int i11 = this.mLocalNightMode;
        return i11 != -100 ? i11 : AppCompatDelegate.getDefaultNightMode();
    }

    private void cleanupAutoManagers() {
        AutoNightModeManager autoNightModeManager = this.mAutoTimeNightModeManager;
        if (autoNightModeManager != null) {
            autoNightModeManager.a();
        }
        AutoNightModeManager autoNightModeManager2 = this.mAutoBatteryNightModeManager;
        if (autoNightModeManager2 != null) {
            autoNightModeManager2.a();
        }
    }

    @NonNull
    private Configuration createOverrideAppConfiguration(@NonNull Context context, int i11, @Nullable LocaleListCompat localeListCompat, @Nullable Configuration configuration, boolean z11) {
        int i12;
        if (i11 == 1) {
            i12 = 16;
        } else if (i11 == 2) {
            i12 = 32;
        } else if (z11) {
            i12 = 0;
        } else {
            i12 = context.getApplicationContext().getResources().getConfiguration().uiMode & 48;
        }
        Configuration configuration2 = new Configuration();
        configuration2.fontScale = 0.0f;
        if (configuration != null) {
            configuration2.setTo(configuration);
        }
        configuration2.uiMode = i12 | (configuration2.uiMode & -49);
        if (localeListCompat != null) {
            J(configuration2, localeListCompat);
        }
        return configuration2;
    }

    private ViewGroup createSubDecor() {
        ViewGroup viewGroup;
        Context context;
        TypedArray obtainStyledAttributes = this.f544d.obtainStyledAttributes(R.styleable.AppCompatTheme);
        int i11 = R.styleable.AppCompatTheme_windowActionBar;
        if (obtainStyledAttributes.hasValue(i11)) {
            if (obtainStyledAttributes.getBoolean(R.styleable.AppCompatTheme_windowNoTitle, false)) {
                requestWindowFeature(1);
            } else if (obtainStyledAttributes.getBoolean(i11, false)) {
                requestWindowFeature(108);
            }
            if (obtainStyledAttributes.getBoolean(R.styleable.AppCompatTheme_windowActionBarOverlay, false)) {
                requestWindowFeature(109);
            }
            if (obtainStyledAttributes.getBoolean(R.styleable.AppCompatTheme_windowActionModeOverlay, false)) {
                requestWindowFeature(10);
            }
            this.f558r = obtainStyledAttributes.getBoolean(R.styleable.AppCompatTheme_android_windowIsFloating, false);
            obtainStyledAttributes.recycle();
            ensureWindow();
            this.f545e.getDecorView();
            LayoutInflater from = LayoutInflater.from(this.f544d);
            if (this.f559s) {
                viewGroup = this.f557q ? (ViewGroup) from.inflate(R.layout.abc_screen_simple_overlay_action_mode, (ViewGroup) null) : (ViewGroup) from.inflate(R.layout.abc_screen_simple, (ViewGroup) null);
            } else if (this.f558r) {
                viewGroup = (ViewGroup) from.inflate(R.layout.abc_dialog_title_material, (ViewGroup) null);
                this.f556p = false;
                this.f555o = false;
            } else if (this.f555o) {
                TypedValue typedValue = new TypedValue();
                this.f544d.getTheme().resolveAttribute(R.attr.actionBarTheme, typedValue, true);
                if (typedValue.resourceId != 0) {
                    context = new androidx.appcompat.view.ContextThemeWrapper(this.f544d, typedValue.resourceId);
                } else {
                    context = this.f544d;
                }
                viewGroup = (ViewGroup) LayoutInflater.from(context).inflate(R.layout.abc_screen_toolbar, (ViewGroup) null);
                DecorContentParent decorContentParent = (DecorContentParent) viewGroup.findViewById(R.id.decor_content_parent);
                this.mDecorContentParent = decorContentParent;
                decorContentParent.setWindowCallback(z());
                if (this.f556p) {
                    this.mDecorContentParent.initFeature(109);
                }
                if (this.mFeatureProgress) {
                    this.mDecorContentParent.initFeature(2);
                }
                if (this.mFeatureIndeterminateProgress) {
                    this.mDecorContentParent.initFeature(5);
                }
            } else {
                viewGroup = null;
            }
            if (viewGroup != null) {
                ViewCompat.setOnApplyWindowInsetsListener(viewGroup, new OnApplyWindowInsetsListener() {
                    public WindowInsetsCompat onApplyWindowInsets(View view, WindowInsetsCompat windowInsetsCompat) {
                        int systemWindowInsetTop = windowInsetsCompat.getSystemWindowInsetTop();
                        int P = AppCompatDelegateImpl.this.P(windowInsetsCompat, (Rect) null);
                        if (systemWindowInsetTop != P) {
                            windowInsetsCompat = windowInsetsCompat.replaceSystemWindowInsets(windowInsetsCompat.getSystemWindowInsetLeft(), P, windowInsetsCompat.getSystemWindowInsetRight(), windowInsetsCompat.getSystemWindowInsetBottom());
                        }
                        return ViewCompat.onApplyWindowInsets(view, windowInsetsCompat);
                    }
                });
                if (this.mDecorContentParent == null) {
                    this.mTitleView = (TextView) viewGroup.findViewById(R.id.title);
                }
                ViewUtils.makeOptionalFitsSystemWindows(viewGroup);
                ContentFrameLayout contentFrameLayout = (ContentFrameLayout) viewGroup.findViewById(R.id.action_bar_activity_content);
                ViewGroup viewGroup2 = (ViewGroup) this.f545e.findViewById(16908290);
                if (viewGroup2 != null) {
                    while (viewGroup2.getChildCount() > 0) {
                        View childAt = viewGroup2.getChildAt(0);
                        viewGroup2.removeViewAt(0);
                        contentFrameLayout.addView(childAt);
                    }
                    viewGroup2.setId(-1);
                    contentFrameLayout.setId(16908290);
                    if (viewGroup2 instanceof FrameLayout) {
                        ((FrameLayout) viewGroup2).setForeground((Drawable) null);
                    }
                }
                this.f545e.setContentView(viewGroup);
                contentFrameLayout.setAttachListener(new ContentFrameLayout.OnAttachListener() {
                    public void onAttachedFromWindow() {
                    }

                    public void onDetachedFromWindow() {
                        AppCompatDelegateImpl.this.q();
                    }
                });
                return viewGroup;
            }
            throw new IllegalArgumentException("AppCompat does not support the current theme features: { windowActionBar: " + this.f555o + ", windowActionBarOverlay: " + this.f556p + ", android:windowIsFloating: " + this.f558r + ", windowActionModeOverlay: " + this.f557q + ", windowNoTitle: " + this.f559s + " }");
        }
        obtainStyledAttributes.recycle();
        throw new IllegalStateException("You need to use a Theme.AppCompat theme (or descendant) with this activity.");
    }

    private void ensureSubDecor() {
        if (!this.mSubDecorInstalled) {
            this.f554n = createSubDecor();
            CharSequence y11 = y();
            if (!TextUtils.isEmpty(y11)) {
                DecorContentParent decorContentParent = this.mDecorContentParent;
                if (decorContentParent != null) {
                    decorContentParent.setWindowTitle(y11);
                } else if (I() != null) {
                    I().setWindowTitle(y11);
                } else {
                    TextView textView = this.mTitleView;
                    if (textView != null) {
                        textView.setText(y11);
                    }
                }
            }
            applyFixedSizeWindow();
            H(this.f554n);
            this.mSubDecorInstalled = true;
            PanelFeatureState x11 = x(0, false);
            if (this.f560t) {
                return;
            }
            if (x11 == null || x11.f590j == null) {
                invalidatePanelMenu(108);
            }
        }
    }

    private void ensureWindow() {
        if (this.f545e == null) {
            Object obj = this.f543c;
            if (obj instanceof Activity) {
                attachToWindow(((Activity) obj).getWindow());
            }
        }
        if (this.f545e == null) {
            throw new IllegalStateException("We have not been given a Window");
        }
    }

    @NonNull
    private static Configuration generateConfigDelta(@NonNull Configuration configuration, @Nullable Configuration configuration2) {
        Configuration configuration3 = new Configuration();
        configuration3.fontScale = 0.0f;
        if (!(configuration2 == null || configuration.diff(configuration2) == 0)) {
            float f11 = configuration.fontScale;
            float f12 = configuration2.fontScale;
            if (f11 != f12) {
                configuration3.fontScale = f12;
            }
            int i11 = configuration.mcc;
            int i12 = configuration2.mcc;
            if (i11 != i12) {
                configuration3.mcc = i12;
            }
            int i13 = configuration.mnc;
            int i14 = configuration2.mnc;
            if (i13 != i14) {
                configuration3.mnc = i14;
            }
            int i15 = Build.VERSION.SDK_INT;
            if (i15 >= 24) {
                Api24Impl.a(configuration, configuration2, configuration3);
            } else if (!ObjectsCompat.equals(configuration.locale, configuration2.locale)) {
                configuration3.locale = configuration2.locale;
            }
            int i16 = configuration.touchscreen;
            int i17 = configuration2.touchscreen;
            if (i16 != i17) {
                configuration3.touchscreen = i17;
            }
            int i18 = configuration.keyboard;
            int i19 = configuration2.keyboard;
            if (i18 != i19) {
                configuration3.keyboard = i19;
            }
            int i21 = configuration.keyboardHidden;
            int i22 = configuration2.keyboardHidden;
            if (i21 != i22) {
                configuration3.keyboardHidden = i22;
            }
            int i23 = configuration.navigation;
            int i24 = configuration2.navigation;
            if (i23 != i24) {
                configuration3.navigation = i24;
            }
            int i25 = configuration.navigationHidden;
            int i26 = configuration2.navigationHidden;
            if (i25 != i26) {
                configuration3.navigationHidden = i26;
            }
            int i27 = configuration.orientation;
            int i28 = configuration2.orientation;
            if (i27 != i28) {
                configuration3.orientation = i28;
            }
            int i29 = configuration.screenLayout & 15;
            int i31 = configuration2.screenLayout;
            if (i29 != (i31 & 15)) {
                configuration3.screenLayout |= i31 & 15;
            }
            int i32 = configuration.screenLayout & 192;
            int i33 = configuration2.screenLayout;
            if (i32 != (i33 & 192)) {
                configuration3.screenLayout |= i33 & 192;
            }
            int i34 = configuration.screenLayout & 48;
            int i35 = configuration2.screenLayout;
            if (i34 != (i35 & 48)) {
                configuration3.screenLayout |= i35 & 48;
            }
            int i36 = configuration.screenLayout & ValidationPath.MAX_PATH_LENGTH_BYTES;
            int i37 = configuration2.screenLayout;
            if (i36 != (i37 & ValidationPath.MAX_PATH_LENGTH_BYTES)) {
                configuration3.screenLayout |= i37 & ValidationPath.MAX_PATH_LENGTH_BYTES;
            }
            if (i15 >= 26) {
                Api26Impl.a(configuration, configuration2, configuration3);
            }
            int i38 = configuration.uiMode & 15;
            int i39 = configuration2.uiMode;
            if (i38 != (i39 & 15)) {
                configuration3.uiMode |= i39 & 15;
            }
            int i41 = configuration.uiMode & 48;
            int i42 = configuration2.uiMode;
            if (i41 != (i42 & 48)) {
                configuration3.uiMode |= i42 & 48;
            }
            int i43 = configuration.screenWidthDp;
            int i44 = configuration2.screenWidthDp;
            if (i43 != i44) {
                configuration3.screenWidthDp = i44;
            }
            int i45 = configuration.screenHeightDp;
            int i46 = configuration2.screenHeightDp;
            if (i45 != i46) {
                configuration3.screenHeightDp = i46;
            }
            int i47 = configuration.smallestScreenWidthDp;
            int i48 = configuration2.smallestScreenWidthDp;
            if (i47 != i48) {
                configuration3.smallestScreenWidthDp = i48;
            }
            Api17Impl.b(configuration, configuration2, configuration3);
        }
        return configuration3;
    }

    private int getActivityHandlesConfigChangesFlags(Context context) {
        int i11;
        if (!this.mActivityHandlesConfigFlagsChecked && (this.f543c instanceof Activity)) {
            PackageManager packageManager = context.getPackageManager();
            if (packageManager == null) {
                return 0;
            }
            try {
                int i12 = Build.VERSION.SDK_INT;
                if (i12 >= 29) {
                    i11 = 269221888;
                } else if (i12 >= 24) {
                    i11 = 786432;
                } else {
                    i11 = 0;
                }
                ActivityInfo activityInfo = packageManager.getActivityInfo(new ComponentName(context, this.f543c.getClass()), i11);
                if (activityInfo != null) {
                    this.mActivityHandlesConfigFlags = activityInfo.configChanges;
                }
            } catch (PackageManager.NameNotFoundException unused) {
                this.mActivityHandlesConfigFlags = 0;
            }
        }
        this.mActivityHandlesConfigFlagsChecked = true;
        return this.mActivityHandlesConfigFlags;
    }

    private AutoNightModeManager getAutoBatteryNightModeManager(@NonNull Context context) {
        if (this.mAutoBatteryNightModeManager == null) {
            this.mAutoBatteryNightModeManager = new AutoBatteryNightModeManager(context);
        }
        return this.mAutoBatteryNightModeManager;
    }

    private AutoNightModeManager getAutoTimeNightModeManager(@NonNull Context context) {
        if (this.mAutoTimeNightModeManager == null) {
            this.mAutoTimeNightModeManager = new AutoTimeNightModeManager(TwilightManager.a(context));
        }
        return this.mAutoTimeNightModeManager;
    }

    private void initWindowDecorActionBar() {
        ensureSubDecor();
        if (this.f555o && this.f547g == null) {
            Object obj = this.f543c;
            if (obj instanceof Activity) {
                this.f547g = new WindowDecorActionBar((Activity) this.f543c, this.f556p);
            } else if (obj instanceof Dialog) {
                this.f547g = new WindowDecorActionBar((Dialog) this.f543c);
            }
            ActionBar actionBar = this.f547g;
            if (actionBar != null) {
                actionBar.setDefaultDisplayHomeAsUpEnabled(this.mEnableDefaultActionBarUp);
            }
        }
    }

    private boolean initializePanelContent(PanelFeatureState panelFeatureState) {
        View view = panelFeatureState.f589i;
        if (view != null) {
            panelFeatureState.f588h = view;
            return true;
        } else if (panelFeatureState.f590j == null) {
            return false;
        } else {
            if (this.mPanelMenuPresenterCallback == null) {
                this.mPanelMenuPresenterCallback = new PanelMenuPresenterCallback();
            }
            View view2 = (View) panelFeatureState.a(this.mPanelMenuPresenterCallback);
            panelFeatureState.f588h = view2;
            if (view2 != null) {
                return true;
            }
            return false;
        }
    }

    private boolean initializePanelDecor(PanelFeatureState panelFeatureState) {
        panelFeatureState.c(v());
        panelFeatureState.f587g = new ListMenuDecorView(panelFeatureState.f592l);
        panelFeatureState.f583c = 81;
        return true;
    }

    private boolean initializePanelMenu(PanelFeatureState panelFeatureState) {
        Resources.Theme theme;
        Context context = this.f544d;
        int i11 = panelFeatureState.f581a;
        if ((i11 == 0 || i11 == 108) && this.mDecorContentParent != null) {
            TypedValue typedValue = new TypedValue();
            Resources.Theme theme2 = context.getTheme();
            theme2.resolveAttribute(R.attr.actionBarTheme, typedValue, true);
            if (typedValue.resourceId != 0) {
                theme = context.getResources().newTheme();
                theme.setTo(theme2);
                theme.applyStyle(typedValue.resourceId, true);
                theme.resolveAttribute(R.attr.actionBarWidgetTheme, typedValue, true);
            } else {
                theme2.resolveAttribute(R.attr.actionBarWidgetTheme, typedValue, true);
                theme = null;
            }
            if (typedValue.resourceId != 0) {
                if (theme == null) {
                    theme = context.getResources().newTheme();
                    theme.setTo(theme2);
                }
                theme.applyStyle(typedValue.resourceId, true);
            }
            if (theme != null) {
                androidx.appcompat.view.ContextThemeWrapper contextThemeWrapper = new androidx.appcompat.view.ContextThemeWrapper(context, 0);
                contextThemeWrapper.getTheme().setTo(theme);
                context = contextThemeWrapper;
            }
        }
        MenuBuilder menuBuilder = new MenuBuilder(context);
        menuBuilder.setCallback(this);
        panelFeatureState.b(menuBuilder);
        return true;
    }

    private void invalidatePanelMenu(int i11) {
        this.f562v = (1 << i11) | this.f562v;
        if (!this.f561u) {
            ViewCompat.postOnAnimation(this.f545e.getDecorView(), this.mInvalidatePanelMenuRunnable);
            this.f561u = true;
        }
    }

    private boolean onKeyDownPanel(int i11, KeyEvent keyEvent) {
        if (keyEvent.getRepeatCount() != 0) {
            return false;
        }
        PanelFeatureState x11 = x(i11, true);
        if (!x11.f595o) {
            return preparePanel(x11, keyEvent);
        }
        return false;
    }

    /* JADX WARNING: Removed duplicated region for block: B:34:0x006a  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private boolean onKeyUpPanel(int r5, android.view.KeyEvent r6) {
        /*
            r4 = this;
            androidx.appcompat.view.ActionMode r0 = r4.f549i
            r1 = 0
            if (r0 == 0) goto L_0x0006
            return r1
        L_0x0006:
            r0 = 1
            androidx.appcompat.app.AppCompatDelegateImpl$PanelFeatureState r2 = r4.x(r5, r0)
            if (r5 != 0) goto L_0x0043
            androidx.appcompat.widget.DecorContentParent r5 = r4.mDecorContentParent
            if (r5 == 0) goto L_0x0043
            boolean r5 = r5.canShowOverflowMenu()
            if (r5 == 0) goto L_0x0043
            android.content.Context r5 = r4.f544d
            android.view.ViewConfiguration r5 = android.view.ViewConfiguration.get(r5)
            boolean r5 = r5.hasPermanentMenuKey()
            if (r5 != 0) goto L_0x0043
            androidx.appcompat.widget.DecorContentParent r5 = r4.mDecorContentParent
            boolean r5 = r5.isOverflowMenuShowing()
            if (r5 != 0) goto L_0x003c
            boolean r5 = r4.f560t
            if (r5 != 0) goto L_0x0062
            boolean r5 = r4.preparePanel(r2, r6)
            if (r5 == 0) goto L_0x0062
            androidx.appcompat.widget.DecorContentParent r5 = r4.mDecorContentParent
            boolean r0 = r5.showOverflowMenu()
            goto L_0x0068
        L_0x003c:
            androidx.appcompat.widget.DecorContentParent r5 = r4.mDecorContentParent
            boolean r0 = r5.hideOverflowMenu()
            goto L_0x0068
        L_0x0043:
            boolean r5 = r2.f595o
            if (r5 != 0) goto L_0x0064
            boolean r3 = r2.f594n
            if (r3 == 0) goto L_0x004c
            goto L_0x0064
        L_0x004c:
            boolean r5 = r2.f593m
            if (r5 == 0) goto L_0x0062
            boolean r5 = r2.f597q
            if (r5 == 0) goto L_0x005b
            r2.f593m = r1
            boolean r5 = r4.preparePanel(r2, r6)
            goto L_0x005c
        L_0x005b:
            r5 = r0
        L_0x005c:
            if (r5 == 0) goto L_0x0062
            r4.openPanel(r2, r6)
            goto L_0x0068
        L_0x0062:
            r0 = r1
            goto L_0x0068
        L_0x0064:
            r4.p(r2, r0)
            r0 = r5
        L_0x0068:
            if (r0 == 0) goto L_0x0085
            android.content.Context r5 = r4.f544d
            android.content.Context r5 = r5.getApplicationContext()
            java.lang.String r6 = "audio"
            java.lang.Object r5 = r5.getSystemService(r6)
            android.media.AudioManager r5 = (android.media.AudioManager) r5
            if (r5 == 0) goto L_0x007e
            r5.playSoundEffect(r1)
            goto L_0x0085
        L_0x007e:
            java.lang.String r5 = "AppCompatDelegate"
            java.lang.String r6 = "Couldn't get audio manager"
            android.util.Log.w(r5, r6)
        L_0x0085:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.appcompat.app.AppCompatDelegateImpl.onKeyUpPanel(int, android.view.KeyEvent):boolean");
    }

    /* JADX WARNING: Removed duplicated region for block: B:61:0x00f2  */
    /* JADX WARNING: Removed duplicated region for block: B:66:? A[RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void openPanel(androidx.appcompat.app.AppCompatDelegateImpl.PanelFeatureState r13, android.view.KeyEvent r14) {
        /*
            r12 = this;
            boolean r0 = r13.f595o
            if (r0 != 0) goto L_0x00f8
            boolean r0 = r12.f560t
            if (r0 == 0) goto L_0x000a
            goto L_0x00f8
        L_0x000a:
            int r0 = r13.f581a
            r1 = 0
            r2 = 1
            if (r0 != 0) goto L_0x0027
            android.content.Context r0 = r12.f544d
            android.content.res.Resources r0 = r0.getResources()
            android.content.res.Configuration r0 = r0.getConfiguration()
            int r0 = r0.screenLayout
            r0 = r0 & 15
            r3 = 4
            if (r0 != r3) goto L_0x0023
            r0 = r2
            goto L_0x0024
        L_0x0023:
            r0 = r1
        L_0x0024:
            if (r0 == 0) goto L_0x0027
            return
        L_0x0027:
            android.view.Window$Callback r0 = r12.z()
            if (r0 == 0) goto L_0x003b
            int r3 = r13.f581a
            androidx.appcompat.view.menu.MenuBuilder r4 = r13.f590j
            boolean r0 = r0.onMenuOpened(r3, r4)
            if (r0 != 0) goto L_0x003b
            r12.p(r13, r2)
            return
        L_0x003b:
            android.content.Context r0 = r12.f544d
            java.lang.String r3 = "window"
            java.lang.Object r0 = r0.getSystemService(r3)
            android.view.WindowManager r0 = (android.view.WindowManager) r0
            if (r0 != 0) goto L_0x0048
            return
        L_0x0048:
            boolean r14 = r12.preparePanel(r13, r14)
            if (r14 != 0) goto L_0x004f
            return
        L_0x004f:
            android.view.ViewGroup r14 = r13.f587g
            r3 = -2
            if (r14 == 0) goto L_0x006a
            boolean r4 = r13.f596p
            if (r4 == 0) goto L_0x0059
            goto L_0x006a
        L_0x0059:
            android.view.View r14 = r13.f589i
            if (r14 == 0) goto L_0x00cc
            android.view.ViewGroup$LayoutParams r14 = r14.getLayoutParams()
            if (r14 == 0) goto L_0x00cc
            int r14 = r14.width
            r4 = -1
            if (r14 != r4) goto L_0x00cc
            r5 = r4
            goto L_0x00cd
        L_0x006a:
            if (r14 != 0) goto L_0x0077
            boolean r14 = r12.initializePanelDecor(r13)
            if (r14 == 0) goto L_0x0076
            android.view.ViewGroup r14 = r13.f587g
            if (r14 != 0) goto L_0x0086
        L_0x0076:
            return
        L_0x0077:
            boolean r4 = r13.f596p
            if (r4 == 0) goto L_0x0086
            int r14 = r14.getChildCount()
            if (r14 <= 0) goto L_0x0086
            android.view.ViewGroup r14 = r13.f587g
            r14.removeAllViews()
        L_0x0086:
            boolean r14 = r12.initializePanelContent(r13)
            if (r14 == 0) goto L_0x00f6
            boolean r14 = r13.hasPanelItems()
            if (r14 != 0) goto L_0x0093
            goto L_0x00f6
        L_0x0093:
            android.view.View r14 = r13.f588h
            android.view.ViewGroup$LayoutParams r14 = r14.getLayoutParams()
            if (r14 != 0) goto L_0x00a0
            android.view.ViewGroup$LayoutParams r14 = new android.view.ViewGroup$LayoutParams
            r14.<init>(r3, r3)
        L_0x00a0:
            int r4 = r13.f582b
            android.view.ViewGroup r5 = r13.f587g
            r5.setBackgroundResource(r4)
            android.view.View r4 = r13.f588h
            android.view.ViewParent r4 = r4.getParent()
            boolean r5 = r4 instanceof android.view.ViewGroup
            if (r5 == 0) goto L_0x00b8
            android.view.ViewGroup r4 = (android.view.ViewGroup) r4
            android.view.View r5 = r13.f588h
            r4.removeView(r5)
        L_0x00b8:
            android.view.ViewGroup r4 = r13.f587g
            android.view.View r5 = r13.f588h
            r4.addView(r5, r14)
            android.view.View r14 = r13.f588h
            boolean r14 = r14.hasFocus()
            if (r14 != 0) goto L_0x00cc
            android.view.View r14 = r13.f588h
            r14.requestFocus()
        L_0x00cc:
            r5 = r3
        L_0x00cd:
            r13.f594n = r1
            android.view.WindowManager$LayoutParams r14 = new android.view.WindowManager$LayoutParams
            r6 = -2
            int r7 = r13.f584d
            int r8 = r13.f585e
            r9 = 1002(0x3ea, float:1.404E-42)
            r10 = 8519680(0x820000, float:1.1938615E-38)
            r11 = -3
            r4 = r14
            r4.<init>(r5, r6, r7, r8, r9, r10, r11)
            int r1 = r13.f583c
            r14.gravity = r1
            int r1 = r13.f586f
            r14.windowAnimations = r1
            android.view.ViewGroup r1 = r13.f587g
            r0.addView(r1, r14)
            r13.f595o = r2
            int r13 = r13.f581a
            if (r13 != 0) goto L_0x00f5
            r12.O()
        L_0x00f5:
            return
        L_0x00f6:
            r13.f596p = r2
        L_0x00f8:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.appcompat.app.AppCompatDelegateImpl.openPanel(androidx.appcompat.app.AppCompatDelegateImpl$PanelFeatureState, android.view.KeyEvent):void");
    }

    private boolean performPanelShortcut(PanelFeatureState panelFeatureState, int i11, KeyEvent keyEvent, int i12) {
        MenuBuilder menuBuilder;
        boolean z11 = false;
        if (keyEvent.isSystem()) {
            return false;
        }
        if ((panelFeatureState.f593m || preparePanel(panelFeatureState, keyEvent)) && (menuBuilder = panelFeatureState.f590j) != null) {
            z11 = menuBuilder.performShortcut(i11, keyEvent, i12);
        }
        if (z11 && (i12 & 1) == 0 && this.mDecorContentParent == null) {
            p(panelFeatureState, true);
        }
        return z11;
    }

    private boolean preparePanel(PanelFeatureState panelFeatureState, KeyEvent keyEvent) {
        boolean z11;
        int i11;
        boolean z12;
        DecorContentParent decorContentParent;
        DecorContentParent decorContentParent2;
        DecorContentParent decorContentParent3;
        if (this.f560t) {
            return false;
        }
        if (panelFeatureState.f593m) {
            return true;
        }
        PanelFeatureState panelFeatureState2 = this.mPreparedPanel;
        if (!(panelFeatureState2 == null || panelFeatureState2 == panelFeatureState)) {
            p(panelFeatureState2, false);
        }
        Window.Callback z13 = z();
        if (z13 != null) {
            panelFeatureState.f589i = z13.onCreatePanelView(panelFeatureState.f581a);
        }
        int i12 = panelFeatureState.f581a;
        if (i12 == 0 || i12 == 108) {
            z11 = true;
        } else {
            z11 = false;
        }
        if (z11 && (decorContentParent3 = this.mDecorContentParent) != null) {
            decorContentParent3.setMenuPrepared();
        }
        if (panelFeatureState.f589i == null && (!z11 || !(I() instanceof ToolbarActionBar))) {
            MenuBuilder menuBuilder = panelFeatureState.f590j;
            if (menuBuilder == null || panelFeatureState.f597q) {
                if (menuBuilder == null && (!initializePanelMenu(panelFeatureState) || panelFeatureState.f590j == null)) {
                    return false;
                }
                if (z11 && this.mDecorContentParent != null) {
                    if (this.mActionMenuPresenterCallback == null) {
                        this.mActionMenuPresenterCallback = new ActionMenuPresenterCallback();
                    }
                    this.mDecorContentParent.setMenu(panelFeatureState.f590j, this.mActionMenuPresenterCallback);
                }
                panelFeatureState.f590j.stopDispatchingItemsChanged();
                if (!z13.onCreatePanelMenu(panelFeatureState.f581a, panelFeatureState.f590j)) {
                    panelFeatureState.b((MenuBuilder) null);
                    if (z11 && (decorContentParent2 = this.mDecorContentParent) != null) {
                        decorContentParent2.setMenu((Menu) null, this.mActionMenuPresenterCallback);
                    }
                    return false;
                }
                panelFeatureState.f597q = false;
            }
            panelFeatureState.f590j.stopDispatchingItemsChanged();
            Bundle bundle = panelFeatureState.f598r;
            if (bundle != null) {
                panelFeatureState.f590j.restoreActionViewStates(bundle);
                panelFeatureState.f598r = null;
            }
            if (!z13.onPreparePanel(0, panelFeatureState.f589i, panelFeatureState.f590j)) {
                if (z11 && (decorContentParent = this.mDecorContentParent) != null) {
                    decorContentParent.setMenu((Menu) null, this.mActionMenuPresenterCallback);
                }
                panelFeatureState.f590j.startDispatchingItemsChanged();
                return false;
            }
            if (keyEvent != null) {
                i11 = keyEvent.getDeviceId();
            } else {
                i11 = -1;
            }
            if (KeyCharacterMap.load(i11).getKeyboardType() != 1) {
                z12 = true;
            } else {
                z12 = false;
            }
            panelFeatureState.qwertyMode = z12;
            panelFeatureState.f590j.setQwertyMode(z12);
            panelFeatureState.f590j.startDispatchingItemsChanged();
        }
        panelFeatureState.f593m = true;
        panelFeatureState.f594n = false;
        this.mPreparedPanel = panelFeatureState;
        return true;
    }

    private void reopenMenu(boolean z11) {
        DecorContentParent decorContentParent = this.mDecorContentParent;
        if (decorContentParent == null || !decorContentParent.canShowOverflowMenu() || (ViewConfiguration.get(this.f544d).hasPermanentMenuKey() && !this.mDecorContentParent.isOverflowMenuShowPending())) {
            PanelFeatureState x11 = x(0, true);
            x11.f596p = true;
            p(x11, false);
            openPanel(x11, (KeyEvent) null);
            return;
        }
        Window.Callback z12 = z();
        if (this.mDecorContentParent.isOverflowMenuShowing() && z11) {
            this.mDecorContentParent.hideOverflowMenu();
            if (!this.f560t) {
                z12.onPanelClosed(108, x(0, true).f590j);
            }
        } else if (z12 != null && !this.f560t) {
            if (this.f561u && (this.f562v & 1) != 0) {
                this.f545e.getDecorView().removeCallbacks(this.mInvalidatePanelMenuRunnable);
                this.mInvalidatePanelMenuRunnable.run();
            }
            PanelFeatureState x12 = x(0, true);
            MenuBuilder menuBuilder = x12.f590j;
            if (menuBuilder != null && !x12.f597q && z12.onPreparePanel(0, x12.f589i, menuBuilder)) {
                z12.onMenuOpened(108, x12.f590j);
                this.mDecorContentParent.showOverflowMenu();
            }
        }
    }

    private int sanitizeWindowFeatureId(int i11) {
        if (i11 == 8) {
            Log.i("AppCompatDelegate", "You should now use the AppCompatDelegate.FEATURE_SUPPORT_ACTION_BAR id when requesting this feature.");
            return 108;
        } else if (i11 != 9) {
            return i11;
        } else {
            Log.i("AppCompatDelegate", "You should now use the AppCompatDelegate.FEATURE_SUPPORT_ACTION_BAR_OVERLAY id when requesting this feature.");
            return 109;
        }
    }

    private boolean shouldInheritContext(ViewParent viewParent) {
        if (viewParent == null) {
            return false;
        }
        View decorView = this.f545e.getDecorView();
        while (viewParent != null) {
            if (viewParent == decorView || !(viewParent instanceof View) || ViewCompat.isAttachedToWindow((View) viewParent)) {
                return false;
            }
            viewParent = viewParent.getParent();
        }
        return true;
    }

    private void throwFeatureRequestIfSubDecorInstalled() {
        if (this.mSubDecorInstalled) {
            throw new AndroidRuntimeException("Window feature must be requested before adding content");
        }
    }

    @Nullable
    private AppCompatActivity tryUnwrapContext() {
        Context context = this.f544d;
        while (context != null) {
            if (!(context instanceof AppCompatActivity)) {
                if (!(context instanceof ContextWrapper)) {
                    break;
                }
                context = ((ContextWrapper) context).getBaseContext();
            } else {
                return (AppCompatActivity) context;
            }
        }
        return null;
    }

    private void updateActivityConfiguration(Configuration configuration) {
        Activity activity = (Activity) this.f543c;
        if (activity instanceof LifecycleOwner) {
            if (((LifecycleOwner) activity).getLifecycle().getCurrentState().isAtLeast(Lifecycle.State.CREATED)) {
                activity.onConfigurationChanged(configuration);
            }
        } else if (this.mCreated && !this.f560t) {
            activity.onConfigurationChanged(configuration);
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:38:0x0082  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private boolean updateAppConfiguration(int r9, @androidx.annotation.Nullable androidx.core.os.LocaleListCompat r10, boolean r11) {
        /*
            r8 = this;
            android.content.Context r1 = r8.f544d
            r4 = 0
            r5 = 0
            r0 = r8
            r2 = r9
            r3 = r10
            android.content.res.Configuration r0 = r0.createOverrideAppConfiguration(r1, r2, r3, r4, r5)
            android.content.Context r1 = r8.f544d
            int r1 = r8.getActivityHandlesConfigChangesFlags(r1)
            android.content.res.Configuration r2 = r8.mEffectiveConfiguration
            if (r2 != 0) goto L_0x001f
            android.content.Context r2 = r8.f544d
            android.content.res.Resources r2 = r2.getResources()
            android.content.res.Configuration r2 = r2.getConfiguration()
        L_0x001f:
            int r3 = r2.uiMode
            r3 = r3 & 48
            int r4 = r0.uiMode
            r4 = r4 & 48
            androidx.core.os.LocaleListCompat r2 = r8.w(r2)
            r5 = 0
            if (r10 != 0) goto L_0x0030
            r0 = r5
            goto L_0x0034
        L_0x0030:
            androidx.core.os.LocaleListCompat r0 = r8.w(r0)
        L_0x0034:
            r6 = 0
            if (r3 == r4) goto L_0x003a
            r3 = 512(0x200, float:7.175E-43)
            goto L_0x003b
        L_0x003a:
            r3 = r6
        L_0x003b:
            if (r0 == 0) goto L_0x0047
            boolean r2 = r2.equals(r0)
            if (r2 != 0) goto L_0x0047
            r2 = r3 | 4
            r3 = r2 | 8192(0x2000, float:1.14794E-41)
        L_0x0047:
            int r2 = ~r1
            r2 = r2 & r3
            r7 = 1
            if (r2 == 0) goto L_0x0071
            if (r11 == 0) goto L_0x0071
            boolean r11 = r8.mBaseContextAttached
            if (r11 == 0) goto L_0x0071
            boolean r11 = sCanReturnDifferentContext
            if (r11 != 0) goto L_0x005a
            boolean r11 = r8.mCreated
            if (r11 == 0) goto L_0x0071
        L_0x005a:
            java.lang.Object r11 = r8.f543c
            boolean r2 = r11 instanceof android.app.Activity
            if (r2 == 0) goto L_0x0071
            android.app.Activity r11 = (android.app.Activity) r11
            boolean r11 = r11.isChild()
            if (r11 != 0) goto L_0x0071
            java.lang.Object r11 = r8.f543c
            android.app.Activity r11 = (android.app.Activity) r11
            androidx.core.app.ActivityCompat.recreate(r11)
            r11 = r7
            goto L_0x0072
        L_0x0071:
            r11 = r6
        L_0x0072:
            if (r11 != 0) goto L_0x007f
            if (r3 == 0) goto L_0x007f
            r11 = r3 & r1
            if (r11 != r3) goto L_0x007b
            r6 = r7
        L_0x007b:
            r8.updateResourcesConfiguration(r4, r0, r6, r5)
            goto L_0x0080
        L_0x007f:
            r7 = r11
        L_0x0080:
            if (r7 == 0) goto L_0x009c
            java.lang.Object r11 = r8.f543c
            boolean r1 = r11 instanceof androidx.appcompat.app.AppCompatActivity
            if (r1 == 0) goto L_0x009c
            r1 = r3 & 512(0x200, float:7.175E-43)
            if (r1 == 0) goto L_0x0091
            androidx.appcompat.app.AppCompatActivity r11 = (androidx.appcompat.app.AppCompatActivity) r11
            r11.onNightModeChanged(r9)
        L_0x0091:
            r9 = r3 & 4
            if (r9 == 0) goto L_0x009c
            java.lang.Object r9 = r8.f543c
            androidx.appcompat.app.AppCompatActivity r9 = (androidx.appcompat.app.AppCompatActivity) r9
            r9.onLocalesChanged(r10)
        L_0x009c:
            if (r7 == 0) goto L_0x00b1
            if (r0 == 0) goto L_0x00b1
            android.content.Context r9 = r8.f544d
            android.content.res.Resources r9 = r9.getResources()
            android.content.res.Configuration r9 = r9.getConfiguration()
            androidx.core.os.LocaleListCompat r9 = r8.w(r9)
            r8.K(r9)
        L_0x00b1:
            return r7
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.appcompat.app.AppCompatDelegateImpl.updateAppConfiguration(int, androidx.core.os.LocaleListCompat, boolean):boolean");
    }

    private void updateResourcesConfiguration(int i11, @Nullable LocaleListCompat localeListCompat, boolean z11, @Nullable Configuration configuration) {
        Resources resources = this.f544d.getResources();
        Configuration configuration2 = new Configuration(resources.getConfiguration());
        if (configuration != null) {
            configuration2.updateFrom(configuration);
        }
        configuration2.uiMode = i11 | (resources.getConfiguration().uiMode & -49);
        if (localeListCompat != null) {
            J(configuration2, localeListCompat);
        }
        resources.updateConfiguration(configuration2, (DisplayMetrics) null);
        if (Build.VERSION.SDK_INT < 26) {
            ResourcesFlusher.a(resources);
        }
        int i12 = this.mThemeResId;
        if (i12 != 0) {
            this.f544d.setTheme(i12);
            this.f544d.getTheme().applyStyle(this.mThemeResId, true);
        }
        if (z11 && (this.f543c instanceof Activity)) {
            updateActivityConfiguration(configuration2);
        }
    }

    private void updateStatusGuardColor(View view) {
        boolean z11;
        int i11;
        if ((ViewCompat.getWindowSystemUiVisibility(view) & 8192) != 0) {
            z11 = true;
        } else {
            z11 = false;
        }
        if (z11) {
            i11 = ContextCompat.getColor(this.f544d, R.color.abc_decor_view_status_guard_light);
        } else {
            i11 = ContextCompat.getColor(this.f544d, R.color.abc_decor_view_status_guard);
        }
        view.setBackgroundColor(i11);
    }

    public int A(@NonNull Context context, int i11) {
        if (i11 == -100) {
            return -1;
        }
        if (i11 != -1) {
            if (i11 != 0) {
                if (!(i11 == 1 || i11 == 2)) {
                    if (i11 == 3) {
                        return getAutoBatteryNightModeManager(context).getApplyableNightMode();
                    }
                    throw new IllegalStateException("Unknown value set for night mode. Please use one of the MODE_NIGHT values from AppCompatDelegate.");
                }
            } else if (((UiModeManager) context.getApplicationContext().getSystemService("uimode")).getNightMode() == 0) {
                return -1;
            } else {
                return getAutoTimeNightModeManager(context).getApplyableNightMode();
            }
        }
        return i11;
    }

    public boolean B() {
        boolean z11 = this.mLongPressBackDown;
        this.mLongPressBackDown = false;
        PanelFeatureState x11 = x(0, false);
        if (x11 == null || !x11.f595o) {
            androidx.appcompat.view.ActionMode actionMode = this.f549i;
            if (actionMode != null) {
                actionMode.finish();
                return true;
            }
            ActionBar supportActionBar = getSupportActionBar();
            if (supportActionBar == null || !supportActionBar.collapseActionView()) {
                return false;
            }
            return true;
        }
        if (!z11) {
            p(x11, true);
        }
        return true;
    }

    public boolean C(int i11, KeyEvent keyEvent) {
        boolean z11 = true;
        if (i11 == 4) {
            if ((keyEvent.getFlags() & 128) == 0) {
                z11 = false;
            }
            this.mLongPressBackDown = z11;
        } else if (i11 == 82) {
            onKeyDownPanel(0, keyEvent);
            return true;
        }
        return false;
    }

    public boolean D(int i11, KeyEvent keyEvent) {
        ActionBar supportActionBar = getSupportActionBar();
        if (supportActionBar != null && supportActionBar.onKeyShortcut(i11, keyEvent)) {
            return true;
        }
        PanelFeatureState panelFeatureState = this.mPreparedPanel;
        if (panelFeatureState == null || !performPanelShortcut(panelFeatureState, keyEvent.getKeyCode(), keyEvent, 1)) {
            if (this.mPreparedPanel == null) {
                PanelFeatureState x11 = x(0, true);
                preparePanel(x11, keyEvent);
                boolean performPanelShortcut = performPanelShortcut(x11, keyEvent.getKeyCode(), keyEvent, 1);
                x11.f593m = false;
                if (performPanelShortcut) {
                    return true;
                }
            }
            return false;
        }
        PanelFeatureState panelFeatureState2 = this.mPreparedPanel;
        if (panelFeatureState2 != null) {
            panelFeatureState2.f594n = true;
        }
        return true;
    }

    public boolean E(int i11, KeyEvent keyEvent) {
        if (i11 != 4) {
            if (i11 == 82) {
                onKeyUpPanel(0, keyEvent);
                return true;
            }
        } else if (B()) {
            return true;
        }
        return false;
    }

    public void F(int i11) {
        ActionBar supportActionBar;
        if (i11 == 108 && (supportActionBar = getSupportActionBar()) != null) {
            supportActionBar.dispatchMenuVisibilityChanged(true);
        }
    }

    public void G(int i11) {
        if (i11 == 108) {
            ActionBar supportActionBar = getSupportActionBar();
            if (supportActionBar != null) {
                supportActionBar.dispatchMenuVisibilityChanged(false);
            }
        } else if (i11 == 0) {
            PanelFeatureState x11 = x(i11, true);
            if (x11.f595o) {
                p(x11, false);
            }
        }
    }

    public void H(ViewGroup viewGroup) {
    }

    public final ActionBar I() {
        return this.f547g;
    }

    public void J(Configuration configuration, @NonNull LocaleListCompat localeListCompat) {
        if (Build.VERSION.SDK_INT >= 24) {
            Api24Impl.c(configuration, localeListCompat);
            return;
        }
        Api17Impl.d(configuration, localeListCompat.get(0));
        Api17Impl.c(configuration, localeListCompat.get(0));
    }

    public void K(LocaleListCompat localeListCompat) {
        if (Build.VERSION.SDK_INT >= 24) {
            Api24Impl.setDefaultLocales(localeListCompat);
        } else {
            Locale.setDefault(localeListCompat.get(0));
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:2:0x0004, code lost:
        r0 = r1.f554n;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final boolean L() {
        /*
            r1 = this;
            boolean r0 = r1.mSubDecorInstalled
            if (r0 == 0) goto L_0x0010
            android.view.ViewGroup r0 = r1.f554n
            if (r0 == 0) goto L_0x0010
            boolean r0 = androidx.core.view.ViewCompat.isLaidOut(r0)
            if (r0 == 0) goto L_0x0010
            r0 = 1
            goto L_0x0011
        L_0x0010:
            r0 = 0
        L_0x0011:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.appcompat.app.AppCompatDelegateImpl.L():boolean");
    }

    public boolean M() {
        if (this.mDispatcher == null) {
            return false;
        }
        PanelFeatureState x11 = x(0, false);
        if ((x11 == null || !x11.f595o) && this.f549i == null) {
            return false;
        }
        return true;
    }

    /* JADX WARNING: Removed duplicated region for block: B:15:0x0025  */
    /* JADX WARNING: Removed duplicated region for block: B:16:0x0029  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public androidx.appcompat.view.ActionMode N(@androidx.annotation.NonNull androidx.appcompat.view.ActionMode.Callback r8) {
        /*
            r7 = this;
            r7.t()
            androidx.appcompat.view.ActionMode r0 = r7.f549i
            if (r0 == 0) goto L_0x000a
            r0.finish()
        L_0x000a:
            boolean r0 = r8 instanceof androidx.appcompat.app.AppCompatDelegateImpl.ActionModeCallbackWrapperV9
            if (r0 != 0) goto L_0x0014
            androidx.appcompat.app.AppCompatDelegateImpl$ActionModeCallbackWrapperV9 r0 = new androidx.appcompat.app.AppCompatDelegateImpl$ActionModeCallbackWrapperV9
            r0.<init>(r8)
            r8 = r0
        L_0x0014:
            androidx.appcompat.app.AppCompatCallback r0 = r7.f546f
            r1 = 0
            if (r0 == 0) goto L_0x0022
            boolean r2 = r7.f560t
            if (r2 != 0) goto L_0x0022
            androidx.appcompat.view.ActionMode r0 = r0.onWindowStartingSupportActionMode(r8)     // Catch:{ AbstractMethodError -> 0x0022 }
            goto L_0x0023
        L_0x0022:
            r0 = r1
        L_0x0023:
            if (r0 == 0) goto L_0x0029
            r7.f549i = r0
            goto L_0x015b
        L_0x0029:
            androidx.appcompat.widget.ActionBarContextView r0 = r7.f550j
            r2 = 0
            r3 = 1
            if (r0 != 0) goto L_0x00d4
            boolean r0 = r7.f558r
            if (r0 == 0) goto L_0x00b5
            android.util.TypedValue r0 = new android.util.TypedValue
            r0.<init>()
            android.content.Context r4 = r7.f544d
            android.content.res.Resources$Theme r4 = r4.getTheme()
            int r5 = androidx.appcompat.R.attr.actionBarTheme
            r4.resolveAttribute(r5, r0, r3)
            int r5 = r0.resourceId
            if (r5 == 0) goto L_0x0068
            android.content.Context r5 = r7.f544d
            android.content.res.Resources r5 = r5.getResources()
            android.content.res.Resources$Theme r5 = r5.newTheme()
            r5.setTo(r4)
            int r4 = r0.resourceId
            r5.applyStyle(r4, r3)
            androidx.appcompat.view.ContextThemeWrapper r4 = new androidx.appcompat.view.ContextThemeWrapper
            android.content.Context r6 = r7.f544d
            r4.<init>((android.content.Context) r6, (int) r2)
            android.content.res.Resources$Theme r6 = r4.getTheme()
            r6.setTo(r5)
            goto L_0x006a
        L_0x0068:
            android.content.Context r4 = r7.f544d
        L_0x006a:
            androidx.appcompat.widget.ActionBarContextView r5 = new androidx.appcompat.widget.ActionBarContextView
            r5.<init>(r4)
            r7.f550j = r5
            android.widget.PopupWindow r5 = new android.widget.PopupWindow
            int r6 = androidx.appcompat.R.attr.actionModePopupWindowStyle
            r5.<init>(r4, r1, r6)
            r7.f551k = r5
            r6 = 2
            androidx.core.widget.PopupWindowCompat.setWindowLayoutType(r5, r6)
            android.widget.PopupWindow r5 = r7.f551k
            androidx.appcompat.widget.ActionBarContextView r6 = r7.f550j
            r5.setContentView(r6)
            android.widget.PopupWindow r5 = r7.f551k
            r6 = -1
            r5.setWidth(r6)
            android.content.res.Resources$Theme r5 = r4.getTheme()
            int r6 = androidx.appcompat.R.attr.actionBarSize
            r5.resolveAttribute(r6, r0, r3)
            int r0 = r0.data
            android.content.res.Resources r4 = r4.getResources()
            android.util.DisplayMetrics r4 = r4.getDisplayMetrics()
            int r0 = android.util.TypedValue.complexToDimensionPixelSize(r0, r4)
            androidx.appcompat.widget.ActionBarContextView r4 = r7.f550j
            r4.setContentHeight(r0)
            android.widget.PopupWindow r0 = r7.f551k
            r4 = -2
            r0.setHeight(r4)
            androidx.appcompat.app.AppCompatDelegateImpl$6 r0 = new androidx.appcompat.app.AppCompatDelegateImpl$6
            r0.<init>()
            r7.f552l = r0
            goto L_0x00d4
        L_0x00b5:
            android.view.ViewGroup r0 = r7.f554n
            int r4 = androidx.appcompat.R.id.action_mode_bar_stub
            android.view.View r0 = r0.findViewById(r4)
            androidx.appcompat.widget.ViewStubCompat r0 = (androidx.appcompat.widget.ViewStubCompat) r0
            if (r0 == 0) goto L_0x00d4
            android.content.Context r4 = r7.v()
            android.view.LayoutInflater r4 = android.view.LayoutInflater.from(r4)
            r0.setLayoutInflater(r4)
            android.view.View r0 = r0.inflate()
            androidx.appcompat.widget.ActionBarContextView r0 = (androidx.appcompat.widget.ActionBarContextView) r0
            r7.f550j = r0
        L_0x00d4:
            androidx.appcompat.widget.ActionBarContextView r0 = r7.f550j
            if (r0 == 0) goto L_0x015b
            r7.t()
            androidx.appcompat.widget.ActionBarContextView r0 = r7.f550j
            r0.killMode()
            androidx.appcompat.view.StandaloneActionMode r0 = new androidx.appcompat.view.StandaloneActionMode
            androidx.appcompat.widget.ActionBarContextView r4 = r7.f550j
            android.content.Context r4 = r4.getContext()
            androidx.appcompat.widget.ActionBarContextView r5 = r7.f550j
            android.widget.PopupWindow r6 = r7.f551k
            if (r6 != 0) goto L_0x00ef
            goto L_0x00f0
        L_0x00ef:
            r3 = r2
        L_0x00f0:
            r0.<init>(r4, r5, r8, r3)
            android.view.Menu r3 = r0.getMenu()
            boolean r8 = r8.onCreateActionMode(r0, r3)
            if (r8 == 0) goto L_0x0159
            r0.invalidate()
            androidx.appcompat.widget.ActionBarContextView r8 = r7.f550j
            r8.initForMode(r0)
            r7.f549i = r0
            boolean r8 = r7.L()
            r0 = 1065353216(0x3f800000, float:1.0)
            if (r8 == 0) goto L_0x012a
            androidx.appcompat.widget.ActionBarContextView r8 = r7.f550j
            r1 = 0
            r8.setAlpha(r1)
            androidx.appcompat.widget.ActionBarContextView r8 = r7.f550j
            androidx.core.view.ViewPropertyAnimatorCompat r8 = androidx.core.view.ViewCompat.animate(r8)
            androidx.core.view.ViewPropertyAnimatorCompat r8 = r8.alpha(r0)
            r7.f553m = r8
            androidx.appcompat.app.AppCompatDelegateImpl$7 r0 = new androidx.appcompat.app.AppCompatDelegateImpl$7
            r0.<init>()
            r8.setListener(r0)
            goto L_0x0149
        L_0x012a:
            androidx.appcompat.widget.ActionBarContextView r8 = r7.f550j
            r8.setAlpha(r0)
            androidx.appcompat.widget.ActionBarContextView r8 = r7.f550j
            r8.setVisibility(r2)
            androidx.appcompat.widget.ActionBarContextView r8 = r7.f550j
            android.view.ViewParent r8 = r8.getParent()
            boolean r8 = r8 instanceof android.view.View
            if (r8 == 0) goto L_0x0149
            androidx.appcompat.widget.ActionBarContextView r8 = r7.f550j
            android.view.ViewParent r8 = r8.getParent()
            android.view.View r8 = (android.view.View) r8
            androidx.core.view.ViewCompat.requestApplyInsets(r8)
        L_0x0149:
            android.widget.PopupWindow r8 = r7.f551k
            if (r8 == 0) goto L_0x015b
            android.view.Window r8 = r7.f545e
            android.view.View r8 = r8.getDecorView()
            java.lang.Runnable r0 = r7.f552l
            r8.post(r0)
            goto L_0x015b
        L_0x0159:
            r7.f549i = r1
        L_0x015b:
            androidx.appcompat.view.ActionMode r8 = r7.f549i
            if (r8 == 0) goto L_0x0166
            androidx.appcompat.app.AppCompatCallback r0 = r7.f546f
            if (r0 == 0) goto L_0x0166
            r0.onSupportActionModeStarted(r8)
        L_0x0166:
            r7.O()
            androidx.appcompat.view.ActionMode r8 = r7.f549i
            return r8
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.appcompat.app.AppCompatDelegateImpl.N(androidx.appcompat.view.ActionMode$Callback):androidx.appcompat.view.ActionMode");
    }

    public void O() {
        OnBackInvokedCallback onBackInvokedCallback;
        if (Build.VERSION.SDK_INT >= 33) {
            boolean M = M();
            if (M && this.mBackCallback == null) {
                this.mBackCallback = Api33Impl.b(this.mDispatcher, this);
            } else if (!M && (onBackInvokedCallback = this.mBackCallback) != null) {
                Api33Impl.c(this.mDispatcher, onBackInvokedCallback);
            }
        }
    }

    public final int P(@Nullable WindowInsetsCompat windowInsetsCompat, @Nullable Rect rect) {
        int i11;
        boolean z11;
        int i12;
        int i13;
        boolean z12;
        ViewGroup.MarginLayoutParams marginLayoutParams;
        int i14;
        int i15 = 0;
        if (windowInsetsCompat != null) {
            i11 = windowInsetsCompat.getSystemWindowInsetTop();
        } else if (rect != null) {
            i11 = rect.top;
        } else {
            i11 = 0;
        }
        ActionBarContextView actionBarContextView = this.f550j;
        if (actionBarContextView == null || !(actionBarContextView.getLayoutParams() instanceof ViewGroup.MarginLayoutParams)) {
            z11 = false;
        } else {
            ViewGroup.MarginLayoutParams marginLayoutParams2 = (ViewGroup.MarginLayoutParams) this.f550j.getLayoutParams();
            boolean z13 = true;
            if (this.f550j.isShown()) {
                if (this.mTempRect1 == null) {
                    this.mTempRect1 = new Rect();
                    this.mTempRect2 = new Rect();
                }
                Rect rect2 = this.mTempRect1;
                Rect rect3 = this.mTempRect2;
                if (windowInsetsCompat == null) {
                    rect2.set(rect);
                } else {
                    rect2.set(windowInsetsCompat.getSystemWindowInsetLeft(), windowInsetsCompat.getSystemWindowInsetTop(), windowInsetsCompat.getSystemWindowInsetRight(), windowInsetsCompat.getSystemWindowInsetBottom());
                }
                ViewUtils.computeFitSystemWindows(this.f554n, rect2, rect3);
                int i16 = rect2.top;
                int i17 = rect2.left;
                int i18 = rect2.right;
                WindowInsetsCompat rootWindowInsets = ViewCompat.getRootWindowInsets(this.f554n);
                if (rootWindowInsets == null) {
                    i12 = 0;
                } else {
                    i12 = rootWindowInsets.getSystemWindowInsetLeft();
                }
                if (rootWindowInsets == null) {
                    i13 = 0;
                } else {
                    i13 = rootWindowInsets.getSystemWindowInsetRight();
                }
                if (marginLayoutParams2.topMargin == i16 && marginLayoutParams2.leftMargin == i17 && marginLayoutParams2.rightMargin == i18) {
                    z12 = false;
                } else {
                    marginLayoutParams2.topMargin = i16;
                    marginLayoutParams2.leftMargin = i17;
                    marginLayoutParams2.rightMargin = i18;
                    z12 = true;
                }
                if (i16 <= 0 || this.mStatusGuard != null) {
                    View view = this.mStatusGuard;
                    if (!(view == null || ((marginLayoutParams = (ViewGroup.MarginLayoutParams) view.getLayoutParams()).height == (i14 = marginLayoutParams2.topMargin) && marginLayoutParams.leftMargin == i12 && marginLayoutParams.rightMargin == i13))) {
                        marginLayoutParams.height = i14;
                        marginLayoutParams.leftMargin = i12;
                        marginLayoutParams.rightMargin = i13;
                        this.mStatusGuard.setLayoutParams(marginLayoutParams);
                    }
                } else {
                    View view2 = new View(this.f544d);
                    this.mStatusGuard = view2;
                    view2.setVisibility(8);
                    FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, marginLayoutParams2.topMargin, 51);
                    layoutParams.leftMargin = i12;
                    layoutParams.rightMargin = i13;
                    this.f554n.addView(this.mStatusGuard, -1, layoutParams);
                }
                View view3 = this.mStatusGuard;
                if (view3 == null) {
                    z13 = false;
                }
                if (z13 && view3.getVisibility() != 0) {
                    updateStatusGuardColor(this.mStatusGuard);
                }
                if (!this.f557q && z13) {
                    i11 = 0;
                }
                z11 = z13;
                z13 = z12;
            } else if (marginLayoutParams2.topMargin != 0) {
                marginLayoutParams2.topMargin = 0;
                z11 = false;
            } else {
                z11 = false;
                z13 = false;
            }
            if (z13) {
                this.f550j.setLayoutParams(marginLayoutParams2);
            }
        }
        View view4 = this.mStatusGuard;
        if (view4 != null) {
            if (!z11) {
                i15 = 8;
            }
            view4.setVisibility(i15);
        }
        return i11;
    }

    public void addContentView(View view, ViewGroup.LayoutParams layoutParams) {
        ensureSubDecor();
        ((ViewGroup) this.f554n.findViewById(16908290)).addView(view, layoutParams);
        this.mAppCompatWindowCallback.bypassOnContentChanged(this.f545e.getCallback());
    }

    public boolean applyDayNight() {
        return applyApplicationSpecificConfig(true);
    }

    @CallSuper
    @NonNull
    public Context attachBaseContext2(@NonNull Context context) {
        Configuration configuration;
        boolean z11 = true;
        this.mBaseContextAttached = true;
        int A = A(context, calculateNightMode());
        if (AppCompatDelegate.i(context)) {
            AppCompatDelegate.k(context);
        }
        LocaleListCompat l11 = l(context);
        if (sCanApplyOverrideConfiguration && (context instanceof ContextThemeWrapper)) {
            try {
                ContextThemeWrapperCompatApi17Impl.a((ContextThemeWrapper) context, createOverrideAppConfiguration(context, A, l11, (Configuration) null, false));
                return context;
            } catch (IllegalStateException unused) {
            }
        }
        if (context instanceof androidx.appcompat.view.ContextThemeWrapper) {
            try {
                ((androidx.appcompat.view.ContextThemeWrapper) context).applyOverrideConfiguration(createOverrideAppConfiguration(context, A, l11, (Configuration) null, false));
                return context;
            } catch (IllegalStateException unused2) {
            }
        }
        if (!sCanReturnDifferentContext) {
            return super.attachBaseContext2(context);
        }
        Configuration configuration2 = new Configuration();
        configuration2.uiMode = -1;
        configuration2.fontScale = 0.0f;
        Configuration configuration3 = Api17Impl.a(context, configuration2).getResources().getConfiguration();
        Configuration configuration4 = context.getResources().getConfiguration();
        configuration3.uiMode = configuration4.uiMode;
        if (!configuration3.equals(configuration4)) {
            configuration = generateConfigDelta(configuration3, configuration4);
        } else {
            configuration = null;
        }
        Configuration createOverrideAppConfiguration = createOverrideAppConfiguration(context, A, l11, configuration, true);
        androidx.appcompat.view.ContextThemeWrapper contextThemeWrapper = new androidx.appcompat.view.ContextThemeWrapper(context, R.style.Theme_AppCompat_Empty);
        contextThemeWrapper.applyOverrideConfiguration(createOverrideAppConfiguration);
        boolean z12 = false;
        try {
            if (context.getTheme() == null) {
                z11 = false;
            }
            z12 = z11;
        } catch (NullPointerException unused3) {
        }
        if (z12) {
            ResourcesCompat.ThemeCompat.rebase(contextThemeWrapper.getTheme());
        }
        return super.attachBaseContext2(contextThemeWrapper);
    }

    public View createView(View view, String str, @NonNull Context context, @NonNull AttributeSet attributeSet) {
        boolean z11;
        boolean z12 = false;
        if (this.mAppCompatViewInflater == null) {
            String string = this.f544d.obtainStyledAttributes(R.styleable.AppCompatTheme).getString(R.styleable.AppCompatTheme_viewInflaterClass);
            if (string == null) {
                this.mAppCompatViewInflater = new AppCompatViewInflater();
            } else {
                try {
                    this.mAppCompatViewInflater = (AppCompatViewInflater) this.f544d.getClassLoader().loadClass(string).getDeclaredConstructor(new Class[0]).newInstance(new Object[0]);
                } catch (Throwable th2) {
                    Log.i("AppCompatDelegate", "Failed to instantiate custom view inflater " + string + ". Falling back to default.", th2);
                    this.mAppCompatViewInflater = new AppCompatViewInflater();
                }
            }
        }
        boolean z13 = IS_PRE_LOLLIPOP;
        if (z13) {
            if (this.mLayoutIncludeDetector == null) {
                this.mLayoutIncludeDetector = new LayoutIncludeDetector();
            }
            if (this.mLayoutIncludeDetector.a(attributeSet)) {
                z11 = true;
                return this.mAppCompatViewInflater.createView(view, str, context, attributeSet, z11, z13, true, VectorEnabledTintResources.shouldBeUsed());
            } else if (!(attributeSet instanceof XmlPullParser)) {
                z12 = shouldInheritContext((ViewParent) view);
            } else if (((XmlPullParser) attributeSet).getDepth() > 1) {
                z12 = true;
            }
        }
        z11 = z12;
        return this.mAppCompatViewInflater.createView(view, str, context, attributeSet, z11, z13, true, VectorEnabledTintResources.shouldBeUsed());
    }

    public boolean d() {
        if (AppCompatDelegate.i(this.f544d) && AppCompatDelegate.g() != null && !AppCompatDelegate.g().equals(AppCompatDelegate.h())) {
            e(this.f544d);
        }
        return applyApplicationSpecificConfig(true);
    }

    @Nullable
    public <T extends View> T findViewById(@IdRes int i11) {
        ensureSubDecor();
        return this.f545e.findViewById(i11);
    }

    public Context getContextForDelegate() {
        return this.f544d;
    }

    public final ActionBarDrawerToggle.Delegate getDrawerToggleDelegate() {
        return new ActionBarDrawableToggleImpl();
    }

    public int getLocalNightMode() {
        return this.mLocalNightMode;
    }

    public MenuInflater getMenuInflater() {
        Context context;
        if (this.f548h == null) {
            initWindowDecorActionBar();
            ActionBar actionBar = this.f547g;
            if (actionBar != null) {
                context = actionBar.getThemedContext();
            } else {
                context = this.f544d;
            }
            this.f548h = new SupportMenuInflater(context);
        }
        return this.f548h;
    }

    public ActionBar getSupportActionBar() {
        initWindowDecorActionBar();
        return this.f547g;
    }

    public boolean hasWindowFeature(int i11) {
        boolean z11;
        int sanitizeWindowFeatureId = sanitizeWindowFeatureId(i11);
        if (sanitizeWindowFeatureId == 1) {
            z11 = this.f559s;
        } else if (sanitizeWindowFeatureId == 2) {
            z11 = this.mFeatureProgress;
        } else if (sanitizeWindowFeatureId == 5) {
            z11 = this.mFeatureIndeterminateProgress;
        } else if (sanitizeWindowFeatureId == 10) {
            z11 = this.f557q;
        } else if (sanitizeWindowFeatureId == 108) {
            z11 = this.f555o;
        } else if (sanitizeWindowFeatureId != 109) {
            z11 = false;
        } else {
            z11 = this.f556p;
        }
        if (z11 || this.f545e.hasFeature(i11)) {
            return true;
        }
        return false;
    }

    public void installViewFactory() {
        LayoutInflater from = LayoutInflater.from(this.f544d);
        if (from.getFactory() == null) {
            LayoutInflaterCompat.setFactory2(from, this);
        } else if (!(from.getFactory2() instanceof AppCompatDelegateImpl)) {
            Log.i("AppCompatDelegate", "The Activity's LayoutInflater already has a Factory installed so we can not install AppCompat's");
        }
    }

    public void invalidateOptionsMenu() {
        if (I() != null && !getSupportActionBar().invalidateOptionsMenu()) {
            invalidatePanelMenu(0);
        }
    }

    public boolean isHandleNativeActionModesEnabled() {
        return this.mHandleNativeActionModes;
    }

    @Nullable
    public LocaleListCompat l(@NonNull Context context) {
        LocaleListCompat g11;
        LocaleListCompat localeListCompat;
        int i11 = Build.VERSION.SDK_INT;
        if (i11 >= 33 || (g11 = AppCompatDelegate.g()) == null) {
            return null;
        }
        LocaleListCompat w11 = w(context.getApplicationContext().getResources().getConfiguration());
        if (i11 >= 24) {
            localeListCompat = LocaleOverlayHelper.a(g11, w11);
        } else if (g11.isEmpty()) {
            localeListCompat = LocaleListCompat.getEmptyLocaleList();
        } else {
            localeListCompat = LocaleListCompat.forLanguageTags(g11.get(0).toString());
        }
        if (localeListCompat.isEmpty()) {
            return w11;
        }
        return localeListCompat;
    }

    public void m(int i11, PanelFeatureState panelFeatureState, Menu menu) {
        if (menu == null) {
            if (panelFeatureState == null && i11 >= 0) {
                PanelFeatureState[] panelFeatureStateArr = this.mPanels;
                if (i11 < panelFeatureStateArr.length) {
                    panelFeatureState = panelFeatureStateArr[i11];
                }
            }
            if (panelFeatureState != null) {
                menu = panelFeatureState.f590j;
            }
        }
        if ((panelFeatureState == null || panelFeatureState.f595o) && !this.f560t) {
            this.mAppCompatWindowCallback.bypassOnPanelClosed(this.f545e.getCallback(), i11, menu);
        }
    }

    public void n(@NonNull MenuBuilder menuBuilder) {
        if (!this.mClosingActionMenu) {
            this.mClosingActionMenu = true;
            this.mDecorContentParent.dismissPopups();
            Window.Callback z11 = z();
            if (z11 != null && !this.f560t) {
                z11.onPanelClosed(108, menuBuilder);
            }
            this.mClosingActionMenu = false;
        }
    }

    public void o(int i11) {
        p(x(i11, true), true);
    }

    public void onConfigurationChanged(Configuration configuration) {
        ActionBar supportActionBar;
        if (this.f555o && this.mSubDecorInstalled && (supportActionBar = getSupportActionBar()) != null) {
            supportActionBar.onConfigurationChanged(configuration);
        }
        AppCompatDrawableManager.get().onConfigurationChanged(this.f544d);
        this.mEffectiveConfiguration = new Configuration(this.f544d.getResources().getConfiguration());
        applyApplicationSpecificConfig(false, false);
    }

    public void onCreate(Bundle bundle) {
        String str;
        this.mBaseContextAttached = true;
        applyApplicationSpecificConfig(false);
        ensureWindow();
        Object obj = this.f543c;
        if (obj instanceof Activity) {
            try {
                str = NavUtils.getParentActivityName((Activity) obj);
            } catch (IllegalArgumentException unused) {
                str = null;
            }
            if (str != null) {
                ActionBar I = I();
                if (I == null) {
                    this.mEnableDefaultActionBarUp = true;
                } else {
                    I.setDefaultDisplayHomeAsUpEnabled(true);
                }
            }
            AppCompatDelegate.c(this);
        }
        this.mEffectiveConfiguration = new Configuration(this.f544d.getResources().getConfiguration());
        this.mCreated = true;
    }

    public final View onCreateView(View view, String str, Context context, AttributeSet attributeSet) {
        return createView(view, str, context, attributeSet);
    }

    /* JADX WARNING: Removed duplicated region for block: B:16:0x0058  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void onDestroy() {
        /*
            r3 = this;
            java.lang.Object r0 = r3.f543c
            boolean r0 = r0 instanceof android.app.Activity
            if (r0 == 0) goto L_0x0009
            androidx.appcompat.app.AppCompatDelegate.j(r3)
        L_0x0009:
            boolean r0 = r3.f561u
            if (r0 == 0) goto L_0x0018
            android.view.Window r0 = r3.f545e
            android.view.View r0 = r0.getDecorView()
            java.lang.Runnable r1 = r3.mInvalidatePanelMenuRunnable
            r0.removeCallbacks(r1)
        L_0x0018:
            r0 = 1
            r3.f560t = r0
            int r0 = r3.mLocalNightMode
            r1 = -100
            if (r0 == r1) goto L_0x0045
            java.lang.Object r0 = r3.f543c
            boolean r1 = r0 instanceof android.app.Activity
            if (r1 == 0) goto L_0x0045
            android.app.Activity r0 = (android.app.Activity) r0
            boolean r0 = r0.isChangingConfigurations()
            if (r0 == 0) goto L_0x0045
            androidx.collection.SimpleArrayMap<java.lang.String, java.lang.Integer> r0 = sLocalNightModes
            java.lang.Object r1 = r3.f543c
            java.lang.Class r1 = r1.getClass()
            java.lang.String r1 = r1.getName()
            int r2 = r3.mLocalNightMode
            java.lang.Integer r2 = java.lang.Integer.valueOf(r2)
            r0.put(r1, r2)
            goto L_0x0054
        L_0x0045:
            androidx.collection.SimpleArrayMap<java.lang.String, java.lang.Integer> r0 = sLocalNightModes
            java.lang.Object r1 = r3.f543c
            java.lang.Class r1 = r1.getClass()
            java.lang.String r1 = r1.getName()
            r0.remove(r1)
        L_0x0054:
            androidx.appcompat.app.ActionBar r0 = r3.f547g
            if (r0 == 0) goto L_0x005b
            r0.a()
        L_0x005b:
            r3.cleanupAutoManagers()
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.appcompat.app.AppCompatDelegateImpl.onDestroy():void");
    }

    public boolean onMenuItemSelected(@NonNull MenuBuilder menuBuilder, @NonNull MenuItem menuItem) {
        PanelFeatureState u11;
        Window.Callback z11 = z();
        if (z11 == null || this.f560t || (u11 = u(menuBuilder.getRootMenu())) == null) {
            return false;
        }
        return z11.onMenuItemSelected(u11.f581a, menuItem);
    }

    public void onMenuModeChange(@NonNull MenuBuilder menuBuilder) {
        reopenMenu(true);
    }

    public void onPostCreate(Bundle bundle) {
        ensureSubDecor();
    }

    public void onPostResume() {
        ActionBar supportActionBar = getSupportActionBar();
        if (supportActionBar != null) {
            supportActionBar.setShowHideAnimationEnabled(true);
        }
    }

    public void onSaveInstanceState(Bundle bundle) {
    }

    public void onStart() {
        applyApplicationSpecificConfig(true, false);
    }

    public void onStop() {
        ActionBar supportActionBar = getSupportActionBar();
        if (supportActionBar != null) {
            supportActionBar.setShowHideAnimationEnabled(false);
        }
    }

    public void p(PanelFeatureState panelFeatureState, boolean z11) {
        ViewGroup viewGroup;
        DecorContentParent decorContentParent;
        if (!z11 || panelFeatureState.f581a != 0 || (decorContentParent = this.mDecorContentParent) == null || !decorContentParent.isOverflowMenuShowing()) {
            WindowManager windowManager = (WindowManager) this.f544d.getSystemService("window");
            if (!(windowManager == null || !panelFeatureState.f595o || (viewGroup = panelFeatureState.f587g) == null)) {
                windowManager.removeView(viewGroup);
                if (z11) {
                    m(panelFeatureState.f581a, panelFeatureState, (Menu) null);
                }
            }
            panelFeatureState.f593m = false;
            panelFeatureState.f594n = false;
            panelFeatureState.f595o = false;
            panelFeatureState.f588h = null;
            panelFeatureState.f596p = true;
            if (this.mPreparedPanel == panelFeatureState) {
                this.mPreparedPanel = null;
            }
            if (panelFeatureState.f581a == 0) {
                O();
                return;
            }
            return;
        }
        n(panelFeatureState.f590j);
    }

    public void q() {
        MenuBuilder menuBuilder;
        DecorContentParent decorContentParent = this.mDecorContentParent;
        if (decorContentParent != null) {
            decorContentParent.dismissPopups();
        }
        if (this.f551k != null) {
            this.f545e.getDecorView().removeCallbacks(this.f552l);
            if (this.f551k.isShowing()) {
                try {
                    this.f551k.dismiss();
                } catch (IllegalArgumentException unused) {
                }
            }
            this.f551k = null;
        }
        t();
        PanelFeatureState x11 = x(0, false);
        if (x11 != null && (menuBuilder = x11.f590j) != null) {
            menuBuilder.close();
        }
    }

    public boolean r(KeyEvent keyEvent) {
        View decorView;
        Object obj = this.f543c;
        boolean z11 = true;
        if (((obj instanceof KeyEventDispatcher.Component) || (obj instanceof AppCompatDialog)) && (decorView = this.f545e.getDecorView()) != null && KeyEventDispatcher.dispatchBeforeHierarchy(decorView, keyEvent)) {
            return true;
        }
        if (keyEvent.getKeyCode() == 82 && this.mAppCompatWindowCallback.bypassDispatchKeyEvent(this.f545e.getCallback(), keyEvent)) {
            return true;
        }
        int keyCode = keyEvent.getKeyCode();
        if (keyEvent.getAction() != 0) {
            z11 = false;
        }
        if (z11) {
            return C(keyCode, keyEvent);
        }
        return E(keyCode, keyEvent);
    }

    public boolean requestWindowFeature(int i11) {
        int sanitizeWindowFeatureId = sanitizeWindowFeatureId(i11);
        if (this.f559s && sanitizeWindowFeatureId == 108) {
            return false;
        }
        if (this.f555o && sanitizeWindowFeatureId == 1) {
            this.f555o = false;
        }
        if (sanitizeWindowFeatureId == 1) {
            throwFeatureRequestIfSubDecorInstalled();
            this.f559s = true;
            return true;
        } else if (sanitizeWindowFeatureId == 2) {
            throwFeatureRequestIfSubDecorInstalled();
            this.mFeatureProgress = true;
            return true;
        } else if (sanitizeWindowFeatureId == 5) {
            throwFeatureRequestIfSubDecorInstalled();
            this.mFeatureIndeterminateProgress = true;
            return true;
        } else if (sanitizeWindowFeatureId == 10) {
            throwFeatureRequestIfSubDecorInstalled();
            this.f557q = true;
            return true;
        } else if (sanitizeWindowFeatureId == 108) {
            throwFeatureRequestIfSubDecorInstalled();
            this.f555o = true;
            return true;
        } else if (sanitizeWindowFeatureId != 109) {
            return this.f545e.requestFeature(sanitizeWindowFeatureId);
        } else {
            throwFeatureRequestIfSubDecorInstalled();
            this.f556p = true;
            return true;
        }
    }

    public void s(int i11) {
        PanelFeatureState x11;
        PanelFeatureState x12 = x(i11, true);
        if (x12.f590j != null) {
            Bundle bundle = new Bundle();
            x12.f590j.saveActionViewStates(bundle);
            if (bundle.size() > 0) {
                x12.f598r = bundle;
            }
            x12.f590j.stopDispatchingItemsChanged();
            x12.f590j.clear();
        }
        x12.f597q = true;
        x12.f596p = true;
        if ((i11 == 108 || i11 == 0) && this.mDecorContentParent != null && (x11 = x(0, false)) != null) {
            x11.f593m = false;
            preparePanel(x11, (KeyEvent) null);
        }
    }

    public void setContentView(View view) {
        ensureSubDecor();
        ViewGroup viewGroup = (ViewGroup) this.f554n.findViewById(16908290);
        viewGroup.removeAllViews();
        viewGroup.addView(view);
        this.mAppCompatWindowCallback.bypassOnContentChanged(this.f545e.getCallback());
    }

    public void setHandleNativeActionModesEnabled(boolean z11) {
        this.mHandleNativeActionModes = z11;
    }

    @RequiresApi(17)
    public void setLocalNightMode(int i11) {
        if (this.mLocalNightMode != i11) {
            this.mLocalNightMode = i11;
            if (this.mBaseContextAttached) {
                applyDayNight();
            }
        }
    }

    @RequiresApi(33)
    public void setOnBackInvokedDispatcher(@Nullable OnBackInvokedDispatcher onBackInvokedDispatcher) {
        OnBackInvokedCallback onBackInvokedCallback;
        super.setOnBackInvokedDispatcher(onBackInvokedDispatcher);
        OnBackInvokedDispatcher onBackInvokedDispatcher2 = this.mDispatcher;
        if (!(onBackInvokedDispatcher2 == null || (onBackInvokedCallback = this.mBackCallback) == null)) {
            Api33Impl.c(onBackInvokedDispatcher2, onBackInvokedCallback);
            this.mBackCallback = null;
        }
        if (onBackInvokedDispatcher == null) {
            Object obj = this.f543c;
            if ((obj instanceof Activity) && ((Activity) obj).getWindow() != null) {
                this.mDispatcher = Api33Impl.a((Activity) this.f543c);
                O();
            }
        }
        this.mDispatcher = onBackInvokedDispatcher;
        O();
    }

    public void setSupportActionBar(Toolbar toolbar) {
        if (this.f543c instanceof Activity) {
            ActionBar supportActionBar = getSupportActionBar();
            if (!(supportActionBar instanceof WindowDecorActionBar)) {
                this.f548h = null;
                if (supportActionBar != null) {
                    supportActionBar.a();
                }
                this.f547g = null;
                if (toolbar != null) {
                    ToolbarActionBar toolbarActionBar = new ToolbarActionBar(toolbar, y(), this.mAppCompatWindowCallback);
                    this.f547g = toolbarActionBar;
                    this.mAppCompatWindowCallback.a(toolbarActionBar.f608c);
                    toolbar.setBackInvokedCallbackEnabled(true);
                } else {
                    this.mAppCompatWindowCallback.a((ActionBarMenuCallback) null);
                }
                invalidateOptionsMenu();
                return;
            }
            throw new IllegalStateException("This Activity already has an action bar supplied by the window decor. Do not request Window.FEATURE_SUPPORT_ACTION_BAR and set windowActionBar to false in your theme to use a Toolbar instead.");
        }
    }

    public void setTheme(@StyleRes int i11) {
        this.mThemeResId = i11;
    }

    public final void setTitle(CharSequence charSequence) {
        this.mTitle = charSequence;
        DecorContentParent decorContentParent = this.mDecorContentParent;
        if (decorContentParent != null) {
            decorContentParent.setWindowTitle(charSequence);
        } else if (I() != null) {
            I().setWindowTitle(charSequence);
        } else {
            TextView textView = this.mTitleView;
            if (textView != null) {
                textView.setText(charSequence);
            }
        }
    }

    public androidx.appcompat.view.ActionMode startSupportActionMode(@NonNull ActionMode.Callback callback) {
        AppCompatCallback appCompatCallback;
        if (callback != null) {
            androidx.appcompat.view.ActionMode actionMode = this.f549i;
            if (actionMode != null) {
                actionMode.finish();
            }
            ActionModeCallbackWrapperV9 actionModeCallbackWrapperV9 = new ActionModeCallbackWrapperV9(callback);
            ActionBar supportActionBar = getSupportActionBar();
            if (supportActionBar != null) {
                androidx.appcompat.view.ActionMode startActionMode = supportActionBar.startActionMode(actionModeCallbackWrapperV9);
                this.f549i = startActionMode;
                if (!(startActionMode == null || (appCompatCallback = this.f546f) == null)) {
                    appCompatCallback.onSupportActionModeStarted(startActionMode);
                }
            }
            if (this.f549i == null) {
                this.f549i = N(actionModeCallbackWrapperV9);
            }
            O();
            return this.f549i;
        }
        throw new IllegalArgumentException("ActionMode callback can not be null.");
    }

    public void t() {
        ViewPropertyAnimatorCompat viewPropertyAnimatorCompat = this.f553m;
        if (viewPropertyAnimatorCompat != null) {
            viewPropertyAnimatorCompat.cancel();
        }
    }

    public PanelFeatureState u(Menu menu) {
        int i11;
        PanelFeatureState[] panelFeatureStateArr = this.mPanels;
        if (panelFeatureStateArr != null) {
            i11 = panelFeatureStateArr.length;
        } else {
            i11 = 0;
        }
        for (int i12 = 0; i12 < i11; i12++) {
            PanelFeatureState panelFeatureState = panelFeatureStateArr[i12];
            if (panelFeatureState != null && panelFeatureState.f590j == menu) {
                return panelFeatureState;
            }
        }
        return null;
    }

    public final Context v() {
        Context context;
        ActionBar supportActionBar = getSupportActionBar();
        if (supportActionBar != null) {
            context = supportActionBar.getThemedContext();
        } else {
            context = null;
        }
        if (context == null) {
            return this.f544d;
        }
        return context;
    }

    public LocaleListCompat w(Configuration configuration) {
        if (Build.VERSION.SDK_INT >= 24) {
            return Api24Impl.b(configuration);
        }
        return LocaleListCompat.forLanguageTags(Api21Impl.b(configuration.locale));
    }

    public PanelFeatureState x(int i11, boolean z11) {
        PanelFeatureState[] panelFeatureStateArr = this.mPanels;
        if (panelFeatureStateArr == null || panelFeatureStateArr.length <= i11) {
            PanelFeatureState[] panelFeatureStateArr2 = new PanelFeatureState[(i11 + 1)];
            if (panelFeatureStateArr != null) {
                System.arraycopy(panelFeatureStateArr, 0, panelFeatureStateArr2, 0, panelFeatureStateArr.length);
            }
            this.mPanels = panelFeatureStateArr2;
            panelFeatureStateArr = panelFeatureStateArr2;
        }
        PanelFeatureState panelFeatureState = panelFeatureStateArr[i11];
        if (panelFeatureState != null) {
            return panelFeatureState;
        }
        PanelFeatureState panelFeatureState2 = new PanelFeatureState(i11);
        panelFeatureStateArr[i11] = panelFeatureState2;
        return panelFeatureState2;
    }

    public final CharSequence y() {
        Object obj = this.f543c;
        if (obj instanceof Activity) {
            return ((Activity) obj).getTitle();
        }
        return this.mTitle;
    }

    public final Window.Callback z() {
        return this.f545e.getCallback();
    }

    public AppCompatDelegateImpl(Dialog dialog, AppCompatCallback appCompatCallback) {
        this(dialog.getContext(), dialog.getWindow(), appCompatCallback, dialog);
    }

    private boolean applyApplicationSpecificConfig(boolean z11, boolean z12) {
        if (this.f560t) {
            return false;
        }
        int calculateNightMode = calculateNightMode();
        int A = A(this.f544d, calculateNightMode);
        LocaleListCompat l11 = Build.VERSION.SDK_INT < 33 ? l(this.f544d) : null;
        if (!z12 && l11 != null) {
            l11 = w(this.f544d.getResources().getConfiguration());
        }
        boolean updateAppConfiguration = updateAppConfiguration(A, l11, z11);
        if (calculateNightMode == 0) {
            getAutoTimeNightModeManager(this.f544d).c();
        } else {
            AutoNightModeManager autoNightModeManager = this.mAutoTimeNightModeManager;
            if (autoNightModeManager != null) {
                autoNightModeManager.a();
            }
        }
        if (calculateNightMode == 3) {
            getAutoBatteryNightModeManager(this.f544d).c();
        } else {
            AutoNightModeManager autoNightModeManager2 = this.mAutoBatteryNightModeManager;
            if (autoNightModeManager2 != null) {
                autoNightModeManager2.a();
            }
        }
        return updateAppConfiguration;
    }

    public View onCreateView(String str, Context context, AttributeSet attributeSet) {
        return onCreateView((View) null, str, context, attributeSet);
    }

    public AppCompatDelegateImpl(Context context, Window window, AppCompatCallback appCompatCallback) {
        this(context, window, appCompatCallback, context);
    }

    public AppCompatDelegateImpl(Context context, Activity activity, AppCompatCallback appCompatCallback) {
        this(context, (Window) null, appCompatCallback, activity);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:9:0x0036, code lost:
        r3 = sLocalNightModes;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private AppCompatDelegateImpl(android.content.Context r3, android.view.Window r4, androidx.appcompat.app.AppCompatCallback r5, java.lang.Object r6) {
        /*
            r2 = this;
            r2.<init>()
            r0 = 0
            r2.f553m = r0
            r0 = 1
            r2.mHandleNativeActionModes = r0
            r0 = -100
            r2.mLocalNightMode = r0
            androidx.appcompat.app.AppCompatDelegateImpl$2 r1 = new androidx.appcompat.app.AppCompatDelegateImpl$2
            r1.<init>()
            r2.mInvalidatePanelMenuRunnable = r1
            r2.f544d = r3
            r2.f546f = r5
            r2.f543c = r6
            int r3 = r2.mLocalNightMode
            if (r3 != r0) goto L_0x0032
            boolean r3 = r6 instanceof android.app.Dialog
            if (r3 == 0) goto L_0x0032
            androidx.appcompat.app.AppCompatActivity r3 = r2.tryUnwrapContext()
            if (r3 == 0) goto L_0x0032
            androidx.appcompat.app.AppCompatDelegate r3 = r3.getDelegate()
            int r3 = r3.getLocalNightMode()
            r2.mLocalNightMode = r3
        L_0x0032:
            int r3 = r2.mLocalNightMode
            if (r3 != r0) goto L_0x0059
            androidx.collection.SimpleArrayMap<java.lang.String, java.lang.Integer> r3 = sLocalNightModes
            java.lang.Class r5 = r6.getClass()
            java.lang.String r5 = r5.getName()
            java.lang.Object r5 = r3.get(r5)
            java.lang.Integer r5 = (java.lang.Integer) r5
            if (r5 == 0) goto L_0x0059
            int r5 = r5.intValue()
            r2.mLocalNightMode = r5
            java.lang.Class r5 = r6.getClass()
            java.lang.String r5 = r5.getName()
            r3.remove(r5)
        L_0x0059:
            if (r4 == 0) goto L_0x005e
            r2.attachToWindow(r4)
        L_0x005e:
            androidx.appcompat.widget.AppCompatDrawableManager.preload()
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.appcompat.app.AppCompatDelegateImpl.<init>(android.content.Context, android.view.Window, androidx.appcompat.app.AppCompatCallback, java.lang.Object):void");
    }

    public void setContentView(int i11) {
        ensureSubDecor();
        ViewGroup viewGroup = (ViewGroup) this.f554n.findViewById(16908290);
        viewGroup.removeAllViews();
        LayoutInflater.from(this.f544d).inflate(i11, viewGroup);
        this.mAppCompatWindowCallback.bypassOnContentChanged(this.f545e.getCallback());
    }

    public void setContentView(View view, ViewGroup.LayoutParams layoutParams) {
        ensureSubDecor();
        ViewGroup viewGroup = (ViewGroup) this.f554n.findViewById(16908290);
        viewGroup.removeAllViews();
        viewGroup.addView(view, layoutParams);
        this.mAppCompatWindowCallback.bypassOnContentChanged(this.f545e.getCallback());
    }
}
