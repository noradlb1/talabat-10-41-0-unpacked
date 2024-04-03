package androidx.compose.runtime;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.TypeIntrinsics;

@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", "invoke"}, k = 3, mv = {1, 7, 1}, xi = 48)
public final class ComposerImpl$doCompose$2$5 extends Lambda implements Function0<Unit> {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ Function2<Composer, Integer, Unit> f9055g;

    /* renamed from: h  reason: collision with root package name */
    public final /* synthetic */ ComposerImpl f9056h;

    /* renamed from: i  reason: collision with root package name */
    public final /* synthetic */ Object f9057i;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public ComposerImpl$doCompose$2$5(Function2<? super Composer, ? super Integer, Unit> function2, ComposerImpl composerImpl, Object obj) {
        super(0);
        this.f9055g = function2;
        this.f9056h = composerImpl;
        this.f9057i = obj;
    }

    public final void invoke() {
        Object obj;
        if (this.f9055g != null) {
            this.f9056h.startGroup(200, ComposerKt.getInvocation());
            ActualJvm_jvmKt.invokeComposable(this.f9056h, this.f9055g);
            this.f9056h.endGroup();
        } else if (!this.f9056h.forciblyRecompose || (obj = this.f9057i) == null || Intrinsics.areEqual(obj, Composer.Companion.getEmpty())) {
            this.f9056h.skipCurrentGroup();
        } else {
            this.f9056h.startGroup(200, ComposerKt.getInvocation());
            ComposerImpl composerImpl = this.f9056h;
            Object obj2 = this.f9057i;
            Intrinsics.checkNotNull(obj2, "null cannot be cast to non-null type kotlin.Function2<androidx.compose.runtime.Composer, kotlin.Int, kotlin.Unit>");
            ActualJvm_jvmKt.invokeComposable(composerImpl, (Function2) TypeIntrinsics.beforeCheckcastToFunctionOfArity(obj2, 2));
            this.f9056h.endGroup();
        }
    }
}
