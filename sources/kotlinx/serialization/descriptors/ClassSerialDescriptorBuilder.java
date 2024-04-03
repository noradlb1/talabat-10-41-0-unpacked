package kotlinx.serialization.descriptors;

import java.lang.annotation.Annotation;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.ExperimentalSerializationApi;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0010\u001b\n\u0002\b\u0007\n\u0002\u0010!\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\t\n\u0002\u0010#\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u000f\b\u0000\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J0\u0010\"\u001a\u00020#2\u0006\u0010$\u001a\u00020\u00032\u0006\u0010%\u001a\u00020\u00122\u000e\b\u0002\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u00062\b\b\u0002\u0010&\u001a\u00020\u0017R*\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u00068\u0006@\u0006X\u000e¢\u0006\u0014\n\u0000\u0012\u0004\b\b\u0010\t\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\rR \u0010\u000e\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00070\u00060\u000fX\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u000bR\u001a\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00120\u000fX\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u000bR\u001a\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00030\u000fX\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u000bR\u001a\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00170\u000fX\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u000bR$\u0010\u0019\u001a\u00020\u00178\u0006@\u0006X\u000e¢\u0006\u0014\n\u0000\u0012\u0004\b\u001a\u0010\t\u001a\u0004\b\u0019\u0010\u001b\"\u0004\b\u001c\u0010\u001dR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u001fR\u0014\u0010 \u001a\b\u0012\u0004\u0012\u00020\u00030!X\u0004¢\u0006\u0002\n\u0000¨\u0006'"}, d2 = {"Lkotlinx/serialization/descriptors/ClassSerialDescriptorBuilder;", "", "serialName", "", "(Ljava/lang/String;)V", "annotations", "", "", "getAnnotations$annotations", "()V", "getAnnotations", "()Ljava/util/List;", "setAnnotations", "(Ljava/util/List;)V", "elementAnnotations", "", "getElementAnnotations$kotlinx_serialization_core", "elementDescriptors", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "getElementDescriptors$kotlinx_serialization_core", "elementNames", "getElementNames$kotlinx_serialization_core", "elementOptionality", "", "getElementOptionality$kotlinx_serialization_core", "isNullable", "isNullable$annotations", "()Z", "setNullable", "(Z)V", "getSerialName", "()Ljava/lang/String;", "uniqueNames", "", "element", "", "elementName", "descriptor", "isOptional", "kotlinx-serialization-core"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class ClassSerialDescriptorBuilder {
    @NotNull
    private List<? extends Annotation> annotations = CollectionsKt__CollectionsKt.emptyList();
    @NotNull
    private final List<List<Annotation>> elementAnnotations = new ArrayList();
    @NotNull
    private final List<SerialDescriptor> elementDescriptors = new ArrayList();
    @NotNull
    private final List<String> elementNames = new ArrayList();
    @NotNull
    private final List<Boolean> elementOptionality = new ArrayList();
    private boolean isNullable;
    @NotNull
    private final String serialName;
    @NotNull
    private final Set<String> uniqueNames = new HashSet();

    public ClassSerialDescriptorBuilder(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "serialName");
        this.serialName = str;
    }

    public static /* synthetic */ void element$default(ClassSerialDescriptorBuilder classSerialDescriptorBuilder, String str, SerialDescriptor serialDescriptor, List list, boolean z11, int i11, Object obj) {
        if ((i11 & 4) != 0) {
            list = CollectionsKt__CollectionsKt.emptyList();
        }
        if ((i11 & 8) != 0) {
            z11 = false;
        }
        classSerialDescriptorBuilder.element(str, serialDescriptor, list, z11);
    }

    @ExperimentalSerializationApi
    public static /* synthetic */ void getAnnotations$annotations() {
    }

    @ExperimentalSerializationApi
    public static /* synthetic */ void isNullable$annotations() {
    }

    public final void element(@NotNull String str, @NotNull SerialDescriptor serialDescriptor, @NotNull List<? extends Annotation> list, boolean z11) {
        Intrinsics.checkNotNullParameter(str, "elementName");
        Intrinsics.checkNotNullParameter(serialDescriptor, "descriptor");
        Intrinsics.checkNotNullParameter(list, "annotations");
        if (this.uniqueNames.add(str)) {
            this.elementNames.add(str);
            this.elementDescriptors.add(serialDescriptor);
            this.elementAnnotations.add(list);
            this.elementOptionality.add(Boolean.valueOf(z11));
            return;
        }
        throw new IllegalArgumentException(("Element with name '" + str + "' is already registered").toString());
    }

    @NotNull
    public final List<Annotation> getAnnotations() {
        return this.annotations;
    }

    @NotNull
    public final List<List<Annotation>> getElementAnnotations$kotlinx_serialization_core() {
        return this.elementAnnotations;
    }

    @NotNull
    public final List<SerialDescriptor> getElementDescriptors$kotlinx_serialization_core() {
        return this.elementDescriptors;
    }

    @NotNull
    public final List<String> getElementNames$kotlinx_serialization_core() {
        return this.elementNames;
    }

    @NotNull
    public final List<Boolean> getElementOptionality$kotlinx_serialization_core() {
        return this.elementOptionality;
    }

    @NotNull
    public final String getSerialName() {
        return this.serialName;
    }

    public final boolean isNullable() {
        return this.isNullable;
    }

    public final void setAnnotations(@NotNull List<? extends Annotation> list) {
        Intrinsics.checkNotNullParameter(list, "<set-?>");
        this.annotations = list;
    }

    public final void setNullable(boolean z11) {
        this.isNullable = z11;
    }
}
