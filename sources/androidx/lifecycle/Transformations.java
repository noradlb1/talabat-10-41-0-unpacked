package androidx.lifecycle;

import androidx.annotation.MainThread;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.arch.core.util.Function;

public class Transformations {
    private Transformations() {
    }

    @MainThread
    @NonNull
    public static <X> LiveData<X> distinctUntilChanged(@NonNull LiveData<X> liveData) {
        final MediatorLiveData mediatorLiveData = new MediatorLiveData();
        mediatorLiveData.addSource(liveData, new Observer<X>() {

            /* renamed from: a  reason: collision with root package name */
            public boolean f36117a = true;

            public void onChanged(X x11) {
                Object value = MediatorLiveData.this.getValue();
                if (this.f36117a || ((value == null && x11 != null) || (value != null && !value.equals(x11)))) {
                    this.f36117a = false;
                    MediatorLiveData.this.setValue(x11);
                }
            }
        });
        return mediatorLiveData;
    }

    @MainThread
    @NonNull
    public static <X, Y> LiveData<Y> map(@NonNull LiveData<X> liveData, @NonNull final Function<X, Y> function) {
        final MediatorLiveData mediatorLiveData = new MediatorLiveData();
        mediatorLiveData.addSource(liveData, new Observer<X>() {
            public void onChanged(@Nullable X x11) {
                MediatorLiveData.this.setValue(function.apply(x11));
            }
        });
        return mediatorLiveData;
    }

    @MainThread
    @NonNull
    public static <X, Y> LiveData<Y> switchMap(@NonNull LiveData<X> liveData, @NonNull final Function<X, LiveData<Y>> function) {
        final MediatorLiveData mediatorLiveData = new MediatorLiveData();
        mediatorLiveData.addSource(liveData, new Observer<X>() {

            /* renamed from: a  reason: collision with root package name */
            public LiveData<Y> f36113a;

            public void onChanged(@Nullable X x11) {
                LiveData<Y> liveData = (LiveData) Function.this.apply(x11);
                LiveData<Y> liveData2 = this.f36113a;
                if (liveData2 != liveData) {
                    if (liveData2 != null) {
                        mediatorLiveData.removeSource(liveData2);
                    }
                    this.f36113a = liveData;
                    if (liveData != null) {
                        mediatorLiveData.addSource(liveData, new Observer<Y>() {
                            public void onChanged(@Nullable Y y11) {
                                mediatorLiveData.setValue(y11);
                            }
                        });
                    }
                }
            }
        });
        return mediatorLiveData;
    }
}
