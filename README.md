# Open Telemetry Reactive Sample

### Run

To run this project you need to have before

- OpenTelemetry Collector
- OpenTelemetry Agent
- Jaeger

First of all, run the command below

```sheel
mvn clean install -DskipTests
```
Run the project
```text
src/main/java/com/huntercodexs/example/DemoApplication.java
```
Make same tests with the application running to check if everything is ok, and then stop the application and go forward 
executing the java agent passing this application as a parameter to this agent.

Example
```text
http://localhost:38080/api/v1/hello
```

So open a new terminal to run the java agent command below

```text
/home/jereelton/.jdks/jdk-17.0.1/bin/java -javaagent:otel/opentelemetry-javaagent-1.32.1.jar -Dotel.service.name=opentelemetry-reactive-sample-v2.0.0 -Dotel.traces.exporter=jaeger -Dotel.metrics.exporter=none -Dotel.exporter.jaeger.endpoint=http://localhost:14250 -jar target/*.jar
```

And now check the traces generated in the Jaeger UI tools or any other tools that you like or being using.

- Java Agent Releases

https://github.com/open-telemetry/opentelemetry-java-instrumentation/releases
