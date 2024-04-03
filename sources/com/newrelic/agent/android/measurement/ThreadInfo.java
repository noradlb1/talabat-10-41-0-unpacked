package com.newrelic.agent.android.measurement;

public class ThreadInfo {

    /* renamed from: id  reason: collision with root package name */
    private long f52784id;

    /* renamed from: name  reason: collision with root package name */
    private String f52785name;

    public ThreadInfo() {
        this(Thread.currentThread());
    }

    public static ThreadInfo fromThread(Thread thread) {
        return new ThreadInfo(thread);
    }

    public long getId() {
        return this.f52784id;
    }

    public String getName() {
        return this.f52785name;
    }

    public void setId(long j11) {
        this.f52784id = j11;
    }

    public void setName(String str) {
        this.f52785name = str;
    }

    public String toString() {
        long j11 = this.f52784id;
        String str = this.f52785name;
        return "ThreadInfo{id=" + j11 + ", name='" + str + "'}";
    }

    public ThreadInfo(long j11, String str) {
        this.f52784id = j11;
        this.f52785name = str;
    }

    public ThreadInfo(Thread thread) {
        this(thread.getId(), thread.getName());
    }
}
