package androidx.core.content.pm;

import android.app.ActivityManager;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentSender;
import android.content.pm.ActivityInfo;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.content.pm.ShortcutInfo;
import android.content.pm.ShortcutManager;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.util.DisplayMetrics;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.annotation.RestrictTo;
import androidx.annotation.VisibleForTesting;
import androidx.core.content.pm.ShortcutInfoCompat;
import androidx.core.content.pm.ShortcutInfoCompatSaver;
import androidx.core.graphics.drawable.IconCompat;
import androidx.core.util.Preconditions;
import java.io.InputStream;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

public class ShortcutManagerCompat {
    private static final int DEFAULT_MAX_ICON_DIMENSION_DP = 96;
    private static final int DEFAULT_MAX_ICON_DIMENSION_LOWRAM_DP = 48;
    public static final String EXTRA_SHORTCUT_ID = "android.intent.extra.shortcut.ID";
    public static final int FLAG_MATCH_CACHED = 8;
    public static final int FLAG_MATCH_DYNAMIC = 2;
    public static final int FLAG_MATCH_MANIFEST = 1;
    public static final int FLAG_MATCH_PINNED = 4;
    private static final String SHORTCUT_LISTENER_INTENT_FILTER_ACTION = "androidx.core.content.pm.SHORTCUT_LISTENER";
    private static final String SHORTCUT_LISTENER_META_DATA_KEY = "androidx.core.content.pm.shortcut_listener_impl";
    private static volatile List<ShortcutInfoChangeListener> sShortcutInfoChangeListeners;
    private static volatile ShortcutInfoCompatSaver<?> sShortcutInfoCompatSaver;

    @RequiresApi(25)
    public static class Api25Impl {
        private Api25Impl() {
        }

        public static String a(@NonNull List<ShortcutInfo> list) {
            int i11 = -1;
            String str = null;
            for (ShortcutInfo next : list) {
                if (next.getRank() > i11) {
                    String a11 = next.getId();
                    str = a11;
                    i11 = next.getRank();
                }
            }
            return str;
        }
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    @Retention(RetentionPolicy.SOURCE)
    public @interface ShortcutMatchFlags {
    }

    private ShortcutManagerCompat() {
    }

    @VisibleForTesting
    public static boolean a(@NonNull Context context, @NonNull ShortcutInfoCompat shortcutInfoCompat) {
        Bitmap decodeStream;
        IconCompat iconCompat;
        IconCompat iconCompat2 = shortcutInfoCompat.f11248i;
        if (iconCompat2 == null) {
            return false;
        }
        int i11 = iconCompat2.mType;
        if (i11 != 6 && i11 != 4) {
            return true;
        }
        InputStream uriInputStream = iconCompat2.getUriInputStream(context);
        if (uriInputStream == null || (decodeStream = BitmapFactory.decodeStream(uriInputStream)) == null) {
            return false;
        }
        if (i11 == 6) {
            iconCompat = IconCompat.createWithAdaptiveBitmap(decodeStream);
        } else {
            iconCompat = IconCompat.createWithBitmap(decodeStream);
        }
        shortcutInfoCompat.f11248i = iconCompat;
        return true;
    }

    public static boolean addDynamicShortcuts(@NonNull Context context, @NonNull List<ShortcutInfoCompat> list) {
        List<ShortcutInfoCompat> removeShortcutsExcludedFromSurface = removeShortcutsExcludedFromSurface(list, 1);
        int i11 = Build.VERSION.SDK_INT;
        if (i11 <= 29) {
            b(context, removeShortcutsExcludedFromSurface);
        }
        if (i11 >= 25) {
            ArrayList arrayList = new ArrayList();
            for (ShortcutInfoCompat shortcutInfo : removeShortcutsExcludedFromSurface) {
                arrayList.add(shortcutInfo.toShortcutInfo());
            }
            if (!((ShortcutManager) context.getSystemService(ShortcutManager.class)).addDynamicShortcuts(arrayList)) {
                return false;
            }
        }
        getShortcutInfoSaverInstance(context).addShortcuts(removeShortcutsExcludedFromSurface);
        for (ShortcutInfoChangeListener onShortcutAdded : getShortcutInfoListeners(context)) {
            onShortcutAdded.onShortcutAdded(list);
        }
        return true;
    }

