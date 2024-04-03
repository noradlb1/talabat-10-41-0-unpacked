package androidx.loader.content;

import android.content.Context;
import android.os.Handler;
import android.os.SystemClock;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
import androidx.core.os.OperationCanceledException;
import androidx.core.util.TimeUtils;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.Executor;

public abstract class AsyncTaskLoader<D> extends Loader<D> {
    static final boolean DEBUG = false;
    static final String TAG = "AsyncTaskLoader";
    volatile AsyncTaskLoader<D>.LoadTask mCancellingTask;
    private final Executor mExecutor;
    Handler mHandler;
    long mLastLoadCompleteTime;
    volatile AsyncTaskLoader<D>.LoadTask mTask;
    long mUpdateThrottle;

    public final class LoadTask extends ModernAsyncTask<Void, Void, D> implements Runnable {

        /* renamed from: d  reason: collision with root package name */
        public boolean f36148d;
        private final CountDownLatch mDone = new CountDownLatch(1);

        public LoadTask() {
        }

        public void d(D d11) {
            try {
                AsyncTaskLoader.this.dispatchOnCancelled(this, d11);
            } finally {
                this.mDone.countDown();
            }
        }

        public void e(D d11) {
            try {
                AsyncTaskLoader.this.dispatchOnLoadComplete(this, d11);
            } finally {
                this.mDone.countDown();
            }
        }

        /* renamed from: j */
        public D a(Void... voidArr) {
            try {
                return AsyncTaskLoader.this.onLoadInBackground();
            } catch (OperationCanceledException e11) {
                if (isCancelled()) {
                    return null;
                }
                throw e11;
            }
        }

        public void run() {
            this.f36148d = false;
            AsyncTaskLoader.this.executePendingTask();
        }

        public void waitForLoader() {
            try {
                this.mDone.await();
            } catch (InterruptedException unused) {
            }
        }
    }

    public AsyncTaskLoader(@NonNull Context context) {
        this(context, ModernAsyncTask.THREAD_POOL_EXECUTOR);
    }

    public void cancelLoadInBackground() {
    }

    public void dispatchOnCancelled(AsyncTaskLoader<D>.LoadTask loadTask, D d11) {
        onCanceled(d11);
        if (this.mCancellingTask == loadTask) {
            rollbackContentChanged();
            this.mLastLoadCompleteTime = SystemClock.uptimeMillis();
            this.mCancellingTask = null;
            deliverCancellation();
            executePendingTask();
        }
    }

    public void dispatchOnLoadComplete(AsyncTaskLoader<D>.LoadTask loadTask, D d11) {
        if (this.mTask != loadTask) {
            dispatchOnCancelled(loadTask, d11);
        } else if (isAbandoned()) {
            onCanceled(d11);
        } else {
            commitContentChanged();
            this.mLastLoadCompleteTime = SystemClock.uptimeMillis();
            this.mTask = null;
            deliverResult(d11);
        }
    }

    @Deprecated
    public void dump(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr) {
        super.dump(str, fileDescriptor, printWriter, strArr);
        if (this.mTask != null) {
            printWriter.print(str);
            printWriter.print("mTask=");
            printWriter.print(this.mTask);
            printWriter.print(" waiting=");
            printWriter.println(this.mTask.f36148d);
        }
        if (this.mCancellingTask != null) {
            printWriter.print(str);
            printWriter.print("mCancellingTask=");
            printWriter.print(this.mCancellingTask);
            printWriter.print(" waiting=");
            printWriter.println(this.mCancellingTask.f36148d);
        }
        if (this.mUpdateThrottle != 0) {
            printWriter.print(str);
            printWriter.print("mUpdateThrottle=");
            TimeUtils.formatDuration(this.mUpdateThrottle, printWriter);
            printWriter.print(" mLastLoadCompleteTime=");
            TimeUtils.formatDuration(this.mLastLoadCompleteTime, SystemClock.uptimeMillis(), printWriter);
            printWriter.println();
        }
    }

    public void executePendingTask() {
        if (this.mCancellingTask == null && this.mTask != null) {
            if (this.mTask.f36148d) {
                this.mTask.f36148d = false;
                this.mHandler.removeCallbacks(this.mTask);
            }
            if (this.mUpdateThrottle <= 0 || SystemClock.uptimeMillis() >= this.mLastLoadCompleteTime + this.mUpdateThrottle) {
                this.mTask.executeOnExecutor(this.mExecutor, (Params[]) null);
                return;
            }
            this.mTask.f36148d = true;
            this.mHandler.postAtTime(this.mTask, this.mLastLoadCompleteTime + this.mUpdateThrottle);
        }
    }

    public boolean isLoadInBackgroundCanceled() {
        return this.mCancellingTask != null;
    }

    @Nullable
    public abstract D loadInBackground();

    public boolean onCancelLoad() {
        if (this.mTask == null) {
            return false;
        }
        if (!this.mStarted) {
            this.mContentChanged = true;
        }
        if (this.mCancellingTask != null) {
            if (this.mTask.f36148d) {
                this.mTask.f36148d = false;
                this.mHandler.removeCallbacks(this.mTask);
            }
            this.mTask = null;
            return false;
        } else if (this.mTask.f36148d) {
            this.mTask.f36148d = false;
            this.mHandler.removeCallbacks(this.mTask);
            this.mTask = null;
            return false;
        } else {
            boolean cancel = this.mTask.cancel(false);
            if (cancel) {
                this.mCancellingTask = this.mTask;
                cancelLoadInBackground();
            }
            this.mTask = null;
            return cancel;
        }
    }

    public void onCanceled(@Nullable D d11) {
    }

    public void onForceLoad() {
        super.onForceLoad();
        cancelLoad();
        this.mTask = new LoadTask();
        executePendingTask();
    }

    @Nullable
    public D onLoadInBackground() {
        return loadInBackground();
    }

    public void setUpdateThrottle(long j11) {
        this.mUpdateThrottle = j11;
        if (j11 != 0) {
            this.mHandler = new Handler();
        }
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public void waitForLoader() {
        AsyncTaskLoader<D>.LoadTask loadTask = this.mTask;
        if (loadTask != null) {
            loadTask.waitForLoader();
        }
    }

    private AsyncTaskLoader(@NonNull Context context, @NonNull Executor executor) {
        super(context);
        this.mLastLoadCompleteTime = -10000;
        this.mExecutor = executor;
    }
}
