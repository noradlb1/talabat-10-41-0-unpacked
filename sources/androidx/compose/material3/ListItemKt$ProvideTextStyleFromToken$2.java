package androidx.compose.material3;

import androidx.compose.material3.tokens.TypographyKeyTokens;
import androidx.compose.runtime.Composer;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.Nullable;

@Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
public final class ListItemKt$ProvideTextStyleFromToken$2 extends Lambda implements Function2<Composer, Integer, Unit> {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ long f7289g;

    /* renamed from: h  reason: collision with root package name */
    public final /* synthetic */ TypographyKeyTokens f7290h;

    /* renamed from: i  reason: collision with root package name */
    public final /* synthetic */ Function2<Composer, Integer, Unit> f7291i;

    /* renamed from: j  reason: collision with root package name */
    public final /* synthetic */ int f7292j;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public ListItemKt$ProvideTextStyleFromToken$2(long j11, TypographyKeyTokens typographyKeyTokens, Function2<? super Composer, ? super Integer, Unit> function2, int i11) {
        super(2);
        this.f7289g = j11;
        this.f7290h = typographyKeyTokens;
        this.f7291i = function2;
        this.f7292j = i11;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
        invoke((Composer) obj, ((Number) obj2).intValue());
        return Unit.INSTANCE;
    }

    public final void invoke(@Nullable Composer composer, int i11) {
        ListItemKt.m1730ProvideTextStyleFromToken3JVO9M(this.f7289g, this.f7290h, this.f7291i, composer, this.f7292j | 1);
    }
}
