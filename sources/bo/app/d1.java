package bo.app;

import com.braze.support.BrazeLogger;
import java.util.Random;
import java.util.concurrent.TimeUnit;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.Ref;

@Metadata(bv = {}, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\n\u0018\u00002\u00020\u0001:\u0001\u0006B\u001b\b\u0007\u0012\u0006\u0010\r\u001a\u00020\u0004\u0012\b\b\u0002\u0010\u000e\u001a\u00020\u0004¢\u0006\u0004\b\u000f\u0010\u0010J\b\u0010\u0003\u001a\u00020\u0002H\u0016J\u0010\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0004H\u0016R\u0014\u0010\n\u001a\u00020\u00078VX\u0004¢\u0006\u0006\u001a\u0004\b\b\u0010\tR\u0014\u0010\f\u001a\u00020\u00048VX\u0004¢\u0006\u0006\u001a\u0004\b\u0006\u0010\u000b¨\u0006\u0011"}, d2 = {"Lbo/app/d1;", "Lbo/app/w1;", "", "c", "", "normalSleepDurationMs", "a", "", "b", "()Z", "isBackingOff", "()I", "newSleepDurationAfterFailure", "maxSleepDurationMs", "defaultNormalSleepDurationMs", "<init>", "(II)V", "android-sdk-base_release"}, k = 1, mv = {1, 6, 0})
public final class d1 implements w1 {

    /* renamed from: e  reason: collision with root package name */
    public static final a f38438e = new a((DefaultConstructorMarker) null);
    /* access modifiers changed from: private */

    /* renamed from: a  reason: collision with root package name */
    public final int f38439a;

    /* renamed from: b  reason: collision with root package name */
    private final int f38440b;

    /* renamed from: c  reason: collision with root package name */
    private final Random f38441c;
    /* access modifiers changed from: private */

    /* renamed from: d  reason: collision with root package name */
    public int f38442d;

    @Metadata(bv = {}, d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\n\b\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\r\u0010\u000bJ \u0010\u0007\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0004H\u0007R\u001a\u0010\b\u001a\u00020\u00048\u0006XT¢\u0006\f\n\u0004\b\b\u0010\t\u0012\u0004\b\n\u0010\u000bR\u0014\u0010\f\u001a\u00020\u00048\u0006XT¢\u0006\u0006\n\u0004\b\f\u0010\t¨\u0006\u000e"}, d2 = {"Lbo/app/d1$a;", "", "Ljava/util/Random;", "random", "", "valueA", "valueB", "a", "minimumSleepTimeMs", "I", "getMinimumSleepTimeMs$annotations", "()V", "scaleFactor", "<init>", "android-sdk-base_release"}, k = 1, mv = {1, 6, 0})
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @JvmStatic
        public final int a(Random random, int i11, int i12) {
            Intrinsics.checkNotNullParameter(random, "random");
            return random.nextInt(Math.abs(i11 - i12) + 1) + Math.min(i11, i12);
        }
    }

    @Metadata(bv = {}, d1 = {"\u0000\b\n\u0002\u0010\u000e\n\u0002\b\u0002\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"", "a", "()Ljava/lang/String;"}, k = 3, mv = {1, 6, 0})
    public static final class b extends Lambda implements Function0<String> {

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ Ref.IntRef f38443b;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public b(Ref.IntRef intRef) {
            super(0);
            this.f38443b = intRef;
        }

        /* renamed from: a */
        public final String invoke() {
            return "Sleep time too small: " + this.f38443b.element + " increasing to 250";
        }
    }

    @Metadata(bv = {}, d1 = {"\u0000\b\n\u0002\u0010\u000e\n\u0002\b\u0002\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"", "a", "()Ljava/lang/String;"}, k = 3, mv = {1, 6, 0})
    public static final class c extends Lambda implements Function0<String> {

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ d1 f38444b;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public c(d1 d1Var) {
            super(0);
            this.f38444b = d1Var;
        }

        /* renamed from: a */
        public final String invoke() {
            return Intrinsics.stringPlus("Computing new sleep delay. Previous sleep delay: ", Integer.valueOf(this.f38444b.f38442d));
        }
    }

    @Metadata(bv = {}, d1 = {"\u0000\b\n\u0002\u0010\u000e\n\u0002\b\u0002\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"", "a", "()Ljava/lang/String;"}, k = 3, mv = {1, 6, 0})
    public static final class d extends Lambda implements Function0<String> {

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ d1 f38445b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ Ref.IntRef f38446c;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public d(d1 d1Var, Ref.IntRef intRef) {
            super(0);
            this.f38445b = d1Var;
            this.f38446c = intRef;
        }

        /* renamed from: a */
        public final String invoke() {
            return "New sleep duration: " + this.f38445b.f38442d + " ms. Default sleep duration: " + this.f38446c.element + " ms. Max sleep: " + this.f38445b.f38439a + " ms.";
        }
    }

    public d1(int i11, int i12) {
        this.f38439a = i11;
        this.f38440b = i12;
        this.f38441c = new Random();
    }

    public void c() {
        this.f38442d = 0;
    }

    public int a() {
        return a(this.f38440b);
    }

    public boolean b() {
        return this.f38442d != 0;
    }

    public int a(int i11) {
        Ref.IntRef intRef = new Ref.IntRef();
        intRef.element = i11;
        if (i11 < 250) {
            BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) this, (BrazeLogger.Priority) null, (Throwable) null, false, (Function0) new b(intRef), 7, (Object) null);
            intRef.element = 250;
        }
        if (this.f38442d == 0) {
            this.f38442d = 250;
        }
        BrazeLogger brazeLogger = BrazeLogger.INSTANCE;
        BrazeLogger.brazelog$default(brazeLogger, (Object) this, (BrazeLogger.Priority) null, (Throwable) null, false, (Function0) new c(this), 7, (Object) null);
        this.f38442d = Math.min(this.f38439a, f38438e.a(this.f38441c, Math.max(intRef.element, this.f38442d), this.f38442d * 3));
        BrazeLogger.brazelog$default(brazeLogger, (Object) this, (BrazeLogger.Priority) null, (Throwable) null, false, (Function0) new d(this, intRef), 7, (Object) null);
        return this.f38442d;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ d1(int i11, int i12, int i13, DefaultConstructorMarker defaultConstructorMarker) {
        this(i11, (i13 & 2) != 0 ? (int) TimeUnit.SECONDS.toMillis(1) : i12);
    }
}
