# Utility Tasks  
A hands-on Java practice set

Collection of ten small console utilities that demonstrate core language features: primitives, arrays, loops, I/O, simple algorithms and OOP.

---

## Project layout
Each task is a self-contained sub-project:  
`Task01/src`, `Task02/src`, …, `Task10/src`

If task N needs code from task N-1, copy the previous folder and continue.

---

## Task 01 – Triangle Perimeter
Read six `double` values (three vertex coordinates).

Print:
- `Perimeter: &lt;value&gt;` (3 decimal places) if the points form a triangle
- `It's not a triangle` otherwise

Error handling:
- Wrong input → `Could not parse a number. Please try again.`

Constraints:
- Use only primitive types

---

## Task 02 – Seconds → hh:mm:ss
Read one `int` – total seconds.

Convert and print time as `hh:mm:ss` (with leading zeros).

Error handling:
- Negative input → `Incorrect time`

Requirements:
- Split code into: `read()` → `convert()` → `print()`
- Use only primitive types

---

## Task 03 – Fibonacci (recursive)
Read `int n`.

Print n-th Fibonacci number using recursion.

Error handling:
- n ≤ 0 or too large → `Too large n`

Constraints:
- Use only primitive types

---

## Task 04 – Average of Negatives
Read `int size`, then `size` integers into an array.

Output:
- Average of negative values, or
- `There are no negative elements` if none found

Error handling:
- `size ≤ 0` → `Input error. Size &lt;= 0`

Requirements:
- Use a `for` loop with precondition
- Use only primitive types

---

## Task 05 – Same First & Last Digit
Read `int size`, then `size` integers.

Collect numbers whose first and last digits match into a separate array and print them.

Output if none found:
- `There are no such elements`

Error handling:
- `size ≤ 0` → `Input error. Size &lt;= 0`

Requirements:
- Use a `while` loop and a helper method
- Use only primitive types

---

## Task 06 – Selection Sort
Read `int size`, then `size` `double` values.

Sort ascending using your own selection-sort routine (no library sort).

Error handling:
- `size ≤ 0` → `Input error. Size &lt;= 0`

Constraints:
- Use only primitive types

---

## Task 07 – Min & Max from File
Read a file path from console.

File format: `count v1 v2 … vCount`

Read at most `count` valid `double` tokens; skip non-numbers.

Outputs:
- Print how many numbers were read
- Print the list itself
- Save min and max values to `result.txt`

Error handling:
- File missing → `Input error. File doesn't exist`
- `count ≤ 0` → `Input error. Size &lt;= 0`
- Too few numbers → `Input error. Insufficient number of items`

---

## Task 08 – Ascending Check
Read integers until EOF or first non-number.

Do **not** store values in an array.

Output:
- `The sequence is in ascending order` if strictly ascending
- `The sequence is not ordered from the ordinal number of the number X` (X = first violating position) otherwise

Error handling:
- No input at all → `Input error`

Constraints:
- Use only primitive types

---

## Task 09 – Sub-string Filter
Read `int n`, then `n` strings into a `List&lt;String&gt;`.

Then read one filter string `sub`.

Return all strings that contain `sub` (case-sensitive), comma-separated.

Requirements:
- Implement filtering yourself (no Stream API)

---

## Task 10 – Adults’ Names
Create simple `User` class (fields: `String name`, `int age`) in its own file.

Read amount of users, then pairs `name` `age`.

Processing:
- Negative/zero age → `Incorrect input. Age &lt;= 0` (skip user)
- Print comma-separated names of users with age ≥ 18

Requirements:
- Use Java Stream API for the final filter

---

## Build & Run
Compile and launch any task from its `TaskNN` directory in your favourite way (CLI, IDE, build tool – your choice).

All tasks are intentionally framework-free; only standard JDK is required.

Feel free to fork, modify and distribute — no proprietary wording inside.
