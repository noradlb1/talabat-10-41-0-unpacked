package androidx.compose.runtime;

import androidx.compose.runtime.collection.IdentityArrayIntMap;
import androidx.compose.runtime.collection.IdentityArrayMap;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000j\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\b\u0000\u0018\u00002\u00020\u00012\u00020\u0002B\u000f\u0012\b\u0010\u0003\u001a\u0004\u0018\u00010\u0004¢\u0006\u0002\u0010\u0005J\u000e\u00107\u001a\u00020\u00102\u0006\u0010\u0003\u001a\u00020\u0004J\u000e\u00108\u001a\u00020\u00102\u0006\u00109\u001a\u00020\u000eJ\u001c\u0010:\u001a\u0010\u0012\u0004\u0012\u00020<\u0012\u0004\u0012\u00020\u0010\u0018\u00010;2\u0006\u0010=\u001a\u00020\u000fJ\b\u0010>\u001a\u00020\u0010H\u0016J\u0010\u0010?\u001a\u00020@2\b\u0010\u0019\u001a\u0004\u0018\u00010/J\u0016\u0010A\u001a\u00020\u00122\u000e\u0010B\u001a\n\u0012\u0004\u0012\u00020/\u0018\u00010CJ\u000e\u0010D\u001a\u00020\u00102\u0006\u0010E\u001a\u00020/J\u0006\u0010F\u001a\u00020\u0010J\u0006\u0010G\u001a\u00020\u0010J\u0006\u0010H\u001a\u00020\u0010J\u000e\u0010I\u001a\u00020\u00102\u0006\u0010=\u001a\u00020\u000fJ\"\u0010J\u001a\u00020\u00102\u0018\u0010\f\u001a\u0014\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020\u00100\rH\u0016R\u001c\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bR\"\u0010\f\u001a\u0016\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020\u0010\u0018\u00010\rX\u000e¢\u0006\u0002\n\u0000R\u0011\u0010\u0011\u001a\u00020\u00128F¢\u0006\u0006\u001a\u0004\b\u0013\u0010\u0014R\"\u0010\u0003\u001a\u0004\u0018\u00010\u00042\b\u0010\u0015\u001a\u0004\u0018\u00010\u0004@BX\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0017R\u000e\u0010\u0018\u001a\u00020\u000fX\u000e¢\u0006\u0002\n\u0000R$\u0010\u001a\u001a\u00020\u00122\u0006\u0010\u0019\u001a\u00020\u00128F@FX\u000e¢\u0006\f\u001a\u0004\b\u001b\u0010\u0014\"\u0004\b\u001c\u0010\u001dR$\u0010\u001e\u001a\u00020\u00122\u0006\u0010\u0019\u001a\u00020\u00128F@FX\u000e¢\u0006\f\u001a\u0004\b\u001f\u0010\u0014\"\u0004\b \u0010\u001dR\u000e\u0010!\u001a\u00020\u000fX\u000e¢\u0006\u0002\n\u0000R\u0011\u0010\"\u001a\u00020\u00128F¢\u0006\u0006\u001a\u0004\b\"\u0010\u0014R$\u0010#\u001a\u00020\u00122\u0006\u0010\u0019\u001a\u00020\u00128F@FX\u000e¢\u0006\f\u001a\u0004\b$\u0010\u0014\"\u0004\b%\u0010\u001dR$\u0010&\u001a\u00020\u00122\u0006\u0010\u0019\u001a\u00020\u00128B@BX\u000e¢\u0006\f\u001a\u0004\b'\u0010\u0014\"\u0004\b(\u0010\u001dR$\u0010)\u001a\u00020\u00122\u0006\u0010\u0019\u001a\u00020\u00128@@BX\u000e¢\u0006\f\u001a\u0004\b*\u0010\u0014\"\u0004\b+\u0010\u001dR\"\u0010,\u001a\u0016\u0012\b\u0012\u0006\u0012\u0002\b\u00030.\u0012\u0006\u0012\u0004\u0018\u00010/\u0018\u00010-X\u000e¢\u0006\u0002\n\u0000R\u0010\u00100\u001a\u0004\u0018\u000101X\u000e¢\u0006\u0002\n\u0000R$\u00102\u001a\u00020\u00122\u0006\u0010\u0019\u001a\u00020\u00128F@FX\u000e¢\u0006\f\u001a\u0004\b3\u0010\u0014\"\u0004\b4\u0010\u001dR\u0011\u00105\u001a\u00020\u00128F¢\u0006\u0006\u001a\u0004\b6\u0010\u0014¨\u0006K"}, d2 = {"Landroidx/compose/runtime/RecomposeScopeImpl;", "Landroidx/compose/runtime/ScopeUpdateScope;", "Landroidx/compose/runtime/RecomposeScope;", "composition", "Landroidx/compose/runtime/CompositionImpl;", "(Landroidx/compose/runtime/CompositionImpl;)V", "anchor", "Landroidx/compose/runtime/Anchor;", "getAnchor", "()Landroidx/compose/runtime/Anchor;", "setAnchor", "(Landroidx/compose/runtime/Anchor;)V", "block", "Lkotlin/Function2;", "Landroidx/compose/runtime/Composer;", "", "", "canRecompose", "", "getCanRecompose", "()Z", "<set-?>", "getComposition", "()Landroidx/compose/runtime/CompositionImpl;", "currentToken", "value", "defaultsInScope", "getDefaultsInScope", "setDefaultsInScope", "(Z)V", "defaultsInvalid", "getDefaultsInvalid", "setDefaultsInvalid", "flags", "isConditional", "requiresRecompose", "getRequiresRecompose", "setRequiresRecompose", "rereading", "getRereading", "setRereading", "skipped", "getSkipped$runtime_release", "setSkipped", "trackedDependencies", "Landroidx/compose/runtime/collection/IdentityArrayMap;", "Landroidx/compose/runtime/DerivedState;", "", "trackedInstances", "Landroidx/compose/runtime/collection/IdentityArrayIntMap;", "used", "getUsed", "setUsed", "valid", "getValid", "adoptedBy", "compose", "composer", "end", "Lkotlin/Function1;", "Landroidx/compose/runtime/Composition;", "token", "invalidate", "invalidateForResult", "Landroidx/compose/runtime/InvalidationResult;", "isInvalidFor", "instances", "Landroidx/compose/runtime/collection/IdentityArraySet;", "recordRead", "instance", "release", "rereadTrackedInstances", "scopeSkipped", "start", "updateScope", "runtime_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class RecomposeScopeImpl implements ScopeUpdateScope, RecomposeScope {
    @Nullable
    private Anchor anchor;
    @Nullable
    private Function2<? super Composer, ? super Integer, Unit> block;
    @Nullable
    private CompositionImpl composition;
    /* access modifiers changed from: private */
    public int currentToken;
    private int flags;
    /* access modifiers changed from: private */
    @Nullable
    public IdentityArrayMap<DerivedState<?>, Object> trackedDependencies;
    /* access modifiers changed from: private */
    @Nullable
    public IdentityArrayIntMap trackedInstances;

    public RecomposeScopeImpl(@Nullable CompositionImpl compositionImpl) {
        this.composition = compositionImpl;
    }

    private final boolean getRereading() {
        return (this.flags & 32) != 0;
    }

    private final void setRereading(boolean z11) {
        if (z11) {
            this.flags |= 32;
        } else {
            this.flags &= -33;
        }
    }

    private final void setSkipped(boolean z11) {
        if (z11) {
            this.flags |= 16;
        } else {
            this.flags &= -17;
        }
    }

    public final void adoptedBy(@NotNull CompositionImpl compositionImpl) {
        Intrinsics.checkNotNullParameter(compositionImpl, "composition");
        this.composition = compositionImpl;
    }

    public final void compose(@NotNull Composer composer) {
        Unit unit;
        Intrinsics.checkNotNullParameter(composer, "composer");
        Function2<? super Composer, ? super Integer, Unit> function2 = this.block;
        if (function2 != null) {
            function2.invoke(composer, 1);
            unit = Unit.INSTANCE;
        } else {
            unit = null;
        }
        if (unit == null) {
            throw new IllegalStateException("Invalid restart scope".toString());
        }
    }

    @Nullable
    public final Function1<Composition, Unit> end(int i11) {
        boolean z11;
        IdentityArrayIntMap identityArrayIntMap = this.trackedInstances;
        if (identityArrayIntMap == null || getSkipped$runtime_release()) {
            return null;
        }
        int size = identityArrayIntMap.getSize();
        boolean z12 = false;
        int i12 = 0;
        while (true) {
            if (i12 >= size) {
                break;
            }
            Intrinsics.checkNotNull(identityArrayIntMap.getKeys()[i12], "null cannot be cast to non-null type kotlin.Any");
            if (identityArrayIntMap.getValues()[i12] != i11) {
                z11 = true;
            } else {
                z11 = false;
            }
            if (z11) {
                z12 = true;
                break;
            }
            i12++;
        }
        if (z12) {
            return new RecomposeScopeImpl$end$1$2(this, i11, identityArrayIntMap);
        }
        return null;
    }

    @Nullable
    public final Anchor getAnchor() {
        return this.anchor;
    }

    public final boolean getCanRecompose() {
        return this.block != null;
    }

    @Nullable
    public final CompositionImpl getComposition() {
        return this.composition;
    }

    public final boolean getDefaultsInScope() {
        return (this.flags & 2) != 0;
    }

    public final boolean getDefaultsInvalid() {
        return (this.flags & 4) != 0;
    }

    public final boolean getRequiresRecompose() {
        return (this.flags & 8) != 0;
    }

    public final boolean getSkipped$runtime_release() {
        return (this.flags & 16) != 0;
    }

    public final boolean getUsed() {
        return (this.flags & 1) != 0;
    }

    public final boolean getValid() {
        if (this.composition == null) {
            return false;
        }
        Anchor anchor2 = this.anchor;
        return anchor2 != null ? anchor2.getValid() : false;
    }

    public void invalidate() {
        CompositionImpl compositionImpl = this.composition;
        if (compositionImpl != null) {
            compositionImpl.invalidate(this, (Object) null);
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:2:0x0004, code lost:
        r2 = r0.invalidate(r1, r2);
     */
    @org.jetbrains.annotations.NotNull
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final androidx.compose.runtime.InvalidationResult invalidateForResult(@org.jetbrains.annotations.Nullable java.lang.Object r2) {
        /*
            r1 = this;
            androidx.compose.runtime.CompositionImpl r0 = r1.composition
            if (r0 == 0) goto L_0x000a
            androidx.compose.runtime.InvalidationResult r2 = r0.invalidate(r1, r2)
            if (r2 != 0) goto L_0x000c
        L_0x000a:
            androidx.compose.runtime.InvalidationResult r2 = androidx.compose.runtime.InvalidationResult.IGNORED
        L_0x000c:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.runtime.RecomposeScopeImpl.invalidateForResult(java.lang.Object):androidx.compose.runtime.InvalidationResult");
    }

    public final boolean isConditional() {
        return this.trackedDependencies != null;
    }

    /* JADX WARNING: Removed duplicated region for block: B:26:0x004c A[RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:29:0x0049 A[SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final boolean isInvalidFor(@org.jetbrains.annotations.Nullable androidx.compose.runtime.collection.IdentityArraySet<java.lang.Object> r7) {
        /*
            r6 = this;
            r0 = 1
            if (r7 != 0) goto L_0x0004
            return r0
        L_0x0004:
            androidx.compose.runtime.collection.IdentityArrayMap<androidx.compose.runtime.DerivedState<?>, java.lang.Object> r1 = r6.trackedDependencies
            if (r1 != 0) goto L_0x0009
            return r0
        L_0x0009:
            boolean r2 = r7.isNotEmpty()
            if (r2 == 0) goto L_0x004d
            boolean r2 = r7.isEmpty()
            r3 = 0
            if (r2 == 0) goto L_0x0018
        L_0x0016:
            r7 = r0
            goto L_0x004a
        L_0x0018:
            java.util.Iterator r7 = r7.iterator()
        L_0x001c:
            boolean r2 = r7.hasNext()
            if (r2 == 0) goto L_0x0016
            java.lang.Object r2 = r7.next()
            boolean r4 = r2 instanceof androidx.compose.runtime.DerivedState
            if (r4 == 0) goto L_0x0046
            androidx.compose.runtime.DerivedState r2 = (androidx.compose.runtime.DerivedState) r2
            androidx.compose.runtime.SnapshotMutationPolicy r4 = r2.getPolicy()
            if (r4 != 0) goto L_0x0036
            androidx.compose.runtime.SnapshotMutationPolicy r4 = androidx.compose.runtime.SnapshotStateKt.structuralEqualityPolicy()
        L_0x0036:
            java.lang.Object r5 = r2.getCurrentValue()
            java.lang.Object r2 = r1.get(r2)
            boolean r2 = r4.equivalent(r5, r2)
            if (r2 == 0) goto L_0x0046
            r2 = r0
            goto L_0x0047
        L_0x0046:
            r2 = r3
        L_0x0047:
            if (r2 != 0) goto L_0x001c
            r7 = r3
        L_0x004a:
            if (r7 == 0) goto L_0x004d
            return r3
        L_0x004d:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.runtime.RecomposeScopeImpl.isInvalidFor(androidx.compose.runtime.collection.IdentityArraySet):boolean");
    }

    public final void recordRead(@NotNull Object obj) {
        Intrinsics.checkNotNullParameter(obj, "instance");
        if (!getRereading()) {
            IdentityArrayIntMap identityArrayIntMap = this.trackedInstances;
            if (identityArrayIntMap == null) {
                identityArrayIntMap = new IdentityArrayIntMap();
                this.trackedInstances = identityArrayIntMap;
            }
            identityArrayIntMap.add(obj, this.currentToken);
            if (obj instanceof DerivedState) {
                IdentityArrayMap<DerivedState<?>, Object> identityArrayMap = this.trackedDependencies;
                if (identityArrayMap == null) {
                    identityArrayMap = new IdentityArrayMap<>(0, 1, (DefaultConstructorMarker) null);
                    this.trackedDependencies = identityArrayMap;
                }
                identityArrayMap.set(obj, ((DerivedState) obj).getCurrentValue());
            }
        }
    }

    public final void release() {
        this.composition = null;
        this.trackedInstances = null;
        this.trackedDependencies = null;
    }

    public final void rereadTrackedInstances() {
        IdentityArrayIntMap identityArrayIntMap;
        CompositionImpl compositionImpl = this.composition;
        if (compositionImpl != null && (identityArrayIntMap = this.trackedInstances) != null) {
            setRereading(true);
            try {
                int size = identityArrayIntMap.getSize();
                for (int i11 = 0; i11 < size; i11++) {
                    Object obj = identityArrayIntMap.getKeys()[i11];
                    Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlin.Any");
                    int i12 = identityArrayIntMap.getValues()[i11];
                    compositionImpl.recordReadOf(obj);
                }
            } finally {
                setRereading(false);
            }
        }
    }

    public final void scopeSkipped() {
        setSkipped(true);
    }

    public final void setAnchor(@Nullable Anchor anchor2) {
        this.anchor = anchor2;
    }

    public final void setDefaultsInScope(boolean z11) {
        if (z11) {
            this.flags |= 2;
        } else {
            this.flags &= -3;
        }
    }

    public final void setDefaultsInvalid(boolean z11) {
        if (z11) {
            this.flags |= 4;
        } else {
            this.flags &= -5;
        }
    }

    public final void setRequiresRecompose(boolean z11) {
        if (z11) {
            this.flags |= 8;
        } else {
            this.flags &= -9;
        }
    }

    public final void setUsed(boolean z11) {
        if (z11) {
            this.flags |= 1;
        } else {
            this.flags &= -2;
        }
    }

    public final void start(int i11) {
        this.currentToken = i11;
        setSkipped(false);
    }

    public void updateScope(@NotNull Function2<? super Composer, ? super Integer, Unit> function2) {
        Intrinsics.checkNotNullParameter(function2, "block");
        this.block = function2;
    }
}
