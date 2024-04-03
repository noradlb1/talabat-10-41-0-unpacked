package androidx.compose.material;

import androidx.compose.runtime.Composer;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.Nullable;

@Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
public final class AlertDialogKt$AlertDialogFlowRow$2 extends Lambda implements Function2<Composer, Integer, Unit> {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ float f3813g;

    /* renamed from: h  reason: collision with root package name */
    public final /* synthetic */ float f3814h;

    /* renamed from: i  reason: collision with root package name */
    public final /* synthetic */ Function2<Composer, Integer, Unit> f3815i;

    /* renamed from: j  reason: collision with root package name */
    public final /* synthetic */ int f3816j;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public AlertDialogKt$AlertDialogFlowRow$2(float f11, float f12, Function2<? super Composer, ? super Integer, Unit> function2, int i11) {
        super(2);
        this.f3813g = f11;
        this.f3814h = f12;
        this.f3815i = function2;
        this.f3816j = i11;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
        invoke((Composer) obj, ((Number) obj2).intValue());
        return Unit.INSTANCE;
    }

    public final void invoke(@Nullable Composer composer, int i11) {
        AlertDialogKt.m1076AlertDialogFlowRowixp7dh8(this.f3813g, this.f3814h, this.f3815i, composer, this.f3816j | 1);
    }
}
