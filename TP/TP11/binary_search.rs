fn binary_search<T: PartialOrd + Copy>(sorted_list: &[T], target: T) -> Option<usize> {
    let mut left = 0;
    let mut right = sorted_list.len();

    while left < right {
        let mid = left + (right - left) / 2;

        if sorted_list[mid] == target {
            return Some(mid);
        } else if sorted_list[mid] < target {
            left = mid + 1;
        } else {
            right = mid;
        }
    }

    None
}

fn main() {
    let nums = vec![1, 3, 5, 7, 9, 11];
    let target = 5;

    if let Some(index) = binary_search(&nums, target) {
        println!("Found {} at index {}", target, index);
    } else {
        println!("{} not found in the list", target);
    }

    let words = vec!["apple", "banana", "cherry", "date"];
    let target_word = "cherry";

    if let Some(index) = binary_search(&words, target_word) {
        println!("Found '{}' at index {}", target_word, index);
    } else {
        println!("'{}' not found in the list", target_word);
    }
}