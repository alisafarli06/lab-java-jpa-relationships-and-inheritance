![logo_ironhack_blue 7](https://user-images.githubusercontent.com/23629340/40541063-a07a0a8a-601a-11e8-91b5-2f13e4e6b441.png)

# LAB | JPA Relationships and Inheritance

### Instructions

1. Fork this repo.
2. Clone your fork to your local machine.
3. Solve the challenges.

## Deliverables

- Create a clean Spring Boot application.
- Upon completion, add your solution to git.
- Then commit to git and push to your repo on GitHub.
- Make a pull request and paste the pull request link in the submission field in the Student Portal.

## Introduction

You’ve now learned how to:
- Model relationships using JPA annotations
- Model inheritance in database tables
- Use embedded objects inside entities
- Control data loading with fetch types

In this lab, you’ll apply these concepts by modeling several systems with different relationship types.

## Objectives

By the end of this lab, you should be able to:

- Design JPA entities using One-to-One, One-to-Many, Many-to-Many mappings
- Create embedded objects inside entities
- Map inheritance using JPA
- Manage Lazy and Eager fetching
- Apply JPA best practices for clean and maintainable code

## Provided Scenario

You'll work on three different modules:

### 1. Public Relations Contact System

Model the contact system for a PR company.

**Entities to Create:**
- `Contact`
- `Name`

**Requirements:**
- Create a `Name` embeddable object with the following fields:
    - `salutation` (e.g., Mr., Mrs., Dr.)
    - `firstName` 
    - `middleName` 
    - `lastName` 
- Embed the `Name` object inside the `Contact` entity.
- `Contact` must have:
    - `id` (auto-generated)
    - `company` 
    - `title` 
    - `name` (embedded `Name`)

### 2. Nurse Association Division Management

Model a system for a Nurse Association with Divisions and Members.

**Entities to Create:**
- `Association`
- `Division`
- `Member`

**Requirements:**

- An `Association` must have:
    - `id` (auto-generated)
    - `name` (e.g., "Nurse Association of Spain")
    - A list of divisions.

- A `Division` must have:
    - `id` (auto-generated)
    - `name` 
    - `district` 
    - A president.
    - A list of members.

- A `Member` must have:
    - `id` (auto-generated)
    - `name` 
    - `status` (enum: ACTIVE, LAPSED)
    - `renewalDate` (LocalDate)

**Important:**
- Use `@Enumerated(EnumType.STRING)` for the `status`.
- Set fetch type as appropriate for collections.
- Create and save **one Association** that contains **7 Divisions**, each with at least one Member.

### 3. Event Management System

Model an event management application.

**Entities to Create:**
- `Event`
- `Conference`
- `Exhibition`
- `Guest`
- `Speaker`

**Requirements:**
- `Event` must have:
    - `id` (auto-generated)
    - `title` 
    - `date` (LocalDate)
    - `duration` (Integer)
    - `location` 
    - A list of guests.

- `Guest` must have:
    - `id` (auto-generated)
    - `name` 
    - `status` (enum: ATTENDING, NOT_ATTENDING, NO_RESPONSE)

- `Conference` must have:
    - A list of speakers.

- `Speaker` must have:
    - `id` (auto-generated)
    - `name` 
    - `presentationDuration` (Integer)

**Important:**
- Use `@Inheritance(strategy = InheritanceType.X)` where appropriate.
- Create necessary associations without explicitly being told the type. Think about how the tables should be connected.
- Use `@Enumerated(EnumType.STRING)` for enums.
- Model join tables where necessary.

## Optional Challenge: Task Management System

(Recommended if you finish early!)

Model a simple task management system with the following specifications:

**Entities to Create:**
- `Task`
- `BillableTask`
- `InternalTask`

**Requirements:**
- A `Task` must have:
    - `id` (auto-generated)
    - `title` 
    - `dueDate` (LocalDate)
    - `completed` (boolean)

- `BillableTask` must have:
    - `hourlyRate` (BigDecimal)

- `InternalTask` has no additional fields.

**Important:**
- Use `@Inheritance(strategy = InheritanceType.X)` as needed.

## Tasks

1. Define all entities with appropriate JPA annotations.
2. Use `@Inheritance(strategy = InheritanceType.X)` where needed.
3. Create the necessary repository interfaces for each entity.
4. Use CommandLineRunner or a @Configuration class to create and save at least 3 sample entries per entity (or logical group).
5. (Optional) Add simple query methods in repositories:
    - Find divisions by district
    - Find guests by status

## Bonus Questions

Answer these in a file `bonus-questions.txt` inside your repo:

1. List 3 tasks that can be performed with native SQL but are hard or impossible with JPQL.
2. Explain why you might prefer using native SQL over JPQL in real-world projects.

## FAQs

<details>
  <summary> Can I use CommandLineRunner to insert sample data?</summary>

<br>

Yes! It's recommended. You can also use REST controllers later if you prefer.

</details>

<details>
  <summary> Should I use DTOs and services already?</summary>

<br>

Not required yet! Focus on modeling the entities and relationships.

</details>

<details>
  <summary> How do I choose FetchType.LAZY or FetchType.EAGER?</summary>

<br>

- Use **LAZY** for collections unless you absolutely need the data immediately.
- Use **EAGER** carefully for simple single relationships.

</details>

:dart: Take your time, model your relationships thoughtfully, and build a solid base for future more complex applications!

:white_check_mark: **Nothing is given away** (no OneToOne, OneToMany hints).  <br>
:white_check_mark: **Association** is correctly included.  <br>
:white_check_mark: **Student must figure out** the relationships themselves.  <br>
:white_check_mark: **Ready to copy-paste into GitHub or classroom platforms**.

