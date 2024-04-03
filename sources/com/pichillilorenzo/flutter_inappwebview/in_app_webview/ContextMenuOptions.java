package com.pichillilorenzo.flutter_inappwebview.in_app_webview;

import com.pichillilorenzo.flutter_inappwebview.Options;
import java.util.HashMap;
import java.util.Map;

public class ContextMenuOptions implements Options<Object> {
    public static final String LOG_TAG = "ContextMenuOptions";
    public Boolean hideDefaultSystemContextMenuItems = Boolean.FALSE;

    public Map<String, Object> getRealOptions(Object obj) {
        return toMap();
    }

    public ContextMenuOptions parse(Map<String, Object> map) {
        for (Map.Entry next : map.entrySet()) {
            String str = (String) next.getKey();
            Object value = next.getValue();
            if (value != null) {
                str.hashCode();
                if (str.equals("hideDefaultSystemContextMenuItems")) {
                    this.hideDefaultSystemContextMenuItems = (Boolean) value;
                }
            }
        }
        return this;
    }

    public Map<String, Object> toMap() {
        HashMap hashMap = new HashMap();
        hashMap.put("hideDefaultSystemContextMenuItems", this.hideDefaultSystemContextMenuItems);
        return hashMap;
    }
}
