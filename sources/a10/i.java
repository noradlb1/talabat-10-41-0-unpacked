package a10;

import androidx.lifecycle.MutableLiveData;
import io.reactivex.functions.Consumer;

public final /* synthetic */ class i implements Consumer {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ MutableLiveData f24275b;

    public /* synthetic */ i(MutableLiveData mutableLiveData) {
        this.f24275b = mutableLiveData;
    }

    public final void accept(Object obj) {
        this.f24275b.postValue((Boolean) obj);
    }
}
