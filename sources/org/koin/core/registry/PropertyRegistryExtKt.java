package org.koin.core.registry;

import com.braze.models.FeatureFlag;
import java.io.ByteArrayInputStream;
import java.net.URL;
import java.nio.charset.Charset;
import java.util.Map;
import java.util.Properties;
import kotlin.Metadata;
import kotlin.io.TextStreamsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Charsets;
import org.jetbrains.annotations.NotNull;
import org.koin.core.Koin;
import org.koin.core.error.NoPropertyFileFoundException;
import org.koin.core.logger.Level;

@Metadata(d1 = {"\u0000\u001a\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\u001a\u0010\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\u0002\u001a\n\u0010\u0004\u001a\u00020\u0005*\u00020\u0006\u001a\u0012\u0010\u0007\u001a\u00020\u0005*\u00020\u00062\u0006\u0010\b\u001a\u00020\u0003\u001a\u0012\u0010\t\u001a\u00020\u0005*\u00020\u00062\u0006\u0010\n\u001a\u00020\u0001¨\u0006\u000b"}, d2 = {"readDataFromFile", "Ljava/util/Properties;", "content", "", "loadEnvironmentProperties", "", "Lorg/koin/core/registry/PropertyRegistry;", "loadPropertiesFromFile", "fileName", "saveProperties", "properties", "koin-core"}, k = 2, mv = {1, 5, 1}, xi = 48)
public final class PropertyRegistryExtKt {
    public static final void loadEnvironmentProperties(@NotNull PropertyRegistry propertyRegistry) {
        Intrinsics.checkNotNullParameter(propertyRegistry, "<this>");
        propertyRegistry.get_koin$koin_core().getLogger().log(Level.DEBUG, (Function0<String>) PropertyRegistryExtKt$loadEnvironmentProperties$1.INSTANCE);
        Properties properties = System.getProperties();
        Intrinsics.checkNotNullExpressionValue(properties, "sysProperties");
        saveProperties(propertyRegistry, properties);
        Map<String, String> map = System.getenv();
        Intrinsics.checkNotNullExpressionValue(map, "getenv()");
        Properties properties2 = new Properties();
        properties2.putAll(map);
        saveProperties(propertyRegistry, properties2);
    }

    public static final void loadPropertiesFromFile(@NotNull PropertyRegistry propertyRegistry, @NotNull String str) {
        String str2;
        Intrinsics.checkNotNullParameter(propertyRegistry, "<this>");
        Intrinsics.checkNotNullParameter(str, "fileName");
        propertyRegistry.get_koin$koin_core().getLogger().log(Level.DEBUG, (Function0<String>) new PropertyRegistryExtKt$loadPropertiesFromFile$1(str));
        URL resource = Koin.class.getResource(str);
        if (resource == null) {
            str2 = null;
        } else {
            str2 = new String(TextStreamsKt.readBytes(resource), Charsets.UTF_8);
        }
        if (str2 != null) {
            propertyRegistry.get_koin$koin_core().getLogger().log(Level.INFO, (Function0<String>) new PropertyRegistryExtKt$loadPropertiesFromFile$2(str));
            saveProperties(propertyRegistry, readDataFromFile(str2));
            return;
        }
        throw new NoPropertyFileFoundException("No properties found for file '" + str + '\'');
    }

    private static final Properties readDataFromFile(String str) {
        Properties properties = new Properties();
        Charset charset = Charsets.UTF_8;
        if (str != null) {
            byte[] bytes = str.getBytes(charset);
            Intrinsics.checkNotNullExpressionValue(bytes, "(this as java.lang.String).getBytes(charset)");
            properties.load(new ByteArrayInputStream(bytes));
            return properties;
        }
        throw new NullPointerException("null cannot be cast to non-null type java.lang.String");
    }

    public static final void saveProperties(@NotNull PropertyRegistry propertyRegistry, @NotNull Properties properties) {
        Intrinsics.checkNotNullParameter(propertyRegistry, "<this>");
        Intrinsics.checkNotNullParameter(properties, FeatureFlag.PROPERTIES);
        propertyRegistry.get_koin$koin_core().getLogger().log(Level.DEBUG, (Function0<String>) new PropertyRegistryExtKt$saveProperties$1(properties));
        for (Map.Entry entry : MapsKt__MapsKt.toMap(properties).entrySet()) {
            propertyRegistry.saveProperty$koin_core((String) entry.getKey(), (String) entry.getValue());
        }
    }
}
