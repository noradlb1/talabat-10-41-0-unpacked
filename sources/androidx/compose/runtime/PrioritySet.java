package androidx.compose.runtime;

import com.talabat.talabatcommon.views.wallet.cardViewWidgets.view.DefaultCardView;
import java.util.ArrayList;
import java.util.List;
import kotlin.KotlinNothingValueException;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010!\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0005\b\u0000\u0018\u00002\u00020\u0001B\u0015\u0012\u000e\b\u0002\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\u0002\u0010\u0005J\u000e\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u0004J\u0006\u0010\t\u001a\u00020\nJ\u0006\u0010\u000b\u001a\u00020\nJ\u0006\u0010\f\u001a\u00020\u0004J\u0006\u0010\r\u001a\u00020\u0004J\u0006\u0010\u000e\u001a\u00020\u0007R\u0014\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003X\u0004¢\u0006\u0002\n\u0000¨\u0006\u000f"}, d2 = {"Landroidx/compose/runtime/PrioritySet;", "", "list", "", "", "(Ljava/util/List;)V", "add", "", "value", "isEmpty", "", "isNotEmpty", "peek", "takeMax", "validateHeap", "runtime_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class PrioritySet {
    @NotNull
    private final List<Integer> list;

    public PrioritySet() {
        this((List) null, 1, (DefaultConstructorMarker) null);
    }

    public PrioritySet(@NotNull List<Integer> list2) {
        Intrinsics.checkNotNullParameter(list2, DefaultCardView.CARD_LIST);
        this.list = list2;
    }

    public final void add(int i11) {
        if (!this.list.isEmpty()) {
            if (this.list.get(0).intValue() != i11) {
                List<Integer> list2 = this.list;
                if (list2.get(list2.size() - 1).intValue() == i11) {
                    return;
                }
            } else {
                return;
            }
        }
        int size = this.list.size();
        this.list.add(Integer.valueOf(i11));
        while (size > 0) {
            int i12 = ((size + 1) >>> 1) - 1;
            int intValue = this.list.get(i12).intValue();
            if (i11 <= intValue) {
                break;
            }
            this.list.set(size, Integer.valueOf(intValue));
            size = i12;
        }
        this.list.set(size, Integer.valueOf(i11));
    }

    public final boolean isEmpty() {
        return this.list.isEmpty();
    }

    public final boolean isNotEmpty() {
        return !this.list.isEmpty();
    }

    public final int peek() {
        return ((Number) CollectionsKt___CollectionsKt.first(this.list)).intValue();
    }

    public final int takeMax() {
        boolean z11;
        int intValue;
        if (this.list.size() > 0) {
            z11 = true;
        } else {
            z11 = false;
        }
        if (z11) {
            int intValue2 = this.list.get(0).intValue();
            while ((!this.list.isEmpty()) && this.list.get(0).intValue() == intValue2) {
                List<Integer> list2 = this.list;
                list2.set(0, CollectionsKt___CollectionsKt.last(list2));
                List<Integer> list3 = this.list;
                list3.remove(list3.size() - 1);
                int size = this.list.size();
                int size2 = this.list.size() >>> 1;
                int i11 = 0;
                while (i11 < size2) {
                    int intValue3 = this.list.get(i11).intValue();
                    int i12 = (i11 + 1) * 2;
                    int i13 = i12 - 1;
                    int intValue4 = this.list.get(i13).intValue();
                    if (i12 < size && (intValue = this.list.get(i12).intValue()) > intValue4) {
                        if (intValue <= intValue3) {
                            break;
                        }
                        this.list.set(i11, Integer.valueOf(intValue));
                        this.list.set(i12, Integer.valueOf(intValue3));
                        i11 = i12;
                    } else if (intValue4 <= intValue3) {
                        break;
                    } else {
                        this.list.set(i11, Integer.valueOf(intValue4));
                        this.list.set(i13, Integer.valueOf(intValue3));
                        i11 = i13;
                    }
                }
            }
            return intValue2;
        }
        ComposerKt.composeRuntimeError("Set is empty".toString());
        throw new KotlinNothingValueException();
    }

    public final void validateHeap() {
        boolean z11;
        int size = this.list.size();
        int i11 = size / 2;
        int i12 = 0;
        while (i12 < i11) {
            int i13 = i12 + 1;
            int i14 = i13 * 2;
            boolean z12 = true;
            if (this.list.get(i12).intValue() >= this.list.get(i14 - 1).intValue()) {
                z11 = true;
            } else {
                z11 = false;
            }
            if (z11) {
                if (i14 < size && this.list.get(i12).intValue() < this.list.get(i14).intValue()) {
                    z12 = false;
                }
                if (z12) {
                    i12 = i13;
                } else {
                    throw new IllegalStateException("Check failed.".toString());
                }
            } else {
                throw new IllegalStateException("Check failed.".toString());
            }
        }
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ PrioritySet(List list2, int i11, DefaultConstructorMarker defaultConstructorMarker) {
        this((i11 & 1) != 0 ? new ArrayList() : list2);
    }
}
