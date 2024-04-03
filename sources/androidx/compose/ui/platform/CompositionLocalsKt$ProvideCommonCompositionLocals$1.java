package androidx.compose.ui.platform;

import androidx.compose.runtime.Composer;
import androidx.compose.ui.node.Owner;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.Nullable;

@Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
public final class CompositionLocalsKt$ProvideCommonCompositionLocals$1 extends Lambda implements Function2<Composer, Integer, Unit> {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ Owner f10026g;

    /* renamed from: h  reason: collision with root package name */
    public final /* synthetic */ UriHandler f10027h;

    /* renamed from: i  reason: collision with root package name */
    public final /* synthetic */ Function2<Composer, Integer, Unit> f10028i;

    /* renamed from: j  reason: collision with root package name */
    public final /* synthetic */ int f10029j;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public CompositionLocalsKt$ProvideCommonCompositionLocals$1(Owner owner, UriHandler uriHandler, Function2<? super Composer, ? super Integer, Unit> function2, int i11) {
        super(2);
        this.f10026g = owner;
        this.f10027h = uriHandler;
        this.f10028i = function2;
        this.f10029j = i11;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
        invoke((Composer) obj, ((Number) obj2).intValue());
        return Unit.INSTANCE;
    }

    public final void invoke(@Nullable Composer composer, int i11) {
        CompositionLocalsKt.ProvideCommonCompositionLocals(this.f10026g, this.f10027h, this.f10028i, composer, this.f10029j | 1);
    }
}
