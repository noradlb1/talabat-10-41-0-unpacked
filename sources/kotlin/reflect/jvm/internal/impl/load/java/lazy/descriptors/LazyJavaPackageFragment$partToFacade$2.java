package kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors;

import java.util.HashMap;
import java.util.Map;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.reflect.jvm.internal.impl.load.kotlin.KotlinJvmBinaryClass;
import kotlin.reflect.jvm.internal.impl.load.kotlin.header.KotlinClassHeader;
import kotlin.reflect.jvm.internal.impl.resolve.jvm.JvmClassName;
import org.jetbrains.annotations.NotNull;

public final class LazyJavaPackageFragment$partToFacade$2 extends Lambda implements Function0<HashMap<JvmClassName, JvmClassName>> {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ LazyJavaPackageFragment f24623g;

    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[KotlinClassHeader.Kind.values().length];
            iArr[KotlinClassHeader.Kind.MULTIFILE_CLASS_PART.ordinal()] = 1;
            iArr[KotlinClassHeader.Kind.FILE_FACADE.ordinal()] = 2;
            $EnumSwitchMapping$0 = iArr;
        }
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public LazyJavaPackageFragment$partToFacade$2(LazyJavaPackageFragment lazyJavaPackageFragment) {
        super(0);
        this.f24623g = lazyJavaPackageFragment;
    }

    @NotNull
    public final HashMap<JvmClassName, JvmClassName> invoke() {
        HashMap<JvmClassName, JvmClassName> hashMap = new HashMap<>();
        for (Map.Entry next : this.f24623g.getBinaryClasses$descriptors_jvm().entrySet()) {
            JvmClassName byInternalName = JvmClassName.byInternalName((String) next.getKey());
            Intrinsics.checkNotNullExpressionValue(byInternalName, "byInternalName(partInternalName)");
            KotlinClassHeader classHeader = ((KotlinJvmBinaryClass) next.getValue()).getClassHeader();
            int i11 = WhenMappings.$EnumSwitchMapping$0[classHeader.getKind().ordinal()];
            if (i11 == 1) {
                String multifileClassName = classHeader.getMultifileClassName();
                if (multifileClassName != null) {
                    JvmClassName byInternalName2 = JvmClassName.byInternalName(multifileClassName);
                    Intrinsics.checkNotNullExpressionValue(byInternalName2, "byInternalName(header.mu…: continue@kotlinClasses)");
                    hashMap.put(byInternalName, byInternalName2);
                }
            } else if (i11 == 2) {
                hashMap.put(byInternalName, byInternalName);
            }
        }
        return hashMap;
    }
}
