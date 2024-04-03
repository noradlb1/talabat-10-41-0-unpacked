package androidx.compose.material3.tokens;

import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0000\bÀ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006R\u000e\u0010\u0007\u001a\u00020\bXT¢\u0006\u0002\n\u0000¨\u0006\t"}, d2 = {"Landroidx/compose/material3/tokens/ScrimTokens;", "", "()V", "ContainerColor", "Landroidx/compose/material3/tokens/ColorSchemeKeyTokens;", "getContainerColor", "()Landroidx/compose/material3/tokens/ColorSchemeKeyTokens;", "ContainerOpacity", "", "material3_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class ScrimTokens {
    @NotNull
    private static final ColorSchemeKeyTokens ContainerColor = ColorSchemeKeyTokens.Scrim;
    public static final float ContainerOpacity = 0.32f;
    @NotNull
    public static final ScrimTokens INSTANCE = new ScrimTokens();

    private ScrimTokens() {
    }

    @NotNull
    public final ColorSchemeKeyTokens getContainerColor() {
        return ContainerColor;
    }
}
