package bo.app;

import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(bv = {}, d1 = {"\u0000\u000e\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\u0010\u0003\u001a\u00020\u0002\"\u0010\b\u0000\u0010\u0001\u0018\u0001*\b\u0012\u0004\u0012\u00028\u00000\u0000H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"", "TargetEnum", "", "a", "()Ljava/lang/String;"}, k = 3, mv = {1, 6, 0})
public final class v0 extends Lambda implements Function0<String> {

    /* renamed from: b  reason: collision with root package name */
    final /* synthetic */ String f39496b;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public v0(String str) {
        super(0);
        this.f39496b = str;
    }

    /* renamed from: a */
    public final String invoke() {
        return Intrinsics.stringPlus("Failed to create valid enum from string: ", this.f39496b);
    }
}
