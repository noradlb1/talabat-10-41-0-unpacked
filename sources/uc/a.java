package uc;

import com.instabug.library.core.eventbus.eventpublisher.AbstractEventPublisher;
import com.instabug.library.core.eventbus.eventpublisher.Subscriber;
import com.instabug.library.core.eventbus.eventpublisher.Unsubscribable;

public final /* synthetic */ class a implements Unsubscribable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ AbstractEventPublisher f34732a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ Subscriber f34733b;

    public /* synthetic */ a(AbstractEventPublisher abstractEventPublisher, Subscriber subscriber) {
        this.f34732a = abstractEventPublisher;
        this.f34733b = subscriber;
    }

    public final void unsubscribe() {
        AbstractEventPublisher.m9023subscribe$lambda0(this.f34732a, this.f34733b);
    }
}
