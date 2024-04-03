package com.talabat.feature.subscriptions.fake.di;

import java.lang.annotation.Documented;
import java.lang.annotation.RetentionPolicy;
import javax.inject.Qualifier;
import kotlin.Metadata;
import kotlin.annotation.AnnotationRetention;
import kotlin.annotation.MustBeDocumented;
import kotlin.annotation.Retention;

@MustBeDocumented
@Retention(AnnotationRetention.RUNTIME)
@Qualifier
@Documented
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u001b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0002\u0018\u00002\u00020\u0001B\n\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003R\u000f\u0010\u0002\u001a\u00020\u0003¢\u0006\u0006\u001a\u0004\b\u0002\u0010\u0004¨\u0006\u0005"}, d2 = {"Lcom/talabat/feature/subscriptions/fake/di/FakeSubscriptionsFeature;", "", "name", "", "()Ljava/lang/String;", "com_talabat_feature_subscriptions_fake_fake"}, k = 1, mv = {1, 6, 0}, xi = 48)
@java.lang.annotation.Retention(RetentionPolicy.RUNTIME)
public @interface FakeSubscriptionsFeature {
    String name() default "";
}
