package com.huawei.hms.dtm.core;

import java.net.Inet4Address;
import java.net.InetAddress;
import java.net.NetworkInterface;
import java.net.SocketException;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public class Ab extends Y {
    public C0435sc<?> a(X x11, List<C0435sc<?>> list) throws V {
        try {
            for (T inetAddresses : Collections.list(NetworkInterface.getNetworkInterfaces())) {
                Iterator<T> it = Collections.list(inetAddresses.getInetAddresses()).iterator();
                while (true) {
                    if (it.hasNext()) {
                        InetAddress inetAddress = (InetAddress) it.next();
                        if (!inetAddress.isLoopbackAddress() && (inetAddress instanceof Inet4Address)) {
                            return new Cc(inetAddress.getHostAddress());
                        }
                    }
                }
            }
            return new Cc("");
        } catch (SocketException unused) {
            return Cc.f48270b;
        }
    }

    public String a() {
        return "deviceIp";
    }
}
