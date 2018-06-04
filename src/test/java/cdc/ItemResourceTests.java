package cdc;

import spring.cloud.sample.order.OrderApp;
import spring.cloud.sample.order.clients.Item;
import spring.cloud.sample.order.clients.ItemResource;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.cloud.contract.stubrunner.spring.AutoConfigureStubRunner;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.springframework.cloud.contract.verifier.assertion.SpringCloudContractAssertions.assertThat;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = OrderApp.class)
@AutoConfigureStubRunner(ids = {"spring.cloud.sample:item-feign-hystrix:+:stubs:8083"}, workOffline = true)
public class ItemResourceTests {

    @Autowired
    private ItemResource itemResource;

    @Test
    public void getAllItemsToContract() {
        List<Item> items = itemResource.findAll();
        Item firstItem = items.stream().findFirst().get();

        assertThat(firstItem.getName()).isEqualTo("Banana");
    }

}
