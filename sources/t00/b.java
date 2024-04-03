package t00;

import io.reactivex.ObservableEmitter;
import io.reactivex.ObservableOnSubscribe;
import kotlin.coroutines.CoroutineContext;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.rx2.RxConvertKt;

public final /* synthetic */ class b implements ObservableOnSubscribe {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ CoroutineContext f28190a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ Flow f28191b;

    public /* synthetic */ b(CoroutineContext coroutineContext, Flow flow) {
        this.f28190a = coroutineContext;
        this.f28191b = flow;
    }

    public final void subscribe(ObservableEmitter observableEmitter) {
        RxConvertKt.m7856asObservable$lambda0(this.f28190a, this.f28191b, observableEmitter);
    }
}
