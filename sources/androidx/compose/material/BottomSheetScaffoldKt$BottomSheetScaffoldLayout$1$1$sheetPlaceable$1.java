package androidx.compose.material;

import androidx.compose.runtime.Composable;
import androidx.compose.runtime.Composer;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.Nullable;

@Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
public final class BottomSheetScaffoldKt$BottomSheetScaffoldLayout$1$1$sheetPlaceable$1 extends Lambda implements Function2<Composer, Integer, Unit> {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ Function3<Integer, Composer, Integer, Unit> f4224g;

    /* renamed from: h  reason: collision with root package name */
    public final /* synthetic */ int f4225h;

    /* renamed from: i  reason: collision with root package name */
    public final /* synthetic */ int f4226i;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public BottomSheetScaffoldKt$BottomSheetScaffoldLayout$1$1$sheetPlaceable$1(Function3<? super Integer, ? super Composer, ? super Integer, Unit> function3, int i11, int i12) {
        super(2);
        this.f4224g = function3;
        this.f4225h = i11;
        this.f4226i = i12;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
        invoke((Composer) obj, ((Number) obj2).intValue());
        return Unit.INSTANCE;
    }

    @Composable
    public final void invoke(@Nullable Composer composer, int i11) {
        if ((i11 & 11) != 2 || !composer.getSkipping()) {
            this.f4224g.invoke(Integer.valueOf(this.f4225h), composer, Integer.valueOf((this.f4226i >> 3) & 112));
        } else {
            composer.skipToGroupEnd();
        }
    }
}
