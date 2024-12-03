fn swap<T>(a: &mut T, b: &mut T) {
    std::mem::swap(a, b);
}

fn main() {
    let mut x = 5;
    let mut y = 10;

    println!("Before swap: x = {}, y = {}", x, y);
    swap(&mut x, &mut y);
    println!("After swap: x = {}, y = {}", x, y);

    let mut str1 = String::from("Hello");
    let mut str2 = String::from("World");

    println!("\nBefore swap: str1 = {}, str2 = {}", str1, str2);
    swap(&mut str1, &mut str2);
    println!("After swap: str1 = {}, str2 = {}", str1, str2);
}