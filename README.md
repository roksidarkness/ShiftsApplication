# The Problem

Our providers in Dallas, TX need the ability to see nearby shifts available on the ShiftKey platform to plan their
 work week. Your goal is to build an user interface that allows them to accomplish this.
 
## Details
Use the `MainActivity` to get started. Using an address of "Dallas, TX", display one week of nearby shifts that come
 back from the [Available Shifts API](https://bitbucket.org/shiftkeyllc/ios-coding-challenge/src/master/API-DOC.md) in a list. The shift cell should include information relevant to the provider
  and when tapped, it should present a different screen to display more information about the shift.

The submitted code should reflect what you feel represents your best work. You should be prepared to talk about your solution in an interview setting.

Please note that this code you submit is for the technical review portion of the interview process and will not be used in any production application. 

To start working on the challenge, clone this repo onto your development machine. Commit your changes there and when finished, publish your repo on your public bitbucket or github account.

### Requirements ###

* Written in Kotlin
* Fetches available shifts using the [Available Shifts API](https://bitbucket.org/shiftkeyllc/ios-coding-challenge/src/master/API-DOC.md) with an address of "Dallas, TX"
* On app launch, the current week of shifts should be fetched and displayed, starting with today's date
* Tapping on a shift cell should present a shift details screen with shift details
* Optional: Scrolling to the end of the current week on the list loads shifts for the next week

### What are we looking for? ###

* Solid architecture
* Use of design patterns
* Follow Material design principles
* Experience with android architecture components
* Familiarity with libraries/frameworks
* Testability