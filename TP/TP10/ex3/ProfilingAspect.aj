import java.util.LinkedHashMap;

public aspect ProfilingAspect {
		
	private static class ProfileInfo {
		int numCalls = 0;
		long totalDuration = 0;
	}

	private static LinkedHashMap<Key, ProfileInfo> prof = 
			           new LinkedHashMap<Key, ProfileInfo>();
	
	static Key searchKey = new Key(null, "", null, null);
	
	Object around(): call(@Profiling * *(..)) {

		searchKey.args = thisJoinPoint.getArgs();
		searchKey.target = thisJoinPoint.getTarget();
		searchKey.declaringClass = thisJoinPoint.getSignature().getDeclaringType();
		searchKey.methodName = thisJoinPoint.getSignature().getName();
		ProfileInfo info = prof.get(searchKey);
		
		long startTime = System.nanoTime(); // Capture start time
		Object res = proceed(); // executes the method
		long endTime = System.nanoTime(); // Capture end time
		long duration = endTime - startTime; // Calculate elapsed time in milliseconds
		
		if (info != null) {
			info.numCalls++;
			info.totalDuration += duration;
			return res;
		}
		else {
			Key key = new Key(
					thisJoinPoint.getSignature().getDeclaringType(), 
					thisJoinPoint.getSignature().getName(), 
					thisJoinPoint.getTarget(), 
					thisJoinPoint.getArgs());
			info = new ProfileInfo();
			info.numCalls = 1;
			info.totalDuration = duration;
			prof.put(key, info); 
			return res;
		}
	} 
		
    before(): call(void java.lang.System.exit(int)) {
    	for (Key key: prof.keySet()) {
    		ProfileInfo info = prof.get(key);    		
    		System.out.println(key + ": " + info.numCalls + " calls, " +
    				info.totalDuration / info.numCalls + " nanoseconds per call");
    	}
    } 
}
