package androidx.compose.foundation.text.selection;

import androidx.compose.runtime.Composer;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.text.style.ResolvedTextDirection;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.Nullable;

@Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
public final class AndroidSelectionHandles_androidKt$SelectionHandle$2 extends Lambda implements Function2<Composer, Integer, Unit> {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ long f3643g;

    /* renamed from: h  reason: collision with root package name */
    public final /* synthetic */ boolean f3644h;

    /* renamed from: i  reason: collision with root package name */
    public final /* synthetic */ ResolvedTextDirection f3645i;

    /* renamed from: j  reason: collision with root package name */
    public final /* synthetic */ boolean f3646j;

    /* renamed from: k  reason: collision with root package name */
    public final /* synthetic */ Modifier f3647k;

    /* renamed from: l  reason: collision with root package name */
    public final /* synthetic */ Function2<Composer, Integer, Unit> f3648l;

    /* renamed from: m  reason: collision with root package name */
    public final /* synthetic */ int f3649m;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public AndroidSelectionHandles_androidKt$SelectionHandle$2(long j11, boolean z11, ResolvedTextDirection resolvedTextDirection, boolean z12, Modifier modifier, Function2<? super Composer, ? super Integer, Unit> function2, int i11) {
        super(2);
        this.f3643g = j11;
        this.f3644h = z11;
        this.f3645i = resolvedTextDirection;
        this.f3646j = z12;
        this.f3647k = modifier;
        this.f3648l = function2;
        this.f3649m = i11;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
        invoke((Composer) obj, ((Number) obj2).intValue());
        return Unit.INSTANCE;
    }

    public final void invoke(@Nullable Composer composer, int i11) {
        AndroidSelectionHandles_androidKt.m944SelectionHandle8fL75g(this.f3643g, this.f3644h, this.f3645i, this.f3646j, this.f3647k, this.f3648l, composer, this.f3649m | 1);
    }
}
