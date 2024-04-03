package com.designsystem.ds_text_link;

import androidx.compose.runtime.Composable;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.Modifier;
import com.designsystem.ds_theme.DSThemeKt;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\u001a\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\u001a%\u0010\u0000\u001a\u00020\u00012\b\b\u0002\u0010\u0002\u001a\u00020\u00032\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005H\u0007¢\u0006\u0002\u0010\u0007¨\u0006\b"}, d2 = {"DSParagraphWithTextLinks", "", "modifier", "Landroidx/compose/ui/Modifier;", "texts", "", "Lcom/designsystem/ds_text_link/DSTextLinkText;", "(Landroidx/compose/ui/Modifier;Ljava/util/List;Landroidx/compose/runtime/Composer;II)V", "marshmallow_release"}, k = 2, mv = {1, 5, 1}, xi = 48)
public final class DSParagraphWithTextLinksKt {
    @Composable
    public static final void DSParagraphWithTextLinks(@Nullable Modifier modifier, @NotNull List<? extends DSTextLinkText> list, @Nullable Composer composer, int i11, int i12) {
        Intrinsics.checkNotNullParameter(list, "texts");
        Composer startRestartGroup = composer.startRestartGroup(1845923245);
        if ((i12 & 1) != 0) {
            modifier = Modifier.Companion;
        }
        DSThemeKt.DSTheme(ComposableLambdaKt.composableLambda(startRestartGroup, -819895471, true, new DSParagraphWithTextLinksKt$DSParagraphWithTextLinks$1(modifier, list, i11)), startRestartGroup, 6);
        ScopeUpdateScope endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new DSParagraphWithTextLinksKt$DSParagraphWithTextLinks$2(modifier, list, i11, i12));
        }
    }
}
