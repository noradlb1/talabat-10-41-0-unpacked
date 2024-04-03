package t00;

import io.reactivex.ObservableEmitter;
import io.reactivex.ObservableOnSubscribe;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.rx2.RxObservableKt;

public final /* synthetic */ class d implements ObservableOnSubscribe {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ CoroutineScope f28195a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ CoroutineContext f28196b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ Function2 f28197c;

    public /* synthetic */ d(CoroutineScope coroutineScope, CoroutineContext coroutineContext, Function2 function2) {
        this.f28195a = coroutineScope;
        this.f28196b = coroutineContext;
        this.f28197c = function2;
    }

    public final void subscribe(ObservableEmitter observableEmitter) {
        RxObservableKt.m7859rxObservableInternal$lambda1(this.f28195a, this.f28196b, this.f28197c, observableEmitter);
    }
}
