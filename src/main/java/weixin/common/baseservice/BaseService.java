package weixin.common.baseservice;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;

/**
 * @author chenx
 * @create 2018-09-17 21:17
 */
public class BaseService<T> {

    protected static final Logger log = LoggerFactory.getLogger(BaseService.class);

    protected static Logger logger = null;

    public BaseService() {
        Type type = this.getClass().getGenericSuperclass();
        Type[] parameterizedTypes = ((ParameterizedType) type).getActualTypeArguments();
        Class<?> clazz = parameterizedTypes[0].getClass();
        BaseService.logger = LoggerFactory.getLogger(clazz);
    }

}

