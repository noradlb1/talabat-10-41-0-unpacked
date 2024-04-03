package kotlin.reflect.jvm.internal.impl.renderer;

import java.util.ArrayList;
import java.util.Set;
import kotlin.jvm.JvmField;
import kotlin.jvm.internal.DefaultConstructorMarker;
import org.jetbrains.annotations.NotNull;

public enum DescriptorRendererModifier {
    VISIBILITY(true),
    MODALITY(true),
    OVERRIDE(true),
    ANNOTATIONS(false),
    INNER(true),
    MEMBER_KIND(true),
    DATA(true),
    INLINE(true),
    EXPECT(true),
    ACTUAL(true),
    CONST(true),
    LATEINIT(true),
    FUN(true),
    VALUE(true);
    
    @NotNull
    @JvmField
    public static final Set<DescriptorRendererModifier> ALL = null;
    @NotNull
    @JvmField
    public static final Set<DescriptorRendererModifier> ALL_EXCEPT_ANNOTATIONS = null;
    @NotNull
    public static final Companion Companion = null;
    private final boolean includeByDefault;

    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* access modifiers changed from: public */
    static {
        int i11;
        Companion = new Companion((DefaultConstructorMarker) null);
        DescriptorRendererModifier[] values = values();
        ArrayList arrayList = new ArrayList();
        for (DescriptorRendererModifier descriptorRendererModifier : values) {
            if (descriptorRendererModifier.includeByDefault) {
                arrayList.add(descriptorRendererModifier);
            }
        }
        ALL_EXCEPT_ANNOTATIONS = CollectionsKt___CollectionsKt.toSet(arrayList);
        ALL = ArraysKt___ArraysKt.toSet((T[]) values());
    }

    private DescriptorRendererModifier(boolean z11) {
        this.includeByDefault = z11;
    }
}
