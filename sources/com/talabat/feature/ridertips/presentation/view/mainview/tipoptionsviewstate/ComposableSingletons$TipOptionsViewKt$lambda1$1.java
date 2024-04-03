package com.talabat.feature.ridertips.presentation.view.mainview.tipoptionsviewstate;

import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.foundation.layout.SpacerKt;
import androidx.compose.foundation.lazy.LazyItemScope;
import androidx.compose.runtime.Composable;
import androidx.compose.runtime.ComposableTarget;
import androidx.compose.runtime.Composer;
import androidx.compose.ui.Modifier;
import com.designsystem.ds_theme.DSTheme;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u000b¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"<anonymous>", "", "Landroidx/compose/foundation/lazy/LazyItemScope;", "invoke", "(Landroidx/compose/foundation/lazy/LazyItemScope;Landroidx/compose/runtime/Composer;I)V"}, k = 3, mv = {1, 6, 0}, xi = 48)
/* renamed from: com.talabat.feature.ridertips.presentation.view.mainview.tipoptionsviewstate.ComposableSingletons$TipOptionsViewKt$lambda-1$1  reason: invalid class name */
public final class ComposableSingletons$TipOptionsViewKt$lambda1$1 extends Lambda implements Function3<LazyItemScope, Composer, Integer, Unit> {
    public static final ComposableSingletons$TipOptionsViewKt$lambda1$1 INSTANCE = new ComposableSingletons$TipOptionsViewKt$lambda1$1();

    public ComposableSingletons$TipOptionsViewKt$lambda1$1() {
        super(3);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2, Object obj3) {
        invoke((LazyItemScope) obj, (Composer) obj2, ((Number) obj3).intValue());
        return Unit.INSTANCE;
    }

    @ComposableTarget(applier = "androidx.compose.ui.UiComposable")
    @Composable
    public final void invoke(@NotNull LazyItemScope lazyItemScope, @Nullable Composer composer, int i11) {
        Intrinsics.checkNotNullParameter(lazyItemScope, "$this$item");
        if ((i11 & 81) != 16 || !composer.getSkipping()) {
            SpacerKt.Spacer(SizeKt.m563width3ABfNKs(Modifier.Companion, DSTheme.INSTANCE.getDimens(composer, 8).m8842getDsSD9Ej5fM()), composer, 0);
        } else {
            composer.skipToGroupEnd();
        }
    }
}
