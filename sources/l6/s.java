package l6;

import android.os.Bundle;
import com.facebook.appevents.UserDataStore;

public final /* synthetic */ class s implements Runnable {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ Bundle f34553b;

    public /* synthetic */ s(Bundle bundle) {
        this.f34553b = bundle;
    }

    public final void run() {
        UserDataStore.m8897setUserDataAndHash$lambda1(this.f34553b);
    }
}
