package web.portal.permits.errors;


import org.zalando.problem.AbstractThrowableProblem;
import org.zalando.problem.Status;

import java.net.URI;

public class ResourceNotFoundProblem extends AbstractThrowableProblem {

    private static final URI TYPE
            = URI.create("https://example.org/not-found");

    public ResourceNotFoundProblem(Long taskId) {
        super(
                TYPE,
                "Resource not found",
                Status.NOT_FOUND,
                String.format("Resource '%s' not found", taskId));
    }

}