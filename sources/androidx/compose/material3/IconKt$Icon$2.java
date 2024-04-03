package androidx.compose.material3;

import androidx.compose.runtime.Composer;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.graphics.ImageBitmap;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.Nullable;

@Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
public final class IconKt$Icon$2 extends Lambda implements Function2<Composer, Integer, Unit> {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ ImageBitmap f7223g;

    /* renamed from: h  reason: collision with root package name */
    public final /* synthetic */ String f7224h;

    /* renamed from: i  reason: collision with root package name */
    public final /* synthetic */ Modifier f7225i;

    /* renamed from: j  reason: collision with root package name */
    public final /* synthetic */ long f7226j;

    /* renamed from: k  reason: collision with root package name */
    public final /* synthetic */ int f7227k;

    /* renamed from: l  reason: collision with root package name */
    public final /* synthetic */ int f7228l;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public IconKt$Icon$2(ImageBitmap imageBitmap, String str, Modifier modifier, long j11, int i11, int i12) {
        super(2);
        this.f7223g = imageBitmap;
        this.f7224h = str;
        this.f7225i = modifier;
        this.f7226j = j11;
        this.f7227k = i11;
        this.f7228l = i12;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
        invoke((Composer) obj, ((Number) obj2).intValue());
        return Unit.INSTANCE;
    }

    public final void invoke(@Nullable Composer composer, int i11) {
        IconKt.m1716Iconww6aTOc(this.f7223g, this.f7224h, this.f7225i, this.f7226j, composer, this.f7227k | 1, this.f7228l);
    }
}
