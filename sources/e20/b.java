package e20;

import okhttp3.Call;
import okhttp3.EventListener;
import okhttp3.internal.Util;

public final /* synthetic */ class b implements EventListener.Factory {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ EventListener f24323a;

    public /* synthetic */ b(EventListener eventListener) {
        this.f24323a = eventListener;
    }

    public final EventListener create(Call call) {
        return Util.m8048asFactory$lambda8(this.f24323a, call);
    }
}
