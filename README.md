# CS-320-Final-Project
# Author: Aiden Villanueva
# Oct. 22, 2025

'''The final project from SNHU CS-320 Software Testing Automation and QA'''

This project is intended to display concrete understanding of the quality assurance process and several different software testing methods including white-box testing, unit testing and funtional testing, specifically as they pertain to the Java ecosystem and JUnit testing framework. 

I make sure software is functional and secure through a comprehensive, requirement-driven test-writing strategy. This involves creating a suite of tests that cover successful operations, all foreseeable failure scenarios, edge cases, and invalid inputs during the process of wiring the initial code.

This strategy uses several key techniques:
  - Unit testing verifies the correctness of individual components in isolation, like variables at runtime or constructors and destructors.
  - White-Box Testing uses knowledge of the code's internal logic to validate all pathways, conditional branches, and error-handling routines.
  - Functional testing verifies that individual classes and methods operate as intended, both under valid and invalid input.

A high level of test coverage provides strong confidence that the software is stable, reliable, and secure against invalid data.

User needs are interpreted from the software requirements, which serve as an objective checklist. The idea is to create a very high level of alignment between the software and the requirements by making sure every piece of application logic is directly tied to and validated against a documented requirement. For every feature, there should be a direct line from a specific requirement to the test case that validates it. For example, if a requirement states the system must add a contact with a unique ID, validate this with tests that confirm successful addition a well as the proper rejection of a duplicate ID.

My design approach was based on modularity and robustness, where the software is structured into individual components or modules (like the Appointment class and AppointmentService) that can be developed and tested in isolation before being integrated. This modular design makes use of software engineering concepts like DRY and encapsulation to create a codebase which is resistant to misfunction and easier to refactor, with bugs and errors being caught much earlier in the development process. 
