package org.apereo.cas.webauthn.web.flow;

import org.apereo.cas.web.flow.authentication.BaseMultifactorAuthenticationProviderEventResolver;
import org.apereo.cas.web.flow.resolver.impl.CasWebflowEventResolutionConfigurationContext;

import org.apereo.inspektr.audit.annotation.Audit;
import org.springframework.webflow.execution.Event;
import org.springframework.webflow.execution.RequestContext;

import java.util.Set;

/**
 * This is {@link WebAuthnAuthenticationWebflowEventResolver}.
 *
 * @author Misagh Moayyed
 * @since 6.1.0
 */
public class WebAuthnAuthenticationWebflowEventResolver extends BaseMultifactorAuthenticationProviderEventResolver {

    public WebAuthnAuthenticationWebflowEventResolver(
        final CasWebflowEventResolutionConfigurationContext webflowEventResolutionConfigurationContext) {
        super(webflowEventResolutionConfigurationContext);
    }

    @Override
    public Set<Event> resolveInternal(final RequestContext context) {
        return handleAuthenticationTransactionAndGrantTicketGrantingTicket(context);
    }

    @Audit(action = "AUTHENTICATION_EVENT",
        actionResolverName = "AUTHENTICATION_EVENT_ACTION_RESOLVER",
        resourceResolverName = "AUTHENTICATION_EVENT_RESOURCE_RESOLVER")
    @Override
    public Event resolveSingle(final RequestContext context) {
        return super.resolveSingle(context);
    }
}

