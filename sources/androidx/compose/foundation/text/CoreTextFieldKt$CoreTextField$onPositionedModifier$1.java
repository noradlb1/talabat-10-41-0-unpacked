package androidx.compose.foundation.text;

import androidx.compose.foundation.text.selection.TextFieldSelectionManager;
import androidx.compose.foundation.text.selection.TextFieldSelectionManagerKt;
import androidx.compose.ui.layout.LayoutCoordinates;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;

@Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
public final class CoreTextFieldKt$CoreTextField$onPositionedModifier$1 extends Lambda implements Function1<LayoutCoordinates, Unit> {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ TextFieldState f3453g;

    /* renamed from: h  reason: collision with root package name */
    public final /* synthetic */ boolean f3454h;

    /* renamed from: i  reason: collision with root package name */
    public final /* synthetic */ TextFieldSelectionManager f3455i;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public CoreTextFieldKt$CoreTextField$onPositionedModifier$1(TextFieldState textFieldState, boolean z11, TextFieldSelectionManager textFieldSelectionManager) {
        super(1);
        this.f3453g = textFieldState;
        this.f3454h = z11;
        this.f3455i = textFieldSelectionManager;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((LayoutCoordinates) obj);
        return Unit.INSTANCE;
    }

    public final void invoke(@NotNull LayoutCoordinates layoutCoordinates) {
        Intrinsics.checkNotNullParameter(layoutCoordinates, "it");
        this.f3453g.setLayoutCoordinates(layoutCoordinates);
        if (this.f3454h) {
            if (this.f3453g.getHandleState() == HandleState.Selection) {
                if (this.f3453g.getShowFloatingToolbar()) {
                    this.f3455i.showSelectionToolbar$foundation_release();
                } else {
                    this.f3455i.hideSelectionToolbar$foundation_release();
                }
                this.f3453g.setShowSelectionHandleStart(TextFieldSelectionManagerKt.isSelectionHandleInVisibleBound(this.f3455i, true));
                this.f3453g.setShowSelectionHandleEnd(TextFieldSelectionManagerKt.isSelectionHandleInVisibleBound(this.f3455i, false));
            } else if (this.f3453g.getHandleState() == HandleState.Cursor) {
                this.f3453g.setShowCursorHandle(TextFieldSelectionManagerKt.isSelectionHandleInVisibleBound(this.f3455i, true));
            }
        }
        TextLayoutResultProxy layoutResult = this.f3453g.getLayoutResult();
        if (layoutResult != null) {
            layoutResult.setInnerTextFieldCoordinates(layoutCoordinates);
        }
    }
}
