package com.huawei.location.nlp.network.request;

import com.huawei.location.nlp.network.response.Location;
import kotlinx.serialization.json.internal.AbstractJsonLexerKt;

public class NLPLocationOnLine extends Location {
    private int source;
    private int technology;

    public int getSource() {
        return this.source;
    }

    public int getTechnology() {
        return this.technology;
    }

    public void setSource(int i11) {
        this.source = i11;
    }

    public void setTechnology(int i11) {
        this.technology = i11;
    }

    public String toString() {
        return "NLPLocationOnLine{" + super.toString() + "source=" + this.source + ", technology=" + this.technology + AbstractJsonLexerKt.END_OBJ;
    }
}
