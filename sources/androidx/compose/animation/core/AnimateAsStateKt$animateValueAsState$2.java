package androidx.compose.animation.core;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;
import kotlinx.coroutines.channels.Channel;

@Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
public final class AnimateAsStateKt$animateValueAsState$2 extends Lambda implements Function0<Unit> {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ Channel<T> f1296g;

    /* renamed from: h  reason: collision with root package name */
    public final /* synthetic */ T f1297h;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public AnimateAsStateKt$animateValueAsState$2(Channel<T> channel, T t11) {
        super(0);
        this.f1296g = channel;
        this.f1297h = t11;
    }

    public final void invoke() {
        this.f1296g.m7820trySendJP2dKIU(this.f1297h);
    }
}
