package com.deliveryhero.fluid.values.codecs.scalar;

import com.deliveryhero.fluid.values.Enumeration;
import com.deliveryhero.fluid.values.ValueType;
import com.deliveryhero.fluid.values.codecs.ValueCodec;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Locale;
import java.util.NoSuchElementException;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\u000e\n\u0002\b\u0005\b&\u0018\u0000*\b\b\u0000\u0010\u0001*\u00020\u00022\b\u0012\u0004\u0012\u0002H\u00010\u0003B\u001b\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00028\u00000\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\u0015\u0010\u0010\u001a\u00028\u00002\u0006\u0010\u0011\u001a\u00020\u0012H\u0016¢\u0006\u0002\u0010\u0013J\u0015\u0010\u0014\u001a\u00020\u00122\u0006\u0010\u0015\u001a\u00028\u0000H\u0016¢\u0006\u0002\u0010\u0016R\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0014\u0010\u000b\u001a\u00020\u0007X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\nR\u0019\u0010\u0004\u001a\b\u0012\u0004\u0012\u00028\u00000\u0005¢\u0006\n\n\u0002\u0010\u000f\u001a\u0004\b\r\u0010\u000e¨\u0006\u0017"}, d2 = {"Lcom/deliveryhero/fluid/values/codecs/scalar/EnumerationCodec;", "EnumT", "Lcom/deliveryhero/fluid/values/Enumeration;", "Lcom/deliveryhero/fluid/values/codecs/ValueCodec$Scalar;", "values", "", "type", "Lcom/deliveryhero/fluid/values/ValueType;", "([Lcom/deliveryhero/fluid/values/Enumeration;Lcom/deliveryhero/fluid/values/ValueType;)V", "getType", "()Lcom/deliveryhero/fluid/values/ValueType;", "valueType", "getValueType", "getValues", "()[Lcom/deliveryhero/fluid/values/Enumeration;", "[Lcom/deliveryhero/fluid/values/Enumeration;", "decode", "encoded", "", "(Ljava/lang/String;)Lcom/deliveryhero/fluid/values/Enumeration;", "encode", "decoded", "(Lcom/deliveryhero/fluid/values/Enumeration;)Ljava/lang/String;", "core_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
public abstract class EnumerationCodec<EnumT extends Enumeration> implements ValueCodec.Scalar<EnumT> {
    @NotNull
    private final ValueType type;
    @NotNull
    private final ValueType valueType;
    @NotNull
    private final EnumT[] values;

    public EnumerationCodec(@NotNull EnumT[] enumtArr, @NotNull ValueType valueType2) {
        Intrinsics.checkNotNullParameter(enumtArr, "values");
        Intrinsics.checkNotNullParameter(valueType2, "type");
        this.values = enumtArr;
        this.type = valueType2;
        int length = enumtArr.length;
        boolean z11 = false;
        int i11 = 0;
        while (i11 < length) {
            EnumT enumt = enumtArr[i11];
            String id2 = enumt.getId();
            String lowerCase = enumt.getId().toLowerCase(Locale.ROOT);
            Intrinsics.checkNotNullExpressionValue(lowerCase, "this as java.lang.String).toLowerCase(Locale.ROOT)");
            if (Intrinsics.areEqual((Object) id2, (Object) lowerCase)) {
                i11++;
            } else {
                throw new IllegalArgumentException("All enumeration IDs must be in lowercase".toString());
            }
        }
        EnumT[] enumtArr2 = this.values;
        HashSet hashSet = new HashSet();
        ArrayList arrayList = new ArrayList();
        for (EnumT enumt2 : enumtArr2) {
            if (hashSet.add(enumt2.getId())) {
                arrayList.add(enumt2);
            }
        }
        if (arrayList.size() == this.values.length ? true : z11) {
            this.valueType = this.type;
            return;
        }
        throw new IllegalArgumentException("Enumeration IDs must be unique".toString());
    }

    @NotNull
    public final ValueType getType() {
        return this.type;
    }

    @NotNull
    public ValueType getValueType() {
        return this.valueType;
    }

    @NotNull
    public final EnumT[] getValues() {
        return this.values;
    }

    @NotNull
    public EnumT decode(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "encoded");
        String lowerCase = str.toLowerCase(Locale.ROOT);
        Intrinsics.checkNotNullExpressionValue(lowerCase, "this as java.lang.String).toLowerCase(Locale.ROOT)");
        for (EnumT enumt : this.values) {
            if (Intrinsics.areEqual((Object) enumt.getId(), (Object) lowerCase)) {
                return enumt;
            }
        }
        throw new NoSuchElementException("Array contains no element matching the predicate.");
    }

    @NotNull
    public String encode(@NotNull EnumT enumt) {
        Intrinsics.checkNotNullParameter(enumt, "decoded");
        return enumt.getId();
    }
}
