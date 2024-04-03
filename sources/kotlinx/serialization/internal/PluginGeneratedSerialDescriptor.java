package kotlinx.serialization.internal;

import java.lang.annotation.Annotation;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.Lazy;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;
import kotlin.PublishedApi;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.IntRange;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.descriptors.SerialDescriptor;
import kotlinx.serialization.descriptors.SerialKind;
import kotlinx.serialization.descriptors.StructureKind;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.junit.jupiter.api.IndicativeSentencesGeneration;

@Metadata(d1 = {"\u0000v\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0010 \n\u0002\u0010\u001b\n\u0002\b\u0003\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010!\n\u0002\b\u0002\n\u0002\u0010\u0018\n\u0000\n\u0002\u0010$\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\"\n\u0002\b\u0007\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u0000\n\u0002\b\r\b\u0011\u0018\u00002\u00020\u00012\u00020\u0002B%\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u000e\b\u0002\u0010\u0005\u001a\b\u0012\u0002\b\u0003\u0018\u00010\u0006\u0012\u0006\u0010\u0007\u001a\u00020\b¢\u0006\u0002\u0010\tJ\u0018\u00104\u001a\u0002052\u0006\u00106\u001a\u00020\u00042\b\b\u0002\u00107\u001a\u000208J\u0014\u00109\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\b0!H\u0002J\u0013\u0010:\u001a\u0002082\b\u0010;\u001a\u0004\u0018\u00010<H\u0002J\u0016\u0010=\u001a\b\u0012\u0004\u0012\u00020\u00120\u00112\u0006\u0010>\u001a\u00020\bH\u0016J\u0010\u0010?\u001a\u00020\u00012\u0006\u0010>\u001a\u00020\bH\u0016J\u0010\u0010@\u001a\u00020\b2\u0006\u00106\u001a\u00020\u0004H\u0016J\u0010\u0010A\u001a\u00020\u00042\u0006\u0010>\u001a\u00020\bH\u0016J\b\u0010B\u001a\u00020\bH\u0016J\u0010\u0010C\u001a\u0002082\u0006\u0010>\u001a\u00020\bH\u0016J\u000e\u0010D\u001a\u0002052\u0006\u0010E\u001a\u00020\u0012J\u000e\u0010F\u001a\u0002052\u0006\u0010G\u001a\u00020\u0012J\b\u0010H\u001a\u00020\u0004H\u0016R\u001b\u0010\n\u001a\u00020\b8BX\u0002¢\u0006\f\n\u0004\b\r\u0010\u000e\u001a\u0004\b\u000b\u0010\fR\u000e\u0010\u000f\u001a\u00020\bX\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00120\u00118VX\u0004¢\u0006\u0006\u001a\u0004\b\u0013\u0010\u0014R%\u0010\u0015\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00170\u00168BX\u0002¢\u0006\f\n\u0004\b\u001a\u0010\u000e\u001a\u0004\b\u0018\u0010\u0019R\u0016\u0010\u001b\u001a\n\u0012\u0004\u0012\u00020\u0012\u0018\u00010\u001cX\u000e¢\u0006\u0002\n\u0000R\u0011\u0010\u0007\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\fR\u000e\u0010\u001e\u001a\u00020\u001fX\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0005\u001a\b\u0012\u0002\b\u0003\u0018\u00010\u0006X\u0004¢\u0006\u0002\n\u0000R\u001a\u0010 \u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\b0!X\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\"\u001a\u00020#8VX\u0004¢\u0006\u0006\u001a\u0004\b$\u0010%R\u0016\u0010&\u001a\b\u0012\u0004\u0012\u00020\u00040\u0016X\u0004¢\u0006\u0004\n\u0002\u0010'R\u001e\u0010(\u001a\u0010\u0012\f\u0012\n\u0012\u0004\u0012\u00020\u0012\u0018\u00010\u001c0\u0016X\u0004¢\u0006\u0004\n\u0002\u0010)R\u0014\u0010\u0003\u001a\u00020\u0004X\u0004¢\u0006\b\n\u0000\u001a\u0004\b*\u0010+R\u001a\u0010,\u001a\b\u0012\u0004\u0012\u00020\u00040-8VX\u0004¢\u0006\u0006\u001a\u0004\b.\u0010/R!\u00100\u001a\b\u0012\u0004\u0012\u00020\u00010\u00168@X\u0002¢\u0006\f\n\u0004\b3\u0010\u000e\u001a\u0004\b1\u00102¨\u0006I"}, d2 = {"Lkotlinx/serialization/internal/PluginGeneratedSerialDescriptor;", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "Lkotlinx/serialization/internal/CachedNames;", "serialName", "", "generatedSerializer", "Lkotlinx/serialization/internal/GeneratedSerializer;", "elementsCount", "", "(Ljava/lang/String;Lkotlinx/serialization/internal/GeneratedSerializer;I)V", "_hashCode", "get_hashCode", "()I", "_hashCode$delegate", "Lkotlin/Lazy;", "added", "annotations", "", "", "getAnnotations", "()Ljava/util/List;", "childSerializers", "", "Lkotlinx/serialization/KSerializer;", "getChildSerializers", "()[Lkotlinx/serialization/KSerializer;", "childSerializers$delegate", "classAnnotations", "", "getElementsCount", "elementsOptionality", "", "indices", "", "kind", "Lkotlinx/serialization/descriptors/SerialKind;", "getKind", "()Lkotlinx/serialization/descriptors/SerialKind;", "names", "[Ljava/lang/String;", "propertiesAnnotations", "[Ljava/util/List;", "getSerialName", "()Ljava/lang/String;", "serialNames", "", "getSerialNames", "()Ljava/util/Set;", "typeParameterDescriptors", "getTypeParameterDescriptors$kotlinx_serialization_core", "()[Lkotlinx/serialization/descriptors/SerialDescriptor;", "typeParameterDescriptors$delegate", "addElement", "", "name", "isOptional", "", "buildIndices", "equals", "other", "", "getElementAnnotations", "index", "getElementDescriptor", "getElementIndex", "getElementName", "hashCode", "isElementOptional", "pushAnnotation", "annotation", "pushClassAnnotation", "a", "toString", "kotlinx-serialization-core"}, k = 1, mv = {1, 6, 0}, xi = 48)
@PublishedApi
public class PluginGeneratedSerialDescriptor implements SerialDescriptor, CachedNames {
    @NotNull
    private final Lazy _hashCode$delegate;
    private int added;
    @NotNull
    private final Lazy childSerializers$delegate;
    @Nullable
    private List<Annotation> classAnnotations;
    private final int elementsCount;
    @NotNull
    private final boolean[] elementsOptionality;
    /* access modifiers changed from: private */
    @Nullable
    public final GeneratedSerializer<?> generatedSerializer;
    @NotNull
    private Map<String, Integer> indices;
    @NotNull
    private final String[] names;
    @NotNull
    private final List<Annotation>[] propertiesAnnotations;
    @NotNull
    private final String serialName;
    @NotNull
    private final Lazy typeParameterDescriptors$delegate;

