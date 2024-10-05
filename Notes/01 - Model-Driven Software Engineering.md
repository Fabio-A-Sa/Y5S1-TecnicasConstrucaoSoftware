# Model-Driven Software Engineering (MDSE)

A **Abstração** é a capacidade de encontrar situações comuns em diferentes observações para gerar uma representação mental da realidade. Consiste em processos de:

- Generalização;
- Classificação;
- Aggregação;

Um **Model** é a representação simplificada ou parcial da realidade. Implementam dois tipos de funções quando aplicam a abstração:

- `Reduction`: o modelo reflete apenas uma relevante secção das propriedades originais, apenas para focar nas partes de interesse;
- `Mapping`: o modelo é baseado num indivíduo original que teve as suas propriedades generalizadas;

**MDSE** é a capacidade de modeling que serve para melhoria da eficiência na criação de software.

### Model Classification

#### Type

- `Sketches`: para motivos de comunicação, ou vistas parciais do sistema especificado;
- `Blueprints`: proporciam uma forma completa e detalhada da especificação do sistema;
- `Programs`: quando são usados para desenvolver o sistema em si;

#### Representation

- `Textual`: em plaintext;
- `Visual`: usando diagramas para representar relações;

#### Formality

- `Informal`: desenhos/esquemas;
- `Semiformal`: usando UML para estruturação;
- `Formal`: usando um software, como o Alloy;

## Hierarquia

- `MDA`: Model-Driven Architecture;
- `MDD`: Model-Driven Development;
- `MDE`: Model-Driven Engineering;
- `MBE`: Model-Based Engineering;

**MDSE** procura soluções com base em dois eixos: conceptualização e implementação:

### Conceptualização

- **Application level**, onde os modelos da aplicação são definidos, as transformações efetuadas e os componentes essenciais são gerados;
- **Application domain level**, onde existe a definição de modeling language, transformações e plataformas de implementação;
- **Meta level**, onde conceptualização de modelos e transformações são definidos;

### Implementação

- **Modeling level**, onde os modelos são definidos;
- **Realization level**, onde as soluções são implementadas, por exemplo o próprio código;
- **Automation level**, onde os mappings da etapa de modelação são colocados;

Existem vários espaços na modelação:

- Problem space;
- Solution space;
- Technical space;

Existem várias linguagens:

- Domain Specific Languages (`DSL`), como HTML ou SQL;
- Domain Specific Modeling Language (`DSML`), a que vamos criar;
- General Porpose Modeling Language (`GPL`), como UML;

Os Modelos também podem ser `estáticos` (partes estáticas do sistema, como class diagrams) ou `dinâmicos` (como ações, algoritmos e colaboração entre componentes, diagramas de sequências).

### MetaModel

São definições de linguagens de modelação (por exemplo gramáticas para programming languages). Um modelo está conforme com o seu metamodel se todos os seus elementos podem ser expressados / são instâncias do metamodelo correspondente.

No fundo, podemos organizar os modelos em:

- M0: os objectos em si;
- M1: como UML models;
- M2: UML metamodel;
- M3: MOF;