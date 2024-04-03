package androidx.emoji2.text;

import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.text.Editable;
import android.view.KeyEvent;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputConnection;
import androidx.annotation.AnyThread;
import androidx.annotation.CheckResult;
import androidx.annotation.ColorInt;
import androidx.annotation.GuardedBy;
import androidx.annotation.IntRange;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.annotation.RestrictTo;
import androidx.collection.ArraySet;
import androidx.core.util.Preconditions;
import androidx.emoji2.text.DefaultEmojiCompatConfig;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.Set;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

@AnyThread
public class EmojiCompat {
    private static final Object CONFIG_LOCK = new Object();
    public static final String EDITOR_INFO_METAVERSION_KEY = "android.support.text.emoji.emojiCompat_metadataVersion";
    public static final String EDITOR_INFO_REPLACE_ALL_KEY = "android.support.text.emoji.emojiCompat_replaceAll";
    public static final int EMOJI_FALLBACK = 2;
    public static final int EMOJI_SUPPORTED = 1;
    public static final int EMOJI_UNSUPPORTED = 0;
    private static final Object INSTANCE_LOCK = new Object();
    public static final int LOAD_STATE_DEFAULT = 3;
    public static final int LOAD_STATE_FAILED = 2;
    public static final int LOAD_STATE_LOADING = 0;
    public static final int LOAD_STATE_SUCCEEDED = 1;
    public static final int LOAD_STRATEGY_DEFAULT = 0;
    public static final int LOAD_STRATEGY_MANUAL = 1;
    private static final String NOT_INITIALIZED_ERROR_TEXT = "EmojiCompat is not initialized.\n\nYou must initialize EmojiCompat prior to referencing the EmojiCompat instance.\n\nThe most likely cause of this error is disabling the EmojiCompatInitializer\neither explicitly in AndroidManifest.xml, or by including\nandroidx.emoji2:emoji2-bundled.\n\nAutomatic initialization is typically performed by EmojiCompatInitializer. If\nyou are not expecting to initialize EmojiCompat manually in your application,\nplease check to ensure it has not been removed from your APK's manifest. You can\ndo this in Android Studio using Build > Analyze APK.\n\nIn the APK Analyzer, ensure that the startup entry for\nEmojiCompatInitializer and InitializationProvider is present in\n AndroidManifest.xml. If it is missing or contains tools:node=\"remove\", and you\nintend to use automatic configuration, verify:\n\n  1. Your application does not include emoji2-bundled\n  2. All modules do not contain an exclusion manifest rule for\n     EmojiCompatInitializer or InitializationProvider. For more information\n     about manifest exclusions see the documentation for the androidx startup\n     library.\n\nIf you intend to use emoji2-bundled, please call EmojiCompat.init. You can\nlearn more in the documentation for BundledEmojiCompatConfig.\n\nIf you intended to perform manual configuration, it is recommended that you call\nEmojiCompat.init immediately on application startup.\n\nIf you still cannot resolve this issue, please open a bug with your specific\nconfiguration to help improve error message.";
    public static final int REPLACE_STRATEGY_ALL = 1;
    public static final int REPLACE_STRATEGY_DEFAULT = 0;
    public static final int REPLACE_STRATEGY_NON_EXISTENT = 2;
    @GuardedBy("CONFIG_LOCK")
    private static volatile boolean sHasDoneDefaultConfigLookup;
    @GuardedBy("INSTANCE_LOCK")
    @Nullable
    private static volatile EmojiCompat sInstance;
    @NonNull

    /* renamed from: a  reason: collision with root package name */
    public final MetadataRepoLoader f35886a;

    /* renamed from: b  reason: collision with root package name */
    public final boolean f35887b;

    /* renamed from: c  reason: collision with root package name */
    public final boolean f35888c;
    @Nullable

    /* renamed from: d  reason: collision with root package name */
    public final int[] f35889d;
    private final int mEmojiSpanIndicatorColor;
    private final boolean mEmojiSpanIndicatorEnabled;
    /* access modifiers changed from: private */
    public final GlyphChecker mGlyphChecker;
    @NonNull
    private final CompatInternal mHelper;
    @GuardedBy("mInitLock")
    @NonNull
    private final Set<InitCallback> mInitCallbacks;
    @NonNull
    private final ReadWriteLock mInitLock = new ReentrantReadWriteLock();
    @GuardedBy("mInitLock")
    private volatile int mLoadState = 3;
    @NonNull
    private final Handler mMainHandler;
    private final int mMetadataLoadStrategy;

