package kotlinx.serialization.descriptors;

import j$.util.Iterator;
import j$.util.function.Consumer;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.jvm.internal.markers.KMappedMarker;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u001d\n\u0000\n\u0002\u0010(\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\t\u0010\u0005\u001a\u00020\u0006H\u0002J\t\u0010\u0007\u001a\u00020\u0002H\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u000e¢\u0006\u0002\n\u0000¨\u0006\b"}, d2 = {"kotlinx/serialization/descriptors/SerialDescriptorKt$elementDescriptors$1$1", "", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "elementsLeft", "", "hasNext", "", "next", "kotlinx-serialization-core"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class SerialDescriptorKt$elementDescriptors$1$1 implements Iterator<SerialDescriptor>, KMappedMarker, j$.util.Iterator {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ SerialDescriptor f26408b;
    private int elementsLeft;

    public SerialDescriptorKt$elementDescriptors$1$1(SerialDescriptor serialDescriptor) {
        this.f26408b = serialDescriptor;
        this.elementsLeft = serialDescriptor.getElementsCount();
    }

    public /* synthetic */ void forEachRemaining(Consumer consumer) {
        Iterator.CC.$default$forEachRemaining(this, consumer);
    }

    public /* synthetic */ void forEachRemaining(java.util.function.Consumer consumer) {
        forEachRemaining(Consumer.VivifiedWrapper.convert(consumer));
    }

    public boolean hasNext() {
        return this.elementsLeft > 0;
    }

    public void remove() {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @NotNull
    public SerialDescriptor next() {
        SerialDescriptor serialDescriptor = this.f26408b;
        int elementsCount = serialDescriptor.getElementsCount();
        int i11 = this.elementsLeft;
        this.elementsLeft = i11 - 1;
        return serialDescriptor.getElementDescriptor(elementsCount - i11);
    }
}
