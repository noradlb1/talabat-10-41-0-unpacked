package androidx.compose.material;

import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.runtime.Composable;
import androidx.compose.runtime.ComposableTarget;
import androidx.compose.runtime.Composer;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.layout.SubcomposeLayoutKt;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.Nullable;

@Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
public final class TabRowKt$TabRow$2 extends Lambda implements Function2<Composer, Integer, Unit> {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ Function2<Composer, Integer, Unit> f5838g;

    /* renamed from: h  reason: collision with root package name */
    public final /* synthetic */ Function2<Composer, Integer, Unit> f5839h;

    /* renamed from: i  reason: collision with root package name */
    public final /* synthetic */ Function3<List<TabPosition>, Composer, Integer, Unit> f5840i;

    /* renamed from: j  reason: collision with root package name */
    public final /* synthetic */ int f5841j;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public TabRowKt$TabRow$2(Function2<? super Composer, ? super Integer, Unit> function2, Function2<? super Composer, ? super Integer, Unit> function22, Function3<? super List<TabPosition>, ? super Composer, ? super Integer, Unit> function3, int i11) {
        super(2);
        this.f5838g = function2;
        this.f5839h = function22;
        this.f5840i = function3;
        this.f5841j = i11;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
        invoke((Composer) obj, ((Number) obj2).intValue());
        return Unit.INSTANCE;
    }

    @ComposableTarget(applier = "androidx.compose.ui.UiComposable")
    @Composable
    public final void invoke(@Nullable Composer composer, int i11) {
        if ((i11 & 11) != 2 || !composer.getSkipping()) {
            Modifier fillMaxWidth$default = SizeKt.fillMaxWidth$default(Modifier.Companion, 0.0f, 1, (Object) null);
            Function2<Composer, Integer, Unit> function2 = this.f5838g;
            Function2<Composer, Integer, Unit> function22 = this.f5839h;
            Function3<List<TabPosition>, Composer, Integer, Unit> function3 = this.f5840i;
            int i12 = this.f5841j;
            composer.startReplaceableGroup(1618982084);
            boolean changed = composer.changed((Object) function2) | composer.changed((Object) function22) | composer.changed((Object) function3);
            Object rememberedValue = composer.rememberedValue();
            if (changed || rememberedValue == Composer.Companion.getEmpty()) {
                rememberedValue = new TabRowKt$TabRow$2$1$1(function2, function22, function3, i12);
                composer.updateRememberedValue(rememberedValue);
            }
            composer.endReplaceableGroup();
            SubcomposeLayoutKt.SubcomposeLayout(fillMaxWidth$default, (Function2) rememberedValue, composer, 6, 0);
            return;
        }
        composer.skipToGroupEnd();
    }
}
