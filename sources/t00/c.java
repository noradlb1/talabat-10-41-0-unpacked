package t00;

import io.reactivex.MaybeEmitter;
import io.reactivex.MaybeOnSubscribe;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.rx2.RxMaybeKt;

public final /* synthetic */ class c implements MaybeOnSubscribe {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ CoroutineScope f28192a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ CoroutineContext f28193b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ Function2 f28194c;

    public /* synthetic */ c(CoroutineScope coroutineScope, CoroutineContext coroutineContext, Function2 function2) {
        this.f28192a = coroutineScope;
        this.f28193b = coroutineContext;
        this.f28194c = function2;
    }

    public final void subscribe(MaybeEmitter maybeEmitter) {
        RxMaybeKt.m7857rxMaybeInternal$lambda1(this.f28192a, this.f28193b, this.f28194c, maybeEmitter);
    }
}
