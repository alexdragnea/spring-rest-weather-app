// package net.dg.springrestweather;
//
// import org.junit.jupiter.api.extension.RegisterExtension;
// import org.springframework.boot.test.context.SpringBootTest;
//
// @SpringBootTest({"server.port:0"})
// public class InventoryClientServiceTest {
//
//    @RegisterExtension
//    static WireMockExtension INVENTORY_SERVICE = WireMockExtension.newInstance()
//            .options(WireMockConfiguration.wireMockConfig().port(8081))
//            .build();
//    @Autowired
//    private InventoryServiceClient inventoryServiceClient;
//    @Test
//    public void testInventoryServiceClientCreateProductWorksProperly() {
//        String responseBody = "{ \"productId\": \"828bc3cb-52f0-482b-8247-d3db5c87c941\",
// \"name\": \"Phone\", \"stock\": 3}";
//
// INVENTORY_SERVICE.stubFor(WireMock.post("/products").withRequestBody(WireMock.equalToJson("{
// \"name\": \"Phone\", \"initialStock\": 3}"))
//                .willReturn(WireMock.okJson(responseBody)));
//        CreateProductResponse response = inventoryServiceClient.createProduct(new
// CreateProductRequest("Phone", 3));
//        assertThat(response.getProductId()).isNotNull();
//        assertThat(response.getName()).isEqualTo("Phone");
//        assertThat(response.getStock()).isEqualTo(3);
//    }
// }
