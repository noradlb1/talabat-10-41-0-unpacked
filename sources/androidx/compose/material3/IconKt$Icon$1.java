package androidx.compose.material3;

import androidx.compose.runtime.Composer;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.graphics.vector.ImageVector;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.Nullable;

@Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
public final class IconKt$Icon$1 extends Lambda implements Function2<Composer, Integer, Unit> {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ ImageVector f7217g;

    /* renamed from: h  reason: collision with root package name */
    public final /* synthetic */ String f7218h;

    /* renamed from: i  reason: collision with root package name */
    public final /* synthetic */ Modifier f7219i;

    /* renamed from: j  reason: collision with root package name */
    public final /* synthetic */ long f7220j;

    /* renamed from: k  reason: collision with root package name */
    public final /* synthetic */ int f7221k;

    /* renamed from: l  reason: collision with root package name */
    public final /* synthetic */ int f7222l;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public IconKt$Icon$1(ImageVector imageVector, String str, Modifier modifier, long j11, int i11, int i12) {
        super(2);
        this.f7217g = imageVector;
        this.f7218h = str;
        this.f7219i = modifier;
        this.f7220j = j11;
        this.f7221k = i11;
        this.f7222l = i12;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
        invoke((Composer) obj, ((Number) obj2).intValue());
        return Unit.INSTANCE;
    }

    public final void invoke(@Nullable Composer composer, int i11) {
        IconKt.m1718Iconww6aTOc(this.f7217g, this.f7218h, this.f7219i, this.f7220j, composer, this.f7221k | 1, this.f7222l);
    }
}
