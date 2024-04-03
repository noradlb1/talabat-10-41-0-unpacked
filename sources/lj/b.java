package lj;

import androidx.lifecycle.MutableLiveData;
import io.reactivex.functions.Consumer;
import kotlin.Pair;

public final /* synthetic */ class b implements Consumer {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ MutableLiveData f57010b;

    public /* synthetic */ b(MutableLiveData mutableLiveData) {
        this.f57010b = mutableLiveData;
    }

    public final void accept(Object obj) {
        this.f57010b.postValue((Pair) obj);
    }
}
