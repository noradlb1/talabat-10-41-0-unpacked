package kotlin.collections;

import java.util.Iterator;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.ArrayIteratorsKt;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010(\n\u0002\u0010\t\n\u0000\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001H\n¢\u0006\u0002\b\u0003"}, d2 = {"<anonymous>", "", "", "invoke"}, k = 3, mv = {1, 7, 1}, xi = 48)
public final class ArraysKt___ArraysKt$withIndex$5 extends Lambda implements Function0<Iterator<? extends Long>> {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ long[] f23788g;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public ArraysKt___ArraysKt$withIndex$5(long[] jArr) {
        super(0);
        this.f23788g = jArr;
    }

    @NotNull
    public final Iterator<Long> invoke() {
        return ArrayIteratorsKt.iterator(this.f23788g);
    }
}
