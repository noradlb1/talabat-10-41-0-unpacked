package androidx.compose.ui.focus;

import androidx.compose.ui.focus.FocusRequester;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u001c\b\u0000\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002R\u001a\u0010\u0003\u001a\u00020\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u001a\u0010\t\u001a\u00020\nX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\u001a\u0010\u000f\u001a\u00020\nX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\f\"\u0004\b\u0011\u0010\u000eR/\u0010\u0012\u001a\u000e\u0012\u0004\u0012\u00020\u0014\u0012\u0004\u0012\u00020\n0\u0013X\u000eø\u0001\u0000¢\u0006\u0014\n\u0000\u0012\u0004\b\u0015\u0010\u0002\u001a\u0004\b\u0016\u0010\u0017\"\u0004\b\u0018\u0010\u0019R/\u0010\u001a\u001a\u000e\u0012\u0004\u0012\u00020\u0014\u0012\u0004\u0012\u00020\n0\u0013X\u000eø\u0001\u0000¢\u0006\u0014\n\u0000\u0012\u0004\b\u001b\u0010\u0002\u001a\u0004\b\u001c\u0010\u0017\"\u0004\b\u001d\u0010\u0019R\u001a\u0010\u001e\u001a\u00020\nX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001f\u0010\f\"\u0004\b \u0010\u000eR\u001a\u0010!\u001a\u00020\nX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\"\u0010\f\"\u0004\b#\u0010\u000eR\u001a\u0010$\u001a\u00020\nX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b%\u0010\f\"\u0004\b&\u0010\u000eR\u001a\u0010'\u001a\u00020\nX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b(\u0010\f\"\u0004\b)\u0010\u000eR\u001a\u0010*\u001a\u00020\nX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b+\u0010\f\"\u0004\b,\u0010\u000eR\u001a\u0010-\u001a\u00020\nX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b.\u0010\f\"\u0004\b/\u0010\u000e\u0002\u0004\n\u0002\b\u0019¨\u00060"}, d2 = {"Landroidx/compose/ui/focus/FocusPropertiesImpl;", "Landroidx/compose/ui/focus/FocusProperties;", "()V", "canFocus", "", "getCanFocus", "()Z", "setCanFocus", "(Z)V", "down", "Landroidx/compose/ui/focus/FocusRequester;", "getDown", "()Landroidx/compose/ui/focus/FocusRequester;", "setDown", "(Landroidx/compose/ui/focus/FocusRequester;)V", "end", "getEnd", "setEnd", "enter", "Lkotlin/Function1;", "Landroidx/compose/ui/focus/FocusDirection;", "getEnter$annotations", "getEnter", "()Lkotlin/jvm/functions/Function1;", "setEnter", "(Lkotlin/jvm/functions/Function1;)V", "exit", "getExit$annotations", "getExit", "setExit", "left", "getLeft", "setLeft", "next", "getNext", "setNext", "previous", "getPrevious", "setPrevious", "right", "getRight", "setRight", "start", "getStart", "setStart", "up", "getUp", "setUp", "ui_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class FocusPropertiesImpl implements FocusProperties {
    private boolean canFocus = true;
    @NotNull
    private FocusRequester down;
    @NotNull
    private FocusRequester end;
    @NotNull
    private Function1<? super FocusDirection, FocusRequester> enter;
    @NotNull
    private Function1<? super FocusDirection, FocusRequester> exit;
    @NotNull
    private FocusRequester left;
    @NotNull
    private FocusRequester next;
    @NotNull
    private FocusRequester previous;
    @NotNull
    private FocusRequester right;
    @NotNull
    private FocusRequester start;
    @NotNull

    /* renamed from: up  reason: collision with root package name */
    private FocusRequester f9597up;

    public FocusPropertiesImpl() {
        FocusRequester.Companion companion = FocusRequester.Companion;
        this.next = companion.getDefault();
        this.previous = companion.getDefault();
        this.f9597up = companion.getDefault();
        this.down = companion.getDefault();
        this.left = companion.getDefault();
        this.right = companion.getDefault();
        this.start = companion.getDefault();
        this.end = companion.getDefault();
        this.enter = FocusPropertiesImpl$enter$1.INSTANCE;
        this.exit = FocusPropertiesImpl$exit$1.INSTANCE;
    }

    public static /* synthetic */ void getEnter$annotations() {
    }

    public static /* synthetic */ void getExit$annotations() {
    }

    public boolean getCanFocus() {
        return this.canFocus;
    }

    @NotNull
    public FocusRequester getDown() {
        return this.down;
    }

    @NotNull
    public FocusRequester getEnd() {
        return this.end;
    }

    @NotNull
    public Function1<FocusDirection, FocusRequester> getEnter() {
        return this.enter;
    }

    @NotNull
    public Function1<FocusDirection, FocusRequester> getExit() {
        return this.exit;
    }

    @NotNull
    public FocusRequester getLeft() {
        return this.left;
    }

    @NotNull
    public FocusRequester getNext() {
        return this.next;
    }

    @NotNull
    public FocusRequester getPrevious() {
        return this.previous;
    }

    @NotNull
    public FocusRequester getRight() {
        return this.right;
    }

    @NotNull
    public FocusRequester getStart() {
        return this.start;
    }

    @NotNull
    public FocusRequester getUp() {
        return this.f9597up;
    }

    public void setCanFocus(boolean z11) {
        this.canFocus = z11;
    }

    public void setDown(@NotNull FocusRequester focusRequester) {
        Intrinsics.checkNotNullParameter(focusRequester, "<set-?>");
        this.down = focusRequester;
    }

    public void setEnd(@NotNull FocusRequester focusRequester) {
        Intrinsics.checkNotNullParameter(focusRequester, "<set-?>");
        this.end = focusRequester;
    }

    public void setEnter(@NotNull Function1<? super FocusDirection, FocusRequester> function1) {
        Intrinsics.checkNotNullParameter(function1, "<set-?>");
        this.enter = function1;
    }

    public void setExit(@NotNull Function1<? super FocusDirection, FocusRequester> function1) {
        Intrinsics.checkNotNullParameter(function1, "<set-?>");
        this.exit = function1;
    }

    public void setLeft(@NotNull FocusRequester focusRequester) {
        Intrinsics.checkNotNullParameter(focusRequester, "<set-?>");
        this.left = focusRequester;
    }

    public void setNext(@NotNull FocusRequester focusRequester) {
        Intrinsics.checkNotNullParameter(focusRequester, "<set-?>");
        this.next = focusRequester;
    }

    public void setPrevious(@NotNull FocusRequester focusRequester) {
        Intrinsics.checkNotNullParameter(focusRequester, "<set-?>");
        this.previous = focusRequester;
    }

    public void setRight(@NotNull FocusRequester focusRequester) {
        Intrinsics.checkNotNullParameter(focusRequester, "<set-?>");
        this.right = focusRequester;
    }

    public void setStart(@NotNull FocusRequester focusRequester) {
        Intrinsics.checkNotNullParameter(focusRequester, "<set-?>");
        this.start = focusRequester;
    }

    public void setUp(@NotNull FocusRequester focusRequester) {
        Intrinsics.checkNotNullParameter(focusRequester, "<set-?>");
        this.f9597up = focusRequester;
    }
}
