package kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement;

import java.util.Map;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;

public final class AbstractSignatureParts$computeIndexedQualifiers$1 extends Lambda implements Function1<Integer, JavaTypeQualifiers> {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ TypeEnhancementInfo f24664g;

    /* renamed from: h  reason: collision with root package name */
    public final /* synthetic */ JavaTypeQualifiers[] f24665h;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public AbstractSignatureParts$computeIndexedQualifiers$1(TypeEnhancementInfo typeEnhancementInfo, JavaTypeQualifiers[] javaTypeQualifiersArr) {
        super(1);
        this.f24664g = typeEnhancementInfo;
        this.f24665h = javaTypeQualifiersArr;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        return invoke(((Number) obj).intValue());
    }

    @NotNull
    public final JavaTypeQualifiers invoke(int i11) {
        Map<Integer, JavaTypeQualifiers> map;
        JavaTypeQualifiers javaTypeQualifiers;
        TypeEnhancementInfo typeEnhancementInfo = this.f24664g;
        if (typeEnhancementInfo != null && (map = typeEnhancementInfo.getMap()) != null && (javaTypeQualifiers = map.get(Integer.valueOf(i11))) != null) {
            return javaTypeQualifiers;
        }
        JavaTypeQualifiers[] javaTypeQualifiersArr = this.f24665h;
        return (i11 < 0 || i11 > ArraysKt___ArraysKt.getLastIndex((T[]) javaTypeQualifiersArr)) ? JavaTypeQualifiers.Companion.getNONE() : javaTypeQualifiersArr[i11];
    }
}
