package org.junit.rules;

import org.junit.runner.Description;

public class TestName extends TestWatcher {

    /* renamed from: name  reason: collision with root package name */
    private String f28116name;

    public String getMethodName() {
        return this.f28116name;
    }

    public void j(Description description) {
        this.f28116name = description.getMethodName();
    }
}
