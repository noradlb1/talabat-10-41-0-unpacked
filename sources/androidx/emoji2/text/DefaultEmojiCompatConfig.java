package androidx.emoji2.text;

import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.ProviderInfo;
import android.content.pm.ResolveInfo;
import android.content.pm.Signature;
import android.os.Build;
import android.util.Log;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.annotation.RestrictTo;
import androidx.annotation.VisibleForTesting;
import androidx.core.provider.FontRequest;
import androidx.core.util.Preconditions;
import androidx.emoji2.text.EmojiCompat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public final class DefaultEmojiCompatConfig {

    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public static class DefaultEmojiCompatConfigFactory {
        @NonNull
        private static final String DEFAULT_EMOJI_QUERY = "emojicompat-emoji-font";
        @NonNull
        private static final String INTENT_LOAD_EMOJI_FONT = "androidx.content.action.LOAD_EMOJI_FONT";
        @NonNull
        private static final String TAG = "emoji2.text.DefaultEmojiConfig";
        private final DefaultEmojiCompatConfigHelper mHelper;

        @RestrictTo({RestrictTo.Scope.LIBRARY})
        public DefaultEmojiCompatConfigFactory(@Nullable DefaultEmojiCompatConfigHelper defaultEmojiCompatConfigHelper) {
            this.mHelper = defaultEmojiCompatConfigHelper == null ? getHelperForApi() : defaultEmojiCompatConfigHelper;
        }

        @Nullable
        private EmojiCompat.Config configOrNull(@NonNull Context context, @Nullable FontRequest fontRequest) {
            if (fontRequest == null) {
                return null;
            }
            return new FontRequestEmojiCompatConfig(context, fontRequest);
        }

        @NonNull
        private List<List<byte[]>> convertToByteArray(@NonNull Signature[] signatureArr) {
            ArrayList arrayList = new ArrayList();
            for (Signature byteArray : signatureArr) {
                arrayList.add(byteArray.toByteArray());
            }
            return Collections.singletonList(arrayList);
        }

        @NonNull
        private FontRequest generateFontRequestFrom(@NonNull ProviderInfo providerInfo, @NonNull PackageManager packageManager) throws PackageManager.NameNotFoundException {
            String str = providerInfo.authority;
            String str2 = providerInfo.packageName;
            return new FontRequest(str, str2, DEFAULT_EMOJI_QUERY, convertToByteArray(this.mHelper.getSigningSignatures(packageManager, str2)));
        }

        @NonNull
        private static DefaultEmojiCompatConfigHelper getHelperForApi() {
            if (Build.VERSION.SDK_INT >= 28) {
                return new DefaultEmojiCompatConfigHelper_API28();
            }
            return new DefaultEmojiCompatConfigHelper_API19();
        }

        /* JADX WARNING: Code restructure failed: missing block: B:1:0x0002, code lost:
            r2 = r2.applicationInfo;
         */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        private boolean hasFlagSystem(@androidx.annotation.Nullable android.content.pm.ProviderInfo r2) {
            /*
                r1 = this;
                if (r2 == 0) goto L_0x000d
                android.content.pm.ApplicationInfo r2 = r2.applicationInfo
                if (r2 == 0) goto L_0x000d
                int r2 = r2.flags
                r0 = 1
                r2 = r2 & r0
                if (r2 != r0) goto L_0x000d
                goto L_0x000e
            L_0x000d:
                r0 = 0
            L_0x000e:
                return r0
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.emoji2.text.DefaultEmojiCompatConfig.DefaultEmojiCompatConfigFactory.hasFlagSystem(android.content.pm.ProviderInfo):boolean");
        }

        @Nullable
        private ProviderInfo queryDefaultInstalledContentProvider(@NonNull PackageManager packageManager) {
            for (ResolveInfo providerInfo : this.mHelper.queryIntentContentProviders(packageManager, new Intent(INTENT_LOAD_EMOJI_FONT), 0)) {
                ProviderInfo providerInfo2 = this.mHelper.getProviderInfo(providerInfo);
                if (hasFlagSystem(providerInfo2)) {
                    return providerInfo2;
                }
            }
            return null;
        }

        @VisibleForTesting
        @Nullable
        @RestrictTo({RestrictTo.Scope.LIBRARY})
        public FontRequest a(@NonNull Context context) {
            PackageManager packageManager = context.getPackageManager();
            Preconditions.checkNotNull(packageManager, "Package manager required to locate emoji font provider");
            ProviderInfo queryDefaultInstalledContentProvider = queryDefaultInstalledContentProvider(packageManager);
            if (queryDefaultInstalledContentProvider == null) {
                return null;
            }
            try {
                return generateFontRequestFrom(queryDefaultInstalledContentProvider, packageManager);
            } catch (PackageManager.NameNotFoundException e11) {
                Log.wtf(TAG, e11);
                return null;
            }
        }

        @Nullable
        @RestrictTo({RestrictTo.Scope.LIBRARY})
        public EmojiCompat.Config create(@NonNull Context context) {
            return configOrNull(context, a(context));
        }
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public static class DefaultEmojiCompatConfigHelper {
        @Nullable
        public ProviderInfo getProviderInfo(@NonNull ResolveInfo resolveInfo) {
            throw new IllegalStateException("Unable to get provider info prior to API 19");
        }

        @NonNull
        public Signature[] getSigningSignatures(@NonNull PackageManager packageManager, @NonNull String str) throws PackageManager.NameNotFoundException {
            return packageManager.getPackageInfo(str, 64).signatures;
        }

        @NonNull
        public List<ResolveInfo> queryIntentContentProviders(@NonNull PackageManager packageManager, @NonNull Intent intent, int i11) {
            return Collections.emptyList();
        }
    }

    @RequiresApi(19)
    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public static class DefaultEmojiCompatConfigHelper_API19 extends DefaultEmojiCompatConfigHelper {
        @Nullable
        public ProviderInfo getProviderInfo(@NonNull ResolveInfo resolveInfo) {
            return resolveInfo.providerInfo;
        }

        @NonNull
        public List<ResolveInfo> queryIntentContentProviders(@NonNull PackageManager packageManager, @NonNull Intent intent, int i11) {
            return packageManager.queryIntentContentProviders(intent, i11);
        }
    }

    @RequiresApi(28)
    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public static class DefaultEmojiCompatConfigHelper_API28 extends DefaultEmojiCompatConfigHelper_API19 {
        @NonNull
        public Signature[] getSigningSignatures(@NonNull PackageManager packageManager, @NonNull String str) throws PackageManager.NameNotFoundException {
            return packageManager.getPackageInfo(str, 64).signatures;
        }
    }

    private DefaultEmojiCompatConfig() {
    }

    @Nullable
    public static FontRequestEmojiCompatConfig create(@NonNull Context context) {
        return (FontRequestEmojiCompatConfig) new DefaultEmojiCompatConfigFactory((DefaultEmojiCompatConfigHelper) null).create(context);
    }
}
