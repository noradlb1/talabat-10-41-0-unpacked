package z2;

import coil.EventListener;
import coil.request.ImageRequest;

public final /* synthetic */ class b implements EventListener.Factory {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ EventListener f44451a;

    public /* synthetic */ b(EventListener eventListener) {
        this.f44451a = eventListener;
    }

    public final EventListener create(ImageRequest imageRequest) {
        return EventListener.Factory.Companion.m9131invoke$lambda0(this.f44451a, imageRequest);
    }
}
