package t00;

import io.reactivex.SingleEmitter;
import io.reactivex.SingleOnSubscribe;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.rx2.RxSingleKt;

public final /* synthetic */ class f implements SingleOnSubscribe {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ CoroutineScope f28199a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ CoroutineContext f28200b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ Function2 f28201c;

    public /* synthetic */ f(CoroutineScope coroutineScope, CoroutineContext coroutineContext, Function2 function2) {
        this.f28199a = coroutineScope;
        this.f28200b = coroutineContext;
        this.f28201c = function2;
    }

    public final void subscribe(SingleEmitter singleEmitter) {
        RxSingleKt.m7861rxSingleInternal$lambda1(this.f28199a, this.f28200b, this.f28201c, singleEmitter);
    }
}
