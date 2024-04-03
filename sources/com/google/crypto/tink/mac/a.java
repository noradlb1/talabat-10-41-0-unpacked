package com.google.crypto.tink.mac;

import com.google.crypto.tink.Parameters;
import com.google.crypto.tink.internal.ParametersSerializer;
import com.google.crypto.tink.internal.Serialization;

public final /* synthetic */ class a implements ParametersSerializer.ParametersSerializationFunction {
    public final Serialization serializeParameters(Parameters parameters) {
        return AesCmacProtoSerialization.serializeParameters((AesCmacParameters) parameters);
    }
}
