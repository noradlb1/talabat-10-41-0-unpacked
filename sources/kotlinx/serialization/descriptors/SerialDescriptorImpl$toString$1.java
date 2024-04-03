package kotlinx.serialization.descriptors;

import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\r\n\u0000\n\u0002\u0010\b\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "", "it", "", "invoke"}, k = 3, mv = {1, 6, 0}, xi = 48)
public final class SerialDescriptorImpl$toString$1 extends Lambda implements Function1<Integer, CharSequence> {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ SerialDescriptorImpl f26405g;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public SerialDescriptorImpl$toString$1(SerialDescriptorImpl serialDescriptorImpl) {
        super(1);
        this.f26405g = serialDescriptorImpl;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        return invoke(((Number) obj).intValue());
    }

    @NotNull
    public final CharSequence invoke(int i11) {
        return this.f26405g.getElementName(i11) + ": " + this.f26405g.getElementDescriptor(i11).getSerialName();
    }
}
