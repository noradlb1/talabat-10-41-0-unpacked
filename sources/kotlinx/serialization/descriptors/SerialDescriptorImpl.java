package kotlinx.serialization.descriptors;

import fwfd.com.fwfsdk.constant.FWFConstants;
import java.lang.annotation.Annotation;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.collections.IndexedValue;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.IntRange;
import kotlinx.serialization.descriptors.SerialDescriptor;
import kotlinx.serialization.internal.CachedNames;
import kotlinx.serialization.internal.Platform_commonKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.junit.jupiter.api.IndicativeSentencesGeneration;

@Metadata(d1 = {"\u0000d\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010 \n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u001b\n\u0002\b\u0003\n\u0002\u0010\u0011\n\u0002\b\u0006\n\u0002\u0010\u0018\n\u0002\b\u0004\n\u0002\u0010$\n\u0002\b\u0003\n\u0002\u0010\"\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\n\b\u0000\u0018\u00002\u00020\u00012\u00020\u0002B3\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00010\n\u0012\u0006\u0010\u000b\u001a\u00020\f¢\u0006\u0002\u0010\rJ\u0013\u0010,\u001a\u00020-2\b\u0010.\u001a\u0004\u0018\u00010/H\u0002J\u0016\u00100\u001a\b\u0012\u0004\u0012\u00020\u00140\n2\u0006\u00101\u001a\u00020\bH\u0016J\u0010\u00102\u001a\u00020\u00012\u0006\u00101\u001a\u00020\bH\u0016J\u0010\u00103\u001a\u00020\b2\u0006\u00104\u001a\u00020\u0004H\u0016J\u0010\u00105\u001a\u00020\u00042\u0006\u00101\u001a\u00020\bH\u0016J\b\u00106\u001a\u00020\bH\u0016J\u0010\u00107\u001a\u00020-2\u0006\u00101\u001a\u00020\bH\u0016J\b\u00108\u001a\u00020\u0004H\u0016R\u001b\u0010\u000e\u001a\u00020\b8BX\u0002¢\u0006\f\n\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u000f\u0010\u0010R\u001a\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00140\nX\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016R\u001c\u0010\u0017\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00140\n0\u0018X\u0004¢\u0006\u0004\n\u0002\u0010\u0019R\u0016\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u00010\u0018X\u0004¢\u0006\u0004\n\u0002\u0010\u001bR\u0016\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\u00040\u0018X\u0004¢\u0006\u0004\n\u0002\u0010\u001dR\u000e\u0010\u001e\u001a\u00020\u001fX\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0007\u001a\u00020\bX\u0004¢\u0006\b\n\u0000\u001a\u0004\b \u0010\u0010R\u0014\u0010\u0005\u001a\u00020\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b!\u0010\"R\u001a\u0010#\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\b0$X\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0003\u001a\u00020\u0004X\u0004¢\u0006\b\n\u0000\u001a\u0004\b%\u0010&R\u001a\u0010'\u001a\b\u0012\u0004\u0012\u00020\u00040(X\u0004¢\u0006\b\n\u0000\u001a\u0004\b)\u0010*R\u0016\u0010+\u001a\b\u0012\u0004\u0012\u00020\u00010\u0018X\u0004¢\u0006\u0004\n\u0002\u0010\u001b¨\u00069"}, d2 = {"Lkotlinx/serialization/descriptors/SerialDescriptorImpl;", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "Lkotlinx/serialization/internal/CachedNames;", "serialName", "", "kind", "Lkotlinx/serialization/descriptors/SerialKind;", "elementsCount", "", "typeParameters", "", "builder", "Lkotlinx/serialization/descriptors/ClassSerialDescriptorBuilder;", "(Ljava/lang/String;Lkotlinx/serialization/descriptors/SerialKind;ILjava/util/List;Lkotlinx/serialization/descriptors/ClassSerialDescriptorBuilder;)V", "_hashCode", "get_hashCode", "()I", "_hashCode$delegate", "Lkotlin/Lazy;", "annotations", "", "getAnnotations", "()Ljava/util/List;", "elementAnnotations", "", "[Ljava/util/List;", "elementDescriptors", "[Lkotlinx/serialization/descriptors/SerialDescriptor;", "elementNames", "[Ljava/lang/String;", "elementOptionality", "", "getElementsCount", "getKind", "()Lkotlinx/serialization/descriptors/SerialKind;", "name2Index", "", "getSerialName", "()Ljava/lang/String;", "serialNames", "", "getSerialNames", "()Ljava/util/Set;", "typeParametersDescriptors", "equals", "", "other", "", "getElementAnnotations", "index", "getElementDescriptor", "getElementIndex", "name", "getElementName", "hashCode", "isElementOptional", "toString", "kotlinx-serialization-core"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class SerialDescriptorImpl implements SerialDescriptor, CachedNames {
    @NotNull
    private final Lazy _hashCode$delegate;
    @NotNull
    private final List<Annotation> annotations;
    @NotNull
    private final List<Annotation>[] elementAnnotations;
    @NotNull
    private final SerialDescriptor[] elementDescriptors;
    @NotNull
    private final String[] elementNames;
    @NotNull
    private final boolean[] elementOptionality;
    private final int elementsCount;
    @NotNull
    private final SerialKind kind;
    @NotNull
    private final Map<String, Integer> name2Index;
    @NotNull
    private final String serialName;
    @NotNull
    private final Set<String> serialNames;
    /* access modifiers changed from: private */
    @NotNull
    public final SerialDescriptor[] typeParametersDescriptors;

    public SerialDescriptorImpl(@NotNull String str, @NotNull SerialKind serialKind, int i11, @NotNull List<? extends SerialDescriptor> list, @NotNull ClassSerialDescriptorBuilder classSerialDescriptorBuilder) {
        Intrinsics.checkNotNullParameter(str, "serialName");
        Intrinsics.checkNotNullParameter(serialKind, FWFConstants.EXPLANATION_TYPE_KIND);
        Intrinsics.checkNotNullParameter(list, "typeParameters");
        Intrinsics.checkNotNullParameter(classSerialDescriptorBuilder, "builder");
        this.serialName = str;
        this.kind = serialKind;
        this.elementsCount = i11;
        this.annotations = classSerialDescriptorBuilder.getAnnotations();
        this.serialNames = CollectionsKt___CollectionsKt.toHashSet(classSerialDescriptorBuilder.getElementNames$kotlinx_serialization_core());
        Object[] array = classSerialDescriptorBuilder.getElementNames$kotlinx_serialization_core().toArray(new String[0]);
        if (array != null) {
            String[] strArr = (String[]) array;
            this.elementNames = strArr;
            this.elementDescriptors = Platform_commonKt.compactArray(classSerialDescriptorBuilder.getElementDescriptors$kotlinx_serialization_core());
            Object[] array2 = classSerialDescriptorBuilder.getElementAnnotations$kotlinx_serialization_core().toArray(new List[0]);
            if (array2 != null) {
                this.elementAnnotations = (List[]) array2;
                this.elementOptionality = CollectionsKt___CollectionsKt.toBooleanArray(classSerialDescriptorBuilder.getElementOptionality$kotlinx_serialization_core());
                Iterable<IndexedValue> withIndex = ArraysKt___ArraysKt.withIndex((T[]) strArr);
                ArrayList arrayList = new ArrayList(CollectionsKt__IterablesKt.collectionSizeOrDefault(withIndex, 10));
                for (IndexedValue indexedValue : withIndex) {
                    arrayList.add(TuplesKt.to(indexedValue.getValue(), Integer.valueOf(indexedValue.getIndex())));
                }
                this.name2Index = MapsKt__MapsKt.toMap(arrayList);
                this.typeParametersDescriptors = Platform_commonKt.compactArray(list);
                this._hashCode$delegate = LazyKt__LazyJVMKt.lazy(new SerialDescriptorImpl$_hashCode$2(this));
                return;
            }
            throw new NullPointerException("null cannot be cast to non-null type kotlin.Array<T of kotlin.collections.ArraysKt__ArraysJVMKt.toTypedArray>");
        }
        throw new NullPointerException("null cannot be cast to non-null type kotlin.Array<T of kotlin.collections.ArraysKt__ArraysJVMKt.toTypedArray>");
    }

    private final int get_hashCode() {
        return ((Number) this._hashCode$delegate.getValue()).intValue();
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof SerialDescriptorImpl) {
            SerialDescriptor serialDescriptor = (SerialDescriptor) obj;
            if (Intrinsics.areEqual((Object) getSerialName(), (Object) serialDescriptor.getSerialName()) && Arrays.equals(this.typeParametersDescriptors, ((SerialDescriptorImpl) obj).typeParametersDescriptors) && getElementsCount() == serialDescriptor.getElementsCount()) {
                int elementsCount2 = getElementsCount();
                int i11 = 0;
                while (i11 < elementsCount2) {
                    if (Intrinsics.areEqual((Object) getElementDescriptor(i11).getSerialName(), (Object) serialDescriptor.getElementDescriptor(i11).getSerialName()) && Intrinsics.areEqual((Object) getElementDescriptor(i11).getKind(), (Object) serialDescriptor.getElementDescriptor(i11).getKind())) {
                        i11++;
                    }
                }
                return true;
            }
        }
        return false;
    }

    @NotNull
    public List<Annotation> getAnnotations() {
        return this.annotations;
    }

    @NotNull
    public List<Annotation> getElementAnnotations(int i11) {
        return this.elementAnnotations[i11];
    }

    @NotNull
    public SerialDescriptor getElementDescriptor(int i11) {
        return this.elementDescriptors[i11];
    }

    public int getElementIndex(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "name");
        Integer num = this.name2Index.get(str);
        if (num != null) {
            return num.intValue();
        }
        return -3;
    }

    @NotNull
    public String getElementName(int i11) {
        return this.elementNames[i11];
    }

    public int getElementsCount() {
        return this.elementsCount;
    }

    @NotNull
    public SerialKind getKind() {
        return this.kind;
    }

    @NotNull
    public String getSerialName() {
        return this.serialName;
    }

    @NotNull
    public Set<String> getSerialNames() {
        return this.serialNames;
    }

    public int hashCode() {
        return get_hashCode();
    }

    public boolean isElementOptional(int i11) {
        return this.elementOptionality[i11];
    }

    public boolean isInline() {
        return SerialDescriptor.DefaultImpls.isInline(this);
    }

    public boolean isNullable() {
        return SerialDescriptor.DefaultImpls.isNullable(this);
    }

    @NotNull
    public String toString() {
        IntRange until = RangesKt___RangesKt.until(0, getElementsCount());
        return CollectionsKt___CollectionsKt.joinToString$default(until, IndicativeSentencesGeneration.DEFAULT_SEPARATOR, getSerialName() + '(', ")", 0, (CharSequence) null, new SerialDescriptorImpl$toString$1(this), 24, (Object) null);
    }
}
