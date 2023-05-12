package tacos.configurations;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

@Component
@Profile("prod")
@Slf4j
public class ProductionDatasourceConfig implements DatasourceConfig {

    @Value("@{server.port}")
    private String port;
    @Value("@{taco.orders.pageSize}")
    private String pageSize;

    @Override
    public void setup() {
        log.info("Setting out prod profile");
        log.info("Port" + port);
        log.info("pageSize" + pageSize);
    }
}
