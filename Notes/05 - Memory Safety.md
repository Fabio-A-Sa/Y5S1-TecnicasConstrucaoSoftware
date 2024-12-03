# Memory Safety

Rust é uma linguagem de programação que utiliza memory safety para eliminar vulnerabilidades relacionadas à utilização de memória.

É uma linguagem compilada, criada pela Mozilla em 2015. Safe concurrency em runtime. Some examples:

## Ownership

Um objecto só tem uma variável por vez. Em C uma variável é um pointer para um Objecto, em Rust só é possível ter uma variável/pointer para o mesmo Objecto.

```rust
fn main() {
    let s1 = String::from("hello");
    let s2 = s1;
    println!("s2: {}", s2);
    // Error: println!("s1: {}", s1);
}
```

## References and Borrowing

Neste caso s1, depois de ser chamado pela anterior função, deixa de ser o owner do valor. Logo o print gerará um erro de compilação:

```rust
fn main() {
    let s1 = String::from("hello");
    let len = calculate_length(s1);
    println!("The length of '{s1}' is {len}.");
}

fn calculate_length(s: String) -> usize {
    s.len()
}
```

Podemos usar *borrowing* para que o ownership não seja alterado permanentemente. Temporariamente a função chamada tem acesso ao valor:

```rust
fn main() {
    let s1 = String::from("hello");
    let len = calculate_length(&s1);
    println!("The length of '{s1}' is {len}.");
}

fn calculate_length(&s: String) -> usize {
    s.len()
}
```

Por default, as variáveis são imutáveis e devem ser sempre válidas. 

```rust
fn main() {
    let mut s = String::from("Hello");
    let r1 = &mut s;
    // ERROR: cannot borrow 's' as mutable more than once at a time
    let r2 = &mut s;
}
```

Também não podemos retornar referências, porque a variável é dropada mal o método termina:

```rust
fn main() {
    // Error!
    let reference_to_nothing = dangle();
}

fn dangle() -> &String {
    let s = String::from("hello");
    &s
} // s is dropped here!
```

## Generics

```rust
fn largest<T: PartialOrd>(list: &[T]) -> &T {
    let mut largest = &list[0];
    for item in list {
        if item > largest {
            largest = item;
        }
    }
    largest
}

fn main() {
    let number_list = vec![34, 50, 25, 100, 65];
    let result = largest(&number_list);
    println!("The largest number is {result}");

    let char_list = vec!['y', 'm', 'a', 'q'];
    let result = largest(&char_list);
    println!("The largest char is {result}");

    let point_list = vec![
        Point { x: 0.0, y: 0.0 },
        Point { x: 2.0, y: 5.0 },
        Point { x: 2.0, y: 2.0 },
    ];

    let result = largest(&point_list);
    println!("The largest point is ({}, {})", result.x, result.y);
}
```

## Macros

