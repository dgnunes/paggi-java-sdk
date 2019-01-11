package br.com.paggi.model.bean;

public class PaggiPlan {
    private String name;
    private String price;
    private String interval;
    private String trial_period;
    private String external_identifier;
    private String description;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getInterval() {
        return interval;
    }

    public void setInterval(String interval) {
        this.interval = interval;
    }

    public String getTrial_period() {
        return trial_period;
    }

    public void setTrial_period(String trial_period) {
        this.trial_period = trial_period;
    }

    public String getExternal_identifier() {
        return external_identifier;
    }

    public void setExternal_identifier(String external_identifier) {
        this.external_identifier = external_identifier;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    //Fluent
    public PaggiPlan withName(String name) {
        this.name = name;
        return this;
    }

    public PaggiPlan withPrice(String price) {
        this.price = price;
        return this;
    }

    public PaggiPlan withInterval(String interval) {
        this.interval = interval;
        return this;
    }

    public PaggiPlan withTrial_period(String trial_period) {
        this.trial_period = trial_period;
        return this;
    }

    public PaggiPlan withExternal_identifier(String external_identifier) {
        this.external_identifier = external_identifier;
        return this;
    }

    public PaggiPlan withDescription(String description) {
        this.description = description;
        return this;
    }
}
