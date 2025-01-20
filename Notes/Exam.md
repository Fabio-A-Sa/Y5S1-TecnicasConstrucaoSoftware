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
- Class invariants: domain, unique, associations, time, derived, business;
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
- Em rust, uma variável é o owner por vez, quando vamos usar deixa de o ser, e depois de colocar parâmetros deixamos de poder usar a variável;
- A menos que usemos borrowing, não se pode usar borrowing mais que uma vez e não se pode retornar referências (porque o owner desaparece);
- Codex, para Python, e HumanEval, para avaliar o comportamento dos LLMs;
- AutoUAT permite transformar user stories em Acceptance tests (Gherkin);
- Outsystems permite importar APIs, conectores, e custom code em C#/Java. Cria Web apps reativas;
- Tem os componentes: lifetime (pipelines, performance, control user permissions), service center (logs, issues), forge (marketplace), cloud (hosting);
- Outsystems tem 3 camadas: end-user modules (UI and process), core modules (business services), foundation modules ( Non-functional requirements);
- LLMs podem ser usadas para detectar architectural patterns (mais abstractos que design patterns, porque podem ser implementados em formas distintas, sem depender de classes, e mais complexas de identificar);
- Detectam também microservices patterns, usando IaC (infraestructure as code) + LLMs, com mais impacto, mais preciso e potencialmente muito mais barato;