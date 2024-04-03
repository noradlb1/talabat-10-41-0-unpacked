package androidx.compose.ui.text.input;

import kotlin.Metadata;
import kotlin.jvm.JvmInline;
import kotlin.jvm.internal.DefaultConstructorMarker;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\u0004\b@\u0018\u0000 \u00112\u00020\u0001:\u0001\u0011B\u0014\b\u0000\u0012\u0006\u0010\u0002\u001a\u00020\u0003ø\u0001\u0000¢\u0006\u0004\b\u0004\u0010\u0005J\u001a\u0010\u0006\u001a\u00020\u00072\b\u0010\b\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\t\u0010\nJ\u0010\u0010\u000b\u001a\u00020\u0003HÖ\u0001¢\u0006\u0004\b\f\u0010\u0005J\u000f\u0010\r\u001a\u00020\u000eH\u0016¢\u0006\u0004\b\u000f\u0010\u0010R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000\u0001\u0002\u0001\u00020\u0003ø\u0001\u0000\u0002\u0004\n\u0002\b\u0019¨\u0006\u0012"}, d2 = {"Landroidx/compose/ui/text/input/ImeAction;", "", "value", "", "constructor-impl", "(I)I", "equals", "", "other", "equals-impl", "(ILjava/lang/Object;)Z", "hashCode", "hashCode-impl", "toString", "", "toString-impl", "(I)Ljava/lang/String;", "Companion", "ui-text_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
@JvmInline
public final class ImeAction {
    @NotNull
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    /* access modifiers changed from: private */
    public static final int Default = m5181constructorimpl(1);
    /* access modifiers changed from: private */
    public static final int Done = m5181constructorimpl(7);
    /* access modifiers changed from: private */
    public static final int Go = m5181constructorimpl(2);
    /* access modifiers changed from: private */
    public static final int Next = m5181constructorimpl(6);
    /* access modifiers changed from: private */
    public static final int None = m5181constructorimpl(0);
    /* access modifiers changed from: private */
    public static final int Previous = m5181constructorimpl(5);
    /* access modifiers changed from: private */
    public static final int Search = m5181constructorimpl(3);
    /* access modifiers changed from: private */
    public static final int Send = m5181constructorimpl(4);
    private final int value;

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0012\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u001c\u0010\u0003\u001a\u00020\u0004ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\n\n\u0002\u0010\u0007\u001a\u0004\b\u0005\u0010\u0006R\u001c\u0010\b\u001a\u00020\u0004ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\n\n\u0002\u0010\u0007\u001a\u0004\b\t\u0010\u0006R\u001c\u0010\n\u001a\u00020\u0004ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\n\n\u0002\u0010\u0007\u001a\u0004\b\u000b\u0010\u0006R\u001c\u0010\f\u001a\u00020\u0004ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\n\n\u0002\u0010\u0007\u001a\u0004\b\r\u0010\u0006R\u001c\u0010\u000e\u001a\u00020\u0004ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\n\n\u0002\u0010\u0007\u001a\u0004\b\u000f\u0010\u0006R\u001c\u0010\u0010\u001a\u00020\u0004ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\n\n\u0002\u0010\u0007\u001a\u0004\b\u0011\u0010\u0006R\u001c\u0010\u0012\u001a\u00020\u0004ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\n\n\u0002\u0010\u0007\u001a\u0004\b\u0013\u0010\u0006R\u001c\u0010\u0014\u001a\u00020\u0004ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\n\n\u0002\u0010\u0007\u001a\u0004\b\u0015\u0010\u0006\u0002\u000f\n\u0002\b\u0019\n\u0005\b¡\u001e0\u0001\n\u0002\b!¨\u0006\u0016"}, d2 = {"Landroidx/compose/ui/text/input/ImeAction$Companion;", "", "()V", "Default", "Landroidx/compose/ui/text/input/ImeAction;", "getDefault-eUduSuo", "()I", "I", "Done", "getDone-eUduSuo", "Go", "getGo-eUduSuo", "Next", "getNext-eUduSuo", "None", "getNone-eUduSuo", "Previous", "getPrevious-eUduSuo", "Search", "getSearch-eUduSuo", "Send", "getSend-eUduSuo", "ui-text_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        /* renamed from: getDefault-eUduSuo  reason: not valid java name */
        public final int m5187getDefaulteUduSuo() {
            return ImeAction.Default;
        }

        /* renamed from: getDone-eUduSuo  reason: not valid java name */
        public final int m5188getDoneeUduSuo() {
            return ImeAction.Done;
        }

        /* renamed from: getGo-eUduSuo  reason: not valid java name */
        public final int m5189getGoeUduSuo() {
            return ImeAction.Go;
        }

        /* renamed from: getNext-eUduSuo  reason: not valid java name */
        public final int m5190getNexteUduSuo() {
            return ImeAction.Next;
        }

        /* renamed from: getNone-eUduSuo  reason: not valid java name */
        public final int m5191getNoneeUduSuo() {
            return ImeAction.None;
        }

        /* renamed from: getPrevious-eUduSuo  reason: not valid java name */
        public final int m5192getPreviouseUduSuo() {
            return ImeAction.Previous;
        }

        /* renamed from: getSearch-eUduSuo  reason: not valid java name */
        public final int m5193getSearcheUduSuo() {
            return ImeAction.Search;
        }

        /* renamed from: getSend-eUduSuo  reason: not valid java name */
        public final int m5194getSendeUduSuo() {
            return ImeAction.Send;
        }
    }

    private /* synthetic */ ImeAction(int i11) {
        this.value = i11;
    }

    /* renamed from: box-impl  reason: not valid java name */
    public static final /* synthetic */ ImeAction m5180boximpl(int i11) {
        return new ImeAction(i11);
    }

    /* renamed from: constructor-impl  reason: not valid java name */
    public static int m5181constructorimpl(int i11) {
        return i11;
    }

    /* renamed from: equals-impl  reason: not valid java name */
    public static boolean m5182equalsimpl(int i11, Object obj) {
        return (obj instanceof ImeAction) && i11 == ((ImeAction) obj).m5186unboximpl();
    }

    /* renamed from: equals-impl0  reason: not valid java name */
    public static final boolean m5183equalsimpl0(int i11, int i12) {
        return i11 == i12;
    }

    /* renamed from: hashCode-impl  reason: not valid java name */
    public static int m5184hashCodeimpl(int i11) {
        return i11;
    }

    @NotNull
    /* renamed from: toString-impl  reason: not valid java name */
    public static String m5185toStringimpl(int i11) {
        if (m5183equalsimpl0(i11, None)) {
            return "None";
        }
        if (m5183equalsimpl0(i11, Default)) {
            return "Default";
        }
        if (m5183equalsimpl0(i11, Go)) {
            return "Go";
        }
        if (m5183equalsimpl0(i11, Search)) {
            return "Search";
        }
        if (m5183equalsimpl0(i11, Send)) {
            return "Send";
        }
        if (m5183equalsimpl0(i11, Previous)) {
            return "Previous";
        }
        if (m5183equalsimpl0(i11, Next)) {
            return "Next";
        }
        if (m5183equalsimpl0(i11, Done)) {
            return "Done";
        }
        return "Invalid";
    }

    public boolean equals(Object obj) {
        return m5182equalsimpl(this.value, obj);
    }

    public int hashCode() {
        return m5184hashCodeimpl(this.value);
    }

    @NotNull
    public String toString() {
        return m5185toStringimpl(this.value);
    }

    /* renamed from: unbox-impl  reason: not valid java name */
    public final /* synthetic */ int m5186unboximpl() {
        return this.value;
    }
}
