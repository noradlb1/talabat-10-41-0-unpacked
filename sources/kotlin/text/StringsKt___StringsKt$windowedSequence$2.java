package kotlin.text;

import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\f\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\u0010\u0000\u001a\u0002H\u0001\"\u0004\b\u0000\u0010\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"<anonymous>", "R", "index", "", "invoke", "(I)Ljava/lang/Object;"}, k = 3, mv = {1, 7, 1}, xi = 48)
public final class StringsKt___StringsKt$windowedSequence$2 extends Lambda implements Function1<Integer, R> {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ int f25101g;

    /* renamed from: h  reason: collision with root package name */
    public final /* synthetic */ CharSequence f25102h;

    /* renamed from: i  reason: collision with root package name */
    public final /* synthetic */ Function1<CharSequence, R> f25103i;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public StringsKt___StringsKt$windowedSequence$2(int i11, CharSequence charSequence, Function1<? super CharSequence, ? extends R> function1) {
        super(1);
        this.f25101g = i11;
        this.f25102h = charSequence;
        this.f25103i = function1;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        return invoke(((Number) obj).intValue());
    }

    public final R invoke(int i11) {
        int i12 = this.f25101g + i11;
        if (i12 < 0 || i12 > this.f25102h.length()) {
            i12 = this.f25102h.length();
        }
        return this.f25103i.invoke(this.f25102h.subSequence(i11, i12));
    }
}
