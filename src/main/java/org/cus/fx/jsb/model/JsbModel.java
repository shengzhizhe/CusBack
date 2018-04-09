package org.cus.fx.jsb.model;

import java.io.Serializable;

/**
 * @author ld
 * @name
 * @table
 * @remarks
 */
public class JsbModel implements Serializable {

    private String uuid;
    private String rq;
    private String titles;
    private String bodys;

    public String getUuid() {
        return uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid;
    }

    public String getRq() {
        return rq;
    }

    public void setRq(String rq) {
        this.rq = rq;
    }

    public String getTitles() {
        return titles;
    }

    public void setTitles(String titles) {
        this.titles = titles;
    }

    public String getBodys() {
        return bodys;
    }

    public void setBodys(String bodys) {
        this.bodys = bodys;
    }

    public JsbModel() {
        super();
    }

    public JsbModel(String uuid, String rq, String titles, String bodys) {
        this.uuid = uuid;
        this.rq = rq;
        this.titles = titles;
        this.bodys = bodys;
    }

    @Override
    public String toString() {
        return "JsbModel{" +
                "uuid='" + uuid + '\'' +
                ", rq='" + rq + '\'' +
                ", titles='" + titles + '\'' +
                ", bodys='" + bodys + '\'' +
                '}';
    }
}
