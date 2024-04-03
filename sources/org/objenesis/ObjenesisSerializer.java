package org.objenesis;

import org.objenesis.strategy.SerializingInstantiatorStrategy;

public class ObjenesisSerializer extends ObjenesisBase {
    public ObjenesisSerializer() {
        super(new SerializingInstantiatorStrategy());
    }

    public ObjenesisSerializer(boolean z11) {
        super(new SerializingInstantiatorStrategy(), z11);
    }
}
