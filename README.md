# Grouch api gateway

## Swagger-ui
```bash
docker run -p 8080:8080 -e SWAGGER_JSON=/schema/api.yaml -v `pwd`/src/main/resources:/schema swaggerapi/swagger-ui
```

## Run locally
```bash
sam local start-api
```

## Swagger

http://grouch-message-service-swagger-ui.s3-website-us-east-1.amazonaws.com/

### Deploy openapi schema to S3
```bash
aws s3 cp src/main/resources/api.yaml s3://grouch-message-service-swagger
```

### Deploy swagger-ui to S3
```bash
aws s3 sync node_modules/swagger-ui-dist s3://grouch-message-service-swagger-ui
```