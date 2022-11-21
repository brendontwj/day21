package vttp2022.day21.day21.models;

import org.springframework.stereotype.Component;

@Component
public class Query {
    private String name;
    private int limit;
    
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public int getLimit() {
        return limit;
    }
    public void setLimit(int limit) {
        this.limit = limit;
    }
}
