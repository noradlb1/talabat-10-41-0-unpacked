package l6;

import com.facebook.appevents.UserDataStore;

public final /* synthetic */ class u implements Runnable {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ String f34554b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ String f34555c;

    public /* synthetic */ u(String str, String str2) {
        this.f34554b = str;
        this.f34555c = str2;
    }

    public final void run() {
        UserDataStore.m8898writeDataIntoCache$lambda0(this.f34554b, this.f34555c);
    }
}
