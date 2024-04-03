package com.pichillilorenzo.flutter_inappwebview.types;

import java.util.HashMap;
import java.util.Map;
import kotlinx.serialization.json.internal.AbstractJsonLexerKt;

public class NavigationAction {
    boolean hasGesture;
    boolean isForMainFrame;
    boolean isRedirect;
    URLRequest request;

    public NavigationAction(URLRequest uRLRequest, boolean z11, boolean z12, boolean z13) {
        this.request = uRLRequest;
        this.isForMainFrame = z11;
        this.hasGesture = z12;
        this.isRedirect = z13;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        NavigationAction navigationAction = (NavigationAction) obj;
        if (this.isForMainFrame == navigationAction.isForMainFrame && this.hasGesture == navigationAction.hasGesture && this.isRedirect == navigationAction.isRedirect) {
            return this.request.equals(navigationAction.request);
        }
        return false;
    }

    public URLRequest getRequest() {
        return this.request;
    }

    public int hashCode() {
        return (((((this.request.hashCode() * 31) + (this.isForMainFrame ? 1 : 0)) * 31) + (this.hasGesture ? 1 : 0)) * 31) + (this.isRedirect ? 1 : 0);
    }

    public boolean isForMainFrame() {
        return this.isForMainFrame;
    }

    public boolean isHasGesture() {
        return this.hasGesture;
    }

    public boolean isRedirect() {
        return this.isRedirect;
    }

    public void setForMainFrame(boolean z11) {
        this.isForMainFrame = z11;
    }

    public void setHasGesture(boolean z11) {
        this.hasGesture = z11;
    }

    public void setRedirect(boolean z11) {
        this.isRedirect = z11;
    }

    public void setRequest(URLRequest uRLRequest) {
        this.request = uRLRequest;
    }

    public Map<String, Object> toMap() {
        HashMap hashMap = new HashMap();
        hashMap.put("request", this.request.toMap());
        hashMap.put("isForMainFrame", Boolean.valueOf(this.isForMainFrame));
        hashMap.put("androidHasGesture", Boolean.valueOf(this.hasGesture));
        hashMap.put("androidIsRedirect", Boolean.valueOf(this.isRedirect));
        return hashMap;
    }

    public String toString() {
        return "NavigationAction{request=" + this.request + ", isForMainFrame=" + this.isForMainFrame + ", hasGesture=" + this.hasGesture + ", isRedirect=" + this.isRedirect + AbstractJsonLexerKt.END_OBJ;
    }
}
