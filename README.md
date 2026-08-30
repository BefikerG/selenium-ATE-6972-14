# Selenium E2E Testing — automationexercise.com

Individual homework for Software Testing and Validation (AAU) — a Selenium
4 + JUnit 5 test suite against [automationexercise.com](https://automationexercise.com),
covering navigation, search, login validation, explicit waits, parameterized
data-driven testing, and the Page Object pattern.

**Status:** 6/6 tests passing — `mvn test` → `BUILD SUCCESS`

## Stack

- Java 17
- Selenium 4 (`selenium-java`)
- JUnit 5 (Jupiter)
- WebDriverManager (auto-resolves the matching chromedriver)
- Maven + Surefire

## Structure

```
src/test/java/
├── pages/
│   ├── LoginPage.java     # Page Object for /login
│   └── SearchPage.java    # Page Object for /products (search)
└── tests/
    ├── BaseTest.java      # shared lifecycle — fresh browser per test
    ├── HomeTest.java      # navigation smoke test
    ├── LoginTest.java     # invalid-login negative path
    └── SearchTest.java    # search positive path + parameterized partitions
```

## Run it

```bash
mvn test
```

Requires Java 17+, Maven, and Chrome installed locally. No manual
chromedriver setup needed.

## What's covered

| Area | Where |
|---|---|
| Two distinct locator strategies (`By.id`, `By.cssSelector`) | `LoginPage`, `SearchPage` |
| Positive path — product search | `SearchTest` |
| Negative path — invalid login | `LoginTest` |
| Explicit wait (`WebDriverWait` + `ExpectedConditions`) | `SearchPage.searchFor()` |
| Parameterized test, equivalence partitioning | `SearchTest.searchPartitionsBehaveAsExpected` |
| Page Object Model | `pages/` |
| No `Thread.sleep`, no positional XPath | throughout |

Full writeup, test case table, and defects found are in `report.pdf`.

## Author

Befiker Gezahegn — ATE/6972/14
