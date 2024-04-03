package p005if;

import com.talabat.authentication.token.data.model.TokenData;
import io.reactivex.SingleEmitter;
import io.reactivex.functions.Consumer;

/* renamed from: if.e  reason: invalid package */
public final /* synthetic */ class e implements Consumer {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ SingleEmitter f56901b;

    public /* synthetic */ e(SingleEmitter singleEmitter) {
        this.f56901b = singleEmitter;
    }

    public final void accept(Object obj) {
        this.f56901b.onSuccess((TokenData.Valid) obj);
    }
}
