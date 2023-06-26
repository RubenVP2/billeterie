package fr.agiletp.back.billeterie.models.request;

import fr.agiletp.back.billeterie.models.json.PurchaseJson;

public class PurchaseRequest {

    private PurchaseJson params;

    public PurchaseJson getParams() {
        return params;
    }

    public void setParams(PurchaseJson params) {
        this.params = params;
    }
}