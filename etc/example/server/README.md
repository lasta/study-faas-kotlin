# Sample API Server
A sample API server to test client

## Build and run
```shell script
cd etc/example/test # this README.md directory
./gradlew build
./gradlew run
```

then wake an API server up at 8080 port.

## API Spec
### `/`
#### Request parameters
none

#### Response
##### Headers
```
Content-Length: 12
Content-Type: text/plain
charset=UTF-8
```

##### Body
```
"HELLO WORLD!"
```

### `/json/jackson`
#### Request parameters
none

#### Response
##### Headers
```
Content-Length: 23
Content-Type: application/json; charset=UTF-8
```

##### Body
```json
{
  "hello" : "world"
}
```