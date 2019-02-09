# mac-circuit-breaker


Client --> Customer Service --> Product Service


## Success 
```
http://localhost:9001/customers/1 
```

## Fail with fallback

When Product service die, Customer service will use Hystrix fallback

```
http://localhost:9001/customers/2
```