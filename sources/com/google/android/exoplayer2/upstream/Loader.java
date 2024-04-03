package com.google.android.exoplayer2.upstream;

import android.annotation.SuppressLint;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.os.SystemClock;
import androidx.annotation.Nullable;
import com.google.android.exoplayer2.C;
import com.google.android.exoplayer2.util.Assertions;
import com.google.android.exoplayer2.util.Log;
import com.google.android.exoplayer2.util.TraceUtil;
import com.google.android.exoplayer2.util.Util;
import java.io.IOException;
import java.util.concurrent.ExecutorService;

public final class Loader implements LoaderErrorThrower {
    private static final int ACTION_TYPE_DONT_RETRY = 2;
    private static final int ACTION_TYPE_DONT_RETRY_FATAL = 3;
    private static final int ACTION_TYPE_RETRY = 0;
    private static final int ACTION_TYPE_RETRY_AND_RESET_ERROR_COUNT = 1;
    public static final LoadErrorAction DONT_RETRY = new LoadErrorAction(2, C.TIME_UNSET);
    public static final LoadErrorAction DONT_RETRY_FATAL = new LoadErrorAction(3, C.TIME_UNSET);
    public static final LoadErrorAction RETRY = createRetryAction(false, C.TIME_UNSET);
    public static final LoadErrorAction RETRY_RESET_ERROR_COUNT = createRetryAction(true, C.TIME_UNSET);
    private static final String THREAD_NAME_PREFIX = "ExoPlayer:Loader:";
    /* access modifiers changed from: private */
    @Nullable
    public LoadTask<? extends Loadable> currentTask;
    /* access modifiers changed from: private */
    public final ExecutorService downloadExecutorService;
    /* access modifiers changed from: private */
    @Nullable
    public IOException fatalError;

    public interface Callback<T extends Loadable> {
        void onLoadCanceled(T t11, long j11, long j12, boolean z11);

        void onLoadCompleted(T t11, long j11, long j12);

        LoadErrorAction onLoadError(T t11, long j11, long j12, IOException iOException, int i11);
    }

    public static final class LoadErrorAction {
        /* access modifiers changed from: private */
        public final long retryDelayMillis;
        /* access modifiers changed from: private */
        public final int type;

        public boolean isRetry() {
            int i11 = this.type;
            return i11 == 0 || i11 == 1;
        }

        private LoadErrorAction(int i11, long j11) {
            this.type = i11;
            this.retryDelayMillis = j11;
        }
    }

    @SuppressLint({"HandlerLeak"})
    public final class LoadTask<T extends Loadable> extends Handler implements Runnable {
        private static final int MSG_FATAL_ERROR = 3;
        private static final int MSG_FINISH = 1;
        private static final int MSG_IO_EXCEPTION = 2;
        private static final int MSG_START = 0;
        private static final String TAG = "LoadTask";
        @Nullable
        private Callback<T> callback;
        private boolean canceled;
        @Nullable
        private IOException currentError;
        public final int defaultMinRetryCount;
        private int errorCount;
        @Nullable
        private Thread executorThread;
        private final T loadable;
        private volatile boolean released;
        private final long startTimeMs;

        public LoadTask(Looper looper, T t11, Callback<T> callback2, int i11, long j11) {
            super(looper);
            this.loadable = t11;
            this.callback = callback2;
            this.defaultMinRetryCount = i11;
            this.startTimeMs = j11;
        }

        private void execute() {
            this.currentError = null;
            Loader.this.downloadExecutorService.execute((Runnable) Assertions.checkNotNull(Loader.this.currentTask));
        }

        private void finish() {
            LoadTask unused = Loader.this.currentTask = null;
        }

        private long getRetryDelayMillis() {
            return (long) Math.min((this.errorCount - 1) * 1000, 5000);
        }

        public void cancel(boolean z11) {
            this.released = z11;
            this.currentError = null;
            if (hasMessages(0)) {
                this.canceled = true;
                removeMessages(0);
                if (!z11) {
                    sendEmptyMessage(1);
                }
            } else {
                synchronized (this) {
                    this.canceled = true;
                    this.loadable.cancelLoad();
                    Thread thread = this.executorThread;
                    if (thread != null) {
                        thread.interrupt();
                    }
                }
            }
            if (z11) {
                finish();
                long elapsedRealtime = SystemClock.elapsedRealtime();
                ((Callback) Assertions.checkNotNull(this.callback)).onLoadCanceled(this.loadable, elapsedRealtime, elapsedRealtime - this.startTimeMs, true);
                this.callback = null;
            }
        }

        public void handleMessage(Message message) {
            long j11;
            if (!this.released) {
                int i11 = message.what;
                if (i11 == 0) {
                    execute();
                } else if (i11 != 3) {
                    finish();
                    long elapsedRealtime = SystemClock.elapsedRealtime();
                    long j12 = elapsedRealtime - this.startTimeMs;
                    Callback callback2 = (Callback) Assertions.checkNotNull(this.callback);
                    if (this.canceled) {
                        callback2.onLoadCanceled(this.loadable, elapsedRealtime, j12, false);
                        return;
                    }
                    int i12 = message.what;
                    if (i12 == 1) {
                        try {
                            callback2.onLoadCompleted(this.loadable, elapsedRealtime, j12);
                        } catch (RuntimeException e11) {
                            Log.e(TAG, "Unexpected exception handling load completed", e11);
                            IOException unused = Loader.this.fatalError = new UnexpectedLoaderException(e11);
                        }
                    } else if (i12 == 2) {
                        IOException iOException = (IOException) message.obj;
                        this.currentError = iOException;
                        int i13 = this.errorCount + 1;
                        this.errorCount = i13;
                        LoadErrorAction onLoadError = callback2.onLoadError(this.loadable, elapsedRealtime, j12, iOException, i13);
                        if (onLoadError.type == 3) {
                            IOException unused2 = Loader.this.fatalError = this.currentError;
                        } else if (onLoadError.type != 2) {
                            if (onLoadError.type == 1) {
                                this.errorCount = 1;
                            }
                            if (onLoadError.retryDelayMillis != C.TIME_UNSET) {
                                j11 = onLoadError.retryDelayMillis;
                            } else {
                                j11 = getRetryDelayMillis();
                            }
                            start(j11);
                        }
                    }
                } else {
                    throw ((Error) message.obj);
                }
            }
        }

