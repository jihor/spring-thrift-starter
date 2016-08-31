namespace * example

enum TStatus {
    MR,
    MISS,
    MRS,
    MS
}

struct TName {
    1: required string firstName;
    2: required string secondName;
    3: optional TStatus status;
}

exception TCustomException {
    1: required string message
}

service TGreetingService {
    string greet(1: TName name);
}

service TGreetingServiceWithExceptions {
    string customException(1: TName name) throws (1: TCustomException e);
    string runtimeException1(1: TName name) throws (1: TCustomException e);
    string runtimeException2(1: TName name) throws (1: TCustomException e);
}