package com.designsystem.extensions;

import android.view.animation.Animation;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u0014\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a<\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\u000e\b\u0002\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00010\u00042\u000e\b\u0002\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00010\u00042\u000e\b\u0002\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00010\u0004H\u0000¨\u0006\u0007"}, d2 = {"onAnimation", "", "Landroid/view/animation/Animation;", "start", "Lkotlin/Function0;", "end", "repeat", "marshmallow_release"}, k = 2, mv = {1, 5, 1}, xi = 48)
public final class AnimationExtensionsKt {
    public static final void onAnimation(@NotNull Animation animation, @NotNull Function0<Unit> function0, @NotNull Function0<Unit> function02, @NotNull Function0<Unit> function03) {
        Intrinsics.checkNotNullParameter(animation, "<this>");
        Intrinsics.checkNotNullParameter(function0, "start");
        Intrinsics.checkNotNullParameter(function02, TtmlNode.END);
        Intrinsics.checkNotNullParameter(function03, "repeat");
        animation.setAnimationListener(new AnimationExtensionsKt$onAnimation$4(function0, function02, function03));
    }

    public static /* synthetic */ void onAnimation$default(Animation animation, Function0 function0, Function0 function02, Function0 function03, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            function0 = AnimationExtensionsKt$onAnimation$1.INSTANCE;
        }
        if ((i11 & 2) != 0) {
            function02 = AnimationExtensionsKt$onAnimation$2.INSTANCE;
        }
        if ((i11 & 4) != 0) {
            function03 = AnimationExtensionsKt$onAnimation$3.INSTANCE;
        }
        onAnimation(animation, function0, function02, function03);
    }
}
