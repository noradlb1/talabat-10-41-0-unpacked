package bo.app;

import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import x2.l;

@Metadata(bv = {}, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\b\u0004\u0018\u00002\u00020\u0001:\u0001\u0003B\u0015\u0012\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00020\u0006¢\u0006\u0004\b\b\u0010\tR\u0013\u0010\u0005\u001a\u0004\u0018\u00010\u00028F¢\u0006\u0006\u001a\u0004\b\u0003\u0010\u0004¨\u0006\n"}, d2 = {"Lbo/app/l6;", "", "Lbo/app/b3;", "a", "()Lbo/app/b3;", "nextFallbackTriggeredAction", "", "fallbackActions", "<init>", "(Ljava/util/List;)V", "android-sdk-base_release"}, k = 1, mv = {1, 6, 0})
public final class l6 {

    /* renamed from: b  reason: collision with root package name */
    public static final a f38921b = new a((DefaultConstructorMarker) null);

    /* renamed from: c  reason: collision with root package name */
    private static final Comparator<b3> f38922c = new l();

    /* renamed from: a  reason: collision with root package name */
    private final PriorityQueue<b3> f38923a;

    @Metadata(bv = {}, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\n\u0010\u000bR\u0014\u0010\u0003\u001a\u00020\u00028\u0006XT¢\u0006\u0006\n\u0004\b\u0003\u0010\u0004R\"\u0010\b\u001a\u0010\u0012\f\u0012\n \u0007*\u0004\u0018\u00010\u00060\u00060\u00058\u0002X\u0004¢\u0006\u0006\n\u0004\b\b\u0010\t¨\u0006\f"}, d2 = {"Lbo/app/l6$a;", "", "", "INITIAL_TRIGGER_CAPACITY", "I", "Ljava/util/Comparator;", "Lbo/app/b3;", "kotlin.jvm.PlatformType", "triggeredActionComparator", "Ljava/util/Comparator;", "<init>", "()V", "android-sdk-base_release"}, k = 1, mv = {1, 6, 0})
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public l6(List<? extends b3> list) {
        Intrinsics.checkNotNullParameter(list, "fallbackActions");
        PriorityQueue<b3> priorityQueue = new PriorityQueue<>(12, f38922c);
        this.f38923a = priorityQueue;
        priorityQueue.addAll(list);
    }

    public final b3 a() {
        return this.f38923a.poll();
    }

    /* access modifiers changed from: private */
    public static final int a(b3 b3Var, b3 b3Var2) {
        Intrinsics.checkNotNullParameter(b3Var, "actionA");
        Intrinsics.checkNotNullParameter(b3Var2, "actionB");
        int u11 = b3Var.f().u();
        int u12 = b3Var2.f().u();
        if (u11 > u12) {
            return -1;
        }
        if (u11 < u12) {
            return 1;
        }
        return b3Var.getId().compareTo(b3Var2.getId());
    }
}
