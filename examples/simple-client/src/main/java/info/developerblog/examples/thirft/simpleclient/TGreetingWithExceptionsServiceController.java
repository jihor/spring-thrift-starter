package info.developerblog.examples.thirft.simpleclient;

import example.TCustomException;
import example.TGreetingServiceWithExceptions;
import example.TName;
import org.apache.thrift.TException;
import ru.trylogic.spring.boot.thrift.annotation.ThriftController;

/**
 * Created by aleksandr on 01.09.15.
 */
@ThriftController("/api-with-exceptions")
public class TGreetingWithExceptionsServiceController implements TGreetingServiceWithExceptions.Iface {

    @Override
    public String customException(TName name) throws TCustomException {
        throw new TCustomException("You are not welcome here " + name.getSecondName());
    }

    @Override
    public String runtimeException1(TName name) throws TException {
        throw new RuntimeException("You are not welcome here " + name.getSecondName());
    }

    @Override
    public String runtimeException2(TName name) throws TCustomException {
        throw new RuntimeException("You are not welcome here " + name.getSecondName());
    }
}
