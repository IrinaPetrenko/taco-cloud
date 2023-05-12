package tacos.controllers;

import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

@Data
@Component
@Profile("!prod")
public class TestBean {
    private String greeting;

    @Value("@{taco.orders.pageSize}")
    private String pageSize;

    public TestBean(String s) {
        this.greeting = s;
    }


}
