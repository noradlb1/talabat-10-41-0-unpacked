package androidx.browser.customtabs;

import android.app.PendingIntent;
import android.app.Service;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.IBinder;
import android.os.RemoteException;
import android.support.customtabs.ICustomTabsCallback;
import android.support.customtabs.ICustomTabsService;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
import androidx.collection.SimpleArrayMap;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.List;
import java.util.NoSuchElementException;

public abstract class CustomTabsService extends Service {
    public static final String ACTION_CUSTOM_TABS_CONNECTION = "android.support.customtabs.action.CustomTabsService";
    public static final String CATEGORY_COLOR_SCHEME_CUSTOMIZATION = "androidx.browser.customtabs.category.ColorSchemeCustomization";
    public static final String CATEGORY_NAVBAR_COLOR_CUSTOMIZATION = "androidx.browser.customtabs.category.NavBarColorCustomization";
    public static final String CATEGORY_TRUSTED_WEB_ACTIVITY_IMMERSIVE_MODE = "androidx.browser.trusted.category.ImmersiveMode";
    public static final String CATEGORY_WEB_SHARE_TARGET_V2 = "androidx.browser.trusted.category.WebShareTargetV2";
    public static final int FILE_PURPOSE_TRUSTED_WEB_ACTIVITY_SPLASH_IMAGE = 1;
    public static final String KEY_SUCCESS = "androidx.browser.customtabs.SUCCESS";
    public static final String KEY_URL = "android.support.customtabs.otherurls.URL";
    public static final int RELATION_HANDLE_ALL_URLS = 2;
    public static final int RELATION_USE_AS_ORIGIN = 1;
    public static final int RESULT_FAILURE_DISALLOWED = -1;
    public static final int RESULT_FAILURE_MESSAGING_ERROR = -3;
    public static final int RESULT_FAILURE_REMOTE_ERROR = -2;
    public static final int RESULT_SUCCESS = 0;
    public static final String TRUSTED_WEB_ACTIVITY_CATEGORY = "androidx.browser.trusted.category.TrustedWebActivities";