    @VisibleForTesting
    public static void b(@NonNull Context context, @NonNull List<ShortcutInfoCompat> list) {
        for (ShortcutInfoCompat shortcutInfoCompat : new ArrayList(list)) {
            if (!a(context, shortcutInfoCompat)) {
                list.remove(shortcutInfoCompat);
            }
        }
    }

    @NonNull
    public static Intent createShortcutResultIntent(@NonNull Context context, @NonNull ShortcutInfoCompat shortcutInfoCompat) {
        Intent intent;
        if (Build.VERSION.SDK_INT >= 26) {
            intent = ((ShortcutManager) context.getSystemService(ShortcutManager.class)).createShortcutResultIntent(shortcutInfoCompat.toShortcutInfo());
        } else {
            intent = null;
        }
        if (intent == null) {
            intent = new Intent();
        }
        return shortcutInfoCompat.a(intent);
    }

    public static void disableShortcuts(@NonNull Context context, @NonNull List<String> list, @Nullable CharSequence charSequence) {
        if (Build.VERSION.SDK_INT >= 25) {
            ((ShortcutManager) context.getSystemService(ShortcutManager.class)).disableShortcuts(list, charSequence);
        }
        getShortcutInfoSaverInstance(context).removeShortcuts(list);
        for (ShortcutInfoChangeListener onShortcutRemoved : getShortcutInfoListeners(context)) {
            onShortcutRemoved.onShortcutRemoved(list);
        }
    }

    public static void enableShortcuts(@NonNull Context context, @NonNull List<ShortcutInfoCompat> list) {
        List<ShortcutInfoCompat> removeShortcutsExcludedFromSurface = removeShortcutsExcludedFromSurface(list, 1);
        if (Build.VERSION.SDK_INT >= 25) {
            ArrayList arrayList = new ArrayList(list.size());
            for (ShortcutInfoCompat shortcutInfoCompat : removeShortcutsExcludedFromSurface) {
                arrayList.add(shortcutInfoCompat.f11241b);
            }
            ((ShortcutManager) context.getSystemService(ShortcutManager.class)).enableShortcuts(arrayList);
        }
        getShortcutInfoSaverInstance(context).addShortcuts(removeShortcutsExcludedFromSurface);
        for (ShortcutInfoChangeListener onShortcutAdded : getShortcutInfoListeners(context)) {
            onShortcutAdded.onShortcutAdded(list);
        }
    }

    @NonNull
    public static List<ShortcutInfoCompat> getDynamicShortcuts(@NonNull Context context) {
        if (Build.VERSION.SDK_INT >= 25) {
            List<ShortcutInfo> a11 = ((ShortcutManager) context.getSystemService(ShortcutManager.class)).getDynamicShortcuts();
            ArrayList arrayList = new ArrayList(a11.size());
            for (ShortcutInfo builder : a11) {
                arrayList.add(new ShortcutInfoCompat.Builder(context, builder).build());
            }
            return arrayList;
        }
        try {
            return getShortcutInfoSaverInstance(context).getShortcuts();
        } catch (Exception unused) {
            return new ArrayList();
        }
    }

    private static int getIconDimensionInternal(@NonNull Context context, boolean z11) {
        boolean z12;
        int i11;
        float f11;
        ActivityManager activityManager = (ActivityManager) context.getSystemService("activity");
        if (activityManager == null || activityManager.isLowRamDevice()) {
            z12 = true;
        } else {
            z12 = false;
        }
        if (z12) {
            i11 = 48;
        } else {
            i11 = 96;
        }
        int max = Math.max(1, i11);
        DisplayMetrics displayMetrics = context.getResources().getDisplayMetrics();
        if (z11) {
            f11 = displayMetrics.xdpi;
        } else {
            f11 = displayMetrics.ydpi;
        }
        return (int) (((float) max) * (f11 / 160.0f));
    }

    public static int getIconMaxHeight(@NonNull Context context) {
        Preconditions.checkNotNull(context);
        if (Build.VERSION.SDK_INT >= 25) {
            return ((ShortcutManager) context.getSystemService(ShortcutManager.class)).getIconMaxHeight();
        }
        return getIconDimensionInternal(context, false);
    }

