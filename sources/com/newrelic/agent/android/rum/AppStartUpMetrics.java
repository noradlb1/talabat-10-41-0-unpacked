package com.newrelic.agent.android.rum;

import kotlinx.serialization.json.internal.AbstractJsonLexerKt;

public class AppStartUpMetrics {
    private Long appOnCreateEndToFirstActivityCreate = 0L;
    private Long applicationOnCreateTime = 0L;
    private Long coldStartTime = 0L;
    private Long contentProviderToAppStart = 0L;
    private Long firstActivityCreateToResume = 0L;
    private Long hotStartTime = 0L;
    private Long warmStartTime = 0L;

    public AppStartUpMetrics() {
        AppTracer instance = AppTracer.getInstance();
        this.contentProviderToAppStart = Long.valueOf(instance.getAppOnCreateTime().longValue() - instance.getContentProviderStartedTime().longValue());
        this.applicationOnCreateTime = Long.valueOf(instance.getAppOnCreateEndTime().longValue() - instance.getAppOnCreateTime().longValue());
        this.appOnCreateEndToFirstActivityCreate = Long.valueOf(instance.getFirstActivityCreatedTime().longValue() - instance.getAppOnCreateEndTime().longValue());
        this.firstActivityCreateToResume = Long.valueOf(instance.getFirstActivityResumeTime().longValue() - instance.getFirstActivityCreatedTime().longValue());
        this.coldStartTime = Long.valueOf(instance.getFirstActivityResumeTime().longValue() - instance.getContentProviderStartedTime().longValue());
        this.hotStartTime = Long.valueOf(instance.getFirstActivityResumeTime().longValue() - instance.getFirstActivityStartTime().longValue());
        this.warmStartTime = Long.valueOf(instance.getFirstActivityResumeTime().longValue() - instance.getContentProviderStartedTime().longValue());
    }

    public Long getAppOnCreateEndToFirstActivityCreate() {
        return this.appOnCreateEndToFirstActivityCreate;
    }

    public Long getApplicationOnCreateTime() {
        return this.applicationOnCreateTime;
    }

    public Long getColdStartTime() {
        return this.coldStartTime;
    }

    public Long getContentProviderToAppStart() {
        return this.contentProviderToAppStart;
    }

    public Long getFirstActivityCreateToResume() {
        return this.firstActivityCreateToResume;
    }

    public Long getHotStartTime() {
        return this.hotStartTime;
    }

    public Long getWarmStartTime() {
        return this.warmStartTime;
    }

    public void setAppOnCreateEndToFirstActivityCreate(Long l11) {
        this.appOnCreateEndToFirstActivityCreate = l11;
    }

    public void setApplicationOnCreateTime(Long l11) {
        this.applicationOnCreateTime = l11;
    }

    public void setColdStartTime(Long l11) {
        this.coldStartTime = l11;
    }

    public void setContentProviderToAppStart(Long l11) {
        this.contentProviderToAppStart = l11;
    }

    public void setFirstActivityCreateToResume(Long l11) {
        this.firstActivityCreateToResume = l11;
    }

    public void setHotStartTime(Long l11) {
        this.hotStartTime = l11;
    }

    public void setWarmStartTime(Long l11) {
        this.warmStartTime = l11;
    }

    public String toString() {
        return "NewRelicAppStartUpMetrics{contentProviderToAppStart=" + (((double) this.contentProviderToAppStart.longValue()) / 1000.0d) + ", applicationOnCreateTime=" + (((double) this.applicationOnCreateTime.longValue()) / 1000.0d) + ", appOnCreateEndToFirstActivityCreate=" + (((double) this.appOnCreateEndToFirstActivityCreate.longValue()) / 1000.0d) + ", firstActivityCreateToResume=" + (((double) this.firstActivityCreateToResume.longValue()) / 1000.0d) + ", coldStartTime=" + (((double) this.coldStartTime.longValue()) / 1000.0d) + ", hotStartTime=" + (((double) this.hotStartTime.longValue()) / 1000.0d) + ", warmStartTime=" + (((double) this.warmStartTime.longValue()) / 1000.0d) + AbstractJsonLexerKt.END_OBJ;
    }
}
