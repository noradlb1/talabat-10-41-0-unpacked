package com.skydoves.landscapist;

import android.graphics.drawable.Drawable;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u0007\n\u0002\b\u0002*\u0001\u0000\u0010\u0001\u001a\u00020\u0000H\n"}, d2 = {"com/skydoves/landscapist/DrawablePainter$callback$2$1", "<anonymous>"}, k = 3, mv = {1, 5, 1})
public final class DrawablePainter$callback$2 extends Lambda implements Function0<AnonymousClass1> {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ DrawablePainter f52944g;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public DrawablePainter$callback$2(DrawablePainter drawablePainter) {
        super(0);
        this.f52944g = drawablePainter;
    }

    @NotNull
    public final AnonymousClass1 invoke() {
        final DrawablePainter drawablePainter = this.f52944g;
        return new Drawable.Callback() {
            public void invalidateDrawable(@NotNull Drawable drawable) {
                Intrinsics.checkNotNullParameter(drawable, "d");
                DrawablePainter drawablePainter = drawablePainter;
                drawablePainter.setInvalidateTick(drawablePainter.getInvalidateTick() + 1);
            }

            public void scheduleDrawable(@NotNull Drawable drawable, @NotNull Runnable runnable, long j11) {
                Intrinsics.checkNotNullParameter(drawable, "d");
                Intrinsics.checkNotNullParameter(runnable, "what");
                DrawablePainterKt.getMAIN_HANDLER().postAtTime(runnable, j11);
            }

            public void unscheduleDrawable(@NotNull Drawable drawable, @NotNull Runnable runnable) {
                Intrinsics.checkNotNullParameter(drawable, "d");
                Intrinsics.checkNotNullParameter(runnable, "what");
                DrawablePainterKt.getMAIN_HANDLER().removeCallbacks(runnable);
            }
        };
    }
}
