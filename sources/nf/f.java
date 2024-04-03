package nf;

import com.talabat.authentication.token.domain.model.Token;
import io.reactivex.SingleEmitter;
import io.reactivex.functions.Consumer;

public final /* synthetic */ class f implements Consumer {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ SingleEmitter f57061b;

    public /* synthetic */ f(SingleEmitter singleEmitter) {
        this.f57061b = singleEmitter;
    }

    public final void accept(Object obj) {
        this.f57061b.onSuccess((Token) obj);
    }
}
