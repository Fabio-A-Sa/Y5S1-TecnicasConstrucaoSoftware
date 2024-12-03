public aspect CachingAspect {
    private static java.util.HashMap<Key, Object> cache = new java.util.HashMap<Key, Object>();
    private static Key cacheSearchKey = new Key(null, "", null, null);

    Object around(): call(@Cache * *(..)) {
    	
        cacheSearchKey.args = thisJoinPoint.getArgs();
        cacheSearchKey.target = thisJoinPoint.getTarget();
        cacheSearchKey.declaringClass = thisJoinPoint.getSignature().getDeclaringType();
        cacheSearchKey.methodName = thisJoinPoint.getSignature().getName();

        if (cache.containsKey(cacheSearchKey)) {
            return cache.get(cacheSearchKey);
        }

        Object result = proceed();
        Key newKey = new Key(
            thisJoinPoint.getSignature().getDeclaringType(),
            thisJoinPoint.getSignature().getName(),
            thisJoinPoint.getTarget(),
            thisJoinPoint.getArgs()
        );
        
        cache.put(newKey, result);
        return result;
    }
}
