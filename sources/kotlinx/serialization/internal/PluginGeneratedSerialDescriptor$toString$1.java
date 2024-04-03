package kotlinx.serialization.internal;

import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\r\n\u0000\n\u0002\u0010\b\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "", "i", "", "invoke"}, k = 3, mv = {1, 6, 0}, xi = 48)
public final class PluginGeneratedSerialDescriptor$toString$1 extends Lambda implements Function1<Integer, CharSequence> {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ PluginGeneratedSerialDescriptor f26426g;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public PluginGeneratedSerialDescriptor$toString$1(PluginGeneratedSerialDescriptor pluginGeneratedSerialDescriptor) {
        super(1);
        this.f26426g = pluginGeneratedSerialDescriptor;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        return invoke(((Number) obj).intValue());
    }

    @NotNull
    public final CharSequence invoke(int i11) {
        return this.f26426g.getElementName(i11) + ": " + this.f26426g.getElementDescriptor(i11).getSerialName();
    }
}
