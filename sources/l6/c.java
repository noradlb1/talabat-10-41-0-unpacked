package l6;

import com.facebook.appevents.AccessTokenAppIdPair;
import com.facebook.appevents.AppEventQueue;
import com.facebook.appevents.SessionEventsState;

public final /* synthetic */ class c implements Runnable {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ AccessTokenAppIdPair f34542b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ SessionEventsState f34543c;

    public /* synthetic */ c(AccessTokenAppIdPair accessTokenAppIdPair, SessionEventsState sessionEventsState) {
        this.f34542b = accessTokenAppIdPair;
        this.f34543c = sessionEventsState;
    }

    public final void run() {
        AppEventQueue.m8884handleResponse$lambda5(this.f34542b, this.f34543c);
    }
}