    public PluginGeneratedSerialDescriptor(@NotNull String str, @Nullable GeneratedSerializer<?> generatedSerializer2, int i11) {
        Intrinsics.checkNotNullParameter(str, "serialName");
        this.serialName = str;
        this.generatedSerializer = generatedSerializer2;
        this.elementsCount = i11;
        this.added = -1;
        String[] strArr = new String[i11];
        for (int i12 = 0; i12 < i11; i12++) {
            strArr[i12] = "[UNINITIALIZED]";
        }
        this.names = strArr;
        int i13 = this.elementsCount;
        this.propertiesAnnotations = new List[i13];
        this.elementsOptionality = new boolean[i13];
        this.indices = MapsKt__MapsKt.emptyMap();
        LazyThreadSafetyMode lazyThreadSafetyMode = LazyThreadSafetyMode.PUBLICATION;
        this.childSerializers$delegate = LazyKt__LazyJVMKt.lazy(lazyThreadSafetyMode, new PluginGeneratedSerialDescriptor$childSerializers$2(this));
        this.typeParameterDescriptors$delegate = LazyKt__LazyJVMKt.lazy(lazyThreadSafetyMode, new PluginGeneratedSerialDescriptor$typeParameterDescriptors$2(this));
        this._hashCode$delegate = LazyKt__LazyJVMKt.lazy(lazyThreadSafetyMode, new PluginGeneratedSerialDescriptor$_hashCode$2(this));
    }

    public static /* synthetic */ void addElement$default(PluginGeneratedSerialDescriptor pluginGeneratedSerialDescriptor, String str, boolean z11, int i11, Object obj) {
        if (obj == null) {
            if ((i11 & 2) != 0) {
                z11 = false;
            }
            pluginGeneratedSerialDescriptor.addElement(str, z11);
            return;
        }
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: addElement");
    }

