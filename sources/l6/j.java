package l6;

import android.content.Context;
import com.facebook.appevents.AppEventsLoggerImpl;

public final /* synthetic */ class j implements Runnable {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ Context f34551b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ AppEventsLoggerImpl f34552c;

    public /* synthetic */ j(Context context, AppEventsLoggerImpl appEventsLoggerImpl) {
        this.f34551b = context;
        this.f34552c = appEventsLoggerImpl;
    }

    public final void run() {
        AppEventsLoggerImpl.Companion.m8886initializeLib$lambda4(this.f34551b, this.f34552c);
    }
}
