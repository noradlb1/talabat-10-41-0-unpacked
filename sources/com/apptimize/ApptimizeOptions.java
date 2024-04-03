package com.apptimize;

import com.huawei.hms.flutter.map.constants.Param;

public class ApptimizeOptions {

    /* renamed from: a  reason: collision with root package name */
    private Long f40964a = null;

    /* renamed from: b  reason: collision with root package name */
    private boolean f40965b = false;

    /* renamed from: c  reason: collision with root package name */
    private String f40966c = null;

    /* renamed from: d  reason: collision with root package name */
    private boolean f40967d = false;

    /* renamed from: e  reason: collision with root package name */
    private LogLevel f40968e = LogLevel.VERBOSE;

    /* renamed from: f  reason: collision with root package name */
    private ServerRegion f40969f = ServerRegion.DEFAULT;

    /* renamed from: g  reason: collision with root package name */
    private boolean f40970g = false;

    /* renamed from: h  reason: collision with root package name */
    private boolean f40971h = true;

    /* renamed from: i  reason: collision with root package name */
    private boolean f40972i = true;

    /* renamed from: j  reason: collision with root package name */
    private boolean f40973j = true;

    /* renamed from: k  reason: collision with root package name */
    private boolean f40974k = false;

    /* renamed from: l  reason: collision with root package name */
    private boolean f40975l = false;

    /* renamed from: m  reason: collision with root package name */
    private boolean f40976m = false;

    /* renamed from: n  reason: collision with root package name */
    private boolean f40977n = false;

    /* renamed from: o  reason: collision with root package name */
    private boolean f40978o = true;

    public enum LogLevel {
        VERBOSE("VERBOSE"),
        DEBUG("DEBUG"),
        INFO("INFO"),
        WARNING("WARN"),
        ERROR(Param.ERROR),
        OFF("OFF");
        
        private String tag;

        private LogLevel(String str) {
            this.tag = str;
        }

        public String getTag() {
            return this.tag;
        }
    }

    public enum ServerRegion {
        DEFAULT("DEFAULT"),
        EUCS("EUCS");
        
        private String region;

        private ServerRegion(String str) {
            this.region = str;
        }

        public String getRegion() {
            return this.region;
        }
    }

    public ApptimizeOptions disableVisualChangesAndThirdPartyEventImport() {
        this.f40971h = false;
        this.f40972i = false;
        return this;
    }

    public boolean doesForceVariantsShowWinnersAndInstantUpdates() {
        return this.f40976m;
    }

    public String getDeviceName() {
        return this.f40966c;
    }

    public LogLevel getLogLevel() {
        return this.f40968e;
    }

    public ServerRegion getServerRegion() {
        return this.f40969f;
    }

    public Long getUpdateMetaDataTimeout() {
        return this.f40964a;
    }

    public boolean isDeveloperModeDisabled() {
        return this.f40965b;
    }

    public boolean isDevicePairingEnabled() {
        return this.f40978o;
    }

    public boolean isExplicitEnablingRequired() {
        return this.f40967d;
    }

    public boolean isMultiprocessModeEnabled() {
        return this.f40970g;
    }

    public boolean isPerformanceLoggingEnabled() {
        return this.f40975l;
    }

    public boolean isRefreshingMetadataOnSetup() {
        return this.f40977n;
    }

    public boolean isSetupInBackground() {
        return this.f40974k;
    }

    public boolean isThirdPartyEventExportingEnabled() {
        return this.f40973j;
    }

    public boolean isThirdPartyEventImportingEnabled() {
        return this.f40972i;
    }

    public boolean isVisualChangesEnabled() {
        return this.f40971h;
    }

    public ApptimizeOptions setDeveloperModeDisabled(boolean z11) {
        this.f40965b = z11;
        return this;
    }

    public ApptimizeOptions setDeviceName(String str) {
        this.f40966c = str;
        return this;
    }

    public ApptimizeOptions setExplicitEnablingRequired(boolean z11) {
        this.f40967d = z11;
        return this;
    }

    public ApptimizeOptions setForceVariantsShowWinnersAndInstantUpdates(boolean z11) {
        this.f40976m = z11;
        return this;
    }

    public ApptimizeOptions setIsDevicePairingEnabled(boolean z11) {
        this.f40978o = z11;
        return this;
    }

    public ApptimizeOptions setIsRefreshingMetadataOnSetup(boolean z11) {
        this.f40977n = z11;
        return this;
    }

    public ApptimizeOptions setLogLevel(LogLevel logLevel) {
        if (logLevel != null) {
            this.f40968e = logLevel;
        }
        return this;
    }

    public ApptimizeOptions setMultiprocessMode(boolean z11) {
        this.f40970g = z11;
        return this;
    }

    public ApptimizeOptions setPerformanceLoggingEnabled(boolean z11) {
        this.f40975l = z11;
        return this;
    }

    public ApptimizeOptions setServerRegion(ServerRegion serverRegion) {
        this.f40969f = serverRegion;
        return this;
    }

    public ApptimizeOptions setThirdPartyEventExportingEnabled(boolean z11) {
        this.f40973j = z11;
        return this;
    }

    public ApptimizeOptions setThirdPartyEventImportingEnabled(boolean z11) {
        this.f40972i = z11;
        return this;
    }

    public ApptimizeOptions setUpdateMetadataTimeout(long j11) {
        this.f40964a = Long.valueOf(j11);
        return this;
    }

    public ApptimizeOptions setVisualChangesEnabled(boolean z11) {
        this.f40971h = z11;
        return this;
    }

    public ApptimizeOptions setupInBackground(boolean z11) {
        this.f40974k = z11;
        return this;
    }
}
