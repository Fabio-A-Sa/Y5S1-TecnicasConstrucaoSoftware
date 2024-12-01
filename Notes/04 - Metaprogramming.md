# Metaprogramming Techniques

## Reflection

Quando o próprio código consegue observar, modificar, intersectar e emitir o seu próprio código em run-time. Pode criar novas instâncias, consultar os seus construtores, métodos, fields.

```java
Class<?> c = Class.forName("Object");
Method ms[] = c.getDeclaredMethods();
for (Method m : ms)
    System.out.println(m.toString());
```

- Criar novo objecto em run-time

```java
// without reflection
new Board().hello();

// with reflection
Class<?> bClass = Class.forName("Board");
Board x = (Board) bClass.newInstance();
bClass.getMethod("hello").invoke(x);
```

- Trocar a acessibilidade de fields privados:

```java
if (!Modifier.isPublic(field.getModifiers()))
    field.setAccessible(true);

Object obj = field.get(obj);
```

No entanto, a reflexão não é eficiente (1000 vezes mais lenta que programação direta ou por referência).

## Java Annotations

São dados sobre um elemento do programa (metadados) que não fazem parte do próprio programa. Permitem:

- Declaração de tipos de anotações com o @interface;
- Anotação de elementos de programas;
- API de reflexão para processar anotações em runtime;

As anotações são usadas para:

- Detectar erros ou suprimir warnings;
- Geração de código, arquivos XML, etc;
- Inspecionar anotações via reflexão;

```java
public @interface EnhancementRequest {
    int id();
    String synopsis() default "";
    String author() default "[unassigned]";
}

@EnhancementRequest(id = 286, author = "John")
public static void timeTravel(Date destination) {...}
```

### Meta-anotações

- @Target: Define os elementos onde a anotação pode ser usada;
- @Retention: Define o tempo de vida da anotação (SOURCE, CLASS ou RUNTIME);
- @Documented: Indica que a anotação deve ser documentada no Javadoc;
- @Inherited: Permite que subclasses herdem a anotação;
- @Repeatable: Permite múltiplas aplicações de uma mesma anotação;

```java
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
public @interface Authorship {
    String author();
    String when();
}

@Authorship(author = "God", when = "13.8 billion years ago")
public class Universe { }

Class aClass = Universe.class;
Annotation[] annotations = aClass.getAnnotations();
for (Annotation annotation : annotations) {
    if (annotation instanceof Authorship) {
        Authorship auth = (Authorship) annotation;
        System.out.println("Author: " + auth.author());
        System.out.println("When: " + auth.when());
    }
}
```

## Aspect-Oriented Programming (AOP)

Paradigma de programação que separa preocupações transversais do código principal, como logging, segurança, ou transações. Permite aplicar funcionalidades transversais a diferentes partes do código sem duplicação. Conceitos principais:

- `Aspect`: Unidade de modularidade que encapsula preocupações transversais;
- `Join Point`: Ponto específico no fluxo de execução do programa (e.g., chamadas de método, inicializações);
- `Pointcut`: Expressão que captura múltiplos join points;
- `Advice`: Código executado em torno de um join point (antes, depois, ou em vez);
- `Weaving`: Processo de integração dos aspectos no programa (em tempo de compilação ou runtime);

### Tipos de Advice

- `Before`: executa antes do join point:

```java
before(): publicCall() {
    System.out.println("Executando antes do método.");
}
```

- `After`: executa depois do join point:

```java
after(): publicCall() {
    System.out.println("Executando após o método.");
}
```

- `Around`: substitui o join point, podendo invocá-lo condicionalmente:

```java
int around(): publicCall() {
    if (condition) return proceed();
    return 0;
}
```

### Modelo de Join Points

```java
// Chamadas e execuções de métodos e construtores
call(public void SomeClass.someMethod());
execution(public void SomeClass.someMethod());

// Acessos a campos
get(public int SomeClass.someField);
set(public int SomeClass.someField);

// Fluxos de execução
cflow(call(* OtherClass.otherMethod(..)));

// Exemplo mais complexo: logging de mudanças em formas geométricas
aspect LoggingAspect {
    pointcut shapeChange(): call(public void Shape.set*(..));

    after(): shapeChange() {
        System.out.println("Forma alterada.");
    }
}
```

#### Vantagens

- Melhora a modularidade, separando preocupações transversais;
- Facilita a manutenção e escalabilidade;

#### Desvantagens

- Pode introduzir complexidade adicional;
- Algumas implementações possuem impacto em desempenho;

