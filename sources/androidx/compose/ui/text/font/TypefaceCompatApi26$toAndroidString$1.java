package androidx.compose.ui.text.font;

import androidx.compose.ui.text.font.FontVariation;
import androidx.compose.ui.unit.Density;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\r\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "", "setting", "Landroidx/compose/ui/text/font/FontVariation$Setting;", "invoke"}, k = 3, mv = {1, 7, 1}, xi = 48)
public final class TypefaceCompatApi26$toAndroidString$1 extends Lambda implements Function1<FontVariation.Setting, CharSequence> {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ Density f10206g;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public TypefaceCompatApi26$toAndroidString$1(Density density) {
        super(1);
        this.f10206g = density;
    }

    @NotNull
    public final CharSequence invoke(@NotNull FontVariation.Setting setting) {
        Intrinsics.checkNotNullParameter(setting, "setting");
        return '\'' + setting.getAxisName() + "' " + setting.toVariationValue(this.f10206g);
    }
}
