package androidx.compose.runtime;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\u001a\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\n\u0010\u0002\u001a\u0006\u0012\u0002\b\u00030\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\n¢\u0006\u0002\b\b"}, d2 = {"<anonymous>", "", "<anonymous parameter 0>", "Landroidx/compose/runtime/Applier;", "slots", "Landroidx/compose/runtime/SlotWriter;", "rememberManager", "Landroidx/compose/runtime/RememberManager;", "invoke"}, k = 3, mv = {1, 7, 1}, xi = 48)
public final class ComposerImpl$updateValue$2 extends Lambda implements Function3<Applier<?>, SlotWriter, RememberManager, Unit> {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ Object f9102g;

    /* renamed from: h  reason: collision with root package name */
    public final /* synthetic */ int f9103h;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public ComposerImpl$updateValue$2(Object obj, int i11) {
        super(3);
        this.f9102g = obj;
        this.f9103h = i11;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2, Object obj3) {
        invoke((Applier<?>) (Applier) obj, (SlotWriter) obj2, (RememberManager) obj3);
        return Unit.INSTANCE;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:8:0x0030, code lost:
        r2 = (androidx.compose.runtime.RecomposeScopeImpl) r2;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void invoke(@org.jetbrains.annotations.NotNull androidx.compose.runtime.Applier<?> r2, @org.jetbrains.annotations.NotNull androidx.compose.runtime.SlotWriter r3, @org.jetbrains.annotations.NotNull androidx.compose.runtime.RememberManager r4) {
        /*
            r1 = this;
            java.lang.String r0 = "<anonymous parameter 0>"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r2, r0)
            java.lang.String r2 = "slots"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r3, r2)
            java.lang.String r2 = "rememberManager"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r4, r2)
            java.lang.Object r2 = r1.f9102g
            boolean r0 = r2 instanceof androidx.compose.runtime.RememberObserver
            if (r0 == 0) goto L_0x001a
            androidx.compose.runtime.RememberObserver r2 = (androidx.compose.runtime.RememberObserver) r2
            r4.remembering(r2)
        L_0x001a:
            int r2 = r1.f9103h
            java.lang.Object r0 = r1.f9102g
            java.lang.Object r2 = r3.set(r2, r0)
            boolean r3 = r2 instanceof androidx.compose.runtime.RememberObserver
            if (r3 == 0) goto L_0x002c
            androidx.compose.runtime.RememberObserver r2 = (androidx.compose.runtime.RememberObserver) r2
            r4.forgetting(r2)
            goto L_0x003f
        L_0x002c:
            boolean r3 = r2 instanceof androidx.compose.runtime.RecomposeScopeImpl
            if (r3 == 0) goto L_0x003f
            androidx.compose.runtime.RecomposeScopeImpl r2 = (androidx.compose.runtime.RecomposeScopeImpl) r2
            androidx.compose.runtime.CompositionImpl r3 = r2.getComposition()
            if (r3 == 0) goto L_0x003f
            r2.release()
            r2 = 1
            r3.setPendingInvalidScopes$runtime_release(r2)
        L_0x003f:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.runtime.ComposerImpl$updateValue$2.invoke(androidx.compose.runtime.Applier, androidx.compose.runtime.SlotWriter, androidx.compose.runtime.RememberManager):void");
    }
}
