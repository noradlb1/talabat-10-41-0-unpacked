package androidx.compose.ui.semantics;

import androidx.compose.runtime.Immutable;
import kotlin.Metadata;
import kotlin.jvm.JvmInline;
import kotlin.jvm.internal.DefaultConstructorMarker;
import org.jetbrains.annotations.NotNull;

@Immutable
@JvmInline
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\u0004\b@\u0018\u0000 \u00112\u00020\u0001:\u0001\u0011B\u0014\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003ø\u0001\u0000¢\u0006\u0004\b\u0004\u0010\u0005J\u001a\u0010\u0006\u001a\u00020\u00072\b\u0010\b\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\t\u0010\nJ\u0010\u0010\u000b\u001a\u00020\u0003HÖ\u0001¢\u0006\u0004\b\f\u0010\u0005J\u000f\u0010\r\u001a\u00020\u000eH\u0016¢\u0006\u0004\b\u000f\u0010\u0010R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000\u0001\u0002\u0001\u00020\u0003ø\u0001\u0000\u0002\u0004\n\u0002\b\u0019¨\u0006\u0012"}, d2 = {"Landroidx/compose/ui/semantics/Role;", "", "value", "", "constructor-impl", "(I)I", "equals", "", "other", "equals-impl", "(ILjava/lang/Object;)Z", "hashCode", "hashCode-impl", "toString", "", "toString-impl", "(I)Ljava/lang/String;", "Companion", "ui_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class Role {
    /* access modifiers changed from: private */
    public static final int Button = m4905constructorimpl(0);
    /* access modifiers changed from: private */
    public static final int Checkbox = m4905constructorimpl(1);
    @NotNull
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    /* access modifiers changed from: private */
    public static final int Image = m4905constructorimpl(5);
    /* access modifiers changed from: private */
    public static final int RadioButton = m4905constructorimpl(3);
    /* access modifiers changed from: private */
    public static final int Switch = m4905constructorimpl(2);
    /* access modifiers changed from: private */
    public static final int Tab = m4905constructorimpl(4);
    private final int value;

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000e\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u001c\u0010\u0003\u001a\u00020\u0004ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\n\n\u0002\u0010\u0007\u001a\u0004\b\u0005\u0010\u0006R\u001c\u0010\b\u001a\u00020\u0004ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\n\n\u0002\u0010\u0007\u001a\u0004\b\t\u0010\u0006R\u001c\u0010\n\u001a\u00020\u0004ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\n\n\u0002\u0010\u0007\u001a\u0004\b\u000b\u0010\u0006R\u001c\u0010\f\u001a\u00020\u0004ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\n\n\u0002\u0010\u0007\u001a\u0004\b\r\u0010\u0006R\u001c\u0010\u000e\u001a\u00020\u0004ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\n\n\u0002\u0010\u0007\u001a\u0004\b\u000f\u0010\u0006R\u001c\u0010\u0010\u001a\u00020\u0004ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\n\n\u0002\u0010\u0007\u001a\u0004\b\u0011\u0010\u0006\u0002\u000f\n\u0002\b\u0019\n\u0005\b¡\u001e0\u0001\n\u0002\b!¨\u0006\u0012"}, d2 = {"Landroidx/compose/ui/semantics/Role$Companion;", "", "()V", "Button", "Landroidx/compose/ui/semantics/Role;", "getButton-o7Vup1c", "()I", "I", "Checkbox", "getCheckbox-o7Vup1c", "Image", "getImage-o7Vup1c", "RadioButton", "getRadioButton-o7Vup1c", "Switch", "getSwitch-o7Vup1c", "Tab", "getTab-o7Vup1c", "ui_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        /* renamed from: getButton-o7Vup1c  reason: not valid java name */
        public final int m4911getButtono7Vup1c() {
            return Role.Button;
        }

        /* renamed from: getCheckbox-o7Vup1c  reason: not valid java name */
        public final int m4912getCheckboxo7Vup1c() {
            return Role.Checkbox;
        }

        /* renamed from: getImage-o7Vup1c  reason: not valid java name */
        public final int m4913getImageo7Vup1c() {
            return Role.Image;
        }

        /* renamed from: getRadioButton-o7Vup1c  reason: not valid java name */
        public final int m4914getRadioButtono7Vup1c() {
            return Role.RadioButton;
        }

        /* renamed from: getSwitch-o7Vup1c  reason: not valid java name */
        public final int m4915getSwitcho7Vup1c() {
            return Role.Switch;
        }

        /* renamed from: getTab-o7Vup1c  reason: not valid java name */
        public final int m4916getTabo7Vup1c() {
            return Role.Tab;
        }
    }

    private /* synthetic */ Role(int i11) {
        this.value = i11;
    }

    /* renamed from: box-impl  reason: not valid java name */
    public static final /* synthetic */ Role m4904boximpl(int i11) {
        return new Role(i11);
    }

    /* renamed from: constructor-impl  reason: not valid java name */
    private static int m4905constructorimpl(int i11) {
        return i11;
    }

    /* renamed from: equals-impl  reason: not valid java name */
    public static boolean m4906equalsimpl(int i11, Object obj) {
        return (obj instanceof Role) && i11 == ((Role) obj).m4910unboximpl();
    }

    /* renamed from: equals-impl0  reason: not valid java name */
    public static final boolean m4907equalsimpl0(int i11, int i12) {
        return i11 == i12;
    }

    /* renamed from: hashCode-impl  reason: not valid java name */
    public static int m4908hashCodeimpl(int i11) {
        return i11;
    }

    @NotNull
    /* renamed from: toString-impl  reason: not valid java name */
    public static String m4909toStringimpl(int i11) {
        if (m4907equalsimpl0(i11, Button)) {
            return "Button";
        }
        if (m4907equalsimpl0(i11, Checkbox)) {
            return "Checkbox";
        }
        if (m4907equalsimpl0(i11, Switch)) {
            return "Switch";
        }
        if (m4907equalsimpl0(i11, RadioButton)) {
            return "RadioButton";
        }
        if (m4907equalsimpl0(i11, Tab)) {
            return "Tab";
        }
        if (m4907equalsimpl0(i11, Image)) {
            return "Image";
        }
        return "Unknown";
    }

    public boolean equals(Object obj) {
        return m4906equalsimpl(this.value, obj);
    }

    public int hashCode() {
        return m4908hashCodeimpl(this.value);
    }

    @NotNull
    public String toString() {
        return m4909toStringimpl(this.value);
    }

    /* renamed from: unbox-impl  reason: not valid java name */
    public final /* synthetic */ int m4910unboximpl() {
        return this.value;
    }
}
