package androidx.compose.material3;

import androidx.compose.runtime.Composer;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.graphics.painter.Painter;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.Nullable;

@Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
public final class IconKt$Icon$3 extends Lambda implements Function2<Composer, Integer, Unit> {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ Painter f7229g;

    /* renamed from: h  reason: collision with root package name */
    public final /* synthetic */ String f7230h;

    /* renamed from: i  reason: collision with root package name */
    public final /* synthetic */ Modifier f7231i;

    /* renamed from: j  reason: collision with root package name */
    public final /* synthetic */ long f7232j;

    /* renamed from: k  reason: collision with root package name */
    public final /* synthetic */ int f7233k;

    /* renamed from: l  reason: collision with root package name */
    public final /* synthetic */ int f7234l;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public IconKt$Icon$3(Painter painter, String str, Modifier modifier, long j11, int i11, int i12) {
        super(2);
        this.f7229g = painter;
        this.f7230h = str;
        this.f7231i = modifier;
        this.f7232j = j11;
        this.f7233k = i11;
        this.f7234l = i12;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
        invoke((Composer) obj, ((Number) obj2).intValue());
        return Unit.INSTANCE;
    }

    public final void invoke(@Nullable Composer composer, int i11) {
        IconKt.m1717Iconww6aTOc(this.f7229g, this.f7230h, this.f7231i, this.f7232j, composer, this.f7233k | 1, this.f7234l);
    }
}
