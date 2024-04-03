package androidx.compose.material3.internal;

import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.unit.IntRect;
import com.huawei.hms.flutter.map.constants.Param;
import kotlin.Metadata;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\u0016\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\b\u0010\u0002\u001a\u0004\u0018\u00010\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\n¢\u0006\u0004\b\u0006\u0010\u0007"}, d2 = {"<anonymous>", "", "offset", "Landroidx/compose/ui/geometry/Offset;", "bounds", "Landroidx/compose/ui/unit/IntRect;", "invoke-KMgbckE", "(Landroidx/compose/ui/geometry/Offset;Landroidx/compose/ui/unit/IntRect;)Ljava/lang/Boolean;"}, k = 3, mv = {1, 7, 1}, xi = 48)
public final class PopupLayout$dismissOnOutsideClick$1 extends Lambda implements Function2<Offset, IntRect, Boolean> {
    public static final PopupLayout$dismissOnOutsideClick$1 INSTANCE = new PopupLayout$dismissOnOutsideClick$1();

    public PopupLayout$dismissOnOutsideClick$1() {
        super(2);
    }

    @NotNull
    /* renamed from: invoke-KMgbckE  reason: not valid java name */
    public final Boolean invoke(@Nullable Offset offset, @NotNull IntRect intRect) {
        Intrinsics.checkNotNullParameter(intRect, Param.BOUNDS);
        boolean z11 = false;
        if (offset != null && (Offset.m2676getXimpl(offset.m2686unboximpl()) < ((float) intRect.getLeft()) || Offset.m2676getXimpl(offset.m2686unboximpl()) > ((float) intRect.getRight()) || Offset.m2677getYimpl(offset.m2686unboximpl()) < ((float) intRect.getTop()) || Offset.m2677getYimpl(offset.m2686unboximpl()) > ((float) intRect.getBottom()))) {
            z11 = true;
        }
        return Boolean.valueOf(z11);
    }
}
