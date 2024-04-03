package androidx.compose.ui.graphics.vector;

import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.jvm.JvmInline;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u000e\n\u0002\u0010\u000e\n\u0002\b\u0003\b@\u0018\u0000*\u0004\b\u0000\u0010\u00012\u00020\u0002B$\u0012\u0018\b\u0002\u0010\u0003\u001a\u0012\u0012\u0004\u0012\u00028\u00000\u0004j\b\u0012\u0004\u0012\u00028\u0000`\u0005ø\u0001\u0000¢\u0006\u0004\b\u0006\u0010\u0007J\u001a\u0010\f\u001a\u00020\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u0002HÖ\u0003¢\u0006\u0004\b\u000f\u0010\u0010J\u0010\u0010\u0011\u001a\u00020\tHÖ\u0001¢\u0006\u0004\b\u0012\u0010\u000bJ\r\u0010\u0013\u001a\u00028\u0000¢\u0006\u0004\b\u0014\u0010\u0015J\r\u0010\u0016\u001a\u00028\u0000¢\u0006\u0004\b\u0017\u0010\u0015J\u0015\u0010\u0018\u001a\u00020\r2\u0006\u0010\u0019\u001a\u00028\u0000¢\u0006\u0004\b\u001a\u0010\u0010J\u0010\u0010\u001b\u001a\u00020\u001cHÖ\u0001¢\u0006\u0004\b\u001d\u0010\u001eR\u001e\u0010\u0003\u001a\u0012\u0012\u0004\u0012\u00028\u00000\u0004j\b\u0012\u0004\u0012\u00028\u0000`\u0005X\u0004¢\u0006\u0002\n\u0000R\u0011\u0010\b\u001a\u00020\t8F¢\u0006\u0006\u001a\u0004\b\n\u0010\u000b\u0001\u0003\u0001\u0012\u0012\u0004\u0012\u0002H\u00010\u0004j\b\u0012\u0004\u0012\u0002H\u0001`\u0005ø\u0001\u0000\u0002\u0004\n\u0002\b\u0019¨\u0006\u001f"}, d2 = {"Landroidx/compose/ui/graphics/vector/Stack;", "T", "", "backing", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "constructor-impl", "(Ljava/util/ArrayList;)Ljava/util/ArrayList;", "size", "", "getSize-impl", "(Ljava/util/ArrayList;)I", "equals", "", "other", "equals-impl", "(Ljava/util/ArrayList;Ljava/lang/Object;)Z", "hashCode", "hashCode-impl", "peek", "peek-impl", "(Ljava/util/ArrayList;)Ljava/lang/Object;", "pop", "pop-impl", "push", "value", "push-impl", "toString", "", "toString-impl", "(Ljava/util/ArrayList;)Ljava/lang/String;", "ui_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
@JvmInline
final class Stack<T> {
    @NotNull
    private final ArrayList<T> backing;

    private /* synthetic */ Stack(ArrayList arrayList) {
        this.backing = arrayList;
    }

    /* renamed from: box-impl  reason: not valid java name */
    public static final /* synthetic */ Stack m3532boximpl(ArrayList arrayList) {
        return new Stack(arrayList);
    }

    @NotNull
    /* renamed from: constructor-impl  reason: not valid java name */
    public static <T> ArrayList<T> m3533constructorimpl(@NotNull ArrayList<T> arrayList) {
        Intrinsics.checkNotNullParameter(arrayList, "backing");
        return arrayList;
    }

    /* renamed from: constructor-impl$default  reason: not valid java name */
    public static /* synthetic */ ArrayList m3534constructorimpl$default(ArrayList arrayList, int i11, DefaultConstructorMarker defaultConstructorMarker) {
        if ((i11 & 1) != 0) {
            arrayList = new ArrayList();
        }
        return m3533constructorimpl(arrayList);
    }

    /* renamed from: equals-impl  reason: not valid java name */
    public static boolean m3535equalsimpl(ArrayList<T> arrayList, Object obj) {
        return (obj instanceof Stack) && Intrinsics.areEqual((Object) arrayList, (Object) ((Stack) obj).m3543unboximpl());
    }

    /* renamed from: equals-impl0  reason: not valid java name */
    public static final boolean m3536equalsimpl0(ArrayList<T> arrayList, ArrayList<T> arrayList2) {
        return Intrinsics.areEqual((Object) arrayList, (Object) arrayList2);
    }

    /* renamed from: getSize-impl  reason: not valid java name */
    public static final int m3537getSizeimpl(ArrayList<T> arrayList) {
        return arrayList.size();
    }

    /* renamed from: hashCode-impl  reason: not valid java name */
    public static int m3538hashCodeimpl(ArrayList<T> arrayList) {
        return arrayList.hashCode();
    }

    /* renamed from: peek-impl  reason: not valid java name */
    public static final T m3539peekimpl(ArrayList<T> arrayList) {
        return arrayList.get(m3537getSizeimpl(arrayList) - 1);
    }

    /* renamed from: pop-impl  reason: not valid java name */
    public static final T m3540popimpl(ArrayList<T> arrayList) {
        return arrayList.remove(m3537getSizeimpl(arrayList) - 1);
    }

    /* renamed from: push-impl  reason: not valid java name */
    public static final boolean m3541pushimpl(ArrayList<T> arrayList, T t11) {
        return arrayList.add(t11);
    }

    /* renamed from: toString-impl  reason: not valid java name */
    public static String m3542toStringimpl(ArrayList<T> arrayList) {
        return "Stack(backing=" + arrayList + ')';
    }

    public boolean equals(Object obj) {
        return m3535equalsimpl(this.backing, obj);
    }

    public int hashCode() {
        return m3538hashCodeimpl(this.backing);
    }

    public String toString() {
        return m3542toStringimpl(this.backing);
    }

    /* renamed from: unbox-impl  reason: not valid java name */
    public final /* synthetic */ ArrayList m3543unboximpl() {
        return this.backing;
    }
}
