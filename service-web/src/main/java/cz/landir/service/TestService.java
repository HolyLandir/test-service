package cz.landir.service;

import javax.ws.rs.core.Response;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import cz.landir.service.data.Greeting;

@Component
public class TestService implements ITestService {
	private static final Logger LOG = LoggerFactory.getLogger(TestService.class);

	public Response getGreeting(String name) {
		LOG.trace("Get greeting {}", name);
		return Response.ok().entity(new Greeting(StringUtils.isBlank(name) ? "Hello world" : ("Hello " + name))).build();
	}

}
