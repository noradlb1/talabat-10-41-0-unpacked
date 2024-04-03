package androidx.compose.ui.node;

import androidx.compose.ui.Modifier;
import androidx.compose.ui.draw.DrawCacheModifier;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", "invoke"}, k = 3, mv = {1, 7, 1}, xi = 48)
public final class BackwardsCompatNode$updateDrawCache$1 extends Lambda implements Function0<Unit> {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ Modifier.Element f9908g;

    /* renamed from: h  reason: collision with root package name */
    public final /* synthetic */ BackwardsCompatNode f9909h;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public BackwardsCompatNode$updateDrawCache$1(Modifier.Element element, BackwardsCompatNode backwardsCompatNode) {
        super(0);
        this.f9908g = element;
        this.f9909h = backwardsCompatNode;
    }

    public final void invoke() {
        ((DrawCacheModifier) this.f9908g).onBuildCache(this.f9909h);
    }
}
