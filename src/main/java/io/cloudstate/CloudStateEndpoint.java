package io.cloudstate;

import org.apache.camel.Consumer;
import org.apache.camel.Processor;
import org.apache.camel.Producer;
import org.apache.camel.support.DefaultEndpoint;
import org.apache.camel.spi.Metadata;
import org.apache.camel.spi.UriEndpoint;
import org.apache.camel.spi.UriParam;
import org.apache.camel.spi.UriPath;

import java.util.concurrent.ExecutorService;

/**
 * Cloudstate Camel component support.
 *
 */
@UriEndpoint(firstVersion = "0.1.1", scheme = "cloudstate", title = "Cloudstate", syntax="cloudstate:entityType",
             consumerClass = CloudStateConsumer.class, label = "custom")
public class CloudStateEndpoint extends DefaultEndpoint {

    @UriPath @Metadata(required = true)
    private String entityType;

    @UriParam(defaultValue = "10")
    private int option = 10;

    public CloudStateEndpoint() {}

    public CloudStateEndpoint(String uri, CloudStateComponent component) {
        super(uri, component);
    }

    public Producer createProducer() throws Exception {
        return new CloudStateProducer(this);
    }

    public Consumer createConsumer(Processor processor) throws Exception {
        Consumer consumer = new CloudStateConsumer(this, processor);
        configureConsumer(consumer);
        return consumer;
    }

    /**
     * Some description of this option, and what it does
     */
    public void setEntityType(String entityType) {
        this.entityType = entityType;
    }

    public String getEntityType() {
        return entityType;
    }

    /**
     * Some description of this option, and what it does
     */
    public void setOption(int option) {
        this.option = option;
    }

    public int getOption() {
        return option;
    }

    public ExecutorService createExecutor() {
        // TODO: Delete me when you implementy your custom component
        return getCamelContext().getExecutorServiceManager().newSingleThreadExecutor(this, "CloudStateConsumer");
    }
}
