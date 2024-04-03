package com.designsystem.ds_image;

import androidx.compose.runtime.Composer;
import androidx.compose.ui.layout.ContentScale;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.Nullable;

@Metadata(k = 3, mv = {1, 5, 1}, xi = 48)
public final class RatioImageComposablesKt$RatioImageBlurredPlaceholder$1 extends Lambda implements Function2<Composer, Integer, Unit> {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ String f31331g;

    /* renamed from: h  reason: collision with root package name */
    public final /* synthetic */ ContentScale f31332h;

    /* renamed from: i  reason: collision with root package name */
    public final /* synthetic */ int f31333i;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public RatioImageComposablesKt$RatioImageBlurredPlaceholder$1(String str, ContentScale contentScale, int i11) {
        super(2);
        this.f31331g = str;
        this.f31332h = contentScale;
        this.f31333i = i11;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
        invoke((Composer) obj, ((Number) obj2).intValue());
        return Unit.INSTANCE;
    }

    public final void invoke(@Nullable Composer composer, int i11) {
        RatioImageComposablesKt.RatioImageBlurredPlaceholder(this.f31331g, this.f31332h, composer, this.f31333i | 1);
    }
}
