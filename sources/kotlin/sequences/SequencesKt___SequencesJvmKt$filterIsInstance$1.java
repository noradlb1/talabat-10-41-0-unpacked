package kotlin.sequences;

import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\u0012\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u00022\b\u0010\u0003\u001a\u0004\u0018\u00010\u0004H\n¢\u0006\u0004\b\u0005\u0010\u0006"}, d2 = {"<anonymous>", "", "R", "it", "", "invoke", "(Ljava/lang/Object;)Ljava/lang/Boolean;"}, k = 3, mv = {1, 7, 1}, xi = 48)
public final class SequencesKt___SequencesJvmKt$filterIsInstance$1 extends Lambda implements Function1<Object, Boolean> {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ Class<R> f25011g;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public SequencesKt___SequencesJvmKt$filterIsInstance$1(Class<R> cls) {
        super(1);
        this.f25011g = cls;
    }

    @NotNull
    public final Boolean invoke(@Nullable Object obj) {
        return Boolean.valueOf(this.f25011g.isInstance(obj));
    }
}
