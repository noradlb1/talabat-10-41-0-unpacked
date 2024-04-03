package androidx.browser.trusted;

import android.content.ComponentName;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.support.customtabs.trusted.ITrustedWebActivityService;
import androidx.annotation.MainThread;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.concurrent.futures.CallbackToFutureAdapter;
import com.google.common.util.concurrent.ListenableFuture;
import java.util.ArrayList;
import java.util.List;

class ConnectionHolder implements ServiceConnection {
    private static final int STATE_AWAITING_CONNECTION = 0;
    private static final int STATE_CANCELLED = 3;
    private static final int STATE_CONNECTED = 1;
    private static final int STATE_DISCONNECTED = 2;
    @Nullable
    private Exception mCancellationException;
    @NonNull
    private final Runnable mCloseRunnable;
    @NonNull
    private List<CallbackToFutureAdapter.Completer<TrustedWebActivityServiceConnection>> mCompleters;
    @Nullable
    private TrustedWebActivityServiceConnection mService;
    private int mState;
    @NonNull
    private final WrapperFactory mWrapperFactory;

    public static class WrapperFactory {
        @NonNull
        public TrustedWebActivityServiceConnection a(ComponentName componentName, IBinder iBinder) {
            return new TrustedWebActivityServiceConnection(ITrustedWebActivityService.Stub.asInterface(iBinder), componentName);
        }
    }

    @MainThread
    public ConnectionHolder(@NonNull Runnable runnable) {
        this(runnable, new WrapperFactory());
    }

    /* access modifiers changed from: private */
    public /* synthetic */ Object lambda$getServiceWrapper$0(CallbackToFutureAdapter.Completer completer) throws Exception {
        int i11 = this.mState;
        if (i11 == 0) {
            this.mCompleters.add(completer);
        } else if (i11 == 1) {
            TrustedWebActivityServiceConnection trustedWebActivityServiceConnection = this.mService;
            if (trustedWebActivityServiceConnection != null) {
                completer.set(trustedWebActivityServiceConnection);
            } else {
                throw new IllegalStateException("ConnectionHolder state is incorrect.");
            }
        } else if (i11 == 2) {
            throw new IllegalStateException("Service has been disconnected.");
        } else if (i11 != 3) {
            throw new IllegalStateException("Connection state is invalid");
        } else {
            throw this.mCancellationException;
        }
        return "ConnectionHolder, state = " + this.mState;
    }

    @MainThread
    public void cancel(@NonNull Exception exc) {
        for (CallbackToFutureAdapter.Completer<TrustedWebActivityServiceConnection> exception : this.mCompleters) {
            exception.setException(exc);
        }
        this.mCompleters.clear();
        this.mCloseRunnable.run();
        this.mState = 3;
        this.mCancellationException = exc;
    }

    @MainThread
    @NonNull
    public ListenableFuture<TrustedWebActivityServiceConnection> getServiceWrapper() {
        return CallbackToFutureAdapter.getFuture(new a(this));
    }

    @MainThread
    public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
        this.mService = this.mWrapperFactory.a(componentName, iBinder);
        for (CallbackToFutureAdapter.Completer<TrustedWebActivityServiceConnection> completer : this.mCompleters) {
            completer.set(this.mService);
        }
        this.mCompleters.clear();
        this.mState = 1;
    }

    @MainThread
    public void onServiceDisconnected(ComponentName componentName) {
        this.mService = null;
        this.mCloseRunnable.run();
        this.mState = 2;
    }

    @MainThread
    public ConnectionHolder(@NonNull Runnable runnable, @NonNull WrapperFactory wrapperFactory) {
        this.mState = 0;
        this.mCompleters = new ArrayList();
        this.mCloseRunnable = runnable;
        this.mWrapperFactory = wrapperFactory;
    }
}
