package androidx.compose.material;

import androidx.compose.material.icons.Icons;
import androidx.compose.material.icons.filled.ArrowDropDownKt;
import androidx.compose.runtime.Composable;
import androidx.compose.runtime.ComposableTarget;
import androidx.compose.runtime.Composer;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.draw.RotateKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.Nullable;

@Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
public final class ExposedDropdownMenuDefaults$TrailingIcon$3 extends Lambda implements Function2<Composer, Integer, Unit> {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ boolean f4527g;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public ExposedDropdownMenuDefaults$TrailingIcon$3(boolean z11) {
        super(2);
        this.f4527g = z11;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
        invoke((Composer) obj, ((Number) obj2).intValue());
        return Unit.INSTANCE;
    }

    @ComposableTarget(applier = "androidx.compose.ui.UiComposable")
    @Composable
    public final void invoke(@Nullable Composer composer, int i11) {
        if ((i11 & 11) != 2 || !composer.getSkipping()) {
            IconKt.m1279Iconww6aTOc(ArrowDropDownKt.getArrowDropDown(Icons.Filled.INSTANCE), "Trailing icon for exposed dropdown menu", RotateKt.rotate(Modifier.Companion, this.f4527g ? 180.0f : 360.0f), 0, composer, 48, 8);
        } else {
            composer.skipToGroupEnd();
        }
    }
}
