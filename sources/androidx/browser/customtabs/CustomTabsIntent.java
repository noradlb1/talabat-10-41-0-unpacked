package androidx.browser.customtabs;

import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.IBinder;
import android.os.LocaleList;
import android.text.TextUtils;
import android.util.SparseArray;
import android.widget.RemoteViews;
import androidx.annotation.AnimRes;
import androidx.annotation.ColorInt;
import androidx.annotation.Dimension;
import androidx.annotation.DoNotInline;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.annotation.RestrictTo;
import androidx.browser.customtabs.CustomTabColorSchemeParams;
import androidx.browser.customtabs.CustomTabsSession;
import androidx.core.app.ActivityOptionsCompat;
import androidx.core.app.BundleCompat;
import androidx.core.content.ContextCompat;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.ArrayList;

public final class CustomTabsIntent {
    public static final int ACTIVITY_HEIGHT_ADJUSTABLE = 1;
    public static final int ACTIVITY_HEIGHT_DEFAULT = 0;
    public static final int ACTIVITY_HEIGHT_FIXED = 2;
    private static final int ACTIVITY_HEIGHT_MAX = 2;
    public static final int CLOSE_BUTTON_POSITION_DEFAULT = 0;
    public static final int CLOSE_BUTTON_POSITION_END = 2;
    private static final int CLOSE_BUTTON_POSITION_MAX = 2;
    public static final int CLOSE_BUTTON_POSITION_START = 1;
    public static final int COLOR_SCHEME_DARK = 2;
    public static final int COLOR_SCHEME_LIGHT = 1;
    private static final int COLOR_SCHEME_MAX = 2;
    public static final int COLOR_SCHEME_SYSTEM = 0;
    public static final String EXTRA_ACTION_BUTTON_BUNDLE = "android.support.customtabs.extra.ACTION_BUTTON_BUNDLE";
    public static final String EXTRA_ACTIVITY_HEIGHT_RESIZE_BEHAVIOR = "androidx.browser.customtabs.extra.ACTIVITY_HEIGHT_RESIZE_BEHAVIOR";
    public static final String EXTRA_CLOSE_BUTTON_ICON = "android.support.customtabs.extra.CLOSE_BUTTON_ICON";
    public static final String EXTRA_CLOSE_BUTTON_POSITION = "androidx.browser.customtabs.extra.CLOSE_BUTTON_POSITION";
    public static final String EXTRA_COLOR_SCHEME = "androidx.browser.customtabs.extra.COLOR_SCHEME";
    public static final String EXTRA_COLOR_SCHEME_PARAMS = "androidx.browser.customtabs.extra.COLOR_SCHEME_PARAMS";
    @Deprecated
    public static final String EXTRA_DEFAULT_SHARE_MENU_ITEM = "android.support.customtabs.extra.SHARE_MENU_ITEM";
    public static final String EXTRA_ENABLE_INSTANT_APPS = "android.support.customtabs.extra.EXTRA_ENABLE_INSTANT_APPS";
    public static final String EXTRA_ENABLE_URLBAR_HIDING = "android.support.customtabs.extra.ENABLE_URLBAR_HIDING";
    public static final String EXTRA_EXIT_ANIMATION_BUNDLE = "android.support.customtabs.extra.EXIT_ANIMATION_BUNDLE";
    public static final String EXTRA_INITIAL_ACTIVITY_HEIGHT_PX = "androidx.browser.customtabs.extra.INITIAL_ACTIVITY_HEIGHT_PX";
    public static final String EXTRA_MENU_ITEMS = "android.support.customtabs.extra.MENU_ITEMS";
    public static final String EXTRA_NAVIGATION_BAR_COLOR = "androidx.browser.customtabs.extra.NAVIGATION_BAR_COLOR";
    public static final String EXTRA_NAVIGATION_BAR_DIVIDER_COLOR = "androidx.browser.customtabs.extra.NAVIGATION_BAR_DIVIDER_COLOR";
    public static final String EXTRA_REMOTEVIEWS = "android.support.customtabs.extra.EXTRA_REMOTEVIEWS";
    public static final String EXTRA_REMOTEVIEWS_CLICKED_ID = "android.support.customtabs.extra.EXTRA_REMOTEVIEWS_CLICKED_ID";
    public static final String EXTRA_REMOTEVIEWS_PENDINGINTENT = "android.support.customtabs.extra.EXTRA_REMOTEVIEWS_PENDINGINTENT";
    public static final String EXTRA_REMOTEVIEWS_VIEW_IDS = "android.support.customtabs.extra.EXTRA_REMOTEVIEWS_VIEW_IDS";
    public static final String EXTRA_SECONDARY_TOOLBAR_COLOR = "android.support.customtabs.extra.SECONDARY_TOOLBAR_COLOR";
    public static final String EXTRA_SESSION = "android.support.customtabs.extra.SESSION";
    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public static final String EXTRA_SESSION_ID = "android.support.customtabs.extra.SESSION_ID";
    public static final String EXTRA_SHARE_STATE = "androidx.browser.customtabs.extra.SHARE_STATE";
    public static final String EXTRA_TINT_ACTION_BUTTON = "android.support.customtabs.extra.TINT_ACTION_BUTTON";
    public static final String EXTRA_TITLE_VISIBILITY_STATE = "android.support.customtabs.extra.TITLE_VISIBILITY";
    public static final String EXTRA_TOOLBAR_COLOR = "android.support.customtabs.extra.TOOLBAR_COLOR";
    public static final String EXTRA_TOOLBAR_CORNER_RADIUS_DP = "androidx.browser.customtabs.extra.TOOLBAR_CORNER_RADIUS_DP";
    public static final String EXTRA_TOOLBAR_ITEMS = "android.support.customtabs.extra.TOOLBAR_ITEMS";
    private static final String EXTRA_USER_OPT_OUT_FROM_CUSTOM_TABS = "android.support.customtabs.extra.user_opt_out";
    private static final String HTTP_ACCEPT_LANGUAGE = "Accept-Language";
    public static final String KEY_DESCRIPTION = "android.support.customtabs.customaction.DESCRIPTION";
    public static final String KEY_ICON = "android.support.customtabs.customaction.ICON";
    public static final String KEY_ID = "android.support.customtabs.customaction.ID";
    public static final String KEY_MENU_ITEM_TITLE = "android.support.customtabs.customaction.MENU_ITEM_TITLE";
    public static final String KEY_PENDING_INTENT = "android.support.customtabs.customaction.PENDING_INTENT";
    private static final int MAX_TOOLBAR_CORNER_RADIUS_DP = 16;
    private static final int MAX_TOOLBAR_ITEMS = 5;
    public static final int NO_TITLE = 0;
    public static final int SHARE_STATE_DEFAULT = 0;
    private static final int SHARE_STATE_MAX = 2;
    public static final int SHARE_STATE_OFF = 2;
    public static final int SHARE_STATE_ON = 1;
    public static final int SHOW_PAGE_TITLE = 1;
    public static final int TOOLBAR_ACTION_BUTTON_ID = 0;
    @NonNull
    public final Intent intent;
    @Nullable
    public final Bundle startAnimationBundle;

