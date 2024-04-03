package com.deliveryhero.fluid.values.codecs;

import com.deliveryhero.fluid.values.ValueType;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\bv\u0018\u0000*\b\b\u0000\u0010\u0001*\u00020\u0002*\b\b\u0001\u0010\u0003*\u00020\u00022\u00020\u0002:\u0002\r\u000eJ\u0015\u0010\b\u001a\u00028\u00002\u0006\u0010\t\u001a\u00028\u0001H&¢\u0006\u0002\u0010\nJ\u0015\u0010\u000b\u001a\u00028\u00012\u0006\u0010\f\u001a\u00028\u0000H&¢\u0006\u0002\u0010\nR\u0012\u0010\u0004\u001a\u00020\u0005X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0006\u0010\u0007\u0001\u0002\u000f\u0010¨\u0006\u0011"}, d2 = {"Lcom/deliveryhero/fluid/values/codecs/ValueCodec;", "DecodedT", "", "EncodedT", "valueType", "Lcom/deliveryhero/fluid/values/ValueType;", "getValueType", "()Lcom/deliveryhero/fluid/values/ValueType;", "decode", "encoded", "(Ljava/lang/Object;)Ljava/lang/Object;", "encode", "decoded", "Composite", "Scalar", "Lcom/deliveryhero/fluid/values/codecs/ValueCodec$Scalar;", "Lcom/deliveryhero/fluid/values/codecs/ValueCodec$Composite;", "core_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
public interface ValueCodec<DecodedT, EncodedT> {

    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\bv\u0018\u0000*\b\b\u0002\u0010\u0001*\u00020\u0002*\b\b\u0003\u0010\u0003*\u00020\u00022\u000e\u0012\u0004\u0012\u0002H\u0001\u0012\u0004\u0012\u0002H\u00030\u0004\u0001\u0001\u0005¨\u0006\u0006"}, d2 = {"Lcom/deliveryhero/fluid/values/codecs/ValueCodec$Composite;", "DecodedT", "", "EncodedT", "Lcom/deliveryhero/fluid/values/codecs/ValueCodec;", "Lcom/deliveryhero/fluid/values/codecs/CellCodec;", "core_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public interface Composite<DecodedT, EncodedT> extends ValueCodec<DecodedT, EncodedT> {
    }

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\bf\u0018\u0000*\b\b\u0002\u0010\u0001*\u00020\u00022\u000e\u0012\u0004\u0012\u0002H\u0001\u0012\u0004\u0012\u00020\u00040\u0003¨\u0006\u0005"}, d2 = {"Lcom/deliveryhero/fluid/values/codecs/ValueCodec$Scalar;", "DecodedT", "", "Lcom/deliveryhero/fluid/values/codecs/ValueCodec;", "", "core_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public interface Scalar<DecodedT> extends ValueCodec<DecodedT, String> {
    }

    @NotNull
    DecodedT decode(@NotNull EncodedT encodedt) throws Exception;

    @NotNull
    EncodedT encode(@NotNull DecodedT decodedt) throws Exception;

    @NotNull
    ValueType getValueType();
}
