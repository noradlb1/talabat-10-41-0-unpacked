package com.designsystem.ds_navigation_bar;

import android.view.View;
import androidx.compose.runtime.Composable;
import androidx.compose.runtime.Composer;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.viewinterop.AndroidView_androidKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\u0006\n\u0002\u0010\u0002\n\u0000\u0010\u0001\u001a\u00020\u0000H\u000b"}, d2 = {"", "<anonymous>"}, k = 3, mv = {1, 5, 1})
public final class DSNavigationBar$createTrailingContainerComposable$1 extends Lambda implements Function2<Composer, Integer, Unit> {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ View f32383g;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public DSNavigationBar$createTrailingContainerComposable$1(View view) {
        super(2);
        this.f32383g = view;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
        invoke((Composer) obj, ((Number) obj2).intValue());
        return Unit.INSTANCE;
    }

    @Composable
    public final void invoke(@Nullable Composer composer, int i11) {
        if (((i11 & 11) ^ 2) != 0 || !composer.getSkipping()) {
            View view = this.f32383g;
            if (view == null) {
                composer.startReplaceableGroup(311459795);
            } else {
                composer.startReplaceableGroup(-128500242);
                AndroidView_androidKt.AndroidView(new DSNavigationBar$createTrailingContainerComposable$1$1$1(view), (Modifier) null, (Function1) null, composer, 0, 6);
            }
            composer.endReplaceableGroup();
            return;
        }
        composer.skipToGroupEnd();
    }
}
