package kotlin.reflect.jvm.internal;

import java.lang.annotation.Annotation;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010 \n\u0002\u0010\u001b\n\u0002\b\u0002\u0010\u0000\u001a\u0016\u0012\u0004\u0012\u00020\u0002 \u0003*\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u00010\u0001H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "", "", "kotlin.jvm.PlatformType", "invoke"}, k = 3, mv = {1, 7, 1}, xi = 48)
public final class KParameterImpl$annotations$2 extends Lambda implements Function0<List<? extends Annotation>> {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ KParameterImpl f24415g;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public KParameterImpl$annotations$2(KParameterImpl kParameterImpl) {
        super(0);
        this.f24415g = kParameterImpl;
    }

    public final List<Annotation> invoke() {
        return UtilKt.computeAnnotations(this.f24415g.getDescriptor());
    }
}
