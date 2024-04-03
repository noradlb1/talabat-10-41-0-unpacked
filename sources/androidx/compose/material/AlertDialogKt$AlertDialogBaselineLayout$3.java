package androidx.compose.material;

import androidx.compose.foundation.layout.ColumnScope;
import androidx.compose.runtime.Composer;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.Nullable;

@Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
public final class AlertDialogKt$AlertDialogBaselineLayout$3 extends Lambda implements Function2<Composer, Integer, Unit> {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ ColumnScope f3781g;

    /* renamed from: h  reason: collision with root package name */
    public final /* synthetic */ Function2<Composer, Integer, Unit> f3782h;

    /* renamed from: i  reason: collision with root package name */
    public final /* synthetic */ Function2<Composer, Integer, Unit> f3783i;

    /* renamed from: j  reason: collision with root package name */
    public final /* synthetic */ int f3784j;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public AlertDialogKt$AlertDialogBaselineLayout$3(ColumnScope columnScope, Function2<? super Composer, ? super Integer, Unit> function2, Function2<? super Composer, ? super Integer, Unit> function22, int i11) {
        super(2);
        this.f3781g = columnScope;
        this.f3782h = function2;
        this.f3783i = function22;
        this.f3784j = i11;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
        invoke((Composer) obj, ((Number) obj2).intValue());
        return Unit.INSTANCE;
    }

    public final void invoke(@Nullable Composer composer, int i11) {
        AlertDialogKt.AlertDialogBaselineLayout(this.f3781g, this.f3782h, this.f3783i, composer, this.f3784j | 1);
    }
}
