package net.mporter.cucumber;

import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@EnableFeignClients(basePackages = "org.openapitools.api")
@SpringBootTest(classes = CucumberRunner.class)
public class SpringCucumberContext {
}
