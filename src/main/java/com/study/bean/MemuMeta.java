package com.study.bean;

import java.io.Serializable;

public class MemuMeta implements Serializable {

    private boolean keepAlive;

    public boolean isKeepAlive() {
        return keepAlive;
    }

    public void setKeepAlive(boolean keepAlive) {
        this.keepAlive = keepAlive;
    }

    public boolean isRequireAuth() {
        return requireAuth;
    }

    public void setRequireAuth(boolean requireAuth) {
        this.requireAuth = requireAuth;
    }

    private boolean requireAuth;


}