    /* renamed from: b  reason: collision with root package name */
    public final SimpleArrayMap<IBinder, IBinder.DeathRecipient> f1001b = new SimpleArrayMap<>();
    private ICustomTabsService.Stub mBinder = new ICustomTabsService.Stub() {
        @Nullable
        private PendingIntent getSessionIdFromBundle(@Nullable Bundle bundle) {
            if (bundle == null) {
                return null;
            }
            PendingIntent pendingIntent = (PendingIntent) bundle.getParcelable(CustomTabsIntent.EXTRA_SESSION_ID);
            bundle.remove(CustomTabsIntent.EXTRA_SESSION_ID);
            return pendingIntent;
        }

        /* access modifiers changed from: private */
        public /* synthetic */ void lambda$newSessionInternal$0(CustomTabsSessionToken customTabsSessionToken) {
            CustomTabsService.this.a(customTabsSessionToken);
        }

        private boolean newSessionInternal(@NonNull ICustomTabsCallback iCustomTabsCallback, @Nullable PendingIntent pendingIntent) {
            CustomTabsSessionToken customTabsSessionToken = new CustomTabsSessionToken(iCustomTabsCallback, pendingIntent);
            try {
                a aVar = new a(this, customTabsSessionToken);
                synchronized (CustomTabsService.this.f1001b) {
                    iCustomTabsCallback.asBinder().linkToDeath(aVar, 0);
                    CustomTabsService.this.f1001b.put(iCustomTabsCallback.asBinder(), aVar);
                }
                return CustomTabsService.this.d(customTabsSessionToken);
            } catch (RemoteException unused) {
                return false;
            }
        }

        public Bundle extraCommand(@NonNull String str, @Nullable Bundle bundle) {
            return CustomTabsService.this.b(str, bundle);
        }

        public boolean mayLaunchUrl(@Nullable ICustomTabsCallback iCustomTabsCallback, @Nullable Uri uri, @Nullable Bundle bundle, @Nullable List<Bundle> list) {
            return CustomTabsService.this.c(new CustomTabsSessionToken(iCustomTabsCallback, getSessionIdFromBundle(bundle)), uri, bundle, list);
        }

        public boolean newSession(@NonNull ICustomTabsCallback iCustomTabsCallback) {
            return newSessionInternal(iCustomTabsCallback, (PendingIntent) null);
        }

        public boolean newSessionWithExtras(@NonNull ICustomTabsCallback iCustomTabsCallback, @Nullable Bundle bundle) {
            return newSessionInternal(iCustomTabsCallback, getSessionIdFromBundle(bundle));
        }

        public int postMessage(@NonNull ICustomTabsCallback iCustomTabsCallback, @NonNull String str, @Nullable Bundle bundle) {
            return CustomTabsService.this.e(new CustomTabsSessionToken(iCustomTabsCallback, getSessionIdFromBundle(bundle)), str, bundle);
        }

        public boolean receiveFile(@NonNull ICustomTabsCallback iCustomTabsCallback, @NonNull Uri uri, int i11, @Nullable Bundle bundle) {
            return CustomTabsService.this.f(new CustomTabsSessionToken(iCustomTabsCallback, getSessionIdFromBundle(bundle)), uri, i11, bundle);
        }

        public boolean requestPostMessageChannel(@NonNull ICustomTabsCallback iCustomTabsCallback, @NonNull Uri uri) {
            return CustomTabsService.this.g(new CustomTabsSessionToken(iCustomTabsCallback, (PendingIntent) null), uri);
        }

        public boolean requestPostMessageChannelWithExtras(@NonNull ICustomTabsCallback iCustomTabsCallback, @NonNull Uri uri, @NonNull Bundle bundle) {
            return CustomTabsService.this.g(new CustomTabsSessionToken(iCustomTabsCallback, getSessionIdFromBundle(bundle)), uri);
        }

        public boolean updateVisuals(@NonNull ICustomTabsCallback iCustomTabsCallback, @Nullable Bundle bundle) {
            return CustomTabsService.this.h(new CustomTabsSessionToken(iCustomTabsCallback, getSessionIdFromBundle(bundle)), bundle);
        }

        public boolean validateRelationship(@NonNull ICustomTabsCallback iCustomTabsCallback, int i11, @NonNull Uri uri, @Nullable Bundle bundle) {
            return CustomTabsService.this.i(new CustomTabsSessionToken(iCustomTabsCallback, getSessionIdFromBundle(bundle)), i11, uri, bundle);
        }

        public boolean warmup(long j11) {
            return CustomTabsService.this.j(j11);
        }
    };

    @RestrictTo({RestrictTo.Scope.LIBRARY})
    @Retention(RetentionPolicy.SOURCE)
    public @interface FilePurpose {
    }

    @Retention(RetentionPolicy.SOURCE)
    public @interface Relation {
    }

    @Retention(RetentionPolicy.SOURCE)
    public @interface Result {
    }

    public boolean a(@NonNull CustomTabsSessionToken customTabsSessionToken) {
        try {
            synchronized (this.f1001b) {
                IBinder a11 = customTabsSessionToken.a();
                if (a11 == null) {
                    return false;
                }
                a11.unlinkToDeath(this.f1001b.get(a11), 0);
                this.f1001b.remove(a11);
                return true;
            }
        } catch (NoSuchElementException unused) {
            return false;
        }
    }

    @Nullable
    public abstract Bundle b(@NonNull String str, @Nullable Bundle bundle);

    public abstract boolean c(@NonNull CustomTabsSessionToken customTabsSessionToken, @Nullable Uri uri, @Nullable Bundle bundle, @Nullable List<Bundle> list);

    public abstract boolean d(@NonNull CustomTabsSessionToken customTabsSessionToken);

    public abstract int e(@NonNull CustomTabsSessionToken customTabsSessionToken, @NonNull String str, @Nullable Bundle bundle);

    public abstract boolean f(@NonNull CustomTabsSessionToken customTabsSessionToken, @NonNull Uri uri, int i11, @Nullable Bundle bundle);

    public abstract boolean g(@NonNull CustomTabsSessionToken customTabsSessionToken, @NonNull Uri uri);

    public abstract boolean h(@NonNull CustomTabsSessionToken customTabsSessionToken, @Nullable Bundle bundle);

    public abstract boolean i(@NonNull CustomTabsSessionToken customTabsSessionToken, int i11, @NonNull Uri uri, @Nullable Bundle bundle);

    public abstract boolean j(long j11);

    @NonNull
    public IBinder onBind(@Nullable Intent intent) {
        return this.mBinder;
    }
}
