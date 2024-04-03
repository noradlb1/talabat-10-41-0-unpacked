package com.newrelic.agent.android.rum;

import android.app.Application;
import android.content.Intent;
import android.os.SystemClock;
import java.util.concurrent.atomic.AtomicReference;

public final class AppTracer {
    private static Long appOnCreateEndTime = 0L;
    private static Long appOnCreateTime = 0L;
    private static Long contentProviderStartedTime = 0L;
    private static Boolean currentAppLaunchProcessed = Boolean.TRUE;
    private static Long firstActivityCreatedTime = 0L;
    private static Intent firstActivityIntent = null;
    private static String firstActivityName = null;
    private static String firstActivityReferrer = null;
    private static Long firstActivityResumeTime = 0L;
    private static Long firstActivityStartTime = 0L;
    private static Long firstDrawTime = 0L;
    private static final AtomicReference<AppTracer> instance = new AtomicReference<>(new AppTracer());
    private static Boolean isColdStart = null;
    private static Boolean isFirstPostExecuted = Boolean.FALSE;
    private static Long lastAppPauseTime = 0L;

    public static AppTracer getInstance() {
        return instance.get();
    }

    public Long getAppOnCreateEndTime() {
        return appOnCreateEndTime;
    }

    public Long getAppOnCreateTime() {
        return appOnCreateTime;
    }

    public Long getContentProviderStartedTime() {
        return contentProviderStartedTime;
    }

    public Boolean getCurrentAppLaunchProcessed() {
        return currentAppLaunchProcessed;
    }

    public Long getFirstActivityCreatedTime() {
        return firstActivityCreatedTime;
    }

    public Intent getFirstActivityIntent() {
        return firstActivityIntent;
    }

    public String getFirstActivityName() {
        return firstActivityName;
    }

    public String getFirstActivityReferrer() {
        return firstActivityReferrer;
    }

    public Long getFirstActivityResumeTime() {
        return firstActivityResumeTime;
    }

    public Long getFirstActivityStartTime() {
        return firstActivityStartTime;
    }

    public Long getFirstDrawTime() {
        return firstDrawTime;
    }

    public Boolean getFirstPostExecuted() {
        return isFirstPostExecuted;
    }

    public Long getLastAppPauseTime() {
        return lastAppPauseTime;
    }

    public boolean isColdStart() {
        return isColdStart.booleanValue();
    }

    public void onAppLaunchListener(Application application) {
        appOnCreateEndTime = Long.valueOf(SystemClock.uptimeMillis());
    }

    public void setAppOnCreateEndTime(Long l11) {
        appOnCreateEndTime = l11;
    }

    public void setAppOnCreateTime(Long l11) {
        appOnCreateTime = l11;
    }

    public void setContentProviderStartedTime(Long l11) {
        contentProviderStartedTime = l11;
    }

    public void setCurrentAppLaunchProcessed(Boolean bool) {
        currentAppLaunchProcessed = bool;
    }

    public void setFirstActivityCreatedTime(Long l11) {
        firstActivityCreatedTime = l11;
    }

    public void setFirstActivityIntent(Intent intent) {
        firstActivityIntent = intent;
    }

    public void setFirstActivityName(String str) {
        firstActivityName = str;
    }

    public void setFirstActivityReferrer(String str) {
        firstActivityReferrer = str;
    }

    public void setFirstActivityResumeTime(Long l11) {
        firstActivityResumeTime = l11;
    }

    public void setFirstActivityStartTime(Long l11) {
        firstActivityStartTime = l11;
    }

    public void setFirstDrawTime(Long l11) {
        firstDrawTime = l11;
    }

    public void setFirstPostExecuted(Boolean bool) {
        isFirstPostExecuted = bool;
    }

    public void setIsColdStart(boolean z11) {
        isColdStart = Boolean.valueOf(z11);
    }

    public void setLastAppPauseTime(Long l11) {
        lastAppPauseTime = l11;
    }

    public void start() {
        appOnCreateTime = Long.valueOf(SystemClock.uptimeMillis());
    }
}
