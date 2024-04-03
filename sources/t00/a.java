package t00;

import io.reactivex.CompletableEmitter;
import io.reactivex.CompletableOnSubscribe;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.rx2.RxCompletableKt;

public final /* synthetic */ class a implements CompletableOnSubscribe {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ CoroutineScope f28187a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ CoroutineContext f28188b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ Function2 f28189c;

    public /* synthetic */ a(CoroutineScope coroutineScope, CoroutineContext coroutineContext, Function2 function2) {
        this.f28187a = coroutineScope;
        this.f28188b = coroutineContext;
        this.f28189c = function2;
    }

    public final void subscribe(CompletableEmitter completableEmitter) {
        RxCompletableKt.m7855rxCompletableInternal$lambda1(this.f28187a, this.f28188b, this.f28189c, completableEmitter);
    }
}
