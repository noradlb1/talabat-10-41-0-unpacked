package yg;

import com.talabat.core.google.login.data.dto.GoogleLoginDto;
import io.reactivex.SingleEmitter;
import io.reactivex.functions.Consumer;

public final /* synthetic */ class f implements Consumer {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ SingleEmitter f58020b;

    public /* synthetic */ f(SingleEmitter singleEmitter) {
        this.f58020b = singleEmitter;
    }

    public final void accept(Object obj) {
        this.f58020b.onSuccess((GoogleLoginDto) obj);
    }
}
