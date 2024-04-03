package kotlinx.serialization.descriptors;

import java.lang.annotation.Annotation;
import java.util.List;
import kotlin.Metadata;
import kotlinx.serialization.ExperimentalSerializationApi;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010 \n\u0002\u0010\u001b\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u000b\bf\u0018\u00002\u00020\u0001J\u0016\u0010\u001e\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\u0006\u0010\u001f\u001a\u00020\nH'J\u0010\u0010 \u001a\u00020\u00002\u0006\u0010\u001f\u001a\u00020\nH'J\u0010\u0010!\u001a\u00020\n2\u0006\u0010\"\u001a\u00020\u001aH'J\u0010\u0010#\u001a\u00020\u001a2\u0006\u0010\u001f\u001a\u00020\nH'J\u0010\u0010$\u001a\u00020\u000f2\u0006\u0010\u001f\u001a\u00020\nH'R \u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u00038VX\u0004¢\u0006\f\u0012\u0004\b\u0005\u0010\u0006\u001a\u0004\b\u0007\u0010\bR\u001a\u0010\t\u001a\u00020\n8&X§\u0004¢\u0006\f\u0012\u0004\b\u000b\u0010\u0006\u001a\u0004\b\f\u0010\rR\u001a\u0010\u000e\u001a\u00020\u000f8VX\u0004¢\u0006\f\u0012\u0004\b\u0010\u0010\u0006\u001a\u0004\b\u000e\u0010\u0011R\u001a\u0010\u0012\u001a\u00020\u000f8VX\u0004¢\u0006\f\u0012\u0004\b\u0013\u0010\u0006\u001a\u0004\b\u0012\u0010\u0011R\u001a\u0010\u0014\u001a\u00020\u00158&X§\u0004¢\u0006\f\u0012\u0004\b\u0016\u0010\u0006\u001a\u0004\b\u0017\u0010\u0018R\u001a\u0010\u0019\u001a\u00020\u001a8&X§\u0004¢\u0006\f\u0012\u0004\b\u001b\u0010\u0006\u001a\u0004\b\u001c\u0010\u001d¨\u0006%"}, d2 = {"Lkotlinx/serialization/descriptors/SerialDescriptor;", "", "annotations", "", "", "getAnnotations$annotations", "()V", "getAnnotations", "()Ljava/util/List;", "elementsCount", "", "getElementsCount$annotations", "getElementsCount", "()I", "isInline", "", "isInline$annotations", "()Z", "isNullable", "isNullable$annotations", "kind", "Lkotlinx/serialization/descriptors/SerialKind;", "getKind$annotations", "getKind", "()Lkotlinx/serialization/descriptors/SerialKind;", "serialName", "", "getSerialName$annotations", "getSerialName", "()Ljava/lang/String;", "getElementAnnotations", "index", "getElementDescriptor", "getElementIndex", "name", "getElementName", "isElementOptional", "kotlinx-serialization-core"}, k = 1, mv = {1, 6, 0}, xi = 48)
public interface SerialDescriptor {

    @Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
    public static final class DefaultImpls {
        @NotNull
        public static List<Annotation> getAnnotations(@NotNull SerialDescriptor serialDescriptor) {
            return CollectionsKt__CollectionsKt.emptyList();
        }

        @ExperimentalSerializationApi
        public static /* synthetic */ void getAnnotations$annotations() {
        }

        @ExperimentalSerializationApi
        public static /* synthetic */ void getElementsCount$annotations() {
        }

        @ExperimentalSerializationApi
        public static /* synthetic */ void getKind$annotations() {
        }

        @ExperimentalSerializationApi
        public static /* synthetic */ void getSerialName$annotations() {
        }

        public static boolean isInline(@NotNull SerialDescriptor serialDescriptor) {
            return false;
        }

        @ExperimentalSerializationApi
        public static /* synthetic */ void isInline$annotations() {
        }

        public static boolean isNullable(@NotNull SerialDescriptor serialDescriptor) {
            return false;
        }

        @ExperimentalSerializationApi
        public static /* synthetic */ void isNullable$annotations() {
        }
    }

    @NotNull
    List<Annotation> getAnnotations();

    @ExperimentalSerializationApi
    @NotNull
    List<Annotation> getElementAnnotations(int i11);

    @ExperimentalSerializationApi
    @NotNull
    SerialDescriptor getElementDescriptor(int i11);

    @ExperimentalSerializationApi
    int getElementIndex(@NotNull String str);

    @ExperimentalSerializationApi
    @NotNull
    String getElementName(int i11);

    int getElementsCount();

    @NotNull
    SerialKind getKind();

    @NotNull
    String getSerialName();

    @ExperimentalSerializationApi
    boolean isElementOptional(int i11);

    boolean isInline();

    boolean isNullable();
}
