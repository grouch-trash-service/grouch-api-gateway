# Grouch api gateway

## Swagger-ui
```bash
docker run -p 8080:8080 -e SWAGGER_JSON=/schema/swagger.yaml -v `pwd`/src/main/resources:/schema swaggerapi/swagger-ui
```

## Run locally
```bash
sam local start-api
```