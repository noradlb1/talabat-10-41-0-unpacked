package kotlin.reflect.jvm.internal;

import java.lang.annotation.Annotation;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010 \n\u0002\u0010\u001b\n\u0002\b\u0003\u0010\u0000\u001a\u0016\u0012\u0004\u0012\u00020\u0002 \u0003*\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u00010\u0001\"\u0006\b\u0000\u0010\u0004 \u0001H\n¢\u0006\u0002\b\u0005"}, d2 = {"<anonymous>", "", "", "kotlin.jvm.PlatformType", "R", "invoke"}, k = 3, mv = {1, 7, 1}, xi = 48)
public final class KCallableImpl$_annotations$1 extends Lambda implements Function0<List<? extends Annotation>> {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ KCallableImpl<R> f24356g;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public KCallableImpl$_annotations$1(KCallableImpl<? extends R> kCallableImpl) {
        super(0);
        this.f24356g = kCallableImpl;
    }

    public final List<Annotation> invoke() {
        return UtilKt.computeAnnotations(this.f24356g.getDescriptor());
    }
}
