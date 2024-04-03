package io.reactivex.rxjava3.disposables;

import io.reactivex.rxjava3.annotations.NonNull;
import io.reactivex.rxjava3.annotations.Nullable;
import io.reactivex.rxjava3.exceptions.CompositeException;
import io.reactivex.rxjava3.exceptions.Exceptions;
import io.reactivex.rxjava3.internal.util.ExceptionHelper;
import io.reactivex.rxjava3.internal.util.OpenHashSet;
import java.util.ArrayList;
import java.util.Objects;

public final class CompositeDisposable implements Disposable, DisposableContainer {

    /* renamed from: b  reason: collision with root package name */
    public OpenHashSet<Disposable> f18782b;

    /* renamed from: c  reason: collision with root package name */
    public volatile boolean f18783c;

    public CompositeDisposable() {
    }

    public void a(@Nullable OpenHashSet<Disposable> openHashSet) {
        if (openHashSet != null) {
            ArrayList arrayList = null;
            for (Object obj : openHashSet.keys()) {
                if (obj instanceof Disposable) {
                    try {
                        ((Disposable) obj).dispose();
                    } catch (Throwable th2) {
                        Exceptions.throwIfFatal(th2);
                        if (arrayList == null) {
                            arrayList = new ArrayList();
                        }
                        arrayList.add(th2);
                    }
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

    public boolean add(@NonNull Disposable disposable) {
        Objects.requireNonNull(disposable, "disposable is null");
        if (!this.f18783c) {
            synchronized (this) {
                if (!this.f18783c) {
                    OpenHashSet<Disposable> openHashSet = this.f18782b;
                    if (openHashSet == null) {
                        openHashSet = new OpenHashSet<>();
                        this.f18782b = openHashSet;
                    }
                    openHashSet.add(disposable);
                    return true;
                }
            }
        }
        disposable.dispose();
        return false;
    }

    public boolean addAll(@NonNull Disposable... disposableArr) {
        Objects.requireNonNull(disposableArr, "disposables is null");
        if (!this.f18783c) {
            synchronized (this) {
                if (!this.f18783c) {
                    OpenHashSet<Disposable> openHashSet = this.f18782b;
                    if (openHashSet == null) {
                        openHashSet = new OpenHashSet<>(disposableArr.length + 1);
                        this.f18782b = openHashSet;
                    }
                    for (Disposable disposable : disposableArr) {
                        Objects.requireNonNull(disposable, "A Disposable in the disposables array is null");
                        openHashSet.add(disposable);
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
        if (!this.f18783c) {
            synchronized (this) {
                if (!this.f18783c) {
                    OpenHashSet<Disposable> openHashSet = this.f18782b;
                    this.f18782b = null;
                    a(openHashSet);
                }
            }
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:17:0x0021, code lost:
        return false;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean delete(@io.reactivex.rxjava3.annotations.NonNull io.reactivex.rxjava3.disposables.Disposable r3) {
        /*
            r2 = this;
            java.lang.String r0 = "disposable is null"
            java.util.Objects.requireNonNull(r3, r0)
            boolean r0 = r2.f18783c
            r1 = 0
            if (r0 == 0) goto L_0x000b
            return r1
        L_0x000b:
            monitor-enter(r2)
            boolean r0 = r2.f18783c     // Catch:{ all -> 0x0022 }
            if (r0 == 0) goto L_0x0012
            monitor-exit(r2)     // Catch:{ all -> 0x0022 }
            return r1
        L_0x0012:
            io.reactivex.rxjava3.internal.util.OpenHashSet<io.reactivex.rxjava3.disposables.Disposable> r0 = r2.f18782b     // Catch:{ all -> 0x0022 }
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
        throw new UnsupportedOperationException("Method not decompiled: io.reactivex.rxjava3.disposables.CompositeDisposable.delete(io.reactivex.rxjava3.disposables.Disposable):boolean");
    }

    public void dispose() {
        if (!this.f18783c) {
            synchronized (this) {
                if (!this.f18783c) {
                    this.f18783c = true;
                    OpenHashSet<Disposable> openHashSet = this.f18782b;
                    this.f18782b = null;
                    a(openHashSet);
                }
            }
        }
    }

    public boolean isDisposed() {
        return this.f18783c;
    }

    public boolean remove(@NonNull Disposable disposable) {
        if (!delete(disposable)) {
            return false;
        }
        disposable.dispose();
        return true;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:13:0x0016, code lost:
        return r1;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public int size() {
        /*
            r2 = this;
            boolean r0 = r2.f18783c
            r1 = 0
            if (r0 == 0) goto L_0x0006
            return r1
        L_0x0006:
            monitor-enter(r2)
            boolean r0 = r2.f18783c     // Catch:{ all -> 0x0017 }
            if (r0 == 0) goto L_0x000d
            monitor-exit(r2)     // Catch:{ all -> 0x0017 }
            return r1
        L_0x000d:
            io.reactivex.rxjava3.internal.util.OpenHashSet<io.reactivex.rxjava3.disposables.Disposable> r0 = r2.f18782b     // Catch:{ all -> 0x0017 }
            if (r0 == 0) goto L_0x0015
            int r1 = r0.size()     // Catch:{ all -> 0x0017 }
        L_0x0015:
            monitor-exit(r2)     // Catch:{ all -> 0x0017 }
            return r1
        L_0x0017:
            r0 = move-exception
            monitor-exit(r2)     // Catch:{ all -> 0x0017 }
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: io.reactivex.rxjava3.disposables.CompositeDisposable.size():int");
    }

    public CompositeDisposable(@NonNull Disposable... disposableArr) {
        Objects.requireNonNull(disposableArr, "disposables is null");
        this.f18782b = new OpenHashSet<>(disposableArr.length + 1);
        for (Disposable disposable : disposableArr) {
            Objects.requireNonNull(disposable, "A Disposable in the disposables array is null");
            this.f18782b.add(disposable);
        }
    }

    public CompositeDisposable(@NonNull Iterable<? extends Disposable> iterable) {
        Objects.requireNonNull(iterable, "disposables is null");
        this.f18782b = new OpenHashSet<>();
        for (Disposable disposable : iterable) {
            Objects.requireNonNull(disposable, "A Disposable item in the disposables sequence is null");
            this.f18782b.add(disposable);
        }
    }
}
