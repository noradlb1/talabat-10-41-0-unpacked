package com.huawei.location.nlp.network.request;

import com.huawei.location.nlp.network.response.Location;
import kotlinx.serialization.json.internal.AbstractJsonLexerKt;

public class GPSLocationOnline extends Location {
    private int sourceType;

    public int getSourceType() {
        return this.sourceType;
    }

    public void setSourceType(int i11) {
        this.sourceType = i11;
    }

    public String toString() {
        return "GPSLocationOnline{" + super.toString() + "sourceType=" + this.sourceType + AbstractJsonLexerKt.END_OBJ;
    }
}
