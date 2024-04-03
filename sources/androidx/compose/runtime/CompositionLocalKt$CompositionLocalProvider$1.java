package androidx.compose.runtime;

import java.util.Arrays;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.Nullable;

@Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
public final class CompositionLocalKt$CompositionLocalProvider$1 extends Lambda implements Function2<Composer, Integer, Unit> {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ ProvidedValue<?>[] f9104g;

    /* renamed from: h  reason: collision with root package name */
    public final /* synthetic */ Function2<Composer, Integer, Unit> f9105h;

    /* renamed from: i  reason: collision with root package name */
    public final /* synthetic */ int f9106i;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public CompositionLocalKt$CompositionLocalProvider$1(ProvidedValue<?>[] providedValueArr, Function2<? super Composer, ? super Integer, Unit> function2, int i11) {
        super(2);
        this.f9104g = providedValueArr;
        this.f9105h = function2;
        this.f9106i = i11;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
        invoke((Composer) obj, ((Number) obj2).intValue());
        return Unit.INSTANCE;
    }

    public final void invoke(@Nullable Composer composer, int i11) {
        ProvidedValue<?>[] providedValueArr = this.f9104g;
        CompositionLocalKt.CompositionLocalProvider((ProvidedValue<?>[]) (ProvidedValue[]) Arrays.copyOf(providedValueArr, providedValueArr.length), (Function2<? super Composer, ? super Integer, Unit>) this.f9105h, composer, this.f9106i | 1);
    }
}
