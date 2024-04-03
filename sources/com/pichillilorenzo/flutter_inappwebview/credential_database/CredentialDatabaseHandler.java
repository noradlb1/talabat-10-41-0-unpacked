package com.pichillilorenzo.flutter_inappwebview.credential_database;

import com.pichillilorenzo.flutter_inappwebview.InAppWebViewFlutterPlugin;
import io.flutter.plugin.common.MethodChannel;

public class CredentialDatabaseHandler implements MethodChannel.MethodCallHandler {
    static final String LOG_TAG = "CredentialDatabaseHandler";
    public static CredentialDatabase credentialDatabase;
    public MethodChannel channel;
    public InAppWebViewFlutterPlugin plugin;

    public CredentialDatabaseHandler(InAppWebViewFlutterPlugin inAppWebViewFlutterPlugin) {
        this.plugin = inAppWebViewFlutterPlugin;
        MethodChannel methodChannel = new MethodChannel(inAppWebViewFlutterPlugin.messenger, "com.pichillilorenzo/flutter_inappwebview_credential_database");
        this.channel = methodChannel;
        methodChannel.setMethodCallHandler(this);
    }

    public static void init(InAppWebViewFlutterPlugin inAppWebViewFlutterPlugin) {
        if (credentialDatabase == null) {
            credentialDatabase = CredentialDatabase.getInstance(inAppWebViewFlutterPlugin.applicationContext);
        }
    }

    public void dispose() {
        this.channel.setMethodCallHandler((MethodChannel.MethodCallHandler) null);
        this.plugin = null;
    }

