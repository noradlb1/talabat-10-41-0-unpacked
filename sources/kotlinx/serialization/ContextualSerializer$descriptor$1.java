package kotlinx.serialization;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;
import kotlinx.serialization.descriptors.ClassSerialDescriptorBuilder;

@Metadata(d1 = {"\u0000\u0012\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001\"\b\b\u0000\u0010\u0002*\u00020\u0003*\u00020\u0004H\n¢\u0006\u0002\b\u0005"}, d2 = {"<anonymous>", "", "T", "", "Lkotlinx/serialization/descriptors/ClassSerialDescriptorBuilder;", "invoke"}, k = 3, mv = {1, 6, 0}, xi = 48)
public final class ContextualSerializer$descriptor$1 extends Lambda implements Function1<ClassSerialDescriptorBuilder, Unit> {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ ContextualSerializer<T> f26394g;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public ContextualSerializer$descriptor$1(ContextualSerializer<T> contextualSerializer) {
        super(1);
        this.f26394g = contextualSerializer;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((ClassSerialDescriptorBuilder) obj);
        return Unit.INSTANCE;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:2:0x000d, code lost:
        r0 = r0.getDescriptor();
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void invoke(@org.jetbrains.annotations.NotNull kotlinx.serialization.descriptors.ClassSerialDescriptorBuilder r2) {
        /*
            r1 = this;
            java.lang.String r0 = "$this$buildSerialDescriptor"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r2, r0)
            kotlinx.serialization.ContextualSerializer<T> r0 = r1.f26394g
            kotlinx.serialization.KSerializer r0 = r0.fallbackSerializer
            if (r0 == 0) goto L_0x0018
            kotlinx.serialization.descriptors.SerialDescriptor r0 = r0.getDescriptor()
            if (r0 == 0) goto L_0x0018
            java.util.List r0 = r0.getAnnotations()
            goto L_0x0019
        L_0x0018:
            r0 = 0
        L_0x0019:
            if (r0 != 0) goto L_0x001f
            java.util.List r0 = kotlin.collections.CollectionsKt__CollectionsKt.emptyList()
        L_0x001f:
            r2.setAnnotations(r0)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.serialization.ContextualSerializer$descriptor$1.invoke(kotlinx.serialization.descriptors.ClassSerialDescriptorBuilder):void");
    }
}
