# LibraryCLI

A small command-line library management system, written in plain Java (no frameworks) as a first project for relearning the language.

## What it does

Models a simple library: books can be added to a catalog, members can be registered, and members can check out and return books. The system enforces basic rules (you can't check out a book that's already checked out, or one that doesn't exist) using custom validation and Java's exception handling.

## Concepts demonstrated

- **Encapsulation** — fields are `private`; mutation is deliberately restricted using Java's four access levels (`private`, package-private, `public`), so only trusted collaborator classes can change internal state directly
- **Immutability vs. mutability** — `final` fields that hold mutable collections, and the distinction between locking a *reference* vs. locking the *object* it points to
- **Collections** — `List`, `Map`, `ArrayList`, `HashMap`
- **Streams & lambdas** — filtering the catalog with `stream().filter(...)`
- **`Optional`** — safe lookups instead of returning `null`
- **Defensive copying** — `List.copyOf(...)` to prevent external code from mutating internal state through a getter
- **Exception handling** — `IllegalArgumentException` vs. `IllegalStateException` for different failure modes, and `try`/`catch` for expected, recoverable failures

