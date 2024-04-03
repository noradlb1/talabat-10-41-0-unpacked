package androidx.compose.ui.focus;

import androidx.compose.ui.ExperimentalComposeUiApi;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u001e\bf\u0018\u00002\u00020\u0001R\u0018\u0010\u0002\u001a\u00020\u0003X¦\u000e¢\u0006\f\u001a\u0004\b\u0004\u0010\u0005\"\u0004\b\u0006\u0010\u0007R$\u0010\n\u001a\u00020\t2\u0006\u0010\b\u001a\u00020\t8V@VX\u000e¢\u0006\f\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR$\u0010\u000f\u001a\u00020\t2\u0006\u0010\b\u001a\u00020\t8V@VX\u000e¢\u0006\f\u001a\u0004\b\u0010\u0010\f\"\u0004\b\u0011\u0010\u000eRE\u0010\u0014\u001a\u000e\u0012\u0004\u0012\u00020\u0013\u0012\u0004\u0012\u00020\t0\u00122\u0012\u0010\b\u001a\u000e\u0012\u0004\u0012\u00020\u0013\u0012\u0004\u0012\u00020\t0\u00128W@WX\u000eø\u0001\u0000¢\u0006\u0012\u0012\u0004\b\u0015\u0010\u0016\u001a\u0004\b\u0017\u0010\u0018\"\u0004\b\u0019\u0010\u001aRE\u0010\u001b\u001a\u000e\u0012\u0004\u0012\u00020\u0013\u0012\u0004\u0012\u00020\t0\u00122\u0012\u0010\b\u001a\u000e\u0012\u0004\u0012\u00020\u0013\u0012\u0004\u0012\u00020\t0\u00128W@WX\u000eø\u0001\u0000¢\u0006\u0012\u0012\u0004\b\u001c\u0010\u0016\u001a\u0004\b\u001d\u0010\u0018\"\u0004\b\u001e\u0010\u001aR$\u0010\u001f\u001a\u00020\t2\u0006\u0010\b\u001a\u00020\t8V@VX\u000e¢\u0006\f\u001a\u0004\b \u0010\f\"\u0004\b!\u0010\u000eR$\u0010\"\u001a\u00020\t2\u0006\u0010\b\u001a\u00020\t8V@VX\u000e¢\u0006\f\u001a\u0004\b#\u0010\f\"\u0004\b$\u0010\u000eR$\u0010%\u001a\u00020\t2\u0006\u0010\b\u001a\u00020\t8V@VX\u000e¢\u0006\f\u001a\u0004\b&\u0010\f\"\u0004\b'\u0010\u000eR$\u0010(\u001a\u00020\t2\u0006\u0010\b\u001a\u00020\t8V@VX\u000e¢\u0006\f\u001a\u0004\b)\u0010\f\"\u0004\b*\u0010\u000eR$\u0010+\u001a\u00020\t2\u0006\u0010\b\u001a\u00020\t8V@VX\u000e¢\u0006\f\u001a\u0004\b,\u0010\f\"\u0004\b-\u0010\u000eR$\u0010.\u001a\u00020\t2\u0006\u0010\b\u001a\u00020\t8V@VX\u000e¢\u0006\f\u001a\u0004\b/\u0010\f\"\u0004\b0\u0010\u000eø\u0001\u0001\u0002\n\n\u0002\b\u0019\n\u0004\b!0\u0001¨\u00061À\u0006\u0001"}, d2 = {"Landroidx/compose/ui/focus/FocusProperties;", "", "canFocus", "", "getCanFocus", "()Z", "setCanFocus", "(Z)V", "<anonymous parameter 0>", "Landroidx/compose/ui/focus/FocusRequester;", "down", "getDown", "()Landroidx/compose/ui/focus/FocusRequester;", "setDown", "(Landroidx/compose/ui/focus/FocusRequester;)V", "end", "getEnd", "setEnd", "Lkotlin/Function1;", "Landroidx/compose/ui/focus/FocusDirection;", "enter", "getEnter$annotations", "()V", "getEnter", "()Lkotlin/jvm/functions/Function1;", "setEnter", "(Lkotlin/jvm/functions/Function1;)V", "exit", "getExit$annotations", "getExit", "setExit", "left", "getLeft", "setLeft", "next", "getNext", "setNext", "previous", "getPrevious", "setPrevious", "right", "getRight", "setRight", "start", "getStart", "setStart", "up", "getUp", "setUp", "ui_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public interface FocusProperties {

    /* renamed from: androidx.compose.ui.focus.FocusProperties$-CC  reason: invalid class name */
    public final /* synthetic */ class CC {
        @NotNull
        public static FocusRequester a(FocusProperties focusProperties) {
            return FocusRequester.Companion.getDefault();
        }

        @NotNull
        public static FocusRequester b(FocusProperties focusProperties) {
            return FocusRequester.Companion.getDefault();
        }

        @ExperimentalComposeUiApi
        @NotNull
        public static Function1 c(FocusProperties focusProperties) {
            return FocusProperties$enter$1.INSTANCE;
        }

        @ExperimentalComposeUiApi
        @NotNull
        public static Function1 d(FocusProperties focusProperties) {
            return FocusProperties$exit$1.INSTANCE;
        }

        @NotNull
        public static FocusRequester e(FocusProperties focusProperties) {
            return FocusRequester.Companion.getDefault();
        }

        @NotNull
        public static FocusRequester f(FocusProperties focusProperties) {
            return FocusRequester.Companion.getDefault();
        }

        @NotNull
        public static FocusRequester g(FocusProperties focusProperties) {
            return FocusRequester.Companion.getDefault();
        }

        @NotNull
        public static FocusRequester h(FocusProperties focusProperties) {
            return FocusRequester.Companion.getDefault();
        }

        @NotNull
        public static FocusRequester i(FocusProperties focusProperties) {
            return FocusRequester.Companion.getDefault();
        }

        @NotNull
        public static FocusRequester j(FocusProperties focusProperties) {
            return FocusRequester.Companion.getDefault();
        }

        public static void k(FocusProperties focusProperties, @NotNull FocusRequester focusRequester) {
            Intrinsics.checkNotNullParameter(focusRequester, "<anonymous parameter 0>");
        }

        public static void l(FocusProperties focusProperties, @NotNull FocusRequester focusRequester) {
            Intrinsics.checkNotNullParameter(focusRequester, "<anonymous parameter 0>");
        }

        @ExperimentalComposeUiApi
        public static void m(FocusProperties focusProperties, @NotNull Function1 function1) {
            Intrinsics.checkNotNullParameter(function1, "<anonymous parameter 0>");
        }

        @ExperimentalComposeUiApi
        public static void n(FocusProperties focusProperties, @NotNull Function1 function1) {
            Intrinsics.checkNotNullParameter(function1, "<anonymous parameter 0>");
        }

        public static void o(FocusProperties focusProperties, @NotNull FocusRequester focusRequester) {
            Intrinsics.checkNotNullParameter(focusRequester, "<anonymous parameter 0>");
        }

        public static void p(FocusProperties focusProperties, @NotNull FocusRequester focusRequester) {
            Intrinsics.checkNotNullParameter(focusRequester, "<anonymous parameter 0>");
        }

        public static void q(FocusProperties focusProperties, @NotNull FocusRequester focusRequester) {
            Intrinsics.checkNotNullParameter(focusRequester, "<anonymous parameter 0>");
        }

        public static void r(FocusProperties focusProperties, @NotNull FocusRequester focusRequester) {
            Intrinsics.checkNotNullParameter(focusRequester, "<anonymous parameter 0>");
        }

        public static void s(FocusProperties focusProperties, @NotNull FocusRequester focusRequester) {
            Intrinsics.checkNotNullParameter(focusRequester, "<anonymous parameter 0>");
        }

        public static void t(FocusProperties focusProperties, @NotNull FocusRequester focusRequester) {
            Intrinsics.checkNotNullParameter(focusRequester, "<anonymous parameter 0>");
        }

        @ExperimentalComposeUiApi
        public static /* synthetic */ void u() {
        }

        @ExperimentalComposeUiApi
        public static /* synthetic */ void v() {
        }
    }

    boolean getCanFocus();

    @NotNull
    FocusRequester getDown();

    @NotNull
    FocusRequester getEnd();

    @ExperimentalComposeUiApi
    @NotNull
    Function1<FocusDirection, FocusRequester> getEnter();

    @ExperimentalComposeUiApi
    @NotNull
    Function1<FocusDirection, FocusRequester> getExit();

    @NotNull
    FocusRequester getLeft();

    @NotNull
    FocusRequester getNext();

    @NotNull
    FocusRequester getPrevious();

    @NotNull
    FocusRequester getRight();

    @NotNull
    FocusRequester getStart();

    @NotNull
    FocusRequester getUp();

    void setCanFocus(boolean z11);

    void setDown(@NotNull FocusRequester focusRequester);

    void setEnd(@NotNull FocusRequester focusRequester);

    @ExperimentalComposeUiApi
    void setEnter(@NotNull Function1<? super FocusDirection, FocusRequester> function1);

    @ExperimentalComposeUiApi
    void setExit(@NotNull Function1<? super FocusDirection, FocusRequester> function1);

    void setLeft(@NotNull FocusRequester focusRequester);

    void setNext(@NotNull FocusRequester focusRequester);

    void setPrevious(@NotNull FocusRequester focusRequester);

    void setRight(@NotNull FocusRequester focusRequester);

    void setStart(@NotNull FocusRequester focusRequester);

    void setUp(@NotNull FocusRequester focusRequester);
}
