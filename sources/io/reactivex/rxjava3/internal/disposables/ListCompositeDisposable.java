package io.reactivex.rxjava3.internal.disposables;

import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.disposables.DisposableContainer;
import io.reactivex.rxjava3.exceptions.CompositeException;
import io.reactivex.rxjava3.exceptions.Exceptions;
import io.reactivex.rxjava3.internal.util.ExceptionHelper;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Objects;

public final class ListCompositeDisposable implements Disposable, DisposableContainer {

    /* renamed from: b  reason: collision with root package name */
    public List<Disposable> f18786b;

    /* renamed from: c  reason: collision with root package name */
    public volatile boolean f18787c;

    public ListCompositeDisposable() {
    }

    public void a(List<Disposable> list) {
        if (list != null) {
            ArrayList arrayList = null;
            for (Disposable dispose : list) {
                try {
                    dispose.dispose();
                } catch (Throwable th2) {
                    Exceptions.throwIfFatal(th2);
                    if (arrayList == null) {
                        arrayList = new ArrayList();
                    }
                    arrayList.add(th2);
                }
            }
            if (arrayList == null) {
                return;
            }
            if (arrayList.size() == 1) {
                throw ExceptionHelper.wrapOrThrow((Throwable) arrayList.get(0));
            }
            throw new CompositeException((Iterable<? extends Throwable>) arrayList);
        }
    }

    public boolean add(Disposable disposable) {
        Objects.requireNonNull(disposable, "d is null");
        if (!this.f18787c) {
            synchronized (this) {
                if (!this.f18787c) {
                    List list = this.f18786b;
                    if (list == null) {
                        list = new LinkedList();
                        this.f18786b = list;
                    }
                    list.add(disposable);
                    return true;
                }
            }
        }
        disposable.dispose();
        return false;
    }

    public boolean addAll(Disposable... disposableArr) {
        Objects.requireNonNull(disposableArr, "ds is null");
        if (!this.f18787c) {
            synchronized (this) {
                if (!this.f18787c) {
                    List list = this.f18786b;
                    if (list == null) {
                        list = new LinkedList();
                        this.f18786b = list;
                    }
                    for (Disposable disposable : disposableArr) {
                        Objects.requireNonNull(disposable, "d is null");
                        list.add(disposable);
                    }
                    return true;
                }
            }
        }
        for (Disposable dispose : disposableArr) {
            dispose.dispose();
        }
        return false;
    }

    public void clear() {
        if (!this.f18787c) {
            synchronized (this) {
                if (!this.f18787c) {
                    List<Disposable> list = this.f18786b;
                    this.f18786b = null;
                    a(list);
                }
            }
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:17:0x0021, code lost:
        return false;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean delete(io.reactivex.rxjava3.disposables.Disposable r3) {
        /*
            r2 = this;
            java.lang.String r0 = "Disposable item is null"
            java.util.Objects.requireNonNull(r3, r0)
            boolean r0 = r2.f18787c
            r1 = 0
            if (r0 == 0) goto L_0x000b
            return r1
        L_0x000b:
            monitor-enter(r2)
            boolean r0 = r2.f18787c     // Catch:{ all -> 0x0022 }
            if (r0 == 0) goto L_0x0012
            monitor-exit(r2)     // Catch:{ all -> 0x0022 }
            return r1
        L_0x0012:
            java.util.List<io.reactivex.rxjava3.disposables.Disposable> r0 = r2.f18786b     // Catch:{ all -> 0x0022 }
            if (r0 == 0) goto L_0x0020
            boolean r3 = r0.remove(r3)     // Catch:{ all -> 0x0022 }
            if (r3 != 0) goto L_0x001d
            goto L_0x0020
        L_0x001d:
            monitor-exit(r2)     // Catch:{ all -> 0x0022 }
            r3 = 1
            return r3
        L_0x0020:
            monitor-exit(r2)     // Catch:{ all -> 0x0022 }
            return r1
        L_0x0022:
            r3 = move-exception
            monitor-exit(r2)     // Catch:{ all -> 0x0022 }
            throw r3
        */
        throw new UnsupportedOperationException("Method not decompiled: io.reactivex.rxjava3.internal.disposables.ListCompositeDisposable.delete(io.reactivex.rxjava3.disposables.Disposable):boolean");
    }

    public void dispose() {
        if (!this.f18787c) {
            synchronized (this) {
                if (!this.f18787c) {
                    this.f18787c = true;
                    List<Disposable> list = this.f18786b;
                    this.f18786b = null;
                    a(list);
                }
            }
        }
    }

    public boolean isDisposed() {
        return this.f18787c;
    }

    public boolean remove(Disposable disposable) {
        if (!delete(disposable)) {
            return false;
        }
        disposable.dispose();
        return true;
    }

    public ListCompositeDisposable(Disposable... disposableArr) {
        Objects.requireNonNull(disposableArr, "resources is null");
        this.f18786b = new LinkedList();
        for (Disposable disposable : disposableArr) {
            Objects.requireNonNull(disposable, "Disposable item is null");
            this.f18786b.add(disposable);
        }
    }

    public ListCompositeDisposable(Iterable<? extends Disposable> iterable) {
        Objects.requireNonNull(iterable, "resources is null");
        this.f18786b = new LinkedList();
        for (Disposable disposable : iterable) {
            Objects.requireNonNull(disposable, "Disposable item is null");
            this.f18786b.add(disposable);
        }
    }
}