    public static int getIconMaxWidth(@NonNull Context context) {
        Preconditions.checkNotNull(context);
        if (Build.VERSION.SDK_INT >= 25) {
            return ((ShortcutManager) context.getSystemService(ShortcutManager.class)).getIconMaxWidth();
        }
        return getIconDimensionInternal(context, true);
    }

    public static int getMaxShortcutCountPerActivity(@NonNull Context context) {
        Preconditions.checkNotNull(context);
        if (Build.VERSION.SDK_INT >= 25) {
            return ((ShortcutManager) context.getSystemService(ShortcutManager.class)).getMaxShortcutCountPerActivity();
        }
        return 5;
    }

    private static String getShortcutInfoCompatWithLowestRank(@NonNull List<ShortcutInfoCompat> list) {
        int i11 = -1;
        String str = null;
        for (ShortcutInfoCompat next : list) {
            if (next.getRank() > i11) {
                String id2 = next.getId();
                str = id2;
                i11 = next.getRank();
            }
        }
        return str;
    }

    private static List<ShortcutInfoChangeListener> getShortcutInfoListeners(Context context) {
        Bundle bundle;
        String string;
        if (sShortcutInfoChangeListeners == null) {
            ArrayList arrayList = new ArrayList();
            PackageManager packageManager = context.getPackageManager();
            Intent intent = new Intent(SHORTCUT_LISTENER_INTENT_FILTER_ACTION);
            intent.setPackage(context.getPackageName());
            for (ResolveInfo resolveInfo : packageManager.queryIntentActivities(intent, 128)) {
                ActivityInfo activityInfo = resolveInfo.activityInfo;
                if (!(activityInfo == null || (bundle = activityInfo.metaData) == null || (string = bundle.getString(SHORTCUT_LISTENER_META_DATA_KEY)) == null)) {
                    try {
                        arrayList.add((ShortcutInfoChangeListener) Class.forName(string, false, ShortcutManagerCompat.class.getClassLoader()).getMethod("getInstance", new Class[]{Context.class}).invoke((Object) null, new Object[]{context}));
                    } catch (Exception unused) {
                    }
                }
            }
            if (sShortcutInfoChangeListeners == null) {
                sShortcutInfoChangeListeners = arrayList;
            }
        }
        return sShortcutInfoChangeListeners;
    }

    private static ShortcutInfoCompatSaver<?> getShortcutInfoSaverInstance(Context context) {
        if (sShortcutInfoCompatSaver == null) {
            try {
                sShortcutInfoCompatSaver = (ShortcutInfoCompatSaver) Class.forName("androidx.sharetarget.ShortcutInfoCompatSaverImpl", false, ShortcutManagerCompat.class.getClassLoader()).getMethod("getInstance", new Class[]{Context.class}).invoke((Object) null, new Object[]{context});
            } catch (Exception unused) {
            }
            if (sShortcutInfoCompatSaver == null) {
                sShortcutInfoCompatSaver = new ShortcutInfoCompatSaver.NoopImpl();
            }
        }
        return sShortcutInfoCompatSaver;
    }

    @NonNull
    public static List<ShortcutInfoCompat> getShortcuts(@NonNull Context context, int i11) {
        int i12 = Build.VERSION.SDK_INT;
        if (i12 >= 30) {
            return ShortcutInfoCompat.b(context, ((ShortcutManager) context.getSystemService(ShortcutManager.class)).getShortcuts(i11));
        }
        if (i12 >= 25) {
            ShortcutManager shortcutManager = (ShortcutManager) context.getSystemService(ShortcutManager.class);
            ArrayList arrayList = new ArrayList();
            if ((i11 & 1) != 0) {
                arrayList.addAll(shortcutManager.getManifestShortcuts());
            }
            if ((i11 & 2) != 0) {
                arrayList.addAll(shortcutManager.getDynamicShortcuts());
            }
            if ((i11 & 4) != 0) {
                arrayList.addAll(shortcutManager.getPinnedShortcuts());
            }
            return ShortcutInfoCompat.b(context, arrayList);
        }
        if ((i11 & 2) != 0) {
            try {
                return getShortcutInfoSaverInstance(context).getShortcuts();
            } catch (Exception unused) {
            }
        }
        return Collections.emptyList();
    }

