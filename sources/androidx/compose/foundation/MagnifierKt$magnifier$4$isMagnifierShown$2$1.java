package androidx.compose.foundation;

import androidx.compose.runtime.State;
import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.geometry.OffsetKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;

@Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
public final class MagnifierKt$magnifier$4$isMagnifierShown$2$1 extends Lambda implements Function0<Boolean> {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ State<Offset> f1762g;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public MagnifierKt$magnifier$4$isMagnifierShown$2$1(State<Offset> state) {
        super(0);
        this.f1762g = state;
    }

    @NotNull
    public final Boolean invoke() {
        return Boolean.valueOf(OffsetKt.m2695isSpecifiedk4lQ0M(MagnifierKt$magnifier$4.m244invoke$lambda8(this.f1762g)));
    }
}
