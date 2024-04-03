package com.skydoves.landscapist;

import androidx.compose.runtime.Composer;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.graphics.ColorFilter;
import androidx.compose.ui.layout.ContentScale;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.Nullable;

@Metadata(k = 3, mv = {1, 5, 1}, xi = 48)
public final class ImageWithSource__ImageBySourceKt$ImageBySource$1 extends Lambda implements Function2<Composer, Integer, Unit> {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ Object f52962g;

    /* renamed from: h  reason: collision with root package name */
    public final /* synthetic */ Modifier f52963h;

    /* renamed from: i  reason: collision with root package name */
    public final /* synthetic */ Alignment f52964i;

    /* renamed from: j  reason: collision with root package name */
    public final /* synthetic */ ContentScale f52965j;

    /* renamed from: k  reason: collision with root package name */
    public final /* synthetic */ String f52966k;

    /* renamed from: l  reason: collision with root package name */
    public final /* synthetic */ ColorFilter f52967l;

    /* renamed from: m  reason: collision with root package name */
    public final /* synthetic */ float f52968m;

    /* renamed from: n  reason: collision with root package name */
    public final /* synthetic */ int f52969n;

    /* renamed from: o  reason: collision with root package name */
    public final /* synthetic */ int f52970o;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public ImageWithSource__ImageBySourceKt$ImageBySource$1(Object obj, Modifier modifier, Alignment alignment, ContentScale contentScale, String str, ColorFilter colorFilter, float f11, int i11, int i12) {
        super(2);
        this.f52962g = obj;
        this.f52963h = modifier;
        this.f52964i = alignment;
        this.f52965j = contentScale;
        this.f52966k = str;
        this.f52967l = colorFilter;
        this.f52968m = f11;
        this.f52969n = i11;
        this.f52970o = i12;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
        invoke((Composer) obj, ((Number) obj2).intValue());
        return Unit.INSTANCE;
    }

    public final void invoke(@Nullable Composer composer, int i11) {
        ImageWithSource.ImageBySource(this.f52962g, this.f52963h, this.f52964i, this.f52965j, this.f52966k, this.f52967l, this.f52968m, composer, this.f52969n | 1, this.f52970o);
    }
}
