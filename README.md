# Grouch api gateway
Grouch api gateway is the api gateway for Grouch Trash Service.
The api for grouch trash service is defined using [open api](src/main/resources/api.yaml)
and runs on `aws API Gateway.`
For full documentation on the api please see the [swagger-ui page.](http://grouch-message-service-swagger-ui.s3-website-us-east-1.amazonaws.com/
)
## Build
The project is build using maven and uses npm and sam.

The following command can be used to build.
```bash
./mvnw package
```

## Running locally
The api can be started locally with sam by running the following command.
```bash
sam build -t template-local.yaml && sam local start-api
```
to run swagger-ui locally run the following command
```bash
docker run -p 8080:8080 -e SWAGGER_JSON=/schema/api.yaml -v `pwd`/src/main/resources:/schema swaggerapi/swagger-ui
```
## Tests
### Cucumber Tests
This project uses cucumber to automate testing and describe behavior.
To run the tests locally first [start the api.](#Running-locally)
Then run the following command.

```bash
./mvnw -P cucumber verify
```
To run the same tests against the production api.
```bash
./mvnw -P cucumber verify -Dspring.profiles.active=prod -DgrouchTrashMessageService.security.authorizer.key=${API_KEY}
```

## Packages
packages that contains generated client code will be deployed to github as part of the build pipeline.
To deploy these packages locally first set the following env variables.
* GITHUB_ACTOR
* GITHUB_TOKEN
* NODE_AUTH_TOKEN

Then run the following command.

```bash
./mvnw -s settings.xml deploy
```

## Deploy
The code will automatically be built and deployed with a [github action.](.github/workflows/build.yml)

to deploy the application first use the `aws configure` comand to setup credentials for aws, then run
```bash
sam deploy
```

To deploy swagger-ui to the aws s3 run the following.

### Deploy openapi schema to S3
```bash
aws s3 cp src/main/resources/api.yaml s3://grouch-message-service-swagger
```

### Deploy swagger-ui to S3
```bash
aws s3 sync node_modules/swagger-ui-dist s3://grouch-message-service-swagger-ui
```
