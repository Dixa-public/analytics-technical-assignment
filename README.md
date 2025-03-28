<div align="center">
  <img src="https://cdn.dixa.io/images/logo/dixa-horizontal-purple.svg" width="200">

<h3 align="center">Analytics Technical Assignment</h3>

  <p align="center">As part of our application process, we would like you to complete this assignment. We don't set a time limit on the assignment, so it's up to you how much time and energy you put into it.</p>
</div>

## About the assignment

The goal of the assignment is to work on a small Analytics application by solving a series of tasks outlined below. 
The application is meant to represent a basic Analytics application, to be used by Dixa's clients for answering key
questions about their customer experience function. It focuses on what's at the heart of our industry, namely conversations,
consisting of a series of messages exchanged between a customer and customer support agent(s). Furthermore, each conversation
can be associated with tags, placed in queues, amongst many other things, most of which are out of scope for this assignment.

## Setting up the project

### Requirements
The only prerequisites for running this project should be `sbt`, `sqlite3` and `java`.

`sbt` can be installed on OS X with `brew install sbt` or on Ubuntu with `sudo apt-get install sbt`.

`sqlite3` is preinstalled on OS X and can be installed on Ubuntu with `sudo apt-get install sqlite3`.

On Windows, please consult the respective installation guides for `sbt` and `sqlite3`.

This application has been developed and tested using `java 21`, but is expected to also works with other version as well.

### Running the application

The project relies on [sbt](https://www.scala-sbt.org/) for building and can also be used for running the application,
using the following command:
```sbt
runMain com.dixa.analytics.Main
```

Expect the application to take some time (~1 minute) to process all the data, especially once you've added implementations
solving the tasks outlined below. Besides your hardware and available resources, the execution time may vary depending
on the efficiency of your implementations.

## Tasks
Below you find the set of tasks to be completed. The first 1-3 tasks will require some code to be written, whereas the
last task (4), is primarily meant for promoting a discussion around the design of the application. That said, you are
still welcome and encouraged to make changes to the codebase based on any improvements you identify.

NB. The [EventStream.scala](analytics/src/main/scala/com/dixa/analytics/generator/EventStream.scala) object, which is
**not to be altered**, emulates an event stream serving as input data for this assignment.

### 1. Persist messages
Making use of the existing [Message.scala](analytics/src/main/scala/com/dixa/analytics/model/Message.scala) class and
the corresponding database table, called `messages`, implement necessary logic to persist relevant messages; messages
with body (text) `<masked>` are to be considered sensitive and should **not** be persisted in the database. The solution
should achieve the following:
* Filter out sensitive messages
* Persist messages in the database

### 2. Add conversation tags 
Implement necessary components for associating tags with conversation, given the event structure defined in
[ConversationTag.scala](analytics/src/main/scala/com/dixa/analytics/model/ConversationTag.scala). This includes:
* Make necessary database schema changes, to be defined in [Database.scala](analytics/src/main/scala/com/dixa/analytics/dao/Database.scala).
* Supporting both associating/dissociating (adding/removing) tags with conversations (wrapper class [ActionType.scala](analytics/src/main/scala/com/dixa/analytics/model/ActionType.scala) defines the type of action to be performed).

### 3. Priority conversations
A client who's striving to run the most efficient customer support function in their industry, has invented a custom
escalation policy which they would like to monitor using Analytics. The escalation policy is defined as conversations
**not tagged as "spam"** with **two or more customer (inbound) messages, where the time between the first and last
customer message exceeds 24 hours, without there being any agent message (outbound) in between**.

* Implement an aggregate query in [AggregateQueryDao.scala](analytics/src/main/scala/com/dixa/analytics/dao/AggregateQueryDao.scala) for counting the number of escalated conversations

### 4. Design question
Given the current state of the application, think about and discuss potential points of improvement, considerations, etc.
which could be relevant for Analytics. For inspiration, below are some areas/points:
* What are potential bottlenecks in the current design? What could be improved?
* How could we optimize for read latency (aggregated queries)?
* How to ensure reads (aggregated queries) don't impact writes (ingestion)?

## Submitting your solution
When you are ready for us to look at your solution, do the
following in **your repo**:

1. Create a Pull Request targeting the `main` branch. The solution must be implemented in a separate branch.
2. Add us as external contributors to your own private repo, so we can review your pull request.

When we are done, you, of course, own the code you made.