    /* JADX WARNING: type inference failed for: r14v15, types: [java.util.List, java.util.ArrayList] */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Unknown variable types count: 1 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void onMethodCall(io.flutter.plugin.common.MethodCall r14, io.flutter.plugin.common.MethodChannel.Result r15) {
        /*
            r13 = this;
            com.pichillilorenzo.flutter_inappwebview.InAppWebViewFlutterPlugin r0 = r13.plugin
            if (r0 == 0) goto L_0x0007
            init(r0)
        L_0x0007:
            java.lang.String r0 = r14.method
            r0.hashCode()
            int r1 = r0.hashCode()
            r2 = -1
            switch(r1) {
                case -1851697792: goto L_0x004c;
                case -410271914: goto L_0x0041;
                case 589173355: goto L_0x0036;
                case 998955721: goto L_0x002b;
                case 1084504936: goto L_0x0020;
                case 1930845769: goto L_0x0015;
                default: goto L_0x0014;
            }
        L_0x0014:
            goto L_0x0056
        L_0x0015:
            java.lang.String r1 = "getAllAuthCredentials"
            boolean r0 = r0.equals(r1)
            if (r0 != 0) goto L_0x001e
            goto L_0x0056
        L_0x001e:
            r2 = 5
            goto L_0x0056
        L_0x0020:
            java.lang.String r1 = "removeHttpAuthCredentials"
            boolean r0 = r0.equals(r1)
            if (r0 != 0) goto L_0x0029
            goto L_0x0056
        L_0x0029:
            r2 = 4
            goto L_0x0056
        L_0x002b:
            java.lang.String r1 = "setHttpAuthCredential"
            boolean r0 = r0.equals(r1)
            if (r0 != 0) goto L_0x0034
            goto L_0x0056
        L_0x0034:
            r2 = 3
            goto L_0x0056
        L_0x0036:
            java.lang.String r1 = "removeHttpAuthCredential"
            boolean r0 = r0.equals(r1)
            if (r0 != 0) goto L_0x003f
            goto L_0x0056
        L_0x003f:
            r2 = 2
            goto L_0x0056
        L_0x0041:
            java.lang.String r1 = "getHttpAuthCredentials"
            boolean r0 = r0.equals(r1)
            if (r0 != 0) goto L_0x004a
            goto L_0x0056
        L_0x004a:
            r2 = 1
            goto L_0x0056
        L_0x004c:
            java.lang.String r1 = "clearAllAuthCredentials"
            boolean r0 = r0.equals(r1)
            if (r0 != 0) goto L_0x0055
            goto L_0x0056
        L_0x0055:
            r2 = 0
        L_0x0056:
            java.lang.String r0 = "password"
            java.lang.String r1 = "username"
            java.lang.String r3 = "port"
            java.lang.String r4 = "realm"
            java.lang.String r5 = "protocol"
            java.lang.String r6 = "host"
            switch(r2) {
                case 0: goto L_0x018a;
                case 1: goto L_0x014b;
                case 2: goto L_0x0116;
                case 3: goto L_0x00e6;
                case 4: goto L_0x00c8;
                case 5: goto L_0x006b;
                default: goto L_0x0066;
            }
        L_0x0066:
            r15.notImplemented()
            goto L_0x019f
        L_0x006b:
            java.util.ArrayList r14 = new java.util.ArrayList
            r14.<init>()
            com.pichillilorenzo.flutter_inappwebview.credential_database.CredentialDatabase r0 = credentialDatabase
            com.pichillilorenzo.flutter_inappwebview.credential_database.URLProtectionSpaceDao r0 = r0.protectionSpaceDao
            java.util.List r0 = r0.getAll()
            java.util.Iterator r0 = r0.iterator()
        L_0x007c:
            boolean r1 = r0.hasNext()
            if (r1 == 0) goto L_0x0147
            java.lang.Object r1 = r0.next()
            com.pichillilorenzo.flutter_inappwebview.types.URLProtectionSpace r1 = (com.pichillilorenzo.flutter_inappwebview.types.URLProtectionSpace) r1
            java.util.ArrayList r2 = new java.util.ArrayList
            r2.<init>()
            com.pichillilorenzo.flutter_inappwebview.credential_database.CredentialDatabase r3 = credentialDatabase
            com.pichillilorenzo.flutter_inappwebview.credential_database.URLCredentialDao r3 = r3.credentialDao
            java.lang.Long r4 = r1.getId()
            java.util.List r3 = r3.getAllByProtectionSpaceId(r4)
            java.util.Iterator r3 = r3.iterator()
        L_0x009d:
            boolean r4 = r3.hasNext()
            if (r4 == 0) goto L_0x00b1
            java.lang.Object r4 = r3.next()
            com.pichillilorenzo.flutter_inappwebview.types.URLCredential r4 = (com.pichillilorenzo.flutter_inappwebview.types.URLCredential) r4
            java.util.Map r4 = r4.toMap()
            r2.add(r4)
            goto L_0x009d
        L_0x00b1:
            java.util.HashMap r3 = new java.util.HashMap
            r3.<init>()
            java.util.Map r1 = r1.toMap()
            java.lang.String r4 = "protectionSpace"
            r3.put(r4, r1)
            java.lang.String r1 = "credentials"
            r3.put(r1, r2)
            r14.add(r3)
            goto L_0x007c
        L_0x00c8:
            java.lang.Object r0 = r14.argument(r6)
            java.lang.String r0 = (java.lang.String) r0
            java.lang.Object r1 = r14.argument(r5)
            java.lang.String r1 = (java.lang.String) r1
            java.lang.Object r2 = r14.argument(r4)
            java.lang.String r2 = (java.lang.String) r2
            java.lang.Object r14 = r14.argument(r3)
            java.lang.Integer r14 = (java.lang.Integer) r14
            com.pichillilorenzo.flutter_inappwebview.credential_database.CredentialDatabase r3 = credentialDatabase
            r3.removeHttpAuthCredentials(r0, r1, r2, r14)
            goto L_0x0145
        L_0x00e6:
            java.lang.Object r2 = r14.argument(r6)
            r7 = r2
            java.lang.String r7 = (java.lang.String) r7
            java.lang.Object r2 = r14.argument(r5)
            r8 = r2
            java.lang.String r8 = (java.lang.String) r8
            java.lang.Object r2 = r14.argument(r4)
            r9 = r2
            java.lang.String r9 = (java.lang.String) r9
            java.lang.Object r2 = r14.argument(r3)
            r10 = r2
            java.lang.Integer r10 = (java.lang.Integer) r10
            java.lang.Object r1 = r14.argument(r1)
            r11 = r1
            java.lang.String r11 = (java.lang.String) r11
            java.lang.Object r14 = r14.argument(r0)
            r12 = r14
            java.lang.String r12 = (java.lang.String) r12
            com.pichillilorenzo.flutter_inappwebview.credential_database.CredentialDatabase r6 = credentialDatabase
            r6.setHttpAuthCredential(r7, r8, r9, r10, r11, r12)
            goto L_0x0145
        L_0x0116:
            java.lang.Object r2 = r14.argument(r6)
            r7 = r2
            java.lang.String r7 = (java.lang.String) r7
            java.lang.Object r2 = r14.argument(r5)
            r8 = r2
            java.lang.String r8 = (java.lang.String) r8
            java.lang.Object r2 = r14.argument(r4)
            r9 = r2
            java.lang.String r9 = (java.lang.String) r9
            java.lang.Object r2 = r14.argument(r3)
            r10 = r2
            java.lang.Integer r10 = (java.lang.Integer) r10
            java.lang.Object r1 = r14.argument(r1)
            r11 = r1
            java.lang.String r11 = (java.lang.String) r11
            java.lang.Object r14 = r14.argument(r0)
            r12 = r14
            java.lang.String r12 = (java.lang.String) r12
            com.pichillilorenzo.flutter_inappwebview.credential_database.CredentialDatabase r6 = credentialDatabase
            r6.removeHttpAuthCredential(r7, r8, r9, r10, r11, r12)
        L_0x0145:
            java.lang.Boolean r14 = java.lang.Boolean.TRUE
        L_0x0147:
            r15.success(r14)
            goto L_0x019f
        L_0x014b:
            java.lang.Object r0 = r14.argument(r6)
            java.lang.String r0 = (java.lang.String) r0
            java.lang.Object r1 = r14.argument(r5)
            java.lang.String r1 = (java.lang.String) r1
            java.lang.Object r2 = r14.argument(r4)
            java.lang.String r2 = (java.lang.String) r2
            java.lang.Object r14 = r14.argument(r3)
            java.lang.Integer r14 = (java.lang.Integer) r14
            java.util.ArrayList r3 = new java.util.ArrayList
            r3.<init>()
            com.pichillilorenzo.flutter_inappwebview.credential_database.CredentialDatabase r4 = credentialDatabase
            java.util.List r14 = r4.getHttpAuthCredentials(r0, r1, r2, r14)
            java.util.Iterator r14 = r14.iterator()
        L_0x0172:
            boolean r0 = r14.hasNext()
            if (r0 == 0) goto L_0x0186
            java.lang.Object r0 = r14.next()
            com.pichillilorenzo.flutter_inappwebview.types.URLCredential r0 = (com.pichillilorenzo.flutter_inappwebview.types.URLCredential) r0
            java.util.Map r0 = r0.toMap()
            r3.add(r0)
            goto L_0x0172
        L_0x0186:
            r15.success(r3)
            goto L_0x019f
        L_0x018a:
            com.pichillilorenzo.flutter_inappwebview.credential_database.CredentialDatabase r14 = credentialDatabase
            r14.clearAllAuthCredentials()
            com.pichillilorenzo.flutter_inappwebview.InAppWebViewFlutterPlugin r14 = r13.plugin
            if (r14 == 0) goto L_0x0145
            android.content.Context r14 = r14.applicationContext
            if (r14 == 0) goto L_0x0145
            android.webkit.WebViewDatabase r14 = android.webkit.WebViewDatabase.getInstance(r14)
            r14.clearHttpAuthUsernamePassword()
            goto L_0x0145
        L_0x019f:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.pichillilorenzo.flutter_inappwebview.credential_database.CredentialDatabaseHandler.onMethodCall(io.flutter.plugin.common.MethodCall, io.flutter.plugin.common.MethodChannel$Result):void");
    }
}