        public void maybeThrowError(int i11) throws IOException {
            IOException iOException = this.currentError;
            if (iOException != null && this.errorCount > i11) {
                throw iOException;
            }
        }

        public void run() {
            boolean z11;
            try {
                synchronized (this) {
                    if (!this.canceled) {
                        z11 = true;
                    } else {
                        z11 = false;
                    }
                    this.executorThread = Thread.currentThread();
                }
                if (z11) {
                    TraceUtil.beginSection("load:" + this.loadable.getClass().getSimpleName());
                    this.loadable.load();
                    TraceUtil.endSection();
                }
                synchronized (this) {
                    this.executorThread = null;
                    Thread.interrupted();
                }
                if (!this.released) {
                    sendEmptyMessage(1);
                }
            } catch (IOException e11) {
                if (!this.released) {
                    obtainMessage(2, e11).sendToTarget();
                }
            } catch (Exception e12) {
                if (!this.released) {
                    Log.e(TAG, "Unexpected exception loading stream", e12);
                    obtainMessage(2, new UnexpectedLoaderException(e12)).sendToTarget();
                }
            } catch (OutOfMemoryError e13) {
                if (!this.released) {
                    Log.e(TAG, "OutOfMemory error loading stream", e13);
                    obtainMessage(2, new UnexpectedLoaderException(e13)).sendToTarget();
                }
            } catch (Error e14) {
                if (!this.released) {
                    Log.e(TAG, "Unexpected error loading stream", e14);
                    obtainMessage(3, e14).sendToTarget();
                }
                throw e14;
            } catch (Throwable th2) {
                TraceUtil.endSection();
                throw th2;
            }
        }

        public void start(long j11) {
            boolean z11;
            if (Loader.this.currentTask == null) {
                z11 = true;
            } else {
                z11 = false;
            }
            Assertions.checkState(z11);
            LoadTask unused = Loader.this.currentTask = this;
            if (j11 > 0) {
                sendEmptyMessageDelayed(0, j11);
            } else {
                execute();
            }
        }
    }

    public interface Loadable {
        void cancelLoad();

        void load() throws IOException;
    }

    public interface ReleaseCallback {
        void onLoaderReleased();
    }

    public static final class ReleaseTask implements Runnable {
        private final ReleaseCallback callback;

        public ReleaseTask(ReleaseCallback releaseCallback) {
            this.callback = releaseCallback;
        }

        public void run() {
            this.callback.onLoaderReleased();
        }
    }

    public static final class UnexpectedLoaderException extends IOException {
        public UnexpectedLoaderException(Throwable th2) {
            super("Unexpected " + th2.getClass().getSimpleName() + ": " + th2.getMessage(), th2);
        }
    }

    public Loader(String str) {
        this.downloadExecutorService = Util.newSingleThreadExecutor(THREAD_NAME_PREFIX + str);
    }

    public static LoadErrorAction createRetryAction(boolean z11, long j11) {
        return new LoadErrorAction(z11 ? 1 : 0, j11);
    }

    public void cancelLoading() {
        ((LoadTask) Assertions.checkStateNotNull(this.currentTask)).cancel(false);
    }

    public void clearFatalError() {
        this.fatalError = null;
    }

    public boolean hasFatalError() {
        return this.fatalError != null;
    }

    public boolean isLoading() {
        return this.currentTask != null;
    }

    public void maybeThrowError() throws IOException {
        maybeThrowError(Integer.MIN_VALUE);
    }

    public void release() {
        release((ReleaseCallback) null);
    }

    public <T extends Loadable> long startLoading(T t11, Callback<T> callback, int i11) {
        this.fatalError = null;
        long elapsedRealtime = SystemClock.elapsedRealtime();
        new LoadTask((Looper) Assertions.checkStateNotNull(Looper.myLooper()), t11, callback, i11, elapsedRealtime).start(0);
        return elapsedRealtime;
    }

    public void maybeThrowError(int i11) throws IOException {
        IOException iOException = this.fatalError;
        if (iOException == null) {
            LoadTask<? extends Loadable> loadTask = this.currentTask;
            if (loadTask != null) {
                if (i11 == Integer.MIN_VALUE) {
                    i11 = loadTask.defaultMinRetryCount;
                }
                loadTask.maybeThrowError(i11);
                return;
            }
            return;
        }
        throw iOException;
    }

    public void release(@Nullable ReleaseCallback releaseCallback) {
        LoadTask<? extends Loadable> loadTask = this.currentTask;
        if (loadTask != null) {
            loadTask.cancel(true);
        }
        if (releaseCallback != null) {
            this.downloadExecutorService.execute(new ReleaseTask(releaseCallback));
        }
        this.downloadExecutorService.shutdown();
    }
}
