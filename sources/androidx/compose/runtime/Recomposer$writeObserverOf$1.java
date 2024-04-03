package androidx.compose.runtime;

import androidx.compose.runtime.collection.IdentityArraySet;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "", "value", "", "invoke"}, k = 3, mv = {1, 7, 1}, xi = 48)
public final class Recomposer$writeObserverOf$1 extends Lambda implements Function1<Object, Unit> {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ ControlledComposition f9213g;

    /* renamed from: h  reason: collision with root package name */
    public final /* synthetic */ IdentityArraySet<Object> f9214h;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public Recomposer$writeObserverOf$1(ControlledComposition controlledComposition, IdentityArraySet<Object> identityArraySet) {
        super(1);
        this.f9213g = controlledComposition;
        this.f9214h = identityArraySet;
    }

    public final void invoke(@NotNull Object obj) {
        Intrinsics.checkNotNullParameter(obj, "value");
        this.f9213g.recordWriteOf(obj);
        IdentityArraySet<Object> identityArraySet = this.f9214h;
        if (identityArraySet != null) {
            identityArraySet.add(obj);
        }
    }
}
