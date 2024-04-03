package androidx.compose.ui.input.pointer;

import android.view.MotionEvent;
import androidx.compose.ui.viewinterop.AndroidViewHolder;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"<anonymous>", "", "motionEvent", "Landroid/view/MotionEvent;", "invoke", "(Landroid/view/MotionEvent;)Ljava/lang/Boolean;"}, k = 3, mv = {1, 7, 1}, xi = 48)
public final class PointerInteropFilter_androidKt$pointerInteropFilter$3 extends Lambda implements Function1<MotionEvent, Boolean> {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ AndroidViewHolder f9800g;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public PointerInteropFilter_androidKt$pointerInteropFilter$3(AndroidViewHolder androidViewHolder) {
        super(1);
        this.f9800g = androidViewHolder;
    }

    @NotNull
    public final Boolean invoke(@NotNull MotionEvent motionEvent) {
        boolean z11;
        Intrinsics.checkNotNullParameter(motionEvent, "motionEvent");
        switch (motionEvent.getActionMasked()) {
            case 0:
            case 1:
            case 2:
            case 3:
            case 4:
            case 5:
            case 6:
                z11 = this.f9800g.dispatchTouchEvent(motionEvent);
                break;
            default:
                z11 = this.f9800g.dispatchGenericMotionEvent(motionEvent);
                break;
        }
        return Boolean.valueOf(z11);
    }
}
