package kotlin.text;

import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u0004\u0018\u00010\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "Lkotlin/text/MatchResult;", "invoke"}, k = 3, mv = {1, 7, 1}, xi = 48)
public final class Regex$findAll$1 extends Lambda implements Function0<MatchResult> {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ Regex f25078g;

    /* renamed from: h  reason: collision with root package name */
    public final /* synthetic */ CharSequence f25079h;

    /* renamed from: i  reason: collision with root package name */
    public final /* synthetic */ int f25080i;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public Regex$findAll$1(Regex regex, CharSequence charSequence, int i11) {
        super(0);
        this.f25078g = regex;
        this.f25079h = charSequence;
        this.f25080i = i11;
    }

    @Nullable
    public final MatchResult invoke() {
        return this.f25078g.find(this.f25079h, this.f25080i);
    }
}
