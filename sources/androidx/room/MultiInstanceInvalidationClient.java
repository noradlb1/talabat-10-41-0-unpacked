package androidx.room;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.os.RemoteException;
import android.util.Log;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.room.IMultiInstanceInvalidationCallback;
import androidx.room.IMultiInstanceInvalidationService;
import androidx.room.InvalidationTracker;
import java.util.Set;
import java.util.concurrent.Executor;
import java.util.concurrent.atomic.AtomicBoolean;

class MultiInstanceInvalidationClient {

    /* renamed from: a  reason: collision with root package name */
    public final Context f37439a;

    /* renamed from: b  reason: collision with root package name */
    public final String f37440b;

    /* renamed from: c  reason: collision with root package name */
    public int f37441c;

    /* renamed from: d  reason: collision with root package name */
    public final InvalidationTracker f37442d;

    /* renamed from: e  reason: collision with root package name */
    public final InvalidationTracker.Observer f37443e;
    @Nullable

    /* renamed from: f  reason: collision with root package name */
    public IMultiInstanceInvalidationService f37444f;

    /* renamed from: g  reason: collision with root package name */
    public final Executor f37445g;

    /* renamed from: h  reason: collision with root package name */
    public final IMultiInstanceInvalidationCallback f37446h = new IMultiInstanceInvalidationCallback.Stub() {
        public void onInvalidation(final String[] strArr) {
            MultiInstanceInvalidationClient.this.f37445g.execute(new Runnable() {
                public void run() {
                    MultiInstanceInvalidationClient.this.f37442d.notifyObserversByTableNames(strArr);
                }
            });
        }
    };

    /* renamed from: i  reason: collision with root package name */
    public final AtomicBoolean f37447i = new AtomicBoolean(false);

    /* renamed from: j  reason: collision with root package name */
    public final ServiceConnection f37448j;

    /* renamed from: k  reason: collision with root package name */
    public final Runnable f37449k;

    /* renamed from: l  reason: collision with root package name */
    public final Runnable f37450l;

    public MultiInstanceInvalidationClient(Context context, String str, Intent intent, InvalidationTracker invalidationTracker, Executor executor) {
        AnonymousClass2 r02 = new ServiceConnection() {
            public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
                MultiInstanceInvalidationClient.this.f37444f = IMultiInstanceInvalidationService.Stub.asInterface(iBinder);
                MultiInstanceInvalidationClient multiInstanceInvalidationClient = MultiInstanceInvalidationClient.this;
                multiInstanceInvalidationClient.f37445g.execute(multiInstanceInvalidationClient.f37449k);
            }

            public void onServiceDisconnected(ComponentName componentName) {
                MultiInstanceInvalidationClient multiInstanceInvalidationClient = MultiInstanceInvalidationClient.this;
                multiInstanceInvalidationClient.f37445g.execute(multiInstanceInvalidationClient.f37450l);
                MultiInstanceInvalidationClient.this.f37444f = null;
            }
        };
        this.f37448j = r02;
        this.f37449k = new Runnable() {
            public void run() {
                try {
                    MultiInstanceInvalidationClient multiInstanceInvalidationClient = MultiInstanceInvalidationClient.this;
                    IMultiInstanceInvalidationService iMultiInstanceInvalidationService = multiInstanceInvalidationClient.f37444f;
                    if (iMultiInstanceInvalidationService != null) {
                        multiInstanceInvalidationClient.f37441c = iMultiInstanceInvalidationService.registerCallback(multiInstanceInvalidationClient.f37446h, multiInstanceInvalidationClient.f37440b);
                        MultiInstanceInvalidationClient multiInstanceInvalidationClient2 = MultiInstanceInvalidationClient.this;
                        multiInstanceInvalidationClient2.f37442d.addObserver(multiInstanceInvalidationClient2.f37443e);
                    }
                } catch (RemoteException e11) {
                    Log.w("ROOM", "Cannot register multi-instance invalidation callback", e11);
                }
            }
        };
        this.f37450l = new Runnable() {
            public void run() {
                MultiInstanceInvalidationClient multiInstanceInvalidationClient = MultiInstanceInvalidationClient.this;
                multiInstanceInvalidationClient.f37442d.removeObserver(multiInstanceInvalidationClient.f37443e);
            }
        };
        Context applicationContext = context.getApplicationContext();
        this.f37439a = applicationContext;
        this.f37440b = str;
        this.f37442d = invalidationTracker;
        this.f37445g = executor;
        this.f37443e = new InvalidationTracker.Observer((String[]) invalidationTracker.f37421a.keySet().toArray(new String[0])) {
            public boolean a() {
                return true;
            }

            public void onInvalidated(@NonNull Set<String> set) {
                if (!MultiInstanceInvalidationClient.this.f37447i.get()) {
                    try {
                        MultiInstanceInvalidationClient multiInstanceInvalidationClient = MultiInstanceInvalidationClient.this;
                        IMultiInstanceInvalidationService iMultiInstanceInvalidationService = multiInstanceInvalidationClient.f37444f;
                        if (iMultiInstanceInvalidationService != null) {
                            iMultiInstanceInvalidationService.broadcastInvalidation(multiInstanceInvalidationClient.f37441c, (String[]) set.toArray(new String[0]));
                        }
                    } catch (RemoteException e11) {
                        Log.w("ROOM", "Cannot broadcast invalidation", e11);
                    }
                }
            }
        };
        applicationContext.bindService(intent, r02, 1);
    }

    public void a() {
        if (this.f37447i.compareAndSet(false, true)) {
            this.f37442d.removeObserver(this.f37443e);
            try {
                IMultiInstanceInvalidationService iMultiInstanceInvalidationService = this.f37444f;
                if (iMultiInstanceInvalidationService != null) {
                    iMultiInstanceInvalidationService.unregisterCallback(this.f37446h, this.f37441c);
                }
            } catch (RemoteException e11) {
                Log.w("ROOM", "Cannot unregister multi-instance invalidation callback", e11);
            }
            this.f37439a.unbindService(this.f37448j);
        }
    }
}
