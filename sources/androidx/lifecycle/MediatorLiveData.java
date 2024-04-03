package androidx.lifecycle;

import androidx.annotation.CallSuper;
import androidx.annotation.MainThread;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.arch.core.internal.SafeIterableMap;
import java.util.Iterator;
import java.util.Map;

public class MediatorLiveData<T> extends MutableLiveData<T> {
    private SafeIterableMap<LiveData<?>, Source<?>> mSources = new SafeIterableMap<>();

    public static class Source<V> implements Observer<V> {

        /* renamed from: a  reason: collision with root package name */
        public final LiveData<V> f36068a;

        /* renamed from: b  reason: collision with root package name */
        public final Observer<? super V> f36069b;

        /* renamed from: c  reason: collision with root package name */
        public int f36070c = -1;

        public Source(LiveData<V> liveData, Observer<? super V> observer) {
            this.f36068a = liveData;
            this.f36069b = observer;
        }

        public void a() {
            this.f36068a.observeForever(this);
        }

        public void b() {
            this.f36068a.removeObserver(this);
        }

        public void onChanged(@Nullable V v11) {
            if (this.f36070c != this.f36068a.d()) {
                this.f36070c = this.f36068a.d();
                this.f36069b.onChanged(v11);
            }
        }
    }

    @MainThread
    public <S> void addSource(@NonNull LiveData<S> liveData, @NonNull Observer<? super S> observer) {
        Source source = new Source(liveData, observer);
        Source putIfAbsent = this.mSources.putIfAbsent(liveData, source);
        if (putIfAbsent != null && putIfAbsent.f36069b != observer) {
            throw new IllegalArgumentException("This source was already added with the different observer");
        } else if (putIfAbsent == null && hasActiveObservers()) {
            source.a();
        }
    }

    @CallSuper
    public void e() {
        Iterator<Map.Entry<LiveData<?>, Source<?>>> it = this.mSources.iterator();
        while (it.hasNext()) {
            ((Source) it.next().getValue()).a();
        }
    }

    @CallSuper
    public void f() {
        Iterator<Map.Entry<LiveData<?>, Source<?>>> it = this.mSources.iterator();
        while (it.hasNext()) {
            ((Source) it.next().getValue()).b();
        }
    }

    @MainThread
    public <S> void removeSource(@NonNull LiveData<S> liveData) {
        Source remove = this.mSources.remove(liveData);
        if (remove != null) {
            remove.b();
        }
    }
}
