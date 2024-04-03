package androidx.compose.material;

import androidx.compose.runtime.Composable;
import androidx.compose.runtime.ComposableTarget;
import androidx.compose.runtime.Composer;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.Nullable;

@Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
public final class AndroidAlertDialog_androidKt$AlertDialog$1$1$1 extends Lambda implements Function2<Composer, Integer, Unit> {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ Function2<Composer, Integer, Unit> f3820g;

    /* renamed from: h  reason: collision with root package name */
    public final /* synthetic */ int f3821h;

    /* renamed from: i  reason: collision with root package name */
    public final /* synthetic */ Function2<Composer, Integer, Unit> f3822i;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public AndroidAlertDialog_androidKt$AlertDialog$1$1$1(Function2<? super Composer, ? super Integer, Unit> function2, int i11, Function2<? super Composer, ? super Integer, Unit> function22) {
        super(2);
        this.f3820g = function2;
        this.f3821h = i11;
        this.f3822i = function22;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
        invoke((Composer) obj, ((Number) obj2).intValue());
        return Unit.INSTANCE;
    }

    @ComposableTarget(applier = "androidx.compose.ui.UiComposable")
    @Composable
    public final void invoke(@Nullable Composer composer, int i11) {
        if ((i11 & 11) != 2 || !composer.getSkipping()) {
            Function2<Composer, Integer, Unit> function2 = this.f3820g;
            composer.startReplaceableGroup(-1046483318);
            if (function2 != null) {
                function2.invoke(composer, Integer.valueOf((this.f3821h >> 9) & 14));
                Unit unit = Unit.INSTANCE;
            }
            composer.endReplaceableGroup();
            this.f3822i.invoke(composer, Integer.valueOf((this.f3821h >> 3) & 14));
            return;
        }
        composer.skipToGroupEnd();
    }
}
