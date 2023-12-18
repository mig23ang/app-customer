package com.mibanco.customer.data.entities.client.fic;

import java.io.Serializable;

public class ApiMessage implements Serializable {

    private boolean status;
    private String text;

    public ApiMessage(boolean status, String text) {
        this.setStatus(status);
        this.setText(text);
    }


    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }
}
