macro_rules! switch {
    ($value:expr, {
        $($pattern:pat => $result:expr),* $(,)?
    }) => {{
        match $value {
            $($pattern => $result),*,
            _ => {}, // Handles unmatched cases
        }
    }};
}

fn main() {
    let num = 3;

    switch!(num, {
        1 => println!("One"),
        2 => println!("Two"),
        3 => println!("Three"),
        4 => println!("Four"),
        _ => println!("Default case"),
    });

    let day = "Tuesday";

    switch!(day, {
        "Monday" => println!("Start of the week"),
        "Friday" => println!("Almost weekend"),
        "Saturday" | "Sunday" => println!("Weekend!"),
        _ => println!("Another workday"),
    });
}