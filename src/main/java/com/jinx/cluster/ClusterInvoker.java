
package com.jinx.cluster;


import com.jinx.common.URL;
import com.jinx.rpc.Invoker;

public interface ClusterInvoker<T> extends Invoker<T> {
    URL getRegistryUrl();

    Directory<T> getDirectory();
}
