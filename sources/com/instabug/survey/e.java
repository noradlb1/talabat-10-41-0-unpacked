package com.instabug.survey;

import com.instabug.library.user.UserEvent;
import com.instabug.library.util.InstabugSDKLogger;
import com.instabug.survey.settings.c;
import io.reactivex.functions.Consumer;

class e implements Consumer {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ h f52381b;

    public e(h hVar) {
        this.f52381b = hVar;
    }

    /* renamed from: a */
    public void accept(UserEvent userEvent) {
        if (this.f52381b.b()) {
            if (userEvent instanceof c) {
                InstabugSDKLogger.v("IBG-Surveys", "Surveys auto showing is triggered");
                this.f52381b.f52386c.d();
            } else if (c.o() && userEvent.getEventIdentifier() != null) {
                InstabugSDKLogger.v("IBG-Surveys", "Survey with event: {" + userEvent.getEventIdentifier() + "} is triggered");
                this.f52381b.f52386c.c(userEvent.getEventIdentifier());
            }
        }
    }
}
