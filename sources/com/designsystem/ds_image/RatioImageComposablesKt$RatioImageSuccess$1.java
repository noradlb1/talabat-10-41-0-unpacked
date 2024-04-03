package com.designsystem.ds_image;

import android.graphics.drawable.Drawable;
import androidx.compose.runtime.Composer;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.layout.ContentScale;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.Nullable;

@Metadata(k = 3, mv = {1, 5, 1}, xi = 48)
public final class RatioImageComposablesKt$RatioImageSuccess$1 extends Lambda implements Function2<Composer, Integer, Unit> {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ Drawable f31336g;

    /* renamed from: h  reason: collision with root package name */
    public final /* synthetic */ ContentScale f31337h;

    /* renamed from: i  reason: collision with root package name */
    public final /* synthetic */ Modifier f31338i;

    /* renamed from: j  reason: collision with root package name */
    public final /* synthetic */ int f31339j;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public RatioImageComposablesKt$RatioImageSuccess$1(Drawable drawable, ContentScale contentScale, Modifier modifier, int i11) {
        super(2);
        this.f31336g = drawable;
        this.f31337h = contentScale;
        this.f31338i = modifier;
        this.f31339j = i11;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
        invoke((Composer) obj, ((Number) obj2).intValue());
        return Unit.INSTANCE;
    }

    public final void invoke(@Nullable Composer composer, int i11) {
        RatioImageComposablesKt.RatioImageSuccess(this.f31336g, this.f31337h, this.f31338i, composer, this.f31339j | 1);
    }
}
