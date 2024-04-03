package jf;

import com.talabat.authentication.token.data.model.TokenData;
import io.reactivex.SingleEmitter;
import io.reactivex.functions.Consumer;

public final /* synthetic */ class d implements Consumer {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ SingleEmitter f56921b;

    public /* synthetic */ d(SingleEmitter singleEmitter) {
        this.f56921b = singleEmitter;
    }

    public final void accept(Object obj) {
        this.f56921b.onSuccess((TokenData) obj);
    }
}
