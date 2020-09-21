package io.cloudstate;

import org.apache.camel.Exchange;
import org.apache.camel.support.DefaultProducer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class CloudstateProducer extends DefaultProducer {
    private static final Logger LOG = LoggerFactory.getLogger(CloudstateProducer.class);
    private CloudstateEndpoint endpoint;

    public CloudstateProducer(CloudstateEndpoint endpoint) {
        super(endpoint);
        this.endpoint = endpoint;
    }

    public void process(Exchange exchange) throws Exception {
        System.out.println(exchange.getIn().getBody());    
    }

}
