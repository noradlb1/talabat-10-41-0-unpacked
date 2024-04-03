package com.pichillilorenzo.flutter_inappwebview;

import com.pichillilorenzo.flutter_inappwebview.types.InAppWebViewInterface;
import io.flutter.plugin.common.MethodChannel;

public class InAppWebViewMethodHandler implements MethodChannel.MethodCallHandler {
    static final String LOG_TAG = "IAWMethodHandler";
    public InAppWebViewInterface webView;

    public InAppWebViewMethodHandler(InAppWebViewInterface inAppWebViewInterface) {
        this.webView = inAppWebViewInterface;
    }

    public void dispose() {
        this.webView = null;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:402:0x0834, code lost:
        if (r0.isLoading() != false) goto L_0x09cf;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:406:0x0841, code lost:
        if (r0.canGoBack() != false) goto L_0x09cf;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:426:0x08c4, code lost:
        r18.notImplemented();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:470:0x0995, code lost:
        r0 = java.lang.Boolean.valueOf(r0);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:474:0x09a4, code lost:
        if (r0.canGoForward() != false) goto L_0x09cf;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:484:0x09cd, code lost:
        if (r3.canGoBackOrForward(((java.lang.Integer) r0.argument(com.braze.ui.actions.brazeactions.steps.ContainerStep.STEPS)).intValue()) != false) goto L_0x09cf;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:485:0x09cf, code lost:
        r5 = true;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:486:0x09d1, code lost:
        r5 = r8;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:487:0x09d2, code lost:
        r0 = java.lang.Boolean.valueOf(r5);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:505:0x0a45, code lost:
        r0 = java.lang.Integer.valueOf(r0);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:506:0x0a4a, code lost:
        r2.success(r6);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:510:0x0a55, code lost:
        r0 = java.lang.Boolean.TRUE;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:514:0x0a65, code lost:
        r0 = java.lang.Boolean.FALSE;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:515:0x0a67, code lost:
        r2.success(r0);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:521:?, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:529:?, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:532:?, code lost:
        return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void onMethodCall(io.flutter.plugin.common.MethodCall r17, io.flutter.plugin.common.MethodChannel.Result r18) {
        /*
            r16 = this;
            r1 = r16
            r0 = r17
            r2 = r18
            java.lang.String r3 = r0.method
            r3.hashCode()
            int r4 = r3.hashCode()
            r7 = -1
            switch(r4) {
                case -2022488786: goto L_0x03db;
                case -1787354268: goto L_0x03d0;
                case -1773179062: goto L_0x03c5;
                case -1683397606: goto L_0x03ba;
                case -1624396757: goto L_0x03af;
                case -1331417355: goto L_0x03a4;
                case -1331417354: goto L_0x0399;
                case -1309347773: goto L_0x038e;
                case -1249348039: goto L_0x0380;
                case -1241591313: goto L_0x0372;
                case -1067273523: goto L_0x0364;
                case -995752566: goto L_0x0356;
                case -957712370: goto L_0x0348;
                case -948122918: goto L_0x0339;
                case -934641255: goto L_0x032b;
                case -934426579: goto L_0x031d;
                case -759238347: goto L_0x030f;
                case -756050293: goto L_0x0301;
                case -696286326: goto L_0x02f2;
                case -696286120: goto L_0x02e3;
                case -694273432: goto L_0x02d5;
                case -679382964: goto L_0x02c7;
                case -678975813: goto L_0x02b9;
                case -543453324: goto L_0x02ab;
                case -402165756: goto L_0x029d;
                case -402165208: goto L_0x028f;
                case -391221073: goto L_0x0281;
                case -318289731: goto L_0x0273;
                case -317054497: goto L_0x0265;
                case -243128142: goto L_0x0257;
                case -212614552: goto L_0x0249;
                case -127960866: goto L_0x023b;
                case -110027141: goto L_0x022c;
                case -53272641: goto L_0x021e;
                case -32598479: goto L_0x0210;
                case -17750794: goto L_0x0201;
                case 3202370: goto L_0x01f3;
                case 3529469: goto L_0x01e4;
                case 94756344: goto L_0x01d6;
                case 97958356: goto L_0x01c8;
                case 106440182: goto L_0x01ba;
                case 194959693: goto L_0x01ab;
                case 210916051: goto L_0x019d;
                case 336631465: goto L_0x018f;
                case 492688268: goto L_0x0181;
                case 559938080: goto L_0x0173;
                case 740366903: goto L_0x0165;
                case 817048102: goto L_0x0157;
                case 858987473: goto L_0x0149;
                case 903120263: goto L_0x013b;
                case 998674874: goto L_0x012d;
                case 1042858233: goto L_0x011f;
                case 1076821923: goto L_0x0111;
                case 1091267752: goto L_0x0103;
                case 1246613238: goto L_0x00f5;
                case 1312131169: goto L_0x00e7;
                case 1520566363: goto L_0x00d9;
                case 1587824640: goto L_0x00cb;
                case 1596466167: goto L_0x00bd;
                case 1631638145: goto L_0x00af;
                case 1724190684: goto L_0x00a1;
                case 1726230251: goto L_0x0093;
                case 1729408231: goto L_0x0085;
                case 1779894764: goto L_0x0077;
                case 1810715187: goto L_0x0069;
                case 1845118384: goto L_0x005b;
                case 1845185410: goto L_0x004d;
                case 1916929588: goto L_0x003f;
                case 1925083019: goto L_0x0031;
                case 1937913574: goto L_0x0023;
                case 1966196898: goto L_0x0015;
                default: goto L_0x0013;
            }
        L_0x0013:
            goto L_0x03e5
        L_0x0015:
            java.lang.String r4 = "getTitle"
            boolean r3 = r3.equals(r4)
            if (r3 != 0) goto L_0x001f
            goto L_0x03e5
        L_0x001f:
            r7 = 70
            goto L_0x03e5
        L_0x0023:
            java.lang.String r4 = "evaluateJavascript"
            boolean r3 = r3.equals(r4)
            if (r3 != 0) goto L_0x002d
            goto L_0x03e5
        L_0x002d:
            r7 = 69
            goto L_0x03e5
        L_0x0031:
            java.lang.String r4 = "injectJavascriptFileFromUrl"
            boolean r3 = r3.equals(r4)
            if (r3 != 0) goto L_0x003b
            goto L_0x03e5
        L_0x003b:
            r7 = 68
            goto L_0x03e5
        L_0x003f:
            java.lang.String r4 = "findAllAsync"
            boolean r3 = r3.equals(r4)
            if (r3 != 0) goto L_0x0049
            goto L_0x03e5
        L_0x0049:
            r7 = 67
            goto L_0x03e5
        L_0x004d:
            java.lang.String r4 = "loadFile"
            boolean r3 = r3.equals(r4)
            if (r3 != 0) goto L_0x0057
            goto L_0x03e5
        L_0x0057:
            r7 = 66
            goto L_0x03e5
        L_0x005b:
            java.lang.String r4 = "loadData"
            boolean r3 = r3.equals(r4)
            if (r3 != 0) goto L_0x0065
            goto L_0x03e5
        L_0x0065:
            r7 = 65
            goto L_0x03e5
        L_0x0069:
            java.lang.String r4 = "goBackOrForward"
            boolean r3 = r3.equals(r4)
            if (r3 != 0) goto L_0x0073
            goto L_0x03e5
        L_0x0073:
            r7 = 64
            goto L_0x03e5
        L_0x0077:
            java.lang.String r4 = "setContextMenu"
            boolean r3 = r3.equals(r4)
            if (r3 != 0) goto L_0x0081
            goto L_0x03e5
        L_0x0081:
            r7 = 63
            goto L_0x03e5
        L_0x0085:
            java.lang.String r4 = "requestImageRef"
            boolean r3 = r3.equals(r4)
            if (r3 != 0) goto L_0x008f
            goto L_0x03e5
        L_0x008f:
            r7 = 62
            goto L_0x03e5
        L_0x0093:
            java.lang.String r4 = "callAsyncJavaScript"
            boolean r3 = r3.equals(r4)
            if (r3 != 0) goto L_0x009d
            goto L_0x03e5
        L_0x009d:
            r7 = 61
            goto L_0x03e5
        L_0x00a1:
            java.lang.String r4 = "setOptions"
            boolean r3 = r3.equals(r4)
            if (r3 != 0) goto L_0x00ab
            goto L_0x03e5
        L_0x00ab:
            r7 = 60
            goto L_0x03e5
        L_0x00af:
            java.lang.String r4 = "getZoomScale"
            boolean r3 = r3.equals(r4)
            if (r3 != 0) goto L_0x00b9
            goto L_0x03e5
        L_0x00b9:
            r7 = 59
            goto L_0x03e5
        L_0x00bd:
            java.lang.String r4 = "addUserScript"
            boolean r3 = r3.equals(r4)
            if (r3 != 0) goto L_0x00c7
            goto L_0x03e5
        L_0x00c7:
            r7 = 58
            goto L_0x03e5
        L_0x00cb:
            java.lang.String r4 = "removeAllUserScripts"
            boolean r3 = r3.equals(r4)
            if (r3 != 0) goto L_0x00d5
            goto L_0x03e5
        L_0x00d5:
            r7 = 57
            goto L_0x03e5
        L_0x00d9:
            java.lang.String r4 = "resumeTimers"
            boolean r3 = r3.equals(r4)
            if (r3 != 0) goto L_0x00e3
            goto L_0x03e5
        L_0x00e3:
            r7 = 56
            goto L_0x03e5
        L_0x00e7:
            java.lang.String r4 = "getCertificate"
            boolean r3 = r3.equals(r4)
            if (r3 != 0) goto L_0x00f1
            goto L_0x03e5
        L_0x00f1:
            r7 = 55
            goto L_0x03e5
        L_0x00f5:
            java.lang.String r4 = "requestFocusNodeHref"
            boolean r3 = r3.equals(r4)
            if (r3 != 0) goto L_0x00ff
            goto L_0x03e5
        L_0x00ff:
            r7 = 54
            goto L_0x03e5
        L_0x0103:
            java.lang.String r4 = "getOriginalUrl"
            boolean r3 = r3.equals(r4)
            if (r3 != 0) goto L_0x010d
            goto L_0x03e5
        L_0x010d:
            r7 = 53
            goto L_0x03e5
        L_0x0111:
            java.lang.String r4 = "getProgress"
            boolean r3 = r3.equals(r4)
            if (r3 != 0) goto L_0x011b
            goto L_0x03e5
        L_0x011b:
            r7 = 52
            goto L_0x03e5
        L_0x011f:
            java.lang.String r4 = "clearSslPreferences"
            boolean r3 = r3.equals(r4)
            if (r3 != 0) goto L_0x0129
            goto L_0x03e5
        L_0x0129:
            r7 = 51
            goto L_0x03e5
        L_0x012d:
            java.lang.String r4 = "removeUserScriptsByGroupName"
            boolean r3 = r3.equals(r4)
            if (r3 != 0) goto L_0x0137
            goto L_0x03e5
        L_0x0137:
            r7 = 50
            goto L_0x03e5
        L_0x013b:
            java.lang.String r4 = "clearHistory"
            boolean r3 = r3.equals(r4)
            if (r3 != 0) goto L_0x0145
            goto L_0x03e5
        L_0x0145:
            r7 = 49
            goto L_0x03e5
        L_0x0149:
            java.lang.String r4 = "pageDown"
            boolean r3 = r3.equals(r4)
            if (r3 != 0) goto L_0x0153
            goto L_0x03e5
        L_0x0153:
            r7 = 48
            goto L_0x03e5
        L_0x0157:
            java.lang.String r4 = "clearMatches"
            boolean r3 = r3.equals(r4)
            if (r3 != 0) goto L_0x0161
            goto L_0x03e5
        L_0x0161:
            r7 = 47
            goto L_0x03e5
        L_0x0165:
            java.lang.String r4 = "injectCSSFileFromUrl"
            boolean r3 = r3.equals(r4)
            if (r3 != 0) goto L_0x016f
            goto L_0x03e5
        L_0x016f:
            r7 = 46
            goto L_0x03e5
        L_0x0173:
            java.lang.String r4 = "canScrollVertically"
            boolean r3 = r3.equals(r4)
            if (r3 != 0) goto L_0x017d
            goto L_0x03e5
        L_0x017d:
            r7 = 45
            goto L_0x03e5
        L_0x0181:
            java.lang.String r4 = "getHitTestResult"
            boolean r3 = r3.equals(r4)
            if (r3 != 0) goto L_0x018b
            goto L_0x03e5
        L_0x018b:
            r7 = 44
            goto L_0x03e5
        L_0x018f:
            java.lang.String r4 = "loadUrl"
            boolean r3 = r3.equals(r4)
            if (r3 != 0) goto L_0x0199
            goto L_0x03e5
        L_0x0199:
            r7 = 43
            goto L_0x03e5
        L_0x019d:
            java.lang.String r4 = "postWebMessage"
            boolean r3 = r3.equals(r4)
            if (r3 != 0) goto L_0x01a7
            goto L_0x03e5
        L_0x01a7:
            r7 = 42
            goto L_0x03e5
        L_0x01ab:
            java.lang.String r4 = "takeScreenshot"
            boolean r3 = r3.equals(r4)
            if (r3 != 0) goto L_0x01b6
            goto L_0x03e5
        L_0x01b6:
            r7 = 41
            goto L_0x03e5
        L_0x01ba:
            java.lang.String r4 = "pause"
            boolean r3 = r3.equals(r4)
            if (r3 != 0) goto L_0x01c4
            goto L_0x03e5
        L_0x01c4:
            r7 = 40
            goto L_0x03e5
        L_0x01c8:
            java.lang.String r4 = "createWebMessageChannel"
            boolean r3 = r3.equals(r4)
            if (r3 != 0) goto L_0x01d2
            goto L_0x03e5
        L_0x01d2:
            r7 = 39
            goto L_0x03e5
        L_0x01d6:
            java.lang.String r4 = "close"
            boolean r3 = r3.equals(r4)
            if (r3 != 0) goto L_0x01e0
            goto L_0x03e5
        L_0x01e0:
            r7 = 38
            goto L_0x03e5
        L_0x01e4:
            java.lang.String r4 = "show"
            boolean r3 = r3.equals(r4)
            if (r3 != 0) goto L_0x01ef
            goto L_0x03e5
        L_0x01ef:
            r7 = 37
            goto L_0x03e5
        L_0x01f3:
            java.lang.String r4 = "hide"
            boolean r3 = r3.equals(r4)
            if (r3 != 0) goto L_0x01fd
            goto L_0x03e5
        L_0x01fd:
            r7 = 36
            goto L_0x03e5
        L_0x0201:
            java.lang.String r4 = "startSafeBrowsing"
            boolean r3 = r3.equals(r4)
            if (r3 != 0) goto L_0x020c
            goto L_0x03e5
        L_0x020c:
            r7 = 35
            goto L_0x03e5
        L_0x0210:
            java.lang.String r4 = "getCopyBackForwardList"
            boolean r3 = r3.equals(r4)
            if (r3 != 0) goto L_0x021a
            goto L_0x03e5
        L_0x021a:
            r7 = 34
            goto L_0x03e5
        L_0x021e:
            java.lang.String r4 = "injectCSSCode"
            boolean r3 = r3.equals(r4)
            if (r3 != 0) goto L_0x0228
            goto L_0x03e5
        L_0x0228:
            r7 = 33
            goto L_0x03e5
        L_0x022c:
            java.lang.String r4 = "zoomOut"
            boolean r3 = r3.equals(r4)
            if (r3 != 0) goto L_0x0237
            goto L_0x03e5
        L_0x0237:
            r7 = 32
            goto L_0x03e5
        L_0x023b:
            java.lang.String r4 = "getSelectedText"
            boolean r3 = r3.equals(r4)
            if (r3 != 0) goto L_0x0245
            goto L_0x03e5
        L_0x0245:
            r7 = 31
            goto L_0x03e5
        L_0x0249:
            java.lang.String r4 = "getOptions"
            boolean r3 = r3.equals(r4)
            if (r3 != 0) goto L_0x0253
            goto L_0x03e5
        L_0x0253:
            r7 = 30
            goto L_0x03e5
        L_0x0257:
            java.lang.String r4 = "isLoading"
            boolean r3 = r3.equals(r4)
            if (r3 != 0) goto L_0x0261
            goto L_0x03e5
        L_0x0261:
            r7 = 29
            goto L_0x03e5
        L_0x0265:
            java.lang.String r4 = "canGoBack"
            boolean r3 = r3.equals(r4)
            if (r3 != 0) goto L_0x026f
            goto L_0x03e5
        L_0x026f:
            r7 = 28
            goto L_0x03e5
        L_0x0273:
            java.lang.String r4 = "goForward"
            boolean r3 = r3.equals(r4)
            if (r3 != 0) goto L_0x027d
            goto L_0x03e5
        L_0x027d:
            r7 = 27
            goto L_0x03e5
        L_0x0281:
            java.lang.String r4 = "postUrl"
            boolean r3 = r3.equals(r4)
            if (r3 != 0) goto L_0x028b
            goto L_0x03e5
        L_0x028b:
            r7 = 26
            goto L_0x03e5
        L_0x028f:
            java.lang.String r4 = "scrollTo"
            boolean r3 = r3.equals(r4)
            if (r3 != 0) goto L_0x0299
            goto L_0x03e5
        L_0x0299:
            r7 = 25
            goto L_0x03e5
        L_0x029d:
            java.lang.String r4 = "scrollBy"
            boolean r3 = r3.equals(r4)
            if (r3 != 0) goto L_0x02a7
            goto L_0x03e5
        L_0x02a7:
            r7 = 24
            goto L_0x03e5
        L_0x02ab:
            java.lang.String r4 = "isHidden"
            boolean r3 = r3.equals(r4)
            if (r3 != 0) goto L_0x02b5
            goto L_0x03e5
        L_0x02b5:
            r7 = 23
            goto L_0x03e5
        L_0x02b9:
            java.lang.String r4 = "printCurrentPage"
            boolean r3 = r3.equals(r4)
            if (r3 != 0) goto L_0x02c3
            goto L_0x03e5
        L_0x02c3:
            r7 = 22
            goto L_0x03e5
        L_0x02c7:
            java.lang.String r4 = "findNext"
            boolean r3 = r3.equals(r4)
            if (r3 != 0) goto L_0x02d1
            goto L_0x03e5
        L_0x02d1:
            r7 = 21
            goto L_0x03e5
        L_0x02d5:
            java.lang.String r4 = "addWebMessageListener"
            boolean r3 = r3.equals(r4)
            if (r3 != 0) goto L_0x02df
            goto L_0x03e5
        L_0x02df:
            r7 = 20
            goto L_0x03e5
        L_0x02e3:
            java.lang.String r4 = "zoomIn"
            boolean r3 = r3.equals(r4)
            if (r3 != 0) goto L_0x02ee
            goto L_0x03e5
        L_0x02ee:
            r7 = 19
            goto L_0x03e5
        L_0x02f2:
            java.lang.String r4 = "zoomBy"
            boolean r3 = r3.equals(r4)
            if (r3 != 0) goto L_0x02fd
            goto L_0x03e5
        L_0x02fd:
            r7 = 18
            goto L_0x03e5
        L_0x0301:
            java.lang.String r4 = "clearFocus"
            boolean r3 = r3.equals(r4)
            if (r3 != 0) goto L_0x030b
            goto L_0x03e5
        L_0x030b:
            r7 = 17
            goto L_0x03e5
        L_0x030f:
            java.lang.String r4 = "clearCache"
            boolean r3 = r3.equals(r4)
            if (r3 != 0) goto L_0x0319
            goto L_0x03e5
        L_0x0319:
            r7 = 16
            goto L_0x03e5
        L_0x031d:
            java.lang.String r4 = "resume"
            boolean r3 = r3.equals(r4)
            if (r3 != 0) goto L_0x0327
            goto L_0x03e5
        L_0x0327:
            r7 = 15
            goto L_0x03e5
        L_0x032b:
            java.lang.String r4 = "reload"
            boolean r3 = r3.equals(r4)
            if (r3 != 0) goto L_0x0335
            goto L_0x03e5
        L_0x0335:
            r7 = 14
            goto L_0x03e5
        L_0x0339:
            java.lang.String r4 = "stopLoading"
            boolean r3 = r3.equals(r4)
            if (r3 != 0) goto L_0x0344
            goto L_0x03e5
        L_0x0344:
            r7 = 13
            goto L_0x03e5
        L_0x0348:
            java.lang.String r4 = "canScrollHorizontally"
            boolean r3 = r3.equals(r4)
            if (r3 != 0) goto L_0x0352
            goto L_0x03e5
        L_0x0352:
            r7 = 12
            goto L_0x03e5
        L_0x0356:
            java.lang.String r4 = "pageUp"
            boolean r3 = r3.equals(r4)
            if (r3 != 0) goto L_0x0360
            goto L_0x03e5
        L_0x0360:
            r7 = 11
            goto L_0x03e5
        L_0x0364:
            java.lang.String r4 = "canGoForward"
            boolean r3 = r3.equals(r4)
            if (r3 != 0) goto L_0x036e
            goto L_0x03e5
        L_0x036e:
            r7 = 10
            goto L_0x03e5
        L_0x0372:
            java.lang.String r4 = "goBack"
            boolean r3 = r3.equals(r4)
            if (r3 != 0) goto L_0x037c
            goto L_0x03e5
        L_0x037c:
            r7 = 9
            goto L_0x03e5
        L_0x0380:
            java.lang.String r4 = "getUrl"
            boolean r3 = r3.equals(r4)
            if (r3 != 0) goto L_0x038a
            goto L_0x03e5
        L_0x038a:
            r7 = 8
            goto L_0x03e5
        L_0x038e:
            java.lang.String r4 = "canGoBackOrForward"
            boolean r3 = r3.equals(r4)
            if (r3 != 0) goto L_0x0397
            goto L_0x03e5
        L_0x0397:
            r7 = 7
            goto L_0x03e5
        L_0x0399:
            java.lang.String r4 = "getScrollY"
            boolean r3 = r3.equals(r4)
            if (r3 != 0) goto L_0x03a2
            goto L_0x03e5
        L_0x03a2:
            r7 = 6
            goto L_0x03e5
        L_0x03a4:
            java.lang.String r4 = "getScrollX"
            boolean r3 = r3.equals(r4)
            if (r3 != 0) goto L_0x03ad
            goto L_0x03e5
        L_0x03ad:
            r7 = 5
            goto L_0x03e5
        L_0x03af:
            java.lang.String r4 = "saveWebArchive"
            boolean r3 = r3.equals(r4)
            if (r3 != 0) goto L_0x03b8
            goto L_0x03e5
        L_0x03b8:
            r7 = 4
            goto L_0x03e5
        L_0x03ba:
            java.lang.String r4 = "removeUserScript"
            boolean r3 = r3.equals(r4)
            if (r3 != 0) goto L_0x03c3
            goto L_0x03e5
        L_0x03c3:
            r7 = 3
            goto L_0x03e5
        L_0x03c5:
            java.lang.String r4 = "getContentHeight"
            boolean r3 = r3.equals(r4)
            if (r3 != 0) goto L_0x03ce
            goto L_0x03e5
        L_0x03ce:
            r7 = 2
            goto L_0x03e5
        L_0x03d0:
            java.lang.String r4 = "pauseTimers"
            boolean r3 = r3.equals(r4)
            if (r3 != 0) goto L_0x03d9
            goto L_0x03e5
        L_0x03d9:
            r7 = 1
            goto L_0x03e5
        L_0x03db:
            java.lang.String r4 = "isSecureContext"
            boolean r3 = r3.equals(r4)
            if (r3 != 0) goto L_0x03e4
            goto L_0x03e5
        L_0x03e4:
            r7 = 0
        L_0x03e5:
            java.lang.String r3 = "userScript"
            java.lang.String r4 = "index"
            java.lang.String r8 = "contentWorld"
            java.lang.String r9 = "data"
            java.lang.String r10 = "urlFile"
            java.lang.String r11 = "source"
            java.lang.String r12 = "animated"
            java.lang.String r13 = "y"
            java.lang.String r14 = "x"
            java.lang.String r15 = "steps"
            java.lang.String r5 = "IAWMethodHandler"
            r6 = 0
            switch(r7) {
                case 0: goto L_0x0a58;
                case 1: goto L_0x0a4e;
                case 2: goto L_0x0a3b;
                case 3: goto L_0x0a0d;
                case 4: goto L_0x09ea;
                case 5: goto L_0x09e1;
                case 6: goto L_0x09d8;
                case 7: goto L_0x09ba;
                case 8: goto L_0x09b0;
                case 9: goto L_0x09a7;
                case 10: goto L_0x099b;
                case 11: goto L_0x097e;
                case 12: goto L_0x0975;
                case 13: goto L_0x096c;
                case 14: goto L_0x0963;
                case 15: goto L_0x095a;
                case 16: goto L_0x0951;
                case 17: goto L_0x0948;
                case 18: goto L_0x092f;
                case 19: goto L_0x0926;
                case 20: goto L_0x08e9;
                case 21: goto L_0x08d2;
                case 22: goto L_0x08c9;
                case 23: goto L_0x08a4;
                case 24: goto L_0x0887;
                case 25: goto L_0x086a;
                case 26: goto L_0x084e;
                case 27: goto L_0x0845;
                case 28: goto L_0x0838;
                case 29: goto L_0x082b;
                case 30: goto L_0x07ff;
                case 31: goto L_0x07ef;
                case 32: goto L_0x07e5;
                case 33: goto L_0x07d4;
                case 34: goto L_0x07ca;
                case 35: goto L_0x07ae;
                case 36: goto L_0x078d;
                case 37: goto L_0x076c;
                case 38: goto L_0x074b;
                case 39: goto L_0x072f;
                case 40: goto L_0x0726;
                case 41: goto L_0x0713;
                case 42: goto L_0x0673;
                case 43: goto L_0x065b;
                case 44: goto L_0x0647;
                case 45: goto L_0x063d;
                case 46: goto L_0x0624;
                case 47: goto L_0x061b;
                case 48: goto L_0x0603;
                case 49: goto L_0x05fa;
                case 50: goto L_0x05dd;
                case 51: goto L_0x05d4;
                case 52: goto L_0x05c6;
                case 53: goto L_0x05bc;
                case 54: goto L_0x05b2;
                case 55: goto L_0x05a4;
                case 56: goto L_0x059b;
                case 57: goto L_0x0586;
                case 58: goto L_0x0566;
                case 59: goto L_0x0556;
                case 60: goto L_0x050c;
                case 61: goto L_0x04e2;
                case 62: goto L_0x04d8;
                case 63: goto L_0x04c5;
                case 64: goto L_0x04b2;
                case 65: goto L_0x047c;
                case 66: goto L_0x045d;
                case 67: goto L_0x044a;
                case 68: goto L_0x0431;
                case 69: goto L_0x0411;
                case 70: goto L_0x0407;
                default: goto L_0x0405;
            }
        L_0x0405:
            goto L_0x08c4
        L_0x0407:
            com.pichillilorenzo.flutter_inappwebview.types.InAppWebViewInterface r0 = r1.webView
            if (r0 == 0) goto L_0x0a4a
            java.lang.String r6 = r0.getTitle()
            goto L_0x0a4a
        L_0x0411:
            com.pichillilorenzo.flutter_inappwebview.types.InAppWebViewInterface r3 = r1.webView
            if (r3 == 0) goto L_0x0a4a
            java.lang.Object r3 = r0.argument(r11)
            java.lang.String r3 = (java.lang.String) r3
            java.lang.Object r0 = r0.argument(r8)
            java.util.Map r0 = (java.util.Map) r0
            com.pichillilorenzo.flutter_inappwebview.types.ContentWorld r0 = com.pichillilorenzo.flutter_inappwebview.types.ContentWorld.fromMap(r0)
            com.pichillilorenzo.flutter_inappwebview.types.InAppWebViewInterface r4 = r1.webView
            com.pichillilorenzo.flutter_inappwebview.InAppWebViewMethodHandler$1 r5 = new com.pichillilorenzo.flutter_inappwebview.InAppWebViewMethodHandler$1
            r5.<init>(r2)
            r4.evaluateJavascript(r3, r0, r5)
            goto L_0x0a6a
        L_0x0431:
            com.pichillilorenzo.flutter_inappwebview.types.InAppWebViewInterface r3 = r1.webView
            if (r3 == 0) goto L_0x0a55
            java.lang.Object r3 = r0.argument(r10)
            java.lang.String r3 = (java.lang.String) r3
            java.lang.String r4 = "scriptHtmlTagAttributes"
            java.lang.Object r0 = r0.argument(r4)
            java.util.Map r0 = (java.util.Map) r0
            com.pichillilorenzo.flutter_inappwebview.types.InAppWebViewInterface r4 = r1.webView
            r4.injectJavascriptFileFromUrl(r3, r0)
            goto L_0x0a55
        L_0x044a:
            com.pichillilorenzo.flutter_inappwebview.types.InAppWebViewInterface r3 = r1.webView
            if (r3 == 0) goto L_0x0a55
            java.lang.String r3 = "find"
            java.lang.Object r0 = r0.argument(r3)
            java.lang.String r0 = (java.lang.String) r0
            com.pichillilorenzo.flutter_inappwebview.types.InAppWebViewInterface r3 = r1.webView
            r3.findAllAsync(r0)
            goto L_0x0a55
        L_0x045d:
            com.pichillilorenzo.flutter_inappwebview.types.InAppWebViewInterface r3 = r1.webView
            if (r3 == 0) goto L_0x0a55
            java.lang.String r3 = "assetFilePath"
            java.lang.Object r0 = r0.argument(r3)
            java.lang.String r0 = (java.lang.String) r0
            com.pichillilorenzo.flutter_inappwebview.types.InAppWebViewInterface r3 = r1.webView     // Catch:{ IOException -> 0x0470 }
            r3.loadFile(r0)     // Catch:{ IOException -> 0x0470 }
            goto L_0x0a55
        L_0x0470:
            r0 = move-exception
            r0.printStackTrace()
            java.lang.String r0 = r0.getMessage()
            r2.error(r5, r0, r6)
            return
        L_0x047c:
            com.pichillilorenzo.flutter_inappwebview.types.InAppWebViewInterface r3 = r1.webView
            if (r3 == 0) goto L_0x0a55
            java.lang.Object r3 = r0.argument(r9)
            r6 = r3
            java.lang.String r6 = (java.lang.String) r6
            java.lang.String r3 = "mimeType"
            java.lang.Object r3 = r0.argument(r3)
            r7 = r3
            java.lang.String r7 = (java.lang.String) r7
            java.lang.String r3 = "encoding"
            java.lang.Object r3 = r0.argument(r3)
            r8 = r3
            java.lang.String r8 = (java.lang.String) r8
            java.lang.String r3 = "baseUrl"
            java.lang.Object r3 = r0.argument(r3)
            r5 = r3
            java.lang.String r5 = (java.lang.String) r5
            java.lang.String r3 = "historyUrl"
            java.lang.Object r0 = r0.argument(r3)
            r9 = r0
            java.lang.String r9 = (java.lang.String) r9
            com.pichillilorenzo.flutter_inappwebview.types.InAppWebViewInterface r4 = r1.webView
            r4.loadDataWithBaseURL(r5, r6, r7, r8, r9)
            goto L_0x0a55
        L_0x04b2:
            com.pichillilorenzo.flutter_inappwebview.types.InAppWebViewInterface r3 = r1.webView
            if (r3 == 0) goto L_0x0a55
            java.lang.Object r0 = r0.argument(r15)
            java.lang.Integer r0 = (java.lang.Integer) r0
            int r0 = r0.intValue()
            r3.goBackOrForward(r0)
            goto L_0x0a55
        L_0x04c5:
            com.pichillilorenzo.flutter_inappwebview.types.InAppWebViewInterface r3 = r1.webView
            if (r3 == 0) goto L_0x0a55
            java.lang.String r3 = "contextMenu"
            java.lang.Object r0 = r0.argument(r3)
            java.util.Map r0 = (java.util.Map) r0
            com.pichillilorenzo.flutter_inappwebview.types.InAppWebViewInterface r3 = r1.webView
            r3.setContextMenu(r0)
            goto L_0x0a55
        L_0x04d8:
            com.pichillilorenzo.flutter_inappwebview.types.InAppWebViewInterface r0 = r1.webView
            if (r0 == 0) goto L_0x0a4a
            java.util.Map r0 = r0.requestImageRef()
            goto L_0x0a67
        L_0x04e2:
            com.pichillilorenzo.flutter_inappwebview.types.InAppWebViewInterface r3 = r1.webView
            if (r3 == 0) goto L_0x0a4a
            java.lang.String r3 = "functionBody"
            java.lang.Object r3 = r0.argument(r3)
            java.lang.String r3 = (java.lang.String) r3
            java.lang.String r4 = "arguments"
            java.lang.Object r4 = r0.argument(r4)
            java.util.Map r4 = (java.util.Map) r4
            java.lang.Object r0 = r0.argument(r8)
            java.util.Map r0 = (java.util.Map) r0
            com.pichillilorenzo.flutter_inappwebview.types.ContentWorld r0 = com.pichillilorenzo.flutter_inappwebview.types.ContentWorld.fromMap(r0)
            com.pichillilorenzo.flutter_inappwebview.types.InAppWebViewInterface r5 = r1.webView
            com.pichillilorenzo.flutter_inappwebview.InAppWebViewMethodHandler$5 r6 = new com.pichillilorenzo.flutter_inappwebview.InAppWebViewMethodHandler$5
            r6.<init>(r2)
            r5.callAsyncJavaScript(r3, r4, r0, r6)
            goto L_0x0a6a
        L_0x050c:
            com.pichillilorenzo.flutter_inappwebview.types.InAppWebViewInterface r3 = r1.webView
            java.lang.String r4 = "options"
            if (r3 == 0) goto L_0x053d
            com.pichillilorenzo.flutter_inappwebview.in_app_browser.InAppBrowserDelegate r3 = r3.getInAppBrowserDelegate()
            if (r3 == 0) goto L_0x053d
            com.pichillilorenzo.flutter_inappwebview.types.InAppWebViewInterface r3 = r1.webView
            com.pichillilorenzo.flutter_inappwebview.in_app_browser.InAppBrowserDelegate r3 = r3.getInAppBrowserDelegate()
            boolean r3 = r3 instanceof com.pichillilorenzo.flutter_inappwebview.in_app_browser.InAppBrowserActivity
            if (r3 == 0) goto L_0x053d
            com.pichillilorenzo.flutter_inappwebview.types.InAppWebViewInterface r3 = r1.webView
            com.pichillilorenzo.flutter_inappwebview.in_app_browser.InAppBrowserDelegate r3 = r3.getInAppBrowserDelegate()
            com.pichillilorenzo.flutter_inappwebview.in_app_browser.InAppBrowserActivity r3 = (com.pichillilorenzo.flutter_inappwebview.in_app_browser.InAppBrowserActivity) r3
            com.pichillilorenzo.flutter_inappwebview.in_app_browser.InAppBrowserOptions r5 = new com.pichillilorenzo.flutter_inappwebview.in_app_browser.InAppBrowserOptions
            r5.<init>()
            java.lang.Object r0 = r0.argument(r4)
            java.util.HashMap r0 = (java.util.HashMap) r0
            r5.parse((java.util.Map) r0)
            r3.setOptions(r5, r0)
            goto L_0x0a55
        L_0x053d:
            com.pichillilorenzo.flutter_inappwebview.types.InAppWebViewInterface r3 = r1.webView
            if (r3 == 0) goto L_0x0a55
            com.pichillilorenzo.flutter_inappwebview.in_app_webview.InAppWebViewOptions r3 = new com.pichillilorenzo.flutter_inappwebview.in_app_webview.InAppWebViewOptions
            r3.<init>()
            java.lang.Object r0 = r0.argument(r4)
            java.util.HashMap r0 = (java.util.HashMap) r0
            r3.parse((java.util.Map) r0)
            com.pichillilorenzo.flutter_inappwebview.types.InAppWebViewInterface r4 = r1.webView
            r4.setOptions(r3, r0)
            goto L_0x0a55
        L_0x0556:
            com.pichillilorenzo.flutter_inappwebview.types.InAppWebViewInterface r0 = r1.webView
            boolean r3 = r0 instanceof com.pichillilorenzo.flutter_inappwebview.in_app_webview.InAppWebView
            if (r3 == 0) goto L_0x0a4a
            float r0 = r0.getZoomScale()
            java.lang.Float r0 = java.lang.Float.valueOf(r0)
            goto L_0x0a67
        L_0x0566:
            com.pichillilorenzo.flutter_inappwebview.types.InAppWebViewInterface r4 = r1.webView
            if (r4 == 0) goto L_0x0a65
            com.pichillilorenzo.flutter_inappwebview.types.UserContentController r4 = r4.getUserContentController()
            if (r4 == 0) goto L_0x0a65
            java.lang.Object r0 = r0.argument(r3)
            java.util.Map r0 = (java.util.Map) r0
            com.pichillilorenzo.flutter_inappwebview.types.UserScript r0 = com.pichillilorenzo.flutter_inappwebview.types.UserScript.fromMap(r0)
            com.pichillilorenzo.flutter_inappwebview.types.InAppWebViewInterface r3 = r1.webView
            com.pichillilorenzo.flutter_inappwebview.types.UserContentController r3 = r3.getUserContentController()
            boolean r0 = r3.addUserOnlyScript(r0)
            goto L_0x0995
        L_0x0586:
            com.pichillilorenzo.flutter_inappwebview.types.InAppWebViewInterface r0 = r1.webView
            if (r0 == 0) goto L_0x0a55
            com.pichillilorenzo.flutter_inappwebview.types.UserContentController r0 = r0.getUserContentController()
            if (r0 == 0) goto L_0x0a55
            com.pichillilorenzo.flutter_inappwebview.types.InAppWebViewInterface r0 = r1.webView
            com.pichillilorenzo.flutter_inappwebview.types.UserContentController r0 = r0.getUserContentController()
            r0.removeAllUserOnlyScripts()
            goto L_0x0a55
        L_0x059b:
            com.pichillilorenzo.flutter_inappwebview.types.InAppWebViewInterface r0 = r1.webView
            if (r0 == 0) goto L_0x0a55
            r0.resumeTimers()
            goto L_0x0a55
        L_0x05a4:
            com.pichillilorenzo.flutter_inappwebview.types.InAppWebViewInterface r0 = r1.webView
            if (r0 == 0) goto L_0x0a4a
            android.net.http.SslCertificate r0 = r0.getCertificate()
            java.util.Map r0 = com.pichillilorenzo.flutter_inappwebview.types.SslCertificateExt.toMap(r0)
            goto L_0x0a67
        L_0x05b2:
            com.pichillilorenzo.flutter_inappwebview.types.InAppWebViewInterface r0 = r1.webView
            if (r0 == 0) goto L_0x0a4a
            java.util.Map r0 = r0.requestFocusNodeHref()
            goto L_0x0a67
        L_0x05bc:
            com.pichillilorenzo.flutter_inappwebview.types.InAppWebViewInterface r0 = r1.webView
            if (r0 == 0) goto L_0x0a4a
            java.lang.String r6 = r0.getOriginalUrl()
            goto L_0x0a4a
        L_0x05c6:
            com.pichillilorenzo.flutter_inappwebview.types.InAppWebViewInterface r0 = r1.webView
            if (r0 == 0) goto L_0x0a4a
            int r0 = r0.getProgress()
            java.lang.Integer r6 = java.lang.Integer.valueOf(r0)
            goto L_0x0a4a
        L_0x05d4:
            com.pichillilorenzo.flutter_inappwebview.types.InAppWebViewInterface r0 = r1.webView
            if (r0 == 0) goto L_0x0a55
            r0.clearSslPreferences()
            goto L_0x0a55
        L_0x05dd:
            com.pichillilorenzo.flutter_inappwebview.types.InAppWebViewInterface r3 = r1.webView
            if (r3 == 0) goto L_0x0a55
            com.pichillilorenzo.flutter_inappwebview.types.UserContentController r3 = r3.getUserContentController()
            if (r3 == 0) goto L_0x0a55
            java.lang.String r3 = "groupName"
            java.lang.Object r0 = r0.argument(r3)
            java.lang.String r0 = (java.lang.String) r0
            com.pichillilorenzo.flutter_inappwebview.types.InAppWebViewInterface r3 = r1.webView
            com.pichillilorenzo.flutter_inappwebview.types.UserContentController r3 = r3.getUserContentController()
            r3.removeUserOnlyScriptsByGroupName(r0)
            goto L_0x0a55
        L_0x05fa:
            com.pichillilorenzo.flutter_inappwebview.types.InAppWebViewInterface r0 = r1.webView
            if (r0 == 0) goto L_0x0a55
            r0.clearHistory()
            goto L_0x0a55
        L_0x0603:
            com.pichillilorenzo.flutter_inappwebview.types.InAppWebViewInterface r3 = r1.webView
            if (r3 == 0) goto L_0x0a65
            java.lang.String r3 = "bottom"
            java.lang.Object r0 = r0.argument(r3)
            java.lang.Boolean r0 = (java.lang.Boolean) r0
            boolean r0 = r0.booleanValue()
            com.pichillilorenzo.flutter_inappwebview.types.InAppWebViewInterface r3 = r1.webView
            boolean r0 = r3.pageDown(r0)
            goto L_0x0995
        L_0x061b:
            com.pichillilorenzo.flutter_inappwebview.types.InAppWebViewInterface r0 = r1.webView
            if (r0 == 0) goto L_0x0a55
            r0.clearMatches()
            goto L_0x0a55
        L_0x0624:
            com.pichillilorenzo.flutter_inappwebview.types.InAppWebViewInterface r3 = r1.webView
            if (r3 == 0) goto L_0x0a55
            java.lang.Object r3 = r0.argument(r10)
            java.lang.String r3 = (java.lang.String) r3
            java.lang.String r4 = "cssLinkHtmlTagAttributes"
            java.lang.Object r0 = r0.argument(r4)
            java.util.Map r0 = (java.util.Map) r0
            com.pichillilorenzo.flutter_inappwebview.types.InAppWebViewInterface r4 = r1.webView
            r4.injectCSSFileFromUrl(r3, r0)
            goto L_0x0a55
        L_0x063d:
            com.pichillilorenzo.flutter_inappwebview.types.InAppWebViewInterface r0 = r1.webView
            if (r0 == 0) goto L_0x0a65
            boolean r0 = r0.canScrollVertically()
            goto L_0x0995
        L_0x0647:
            com.pichillilorenzo.flutter_inappwebview.types.InAppWebViewInterface r0 = r1.webView
            boolean r3 = r0 instanceof com.pichillilorenzo.flutter_inappwebview.in_app_webview.InAppWebView
            if (r3 == 0) goto L_0x0a4a
            android.webkit.WebView$HitTestResult r0 = r0.getHitTestResult()
            com.pichillilorenzo.flutter_inappwebview.types.HitTestResult r0 = com.pichillilorenzo.flutter_inappwebview.types.HitTestResult.fromWebViewHitTestResult(r0)
            java.util.Map r0 = r0.toMap()
            goto L_0x0a67
        L_0x065b:
            com.pichillilorenzo.flutter_inappwebview.types.InAppWebViewInterface r3 = r1.webView
            if (r3 == 0) goto L_0x0a55
            java.lang.String r3 = "urlRequest"
            java.lang.Object r0 = r0.argument(r3)
            java.util.Map r0 = (java.util.Map) r0
            com.pichillilorenzo.flutter_inappwebview.types.InAppWebViewInterface r3 = r1.webView
            com.pichillilorenzo.flutter_inappwebview.types.URLRequest r0 = com.pichillilorenzo.flutter_inappwebview.types.URLRequest.fromMap(r0)
            r3.loadUrl(r0)
            goto L_0x0a55
        L_0x0673:
            com.pichillilorenzo.flutter_inappwebview.types.InAppWebViewInterface r3 = r1.webView
            if (r3 == 0) goto L_0x0a55
            java.lang.String r3 = "POST_WEB_MESSAGE"
            boolean r3 = androidx.webkit.WebViewFeature.isFeatureSupported(r3)
            if (r3 == 0) goto L_0x0a55
            java.lang.String r3 = "message"
            java.lang.Object r3 = r0.argument(r3)
            java.util.Map r3 = (java.util.Map) r3
            java.lang.String r7 = "targetOrigin"
            java.lang.Object r0 = r0.argument(r7)
            java.lang.String r0 = (java.lang.String) r0
            java.util.ArrayList r7 = new java.util.ArrayList
            r7.<init>()
            java.util.ArrayList r8 = new java.util.ArrayList
            r8.<init>()
            java.lang.String r8 = "ports"
            java.lang.Object r8 = r3.get(r8)
            java.util.List r8 = (java.util.List) r8
            if (r8 == 0) goto L_0x06e7
            java.util.Iterator r8 = r8.iterator()
        L_0x06a8:
            boolean r10 = r8.hasNext()
            if (r10 == 0) goto L_0x06e7
            java.lang.Object r10 = r8.next()
            java.util.Map r10 = (java.util.Map) r10
            java.lang.String r11 = "webMessageChannelId"
            java.lang.Object r11 = r10.get(r11)
            java.lang.String r11 = (java.lang.String) r11
            java.lang.Object r10 = r10.get(r4)
            java.lang.Integer r10 = (java.lang.Integer) r10
            com.pichillilorenzo.flutter_inappwebview.types.InAppWebViewInterface r12 = r1.webView
            java.util.Map r12 = r12.getWebMessageChannels()
            java.lang.Object r11 = r12.get(r11)
            com.pichillilorenzo.flutter_inappwebview.types.WebMessageChannel r11 = (com.pichillilorenzo.flutter_inappwebview.types.WebMessageChannel) r11
            if (r11 == 0) goto L_0x06a8
            com.pichillilorenzo.flutter_inappwebview.types.InAppWebViewInterface r12 = r1.webView
            boolean r12 = r12 instanceof com.pichillilorenzo.flutter_inappwebview.in_app_webview.InAppWebView
            if (r12 == 0) goto L_0x06a8
            java.util.List<androidx.webkit.WebMessagePortCompat> r11 = r11.compatPorts
            int r10 = r10.intValue()
            java.lang.Object r10 = r11.get(r10)
            androidx.webkit.WebMessagePortCompat r10 = (androidx.webkit.WebMessagePortCompat) r10
            r7.add(r10)
            goto L_0x06a8
        L_0x06e7:
            com.pichillilorenzo.flutter_inappwebview.types.InAppWebViewInterface r4 = r1.webView
            boolean r4 = r4 instanceof com.pichillilorenzo.flutter_inappwebview.in_app_webview.InAppWebView
            if (r4 == 0) goto L_0x0a6a
            androidx.webkit.WebMessageCompat r4 = new androidx.webkit.WebMessageCompat
            java.lang.Object r3 = r3.get(r9)
            java.lang.String r3 = (java.lang.String) r3
            r8 = 0
            androidx.webkit.WebMessagePortCompat[] r8 = new androidx.webkit.WebMessagePortCompat[r8]
            java.lang.Object[] r7 = r7.toArray(r8)
            androidx.webkit.WebMessagePortCompat[] r7 = (androidx.webkit.WebMessagePortCompat[]) r7
            r4.<init>((java.lang.String) r3, (androidx.webkit.WebMessagePortCompat[]) r7)
            com.pichillilorenzo.flutter_inappwebview.types.InAppWebViewInterface r3 = r1.webView     // Catch:{ Exception -> 0x091c }
            android.webkit.WebView r3 = (android.webkit.WebView) r3     // Catch:{ Exception -> 0x091c }
            android.net.Uri r0 = android.net.Uri.parse(r0)     // Catch:{ Exception -> 0x091c }
            androidx.webkit.WebViewCompat.postWebMessage(r3, r4, r0)     // Catch:{ Exception -> 0x091c }
            java.lang.Boolean r0 = java.lang.Boolean.TRUE     // Catch:{ Exception -> 0x091c }
            r2.success(r0)     // Catch:{ Exception -> 0x091c }
            goto L_0x0a6a
        L_0x0713:
            com.pichillilorenzo.flutter_inappwebview.types.InAppWebViewInterface r3 = r1.webView
            if (r3 == 0) goto L_0x0a4a
            java.lang.String r3 = "screenshotConfiguration"
            java.lang.Object r0 = r0.argument(r3)
            java.util.Map r0 = (java.util.Map) r0
            com.pichillilorenzo.flutter_inappwebview.types.InAppWebViewInterface r3 = r1.webView
            r3.takeScreenshot(r0, r2)
            goto L_0x0a6a
        L_0x0726:
            com.pichillilorenzo.flutter_inappwebview.types.InAppWebViewInterface r0 = r1.webView
            if (r0 == 0) goto L_0x0a55
            r0.onPause()
            goto L_0x0a55
        L_0x072f:
            com.pichillilorenzo.flutter_inappwebview.types.InAppWebViewInterface r0 = r1.webView
            if (r0 == 0) goto L_0x0a4a
            boolean r0 = r0 instanceof com.pichillilorenzo.flutter_inappwebview.in_app_webview.InAppWebView
            if (r0 == 0) goto L_0x0a4a
            java.lang.String r0 = "CREATE_WEB_MESSAGE_CHANNEL"
            boolean r0 = androidx.webkit.WebViewFeature.isFeatureSupported(r0)
            if (r0 == 0) goto L_0x0a4a
            com.pichillilorenzo.flutter_inappwebview.types.InAppWebViewInterface r0 = r1.webView
            com.pichillilorenzo.flutter_inappwebview.types.WebMessageChannel r0 = r0.createCompatWebMessageChannel()
            java.util.Map r0 = r0.toMap()
            goto L_0x0a67
        L_0x074b:
            com.pichillilorenzo.flutter_inappwebview.types.InAppWebViewInterface r0 = r1.webView
            if (r0 == 0) goto L_0x08c4
            com.pichillilorenzo.flutter_inappwebview.in_app_browser.InAppBrowserDelegate r0 = r0.getInAppBrowserDelegate()
            if (r0 == 0) goto L_0x08c4
            com.pichillilorenzo.flutter_inappwebview.types.InAppWebViewInterface r0 = r1.webView
            com.pichillilorenzo.flutter_inappwebview.in_app_browser.InAppBrowserDelegate r0 = r0.getInAppBrowserDelegate()
            boolean r0 = r0 instanceof com.pichillilorenzo.flutter_inappwebview.in_app_browser.InAppBrowserActivity
            if (r0 == 0) goto L_0x08c4
            com.pichillilorenzo.flutter_inappwebview.types.InAppWebViewInterface r0 = r1.webView
            com.pichillilorenzo.flutter_inappwebview.in_app_browser.InAppBrowserDelegate r0 = r0.getInAppBrowserDelegate()
            com.pichillilorenzo.flutter_inappwebview.in_app_browser.InAppBrowserActivity r0 = (com.pichillilorenzo.flutter_inappwebview.in_app_browser.InAppBrowserActivity) r0
            r0.close(r2)
            goto L_0x0a6a
        L_0x076c:
            com.pichillilorenzo.flutter_inappwebview.types.InAppWebViewInterface r0 = r1.webView
            if (r0 == 0) goto L_0x08c4
            com.pichillilorenzo.flutter_inappwebview.in_app_browser.InAppBrowserDelegate r0 = r0.getInAppBrowserDelegate()
            if (r0 == 0) goto L_0x08c4
            com.pichillilorenzo.flutter_inappwebview.types.InAppWebViewInterface r0 = r1.webView
            com.pichillilorenzo.flutter_inappwebview.in_app_browser.InAppBrowserDelegate r0 = r0.getInAppBrowserDelegate()
            boolean r0 = r0 instanceof com.pichillilorenzo.flutter_inappwebview.in_app_browser.InAppBrowserActivity
            if (r0 == 0) goto L_0x08c4
            com.pichillilorenzo.flutter_inappwebview.types.InAppWebViewInterface r0 = r1.webView
            com.pichillilorenzo.flutter_inappwebview.in_app_browser.InAppBrowserDelegate r0 = r0.getInAppBrowserDelegate()
            com.pichillilorenzo.flutter_inappwebview.in_app_browser.InAppBrowserActivity r0 = (com.pichillilorenzo.flutter_inappwebview.in_app_browser.InAppBrowserActivity) r0
            r0.show()
            goto L_0x0a55
        L_0x078d:
            com.pichillilorenzo.flutter_inappwebview.types.InAppWebViewInterface r0 = r1.webView
            if (r0 == 0) goto L_0x08c4
            com.pichillilorenzo.flutter_inappwebview.in_app_browser.InAppBrowserDelegate r0 = r0.getInAppBrowserDelegate()
            if (r0 == 0) goto L_0x08c4
            com.pichillilorenzo.flutter_inappwebview.types.InAppWebViewInterface r0 = r1.webView
            com.pichillilorenzo.flutter_inappwebview.in_app_browser.InAppBrowserDelegate r0 = r0.getInAppBrowserDelegate()
            boolean r0 = r0 instanceof com.pichillilorenzo.flutter_inappwebview.in_app_browser.InAppBrowserActivity
            if (r0 == 0) goto L_0x08c4
            com.pichillilorenzo.flutter_inappwebview.types.InAppWebViewInterface r0 = r1.webView
            com.pichillilorenzo.flutter_inappwebview.in_app_browser.InAppBrowserDelegate r0 = r0.getInAppBrowserDelegate()
            com.pichillilorenzo.flutter_inappwebview.in_app_browser.InAppBrowserActivity r0 = (com.pichillilorenzo.flutter_inappwebview.in_app_browser.InAppBrowserActivity) r0
            r0.hide()
            goto L_0x0a55
        L_0x07ae:
            com.pichillilorenzo.flutter_inappwebview.types.InAppWebViewInterface r0 = r1.webView
            if (r0 == 0) goto L_0x0a65
            java.lang.String r0 = "START_SAFE_BROWSING"
            boolean r0 = androidx.webkit.WebViewFeature.isFeatureSupported(r0)
            if (r0 == 0) goto L_0x0a65
            com.pichillilorenzo.flutter_inappwebview.types.InAppWebViewInterface r0 = r1.webView
            android.content.Context r0 = r0.getContext()
            com.pichillilorenzo.flutter_inappwebview.InAppWebViewMethodHandler$2 r3 = new com.pichillilorenzo.flutter_inappwebview.InAppWebViewMethodHandler$2
            r3.<init>(r2)
            androidx.webkit.WebViewCompat.startSafeBrowsing(r0, r3)
            goto L_0x0a6a
        L_0x07ca:
            com.pichillilorenzo.flutter_inappwebview.types.InAppWebViewInterface r0 = r1.webView
            if (r0 == 0) goto L_0x0a4a
            java.util.HashMap r6 = r0.getCopyBackForwardList()
            goto L_0x0a4a
        L_0x07d4:
            com.pichillilorenzo.flutter_inappwebview.types.InAppWebViewInterface r3 = r1.webView
            if (r3 == 0) goto L_0x0a55
            java.lang.Object r0 = r0.argument(r11)
            java.lang.String r0 = (java.lang.String) r0
            com.pichillilorenzo.flutter_inappwebview.types.InAppWebViewInterface r3 = r1.webView
            r3.injectCSSCode(r0)
            goto L_0x0a55
        L_0x07e5:
            com.pichillilorenzo.flutter_inappwebview.types.InAppWebViewInterface r0 = r1.webView
            if (r0 == 0) goto L_0x0a65
            boolean r0 = r0.zoomOut()
            goto L_0x0995
        L_0x07ef:
            com.pichillilorenzo.flutter_inappwebview.types.InAppWebViewInterface r0 = r1.webView
            boolean r3 = r0 instanceof com.pichillilorenzo.flutter_inappwebview.in_app_webview.InAppWebView
            if (r3 == 0) goto L_0x0a4a
            com.pichillilorenzo.flutter_inappwebview.InAppWebViewMethodHandler$3 r3 = new com.pichillilorenzo.flutter_inappwebview.InAppWebViewMethodHandler$3
            r3.<init>(r2)
            r0.getSelectedText(r3)
            goto L_0x0a6a
        L_0x07ff:
            com.pichillilorenzo.flutter_inappwebview.types.InAppWebViewInterface r0 = r1.webView
            if (r0 == 0) goto L_0x0821
            com.pichillilorenzo.flutter_inappwebview.in_app_browser.InAppBrowserDelegate r0 = r0.getInAppBrowserDelegate()
            if (r0 == 0) goto L_0x0821
            com.pichillilorenzo.flutter_inappwebview.types.InAppWebViewInterface r0 = r1.webView
            com.pichillilorenzo.flutter_inappwebview.in_app_browser.InAppBrowserDelegate r0 = r0.getInAppBrowserDelegate()
            boolean r0 = r0 instanceof com.pichillilorenzo.flutter_inappwebview.in_app_browser.InAppBrowserActivity
            if (r0 == 0) goto L_0x0821
            com.pichillilorenzo.flutter_inappwebview.types.InAppWebViewInterface r0 = r1.webView
            com.pichillilorenzo.flutter_inappwebview.in_app_browser.InAppBrowserDelegate r0 = r0.getInAppBrowserDelegate()
            com.pichillilorenzo.flutter_inappwebview.in_app_browser.InAppBrowserActivity r0 = (com.pichillilorenzo.flutter_inappwebview.in_app_browser.InAppBrowserActivity) r0
            java.util.Map r0 = r0.getOptions()
            goto L_0x0a67
        L_0x0821:
            com.pichillilorenzo.flutter_inappwebview.types.InAppWebViewInterface r0 = r1.webView
            if (r0 == 0) goto L_0x0a4a
            java.util.Map r6 = r0.getOptions()
            goto L_0x0a4a
        L_0x082b:
            r8 = 0
            com.pichillilorenzo.flutter_inappwebview.types.InAppWebViewInterface r0 = r1.webView
            if (r0 == 0) goto L_0x09d1
            boolean r0 = r0.isLoading()
            if (r0 == 0) goto L_0x09d1
            goto L_0x09cf
        L_0x0838:
            r8 = 0
            com.pichillilorenzo.flutter_inappwebview.types.InAppWebViewInterface r0 = r1.webView
            if (r0 == 0) goto L_0x09d1
            boolean r0 = r0.canGoBack()
            if (r0 == 0) goto L_0x09d1
            goto L_0x09cf
        L_0x0845:
            com.pichillilorenzo.flutter_inappwebview.types.InAppWebViewInterface r0 = r1.webView
            if (r0 == 0) goto L_0x0a55
            r0.goForward()
            goto L_0x0a55
        L_0x084e:
            com.pichillilorenzo.flutter_inappwebview.types.InAppWebViewInterface r3 = r1.webView
            if (r3 == 0) goto L_0x0a55
            java.lang.String r3 = "url"
            java.lang.Object r3 = r0.argument(r3)
            java.lang.String r3 = (java.lang.String) r3
            java.lang.String r4 = "postData"
            java.lang.Object r0 = r0.argument(r4)
            byte[] r0 = (byte[]) r0
            com.pichillilorenzo.flutter_inappwebview.types.InAppWebViewInterface r4 = r1.webView
            r4.postUrl(r3, r0)
            goto L_0x0a55
        L_0x086a:
            com.pichillilorenzo.flutter_inappwebview.types.InAppWebViewInterface r3 = r1.webView
            if (r3 == 0) goto L_0x0a55
            java.lang.Object r3 = r0.argument(r14)
            java.lang.Integer r3 = (java.lang.Integer) r3
            java.lang.Object r4 = r0.argument(r13)
            java.lang.Integer r4 = (java.lang.Integer) r4
            java.lang.Object r0 = r0.argument(r12)
            java.lang.Boolean r0 = (java.lang.Boolean) r0
            com.pichillilorenzo.flutter_inappwebview.types.InAppWebViewInterface r5 = r1.webView
            r5.scrollTo(r3, r4, r0)
            goto L_0x0a55
        L_0x0887:
            com.pichillilorenzo.flutter_inappwebview.types.InAppWebViewInterface r3 = r1.webView
            if (r3 == 0) goto L_0x0a55
            java.lang.Object r3 = r0.argument(r14)
            java.lang.Integer r3 = (java.lang.Integer) r3
            java.lang.Object r4 = r0.argument(r13)
            java.lang.Integer r4 = (java.lang.Integer) r4
            java.lang.Object r0 = r0.argument(r12)
            java.lang.Boolean r0 = (java.lang.Boolean) r0
            com.pichillilorenzo.flutter_inappwebview.types.InAppWebViewInterface r5 = r1.webView
            r5.scrollBy(r3, r4, r0)
            goto L_0x0a55
        L_0x08a4:
            com.pichillilorenzo.flutter_inappwebview.types.InAppWebViewInterface r0 = r1.webView
            if (r0 == 0) goto L_0x08c4
            com.pichillilorenzo.flutter_inappwebview.in_app_browser.InAppBrowserDelegate r0 = r0.getInAppBrowserDelegate()
            if (r0 == 0) goto L_0x08c4
            com.pichillilorenzo.flutter_inappwebview.types.InAppWebViewInterface r0 = r1.webView
            com.pichillilorenzo.flutter_inappwebview.in_app_browser.InAppBrowserDelegate r0 = r0.getInAppBrowserDelegate()
            boolean r0 = r0 instanceof com.pichillilorenzo.flutter_inappwebview.in_app_browser.InAppBrowserActivity
            if (r0 == 0) goto L_0x08c4
            com.pichillilorenzo.flutter_inappwebview.types.InAppWebViewInterface r0 = r1.webView
            com.pichillilorenzo.flutter_inappwebview.in_app_browser.InAppBrowserDelegate r0 = r0.getInAppBrowserDelegate()
            com.pichillilorenzo.flutter_inappwebview.in_app_browser.InAppBrowserActivity r0 = (com.pichillilorenzo.flutter_inappwebview.in_app_browser.InAppBrowserActivity) r0
            boolean r0 = r0.isHidden
            goto L_0x0995
        L_0x08c4:
            r18.notImplemented()
            goto L_0x0a6a
        L_0x08c9:
            com.pichillilorenzo.flutter_inappwebview.types.InAppWebViewInterface r0 = r1.webView
            if (r0 == 0) goto L_0x0a55
            r0.printCurrentPage()
            goto L_0x0a55
        L_0x08d2:
            com.pichillilorenzo.flutter_inappwebview.types.InAppWebViewInterface r3 = r1.webView
            if (r3 == 0) goto L_0x0a55
            java.lang.String r3 = "forward"
            java.lang.Object r0 = r0.argument(r3)
            java.lang.Boolean r0 = (java.lang.Boolean) r0
            com.pichillilorenzo.flutter_inappwebview.types.InAppWebViewInterface r3 = r1.webView
            boolean r0 = r0.booleanValue()
            r3.findNext(r0)
            goto L_0x0a55
        L_0x08e9:
            com.pichillilorenzo.flutter_inappwebview.types.InAppWebViewInterface r3 = r1.webView
            if (r3 == 0) goto L_0x0a55
            java.lang.String r3 = "webMessageListener"
            java.lang.Object r0 = r0.argument(r3)
            java.util.Map r0 = (java.util.Map) r0
            com.pichillilorenzo.flutter_inappwebview.types.InAppWebViewInterface r3 = r1.webView
            com.pichillilorenzo.flutter_inappwebview.InAppWebViewFlutterPlugin r4 = r3.getPlugin()
            io.flutter.plugin.common.BinaryMessenger r4 = r4.messenger
            com.pichillilorenzo.flutter_inappwebview.types.WebMessageListener r0 = com.pichillilorenzo.flutter_inappwebview.types.WebMessageListener.fromMap(r3, r4, r0)
            com.pichillilorenzo.flutter_inappwebview.types.InAppWebViewInterface r3 = r1.webView
            boolean r3 = r3 instanceof com.pichillilorenzo.flutter_inappwebview.in_app_webview.InAppWebView
            if (r3 == 0) goto L_0x0a55
            java.lang.String r3 = "WEB_MESSAGE_LISTENER"
            boolean r3 = androidx.webkit.WebViewFeature.isFeatureSupported(r3)
            if (r3 == 0) goto L_0x0a55
            com.pichillilorenzo.flutter_inappwebview.types.InAppWebViewInterface r3 = r1.webView     // Catch:{ Exception -> 0x091c }
            r3.addWebMessageListener(r0)     // Catch:{ Exception -> 0x091c }
            java.lang.Boolean r0 = java.lang.Boolean.TRUE     // Catch:{ Exception -> 0x091c }
            r2.success(r0)     // Catch:{ Exception -> 0x091c }
            goto L_0x0a6a
        L_0x091c:
            r0 = move-exception
            java.lang.String r0 = r0.getMessage()
            r2.error(r5, r0, r6)
            goto L_0x0a6a
        L_0x0926:
            com.pichillilorenzo.flutter_inappwebview.types.InAppWebViewInterface r0 = r1.webView
            if (r0 == 0) goto L_0x0a65
            boolean r0 = r0.zoomIn()
            goto L_0x0995
        L_0x092f:
            com.pichillilorenzo.flutter_inappwebview.types.InAppWebViewInterface r3 = r1.webView
            if (r3 == 0) goto L_0x0a55
            java.lang.String r3 = "zoomFactor"
            java.lang.Object r0 = r0.argument(r3)
            java.lang.Double r0 = (java.lang.Double) r0
            double r3 = r0.doubleValue()
            com.pichillilorenzo.flutter_inappwebview.types.InAppWebViewInterface r0 = r1.webView
            float r3 = (float) r3
            r0.zoomBy(r3)
            goto L_0x0a55
        L_0x0948:
            com.pichillilorenzo.flutter_inappwebview.types.InAppWebViewInterface r0 = r1.webView
            if (r0 == 0) goto L_0x0a55
            r0.clearFocus()
            goto L_0x0a55
        L_0x0951:
            com.pichillilorenzo.flutter_inappwebview.types.InAppWebViewInterface r0 = r1.webView
            if (r0 == 0) goto L_0x0a55
            r0.clearAllCache()
            goto L_0x0a55
        L_0x095a:
            com.pichillilorenzo.flutter_inappwebview.types.InAppWebViewInterface r0 = r1.webView
            if (r0 == 0) goto L_0x0a55
            r0.onResume()
            goto L_0x0a55
        L_0x0963:
            com.pichillilorenzo.flutter_inappwebview.types.InAppWebViewInterface r0 = r1.webView
            if (r0 == 0) goto L_0x0a55
            r0.reload()
            goto L_0x0a55
        L_0x096c:
            com.pichillilorenzo.flutter_inappwebview.types.InAppWebViewInterface r0 = r1.webView
            if (r0 == 0) goto L_0x0a55
            r0.stopLoading()
            goto L_0x0a55
        L_0x0975:
            com.pichillilorenzo.flutter_inappwebview.types.InAppWebViewInterface r0 = r1.webView
            if (r0 == 0) goto L_0x0a65
            boolean r0 = r0.canScrollHorizontally()
            goto L_0x0995
        L_0x097e:
            com.pichillilorenzo.flutter_inappwebview.types.InAppWebViewInterface r3 = r1.webView
            if (r3 == 0) goto L_0x0a65
            java.lang.String r3 = "top"
            java.lang.Object r0 = r0.argument(r3)
            java.lang.Boolean r0 = (java.lang.Boolean) r0
            boolean r0 = r0.booleanValue()
            com.pichillilorenzo.flutter_inappwebview.types.InAppWebViewInterface r3 = r1.webView
            boolean r0 = r3.pageUp(r0)
        L_0x0995:
            java.lang.Boolean r0 = java.lang.Boolean.valueOf(r0)
            goto L_0x0a67
        L_0x099b:
            r8 = 0
            com.pichillilorenzo.flutter_inappwebview.types.InAppWebViewInterface r0 = r1.webView
            if (r0 == 0) goto L_0x09d1
            boolean r0 = r0.canGoForward()
            if (r0 == 0) goto L_0x09d1
            goto L_0x09cf
        L_0x09a7:
            com.pichillilorenzo.flutter_inappwebview.types.InAppWebViewInterface r0 = r1.webView
            if (r0 == 0) goto L_0x0a55
            r0.goBack()
            goto L_0x0a55
        L_0x09b0:
            com.pichillilorenzo.flutter_inappwebview.types.InAppWebViewInterface r0 = r1.webView
            if (r0 == 0) goto L_0x0a4a
            java.lang.String r6 = r0.getUrl()
            goto L_0x0a4a
        L_0x09ba:
            r8 = 0
            com.pichillilorenzo.flutter_inappwebview.types.InAppWebViewInterface r3 = r1.webView
            if (r3 == 0) goto L_0x09d1
            java.lang.Object r0 = r0.argument(r15)
            java.lang.Integer r0 = (java.lang.Integer) r0
            int r0 = r0.intValue()
            boolean r0 = r3.canGoBackOrForward(r0)
            if (r0 == 0) goto L_0x09d1
        L_0x09cf:
            r5 = 1
            goto L_0x09d2
        L_0x09d1:
            r5 = r8
        L_0x09d2:
            java.lang.Boolean r0 = java.lang.Boolean.valueOf(r5)
            goto L_0x0a67
        L_0x09d8:
            com.pichillilorenzo.flutter_inappwebview.types.InAppWebViewInterface r0 = r1.webView
            if (r0 == 0) goto L_0x0a4a
            int r0 = r0.getScrollY()
            goto L_0x0a45
        L_0x09e1:
            com.pichillilorenzo.flutter_inappwebview.types.InAppWebViewInterface r0 = r1.webView
            if (r0 == 0) goto L_0x0a4a
            int r0 = r0.getScrollX()
            goto L_0x0a45
        L_0x09ea:
            com.pichillilorenzo.flutter_inappwebview.types.InAppWebViewInterface r3 = r1.webView
            if (r3 == 0) goto L_0x0a4a
            java.lang.String r3 = "filePath"
            java.lang.Object r3 = r0.argument(r3)
            java.lang.String r3 = (java.lang.String) r3
            java.lang.String r4 = "autoname"
            java.lang.Object r0 = r0.argument(r4)
            java.lang.Boolean r0 = (java.lang.Boolean) r0
            boolean r0 = r0.booleanValue()
            com.pichillilorenzo.flutter_inappwebview.types.InAppWebViewInterface r4 = r1.webView
            com.pichillilorenzo.flutter_inappwebview.InAppWebViewMethodHandler$4 r5 = new com.pichillilorenzo.flutter_inappwebview.InAppWebViewMethodHandler$4
            r5.<init>(r2)
            r4.saveWebArchive(r3, r0, r5)
            goto L_0x0a6a
        L_0x0a0d:
            com.pichillilorenzo.flutter_inappwebview.types.InAppWebViewInterface r5 = r1.webView
            if (r5 == 0) goto L_0x0a65
            com.pichillilorenzo.flutter_inappwebview.types.UserContentController r5 = r5.getUserContentController()
            if (r5 == 0) goto L_0x0a65
            java.lang.Object r4 = r0.argument(r4)
            java.lang.Integer r4 = (java.lang.Integer) r4
            java.lang.Object r0 = r0.argument(r3)
            java.util.Map r0 = (java.util.Map) r0
            com.pichillilorenzo.flutter_inappwebview.types.UserScript r0 = com.pichillilorenzo.flutter_inappwebview.types.UserScript.fromMap(r0)
            com.pichillilorenzo.flutter_inappwebview.types.InAppWebViewInterface r3 = r1.webView
            com.pichillilorenzo.flutter_inappwebview.types.UserContentController r3 = r3.getUserContentController()
            int r4 = r4.intValue()
            com.pichillilorenzo.flutter_inappwebview.types.UserScriptInjectionTime r0 = r0.getInjectionTime()
            boolean r0 = r3.removeUserOnlyScriptAt(r4, r0)
            goto L_0x0995
        L_0x0a3b:
            com.pichillilorenzo.flutter_inappwebview.types.InAppWebViewInterface r0 = r1.webView
            boolean r3 = r0 instanceof com.pichillilorenzo.flutter_inappwebview.in_app_webview.InAppWebView
            if (r3 == 0) goto L_0x0a4a
            int r0 = r0.getContentHeight()
        L_0x0a45:
            java.lang.Integer r0 = java.lang.Integer.valueOf(r0)
            goto L_0x0a67
        L_0x0a4a:
            r2.success(r6)
            goto L_0x0a6a
        L_0x0a4e:
            com.pichillilorenzo.flutter_inappwebview.types.InAppWebViewInterface r0 = r1.webView
            if (r0 == 0) goto L_0x0a55
            r0.pauseTimers()
        L_0x0a55:
            java.lang.Boolean r0 = java.lang.Boolean.TRUE
            goto L_0x0a67
        L_0x0a58:
            com.pichillilorenzo.flutter_inappwebview.types.InAppWebViewInterface r0 = r1.webView
            if (r0 == 0) goto L_0x0a65
            com.pichillilorenzo.flutter_inappwebview.InAppWebViewMethodHandler$6 r3 = new com.pichillilorenzo.flutter_inappwebview.InAppWebViewMethodHandler$6
            r3.<init>(r2)
            r0.isSecureContext(r3)
            goto L_0x0a6a
        L_0x0a65:
            java.lang.Boolean r0 = java.lang.Boolean.FALSE
        L_0x0a67:
            r2.success(r0)
        L_0x0a6a:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.pichillilorenzo.flutter_inappwebview.InAppWebViewMethodHandler.onMethodCall(io.flutter.plugin.common.MethodCall, io.flutter.plugin.common.MethodChannel$Result):void");
    }
}
