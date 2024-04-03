package kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement;

import androidx.exifinterface.media.ExifInterface;
import com.newrelic.agent.android.agentdata.HexAttribute;
import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.IndexedValue;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.load.kotlin.SignatureBuildingComponents;
import kotlin.reflect.jvm.internal.impl.resolve.jvm.JvmPrimitiveType;
import org.jetbrains.annotations.NotNull;

final class SignatureEnhancementBuilder {
    /* access modifiers changed from: private */
    @NotNull
    public final Map<String, PredefinedFunctionEnhancementInfo> signatures = new LinkedHashMap();

    @NotNull
    public final Map<String, PredefinedFunctionEnhancementInfo> build() {
        return this.signatures;
    }

    public final class ClassEnhancementBuilder {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ SignatureEnhancementBuilder f24704a;
        @NotNull
        private final String className;

        public ClassEnhancementBuilder(@NotNull SignatureEnhancementBuilder signatureEnhancementBuilder, String str) {
            Intrinsics.checkNotNullParameter(str, HexAttribute.HEX_ATTR_CLASS_NAME);
            this.f24704a = signatureEnhancementBuilder;
            this.className = str;
        }

        public final void function(@NotNull String str, @NotNull Function1<? super FunctionEnhancementBuilder, Unit> function1) {
            Intrinsics.checkNotNullParameter(str, "name");
            Intrinsics.checkNotNullParameter(function1, "block");
            Map access$getSignatures$p = this.f24704a.signatures;
            FunctionEnhancementBuilder functionEnhancementBuilder = new FunctionEnhancementBuilder(this, str);
            function1.invoke(functionEnhancementBuilder);
            Pair<String, PredefinedFunctionEnhancementInfo> build = functionEnhancementBuilder.build();
            access$getSignatures$p.put(build.getFirst(), build.getSecond());
        }

        @NotNull
        public final String getClassName() {
            return this.className;
        }

        public final class FunctionEnhancementBuilder {

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ ClassEnhancementBuilder f24705a;
            @NotNull
            private final String functionName;
            @NotNull
            private final List<Pair<String, TypeEnhancementInfo>> parameters = new ArrayList();
            @NotNull
            private Pair<String, TypeEnhancementInfo> returnType = TuplesKt.to(ExifInterface.GPS_MEASUREMENT_INTERRUPTED, null);

            public FunctionEnhancementBuilder(@NotNull ClassEnhancementBuilder classEnhancementBuilder, String str) {
                Intrinsics.checkNotNullParameter(str, "functionName");
                this.f24705a = classEnhancementBuilder;
                this.functionName = str;
            }

            @NotNull
            public final Pair<String, PredefinedFunctionEnhancementInfo> build() {
                SignatureBuildingComponents signatureBuildingComponents = SignatureBuildingComponents.INSTANCE;
                String className = this.f24705a.getClassName();
                String str = this.functionName;
                Iterable<Pair> iterable = this.parameters;
                ArrayList arrayList = new ArrayList(CollectionsKt__IterablesKt.collectionSizeOrDefault(iterable, 10));
                for (Pair first : iterable) {
                    arrayList.add((String) first.getFirst());
                }
                String signature = signatureBuildingComponents.signature(className, signatureBuildingComponents.jvmDescriptor(str, arrayList, this.returnType.getFirst()));
                TypeEnhancementInfo second = this.returnType.getSecond();
                Iterable<Pair> iterable2 = this.parameters;
                ArrayList arrayList2 = new ArrayList(CollectionsKt__IterablesKt.collectionSizeOrDefault(iterable2, 10));
                for (Pair second2 : iterable2) {
                    arrayList2.add((TypeEnhancementInfo) second2.getSecond());
                }
                return TuplesKt.to(signature, new PredefinedFunctionEnhancementInfo(second, arrayList2));
            }

            public final void parameter(@NotNull String str, @NotNull JavaTypeQualifiers... javaTypeQualifiersArr) {
                boolean z11;
                TypeEnhancementInfo typeEnhancementInfo;
                Intrinsics.checkNotNullParameter(str, "type");
                Intrinsics.checkNotNullParameter(javaTypeQualifiersArr, "qualifiers");
                Collection collection = this.parameters;
                if (javaTypeQualifiersArr.length == 0) {
                    z11 = true;
                } else {
                    z11 = false;
                }
                if (z11) {
                    typeEnhancementInfo = null;
                } else {
                    Iterable<IndexedValue> withIndex = ArraysKt___ArraysKt.withIndex((T[]) javaTypeQualifiersArr);
                    LinkedHashMap linkedHashMap = new LinkedHashMap(RangesKt___RangesKt.coerceAtLeast(MapsKt__MapsJVMKt.mapCapacity(CollectionsKt__IterablesKt.collectionSizeOrDefault(withIndex, 10)), 16));
                    for (IndexedValue indexedValue : withIndex) {
                        linkedHashMap.put(Integer.valueOf(indexedValue.getIndex()), (JavaTypeQualifiers) indexedValue.getValue());
                    }
                    typeEnhancementInfo = new TypeEnhancementInfo(linkedHashMap);
                }
                collection.add(TuplesKt.to(str, typeEnhancementInfo));
            }

            public final void returns(@NotNull String str, @NotNull JavaTypeQualifiers... javaTypeQualifiersArr) {
                Intrinsics.checkNotNullParameter(str, "type");
                Intrinsics.checkNotNullParameter(javaTypeQualifiersArr, "qualifiers");
                Iterable<IndexedValue> withIndex = ArraysKt___ArraysKt.withIndex((T[]) javaTypeQualifiersArr);
                LinkedHashMap linkedHashMap = new LinkedHashMap(RangesKt___RangesKt.coerceAtLeast(MapsKt__MapsJVMKt.mapCapacity(CollectionsKt__IterablesKt.collectionSizeOrDefault(withIndex, 10)), 16));
                for (IndexedValue indexedValue : withIndex) {
                    linkedHashMap.put(Integer.valueOf(indexedValue.getIndex()), (JavaTypeQualifiers) indexedValue.getValue());
                }
                this.returnType = TuplesKt.to(str, new TypeEnhancementInfo(linkedHashMap));
            }

            public final void returns(@NotNull JvmPrimitiveType jvmPrimitiveType) {
                Intrinsics.checkNotNullParameter(jvmPrimitiveType, "type");
                String desc = jvmPrimitiveType.getDesc();
                Intrinsics.checkNotNullExpressionValue(desc, "type.desc");
                this.returnType = TuplesKt.to(desc, null);
            }
        }
    }
}
