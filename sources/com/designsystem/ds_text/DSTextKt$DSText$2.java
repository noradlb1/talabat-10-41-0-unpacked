package com.designsystem.ds_text;

import android.content.Context;
import androidx.compose.runtime.Composable;
import androidx.compose.runtime.Composer;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.platform.AndroidCompositionLocals_androidKt;
import androidx.compose.ui.text.TextStyle;
import kotlin.Metadata;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(k = 3, mv = {1, 5, 1}, xi = 48)
public final class DSTextKt$DSText$2 extends Lambda implements Function3<Modifier, Composer, Integer, Modifier> {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ TextStyle f33109g;

    /* renamed from: h  reason: collision with root package name */
    public final /* synthetic */ float f33110h;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public DSTextKt$DSText$2(TextStyle textStyle, float f11) {
        super(3);
        this.f33109g = textStyle;
        this.f33110h = f11;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2, Object obj3) {
        return invoke((Modifier) obj, (Composer) obj2, ((Number) obj3).intValue());
    }

    @NotNull
    @Composable
    public final Modifier invoke(@NotNull Modifier modifier, @Nullable Composer composer, int i11) {
        Intrinsics.checkNotNullParameter(modifier, "$this$composed");
        composer.startReplaceableGroup(571698942);
        TextLayoutModifier textLayoutModifier = new TextLayoutModifier((Context) composer.consume(AndroidCompositionLocals_androidKt.getLocalContext()), this.f33109g, this.f33110h);
        composer.endReplaceableGroup();
        return textLayoutModifier;
    }
}
