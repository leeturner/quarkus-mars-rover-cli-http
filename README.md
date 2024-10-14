# Quarkus Mars Rover Http CLI

This CLI is designed to communicate with the [mars rover http service](https://github.com/wiremock/quarkus-mars-rover-service-http)
and print out the names to the command line:

```
Mars Rovers:

0 - Spirit
1 - Opportunity
2 - Curiosity
3 - Perseverance
4 - Sojourner
```

These two applications combined show how http services can be mocked using [WireMock](https://wiremockk.org) and the 
Quarkus [WireMock dev service](https://docs.quarkiverse.io/quarkus-wiremock/dev/index.html).  The `MarRoverCliCommandTest` 
is annotated with `@ConnectWireMock` which allows it to spin up a WireMock server in the background and load the 
stub mapping file in `/src/test/resources/mappings`.  The mapping file defines the request the WireMock server will 
match and the response it will send back:

```json
{
  "request": {
    "method": "GET",
    "url": "/rovers"
  },
  "response": {
    "status": 200,
    "headers": {
      "Content-Type": "application/json"
    },
    "jsonBody": [
      {
        "id": 0,
        "name": "Spirit - Test"
      },
      {
        "id": 1,
        "name": "Opportunity - Test"
      },
      {
        "id": 2,
        "name": "Curiosity - Test"
      },
      {
        "id": 3,
        "name": "Perseverance - Test"
      },
      {
        "id": 4,
        "name": "Sojourner - Test"
      }
    ]
  }
}
```

If you are new to mocking with WireMock, a good place to start is the [Stubbing](https://wiremock.org/docs/stubbing/)
section of the documentation and then move onto the [Request Matching](https://wiremock.org/docs/request-matching/) and
[Response Templating](https://wiremock.org/docs/response-templating/) sections.

## WireMock Cloud
[WireMock Cloud](https://www.wiremock.io/?utm_source=github&utm_medium=referral&utm_campaign=quarkus-insights&utm_term=quarkus-mars-rover-service-http)
is a managed, hosted version of WireMock, developed by the same team who wrote the open-source project. It's built on
the same technology that powers open source WireMock and is 100% compatible with the WireMock API, with additional
features that make it quick and easy to mock any API you depend on. WireMock Cloud also introduces advanced capabilities
such as chaos engineering, mock creation from openAPI spec, contract testing, import data from CSV files and the newer
stateful mock functionality, as well as better collaboration and user management.  WireMock Cloud has a free forever
plan so take a look and see how WireMock Cloud can fit into your SDLC.

## Quarkus

This project uses Quarkus, the Supersonic Subatomic Java Framework.

If you want to learn more about Quarkus, please visit its website: https://quarkus.io/ .

### Running the application in dev mode

You can run your application in dev mode that enables live coding using:
```shell script
./gradlew quarkusDev
```

> **_NOTE:_**  Quarkus now ships with a Dev UI, which is available in dev mode only at http://localhost:8080/q/dev/.
