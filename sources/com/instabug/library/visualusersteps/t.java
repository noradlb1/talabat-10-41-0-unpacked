package com.instabug.library.visualusersteps;

class t implements Runnable {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ String f52185b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ String f52186c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ d f52187d;

    /* renamed from: e  reason: collision with root package name */
    public final /* synthetic */ String f52188e;

    /* renamed from: f  reason: collision with root package name */
    public final /* synthetic */ String f52189f;

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ y f52190g;

    public t(y yVar, String str, String str2, d dVar, String str3, String str4) {
        this.f52190g = yVar;
        this.f52185b = str;
        this.f52186c = str2;
        this.f52187d = dVar;
        this.f52188e = str3;
        this.f52189f = str4;
    }

    /* JADX WARNING: Can't fix incorrect switch cases order */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void run() {
        /*
            r8 = this;
            java.lang.String r0 = r8.f52185b     // Catch:{ Exception -> 0x02ae }
            if (r0 == 0) goto L_0x000d
            java.lang.String r1 = "SupportRequestManagerFragment"
            boolean r0 = r0.equals(r1)     // Catch:{ Exception -> 0x02ae }
            if (r0 == 0) goto L_0x000d
            return
        L_0x000d:
            com.instabug.library.e0 r0 = com.instabug.library.e0.c()     // Catch:{ Exception -> 0x02ae }
            com.instabug.library.Feature r1 = com.instabug.library.Feature.REPRO_STEPS     // Catch:{ Exception -> 0x02ae }
            com.instabug.library.Feature$State r0 = r0.b((java.lang.Object) r1)     // Catch:{ Exception -> 0x02ae }
            com.instabug.library.Feature$State r1 = com.instabug.library.Feature.State.DISABLED     // Catch:{ Exception -> 0x02ae }
            if (r0 == r1) goto L_0x02a8
            boolean r0 = com.instabug.library.core.InstabugCore.isForegroundBusy()     // Catch:{ Exception -> 0x02ae }
            if (r0 != 0) goto L_0x02a8
            com.instabug.library.visualusersteps.y r0 = r8.f52190g     // Catch:{ Exception -> 0x02ae }
            boolean r0 = r0.m()     // Catch:{ Exception -> 0x02ae }
            if (r0 == 0) goto L_0x002b
            goto L_0x02a8
        L_0x002b:
            com.instabug.library.visualusersteps.y r0 = r8.f52190g     // Catch:{ Exception -> 0x02ae }
            r0.p()     // Catch:{ Exception -> 0x02ae }
            java.lang.String r0 = r8.f52186c     // Catch:{ Exception -> 0x02ae }
            int r1 = r0.hashCode()     // Catch:{ Exception -> 0x02ae }
            r2 = 0
            r3 = 4
            java.lang.String r4 = "DIALOG_FRAGMENT_RESUMED"
            r5 = 1
            java.lang.String r6 = "FRAGMENT_RESUMED"
            java.lang.String r7 = "ACTIVITY_RESUMED"
            switch(r1) {
                case -1933282175: goto L_0x0107;
                case -1705165623: goto L_0x00fd;
                case -1647502663: goto L_0x00f2;
                case -1643440744: goto L_0x00e7;
                case -1574447993: goto L_0x00df;
                case -1431942979: goto L_0x00d4;
                case -1382777347: goto L_0x00c9;
                case -1023412878: goto L_0x00be;
                case -1010547010: goto L_0x00b4;
                case -930544378: goto L_0x00a9;
                case -730405706: goto L_0x009d;
                case -274213071: goto L_0x0091;
                case -261347203: goto L_0x0086;
                case 3213533: goto L_0x007a;
                case 26863710: goto L_0x006e;
                case 433141802: goto L_0x0062;
                case 1757682911: goto L_0x0059;
                case 1855874739: goto L_0x004d;
                case 1971319496: goto L_0x0044;
                default: goto L_0x0042;
            }
        L_0x0042:
            goto L_0x0111
        L_0x0044:
            boolean r0 = r0.equals(r6)     // Catch:{ Exception -> 0x02ae }
            if (r0 == 0) goto L_0x0111
            r0 = r5
            goto L_0x0112
        L_0x004d:
            java.lang.String r1 = "FRAGMENT_ATTACHED"
            boolean r0 = r0.equals(r1)     // Catch:{ Exception -> 0x02ae }
            if (r0 == 0) goto L_0x0111
            r0 = 14
            goto L_0x0112
        L_0x0059:
            boolean r0 = r0.equals(r4)     // Catch:{ Exception -> 0x02ae }
            if (r0 == 0) goto L_0x0111
            r0 = 2
            goto L_0x0112
        L_0x0062:
            java.lang.String r1 = "UNKNOWN"
            boolean r0 = r0.equals(r1)     // Catch:{ Exception -> 0x02ae }
            if (r0 == 0) goto L_0x0111
            r0 = 9
            goto L_0x0112
        L_0x006e:
            java.lang.String r1 = "ACTIVITY_PAUSED"
            boolean r0 = r0.equals(r1)     // Catch:{ Exception -> 0x02ae }
            if (r0 == 0) goto L_0x0111
            r0 = 17
            goto L_0x0112
        L_0x007a:
            java.lang.String r1 = "OPEN_DIALOG"
            boolean r0 = r0.equals(r1)     // Catch:{ Exception -> 0x02ae }
            if (r0 == 0) goto L_0x0111
            r0 = 13
            goto L_0x0112
        L_0x0086:
            java.lang.String r1 = "ACTIVITY_STOPPED"
            boolean r0 = r0.equals(r1)     // Catch:{ Exception -> 0x02ae }
            if (r0 == 0) goto L_0x0111
            r0 = 6
            goto L_0x0112
        L_0x0091:
            java.lang.String r1 = "ACTIVITY_STARTED"
            boolean r0 = r0.equals(r1)     // Catch:{ Exception -> 0x02ae }
            if (r0 == 0) goto L_0x0111
            r0 = 12
            goto L_0x0112
        L_0x009d:
            java.lang.String r1 = "FRAGMENT_VISIBILITY_CHANGED"
            boolean r0 = r0.equals(r1)     // Catch:{ Exception -> 0x02ae }
            if (r0 == 0) goto L_0x0111
            r0 = 8
            goto L_0x0112
        L_0x00a9:
            java.lang.String r1 = "TAB_SELECT"
            boolean r0 = r0.equals(r1)     // Catch:{ Exception -> 0x02ae }
            if (r0 == 0) goto L_0x0111
            r0 = 3
            goto L_0x0112
        L_0x00b4:
            java.lang.String r1 = "FRAGMENT_STOPPED"
            boolean r0 = r0.equals(r1)     // Catch:{ Exception -> 0x02ae }
            if (r0 == 0) goto L_0x0111
            r0 = 7
            goto L_0x0112
        L_0x00be:
            java.lang.String r1 = "FRAGMENT_STARTED"
            boolean r0 = r0.equals(r1)     // Catch:{ Exception -> 0x02ae }
            if (r0 == 0) goto L_0x0111
            r0 = 16
            goto L_0x0112
        L_0x00c9:
            java.lang.String r1 = "FRAGMENT_PAUSED"
            boolean r0 = r0.equals(r1)     // Catch:{ Exception -> 0x02ae }
            if (r0 == 0) goto L_0x0111
            r0 = 18
            goto L_0x0112
        L_0x00d4:
            java.lang.String r1 = "FRAGMENT_VIEW_CREATED"
            boolean r0 = r0.equals(r1)     // Catch:{ Exception -> 0x02ae }
            if (r0 == 0) goto L_0x0111
            r0 = 15
            goto L_0x0112
        L_0x00df:
            boolean r0 = r0.equals(r7)     // Catch:{ Exception -> 0x02ae }
            if (r0 == 0) goto L_0x0111
            r0 = r2
            goto L_0x0112
        L_0x00e7:
            java.lang.String r1 = "ACTIVITY_CREATED"
            boolean r0 = r0.equals(r1)     // Catch:{ Exception -> 0x02ae }
            if (r0 == 0) goto L_0x0111
            r0 = 11
            goto L_0x0112
        L_0x00f2:
            java.lang.String r1 = "APPLICATION_CREATED"
            boolean r0 = r0.equals(r1)     // Catch:{ Exception -> 0x02ae }
            if (r0 == 0) goto L_0x0111
            r0 = 10
            goto L_0x0112
        L_0x00fd:
            java.lang.String r1 = "ACTIVITY_DESTROYED"
            boolean r0 = r0.equals(r1)     // Catch:{ Exception -> 0x02ae }
            if (r0 == 0) goto L_0x0111
            r0 = r3
            goto L_0x0112
        L_0x0107:
            java.lang.String r1 = "FRAGMENT_DETACHED"
            boolean r0 = r0.equals(r1)     // Catch:{ Exception -> 0x02ae }
            if (r0 == 0) goto L_0x0111
            r0 = 5
            goto L_0x0112
        L_0x0111:
            r0 = -1
        L_0x0112:
            switch(r0) {
                case 0: goto L_0x0177;
                case 1: goto L_0x0177;
                case 2: goto L_0x0177;
                case 3: goto L_0x014f;
                case 4: goto L_0x0119;
                case 5: goto L_0x0119;
                case 6: goto L_0x0119;
                case 7: goto L_0x0119;
                case 8: goto L_0x029b;
                case 9: goto L_0x029b;
                case 10: goto L_0x029b;
                case 11: goto L_0x029b;
                case 12: goto L_0x029b;
                case 13: goto L_0x029b;
                case 14: goto L_0x029b;
                case 15: goto L_0x029b;
                case 16: goto L_0x029b;
                default: goto L_0x0115;
            }     // Catch:{ Exception -> 0x02ae }
        L_0x0115:
            com.instabug.library.visualusersteps.y r1 = r8.f52190g     // Catch:{ Exception -> 0x02ae }
            goto L_0x028e
        L_0x0119:
            com.instabug.library.visualusersteps.d r0 = r8.f52187d     // Catch:{ Exception -> 0x02ae }
            if (r0 == 0) goto L_0x029b
            r0.b((boolean) r5)     // Catch:{ Exception -> 0x02ae }
            com.instabug.library.visualusersteps.d r0 = r8.f52187d     // Catch:{ Exception -> 0x02ae }
            com.instabug.library.visualusersteps.VisualUserStep r0 = r0.c()     // Catch:{ Exception -> 0x02ae }
            if (r0 == 0) goto L_0x029b
            com.instabug.library.visualusersteps.d r0 = r8.f52187d     // Catch:{ Exception -> 0x02ae }
            com.instabug.library.visualusersteps.VisualUserStep r0 = r0.c()     // Catch:{ Exception -> 0x02ae }
            java.lang.String r0 = r0.getStepType()     // Catch:{ Exception -> 0x02ae }
            if (r0 == 0) goto L_0x029b
            com.instabug.library.visualusersteps.d r0 = r8.f52187d     // Catch:{ Exception -> 0x02ae }
            com.instabug.library.visualusersteps.VisualUserStep r0 = r0.c()     // Catch:{ Exception -> 0x02ae }
            java.lang.String r0 = r0.getStepType()     // Catch:{ Exception -> 0x02ae }
            java.lang.String r1 = "START_EDITING"
            boolean r0 = r0.equals(r1)     // Catch:{ Exception -> 0x02ae }
            if (r0 == 0) goto L_0x029b
            com.instabug.library.visualusersteps.y r0 = r8.f52190g     // Catch:{ Exception -> 0x02ae }
            com.instabug.library.visualusersteps.d r1 = r8.f52187d     // Catch:{ Exception -> 0x02ae }
            r0.a((com.instabug.library.visualusersteps.d) r1, (boolean) r2)     // Catch:{ Exception -> 0x02ae }
            goto L_0x029b
        L_0x014f:
            java.lang.String r0 = r8.f52185b     // Catch:{ Exception -> 0x02ae }
            if (r0 == 0) goto L_0x029b
            com.instabug.library.visualusersteps.y r1 = r8.f52190g     // Catch:{ Exception -> 0x02ae }
            java.lang.String r1 = r1.f52205e     // Catch:{ Exception -> 0x02ae }
            boolean r0 = r0.equals(r1)     // Catch:{ Exception -> 0x02ae }
            if (r0 != 0) goto L_0x029b
            com.instabug.library.visualusersteps.y r0 = r8.f52190g     // Catch:{ Exception -> 0x02ae }
            java.lang.String r1 = r8.f52185b     // Catch:{ Exception -> 0x02ae }
            java.lang.String r2 = r8.f52186c     // Catch:{ Exception -> 0x02ae }
            r0.j(r1, r2)     // Catch:{ Exception -> 0x02ae }
            com.instabug.library.visualusersteps.y r0 = r8.f52190g     // Catch:{ Exception -> 0x02ae }
            com.instabug.library.visualusersteps.d r0 = r0.c()     // Catch:{ Exception -> 0x02ae }
            if (r0 == 0) goto L_0x029b
            com.instabug.library.visualusersteps.y r1 = r8.f52190g     // Catch:{ Exception -> 0x02ae }
            r1.g(r0)     // Catch:{ Exception -> 0x02ae }
            goto L_0x029b
        L_0x0177:
            com.instabug.library.visualusersteps.d r0 = r8.f52187d     // Catch:{ Exception -> 0x02ae }
            if (r0 == 0) goto L_0x01cf
            java.lang.String r0 = r0.g()     // Catch:{ Exception -> 0x02ae }
            if (r0 == 0) goto L_0x01cf
            com.instabug.library.visualusersteps.d r0 = r8.f52187d     // Catch:{ Exception -> 0x02ae }
            java.lang.String r0 = r0.e()     // Catch:{ Exception -> 0x02ae }
            if (r0 == 0) goto L_0x01ab
            com.instabug.library.visualusersteps.d r0 = r8.f52187d     // Catch:{ Exception -> 0x02ae }
            java.lang.String r0 = r0.e()     // Catch:{ Exception -> 0x02ae }
            java.lang.String r1 = r8.f52185b     // Catch:{ Exception -> 0x02ae }
            boolean r0 = r0.equals(r1)     // Catch:{ Exception -> 0x02ae }
            if (r0 == 0) goto L_0x01ab
            com.instabug.library.visualusersteps.d r0 = r8.f52187d     // Catch:{ Exception -> 0x02ae }
            java.lang.String r0 = r0.g()     // Catch:{ Exception -> 0x02ae }
            java.lang.String r1 = r8.f52186c     // Catch:{ Exception -> 0x02ae }
            boolean r0 = r0.equals(r1)     // Catch:{ Exception -> 0x02ae }
            if (r0 == 0) goto L_0x01ab
            com.instabug.library.visualusersteps.y r0 = r8.f52190g     // Catch:{ Exception -> 0x02ae }
            r0.n()     // Catch:{ Exception -> 0x02ae }
            return
        L_0x01ab:
            java.lang.String r0 = r8.f52186c     // Catch:{ Exception -> 0x02ae }
            boolean r0 = r0.equals(r7)     // Catch:{ Exception -> 0x02ae }
            if (r0 == 0) goto L_0x01cf
            com.instabug.library.visualusersteps.d r0 = r8.f52187d     // Catch:{ Exception -> 0x02ae }
            java.lang.String r0 = r0.g()     // Catch:{ Exception -> 0x02ae }
            boolean r0 = r0.equals(r6)     // Catch:{ Exception -> 0x02ae }
            if (r0 == 0) goto L_0x01cf
            com.instabug.library.visualusersteps.y r0 = r8.f52190g     // Catch:{ Exception -> 0x02ae }
            com.instabug.library.visualusersteps.d r1 = r8.f52187d     // Catch:{ Exception -> 0x02ae }
            boolean r0 = r0.b((com.instabug.library.visualusersteps.d) r1)     // Catch:{ Exception -> 0x02ae }
            if (r0 == 0) goto L_0x01cf
            com.instabug.library.visualusersteps.y r0 = r8.f52190g     // Catch:{ Exception -> 0x02ae }
            r0.n()     // Catch:{ Exception -> 0x02ae }
            return
        L_0x01cf:
            com.instabug.library.visualusersteps.d r0 = r8.f52187d     // Catch:{ Exception -> 0x02ae }
            if (r0 == 0) goto L_0x020c
            java.lang.String r0 = r8.f52186c     // Catch:{ Exception -> 0x02ae }
            boolean r0 = r0.equals(r4)     // Catch:{ Exception -> 0x02ae }
            if (r0 == 0) goto L_0x020c
            long r0 = android.os.SystemClock.elapsedRealtime()     // Catch:{ Exception -> 0x02ae }
            com.instabug.library.visualusersteps.y r2 = r8.f52190g     // Catch:{ Exception -> 0x02ae }
            long r6 = r2.f52207g     // Catch:{ Exception -> 0x02ae }
            long r0 = r0 - r6
            r6 = 500(0x1f4, double:2.47E-321)
            int r0 = (r0 > r6 ? 1 : (r0 == r6 ? 0 : -1))
            if (r0 < 0) goto L_0x01ff
            com.instabug.library.visualusersteps.d r0 = r8.f52187d     // Catch:{ Exception -> 0x02ae }
            boolean r0 = r0.i()     // Catch:{ Exception -> 0x02ae }
            if (r0 == 0) goto L_0x01f5
            goto L_0x01ff
        L_0x01f5:
            com.instabug.library.visualusersteps.y r0 = r8.f52190g     // Catch:{ Exception -> 0x02ae }
            long r1 = android.os.SystemClock.elapsedRealtime()     // Catch:{ Exception -> 0x02ae }
            long unused = r0.f52207g = r1     // Catch:{ Exception -> 0x02ae }
            goto L_0x0256
        L_0x01ff:
            com.instabug.library.visualusersteps.d r0 = r8.f52187d     // Catch:{ Exception -> 0x02ae }
            java.lang.String r1 = r8.f52185b     // Catch:{ Exception -> 0x02ae }
            r0.a((java.lang.String) r1)     // Catch:{ Exception -> 0x02ae }
            com.instabug.library.visualusersteps.y r0 = r8.f52190g     // Catch:{ Exception -> 0x02ae }
            r0.n()     // Catch:{ Exception -> 0x02ae }
            return
        L_0x020c:
            com.instabug.library.visualusersteps.d r0 = r8.f52187d     // Catch:{ Exception -> 0x02ae }
            if (r0 == 0) goto L_0x0256
            com.instabug.library.visualusersteps.y r1 = r8.f52190g     // Catch:{ Exception -> 0x02ae }
            boolean r0 = r1.b((com.instabug.library.visualusersteps.d) r0)     // Catch:{ Exception -> 0x02ae }
            if (r0 == 0) goto L_0x0256
            com.instabug.library.visualusersteps.d r0 = r8.f52187d     // Catch:{ Exception -> 0x02ae }
            java.lang.String r0 = r0.g()     // Catch:{ Exception -> 0x02ae }
            if (r0 == 0) goto L_0x0256
            com.instabug.library.visualusersteps.d r0 = r8.f52187d     // Catch:{ Exception -> 0x02ae }
            java.lang.String r0 = r0.g()     // Catch:{ Exception -> 0x02ae }
            boolean r0 = r0.equals(r6)     // Catch:{ Exception -> 0x02ae }
            if (r0 != 0) goto L_0x0256
            com.instabug.library.visualusersteps.d r0 = r8.f52187d     // Catch:{ Exception -> 0x02ae }
            java.lang.String r0 = r0.g()     // Catch:{ Exception -> 0x02ae }
            boolean r0 = r0.equals(r7)     // Catch:{ Exception -> 0x02ae }
            if (r0 != 0) goto L_0x0256
            com.instabug.library.visualusersteps.d r0 = r8.f52187d     // Catch:{ Exception -> 0x02ae }
            java.lang.String r1 = r8.f52185b     // Catch:{ Exception -> 0x02ae }
            r0.a((java.lang.String) r1)     // Catch:{ Exception -> 0x02ae }
            com.instabug.library.visualusersteps.y r0 = r8.f52190g     // Catch:{ Exception -> 0x02ae }
            com.instabug.library.visualusersteps.d r0 = r0.e()     // Catch:{ Exception -> 0x02ae }
            if (r0 == 0) goto L_0x0250
            com.instabug.library.visualusersteps.y r0 = r8.f52190g     // Catch:{ Exception -> 0x02ae }
            com.instabug.library.visualusersteps.d r1 = r0.e()     // Catch:{ Exception -> 0x02ae }
            r0.g(r1)     // Catch:{ Exception -> 0x02ae }
        L_0x0250:
            com.instabug.library.visualusersteps.y r0 = r8.f52190g     // Catch:{ Exception -> 0x02ae }
            r0.n()     // Catch:{ Exception -> 0x02ae }
            return
        L_0x0256:
            com.instabug.library.visualusersteps.d r0 = r8.f52187d     // Catch:{ Exception -> 0x02ae }
            if (r0 == 0) goto L_0x0260
            boolean r0 = r0.j()     // Catch:{ Exception -> 0x02ae }
            if (r0 == 0) goto L_0x027a
        L_0x0260:
            com.instabug.library.settings.SettingsManager r0 = com.instabug.library.settings.SettingsManager.getInstance()     // Catch:{ Exception -> 0x02ae }
            int r0 = r0.getCurrentPlatform()     // Catch:{ Exception -> 0x02ae }
            if (r0 == r3) goto L_0x027a
            com.instabug.library.visualusersteps.y r0 = r8.f52190g     // Catch:{ Exception -> 0x02ae }
            java.lang.String r1 = r8.f52185b     // Catch:{ Exception -> 0x02ae }
            java.lang.String r2 = r8.f52186c     // Catch:{ Exception -> 0x02ae }
            r0.j(r1, r2)     // Catch:{ Exception -> 0x02ae }
            com.instabug.library.visualusersteps.y r0 = r8.f52190g     // Catch:{ Exception -> 0x02ae }
            com.instabug.library.visualusersteps.d r0 = r0.c()     // Catch:{ Exception -> 0x02ae }
            goto L_0x027b
        L_0x027a:
            r0 = 0
        L_0x027b:
            if (r0 == 0) goto L_0x0280
            r0.b((boolean) r5)     // Catch:{ Exception -> 0x02ae }
        L_0x0280:
            if (r0 == 0) goto L_0x029b
            com.instabug.library.visualusersteps.c r1 = r0.d()     // Catch:{ Exception -> 0x02ae }
            if (r1 != 0) goto L_0x029b
            com.instabug.library.visualusersteps.y r1 = r8.f52190g     // Catch:{ Exception -> 0x02ae }
            r1.g(r0)     // Catch:{ Exception -> 0x02ae }
            goto L_0x029b
        L_0x028e:
            com.instabug.library.visualusersteps.d r2 = r8.f52187d     // Catch:{ Exception -> 0x02ae }
            java.lang.String r3 = r8.f52186c     // Catch:{ Exception -> 0x02ae }
            java.lang.String r4 = r8.f52185b     // Catch:{ Exception -> 0x02ae }
            java.lang.String r5 = r8.f52188e     // Catch:{ Exception -> 0x02ae }
            java.lang.String r6 = r8.f52189f     // Catch:{ Exception -> 0x02ae }
            r1.a((com.instabug.library.visualusersteps.d) r2, (java.lang.String) r3, (java.lang.String) r4, (java.lang.String) r5, (java.lang.String) r6)     // Catch:{ Exception -> 0x02ae }
        L_0x029b:
            com.instabug.library.visualusersteps.y r0 = r8.f52190g     // Catch:{ Exception -> 0x02ae }
            java.lang.String r1 = r8.f52185b     // Catch:{ Exception -> 0x02ae }
            java.lang.String unused = r0.f52205e = r1     // Catch:{ Exception -> 0x02ae }
            com.instabug.library.visualusersteps.y r0 = r8.f52190g     // Catch:{ Exception -> 0x02ae }
            r0.n()     // Catch:{ Exception -> 0x02ae }
            goto L_0x02b4
        L_0x02a8:
            com.instabug.library.visualusersteps.y r0 = r8.f52190g     // Catch:{ Exception -> 0x02ae }
            r0.n()     // Catch:{ Exception -> 0x02ae }
            return
        L_0x02ae:
            r0 = move-exception
            java.lang.String r1 = "couldn't add visual user step"
            com.instabug.library.diagnostics.IBGDiagnostics.reportNonFatal(r0, r1)
        L_0x02b4:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.instabug.library.visualusersteps.t.run():void");
    }
}
