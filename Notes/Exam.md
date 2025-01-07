# Exam preparation

## Part I - MDSE (10 points)

We will present you with a simple, practical case, and we will ask some questions about the MDSE approach, related to:

- keys steps and technologies

- key metamodel elements 

- key invariants

- key M2M rules needed

- key M2T templates needed   

## Part II - General Concepts (10 points)

- Reflection, annotations and aspect-oriented-programming in Java and AspectJ (2.5 points);

- Memory safety, generics and macros in Rust (2.5 points);

- Low-code development and the Outsystems platform (2.5 points);

- GenerativeAI (2.5 points).

## Notes

- Um modelo pode implementar uma redução (parte principal das propriedades) ou um mapping (focado num indivíduo original que teve as suas propriedades generalizadas);
- Models podem ser sketches, blueprints and programs;
- Models podem ser caracterizados por representação (textual, visual) ou por formalidade (UML é semiformal);
- MDA < MDD < MDE < MBE (architecture, development, driven-eng, base-eng);
- Conceptualização: MAR (modeling, automação, realização);
- Models podem ser estáticos (arquitetura) ou dinâmicos (comportamento);
- M0 to M3 (object, model, metamodel, meta-metamodel);
- OCL para constraints impossíveis de colocar em UML (invariantes), ATL para M2M;
- Rules chamam lazy/called rules;
- Class invariants: domain, unique, associations, time, derived, busine
- Matched rules não precisam de uma call explícita;
- Matched rules só podem ter 1 source element;
- Acceleo para M2T transformations, usando template-approach, OMG standard (Object Management Group) e tendo extensão .mlt (model to text language);
- M2T é vantajoso: separação do código estático/dinâmico, reutilização, não há uma especificação clara do formato do output, não há uma linguage por detrás;
- Reflection: inspecionar e modificar o próprio código em runtime;
- Reification: tornar algo abstracto em concreto, por exemplo classes em objectos, em runtime. Exemplo: java faz store de metadata em classes, que podem ser usadas em reflection;
- Dois problemas: segurança (aceder a propriedades privadas) e performance (3 graus de grandeza superiores);
- Java anotations, para gerar documentação, informação para o compilador ou somente runtime processing (só com a flag RetentionPolicy.RUNTIME). Também existem meta-anotações;
- Aspect Oriented Programming AOP, facilita manutenção/escalabilidade/modularidade/separa preocupações, mas introduz complexidade e falta de desempenho;
- call tem this/target, enquanto que execution apenas tem this;
- join point é onde um aspecto pode ser chamado, como antes/depois de um método ser chamado ou no lançamento de uma excepção;
- 