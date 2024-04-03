package androidx.compose.runtime.livedata;

import androidx.compose.runtime.MutableState;
import androidx.lifecycle.Observer;
import kotlin.Metadata;

@Metadata(k = 3, mv = {1, 5, 1}, xi = 48)
public final class LiveDataAdapterKt$observeAsState$1$observer$1<T> implements Observer {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ MutableState<R> f9485a;

    public LiveDataAdapterKt$observeAsState$1$observer$1(MutableState<R> mutableState) {
        this.f9485a = mutableState;
    }

    public final void onChanged(T t11) {
        this.f9485a.setValue(t11);
    }
}
