# Model-to-Model Transformations

- `Eclipse Modeling Framework` (EMF) proporciona a infraestrutura;

- `Atlas Transformation Language` (ATL) é usada para designar as regras de transformação entre modelos e para executar essas regras. 

- `Object Constraint Language` (OCL) é uma linguagem declarativa que é usada para pesquisa nos modelos com transformações em ATL. Usada quando as restrições dos modelos não são suficientes para digerir a complexidade da transformação;

- `EMF core metamodel` (Ecore) é a linguagem para definir os modelos source and target metamodels in transformations;  

- `XML Metadata Interchange` (XMI) é o formato usado para descrever o source e target model usados nas transformações ATL;

## ATL

Um model ATL define um conjunto de regras para transformar modelos noutros modelos. Tem a seguinte estrutura:

- O `header` define o nome do módulo, os inputs e os outputs;
- O `import`, que é opcional, permite exportar bibliotecas ATL;
- Existem `helpers` que são métodos auxiliares, manipulam atributos e operações entre estes;
- Existem `rules` que definem como gerar os modelos a partir dos existentes;

### Helpers



### Rules

