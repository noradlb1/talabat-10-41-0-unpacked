package androidx.compose.runtime.internal;

import androidx.compose.runtime.Composer;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.SpreadBuilder;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u0014\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\n¢\u0006\u0002\b\u0006"}, d2 = {"<anonymous>", "", "nc", "Landroidx/compose/runtime/Composer;", "<anonymous parameter 1>", "", "invoke"}, k = 3, mv = {1, 7, 1}, xi = 48)
public final class ComposableLambdaNImpl$invoke$1 extends Lambda implements Function2<Composer, Integer, Unit> {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ Object[] f9477g;

    /* renamed from: h  reason: collision with root package name */
    public final /* synthetic */ int f9478h;

    /* renamed from: i  reason: collision with root package name */
    public final /* synthetic */ ComposableLambdaNImpl f9479i;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public ComposableLambdaNImpl$invoke$1(Object[] objArr, int i11, ComposableLambdaNImpl composableLambdaNImpl) {
        super(2);
        this.f9477g = objArr;
        this.f9478h = i11;
        this.f9479i = composableLambdaNImpl;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
        invoke((Composer) obj, ((Number) obj2).intValue());
        return Unit.INSTANCE;
    }

    public final void invoke(@NotNull Composer composer, int i11) {
        Intrinsics.checkNotNullParameter(composer, "nc");
        Object[] array = ArraysKt___ArraysKt.slice((T[]) this.f9477g, RangesKt___RangesKt.until(0, this.f9478h)).toArray(new Object[0]);
        Intrinsics.checkNotNull(array, "null cannot be cast to non-null type kotlin.Array<T of kotlin.collections.ArraysKt__ArraysJVMKt.toTypedArray>");
        Object obj = this.f9477g[this.f9478h + 1];
        Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlin.Int");
        int intValue = ((Integer) obj).intValue();
        Object[] objArr = this.f9477g;
        Object[] array2 = ArraysKt___ArraysKt.slice((T[]) objArr, RangesKt___RangesKt.until(this.f9478h + 2, objArr.length)).toArray(new Object[0]);
        Intrinsics.checkNotNull(array2, "null cannot be cast to non-null type kotlin.Array<T of kotlin.collections.ArraysKt__ArraysJVMKt.toTypedArray>");
        ComposableLambdaNImpl composableLambdaNImpl = this.f9479i;
        SpreadBuilder spreadBuilder = new SpreadBuilder(4);
        spreadBuilder.addSpread(array);
        spreadBuilder.add(composer);
        spreadBuilder.add(Integer.valueOf(intValue | 1));
        spreadBuilder.addSpread(array2);
        composableLambdaNImpl.invoke(spreadBuilder.toArray(new Object[spreadBuilder.size()]));
    }
}
