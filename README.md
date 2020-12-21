The Application fetches the list of Superheroes using Open Source API to explain the use of MVP Architecture Pattern.
# **Android MVP Architecture: Sample App**
A clean codebase is always a pleasure to work with. A well organized codebase is easy to maintain, is robust, performs well, is testable and is self-documenting. Picking an architecture in Android is tricky, however in this sample, you will look at a way to achieve a clean codebase using MVP architecture pattern.
## MVP - Model View Presenter
**Model View Presenter** divides our application into three layers namely the **Model**, **View** and **Presenter**. It separates the data model, from a view through a presenter.

![Mvp](https://www.vogella.com/tutorials/AndroidArchitecture/img/xmvp_overview.png.pagespeed.ic.LP57lDGT0y.webp)

Key points of MVP Architecture Pattern:
* It provides modularity, testability and a more clean and maintainable codebase.
* View more separated from Model, and the Presenter is the mediator between Model and View.
* It is Easier to create unit tests.
* Generally there is a one to one mapping between View and Presenter, with the possibility to use multiple Presenters for complex Views
* Communication between View-Presenter and Presenter-Model happens via an interface.
* One Presenter class manages one View at a time i.e., there is a one-to-one relationship between Presenter and View.
* Model and View class doesn’t have knowledge about each other’s existence.

## MODEL
In an application with a good layered architecture, the model would only act as a gateway to the domain layer or business logic.
It acts as the provider of the data we want to display in the view. 
Model’s responsibilities include using APIs, caching data, managing databases and so on.

## VIEW
The View-interface, usually implemented by an Activity (it may be a Fragment, a View depending on how the app is structured), will contain a reference to the presenter.
It will be responsible for creating the presenter object.The only thing that the view will do is to call a method from the Presenter every time there is an interface action (a button click for example). 

## PRESENTER
The Presenter is responsible to act as a middle man between the View and the Model.
It retrieves the data from the Model and returns it formatted to the View. It handles UI updates based on changes to the data model, processes users inputs and decides what happens when you interact with the View.
