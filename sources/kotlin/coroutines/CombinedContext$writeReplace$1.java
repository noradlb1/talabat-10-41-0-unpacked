package kotlin.coroutines;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.Ref;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u0012\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00012\u0006\u0010\u0003\u001a\u00020\u0004H\n¢\u0006\u0004\b\u0005\u0010\u0006"}, d2 = {"<anonymous>", "", "<anonymous parameter 0>", "element", "Lkotlin/coroutines/CoroutineContext$Element;", "invoke", "(Lkotlin/Unit;Lkotlin/coroutines/CoroutineContext$Element;)V"}, k = 3, mv = {1, 7, 1}, xi = 48)
public final class CombinedContext$writeReplace$1 extends Lambda implements Function2<Unit, CoroutineContext.Element, Unit> {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ CoroutineContext[] f23852g;

    /* renamed from: h  reason: collision with root package name */
    public final /* synthetic */ Ref.IntRef f23853h;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public CombinedContext$writeReplace$1(CoroutineContext[] coroutineContextArr, Ref.IntRef intRef) {
        super(2);
        this.f23852g = coroutineContextArr;
        this.f23853h = intRef;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
        invoke((Unit) obj, (CoroutineContext.Element) obj2);
        return Unit.INSTANCE;
    }

    public final void invoke(@NotNull Unit unit, @NotNull CoroutineContext.Element element) {
        Intrinsics.checkNotNullParameter(unit, "<anonymous parameter 0>");
        Intrinsics.checkNotNullParameter(element, "element");
        CoroutineContext[] coroutineContextArr = this.f23852g;
        Ref.IntRef intRef = this.f23853h;
        int i11 = intRef.element;
        intRef.element = i11 + 1;
        coroutineContextArr[i11] = element;
    }
}
