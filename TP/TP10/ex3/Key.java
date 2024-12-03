// Auxiliary class for storing the HashMap key (method signature and args).
public class Key {
		Class<?> declaringClass; // target class
		String methodName; // target method
		Object target; // target object (null if static)
		Object[] args; // call arguments
		
		// Key constructor
		@SuppressWarnings("unused")
		Key(Class<?> declaringClass, String methodName, Object target, Object[] args) {
			this.declaringClass = declaringClass ;
			this.methodName= methodName;
			this.target = target;
			this.args = args;			
		}
		
		@Override
		public boolean equals(Object obj){
			if ( ! (obj instanceof Key))
				return false;
			if ( declaringClass != ((Key)obj).declaringClass)
				return false;
			if ( target != ((Key)obj).target)
				return false;
			if ( ! methodName.equals(((Key)obj).methodName))
				return false;
			if (args == null)
				return ((Key)obj).args == null;
			if ( args.length != ((Key)obj).args.length)
				return false;
			for (int i = 0; i < args.length; i++)
				if (args[i] == null) {
					if (((Key)obj).args[i] != null)
						return false;
				}
				else if ( ! args[i].equals(((Key)obj).args[i]))
					return false;
			return true;
		}

		// Needed to ensure that equal keys have the same hash code.
		@Override
		public int hashCode() {
			int h = methodName.hashCode() 
					^ declaringClass.hashCode();
			if (target != null)
				h ^= target.hashCode();
			if (args != null)
				for (int i = 0; i < args.length; i++)
					if (args[i] != null)
						h ^= args[i].hashCode();
			return h;
		}	
		
		@Override
		public String toString() {
			String argsStr = "";
			for (Object arg: args)
				if (argsStr.equals(""))
					argsStr = arg.toString();
				else
					argsStr = argsStr + ", " + arg.toString(); 
			return declaringClass.getName() + "." + methodName + "(" + argsStr + ")"; 
		}
	}
