package com.jinx.register.support;

import com.google.common.collect.Sets;
import com.jinx.common.URL;
import com.jinx.monitor.NotifyListener;
import com.jinx.register.Registry;

import java.util.List;
import java.util.Set;

public abstract class AbstractRegistry implements Registry {

    private final Set<URL> registered = Sets.newConcurrentHashSet();

    @Override
    public URL getUrl() {
        return null;
    }

    @Override
    public List<URL> lookup(URL url) {
        return null;
    }

    @Override
    public void register(URL url) {
        if (url == null) {
            throw new IllegalArgumentException("register url == null");
        }
        registered.add(url);
    }

    @Override
    public void unregister(URL url) {

    }

    @Override
    public void subscribe(URL url, NotifyListener listener) {

    }

    @Override
    public void unsubscribe(URL url, NotifyListener listener) {

    }

    @Override
    public void destroy() {

    }

    @Override
    public String toString() {
        return getUrl().toString();
    }
}

