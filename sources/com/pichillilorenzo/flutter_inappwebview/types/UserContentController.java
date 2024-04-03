package com.pichillilorenzo.flutter_inappwebview.types;

import android.text.TextUtils;
import com.pichillilorenzo.flutter_inappwebview.Util;
import com.pichillilorenzo.flutter_inappwebview.plugin_scripts_js.PluginScriptsUtil;
import datamodels.TypesAliasesKt;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import org.json.JSONObject;
import org.junit.jupiter.api.IndicativeSentencesGeneration;

public class UserContentController {
    private static final String CONTENT_WORLDS_GENERATOR_JS_SOURCE = "(function() {  var contentWorldNames = [$IN_APP_WEBVIEW_CONTENT_WORLD_NAME_ARRAY];  for (var contentWorldName of contentWorldNames) {    var iframeId = 'flutter_inappwebview_' + contentWorldName;    var iframe = document.getElementById(iframeId);    if (iframe == null) {      iframe = document.createElement('iframe');      iframe.id = iframeId;      iframe.style = 'display: none; z-index: 0; position: absolute; width: 0px; height: 0px';      document.body.append(iframe);    }    var script = iframe.contentWindow.document.createElement('script');    script.innerHTML = $IN_APP_WEBVIEW_JSON_SOURCE_ENCODED;    iframe.contentWindow.document.body.append(script);  }})();";
    private static final String CONTENT_WORLD_WRAPPER_JS_SOURCE = "(function() {  var iframeId = 'flutter_inappwebview_$IN_APP_WEBVIEW_CONTENT_WORLD_NAME';  var iframe = document.getElementById(iframeId);  if (iframe == null) {    iframe = document.createElement('iframe');    iframe.id = iframeId;    iframe.style = 'display: none; z-index: 0; position: absolute; width: 0px; height: 0px';    document.body.append(iframe);  }  var script = iframe.contentWindow.document.createElement('script');  script.innerHTML = $IN_APP_WEBVIEW_JSON_SOURCE_ENCODED;  iframe.contentWindow.document.body.append(script);})();";
    private static final String DOCUMENT_READY_WRAPPER_JS_SOURCE = "if (document.readyState === 'interactive' || document.readyState === 'complete') {   $IN_APP_WEBVIEW_PLACEHOLDER_VALUE}";
    protected static final String LOG_TAG = "UserContentController";
    private static final String USER_SCRIPTS_AT_DOCUMENT_END_WRAPPER_JS_SOURCE = "if (window.flutter_inappwebview != null && (window.flutter_inappwebview._userScriptsAtDocumentEndLoaded == null || !window.flutter_inappwebview._userScriptsAtDocumentEndLoaded)) {  window.flutter_inappwebview._userScriptsAtDocumentEndLoaded = true;  $IN_APP_WEBVIEW_PLACEHOLDER_VALUE}";
    private static final String USER_SCRIPTS_AT_DOCUMENT_START_WRAPPER_JS_SOURCE = "if (window.flutter_inappwebview != null && (window.flutter_inappwebview._userScriptsAtDocumentStartLoaded == null || !window.flutter_inappwebview._userScriptsAtDocumentStartLoaded)) {  window.flutter_inappwebview._userScriptsAtDocumentStartLoaded = true;  $IN_APP_WEBVIEW_PLACEHOLDER_VALUE}";
    private final Set<ContentWorld> contentWorlds = new HashSet<ContentWorld>() {
        {
            add(ContentWorld.PAGE);
        }
    };
    private final Map<UserScriptInjectionTime, LinkedHashSet<PluginScript>> pluginScripts = new HashMap<UserScriptInjectionTime, LinkedHashSet<PluginScript>>() {
        {
            put(UserScriptInjectionTime.AT_DOCUMENT_START, new LinkedHashSet());
            put(UserScriptInjectionTime.AT_DOCUMENT_END, new LinkedHashSet());
        }
    };
    private final Map<UserScriptInjectionTime, LinkedHashSet<UserScript>> userOnlyScripts = new HashMap<UserScriptInjectionTime, LinkedHashSet<UserScript>>() {
        {
            put(UserScriptInjectionTime.AT_DOCUMENT_START, new LinkedHashSet());
            put(UserScriptInjectionTime.AT_DOCUMENT_END, new LinkedHashSet());
        }
    };

    public static String escapeCode(String str) {
        return JSONObject.quote(str);
    }

    public static String escapeContentWorldName(String str) {
        return str.replaceAll("'", "\\\\'");
    }

    public boolean addPluginScript(PluginScript pluginScript) {
        ContentWorld contentWorld = pluginScript.getContentWorld();
        if (contentWorld != null) {
            this.contentWorlds.add(contentWorld);
        }
        return this.pluginScripts.get(pluginScript.getInjectionTime()).add(pluginScript);
    }

    public void addPluginScripts(List<PluginScript> list) {
        for (PluginScript addPluginScript : list) {
            addPluginScript(addPluginScript);
        }
    }

