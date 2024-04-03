package com.designsystem.ds_text_link;

import androidx.compose.runtime.Composable;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.Immutable;
import androidx.compose.runtime.SnapshotStateKt;
import androidx.compose.runtime.State;
import androidx.compose.ui.graphics.Color;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Immutable
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\b\u0001\u0018\u00002\u00020\u0001B\u0018\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003ø\u0001\u0000¢\u0006\u0002\u0010\u0005J\u001e\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00030\b2\u0006\u0010\t\u001a\u00020\nH\u0017ø\u0001\u0000¢\u0006\u0002\u0010\u000bR\u0019\u0010\u0004\u001a\u00020\u0003X\u0004ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\u0004\n\u0002\u0010\u0006R\u0019\u0010\u0002\u001a\u00020\u0003X\u0004ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\u0004\n\u0002\u0010\u0006\u0002\u000f\n\u0002\b\u0019\n\u0005\b¡\u001e0\u0001\n\u0002\b!¨\u0006\f"}, d2 = {"Lcom/designsystem/ds_text_link/DSDefaultTextLinkTheme;", "Lcom/designsystem/ds_text_link/DSTextLinkTheme;", "textColor", "Landroidx/compose/ui/graphics/Color;", "disabledTextColor", "(JJLkotlin/jvm/internal/DefaultConstructorMarker;)V", "J", "color", "Landroidx/compose/runtime/State;", "isEnabled", "", "(ZLandroidx/compose/runtime/Composer;I)Landroidx/compose/runtime/State;", "marshmallow_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
public final class DSDefaultTextLinkTheme implements DSTextLinkTheme {
    private final long disabledTextColor;
    private final long textColor;

    private DSDefaultTextLinkTheme(long j11, long j12) {
        this.textColor = j11;
        this.disabledTextColor = j12;
    }

    public /* synthetic */ DSDefaultTextLinkTheme(long j11, long j12, DefaultConstructorMarker defaultConstructorMarker) {
        this(j11, j12);
    }

    @NotNull
    @Composable
    public State<Color> color(boolean z11, @Nullable Composer composer, int i11) {
        long j11;
        composer.startReplaceableGroup(-287608219);
        if (!z11) {
            j11 = this.disabledTextColor;
        } else {
            j11 = this.textColor;
        }
        State<Color> rememberUpdatedState = SnapshotStateKt.rememberUpdatedState(Color.m2909boximpl(j11), composer, 0);
        composer.endReplaceableGroup();
        return rememberUpdatedState;
    }
}
