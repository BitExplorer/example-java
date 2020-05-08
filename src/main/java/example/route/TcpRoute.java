package example.route;

import org.apache.camel.Exchange;
import org.apache.camel.Processor;
import org.apache.camel.builder.RouteBuilder;
import org.springframework.stereotype.Component;

@Component
public class TcpRoute extends RouteBuilder {
    @Override
    public void configure() throws Exception {
//        from("netty4:tcp://localhost:7000?textline=true&encoding=utf8")
//                .process(new Processor() {
//                    @Override
//                    public void process(final Exchange exchange) throws Exception {
//                        log.info("[Processor] - Incoming Message -> {}", exchange.getIn().getBody(String.class));
//                    }
//                }).end();

        from("netty4:tcp://0.0.0.0:8081")
                .log("got here")
                .process(exchange -> {
            String body = exchange.getIn().getBody(String.class);
                    System.out.println("body = " + body);
            //exchange.getOut().setBody("Bye " + body);
            // some condition which determines if we should close
//                if (close) {
//                    exchange.getOut().setHeader(NettyConstants.NETTY_CLOSE_CHANNEL_WHEN_COMPLETE, true);
//                }
        });

    }
}