    public boolean addUserOnlyScript(UserScript userScript) {
        ContentWorld contentWorld = userScript.getContentWorld();
        if (contentWorld != null) {
            this.contentWorlds.add(contentWorld);
        }
        return this.userOnlyScripts.get(userScript.getInjectionTime()).add(userScript);
    }

    public void addUserOnlyScripts(List<UserScript> list) {
        for (UserScript addUserOnlyScript : list) {
            addUserOnlyScript(addUserOnlyScript);
        }
    }

    public boolean containsPluginScript(PluginScript pluginScript) {
        return getPluginScriptAsList().contains(pluginScript);
    }

    public boolean containsPluginScriptByGroupName(String str) {
        Iterator<PluginScript> it = getPluginScriptAsList().iterator();
        while (it.hasNext()) {
            if (Util.objEquals(str, it.next().getGroupName())) {
                return true;
            }
        }
        return false;
    }

    public boolean containsUserOnlyScript(UserScript userScript) {
        return getUserOnlyScriptAsList().contains(userScript);
    }

    public boolean containsUserOnlyScriptByGroupName(String str) {
        Iterator<UserScript> it = getUserOnlyScriptAsList().iterator();
        while (it.hasNext()) {
            if (Util.objEquals(str, it.next().getGroupName())) {
                return true;
            }
        }
        return false;
    }

    public String generateCodeForDocumentStart() {
        UserScriptInjectionTime userScriptInjectionTime = UserScriptInjectionTime.AT_DOCUMENT_START;
        return USER_SCRIPTS_AT_DOCUMENT_START_WRAPPER_JS_SOURCE.replace(PluginScriptsUtil.VAR_PLACEHOLDER_VALUE, (("" + generatePluginScriptsCodeAt(userScriptInjectionTime)) + generateContentWorldsCreatorCode()) + generateUserOnlyScriptsCodeAt(userScriptInjectionTime));
    }

    public String generateCodeForScriptEvaluation(String str, ContentWorld contentWorld) {
        if (contentWorld == null || contentWorld.equals(ContentWorld.PAGE)) {
            return str;
        }
        StringBuilder sb2 = new StringBuilder();
        if (!this.contentWorlds.contains(contentWorld)) {
            this.contentWorlds.add(contentWorld);
            Iterator<PluginScript> it = getPluginScriptsRequiredInAllContentWorlds().iterator();
            while (it.hasNext()) {
                sb2.append(TypesAliasesKt.separator);
                sb2.append(it.next().getSource());
            }
        }
        sb2.append(str);
        return wrapSourceCodeInContentWorld(contentWorld, sb2.toString());
    }

    public String generateContentWorldsCreatorCode() {
        if (this.contentWorlds.size() == 1) {
            return "";
        }
        StringBuilder sb2 = new StringBuilder();
        Iterator<PluginScript> it = getPluginScriptsRequiredInAllContentWorlds().iterator();
        while (it.hasNext()) {
            sb2.append(it.next().getSource());
        }
        ArrayList arrayList = new ArrayList();
        for (ContentWorld next : this.contentWorlds) {
            if (!next.equals(ContentWorld.PAGE)) {
                arrayList.add("'" + escapeContentWorldName(next.getName()) + "'");
            }
        }
        return CONTENT_WORLDS_GENERATOR_JS_SOURCE.replace(PluginScriptsUtil.VAR_CONTENT_WORLD_NAME_ARRAY, TextUtils.join(IndicativeSentencesGeneration.DEFAULT_SEPARATOR, arrayList)).replace(PluginScriptsUtil.VAR_JSON_SOURCE_ENCODED, escapeCode(sb2.toString()));
    }

    public String generatePluginScriptsCodeAt(UserScriptInjectionTime userScriptInjectionTime) {
        StringBuilder sb2 = new StringBuilder();
        Iterator<PluginScript> it = getPluginScriptsAt(userScriptInjectionTime).iterator();
        while (it.hasNext()) {
            PluginScript next = it.next();
            sb2.append(wrapSourceCodeInContentWorld(next.getContentWorld(), TypesAliasesKt.separator + next.getSource()));
        }
        return sb2.toString();
    }

    public String generateUserOnlyScriptsCodeAt(UserScriptInjectionTime userScriptInjectionTime) {
        StringBuilder sb2 = new StringBuilder();
        Iterator<UserScript> it = getUserOnlyScriptsAt(userScriptInjectionTime).iterator();
        while (it.hasNext()) {
            UserScript next = it.next();
            sb2.append(wrapSourceCodeInContentWorld(next.getContentWorld(), TypesAliasesKt.separator + next.getSource()));
        }
        return sb2.toString();
    }

    public String generateWrappedCodeForDocumentEnd() {
        UserScriptInjectionTime userScriptInjectionTime = UserScriptInjectionTime.AT_DOCUMENT_END;
        return USER_SCRIPTS_AT_DOCUMENT_END_WRAPPER_JS_SOURCE.replace(PluginScriptsUtil.VAR_PLACEHOLDER_VALUE, (generateCodeForDocumentStart() + generatePluginScriptsCodeAt(userScriptInjectionTime)) + generateUserOnlyScriptsCodeAt(userScriptInjectionTime));
    }

