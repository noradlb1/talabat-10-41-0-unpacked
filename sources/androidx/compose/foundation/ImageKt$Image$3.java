package androidx.compose.foundation;

import androidx.compose.runtime.Composer;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.graphics.ColorFilter;
import androidx.compose.ui.graphics.painter.Painter;
import androidx.compose.ui.layout.ContentScale;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.Nullable;

@Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
public final class ImageKt$Image$3 extends Lambda implements Function2<Composer, Integer, Unit> {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ Painter f1710g;

    /* renamed from: h  reason: collision with root package name */
    public final /* synthetic */ String f1711h;

    /* renamed from: i  reason: collision with root package name */
    public final /* synthetic */ Modifier f1712i;

    /* renamed from: j  reason: collision with root package name */
    public final /* synthetic */ Alignment f1713j;

    /* renamed from: k  reason: collision with root package name */
    public final /* synthetic */ ContentScale f1714k;

    /* renamed from: l  reason: collision with root package name */
    public final /* synthetic */ float f1715l;

    /* renamed from: m  reason: collision with root package name */
    public final /* synthetic */ ColorFilter f1716m;

    /* renamed from: n  reason: collision with root package name */
    public final /* synthetic */ int f1717n;

    /* renamed from: o  reason: collision with root package name */
    public final /* synthetic */ int f1718o;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public ImageKt$Image$3(Painter painter, String str, Modifier modifier, Alignment alignment, ContentScale contentScale, float f11, ColorFilter colorFilter, int i11, int i12) {
        super(2);
        this.f1710g = painter;
        this.f1711h = str;
        this.f1712i = modifier;
        this.f1713j = alignment;
        this.f1714k = contentScale;
        this.f1715l = f11;
        this.f1716m = colorFilter;
        this.f1717n = i11;
        this.f1718o = i12;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
        invoke((Composer) obj, ((Number) obj2).intValue());
        return Unit.INSTANCE;
    }

    public final void invoke(@Nullable Composer composer, int i11) {
        ImageKt.Image(this.f1710g, this.f1711h, this.f1712i, this.f1713j, this.f1714k, this.f1715l, this.f1716m, composer, this.f1717n | 1, this.f1718o);
    }
}
