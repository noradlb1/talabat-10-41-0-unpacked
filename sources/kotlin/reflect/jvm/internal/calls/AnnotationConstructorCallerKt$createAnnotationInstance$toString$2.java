package kotlin.reflect.jvm.internal.calls;

import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;
import org.junit.jupiter.api.IndicativeSentencesGeneration;

@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0000\n\u0000\u0010\u0000\u001a\u00020\u0001\"\b\b\u0000\u0010\u0002*\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "", "T", "", "invoke"}, k = 3, mv = {1, 7, 1}, xi = 48)
public final class AnnotationConstructorCallerKt$createAnnotationInstance$toString$2 extends Lambda implements Function0<String> {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ Class<T> f24448g;

    /* renamed from: h  reason: collision with root package name */
    public final /* synthetic */ Map<String, Object> f24449h;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public AnnotationConstructorCallerKt$createAnnotationInstance$toString$2(Class<T> cls, Map<String, ? extends Object> map) {
        super(0);
        this.f24448g = cls;
        this.f24449h = map;
    }

    @NotNull
    public final String invoke() {
        Class<T> cls = this.f24448g;
        Map<String, Object> map = this.f24449h;
        StringBuilder sb2 = new StringBuilder();
        sb2.append('@');
        sb2.append(cls.getCanonicalName());
        Appendable unused = CollectionsKt___CollectionsKt.joinTo$default(map.entrySet(), sb2, IndicativeSentencesGeneration.DEFAULT_SEPARATOR, "(", ")", 0, (CharSequence) null, AnnotationConstructorCallerKt$createAnnotationInstance$toString$2$1$1.INSTANCE, 48, (Object) null);
        String sb3 = sb2.toString();
        Intrinsics.checkNotNullExpressionValue(sb3, "StringBuilder().apply(builderAction).toString()");
        return sb3;
    }
}
