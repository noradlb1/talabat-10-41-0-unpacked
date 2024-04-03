package bo.app;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {}, d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0003\n\u0002\b\u0004\u0018\u00002\u00060\u0001j\u0002`\u0002B\u0019\b\u0016\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0005¢\u0006\u0004\b\u0007\u0010\b¨\u0006\t"}, d2 = {"Lbo/app/r5;", "Ljava/lang/Exception;", "Lkotlin/Exception;", "", "message", "", "innerException", "<init>", "(Ljava/lang/String;Ljava/lang/Throwable;)V", "android-sdk-base_release"}, k = 1, mv = {1, 6, 0})
public final class r5 extends Exception {
    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public r5(String str, Throwable th2) {
        super(str, th2);
        Intrinsics.checkNotNullParameter(str, "message");
        Intrinsics.checkNotNullParameter(th2, "innerException");
    }
}
