## Shortener Url Code Challenge

### Solution
Let us assume the short URL looks like this: http://shortener.com/{hashValue}. To support the URL shortening use case, we must find a hash function encode that maps a long URL to the hashValue.

The hash value is made up of characters of [0-9, a-z, A-Z], containing 10 + 26 + 26 = 62 possible characters. If we are going to support at most 8 characters as a hash value, the service able to support up to 3.5 trillion URLs(n = 7, 62 ^ n = ~3.5 trillion)

#### Domain
It is responsible to encode and decode url base on base62.

#### Infrastructure
It is responsible to interact with client.

#### Usecase
It knows the flow/steps to encode and decode urls

### Requirement
- Kotlin
- Gradle

### How to Run
Run it through docker
```
sudo docker build -t shortenerutl-service .
sudo docker run -p 8080:8080 shortenerurl-service

GET api/v1/shourtUrl
POST api/v1/data/shourten

API Doc: /localhost:8080/documentations
```
