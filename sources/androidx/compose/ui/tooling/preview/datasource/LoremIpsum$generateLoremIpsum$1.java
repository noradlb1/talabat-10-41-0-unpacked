package androidx.compose.ui.tooling.preview.datasource;

import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.Ref;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u000e\n\u0000\u0010\u0000\u001a\u0004\u0018\u00010\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", "invoke"}, k = 3, mv = {1, 6, 0}, xi = 48)
public final class LoremIpsum$generateLoremIpsum$1 extends Lambda implements Function0<String> {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ Ref.IntRef f10283g;

    /* renamed from: h  reason: collision with root package name */
    public final /* synthetic */ int f10284h;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public LoremIpsum$generateLoremIpsum$1(Ref.IntRef intRef, int i11) {
        super(0);
        this.f10283g = intRef;
        this.f10284h = i11;
    }

    @Nullable
    public final String invoke() {
        List access$getLOREM_IPSUM_SOURCE$p = LoremIpsumKt.LOREM_IPSUM_SOURCE;
        Ref.IntRef intRef = this.f10283g;
        int i11 = intRef.element;
        intRef.element = i11 + 1;
        return (String) access$getLOREM_IPSUM_SOURCE$p.get(i11 % this.f10284h);
    }
}
