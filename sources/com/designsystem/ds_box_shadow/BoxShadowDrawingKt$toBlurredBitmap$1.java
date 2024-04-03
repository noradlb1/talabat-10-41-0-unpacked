package com.designsystem.ds_box_shadow;

import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\n"}, d2 = {"Landroid/graphics/Canvas;", "", "<anonymous>"}, k = 3, mv = {1, 5, 1})
public final class BoxShadowDrawingKt$toBlurredBitmap$1 extends Lambda implements Function1<Canvas, Unit> {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ float f30603g;

    /* renamed from: h  reason: collision with root package name */
    public final /* synthetic */ float f30604h;

    /* renamed from: i  reason: collision with root package name */
    public final /* synthetic */ Drawable f30605i;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public BoxShadowDrawingKt$toBlurredBitmap$1(float f11, float f12, Drawable drawable) {
        super(1);
        this.f30603g = f11;
        this.f30604h = f12;
        this.f30605i = drawable;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((Canvas) obj);
        return Unit.INSTANCE;
    }

    public final void invoke(@NotNull Canvas canvas) {
        Intrinsics.checkNotNullParameter(canvas, "$this$blurred");
        Drawable drawable = this.f30605i;
        int save = canvas.save();
        canvas.translate(this.f30603g + 25.0f, this.f30604h + 25.0f);
        try {
            drawable.draw(canvas);
        } finally {
            canvas.restoreToCount(save);
        }
    }
}
