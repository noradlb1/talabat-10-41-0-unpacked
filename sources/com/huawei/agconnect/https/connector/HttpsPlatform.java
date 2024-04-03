package com.huawei.agconnect.https.connector;

public class HttpsPlatform {
    private static final HttpsPlatform INSTANCE = new HttpsPlatform();
    private Connector connector;

    private HttpsPlatform() {
    }

    public static HttpsPlatform getInstance() {
        return INSTANCE;
    }

    public Connector getConnector() {
        return this.connector;
    }

    public void init(Connector connector2) {
        if (this.connector == null) {
            this.connector = connector2;
        }
    }
}
