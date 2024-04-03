package androidx.compose.ui.text.font;

import androidx.compose.runtime.Immutable;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Immutable
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\b\u0007\u0018\u00002\u00020\u0001B\u0017\b\u0000\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0002\u0010\u0005J\b\u0010\b\u001a\u00020\u0003H\u0016R\u000e\u0010\u0004\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\t"}, d2 = {"Landroidx/compose/ui/text/font/GenericFontFamily;", "Landroidx/compose/ui/text/font/SystemFontFamily;", "name", "", "fontFamilyName", "(Ljava/lang/String;Ljava/lang/String;)V", "getName", "()Ljava/lang/String;", "toString", "ui-text_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class GenericFontFamily extends SystemFontFamily {
    @NotNull
    private final String fontFamilyName;
    @NotNull

    /* renamed from: name  reason: collision with root package name */
    private final String f10204name;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public GenericFontFamily(@NotNull String str, @NotNull String str2) {
        super((DefaultConstructorMarker) null);
        Intrinsics.checkNotNullParameter(str, "name");
        Intrinsics.checkNotNullParameter(str2, "fontFamilyName");
        this.f10204name = str;
        this.fontFamilyName = str2;
    }

    @NotNull
    public final String getName() {
        return this.f10204name;
    }

    @NotNull
    public String toString() {
        return this.fontFamilyName;
    }
}
