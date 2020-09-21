package io.cloudstate;

import java.util.Map;

import org.apache.camel.Endpoint;

import org.apache.camel.support.DefaultComponent;

@org.apache.camel.spi.annotations.Component("cloudstate")
public class CloudStateComponent extends DefaultComponent {
    
    protected Endpoint createEndpoint(String uri, String remaining, Map<String, Object> parameters) throws Exception {
        Endpoint endpoint = new CloudStateEndpoint(uri, this);
        setProperties(endpoint, parameters);
        return endpoint;
    }
}