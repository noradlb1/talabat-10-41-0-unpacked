package com.designsystem.ds_text_link;

import androidx.compose.runtime.Composable;
import androidx.compose.runtime.Composer;
import com.designsystem.ds_theme.DSTheme;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÀ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\r\u0010\u0003\u001a\u00020\u0004H\u0007¢\u0006\u0002\u0010\u0005J\r\u0010\u0006\u001a\u00020\u0004H\u0007¢\u0006\u0002\u0010\u0005¨\u0006\u0007"}, d2 = {"Lcom/designsystem/ds_text_link/DSTextLinkDefaults;", "", "()V", "alternativeTextLinkTheme", "Lcom/designsystem/ds_text_link/DSDefaultTextLinkTheme;", "(Landroidx/compose/runtime/Composer;I)Lcom/designsystem/ds_text_link/DSDefaultTextLinkTheme;", "textLinkTheme", "marshmallow_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
public final class DSTextLinkDefaults {
    @NotNull
    public static final DSTextLinkDefaults INSTANCE = new DSTextLinkDefaults();

    private DSTextLinkDefaults() {
    }

    @NotNull
    @Composable
    public final DSDefaultTextLinkTheme alternativeTextLinkTheme(@Nullable Composer composer, int i11) {
        composer.startReplaceableGroup(1160632208);
        DSTheme dSTheme = DSTheme.INSTANCE;
        DSDefaultTextLinkTheme dSDefaultTextLinkTheme = new DSDefaultTextLinkTheme(dSTheme.getColors(composer, 0).m8771getDsNeutral700d7_KjU(), dSTheme.getColors(composer, 0).m8764getDsNeutral350d7_KjU(), (DefaultConstructorMarker) null);
        composer.endReplaceableGroup();
        return dSDefaultTextLinkTheme;
    }

    @NotNull
    @Composable
    public final DSDefaultTextLinkTheme textLinkTheme(@Nullable Composer composer, int i11) {
        composer.startReplaceableGroup(-1503357150);
        DSTheme dSTheme = DSTheme.INSTANCE;
        DSDefaultTextLinkTheme dSDefaultTextLinkTheme = new DSDefaultTextLinkTheme(dSTheme.getColors(composer, 0).m8793getDsPrimary1000d7_KjU(), dSTheme.getColors(composer, 0).m8794getDsPrimary300d7_KjU(), (DefaultConstructorMarker) null);
        composer.endReplaceableGroup();
        return dSDefaultTextLinkTheme;
    }
}