    private final Map<String, Integer> buildIndices() {
        HashMap hashMap = new HashMap();
        int length = this.names.length;
        for (int i11 = 0; i11 < length; i11++) {
            hashMap.put(this.names[i11], Integer.valueOf(i11));
        }
        return hashMap;
    }

    private final KSerializer<?>[] getChildSerializers() {
        return (KSerializer[]) this.childSerializers$delegate.getValue();
    }

    private final int get_hashCode() {
        return ((Number) this._hashCode$delegate.getValue()).intValue();
    }

    public final void addElement(@NotNull String str, boolean z11) {
        Intrinsics.checkNotNullParameter(str, "name");
        String[] strArr = this.names;
        int i11 = this.added + 1;
        this.added = i11;
        strArr[i11] = str;
        this.elementsOptionality[i11] = z11;
        this.propertiesAnnotations[i11] = null;
        if (i11 == this.elementsCount - 1) {
            this.indices = buildIndices();
        }
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof PluginGeneratedSerialDescriptor) {
            SerialDescriptor serialDescriptor = (SerialDescriptor) obj;
            if (Intrinsics.areEqual((Object) getSerialName(), (Object) serialDescriptor.getSerialName()) && Arrays.equals(getTypeParameterDescriptors$kotlinx_serialization_core(), ((PluginGeneratedSerialDescriptor) obj).getTypeParameterDescriptors$kotlinx_serialization_core()) && getElementsCount() == serialDescriptor.getElementsCount()) {
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
        List<Annotation> list = this.classAnnotations;
        return list == null ? CollectionsKt__CollectionsKt.emptyList() : list;
    }

    @NotNull
    public List<Annotation> getElementAnnotations(int i11) {
        List<Annotation> list = this.propertiesAnnotations[i11];
        if (list == null) {
            return CollectionsKt__CollectionsKt.emptyList();
        }
        return list;
    }

    @NotNull
    public SerialDescriptor getElementDescriptor(int i11) {
        return getChildSerializers()[i11].getDescriptor();
    }

    public int getElementIndex(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "name");
        Integer num = this.indices.get(str);
        if (num != null) {
            return num.intValue();
        }
        return -3;
    }

    @NotNull
    public String getElementName(int i11) {
        return this.names[i11];
    }

    public final int getElementsCount() {
        return this.elementsCount;
    }

    @NotNull
    public SerialKind getKind() {
        return StructureKind.CLASS.INSTANCE;
    }

    @NotNull
    public String getSerialName() {
        return this.serialName;
    }

    @NotNull
    public Set<String> getSerialNames() {
        return this.indices.keySet();
    }

    @NotNull
    public final SerialDescriptor[] getTypeParameterDescriptors$kotlinx_serialization_core() {
        return (SerialDescriptor[]) this.typeParameterDescriptors$delegate.getValue();
    }

    public int hashCode() {
        return get_hashCode();
    }

    public boolean isElementOptional(int i11) {
        return this.elementsOptionality[i11];
    }

    public boolean isInline() {
        return SerialDescriptor.DefaultImpls.isInline(this);
    }

    public boolean isNullable() {
        return SerialDescriptor.DefaultImpls.isNullable(this);
    }

    public final void pushAnnotation(@NotNull Annotation annotation) {
        Intrinsics.checkNotNullParameter(annotation, "annotation");
        List<Annotation> list = this.propertiesAnnotations[this.added];
        if (list == null) {
            list = new ArrayList<>(1);
            this.propertiesAnnotations[this.added] = list;
        }
        list.add(annotation);
    }

    public final void pushClassAnnotation(@NotNull Annotation annotation) {
        Intrinsics.checkNotNullParameter(annotation, "a");
        if (this.classAnnotations == null) {
            this.classAnnotations = new ArrayList(1);
        }
        List<Annotation> list = this.classAnnotations;
        Intrinsics.checkNotNull(list);
        list.add(annotation);
    }

    @NotNull
    public String toString() {
        IntRange until = RangesKt___RangesKt.until(0, this.elementsCount);
        return CollectionsKt___CollectionsKt.joinToString$default(until, IndicativeSentencesGeneration.DEFAULT_SEPARATOR, getSerialName() + '(', ")", 0, (CharSequence) null, new PluginGeneratedSerialDescriptor$toString$1(this), 24, (Object) null);
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ PluginGeneratedSerialDescriptor(String str, GeneratedSerializer generatedSerializer2, int i11, int i12, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, (i12 & 2) != 0 ? null : generatedSerializer2, i11);
    }
}