    public static boolean isRateLimitingActive(@NonNull Context context) {
        Preconditions.checkNotNull(context);
        if (Build.VERSION.SDK_INT >= 25) {
            return ((ShortcutManager) context.getSystemService(ShortcutManager.class)).isRateLimitingActive();
        }
        if (getShortcuts(context, 3).size() == getMaxShortcutCountPerActivity(context)) {
            return true;
        }
        return false;
    }

    /* JADX WARNING: Removed duplicated region for block: B:10:0x0036  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static boolean isRequestPinShortcutSupported(@androidx.annotation.NonNull android.content.Context r4) {
        /*
            int r0 = android.os.Build.VERSION.SDK_INT
            r1 = 26
            if (r0 < r1) goto L_0x0013
            java.lang.Class<android.content.pm.ShortcutManager> r0 = android.content.pm.ShortcutManager.class
            java.lang.Object r4 = r4.getSystemService(r0)
            android.content.pm.ShortcutManager r4 = (android.content.pm.ShortcutManager) r4
            boolean r4 = r4.isRequestPinShortcutSupported()
            return r4
        L_0x0013:
            java.lang.String r0 = "com.android.launcher.permission.INSTALL_SHORTCUT"
            int r1 = androidx.core.content.ContextCompat.checkSelfPermission(r4, r0)
            r2 = 0
            if (r1 == 0) goto L_0x001d
            return r2
        L_0x001d:
            android.content.pm.PackageManager r4 = r4.getPackageManager()
            android.content.Intent r1 = new android.content.Intent
            java.lang.String r3 = "com.android.launcher.action.INSTALL_SHORTCUT"
            r1.<init>(r3)
            java.util.List r4 = r4.queryBroadcastReceivers(r1, r2)
            java.util.Iterator r4 = r4.iterator()
        L_0x0030:
            boolean r1 = r4.hasNext()
            if (r1 == 0) goto L_0x004e
            java.lang.Object r1 = r4.next()
            android.content.pm.ResolveInfo r1 = (android.content.pm.ResolveInfo) r1
            android.content.pm.ActivityInfo r1 = r1.activityInfo
            java.lang.String r1 = r1.permission
            boolean r3 = android.text.TextUtils.isEmpty(r1)
            if (r3 != 0) goto L_0x004c
            boolean r1 = r0.equals(r1)
            if (r1 == 0) goto L_0x0030
        L_0x004c:
            r4 = 1
            return r4
        L_0x004e:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.core.content.pm.ShortcutManagerCompat.isRequestPinShortcutSupported(android.content.Context):boolean");
    }

    /*  JADX ERROR: StackOverflow in pass: MarkFinallyVisitor
        jadx.core.utils.exceptions.JadxOverflowException: 
        	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:47)
        	at jadx.core.utils.ErrorsCounter.methodError(ErrorsCounter.java:81)
        */
    public static boolean pushDynamicShortcut(@androidx.annotation.NonNull android.content.Context r6, @androidx.annotation.NonNull androidx.core.content.pm.ShortcutInfoCompat r7) {
        /*
            androidx.core.util.Preconditions.checkNotNull(r6)
            androidx.core.util.Preconditions.checkNotNull(r7)
            int r0 = android.os.Build.VERSION.SDK_INT
            r1 = 31
            r2 = 1
            if (r0 > r1) goto L_0x0030
            boolean r1 = r7.isExcludedFromSurfaces(r2)
            if (r1 == 0) goto L_0x0030
            java.util.List r6 = getShortcutInfoListeners(r6)
            java.util.Iterator r6 = r6.iterator()
        L_0x001b:
            boolean r0 = r6.hasNext()
            if (r0 == 0) goto L_0x002f
            java.lang.Object r0 = r6.next()
            androidx.core.content.pm.ShortcutInfoChangeListener r0 = (androidx.core.content.pm.ShortcutInfoChangeListener) r0
            java.util.List r1 = java.util.Collections.singletonList(r7)
            r0.onShortcutAdded(r1)
            goto L_0x001b
        L_0x002f:
            return r2
        L_0x0030:
            int r1 = getMaxShortcutCountPerActivity(r6)
            r3 = 0
            if (r1 != 0) goto L_0x0038
            return r3
        L_0x0038:
            r4 = 29
            if (r0 > r4) goto L_0x003f
            a(r6, r7)
        L_0x003f:
            r4 = 30
            if (r0 < r4) goto L_0x0053
            java.lang.Class<android.content.pm.ShortcutManager> r0 = android.content.pm.ShortcutManager.class
            java.lang.Object r0 = r6.getSystemService(r0)
            android.content.pm.ShortcutManager r0 = (android.content.pm.ShortcutManager) r0
            android.content.pm.ShortcutInfo r4 = r7.toShortcutInfo()
            c1.z0.a(r0, r4)
            goto L_0x008e
        L_0x0053:
            r4 = 25
            if (r0 < r4) goto L_0x008e
            java.lang.Class<android.content.pm.ShortcutManager> r0 = android.content.pm.ShortcutManager.class
            java.lang.Object r0 = r6.getSystemService(r0)
            android.content.pm.ShortcutManager r0 = (android.content.pm.ShortcutManager) r0
            boolean r4 = r0.isRateLimitingActive()
            if (r4 == 0) goto L_0x0066
            return r3
        L_0x0066:
            java.util.List r4 = r0.getDynamicShortcuts()
            int r5 = r4.size()
            if (r5 < r1) goto L_0x007f
            java.lang.String[] r5 = new java.lang.String[r2]
            java.lang.String r4 = androidx.core.content.pm.ShortcutManagerCompat.Api25Impl.a(r4)
            r5[r3] = r4
            java.util.List r4 = java.util.Arrays.asList(r5)
            r0.removeDynamicShortcuts(r4)
        L_0x007f:
            android.content.pm.ShortcutInfo[] r4 = new android.content.pm.ShortcutInfo[r2]
            android.content.pm.ShortcutInfo r5 = r7.toShortcutInfo()
            r4[r3] = r5
            java.util.List r4 = java.util.Arrays.asList(r4)
            boolean unused = r0.addDynamicShortcuts(r4)
        L_0x008e:
            androidx.core.content.pm.ShortcutInfoCompatSaver r0 = getShortcutInfoSaverInstance(r6)
            java.util.List r4 = r0.getShortcuts()     // Catch:{ Exception -> 0x00ff, all -> 0x00da }
            int r5 = r4.size()     // Catch:{ Exception -> 0x00ff, all -> 0x00da }
            if (r5 < r1) goto L_0x00ab
            java.lang.String[] r1 = new java.lang.String[r2]     // Catch:{ Exception -> 0x00ff, all -> 0x00da }
            java.lang.String r4 = getShortcutInfoCompatWithLowestRank(r4)     // Catch:{ Exception -> 0x00ff, all -> 0x00da }
            r1[r3] = r4     // Catch:{ Exception -> 0x00ff, all -> 0x00da }
            java.util.List r1 = java.util.Arrays.asList(r1)     // Catch:{ Exception -> 0x00ff, all -> 0x00da }
            r0.removeShortcuts(r1)     // Catch:{ Exception -> 0x00ff, all -> 0x00da }
        L_0x00ab:
            androidx.core.content.pm.ShortcutInfoCompat[] r1 = new androidx.core.content.pm.ShortcutInfoCompat[r2]     // Catch:{ Exception -> 0x00ff, all -> 0x00da }
            r1[r3] = r7     // Catch:{ Exception -> 0x00ff, all -> 0x00da }
            java.util.List r1 = java.util.Arrays.asList(r1)     // Catch:{ Exception -> 0x00ff, all -> 0x00da }
            r0.addShortcuts(r1)     // Catch:{ Exception -> 0x00ff, all -> 0x00da }
            java.util.List r0 = getShortcutInfoListeners(r6)
            java.util.Iterator r0 = r0.iterator()
        L_0x00be:
            boolean r1 = r0.hasNext()
            if (r1 == 0) goto L_0x00d2
            java.lang.Object r1 = r0.next()
            androidx.core.content.pm.ShortcutInfoChangeListener r1 = (androidx.core.content.pm.ShortcutInfoChangeListener) r1
            java.util.List r3 = java.util.Collections.singletonList(r7)
            r1.onShortcutAdded(r3)
            goto L_0x00be
        L_0x00d2:
            java.lang.String r7 = r7.getId()
            reportShortcutUsed(r6, r7)
            return r2
        L_0x00da:
            r0 = move-exception
            java.util.List r1 = getShortcutInfoListeners(r6)
            java.util.Iterator r1 = r1.iterator()
        L_0x00e3:
            boolean r2 = r1.hasNext()
            if (r2 == 0) goto L_0x00f7
            java.lang.Object r2 = r1.next()
            androidx.core.content.pm.ShortcutInfoChangeListener r2 = (androidx.core.content.pm.ShortcutInfoChangeListener) r2
            java.util.List r3 = java.util.Collections.singletonList(r7)
            r2.onShortcutAdded(r3)
            goto L_0x00e3
        L_0x00f7:
            java.lang.String r7 = r7.getId()
            reportShortcutUsed(r6, r7)
            throw r0
        L_0x00ff:
            java.util.List r0 = getShortcutInfoListeners(r6)
            java.util.Iterator r0 = r0.iterator()
        L_0x0107:
            boolean r1 = r0.hasNext()
            if (r1 == 0) goto L_0x011b
            java.lang.Object r1 = r0.next()
            androidx.core.content.pm.ShortcutInfoChangeListener r1 = (androidx.core.content.pm.ShortcutInfoChangeListener) r1
            java.util.List r2 = java.util.Collections.singletonList(r7)
            r1.onShortcutAdded(r2)
            goto L_0x0107
        L_0x011b:
            java.lang.String r7 = r7.getId()
            reportShortcutUsed(r6, r7)
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.core.content.pm.ShortcutManagerCompat.pushDynamicShortcut(android.content.Context, androidx.core.content.pm.ShortcutInfoCompat):boolean");
    }

    public static void removeAllDynamicShortcuts(@NonNull Context context) {
        if (Build.VERSION.SDK_INT >= 25) {
            ((ShortcutManager) context.getSystemService(ShortcutManager.class)).removeAllDynamicShortcuts();
        }
        getShortcutInfoSaverInstance(context).removeAllShortcuts();
        for (ShortcutInfoChangeListener onAllShortcutsRemoved : getShortcutInfoListeners(context)) {
            onAllShortcutsRemoved.onAllShortcutsRemoved();
        }
    }

    public static void removeDynamicShortcuts(@NonNull Context context, @NonNull List<String> list) {
        if (Build.VERSION.SDK_INT >= 25) {
            ((ShortcutManager) context.getSystemService(ShortcutManager.class)).removeDynamicShortcuts(list);
        }
        getShortcutInfoSaverInstance(context).removeShortcuts(list);
        for (ShortcutInfoChangeListener onShortcutRemoved : getShortcutInfoListeners(context)) {
            onShortcutRemoved.onShortcutRemoved(list);
        }
    }

    public static void removeLongLivedShortcuts(@NonNull Context context, @NonNull List<String> list) {
        if (Build.VERSION.SDK_INT < 30) {
            removeDynamicShortcuts(context, list);
            return;
        }
        ((ShortcutManager) context.getSystemService(ShortcutManager.class)).removeLongLivedShortcuts(list);
        getShortcutInfoSaverInstance(context).removeShortcuts(list);
        for (ShortcutInfoChangeListener onShortcutRemoved : getShortcutInfoListeners(context)) {
            onShortcutRemoved.onShortcutRemoved(list);
        }
    }

    @NonNull
    private static List<ShortcutInfoCompat> removeShortcutsExcludedFromSurface(@NonNull List<ShortcutInfoCompat> list, int i11) {
        Objects.requireNonNull(list);
        if (Build.VERSION.SDK_INT > 31) {
            return list;
        }
        ArrayList arrayList = new ArrayList(list);
        for (ShortcutInfoCompat next : list) {
            if (next.isExcludedFromSurfaces(i11)) {
                arrayList.remove(next);
            }
        }
        return arrayList;
    }

    public static void reportShortcutUsed(@NonNull Context context, @NonNull String str) {
        Preconditions.checkNotNull(context);
        Preconditions.checkNotNull(str);
        if (Build.VERSION.SDK_INT >= 25) {
            ((ShortcutManager) context.getSystemService(ShortcutManager.class)).reportShortcutUsed(str);
        }
        for (ShortcutInfoChangeListener onShortcutUsageReported : getShortcutInfoListeners(context)) {
            onShortcutUsageReported.onShortcutUsageReported(Collections.singletonList(str));
        }
    }

    public static boolean requestPinShortcut(@NonNull Context context, @NonNull ShortcutInfoCompat shortcutInfoCompat, @Nullable final IntentSender intentSender) {
        int i11 = Build.VERSION.SDK_INT;
        if (i11 <= 31 && shortcutInfoCompat.isExcludedFromSurfaces(1)) {
            return false;
        }
        if (i11 >= 26) {
            return ((ShortcutManager) context.getSystemService(ShortcutManager.class)).requestPinShortcut(shortcutInfoCompat.toShortcutInfo(), intentSender);
        }
        if (!isRequestPinShortcutSupported(context)) {
            return false;
        }
        Intent a11 = shortcutInfoCompat.a(new Intent("com.android.launcher.action.INSTALL_SHORTCUT"));
        if (intentSender == null) {
            context.sendBroadcast(a11);
            return true;
        }
        context.sendOrderedBroadcast(a11, (String) null, new BroadcastReceiver() {
            public void onReceive(Context context, Intent intent) {
                try {
                    intentSender.sendIntent(context, 0, (Intent) null, (IntentSender.OnFinished) null, (Handler) null);
                } catch (IntentSender.SendIntentException unused) {
                }
            }
        }, (Handler) null, -1, (String) null, (Bundle) null);
        return true;
    }

    public static boolean setDynamicShortcuts(@NonNull Context context, @NonNull List<ShortcutInfoCompat> list) {
        Preconditions.checkNotNull(context);
        Preconditions.checkNotNull(list);
        List<ShortcutInfoCompat> removeShortcutsExcludedFromSurface = removeShortcutsExcludedFromSurface(list, 1);
        if (Build.VERSION.SDK_INT >= 25) {
            ArrayList arrayList = new ArrayList(removeShortcutsExcludedFromSurface.size());
            for (ShortcutInfoCompat shortcutInfo : removeShortcutsExcludedFromSurface) {
                arrayList.add(shortcutInfo.toShortcutInfo());
            }
            if (!((ShortcutManager) context.getSystemService(ShortcutManager.class)).setDynamicShortcuts(arrayList)) {
                return false;
            }
        }
        getShortcutInfoSaverInstance(context).removeAllShortcuts();
        getShortcutInfoSaverInstance(context).addShortcuts(removeShortcutsExcludedFromSurface);
        for (ShortcutInfoChangeListener next : getShortcutInfoListeners(context)) {
            next.onAllShortcutsRemoved();
            next.onShortcutAdded(list);
        }
        return true;
    }

    public static boolean updateShortcuts(@NonNull Context context, @NonNull List<ShortcutInfoCompat> list) {
        List<ShortcutInfoCompat> removeShortcutsExcludedFromSurface = removeShortcutsExcludedFromSurface(list, 1);
        int i11 = Build.VERSION.SDK_INT;
        if (i11 <= 29) {
            b(context, removeShortcutsExcludedFromSurface);
        }
        if (i11 >= 25) {
            ArrayList arrayList = new ArrayList();
            for (ShortcutInfoCompat shortcutInfo : removeShortcutsExcludedFromSurface) {
                arrayList.add(shortcutInfo.toShortcutInfo());
            }
            if (!((ShortcutManager) context.getSystemService(ShortcutManager.class)).updateShortcuts(arrayList)) {
                return false;
            }
        }
        getShortcutInfoSaverInstance(context).addShortcuts(removeShortcutsExcludedFromSurface);
        for (ShortcutInfoChangeListener onShortcutUpdated : getShortcutInfoListeners(context)) {
            onShortcutUpdated.onShortcutUpdated(list);
        }
        return true;
    }
}
