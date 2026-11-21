# Java Triangle Checker

A Java CLI application (`SEHS2242` Object-Oriented Programming Individual Assignment) that validates three positive integer side lengths on a single input line, retries with targeted error diagnostics on invalid input, checks the triangle inequality, and classifies valid triangles into **Equilateral**, **Right angled**, **Isosceles**, or **Scalene**.

## Tech Stack
- **Language:** Java (tested with JDK 21)
- **Standard Library:** `java.util.Scanner`

## Directory Structure
```text
.
├── TriangleChecker.java             # Main CLI program (90 lines)
├── docs/
│   └── Triangle_Checker_Report.pdf  # Anonymized 23-page assignment & testing report
├── .gitignore
└── README.md
```

## How to Build & Run
```bash
javac TriangleChecker.java
java TriangleChecker
```

### Example Inputs & Outputs
- `10 10 10` -> `Equilateral triangle`
- `3 4 5` / `4 3 5` -> `Right angled triangle`
- `5 5 8` -> `Isosceles triangle`
- `4 6 7` -> `Scalene triangle`
- `1 2 3` -> `Cannot form a triangle` (ends program)
- `3.5 4 5` -> `Decimals or out-of-range numbers are not allowed.` (prompts retry)
- `-3 4 5` -> `Negative numbers are not allowed. Enter positive integers.` (prompts retry)
- `0 4 5` -> `Zero is not a positive integer. Enter numbers greater than zero.` (prompts retry)
- `3 4` or `3 4 5 6` -> `Please enter exactly three integers on one line.` (prompts retry)
- `abc 4 5` -> `Only integers are allowed. Please try again.` (prompts retry)

## Authorship & Attribution
- Individual coursework project (`SEHS2242` Object-Oriented Programming).

## Development Difficulties, AI Prompting & Solutions
Summarized directly from Section 3 (*Application of Generative AI*) of `docs/Triangle_Checker_Report.pdf`:
1. **Input Count & Type Validation on a Single Line:** Reading from `System.in` directly would wait across multiple lines if fewer than three integers were entered. Using ChatGPT/Codex (Prompts 1–3), the solution uses two `Scanner` instances—`input.nextLine()` to capture one complete line, and a second `Scanner(input.nextLine())` (`values`) using `hasNextInt()`, `hasNextDouble()`, `hasNext()`, and `nextInt()`—paired with `!hasNextInt()` + `continue` to reject non-integers, decimals, out-of-range numbers, missing items, or extra items before reading.
2. **Separating Negatives/Zero from Non-Integers:** Because `hasNextInt()` accepts `-3` and `0`, separate `< 0` and `== 0` checks were added after parsing all three `int` values to give specific error messages and retry.
3. **Keeping Classification Simple & Rejecting AI Over-Complication:** AI initially suggested trigonometric functions and helper methods for squaring; these were rejected in favor of basic arithmetic (`a * a`), triangle inequality (`a + b <= c`, etc.), and an ordered `if / else if` chain (equilateral -> right-angled -> isosceles -> scalene), ending with `return` even on `"Cannot form a triangle"`.
4. **Known Limitation Documented:** Very large `int` inputs (e.g., `50000`) can overflow `a * a` in 32-bit `int` arithmetic.
