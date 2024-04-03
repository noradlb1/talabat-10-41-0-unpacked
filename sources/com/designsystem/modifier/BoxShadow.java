package com.designsystem.modifier;

import android.content.Context;
import androidx.annotation.VisibleForTesting;
import androidx.compose.foundation.shape.RoundedCornerShape;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.draw.DrawModifier;
import androidx.compose.ui.graphics.drawscope.ContentDrawScope;
import com.designsystem.ds_box_shadow.BoxShadowDrawingKt;
import com.designsystem.ds_box_shadow.Shadow;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\b\u0001\u0018\u00002\u00020\u0001B#\u0012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\b¢\u0006\u0002\u0010\tJ\u0013\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\rH\u0002J\b\u0010\u000e\u001a\u00020\u000fH\u0016J\b\u0010\u0010\u001a\u00020\u0011H\u0016J\f\u0010\u0012\u001a\u00020\u0013*\u00020\u0014H\u0016R\u000e\u0010\u0007\u001a\u00020\bX\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0004¢\u0006\u0002\n\u0000¨\u0006\u0015"}, d2 = {"Lcom/designsystem/modifier/BoxShadow;", "Landroidx/compose/ui/draw/DrawModifier;", "shadows", "", "Lcom/designsystem/ds_box_shadow/Shadow;", "shape", "Landroidx/compose/foundation/shape/RoundedCornerShape;", "context", "Landroid/content/Context;", "(Ljava/util/List;Landroidx/compose/foundation/shape/RoundedCornerShape;Landroid/content/Context;)V", "equals", "", "other", "", "hashCode", "", "toString", "", "draw", "", "Landroidx/compose/ui/graphics/drawscope/ContentDrawScope;", "marshmallow_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
@VisibleForTesting
public final class BoxShadow implements DrawModifier {
    @NotNull
    private final Context context;
    @NotNull
    private final List<Shadow> shadows;
    @NotNull
    private final RoundedCornerShape shape;

    public BoxShadow(@NotNull List<Shadow> list, @NotNull RoundedCornerShape roundedCornerShape, @NotNull Context context2) {
        Intrinsics.checkNotNullParameter(list, "shadows");
        Intrinsics.checkNotNullParameter(roundedCornerShape, "shape");
        Intrinsics.checkNotNullParameter(context2, "context");
        this.shadows = list;
        this.shape = roundedCornerShape;
        this.context = context2;
    }

    public boolean all(@NotNull Function1<? super Modifier.Element, Boolean> function1) {
        return DrawModifier.DefaultImpls.all(this, function1);
    }

    public boolean any(@NotNull Function1<? super Modifier.Element, Boolean> function1) {
        return DrawModifier.DefaultImpls.any(this, function1);
    }

    public void draw(@NotNull ContentDrawScope contentDrawScope) {
        Intrinsics.checkNotNullParameter(contentDrawScope, "<this>");
        BoxShadowDrawingKt.drawBoxShadow(contentDrawScope, this.shadows, this.shape, this.context);
        contentDrawScope.drawContent();
    }

    public boolean equals(@Nullable Object obj) {
        BoxShadow boxShadow;
        if (obj instanceof BoxShadow) {
            boxShadow = (BoxShadow) obj;
        } else {
            boxShadow = null;
        }
        if (boxShadow != null && Intrinsics.areEqual((Object) this.shadows, (Object) boxShadow.shadows) && Intrinsics.areEqual((Object) this.shape, (Object) boxShadow.shape)) {
            return true;
        }
        return false;
    }

    public <R> R foldIn(R r11, @NotNull Function2<? super R, ? super Modifier.Element, ? extends R> function2) {
        return DrawModifier.DefaultImpls.foldIn(this, r11, function2);
    }

    public <R> R foldOut(R r11, @NotNull Function2<? super Modifier.Element, ? super R, ? extends R> function2) {
        return DrawModifier.DefaultImpls.foldOut(this, r11, function2);
    }

    public int hashCode() {
        return (this.shadows.hashCode() * 31) + this.shape.hashCode();
    }

    @NotNull
    public Modifier then(@NotNull Modifier modifier) {
        return DrawModifier.DefaultImpls.then(this, modifier);
    }

    @NotNull
    public String toString() {
        return "BoxShadow(shadows=" + this.shadows + ", shape=" + this.shape + ')';
    }
}
