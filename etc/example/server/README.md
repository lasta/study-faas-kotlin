# Sample API Server
A sample API server to test client

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