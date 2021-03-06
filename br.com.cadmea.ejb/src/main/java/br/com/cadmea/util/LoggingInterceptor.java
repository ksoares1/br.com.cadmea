package br.com.cadmea.util;

import java.lang.reflect.Method;

import javax.interceptor.AroundInvoke;
import javax.interceptor.Interceptor;
import javax.interceptor.InvocationContext;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

@Interceptor
@Traced
public class LoggingInterceptor
{

    private static final Logger LOG = LogManager.getLogger(LoggingInterceptor.class);

    /**
     * CDI interceptor for logging entry and exit to methods/classes which have been annotated with the @TRaced
     * annotation.
     *
     * @param ctx
     * @return
     * @throws Exception
     */
    @AroundInvoke
    public Object traceLog(InvocationContext ctx) throws Exception
    {
        Method method = ctx.getMethod();
        LOG.trace(">>> {"+method.getDeclaringClass().getName()+"}.{"+method.getName()+"} " );
        Object obj = ctx.proceed();
        LOG.trace("<<< {"+ method.getDeclaringClass().getName() +"}.{"+method.getName()+"} ");
        return obj;
    }
}