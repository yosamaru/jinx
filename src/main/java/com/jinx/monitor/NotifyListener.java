package com.jinx.monitor;


import com.jinx.common.URL;

import java.util.List;

public interface NotifyListener {

    void notify(List<URL> urls);

}