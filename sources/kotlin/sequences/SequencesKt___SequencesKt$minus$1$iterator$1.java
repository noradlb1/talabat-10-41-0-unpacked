package kotlin.sequences;

import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.Ref;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u00022\u0006\u0010\u0003\u001a\u0002H\u0002H\n¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"<anonymous>", "", "T", "it", "invoke", "(Ljava/lang/Object;)Ljava/lang/Boolean;"}, k = 3, mv = {1, 7, 1}, xi = 48)
public final class SequencesKt___SequencesKt$minus$1$iterator$1 extends Lambda implements Function1<T, Boolean> {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ Ref.BooleanRef f25019g;

    /* renamed from: h  reason: collision with root package name */
    public final /* synthetic */ T f25020h;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public SequencesKt___SequencesKt$minus$1$iterator$1(Ref.BooleanRef booleanRef, T t11) {
        super(1);
        this.f25019g = booleanRef;
        this.f25020h = t11;
    }

    @NotNull
    public final Boolean invoke(T t11) {
        boolean z11 = true;
        if (!this.f25019g.element && Intrinsics.areEqual((Object) t11, (Object) this.f25020h)) {
            this.f25019g.element = true;
            z11 = false;
        }
        return Boolean.valueOf(z11);
    }
}
