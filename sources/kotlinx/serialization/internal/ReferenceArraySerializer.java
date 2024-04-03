package kotlinx.serialization.internal;

import java.util.ArrayList;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.PublishedApi;
import kotlin.jvm.internal.ArrayIteratorKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.KClass;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.descriptors.SerialDescriptor;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010(\n\u0002\b\t\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0001\u0018\u0000*\b\b\u0000\u0010\u0002*\u00020\u0001*\n\b\u0001\u0010\u0003*\u0004\u0018\u00018\u00002*\u0012\u0004\u0012\u00028\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00010\u0005\u0012\u0014\u0012\u0012\u0012\u0004\u0012\u00028\u00010\u0006j\b\u0012\u0004\u0012\u00028\u0001`\u00070\u0004B#\u0012\f\u0010\u001c\u001a\b\u0012\u0004\u0012\u00028\u00000\u001b\u0012\f\u0010$\u001a\b\u0012\u0004\u0012\u00028\u00010#¢\u0006\u0004\b%\u0010&J\u0019\u0010\t\u001a\u00020\b*\b\u0012\u0004\u0012\u00028\u00010\u0005H\u0014¢\u0006\u0004\b\t\u0010\nJ\u001f\u0010\f\u001a\b\u0012\u0004\u0012\u00028\u00010\u000b*\b\u0012\u0004\u0012\u00028\u00010\u0005H\u0014¢\u0006\u0004\b\f\u0010\rJ\u0018\u0010\u000e\u001a\u0012\u0012\u0004\u0012\u00028\u00010\u0006j\b\u0012\u0004\u0012\u00028\u0001`\u0007H\u0014J\u001c\u0010\u000f\u001a\u00020\b*\u0012\u0012\u0004\u0012\u00028\u00010\u0006j\b\u0012\u0004\u0012\u00028\u0001`\u0007H\u0014J)\u0010\u0010\u001a\b\u0012\u0004\u0012\u00028\u00010\u0005*\u0012\u0012\u0004\u0012\u00028\u00010\u0006j\b\u0012\u0004\u0012\u00028\u0001`\u0007H\u0014¢\u0006\u0004\b\u0010\u0010\u0011J)\u0010\u0012\u001a\u0012\u0012\u0004\u0012\u00028\u00010\u0006j\b\u0012\u0004\u0012\u00028\u0001`\u0007*\b\u0012\u0004\u0012\u00028\u00010\u0005H\u0014¢\u0006\u0004\b\u0012\u0010\u0013J$\u0010\u0016\u001a\u00020\u0015*\u0012\u0012\u0004\u0012\u00028\u00010\u0006j\b\u0012\u0004\u0012\u00028\u0001`\u00072\u0006\u0010\u0014\u001a\u00020\bH\u0014J3\u0010\u0019\u001a\u00020\u0015*\u0012\u0012\u0004\u0012\u00028\u00010\u0006j\b\u0012\u0004\u0012\u00028\u0001`\u00072\u0006\u0010\u0017\u001a\u00020\b2\u0006\u0010\u0018\u001a\u00028\u0001H\u0014¢\u0006\u0004\b\u0019\u0010\u001aR\u001a\u0010\u001c\u001a\b\u0012\u0004\u0012\u00028\u00000\u001b8\u0002X\u0004¢\u0006\u0006\n\u0004\b\u001c\u0010\u001dR\u001a\u0010\u001f\u001a\u00020\u001e8\u0016X\u0004¢\u0006\f\n\u0004\b\u001f\u0010 \u001a\u0004\b!\u0010\"¨\u0006'"}, d2 = {"Lkotlinx/serialization/internal/ReferenceArraySerializer;", "", "ElementKlass", "Element", "Lkotlinx/serialization/internal/CollectionLikeSerializer;", "", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "", "e", "([Ljava/lang/Object;)I", "", "d", "([Ljava/lang/Object;)Ljava/util/Iterator;", "a", "b", "h", "(Ljava/util/ArrayList;)[Ljava/lang/Object;", "g", "([Ljava/lang/Object;)Ljava/util/ArrayList;", "size", "", "c", "index", "element", "f", "(Ljava/util/ArrayList;ILjava/lang/Object;)V", "Lkotlin/reflect/KClass;", "kClass", "Lkotlin/reflect/KClass;", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "descriptor", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "getDescriptor", "()Lkotlinx/serialization/descriptors/SerialDescriptor;", "Lkotlinx/serialization/KSerializer;", "eSerializer", "<init>", "(Lkotlin/reflect/KClass;Lkotlinx/serialization/KSerializer;)V", "kotlinx-serialization-core"}, k = 1, mv = {1, 6, 0})
@PublishedApi
public final class ReferenceArraySerializer<ElementKlass, Element extends ElementKlass> extends CollectionLikeSerializer<Element, Element[], ArrayList<Element>> {
    @NotNull
    private final SerialDescriptor descriptor;
    @NotNull
    private final KClass<ElementKlass> kClass;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public ReferenceArraySerializer(@NotNull KClass<ElementKlass> kClass2, @NotNull KSerializer<Element> kSerializer) {
        super(kSerializer, (DefaultConstructorMarker) null);
        Intrinsics.checkNotNullParameter(kClass2, "kClass");
        Intrinsics.checkNotNullParameter(kSerializer, "eSerializer");
        this.kClass = kClass2;
        this.descriptor = new ArrayClassDesc(kSerializer.getDescriptor());
    }

    @NotNull
    /* renamed from: a */
    public ArrayList<Element> builder() {
        return new ArrayList<>();
    }

    /* renamed from: b */
    public int builderSize(@NotNull ArrayList<Element> arrayList) {
        Intrinsics.checkNotNullParameter(arrayList, "<this>");
        return arrayList.size();
    }

    /* renamed from: c */
    public void checkCapacity(@NotNull ArrayList<Element> arrayList, int i11) {
        Intrinsics.checkNotNullParameter(arrayList, "<this>");
        arrayList.ensureCapacity(i11);
    }

    @NotNull
    /* renamed from: d */
    public Iterator<Element> collectionIterator(@NotNull Element[] elementArr) {
        Intrinsics.checkNotNullParameter(elementArr, "<this>");
        return ArrayIteratorKt.iterator(elementArr);
    }

    /* renamed from: e */
    public int collectionSize(@NotNull Element[] elementArr) {
        Intrinsics.checkNotNullParameter(elementArr, "<this>");
        return elementArr.length;
    }

    /* renamed from: f */
    public void insert(@NotNull ArrayList<Element> arrayList, int i11, Element element) {
        Intrinsics.checkNotNullParameter(arrayList, "<this>");
        arrayList.add(i11, element);
    }

    @NotNull
    /* renamed from: g */
    public ArrayList<Element> toBuilder(@NotNull Element[] elementArr) {
        Intrinsics.checkNotNullParameter(elementArr, "<this>");
        return new ArrayList<>(ArraysKt___ArraysJvmKt.asList((T[]) elementArr));
    }

    @NotNull
    public SerialDescriptor getDescriptor() {
        return this.descriptor;
    }

    @NotNull
    /* renamed from: h */
    public Element[] toResult(@NotNull ArrayList<Element> arrayList) {
        Intrinsics.checkNotNullParameter(arrayList, "<this>");
        return PlatformKt.toNativeArrayImpl(arrayList, this.kClass);
    }
}
