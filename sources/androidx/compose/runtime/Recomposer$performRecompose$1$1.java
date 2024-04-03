package androidx.compose.runtime;

import androidx.compose.runtime.collection.IdentityArraySet;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", "invoke"}, k = 3, mv = {1, 7, 1}, xi = 48)
public final class Recomposer$performRecompose$1$1 extends Lambda implements Function0<Unit> {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ IdentityArraySet<Object> f9163g;

    /* renamed from: h  reason: collision with root package name */
    public final /* synthetic */ ControlledComposition f9164h;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public Recomposer$performRecompose$1$1(IdentityArraySet<Object> identityArraySet, ControlledComposition controlledComposition) {
        super(0);
        this.f9163g = identityArraySet;
        this.f9164h = controlledComposition;
    }

    public final void invoke() {
        IdentityArraySet<Object> identityArraySet = this.f9163g;
        ControlledComposition controlledComposition = this.f9164h;
        int size = identityArraySet.size();
        for (int i11 = 0; i11 < size; i11++) {
            controlledComposition.recordWriteOf(identityArraySet.get(i11));
        }
    }
}
