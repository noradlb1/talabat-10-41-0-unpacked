package androidx.compose.runtime;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.Nullable;

@Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
public final class CompositionLocalKt$CompositionLocalProvider$3 extends Lambda implements Function2<Composer, Integer, Unit> {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ CompositionLocalContext f9107g;

    /* renamed from: h  reason: collision with root package name */
    public final /* synthetic */ Function2<Composer, Integer, Unit> f9108h;

    /* renamed from: i  reason: collision with root package name */
    public final /* synthetic */ int f9109i;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public CompositionLocalKt$CompositionLocalProvider$3(CompositionLocalContext compositionLocalContext, Function2<? super Composer, ? super Integer, Unit> function2, int i11) {
        super(2);
        this.f9107g = compositionLocalContext;
        this.f9108h = function2;
        this.f9109i = i11;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
        invoke((Composer) obj, ((Number) obj2).intValue());
        return Unit.INSTANCE;
    }

    public final void invoke(@Nullable Composer composer, int i11) {
        CompositionLocalKt.CompositionLocalProvider(this.f9107g, (Function2<? super Composer, ? super Integer, Unit>) this.f9108h, composer, this.f9109i | 1);
    }
}
