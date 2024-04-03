package com.uxcam.internals;

import android.webkit.WebView;
import com.braze.ui.inappmessage.utils.InAppMessageWebViewClient;
import java.lang.ref.WeakReference;

public class iq implements ip {
    public void a(String str) {
        WeakReference weakReference = fn.f13381l;
        if (weakReference != null && weakReference.get() != null) {
            int[] iArr = new int[2];
            ((WebView) fn.f13381l.get()).getLocationOnScreen(iArr);
            boolean z11 = false;
            String replace = "!function(){var e=$$webviewX,t=$$webviewY,n=$$occludeAllTextFields;var i=[];function o(n,o){var a=n.left*o*window.devicePixelRatio+window.screenX+e,c=n.top*o*window.devicePixelRatio+window.screenY+t,r=n.right*o*window.devicePixelRatio+window.screenX+e,w=n.bottom*o*window.devicePixelRatio+window.screenY+t;i.push([parseInt(a),parseInt(c),parseInt(r),parseInt(w)])}!function(){var e,t=document.getElementsByClassName(\"uxcam-occlude\");for(e=0;e<t.length;e++){var n=t[e].getBoundingClientRect(),i=t[e].style.zoom;i||(i=1),o(n,i)}}(),function(){var e,t=document.getElementsByTagName(\"input\");for(e=0;e<t.length;e++){var i=t[e].getBoundingClientRect();if(\"password\"===t[e].type.toLowerCase()||n){var a=t[e].style.zoom;a||(a=1),o(i,a)}}}();try{UXCam.occludeRectsOnNextFrame(JSON.stringify(i))}catch(e){}}();".replace("$$webviewX", String.valueOf(iArr[0])).replace("$$webviewY", String.valueOf(iArr[1]));
            if (ee.a(str) != null) {
                z11 = true;
            }
            ((WebView) fn.f13381l.get()).loadUrl(InAppMessageWebViewClient.JAVASCRIPT_PREFIX + replace.replace("$$occludeAllTextFields", String.valueOf(z11)));
        }
    }
}
