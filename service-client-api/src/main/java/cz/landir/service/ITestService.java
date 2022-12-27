package cz.landir.service;

import java.net.HttpURLConnection;

import cz.landir.service.data.Greeting;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.ArraySchema;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.QueryParam;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

@Path("/service")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public interface ITestService {

	@GET
	@Path("/")
	@Operation(description = "Greeting generator")
	@ApiResponses(value = { @ApiResponse(responseCode = ""
			+ HttpURLConnection.HTTP_OK, description = "successful list", content = @Content(mediaType = MediaType.APPLICATION_JSON, array = @ArraySchema(schema = @Schema(implementation = Greeting.class)))),
			@ApiResponse(responseCode = ""
					+ HttpURLConnection.HTTP_INTERNAL_ERROR, description = "Server failed", content = @Content(mediaType = MediaType.APPLICATION_JSON, array = @ArraySchema(schema = @Schema(implementation = String.class)))) })
	public Response getGreeting(@QueryParam("name") String name);
}