    @RestrictTo({RestrictTo.Scope.LIBRARY})
    @Retention(RetentionPolicy.SOURCE)
    public @interface CodepointSequenceMatchResult {
    }

    public static class CompatInternal {

        /* renamed from: a  reason: collision with root package name */
        public final EmojiCompat f35890a;

        public CompatInternal(EmojiCompat emojiCompat) {
            this.f35890a = emojiCompat;
        }

        public String a() {
            return "";
        }

        public boolean b(@NonNull CharSequence charSequence) {
            return false;
        }

        public boolean c(@NonNull CharSequence charSequence, int i11) {
            return false;
        }

        public void d() {
            this.f35890a.c();
        }

        public CharSequence e(@NonNull CharSequence charSequence, @IntRange(from = 0) int i11, @IntRange(from = 0) int i12, @IntRange(from = 0) int i13, boolean z11) {
            return charSequence;
        }

        public void f(@NonNull EditorInfo editorInfo) {
        }

        public int getEmojiMatch(CharSequence charSequence, int i11) {
            return 0;
        }
    }

    @RequiresApi(19)
    public static final class CompatInternal19 extends CompatInternal {
        private volatile MetadataRepo mMetadataRepo;
        private volatile EmojiProcessor mProcessor;

        public CompatInternal19(EmojiCompat emojiCompat) {
            super(emojiCompat);
        }

        public String a() {
            String sourceSha = this.mMetadataRepo.getMetadataList().sourceSha();
            return sourceSha == null ? "" : sourceSha;
        }

        public boolean b(@NonNull CharSequence charSequence) {
            return this.mProcessor.a(charSequence) == 1;
        }

        public boolean c(@NonNull CharSequence charSequence, int i11) {
            return this.mProcessor.b(charSequence, i11) == 1;
        }

        public void d() {
            try {
                this.f35890a.f35886a.load(new MetadataRepoLoaderCallback() {
                    public void onFailed(@Nullable Throwable th2) {
                        CompatInternal19.this.f35890a.b(th2);
                    }

                    public void onLoaded(@NonNull MetadataRepo metadataRepo) {
                        CompatInternal19.this.g(metadataRepo);
                    }
                });
            } catch (Throwable th2) {
                this.f35890a.b(th2);
            }
        }

        public CharSequence e(@NonNull CharSequence charSequence, int i11, int i12, int i13, boolean z11) {
            return this.mProcessor.e(charSequence, i11, i12, i13, z11);
        }

        public void f(@NonNull EditorInfo editorInfo) {
            editorInfo.extras.putInt(EmojiCompat.EDITOR_INFO_METAVERSION_KEY, this.mMetadataRepo.a());
            editorInfo.extras.putBoolean(EmojiCompat.EDITOR_INFO_REPLACE_ALL_KEY, this.f35890a.f35887b);
        }

        public void g(@NonNull MetadataRepo metadataRepo) {
            if (metadataRepo == null) {
                this.f35890a.b(new IllegalArgumentException("metadataRepo cannot be null"));
                return;
            }
            this.mMetadataRepo = metadataRepo;
            MetadataRepo metadataRepo2 = this.mMetadataRepo;
            SpanFactory spanFactory = new SpanFactory();
            GlyphChecker a11 = this.f35890a.mGlyphChecker;
            EmojiCompat emojiCompat = this.f35890a;
            this.mProcessor = new EmojiProcessor(metadataRepo2, spanFactory, a11, emojiCompat.f35888c, emojiCompat.f35889d);
            this.f35890a.c();
        }

        public int getEmojiMatch(CharSequence charSequence, int i11) {
            return this.mProcessor.b(charSequence, i11);
        }
    }

    public static abstract class Config {
        @NonNull

        /* renamed from: a  reason: collision with root package name */
        public final MetadataRepoLoader f35892a;

        /* renamed from: b  reason: collision with root package name */
        public boolean f35893b;

