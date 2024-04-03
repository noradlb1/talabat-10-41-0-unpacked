package androidx.compose.ui.layout;

import kotlin.Metadata;
import kotlin.jvm.JvmInline;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\bf\u0018\u00002\u00020\u0001:\u0002\f\rJ@\u0010\u0002\u001a\u0004\u0018\u0001H\u0003\"\u0004\b\u0000\u0010\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0019\u0010\u0006\u001a\u0015\u0012\u0004\u0012\u00020\b\u0012\u0006\u0012\u0004\u0018\u0001H\u00030\u0007¢\u0006\u0002\b\tH&ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\n\u0010\u000bø\u0001\u0002\u0002\u0011\n\u0005\b¡\u001e0\u0001\n\u0002\b\u0019\n\u0004\b!0\u0001¨\u0006\u000eÀ\u0006\u0001"}, d2 = {"Landroidx/compose/ui/layout/BeyondBoundsLayout;", "", "layout", "T", "direction", "Landroidx/compose/ui/layout/BeyondBoundsLayout$LayoutDirection;", "block", "Lkotlin/Function1;", "Landroidx/compose/ui/layout/BeyondBoundsLayout$BeyondBoundsScope;", "Lkotlin/ExtensionFunctionType;", "layout-o7g1Pn8", "(ILkotlin/jvm/functions/Function1;)Ljava/lang/Object;", "BeyondBoundsScope", "LayoutDirection", "ui_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public interface BeyondBoundsLayout {

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001R\u0012\u0010\u0002\u001a\u00020\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0004\u0010\u0005ø\u0001\u0000\u0002\u0006\n\u0004\b!0\u0001¨\u0006\u0006À\u0006\u0001"}, d2 = {"Landroidx/compose/ui/layout/BeyondBoundsLayout$BeyondBoundsScope;", "", "hasMoreContent", "", "getHasMoreContent", "()Z", "ui_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public interface BeyondBoundsScope {
        boolean getHasMoreContent();
    }

    @JvmInline
    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\u0004\b@\u0018\u0000 \u00112\u00020\u0001:\u0001\u0011B\u0014\b\u0000\u0012\u0006\u0010\u0002\u001a\u00020\u0003ø\u0001\u0000¢\u0006\u0004\b\u0004\u0010\u0005J\u001a\u0010\u0006\u001a\u00020\u00072\b\u0010\b\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\t\u0010\nJ\u0010\u0010\u000b\u001a\u00020\u0003HÖ\u0001¢\u0006\u0004\b\f\u0010\u0005J\u000f\u0010\r\u001a\u00020\u000eH\u0016¢\u0006\u0004\b\u000f\u0010\u0010R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000\u0001\u0002\u0001\u00020\u0003ø\u0001\u0000\u0002\u0004\n\u0002\b\u0019¨\u0006\u0012"}, d2 = {"Landroidx/compose/ui/layout/BeyondBoundsLayout$LayoutDirection;", "", "value", "", "constructor-impl", "(I)I", "equals", "", "other", "equals-impl", "(ILjava/lang/Object;)Z", "hashCode", "hashCode-impl", "toString", "", "toString-impl", "(I)Ljava/lang/String;", "Companion", "ui_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public static final class LayoutDirection {
        /* access modifiers changed from: private */
        public static final int Above = m4429constructorimpl(5);
        /* access modifiers changed from: private */
        public static final int After = m4429constructorimpl(2);
        /* access modifiers changed from: private */
        public static final int Before = m4429constructorimpl(1);
        /* access modifiers changed from: private */
        public static final int Below = m4429constructorimpl(6);
        @NotNull
        public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
        /* access modifiers changed from: private */
        public static final int Left = m4429constructorimpl(3);
        /* access modifiers changed from: private */
        public static final int Right = m4429constructorimpl(4);
        private final int value;

        @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000e\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u001c\u0010\u0003\u001a\u00020\u0004ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\n\n\u0002\u0010\u0007\u001a\u0004\b\u0005\u0010\u0006R\u001c\u0010\b\u001a\u00020\u0004ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\n\n\u0002\u0010\u0007\u001a\u0004\b\t\u0010\u0006R\u001c\u0010\n\u001a\u00020\u0004ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\n\n\u0002\u0010\u0007\u001a\u0004\b\u000b\u0010\u0006R\u001c\u0010\f\u001a\u00020\u0004ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\n\n\u0002\u0010\u0007\u001a\u0004\b\r\u0010\u0006R\u001c\u0010\u000e\u001a\u00020\u0004ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\n\n\u0002\u0010\u0007\u001a\u0004\b\u000f\u0010\u0006R\u001c\u0010\u0010\u001a\u00020\u0004ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\n\n\u0002\u0010\u0007\u001a\u0004\b\u0011\u0010\u0006\u0002\u000f\n\u0002\b\u0019\n\u0005\b¡\u001e0\u0001\n\u0002\b!¨\u0006\u0012"}, d2 = {"Landroidx/compose/ui/layout/BeyondBoundsLayout$LayoutDirection$Companion;", "", "()V", "Above", "Landroidx/compose/ui/layout/BeyondBoundsLayout$LayoutDirection;", "getAbove-hoxUOeE", "()I", "I", "After", "getAfter-hoxUOeE", "Before", "getBefore-hoxUOeE", "Below", "getBelow-hoxUOeE", "Left", "getLeft-hoxUOeE", "Right", "getRight-hoxUOeE", "ui_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
        public static final class Companion {
            private Companion() {
            }

            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            /* renamed from: getAbove-hoxUOeE  reason: not valid java name */
            public final int m4435getAbovehoxUOeE() {
                return LayoutDirection.Above;
            }

            /* renamed from: getAfter-hoxUOeE  reason: not valid java name */
            public final int m4436getAfterhoxUOeE() {
                return LayoutDirection.After;
            }

            /* renamed from: getBefore-hoxUOeE  reason: not valid java name */
            public final int m4437getBeforehoxUOeE() {
                return LayoutDirection.Before;
            }

            /* renamed from: getBelow-hoxUOeE  reason: not valid java name */
            public final int m4438getBelowhoxUOeE() {
                return LayoutDirection.Below;
            }

            /* renamed from: getLeft-hoxUOeE  reason: not valid java name */
            public final int m4439getLefthoxUOeE() {
                return LayoutDirection.Left;
            }

            /* renamed from: getRight-hoxUOeE  reason: not valid java name */
            public final int m4440getRighthoxUOeE() {
                return LayoutDirection.Right;
            }
        }

        private /* synthetic */ LayoutDirection(int i11) {
            this.value = i11;
        }

        /* renamed from: box-impl  reason: not valid java name */
        public static final /* synthetic */ LayoutDirection m4428boximpl(int i11) {
            return new LayoutDirection(i11);
        }

        /* renamed from: constructor-impl  reason: not valid java name */
        public static int m4429constructorimpl(int i11) {
            return i11;
        }

        /* renamed from: equals-impl  reason: not valid java name */
        public static boolean m4430equalsimpl(int i11, Object obj) {
            return (obj instanceof LayoutDirection) && i11 == ((LayoutDirection) obj).m4434unboximpl();
        }

        /* renamed from: equals-impl0  reason: not valid java name */
        public static final boolean m4431equalsimpl0(int i11, int i12) {
            return i11 == i12;
        }

        /* renamed from: hashCode-impl  reason: not valid java name */
        public static int m4432hashCodeimpl(int i11) {
            return i11;
        }

        @NotNull
        /* renamed from: toString-impl  reason: not valid java name */
        public static String m4433toStringimpl(int i11) {
            if (m4431equalsimpl0(i11, Before)) {
                return "Before";
            }
            if (m4431equalsimpl0(i11, After)) {
                return "After";
            }
            if (m4431equalsimpl0(i11, Left)) {
                return "Left";
            }
            if (m4431equalsimpl0(i11, Right)) {
                return "Right";
            }
            if (m4431equalsimpl0(i11, Above)) {
                return "Above";
            }
            if (m4431equalsimpl0(i11, Below)) {
                return "Below";
            }
            return "invalid LayoutDirection";
        }

        public boolean equals(Object obj) {
            return m4430equalsimpl(this.value, obj);
        }

        public int hashCode() {
            return m4432hashCodeimpl(this.value);
        }

        @NotNull
        public String toString() {
            return m4433toStringimpl(this.value);
        }

        /* renamed from: unbox-impl  reason: not valid java name */
        public final /* synthetic */ int m4434unboximpl() {
            return this.value;
        }
    }

    @Nullable
    /* renamed from: layout-o7g1Pn8  reason: not valid java name */
    <T> T m4427layouto7g1Pn8(int i11, @NotNull Function1<? super BeyondBoundsScope, ? extends T> function1);
}
