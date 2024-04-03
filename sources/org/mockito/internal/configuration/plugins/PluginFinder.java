package org.mockito.internal.configuration.plugins;

import com.google.firebase.perf.network.FirebasePerfUrlConnection;
import java.io.InputStream;
import java.net.URL;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.mockito.exceptions.base.MockitoException;
import org.mockito.internal.util.io.IOUtil;
import org.mockito.plugins.PluginSwitch;

class PluginFinder {
    private final PluginSwitch pluginSwitch;

    public PluginFinder(PluginSwitch pluginSwitch2) {
        this.pluginSwitch = pluginSwitch2;
    }

    public String a(Iterable<URL> iterable) {
        Iterator<URL> it = iterable.iterator();
        while (true) {
            InputStream inputStream = null;
            if (!it.hasNext()) {
                return null;
            }
            URL next = it.next();
            try {
                inputStream = FirebasePerfUrlConnection.openStream(next);
                String a11 = new PluginFileReader().a(inputStream);
                if (a11 != null) {
                    if (this.pluginSwitch.isEnabled(a11)) {
                        IOUtil.closeQuietly(inputStream);
                        return a11;
                    }
                }
                IOUtil.closeQuietly(inputStream);
            } catch (Exception e11) {
                throw new MockitoException("Problems reading plugin implementation from: " + next, e11);
            } catch (Throwable th2) {
                IOUtil.closeQuietly(inputStream);
                throw th2;
            }
        }
    }

    public List<String> b(Iterable<URL> iterable) {
        ArrayList arrayList = new ArrayList();
        for (URL next : iterable) {
            InputStream inputStream = null;
            try {
                inputStream = FirebasePerfUrlConnection.openStream(next);
                String a11 = new PluginFileReader().a(inputStream);
                if (a11 != null) {
                    if (this.pluginSwitch.isEnabled(a11)) {
                        arrayList.add(a11);
                    }
                }
                IOUtil.closeQuietly(inputStream);
            } catch (Exception e11) {
                throw new MockitoException("Problems reading plugin implementation from: " + next, e11);
            } catch (Throwable th2) {
                IOUtil.closeQuietly(inputStream);
                throw th2;
            }
        }
        return arrayList;
    }
}