        /* renamed from: c  reason: collision with root package name */
        public boolean f35894c;
        @Nullable

        /* renamed from: d  reason: collision with root package name */
        public int[] f35895d;
        @Nullable

        /* renamed from: e  reason: collision with root package name */
        public Set<InitCallback> f35896e;

        /* renamed from: f  reason: collision with root package name */
        public boolean f35897f;

        /* renamed from: g  reason: collision with root package name */
        public int f35898g = -16711936;

        /* renamed from: h  reason: collision with root package name */
        public int f35899h = 0;
        @NonNull

        /* renamed from: i  reason: collision with root package name */
        public GlyphChecker f35900i = new DefaultGlyphChecker();

        public Config(@NonNull MetadataRepoLoader metadataRepoLoader) {
            Preconditions.checkNotNull(metadataRepoLoader, "metadataLoader cannot be null.");
            this.f35892a = metadataRepoLoader;
        }

        @NonNull
        public final MetadataRepoLoader a() {
            return this.f35892a;
        }

        @NonNull
        public Config registerInitCallback(@NonNull InitCallback initCallback) {
            Preconditions.checkNotNull(initCallback, "initCallback cannot be null");
            if (this.f35896e == null) {
                this.f35896e = new ArraySet();
            }
            this.f35896e.add(initCallback);
            return this;
        }

        @NonNull
        public Config setEmojiSpanIndicatorColor(@ColorInt int i11) {
            this.f35898g = i11;
            return this;
        }

        @NonNull
        public Config setEmojiSpanIndicatorEnabled(boolean z11) {
            this.f35897f = z11;
            return this;
        }

        @NonNull
        public Config setGlyphChecker(@NonNull GlyphChecker glyphChecker) {
            Preconditions.checkNotNull(glyphChecker, "GlyphChecker cannot be null");
            this.f35900i = glyphChecker;
            return this;
        }

        @NonNull
        public Config setMetadataLoadStrategy(int i11) {
            this.f35899h = i11;
            return this;
        }

        @NonNull
        public Config setReplaceAll(boolean z11) {
            this.f35893b = z11;
            return this;
        }

        @NonNull
        public Config setUseEmojiAsDefaultStyle(boolean z11) {
            return setUseEmojiAsDefaultStyle(z11, (List<Integer>) null);
        }

        @NonNull
        public Config unregisterInitCallback(@NonNull InitCallback initCallback) {
            Preconditions.checkNotNull(initCallback, "initCallback cannot be null");
            Set<InitCallback> set = this.f35896e;
            if (set != null) {
                set.remove(initCallback);
            }
            return this;
        }

        @NonNull
        public Config setUseEmojiAsDefaultStyle(boolean z11, @Nullable List<Integer> list) {
            this.f35894c = z11;
            if (!z11 || list == null) {
                this.f35895d = null;
            } else {
                this.f35895d = new int[list.size()];
                int i11 = 0;
                for (Integer intValue : list) {
                    this.f35895d[i11] = intValue.intValue();
                    i11++;
                }
                Arrays.sort(this.f35895d);
            }
            return this;
        }
    }

    public interface GlyphChecker {
        boolean hasGlyph(@NonNull CharSequence charSequence, @IntRange(from = 0) int i11, @IntRange(from = 0) int i12, @IntRange(from = 0) int i13);
    }

    public static abstract class InitCallback {
        public void onFailed(@Nullable Throwable th2) {
        }

        public void onInitialized() {
        }
    }

    public static class ListenerDispatcher implements Runnable {
        private final List<InitCallback> mInitCallbacks;
        private final int mLoadState;
        private final Throwable mThrowable;

        public ListenerDispatcher(@NonNull InitCallback initCallback, int i11) {
            this(Arrays.asList(new InitCallback[]{(InitCallback) Preconditions.checkNotNull(initCallback, "initCallback cannot be null")}), i11, (Throwable) null);
        }

        public void run() {
            int size = this.mInitCallbacks.size();
            int i11 = 0;
            if (this.mLoadState != 1) {
                while (i11 < size) {
                    this.mInitCallbacks.get(i11).onFailed(this.mThrowable);
                    i11++;
                }
                return;
            }
            while (i11 < size) {
                this.mInitCallbacks.get(i11).onInitialized();
                i11++;
            }
        }

