package com.designsystem.modifier;

import android.content.Context;
import androidx.compose.foundation.shape.RoundedCornerShape;
import androidx.compose.runtime.Composable;
import androidx.compose.runtime.Composer;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.platform.AndroidCompositionLocals_androidKt;
import com.designsystem.ds_box_shadow.Shadow;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\u0006\n\u0002\u0018\u0002\n\u0000\u0010\u0001\u001a\u00020\u0000*\u00020\u0000H\u000b"}, d2 = {"Landroidx/compose/ui/Modifier;", "<anonymous>"}, k = 3, mv = {1, 5, 1})
public final class BoxShadowKt$boxShadow$2 extends Lambda implements Function3<Modifier, Composer, Integer, Modifier> {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ List<Shadow> f33552g;

    /* renamed from: h  reason: collision with root package name */
    public final /* synthetic */ RoundedCornerShape f33553h;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public BoxShadowKt$boxShadow$2(List<Shadow> list, RoundedCornerShape roundedCornerShape) {
        super(3);
        this.f33552g = list;
        this.f33553h = roundedCornerShape;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2, Object obj3) {
        return invoke((Modifier) obj, (Composer) obj2, ((Number) obj3).intValue());
    }

    @NotNull
    @Composable
    public final Modifier invoke(@NotNull Modifier modifier, @Nullable Composer composer, int i11) {
        Intrinsics.checkNotNullParameter(modifier, "$this$composed");
        composer.startReplaceableGroup(-495701732);
        Modifier then = modifier.then(new BoxShadow(this.f33552g, this.f33553h, (Context) composer.consume(AndroidCompositionLocals_androidKt.getLocalContext())));
        composer.endReplaceableGroup();
        return then;
    }
}
