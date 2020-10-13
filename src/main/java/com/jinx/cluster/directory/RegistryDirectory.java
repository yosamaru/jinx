package com.jinx.cluster.directory;


import com.jinx.common.URL;
import com.jinx.monitor.NotifyListener;
import com.jinx.rpc.Invocation;
import com.jinx.rpc.Invoker;
import com.jinx.rpc.RpcException;

import java.util.List;

public class RegistryDirectory<T> extends AbstractDirectory<T> implements NotifyListener {

    public RegistryDirectory(URL url) {
        super(url);
    }

    @Override
    public void destroy() {
        if (isDestroyed()) {
            return;
        }

        // unregister.

        // unsubscribe.

        super.destroy(); // must be executed after unsubscribing
        try {
//            destroyAllInvokers();
        } catch (Throwable t) {

        }
    }

    @Override
    protected List<Invoker<T>> doList(Invocation invocation) throws RpcException {
        return null;
    }

    @Override
    public synchronized void notify(List<URL> urls) {

    }



    @Override
    public Class<T> getInterface() {
        return null;
    }

    @Override
    public List<Invoker<T>> getAllInvokers() {
        return null;
    }

    @Override
    public URL getConsumerUrl() {
        return null;
    }


    @Override
    public boolean isAvailable() {

        return false;
    }

}
