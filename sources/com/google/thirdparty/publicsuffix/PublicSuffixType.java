package com.google.thirdparty.publicsuffix;

import com.google.common.annotations.Beta;
import com.google.common.annotations.GwtCompatible;
import kotlinx.serialization.json.internal.AbstractJsonLexerKt;

@GwtCompatible
@Beta
public enum PublicSuffixType {
    PRIVATE(AbstractJsonLexerKt.COLON, AbstractJsonLexerKt.COMMA),
    REGISTRY('!', '?');
    
    private final char innerNodeCode;
    private final char leafNodeCode;

    private PublicSuffixType(char c11, char c12) {
        this.innerNodeCode = c11;
        this.leafNodeCode = c12;
    }

    public static PublicSuffixType fromCode(char c11) {
        for (PublicSuffixType publicSuffixType : values()) {
            if (publicSuffixType.getInnerNodeCode() == c11 || publicSuffixType.getLeafNodeCode() == c11) {
                return publicSuffixType;
            }
        }
        throw new IllegalArgumentException("No enum corresponding to given code: " + c11);
    }

    public char getInnerNodeCode() {
        return this.innerNodeCode;
    }

    public char getLeafNodeCode() {
        return this.leafNodeCode;
    }
}
