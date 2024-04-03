package androidx.compose.runtime;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\n\u0010\u0002\u001a\u0006\u0012\u0002\b\u00030\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "", "it", "Landroidx/compose/runtime/State;", "invoke"}, k = 3, mv = {1, 7, 1}, xi = 48)
public final class ComposerImpl$doCompose$2$3 extends Lambda implements Function1<State<?>, Unit> {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ ComposerImpl f9053g;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public ComposerImpl$doCompose$2$3(ComposerImpl composerImpl) {
        super(1);
        this.f9053g = composerImpl;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((State<?>) (State) obj);
        return Unit.INSTANCE;
    }

    public final void invoke(@NotNull State<?> state) {
        Intrinsics.checkNotNullParameter(state, "it");
        ComposerImpl composerImpl = this.f9053g;
        composerImpl.childrenComposing = composerImpl.childrenComposing + 1;
    }
}
