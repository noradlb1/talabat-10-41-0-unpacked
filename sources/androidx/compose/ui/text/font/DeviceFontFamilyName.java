package androidx.compose.ui.text.font;

import androidx.compose.ui.text.ExperimentalTextApi;
import kotlin.Metadata;
import kotlin.jvm.JvmInline;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@ExperimentalTextApi
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0005\b@\u0018\u00002\u00020\u0001B\u0012\u0012\u0006\u0010\u0002\u001a\u00020\u0003ø\u0001\u0000¢\u0006\u0004\b\u0004\u0010\u0005J\u001a\u0010\b\u001a\u00020\t2\b\u0010\n\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u000b\u0010\fJ\u0010\u0010\r\u001a\u00020\u000eHÖ\u0001¢\u0006\u0004\b\u000f\u0010\u0010J\u0010\u0010\u0011\u001a\u00020\u0003HÖ\u0001¢\u0006\u0004\b\u0012\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007\u0001\u0002ø\u0001\u0000\u0002\u0004\n\u0002\b\u0019¨\u0006\u0013"}, d2 = {"Landroidx/compose/ui/text/font/DeviceFontFamilyName;", "", "name", "", "constructor-impl", "(Ljava/lang/String;)Ljava/lang/String;", "getName", "()Ljava/lang/String;", "equals", "", "other", "equals-impl", "(Ljava/lang/String;Ljava/lang/Object;)Z", "hashCode", "", "hashCode-impl", "(Ljava/lang/String;)I", "toString", "toString-impl", "ui-text_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
@JvmInline
public final class DeviceFontFamilyName {
    @NotNull

    /* renamed from: name  reason: collision with root package name */
    private final String f10177name;

    private /* synthetic */ DeviceFontFamilyName(String str) {
        this.f10177name = str;
    }

    /* renamed from: box-impl  reason: not valid java name */
    public static final /* synthetic */ DeviceFontFamilyName m5088boximpl(String str) {
        return new DeviceFontFamilyName(str);
    }

    @NotNull
    /* renamed from: constructor-impl  reason: not valid java name */
    public static String m5089constructorimpl(@NotNull String str) {
        boolean z11;
        Intrinsics.checkNotNullParameter(str, "name");
        if (str.length() > 0) {
            z11 = true;
        } else {
            z11 = false;
        }
        if (z11) {
            return str;
        }
        throw new IllegalArgumentException("name may not be empty".toString());
    }

    /* renamed from: equals-impl  reason: not valid java name */
    public static boolean m5090equalsimpl(String str, Object obj) {
        return (obj instanceof DeviceFontFamilyName) && Intrinsics.areEqual((Object) str, (Object) ((DeviceFontFamilyName) obj).m5094unboximpl());
    }

    /* renamed from: equals-impl0  reason: not valid java name */
    public static final boolean m5091equalsimpl0(String str, String str2) {
        return Intrinsics.areEqual((Object) str, (Object) str2);
    }

    /* renamed from: hashCode-impl  reason: not valid java name */
    public static int m5092hashCodeimpl(String str) {
        return str.hashCode();
    }

    /* renamed from: toString-impl  reason: not valid java name */
    public static String m5093toStringimpl(String str) {
        return "DeviceFontFamilyName(name=" + str + ')';
    }

    public boolean equals(Object obj) {
        return m5090equalsimpl(this.f10177name, obj);
    }

    @NotNull
    public final String getName() {
        return this.f10177name;
    }

    public int hashCode() {
        return m5092hashCodeimpl(this.f10177name);
    }

    public String toString() {
        return m5093toStringimpl(this.f10177name);
    }

    /* renamed from: unbox-impl  reason: not valid java name */
    public final /* synthetic */ String m5094unboximpl() {
        return this.f10177name;
    }
}
