package s00;

import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.reactive.PublishKt;
import org.reactivestreams.Publisher;
import org.reactivestreams.Subscriber;

public final /* synthetic */ class a implements Publisher {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ CoroutineScope f28177b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ CoroutineContext f28178c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ Function2 f28179d;

    /* renamed from: e  reason: collision with root package name */
    public final /* synthetic */ Function2 f28180e;

    public /* synthetic */ a(CoroutineScope coroutineScope, CoroutineContext coroutineContext, Function2 function2, Function2 function22) {
        this.f28177b = coroutineScope;
        this.f28178c = coroutineContext;
        this.f28179d = function2;
        this.f28180e = function22;
    }

    public final void subscribe(Subscriber subscriber) {
        PublishKt.m7853publishInternal$lambda1(this.f28177b, this.f28178c, this.f28179d, this.f28180e, subscriber);
    }
}
