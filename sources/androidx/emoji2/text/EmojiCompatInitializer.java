package androidx.emoji2.text;

import android.content.Context;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.annotation.WorkerThread;
import androidx.core.os.TraceCompat;
import androidx.emoji2.text.EmojiCompat;
import androidx.lifecycle.DefaultLifecycleObserver;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.ProcessLifecycleInitializer;
import androidx.startup.AppInitializer;
import androidx.startup.Initializer;
import d2.a;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.ThreadPoolExecutor;

public class EmojiCompatInitializer implements Initializer<Boolean> {
    private static final long STARTUP_THREAD_CREATION_DELAY_MS = 500;
    private static final String S_INITIALIZER_THREAD_NAME = "EmojiCompatInitializer";

    @RequiresApi(19)
    public static class BackgroundDefaultConfig extends EmojiCompat.Config {
        public BackgroundDefaultConfig(Context context) {
            super(new BackgroundDefaultLoader(context));
            setMetadataLoadStrategy(1);
        }
    }

    @RequiresApi(19)
    public static class BackgroundDefaultLoader implements EmojiCompat.MetadataRepoLoader {
        private final Context mContext;

        public BackgroundDefaultLoader(Context context) {
            this.mContext = context.getApplicationContext();
        }

        @WorkerThread
        /* renamed from: b */
        public void lambda$load$0(@NonNull final EmojiCompat.MetadataRepoLoaderCallback metadataRepoLoaderCallback, @NonNull final ThreadPoolExecutor threadPoolExecutor) {
            try {
                FontRequestEmojiCompatConfig create = DefaultEmojiCompatConfig.create(this.mContext);
                if (create != null) {
                    create.setLoadingExecutor(threadPoolExecutor);
                    create.a().load(new EmojiCompat.MetadataRepoLoaderCallback() {
                        public void onFailed(@Nullable Throwable th2) {
                            try {
                                metadataRepoLoaderCallback.onFailed(th2);
                            } finally {
                                threadPoolExecutor.shutdown();
                            }
                        }

                        public void onLoaded(@NonNull MetadataRepo metadataRepo) {
                            try {
                                metadataRepoLoaderCallback.onLoaded(metadataRepo);
                            } finally {
                                threadPoolExecutor.shutdown();
                            }
                        }
                    });
                    return;
                }
                throw new RuntimeException("EmojiCompat font provider not available on this device.");
            } catch (Throwable th2) {
                metadataRepoLoaderCallback.onFailed(th2);
                threadPoolExecutor.shutdown();
            }
        }

        public void load(@NonNull EmojiCompat.MetadataRepoLoaderCallback metadataRepoLoaderCallback) {
            ThreadPoolExecutor c11 = ConcurrencyHelpers.c(EmojiCompatInitializer.S_INITIALIZER_THREAD_NAME);
            c11.execute(new b(this, metadataRepoLoaderCallback, c11));
        }
    }

    public static class LoadEmojiCompatRunnable implements Runnable {
        public void run() {
            try {
                TraceCompat.beginSection("EmojiCompat.EmojiCompatInitializer.run");
                if (EmojiCompat.isConfigured()) {
                    EmojiCompat.get().load();
                }
            } finally {
                TraceCompat.endSection();
            }
        }
    }

    @RequiresApi(19)
    public void a(@NonNull Context context) {
        final Lifecycle lifecycle = ((LifecycleOwner) AppInitializer.getInstance(context).initializeComponent(ProcessLifecycleInitializer.class)).getLifecycle();
        lifecycle.addObserver(new DefaultLifecycleObserver() {
            public /* synthetic */ void onCreate(LifecycleOwner lifecycleOwner) {
                a.a(this, lifecycleOwner);
            }

            public /* synthetic */ void onDestroy(LifecycleOwner lifecycleOwner) {
                a.b(this, lifecycleOwner);
            }

            public /* synthetic */ void onPause(LifecycleOwner lifecycleOwner) {
                a.c(this, lifecycleOwner);
            }

            public void onResume(@NonNull LifecycleOwner lifecycleOwner) {
                EmojiCompatInitializer.this.b();
                lifecycle.removeObserver(this);
            }

            public /* synthetic */ void onStart(LifecycleOwner lifecycleOwner) {
                a.e(this, lifecycleOwner);
            }

            public /* synthetic */ void onStop(LifecycleOwner lifecycleOwner) {
                a.f(this, lifecycleOwner);
            }
        });
    }

    @RequiresApi(19)
    public void b() {
        ConcurrencyHelpers.d().postDelayed(new LoadEmojiCompatRunnable(), 500);
    }

    @NonNull
    public List<Class<? extends Initializer<?>>> dependencies() {
        return Collections.singletonList(ProcessLifecycleInitializer.class);
    }

    @NonNull
    public Boolean create(@NonNull Context context) {
        EmojiCompat.init((EmojiCompat.Config) new BackgroundDefaultConfig(context));
        a(context);
        return Boolean.TRUE;
    }
}
