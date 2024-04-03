package ue;

import com.talabat.LoginScreen;
import io.reactivex.functions.Consumer;

public final /* synthetic */ class z9 implements Consumer {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ Consumer f57862b;

    public /* synthetic */ z9(Consumer consumer) {
        this.f57862b = consumer;
    }

    public final void accept(Object obj) {
        LoginScreen.lambda$checkIfUserIsAlreadyRegistered$9(this.f57862b, (Throwable) obj);
    }
}
