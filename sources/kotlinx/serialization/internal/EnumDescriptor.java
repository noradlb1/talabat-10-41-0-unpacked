package kotlinx.serialization.internal;

import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.PublishedApi;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.descriptors.SerialDescriptor;
import kotlinx.serialization.descriptors.SerialDescriptorKt;
import kotlinx.serialization.descriptors.SerialKind;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.junit.jupiter.api.IndicativeSentencesGeneration;

@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0005\b\u0001\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\u0013\u0010\u0012\u001a\u00020\u00132\b\u0010\u0014\u001a\u0004\u0018\u00010\u0015H\u0002J\u0010\u0010\u0016\u001a\u00020\t2\u0006\u0010\u0017\u001a\u00020\u0005H\u0016J\b\u0010\u0018\u001a\u00020\u0005H\u0016J\b\u0010\u0019\u001a\u00020\u0003H\u0016R!\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\b8BX\u0002¢\u0006\f\n\u0004\b\f\u0010\r\u001a\u0004\b\n\u0010\u000bR\u0014\u0010\u000e\u001a\u00020\u000fX\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011¨\u0006\u001a"}, d2 = {"Lkotlinx/serialization/internal/EnumDescriptor;", "Lkotlinx/serialization/internal/PluginGeneratedSerialDescriptor;", "name", "", "elementsCount", "", "(Ljava/lang/String;I)V", "elementDescriptors", "", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "getElementDescriptors", "()[Lkotlinx/serialization/descriptors/SerialDescriptor;", "elementDescriptors$delegate", "Lkotlin/Lazy;", "kind", "Lkotlinx/serialization/descriptors/SerialKind;", "getKind", "()Lkotlinx/serialization/descriptors/SerialKind;", "equals", "", "other", "", "getElementDescriptor", "index", "hashCode", "toString", "kotlinx-serialization-core"}, k = 1, mv = {1, 6, 0}, xi = 48)
@PublishedApi
public final class EnumDescriptor extends PluginGeneratedSerialDescriptor {
    @NotNull
    private final Lazy elementDescriptors$delegate;
    @NotNull
    private final SerialKind kind = SerialKind.ENUM.INSTANCE;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public EnumDescriptor(@NotNull String str, int i11) {
        super(str, (GeneratedSerializer) null, i11, 2, (DefaultConstructorMarker) null);
        Intrinsics.checkNotNullParameter(str, "name");
        this.elementDescriptors$delegate = LazyKt__LazyJVMKt.lazy(new EnumDescriptor$elementDescriptors$2(i11, str, this));
    }

    private final SerialDescriptor[] getElementDescriptors() {
        return (SerialDescriptor[]) this.elementDescriptors$delegate.getValue();
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || !(obj instanceof SerialDescriptor)) {
            return false;
        }
        SerialDescriptor serialDescriptor = (SerialDescriptor) obj;
        if (serialDescriptor.getKind() == SerialKind.ENUM.INSTANCE && Intrinsics.areEqual((Object) getSerialName(), (Object) serialDescriptor.getSerialName()) && Intrinsics.areEqual((Object) Platform_commonKt.cachedSerialNames(this), (Object) Platform_commonKt.cachedSerialNames(serialDescriptor))) {
            return true;
        }
        return false;
    }

    @NotNull
    public SerialDescriptor getElementDescriptor(int i11) {
        return getElementDescriptors()[i11];
    }

    @NotNull
    public SerialKind getKind() {
        return this.kind;
    }

    public int hashCode() {
        int i11;
        int hashCode = getSerialName().hashCode();
        int i12 = 1;
        for (String next : SerialDescriptorKt.getElementNames(this)) {
            int i13 = i12 * 31;
            if (next != null) {
                i11 = next.hashCode();
            } else {
                i11 = 0;
            }
            i12 = i13 + i11;
        }
        return (hashCode * 31) + i12;
    }

    @NotNull
    public String toString() {
        Iterable<String> elementNames = SerialDescriptorKt.getElementNames(this);
        return CollectionsKt___CollectionsKt.joinToString$default(elementNames, IndicativeSentencesGeneration.DEFAULT_SEPARATOR, getSerialName() + '(', ")", 0, (CharSequence) null, (Function1) null, 56, (Object) null);
    }
}
