package androidx.asynclayoutinflater.view;

import android.content.Context;
import android.os.Handler;
import android.os.Message;
import android.util.AttributeSet;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.LayoutRes;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.UiThread;
import androidx.core.util.Pools;
import java.util.concurrent.ArrayBlockingQueue;

public final class AsyncLayoutInflater {
    private static final String TAG = "AsyncLayoutInflater";

    /* renamed from: a  reason: collision with root package name */
    public LayoutInflater f948a;

    /* renamed from: b  reason: collision with root package name */
    public Handler f949b;

    /* renamed from: c  reason: collision with root package name */
    public InflateThread f950c;
    private Handler.Callback mHandlerCallback = new Handler.Callback() {
        public boolean handleMessage(Message message) {
            InflateRequest inflateRequest = (InflateRequest) message.obj;
            if (inflateRequest.f955d == null) {
                inflateRequest.f955d = AsyncLayoutInflater.this.f948a.inflate(inflateRequest.f954c, inflateRequest.f953b, false);
            }
            inflateRequest.f956e.onInflateFinished(inflateRequest.f955d, inflateRequest.f954c, inflateRequest.f953b);
            AsyncLayoutInflater.this.f950c.releaseRequest(inflateRequest);
            return true;
        }
    };

    public static class BasicInflater extends LayoutInflater {
        private static final String[] sClassPrefixList = {"android.widget.", "android.webkit.", "android.app."};

        public BasicInflater(Context context) {
            super(context);
        }

        public LayoutInflater cloneInContext(Context context) {
            return new BasicInflater(context);
        }

        public View onCreateView(String str, AttributeSet attributeSet) throws ClassNotFoundException {
            String[] strArr = sClassPrefixList;
            int length = strArr.length;
            int i11 = 0;
            while (i11 < length) {
                try {
                    View createView = createView(str, strArr[i11], attributeSet);
                    if (createView != null) {
                        return createView;
                    }
                    i11++;
                } catch (ClassNotFoundException unused) {
                }
            }
            return super.onCreateView(str, attributeSet);
        }
    }

    public static class InflateRequest {

        /* renamed from: a  reason: collision with root package name */
        public AsyncLayoutInflater f952a;

        /* renamed from: b  reason: collision with root package name */
        public ViewGroup f953b;

        /* renamed from: c  reason: collision with root package name */
        public int f954c;

        /* renamed from: d  reason: collision with root package name */
        public View f955d;

        /* renamed from: e  reason: collision with root package name */
        public OnInflateFinishedListener f956e;
    }

    public static class InflateThread extends Thread {
        private static final InflateThread sInstance;
        private ArrayBlockingQueue<InflateRequest> mQueue = new ArrayBlockingQueue<>(10);
        private Pools.SynchronizedPool<InflateRequest> mRequestPool = new Pools.SynchronizedPool<>(10);

        static {
            InflateThread inflateThread = new InflateThread();
            sInstance = inflateThread;
            inflateThread.start();
        }

        private InflateThread() {
        }

        public static InflateThread getInstance() {
            return sInstance;
        }

        public void enqueue(InflateRequest inflateRequest) {
            try {
                this.mQueue.put(inflateRequest);
            } catch (InterruptedException e11) {
                throw new RuntimeException("Failed to enqueue async inflate request", e11);
            }
        }

        public InflateRequest obtainRequest() {
            InflateRequest acquire = this.mRequestPool.acquire();
            if (acquire == null) {
                return new InflateRequest();
            }
            return acquire;
        }

        public void releaseRequest(InflateRequest inflateRequest) {
            inflateRequest.f956e = null;
            inflateRequest.f952a = null;
            inflateRequest.f953b = null;
            inflateRequest.f954c = 0;
            inflateRequest.f955d = null;
            this.mRequestPool.release(inflateRequest);
        }

        public void run() {
            while (true) {
                runInner();
            }
        }

        public void runInner() {
            try {
                InflateRequest take = this.mQueue.take();
                try {
                    take.f955d = take.f952a.f948a.inflate(take.f954c, take.f953b, false);
                } catch (RuntimeException e11) {
                    Log.w(AsyncLayoutInflater.TAG, "Failed to inflate resource in the background! Retrying on the UI thread", e11);
                }
                Message.obtain(take.f952a.f949b, 0, take).sendToTarget();
            } catch (InterruptedException e12) {
                Log.w(AsyncLayoutInflater.TAG, e12);
            }
        }
    }

    public interface OnInflateFinishedListener {
        void onInflateFinished(@NonNull View view, @LayoutRes int i11, @Nullable ViewGroup viewGroup);
    }

    public AsyncLayoutInflater(@NonNull Context context) {
        this.f948a = new BasicInflater(context);
        this.f949b = new Handler(this.mHandlerCallback);
        this.f950c = InflateThread.getInstance();
    }

    @UiThread
    public void inflate(@LayoutRes int i11, @Nullable ViewGroup viewGroup, @NonNull OnInflateFinishedListener onInflateFinishedListener) {
        if (onInflateFinishedListener != null) {
            InflateRequest obtainRequest = this.f950c.obtainRequest();
            obtainRequest.f952a = this;
            obtainRequest.f954c = i11;
            obtainRequest.f953b = viewGroup;
            obtainRequest.f956e = onInflateFinishedListener;
            this.f950c.enqueue(obtainRequest);
            return;
        }
        throw new NullPointerException("callback argument may not be null!");
    }
}
