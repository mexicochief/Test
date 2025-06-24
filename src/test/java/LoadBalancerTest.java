//import org.junit.jupiter.api.Test;
//import org.mockito.Mockito;
//import org.stardust.LoadBalancer;
//import org.stardust.error.LoadBalancerException;
//import org.stardust.server.DefaultServer;
//import org.stardust.server.Server;
//import org.stardust.strategy.LoadBalancerStrategy;
//
//import java.util.ArrayList;
//import java.util.List;
//
//import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;
//import static org.mockito.Mockito.when;
//
//public class LoadBalancerTest {
//
//
//    private final LoadBalancerStrategy strategy = Mockito.mock(LoadBalancerStrategy.class);
//
//    private final LoadBalancer loadBalancer = new LoadBalancer(new ArrayList<>(), strategy);
//
//
//    @Test
//    void testAddServer() {
//
//    }
//
//
//    @Test
//    void testAddServerNullInstanceException() {
//        assertThatThrownBy(() -> loadBalancer.addServer(null))
//                .isInstanceOf(LoadBalancerException.class)
//                .hasMessage("Server instance should not to be null");
//    }
//
//    @Test
//    void testAddServerCapacityReachedException() {
//        for (int i = 0; i < 10; i++) {
//            loadBalancer.addServer(new DefaultServer(String.valueOf(i)));
//        }
//
//        assertThatThrownBy(
//                () -> {
//                    loadBalancer.addServer(new DefaultServer("error"));
//                }
//        )
//                .isInstanceOf(LoadBalancerException.class)
//                .hasMessage("Max server capacity reached");
//    }
//
//    @Test
//    void testRemoveServer() {
//
//    }
//
//    @Test
//    void testRouteRequest() {
//        Server server = Mockito.mock(Server.class);
//        loadBalancer.addServer(server);
//
//        when(strategy.getNextServer(List.of(server))).thenReturn(server);
//
//        loadBalancer.routeRequest("request");
//    }
//
//    @Test
//    void testRoutRequestNoServerAvailable() {
//
//        assertThatThrownBy(
//                () -> loadBalancer.routeRequest("String")
//        )
//                .isInstanceOf(LoadBalancerException.class);
//    }
//
//}
