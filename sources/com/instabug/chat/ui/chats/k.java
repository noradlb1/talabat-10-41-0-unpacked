package com.instabug.chat.ui.chats;

import android.annotation.SuppressLint;
import android.content.Context;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import com.instabug.chat.model.c;
import com.instabug.chat.model.d;
import com.instabug.chat.notification.v;
import com.instabug.chat.synchronization.a;
import com.instabug.chat.synchronization.b;
import com.instabug.library.Instabug;
import com.instabug.library.PresentationManager;
import com.instabug.library.core.ui.BasePresenter;
import com.instabug.library.diagnostics.IBGDiagnostics;
import com.instabug.library.internal.storage.cache.CacheChangedListener;
import com.instabug.library.internal.storage.cache.CacheManager;
import com.instabug.library.util.InstabugSDKLogger;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.subjects.PublishSubject;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.TimeUnit;

class k extends BasePresenter implements e, CacheChangedListener, b {
    @Nullable

    /* renamed from: a  reason: collision with root package name */
    private PublishSubject f46276a;
    @Nullable

    /* renamed from: b  reason: collision with root package name */
    private Disposable f46277b;

    public k(f fVar) {
        super(fVar);
    }

    private void a(long j11) {
        PublishSubject publishSubject = this.f46276a;
        if (publishSubject != null) {
            publishSubject.onNext(Long.valueOf(j11));
        }
    }

    private void a(CacheChangedListener cacheChangedListener) {
        try {
            CacheManager.getInstance().subscribe("chats_memory_cache", cacheChangedListener);
        } catch (IllegalArgumentException e11) {
            InstabugSDKLogger.e("ChatsPresenter", "Couldn't subscribe to cache", e11);
            IBGDiagnostics.reportNonFatal(e11, "Couldn't subscribe to cache");
        }
    }

    private synchronized ArrayList k() {
        ArrayList arrayList;
        arrayList = com.instabug.chat.cache.k.b() != null ? new ArrayList(com.instabug.chat.cache.k.i()) : new ArrayList();
        Collections.sort(arrayList, Collections.reverseOrder(new c()));
        return arrayList;
    }

    private void l() {
        PublishSubject create = PublishSubject.create();
        this.f46276a = create;
        this.f46277b = (Disposable) create.debounce(300, TimeUnit.MILLISECONDS).observeOn(AndroidSchedulers.mainThread()).subscribeWith(new j(this));
    }

    private void m() {
        Disposable disposable = this.f46277b;
        if (disposable != null && !disposable.isDisposed()) {
            this.f46277b.dispose();
        }
    }

    /* access modifiers changed from: private */
    public void n() {
        f fVar;
        ArrayList k11 = k();
        Collections.sort(k11, Collections.reverseOrder(new c()));
        WeakReference<V> weakReference = this.f34200f;
        if (weakReference != null && (fVar = (f) weakReference.get()) != null) {
            fVar.a(k11);
            fVar.l();
        }
    }

    /* renamed from: a */
    public void onCachedItemAdded(d dVar) {
        a(System.currentTimeMillis());
    }

    /* renamed from: a */
    public void onCachedItemUpdated(d dVar, d dVar2) {
        a(System.currentTimeMillis());
    }

    public void b() {
        l();
        a((CacheChangedListener) this);
        a.b().a((b) this);
        n();
    }

    /* renamed from: b */
    public void onCachedItemRemoved(d dVar) {
        a(System.currentTimeMillis());
    }

    public void g() {
        CacheManager.getInstance().unSubscribe("chats_memory_cache", this);
        a.b().b((b) this);
        m();
    }

    public void onCacheInvalidated() {
        a(System.currentTimeMillis());
    }

    @SuppressLint({"ERADICATE_INCONSISTENT_SUBCLASS_RETURN_ANNOTATION"})
    @Nullable
    public List onNewMessagesReceived(@NonNull List list) {
        f fVar;
        WeakReference<V> weakReference = this.f34200f;
        if (weakReference == null || (fVar = (f) weakReference.get()) == null || ((Fragment) fVar.getViewContext()).getActivity() == null) {
            return null;
        }
        if (fVar.c()) {
            v.a().b((Context) ((Fragment) fVar.getViewContext()).getActivity());
            return null;
        } else if (Instabug.getApplicationContext() == null) {
            return null;
        } else {
            PresentationManager.getInstance().show(new i(this, list));
            return null;
        }
    }
}
