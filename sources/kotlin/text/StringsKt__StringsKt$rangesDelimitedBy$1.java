package kotlin.text;

import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\u0012\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\u0010\r\n\u0002\b\u0002\u0010\u0000\u001a\u0010\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u0001*\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0002H\n¢\u0006\u0002\b\u0005"}, d2 = {"<anonymous>", "Lkotlin/Pair;", "", "", "currentIndex", "invoke"}, k = 3, mv = {1, 7, 1}, xi = 48)
public final class StringsKt__StringsKt$rangesDelimitedBy$1 extends Lambda implements Function2<CharSequence, Integer, Pair<? extends Integer, ? extends Integer>> {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ char[] f25091g;

    /* renamed from: h  reason: collision with root package name */
    public final /* synthetic */ boolean f25092h;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public StringsKt__StringsKt$rangesDelimitedBy$1(char[] cArr, boolean z11) {
        super(2);
        this.f25091g = cArr;
        this.f25092h = z11;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
        return invoke((CharSequence) obj, ((Number) obj2).intValue());
    }

    @Nullable
    public final Pair<Integer, Integer> invoke(@NotNull CharSequence charSequence, int i11) {
        Intrinsics.checkNotNullParameter(charSequence, "$this$$receiver");
        int indexOfAny = StringsKt__StringsKt.indexOfAny(charSequence, this.f25091g, i11, this.f25092h);
        if (indexOfAny < 0) {
            return null;
        }
        return TuplesKt.to(Integer.valueOf(indexOfAny), 1);
    }
}
