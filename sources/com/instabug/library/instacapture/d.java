package com.instabug.library.instacapture;

import android.annotation.SuppressLint;
import android.app.Activity;
import androidx.annotation.IdRes;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.instabug.library.instacapture.exception.b;
import com.instabug.library.instacapture.exception.c;
import com.instabug.library.instacapture.screenshot.a;
import com.instabug.library.util.InstabugSDKLogger;
import com.instabug.library.util.threading.PoolProvider;
import com.instabug.library.util.threading.PriorityThreadFactory;
import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public final class d {

    /* renamed from: e  reason: collision with root package name */
    private static d f34376e;
    @NonNull

    /* renamed from: a  reason: collision with root package name */
    private a f34377a;
    @Nullable

    /* renamed from: b  reason: collision with root package name */
    private a f34378b = a();

    /* renamed from: c  reason: collision with root package name */
    private final Map f34379c = new HashMap();

    /* renamed from: d  reason: collision with root package name */
    private final Map f34380d = new HashMap();

    private d(@NonNull Activity activity) {
        new ThreadPoolExecutor(1, 1, 60, TimeUnit.SECONDS, new LinkedBlockingQueue(), new PriorityThreadFactory("screenshot-executor", 10));
        a aVar = new a();
        this.f34377a = aVar;
        aVar.b(activity);
    }

    public static d a(@NonNull Activity activity) {
        d dVar;
        synchronized (d.class) {
            d dVar2 = f34376e;
            if (dVar2 == null) {
                f34376e = new d(activity);
            } else {
                dVar2.b(activity);
            }
            dVar = f34376e;
        }
        return dVar;
    }

    private void b(@NonNull Activity activity) {
        this.f34377a.b(activity);
    }

    /* access modifiers changed from: private */
    public void b() {
        if (this.f34379c.size() > 0) {
            com.instabug.library.instacapture.listener.a aVar = (com.instabug.library.instacapture.listener.a) this.f34379c.keySet().toArray()[0];
            this.f34380d.put(aVar, b(aVar));
        }
    }

    @SuppressLint({"ERADICATE_NULLABLE_DEREFERENCE"})
    @Nullable
    private Disposable b(com.instabug.library.instacapture.listener.a aVar) {
        if (this.f34379c.get(aVar) != null) {
            return ((Observable) this.f34379c.get(aVar)).subscribeOn(Schedulers.from(PoolProvider.getSingleThreadExecutor("ibg-capture"))).subscribe(new b(this, aVar), new c(this, aVar));
        }
        return null;
    }

    public void a(com.instabug.library.instacapture.listener.a aVar, @IdRes @Nullable int... iArr) {
        if (this.f34378b == null) {
            a a11 = a();
            this.f34378b = a11;
            if (a11 == null) {
                if (aVar != null) {
                    aVar.a(new Throwable("screenshot provider is null"));
                    return;
                }
                return;
            }
        }
        this.f34379c.put(aVar, b(aVar, iArr));
        if (this.f34379c.size() == 1) {
            b();
        }
    }

    private Observable b(com.instabug.library.instacapture.listener.a aVar, @IdRes @Nullable int... iArr) {
        Activity a11 = this.f34377a.a();
        if (a11 == null) {
            return Observable.error((Throwable) new com.instabug.library.instacapture.exception.a("Is your activity running?"));
        }
        if (aVar != null) {
            aVar.a();
        }
        a aVar2 = this.f34378b;
        if (aVar2 == null) {
            return Observable.error((Throwable) new c("screenshot provider is null"));
        }
        Observable a12 = aVar2.a(a11, iArr);
        if (a12 != null) {
            return a12.observeOn(AndroidSchedulers.mainThread());
        }
        return Observable.error((Throwable) new b("Observable of bitmap is null due to IllegalArgumentException or OutOfMemoryError"));
    }

    /* access modifiers changed from: private */
    public void a(com.instabug.library.instacapture.listener.a aVar) {
        if (this.f34380d.size() > 0) {
            Disposable disposable = (Disposable) this.f34380d.get(aVar);
            if (disposable != null) {
                disposable.dispose();
            }
            this.f34380d.remove(aVar);
            this.f34379c.remove(aVar);
        }
    }

    @Nullable
    private a a() {
        if (this.f34377a.a() != null) {
            return new a();
        }
        InstabugSDKLogger.e("IBG-Core", "Is your activity running?");
        return null;
    }
}