    @RestrictTo({RestrictTo.Scope.LIBRARY})
    @Retention(RetentionPolicy.SOURCE)
    public @interface ActivityHeightResizeBehavior {
    }

    @RequiresApi(api = 24)
    public static class Api24Impl {
        private Api24Impl() {
        }

        @DoNotInline
        @Nullable
        public static String a() {
            LocaleList a11 = LocaleList.getAdjustedDefault();
            if (a11.size() > 0) {
                return a11.get(0).toLanguageTag();
            }
            return null;
        }
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY})
    @Retention(RetentionPolicy.SOURCE)
    public @interface CloseButtonPosition {
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY})
    @Retention(RetentionPolicy.SOURCE)
    public @interface ColorScheme {
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY})
    @Retention(RetentionPolicy.SOURCE)
    public @interface ShareState {
    }

    public CustomTabsIntent(@NonNull Intent intent2, @Nullable Bundle bundle) {
        this.intent = intent2;
        this.startAnimationBundle = bundle;
    }

    public static int getActivityResizeBehavior(@NonNull Intent intent2) {
        return intent2.getIntExtra(EXTRA_ACTIVITY_HEIGHT_RESIZE_BEHAVIOR, 0);
    }

    public static int getCloseButtonPosition(@NonNull Intent intent2) {
        return intent2.getIntExtra(EXTRA_CLOSE_BUTTON_POSITION, 0);
    }

    @NonNull
    public static CustomTabColorSchemeParams getColorSchemeParams(@NonNull Intent intent2, int i11) {
        Bundle bundle;
        if (i11 < 0 || i11 > 2 || i11 == 0) {
            throw new IllegalArgumentException("Invalid colorScheme: " + i11);
        }
        Bundle extras = intent2.getExtras();
        if (extras == null) {
            return CustomTabColorSchemeParams.a((Bundle) null);
        }
        CustomTabColorSchemeParams a11 = CustomTabColorSchemeParams.a(extras);
        SparseArray sparseParcelableArray = extras.getSparseParcelableArray(EXTRA_COLOR_SCHEME_PARAMS);
        if (sparseParcelableArray == null || (bundle = (Bundle) sparseParcelableArray.get(i11)) == null) {
            return a11;
        }
        return CustomTabColorSchemeParams.a(bundle).c(a11);
    }

    @Dimension(unit = 1)
    public static int getInitialActivityHeightPx(@NonNull Intent intent2) {
        return intent2.getIntExtra(EXTRA_INITIAL_ACTIVITY_HEIGHT_PX, 0);
    }

    public static int getMaxToolbarItems() {
        return 5;
    }

    @Dimension(unit = 0)
    public static int getToolbarCornerRadiusDp(@NonNull Intent intent2) {
        return intent2.getIntExtra(EXTRA_TOOLBAR_CORNER_RADIUS_DP, 16);
    }

    @NonNull
    public static Intent setAlwaysUseBrowserUI(@Nullable Intent intent2) {
        if (intent2 == null) {
            intent2 = new Intent("android.intent.action.VIEW");
        }
        intent2.addFlags(268435456);
        intent2.putExtra(EXTRA_USER_OPT_OUT_FROM_CUSTOM_TABS, true);
        return intent2;
    }

    public static boolean shouldAlwaysUseBrowserUI(@NonNull Intent intent2) {
        if (!intent2.getBooleanExtra(EXTRA_USER_OPT_OUT_FROM_CUSTOM_TABS, false) || (intent2.getFlags() & 268435456) == 0) {
            return false;
        }
        return true;
    }

    public void launchUrl(@NonNull Context context, @NonNull Uri uri) {
        this.intent.setData(uri);
        ContextCompat.startActivity(context, this.intent, this.startAnimationBundle);
    }

    public static final class Builder {
        @Nullable
        private ArrayList<Bundle> mActionButtons;
        @Nullable
        private SparseArray<Bundle> mColorSchemeParamBundles;
        private final CustomTabColorSchemeParams.Builder mDefaultColorSchemeBuilder = new CustomTabColorSchemeParams.Builder();
        @Nullable
        private Bundle mDefaultColorSchemeBundle;
        private boolean mInstantAppsEnabled = true;
        private final Intent mIntent = new Intent("android.intent.action.VIEW");
        @Nullable
        private ArrayList<Bundle> mMenuItems;
        private int mShareState = 0;
        @Nullable
        private Bundle mStartAnimationBundle;

        public Builder() {
        }

        @RequiresApi(api = 24)
        private void setCurrentLocaleAsDefaultAcceptLanguage() {
            Bundle bundle;
            String a11 = Api24Impl.a();
            if (!TextUtils.isEmpty(a11)) {
                if (this.mIntent.hasExtra("com.android.browser.headers")) {
                    bundle = this.mIntent.getBundleExtra("com.android.browser.headers");
                } else {
                    bundle = new Bundle();
                }
                if (!bundle.containsKey("Accept-Language")) {
                    bundle.putString("Accept-Language", a11);
                    this.mIntent.putExtra("com.android.browser.headers", bundle);
                }
            }
        }

        private void setSessionParameters(@Nullable IBinder iBinder, @Nullable PendingIntent pendingIntent) {
            Bundle bundle = new Bundle();
            BundleCompat.putBinder(bundle, CustomTabsIntent.EXTRA_SESSION, iBinder);
            if (pendingIntent != null) {
                bundle.putParcelable(CustomTabsIntent.EXTRA_SESSION_ID, pendingIntent);
            }
            this.mIntent.putExtras(bundle);
        }

        @NonNull
        @Deprecated
        public Builder addDefaultShareMenuItem() {
            setShareState(1);
            return this;
        }

        @NonNull
        public Builder addMenuItem(@NonNull String str, @NonNull PendingIntent pendingIntent) {
            if (this.mMenuItems == null) {
                this.mMenuItems = new ArrayList<>();
            }
            Bundle bundle = new Bundle();
            bundle.putString(CustomTabsIntent.KEY_MENU_ITEM_TITLE, str);
            bundle.putParcelable(CustomTabsIntent.KEY_PENDING_INTENT, pendingIntent);
            this.mMenuItems.add(bundle);
            return this;
        }

        @NonNull
        @Deprecated
        public Builder addToolbarItem(int i11, @NonNull Bitmap bitmap, @NonNull String str, @NonNull PendingIntent pendingIntent) throws IllegalStateException {
            if (this.mActionButtons == null) {
                this.mActionButtons = new ArrayList<>();
            }
            if (this.mActionButtons.size() < 5) {
                Bundle bundle = new Bundle();
                bundle.putInt(CustomTabsIntent.KEY_ID, i11);
                bundle.putParcelable(CustomTabsIntent.KEY_ICON, bitmap);
                bundle.putString(CustomTabsIntent.KEY_DESCRIPTION, str);
                bundle.putParcelable(CustomTabsIntent.KEY_PENDING_INTENT, pendingIntent);
                this.mActionButtons.add(bundle);
                return this;
            }
            throw new IllegalStateException("Exceeded maximum toolbar item count of 5");
        }

        @NonNull
        public CustomTabsIntent build() {
            if (!this.mIntent.hasExtra(CustomTabsIntent.EXTRA_SESSION)) {
                setSessionParameters((IBinder) null, (PendingIntent) null);
            }
            ArrayList<Bundle> arrayList = this.mMenuItems;
            if (arrayList != null) {
                this.mIntent.putParcelableArrayListExtra(CustomTabsIntent.EXTRA_MENU_ITEMS, arrayList);
            }
            ArrayList<Bundle> arrayList2 = this.mActionButtons;
            if (arrayList2 != null) {
                this.mIntent.putParcelableArrayListExtra(CustomTabsIntent.EXTRA_TOOLBAR_ITEMS, arrayList2);
            }
            this.mIntent.putExtra(CustomTabsIntent.EXTRA_ENABLE_INSTANT_APPS, this.mInstantAppsEnabled);
            this.mIntent.putExtras(this.mDefaultColorSchemeBuilder.build().b());
            Bundle bundle = this.mDefaultColorSchemeBundle;
            if (bundle != null) {
                this.mIntent.putExtras(bundle);
            }
            if (this.mColorSchemeParamBundles != null) {
                Bundle bundle2 = new Bundle();
                bundle2.putSparseParcelableArray(CustomTabsIntent.EXTRA_COLOR_SCHEME_PARAMS, this.mColorSchemeParamBundles);
                this.mIntent.putExtras(bundle2);
            }
            this.mIntent.putExtra(CustomTabsIntent.EXTRA_SHARE_STATE, this.mShareState);
            if (Build.VERSION.SDK_INT >= 24) {
                setCurrentLocaleAsDefaultAcceptLanguage();
            }
            return new CustomTabsIntent(this.mIntent, this.mStartAnimationBundle);
        }

        @NonNull
        @Deprecated
        public Builder enableUrlBarHiding() {
            this.mIntent.putExtra(CustomTabsIntent.EXTRA_ENABLE_URLBAR_HIDING, true);
            return this;
        }

        @NonNull
        public Builder setActionButton(@NonNull Bitmap bitmap, @NonNull String str, @NonNull PendingIntent pendingIntent, boolean z11) {
            Bundle bundle = new Bundle();
            bundle.putInt(CustomTabsIntent.KEY_ID, 0);
            bundle.putParcelable(CustomTabsIntent.KEY_ICON, bitmap);
            bundle.putString(CustomTabsIntent.KEY_DESCRIPTION, str);
            bundle.putParcelable(CustomTabsIntent.KEY_PENDING_INTENT, pendingIntent);
            this.mIntent.putExtra(CustomTabsIntent.EXTRA_ACTION_BUTTON_BUNDLE, bundle);
            this.mIntent.putExtra(CustomTabsIntent.EXTRA_TINT_ACTION_BUTTON, z11);
            return this;
        }

        @NonNull
        public Builder setCloseButtonIcon(@NonNull Bitmap bitmap) {
            this.mIntent.putExtra(CustomTabsIntent.EXTRA_CLOSE_BUTTON_ICON, bitmap);
            return this;
        }

        @NonNull
        public Builder setCloseButtonPosition(int i11) {
            if (i11 < 0 || i11 > 2) {
                throw new IllegalArgumentException("Invalid value for the position argument");
            }
            this.mIntent.putExtra(CustomTabsIntent.EXTRA_CLOSE_BUTTON_POSITION, i11);
            return this;
        }

        @NonNull
        public Builder setColorScheme(int i11) {
            if (i11 < 0 || i11 > 2) {
                throw new IllegalArgumentException("Invalid value for the colorScheme argument");
            }
            this.mIntent.putExtra(CustomTabsIntent.EXTRA_COLOR_SCHEME, i11);
            return this;
        }

        @NonNull
        public Builder setColorSchemeParams(int i11, @NonNull CustomTabColorSchemeParams customTabColorSchemeParams) {
            if (i11 < 0 || i11 > 2 || i11 == 0) {
                throw new IllegalArgumentException("Invalid colorScheme: " + i11);
            }
            if (this.mColorSchemeParamBundles == null) {
                this.mColorSchemeParamBundles = new SparseArray<>();
            }
            this.mColorSchemeParamBundles.put(i11, customTabColorSchemeParams.b());
            return this;
        }

        @NonNull
        public Builder setDefaultColorSchemeParams(@NonNull CustomTabColorSchemeParams customTabColorSchemeParams) {
            this.mDefaultColorSchemeBundle = customTabColorSchemeParams.b();
            return this;
        }

        @NonNull
        @Deprecated
        public Builder setDefaultShareMenuItemEnabled(boolean z11) {
            if (z11) {
                setShareState(1);
            } else {
                setShareState(2);
            }
            return this;
        }

        @NonNull
        public Builder setExitAnimations(@NonNull Context context, @AnimRes int i11, @AnimRes int i12) {
            this.mIntent.putExtra(CustomTabsIntent.EXTRA_EXIT_ANIMATION_BUNDLE, ActivityOptionsCompat.makeCustomAnimation(context, i11, i12).toBundle());
            return this;
        }

        @NonNull
        public Builder setInitialActivityHeightPx(@Dimension(unit = 1) int i11, int i12) {
            if (i11 <= 0) {
                throw new IllegalArgumentException("Invalid value for the initialHeightPx argument");
            } else if (i12 < 0 || i12 > 2) {
                throw new IllegalArgumentException("Invalid value for the activityHeightResizeBehavior argument");
            } else {
                this.mIntent.putExtra(CustomTabsIntent.EXTRA_INITIAL_ACTIVITY_HEIGHT_PX, i11);
                this.mIntent.putExtra(CustomTabsIntent.EXTRA_ACTIVITY_HEIGHT_RESIZE_BEHAVIOR, i12);
                return this;
            }
        }

        @NonNull
        public Builder setInstantAppsEnabled(boolean z11) {
            this.mInstantAppsEnabled = z11;
            return this;
        }

        @NonNull
        @Deprecated
        public Builder setNavigationBarColor(@ColorInt int i11) {
            this.mDefaultColorSchemeBuilder.setNavigationBarColor(i11);
            return this;
        }

        @NonNull
        @Deprecated
        public Builder setNavigationBarDividerColor(@ColorInt int i11) {
            this.mDefaultColorSchemeBuilder.setNavigationBarDividerColor(i11);
            return this;
        }

        @NonNull
        @RestrictTo({RestrictTo.Scope.LIBRARY})
        public Builder setPendingSession(@NonNull CustomTabsSession.PendingSession pendingSession) {
            setSessionParameters((IBinder) null, pendingSession.b());
            return this;
        }

        @NonNull
        @Deprecated
        public Builder setSecondaryToolbarColor(@ColorInt int i11) {
            this.mDefaultColorSchemeBuilder.setSecondaryToolbarColor(i11);
            return this;
        }

        @NonNull
        public Builder setSecondaryToolbarViews(@NonNull RemoteViews remoteViews, @Nullable int[] iArr, @Nullable PendingIntent pendingIntent) {
            this.mIntent.putExtra(CustomTabsIntent.EXTRA_REMOTEVIEWS, remoteViews);
            this.mIntent.putExtra(CustomTabsIntent.EXTRA_REMOTEVIEWS_VIEW_IDS, iArr);
            this.mIntent.putExtra(CustomTabsIntent.EXTRA_REMOTEVIEWS_PENDINGINTENT, pendingIntent);
            return this;
        }

        @NonNull
        public Builder setSession(@NonNull CustomTabsSession customTabsSession) {
            this.mIntent.setPackage(customTabsSession.b().getPackageName());
            setSessionParameters(customTabsSession.a(), customTabsSession.c());
            return this;
        }

        @NonNull
        public Builder setShareState(int i11) {
            if (i11 < 0 || i11 > 2) {
                throw new IllegalArgumentException("Invalid value for the shareState argument");
            }
            this.mShareState = i11;
            if (i11 == 1) {
                this.mIntent.putExtra(CustomTabsIntent.EXTRA_DEFAULT_SHARE_MENU_ITEM, true);
            } else if (i11 == 2) {
                this.mIntent.putExtra(CustomTabsIntent.EXTRA_DEFAULT_SHARE_MENU_ITEM, false);
            } else {
                this.mIntent.removeExtra(CustomTabsIntent.EXTRA_DEFAULT_SHARE_MENU_ITEM);
            }
            return this;
        }

        @NonNull
        public Builder setShowTitle(boolean z11) {
            this.mIntent.putExtra(CustomTabsIntent.EXTRA_TITLE_VISIBILITY_STATE, z11 ? 1 : 0);
            return this;
        }

        @NonNull
        public Builder setStartAnimations(@NonNull Context context, @AnimRes int i11, @AnimRes int i12) {
            this.mStartAnimationBundle = ActivityOptionsCompat.makeCustomAnimation(context, i11, i12).toBundle();
            return this;
        }

        @NonNull
        @Deprecated
        public Builder setToolbarColor(@ColorInt int i11) {
            this.mDefaultColorSchemeBuilder.setToolbarColor(i11);
            return this;
        }

        @NonNull
        public Builder setToolbarCornerRadiusDp(@Dimension(unit = 0) int i11) {
            if (i11 < 0 || i11 > 16) {
                throw new IllegalArgumentException("Invalid value for the cornerRadiusDp argument");
            }
            this.mIntent.putExtra(CustomTabsIntent.EXTRA_TOOLBAR_CORNER_RADIUS_DP, i11);
            return this;
        }

        @NonNull
        public Builder setUrlBarHidingEnabled(boolean z11) {
            this.mIntent.putExtra(CustomTabsIntent.EXTRA_ENABLE_URLBAR_HIDING, z11);
            return this;
        }

        @NonNull
        public Builder setInitialActivityHeightPx(@Dimension(unit = 1) int i11) {
            return setInitialActivityHeightPx(i11, 0);
        }

        public Builder(@Nullable CustomTabsSession customTabsSession) {
            if (customTabsSession != null) {
                setSession(customTabsSession);
            }
        }

        @NonNull
        public Builder setActionButton(@NonNull Bitmap bitmap, @NonNull String str, @NonNull PendingIntent pendingIntent) {
            return setActionButton(bitmap, str, pendingIntent, false);
        }
    }
}