        public ListenerDispatcher(@NonNull Collection<InitCallback> collection, int i11) {
            this(collection, i11, (Throwable) null);
        }

        public ListenerDispatcher(@NonNull Collection<InitCallback> collection, int i11, @Nullable Throwable th2) {
            Preconditions.checkNotNull(collection, "initCallbacks cannot be null");
            this.mInitCallbacks = new ArrayList(collection);
            this.mLoadState = i11;
            this.mThrowable = th2;
        }
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY})
    @Retention(RetentionPolicy.SOURCE)
    public @interface LoadStrategy {
    }

    public interface MetadataRepoLoader {
        void load(@NonNull MetadataRepoLoaderCallback metadataRepoLoaderCallback);
    }

    public static abstract class MetadataRepoLoaderCallback {
        public abstract void onFailed(@Nullable Throwable th2);

        public abstract void onLoaded(@NonNull MetadataRepo metadataRepo);
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY})
    @Retention(RetentionPolicy.SOURCE)
    public @interface ReplaceStrategy {
    }

    @RequiresApi(19)
    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public static class SpanFactory {
        public EmojiSpan a(@NonNull EmojiMetadata emojiMetadata) {
            return new TypefaceEmojiSpan(emojiMetadata);
        }
    }

    private EmojiCompat(@NonNull Config config) {
        this.f35887b = config.f35893b;
        this.f35888c = config.f35894c;
        this.f35889d = config.f35895d;
        this.mEmojiSpanIndicatorEnabled = config.f35897f;
        this.mEmojiSpanIndicatorColor = config.f35898g;
        this.f35886a = config.f35892a;
        this.mMetadataLoadStrategy = config.f35899h;
        this.mGlyphChecker = config.f35900i;
        this.mMainHandler = new Handler(Looper.getMainLooper());
        ArraySet arraySet = new ArraySet();
        this.mInitCallbacks = arraySet;
        Set<InitCallback> set = config.f35896e;
        if (set != null && !set.isEmpty()) {
            arraySet.addAll(config.f35896e);
        }
        this.mHelper = new CompatInternal19(this);
        loadMetadata();
    }

    @NonNull
    public static EmojiCompat get() {
        EmojiCompat emojiCompat;
        boolean z11;
        synchronized (INSTANCE_LOCK) {
            emojiCompat = sInstance;
            if (emojiCompat != null) {
                z11 = true;
            } else {
                z11 = false;
            }
            Preconditions.checkState(z11, NOT_INITIALIZED_ERROR_TEXT);
        }
        return emojiCompat;
    }

    public static boolean handleDeleteSurroundingText(@NonNull InputConnection inputConnection, @NonNull Editable editable, @IntRange(from = 0) int i11, @IntRange(from = 0) int i12, boolean z11) {
        return EmojiProcessor.c(inputConnection, editable, i11, i12, z11);
    }

    public static boolean handleOnKeyDown(@NonNull Editable editable, int i11, @NonNull KeyEvent keyEvent) {
        return EmojiProcessor.d(editable, i11, keyEvent);
    }

    @Nullable
    public static EmojiCompat init(@NonNull Context context) {
        return init(context, (DefaultEmojiCompatConfig.DefaultEmojiCompatConfigFactory) null);
    }

    public static boolean isConfigured() {
        return sInstance != null;
    }

    private boolean isInitialized() {
        return getLoadState() == 1;
    }

    /* JADX INFO: finally extract failed */
    private void loadMetadata() {
        this.mInitLock.writeLock().lock();
        try {
            if (this.mMetadataLoadStrategy == 0) {
                this.mLoadState = 0;
            }
            this.mInitLock.writeLock().unlock();
            if (getLoadState() == 0) {
                this.mHelper.d();
            }
        } catch (Throwable th2) {
            this.mInitLock.writeLock().unlock();
            throw th2;
        }
    }

    @NonNull
    public static EmojiCompat reset(@NonNull Config config) {
        EmojiCompat emojiCompat;
        synchronized (INSTANCE_LOCK) {
            emojiCompat = new EmojiCompat(config);
            sInstance = emojiCompat;
        }
        return emojiCompat;
    }

    @RestrictTo({RestrictTo.Scope.TESTS})
    public static void skipDefaultConfigurationLookup(boolean z11) {
        synchronized (CONFIG_LOCK) {
            sHasDoneDefaultConfigLookup = z11;
        }
    }

    /* JADX INFO: finally extract failed */
    public void b(@Nullable Throwable th2) {
        ArrayList arrayList = new ArrayList();
        this.mInitLock.writeLock().lock();
        try {
            this.mLoadState = 2;
            arrayList.addAll(this.mInitCallbacks);
            this.mInitCallbacks.clear();
            this.mInitLock.writeLock().unlock();
            this.mMainHandler.post(new ListenerDispatcher(arrayList, this.mLoadState, th2));
        } catch (Throwable th3) {
            this.mInitLock.writeLock().unlock();
            throw th3;
        }
    }

    /* JADX INFO: finally extract failed */
    public void c() {
        ArrayList arrayList = new ArrayList();
        this.mInitLock.writeLock().lock();
        try {
            this.mLoadState = 1;
            arrayList.addAll(this.mInitCallbacks);
            this.mInitCallbacks.clear();
            this.mInitLock.writeLock().unlock();
            this.mMainHandler.post(new ListenerDispatcher((Collection<InitCallback>) arrayList, this.mLoadState));
        } catch (Throwable th2) {
            this.mInitLock.writeLock().unlock();
            throw th2;
        }
    }

    @NonNull
    public String getAssetSignature() {
        Preconditions.checkState(isInitialized(), "Not initialized yet");
        return this.mHelper.a();
    }

    public int getEmojiMatch(@NonNull CharSequence charSequence, @IntRange(from = 0) int i11) {
        Preconditions.checkState(isInitialized(), "Not initialized yet");
        Preconditions.checkNotNull(charSequence, "sequence cannot be null");
        return this.mHelper.getEmojiMatch(charSequence, i11);
    }

    @ColorInt
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public int getEmojiSpanIndicatorColor() {
        return this.mEmojiSpanIndicatorColor;
    }

    public int getLoadState() {
        this.mInitLock.readLock().lock();
        try {
            return this.mLoadState;
        } finally {
            this.mInitLock.readLock().unlock();
        }
    }

    @Deprecated
    public boolean hasEmojiGlyph(@NonNull CharSequence charSequence) {
        Preconditions.checkState(isInitialized(), "Not initialized yet");
        Preconditions.checkNotNull(charSequence, "sequence cannot be null");
        return this.mHelper.b(charSequence);
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public boolean isEmojiSpanIndicatorEnabled() {
        return this.mEmojiSpanIndicatorEnabled;
    }

    public void load() {
        boolean z11 = true;
        if (this.mMetadataLoadStrategy != 1) {
            z11 = false;
        }
        Preconditions.checkState(z11, "Set metadataLoadStrategy to LOAD_STRATEGY_MANUAL to execute manual loading");
        if (!isInitialized()) {
            this.mInitLock.writeLock().lock();
            try {
                if (this.mLoadState != 0) {
                    this.mLoadState = 0;
                    this.mInitLock.writeLock().unlock();
                    this.mHelper.d();
                }
            } finally {
                this.mInitLock.writeLock().unlock();
            }
        }
    }

    @CheckResult
    @Nullable
    public CharSequence process(@Nullable CharSequence charSequence) {
        return process(charSequence, 0, charSequence == null ? 0 : charSequence.length());
    }

    public void registerInitCallback(@NonNull InitCallback initCallback) {
        Preconditions.checkNotNull(initCallback, "initCallback cannot be null");
        this.mInitLock.writeLock().lock();
        try {
            if (this.mLoadState != 1) {
                if (this.mLoadState != 2) {
                    this.mInitCallbacks.add(initCallback);
                }
            }
            this.mMainHandler.post(new ListenerDispatcher(initCallback, this.mLoadState));
        } finally {
            this.mInitLock.writeLock().unlock();
        }
    }

    public void unregisterInitCallback(@NonNull InitCallback initCallback) {
        Preconditions.checkNotNull(initCallback, "initCallback cannot be null");
        this.mInitLock.writeLock().lock();
        try {
            this.mInitCallbacks.remove(initCallback);
        } finally {
            this.mInitLock.writeLock().unlock();
        }
    }

    public void updateEditorInfo(@NonNull EditorInfo editorInfo) {
        if (isInitialized() && editorInfo != null) {
            if (editorInfo.extras == null) {
                editorInfo.extras = new Bundle();
            }
            this.mHelper.f(editorInfo);
        }
    }

    @Nullable
    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public static EmojiCompat init(@NonNull Context context, @Nullable DefaultEmojiCompatConfig.DefaultEmojiCompatConfigFactory defaultEmojiCompatConfigFactory) {
        EmojiCompat emojiCompat;
        if (sHasDoneDefaultConfigLookup) {
            return sInstance;
        }
        if (defaultEmojiCompatConfigFactory == null) {
            defaultEmojiCompatConfigFactory = new DefaultEmojiCompatConfig.DefaultEmojiCompatConfigFactory((DefaultEmojiCompatConfig.DefaultEmojiCompatConfigHelper) null);
        }
        Config create = defaultEmojiCompatConfigFactory.create(context);
        synchronized (CONFIG_LOCK) {
            if (!sHasDoneDefaultConfigLookup) {
                if (create != null) {
                    init(create);
                }
                sHasDoneDefaultConfigLookup = true;
            }
            emojiCompat = sInstance;
        }
        return emojiCompat;
    }

    @CheckResult
    @Nullable
    public CharSequence process(@Nullable CharSequence charSequence, @IntRange(from = 0) int i11, @IntRange(from = 0) int i12) {
        return process(charSequence, i11, i12, Integer.MAX_VALUE);
    }

    @Deprecated
    public boolean hasEmojiGlyph(@NonNull CharSequence charSequence, @IntRange(from = 0) int i11) {
        Preconditions.checkState(isInitialized(), "Not initialized yet");
        Preconditions.checkNotNull(charSequence, "sequence cannot be null");
        return this.mHelper.c(charSequence, i11);
    }

    @CheckResult
    @Nullable
    public CharSequence process(@Nullable CharSequence charSequence, @IntRange(from = 0) int i11, @IntRange(from = 0) int i12, @IntRange(from = 0) int i13) {
        return process(charSequence, i11, i12, i13, 0);
    }

    @CheckResult
    @Nullable
    public CharSequence process(@Nullable CharSequence charSequence, @IntRange(from = 0) int i11, @IntRange(from = 0) int i12, @IntRange(from = 0) int i13, int i14) {
        boolean z11;
        Preconditions.checkState(isInitialized(), "Not initialized yet");
        Preconditions.checkArgumentNonnegative(i11, "start cannot be negative");
        Preconditions.checkArgumentNonnegative(i12, "end cannot be negative");
        Preconditions.checkArgumentNonnegative(i13, "maxEmojiCount cannot be negative");
        boolean z12 = false;
        Preconditions.checkArgument(i11 <= i12, "start should be <= than end");
        if (charSequence == null) {
            return null;
        }
        Preconditions.checkArgument(i11 <= charSequence.length(), "start should be < than charSequence length");
        Preconditions.checkArgument(i12 <= charSequence.length(), "end should be < than charSequence length");
        if (charSequence.length() == 0 || i11 == i12) {
            return charSequence;
        }
        if (i14 != 1) {
            if (i14 != 2) {
                z12 = this.f35887b;
            }
            z11 = z12;
        } else {
            z11 = true;
        }
        return this.mHelper.e(charSequence, i11, i12, i13, z11);
    }

    @Nullable
    @RestrictTo({RestrictTo.Scope.TESTS})
    public static EmojiCompat reset(@Nullable EmojiCompat emojiCompat) {
        EmojiCompat emojiCompat2;
        synchronized (INSTANCE_LOCK) {
            sInstance = emojiCompat;
            emojiCompat2 = sInstance;
        }
        return emojiCompat2;
    }

    @NonNull
    public static EmojiCompat init(@NonNull Config config) {
        EmojiCompat emojiCompat = sInstance;
        if (emojiCompat == null) {
            synchronized (INSTANCE_LOCK) {
                emojiCompat = sInstance;
                if (emojiCompat == null) {
                    emojiCompat = new EmojiCompat(config);
                    sInstance = emojiCompat;
                }
            }
        }
        return emojiCompat;
    }
}
