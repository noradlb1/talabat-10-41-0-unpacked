package androidx.compose.runtime;

import androidx.compose.runtime.collection.IdentityArrayIntMap;
import androidx.compose.runtime.collection.IdentityArrayMap;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "", "composition", "Landroidx/compose/runtime/Composition;", "invoke"}, k = 3, mv = {1, 7, 1}, xi = 48)
public final class RecomposeScopeImpl$end$1$2 extends Lambda implements Function1<Composition, Unit> {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ RecomposeScopeImpl f9151g;

    /* renamed from: h  reason: collision with root package name */
    public final /* synthetic */ int f9152h;

    /* renamed from: i  reason: collision with root package name */
    public final /* synthetic */ IdentityArrayIntMap f9153i;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public RecomposeScopeImpl$end$1$2(RecomposeScopeImpl recomposeScopeImpl, int i11, IdentityArrayIntMap identityArrayIntMap) {
        super(1);
        this.f9151g = recomposeScopeImpl;
        this.f9152h = i11;
        this.f9153i = identityArrayIntMap;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((Composition) obj);
        return Unit.INSTANCE;
    }

    public final void invoke(@NotNull Composition composition) {
        Intrinsics.checkNotNullParameter(composition, "composition");
        if (this.f9151g.currentToken == this.f9152h && Intrinsics.areEqual((Object) this.f9153i, (Object) this.f9151g.trackedInstances) && (composition instanceof CompositionImpl)) {
            IdentityArrayIntMap identityArrayIntMap = this.f9153i;
            int i11 = this.f9152h;
            RecomposeScopeImpl recomposeScopeImpl = this.f9151g;
            int size = identityArrayIntMap.getSize();
            int i12 = 0;
            for (int i13 = 0; i13 < size; i13++) {
                Object obj = identityArrayIntMap.getKeys()[i13];
                Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlin.Any");
                int i14 = identityArrayIntMap.getValues()[i13];
                boolean z11 = i14 != i11;
                if (z11) {
                    CompositionImpl compositionImpl = (CompositionImpl) composition;
                    compositionImpl.removeObservation$runtime_release(obj, recomposeScopeImpl);
                    DerivedState derivedState = obj instanceof DerivedState ? (DerivedState) obj : null;
                    if (derivedState != null) {
                        compositionImpl.removeDerivedStateObservation$runtime_release(derivedState);
                        IdentityArrayMap access$getTrackedDependencies$p = recomposeScopeImpl.trackedDependencies;
                        if (access$getTrackedDependencies$p != null) {
                            access$getTrackedDependencies$p.remove(derivedState);
                            if (access$getTrackedDependencies$p.getSize$runtime_release() == 0) {
                                recomposeScopeImpl.trackedDependencies = null;
                            }
                        }
                    }
                }
                if (!z11) {
                    if (i12 != i13) {
                        identityArrayIntMap.getKeys()[i12] = obj;
                        identityArrayIntMap.getValues()[i12] = i14;
                    }
                    i12++;
                }
            }
            int size2 = identityArrayIntMap.getSize();
            for (int i15 = i12; i15 < size2; i15++) {
                identityArrayIntMap.getKeys()[i15] = null;
            }
            identityArrayIntMap.setSize(i12);
            if (this.f9153i.getSize() == 0) {
                this.f9151g.trackedInstances = null;
            }
        }
    }
}
