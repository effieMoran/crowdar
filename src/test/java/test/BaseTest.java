package test;

import org.junit.jupiter.api.extension.AfterTestExecutionCallback;
import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.api.extension.RegisterExtension;

import java.util.Optional;

public abstract class BaseTest {

    protected abstract void failedAfter();

    protected abstract void succeededAfter();

    @RegisterExtension
    AfterTestExecutionCallback afterTestExecutionCallback;

    {
        afterTestExecutionCallback = new AfterTestExecutionCallback() {
            @Override
            public void afterTestExecution(ExtensionContext context) throws Exception {
                Optional<Throwable> exception = context.getExecutionException();
                if (exception.isPresent()) { // has exception
                    failedAfter();
                } else {                     // no exception
                    succeededAfter();
                }
            }
        };
    }
}