    public String generateWrappedCodeForDocumentStart() {
        return Util.replaceAll(DOCUMENT_READY_WRAPPER_JS_SOURCE, PluginScriptsUtil.VAR_PLACEHOLDER_VALUE, generateCodeForDocumentStart());
    }

    public LinkedHashSet<ContentWorld> getContentWorlds() {
        return new LinkedHashSet<>(this.contentWorlds);
    }

    public LinkedHashSet<PluginScript> getPluginScriptAsList() {
        LinkedHashSet<PluginScript> linkedHashSet = new LinkedHashSet<>();
        for (LinkedHashSet<PluginScript> addAll : this.pluginScripts.values()) {
            linkedHashSet.addAll(addAll);
        }
        return linkedHashSet;
    }

    public LinkedHashSet<PluginScript> getPluginScriptsAt(UserScriptInjectionTime userScriptInjectionTime) {
        return new LinkedHashSet<>(this.pluginScripts.get(userScriptInjectionTime));
    }

    public LinkedHashSet<PluginScript> getPluginScriptsRequiredInAllContentWorlds() {
        LinkedHashSet<PluginScript> linkedHashSet = new LinkedHashSet<>();
        Iterator<PluginScript> it = getPluginScriptsAt(UserScriptInjectionTime.AT_DOCUMENT_START).iterator();
        while (it.hasNext()) {
            PluginScript next = it.next();
            if (next.isRequiredInAllContentWorlds()) {
                linkedHashSet.add(next);
            }
        }
        return linkedHashSet;
    }

    public LinkedHashSet<UserScript> getUserOnlyScriptAsList() {
        LinkedHashSet<UserScript> linkedHashSet = new LinkedHashSet<>();
        for (LinkedHashSet<UserScript> addAll : this.userOnlyScripts.values()) {
            linkedHashSet.addAll(addAll);
        }
        return linkedHashSet;
    }

    public LinkedHashSet<UserScript> getUserOnlyScriptsAt(UserScriptInjectionTime userScriptInjectionTime) {
        return new LinkedHashSet<>(this.userOnlyScripts.get(userScriptInjectionTime));
    }

    public void removeAllPluginScripts() {
        this.pluginScripts.get(UserScriptInjectionTime.AT_DOCUMENT_START).clear();
        this.pluginScripts.get(UserScriptInjectionTime.AT_DOCUMENT_END).clear();
    }

    public void removeAllUserOnlyScripts() {
        this.userOnlyScripts.get(UserScriptInjectionTime.AT_DOCUMENT_START).clear();
        this.userOnlyScripts.get(UserScriptInjectionTime.AT_DOCUMENT_END).clear();
    }

    public boolean removePluginScript(PluginScript pluginScript) {
        return this.pluginScripts.get(pluginScript.getInjectionTime()).remove(pluginScript);
    }

    public void removePluginScriptsByGroupName(String str) {
        Iterator<PluginScript> it = getPluginScriptAsList().iterator();
        while (it.hasNext()) {
            PluginScript next = it.next();
            if (Util.objEquals(str, next.getGroupName())) {
                removePluginScript(next);
            }
        }
    }

    public boolean removeUserOnlyScript(UserScript userScript) {
        return this.userOnlyScripts.get(userScript.getInjectionTime()).remove(userScript);
    }

    public boolean removeUserOnlyScriptAt(int i11, UserScriptInjectionTime userScriptInjectionTime) {
        return removeUserOnlyScript((UserScript) new ArrayList(this.userOnlyScripts.get(userScriptInjectionTime)).get(i11));
    }

    public void removeUserOnlyScriptsByGroupName(String str) {
        Iterator<UserScript> it = getUserOnlyScriptAsList().iterator();
        while (it.hasNext()) {
            UserScript next = it.next();
            if (Util.objEquals(str, next.getGroupName())) {
                removeUserOnlyScript(next);
            }
        }
    }

    public void resetContentWorlds() {
        this.contentWorlds.clear();
        this.contentWorlds.add(ContentWorld.PAGE);
        Iterator<PluginScript> it = getPluginScriptAsList().iterator();
        while (it.hasNext()) {
            this.contentWorlds.add(it.next().getContentWorld());
        }
        Iterator<UserScript> it2 = getUserOnlyScriptAsList().iterator();
        while (it2.hasNext()) {
            this.contentWorlds.add(it2.next().getContentWorld());
        }
    }

    public String wrapSourceCodeInContentWorld(ContentWorld contentWorld, String str) {
        return (contentWorld == null || contentWorld.equals(ContentWorld.PAGE)) ? str : CONTENT_WORLD_WRAPPER_JS_SOURCE.replace(PluginScriptsUtil.VAR_CONTENT_WORLD_NAME, escapeContentWorldName(contentWorld.getName())).replace(PluginScriptsUtil.VAR_JSON_SOURCE_ENCODED, escapeCode(str));
    }
}
