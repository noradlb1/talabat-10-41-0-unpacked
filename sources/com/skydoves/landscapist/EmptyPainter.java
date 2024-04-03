package com.skydoves.landscapist;

import androidx.compose.ui.geometry.Size;
import androidx.compose.ui.graphics.drawscope.DrawScope;
import androidx.compose.ui.graphics.painter.Painter;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\bÀ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\t\u0010\nJ\f\u0010\u0004\u001a\u00020\u0003*\u00020\u0002H\u0014R\u001d\u0010\b\u001a\u00020\u00058VX\u0004ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\u0006\u001a\u0004\b\u0006\u0010\u0007\u0002\u000f\n\u0002\b\u0019\n\u0005\b¡\u001e0\u0001\n\u0002\b!¨\u0006\u000b"}, d2 = {"Lcom/skydoves/landscapist/EmptyPainter;", "Landroidx/compose/ui/graphics/painter/Painter;", "Landroidx/compose/ui/graphics/drawscope/DrawScope;", "", "d", "Landroidx/compose/ui/geometry/Size;", "getIntrinsicSize-NH-jbRc", "()J", "intrinsicSize", "<init>", "()V", "landscapist_release"}, k = 1, mv = {1, 5, 1})
public final class EmptyPainter extends Painter {
    @NotNull
    public static final EmptyPainter INSTANCE = new EmptyPainter();

    private EmptyPainter() {
    }

    public void d(@NotNull DrawScope drawScope) {
        Intrinsics.checkNotNullParameter(drawScope, "<this>");
    }

    /* renamed from: getIntrinsicSize-NH-jbRc  reason: not valid java name */
    public long m9394getIntrinsicSizeNHjbRc() {
        return Size.Companion.m2753getUnspecifiedNHjbRc();
    }
}
