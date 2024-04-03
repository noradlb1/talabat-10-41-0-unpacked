package androidx.compose.ui.layout;

import androidx.compose.runtime.Applier;
import androidx.compose.runtime.Composable;
import androidx.compose.runtime.ComposableTarget;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.Updater;
import androidx.compose.ui.node.ComposeUiNode;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001H\u000b¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"<anonymous>", "", "invoke", "(Landroidx/compose/runtime/Composer;I)V"}, k = 3, mv = {1, 7, 1}, xi = 48)
public final class LayoutKt$combineAsVirtualLayouts$1 extends Lambda implements Function2<Composer, Integer, Unit> {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ List<Function2<Composer, Integer, Unit>> f9847g;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public LayoutKt$combineAsVirtualLayouts$1(List<? extends Function2<? super Composer, ? super Integer, Unit>> list) {
        super(2);
        this.f9847g = list;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
        invoke((Composer) obj, ((Number) obj2).intValue());
        return Unit.INSTANCE;
    }

    @ComposableTarget(applier = "androidx.compose.ui.UiComposable")
    @Composable
    public final void invoke(@Nullable Composer composer, int i11) {
        if ((i11 & 11) != 2 || !composer.getSkipping()) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1953651383, i11, -1, "androidx.compose.ui.layout.combineAsVirtualLayouts.<anonymous> (Layout.kt:178)");
            }
            List<Function2<Composer, Integer, Unit>> list = this.f9847g;
            int size = list.size();
            for (int i12 = 0; i12 < size; i12++) {
                Function2 function2 = list.get(i12);
                Function0<ComposeUiNode> virtualConstructor = ComposeUiNode.Companion.getVirtualConstructor();
                composer.startReplaceableGroup(-692256719);
                if (!(composer.getApplier() instanceof Applier)) {
                    ComposablesKt.invalidApplier();
                }
                composer.startReusableNode();
                if (composer.getInserting()) {
                    composer.createNode(virtualConstructor);
                } else {
                    composer.useNode();
                }
                composer.disableReusing();
                Updater.m2536constructorimpl(composer);
                composer.enableReusing();
                function2.invoke(composer, 0);
                composer.endNode();
                composer.endReplaceableGroup();
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
                return;
            }
            return;
        }
        composer.skipToGroupEnd();
    }
}
