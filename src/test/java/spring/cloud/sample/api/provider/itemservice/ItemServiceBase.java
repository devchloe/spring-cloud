package spring.cloud.sample.api.provider.itemservice;

import io.restassured.module.mockmvc.RestAssuredMockMvc;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.context.WebApplicationContext;
import spring.cloud.sample.ItemServiceApp;
import spring.cloud.sample.domain.Item;
import spring.cloud.sample.service.ItemService;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.when;

@Ignore
@RunWith(SpringRunner.class)
@SpringBootTest(classes = ItemServiceApp.class)
public class ItemServiceBase {

    @Autowired
    private WebApplicationContext context;

    @Mock
    private ItemService itemService;

    @Before
    public void setup() {
        List<Item> items = new ArrayList<Item>();

        items.add(new Item("Banana", 550.0));
        items.add(new Item("Apple", 700.0));
        items.add(new Item("Strawberry", 4000.0));
        items.add(new Item("Peach", 5000.0));
        items.add(new Item("Water mellon", 9000.0));

        when(itemService.getAllItems()).thenReturn(items);

        // we set up RestAssured so that the generated tests can simply use RestAssured to send requests against our controller.
        RestAssuredMockMvc.webAppContextSetup(context);
    }
}
