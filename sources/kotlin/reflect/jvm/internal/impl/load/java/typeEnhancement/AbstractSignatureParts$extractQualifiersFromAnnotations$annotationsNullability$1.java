package kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement;

import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;

public final class AbstractSignatureParts$extractQualifiersFromAnnotations$annotationsNullability$1 extends Lambda implements Function1<TAnnotation, Boolean> {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ AbstractSignatureParts<TAnnotation> f24666g;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public AbstractSignatureParts$extractQualifiersFromAnnotations$annotationsNullability$1(AbstractSignatureParts<TAnnotation> abstractSignatureParts) {
        super(1);
        this.f24666g = abstractSignatureParts;
    }

    @NotNull
    public final Boolean invoke(@NotNull TAnnotation tannotation) {
        Intrinsics.checkNotNullParameter(tannotation, "$this$extractNullability");
        return Boolean.valueOf(this.f24666g.getForceWarning(tannotation));
    }
}
