package com.skydoves.landscapist.coil;

import androidx.compose.runtime.Composable;
import androidx.compose.runtime.Composer;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.graphics.ColorFilter;
import androidx.compose.ui.layout.ContentScale;
import com.skydoves.landscapist.ImageWithSource;
import com.skydoves.landscapist.coil.CoilImageState;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import net.bytebuddy.jar.asm.Opcodes;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(k = 3, mv = {1, 5, 1}, xi = 48)
public final class CoilImage__CoilImageKt$CoilImage$1 extends Lambda implements Function3<CoilImageState.Failure, Composer, Integer, Unit> {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ Object f52995g;

    /* renamed from: h  reason: collision with root package name */
    public final /* synthetic */ Modifier f52996h;

    /* renamed from: i  reason: collision with root package name */
    public final /* synthetic */ Alignment f52997i;

    /* renamed from: j  reason: collision with root package name */
    public final /* synthetic */ ContentScale f52998j;

    /* renamed from: k  reason: collision with root package name */
    public final /* synthetic */ String f52999k;

    /* renamed from: l  reason: collision with root package name */
    public final /* synthetic */ ColorFilter f53000l;

    /* renamed from: m  reason: collision with root package name */
    public final /* synthetic */ float f53001m;

    /* renamed from: n  reason: collision with root package name */
    public final /* synthetic */ int f53002n;

    /* renamed from: o  reason: collision with root package name */
    public final /* synthetic */ int f53003o;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public CoilImage__CoilImageKt$CoilImage$1(Object obj, Modifier modifier, Alignment alignment, ContentScale contentScale, String str, ColorFilter colorFilter, float f11, int i11, int i12) {
        super(3);
        this.f52995g = obj;
        this.f52996h = modifier;
        this.f52997i = alignment;
        this.f52998j = contentScale;
        this.f52999k = str;
        this.f53000l = colorFilter;
        this.f53001m = f11;
        this.f53002n = i11;
        this.f53003o = i12;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2, Object obj3) {
        invoke((CoilImageState.Failure) obj, (Composer) obj2, ((Number) obj3).intValue());
        return Unit.INSTANCE;
    }

    @Composable
    public final void invoke(@NotNull CoilImageState.Failure failure, @Nullable Composer composer, int i11) {
        Intrinsics.checkNotNullParameter(failure, "it");
        if (((i11 & 81) ^ 16) != 0 || !composer.getSkipping()) {
            Object obj = this.f52995g;
            if (obj == null) {
                composer.startReplaceableGroup(279424947);
            } else {
                composer.startReplaceableGroup(-2069196274);
                Modifier modifier = this.f52996h;
                Alignment alignment = this.f52997i;
                ContentScale contentScale = this.f52998j;
                String str = this.f52999k;
                ColorFilter colorFilter = this.f53000l;
                float f11 = this.f53001m;
                int i12 = this.f53002n;
                int i13 = i12 >> 12;
                int i14 = (this.f53003o << 15) & Opcodes.ASM7;
                Composer composer2 = composer;
                ImageWithSource.ImageBySource(obj, modifier, alignment, contentScale, str, colorFilter, f11, composer2, i14 | (i12 & 112) | 8 | ((i12 >> 9) & 896) | (i13 & 7168) | (i13 & 57344) | (i12 & 3670016), 0);
            }
            composer.endReplaceableGroup();
            return;
        }
        composer.skipToGroupEnd();
    }
}
