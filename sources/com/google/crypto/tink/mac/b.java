package com.google.crypto.tink.mac;

import com.google.crypto.tink.Parameters;
import com.google.crypto.tink.internal.ParametersParser;
import com.google.crypto.tink.internal.ProtoParametersSerialization;
import com.google.crypto.tink.internal.Serialization;

public final /* synthetic */ class b implements ParametersParser.ParametersParsingFunction {
    public final Parameters parseParameters(Serialization serialization) {
        return AesCmacProtoSerialization.parseParameters((ProtoParametersSerialization) serialization);
    }
}
