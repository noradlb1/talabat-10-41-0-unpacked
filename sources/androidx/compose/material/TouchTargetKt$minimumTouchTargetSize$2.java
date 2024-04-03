package androidx.compose.material;

import androidx.compose.runtime.Composable;
import androidx.compose.runtime.Composer;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.platform.CompositionLocalsKt;
import androidx.compose.ui.platform.ViewConfiguration;
import kotlin.Metadata;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0001H\u000b¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"<anonymous>", "Landroidx/compose/ui/Modifier;", "invoke", "(Landroidx/compose/ui/Modifier;Landroidx/compose/runtime/Composer;I)Landroidx/compose/ui/Modifier;"}, k = 3, mv = {1, 6, 0}, xi = 48)
public final class TouchTargetKt$minimumTouchTargetSize$2 extends Lambda implements Function3<Modifier, Composer, Integer, Modifier> {
    public static final TouchTargetKt$minimumTouchTargetSize$2 INSTANCE = new TouchTargetKt$minimumTouchTargetSize$2();

    public TouchTargetKt$minimumTouchTargetSize$2() {
        super(3);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2, Object obj3) {
        return invoke((Modifier) obj, (Composer) obj2, ((Number) obj3).intValue());
    }

    @NotNull
    @Composable
    public final Modifier invoke(@NotNull Modifier modifier, @Nullable Composer composer, int i11) {
        Modifier modifier2;
        Intrinsics.checkNotNullParameter(modifier, "$this$composed");
        composer.startReplaceableGroup(1220403677);
        if (((Boolean) composer.consume(TouchTargetKt.getLocalMinimumTouchTargetEnforcement())).booleanValue()) {
            modifier2 = new MinimumTouchTargetModifier(((ViewConfiguration) composer.consume(CompositionLocalsKt.getLocalViewConfiguration())).m4881getMinimumTouchTargetSizeMYxV2XQ(), (DefaultConstructorMarker) null);
        } else {
            modifier2 = Modifier.Companion;
        }
        composer.endReplaceableGroup();
        return modifier2;
    }
}
