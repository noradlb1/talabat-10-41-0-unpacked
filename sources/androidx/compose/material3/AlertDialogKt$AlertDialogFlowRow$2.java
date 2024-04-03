package androidx.compose.material3;

import androidx.compose.runtime.Composer;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.Nullable;

@Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
public final class AlertDialogKt$AlertDialogFlowRow$2 extends Lambda implements Function2<Composer, Integer, Unit> {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ float f6300g;

    /* renamed from: h  reason: collision with root package name */
    public final /* synthetic */ float f6301h;

    /* renamed from: i  reason: collision with root package name */
    public final /* synthetic */ Function2<Composer, Integer, Unit> f6302i;

    /* renamed from: j  reason: collision with root package name */
    public final /* synthetic */ int f6303j;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public AlertDialogKt$AlertDialogFlowRow$2(float f11, float f12, Function2<? super Composer, ? super Integer, Unit> function2, int i11) {
        super(2);
        this.f6300g = f11;
        this.f6301h = f12;
        this.f6302i = function2;
        this.f6303j = i11;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
        invoke((Composer) obj, ((Number) obj2).intValue());
        return Unit.INSTANCE;
    }

    public final void invoke(@Nullable Composer composer, int i11) {
        AlertDialogKt.m1494AlertDialogFlowRowixp7dh8(this.f6300g, this.f6301h, this.f6302i, composer, this.f6303j | 1);
    }
}
