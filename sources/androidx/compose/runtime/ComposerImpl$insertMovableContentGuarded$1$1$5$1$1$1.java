package androidx.compose.runtime;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", "invoke"}, k = 3, mv = {1, 7, 1}, xi = 48)
public final class ComposerImpl$insertMovableContentGuarded$1$1$5$1$1$1 extends Lambda implements Function0<Unit> {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ ComposerImpl f9074g;

    /* renamed from: h  reason: collision with root package name */
    public final /* synthetic */ MovableContentStateReference f9075h;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public ComposerImpl$insertMovableContentGuarded$1$1$5$1$1$1(ComposerImpl composerImpl, MovableContentStateReference movableContentStateReference) {
        super(0);
        this.f9074g = composerImpl;
        this.f9075h = movableContentStateReference;
    }

    public final void invoke() {
        this.f9074g.invokeMovableContentLambda(this.f9075h.getContent$runtime_release(), this.f9075h.getLocals$runtime_release(), this.f9075h.getParameter$runtime_release(), true);
    }
}
