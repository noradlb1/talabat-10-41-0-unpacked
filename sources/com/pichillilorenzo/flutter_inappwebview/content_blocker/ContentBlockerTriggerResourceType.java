package com.pichillilorenzo.flutter_inappwebview.content_blocker;

import com.facebook.share.internal.ShareConstants;

public enum ContentBlockerTriggerResourceType {
    DOCUMENT("document"),
    IMAGE("image"),
    STYLE_SHEET("style-sheet"),
    SCRIPT("script"),
    FONT("font"),
    SVG_DOCUMENT("svg-document"),
    MEDIA(ShareConstants.WEB_DIALOG_PARAM_MEDIA),
    POPUP("popup"),
    RAW("raw");
    
    private final String value;

    private ContentBlockerTriggerResourceType(String str) {
        this.value = str;
    }

    public static ContentBlockerTriggerResourceType fromValue(String str) {
        for (ContentBlockerTriggerResourceType contentBlockerTriggerResourceType : values()) {
            if (str.equals(contentBlockerTriggerResourceType.value)) {
                return contentBlockerTriggerResourceType;
            }
        }
        throw new IllegalArgumentException("No enum constant: " + str);
    }

    public boolean equalsValue(String str) {
        return this.value.equals(str);
    }

    public String toString() {
        return this.value;
    }
}
