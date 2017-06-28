package edu.gsu.httpscs.nipuna2017summer.audio;

import java.io.Serializable;

/**
 * Created by nipunasenanayake on 6/25/17.
 */

public class BaseBean implements Serializable{
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
