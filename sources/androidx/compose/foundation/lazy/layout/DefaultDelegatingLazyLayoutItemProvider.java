package androidx.compose.foundation.lazy.layout;

import androidx.compose.foundation.ExperimentalFoundationApi;
import androidx.compose.runtime.Composable;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.State;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import net.bytebuddy.implementation.MethodDelegation;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010$\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0005\b\u0003\u0018\u00002\u00020\u0001B\u0013\u0012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00010\u0003¢\u0006\u0002\u0010\u0004J\u0015\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u0006H\u0017¢\u0006\u0002\u0010\u0011J\u0012\u0010\u0012\u001a\u0004\u0018\u00010\u000b2\u0006\u0010\u0010\u001a\u00020\u0006H\u0016J\u0010\u0010\u0013\u001a\u00020\u000b2\u0006\u0010\u0010\u001a\u00020\u0006H\u0016R\u0014\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00010\u0003X\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0005\u001a\u00020\u00068VX\u0004¢\u0006\u0006\u001a\u0004\b\u0007\u0010\bR \u0010\t\u001a\u000e\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\u00060\n8VX\u0004¢\u0006\u0006\u001a\u0004\b\f\u0010\r¨\u0006\u0014"}, d2 = {"Landroidx/compose/foundation/lazy/layout/DefaultDelegatingLazyLayoutItemProvider;", "Landroidx/compose/foundation/lazy/layout/LazyLayoutItemProvider;", "delegate", "Landroidx/compose/runtime/State;", "(Landroidx/compose/runtime/State;)V", "itemCount", "", "getItemCount", "()I", "keyToIndexMap", "", "", "getKeyToIndexMap", "()Ljava/util/Map;", "Item", "", "index", "(ILandroidx/compose/runtime/Composer;I)V", "getContentType", "getKey", "foundation_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
@ExperimentalFoundationApi
final class DefaultDelegatingLazyLayoutItemProvider implements LazyLayoutItemProvider {
    @NotNull
    private final State<LazyLayoutItemProvider> delegate;

    public DefaultDelegatingLazyLayoutItemProvider(@NotNull State<? extends LazyLayoutItemProvider> state) {
        Intrinsics.checkNotNullParameter(state, MethodDelegation.ImplementationDelegate.FIELD_NAME_PREFIX);
        this.delegate = state;
    }

    @Composable
    public void Item(int i11, @Nullable Composer composer, int i12) {
        int i13;
        int i14;
        int i15;
        Composer startRestartGroup = composer.startRestartGroup(1633511187);
        if ((i12 & 14) == 0) {
            if (startRestartGroup.changed(i11)) {
                i15 = 4;
            } else {
                i15 = 2;
            }
            i13 = i15 | i12;
        } else {
            i13 = i12;
        }
        if ((i12 & 112) == 0) {
            if (startRestartGroup.changed((Object) this)) {
                i14 = 32;
            } else {
                i14 = 16;
            }
            i13 |= i14;
        }
        if ((i13 & 91) != 18 || !startRestartGroup.getSkipping()) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1633511187, i13, -1, "androidx.compose.foundation.lazy.layout.DefaultDelegatingLazyLayoutItemProvider.Item (LazyLayoutItemProvider.kt:195)");
            }
            this.delegate.getValue().Item(i11, startRestartGroup, i13 & 14);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            startRestartGroup.skipToGroupEnd();
        }
        ScopeUpdateScope endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new DefaultDelegatingLazyLayoutItemProvider$Item$1(this, i11, i12));
        }
    }

    @Nullable
    public Object getContentType(int i11) {
        return this.delegate.getValue().getContentType(i11);
    }

    public int getItemCount() {
        return this.delegate.getValue().getItemCount();
    }

    @NotNull
    public Object getKey(int i11) {
        return this.delegate.getValue().getKey(i11);
    }

    @NotNull
    public Map<Object, Integer> getKeyToIndexMap() {
        return this.delegate.getValue().getKeyToIndexMap();
    }
}
